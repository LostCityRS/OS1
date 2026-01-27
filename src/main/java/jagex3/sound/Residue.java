package jagex3.sound;

import deob.ObfuscatedName;

// jag::oldscape::sound::Residue
@ObfuscatedName("h")
public class Residue {

	@ObfuscatedName("h.r")
	public int type = JagVorbis.readBits(16);

	@ObfuscatedName("h.d")
	public int begin = JagVorbis.readBits(24);

	@ObfuscatedName("h.l")
	public int end = JagVorbis.readBits(24);

	@ObfuscatedName("h.m")
	public int partition_size = JagVorbis.readBits(24) + 1;

	@ObfuscatedName("h.c")
	public int classifications = JagVorbis.readBits(6) + 1;

	@ObfuscatedName("h.n")
	public int classbook = JagVorbis.readBits(8);

	@ObfuscatedName("h.j")
	public int[] residue_books;

	public Residue() {
		int[] residue_cascade = new int[this.classifications];
		for (int i = 0; i < this.classifications; i++) {
			int high_bits = 0;
			int low_bits = JagVorbis.readBits(3);
			boolean has_high_bits = JagVorbis.readBit() != 0;
			if (has_high_bits) {
				high_bits = JagVorbis.readBits(5);
			}
			residue_cascade[i] = high_bits << 3 | low_bits;
		}

		this.residue_books = new int[this.classifications * 8];
		for (int i = 0; i < this.classifications * 8; i++) {
			this.residue_books[i] = (residue_cascade[i >> 3] & 0x1 << (i & 0x7)) == 0 ? -1 : JagVorbis.readBits(8);
		}
	}

	// jag::oldscape::sound::Residue::PacketDecode
	@ObfuscatedName("h.r([FIZ)V")
	public void packetDecode(float[] arg0, int arg1, boolean arg2) {
		for (int var4 = 0; var4 < arg1; var4++) {
			arg0[var4] = 0.0F;
		}

		if (arg2) {
			return;
		}

		int var5 = JagVorbis.codebooks[this.classbook].dimensions;
		int var6 = this.end - this.begin;
		int var7 = var6 / this.partition_size;
		int[] var8 = new int[var7];
		for (int var9 = 0; var9 < 8; var9++) {
			int var10 = 0;
			while (var10 < var7) {
				if (var9 == 0) {
					int var11 = JagVorbis.codebooks[this.classbook].decodeScalar();
					for (int var12 = var5 - 1; var12 >= 0; var12--) {
						if (var10 + var12 < var7) {
							var8[var10 + var12] = var11 % this.classifications;
						}
						var11 /= this.classifications;
					}
				}
				for (int var13 = 0; var13 < var5; var13++) {
					int var14 = var8[var10];
					int var15 = this.residue_books[var14 * 8 + var9];
					if (var15 >= 0) {
						int var16 = this.partition_size * var10 + this.begin;
						CodeBook var17 = JagVorbis.codebooks[var15];
						if (this.type == 0) {
							int var18 = this.partition_size / var17.dimensions;
							for (int var19 = 0; var19 < var18; var19++) {
								float[] var20 = var17.decodeVQ();
								for (int var21 = 0; var21 < var17.dimensions; var21++) {
									arg0[var18 * var21 + var16 + var19] += var20[var21];
								}
							}
						} else {
							int var22 = 0;
							while (var22 < this.partition_size) {
								float[] var23 = var17.decodeVQ();
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
