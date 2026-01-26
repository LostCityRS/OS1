package jagex3.config;

import deob.ObfuscatedName;
import jagex3.client.VarCache;
import jagex3.dash3d.ModelLit;
import jagex3.dash3d.ModelSource;
import jagex3.dash3d.ModelUnlit;
import jagex3.datastruct.Linkable2;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;
import jagex3.js5.Js5;
import jagex3.jstring.Text;

// jag::oldscape::configdecoder::LocType
@ObfuscatedName("ey")
public class LocType extends Linkable2 {

	// jag::oldscape::configdecoder::LocType::m_lowMem
	@ObfuscatedName("ey.n")
	public static boolean lowMem = false;

	// jag::oldscape::configdecoder::LocType::m_pConfigClient
	@ObfuscatedName("j.j")
	public static Js5 clientConfig;

	// jag::oldscape::configdecoder::LocType::m_pModels
	@ObfuscatedName("ey.z")
	public static Js5 models;

	// jag::oldscape::configdecoder::LocType::m_recentUse
	@ObfuscatedName("ey.g")
	public static LruCache recentUse = new LruCache(64);

	// jag::oldscape::configdecoder::LocType::m_mc1
	@ObfuscatedName("ey.q")
	public static LruCache mc1 = new LruCache(500);

	// jag::oldscape::configdecoder::LocType::m_mc2
	@ObfuscatedName("ey.i")
	public static LruCache mc2 = new LruCache(30);

	// jag::oldscape::configdecoder::LocType::m_mc3
	@ObfuscatedName("ey.s")
	public static LruCache mc3 = new LruCache(30);

	@ObfuscatedName("ey.u")
	public static ModelUnlit[] temp = new ModelUnlit[4];

	@ObfuscatedName("ey.v")
	public int id;

	@ObfuscatedName("ey.w")
	public int[] model;

	@ObfuscatedName("ey.e")
	public int[] shape;

	@ObfuscatedName("ey.b")
	public String name = "null";

	@ObfuscatedName("ey.y")
	public short[] recol_s;

	@ObfuscatedName("ey.t")
	public short[] recol_d;

	@ObfuscatedName("ey.f")
	public short[] retex_s;

	@ObfuscatedName("ey.k")
	public short[] retex_d;

	@ObfuscatedName("ey.o")
	public int width = 1;

	@ObfuscatedName("ey.a")
	public int length = 1;

	@ObfuscatedName("ey.h")
	public int blockwalk = 2;

	@ObfuscatedName("ey.x")
	public boolean blockrange = true;

	@ObfuscatedName("ey.p")
	public int active = -1;

	@ObfuscatedName("ey.ad")
	public int skewType = -1;

	@ObfuscatedName("ey.ac")
	public boolean sharelight = false;

	@ObfuscatedName("ey.aa")
	public boolean occlude = false;

	@ObfuscatedName("ey.as")
	public int anim = -1;

	@ObfuscatedName("ey.am")
	public int wallwidth = 16;

	@ObfuscatedName("ey.ap")
	public int ambient = 0;

	@ObfuscatedName("ey.av")
	public int contrast = 0;

	@ObfuscatedName("ey.ak")
	public String[] op = new String[5];

	@ObfuscatedName("ey.az")
	public int mapfunction = -1;

	@ObfuscatedName("ey.an")
	public int mapscene = -1;

	@ObfuscatedName("ey.ah")
	public boolean mirror = false;

	@ObfuscatedName("ey.ay")
	public boolean shadow = true;

	@ObfuscatedName("ey.al")
	public int resizex = 128;

	@ObfuscatedName("ey.ab")
	public int resizey = 128;

	@ObfuscatedName("ey.ao")
	public int resizez = 128;

	@ObfuscatedName("ey.ag")
	public int offsetx = 0;

	@ObfuscatedName("ey.ar")
	public int offsety = 0;

	@ObfuscatedName("ey.aq")
	public int offsetz = 0;

	@ObfuscatedName("ey.at")
	public int forceapproach = 0;

	@ObfuscatedName("ey.ae")
	public boolean forcedecor = false;

	@ObfuscatedName("ey.au")
	public boolean breakroutefinding = false;

	@ObfuscatedName("ey.ax")
	public int raiseobject = -1;

	@ObfuscatedName("ey.ai")
	public int[] multiloc;

	@ObfuscatedName("ey.aj")
	public int multivarbit = -1;

	@ObfuscatedName("ey.aw")
	public int multivarp = -1;

	@ObfuscatedName("ey.af")
	public int bgsound_sound = -1;

	@ObfuscatedName("ey.bh")
	public int bgsound_range = 0;

	@ObfuscatedName("ey.bi")
	public int bgsound_mindelay = 0;

	@ObfuscatedName("ey.bs")
	public int bgsound_maxdelay = 0;

	@ObfuscatedName("ey.bk")
	public int[] bgsound_random;

	// jag::oldscape::configdecoder::LocType::Init
	@ObfuscatedName("av.z(Lch;Lch;ZI)V")
	public static void init(Js5 config, Js5 model, boolean lowmem) {
		clientConfig = config;
		models = model;
		lowMem = lowmem;
	}

	// jag::oldscape::configdecoder::LocType::List
	@ObfuscatedName("fj.g(IB)Ley;")
	public static LocType list(int id) {
		LocType cached = (LocType) recentUse.find(id);
		if (cached != null) {
			return cached;
		}

		byte[] data = clientConfig.getFile(6, id);
		LocType type = new LocType();
		type.id = id;
		if (data != null) {
			type.decode(new Packet(data));
		}
		type.postDecode();

		if (type.breakroutefinding) {
			type.blockwalk = 0;
			type.blockrange = false;
		}

		recentUse.put(type, id);
		return type;
	}

	// jag::oldscape::configdecoder::LocType::PostDecode
	@ObfuscatedName("ey.q(B)V")
	public void postDecode() {
		if (this.active == -1) {
			this.active = 0;

			if (this.model != null && (this.shape == null || this.shape[0] == 10)) {
				this.active = 1;
			}

			for (int i = 0; i < 5; i++) {
				if (this.op[i] != null) {
					this.active = 1;
				}
			}
		}

		if (this.raiseobject == -1) {
			this.raiseobject = this.blockwalk == 0 ? 0 : 1;
		}
	}

	// jag::oldscape::configdecoder::LocType::Decode
	@ObfuscatedName("ey.i(Lev;I)V")
	public void decode(Packet buf) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}

			this.decode(buf, code);
		}
	}

	// jag::oldscape::configdecoder::LocType::Decode
	@ObfuscatedName("ey.s(Lev;II)V")
	public void decode(Packet buf, int code) {
		if (code == 1) {
			int count = buf.g1();
			if (count > 0) {
				if (this.model == null || lowMem) {
					this.shape = new int[count];
					this.model = new int[count];

					for (int i = 0; i < count; i++) {
						this.model[i] = buf.g2();
						this.shape[i] = buf.g1();
					}
				} else {
					buf.pos += count * 3;
				}
			}
		} else if (code == 2) {
			this.name = buf.gjstr();
		} else if (code == 5) {
			int count = buf.g1();
			if (count > 0) {
				if (this.model == null || lowMem) {
					this.shape = null;
					this.model = new int[count];

					for (int i = 0; i < count; i++) {
						this.model[i] = buf.g2();
					}
				} else {
					buf.pos += count * 2;
				}
			}
		} else if (code == 14) {
			this.width = buf.g1();
		} else if (code == 15) {
			this.length = buf.g1();
		} else if (code == 17) {
			this.blockwalk = 0;
			this.blockrange = false;
		} else if (code == 18) {
			this.blockrange = false;
		} else if (code == 19) {
			this.active = buf.g1();
		} else if (code == 21) {
			this.skewType = 0;
		} else if (code == 22) {
			this.sharelight = true;
		} else if (code == 23) {
			this.occlude = true;
		} else if (code == 24) {
			this.anim = buf.g2();
			if (this.anim == 65535) {
				this.anim = -1;
			}
		} else if (code == 27) {
			this.blockwalk = 1;
		} else if (code == 28) {
			this.wallwidth = buf.g1();
		} else if (code == 29) {
			this.ambient = buf.g1b();
		} else if (code == 39) {
			this.contrast = buf.g1b() * 25;
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
			this.mapfunction = buf.g2();
		} else if (code == 62) {
			this.mirror = true;
		} else if (code == 64) {
			this.shadow = false;
		} else if (code == 65) {
			this.resizex = buf.g2();
		} else if (code == 66) {
			this.resizey = buf.g2();
		} else if (code == 67) {
			this.resizez = buf.g2();
		} else if (code == 68) {
			this.mapscene = buf.g2();
		} else if (code == 69) {
			this.forceapproach = buf.g1();
		} else if (code == 70) {
			this.offsetx = buf.g2b();
		} else if (code == 71) {
			this.offsety = buf.g2b();
		} else if (code == 72) {
			this.offsetz = buf.g2b();
		} else if (code == 73) {
			this.forcedecor = true;
		} else if (code == 74) {
			this.breakroutefinding = true;
		} else if (code == 75) {
			this.raiseobject = buf.g1();
		} else if (code == 77) {
			this.multivarbit = buf.g2();
			if (this.multivarbit == 65535) {
				this.multivarbit = -1;
			}

			this.multivarp = buf.g2();
			if (this.multivarp == 65535) {
				this.multivarp = -1;
			}

			int count = buf.g1();
			this.multiloc = new int[count + 1];
			for (int i = 0; i <= count; i++) {
				this.multiloc[i] = buf.g2();
				if (this.multiloc[i] == 65535) {
					this.multiloc[i] = -1;
				}
			}
		} else if (code == 78) {
			this.bgsound_sound = buf.g2();
			this.bgsound_range = buf.g1();
		} else if (code == 79) {
			this.bgsound_mindelay = buf.g2();
			this.bgsound_maxdelay = buf.g2();
			this.bgsound_range = buf.g1();

			int count = buf.g1();
			this.bgsound_random = new int[count];
			for (int i = 0; i < count; i++) {
				this.bgsound_random[i] = buf.g2();
			}
		} else if (code == 81) {
			this.skewType = buf.g1() * 256;
		}
	}

	// jag::oldscape::configdecoder::LocType::CheckModel
	@ObfuscatedName("ey.u(II)Z")
	public final boolean checkModel(int arg0) {
		if (this.shape != null) {
			for (int var4 = 0; var4 < this.shape.length; var4++) {
				if (this.shape[var4] == arg0) {
					return models.requestDownload(this.model[var4] & 0xFFFF, 0);
				}
			}
			return true;
		} else if (this.model == null) {
			return true;
		} else if (arg0 == 10) {
			boolean var2 = true;
			for (int var3 = 0; var3 < this.model.length; var3++) {
				var2 &= models.requestDownload(this.model[var3] & 0xFFFF, 0);
			}
			return var2;
		} else {
			return true;
		}
	}

	// jag::oldscape::configdecoder::LocType::CheckModelAll
	@ObfuscatedName("ey.v(I)Z")
	public final boolean checkModelAll() {
		if (this.model == null) {
			return true;
		}
		boolean var1 = true;
		for (int var2 = 0; var2 < this.model.length; var2++) {
			var1 &= models.requestDownload(this.model[var2] & 0xFFFF, 0);
		}
		return var1;
	}

	// jag::oldscape::configdecoder::LocType::GetModel
	@ObfuscatedName("ey.w(II[[IIIII)Lfu;")
	public final ModelSource getModel(int arg0, int arg1, int[][] arg2, int arg3, int arg4, int arg5) {
		long var7;
		if (this.shape == null) {
			var7 = (this.id << 10) + arg1;
		} else {
			var7 = (this.id << 10) + (arg0 << 3) + arg1;
		}
		ModelSource var9 = (ModelSource) mc2.find(var7);
		if (var9 == null) {
			ModelUnlit var10 = this.buildModel(arg0, arg1);
			if (var10 == null) {
				return null;
			}
			if (this.sharelight) {
				var10.ambient = (short) (this.ambient + 64);
				var10.contrast = (short) (this.contrast + 768);
				var10.calculateNormals();
				var9 = var10;
			} else {
				var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
			}
			mc2.put(var9, var7);
		}
		if (this.sharelight) {
			var9 = ((ModelUnlit) var9).copyForShareLight();
		}
		if (this.skewType >= 0) {
			if (var9 instanceof ModelLit) {
				var9 = ((ModelLit) var9).hillSkew(arg2, arg3, arg4, arg5, true, this.skewType);
			} else if (var9 instanceof ModelUnlit) {
				var9 = ((ModelUnlit) var9).hillSkew(arg2, arg3, arg4, arg5, true, this.skewType);
			}
		}
		return var9;
	}

	// jag::oldscape::configdecoder::LocType::GetModelLit
	@ObfuscatedName("ey.e(II[[IIIII)Lfo;")
	public final ModelLit getModelLit(int arg0, int arg1, int[][] arg2, int arg3, int arg4, int arg5) {
		long var7;
		if (this.shape == null) {
			var7 = (this.id << 10) + arg1;
		} else {
			var7 = (this.id << 10) + (arg0 << 3) + arg1;
		}
		ModelLit var9 = (ModelLit) mc3.find(var7);
		if (var9 == null) {
			ModelUnlit var10 = this.buildModel(arg0, arg1);
			if (var10 == null) {
				return null;
			}
			var9 = var10.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
			mc3.put(var9, var7);
		}
		if (this.skewType >= 0) {
			var9 = var9.hillSkew(arg2, arg3, arg4, arg5, true, this.skewType);
		}
		return var9;
	}

	// jag::oldscape::configdecoder::LocType::GetTempModel
	@ObfuscatedName("ey.b(II[[IIIILeo;IB)Lfo;")
	public final ModelLit getTempModel(int arg0, int arg1, int[][] arg2, int arg3, int arg4, int arg5, SeqType arg6, int arg7) {
		long var9;
		if (this.shape == null) {
			var9 = (this.id << 10) + arg1;
		} else {
			var9 = (this.id << 10) + (arg0 << 3) + arg1;
		}
		ModelLit var11 = (ModelLit) mc3.find(var9);
		if (var11 == null) {
			ModelUnlit var12 = this.buildModel(arg0, arg1);
			if (var12 == null) {
				return null;
			}
			var11 = var12.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
			mc3.put(var11, var9);
		}
		if (arg6 == null && this.skewType == -1) {
			return var11;
		}
		ModelLit var13;
		if (arg6 == null) {
			var13 = var11.copyForAnim(true);
		} else {
			var13 = arg6.animateModel90(var11, arg7, arg1);
		}
		if (this.skewType >= 0) {
			var13 = var13.hillSkew(arg2, arg3, arg4, arg5, false, this.skewType);
		}
		return var13;
	}

	// jag::oldscape::configdecoder::LocType::BuildModel
	@ObfuscatedName("ey.y(IIB)Lfw;")
	public final ModelUnlit buildModel(int arg0, int arg1) {
		ModelUnlit var3 = null;
		if (this.shape == null) {
			if (arg0 != 10) {
				return null;
			}
			if (this.model == null) {
				return null;
			}
			boolean var4 = this.mirror;
			if (arg0 == 2 && arg1 > 3) {
				var4 = !var4;
			}
			int var5 = this.model.length;
			for (int var6 = 0; var6 < var5; var6++) {
				int var7 = this.model[var6];
				if (var4) {
					var7 += 65536;
				}
				var3 = (ModelUnlit) mc1.find((long) var7);
				if (var3 == null) {
					var3 = ModelUnlit.load(models, var7 & 0xFFFF, 0);
					if (var3 == null) {
						return null;
					}
					if (var4) {
						var3.mirror();
					}
					mc1.put(var3, (long) var7);
				}
				if (var5 > 1) {
					temp[var6] = var3;
				}
			}
			if (var5 > 1) {
				var3 = new ModelUnlit(temp, var5);
			}
		} else {
			int var8 = -1;
			for (int var9 = 0; var9 < this.shape.length; var9++) {
				if (this.shape[var9] == arg0) {
					var8 = var9;
					break;
				}
			}
			if (var8 == -1) {
				return null;
			}
			int var10 = this.model[var8];
			boolean var11 = this.mirror ^ arg1 > 3;
			if (var11) {
				var10 += 65536;
			}
			var3 = (ModelUnlit) mc1.find((long) var10);
			if (var3 == null) {
				var3 = ModelUnlit.load(models, var10 & 0xFFFF, 0);
				if (var3 == null) {
					return null;
				}
				if (var11) {
					var3.mirror();
				}
				mc1.put(var3, (long) var10);
			}
		}
		boolean var12;
		if (this.resizex == 128 && this.resizey == 128 && this.resizez == 128) {
			var12 = false;
		} else {
			var12 = true;
		}
		boolean var13;
		if (this.offsetx == 0 && this.offsety == 0 && this.offsetz == 0) {
			var13 = false;
		} else {
			var13 = true;
		}
		ModelUnlit var14 = new ModelUnlit(var3, arg1 == 0 && !var12 && !var13, this.recol_s == null, this.retex_s == null, true);
		if (arg0 == 4 && arg1 > 3) {
			var14.rotateXAxis(256);
			var14.translate(45, 0, -45);
		}
		int var15 = arg1 & 0x3;
		if (var15 == 1) {
			var14.rotate90();
		} else if (var15 == 2) {
			var14.rotate180();
		} else if (var15 == 3) {
			var14.rotate270();
		}
		if (this.recol_s != null) {
			for (int var16 = 0; var16 < this.recol_s.length; var16++) {
				var14.recolour(this.recol_s[var16], this.recol_d[var16]);
			}
		}
		if (this.retex_s != null) {
			for (int var17 = 0; var17 < this.retex_s.length; var17++) {
				var14.retexture(this.retex_s[var17], this.retex_d[var17]);
			}
		}
		if (var12) {
			var14.resize(this.resizex, this.resizey, this.resizez);
		}
		if (var13) {
			var14.translate(this.offsetx, this.offsety, this.offsetz);
		}
		return var14;
	}

	// jag::oldscape::configdecoder::LocType::GetMultiLoc(void)	000000010022BB20	P
	@ObfuscatedName("ey.t(B)Ley;")
	public final LocType getMultiLoc() {
		int var1 = -1;
		if (this.multivarbit != -1) {
			var1 = VarCache.getVarbit(this.multivarbit);
		} else if (this.multivarp != -1) {
			var1 = VarCache.var[this.multivarp];
		}
		return var1 < 0 || var1 >= this.multiloc.length || this.multiloc[var1] == -1 ? null : list(this.multiloc[var1]);
	}

	// jag::oldscape::configdecoder::LocType::ResetCache
	@ObfuscatedName("ba.f(I)V")
	public static void resetCache() {
		recentUse.clear();
		mc1.clear();
		mc2.clear();
		mc3.clear();
	}

	// jag::oldscape::configdecoder::LocType::HasBgSound
	@ObfuscatedName("ey.k(B)Z")
	public boolean hasBgSound() {
		if (this.multiloc == null) {
			return this.bgsound_sound != -1 || this.bgsound_random != null;
		}
		for (int var1 = 0; var1 < this.multiloc.length; var1++) {
			if (this.multiloc[var1] != -1) {
				LocType var2 = list(this.multiloc[var1]);
				if (var2.bgsound_sound != -1 || var2.bgsound_random != null) {
					return true;
				}
			}
		}
		return false;
	}
}
