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
		byte[] var2 = configJs5.getFile(8, arg0);
		EnumType var3 = new EnumType();
		if (var2 != null) {
			var3.decode(new Packet(var2));
		}
		field2425.put(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("fe.g(Lev;I)V")
	public void decode(Packet arg0) {
		while (true) {
			int var2 = arg0.g1();
			if (var2 == 0) {
				return;
			}
			this.decodeInner(arg0, var2);
		}
	}

	@ObfuscatedName("fe.q(Lev;IB)V")
	public void decodeInner(Packet arg0, int arg1) {
		if (arg1 == 1) {
			this.inputtype = arg0.g1();
		} else if (arg1 == 2) {
			this.outputtype = (char) arg0.g1();
		} else if (arg1 == 3) {
			this.defaultString = arg0.gjstr();
		} else if (arg1 == 4) {
			this.defaultInt = arg0.g4();
		} else if (arg1 == 5) {
			this.count = arg0.g2();
			this.keys = new int[this.count];
			this.stringValues = new String[this.count];
			for (int var3 = 0; var3 < this.count; var3++) {
				this.keys[var3] = arg0.g4();
				this.stringValues[var3] = arg0.gjstr();
			}
		} else if (arg1 == 6) {
			this.count = arg0.g2();
			this.keys = new int[this.count];
			this.intValues = new int[this.count];
			for (int var4 = 0; var4 < this.count; var4++) {
				this.keys[var4] = arg0.g4();
				this.intValues[var4] = arg0.g4();
			}
		}
	}
}
