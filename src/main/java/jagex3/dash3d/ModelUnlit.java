package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.io.Packet;
import jagex3.js5.Js5;

@ObfuscatedName("fw")
public class ModelUnlit extends ModelSource {

	@ObfuscatedName("fw.j")
	public int vertexCount = 0;

	@ObfuscatedName("fw.z")
	public int[] vertexX;

	@ObfuscatedName("fw.g")
	public int[] vertexY;

	@ObfuscatedName("fw.q")
	public int[] vertexZ;

	@ObfuscatedName("fw.i")
	public int faceCount = 0;

	@ObfuscatedName("fw.s")
	public int[] faceVertexA;

	@ObfuscatedName("fw.u")
	public int[] faceVertexB;

	@ObfuscatedName("fw.v")
	public int[] faceVertexC;

	@ObfuscatedName("fw.w")
	public byte[] faceRenderType;

	@ObfuscatedName("fw.e")
	public byte[] facePriority;

	@ObfuscatedName("fw.b")
	public byte[] faceAlpha;

	@ObfuscatedName("fw.y")
	public byte[] faceTextureAxis;

	@ObfuscatedName("fw.t")
	public short[] faceColour;

	@ObfuscatedName("fw.f")
	public short[] faceTextureId;

	@ObfuscatedName("fw.k")
	public byte priority = 0;

	@ObfuscatedName("fw.o")
	public int faceTextureCount;

	@ObfuscatedName("fw.a")
	public byte[] textureRenderType;

	@ObfuscatedName("fw.h")
	public short[] faceTextureP;

	@ObfuscatedName("fw.x")
	public short[] faceTextureM;

	@ObfuscatedName("fw.p")
	public short[] faceTextureN;

	@ObfuscatedName("fw.ad")
	public short[] textureScaleX;

	@ObfuscatedName("fw.ac")
	public short[] textureScaleY;

	@ObfuscatedName("fw.aa")
	public short[] textureScaleZ;

	@ObfuscatedName("fw.as")
	public short[] textureRotation;

	@ObfuscatedName("fw.am")
	public short[] textureSpeed;

	@ObfuscatedName("fw.ap")
	public short[] textureDirection;

	@ObfuscatedName("fw.av")
	public byte[] textureTranslation;

	@ObfuscatedName("fw.ak")
	public int[] vertexLabel;

	@ObfuscatedName("fw.az")
	public int[] faceLabel;

	@ObfuscatedName("fw.an")
	public int[][] labelVertices;

	@ObfuscatedName("fw.ah")
	public int[][] labelFaces;

	@ObfuscatedName("fw.ay")
	public FaceNormal[] faceNormal;

	@ObfuscatedName("fw.al")
	public PointNormal[] vertexNormal;

	@ObfuscatedName("fw.ab")
	public PointNormal[] sharedVertexNormals;

	@ObfuscatedName("fw.ao")
	public short ambient;

	@ObfuscatedName("fw.ag")
	public short contrast;

	@ObfuscatedName("fw.ar")
	public boolean boundsCalculated = false;

	@ObfuscatedName("fw.aq")
	public int maxY;

	@ObfuscatedName("fw.at")
	public int minX;

	@ObfuscatedName("fw.ae")
	public int maxX;

	@ObfuscatedName("fw.au")
	public int minZ;

	@ObfuscatedName("fw.ax")
	public int maxZ;

	@ObfuscatedName("fw.ai")
	public static int[] shareTickA = new int[10000];

	@ObfuscatedName("fw.aj")
	public static int[] shareTickB = new int[10000];

	// jag::oldscape::dash3d::ModelUnlitImpl::m_shareTic
	@ObfuscatedName("fw.aw")
	public static int shareTic = 0;

	@ObfuscatedName("fw.af")
	public static int[] sinTable = Pix3D.sinTable;

	@ObfuscatedName("fw.bh")
	public static int[] cosTable = Pix3D.cosTable;

	public ModelUnlit() {
	}

	// jag::oldscape::dash3d::ModelUnlit::Load
	@ObfuscatedName("fw.b(Lch;II)Lfw;")
	public static ModelUnlit load(Js5 arg0, int arg1, int arg2) {
		byte[] var3 = arg0.getFile(arg1, arg2);
		return var3 == null ? null : new ModelUnlit(var3);
	}

	public ModelUnlit(byte[] src) {
		if (src[src.length - 1] == -1 && src[src.length - 2] == -1) {
			this.loadOb3(src);
		} else {
			this.loadOb2(src);
		}
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::LoadOb3Engine200
	@ObfuscatedName("fw.y([B)V")
	public void loadOb3(byte[] src) {
		Packet var1 = new Packet(src);
		Packet var3 = new Packet(src);
		Packet var4 = new Packet(src);
		Packet var5 = new Packet(src);
		Packet var6 = new Packet(src);
		Packet var7 = new Packet(src);
		Packet var8 = new Packet(src);

		var1.pos = src.length - 23;
		int var9 = var1.g2();
		int var10 = var1.g2();
		int var11 = var1.g1();
		int var12 = var1.g1();
		int hasPriorities = var1.g1();
		int var14 = var1.g1();
		int var15 = var1.g1();
		int var16 = var1.g1();
		int var17 = var1.g1();
		int var18 = var1.g2();
		int var19 = var1.g2();
		int var20 = var1.g2();
		int var21 = var1.g2();
		int var22 = var1.g2();

		int var23 = 0;
		int var24 = 0;
		int var25 = 0;
		if (var11 > 0) {
			this.textureRenderType = new byte[var11];
			var1.pos = 0;

			for (int var26 = 0; var26 < var11; var26++) {
				byte var27 = this.textureRenderType[var26] = var1.g1b();
				if (var27 == 0) {
					var23++;
				}
				if (var27 >= 1 && var27 <= 3) {
					var24++;
				}
				if (var27 == 2) {
					var25++;
				}
			}
		}

		int var30 = var9 + var11;
		int var31 = var30;
		if (var12 == 1) {
			var30 += var10;
		}

		int var33 = var10 + var30;
		int var34 = var33;
		if (hasPriorities == 255) {
			var33 += var10;
		}

		int var35 = var33;
		if (var15 == 1) {
			var33 += var10;
		}

		int var36 = var33;
		if (var17 == 1) {
			var33 += var9;
		}

		int var37 = var33;
		if (var14 == 1) {
			var33 += var10;
		}

		int var39 = var21 + var33;
		int var40 = var39;
		if (var16 == 1) {
			var39 += var10 * 2;
		}

		int var42 = var22 + var39;
		int var44 = var10 * 2 + var42;
		int var46 = var18 + var44;
		int var48 = var19 + var46;
		int var50 = var20 + var48;
		int var52 = var23 * 6 + var50;
		int var54 = var24 * 6 + var52;
		int var56 = var24 * 6 + var54;
		int var58 = var24 * 2 + var56;
		int var60 = var24 + var58;
		int var62 = var24 * 2 + var25 * 2 + var60;

		this.vertexCount = var9;
		this.faceCount = var10;
		this.faceTextureCount = var11;
		this.vertexX = new int[var9];
		this.vertexY = new int[var9];
		this.vertexZ = new int[var9];
		this.faceVertexA = new int[var10];
		this.faceVertexB = new int[var10];
		this.faceVertexC = new int[var10];

		if (var17 == 1) {
			this.vertexLabel = new int[var9];
		}

		if (var12 == 1) {
			this.faceRenderType = new byte[var10];
		}

		if (hasPriorities == 255) {
			this.facePriority = new byte[var10];
		} else {
			this.priority = (byte) hasPriorities;
		}

		if (var14 == 1) {
			this.faceAlpha = new byte[var10];
		}

		if (var15 == 1) {
			this.faceLabel = new int[var10];
		}

		if (var16 == 1) {
			this.faceTextureId = new short[var10];
		}

		if (var16 == 1 && var11 > 0) {
			this.faceTextureAxis = new byte[var10];
		}

		this.faceColour = new short[var10];
		if (var11 > 0) {
			this.faceTextureP = new short[var11];
			this.faceTextureM = new short[var11];
			this.faceTextureN = new short[var11];

			if (var24 > 0) {
				this.textureScaleX = new short[var24];
				this.textureScaleY = new short[var24];
				this.textureScaleZ = new short[var24];
				this.textureRotation = new short[var24];
				this.textureTranslation = new byte[var24];
				this.textureSpeed = new short[var24];
			}

			if (var25 > 0) {
				this.textureDirection = new short[var25];
			}
		}

		var1.pos = var11;
		var3.pos = var44;
		var4.pos = var46;
		var5.pos = var48;
		var6.pos = var36;

		int var64 = 0;
		int var65 = 0;
		int var66 = 0;
		for (int var67 = 0; var67 < var9; var67++) {
			int var68 = var1.g1();
			int var69 = 0;
			if ((var68 & 0x1) != 0) {
				var69 = var3.gsmarts();
			}
			int var70 = 0;
			if ((var68 & 0x2) != 0) {
				var70 = var4.gsmarts();
			}
			int var71 = 0;
			if ((var68 & 0x4) != 0) {
				var71 = var5.gsmarts();
			}

			this.vertexX[var67] = var64 + var69;
			this.vertexY[var67] = var65 + var70;
			this.vertexZ[var67] = var66 + var71;

			var64 = this.vertexX[var67];
			var65 = this.vertexY[var67];
			var66 = this.vertexZ[var67];

			if (var17 == 1) {
				this.vertexLabel[var67] = var6.g1();
			}
		}

		var1.pos = var42;
		var3.pos = var31;
		var4.pos = var34;
		var5.pos = var37;
		var6.pos = var35;
		var7.pos = var40;
		var8.pos = var39;

		for (int var72 = 0; var72 < var10; var72++) {
			this.faceColour[var72] = (short) var1.g2();

			if (var12 == 1) {
				this.faceRenderType[var72] = var3.g1b();
			}

			if (hasPriorities == 255) {
				this.facePriority[var72] = var4.g1b();
			}

			if (var14 == 1) {
				this.faceAlpha[var72] = var5.g1b();
			}

			if (var15 == 1) {
				this.faceLabel[var72] = var6.g1();
			}

			if (var16 == 1) {
				this.faceTextureId[var72] = (short) (var7.g2() - 1);
			}

			if (this.faceTextureAxis != null && this.faceTextureId[var72] != -1) {
				this.faceTextureAxis[var72] = (byte) (var8.g1() - 1);
			}
		}

		var1.pos = var33;
		var3.pos = var30;

		int var73 = 0;
		int var74 = 0;
		int var75 = 0;
		int var76 = 0;
		for (int var77 = 0; var77 < var10; var77++) {
			int var78 = var3.g1();
			if (var78 == 1) {
				var73 = var1.gsmarts() + var76;
				var74 = var1.gsmarts() + var73;
				var75 = var1.gsmarts() + var74;
				var76 = var75;
				this.faceVertexA[var77] = var73;
				this.faceVertexB[var77] = var74;
				this.faceVertexC[var77] = var75;
			}
			if (var78 == 2) {
				var74 = var75;
				var75 = var1.gsmarts() + var76;
				var76 = var75;
				this.faceVertexA[var77] = var73;
				this.faceVertexB[var77] = var74;
				this.faceVertexC[var77] = var75;
			}
			if (var78 == 3) {
				var73 = var75;
				var75 = var1.gsmarts() + var76;
				var76 = var75;
				this.faceVertexA[var77] = var73;
				this.faceVertexB[var77] = var74;
				this.faceVertexC[var77] = var75;
			}
			if (var78 == 4) {
				int var81 = var73;
				var73 = var74;
				var74 = var81;
				var75 = var1.gsmarts() + var76;
				var76 = var75;
				this.faceVertexA[var77] = var73;
				this.faceVertexB[var77] = var81;
				this.faceVertexC[var77] = var75;
			}
		}

		var1.pos = var50;
		var3.pos = var52;
		var4.pos = var54;
		var5.pos = var56;
		var6.pos = var58;
		var7.pos = var60;

		for (int var82 = 0; var82 < var11; var82++) {
			int var83 = this.textureRenderType[var82] & 0xFF;
			if (var83 == 0) {
				this.faceTextureP[var82] = (short) var1.g2();
				this.faceTextureM[var82] = (short) var1.g2();
				this.faceTextureN[var82] = (short) var1.g2();
			}
			if (var83 == 1) {
				this.faceTextureP[var82] = (short) var3.g2();
				this.faceTextureM[var82] = (short) var3.g2();
				this.faceTextureN[var82] = (short) var3.g2();
				this.textureScaleX[var82] = (short) var4.g2();
				this.textureScaleY[var82] = (short) var4.g2();
				this.textureScaleZ[var82] = (short) var4.g2();
				this.textureRotation[var82] = (short) var5.g2();
				this.textureTranslation[var82] = var6.g1b();
				this.textureSpeed[var82] = (short) var7.g2();
			}
			if (var83 == 2) {
				this.faceTextureP[var82] = (short) var3.g2();
				this.faceTextureM[var82] = (short) var3.g2();
				this.faceTextureN[var82] = (short) var3.g2();
				this.textureScaleX[var82] = (short) var4.g2();
				this.textureScaleY[var82] = (short) var4.g2();
				this.textureScaleZ[var82] = (short) var4.g2();
				this.textureRotation[var82] = (short) var5.g2();
				this.textureTranslation[var82] = var6.g1b();
				this.textureSpeed[var82] = (short) var7.g2();
				this.textureDirection[var82] = (short) var7.g2();
			}
			if (var83 == 3) {
				this.faceTextureP[var82] = (short) var3.g2();
				this.faceTextureM[var82] = (short) var3.g2();
				this.faceTextureN[var82] = (short) var3.g2();
				this.textureScaleX[var82] = (short) var4.g2();
				this.textureScaleY[var82] = (short) var4.g2();
				this.textureScaleZ[var82] = (short) var4.g2();
				this.textureRotation[var82] = (short) var5.g2();
				this.textureTranslation[var82] = var6.g1b();
				this.textureSpeed[var82] = (short) var7.g2();
			}
		}

		var1.pos = var62;
		int var84 = var1.g1();
		if (var84 != 0) {
			new UnusedAJ();
			var1.g2();
			var1.g2();
			var1.g2();
			var1.g4();
		}
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::LoadOb2Engine200
	@ObfuscatedName("fw.t([B)V")
	public void loadOb2(byte[] src) {
		boolean hasRenderType = false;
		boolean hasTextureId = false;

		Packet trailer = new Packet(src);
		trailer.pos = src.length - 18;

		int vertexCount = trailer.g2();
		int faceCount = trailer.g2();
		int faceTextureCount = trailer.g1();

		int hasFaceInfo = trailer.g1();

		int priority = trailer.g1();
		int hasFaceAlpha = trailer.g1();
		int hasFaceLabels = trailer.g1();
		int hasVertexLabels = trailer.g1();

		int dataLengthX = trailer.g2();
		int dataLengthY = trailer.g2();
		int dataLengthZ = trailer.g2();
		int dataLengthFaceIndex = trailer.g2();

		int pos = 0;

		int vertexOrderOffset = pos;
		pos += vertexCount;

		int faceIndexOrderOffset = pos;
		pos += faceCount;

		int facePriorityOffset = pos;
		if (priority == 255) {
			pos += faceCount;
		}

		int faceLabelOffset = pos;
		if (hasFaceLabels == 1) {
			pos += faceCount;
		}

		int faceInfoOffset = pos;
		if (hasFaceInfo == 1) {
			pos += faceCount;
		}

		int vertexLabelOffset = pos;
		if (hasVertexLabels == 1) {
			pos += vertexCount;
		}

		int faceAlphaOffset = pos;
		if (hasFaceAlpha == 1) {
			pos += faceCount;
		}

		int faceIndexOffset = pos;
		pos += dataLengthFaceIndex;

		int faceColourOffset = pos;
		pos += faceCount * 2;

		int faceTextureAxisOffset = pos;
		pos += faceTextureCount * 6;

		int vertexXOffset = pos;
		pos += dataLengthX;

		int vertexYOffset = pos;
		pos += dataLengthY;

		int vertexZOffset = pos;
		pos += dataLengthZ;

		this.vertexCount = vertexCount;
		this.faceCount = faceCount;
		this.faceTextureCount = faceTextureCount;

		this.vertexX = new int[vertexCount];
		this.vertexY = new int[vertexCount];
		this.vertexZ = new int[vertexCount];

		this.faceVertexA = new int[faceCount];
		this.faceVertexB = new int[faceCount];
		this.faceVertexC = new int[faceCount];

		if (faceTextureCount > 0) {
			this.textureRenderType = new byte[faceTextureCount];
			this.faceTextureP = new short[faceTextureCount];
			this.faceTextureM = new short[faceTextureCount];
			this.faceTextureN = new short[faceTextureCount];
		}

		if (hasVertexLabels == 1) {
			this.vertexLabel = new int[vertexCount];
		}

		if (hasFaceInfo == 1) {
			this.faceRenderType = new byte[faceCount];
			this.faceTextureAxis = new byte[faceCount];
			this.faceTextureId = new short[faceCount];
		}

		if (priority == 255) {
			this.facePriority = new byte[faceCount];
		} else {
			this.priority = (byte) priority;
		}

		if (hasFaceAlpha == 1) {
			this.faceAlpha = new byte[faceCount];
		}

		if (hasFaceLabels == 1) {
			this.faceLabel = new int[faceCount];
		}

		this.faceColour = new short[faceCount];

		Packet point1 = new Packet(src);
		point1.pos = vertexOrderOffset;

		Packet point2 = new Packet(src);
		point2.pos = vertexXOffset;

		Packet point3 = new Packet(src);
		point3.pos = vertexYOffset;

		Packet point4 = new Packet(src);
		point4.pos = vertexZOffset;

		Packet point5 = new Packet(src);
		point5.pos = vertexLabelOffset;

		int dx = 0;
		int dy = 0;
		int dz = 0;
		for (int v = 0; v < vertexCount; v++) {
			int order = point1.g1();

			int x = 0;
			if ((order & 0x1) != 0) {
				x = point2.gsmarts();
			}

			int y = 0;
			if ((order & 0x2) != 0) {
				y = point3.gsmarts();
			}

			int z = 0;
			if ((order & 0x4) != 0) {
				z = point4.gsmarts();
			}

			this.vertexX[v] = dx + x;
			this.vertexY[v] = dy + y;
			this.vertexZ[v] = dz + z;

			dx = this.vertexX[v];
			dy = this.vertexY[v];
			dz = this.vertexZ[v];

			if (hasVertexLabels == 1) {
				this.vertexLabel[v] = point5.g1();
			}
		}

		Packet face1 = new Packet(src);
		face1.pos = faceColourOffset;

		Packet face2 = new Packet(src);
		face2.pos = faceInfoOffset;

		Packet face3 = new Packet(src);
		face3.pos = facePriorityOffset;

		Packet face4 = new Packet(src);
		face4.pos = faceAlphaOffset;

		Packet face5 = new Packet(src);
		face5.pos = faceLabelOffset;

		for (int f = 0; f < faceCount; f++) {
			this.faceColour[f] = (short) face1.g2();

			if (hasFaceInfo == 1) {
				int var52 = face2.g1();
				if ((var52 & 0x1) == 1) {
					this.faceRenderType[f] = 1;
					hasRenderType = true;
				} else {
					this.faceRenderType[f] = 0;
				}
				if ((var52 & 0x2) == 2) {
					this.faceTextureAxis[f] = (byte) (var52 >> 2);
					this.faceTextureId[f] = this.faceColour[f];
					this.faceColour[f] = 127;
					if (this.faceTextureId[f] != -1) {
						hasTextureId = true;
					}
				} else {
					this.faceTextureAxis[f] = -1;
					this.faceTextureId[f] = -1;
				}
			}

			if (priority == 255) {
				this.facePriority[f] = face3.g1b();
			}

			if (hasFaceAlpha == 1) {
				this.faceAlpha[f] = face4.g1b();
			}

			if (hasFaceLabels == 1) {
				this.faceLabel[f] = face5.g1();
			}
		}

		Packet vertex1 = new Packet(src);
		vertex1.pos = faceIndexOffset;

		Packet vertex2 = new Packet(src);
		vertex2.pos = faceIndexOrderOffset;

		int a = 0;
		int b = 0;
		int c = 0;
		int last = 0;
		for (int f = 0; f < faceCount; f++) {
			int order = vertex2.g1();

			if (order == 1) {
				a = vertex1.gsmarts() + last;
				b = vertex1.gsmarts() + a;
				c = vertex1.gsmarts() + b;
				last = c;
			} else if (order == 2) {
				b = c;
				c = vertex1.gsmarts() + last;
				last = c;
			} else if (order == 3) {
				a = c;
				c = vertex1.gsmarts() + last;
				last = c;
			} else if (order == 4) {
				int tmp = a;
				a = b;
				b = tmp;
				c = vertex1.gsmarts() + last;
				last = c;
			}

			this.faceVertexA[f] = a;
			this.faceVertexB[f] = b;
			this.faceVertexC[f] = c;
		}

		Packet axis = new Packet(src);
		axis.pos = faceTextureAxisOffset;

		for (int f = 0; f < faceTextureCount; f++) {
			this.textureRenderType[f] = 0;
			this.faceTextureP[f] = (short) axis.g2();
			this.faceTextureM[f] = (short) axis.g2();
			this.faceTextureN[f] = (short) axis.g2();
		}

		if (this.faceTextureAxis != null) {
			boolean hasTexture = false;
			for (int var64 = 0; var64 < faceCount; var64++) {
				int var65 = this.faceTextureAxis[var64] & 0xFF;
				if (var65 != 255) {
					if ((this.faceTextureP[var65] & 0xFFFF) == this.faceVertexA[var64] && (this.faceTextureM[var65] & 0xFFFF) == this.faceVertexB[var64] && (this.faceTextureN[var65] & 0xFFFF) == this.faceVertexC[var64]) {
						this.faceTextureAxis[var64] = -1;
					} else {
						hasTexture = true;
					}
				}
			}
			if (!hasTexture) {
				this.faceTextureAxis = null;
			}
		}

		if (!hasTextureId) {
			this.faceTextureId = null;
		}

		if (!hasRenderType) {
			this.faceRenderType = null;
		}
	}

	public ModelUnlit(ModelUnlit[] models, int count) {
		boolean copyRenderType = false;
		boolean copyPriority = false;
		boolean copyAlpha = false;
		boolean copyLabel = false;
		boolean copyTextureId = false;
		boolean copyTextureAxis = false;

		this.vertexCount = 0;
		this.faceCount = 0;
		this.faceTextureCount = 0;
		this.priority = -1;

		for (int var9 = 0; var9 < count; var9++) {
			ModelUnlit model = models[var9];
			if (model != null) {
				this.vertexCount += model.vertexCount;
				this.faceCount += model.faceCount;
				this.faceTextureCount += model.faceTextureCount;

				if (model.facePriority == null) {
					if (this.priority == -1) {
						this.priority = model.priority;
					}

					if (this.priority != model.priority) {
						copyPriority = true;
					}
				} else {
					copyPriority = true;
				}

				copyRenderType |= model.faceRenderType != null;
				copyAlpha |= model.faceAlpha != null;
				copyLabel |= model.faceLabel != null;
				copyTextureId |= model.faceTextureId != null;
				copyTextureAxis |= model.faceTextureAxis != null;
			}
		}

		this.vertexX = new int[this.vertexCount];
		this.vertexY = new int[this.vertexCount];
		this.vertexZ = new int[this.vertexCount];

		this.vertexLabel = new int[this.vertexCount];

		this.faceVertexA = new int[this.faceCount];
		this.faceVertexB = new int[this.faceCount];
		this.faceVertexC = new int[this.faceCount];

		if (copyRenderType) {
			this.faceRenderType = new byte[this.faceCount];
		}

		if (copyPriority) {
			this.facePriority = new byte[this.faceCount];
		}

		if (copyAlpha) {
			this.faceAlpha = new byte[this.faceCount];
		}

		if (copyLabel) {
			this.faceLabel = new int[this.faceCount];
		}

		if (copyTextureId) {
			this.faceTextureId = new short[this.faceCount];
		}

		if (copyTextureAxis) {
			this.faceTextureAxis = new byte[this.faceCount];
		}

		this.faceColour = new short[this.faceCount];

		if (this.faceTextureCount > 0) {
			this.textureRenderType = new byte[this.faceTextureCount];
			this.faceTextureP = new short[this.faceTextureCount];
			this.faceTextureM = new short[this.faceTextureCount];
			this.faceTextureN = new short[this.faceTextureCount];
			this.textureScaleX = new short[this.faceTextureCount];
			this.textureScaleY = new short[this.faceTextureCount];
			this.textureScaleZ = new short[this.faceTextureCount];
			this.textureRotation = new short[this.faceTextureCount];
			this.textureTranslation = new byte[this.faceTextureCount];
			this.textureSpeed = new short[this.faceTextureCount];
			this.textureDirection = new short[this.faceTextureCount];
		}

		this.vertexCount = 0;
		this.faceCount = 0;
		this.faceTextureCount = 0;

		for (int i = 0; i < count; i++) {
			ModelUnlit model = models[i];
			if (model == null) {
				continue;
			}

			for (int f = 0; f < model.faceCount; f++) {
				if (copyRenderType && model.faceRenderType != null) {
					this.faceRenderType[this.faceCount] = model.faceRenderType[f];
				}

				if (copyPriority) {
					if (model.facePriority == null) {
						this.facePriority[this.faceCount] = model.priority;
					} else {
						this.facePriority[this.faceCount] = model.facePriority[f];
					}
				}

				if (copyAlpha && model.faceAlpha != null) {
					this.faceAlpha[this.faceCount] = model.faceAlpha[f];
				}

				if (copyLabel && model.faceLabel != null) {
					this.faceLabel[this.faceCount] = model.faceLabel[f];
				}

				if (copyTextureId) {
					if (model.faceTextureId == null) {
						this.faceTextureId[this.faceCount] = -1;
					} else {
						this.faceTextureId[this.faceCount] = model.faceTextureId[f];
					}
				}

				if (copyTextureAxis) {
					if (model.faceTextureAxis == null || model.faceTextureAxis[f] == -1) {
						this.faceTextureAxis[this.faceCount] = -1;
					} else {
						this.faceTextureAxis[this.faceCount] = (byte) (model.faceTextureAxis[f] + this.faceTextureCount);
					}
				}

				this.faceColour[this.faceCount] = model.faceColour[f];
				this.faceVertexA[this.faceCount] = this.addPoint(model, model.faceVertexA[f]);
				this.faceVertexB[this.faceCount] = this.addPoint(model, model.faceVertexB[f]);
				this.faceVertexC[this.faceCount] = this.addPoint(model, model.faceVertexC[f]);
				this.faceCount++;
			}

			for (int var14 = 0; var14 < model.faceTextureCount; var14++) {
				byte type = this.textureRenderType[this.faceTextureCount] = model.textureRenderType[var14];

				if (type == 0) {
					this.faceTextureP[this.faceTextureCount] = (short) this.addPoint(model, model.faceTextureP[var14]);
					this.faceTextureM[this.faceTextureCount] = (short) this.addPoint(model, model.faceTextureM[var14]);
					this.faceTextureN[this.faceTextureCount] = (short) this.addPoint(model, model.faceTextureN[var14]);
				}
				if (type >= 1 && type <= 3) {
					this.faceTextureP[this.faceTextureCount] = model.faceTextureP[var14];
					this.faceTextureM[this.faceTextureCount] = model.faceTextureM[var14];
					this.faceTextureN[this.faceTextureCount] = model.faceTextureN[var14];
					this.textureScaleX[this.faceTextureCount] = model.textureScaleX[var14];
					this.textureScaleY[this.faceTextureCount] = model.textureScaleY[var14];
					this.textureScaleZ[this.faceTextureCount] = model.textureScaleZ[var14];
					this.textureRotation[this.faceTextureCount] = model.textureRotation[var14];
					this.textureTranslation[this.faceTextureCount] = model.textureTranslation[var14];
					this.textureSpeed[this.faceTextureCount] = model.textureSpeed[var14];
				}
				if (type == 2) {
					this.textureDirection[this.faceTextureCount] = model.textureDirection[var14];
				}

				this.faceTextureCount++;
			}
		}
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::AddPoint
	@ObfuscatedName("fw.f(Lfw;I)I")
	public final int addPoint(ModelUnlit src, int vertex) {
		int index = -1;

		int x = src.vertexX[vertex];
		int y = src.vertexY[vertex];
		int z = src.vertexZ[vertex];

		for (int v = 0; v < this.vertexCount; v++) {
			if (this.vertexX[v] == x && this.vertexY[v] == y && this.vertexZ[v] == z) {
				index = v;
				break;
			}
		}

		if (index == -1) {
			this.vertexX[this.vertexCount] = x;
			this.vertexY[this.vertexCount] = y;
			this.vertexZ[this.vertexCount] = z;

			if (src.vertexLabel != null) {
				this.vertexLabel[this.vertexCount] = src.vertexLabel[vertex];
			}

			index = this.vertexCount++;
		}

		return index;
	}

	public ModelUnlit(ModelUnlit arg0, boolean arg1, boolean arg2, boolean arg3, boolean arg4) {
		this.vertexCount = arg0.vertexCount;
		this.faceCount = arg0.faceCount;
		this.faceTextureCount = arg0.faceTextureCount;
		if (arg1) {
			this.vertexX = arg0.vertexX;
			this.vertexY = arg0.vertexY;
			this.vertexZ = arg0.vertexZ;
		} else {
			this.vertexX = new int[this.vertexCount];
			this.vertexY = new int[this.vertexCount];
			this.vertexZ = new int[this.vertexCount];
			for (int var6 = 0; var6 < this.vertexCount; var6++) {
				this.vertexX[var6] = arg0.vertexX[var6];
				this.vertexY[var6] = arg0.vertexY[var6];
				this.vertexZ[var6] = arg0.vertexZ[var6];
			}
		}
		if (arg2) {
			this.faceColour = arg0.faceColour;
		} else {
			this.faceColour = new short[this.faceCount];
			for (int var7 = 0; var7 < this.faceCount; var7++) {
				this.faceColour[var7] = arg0.faceColour[var7];
			}
		}
		if (arg3 || arg0.faceTextureId == null) {
			this.faceTextureId = arg0.faceTextureId;
		} else {
			this.faceTextureId = new short[this.faceCount];
			for (int var8 = 0; var8 < this.faceCount; var8++) {
				this.faceTextureId[var8] = arg0.faceTextureId[var8];
			}
		}
		if (arg4) {
			this.faceAlpha = arg0.faceAlpha;
		} else {
			this.faceAlpha = new byte[this.faceCount];
			if (arg0.faceAlpha == null) {
				for (int var9 = 0; var9 < this.faceCount; var9++) {
					this.faceAlpha[var9] = 0;
				}
			} else {
				for (int var10 = 0; var10 < this.faceCount; var10++) {
					this.faceAlpha[var10] = arg0.faceAlpha[var10];
				}
			}
		}
		this.faceVertexA = arg0.faceVertexA;
		this.faceVertexB = arg0.faceVertexB;
		this.faceVertexC = arg0.faceVertexC;
		this.faceRenderType = arg0.faceRenderType;
		this.facePriority = arg0.facePriority;
		this.faceTextureAxis = arg0.faceTextureAxis;
		this.priority = arg0.priority;
		this.textureRenderType = arg0.textureRenderType;
		this.faceTextureP = arg0.faceTextureP;
		this.faceTextureM = arg0.faceTextureM;
		this.faceTextureN = arg0.faceTextureN;
		this.textureScaleX = arg0.textureScaleX;
		this.textureScaleY = arg0.textureScaleY;
		this.textureScaleZ = arg0.textureScaleZ;
		this.textureRotation = arg0.textureRotation;
		this.textureTranslation = arg0.textureTranslation;
		this.textureSpeed = arg0.textureSpeed;
		this.textureDirection = arg0.textureDirection;
		this.vertexLabel = arg0.vertexLabel;
		this.faceLabel = arg0.faceLabel;
		this.labelVertices = arg0.labelVertices;
		this.labelFaces = arg0.labelFaces;
		this.vertexNormal = arg0.vertexNormal;
		this.faceNormal = arg0.faceNormal;
		this.sharedVertexNormals = arg0.sharedVertexNormals;
		this.ambient = arg0.ambient;
		this.contrast = arg0.contrast;
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::CopyForShareLight
	@ObfuscatedName("fw.k()Lfw;")
	public ModelUnlit copyForShareLight() {
		ModelUnlit copy = new ModelUnlit();

		if (this.faceRenderType != null) {
			copy.faceRenderType = new byte[this.faceCount];

			for (int f = 0; f < this.faceCount; f++) {
				copy.faceRenderType[f] = this.faceRenderType[f];
			}
		}

		copy.vertexCount = this.vertexCount;
		copy.faceCount = this.faceCount;
		copy.faceTextureCount = this.faceTextureCount;

		copy.vertexX = this.vertexX;
		copy.vertexY = this.vertexY;
		copy.vertexZ = this.vertexZ;

		copy.faceVertexA = this.faceVertexA;
		copy.faceVertexB = this.faceVertexB;
		copy.faceVertexC = this.faceVertexC;

		copy.facePriority = this.facePriority;
		copy.faceAlpha = this.faceAlpha;
		copy.faceTextureAxis = this.faceTextureAxis;
		copy.faceColour = this.faceColour;
		copy.faceTextureId = this.faceTextureId;
		copy.priority = this.priority;

		copy.textureRenderType = this.textureRenderType;
		copy.faceTextureP = this.faceTextureP;
		copy.faceTextureM = this.faceTextureM;
		copy.faceTextureN = this.faceTextureN;
		copy.textureScaleX = this.textureScaleX;
		copy.textureScaleY = this.textureScaleY;
		copy.textureScaleZ = this.textureScaleZ;
		copy.textureRotation = this.textureRotation;
		copy.textureTranslation = this.textureTranslation;
		copy.textureSpeed = this.textureSpeed;
		copy.textureDirection = this.textureDirection;

		copy.vertexLabel = this.vertexLabel;
		copy.faceLabel = this.faceLabel;
		copy.labelVertices = this.labelVertices;
		copy.labelFaces = this.labelFaces;

		copy.vertexNormal = this.vertexNormal;
		copy.faceNormal = this.faceNormal;

		copy.ambient = this.ambient;
		copy.contrast = this.contrast;

		return copy;
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::HillSkew
	@ObfuscatedName("fw.o([[IIIIZI)Lfw;")
	public ModelUnlit hillSkew(int[][] groundh, int x, int y, int z, boolean copy, int blend) {
		this.calcBoundingCube();

		int var7 = this.minX + x;
		int var8 = this.maxX + x;
		int var9 = this.maxZ + z;
		int var10 = this.minZ + z;

		if (var7 < 0 || var8 + 128 >> 7 >= groundh.length || var9 < 0 || var10 + 128 >> 7 >= groundh[0].length) {
			return this;
		}

		int var11 = var7 >> 7;
		int var12 = var8 + 127 >> 7;
		int var13 = var9 >> 7;
		int var14 = var10 + 127 >> 7;

		if (groundh[var11][var13] == y && groundh[var12][var13] == y && groundh[var11][var14] == y && groundh[var12][var14] == y) {
			return this;
		}

		ModelUnlit model;
		if (copy) {
			model = new ModelUnlit();
			model.vertexCount = this.vertexCount;
			model.faceCount = this.faceCount;
			model.faceTextureCount = this.faceTextureCount;
			model.vertexX = this.vertexX;
			model.vertexZ = this.vertexZ;
			model.faceVertexA = this.faceVertexA;
			model.faceVertexB = this.faceVertexB;
			model.faceVertexC = this.faceVertexC;
			model.faceRenderType = this.faceRenderType;
			model.facePriority = this.facePriority;
			model.faceAlpha = this.faceAlpha;
			model.faceTextureAxis = this.faceTextureAxis;
			model.faceColour = this.faceColour;
			model.faceTextureId = this.faceTextureId;
			model.priority = this.priority;
			model.textureRenderType = this.textureRenderType;
			model.faceTextureP = this.faceTextureP;
			model.faceTextureM = this.faceTextureM;
			model.faceTextureN = this.faceTextureN;
			model.textureScaleX = this.textureScaleX;
			model.textureScaleY = this.textureScaleY;
			model.textureScaleZ = this.textureScaleZ;
			model.textureRotation = this.textureRotation;
			model.textureTranslation = this.textureTranslation;
			model.textureSpeed = this.textureSpeed;
			model.textureDirection = this.textureDirection;
			model.vertexLabel = this.vertexLabel;
			model.faceLabel = this.faceLabel;
			model.labelVertices = this.labelVertices;
			model.labelFaces = this.labelFaces;
			model.ambient = this.ambient;
			model.contrast = this.contrast;
			model.vertexY = new int[model.vertexCount];
		} else {
			model = this;
		}

		if (blend == 0) {
			for (int var16 = 0; var16 < model.vertexCount; var16++) {
				int var17 = this.vertexX[var16] + x;
				int var18 = this.vertexZ[var16] + z;
				int var19 = var17 & 0x7F;
				int var20 = var18 & 0x7F;
				int var21 = var17 >> 7;
				int var22 = var18 >> 7;
				int var23 = (128 - var19) * groundh[var21][var22] + groundh[var21 + 1][var22] * var19 >> 7;
				int var24 = (128 - var19) * groundh[var21][var22 + 1] + groundh[var21 + 1][var22 + 1] * var19 >> 7;
				int var25 = (128 - var20) * var23 + var20 * var24 >> 7;
				model.vertexY[var16] = this.vertexY[var16] + var25 - y;
			}
		} else {
			for (int var26 = 0; var26 < model.vertexCount; var26++) {
				int var27 = (-this.vertexY[var26] << 16) / this.minY;
				if (var27 < blend) {
					int var28 = this.vertexX[var26] + x;
					int var29 = this.vertexZ[var26] + z;
					int var30 = var28 & 0x7F;
					int var31 = var29 & 0x7F;
					int var32 = var28 >> 7;
					int var33 = var29 >> 7;
					int var34 = (128 - var30) * groundh[var32][var33] + groundh[var32 + 1][var33] * var30 >> 7;
					int var35 = (128 - var30) * groundh[var32][var33 + 1] + groundh[var32 + 1][var33 + 1] * var30 >> 7;
					int var36 = (128 - var31) * var34 + var31 * var35 >> 7;
					model.vertexY[var26] = (var36 - y) * (blend - var27) / blend + this.vertexY[var26];
				}
			}
		}

		model.geometryChanged();
		return model;
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::PrepareAnim
	@ObfuscatedName("fw.a()V")
	public void prepareAnim() {
		if (this.vertexLabel != null) {
			int[] var1 = new int[256];
			int var2 = 0;
			for (int var3 = 0; var3 < this.vertexCount; var3++) {
				int var4 = this.vertexLabel[var3];
				var1[var4]++;
				if (var4 > var2) {
					var2 = var4;
				}
			}
			this.labelVertices = new int[var2 + 1][];
			for (int var5 = 0; var5 <= var2; var5++) {
				this.labelVertices[var5] = new int[var1[var5]];
				var1[var5] = 0;
			}
			int var6 = 0;
			while (var6 < this.vertexCount) {
				int var7 = this.vertexLabel[var6];
				this.labelVertices[var7][var1[var7]++] = var6++;
			}
			this.vertexLabel = null;
		}

		if (this.faceLabel != null) {
			int[] var8 = new int[256];
			int var9 = 0;
			for (int var10 = 0; var10 < this.faceCount; var10++) {
				int var11 = this.faceLabel[var10];
				var8[var11]++;
				if (var11 > var9) {
					var9 = var11;
				}
			}
			this.labelFaces = new int[var9 + 1][];
			for (int var12 = 0; var12 <= var9; var12++) {
				this.labelFaces[var12] = new int[var8[var12]];
				var8[var12] = 0;
			}
			int var13 = 0;
			while (var13 < this.faceCount) {
				int var14 = this.faceLabel[var13];
				this.labelFaces[var14][var8[var14]++] = var13++;
			}
			this.faceLabel = null;
		}
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::Rotate90
	@ObfuscatedName("fw.h()V")
	public void rotate90() {
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			int var2 = this.vertexX[var1];
			this.vertexX[var1] = this.vertexZ[var1];
			this.vertexZ[var1] = -var2;
		}
		this.geometryChanged();
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::Rotate180
	@ObfuscatedName("fw.x()V")
	public void rotate180() {
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			this.vertexX[var1] = -this.vertexX[var1];
			this.vertexZ[var1] = -this.vertexZ[var1];
		}
		this.geometryChanged();
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::Rotate270
	@ObfuscatedName("fw.p()V")
	public void rotate270() {
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			int var2 = this.vertexZ[var1];
			this.vertexZ[var1] = this.vertexX[var1];
			this.vertexX[var1] = -var2;
		}
		this.geometryChanged();
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::RotateXAxis
	@ObfuscatedName("fw.ad(I)V")
	public void rotateXAxis(int arg0) {
		int var2 = sinTable[arg0];
		int var3 = cosTable[arg0];
		for (int var4 = 0; var4 < this.vertexCount; var4++) {
			int var5 = this.vertexZ[var4] * var2 + this.vertexX[var4] * var3 >> 16;
			this.vertexZ[var4] = this.vertexZ[var4] * var3 - this.vertexX[var4] * var2 >> 16;
			this.vertexX[var4] = var5;
		}
		this.geometryChanged();
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::Translate
	@ObfuscatedName("fw.ac(III)V")
	public void translate(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < this.vertexCount; var4++) {
			this.vertexX[var4] += arg0;
			this.vertexY[var4] += arg1;
			this.vertexZ[var4] += arg2;
		}
		this.geometryChanged();
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::Recolour
	@ObfuscatedName("fw.aa(SS)V")
	public void recolour(short arg0, short arg1) {
		for (int var3 = 0; var3 < this.faceCount; var3++) {
			if (this.faceColour[var3] == arg0) {
				this.faceColour[var3] = arg1;
			}
		}
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::Retexture
	@ObfuscatedName("fw.as(SS)V")
	public void retexture(short arg0, short arg1) {
		if (this.faceTextureId == null) {
			return;
		}
		for (int var3 = 0; var3 < this.faceCount; var3++) {
			if (this.faceTextureId[var3] == arg0) {
				this.faceTextureId[var3] = arg1;
			}
		}
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::Mirror
	@ObfuscatedName("fw.am()V")
	public void mirror() {
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			this.vertexZ[var1] = -this.vertexZ[var1];
		}
		for (int var2 = 0; var2 < this.faceCount; var2++) {
			int var3 = this.faceVertexA[var2];
			this.faceVertexA[var2] = this.faceVertexC[var2];
			this.faceVertexC[var2] = var3;
		}
		this.geometryChanged();
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::Resize
	@ObfuscatedName("fw.ap(III)V")
	public void resize(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < this.vertexCount; var4++) {
			this.vertexX[var4] = this.vertexX[var4] * arg0 / 128;
			this.vertexY[var4] = this.vertexY[var4] * arg1 / 128;
			this.vertexZ[var4] = this.vertexZ[var4] * arg2 / 128;
		}
		this.geometryChanged();
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::CalculateNormals
	@ObfuscatedName("fw.av()V")
	public void calculateNormals() {
		if (this.vertexNormal != null) {
			return;
		}

		this.vertexNormal = new PointNormal[this.vertexCount];
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			this.vertexNormal[var1] = new PointNormal();
		}

		for (int f = 0; f < this.faceCount; f++) {
			int a = this.faceVertexA[f];
			int b = this.faceVertexB[f];
			int c = this.faceVertexC[f];

			int dxAB = this.vertexX[b] - this.vertexX[a];
			int dyAB = this.vertexY[b] - this.vertexY[a];
			int dzAB = this.vertexZ[b] - this.vertexZ[a];

			int dxAC = this.vertexX[c] - this.vertexX[a];
			int dyAC = this.vertexY[c] - this.vertexY[a];
			int dzAC = this.vertexZ[c] - this.vertexZ[a];

			int nx = dyAB * dzAC - dzAB * dyAC;
			int ny = dzAB * dxAC - dxAB * dzAC;
			int nz;
			for (nz = dxAB * dyAC - dyAB * dxAC; nx > 8192 || ny > 8192 || nz > 8192 || nx < -8192 || ny < -8192 || nz < -8192; nz >>= 0x1) {
				nx >>= 0x1;
				ny >>= 0x1;
			}

			int length = (int) Math.sqrt(nz * nz + nx * nx + ny * ny);
			if (length <= 0) {
				length = 1;
			}

			int var16 = nx * 256 / length;
			int var17 = ny * 256 / length;
			int var18 = nz * 256 / length;

			byte type;
			if (this.faceRenderType == null) {
				type = 0;
			} else {
				type = this.faceRenderType[f];
			}

			if (type == 0) {
				PointNormal n = this.vertexNormal[a];
				n.x += var16;
				n.y += var17;
				n.z += var18;
				n.w++;

				n = this.vertexNormal[b];
				n.x += var16;
				n.y += var17;
				n.z += var18;
				n.w++;

				n = this.vertexNormal[c];
				n.x += var16;
				n.y += var17;
				n.z += var18;
				n.w++;
			} else if (type == 1) {
				if (this.faceNormal == null) {
					this.faceNormal = new FaceNormal[this.faceCount];
				}

				FaceNormal n = this.faceNormal[f] = new FaceNormal();
				n.x = var16;
				n.y = var17;
				n.z = var18;
			}
		}
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::GeometryChanged
	@ObfuscatedName("fw.ak()V")
	public void geometryChanged() {
		this.vertexNormal = null;
		this.sharedVertexNormals = null;
		this.faceNormal = null;
		this.boundsCalculated = false;
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::CalcBoundingCube
	@ObfuscatedName("fw.az()V")
	public void calcBoundingCube() {
		if (this.boundsCalculated) {
			return;
		}

		this.minY = 0;
		this.maxY = 0;
		this.minX = 999999;
		this.maxX = -999999;
		this.minZ = -99999;
		this.maxZ = 99999;

		for (int v = 0; v < this.vertexCount; v++) {
			int x = this.vertexX[v];
			int y = this.vertexY[v];
			int z = this.vertexZ[v];

			if (x < this.minX) {
				this.minX = x;
			}

			if (x > this.maxX) {
				this.maxX = x;
			}

			if (z < this.maxZ) {
				this.maxZ = z;
			}

			if (z > this.minZ) {
				this.minZ = z;
			}

			if (-y > this.minY) {
				this.minY = -y;
			}

			if (y > this.maxY) {
				this.maxY = y;
			}
		}

		this.boundsCalculated = true;
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::ShareLight
	@ObfuscatedName("fw.an(Lfw;Lfw;IIIZ)V")
	public static void shareLight(ModelUnlit model1, ModelUnlit model2, int arg2, int arg3, int arg4, boolean arg5) {
		model1.calcBoundingCube();
		model1.calculateNormals();
		model2.calcBoundingCube();
		model2.calculateNormals();

		shareTic++;

		int var6 = 0;
		int[] var7 = model2.vertexX;
		int var8 = model2.vertexCount;
		for (int var9 = 0; var9 < model1.vertexCount; var9++) {
			PointNormal var10 = model1.vertexNormal[var9];
			if (var10.w == 0) {
				continue;
			}

			int var11 = model1.vertexY[var9] - arg3;
			if (var11 <= model2.maxY) {
				int var12 = model1.vertexX[var9] - arg2;
				if (var12 < model2.minX || var12 > model2.maxX) {
					continue;
				}

				int var13 = model1.vertexZ[var9] - arg4;
				if (var13 < model2.maxZ || var13 > model2.minZ) {
					continue;
				}

				for (int var14 = 0; var14 < var8; var14++) {
					PointNormal var15 = model2.vertexNormal[var14];
					if (var7[var14] != var12 || model2.vertexZ[var14] != var13 || model2.vertexY[var14] != var11 || var15.w == 0) {
						continue;
					}

					if (model1.sharedVertexNormals == null) {
						model1.sharedVertexNormals = new PointNormal[model1.vertexCount];
					}

					if (model2.sharedVertexNormals == null) {
						model2.sharedVertexNormals = new PointNormal[var8];
					}

					PointNormal var16 = model1.sharedVertexNormals[var9];
					if (var16 == null) {
						var16 = model1.sharedVertexNormals[var9] = new PointNormal(var10);
					}

					PointNormal var17 = model2.sharedVertexNormals[var14];
					if (var17 == null) {
						var17 = model2.sharedVertexNormals[var14] = new PointNormal(var15);
					}

					var16.x += var15.x;
					var16.y += var15.y;
					var16.z += var15.z;
					var16.w += var15.w;

					var17.x += var10.x;
					var17.y += var10.y;
					var17.z += var10.z;
					var17.w += var10.w;

					var6++;

					shareTickA[var9] = shareTic;
					shareTickB[var14] = shareTic;
				}
			}
		}

		if (var6 >= 3 && arg5) {
			for (int var18 = 0; var18 < model1.faceCount; var18++) {
				if (shareTickA[model1.faceVertexA[var18]] == shareTic && shareTickA[model1.faceVertexB[var18]] == shareTic && shareTickA[model1.faceVertexC[var18]] == shareTic) {
					if (model1.faceRenderType == null) {
						model1.faceRenderType = new byte[model1.faceCount];
					}
					model1.faceRenderType[var18] = 2;
				}
			}

			for (int var19 = 0; var19 < model2.faceCount; var19++) {
				if (shareTickB[model2.faceVertexA[var19]] == shareTic && shareTickB[model2.faceVertexB[var19]] == shareTic && shareTickB[model2.faceVertexC[var19]] == shareTic) {
					if (model2.faceRenderType == null) {
						model2.faceRenderType = new byte[model2.faceCount];
					}
					model2.faceRenderType[var19] = 2;
				}
			}
		}
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::Light
	@ObfuscatedName("fw.ah(IIIII)Lfo;")
	public final ModelLit light(int ambient, int contrast, int x, int y, int z) {
		this.calculateNormals();

		int distance = (int) Math.sqrt(z * z + x * x + y * y);
		int scale = contrast * distance >> 8;

		ModelLit lit = new ModelLit();
		lit.faceColourA = new int[this.faceCount];
		lit.faceColourB = new int[this.faceCount];
		lit.faceColourC = new int[this.faceCount];

		if (this.faceTextureCount > 0 && this.faceTextureAxis != null) {
			int[] axis = new int[this.faceTextureCount];
			for (int f = 0; f < this.faceCount; f++) {
				if (this.faceTextureAxis[f] != -1) {
					axis[this.faceTextureAxis[f] & 0xFF]++;
				}
			}

			lit.faceTextureCount = 0;
			for (int f = 0; f < this.faceTextureCount; f++) {
				if (axis[f] > 0 && this.textureRenderType[f] == 0) {
					lit.faceTextureCount++;
				}
			}

			lit.faceTextureP = new int[lit.faceTextureCount];
			lit.faceTextureM = new int[lit.faceTextureCount];
			lit.faceTextureN = new int[lit.faceTextureCount];

			int textureCount = 0;
			for (int f = 0; f < this.faceTextureCount; f++) {
				if (axis[f] > 0 && this.textureRenderType[f] == 0) {
					lit.faceTextureP[textureCount] = this.faceTextureP[f] & 0xFFFF;
					lit.faceTextureM[textureCount] = this.faceTextureM[f] & 0xFFFF;
					lit.faceTextureN[textureCount] = this.faceTextureN[f] & 0xFFFF;
					axis[f] = textureCount++;
				} else {
					axis[f] = -1;
				}
			}

			lit.faceTextureAxis = new byte[this.faceCount];
			for (int f = 0; f < this.faceCount; f++) {
				if (this.faceTextureAxis[f] == -1) {
					lit.faceTextureAxis[f] = -1;
				} else {
					lit.faceTextureAxis[f] = (byte) axis[this.faceTextureAxis[f] & 0xFF];
				}
			}
		}

		for (int f = 0; f < this.faceCount; f++) {
			byte type;
			if (this.faceRenderType == null) {
				type = 0;
			} else {
				type = this.faceRenderType[f];
			}

			byte alpha;
			if (this.faceAlpha == null) {
				alpha = 0;
			} else {
				alpha = this.faceAlpha[f];
			}

			short textureId;
			if (this.faceTextureId == null) {
				textureId = -1;
			} else {
				textureId = this.faceTextureId[f];
			}

			if (alpha == -2) {
				type = 3;
			}

			if (alpha == -1) {
				type = 2;
			}

			if (textureId == -1) {
				if (type == 0) {
					int colour = this.faceColour[f] & 0xFFFF;

					PointNormal normalA;
					if (this.sharedVertexNormals == null || this.sharedVertexNormals[this.faceVertexA[f]] == null) {
						normalA = this.vertexNormal[this.faceVertexA[f]];
					} else {
						normalA = this.sharedVertexNormals[this.faceVertexA[f]];
					}
					int intensityA = (normalA.z * z + normalA.x * x + normalA.y * y) / (normalA.w * scale) + ambient;
					lit.faceColourA[f] = getColour(colour, intensityA);

					PointNormal normalB;
					if (this.sharedVertexNormals == null || this.sharedVertexNormals[this.faceVertexB[f]] == null) {
						normalB = this.vertexNormal[this.faceVertexB[f]];
					} else {
						normalB = this.sharedVertexNormals[this.faceVertexB[f]];
					}
					int intensityB = (normalB.z * z + normalB.x * x + normalB.y * y) / (normalB.w * scale) + ambient;
					lit.faceColourB[f] = getColour(colour, intensityB);

					PointNormal normalC;
					if (this.sharedVertexNormals == null || this.sharedVertexNormals[this.faceVertexC[f]] == null) {
						normalC = this.vertexNormal[this.faceVertexC[f]];
					} else {
						normalC = this.sharedVertexNormals[this.faceVertexC[f]];
					}
					int intensityC = (normalC.z * z + normalC.x * x + normalC.y * y) / (normalC.w * scale) + ambient;
					lit.faceColourC[f] = getColour(colour, intensityC);
				} else if (type == 1) {
					FaceNormal normal = this.faceNormal[f];
					int intensity = (normal.z * z + normal.x * x + normal.y * y) / (scale / 2 + scale) + ambient;
					lit.faceColourA[f] = getColour(this.faceColour[f] & 0xFFFF, intensity);
					lit.faceColourC[f] = -1;
				} else if (type == 3) {
					lit.faceColourA[f] = 128;
					lit.faceColourC[f] = -1;
				} else {
					lit.faceColourC[f] = -2;
				}
			} else if (type == 0) {
				PointNormal normalA;
				if (this.sharedVertexNormals == null || this.sharedVertexNormals[this.faceVertexA[f]] == null) {
					normalA = this.vertexNormal[this.faceVertexA[f]];
				} else {
					normalA = this.sharedVertexNormals[this.faceVertexA[f]];
				}
				int intensityA = (normalA.z * z + normalA.x * x + normalA.y * y) / (normalA.w * scale) + ambient;
				lit.faceColourA[f] = getTexLight(intensityA);

				PointNormal normalB;
				if (this.sharedVertexNormals == null || this.sharedVertexNormals[this.faceVertexB[f]] == null) {
					normalB = this.vertexNormal[this.faceVertexB[f]];
				} else {
					normalB = this.sharedVertexNormals[this.faceVertexB[f]];
				}
				int intensityB = (normalB.z * z + normalB.x * x + normalB.y * y) / (normalB.w * scale) + ambient;
				lit.faceColourB[f] = getTexLight(intensityB);

				PointNormal normalC;
				if (this.sharedVertexNormals == null || this.sharedVertexNormals[this.faceVertexC[f]] == null) {
					normalC = this.vertexNormal[this.faceVertexC[f]];
				} else {
					normalC = this.sharedVertexNormals[this.faceVertexC[f]];
				}
				int intensityC = (normalC.z * z + normalC.x * x + normalC.y * y) / (normalC.w * scale) + ambient;
				lit.faceColourC[f] = getTexLight(intensityC);
			} else if (type == 1) {
				FaceNormal normal = this.faceNormal[f];
				int intensity = (normal.z * z + normal.x * x + normal.y * y) / (scale / 2 + scale) + ambient;
				lit.faceColourA[f] = getTexLight(intensity);
				lit.faceColourC[f] = -1;
			} else {
				lit.faceColourC[f] = -2;
			}
		}

		this.prepareAnim();

		lit.vertexCount = this.vertexCount;
		lit.vertexX = this.vertexX;
		lit.vertexY = this.vertexY;
		lit.vertexZ = this.vertexZ;

		lit.faceCount = this.faceCount;
		lit.faceVertexA = this.faceVertexA;
		lit.faceVertexB = this.faceVertexB;
		lit.faceVertexC = this.faceVertexC;
		lit.facePriority = this.facePriority;
		lit.faceAlpha = this.faceAlpha;
		lit.priority = this.priority;

		lit.labelVertices = this.labelVertices;
		lit.labelFaces = this.labelFaces;

		lit.faceTextureId = this.faceTextureId;

		return lit;
	}

	// jag::oldscape::dash3d::ModelUnlit::GetColour
	@ObfuscatedName("fw.ay(II)I")
	public static int getColour(int arg0, int arg1) {
		int var2 = (arg0 & 0x7F) * arg1 >> 7;
		if (var2 < 2) {
			var2 = 2;
		} else if (var2 > 126) {
			var2 = 126;
		}
		return (arg0 & 0xFF80) + var2;
	}

	// jag::oldscape::dash3d::ModelUnlit::GetTexLight
	@ObfuscatedName("fw.al(I)I")
	public static int getTexLight(int arg0) {
		if (arg0 < 2) {
			arg0 = 2;
		} else if (arg0 > 126) {
			arg0 = 126;
		}
		return arg0;
	}
}
