package jagex3.client.input.mouse;

import deob.ObfuscatedName;

import java.awt.*;

@ObfuscatedName("ac")
public abstract class MouseWheelInterface {

	@ObfuscatedName("bv.r(I)Lac;")
	public static MouseWheelInterface getProvider() {
		try {
			return new ClientMouseWheelListener();
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
