package jagex2.client;

import deob.ObfuscatedName;

@ObfuscatedName("da")
public class Namespace {

	@ObfuscatedName("da.r")
	public static final Namespace OLDSCAPE = new Namespace(6, 0, "", "");

	@ObfuscatedName("da.d")
	public static final Namespace field1521 = new Namespace(1, 1, "", "");

	@ObfuscatedName("da.l")
	public static final Namespace field1520 = new Namespace(7, 2, "", "");

	@ObfuscatedName("da.m")
	public static final Namespace field1524 = new Namespace(0, 3, "", "");

	@ObfuscatedName("da.c")
	public static final Namespace field1522 = new Namespace(5, 4, "", "");

	@ObfuscatedName("da.n")
	public static final Namespace field1523 = new Namespace(3, 5, "", "");

	@ObfuscatedName("da.j")
	public static final Namespace field1519 = new Namespace(2, 6, "", "");

	@ObfuscatedName("da.z")
	public static final Namespace LEGACY = new Namespace(4, -1, "", "", true, new Namespace[] { OLDSCAPE, field1521, field1520, field1522, field1524 });

	@ObfuscatedName("da.g")
	public final int field1526;

	@ObfuscatedName("da.q")
	public final String field1518;

	public Namespace(int arg0, int arg1, String arg2, String arg3) {
		this.field1526 = arg0;
		this.field1518 = arg3;
	}

	public Namespace(int arg0, int arg1, String arg2, String arg3, boolean arg4, Namespace[] arg5) {
		this.field1526 = arg0;
		this.field1518 = arg3;
	}

	public String toString() {
		return this.field1518;
	}
}
