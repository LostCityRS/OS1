package jagex2.datastruct.time;

import deob.ObfuscatedName;

@ObfuscatedName("bx")
public class MonotonicTime {

	@ObfuscatedName("bx.r")
	public static long field809;

	@ObfuscatedName("bx.d")
	public static long field810;

	public MonotonicTime() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("cm.r(I)J")
	public static synchronized long method1135() {
		long var0 = System.currentTimeMillis();
		if (var0 < field809) {
			field810 += field809 - var0;
		}
		field809 = var0;
		return field810 + var0;
	}
}
