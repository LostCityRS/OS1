package jagex3.config;

import deob.ObfuscatedName;
import jagex3.dash3d.ModelUnlit;
import jagex3.datastruct.DoublyLinkable;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;
import jagex3.js5.Js5;

@ObfuscatedName("fd")
public class IdkType extends DoublyLinkable {

	@ObfuscatedName("fd.n")
	public static Js5 configJs5;

	@ObfuscatedName("fd.j")
	public static Js5 modelJs5;

	@ObfuscatedName("dl.z")
	public static int count;

	@ObfuscatedName("fd.g")
	public static LruCache cache = new LruCache(64);

	@ObfuscatedName("fd.q")
	public int type = -1;

	@ObfuscatedName("fd.i")
	public int[] models;

	@ObfuscatedName("fd.s")
	public short[] recol_s;

	@ObfuscatedName("fd.u")
	public short[] recol_d;

	@ObfuscatedName("fd.v")
	public short[] retex_s;

	@ObfuscatedName("fd.w")
	public short[] retex_d;

	@ObfuscatedName("fd.e")
	public int[] heads = new int[] { -1, -1, -1, -1, -1 };

	@ObfuscatedName("fd.b")
	public boolean disable = false;

	@ObfuscatedName("ct.z(Lch;Lch;I)V")
	public static void unpack(Js5 config, Js5 model) {
		configJs5 = config;
		modelJs5 = model;

		count = configJs5.getFileIdLimit(3);
	}

	@ObfuscatedName("p.g(II)Lfd;")
	public static IdkType get(int arg0) {
		IdkType cached = (IdkType) cache.get(arg0);
		if (cached != null) {
			return cached;
		}

		byte[] data = configJs5.getFile(3, arg0);
		IdkType type = new IdkType();
		if (data != null) {
			type.decode(new Packet(data));
		}

		cache.put(type, arg0);
		return type;
	}

	@ObfuscatedName("fd.q(Lev;I)V")
	public void decode(Packet buf) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}

			this.decodeInner(buf, code);
		}
	}

	@ObfuscatedName("fd.i(Lev;II)V")
	public void decodeInner(Packet buf, int code) {
		if (code == 1) {
			this.type = buf.g1();
		} else if (code == 2) {
			int count = buf.g1();

			this.models = new int[count];

			for (int i = 0; i < count; i++) {
				this.models[i] = buf.g2();
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
			this.heads[code - 60] = buf.g2();
		}
	}

	@ObfuscatedName("fd.s(I)Z")
	public boolean checkModel() {
		if (this.models == null) {
			return true;
		}

		boolean status = true;
		for (int i = 0; i < this.models.length; i++) {
			if (!modelJs5.requestDownload(this.models[i], 0)) {
				status = false;
			}
		}

		return status;
	}

	@ObfuscatedName("fd.u(S)Lfw;")
	public ModelUnlit getModel() {
		if (this.models == null) {
			return null;
		}

		ModelUnlit[] models = new ModelUnlit[this.models.length];
		for (int i = 0; i < this.models.length; i++) {
			models[i] = ModelUnlit.tryGet(modelJs5, this.models[i], 0);
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

	@ObfuscatedName("fd.v(B)Z")
	public boolean checkHead() {
		boolean status = true;
		for (int i = 0; i < 5; i++) {
			if (this.heads[i] != -1 && !modelJs5.requestDownload(this.heads[i], 0)) {
				status = false;
			}
		}
		return status;
	}

	@ObfuscatedName("fd.w(B)Lfw;")
	public ModelUnlit getHeadModel() {
		ModelUnlit[] models = new ModelUnlit[5];
		int modelCount = 0;
		for (int i = 0; i < 5; i++) {
			if (this.heads[i] != -1) {
				models[modelCount++] = ModelUnlit.tryGet(modelJs5, this.heads[i], 0);
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

	public static void unload() {
		cache.clear();
	}
}
