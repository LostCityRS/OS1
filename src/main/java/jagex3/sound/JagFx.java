package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.io.Packet;
import jagex3.js5.Js5;

// jag::oldscape::sound::JagFX
@ObfuscatedName("o")
public class JagFx {

	@ObfuscatedName("o.d")
	public Tone[] tones = new Tone[10];

	@ObfuscatedName("o.l")
	public int loopBegin;

	@ObfuscatedName("o.m")
	public int loopEnd;

	// jag::oldscape::sound::JagFX::Load
	@ObfuscatedName("o.r(Lch;II)Lo;")
	public static JagFx load(Js5 arg0, int arg1, int arg2) {
		byte[] src = arg0.getFile(arg1, arg2);
		return src == null ? null : new JagFx(new Packet(src));
	}

	public JagFx(Packet arg0) {
		for (int var2 = 0; var2 < 10; var2++) {
			int var3 = arg0.g1();
			if (var3 != 0) {
				arg0.pos--;
				this.tones[var2] = new Tone();
				this.tones[var2].load(arg0);
			}
		}

		this.loopBegin = arg0.g2();
		this.loopEnd = arg0.g2();
	}

	// jag::oldscape::sound::JagFX::ToWave
	@ObfuscatedName("o.d()Leq;")
	public Wave toWave() {
		byte[] var1 = this.makeSound();
		return new Wave(22050, var1, this.loopBegin * 22050 / 1000, this.loopEnd * 22050 / 1000);
	}

	// jag::oldscape::sound::JagFX::OptimiseStart
	@ObfuscatedName("o.l()I")
	public final int optimiseStart() {
		int var1 = 9999999;
		for (int var2 = 0; var2 < 10; var2++) {
			if (this.tones[var2] != null && this.tones[var2].start / 20 < var1) {
				var1 = this.tones[var2].start / 20;
			}
		}
		if (this.loopBegin < this.loopEnd && this.loopBegin / 20 < var1) {
			var1 = this.loopBegin / 20;
		}
		if (var1 == 9999999 || var1 == 0) {
			return 0;
		}
		for (int var3 = 0; var3 < 10; var3++) {
			if (this.tones[var3] != null) {
				this.tones[var3].start -= var1 * 20;
			}
		}
		if (this.loopBegin < this.loopEnd) {
			this.loopBegin -= var1 * 20;
			this.loopEnd -= var1 * 20;
		}
		return var1;
	}

	// jag::oldscape::sound::JagFX::MakeSound
	@ObfuscatedName("o.m()[B")
	public final byte[] makeSound() {
		int var1 = 0;
		for (int var2 = 0; var2 < 10; var2++) {
			if (this.tones[var2] != null && this.tones[var2].start + this.tones[var2].length > var1) {
				var1 = this.tones[var2].start + this.tones[var2].length;
			}
		}
		if (var1 == 0) {
			return new byte[0];
		}
		int var3 = var1 * 22050 / 1000;
		byte[] var4 = new byte[var3];
		for (int var5 = 0; var5 < 10; var5++) {
			if (this.tones[var5] != null) {
				int var6 = this.tones[var5].length * 22050 / 1000;
				int var7 = this.tones[var5].start * 22050 / 1000;
				int[] var8 = this.tones[var5].generate(var6, this.tones[var5].length);
				for (int var9 = 0; var9 < var6; var9++) {
					int var10 = (var8[var9] >> 8) + var4[var7 + var9];
					if ((var10 + 128 & 0xFFFFFF00) != 0) {
						var10 = var10 >> 31 ^ 0x7F;
					}
					var4[var7 + var9] = (byte) var10;
				}
			}
		}
		return var4;
	}
}
