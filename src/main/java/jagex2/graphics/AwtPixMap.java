package jagex2.graphics;

import deob.ObfuscatedName;

import java.awt.*;
import java.awt.image.*;

@ObfuscatedName("dm")
public class AwtPixMap extends PixMap implements ImageProducer, ImageObserver {

	@ObfuscatedName("dm.c")
	public ColorModel field1566;

	@ObfuscatedName("dm.n")
	public ImageConsumer field1567;

	@ObfuscatedName("dm.r(IILjava/awt/Component;I)V")
	public final void method548(int arg0, int arg1, Component arg2) {
		this.field541 = arg0;
		this.field540 = arg1;
		this.field538 = new int[arg0 * arg1 + 1];
		this.field1566 = new DirectColorModel(32, 16711680, 65280, 255);
		this.field539 = arg2.createImage(this);
		this.method1448();
		arg2.prepareImage(this.field539, this);
		this.method1448();
		arg2.prepareImage(this.field539, this);
		this.method1448();
		arg2.prepareImage(this.field539, this);
		this.method544();
	}

	@ObfuscatedName("dm.l(Ljava/awt/Graphics;III)V")
	public final void method545(Graphics arg0, int arg1, int arg2) {
		this.method1448();
		arg0.drawImage(this.field539, arg1, arg2, this);
	}

	@ObfuscatedName("dm.m(Ljava/awt/Graphics;IIIII)V")
	public final void method546(Graphics arg0, int arg1, int arg2, int arg3, int arg4) {
		this.method1449(arg1, arg2, arg3, arg4);
		Shape var6 = arg0.getClip();
		arg0.clipRect(arg1, arg2, arg3, arg4);
		arg0.drawImage(this.field539, 0, 0, this);
		arg0.setClip(var6);
	}

	public synchronized void addConsumer(ImageConsumer arg0) {
		this.field1567 = arg0;
		arg0.setDimensions(this.field541, this.field540);
		arg0.setProperties(null);
		arg0.setColorModel(this.field1566);
		arg0.setHints(14);
	}

	public synchronized boolean isConsumer(ImageConsumer arg0) {
		return this.field1567 == arg0;
	}

	public synchronized void removeConsumer(ImageConsumer arg0) {
		if (this.field1567 == arg0) {
			this.field1567 = null;
		}
	}

	public void startProduction(ImageConsumer arg0) {
		this.addConsumer(arg0);
	}

	public void requestTopDownLeftRightResend(ImageConsumer arg0) {
	}

	@ObfuscatedName("dm.v(I)V")
	public synchronized void method1448() {
		if (this.field1567 != null) {
			this.field1567.setPixels(0, 0, this.field541, this.field540, this.field1566, this.field538, 0, this.field541);
			this.field1567.imageComplete(2);
		}
	}

	@ObfuscatedName("dm.w(IIIIB)V")
	public synchronized void method1449(int arg0, int arg1, int arg2, int arg3) {
		if (this.field1567 != null) {
			this.field1567.setPixels(arg0, arg1, arg2, arg3, this.field1566, this.field538, this.field541 * arg1 + arg0, this.field541);
			this.field1567.imageComplete(2);
		}
	}

	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		return true;
	}
}
