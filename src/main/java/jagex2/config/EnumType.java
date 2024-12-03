package jagex2.config;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("fe")
public class EnumType extends DoublyLinkable {

	@ObfuscatedName("fe.n")
	public static Js5Index field2422;

	@ObfuscatedName("fe.j")
	public static LruCache field2425 = new LruCache(64);

	@ObfuscatedName("fe.z")
	public int field2423;

	@ObfuscatedName("fe.g")
	public char field2424;

	@ObfuscatedName("fe.q")
	public String field2428 = "null";

	@ObfuscatedName("fe.i")
	public int field2426;

	@ObfuscatedName("fe.s")
	public int field2427 = 0;

	@ObfuscatedName("fe.u")
	public int[] field2421;

	@ObfuscatedName("fe.v")
	public int[] field2429;

	@ObfuscatedName("fe.w")
	public String[] field2430;

	@ObfuscatedName("ek.z(II)Lfe;")
	public static EnumType get(int arg0) {
		EnumType var1 = (EnumType) field2425.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = field2422.method1044(8, arg0);
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
			this.field2423 = arg0.g1();
		} else if (arg1 == 2) {
			this.field2424 = (char) arg0.g1();
		} else if (arg1 == 3) {
			this.field2428 = arg0.gjstr();
		} else if (arg1 == 4) {
			this.field2426 = arg0.g4();
		} else if (arg1 == 5) {
			this.field2427 = arg0.g2();
			this.field2421 = new int[this.field2427];
			this.field2430 = new String[this.field2427];
			for (int var3 = 0; var3 < this.field2427; var3++) {
				this.field2421[var3] = arg0.g4();
				this.field2430[var3] = arg0.gjstr();
			}
		} else if (arg1 == 6) {
			this.field2427 = arg0.g2();
			this.field2421 = new int[this.field2427];
			this.field2429 = new int[this.field2427];
			for (int var4 = 0; var4 < this.field2427; var4++) {
				this.field2421[var4] = arg0.g4();
				this.field2429[var4] = arg0.g4();
			}
		}
	}
}
