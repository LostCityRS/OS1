package jagex2.graphics;

import deob.ObfuscatedName;
import jagex2.io.Packet;

@ObfuscatedName("ae")
public class AnimFrame {

	@ObfuscatedName("ae.r")
	public static int[] tempGroups = new int[500];

	@ObfuscatedName("ae.d")
	public static int[] tempX = new int[500];

	@ObfuscatedName("ae.l")
	public static int[] tempY = new int[500];

	@ObfuscatedName("ae.m")
	public static int[] tempZ = new int[500];

	@ObfuscatedName("ae.c")
	public AnimBase base = null;

	@ObfuscatedName("ae.n")
	public int length = -1;

	@ObfuscatedName("ae.j")
	public int[] groups;

	@ObfuscatedName("ae.z")
	public int[] x;

	@ObfuscatedName("ae.g")
	public int[] y;

	@ObfuscatedName("ae.q")
	public int[] z;

	@ObfuscatedName("ae.i")
	public boolean hasAlpha = false;

	public AnimFrame(byte[] src, AnimBase base) {
		this.base = base;

		Packet var3 = new Packet(src);
		Packet var4 = new Packet(src);
		var3.pos = 2;
		int var5 = var3.g1();
		int var6 = -1;
		int length = 0;
		var4.pos = var3.pos + var5;

		for (int var8 = 0; var8 < var5; var8++) {
			int var9 = var3.g1();
			if (var9 <= 0) {
				continue;
			}

			if (this.base.types[var8] != 0) {
				for (int var10 = var8 - 1; var10 > var6; var10--) {
					if (this.base.types[var10] == 0) {
						tempGroups[length] = var10;
						tempX[length] = 0;
						tempY[length] = 0;
						tempZ[length] = 0;
						length++;
						break;
					}
				}
			}

			tempGroups[length] = var8;
			short var11 = 0;
			if (this.base.types[var8] == 3) {
				var11 = 128;
			}

			if ((var9 & 0x1) == 0) {
				tempX[length] = var11;
			} else {
				tempX[length] = var4.gsmarts();
			}

			if ((var9 & 0x2) == 0) {
				tempY[length] = var11;
			} else {
				tempY[length] = var4.gsmarts();
			}

			if ((var9 & 0x4) == 0) {
				tempZ[length] = var11;
			} else {
				tempZ[length] = var4.gsmarts();
			}

			var6 = var8;
			length++;

			if (this.base.types[var8] == 5) {
				this.hasAlpha = true;
			}
		}

		if (var4.pos != src.length) {
			throw new RuntimeException();
		}

		this.length = length;
		this.groups = new int[length];
		this.x = new int[length];
		this.y = new int[length];
		this.z = new int[length];

		for (int i = 0; i < length; i++) {
			this.groups[i] = tempGroups[i];
			this.x[i] = tempX[i];
			this.y[i] = tempY[i];
			this.z[i] = tempZ[i];
		}
	}
}
