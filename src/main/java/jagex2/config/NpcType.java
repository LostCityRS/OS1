package jagex2.config;

import deob.ObfuscatedName;
import jagex2.client.VarProvider;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.dash3d.ModelLit;
import jagex2.dash3d.ModelUnlit;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;
import jagex2.jstring.Locale;

@ObfuscatedName("em")
public class NpcType extends DoublyLinkable {

	@ObfuscatedName("em.n")
	public static Js5Index configJs5;

	@ObfuscatedName("dy.j")
	public static Js5Index modelJs5;

	@ObfuscatedName("em.z")
	public static LruCache configCache = new LruCache(64);

	@ObfuscatedName("em.g")
	public static LruCache modelCache = new LruCache(50);

	@ObfuscatedName("em.q")
	public int index;

	@ObfuscatedName("em.i")
	public String name = "null";

	@ObfuscatedName("em.s")
	public int size = 1;

	@ObfuscatedName("em.u")
	public int[] models;

	@ObfuscatedName("em.v")
	public int[] heads;

	@ObfuscatedName("em.w")
	public int readyanim = -1;

	@ObfuscatedName("em.e")
	public int field2287 = -1;

	@ObfuscatedName("em.b")
	public int field2278 = -1;

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

	@ObfuscatedName("by.z(Lch;Lch;B)V")
	public static void init(Js5Index config, Js5Index model) {
		configJs5 = config;
		modelJs5 = model;
	}

	@ObfuscatedName("f.g(IB)Lem;")
	public static NpcType get(int id) {
		NpcType cached = (NpcType) configCache.get(id);
		if (cached != null) {
			return cached;
		}

		byte[] buf = configJs5.getFile(9, id);
		NpcType npc = new NpcType();
		npc.index = id;
		if (buf != null) {
			npc.decode(new Packet(buf));
		}
		npc.postDecode();

		configCache.put(npc, id);
		return npc;
	}

	@ObfuscatedName("em.q(I)V")
	public void postDecode() {
	}

	@ObfuscatedName("em.i(Lev;I)V")
	public void decode(Packet buf) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}

			this.decodeInner(buf, code);
		}
	}

	@ObfuscatedName("em.s(Lev;II)V")
	public void decodeInner(Packet buf, int code) {
		if (code == 1) {
			int count = buf.g1();
			this.models = new int[count];

			for (int i = 0; i < count; i++) {
				this.models[i] = buf.g2();
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
			this.field2287 = buf.g2();
		} else if (code == 16) {
			this.field2278 = buf.g2();
		} else if (code == 17) {
			this.walkanim = buf.g2();
			this.walkanim_b = buf.g2();
			this.walkanim_r = buf.g2();
			this.walkanim_l = buf.g2();
		} else if (code >= 30 && code < 35) {
			this.op[code - 30] = buf.gjstr();
			if (this.op[code - 30].equalsIgnoreCase(Locale.hidden)) {
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
			this.heads = new int[count];

			for (int i = 0; i < count; i++) {
				this.heads[i] = buf.g2();
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

	@ObfuscatedName("em.u(Leo;ILeo;IB)Lfo;")
	public final ModelUnlit getModel(SeqType primaryAnim, int arg1, SeqType secondaryAnim, int arg3) {
		if (this.multinpc != null) {
			NpcType npc = this.getMultiNpc();
			return npc == null ? null : npc.getModel(primaryAnim, arg1, secondaryAnim, arg3);
		}

		ModelUnlit cached = (ModelUnlit) modelCache.get(this.index);
		if (cached == null) {
			boolean needsModel = false;
			for (int i = 0; i < this.models.length; i++) {
				if (!modelJs5.download(this.models[i], 0)) {
					needsModel = true;
				}
			}

			if (needsModel) {
				return null;
			}

			ModelLit[] models = new ModelLit[this.models.length];
			for (int i = 0; i < this.models.length; i++) {
				models[i] = ModelLit.tryGet(modelJs5, this.models[i], 0);
			}

			ModelLit model;
			if (models.length == 1) {
				model = models[0];
			} else {
				model = new ModelLit(models, models.length);
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

			cached = model.calculateNormals(this.ambient + 64, this.contrast + 850, -30, -50, -30);
			modelCache.put(cached, this.index);
		}

		ModelUnlit model;
		if (primaryAnim != null && secondaryAnim != null) {
			model = primaryAnim.method2421(cached, arg1, secondaryAnim, arg3);
		} else if (primaryAnim != null) {
			model = primaryAnim.method2436(cached, arg1);
		} else if (secondaryAnim == null) {
			model = cached.method2999(true);
		} else {
			model = secondaryAnim.method2436(cached, arg3);
		}

		if (this.resizeh != 128 || this.resizev != 128) {
			model.scale(this.resizeh, this.resizev, this.resizeh);
		}

		return model;
	}

	@ObfuscatedName("em.v(I)Lfw;")
	public final ModelLit getHeadModel() {
		if (this.multinpc != null) {
			NpcType npc = this.getMultiNpc();
			return npc == null ? null : npc.getHeadModel();
		}

		if (this.heads == null) {
			return null;
		}

		boolean needsModel = false;
		for (int i = 0; i < this.heads.length; i++) {
			if (!modelJs5.download(this.heads[i], 0)) {
				needsModel = true;
			}
		}

		if (needsModel) {
			return null;
		}

		ModelLit[] models = new ModelLit[this.heads.length];
		for (int i = 0; i < this.heads.length; i++) {
			models[i] = ModelLit.tryGet(modelJs5, this.heads[i], 0);
		}

		ModelLit model;
		if (models.length == 1) {
			model = models[0];
		} else {
			model = new ModelLit(models, models.length);
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

	@ObfuscatedName("em.w(B)Lem;")
	public final NpcType getMultiNpc() {
		int value = -1;
		if (this.multivarbit != -1) {
			value = VarProvider.getVarbit(this.multivarbit);
		} else if (this.multivarp != -1) {
			value = VarProvider.varps[this.multivarp];
		}

		if (value < 0 || value >= this.multinpc.length || this.multinpc[value] == -1) {
			return null;
		}

		return get(this.multinpc[value]);
	}

	@ObfuscatedName("em.e(I)Z")
	public boolean isNotMulti() {
		if (this.multinpc == null) {
			return true;
		}

		int value = -1;
		if (this.multivarbit != -1) {
			value = VarProvider.getVarbit(this.multivarbit);
		} else if (this.multivarp != -1) {
			value = VarProvider.varps[this.multivarp];
		}

		return value >= 0 && value < this.multinpc.length && this.multinpc[value] != -1;
	}

	@ObfuscatedName("df.b(I)V")
	public static void unload() {
		configCache.clear();
		modelCache.clear();
	}
}
