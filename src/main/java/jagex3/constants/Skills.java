package jagex3.constants;

import deob.ObfuscatedName;

// jag::oldscape::constants::skills
@ObfuscatedName("bm")
public class Skills {

	// jag::oldscape::constants::skills::used
	@ObfuscatedName("bm.d")
	public static final boolean[] used = new boolean[] {
		true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true,
		true, true, true, true, true, false, false
	};

	// jag::oldscape::constants::skills::skillxp
	@ObfuscatedName("bm.l")
	public static int[] skillxp = new int[99];

	static {
		int var0 = 0;
		for (int var1 = 0; var1 < 99; var1++) {
			int var2 = var1 + 1;
			int var3 = (int) ((double) var2 + Math.pow(2.0D, (double) var2 / 7.0D) * 300.0D);
			var0 += var3;
			skillxp[var1] = var0 / 4;
		}
	}

	public Skills() throws Throwable {
		throw new Error();
	}
}
