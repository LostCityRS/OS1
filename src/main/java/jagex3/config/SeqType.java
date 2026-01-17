package jagex3.config;

import deob.ObfuscatedName;
import jagex3.dash3d.AnimFrameSet;
import jagex3.dash3d.ModelLit;
import jagex3.datastruct.DoublyLinkable;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;
import jagex3.js5.Js5;

@ObfuscatedName("eo")
public class SeqType extends DoublyLinkable {

	@ObfuscatedName("dz.n")
	public static Js5 field1517;

	@ObfuscatedName("ag.j")
	public static Js5 field556;

	@ObfuscatedName("eo.z")
	public static Js5 field2361;

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
	public int loops = -1;

	@ObfuscatedName("eo.e")
	public int[] walkmerge;

	@ObfuscatedName("eo.b")
	public boolean stretches = false;

	@ObfuscatedName("eo.y")
	public int priority = 5;

	@ObfuscatedName("eo.t")
	public int replaceheldleft = -1;

	@ObfuscatedName("eo.f")
	public int replaceheldright = -1;

	@ObfuscatedName("eo.k")
	public int maxloops = 99;

	@ObfuscatedName("eo.o")
	public int preanim_move = -1;

	@ObfuscatedName("eo.a")
	public int postanim_move = -1;

	@ObfuscatedName("eo.h")
	public int duplicatebehavior = 2;

	@ObfuscatedName("ai.z(Lch;Lch;Lch;I)V")
	public static void unpack(Js5 arg0, Js5 arg1, Js5 arg2) {
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
		byte[] var2 = field1517.getFile(12, arg0);
		SeqType var3 = new SeqType();
		if (var2 != null) {
			var3.decode(new Packet(var2));
		}
		var3.postDecode();
		field2362.put(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("eo.q(Lev;S)V")
	public void decode(Packet arg0) {
		while (true) {
			int var2 = arg0.g1();
			if (var2 == 0) {
				return;
			}
			this.decodeInner(arg0, var2);
		}
	}

	@ObfuscatedName("eo.i(Lev;IB)V")
	public void decodeInner(Packet arg0, int arg1) {
		if (arg1 == 1) {
			int var3 = arg0.g2();
			this.delay = new int[var3];
			for (int var4 = 0; var4 < var3; var4++) {
				this.delay[var4] = arg0.g2();
			}
			this.frames = new int[var3];
			for (int var5 = 0; var5 < var3; var5++) {
				this.frames[var5] = arg0.g2();
			}
			for (int var6 = 0; var6 < var3; var6++) {
				this.frames[var6] += arg0.g2() << 16;
			}
		} else if (arg1 == 2) {
			this.loops = arg0.g2();
		} else if (arg1 == 3) {
			int var7 = arg0.g1();
			this.walkmerge = new int[var7 + 1];
			for (int var8 = 0; var8 < var7; var8++) {
				this.walkmerge[var8] = arg0.g1();
			}
			this.walkmerge[var7] = 9999999;
		} else if (arg1 == 4) {
			this.stretches = true;
		} else if (arg1 == 5) {
			this.priority = arg0.g1();
		} else if (arg1 == 6) {
			this.replaceheldleft = arg0.g2();
		} else if (arg1 == 7) {
			this.replaceheldright = arg0.g2();
		} else if (arg1 == 8) {
			this.maxloops = arg0.g1();
		} else if (arg1 == 9) {
			this.preanim_move = arg0.g1();
		} else if (arg1 == 10) {
			this.postanim_move = arg0.g1();
		} else if (arg1 == 11) {
			this.duplicatebehavior = arg0.g1();
		} else if (arg1 == 12) {
			int var9 = arg0.g1();
			this.field2365 = new int[var9];
			for (int var10 = 0; var10 < var9; var10++) {
				this.field2365[var10] = arg0.g2();
			}
			for (int var11 = 0; var11 < var9; var11++) {
				this.field2365[var11] += arg0.g2() << 16;
			}
		} else if (arg1 == 13) {
			int var12 = arg0.g1();
			this.sound = new int[var12];
			for (int var13 = 0; var13 < var12; var13++) {
				this.sound[var13] = arg0.g3();
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
	public ModelLit method2436(ModelLit arg0, int arg1) {
		int var3 = this.frames[arg1];
		AnimFrameSet var4 = method760(var3 >> 16);
		int var5 = var3 & 0xFFFF;
		if (var4 == null) {
			return arg0.method2999(true);
		} else {
			ModelLit var6 = arg0.method2999(!var4.method2652(var5));
			var6.method3005(var4, var5);
			return var6;
		}
	}

	@ObfuscatedName("eo.v(Lfo;IIB)Lfo;")
	public ModelLit method2419(ModelLit arg0, int arg1, int arg2) {
		int var4 = this.frames[arg1];
		AnimFrameSet var5 = method760(var4 >> 16);
		int var6 = var4 & 0xFFFF;
		if (var5 == null) {
			return arg0.method2999(true);
		}
		ModelLit var7 = arg0.method2999(!var5.method2652(var6));
		int var8 = arg2 & 0x3;
		if (var8 == 1) {
			var7.method3010();
		} else if (var8 == 2) {
			var7.method3009();
		} else if (var8 == 3) {
			var7.rotate90();
		}
		var7.method3005(var5, var6);
		if (var8 == 1) {
			var7.rotate90();
		} else if (var8 == 2) {
			var7.method3009();
		} else if (var8 == 3) {
			var7.method3010();
		}
		return var7;
	}

	@ObfuscatedName("eo.w(Lfo;II)Lfo;")
	public ModelLit method2439(ModelLit arg0, int arg1) {
		int var3 = this.frames[arg1];
		AnimFrameSet var4 = method760(var3 >> 16);
		int var5 = var3 & 0xFFFF;
		if (var4 == null) {
			return arg0.method3040(true);
		} else {
			ModelLit var6 = arg0.method3040(!var4.method2652(var5));
			var6.method3005(var4, var5);
			return var6;
		}
	}

	@ObfuscatedName("eo.e(Lfo;ILeo;II)Lfo;")
	public ModelLit method2421(ModelLit arg0, int arg1, SeqType arg2, int arg3) {
		int var5 = this.frames[arg1];
		AnimFrameSet var6 = method760(var5 >> 16);
		int var7 = var5 & 0xFFFF;
		if (var6 == null) {
			return arg2.method2436(arg0, arg3);
		}
		int var8 = arg2.frames[arg3];
		AnimFrameSet var9 = method760(var8 >> 16);
		int var10 = var8 & 0xFFFF;
		if (var9 == null) {
			ModelLit var11 = arg0.method2999(!var6.method2652(var7));
			var11.method3005(var6, var7);
			return var11;
		} else {
			ModelLit var12 = arg0.method2999(!var6.method2652(var7) & !var9.method2652(var10));
			var12.method3006(var6, var7, var9, var10, this.walkmerge);
			return var12;
		}
	}

	@ObfuscatedName("eo.b(Lfo;IB)Lfo;")
	public ModelLit method2430(ModelLit arg0, int arg1) {
		int var3 = this.frames[arg1];
		AnimFrameSet var4 = method760(var3 >> 16);
		int var5 = var3 & 0xFFFF;
		if (var4 == null) {
			return arg0.method2999(true);
		}
		AnimFrameSet var6 = null;
		int var7 = 0;
		if (this.field2365 != null && arg1 < this.field2365.length) {
			int var8 = this.field2365[arg1];
			var6 = method760(var8 >> 16);
			var7 = var8 & 0xFFFF;
		}
		if (var6 == null || var7 == 65535) {
			ModelLit var10 = arg0.method2999(!var4.method2652(var5));
			var10.method3005(var4, var5);
			return var10;
		} else {
			ModelLit var9 = arg0.method2999(!var4.method2652(var5) & !var6.method2652(var7));
			var9.method3005(var4, var5);
			var9.method3005(var6, var7);
			return var9;
		}
	}

	@ObfuscatedName("bi.y(IB)Lfr;")
	public static AnimFrameSet method760(int arg0) {
		AnimFrameSet var1 = (AnimFrameSet) field2370.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		Js5 var2 = field556;
		Js5 var3 = field2361;
		boolean var4 = true;
		int[] var5 = var2.getFileList(arg0);
		for (int var6 = 0; var6 < var5.length; var6++) {
			byte[] var7 = var2.peekFile(arg0, var5[var6]);
			if (var7 == null) {
				var4 = false;
			} else {
				int var8 = (var7[0] & 0xFF) << 8 | var7[1] & 0xFF;
				byte[] var9 = var3.peekFile(var8, 0);
				if (var9 == null) {
					var4 = false;
				}
			}
		}
		AnimFrameSet var10;
		if (var4) {
			try {
				var10 = new AnimFrameSet(var2, var3, arg0, false);
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
	public static void unload() {
		field2362.clear();
		field2370.clear();
	}
}
