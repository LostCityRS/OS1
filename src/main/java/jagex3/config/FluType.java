package jagex3.config;

import deob.ObfuscatedName;
import jagex3.datastruct.DoublyLinkable;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;
import jagex3.js5.Js5;

@ObfuscatedName("ec")
public class FluType extends DoublyLinkable {

	@ObfuscatedName("ec.n")
	public static Js5 configJs5;

	@ObfuscatedName("ec.j")
	public static LruCache cache = new LruCache(64);

	@ObfuscatedName("ec.z")
	public int rgb = 0;

	@ObfuscatedName("ec.g")
	public int chroma;

	@ObfuscatedName("ec.q")
	public int hue;

	@ObfuscatedName("ec.i")
	public int saturation;

	@ObfuscatedName("ec.s")
	public int luminance;

	@ObfuscatedName("u.z(Lch;I)V")
	public static void unpack(Js5 config) {
		configJs5 = config;
	}

	@ObfuscatedName("bf.g(IB)Lec;")
	public static FluType get(int id) {
		FluType cached = (FluType) cache.get(id);
		if (cached != null) {
			return cached;
		}

		byte[] data = configJs5.getFile(1, id);
		FluType type = new FluType();
		if (data != null) {
			type.decode(new Packet(data), id);
		}
		type.postDecode();

		cache.put(type, id);
		return type;
	}

	@ObfuscatedName("ec.q(I)V")
	public void postDecode() {
		this.getHsl(this.rgb);
	}

	@ObfuscatedName("ec.i(Lev;II)V")
	public void decode(Packet buf, int id) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}

			this.decodeInner(buf, code, id);
		}
	}

	@ObfuscatedName("ec.s(Lev;III)V")
	public void decodeInner(Packet buf, int code, int id) {
		if (code == 1) {
			this.rgb = buf.g3();
		}
	}

	@ObfuscatedName("ec.u(IB)V")
	public void getHsl(int arg0) {
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
		this.hue = (int) (var14 * 256.0D);
		this.saturation = (int) (var16 * 256.0D);
		if (this.hue < 0) {
			this.hue = 0;
		} else if (this.hue > 255) {
			this.hue = 255;
		}
		if (this.saturation < 0) {
			this.saturation = 0;
		} else if (this.saturation > 255) {
			this.saturation = 255;
		}
		if (var16 > 0.5D) {
			this.luminance = (int) ((1.0D - var16) * var14 * 512.0D);
		} else {
			this.luminance = (int) (var14 * var16 * 512.0D);
		}
		if (this.luminance < 1) {
			this.luminance = 1;
		}
		this.chroma = (int) ((double) this.luminance * var18);
	}

	@ObfuscatedName("fg.v(I)V")
	public static void unload() {
		cache.clear();
	}
}
