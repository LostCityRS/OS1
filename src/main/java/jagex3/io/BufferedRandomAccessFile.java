package jagex3.io;

import deob.ObfuscatedName;

import java.io.EOFException;
import java.io.IOException;

// jag::oldscape::jagex3::Js5LocalCache::BufferedRandomAccessFile
@ObfuscatedName("v")
public class BufferedRandomAccessFile {

	@ObfuscatedName("v.r")
	public FileOnDisk file;

	@ObfuscatedName("v.d")
	public byte[] buffer;

	@ObfuscatedName("v.l")
	public long bufferStartPos = -1L;

	@ObfuscatedName("v.m")
	public int bufferPos;

	@ObfuscatedName("v.c")
	public byte[] writeBuffer;

	@ObfuscatedName("v.n")
	public long writeBufferPos = -1L;

	@ObfuscatedName("v.j")
	public int writeBufferSize = 0;

	@ObfuscatedName("v.z")
	public long targetPos;

	@ObfuscatedName("v.g")
	public long fileLength;

	@ObfuscatedName("v.q")
	public long field213;

	@ObfuscatedName("v.i")
	public long filePos;

	public BufferedRandomAccessFile(FileOnDisk arg0, int arg1, int arg2) throws IOException {
		this.file = arg0;
		this.field213 = this.fileLength = arg0.length();
		this.buffer = new byte[arg1];
		this.writeBuffer = new byte[arg2];
		this.targetPos = 0L;
	}

	@ObfuscatedName("v.r(I)V")
	public void close() throws IOException {
		this.flush();
		this.file.close();
	}

	@ObfuscatedName("v.d(J)V")
	public void seek(long arg0) throws IOException {
		if (arg0 < 0L) {
			throw new IOException("");
		}
		this.targetPos = arg0;
	}

	@ObfuscatedName("v.l(I)J")
	public long length() {
		return this.field213;
	}

	@ObfuscatedName("v.m([BI)V")
	public void read(byte[] arg0) throws IOException {
		this.read(arg0, 0, arg0.length);
	}

	@ObfuscatedName("v.c([BIII)V")
	public void read(byte[] arg0, int arg1, int arg2) throws IOException {
		try {
			if (arg1 + arg2 > arg0.length) {
				throw new ArrayIndexOutOfBoundsException(arg1 + arg2 - arg0.length);
			}
			if (this.writeBufferPos != -1L && this.targetPos >= this.writeBufferPos && this.targetPos + (long) arg2 <= this.writeBufferPos + (long) this.writeBufferSize) {
				System.arraycopy(this.writeBuffer, (int) (this.targetPos - this.writeBufferPos), arg0, arg1, arg2);
				this.targetPos += arg2;
				return;
			}
			long var4 = this.targetPos;
			int var6 = arg1;
			int var7 = arg2;
			if (this.targetPos >= this.bufferStartPos && this.targetPos < this.bufferStartPos + (long) this.bufferPos) {
				int var8 = (int) ((long) this.bufferPos - (this.targetPos - this.bufferStartPos));
				if (var8 > arg2) {
					var8 = arg2;
				}
				System.arraycopy(this.buffer, (int) (this.targetPos - this.bufferStartPos), arg0, arg1, var8);
				this.targetPos += var8;
				arg1 += var8;
				arg2 -= var8;
			}
			if (arg2 > this.buffer.length) {
				this.file.seek(this.targetPos);
				this.filePos = this.targetPos;
				while (arg2 > 0) {
					int var9 = this.file.read(arg0, arg1, arg2);
					if (var9 == -1) {
						break;
					}
					this.filePos += var9;
					this.targetPos += var9;
					arg1 += var9;
					arg2 -= var9;
				}
			} else if (arg2 > 0) {
				this.fillBuffer();
				int var10 = arg2;
				if (arg2 > this.bufferPos) {
					var10 = this.bufferPos;
				}
				System.arraycopy(this.buffer, 0, arg0, arg1, var10);
				arg1 += var10;
				arg2 -= var10;
				this.targetPos += var10;
			}
			if (this.writeBufferPos != -1L) {
				if (this.writeBufferPos > this.targetPos && arg2 > 0) {
					int var11 = (int) (this.writeBufferPos - this.targetPos) + arg1;
					if (var11 > arg1 + arg2) {
						var11 = arg1 + arg2;
					}
					while (arg1 < var11) {
						arg0[arg1++] = 0;
						arg2--;
						this.targetPos++;
					}
				}
				long var12 = -1L;
				long var14 = -1L;
				if (this.writeBufferPos >= var4 && this.writeBufferPos < (long) var7 + var4) {
					var12 = this.writeBufferPos;
				} else if (var4 >= this.writeBufferPos && var4 < this.writeBufferPos + (long) this.writeBufferSize) {
					var12 = var4;
				}
				if (this.writeBufferPos + (long) this.writeBufferSize > var4 && this.writeBufferPos + (long) this.writeBufferSize <= (long) var7 + var4) {
					var14 = this.writeBufferPos + (long) this.writeBufferSize;
				} else if ((long) var7 + var4 > this.writeBufferPos && (long) var7 + var4 <= this.writeBufferPos + (long) this.writeBufferSize) {
					var14 = (long) var7 + var4;
				}
				if (var12 > -1L && var14 > var12) {
					int var16 = (int) (var14 - var12);
					System.arraycopy(this.writeBuffer, (int) (var12 - this.writeBufferPos), arg0, (int) (var12 - var4) + var6, var16);
					if (var14 > this.targetPos) {
						arg2 = (int) ((long) arg2 - (var14 - this.targetPos));
						this.targetPos = var14;
					}
				}
			}
		} catch (IOException var18) {
			this.filePos = -1L;
			throw var18;
		}
		if (arg2 > 0) {
			throw new EOFException();
		}
	}

	@ObfuscatedName("v.n(I)V")
	public void fillBuffer() throws IOException {
		this.bufferPos = 0;
		if (this.targetPos != this.filePos) {
			this.file.seek(this.targetPos);
			this.filePos = this.targetPos;
		}
		this.bufferStartPos = this.targetPos;
		while (this.bufferPos < this.buffer.length) {
			int var1 = this.file.read(this.buffer, this.bufferPos, this.buffer.length - this.bufferPos);
			if (var1 == -1) {
				break;
			}
			this.filePos += var1;
			this.bufferPos += var1;
		}
	}

	@ObfuscatedName("v.j([BIIB)V")
	public void write(byte[] arg0, int arg1, int arg2) throws IOException {
		try {
			if (this.targetPos + (long) arg2 > this.field213) {
				this.field213 = this.targetPos + (long) arg2;
			}
			if (this.writeBufferPos != -1L && (this.targetPos < this.writeBufferPos || this.targetPos > this.writeBufferPos + (long) this.writeBufferSize)) {
				this.flush();
			}
			if (this.writeBufferPos != -1L && this.targetPos + (long) arg2 > this.writeBufferPos + (long) this.writeBuffer.length) {
				int var4 = (int) ((long) this.writeBuffer.length - (this.targetPos - this.writeBufferPos));
				System.arraycopy(arg0, arg1, this.writeBuffer, (int) (this.targetPos - this.writeBufferPos), var4);
				this.targetPos += var4;
				arg1 += var4;
				arg2 -= var4;
				this.writeBufferSize = this.writeBuffer.length;
				this.flush();
			}
			if (arg2 > this.writeBuffer.length) {
				if (this.targetPos != this.filePos) {
					this.file.seek(this.targetPos);
					this.filePos = this.targetPos;
				}
				this.file.write(arg0, arg1, arg2);
				this.filePos += arg2;
				if (this.filePos > this.fileLength) {
					this.fileLength = this.filePos;
				}
				long var5 = -1L;
				long var7 = -1L;
				if (this.targetPos >= this.bufferStartPos && this.targetPos < this.bufferStartPos + (long) this.bufferPos) {
					var5 = this.targetPos;
				} else if (this.bufferStartPos >= this.targetPos && this.bufferStartPos < this.targetPos + (long) arg2) {
					var5 = this.bufferStartPos;
				}
				if (this.targetPos + (long) arg2 > this.bufferStartPos && this.targetPos + (long) arg2 <= this.bufferStartPos + (long) this.bufferPos) {
					var7 = this.targetPos + (long) arg2;
				} else if (this.bufferStartPos + (long) this.bufferPos > this.targetPos && this.bufferStartPos + (long) this.bufferPos <= this.targetPos + (long) arg2) {
					var7 = this.bufferStartPos + (long) this.bufferPos;
				}
				if (var5 > -1L && var7 > var5) {
					int var9 = (int) (var7 - var5);
					System.arraycopy(arg0, (int) ((long) arg1 + var5 - this.targetPos), this.buffer, (int) (var5 - this.bufferStartPos), var9);
				}
				this.targetPos += arg2;
			} else if (arg2 > 0) {
				if (this.writeBufferPos == -1L) {
					this.writeBufferPos = this.targetPos;
				}
				System.arraycopy(arg0, arg1, this.writeBuffer, (int) (this.targetPos - this.writeBufferPos), arg2);
				this.targetPos += arg2;
				if (this.targetPos - this.writeBufferPos > (long) this.writeBufferSize) {
					this.writeBufferSize = (int) (this.targetPos - this.writeBufferPos);
				}
			}
		} catch (IOException var11) {
			this.filePos = -1L;
			throw var11;
		}
	}

	@ObfuscatedName("v.z(I)V")
	public void flush() throws IOException {
		if (this.writeBufferPos == -1L) {
			return;
		}
		if (this.writeBufferPos != this.filePos) {
			this.file.seek(this.writeBufferPos);
			this.filePos = this.writeBufferPos;
		}
		this.file.write(this.writeBuffer, 0, this.writeBufferSize);
		this.filePos += this.writeBufferSize;
		if (this.filePos > this.fileLength) {
			this.fileLength = this.filePos;
		}
		long var1 = -1L;
		long var3 = -1L;
		if (this.writeBufferPos >= this.bufferStartPos && this.writeBufferPos < this.bufferStartPos + (long) this.bufferPos) {
			var1 = this.writeBufferPos;
		} else if (this.bufferStartPos >= this.writeBufferPos && this.bufferStartPos < this.writeBufferPos + (long) this.writeBufferSize) {
			var1 = this.bufferStartPos;
		}
		if (this.writeBufferPos + (long) this.writeBufferSize > this.bufferStartPos && this.writeBufferPos + (long) this.writeBufferSize <= this.bufferStartPos + (long) this.bufferPos) {
			var3 = this.writeBufferPos + (long) this.writeBufferSize;
		} else if (this.bufferStartPos + (long) this.bufferPos > this.writeBufferPos && this.bufferStartPos + (long) this.bufferPos <= this.writeBufferPos + (long) this.writeBufferSize) {
			var3 = this.bufferStartPos + (long) this.bufferPos;
		}
		if (var1 > -1L && var3 > var1) {
			int var5 = (int) (var3 - var1);
			System.arraycopy(this.writeBuffer, (int) (var1 - this.writeBufferPos), this.buffer, (int) (var1 - this.bufferStartPos), var5);
		}
		this.writeBufferPos = -1L;
		this.writeBufferSize = 0;
	}
}
