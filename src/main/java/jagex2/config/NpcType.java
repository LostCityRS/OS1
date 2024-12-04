package jagex2.config;

import deob.ObfuscatedName;
import jagex2.client.VarProvider;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.graphics.Model;
import jagex2.graphics.SoftwareModel;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;
import jagex2.jstring.EnglishLocale;

@ObfuscatedName("em")
public class NpcType extends DoublyLinkable {

	@ObfuscatedName("em.n")
	public static Js5Index field2281;

	@ObfuscatedName("dy.j")
	public static Js5Index field1600;

	@ObfuscatedName("em.z")
	public static LruCache field2274 = new LruCache(64);

	@ObfuscatedName("em.g")
	public static LruCache field2288 = new LruCache(50);

	@ObfuscatedName("em.q")
	public int field2271;

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
	public boolean walksmoothing = true; // todo: real name

	@ObfuscatedName("by.z(Lch;Lch;B)V")
	public static void init(Js5Index arg0, Js5Index arg1) {
		field2281 = arg0;
		field1600 = arg1;
	}

	@ObfuscatedName("f.g(IB)Lem;")
	public static NpcType get(int arg0) {
		NpcType var1 = (NpcType) field2274.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = field2281.getFile(9, arg0);
		NpcType var3 = new NpcType();
		var3.field2271 = arg0;
		if (var2 != null) {
			var3.decode(new Packet(var2));
		}
		var3.postDecode();
		field2274.put(var3, (long) arg0);
		return var3;
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
			int var3 = buf.g1();
			this.models = new int[var3];
			for (int var4 = 0; var4 < var3; var4++) {
				this.models[var4] = buf.g2();
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
			if (this.op[code - 30].equalsIgnoreCase(EnglishLocale.hidden)) {
				this.op[code - 30] = null;
			}
		} else if (code == 40) {
			int var5 = buf.g1();
			this.recol_s = new short[var5];
			this.recol_d = new short[var5];
			for (int var6 = 0; var6 < var5; var6++) {
				this.recol_s[var6] = (short) buf.g2();
				this.recol_d[var6] = (short) buf.g2();
			}
		} else if (code == 41) {
			int var7 = buf.g1();
			this.retex_s = new short[var7];
			this.retex_d = new short[var7];
			for (int var8 = 0; var8 < var7; var8++) {
				this.retex_s[var8] = (short) buf.g2();
				this.retex_d[var8] = (short) buf.g2();
			}
		} else if (code == 60) {
			int var9 = buf.g1();
			this.heads = new int[var9];
			for (int var10 = 0; var10 < var9; var10++) {
				this.heads[var10] = buf.g2();
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
			int var11 = buf.g1();
			this.multinpc = new int[var11 + 1];
			for (int var12 = 0; var12 <= var11; var12++) {
				this.multinpc[var12] = buf.g2();
				if (this.multinpc[var12] == 65535) {
					this.multinpc[var12] = -1;
				}
			}
		} else if (code == 107) {
			this.active = false;
		} else if (code == 109) {
			this.walksmoothing = false;
		}
	}

	@ObfuscatedName("em.u(Leo;ILeo;IB)Lfo;")
	public final SoftwareModel method2330(SeqType arg0, int arg1, SeqType arg2, int arg3) {
		if (this.multinpc != null) {
			NpcType var5 = this.method2332();
			return var5 == null ? null : var5.method2330(arg0, arg1, arg2, arg3);
		}
		SoftwareModel var6 = (SoftwareModel) field2288.get((long) this.field2271);
		if (var6 == null) {
			boolean var7 = false;
			for (int var8 = 0; var8 < this.models.length; var8++) {
				if (!field1600.requestDownload(this.models[var8], 0)) {
					var7 = true;
				}
			}
			if (var7) {
				return null;
			}
			Model[] var9 = new Model[this.models.length];
			for (int var10 = 0; var10 < this.models.length; var10++) {
				var9[var10] = Model.tryGet(field1600, this.models[var10], 0);
			}
			Model var11;
			if (var9.length == 1) {
				var11 = var9[0];
			} else {
				var11 = new Model(var9, var9.length);
			}
			if (this.recol_s != null) {
				for (int var12 = 0; var12 < this.recol_s.length; var12++) {
					var11.recolour(this.recol_s[var12], this.recol_d[var12]);
				}
			}
			if (this.retex_s != null) {
				for (int var13 = 0; var13 < this.retex_s.length; var13++) {
					var11.retexture(this.retex_s[var13], this.retex_d[var13]);
				}
			}
			var6 = var11.method2942(this.ambient + 64, this.contrast + 850, -30, -50, -30);
			field2288.put(var6, (long) this.field2271);
		}
		SoftwareModel var14;
		if (arg0 != null && arg2 != null) {
			var14 = arg0.method2421(var6, arg1, arg2, arg3);
		} else if (arg0 != null) {
			var14 = arg0.method2436(var6, arg1);
		} else if (arg2 == null) {
			var14 = var6.method2999(true);
		} else {
			var14 = arg2.method2436(var6, arg3);
		}
		if (this.resizeh != 128 || this.resizev != 128) {
			var14.method3013(this.resizeh, this.resizev, this.resizeh);
		}
		return var14;
	}

	@ObfuscatedName("em.v(I)Lfw;")
	public final Model method2331() {
		if (this.multinpc != null) {
			NpcType var1 = this.method2332();
			return var1 == null ? null : var1.method2331();
		} else if (this.heads == null) {
			return null;
		} else {
			boolean var2 = false;
			for (int var3 = 0; var3 < this.heads.length; var3++) {
				if (!field1600.requestDownload(this.heads[var3], 0)) {
					var2 = true;
				}
			}
			if (var2) {
				return null;
			}
			Model[] var4 = new Model[this.heads.length];
			for (int var5 = 0; var5 < this.heads.length; var5++) {
				var4[var5] = Model.tryGet(field1600, this.heads[var5], 0);
			}
			Model var6;
			if (var4.length == 1) {
				var6 = var4[0];
			} else {
				var6 = new Model(var4, var4.length);
			}
			if (this.recol_s != null) {
				for (int var7 = 0; var7 < this.recol_s.length; var7++) {
					var6.recolour(this.recol_s[var7], this.recol_d[var7]);
				}
			}
			if (this.retex_s != null) {
				for (int var8 = 0; var8 < this.retex_s.length; var8++) {
					var6.retexture(this.retex_s[var8], this.retex_d[var8]);
				}
			}
			return var6;
		}
	}

	@ObfuscatedName("em.w(B)Lem;")
	public final NpcType method2332() {
		int var1 = -1;
		if (this.multivarbit != -1) {
			var1 = VarProvider.method1130(this.multivarbit);
		} else if (this.multivarp != -1) {
			var1 = VarProvider.field1210[this.multivarp];
		}
		return var1 < 0 || var1 >= this.multinpc.length || this.multinpc[var1] == -1 ? null : get(this.multinpc[var1]);
	}

	@ObfuscatedName("em.e(I)Z")
	public boolean method2339() {
		if (this.multinpc == null) {
			return true;
		}
		int var1 = -1;
		if (this.multivarbit != -1) {
			var1 = VarProvider.method1130(this.multivarbit);
		} else if (this.multivarp != -1) {
			var1 = VarProvider.field1210[this.multivarp];
		}
		return var1 >= 0 && var1 < this.multinpc.length && this.multinpc[var1] != -1;
	}

	@ObfuscatedName("df.b(I)V")
	public static void method1334() {
		field2274.clear();
		field2288.clear();
	}
}
