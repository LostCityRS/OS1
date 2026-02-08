package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.client.Client;
import jagex3.client.ClientBuild;
import jagex3.config.LocType;
import jagex3.config.SeqType;

// jag::oldscape::ClientLocAnim
@ObfuscatedName("ff")
public class ClientLocAnim extends ModelSource {

	@ObfuscatedName("ff.j")
	public int id;

	@ObfuscatedName("ff.z")
	public int shape;

	@ObfuscatedName("ff.g")
	public int angle;

	@ObfuscatedName("ff.q")
	public int level;

	@ObfuscatedName("ff.i")
	public int x;

	@ObfuscatedName("ff.s")
	public int z;

	@ObfuscatedName("ff.u")
	public SeqType anim;

	@ObfuscatedName("ff.v")
	public int animFrame;

	@ObfuscatedName("ff.w")
	public int animCycle;

	public ClientLocAnim(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, boolean arg7, ModelSource arg8) {
		this.id = arg0;
		this.shape = arg1;
		this.angle = arg2;
		this.level = arg3;
		this.x = arg4;
		this.z = arg5;
		if (arg6 != -1) {
			this.anim = SeqType.list(arg6);
			this.animFrame = 0;
			this.animCycle = Client.loopCycle - 1;
			if (this.anim.duplicatebehavior == 0 && arg8 != null && arg8 instanceof ClientLocAnim) {
				ClientLocAnim var10 = (ClientLocAnim) arg8;
				if (this.anim == var10.anim) {
					this.animFrame = var10.animFrame;
					this.animCycle = var10.animCycle;
					return;
				}
			}
			if (arg7 && this.anim.loops != -1) {
				this.animFrame = (int) (Math.random() * (double) this.anim.frames.length);
				this.animCycle -= (int) (Math.random() * (double) this.anim.delay[this.animFrame]);
			}
		}
	}

	// jag::oldscape::ClientLocAnim::GetTempModel
	@ObfuscatedName("ff.g(I)Lfo;")
	public final ModelLit getTempModel() {
		if (this.anim != null) {
			int var1 = Client.loopCycle - this.animCycle;
			if (var1 > 100 && this.anim.loops > 0) {
				var1 = 100;
			}
			label47:
			{
				do {
					do {
						if (var1 <= this.anim.delay[this.animFrame]) {
							break label47;
						}
						var1 -= this.anim.delay[this.animFrame];
						this.animFrame++;
					} while (this.animFrame < this.anim.frames.length);
					this.animFrame -= this.anim.loops;
				} while (this.animFrame >= 0 && this.animFrame < this.anim.frames.length);
				this.anim = null;
			}
			this.animCycle = Client.loopCycle - var1;
		}
		LocType var2 = LocType.list(this.id);
		if (var2.multiloc != null) {
			var2 = var2.getMultiLoc();
		}
		if (var2 == null) {
			return null;
		}
		int var3;
		int var4;
		if (this.angle == 1 || this.angle == 3) {
			var3 = var2.length;
			var4 = var2.width;
		} else {
			var3 = var2.width;
			var4 = var2.length;
		}
		int heightSW = (var3 >> 1) + this.x;
		int heightSE = (var3 + 1 >> 1) + this.x;
		int heightNE = (var4 >> 1) + this.z;
		int heightNW = (var4 + 1 >> 1) + this.z;
		int[][] var9 = ClientBuild.groundh[this.level];
		int var10 = var9[heightSW][heightNE] + var9[heightSE][heightNE] + var9[heightSW][heightNW] + var9[heightSE][heightNW] >> 2;
		int var11 = (this.x << 7) + (var3 << 6);
		int var12 = (this.z << 7) + (var4 << 6);
		return var2.getTempModel(this.shape, this.angle, var9, var11, var10, var12, this.anim, this.animFrame);
	}
}
