package jagex3.client;

import deob.ObfuscatedName;
import jagex3.config.VarBitType;

@ObfuscatedName("cm")
public class VarCache {

	@ObfuscatedName("cm.r")
	public static int[] mask = new int[32];

	@ObfuscatedName("cm.d")
	public static int[] varServ;

	@ObfuscatedName("cm.l")
	public static int[] var;

	static {
		int acc = 2;
		for (int b = 0; b < 32; b++) {
			mask[b] = acc - 1;
			acc += acc;
		}

		varServ = new int[2000];
		var = new int[2000];
	}

	public VarCache() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("cc.r(II)I")
	public static int getVarbit(int id) {
		VarBitType varbit = VarBitType.get(id);
		int basevar = varbit.basevar;
		int startbit = varbit.startbit;
		int endbit = varbit.endbit;
		int mask = VarCache.mask[endbit - startbit];
		return var[basevar] >> startbit & mask;
	}
}
