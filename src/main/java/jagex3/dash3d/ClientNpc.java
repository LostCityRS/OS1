package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.config.NpcType;
import jagex3.config.SeqType;
import jagex3.config.SpotAnimType;

// jag::oldscape::ClientNpc
@ObfuscatedName("ge")
public class ClientNpc extends ClientEntity {

	@ObfuscatedName("ge.bu")
	public NpcType type;

	// jag::oldscape::ClientNpc::GetTempModel
	@ObfuscatedName("ge.g(I)Lfo;")
	public final ModelLit getTempModel() {
		if (this.type == null) {
			return null;
		}
		SeqType var1 = this.primarySeqId != -1 && this.primarySeqDelay == 0 ? SeqType.get(this.primarySeqId) : null;
		SeqType var2 = this.secondarySeqId == -1 || this.secondarySeqId == this.readyanim && var1 != null ? null : SeqType.get(this.secondarySeqId);
		ModelLit var3 = this.type.getModel(var1, this.primarySeqFrame, var2, this.field2641);
		if (var3 == null) {
			return null;
		}
		var3.calcBoundingCylinder();
		this.height = var3.minY;
		if (this.spotanimId != -1 && this.spotanimFrame != -1) {
			ModelLit var4 = SpotAnimType.list(this.spotanimId).getTempModel2(this.spotanimFrame);
			if (var4 != null) {
				var4.translate(0, -this.field2629, 0);
				ModelLit[] var5 = new ModelLit[] { var3, var4 };
				var3 = new ModelLit(var5, 2);
			}
		}
		if (this.type.size == 1) {
			var3.useAABBMouseCheck = true;
		}
		return var3;
	}

	// jag::oldscape::ClientNpc::Ready
	@ObfuscatedName("ge.f(I)Z")
	public final boolean ready() {
		return this.type != null;
	}
}
