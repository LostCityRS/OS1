package jagex2.graphics;

import deob.ObfuscatedName;

import java.awt.*;
import java.awt.image.*;
import java.util.Hashtable;

@ObfuscatedName("di")
public class BufferedPixMap extends PixMap {

	@ObfuscatedName("di.c")
	public Component component;

	@ObfuscatedName("di.r(IILjava/awt/Component;I)V")
	public final void create(int arg0, int arg1, Component arg2) {
		this.width = arg0;
		this.height = arg1;
		this.data = new int[arg0 * arg1 + 1];
		DataBufferInt var4 = new DataBufferInt(this.data, this.data.length);
		DirectColorModel var5 = new DirectColorModel(32, 0xff0000, 0xff00, 0xff);
		WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(this.width, this.height), var4, null);
		this.image = new BufferedImage(var5, var6, false, new Hashtable());
		this.component = arg2;
		this.bind();
	}

	@ObfuscatedName("di.l(Ljava/awt/Graphics;III)V")
	public final void draw(Graphics arg0, int arg1, int arg2) {
		arg0.drawImage(this.image, arg1, arg2, this.component);
	}

	@ObfuscatedName("di.m(Ljava/awt/Graphics;IIIII)V")
	public final void draw(Graphics arg0, int arg1, int arg2, int arg3, int arg4) {
		Shape var6 = arg0.getClip();
		arg0.clipRect(arg1, arg2, arg3, arg4);
		arg0.drawImage(this.image, 0, 0, this.component);
		arg0.setClip(var6);
	}
}
