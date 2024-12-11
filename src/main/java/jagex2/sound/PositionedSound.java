package jagex2.sound;

import deob.ObfuscatedName;
import jagex2.client.Client;
import jagex2.config.LocType;
import jagex2.datastruct.LinkList;
import jagex2.datastruct.Linkable;
import jagex2.sound.synth.Wave;

@ObfuscatedName("de")
public class PositionedSound extends Linkable {

	@ObfuscatedName("de.m")
	public static LinkList field1612 = new LinkList();

	@ObfuscatedName("de.c")
	public int field1602;

	@ObfuscatedName("de.n")
	public int field1609;

	@ObfuscatedName("de.j")
	public int field1606;

	@ObfuscatedName("de.z")
	public int field1605;

	@ObfuscatedName("de.g")
	public int field1610;

	@ObfuscatedName("de.q")
	public int field1607;

	@ObfuscatedName("de.i")
	public int field1608;

	@ObfuscatedName("de.s")
	public int field1601;

	@ObfuscatedName("de.u")
	public SoundPcmStream field1603;

	@ObfuscatedName("de.v")
	public int field1611;

	@ObfuscatedName("de.w")
	public int[] field1604;

	@ObfuscatedName("de.e")
	public int field1613;

	@ObfuscatedName("de.b")
	public SoundPcmStream field1614;

	@ObfuscatedName("de.y")
	public LocType field1615;

	@ObfuscatedName("az.c(B)V")
	public static void method478() {
		for (PositionedSound var0 = (PositionedSound) field1612.head(); var0 != null; var0 = (PositionedSound) field1612.next()) {
			if (var0.field1615 != null) {
				var0.method1492();
			}
		}
	}

	@ObfuscatedName("de.n(I)V")
	public void method1492() {
		int var1 = this.field1608;
		LocType var2 = this.field1615.getMultiLoc();
		if (var2 == null) {
			this.field1608 = -1;
			this.field1607 = 0;
			this.field1601 = 0;
			this.field1611 = 0;
			this.field1604 = null;
		} else {
			this.field1608 = var2.bgsound_sound;
			this.field1607 = var2.bgsound_range * 128;
			this.field1601 = var2.bgsound_mindelay;
			this.field1611 = var2.bgsound_maxdelay;
			this.field1604 = var2.bgsound_random;
		}
		if (this.field1608 != var1 && this.field1603 != null) {
			Client.field1460.method2175(this.field1603);
			this.field1603 = null;
		}
	}

	@ObfuscatedName("bs.j(IIILey;IB)V")
	public static void method763(int arg0, int arg1, int arg2, LocType arg3, int arg4) {
		PositionedSound var5 = new PositionedSound();
		var5.field1602 = arg0;
		var5.field1609 = arg1 * 128;
		var5.field1606 = arg2 * 128;
		int var6 = arg3.width;
		int var7 = arg3.length;
		if (arg4 == 1 || arg4 == 3) {
			var6 = arg3.length;
			var7 = arg3.width;
		}
		var5.field1605 = (arg1 + var6) * 128;
		var5.field1610 = (arg2 + var7) * 128;
		var5.field1608 = arg3.bgsound_sound;
		var5.field1607 = arg3.bgsound_range * 128;
		var5.field1601 = arg3.bgsound_mindelay;
		var5.field1611 = arg3.bgsound_maxdelay;
		var5.field1604 = arg3.bgsound_random;
		if (arg3.multiloc != null) {
			var5.field1615 = arg3;
			var5.method1492();
		}
		field1612.push(var5);
		if (var5.field1604 != null) {
			var5.field1613 = var5.field1601 + (int) (Math.random() * (double) (var5.field1611 - var5.field1601));
		}
	}

	@ObfuscatedName("ex.z(IIIII)V")
	public static void method2297(int arg0, int arg1, int arg2, int arg3) {
		for (PositionedSound var4 = (PositionedSound) field1612.head(); var4 != null; var4 = (PositionedSound) field1612.next()) {
			if (var4.field1608 != -1 || var4.field1604 != null) {
				int var5 = 0;
				if (arg1 > var4.field1605) {
					var5 += arg1 - var4.field1605;
				} else if (arg1 < var4.field1609) {
					var5 += var4.field1609 - arg1;
				}
				if (arg2 > var4.field1610) {
					var5 += arg2 - var4.field1610;
				} else if (arg2 < var4.field1606) {
					var5 += var4.field1606 - arg2;
				}
				if (var5 - 64 > var4.field1607 || Client.field2174 == 0 || var4.field1602 != arg0) {
					if (var4.field1603 != null) {
						Client.field1460.method2175(var4.field1603);
						var4.field1603 = null;
					}
					if (var4.field1614 != null) {
						Client.field1460.method2175(var4.field1614);
						var4.field1614 = null;
					}
				} else {
					var5 -= 64;
					if (var5 < 0) {
						var5 = 0;
					}
					int var6 = Client.field2174 * (var4.field1607 - var5) / var4.field1607;
					if (var4.field1603 != null) {
						var4.field1603.method2090(var6);
					} else if (var4.field1608 >= 0) {
						Wave var7 = Wave.method294(Client.synthSoundJs5, var4.field1608, 0);
						if (var7 != null) {
							PcmSound var8 = var7.method291().method2050(Client.field1733);
							SoundPcmStream var9 = SoundPcmStream.method2144(var8, 100, var6);
							var9.method2061(-1);
							Client.field1460.method2174(var9);
							var4.field1603 = var9;
						}
					}
					if (var4.field1614 != null) {
						var4.field1614.method2090(var6);
						if (!var4.field1614.isLinked()) {
							var4.field1614 = null;
						}
					} else if (var4.field1604 != null && (var4.field1613 -= arg3) <= 0) {
						int var10 = (int) (Math.random() * (double) var4.field1604.length);
						Wave var11 = Wave.method294(Client.synthSoundJs5, var4.field1604[var10], 0);
						if (var11 != null) {
							PcmSound var12 = var11.method291().method2050(Client.field1733);
							SoundPcmStream var13 = SoundPcmStream.method2144(var12, 100, var6);
							var13.method2061(0);
							Client.field1460.method2174(var13);
							var4.field1614 = var13;
							var4.field1613 = var4.field1601 + (int) (Math.random() * (double) (var4.field1611 - var4.field1601));
						}
					}
				}
			}
		}
	}
}
