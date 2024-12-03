package jagex2.client;

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
	public final String field850;

	@ObfuscatedName("be.n")
	public final int field851;

	public ModeWhat(String arg0, int arg1) {
		this.field850 = arg0;
		this.field851 = arg1;
	}
}
