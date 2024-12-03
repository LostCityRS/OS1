package jagex2.config;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.graphics.Model;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("fd")
public class IdkType extends DoublyLinkable {

	@ObfuscatedName("fd.n")
	public static Js5Index field2394;

	@ObfuscatedName("fd.j")
	public static Js5Index field2397;

	@ObfuscatedName("dl.z")
	public static int field1628;

	@ObfuscatedName("fd.g")
	public static LruCache field2396 = new LruCache(64);

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
	public static void method1194(Js5Index arg0, Js5Index arg1) {
		field2394 = arg0;
		field2397 = arg1;
		field1628 = field2394.method1054(3);
	}

	@ObfuscatedName("p.g(II)Lfd;")
	public static IdkType get(int arg0) {
		IdkType var1 = (IdkType) field2396.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = field2394.method1044(3, arg0);
		IdkType var3 = new IdkType();
		if (var2 != null) {
			var3.decode(new Packet(var2));
		}
		field2396.put(var3, (long) arg0);
		return var3;
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
			int var3 = buf.g1();
			this.models = new int[var3];
			for (int var4 = 0; var4 < var3; var4++) {
				this.models[var4] = buf.g2();
			}
		} else if (code == 3) {
			this.disable = true;
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
		} else if (code >= 60 && code < 70) {
			this.heads[code - 60] = buf.g2();
		}
	}

	@ObfuscatedName("fd.s(I)Z")
	public boolean method2461() {
		if (this.models == null) {
			return true;
		}
		boolean var1 = true;
		for (int var2 = 0; var2 < this.models.length; var2++) {
			if (!field2397.method1046(this.models[var2], 0)) {
				var1 = false;
			}
		}
		return var1;
	}

	@ObfuscatedName("fd.u(S)Lfw;")
	public Model method2465() {
		if (this.models == null) {
			return null;
		}
		Model[] var1 = new Model[this.models.length];
		for (int var2 = 0; var2 < this.models.length; var2++) {
			var1[var2] = Model.method2992(field2397, this.models[var2], 0);
		}
		Model var3;
		if (var1.length == 1) {
			var3 = var1[0];
		} else {
			var3 = new Model(var1, var1.length);
		}
		if (this.recol_s != null) {
			for (int var4 = 0; var4 < this.recol_s.length; var4++) {
				var3.method2935(this.recol_s[var4], this.recol_d[var4]);
			}
		}
		if (this.retex_s != null) {
			for (int var5 = 0; var5 < this.retex_s.length; var5++) {
				var3.method2976(this.retex_s[var5], this.retex_d[var5]);
			}
		}
		return var3;
	}

	@ObfuscatedName("fd.v(B)Z")
	public boolean method2463() {
		boolean var1 = true;
		for (int var2 = 0; var2 < 5; var2++) {
			if (this.heads[var2] != -1 && !field2397.method1046(this.heads[var2], 0)) {
				var1 = false;
			}
		}
		return var1;
	}

	@ObfuscatedName("fd.w(B)Lfw;")
	public Model method2480() {
		Model[] var1 = new Model[5];
		int var2 = 0;
		for (int var3 = 0; var3 < 5; var3++) {
			if (this.heads[var3] != -1) {
				var1[var2++] = Model.method2992(field2397, this.heads[var3], 0);
			}
		}
		Model var4 = new Model(var1, var2);
		if (this.recol_s != null) {
			for (int var5 = 0; var5 < this.recol_s.length; var5++) {
				var4.method2935(this.recol_s[var5], this.recol_d[var5]);
			}
		}
		if (this.retex_s != null) {
			for (int var6 = 0; var6 < this.retex_s.length; var6++) {
				var4.method2976(this.retex_s[var6], this.retex_d[var6]);
			}
		}
		return var4;
	}
}
