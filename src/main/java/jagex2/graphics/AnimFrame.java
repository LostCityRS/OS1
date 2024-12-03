package jagex2.graphics;

import deob.ObfuscatedName;
import jagex2.io.Packet;

@ObfuscatedName("ae")
public class AnimFrame {

	@ObfuscatedName("ae.r")
	public static int[] field658 = new int[500];

	@ObfuscatedName("ae.d")
	public static int[] field656 = new int[500];

	@ObfuscatedName("ae.l")
	public static int[] field657 = new int[500];

	@ObfuscatedName("ae.m")
	public static int[] field665 = new int[500];

	@ObfuscatedName("ae.c")
	public AnimBase field659 = null;

	@ObfuscatedName("ae.n")
	public int field660 = -1;

	@ObfuscatedName("ae.j")
	public int[] field661;

	@ObfuscatedName("ae.z")
	public int[] field662;

	@ObfuscatedName("ae.g")
	public int[] field663;

	@ObfuscatedName("ae.q")
	public int[] field664;

	@ObfuscatedName("ae.i")
	public boolean field655 = false;

	public AnimFrame(byte[] arg0, AnimBase arg1) {
		this.field659 = arg1;
		Packet var3 = new Packet(arg0);
		Packet var4 = new Packet(arg0);
		var3.pos = 2;
		int var5 = var3.g1();
		int var6 = -1;
		int var7 = 0;
		var4.pos = var3.pos + var5;
		for (int var8 = 0; var8 < var5; var8++) {
			int var9 = var3.g1();
			if (var9 > 0) {
				if (this.field659.field1723[var8] != 0) {
					for (int var10 = var8 - 1; var10 > var6; var10--) {
						if (this.field659.field1723[var10] == 0) {
							field658[var7] = var10;
							field656[var7] = 0;
							field657[var7] = 0;
							field665[var7] = 0;
							var7++;
							break;
						}
					}
				}
				field658[var7] = var8;
				short var11 = 0;
				if (this.field659.field1723[var8] == 3) {
					var11 = 128;
				}
				if ((var9 & 0x1) == 0) {
					field656[var7] = var11;
				} else {
					field656[var7] = var4.gsmarts();
				}
				if ((var9 & 0x2) == 0) {
					field657[var7] = var11;
				} else {
					field657[var7] = var4.gsmarts();
				}
				if ((var9 & 0x4) == 0) {
					field665[var7] = var11;
				} else {
					field665[var7] = var4.gsmarts();
				}
				var6 = var8;
				var7++;
				if (this.field659.field1723[var8] == 5) {
					this.field655 = true;
				}
			}
		}
		if (var4.pos != arg0.length) {
			throw new RuntimeException();
		}
		this.field660 = var7;
		this.field661 = new int[var7];
		this.field662 = new int[var7];
		this.field663 = new int[var7];
		this.field664 = new int[var7];
		for (int var12 = 0; var12 < var7; var12++) {
			this.field661[var12] = field658[var12];
			this.field662[var12] = field656[var12];
			this.field663[var12] = field657[var12];
			this.field664[var12] = field665[var12];
		}
	}
}
