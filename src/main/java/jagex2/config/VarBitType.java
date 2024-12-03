package jagex2.config;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("fc")
public class VarBitType extends DoublyLinkable {

	@ObfuscatedName("fc.n")
	public static Js5Index field2419;

	@ObfuscatedName("fc.j")
	public static LruCache field2417 = new LruCache(64);

	@ObfuscatedName("fc.z")
	public int field2418;

	@ObfuscatedName("fc.g")
	public int field2416;

	@ObfuscatedName("fc.q")
	public int field2420;

	@ObfuscatedName("q.z(II)Lfc;")
	public static VarBitType get(int arg0) {
		VarBitType var1 = (VarBitType) field2417.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = field2419.method1044(14, arg0);
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
			this.field2418 = arg0.g2();
			this.field2416 = arg0.g1();
			this.field2420 = arg0.g1();
		}
	}
}
