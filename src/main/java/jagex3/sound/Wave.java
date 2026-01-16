package jagex3.sound;

import deob.ObfuscatedName;

// jag::oldscape::sound::Wave
@ObfuscatedName("eq")
public class Wave extends PcmStreamable {

	@ObfuscatedName("eq.c")
	public int samplingFrequency;

	@ObfuscatedName("eq.n")
	public byte[] samples;

	@ObfuscatedName("eq.j")
	public int loopStartPosition;

	@ObfuscatedName("eq.z")
	public int loopEndPosition;

	@ObfuscatedName("eq.g")
	public boolean loopReversed;

	public Wave(int arg0, byte[] arg1, int arg2, int arg3) {
		this.samplingFrequency = arg0;
		this.samples = arg1;
		this.loopStartPosition = arg2;
		this.loopEndPosition = arg3;
	}

	public Wave(int arg0, byte[] arg1, int arg2, int arg3, boolean arg4) {
		this.samplingFrequency = arg0;
		this.samples = arg1;
		this.loopStartPosition = arg2;
		this.loopEndPosition = arg3;
		this.loopReversed = arg4;
	}

	@ObfuscatedName("eq.c(Lp;)Leq;")
	public Wave decimate(Decimator d) {
		this.samples = d.decimate(this.samples);
		this.samplingFrequency = d.transmitFreq(this.samplingFrequency);
		if (this.loopEndPosition == this.loopStartPosition) {
			this.loopStartPosition = this.loopEndPosition = d.transmitPos(this.loopStartPosition);
		} else {
			this.loopStartPosition = d.transmitPos(this.loopStartPosition);
			this.loopEndPosition = d.transmitPos(this.loopEndPosition);
			if (this.loopEndPosition == this.loopStartPosition) {
				this.loopStartPosition--;
			}
		}
		return this;
	}
}
