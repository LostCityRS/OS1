package jagex2.config;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.io.Packet;

@ObfuscatedName("fp")
public class InvType extends DoublyLinkable {

	@ObfuscatedName("fp.j")
	public static LruCache field2475 = new LruCache(64);

	@ObfuscatedName("fp.z")
	public int field2477 = 0;

	@ObfuscatedName("fp.z(Lev;I)V")
	public void method2569(Packet arg0) {
		while (true) {
			int var2 = arg0.g1();
			if (var2 == 0) {
				return;
			}
			this.method2566(arg0, var2);
		}
	}

	@ObfuscatedName("fp.g(Lev;II)V")
	public void method2566(Packet arg0, int arg1) {
		if (arg1 == 2) {
			this.field2477 = arg0.g2();
		}
	}
}
