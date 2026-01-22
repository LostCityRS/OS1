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
	public static int clipMinY = 0;

	@ObfuscatedName("fv.q")
	public static int clipMaxY = 0;

	@ObfuscatedName("fv.i")
	public static int clipMinX = 0;

	@ObfuscatedName("fv.s")
	public static int clipMaxX = 0;

	@ObfuscatedName("fv.z([III)V")
	public static void setPixels(int[] arg0, int arg1, int arg2) {
		pixels = arg0;
		width = arg1;
		height = arg2;
		setClipping(0, 0, arg1, arg2);
	}

	// jag::oldscape::graphics::Pix2D::ResetClipping
	@ObfuscatedName("fv.g()V")
	public static void resetClipping() {
		clipMinX = 0;
		clipMinY = 0;
		clipMaxX = width;
		clipMaxY = height;
	}

	// jag::oldscape::dash3d::Pix2D::SetClipping
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

		clipMinX = arg0;
		clipMinY = arg1;
		clipMaxX = arg2;
		clipMaxY = arg3;
	}

	// jag::oldscape::graphics::Pix2D::SetSubClipping
	@ObfuscatedName("fv.i(IIII)V")
	public static void setSubClipping(int arg0, int arg1, int arg2, int arg3) {
		if (clipMinX < arg0) {
			clipMinX = arg0;
		}

		if (clipMinY < arg1) {
			clipMinY = arg1;
		}

		if (clipMaxX > arg2) {
			clipMaxX = arg2;
		}

		if (clipMaxY > arg3) {
			clipMaxY = arg3;
		}
	}

	// jag::oldscape::graphics::Pix2D::SaveClipping
	@ObfuscatedName("fv.s([I)V")
	public static void saveClipping(int[] dst) {
		dst[0] = clipMinX;
		dst[1] = clipMinY;
		dst[2] = clipMaxX;
		dst[3] = clipMaxY;
	}

	// jag::oldscape::graphics::Pix2D::RestoreClipping
	@ObfuscatedName("fv.u([I)V")
	public static void restoreClipping(int[] src) {
		clipMinX = src[0];
		clipMinY = src[1];
		clipMaxX = src[2];
		clipMaxY = src[3];
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
		if (arg0 < clipMinX) {
			arg2 -= clipMinX - arg0;
			arg0 = clipMinX;
		}
		if (arg1 < clipMinY) {
			arg3 -= clipMinY - arg1;
			arg1 = clipMinY;
		}
		if (arg0 + arg2 > clipMaxX) {
			arg2 = clipMaxX - arg0;
		}
		if (arg1 + arg3 > clipMaxY) {
			arg3 = clipMaxY - arg1;
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
		if (arg0 < clipMinX) {
			arg2 -= clipMinX - arg0;
			arg0 = clipMinX;
		}
		if (arg1 < clipMinY) {
			arg3 -= clipMinY - arg1;
			arg1 = clipMinY;
		}
		if (arg0 + arg2 > clipMaxX) {
			arg2 = clipMaxX - arg0;
		}
		if (arg1 + arg3 > clipMaxY) {
			arg3 = clipMaxY - arg1;
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

	// jag::oldscape::graphics::Pix2D::FillRectVGrad
	@ObfuscatedName("fv.b(IIIIII)V")
	public static void fillRectVGrad(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		int var6 = 0;
		int var7 = 65536 / arg3;
		if (arg0 < clipMinX) {
			arg2 -= clipMinX - arg0;
			arg0 = clipMinX;
		}
		if (arg1 < clipMinY) {
			var6 += (clipMinY - arg1) * var7;
			arg3 -= clipMinY - arg1;
			arg1 = clipMinY;
		}
		if (arg0 + arg2 > clipMaxX) {
			arg2 = clipMaxX - arg0;
		}
		if (arg1 + arg3 > clipMaxY) {
			arg3 = clipMaxY - arg1;
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
		if (arg1 < clipMinY || arg1 >= clipMaxY) {
			return;
		}
		if (arg0 < clipMinX) {
			arg2 -= clipMinX - arg0;
			arg0 = clipMinX;
		}
		if (arg0 + arg2 > clipMaxX) {
			arg2 = clipMaxX - arg0;
		}
		int var4 = width * arg1 + arg0;
		for (int var5 = 0; var5 < arg2; var5++) {
			pixels[var4 + var5] = arg3;
		}
	}

	@ObfuscatedName("fv.k(IIIII)V")
	public static void hlineTrans(int arg0, int arg1, int arg2, int arg3, int arg4) {
		if (arg1 < clipMinY || arg1 >= clipMaxY) {
			return;
		}
		if (arg0 < clipMinX) {
			arg2 -= clipMinX - arg0;
			arg0 = clipMinX;
		}
		if (arg0 + arg2 > clipMaxX) {
			arg2 = clipMaxX - arg0;
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
		if (arg0 < clipMinX || arg0 >= clipMaxX) {
			return;
		}
		if (arg1 < clipMinY) {
			arg2 -= clipMinY - arg1;
			arg1 = clipMinY;
		}
		if (arg1 + arg2 > clipMaxY) {
			arg2 = clipMaxY - arg1;
		}
		int var4 = width * arg1 + arg0;
		for (int var5 = 0; var5 < arg2; var5++) {
			pixels[width * var5 + var4] = arg3;
		}
	}

	@ObfuscatedName("fv.a(IIIII)V")
	public static void vlineTrans(int arg0, int arg1, int arg2, int arg3, int arg4) {
		if (arg0 < clipMinX || arg0 >= clipMaxX) {
			return;
		}
		if (arg1 < clipMinY) {
			arg2 -= clipMinY - arg1;
			arg1 = clipMinY;
		}
		if (arg1 + arg2 > clipMaxY) {
			arg2 = clipMaxY - arg1;
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
				if (arg0 < clipMinX) {
					var8 += (clipMinX - arg0) * var10;
					arg0 = clipMinX;
				}
				if (var11 >= clipMaxX) {
					var11 = clipMaxX - 1;
				}
				while (arg0 <= var11) {
					int var12 = var8 >> 16;
					if (var12 >= clipMinY && var12 < clipMaxY) {
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
				if (arg1 < clipMinY) {
					var14 += (clipMinY - arg1) * var16;
					arg1 = clipMinY;
				}
				if (var17 >= clipMaxY) {
					var17 = clipMaxY - 1;
				}
				while (arg1 <= var17) {
					int var18 = var14 >> 16;
					if (var18 >= clipMinX && var18 < clipMaxX) {
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
