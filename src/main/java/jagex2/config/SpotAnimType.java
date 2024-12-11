package jagex2.config;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.graphics.Model;
import jagex2.graphics.SoftwareModel;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;
import jagex2.js5.Js5Provider;

@ObfuscatedName("eu")
public class SpotAnimType extends DoublyLinkable {

	@ObfuscatedName("eu.n")
	public static Js5Index configJs5;

	@ObfuscatedName("eu.j")
	public static Js5Index modelJs5;

	@ObfuscatedName("eu.z")
	public static LruCache field2379 = new LruCache(64);

	@ObfuscatedName("eu.g")
	public static LruCache field2392 = new LruCache(30);

	@ObfuscatedName("eu.q")
	public int field2382;

	@ObfuscatedName("eu.i")
	public int model;

	@ObfuscatedName("eu.s")
	public int anim = -1;

	@ObfuscatedName("eu.u")
	public short[] recol_s;

	@ObfuscatedName("eu.v")
	public short[] recol_d;

	@ObfuscatedName("eu.w")
	public short[] retex_s;

	@ObfuscatedName("eu.e")
	public short[] retex_d;

	@ObfuscatedName("eu.b")
	public int resizeh = 128;

	@ObfuscatedName("eu.y")
	public int resizev = 128;

	@ObfuscatedName("eu.t")
	public int angle = 0;

	@ObfuscatedName("eu.f")
	public int ambient = 0;

	@ObfuscatedName("eu.k")
	public int contrast = 0;

	@ObfuscatedName("cm.z(IB)Leu;")
	public static SpotAnimType get(int arg0) {
		SpotAnimType var1 = (SpotAnimType) field2379.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = configJs5.getFile(13, arg0);
		SpotAnimType var3 = new SpotAnimType();
		var3.field2382 = arg0;
		if (var2 != null) {
			var3.decode(new Packet(var2));
		}
		field2379.put(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("eu.g(Lev;I)V")
	public void decode(Packet arg0) {
		while (true) {
			int var2 = arg0.g1();
			if (var2 == 0) {
				return;
			}
			this.decodeInner(arg0, var2);
		}
	}

	@ObfuscatedName("eu.q(Lev;II)V")
	public void decodeInner(Packet arg0, int arg1) {
		if (arg1 == 1) {
			this.model = arg0.g2();
		} else if (arg1 == 2) {
			this.anim = arg0.g2();
		} else if (arg1 == 4) {
			this.resizeh = arg0.g2();
		} else if (arg1 == 5) {
			this.resizev = arg0.g2();
		} else if (arg1 == 6) {
			this.angle = arg0.g2();
		} else if (arg1 == 7) {
			this.ambient = arg0.g1();
		} else if (arg1 == 8) {
			this.contrast = arg0.g1();
		} else if (arg1 == 40) {
			int var3 = arg0.g1();
			this.recol_s = new short[var3];
			this.recol_d = new short[var3];
			for (int var4 = 0; var4 < var3; var4++) {
				this.recol_s[var4] = (short) arg0.g2();
				this.recol_d[var4] = (short) arg0.g2();
			}
		} else if (arg1 == 41) {
			int var5 = arg0.g1();
			this.retex_s = new short[var5];
			this.retex_d = new short[var5];
			for (int var6 = 0; var6 < var5; var6++) {
				this.retex_s[var6] = (short) arg0.g2();
				this.retex_d[var6] = (short) arg0.g2();
			}
		}
	}

	@ObfuscatedName("eu.i(IS)Lfo;")
	public final SoftwareModel method2455(int arg0) {
		SoftwareModel var2 = (SoftwareModel) field2392.get((long) this.field2382);
		if (var2 == null) {
			Model var3 = Model.tryGet(modelJs5, this.model, 0);
			if (var3 == null) {
				return null;
			}
			if (this.recol_s != null) {
				for (int var4 = 0; var4 < this.recol_s.length; var4++) {
					var3.recolour(this.recol_s[var4], this.recol_d[var4]);
				}
			}
			if (this.retex_s != null) {
				for (int var5 = 0; var5 < this.retex_s.length; var5++) {
					var3.retexture(this.retex_s[var5], this.retex_d[var5]);
				}
			}
			var2 = var3.calculateNormals(this.ambient + 64, this.contrast + 850, -30, -50, -30);
			field2392.put(var2, (long) this.field2382);
		}
		SoftwareModel var6;
		if (this.anim == -1 || arg0 == -1) {
			var6 = var2.method3040(true);
		} else {
			var6 = SeqType.get(this.anim).method2439(var2, arg0);
		}
		if (this.resizeh != 128 || this.resizev != 128) {
			var6.scale(this.resizeh, this.resizev, this.resizeh);
		}
		if (this.angle != 0) {
			if (this.angle == 90) {
				var6.method3008();
			}
			if (this.angle == 180) {
				var6.method3008();
				var6.method3008();
			}
			if (this.angle == 270) {
				var6.method3008();
				var6.method3008();
				var6.method3008();
			}
		}
		return var6;
	}

	public static void init(Js5Provider var36, Js5Provider var37) {
		configJs5 = var36;
		modelJs5 = var37;
	}
}
