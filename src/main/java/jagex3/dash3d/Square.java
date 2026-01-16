package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable;

@ObfuscatedName("es")
public class Square extends Linkable {

	@ObfuscatedName("es.m")
	public int level;

	@ObfuscatedName("es.c")
	public int x;

	@ObfuscatedName("es.n")
	public int z;

	@ObfuscatedName("es.j")
	public int originalLevel;

	@ObfuscatedName("es.z")
	public QuickGround quickGround;

	@ObfuscatedName("es.g")
	public Ground ground;

	@ObfuscatedName("es.q")
	public Wall wall;

	@ObfuscatedName("es.i")
	public Decor decor;

	@ObfuscatedName("es.s")
	public GroundDecor groundDecor;

	@ObfuscatedName("es.u")
	public GroundObject groundObject;

	@ObfuscatedName("es.v")
	public int spriteCount;

	@ObfuscatedName("es.w")
	public Sprite[] sprites = new Sprite[5];

	@ObfuscatedName("es.e")
	public int[] spriteSpan = new int[5];

	@ObfuscatedName("es.b")
	public int spriteSpans = 0;

	@ObfuscatedName("es.y")
	public int drawLevel;

	@ObfuscatedName("es.t")
	public boolean drawFront;

	@ObfuscatedName("es.f")
	public boolean drawBack;

	@ObfuscatedName("es.k")
	public boolean drawSprites;

	@ObfuscatedName("es.o")
	public int checkLocSpans;

	@ObfuscatedName("es.a")
	public int blockLocSpans;

	@ObfuscatedName("es.h")
	public int inverseBlockLocSpans;

	@ObfuscatedName("es.x")
	public int backWallTypes;

	@ObfuscatedName("es.p")
	public Square linkedSquare;

	public Square(int arg0, int arg1, int arg2) {
		this.originalLevel = this.level = arg0;
		this.x = arg1;
		this.z = arg2;
	}
}
