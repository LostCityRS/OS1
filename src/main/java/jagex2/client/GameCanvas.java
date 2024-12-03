package jagex2.client;

import deob.ObfuscatedName;

import java.awt.*;

@ObfuscatedName("fk")
public class GameCanvas extends Canvas {

	@ObfuscatedName("fk.r")
	public Component component;

	public GameCanvas(Component arg0) {
		this.component = arg0;
	}

	public final void update(Graphics arg0) {
		this.component.update(arg0);
	}

	public final void paint(Graphics arg0) {
		this.component.paint(arg0);
	}
}
