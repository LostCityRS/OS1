package jagex2.client;

import deob.ObfuscatedName;
import jagex2.datastruct.PreciseSleep;

@ObfuscatedName("j")
public class MouseTracking implements Runnable {

	@ObfuscatedName("j.r")
	public boolean field115 = true;

	@ObfuscatedName("j.d")
	public Object field119 = new Object();

	@ObfuscatedName("j.l")
	public int field117 = 0;

	@ObfuscatedName("j.m")
	public int[] field118 = new int[500];

	@ObfuscatedName("j.c")
	public int[] field116 = new int[500];

	public void run() {
		while (this.field115) {
			Object var1 = this.field119;
			synchronized (this.field119) {
				if (this.field117 < 500) {
					this.field118[this.field117] = JavaMouseProvider.field488;
					this.field116[this.field117] = JavaMouseProvider.field492;
					this.field117++;
				}
			}
			PreciseSleep.method1020(50L);
		}
	}
}
