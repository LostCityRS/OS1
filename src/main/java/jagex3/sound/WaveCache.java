package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.datastruct.HashTable;
import jagex3.js5.Js5;

// jag::oldscape::sound::WaveCache
@ObfuscatedName("a")
public class WaveCache {

	@ObfuscatedName("a.r")
	public Js5 synthArchive;

	@ObfuscatedName("a.d")
	public Js5 vorbisArchive;

	@ObfuscatedName("a.l")
	public HashTable vorbisCache = new HashTable(256);

	@ObfuscatedName("a.m")
	public HashTable waveCache = new HashTable(256);

	public WaveCache(Js5 arg0, Js5 arg1) {
		this.synthArchive = arg0;
		this.vorbisArchive = arg1;
	}

	@ObfuscatedName("a.r(II[II)Leq;")
	public Wave getJagFx(int arg0, int arg1, int[] arg2) {
		// todo: inlined hashAudioID?
		int var4 = arg1 ^ (arg0 << 4 & 0xFFFF | arg0 >>> 12);
		int var5 = var4 | arg0 << 16;
		long var6 = (long) var5;

		Wave var8 = (Wave) this.waveCache.get(var6);
		if (var8 != null) {
			return var8;
		} else if (arg2 == null || arg2[0] > 0) {
			JagFx var9 = JagFx.load(this.synthArchive, arg0, arg1);
			if (var9 == null) {
				return null;
			}
			Wave var10 = var9.toWave();
			this.waveCache.put(var10, var6);
			if (arg2 != null) {
				arg2[0] -= var10.samples.length;
			}
			return var10;
		} else {
			return null;
		}
	}

	@ObfuscatedName("a.d(II[II)Leq;")
	public Wave getJagVorbis(int arg0, int arg1, int[] arg2) {
		// todo: inlined hashAudioID?
		int var4 = arg1 ^ (arg0 << 4 & 0xFFFF | arg0 >>> 12);
		int var5 = var4 | arg0 << 16;
		long var6 = (long) var5 ^ 0x100000000L;

		Wave var8 = (Wave) this.waveCache.get(var6);
		if (var8 != null) {
			return var8;
		} else if (arg2 == null || arg2[0] > 0) {
			JagVorbis var9 = (JagVorbis) this.vorbisCache.get(var6);
			if (var9 == null) {
				var9 = JagVorbis.decode(this.vorbisArchive, arg0, arg1);
				if (var9 == null) {
					return null;
				}
				this.vorbisCache.put(var9, var6);
			}
			Wave var10 = var9.method1539(arg2);
			if (var10 == null) {
				return null;
			} else {
				var9.unlink();
				this.waveCache.put(var10, var6);
				return var10;
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("a.l(I[II)Leq;")
	public Wave getJagFx(int arg0, int[] arg1) {
		if (this.synthArchive.getGroupCount() == 1) {
			return this.getJagFx(0, arg0, arg1);
		} else if (this.synthArchive.getFileCount(arg0) == 1) {
			return this.getJagFx(arg0, 0, arg1);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("a.m(I[II)Leq;")
	public Wave getJagVorbis(int arg0, int[] arg1) {
		if (this.vorbisArchive.getGroupCount() == 1) {
			return this.getJagVorbis(0, arg0, arg1);
		} else if (this.vorbisArchive.getFileCount(arg0) == 1) {
			return this.getJagVorbis(arg0, 0, arg1);
		} else {
			throw new RuntimeException();
		}
	}
}
