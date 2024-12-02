package jagex2.client;

import deob.ObfuscatedName;

@ObfuscatedName("cm")
public class VarProvider {

	@ObfuscatedName("cm.r")
	public static int[] field1212 = new int[32];

	@ObfuscatedName("cm.d")
	public static int[] field1211;

	@ObfuscatedName("cm.l")
	public static int[] field1210;

	static {
		int var0 = 2;
		for (int var1 = 0; var1 < 32; var1++) {
			field1212[var1] = var0 - 1;
			var0 += var0;
		}
		field1211 = new int[2000];
		field1210 = new int[2000];
	}

	public VarProvider() throws Throwable {
		throw new Error();
	}
}
