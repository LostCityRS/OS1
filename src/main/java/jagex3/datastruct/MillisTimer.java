package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("dc")
public class MillisTimer extends Timer {

	@ObfuscatedName("dc.r")
	public long[] field1561 = new long[10];

	@ObfuscatedName("dc.d")
	public int field1559 = 256;

	@ObfuscatedName("dc.l")
	public int field1560 = 1;

	@ObfuscatedName("dc.m")
	public long field1563 = MonotonicTime.currentTime();

	@ObfuscatedName("dc.c")
	public int field1562 = 0;

	@ObfuscatedName("dc.n")
	public int field1558;

	public MillisTimer() {
		for (int var1 = 0; var1 < 10; var1++) {
			this.field1561[var1] = this.field1563;
		}
	}

	@ObfuscatedName("dc.r(I)V")
	public void reset() {
		for (int var1 = 0; var1 < 10; var1++) {
			this.field1561[var1] = 0L;
		}
	}

	@ObfuscatedName("dc.d(IIB)I")
	public int count(int arg0, int arg1) {
		int var3 = this.field1559;
		int var4 = this.field1560;
		this.field1559 = 300;
		this.field1560 = 1;
		this.field1563 = MonotonicTime.currentTime();
		if (this.field1561[this.field1558] == 0L) {
			this.field1559 = var3;
			this.field1560 = var4;
		} else if (this.field1563 > this.field1561[this.field1558]) {
			this.field1559 = (int) ((long) (arg0 * 2560) / (this.field1563 - this.field1561[this.field1558]));
		}
		if (this.field1559 < 25) {
			this.field1559 = 25;
		}
		if (this.field1559 > 256) {
			this.field1559 = 256;
			this.field1560 = (int) ((long) arg0 - (this.field1563 - this.field1561[this.field1558]) / 10L);
		}
		if (this.field1560 > arg0) {
			this.field1560 = arg0;
		}
		this.field1561[this.field1558] = this.field1563;
		this.field1558 = (this.field1558 + 1) % 10;
		if (this.field1560 > 1) {
			for (int var5 = 0; var5 < 10; var5++) {
				if (this.field1561[var5] != 0L) {
					this.field1561[var5] += this.field1560;
				}
			}
		}
		if (this.field1560 < arg1) {
			this.field1560 = arg1;
		}
		ThreadSleep.sleepPrecise((long) this.field1560);
		int var6 = 0;
		while (this.field1562 < 256) {
			var6++;
			this.field1562 += this.field1559;
		}
		this.field1562 &= 0xFF;
		return var6;
	}
}
