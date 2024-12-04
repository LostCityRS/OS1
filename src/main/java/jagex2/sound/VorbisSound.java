package jagex2.sound;

import deob.ObfuscatedName;
import jagex2.datastruct.IntUtil;
import jagex2.datastruct.Linkable;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("dt")
public class VorbisSound extends Linkable {

	@ObfuscatedName("dt.m")
	public byte[][] field1674;

	@ObfuscatedName("dt.c")
	public int field1648;

	@ObfuscatedName("dt.n")
	public int field1670;

	@ObfuscatedName("dt.j")
	public int field1676;

	@ObfuscatedName("dt.z")
	public int field1677;

	@ObfuscatedName("dt.g")
	public boolean field1652;

	@ObfuscatedName("dt.q")
	public static byte[] field1653;

	@ObfuscatedName("dt.i")
	public static int field1654;

	@ObfuscatedName("dt.s")
	public static int field1655;

	@ObfuscatedName("dt.u")
	public static int field1650;

	@ObfuscatedName("dt.v")
	public static int field1657;

	@ObfuscatedName("dt.w")
	public static VorbisCookbook[] field1658;

	@ObfuscatedName("dt.e")
	public static VorbisFloor[] field1659;

	@ObfuscatedName("dt.b")
	public static VorbisResidue[] field1668;

	@ObfuscatedName("dt.y")
	public static VorbisMapping[] field1661;

	@ObfuscatedName("dt.t")
	public static boolean[] field1662;

	@ObfuscatedName("dt.f")
	public static int[] field1663;

	@ObfuscatedName("dt.k")
	public static boolean field1664 = false;

	@ObfuscatedName("dt.o")
	public float[] field1665;

	@ObfuscatedName("dt.a")
	public int field1666;

	@ObfuscatedName("dt.h")
	public int field1667;

	@ObfuscatedName("dt.x")
	public boolean field1651;

	@ObfuscatedName("dt.p")
	public static float[] field1649;

	@ObfuscatedName("dt.ad")
	public static float[] field1669;

	@ObfuscatedName("dt.ac")
	public static float[] field1671;

	@ObfuscatedName("dt.aa")
	public static float[] field1672;

	@ObfuscatedName("dt.as")
	public static float[] field1673;

	@ObfuscatedName("dt.am")
	public static float[] field1678;

	@ObfuscatedName("dt.ap")
	public static float[] field1675;

	@ObfuscatedName("dt.av")
	public static int[] field1656;

	@ObfuscatedName("dt.ak")
	public static int[] field1647;

	@ObfuscatedName("dt.az")
	public byte[] field1660;

	@ObfuscatedName("dt.an")
	public int field1679;

	@ObfuscatedName("dt.ah")
	public int field1680;

	@ObfuscatedName("dt.c(I)F")
	public static float method1540(int arg0) {
		int var1 = arg0 & 0x1FFFFF;
		int var2 = arg0 & Integer.MIN_VALUE;
		int var3 = arg0 >> 21 & 0x3FF;
		if (var2 != 0) {
			var1 = -var1;
		}
		return (float) ((double) var1 * Math.pow(2.0D, (double) (var3 - 788)));
	}

	@ObfuscatedName("dt.n([BI)V")
	public static void method1536(byte[] arg0, int arg1) {
		field1653 = arg0;
		field1654 = arg1;
		field1655 = 0;
	}

	@ObfuscatedName("dt.j()I")
	public static int method1553() {
		int var0 = field1653[field1654] >> field1655 & 0x1;
		field1655++;
		field1654 += field1655 >> 3;
		field1655 &= 0x7;
		return var0;
	}

	@ObfuscatedName("dt.z(I)I")
	public static int method1561(int arg0) {
		int var1 = 0;
		int var2 = 0;
		while (arg0 >= 8 - field1655) {
			int var3 = 8 - field1655;
			int var4 = (0x1 << var3) - 1;
			var1 += (field1653[field1654] >> field1655 & var4) << var2;
			field1655 = 0;
			field1654++;
			var2 += var3;
			arg0 -= var3;
		}
		if (arg0 > 0) {
			int var5 = (0x1 << arg0) - 1;
			var1 += (field1653[field1654] >> field1655 & var5) << var2;
			field1655 += arg0;
		}
		return var1;
	}

	@ObfuscatedName("dt.g([B)V")
	public void method1535(byte[] arg0) {
		Packet var2 = new Packet(arg0);
		this.field1648 = var2.g4();
		this.field1670 = var2.g4();
		this.field1676 = var2.g4();
		this.field1677 = var2.g4();
		if (this.field1677 < 0) {
			this.field1677 = ~this.field1677;
			this.field1652 = true;
		}
		int var3 = var2.g4();
		this.field1674 = new byte[var3][];
		for (int var4 = 0; var4 < var3; var4++) {
			int var5 = 0;
			int var6;
			do {
				var6 = var2.g1();
				var5 += var6;
			} while (var6 >= 255);
			byte[] var7 = new byte[var5];
			var2.gdata(var7, 0, var5);
			this.field1674[var4] = var7;
		}
	}

	@ObfuscatedName("dt.q([B)V")
	public static void method1551(byte[] arg0) {
		method1536(arg0, 0);
		field1650 = 0x1 << method1561(4);
		field1657 = 0x1 << method1561(4);
		field1649 = new float[field1657];
		for (int var1 = 0; var1 < 2; var1++) {
			int var2 = var1 == 0 ? field1650 : field1657;
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
			int var13 = IntUtil.method479(var5 - 1);
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
				field1669 = var6;
				field1671 = var8;
				field1672 = var10;
				field1656 = var12;
			} else {
				field1673 = var6;
				field1678 = var8;
				field1675 = var10;
				field1647 = var12;
			}
		}
		int var21 = method1561(8) + 1;
		field1658 = new VorbisCookbook[var21];
		for (int var22 = 0; var22 < var21; var22++) {
			field1658[var22] = new VorbisCookbook();
		}
		int var23 = method1561(6) + 1;
		for (int var24 = 0; var24 < var23; var24++) {
			method1561(16);
		}
		int var25 = method1561(6) + 1;
		field1659 = new VorbisFloor[var25];
		for (int var26 = 0; var26 < var25; var26++) {
			field1659[var26] = new VorbisFloor();
		}
		int var27 = method1561(6) + 1;
		field1668 = new VorbisResidue[var27];
		for (int var28 = 0; var28 < var27; var28++) {
			field1668[var28] = new VorbisResidue();
		}
		int var29 = method1561(6) + 1;
		field1661 = new VorbisMapping[var29];
		for (int var30 = 0; var30 < var29; var30++) {
			field1661[var30] = new VorbisMapping();
		}
		int var31 = method1561(6) + 1;
		field1662 = new boolean[var31];
		field1663 = new int[var31];
		for (int var32 = 0; var32 < var31; var32++) {
			field1662[var32] = method1553() != 0;
			method1561(16);
			method1561(16);
			field1663[var32] = method1561(8);
		}
	}

	@ObfuscatedName("dt.i(I)[F")
	public float[] method1541(int arg0) {
		method1536(this.field1674[arg0], 0);
		method1553();
		int var2 = method1561(IntUtil.method479(field1663.length - 1));
		boolean var3 = field1662[var2];
		int var4 = var3 ? field1657 : field1650;
		boolean var5 = false;
		boolean var6 = false;
		if (var3) {
			var5 = method1553() != 0;
			var6 = method1553() != 0;
		}
		int var7 = var4 >> 1;
		int var8;
		int var9;
		int var10;
		if (var3 && !var5) {
			var8 = (var4 >> 2) - (field1650 >> 2);
			var9 = (field1650 >> 2) + (var4 >> 2);
			var10 = field1650 >> 1;
		} else {
			var8 = 0;
			var9 = var7;
			var10 = var4 >> 1;
		}
		int var11;
		int var12;
		int var13;
		if (var3 && !var6) {
			var11 = var4 - (var4 >> 2) - (field1650 >> 2);
			var12 = (field1650 >> 2) + (var4 - (var4 >> 2));
			var13 = field1650 >> 1;
		} else {
			var11 = var7;
			var12 = var4;
			var13 = var4 >> 1;
		}
		VorbisMapping var14 = field1661[field1663[var2]];
		int var15 = var14.field232;
		int var16 = var14.field234[var15];
		boolean var17 = !field1659[var16].method187();
		boolean var18 = var17;
		for (int var19 = 0; var19 < var14.field231; var19++) {
			VorbisResidue var20 = field1668[var14.field233[var19]];
			float[] var21 = field1649;
			var20.method317(var21, var4 >> 1, var18);
		}
		if (!var17) {
			int var22 = var14.field232;
			int var23 = var14.field234[var22];
			field1659[var23].method188(field1649, var4 >> 1);
		}
		if (var17) {
			for (int var24 = var4 >> 1; var24 < var4; var24++) {
				field1649[var24] = 0.0F;
			}
		} else {
			int var25 = var4 >> 1;
			int var26 = var4 >> 2;
			int var27 = var4 >> 3;
			float[] var28 = field1649;
			for (int var29 = 0; var29 < var25; var29++) {
				var28[var29] *= 0.5F;
			}
			for (int var30 = var25; var30 < var4; var30++) {
				var28[var30] = -var28[var4 - var30 - 1];
			}
			float[] var31 = var3 ? field1673 : field1669;
			float[] var32 = var3 ? field1678 : field1671;
			float[] var33 = var3 ? field1675 : field1672;
			int[] var34 = var3 ? field1647 : field1656;
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
			int var47 = IntUtil.method479(var4 - 1);
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
				field1649[var86] *= (float) Math.sin((double) var87 * 1.5707963267948966D * (double) var87);
			}
			for (int var88 = var11; var88 < var12; var88++) {
				float var89 = (float) Math.sin(((double) (var88 - var11) + 0.5D) / (double) var13 * 0.5D * 3.141592653589793D + 1.5707963267948966D);
				field1649[var88] *= (float) Math.sin((double) var89 * 1.5707963267948966D * (double) var89);
			}
		}
		float[] var90 = null;
		if (this.field1666 > 0) {
			int var91 = this.field1666 + var4 >> 2;
			var90 = new float[var91];
			if (!this.field1651) {
				for (int var92 = 0; var92 < this.field1667; var92++) {
					int var93 = (this.field1666 >> 1) + var92;
					var90[var92] += this.field1665[var93];
				}
			}
			if (!var17) {
				for (int var94 = var8; var94 < var4 >> 1; var94++) {
					int var95 = var90.length - (var4 >> 1) + var94;
					var90[var95] += field1649[var94];
				}
			}
		}
		float[] var96 = this.field1665;
		this.field1665 = field1649;
		field1649 = var96;
		this.field1666 = var4;
		this.field1667 = var12 - (var4 >> 1);
		this.field1651 = var17;
		return var90;
	}

	@ObfuscatedName("dt.s(Lch;)Z")
	public static boolean method1542(Js5Index arg0) {
		if (!field1664) {
			byte[] var1 = arg0.getFile(0, 0);
			if (var1 == null) {
				return false;
			}
			method1551(var1);
			field1664 = true;
		}
		return true;
	}

	@ObfuscatedName("dt.u(Lch;II)Ldt;")
	public static VorbisSound method1543(Js5Index arg0, int arg1, int arg2) {
		if (method1542(arg0)) {
			byte[] var3 = arg0.getFile(arg1, arg2);
			return var3 == null ? null : new VorbisSound(var3);
		} else {
			arg0.requestDownload(arg1, arg2);
			return null;
		}
	}

	public VorbisSound(byte[] arg0) {
		this.method1535(arg0);
	}

	@ObfuscatedName("dt.v([I)Leq;")
	public PcmSound method1539(int[] arg0) {
		if (arg0 != null && arg0[0] <= 0) {
			return null;
		}
		if (this.field1660 == null) {
			this.field1666 = 0;
			this.field1665 = new float[field1657];
			this.field1660 = new byte[this.field1670];
			this.field1679 = 0;
			this.field1680 = 0;
		}
		while (this.field1680 < this.field1674.length) {
			if (arg0 != null && arg0[0] <= 0) {
				return null;
			}
			float[] var2 = this.method1541(this.field1680);
			if (var2 != null) {
				int var3 = this.field1679;
				int var4 = var2.length;
				if (var4 > this.field1670 - var3) {
					var4 = this.field1670 - var3;
				}
				for (int var5 = 0; var5 < var4; var5++) {
					int var6 = (int) (var2[var5] * 128.0F + 128.0F);
					if ((var6 & 0xFFFFFF00) != 0) {
						var6 = ~var6 >> 31;
					}
					this.field1660[var3++] = (byte) (var6 - 128);
				}
				if (arg0 != null) {
					arg0[0] -= var3 - this.field1679;
				}
				this.field1679 = var3;
			}
			this.field1680++;
		}
		this.field1665 = null;
		byte[] var7 = this.field1660;
		this.field1660 = null;
		return new PcmSound(this.field1648, var7, this.field1676, this.field1677, this.field1652);
	}
}
