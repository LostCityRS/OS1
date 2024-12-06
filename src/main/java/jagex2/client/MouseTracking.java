package jagex2.client;

import deob.ObfuscatedName;
import jagex2.datastruct.PreciseSleep;

@ObfuscatedName("j")
public class MouseTracking implements Runnable {

	@ObfuscatedName("j.r")
	public boolean active = true;

	@ObfuscatedName("j.d")
	public Object lock = new Object();

	@ObfuscatedName("j.l")
	public int length = 0;

	@ObfuscatedName("j.m")
	public int[] x = new int[500];

	@ObfuscatedName("j.c")
	public int[] y = new int[500];

	public void run() {
		while (this.active) {
			Object var1 = this.lock;
			synchronized (this.lock) {
				if (this.length < 500) {
					this.x[this.length] = JavaMouseProvider.mouseX;
					this.y[this.length] = JavaMouseProvider.mouseY;
					this.length++;
				}
			}
			PreciseSleep.sleep(50L);
		}
	}
}
