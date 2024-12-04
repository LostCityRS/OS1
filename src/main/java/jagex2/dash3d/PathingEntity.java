package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.config.SeqType;

@ObfuscatedName("fz")
public abstract class PathingEntity extends Entity {

	@ObfuscatedName("fz.j")
	public int field2615;

	@ObfuscatedName("fz.z")
	public int field2614;

	@ObfuscatedName("fz.g")
	public int field2646;

	@ObfuscatedName("fz.q")
	public boolean field2616 = false;

	@ObfuscatedName("fz.i")
	public int field2657 = 1;

	@ObfuscatedName("fz.s")
	public int field2622 = -1;

	@ObfuscatedName("fz.u")
	public int field2619 = -1;

	@ObfuscatedName("fz.v")
	public int field2620 = -1;

	@ObfuscatedName("fz.w")
	public int field2621 = -1;

	@ObfuscatedName("fz.e")
	public int field2664 = -1;

	@ObfuscatedName("fz.b")
	public int field2623 = -1;

	@ObfuscatedName("fz.y")
	public int field2624 = -1;

	@ObfuscatedName("fz.t")
	public int field2625 = -1;

	@ObfuscatedName("fz.f")
	public String field2644 = null;

	@ObfuscatedName("fz.k")
	public int field2634 = 100;

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
	public int field2637 = -1;

	@ObfuscatedName("fz.ap")
	public int field2638 = 0;

	@ObfuscatedName("fz.av")
	public int field2639 = 0;

	@ObfuscatedName("fz.ak")
	public int field2640 = -1;

	@ObfuscatedName("fz.az")
	public int field2641 = 0;

	@ObfuscatedName("fz.an")
	public int field2662 = 0;

	@ObfuscatedName("fz.ah")
	public int field2643 = -1;

	@ObfuscatedName("fz.ay")
	public int field2653 = 0;

	@ObfuscatedName("fz.al")
	public int field2645 = 0;

	@ObfuscatedName("fz.ab")
	public int field2627 = 0;

	@ObfuscatedName("fz.ao")
	public int field2647 = 0;

	@ObfuscatedName("fz.ag")
	public int field2648 = -1;

	@ObfuscatedName("fz.ar")
	public int field2649 = 0;

	@ObfuscatedName("fz.aq")
	public int field2650 = 0;

	@ObfuscatedName("fz.at")
	public int field2651;

	@ObfuscatedName("fz.ae")
	public int field2629;

	@ObfuscatedName("fz.au")
	public int field2617;

	@ObfuscatedName("fz.ax")
	public int field2654;

	@ObfuscatedName("fz.ai")
	public int field2655;

	@ObfuscatedName("fz.aj")
	public int field2642;

	@ObfuscatedName("fz.aw")
	public int field2628;

	@ObfuscatedName("fz.af")
	public int field2658;

	@ObfuscatedName("fz.bh")
	public int field2659;

	@ObfuscatedName("fz.bi")
	public int field2660 = 0;

	@ObfuscatedName("fz.bs")
	public int field2626 = 200;

	@ObfuscatedName("fz.bk")
	public int field2618;

	@ObfuscatedName("fz.bv")
	public int field2663 = 0;

	@ObfuscatedName("fz.bg")
	public int field2661 = 32;

	@ObfuscatedName("fz.bl")
	public int field2665 = 0;

	@ObfuscatedName("fz.bt")
	public int[] pathTileX = new int[10];

	@ObfuscatedName("fz.bw")
	public int[] pathTileZ = new int[10];

	@ObfuscatedName("fz.by")
	public boolean[] field2668 = new boolean[10];

	@ObfuscatedName("fz.bx")
	public int field2669 = 0;

	@ObfuscatedName("fz.bf")
	public int field2656 = 0;

	@ObfuscatedName("fz.b(IIZB)V")
	public final void method2907(int arg0, int arg1, boolean arg2) {
		if (this.field2643 != -1 && SeqType.get(this.field2643).postanim_move == 1) {
			this.field2643 = -1;
		}
		if (!arg2) {
			int var4 = arg0 - this.pathTileX[0];
			int var5 = arg1 - this.pathTileZ[0];
			if (var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
				if (this.field2665 < 9) {
					this.field2665++;
				}
				for (int var6 = this.field2665; var6 > 0; var6--) {
					this.pathTileX[var6] = this.pathTileX[var6 - 1];
					this.pathTileZ[var6] = this.pathTileZ[var6 - 1];
					this.field2668[var6] = this.field2668[var6 - 1];
				}
				this.pathTileX[0] = arg0;
				this.pathTileZ[0] = arg1;
				this.field2668[0] = false;
				return;
			}
		}
		this.field2665 = 0;
		this.field2656 = 0;
		this.field2669 = 0;
		this.pathTileX[0] = arg0;
		this.pathTileZ[0] = arg1;
		this.field2615 = this.pathTileX[0] * 128 + this.field2657 * 64;
		this.field2614 = this.pathTileZ[0] * 128 + this.field2657 * 64;
	}

	@ObfuscatedName("fz.y(IZI)V")
	public final void method2908(int arg0, boolean arg1) {
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
		if (this.field2643 != -1 && SeqType.get(this.field2643).postanim_move == 1) {
			this.field2643 = -1;
		}
		if (this.field2665 < 9) {
			this.field2665++;
		}
		for (int var5 = this.field2665; var5 > 0; var5--) {
			this.pathTileX[var5] = this.pathTileX[var5 - 1];
			this.pathTileZ[var5] = this.pathTileZ[var5 - 1];
			this.field2668[var5] = this.field2668[var5 - 1];
		}
		this.pathTileX[0] = var3;
		this.pathTileZ[0] = var4;
		this.field2668[0] = arg1;
	}

	@ObfuscatedName("fz.t(I)V")
	public final void method2906() {
		this.field2665 = 0;
		this.field2656 = 0;
	}

	@ObfuscatedName("fz.f(I)Z")
	public boolean method2915() {
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
