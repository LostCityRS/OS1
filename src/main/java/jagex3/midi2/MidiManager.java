package jagex3.midi2;

import deob.ObfuscatedName;
import jagex3.js5.Js5;
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

	// jag::oldscape::midi2::MidiManager::m_midiPlayers
	@ObfuscatedName("bd.m")
	public static MidiPlayer midiPlayer;

	@ObfuscatedName("bd.c")
	public static int state = 0;

	@ObfuscatedName("bd.n")
	public static Js5 midis;

	@ObfuscatedName("aa.j")
	public static int pendingGroupId;

	@ObfuscatedName("bd.z")
	public static int pendingFileId;

	@ObfuscatedName("bd.g")
	public static int pendingVolume;

	@ObfuscatedName("cl.q")
	public static int fadeOutRate;

	@ObfuscatedName("dl.i")
	public static boolean pendingLoop;

	@ObfuscatedName("bd.s")
	public static MidiFile loadingMidiFile;

	@ObfuscatedName("dr.u")
	public static WaveCache loadingWaveCache;

	public MidiManager() throws Throwable {
		throw new Error();
	}

	// jag::oldscape::midi2::MidiManager::Init
	@ObfuscatedName("dl.r(Lch;Lch;Lch;Led;B)Z")
	public static boolean init(Js5 arg0, Js5 arg1, Js5 arg2, MidiPlayer arg3) {
		patches = arg0;
		vorbis = arg1;
		jagFX = arg2;
		midiPlayer = arg3;
		return true;
	}

	// jag::oldscape::midi2::MidiManager::Play
	@ObfuscatedName("cu.d(Lch;IIIZI)V")
	public static void play(Js5 arg0, int arg1, int arg2, int arg3, boolean arg4) {
		state = 1;
		midis = arg0;
		pendingGroupId = arg1;
		pendingFileId = arg2;
		pendingVolume = arg3;
		pendingLoop = arg4;
		fadeOutRate = 10000;
	}

	// jag::oldscape::midi2::MidiManager::SetVolume
	@ObfuscatedName("i.l(II)V")
	public static void setVolume(int arg0) {
		if (state == 0) {
			midiPlayer.setGlobalVolume(arg0);
		} else {
			pendingVolume = arg0;
		}
	}

	// jag::oldscape::midi2::MidiManager::Stop
	@ObfuscatedName("bc.m(B)V")
	public static void stop() {
		midiPlayer.stop();
		state = 1;
		midis = null;
	}

	// jag::oldscape::midi2::MidiManager::SwapSongs
	@ObfuscatedName("q.c(ILch;IIIZI)V")
	public static void swapSongs(int arg0, Js5 arg1, int arg2, int arg3, int arg4, boolean arg5) {
		state = 1;
		midis = arg1;
		pendingGroupId = arg2;
		pendingFileId = arg3;
		pendingVolume = arg4;
		pendingLoop = arg5;
		fadeOutRate = arg0;
	}

	// jag::oldscape::midi2::MidiManager::IsInitialised
	@ObfuscatedName("eu.n(I)Z")
	public static boolean isInitialised() {
		return state == 0 ? midiPlayer.loaded() : true;
	}

	@ObfuscatedName("by.j(I)V")
	public static void updateFadeOut() {
		try {
			if (state == 1) {
				int var0 = midiPlayer.getGlobalVolume();
				if (var0 > 0 && midiPlayer.loaded()) {
					int var1 = var0 - fadeOutRate;
					if (var1 < 0) {
						var1 = 0;
					}
					midiPlayer.setGlobalVolume(var1);
					return;
				}

				midiPlayer.stop();
				midiPlayer.clearPatches();

				if (midis == null) {
					state = 0;
				} else {
					state = 2;
				}

				loadingMidiFile = null;
				loadingWaveCache = null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			midiPlayer.stop();
			state = 0;
			loadingMidiFile = null;
			loadingWaveCache = null;
			midis = null;
		}
	}

	@ObfuscatedName("ay.z(I)Z")
	public static boolean updateLoading() {
		try {
			if (state == 2) {
				if (loadingMidiFile == null) {
					loadingMidiFile = MidiFile.load(midis, pendingGroupId, pendingFileId);
					if (loadingMidiFile == null) {
						return false;
					}
				}

				if (loadingWaveCache == null) {
					loadingWaveCache = new WaveCache(jagFX, vorbis);
				}

				if (midiPlayer.loadAndQueuePatches(loadingMidiFile, patches, loadingWaveCache, 22050)) {
					midiPlayer.freeWaveIds();
					midiPlayer.setGlobalVolume(pendingVolume);
					midiPlayer.start(loadingMidiFile, pendingLoop);
					state = 0;
					loadingMidiFile = null;
					loadingWaveCache = null;
					midis = null;
					return true;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			midiPlayer.stop();
			state = 0;
			loadingMidiFile = null;
			loadingWaveCache = null;
			midis = null;
		}

		return false;
	}

	// jag::oldscape::midi2::MidiManager::Stop
	public static void stop2() {
		state = 1;
		midis = null;
		pendingGroupId = -1;
		pendingFileId = -1;
		pendingVolume = 0;
		pendingLoop = false;
		fadeOutRate = 2;
	}
}
