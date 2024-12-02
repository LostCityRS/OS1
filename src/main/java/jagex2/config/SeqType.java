package jagex2.config;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.graphics.AnimFrameset;
import jagex2.graphics.SoftwareModel;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("eo")
public class SeqType extends DoublyLinkable {

	@ObfuscatedName("eo.g")
	public static LruCache field2362 = new LruCache(64);

	@ObfuscatedName("eo.q")
	public static LruCache field2370 = new LruCache(100);

	@ObfuscatedName("eo.i")
	public int[] field2364;

	@ObfuscatedName("eo.s")
	public int[] field2365;

	@ObfuscatedName("eo.u")
	public int[] field2366;

	@ObfuscatedName("eo.v")
	public int[] field2367;

	@ObfuscatedName("eo.w")
	public int field2368 = -1;

	@ObfuscatedName("eo.e")
	public int[] field2369;

	@ObfuscatedName("eo.b")
	public boolean field2374 = false;

	@ObfuscatedName("eo.y")
	public int field2371 = 5;

	@ObfuscatedName("eo.t")
	public int field2372 = -1;

	@ObfuscatedName("eo.f")
	public int field2373 = -1;

	@ObfuscatedName("eo.k")
	public int field2363 = 99;

	@ObfuscatedName("eo.o")
	public int field2375 = -1;

	@ObfuscatedName("eo.a")
	public int field2376 = -1;

	@ObfuscatedName("eo.h")
	public int field2377 = 2;

	@ObfuscatedName("ai.z(Lch;Lch;Lch;I)V")
	public static void method727(Js5Index arg0, Js5Index arg1, Js5Index arg2) {
		Statics.field1517 = arg0;
		Statics.field556 = arg1;
		Statics.field2361 = arg2;
	}

	@ObfuscatedName("i.g(IB)Leo;")
	public static SeqType method104(int arg0) {
		SeqType var1 = (SeqType) field2362.method1244((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = Statics.field1517.method1044(12, arg0);
		SeqType var3 = new SeqType();
		if (var2 != null) {
			var3.method2415(new Packet(var2));
		}
		var3.method2417();
		field2362.method1246(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("eo.q(Lev;S)V")
	public void method2415(Packet arg0) {
		while (true) {
			int var2 = arg0.method1600();
			if (var2 == 0) {
				return;
			}
			this.method2416(arg0, var2);
		}
	}

	@ObfuscatedName("eo.i(Lev;IB)V")
	public void method2416(Packet arg0, int arg1) {
		if (arg1 == 1) {
			int var3 = arg0.method1602();
			this.field2366 = new int[var3];
			for (int var4 = 0; var4 < var3; var4++) {
				this.field2366[var4] = arg0.method1602();
			}
			this.field2364 = new int[var3];
			for (int var5 = 0; var5 < var3; var5++) {
				this.field2364[var5] = arg0.method1602();
			}
			for (int var6 = 0; var6 < var3; var6++) {
				this.field2364[var6] += arg0.method1602() << 16;
			}
		} else if (arg1 == 2) {
			this.field2368 = arg0.method1602();
		} else if (arg1 == 3) {
			int var7 = arg0.method1600();
			this.field2369 = new int[var7 + 1];
			for (int var8 = 0; var8 < var7; var8++) {
				this.field2369[var8] = arg0.method1600();
			}
			this.field2369[var7] = 9999999;
		} else if (arg1 == 4) {
			this.field2374 = true;
		} else if (arg1 == 5) {
			this.field2371 = arg0.method1600();
		} else if (arg1 == 6) {
			this.field2372 = arg0.method1602();
		} else if (arg1 == 7) {
			this.field2373 = arg0.method1602();
		} else if (arg1 == 8) {
			this.field2363 = arg0.method1600();
		} else if (arg1 == 9) {
			this.field2375 = arg0.method1600();
		} else if (arg1 == 10) {
			this.field2376 = arg0.method1600();
		} else if (arg1 == 11) {
			this.field2377 = arg0.method1600();
		} else if (arg1 == 12) {
			int var9 = arg0.method1600();
			this.field2365 = new int[var9];
			for (int var10 = 0; var10 < var9; var10++) {
				this.field2365[var10] = arg0.method1602();
			}
			for (int var11 = 0; var11 < var9; var11++) {
				this.field2365[var11] += arg0.method1602() << 16;
			}
		} else if (arg1 == 13) {
			int var12 = arg0.method1600();
			this.field2367 = new int[var12];
			for (int var13 = 0; var13 < var12; var13++) {
				this.field2367[var13] = arg0.method1728();
			}
		}
	}

	@ObfuscatedName("eo.s(B)V")
	public void method2417() {
		if (this.field2375 == -1) {
			if (this.field2369 == null) {
				this.field2375 = 0;
			} else {
				this.field2375 = 2;
			}
		}
		if (this.field2376 != -1) {
			return;
		}
		if (this.field2369 == null) {
			this.field2376 = 0;
		} else {
			this.field2376 = 2;
		}
	}

	@ObfuscatedName("eo.u(Lfo;II)Lfo;")
	public SoftwareModel method2436(SoftwareModel arg0, int arg1) {
		int var3 = this.field2364[arg1];
		AnimFrameset var4 = method760(var3 >> 16);
		int var5 = var3 & 0xFFFF;
		if (var4 == null) {
			return arg0.method2999(true);
		} else {
			SoftwareModel var6 = arg0.method2999(!var4.method2652(var5));
			var6.method3005(var4, var5);
			return var6;
		}
	}

	@ObfuscatedName("eo.v(Lfo;IIB)Lfo;")
	public SoftwareModel method2419(SoftwareModel arg0, int arg1, int arg2) {
		int var4 = this.field2364[arg1];
		AnimFrameset var5 = method760(var4 >> 16);
		int var6 = var4 & 0xFFFF;
		if (var5 == null) {
			return arg0.method2999(true);
		}
		SoftwareModel var7 = arg0.method2999(!var5.method2652(var6));
		int var8 = arg2 & 0x3;
		if (var8 == 1) {
			var7.method3010();
		} else if (var8 == 2) {
			var7.method3009();
		} else if (var8 == 3) {
			var7.method3008();
		}
		var7.method3005(var5, var6);
		if (var8 == 1) {
			var7.method3008();
		} else if (var8 == 2) {
			var7.method3009();
		} else if (var8 == 3) {
			var7.method3010();
		}
		return var7;
	}

	@ObfuscatedName("eo.w(Lfo;II)Lfo;")
	public SoftwareModel method2439(SoftwareModel arg0, int arg1) {
		int var3 = this.field2364[arg1];
		AnimFrameset var4 = method760(var3 >> 16);
		int var5 = var3 & 0xFFFF;
		if (var4 == null) {
			return arg0.method3040(true);
		} else {
			SoftwareModel var6 = arg0.method3040(!var4.method2652(var5));
			var6.method3005(var4, var5);
			return var6;
		}
	}

	@ObfuscatedName("eo.e(Lfo;ILeo;II)Lfo;")
	public SoftwareModel method2421(SoftwareModel arg0, int arg1, SeqType arg2, int arg3) {
		int var5 = this.field2364[arg1];
		AnimFrameset var6 = method760(var5 >> 16);
		int var7 = var5 & 0xFFFF;
		if (var6 == null) {
			return arg2.method2436(arg0, arg3);
		}
		int var8 = arg2.field2364[arg3];
		AnimFrameset var9 = method760(var8 >> 16);
		int var10 = var8 & 0xFFFF;
		if (var9 == null) {
			SoftwareModel var11 = arg0.method2999(!var6.method2652(var7));
			var11.method3005(var6, var7);
			return var11;
		} else {
			SoftwareModel var12 = arg0.method2999(!var6.method2652(var7) & !var9.method2652(var10));
			var12.method3006(var6, var7, var9, var10, this.field2369);
			return var12;
		}
	}

	@ObfuscatedName("eo.b(Lfo;IB)Lfo;")
	public SoftwareModel method2430(SoftwareModel arg0, int arg1) {
		int var3 = this.field2364[arg1];
		AnimFrameset var4 = method760(var3 >> 16);
		int var5 = var3 & 0xFFFF;
		if (var4 == null) {
			return arg0.method2999(true);
		}
		AnimFrameset var6 = null;
		int var7 = 0;
		if (this.field2365 != null && arg1 < this.field2365.length) {
			int var8 = this.field2365[arg1];
			var6 = method760(var8 >> 16);
			var7 = var8 & 0xFFFF;
		}
		if (var6 == null || var7 == 65535) {
			SoftwareModel var10 = arg0.method2999(!var4.method2652(var5));
			var10.method3005(var4, var5);
			return var10;
		} else {
			SoftwareModel var9 = arg0.method2999(!var4.method2652(var5) & !var6.method2652(var7));
			var9.method3005(var4, var5);
			var9.method3005(var6, var7);
			return var9;
		}
	}

	@ObfuscatedName("bi.y(IB)Lfr;")
	public static AnimFrameset method760(int arg0) {
		AnimFrameset var1 = (AnimFrameset) field2370.method1244((long) arg0);
		if (var1 != null) {
			return var1;
		}
		Js5Index var2 = Statics.field556;
		Js5Index var3 = Statics.field2361;
		boolean var4 = true;
		int[] var5 = var2.method1053(arg0);
		for (int var6 = 0; var6 < var5.length; var6++) {
			byte[] var7 = var2.method1050(arg0, var5[var6]);
			if (var7 == null) {
				var4 = false;
			} else {
				int var8 = (var7[0] & 0xFF) << 8 | var7[1] & 0xFF;
				byte[] var9 = var3.method1050(var8, 0);
				if (var9 == null) {
					var4 = false;
				}
			}
		}
		AnimFrameset var10;
		if (var4) {
			try {
				var10 = new AnimFrameset(var2, var3, arg0, false);
			} catch (Exception var13) {
				var10 = null;
			}
		} else {
			var10 = null;
		}
		if (var10 != null) {
			field2370.method1246(var10, (long) arg0);
		}
		return var10;
	}

	@ObfuscatedName("cu.t(I)V")
	public static void method1123() {
		field2362.method1253();
		field2370.method1253();
	}
}
