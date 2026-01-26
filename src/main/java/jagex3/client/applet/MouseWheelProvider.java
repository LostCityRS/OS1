package jagex3.client.applet;

import deob.ObfuscatedName;

import java.awt.*;

@ObfuscatedName("ac")
public abstract class MouseWheelProvider {

	@ObfuscatedName("bv.r(I)Lac;")
	public static MouseWheelProvider getProvider() {
		try {
			return new JavaMouseWheelProvider();
		} catch (Throwable ex) {
			return null;
		}
	}

	@ObfuscatedName("ac.d(Ljava/awt/Component;I)V")
	public abstract void addListeners(Component c);

	@ObfuscatedName("ac.l(Ljava/awt/Component;B)V")
	public abstract void removeListeners(Component c);

	@ObfuscatedName("ac.m(I)I")
	public abstract int getRotation();
}
