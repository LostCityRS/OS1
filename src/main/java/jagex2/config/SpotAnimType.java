package jagex2.config;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.graphics.Model;
import jagex2.graphics.SoftwareModel;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("eu")
public class SpotAnimType extends DoublyLinkable {

	@ObfuscatedName("eu.n")
	public static Js5Index field2381;

	@ObfuscatedName("eu.j")
	public static Js5Index field2385;

	@ObfuscatedName("eu.z")
	public static LruCache field2379 = new LruCache(64);

	@ObfuscatedName("eu.g")
	public static LruCache field2392 = new LruCache(30);

	@ObfuscatedName("eu.q")
	public int field2382;

	@ObfuscatedName("eu.i")
	public int field2383;

	@ObfuscatedName("eu.s")
	public int field2390 = -1;

	@ObfuscatedName("eu.u")
	public short[] field2384;

	@ObfuscatedName("eu.v")
	public short[] field2386;

	@ObfuscatedName("eu.w")
	public short[] field2387;

	@ObfuscatedName("eu.e")
	public short[] field2388;

	@ObfuscatedName("eu.b")
	public int field2378 = 128;

	@ObfuscatedName("eu.y")
	public int field2389 = 128;

	@ObfuscatedName("eu.t")
	public int field2380 = 0;

	@ObfuscatedName("eu.f")
	public int field2391 = 0;

	@ObfuscatedName("eu.k")
	public int field2393 = 0;

	@ObfuscatedName("cm.z(IB)Leu;")
	public static SpotAnimType method1133(int arg0) {
		SpotAnimType var1 = (SpotAnimType) field2379.method1244((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = field2381.method1044(13, arg0);
		SpotAnimType var3 = new SpotAnimType();
		var3.field2382 = arg0;
		if (var2 != null) {
			var3.method2445(new Packet(var2));
		}
		field2379.method1246(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("eu.g(Lev;I)V")
	public void method2445(Packet arg0) {
		while (true) {
			int var2 = arg0.g1();
			if (var2 == 0) {
				return;
			}
			this.method2446(arg0, var2);
		}
	}

	@ObfuscatedName("eu.q(Lev;II)V")
	public void method2446(Packet arg0, int arg1) {
		if (arg1 == 1) {
			this.field2383 = arg0.g2();
		} else if (arg1 == 2) {
			this.field2390 = arg0.g2();
		} else if (arg1 == 4) {
			this.field2378 = arg0.g2();
		} else if (arg1 == 5) {
			this.field2389 = arg0.g2();
		} else if (arg1 == 6) {
			this.field2380 = arg0.g2();
		} else if (arg1 == 7) {
			this.field2391 = arg0.g1();
		} else if (arg1 == 8) {
			this.field2393 = arg0.g1();
		} else if (arg1 == 40) {
			int var3 = arg0.g1();
			this.field2384 = new short[var3];
			this.field2386 = new short[var3];
			for (int var4 = 0; var4 < var3; var4++) {
				this.field2384[var4] = (short) arg0.g2();
				this.field2386[var4] = (short) arg0.g2();
			}
		} else if (arg1 == 41) {
			int var5 = arg0.g1();
			this.field2387 = new short[var5];
			this.field2388 = new short[var5];
			for (int var6 = 0; var6 < var5; var6++) {
				this.field2387[var6] = (short) arg0.g2();
				this.field2388[var6] = (short) arg0.g2();
			}
		}
	}

	@ObfuscatedName("eu.i(IS)Lfo;")
	public final SoftwareModel method2455(int arg0) {
		SoftwareModel var2 = (SoftwareModel) field2392.method1244((long) this.field2382);
		if (var2 == null) {
			Model var3 = Model.method2992(field2385, this.field2383, 0);
			if (var3 == null) {
				return null;
			}
			if (this.field2384 != null) {
				for (int var4 = 0; var4 < this.field2384.length; var4++) {
					var3.method2935(this.field2384[var4], this.field2386[var4]);
				}
			}
			if (this.field2387 != null) {
				for (int var5 = 0; var5 < this.field2387.length; var5++) {
					var3.method2976(this.field2387[var5], this.field2388[var5]);
				}
			}
			var2 = var3.method2942(this.field2391 + 64, this.field2393 + 850, -30, -50, -30);
			field2392.method1246(var2, (long) this.field2382);
		}
		SoftwareModel var6;
		if (this.field2390 == -1 || arg0 == -1) {
			var6 = var2.method3040(true);
		} else {
			var6 = SeqType.method104(this.field2390).method2439(var2, arg0);
		}
		if (this.field2378 != 128 || this.field2389 != 128) {
			var6.method3013(this.field2378, this.field2389, this.field2378);
		}
		if (this.field2380 != 0) {
			if (this.field2380 == 90) {
				var6.method3008();
			}
			if (this.field2380 == 180) {
				var6.method3008();
				var6.method3008();
			}
			if (this.field2380 == 270) {
				var6.method3008();
				var6.method3008();
				var6.method3008();
			}
		}
		return var6;
	}
}
