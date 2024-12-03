package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.config.SeqType;
import jagex2.config.SpotAnimType;
import jagex2.graphics.SoftwareModel;

@ObfuscatedName("fn")
public class SpotAnimEntity extends Entity {

	@ObfuscatedName("fn.j")
	public int field2608;

	@ObfuscatedName("fn.z")
	public int field2611;

	@ObfuscatedName("fn.g")
	public int field2603;

	@ObfuscatedName("fn.q")
	public int field2604;

	@ObfuscatedName("fn.i")
	public int field2610;

	@ObfuscatedName("fn.s")
	public int field2606;

	@ObfuscatedName("fn.u")
	public SeqType field2607;

	@ObfuscatedName("fn.v")
	public int field2609 = 0;

	@ObfuscatedName("fn.w")
	public int field2602 = 0;

	@ObfuscatedName("fn.e")
	public boolean field2605 = false;

	public SpotAnimEntity(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		this.field2608 = arg0;
		this.field2604 = arg1;
		this.field2610 = arg2;
		this.field2606 = arg3;
		this.field2611 = arg4;
		this.field2603 = arg5 + arg6;
		int var8 = SpotAnimType.get(this.field2608).anim;
		if (var8 == -1) {
			this.field2605 = true;
		} else {
			this.field2605 = false;
			this.field2607 = SeqType.get(var8);
		}
	}

	@ObfuscatedName("fn.b(II)V")
	public final void method2902(int arg0) {
		if (this.field2605) {
			return;
		}
		this.field2602 += arg0;
		while (this.field2602 > this.field2607.delay[this.field2609]) {
			this.field2602 -= this.field2607.delay[this.field2609];
			this.field2609++;
			if (this.field2609 >= this.field2607.frames.length) {
				this.field2605 = true;
				break;
			}
		}
	}

	@ObfuscatedName("fn.g(I)Lfo;")
	public final SoftwareModel method2643() {
		SpotAnimType var1 = SpotAnimType.get(this.field2608);
		SoftwareModel var2;
		if (this.field2605) {
			var2 = var1.method2455(-1);
		} else {
			var2 = var1.method2455(this.field2609);
		}
		return var2 == null ? null : var2;
	}
}
