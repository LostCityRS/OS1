package jagex3.graphics;

import deob.ObfuscatedName;

import java.awt.*;
import java.awt.image.*;

@ObfuscatedName("dm")
public class JavaSafePixMap extends PixMap implements ImageProducer, ImageObserver {

	@ObfuscatedName("dm.c")
	public ColorModel colorModel;

	@ObfuscatedName("dm.n")
	public ImageConsumer consumer;

	@ObfuscatedName("dm.r(IILjava/awt/Component;I)V")
	public final void create(int w, int h, Component c) {
		this.width = w;
		this.height = h;
		this.data = new int[w * h + 1];
		this.colorModel = new DirectColorModel(32, 16711680, 65280, 255);
		this.image = c.createImage(this);

		this.setPixels();
		c.prepareImage(this.image, this);

		this.setPixels();
		c.prepareImage(this.image, this);

		this.setPixels();
		c.prepareImage(this.image, this);

		this.bind();
	}

	@ObfuscatedName("dm.l(Ljava/awt/Graphics;III)V")
	public final void draw(Graphics g, int x, int y) {
		this.setPixels();
		g.drawImage(this.image, x, y, this);
	}

	@ObfuscatedName("dm.m(Ljava/awt/Graphics;IIIII)V")
	public final void draw(Graphics g, int x, int y, int w, int h) {
		this.setPixels(x, y, w, h);
		Shape save = g.getClip();
		g.clipRect(x, y, w, h);
		g.drawImage(this.image, 0, 0, this);
		g.setClip(save);
	}

	public synchronized void addConsumer(ImageConsumer arg0) {
		this.consumer = arg0;
		arg0.setDimensions(this.width, this.height);
		arg0.setProperties(null);
		arg0.setColorModel(this.colorModel);
		arg0.setHints(14);
	}

	public synchronized boolean isConsumer(ImageConsumer arg0) {
		return this.consumer == arg0;
	}

	public synchronized void removeConsumer(ImageConsumer arg0) {
		if (this.consumer == arg0) {
			this.consumer = null;
		}
	}

	public void startProduction(ImageConsumer arg0) {
		this.addConsumer(arg0);
	}

	public void requestTopDownLeftRightResend(ImageConsumer arg0) {
	}

	@ObfuscatedName("dm.v(I)V")
	public synchronized void setPixels() {
		if (this.consumer != null) {
			this.consumer.setPixels(0, 0, this.width, this.height, this.colorModel, this.data, 0, this.width);
			this.consumer.imageComplete(2);
		}
	}

	@ObfuscatedName("dm.w(IIIIB)V")
	public synchronized void setPixels(int arg0, int arg1, int arg2, int arg3) {
		if (this.consumer != null) {
			this.consumer.setPixels(arg0, arg1, arg2, arg3, this.colorModel, this.data, this.width * arg1 + arg0, this.width);
			this.consumer.imageComplete(2);
		}
	}

	public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		return true;
	}
}
