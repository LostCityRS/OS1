package jagex2.sound;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.js5.Js5Index;

@ObfuscatedName("bd")
public class MidiPlayer {

	@ObfuscatedName("bd.c")
	public static int field1117 = 0;

	public MidiPlayer() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("dl.r(Lch;Lch;Lch;Led;B)Z")
	public static boolean method1511(Js5Index arg0, Js5Index arg1, Js5Index arg2, MidiPcmStream arg3) {
		Statics.field1119 = arg0;
		Statics.field1114 = arg1;
		Statics.field1115 = arg2;
		Statics.field1116 = arg3;
		return true;
	}

	@ObfuscatedName("cu.d(Lch;IIIZI)V")
	public static void method1125(Js5Index arg0, int arg1, int arg2, int arg3, boolean arg4) {
		field1117 = 1;
		Statics.field1118 = arg0;
		Statics.field349 = arg1;
		Statics.field1121 = arg2;
		Statics.field1120 = arg3;
		Statics.field1625 = arg4;
		Statics.field1152 = 10000;
	}

	@ObfuscatedName("i.l(II)V")
	public static void method105(int arg0) {
		if (field1117 == 0) {
			Statics.field1116.method2206(arg0);
		} else {
			Statics.field1120 = arg0;
		}
	}

	@ObfuscatedName("bc.m(B)V")
	public static void method917() {
		Statics.field1116.method2290();
		field1117 = 1;
		Statics.field1118 = null;
	}

	@ObfuscatedName("q.c(ILch;IIIZI)V")
	public static void method95(int arg0, Js5Index arg1, int arg2, int arg3, int arg4, boolean arg5) {
		field1117 = 1;
		Statics.field1118 = arg1;
		Statics.field349 = arg2;
		Statics.field1121 = arg3;
		Statics.field1120 = arg4;
		Statics.field1625 = arg5;
		Statics.field1152 = arg0;
	}

	@ObfuscatedName("eu.n(I)Z")
	public static boolean method2456() {
		return field1117 == 0 ? Statics.field1116.method2200() : true;
	}

	@ObfuscatedName("by.j(I)V")
	public static void method825() {
		try {
			if (field1117 == 1) {
				int var0 = Statics.field1116.method2254();
				if (var0 > 0 && Statics.field1116.method2200()) {
					int var1 = var0 - Statics.field1152;
					if (var1 < 0) {
						var1 = 0;
					}
					Statics.field1116.method2206(var1);
					return;
				}
				Statics.field1116.method2290();
				Statics.field1116.method2289();
				if (Statics.field1118 == null) {
					field1117 = 0;
				} else {
					field1117 = 2;
				}
				Statics.field1113 = null;
				Statics.field1586 = null;
			}
		} catch (Exception var3) {
			var3.printStackTrace();
			Statics.field1116.method2290();
			field1117 = 0;
			Statics.field1113 = null;
			Statics.field1586 = null;
			Statics.field1118 = null;
		}
	}

	@ObfuscatedName("ay.z(I)Z")
	public static boolean method511() {
		try {
			if (field1117 == 2) {
				if (Statics.field1113 == null) {
					Statics.field1113 = Song.method1775(Statics.field1118, Statics.field349, Statics.field1121);
					if (Statics.field1113 == null) {
						return false;
					}
				}
				if (Statics.field1586 == null) {
					Statics.field1586 = new SoundBank(Statics.field1115, Statics.field1114);
				}
				if (Statics.field1116.method2196(Statics.field1113, Statics.field1119, Statics.field1586, 22050)) {
					Statics.field1116.method2220();
					Statics.field1116.method2206(Statics.field1120);
					Statics.field1116.method2199(Statics.field1113, Statics.field1625);
					field1117 = 0;
					Statics.field1113 = null;
					Statics.field1586 = null;
					Statics.field1118 = null;
					return true;
				}
			}
		} catch (Exception var1) {
			var1.printStackTrace();
			Statics.field1116.method2290();
			field1117 = 0;
			Statics.field1113 = null;
			Statics.field1586 = null;
			Statics.field1118 = null;
		}
		return false;
	}
}
