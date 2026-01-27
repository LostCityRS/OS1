package jagex3.javconfig;

import deob.ObfuscatedName;

@ObfuscatedName("be")
public class ModeWhat {

	@ObfuscatedName("be.r")
	public static final ModeWhat LIVE = new ModeWhat("LIVE", 0);

	@ObfuscatedName("be.d")
	public static final ModeWhat BUILDLIVE = new ModeWhat("BUILDLIVE", 3);

	@ObfuscatedName("be.l")
	public static final ModeWhat RC = new ModeWhat("RC", 1);

	@ObfuscatedName("be.m")
	public static final ModeWhat WIP = new ModeWhat("WIP", 2);

	@ObfuscatedName("be.c")
	public final String name;

	@ObfuscatedName("be.n")
	public final int id;

	public ModeWhat(String arg0, int arg1) {
		this.name = arg0;
		this.id = arg1;
	}

	public static ModeWhat[] values() {
		return new ModeWhat[] {
			ModeWhat.RC, ModeWhat.WIP, ModeWhat.BUILDLIVE, ModeWhat.LIVE
		};
	}

	public static ModeWhat get(int id) {
		ModeWhat[] all = ModeWhat.values();
		for (int i = 0; i < all.length; i++) {
			ModeWhat mode = all[i];
			if (mode.id == id) {
				return mode;
			}
		}
		return null;
	}
}
