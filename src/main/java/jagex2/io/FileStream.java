package jagex2.io;

import deob.ObfuscatedName;
import java.io.EOFException;
import java.io.IOException;

@ObfuscatedName("ap")
public class FileStream {

	@ObfuscatedName("ap.r")
	public static byte[] field365 = new byte[520];

	@ObfuscatedName("ap.d")
	public BufferedFile field364 = null;

	@ObfuscatedName("ap.l")
	public BufferedFile field363 = null;

	@ObfuscatedName("ap.m")
	public int field366;

	@ObfuscatedName("ap.c")
	public int field367 = 65000;

	public FileStream(int arg0, BufferedFile arg1, BufferedFile arg2, int arg3) {
		this.field366 = arg0;
		this.field363 = arg1;
		this.field364 = arg2;
		this.field367 = arg3;
	}

	@ObfuscatedName("ap.r(II)[B")
	public byte[] method418(int arg0) {
		BufferedFile var2 = this.field363;
		synchronized (this.field363) {
			Object var10000;
			try {
				if (this.field364.method133() < (long) (arg0 * 6 + 6)) {
					var10000 = null;
					return (byte[]) var10000;
				}
				this.field364.method132((long) (arg0 * 6));
				this.field364.method135(field365, 0, 6);
				int var3 = (field365[2] & 0xFF) + ((field365[0] & 0xFF) << 16) + ((field365[1] & 0xFF) << 8);
				int var4 = (field365[5] & 0xFF) + ((field365[4] & 0xFF) << 8) + ((field365[3] & 0xFF) << 16);
				if (var3 < 0 || var3 > this.field367) {
					var10000 = null;
					return (byte[]) var10000;
				}
				if (var4 > 0 && (long) var4 <= this.field363.method133() / 520L) {
					byte[] var5 = new byte[var3];
					int var6 = 0;
					int var7 = 0;
					while (var6 < var3) {
						if (var4 == 0) {
							var10000 = null;
							return (byte[]) var10000;
						}
						this.field363.method132((long) (var4 * 520));
						int var8 = var3 - var6;
						if (var8 > 512) {
							var8 = 512;
						}
						this.field363.method135(field365, 0, var8 + 8);
						int var9 = ((field365[0] & 0xFF) << 8) + (field365[1] & 0xFF);
						int var10 = ((field365[2] & 0xFF) << 8) + (field365[3] & 0xFF);
						int var11 = (field365[6] & 0xFF) + ((field365[4] & 0xFF) << 16) + ((field365[5] & 0xFF) << 8);
						int var12 = field365[7] & 0xFF;
						if (arg0 != var9 || var7 != var10 || this.field366 != var12) {
							var10000 = null;
							return (byte[]) var10000;
						}
						if (var11 < 0 || (long) var11 > this.field363.method133() / 520L) {
							var10000 = null;
							return (byte[]) var10000;
						}
						for (int var13 = 0; var13 < var8; var13++) {
							var5[var6++] = field365[var13 + 8];
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

	@ObfuscatedName("ap.d(I[BII)Z")
	public boolean method410(int arg0, byte[] arg1, int arg2) {
		BufferedFile var4 = this.field363;
		synchronized (this.field363) {
			if (arg2 < 0 || arg2 > this.field367) {
				throw new IllegalArgumentException();
			}
			boolean var5 = this.method411(arg0, arg1, arg2, true);
			if (!var5) {
				var5 = this.method411(arg0, arg1, arg2, false);
			}
			return var5;
		}
	}

	@ObfuscatedName("ap.l(I[BIZI)Z")
	public boolean method411(int arg0, byte[] arg1, int arg2, boolean arg3) {
		BufferedFile var5 = this.field363;
		synchronized (this.field363) {
			try {
				int var6;
				boolean var10000;
				if (arg3) {
					if (this.field364.method133() < (long) (arg0 * 6 + 6)) {
						var10000 = false;
						return var10000;
					}
					this.field364.method132((long) (arg0 * 6));
					this.field364.method135(field365, 0, 6);
					var6 = (field365[5] & 0xFF) + ((field365[4] & 0xFF) << 8) + ((field365[3] & 0xFF) << 16);
					if (var6 <= 0 || (long) var6 > this.field363.method133() / 520L) {
						var10000 = false;
						return var10000;
					}
				} else {
					var6 = (int) ((this.field363.method133() + 519L) / 520L);
					if (var6 == 0) {
						var6 = 1;
					}
				}
				field365[0] = (byte) (arg2 >> 16);
				field365[1] = (byte) (arg2 >> 8);
				field365[2] = (byte) arg2;
				field365[3] = (byte) (var6 >> 16);
				field365[4] = (byte) (var6 >> 8);
				field365[5] = (byte) var6;
				this.field364.method132((long) (arg0 * 6));
				this.field364.method153(field365, 0, 6);
				int var7 = 0;
				int var8 = 0;
				while (true) {
					if (var7 < arg2) {
						label129: {
							int var9 = 0;
							if (arg3) {
								this.field363.method132((long) (var6 * 520));
								try {
									this.field363.method135(field365, 0, 8);
								} catch (EOFException var17) {
									break label129;
								}
								int var11 = ((field365[0] & 0xFF) << 8) + (field365[1] & 0xFF);
								int var12 = ((field365[2] & 0xFF) << 8) + (field365[3] & 0xFF);
								var9 = (field365[6] & 0xFF) + ((field365[4] & 0xFF) << 16) + ((field365[5] & 0xFF) << 8);
								int var13 = field365[7] & 0xFF;
								if (arg0 != var11 || var8 != var12 || this.field366 != var13) {
									var10000 = false;
									return var10000;
								}
								if (var9 < 0 || (long) var9 > this.field363.method133() / 520L) {
									var10000 = false;
									return var10000;
								}
							}
							if (var9 == 0) {
								arg3 = false;
								var9 = (int) ((this.field363.method133() + 519L) / 520L);
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
							field365[0] = (byte) (arg0 >> 8);
							field365[1] = (byte) arg0;
							field365[2] = (byte) (var8 >> 8);
							field365[3] = (byte) var8;
							field365[4] = (byte) (var9 >> 16);
							field365[5] = (byte) (var9 >> 8);
							field365[6] = (byte) var9;
							field365[7] = (byte) this.field366;
							this.field363.method132((long) (var6 * 520));
							this.field363.method153(field365, 0, 8);
							int var14 = arg2 - var7;
							if (var14 > 512) {
								var14 = 512;
							}
							this.field363.method153(arg1, var7, var14);
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
