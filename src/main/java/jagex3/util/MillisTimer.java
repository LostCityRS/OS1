package jagex3.util;

import deob.ObfuscatedName;

@ObfuscatedName("dc")
public class MillisTimer extends Timer {

	// field names from old rs2 applet strings

	@ObfuscatedName("dc.r")
	public long[] otim = new long[10];

	@ObfuscatedName("dc.d")
	public int ratio = 256;

	@ObfuscatedName("dc.l")
	public int delta = 1;

	@ObfuscatedName("dc.m")
	public long ntime = MonotonicTime.currentTime();

	@ObfuscatedName("dc.c")
	public int count = 0;

	@ObfuscatedName("dc.n")
	public int opos;

	public MillisTimer() {
		for (int i = 0; i < 10; i++) {
			this.otim[i] = this.ntime;
		}
	}

	@ObfuscatedName("dc.r(I)V")
	public void reset() {
		for (int i = 0; i < 10; i++) {
			this.otim[i] = 0L;
		}
	}

	@ObfuscatedName("dc.d(IIB)I")
	public int count(int deltime, int mindel) {
		int lastRatio = this.ratio;
		int lastDelta = this.delta;

		this.ratio = 300;
		this.delta = 1;
		this.ntime = MonotonicTime.currentTime();

		if (this.otim[this.opos] == 0L) {
			this.ratio = lastRatio;
			this.delta = lastDelta;
		} else if (this.ntime > this.otim[this.opos]) {
			this.ratio = (int) ((long) (deltime * 2560) / (this.ntime - this.otim[this.opos]));
		}

		if (this.ratio < 25) {
			this.ratio = 25;
		}

		if (this.ratio > 256) {
			this.ratio = 256;
			this.delta = (int) ((long) deltime - (this.ntime - this.otim[this.opos]) / 10L);
		}

		if (this.delta > deltime) {
			this.delta = deltime;
		}

		this.otim[this.opos] = this.ntime;
		this.opos = (this.opos + 1) % 10;

		if (this.delta > 1) {
			for (int i = 0; i < 10; i++) {
				if (this.otim[i] != 0L) {
					this.otim[i] += this.delta;
				}
			}
		}

		if (this.delta < mindel) {
			this.delta = mindel;
		}

		ThreadSleep.sleepPrecise((long) this.delta);

		int loops = 0;
		while (this.count < 256) {
			loops++;
			this.count += this.ratio;
		}

		this.count &= 0xFF;
		return loops;
	}
}
