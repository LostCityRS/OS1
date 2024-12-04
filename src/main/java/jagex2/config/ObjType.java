package jagex2.config;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.graphics.*;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;
import jagex2.jstring.EnglishLocale;

@ObfuscatedName("fj")
public class ObjType extends DoublyLinkable {

	@ObfuscatedName("fj.n")
	public static Js5Index configJs5;

	@ObfuscatedName("bb.j")
	public static Js5Index modelJs5;

	@ObfuscatedName("cq.z")
	public static boolean field1462;

	@ObfuscatedName("fj.g")
	public static LruCache field2432 = new LruCache(64);

	@ObfuscatedName("fj.q")
	public static LruCache field2433 = new LruCache(50);

	@ObfuscatedName("fj.i")
	public static LruCache field2434 = new LruCache(100);

	@ObfuscatedName("bf.s")
	public static SoftwareFont field815;

	@ObfuscatedName("fj.u")
	public int field2435;

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
	public String[] op = new String[] { null, null, EnglishLocale.field867, null, null };

	@ObfuscatedName("fj.as")
	public String[] iop = new String[] { null, null, null, null, EnglishLocale.field868 };

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

	@ObfuscatedName("bb.z(II)Lfj;")
	public static ObjType get(int arg0) {
		ObjType var1 = (ObjType) field2432.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = configJs5.getFile(10, arg0);
		ObjType var3 = new ObjType();
		var3.field2435 = arg0;
		if (var2 != null) {
			var3.decode(new Packet(var2));
		}
		var3.postDecode();
		if (var3.certtemplate != -1) {
			var3.method2520(get(var3.certtemplate), get(var3.certlink));
		}
		if (!field1462 && var3.members) {
			var3.name = EnglishLocale.field1077;
			var3.op = null;
			var3.iop = null;
			var3.team = 0;
		}
		field2432.put(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("fj.g(B)V")
	public void postDecode() {
	}

	@ObfuscatedName("fj.q(Lev;B)V")
	public void decode(Packet buf) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}
			this.decodeInner(buf, code);
		}
	}

	@ObfuscatedName("fj.i(Lev;II)V")
	public void decodeInner(Packet buf, int code) {
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
			if (this.op[code - 30].equalsIgnoreCase(EnglishLocale.hidden)) {
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

	@ObfuscatedName("fj.s(Lfj;Lfj;I)V")
	public void method2520(ObjType arg0, ObjType arg1) {
		this.model = arg0.model;
		this.zoom2d = arg0.zoom2d;
		this.xan2d = arg0.xan2d;
		this.yan2d = arg0.yan2d;
		this.zan2d = arg0.zan2d;
		this.xof2d = arg0.xof2d;
		this.yof2d = arg0.yof2d;
		this.recol_s = arg0.recol_s;
		this.recol_d = arg0.recol_d;
		this.retex_s = arg0.retex_s;
		this.retex_d = arg0.retex_d;
		this.name = arg1.name;
		this.members = arg1.members;
		this.cost = arg1.cost;
		this.stackable = 1;
	}

	@ObfuscatedName("fj.u(II)Lfw;")
	public final Model method2521(int arg0) {
		if (this.countobj != null && arg0 > 1) {
			int var2 = -1;
			for (int var3 = 0; var3 < 10; var3++) {
				if (arg0 >= this.countco[var3] && this.countco[var3] != 0) {
					var2 = this.countobj[var3];
				}
			}
			if (var2 != -1) {
				return get(var2).method2521(1);
			}
		}
		Model var4 = Model.tryGet(modelJs5, this.model, 0);
		if (var4 == null) {
			return null;
		}
		if (this.resizex != 128 || this.resizey != 128 || this.resizez != 128) {
			var4.scale(this.resizex, this.resizey, this.resizez);
		}
		if (this.recol_s != null) {
			for (int var5 = 0; var5 < this.recol_s.length; var5++) {
				var4.recolour(this.recol_s[var5], this.recol_d[var5]);
			}
		}
		if (this.retex_s != null) {
			for (int var6 = 0; var6 < this.retex_s.length; var6++) {
				var4.retexture(this.retex_s[var6], this.retex_d[var6]);
			}
		}
		return var4;
	}

	@ObfuscatedName("fj.v(IB)Lfo;")
	public final SoftwareModel method2532(int arg0) {
		if (this.countobj != null && arg0 > 1) {
			int var2 = -1;
			for (int var3 = 0; var3 < 10; var3++) {
				if (arg0 >= this.countco[var3] && this.countco[var3] != 0) {
					var2 = this.countobj[var3];
				}
			}
			if (var2 != -1) {
				return get(var2).method2532(1);
			}
		}
		SoftwareModel var4 = (SoftwareModel) field2433.get((long) this.field2435);
		if (var4 != null) {
			return var4;
		}
		Model var5 = Model.tryGet(modelJs5, this.model, 0);
		if (var5 == null) {
			return null;
		}
		if (this.resizex != 128 || this.resizey != 128 || this.resizez != 128) {
			var5.scale(this.resizex, this.resizey, this.resizez);
		}
		if (this.recol_s != null) {
			for (int var6 = 0; var6 < this.recol_s.length; var6++) {
				var5.recolour(this.recol_s[var6], this.recol_d[var6]);
			}
		}
		if (this.retex_s != null) {
			for (int var7 = 0; var7 < this.retex_s.length; var7++) {
				var5.retexture(this.retex_s[var7], this.retex_d[var7]);
			}
		}
		SoftwareModel var8 = var5.method2942(this.ambient + 64, this.contrast + 768, -50, -10, -50);
		var8.field2744 = true;
		field2433.put(var8, (long) this.field2435);
		return var8;
	}

	@ObfuscatedName("fj.w(II)Lfj;")
	public ObjType method2523(int arg0) {
		if (this.countobj != null && arg0 > 1) {
			int var2 = -1;
			for (int var3 = 0; var3 < 10; var3++) {
				if (arg0 >= this.countco[var3] && this.countco[var3] != 0) {
					var2 = this.countobj[var3];
				}
			}
			if (var2 != -1) {
				return get(var2);
			}
		}
		return this;
	}

	@ObfuscatedName("eg.e(IIIIZI)Lfq;")
	public static final Pix32 method1837(int arg0, int arg1, int arg2, int arg3, boolean arg4) {
		long var5 = ((long) arg3 << 40) + ((long) arg2 << 38) + ((long) arg1 << 16) + (long) arg0;
		if (!arg4) {
			Pix32 var7 = (Pix32) field2434.get(var5);
			if (var7 != null) {
				return var7;
			}
		}
		ObjType var8 = get(arg0);
		if (arg1 > 1 && var8.countobj != null) {
			int var9 = -1;
			for (int var10 = 0; var10 < 10; var10++) {
				if (arg1 >= var8.countco[var10] && var8.countco[var10] != 0) {
					var9 = var8.countobj[var10];
				}
			}
			if (var9 != -1) {
				var8 = get(var9);
			}
		}
		SoftwareModel var11 = var8.method2532(1);
		if (var11 == null) {
			return null;
		}
		Pix32 var12 = null;
		if (var8.certtemplate != -1) {
			var12 = method1837(var8.certlink, 10, 1, 0, true);
			if (var12 == null) {
				return null;
			}
		}
		int[] var13 = Pix2D.data;
		int var14 = Pix2D.width2d;
		int var15 = Pix2D.height2d;
		int[] var16 = new int[4];
		Pix2D.method2587(var16);
		Pix32 var17 = new Pix32(36, 32);
		Pix2D.method2583(var17.field2506, 36, 32);
		Pix2D.method2589();
		Pix3D.method2808();
		Pix3D.method2784(16, 16);
		Pix3D.field2522 = false;
		int var18 = var8.zoom2d;
		if (arg4) {
			var18 = (int) ((double) var18 * 1.5D);
		} else if (arg2 == 2) {
			var18 = (int) ((double) var18 * 1.04D);
		}
		int var19 = Pix3D.sinTable[var8.xan2d] * var18 >> 16;
		int var20 = Pix3D.cosTable[var8.xan2d] * var18 >> 16;
		var11.method3002();
		var11.method3014(0, var8.yan2d, var8.zan2d, var8.xan2d, var8.xof2d, var8.yof2d + var11.field2487 / 2 + var19, var8.yof2d + var20);
		if (arg2 >= 1) {
			var17.method2714(1);
		}
		if (arg2 >= 2) {
			var17.method2714(16777215);
		}
		if (arg3 != 0) {
			var17.method2669(arg3);
		}
		Pix2D.method2583(var17.field2506, 36, 32);
		if (var8.certtemplate != -1) {
			var12.method2671(0, 0);
		}
		if (!arg4 && (var8.stackable == 1 || arg1 != 1) && arg1 != -1) {
			field815.method2821(method926(arg1), 0, 9, 16776960, 1);
		}
		if (!arg4) {
			field2434.put(var17, var5);
		}
		Pix2D.method2583(var13, var14, var15);
		Pix2D.method2612(var16);
		Pix3D.method2808();
		Pix3D.field2522 = true;
		return var17;
	}

	@ObfuscatedName("bb.b(II)Ljava/lang/String;")
	public static final String method926(int arg0) {
		if (arg0 < 100000) {
			return "<col=ffff00>" + arg0 + "</col>";
		} else if (arg0 < 10000000) {
			return "<col=ffffff>" + arg0 / 1000 + EnglishLocale.field1019 + "</col>";
		} else {
			return "<col=00ff80>" + arg0 / 1000000 + EnglishLocale.field942 + "</col>";
		}
	}

	@ObfuscatedName("fj.y(ZI)Z")
	public final boolean method2547(boolean arg0) {
		int var2 = this.manwear;
		int var3 = this.manwear2;
		int var4 = this.manwear3;
		if (arg0) {
			var2 = this.womanwear;
			var3 = this.womanwear2;
			var4 = this.womanwear3;
		}
		if (var2 == -1) {
			return true;
		}
		boolean var5 = true;
		if (!modelJs5.requestDownload(var2, 0)) {
			var5 = false;
		}
		if (var3 != -1 && !modelJs5.requestDownload(var3, 0)) {
			var5 = false;
		}
		if (var4 != -1 && !modelJs5.requestDownload(var4, 0)) {
			var5 = false;
		}
		return var5;
	}

	@ObfuscatedName("fj.t(ZI)Lfw;")
	public final Model method2525(boolean arg0) {
		int var2 = this.manwear;
		int var3 = this.manwear2;
		int var4 = this.manwear3;
		if (arg0) {
			var2 = this.womanwear;
			var3 = this.womanwear2;
			var4 = this.womanwear3;
		}
		if (var2 == -1) {
			return null;
		}
		Model var5 = Model.tryGet(modelJs5, var2, 0);
		if (var3 != -1) {
			Model var6 = Model.tryGet(modelJs5, var3, 0);
			if (var4 == -1) {
				Model[] var9 = new Model[] { var5, var6 };
				var5 = new Model(var9, 2);
			} else {
				Model var7 = Model.tryGet(modelJs5, var4, 0);
				Model[] var8 = new Model[] { var5, var6, var7 };
				var5 = new Model(var8, 3);
			}
		}
		if (!arg0 && this.manwearOffsetY != 0) {
			var5.translate(0, this.manwearOffsetY, 0);
		}
		if (arg0 && this.womanwearOffsetY != 0) {
			var5.translate(0, this.womanwearOffsetY, 0);
		}
		if (this.recol_s != null) {
			for (int var10 = 0; var10 < this.recol_s.length; var10++) {
				var5.recolour(this.recol_s[var10], this.recol_d[var10]);
			}
		}
		if (this.retex_s != null) {
			for (int var11 = 0; var11 < this.retex_s.length; var11++) {
				var5.retexture(this.retex_s[var11], this.retex_d[var11]);
			}
		}
		return var5;
	}

	@ObfuscatedName("fj.f(ZB)Z")
	public final boolean method2554(boolean arg0) {
		int var2 = this.manhead;
		int var3 = this.manhead2;
		if (arg0) {
			var2 = this.womanhead;
			var3 = this.womanhead2;
		}
		if (var2 == -1) {
			return true;
		}
		boolean var4 = true;
		if (!modelJs5.requestDownload(var2, 0)) {
			var4 = false;
		}
		if (var3 != -1 && !modelJs5.requestDownload(var3, 0)) {
			var4 = false;
		}
		return var4;
	}

	@ObfuscatedName("fj.k(ZI)Lfw;")
	public final Model method2527(boolean arg0) {
		int var2 = this.manhead;
		int var3 = this.manhead2;
		if (arg0) {
			var2 = this.womanhead;
			var3 = this.womanhead2;
		}
		if (var2 == -1) {
			return null;
		}
		Model var4 = Model.tryGet(modelJs5, var2, 0);
		if (var3 != -1) {
			Model var5 = Model.tryGet(modelJs5, var3, 0);
			Model[] var6 = new Model[] { var4, var5 };
			var4 = new Model(var6, 2);
		}
		if (this.recol_s != null) {
			for (int var7 = 0; var7 < this.recol_s.length; var7++) {
				var4.recolour(this.recol_s[var7], this.recol_d[var7]);
			}
		}
		if (this.retex_s != null) {
			for (int var8 = 0; var8 < this.retex_s.length; var8++) {
				var4.retexture(this.retex_s[var8], this.retex_d[var8]);
			}
		}
		return var4;
	}

	@ObfuscatedName("da.o(S)V")
	public static void method1352() {
		field2434.clear();
	}
}
