package jagex3.config;

import deob.ObfuscatedName;
import jagex3.datastruct.DoublyLinkable;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;
import jagex3.js5.Js5;
import jagex3.js5.Js5Loader;

@ObfuscatedName("fe")
public class EnumType extends DoublyLinkable {

	@ObfuscatedName("fe.n")
	public static Js5 configJs5;

	@ObfuscatedName("fe.j")
	public static LruCache cache = new LruCache(64);

	@ObfuscatedName("fe.z")
	public int inputtype;

	@ObfuscatedName("fe.g")
	public char outputtype;

	@ObfuscatedName("fe.q")
	public String defaultString = "null";

	@ObfuscatedName("fe.i")
	public int defaultInt;

	@ObfuscatedName("fe.s")
	public int count = 0;

	@ObfuscatedName("fe.u")
	public int[] keys;

	@ObfuscatedName("fe.v")
	public int[] intValues;

	@ObfuscatedName("fe.w")
	public String[] stringValues;

	@ObfuscatedName("ek.z(II)Lfe;")
	public static EnumType get(int id) {
		EnumType cached = (EnumType) cache.get(id);
		if (cached != null) {
			return cached;
		}

		byte[] data = configJs5.getFile(8, id);
		EnumType type = new EnumType();
		if (data != null) {
			type.decode(new Packet(data));
		}

		cache.put(type, id);
		return type;
	}

	@ObfuscatedName("fe.g(Lev;I)V")
	public void decode(Packet buf) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}

			this.decodeInner(buf, code);
		}
	}

	@ObfuscatedName("fe.q(Lev;IB)V")
	public void decodeInner(Packet buf, int code) {
		if (code == 1) {
			this.inputtype = buf.g1();
		} else if (code == 2) {
			this.outputtype = (char) buf.g1();
		} else if (code == 3) {
			this.defaultString = buf.gjstr();
		} else if (code == 4) {
			this.defaultInt = buf.g4();
		} else if (code == 5) {
			this.count = buf.g2();

			this.keys = new int[this.count];
			this.stringValues = new String[this.count];

			for (int i = 0; i < this.count; i++) {
				this.keys[i] = buf.g4();
				this.stringValues[i] = buf.gjstr();
			}
		} else if (code == 6) {
			this.count = buf.g2();

			this.keys = new int[this.count];
			this.intValues = new int[this.count];

			for (int i = 0; i < this.count; i++) {
				this.keys[i] = buf.g4();
				this.intValues[i] = buf.g4();
			}
		}
	}

	public static void unpack(Js5Loader config) {
		configJs5 = config;
	}
}
