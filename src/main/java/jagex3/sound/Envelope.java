package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.io.Packet;

// jag::oldscape::sound::Envelope
@ObfuscatedName("k")
public class Envelope {

	@ObfuscatedName("k.r")
	public int length = 2;

	@ObfuscatedName("k.d")
	public int[] shapeDelta = new int[2];

	@ObfuscatedName("k.l")
	public int[] shapePeak = new int[2];

	@ObfuscatedName("k.m")
	public int start;

	@ObfuscatedName("k.c")
	public int end;

	@ObfuscatedName("k.n")
	public int form;

	@ObfuscatedName("k.j")
	public int threshold;

	@ObfuscatedName("k.z")
	public int position;

	@ObfuscatedName("k.g")
	public int delta;

	@ObfuscatedName("k.q")
	public int amplitude;

	@ObfuscatedName("k.i")
	public int ticks;

	public Envelope() {
		this.shapeDelta[0] = 0;
		this.shapeDelta[1] = 65535;
		this.shapePeak[0] = 0;
		this.shapePeak[1] = 65535;
	}

	@ObfuscatedName("k.r(Lev;)V")
	public final void load(Packet arg0) {
		this.form = arg0.g1();
		this.start = arg0.g4();
		this.end = arg0.g4();
		this.loadPoints(arg0);
	}

	// jag::oldscape::sound::Envelope::LoadPoints
	@ObfuscatedName("k.d(Lev;)V")
	public final void loadPoints(Packet arg0) {
		this.length = arg0.g1();
		this.shapeDelta = new int[this.length];
		this.shapePeak = new int[this.length];
		for (int var2 = 0; var2 < this.length; var2++) {
			this.shapeDelta[var2] = arg0.g2();
			this.shapePeak[var2] = arg0.g2();
		}
	}

	// jag::oldscape::sound::Envelope::GenInit
	@ObfuscatedName("k.l()V")
	public final void genInit() {
		this.threshold = 0;
		this.position = 0;
		this.delta = 0;
		this.amplitude = 0;
		this.ticks = 0;
	}

	// jag::oldscape::sound::Envelope::GenNext
	@ObfuscatedName("k.m(I)I")
	public final int genNext(int arg0) {
		if (this.ticks >= this.threshold) {
			this.amplitude = this.shapePeak[this.position++] << 15;
			if (this.position >= this.length) {
				this.position = this.length - 1;
			}
			this.threshold = (int) ((double) this.shapeDelta[this.position] / 65536.0D * (double) arg0);
			if (this.threshold > this.ticks) {
				this.delta = ((this.shapePeak[this.position] << 15) - this.amplitude) / (this.threshold - this.ticks);
			}
		}
		this.amplitude += this.delta;
		this.ticks++;
		return this.amplitude - this.delta >> 15;
	}
}
