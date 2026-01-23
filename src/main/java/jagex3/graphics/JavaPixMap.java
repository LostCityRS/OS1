package jagex3.graphics;

import deob.ObfuscatedName;

import java.awt.*;
import java.awt.image.*;
import java.util.Hashtable;

@ObfuscatedName("di")
public class JavaPixMap extends PixMap {

	@ObfuscatedName("di.c")
	public Component component;

	@ObfuscatedName("di.r(IILjava/awt/Component;I)V")
	public final void create(int w, int h, Component c) {
		this.width = w;
		this.height = h;
		this.data = new int[w * h + 1];
		DataBufferInt var4 = new DataBufferInt(this.data, this.data.length);
		DirectColorModel var5 = new DirectColorModel(32, 0xff0000, 0xff00, 0xff);
		WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(this.width, this.height), var4, null);
		this.image = new BufferedImage(var5, var6, false, new Hashtable());
		this.component = c;
		this.bind();
	}

	@ObfuscatedName("di.l(Ljava/awt/Graphics;III)V")
	public final void draw(Graphics g, int x, int y) {
		g.drawImage(this.image, x, y, this.component);
	}

	@ObfuscatedName("di.m(Ljava/awt/Graphics;IIIII)V")
	public final void draw(Graphics g, int x, int y, int w, int h) {
		Shape save = g.getClip();
		g.clipRect(x, y, w, h);
		g.drawImage(this.image, 0, 0, this.component);
		g.setClip(save);
	}
}
