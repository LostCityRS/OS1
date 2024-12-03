package jagex2.config;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.graphics.AnimFrameset;
import jagex2.graphics.SoftwareModel;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("eo")
public class SeqType extends DoublyLinkable {

	@ObfuscatedName("dz.n")
	public static Js5Index field1517;

	@ObfuscatedName("ag.j")
	public static Js5Index field556;

	@ObfuscatedName("eo.z")
	public static Js5Index field2361;

	@ObfuscatedName("eo.g")
	public static LruCache field2362 = new LruCache(64);

	@ObfuscatedName("eo.q")
	public static LruCache field2370 = new LruCache(100);

	@ObfuscatedName("eo.i")
	public int[] frames;

	@ObfuscatedName("eo.s")
	public int[] field2365;

	@ObfuscatedName("eo.u")
	public int[] delay;

	@ObfuscatedName("eo.v")
	public int[] sound;

	@ObfuscatedName("eo.w")
	public int replayoff = -1;

	@ObfuscatedName("eo.e")
	public int[] walkmerge;

	@ObfuscatedName("eo.b")
	public boolean stretches = false;

	@ObfuscatedName("eo.y")
	public int priority = 5;

	@ObfuscatedName("eo.t")
	public int righthand = -1;

	@ObfuscatedName("eo.f")
	public int lefthand = -1;

	@ObfuscatedName("eo.k")
	public int replaycount = 99;

	@ObfuscatedName("eo.o")
	public int preanim_move = -1;

	@ObfuscatedName("eo.a")
	public int postanim_move = -1;

	@ObfuscatedName("eo.h")
	public int replacemode = 2;

	@ObfuscatedName("ai.z(Lch;Lch;Lch;I)V")
	public static void method727(Js5Index arg0, Js5Index arg1, Js5Index arg2) {
		field1517 = arg0;
		field556 = arg1;
		field2361 = arg2;
	}

	@ObfuscatedName("i.g(IB)Leo;")
	public static SeqType get(int arg0) {
		SeqType var1 = (SeqType) field2362.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = field1517.method1044(12, arg0);
		SeqType var3 = new SeqType();
		if (var2 != null) {
			var3.decode(new Packet(var2));
		}
		var3.postDecode();
		field2362.put(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("eo.q(Lev;S)V")
	public void decode(Packet buf) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}
			this.decodeInner(buf, code);
		}
	}

	@ObfuscatedName("eo.i(Lev;IB)V")
	public void decodeInner(Packet buf, int code) {
		if (code == 1) {
			int var3 = buf.g2();
			this.delay = new int[var3];
			for (int var4 = 0; var4 < var3; var4++) {
				this.delay[var4] = buf.g2();
			}
			this.frames = new int[var3];
			for (int var5 = 0; var5 < var3; var5++) {
				this.frames[var5] = buf.g2();
			}
			for (int var6 = 0; var6 < var3; var6++) {
				this.frames[var6] += buf.g2() << 16;
			}
		} else if (code == 2) {
			this.replayoff = buf.g2();
		} else if (code == 3) {
			int var7 = buf.g1();
			this.walkmerge = new int[var7 + 1];
			for (int var8 = 0; var8 < var7; var8++) {
				this.walkmerge[var8] = buf.g1();
			}
			this.walkmerge[var7] = 9999999;
		} else if (code == 4) {
			this.stretches = true;
		} else if (code == 5) {
			this.priority = buf.g1();
		} else if (code == 6) {
			this.righthand = buf.g2();
		} else if (code == 7) {
			this.lefthand = buf.g2();
		} else if (code == 8) {
			this.replaycount = buf.g1();
		} else if (code == 9) {
			this.preanim_move = buf.g1();
		} else if (code == 10) {
			this.postanim_move = buf.g1();
		} else if (code == 11) {
			this.replacemode = buf.g1();
		} else if (code == 12) {
			int var9 = buf.g1();
			this.field2365 = new int[var9];
			for (int var10 = 0; var10 < var9; var10++) {
				this.field2365[var10] = buf.g2();
			}
			for (int var11 = 0; var11 < var9; var11++) {
				this.field2365[var11] += buf.g2() << 16;
			}
		} else if (code == 13) {
			int var12 = buf.g1();
			this.sound = new int[var12];
			for (int var13 = 0; var13 < var12; var13++) {
				this.sound[var13] = buf.g3();
			}
		}
	}

	@ObfuscatedName("eo.s(B)V")
	public void postDecode() {
		if (this.preanim_move == -1) {
			if (this.walkmerge == null) {
				this.preanim_move = 0;
			} else {
				this.preanim_move = 2;
			}
		}
        if (this.postanim_move == -1) {
            if (this.walkmerge == null) {
                this.postanim_move = 0;
            } else {
                this.postanim_move = 2;
            }
        }
    }

	@ObfuscatedName("eo.u(Lfo;II)Lfo;")
	public SoftwareModel method2436(SoftwareModel arg0, int arg1) {
		int var3 = this.frames[arg1];
		AnimFrameset var4 = method760(var3 >> 16);
		int var5 = var3 & 0xFFFF;
		if (var4 == null) {
			return arg0.method2999(true);
		} else {
			SoftwareModel var6 = arg0.method2999(!var4.method2652(var5));
			var6.method3005(var4, var5);
			return var6;
		}
	}

	@ObfuscatedName("eo.v(Lfo;IIB)Lfo;")
	public SoftwareModel method2419(SoftwareModel arg0, int arg1, int arg2) {
		int var4 = this.frames[arg1];
		AnimFrameset var5 = method760(var4 >> 16);
		int var6 = var4 & 0xFFFF;
		if (var5 == null) {
			return arg0.method2999(true);
		}
		SoftwareModel var7 = arg0.method2999(!var5.method2652(var6));
		int var8 = arg2 & 0x3;
		if (var8 == 1) {
			var7.method3010();
		} else if (var8 == 2) {
			var7.method3009();
		} else if (var8 == 3) {
			var7.method3008();
		}
		var7.method3005(var5, var6);
		if (var8 == 1) {
			var7.method3008();
		} else if (var8 == 2) {
			var7.method3009();
		} else if (var8 == 3) {
			var7.method3010();
		}
		return var7;
	}

	@ObfuscatedName("eo.w(Lfo;II)Lfo;")
	public SoftwareModel method2439(SoftwareModel arg0, int arg1) {
		int var3 = this.frames[arg1];
		AnimFrameset var4 = method760(var3 >> 16);
		int var5 = var3 & 0xFFFF;
		if (var4 == null) {
			return arg0.method3040(true);
		} else {
			SoftwareModel var6 = arg0.method3040(!var4.method2652(var5));
			var6.method3005(var4, var5);
			return var6;
		}
	}

	@ObfuscatedName("eo.e(Lfo;ILeo;II)Lfo;")
	public SoftwareModel method2421(SoftwareModel arg0, int arg1, SeqType arg2, int arg3) {
		int var5 = this.frames[arg1];
		AnimFrameset var6 = method760(var5 >> 16);
		int var7 = var5 & 0xFFFF;
		if (var6 == null) {
			return arg2.method2436(arg0, arg3);
		}
		int var8 = arg2.frames[arg3];
		AnimFrameset var9 = method760(var8 >> 16);
		int var10 = var8 & 0xFFFF;
		if (var9 == null) {
			SoftwareModel var11 = arg0.method2999(!var6.method2652(var7));
			var11.method3005(var6, var7);
			return var11;
		} else {
			SoftwareModel var12 = arg0.method2999(!var6.method2652(var7) & !var9.method2652(var10));
			var12.method3006(var6, var7, var9, var10, this.walkmerge);
			return var12;
		}
	}

	@ObfuscatedName("eo.b(Lfo;IB)Lfo;")
	public SoftwareModel method2430(SoftwareModel arg0, int arg1) {
		int var3 = this.frames[arg1];
		AnimFrameset var4 = method760(var3 >> 16);
		int var5 = var3 & 0xFFFF;
		if (var4 == null) {
			return arg0.method2999(true);
		}
		AnimFrameset var6 = null;
		int var7 = 0;
		if (this.field2365 != null && arg1 < this.field2365.length) {
			int var8 = this.field2365[arg1];
			var6 = method760(var8 >> 16);
			var7 = var8 & 0xFFFF;
		}
		if (var6 == null || var7 == 65535) {
			SoftwareModel var10 = arg0.method2999(!var4.method2652(var5));
			var10.method3005(var4, var5);
			return var10;
		} else {
			SoftwareModel var9 = arg0.method2999(!var4.method2652(var5) & !var6.method2652(var7));
			var9.method3005(var4, var5);
			var9.method3005(var6, var7);
			return var9;
		}
	}

	@ObfuscatedName("bi.y(IB)Lfr;")
	public static AnimFrameset method760(int arg0) {
		AnimFrameset var1 = (AnimFrameset) field2370.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		Js5Index var2 = field556;
		Js5Index var3 = field2361;
		boolean var4 = true;
		int[] var5 = var2.method1053(arg0);
		for (int var6 = 0; var6 < var5.length; var6++) {
			byte[] var7 = var2.method1050(arg0, var5[var6]);
			if (var7 == null) {
				var4 = false;
			} else {
				int var8 = (var7[0] & 0xFF) << 8 | var7[1] & 0xFF;
				byte[] var9 = var3.method1050(var8, 0);
				if (var9 == null) {
					var4 = false;
				}
			}
		}
		AnimFrameset var10;
		if (var4) {
			try {
				var10 = new AnimFrameset(var2, var3, arg0, false);
			} catch (Exception var13) {
				var10 = null;
			}
		} else {
			var10 = null;
		}
		if (var10 != null) {
			field2370.put(var10, (long) arg0);
		}
		return var10;
	}

	@ObfuscatedName("cu.t(I)V")
	public static void method1123() {
		field2362.clear();
		field2370.clear();
	}
}
