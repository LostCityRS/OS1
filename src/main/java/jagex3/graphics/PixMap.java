package jagex3.graphics;

import deob.ObfuscatedName;

import java.awt.*;

@ObfuscatedName("ab")
public abstract class PixMap {

	@ObfuscatedName("ab.r")
	public int[] data;

	@ObfuscatedName("ab.d")
	public int width;

	@ObfuscatedName("ab.l")
	public int height;

	@ObfuscatedName("ab.m")
	public Image image;

	@ObfuscatedName("ab.d(I)V")
	public final void bind() {
		Pix2D.bind(this.data, this.width, this.height);
	}

	@ObfuscatedName("ab.l(Ljava/awt/Graphics;III)V")
	public abstract void draw(Graphics arg0, int arg1, int arg2);

	@ObfuscatedName("ab.m(Ljava/awt/Graphics;IIIII)V")
	public abstract void draw(Graphics arg0, int arg1, int arg2, int arg3, int arg4);

	@ObfuscatedName("ab.r(IILjava/awt/Component;I)V")
	public abstract void create(int arg0, int arg1, Component arg2);
}
