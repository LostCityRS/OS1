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
import jagex2.jstring.EnglishLocale;

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
	public static void init(Js5Index config, Js5Index model, boolean lowMem) {
		configJs5 = config;
		modelJs5 = model;
		lowMemory = lowMem;
	}

	@ObfuscatedName("fj.g(IB)Ley;")
	public static LocType get(int id) {
		LocType cached = (LocType) cache.get(id);
		if (cached != null) {
			return cached;
		}

		byte[] data = configJs5.method1044(6, id);
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

		cache.put(type, id);
		return type;
	}

	@ObfuscatedName("ey.q(B)V")
	public void postDecode() {
		if (this.active == -1) {
			this.active = 0;

			if (this.models != null && (this.shapes == null || this.shapes[0] == 10)) {
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

	@ObfuscatedName("ey.i(Lev;I)V")
	public void decode(Packet buf) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}

			this.decodeInner(buf, code);
		}
	}

	@ObfuscatedName("ey.s(Lev;II)V")
	public void decodeInner(Packet buf, int code) {
		if (code == 1) {
			// model=name, with arbitrary shapes
			int count = buf.g1();
			if (count > 0) {
				// models can be encoded twice - the first is the standard/"high detail" models
				// the second is the low detail models
				if (this.models == null || lowMemory) {
					this.shapes = new int[count];
					this.models = new int[count];

					for (int i = 0; i < count; i++) {
						this.models[i] = buf.g2();
						this.shapes[i] = buf.g1();
					}
				} else {
					buf.pos += count * 3;
				}
			}
		} else if (code == 2) {
			// name=string
			this.name = buf.gjstr();
		} else if (code == 5) {
			// model=name, only shape 10 (centrepiece_straight)
			int count = buf.g1();
			if (count > 0) {
				// models can be encoded twice - the first is the standard/"high detail" models
				// the second is the low detail models
				if (this.models == null || lowMemory) {
					this.shapes = null;
					this.models = new int[count];

					for (int i = 0; i < count; i++) {
						this.models[i] = buf.g2();
					}
				} else {
					buf.pos += count * 2;
				}
			}
		} else if (code == 14) {
			// width=x
			this.width = buf.g1();
		} else if (code == 15) {
			// length=z
			this.length = buf.g1();
		} else if (code == 17) {
			// blockwalk=no
			this.blockwalk = 0;
			this.blockrange = false;
		} else if (code == 18) {
			// blockrange=no
			this.blockrange = false;
		} else if (code == 19) {
			// active=yes/no
			this.active = buf.g1();
		} else if (code == 21) {
			// hillskew=yes
			this.skewType = 0;
		} else if (code == 22) {
			// sharelight=yes
			this.sharelight = true;
		} else if (code == 23) {
			// occlude=yes
			this.occlude = true;
		} else if (code == 24) {
			// anim=seq
			this.anim = buf.g2();
			if (this.anim == 65535) {
				this.anim = -1;
			}
		} else if (code == 27) {
			// blockwalk=?
			this.blockwalk = 1;
		} else if (code == 28) {
			// wallwidth=number
			this.wallwidth = buf.g1();
		} else if (code == 29) {
			// ambient=number
			this.ambient = buf.g1b();
		} else if (code == 39) {
			// contrast=number
			this.contrast = buf.g1b() * 25;
		} else if (code >= 30 && code < 35) {
			// opX=string, up to 5 ops
			this.op[code - 30] = buf.gjstr();
			if (this.op[code - 30].equalsIgnoreCase(EnglishLocale.hidden)) {
				this.op[code - 30] = null;
			}
		} else if (code == 40) {
			// recolXs=number, recolXd=number
			// e.g. recol1s=0 recol1d=1234
			// replace source with dest color
			int count = buf.g1();
			this.recol_s = new short[count];
			this.recol_d = new short[count];
			for (int i = 0; i < count; i++) {
				this.recol_s[i] = (short) buf.g2();
				this.recol_d[i] = (short) buf.g2();
			}
		} else if (code == 41) {
			// retexX=number, retexX=number
			// (number taken from texture in model editor? don't think they use the file name)
			// replace source with dest texture
			int count = buf.g1();
			this.retex_s = new short[count];
			this.retex_d = new short[count];
			for (int i = 0; i < count; i++) {
				this.retex_s[i] = (short) buf.g2();
				this.retex_d[i] = (short) buf.g2();
			}
		} else if (code == 60) {
			// mapfunction=number
			// (number is the cell # in the mapfunction spritesheet)
			this.mapfunction = buf.g2();
		} else if (code == 62) {
			// mirror=yes
			this.mirror = true;
		} else if (code == 64) {
			// shadow=no
			this.shadow = false;
		} else if (code == 65) {
			// resizex=number, in client units, where 128=1 tile
			this.resizex = buf.g2();
		} else if (code == 66) {
			// resizey=number, in client units (what does this mean vertically?)
			this.resizey = buf.g2();
		} else if (code == 67) {
			// resizez=number, in client units, where 128=1 tile
			this.resizez = buf.g2();
		} else if (code == 68) {
			// mapscene=number
			// (number is the cell # in the mapscene spritesheet)
			this.mapscene = buf.g2();
		} else if (code == 69) {
			// forceapproach=north, south, east, west
			// this is a bitmask (4 bits), 0 in a position means that direction is allowed
			// when the packer sees a forceapproach line it uses 0b1111 and that direction bit is set to 0
			// north = ~0b0001
			// east = ~0b0010
			// south = ~0b0100
			// west = ~0b1000
			this.forceapproach = buf.g1();
		} else if (code == 70) {
			// offsetx=number
			this.offsetx = buf.g2b();
		} else if (code == 71) {
			// offsety=number
			this.offsety = buf.g2b();
		} else if (code == 72) {
			// offsetz=number
			this.offsetz = buf.g2b();
		} else if (code == 73) {
			// forcedecor=yes
			this.forcedecor = true;
		} else if (code == 74) {
			// breakroutefinding=yes
			this.breakroutefinding = true;
		} else if (code == 75) {
			// raiseobject=yes/no
			this.raiseobject = buf.g1();
		} else if (code == 77) {
			// multi
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
			// bgsound
			this.bgsound_sound = buf.g2();
			this.bgsound_range = buf.g1();
		} else if (code == 79) {
			// randomsound
			this.bgsound_mindelay = buf.g2();
			this.bgsound_maxdelay = buf.g2();
			this.bgsound_range = buf.g1();
			int var13 = buf.g1();
			this.bgsound_random = new int[var13];
			for (int var14 = 0; var14 < var13; var14++) {
				this.bgsound_random[var14] = buf.g2();
			}
		} else if (code == 81) {
			// treeskew=number
			this.skewType = buf.g1() * 256;
		}
	}

	@ObfuscatedName("ey.u(II)Z")
	public final boolean isPrefetched(int shape) {
		if (this.shapes != null) {
			for (int i = 0; i < this.shapes.length; i++) {
				if (this.shapes[i] == shape) {
					return modelJs5.method1046(this.models[i] & 0xFFFF, 0);
				}
			}

			return true;
		}

		if (this.models == null) {
			return true;
		}

		if (shape == 10) {
			boolean ready = true;
			for (int i = 0; i < this.models.length; i++) {
				ready &= modelJs5.method1046(this.models[i] & 0xFFFF, 0);
			}
			return ready;
		}

		return true;
	}

	@ObfuscatedName("ey.v(I)Z")
	public final boolean isPrefetched() {
		if (this.models == null) {
			return true;
		}

		boolean ready = true;
		for (int i = 0; i < this.models.length; i++) {
			ready &= modelJs5.method1046(this.models[i] & 0xFFFF, 0);
		}
		return ready;
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
				var9 = var10.method2942(this.ambient + 64, this.contrast + 768, -50, -10, -50);
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
			var9 = var10.method2942(this.ambient + 64, this.contrast + 768, -50, -10, -50);
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
			var11 = var12.method2942(this.ambient + 64, this.contrast + 768, -50, -10, -50);
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
	public final Model getModel(int shape, int rotation) {
		Model built = null;

		if (this.shapes == null) {
			if (shape != 10) {
				return null;
			}

			if (this.models == null) {
				return null;
			}

			boolean mirrored = this.mirror;
			if (shape == 2 && rotation > 3) {
				mirrored = !mirrored;
			}

			int modelCount = this.models.length;
			for (int i = 0; i < modelCount; i++) {
				int modelId = this.models[i];
				if (mirrored) {
					modelId += 65536;
				}

				built = (Model) modelCacheStatic.get(modelId);
				if (built == null) {
					built = Model.tryGet(modelJs5, modelId & 0xFFFF, 0);
					if (built == null) {
						return null;
					}

					if (mirrored) {
						built.rotateY180();
					}

					modelCacheStatic.put(built, modelId);
				}

				if (modelCount > 1) {
					temp[i] = built;
				}
			}

			if (modelCount > 1) {
				built = new Model(temp, modelCount);
			}
		} else {
			int shapeIndex = -1;
			for (int i = 0; i < this.shapes.length; i++) {
				if (this.shapes[i] == shape) {
					shapeIndex = i;
					break;
				}
			}

			if (shapeIndex == -1) {
				return null;
			}

			int modelId = this.models[shapeIndex];
			boolean mirrored = this.mirror ^ rotation > 3;
			if (mirrored) {
				modelId += 65536;
			}

			built = (Model) modelCacheStatic.get(modelId);
			if (built == null) {
				built = Model.tryGet(modelJs5, modelId & 0xFFFF, 0);
				if (built == null) {
					return null;
				}

				if (mirrored) {
					built.rotateY180();
				}

				modelCacheStatic.put(built, modelId);
			}
		}

		boolean scale;
		if (this.resizex == 128 && this.resizey == 128 && this.resizez == 128) {
			scale = false;
		} else {
			scale = true;
		}

		boolean translate;
		if (this.offsetx == 0 && this.offsety == 0 && this.offsetz == 0) {
			translate = false;
		} else {
			translate = true;
		}

		Model model = new Model(built, rotation == 0 && !scale && !translate, this.recol_s == null, this.retex_s == null, true);
		if (shape == 4 && rotation > 3) {
			model.method2933(256);
			model.translate(45, 0, -45);
		}

		int var15 = rotation & 0x3;
		if (var15 == 1) {
			model.method2930();
		} else if (var15 == 2) {
			model.method2931();
		} else if (var15 == 3) {
			model.method2923();
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

		if (scale) {
			model.scale(this.resizex, this.resizey, this.resizez);
		}

		if (translate) {
			model.translate(this.offsetx, this.offsety, this.offsetz);
		}

		return model;
	}

	@ObfuscatedName("ey.t(B)Ley;")
	public final LocType getMultiLoc() {
		int state = -1;
		if (this.multivarbit != -1) {
			state = VarProvider.method1130(this.multivarbit);
		} else if (this.multivarp != -1) {
			state = VarProvider.field1210[this.multivarp];
		}

		return state < 0 || state >= this.multiloc.length || this.multiloc[state] == -1 ? null : get(this.multiloc[state]);
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

		for (int i = 0; i < this.multiloc.length; i++) {
			if (this.multiloc[i] != -1) {
				LocType type = get(this.multiloc[i]);
				if (type.bgsound_sound != -1 || type.bgsound_random != null) {
					return true;
				}
			}
		}

		return false;
	}
}
