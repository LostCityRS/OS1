package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("bq")
public class ThreadSleep {

	public ThreadSleep() throws Throwable {
		throw new Error();
	}

	// jag::this_thread::SleepPrecise
	@ObfuscatedName("cl.r(J)V")
	public static void sleepPrecise(long ms) {
		if (ms <= 0L) {
			return;
		}

		if (ms % 10L == 0L) {
			sleep(ms - 1L);
			sleep(1L);
		} else {
			sleep(ms);
		}
	}

	// jag::this_thread::Sleep
	@ObfuscatedName("dr.d(J)V")
	public static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ignore) {
		}
	}
}
