package jagex2.graphics;

import deob.ObfuscatedName;

import java.awt.*;

@ObfuscatedName("ab")
public abstract class PixMap {

	@ObfuscatedName("ab.r")
	public int[] field538;

	@ObfuscatedName("ab.d")
	public int field541;

	@ObfuscatedName("ab.l")
	public int field540;

	@ObfuscatedName("ab.m")
	public Image field539;

	@ObfuscatedName("ab.d(I)V")
	public final void method544() {
		Pix2D.method2583(this.field538, this.field541, this.field540);
	}

	@ObfuscatedName("ab.l(Ljava/awt/Graphics;III)V")
	public abstract void method545(Graphics arg0, int arg1, int arg2);

	@ObfuscatedName("ab.m(Ljava/awt/Graphics;IIIII)V")
	public abstract void method546(Graphics arg0, int arg1, int arg2, int arg3, int arg4);

	@ObfuscatedName("ab.r(IILjava/awt/Component;I)V")
	public abstract void method548(int arg0, int arg1, Component arg2);
}
