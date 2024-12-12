package jagex2.graphics;

import deob.ObfuscatedName;
import jagex2.dash3d.entity.Entity;

@ObfuscatedName("fo")
public class ModelLit extends Entity {

	@ObfuscatedName("fo.j")
	public static ModelLit field2758 = new ModelLit();

	@ObfuscatedName("fo.z")
	public static byte[] field2770 = new byte[1];

	@ObfuscatedName("fo.g")
	public static ModelLit field2720 = new ModelLit();

	@ObfuscatedName("fo.q")
	public static byte[] field2725 = new byte[1];

	@ObfuscatedName("fo.i")
	public int vertexCount = 0;

	@ObfuscatedName("fo.s")
	public int[] vertexX;

	@ObfuscatedName("fo.u")
	public int[] vertexY;

	@ObfuscatedName("fo.v")
	public int[] vertexZ;

	@ObfuscatedName("fo.w")
	public int field2780 = 0;

	@ObfuscatedName("fo.e")
	public int[] faceVertexA;

	@ObfuscatedName("fo.b")
	public int[] faceVertexB;

	@ObfuscatedName("fo.y")
	public int[] faceVertexC;

	@ObfuscatedName("fo.t")
	public int[] faceColorA;

	@ObfuscatedName("fo.f")
	public int[] faceColorB;

	@ObfuscatedName("fo.k")
	public int[] faceColorC;

	@ObfuscatedName("fo.o")
	public byte[] facePriority;

	@ObfuscatedName("fo.a")
	public byte[] faceAlpha;

	@ObfuscatedName("fo.h")
	public byte[] field2735;

	@ObfuscatedName("fo.x")
	public short[] field2718;

	@ObfuscatedName("fo.p")
	public byte field2737 = 0;

	@ObfuscatedName("fo.ad")
	public int field2738 = 0;

	@ObfuscatedName("fo.ac")
	public int[] field2739;

	@ObfuscatedName("fo.aa")
	public int[] field2774;

	@ObfuscatedName("fo.as")
	public int[] field2765;

	@ObfuscatedName("fo.am")
	public int[][] field2742;

	@ObfuscatedName("fo.ap")
	public int[][] field2743;

	@ObfuscatedName("fo.av")
	public boolean picking = false;

	@ObfuscatedName("fo.ak")
	public int field2745;

	@ObfuscatedName("fo.az")
	public int field2746;

	@ObfuscatedName("fo.an")
	public int field2747;

	@ObfuscatedName("fo.ah")
	public int maxDepth;

	@ObfuscatedName("fo.ay")
	public int minDepth;

	@ObfuscatedName("fo.ab")
	public static boolean[] faceClippedX = new boolean[4096];

	@ObfuscatedName("fo.ao")
	public static boolean[] faceNearClipped = new boolean[4096];

	@ObfuscatedName("fo.ag")
	public static int[] vertexScreenX = new int[4096];

	@ObfuscatedName("fo.ar")
	public static int[] vertexScreenY = new int[4096];

	@ObfuscatedName("fo.aq")
	public static int[] vertexScreenZ = new int[4096];

	@ObfuscatedName("fo.at")
	public static int[] vertexViewSpaceX = new int[4096];

	@ObfuscatedName("fo.ae")
	public static int[] vertexViewSpaceY = new int[4096];

	@ObfuscatedName("fo.au")
	public static int[] vertexViewSpaceZ = new int[4096];

	@ObfuscatedName("fo.ai")
	public static int[] tmpDepthFaceCount = new int[1600];

	@ObfuscatedName("fo.aj")
	public static int[][] tmpDepthFaces = new int[1600][512];

	@ObfuscatedName("fo.aw")
	public static int[] tmpPriorityFaceCount = new int[12];

	@ObfuscatedName("fo.af")
	public static int[][] tmpPriorityFaces = new int[12][2000];

	@ObfuscatedName("fo.bh")
	public static int[] tmpPriority10FaceDepth = new int[2000];

	@ObfuscatedName("fo.bi")
	public static int[] tmpPriority11FaceDepth = new int[2000];

	@ObfuscatedName("fo.bs")
	public static int[] tmpPriorityDepthSum = new int[12];

	@ObfuscatedName("fo.bk")
	public static int[] clippedX = new int[10];

	@ObfuscatedName("fo.bv")
	public static int[] clippedY = new int[10];

	@ObfuscatedName("fo.bg")
	public static int[] clippedColor = new int[10];

	@ObfuscatedName("fo.bl")
	public static int baseX;

	@ObfuscatedName("fo.bt")
	public static int baseY;

	@ObfuscatedName("fo.bw")
	public static int baseZ;

	@ObfuscatedName("fo.by")
	public static boolean checkHover = false;

	@ObfuscatedName("fo.bx")
	public static int mouseX = 0;

	@ObfuscatedName("fo.bf")
	public static int mouseY = 0;

	@ObfuscatedName("fo.bu")
	public static int pickedCount = 0;

	@ObfuscatedName("fo.bo")
	public static int[] pickedBitsets = new int[1000];

	@ObfuscatedName("fo.bq")
	public static int[] sinTable = Pix3D.sinTable;

	@ObfuscatedName("fo.bj")
	public static int[] cosTable = Pix3D.cosTable;

	@ObfuscatedName("fo.bz")
	public static int[] palette = Pix3D.palette;

	@ObfuscatedName("fo.bm")
	public static int[] divTable2 = Pix3D.divTable2;

	public ModelLit() {
	}

	public ModelLit(ModelLit[] models, int count) {
		boolean var3 = false;
		boolean var4 = false;
		boolean var5 = false;
		boolean var6 = false;
		this.vertexCount = 0;
		this.field2780 = 0;
		this.field2738 = 0;
		this.field2737 = -1;
		for (int var7 = 0; var7 < count; var7++) {
			ModelLit var8 = models[var7];
			if (var8 != null) {
				this.vertexCount += var8.vertexCount;
				this.field2780 += var8.field2780;
				this.field2738 += var8.field2738;
				if (var8.facePriority == null) {
					if (this.field2737 == -1) {
						this.field2737 = var8.field2737;
					}
					if (this.field2737 != var8.field2737) {
						var3 = true;
					}
				} else {
					var3 = true;
				}
				var4 |= var8.faceAlpha != null;
				var5 |= var8.field2718 != null;
				var6 |= var8.field2735 != null;
			}
		}
		this.vertexX = new int[this.vertexCount];
		this.vertexY = new int[this.vertexCount];
		this.vertexZ = new int[this.vertexCount];
		this.faceVertexA = new int[this.field2780];
		this.faceVertexB = new int[this.field2780];
		this.faceVertexC = new int[this.field2780];
		this.faceColorA = new int[this.field2780];
		this.faceColorB = new int[this.field2780];
		this.faceColorC = new int[this.field2780];
		if (var3) {
			this.facePriority = new byte[this.field2780];
		}
		if (var4) {
			this.faceAlpha = new byte[this.field2780];
		}
		if (var5) {
			this.field2718 = new short[this.field2780];
		}
		if (var6) {
			this.field2735 = new byte[this.field2780];
		}
		if (this.field2738 > 0) {
			this.field2739 = new int[this.field2738];
			this.field2774 = new int[this.field2738];
			this.field2765 = new int[this.field2738];
		}
		this.vertexCount = 0;
		this.field2780 = 0;
		this.field2738 = 0;
		for (int var9 = 0; var9 < count; var9++) {
			ModelLit var10 = models[var9];
			if (var10 != null) {
				for (int var11 = 0; var11 < var10.field2780; var11++) {
					this.faceVertexA[this.field2780] = var10.faceVertexA[var11] + this.vertexCount;
					this.faceVertexB[this.field2780] = var10.faceVertexB[var11] + this.vertexCount;
					this.faceVertexC[this.field2780] = var10.faceVertexC[var11] + this.vertexCount;
					this.faceColorA[this.field2780] = var10.faceColorA[var11];
					this.faceColorB[this.field2780] = var10.faceColorB[var11];
					this.faceColorC[this.field2780] = var10.faceColorC[var11];
					if (var3) {
						if (var10.facePriority == null) {
							this.facePriority[this.field2780] = var10.field2737;
						} else {
							this.facePriority[this.field2780] = var10.facePriority[var11];
						}
					}
					if (var4 && var10.faceAlpha != null) {
						this.faceAlpha[this.field2780] = var10.faceAlpha[var11];
					}
					if (var5) {
						if (var10.field2718 == null) {
							this.field2718[this.field2780] = -1;
						} else {
							this.field2718[this.field2780] = var10.field2718[var11];
						}
					}
					if (var6) {
						if (var10.field2735 == null || var10.field2735[var11] == -1) {
							this.field2735[this.field2780] = -1;
						} else {
							this.field2735[this.field2780] = (byte) (var10.field2735[var11] + this.field2738);
						}
					}
					this.field2780++;
				}
				for (int var12 = 0; var12 < var10.field2738; var12++) {
					this.field2739[this.field2738] = var10.field2739[var12] + this.vertexCount;
					this.field2774[this.field2738] = var10.field2774[var12] + this.vertexCount;
					this.field2765[this.field2738] = var10.field2765[var12] + this.vertexCount;
					this.field2738++;
				}
				for (int var13 = 0; var13 < var10.vertexCount; var13++) {
					this.vertexX[this.vertexCount] = var10.vertexX[var13];
					this.vertexY[this.vertexCount] = var10.vertexY[var13];
					this.vertexZ[this.vertexCount] = var10.vertexZ[var13];
					this.vertexCount++;
				}
			}
		}
	}

	@ObfuscatedName("fo.b([[IIIIZI)Lfo;")
	public ModelLit method3054(int[][] arg0, int arg1, int arg2, int arg3, boolean arg4, int arg5) {
		this.method3002();
		int var7 = arg1 - this.field2747;
		int var8 = this.field2747 + arg1;
		int var9 = arg3 - this.field2747;
		int var10 = this.field2747 + arg3;
		if (var7 < 0 || var8 + 128 >> 7 >= arg0.length || var9 < 0 || var10 + 128 >> 7 >= arg0[0].length) {
			return this;
		}
		int var11 = var7 >> 7;
		int var12 = var8 + 127 >> 7;
		int var13 = var9 >> 7;
		int var14 = var10 + 127 >> 7;
		if (arg0[var11][var13] == arg2 && arg0[var12][var13] == arg2 && arg0[var11][var14] == arg2 && arg0[var12][var14] == arg2) {
			return this;
		}
		ModelLit var15;
		if (arg4) {
			var15 = new ModelLit();
			var15.vertexCount = this.vertexCount;
			var15.field2780 = this.field2780;
			var15.field2738 = this.field2738;
			var15.vertexX = this.vertexX;
			var15.vertexZ = this.vertexZ;
			var15.faceVertexA = this.faceVertexA;
			var15.faceVertexB = this.faceVertexB;
			var15.faceVertexC = this.faceVertexC;
			var15.faceColorA = this.faceColorA;
			var15.faceColorB = this.faceColorB;
			var15.faceColorC = this.faceColorC;
			var15.facePriority = this.facePriority;
			var15.faceAlpha = this.faceAlpha;
			var15.field2735 = this.field2735;
			var15.field2718 = this.field2718;
			var15.field2737 = this.field2737;
			var15.field2739 = this.field2739;
			var15.field2774 = this.field2774;
			var15.field2765 = this.field2765;
			var15.field2742 = this.field2742;
			var15.field2743 = this.field2743;
			var15.picking = this.picking;
			var15.vertexY = new int[var15.vertexCount];
		} else {
			var15 = this;
		}
		if (arg5 == 0) {
			for (int var16 = 0; var16 < var15.vertexCount; var16++) {
				int var17 = this.vertexX[var16] + arg1;
				int var18 = this.vertexZ[var16] + arg3;
				int var19 = var17 & 0x7F;
				int var20 = var18 & 0x7F;
				int var21 = var17 >> 7;
				int var22 = var18 >> 7;
				int var23 = (128 - var19) * arg0[var21][var22] + arg0[var21 + 1][var22] * var19 >> 7;
				int var24 = (128 - var19) * arg0[var21][var22 + 1] + arg0[var21 + 1][var22 + 1] * var19 >> 7;
				int var25 = (128 - var20) * var23 + var20 * var24 >> 7;
				var15.vertexY[var16] = this.vertexY[var16] + var25 - arg2;
			}
		} else {
			for (int var26 = 0; var26 < var15.vertexCount; var26++) {
				int var27 = (-this.vertexY[var26] << 16) / this.minY;
				if (var27 < arg5) {
					int var28 = this.vertexX[var26] + arg1;
					int var29 = this.vertexZ[var26] + arg3;
					int var30 = var28 & 0x7F;
					int var31 = var29 & 0x7F;
					int var32 = var28 >> 7;
					int var33 = var29 >> 7;
					int var34 = (128 - var30) * arg0[var32][var33] + arg0[var32 + 1][var33] * var30 >> 7;
					int var35 = (128 - var30) * arg0[var32][var33 + 1] + arg0[var32 + 1][var33 + 1] * var30 >> 7;
					int var36 = (128 - var31) * var34 + var31 * var35 >> 7;
					var15.vertexY[var26] = (var36 - arg2) * (arg5 - var27) / arg5 + this.vertexY[var26];
				}
			}
		}
		var15.field2745 = 0;
		return var15;
	}

	@ObfuscatedName("fo.y(Z)Lfo;")
	public ModelLit method2999(boolean arg0) {
		if (!arg0 && field2770.length < this.field2780) {
			field2770 = new byte[this.field2780 + 100];
		}
		return this.method3046(arg0, field2758, field2770);
	}

	@ObfuscatedName("fo.t(Z)Lfo;")
	public ModelLit method3040(boolean arg0) {
		if (!arg0 && field2725.length < this.field2780) {
			field2725 = new byte[this.field2780 + 100];
		}
		return this.method3046(arg0, field2720, field2725);
	}

	@ObfuscatedName("fo.f(ZLfo;[B)Lfo;")
	public ModelLit method3046(boolean copyAlpha, ModelLit model, byte[] arg2) {
		model.vertexCount = this.vertexCount;
		model.field2780 = this.field2780;
		model.field2738 = this.field2738;
		if (model.vertexX == null || model.vertexX.length < this.vertexCount) {
			model.vertexX = new int[this.vertexCount + 100];
			model.vertexY = new int[this.vertexCount + 100];
			model.vertexZ = new int[this.vertexCount + 100];
		}
		for (int var4 = 0; var4 < this.vertexCount; var4++) {
			model.vertexX[var4] = this.vertexX[var4];
			model.vertexY[var4] = this.vertexY[var4];
			model.vertexZ[var4] = this.vertexZ[var4];
		}
		if (copyAlpha) {
			model.faceAlpha = this.faceAlpha;
		} else {
			model.faceAlpha = arg2;
			if (this.faceAlpha == null) {
				for (int var5 = 0; var5 < this.field2780; var5++) {
					model.faceAlpha[var5] = 0;
				}
			} else {
				for (int var6 = 0; var6 < this.field2780; var6++) {
					model.faceAlpha[var6] = this.faceAlpha[var6];
				}
			}
		}

		model.faceVertexA = this.faceVertexA;
		model.faceVertexB = this.faceVertexB;
		model.faceVertexC = this.faceVertexC;
		model.faceColorA = this.faceColorA;
		model.faceColorB = this.faceColorB;
		model.faceColorC = this.faceColorC;
		model.facePriority = this.facePriority;
		model.field2735 = this.field2735;
		model.field2718 = this.field2718;
		model.field2737 = this.field2737;
		model.field2739 = this.field2739;
		model.field2774 = this.field2774;
		model.field2765 = this.field2765;
		model.field2742 = this.field2742;
		model.field2743 = this.field2743;
		model.picking = this.picking;
		model.field2745 = 0;
		return model;
	}

	@ObfuscatedName("fo.k()V")
	public void method3002() {
		if (this.field2745 == 1) {
			return;
		}
		this.field2745 = 1;
		this.minY = 0;
		this.field2746 = 0;
		this.field2747 = 0;
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			int var2 = this.vertexX[var1];
			int var3 = this.vertexY[var1];
			int var4 = this.vertexZ[var1];
			if (-var3 > this.minY) {
				this.minY = -var3;
			}
			if (var3 > this.field2746) {
				this.field2746 = var3;
			}
			int var5 = var2 * var2 + var4 * var4;
			if (var5 > this.field2747) {
				this.field2747 = var5;
			}
		}
		this.field2747 = (int) (Math.sqrt((double) this.field2747) + 0.99D);
		this.minDepth = (int) (Math.sqrt((double) (this.minY * this.minY + this.field2747 * this.field2747)) + 0.99D);
		this.maxDepth = this.minDepth + (int) (Math.sqrt((double) (this.field2747 * this.field2747 + this.field2746 * this.field2746)) + 0.99D);
	}

	@ObfuscatedName("fo.o()V")
	public void method3003() {
		if (this.field2745 == 2) {
			return;
		}
		this.field2745 = 2;
		this.field2747 = 0;
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			int var2 = this.vertexX[var1];
			int var3 = this.vertexY[var1];
			int var4 = this.vertexZ[var1];
			int var5 = var3 * var3 + var2 * var2 + var4 * var4;
			if (var5 > this.field2747) {
				this.field2747 = var5;
			}
		}
		this.field2747 = (int) (Math.sqrt((double) this.field2747) + 0.99D);
		this.minDepth = this.field2747;
		this.maxDepth = this.field2747 + this.field2747;
	}

	@ObfuscatedName("fo.a()I")
	public int method3004() {
		this.method3002();
		return this.field2747;
	}

	@ObfuscatedName("fo.h(Lfr;I)V")
	public void method3005(AnimFrameset arg0, int arg1) {
		if (this.field2742 == null || arg1 == -1) {
			return;
		}
		AnimFrame var3 = arg0.field2488[arg1];
		AnimBase var4 = var3.base;
		baseX = 0;
		baseY = 0;
		baseZ = 0;
		for (int var5 = 0; var5 < var3.length; var5++) {
			int var6 = var3.groups[var5];
			this.method3007(var4.types[var6], var4.labels[var6], var3.x[var5], var3.y[var5], var3.z[var5]);
		}
		this.field2745 = 0;
	}

	@ObfuscatedName("fo.x(Lfr;ILfr;I[I)V")
	public void method3006(AnimFrameset arg0, int arg1, AnimFrameset arg2, int arg3, int[] arg4) {
		if (arg1 == -1) {
			return;
		}
		if (arg4 == null || arg3 == -1) {
			this.method3005(arg0, arg1);
			return;
		}
		AnimFrame var6 = arg0.field2488[arg1];
		AnimFrame var7 = arg2.field2488[arg3];
		AnimBase var8 = var6.base;
		baseX = 0;
		baseY = 0;
		baseZ = 0;
		byte var9 = 0;
		int var17 = var9 + 1;
		int var10 = arg4[var9];
		for (int var11 = 0; var11 < var6.length; var11++) {
			int var12 = var6.groups[var11];
			while (var12 > var10) {
				var10 = arg4[var17++];
			}
			if (var10 != var12 || var8.types[var12] == 0) {
				this.method3007(var8.types[var12], var8.labels[var12], var6.x[var11], var6.y[var11], var6.z[var11]);
			}
		}
		baseX = 0;
		baseY = 0;
		baseZ = 0;
		byte var13 = 0;
		int var18 = var13 + 1;
		int var14 = arg4[var13];
		for (int var15 = 0; var15 < var7.length; var15++) {
			int var16 = var7.groups[var15];
			while (var16 > var14) {
				var14 = arg4[var18++];
			}
			if (var14 == var16 || var8.types[var16] == 0) {
				this.method3007(var8.types[var16], var8.labels[var16], var7.x[var15], var7.y[var15], var7.z[var15]);
			}
		}
		this.field2745 = 0;
	}

	@ObfuscatedName("fo.p(I[IIII)V")
	public void method3007(int arg0, int[] arg1, int arg2, int arg3, int arg4) {
		int var6 = arg1.length;
		if (arg0 == 0) {
			int var7 = 0;
			baseX = 0;
			baseY = 0;
			baseZ = 0;
			for (int var8 = 0; var8 < var6; var8++) {
				int var9 = arg1[var8];
				if (var9 < this.field2742.length) {
					int[] var10 = this.field2742[var9];
					for (int var11 = 0; var11 < var10.length; var11++) {
						int var12 = var10[var11];
						baseX += this.vertexX[var12];
						baseY += this.vertexY[var12];
						baseZ += this.vertexZ[var12];
						var7++;
					}
				}
			}
			if (var7 > 0) {
				baseX = baseX / var7 + arg2;
				baseY = baseY / var7 + arg3;
				baseZ = baseZ / var7 + arg4;
			} else {
				baseX = arg2;
				baseY = arg3;
				baseZ = arg4;
			}
		} else if (arg0 == 1) {
			for (int var13 = 0; var13 < var6; var13++) {
				int var14 = arg1[var13];
				if (var14 < this.field2742.length) {
					int[] var15 = this.field2742[var14];
					for (int var16 = 0; var16 < var15.length; var16++) {
						int var17 = var15[var16];
						this.vertexX[var17] += arg2;
						this.vertexY[var17] += arg3;
						this.vertexZ[var17] += arg4;
					}
				}
			}
		} else if (arg0 == 2) {
			for (int var18 = 0; var18 < var6; var18++) {
				int var19 = arg1[var18];
				if (var19 < this.field2742.length) {
					int[] var20 = this.field2742[var19];
					for (int var21 = 0; var21 < var20.length; var21++) {
						int var22 = var20[var21];
						this.vertexX[var22] -= baseX;
						this.vertexY[var22] -= baseY;
						this.vertexZ[var22] -= baseZ;
						int var23 = (arg2 & 0xFF) * 8;
						int var24 = (arg3 & 0xFF) * 8;
						int var25 = (arg4 & 0xFF) * 8;
						if (var25 != 0) {
							int var26 = sinTable[var25];
							int var27 = cosTable[var25];
							int var28 = this.vertexY[var22] * var26 + this.vertexX[var22] * var27 >> 16;
							this.vertexY[var22] = this.vertexY[var22] * var27 - this.vertexX[var22] * var26 >> 16;
							this.vertexX[var22] = var28;
						}
						if (var23 != 0) {
							int var29 = sinTable[var23];
							int var30 = cosTable[var23];
							int var31 = this.vertexY[var22] * var30 - this.vertexZ[var22] * var29 >> 16;
							this.vertexZ[var22] = this.vertexZ[var22] * var30 + this.vertexY[var22] * var29 >> 16;
							this.vertexY[var22] = var31;
						}
						if (var24 != 0) {
							int var32 = sinTable[var24];
							int var33 = cosTable[var24];
							int var34 = this.vertexZ[var22] * var32 + this.vertexX[var22] * var33 >> 16;
							this.vertexZ[var22] = this.vertexZ[var22] * var33 - this.vertexX[var22] * var32 >> 16;
							this.vertexX[var22] = var34;
						}
						this.vertexX[var22] += baseX;
						this.vertexY[var22] += baseY;
						this.vertexZ[var22] += baseZ;
					}
				}
			}
		} else if (arg0 == 3) {
			for (int var35 = 0; var35 < var6; var35++) {
				int var36 = arg1[var35];
				if (var36 < this.field2742.length) {
					int[] var37 = this.field2742[var36];
					for (int var38 = 0; var38 < var37.length; var38++) {
						int var39 = var37[var38];
						this.vertexX[var39] -= baseX;
						this.vertexY[var39] -= baseY;
						this.vertexZ[var39] -= baseZ;
						this.vertexX[var39] = this.vertexX[var39] * arg2 / 128;
						this.vertexY[var39] = this.vertexY[var39] * arg3 / 128;
						this.vertexZ[var39] = this.vertexZ[var39] * arg4 / 128;
						this.vertexX[var39] += baseX;
						this.vertexY[var39] += baseY;
						this.vertexZ[var39] += baseZ;
					}
				}
			}
		} else if (arg0 == 5 && (this.field2743 != null && this.faceAlpha != null)) {
			for (int var40 = 0; var40 < var6; var40++) {
				int var41 = arg1[var40];
				if (var41 < this.field2743.length) {
					int[] var42 = this.field2743[var41];
					for (int var43 = 0; var43 < var42.length; var43++) {
						int var44 = var42[var43];
						int var45 = (this.faceAlpha[var44] & 0xFF) + arg2 * 8;
						if (var45 < 0) {
							var45 = 0;
						} else if (var45 > 255) {
							var45 = 255;
						}
						this.faceAlpha[var44] = (byte) var45;
					}
				}
			}
		}
	}

	@ObfuscatedName("fo.ad()V")
	public void method3008() {
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			int var2 = this.vertexX[var1];
			this.vertexX[var1] = this.vertexZ[var1];
			this.vertexZ[var1] = -var2;
		}
		this.field2745 = 0;
	}

	@ObfuscatedName("fo.ac()V")
	public void method3009() {
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			this.vertexX[var1] = -this.vertexX[var1];
			this.vertexZ[var1] = -this.vertexZ[var1];
		}
		this.field2745 = 0;
	}

	@ObfuscatedName("fo.aa()V")
	public void method3010() {
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			int var2 = this.vertexZ[var1];
			this.vertexZ[var1] = this.vertexX[var1];
			this.vertexX[var1] = -var2;
		}
		this.field2745 = 0;
	}

	@ObfuscatedName("fo.as(I)V")
	public void method3011(int arg0) {
		int var2 = sinTable[arg0];
		int var3 = cosTable[arg0];
		for (int var4 = 0; var4 < this.vertexCount; var4++) {
			int var5 = this.vertexY[var4] * var3 - this.vertexZ[var4] * var2 >> 16;
			this.vertexZ[var4] = this.vertexZ[var4] * var3 + this.vertexY[var4] * var2 >> 16;
			this.vertexY[var4] = var5;
		}
		this.field2745 = 0;
	}

	@ObfuscatedName("fo.am(III)V")
	public void method3012(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < this.vertexCount; var4++) {
			this.vertexX[var4] += arg0;
			this.vertexY[var4] += arg1;
			this.vertexZ[var4] += arg2;
		}
		this.field2745 = 0;
	}

	@ObfuscatedName("fo.ap(III)V")
	public void scale(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < this.vertexCount; var4++) {
			this.vertexX[var4] = this.vertexX[var4] * arg0 / 128;
			this.vertexY[var4] = this.vertexY[var4] * arg1 / 128;
			this.vertexZ[var4] = this.vertexZ[var4] * arg2 / 128;
		}
		this.field2745 = 0;
	}

	@ObfuscatedName("fo.av(IIIIIII)V")
	public final void method3014(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		tmpDepthFaceCount[0] = -1;
		if (this.field2745 != 2 && this.field2745 != 1) {
			this.method3003();
		}
		int var8 = Pix3D.centerX;
		int var9 = Pix3D.centerY;
		int var10 = sinTable[arg0];
		int var11 = cosTable[arg0];
		int var12 = sinTable[arg1];
		int var13 = cosTable[arg1];
		int var14 = sinTable[arg2];
		int var15 = cosTable[arg2];
		int var16 = sinTable[arg3];
		int var17 = cosTable[arg3];
		int var18 = arg5 * var16 + arg6 * var17 >> 16;
		for (int var19 = 0; var19 < this.vertexCount; var19++) {
			int var20 = this.vertexX[var19];
			int var21 = this.vertexY[var19];
			int var22 = this.vertexZ[var19];
			if (arg2 != 0) {
				int var23 = var14 * var21 + var15 * var20 >> 16;
				var21 = var15 * var21 - var14 * var20 >> 16;
				var20 = var23;
			}
			if (arg0 != 0) {
				int var24 = var11 * var21 - var10 * var22 >> 16;
				var22 = var10 * var21 + var11 * var22 >> 16;
				var21 = var24;
			}
			if (arg1 != 0) {
				int var25 = var12 * var22 + var13 * var20 >> 16;
				var22 = var13 * var22 - var12 * var20 >> 16;
				var20 = var25;
			}
			int var26 = arg4 + var20;
			int var27 = arg5 + var21;
			int var28 = arg6 + var22;
			int var29 = var17 * var27 - var16 * var28 >> 16;
			int var30 = var16 * var27 + var17 * var28 >> 16;
			vertexScreenZ[var19] = var30 - var18;
			vertexScreenX[var19] = (var26 << 9) / var30 + var8;
			vertexScreenY[var19] = (var29 << 9) / var30 + var9;
			if (this.field2738 > 0) {
				vertexViewSpaceX[var19] = var26;
				vertexViewSpaceY[var19] = var29;
				vertexViewSpaceZ[var19] = var30;
			}
		}
		try {
			this.draw(false, false, 0);
		} catch (Exception var33) {
		}
	}

	@ObfuscatedName("fo.ak(IIIIIIII)V")
	public final void method3020(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		tmpDepthFaceCount[0] = -1;
		if (this.field2745 != 2 && this.field2745 != 1) {
			this.method3003();
		}
		int var9 = Pix3D.centerX;
		int var10 = Pix3D.centerY;
		int var11 = sinTable[arg0];
		int var12 = cosTable[arg0];
		int var13 = sinTable[arg1];
		int var14 = cosTable[arg1];
		int var15 = sinTable[arg2];
		int var16 = cosTable[arg2];
		int var17 = sinTable[arg3];
		int var18 = cosTable[arg3];
		int var19 = arg5 * var17 + arg6 * var18 >> 16;
		for (int var20 = 0; var20 < this.vertexCount; var20++) {
			int var21 = this.vertexX[var20];
			int var22 = this.vertexY[var20];
			int var23 = this.vertexZ[var20];
			if (arg2 != 0) {
				int var24 = var15 * var22 + var16 * var21 >> 16;
				var22 = var16 * var22 - var15 * var21 >> 16;
				var21 = var24;
			}
			if (arg0 != 0) {
				int var25 = var12 * var22 - var11 * var23 >> 16;
				var23 = var11 * var22 + var12 * var23 >> 16;
				var22 = var25;
			}
			if (arg1 != 0) {
				int var26 = var13 * var23 + var14 * var21 >> 16;
				var23 = var14 * var23 - var13 * var21 >> 16;
				var21 = var26;
			}
			int var27 = arg4 + var21;
			int var28 = arg5 + var22;
			int var29 = arg6 + var23;
			int var30 = var18 * var28 - var17 * var29 >> 16;
			int var31 = var17 * var28 + var18 * var29 >> 16;
			vertexScreenZ[var20] = var31 - var19;
			vertexScreenX[var20] = (var27 << 9) / arg7 + var9;
			vertexScreenY[var20] = (var30 << 9) / arg7 + var10;
			if (this.field2738 > 0) {
				vertexViewSpaceX[var20] = var27;
				vertexViewSpaceY[var20] = var30;
				vertexViewSpaceZ[var20] = var31;
			}
		}
		try {
			this.draw(false, false, 0);
		} catch (Exception var34) {
		}
	}

	@ObfuscatedName("fo.z(IIIIIIIII)V")
	public void draw(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int bitset) {
		tmpDepthFaceCount[0] = -1;

		if (this.field2745 != 1) {
			this.method3002();
		}

		int var10 = arg4 * arg7 - arg3 * arg5 >> 16;
		int var11 = arg1 * arg6 + arg2 * var10 >> 16;
		int var12 = this.field2747 * arg2 >> 16;
		int var13 = var11 + var12;
		if (var13 <= 50 || var11 >= 3500) {
			return;
		}

		int var14 = arg3 * arg7 + arg4 * arg5 >> 16;
		int var15 = var14 - this.field2747 << 9;
		if (var15 / var13 >= Pix3D.field2534) {
			return;
		}

		int var16 = this.field2747 + var14 << 9;
		if (var16 / var13 <= Pix3D.field2542) {
			return;
		}

		int var17 = arg2 * arg6 - arg1 * var10 >> 16;
		int var18 = this.field2747 * arg1 >> 16;
		int var19 = var17 + var18 << 9;
		if (var19 / var13 <= Pix3D.field2535) {
			return;
		}

		int var20 = (this.minY * arg2 >> 16) + var18;
		int var21 = var17 - var20 << 9;
		if (var21 / var13 >= Pix3D.field2537) {
			return;
		}

		int var22 = (this.minY * arg1 >> 16) + var12;
		boolean clipped = false;
		boolean var24 = false;
		if (var11 - var22 <= 50) {
			var24 = true;
		}

		boolean var25 = var24 || this.field2738 > 0;
		boolean picking = false;

		if (bitset > 0 && checkHover) {
			int var27 = var11 - var12;
			if (var27 <= 50) {
				var27 = 50;
			}
			int var28;
			int var29;
			if (var14 > 0) {
				var28 = var15 / var13;
				var29 = var16 / var27;
			} else {
				var29 = var16 / var13;
				var28 = var15 / var27;
			}
			int var30;
			int var31;
			if (var17 > 0) {
				var30 = var21 / var13;
				var31 = var19 / var27;
			} else {
				var31 = var19 / var13;
				var30 = var21 / var27;
			}
			int var32 = mouseX - Pix3D.centerX;
			int var33 = mouseY - Pix3D.centerY;
			if (var32 > var28 && var32 < var29 && var33 > var30 && var33 < var31) {
				if (this.picking) {
					pickedBitsets[pickedCount++] = bitset;
				} else {
					picking = true;
				}
			}
		}

		int var34 = Pix3D.centerX;
		int var35 = Pix3D.centerY;

		int var36 = 0;
		int var37 = 0;
		if (arg0 != 0) {
			var36 = sinTable[arg0];
			var37 = cosTable[arg0];
		}

		for (int var38 = 0; var38 < this.vertexCount; var38++) {
			int var39 = this.vertexX[var38];
			int var40 = this.vertexY[var38];
			int var41 = this.vertexZ[var38];

			if (arg0 != 0) {
				int var42 = var36 * var41 + var37 * var39 >> 16;
				var41 = var37 * var41 - var36 * var39 >> 16;
				var39 = var42;
			}

			int var43 = arg5 + var39;
			int var44 = arg6 + var40;
			int var45 = arg7 + var41;
			int var46 = arg3 * var45 + arg4 * var43 >> 16;
			int var47 = arg4 * var45 - arg3 * var43 >> 16;
			int var49 = arg2 * var44 - arg1 * var47 >> 16;
			int var50 = arg1 * var44 + arg2 * var47 >> 16;
			vertexScreenZ[var38] = var50 - var11;

			if (var50 >= 50) {
				vertexScreenX[var38] = (var46 << 9) / var50 + var34;
				vertexScreenY[var38] = (var49 << 9) / var50 + var35;
			} else {
				vertexScreenX[var38] = -5000;
				clipped = true;
			}

			if (var25) {
				vertexViewSpaceX[var38] = var46;
				vertexViewSpaceY[var38] = var49;
				vertexViewSpaceZ[var38] = var50;
			}
		}

		try {
			this.draw(clipped, picking, bitset);
		} catch (Exception var53) {
		}
	}

	@ObfuscatedName("fo.az(ZZI)V")
	public final void draw(boolean clipped, boolean picking, int bitset) {
		if (this.maxDepth >= 1600) {
			return;
		}

		for (int i = 0; i < this.maxDepth; i++) {
			tmpDepthFaceCount[i] = 0;
		}

		for (int f = 0; f < this.field2780; f++) {
			if (this.faceColorC[f] != -2) {
				int var6 = this.faceVertexA[f];
				int var7 = this.faceVertexB[f];
				int var8 = this.faceVertexC[f];

				int var9 = vertexScreenX[var6];
				int var10 = vertexScreenX[var7];
				int var11 = vertexScreenX[var8];

				if (clipped && (var9 == -5000 || var10 == -5000 || var11 == -5000)) {
					int var12 = vertexViewSpaceX[var6];
					int var13 = vertexViewSpaceX[var7];
					int var14 = vertexViewSpaceX[var8];

					int var15 = vertexViewSpaceY[var6];
					int var16 = vertexViewSpaceY[var7];
					int var17 = vertexViewSpaceY[var8];

					int var18 = vertexViewSpaceZ[var6];
					int var19 = vertexViewSpaceZ[var7];
					int var20 = vertexViewSpaceZ[var8];

					int var21 = var12 - var13;
					int var22 = var14 - var13;
					int var23 = var15 - var16;
					int var24 = var17 - var16;
					int var25 = var18 - var19;
					int var26 = var20 - var19;
					int var27 = var23 * var26 - var24 * var25;
					int var28 = var22 * var25 - var21 * var26;
					int var29 = var21 * var24 - var22 * var23;
					if (var19 * var29 + var13 * var27 + var16 * var28 > 0) {
						faceNearClipped[f] = true;
						int var30 = (vertexScreenZ[var6] + vertexScreenZ[var7] + vertexScreenZ[var8]) / 3 + this.minDepth;
						tmpDepthFaces[var30][tmpDepthFaceCount[var30]++] = f;
					}
				} else {
					if (picking && this.pointWithinTriangle(mouseX, mouseY, vertexScreenY[var6], vertexScreenY[var7], vertexScreenY[var8], var9, var10, var11)) {
						pickedBitsets[pickedCount++] = bitset;
						picking = false;
					}

					if ((vertexScreenY[var8] - vertexScreenY[var7]) * (var9 - var10) - (vertexScreenY[var6] - vertexScreenY[var7]) * (var11 - var10) > 0) {
						faceNearClipped[f] = false;

						if (var9 >= 0 && var10 >= 0 && var11 >= 0 && var9 <= Pix3D.boundX && var10 <= Pix3D.boundX && var11 <= Pix3D.boundX) {
							faceClippedX[f] = false;
						} else {
							faceClippedX[f] = true;
						}

						int var31 = (vertexScreenZ[var6] + vertexScreenZ[var7] + vertexScreenZ[var8]) / 3 + this.minDepth;
						tmpDepthFaces[var31][tmpDepthFaceCount[var31]++] = f;
					}
				}
			}
		}

		if (this.facePriority == null) {
			for (int depth = this.maxDepth - 1; depth >= 0; depth--) {
				int count = tmpDepthFaceCount[depth];
				if (count > 0) {
					int[] faces = tmpDepthFaces[depth];
					for (int f = 0; f < count; f++) {
						this.drawFace(faces[f]);
					}
				}
			}

			return;
		}

		for (int priority = 0; priority < 12; priority++) {
			tmpPriorityFaceCount[priority] = 0;
			tmpPriorityDepthSum[priority] = 0;
		}

		for (int depth = this.maxDepth - 1; depth >= 0; depth--) {
			int faceCount = tmpDepthFaceCount[depth];

			if (faceCount > 0) {
				int[] faces = tmpDepthFaces[depth];
				for (int i = 0; i < faceCount; i++) {
					int priorityDepth = faces[i];
					byte priorityFace = this.facePriority[priorityDepth];
					int priorityFaceCount = tmpPriorityFaceCount[priorityFace]++;

					tmpPriorityFaces[priorityFace][priorityFaceCount] = priorityDepth;

					if (priorityFace < 10) {
						tmpPriorityDepthSum[priorityFace] += depth;
					} else if (priorityFace == 10) {
						tmpPriority10FaceDepth[priorityFaceCount] = depth;
					} else {
						tmpPriority11FaceDepth[priorityFaceCount] = depth;
					}
				}
			}
		}

		int var44 = 0;
		if (tmpPriorityFaceCount[1] > 0 || tmpPriorityFaceCount[2] > 0) {
			var44 = (tmpPriorityDepthSum[1] + tmpPriorityDepthSum[2]) / (tmpPriorityFaceCount[1] + tmpPriorityFaceCount[2]);
		}

		int var45 = 0;
		if (tmpPriorityFaceCount[3] > 0 || tmpPriorityFaceCount[4] > 0) {
			var45 = (tmpPriorityDepthSum[3] + tmpPriorityDepthSum[4]) / (tmpPriorityFaceCount[3] + tmpPriorityFaceCount[4]);
		}

		int var46 = 0;
		if (tmpPriorityFaceCount[6] > 0 || tmpPriorityFaceCount[8] > 0) {
			var46 = (tmpPriorityDepthSum[6] + tmpPriorityDepthSum[8]) / (tmpPriorityFaceCount[6] + tmpPriorityFaceCount[8]);
		}

		int var47 = 0;
		int var48 = tmpPriorityFaceCount[10];
		int[] var49 = tmpPriorityFaces[10];
		int[] var50 = tmpPriority10FaceDepth;
		if (var47 == var48) {
			var47 = 0;
			var48 = tmpPriorityFaceCount[11];
			var49 = tmpPriorityFaces[11];
			var50 = tmpPriority11FaceDepth;
		}

		int var51;
		if (var47 < var48) {
			var51 = var50[var47];
		} else {
			var51 = -1000;
		}

		for (int var52 = 0; var52 < 10; var52++) {
			while (var52 == 0 && var51 > var44) {
				this.drawFace(var49[var47++]);
				if (var47 == var48 && tmpPriorityFaces[11] != var49) {
					var47 = 0;
					var48 = tmpPriorityFaceCount[11];
					var49 = tmpPriorityFaces[11];
					var50 = tmpPriority11FaceDepth;
				}
				if (var47 < var48) {
					var51 = var50[var47];
				} else {
					var51 = -1000;
				}
			}

			while (var52 == 3 && var51 > var45) {
				this.drawFace(var49[var47++]);
				if (var47 == var48 && tmpPriorityFaces[11] != var49) {
					var47 = 0;
					var48 = tmpPriorityFaceCount[11];
					var49 = tmpPriorityFaces[11];
					var50 = tmpPriority11FaceDepth;
				}
				if (var47 < var48) {
					var51 = var50[var47];
				} else {
					var51 = -1000;
				}
			}

			while (var52 == 5 && var51 > var46) {
				this.drawFace(var49[var47++]);
				if (var47 == var48 && tmpPriorityFaces[11] != var49) {
					var47 = 0;
					var48 = tmpPriorityFaceCount[11];
					var49 = tmpPriorityFaces[11];
					var50 = tmpPriority11FaceDepth;
				}
				if (var47 < var48) {
					var51 = var50[var47];
				} else {
					var51 = -1000;
				}
			}

			int var53 = tmpPriorityFaceCount[var52];
			int[] var54 = tmpPriorityFaces[var52];
			for (int var55 = 0; var55 < var53; var55++) {
				this.drawFace(var54[var55]);
			}
		}

		while (var51 != -1000) {
			this.drawFace(var49[var47++]);
			if (var47 == var48 && tmpPriorityFaces[11] != var49) {
				var47 = 0;
				var49 = tmpPriorityFaces[11];
				var48 = tmpPriorityFaceCount[11];
				var50 = tmpPriority11FaceDepth;
			}
			if (var47 < var48) {
				var51 = var50[var47];
			} else {
				var51 = -1000;
			}
		}
	}

	@ObfuscatedName("fo.an(I)V")
	public final void drawFace(int face) {
		if (faceNearClipped[face]) {
			this.drawNearClippedFace(face);
			return;
		}

		int a = this.faceVertexA[face];
		int b = this.faceVertexB[face];
		int c = this.faceVertexC[face];

		Pix3D.hclip = faceClippedX[face];

		if (this.faceAlpha == null) {
			Pix3D.trans = 0;
		} else {
			Pix3D.trans = this.faceAlpha[face] & 0xFF;
		}

		if (this.field2718 != null && this.field2718[face] != -1) {
			int var6;
			int var7;
			int var8;
			if (this.field2735 == null || this.field2735[face] == -1) {
				var6 = a;
				var7 = b;
				var8 = c;
			} else {
				int var5 = this.field2735[face] & 0xFF;
				var6 = this.field2739[var5];
				var7 = this.field2774[var5];
				var8 = this.field2765[var5];
			}
			if (this.faceColorC[face] == -1) {
				Pix3D.method2769(vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], vertexScreenX[a], vertexScreenX[b], vertexScreenX[c], this.faceColorA[face], this.faceColorA[face], this.faceColorA[face], vertexViewSpaceX[var6], vertexViewSpaceX[var7], vertexViewSpaceX[var8], vertexViewSpaceY[var6], vertexViewSpaceY[var7], vertexViewSpaceY[var8], vertexViewSpaceZ[var6], vertexViewSpaceZ[var7], vertexViewSpaceZ[var8], this.field2718[face]);
			} else {
				Pix3D.method2769(vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], vertexScreenX[a], vertexScreenX[b], vertexScreenX[c], this.faceColorA[face], this.faceColorB[face], this.faceColorC[face], vertexViewSpaceX[var6], vertexViewSpaceX[var7], vertexViewSpaceX[var8], vertexViewSpaceY[var6], vertexViewSpaceY[var7], vertexViewSpaceY[var8], vertexViewSpaceZ[var6], vertexViewSpaceZ[var7], vertexViewSpaceZ[var8], this.field2718[face]);
			}
		} else if (this.faceColorC[face] == -1) {
			Pix3D.method2767(vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], vertexScreenX[a], vertexScreenX[b], vertexScreenX[c], palette[this.faceColorA[face]]);
		} else {
			Pix3D.gouraudTriangle(vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], vertexScreenX[a], vertexScreenX[b], vertexScreenX[c], this.faceColorA[face], this.faceColorB[face], this.faceColorC[face]);
		}
	}

	@ObfuscatedName("fo.ah(I)V")
	public final void drawNearClippedFace(int arg0) {
		int var2 = Pix3D.centerX;
		int var3 = Pix3D.centerY;
		int elements = 0;
		int var5 = this.faceVertexA[arg0];
		int var6 = this.faceVertexB[arg0];
		int var7 = this.faceVertexC[arg0];
		int var8 = vertexViewSpaceZ[var5];
		int var9 = vertexViewSpaceZ[var6];
		int var10 = vertexViewSpaceZ[var7];
		if (this.faceAlpha == null) {
			Pix3D.trans = 0;
		} else {
			Pix3D.trans = this.faceAlpha[arg0] & 0xFF;
		}
		if (var8 >= 50) {
			clippedX[elements] = vertexScreenX[var5];
			clippedY[elements] = vertexScreenY[var5];
			clippedColor[elements++] = this.faceColorA[arg0];
		} else {
			int var11 = vertexViewSpaceX[var5];
			int var12 = vertexViewSpaceY[var5];
			int var13 = this.faceColorA[arg0];
			if (var10 >= 50) {
				int var14 = (50 - var8) * divTable2[var10 - var8];
				clippedX[elements] = (((vertexViewSpaceX[var7] - var11) * var14 >> 16) + var11 << 9) / 50 + var2;
				clippedY[elements] = (((vertexViewSpaceY[var7] - var12) * var14 >> 16) + var12 << 9) / 50 + var3;
				clippedColor[elements++] = ((this.faceColorC[arg0] - var13) * var14 >> 16) + var13;
			}
			if (var9 >= 50) {
				int var15 = (50 - var8) * divTable2[var9 - var8];
				clippedX[elements] = (((vertexViewSpaceX[var6] - var11) * var15 >> 16) + var11 << 9) / 50 + var2;
				clippedY[elements] = (((vertexViewSpaceY[var6] - var12) * var15 >> 16) + var12 << 9) / 50 + var3;
				clippedColor[elements++] = ((this.faceColorB[arg0] - var13) * var15 >> 16) + var13;
			}
		}
		if (var9 >= 50) {
			clippedX[elements] = vertexScreenX[var6];
			clippedY[elements] = vertexScreenY[var6];
			clippedColor[elements++] = this.faceColorB[arg0];
		} else {
			int var16 = vertexViewSpaceX[var6];
			int var17 = vertexViewSpaceY[var6];
			int var18 = this.faceColorB[arg0];
			if (var8 >= 50) {
				int var19 = (50 - var9) * divTable2[var8 - var9];
				clippedX[elements] = (((vertexViewSpaceX[var5] - var16) * var19 >> 16) + var16 << 9) / 50 + var2;
				clippedY[elements] = (((vertexViewSpaceY[var5] - var17) * var19 >> 16) + var17 << 9) / 50 + var3;
				clippedColor[elements++] = ((this.faceColorA[arg0] - var18) * var19 >> 16) + var18;
			}
			if (var10 >= 50) {
				int var20 = (50 - var9) * divTable2[var10 - var9];
				clippedX[elements] = (((vertexViewSpaceX[var7] - var16) * var20 >> 16) + var16 << 9) / 50 + var2;
				clippedY[elements] = (((vertexViewSpaceY[var7] - var17) * var20 >> 16) + var17 << 9) / 50 + var3;
				clippedColor[elements++] = ((this.faceColorC[arg0] - var18) * var20 >> 16) + var18;
			}
		}
		if (var10 >= 50) {
			clippedX[elements] = vertexScreenX[var7];
			clippedY[elements] = vertexScreenY[var7];
			clippedColor[elements++] = this.faceColorC[arg0];
		} else {
			int var21 = vertexViewSpaceX[var7];
			int var22 = vertexViewSpaceY[var7];
			int var23 = this.faceColorC[arg0];
			if (var9 >= 50) {
				int var24 = (50 - var10) * divTable2[var9 - var10];
				clippedX[elements] = (((vertexViewSpaceX[var6] - var21) * var24 >> 16) + var21 << 9) / 50 + var2;
				clippedY[elements] = (((vertexViewSpaceY[var6] - var22) * var24 >> 16) + var22 << 9) / 50 + var3;
				clippedColor[elements++] = ((this.faceColorB[arg0] - var23) * var24 >> 16) + var23;
			}
			if (var8 >= 50) {
				int var25 = (50 - var10) * divTable2[var8 - var10];
				clippedX[elements] = (((vertexViewSpaceX[var5] - var21) * var25 >> 16) + var21 << 9) / 50 + var2;
				clippedY[elements] = (((vertexViewSpaceY[var5] - var22) * var25 >> 16) + var22 << 9) / 50 + var3;
				clippedColor[elements++] = ((this.faceColorA[arg0] - var23) * var25 >> 16) + var23;
			}
		}
		int var26 = clippedX[0];
		int var27 = clippedX[1];
		int var28 = clippedX[2];
		int var29 = clippedY[0];
		int var30 = clippedY[1];
		int var31 = clippedY[2];
		Pix3D.hclip = false;
		if (elements == 3) {
			if (var26 < 0 || var27 < 0 || var28 < 0 || var26 > Pix3D.boundX || var27 > Pix3D.boundX || var28 > Pix3D.boundX) {
				Pix3D.hclip = true;
			}
			if (this.field2718 != null && this.field2718[arg0] != -1) {
				int var33;
				int var34;
				int var35;
				if (this.field2735 == null || this.field2735[arg0] == -1) {
					var33 = var5;
					var34 = var6;
					var35 = var7;
				} else {
					int var32 = this.field2735[arg0] & 0xFF;
					var33 = this.field2739[var32];
					var34 = this.field2774[var32];
					var35 = this.field2765[var32];
				}
				if (this.faceColorC[arg0] == -1) {
					Pix3D.method2769(var29, var30, var31, var26, var27, var28, this.faceColorA[arg0], this.faceColorA[arg0], this.faceColorA[arg0], vertexViewSpaceX[var33], vertexViewSpaceX[var34], vertexViewSpaceX[var35], vertexViewSpaceY[var33], vertexViewSpaceY[var34], vertexViewSpaceY[var35], vertexViewSpaceZ[var33], vertexViewSpaceZ[var34], vertexViewSpaceZ[var35], this.field2718[arg0]);
				} else {
					Pix3D.method2769(var29, var30, var31, var26, var27, var28, clippedColor[0], clippedColor[1], clippedColor[2], vertexViewSpaceX[var33], vertexViewSpaceX[var34], vertexViewSpaceX[var35], vertexViewSpaceY[var33], vertexViewSpaceY[var34], vertexViewSpaceY[var35], vertexViewSpaceZ[var33], vertexViewSpaceZ[var34], vertexViewSpaceZ[var35], this.field2718[arg0]);
				}
			} else if (this.faceColorC[arg0] == -1) {
				Pix3D.method2767(var29, var30, var31, var26, var27, var28, palette[this.faceColorA[arg0]]);
			} else {
				Pix3D.gouraudTriangle(var29, var30, var31, var26, var27, var28, clippedColor[0], clippedColor[1], clippedColor[2]);
			}
		} else if (elements == 4) {
            if (var26 < 0 || var27 < 0 || var28 < 0 || var26 > Pix3D.boundX || var27 > Pix3D.boundX || var28 > Pix3D.boundX || clippedX[3] < 0 || clippedX[3] > Pix3D.boundX) {
                Pix3D.hclip = true;
            }
            if (this.field2718 != null && this.field2718[arg0] != -1) {
                int var37;
                int var38;
                int var39;
                if (this.field2735 == null || this.field2735[arg0] == -1) {
                    var37 = var5;
                    var38 = var6;
                    var39 = var7;
                } else {
                    int var36 = this.field2735[arg0] & 0xFF;
                    var37 = this.field2739[var36];
                    var38 = this.field2774[var36];
                    var39 = this.field2765[var36];
                }
                short var40 = this.field2718[arg0];
                if (this.faceColorC[arg0] == -1) {
                    Pix3D.method2769(var29, var30, var31, var26, var27, var28, this.faceColorA[arg0], this.faceColorA[arg0], this.faceColorA[arg0], vertexViewSpaceX[var37], vertexViewSpaceX[var38], vertexViewSpaceX[var39], vertexViewSpaceY[var37], vertexViewSpaceY[var38], vertexViewSpaceY[var39], vertexViewSpaceZ[var37], vertexViewSpaceZ[var38], vertexViewSpaceZ[var39], var40);
                    Pix3D.method2769(var29, var31, clippedY[3], var26, var28, clippedX[3], this.faceColorA[arg0], this.faceColorA[arg0], this.faceColorA[arg0], vertexViewSpaceX[var37], vertexViewSpaceX[var38], vertexViewSpaceX[var39], vertexViewSpaceY[var37], vertexViewSpaceY[var38], vertexViewSpaceY[var39], vertexViewSpaceZ[var37], vertexViewSpaceZ[var38], vertexViewSpaceZ[var39], var40);
                } else {
                    Pix3D.method2769(var29, var30, var31, var26, var27, var28, clippedColor[0], clippedColor[1], clippedColor[2], vertexViewSpaceX[var37], vertexViewSpaceX[var38], vertexViewSpaceX[var39], vertexViewSpaceY[var37], vertexViewSpaceY[var38], vertexViewSpaceY[var39], vertexViewSpaceZ[var37], vertexViewSpaceZ[var38], vertexViewSpaceZ[var39], var40);
                    Pix3D.method2769(var29, var31, clippedY[3], var26, var28, clippedX[3], clippedColor[0], clippedColor[2], clippedColor[3], vertexViewSpaceX[var37], vertexViewSpaceX[var38], vertexViewSpaceX[var39], vertexViewSpaceY[var37], vertexViewSpaceY[var38], vertexViewSpaceY[var39], vertexViewSpaceZ[var37], vertexViewSpaceZ[var38], vertexViewSpaceZ[var39], var40);
                }
            } else if (this.faceColorC[arg0] == -1) {
                int var41 = palette[this.faceColorA[arg0]];
                Pix3D.method2767(var29, var30, var31, var26, var27, var28, var41);
                Pix3D.method2767(var29, var31, clippedY[3], var26, var28, clippedX[3], var41);
            } else {
                Pix3D.gouraudTriangle(var29, var30, var31, var26, var27, var28, clippedColor[0], clippedColor[1], clippedColor[2]);
                Pix3D.gouraudTriangle(var29, var31, clippedY[3], var26, var28, clippedX[3], clippedColor[0], clippedColor[2], clippedColor[3]);
            }
        }
    }

	@ObfuscatedName("fo.ay(IIIIIIII)Z")
	public final boolean pointWithinTriangle(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		if (arg1 < arg2 && arg1 < arg3 && arg1 < arg4) {
			return false;
		} else if (arg1 > arg2 && arg1 > arg3 && arg1 > arg4) {
			return false;
		} else if (arg0 < arg5 && arg0 < arg6 && arg0 < arg7) {
			return false;
		} else {
			return arg0 <= arg5 || arg0 <= arg6 || arg0 <= arg7;
		}
	}
}
