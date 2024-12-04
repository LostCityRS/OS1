package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.client.Client;
import jagex2.config.LocType;
import jagex2.config.SeqType;
import jagex2.graphics.SoftwareModel;

@ObfuscatedName("ff")
public class LocEntity extends Entity {

	@ObfuscatedName("ff.j")
	public int field2599;

	@ObfuscatedName("ff.z")
	public int field2592;

	@ObfuscatedName("ff.g")
	public int field2593;

	@ObfuscatedName("ff.q")
	public int field2594;

	@ObfuscatedName("ff.i")
	public int field2595;

	@ObfuscatedName("ff.s")
	public int field2596;

	@ObfuscatedName("ff.u")
	public SeqType anim;

	@ObfuscatedName("ff.v")
	public int animFrame;

	@ObfuscatedName("ff.w")
	public int animCycle;

	public LocEntity(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, boolean arg7, Entity arg8) {
		this.field2599 = arg0;
		this.field2592 = arg1;
		this.field2593 = arg2;
		this.field2594 = arg3;
		this.field2595 = arg4;
		this.field2596 = arg5;
		if (arg6 != -1) {
			this.anim = SeqType.get(arg6);
			this.animFrame = 0;
			this.animCycle = Client.loopCycle - 1;
			if (this.anim.replacemode == 0 && arg8 != null && arg8 instanceof LocEntity) {
				LocEntity var10 = (LocEntity) arg8;
				if (this.anim == var10.anim) {
					this.animFrame = var10.animFrame;
					this.animCycle = var10.animCycle;
					return;
				}
			}
			if (arg7 && this.anim.replayoff != -1) {
				this.animFrame = (int) (Math.random() * (double) this.anim.frames.length);
				this.animCycle -= (int) (Math.random() * (double) this.anim.delay[this.animFrame]);
			}
		}
	}

	@ObfuscatedName("ff.g(I)Lfo;")
	public final SoftwareModel method2643() {
		if (this.anim != null) {
			int var1 = Client.loopCycle - this.animCycle;
			if (var1 > 100 && this.anim.replayoff > 0) {
				var1 = 100;
			}
			label47: {
				do {
					do {
						if (var1 <= this.anim.delay[this.animFrame]) {
							break label47;
						}
						var1 -= this.anim.delay[this.animFrame];
						this.animFrame++;
					} while (this.animFrame < this.anim.frames.length);
					this.animFrame -= this.anim.replayoff;
				} while (this.animFrame >= 0 && this.animFrame < this.anim.frames.length);
				this.anim = null;
			}
			this.animCycle = Client.loopCycle - var1;
		}
		LocType var2 = LocType.get(this.field2599);
		if (var2.multiloc != null) {
			var2 = var2.getMultiLoc();
		}
		if (var2 == null) {
			return null;
		}
		int var3;
		int var4;
		if (this.field2593 == 1 || this.field2593 == 3) {
			var3 = var2.length;
			var4 = var2.width;
		} else {
			var3 = var2.width;
			var4 = var2.length;
		}
		int var5 = (var3 >> 1) + this.field2595;
		int var6 = (var3 + 1 >> 1) + this.field2595;
		int var7 = (var4 >> 1) + this.field2596;
		int var8 = (var4 + 1 >> 1) + this.field2596;
		int[][] var9 = World.levelHeightmap[this.field2594];
		int var10 = var9[var5][var7] + var9[var6][var7] + var9[var5][var8] + var9[var6][var8] >> 2;
		int var11 = (this.field2595 << 7) + (var3 << 6);
		int var12 = (this.field2596 << 7) + (var4 << 6);
		return var2.method2376(this.field2592, this.field2593, var9, var11, var10, var12, this.anim, this.animFrame);
	}
}
