package jagex3.sound;

import deob.ObfuscatedName;

// jag::oldscape::sound::Residue
@ObfuscatedName("h")
public class Residue {

	@ObfuscatedName("h.r")
	public int field319 = JagVorbis.read_bits(16);

	@ObfuscatedName("h.d")
	public int field317 = JagVorbis.read_bits(24);

	@ObfuscatedName("h.l")
	public int field320 = JagVorbis.read_bits(24);

	@ObfuscatedName("h.m")
	public int field318 = JagVorbis.read_bits(24) + 1;

	@ObfuscatedName("h.c")
	public int residue_count = JagVorbis.read_bits(6) + 1;

	@ObfuscatedName("h.n")
	public int field321 = JagVorbis.read_bits(8);

	@ObfuscatedName("h.j")
	public int[] residue_books;

	public Residue() {
		int[] residue_cascade = new int[this.residue_count];
		for (int i = 0; i < this.residue_count; i++) {
			int high_bits = 0;
			int low_bits = JagVorbis.read_bits(3);
			boolean has_high_bits = JagVorbis.read_bool() != 0;
			if (has_high_bits) {
				high_bits = JagVorbis.read_bits(5);
			}
			residue_cascade[i] = high_bits << 3 | low_bits;
		}

		this.residue_books = new int[this.residue_count * 8];
		for (int i = 0; i < this.residue_count * 8; i++) {
			this.residue_books[i] = (residue_cascade[i >> 3] & 0x1 << (i & 0x7)) == 0 ? -1 : JagVorbis.read_bits(8);
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
		int var5 = JagVorbis.codebooks[this.field321].dimensions;
		int var6 = this.field320 - this.field317;
		int var7 = var6 / this.field318;
		int[] var8 = new int[var7];
		for (int var9 = 0; var9 < 8; var9++) {
			int var10 = 0;
			while (var10 < var7) {
				if (var9 == 0) {
					int var11 = JagVorbis.codebooks[this.field321].method320();
					for (int var12 = var5 - 1; var12 >= 0; var12--) {
						if (var10 + var12 < var7) {
							var8[var10 + var12] = var11 % this.residue_count;
						}
						var11 /= this.residue_count;
					}
				}
				for (int var13 = 0; var13 < var5; var13++) {
					int var14 = var8[var10];
					int var15 = this.residue_books[var14 * 8 + var9];
					if (var15 >= 0) {
						int var16 = this.field318 * var10 + this.field317;
						CodeBook var17 = JagVorbis.codebooks[var15];
						if (this.field319 == 0) {
							int var18 = this.field318 / var17.dimensions;
							for (int var19 = 0; var19 < var18; var19++) {
								float[] var20 = var17.method318();
								for (int var21 = 0; var21 < var17.dimensions; var21++) {
									arg0[var18 * var21 + var16 + var19] += var20[var21];
								}
							}
						} else {
							int var22 = 0;
							while (var22 < this.field318) {
								float[] var23 = var17.method318();
								for (int var24 = 0; var24 < var17.dimensions; var24++) {
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
