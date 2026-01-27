package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.datastruct.MathTool;

// jag::oldscape::sound::CodeBook
@ObfuscatedName("x")
public class CodeBook {

	@ObfuscatedName("x.r")
	public int dimensions;

	@ObfuscatedName("x.d")
	public int entries;

	@ObfuscatedName("x.l")
	public int[] lengths;

	@ObfuscatedName("x.m")
	public int[] field326;

	@ObfuscatedName("x.c")
	public float[][] field328;

	@ObfuscatedName("x.n")
	public int[] field323;

	// jag::oldscape::sound::CodeBook::Lookup1Values
	@ObfuscatedName("x.r(II)I")
	public static int lookup1Values(int arg0, int arg1) {
		int var2 = (int) Math.pow((double) arg0, 1.0D / (double) arg1) + 1;
		while (true) {
			int var3 = var2;
			int var4 = arg1;
			int var5 = 1;
			while (var4 > 1) {
				if ((var4 & 0x1) != 0) {
					var5 = var3 * var5;
				}
				var3 *= var3;
				var4 >>= 0x1;
			}
			int var6;
			if (var4 == 1) {
				var6 = var3 * var5;
			} else {
				var6 = var5;
			}
			if (var6 <= arg0) {
				return var2;
			}
			var2--;
		}
	}

	public CodeBook() {
		JagVorbis.readBits(24);
		this.dimensions = JagVorbis.readBits(16);
		this.entries = JagVorbis.readBits(24);
		this.lengths = new int[this.entries];
		boolean ordered = JagVorbis.readBit() != 0;

		if (ordered) {
			int current_entry = 0;
			int current_length = JagVorbis.readBits(5) + 1;

			while (current_entry < this.entries) {
				int n = JagVorbis.readBits(MathTool.bitsRequired(this.entries - current_entry));

				for (int i = 0; i < n; i++) {
					this.lengths[current_entry++] = current_length;
				}

				current_length++;
			}
		} else {
			boolean present = JagVorbis.readBit() != 0;

			for (int i = 0; i < this.entries; i++) {
				if (present && JagVorbis.readBit() == 0) {
					this.lengths[i] = 0;
				} else {
					this.lengths[i] = JagVorbis.readBits(5) + 1;
				}
			}
		}

		this.prepareHuffman();

		int lookup_type = JagVorbis.readBits(4);
		if (lookup_type > 0) {
			float minimum_value = JagVorbis.float32Unpack(JagVorbis.readBits(32));
			float delta_value = JagVorbis.float32Unpack(JagVorbis.readBits(32));
			int value_bits = JagVorbis.readBits(4) + 1;
			boolean sequence_p = JagVorbis.readBit() != 0;

			int lookup_values;
			if (lookup_type == 1) {
				lookup_values = lookup1Values(this.entries, this.dimensions);
			} else {
				lookup_values = this.entries * this.dimensions;
			}

			this.field326 = new int[lookup_values];
			for (int var14 = 0; var14 < lookup_values; var14++) {
				this.field326[var14] = JagVorbis.readBits(value_bits);
			}

			this.field328 = new float[this.entries][this.dimensions];
			if (lookup_type == 1) {
				for (int var15 = 0; var15 < this.entries; var15++) {
					float var16 = 0.0F;
					int var17 = 1;
					for (int var18 = 0; var18 < this.dimensions; var18++) {
						int var19 = var15 / var17 % lookup_values;
						float var20 = (float) this.field326[var19] * delta_value + minimum_value + var16;
						this.field328[var15][var18] = var20;
						if (sequence_p) {
							var16 = var20;
						}
						var17 = lookup_values * var17;
					}
				}
			} else {
				for (int var21 = 0; var21 < this.entries; var21++) {
					float var22 = 0.0F;
					int var23 = this.dimensions * var21;
					for (int var24 = 0; var24 < this.dimensions; var24++) {
						float var25 = (float) this.field326[var23] * delta_value + minimum_value + var22;
						this.field328[var21][var24] = var25;
						if (sequence_p) {
							var22 = var25;
						}
						var23++;
					}
				}
			}
		}
	}

	// jag::oldscape::sound::CodeBook::PrepareHuffman
	@ObfuscatedName("x.d()V")
	public void prepareHuffman() {
		int[] var1 = new int[this.entries];
		int[] var2 = new int[33];
		for (int var3 = 0; var3 < this.entries; var3++) {
			int var4 = this.lengths[var3];
			if (var4 != 0) {
				int var5 = 0x1 << 32 - var4;
				int var6 = var2[var4];
				var1[var3] = var6;
				int var7;
				if ((var6 & var5) == 0) {
					var7 = var6 | var5;
					for (int var8 = var4 - 1; var8 >= 1; var8--) {
						int var9 = var2[var8];
						if (var6 != var9) {
							break;
						}
						int var10 = 0x1 << 32 - var8;
						if ((var9 & var10) != 0) {
							var2[var8] = var2[var8 - 1];
							break;
						}
						var2[var8] = var9 | var10;
					}
				} else {
					var7 = var2[var4 - 1];
				}
				var2[var4] = var7;
				for (int var11 = var4 + 1; var11 <= 32; var11++) {
					int var12 = var2[var11];
					if (var6 == var12) {
						var2[var11] = var7;
					}
				}
			}
		}
		this.field323 = new int[8];
		int var13 = 0;
		for (int var14 = 0; var14 < this.entries; var14++) {
			int var15 = this.lengths[var14];
			if (var15 != 0) {
				int var16 = var1[var14];
				int var17 = 0;
				for (int var18 = 0; var18 < var15; var18++) {
					int var19 = Integer.MIN_VALUE >>> var18;
					if ((var16 & var19) == 0) {
						var17++;
					} else {
						if (this.field323[var17] == 0) {
							this.field323[var17] = var13;
						}
						var17 = this.field323[var17];
					}
					if (var17 >= this.field323.length) {
						int[] var20 = new int[this.field323.length * 2];
						for (int var21 = 0; var21 < this.field323.length; var21++) {
							var20[var21] = this.field323[var21];
						}
						this.field323 = var20;
					}
					int var22 = var19 >>> 1;
				}
				this.field323[var17] = ~var14;
				if (var17 >= var13) {
					var13 = var17 + 1;
				}
			}
		}
	}

	// jag::oldscape::sound::CodeBook::DecodeScalar
	@ObfuscatedName("x.l()I")
	public int decodeScalar() {
		int var1;
		for (var1 = 0; this.field323[var1] >= 0; var1 = JagVorbis.readBit() == 0 ? var1 + 1 : this.field323[var1]) {
		}
		return ~this.field323[var1];
	}

	// jag::oldscape::sound::CodeBook::DecodeVQ
	@ObfuscatedName("x.m()[F")
	public float[] decodeVQ() {
		return this.field328[this.decodeScalar()];
	}
}
