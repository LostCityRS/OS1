package jagex3.midi;

import deob.ObfuscatedName;
import jagex3.datastruct.IntUtil;

@ObfuscatedName("x")
public class VorbisCookbook {

	@ObfuscatedName("x.r")
	public int field324;

	@ObfuscatedName("x.d")
	public int field327;

	@ObfuscatedName("x.l")
	public int[] field325;

	@ObfuscatedName("x.m")
	public int[] field326;

	@ObfuscatedName("x.c")
	public float[][] field328;

	@ObfuscatedName("x.n")
	public int[] field323;

	@ObfuscatedName("x.r(II)I")
	public static int method323(int arg0, int arg1) {
		int var2 = (int) Math.pow((double) arg0, 1.0D / (double) arg1) + 1;
		while (true) {
			int var3 = var2;
			int var4 = arg1;
			int var5 = 1;
			while (var4 > 1) {
				if ((var4 & 0x1) != 0) {
					var5 = var3 * var5;
				}
				var3 *= var3;
				var4 >>= 0x1;
			}
			int var6;
			if (var4 == 1) {
				var6 = var3 * var5;
			} else {
				var6 = var5;
			}
			if (var6 <= arg0) {
				return var2;
			}
			var2--;
		}
	}

	public VorbisCookbook() {
		VorbisSound.method1561(24);
		this.field324 = VorbisSound.method1561(16);
		this.field327 = VorbisSound.method1561(24);
		this.field325 = new int[this.field327];
		boolean var1 = VorbisSound.method1553() != 0;
		if (var1) {
			int var2 = 0;
			int var3 = VorbisSound.method1561(5) + 1;
			while (var2 < this.field327) {
				int var4 = VorbisSound.method1561(IntUtil.method479(this.field327 - var2));
				for (int var5 = 0; var5 < var4; var5++) {
					this.field325[var2++] = var3;
				}
				var3++;
			}
		} else {
			boolean var6 = VorbisSound.method1553() != 0;
			for (int var7 = 0; var7 < this.field327; var7++) {
				if (var6 && VorbisSound.method1553() == 0) {
					this.field325[var7] = 0;
				} else {
					this.field325[var7] = VorbisSound.method1561(5) + 1;
				}
			}
		}
		this.method319();
		int var8 = VorbisSound.method1561(4);
		if (var8 > 0) {
			float var9 = VorbisSound.method1540(VorbisSound.method1561(32));
			float var10 = VorbisSound.method1540(VorbisSound.method1561(32));
			int var11 = VorbisSound.method1561(4) + 1;
			boolean var12 = VorbisSound.method1553() != 0;
			int var13;
			if (var8 == 1) {
				var13 = method323(this.field327, this.field324);
			} else {
				var13 = this.field327 * this.field324;
			}
			this.field326 = new int[var13];
			for (int var14 = 0; var14 < var13; var14++) {
				this.field326[var14] = VorbisSound.method1561(var11);
			}
			this.field328 = new float[this.field327][this.field324];
			if (var8 == 1) {
				for (int var15 = 0; var15 < this.field327; var15++) {
					float var16 = 0.0F;
					int var17 = 1;
					for (int var18 = 0; var18 < this.field324; var18++) {
						int var19 = var15 / var17 % var13;
						float var20 = (float) this.field326[var19] * var10 + var9 + var16;
						this.field328[var15][var18] = var20;
						if (var12) {
							var16 = var20;
						}
						var17 = var13 * var17;
					}
				}
			} else {
				for (int var21 = 0; var21 < this.field327; var21++) {
					float var22 = 0.0F;
					int var23 = this.field324 * var21;
					for (int var24 = 0; var24 < this.field324; var24++) {
						float var25 = (float) this.field326[var23] * var10 + var9 + var22;
						this.field328[var21][var24] = var25;
						if (var12) {
							var22 = var25;
						}
						var23++;
					}
				}
			}
		}
	}

	@ObfuscatedName("x.d()V")
	public void method319() {
		int[] var1 = new int[this.field327];
		int[] var2 = new int[33];
		for (int var3 = 0; var3 < this.field327; var3++) {
			int var4 = this.field325[var3];
			if (var4 != 0) {
				int var5 = 0x1 << 32 - var4;
				int var6 = var2[var4];
				var1[var3] = var6;
				int var7;
				if ((var6 & var5) == 0) {
					var7 = var6 | var5;
					for (int var8 = var4 - 1; var8 >= 1; var8--) {
						int var9 = var2[var8];
						if (var6 != var9) {
							break;
						}
						int var10 = 0x1 << 32 - var8;
						if ((var9 & var10) != 0) {
							var2[var8] = var2[var8 - 1];
							break;
						}
						var2[var8] = var9 | var10;
					}
				} else {
					var7 = var2[var4 - 1];
				}
				var2[var4] = var7;
				for (int var11 = var4 + 1; var11 <= 32; var11++) {
					int var12 = var2[var11];
					if (var6 == var12) {
						var2[var11] = var7;
					}
				}
			}
		}
		this.field323 = new int[8];
		int var13 = 0;
		for (int var14 = 0; var14 < this.field327; var14++) {
			int var15 = this.field325[var14];
			if (var15 != 0) {
				int var16 = var1[var14];
				int var17 = 0;
				for (int var18 = 0; var18 < var15; var18++) {
					int var19 = Integer.MIN_VALUE >>> var18;
					if ((var16 & var19) == 0) {
						var17++;
					} else {
						if (this.field323[var17] == 0) {
							this.field323[var17] = var13;
						}
						var17 = this.field323[var17];
					}
					if (var17 >= this.field323.length) {
						int[] var20 = new int[this.field323.length * 2];
						for (int var21 = 0; var21 < this.field323.length; var21++) {
							var20[var21] = this.field323[var21];
						}
						this.field323 = var20;
					}
					int var22 = var19 >>> 1;
				}
				this.field323[var17] = ~var14;
				if (var17 >= var13) {
					var13 = var17 + 1;
				}
			}
		}
	}

	@ObfuscatedName("x.l()I")
	public int method320() {
		int var1;
		for (var1 = 0; this.field323[var1] >= 0; var1 = VorbisSound.method1553() == 0 ? var1 + 1 : this.field323[var1]) {
		}
		return ~this.field323[var1];
	}

	@ObfuscatedName("x.m()[F")
	public float[] method318() {
		return this.field328[this.method320()];
	}
}
