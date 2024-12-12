package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.io.Packet;

@ObfuscatedName("ad")
public class Filter {

	@ObfuscatedName("ad.r")
	public int[] field338 = new int[2];

	@ObfuscatedName("ad.l")
	public int[][][] field346 = new int[2][2][4];

	@ObfuscatedName("ad.m")
	public int[][][] field339 = new int[2][2][4];

	@ObfuscatedName("ad.c")
	public int[] field340 = new int[2];

	@ObfuscatedName("ad.n")
	public static float[][] field341 = new float[2][8];

	@ObfuscatedName("ad.j")
	public static int[][] field342 = new int[2][8];

	@ObfuscatedName("ad.z")
	public static float field343;

	@ObfuscatedName("ad.g")
	public static int field344;

	@ObfuscatedName("ad.r(IIF)F")
	public float method348(int arg0, int arg1, float arg2) {
		float var4 = (float) (this.field339[arg0][1][arg1] - this.field339[arg0][0][arg1]) * arg2 + (float) this.field339[arg0][0][arg1];
		float var5 = var4 * 0.0015258789F;
		return 1.0F - (float) Math.pow(10.0D, (double) (-var5 / 20.0F));
	}

	@ObfuscatedName("ad.d(F)F")
	public static float method349(float arg0) {
		float var1 = (float) Math.pow(2.0D, (double) arg0) * 32.703197F;
		return var1 * 3.1415927F / 11025.0F;
	}

	@ObfuscatedName("ad.l(IIF)F")
	public float method350(int arg0, int arg1, float arg2) {
		float var4 = (float) (this.field346[arg0][1][arg1] - this.field346[arg0][0][arg1]) * arg2 + (float) this.field346[arg0][0][arg1];
		float var5 = var4 * 1.2207031E-4F;
		return method349(var5);
	}

	@ObfuscatedName("ad.m(IF)I")
	public int method351(int arg0, float arg1) {
		if (arg0 == 0) {
			float var3 = (float) (this.field340[1] - this.field340[0]) * arg1 + (float) this.field340[0];
			float var4 = var3 * 0.0030517578F;
			field343 = (float) Math.pow(0.1D, (double) (var4 / 20.0F));
			field344 = (int) (field343 * 65536.0F);
		}
		if (this.field338[arg0] == 0) {
			return 0;
		}
		float var5 = this.method348(arg0, 0, arg1);
		field341[arg0][0] = var5 * -2.0F * (float) Math.cos((double) this.method350(arg0, 0, arg1));
		field341[arg0][1] = var5 * var5;
		for (int var6 = 1; var6 < this.field338[arg0]; var6++) {
			float var7 = this.method348(arg0, var6, arg1);
			float var8 = var7 * -2.0F * (float) Math.cos((double) this.method350(arg0, var6, arg1));
			float var9 = var7 * var7;
			field341[arg0][var6 * 2 + 1] = field341[arg0][var6 * 2 - 1] * var9;
			field341[arg0][var6 * 2] = field341[arg0][var6 * 2 - 1] * var8 + field341[arg0][var6 * 2 - 2] * var9;
			for (int var10 = var6 * 2 - 1; var10 >= 2; var10--) {
				field341[arg0][var10] += field341[arg0][var10 - 1] * var8 + field341[arg0][var10 - 2] * var9;
			}
			field341[arg0][1] += field341[arg0][0] * var8 + var9;
			field341[arg0][0] += var8;
		}
		if (arg0 == 0) {
			for (int var11 = 0; var11 < this.field338[0] * 2; var11++) {
				field341[0][var11] *= field343;
			}
		}
		for (int var12 = 0; var12 < this.field338[arg0] * 2; var12++) {
			field342[arg0][var12] = (int) (field341[arg0][var12] * 65536.0F);
		}
		return this.field338[arg0] * 2;
	}

	@ObfuscatedName("ad.c(Lev;Lk;)V")
	public final void method357(Packet arg0, Envelope arg1) {
		int var3 = arg0.g1();
		this.field338[0] = var3 >> 4;
		this.field338[1] = var3 & 0xF;
		if (var3 == 0) {
			int[] var9 = this.field340;
			this.field340[1] = 0;
			var9[0] = 0;
			return;
		}
		this.field340[0] = arg0.g2();
		this.field340[1] = arg0.g2();
		int var4 = arg0.g1();
		for (int var5 = 0; var5 < 2; var5++) {
			for (int var6 = 0; var6 < this.field338[var5]; var6++) {
				this.field346[var5][0][var6] = arg0.g2();
				this.field339[var5][0][var6] = arg0.g2();
			}
		}
		for (int var7 = 0; var7 < 2; var7++) {
			for (int var8 = 0; var8 < this.field338[var7]; var8++) {
				if ((var4 & 0x1 << var7 * 4 << var8) == 0) {
					this.field346[var7][1][var8] = this.field346[var7][0][var8];
					this.field339[var7][1][var8] = this.field339[var7][0][var8];
				} else {
					this.field346[var7][1][var8] = arg0.g2();
					this.field339[var7][1][var8] = arg0.g2();
				}
			}
		}
		if (var4 != 0 || this.field340[1] != this.field340[0]) {
			arg1.method277(arg0);
		}
	}
}
