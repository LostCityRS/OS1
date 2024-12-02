package jagex2.config;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.client.VarProvider;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.graphics.Model;
import jagex2.graphics.SoftwareModel;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;
import jagex2.jstring.EnglishLocale;

@ObfuscatedName("em")
public class NpcType extends DoublyLinkable {

	@ObfuscatedName("em.z")
	public static LruCache field2274 = new LruCache(64);

	@ObfuscatedName("em.g")
	public static LruCache field2288 = new LruCache(50);

	@ObfuscatedName("em.q")
	public int field2271;

	@ObfuscatedName("em.i")
	public String field2272 = "null";

	@ObfuscatedName("em.s")
	public int field2283 = 1;

	@ObfuscatedName("em.u")
	public int[] field2292;

	@ObfuscatedName("em.v")
	public int[] field2275;

	@ObfuscatedName("em.w")
	public int field2276 = -1;

	@ObfuscatedName("em.e")
	public int field2287 = -1;

	@ObfuscatedName("em.b")
	public int field2278 = -1;

	@ObfuscatedName("em.y")
	public int field2279 = -1;

	@ObfuscatedName("em.t")
	public int field2280 = -1;

	@ObfuscatedName("em.f")
	public int field2294 = -1;

	@ObfuscatedName("em.k")
	public int field2282 = -1;

	@ObfuscatedName("em.o")
	public short[] field2277;

	@ObfuscatedName("em.a")
	public short[] field2284;

	@ObfuscatedName("em.h")
	public short[] field2285;

	@ObfuscatedName("em.x")
	public short[] field2286;

	@ObfuscatedName("em.p")
	public String[] field2268 = new String[5];

	@ObfuscatedName("em.ad")
	public boolean field2298 = true;

	@ObfuscatedName("em.ac")
	public int field2289 = -1;

	@ObfuscatedName("em.aa")
	public int field2270 = 128;

	@ObfuscatedName("em.as")
	public int field2291 = 128;

	@ObfuscatedName("em.am")
	public boolean field2290 = false;

	@ObfuscatedName("em.ap")
	public int field2293 = 0;

	@ObfuscatedName("em.av")
	public int field2269 = 0;

	@ObfuscatedName("em.ak")
	public int field2295 = -1;

	@ObfuscatedName("em.az")
	public int field2296 = 32;

	@ObfuscatedName("em.an")
	public int[] field2273;

	@ObfuscatedName("em.ah")
	public int field2297 = -1;

	@ObfuscatedName("em.ay")
	public int field2299 = -1;

	@ObfuscatedName("em.al")
	public boolean field2300 = true;

	@ObfuscatedName("em.ab")
	public boolean field2301 = true;

	@ObfuscatedName("by.z(Lch;Lch;B)V")
	public static void method828(Js5Index arg0, Js5Index arg1) {
		Statics.field2281 = arg0;
		Statics.field1600 = arg1;
	}

	@ObfuscatedName("f.g(IB)Lem;")
	public static NpcType method275(int arg0) {
		NpcType var1 = (NpcType) field2274.method1244((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = Statics.field2281.method1044(9, arg0);
		NpcType var3 = new NpcType();
		var3.field2271 = arg0;
		if (var2 != null) {
			var3.method2328(new Packet(var2));
		}
		var3.method2327();
		field2274.method1246(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("em.q(I)V")
	public void method2327() {
	}

	@ObfuscatedName("em.i(Lev;I)V")
	public void method2328(Packet arg0) {
		while (true) {
			int var2 = arg0.method1600();
			if (var2 == 0) {
				return;
			}
			this.method2334(arg0, var2);
		}
	}

	@ObfuscatedName("em.s(Lev;II)V")
	public void method2334(Packet arg0, int arg1) {
		if (arg1 == 1) {
			int var3 = arg0.method1600();
			this.field2292 = new int[var3];
			for (int var4 = 0; var4 < var3; var4++) {
				this.field2292[var4] = arg0.method1602();
			}
		} else if (arg1 == 2) {
			this.field2272 = arg0.method1693();
		} else if (arg1 == 12) {
			this.field2283 = arg0.method1600();
		} else if (arg1 == 13) {
			this.field2276 = arg0.method1602();
		} else if (arg1 == 14) {
			this.field2279 = arg0.method1602();
		} else if (arg1 == 15) {
			this.field2287 = arg0.method1602();
		} else if (arg1 == 16) {
			this.field2278 = arg0.method1602();
		} else if (arg1 == 17) {
			this.field2279 = arg0.method1602();
			this.field2280 = arg0.method1602();
			this.field2294 = arg0.method1602();
			this.field2282 = arg0.method1602();
		} else if (arg1 >= 30 && arg1 < 35) {
			this.field2268[arg1 - 30] = arg0.method1693();
			if (this.field2268[arg1 - 30].equalsIgnoreCase(EnglishLocale.field869)) {
				this.field2268[arg1 - 30] = null;
			}
		} else if (arg1 == 40) {
			int var5 = arg0.method1600();
			this.field2277 = new short[var5];
			this.field2284 = new short[var5];
			for (int var6 = 0; var6 < var5; var6++) {
				this.field2277[var6] = (short) arg0.method1602();
				this.field2284[var6] = (short) arg0.method1602();
			}
		} else if (arg1 == 41) {
			int var7 = arg0.method1600();
			this.field2285 = new short[var7];
			this.field2286 = new short[var7];
			for (int var8 = 0; var8 < var7; var8++) {
				this.field2285[var8] = (short) arg0.method1602();
				this.field2286[var8] = (short) arg0.method1602();
			}
		} else if (arg1 == 60) {
			int var9 = arg0.method1600();
			this.field2275 = new int[var9];
			for (int var10 = 0; var10 < var9; var10++) {
				this.field2275[var10] = arg0.method1602();
			}
		} else if (arg1 == 93) {
			this.field2298 = false;
		} else if (arg1 == 95) {
			this.field2289 = arg0.method1602();
		} else if (arg1 == 97) {
			this.field2270 = arg0.method1602();
		} else if (arg1 == 98) {
			this.field2291 = arg0.method1602();
		} else if (arg1 == 99) {
			this.field2290 = true;
		} else if (arg1 == 100) {
			this.field2293 = arg0.method1595();
		} else if (arg1 == 101) {
			this.field2269 = arg0.method1595();
		} else if (arg1 == 102) {
			this.field2295 = arg0.method1602();
		} else if (arg1 == 103) {
			this.field2296 = arg0.method1602();
		} else if (arg1 == 106) {
			this.field2297 = arg0.method1602();
			if (this.field2297 == 65535) {
				this.field2297 = -1;
			}
			this.field2299 = arg0.method1602();
			if (this.field2299 == 65535) {
				this.field2299 = -1;
			}
			int var11 = arg0.method1600();
			this.field2273 = new int[var11 + 1];
			for (int var12 = 0; var12 <= var11; var12++) {
				this.field2273[var12] = arg0.method1602();
				if (this.field2273[var12] == 65535) {
					this.field2273[var12] = -1;
				}
			}
		} else if (arg1 == 107) {
			this.field2300 = false;
		} else if (arg1 == 109) {
			this.field2301 = false;
		}
	}

	@ObfuscatedName("em.u(Leo;ILeo;IB)Lfo;")
	public final SoftwareModel method2330(SeqType arg0, int arg1, SeqType arg2, int arg3) {
		if (this.field2273 != null) {
			NpcType var5 = this.method2332();
			return var5 == null ? null : var5.method2330(arg0, arg1, arg2, arg3);
		}
		SoftwareModel var6 = (SoftwareModel) field2288.method1244((long) this.field2271);
		if (var6 == null) {
			boolean var7 = false;
			for (int var8 = 0; var8 < this.field2292.length; var8++) {
				if (!Statics.field1600.method1046(this.field2292[var8], 0)) {
					var7 = true;
				}
			}
			if (var7) {
				return null;
			}
			Model[] var9 = new Model[this.field2292.length];
			for (int var10 = 0; var10 < this.field2292.length; var10++) {
				var9[var10] = Model.method2992(Statics.field1600, this.field2292[var10], 0);
			}
			Model var11;
			if (var9.length == 1) {
				var11 = var9[0];
			} else {
				var11 = new Model(var9, var9.length);
			}
			if (this.field2277 != null) {
				for (int var12 = 0; var12 < this.field2277.length; var12++) {
					var11.method2935(this.field2277[var12], this.field2284[var12]);
				}
			}
			if (this.field2285 != null) {
				for (int var13 = 0; var13 < this.field2285.length; var13++) {
					var11.method2976(this.field2285[var13], this.field2286[var13]);
				}
			}
			var6 = var11.method2942(this.field2293 + 64, this.field2269 * 5 + 850, -30, -50, -30);
			field2288.method1246(var6, (long) this.field2271);
		}
		SoftwareModel var14;
		if (arg0 != null && arg2 != null) {
			var14 = arg0.method2421(var6, arg1, arg2, arg3);
		} else if (arg0 != null) {
			var14 = arg0.method2436(var6, arg1);
		} else if (arg2 == null) {
			var14 = var6.method2999(true);
		} else {
			var14 = arg2.method2436(var6, arg3);
		}
		if (this.field2270 != 128 || this.field2291 != 128) {
			var14.method3013(this.field2270, this.field2291, this.field2270);
		}
		return var14;
	}

	@ObfuscatedName("em.v(I)Lfw;")
	public final Model method2331() {
		if (this.field2273 != null) {
			NpcType var1 = this.method2332();
			return var1 == null ? null : var1.method2331();
		} else if (this.field2275 == null) {
			return null;
		} else {
			boolean var2 = false;
			for (int var3 = 0; var3 < this.field2275.length; var3++) {
				if (!Statics.field1600.method1046(this.field2275[var3], 0)) {
					var2 = true;
				}
			}
			if (var2) {
				return null;
			}
			Model[] var4 = new Model[this.field2275.length];
			for (int var5 = 0; var5 < this.field2275.length; var5++) {
				var4[var5] = Model.method2992(Statics.field1600, this.field2275[var5], 0);
			}
			Model var6;
			if (var4.length == 1) {
				var6 = var4[0];
			} else {
				var6 = new Model(var4, var4.length);
			}
			if (this.field2277 != null) {
				for (int var7 = 0; var7 < this.field2277.length; var7++) {
					var6.method2935(this.field2277[var7], this.field2284[var7]);
				}
			}
			if (this.field2285 != null) {
				for (int var8 = 0; var8 < this.field2285.length; var8++) {
					var6.method2976(this.field2285[var8], this.field2286[var8]);
				}
			}
			return var6;
		}
	}

	@ObfuscatedName("em.w(B)Lem;")
	public final NpcType method2332() {
		int var1 = -1;
		if (this.field2297 != -1) {
			var1 = Statics.method1130(this.field2297);
		} else if (this.field2299 != -1) {
			var1 = VarProvider.field1210[this.field2299];
		}
		return var1 < 0 || var1 >= this.field2273.length || this.field2273[var1] == -1 ? null : method275(this.field2273[var1]);
	}

	@ObfuscatedName("em.e(I)Z")
	public boolean method2339() {
		if (this.field2273 == null) {
			return true;
		}
		int var1 = -1;
		if (this.field2297 != -1) {
			var1 = Statics.method1130(this.field2297);
		} else if (this.field2299 != -1) {
			var1 = VarProvider.field1210[this.field2299];
		}
		return var1 >= 0 && var1 < this.field2273.length && this.field2273[var1] != -1;
	}

	@ObfuscatedName("df.b(I)V")
	public static void method1334() {
		field2274.method1253();
		field2288.method1253();
	}
}
