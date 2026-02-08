package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.io.Packet;
import jagex3.util.ArrayUtil;

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
	public final int[] generate(int sampleCount, int length) {
		ArrayUtil.clear(buf, 0, sampleCount);

		if (length < 10) {
			return buf;
		}

		double samplesPerStep = (double) sampleCount / ((double) length + 0.0D);

		this.frequencyBase.genInit();
		this.amplitudeBase.genInit();

		int frequencyStart = 0;
		int frequencyDuration = 0;
		int frequencyPhase = 0;
		if (this.frequencyModRate != null) {
			this.frequencyModRate.genInit();
			this.frequencyModRange.genInit();
			frequencyStart = (int) ((double) (this.frequencyModRate.end - this.frequencyModRate.start) * 32.768D / samplesPerStep);
			frequencyDuration = (int) ((double) this.frequencyModRate.start * 32.768D / samplesPerStep);
		}

		int amplitudeStart = 0;
		int amplitudeDuration = 0;
		int amplitudePhase = 0;
		if (this.amplitudeModRate != null) {
			this.amplitudeModRate.genInit();
			this.amplitudeModRange.genInit();
			amplitudeStart = (int) ((double) (this.amplitudeModRate.end - this.amplitudeModRate.start) * 32.768D / samplesPerStep);
			amplitudeDuration = (int) ((double) this.amplitudeModRate.start * 32.768D / samplesPerStep);
		}

		for (int harmonic = 0; harmonic < 5; harmonic++) {
			if (this.harmonicVolume[harmonic] != 0) {
				fPos[harmonic] = 0;
				fDel[harmonic] = (int) ((double) this.harmonicDelay[harmonic] * samplesPerStep);
				fAmp[harmonic] = (this.harmonicVolume[harmonic] << 14) / 100;
				fMulti[harmonic] = (int) ((double) (this.frequencyBase.end - this.frequencyBase.start) * 32.768D * Math.pow(1.0057929410678534D, (double) this.harmonicSemitone[harmonic]) / samplesPerStep);
				fOffset[harmonic] = (int) ((double) this.frequencyBase.start * 32.768D / samplesPerStep);
			}
		}

		for (int sample = 0; sample < sampleCount; sample++) {
			int frequency = this.frequencyBase.genNext(sampleCount);
			int amplitude = this.amplitudeBase.genNext(sampleCount);

			if (this.frequencyModRate != null) {
				int rate = this.frequencyModRate.genNext(sampleCount);
				int range = this.frequencyModRange.genNext(sampleCount);
				frequency += this.waveFunc(frequencyPhase, range, this.frequencyModRate.form) >> 1;
				frequencyPhase += (frequencyStart * rate >> 16) + frequencyDuration;
			}

			if (this.amplitudeModRate != null) {
				int rate = this.amplitudeModRate.genNext(sampleCount);
				int range = this.amplitudeModRange.genNext(sampleCount);
				amplitude = amplitude * ((this.waveFunc(amplitudePhase, range, this.amplitudeModRate.form) >> 1) + 32768) >> 15;
				amplitudePhase += (amplitudeStart * rate >> 16) + amplitudeDuration;
			}

			for (int harmonic = 0; harmonic < 5; harmonic++) {
				if (this.harmonicVolume[harmonic] != 0) {
					int position = fDel[harmonic] + sample;
					if (position < sampleCount) {
						buf[position] += this.waveFunc(fPos[harmonic], fAmp[harmonic] * amplitude >> 15, this.frequencyBase.form);
						fPos[harmonic] += (fMulti[harmonic] * frequency >> 16) + fOffset[harmonic];
					}
				}
			}
		}

		if (this.release != null) {
			this.release.genInit();
			this.attack.genInit();

			int counter = 0;
			boolean muted = true;

			for (int sample = 0; sample < sampleCount; sample++) {
				int releaseValue = this.release.genNext(sampleCount);
				int attackValue = this.attack.genNext(sampleCount);

				int threshold;
				if (muted) {
					threshold = ((this.release.end - this.release.start) * releaseValue >> 8) + this.release.start;
				} else {
					threshold = ((this.release.end - this.release.start) * attackValue >> 8) + this.release.start;
				}

				counter += 256;
				if (counter >= threshold) {
					counter = 0;
					muted = !muted;
				}

				if (muted) {
					buf[sample] = 0;
				}
			}
		}

		if (this.reverbDelay > 0 && this.reverbVolume > 0) {
			int start = (int) ((double) this.reverbDelay * samplesPerStep);

			for (int sample = start; sample < sampleCount; sample++) {
				buf[sample] += buf[sample - start] * this.reverbVolume / 100;
			}
		}

		if (this.filter.pairs[0] > 0 || this.filter.pairs[1] > 0) {
			this.filterRange.genInit();

			int range = this.filterRange.genNext(sampleCount + 1);
			int forward = this.filter.calculateCoeffs(0, (float) range / 65536.0F);
			int backward = this.filter.calculateCoeffs(1, (float) range / 65536.0F);

			if (sampleCount >= forward + backward) {
				int index = 0;

				int interval = backward;
				if (backward > sampleCount - forward) {
					interval = sampleCount - forward;
				}

				while (index < interval) {
					int sample = (int) ((long) buf[forward + index] * (long) Filter.reduceCoeffInt >> 16);

					for (int offset = 0; offset < forward; offset++) {
						sample += (int) ((long) buf[forward + index - 1 - offset] * (long) Filter.coeffInt[0][offset] >> 16);
					}

					for (int offset = 0; offset < index; offset++) {
						sample -= (int) ((long) buf[index - 1 - offset] * (long) Filter.coeffInt[1][offset] >> 16);
					}

					buf[index] = sample;
					range = this.filterRange.genNext(sampleCount + 1);
					index++;
				}

				interval = 128;
				while (true) {
					if (interval > sampleCount - forward) {
						interval = sampleCount - forward;
					}

					while (index < interval) {
						int sample = (int) ((long) buf[forward + index] * (long) Filter.reduceCoeffInt >> 16);

						for (int offset = 0; offset < forward; offset++) {
							sample += (int) ((long) buf[forward + index - 1 - offset] * (long) Filter.coeffInt[0][offset] >> 16);
						}

						for (int offset = 0; offset < backward; offset++) {
							sample -= (int) ((long) buf[index - 1 - offset] * (long) Filter.coeffInt[1][offset] >> 16);
						}

						buf[index] = sample;
						range = this.filterRange.genNext(sampleCount + 1);
						index++;
					}

					if (index >= sampleCount - forward) {
						while (index < sampleCount) {
							int sample = 0;

							for (int offset = forward + index - sampleCount; offset < forward; offset++) {
								sample += (int) ((long) buf[forward + index - 1 - offset] * (long) Filter.coeffInt[0][offset] >> 16);
							}

							for (int offset = 0; offset < backward; offset++) {
								sample -= (int) ((long) buf[index - 1 - offset] * (long) Filter.coeffInt[1][offset] >> 16);
							}

							buf[index] = sample;
							this.filterRange.genNext(sampleCount + 1);
							index++;
						}

						break;
					}

					forward = this.filter.calculateCoeffs(0, (float) range / 65536.0F);
					backward = this.filter.calculateCoeffs(1, (float) range / 65536.0F);
					interval += 128;
				}
			}
		}

		for (int sample = 0; sample < sampleCount; sample++) {
			if (buf[sample] < -32768) {
				buf[sample] = -32768;
			}
			if (buf[sample] > 32767) {
				buf[sample] = 32767;
			}
		}

		return buf;
	}

	// jag::oldscape::sound::Tone::WaveFunc
	@ObfuscatedName("t.d(III)I")
	public final int waveFunc(int phase, int amplitude, int form) {
		if (form == 1) {
			return (phase & 0x7FFF) < 16384 ? amplitude : -amplitude;
		} else if (form == 2) {
			return sine[phase & 0x7FFF] * amplitude >> 14;
		} else if (form == 3) {
			return ((phase & 0x7FFF) * amplitude >> 14) - amplitude;
		} else if (form == 4) {
			return noise[phase / 2607 & 0x7FFF] * amplitude;
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
