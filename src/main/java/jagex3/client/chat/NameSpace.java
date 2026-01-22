package jagex3.client.chat;

import deob.ObfuscatedName;

@ObfuscatedName("da")
public class NameSpace {

	@ObfuscatedName("da.r")
	public static final NameSpace RUNESCAPE = new NameSpace(6, 0, "", "");

	@ObfuscatedName("da.d")
	public static final NameSpace FUNORB = new NameSpace(1, 1, "", "");

	@ObfuscatedName("da.l")
	public static final NameSpace WAR_OF_LEGENDS = new NameSpace(7, 2, "", "");

	@ObfuscatedName("da.m")
	public static final NameSpace STELLAR_DAWN = new NameSpace(0, 3, "", "");

	@ObfuscatedName("da.c")
	public static final NameSpace EIGHT_REALMS = new NameSpace(5, 4, "", "");

	@ObfuscatedName("da.n")
	public static final NameSpace TRANSFORMERS = new NameSpace(3, 5, "", "");

	@ObfuscatedName("da.j")
	public static final NameSpace SCRATCH = new NameSpace(2, 6, "", "");

	@ObfuscatedName("da.z")
	public static final NameSpace LEGACY = new NameSpace(4, -1, "", "", true, new NameSpace[] {
		RUNESCAPE,
		FUNORB,
		WAR_OF_LEGENDS,
		EIGHT_REALMS,
		STELLAR_DAWN
	});

	@ObfuscatedName("da.g")
	public final int ordinal;

	@ObfuscatedName("da.q")
	public final String name;

	public NameSpace(int ordinal, int id, String arg2, String name) {
		this.ordinal = ordinal;
		this.name = name;
	}

	public NameSpace(int ordinal, int id, String arg2, String name, boolean arg4, NameSpace[] arg5) {
		this.ordinal = ordinal;
		this.name = name;
	}

	public String toString() {
		return this.name;
	}
}
