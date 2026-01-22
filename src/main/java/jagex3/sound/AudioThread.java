package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.client.JagException;
import jagex3.client.SignLink;
import jagex3.datastruct.PreciseSleep;

@ObfuscatedName("f")
public class AudioThread implements Runnable {

	@ObfuscatedName("f.r")
	public SignLink signLink;

	@ObfuscatedName("f.d")
	public volatile PcmPlayer[] players = new PcmPlayer[2];

	@ObfuscatedName("f.l")
	public volatile boolean shutdown = false;

	@ObfuscatedName("f.m")
	public volatile boolean running = false;

	public void run() {
		this.running = true;
		try {
			while (!this.shutdown) {
				for (int var1 = 0; var1 < 2; var1++) {
					PcmPlayer var2 = this.players[var1];
					if (var2 != null) {
						var2.cycle();
					}
				}
				PreciseSleep.sleep(10L);
				SignLink.flushEvents(signLink, null);
			}
		} catch (Exception ex) {
			JagException.report(null, ex);
		} finally {
			this.running = false;
		}
	}
}
