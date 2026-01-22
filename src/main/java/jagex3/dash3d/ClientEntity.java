package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.config.SeqType;

// jag::oldscape::ClientEntity
@ObfuscatedName("fz")
public abstract class ClientEntity extends ModelSource {

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
	public int turnleftanim = -1;

	@ObfuscatedName("fz.v")
	public int turnrightanim = -1;

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
	public int[] damageValues = new int[4];

	@ObfuscatedName("fz.p")
	public int[] damageTypes = new int[4];

	@ObfuscatedName("fz.ad")
	public int[] damageCycles = new int[4];

	@ObfuscatedName("fz.ac")
	public int combatCycle = -1000;

	@ObfuscatedName("fz.aa")
	public int health;

	@ObfuscatedName("fz.as")
	public int totalHealth;

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
	public int exactStartX;

	@ObfuscatedName("fz.ax")
	public int exactEndX;

	@ObfuscatedName("fz.ai")
	public int exactStartZ;

	@ObfuscatedName("fz.aj")
	public int exactEndZ;

	@ObfuscatedName("fz.aw")
	public int exactMoveEnd;

	@ObfuscatedName("fz.af")
	public int exactMoveStart;

	@ObfuscatedName("fz.bh")
	public int exactMoveFacing;

	@ObfuscatedName("fz.bi")
	public int cycle = 0;

	@ObfuscatedName("fz.bs")
	public int height = 200;

	@ObfuscatedName("fz.bk")
	public int dstYaw;

	@ObfuscatedName("fz.bv")
	public int field2663 = 0;

	@ObfuscatedName("fz.bg")
	public int turnSpeed = 32;

	@ObfuscatedName("fz.bl")
	public int routeLength = 0;

	@ObfuscatedName("fz.bt")
	public int[] routeX = new int[10];

	@ObfuscatedName("fz.bw")
	public int[] routeZ = new int[10];

	@ObfuscatedName("fz.by")
	public boolean[] routeRun = new boolean[10];

	@ObfuscatedName("fz.bx")
	public int animDelayMove = 0;

	@ObfuscatedName("fz.bf")
	public int preanimRouteLength = 0;

	// jag::oldscape::ClientNpc::Teleport
	@ObfuscatedName("fz.b(IIZB)V")
	public final void teleport(int arg0, int arg1, boolean arg2) {
		if (this.primarySeqId != -1 && SeqType.get(this.primarySeqId).postanim_move == 1) {
			this.primarySeqId = -1;
		}
		if (!arg2) {
			int var4 = arg0 - this.routeX[0];
			int var5 = arg1 - this.routeZ[0];
			if (var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
				if (this.routeLength < 9) {
					this.routeLength++;
				}
				for (int var6 = this.routeLength; var6 > 0; var6--) {
					this.routeX[var6] = this.routeX[var6 - 1];
					this.routeZ[var6] = this.routeZ[var6 - 1];
					this.routeRun[var6] = this.routeRun[var6 - 1];
				}
				this.routeX[0] = arg0;
				this.routeZ[0] = arg1;
				this.routeRun[0] = false;
				return;
			}
		}
		this.routeLength = 0;
		this.preanimRouteLength = 0;
		this.animDelayMove = 0;
		this.routeX[0] = arg0;
		this.routeZ[0] = arg1;
		this.x = this.routeX[0] * 128 + this.size * 64;
		this.z = this.routeZ[0] * 128 + this.size * 64;
	}

	// jag::oldscape::ClientNpc::MoveCode
	@ObfuscatedName("fz.y(IZI)V")
	public final void moveCode(int arg0, boolean arg1) {
		int var3 = this.routeX[0];
		int var4 = this.routeZ[0];
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
		if (this.routeLength < 9) {
			this.routeLength++;
		}
		for (int var5 = this.routeLength; var5 > 0; var5--) {
			this.routeX[var5] = this.routeX[var5 - 1];
			this.routeZ[var5] = this.routeZ[var5 - 1];
			this.routeRun[var5] = this.routeRun[var5 - 1];
		}
		this.routeX[0] = var3;
		this.routeZ[0] = var4;
		this.routeRun[0] = arg1;
	}

	// jag::oldscape::ClientEntity::AbortRoute
	@ObfuscatedName("fz.t(I)V")
	public final void abortRoute() {
		this.routeLength = 0;
		this.preanimRouteLength = 0;
	}

	// jag::oldscape::ClientEntity::Ready
	@ObfuscatedName("fz.f(I)Z")
	public boolean ready() {
		return false;
	}

	// jag::oldscape::ClientEntity::AddHeadbar
	@ObfuscatedName("fz.k(IIIB)V")
	public final void addHitmark(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < 4; var4++) {
			if (this.damageCycles[var4] <= arg2) {
				this.damageValues[var4] = arg0;
				this.damageTypes[var4] = arg1;
				this.damageCycles[var4] = arg2 + 70;
				return;
			}
		}
	}
}
