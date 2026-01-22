package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.config.SeqType;
import jagex3.config.SpotType;

// jag::oldscape::ClientProj::ClientProj
@ObfuscatedName("fh")
public class ClientProj extends ModelSource {

	@ObfuscatedName("fh.j")
	public int spotanim;

	@ObfuscatedName("fh.z")
	public int level;

	@ObfuscatedName("fh.g")
	public int srcX;

	@ObfuscatedName("fh.q")
	public int srcZ;

	@ObfuscatedName("fh.i")
	public int h1;

	@ObfuscatedName("fh.s")
	public int h2;

	@ObfuscatedName("fh.u")
	public int t1;

	@ObfuscatedName("fh.v")
	public int t2;

	@ObfuscatedName("fh.w")
	public int angle;

	@ObfuscatedName("fh.e")
	public int startpos;

	@ObfuscatedName("fh.b")
	public int target;

	@ObfuscatedName("fh.y")
	public boolean mobile = false;

	@ObfuscatedName("fh.t")
	public double x;

	@ObfuscatedName("fh.f")
	public double z;

	@ObfuscatedName("fh.k")
	public double y;

	@ObfuscatedName("fh.o")
	public double velocityX;

	@ObfuscatedName("fh.a")
	public double velocityZ;

	@ObfuscatedName("fh.h")
	public double velocity;

	@ObfuscatedName("fh.x")
	public double velocityY;

	@ObfuscatedName("fh.p")
	public double accelerationY;

	@ObfuscatedName("fh.ad")
	public int yaw;

	@ObfuscatedName("fh.ac")
	public int pitch;

	@ObfuscatedName("fh.aa")
	public SeqType anim;

	@ObfuscatedName("fh.as")
	public int animFrame = 0;

	@ObfuscatedName("fh.am")
	public int animCycle = 0;

	public ClientProj(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
		this.spotanim = arg0;
		this.level = arg1;
		this.srcX = arg2;
		this.srcZ = arg3;
		this.h1 = arg4;
		this.t1 = arg5;
		this.t2 = arg6;
		this.angle = arg7;
		this.startpos = arg8;
		this.target = arg9;
		this.h2 = arg10;
		this.mobile = false;
		int var12 = SpotType.list(this.spotanim).anim;
		if (var12 == -1) {
			this.anim = null;
		} else {
			this.anim = SeqType.list(var12);
		}
	}

	// jag::oldscape::ClientProj::SetTarget
	@ObfuscatedName("fh.b(IIIII)V")
	public final void setTarget(int arg0, int arg1, int arg2, int arg3) {
		if (!this.mobile) {
			double var5 = (double) (arg0 - this.srcX);
			double var7 = (double) (arg1 - this.srcZ);
			double var9 = Math.sqrt(var5 * var5 + var7 * var7);
			this.x = (double) this.startpos * var5 / var9 + (double) this.srcX;
			this.z = (double) this.startpos * var7 / var9 + (double) this.srcZ;
			this.y = this.h1;
		}
		double var11 = (double) (this.t2 + 1 - arg3);
		this.velocityX = ((double) arg0 - this.x) / var11;
		this.velocityZ = ((double) arg1 - this.z) / var11;
		this.velocity = Math.sqrt(this.velocityZ * this.velocityZ + this.velocityX * this.velocityX);
		if (!this.mobile) {
			this.velocityY = -this.velocity * Math.tan((double) this.angle * 0.02454369D);
		}
		this.accelerationY = ((double) arg2 - this.y - this.velocityY * var11) * 2.0D / (var11 * var11);
	}

	// jag::oldscape::ClientProj::Move
	@ObfuscatedName("fh.y(IB)V")
	public final void move(int arg0) {
		this.mobile = true;
		this.x += (double) arg0 * this.velocityX;
		this.z += (double) arg0 * this.velocityZ;
		this.y += this.accelerationY * 0.5D * (double) arg0 * (double) arg0 + (double) arg0 * this.velocityY;
		this.velocityY += (double) arg0 * this.accelerationY;
		this.yaw = (int) (Math.atan2(this.velocityX, this.velocityZ) * 325.949D) + 1024 & 0x7FF;
		this.pitch = (int) (Math.atan2(this.velocityY, this.velocity) * 325.949D) & 0x7FF;
		if (this.anim != null) {
			this.animCycle += arg0;
			while (true) {
				do {
					do {
						if (this.animCycle <= this.anim.delay[this.animFrame]) {
							return;
						}
						this.animCycle -= this.anim.delay[this.animFrame];
						this.animFrame++;
					} while (this.animFrame < this.anim.frames.length);
					this.animFrame -= this.anim.loops;
				} while (this.animFrame >= 0 && this.animFrame < this.anim.frames.length);
				this.animFrame = 0;
			}
		}
	}

	// jag::oldscape::ClientProj::GetTempModel
	@ObfuscatedName("fh.g(I)Lfo;")
	public final ModelLit getTempModel() {
		SpotType var1 = SpotType.list(this.spotanim);
		ModelLit var2 = var1.getTempModel2(this.animFrame);
		if (var2 == null) {
			return null;
		} else {
			var2.rotateXAxis(this.pitch);
			return var2;
		}
	}
}
