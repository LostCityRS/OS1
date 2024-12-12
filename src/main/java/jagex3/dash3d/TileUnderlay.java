package jagex3.dash3d;

import deob.ObfuscatedName;

@ObfuscatedName("ai")
public class TileUnderlay {

	@ObfuscatedName("ai.r")
	public int southwestColour;

	@ObfuscatedName("ai.d")
	public int field692;

	@ObfuscatedName("ai.l")
	public int northEastColour;

	@ObfuscatedName("ai.m")
	public int field694;

	@ObfuscatedName("ai.c")
	public int textureId;

	@ObfuscatedName("ai.n")
	public boolean flat = true;

	@ObfuscatedName("ai.j")
	public int field697;

	public TileUnderlay(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6) {
		this.southwestColour = arg0;
		this.field692 = arg1;
		this.northEastColour = arg2;
		this.field694 = arg3;
		this.textureId = arg4;
		this.field697 = arg5;
		this.flat = arg6;
	}
}
