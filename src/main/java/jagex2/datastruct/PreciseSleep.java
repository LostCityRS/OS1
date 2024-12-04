package jagex2.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("bq")
public class PreciseSleep {

	public PreciseSleep() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("cl.r(J)V")
	public static final void sleep(long ms) {
		if (ms <= 0L) {
			return;
		}

		if (ms % 10L == 0L) {
			threadSleep(ms - 1L);
			threadSleep(1L);
		} else {
			threadSleep(ms);
		}
	}

	@ObfuscatedName("dr.d(J)V")
	public static final void threadSleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ignore) {
		}
	}
}
