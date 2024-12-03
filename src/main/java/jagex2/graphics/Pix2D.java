package jagex2.graphics;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;

@ObfuscatedName("fv")
public class Pix2D extends DoublyLinkable {

	@ObfuscatedName("fv.n")
	public static int[] data;

	@ObfuscatedName("fv.j")
	public static int width2d;

	@ObfuscatedName("fv.z")
	public static int height2d;

	@ObfuscatedName("fv.g")
	public static int top = 0;

	@ObfuscatedName("fv.q")
	public static int bottom = 0;

	@ObfuscatedName("fv.i")
	public static int left = 0;

	@ObfuscatedName("fv.s")
	public static int right = 0;

	@ObfuscatedName("fv.z([III)V")
	public static void method2583(int[] arg0, int arg1, int arg2) {
		data = arg0;
		width2d = arg1;
		height2d = arg2;
		method2605(0, 0, arg1, arg2);
	}

	@ObfuscatedName("fv.g()V")
	public static void method2584() {
		left = 0;
		top = 0;
		right = width2d;
		bottom = height2d;
	}

	@ObfuscatedName("fv.q(IIII)V")
	public static void method2605(int arg0, int arg1, int arg2, int arg3) {
		if (arg0 < 0) {
			arg0 = 0;
		}
		if (arg1 < 0) {
			arg1 = 0;
		}
		if (arg2 > width2d) {
			arg2 = width2d;
		}
		if (arg3 > height2d) {
			arg3 = height2d;
		}
		left = arg0;
		top = arg1;
		right = arg2;
		bottom = arg3;
	}

	@ObfuscatedName("fv.i(IIII)V")
	public static void method2586(int arg0, int arg1, int arg2, int arg3) {
		if (left < arg0) {
			left = arg0;
		}
		if (top < arg1) {
			top = arg1;
		}
		if (right > arg2) {
			right = arg2;
		}
		if (bottom > arg3) {
			bottom = arg3;
		}
	}

	@ObfuscatedName("fv.s([I)V")
	public static void method2587(int[] arg0) {
		arg0[0] = left;
		arg0[1] = top;
		arg0[2] = right;
		arg0[3] = bottom;
	}

	@ObfuscatedName("fv.u([I)V")
	public static void method2612(int[] arg0) {
		left = arg0[0];
		top = arg0[1];
		right = arg0[2];
		bottom = arg0[3];
	}

	@ObfuscatedName("fv.v()V")
	public static void method2589() {
		int var0 = 0;
		int var1 = width2d * height2d - 7;
		while (var0 < var1) {
			data[var0++] = 0;
			data[var0++] = 0;
			data[var0++] = 0;
			data[var0++] = 0;
			data[var0++] = 0;
			data[var0++] = 0;
			data[var0++] = 0;
			data[var0++] = 0;
		}
		var1 += 7;
		while (var0 < var1) {
			data[var0++] = 0;
		}
	}

	@ObfuscatedName("fv.w(IIIIII)V")
	public static void method2616(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		if (arg0 < left) {
			arg2 -= left - arg0;
			arg0 = left;
		}
		if (arg1 < top) {
			arg3 -= top - arg1;
			arg1 = top;
		}
		if (arg0 + arg2 > right) {
			arg2 = right - arg0;
		}
		if (arg1 + arg3 > bottom) {
			arg3 = bottom - arg1;
		}
		int var6 = ((arg4 & 0xFF00FF) * arg5 >> 8 & 0xFF00FF) + ((arg4 & 0xFF00) * arg5 >> 8 & 0xFF00);
		int var7 = 256 - arg5;
		int var8 = width2d - arg2;
		int var9 = width2d * arg1 + arg0;
		for (int var10 = 0; var10 < arg3; var10++) {
			for (int var11 = -arg2; var11 < 0; var11++) {
				int var12 = data[var9];
				int var13 = ((var12 & 0xFF00FF) * var7 >> 8 & 0xFF00FF) + ((var12 & 0xFF00) * var7 >> 8 & 0xFF00);
				data[var9++] = var6 + var13;
			}
			var9 += var8;
		}
	}

	@ObfuscatedName("fv.e(IIIII)V")
	public static void method2637(int arg0, int arg1, int arg2, int arg3, int arg4) {
		if (arg0 < left) {
			arg2 -= left - arg0;
			arg0 = left;
		}
		if (arg1 < top) {
			arg3 -= top - arg1;
			arg1 = top;
		}
		if (arg0 + arg2 > right) {
			arg2 = right - arg0;
		}
		if (arg1 + arg3 > bottom) {
			arg3 = bottom - arg1;
		}
		int var5 = width2d - arg2;
		int var6 = width2d * arg1 + arg0;
		for (int var7 = -arg3; var7 < 0; var7++) {
			for (int var8 = -arg2; var8 < 0; var8++) {
				data[var6++] = arg4;
			}
			var6 += var5;
		}
	}

	@ObfuscatedName("fv.b(IIIIII)V")
	public static void method2592(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		int var6 = 0;
		int var7 = 65536 / arg3;
		if (arg0 < left) {
			arg2 -= left - arg0;
			arg0 = left;
		}
		if (arg1 < top) {
			var6 += (top - arg1) * var7;
			arg3 -= top - arg1;
			arg1 = top;
		}
		if (arg0 + arg2 > right) {
			arg2 = right - arg0;
		}
		if (arg1 + arg3 > bottom) {
			arg3 = bottom - arg1;
		}
		int var8 = width2d - arg2;
		int var9 = width2d * arg1 + arg0;
		for (int var10 = -arg3; var10 < 0; var10++) {
			int var11 = 65536 - var6 >> 8;
			int var12 = var6 >> 8;
			int var13 = ((arg4 & 0xFF00FF) * var11 + (arg5 & 0xFF00FF) * var12 & 0xFF00FF00) + ((arg4 & 0xFF00) * var11 + (arg5 & 0xFF00) * var12 & 0xFF0000) >>> 8;
			for (int var14 = -arg2; var14 < 0; var14++) {
				data[var9++] = var13;
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
		if (arg1 < top || arg1 >= bottom) {
			return;
		}
		if (arg0 < left) {
			arg2 -= left - arg0;
			arg0 = left;
		}
		if (arg0 + arg2 > right) {
			arg2 = right - arg0;
		}
		int var4 = width2d * arg1 + arg0;
		for (int var5 = 0; var5 < arg2; var5++) {
			data[var4 + var5] = arg3;
		}
	}

	@ObfuscatedName("fv.k(IIIII)V")
	public static void method2632(int arg0, int arg1, int arg2, int arg3, int arg4) {
		if (arg1 < top || arg1 >= bottom) {
			return;
		}
		if (arg0 < left) {
			arg2 -= left - arg0;
			arg0 = left;
		}
		if (arg0 + arg2 > right) {
			arg2 = right - arg0;
		}
		int var5 = 256 - arg4;
		int var6 = (arg3 >> 16 & 0xFF) * arg4;
		int var7 = (arg3 >> 8 & 0xFF) * arg4;
		int var8 = (arg3 & 0xFF) * arg4;
		int var9 = width2d * arg1 + arg0;
		for (int var10 = 0; var10 < arg2; var10++) {
			int var11 = (data[var9] >> 16 & 0xFF) * var5;
			int var12 = (data[var9] >> 8 & 0xFF) * var5;
			int var13 = (data[var9] & 0xFF) * var5;
			int var14 = (var8 + var13 >> 8) + (var6 + var11 >> 8 << 16) + (var7 + var12 >> 8 << 8);
			data[var9++] = var14;
		}
	}

	@ObfuscatedName("fv.o(IIII)V")
	public static void method2596(int arg0, int arg1, int arg2, int arg3) {
		if (arg0 < left || arg0 >= right) {
			return;
		}
		if (arg1 < top) {
			arg2 -= top - arg1;
			arg1 = top;
		}
		if (arg1 + arg2 > bottom) {
			arg2 = bottom - arg1;
		}
		int var4 = width2d * arg1 + arg0;
		for (int var5 = 0; var5 < arg2; var5++) {
			data[width2d * var5 + var4] = arg3;
		}
	}

	@ObfuscatedName("fv.a(IIIII)V")
	public static void method2597(int arg0, int arg1, int arg2, int arg3, int arg4) {
		if (arg0 < left || arg0 >= right) {
			return;
		}
		if (arg1 < top) {
			arg2 -= top - arg1;
			arg1 = top;
		}
		if (arg1 + arg2 > bottom) {
			arg2 = bottom - arg1;
		}
		int var5 = 256 - arg4;
		int var6 = (arg3 >> 16 & 0xFF) * arg4;
		int var7 = (arg3 >> 8 & 0xFF) * arg4;
		int var8 = (arg3 & 0xFF) * arg4;
		int var9 = width2d * arg1 + arg0;
		for (int var10 = 0; var10 < arg2; var10++) {
			int var11 = (data[var9] >> 16 & 0xFF) * var5;
			int var12 = (data[var9] >> 8 & 0xFF) * var5;
			int var13 = (data[var9] & 0xFF) * var5;
			int var14 = (var8 + var13 >> 8) + (var6 + var11 >> 8 << 16) + (var7 + var12 >> 8 << 8);
			data[var9] = var14;
			var9 += width2d;
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
				if (arg0 < left) {
					var8 += (left - arg0) * var10;
					arg0 = left;
				}
				if (var11 >= right) {
					var11 = right - 1;
				}
				while (arg0 <= var11) {
					int var12 = var8 >> 16;
					if (var12 >= top && var12 < bottom) {
						data[width2d * var12 + arg0] = arg4;
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
				if (arg1 < top) {
					var14 += (top - arg1) * var16;
					arg1 = top;
				}
				if (var17 >= bottom) {
					var17 = bottom - 1;
				}
				while (arg1 <= var17) {
					int var18 = var14 >> 16;
					if (var18 >= left && var18 < right) {
						data[width2d * arg1 + var18] = arg4;
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
		int var5 = width2d * arg1 + arg0;
		for (int var6 = 0; var6 < arg3.length; var6++) {
			int var7 = arg3[var6] + var5;
			for (int var8 = -arg4[var6]; var8 < 0; var8++) {
				data[var7++] = arg2;
			}
			var5 += width2d;
		}
	}
}
