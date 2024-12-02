package jagex2.client;

import deob.ObfuscatedName;
import java.awt.Component;

@ObfuscatedName("ac")
public abstract class MouseWheelProvider {

	@ObfuscatedName("bv.r(I)Lac;")
	public static MouseWheelProvider method779() {
		try {
			return new JavaMouseWheelProvider();
		} catch (Throwable var1) {
			return null;
		}
	}

	@ObfuscatedName("ac.d(Ljava/awt/Component;I)V")
	public abstract void method360(Component arg0);

	@ObfuscatedName("ac.l(Ljava/awt/Component;B)V")
	public abstract void method361(Component arg0);

	@ObfuscatedName("ac.m(I)I")
	public abstract int method362();
}
