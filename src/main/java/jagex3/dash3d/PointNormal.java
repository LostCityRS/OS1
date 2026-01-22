package jagex3.dash3d;

import deob.ObfuscatedName;

// jag::oldscape::dash3d::PointNormal
@ObfuscatedName("ao")
public class PointNormal {

	@ObfuscatedName("ao.r")
	public int x;

	@ObfuscatedName("ao.d")
	public int y;

	@ObfuscatedName("ao.l")
	public int z;

	@ObfuscatedName("ao.m")
	public int w;

	public PointNormal() {
	}

	public PointNormal(PointNormal normal) {
		this.x = normal.x;
		this.y = normal.y;
		this.z = normal.z;
		this.w = normal.w;
	}
}
