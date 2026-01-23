package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("dp")
public class NanoTimer extends Timer {

	@ObfuscatedName("dp.r")
	public long field1565 = System.nanoTime();

	@ObfuscatedName("dp.r(I)V")
	public void reset() {
		this.field1565 = System.nanoTime();
	}

	@ObfuscatedName("dp.d(IIB)I")
	public int count(int arg0, int arg1) {
		long var3 = (long) arg1 * 1000000L;
		long var5 = this.field1565 - System.nanoTime();
		if (var5 < var3) {
			var5 = var3;
		}
		ThreadSleep.sleepPrecise(var5 / 1000000L);
		long var7 = System.nanoTime();
		int var9 = 0;
		while (var9 < 10 && (var9 < 1 || this.field1565 < var7)) {
			var9++;
			this.field1565 += (long) arg0 * 1000000L;
		}
		if (this.field1565 < var7) {
			this.field1565 = var7;
		}
		return var9;
	}
}
