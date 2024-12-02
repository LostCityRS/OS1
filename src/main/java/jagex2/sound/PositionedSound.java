package jagex2.sound;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.config.LocType;
import jagex2.datastruct.LinkList;
import jagex2.datastruct.Linkable;

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
		for (PositionedSound var0 = (PositionedSound) field1612.method1297(); var0 != null; var0 = (PositionedSound) field1612.method1299()) {
			if (var0.field1615 != null) {
				var0.method1492();
			}
		}
	}

	@ObfuscatedName("de.n(I)V")
	public void method1492() {
		int var1 = this.field1608;
		LocType var2 = this.field1615.method2368();
		if (var2 == null) {
			this.field1608 = -1;
			this.field1607 = 0;
			this.field1601 = 0;
			this.field1611 = 0;
			this.field1604 = null;
		} else {
			this.field1608 = var2.field2312;
			this.field1607 = var2.field2348 * 128;
			this.field1601 = var2.field2349;
			this.field1611 = var2.field2302;
			this.field1604 = var2.field2351;
		}
		if (this.field1608 != var1 && this.field1603 != null) {
			Statics.field1460.method2175(this.field1603);
			this.field1603 = null;
		}
	}

	@ObfuscatedName("bs.j(IIILey;IB)V")
	public static void method763(int arg0, int arg1, int arg2, LocType arg3, int arg4) {
		PositionedSound var5 = new PositionedSound();
		var5.field1602 = arg0;
		var5.field1609 = arg1 * 128;
		var5.field1606 = arg2 * 128;
		int var6 = arg3.field2344;
		int var7 = arg3.field2318;
		if (arg4 == 1 || arg4 == 3) {
			var6 = arg3.field2318;
			var7 = arg3.field2344;
		}
		var5.field1605 = (arg1 + var6) * 128;
		var5.field1610 = (arg2 + var7) * 128;
		var5.field1608 = arg3.field2312;
		var5.field1607 = arg3.field2348 * 128;
		var5.field1601 = arg3.field2349;
		var5.field1611 = arg3.field2302;
		var5.field1604 = arg3.field2351;
		if (arg3.field2317 != null) {
			var5.field1615 = arg3;
			var5.method1492();
		}
		field1612.method1292(var5);
		if (var5.field1604 != null) {
			var5.field1613 = var5.field1601 + (int) (Math.random() * (double) (var5.field1611 - var5.field1601));
		}
	}
}
