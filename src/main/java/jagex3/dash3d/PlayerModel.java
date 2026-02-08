package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.config.IdkType;
import jagex3.config.NpcType;
import jagex3.config.ObjType;
import jagex3.config.SeqType;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;

// jag::oldscape::rs2lib::PlayerModel
@ObfuscatedName("ct")
public class PlayerModel {

	@ObfuscatedName("ct.r")
	public int[] appearance;

	@ObfuscatedName("ct.d")
	public int[] colour;

	@ObfuscatedName("ct.l")
	public boolean gender;

	@ObfuscatedName("ct.m")
	public int transmog;

	@ObfuscatedName("ct.c")
	public long baseId;

	// jag::oldscape::rs2lib::PlayerModel::m_headModelHashToModelCacheID
	@ObfuscatedName("ct.n")
	public long headModelHashToModelCacheID;

	// jag::oldscape::rs2lib::PlayerModel::m_recol1s
	@ObfuscatedName("c.j")
	public static short[] recol1s;

	// jag::oldscape::rs2lib::PlayerModel::m_recol1d
	@ObfuscatedName("bw.z")
	public static short[][] recol1d;

	// jag::oldscape::rs2lib::PlayerModel::m_recol2s
	@ObfuscatedName("ct.g")
	public static short[] recol2s;

	// jag::oldscape::rs2lib::PlayerModel::m_recol2d
	@ObfuscatedName("ct.q")
	public static short[][] recol2d;

	// jag::oldscape::rs2lib::PlayerModel::m_basePartMap
	@ObfuscatedName("ct.i")
	public static final int[] basePartMap = new int[] { 8, 11, 4, 6, 9, 7, 10 };

	// jag::oldscape::rs2lib::PlayerModel::m_modelCache
	@ObfuscatedName("ct.s")
	public static LruCache modelCache = new LruCache(260);

	// jag::oldscape::rs2lib::PlayerModel::SetAppearance
	@ObfuscatedName("ct.r([I[IZII)V")
	public void setAppearance(int[] arg0, int[] arg1, boolean arg2, int arg3) {
		if (arg0 == null) {
			arg0 = new int[12];
			for (int var5 = 0; var5 < 7; var5++) {
				for (int var6 = 0; var6 < IdkType.numDefinitions; var6++) {
					IdkType var7 = IdkType.list(var6);
					if (var7 != null && !var7.disable && var7.type == var5 + (arg2 ? 7 : 0)) {
						arg0[basePartMap[var5]] = var6 + 256;
						break;
					}
				}
			}
		}
		this.appearance = arg0;
		this.colour = arg1;
		this.gender = arg2;
		this.transmog = arg3;
		this.calcBaseId();
	}

	// jag::oldscape::rs2lib::PlayerModel::IdkChangePart
	@ObfuscatedName("ct.d(IZI)V")
	public void idkChangePart(int arg0, boolean arg1) {
		if (arg0 == 1 && this.gender) {
			return;
		}
		int var3 = this.appearance[basePartMap[arg0]];
		if (var3 == 0) {
			return;
		}
		var3 -= 256;
		IdkType var4;
		do {
			if (arg1) {
				var3++;
				if (var3 >= IdkType.numDefinitions) {
					var3 = 0;
				}
			} else {
				var3--;
				if (var3 < 0) {
					var3 = IdkType.numDefinitions - 1;
				}
			}
			var4 = IdkType.list(var3);
		} while (var4 == null || var4.disable || var4.type != (this.gender ? 7 : 0) + arg0);
		this.appearance[basePartMap[arg0]] = var3 + 256;
		this.calcBaseId();
	}

	// jag::oldscape::rs2lib::PlayerModel::IdkChangeColour
	@ObfuscatedName("ct.l(IZI)V")
	public void idkChangeColour(int arg0, boolean arg1) {
		int var3 = this.colour[arg0];
		if (arg1) {
			var3++;
			if (var3 >= recol1d[arg0].length) {
				var3 = 0;
			}
		} else {
			var3--;
			if (var3 < 0) {
				var3 = recol1d[arg0].length - 1;
			}
		}
		this.colour[arg0] = var3;
		this.calcBaseId();
	}

	// jag::oldscape::rs2lib::PlayerModel::IdkChangeBodytype
	@ObfuscatedName("ct.m(ZI)V")
	public void idkChangeGender(boolean arg0) {
		if (this.gender != arg0) {
			this.setAppearance(null, this.colour, arg0, -1);
		}
	}

	// jag::oldscape::rs2lib::PlayerModel::IdkSaveDesign
	@ObfuscatedName("ct.c(Lev;I)V")
	public void idkSaveDesign(Packet arg0) {
		arg0.p1(this.gender ? 1 : 0);
		for (int var2 = 0; var2 < 7; var2++) {
			int var3 = this.appearance[basePartMap[var2]];
			if (var3 == 0) {
				arg0.p1(-1);
			} else {
				arg0.p1(var3 - 256);
			}
		}
		for (int var4 = 0; var4 < 5; var4++) {
			arg0.p1(this.colour[var4]);
		}
	}

	// jag::oldscape::rs2lib::PlayerModel::CalcBaseId
	@ObfuscatedName("ct.n(I)V")
	public void calcBaseId() {
		long var1 = this.baseId;
		int var3 = this.appearance[5];
		int var4 = this.appearance[9];
		this.appearance[5] = var4;
		this.appearance[9] = var3;
		this.baseId = 0L;
		for (int var5 = 0; var5 < 12; var5++) {
			this.baseId <<= 0x4;
			if (this.appearance[var5] >= 256) {
				this.baseId += this.appearance[var5] - 256;
			}
		}
		if (this.appearance[0] >= 256) {
			this.baseId += this.appearance[0] - 256 >> 4;
		}
		if (this.appearance[1] >= 256) {
			this.baseId += this.appearance[1] - 256 >> 8;
		}
		for (int var6 = 0; var6 < 5; var6++) {
			this.baseId <<= 0x3;
			this.baseId += this.colour[var6];
		}
		this.baseId <<= 0x1;
		this.baseId += this.gender ? 1 : 0;
		this.appearance[5] = var3;
		this.appearance[9] = var4;
		if (var1 != 0L && this.baseId != var1) {
			modelCache.remove(var1);
		}
	}

	// jag::oldscape::rs2lib::PlayerModel::GetTempModel
	@ObfuscatedName("ct.j(Leo;ILeo;IB)Lfo;")
	public ModelLit getTempModel(SeqType arg0, int arg1, SeqType arg2, int arg3) {
		if (this.transmog != -1) {
			return NpcType.list(this.transmog).getTempModel(arg0, arg1, arg2, arg3);
		}
		long var5 = this.baseId;
		int[] var7 = this.appearance;
		if (arg0 != null && (arg0.replaceheldleft >= 0 || arg0.replaceheldright >= 0)) {
			var7 = new int[12];
			for (int var8 = 0; var8 < 12; var8++) {
				var7[var8] = this.appearance[var8];
			}
			if (arg0.replaceheldleft >= 0) {
				var5 += arg0.replaceheldleft - this.appearance[5] << 40;
				var7[5] = arg0.replaceheldleft;
			}
			if (arg0.replaceheldright >= 0) {
				var5 += arg0.replaceheldright - this.appearance[3] << 48;
				var7[3] = arg0.replaceheldright;
			}
		}
		ModelLit var9 = (ModelLit) modelCache.find(var5);
		if (var9 == null) {
			boolean var10 = false;
			for (int var11 = 0; var11 < 12; var11++) {
				int var12 = var7[var11];
				if (var12 >= 256 && var12 < 512 && !IdkType.list(var12 - 256).checkModel()) {
					var10 = true;
				}
				if (var12 >= 512 && !ObjType.list(var12 - 512).checkWearModel(this.gender)) {
					var10 = true;
				}
			}
			if (var10) {
				if (this.headModelHashToModelCacheID != -1L) {
					var9 = (ModelLit) modelCache.find(this.headModelHashToModelCacheID);
				}
				if (var9 == null) {
					return null;
				}
			}
			if (var9 == null) {
				ModelUnlit[] var13 = new ModelUnlit[12];
				int var14 = 0;
				for (int var15 = 0; var15 < 12; var15++) {
					int var16 = var7[var15];
					if (var16 >= 256 && var16 < 512) {
						ModelUnlit var17 = IdkType.list(var16 - 256).getModelNoCheck();
						if (var17 != null) {
							var13[var14++] = var17;
						}
					}
					if (var16 >= 512) {
						ModelUnlit var18 = ObjType.list(var16 - 512).getWearModelNoCheck(this.gender);
						if (var18 != null) {
							var13[var14++] = var18;
						}
					}
				}
				ModelUnlit var19 = new ModelUnlit(var13, var14);
				for (int var20 = 0; var20 < 5; var20++) {
					if (this.colour[var20] < recol1d[var20].length) {
						var19.recolour(recol1s[var20], recol1d[var20][this.colour[var20]]);
					}
					if (this.colour[var20] < recol2d[var20].length) {
						var19.recolour(recol2s[var20], recol2d[var20][this.colour[var20]]);
					}
				}
				var9 = var19.light(64, 850, -30, -50, -30);
				modelCache.put(var9, var5);
				this.headModelHashToModelCacheID = var5;
			}
		}
		if (arg0 == null && arg2 == null) {
			return var9;
		}
		ModelLit var21;
		if (arg0 != null && arg2 != null) {
			var21 = arg0.splitAnimateModel(var9, arg1, arg2, arg3);
		} else if (arg0 == null) {
			var21 = arg2.animateModel(var9, arg3);
		} else {
			var21 = arg0.animateModel(var9, arg1);
		}
		return var21;
	}

	// jag::oldscape::rs2lib::PlayerModel::GetHeadModel
	@ObfuscatedName("ct.z(I)Lfw;")
	public ModelUnlit getHeadModel() {
		if (this.transmog != -1) {
			return NpcType.list(this.transmog).getHead();
		}
		boolean var1 = false;
		for (int var2 = 0; var2 < 12; var2++) {
			int var3 = this.appearance[var2];
			if (var3 >= 256 && var3 < 512 && !IdkType.list(var3 - 256).checkHead()) {
				var1 = true;
			}
			if (var3 >= 512 && !ObjType.list(var3 - 512).checkHeadModel(this.gender)) {
				var1 = true;
			}
		}
		if (var1) {
			return null;
		}
		ModelUnlit[] var4 = new ModelUnlit[12];
		int var5 = 0;
		for (int var6 = 0; var6 < 12; var6++) {
			int var7 = this.appearance[var6];
			if (var7 >= 256 && var7 < 512) {
				ModelUnlit var8 = IdkType.list(var7 - 256).getHeadNoCheck();
				if (var8 != null) {
					var4[var5++] = var8;
				}
			}
			if (var7 >= 512) {
				ModelUnlit var9 = ObjType.list(var7 - 512).getHeadModelNoCheck(this.gender);
				if (var9 != null) {
					var4[var5++] = var9;
				}
			}
		}
		ModelUnlit var10 = new ModelUnlit(var4, var5);
		for (int var11 = 0; var11 < 5; var11++) {
			if (this.colour[var11] < recol1d[var11].length) {
				var10.recolour(recol1s[var11], recol1d[var11][this.colour[var11]]);
			}
			if (this.colour[var11] < recol2d[var11].length) {
				var10.recolour(recol2s[var11], recol2d[var11][this.colour[var11]]);
			}
		}
		return var10;
	}

	@ObfuscatedName("ct.g(I)I")
	public int method1176() {
		if (this.transmog != -1) {
			return NpcType.list(this.transmog).id + 0x12345678;
		}

		return (this.appearance[11] << 5) + (this.appearance[8] << 10) + (this.appearance[0] << 15) + (this.colour[4] << 20) + (this.colour[0] << 25) + this.appearance[1];
	}

	// jag::oldscape::rs2lib::PlayerModel::ResetCache
	@ObfuscatedName("ba.q(I)V")
	public static void resetCache() {
		modelCache.clear();
	}
}
