package jagex2.config;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("fp")
public class InvType extends DoublyLinkable {

	@ObfuscatedName("fp.n")
	public static Js5Index configJs5;

	@ObfuscatedName("fp.j")
	public static LruCache cache = new LruCache(64);

	@ObfuscatedName("fp.z")
	public int size = 0;

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
	public void decodeInner(Packet buf, int code) {
		if (code == 2) {
			this.size = buf.g2();
		}
	}

	// inlined
	public static InvType get(int id) {
		InvType cached = (InvType) InvType.cache.get(id);
		if (cached != null) {
			return cached;
		}

		byte[] buf = InvType.configJs5.getFile(5, id);
		InvType inv = new InvType();
		if (buf != null) {
			inv.decode(new Packet(buf));
		}
		InvType.cache.put(inv, id);
		return inv;
	}
}
