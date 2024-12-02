package jagex2.sound;

import deob.ObfuscatedName;
import jagex2.io.Packet;

@ObfuscatedName("k")
public class Envelope {

	@ObfuscatedName("k.r")
	public int field298 = 2;

	@ObfuscatedName("k.d")
	public int[] field296 = new int[2];

	@ObfuscatedName("k.l")
	public int[] field297 = new int[2];

	@ObfuscatedName("k.m")
	public int field305;

	@ObfuscatedName("k.c")
	public int field299;

	@ObfuscatedName("k.n")
	public int field295;

	@ObfuscatedName("k.j")
	public int field301;

	@ObfuscatedName("k.z")
	public int field300;

	@ObfuscatedName("k.g")
	public int field303;

	@ObfuscatedName("k.q")
	public int field304;

	@ObfuscatedName("k.i")
	public int field302;

	public Envelope() {
		this.field296[0] = 0;
		this.field296[1] = 65535;
		this.field297[0] = 0;
		this.field297[1] = 65535;
	}

	@ObfuscatedName("k.r(Lev;)V")
	public final void method276(Packet arg0) {
		this.field295 = arg0.method1600();
		this.field305 = arg0.method1605();
		this.field299 = arg0.method1605();
		this.method277(arg0);
	}

	@ObfuscatedName("k.d(Lev;)V")
	public final void method277(Packet arg0) {
		this.field298 = arg0.method1600();
		this.field296 = new int[this.field298];
		this.field297 = new int[this.field298];
		for (int var2 = 0; var2 < this.field298; var2++) {
			this.field296[var2] = arg0.method1602();
			this.field297[var2] = arg0.method1602();
		}
	}

	@ObfuscatedName("k.l()V")
	public final void method284() {
		this.field301 = 0;
		this.field300 = 0;
		this.field303 = 0;
		this.field304 = 0;
		this.field302 = 0;
	}

	@ObfuscatedName("k.m(I)I")
	public final int method279(int arg0) {
		if (this.field302 >= this.field301) {
			this.field304 = this.field297[this.field300++] << 15;
			if (this.field300 >= this.field298) {
				this.field300 = this.field298 - 1;
			}
			this.field301 = (int) ((double) this.field296[this.field300] / 65536.0D * (double) arg0);
			if (this.field301 > this.field302) {
				this.field303 = ((this.field297[this.field300] << 15) - this.field304) / (this.field301 - this.field302);
			}
		}
		this.field304 += this.field303;
		this.field302++;
		return this.field304 - this.field303 >> 15;
	}
}
