package jagex3.graphics;

import deob.ObfuscatedName;

// jag::oldscape::graphics::Pix8
@ObfuscatedName("ft")
public class Pix8 extends Pix2D {

	@ObfuscatedName("ft.u")
	public byte[] data;

	@ObfuscatedName("ft.v")
	public int[] bpal;

	@ObfuscatedName("ft.w")
	public int wi;

	@ObfuscatedName("ft.e")
	public int hi;

	@ObfuscatedName("ft.b")
	public int xof;

	@ObfuscatedName("ft.y")
	public int yof;

	@ObfuscatedName("ft.t")
	public int owi;

	@ObfuscatedName("ft.f")
	public int ohi;

	@ObfuscatedName("ft.bm()V")
	public void trim() {
		if (this.owi == this.wi && this.ohi == this.hi) {
			return;
		}
		byte[] var1 = new byte[this.ohi * this.owi];
		int var2 = 0;
		for (int var3 = 0; var3 < this.hi; var3++) {
			for (int var4 = 0; var4 < this.wi; var4++) {
				var1[(this.yof + var3) * this.owi + this.xof + var4] = this.data[var2++];
			}
		}
		this.data = var1;
		this.wi = this.owi;
		this.hi = this.ohi;
		this.xof = 0;
		this.yof = 0;
	}

	// jag::oldscape::graphics::Pix8::RgbAdjust
	@ObfuscatedName("ft.bn(III)V")
	public void rgbAdjust(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < this.bpal.length; var4++) {
			int var5 = this.bpal[var4] >> 16 & 0xFF;
			int var6 = arg0 + var5;
			if (var6 < 0) {
				var6 = 0;
			} else if (var6 > 255) {
				var6 = 255;
			}
			int var7 = this.bpal[var4] >> 8 & 0xFF;
			int var8 = arg1 + var7;
			if (var8 < 0) {
				var8 = 0;
			} else if (var8 > 255) {
				var8 = 255;
			}
			int var9 = this.bpal[var4] & 0xFF;
			int var10 = arg2 + var9;
			if (var10 < 0) {
				var10 = 0;
			} else if (var10 > 255) {
				var10 = 255;
			}
			this.bpal[var4] = (var6 << 16) + (var8 << 8) + var10;
		}
	}

	// jag::oldscape::graphics::NXTPix2D::PlotSprite
	@ObfuscatedName("ft.be(II)V")
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
			plotSprite(Pix2D.pixels, this.data, this.bpal, var6, var5, var8, var7, var9, var10);
		}
	}

	// jag::oldscape::graphics::NXTPix2D::PlotSprite
	@ObfuscatedName("ft.bp([I[B[IIIIIII)V")
	public static void plotSprite(int[] arg0, byte[] arg1, int[] arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
		int var9 = -(arg5 >> 2);
		int var10 = -(arg5 & 0x3);
		for (int var11 = -arg6; var11 < 0; var11++) {
			for (int var12 = var9; var12 < 0; var12++) {
				byte var13 = arg1[arg3++];
				if (var13 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = arg2[var13 & 0xFF];
				}
				byte var14 = arg1[arg3++];
				if (var14 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = arg2[var14 & 0xFF];
				}
				byte var15 = arg1[arg3++];
				if (var15 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = arg2[var15 & 0xFF];
				}
				byte var16 = arg1[arg3++];
				if (var16 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = arg2[var16 & 0xFF];
				}
			}
			for (int var17 = var10; var17 < 0; var17++) {
				byte var18 = arg1[arg3++];
				if (var18 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = arg2[var18 & 0xFF];
				}
			}
			arg4 += arg7;
			arg3 += arg8;
		}
	}
}
