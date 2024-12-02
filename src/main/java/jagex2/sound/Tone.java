package jagex2.sound;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.datastruct.ArrayUtil;
import jagex2.io.Packet;

import java.util.Random;

@ObfuscatedName("t")
public class Tone {

	@ObfuscatedName("t.r")
	public Envelope field276;

	@ObfuscatedName("t.d")
	public Envelope field265;

	@ObfuscatedName("t.l")
	public Envelope field272;

	@ObfuscatedName("t.m")
	public Envelope field267;

	@ObfuscatedName("t.c")
	public Envelope field268;

	@ObfuscatedName("t.n")
	public Envelope field269;

	@ObfuscatedName("t.j")
	public Envelope field282;

	@ObfuscatedName("t.z")
	public Envelope field271;

	@ObfuscatedName("t.g")
	public int[] field281 = new int[] { 0, 0, 0, 0, 0 };

	@ObfuscatedName("t.q")
	public int[] field273 = new int[] { 0, 0, 0, 0, 0 };

	@ObfuscatedName("t.i")
	public int[] field274 = new int[] { 0, 0, 0, 0, 0 };

	@ObfuscatedName("t.s")
	public int field264 = 0;

	@ObfuscatedName("t.u")
	public int field266 = 100;

	@ObfuscatedName("t.v")
	public Filter field277;

	@ObfuscatedName("t.w")
	public Envelope field278;

	@ObfuscatedName("t.e")
	public int field279 = 500;

	@ObfuscatedName("t.b")
	public int field280 = 0;

	@ObfuscatedName("t.y")
	public static int[] field270;

	@ObfuscatedName("t.t")
	public static int[] field284 = new int[32768];

	@ObfuscatedName("t.f")
	public static int[] field283;

	@ObfuscatedName("t.o")
	public static int[] field275;

	@ObfuscatedName("t.a")
	public static int[] field286;

	@ObfuscatedName("t.h")
	public static int[] field287;

	@ObfuscatedName("t.x")
	public static int[] field288;

	@ObfuscatedName("t.p")
	public static int[] field289;

	static {
		Random var0 = new Random(0L);
		for (int var1 = 0; var1 < 32768; var1++) {
			field284[var1] = (var0.nextInt() & 0x2) - 1;
		}
		field283 = new int[32768];
		for (int var2 = 0; var2 < 32768; var2++) {
			field283[var2] = (int) (Math.sin((double) var2 / 5215.1903D) * 16384.0D);
		}
		field270 = new int[220500];
		field275 = new int[5];
		field286 = new int[5];
		field287 = new int[5];
		field288 = new int[5];
		field289 = new int[5];
	}

	@ObfuscatedName("t.r(II)[I")
	public final int[] method269(int arg0, int arg1) {
		ArrayUtil.method883(field270, 0, arg0);
		if (arg1 < 10) {
			return field270;
		}
		double var3 = (double) arg0 / ((double) arg1 + 0.0D);
		this.field276.method284();
		this.field265.method284();
		int var5 = 0;
		int var6 = 0;
		int var7 = 0;
		if (this.field272 != null) {
			this.field272.method284();
			this.field267.method284();
			var5 = (int) ((double) (this.field272.field299 - this.field272.field305) * 32.768D / var3);
			var6 = (int) ((double) this.field272.field305 * 32.768D / var3);
		}
		int var8 = 0;
		int var9 = 0;
		int var10 = 0;
		if (this.field268 != null) {
			this.field268.method284();
			this.field269.method284();
			var8 = (int) ((double) (this.field268.field299 - this.field268.field305) * 32.768D / var3);
			var9 = (int) ((double) this.field268.field305 * 32.768D / var3);
		}
		for (int var11 = 0; var11 < 5; var11++) {
			if (this.field281[var11] != 0) {
				field275[var11] = 0;
				field286[var11] = (int) ((double) this.field274[var11] * var3);
				field287[var11] = (this.field281[var11] << 14) / 100;
				field288[var11] = (int) ((double) (this.field276.field299 - this.field276.field305) * 32.768D * Math.pow(1.0057929410678534D, (double) this.field273[var11]) / var3);
				field289[var11] = (int) ((double) this.field276.field305 * 32.768D / var3);
			}
		}
		for (int var12 = 0; var12 < arg0; var12++) {
			int var13 = this.field276.method279(arg0);
			int var14 = this.field265.method279(arg0);
			if (this.field272 != null) {
				int var15 = this.field272.method279(arg0);
				int var16 = this.field267.method279(arg0);
				var13 += this.method264(var7, var16, this.field272.field295) >> 1;
				var7 += (var5 * var15 >> 16) + var6;
			}
			if (this.field268 != null) {
				int var17 = this.field268.method279(arg0);
				int var18 = this.field269.method279(arg0);
				var14 = var14 * ((this.method264(var10, var18, this.field268.field295) >> 1) + 32768) >> 15;
				var10 += (var8 * var17 >> 16) + var9;
			}
			for (int var19 = 0; var19 < 5; var19++) {
				if (this.field281[var19] != 0) {
					int var20 = field286[var19] + var12;
					if (var20 < arg0) {
						field270[var20] += this.method264(field275[var19], field287[var19] * var14 >> 15, this.field276.field295);
						field275[var19] += (field288[var19] * var13 >> 16) + field289[var19];
					}
				}
			}
		}
		if (this.field282 != null) {
			this.field282.method284();
			this.field271.method284();
			int var21 = 0;
			boolean var22 = false;
			boolean var23 = true;
			for (int var24 = 0; var24 < arg0; var24++) {
				int var25 = this.field282.method279(arg0);
				int var26 = this.field271.method279(arg0);
				int var27;
				if (var23) {
					var27 = ((this.field282.field299 - this.field282.field305) * var25 >> 8) + this.field282.field305;
				} else {
					var27 = ((this.field282.field299 - this.field282.field305) * var26 >> 8) + this.field282.field305;
				}
				var21 += 256;
				if (var21 >= var27) {
					var21 = 0;
					var23 = !var23;
				}
				if (var23) {
					field270[var24] = 0;
				}
			}
		}
		if (this.field264 > 0 && this.field266 > 0) {
			int var28 = (int) ((double) this.field264 * var3);
			for (int var29 = var28; var29 < arg0; var29++) {
				field270[var29] += field270[var29 - var28] * this.field266 / 100;
			}
		}
		if (this.field277.field338[0] > 0 || this.field277.field338[1] > 0) {
			this.field278.method284();
			int var30 = this.field278.method279(arg0 + 1);
			int var31 = this.field277.method351(0, (float) var30 / 65536.0F);
			int var32 = this.field277.method351(1, (float) var30 / 65536.0F);
			if (arg0 >= var31 + var32) {
				int var33 = 0;
				int var34 = var32;
				if (var32 > arg0 - var31) {
					var34 = arg0 - var31;
				}
				while (var33 < var34) {
					int var35 = (int) ((long) field270[var31 + var33] * (long) Statics.field344 >> 16);
					for (int var36 = 0; var36 < var31; var36++) {
						var35 += (int) ((long) field270[var31 + var33 - 1 - var36] * (long) Filter.field342[0][var36] >> 16);
					}
					for (int var37 = 0; var37 < var33; var37++) {
						var35 -= (int) ((long) field270[var33 - 1 - var37] * (long) Filter.field342[1][var37] >> 16);
					}
					field270[var33] = var35;
					var30 = this.field278.method279(arg0 + 1);
					var33++;
				}
				int var38 = 128;
				while (true) {
					if (var38 > arg0 - var31) {
						var38 = arg0 - var31;
					}
					while (var33 < var38) {
						int var39 = (int) ((long) field270[var31 + var33] * (long) Statics.field344 >> 16);
						for (int var40 = 0; var40 < var31; var40++) {
							var39 += (int) ((long) field270[var31 + var33 - 1 - var40] * (long) Filter.field342[0][var40] >> 16);
						}
						for (int var41 = 0; var41 < var32; var41++) {
							var39 -= (int) ((long) field270[var33 - 1 - var41] * (long) Filter.field342[1][var41] >> 16);
						}
						field270[var33] = var39;
						var30 = this.field278.method279(arg0 + 1);
						var33++;
					}
					if (var33 >= arg0 - var31) {
						while (var33 < arg0) {
							int var42 = 0;
							for (int var43 = var31 + var33 - arg0; var43 < var31; var43++) {
								var42 += (int) ((long) field270[var31 + var33 - 1 - var43] * (long) Filter.field342[0][var43] >> 16);
							}
							for (int var44 = 0; var44 < var32; var44++) {
								var42 -= (int) ((long) field270[var33 - 1 - var44] * (long) Filter.field342[1][var44] >> 16);
							}
							field270[var33] = var42;
							this.field278.method279(arg0 + 1);
							var33++;
						}
						break;
					}
					var31 = this.field277.method351(0, (float) var30 / 65536.0F);
					var32 = this.field277.method351(1, (float) var30 / 65536.0F);
					var38 += 128;
				}
			}
		}
		for (int var46 = 0; var46 < arg0; var46++) {
			if (field270[var46] < -32768) {
				field270[var46] = -32768;
			}
			if (field270[var46] > 32767) {
				field270[var46] = 32767;
			}
		}
		return field270;
	}

	@ObfuscatedName("t.d(III)I")
	public final int method264(int arg0, int arg1, int arg2) {
		if (arg2 == 1) {
			return (arg0 & 0x7FFF) < 16384 ? arg1 : -arg1;
		} else if (arg2 == 2) {
			return field283[arg0 & 0x7FFF] * arg1 >> 14;
		} else if (arg2 == 3) {
			return ((arg0 & 0x7FFF) * arg1 >> 14) - arg1;
		} else if (arg2 == 4) {
			return field284[arg0 / 2607 & 0x7FFF] * arg1;
		} else {
			return 0;
		}
	}

	@ObfuscatedName("t.l(Lev;)V")
	public final void method263(Packet arg0) {
		this.field276 = new Envelope();
		this.field276.method276(arg0);
		this.field265 = new Envelope();
		this.field265.method276(arg0);
		int var2 = arg0.method1600();
		if (var2 != 0) {
			arg0.field1729--;
			this.field272 = new Envelope();
			this.field272.method276(arg0);
			this.field267 = new Envelope();
			this.field267.method276(arg0);
		}
		int var3 = arg0.method1600();
		if (var3 != 0) {
			arg0.field1729--;
			this.field268 = new Envelope();
			this.field268.method276(arg0);
			this.field269 = new Envelope();
			this.field269.method276(arg0);
		}
		int var4 = arg0.method1600();
		if (var4 != 0) {
			arg0.field1729--;
			this.field282 = new Envelope();
			this.field282.method276(arg0);
			this.field271 = new Envelope();
			this.field271.method276(arg0);
		}
		for (int var5 = 0; var5 < 10; var5++) {
			int var6 = arg0.method1640();
			if (var6 == 0) {
				break;
			}
			this.field281[var5] = var6;
			this.field273[var5] = arg0.method1612();
			this.field274[var5] = arg0.method1640();
		}
		this.field264 = arg0.method1640();
		this.field266 = arg0.method1640();
		this.field279 = arg0.method1602();
		this.field280 = arg0.method1602();
		this.field277 = new Filter();
		this.field278 = new Envelope();
		this.field277.method357(arg0, this.field278);
	}
}
