package jagex2.io;

import deob.ObfuscatedName;

import java.io.EOFException;
import java.io.IOException;

@ObfuscatedName("v")
public class BufferedFile {

	@ObfuscatedName("v.r")
	public FileOnDisk field204;

	@ObfuscatedName("v.d")
	public byte[] field208;

	@ObfuscatedName("v.l")
	public long field205 = -1L;

	@ObfuscatedName("v.m")
	public int field203;

	@ObfuscatedName("v.c")
	public byte[] field207;

	@ObfuscatedName("v.n")
	public long field212 = -1L;

	@ObfuscatedName("v.j")
	public int field209 = 0;

	@ObfuscatedName("v.z")
	public long field210;

	@ObfuscatedName("v.g")
	public long field211;

	@ObfuscatedName("v.q")
	public long field213;

	@ObfuscatedName("v.i")
	public long field206;

	public BufferedFile(FileOnDisk arg0, int arg1, int arg2) throws IOException {
		this.field204 = arg0;
		this.field213 = this.field211 = arg0.length();
		this.field208 = new byte[arg1];
		this.field207 = new byte[arg2];
		this.field210 = 0L;
	}

	@ObfuscatedName("v.r(I)V")
	public void method137() throws IOException {
		this.method138();
		this.field204.close();
	}

	@ObfuscatedName("v.d(J)V")
	public void seek(long arg0) throws IOException {
		if (arg0 < 0L) {
			throw new IOException("");
		}
		this.field210 = arg0;
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
			if (this.field212 != -1L && this.field210 >= this.field212 && this.field210 + (long) arg2 <= this.field212 + (long) this.field209) {
				System.arraycopy(this.field207, (int) (this.field210 - this.field212), arg0, arg1, arg2);
				this.field210 += arg2;
				return;
			}
			long var4 = this.field210;
			int var6 = arg1;
			int var7 = arg2;
			if (this.field210 >= this.field205 && this.field210 < this.field205 + (long) this.field203) {
				int var8 = (int) ((long) this.field203 - (this.field210 - this.field205));
				if (var8 > arg2) {
					var8 = arg2;
				}
				System.arraycopy(this.field208, (int) (this.field210 - this.field205), arg0, arg1, var8);
				this.field210 += var8;
				arg1 += var8;
				arg2 -= var8;
			}
			if (arg2 > this.field208.length) {
				this.field204.seek(this.field210);
				this.field206 = this.field210;
				while (arg2 > 0) {
					int var9 = this.field204.read(arg0, arg1, arg2);
					if (var9 == -1) {
						break;
					}
					this.field206 += var9;
					this.field210 += var9;
					arg1 += var9;
					arg2 -= var9;
				}
			} else if (arg2 > 0) {
				this.method130();
				int var10 = arg2;
				if (arg2 > this.field203) {
					var10 = this.field203;
				}
				System.arraycopy(this.field208, 0, arg0, arg1, var10);
				arg1 += var10;
				arg2 -= var10;
				this.field210 += var10;
			}
			if (this.field212 != -1L) {
				if (this.field212 > this.field210 && arg2 > 0) {
					int var11 = (int) (this.field212 - this.field210) + arg1;
					if (var11 > arg1 + arg2) {
						var11 = arg1 + arg2;
					}
					while (arg1 < var11) {
						arg0[arg1++] = 0;
						arg2--;
						this.field210++;
					}
				}
				long var12 = -1L;
				long var14 = -1L;
				if (this.field212 >= var4 && this.field212 < (long) var7 + var4) {
					var12 = this.field212;
				} else if (var4 >= this.field212 && var4 < this.field212 + (long) this.field209) {
					var12 = var4;
				}
				if (this.field212 + (long) this.field209 > var4 && this.field212 + (long) this.field209 <= (long) var7 + var4) {
					var14 = this.field212 + (long) this.field209;
				} else if ((long) var7 + var4 > this.field212 && (long) var7 + var4 <= this.field212 + (long) this.field209) {
					var14 = (long) var7 + var4;
				}
				if (var12 > -1L && var14 > var12) {
					int var16 = (int) (var14 - var12);
					System.arraycopy(this.field207, (int) (var12 - this.field212), arg0, (int) (var12 - var4) + var6, var16);
					if (var14 > this.field210) {
						arg2 = (int) ((long) arg2 - (var14 - this.field210));
						this.field210 = var14;
					}
				}
			}
		} catch (IOException var18) {
			this.field206 = -1L;
			throw var18;
		}
		if (arg2 > 0) {
			throw new EOFException();
		}
	}

	@ObfuscatedName("v.n(I)V")
	public void method130() throws IOException {
		this.field203 = 0;
		if (this.field210 != this.field206) {
			this.field204.seek(this.field210);
			this.field206 = this.field210;
		}
		this.field205 = this.field210;
		while (this.field203 < this.field208.length) {
			int var1 = this.field204.read(this.field208, this.field203, this.field208.length - this.field203);
			if (var1 == -1) {
				break;
			}
			this.field206 += var1;
			this.field203 += var1;
		}
	}

	@ObfuscatedName("v.j([BIIB)V")
	public void write(byte[] arg0, int arg1, int arg2) throws IOException {
		try {
			if (this.field210 + (long) arg2 > this.field213) {
				this.field213 = this.field210 + (long) arg2;
			}
			if (this.field212 != -1L && (this.field210 < this.field212 || this.field210 > this.field212 + (long) this.field209)) {
				this.method138();
			}
			if (this.field212 != -1L && this.field210 + (long) arg2 > this.field212 + (long) this.field207.length) {
				int var4 = (int) ((long) this.field207.length - (this.field210 - this.field212));
				System.arraycopy(arg0, arg1, this.field207, (int) (this.field210 - this.field212), var4);
				this.field210 += var4;
				arg1 += var4;
				arg2 -= var4;
				this.field209 = this.field207.length;
				this.method138();
			}
			if (arg2 > this.field207.length) {
				if (this.field210 != this.field206) {
					this.field204.seek(this.field210);
					this.field206 = this.field210;
				}
				this.field204.write(arg0, arg1, arg2);
				this.field206 += arg2;
				if (this.field206 > this.field211) {
					this.field211 = this.field206;
				}
				long var5 = -1L;
				long var7 = -1L;
				if (this.field210 >= this.field205 && this.field210 < this.field205 + (long) this.field203) {
					var5 = this.field210;
				} else if (this.field205 >= this.field210 && this.field205 < this.field210 + (long) arg2) {
					var5 = this.field205;
				}
				if (this.field210 + (long) arg2 > this.field205 && this.field210 + (long) arg2 <= this.field205 + (long) this.field203) {
					var7 = this.field210 + (long) arg2;
				} else if (this.field205 + (long) this.field203 > this.field210 && this.field205 + (long) this.field203 <= this.field210 + (long) arg2) {
					var7 = this.field205 + (long) this.field203;
				}
				if (var5 > -1L && var7 > var5) {
					int var9 = (int) (var7 - var5);
					System.arraycopy(arg0, (int) ((long) arg1 + var5 - this.field210), this.field208, (int) (var5 - this.field205), var9);
				}
				this.field210 += arg2;
			} else if (arg2 > 0) {
				if (this.field212 == -1L) {
					this.field212 = this.field210;
				}
				System.arraycopy(arg0, arg1, this.field207, (int) (this.field210 - this.field212), arg2);
				this.field210 += arg2;
				if (this.field210 - this.field212 > (long) this.field209) {
					this.field209 = (int) (this.field210 - this.field212);
				}
			}
		} catch (IOException var11) {
			this.field206 = -1L;
			throw var11;
		}
	}

	@ObfuscatedName("v.z(I)V")
	public void method138() throws IOException {
		if (this.field212 == -1L) {
			return;
		}
		if (this.field212 != this.field206) {
			this.field204.seek(this.field212);
			this.field206 = this.field212;
		}
		this.field204.write(this.field207, 0, this.field209);
		this.field206 += (long) (this.field209 * 1278705117) * 1663746677L;
		if (this.field206 > this.field211) {
			this.field211 = this.field206;
		}
		long var1 = -1L;
		long var3 = -1L;
		if (this.field212 >= this.field205 && this.field212 < this.field205 + (long) this.field203) {
			var1 = this.field212;
		} else if (this.field205 >= this.field212 && this.field205 < this.field212 + (long) this.field209) {
			var1 = this.field205;
		}
		if (this.field212 + (long) this.field209 > this.field205 && this.field212 + (long) this.field209 <= this.field205 + (long) this.field203) {
			var3 = this.field212 + (long) this.field209;
		} else if (this.field205 + (long) this.field203 > this.field212 && this.field205 + (long) this.field203 <= this.field212 + (long) this.field209) {
			var3 = this.field205 + (long) this.field203;
		}
		if (var1 > -1L && var3 > var1) {
			int var5 = (int) (var3 - var1);
			System.arraycopy(this.field207, (int) (var1 - this.field212), this.field208, (int) (var1 - this.field205), var5);
		}
		this.field212 = -1L;
		this.field209 = 0;
	}
}
