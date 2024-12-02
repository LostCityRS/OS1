package jagex2.client;

import deob.ObfuscatedName;

@ObfuscatedName("bp")
public class ModeGame implements ModeGameProvider {

	@ObfuscatedName("bp.r")
	public static final ModeGame field860 = new ModeGame("runescape", "RuneScape", 0);

	@ObfuscatedName("bp.d")
	public static final ModeGame field856 = new ModeGame("stellardawn", "Stellar Dawn", 1);

	@ObfuscatedName("bp.l")
	public static final ModeGame field858 = new ModeGame("game3", "Game 3", 2);

	@ObfuscatedName("bp.m")
	public static final ModeGame field859 = new ModeGame("game4", "Game 4", 3);

	@ObfuscatedName("bp.c")
	public static final ModeGame field857 = new ModeGame("game5", "Game 5", 4);

	@ObfuscatedName("bp.n")
	public static final ModeGame field861 = new ModeGame("oldscape", "RuneScape 2007", 5);

	@ObfuscatedName("bp.j")
	public final int field862;

	@ObfuscatedName("bm.l(I)[Lbp;")
	public static ModeGame[] method902() {
		return new ModeGame[] { field857, field856, field860, field861, field859, field858 };
	}

	public ModeGame(String arg0, String arg1, int arg2) {
		this.field862 = arg2;
	}

	@ObfuscatedName("bp.r(B)I")
	public int method797() {
		return this.field862;
	}
}
