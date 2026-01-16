package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.client.Client;
import jagex3.config.LocType;
import jagex3.datastruct.LinkList;
import jagex3.datastruct.Linkable;

// jag::oldscape::bgsound
@ObfuscatedName("de")
public class BgSound extends Linkable {

	@ObfuscatedName("de.m")
	public static LinkList sounds = new LinkList();

	@ObfuscatedName("de.c")
	public int level;

	@ObfuscatedName("de.n")
	public int minX;

	@ObfuscatedName("de.j")
	public int minZ;

	@ObfuscatedName("de.z")
	public int maxX;

	@ObfuscatedName("de.g")
	public int maxZ;

	@ObfuscatedName("de.q")
	public int range;

	@ObfuscatedName("de.i")
	public int sound;

	@ObfuscatedName("de.s")
	public int mindelay;

	@ObfuscatedName("de.u")
	public WaveStream field1603;

	@ObfuscatedName("de.v")
	public int maxdelay;

	@ObfuscatedName("de.w")
	public int[] random;

	@ObfuscatedName("de.e")
	public int field1613;

	@ObfuscatedName("de.b")
	public WaveStream field1614;

	@ObfuscatedName("de.y")
	public LocType multiloc;

	@ObfuscatedName("az.c(B)V")
	public static void computeAllProperties() {
		for (BgSound var0 = (BgSound) sounds.head(); var0 != null; var0 = (BgSound) sounds.next()) {
			if (var0.multiloc != null) {
				var0.computeProperties();
			}
		}
	}

	@ObfuscatedName("de.n(I)V")
	public void computeProperties() {
		int sound = this.sound;

		LocType loc = this.multiloc.getMultiLoc();
		if (loc == null) {
			this.sound = -1;
			this.range = 0;
			this.mindelay = 0;
			this.maxdelay = 0;
			this.random = null;
		} else {
			this.sound = loc.bgsound_sound;
			this.range = loc.bgsound_range * 128;
			this.mindelay = loc.bgsound_mindelay;
			this.maxdelay = loc.bgsound_maxdelay;
			this.random = loc.bgsound_random;
		}

		if (this.sound != sound && this.field1603 != null) {
			Client.soundMixer.stopStream(this.field1603);
			this.field1603 = null;
		}
	}

	@ObfuscatedName("bs.j(IIILey;IB)V")
	public static void method763(int arg0, int arg1, int arg2, LocType arg3, int arg4) {
		BgSound bg = new BgSound();
		bg.level = arg0;
		bg.minX = arg1 * 128;
		bg.minZ = arg2 * 128;
		int var6 = arg3.width;
		int var7 = arg3.length;
		if (arg4 == 1 || arg4 == 3) {
			var6 = arg3.length;
			var7 = arg3.width;
		}
		bg.maxX = (arg1 + var6) * 128;
		bg.maxZ = (arg2 + var7) * 128;
		bg.sound = arg3.bgsound_sound;
		bg.range = arg3.bgsound_range * 128;
		bg.mindelay = arg3.bgsound_mindelay;
		bg.maxdelay = arg3.bgsound_maxdelay;
		bg.random = arg3.bgsound_random;
		if (arg3.multiloc != null) {
			bg.multiloc = arg3;
			bg.computeProperties();
		}
		sounds.push(bg);
		if (bg.random != null) {
			bg.field1613 = bg.mindelay + (int) (Math.random() * (double) (bg.maxdelay - bg.mindelay));
		}
	}

	@ObfuscatedName("ex.z(IIIII)V")
	public static void method2297(int arg0, int arg1, int arg2, int arg3) {
		for (BgSound var4 = (BgSound) sounds.head(); var4 != null; var4 = (BgSound) sounds.next()) {
			if (var4.sound != -1 || var4.random != null) {
				int var5 = 0;
				if (arg1 > var4.maxX) {
					var5 += arg1 - var4.maxX;
				} else if (arg1 < var4.minX) {
					var5 += var4.minX - arg1;
				}
				if (arg2 > var4.maxZ) {
					var5 += arg2 - var4.maxZ;
				} else if (arg2 < var4.minZ) {
					var5 += var4.minZ - arg2;
				}
				if (var5 - 64 > var4.range || Client.field2174 == 0 || var4.level != arg0) {
					if (var4.field1603 != null) {
						Client.soundMixer.stopStream(var4.field1603);
						var4.field1603 = null;
					}
					if (var4.field1614 != null) {
						Client.soundMixer.stopStream(var4.field1614);
						var4.field1614 = null;
					}
				} else {
					var5 -= 64;
					if (var5 < 0) {
						var5 = 0;
					}
					int var6 = Client.field2174 * (var4.range - var5) / var4.range;
					if (var4.field1603 != null) {
						var4.field1603.method2090(var6);
					} else if (var4.sound >= 0) {
						JagFx var7 = JagFx.generate(Client.soundFxJs5, var4.sound, 0);
						if (var7 != null) {
							Wave var8 = var7.toWave().decimate(Client.soundDecimator);
							WaveStream var9 = WaveStream.method2144(var8, 100, var6);
							var9.setLoopCount(-1);
							Client.soundMixer.playStream(var9);
							var4.field1603 = var9;
						}
					}
					if (var4.field1614 != null) {
						var4.field1614.method2090(var6);
						if (!var4.field1614.isLinked()) {
							var4.field1614 = null;
						}
					} else if (var4.random != null && (var4.field1613 -= arg3) <= 0) {
						int var10 = (int) (Math.random() * (double) var4.random.length);
						JagFx var11 = JagFx.generate(Client.soundFxJs5, var4.random[var10], 0);
						if (var11 != null) {
							Wave var12 = var11.toWave().decimate(Client.soundDecimator);
							WaveStream var13 = WaveStream.method2144(var12, 100, var6);
							var13.setLoopCount(0);
							Client.soundMixer.playStream(var13);
							var4.field1614 = var13;
							var4.field1613 = var4.mindelay + (int) (Math.random() * (double) (var4.maxdelay - var4.mindelay));
						}
					}
				}
			}
		}
	}
}
