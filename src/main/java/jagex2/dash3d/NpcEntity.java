package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.config.NpcType;
import jagex2.config.SeqType;
import jagex2.config.SpotAnimType;
import jagex2.graphics.SoftwareModel;

@ObfuscatedName("ge")
public class NpcEntity extends PathingEntity {

	@ObfuscatedName("ge.bu")
	public NpcType type;

	@ObfuscatedName("ge.g(I)Lfo;")
	public final SoftwareModel getModel() {
		if (this.type == null) {
			return null;
		}
		SeqType var1 = this.primarySeqId != -1 && this.primarySeqDelay == 0 ? SeqType.get(this.primarySeqId) : null;
		SeqType var2 = this.secondarySeqId == -1 || this.secondarySeqId == this.readyanim && var1 != null ? null : SeqType.get(this.secondarySeqId);
		SoftwareModel var3 = this.type.getModel(var1, this.primarySeqFrame, var2, this.field2641);
		if (var3 == null) {
			return null;
		}
		var3.method3002();
		this.field2626 = var3.minY;
		if (this.spotanimId != -1 && this.spotanimFrame != -1) {
			SoftwareModel var4 = SpotAnimType.get(this.spotanimId).method2455(this.spotanimFrame);
			if (var4 != null) {
				var4.method3012(0, -this.field2629, 0);
				SoftwareModel[] var5 = new SoftwareModel[] { var3, var4 };
				var3 = new SoftwareModel(var5, 2);
			}
		}
		if (this.type.size == 1) {
			var3.picking = true;
		}
		return var3;
	}

	@ObfuscatedName("ge.f(I)Z")
	public final boolean isVisible() {
		return this.type != null;
	}
}
