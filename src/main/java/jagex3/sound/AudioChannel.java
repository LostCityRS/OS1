package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.client.SignLink;
import jagex3.datastruct.ArrayUtil;
import jagex3.datastruct.MonotonicTime;
import jagex3.datastruct.PreciseSleep;

import java.awt.*;

@ObfuscatedName("y")
public class AudioChannel {

	@ObfuscatedName("y.r")
	public static int field241;

	@ObfuscatedName("y.d")
	public static boolean field236;

	@ObfuscatedName("y.l")
	public static int field239;

	@ObfuscatedName("y.m")
	public static AudioThread field238;

	@ObfuscatedName("y.j")
	public int[] field243;

	@ObfuscatedName("y.z")
	public PcmStream field242;

	@ObfuscatedName("y.g")
	public int field256 = 32;

	@ObfuscatedName("y.q")
	public long field244 = MonotonicTime.method1135();

	@ObfuscatedName("y.i")
	public int field245;

	@ObfuscatedName("y.s")
	public int field246;

	@ObfuscatedName("y.u")
	public int field247;

	@ObfuscatedName("y.v")
	public long field248 = 0L;

	@ObfuscatedName("y.w")
	public int field249 = 0;

	@ObfuscatedName("y.e")
	public int field255 = 0;

	@ObfuscatedName("y.b")
	public int field251 = 0;

	@ObfuscatedName("y.y")
	public long field250 = 0L;

	@ObfuscatedName("y.t")
	public boolean field253 = true;

	@ObfuscatedName("y.x")
	public int field259 = 0;

	@ObfuscatedName("y.p")
	public PcmStream[] field240 = new PcmStream[8];

	@ObfuscatedName("y.ad")
	public PcmStream[] field261 = new PcmStream[8];

	@ObfuscatedName("bx.r(IZII)V")
	public static final void method832(int arg0, boolean arg1, int arg2) {
		if (arg0 < 8000 || arg0 > 48000) {
			throw new IllegalArgumentException();
		}
		field241 = arg0;
		field236 = arg1;
		field239 = arg2;
	}

	@ObfuscatedName("cm.d(Lak;Ljava/awt/Component;III)Ly;")
	public static final AudioChannel method1132(SignLink arg0, Component arg1, int arg2, int arg3) {
		if (field241 == 0) {
			throw new IllegalStateException();
		} else if (arg2 >= 0 && arg2 < 2) {
			if (arg3 < 256) {
				arg3 = 256;
			}
			try {
				JavaAudioChannel var4 = new JavaAudioChannel();
				var4.field243 = new int[(field236 ? 2 : 1) * 256];
				var4.field246 = arg3;
				var4.method209(arg1);
				var4.field245 = (arg3 & 0xFFFFFC00) + 1024;
				if (var4.field245 > 16384) {
					var4.field245 = 16384;
				}
				var4.method214(var4.field245);
				if (field239 > 0 && field238 == null) {
					field238 = new AudioThread();
					field238.field290 = arg0;
					arg0.startThread(field238, field239);
				}
				if (field238 != null) {
					if (field238.field293[arg2] != null) {
						throw new IllegalArgumentException();
					}
					field238.field293[arg2] = var4;
				}
				return var4;
			} catch (Throwable var9) {
				try {
					SignLinkAudioChannel var6 = new SignLinkAudioChannel(arg0, arg2);
					var6.field243 = new int[(field236 ? 2 : 1) * 256];
					var6.field246 = arg3;
					var6.method209(arg1);
					var6.field245 = 16384;
					var6.method214(var6.field245);
					if (field239 > 0 && field238 == null) {
						field238 = new AudioThread();
						field238.field290 = arg0;
						arg0.startThread(field238, field239);
					}
					if (field238 != null) {
						if (field238.field293[arg2] != null) {
							throw new IllegalArgumentException();
						}
						field238.field293[arg2] = var6;
					}
					return var6;
				} catch (Throwable var8) {
					return new AudioChannel();
				}
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("y.l(Ldx;I)V")
	public final synchronized void method240(PcmStream arg0) {
		this.field242 = arg0;
	}

	@ObfuscatedName("y.m(B)V")
	public final synchronized void method235() {
		if (this.field243 == null) {
			return;
		}
		long var1 = MonotonicTime.method1135();
		try {
			if (this.field248 != 0L) {
				if (var1 < this.field248) {
					return;
				}
				this.method214(this.field245);
				this.field248 = 0L;
				this.field253 = true;
			}
			int var3 = this.method215();
			if (this.field251 - var3 > this.field249) {
				this.field249 = this.field251 - var3;
			}
			int var4 = this.field247 + this.field246;
			if (var4 + 256 > 16384) {
				var4 = 16128;
			}
			if (var4 + 256 > this.field245) {
				this.field245 += 1024;
				if (this.field245 > 16384) {
					this.field245 = 16384;
				}
				this.method217();
				this.method214(this.field245);
				var3 = 0;
				this.field253 = true;
				if (var4 + 256 > this.field245) {
					var4 = this.field245 - 256;
					this.field247 = var4 - this.field246;
				}
			}
			while (var3 < var4) {
				this.method250(this.field243, 256);
				this.method216();
				var3 += 256;
			}
			if (var1 > this.field250) {
				if (this.field253) {
					this.field253 = false;
				} else if (this.field249 == 0 && this.field255 == 0) {
					this.method217();
					this.field248 = var1 + 2000L;
					return;
				} else {
					this.field247 = Math.min(this.field255, this.field249);
					this.field255 = this.field249;
				}
				this.field249 = 0;
				this.field250 = var1 + 2000L;
			}
			this.field251 = var3;
		} catch (Exception var8) {
			this.method217();
			this.field248 = var1 + 2000L;
		}
		try {
			if (var1 > this.field244 + 500000L) {
				var1 = this.field244;
			}
			while (var1 > this.field244 + 5000L) {
				this.method210(256);
				this.field244 += 256000 / field241;
			}
		} catch (Exception var7) {
			this.field244 = var1;
		}
	}

	@ObfuscatedName("y.c(B)V")
	public final void method207() {
		this.field253 = true;
	}

	@ObfuscatedName("y.n(I)V")
	public final synchronized void method208() {
		this.field253 = true;
		try {
			this.method218();
		} catch (Exception var2) {
			this.method217();
			this.field248 = MonotonicTime.method1135() + 2000L;
		}
	}

	@ObfuscatedName("y.j(I)V")
	public final synchronized void method248() {
		if (field238 != null) {
			boolean var1 = true;
			for (int var2 = 0; var2 < 2; var2++) {
				if (field238.field293[var2] == this) {
					field238.field293[var2] = null;
				}
				if (field238.field293[var2] != null) {
					var1 = false;
				}
			}
			if (var1) {
				field238.field292 = true;
				while (field238.field291) {
					PreciseSleep.sleep(50L);
				}
				field238 = null;
			}
		}
		this.method217();
		this.field243 = null;
	}

	@ObfuscatedName("y.z(II)V")
	public final void method210(int arg0) {
		this.field259 -= arg0;
		if (this.field259 < 0) {
			this.field259 = 0;
		}
		if (this.field242 != null) {
			this.field242.method1521(arg0);
		}
	}

	@ObfuscatedName("y.g([II)V")
	public final void method250(int[] arg0, int arg1) {
		int var3 = arg1;
		if (field236) {
			var3 = arg1 << 1;
		}
		ArrayUtil.method883(arg0, 0, var3);
		this.field259 -= arg1;
		if (this.field242 != null && this.field259 <= 0) {
			this.field259 += field241 >> 4;
			method815(this.field242);
			this.method212(this.field242, this.field242.method1514());
			int var4 = 0;
			int var5 = 255;
			int var6 = 7;
			label105: while (var5 != 0) {
				int var7;
				int var8;
				if (var6 < 0) {
					var7 = var6 & 0x3;
					var8 = -(var6 >> 2);
				} else {
					var7 = var6;
					var8 = 0;
				}
				for (int var9 = var5 >>> var7 & 0x11111111; var9 != 0; var9 >>>= 0x4) {
					if ((var9 & 0x1) != 0) {
						var5 &= ~(0x1 << var7);
						PcmStream var10 = null;
						PcmStream var11 = this.field240[var7];
						label99: while (true) {
							while (true) {
								if (var11 == null) {
									break label99;
								}
								Sound var12 = var11.field1644;
								if (var12 == null || var12.field1642 <= var8) {
									var11.field1643 = true;
									int var13 = var11.method1518();
									var4 += var13;
									if (var12 != null) {
										var12.field1642 += var13;
									}
									if (var4 >= this.field256) {
										break label105;
									}
									PcmStream var14 = var11.method1516();
									if (var14 != null) {
										int var15 = var11.field1646;
										while (var14 != null) {
											this.method212(var14, var15 * var14.method1514() >> 8);
											var14 = var11.method1517();
										}
									}
									PcmStream var16 = var11.field1645;
									var11.field1645 = null;
									if (var10 == null) {
										this.field240[var7] = var16;
									} else {
										var10.field1645 = var16;
									}
									if (var16 == null) {
										this.field261[var7] = var10;
									}
									var11 = var16;
								} else {
									var5 |= 0x1 << var7;
									var10 = var11;
									var11 = var11.field1645;
								}
							}
						}
					}
					var7 += 4;
					var8++;
				}
				var6--;
			}
			for (int var17 = 0; var17 < 8; var17++) {
				PcmStream var18 = this.field240[var17];
				PcmStream[] var19 = this.field240;
				this.field261[var17] = null;
				var19[var17] = null;
				while (var18 != null) {
					PcmStream var21 = var18.field1645;
					var18.field1645 = null;
					var18 = var21;
				}
			}
		}
		if (this.field259 < 0) {
			this.field259 = 0;
		}
		if (this.field242 != null) {
			this.field242.method1520(arg0, 0, arg1);
		}
		this.field244 = MonotonicTime.method1135();
	}

	@ObfuscatedName("bw.q(Ldx;I)V")
	public static final void method815(PcmStream arg0) {
		arg0.field1643 = false;
		if (arg0.field1644 != null) {
			arg0.field1644.field1642 = 0;
		}
		for (PcmStream var1 = arg0.method1516(); var1 != null; var1 = arg0.method1517()) {
			method815(var1);
		}
	}

	@ObfuscatedName("y.i(Ldx;II)V")
	public final void method212(PcmStream arg0, int arg1) {
		int var3 = arg1 >> 5;
		PcmStream var4 = this.field261[var3];
		if (var4 == null) {
			this.field240[var3] = arg0;
		} else {
			var4.field1645 = arg0;
		}
		this.field261[var3] = arg0;
		arg0.field1646 = arg1;
	}

	@ObfuscatedName("y.s(Ljava/awt/Component;)V")
	public void method209(Component arg0) throws Exception {
	}

	@ObfuscatedName("y.u(I)V")
	public void method214(int arg0) throws Exception {
	}

	@ObfuscatedName("y.v()I")
	public int method215() throws Exception {
		return this.field245;
	}

	@ObfuscatedName("y.w()V")
	public void method216() throws Exception {
	}

	@ObfuscatedName("y.e()V")
	public void method217() {
	}

	@ObfuscatedName("y.b()V")
	public void method218() throws Exception {
	}
}
