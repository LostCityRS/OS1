package jagex3.config;

import deob.ObfuscatedName;
import jagex3.datastruct.DoublyLinkable;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;
import jagex3.js5.Js5Index;
import jagex3.js5.Js5Local;

@ObfuscatedName("fc")
public class VarBitType extends DoublyLinkable {

	@ObfuscatedName("fc.n")
	public static Js5Index configJs5;

	@ObfuscatedName("fc.j")
	public static LruCache field2417 = new LruCache(64);

	@ObfuscatedName("fc.z")
	public int basevar;

	@ObfuscatedName("fc.g")
	public int startbit;

	@ObfuscatedName("fc.q")
	public int endbit;

	@ObfuscatedName("q.z(II)Lfc;")
	public static VarBitType get(int arg0) {
		VarBitType var1 = (VarBitType) field2417.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = configJs5.getFile(14, arg0);
		VarBitType var3 = new VarBitType();
		if (var2 != null) {
			var3.decode(new Packet(var2));
		}
		field2417.put(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("fc.g(Lev;B)V")
	public void decode(Packet arg0) {
		while (true) {
			int var2 = arg0.g1();
			if (var2 == 0) {
				return;
			}
			this.decodeInner(arg0, var2);
		}
	}

	@ObfuscatedName("fc.q(Lev;II)V")
	public void decodeInner(Packet arg0, int arg1) {
		if (arg1 == 1) {
			this.basevar = arg0.g2();
			this.startbit = arg0.g1();
			this.endbit = arg0.g1();
		}
	}

	public static void unpack(Js5Local var38) {
		configJs5 = var38;
	}

	public static void unload() {
		field2417.clear();
	}
}
