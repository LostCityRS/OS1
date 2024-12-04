package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.client.Client;
import jagex2.client.JagException;
import jagex2.config.ObjType;
import jagex2.config.SeqType;
import jagex2.config.SpotAnimType;
import jagex2.graphics.SoftwareModel;
import jagex2.io.Packet;

@ObfuscatedName("fi")
public class PlayerEntity extends PathingEntity {

	@ObfuscatedName("fi.bu")
	public String field2796;

	@ObfuscatedName("fi.bo")
	public PlayerModel field2786;

	@ObfuscatedName("fi.bq")
	public int field2787 = -1;

	@ObfuscatedName("fi.bj")
	public int field2800 = -1;

	@ObfuscatedName("fi.bz")
	public int field2789 = 0;

	@ObfuscatedName("fi.bm")
	public int field2790 = 0;

	@ObfuscatedName("fi.bn")
	public int field2791;

	@ObfuscatedName("fi.be")
	public int field2792 = 0;

	@ObfuscatedName("fi.bp")
	public int field2793 = 0;

	@ObfuscatedName("fi.ba")
	public int field2794;

	@ObfuscatedName("fi.bc")
	public int field2797;

	@ObfuscatedName("fi.br")
	public int field2799;

	@ObfuscatedName("fi.bb")
	public SoftwareModel field2801;

	@ObfuscatedName("fi.bd")
	public int field2798;

	@ObfuscatedName("fi.cr")
	public int field2802;

	@ObfuscatedName("fi.cs")
	public int field2785;

	@ObfuscatedName("fi.cj")
	public int field2788;

	@ObfuscatedName("fi.cl")
	public boolean field2795 = false;

	@ObfuscatedName("fi.cp")
	public int field2803 = 0;

	@ObfuscatedName("fi.am(Lev;I)V")
	public final void method3061(Packet arg0) {
		arg0.pos = 0;
		int var2 = arg0.g1();
		this.field2787 = arg0.g1b();
		this.field2800 = arg0.g1b();
		int var3 = -1;
		this.field2803 = 0;
		int[] var4 = new int[12];
		for (int var5 = 0; var5 < 12; var5++) {
			int var6 = arg0.g1();
			if (var6 == 0) {
				var4[var5] = 0;
			} else {
				int var7 = arg0.g1();
				var4[var5] = (var6 << 8) + var7;
				if (var5 == 0 && var4[0] == 65535) {
					var3 = arg0.g2();
					break;
				}
				if (var4[var5] >= 512) {
					int var8 = ObjType.get(var4[var5] - 512).team;
					if (var8 != 0) {
						this.field2803 = var8;
					}
				}
			}
		}
		int[] var9 = new int[5];
		for (int var10 = 0; var10 < 5; var10++) {
			int var11 = arg0.g1();
			if (var11 < 0 || var11 >= PlayerModel.field800[var10].length) {
				var11 = 0;
			}
			var9[var10] = var11;
		}
		this.field2622 = arg0.g2();
		if (this.field2622 == 65535) {
			this.field2622 = -1;
		}
		this.field2619 = arg0.g2();
		if (this.field2619 == 65535) {
			this.field2619 = -1;
		}
		this.field2620 = this.field2619;
		this.field2621 = arg0.g2();
		if (this.field2621 == 65535) {
			this.field2621 = -1;
		}
		this.field2664 = arg0.g2();
		if (this.field2664 == 65535) {
			this.field2664 = -1;
		}
		this.field2623 = arg0.g2();
		if (this.field2623 == 65535) {
			this.field2623 = -1;
		}
		this.field2624 = arg0.g2();
		if (this.field2624 == 65535) {
			this.field2624 = -1;
		}
		this.field2625 = arg0.g2();
		if (this.field2625 == 65535) {
			this.field2625 = -1;
		}
		this.field2796 = arg0.gjstr();
		if (Client.localPlayer == this) {
			JagException.username = this.field2796;
		}
		this.field2789 = arg0.g1();
		this.field2790 = arg0.g2();
		if (this.field2786 == null) {
			this.field2786 = new PlayerModel();
		}
		this.field2786.method1168(var4, var9, var2 == 1, var3);
	}

	@ObfuscatedName("fi.g(I)Lfo;")
	public final SoftwareModel method2643() {
		if (this.field2786 == null) {
			return null;
		}
		SeqType var1 = this.field2643 != -1 && this.field2627 == 0 ? SeqType.get(this.field2643) : null;
		SeqType var2 = this.field2640 == -1 || this.field2795 || this.field2640 == this.field2622 && var1 != null ? null : SeqType.get(this.field2640);
		SoftwareModel var3 = this.field2786.method1174(var1, this.field2653, var2, this.field2641);
		if (var3 == null) {
			return null;
		}
		var3.method3002();
		this.field2626 = var3.field2487;
		if (!this.field2795 && this.field2648 != -1 && this.field2649 != -1) {
			SoftwareModel var4 = SpotAnimType.get(this.field2648).method2455(this.field2649);
			if (var4 != null) {
				var4.method3012(0, -this.field2629, 0);
				SoftwareModel[] var5 = new SoftwareModel[] { var3, var4 };
				var3 = new SoftwareModel(var5, 2);
			}
		}
		if (!this.field2795 && this.field2801 != null) {
			if (Client.field1922 >= this.field2793) {
				this.field2801 = null;
			}
			if (Client.field1922 >= this.field2792 && Client.field1922 < this.field2793) {
				SoftwareModel var6 = this.field2801;
				var6.method3012(this.field2794 - this.field2615, this.field2797 - this.field2791, this.field2799 - this.field2614);
				if (this.field2618 == 512) {
					var6.method3008();
					var6.method3008();
					var6.method3008();
				} else if (this.field2618 == 1024) {
					var6.method3008();
					var6.method3008();
				} else if (this.field2618 == 1536) {
					var6.method3008();
				}
				SoftwareModel[] var7 = new SoftwareModel[] { var3, var6 };
				var3 = new SoftwareModel(var7, 2);
				if (this.field2618 == 512) {
					var6.method3008();
				} else if (this.field2618 == 1024) {
					var6.method3008();
					var6.method3008();
				} else if (this.field2618 == 1536) {
					var6.method3008();
					var6.method3008();
					var6.method3008();
				}
				var6.method3012(this.field2615 - this.field2794, this.field2791 - this.field2797, this.field2614 - this.field2799);
			}
		}
		var3.field2744 = true;
		return var3;
	}

	@ObfuscatedName("fi.f(I)Z")
	public final boolean method2915() {
		return this.field2786 != null;
	}
}
