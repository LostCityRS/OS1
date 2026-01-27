package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.client.SignLink;

import java.awt.*;

@ObfuscatedName("dv")
public class JavaSafePcmPlayer extends PcmPlayer {

	@ObfuscatedName("dv.ac")
	public static AudioSource source;

	@ObfuscatedName("dv.aa")
	public int field1551;

	public JavaSafePcmPlayer(SignLink arg0, int arg1) {
		source = arg0.getAudio();
		this.field1551 = arg1;
	}

	@ObfuscatedName("dv.s(Ljava/awt/Component;)V")
	public void init(Component arg0) throws Exception {
		source.init(arg0, PcmPlayer.frequency, PcmPlayer.stereo);
	}

	@ObfuscatedName("dv.u(I)V")
	public void open(int arg0) throws Exception {
		if (arg0 > 32768) {
			throw new IllegalArgumentException();
		}
		source.open(this.field1551, arg0);
	}

	@ObfuscatedName("dv.v()I")
	public int queued() {
		return source.queued(this.field1551);
	}

	@ObfuscatedName("dv.w()V")
	public void write() {
		source.write(this.field1551, this.samples);
	}

	@ObfuscatedName("dv.e()V")
	public void close() {
		source.close(this.field1551);
	}

	@ObfuscatedName("dv.b()V")
	public void flush() {
		source.flush(this.field1551);
	}
}
