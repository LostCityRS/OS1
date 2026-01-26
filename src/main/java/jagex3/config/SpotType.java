package jagex3.config;

import deob.ObfuscatedName;
import jagex3.dash3d.ModelLit;
import jagex3.dash3d.ModelUnlit;
import jagex3.datastruct.Linkable2;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;
import jagex3.js5.Js5;
import jagex3.js5.Js5Loader;

// jag::oldscape::configdecoder::SpotType
@ObfuscatedName("eu")
public class SpotType extends Linkable2 {

	// jag::oldscape::configdecoder::SpotType::m_pConfigClient
	@ObfuscatedName("eu.n")
	public static Js5 configClient;

	// jag::oldscape::configdecoder::SpotType::m_pModels
	@ObfuscatedName("eu.j")
	public static Js5 models;

	// jag::oldscape::configdecoder::SpotType::m_recentUse
	@ObfuscatedName("eu.z")
	public static LruCache recentUse = new LruCache(64);

	// jag::oldscape::configdecoder::SpotType::m_modelCache
	@ObfuscatedName("eu.g")
	public static LruCache modelCache = new LruCache(30);

	@ObfuscatedName("eu.q")
	public int id;

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

	// jag::oldscape::configdecoder::SpotType::List
	@ObfuscatedName("cm.z(IB)Leu;")
	public static SpotType list(int id) {
		SpotType var1 = (SpotType) recentUse.find((long) id);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = configClient.getFile(13, id);
		SpotType var3 = new SpotType();
		var3.id = id;
		if (var2 != null) {
			var3.decode(new Packet(var2));
		}
		recentUse.put(var3, (long) id);
		return var3;
	}

	// jag::oldscape::configdecoder::SpotType::Decode
	@ObfuscatedName("eu.g(Lev;I)V")
	public void decode(Packet arg0) {
		while (true) {
			int var2 = arg0.g1();
			if (var2 == 0) {
				return;
			}
			this.decode(arg0, var2);
		}
	}

	// jag::oldscape::configdecoder::SpotType::Decode
	@ObfuscatedName("eu.q(Lev;II)V")
	public void decode(Packet arg0, int arg1) {
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

	// jag::oldscape::configdecoder::SpotType::GetTempModel2
	@ObfuscatedName("eu.i(IS)Lfo;")
	public final ModelLit getTempModel2(int arg0) {
		ModelLit var2 = (ModelLit) modelCache.find((long) this.id);
		if (var2 == null) {
			ModelUnlit var3 = ModelUnlit.load(models, this.model, 0);
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
			var2 = var3.light(this.ambient + 64, this.contrast + 850, -30, -50, -30);
			modelCache.put(var2, (long) this.id);
		}
		ModelLit var6;
		if (this.anim == -1 || arg0 == -1) {
			var6 = var2.copyForAnim2(true);
		} else {
			var6 = SeqType.list(this.anim).animateModel2(var2, arg0);
		}
		if (this.resizeh != 128 || this.resizev != 128) {
			var6.resize(this.resizeh, this.resizev, this.resizeh);
		}
		if (this.angle != 0) {
			if (this.angle == 90) {
				var6.rotate90();
			}
			if (this.angle == 180) {
				var6.rotate90();
				var6.rotate90();
			}
			if (this.angle == 270) {
				var6.rotate90();
				var6.rotate90();
				var6.rotate90();
			}
		}
		return var6;
	}

	// jag::oldscape::configdecoder::SpotType::Init
	public static void init(Js5Loader var36, Js5Loader var37) {
		configClient = var36;
		models = var37;
	}

	// jag::oldscape::configdecoder::SpotType::ResetCache
	public static void resetCache() {
		recentUse.clear();
		modelCache.clear();
	}
}
