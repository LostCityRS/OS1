package jagex2.sound;

import deob.ObfuscatedName;
import deob.Statics;

@ObfuscatedName("h")
public class VorbisResidue {

	@ObfuscatedName("h.r")
	public int field319 = VorbisSound.method1561(16);

	@ObfuscatedName("h.d")
	public int field317 = VorbisSound.method1561(24);

	@ObfuscatedName("h.l")
	public int field320 = VorbisSound.method1561(24);

	@ObfuscatedName("h.m")
	public int field318 = VorbisSound.method1561(24) + 1;

	@ObfuscatedName("h.c")
	public int field316 = VorbisSound.method1561(6) + 1;

	@ObfuscatedName("h.n")
	public int field321 = VorbisSound.method1561(8);

	@ObfuscatedName("h.j")
	public int[] field322;

	public VorbisResidue() {
		int[] var1 = new int[this.field316];
		for (int var2 = 0; var2 < this.field316; var2++) {
			int var3 = 0;
			int var4 = VorbisSound.method1561(3);
			boolean var5 = VorbisSound.method1553() != 0;
			if (var5) {
				var3 = VorbisSound.method1561(5);
			}
			var1[var2] = var3 << 3 | var4;
		}
		this.field322 = new int[this.field316 * 8];
		for (int var6 = 0; var6 < this.field316 * 8; var6++) {
			this.field322[var6] = (var1[var6 >> 3] & 0x1 << (var6 & 0x7)) == 0 ? -1 : VorbisSound.method1561(8);
		}
	}

	@ObfuscatedName("h.r([FIZ)V")
	public void method317(float[] arg0, int arg1, boolean arg2) {
		for (int var4 = 0; var4 < arg1; var4++) {
			arg0[var4] = 0.0F;
		}
		if (arg2) {
			return;
		}
		int var5 = Statics.field1658[this.field321].field324;
		int var6 = this.field320 - this.field317;
		int var7 = var6 / this.field318;
		int[] var8 = new int[var7];
		for (int var9 = 0; var9 < 8; var9++) {
			int var10 = 0;
			while (var10 < var7) {
				if (var9 == 0) {
					int var11 = Statics.field1658[this.field321].method320();
					for (int var12 = var5 - 1; var12 >= 0; var12--) {
						if (var10 + var12 < var7) {
							var8[var10 + var12] = var11 % this.field316;
						}
						var11 /= this.field316;
					}
				}
				for (int var13 = 0; var13 < var5; var13++) {
					int var14 = var8[var10];
					int var15 = this.field322[var14 * 8 + var9];
					if (var15 >= 0) {
						int var16 = this.field318 * var10 + this.field317;
						VorbisCookbook var17 = Statics.field1658[var15];
						if (this.field319 == 0) {
							int var18 = this.field318 / var17.field324;
							for (int var19 = 0; var19 < var18; var19++) {
								float[] var20 = var17.method318();
								for (int var21 = 0; var21 < var17.field324; var21++) {
									arg0[var18 * var21 + var16 + var19] += var20[var21];
								}
							}
						} else {
							int var22 = 0;
							while (var22 < this.field318) {
								float[] var23 = var17.method318();
								for (int var24 = 0; var24 < var17.field324; var24++) {
									arg0[var16 + var22] += var23[var24];
									var22++;
								}
							}
						}
					}
					var10++;
					if (var10 >= var7) {
						break;
					}
				}
			}
		}
	}
}
