package jagex2.client;

import deob.ObfuscatedName;
import jagex2.config.VarBitType;

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

	@ObfuscatedName("cc.r(II)I")
	public static int method1130(int arg0) {
		VarBitType var1 = VarBitType.get(arg0);
		int var2 = var1.basevar;
		int var3 = var1.startbit;
		int var4 = var1.endbit;
		int var5 = field1212[var4 - var3];
		return field1210[var2] >> var3 & var5;
	}
}
