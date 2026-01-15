package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable;

@ObfuscatedName("dn")
public class LocChange extends Linkable {

	@ObfuscatedName("dn.m")
	public int level;

	@ObfuscatedName("dn.c")
	public int layer;

	@ObfuscatedName("dn.n")
	public int x;

	@ObfuscatedName("dn.j")
	public int z;

	@ObfuscatedName("dn.z")
	public int oldType;

	@ObfuscatedName("dn.g")
	public int oldAngle;

	@ObfuscatedName("dn.q")
	public int oldShape;

	@ObfuscatedName("dn.i")
	public int newType;

	@ObfuscatedName("dn.s")
	public int newAngle;

	@ObfuscatedName("dn.u")
	public int newShape;

	@ObfuscatedName("dn.v")
	public int startTime = 0;

	@ObfuscatedName("dn.w")
	public int endTime = -1;
}
