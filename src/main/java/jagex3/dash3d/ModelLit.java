package jagex3.dash3d;

import deob.ObfuscatedName;

@ObfuscatedName("fo")
public class ModelLit extends ModelSource {

	// jag::oldscape::dash3d::ModelLitImpl::m_tempModel
	@ObfuscatedName("fo.j")
	public static ModelLit tempModel = new ModelLit();

	// jag::oldscape::dash3d::ModelLitImpl::m_tempFTran
	@ObfuscatedName("fo.z")
	public static byte[] tempFTran = new byte[1];

	// jag::oldscape::dash3d::ModelLitImpl::m_tempModel2
	@ObfuscatedName("fo.g")
	public static ModelLit tempModel2 = new ModelLit();

	// jag::oldscape::dash3d::ModelLitImpl::m_tempFTran2
	@ObfuscatedName("fo.q")
	public static byte[] tempFTran2 = new byte[1];

	@ObfuscatedName("fo.i")
	public int vertexCount = 0;

	@ObfuscatedName("fo.s")
	public int[] vertexX;

	@ObfuscatedName("fo.u")
	public int[] vertexY;

	@ObfuscatedName("fo.v")
	public int[] vertexZ;

	@ObfuscatedName("fo.w")
	public int faceCount = 0;

	@ObfuscatedName("fo.e")
	public int[] faceVertexA;

	@ObfuscatedName("fo.b")
	public int[] faceVertexB;

	@ObfuscatedName("fo.y")
	public int[] faceVertexC;

	@ObfuscatedName("fo.t")
	public int[] faceColourA;

	@ObfuscatedName("fo.f")
	public int[] faceColourB;

	@ObfuscatedName("fo.k")
	public int[] faceColourC;

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
	public int faceTextureCount = 0;

	@ObfuscatedName("fo.ac")
	public int[] field2739;

	@ObfuscatedName("fo.aa")
	public int[] field2774;

	@ObfuscatedName("fo.as")
	public int[] field2765;

	@ObfuscatedName("fo.am")
	public int[][] labelVertices;

	@ObfuscatedName("fo.ap")
	public int[][] field2743;

	// jag::oldscape::dash3d::ModelLit::m_useAABBMouseCheck
	@ObfuscatedName("fo.av")
	public boolean useAABBMouseCheck = false;

	// jag::oldscape::dash3d::ModelLitImpl::ResetBoundingCalculations
	@ObfuscatedName("fo.ak")
	public int boundingCalc;

	@ObfuscatedName("fo.az")
	public int maxY;

	@ObfuscatedName("fo.an")
	public int radius;

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
	public static int[] clippedColour = new int[10];

	// jag::oldscape::dash3d::ModelLitImpl::m_oX
	@ObfuscatedName("fo.bl")
	public static int oX;

	// jag::oldscape::dash3d::ModelLitImpl::m_oY
	@ObfuscatedName("fo.bt")
	public static int oY;

	// jag::oldscape::dash3d::ModelLitImpl::m_oZ
	@ObfuscatedName("fo.bw")
	public static int oZ;

	// jag::oldscape::dash3d::MousePickingHelper::m_mouseCheck
	@ObfuscatedName("fo.by")
	public static boolean checkHover = false;

	// jag::oldscape::dash3d::MousePickingHelper::m_mouseX
	@ObfuscatedName("fo.bx")
	public static int mouseX = 0;

	// jag::oldscape::dash3d::MousePickingHelper::m_mouseY
	@ObfuscatedName("fo.bf")
	public static int mouseY = 0;

	// jag::oldscape::dash3d::MousePickingHelper::m_pickedEntityCount
	@ObfuscatedName("fo.bu")
	public static int pickedCount = 0;

	// jag::oldscape::dash3d::MousePickingHelper::m_pickedEntityTypecode
	@ObfuscatedName("fo.bo")
	public static int[] pickedEntityTypecode = new int[1000];

	@ObfuscatedName("fo.bq")
	public static int[] sinTable = Pix3D.sinTable;

	@ObfuscatedName("fo.bj")
	public static int[] cosTable = Pix3D.cosTable;

	@ObfuscatedName("fo.bz")
	public static int[] palette = Pix3D.colourTable;

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
		this.faceCount = 0;
		this.faceTextureCount = 0;
		this.field2737 = -1;
		for (int var7 = 0; var7 < count; var7++) {
			ModelLit var8 = models[var7];
			if (var8 != null) {
				this.vertexCount += var8.vertexCount;
				this.faceCount += var8.faceCount;
				this.faceTextureCount += var8.faceTextureCount;
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
		this.faceVertexA = new int[this.faceCount];
		this.faceVertexB = new int[this.faceCount];
		this.faceVertexC = new int[this.faceCount];
		this.faceColourA = new int[this.faceCount];
		this.faceColourB = new int[this.faceCount];
		this.faceColourC = new int[this.faceCount];
		if (var3) {
			this.facePriority = new byte[this.faceCount];
		}
		if (var4) {
			this.faceAlpha = new byte[this.faceCount];
		}
		if (var5) {
			this.field2718 = new short[this.faceCount];
		}
		if (var6) {
			this.field2735 = new byte[this.faceCount];
		}
		if (this.faceTextureCount > 0) {
			this.field2739 = new int[this.faceTextureCount];
			this.field2774 = new int[this.faceTextureCount];
			this.field2765 = new int[this.faceTextureCount];
		}
		this.vertexCount = 0;
		this.faceCount = 0;
		this.faceTextureCount = 0;
		for (int var9 = 0; var9 < count; var9++) {
			ModelLit var10 = models[var9];
			if (var10 != null) {
				for (int var11 = 0; var11 < var10.faceCount; var11++) {
					this.faceVertexA[this.faceCount] = var10.faceVertexA[var11] + this.vertexCount;
					this.faceVertexB[this.faceCount] = var10.faceVertexB[var11] + this.vertexCount;
					this.faceVertexC[this.faceCount] = var10.faceVertexC[var11] + this.vertexCount;
					this.faceColourA[this.faceCount] = var10.faceColourA[var11];
					this.faceColourB[this.faceCount] = var10.faceColourB[var11];
					this.faceColourC[this.faceCount] = var10.faceColourC[var11];
					if (var3) {
						if (var10.facePriority == null) {
							this.facePriority[this.faceCount] = var10.field2737;
						} else {
							this.facePriority[this.faceCount] = var10.facePriority[var11];
						}
					}
					if (var4 && var10.faceAlpha != null) {
						this.faceAlpha[this.faceCount] = var10.faceAlpha[var11];
					}
					if (var5) {
						if (var10.field2718 == null) {
							this.field2718[this.faceCount] = -1;
						} else {
							this.field2718[this.faceCount] = var10.field2718[var11];
						}
					}
					if (var6) {
						if (var10.field2735 == null || var10.field2735[var11] == -1) {
							this.field2735[this.faceCount] = -1;
						} else {
							this.field2735[this.faceCount] = (byte) (var10.field2735[var11] + this.faceTextureCount);
						}
					}
					this.faceCount++;
				}
				for (int var12 = 0; var12 < var10.faceTextureCount; var12++) {
					this.field2739[this.faceTextureCount] = var10.field2739[var12] + this.vertexCount;
					this.field2774[this.faceTextureCount] = var10.field2774[var12] + this.vertexCount;
					this.field2765[this.faceTextureCount] = var10.field2765[var12] + this.vertexCount;
					this.faceTextureCount++;
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

	// jag::oldscape::dash3d::ModelLitImpl::HillSkew
	@ObfuscatedName("fo.b([[IIIIZI)Lfo;")
	public ModelLit hillSkew(int[][] arg0, int arg1, int arg2, int arg3, boolean arg4, int arg5) {
		this.calcBoundingCylinder();
		int var7 = arg1 - this.radius;
		int var8 = this.radius + arg1;
		int var9 = arg3 - this.radius;
		int var10 = this.radius + arg3;
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
			var15.faceCount = this.faceCount;
			var15.faceTextureCount = this.faceTextureCount;
			var15.vertexX = this.vertexX;
			var15.vertexZ = this.vertexZ;
			var15.faceVertexA = this.faceVertexA;
			var15.faceVertexB = this.faceVertexB;
			var15.faceVertexC = this.faceVertexC;
			var15.faceColourA = this.faceColourA;
			var15.faceColourB = this.faceColourB;
			var15.faceColourC = this.faceColourC;
			var15.facePriority = this.facePriority;
			var15.faceAlpha = this.faceAlpha;
			var15.field2735 = this.field2735;
			var15.field2718 = this.field2718;
			var15.field2737 = this.field2737;
			var15.field2739 = this.field2739;
			var15.field2774 = this.field2774;
			var15.field2765 = this.field2765;
			var15.labelVertices = this.labelVertices;
			var15.field2743 = this.field2743;
			var15.useAABBMouseCheck = this.useAABBMouseCheck;
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
		var15.boundingCalc = 0;
		return var15;
	}

	// jag::oldscape::dash3d::ModelLitImpl::CopyForAnim
	@ObfuscatedName("fo.y(Z)Lfo;")
	public ModelLit copyForAnim(boolean copyAlpha) {
		if (!copyAlpha && tempFTran.length < this.faceCount) {
			tempFTran = new byte[this.faceCount + 100];
		}
		return this.copyForAnim(copyAlpha, tempModel, tempFTran);
	}

	// jag::oldscape::dash3d::ModelLitImpl::CopyForAnim
	@ObfuscatedName("fo.t(Z)Lfo;")
	public ModelLit copyForAnim2(boolean copyAlpha) {
		if (!copyAlpha && tempFTran2.length < this.faceCount) {
			tempFTran2 = new byte[this.faceCount + 100];
		}
		return this.copyForAnim(copyAlpha, tempModel2, tempFTran2);
	}

	// jag::oldscape::dash3d::ModelLitImpl::CopyForAnim
	@ObfuscatedName("fo.f(ZLfo;[B)Lfo;")
	public ModelLit copyForAnim(boolean copyAlpha, ModelLit model, byte[] alpha) {
		model.vertexCount = this.vertexCount;
		model.faceCount = this.faceCount;
		model.faceTextureCount = this.faceTextureCount;

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
			model.faceAlpha = alpha;

			if (this.faceAlpha == null) {
				for (int f = 0; f < this.faceCount; f++) {
					model.faceAlpha[f] = 0;
				}
			} else {
				for (int f = 0; f < this.faceCount; f++) {
					model.faceAlpha[f] = this.faceAlpha[f];
				}
			}
		}

		model.faceVertexA = this.faceVertexA;
		model.faceVertexB = this.faceVertexB;
		model.faceVertexC = this.faceVertexC;
		model.faceColourA = this.faceColourA;
		model.faceColourB = this.faceColourB;
		model.faceColourC = this.faceColourC;
		model.facePriority = this.facePriority;
		model.field2735 = this.field2735;
		model.field2718 = this.field2718;
		model.field2737 = this.field2737;
		model.field2739 = this.field2739;
		model.field2774 = this.field2774;
		model.field2765 = this.field2765;
		model.labelVertices = this.labelVertices;
		model.field2743 = this.field2743;
		model.useAABBMouseCheck = this.useAABBMouseCheck;
		model.boundingCalc = 0;
		return model;
	}

	// jag::oldscape::dash3d::ModelLitImpl::CalcBoundingCylinder
	@ObfuscatedName("fo.k()V")
	public void calcBoundingCylinder() {
		if (this.boundingCalc == 1) {
			return;
		}
		this.boundingCalc = 1;
		this.minY = 0;
		this.maxY = 0;
		this.radius = 0;
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			int var2 = this.vertexX[var1];
			int var3 = this.vertexY[var1];
			int var4 = this.vertexZ[var1];
			if (-var3 > this.minY) {
				this.minY = -var3;
			}
			if (var3 > this.maxY) {
				this.maxY = var3;
			}
			int var5 = var2 * var2 + var4 * var4;
			if (var5 > this.radius) {
				this.radius = var5;
			}
		}
		this.radius = (int) (Math.sqrt((double) this.radius) + 0.99D);
		this.minDepth = (int) (Math.sqrt((double) (this.minY * this.minY + this.radius * this.radius)) + 0.99D);
		this.maxDepth = this.minDepth + (int) (Math.sqrt((double) (this.radius * this.radius + this.maxY * this.maxY)) + 0.99D);
	}

	// jag::oldscape::dash3d::ModelLitImpl::CalcAABB
	@ObfuscatedName("fo.o()V")
	public void calcAABB() {
		if (this.boundingCalc == 2) {
			return;
		}
		this.boundingCalc = 2;
		this.radius = 0;
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			int var2 = this.vertexX[var1];
			int var3 = this.vertexY[var1];
			int var4 = this.vertexZ[var1];
			int var5 = var3 * var3 + var2 * var2 + var4 * var4;
			if (var5 > this.radius) {
				this.radius = var5;
			}
		}
		this.radius = (int) (Math.sqrt((double) this.radius) + 0.99D);
		this.minDepth = this.radius;
		this.maxDepth = this.radius + this.radius;
	}

	// jag::oldscape::dash3d::ModelLitImpl::GetRadiusCylinder
	@ObfuscatedName("fo.a()I")
	public int getRadiusCylinder() {
		this.calcBoundingCylinder();
		return this.radius;
	}

	// jag::oldscape::dash3d::ModelLitImpl::Animate
	@ObfuscatedName("fo.h(Lfr;I)V")
	public void animate(AnimFrameSet arg0, int arg1) {
		if (this.labelVertices == null || arg1 == -1) {
			return;
		}
		AnimFrame var3 = arg0.list[arg1];
		AnimBase var4 = var3.base;
		oX = 0;
		oY = 0;
		oZ = 0;
		for (int var5 = 0; var5 < var3.size; var5++) {
			int var6 = var3.ti[var5];
			this.animate2(var4.type[var6], var4.labels[var6], var3.tx[var5], var3.ty[var5], var3.tz[var5]);
		}
		this.boundingCalc = 0;
	}

	// jag::oldscape::dash3d::ModelLitImpl::MaskAnimate
	@ObfuscatedName("fo.x(Lfr;ILfr;I[I)V")
	public void maskAnimate(AnimFrameSet arg0, int arg1, AnimFrameSet arg2, int arg3, int[] arg4) {
		if (arg1 == -1) {
			return;
		}
		if (arg4 == null || arg3 == -1) {
			this.animate(arg0, arg1);
			return;
		}
		AnimFrame var6 = arg0.list[arg1];
		AnimFrame var7 = arg2.list[arg3];
		AnimBase var8 = var6.base;
		oX = 0;
		oY = 0;
		oZ = 0;
		byte var9 = 0;
		int var17 = var9 + 1;
		int var10 = arg4[var9];
		for (int var11 = 0; var11 < var6.size; var11++) {
			int var12 = var6.ti[var11];
			while (var12 > var10) {
				var10 = arg4[var17++];
			}
			if (var10 != var12 || var8.type[var12] == 0) {
				this.animate2(var8.type[var12], var8.labels[var12], var6.tx[var11], var6.ty[var11], var6.tz[var11]);
			}
		}
		oX = 0;
		oY = 0;
		oZ = 0;
		byte var13 = 0;
		int var18 = var13 + 1;
		int var14 = arg4[var13];
		for (int var15 = 0; var15 < var7.size; var15++) {
			int var16 = var7.ti[var15];
			while (var16 > var14) {
				var14 = arg4[var18++];
			}
			if (var14 == var16 || var8.type[var16] == 0) {
				this.animate2(var8.type[var16], var8.labels[var16], var7.tx[var15], var7.ty[var15], var7.tz[var15]);
			}
		}
		this.boundingCalc = 0;
	}

	// jag::oldscape::dash3d::ModelLitImpl::Animate2
	@ObfuscatedName("fo.p(I[IIII)V")
	public void animate2(int arg0, int[] arg1, int arg2, int arg3, int arg4) {
		int var6 = arg1.length;
		if (arg0 == 0) {
			int var7 = 0;
			oX = 0;
			oY = 0;
			oZ = 0;
			for (int var8 = 0; var8 < var6; var8++) {
				int var9 = arg1[var8];
				if (var9 < this.labelVertices.length) {
					int[] var10 = this.labelVertices[var9];
					for (int var11 = 0; var11 < var10.length; var11++) {
						int var12 = var10[var11];
						oX += this.vertexX[var12];
						oY += this.vertexY[var12];
						oZ += this.vertexZ[var12];
						var7++;
					}
				}
			}
			if (var7 > 0) {
				oX = oX / var7 + arg2;
				oY = oY / var7 + arg3;
				oZ = oZ / var7 + arg4;
			} else {
				oX = arg2;
				oY = arg3;
				oZ = arg4;
			}
		} else if (arg0 == 1) {
			for (int var13 = 0; var13 < var6; var13++) {
				int var14 = arg1[var13];
				if (var14 < this.labelVertices.length) {
					int[] var15 = this.labelVertices[var14];
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
				if (var19 < this.labelVertices.length) {
					int[] var20 = this.labelVertices[var19];
					for (int var21 = 0; var21 < var20.length; var21++) {
						int var22 = var20[var21];
						this.vertexX[var22] -= oX;
						this.vertexY[var22] -= oY;
						this.vertexZ[var22] -= oZ;
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
						this.vertexX[var22] += oX;
						this.vertexY[var22] += oY;
						this.vertexZ[var22] += oZ;
					}
				}
			}
		} else if (arg0 == 3) {
			for (int var35 = 0; var35 < var6; var35++) {
				int var36 = arg1[var35];
				if (var36 < this.labelVertices.length) {
					int[] var37 = this.labelVertices[var36];
					for (int var38 = 0; var38 < var37.length; var38++) {
						int var39 = var37[var38];
						this.vertexX[var39] -= oX;
						this.vertexY[var39] -= oY;
						this.vertexZ[var39] -= oZ;
						this.vertexX[var39] = this.vertexX[var39] * arg2 / 128;
						this.vertexY[var39] = this.vertexY[var39] * arg3 / 128;
						this.vertexZ[var39] = this.vertexZ[var39] * arg4 / 128;
						this.vertexX[var39] += oX;
						this.vertexY[var39] += oY;
						this.vertexZ[var39] += oZ;
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

	// jag::oldscape::dash3d::ModelLitImpl::Rotate90
	@ObfuscatedName("fo.ad()V")
	public void rotate90() {
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			int var2 = this.vertexX[var1];
			this.vertexX[var1] = this.vertexZ[var1];
			this.vertexZ[var1] = -var2;
		}
		this.boundingCalc = 0;
	}

	// jag::oldscape::dash3d::ModelLitImpl::Rotate180
	@ObfuscatedName("fo.ac()V")
	public void rotate180() {
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			this.vertexX[var1] = -this.vertexX[var1];
			this.vertexZ[var1] = -this.vertexZ[var1];
		}
		this.boundingCalc = 0;
	}

	// jag::oldscape::dash3d::ModelLitImpl::Rotate270
	@ObfuscatedName("fo.aa()V")
	public void rotate270() {
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			int var2 = this.vertexZ[var1];
			this.vertexZ[var1] = this.vertexX[var1];
			this.vertexX[var1] = -var2;
		}
		this.boundingCalc = 0;
	}

	// jag::oldscape::dash3d::ModelLitImpl::RotateXAxis
	@ObfuscatedName("fo.as(I)V")
	public void rotateXAxis(int arg0) {
		int var2 = sinTable[arg0];
		int var3 = cosTable[arg0];
		for (int var4 = 0; var4 < this.vertexCount; var4++) {
			int var5 = this.vertexY[var4] * var3 - this.vertexZ[var4] * var2 >> 16;
			this.vertexZ[var4] = this.vertexZ[var4] * var3 + this.vertexY[var4] * var2 >> 16;
			this.vertexY[var4] = var5;
		}
		this.boundingCalc = 0;
	}

	// jag::oldscape::dash3d::ModelLitImpl::Translate
	@ObfuscatedName("fo.am(III)V")
	public void translate(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < this.vertexCount; var4++) {
			this.vertexX[var4] += arg0;
			this.vertexY[var4] += arg1;
			this.vertexZ[var4] += arg2;
		}
		this.boundingCalc = 0;
	}

	// jag::oldscape::dash3d::ModelLitImpl::Resize
	@ObfuscatedName("fo.ap(III)V")
	public void resize(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < this.vertexCount; var4++) {
			this.vertexX[var4] = this.vertexX[var4] * arg0 / 128;
			this.vertexY[var4] = this.vertexY[var4] * arg1 / 128;
			this.vertexZ[var4] = this.vertexZ[var4] * arg2 / 128;
		}
		this.boundingCalc = 0;
	}

	// jag::oldscape::dash3d::SoftwareModelLitRenderer::ObjRender
	@ObfuscatedName("fo.av(IIIIIII)V")
	public final void objRender(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		tmpDepthFaceCount[0] = -1;

		if (this.boundingCalc != 2 && this.boundingCalc != 1) {
			this.calcAABB();
		}

		int var8 = Pix3D.originX;
		int var9 = Pix3D.originY;
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
			if (this.faceTextureCount > 0) {
				vertexViewSpaceX[var19] = var26;
				vertexViewSpaceY[var19] = var29;
				vertexViewSpaceZ[var19] = var30;
			}
		}
		try {
			this.render2(false, false, 0);
		} catch (Exception var33) {
		}
	}

	// jag::oldscape::dash3d::SoftwareModelLitRenderer::ObjRenderOrthog
	@ObfuscatedName("fo.ak(IIIIIIII)V")
	public final void objRenderOrthog(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		tmpDepthFaceCount[0] = -1;
		if (this.boundingCalc != 2 && this.boundingCalc != 1) {
			this.calcAABB();
		}
		int var9 = Pix3D.originX;
		int var10 = Pix3D.originY;
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
			if (this.faceTextureCount > 0) {
				vertexViewSpaceX[var20] = var27;
				vertexViewSpaceY[var20] = var30;
				vertexViewSpaceZ[var20] = var31;
			}
		}
		try {
			this.render2(false, false, 0);
		} catch (Exception var34) {
		}
	}

	// jag::oldscape::dash3d::SoftwareModelLitRenderer::WorldRender
	@ObfuscatedName("fo.z(IIIIIIIII)V")
	public void worldRender(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int typecode) {
		tmpDepthFaceCount[0] = -1;

		if (this.boundingCalc != 1) {
			this.calcBoundingCylinder();
		}

		int var10 = arg4 * arg7 - arg3 * arg5 >> 16;
		int var11 = arg1 * arg6 + arg2 * var10 >> 16;
		int var12 = this.radius * arg2 >> 16;

		int var13 = var11 + var12;
		if (var13 <= 50 || var11 >= 3500) {
			return;
		}

		int var14 = arg3 * arg7 + arg4 * arg5 >> 16;
		int var15 = var14 - this.radius << 9;
		if (var15 / var13 >= Pix3D.maxX) {
			return;
		}

		int var16 = this.radius + var14 << 9;
		if (var16 / var13 <= Pix3D.minX) {
			return;
		}

		int var17 = arg2 * arg6 - arg1 * var10 >> 16;
		int var18 = this.radius * arg1 >> 16;

		int var19 = var17 + var18 << 9;
		if (var19 / var13 <= Pix3D.minY) {
			return;
		}

		int var20 = (this.minY * arg2 >> 16) + var18;
		int var21 = var17 - var20 << 9;
		if (var21 / var13 >= Pix3D.maxY) {
			return;
		}

		int var22 = (this.minY * arg1 >> 16) + var12;

		boolean clipped2 = false;
		boolean clipped = false;
		if (var11 - var22 <= 50) {
			clipped = true;
		}

		boolean textured = clipped || this.faceTextureCount > 0;
		boolean picking = false;

		if (typecode > 0 && checkHover) {
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
			int var32 = mouseX - Pix3D.originX;
			int var33 = mouseY - Pix3D.originY;
			if (var32 > var28 && var32 < var29 && var33 > var30 && var33 < var31) {
				if (this.useAABBMouseCheck) {
					pickedEntityTypecode[pickedCount++] = typecode;
				} else {
					picking = true;
				}
			}
		}

		int var34 = Pix3D.originX;
		int var35 = Pix3D.originY;

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
				clipped2 = true;
			}

			if (textured) {
				vertexViewSpaceX[var38] = var46;
				vertexViewSpaceY[var38] = var49;
				vertexViewSpaceZ[var38] = var50;
			}
		}

		try {
			this.render2(clipped2, picking, typecode);
		} catch (Exception var53) {
		}
	}

	// jag::oldscape::dash3d::SoftwareModelLitRenderer::Render2
	@ObfuscatedName("fo.az(ZZI)V")
	public final void render2(boolean clipped, boolean picking, int typecode) {
		if (this.maxDepth >= 1600) {
			return;
		}

		for (int i = 0; i < this.maxDepth; i++) {
			tmpDepthFaceCount[i] = 0;
		}

		for (int f = 0; f < this.faceCount; f++) {
			if (this.faceColourC[f] != -2) {
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
					if (picking && this.isMouseRoughlyInsideTriangle(mouseX, mouseY, vertexScreenY[var6], vertexScreenY[var7], vertexScreenY[var8], var9, var10, var11)) {
						pickedEntityTypecode[pickedCount++] = typecode;
						picking = false;
					}

					if ((vertexScreenY[var8] - vertexScreenY[var7]) * (var9 - var10) - (vertexScreenY[var6] - vertexScreenY[var7]) * (var11 - var10) > 0) {
						faceNearClipped[f] = false;

						if (var9 >= 0 && var10 >= 0 && var11 >= 0 && var9 <= Pix3D.sizeX && var10 <= Pix3D.sizeX && var11 <= Pix3D.sizeX) {
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
						this.render3(faces[f]);
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
				this.render3(var49[var47++]);
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
				this.render3(var49[var47++]);
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
				this.render3(var49[var47++]);
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
				this.render3(var54[var55]);
			}
		}

		while (var51 != -1000) {
			this.render3(var49[var47++]);
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

	// jag::oldscape::dash3d::SoftwareModelLitRenderer::Render3
	@ObfuscatedName("fo.an(I)V")
	public final void render3(int face) {
		if (faceNearClipped[face]) {
			this.render3ZClip(face);
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
			if (this.faceColourC[face] == -1) {
				Pix3D.textureTriangleAffine(vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], vertexScreenX[a], vertexScreenX[b], vertexScreenX[c], this.faceColourA[face], this.faceColourA[face], this.faceColourA[face], vertexViewSpaceX[var6], vertexViewSpaceX[var7], vertexViewSpaceX[var8], vertexViewSpaceY[var6], vertexViewSpaceY[var7], vertexViewSpaceY[var8], vertexViewSpaceZ[var6], vertexViewSpaceZ[var7], vertexViewSpaceZ[var8], this.field2718[face]);
			} else {
				Pix3D.textureTriangleAffine(vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], vertexScreenX[a], vertexScreenX[b], vertexScreenX[c], this.faceColourA[face], this.faceColourB[face], this.faceColourC[face], vertexViewSpaceX[var6], vertexViewSpaceX[var7], vertexViewSpaceX[var8], vertexViewSpaceY[var6], vertexViewSpaceY[var7], vertexViewSpaceY[var8], vertexViewSpaceZ[var6], vertexViewSpaceZ[var7], vertexViewSpaceZ[var8], this.field2718[face]);
			}
		} else if (this.faceColourC[face] == -1) {
			Pix3D.flatTriangle(vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], vertexScreenX[a], vertexScreenX[b], vertexScreenX[c], palette[this.faceColourA[face]]);
		} else {
			Pix3D.gouraudTriangle(vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], vertexScreenX[a], vertexScreenX[b], vertexScreenX[c], this.faceColourA[face], this.faceColourB[face], this.faceColourC[face]);
		}
	}

	// jag::oldscape::dash3d::SoftwareModelLitRenderer::Render3ZClip
	@ObfuscatedName("fo.ah(I)V")
	public final void render3ZClip(int arg0) {
		int var2 = Pix3D.originX;
		int var3 = Pix3D.originY;
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
			clippedColour[elements++] = this.faceColourA[arg0];
		} else {
			int var11 = vertexViewSpaceX[var5];
			int var12 = vertexViewSpaceY[var5];
			int var13 = this.faceColourA[arg0];
			if (var10 >= 50) {
				int var14 = (50 - var8) * divTable2[var10 - var8];
				clippedX[elements] = (((vertexViewSpaceX[var7] - var11) * var14 >> 16) + var11 << 9) / 50 + var2;
				clippedY[elements] = (((vertexViewSpaceY[var7] - var12) * var14 >> 16) + var12 << 9) / 50 + var3;
				clippedColour[elements++] = ((this.faceColourC[arg0] - var13) * var14 >> 16) + var13;
			}
			if (var9 >= 50) {
				int var15 = (50 - var8) * divTable2[var9 - var8];
				clippedX[elements] = (((vertexViewSpaceX[var6] - var11) * var15 >> 16) + var11 << 9) / 50 + var2;
				clippedY[elements] = (((vertexViewSpaceY[var6] - var12) * var15 >> 16) + var12 << 9) / 50 + var3;
				clippedColour[elements++] = ((this.faceColourB[arg0] - var13) * var15 >> 16) + var13;
			}
		}
		if (var9 >= 50) {
			clippedX[elements] = vertexScreenX[var6];
			clippedY[elements] = vertexScreenY[var6];
			clippedColour[elements++] = this.faceColourB[arg0];
		} else {
			int var16 = vertexViewSpaceX[var6];
			int var17 = vertexViewSpaceY[var6];
			int var18 = this.faceColourB[arg0];
			if (var8 >= 50) {
				int var19 = (50 - var9) * divTable2[var8 - var9];
				clippedX[elements] = (((vertexViewSpaceX[var5] - var16) * var19 >> 16) + var16 << 9) / 50 + var2;
				clippedY[elements] = (((vertexViewSpaceY[var5] - var17) * var19 >> 16) + var17 << 9) / 50 + var3;
				clippedColour[elements++] = ((this.faceColourA[arg0] - var18) * var19 >> 16) + var18;
			}
			if (var10 >= 50) {
				int var20 = (50 - var9) * divTable2[var10 - var9];
				clippedX[elements] = (((vertexViewSpaceX[var7] - var16) * var20 >> 16) + var16 << 9) / 50 + var2;
				clippedY[elements] = (((vertexViewSpaceY[var7] - var17) * var20 >> 16) + var17 << 9) / 50 + var3;
				clippedColour[elements++] = ((this.faceColourC[arg0] - var18) * var20 >> 16) + var18;
			}
		}
		if (var10 >= 50) {
			clippedX[elements] = vertexScreenX[var7];
			clippedY[elements] = vertexScreenY[var7];
			clippedColour[elements++] = this.faceColourC[arg0];
		} else {
			int var21 = vertexViewSpaceX[var7];
			int var22 = vertexViewSpaceY[var7];
			int var23 = this.faceColourC[arg0];
			if (var9 >= 50) {
				int var24 = (50 - var10) * divTable2[var9 - var10];
				clippedX[elements] = (((vertexViewSpaceX[var6] - var21) * var24 >> 16) + var21 << 9) / 50 + var2;
				clippedY[elements] = (((vertexViewSpaceY[var6] - var22) * var24 >> 16) + var22 << 9) / 50 + var3;
				clippedColour[elements++] = ((this.faceColourB[arg0] - var23) * var24 >> 16) + var23;
			}
			if (var8 >= 50) {
				int var25 = (50 - var10) * divTable2[var8 - var10];
				clippedX[elements] = (((vertexViewSpaceX[var5] - var21) * var25 >> 16) + var21 << 9) / 50 + var2;
				clippedY[elements] = (((vertexViewSpaceY[var5] - var22) * var25 >> 16) + var22 << 9) / 50 + var3;
				clippedColour[elements++] = ((this.faceColourA[arg0] - var23) * var25 >> 16) + var23;
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
			if (var26 < 0 || var27 < 0 || var28 < 0 || var26 > Pix3D.sizeX || var27 > Pix3D.sizeX || var28 > Pix3D.sizeX) {
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
				if (this.faceColourC[arg0] == -1) {
					Pix3D.textureTriangleAffine(var29, var30, var31, var26, var27, var28, this.faceColourA[arg0], this.faceColourA[arg0], this.faceColourA[arg0], vertexViewSpaceX[var33], vertexViewSpaceX[var34], vertexViewSpaceX[var35], vertexViewSpaceY[var33], vertexViewSpaceY[var34], vertexViewSpaceY[var35], vertexViewSpaceZ[var33], vertexViewSpaceZ[var34], vertexViewSpaceZ[var35], this.field2718[arg0]);
				} else {
					Pix3D.textureTriangleAffine(var29, var30, var31, var26, var27, var28, clippedColour[0], clippedColour[1], clippedColour[2], vertexViewSpaceX[var33], vertexViewSpaceX[var34], vertexViewSpaceX[var35], vertexViewSpaceY[var33], vertexViewSpaceY[var34], vertexViewSpaceY[var35], vertexViewSpaceZ[var33], vertexViewSpaceZ[var34], vertexViewSpaceZ[var35], this.field2718[arg0]);
				}
			} else if (this.faceColourC[arg0] == -1) {
				Pix3D.flatTriangle(var29, var30, var31, var26, var27, var28, palette[this.faceColourA[arg0]]);
			} else {
				Pix3D.gouraudTriangle(var29, var30, var31, var26, var27, var28, clippedColour[0], clippedColour[1], clippedColour[2]);
			}
		} else if (elements == 4) {
			if (var26 < 0 || var27 < 0 || var28 < 0 || var26 > Pix3D.sizeX || var27 > Pix3D.sizeX || var28 > Pix3D.sizeX || clippedX[3] < 0 || clippedX[3] > Pix3D.sizeX) {
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
				if (this.faceColourC[arg0] == -1) {
					Pix3D.textureTriangleAffine(var29, var30, var31, var26, var27, var28, this.faceColourA[arg0], this.faceColourA[arg0], this.faceColourA[arg0], vertexViewSpaceX[var37], vertexViewSpaceX[var38], vertexViewSpaceX[var39], vertexViewSpaceY[var37], vertexViewSpaceY[var38], vertexViewSpaceY[var39], vertexViewSpaceZ[var37], vertexViewSpaceZ[var38], vertexViewSpaceZ[var39], var40);
					Pix3D.textureTriangleAffine(var29, var31, clippedY[3], var26, var28, clippedX[3], this.faceColourA[arg0], this.faceColourA[arg0], this.faceColourA[arg0], vertexViewSpaceX[var37], vertexViewSpaceX[var38], vertexViewSpaceX[var39], vertexViewSpaceY[var37], vertexViewSpaceY[var38], vertexViewSpaceY[var39], vertexViewSpaceZ[var37], vertexViewSpaceZ[var38], vertexViewSpaceZ[var39], var40);
				} else {
					Pix3D.textureTriangleAffine(var29, var30, var31, var26, var27, var28, clippedColour[0], clippedColour[1], clippedColour[2], vertexViewSpaceX[var37], vertexViewSpaceX[var38], vertexViewSpaceX[var39], vertexViewSpaceY[var37], vertexViewSpaceY[var38], vertexViewSpaceY[var39], vertexViewSpaceZ[var37], vertexViewSpaceZ[var38], vertexViewSpaceZ[var39], var40);
					Pix3D.textureTriangleAffine(var29, var31, clippedY[3], var26, var28, clippedX[3], clippedColour[0], clippedColour[2], clippedColour[3], vertexViewSpaceX[var37], vertexViewSpaceX[var38], vertexViewSpaceX[var39], vertexViewSpaceY[var37], vertexViewSpaceY[var38], vertexViewSpaceY[var39], vertexViewSpaceZ[var37], vertexViewSpaceZ[var38], vertexViewSpaceZ[var39], var40);
				}
			} else if (this.faceColourC[arg0] == -1) {
				int var41 = palette[this.faceColourA[arg0]];
				Pix3D.flatTriangle(var29, var30, var31, var26, var27, var28, var41);
				Pix3D.flatTriangle(var29, var31, clippedY[3], var26, var28, clippedX[3], var41);
			} else {
				Pix3D.gouraudTriangle(var29, var30, var31, var26, var27, var28, clippedColour[0], clippedColour[1], clippedColour[2]);
				Pix3D.gouraudTriangle(var29, var31, clippedY[3], var26, var28, clippedX[3], clippedColour[0], clippedColour[2], clippedColour[3]);
			}
		}
	}

	// jag::oldscape::dash3d::MousePickingHelper::IsMouseRoughlyInsideTriangle
	@ObfuscatedName("fo.ay(IIIIIIII)Z")
	public final boolean isMouseRoughlyInsideTriangle(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
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
