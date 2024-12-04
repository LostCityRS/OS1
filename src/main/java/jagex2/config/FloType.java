package jagex2.config;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("fb")
public class FloType extends DoublyLinkable {

	@ObfuscatedName("by.n")
	public static Js5Index configJs5;

	@ObfuscatedName("fb.j")
	public static LruCache field2411 = new LruCache(64);

	@ObfuscatedName("fb.z")
	public int rgb = 0;

	@ObfuscatedName("fb.g")
	public int texture = -1;

	@ObfuscatedName("fb.q")
	public boolean occlude = true;

	@ObfuscatedName("fb.i")
	public int averageRgb = -1;

	@ObfuscatedName("fb.s")
	public int field2409;

	@ObfuscatedName("fb.u")
	public int field2413;

	@ObfuscatedName("fb.v")
	public int field2405;

	@ObfuscatedName("fb.w")
	public int field2410;

	@ObfuscatedName("fb.e")
	public int field2412;

	@ObfuscatedName("fb.b")
	public int field2415;

	@ObfuscatedName("cj.z(II)Lfb;")
	public static FloType get(int arg0) {
		FloType var1 = (FloType) field2411.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = configJs5.method1044(4, arg0);
		FloType var3 = new FloType();
		if (var2 != null) {
			var3.decode(new Packet(var2), arg0);
		}
		var3.postDecode();
		field2411.put(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("fb.g(B)V")
	public void postDecode() {
		if (this.averageRgb != -1) {
			this.method2488(this.averageRgb);
			this.field2410 = this.field2409;
			this.field2412 = this.field2413;
			this.field2415 = this.field2405;
		}
		this.method2488(this.rgb);
	}

	@ObfuscatedName("fb.q(Lev;IB)V")
	public void decode(Packet buf, int arg1) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}
			this.decodeInner(buf, code, arg1);
		}
	}

	@ObfuscatedName("fb.i(Lev;III)V")
	public void decodeInner(Packet buf, int code, int arg2) {
		if (code == 1) {
			this.rgb = buf.g3();
		} else if (code == 2) {
			this.texture = buf.g1();
		} else if (code == 5) {
			this.occlude = false;
		} else if (code == 7) {
			this.averageRgb = buf.g3();
		} else if (code == 8) {
		}
	}

	@ObfuscatedName("fb.s(II)V")
	public void method2488(int arg0) {
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
		this.field2409 = (int) (var18 * 256.0D);
		this.field2413 = (int) (var14 * 256.0D);
		this.field2405 = (int) (var16 * 256.0D);
		if (this.field2413 < 0) {
			this.field2413 = 0;
		} else if (this.field2413 > 255) {
			this.field2413 = 255;
		}
		if (this.field2405 < 0) {
			this.field2405 = 0;
		} else if (this.field2405 > 255) {
			this.field2405 = 255;
		}
	}
}
