package jagex3.config;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable2;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;
import jagex3.js5.Js5;

// jag::oldscape::configdecoder::FluType
@ObfuscatedName("ec")
public class FluType extends Linkable2 {

	// jag::oldscape::configdecoder::FluType::m_pConfigClient
	@ObfuscatedName("ec.n")
	public static Js5 configClient;

	@ObfuscatedName("ec.j")
	public static LruCache recentUse = new LruCache(64);

	@ObfuscatedName("ec.z")
	public int colour = 0;

	@ObfuscatedName("ec.g")
	public int hue;

	@ObfuscatedName("ec.q")
	public int saturation;

	@ObfuscatedName("ec.i")
	public int lightness;

	@ObfuscatedName("ec.s")
	public int chroma;

	// jag::oldscape::configdecoder::FluType::Init
	@ObfuscatedName("u.z(Lch;I)V")
	public static void init(Js5 config) {
		configClient = config;
	}

	// jag::oldscape::configdecoder::FluType::List
	@ObfuscatedName("bf.g(IB)Lec;")
	public static FluType list(int id) {
		FluType cached = (FluType) recentUse.find(id);
		if (cached != null) {
			return cached;
		}

		byte[] data = configClient.getFile(1, id);
		FluType type = new FluType();
		if (data != null) {
			type.decode(new Packet(data), id);
		}
		type.postDecode();

		recentUse.put(type, id);
		return type;
	}

	// jag::oldscape::configdecoder::FluType::PostDecode
	@ObfuscatedName("ec.q(I)V")
	public void postDecode() {
		this.getHsl(this.colour);
	}

	// jag::oldscape::configdecoder::FluType::Decode
	@ObfuscatedName("ec.i(Lev;II)V")
	public void decode(Packet buf, int id) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}

			this.decode(buf, code, id);
		}
	}

	// jag::oldscape::configdecoder::FluType::Decode
	@ObfuscatedName("ec.s(Lev;III)V")
	public void decode(Packet buf, int code, int id) {
		if (code == 1) {
			this.colour = buf.g3();
		}
	}

	// jag::oldscape::configdecoder::FluType::GetHsl
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
		this.saturation = (int) (var14 * 256.0D);
		this.lightness = (int) (var16 * 256.0D);
		if (this.saturation < 0) {
			this.saturation = 0;
		} else if (this.saturation > 255) {
			this.saturation = 255;
		}
		if (this.lightness < 0) {
			this.lightness = 0;
		} else if (this.lightness > 255) {
			this.lightness = 255;
		}
		if (var16 > 0.5D) {
			this.chroma = (int) ((1.0D - var16) * var14 * 512.0D);
		} else {
			this.chroma = (int) (var14 * var16 * 512.0D);
		}
		if (this.chroma < 1) {
			this.chroma = 1;
		}
		this.hue = (int) ((double) this.chroma * var18);
	}

	@ObfuscatedName("fg.v(I)V")
	public static void resetCache() {
		recentUse.clear();
	}
}
