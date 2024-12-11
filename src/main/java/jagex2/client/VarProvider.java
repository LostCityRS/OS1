package jagex2.client;

import deob.ObfuscatedName;
import jagex2.config.VarBitType;

@ObfuscatedName("cm")
public class VarProvider {

	@ObfuscatedName("cm.r")
	public static int[] BITMASK = new int[32];

	@ObfuscatedName("cm.d")
	public static int[] varCache;

	@ObfuscatedName("cm.l")
	public static int[] varps;

	static {
		int acc = 2;
		for (int b = 0; b < 32; b++) {
			BITMASK[b] = acc - 1;
			acc += acc;
		}

		varCache = new int[2000];
		varps = new int[2000];
	}

	public VarProvider() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("cc.r(II)I")
	public static int getVarbit(int id) {
		VarBitType varbit = VarBitType.get(id);
		int basevar = varbit.basevar;
		int startbit = varbit.startbit;
		int endbit = varbit.endbit;
		int mask = BITMASK[endbit - startbit];
		return varps[basevar] >> startbit & mask;
	}
}
