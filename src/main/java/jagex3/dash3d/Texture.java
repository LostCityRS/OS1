package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable;
import jagex3.graphics.Pix8;
import jagex3.graphics.PixLoader;
import jagex3.io.Packet;
import jagex3.js5.Js5;

@ObfuscatedName("er")
public class Texture extends Linkable {

	@ObfuscatedName("er.z")
	public int averageRgb;

	@ObfuscatedName("er.g")
	public boolean opaque;

	@ObfuscatedName("er.q")
	public int[] fileIds;

	@ObfuscatedName("er.i")
	public int[] op1;

	@ObfuscatedName("er.s")
	public int[] op2;

	@ObfuscatedName("er.u")
	public int[] op3;

	@ObfuscatedName("er.v")
	public int animationDirection;

	@ObfuscatedName("er.w")
	public int animationSpeed;

	@ObfuscatedName("er.e")
	public int[] texels;

	@ObfuscatedName("er.b")
	public boolean field1689 = false;

	@ObfuscatedName("er.y")
	public static int[] swapBuffer;

	public Texture(Packet buf) {
		this.averageRgb = buf.g2();
		this.opaque = buf.g1() == 1;

		int opCount = buf.g1();
		if (opCount < 1 || opCount > 4) {
			throw new RuntimeException();
		}

		this.fileIds = new int[opCount];
		for (int i = 0; i < opCount; i++) {
			this.fileIds[i] = buf.g2();
		}

		if (opCount > 1) {
			this.op1 = new int[opCount - 1];
			for (int i = 0; i < opCount - 1; i++) {
				this.op1[i] = buf.g1();
			}
		}

		if (opCount > 1) {
			this.op2 = new int[opCount - 1];
			for (int i = 0; i < opCount - 1; i++) {
				this.op2[i] = buf.g1();
			}
		}

		this.op3 = new int[opCount];
		for (int i = 0; i < opCount; i++) {
			this.op3[i] = buf.g4();
		}

		this.animationDirection = buf.g1();
		this.animationSpeed = buf.g1();

		this.texels = null;
	}

	@ObfuscatedName("er.c(DILch;)Z")
	public boolean loadTexture(double arg0, int arg1, Js5 arg2) {
		for (int var5 = 0; var5 < this.fileIds.length; var5++) {
			if (arg2.peekFile(this.fileIds[var5]) == null) {
				return false;
			}
		}

		int var6 = arg1 * arg1;
		this.texels = new int[var6];
		for (int var7 = 0; var7 < this.fileIds.length; var7++) {
			Pix8 var8 = PixLoader.makePix8(arg2, this.fileIds[var7]);
			var8.trim();
			byte[] var9 = var8.data;
			int[] var10 = var8.bpal;

			int var11 = this.op3[var7];
			if ((var11 & 0xFF000000) == 0x1000000) {
			}
			if ((var11 & 0xFF000000) == 0x2000000) {
			}
			if ((var11 & 0xFF000000) == 0x3000000) {
				int var12 = var11 & 0xFF00FF;
				int var13 = var11 >> 8 & 0xFF;
				for (int var14 = 0; var14 < var10.length; var14++) {
					int var15 = var10[var14];
					if (var15 >> 8 == (var15 & 0xFFFF)) {
						int var16 = var15 & 0xFF;
						var10[var14] = var12 * var16 >> 8 & 0xFF00FF | var13 * var16 & 0xFF00;
					}
				}
			}

			for (int var17 = 0; var17 < var10.length; var17++) {
				var10[var17] = Pix3D.gammaCorrect(var10[var17], arg0);
			}

			int mode;
			if (var7 == 0) {
				mode = 0;
			} else {
				mode = this.op1[var7 - 1];
			}

			if (var7 == 0) {
			}

			if (mode == 0) {
				if (var8.wi == arg1) {
					for (int var19 = 0; var19 < var6; var19++) {
						this.texels[var19] = var10[var9[var19] & 0xFF];
					}
				} else if (var8.wi == 64 && arg1 == 128) {
					int var20 = 0;
					for (int var21 = 0; var21 < arg1; var21++) {
						for (int var22 = 0; var22 < arg1; var22++) {
							this.texels[var20++] = var10[var9[(var21 >> 1 << 6) + (var22 >> 1)] & 0xFF];
						}
					}
				} else if (var8.wi == 128 && arg1 == 64) {
					int var23 = 0;
					for (int var24 = 0; var24 < arg1; var24++) {
						for (int var25 = 0; var25 < arg1; var25++) {
							this.texels[var23++] = var10[var9[(var24 << 1 << 7) + (var25 << 1)] & 0xFF];
						}
					}
				} else {
					throw new RuntimeException();
				}
			}

			if (mode == 1) {
			}

			if (mode == 2) {
			}

			if (mode == 3) {
			}
		}

		return true;
	}

	@ObfuscatedName("er.n()V")
	public void unload() {
		this.texels = null;
	}

	@ObfuscatedName("er.j(I)V")
	public void animate(int cycle) {
		if (this.texels == null) {
			return;
		}

		if (this.animationDirection == 1 || this.animationDirection == 3) {
			if (swapBuffer == null || swapBuffer.length < this.texels.length) {
				swapBuffer = new int[this.texels.length];
			}

			short var2;
			if (this.texels.length == 4096) {
				var2 = 64;
			} else {
				var2 = 128;
			}

			int var3 = this.texels.length;
			int var4 = cycle * var2 * this.animationSpeed;
			int var5 = var3 - 1;
			if (this.animationDirection == 1) {
				var4 = -var4;
			}

			for (int var6 = 0; var6 < var3; var6++) {
				int var7 = var4 + var6 & var5;
				swapBuffer[var6] = this.texels[var7];
			}

			int[] var8 = this.texels;
			this.texels = swapBuffer;
			swapBuffer = var8;
		}

		if (this.animationDirection == 2 || this.animationDirection == 4) {
			if (swapBuffer == null || swapBuffer.length < this.texels.length) {
				swapBuffer = new int[this.texels.length];
			}

			short var9;
			if (this.texels.length == 4096) {
				var9 = 64;
			} else {
				var9 = 128;
			}

			int var10 = this.texels.length;
			int var11 = this.animationSpeed * cycle;
			int var12 = var9 - 1;
			if (this.animationDirection == 2) {
				var11 = -var11;
			}

			for (int var13 = 0; var13 < var10; var13 += var9) {
				for (int var14 = 0; var14 < var9; var14++) {
					int var15 = var13 + var14;
					int var16 = (var11 + var14 & var12) + var13;
					swapBuffer[var15] = this.texels[var16];
				}
			}

			int[] var17 = this.texels;
			this.texels = swapBuffer;
			swapBuffer = var17;
		}
	}
}
