package jagex3.config;

import deob.ObfuscatedName;
import jagex3.datastruct.DoublyLinkable;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;
import jagex3.js5.Js5;
import jagex3.js5.Js5Loader;

@ObfuscatedName("fp")
public class InvType extends DoublyLinkable {

	@ObfuscatedName("fp.n")
	public static Js5 configJs5;

	@ObfuscatedName("fp.j")
	public static LruCache cache = new LruCache(64);

	@ObfuscatedName("fp.z")
	public int size = 0;

	@ObfuscatedName("fp.z(Lev;I)V")
	public void decode(Packet buf) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}

			this.decodeInner(buf, code);
		}
	}

	@ObfuscatedName("fp.g(Lev;II)V")
	public void decodeInner(Packet buf, int code) {
		if (code == 2) {
			this.size = buf.g2();
		}
	}

	public static InvType get(int id) {
		InvType cached = (InvType) cache.get(id);
		if (cached != null) {
			return cached;
		}

		byte[] data = configJs5.getFile(5, id);
		InvType inv = new InvType();
		if (data != null) {
			inv.decode(new Packet(data));
		}

		cache.put(inv, id);
		return inv;
	}

	public static void unpack(Js5Loader config) {
		configJs5 = config;
	}
}
