package jagex3.graphics;

import deob.ObfuscatedName;
import jagex3.datastruct.DoublyLinkable;

// jag::oldscape::graphics::Pix2D
@ObfuscatedName("fv")
public class Pix2D extends DoublyLinkable {

	@ObfuscatedName("fv.n")
	public static int[] pixels;

	@ObfuscatedName("fv.j")
	public static int width;

	@ObfuscatedName("fv.z")
	public static int height;

	@ObfuscatedName("fv.g")
	public static int top = 0;

	@ObfuscatedName("fv.q")
	public static int bottom = 0;

	@ObfuscatedName("fv.i")
	public static int left = 0;

	@ObfuscatedName("fv.s")
	public static int right = 0;

	@ObfuscatedName("fv.z([III)V")
	public static void setPixels(int[] arg0, int arg1, int arg2) {
		pixels = arg0;
		width = arg1;
		height = arg2;
		setClipping(0, 0, arg1, arg2);
	}

	@ObfuscatedName("fv.g()V")
	public static void resetClipping() {
		left = 0;
		top = 0;
		right = width;
		bottom = height;
	}

	@ObfuscatedName("fv.q(IIII)V")
	public static void setClipping(int arg0, int arg1, int arg2, int arg3) {
		if (arg0 < 0) {
			arg0 = 0;
		}
		if (arg1 < 0) {
			arg1 = 0;
		}
		if (arg2 > width) {
			arg2 = width;
		}
		if (arg3 > height) {
			arg3 = height;
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
	public static void saveClipping(int[] arg0) {
		arg0[0] = left;
		arg0[1] = top;
		arg0[2] = right;
		arg0[3] = bottom;
	}

	@ObfuscatedName("fv.u([I)V")
	public static void loadClipping(int[] arg0) {
		left = arg0[0];
		top = arg0[1];
		right = arg0[2];
		bottom = arg0[3];
	}

	@ObfuscatedName("fv.v()V")
	public static void cls() {
		int var0 = 0;
		int var1 = width * height - 7;
		while (var0 < var1) {
			pixels[var0++] = 0;
			pixels[var0++] = 0;
			pixels[var0++] = 0;
			pixels[var0++] = 0;
			pixels[var0++] = 0;
			pixels[var0++] = 0;
			pixels[var0++] = 0;
			pixels[var0++] = 0;
		}
		var1 += 7;
		while (var0 < var1) {
			pixels[var0++] = 0;
		}
	}

	@ObfuscatedName("fv.w(IIIIII)V")
	public static void fillRectTrans(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
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
		int var8 = width - arg2;
		int var9 = width * arg1 + arg0;
		for (int var10 = 0; var10 < arg3; var10++) {
			for (int var11 = -arg2; var11 < 0; var11++) {
				int var12 = pixels[var9];
				int var13 = ((var12 & 0xFF00FF) * var7 >> 8 & 0xFF00FF) + ((var12 & 0xFF00) * var7 >> 8 & 0xFF00);
				pixels[var9++] = var6 + var13;
			}
			var9 += var8;
		}
	}

	@ObfuscatedName("fv.e(IIIII)V")
	public static void fillRect(int arg0, int arg1, int arg2, int arg3, int arg4) {
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
		int var5 = width - arg2;
		int var6 = width * arg1 + arg0;
		for (int var7 = -arg3; var7 < 0; var7++) {
			for (int var8 = -arg2; var8 < 0; var8++) {
				pixels[var6++] = arg4;
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
		int var8 = width - arg2;
		int var9 = width * arg1 + arg0;
		for (int var10 = -arg3; var10 < 0; var10++) {
			int var11 = 65536 - var6 >> 8;
			int var12 = var6 >> 8;
			int var13 = ((arg4 & 0xFF00FF) * var11 + (arg5 & 0xFF00FF) * var12 & 0xFF00FF00) + ((arg4 & 0xFF00) * var11 + (arg5 & 0xFF00) * var12 & 0xFF0000) >>> 8;
			for (int var14 = -arg2; var14 < 0; var14++) {
				pixels[var9++] = var13;
			}
			var9 += var8;
			var6 += var7;
		}
	}

	@ObfuscatedName("fv.y(IIIII)V")
	public static void drawRect(int arg0, int arg1, int arg2, int arg3, int arg4) {
		hline(arg0, arg1, arg2, arg4);
		hline(arg0, arg1 + arg3 - 1, arg2, arg4);
		vline(arg0, arg1, arg3, arg4);
		vline(arg0 + arg2 - 1, arg1, arg3, arg4);
	}

	@ObfuscatedName("fv.t(IIIIII)V")
	public static void drawRectTrans(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		hlineTrans(arg0, arg1, arg2, arg4, arg5);
		hlineTrans(arg0, arg1 + arg3 - 1, arg2, arg4, arg5);
		if (arg3 >= 3) {
			vlineTrans(arg0, arg1 + 1, arg3 - 2, arg4, arg5);
			vlineTrans(arg0 + arg2 - 1, arg1 + 1, arg3 - 2, arg4, arg5);
		}
	}

	@ObfuscatedName("fv.f(IIII)V")
	public static void hline(int arg0, int arg1, int arg2, int arg3) {
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
		int var4 = width * arg1 + arg0;
		for (int var5 = 0; var5 < arg2; var5++) {
			pixels[var4 + var5] = arg3;
		}
	}

	@ObfuscatedName("fv.k(IIIII)V")
	public static void hlineTrans(int arg0, int arg1, int arg2, int arg3, int arg4) {
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
		int var9 = width * arg1 + arg0;
		for (int var10 = 0; var10 < arg2; var10++) {
			int var11 = (pixels[var9] >> 16 & 0xFF) * var5;
			int var12 = (pixels[var9] >> 8 & 0xFF) * var5;
			int var13 = (pixels[var9] & 0xFF) * var5;
			int var14 = (var8 + var13 >> 8) + (var6 + var11 >> 8 << 16) + (var7 + var12 >> 8 << 8);
			pixels[var9++] = var14;
		}
	}

	@ObfuscatedName("fv.o(IIII)V")
	public static void vline(int arg0, int arg1, int arg2, int arg3) {
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
		int var4 = width * arg1 + arg0;
		for (int var5 = 0; var5 < arg2; var5++) {
			pixels[width * var5 + var4] = arg3;
		}
	}

	@ObfuscatedName("fv.a(IIIII)V")
	public static void vlineTrans(int arg0, int arg1, int arg2, int arg3, int arg4) {
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
		int var9 = width * arg1 + arg0;
		for (int var10 = 0; var10 < arg2; var10++) {
			int var11 = (pixels[var9] >> 16 & 0xFF) * var5;
			int var12 = (pixels[var9] >> 8 & 0xFF) * var5;
			int var13 = (pixels[var9] & 0xFF) * var5;
			int var14 = (var8 + var13 >> 8) + (var6 + var11 >> 8 << 16) + (var7 + var12 >> 8 << 8);
			pixels[var9] = var14;
			var9 += width;
		}
	}

	@ObfuscatedName("fv.h(IIIII)V")
	public static void method2618(int arg0, int arg1, int arg2, int arg3, int arg4) {
		int var5 = arg2 - arg0;
		int var6 = arg3 - arg1;
		if (var6 == 0) {
			if (var5 >= 0) {
				hline(arg0, arg1, var5 + 1, arg4);
			} else {
				hline(arg0 + var5, arg1, -var5 + 1, arg4);
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
						pixels[width * var12 + arg0] = arg4;
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
						pixels[width * arg1 + var18] = arg4;
					}
					var14 += var16;
					arg1++;
				}
			}
		} else if (var6 >= 0) {
			vline(arg0, arg1, var6 + 1, arg4);
		} else {
			vline(arg0, arg1 + var6, -var6 + 1, arg4);
		}
	}

	@ObfuscatedName("fv.x(III[I[I)V")
	public static void method2599(int arg0, int arg1, int arg2, int[] arg3, int[] arg4) {
		int var5 = width * arg1 + arg0;
		for (int var6 = 0; var6 < arg3.length; var6++) {
			int var7 = arg3[var6] + var5;
			for (int var8 = -arg4[var6]; var8 < 0; var8++) {
				pixels[var7++] = arg2;
			}
			var5 += width;
		}
	}
}
