package jagex2.client;

import deob.ObfuscatedName;

import java.awt.*;

@ObfuscatedName("fk")
public class GameCanvas extends Canvas {

	@ObfuscatedName("fk.r")
	public Component field2493;

	public GameCanvas(Component arg0) {
		this.field2493 = arg0;
	}

	public final void update(Graphics arg0) {
		this.field2493.update(arg0);
	}

	public final void paint(Graphics arg0) {
		this.field2493.paint(arg0);
	}
}
