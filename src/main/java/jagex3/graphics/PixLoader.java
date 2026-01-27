package jagex3.graphics;

import deob.ObfuscatedName;
import jagex3.io.Packet;
import jagex3.js5.Js5;

@ObfuscatedName("al")
public class PixLoader {

	// jag::oldscape::graphics::pixloader::m_count
	@ObfuscatedName("al.r")
	public static int count;

	// jag::oldscape::graphics::pixloader::m_owi
	@ObfuscatedName("al.d")
	public static int owi;

	// jag::oldscape::graphics::pixloader::m_ohi
	@ObfuscatedName("al.l")
	public static int ohi;

	// jag::oldscape::graphics::pixloader::m_xof
	@ObfuscatedName("al.m")
	public static int[] xof;

	// jag::oldscape::graphics::pixloader::m_yof
	@ObfuscatedName("al.c")
	public static int[] yof;

	// jag::oldscape::graphics::pixloader::m_wi
	@ObfuscatedName("m.n")
	public static int[] wi;

	// jag::oldscape::graphics::pixloader::m_hi
	@ObfuscatedName("cl.j")
	public static int[] hi;

	// jag::oldscape::graphics::pixloader::m_bpal
	@ObfuscatedName("al.z")
	public static int[] bpal;

	// jag::oldscape::graphics::pixloader::m_bspr
	@ObfuscatedName("bp.g")
	public static byte[][] bspr;

	public PixLoader() throws Throwable {
		throw new Error();
	}

	// jag::oldscape::graphics::pixloader::Makepix8Array
	@ObfuscatedName("al.r(Lch;Ljava/lang/String;Ljava/lang/String;B)[Lft;")
	public static Pix8[] makePix8Array(Js5 arg0, String arg1, String arg2) {
		int var3 = arg0.getGroupId(arg1);
		int var4 = arg0.getFileId(var3, arg2);
		Pix8[] var5;
		if (depack(arg0, var3, var4)) {
			Pix8[] var6 = new Pix8[count];
			for (int var7 = 0; var7 < count; var7++) {
				Pix8 var8 = var6[var7] = new Pix8();
				var8.owi = owi;
				var8.ohi = ohi;
				var8.xof = xof[var7];
				var8.yof = yof[var7];
				var8.wi = wi[var7];
				var8.hi = hi[var7];
				var8.bpal = bpal;
				var8.data = bspr[var7];
			}
			xof = null;
			yof = null;
			wi = null;
			hi = null;
			bpal = null;
			bspr = null;
			var5 = var6;
		} else {
			var5 = null;
		}
		return var5;
	}

	// jag::oldscape::graphics::pixloader::Makepix8
	@ObfuscatedName("ak.d(Lch;Ljava/lang/String;Ljava/lang/String;I)Lft;")
	public static Pix8 makePix8(Js5 arg0, String arg1, String arg2) {
		int var3 = arg0.getGroupId(arg1);
		int var4 = arg0.getFileId(var3, arg2);
		Pix8 var5;
		if (depack(arg0, var3, var4)) {
			var5 = makePix8();
		} else {
			var5 = null;
		}
		return var5;
	}

	// jag::oldscape::graphics::pixloader::Makepix32Array
	@ObfuscatedName("bx.l(Lch;Ljava/lang/String;Ljava/lang/String;I)[Lfq;")
	public static Pix32[] makePix32Array(Js5 arg0, String arg1, String arg2) {
		int var3 = arg0.getGroupId(arg1);
		int var4 = arg0.getFileId(var3, arg2);
		Pix32[] var5;
		if (depack(arg0, var3, var4)) {
			Pix32[] var6 = new Pix32[count];
			for (int var7 = 0; var7 < count; var7++) {
				Pix32 var8 = var6[var7] = new Pix32();
				var8.owi = owi;
				var8.ohi = ohi;
				var8.xof = xof[var7];
				var8.yof = yof[var7];
				var8.wi = wi[var7];
				var8.hi = hi[var7];
				int var9 = var8.wi * var8.hi;
				byte[] var10 = bspr[var7];
				var8.data = new int[var9];
				for (int var11 = 0; var11 < var9; var11++) {
					var8.data[var11] = bpal[var10[var11] & 0xFF];
				}
			}
			xof = null;
			yof = null;
			wi = null;
			hi = null;
			bpal = null;
			bspr = null;
			var5 = var6;
		} else {
			var5 = null;
		}
		return var5;
	}

	// jag::oldscape::graphics::pixloader::Makepix32
	@ObfuscatedName("r.m(Lch;Ljava/lang/String;Ljava/lang/String;I)Lfq;")
	public static Pix32 makePix32(Js5 arg0, String arg1, String arg2) {
		int var3 = arg0.getGroupId(arg1);
		int var4 = arg0.getFileId(var3, arg2);
		Pix32 var5;
		if (depack(arg0, var3, var4)) {
			var5 = makePix32();
		} else {
			var5 = null;
		}
		return var5;
	}

	// jag::oldscape::graphics::pixloader::MakepixfontGeneric
	@ObfuscatedName("bw.c(Lch;Lch;Ljava/lang/String;Ljava/lang/String;I)Lfm;")
	public static PixFontGeneric makePixFont(Js5 arg0, Js5 arg1, String arg2, String arg3) {
		int var4 = arg0.getGroupId(arg2);
		int var5 = arg0.getFileId(var4, arg3);
		PixFontGeneric var6;
		if (depack(arg0, var4, var5)) {
			var6 = makePixFont(arg1.getFile(var4, var5));
		} else {
			var6 = null;
		}
		return var6;
	}

	// jag::oldscape::graphics::pixloader::Makepix8
	@ObfuscatedName("u.n(Lch;II)Lft;")
	public static Pix8 makePix8(Js5 arg0, int arg1) {
		if (!depack(arg0, arg1)) {
			return null;
		}

		return makePix8();
	}

	// jag::oldscape::graphics::pixloader::Makepix8
	@ObfuscatedName("ao.j(I)Lft;")
	public static Pix8 makePix8() {
		Pix8 var0 = new Pix8();
		var0.owi = owi;
		var0.ohi = ohi;
		var0.xof = xof[0];
		var0.yof = yof[0];
		var0.wi = wi[0];
		var0.hi = hi[0];
		var0.bpal = bpal;
		var0.data = bspr[0];
		xof = null;
		yof = null;
		wi = null;
		hi = null;
		bpal = null;
		bspr = null;
		return var0;
	}

	// jag::oldscape::graphics::pixloader::Makepix32
	@ObfuscatedName("bi.z(I)Lfq;")
	public static Pix32 makePix32() {
		Pix32 var0 = new Pix32();
		var0.owi = owi;
		var0.ohi = ohi;
		var0.xof = xof[0];
		var0.yof = yof[0];
		var0.wi = wi[0];
		var0.hi = hi[0];
		int var1 = var0.wi * var0.hi;
		byte[] var2 = bspr[0];
		var0.data = new int[var1];
		for (int var3 = 0; var3 < var1; var3++) {
			var0.data[var3] = bpal[var2[var3] & 0xFF];
		}
		xof = null;
		yof = null;
		wi = null;
		hi = null;
		bpal = null;
		bspr = null;
		return var0;
	}

	// jag::oldscape::graphics::pixloader::MakepixfontGeneric
	@ObfuscatedName("y.g([BI)Lfm;")
	public static PixFontGeneric makePixFont(byte[] arg0) {
		if (arg0 == null) {
			return null;
		}
		PixFontGeneric var1 = new PixFontGeneric(arg0, xof, yof, wi, hi, bpal, bspr);
		xof = null;
		yof = null;
		wi = null;
		hi = null;
		bpal = null;
		bspr = null;
		return var1;
	}

	// jag::oldscape::graphics::pixloader::Depack
	@ObfuscatedName("bn.q(Lch;III)Z")
	public static boolean depack(Js5 arg0, int arg1, int arg2) {
		byte[] var3 = arg0.getFile(arg1, arg2);
		if (var3 == null) {
			return false;
		} else {
			depack(var3);
			return true;
		}
	}

	// jag::oldscape::graphics::pixloader::Depack
	@ObfuscatedName("ai.i(Lch;II)Z")
	public static boolean depack(Js5 arg0, int arg1) {
		byte[] var2 = arg0.getFile(arg1);
		if (var2 == null) {
			return false;
		} else {
			depack(var2);
			return true;
		}
	}

	// jag::oldscape::graphics::pixloader::Depack
	@ObfuscatedName("a.s([BB)V")
	public static void depack(byte[] arg0) {
		Packet var1 = new Packet(arg0);
		var1.pos = arg0.length - 2;

		count = var1.g2();
		xof = new int[count];
		yof = new int[count];
		wi = new int[count];
		hi = new int[count];
		bspr = new byte[count][];

		var1.pos = arg0.length - 7 - count * 8;
		owi = var1.g2();
		ohi = var1.g2();

		int var2 = (var1.g1() & 0xFF) + 1;

		for (int var3 = 0; var3 < count; var3++) {
			xof[var3] = var1.g2();
		}

		for (int var4 = 0; var4 < count; var4++) {
			yof[var4] = var1.g2();
		}

		for (int var5 = 0; var5 < count; var5++) {
			wi[var5] = var1.g2();
		}

		for (int var6 = 0; var6 < count; var6++) {
			hi[var6] = var1.g2();
		}

		var1.pos = arg0.length - 7 - count * 8 - (var2 - 1) * 3;
		bpal = new int[var2];
		for (int var7 = 1; var7 < var2; var7++) {
			bpal[var7] = var1.g3();
			if (bpal[var7] == 0) {
				bpal[var7] = 1;
			}
		}

		var1.pos = 0;
		for (int var8 = 0; var8 < count; var8++) {
			int var9 = wi[var8];
			int var10 = hi[var8];
			int var11 = var9 * var10;

			byte[] var12 = new byte[var11];
			bspr[var8] = var12;

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
