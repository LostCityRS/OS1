package jagex3.client.input.mouse;

import deob.ObfuscatedName;

import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

@ObfuscatedName("dh")
public class ClientMouseWheelListener extends MouseWheelInterface implements MouseWheelListener {

	@ObfuscatedName("dh.r")
	public int rotation = 0;

	@ObfuscatedName("dh.d(Ljava/awt/Component;I)V")
	public void addListeners(Component c) {
		c.addMouseWheelListener(this);
	}

	@ObfuscatedName("dh.l(Ljava/awt/Component;B)V")
	public void removeListeners(Component c) {
		c.removeMouseWheelListener(this);
	}

	public synchronized void mouseWheelMoved(MouseWheelEvent e) {
		this.rotation += e.getWheelRotation();
	}

	@ObfuscatedName("dh.m(I)I")
	public synchronized int getRotation() {
		int total = this.rotation;
		this.rotation = 0;
		return total;
	}
}
