package jagex2.config;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

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
		byte[] var2 = configJs5.method1044(14, arg0);
		VarBitType var3 = new VarBitType();
		if (var2 != null) {
			var3.decode(new Packet(var2));
		}
		field2417.put(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("fc.g(Lev;B)V")
	public void decode(Packet buf) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}
			this.decodeInner(buf, code);
		}
	}

	@ObfuscatedName("fc.q(Lev;II)V")
	public void decodeInner(Packet buf, int code) {
		if (code == 1) {
			this.basevar = buf.g2();
			this.startbit = buf.g1();
			this.endbit = buf.g1();
		}
	}
}
