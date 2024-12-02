package jagex2.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("bv")
public class ByteArrayPool {

	@ObfuscatedName("bv.r")
	public static int field746 = 0;

	@ObfuscatedName("bv.d")
	public static int field745 = 0;

	@ObfuscatedName("bv.l")
	public static int field748 = 0;

	@ObfuscatedName("bv.m")
	public static byte[][] field747 = new byte[1000][];

	@ObfuscatedName("bv.c")
	public static byte[][] field749 = new byte[250][];

	@ObfuscatedName("bv.n")
	public static byte[][] field744 = new byte[50][];

	public ByteArrayPool() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("bv.r(II)[B")
	public static synchronized byte[] method773(int arg0) {
		if (arg0 == 100 && field746 > 0) {
			byte[] var1 = field747[--field746];
			field747[field746] = null;
			return var1;
		} else if (arg0 == 5000 && field745 > 0) {
			byte[] var2 = field749[--field745];
			field749[field745] = null;
			return var2;
		} else if (arg0 == 30000 && field748 > 0) {
			byte[] var3 = field744[--field748];
			field744[field748] = null;
			return var3;
		} else {
			return new byte[arg0];
		}
	}
}
