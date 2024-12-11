package jagex2.dash3d.entity;

import deob.ObfuscatedName;
import jagex2.datastruct.Linkable;

@ObfuscatedName("dn")
public class LocSpawned extends Linkable {

	@ObfuscatedName("dn.m")
	public int level;

	@ObfuscatedName("dn.c")
	public int layer;

	@ObfuscatedName("dn.n")
	public int localX;

	@ObfuscatedName("dn.j")
	public int localZ;

	@ObfuscatedName("dn.z")
	public int previousType;

	@ObfuscatedName("dn.g")
	public int previousRotation;

	@ObfuscatedName("dn.q")
	public int previousShape;

	@ObfuscatedName("dn.i")
	public int type;

	@ObfuscatedName("dn.s")
	public int rotation;

	@ObfuscatedName("dn.u")
	public int shape;

	@ObfuscatedName("dn.v")
	public int delay = 0;

	@ObfuscatedName("dn.w")
	public int duration = -1;
}
