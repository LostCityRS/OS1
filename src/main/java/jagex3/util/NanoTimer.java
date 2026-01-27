package jagex3.util;

import deob.ObfuscatedName;

@ObfuscatedName("dp")
public class NanoTimer extends Timer {

	@ObfuscatedName("dp.r")
	public long ntime = System.nanoTime();

	@ObfuscatedName("dp.r(I)V")
	public void reset() {
		this.ntime = System.nanoTime();
	}

	@ObfuscatedName("dp.d(IIB)I")
	public int count(int deltime, int mindel) {
		long mindelNs = (long) mindel * 1000000L;
		long delta = this.ntime - System.nanoTime();

		if (delta < mindelNs) {
			delta = mindelNs;
		}

		ThreadSleep.sleepPrecise(delta / 1000000L);

		long now = System.nanoTime();

		int loops = 0;
		while (loops < 10 && (loops < 1 || this.ntime < now)) {
			loops++;
			this.ntime += (long) deltime * 1000000L;
		}

		if (this.ntime < now) {
			this.ntime = now;
		}

		return loops;
	}
}
