package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.io.Packet;

// jag::oldscape::dash3d::AnimFrame
@ObfuscatedName("ae")
public class AnimFrame {

	@ObfuscatedName("ae.r")
	public static int[] tempTi = new int[500];

	@ObfuscatedName("ae.d")
	public static int[] tempTx = new int[500];

	@ObfuscatedName("ae.l")
	public static int[] tempTy = new int[500];

	@ObfuscatedName("ae.m")
	public static int[] tempTz = new int[500];

	@ObfuscatedName("ae.c")
	public AnimBase base = null;

	@ObfuscatedName("ae.n")
	public int size = -1;

	@ObfuscatedName("ae.j")
	public int[] ti;

	@ObfuscatedName("ae.z")
	public int[] tx;

	@ObfuscatedName("ae.g")
	public int[] ty;

	@ObfuscatedName("ae.q")
	public int[] tz;

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

			if (this.base.type[var8] != 0) {
				for (int var10 = var8 - 1; var10 > var6; var10--) {
					if (this.base.type[var10] == 0) {
						tempTi[length] = var10;
						tempTx[length] = 0;
						tempTy[length] = 0;
						tempTz[length] = 0;
						length++;
						break;
					}
				}
			}

			tempTi[length] = var8;
			short var11 = 0;
			if (this.base.type[var8] == 3) {
				var11 = 128;
			}

			if ((var9 & 0x1) == 0) {
				tempTx[length] = var11;
			} else {
				tempTx[length] = var4.gsmarts();
			}

			if ((var9 & 0x2) == 0) {
				tempTy[length] = var11;
			} else {
				tempTy[length] = var4.gsmarts();
			}

			if ((var9 & 0x4) == 0) {
				tempTz[length] = var11;
			} else {
				tempTz[length] = var4.gsmarts();
			}

			var6 = var8;
			length++;

			if (this.base.type[var8] == 5) {
				this.hasAlpha = true;
			}
		}

		if (var4.pos != src.length) {
			throw new RuntimeException();
		}

		this.size = length;
		this.ti = new int[length];
		this.tx = new int[length];
		this.ty = new int[length];
		this.tz = new int[length];

		for (int i = 0; i < length; i++) {
			this.ti[i] = tempTi[i];
			this.tx[i] = tempTx[i];
			this.ty[i] = tempTy[i];
			this.tz[i] = tempTz[i];
		}
	}
}
