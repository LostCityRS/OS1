package jagex3.io;

import deob.ObfuscatedName;

@ObfuscatedName("bv")
public class ByteArrayPool {

	@ObfuscatedName("bv.r")
	public static int cacheMinCount = 0;

	@ObfuscatedName("bv.d")
	public static int cacheMidCount = 0;

	@ObfuscatedName("bv.l")
	public static int cacheMaxCount = 0;

	@ObfuscatedName("bv.m")
	public static byte[][] cacheMin = new byte[1000][];

	@ObfuscatedName("bv.c")
	public static byte[][] cacheMid = new byte[250][];

	@ObfuscatedName("bv.n")
	public static byte[][] cacheMax = new byte[50][];

	public ByteArrayPool() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("bv.r(II)[B")
	public static synchronized byte[] alloc(int size) {
		if (size == 100 && cacheMinCount > 0) {
			byte[] data = cacheMin[--cacheMinCount];
			cacheMin[cacheMinCount] = null;
			return data;
		} else if (size == 5000 && cacheMidCount > 0) {
			byte[] data = cacheMid[--cacheMidCount];
			cacheMid[cacheMidCount] = null;
			return data;
		} else if (size == 30000 && cacheMaxCount > 0) {
			byte[] data = cacheMax[--cacheMaxCount];
			cacheMax[cacheMaxCount] = null;
			return data;
		} else {
			return new byte[size];
		}
	}
}
