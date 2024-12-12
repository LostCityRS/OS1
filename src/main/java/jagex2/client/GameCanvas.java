package jagex2.client;

import deob.ObfuscatedName;

import java.awt.*;

@ObfuscatedName("fk")
public class GameCanvas extends Canvas {

	@ObfuscatedName("fk.r")
	public Component component;

	public GameCanvas(Component c) {
		this.component = c;
	}

	public final void update(Graphics g) {
		this.component.update(g);
	}

	public final void paint(Graphics g) {
		this.component.paint(g);
	}
}
