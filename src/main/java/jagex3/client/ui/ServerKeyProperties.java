package jagex3.client.ui;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable;

// jag::ui::ServerKeyProperties (?)
@ObfuscatedName("el")
public class ServerKeyProperties extends Linkable {

	@ObfuscatedName("el.m")
	public int events;

	public ServerKeyProperties(int events) {
		this.events = events;
	}
}
