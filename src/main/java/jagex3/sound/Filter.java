package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.io.Packet;

// jag::oldscape::sound::Filter
@ObfuscatedName("ad")
public class Filter {

	@ObfuscatedName("ad.r")
	public int[] pairs = new int[2];

	@ObfuscatedName("ad.l")
	public int[][][] frequencies = new int[2][2][4];

	@ObfuscatedName("ad.m")
	public int[][][] ranges = new int[2][2][4];

	@ObfuscatedName("ad.c")
	public int[] unities = new int[2];

	// jag::oldscape::sound::Filter::m_coeff
	@ObfuscatedName("ad.n")
	public static float[][] coeff = new float[2][8];

	// jag::oldscape::sound::Filter::m_coeffInt
	@ObfuscatedName("ad.j")
	public static int[][] coeffInt = new int[2][8];

	// jag::oldscape::sound::Filter::m_reduceCoeff
	@ObfuscatedName("ad.z")
	public static float reduceCoeff;

	// jag::oldscape::sound::Filter::m_reduceCoeffInt
	@ObfuscatedName("ad.g")
	public static int reduceCoeffInt;

	// jag::oldscape::sound::Filter::Radius
	@ObfuscatedName("ad.r(IIF)F")
	public float radius(int arg0, int arg1, float arg2) {
		float var4 = (float) (this.ranges[arg0][1][arg1] - this.ranges[arg0][0][arg1]) * arg2 + (float) this.ranges[arg0][0][arg1];
		float var5 = var4 * 0.0015258789F;
		return 1.0F - (float) Math.pow(10.0D, -var5 / 20.0F);
	}

	// jag::oldscape::sound::Filter::Frequency
	@ObfuscatedName("ad.d(F)F")
	public static float frequency(float arg0) {
		float var1 = (float) Math.pow(2.0D, arg0) * 32.703197F;
		return var1 * 3.1415927F / 11025.0F;
	}

	// jag::oldscape::sound::Filter::Frequency
	@ObfuscatedName("ad.l(IIF)F")
	public float frequency(int arg0, int arg1, float arg2) {
		float var4 = (float) (this.frequencies[arg0][1][arg1] - this.frequencies[arg0][0][arg1]) * arg2 + (float) this.frequencies[arg0][0][arg1];
		float var5 = var4 * 1.2207031E-4F;
		return frequency(var5);
	}

	// jag::oldscape::sound::Filter::CalculateCoeffs
	@ObfuscatedName("ad.m(IF)I")
	public int calculateCoeffs(int arg0, float arg1) {
		if (arg0 == 0) {
			float var3 = (float) (this.unities[1] - this.unities[0]) * arg1 + (float) this.unities[0];
			float var4 = var3 * 0.0030517578F;
			reduceCoeff = (float) Math.pow(0.1D, (double) (var4 / 20.0F));
			reduceCoeffInt = (int) (reduceCoeff * 65536.0F);
		}

		if (this.pairs[arg0] == 0) {
			return 0;
		}

		float var5 = this.radius(arg0, 0, arg1);
		coeff[arg0][0] = var5 * -2.0F * (float) Math.cos((double) this.frequency(arg0, 0, arg1));
		coeff[arg0][1] = var5 * var5;
		for (int var6 = 1; var6 < this.pairs[arg0]; var6++) {
			float var7 = this.radius(arg0, var6, arg1);
			float var8 = var7 * -2.0F * (float) Math.cos((double) this.frequency(arg0, var6, arg1));
			float var9 = var7 * var7;
			coeff[arg0][var6 * 2 + 1] = coeff[arg0][var6 * 2 - 1] * var9;
			coeff[arg0][var6 * 2] = coeff[arg0][var6 * 2 - 1] * var8 + coeff[arg0][var6 * 2 - 2] * var9;
			for (int var10 = var6 * 2 - 1; var10 >= 2; var10--) {
				coeff[arg0][var10] += coeff[arg0][var10 - 1] * var8 + coeff[arg0][var10 - 2] * var9;
			}
			coeff[arg0][1] += coeff[arg0][0] * var8 + var9;
			coeff[arg0][0] += var8;
		}

		if (arg0 == 0) {
			for (int var11 = 0; var11 < this.pairs[0] * 2; var11++) {
				coeff[0][var11] *= reduceCoeff;
			}
		}

		for (int var12 = 0; var12 < this.pairs[arg0] * 2; var12++) {
			coeffInt[arg0][var12] = (int) (coeff[arg0][var12] * 65536.0F);
		}

		return this.pairs[arg0] * 2;
	}

	// jag::oldscape::sound::Filter::Load
	@ObfuscatedName("ad.c(Lev;Lk;)V")
	public final void load(Packet arg0, Envelope arg1) {
		int var3 = arg0.g1();
		this.pairs[0] = var3 >> 4;
		this.pairs[1] = var3 & 0xF;

		if (var3 == 0) {
			int[] var9 = this.unities;
			this.unities[1] = 0;
			var9[0] = 0;
			return;
		}

		this.unities[0] = arg0.g2();
		this.unities[1] = arg0.g2();

		int var4 = arg0.g1();
		for (int var5 = 0; var5 < 2; var5++) {
			for (int var6 = 0; var6 < this.pairs[var5]; var6++) {
				this.frequencies[var5][0][var6] = arg0.g2();
				this.ranges[var5][0][var6] = arg0.g2();
			}
		}

		for (int var7 = 0; var7 < 2; var7++) {
			for (int var8 = 0; var8 < this.pairs[var7]; var8++) {
				if ((var4 & 0x1 << var7 * 4 << var8) == 0) {
					this.frequencies[var7][1][var8] = this.frequencies[var7][0][var8];
					this.ranges[var7][1][var8] = this.ranges[var7][0][var8];
				} else {
					this.frequencies[var7][1][var8] = arg0.g2();
					this.ranges[var7][1][var8] = arg0.g2();
				}
			}
		}

		if (var4 != 0 || this.unities[1] != this.unities[0]) {
			arg1.loadPoints(arg0);
		}
	}
}
