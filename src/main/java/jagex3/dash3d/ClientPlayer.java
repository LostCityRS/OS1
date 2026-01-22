package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.client.Client;
import jagex3.client.JagException;
import jagex3.config.ObjType;
import jagex3.config.SeqType;
import jagex3.config.SpotAnimType;
import jagex3.io.Packet;

@ObfuscatedName("fi")
public class ClientPlayer extends ClientEntity {

	@ObfuscatedName("fi.bu")
	public String name;

	@ObfuscatedName("fi.bo")
	public PlayerModel model;

	@ObfuscatedName("fi.bq")
	public int headiconPk = -1;

	@ObfuscatedName("fi.bj")
	public int headiconPrayer = -1;

	@ObfuscatedName("fi.bz")
	public int combatLevel = 0;

	@ObfuscatedName("fi.bm")
	public int skillLevel = 0;

	@ObfuscatedName("fi.bn")
	public int y;

	@ObfuscatedName("fi.be")
	public int locStartCycle = 0;

	@ObfuscatedName("fi.bp")
	public int locEndCycle = 0;

	@ObfuscatedName("fi.ba")
	public int locOffsetX;

	@ObfuscatedName("fi.bc")
	public int locOffsetY;

	@ObfuscatedName("fi.br")
	public int locOffsetZ;

	@ObfuscatedName("fi.bb")
	public ModelLit locModel;

	@ObfuscatedName("fi.bd")
	public int minTileX;

	@ObfuscatedName("fi.cr")
	public int minTileZ;

	@ObfuscatedName("fi.cs")
	public int maxTileX;

	@ObfuscatedName("fi.cj")
	public int maxTileZ;

	@ObfuscatedName("fi.cl")
	public boolean lowMemory = false;

	@ObfuscatedName("fi.cp")
	public int team = 0;

	@ObfuscatedName("fi.am(Lev;I)V")
	public final void setAppearance(Packet arg0) {
		arg0.pos = 0;
		int var2 = arg0.g1();
		this.headiconPk = arg0.g1b();
		this.headiconPrayer = arg0.g1b();
		int var3 = -1;
		this.team = 0;
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
						this.team = var8;
					}
				}
			}
		}
		int[] var9 = new int[5];
		for (int var10 = 0; var10 < 5; var10++) {
			int var11 = arg0.g1();
			if (var11 < 0 || var11 >= PlayerModel.recol1d[var10].length) {
				var11 = 0;
			}
			var9[var10] = var11;
		}
		this.readyanim = arg0.g2();
		if (this.readyanim == 65535) {
			this.readyanim = -1;
		}
		this.turnleftanim = arg0.g2();
		if (this.turnleftanim == 65535) {
			this.turnleftanim = -1;
		}
		this.turnrightanim = this.turnleftanim;
		this.walkanim = arg0.g2();
		if (this.walkanim == 65535) {
			this.walkanim = -1;
		}
		this.walkanim_b = arg0.g2();
		if (this.walkanim_b == 65535) {
			this.walkanim_b = -1;
		}
		this.walkanim_l = arg0.g2();
		if (this.walkanim_l == 65535) {
			this.walkanim_l = -1;
		}
		this.walkanim_r = arg0.g2();
		if (this.walkanim_r == 65535) {
			this.walkanim_r = -1;
		}
		this.runanim = arg0.g2();
		if (this.runanim == 65535) {
			this.runanim = -1;
		}
		this.name = arg0.gjstr();
		if (Client.localPlayer == this) {
			JagException.username = this.name;
		}
		this.combatLevel = arg0.g1();
		this.skillLevel = arg0.g2();
		if (this.model == null) {
			this.model = new PlayerModel();
		}
		this.model.setAppearance(var4, var9, var2 == 1, var3);
	}

	@ObfuscatedName("fi.g(I)Lfo;")
	public final ModelLit getTempModel() {
		if (this.model == null) {
			return null;
		}
		SeqType var1 = this.primarySeqId != -1 && this.primarySeqDelay == 0 ? SeqType.get(this.primarySeqId) : null;
		SeqType var2 = this.secondarySeqId == -1 || this.lowMemory || this.secondarySeqId == this.readyanim && var1 != null ? null : SeqType.get(this.secondarySeqId);
		ModelLit var3 = this.model.getTempModel(var1, this.primarySeqFrame, var2, this.field2641);
		if (var3 == null) {
			return null;
		}
		var3.method3002();
		this.height = var3.minY;
		if (!this.lowMemory && this.spotanimId != -1 && this.spotanimFrame != -1) {
			ModelLit var4 = SpotAnimType.list(this.spotanimId).getTempModel2(this.spotanimFrame);
			if (var4 != null) {
				var4.translate(0, -this.field2629, 0);
				ModelLit[] var5 = new ModelLit[] { var3, var4 };
				var3 = new ModelLit(var5, 2);
			}
		}
		if (!this.lowMemory && this.locModel != null) {
			if (Client.loopCycle >= this.locEndCycle) {
				this.locModel = null;
			}
			if (Client.loopCycle >= this.locStartCycle && Client.loopCycle < this.locEndCycle) {
				ModelLit var6 = this.locModel;
				var6.translate(this.locOffsetX - this.x, this.locOffsetY - this.y, this.locOffsetZ - this.z);
				if (this.dstYaw == 512) {
					var6.rotate90();
					var6.rotate90();
					var6.rotate90();
				} else if (this.dstYaw == 1024) {
					var6.rotate90();
					var6.rotate90();
				} else if (this.dstYaw == 1536) {
					var6.rotate90();
				}
				ModelLit[] var7 = new ModelLit[] { var3, var6 };
				var3 = new ModelLit(var7, 2);
				if (this.dstYaw == 512) {
					var6.rotate90();
				} else if (this.dstYaw == 1024) {
					var6.rotate90();
					var6.rotate90();
				} else if (this.dstYaw == 1536) {
					var6.rotate90();
					var6.rotate90();
					var6.rotate90();
				}
				var6.translate(this.x - this.locOffsetX, this.y - this.locOffsetY, this.z - this.locOffsetZ);
			}
		}
		var3.useAABBMouseCheck = true;
		return var3;
	}

	@ObfuscatedName("fi.f(I)Z")
	public final boolean ready() {
		return this.model != null;
	}
}
