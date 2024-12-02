package jagex2.config;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("ec")
public class FluType extends DoublyLinkable {

	@ObfuscatedName("ec.j")
	public static LruCache field2355 = new LruCache(64);

	@ObfuscatedName("ec.z")
	public int field2354 = 0;

	@ObfuscatedName("ec.g")
	public int field2357;

	@ObfuscatedName("ec.q")
	public int field2356;

	@ObfuscatedName("ec.i")
	public int field2359;

	@ObfuscatedName("ec.s")
	public int field2360;

	@ObfuscatedName("u.z(Lch;I)V")
	public static void method128(Js5Index arg0) {
		Statics.field2358 = arg0;
	}

	@ObfuscatedName("bf.g(IB)Lec;")
	public static FluType method840(int arg0) {
		FluType var1 = (FluType) field2355.method1244((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = Statics.field2358.method1044(1, arg0);
		FluType var3 = new FluType();
		if (var2 != null) {
			var3.method2399(new Packet(var2), arg0);
		}
		var3.method2398();
		field2355.method1246(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("ec.q(I)V")
	public void method2398() {
		this.method2401(this.field2354);
	}

	@ObfuscatedName("ec.i(Lev;II)V")
	public void method2399(Packet arg0, int arg1) {
		while (true) {
			int var3 = arg0.method1600();
			if (var3 == 0) {
				return;
			}
			this.method2400(arg0, var3, arg1);
		}
	}

	@ObfuscatedName("ec.s(Lev;III)V")
	public void method2400(Packet arg0, int arg1, int arg2) {
		if (arg1 == 1) {
			this.field2354 = arg0.method1728();
		}
	}

	@ObfuscatedName("ec.u(IB)V")
	public void method2401(int arg0) {
		double var2 = (double) (arg0 >> 16 & 0xFF) / 256.0D;
		double var4 = (double) (arg0 >> 8 & 0xFF) / 256.0D;
		double var6 = (double) (arg0 & 0xFF) / 256.0D;
		double var8 = var2;
		if (var4 < var2) {
			var8 = var4;
		}
		if (var6 < var8) {
			var8 = var6;
		}
		double var10 = var2;
		if (var4 > var2) {
			var10 = var4;
		}
		if (var6 > var10) {
			var10 = var6;
		}
		double var12 = 0.0D;
		double var14 = 0.0D;
		double var16 = (var8 + var10) / 2.0D;
		if (var8 != var10) {
			if (var16 < 0.5D) {
				var14 = (var10 - var8) / (var8 + var10);
			}
			if (var16 >= 0.5D) {
				var14 = (var10 - var8) / (2.0D - var10 - var8);
			}
			if (var2 == var10) {
				var12 = (var4 - var6) / (var10 - var8);
			} else if (var4 == var10) {
				var12 = (var6 - var2) / (var10 - var8) + 2.0D;
			} else if (var6 == var10) {
				var12 = (var2 - var4) / (var10 - var8) + 4.0D;
			}
		}
		double var18 = var12 / 6.0D;
		this.field2356 = (int) (var14 * 256.0D);
		this.field2359 = (int) (var16 * 256.0D);
		if (this.field2356 < 0) {
			this.field2356 = 0;
		} else if (this.field2356 > 255) {
			this.field2356 = 255;
		}
		if (this.field2359 < 0) {
			this.field2359 = 0;
		} else if (this.field2359 > 255) {
			this.field2359 = 255;
		}
		if (var16 > 0.5D) {
			this.field2360 = (int) ((1.0D - var16) * var14 * 512.0D);
		} else {
			this.field2360 = (int) (var14 * var16 * 512.0D);
		}
		if (this.field2360 < 1) {
			this.field2360 = 1;
		}
		this.field2357 = (int) ((double) this.field2360 * var18);
	}

	@ObfuscatedName("fg.v(I)V")
	public static void method2580() {
		field2355.method1253();
	}
}
