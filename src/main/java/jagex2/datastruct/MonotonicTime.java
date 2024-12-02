package jagex2.datastruct;

import deob.ObfuscatedName;
import deob.Statics;

@ObfuscatedName("bx")
public class MonotonicTime {

	public MonotonicTime() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("cm.r(I)J")
	public static synchronized long method1135() {
		long var0 = System.currentTimeMillis();
		if (var0 < Statics.field809) {
			Statics.field810 += Statics.field809 - var0;
		}
		Statics.field809 = var0;
		return Statics.field810 + var0;
	}
}
