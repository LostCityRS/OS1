package jagex2.config;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.io.Packet;

@ObfuscatedName("fb")
public class FloType extends DoublyLinkable {

	@ObfuscatedName("fb.j")
	public static LruCache field2411 = new LruCache(64);

	@ObfuscatedName("fb.z")
	public int field2406 = 0;

	@ObfuscatedName("fb.g")
	public int field2407 = -1;

	@ObfuscatedName("fb.q")
	public boolean field2408 = true;

	@ObfuscatedName("fb.i")
	public int field2414 = -1;

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
	public static FloType method1002(int arg0) {
		FloType var1 = (FloType) field2411.method1244((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = Statics.field808.method1044(4, arg0);
		FloType var3 = new FloType();
		if (var2 != null) {
			var3.method2499(new Packet(var2), arg0);
		}
		var3.method2485();
		field2411.method1246(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("fb.g(B)V")
	public void method2485() {
		if (this.field2414 != -1) {
			this.method2488(this.field2414);
			this.field2410 = this.field2409;
			this.field2412 = this.field2413;
			this.field2415 = this.field2405;
		}
		this.method2488(this.field2406);
	}

	@ObfuscatedName("fb.q(Lev;IB)V")
	public void method2499(Packet arg0, int arg1) {
		while (true) {
			int var3 = arg0.g1();
			if (var3 == 0) {
				return;
			}
			this.method2487(arg0, var3, arg1);
		}
	}

	@ObfuscatedName("fb.i(Lev;III)V")
	public void method2487(Packet arg0, int arg1, int arg2) {
		if (arg1 == 1) {
			this.field2406 = arg0.g3();
		} else if (arg1 == 2) {
			this.field2407 = arg0.g1();
		} else if (arg1 == 5) {
			this.field2408 = false;
		} else if (arg1 == 7) {
			this.field2414 = arg0.g3();
		} else if (arg1 == 8) {
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
