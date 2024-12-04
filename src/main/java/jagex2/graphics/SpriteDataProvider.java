package jagex2.graphics;

import deob.ObfuscatedName;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("al")
public class SpriteDataProvider {

	@ObfuscatedName("al.r")
	public static int field528;

	@ObfuscatedName("al.d")
	public static int field533;

	@ObfuscatedName("al.l")
	public static int field530;

	@ObfuscatedName("al.m")
	public static int[] field531;

	@ObfuscatedName("al.c")
	public static int[] field532;

	@ObfuscatedName("m.n")
	public static int[] field41;

	@ObfuscatedName("cl.j")
	public static int[] field1151;

	@ObfuscatedName("al.z")
	public static int[] field529;

	@ObfuscatedName("bp.g")
	public static byte[][] field863;

	public SpriteDataProvider() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("al.r(Lch;Ljava/lang/String;Ljava/lang/String;B)[Lft;")
	public static Pix8[] method541(Js5Index arg0, String arg1, String arg2) {
		int var3 = arg0.getGroupId(arg1);
		int var4 = arg0.getFileId(var3, arg2);
		Pix8[] var5;
		if (method905(arg0, var3, var4)) {
			Pix8[] var6 = new Pix8[field528];
			for (int var7 = 0; var7 < field528; var7++) {
				Pix8 var8 = var6[var7] = new Pix8();
				var8.field2517 = field533;
				var8.field2518 = field530;
				var8.field2515 = field531[var7];
				var8.field2516 = field532[var7];
				var8.field2513 = field41[var7];
				var8.field2514 = field1151[var7];
				var8.field2512 = field529;
				var8.field2511 = field863[var7];
			}
			field531 = null;
			field532 = null;
			field41 = null;
			field1151 = null;
			field529 = null;
			field863 = null;
			var5 = var6;
		} else {
			var5 = null;
		}
		return var5;
	}

	@ObfuscatedName("ak.d(Lch;Ljava/lang/String;Ljava/lang/String;I)Lft;")
	public static Pix8 method457(Js5Index arg0, String arg1, String arg2) {
		int var3 = arg0.getGroupId(arg1);
		int var4 = arg0.getFileId(var3, arg2);
		Pix8 var5;
		if (method905(arg0, var3, var4)) {
			var5 = method556();
		} else {
			var5 = null;
		}
		return var5;
	}

	@ObfuscatedName("bx.l(Lch;Ljava/lang/String;Ljava/lang/String;I)[Lfq;")
	public static Pix32[] method830(Js5Index arg0, String arg1, String arg2) {
		int var3 = arg0.getGroupId(arg1);
		int var4 = arg0.getFileId(var3, arg2);
		Pix32[] var5;
		if (method905(arg0, var3, var4)) {
			Pix32[] var6 = new Pix32[field528];
			for (int var7 = 0; var7 < field528; var7++) {
				Pix32 var8 = var6[var7] = new Pix32();
				var8.field2504 = field533;
				var8.field2505 = field530;
				var8.field2502 = field531[var7];
				var8.field2499 = field532[var7];
				var8.field2508 = field41[var7];
				var8.field2501 = field1151[var7];
				int var9 = var8.field2508 * var8.field2501;
				byte[] var10 = field863[var7];
				var8.field2506 = new int[var9];
				for (int var11 = 0; var11 < var9; var11++) {
					var8.field2506[var11] = field529[var10[var11] & 0xFF];
				}
			}
			field531 = null;
			field532 = null;
			field41 = null;
			field1151 = null;
			field529 = null;
			field863 = null;
			var5 = var6;
		} else {
			var5 = null;
		}
		return var5;
	}

	@ObfuscatedName("r.m(Lch;Ljava/lang/String;Ljava/lang/String;I)Lfq;")
	public static Pix32 method4(Js5Index arg0, String arg1, String arg2) {
		int var3 = arg0.getGroupId(arg1);
		int var4 = arg0.getFileId(var3, arg2);
		Pix32 var5;
		if (method905(arg0, var3, var4)) {
			var5 = method759();
		} else {
			var5 = null;
		}
		return var5;
	}

	@ObfuscatedName("bw.c(Lch;Lch;Ljava/lang/String;Ljava/lang/String;I)Lfm;")
	public static SoftwareFont method817(Js5Index arg0, Js5Index arg1, String arg2, String arg3) {
		int var4 = arg0.getGroupId(arg2);
		int var5 = arg0.getFileId(var4, arg3);
		SoftwareFont var6;
		if (method905(arg0, var4, var5)) {
			var6 = method260(arg1.getFile(var4, var5));
		} else {
			var6 = null;
		}
		return var6;
	}

	@ObfuscatedName("u.n(Lch;II)Lft;")
	public static Pix8 method127(Js5Index arg0, int arg1) {
		return method728(arg0, arg1) ? method556() : null;
	}

	@ObfuscatedName("ao.j(I)Lft;")
	public static Pix8 method556() {
		Pix8 var0 = new Pix8();
		var0.field2517 = field533;
		var0.field2518 = field530;
		var0.field2515 = field531[0];
		var0.field2516 = field532[0];
		var0.field2513 = field41[0];
		var0.field2514 = field1151[0];
		var0.field2512 = field529;
		var0.field2511 = field863[0];
		field531 = null;
		field532 = null;
		field41 = null;
		field1151 = null;
		field529 = null;
		field863 = null;
		return var0;
	}

	@ObfuscatedName("bi.z(I)Lfq;")
	public static Pix32 method759() {
		Pix32 var0 = new Pix32();
		var0.field2504 = field533;
		var0.field2505 = field530;
		var0.field2502 = field531[0];
		var0.field2499 = field532[0];
		var0.field2508 = field41[0];
		var0.field2501 = field1151[0];
		int var1 = var0.field2508 * var0.field2501;
		byte[] var2 = field863[0];
		var0.field2506 = new int[var1];
		for (int var3 = 0; var3 < var1; var3++) {
			var0.field2506[var3] = field529[var2[var3] & 0xFF];
		}
		field531 = null;
		field532 = null;
		field41 = null;
		field1151 = null;
		field529 = null;
		field863 = null;
		return var0;
	}

	@ObfuscatedName("y.g([BI)Lfm;")
	public static SoftwareFont method260(byte[] arg0) {
		if (arg0 == null) {
			return null;
		}
		SoftwareFont var1 = new SoftwareFont(arg0, field531, field532, field41, field1151, field529, field863);
		field531 = null;
		field532 = null;
		field41 = null;
		field1151 = null;
		field529 = null;
		field863 = null;
		return var1;
	}

	@ObfuscatedName("bn.q(Lch;III)Z")
	public static boolean method905(Js5Index arg0, int arg1, int arg2) {
		byte[] var3 = arg0.getFile(arg1, arg2);
		if (var3 == null) {
			return false;
		} else {
			method314(var3);
			return true;
		}
	}

	@ObfuscatedName("ai.i(Lch;II)Z")
	public static boolean method728(Js5Index arg0, int arg1) {
		byte[] var2 = arg0.fetchFile(arg1);
		if (var2 == null) {
			return false;
		} else {
			method314(var2);
			return true;
		}
	}

	@ObfuscatedName("a.s([BB)V")
	public static void method314(byte[] arg0) {
		Packet var1 = new Packet(arg0);
		var1.pos = arg0.length - 2;
		field528 = var1.g2();
		field531 = new int[field528];
		field532 = new int[field528];
		field41 = new int[field528];
		field1151 = new int[field528];
		field863 = new byte[field528][];
		var1.pos = arg0.length - 7 - field528 * 8;
		field533 = var1.g2();
		field530 = var1.g2();
		int var2 = (var1.g1() & 0xFF) + 1;
		for (int var3 = 0; var3 < field528; var3++) {
			field531[var3] = var1.g2();
		}
		for (int var4 = 0; var4 < field528; var4++) {
			field532[var4] = var1.g2();
		}
		for (int var5 = 0; var5 < field528; var5++) {
			field41[var5] = var1.g2();
		}
		for (int var6 = 0; var6 < field528; var6++) {
			field1151[var6] = var1.g2();
		}
		var1.pos = arg0.length - 7 - field528 * 8 - (var2 - 1) * 3;
		field529 = new int[var2];
		for (int var7 = 1; var7 < var2; var7++) {
			field529[var7] = var1.g3();
			if (field529[var7] == 0) {
				field529[var7] = 1;
			}
		}
		var1.pos = 0;
		for (int var8 = 0; var8 < field528; var8++) {
			int var9 = field41[var8];
			int var10 = field1151[var8];
			int var11 = var9 * var10;
			byte[] var12 = new byte[var11];
			field863[var8] = var12;
			int var13 = var1.g1();
			if (var13 == 0) {
				for (int var14 = 0; var14 < var11; var14++) {
					var12[var14] = var1.g1b();
				}
			} else if (var13 == 1) {
				for (int var15 = 0; var15 < var9; var15++) {
					for (int var16 = 0; var16 < var10; var16++) {
						var12[var9 * var16 + var15] = var1.g1b();
					}
				}
			}
		}
	}
}
