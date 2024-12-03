package jagex2.config;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("fg")
public class VarPlayerType extends DoublyLinkable {

	@ObfuscatedName("fg.z")
	public static LruCache field2479 = new LruCache(64);

	@ObfuscatedName("fg.g")
	public int field2478 = 0;

	@ObfuscatedName("cy.z(Lch;I)V")
	public static void method1237(Js5Index arg0) {
		Statics.field537 = arg0;
		Statics.field2352 = Statics.field537.method1054(16);
	}

	@ObfuscatedName("ez.g(II)Lfg;")
	public static VarPlayerType method1584(int arg0) {
		VarPlayerType var1 = (VarPlayerType) field2479.method1244((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = Statics.field537.method1044(16, arg0);
		VarPlayerType var3 = new VarPlayerType();
		if (var2 != null) {
			var3.method2571(new Packet(var2));
		}
		field2479.method1246(var3, (long) arg0);
		return var3;
	}

	@ObfuscatedName("fg.q(Lev;I)V")
	public void method2571(Packet arg0) {
		while (true) {
			int var2 = arg0.g1();
			if (var2 == 0) {
				return;
			}
			this.method2572(arg0, var2);
		}
	}

	@ObfuscatedName("fg.i(Lev;II)V")
	public void method2572(Packet arg0, int arg1) {
		if (arg1 == 5) {
			this.field2478 = arg0.g2();
		}
	}

	@ObfuscatedName("cz.s(I)V")
	public static void method1148() {
		field2479.method1253();
	}
}
