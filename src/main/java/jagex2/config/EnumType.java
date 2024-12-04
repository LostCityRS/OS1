package jagex2.config;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("fe")
public class EnumType extends DoublyLinkable {

	@ObfuscatedName("fe.n")
	public static Js5Index configJs5;

	@ObfuscatedName("fe.j")
	public static LruCache field2425 = new LruCache(64);

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
	public static EnumType get(int arg0) {
		EnumType var1 = (EnumType) field2425.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = configJs5.method1044(8, arg0);
		EnumType var3 = new EnumType();
		if (var2 != null) {
			var3.decode(new Packet(var2));
		}
		field2425.put(var3, (long) arg0);
		return var3;
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
			for (int var3 = 0; var3 < this.count; var3++) {
				this.keys[var3] = buf.g4();
				this.stringValues[var3] = buf.gjstr();
			}
		} else if (code == 6) {
			this.count = buf.g2();
			this.keys = new int[this.count];
			this.intValues = new int[this.count];
			for (int var4 = 0; var4 < this.count; var4++) {
				this.keys[var4] = buf.g4();
				this.intValues[var4] = buf.g4();
			}
		}
	}
}
