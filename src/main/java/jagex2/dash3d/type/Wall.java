package jagex2.dash3d.type;

import deob.ObfuscatedName;
import jagex2.dash3d.entity.Entity;

@ObfuscatedName("at")
public class Wall {

	@ObfuscatedName("at.r")
	public int y;

	@ObfuscatedName("at.d")
	public int x;

	@ObfuscatedName("at.l")
	public int z;

	@ObfuscatedName("at.m")
	public int typeA;

	@ObfuscatedName("at.c")
	public int typeB;

	@ObfuscatedName("at.n")
	public Entity modelA;

	@ObfuscatedName("at.j")
	public Entity modelB;

	@ObfuscatedName("at.z")
	public int bitset = 0;

	@ObfuscatedName("at.g")
	public int info = 0;
}
