package jagex3.client.ui;

import deob.ObfuscatedName;

@ObfuscatedName("cv")
public class ServerKeyEvents {

	public ServerKeyEvents() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("bh.r(II)Z")
	public static boolean isResumeEnabled(int events) {
		return (events & 0x1) != 0;
	}

	@ObfuscatedName("da.d(II)I")
	public static int getTargetMask(int events) {
		return events >> 11 & 0x3F;
	}

	@ObfuscatedName("az.l(II)I")
	public static int getDragDepth(int events) {
		return events >> 17 & 0x7;
	}

	@ObfuscatedName("bn.m(II)Z")
	public static boolean isObjSwapEnabled(int events) {
		return (events >> 28 & 0x1) != 0;
	}

	public static boolean isObjReplaceEnabled(int events) {
		return (events >> 29 & 0x1) != 0;
	}
}
