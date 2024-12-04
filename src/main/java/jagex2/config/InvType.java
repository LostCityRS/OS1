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
	public static LruCache field2475 = new LruCache(64);

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
}
