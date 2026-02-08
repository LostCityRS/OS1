package jagex3.config;

import deob.ObfuscatedName;
import jagex3.constants.Text;
import jagex3.dash3d.ModelLit;
import jagex3.dash3d.ModelUnlit;
import jagex3.dash3d.Pix3D;
import jagex3.graphics.PixFontGeneric;
import jagex3.datastruct.Linkable2;
import jagex3.datastruct.LruCache;
import jagex3.graphics.Pix2D;
import jagex3.graphics.Pix32;
import jagex3.io.Packet;
import jagex3.js5.Js5;
import jagex3.js5.Js5Loader;

// jag::oldscape::configdecoder::ObjType
@ObfuscatedName("fj")
public class ObjType extends Linkable2 {

	// jag::oldscape::configdecoder::ObjType::m_pConfigClient
	@ObfuscatedName("fj.n")
	public static Js5 configClient;

	// jag::oldscape::configdecoder::ObjType::m_pModels
	@ObfuscatedName("bb.j")
	public static Js5 models;

	// jag::oldscape::configdecoder::ObjType::m_memServer
	@ObfuscatedName("cq.z")
	public static boolean memServer;

	@ObfuscatedName("fj.g")
	public static LruCache recentUse = new LruCache(64);

	@ObfuscatedName("fj.q")
	public static LruCache modelCache = new LruCache(50);

	@ObfuscatedName("fj.i")
	public static LruCache spriteCache = new LruCache(100);

	// jag::oldscape::configdecoder::ObjType::m_countFont
	@ObfuscatedName("bf.s")
	public static PixFontGeneric countFont;

	@ObfuscatedName("fj.u")
	public int index;

	@ObfuscatedName("fj.v")
	public int model;

	@ObfuscatedName("fj.w")
	public String name = "null";

	@ObfuscatedName("fj.e")
	public short[] recol_s;

	@ObfuscatedName("fj.b")
	public short[] recol_d;

	@ObfuscatedName("fj.y")
	public short[] retex_s;

	@ObfuscatedName("fj.t")
	public short[] retex_d;

	@ObfuscatedName("fj.f")
	public int zoom2d = 2000;

	@ObfuscatedName("fj.k")
	public int xan2d = 0;

	@ObfuscatedName("fj.o")
	public int yan2d = 0;

	@ObfuscatedName("fj.a")
	public int zan2d = 0;

	@ObfuscatedName("fj.h")
	public int xof2d = 0;

	@ObfuscatedName("fj.x")
	public int yof2d = 0;

	@ObfuscatedName("fj.p")
	public int stackable = 0;

	@ObfuscatedName("fj.ad")
	public int cost = 1;

	@ObfuscatedName("fj.ac")
	public boolean members = false;

	@ObfuscatedName("fj.aa")
	public String[] op = new String[] { null, null, Text.TAKE, null, null };

	@ObfuscatedName("fj.as")
	public String[] iop = new String[] { null, null, null, null, Text.DROP};

	@ObfuscatedName("fj.am")
	public int manwear = -1;

	@ObfuscatedName("fj.ap")
	public int manwear2 = -1;

	@ObfuscatedName("fj.av")
	public int manwearOffsetY = 0;

	@ObfuscatedName("fj.ak")
	public int womanwear = -1;

	@ObfuscatedName("fj.az")
	public int womanwear2 = -1;

	@ObfuscatedName("fj.an")
	public int womanwearOffsetY = 0;

	@ObfuscatedName("fj.ah")
	public int manwear3 = -1;

	@ObfuscatedName("fj.ay")
	public int womanwear3 = -1;

	@ObfuscatedName("fj.al")
	public int manhead = -1;

	@ObfuscatedName("fj.ab")
	public int manhead2 = -1;

	@ObfuscatedName("fj.ao")
	public int womanhead = -1;

	@ObfuscatedName("fj.ag")
	public int womanhead2 = -1;

	@ObfuscatedName("fj.ar")
	public int[] countobj;

	@ObfuscatedName("fj.aq")
	public int[] countco;

	@ObfuscatedName("fj.at")
	public int certlink = -1;

	@ObfuscatedName("fj.ae")
	public int certtemplate = -1;

	@ObfuscatedName("fj.au")
	public int resizex = 128;

	@ObfuscatedName("fj.ax")
	public int resizey = 128;

	@ObfuscatedName("fj.ai")
	public int resizez = 128;

	@ObfuscatedName("fj.aj")
	public int ambient = 0;

	@ObfuscatedName("fj.aw")
	public int contrast = 0;

	@ObfuscatedName("fj.af")
	public int team = 0;

	// jag::oldscape::configdecoder::ObjType::List
	@ObfuscatedName("bb.z(II)Lfj;")
	public static ObjType list(int id) {
		ObjType cached = (ObjType) recentUse.find(id);
		if (cached != null) {
			return cached;
		}

		byte[] files = configClient.getFile(10, id);
		ObjType obj = new ObjType();
		obj.index = id;
		if (files != null) {
			obj.decode(new Packet(files));
		}
		obj.postDecode();

		if (obj.certtemplate != -1) {
			obj.genCert(list(obj.certtemplate), list(obj.certlink));
		}

		if (!memServer && obj.members) {
			obj.name = Text.MEMBERS_OBJECT;
			obj.op = null;
			obj.iop = null;
			obj.team = 0;
		}

		recentUse.put(obj, id);
		return obj;
	}

	// jag::oldscape::configdecoder::ObjType::PostDecode
	@ObfuscatedName("fj.g(B)V")
	public void postDecode() {
	}

	// jag::oldscape::configdecoder::ObjType::Decode
	@ObfuscatedName("fj.q(Lev;B)V")
	public void decode(Packet buf) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}

			this.decode(buf, code);
		}
	}

	// jag::oldscape::configdecoder::ObjType::Decode
	@ObfuscatedName("fj.i(Lev;II)V")
	public void decode(Packet buf, int code) {
		if (code == 1) {
			this.model = buf.g2();
		} else if (code == 2) {
			this.name = buf.gjstr();
		} else if (code == 4) {
			this.zoom2d = buf.g2();
		} else if (code == 5) {
			this.xan2d = buf.g2();
		} else if (code == 6) {
			this.yan2d = buf.g2();
		} else if (code == 7) {
			this.xof2d = buf.g2();
			if (this.xof2d > 32767) {
				this.xof2d -= 65536;
			}
		} else if (code == 8) {
			this.yof2d = buf.g2();
			if (this.yof2d > 32767) {
				this.yof2d -= 65536;
			}
		} else if (code == 11) {
			this.stackable = 1;
		} else if (code == 12) {
			this.cost = buf.g4();
		} else if (code == 16) {
			this.members = true;
		} else if (code == 23) {
			this.manwear = buf.g2();
			this.manwearOffsetY = buf.g1();
		} else if (code == 24) {
			this.manwear2 = buf.g2();
		} else if (code == 25) {
			this.womanwear = buf.g2();
			this.womanwearOffsetY = buf.g1();
		} else if (code == 26) {
			this.womanwear2 = buf.g2();
		} else if (code >= 30 && code < 35) {
			this.op[code - 30] = buf.gjstr();
			if (this.op[code - 30].equalsIgnoreCase(Text.HIDDEN)) {
				this.op[code - 30] = null;
			}
		} else if (code >= 35 && code < 40) {
			this.iop[code - 35] = buf.gjstr();
		} else if (code == 40) {
			int var3 = buf.g1();
			this.recol_s = new short[var3];
			this.recol_d = new short[var3];
			for (int var4 = 0; var4 < var3; var4++) {
				this.recol_s[var4] = (short) buf.g2();
				this.recol_d[var4] = (short) buf.g2();
			}
		} else if (code == 41) {
			int var5 = buf.g1();
			this.retex_s = new short[var5];
			this.retex_d = new short[var5];
			for (int var6 = 0; var6 < var5; var6++) {
				this.retex_s[var6] = (short) buf.g2();
				this.retex_d[var6] = (short) buf.g2();
			}
		} else if (code == 78) {
			this.manwear3 = buf.g2();
		} else if (code == 79) {
			this.womanwear3 = buf.g2();
		} else if (code == 90) {
			this.manhead = buf.g2();
		} else if (code == 91) {
			this.womanhead = buf.g2();
		} else if (code == 92) {
			this.manhead2 = buf.g2();
		} else if (code == 93) {
			this.womanhead2 = buf.g2();
		} else if (code == 95) {
			this.zan2d = buf.g2();
		} else if (code == 97) {
			this.certlink = buf.g2();
		} else if (code == 98) {
			this.certtemplate = buf.g2();
		} else if (code >= 100 && code < 110) {
			if (this.countobj == null) {
				this.countobj = new int[10];
				this.countco = new int[10];
			}
			this.countobj[code - 100] = buf.g2();
			this.countco[code - 100] = buf.g2();
		} else if (code == 110) {
			this.resizex = buf.g2();
		} else if (code == 111) {
			this.resizey = buf.g2();
		} else if (code == 112) {
			this.resizez = buf.g2();
		} else if (code == 113) {
			this.ambient = buf.g1b();
		} else if (code == 114) {
			this.contrast = buf.g1b() * 5;
		} else if (code == 115) {
			this.team = buf.g1();
		}
	}

	// jag::oldscape::configdecoder::ObjType::GenCert
	@ObfuscatedName("fj.s(Lfj;Lfj;I)V")
	public void genCert(ObjType template, ObjType link) {
		this.model = template.model;
		this.zoom2d = template.zoom2d;
		this.xan2d = template.xan2d;
		this.yan2d = template.yan2d;
		this.zan2d = template.zan2d;
		this.xof2d = template.xof2d;
		this.yof2d = template.yof2d;
		this.recol_s = template.recol_s;
		this.recol_d = template.recol_d;
		this.retex_s = template.retex_s;
		this.retex_d = template.retex_d;

		this.name = link.name;
		this.members = link.members;
		this.cost = link.cost;

		this.stackable = 1;
	}

	// jag::oldscape::configdecoder::ObjType::GetModelUnlit
	@ObfuscatedName("fj.u(II)Lfw;")
	public final ModelUnlit getModelUnlit(int count) {
		if (this.countobj != null && count > 1) {
			int real = -1;
			for (int i = 0; i < 10; i++) {
				if (count >= this.countco[i] && this.countco[i] != 0) {
					real = this.countobj[i];
				}
			}

			if (real != -1) {
				return list(real).getModelUnlit(1);
			}
		}

		ModelUnlit model = ModelUnlit.load(models, this.model, 0);
		if (model == null) {
			return null;
		}

		if (this.resizex != 128 || this.resizey != 128 || this.resizez != 128) {
			model.resize(this.resizex, this.resizey, this.resizez);
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

	// jag::oldscape::configdecoder::ObjType::GetModelLit
	@ObfuscatedName("fj.v(IB)Lfo;")
	public final ModelLit getModelLit(int count) {
		if (this.countobj != null && count > 1) {
			int real = -1;
			for (int i = 0; i < 10; i++) {
				if (count >= this.countco[i] && this.countco[i] != 0) {
					real = this.countobj[i];
				}
			}

			if (real != -1) {
				return list(real).getModelLit(1);
			}
		}

		ModelLit cached = (ModelLit) modelCache.find(this.index);
		if (cached != null) {
			return cached;
		}

		ModelUnlit model = ModelUnlit.load(models, this.model, 0);
		if (model == null) {
			return null;
		}

		if (this.resizex != 128 || this.resizey != 128 || this.resizez != 128) {
			model.resize(this.resizex, this.resizey, this.resizez);
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

		ModelLit litModel = model.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
		litModel.useAABBMouseCheck = true;
		modelCache.put(litModel, this.index);
		return litModel;
	}

	// jag::oldscape::configdecoder::ObjType::GetStackSizeAlt
	@ObfuscatedName("fj.w(II)Lfj;")
	public ObjType getStackSizeAlt(int count) {
		if (this.countobj != null && count > 1) {
			int obj = -1;
			for (int i = 0; i < 10; i++) {
				if (count >= this.countco[i] && this.countco[i] != 0) {
					obj = this.countobj[i];
				}
			}

			if (obj != -1) {
				return list(obj);
			}
		}

		return this;
	}

	// jag::oldscape::configdecoder::ObjType::GetSprite
	@ObfuscatedName("eg.e(IIIIZI)Lfq;")
	public static Pix32 getSprite(int id, int count, int arg2, int arg3, boolean outlineRgb) {
		long key = ((long) arg3 << 40) + ((long) arg2 << 38) + ((long) count << 16) + (long) id;
		if (!outlineRgb) {
			Pix32 cached = (Pix32) spriteCache.find(key);
			if (cached != null) {
				return cached;
			}
		}

		ObjType obj = list(id);
		if (count > 1 && obj.countobj != null) {
			int real = -1;
			for (int i = 0; i < 10; i++) {
				if (count >= obj.countco[i] && obj.countco[i] != 0) {
					real = obj.countobj[i];
				}
			}

			if (real != -1) {
				obj = list(real);
			}
		}

		ModelLit model = obj.getModelLit(1);
		if (model == null) {
			return null;
		}

		Pix32 certIcon = null;
		if (obj.certtemplate != -1) {
			certIcon = getSprite(obj.certlink, 10, 1, 0, true);
			if (certIcon == null) {
				return null;
			}
		}

		int[] data = Pix2D.pixels;
		int width2d = Pix2D.width;
		int height2d = Pix2D.height;
		int[] var16 = new int[4];
		Pix2D.saveClipping(var16);

		Pix32 var17 = new Pix32(36, 32);
		Pix2D.setPixels(var17.data, 36, 32);
		Pix2D.cls();
		Pix3D.setRenderClipping();
		Pix3D.setOrigin(16, 16);
		Pix3D.lowDetail = false;

		int zoom = obj.zoom2d;
		if (outlineRgb) {
			zoom = (int) ((double) zoom * 1.5D);
		} else if (arg2 == 2) {
			zoom = (int) ((double) zoom * 1.04D);
		}

		int var19 = Pix3D.sinTable[obj.xan2d] * zoom >> 16;
		int var20 = Pix3D.cosTable[obj.xan2d] * zoom >> 16;
		model.calcBoundingCylinder();
		model.objRender(0, obj.yan2d, obj.zan2d, obj.xan2d, obj.xof2d, obj.yof2d + model.minY / 2 + var19, obj.yof2d + var20);

		if (arg2 >= 1) {
			var17.addOutline(0x000001);
		}

		if (arg2 >= 2) {
			var17.addOutline(0xffffff);
		}

		if (arg3 != 0) {
			var17.addShadow(arg3);
		}

		Pix2D.setPixels(var17.data, 36, 32);

		if (obj.certtemplate != -1) {
			certIcon.plotSprite(0, 0);
		}

		if (!outlineRgb && (obj.stackable == 1 || count != 1) && count != -1) {
			countFont.drawString(invNumber(count), 0, 9, 0xffff00, 1);
		}

		if (!outlineRgb) {
			spriteCache.put(var17, key);
		}

		Pix2D.setPixels(data, width2d, height2d);
		Pix2D.restoreClipping(var16);
		Pix3D.setRenderClipping();
		Pix3D.lowDetail = true;
		return var17;
	}

	// jag::oldscape::configdecoder::ObjType::InvNumber
	@ObfuscatedName("bb.b(II)Ljava/lang/String;")
	public static String invNumber(int cost) {
		if (cost < 100000) {
			return "<col=ffff00>" + cost + "</col>";
		} else if (cost < 10000000) {
			return "<col=ffffff>" + cost / 1000 + Text.THOUSAND_SHORT + "</col>";
		} else {
			return "<col=00ff80>" + cost / 1000000 + Text.MILLION_SHORT + "</col>";
		}
	}

	// jag::oldscape::configdecoder::ObjType::CheckWearModel
	@ObfuscatedName("fj.y(ZI)Z")
	public final boolean checkWearModel(boolean gender) {
		int wear1 = this.manwear;
		int wear2 = this.manwear2;
		int wear3 = this.manwear3;
		if (gender) {
			wear1 = this.womanwear;
			wear2 = this.womanwear2;
			wear3 = this.womanwear3;
		}

		if (wear1 == -1) {
			return true;
		}

		boolean status = true;
		if (!models.requestDownload(wear1, 0)) {
			status = false;
		} else if (wear2 != -1 && !models.requestDownload(wear2, 0)) {
			status = false;
		} else if (wear3 != -1 && !models.requestDownload(wear3, 0)) {
			status = false;
		}

		return status;
	}

	// jag::oldscape::configdecoder::ObjType::GetWearModelNoCheck
	@ObfuscatedName("fj.t(ZI)Lfw;")
	public final ModelUnlit getWearModelNoCheck(boolean gender) {
		int wear1 = this.manwear;
		int wear2 = this.manwear2;
		int wear3 = this.manwear3;
		if (gender) {
			wear1 = this.womanwear;
			wear2 = this.womanwear2;
			wear3 = this.womanwear3;
		}

		if (wear1 == -1) {
			return null;
		}

		ModelUnlit model = ModelUnlit.load(models, wear1, 0);
		if (wear2 != -1) {
			ModelUnlit model2 = ModelUnlit.load(models, wear2, 0);
			if (wear3 == -1) {
				ModelUnlit[] models = new ModelUnlit[] { model, model2 };
				model = new ModelUnlit(models, 2);
			} else {
				ModelUnlit model3 = ModelUnlit.load(models, wear3, 0);
				ModelUnlit[] models = new ModelUnlit[] { model, model2, model3 };
				model = new ModelUnlit(models, 3);
			}
		}

		if (!gender && this.manwearOffsetY != 0) {
			model.translate(0, this.manwearOffsetY, 0);
		} else if (gender && this.womanwearOffsetY != 0) {
			model.translate(0, this.womanwearOffsetY, 0);
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

	// jag::oldscape::configdecoder::ObjType::CheckHeadModel
	@ObfuscatedName("fj.f(ZB)Z")
	public final boolean checkHeadModel(boolean gender) {
		int head1 = this.manhead;
		int head2 = this.manhead2;
		if (gender) {
			head1 = this.womanhead;
			head2 = this.womanhead2;
		}
		if (head1 == -1) {
			return true;
		}

		boolean status = true;
		if (!models.requestDownload(head1, 0)) {
			status = false;
		} else if (head2 != -1 && !models.requestDownload(head2, 0)) {
			status = false;
		}
		return status;
	}

	// jag::oldscape::configdecoder::ObjType::GetHeadModelNoCheck
	@ObfuscatedName("fj.k(ZI)Lfw;")
	public final ModelUnlit getHeadModelNoCheck(boolean gender) {
		int head1 = this.manhead;
		int head2 = this.manhead2;
		if (gender) {
			head1 = this.womanhead;
			head2 = this.womanhead2;
		}

		if (head1 == -1) {
			return null;
		}

		ModelUnlit model = ModelUnlit.load(models, head1, 0);
		if (head2 != -1) {
			ModelUnlit model2 = ModelUnlit.load(models, head2, 0);
			ModelUnlit[] models = new ModelUnlit[] { model, model2 };
			model = new ModelUnlit(models, 2);
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

	// jag::oldscape::configdecoder::ObjType::ResetSpriteCache
	@ObfuscatedName("da.o(S)V")
	public static void resetSpriteCache() {
		spriteCache.clear();
	}

	// jag::oldscape::configdecoder::ObjType::Init
	public static void init(Js5Loader var32, Js5Loader var33, boolean var34, PixFontGeneric var35) {
		configClient = var32;
		models = var33;
		memServer = var34;
		configClient.getFileIdLimit(10);
		countFont = var35;
	}

	// jag::oldscape::configdecoder::ObjType::ResetCache
	public static void resetCache() {
		recentUse.clear();
		modelCache.clear();
		spriteCache.clear();
	}
}
