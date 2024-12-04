package jagex2.io;

import deob.ObfuscatedName;

import java.io.EOFException;
import java.io.IOException;

@ObfuscatedName("ap")
public class FileStream {

	@ObfuscatedName("ap.r")
	public static byte[] temp = new byte[520];

	@ObfuscatedName("ap.d")
	public BufferedFile idx = null;

	@ObfuscatedName("ap.l")
	public BufferedFile dat = null;

	@ObfuscatedName("ap.m")
	public int archive;

	@ObfuscatedName("ap.c")
	public int maxFileSize = 65000;

	public FileStream(int archive, BufferedFile dat, BufferedFile idx, int maxFileSize) {
		this.archive = archive;
		this.dat = dat;
		this.idx = idx;
		this.maxFileSize = maxFileSize;
	}

	@ObfuscatedName("ap.r(II)[B")
	public byte[] read(int file) {
		BufferedFile dat = this.dat;
		synchronized (dat) {
			try {
				if (this.idx.length() < (file * 6L + 6)) {
					return null;
				}

				this.idx.seek(file * 6L);

				this.idx.read(temp, 0, 6);
				int len = ((temp[0] & 0xFF) << 16) + ((temp[1] & 0xFF) << 8) + (temp[2] & 0xFF);
				int chunk = ((temp[3] & 0xFF) << 16) + ((temp[4] & 0xFF) << 8) + (temp[5] & 0xFF);

				if (len < 0 || len > this.maxFileSize) {
					return null;
				}

                if (chunk <= 0 || (long) chunk > this.dat.length() / 520L) {
					return null;
                }

				byte[] data = new byte[len];
				int pos = 0;
				for (int part = 0; pos < len; part++) {
					if (chunk == 0) {
						return null;
					}

					this.dat.seek(chunk * 520L);
					int available = len - pos;
					if (available > 512) {
						available = 512;
					}

					this.dat.read(temp, 0, available + 8);
					int metaFile = ((temp[0] & 0xFF) << 8) + (temp[1] & 0xFF);
					int metaPart = ((temp[2] & 0xFF) << 8) + (temp[3] & 0xFF);
					int metaNextChunk = ((temp[4] & 0xFF) << 16) + ((temp[5] & 0xFF) << 8) + (temp[6] & 0xFF);
					int metaArchive = temp[7] & 0xFF;

					if (file != metaFile || part != metaPart || this.archive != metaArchive) {
						return null;
					}

					if (metaNextChunk < 0 || (long) metaNextChunk > this.dat.length() / 520L) {
						return null;
					}

					for (int i = 0; i < available; i++) {
						data[pos++] = temp[i + 8];
					}

					chunk = metaNextChunk;
				}

				return data;
            } catch (IOException ignore) {
				return null;
			}
		}
	}

	@ObfuscatedName("ap.d(I[BII)Z")
	public boolean write(int file, byte[] data, int len) {
		BufferedFile dat = this.dat;
		synchronized (dat) {
			if (len < 0 || len > this.maxFileSize) {
				throw new IllegalArgumentException();
			}

			boolean success = this.write(file, data, len, true);
			if (!success) {
				success = this.write(file, data, len, false);
			}
			return success;
		}
	}

	@ObfuscatedName("ap.l(I[BIZI)Z")
	public boolean write(int file, byte[] data, int len, boolean overwrite) {
		BufferedFile dat = this.dat;
		synchronized (dat) {
			try {
				int metaChunk;
				if (overwrite) {
					if (this.idx.length() < (file * 6L + 6)) {
						return false;
					}

					this.idx.seek(file * 6L);
					this.idx.read(temp, 0, 6);

					metaChunk = ((temp[3] & 0xFF) << 16) + ((temp[4] & 0xFF) << 8) + (temp[5] & 0xFF);
					if (metaChunk <= 0 || (long) metaChunk > this.dat.length() / 520L) {
						return false;
					}
				} else {
					metaChunk = (int) ((this.dat.length() + 519L) / 520L);
					if (metaChunk == 0) {
						metaChunk = 1;
					}
				}

				temp[0] = (byte) (len >> 16);
				temp[1] = (byte) (len >> 8);
				temp[2] = (byte) len;
				temp[3] = (byte) (metaChunk >> 16);
				temp[4] = (byte) (metaChunk >> 8);
				temp[5] = (byte) metaChunk;

				this.idx.seek(file * 6L);
				this.idx.write(temp, 0, 6);

				int written = 0;
				for (int part = 0; written < len; part++) {
					int nextChunk = 0;

					if (overwrite) {
						this.dat.seek(metaChunk * 520L);

						try {
							this.dat.read(temp, 0, 8);
						} catch (EOFException ignore) {
							return false;
						}

						int metaFile = ((temp[0] & 0xFF) << 8) + (temp[1] & 0xFF);
						int metaPart = ((temp[2] & 0xFF) << 8) + (temp[3] & 0xFF);
						nextChunk = ((temp[4] & 0xFF) << 16) + ((temp[5] & 0xFF) << 8) + (temp[6] & 0xFF);
						int metaArchive = temp[7] & 0xFF;

						if (file != metaFile || part != metaPart || this.archive != metaArchive) {
							return false;
						}

						if (nextChunk < 0 || (long) nextChunk > this.dat.length() / 520L) {
							return false;
						}
					}

					if (nextChunk == 0) {
						overwrite = false;
						nextChunk = (int) ((this.dat.length() + 519L) / 520L);

						if (nextChunk == 0) {
							nextChunk++;
						}

						if (metaChunk == nextChunk) {
							nextChunk++;
						}
					}

					if (len - written <= 512) {
						nextChunk = 0;
					}

					temp[0] = (byte) (file >> 8);
					temp[1] = (byte) file;
					temp[2] = (byte) (part >> 8);
					temp[3] = (byte) part;
					temp[4] = (byte) (nextChunk >> 16);
					temp[5] = (byte) (nextChunk >> 8);
					temp[6] = (byte) nextChunk;
					temp[7] = (byte) this.archive;

					this.dat.seek(metaChunk * 520L);
					this.dat.write(temp, 0, 8);

					int available = len - written;
					if (available > 512) {
						available = 512;
					}

					this.dat.write(data, written, available);
					written += available;
					metaChunk = nextChunk;
					part++;
				}

				return true;
			} catch (IOException ignore) {
				return false;
			}
		}
	}
}
