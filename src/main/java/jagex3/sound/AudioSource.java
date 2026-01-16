package jagex3.sound;

import deob.ObfuscatedName;

import java.awt.*;

@ObfuscatedName("w")
public interface AudioSource {

	@ObfuscatedName("w.r(Ljava/awt/Component;IZB)V")
	void init(Component arg0, int arg1, boolean arg2) throws Exception;

	@ObfuscatedName("w.l(IB)I")
	int queued(int arg0);

	@ObfuscatedName("w.m(I[II)V")
	void write(int arg0, int[] arg1);

	@ObfuscatedName("w.n(IB)V")
	void flush(int arg0);

	@ObfuscatedName("w.c(II)V")
	void close(int arg0);

	@ObfuscatedName("w.d(III)V")
	void open(int arg0, int arg1) throws Exception;
}
