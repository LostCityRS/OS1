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
	public float radius(int direction, int pair, float delta) {
		float g = (float) (this.ranges[direction][1][pair] - this.ranges[direction][0][pair]) * delta + (float) this.ranges[direction][0][pair];
		float g2 = g * 0.0015258789F;
		return 1.0F - (float) Math.pow(10.0D, -g2 / 20.0F);
	}

	// jag::oldscape::sound::Filter::Frequency
	@ObfuscatedName("ad.d(F)F")
	public static float frequency(float f) {
		float f1 = (float) Math.pow(2.0D, f) * 32.703197F;
		return f1 * 3.1415927F / 11025.0F;
	}

	// jag::oldscape::sound::Filter::Frequency
	@ObfuscatedName("ad.l(IIF)F")
	public float frequency(int direction, int pair, float delta) {
		float f1 = (float) (this.frequencies[direction][1][pair] - this.frequencies[direction][0][pair]) * delta + (float) this.frequencies[direction][0][pair];
		float f2 = f1 * 1.2207031E-4F;
		return frequency(f2);
	}

	// jag::oldscape::sound::Filter::CalculateCoeffs
	@ObfuscatedName("ad.m(IF)I")
	public int calculateCoeffs(int direction, float delta) {
		if (direction == 0) {
			float u = (float) (this.unities[1] - this.unities[0]) * delta + (float) this.unities[0];
			float u2 = u * 0.0030517578F;
			reduceCoeff = (float) Math.pow(0.1D, u2 / 20.0F);
			reduceCoeffInt = (int) (reduceCoeff * 65536.0F);
		}

		if (this.pairs[direction] == 0) {
			return 0;
		}

		float u = this.radius(direction, 0, delta);

		coeff[direction][0] = u * -2.0F * (float) Math.cos(this.frequency(direction, 0, delta));
		coeff[direction][1] = u * u;

		for (int pair = 1; pair < this.pairs[direction]; pair++) {
			float g = this.radius(direction, pair, delta);
			float a = g * -2.0F * (float) Math.cos(this.frequency(direction, pair, delta));
			float b = g * g;

			coeff[direction][pair * 2 + 1] = coeff[direction][pair * 2 - 1] * b;
			coeff[direction][pair * 2] = coeff[direction][pair * 2 - 1] * a + coeff[direction][pair * 2 - 2] * b;

			for (int i = pair * 2 - 1; i >= 2; i--) {
				coeff[direction][i] += coeff[direction][i - 1] * a + coeff[direction][i - 2] * b;
			}

			coeff[direction][1] += coeff[direction][0] * a + b;
			coeff[direction][0] += a;
		}

		if (direction == 0) {
			for (int i = 0; i < this.pairs[0] * 2; i++) {
				coeff[0][i] *= reduceCoeff;
			}
		}

		for (int i = 0; i < this.pairs[direction] * 2; i++) {
			coeffInt[direction][i] = (int) (coeff[direction][i] * 65536.0F);
		}

		return this.pairs[direction] * 2;
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
