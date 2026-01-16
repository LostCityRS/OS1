package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.client.JagException;
import jagex3.client.TaskHandler;
import jagex3.datastruct.PreciseSleep;

import java.awt.event.ActionEvent;

@ObfuscatedName("f")
public class AudioThread implements Runnable {

	@ObfuscatedName("f.r")
	public TaskHandler field290;

	@ObfuscatedName("f.d")
	public volatile AudioChannel[] field293 = new AudioChannel[2];

	@ObfuscatedName("f.l")
	public volatile boolean field292 = false;

	@ObfuscatedName("f.m")
	public volatile boolean field291 = false;

	public void run() {
		this.field291 = true;
		try {
			while (!this.field292) {
				for (int var1 = 0; var1 < 2; var1++) {
					AudioChannel var2 = this.field293[var1];
					if (var2 != null) {
						var2.method235();
					}
				}
				PreciseSleep.sleep(10L);
				TaskHandler var3 = this.field290;
				Object var4 = null;
				if (var3.eventQueue != null) {
					for (int var5 = 0; var5 < 50 && var3.eventQueue.peekEvent() != null; var5++) {
						PreciseSleep.sleep(1L);
					}
					if (var4 != null) {
						var3.eventQueue.postEvent(new ActionEvent(var4, 1001, "dummy"));
					}
				}
			}
		} catch (Exception var10) {
			JagException.report(null, (Throwable) var10);
		} finally {
			this.field291 = false;
		}
	}
}
