package jagex2.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("bq")
public class PreciseSleep {

	public PreciseSleep() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("cl.r(J)V")
	public static final void method1020(long arg0) {
		if (arg0 <= 0L) {
			return;
		}
		if (arg0 % 10L == 0L) {
			method1487(arg0 - 1L);
			method1487(1L);
		} else {
			method1487(arg0);
		}
	}

	@ObfuscatedName("dr.d(J)V")
	public static final void method1487(long arg0) {
		try {
			Thread.sleep(arg0);
		} catch (InterruptedException var3) {
		}
	}
}
