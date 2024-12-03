package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.config.SeqType;
import jagex2.config.SpotAnimType;
import jagex2.graphics.SoftwareModel;

@ObfuscatedName("fh")
public class ProjAnimEntity extends Entity {

	@ObfuscatedName("fh.j")
	public int field2568;

	@ObfuscatedName("fh.z")
	public int field2583;

	@ObfuscatedName("fh.g")
	public int field2574;

	@ObfuscatedName("fh.q")
	public int field2569;

	@ObfuscatedName("fh.i")
	public int field2570;

	@ObfuscatedName("fh.s")
	public int field2571;

	@ObfuscatedName("fh.u")
	public int field2572;

	@ObfuscatedName("fh.v")
	public int field2573;

	@ObfuscatedName("fh.w")
	public int field2567;

	@ObfuscatedName("fh.e")
	public int field2575;

	@ObfuscatedName("fh.b")
	public int field2582;

	@ObfuscatedName("fh.y")
	public boolean field2587 = false;

	@ObfuscatedName("fh.t")
	public double field2580;

	@ObfuscatedName("fh.f")
	public double field2579;

	@ObfuscatedName("fh.k")
	public double field2576;

	@ObfuscatedName("fh.o")
	public double field2578;

	@ObfuscatedName("fh.a")
	public double field2581;

	@ObfuscatedName("fh.h")
	public double field2566;

	@ObfuscatedName("fh.x")
	public double field2584;

	@ObfuscatedName("fh.p")
	public double field2585;

	@ObfuscatedName("fh.ad")
	public int field2586;

	@ObfuscatedName("fh.ac")
	public int field2577;

	@ObfuscatedName("fh.aa")
	public SeqType field2588;

	@ObfuscatedName("fh.as")
	public int field2589 = 0;

	@ObfuscatedName("fh.am")
	public int field2590 = 0;

	public ProjAnimEntity(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
		this.field2568 = arg0;
		this.field2583 = arg1;
		this.field2574 = arg2;
		this.field2569 = arg3;
		this.field2570 = arg4;
		this.field2572 = arg5;
		this.field2573 = arg6;
		this.field2567 = arg7;
		this.field2575 = arg8;
		this.field2582 = arg9;
		this.field2571 = arg10;
		this.field2587 = false;
		int var12 = SpotAnimType.get(this.field2568).anim;
		if (var12 == -1) {
			this.field2588 = null;
		} else {
			this.field2588 = SeqType.get(var12);
		}
	}

	@ObfuscatedName("fh.b(IIIII)V")
	public final void method2896(int arg0, int arg1, int arg2, int arg3) {
		if (!this.field2587) {
			double var5 = (double) (arg0 - this.field2574);
			double var7 = (double) (arg1 - this.field2569);
			double var9 = Math.sqrt(var5 * var5 + var7 * var7);
			this.field2580 = (double) this.field2575 * var5 / var9 + (double) this.field2574;
			this.field2579 = (double) this.field2575 * var7 / var9 + (double) this.field2569;
			this.field2576 = this.field2570;
		}
		double var11 = (double) (this.field2573 + 1 - arg3);
		this.field2578 = ((double) arg0 - this.field2580) / var11;
		this.field2581 = ((double) arg1 - this.field2579) / var11;
		this.field2566 = Math.sqrt(this.field2581 * this.field2581 + this.field2578 * this.field2578);
		if (!this.field2587) {
			this.field2584 = -this.field2566 * Math.tan((double) this.field2567 * 0.02454369D);
		}
		this.field2585 = ((double) arg2 - this.field2576 - this.field2584 * var11) * 2.0D / (var11 * var11);
	}

	@ObfuscatedName("fh.y(IB)V")
	public final void method2895(int arg0) {
		this.field2587 = true;
		this.field2580 += (double) arg0 * this.field2578;
		this.field2579 += (double) arg0 * this.field2581;
		this.field2576 += this.field2585 * 0.5D * (double) arg0 * (double) arg0 + (double) arg0 * this.field2584;
		this.field2584 += (double) arg0 * this.field2585;
		this.field2586 = (int) (Math.atan2(this.field2578, this.field2581) * 325.949D) + 1024 & 0x7FF;
		this.field2577 = (int) (Math.atan2(this.field2584, this.field2566) * 325.949D) & 0x7FF;
		if (this.field2588 == null) {
			return;
		}
		this.field2590 += arg0;
		while (true) {
			do {
				do {
					if (this.field2590 <= this.field2588.delay[this.field2589]) {
						return;
					}
					this.field2590 -= this.field2588.delay[this.field2589];
					this.field2589++;
				} while (this.field2589 < this.field2588.frames.length);
				this.field2589 -= this.field2588.replayoff;
			} while (this.field2589 >= 0 && this.field2589 < this.field2588.frames.length);
			this.field2589 = 0;
		}
	}

	@ObfuscatedName("fh.g(I)Lfo;")
	public final SoftwareModel method2643() {
		SpotAnimType var1 = SpotAnimType.get(this.field2568);
		SoftwareModel var2 = var1.method2455(this.field2589);
		if (var2 == null) {
			return null;
		} else {
			var2.method3011(this.field2577);
			return var2;
		}
	}
}
