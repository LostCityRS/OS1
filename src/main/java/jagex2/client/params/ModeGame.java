package jagex2.client.params;

import deob.ObfuscatedName;

@ObfuscatedName("bp")
public class ModeGame implements ModeGameProvider {

	@ObfuscatedName("bp.r")
	public static final ModeGame RUNESCAPE = new ModeGame("runescape", "RuneScape", 0);

	@ObfuscatedName("bp.d")
	public static final ModeGame STELLARDAWN = new ModeGame("stellardawn", "Stellar Dawn", 1);

	@ObfuscatedName("bp.l")
	public static final ModeGame ALTERNATEREALITY = new ModeGame("game3", "Game 3", 2);

	@ObfuscatedName("bp.m")
	public static final ModeGame TRANSFORMERS = new ModeGame("game4", "Game 4", 3);

	@ObfuscatedName("bp.c")
	public static final ModeGame SCRATCH = new ModeGame("game5", "Game 5", 4);

	@ObfuscatedName("bp.n")
	public static final ModeGame OLDSCAPE = new ModeGame("oldscape", "RuneScape 2007", 5);

	@ObfuscatedName("bp.j")
	public final int index;

	@ObfuscatedName("bm.l(I)[Lbp;")
	public static ModeGame[] values() {
		return new ModeGame[] { SCRATCH, STELLARDAWN, RUNESCAPE, OLDSCAPE, TRANSFORMERS, ALTERNATEREALITY };
	}

	public ModeGame(String arg0, String arg1, int arg2) {
		this.index = arg2;
	}

	@ObfuscatedName("bp.r(B)I")
	public int getIndex() {
		return this.index;
	}

	public static ModeGame get(int id) {
		ModeGame[] all = ModeGame.values();
		for (int i = 0; i < all.length; i++) {
			ModeGame mode = all[i];
			if (mode.getIndex() == id) {
				return mode;
			}
		}
		return null;
	}
}
