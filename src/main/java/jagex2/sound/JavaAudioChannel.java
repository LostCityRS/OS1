package jagex2.sound;

import deob.ObfuscatedName;
import jagex2.datastruct.IntUtil;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.awt.*;

@ObfuscatedName("ds")
public class JavaAudioChannel extends AudioChannel {

	@ObfuscatedName("ds.ac")
	public AudioFormat field1554;

	@ObfuscatedName("ds.aa")
	public SourceDataLine field1556;

	@ObfuscatedName("ds.as")
	public int field1555;

	@ObfuscatedName("ds.am")
	public byte[] field1553;

	@ObfuscatedName("ds.s(Ljava/awt/Component;)V")
	public void method209(Component arg0) {
		this.field1554 = new AudioFormat((float) AudioChannel.field241, 16, AudioChannel.field236 ? 2 : 1, true, false);
		this.field1553 = new byte[0x100 << (AudioChannel.field236 ? 2 : 1)];
	}

	@ObfuscatedName("ds.u(I)V")
	public void method214(int arg0) throws LineUnavailableException {
		try {
			Info var2 = new Info(SourceDataLine.class, this.field1554, arg0 << (AudioChannel.field236 ? 2 : 1));
			this.field1556 = (SourceDataLine) AudioSystem.getLine(var2);
			this.field1556.open();
			this.field1556.start();
			this.field1555 = arg0;
		} catch (LineUnavailableException var11) {
			if (IntUtil.method1838(arg0) == 1) {
				this.field1556 = null;
				throw var11;
			}
			int var4 = arg0 - 1;
			int var5 = var4 | var4 >>> 1;
			int var6 = var5 | var5 >>> 2;
			int var7 = var6 | var6 >>> 4;
			int var8 = var7 | var7 >>> 8;
			int var9 = var8 | var8 >>> 16;
			int var10 = var9 + 1;
			this.method214(var10);
		}
	}

	@ObfuscatedName("ds.v()I")
	public int method215() {
		return this.field1555 - (this.field1556.available() >> (AudioChannel.field236 ? 2 : 1));
	}

	@ObfuscatedName("ds.w()V")
	public void method216() {
		int var1 = 256;
		if (AudioChannel.field236) {
			var1 <<= 0x1;
		}
		for (int var2 = 0; var2 < var1; var2++) {
			int var3 = this.field243[var2];
			if ((var3 + 8388608 & 0xFF000000) != 0) {
				var3 = var3 >> 31 ^ 0x7FFFFF;
			}
			this.field1553[var2 * 2] = (byte) (var3 >> 8);
			this.field1553[var2 * 2 + 1] = (byte) (var3 >> 16);
		}
		this.field1556.write(this.field1553, 0, var1 << 1);
	}

	@ObfuscatedName("ds.e()V")
	public void method217() {
		if (this.field1556 != null) {
			this.field1556.close();
			this.field1556 = null;
		}
	}

	@ObfuscatedName("ds.b()V")
	public void method218() {
		this.field1556.flush();
	}
}
