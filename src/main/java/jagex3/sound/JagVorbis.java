package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.datastruct.MathTool;
import jagex3.datastruct.Linkable;
import jagex3.io.Packet;
import jagex3.js5.Js5;

// jag::oldscape::sound::JagVorbis
@ObfuscatedName("dt")
public class JagVorbis extends Linkable {

	@ObfuscatedName("dt.m")
	public byte[][] audioPackets;

	@ObfuscatedName("dt.c")
	public int sampleRate;

	@ObfuscatedName("dt.n")
	public int sampleCount;

	@ObfuscatedName("dt.j")
	public int loopStart;

	@ObfuscatedName("dt.z")
	public int loopEnd;

	@ObfuscatedName("dt.g")
	public boolean hasLoop;

	// jag::oldscape::sound::JagVorbis::m_staticUnpacker
	@ObfuscatedName("dt.q")
	public static byte[] staticUnpacker;

	@ObfuscatedName("dt.i")
	public static int bytePos;

	@ObfuscatedName("dt.s")
	public static int bitPos;

	// jag::oldscape::sound::JagVorbis::m_blocksize0
	@ObfuscatedName("dt.u")
	public static int blocksize0;

	// jag::oldscape::sound::JagVorbis::m_blocksize1
	@ObfuscatedName("dt.v")
	public static int blocksize1;

	// jag::oldscape::sound::JagVorbis::m_codebook
	@ObfuscatedName("dt.w")
	public static CodeBook[] codebooks;

	@ObfuscatedName("dt.e")
	public static Floor[] floor_config;

	@ObfuscatedName("dt.b")
	public static Residue[] residue_config;

	@ObfuscatedName("dt.y")
	public static Mapping[] mapping_config;

	@ObfuscatedName("dt.t")
	public static boolean[] blockflag;

	@ObfuscatedName("dt.f")
	public static int[] mapping;

	// jag::oldscape::sound::JagVorbis::m_gotHeaders
	@ObfuscatedName("dt.k")
	public static boolean gotHeaders = false;

	@ObfuscatedName("dt.o")
	public float[] previousWindow;

	@ObfuscatedName("dt.a")
	public int previousWindowSize;

	@ObfuscatedName("dt.h")
	public int previousWindowRightStart;

	@ObfuscatedName("dt.x")
	public boolean previousWindowUnused;

	@ObfuscatedName("dt.p")
	public static float[] workBuffer;

	@ObfuscatedName("dt.ad")
	public static float[] imdctPrevShort;

	@ObfuscatedName("dt.ac")
	public static float[] imdctStepShort;

	@ObfuscatedName("dt.aa")
	public static float[] imdctPostShort;

	@ObfuscatedName("dt.as")
	public static float[] imdctPrevLong;

	@ObfuscatedName("dt.am")
	public static float[] imdctStepLong;

	@ObfuscatedName("dt.ap")
	public static float[] imdctPostLong;

	@ObfuscatedName("dt.av")
	public static int[] bitReverseShort;

	@ObfuscatedName("dt.ak")
	public static int[] bitReverseLong;

	@ObfuscatedName("dt.az")
	public byte[] pcmData;

	@ObfuscatedName("dt.an")
	public int pcmWritePosition;

	@ObfuscatedName("dt.ah")
	public int currentPacketIndex;

	// jag::oldscape::sound::JagVorbis::Float32Unpack
	@ObfuscatedName("dt.c(I)F")
	public static float float32Unpack(int arg0) {
		int var1 = arg0 & 0x1FFFFF;
		int var2 = arg0 & Integer.MIN_VALUE;
		int var3 = arg0 >> 21 & 0x3FF;
		if (var2 != 0) {
			var1 = -var1;
		}
		return (float) ((double) var1 * Math.pow(2.0D, (double) (var3 - 788)));
	}

	// jag::oldscape::sound::BitUnpacker::SetBitPos
	@ObfuscatedName("dt.n([BI)V")
	public static void setBitPos(byte[] arg0, int arg1) {
		staticUnpacker = arg0;
		bytePos = arg1;
		bitPos = 0;
	}

	// jag::oldscape::sound::BitUnpacker::ReadBit
	@ObfuscatedName("dt.j()I")
	public static int readBit() {
		int var0 = staticUnpacker[bytePos] >> bitPos & 0x1;
		bitPos++;
		bytePos += bitPos >> 3;
		bitPos &= 0x7;
		return var0;
	}

	// jag::oldscape::sound::BitUnpacker::ReadBits
	@ObfuscatedName("dt.z(I)I")
	public static int readBits(int n) {
		int var1 = 0;
		int var2 = 0;

		while (n >= 8 - bitPos) {
			int var3 = 8 - bitPos;
			int var4 = (0x1 << var3) - 1;
			var1 += (staticUnpacker[bytePos] >> bitPos & var4) << var2;
			bitPos = 0;
			bytePos++;
			var2 += var3;
			n -= var3;
		}

		if (n > 0) {
			int var5 = (0x1 << n) - 1;
			var1 += (staticUnpacker[bytePos] >> bitPos & var5) << var2;
			bitPos += n;
		}

		return var1;
	}

	// jag::oldscape::sound::JagVorbis::DecodeJagVorbis
	@ObfuscatedName("dt.g([B)V")
	public void decodeJagVorbis(byte[] arg0) {
		Packet var2 = new Packet(arg0);
		this.sampleRate = var2.g4();
		this.sampleCount = var2.g4();
		this.loopStart = var2.g4();
		this.loopEnd = var2.g4();
		if (this.loopEnd < 0) {
			this.loopEnd = ~this.loopEnd;
			this.hasLoop = true;
		}
		int var3 = var2.g4();
		this.audioPackets = new byte[var3][];
		for (int var4 = 0; var4 < var3; var4++) {
			int var5 = 0;
			int var6;
			do {
				var6 = var2.g1();
				var5 += var6;
			} while (var6 >= 255);
			byte[] var7 = new byte[var5];
			var2.gdata(var7, 0, var5);
			this.audioPackets[var4] = var7;
		}
	}

	// jag::oldscape::sound::JagVorbis::ProcessHeaders
	@ObfuscatedName("dt.q([B)V")
	public static void processHeaders(byte[] src) {
		setBitPos(src, 0);
		blocksize0 = 0x1 << readBits(4);
		blocksize1 = 0x1 << readBits(4);
		workBuffer = new float[blocksize1];

		for (int var1 = 0; var1 < 2; var1++) {
			int var2 = var1 == 0 ? blocksize0 : blocksize1;
			int var3 = var2 >> 1;
			int var4 = var2 >> 2;
			int var5 = var2 >> 3;
			float[] var6 = new float[var3];
			for (int var7 = 0; var7 < var4; var7++) {
				var6[var7 * 2] = (float) Math.cos((double) (var7 * 4) * 3.141592653589793D / (double) var2);
				var6[var7 * 2 + 1] = -((float) Math.sin((double) (var7 * 4) * 3.141592653589793D / (double) var2));
			}
			float[] var8 = new float[var3];
			for (int var9 = 0; var9 < var4; var9++) {
				var8[var9 * 2] = (float) Math.cos((double) (var9 * 2 + 1) * 3.141592653589793D / (double) (var2 * 2));
				var8[var9 * 2 + 1] = (float) Math.sin((double) (var9 * 2 + 1) * 3.141592653589793D / (double) (var2 * 2));
			}
			float[] var10 = new float[var4];
			for (int var11 = 0; var11 < var5; var11++) {
				var10[var11 * 2] = (float) Math.cos((double) (var11 * 4 + 2) * 3.141592653589793D / (double) var2);
				var10[var11 * 2 + 1] = -((float) Math.sin((double) (var11 * 4 + 2) * 3.141592653589793D / (double) var2));
			}
			int[] var12 = new int[var5];
			int var13 = MathTool.bitsRequired(var5 - 1);
			for (int var14 = 0; var14 < var5; var14++) {
				int var17 = var14;
				int var18 = var13;
				int var19 = 0;
				while (var18 > 0) {
					var19 = var19 << 1 | var17 & 0x1;
					var17 >>>= 0x1;
					var18--;
				}
				var12[var14] = var19;
			}
			if (var1 == 0) {
				imdctPrevShort = var6;
				imdctStepShort = var8;
				imdctPostShort = var10;
				bitReverseShort = var12;
			} else {
				imdctPrevLong = var6;
				imdctStepLong = var8;
				imdctPostLong = var10;
				bitReverseLong = var12;
			}
		}

		int codebook_count = readBits(8) + 1;
		codebooks = new CodeBook[codebook_count];
		for (int i = 0; i < codebook_count; i++) {
			codebooks[i] = new CodeBook();
		}

		// time domain transfers
		int x = readBits(6) + 1;
		for (int i = 0; i < x; i++) {
			readBits(16);
		}

		int floor_count = readBits(6) + 1;
		floor_config = new Floor[floor_count];
		for (int i = 0; i < floor_count; i++) {
			floor_config[i] = new Floor();
		}

		int residue_count = readBits(6) + 1;
		residue_config = new Residue[residue_count];
		for (int i = 0; i < residue_count; i++) {
			residue_config[i] = new Residue();
		}

		int mapping_count = readBits(6) + 1;
		mapping_config = new Mapping[mapping_count];
		for (int i = 0; i < mapping_count; i++) {
			mapping_config[i] = new Mapping();
		}

		int mode_count = readBits(6) + 1;
		blockflag = new boolean[mode_count];
		mapping = new int[mode_count];
		for (int i = 0; i < mode_count; i++) {
			blockflag[i] = readBit() != 0;
			readBits(16); // windowtype
			readBits(16); // transformtype
			mapping[i] = readBits(8);
		}
	}

	// jag::oldscape::sound::JagVorbis::DecodeAudioPacket
	@ObfuscatedName("dt.i(I)[F")
	public float[] decodeAudioPacket(int arg0) {
		setBitPos(this.audioPackets[arg0], 0);
		readBit();
		int var2 = readBits(MathTool.bitsRequired(mapping.length - 1));

		boolean var3 = blockflag[var2];
		int var4 = var3 ? blocksize1 : blocksize0;

		boolean var5 = false;
		boolean var6 = false;
		if (var3) {
			var5 = readBit() != 0;
			var6 = readBit() != 0;
		}

		int var7 = var4 >> 1;
		int var8;
		int var9;
		int var10;
		if (var3 && !var5) {
			var8 = (var4 >> 2) - (blocksize0 >> 2);
			var9 = (blocksize0 >> 2) + (var4 >> 2);
			var10 = blocksize0 >> 1;
		} else {
			var8 = 0;
			var9 = var7;
			var10 = var4 >> 1;
		}
		int var11;
		int var12;
		int var13;
		if (var3 && !var6) {
			var11 = var4 - (var4 >> 2) - (blocksize0 >> 2);
			var12 = (blocksize0 >> 2) + (var4 - (var4 >> 2));
			var13 = blocksize0 >> 1;
		} else {
			var11 = var7;
			var12 = var4;
			var13 = var4 >> 1;
		}
		Mapping var14 = mapping_config[mapping[var2]];
		int var15 = var14.mux;
		int var16 = var14.submap_floor[var15];
		boolean var17 = !floor_config[var16].packetDecode();
		boolean var18 = var17;
		for (int var19 = 0; var19 < var14.submaps; var19++) {
			Residue var20 = residue_config[var14.submap_residue[var19]];
			float[] var21 = workBuffer;
			var20.packetDecode(var21, var4 >> 1, var18);
		}
		if (!var17) {
			int var22 = var14.mux;
			int var23 = var14.submap_floor[var22];
			floor_config[var23].synthMul(workBuffer, var4 >> 1);
		}
		if (var17) {
			for (int var24 = var4 >> 1; var24 < var4; var24++) {
				workBuffer[var24] = 0.0F;
			}
		} else {
			int var25 = var4 >> 1;
			int var26 = var4 >> 2;
			int var27 = var4 >> 3;
			float[] var28 = workBuffer;
			for (int var29 = 0; var29 < var25; var29++) {
				var28[var29] *= 0.5F;
			}
			for (int var30 = var25; var30 < var4; var30++) {
				var28[var30] = -var28[var4 - var30 - 1];
			}
			float[] var31 = var3 ? imdctPrevLong : imdctPrevShort;
			float[] var32 = var3 ? imdctStepLong : imdctStepShort;
			float[] var33 = var3 ? imdctPostLong : imdctPostShort;
			int[] var34 = var3 ? bitReverseLong : bitReverseShort;
			for (int var35 = 0; var35 < var26; var35++) {
				float var36 = var28[var35 * 4] - var28[var4 - var35 * 4 - 1];
				float var37 = var28[var35 * 4 + 2] - var28[var4 - var35 * 4 - 3];
				float var38 = var31[var35 * 2];
				float var39 = var31[var35 * 2 + 1];
				var28[var4 - var35 * 4 - 1] = var36 * var38 - var37 * var39;
				var28[var4 - var35 * 4 - 3] = var36 * var39 + var37 * var38;
			}
			for (int var40 = 0; var40 < var27; var40++) {
				float var41 = var28[var40 * 4 + var25 + 3];
				float var42 = var28[var40 * 4 + var25 + 1];
				float var43 = var28[var40 * 4 + 3];
				float var44 = var28[var40 * 4 + 1];
				var28[var40 * 4 + var25 + 3] = var41 + var43;
				var28[var40 * 4 + var25 + 1] = var42 + var44;
				float var45 = var31[var25 - 4 - var40 * 4];
				float var46 = var31[var25 - 3 - var40 * 4];
				var28[var40 * 4 + 3] = (var41 - var43) * var45 - (var42 - var44) * var46;
				var28[var40 * 4 + 1] = (var41 - var43) * var46 + (var42 - var44) * var45;
			}
			int var47 = MathTool.bitsRequired(var4 - 1);
			for (int var48 = 0; var48 < var47 - 3; var48++) {
				int var49 = var4 >> var48 + 2;
				int var50 = 0x8 << var48;
				for (int var51 = 0; var51 < 0x2 << var48; var51++) {
					int var52 = var4 - var49 * 2 * var51;
					int var53 = var4 - (var51 * 2 + 1) * var49;
					for (int var54 = 0; var54 < var4 >> var48 + 4; var54++) {
						int var55 = var54 * 4;
						float var56 = var28[var52 - 1 - var55];
						float var57 = var28[var52 - 3 - var55];
						float var58 = var28[var53 - 1 - var55];
						float var59 = var28[var53 - 3 - var55];
						var28[var52 - 1 - var55] = var56 + var58;
						var28[var52 - 3 - var55] = var57 + var59;
						float var60 = var31[var50 * var54];
						float var61 = var31[var50 * var54 + 1];
						var28[var53 - 1 - var55] = (var56 - var58) * var60 - (var57 - var59) * var61;
						var28[var53 - 3 - var55] = (var56 - var58) * var61 + (var57 - var59) * var60;
					}
				}
			}
			for (int var62 = 1; var62 < var27 - 1; var62++) {
				int var63 = var34[var62];
				if (var62 < var63) {
					int var64 = var62 * 8;
					int var65 = var63 * 8;
					float var66 = var28[var64 + 1];
					var28[var64 + 1] = var28[var65 + 1];
					var28[var65 + 1] = var66;
					float var67 = var28[var64 + 3];
					var28[var64 + 3] = var28[var65 + 3];
					var28[var65 + 3] = var67;
					float var68 = var28[var64 + 5];
					var28[var64 + 5] = var28[var65 + 5];
					var28[var65 + 5] = var68;
					float var69 = var28[var64 + 7];
					var28[var64 + 7] = var28[var65 + 7];
					var28[var65 + 7] = var69;
				}
			}
			for (int var70 = 0; var70 < var25; var70++) {
				var28[var70] = var28[var70 * 2 + 1];
			}
			for (int var71 = 0; var71 < var27; var71++) {
				var28[var4 - 1 - var71 * 2] = var28[var71 * 4];
				var28[var4 - 2 - var71 * 2] = var28[var71 * 4 + 1];
				var28[var4 - var26 - 1 - var71 * 2] = var28[var71 * 4 + 2];
				var28[var4 - var26 - 2 - var71 * 2] = var28[var71 * 4 + 3];
			}
			for (int var72 = 0; var72 < var27; var72++) {
				float var73 = var33[var72 * 2];
				float var74 = var33[var72 * 2 + 1];
				float var75 = var28[var72 * 2 + var25];
				float var76 = var28[var72 * 2 + var25 + 1];
				float var77 = var28[var4 - 2 - var72 * 2];
				float var78 = var28[var4 - 1 - var72 * 2];
				float var79 = (var75 - var77) * var74 + (var76 + var78) * var73;
				var28[var72 * 2 + var25] = (var75 + var77 + var79) * 0.5F;
				var28[var4 - 2 - var72 * 2] = (var75 + var77 - var79) * 0.5F;
				float var80 = (var76 + var78) * var74 - (var75 - var77) * var73;
				var28[var72 * 2 + var25 + 1] = (var76 - var78 + var80) * 0.5F;
				var28[var4 - 1 - var72 * 2] = (-var76 + var78 + var80) * 0.5F;
			}
			for (int var81 = 0; var81 < var26; var81++) {
				var28[var81] = var32[var81 * 2] * var28[var81 * 2 + var25] + var32[var81 * 2 + 1] * var28[var81 * 2 + 1 + var25];
				var28[var25 - 1 - var81] = var28[var81 * 2 + var25] * var32[var81 * 2 + 1] - var32[var81 * 2] * var28[var81 * 2 + 1 + var25];
			}
			for (int var82 = 0; var82 < var26; var82++) {
				var28[var4 - var26 + var82] = -var28[var82];
			}
			for (int var83 = 0; var83 < var26; var83++) {
				var28[var83] = var28[var26 + var83];
			}
			for (int var84 = 0; var84 < var26; var84++) {
				var28[var26 + var84] = -var28[var26 - var84 - 1];
			}
			for (int var85 = 0; var85 < var26; var85++) {
				var28[var25 + var85] = var28[var4 - var85 - 1];
			}
			for (int var86 = var8; var86 < var9; var86++) {
				float var87 = (float) Math.sin(((double) (var86 - var8) + 0.5D) / (double) var10 * 0.5D * 3.141592653589793D);
				workBuffer[var86] *= (float) Math.sin((double) var87 * 1.5707963267948966D * (double) var87);
			}
			for (int var88 = var11; var88 < var12; var88++) {
				float var89 = (float) Math.sin(((double) (var88 - var11) + 0.5D) / (double) var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
				workBuffer[var88] *= (float) Math.sin((double) var89 * 1.5707963267948966D * (double) var89);
			}
		}
		float[] var90 = null;
		if (this.previousWindowSize > 0) {
			int var91 = this.previousWindowSize + var4 >> 2;
			var90 = new float[var91];
			if (!this.previousWindowUnused) {
				for (int var92 = 0; var92 < this.previousWindowRightStart; var92++) {
					int var93 = (this.previousWindowSize >> 1) + var92;
					var90[var92] += this.previousWindow[var93];
				}
			}
			if (!var17) {
				for (int var94 = var8; var94 < var4 >> 1; var94++) {
					int var95 = var90.length - (var4 >> 1) + var94;
					var90[var95] += workBuffer[var94];
				}
			}
		}
		float[] var96 = this.previousWindow;
		this.previousWindow = workBuffer;
		workBuffer = var96;
		this.previousWindowSize = var4;
		this.previousWindowRightStart = var12 - (var4 >> 1);
		this.previousWindowUnused = var17;
		return var90;
	}

	// jag::oldscape::sound::JagVorbis::GetHeaders
	@ObfuscatedName("dt.s(Lch;)Z")
	public static boolean getHeaders(Js5 arg0) {
		if (!gotHeaders) {
			byte[] var1 = arg0.getFile(0, 0);
			if (var1 == null) {
				return false;
			}
			processHeaders(var1);
			gotHeaders = true;
		}
		return true;
	}

	// jag::oldscape::sound::JagVorbis::Load
	@ObfuscatedName("dt.u(Lch;II)Ldt;")
	public static JagVorbis load(Js5 arg0, int arg1, int arg2) {
		if (getHeaders(arg0)) {
			byte[] var3 = arg0.getFile(arg1, arg2);
			return var3 == null ? null : new JagVorbis(var3);
		} else {
			arg0.requestDownload(arg1, arg2);
			return null;
		}
	}

	public JagVorbis(byte[] arg0) {
		this.decodeJagVorbis(arg0);
	}

	// jag::oldscape::sound::JagVorbis::ToWave
	@ObfuscatedName("dt.v([I)Leq;")
	public Wave toWave(int[] arg0) {
		if (arg0 != null && arg0[0] <= 0) {
			return null;
		}
		if (this.pcmData == null) {
			this.previousWindowSize = 0;
			this.previousWindow = new float[blocksize1];
			this.pcmData = new byte[this.sampleCount];
			this.pcmWritePosition = 0;
			this.currentPacketIndex = 0;
		}
		while (this.currentPacketIndex < this.audioPackets.length) {
			if (arg0 != null && arg0[0] <= 0) {
				return null;
			}
			float[] var2 = this.decodeAudioPacket(this.currentPacketIndex);
			if (var2 != null) {
				int var3 = this.pcmWritePosition;
				int var4 = var2.length;
				if (var4 > this.sampleCount - var3) {
					var4 = this.sampleCount - var3;
				}
				for (int var5 = 0; var5 < var4; var5++) {
					int var6 = (int) (var2[var5] * 128.0F + 128.0F);
					if ((var6 & 0xFFFFFF00) != 0) {
						var6 = ~var6 >> 31;
					}
					this.pcmData[var3++] = (byte) (var6 - 128);
				}
				if (arg0 != null) {
					arg0[0] -= var3 - this.pcmWritePosition;
				}
				this.pcmWritePosition = var3;
			}
			this.currentPacketIndex++;
		}
		this.previousWindow = null;
		byte[] var7 = this.pcmData;
		this.pcmData = null;
		return new Wave(this.sampleRate, var7, this.loopStart, this.loopEnd, this.hasLoop);
	}
}
