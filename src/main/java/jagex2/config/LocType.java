package jagex2.config;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.client.VarProvider;
import jagex2.dash3d.Entity;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.graphics.Model;
import jagex2.graphics.SoftwareModel;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;
import jagex2.jstring.EnglishLocale;

@ObfuscatedName("ey")
public class LocType extends DoublyLinkable {

	@ObfuscatedName("ey.n")
	public static boolean field2340 = false;

	@ObfuscatedName("ey.g")
	public static LruCache field2345 = new LruCache(64);

	@ObfuscatedName("ey.q")
	public static LruCache field2305 = new LruCache(500);

	@ObfuscatedName("ey.i")
	public static LruCache field2306 = new LruCache(30);

	@ObfuscatedName("ey.s")
	public static LruCache field2307 = new LruCache(30);

	@ObfuscatedName("ey.u")
	public static Model[] field2308 = new Model[4];

	@ObfuscatedName("ey.v")
	public int field2309;

	@ObfuscatedName("ey.w")
	public int[] field2329;

	@ObfuscatedName("ey.e")
	public int[] field2338;

	@ObfuscatedName("ey.b")
	public String field2310 = "null";

	@ObfuscatedName("ey.y")
	public short[] field2313;

	@ObfuscatedName("ey.t")
	public short[] field2311;

	@ObfuscatedName("ey.f")
	public short[] field2315;

	@ObfuscatedName("ey.k")
	public short[] field2316;

	@ObfuscatedName("ey.o")
	public int field2344 = 1;

	@ObfuscatedName("ey.a")
	public int field2318 = 1;

	@ObfuscatedName("ey.h")
	public int field2342 = 2;

	@ObfuscatedName("ey.x")
	public boolean field2319 = true;

	@ObfuscatedName("ey.p")
	public int field2321 = -1;

	@ObfuscatedName("ey.ad")
	public int field2322 = -1;

	@ObfuscatedName("ey.ac")
	public boolean field2323 = false;

	@ObfuscatedName("ey.aa")
	public boolean field2324 = false;

	@ObfuscatedName("ey.as")
	public int field2325 = -1;

	@ObfuscatedName("ey.am")
	public int field2327 = 16;

	@ObfuscatedName("ey.ap")
	public int field2343 = 0;

	@ObfuscatedName("ey.av")
	public int field2326 = 0;

	@ObfuscatedName("ey.ak")
	public String[] field2328 = new String[5];

	@ObfuscatedName("ey.az")
	public int field2330 = -1;

	@ObfuscatedName("ey.an")
	public int field2320 = -1;

	@ObfuscatedName("ey.ah")
	public boolean field2332 = false;

	@ObfuscatedName("ey.ay")
	public boolean field2333 = true;

	@ObfuscatedName("ey.al")
	public int field2334 = 128;

	@ObfuscatedName("ey.ab")
	public int field2335 = 128;

	@ObfuscatedName("ey.ao")
	public int field2336 = 128;

	@ObfuscatedName("ey.ag")
	public int field2304 = 0;

	@ObfuscatedName("ey.ar")
	public int field2350 = 0;

	@ObfuscatedName("ey.aq")
	public int field2339 = 0;

	@ObfuscatedName("ey.at")
	public int field2314 = 0;

	@ObfuscatedName("ey.ae")
	public boolean field2341 = false;

	@ObfuscatedName("ey.au")
	public boolean field2347 = false;

	@ObfuscatedName("ey.ax")
	public int field2337 = -1;

	@ObfuscatedName("ey.ai")
	public int[] field2317;

	@ObfuscatedName("ey.aj")
	public int field2331 = -1;

	@ObfuscatedName("ey.aw")
	public int field2346 = -1;

	@ObfuscatedName("ey.af")
	public int field2312 = -1;

	@ObfuscatedName("ey.bh")
	public int field2348 = 0;

	@ObfuscatedName("ey.bi")
	public int field2349 = 0;

	@ObfuscatedName("ey.bs")
	public int field2302 = 0;

	@ObfuscatedName("ey.bk")
	public int[] field2351;

	@ObfuscatedName("av.z(Lch;Lch;ZI)V")
	public static void method431(Js5Index arg0, Js5Index arg1, boolean arg2) {
		Statics.field120 = arg0;
		Statics.field2303 = arg1;
		field2340 = arg2;
	}

	@ObfuscatedName("fj.g(IB)Ley;")
	public static LocType method2564(int arg0) {
		LocType var1 = (LocType) field2345.method1244((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = Statics.field120.method1044(6, arg0);
		LocType var3 = new LocType();
		var3.field2309 = arg0;
		if (var2 != null) {
			var3.method2360(new Packet(var2));
		}
		var3.method2361();
		if (var3.field2347) {
			var3.field2342 = 0;
			var3.field2319 = false;
		}
		field2345.method1246(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("ey.q(B)V")
	public void method2361() {
		if (this.field2321 == -1) {
			this.field2321 = 0;
			if (this.field2329 != null && (this.field2338 == null || this.field2338[0] == 10)) {
				this.field2321 = 1;
			}
			for (int var1 = 0; var1 < 5; var1++) {
				if (this.field2328[var1] != null) {
					this.field2321 = 1;
				}
			}
		}
		if (this.field2337 == -1) {
			this.field2337 = this.field2342 == 0 ? 0 : 1;
		}
	}

	@ObfuscatedName("ey.i(Lev;I)V")
	public void method2360(Packet arg0) {
		while (true) {
			int var2 = arg0.method1600();
			if (var2 == 0) {
				return;
			}
			this.method2365(arg0, var2);
		}
	}

	@ObfuscatedName("ey.s(Lev;II)V")
	public void method2365(Packet arg0, int arg1) {
		if (arg1 == 1) {
			int var3 = arg0.method1600();
			if (var3 > 0) {
				if (this.field2329 == null || field2340) {
					this.field2338 = new int[var3];
					this.field2329 = new int[var3];
					for (int var4 = 0; var4 < var3; var4++) {
						this.field2329[var4] = arg0.method1602();
						this.field2338[var4] = arg0.method1600();
					}
				} else {
					arg0.field1729 += var3 * 3;
				}
			}
		} else if (arg1 == 2) {
			this.field2310 = arg0.method1693();
		} else if (arg1 == 5) {
			int var5 = arg0.method1600();
			if (var5 > 0) {
				if (this.field2329 == null || field2340) {
					this.field2338 = null;
					this.field2329 = new int[var5];
					for (int var6 = 0; var6 < var5; var6++) {
						this.field2329[var6] = arg0.method1602();
					}
				} else {
					arg0.field1729 += var5 * 2;
				}
			}
		} else if (arg1 == 14) {
			this.field2344 = arg0.method1600();
		} else if (arg1 == 15) {
			this.field2318 = arg0.method1600();
		} else if (arg1 == 17) {
			this.field2342 = 0;
			this.field2319 = false;
		} else if (arg1 == 18) {
			this.field2319 = false;
		} else if (arg1 == 19) {
			this.field2321 = arg0.method1600();
		} else if (arg1 == 21) {
			this.field2322 = 0;
		} else if (arg1 == 22) {
			this.field2323 = true;
		} else if (arg1 == 23) {
			this.field2324 = true;
		} else if (arg1 == 24) {
			this.field2325 = arg0.method1602();
			if (this.field2325 == 65535) {
				this.field2325 = -1;
			}
		} else if (arg1 == 27) {
			this.field2342 = 1;
		} else if (arg1 == 28) {
			this.field2327 = arg0.method1600();
		} else if (arg1 == 29) {
			this.field2343 = arg0.method1595();
		} else if (arg1 == 39) {
			this.field2326 = arg0.method1595() * 25;
		} else if (arg1 >= 30 && arg1 < 35) {
			this.field2328[arg1 - 30] = arg0.method1693();
			if (this.field2328[arg1 - 30].equalsIgnoreCase(EnglishLocale.field869)) {
				this.field2328[arg1 - 30] = null;
			}
		} else if (arg1 == 40) {
			int var7 = arg0.method1600();
			this.field2313 = new short[var7];
			this.field2311 = new short[var7];
			for (int var8 = 0; var8 < var7; var8++) {
				this.field2313[var8] = (short) arg0.method1602();
				this.field2311[var8] = (short) arg0.method1602();
			}
		} else if (arg1 == 41) {
			int var9 = arg0.method1600();
			this.field2315 = new short[var9];
			this.field2316 = new short[var9];
			for (int var10 = 0; var10 < var9; var10++) {
				this.field2315[var10] = (short) arg0.method1602();
				this.field2316[var10] = (short) arg0.method1602();
			}
		} else if (arg1 == 60) {
			this.field2330 = arg0.method1602();
		} else if (arg1 == 62) {
			this.field2332 = true;
		} else if (arg1 == 64) {
			this.field2333 = false;
		} else if (arg1 == 65) {
			this.field2334 = arg0.method1602();
		} else if (arg1 == 66) {
			this.field2335 = arg0.method1602();
		} else if (arg1 == 67) {
			this.field2336 = arg0.method1602();
		} else if (arg1 == 68) {
			this.field2320 = arg0.method1602();
		} else if (arg1 == 69) {
			this.field2314 = arg0.method1600();
		} else if (arg1 == 70) {
			this.field2304 = arg0.method1603();
		} else if (arg1 == 71) {
			this.field2350 = arg0.method1603();
		} else if (arg1 == 72) {
			this.field2339 = arg0.method1603();
		} else if (arg1 == 73) {
			this.field2341 = true;
		} else if (arg1 == 74) {
			this.field2347 = true;
		} else if (arg1 == 75) {
			this.field2337 = arg0.method1600();
		} else if (arg1 == 77) {
			this.field2331 = arg0.method1602();
			if (this.field2331 == 65535) {
				this.field2331 = -1;
			}
			this.field2346 = arg0.method1602();
			if (this.field2346 == 65535) {
				this.field2346 = -1;
			}
			int var11 = arg0.method1600();
			this.field2317 = new int[var11 + 1];
			for (int var12 = 0; var12 <= var11; var12++) {
				this.field2317[var12] = arg0.method1602();
				if (this.field2317[var12] == 65535) {
					this.field2317[var12] = -1;
				}
			}
		} else if (arg1 == 78) {
			this.field2312 = arg0.method1602();
			this.field2348 = arg0.method1600();
		} else if (arg1 == 79) {
			this.field2349 = arg0.method1602();
			this.field2302 = arg0.method1602();
			this.field2348 = arg0.method1600();
			int var13 = arg0.method1600();
			this.field2351 = new int[var13];
			for (int var14 = 0; var14 < var13; var14++) {
				this.field2351[var14] = arg0.method1602();
			}
		} else if (arg1 == 81) {
			this.field2322 = arg0.method1600() * 256;
		}
	}

	@ObfuscatedName("ey.u(II)Z")
	public final boolean method2362(int arg0) {
		if (this.field2338 != null) {
			for (int var4 = 0; var4 < this.field2338.length; var4++) {
				if (this.field2338[var4] == arg0) {
					return Statics.field2303.method1046(this.field2329[var4] & 0xFFFF, 0);
				}
			}
			return true;
		} else if (this.field2329 == null) {
			return true;
		} else if (arg0 == 10) {
			boolean var2 = true;
			for (int var3 = 0; var3 < this.field2329.length; var3++) {
				var2 &= Statics.field2303.method1046(this.field2329[var3] & 0xFFFF, 0);
			}
			return var2;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ey.v(I)Z")
	public final boolean method2366() {
		if (this.field2329 == null) {
			return true;
		}
		boolean var1 = true;
		for (int var2 = 0; var2 < this.field2329.length; var2++) {
			var1 &= Statics.field2303.method1046(this.field2329[var2] & 0xFFFF, 0);
		}
		return var1;
	}

	@ObfuscatedName("ey.w(II[[IIIII)Lfu;")
	public final Entity method2364(int arg0, int arg1, int[][] arg2, int arg3, int arg4, int arg5) {
		long var7;
		if (this.field2338 == null) {
			var7 = (this.field2309 << 10) + arg1;
		} else {
			var7 = (this.field2309 << 10) + (arg0 << 3) + arg1;
		}
		Entity var9 = (Entity) field2306.method1244(var7);
		if (var9 == null) {
			Model var10 = this.method2367(arg0, arg1);
			if (var10 == null) {
				return null;
			}
			if (this.field2323) {
				var10.field2708 = (short) (this.field2343 + 64);
				var10.field2706 = (short) (this.field2326 + 768);
				var10.method2932();
				var9 = var10;
			} else {
				var9 = var10.method2942(this.field2343 + 64, this.field2326 + 768, -50, -10, -50);
			}
			field2306.method1246(var9, var7);
		}
		if (this.field2323) {
			var9 = ((Model) var9).method2982();
		}
		if (this.field2322 >= 0) {
			if (var9 instanceof SoftwareModel) {
				var9 = ((SoftwareModel) var9).method3054(arg2, arg3, arg4, arg5, true, this.field2322);
			} else if (var9 instanceof Model) {
				var9 = ((Model) var9).method2928(arg2, arg3, arg4, arg5, true, this.field2322);
			}
		}
		return var9;
	}

	@ObfuscatedName("ey.e(II[[IIIII)Lfo;")
	public final SoftwareModel method2386(int arg0, int arg1, int[][] arg2, int arg3, int arg4, int arg5) {
		long var7;
		if (this.field2338 == null) {
			var7 = (this.field2309 << 10) + arg1;
		} else {
			var7 = (this.field2309 << 10) + (arg0 << 3) + arg1;
		}
		SoftwareModel var9 = (SoftwareModel) field2307.method1244(var7);
		if (var9 == null) {
			Model var10 = this.method2367(arg0, arg1);
			if (var10 == null) {
				return null;
			}
			var9 = var10.method2942(this.field2343 + 64, this.field2326 + 768, -50, -10, -50);
			field2307.method1246(var9, var7);
		}
		if (this.field2322 >= 0) {
			var9 = var9.method3054(arg2, arg3, arg4, arg5, true, this.field2322);
		}
		return var9;
	}

	@ObfuscatedName("ey.b(II[[IIIILeo;IB)Lfo;")
	public final SoftwareModel method2376(int arg0, int arg1, int[][] arg2, int arg3, int arg4, int arg5, SeqType arg6, int arg7) {
		long var9;
		if (this.field2338 == null) {
			var9 = (this.field2309 << 10) + arg1;
		} else {
			var9 = (this.field2309 << 10) + (arg0 << 3) + arg1;
		}
		SoftwareModel var11 = (SoftwareModel) field2307.method1244(var9);
		if (var11 == null) {
			Model var12 = this.method2367(arg0, arg1);
			if (var12 == null) {
				return null;
			}
			var11 = var12.method2942(this.field2343 + 64, this.field2326 + 768, -50, -10, -50);
			field2307.method1246(var11, var9);
		}
		if (arg6 == null && this.field2322 == -1) {
			return var11;
		}
		SoftwareModel var13;
		if (arg6 == null) {
			var13 = var11.method2999(true);
		} else {
			var13 = arg6.method2419(var11, arg7, arg1);
		}
		if (this.field2322 >= 0) {
			var13 = var13.method3054(arg2, arg3, arg4, arg5, false, this.field2322);
		}
		return var13;
	}

	@ObfuscatedName("ey.y(IIB)Lfw;")
	public final Model method2367(int arg0, int arg1) {
		Model var3 = null;
		if (this.field2338 == null) {
			if (arg0 != 10) {
				return null;
			}
			if (this.field2329 == null) {
				return null;
			}
			boolean var4 = this.field2332;
			if (arg0 == 2 && arg1 > 3) {
				var4 = !var4;
			}
			int var5 = this.field2329.length;
			for (int var6 = 0; var6 < var5; var6++) {
				int var7 = this.field2329[var6];
				if (var4) {
					var7 += 65536;
				}
				var3 = (Model) field2305.method1244((long) var7);
				if (var3 == null) {
					var3 = Model.method2992(Statics.field2303, var7 & 0xFFFF, 0);
					if (var3 == null) {
						return null;
					}
					if (var4) {
						var3.method2981();
					}
					field2305.method1246(var3, (long) var7);
				}
				if (var5 > 1) {
					field2308[var6] = var3;
				}
			}
			if (var5 > 1) {
				var3 = new Model(field2308, var5);
			}
		} else {
			int var8 = -1;
			for (int var9 = 0; var9 < this.field2338.length; var9++) {
				if (this.field2338[var9] == arg0) {
					var8 = var9;
					break;
				}
			}
			if (var8 == -1) {
				return null;
			}
			int var10 = this.field2329[var8];
			boolean var11 = this.field2332 ^ arg1 > 3;
			if (var11) {
				var10 += 65536;
			}
			var3 = (Model) field2305.method1244((long) var10);
			if (var3 == null) {
				var3 = Model.method2992(Statics.field2303, var10 & 0xFFFF, 0);
				if (var3 == null) {
					return null;
				}
				if (var11) {
					var3.method2981();
				}
				field2305.method1246(var3, (long) var10);
			}
		}
		boolean var12;
		if (this.field2334 == 128 && this.field2335 == 128 && this.field2336 == 128) {
			var12 = false;
		} else {
			var12 = true;
		}
		boolean var13;
		if (this.field2304 == 0 && this.field2350 == 0 && this.field2339 == 0) {
			var13 = false;
		} else {
			var13 = true;
		}
		Model var14 = new Model(var3, arg1 == 0 && !var12 && !var13, this.field2313 == null, this.field2315 == null, true);
		if (arg0 == 4 && arg1 > 3) {
			var14.method2933(256);
			var14.method2934(45, 0, -45);
		}
		int var15 = arg1 & 0x3;
		if (var15 == 1) {
			var14.method2930();
		} else if (var15 == 2) {
			var14.method2931();
		} else if (var15 == 3) {
			var14.method2923();
		}
		if (this.field2313 != null) {
			for (int var16 = 0; var16 < this.field2313.length; var16++) {
				var14.method2935(this.field2313[var16], this.field2311[var16]);
			}
		}
		if (this.field2315 != null) {
			for (int var17 = 0; var17 < this.field2315.length; var17++) {
				var14.method2976(this.field2315[var17], this.field2316[var17]);
			}
		}
		if (var12) {
			var14.method2937(this.field2334, this.field2335, this.field2336);
		}
		if (var13) {
			var14.method2934(this.field2304, this.field2350, this.field2339);
		}
		return var14;
	}

	@ObfuscatedName("ey.t(B)Ley;")
	public final LocType method2368() {
		int var1 = -1;
		if (this.field2331 != -1) {
			var1 = VarProvider.method1130(this.field2331);
		} else if (this.field2346 != -1) {
			var1 = VarProvider.field1210[this.field2346];
		}
		return var1 < 0 || var1 >= this.field2317.length || this.field2317[var1] == -1 ? null : method2564(this.field2317[var1]);
	}

	@ObfuscatedName("ba.f(I)V")
	public static void method916() {
		field2345.method1253();
		field2305.method1253();
		field2306.method1253();
		field2307.method1253();
	}

	@ObfuscatedName("ey.k(B)Z")
	public boolean method2374() {
		if (this.field2317 == null) {
			return this.field2312 != -1 || this.field2351 != null;
		}
		for (int var1 = 0; var1 < this.field2317.length; var1++) {
			if (this.field2317[var1] != -1) {
				LocType var2 = method2564(this.field2317[var1]);
				if (var2.field2312 != -1 || var2.field2351 != null) {
					return true;
				}
			}
		}
		return false;
	}
}
