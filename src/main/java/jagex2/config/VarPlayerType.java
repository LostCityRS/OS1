package jagex2.config;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("fg")
public class VarPlayerType extends DoublyLinkable {

	@ObfuscatedName("al.n")
	public static Js5Index field537;

	@ObfuscatedName("ey.j")
	public static int field2352;

	@ObfuscatedName("fg.z")
	public static LruCache field2479 = new LruCache(64);

	@ObfuscatedName("fg.g")
	public int clientcode = 0;

	@ObfuscatedName("cy.z(Lch;I)V")
	public static void method1237(Js5Index arg0) {
		field537 = arg0;
		field2352 = field537.method1054(16);
	}

	@ObfuscatedName("ez.g(II)Lfg;")
	public static VarPlayerType get(int arg0) {
		VarPlayerType var1 = (VarPlayerType) field2479.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = field537.method1044(16, arg0);
		VarPlayerType var3 = new VarPlayerType();
		if (var2 != null) {
			var3.decode(new Packet(var2));
		}
		field2479.put(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("fg.q(Lev;I)V")
	public void decode(Packet buf) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}
			this.decodeInner(buf, code);
		}
	}

	@ObfuscatedName("fg.i(Lev;II)V")
	public void decodeInner(Packet code, int buf) {
		if (buf == 5) {
			this.clientcode = code.g2();
		}
	}

	@ObfuscatedName("cz.s(I)V")
	public static void method1148() {
		field2479.clear();
	}
}
