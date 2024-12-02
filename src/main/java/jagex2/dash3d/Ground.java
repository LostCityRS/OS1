package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.datastruct.Linkable;

@ObfuscatedName("es")
public class Ground extends Linkable {

	@ObfuscatedName("es.m")
	public int field1707;

	@ObfuscatedName("es.c")
	public int field1698;

	@ObfuscatedName("es.n")
	public int field1699;

	@ObfuscatedName("es.j")
	public int field1697;

	@ObfuscatedName("es.z")
	public TileUnderlay field1701;

	@ObfuscatedName("es.g")
	public TileOverlay field1705;

	@ObfuscatedName("es.q")
	public Wall field1703;

	@ObfuscatedName("es.i")
	public Decor field1704;

	@ObfuscatedName("es.s")
	public GroundDecor field1709;

	@ObfuscatedName("es.u")
	public GroundObject field1706;

	@ObfuscatedName("es.v")
	public int field1712;

	@ObfuscatedName("es.w")
	public Location[] field1700 = new Location[5];

	@ObfuscatedName("es.e")
	public int[] field1716 = new int[5];

	@ObfuscatedName("es.b")
	public int field1710 = 0;

	@ObfuscatedName("es.y")
	public int field1711;

	@ObfuscatedName("es.t")
	public boolean field1702;

	@ObfuscatedName("es.f")
	public boolean field1713;

	@ObfuscatedName("es.k")
	public boolean field1714;

	@ObfuscatedName("es.o")
	public int field1715;

	@ObfuscatedName("es.a")
	public int field1718;

	@ObfuscatedName("es.h")
	public int field1717;

	@ObfuscatedName("es.x")
	public int field1708;

	@ObfuscatedName("es.p")
	public Ground field1719;

	public Ground(int arg0, int arg1, int arg2) {
		this.field1697 = this.field1707 = arg0;
		this.field1698 = arg1;
		this.field1699 = arg2;
	}
}
