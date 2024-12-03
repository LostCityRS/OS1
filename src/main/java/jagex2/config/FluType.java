package jagex2.config;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("ec")
public class FluType extends DoublyLinkable {

	@ObfuscatedName("ec.n")
	public static Js5Index field2358;

	@ObfuscatedName("ec.j")
	public static LruCache field2355 = new LruCache(64);

	@ObfuscatedName("ec.z")
	public int rgb = 0;

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
		field2358 = arg0;
	}

	@ObfuscatedName("bf.g(IB)Lec;")
	public static FluType get(int arg0) {
		FluType var1 = (FluType) field2355.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = field2358.method1044(1, arg0);
		FluType var3 = new FluType();
		if (var2 != null) {
			var3.decode(new Packet(var2), arg0);
		}
		var3.postDecode();
		field2355.put(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("ec.q(I)V")
	public void postDecode() {
		this.method2401(this.rgb);
	}

	@ObfuscatedName("ec.i(Lev;II)V")
	public void decode(Packet buf, int arg1) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}
			this.decodeInner(buf, code, arg1);
		}
	}

	@ObfuscatedName("ec.s(Lev;III)V")
	public void decodeInner(Packet buf, int code, int arg2) {
		if (code == 1) {
			this.rgb = buf.g3();
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
		field2355.clear();
	}
}
