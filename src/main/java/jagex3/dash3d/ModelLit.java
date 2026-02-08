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
	public byte[] faceTextureAxis;

	@ObfuscatedName("fo.x")
	public short[] faceTextureId;

	@ObfuscatedName("fo.p")
	public byte priority = 0;

	@ObfuscatedName("fo.ad")
	public int faceTextureCount = 0;

	@ObfuscatedName("fo.ac")
	public int[] faceTextureP;

	@ObfuscatedName("fo.aa")
	public int[] faceTextureM;

	@ObfuscatedName("fo.as")
	public int[] faceTextureN;

	@ObfuscatedName("fo.am")
	public int[][] labelVertices;

	@ObfuscatedName("fo.ap")
	public int[][] labelFaces;

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
	public static boolean mouseCheck = false;

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
	public static int[] colourTable = Pix3D.colourTable;

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
		this.priority = -1;
		for (int var7 = 0; var7 < count; var7++) {
			ModelLit var8 = models[var7];
			if (var8 != null) {
				this.vertexCount += var8.vertexCount;
				this.faceCount += var8.faceCount;
				this.faceTextureCount += var8.faceTextureCount;
				if (var8.facePriority == null) {
					if (this.priority == -1) {
						this.priority = var8.priority;
					}
					if (this.priority != var8.priority) {
						var3 = true;
					}
				} else {
					var3 = true;
				}
				var4 |= var8.faceAlpha != null;
				var5 |= var8.faceTextureId != null;
				var6 |= var8.faceTextureAxis != null;
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
			this.faceTextureId = new short[this.faceCount];
		}
		if (var6) {
			this.faceTextureAxis = new byte[this.faceCount];
		}
		if (this.faceTextureCount > 0) {
			this.faceTextureP = new int[this.faceTextureCount];
			this.faceTextureM = new int[this.faceTextureCount];
			this.faceTextureN = new int[this.faceTextureCount];
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
							this.facePriority[this.faceCount] = var10.priority;
						} else {
							this.facePriority[this.faceCount] = var10.facePriority[var11];
						}
					}
					if (var4 && var10.faceAlpha != null) {
						this.faceAlpha[this.faceCount] = var10.faceAlpha[var11];
					}
					if (var5) {
						if (var10.faceTextureId == null) {
							this.faceTextureId[this.faceCount] = -1;
						} else {
							this.faceTextureId[this.faceCount] = var10.faceTextureId[var11];
						}
					}
					if (var6) {
						if (var10.faceTextureAxis == null || var10.faceTextureAxis[var11] == -1) {
							this.faceTextureAxis[this.faceCount] = -1;
						} else {
							this.faceTextureAxis[this.faceCount] = (byte) (var10.faceTextureAxis[var11] + this.faceTextureCount);
						}
					}
					this.faceCount++;
				}
				for (int var12 = 0; var12 < var10.faceTextureCount; var12++) {
					this.faceTextureP[this.faceTextureCount] = var10.faceTextureP[var12] + this.vertexCount;
					this.faceTextureM[this.faceTextureCount] = var10.faceTextureM[var12] + this.vertexCount;
					this.faceTextureN[this.faceTextureCount] = var10.faceTextureN[var12] + this.vertexCount;
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
			var15.faceTextureAxis = this.faceTextureAxis;
			var15.faceTextureId = this.faceTextureId;
			var15.priority = this.priority;
			var15.faceTextureP = this.faceTextureP;
			var15.faceTextureM = this.faceTextureM;
			var15.faceTextureN = this.faceTextureN;
			var15.labelVertices = this.labelVertices;
			var15.labelFaces = this.labelFaces;
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
		model.faceTextureAxis = this.faceTextureAxis;
		model.faceTextureId = this.faceTextureId;
		model.priority = this.priority;
		model.faceTextureP = this.faceTextureP;
		model.faceTextureM = this.faceTextureM;
		model.faceTextureN = this.faceTextureN;
		model.labelVertices = this.labelVertices;
		model.labelFaces = this.labelFaces;
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
	public void animate2(int type, int[] labels, int arg2, int arg3, int arg4) {
		int labelCount = labels.length;

		if (type == 0) {
			int count = 0;

			oX = 0;
			oY = 0;
			oZ = 0;

			for (int var8 = 0; var8 < labelCount; var8++) {
				int var9 = labels[var8];
				if (var9 < this.labelVertices.length) {
					int[] var10 = this.labelVertices[var9];
					for (int var11 = 0; var11 < var10.length; var11++) {
						int var12 = var10[var11];
						oX += this.vertexX[var12];
						oY += this.vertexY[var12];
						oZ += this.vertexZ[var12];
						count++;
					}
				}
			}
			if (count > 0) {
				oX = oX / count + arg2;
				oY = oY / count + arg3;
				oZ = oZ / count + arg4;
			} else {
				oX = arg2;
				oY = arg3;
				oZ = arg4;
			}
		} else if (type == 1) {
			for (int var13 = 0; var13 < labelCount; var13++) {
				int var14 = labels[var13];
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
		} else if (type == 2) {
			for (int var18 = 0; var18 < labelCount; var18++) {
				int var19 = labels[var18];
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
		} else if (type == 3) {
			for (int var35 = 0; var35 < labelCount; var35++) {
				int var36 = labels[var35];
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
		} else if (type == 5 && (this.labelFaces != null && this.faceAlpha != null)) {
			for (int l = 0; l < labelCount; l++) {
				int label = labels[l];
				if (label < this.labelFaces.length) {
					int[] faces = this.labelFaces[label];
					for (int i = 0; i < faces.length; i++) {
						int f = faces[i];
						int alpha = (this.faceAlpha[f] & 0xFF) + arg2 * 8;
						if (alpha < 0) {
							alpha = 0;
						} else if (alpha > 255) {
							alpha = 255;
						}
						this.faceAlpha[f] = (byte) alpha;
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

		if (typecode > 0 && mouseCheck) {
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
			if (this.faceColourC[f] == -2) {
				continue;
			}

			int a = this.faceVertexA[f];
			int b = this.faceVertexB[f];
			int c = this.faceVertexC[f];

			int xA = vertexScreenX[a];
			int xB = vertexScreenX[b];
			int xC = vertexScreenX[c];

			if (clipped && (xA == -5000 || xB == -5000 || xC == -5000)) {
				int vxA = vertexViewSpaceX[a];
				int vxB = vertexViewSpaceX[b];
				int vxC = vertexViewSpaceX[c];

				int vyA = vertexViewSpaceY[a];
				int vyB = vertexViewSpaceY[b];
				int vyC = vertexViewSpaceY[c];

				int vzA = vertexViewSpaceZ[a];
				int vzB = vertexViewSpaceZ[b];
				int vzC = vertexViewSpaceZ[c];

				int var21 = vxA - vxB;
				int var22 = vxC - vxB;
				int var23 = vyA - vyB;

				int var24 = vyC - vyB;
				int var25 = vzA - vzB;
				int var26 = vzC - vzB;

				int normalX = var23 * var26 - var24 * var25;
				int normalY = var22 * var25 - var21 * var26;
				int normalZ = var21 * var24 - var22 * var23;

				if (vzB * normalZ + vxB * normalX + vyB * normalY > 0) {
					faceNearClipped[f] = true;

					int depthAverage = (vertexScreenZ[a] + vertexScreenZ[b] + vertexScreenZ[c]) / 3 + this.minDepth;
					tmpDepthFaces[depthAverage][tmpDepthFaceCount[depthAverage]++] = f;
				}
			} else {
				if (picking && this.isMouseRoughlyInsideTriangle(mouseX, mouseY, vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], xA, xB, xC)) {
					pickedEntityTypecode[pickedCount++] = typecode;
					picking = false;
				}

				if ((vertexScreenY[c] - vertexScreenY[b]) * (xA - xB) - (vertexScreenY[a] - vertexScreenY[b]) * (xC - xB) > 0) {
					faceNearClipped[f] = false;

					if (xA >= 0 && xB >= 0 && xC >= 0 && xA <= Pix3D.sizeX && xB <= Pix3D.sizeX && xC <= Pix3D.sizeX) {
						faceClippedX[f] = false;
					} else {
						faceClippedX[f] = true;
					}

					int depthAverage = (vertexScreenZ[a] + vertexScreenZ[b] + vertexScreenZ[c]) / 3 + this.minDepth;
					tmpDepthFaces[depthAverage][tmpDepthFaceCount[depthAverage]++] = f;
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

		if (this.faceTextureId != null && this.faceTextureId[face] != -1) {
			int tA;
			int tB;
			int tC;
			if (this.faceTextureAxis == null || this.faceTextureAxis[face] == -1) {
				tA = a;
				tB = b;
				tC = c;
			} else {
				int texturedFace = this.faceTextureAxis[face] & 0xFF;
				tA = this.faceTextureP[texturedFace];
				tB = this.faceTextureM[texturedFace];
				tC = this.faceTextureN[texturedFace];
			}
			if (this.faceColourC[face] == -1) {
				Pix3D.textureTriangleAffine(vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], vertexScreenX[a], vertexScreenX[b], vertexScreenX[c], this.faceColourA[face], this.faceColourA[face], this.faceColourA[face], vertexViewSpaceX[tA], vertexViewSpaceX[tB], vertexViewSpaceX[tC], vertexViewSpaceY[tA], vertexViewSpaceY[tB], vertexViewSpaceY[tC], vertexViewSpaceZ[tA], vertexViewSpaceZ[tB], vertexViewSpaceZ[tC], this.faceTextureId[face]);
			} else {
				Pix3D.textureTriangleAffine(vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], vertexScreenX[a], vertexScreenX[b], vertexScreenX[c], this.faceColourA[face], this.faceColourB[face], this.faceColourC[face], vertexViewSpaceX[tA], vertexViewSpaceX[tB], vertexViewSpaceX[tC], vertexViewSpaceY[tA], vertexViewSpaceY[tB], vertexViewSpaceY[tC], vertexViewSpaceZ[tA], vertexViewSpaceZ[tB], vertexViewSpaceZ[tC], this.faceTextureId[face]);
			}
		} else if (this.faceColourC[face] != -1) {
			Pix3D.gouraudTriangle(vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], vertexScreenX[a], vertexScreenX[b], vertexScreenX[c], this.faceColourA[face], this.faceColourB[face], this.faceColourC[face]);
		} else {
			Pix3D.flatTriangle(vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], vertexScreenX[a], vertexScreenX[b], vertexScreenX[c], colourTable[this.faceColourA[face]]);
		}
	}

	// jag::oldscape::dash3d::SoftwareModelLitRenderer::Render3ZClip
	@ObfuscatedName("fo.ah(I)V")
	public final void render3ZClip(int face) {
		int originX = Pix3D.originX;
		int originY = Pix3D.originY;

		int elements = 0;

		int a = this.faceVertexA[face];
		int b = this.faceVertexB[face];
		int c = this.faceVertexC[face];

		int zA = vertexViewSpaceZ[a];
		int zB = vertexViewSpaceZ[b];
		int zC = vertexViewSpaceZ[c];

		if (this.faceAlpha == null) {
			Pix3D.trans = 0;
		} else {
			Pix3D.trans = this.faceAlpha[face] & 0xFF;
		}

		if (zA >= 50) {
			clippedX[elements] = vertexScreenX[a];
			clippedY[elements] = vertexScreenY[a];
			clippedColour[elements++] = this.faceColourA[face];
		} else {
			int xA = vertexViewSpaceX[a];
			int yA = vertexViewSpaceY[a];
			int colour = this.faceColourA[face];

			if (zC >= 50) {
				int var14 = (50 - zA) * divTable2[zC - zA];
				clippedX[elements] = (((vertexViewSpaceX[c] - xA) * var14 >> 16) + xA << 9) / 50 + originX;
				clippedY[elements] = (((vertexViewSpaceY[c] - yA) * var14 >> 16) + yA << 9) / 50 + originY;
				clippedColour[elements++] = ((this.faceColourC[face] - colour) * var14 >> 16) + colour;
			}

			if (zB >= 50) {
				int var15 = (50 - zA) * divTable2[zB - zA];
				clippedX[elements] = (((vertexViewSpaceX[b] - xA) * var15 >> 16) + xA << 9) / 50 + originX;
				clippedY[elements] = (((vertexViewSpaceY[b] - yA) * var15 >> 16) + yA << 9) / 50 + originY;
				clippedColour[elements++] = ((this.faceColourB[face] - colour) * var15 >> 16) + colour;
			}
		}

		if (zB >= 50) {
			clippedX[elements] = vertexScreenX[b];
			clippedY[elements] = vertexScreenY[b];
			clippedColour[elements++] = this.faceColourB[face];
		} else {
			int var16 = vertexViewSpaceX[b];
			int var17 = vertexViewSpaceY[b];
			int var18 = this.faceColourB[face];
			if (zA >= 50) {
				int var19 = (50 - zB) * divTable2[zA - zB];
				clippedX[elements] = (((vertexViewSpaceX[a] - var16) * var19 >> 16) + var16 << 9) / 50 + originX;
				clippedY[elements] = (((vertexViewSpaceY[a] - var17) * var19 >> 16) + var17 << 9) / 50 + originY;
				clippedColour[elements++] = ((this.faceColourA[face] - var18) * var19 >> 16) + var18;
			}
			if (zC >= 50) {
				int var20 = (50 - zB) * divTable2[zC - zB];
				clippedX[elements] = (((vertexViewSpaceX[c] - var16) * var20 >> 16) + var16 << 9) / 50 + originX;
				clippedY[elements] = (((vertexViewSpaceY[c] - var17) * var20 >> 16) + var17 << 9) / 50 + originY;
				clippedColour[elements++] = ((this.faceColourC[face] - var18) * var20 >> 16) + var18;
			}
		}

		if (zC >= 50) {
			clippedX[elements] = vertexScreenX[c];
			clippedY[elements] = vertexScreenY[c];
			clippedColour[elements++] = this.faceColourC[face];
		} else {
			int var21 = vertexViewSpaceX[c];
			int var22 = vertexViewSpaceY[c];
			int var23 = this.faceColourC[face];
			if (zB >= 50) {
				int var24 = (50 - zC) * divTable2[zB - zC];
				clippedX[elements] = (((vertexViewSpaceX[b] - var21) * var24 >> 16) + var21 << 9) / 50 + originX;
				clippedY[elements] = (((vertexViewSpaceY[b] - var22) * var24 >> 16) + var22 << 9) / 50 + originY;
				clippedColour[elements++] = ((this.faceColourB[face] - var23) * var24 >> 16) + var23;
			}
			if (zA >= 50) {
				int var25 = (50 - zC) * divTable2[zA - zC];
				clippedX[elements] = (((vertexViewSpaceX[a] - var21) * var25 >> 16) + var21 << 9) / 50 + originX;
				clippedY[elements] = (((vertexViewSpaceY[a] - var22) * var25 >> 16) + var22 << 9) / 50 + originY;
				clippedColour[elements++] = ((this.faceColourA[face] - var23) * var25 >> 16) + var23;
			}
		}

		int x0 = clippedX[0];
		int x1 = clippedX[1];
		int x2 = clippedX[2];
		int y0 = clippedY[0];
		int y1 = clippedY[1];
		int y2 = clippedY[2];

		Pix3D.hclip = false;

		if (elements == 3) {
			if (x0 < 0 || x1 < 0 || x2 < 0 || x0 > Pix3D.sizeX || x1 > Pix3D.sizeX || x2 > Pix3D.sizeX) {
				Pix3D.hclip = true;
			}

			if (this.faceTextureId != null && this.faceTextureId[face] != -1) {
				int tA;
				int tB;
				int tC;
				if (this.faceTextureAxis == null || this.faceTextureAxis[face] == -1) {
					tA = a;
					tB = b;
					tC = c;
				} else {
					int texturedFace = this.faceTextureAxis[face] & 0xFF;
					tA = this.faceTextureP[texturedFace];
					tB = this.faceTextureM[texturedFace];
					tC = this.faceTextureN[texturedFace];
				}

				if (this.faceColourC[face] == -1) {
					Pix3D.textureTriangleAffine(y0, y1, y2, x0, x1, x2, this.faceColourA[face], this.faceColourA[face], this.faceColourA[face], vertexViewSpaceX[tA], vertexViewSpaceX[tB], vertexViewSpaceX[tC], vertexViewSpaceY[tA], vertexViewSpaceY[tB], vertexViewSpaceY[tC], vertexViewSpaceZ[tA], vertexViewSpaceZ[tB], vertexViewSpaceZ[tC], this.faceTextureId[face]);
				} else {
					Pix3D.textureTriangleAffine(y0, y1, y2, x0, x1, x2, clippedColour[0], clippedColour[1], clippedColour[2], vertexViewSpaceX[tA], vertexViewSpaceX[tB], vertexViewSpaceX[tC], vertexViewSpaceY[tA], vertexViewSpaceY[tB], vertexViewSpaceY[tC], vertexViewSpaceZ[tA], vertexViewSpaceZ[tB], vertexViewSpaceZ[tC], this.faceTextureId[face]);
				}
			} else if (this.faceColourC[face] == -1) {
				Pix3D.flatTriangle(y0, y1, y2, x0, x1, x2, colourTable[this.faceColourA[face]]);
			} else {
				Pix3D.gouraudTriangle(y0, y1, y2, x0, x1, x2, clippedColour[0], clippedColour[1], clippedColour[2]);
			}
		} else if (elements == 4) {
			if (x0 < 0 || x1 < 0 || x2 < 0 || x0 > Pix3D.sizeX || x1 > Pix3D.sizeX || x2 > Pix3D.sizeX || clippedX[3] < 0 || clippedX[3] > Pix3D.sizeX) {
				Pix3D.hclip = true;
			}

			if (this.faceTextureId != null && this.faceTextureId[face] != -1) {
				int tA;
				int tB;
				int tC;
				if (this.faceTextureAxis == null || this.faceTextureAxis[face] == -1) {
					tA = a;
					tB = b;
					tC = c;
				} else {
					int texturedFace = this.faceTextureAxis[face] & 0xFF;
					tA = this.faceTextureP[texturedFace];
					tB = this.faceTextureM[texturedFace];
					tC = this.faceTextureN[texturedFace];
				}

				short textureId = this.faceTextureId[face];
				if (this.faceColourC[face] == -1) {
					Pix3D.textureTriangleAffine(y0, y1, y2, x0, x1, x2, this.faceColourA[face], this.faceColourA[face], this.faceColourA[face], vertexViewSpaceX[tA], vertexViewSpaceX[tB], vertexViewSpaceX[tC], vertexViewSpaceY[tA], vertexViewSpaceY[tB], vertexViewSpaceY[tC], vertexViewSpaceZ[tA], vertexViewSpaceZ[tB], vertexViewSpaceZ[tC], textureId);
					Pix3D.textureTriangleAffine(
						y0, y2, clippedY[3],
						x0, x2, clippedX[3],
						this.faceColourA[face], this.faceColourA[face], this.faceColourA[face],
						vertexViewSpaceX[tA], vertexViewSpaceX[tB], vertexViewSpaceX[tC],
						vertexViewSpaceY[tA], vertexViewSpaceY[tB],
						vertexViewSpaceY[tC], vertexViewSpaceZ[tA],
						vertexViewSpaceZ[tB], vertexViewSpaceZ[tC],
						textureId
					);
				} else {
					Pix3D.textureTriangleAffine(
						y0, y1, y2,
						x0, x1, x2,
						clippedColour[0], clippedColour[1], clippedColour[2],
						vertexViewSpaceX[tA], vertexViewSpaceX[tB], vertexViewSpaceX[tC],
						vertexViewSpaceY[tA], vertexViewSpaceY[tB], vertexViewSpaceY[tC],
						vertexViewSpaceZ[tA], vertexViewSpaceZ[tB], vertexViewSpaceZ[tC],
						textureId
					);

					Pix3D.textureTriangleAffine(
						y0, y2, clippedY[3],
						x0, x2, clippedX[3],
						clippedColour[0], clippedColour[2], clippedColour[3],
						vertexViewSpaceX[tA], vertexViewSpaceX[tB], vertexViewSpaceX[tC],
						vertexViewSpaceY[tA], vertexViewSpaceY[tB], vertexViewSpaceY[tC],
						vertexViewSpaceZ[tA], vertexViewSpaceZ[tB], vertexViewSpaceZ[tC],
						textureId
					);
				}
			} else if (this.faceColourC[face] != -1) {
				Pix3D.gouraudTriangle(y0, y1, y2, x0, x1, x2, clippedColour[0], clippedColour[1], clippedColour[2]);
				Pix3D.gouraudTriangle(y0, y2, clippedY[3], x0, x2, clippedX[3], clippedColour[0], clippedColour[2], clippedColour[3]);
			} else {
				int var41 = colourTable[this.faceColourA[face]];
				Pix3D.flatTriangle(y0, y1, y2, x0, x1, x2, var41);
				Pix3D.flatTriangle(y0, y2, clippedY[3], x0, x2, clippedX[3], var41);
			}
		}
	}

	// jag::oldscape::dash3d::MousePickingHelper::IsMouseRoughlyInsideTriangle
	@ObfuscatedName("fo.ay(IIIIIIII)Z")
	public final boolean isMouseRoughlyInsideTriangle(int x, int y, int yA, int yB, int yC, int xA, int xB, int xC) {
		if (y < yA && y < yB && y < yC) {
			return false;
		} else if (y > yA && y > yB && y > yC) {
			return false;
		} else if (x < xA && x < xB && x < xC) {
			return false;
		} else if (x > xA && x > xB && x > xC) {
			return false;
		} else {
			return true;
		}
	}
}
