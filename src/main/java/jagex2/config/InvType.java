package jagex2.config;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("fp")
public class InvType extends DoublyLinkable {

	@ObfuscatedName("fp.n")
	public static Js5Index field2476;

	@ObfuscatedName("fp.j")
	public static LruCache field2475 = new LruCache(64);

	@ObfuscatedName("fp.z")
	public int field2477 = 0;

	@ObfuscatedName("fp.z(Lev;I)V")
	public void decode(Packet arg0) {
		while (true) {
			int var2 = arg0.g1();
			if (var2 == 0) {
				return;
			}
			this.decodeInner(arg0, var2);
		}
	}

	@ObfuscatedName("fp.g(Lev;II)V")
	public void decodeInner(Packet arg0, int arg1) {
		if (arg1 == 2) {
			this.field2477 = arg0.g2();
		}
	}
}
