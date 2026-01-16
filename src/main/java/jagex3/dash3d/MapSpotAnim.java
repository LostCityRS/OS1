package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.config.SeqType;
import jagex3.config.SpotAnimType;

@ObfuscatedName("fn")
public class MapSpotAnim extends ModelSource {

	@ObfuscatedName("fn.j")
	public int type;

	@ObfuscatedName("fn.z")
	public int y;

	@ObfuscatedName("fn.g")
	public int startCycle;

	@ObfuscatedName("fn.q")
	public int level;

	@ObfuscatedName("fn.i")
	public int x;

	@ObfuscatedName("fn.s")
	public int z;

	@ObfuscatedName("fn.u")
	public SeqType anim;

	@ObfuscatedName("fn.v")
	public int animFrame = 0;

	@ObfuscatedName("fn.w")
	public int animCycle = 0;

	@ObfuscatedName("fn.e")
	public boolean animComplete = false;

	public MapSpotAnim(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		this.type = arg0;
		this.level = arg1;
		this.x = arg2;
		this.z = arg3;
		this.y = arg4;
		this.startCycle = arg5 + arg6;
		int var8 = SpotAnimType.get(this.type).anim;
		if (var8 == -1) {
			this.animComplete = true;
		} else {
			this.animComplete = false;
			this.anim = SeqType.get(var8);
		}
	}

	@ObfuscatedName("fn.b(II)V")
	public final void update(int arg0) {
		if (this.animComplete) {
			return;
		}
		this.animCycle += arg0;
		while (this.animCycle > this.anim.delay[this.animFrame]) {
			this.animCycle -= this.anim.delay[this.animFrame];
			this.animFrame++;
			if (this.animFrame >= this.anim.frames.length) {
				this.animComplete = true;
				break;
			}
		}
	}

	@ObfuscatedName("fn.g(I)Lfo;")
	public final ModelLit getTempModel() {
		SpotAnimType var1 = SpotAnimType.get(this.type);
		ModelLit var2;
		if (this.animComplete) {
			var2 = var1.animate(-1);
		} else {
			var2 = var1.animate(this.animFrame);
		}
		return var2 == null ? null : var2;
	}
}
