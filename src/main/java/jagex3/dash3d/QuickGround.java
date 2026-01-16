package jagex3.dash3d;

import deob.ObfuscatedName;

@ObfuscatedName("ai")
public class QuickGround {

	@ObfuscatedName("ai.r")
	public int colourSW;

	@ObfuscatedName("ai.d")
	public int colourSE;

	@ObfuscatedName("ai.l")
	public int colourNE;

	@ObfuscatedName("ai.m")
	public int colourNW;

	@ObfuscatedName("ai.c")
	public int texture;

	@ObfuscatedName("ai.n")
	public boolean flat = true;

	@ObfuscatedName("ai.j")
	public int minimapRgb;

	public QuickGround(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, boolean arg6) {
		this.colourSW = arg0;
		this.colourSE = arg1;
		this.colourNE = arg2;
		this.colourNW = arg3;
		this.texture = arg4;
		this.minimapRgb = arg5;
		this.flat = arg6;
	}
}
