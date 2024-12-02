package jagex2.graphics;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.datastruct.DoublyLinkable;

@ObfuscatedName("fv")
public class Pix2D extends DoublyLinkable {

	@ObfuscatedName("fv.g")
	public static int field2483 = 0;

	@ObfuscatedName("fv.q")
	public static int field2482 = 0;

	@ObfuscatedName("fv.i")
	public static int field2485 = 0;

	@ObfuscatedName("fv.s")
	public static int field2484 = 0;

	@ObfuscatedName("fv.z([III)V")
	public static void method2583(int[] arg0, int arg1, int arg2) {
		Statics.field2486 = arg0;
		Statics.field2481 = arg1;
		Statics.field2480 = arg2;
		method2605(0, 0, arg1, arg2);
	}

	@ObfuscatedName("fv.g()V")
	public static void method2584() {
		field2485 = 0;
		field2483 = 0;
		field2484 = Statics.field2481;
		field2482 = Statics.field2480;
	}

	@ObfuscatedName("fv.q(IIII)V")
	public static void method2605(int arg0, int arg1, int arg2, int arg3) {
		if (arg0 < 0) {
			arg0 = 0;
		}
		if (arg1 < 0) {
			arg1 = 0;
		}
		if (arg2 > Statics.field2481) {
			arg2 = Statics.field2481;
		}
		if (arg3 > Statics.field2480) {
			arg3 = Statics.field2480;
		}
		field2485 = arg0;
		field2483 = arg1;
		field2484 = arg2;
		field2482 = arg3;
	}

	@ObfuscatedName("fv.i(IIII)V")
	public static void method2586(int arg0, int arg1, int arg2, int arg3) {
		if (field2485 < arg0) {
			field2485 = arg0;
		}
		if (field2483 < arg1) {
			field2483 = arg1;
		}
		if (field2484 > arg2) {
			field2484 = arg2;
		}
		if (field2482 > arg3) {
			field2482 = arg3;
		}
	}

	@ObfuscatedName("fv.s([I)V")
	public static void method2587(int[] arg0) {
		arg0[0] = field2485;
		arg0[1] = field2483;
		arg0[2] = field2484;
		arg0[3] = field2482;
	}

	@ObfuscatedName("fv.u([I)V")
	public static void method2612(int[] arg0) {
		field2485 = arg0[0];
		field2483 = arg0[1];
		field2484 = arg0[2];
		field2482 = arg0[3];
	}

	@ObfuscatedName("fv.v()V")
	public static void method2589() {
		int var0 = 0;
		int var1 = Statics.field2481 * Statics.field2480 - 7;
		while (var0 < var1) {
			Statics.field2486[var0++] = 0;
			Statics.field2486[var0++] = 0;
			Statics.field2486[var0++] = 0;
			Statics.field2486[var0++] = 0;
			Statics.field2486[var0++] = 0;
			Statics.field2486[var0++] = 0;
			Statics.field2486[var0++] = 0;
			Statics.field2486[var0++] = 0;
		}
		var1 += 7;
		while (var0 < var1) {
			Statics.field2486[var0++] = 0;
		}
	}

	@ObfuscatedName("fv.w(IIIIII)V")
	public static void method2616(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		if (arg0 < field2485) {
			arg2 -= field2485 - arg0;
			arg0 = field2485;
		}
		if (arg1 < field2483) {
			arg3 -= field2483 - arg1;
			arg1 = field2483;
		}
		if (arg0 + arg2 > field2484) {
			arg2 = field2484 - arg0;
		}
		if (arg1 + arg3 > field2482) {
			arg3 = field2482 - arg1;
		}
		int var6 = ((arg4 & 0xFF00FF) * arg5 >> 8 & 0xFF00FF) + ((arg4 & 0xFF00) * arg5 >> 8 & 0xFF00);
		int var7 = 256 - arg5;
		int var8 = Statics.field2481 - arg2;
		int var9 = Statics.field2481 * arg1 + arg0;
		for (int var10 = 0; var10 < arg3; var10++) {
			for (int var11 = -arg2; var11 < 0; var11++) {
				int var12 = Statics.field2486[var9];
				int var13 = ((var12 & 0xFF00FF) * var7 >> 8 & 0xFF00FF) + ((var12 & 0xFF00) * var7 >> 8 & 0xFF00);
				Statics.field2486[var9++] = var6 + var13;
			}
			var9 += var8;
		}
	}

	@ObfuscatedName("fv.e(IIIII)V")
	public static void method2637(int arg0, int arg1, int arg2, int arg3, int arg4) {
		if (arg0 < field2485) {
			arg2 -= field2485 - arg0;
			arg0 = field2485;
		}
		if (arg1 < field2483) {
			arg3 -= field2483 - arg1;
			arg1 = field2483;
		}
		if (arg0 + arg2 > field2484) {
			arg2 = field2484 - arg0;
		}
		if (arg1 + arg3 > field2482) {
			arg3 = field2482 - arg1;
		}
		int var5 = Statics.field2481 - arg2;
		int var6 = Statics.field2481 * arg1 + arg0;
		for (int var7 = -arg3; var7 < 0; var7++) {
			for (int var8 = -arg2; var8 < 0; var8++) {
				Statics.field2486[var6++] = arg4;
			}
			var6 += var5;
		}
	}

	@ObfuscatedName("fv.b(IIIIII)V")
	public static void method2592(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		int var6 = 0;
		int var7 = 65536 / arg3;
		if (arg0 < field2485) {
			arg2 -= field2485 - arg0;
			arg0 = field2485;
		}
		if (arg1 < field2483) {
			var6 += (field2483 - arg1) * var7;
			arg3 -= field2483 - arg1;
			arg1 = field2483;
		}
		if (arg0 + arg2 > field2484) {
			arg2 = field2484 - arg0;
		}
		if (arg1 + arg3 > field2482) {
			arg3 = field2482 - arg1;
		}
		int var8 = Statics.field2481 - arg2;
		int var9 = Statics.field2481 * arg1 + arg0;
		for (int var10 = -arg3; var10 < 0; var10++) {
			int var11 = 65536 - var6 >> 8;
			int var12 = var6 >> 8;
			int var13 = ((arg4 & 0xFF00FF) * var11 + (arg5 & 0xFF00FF) * var12 & 0xFF00FF00) + ((arg4 & 0xFF00) * var11 + (arg5 & 0xFF00) * var12 & 0xFF0000) >>> 8;
			for (int var14 = -arg2; var14 < 0; var14++) {
				Statics.field2486[var9++] = var13;
			}
			var9 += var8;
			var6 += var7;
		}
	}

	@ObfuscatedName("fv.y(IIIII)V")
	public static void method2639(int arg0, int arg1, int arg2, int arg3, int arg4) {
		method2594(arg0, arg1, arg2, arg4);
		method2594(arg0, arg1 + arg3 - 1, arg2, arg4);
		method2596(arg0, arg1, arg3, arg4);
		method2596(arg0 + arg2 - 1, arg1, arg3, arg4);
	}

	@ObfuscatedName("fv.t(IIIIII)V")
	public static void method2582(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		method2632(arg0, arg1, arg2, arg4, arg5);
		method2632(arg0, arg1 + arg3 - 1, arg2, arg4, arg5);
		if (arg3 >= 3) {
			method2597(arg0, arg1 + 1, arg3 - 2, arg4, arg5);
			method2597(arg0 + arg2 - 1, arg1 + 1, arg3 - 2, arg4, arg5);
		}
	}

	@ObfuscatedName("fv.f(IIII)V")
	public static void method2594(int arg0, int arg1, int arg2, int arg3) {
		if (arg1 < field2483 || arg1 >= field2482) {
			return;
		}
		if (arg0 < field2485) {
			arg2 -= field2485 - arg0;
			arg0 = field2485;
		}
		if (arg0 + arg2 > field2484) {
			arg2 = field2484 - arg0;
		}
		int var4 = Statics.field2481 * arg1 + arg0;
		for (int var5 = 0; var5 < arg2; var5++) {
			Statics.field2486[var4 + var5] = arg3;
		}
	}

	@ObfuscatedName("fv.k(IIIII)V")
	public static void method2632(int arg0, int arg1, int arg2, int arg3, int arg4) {
		if (arg1 < field2483 || arg1 >= field2482) {
			return;
		}
		if (arg0 < field2485) {
			arg2 -= field2485 - arg0;
			arg0 = field2485;
		}
		if (arg0 + arg2 > field2484) {
			arg2 = field2484 - arg0;
		}
		int var5 = 256 - arg4;
		int var6 = (arg3 >> 16 & 0xFF) * arg4;
		int var7 = (arg3 >> 8 & 0xFF) * arg4;
		int var8 = (arg3 & 0xFF) * arg4;
		int var9 = Statics.field2481 * arg1 + arg0;
		for (int var10 = 0; var10 < arg2; var10++) {
			int var11 = (Statics.field2486[var9] >> 16 & 0xFF) * var5;
			int var12 = (Statics.field2486[var9] >> 8 & 0xFF) * var5;
			int var13 = (Statics.field2486[var9] & 0xFF) * var5;
			int var14 = (var8 + var13 >> 8) + (var6 + var11 >> 8 << 16) + (var7 + var12 >> 8 << 8);
			Statics.field2486[var9++] = var14;
		}
	}

	@ObfuscatedName("fv.o(IIII)V")
	public static void method2596(int arg0, int arg1, int arg2, int arg3) {
		if (arg0 < field2485 || arg0 >= field2484) {
			return;
		}
		if (arg1 < field2483) {
			arg2 -= field2483 - arg1;
			arg1 = field2483;
		}
		if (arg1 + arg2 > field2482) {
			arg2 = field2482 - arg1;
		}
		int var4 = Statics.field2481 * arg1 + arg0;
		for (int var5 = 0; var5 < arg2; var5++) {
			Statics.field2486[Statics.field2481 * var5 + var4] = arg3;
		}
	}

	@ObfuscatedName("fv.a(IIIII)V")
	public static void method2597(int arg0, int arg1, int arg2, int arg3, int arg4) {
		if (arg0 < field2485 || arg0 >= field2484) {
			return;
		}
		if (arg1 < field2483) {
			arg2 -= field2483 - arg1;
			arg1 = field2483;
		}
		if (arg1 + arg2 > field2482) {
			arg2 = field2482 - arg1;
		}
		int var5 = 256 - arg4;
		int var6 = (arg3 >> 16 & 0xFF) * arg4;
		int var7 = (arg3 >> 8 & 0xFF) * arg4;
		int var8 = (arg3 & 0xFF) * arg4;
		int var9 = Statics.field2481 * arg1 + arg0;
		for (int var10 = 0; var10 < arg2; var10++) {
			int var11 = (Statics.field2486[var9] >> 16 & 0xFF) * var5;
			int var12 = (Statics.field2486[var9] >> 8 & 0xFF) * var5;
			int var13 = (Statics.field2486[var9] & 0xFF) * var5;
			int var14 = (var8 + var13 >> 8) + (var6 + var11 >> 8 << 16) + (var7 + var12 >> 8 << 8);
			Statics.field2486[var9] = var14;
			var9 += Statics.field2481;
		}
	}

	@ObfuscatedName("fv.h(IIIII)V")
	public static void method2618(int arg0, int arg1, int arg2, int arg3, int arg4) {
		int var5 = arg2 - arg0;
		int var6 = arg3 - arg1;
		if (var6 == 0) {
			if (var5 >= 0) {
				method2594(arg0, arg1, var5 + 1, arg4);
			} else {
				method2594(arg0 + var5, arg1, -var5 + 1, arg4);
			}
		} else if (var5 != 0) {
			if (var5 + var6 < 0) {
				arg0 += var5;
				var5 = -var5;
				arg1 += var6;
				var6 = -var6;
			}
			if (var5 > var6) {
				int var7 = arg1 << 16;
				int var8 = var7 + 32768;
				int var9 = var6 << 16;
				int var10 = (int) Math.floor((double) var9 / (double) var5 + 0.5D);
				int var11 = arg0 + var5;
				if (arg0 < field2485) {
					var8 += (field2485 - arg0) * var10;
					arg0 = field2485;
				}
				if (var11 >= field2484) {
					var11 = field2484 - 1;
				}
				while (arg0 <= var11) {
					int var12 = var8 >> 16;
					if (var12 >= field2483 && var12 < field2482) {
						Statics.field2486[Statics.field2481 * var12 + arg0] = arg4;
					}
					var8 += var10;
					arg0++;
				}
			} else {
				int var13 = arg0 << 16;
				int var14 = var13 + 32768;
				int var15 = var5 << 16;
				int var16 = (int) Math.floor((double) var15 / (double) var6 + 0.5D);
				int var17 = arg1 + var6;
				if (arg1 < field2483) {
					var14 += (field2483 - arg1) * var16;
					arg1 = field2483;
				}
				if (var17 >= field2482) {
					var17 = field2482 - 1;
				}
				while (arg1 <= var17) {
					int var18 = var14 >> 16;
					if (var18 >= field2485 && var18 < field2484) {
						Statics.field2486[Statics.field2481 * arg1 + var18] = arg4;
					}
					var14 += var16;
					arg1++;
				}
			}
		} else if (var6 >= 0) {
			method2596(arg0, arg1, var6 + 1, arg4);
		} else {
			method2596(arg0, arg1 + var6, -var6 + 1, arg4);
		}
	}

	@ObfuscatedName("fv.x(III[I[I)V")
	public static void method2599(int arg0, int arg1, int arg2, int[] arg3, int[] arg4) {
		int var5 = Statics.field2481 * arg1 + arg0;
		for (int var6 = 0; var6 < arg3.length; var6++) {
			int var7 = arg3[var6] + var5;
			for (int var8 = -arg4[var6]; var8 < 0; var8++) {
				Statics.field2486[var7++] = arg2;
			}
			var5 += Statics.field2481;
		}
	}
}
