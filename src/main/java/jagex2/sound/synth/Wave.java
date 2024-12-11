package jagex2.sound.synth;

import deob.ObfuscatedName;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;
import jagex2.sound.PcmSound;

@ObfuscatedName("o")
public class Wave {

	@ObfuscatedName("o.d")
	public Tone[] field307 = new Tone[10];

	@ObfuscatedName("o.l")
	public int field308;

	@ObfuscatedName("o.m")
	public int field309;

	@ObfuscatedName("o.r(Lch;II)Lo;")
	public static Wave method294(Js5Index arg0, int arg1, int arg2) {
		byte[] var3 = arg0.getFile(arg1, arg2);
		return var3 == null ? null : new Wave(new Packet(var3));
	}

	public Wave(Packet arg0) {
		for (int var2 = 0; var2 < 10; var2++) {
			int var3 = arg0.g1();
			if (var3 != 0) {
				arg0.pos--;
				this.field307[var2] = new Tone();
				this.field307[var2].method263(arg0);
			}
		}
		this.field308 = arg0.g2();
		this.field309 = arg0.g2();
	}

	@ObfuscatedName("o.d()Leq;")
	public PcmSound method291() {
		byte[] var1 = this.method293();
		return new PcmSound(22050, var1, this.field308 * 22050 / 1000, this.field309 * 22050 / 1000);
	}

	@ObfuscatedName("o.l()I")
	public final int method292() {
		int var1 = 9999999;
		for (int var2 = 0; var2 < 10; var2++) {
			if (this.field307[var2] != null && this.field307[var2].field280 / 20 < var1) {
				var1 = this.field307[var2].field280 / 20;
			}
		}
		if (this.field308 < this.field309 && this.field308 / 20 < var1) {
			var1 = this.field308 / 20;
		}
		if (var1 == 9999999 || var1 == 0) {
			return 0;
		}
		for (int var3 = 0; var3 < 10; var3++) {
			if (this.field307[var3] != null) {
				this.field307[var3].field280 -= var1 * 20;
			}
		}
		if (this.field308 < this.field309) {
			this.field308 -= var1 * 20;
			this.field309 -= var1 * 20;
		}
		return var1;
	}

	@ObfuscatedName("o.m()[B")
	public final byte[] method293() {
		int var1 = 0;
		for (int var2 = 0; var2 < 10; var2++) {
			if (this.field307[var2] != null && this.field307[var2].field280 + this.field307[var2].field279 > var1) {
				var1 = this.field307[var2].field280 + this.field307[var2].field279;
			}
		}
		if (var1 == 0) {
			return new byte[0];
		}
		int var3 = var1 * 22050 / 1000;
		byte[] var4 = new byte[var3];
		for (int var5 = 0; var5 < 10; var5++) {
			if (this.field307[var5] != null) {
				int var6 = this.field307[var5].field279 * 22050 / 1000;
				int var7 = this.field307[var5].field280 * 22050 / 1000;
				int[] var8 = this.field307[var5].method269(var6, this.field307[var5].field279);
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
