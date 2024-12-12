package jagex3.client.applet;

import deob.ObfuscatedName;

import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

@ObfuscatedName("dh")
public class JavaMouseWheelProvider extends MouseWheelProvider implements MouseWheelListener {

	@ObfuscatedName("dh.r")
	public int field1557 = 0;

	@ObfuscatedName("dh.d(Ljava/awt/Component;I)V")
	public void method360(Component arg0) {
		arg0.addMouseWheelListener(this);
	}

	@ObfuscatedName("dh.l(Ljava/awt/Component;B)V")
	public void method361(Component arg0) {
		arg0.removeMouseWheelListener(this);
	}

	public synchronized void mouseWheelMoved(MouseWheelEvent arg0) {
		this.field1557 += arg0.getWheelRotation();
	}

	@ObfuscatedName("dh.m(I)I")
	public synchronized int method362() {
		int var1 = this.field1557;
		this.field1557 = 0;
		return var1;
	}
}
