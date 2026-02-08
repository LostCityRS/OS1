package jagex3.graphics;

import deob.ObfuscatedName;

import java.awt.*;
import java.awt.image.PixelGrabber;

// jag::oldscape::graphics::Pix32
@ObfuscatedName("fq")
public class Pix32 extends Pix2D {

	@ObfuscatedName("fq.u")
	public int[] data;

	@ObfuscatedName("fq.v")
	public int wi;

	@ObfuscatedName("fq.w")
	public int hi;

	@ObfuscatedName("fq.e")
	public int xof;

	@ObfuscatedName("fq.b")
	public int yof;

	@ObfuscatedName("fq.y")
	public int owi;

	@ObfuscatedName("fq.t")
	public int ohi;

	public Pix32() {
	}

	public Pix32(int arg0, int arg1) {
		this.data = new int[arg0 * arg1];
		this.wi = this.owi = arg0;
		this.hi = this.ohi = arg1;
		this.yof = 0;
		this.xof = 0;
	}

	public Pix32(byte[] arg0, Component arg1) {
		try {
			Image var3 = Toolkit.getDefaultToolkit().createImage(arg0);
			MediaTracker var4 = new MediaTracker(arg1);
			var4.addImage(var3, 0);
			var4.waitForAll();
			this.wi = var3.getWidth(arg1);
			this.hi = var3.getHeight(arg1);
			this.owi = this.wi;
			this.ohi = this.hi;
			this.xof = 0;
			this.yof = 0;
			this.data = new int[this.wi * this.hi];
			PixelGrabber var5 = new PixelGrabber(var3, 0, 0, this.wi, this.hi, this.data, 0, this.wi);
			var5.grabPixels();
		} catch (InterruptedException ignore) {
		}
	}

	// jag::oldscape::graphics::Pix32::CopyHFlip
	@ObfuscatedName("fq.bm()Lfq;")
	public Pix32 copyHFlip() {
		Pix32 var1 = new Pix32(this.wi, this.hi);
		var1.owi = this.owi;
		var1.ohi = this.ohi;
		var1.xof = this.owi - this.wi - this.xof;
		var1.yof = this.yof;
		for (int var2 = 0; var2 < this.hi; var2++) {
			for (int var3 = 0; var3 < this.wi; var3++) {
				var1.data[this.wi * var2 + var3] = this.data[this.wi * var2 + this.wi - 1 - var3];
			}
		}
		return var1;
	}

	@ObfuscatedName("fq.bn()V")
	public void setPixels() {
		setPixels(this.data, this.wi, this.hi);
	}

	// jag::oldscape::graphics::Pix32::RgbAdjust
	@ObfuscatedName("fq.be(III)V")
	public void rgbAdjust(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < this.data.length; var4++) {
			int var5 = this.data[var4];
			if (var5 != 0) {
				int var6 = var5 >> 16 & 0xFF;
				int var7 = arg0 + var6;
				if (var7 < 1) {
					var7 = 1;
				} else if (var7 > 255) {
					var7 = 255;
				}
				int var8 = var5 >> 8 & 0xFF;
				int var9 = arg1 + var8;
				if (var9 < 1) {
					var9 = 1;
				} else if (var9 > 255) {
					var9 = 255;
				}
				int var10 = var5 & 0xFF;
				int var11 = arg2 + var10;
				if (var11 < 1) {
					var11 = 1;
				} else if (var11 > 255) {
					var11 = 255;
				}
				this.data[var4] = (var7 << 16) + (var9 << 8) + var11;
			}
		}
	}

	// jag::oldscape::graphics::Pix32::Trim
	@ObfuscatedName("fq.bp()V")
	public void trim() {
		if (this.wi == this.owi && this.ohi == this.hi) {
			return;
		}
		int[] var1 = new int[this.ohi * this.owi];
		for (int var2 = 0; var2 < this.hi; var2++) {
			for (int var3 = 0; var3 < this.wi; var3++) {
				var1[(this.yof + var2) * this.owi + this.xof + var3] = this.data[this.wi * var2 + var3];
			}
		}
		this.data = var1;
		this.wi = this.owi;
		this.hi = this.ohi;
		this.xof = 0;
		this.yof = 0;
	}

	// jag::oldscape::graphics::Pix32::Untrim
	@ObfuscatedName("fq.ba(I)V")
	public void untrim(int arg0) {
		if (this.wi == this.owi && this.ohi == this.hi) {
			return;
		}
		int var2 = arg0;
		if (arg0 > this.xof) {
			var2 = this.xof;
		}
		int var3 = arg0;
		if (this.xof + arg0 + this.wi > this.owi) {
			var3 = this.owi - this.xof - this.wi;
		}
		int var4 = arg0;
		if (arg0 > this.yof) {
			var4 = this.yof;
		}
		int var5 = arg0;
		if (this.yof + arg0 + this.hi > this.ohi) {
			var5 = this.ohi - this.yof - this.hi;
		}
		int var6 = this.wi + var2 + var3;
		int var7 = this.hi + var4 + var5;
		int[] var8 = new int[var6 * var7];
		for (int var9 = 0; var9 < this.hi; var9++) {
			for (int var10 = 0; var10 < this.wi; var10++) {
				var8[(var4 + var9) * var6 + var2 + var10] = this.data[this.wi * var9 + var10];
			}
		}
		this.data = var8;
		this.wi = var6;
		this.hi = var7;
		this.xof -= var2;
		this.yof -= var4;
	}

	// ag::oldscape::graphics::Pix32::HFlip
	@ObfuscatedName("fq.bc()V")
	public void hflip() {
		int[] var1 = new int[this.wi * this.hi];
		int var2 = 0;
		for (int var3 = 0; var3 < this.hi; var3++) {
			for (int var4 = this.wi - 1; var4 >= 0; var4--) {
				var1[var2++] = this.data[this.wi * var3 + var4];
			}
		}
		this.data = var1;
		this.xof = this.owi - this.wi - this.xof;
	}

	// ag::oldscape::graphics::Pix32::VFlip
	@ObfuscatedName("fq.br()V")
	public void vflip() {
		int[] var1 = new int[this.wi * this.hi];
		int var2 = 0;
		for (int var3 = this.hi - 1; var3 >= 0; var3--) {
			for (int var4 = 0; var4 < this.wi; var4++) {
				var1[var2++] = this.data[this.wi * var3 + var4];
			}
		}
		this.data = var1;
		this.yof = this.ohi - this.hi - this.yof;
	}

	// jag::oldscape::graphics::Pix32::AddOutline
	@ObfuscatedName("fq.bb(I)V")
	public void addOutline(int arg0) {
		int[] var2 = new int[this.wi * this.hi];
		int var3 = 0;
		for (int var4 = 0; var4 < this.hi; var4++) {
			for (int var5 = 0; var5 < this.wi; var5++) {
				int var6 = this.data[var3];
				if (var6 == 0) {
					if (var5 > 0 && this.data[var3 - 1] != 0) {
						var6 = arg0;
					} else if (var4 > 0 && this.data[var3 - this.wi] != 0) {
						var6 = arg0;
					} else if (var5 < this.wi - 1 && this.data[var3 + 1] != 0) {
						var6 = arg0;
					} else if (var4 < this.hi - 1 && this.data[this.wi + var3] != 0) {
						var6 = arg0;
					}
				}
				var2[var3++] = var6;
			}
		}
		this.data = var2;
	}

	// jag::oldscape::graphics::Pix32::AddShadow
	@ObfuscatedName("fq.bd(I)V")
	public void addShadow(int arg0) {
		for (int var2 = this.hi - 1; var2 > 0; var2--) {
			int var3 = this.wi * var2;
			for (int var4 = this.wi - 1; var4 > 0; var4--) {
				if (this.data[var3 + var4] == 0 && this.data[var3 + var4 - 1 - this.wi] != 0) {
					this.data[var3 + var4] = arg0;
				}
			}
		}
	}

	// jag::oldscape::graphics::NXTPix2D::QuickPlotSprite
	@ObfuscatedName("fq.cr(II)V")
	public void quickPlotSprite(int x, int y) {
		int var3 = this.xof + x;
		int var4 = this.yof + y;
		int var5 = Pix2D.width * var4 + var3;
		int var6 = 0;
		int var7 = this.hi;
		int var8 = this.wi;
		int var9 = Pix2D.width - var8;
		int var10 = 0;
		if (var4 < clipMinY) {
			int var11 = clipMinY - var4;
			var7 -= var11;
			var4 = clipMinY;
			var6 += var8 * var11;
			var5 += Pix2D.width * var11;
		}
		if (var4 + var7 > clipMaxY) {
			var7 -= var4 + var7 - clipMaxY;
		}
		if (var3 < clipMinX) {
			int var12 = clipMinX - var3;
			var8 -= var12;
			var3 = clipMinX;
			var6 += var12;
			var5 += var12;
			var10 += var12;
			var9 += var12;
		}
		if (var3 + var8 > clipMaxX) {
			int var13 = var3 + var8 - clipMaxX;
			var8 -= var13;
			var10 += var13;
			var9 += var13;
		}
		if (var8 > 0 && var7 > 0) {
			plotQuick(Pix2D.pixels, this.data, var6, var5, var8, var7, var9, var10);
		}
	}

	// jag::oldscape::graphics::NXTPix2D::PlotQuick
	@ObfuscatedName("fq.cs([I[IIIIIII)V")
	public static void plotQuick(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		for (int var8 = -arg5; var8 < 0; var8++) {
			int var9 = arg3 + arg4 - 3;
			while (arg3 < var9) {
				arg0[arg3++] = arg1[arg2++];
				arg0[arg3++] = arg1[arg2++];
				arg0[arg3++] = arg1[arg2++];
				arg0[arg3++] = arg1[arg2++];
			}
			var9 += 3;
			while (arg3 < var9) {
				arg0[arg3++] = arg1[arg2++];
			}
			arg3 += arg6;
			arg2 += arg7;
		}
	}

	// jag::oldscape::graphics::NXTPix2D::PlotSprite
	@ObfuscatedName("fq.cj(II)V")
	public void plotSprite(int arg0, int arg1) {
		int var3 = this.xof + arg0;
		int var4 = this.yof + arg1;
		int var5 = Pix2D.width * var4 + var3;
		int var6 = 0;
		int var7 = this.hi;
		int var8 = this.wi;
		int var9 = Pix2D.width - var8;
		int var10 = 0;
		if (var4 < clipMinY) {
			int var11 = clipMinY - var4;
			var7 -= var11;
			var4 = clipMinY;
			var6 += var8 * var11;
			var5 += Pix2D.width * var11;
		}
		if (var4 + var7 > clipMaxY) {
			var7 -= var4 + var7 - clipMaxY;
		}
		if (var3 < clipMinX) {
			int var12 = clipMinX - var3;
			var8 -= var12;
			var3 = clipMinX;
			var6 += var12;
			var5 += var12;
			var10 += var12;
			var9 += var12;
		}
		if (var3 + var8 > clipMaxX) {
			int var13 = var3 + var8 - clipMaxX;
			var8 -= var13;
			var10 += var13;
			var9 += var13;
		}
		if (var8 > 0 && var7 > 0) {
			plotSprite(Pix2D.pixels, this.data, 0, var6, var5, var8, var7, var9, var10);
		}
	}

	// jag::oldscape::graphics::NXTPix2D::PlotSprite
	@ObfuscatedName("fq.cl([I[IIIIIIII)V")
	public static void plotSprite(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
		int var9 = -(arg5 >> 2);
		int var10 = -(arg5 & 0x3);
		for (int var11 = -arg6; var11 < 0; var11++) {
			for (int var12 = var9; var12 < 0; var12++) {
				int var13 = arg1[arg3++];
				if (var13 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = var13;
				}
				int var14 = arg1[arg3++];
				if (var14 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = var14;
				}
				int var15 = arg1[arg3++];
				if (var15 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = var15;
				}
				int var16 = arg1[arg3++];
				if (var16 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = var16;
				}
			}
			for (int var17 = var10; var17 < 0; var17++) {
				int var18 = arg1[arg3++];
				if (var18 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = var18;
				}
			}
			arg4 += arg7;
			arg3 += arg8;
		}
	}

	// jag::oldscape::graphics::NXTPix2D::ScalePlotSprite
	@ObfuscatedName("fq.cp(IIII)V")
	public void scalePlotSprite(int arg0, int arg1, int arg2, int arg3) {
		if (arg2 <= 0 || arg3 <= 0) {
			return;
		}
		int var5 = this.wi;
		int var6 = this.hi;
		int var7 = 0;
		int var8 = 0;
		int var9 = this.owi;
		int var10 = this.ohi;
		int var11 = (var9 << 16) / arg2;
		int var12 = (var10 << 16) / arg3;
		if (this.xof > 0) {
			int var13 = ((this.xof << 16) + var11 - 1) / var11;
			arg0 += var13;
			var7 += var11 * var13 - (this.xof << 16);
		}
		if (this.yof > 0) {
			int var14 = ((this.yof << 16) + var12 - 1) / var12;
			arg1 += var14;
			var8 += var12 * var14 - (this.yof << 16);
		}
		if (var5 < var9) {
			arg2 = ((var5 << 16) - var7 + var11 - 1) / var11;
		}
		if (var6 < var10) {
			arg3 = ((var6 << 16) - var8 + var12 - 1) / var12;
		}
		int var15 = Pix2D.width * arg1 + arg0;
		int var16 = Pix2D.width - arg2;
		if (arg1 + arg3 > clipMaxY) {
			arg3 -= arg1 + arg3 - clipMaxY;
		}
		if (arg1 < clipMinY) {
			int var17 = clipMinY - arg1;
			arg3 -= var17;
			var15 += Pix2D.width * var17;
			var8 += var12 * var17;
		}
		if (arg0 + arg2 > clipMaxX) {
			int var18 = arg0 + arg2 - clipMaxX;
			arg2 -= var18;
			var16 += var18;
		}
		if (arg0 < clipMinX) {
			int var19 = clipMinX - arg0;
			arg2 -= var19;
			var15 += var19;
			var7 += var11 * var19;
			var16 += var19;
		}
		plotScale(Pix2D.pixels, this.data, 0, var7, var8, var15, var16, arg2, arg3, var11, var12, var5);
	}

	// jag::oldscape::graphics::NXTPix2D::PlotScale
	@ObfuscatedName("fq.ca([I[IIIIIIIIIII)V")
	public static void plotScale(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
		int var12 = arg3;
		for (int var13 = -arg8; var13 < 0; var13++) {
			int var14 = (arg4 >> 16) * arg11;
			for (int var15 = -arg7; var15 < 0; var15++) {
				int var16 = arg1[(arg3 >> 16) + var14];
				if (var16 == 0) {
					arg5++;
				} else {
					arg0[arg5++] = var16;
				}
				arg3 += arg9;
			}
			arg4 += arg10;
			arg3 = var12;
			arg5 += arg6;
		}
	}

	// jag::oldscape::graphics::NXTPix2D::LitPlotSprite
	@ObfuscatedName("fq.co(IIII)V")
	public void litPlotSprite(int arg0, int arg1, int arg2, int arg3) {
		if (arg2 == 256) {
			this.plotSprite(arg0, arg1);
			return;
		}
		int var5 = this.xof + arg0;
		int var6 = this.yof + arg1;
		int var7 = Pix2D.width * var6 + var5;
		int var8 = 0;
		int var9 = this.hi;
		int var10 = this.wi;
		int var11 = Pix2D.width - var10;
		int var12 = 0;
		if (var6 < clipMinY) {
			int var13 = clipMinY - var6;
			var9 -= var13;
			var6 = clipMinY;
			var8 += var10 * var13;
			var7 += Pix2D.width * var13;
		}
		if (var6 + var9 > clipMaxY) {
			var9 -= var6 + var9 - clipMaxY;
		}
		if (var5 < clipMinX) {
			int var14 = clipMinX - var5;
			var10 -= var14;
			var5 = clipMinX;
			var8 += var14;
			var7 += var14;
			var12 += var14;
			var11 += var14;
		}
		if (var5 + var10 > clipMaxX) {
			int var15 = var5 + var10 - clipMaxX;
			var10 -= var15;
			var12 += var15;
			var11 += var15;
		}
		if (var10 > 0 && var9 > 0) {
			litSprite(Pix2D.pixels, this.data, 0, var8, var7, var10, var9, var11, var12, arg2, arg3);
		}
	}

	// jag::oldscape::graphics::NXTPix2D::LitSprite
	@ObfuscatedName("fq.ch([I[IIIIIIIIII)V")
	public static void litSprite(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
		int var11 = 256 - arg9;
		int var12 = (arg10 & 0xFF00FF) * var11 & 0xFF00FF00;
		int var13 = (arg10 & 0xFF00) * var11 & 0xFF0000;
		int var14 = (var12 | var13) >>> 8;
		for (int var15 = -arg6; var15 < 0; var15++) {
			for (int var16 = -arg5; var16 < 0; var16++) {
				int var17 = arg1[arg3++];
				if (var17 == 0) {
					arg4++;
				} else {
					int var18 = (var17 & 0xFF00FF) * arg9 & 0xFF00FF00;
					int var19 = (var17 & 0xFF00) * arg9 & 0xFF0000;
					arg0[arg4++] = ((var18 | var19) >>> 8) + var14;
				}
			}
			arg4 += arg7;
			arg3 += arg8;
		}
	}

	// jag::oldscape::graphics::NXTPix2D::TransPlotSprite
	@ObfuscatedName("fq.cu(III)V")
	public void transPlotSprite(int x, int y, int alpha) {
		int var4 = this.xof + x;
		int var5 = this.yof + y;
		int var6 = Pix2D.width * var5 + var4;
		int var7 = 0;
		int h = this.hi;
		int w = this.wi;
		int dstOff = Pix2D.width - w;
		int srcOff = 0;
		if (var5 < clipMinY) {
			int var12 = clipMinY - var5;
			h -= var12;
			var5 = clipMinY;
			var7 += w * var12;
			var6 += Pix2D.width * var12;
		}
		if (var5 + h > clipMaxY) {
			h -= var5 + h - clipMaxY;
		}
		if (var4 < clipMinX) {
			int var13 = clipMinX - var4;
			w -= var13;
			var4 = clipMinX;
			var7 += var13;
			var6 += var13;
			srcOff += var13;
			dstOff += var13;
		}
		if (var4 + w > clipMaxX) {
			int cutoff = var4 + w - clipMaxX;
			w -= cutoff;
			srcOff += cutoff;
			dstOff += cutoff;
		}
		if (w > 0 && h > 0) {
			tranSprite(Pix2D.pixels, this.data, 0, var7, var6, w, h, dstOff, srcOff, alpha);
		}
	}

	// jag::oldscape::graphics::NXTPix2D::TranSprite
	@ObfuscatedName("fq.cc([I[IIIIIIIII)V")
	public static void tranSprite(int[] dst, int[] src, int arg2, int srcOff, int dstOff, int w, int h, int dstStep, int srcStep, int alpha) {
		int var10 = 256 - alpha;
		for (int var11 = -h; var11 < 0; var11++) {
			for (int var12 = -w; var12 < 0; var12++) {
				int var13 = src[srcOff++];
				if (var13 == 0) {
					dstOff++;
				} else {
					int var14 = dst[dstOff];
					dst[dstOff++] = ((var13 & 0xFF00FF) * alpha + (var14 & 0xFF00FF) * var10 & 0xFF00FF00) + ((var13 & 0xFF00) * alpha + (var14 & 0xFF00) * var10 & 0xFF0000) >> 8;
				}
			}
			dstOff += dstStep;
			srcOff += srcStep;
		}
	}

	// jag::oldscape::graphics::NXTPix2D::TransScalePlotSprite
	@ObfuscatedName("fq.cm(IIIII)V")
	public void transScalePlotSprite(int arg0, int arg1, int arg2, int arg3, int arg4) {
		if (arg2 <= 0 || arg3 <= 0) {
			return;
		}
		int var6 = this.wi;
		int var7 = this.hi;
		int var8 = 0;
		int var9 = 0;
		int var10 = this.owi;
		int var11 = this.ohi;
		int var12 = (var10 << 16) / arg2;
		int var13 = (var11 << 16) / arg3;
		if (this.xof > 0) {
			int var14 = ((this.xof << 16) + var12 - 1) / var12;
			arg0 += var14;
			var8 += var12 * var14 - (this.xof << 16);
		}
		if (this.yof > 0) {
			int var15 = ((this.yof << 16) + var13 - 1) / var13;
			arg1 += var15;
			var9 += var13 * var15 - (this.yof << 16);
		}
		if (var6 < var10) {
			arg2 = ((var6 << 16) - var8 + var12 - 1) / var12;
		}
		if (var7 < var11) {
			arg3 = ((var7 << 16) - var9 + var13 - 1) / var13;
		}
		int var16 = Pix2D.width * arg1 + arg0;
		int var17 = Pix2D.width - arg2;
		if (arg1 + arg3 > clipMaxY) {
			arg3 -= arg1 + arg3 - clipMaxY;
		}
		if (arg1 < clipMinY) {
			int var18 = clipMinY - arg1;
			arg3 -= var18;
			var16 += Pix2D.width * var18;
			var9 += var13 * var18;
		}
		if (arg0 + arg2 > clipMaxX) {
			int var19 = arg0 + arg2 - clipMaxX;
			arg2 -= var19;
			var17 += var19;
		}
		if (arg0 < clipMinX) {
			int var20 = clipMinX - arg0;
			arg2 -= var20;
			var16 += var20;
			var8 += var12 * var20;
			var17 += var20;
		}
		tranScale(Pix2D.pixels, this.data, 0, var8, var9, var16, var17, arg2, arg3, var12, var13, var6, arg4);
	}

	// jag::oldscape::graphics::NXTPix2D::TranScale
	@ObfuscatedName("fq.cw([I[IIIIIIIIIIII)V")
	public static void tranScale(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12) {
		int var13 = 256 - arg12;
		int var14 = arg3;
		for (int var15 = -arg8; var15 < 0; var15++) {
			int var16 = (arg4 >> 16) * arg11;
			for (int var17 = -arg7; var17 < 0; var17++) {
				int var18 = arg1[(arg3 >> 16) + var16];
				if (var18 == 0) {
					arg5++;
				} else {
					int var19 = arg0[arg5];
					arg0[arg5++] = ((var18 & 0xFF00FF) * arg12 + (var19 & 0xFF00FF) * var13 & 0xFF00FF00) + ((var18 & 0xFF00) * arg12 + (var19 & 0xFF00) * var13 & 0xFF0000) >> 8;
				}
				arg3 += arg9;
			}
			arg4 += arg10;
			arg3 = var14;
			arg5 += arg6;
		}
	}

	// jag::oldscape::graphics::NXTPix2D::ScanlineRotatePlotSprite
	@ObfuscatedName("fq.cz(IIIIIIII[I[I)V")
	public void scanlineRotatePlotSprite(int x, int y, int w, int h, int anchorX, int anchorY, int theta, int zoom, int[] lineStart, int[] lineWidth) {
		try {
			int var11 = -w / 2;
			int var12 = -h / 2;
			int var13 = (int) (Math.sin((double) theta / 326.11D) * 65536.0D);
			int var14 = (int) (Math.cos((double) theta / 326.11D) * 65536.0D);
			int var15 = zoom * var13 >> 8;
			int var16 = zoom * var14 >> 8;
			int var17 = (anchorX << 16) + var11 * var16 + var12 * var15;
			int var18 = (anchorY << 16) + (var12 * var16 - var11 * var15);
			int var19 = Pix2D.width * y + x;
			for (int var20 = 0; var20 < h; var20++) {
				int var21 = lineStart[var20];
				int var22 = var19 + var21;
				int var23 = var16 * var21 + var17;
				int var24 = var18 - var15 * var21;
				for (int var25 = -lineWidth[var20]; var25 < 0; var25++) {
					Pix2D.pixels[var22++] = this.data[(var23 >> 16) + (var24 >> 16) * this.wi];
					var23 += var16;
					var24 -= var15;
				}
				var17 += var15;
				var18 += var16;
				var19 += Pix2D.width;
			}
		} catch (Exception var27) {
		}
	}

	// jag::oldscape::graphics::NXTPix2D::RotateTransPlotSprite
	@ObfuscatedName("fq.cv(IIIIIIDI)V")
	public void rotateTransPlotSprite(int x, int y, int w, int h, int anchorX, int anchorY, double theta, int zoom) {
		try {
			int var10 = -w / 2;
			int var11 = -h / 2;
			int var12 = (int) (Math.sin(theta) * 65536.0D);
			int var13 = (int) (Math.cos(theta) * 65536.0D);
			int var14 = zoom * var12 >> 8;
			int var15 = zoom * var13 >> 8;
			int var16 = (anchorX << 16) + var10 * var15 + var11 * var14;
			int var17 = (anchorY << 16) + (var11 * var15 - var10 * var14);
			int var18 = Pix2D.width * y + x;
			for (int var19 = 0; var19 < h; var19++) {
				int var20 = var18;
				int var21 = var16;
				int var22 = var17;
				for (int var23 = -w; var23 < 0; var23++) {
					int var24 = this.data[(var21 >> 16) + (var22 >> 16) * this.wi];
					if (var24 == 0) {
						var20++;
					} else {
						Pix2D.pixels[var20++] = var24;
					}
					var21 += var15;
					var22 -= var14;
				}
				var16 += var14;
				var17 += var15;
				var18 += Pix2D.width;
			}
		} catch (Exception var26) {
		}
	}

	// jag::oldscape::graphics::Pix2D::PixelPerfectRotateScalePlotSprite
	@ObfuscatedName("fq.ct(IIII)V")
	public void pixelPerfectRotateScalePlotSprite(int arg0, int arg1, int arg2, int arg3) {
		this.pixelPerfectRotateScalePlotSprite(this.owi << 3, this.ohi << 3, arg0 << 4, arg1 << 4, arg2, arg3);
	}

	// jag::oldscape::graphics::NXTPix2D::PixelPerfectRotateScalePlotSprite
	@ObfuscatedName("fq.ck(IIIIII)V")
	public void pixelPerfectRotateScalePlotSprite(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		if (arg5 == 0) {
			return;
		}
		int var7 = arg0 - (this.xof << 4);
		int var8 = arg1 - (this.yof << 4);
		double var9 = (double) (arg4 & 0xFFFF) * 9.587379924285257E-5D;
		int var11 = (int) Math.floor(Math.sin(var9) * (double) arg5 + 0.5D);
		int var12 = (int) Math.floor(Math.cos(var9) * (double) arg5 + 0.5D);
		int var13 = -var7 * var12 + -var8 * var11;
		int var14 = var7 * var11 + -var8 * var12;
		int var15 = ((this.wi << 4) - var7) * var12 + -var8 * var11;
		int var16 = -((this.wi << 4) - var7) * var11 + -var8 * var12;
		int var17 = ((this.hi << 4) - var8) * var11 + -var7 * var12;
		int var18 = ((this.hi << 4) - var8) * var12 + var7 * var11;
		int var19 = ((this.wi << 4) - var7) * var12 + ((this.hi << 4) - var8) * var11;
		int var20 = ((this.hi << 4) - var8) * var12 + -((this.wi << 4) - var7) * var11;
		int var21;
		int var22;
		if (var13 < var15) {
			var21 = var13;
			var22 = var15;
		} else {
			var21 = var15;
			var22 = var13;
		}
		if (var17 < var21) {
			var21 = var17;
		}
		if (var19 < var21) {
			var21 = var19;
		}
		if (var17 > var22) {
			var22 = var17;
		}
		if (var19 > var22) {
			var22 = var19;
		}
		int var23;
		int var24;
		if (var14 < var16) {
			var23 = var14;
			var24 = var16;
		} else {
			var23 = var16;
			var24 = var14;
		}
		if (var18 < var23) {
			var23 = var18;
		}
		if (var20 < var23) {
			var23 = var20;
		}
		if (var18 > var24) {
			var24 = var18;
		}
		if (var20 > var24) {
			var24 = var20;
		}
		int var25 = var21 >> 12;
		int var26 = var22 + 4095 >> 12;
		int var27 = var23 >> 12;
		int var28 = var24 + 4095 >> 12;
		int var29 = arg2 + var25;
		int var30 = arg2 + var26;
		int var31 = arg3 + var27;
		int var32 = arg3 + var28;
		int var33 = var29 >> 4;
		int var34 = var30 + 15 >> 4;
		int var35 = var31 >> 4;
		int var36 = var32 + 15 >> 4;
		if (var33 < clipMinX) {
			var33 = clipMinX;
		}
		if (var34 > clipMaxX) {
			var34 = clipMaxX;
		}
		if (var35 < clipMinY) {
			var35 = clipMinY;
		}
		if (var36 > clipMaxY) {
			var36 = clipMaxY;
		}
		int var37 = var33 - var34;
		if (var37 >= 0) {
			return;
		}
		int var38 = var35 - var36;
		if (var38 >= 0) {
			return;
		}
		int var39 = Pix2D.width * var35 + var33;
		double var40 = 1.6777216E7D / (double) arg5;
		int var42 = (int) Math.floor(Math.sin(var9) * var40 + 0.5D);
		int var43 = (int) Math.floor(Math.cos(var9) * var40 + 0.5D);
		int var44 = (var33 << 4) + 8 - arg2;
		int var45 = (var35 << 4) + 8 - arg3;
		int var46 = (var7 << 8) - (var42 * var45 >> 4);
		int var47 = (var8 << 8) + (var43 * var45 >> 4);
		if (var43 == 0) {
			if (var42 == 0) {
				int var48 = var38;
				while (var48 < 0) {
					int var49 = var39;
					int var50 = var46;
					int var51 = var47;
					int var52 = var37;
					if (var46 >= 0 && var47 >= 0 && var46 - (this.wi << 12) < 0 && var47 - (this.hi << 12) < 0) {
						while (var52 < 0) {
							int var53 = this.data[(var50 >> 12) + (var51 >> 12) * this.wi];
							if (var53 == 0) {
								var49++;
							} else {
								Pix2D.pixels[var49++] = var53;
							}
							var52++;
						}
					}
					var48++;
					var39 += Pix2D.width;
				}
			} else if (var42 < 0) {
				int var54 = var38;
				while (var54 < 0) {
					int var55 = var39;
					int var56 = var46;
					int var57 = (var42 * var44 >> 4) + var47;
					int var58 = var37;
					if (var46 >= 0 && var46 - (this.wi << 12) < 0) {
						int var59;
						if ((var59 = var57 - (this.hi << 12)) >= 0) {
							int var60 = (var42 - var59) / var42;
							var58 = var37 + var60;
							var57 += var42 * var60;
							var55 = var39 + var60;
						}
						int var61;
						if ((var61 = (var57 - var42) / var42) > var58) {
							var58 = var61;
						}
						while (var58 < 0) {
							int var62 = this.data[(var56 >> 12) + (var57 >> 12) * this.wi];
							if (var62 == 0) {
								var55++;
							} else {
								Pix2D.pixels[var55++] = var62;
							}
							var57 += var42;
							var58++;
						}
					}
					var54++;
					var46 -= var42;
					var39 += Pix2D.width;
				}
			} else {
				int var63 = var38;
				while (var63 < 0) {
					int var64 = var39;
					int var65 = var46;
					int var66 = (var42 * var44 >> 4) + var47;
					int var67 = var37;
					if (var46 >= 0 && var46 - (this.wi << 12) < 0) {
						if (var66 < 0) {
							int var68 = (var42 - 1 - var66) / var42;
							var67 = var37 + var68;
							var66 += var42 * var68;
							var64 = var39 + var68;
						}
						int var69;
						if ((var69 = (var66 + 1 - (this.hi << 12) - var42) / var42) > var67) {
							var67 = var69;
						}
						while (var67 < 0) {
							int var70 = this.data[(var65 >> 12) + (var66 >> 12) * this.wi];
							if (var70 == 0) {
								var64++;
							} else {
								Pix2D.pixels[var64++] = var70;
							}
							var66 += var42;
							var67++;
						}
					}
					var63++;
					var46 -= var42;
					var39 += Pix2D.width;
				}
			}
		} else if (var43 < 0) {
			if (var42 == 0) {
				int var71 = var38;
				while (var71 < 0) {
					int var72 = var39;
					int var73 = (var43 * var44 >> 4) + var46;
					int var74 = var47;
					int var75 = var37;
					if (var47 >= 0 && var47 - (this.hi << 12) < 0) {
						int var76;
						if ((var76 = var73 - (this.wi << 12)) >= 0) {
							int var77 = (var43 - var76) / var43;
							var75 = var37 + var77;
							var73 += var43 * var77;
							var72 = var39 + var77;
						}
						int var78;
						if ((var78 = (var73 - var43) / var43) > var75) {
							var75 = var78;
						}
						while (var75 < 0) {
							int var79 = this.data[(var73 >> 12) + (var74 >> 12) * this.wi];
							if (var79 == 0) {
								var72++;
							} else {
								Pix2D.pixels[var72++] = var79;
							}
							var73 += var43;
							var75++;
						}
					}
					var71++;
					var47 += var43;
					var39 += Pix2D.width;
				}
			} else if (var42 < 0) {
				int var80 = var38;
				while (var80 < 0) {
					int var81 = var39;
					int var82 = (var43 * var44 >> 4) + var46;
					int var83 = (var42 * var44 >> 4) + var47;
					int var84 = var37;
					int var85;
					if ((var85 = var82 - (this.wi << 12)) >= 0) {
						int var86 = (var43 - var85) / var43;
						var84 = var37 + var86;
						var82 += var43 * var86;
						var83 += var42 * var86;
						var81 = var39 + var86;
					}
					int var87;
					if ((var87 = (var82 - var43) / var43) > var84) {
						var84 = var87;
					}
					int var88;
					if ((var88 = var83 - (this.hi << 12)) >= 0) {
						int var89 = (var42 - var88) / var42;
						var84 += var89;
						var82 += var43 * var89;
						var83 += var42 * var89;
						var81 += var89;
					}
					int var90;
					if ((var90 = (var83 - var42) / var42) > var84) {
						var84 = var90;
					}
					while (var84 < 0) {
						int var91 = this.data[(var82 >> 12) + (var83 >> 12) * this.wi];
						if (var91 == 0) {
							var81++;
						} else {
							Pix2D.pixels[var81++] = var91;
						}
						var82 += var43;
						var83 += var42;
						var84++;
					}
					var80++;
					var46 -= var42;
					var47 += var43;
					var39 += Pix2D.width;
				}
			} else {
				int var92 = var38;
				while (var92 < 0) {
					int var93 = var39;
					int var94 = (var43 * var44 >> 4) + var46;
					int var95 = (var42 * var44 >> 4) + var47;
					int var96 = var37;
					int var97;
					if ((var97 = var94 - (this.wi << 12)) >= 0) {
						int var98 = (var43 - var97) / var43;
						var96 = var37 + var98;
						var94 += var43 * var98;
						var95 += var42 * var98;
						var93 = var39 + var98;
					}
					int var99;
					if ((var99 = (var94 - var43) / var43) > var96) {
						var96 = var99;
					}
					if (var95 < 0) {
						int var100 = (var42 - 1 - var95) / var42;
						var96 += var100;
						var94 += var43 * var100;
						var95 += var42 * var100;
						var93 += var100;
					}
					int var101;
					if ((var101 = (var95 + 1 - (this.hi << 12) - var42) / var42) > var96) {
						var96 = var101;
					}
					while (var96 < 0) {
						int var102 = this.data[(var94 >> 12) + (var95 >> 12) * this.wi];
						if (var102 == 0) {
							var93++;
						} else {
							Pix2D.pixels[var93++] = var102;
						}
						var94 += var43;
						var95 += var42;
						var96++;
					}
					var92++;
					var46 -= var42;
					var47 += var43;
					var39 += Pix2D.width;
				}
			}
		} else if (var42 == 0) {
			int var103 = var38;
			while (var103 < 0) {
				int var104 = var39;
				int var105 = (var43 * var44 >> 4) + var46;
				int var106 = var47;
				int var107 = var37;
				if (var47 >= 0 && var47 - (this.hi << 12) < 0) {
					if (var105 < 0) {
						int var108 = (var43 - 1 - var105) / var43;
						var107 = var37 + var108;
						var105 += var43 * var108;
						var104 = var39 + var108;
					}
					int var109;
					if ((var109 = (var105 + 1 - (this.wi << 12) - var43) / var43) > var107) {
						var107 = var109;
					}
					while (var107 < 0) {
						int var110 = this.data[(var105 >> 12) + (var106 >> 12) * this.wi];
						if (var110 == 0) {
							var104++;
						} else {
							Pix2D.pixels[var104++] = var110;
						}
						var105 += var43;
						var107++;
					}
				}
				var103++;
				var47 += var43;
				var39 += Pix2D.width;
			}
		} else if (var42 < 0) {
			int var111 = var38;
			while (var111 < 0) {
				int var112 = var39;
				int var113 = (var43 * var44 >> 4) + var46;
				int var114 = (var42 * var44 >> 4) + var47;
				int var115 = var37;
				if (var113 < 0) {
					int var116 = (var43 - 1 - var113) / var43;
					var115 = var37 + var116;
					var113 += var43 * var116;
					var114 += var42 * var116;
					var112 = var39 + var116;
				}
				int var117;
				if ((var117 = (var113 + 1 - (this.wi << 12) - var43) / var43) > var115) {
					var115 = var117;
				}
				int var118;
				if ((var118 = var114 - (this.hi << 12)) >= 0) {
					int var119 = (var42 - var118) / var42;
					var115 += var119;
					var113 += var43 * var119;
					var114 += var42 * var119;
					var112 += var119;
				}
				int var120;
				if ((var120 = (var114 - var42) / var42) > var115) {
					var115 = var120;
				}
				while (var115 < 0) {
					int var121 = this.data[(var113 >> 12) + (var114 >> 12) * this.wi];
					if (var121 == 0) {
						var112++;
					} else {
						Pix2D.pixels[var112++] = var121;
					}
					var113 += var43;
					var114 += var42;
					var115++;
				}
				var111++;
				var46 -= var42;
				var47 += var43;
				var39 += Pix2D.width;
			}
		} else {
			int var122 = var38;
			while (var122 < 0) {
				int var123 = var39;
				int var124 = (var43 * var44 >> 4) + var46;
				int var125 = (var42 * var44 >> 4) + var47;
				int var126 = var37;
				if (var124 < 0) {
					int var127 = (var43 - 1 - var124) / var43;
					var126 = var37 + var127;
					var124 += var43 * var127;
					var125 += var42 * var127;
					var123 = var39 + var127;
				}
				int var128;
				if ((var128 = (var124 + 1 - (this.wi << 12) - var43) / var43) > var126) {
					var126 = var128;
				}
				if (var125 < 0) {
					int var129 = (var42 - 1 - var125) / var42;
					var126 += var129;
					var124 += var43 * var129;
					var125 += var42 * var129;
					var123 += var129;
				}
				int var130;
				if ((var130 = (var125 + 1 - (this.hi << 12) - var42) / var42) > var126) {
					var126 = var130;
				}
				while (var126 < 0) {
					int var131 = this.data[(var124 >> 12) + (var125 >> 12) * this.wi];
					if (var131 == 0) {
						var123++;
					} else {
						Pix2D.pixels[var123++] = var131;
					}
					var124 += var43;
					var125 += var42;
					var126++;
				}
				var122++;
				var46 -= var42;
				var47 += var43;
				var39 += Pix2D.width;
			}
		}
	}

	// jag::oldscape::graphics::NXTPix2D::ScanlinePlotSprite
	@ObfuscatedName("fq.cy(Lft;II)V")
	public void scanlinePlotSprite(Pix8 mask, int x, int y) {
		if (clipMaxX - clipMinX != mask.wi || clipMaxY - clipMinY != mask.hi) {
			throw new IllegalStateException();
		}
		int var4 = this.xof + x;
		int var5 = this.yof + y;
		int var6 = Pix2D.width * var5 + var4;
		int var7 = 0;
		int var8 = this.hi;
		int var9 = this.wi;
		int var10 = Pix2D.width - var9;
		int var11 = 0;
		if (var5 < clipMinY) {
			int var12 = clipMinY - var5;
			var8 -= var12;
			var5 = clipMinY;
			var7 += var9 * var12;
			var6 += Pix2D.width * var12;
		}
		if (var5 + var8 > clipMaxY) {
			var8 -= var5 + var8 - clipMaxY;
		}
		if (var4 < clipMinX) {
			int var13 = clipMinX - var4;
			var9 -= var13;
			var4 = clipMinX;
			var7 += var13;
			var6 += var13;
			var11 += var13;
			var10 += var13;
		}
		if (var4 + var9 > clipMaxX) {
			int var14 = var4 + var9 - clipMaxX;
			var9 -= var14;
			var11 += var14;
			var10 += var14;
		}
		if (var9 > 0 && var8 > 0) {
			int var15 = (var5 - clipMinY) * mask.wi + (var4 - clipMinX);
			int var16 = mask.wi - var9;
			plotScanline(Pix2D.pixels, this.data, 0, var7, var6, var15, var9, var8, var10, var11, var16, mask.data);
		}
	}

	@ObfuscatedName("fq.cq([I[IIIIIIIIII[B)V")
	public static void plotScanline(int[] dst, int[] src, int arg2, int srcOff, int dstOff, int maskOff, int w, int h, int dstStep, int srcStep, int maskStep, byte[] mask) {
		int var12 = -(w >> 2);
		int var13 = -(w & 0x3);
		for (int var14 = -h; var14 < 0; var14++) {
			for (int var15 = var12; var15 < 0; var15++) {
				int var16 = src[srcOff++];
				if (var16 != 0 && mask[maskOff] == 0) {
					dst[dstOff++] = var16;
				} else {
					dstOff++;
				}
				maskOff++;
				int var17 = src[srcOff++];
				if (var17 != 0 && mask[maskOff] == 0) {
					dst[dstOff++] = var17;
				} else {
					dstOff++;
				}
				maskOff++;
				int var18 = src[srcOff++];
				if (var18 != 0 && mask[maskOff] == 0) {
					dst[dstOff++] = var18;
				} else {
					dstOff++;
				}
				maskOff++;
				int var19 = src[srcOff++];
				if (var19 != 0 && mask[maskOff] == 0) {
					dst[dstOff++] = var19;
				} else {
					dstOff++;
				}
				maskOff++;
			}
			for (int var20 = var13; var20 < 0; var20++) {
				int var21 = src[srcOff++];
				if (var21 != 0 && mask[maskOff] == 0) {
					dst[dstOff++] = var21;
				} else {
					dstOff++;
				}
				maskOff++;
			}
			dstOff += dstStep;
			srcOff += srcStep;
			maskOff += maskStep;
		}
	}
}
