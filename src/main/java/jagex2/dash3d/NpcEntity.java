package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.config.NpcType;
import jagex2.config.SeqType;
import jagex2.config.SpotAnimType;
import jagex2.graphics.SoftwareModel;

@ObfuscatedName("ge")
public class NpcEntity extends PathingEntity {

	@ObfuscatedName("ge.bu")
	public NpcType field2804;

	@ObfuscatedName("ge.g(I)Lfo;")
	public final SoftwareModel method2643() {
		if (this.field2804 == null) {
			return null;
		}
		SeqType var1 = this.field2643 != -1 && this.field2627 == 0 ? SeqType.get(this.field2643) : null;
		SeqType var2 = this.field2640 == -1 || this.field2640 == this.field2622 && var1 != null ? null : SeqType.get(this.field2640);
		SoftwareModel var3 = this.field2804.method2330(var1, this.field2653, var2, this.field2641);
		if (var3 == null) {
			return null;
		}
		var3.method3002();
		this.field2626 = var3.field2487;
		if (this.field2648 != -1 && this.field2649 != -1) {
			SoftwareModel var4 = SpotAnimType.get(this.field2648).method2455(this.field2649);
			if (var4 != null) {
				var4.method3012(0, -this.field2629, 0);
				SoftwareModel[] var5 = new SoftwareModel[] { var3, var4 };
				var3 = new SoftwareModel(var5, 2);
			}
		}
		if (this.field2804.size == 1) {
			var3.field2744 = true;
		}
		return var3;
	}

	@ObfuscatedName("ge.f(I)Z")
	public final boolean method2915() {
		return this.field2804 != null;
	}
}
