package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("bx")
public class MonotonicTime {

	@ObfuscatedName("bx.r")
	public static long leapMillis;

	@ObfuscatedName("bx.d")
	public static long previous;

	public MonotonicTime() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("cm.r(I)J")
	public static synchronized long currentTime() {
		long var0 = System.currentTimeMillis();
		if (var0 < leapMillis) {
			previous += leapMillis - var0;
		}
		leapMillis = var0;
		return previous + var0;
	}
}
