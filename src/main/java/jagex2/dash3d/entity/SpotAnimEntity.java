package jagex2.dash3d.entity;

import deob.ObfuscatedName;
import jagex2.config.SeqType;
import jagex2.config.SpotAnimType;
import jagex2.graphics.ModelLit;

@ObfuscatedName("fn")
public class SpotAnimEntity extends Entity {

	@ObfuscatedName("fn.j")
	public int field2608;

	@ObfuscatedName("fn.z")
	public int field2611;

	@ObfuscatedName("fn.g")
	public int startCycle;

	@ObfuscatedName("fn.q")
	public int level;

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
	public boolean seqComplete = false;

	public SpotAnimEntity(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		this.field2608 = arg0;
		this.level = arg1;
		this.field2610 = arg2;
		this.field2606 = arg3;
		this.field2611 = arg4;
		this.startCycle = arg5 + arg6;
		int var8 = SpotAnimType.get(this.field2608).anim;
		if (var8 == -1) {
			this.seqComplete = true;
		} else {
			this.seqComplete = false;
			this.field2607 = SeqType.get(var8);
		}
	}

	@ObfuscatedName("fn.b(II)V")
	public final void update(int arg0) {
		if (this.seqComplete) {
			return;
		}
		this.field2602 += arg0;
		while (this.field2602 > this.field2607.delay[this.field2609]) {
			this.field2602 -= this.field2607.delay[this.field2609];
			this.field2609++;
			if (this.field2609 >= this.field2607.frames.length) {
				this.seqComplete = true;
				break;
			}
		}
	}

	@ObfuscatedName("fn.g(I)Lfo;")
	public final ModelLit getModel() {
		SpotAnimType var1 = SpotAnimType.get(this.field2608);
		ModelLit var2;
		if (this.seqComplete) {
			var2 = var1.method2455(-1);
		} else {
			var2 = var1.method2455(this.field2609);
		}
		return var2 == null ? null : var2;
	}
}
