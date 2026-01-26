package jagex3.config;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable2;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;
import jagex3.js5.Js5;

// jag::oldscape::configdecoder::FloType
@ObfuscatedName("fb")
public class FloType extends Linkable2 {

	// jag::oldscape::configdecoder::FloType::m_pConfigClient
	@ObfuscatedName("by.n")
	public static Js5 configClient;

	@ObfuscatedName("fb.j")
	public static LruCache recentUse = new LruCache(64);

	@ObfuscatedName("fb.z")
	public int rgb = 0;

	@ObfuscatedName("fb.g")
	public int texture = -1;

	@ObfuscatedName("fb.q")
	public boolean occlude = true;

	@ObfuscatedName("fb.i")
	public int mapcolour = -1;

	@ObfuscatedName("fb.s")
	public int hue;

	@ObfuscatedName("fb.u")
	public int saturation;

	@ObfuscatedName("fb.v")
	public int luminance;

	@ObfuscatedName("fb.w")
	public int mapHue;

	@ObfuscatedName("fb.e")
	public int mapSaturation;

	@ObfuscatedName("fb.b")
	public int mapLuminance;

	// jag::oldscape::configdecoder::FloType::List
	@ObfuscatedName("cj.z(II)Lfb;")
	public static FloType list(int id) {
		FloType cached = (FloType) recentUse.find(id);
		if (cached != null) {
			return cached;
		}

		byte[] data = configClient.getFile(4, id);
		FloType type = new FloType();
		if (data != null) {
			type.decode(new Packet(data), id);
		}
		type.postDecode();

		recentUse.put(type, id);
		return type;
	}

	// jag::oldscape::configdecoder::FloType::PostDecode
	@ObfuscatedName("fb.g(B)V")
	public void postDecode() {
		if (this.mapcolour != -1) {
			this.getHsl(this.mapcolour);
			this.mapHue = this.hue;
			this.mapSaturation = this.saturation;
			this.mapLuminance = this.luminance;
		}

		this.getHsl(this.rgb);
	}

	// jag::oldscape::configdecoder::FloType::Decode
	@ObfuscatedName("fb.q(Lev;IB)V")
	public void decode(Packet buf, int id) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}

			this.decode(buf, code, id);
		}
	}

	// jag::oldscape::configdecoder::FloType::Decode
	@ObfuscatedName("fb.i(Lev;III)V")
	public void decode(Packet buf, int code, int id) {
		if (code == 1) {
			this.rgb = buf.g3();
		} else if (code == 2) {
			this.texture = buf.g1();
		} else if (code == 5) {
			this.occlude = false;
		} else if (code == 7) {
			this.mapcolour = buf.g3();
		} else if (code == 8) {
			// default water = id
		}
	}

	// jag::oldscape::configdecoder::FloType::GetHsl
	@ObfuscatedName("fb.s(II)V")
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
		this.hue = (int) (var18 * 256.0D);
		this.saturation = (int) (var14 * 256.0D);
		this.luminance = (int) (var16 * 256.0D);
		if (this.saturation < 0) {
			this.saturation = 0;
		} else if (this.saturation > 255) {
			this.saturation = 255;
		}
		if (this.luminance < 0) {
			this.luminance = 0;
		} else if (this.luminance > 255) {
			this.luminance = 255;
		}
	}

	public static void init(Js5 config) {
		configClient = config;
	}

	public static void resetCache() {
		recentUse.clear();
	}
}
