package jagex2.config;

import deob.ObfuscatedName;
import jagex2.client.VarProvider;
import jagex2.dash3d.Entity;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.graphics.Model;
import jagex2.graphics.SoftwareModel;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;
import jagex2.jstring.Locale;

@ObfuscatedName("ey")
public class LocType extends DoublyLinkable {

	@ObfuscatedName("ey.n")
	public static boolean lowMemory = false;

	@ObfuscatedName("j.j")
	public static Js5Index configJs5;

	@ObfuscatedName("ey.z")
	public static Js5Index modelJs5;

	@ObfuscatedName("ey.g")
	public static LruCache cache = new LruCache(64);

	@ObfuscatedName("ey.q")
	public static LruCache modelCacheStatic = new LruCache(500);

	@ObfuscatedName("ey.i")
	public static LruCache field2306 = new LruCache(30);

	@ObfuscatedName("ey.s")
	public static LruCache field2307 = new LruCache(30);

	@ObfuscatedName("ey.u")
	public static Model[] temp = new Model[4];

	@ObfuscatedName("ey.v")
	public int id;

	@ObfuscatedName("ey.w")
	public int[] models;

	@ObfuscatedName("ey.e")
	public int[] shapes;

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

	@ObfuscatedName("av.z(Lch;Lch;ZI)V")
	public static void init(Js5Index arg0, Js5Index arg1, boolean arg2) {
		configJs5 = arg0;
		modelJs5 = arg1;
		lowMemory = arg2;
	}

	@ObfuscatedName("fj.g(IB)Ley;")
	public static LocType get(int arg0) {
		LocType var1 = (LocType) cache.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = configJs5.getFile(6, arg0);
		LocType var3 = new LocType();
		var3.id = arg0;
		if (var2 != null) {
			var3.decode(new Packet(var2));
		}
		var3.postDecode();
		if (var3.breakroutefinding) {
			var3.blockwalk = 0;
			var3.blockrange = false;
		}
		cache.put(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("ey.q(B)V")
	public void postDecode() {
		if (this.active == -1) {
			this.active = 0;
			if (this.models != null && (this.shapes == null || this.shapes[0] == 10)) {
				this.active = 1;
			}
			for (int var1 = 0; var1 < 5; var1++) {
				if (this.op[var1] != null) {
					this.active = 1;
				}
			}
		}
		if (this.raiseobject == -1) {
			this.raiseobject = this.blockwalk == 0 ? 0 : 1;
		}
	}

	@ObfuscatedName("ey.i(Lev;I)V")
	public void decode(Packet arg0) {
		while (true) {
			int var2 = arg0.g1();
			if (var2 == 0) {
				return;
			}
			this.decodeInner(arg0, var2);
		}
	}

	@ObfuscatedName("ey.s(Lev;II)V")
	public void decodeInner(Packet arg0, int arg1) {
		if (arg1 == 1) {
			int var3 = arg0.g1();
			if (var3 > 0) {
				if (this.models == null || lowMemory) {
					this.shapes = new int[var3];
					this.models = new int[var3];
					for (int var4 = 0; var4 < var3; var4++) {
						this.models[var4] = arg0.g2();
						this.shapes[var4] = arg0.g1();
					}
				} else {
					arg0.pos += var3 * 3;
				}
			}
		} else if (arg1 == 2) {
			this.name = arg0.gjstr();
		} else if (arg1 == 5) {
			int var5 = arg0.g1();
			if (var5 > 0) {
				if (this.models == null || lowMemory) {
					this.shapes = null;
					this.models = new int[var5];
					for (int var6 = 0; var6 < var5; var6++) {
						this.models[var6] = arg0.g2();
					}
				} else {
					arg0.pos += var5 * 2;
				}
			}
		} else if (arg1 == 14) {
			this.width = arg0.g1();
		} else if (arg1 == 15) {
			this.length = arg0.g1();
		} else if (arg1 == 17) {
			this.blockwalk = 0;
			this.blockrange = false;
		} else if (arg1 == 18) {
			this.blockrange = false;
		} else if (arg1 == 19) {
			this.active = arg0.g1();
		} else if (arg1 == 21) {
			this.skewType = 0;
		} else if (arg1 == 22) {
			this.sharelight = true;
		} else if (arg1 == 23) {
			this.occlude = true;
		} else if (arg1 == 24) {
			this.anim = arg0.g2();
			if (this.anim == 65535) {
				this.anim = -1;
			}
		} else if (arg1 == 27) {
			this.blockwalk = 1;
		} else if (arg1 == 28) {
			this.wallwidth = arg0.g1();
		} else if (arg1 == 29) {
			this.ambient = arg0.g1b();
		} else if (arg1 == 39) {
			this.contrast = arg0.g1b() * 25;
		} else if (arg1 >= 30 && arg1 < 35) {
			this.op[arg1 - 30] = arg0.gjstr();
			if (this.op[arg1 - 30].equalsIgnoreCase(Locale.hidden)) {
				this.op[arg1 - 30] = null;
			}
		} else if (arg1 == 40) {
			int var7 = arg0.g1();
			this.recol_s = new short[var7];
			this.recol_d = new short[var7];
			for (int var8 = 0; var8 < var7; var8++) {
				this.recol_s[var8] = (short) arg0.g2();
				this.recol_d[var8] = (short) arg0.g2();
			}
		} else if (arg1 == 41) {
			int var9 = arg0.g1();
			this.retex_s = new short[var9];
			this.retex_d = new short[var9];
			for (int var10 = 0; var10 < var9; var10++) {
				this.retex_s[var10] = (short) arg0.g2();
				this.retex_d[var10] = (short) arg0.g2();
			}
		} else if (arg1 == 60) {
			this.mapfunction = arg0.g2();
		} else if (arg1 == 62) {
			this.mirror = true;
		} else if (arg1 == 64) {
			this.shadow = false;
		} else if (arg1 == 65) {
			this.resizex = arg0.g2();
		} else if (arg1 == 66) {
			this.resizey = arg0.g2();
		} else if (arg1 == 67) {
			this.resizez = arg0.g2();
		} else if (arg1 == 68) {
			this.mapscene = arg0.g2();
		} else if (arg1 == 69) {
			this.forceapproach = arg0.g1();
		} else if (arg1 == 70) {
			this.offsetx = arg0.g2b();
		} else if (arg1 == 71) {
			this.offsety = arg0.g2b();
		} else if (arg1 == 72) {
			this.offsetz = arg0.g2b();
		} else if (arg1 == 73) {
			this.forcedecor = true;
		} else if (arg1 == 74) {
			this.breakroutefinding = true;
		} else if (arg1 == 75) {
			this.raiseobject = arg0.g1();
		} else if (arg1 == 77) {
			this.multivarbit = arg0.g2();
			if (this.multivarbit == 65535) {
				this.multivarbit = -1;
			}
			this.multivarp = arg0.g2();
			if (this.multivarp == 65535) {
				this.multivarp = -1;
			}
			int var11 = arg0.g1();
			this.multiloc = new int[var11 + 1];
			for (int var12 = 0; var12 <= var11; var12++) {
				this.multiloc[var12] = arg0.g2();
				if (this.multiloc[var12] == 65535) {
					this.multiloc[var12] = -1;
				}
			}
		} else if (arg1 == 78) {
			this.bgsound_sound = arg0.g2();
			this.bgsound_range = arg0.g1();
		} else if (arg1 == 79) {
			this.bgsound_mindelay = arg0.g2();
			this.bgsound_maxdelay = arg0.g2();
			this.bgsound_range = arg0.g1();
			int var13 = arg0.g1();
			this.bgsound_random = new int[var13];
			for (int var14 = 0; var14 < var13; var14++) {
				this.bgsound_random[var14] = arg0.g2();
			}
		} else if (arg1 == 81) {
			this.skewType = arg0.g1() * 256;
		}
	}

	@ObfuscatedName("ey.u(II)Z")
	public final boolean isDownloaded(int arg0) {
		if (this.shapes != null) {
			for (int var4 = 0; var4 < this.shapes.length; var4++) {
				if (this.shapes[var4] == arg0) {
					return modelJs5.download(this.models[var4] & 0xFFFF, 0);
				}
			}
			return true;
		} else if (this.models == null) {
			return true;
		} else if (arg0 == 10) {
			boolean var2 = true;
			for (int var3 = 0; var3 < this.models.length; var3++) {
				var2 &= modelJs5.download(this.models[var3] & 0xFFFF, 0);
			}
			return var2;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ey.v(I)Z")
	public final boolean isDownloaded() {
		if (this.models == null) {
			return true;
		}
		boolean var1 = true;
		for (int var2 = 0; var2 < this.models.length; var2++) {
			var1 &= modelJs5.download(this.models[var2] & 0xFFFF, 0);
		}
		return var1;
	}

	@ObfuscatedName("ey.w(II[[IIIII)Lfu;")
	public final Entity method2364(int arg0, int arg1, int[][] arg2, int arg3, int arg4, int arg5) {
		long var7;
		if (this.shapes == null) {
			var7 = (this.id << 10) + arg1;
		} else {
			var7 = (this.id << 10) + (arg0 << 3) + arg1;
		}
		Entity var9 = (Entity) field2306.get(var7);
		if (var9 == null) {
			Model var10 = this.getModel(arg0, arg1);
			if (var10 == null) {
				return null;
			}
			if (this.sharelight) {
				var10.field2708 = (short) (this.ambient + 64);
				var10.field2706 = (short) (this.contrast + 768);
				var10.method2932();
				var9 = var10;
			} else {
				var9 = var10.calculateNormals(this.ambient + 64, this.contrast + 768, -50, -10, -50);
			}
			field2306.put(var9, var7);
		}
		if (this.sharelight) {
			var9 = ((Model) var9).method2982();
		}
		if (this.skewType >= 0) {
			if (var9 instanceof SoftwareModel) {
				var9 = ((SoftwareModel) var9).method3054(arg2, arg3, arg4, arg5, true, this.skewType);
			} else if (var9 instanceof Model) {
				var9 = ((Model) var9).method2928(arg2, arg3, arg4, arg5, true, this.skewType);
			}
		}
		return var9;
	}

	@ObfuscatedName("ey.e(II[[IIIII)Lfo;")
	public final SoftwareModel method2386(int arg0, int arg1, int[][] arg2, int arg3, int arg4, int arg5) {
		long var7;
		if (this.shapes == null) {
			var7 = (this.id << 10) + arg1;
		} else {
			var7 = (this.id << 10) + (arg0 << 3) + arg1;
		}
		SoftwareModel var9 = (SoftwareModel) field2307.get(var7);
		if (var9 == null) {
			Model var10 = this.getModel(arg0, arg1);
			if (var10 == null) {
				return null;
			}
			var9 = var10.calculateNormals(this.ambient + 64, this.contrast + 768, -50, -10, -50);
			field2307.put(var9, var7);
		}
		if (this.skewType >= 0) {
			var9 = var9.method3054(arg2, arg3, arg4, arg5, true, this.skewType);
		}
		return var9;
	}

	@ObfuscatedName("ey.b(II[[IIIILeo;IB)Lfo;")
	public final SoftwareModel method2376(int arg0, int arg1, int[][] arg2, int arg3, int arg4, int arg5, SeqType arg6, int arg7) {
		long var9;
		if (this.shapes == null) {
			var9 = (this.id << 10) + arg1;
		} else {
			var9 = (this.id << 10) + (arg0 << 3) + arg1;
		}
		SoftwareModel var11 = (SoftwareModel) field2307.get(var9);
		if (var11 == null) {
			Model var12 = this.getModel(arg0, arg1);
			if (var12 == null) {
				return null;
			}
			var11 = var12.calculateNormals(this.ambient + 64, this.contrast + 768, -50, -10, -50);
			field2307.put(var11, var9);
		}
		if (arg6 == null && this.skewType == -1) {
			return var11;
		}
		SoftwareModel var13;
		if (arg6 == null) {
			var13 = var11.method2999(true);
		} else {
			var13 = arg6.method2419(var11, arg7, arg1);
		}
		if (this.skewType >= 0) {
			var13 = var13.method3054(arg2, arg3, arg4, arg5, false, this.skewType);
		}
		return var13;
	}

	@ObfuscatedName("ey.y(IIB)Lfw;")
	public final Model getModel(int arg0, int arg1) {
		Model var3 = null;
		if (this.shapes == null) {
			if (arg0 != 10) {
				return null;
			}
			if (this.models == null) {
				return null;
			}
			boolean var4 = this.mirror;
			if (arg0 == 2 && arg1 > 3) {
				var4 = !var4;
			}
			int var5 = this.models.length;
			for (int var6 = 0; var6 < var5; var6++) {
				int var7 = this.models[var6];
				if (var4) {
					var7 += 65536;
				}
				var3 = (Model) modelCacheStatic.get((long) var7);
				if (var3 == null) {
					var3 = Model.tryGet(modelJs5, var7 & 0xFFFF, 0);
					if (var3 == null) {
						return null;
					}
					if (var4) {
						var3.rotateY180();
					}
					modelCacheStatic.put(var3, (long) var7);
				}
				if (var5 > 1) {
					temp[var6] = var3;
				}
			}
			if (var5 > 1) {
				var3 = new Model(temp, var5);
			}
		} else {
			int var8 = -1;
			for (int var9 = 0; var9 < this.shapes.length; var9++) {
				if (this.shapes[var9] == arg0) {
					var8 = var9;
					break;
				}
			}
			if (var8 == -1) {
				return null;
			}
			int var10 = this.models[var8];
			boolean var11 = this.mirror ^ arg1 > 3;
			if (var11) {
				var10 += 65536;
			}
			var3 = (Model) modelCacheStatic.get((long) var10);
			if (var3 == null) {
				var3 = Model.tryGet(modelJs5, var10 & 0xFFFF, 0);
				if (var3 == null) {
					return null;
				}
				if (var11) {
					var3.rotateY180();
				}
				modelCacheStatic.put(var3, (long) var10);
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
		Model var14 = new Model(var3, arg1 == 0 && !var12 && !var13, this.recol_s == null, this.retex_s == null, true);
		if (arg0 == 4 && arg1 > 3) {
			var14.method2933(256);
			var14.translate(45, 0, -45);
		}
		int var15 = arg1 & 0x3;
		if (var15 == 1) {
			var14.method2930();
		} else if (var15 == 2) {
			var14.method2931();
		} else if (var15 == 3) {
			var14.method2923();
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
			var14.scale(this.resizex, this.resizey, this.resizez);
		}
		if (var13) {
			var14.translate(this.offsetx, this.offsety, this.offsetz);
		}
		return var14;
	}

	@ObfuscatedName("ey.t(B)Ley;")
	public final LocType getMultiLoc() {
		int var1 = -1;
		if (this.multivarbit != -1) {
			var1 = VarProvider.method1130(this.multivarbit);
		} else if (this.multivarp != -1) {
			var1 = VarProvider.field1210[this.multivarp];
		}
		return var1 < 0 || var1 >= this.multiloc.length || this.multiloc[var1] == -1 ? null : get(this.multiloc[var1]);
	}

	@ObfuscatedName("ba.f(I)V")
	public static void unload() {
		cache.clear();
		modelCacheStatic.clear();
		field2306.clear();
		field2307.clear();
	}

	@ObfuscatedName("ey.k(B)Z")
	public boolean hasSound() {
		if (this.multiloc == null) {
			return this.bgsound_sound != -1 || this.bgsound_random != null;
		}
		for (int var1 = 0; var1 < this.multiloc.length; var1++) {
			if (this.multiloc[var1] != -1) {
				LocType var2 = get(this.multiloc[var1]);
				if (var2.bgsound_sound != -1 || var2.bgsound_random != null) {
					return true;
				}
			}
		}
		return false;
	}
}
