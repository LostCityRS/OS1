package jagex3.midi;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable;
import jagex3.io.Packet;
import jagex3.js5.Js5;
import jagex3.sound.Wave;
import jagex3.sound.WaveCache;

// jag::oldscape::midi2::Patch
@ObfuscatedName("ef")
public class Patch extends Linkable {

	@ObfuscatedName("ef.m")
	public int volume;

	@ObfuscatedName("ef.c")
	public Wave[] noteSound = new Wave[128];

	@ObfuscatedName("ef.n")
	public short[] notePitch = new short[128];

	@ObfuscatedName("ef.j")
	public byte[] noteVolume = new byte[128];

	@ObfuscatedName("ef.z")
	public byte[] notePan = new byte[128];

	@ObfuscatedName("ef.g")
	public EnvelopeSet[] noteEnvelope = new EnvelopeSet[128];

	@ObfuscatedName("ef.q")
	public byte[] noteSecondaryNote = new byte[128];

	@ObfuscatedName("ef.i")
	public int[] noteWaveId = new int[128];

	// jag::oldscape::midi2::Patch::Load
	@ObfuscatedName("l.c(Lch;II)Lef;")
	public static Patch load(Js5 arg0, int arg1) {
		byte[] var2 = arg0.getFile(arg1);
		return var2 == null ? null : new Patch(var2);
	}

	public Patch(byte[] src) {
		Packet buf = new Packet(src);

		int var3;
		for (var3 = 0; buf.data[buf.pos + var3] != 0; var3++) {
		}

		byte[] var4 = new byte[var3];
		for (int var5 = 0; var5 < var3; var5++) {
			var4[var5] = buf.g1b();
		}

		buf.pos++;
		var3++;

		int var6 = buf.pos;
		buf.pos += var3;

		int var7;
		for (var7 = 0; buf.data[buf.pos + var7] != 0; var7++) {
		}

		byte[] var8 = new byte[var7];
		for (int var9 = 0; var9 < var7; var9++) {
			var8[var9] = buf.g1b();
		}

		buf.pos++;
		var7++;

		int var10 = buf.pos;
		buf.pos += var7;

		int var11;
		for (var11 = 0; buf.data[buf.pos + var11] != 0; var11++) {
		}

		byte[] var12 = new byte[var11];
		for (int var13 = 0; var13 < var11; var13++) {
			var12[var13] = buf.g1b();
		}

		buf.pos++;
		var11++;

		byte[] var14 = new byte[var11];
		int var16;
		if (var11 > 1) {
			var14[1] = 1;
			int var15 = 1;
			var16 = 2;
			for (int var17 = 2; var17 < var11; var17++) {
				int var18 = buf.g1();
				if (var18 == 0) {
					var15 = var16++;
				} else {
					if (var18 <= var15) {
						var18--;
					}
					var15 = var18;
				}
				var14[var17] = (byte) var15;
			}
		} else {
			var16 = var11;
		}

		EnvelopeSet[] var19 = new EnvelopeSet[var16];
		for (int var20 = 0; var20 < var19.length; var20++) {
			EnvelopeSet var21 = var19[var20] = new EnvelopeSet();
			int var22 = buf.g1();
			if (var22 > 0) {
				var21.attackVolume = new byte[var22 * 2];
			}
			int var23 = buf.g1();
			if (var23 > 0) {
				var21.releaseVolume = new byte[var23 * 2 + 2];
				var21.releaseVolume[1] = 64;
			}
		}

		int var24 = buf.g1();
		byte[] var25 = var24 > 0 ? new byte[var24 * 2] : null;

		int var26 = buf.g1();
		byte[] var27 = var26 > 0 ? new byte[var26 * 2] : null;

		int var28;
		for (var28 = 0; buf.data[buf.pos + var28] != 0; var28++) {
		}

		byte[] var29 = new byte[var28];
		for (int var30 = 0; var30 < var28; var30++) {
			var29[var30] = buf.g1b();
		}

		buf.pos++;
		var28++;

		int var31 = 0;
		for (int var32 = 0; var32 < 128; var32++) {
			var31 += buf.g1();
			this.notePitch[var32] = (short) var31;
		}

		int var33 = 0;
		for (int var34 = 0; var34 < 128; var34++) {
			var33 += buf.g1();
			this.notePitch[var34] = (short) (this.notePitch[var34] + (var33 << 8));
		}

		int var35 = 0;
		int var36 = 0;
		int var37 = 0;
		for (int var38 = 0; var38 < 128; var38++) {
			if (var35 == 0) {
				if (var36 < var29.length) {
					var35 = var29[var36++];
				} else {
					var35 = -1;
				}
				var37 = buf.gMidiVarLen();
			}
			this.notePitch[var38] = (short) (this.notePitch[var38] + ((var37 - 1 & 0x2) << 14));
			this.noteWaveId[var38] = var37;
			var35--;
		}

		int var39 = 0;
		int var40 = 0;
		int var41 = 0;
		for (int var42 = 0; var42 < 128; var42++) {
			if (this.noteWaveId[var42] != 0) {
				if (var39 == 0) {
					if (var40 < var4.length) {
						var39 = var4[var40++];
					} else {
						var39 = -1;
					}
					var41 = buf.data[var6++] - 1;
				}
				this.noteSecondaryNote[var42] = (byte) var41;
				var39--;
			}
		}

		int var43 = 0;
		int var44 = 0;
		int var45 = 0;
		for (int var46 = 0; var46 < 128; var46++) {
			if (this.noteWaveId[var46] != 0) {
				if (var43 == 0) {
					if (var44 < var8.length) {
						var43 = var8[var44++];
					} else {
						var43 = -1;
					}
					var45 = buf.data[var10++] + 16 << 2;
				}
				this.notePan[var46] = (byte) var45;
				var43--;
			}
		}

		int var47 = 0;
		int var48 = 0;
		EnvelopeSet var49 = null;
		for (int var50 = 0; var50 < 128; var50++) {
			if (this.noteWaveId[var50] != 0) {
				if (var47 == 0) {
					var49 = var19[var14[var48]];
					if (var48 < var12.length) {
						var47 = var12[var48++];
					} else {
						var47 = -1;
					}
				}
				this.noteEnvelope[var50] = var49;
				var47--;
			}
		}

		int var51 = 0;
		int var52 = 0;
		int var53 = 0;
		for (int var54 = 0; var54 < 128; var54++) {
			if (var51 == 0) {
				if (var52 < var29.length) {
					var51 = var29[var52++];
				} else {
					var51 = -1;
				}
				if (this.noteWaveId[var54] > 0) {
					var53 = buf.g1() + 1;
				}
			}
			this.noteVolume[var54] = (byte) var53;
			var51--;
		}

		this.volume = buf.g1() + 1;

		for (int var55 = 0; var55 < var16; var55++) {
			EnvelopeSet var56 = var19[var55];
			if (var56.attackVolume != null) {
				for (int var57 = 1; var57 < var56.attackVolume.length; var57 += 2) {
					var56.attackVolume[var57] = buf.g1b();
				}
			}
			if (var56.releaseVolume != null) {
				for (int var58 = 3; var58 < var56.releaseVolume.length - 2; var58 += 2) {
					var56.releaseVolume[var58] = buf.g1b();
				}
			}
		}

		if (var25 != null) {
			for (int var59 = 1; var59 < var25.length; var59 += 2) {
				var25[var59] = buf.g1b();
			}
		}

		if (var27 != null) {
			for (int var60 = 1; var60 < var27.length; var60 += 2) {
				var27[var60] = buf.g1b();
			}
		}

		for (int var61 = 0; var61 < var16; var61++) {
			EnvelopeSet var62 = var19[var61];
			if (var62.releaseVolume != null) {
				int var63 = 0;
				for (int var64 = 2; var64 < var62.releaseVolume.length; var64 += 2) {
					var63 = var63 + 1 + buf.g1();
					var62.releaseVolume[var64] = (byte) var63;
				}
			}
		}

		for (int var65 = 0; var65 < var16; var65++) {
			EnvelopeSet var66 = var19[var65];
			if (var66.attackVolume != null) {
				int var67 = 0;
				for (int var68 = 2; var68 < var66.attackVolume.length; var68 += 2) {
					var67 = var67 + 1 + buf.g1();
					var66.attackVolume[var68] = (byte) var67;
				}
			}
		}

		if (var25 != null) {
			int var69 = buf.g1();
			var25[0] = (byte) var69;

			for (int var70 = 2; var70 < var25.length; var70 += 2) {
				var69 = var69 + 1 + buf.g1();
				var25[var70] = (byte) var69;
			}

			byte var71 = var25[0];
			byte var72 = var25[1];

			for (int var73 = 0; var73 < var71; var73++) {
				this.noteVolume[var73] = (byte) (this.noteVolume[var73] * var72 + 32 >> 6);
			}

			for (int var74 = 2; var74 < var25.length; var74 += 2) {
				byte var75 = var25[var74];
				byte var76 = var25[var74 + 1];

				int var77 = (var75 - var71) / 2 + (var75 - var71) * var72;

				for (int var78 = var71; var78 < var75; var78++) {
					int var79 = var75 - var71;
					int var80 = var77 >>> 31;
					int var81 = (var77 + var80) / var79 - var80;
					this.noteVolume[var78] = (byte) (this.noteVolume[var78] * var81 + 32 >> 6);
					var77 += var76 - var72;
				}

				var71 = var75;
				var72 = var76;
			}

			for (int var83 = var71; var83 < 128; var83++) {
				this.noteVolume[var83] = (byte) (this.noteVolume[var83] * var72 + 32 >> 6);
			}

			Object var84 = null;
		}

		if (var27 != null) {
			int var85 = buf.g1();
			var27[0] = (byte) var85;

			for (int var86 = 2; var86 < var27.length; var86 += 2) {
				var85 = var85 + 1 + buf.g1();
				var27[var86] = (byte) var85;
			}

			byte var87 = var27[0];
			int var88 = var27[1] << 1;

			for (int var89 = 0; var89 < var87; var89++) {
				int var90 = (this.notePan[var89] & 0xFF) + var88;
				if (var90 < 0) {
					var90 = 0;
				}
				if (var90 > 128) {
					var90 = 128;
				}
				this.notePan[var89] = (byte) var90;
			}

			for (int var91 = 2; var91 < var27.length; var91 += 2) {
				byte var92 = var27[var91];
				int var93 = var27[var91 + 1] << 1;

				int var94 = (var92 - var87) / 2 + (var92 - var87) * var88;

				for (int var95 = var87; var95 < var92; var95++) {
					int var96 = var92 - var87;
					int var97 = var94 >>> 31;
					int var98 = (var94 + var97) / var96 - var97;
					int var100 = (this.notePan[var95] & 0xFF) + var98;
					if (var100 < 0) {
						var100 = 0;
					}
					if (var100 > 128) {
						var100 = 128;
					}
					this.notePan[var95] = (byte) var100;
					var94 += var93 - var88;
				}
				var87 = var92;
				var88 = var93;
			}

			for (int var101 = var87; var101 < 128; var101++) {
				int var102 = (this.notePan[var101] & 0xFF) + var88;
				if (var102 < 0) {
					var102 = 0;
				}
				if (var102 > 128) {
					var102 = 128;
				}

				this.notePan[var101] = (byte) var102;
			}

			Object var103 = null;
		}

		for (int var104 = 0; var104 < var16; var104++) {
			var19[var104].decayVolume = buf.g1();
		}

		for (int var105 = 0; var105 < var16; var105++) {
			EnvelopeSet var106 = var19[var105];
			if (var106.attackVolume != null) {
				var106.attackSpeed = buf.g1();
			}
			if (var106.releaseVolume != null) {
				var106.releaseSpeed = buf.g1();
			}
			if (var106.decayVolume > 0) {
				var106.decaySpeed = buf.g1();
			}
		}

		for (int var107 = 0; var107 < var16; var107++) {
			var19[var107].vibratoFrequency = buf.g1();
		}

		for (int var108 = 0; var108 < var16; var108++) {
			EnvelopeSet var109 = var19[var108];
			if (var109.vibratoFrequency > 0) {
				var109.vibratoAmplitude = buf.g1();
			}
		}

		for (int var110 = 0; var110 < var16; var110++) {
			EnvelopeSet var111 = var19[var110];
			if (var111.vibratoAmplitude > 0) {
				var111.vibratoRampTime = buf.g1();
			}
		}
	}

	// jag::oldscape::midi2::Patch::LoadWaves
	@ObfuscatedName("ef.n(La;[B[II)Z")
	public boolean loadWaves(WaveCache arg0, byte[] arg1, int[] arg2) {
		boolean var4 = true;
		int var5 = 0;
		Wave var6 = null;
		for (int var7 = 0; var7 < 128; var7++) {
			if (arg1 == null || arg1[var7] != 0) {
				int var8 = this.noteWaveId[var7];
				if (var8 != 0) {
					if (var5 != var8) {
						var5 = var8--;
						if ((var8 & 0x1) == 0) {
							var6 = arg0.getJagFx(var8 >> 2, arg2);
						} else {
							var6 = arg0.getJagVorbis(var8 >> 2, arg2);
						}
						if (var6 == null) {
							var4 = false;
						}
					}
					if (var6 != null) {
						this.noteSound[var7] = var6;
						this.noteWaveId[var7] = 0;
					}
				}
			}
		}
		return var4;
	}

	@ObfuscatedName("ef.j(B)V")
	public void freeWaveIds() {
		this.noteWaveId = null;
	}
}
