package jagex3.io;

import deob.ObfuscatedName;

import java.io.EOFException;
import java.io.IOException;

// jag::oldscape::jagex3::Js5LocalCache::DataFile
@ObfuscatedName("ap")
public class DataFile {

	@ObfuscatedName("ap.r")
	public static byte[] temp = new byte[520];

	@ObfuscatedName("ap.d")
	public BufferedRandomAccessFile idx = null;

	@ObfuscatedName("ap.l")
	public BufferedRandomAccessFile dat = null;

	@ObfuscatedName("ap.m")
	public int archive;

	@ObfuscatedName("ap.c")
	public int maxFileSize = 65000;

	public DataFile(int arg0, BufferedRandomAccessFile arg1, BufferedRandomAccessFile arg2, int arg3) {
		this.archive = arg0;
		this.dat = arg1;
		this.idx = arg2;
		this.maxFileSize = arg3;
	}

	// jag::oldscape::jagex3::Js5LocalCache::DataFile::ReadFromFile
	@ObfuscatedName("ap.r(II)[B")
	public byte[] readFromFile(int arg0) {
		BufferedRandomAccessFile var2 = this.dat;
		synchronized (var2) {
			Object var10000;
			try {
				if (this.idx.length() < (long) (arg0 * 6 + 6)) {
					var10000 = null;
					return (byte[]) var10000;
				}
				this.idx.seek((long) (arg0 * 6));
				this.idx.read(temp, 0, 6);
				int var3 = (temp[2] & 0xFF) + ((temp[0] & 0xFF) << 16) + ((temp[1] & 0xFF) << 8);
				int var4 = (temp[5] & 0xFF) + ((temp[4] & 0xFF) << 8) + ((temp[3] & 0xFF) << 16);
				if (var3 < 0 || var3 > this.maxFileSize) {
					var10000 = null;
					return (byte[]) var10000;
				}
				if (var4 > 0 && (long) var4 <= this.dat.length() / 520L) {
					byte[] var5 = new byte[var3];
					int var6 = 0;
					int var7 = 0;
					while (var6 < var3) {
						if (var4 == 0) {
							var10000 = null;
							return (byte[]) var10000;
						}
						this.dat.seek((long) (var4 * 520));
						int var8 = var3 - var6;
						if (var8 > 512) {
							var8 = 512;
						}
						// jag::oldscape::jagex3::Js5LocalCache::DataFile::ReadBlockHeader
						this.dat.read(temp, 0, var8 + 8);
						int var9 = ((temp[0] & 0xFF) << 8) + (temp[1] & 0xFF);
						int var10 = ((temp[2] & 0xFF) << 8) + (temp[3] & 0xFF);
						int var11 = (temp[6] & 0xFF) + ((temp[4] & 0xFF) << 16) + ((temp[5] & 0xFF) << 8);
						int var12 = temp[7] & 0xFF;
						// jag::oldscape::jagex3::Js5LocalCache::DataFile::BlockHeader::Matches
						if (arg0 != var9 || var7 != var10 || this.archive != var12) {
							var10000 = null;
							return (byte[]) var10000;
						}
						if (var11 < 0 || (long) var11 > this.dat.length() / 520L) {
							var10000 = null;
							return (byte[]) var10000;
						}
						for (int var13 = 0; var13 < var8; var13++) {
							var5[var6++] = temp[var13 + 8];
						}
						var4 = var11;
						var7++;
					}
					byte[] var18 = var5;
					return var18;
				}
				var10000 = null;
			} catch (IOException var16) {
				return null;
			}
			return (byte[]) var10000;
		}
	}

	// jag::oldscape::jagex3::Js5LocalCache::DataFile::WriteToFile
	@ObfuscatedName("ap.d(I[BII)Z")
	public boolean writeToFile(int arg0, byte[] arg1, int arg2) {
		BufferedRandomAccessFile var4 = this.dat;
		synchronized (var4) {
			if (arg2 < 0 || arg2 > this.maxFileSize) {
				throw new IllegalArgumentException();
			}
			boolean var5 = this.writeToFile(arg0, arg1, arg2, true);
			if (!var5) {
				var5 = this.writeToFile(arg0, arg1, arg2, false);
			}
			return var5;
		}
	}

	// jag::oldscape::jagex3::Js5LocalCache::DataFile::WriteToFile
	@ObfuscatedName("ap.l(I[BIZI)Z")
	public boolean writeToFile(int arg0, byte[] arg1, int arg2, boolean arg3) {
		BufferedRandomAccessFile var5 = this.dat;
		synchronized (var5) {
			try {
				int var6;
				boolean var10000;
				if (arg3) {
					if (this.idx.length() < (long) (arg0 * 6 + 6)) {
						var10000 = false;
						return var10000;
					}
					this.idx.seek((long) (arg0 * 6));
					this.idx.read(temp, 0, 6);
					var6 = (temp[5] & 0xFF) + ((temp[4] & 0xFF) << 8) + ((temp[3] & 0xFF) << 16);
					if (var6 <= 0 || (long) var6 > this.dat.length() / 520L) {
						var10000 = false;
						return var10000;
					}
				} else {
					var6 = (int) ((this.dat.length() + 519L) / 520L);
					if (var6 == 0) {
						var6 = 1;
					}
				}
				temp[0] = (byte) (arg2 >> 16);
				temp[1] = (byte) (arg2 >> 8);
				temp[2] = (byte) arg2;
				temp[3] = (byte) (var6 >> 16);
				temp[4] = (byte) (var6 >> 8);
				temp[5] = (byte) var6;
				this.idx.seek((long) (arg0 * 6));
				this.idx.write(temp, 0, 6);
				int var7 = 0;
				int var8 = 0;
				while (true) {
					if (var7 < arg2) {
						label129:
						{
							int var9 = 0;
							if (arg3) {
								this.dat.seek((long) (var6 * 520));
								try {
									this.dat.read(temp, 0, 8);
								} catch (EOFException var17) {
									break label129;
								}
								int var11 = ((temp[0] & 0xFF) << 8) + (temp[1] & 0xFF);
								int var12 = ((temp[2] & 0xFF) << 8) + (temp[3] & 0xFF);
								var9 = (temp[6] & 0xFF) + ((temp[4] & 0xFF) << 16) + ((temp[5] & 0xFF) << 8);
								int var13 = temp[7] & 0xFF;
								if (arg0 != var11 || var8 != var12 || this.archive != var13) {
									var10000 = false;
									return var10000;
								}
								if (var9 < 0 || (long) var9 > this.dat.length() / 520L) {
									var10000 = false;
									return var10000;
								}
							}
							if (var9 == 0) {
								arg3 = false;
								var9 = (int) ((this.dat.length() + 519L) / 520L);
								if (var9 == 0) {
									var9++;
								}
								if (var6 == var9) {
									var9++;
								}
							}
							if (arg2 - var7 <= 512) {
								var9 = 0;
							}
							temp[0] = (byte) (arg0 >> 8);
							temp[1] = (byte) arg0;
							temp[2] = (byte) (var8 >> 8);
							temp[3] = (byte) var8;
							temp[4] = (byte) (var9 >> 16);
							temp[5] = (byte) (var9 >> 8);
							temp[6] = (byte) var9;
							temp[7] = (byte) this.archive;
							this.dat.seek((long) (var6 * 520));
							this.dat.write(temp, 0, 8);
							int var14 = arg2 - var7;
							if (var14 > 512) {
								var14 = 512;
							}
							this.dat.write(arg1, var7, var14);
							var7 += var14;
							var6 = var9;
							var8++;
							continue;
						}
					}
					var10000 = true;
					return var10000;
				}
			} catch (IOException var18) {
				return false;
			}
		}
	}
}
