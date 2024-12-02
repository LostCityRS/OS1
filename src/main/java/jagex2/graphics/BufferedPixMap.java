package jagex2.graphics;

import deob.ObfuscatedName;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

@ObfuscatedName("di")
public class BufferedPixMap extends PixMap {

	@ObfuscatedName("di.c")
	public Component field1570;

	@ObfuscatedName("di.r(IILjava/awt/Component;I)V")
	public final void method548(int arg0, int arg1, Component arg2) {
		this.field541 = arg0;
		this.field540 = arg1;
		this.field538 = new int[arg0 * arg1 + 1];
		DataBufferInt var4 = new DataBufferInt(this.field538, this.field538.length);
		DirectColorModel var5 = new DirectColorModel(32, 16711680, 65280, 255);
		WritableRaster var6 = Raster.createWritableRaster(var5.createCompatibleSampleModel(this.field541, this.field540), var4, null);
		this.field539 = new BufferedImage(var5, var6, false, new Hashtable());
		this.field1570 = arg2;
		this.method544();
	}

	@ObfuscatedName("di.l(Ljava/awt/Graphics;III)V")
	public final void method545(Graphics arg0, int arg1, int arg2) {
		arg0.drawImage(this.field539, arg1, arg2, this.field1570);
	}

	@ObfuscatedName("di.m(Ljava/awt/Graphics;IIIII)V")
	public final void method546(Graphics arg0, int arg1, int arg2, int arg3, int arg4) {
		Shape var6 = arg0.getClip();
		arg0.clipRect(arg1, arg2, arg3, arg4);
		arg0.drawImage(this.field539, 0, 0, this.field1570);
		arg0.setClip(var6);
	}
}
