package jagex2.sound.midi;

import deob.ObfuscatedName;
import jagex2.js5.Js5Index;
import jagex2.js5.Js5Provider;

@ObfuscatedName("bd")
public class MidiPlayer {

	@ObfuscatedName("bd.r")
	public static Js5Index field1119;

	@ObfuscatedName("bd.d")
	public static Js5Index field1114;

	@ObfuscatedName("bd.l")
	public static Js5Index field1115;

	@ObfuscatedName("bd.m")
	public static MidiPcmStream field1116;

	@ObfuscatedName("bd.c")
	public static int field1117 = 0;

	@ObfuscatedName("bd.n")
	public static Js5Index field1118;

	@ObfuscatedName("aa.j")
	public static int field349;

	@ObfuscatedName("bd.z")
	public static int field1121;

	@ObfuscatedName("bd.g")
	public static int field1120;

	@ObfuscatedName("cl.q")
	public static int field1152;

	@ObfuscatedName("dl.i")
	public static boolean field1625;

	@ObfuscatedName("bd.s")
	public static Song field1113;

	@ObfuscatedName("dr.u")
	public static SoundBank field1586;

	public MidiPlayer() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("dl.r(Lch;Lch;Lch;Led;B)Z")
	public static boolean method1511(Js5Index arg0, Js5Index arg1, Js5Index arg2, MidiPcmStream arg3) {
		field1119 = arg0;
		field1114 = arg1;
		field1115 = arg2;
		field1116 = arg3;
		return true;
	}

	@ObfuscatedName("cu.d(Lch;IIIZI)V")
	public static void method1125(Js5Index arg0, int arg1, int arg2, int arg3, boolean arg4) {
		field1117 = 1;
		field1118 = arg0;
		field349 = arg1;
		field1121 = arg2;
		field1120 = arg3;
		field1625 = arg4;
		field1152 = 10000;
	}

	@ObfuscatedName("i.l(II)V")
	public static void method105(int arg0) {
		if (field1117 == 0) {
			field1116.method2206(arg0);
		} else {
			field1120 = arg0;
		}
	}

	@ObfuscatedName("bc.m(B)V")
	public static void method917() {
		field1116.method2290();
		field1117 = 1;
		field1118 = null;
	}

	@ObfuscatedName("q.c(ILch;IIIZI)V")
	public static void method95(int arg0, Js5Index arg1, int arg2, int arg3, int arg4, boolean arg5) {
		field1117 = 1;
		field1118 = arg1;
		field349 = arg2;
		field1121 = arg3;
		field1120 = arg4;
		field1625 = arg5;
		field1152 = arg0;
	}

	@ObfuscatedName("eu.n(I)Z")
	public static boolean method2456() {
		return field1117 == 0 ? field1116.method2200() : true;
	}

	@ObfuscatedName("by.j(I)V")
	public static void method825() {
		try {
			if (field1117 == 1) {
				int var0 = field1116.method2254();
				if (var0 > 0 && field1116.method2200()) {
					int var1 = var0 - field1152;
					if (var1 < 0) {
						var1 = 0;
					}
					field1116.method2206(var1);
					return;
				}
				field1116.method2290();
				field1116.method2289();
				if (field1118 == null) {
					field1117 = 0;
				} else {
					field1117 = 2;
				}
				field1113 = null;
				field1586 = null;
			}
		} catch (Exception var3) {
			var3.printStackTrace();
			field1116.method2290();
			field1117 = 0;
			field1113 = null;
			field1586 = null;
			field1118 = null;
		}
	}

	@ObfuscatedName("ay.z(I)Z")
	public static boolean method511() {
		try {
			if (field1117 == 2) {
				if (field1113 == null) {
					field1113 = Song.method1775(field1118, field349, field1121);
					if (field1113 == null) {
						return false;
					}
				}
				if (field1586 == null) {
					field1586 = new SoundBank(field1115, field1114);
				}
				if (field1116.method2196(field1113, field1119, field1586, 22050)) {
					field1116.method2220();
					field1116.method2206(field1120);
					field1116.method2199(field1113, field1625);
					field1117 = 0;
					field1113 = null;
					field1586 = null;
					field1118 = null;
					return true;
				}
			}
		} catch (Exception var1) {
			var1.printStackTrace();
			field1116.method2290();
			field1117 = 0;
			field1113 = null;
			field1586 = null;
			field1118 = null;
		}
		return false;
	}

	public static void imethod1(Js5Provider var17) {
		int var18 = var17.getGroupId("scape main");
		int var19 = var17.getFileId(var18, "");
		method95(2, var17, var18, var19, 255, false);
	}

	public static void imethod2() {
		field1117 = 1;
		field1118 = null;
		field349 = -1;
		field1121 = -1;
		field1120 = 0;
		field1625 = false;
		field1152 = 2;
	}
}
