package jagex2.client;

import deob.ObfuscatedName;

@ObfuscatedName("cv")
public class WorldEntrySettings {

	public WorldEntrySettings() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("bh.r(II)Z")
	public static boolean method745(int arg0) {
		return (arg0 & 0x1) != 0;
	}

	@ObfuscatedName("da.d(II)I")
	public static int method1350(int arg0) {
		return arg0 >> 11 & 0x3F;
	}

	@ObfuscatedName("az.l(II)I")
	public static int method480(int arg0) {
		return arg0 >> 17 & 0x7;
	}

	@ObfuscatedName("bn.m(II)Z")
	public static boolean method904(int arg0) {
		return (arg0 >> 28 & 0x1) != 0;
	}

	public static boolean imethod1(int var491) {
		return (var491 >> 29 & 0x1) != 0;
	}
}
