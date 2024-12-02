package jagex2.datastruct;

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

	@ObfuscatedName("az.l(IB)I")
	public static int method479(int arg0) {
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
