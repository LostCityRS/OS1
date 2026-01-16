package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.datastruct.IntUtil;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.awt.*;

@ObfuscatedName("ds")
public class JavaPcmPlayer extends PcmPlayer {

	@ObfuscatedName("ds.ac")
	public AudioFormat format;

	@ObfuscatedName("ds.aa")
	public SourceDataLine line;

	@ObfuscatedName("ds.as")
	public int lineCapacity;

	@ObfuscatedName("ds.am")
	public byte[] buffer;

	@ObfuscatedName("ds.s(Ljava/awt/Component;)V")
	public void init(Component arg0) {
		this.format = new AudioFormat((float) PcmPlayer.frequency, 16, PcmPlayer.stereo ? 2 : 1, true, false);
		this.buffer = new byte[0x100 << (PcmPlayer.stereo ? 2 : 1)];
	}

	@ObfuscatedName("ds.u(I)V")
	public void open(int arg0) throws LineUnavailableException {
		try {
			Info var2 = new Info(SourceDataLine.class, this.format, arg0 << (PcmPlayer.stereo ? 2 : 1));
			this.line = (SourceDataLine) AudioSystem.getLine(var2);
			this.line.open();
			this.line.start();
			this.lineCapacity = arg0;
		} catch (LineUnavailableException var11) {
			if (IntUtil.bitCount(arg0) == 1) {
				this.line = null;
				throw var11;
			}
			int var4 = arg0 - 1;
			int var5 = var4 | var4 >>> 1;
			int var6 = var5 | var5 >>> 2;
			int var7 = var6 | var6 >>> 4;
			int var8 = var7 | var7 >>> 8;
			int var9 = var8 | var8 >>> 16;
			int var10 = var9 + 1;
			this.open(var10);
		}
	}

	@ObfuscatedName("ds.v()I")
	public int queued() {
		return this.lineCapacity - (this.line.available() >> (PcmPlayer.stereo ? 2 : 1));
	}

	@ObfuscatedName("ds.w()V")
	public void write() {
		int var1 = 256;
		if (PcmPlayer.stereo) {
			var1 <<= 0x1;
		}
		for (int var2 = 0; var2 < var1; var2++) {
			int var3 = this.samples[var2];
			if ((var3 + 0x800000 & 0xFF000000) != 0) {
				var3 = var3 >> 31 ^ 0x7FFFFF;
			}
			this.buffer[var2 * 2] = (byte) (var3 >> 8);
			this.buffer[var2 * 2 + 1] = (byte) (var3 >> 16);
		}
		this.line.write(this.buffer, 0, var1 << 1);
	}

	@ObfuscatedName("ds.e()V")
	public void close() {
		if (this.line != null) {
			this.line.close();
			this.line = null;
		}
	}

	@ObfuscatedName("ds.b()V")
	public void flush() {
		this.line.flush();
	}
}
