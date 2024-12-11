package jagex2.dash3d.entity;

import deob.ObfuscatedName;
import jagex2.config.SeqType;

@ObfuscatedName("fz")
public abstract class PathingEntity extends Entity {

	@ObfuscatedName("fz.j")
	public int x;

	@ObfuscatedName("fz.z")
	public int z;

	@ObfuscatedName("fz.g")
	public int yaw;

	@ObfuscatedName("fz.q")
	public boolean needsForwardDrawPadding = false;

	@ObfuscatedName("fz.i")
	public int size = 1;

	@ObfuscatedName("fz.s")
	public int readyanim = -1;

	@ObfuscatedName("fz.u")
	public int seqTurnIdBase = -1; // todo

	@ObfuscatedName("fz.v")
	public int seqTurnId = -1; // todo

	@ObfuscatedName("fz.w")
	public int walkanim = -1;

	@ObfuscatedName("fz.e")
	public int walkanim_b = -1;

	@ObfuscatedName("fz.b")
	public int walkanim_l = -1;

	@ObfuscatedName("fz.y")
	public int walkanim_r = -1;

	@ObfuscatedName("fz.t")
	public int runanim = -1;

	@ObfuscatedName("fz.f")
	public String chat = null;

	@ObfuscatedName("fz.k")
	public int chatTimer = 100;

	@ObfuscatedName("fz.o")
	public int field2652 = 0;

	@ObfuscatedName("fz.a")
	public int field2670 = 0;

	@ObfuscatedName("fz.x")
	public int[] field2631 = new int[4];

	@ObfuscatedName("fz.p")
	public int[] field2632 = new int[4];

	@ObfuscatedName("fz.ad")
	public int[] field2633 = new int[4];

	@ObfuscatedName("fz.ac")
	public int field2635 = -1000;

	@ObfuscatedName("fz.aa")
	public int field2613;

	@ObfuscatedName("fz.as")
	public int field2636;

	@ObfuscatedName("fz.am")
	public int targetId = -1;

	@ObfuscatedName("fz.ap")
	public int targetTileX = 0;

	@ObfuscatedName("fz.av")
	public int targetTileZ = 0;

	@ObfuscatedName("fz.ak")
	public int secondarySeqId = -1;

	@ObfuscatedName("fz.az")
	public int field2641 = 0;

	@ObfuscatedName("fz.an")
	public int field2662 = 0;

	@ObfuscatedName("fz.ah")
	public int primarySeqId = -1;

	@ObfuscatedName("fz.ay")
	public int primarySeqFrame = 0;

	@ObfuscatedName("fz.al")
	public int primarySeqCycle = 0;

	@ObfuscatedName("fz.ab")
	public int primarySeqDelay = 0;

	@ObfuscatedName("fz.ao")
	public int field2647 = 0;

	@ObfuscatedName("fz.ag")
	public int spotanimId = -1;

	@ObfuscatedName("fz.ar")
	public int spotanimFrame = 0;

	@ObfuscatedName("fz.aq")
	public int spotanimCycle = 0;

	@ObfuscatedName("fz.at")
	public int spotanimLastCycle;

	@ObfuscatedName("fz.ae")
	public int field2629;

	@ObfuscatedName("fz.au")
	public int forceMoveStartSceneTileX;

	@ObfuscatedName("fz.ax")
	public int forceMoveEndSceneTileX;

	@ObfuscatedName("fz.ai")
	public int forceMoveStartSceneTileZ;

	@ObfuscatedName("fz.aj")
	public int forceMoveEndSceneTileZ;

	@ObfuscatedName("fz.aw")
	public int forceMoveEndCycle;

	@ObfuscatedName("fz.af")
	public int forceMoveStartCycle;

	@ObfuscatedName("fz.bh")
	public int forceMoveFaceDirection;

	@ObfuscatedName("fz.bi")
	public int cycle = 0;

	@ObfuscatedName("fz.bs")
	public int field2626 = 200;

	@ObfuscatedName("fz.bk")
	public int dstYaw;

	@ObfuscatedName("fz.bv")
	public int field2663 = 0;

	@ObfuscatedName("fz.bg")
	public int turnSpeed = 32;

	@ObfuscatedName("fz.bl")
	public int pathLength = 0;

	@ObfuscatedName("fz.bt")
	public int[] pathTileX = new int[10];

	@ObfuscatedName("fz.bw")
	public int[] pathTileZ = new int[10];

	@ObfuscatedName("fz.by")
	public boolean[] pathRunning = new boolean[10];

	@ObfuscatedName("fz.bx")
	public int seqTrigger = 0;

	@ObfuscatedName("fz.bf")
	public int seqPathLength = 0;

	@ObfuscatedName("fz.b(IIZB)V")
	public final void move(int arg0, int arg1, boolean arg2) {
		if (this.primarySeqId != -1 && SeqType.get(this.primarySeqId).postanim_move == 1) {
			this.primarySeqId = -1;
		}
		if (!arg2) {
			int var4 = arg0 - this.pathTileX[0];
			int var5 = arg1 - this.pathTileZ[0];
			if (var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
				if (this.pathLength < 9) {
					this.pathLength++;
				}
				for (int var6 = this.pathLength; var6 > 0; var6--) {
					this.pathTileX[var6] = this.pathTileX[var6 - 1];
					this.pathTileZ[var6] = this.pathTileZ[var6 - 1];
					this.pathRunning[var6] = this.pathRunning[var6 - 1];
				}
				this.pathTileX[0] = arg0;
				this.pathTileZ[0] = arg1;
				this.pathRunning[0] = false;
				return;
			}
		}
		this.pathLength = 0;
		this.seqPathLength = 0;
		this.seqTrigger = 0;
		this.pathTileX[0] = arg0;
		this.pathTileZ[0] = arg1;
		this.x = this.pathTileX[0] * 128 + this.size * 64;
		this.z = this.pathTileZ[0] * 128 + this.size * 64;
	}

	@ObfuscatedName("fz.y(IZI)V")
	public final void step(int arg0, boolean arg1) {
		int var3 = this.pathTileX[0];
		int var4 = this.pathTileZ[0];
		if (arg0 == 0) {
			var3--;
			var4++;
		}
		if (arg0 == 1) {
			var4++;
		}
		if (arg0 == 2) {
			var3++;
			var4++;
		}
		if (arg0 == 3) {
			var3--;
		}
		if (arg0 == 4) {
			var3++;
		}
		if (arg0 == 5) {
			var3--;
			var4--;
		}
		if (arg0 == 6) {
			var4--;
		}
		if (arg0 == 7) {
			var3++;
			var4--;
		}
		if (this.primarySeqId != -1 && SeqType.get(this.primarySeqId).postanim_move == 1) {
			this.primarySeqId = -1;
		}
		if (this.pathLength < 9) {
			this.pathLength++;
		}
		for (int var5 = this.pathLength; var5 > 0; var5--) {
			this.pathTileX[var5] = this.pathTileX[var5 - 1];
			this.pathTileZ[var5] = this.pathTileZ[var5 - 1];
			this.pathRunning[var5] = this.pathRunning[var5 - 1];
		}
		this.pathTileX[0] = var3;
		this.pathTileZ[0] = var4;
		this.pathRunning[0] = arg1;
	}

	@ObfuscatedName("fz.t(I)V")
	public final void resetPath() {
		this.pathLength = 0;
		this.seqPathLength = 0;
	}

	@ObfuscatedName("fz.f(I)Z")
	public boolean isVisible() {
		return false;
	}

	@ObfuscatedName("fz.k(IIIB)V")
	public final void method2911(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < 4; var4++) {
			if (this.field2633[var4] <= arg2) {
				this.field2631[var4] = arg0;
				this.field2632[var4] = arg1;
				this.field2633[var4] = arg2 + 70;
				return;
			}
		}
	}
}
