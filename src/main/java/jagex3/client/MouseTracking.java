package jagex3.client;

import deob.ObfuscatedName;
import jagex3.client.input.mouse.ClientMouseListener;
import jagex3.util.ThreadSleep;

@ObfuscatedName("j")
public class MouseTracking implements Runnable {

	@ObfuscatedName("j.r")
	public boolean active = true;

	@ObfuscatedName("j.d")
	public final Object lock = new Object();

	@ObfuscatedName("j.l")
	public int length = 0;

	@ObfuscatedName("j.m")
	public int[] x = new int[500];

	@ObfuscatedName("j.c")
	public int[] y = new int[500];

	public void run() {
		while (this.active) {
			synchronized (this.lock) {
				if (this.length < 500) {
					this.x[this.length] = ClientMouseListener.mouseX;
					this.y[this.length] = ClientMouseListener.mouseY;
					this.length++;
				}
			}

			ThreadSleep.sleepPrecise(50L);
		}
	}
}
