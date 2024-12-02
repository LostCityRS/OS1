package jagex2.config;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.io.Packet;

@ObfuscatedName("fc")
public class VarBitType extends DoublyLinkable {

	@ObfuscatedName("fc.j")
	public static LruCache field2417 = new LruCache(64);

	@ObfuscatedName("fc.z")
	public int field2418;

	@ObfuscatedName("fc.g")
	public int field2416;

	@ObfuscatedName("fc.q")
	public int field2420;

	@ObfuscatedName("q.z(II)Lfc;")
	public static VarBitType method98(int arg0) {
		VarBitType var1 = (VarBitType) field2417.method1244((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = Statics.field2419.method1044(14, arg0);
		VarBitType var3 = new VarBitType();
		if (var2 != null) {
			var3.method2501(new Packet(var2));
		}
		field2417.method1246(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("fc.g(Lev;B)V")
	public void method2501(Packet arg0) {
		while (true) {
			int var2 = arg0.method1600();
			if (var2 == 0) {
				return;
			}
			this.method2503(arg0, var2);
		}
	}

	@ObfuscatedName("fc.q(Lev;II)V")
	public void method2503(Packet arg0, int arg1) {
		if (arg1 == 1) {
			this.field2418 = arg0.method1602();
			this.field2416 = arg0.method1600();
			this.field2420 = arg0.method1600();
		}
	}
}
