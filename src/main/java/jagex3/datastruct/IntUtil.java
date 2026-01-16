package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("bo")
public class IntUtil {

	public IntUtil() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("av.r(IIB)I")
	public static int method430(int arg0, int arg1) {
		if (arg1 > arg0) {
			int var2 = arg0;
			arg0 = arg1;
			arg1 = var2;
		}
		while (arg1 != 0) {
			int var3 = arg0 % arg1;
			arg0 = arg1;
			arg1 = var3;
		}
		return arg0;
	}

	@ObfuscatedName("eg.d(IB)I")
	public static int bitCount(int arg0) {
		int var1 = (arg0 >>> 1 & 0x55555555) + (arg0 & 0x55555555);
		int var2 = (var1 >>> 2 & 0x33333333) + (var1 & 0x33333333);
		int var3 = (var2 >>> 4) + var2 & 0xF0F0F0F;
		int var4 = (var3 >>> 8) + var3;
		int var5 = (var4 >>> 16) + var4;
		return var5 & 0xFF;
	}

	@ObfuscatedName("az.l(IB)I")
	public static int ilog(int arg0) {
		int var1 = 0;
		if (arg0 < 0 || arg0 >= 65536) {
			arg0 >>>= 0x10;
			var1 += 16;
		}
		if (arg0 >= 256) {
			arg0 >>>= 0x8;
			var1 += 8;
		}
		if (arg0 >= 16) {
			arg0 >>>= 0x4;
			var1 += 4;
		}
		if (arg0 >= 4) {
			arg0 >>>= 0x2;
			var1 += 2;
		}
		if (arg0 >= 1) {
			arg0 >>>= 0x1;
			var1++;
		}
		return arg0 + var1;
	}
}
