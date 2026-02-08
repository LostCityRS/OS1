package jagex3.config;

import deob.ObfuscatedName;
import jagex3.constants.Text;
import jagex3.dash3d.ModelLit;
import jagex3.dash3d.ModelUnlit;
import jagex3.datastruct.Linkable2;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;
import jagex3.js5.Js5;
import jagex3.var.VarCache;

// jag::oldscape::configdecoder::NpcType
@ObfuscatedName("em")
public class NpcType extends Linkable2 {

	// jag::oldscape::configdecoder::NpcType::m_pConfigClient
	@ObfuscatedName("em.n")
	public static Js5 configClient;

	// jag::oldscape::configdecoder::NpcType::m_pModels
	@ObfuscatedName("dy.j")
	public static Js5 models;

	// jag::oldscape::configdecoder::NpcType::m_recentUse
	@ObfuscatedName("em.z")
	public static LruCache recentUse = new LruCache(64);

	// jag::oldscape::configdecoder::NpcType::m_modelCache
	@ObfuscatedName("em.g")
	public static LruCache modelCache = new LruCache(50);

	@ObfuscatedName("em.q")
	public int id;

	@ObfuscatedName("em.i")
	public String name = "null";

	@ObfuscatedName("em.s")
	public int size = 1;

	@ObfuscatedName("em.u")
	public int[] model;

	@ObfuscatedName("em.v")
	public int[] head;

	@ObfuscatedName("em.w")
	public int readyanim = -1;

	@ObfuscatedName("em.e")
	public int turnleftanim = -1;

	@ObfuscatedName("em.b")
	public int turnrightanim = -1;

	@ObfuscatedName("em.y")
	public int walkanim = -1;

	@ObfuscatedName("em.t")
	public int walkanim_b = -1;

	@ObfuscatedName("em.f")
	public int walkanim_r = -1;

	@ObfuscatedName("em.k")
	public int walkanim_l = -1;

	@ObfuscatedName("em.o")
	public short[] recol_s;

	@ObfuscatedName("em.a")
	public short[] recol_d;

	@ObfuscatedName("em.h")
	public short[] retex_s;

	@ObfuscatedName("em.x")
	public short[] retex_d;

	@ObfuscatedName("em.p")
	public String[] op = new String[5];

	@ObfuscatedName("em.ad")
	public boolean minimap = true;

	@ObfuscatedName("em.ac")
	public int vislevel = -1;

	@ObfuscatedName("em.aa")
	public int resizeh = 128;

	@ObfuscatedName("em.as")
	public int resizev = 128;

	@ObfuscatedName("em.am")
	public boolean alwaysontop = false;

	@ObfuscatedName("em.ap")
	public int ambient = 0;

	@ObfuscatedName("em.av")
	public int contrast = 0;

	@ObfuscatedName("em.ak")
	public int headicon = -1;

	@ObfuscatedName("em.az")
	public int turnspeed = 32;

	@ObfuscatedName("em.an")
	public int[] multinpc;

	@ObfuscatedName("em.ah")
	public int multivarbit = -1;

	@ObfuscatedName("em.ay")
	public int multivarp = -1;

	@ObfuscatedName("em.al")
	public boolean active = true;

	@ObfuscatedName("em.ab")
	public boolean walksmoothing = true;

	// jag::oldscape::configdecoder::NpcType::Init
	@ObfuscatedName("by.z(Lch;Lch;B)V")
	public static void init(Js5 config, Js5 model) {
		configClient = config;
		models = model;
	}

	// jag::oldscape::configdecoder::NpcType::List
	@ObfuscatedName("f.g(IB)Lem;")
	public static NpcType list(int id) {
		NpcType cached = (NpcType) recentUse.find(id);
		if (cached != null) {
			return cached;
		}

		byte[] buf = configClient.getFile(9, id);
		NpcType npc = new NpcType();
		npc.id = id;
		if (buf != null) {
			npc.decode(new Packet(buf));
		}
		npc.postDecode();

		recentUse.put(npc, id);
		return npc;
	}

	// jag::oldscape::configdecoder::NpcType::PostDecode
	@ObfuscatedName("em.q(I)V")
	public void postDecode() {
	}

	// jag::oldscape::configdecoder::NpcType::Decode
	@ObfuscatedName("em.i(Lev;I)V")
	public void decode(Packet buf) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}

			this.decode(buf, code);
		}
	}

	// jag::oldscape::configdecoder::NpcType::Decode
	@ObfuscatedName("em.s(Lev;II)V")
	public void decode(Packet buf, int code) {
		if (code == 1) {
			int count = buf.g1();
			this.model = new int[count];

			for (int i = 0; i < count; i++) {
				this.model[i] = buf.g2();
			}
		} else if (code == 2) {
			this.name = buf.gjstr();
		} else if (code == 12) {
			this.size = buf.g1();
		} else if (code == 13) {
			this.readyanim = buf.g2();
		} else if (code == 14) {
			this.walkanim = buf.g2();
		} else if (code == 15) {
			this.turnleftanim = buf.g2();
		} else if (code == 16) {
			this.turnrightanim = buf.g2();
		} else if (code == 17) {
			this.walkanim = buf.g2();
			this.walkanim_b = buf.g2();
			this.walkanim_r = buf.g2();
			this.walkanim_l = buf.g2();
		} else if (code >= 30 && code < 35) {
			this.op[code - 30] = buf.gjstr();
			if (this.op[code - 30].equalsIgnoreCase(Text.HIDDEN)) {
				this.op[code - 30] = null;
			}
		} else if (code == 40) {
			int count = buf.g1();
			this.recol_s = new short[count];
			this.recol_d = new short[count];

			for (int i = 0; i < count; i++) {
				this.recol_s[i] = (short) buf.g2();
				this.recol_d[i] = (short) buf.g2();
			}
		} else if (code == 41) {
			int count = buf.g1();
			this.retex_s = new short[count];
			this.retex_d = new short[count];

			for (int i = 0; i < count; i++) {
				this.retex_s[i] = (short) buf.g2();
				this.retex_d[i] = (short) buf.g2();
			}
		} else if (code == 60) {
			int count = buf.g1();
			this.head = new int[count];

			for (int i = 0; i < count; i++) {
				this.head[i] = buf.g2();
			}
		} else if (code == 93) {
			this.minimap = false;
		} else if (code == 95) {
			this.vislevel = buf.g2();
		} else if (code == 97) {
			this.resizeh = buf.g2();
		} else if (code == 98) {
			this.resizev = buf.g2();
		} else if (code == 99) {
			this.alwaysontop = true;
		} else if (code == 100) {
			this.ambient = buf.g1b();
		} else if (code == 101) {
			this.contrast = buf.g1b() * 5;
		} else if (code == 102) {
			this.headicon = buf.g2();
		} else if (code == 103) {
			this.turnspeed = buf.g2();
		} else if (code == 106) {
			this.multivarbit = buf.g2();
			if (this.multivarbit == 65535) {
				this.multivarbit = -1;
			}

			this.multivarp = buf.g2();
			if (this.multivarp == 65535) {
				this.multivarp = -1;
			}

			int count = buf.g1();
			this.multinpc = new int[count + 1];
			for (int i = 0; i <= count; i++) {
				this.multinpc[i] = buf.g2();
				if (this.multinpc[i] == 65535) {
					this.multinpc[i] = -1;
				}
			}
		} else if (code == 107) {
			this.active = false;
		} else if (code == 109) {
			this.walksmoothing = false;
		}
	}

	// jag::oldscape::configdecoder::NpcType::GetTempMode
	@ObfuscatedName("em.u(Leo;ILeo;IB)Lfo;")
	public final ModelLit getTempModel(SeqType primaryAnim, int arg1, SeqType secondaryAnim, int arg3) {
		if (this.multinpc != null) {
			NpcType npc = this.getMultiNpc();
			return npc == null ? null : npc.getTempModel(primaryAnim, arg1, secondaryAnim, arg3);
		}

		ModelLit litModel = (ModelLit) modelCache.find(this.id);
		if (litModel == null) {
			boolean needsModel = false;
			for (int i = 0; i < this.model.length; i++) {
				if (!models.requestDownload(this.model[i], 0)) {
					needsModel = true;
				}
			}

			if (needsModel) {
				return null;
			}

			ModelUnlit[] models = new ModelUnlit[this.model.length];
			for (int i = 0; i < this.model.length; i++) {
				models[i] = ModelUnlit.load(NpcType.models, this.model[i], 0);
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

			litModel = model.light(this.ambient + 64, this.contrast + 850, -30, -50, -30);
			modelCache.put(litModel, this.id);
		}

		ModelLit model;
		if (primaryAnim != null && secondaryAnim != null) {
			model = primaryAnim.splitAnimateModel(litModel, arg1, secondaryAnim, arg3);
		} else if (primaryAnim != null) {
			model = primaryAnim.animateModel(litModel, arg1);
		} else if (secondaryAnim != null) {
			model = secondaryAnim.animateModel(litModel, arg3);
		} else {
			model = litModel.copyForAnim(true);
		}

		if (this.resizeh != 128 || this.resizev != 128) {
			model.resize(this.resizeh, this.resizev, this.resizeh);
		}

		return model;
	}

	// jag::oldscape::configdecoder::NpcType::GetHead
	@ObfuscatedName("em.v(I)Lfw;")
	public final ModelUnlit getHead() {
		if (this.multinpc != null) {
			NpcType npc = this.getMultiNpc();
			return npc == null ? null : npc.getHead();
		}

		if (this.head == null) {
			return null;
		}

		boolean needsModel = false;
		for (int i = 0; i < this.head.length; i++) {
			if (!models.requestDownload(this.head[i], 0)) {
				needsModel = true;
			}
		}

		if (needsModel) {
			return null;
		}

		ModelUnlit[] models = new ModelUnlit[this.head.length];
		for (int i = 0; i < this.head.length; i++) {
			models[i] = ModelUnlit.load(NpcType.models, this.head[i], 0);
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

	// jag::oldscape::configdecoder::NpcType::GetMultiNpc
	@ObfuscatedName("em.w(B)Lem;")
	public final NpcType getMultiNpc() {
		int value = -1;
		if (this.multivarbit != -1) {
			value = VarCache.getVarbit(this.multivarbit);
		} else if (this.multivarp != -1) {
			value = VarCache.var[this.multivarp];
		}

		if (value < 0 || value >= this.multinpc.length || this.multinpc[value] == -1) {
			return null;
		}

		return list(this.multinpc[value]);
	}

	// jag::oldscape::configdecoder::NpcType::IsMultiNpcVisible
	@ObfuscatedName("em.e(I)Z")
	public boolean isMultiNpcVisible() {
		if (this.multinpc == null) {
			return true;
		}

		int value = -1;
		if (this.multivarbit != -1) {
			value = VarCache.getVarbit(this.multivarbit);
		} else if (this.multivarp != -1) {
			value = VarCache.var[this.multivarp];
		}

		return value >= 0 && value < this.multinpc.length && this.multinpc[value] != -1;
	}

	// jag::oldscape::configdecoder::NpcType::ResetCache
	@ObfuscatedName("df.b(I)V")
	public static void resetCache() {
		recentUse.clear();
		modelCache.clear();
	}
}
