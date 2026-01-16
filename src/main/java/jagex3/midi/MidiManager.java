package jagex3.midi;

import deob.ObfuscatedName;
import jagex3.js5.Js5;
import jagex3.js5.Js5Loader;
import jagex3.sound.WaveCache;

// jag::oldscape::midi2::MidiManager
@ObfuscatedName("bd")
public class MidiManager {

	// jag::oldscape::midi2::MidiManager::m_pPatches
	@ObfuscatedName("bd.r")
	public static Js5 patches;

	// jag::oldscape::midi2::MidiManager::m_pVorbis
	@ObfuscatedName("bd.d")
	public static Js5 vorbis;

	// jag::oldscape::midi2::MidiManager::m_pJagFX
	@ObfuscatedName("bd.l")
	public static Js5 jagFX;

	@ObfuscatedName("bd.m")
	public static MidiPlayer midiPlayer;

	@ObfuscatedName("bd.c")
	public static int field1117 = 0;

	@ObfuscatedName("bd.n")
	public static Js5 field1118;

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
	public static MidiFile field1113;

	@ObfuscatedName("dr.u")
	public static WaveCache field1586;

	public MidiManager() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("dl.r(Lch;Lch;Lch;Led;B)Z")
	public static boolean init(Js5 arg0, Js5 arg1, Js5 arg2, MidiPlayer arg3) {
		patches = arg0;
		vorbis = arg1;
		jagFX = arg2;
		midiPlayer = arg3;
		return true;
	}

	@ObfuscatedName("cu.d(Lch;IIIZI)V")
	public static void method1125(Js5 arg0, int arg1, int arg2, int arg3, boolean arg4) {
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
			midiPlayer.setVolume(arg0);
		} else {
			field1120 = arg0;
		}
	}

	@ObfuscatedName("bc.m(B)V")
	public static void method917() {
		midiPlayer.stop();
		field1117 = 1;
		field1118 = null;
	}

	@ObfuscatedName("q.c(ILch;IIIZI)V")
	public static void method95(int arg0, Js5 arg1, int arg2, int arg3, int arg4, boolean arg5) {
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
		return field1117 == 0 ? midiPlayer.loaded() : true;
	}

	@ObfuscatedName("by.j(I)V")
	public static void method825() {
		try {
			if (field1117 == 1) {
				int var0 = midiPlayer.getVolume();
				if (var0 > 0 && midiPlayer.loaded()) {
					int var1 = var0 - field1152;
					if (var1 < 0) {
						var1 = 0;
					}
					midiPlayer.setVolume(var1);
					return;
				}
				midiPlayer.stop();
				midiPlayer.method2289();
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
			midiPlayer.stop();
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
					field1113 = MidiFile.decode(field1118, field349, field1121);
					if (field1113 == null) {
						return false;
					}
				}
				if (field1586 == null) {
					field1586 = new WaveCache(jagFX, vorbis);
				}
				if (midiPlayer.method2196(field1113, patches, field1586, 22050)) {
					midiPlayer.method2220();
					midiPlayer.setVolume(field1120);
					midiPlayer.start(field1113, field1625);
					field1117 = 0;
					field1113 = null;
					field1586 = null;
					field1118 = null;
					return true;
				}
			}
		} catch (Exception var1) {
			var1.printStackTrace();
			midiPlayer.stop();
			field1117 = 0;
			field1113 = null;
			field1586 = null;
			field1118 = null;
		}
		return false;
	}

	public static void imethod1(Js5Loader var17) {
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
