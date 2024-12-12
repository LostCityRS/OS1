package jagex3.midi;

import deob.ObfuscatedName;

@ObfuscatedName("b")
public class VorbisMapping {

	@ObfuscatedName("b.r")
	public int field231;

	@ObfuscatedName("b.d")
	public int field232;

	@ObfuscatedName("b.l")
	public int[] field234;

	@ObfuscatedName("b.m")
	public int[] field233;

	public VorbisMapping() {
		VorbisSound.method1561(16);
		this.field231 = VorbisSound.method1553() == 0 ? 1 : VorbisSound.method1561(4) + 1;
		if (VorbisSound.method1553() != 0) {
			VorbisSound.method1561(8);
		}
		VorbisSound.method1561(2);
		if (this.field231 > 1) {
			this.field232 = VorbisSound.method1561(4);
		}
		this.field234 = new int[this.field231];
		this.field233 = new int[this.field231];
		for (int var1 = 0; var1 < this.field231; var1++) {
			VorbisSound.method1561(8);
			this.field234[var1] = VorbisSound.method1561(8);
			this.field233[var1] = VorbisSound.method1561(8);
		}
	}
}
