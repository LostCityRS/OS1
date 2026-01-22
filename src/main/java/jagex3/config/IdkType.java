package jagex3.config;

import deob.ObfuscatedName;
import jagex3.dash3d.ModelUnlit;
import jagex3.datastruct.DoublyLinkable;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;
import jagex3.js5.Js5;

// jag::oldscape::configdecoder::IdkType
@ObfuscatedName("fd")
public class IdkType extends DoublyLinkable {

	// jag::oldscape::configdecoder::IdkType::m_pConfigClient
	@ObfuscatedName("fd.n")
	public static Js5 configClient;

	// jag::oldscape::configdecoder::IdkType::m_pModels
	@ObfuscatedName("fd.j")
	public static Js5 models;

	// jag::oldscape::configdecoder::IdkType::m_numDefinitions
	@ObfuscatedName("dl.z")
	public static int numDefinitions;

	// jag::oldscape::configdecoder::IdkType::m_recentUse
	@ObfuscatedName("fd.g")
	public static LruCache recentUse = new LruCache(64);

	@ObfuscatedName("fd.q")
	public int type = -1;

	@ObfuscatedName("fd.i")
	public int[] model;

	@ObfuscatedName("fd.s")
	public short[] recol_s;

	@ObfuscatedName("fd.u")
	public short[] recol_d;

	@ObfuscatedName("fd.v")
	public short[] retex_s;

	@ObfuscatedName("fd.w")
	public short[] retex_d;

	@ObfuscatedName("fd.e")
	public int[] head = new int[] { -1, -1, -1, -1, -1 };

	@ObfuscatedName("fd.b")
	public boolean disable = false;

	// jag::oldscape::configdecoder::IdkType::Init
	@ObfuscatedName("ct.z(Lch;Lch;I)V")
	public static void init(Js5 config, Js5 model) {
		configClient = config;
		models = model;

		numDefinitions = configClient.getFileIdLimit(3);
	}

	// jag::oldscape::configdecoder::IdkType::List
	@ObfuscatedName("p.g(II)Lfd;")
	public static IdkType list(int arg0) {
		IdkType cached = (IdkType) recentUse.get(arg0);
		if (cached != null) {
			return cached;
		}

		byte[] data = configClient.getFile(3, arg0);
		IdkType type = new IdkType();
		if (data != null) {
			type.decode(new Packet(data));
		}

		recentUse.put(type, arg0);
		return type;
	}

	// jag::oldscape::configdecoder::IdkType::Decode
	@ObfuscatedName("fd.q(Lev;I)V")
	public void decode(Packet buf) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}

			this.decode(buf, code);
		}
	}

	// jag::oldscape::configdecoder::IdkType::Decode
	@ObfuscatedName("fd.i(Lev;II)V")
	public void decode(Packet buf, int code) {
		if (code == 1) {
			this.type = buf.g1();
		} else if (code == 2) {
			int count = buf.g1();

			this.model = new int[count];

			for (int i = 0; i < count; i++) {
				this.model[i] = buf.g2();
			}
		} else if (code == 3) {
			this.disable = true;
		} else if (code == 40) {
			int count = buf.g1();

			this.recol_s = new short[count];
			this.recol_d = new short[count];

			for (int var6 = 0; var6 < count; var6++) {
				this.recol_s[var6] = (short) buf.g2();
				this.recol_d[var6] = (short) buf.g2();
			}
		} else if (code == 41) {
			int count = buf.g1();

			this.retex_s = new short[count];
			this.retex_d = new short[count];

			for (int var8 = 0; var8 < count; var8++) {
				this.retex_s[var8] = (short) buf.g2();
				this.retex_d[var8] = (short) buf.g2();
			}
		} else if (code >= 60 && code < 70) {
			this.head[code - 60] = buf.g2();
		}
	}

	// jag::oldscape::configdecoder::IdkType::CheckModel
	@ObfuscatedName("fd.s(I)Z")
	public boolean checkModel() {
		if (this.model == null) {
			return true;
		}

		boolean status = true;
		for (int i = 0; i < this.model.length; i++) {
			if (!models.requestDownload(this.model[i], 0)) {
				status = false;
			}
		}

		return status;
	}

	// jag::oldscape::configdecoder::IdkType::GetModelNoCheck
	@ObfuscatedName("fd.u(S)Lfw;")
	public ModelUnlit getModelNoCheck() {
		if (this.model == null) {
			return null;
		}

		ModelUnlit[] models = new ModelUnlit[this.model.length];
		for (int i = 0; i < this.model.length; i++) {
			models[i] = ModelUnlit.load(IdkType.models, this.model[i], 0);
		}

		ModelUnlit model;
		if (models.length == 1) {
			model = models[0];
		} else {
			model = new ModelUnlit(models, models.length);
		}

		if (this.recol_s != null) {
			for (int i = 0; i < this.recol_s.length; i++) {
				model.recolour(this.recol_s[i], this.recol_d[i]);
			}
		}

		if (this.retex_s != null) {
			for (int i = 0; i < this.retex_s.length; i++) {
				model.retexture(this.retex_s[i], this.retex_d[i]);
			}
		}

		return model;
	}

	// jag::oldscape::configdecoder::IdkType::CheckHead
	@ObfuscatedName("fd.v(B)Z")
	public boolean checkHead() {
		boolean status = true;
		for (int i = 0; i < 5; i++) {
			if (this.head[i] != -1 && !models.requestDownload(this.head[i], 0)) {
				status = false;
			}
		}
		return status;
	}

	// jag::oldscape::configdecoder::IdkType::GetHeadNoCheck
	@ObfuscatedName("fd.w(B)Lfw;")
	public ModelUnlit getHeadNoCheck() {
		ModelUnlit[] models = new ModelUnlit[5];
		int modelCount = 0;
		for (int i = 0; i < 5; i++) {
			if (this.head[i] != -1) {
				models[modelCount++] = ModelUnlit.load(IdkType.models, this.head[i], 0);
			}
		}

		ModelUnlit model = new ModelUnlit(models, modelCount);
		if (this.recol_s != null) {
			for (int i = 0; i < this.recol_s.length; i++) {
				model.recolour(this.recol_s[i], this.recol_d[i]);
			}
		}

		if (this.retex_s != null) {
			for (int i = 0; i < this.retex_s.length; i++) {
				model.retexture(this.retex_s[i], this.retex_d[i]);
			}
		}

		return model;
	}

	// jag::oldscape::configdecoder::IdkType::ResetCache
	public static void resetCache() {
		recentUse.clear();
	}
}
