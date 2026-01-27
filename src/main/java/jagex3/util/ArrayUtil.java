package jagex3.util;

import deob.ObfuscatedName;

@ObfuscatedName("bj")
public class ArrayUtil {

	public ArrayUtil() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("bj.q([III)V")
	public static void clear(int[] arg0, int arg1, int arg2) {
		int var3 = arg1 + arg2 - 7;
		while (arg1 < var3) {
			arg0[arg1++] = 0;
			arg0[arg1++] = 0;
			arg0[arg1++] = 0;
			arg0[arg1++] = 0;
			arg0[arg1++] = 0;
			arg0[arg1++] = 0;
			arg0[arg1++] = 0;
			arg0[arg1++] = 0;
		}
		var3 += 7;
		while (arg1 < var3) {
			arg0[arg1++] = 0;
		}
	}
}
