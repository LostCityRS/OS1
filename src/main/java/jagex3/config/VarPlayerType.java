package jagex3.config;

import deob.ObfuscatedName;
import jagex3.datastruct.DoublyLinkable;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;
import jagex3.js5.Js5Index;

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
	public static void init(Js5Index arg0) {
		field537 = arg0;
		field2352 = field537.getFileCount(16);
	}

	@ObfuscatedName("ez.g(II)Lfg;")
	public static VarPlayerType get(int arg0) {
		VarPlayerType var1 = (VarPlayerType) field2479.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = field537.getFile(16, arg0);
		VarPlayerType var3 = new VarPlayerType();
		if (var2 != null) {
			var3.decode(new Packet(var2));
		}
		field2479.put(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("fg.q(Lev;I)V")
	public void decode(Packet arg0) {
		while (true) {
			int var2 = arg0.g1();
			if (var2 == 0) {
				return;
			}
			this.decodeInner(arg0, var2);
		}
	}

	@ObfuscatedName("fg.i(Lev;II)V")
	public void decodeInner(Packet arg0, int arg1) {
		if (arg1 == 5) {
			this.clientcode = arg0.g2();
		}
	}

	@ObfuscatedName("cz.s(I)V")
	public static void unload() {
		field2479.clear();
	}
}
