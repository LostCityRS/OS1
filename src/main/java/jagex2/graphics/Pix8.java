package jagex2.graphics;

import deob.ObfuscatedName;

@ObfuscatedName("ft")
public class Pix8 extends Pix2D {

	@ObfuscatedName("ft.u")
	public byte[] field2511;

	@ObfuscatedName("ft.v")
	public int[] field2512;

	@ObfuscatedName("ft.w")
	public int field2513;

	@ObfuscatedName("ft.e")
	public int field2514;

	@ObfuscatedName("ft.b")
	public int field2515;

	@ObfuscatedName("ft.y")
	public int field2516;

	@ObfuscatedName("ft.t")
	public int field2517;

	@ObfuscatedName("ft.f")
	public int field2518;

	@ObfuscatedName("ft.bm()V")
	public void method2744() {
		if (this.field2517 == this.field2513 && this.field2518 == this.field2514) {
			return;
		}
		byte[] var1 = new byte[this.field2518 * this.field2517];
		int var2 = 0;
		for (int var3 = 0; var3 < this.field2514; var3++) {
			for (int var4 = 0; var4 < this.field2513; var4++) {
				var1[(this.field2516 + var3) * this.field2517 + this.field2515 + var4] = this.field2511[var2++];
			}
		}
		this.field2511 = var1;
		this.field2513 = this.field2517;
		this.field2514 = this.field2518;
		this.field2515 = 0;
		this.field2516 = 0;
	}

	@ObfuscatedName("ft.bn(III)V")
	public void method2751(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < this.field2512.length; var4++) {
			int var5 = this.field2512[var4] >> 16 & 0xFF;
			int var6 = arg0 + var5;
			if (var6 < 0) {
				var6 = 0;
			} else if (var6 > 255) {
				var6 = 255;
			}
			int var7 = this.field2512[var4] >> 8 & 0xFF;
			int var8 = arg1 + var7;
			if (var8 < 0) {
				var8 = 0;
			} else if (var8 > 255) {
				var8 = 255;
			}
			int var9 = this.field2512[var4] & 0xFF;
			int var10 = arg2 + var9;
			if (var10 < 0) {
				var10 = 0;
			} else if (var10 > 255) {
				var10 = 255;
			}
			this.field2512[var4] = (var6 << 16) + (var8 << 8) + var10;
		}
	}

	@ObfuscatedName("ft.be(II)V")
	public void method2747(int arg0, int arg1) {
		int var3 = this.field2515 + arg0;
		int var4 = this.field2516 + arg1;
		int var5 = Pix2D.width2d * var4 + var3;
		int var6 = 0;
		int var7 = this.field2514;
		int var8 = this.field2513;
		int var9 = Pix2D.width2d - var8;
		int var10 = 0;
		if (var4 < top) {
			int var11 = top - var4;
			var7 -= var11;
			var4 = top;
			var6 += var8 * var11;
			var5 += Pix2D.width2d * var11;
		}
		if (var4 + var7 > bottom) {
			var7 -= var4 + var7 - bottom;
		}
		if (var3 < left) {
			int var12 = left - var3;
			var8 -= var12;
			var3 = left;
			var6 += var12;
			var5 += var12;
			var10 += var12;
			var9 += var12;
		}
		if (var3 + var8 > right) {
			int var13 = var3 + var8 - right;
			var8 -= var13;
			var10 += var13;
			var9 += var13;
		}
		if (var8 > 0 && var7 > 0) {
			method2745(Pix2D.data, this.field2511, this.field2512, var6, var5, var8, var7, var9, var10);
		}
	}

	@ObfuscatedName("ft.bp([I[B[IIIIIII)V")
	public static void method2745(int[] arg0, byte[] arg1, int[] arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
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
