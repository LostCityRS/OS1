package jagex2.client;

import deob.ObfuscatedName;

@ObfuscatedName("bm")
public class PlayerStats {

	@ObfuscatedName("bm.d")
	public static final boolean[] enabled = new boolean[] { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false };

	@ObfuscatedName("bm.l")
	public static int[] levelExperience = new int[99];

	static {
		int var0 = 0;
		for (int var1 = 0; var1 < 99; var1++) {
			int var2 = var1 + 1;
			int var3 = (int) ((double) var2 + Math.pow(2.0D, (double) var2 / 7.0D) * 300.0D);
			var0 += var3;
			levelExperience[var1] = var0 / 4;
		}
	}

	public PlayerStats() throws Throwable {
		throw new Error();
	}
}
