package jagex2.sound;

import deob.ObfuscatedName;
import jagex2.datastruct.HashTable;
import jagex2.js5.Js5Index;

@ObfuscatedName("a")
public class SoundBank {

	@ObfuscatedName("a.r")
	public Js5Index field313;

	@ObfuscatedName("a.d")
	public Js5Index field311;

	@ObfuscatedName("a.l")
	public HashTable field310 = new HashTable(256);

	@ObfuscatedName("a.m")
	public HashTable field312 = new HashTable(256);

	public SoundBank(Js5Index arg0, Js5Index arg1) {
		this.field313 = arg0;
		this.field311 = arg1;
	}

	@ObfuscatedName("a.r(II[II)Leq;")
	public PcmSound method303(int arg0, int arg1, int[] arg2) {
		int var4 = arg1 ^ (arg0 << 4 & 0xFFFF | arg0 >>> 12);
		int var5 = var4 | arg0 << 16;
		long var6 = (long) var5;
		PcmSound var8 = (PcmSound) this.field312.get(var6);
		if (var8 != null) {
			return var8;
		} else if (arg2 == null || arg2[0] > 0) {
			Wave var9 = Wave.method294(this.field313, arg0, arg1);
			if (var9 == null) {
				return null;
			}
			PcmSound var10 = var9.method291();
			this.field312.put(var10, var6);
			if (arg2 != null) {
				arg2[0] -= var10.field2204.length;
			}
			return var10;
		} else {
			return null;
		}
	}

	@ObfuscatedName("a.d(II[II)Leq;")
	public PcmSound method304(int arg0, int arg1, int[] arg2) {
		int var4 = arg1 ^ (arg0 << 4 & 0xFFFF | arg0 >>> 12);
		int var5 = var4 | arg0 << 16;
		long var6 = (long) var5 ^ 0x100000000L;
		PcmSound var8 = (PcmSound) this.field312.get(var6);
		if (var8 != null) {
			return var8;
		} else if (arg2 == null || arg2[0] > 0) {
			VorbisSound var9 = (VorbisSound) this.field310.get(var6);
			if (var9 == null) {
				var9 = VorbisSound.method1543(this.field311, arg0, arg1);
				if (var9 == null) {
					return null;
				}
				this.field310.put(var9, var6);
			}
			PcmSound var10 = var9.method1539(arg2);
			if (var10 == null) {
				return null;
			} else {
				var9.unlink();
				this.field312.put(var10, var6);
				return var10;
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("a.l(I[II)Leq;")
	public PcmSound method305(int arg0, int[] arg1) {
		if (this.field313.method1055() == 1) {
			return this.method303(0, arg0, arg1);
		} else if (this.field313.method1054(arg0) == 1) {
			return this.method303(arg0, 0, arg1);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("a.m(I[II)Leq;")
	public PcmSound method309(int arg0, int[] arg1) {
		if (this.field311.method1055() == 1) {
			return this.method304(0, arg0, arg1);
		} else if (this.field311.method1054(arg0) == 1) {
			return this.method304(arg0, 0, arg1);
		} else {
			throw new RuntimeException();
		}
	}
}
