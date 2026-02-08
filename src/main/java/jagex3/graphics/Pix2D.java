package jagex3.graphics;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable2;

// jag::oldscape::graphics::Pix2D
@ObfuscatedName("fv")
public class Pix2D extends Linkable2 {

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

	// jag::oldscape::graphics::Pix2D::SetPixels
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
	public static void setClipping(int x, int y, int w, int h) {
		if (x < 0) {
			x = 0;
		}

		if (y < 0) {
			y = 0;
		}

		if (w > width) {
			w = width;
		}

		if (h > height) {
			h = height;
		}

		clipMinX = x;
		clipMinY = y;
		clipMaxX = w;
		clipMaxY = h;
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

	// jag::oldscape::graphics::NXTPix2D::Cls
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

	// jag::oldscape::graphics::NXTPix2D::FillRectTrans
	@ObfuscatedName("fv.w(IIIIII)V")
	public static void fillRectTrans(int x, int y, int width, int height, int rgb, int alpha) {
		if (x < clipMinX) {
			width -= clipMinX - x;
			x = clipMinX;
		}
		if (y < clipMinY) {
			height -= clipMinY - y;
			y = clipMinY;
		}
		if (x + width > clipMaxX) {
			width = clipMaxX - x;
		}
		if (y + height > clipMaxY) {
			height = clipMaxY - y;
		}
		int var6 = ((rgb & 0xFF00FF) * alpha >> 8 & 0xFF00FF) + ((rgb & 0xFF00) * alpha >> 8 & 0xFF00);
		int var7 = 256 - alpha;
		int var8 = Pix2D.width - width;
		int var9 = Pix2D.width * y + x;
		for (int var10 = 0; var10 < height; var10++) {
			for (int var11 = -width; var11 < 0; var11++) {
				int var12 = pixels[var9];
				int var13 = ((var12 & 0xFF00FF) * var7 >> 8 & 0xFF00FF) + ((var12 & 0xFF00) * var7 >> 8 & 0xFF00);
				pixels[var9++] = var6 + var13;
			}
			var9 += var8;
		}
	}

	// jag::oldscape::graphics::NXTPix2D::FillRect
	@ObfuscatedName("fv.e(IIIII)V")
	public static void fillRect(int x, int y, int width, int height, int rgb) {
		if (x < clipMinX) {
			width -= clipMinX - x;
			x = clipMinX;
		}
		if (y < clipMinY) {
			height -= clipMinY - y;
			y = clipMinY;
		}
		if (x + width > clipMaxX) {
			width = clipMaxX - x;
		}
		if (y + height > clipMaxY) {
			height = clipMaxY - y;
		}
		int var5 = Pix2D.width - width;
		int var6 = Pix2D.width * y + x;
		for (int var7 = -height; var7 < 0; var7++) {
			for (int var8 = -width; var8 < 0; var8++) {
				pixels[var6++] = rgb;
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

	// jag::oldscape::graphics::Pix2D::DrawRect
	@ObfuscatedName("fv.y(IIIII)V")
	public static void drawRect(int x, int y, int w, int h, int rgb) {
		hline(x, y, w, rgb);
		hline(x, y + h - 1, w, rgb);
		vline(x, y, h, rgb);
		vline(x + w - 1, y, h, rgb);
	}

	// jag::oldscape::graphics::Pix2D::DrawRectTrans
	@ObfuscatedName("fv.t(IIIIII)V")
	public static void drawRectTrans(int x, int y, int w, int h, int rgb, int alpha) {
		hlineTrans(x, y, w, rgb, alpha);
		hlineTrans(x, y + h - 1, w, rgb, alpha);
		if (h >= 3) {
			vlineTrans(x, y + 1, h - 2, rgb, alpha);
			vlineTrans(x + w - 1, y + 1, h - 2, rgb, alpha);
		}
	}

	// jag::oldscape::graphics::NXTPix2D::HLine
	@ObfuscatedName("fv.f(IIII)V")
	public static void hline(int x, int y, int width, int rgb) {
		if (y < clipMinY || y >= clipMaxY) {
			return;
		}
		if (x < clipMinX) {
			width -= clipMinX - x;
			x = clipMinX;
		}
		if (x + width > clipMaxX) {
			width = clipMaxX - x;
		}
		int var4 = Pix2D.width * y + x;
		for (int var5 = 0; var5 < width; var5++) {
			pixels[var4 + var5] = rgb;
		}
	}

	// jag::oldscape::graphics::NXTPix2D::HLineTrans
	@ObfuscatedName("fv.k(IIIII)V")
	public static void hlineTrans(int x, int y, int w, int rgb, int alpha) {
		if (y < clipMinY || y >= clipMaxY) {
			return;
		}
		if (x < clipMinX) {
			w -= clipMinX - x;
			x = clipMinX;
		}
		if (x + w > clipMaxX) {
			w = clipMaxX - x;
		}
		int var5 = 256 - alpha;
		int var6 = (rgb >> 16 & 0xFF) * alpha;
		int var7 = (rgb >> 8 & 0xFF) * alpha;
		int var8 = (rgb & 0xFF) * alpha;
		int var9 = width * y + x;
		for (int var10 = 0; var10 < w; var10++) {
			int var11 = (pixels[var9] >> 16 & 0xFF) * var5;
			int var12 = (pixels[var9] >> 8 & 0xFF) * var5;
			int var13 = (pixels[var9] & 0xFF) * var5;
			int var14 = (var8 + var13 >> 8) + (var6 + var11 >> 8 << 16) + (var7 + var12 >> 8 << 8);
			pixels[var9++] = var14;
		}
	}

	// jag::oldscape::graphics::NXTPix2D::VLine
	@ObfuscatedName("fv.o(IIII)V")
	public static void vline(int x, int y, int height, int rgb) {
		if (x < clipMinX || x >= clipMaxX) {
			return;
		}
		if (y < clipMinY) {
			height -= clipMinY - y;
			y = clipMinY;
		}
		if (y + height > clipMaxY) {
			height = clipMaxY - y;
		}
		int var4 = width * y + x;
		for (int var5 = 0; var5 < height; var5++) {
			pixels[width * var5 + var4] = rgb;
		}
	}

	// jag::oldscape::graphics::NXTPix2D::VLineTrans
	@ObfuscatedName("fv.a(IIIII)V")
	public static void vlineTrans(int x, int y, int height, int rgb, int alpha) {
		if (x < clipMinX || x >= clipMaxX) {
			return;
		}
		if (y < clipMinY) {
			height -= clipMinY - y;
			y = clipMinY;
		}
		if (y + height > clipMaxY) {
			height = clipMaxY - y;
		}
		int var5 = 256 - alpha;
		int var6 = (rgb >> 16 & 0xFF) * alpha;
		int var7 = (rgb >> 8 & 0xFF) * alpha;
		int var8 = (rgb & 0xFF) * alpha;
		int var9 = width * y + x;
		for (int var10 = 0; var10 < height; var10++) {
			int var11 = (pixels[var9] >> 16 & 0xFF) * var5;
			int var12 = (pixels[var9] >> 8 & 0xFF) * var5;
			int var13 = (pixels[var9] & 0xFF) * var5;
			int var14 = (var8 + var13 >> 8) + (var6 + var11 >> 8 << 16) + (var7 + var12 >> 8 << 8);
			pixels[var9] = var14;
			var9 += width;
		}
	}

	// jag::oldscape::graphics::NXTPix2D::Line
	@ObfuscatedName("fv.h(IIIII)V")
	public static void line(int x1, int y1, int x2, int y2, int rgb) {
		int dx = x2 - x1;
		int dy = y2 - y1;

		if (dy == 0) {
			if (dx >= 0) {
				hline(x1, y1, dx + 1, rgb);
			} else {
				hline(x1 + dx, y1, -dx + 1, rgb);
			}
		} else if (dx == 0) {
			if (dy >= 0) {
				vline(x1, y1, dy + 1, rgb);
			} else {
				vline(x1, y1 + dy, -dy + 1, rgb);
			}
		} else {
			if (dx + dy < 0) {
				x1 += dx;
				dx = -dx;
				y1 += dy;
				dy = -dy;
			}

			if (dx > dy) {
				int yFine = y1 << 16;
				int yOffset = yFine + 32768;
				int dyFine = dy << 16;
				int yStep = (int) Math.floor((double) dyFine / (double) dx + 0.5D);

				int endX = x1 + dx;
				if (x1 < clipMinX) {
					yOffset += (clipMinX - x1) * yStep;
					x1 = clipMinX;
				}

				if (endX >= clipMaxX) {
					endX = clipMaxX - 1;
				}

				while (x1 <= endX) {
					int drawY = yOffset >> 16;
					if (drawY >= clipMinY && drawY < clipMaxY) {
						pixels[width * drawY + x1] = rgb;
					}

					yOffset += yStep;
					x1++;
				}
			} else {
				int xFine = x1 << 16;
				int xOffset = xFine + 32768;
				int dxFine = dx << 16;
				int xStep = (int) Math.floor((double) dxFine / (double) dy + 0.5D);

				int endY = y1 + dy;
				if (y1 < clipMinY) {
					xOffset += (clipMinY - y1) * xStep;
					y1 = clipMinY;
				}

				if (endY >= clipMaxY) {
					endY = clipMaxY - 1;
				}

				while (y1 <= endY) {
					int drawY = xOffset >> 16;
					if (drawY >= clipMinX && drawY < clipMaxX) {
						pixels[width * y1 + drawY] = rgb;
					}

					xOffset += xStep;
					y1++;
				}
			}
		}
	}

	// jag::oldscape::graphics::Pix2D::FillScanLine
	@ObfuscatedName("fv.x(III[I[I)V")
	public static void fillScanLine(int arg0, int arg1, int arg2, int[] arg3, int[] arg4) {
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
