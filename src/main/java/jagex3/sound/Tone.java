package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.datastruct.ArrayUtil;
import jagex3.io.Packet;

import java.util.Random;

// jag::oldscape::sound::Tone
@ObfuscatedName("t")
public class Tone {

	@ObfuscatedName("t.r")
	public Envelope frequencyBase;

	@ObfuscatedName("t.d")
	public Envelope amplitudeBase;

	@ObfuscatedName("t.l")
	public Envelope frequencyModRate;

	@ObfuscatedName("t.m")
	public Envelope frequencyModRange;

	@ObfuscatedName("t.c")
	public Envelope amplitudeModRate;

	@ObfuscatedName("t.n")
	public Envelope amplitudeModRange;

	@ObfuscatedName("t.j")
	public Envelope release;

	@ObfuscatedName("t.z")
	public Envelope attack;

	@ObfuscatedName("t.g")
	public int[] harmonicVolume = new int[] { 0, 0, 0, 0, 0 };

	@ObfuscatedName("t.q")
	public int[] harmonicSemitone = new int[] { 0, 0, 0, 0, 0 };

	@ObfuscatedName("t.i")
	public int[] harmonicDelay = new int[] { 0, 0, 0, 0, 0 };

	@ObfuscatedName("t.s")
	public int reverbDelay = 0;

	@ObfuscatedName("t.u")
	public int reverbVolume = 100;

	@ObfuscatedName("t.v")
	public Filter filter;

	@ObfuscatedName("t.w")
	public Envelope filterRange;

	@ObfuscatedName("t.e")
	public int length = 500;

	@ObfuscatedName("t.b")
	public int start = 0;

	// jag::oldscape::sound::Tone::m_buf
	@ObfuscatedName("t.y")
	public static int[] buf;

	// jag::oldscape::sound::Tone::m_noise
	@ObfuscatedName("t.t")
	public static int[] noise = new int[32768];

	// jag::oldscape::sound::Tone::m_sine
	@ObfuscatedName("t.f")
	public static int[] sine;

	// jag::oldscape::sound::Tone::m_fPos
	@ObfuscatedName("t.o")
	public static int[] fPos;

	// jag::oldscape::sound::Tone::m_fDel
	@ObfuscatedName("t.a")
	public static int[] fDel;

	// jag::oldscape::sound::Tone::m_fAmp
	@ObfuscatedName("t.h")
	public static int[] fAmp;

	// jag::oldscape::sound::Tone::m_fMulti
	@ObfuscatedName("t.x")
	public static int[] fMulti;

	// jag::oldscape::sound::Tone::m_fOffset
	@ObfuscatedName("t.p")
	public static int[] fOffset;

	static {
		Random rand = new Random(0L);
		for (int i = 0; i < 32768; i++) {
			noise[i] = (rand.nextInt() & 0x2) - 1;
		}

		sine = new int[32768];
		for (int i = 0; i < 32768; i++) {
			sine[i] = (int) (Math.sin((double) i / 5215.1903D) * 16384.0D);
		}

		buf = new int[22050 * 10];

		fPos = new int[5];
		fDel = new int[5];
		fAmp = new int[5];
		fMulti = new int[5];
		fOffset = new int[5];
	}

	// jag::oldscape::sound::Tone::Generate
	@ObfuscatedName("t.r(II)[I")
	public final int[] generate(int arg0, int arg1) {
		ArrayUtil.clear(buf, 0, arg0);

		if (arg1 < 10) {
			return buf;
		}

		double var3 = (double) arg0 / ((double) arg1 + 0.0D);

		this.frequencyBase.genInit();
		this.amplitudeBase.genInit();

		int var5 = 0;
		int var6 = 0;
		int var7 = 0;
		if (this.frequencyModRate != null) {
			this.frequencyModRate.genInit();
			this.frequencyModRange.genInit();
			var5 = (int) ((double) (this.frequencyModRate.end - this.frequencyModRate.start) * 32.768D / var3);
			var6 = (int) ((double) this.frequencyModRate.start * 32.768D / var3);
		}

		int var8 = 0;
		int var9 = 0;
		int var10 = 0;
		if (this.amplitudeModRate != null) {
			this.amplitudeModRate.genInit();
			this.amplitudeModRange.genInit();
			var8 = (int) ((double) (this.amplitudeModRate.end - this.amplitudeModRate.start) * 32.768D / var3);
			var9 = (int) ((double) this.amplitudeModRate.start * 32.768D / var3);
		}

		for (int var11 = 0; var11 < 5; var11++) {
			if (this.harmonicVolume[var11] != 0) {
				fPos[var11] = 0;
				fDel[var11] = (int) ((double) this.harmonicDelay[var11] * var3);
				fAmp[var11] = (this.harmonicVolume[var11] << 14) / 100;
				fMulti[var11] = (int) ((double) (this.frequencyBase.end - this.frequencyBase.start) * 32.768D * Math.pow(1.0057929410678534D, (double) this.harmonicSemitone[var11]) / var3);
				fOffset[var11] = (int) ((double) this.frequencyBase.start * 32.768D / var3);
			}
		}

		for (int var12 = 0; var12 < arg0; var12++) {
			int var13 = this.frequencyBase.genNext(arg0);
			int var14 = this.amplitudeBase.genNext(arg0);

			if (this.frequencyModRate != null) {
				int var15 = this.frequencyModRate.genNext(arg0);
				int var16 = this.frequencyModRange.genNext(arg0);
				var13 += this.waveFunc(var7, var16, this.frequencyModRate.form) >> 1;
				var7 += (var5 * var15 >> 16) + var6;
			}

			if (this.amplitudeModRate != null) {
				int var17 = this.amplitudeModRate.genNext(arg0);
				int var18 = this.amplitudeModRange.genNext(arg0);
				var14 = var14 * ((this.waveFunc(var10, var18, this.amplitudeModRate.form) >> 1) + 32768) >> 15;
				var10 += (var8 * var17 >> 16) + var9;
			}

			for (int var19 = 0; var19 < 5; var19++) {
				if (this.harmonicVolume[var19] != 0) {
					int var20 = fDel[var19] + var12;
					if (var20 < arg0) {
						buf[var20] += this.waveFunc(fPos[var19], fAmp[var19] * var14 >> 15, this.frequencyBase.form);
						fPos[var19] += (fMulti[var19] * var13 >> 16) + fOffset[var19];
					}
				}
			}
		}

		if (this.release != null) {
			this.release.genInit();
			this.attack.genInit();

			int var21 = 0;
			boolean var23 = true;

			for (int var24 = 0; var24 < arg0; var24++) {
				int var25 = this.release.genNext(arg0);
				int var26 = this.attack.genNext(arg0);

				int var27;
				if (var23) {
					var27 = ((this.release.end - this.release.start) * var25 >> 8) + this.release.start;
				} else {
					var27 = ((this.release.end - this.release.start) * var26 >> 8) + this.release.start;
				}

				var21 += 256;
				if (var21 >= var27) {
					var21 = 0;
					var23 = !var23;
				}

				if (var23) {
					buf[var24] = 0;
				}
			}
		}

		if (this.reverbDelay > 0 && this.reverbVolume > 0) {
			int var28 = (int) ((double) this.reverbDelay * var3);
			for (int var29 = var28; var29 < arg0; var29++) {
				buf[var29] += buf[var29 - var28] * this.reverbVolume / 100;
			}
		}

		if (this.filter.pairs[0] > 0 || this.filter.pairs[1] > 0) {
			this.filterRange.genInit();

			int var30 = this.filterRange.genNext(arg0 + 1);

			int var31 = this.filter.calculateCoeffs(0, (float) var30 / 65536.0F);
			int var32 = this.filter.calculateCoeffs(1, (float) var30 / 65536.0F);

			if (arg0 >= var31 + var32) {
				int var33 = 0;
				int var34 = var32;
				if (var32 > arg0 - var31) {
					var34 = arg0 - var31;
				}

				while (var33 < var34) {
					int var35 = (int) ((long) buf[var31 + var33] * (long) Filter.reduceCoeffInt >> 16);
					for (int var36 = 0; var36 < var31; var36++) {
						var35 += (int) ((long) buf[var31 + var33 - 1 - var36] * (long) Filter.coeffInt[0][var36] >> 16);
					}

					for (int var37 = 0; var37 < var33; var37++) {
						var35 -= (int) ((long) buf[var33 - 1 - var37] * (long) Filter.coeffInt[1][var37] >> 16);
					}

					buf[var33] = var35;
					var30 = this.filterRange.genNext(arg0 + 1);
					var33++;
				}

				int var38 = 128;
				while (true) {
					if (var38 > arg0 - var31) {
						var38 = arg0 - var31;
					}

					while (var33 < var38) {
						int var39 = (int) ((long) buf[var31 + var33] * (long) Filter.reduceCoeffInt >> 16);
						for (int var40 = 0; var40 < var31; var40++) {
							var39 += (int) ((long) buf[var31 + var33 - 1 - var40] * (long) Filter.coeffInt[0][var40] >> 16);
						}

						for (int var41 = 0; var41 < var32; var41++) {
							var39 -= (int) ((long) buf[var33 - 1 - var41] * (long) Filter.coeffInt[1][var41] >> 16);
						}

						buf[var33] = var39;
						var30 = this.filterRange.genNext(arg0 + 1);
						var33++;
					}

					if (var33 >= arg0 - var31) {
						while (var33 < arg0) {
							int var42 = 0;
							for (int var43 = var31 + var33 - arg0; var43 < var31; var43++) {
								var42 += (int) ((long) buf[var31 + var33 - 1 - var43] * (long) Filter.coeffInt[0][var43] >> 16);
							}

							for (int var44 = 0; var44 < var32; var44++) {
								var42 -= (int) ((long) buf[var33 - 1 - var44] * (long) Filter.coeffInt[1][var44] >> 16);
							}

							buf[var33] = var42;
							this.filterRange.genNext(arg0 + 1);
							var33++;
						}

						break;
					}

					var31 = this.filter.calculateCoeffs(0, (float) var30 / 65536.0F);
					var32 = this.filter.calculateCoeffs(1, (float) var30 / 65536.0F);
					var38 += 128;
				}
			}
		}

		for (int var46 = 0; var46 < arg0; var46++) {
			if (buf[var46] < -32768) {
				buf[var46] = -32768;
			}
			if (buf[var46] > 32767) {
				buf[var46] = 32767;
			}
		}

		return buf;
	}

	// jag::oldscape::sound::Tone::WaveFunc
	@ObfuscatedName("t.d(III)I")
	public final int waveFunc(int arg0, int arg1, int arg2) {
		if (arg2 == 1) {
			return (arg0 & 0x7FFF) < 16384 ? arg1 : -arg1;
		} else if (arg2 == 2) {
			return sine[arg0 & 0x7FFF] * arg1 >> 14;
		} else if (arg2 == 3) {
			return ((arg0 & 0x7FFF) * arg1 >> 14) - arg1;
		} else if (arg2 == 4) {
			return noise[arg0 / 2607 & 0x7FFF] * arg1;
		} else {
			return 0;
		}
	}

	// jag::oldscape::sound::Tone::Load
	@ObfuscatedName("t.l(Lev;)V")
	public final void load(Packet arg0) {
		this.frequencyBase = new Envelope();
		this.frequencyBase.load(arg0);

		this.amplitudeBase = new Envelope();
		this.amplitudeBase.load(arg0);

		int var2 = arg0.g1();
		if (var2 != 0) {
			arg0.pos--;
			this.frequencyModRate = new Envelope();
			this.frequencyModRate.load(arg0);
			this.frequencyModRange = new Envelope();
			this.frequencyModRange.load(arg0);
		}

		int var3 = arg0.g1();
		if (var3 != 0) {
			arg0.pos--;
			this.amplitudeModRate = new Envelope();
			this.amplitudeModRate.load(arg0);
			this.amplitudeModRange = new Envelope();
			this.amplitudeModRange.load(arg0);
		}

		int var4 = arg0.g1();
		if (var4 != 0) {
			arg0.pos--;
			this.release = new Envelope();
			this.release.load(arg0);
			this.attack = new Envelope();
			this.attack.load(arg0);
		}

		for (int var5 = 0; var5 < 10; var5++) {
			int var6 = arg0.gsmart();
			if (var6 == 0) {
				break;
			}

			this.harmonicVolume[var5] = var6;
			this.harmonicSemitone[var5] = arg0.gsmarts();
			this.harmonicDelay[var5] = arg0.gsmart();
		}

		this.reverbDelay = arg0.gsmart();
		this.reverbVolume = arg0.gsmart();
		this.length = arg0.g2();
		this.start = arg0.g2();

		this.filter = new Filter();
		this.filterRange = new Envelope();
		this.filter.load(arg0, this.filterRange);
	}
}
