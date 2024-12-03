package jagex2.config;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.graphics.*;
import jagex2.io.Packet;
import jagex2.jstring.EnglishLocale;

@ObfuscatedName("fj")
public class ObjType extends DoublyLinkable {

	@ObfuscatedName("fj.g")
	public static LruCache field2432 = new LruCache(64);

	@ObfuscatedName("fj.q")
	public static LruCache field2433 = new LruCache(50);

	@ObfuscatedName("fj.i")
	public static LruCache field2434 = new LruCache(100);

	@ObfuscatedName("fj.u")
	public int field2435;

	@ObfuscatedName("fj.v")
	public int field2436;

	@ObfuscatedName("fj.w")
	public String field2461 = "null";

	@ObfuscatedName("fj.e")
	public short[] field2438;

	@ObfuscatedName("fj.b")
	public short[] field2439;

	@ObfuscatedName("fj.y")
	public short[] field2440;

	@ObfuscatedName("fj.t")
	public short[] field2441;

	@ObfuscatedName("fj.f")
	public int field2442 = 2000;

	@ObfuscatedName("fj.k")
	public int field2443 = 0;

	@ObfuscatedName("fj.o")
	public int field2444 = 0;

	@ObfuscatedName("fj.a")
	public int field2463 = 0;

	@ObfuscatedName("fj.h")
	public int field2471 = 0;

	@ObfuscatedName("fj.x")
	public int field2447 = 0;

	@ObfuscatedName("fj.p")
	public int field2448 = 0;

	@ObfuscatedName("fj.ad")
	public int field2470 = 1;

	@ObfuscatedName("fj.ac")
	public boolean field2457 = false;

	@ObfuscatedName("fj.aa")
	public String[] field2451 = new String[] { null, null, EnglishLocale.field867, null, null };

	@ObfuscatedName("fj.as")
	public String[] field2452 = new String[] { null, null, null, null, EnglishLocale.field868 };

	@ObfuscatedName("fj.am")
	public int field2453 = -1;

	@ObfuscatedName("fj.ap")
	public int field2454 = -1;

	@ObfuscatedName("fj.av")
	public int field2455 = 0;

	@ObfuscatedName("fj.ak")
	public int field2474 = -1;

	@ObfuscatedName("fj.az")
	public int field2460 = -1;

	@ObfuscatedName("fj.an")
	public int field2458 = 0;

	@ObfuscatedName("fj.ah")
	public int field2462 = -1;

	@ObfuscatedName("fj.ay")
	public int field2465 = -1;

	@ObfuscatedName("fj.al")
	public int field2431 = -1;

	@ObfuscatedName("fj.ab")
	public int field2468 = -1;

	@ObfuscatedName("fj.ao")
	public int field2446 = -1;

	@ObfuscatedName("fj.ag")
	public int field2464 = -1;

	@ObfuscatedName("fj.ar")
	public int[] field2467;

	@ObfuscatedName("fj.aq")
	public int[] field2466;

	@ObfuscatedName("fj.at")
	public int field2459 = -1;

	@ObfuscatedName("fj.ae")
	public int field2450 = -1;

	@ObfuscatedName("fj.au")
	public int field2469 = 128;

	@ObfuscatedName("fj.ax")
	public int field2445 = 128;

	@ObfuscatedName("fj.ai")
	public int field2456 = 128;

	@ObfuscatedName("fj.aj")
	public int field2472 = 0;

	@ObfuscatedName("fj.aw")
	public int field2473 = 0;

	@ObfuscatedName("fj.af")
	public int field2437 = 0;

	@ObfuscatedName("bb.z(II)Lfj;")
	public static ObjType method927(int arg0) {
		ObjType var1 = (ObjType) field2432.method1244((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = Statics.field2449.method1044(10, arg0);
		ObjType var3 = new ObjType();
		var3.field2435 = arg0;
		if (var2 != null) {
			var3.method2516(new Packet(var2));
		}
		var3.method2517();
		if (var3.field2450 != -1) {
			var3.method2520(method927(var3.field2450), method927(var3.field2459));
		}
		if (!Statics.field1462 && var3.field2457) {
			var3.field2461 = EnglishLocale.field1077;
			var3.field2451 = null;
			var3.field2452 = null;
			var3.field2437 = 0;
		}
		field2432.method1246(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("fj.g(B)V")
	public void method2517() {
	}

	@ObfuscatedName("fj.q(Lev;B)V")
	public void method2516(Packet arg0) {
		while (true) {
			int var2 = arg0.method1600();
			if (var2 == 0) {
				return;
			}
			this.method2519(arg0, var2);
		}
	}

	@ObfuscatedName("fj.i(Lev;II)V")
	public void method2519(Packet arg0, int arg1) {
		if (arg1 == 1) {
			this.field2436 = arg0.method1602();
		} else if (arg1 == 2) {
			this.field2461 = arg0.method1693();
		} else if (arg1 == 4) {
			this.field2442 = arg0.method1602();
		} else if (arg1 == 5) {
			this.field2443 = arg0.method1602();
		} else if (arg1 == 6) {
			this.field2444 = arg0.method1602();
		} else if (arg1 == 7) {
			this.field2471 = arg0.method1602();
			if (this.field2471 > 32767) {
				this.field2471 -= 65536;
			}
		} else if (arg1 == 8) {
			this.field2447 = arg0.method1602();
			if (this.field2447 > 32767) {
				this.field2447 -= 65536;
			}
		} else if (arg1 == 11) {
			this.field2448 = 1;
		} else if (arg1 == 12) {
			this.field2470 = arg0.method1605();
		} else if (arg1 == 16) {
			this.field2457 = true;
		} else if (arg1 == 23) {
			this.field2453 = arg0.method1602();
			this.field2455 = arg0.method1600();
		} else if (arg1 == 24) {
			this.field2454 = arg0.method1602();
		} else if (arg1 == 25) {
			this.field2474 = arg0.method1602();
			this.field2458 = arg0.method1600();
		} else if (arg1 == 26) {
			this.field2460 = arg0.method1602();
		} else if (arg1 >= 30 && arg1 < 35) {
			this.field2451[arg1 - 30] = arg0.method1693();
			if (this.field2451[arg1 - 30].equalsIgnoreCase(EnglishLocale.field869)) {
				this.field2451[arg1 - 30] = null;
			}
		} else if (arg1 >= 35 && arg1 < 40) {
			this.field2452[arg1 - 35] = arg0.method1693();
		} else if (arg1 == 40) {
			int var3 = arg0.method1600();
			this.field2438 = new short[var3];
			this.field2439 = new short[var3];
			for (int var4 = 0; var4 < var3; var4++) {
				this.field2438[var4] = (short) arg0.method1602();
				this.field2439[var4] = (short) arg0.method1602();
			}
		} else if (arg1 == 41) {
			int var5 = arg0.method1600();
			this.field2440 = new short[var5];
			this.field2441 = new short[var5];
			for (int var6 = 0; var6 < var5; var6++) {
				this.field2440[var6] = (short) arg0.method1602();
				this.field2441[var6] = (short) arg0.method1602();
			}
		} else if (arg1 == 78) {
			this.field2462 = arg0.method1602();
		} else if (arg1 == 79) {
			this.field2465 = arg0.method1602();
		} else if (arg1 == 90) {
			this.field2431 = arg0.method1602();
		} else if (arg1 == 91) {
			this.field2446 = arg0.method1602();
		} else if (arg1 == 92) {
			this.field2468 = arg0.method1602();
		} else if (arg1 == 93) {
			this.field2464 = arg0.method1602();
		} else if (arg1 == 95) {
			this.field2463 = arg0.method1602();
		} else if (arg1 == 97) {
			this.field2459 = arg0.method1602();
		} else if (arg1 == 98) {
			this.field2450 = arg0.method1602();
		} else if (arg1 >= 100 && arg1 < 110) {
			if (this.field2467 == null) {
				this.field2467 = new int[10];
				this.field2466 = new int[10];
			}
			this.field2467[arg1 - 100] = arg0.method1602();
			this.field2466[arg1 - 100] = arg0.method1602();
		} else if (arg1 == 110) {
			this.field2469 = arg0.method1602();
		} else if (arg1 == 111) {
			this.field2445 = arg0.method1602();
		} else if (arg1 == 112) {
			this.field2456 = arg0.method1602();
		} else if (arg1 == 113) {
			this.field2472 = arg0.method1595();
		} else if (arg1 == 114) {
			this.field2473 = arg0.method1595() * 5;
		} else if (arg1 == 115) {
			this.field2437 = arg0.method1600();
		}
	}

	@ObfuscatedName("fj.s(Lfj;Lfj;I)V")
	public void method2520(ObjType arg0, ObjType arg1) {
		this.field2436 = arg0.field2436;
		this.field2442 = arg0.field2442;
		this.field2443 = arg0.field2443;
		this.field2444 = arg0.field2444;
		this.field2463 = arg0.field2463;
		this.field2471 = arg0.field2471;
		this.field2447 = arg0.field2447;
		this.field2438 = arg0.field2438;
		this.field2439 = arg0.field2439;
		this.field2440 = arg0.field2440;
		this.field2441 = arg0.field2441;
		this.field2461 = arg1.field2461;
		this.field2457 = arg1.field2457;
		this.field2470 = arg1.field2470;
		this.field2448 = 1;
	}

	@ObfuscatedName("fj.u(II)Lfw;")
	public final Model method2521(int arg0) {
		if (this.field2467 != null && arg0 > 1) {
			int var2 = -1;
			for (int var3 = 0; var3 < 10; var3++) {
				if (arg0 >= this.field2466[var3] && this.field2466[var3] != 0) {
					var2 = this.field2467[var3];
				}
			}
			if (var2 != -1) {
				return method927(var2).method2521(1);
			}
		}
		Model var4 = Model.method2992(Statics.field1111, this.field2436, 0);
		if (var4 == null) {
			return null;
		}
		if (this.field2469 != 128 || this.field2445 != 128 || this.field2456 != 128) {
			var4.method2937(this.field2469, this.field2445, this.field2456);
		}
		if (this.field2438 != null) {
			for (int var5 = 0; var5 < this.field2438.length; var5++) {
				var4.method2935(this.field2438[var5], this.field2439[var5]);
			}
		}
		if (this.field2440 != null) {
			for (int var6 = 0; var6 < this.field2440.length; var6++) {
				var4.method2976(this.field2440[var6], this.field2441[var6]);
			}
		}
		return var4;
	}

	@ObfuscatedName("fj.v(IB)Lfo;")
	public final SoftwareModel method2532(int arg0) {
		if (this.field2467 != null && arg0 > 1) {
			int var2 = -1;
			for (int var3 = 0; var3 < 10; var3++) {
				if (arg0 >= this.field2466[var3] && this.field2466[var3] != 0) {
					var2 = this.field2467[var3];
				}
			}
			if (var2 != -1) {
				return method927(var2).method2532(1);
			}
		}
		SoftwareModel var4 = (SoftwareModel) field2433.method1244((long) this.field2435);
		if (var4 != null) {
			return var4;
		}
		Model var5 = Model.method2992(Statics.field1111, this.field2436, 0);
		if (var5 == null) {
			return null;
		}
		if (this.field2469 != 128 || this.field2445 != 128 || this.field2456 != 128) {
			var5.method2937(this.field2469, this.field2445, this.field2456);
		}
		if (this.field2438 != null) {
			for (int var6 = 0; var6 < this.field2438.length; var6++) {
				var5.method2935(this.field2438[var6], this.field2439[var6]);
			}
		}
		if (this.field2440 != null) {
			for (int var7 = 0; var7 < this.field2440.length; var7++) {
				var5.method2976(this.field2440[var7], this.field2441[var7]);
			}
		}
		SoftwareModel var8 = var5.method2942(this.field2472 + 64, this.field2473 + 768, -50, -10, -50);
		var8.field2744 = true;
		field2433.method1246(var8, (long) this.field2435);
		return var8;
	}

	@ObfuscatedName("fj.w(II)Lfj;")
	public ObjType method2523(int arg0) {
		if (this.field2467 != null && arg0 > 1) {
			int var2 = -1;
			for (int var3 = 0; var3 < 10; var3++) {
				if (arg0 >= this.field2466[var3] && this.field2466[var3] != 0) {
					var2 = this.field2467[var3];
				}
			}
			if (var2 != -1) {
				return method927(var2);
			}
		}
		return this;
	}

	@ObfuscatedName("eg.e(IIIIZI)Lfq;")
	public static final Pix32 method1837(int arg0, int arg1, int arg2, int arg3, boolean arg4) {
		long var5 = ((long) arg3 << 40) + ((long) arg2 << 38) + ((long) arg1 << 16) + (long) arg0;
		if (!arg4) {
			Pix32 var7 = (Pix32) field2434.method1244(var5);
			if (var7 != null) {
				return var7;
			}
		}
		ObjType var8 = method927(arg0);
		if (arg1 > 1 && var8.field2467 != null) {
			int var9 = -1;
			for (int var10 = 0; var10 < 10; var10++) {
				if (arg1 >= var8.field2466[var10] && var8.field2466[var10] != 0) {
					var9 = var8.field2467[var10];
				}
			}
			if (var9 != -1) {
				var8 = method927(var9);
			}
		}
		SoftwareModel var11 = var8.method2532(1);
		if (var11 == null) {
			return null;
		}
		Pix32 var12 = null;
		if (var8.field2450 != -1) {
			var12 = method1837(var8.field2459, 10, 1, 0, true);
			if (var12 == null) {
				return null;
			}
		}
		int[] var13 = Statics.field2486;
		int var14 = Statics.field2481;
		int var15 = Statics.field2480;
		int[] var16 = new int[4];
		Pix2D.method2587(var16);
		Pix32 var17 = new Pix32(36, 32);
		Pix2D.method2583(var17.field2506, 36, 32);
		Pix2D.method2589();
		Pix3D.method2808();
		Pix3D.method2784(16, 16);
		Pix3D.field2522 = false;
		int var18 = var8.field2442;
		if (arg4) {
			var18 = (int) ((double) var18 * 1.5D);
		} else if (arg2 == 2) {
			var18 = (int) ((double) var18 * 1.04D);
		}
		int var19 = Pix3D.field2533[var8.field2443] * var18 >> 16;
		int var20 = Pix3D.field2530[var8.field2443] * var18 >> 16;
		var11.method3002();
		var11.method3014(0, var8.field2444, var8.field2463, var8.field2443, var8.field2471, var8.field2447 + var11.field2487 / 2 + var19, var8.field2447 + var20);
		if (arg2 >= 1) {
			var17.method2714(1);
		}
		if (arg2 >= 2) {
			var17.method2714(16777215);
		}
		if (arg3 != 0) {
			var17.method2669(arg3);
		}
		Pix2D.method2583(var17.field2506, 36, 32);
		if (var8.field2450 != -1) {
			var12.method2671(0, 0);
		}
		if (!arg4 && (var8.field2448 == 1 || arg1 != 1) && arg1 != -1) {
			Statics.field815.method2821(method926(arg1), 0, 9, 16776960, 1);
		}
		if (!arg4) {
			field2434.method1246(var17, var5);
		}
		Pix2D.method2583(var13, var14, var15);
		Pix2D.method2612(var16);
		Pix3D.method2808();
		Pix3D.field2522 = true;
		return var17;
	}

	@ObfuscatedName("bb.b(II)Ljava/lang/String;")
	public static final String method926(int arg0) {
		if (arg0 < 100000) {
			return "<col=ffff00>" + arg0 + "</col>";
		} else if (arg0 < 10000000) {
			return "<col=ffffff>" + arg0 / 1000 + EnglishLocale.field1019 + "</col>";
		} else {
			return "<col=00ff80>" + arg0 / 1000000 + EnglishLocale.field942 + "</col>";
		}
	}

	@ObfuscatedName("fj.y(ZI)Z")
	public final boolean method2547(boolean arg0) {
		int var2 = this.field2453;
		int var3 = this.field2454;
		int var4 = this.field2462;
		if (arg0) {
			var2 = this.field2474;
			var3 = this.field2460;
			var4 = this.field2465;
		}
		if (var2 == -1) {
			return true;
		}
		boolean var5 = true;
		if (!Statics.field1111.method1046(var2, 0)) {
			var5 = false;
		}
		if (var3 != -1 && !Statics.field1111.method1046(var3, 0)) {
			var5 = false;
		}
		if (var4 != -1 && !Statics.field1111.method1046(var4, 0)) {
			var5 = false;
		}
		return var5;
	}

	@ObfuscatedName("fj.t(ZI)Lfw;")
	public final Model method2525(boolean arg0) {
		int var2 = this.field2453;
		int var3 = this.field2454;
		int var4 = this.field2462;
		if (arg0) {
			var2 = this.field2474;
			var3 = this.field2460;
			var4 = this.field2465;
		}
		if (var2 == -1) {
			return null;
		}
		Model var5 = Model.method2992(Statics.field1111, var2, 0);
		if (var3 != -1) {
			Model var6 = Model.method2992(Statics.field1111, var3, 0);
			if (var4 == -1) {
				Model[] var9 = new Model[] { var5, var6 };
				var5 = new Model(var9, 2);
			} else {
				Model var7 = Model.method2992(Statics.field1111, var4, 0);
				Model[] var8 = new Model[] { var5, var6, var7 };
				var5 = new Model(var8, 3);
			}
		}
		if (!arg0 && this.field2455 != 0) {
			var5.method2934(0, this.field2455, 0);
		}
		if (arg0 && this.field2458 != 0) {
			var5.method2934(0, this.field2458, 0);
		}
		if (this.field2438 != null) {
			for (int var10 = 0; var10 < this.field2438.length; var10++) {
				var5.method2935(this.field2438[var10], this.field2439[var10]);
			}
		}
		if (this.field2440 != null) {
			for (int var11 = 0; var11 < this.field2440.length; var11++) {
				var5.method2976(this.field2440[var11], this.field2441[var11]);
			}
		}
		return var5;
	}

	@ObfuscatedName("fj.f(ZB)Z")
	public final boolean method2554(boolean arg0) {
		int var2 = this.field2431;
		int var3 = this.field2468;
		if (arg0) {
			var2 = this.field2446;
			var3 = this.field2464;
		}
		if (var2 == -1) {
			return true;
		}
		boolean var4 = true;
		if (!Statics.field1111.method1046(var2, 0)) {
			var4 = false;
		}
		if (var3 != -1 && !Statics.field1111.method1046(var3, 0)) {
			var4 = false;
		}
		return var4;
	}

	@ObfuscatedName("fj.k(ZI)Lfw;")
	public final Model method2527(boolean arg0) {
		int var2 = this.field2431;
		int var3 = this.field2468;
		if (arg0) {
			var2 = this.field2446;
			var3 = this.field2464;
		}
		if (var2 == -1) {
			return null;
		}
		Model var4 = Model.method2992(Statics.field1111, var2, 0);
		if (var3 != -1) {
			Model var5 = Model.method2992(Statics.field1111, var3, 0);
			Model[] var6 = new Model[] { var4, var5 };
			var4 = new Model(var6, 2);
		}
		if (this.field2438 != null) {
			for (int var7 = 0; var7 < this.field2438.length; var7++) {
				var4.method2935(this.field2438[var7], this.field2439[var7]);
			}
		}
		if (this.field2440 != null) {
			for (int var8 = 0; var8 < this.field2440.length; var8++) {
				var4.method2976(this.field2440[var8], this.field2441[var8]);
			}
		}
		return var4;
	}

	@ObfuscatedName("da.o(S)V")
	public static void method1352() {
		field2434.method1253();
	}
}
