package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.io.Packet;
import jagex3.js5.Js5;

@ObfuscatedName("fw")
public class ModelUnlit extends ModelSource {

	// jag::oldscape::dash3d::ModelLit::m_numPoints
	@ObfuscatedName("fw.j")
	public int numPoints = 0;

	// jag::oldscape::dash3d::ModelLit::m_pointX
	@ObfuscatedName("fw.z")
	public int[] pointX;

	// jag::oldscape::dash3d::ModelLit::m_pointY
	@ObfuscatedName("fw.g")
	public int[] pointY;

	// jag::oldscape::dash3d::ModelLit::m_pointZ
	@ObfuscatedName("fw.q")
	public int[] pointZ;

	// jag::oldscape::dash3d::ModelLit::m_numFaces
	@ObfuscatedName("fw.i")
	public int numFaces = 0;

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

	// jag::oldscape::dash3d::ModelLit::m_numT
	@ObfuscatedName("fw.o")
	public int numT;

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
	public PointNormal[] pointNormal;

	@ObfuscatedName("fw.ab")
	public PointNormal[] sharedPointNormal;

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

	// jag::oldscape::dash3d::ModelUnlitImpl::m_shareMap
	@ObfuscatedName("fw.ai")
	public static int[] shareMap = new int[10000];

	// jag::oldscape::dash3d::ModelUnlitImpl::m_shareMap2
	@ObfuscatedName("fw.aj")
	public static int[] shareMap2 = new int[10000];

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

		this.numPoints = var9;
		this.numFaces = var10;
		this.numT = var11;
		this.pointX = new int[var9];
		this.pointY = new int[var9];
		this.pointZ = new int[var9];
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

			this.pointX[var67] = var64 + var69;
			this.pointY[var67] = var65 + var70;
			this.pointZ[var67] = var66 + var71;

			var64 = this.pointX[var67];
			var65 = this.pointY[var67];
			var66 = this.pointZ[var67];

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

		int numPoints = trailer.g2();
		int numFaces = trailer.g2();
		int numT = trailer.g1();

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
		pos += numPoints;

		int faceIndexOrderOffset = pos;
		pos += numFaces;

		int facePriorityOffset = pos;
		if (priority == 255) {
			pos += numFaces;
		}

		int faceLabelOffset = pos;
		if (hasFaceLabels == 1) {
			pos += numFaces;
		}

		int faceInfoOffset = pos;
		if (hasFaceInfo == 1) {
			pos += numFaces;
		}

		int vertexLabelOffset = pos;
		if (hasVertexLabels == 1) {
			pos += numPoints;
		}

		int faceAlphaOffset = pos;
		if (hasFaceAlpha == 1) {
			pos += numFaces;
		}

		int faceIndexOffset = pos;
		pos += dataLengthFaceIndex;

		int faceColourOffset = pos;
		pos += numFaces * 2;

		int faceTextureAxisOffset = pos;
		pos += numT * 6;

		int vertexXOffset = pos;
		pos += dataLengthX;

		int vertexYOffset = pos;
		pos += dataLengthY;

		int vertexZOffset = pos;
		pos += dataLengthZ;

		this.numPoints = numPoints;
		this.numFaces = numFaces;
		this.numT = numT;

		this.pointX = new int[numPoints];
		this.pointY = new int[numPoints];
		this.pointZ = new int[numPoints];

		this.faceVertexA = new int[numFaces];
		this.faceVertexB = new int[numFaces];
		this.faceVertexC = new int[numFaces];

		if (numT > 0) {
			this.textureRenderType = new byte[numT];
			this.faceTextureP = new short[numT];
			this.faceTextureM = new short[numT];
			this.faceTextureN = new short[numT];
		}

		if (hasVertexLabels == 1) {
			this.vertexLabel = new int[numPoints];
		}

		if (hasFaceInfo == 1) {
			this.faceRenderType = new byte[numFaces];
			this.faceTextureAxis = new byte[numFaces];
			this.faceTextureId = new short[numFaces];
		}

		if (priority == 255) {
			this.facePriority = new byte[numFaces];
		} else {
			this.priority = (byte) priority;
		}

		if (hasFaceAlpha == 1) {
			this.faceAlpha = new byte[numFaces];
		}

		if (hasFaceLabels == 1) {
			this.faceLabel = new int[numFaces];
		}

		this.faceColour = new short[numFaces];

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
		for (int v = 0; v < numPoints; v++) {
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

			this.pointX[v] = dx + x;
			this.pointY[v] = dy + y;
			this.pointZ[v] = dz + z;

			dx = this.pointX[v];
			dy = this.pointY[v];
			dz = this.pointZ[v];

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

		for (int f = 0; f < numFaces; f++) {
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
		for (int f = 0; f < numFaces; f++) {
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

		for (int f = 0; f < numT; f++) {
			this.textureRenderType[f] = 0;
			this.faceTextureP[f] = (short) axis.g2();
			this.faceTextureM[f] = (short) axis.g2();
			this.faceTextureN[f] = (short) axis.g2();
		}

		if (this.faceTextureAxis != null) {
			boolean hasTexture = false;
			for (int var64 = 0; var64 < numFaces; var64++) {
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

		this.numPoints = 0;
		this.numFaces = 0;
		this.numT = 0;
		this.priority = -1;

		for (int var9 = 0; var9 < count; var9++) {
			ModelUnlit model = models[var9];
			if (model != null) {
				this.numPoints += model.numPoints;
				this.numFaces += model.numFaces;
				this.numT += model.numT;

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

		this.pointX = new int[this.numPoints];
		this.pointY = new int[this.numPoints];
		this.pointZ = new int[this.numPoints];

		this.vertexLabel = new int[this.numPoints];

		this.faceVertexA = new int[this.numFaces];
		this.faceVertexB = new int[this.numFaces];
		this.faceVertexC = new int[this.numFaces];

		if (copyRenderType) {
			this.faceRenderType = new byte[this.numFaces];
		}

		if (copyPriority) {
			this.facePriority = new byte[this.numFaces];
		}

		if (copyAlpha) {
			this.faceAlpha = new byte[this.numFaces];
		}

		if (copyLabel) {
			this.faceLabel = new int[this.numFaces];
		}

		if (copyTextureId) {
			this.faceTextureId = new short[this.numFaces];
		}

		if (copyTextureAxis) {
			this.faceTextureAxis = new byte[this.numFaces];
		}

		this.faceColour = new short[this.numFaces];

		if (this.numT > 0) {
			this.textureRenderType = new byte[this.numT];
			this.faceTextureP = new short[this.numT];
			this.faceTextureM = new short[this.numT];
			this.faceTextureN = new short[this.numT];
			this.textureScaleX = new short[this.numT];
			this.textureScaleY = new short[this.numT];
			this.textureScaleZ = new short[this.numT];
			this.textureRotation = new short[this.numT];
			this.textureTranslation = new byte[this.numT];
			this.textureSpeed = new short[this.numT];
			this.textureDirection = new short[this.numT];
		}

		this.numPoints = 0;
		this.numFaces = 0;
		this.numT = 0;

		for (int i = 0; i < count; i++) {
			ModelUnlit model = models[i];
			if (model == null) {
				continue;
			}

			for (int f = 0; f < model.numFaces; f++) {
				if (copyRenderType && model.faceRenderType != null) {
					this.faceRenderType[this.numFaces] = model.faceRenderType[f];
				}

				if (copyPriority) {
					if (model.facePriority == null) {
						this.facePriority[this.numFaces] = model.priority;
					} else {
						this.facePriority[this.numFaces] = model.facePriority[f];
					}
				}

				if (copyAlpha && model.faceAlpha != null) {
					this.faceAlpha[this.numFaces] = model.faceAlpha[f];
				}

				if (copyLabel && model.faceLabel != null) {
					this.faceLabel[this.numFaces] = model.faceLabel[f];
				}

				if (copyTextureId) {
					if (model.faceTextureId == null) {
						this.faceTextureId[this.numFaces] = -1;
					} else {
						this.faceTextureId[this.numFaces] = model.faceTextureId[f];
					}
				}

				if (copyTextureAxis) {
					if (model.faceTextureAxis == null || model.faceTextureAxis[f] == -1) {
						this.faceTextureAxis[this.numFaces] = -1;
					} else {
						this.faceTextureAxis[this.numFaces] = (byte) (model.faceTextureAxis[f] + this.numT);
					}
				}

				this.faceColour[this.numFaces] = model.faceColour[f];
				this.faceVertexA[this.numFaces] = this.addPoint(model, model.faceVertexA[f]);
				this.faceVertexB[this.numFaces] = this.addPoint(model, model.faceVertexB[f]);
				this.faceVertexC[this.numFaces] = this.addPoint(model, model.faceVertexC[f]);
				this.numFaces++;
			}

			for (int var14 = 0; var14 < model.numT; var14++) {
				byte type = this.textureRenderType[this.numT] = model.textureRenderType[var14];

				if (type == 0) {
					this.faceTextureP[this.numT] = (short) this.addPoint(model, model.faceTextureP[var14]);
					this.faceTextureM[this.numT] = (short) this.addPoint(model, model.faceTextureM[var14]);
					this.faceTextureN[this.numT] = (short) this.addPoint(model, model.faceTextureN[var14]);
				}
				if (type >= 1 && type <= 3) {
					this.faceTextureP[this.numT] = model.faceTextureP[var14];
					this.faceTextureM[this.numT] = model.faceTextureM[var14];
					this.faceTextureN[this.numT] = model.faceTextureN[var14];
					this.textureScaleX[this.numT] = model.textureScaleX[var14];
					this.textureScaleY[this.numT] = model.textureScaleY[var14];
					this.textureScaleZ[this.numT] = model.textureScaleZ[var14];
					this.textureRotation[this.numT] = model.textureRotation[var14];
					this.textureTranslation[this.numT] = model.textureTranslation[var14];
					this.textureSpeed[this.numT] = model.textureSpeed[var14];
				}
				if (type == 2) {
					this.textureDirection[this.numT] = model.textureDirection[var14];
				}

				this.numT++;
			}
		}
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::AddPoint
	@ObfuscatedName("fw.f(Lfw;I)I")
	public final int addPoint(ModelUnlit src, int vertex) {
		int index = -1;

		int x = src.pointX[vertex];
		int y = src.pointY[vertex];
		int z = src.pointZ[vertex];

		for (int v = 0; v < this.numPoints; v++) {
			if (this.pointX[v] == x && this.pointY[v] == y && this.pointZ[v] == z) {
				index = v;
				break;
			}
		}

		if (index == -1) {
			this.pointX[this.numPoints] = x;
			this.pointY[this.numPoints] = y;
			this.pointZ[this.numPoints] = z;

			if (src.vertexLabel != null) {
				this.vertexLabel[this.numPoints] = src.vertexLabel[vertex];
			}

			index = this.numPoints++;
		}

		return index;
	}

	public ModelUnlit(ModelUnlit arg0, boolean arg1, boolean arg2, boolean arg3, boolean arg4) {
		this.numPoints = arg0.numPoints;
		this.numFaces = arg0.numFaces;
		this.numT = arg0.numT;
		if (arg1) {
			this.pointX = arg0.pointX;
			this.pointY = arg0.pointY;
			this.pointZ = arg0.pointZ;
		} else {
			this.pointX = new int[this.numPoints];
			this.pointY = new int[this.numPoints];
			this.pointZ = new int[this.numPoints];
			for (int var6 = 0; var6 < this.numPoints; var6++) {
				this.pointX[var6] = arg0.pointX[var6];
				this.pointY[var6] = arg0.pointY[var6];
				this.pointZ[var6] = arg0.pointZ[var6];
			}
		}
		if (arg2) {
			this.faceColour = arg0.faceColour;
		} else {
			this.faceColour = new short[this.numFaces];
			for (int var7 = 0; var7 < this.numFaces; var7++) {
				this.faceColour[var7] = arg0.faceColour[var7];
			}
		}
		if (arg3 || arg0.faceTextureId == null) {
			this.faceTextureId = arg0.faceTextureId;
		} else {
			this.faceTextureId = new short[this.numFaces];
			for (int var8 = 0; var8 < this.numFaces; var8++) {
				this.faceTextureId[var8] = arg0.faceTextureId[var8];
			}
		}
		if (arg4) {
			this.faceAlpha = arg0.faceAlpha;
		} else {
			this.faceAlpha = new byte[this.numFaces];
			if (arg0.faceAlpha == null) {
				for (int var9 = 0; var9 < this.numFaces; var9++) {
					this.faceAlpha[var9] = 0;
				}
			} else {
				for (int var10 = 0; var10 < this.numFaces; var10++) {
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
		this.pointNormal = arg0.pointNormal;
		this.faceNormal = arg0.faceNormal;
		this.sharedPointNormal = arg0.sharedPointNormal;
		this.ambient = arg0.ambient;
		this.contrast = arg0.contrast;
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::CopyForShareLight
	@ObfuscatedName("fw.k()Lfw;")
	public ModelUnlit copyForShareLight() {
		ModelUnlit copy = new ModelUnlit();

		if (this.faceRenderType != null) {
			copy.faceRenderType = new byte[this.numFaces];

			for (int f = 0; f < this.numFaces; f++) {
				copy.faceRenderType[f] = this.faceRenderType[f];
			}
		}

		copy.numPoints = this.numPoints;
		copy.numFaces = this.numFaces;
		copy.numT = this.numT;

		copy.pointX = this.pointX;
		copy.pointY = this.pointY;
		copy.pointZ = this.pointZ;

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

		copy.pointNormal = this.pointNormal;
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
			model.numPoints = this.numPoints;
			model.numFaces = this.numFaces;
			model.numT = this.numT;
			model.pointX = this.pointX;
			model.pointZ = this.pointZ;
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
			model.pointY = new int[model.numPoints];
		} else {
			model = this;
		}

		if (blend == 0) {
			for (int var16 = 0; var16 < model.numPoints; var16++) {
				int var17 = this.pointX[var16] + x;
				int var18 = this.pointZ[var16] + z;
				int var19 = var17 & 0x7F;
				int var20 = var18 & 0x7F;
				int var21 = var17 >> 7;
				int var22 = var18 >> 7;
				int var23 = (128 - var19) * groundh[var21][var22] + groundh[var21 + 1][var22] * var19 >> 7;
				int var24 = (128 - var19) * groundh[var21][var22 + 1] + groundh[var21 + 1][var22 + 1] * var19 >> 7;
				int var25 = (128 - var20) * var23 + var20 * var24 >> 7;
				model.pointY[var16] = this.pointY[var16] + var25 - y;
			}
		} else {
			for (int var26 = 0; var26 < model.numPoints; var26++) {
				int var27 = (-this.pointY[var26] << 16) / this.minY;
				if (var27 < blend) {
					int var28 = this.pointX[var26] + x;
					int var29 = this.pointZ[var26] + z;
					int var30 = var28 & 0x7F;
					int var31 = var29 & 0x7F;
					int var32 = var28 >> 7;
					int var33 = var29 >> 7;
					int var34 = (128 - var30) * groundh[var32][var33] + groundh[var32 + 1][var33] * var30 >> 7;
					int var35 = (128 - var30) * groundh[var32][var33 + 1] + groundh[var32 + 1][var33 + 1] * var30 >> 7;
					int var36 = (128 - var31) * var34 + var31 * var35 >> 7;
					model.pointY[var26] = (var36 - y) * (blend - var27) / blend + this.pointY[var26];
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
			for (int var3 = 0; var3 < this.numPoints; var3++) {
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
			while (var6 < this.numPoints) {
				int var7 = this.vertexLabel[var6];
				this.labelVertices[var7][var1[var7]++] = var6++;
			}
			this.vertexLabel = null;
		}

		if (this.faceLabel != null) {
			int[] var8 = new int[256];
			int var9 = 0;
			for (int var10 = 0; var10 < this.numFaces; var10++) {
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
			while (var13 < this.numFaces) {
				int var14 = this.faceLabel[var13];
				this.labelFaces[var14][var8[var14]++] = var13++;
			}
			this.faceLabel = null;
		}
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::Rotate90
	@ObfuscatedName("fw.h()V")
	public void rotate90() {
		for (int var1 = 0; var1 < this.numPoints; var1++) {
			int var2 = this.pointX[var1];
			this.pointX[var1] = this.pointZ[var1];
			this.pointZ[var1] = -var2;
		}
		this.geometryChanged();
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::Rotate180
	@ObfuscatedName("fw.x()V")
	public void rotate180() {
		for (int var1 = 0; var1 < this.numPoints; var1++) {
			this.pointX[var1] = -this.pointX[var1];
			this.pointZ[var1] = -this.pointZ[var1];
		}
		this.geometryChanged();
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::Rotate270
	@ObfuscatedName("fw.p()V")
	public void rotate270() {
		for (int var1 = 0; var1 < this.numPoints; var1++) {
			int var2 = this.pointZ[var1];
			this.pointZ[var1] = this.pointX[var1];
			this.pointX[var1] = -var2;
		}
		this.geometryChanged();
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::RotateXAxis
	@ObfuscatedName("fw.ad(I)V")
	public void rotateXAxis(int arg0) {
		int var2 = sinTable[arg0];
		int var3 = cosTable[arg0];
		for (int var4 = 0; var4 < this.numPoints; var4++) {
			int var5 = this.pointZ[var4] * var2 + this.pointX[var4] * var3 >> 16;
			this.pointZ[var4] = this.pointZ[var4] * var3 - this.pointX[var4] * var2 >> 16;
			this.pointX[var4] = var5;
		}
		this.geometryChanged();
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::Translate
	@ObfuscatedName("fw.ac(III)V")
	public void translate(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < this.numPoints; var4++) {
			this.pointX[var4] += arg0;
			this.pointY[var4] += arg1;
			this.pointZ[var4] += arg2;
		}
		this.geometryChanged();
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::Recolour
	@ObfuscatedName("fw.aa(SS)V")
	public void recolour(short arg0, short arg1) {
		for (int var3 = 0; var3 < this.numFaces; var3++) {
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
		for (int var3 = 0; var3 < this.numFaces; var3++) {
			if (this.faceTextureId[var3] == arg0) {
				this.faceTextureId[var3] = arg1;
			}
		}
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::Mirror
	@ObfuscatedName("fw.am()V")
	public void mirror() {
		for (int var1 = 0; var1 < this.numPoints; var1++) {
			this.pointZ[var1] = -this.pointZ[var1];
		}
		for (int var2 = 0; var2 < this.numFaces; var2++) {
			int var3 = this.faceVertexA[var2];
			this.faceVertexA[var2] = this.faceVertexC[var2];
			this.faceVertexC[var2] = var3;
		}
		this.geometryChanged();
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::Resize
	@ObfuscatedName("fw.ap(III)V")
	public void resize(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < this.numPoints; var4++) {
			this.pointX[var4] = this.pointX[var4] * arg0 / 128;
			this.pointY[var4] = this.pointY[var4] * arg1 / 128;
			this.pointZ[var4] = this.pointZ[var4] * arg2 / 128;
		}
		this.geometryChanged();
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::CalculateNormals
	@ObfuscatedName("fw.av()V")
	public void calculateNormals() {
		if (this.pointNormal != null) {
			return;
		}

		this.pointNormal = new PointNormal[this.numPoints];
		for (int var1 = 0; var1 < this.numPoints; var1++) {
			this.pointNormal[var1] = new PointNormal();
		}

		for (int f = 0; f < this.numFaces; f++) {
			int a = this.faceVertexA[f];
			int b = this.faceVertexB[f];
			int c = this.faceVertexC[f];

			int dxAB = this.pointX[b] - this.pointX[a];
			int dyAB = this.pointY[b] - this.pointY[a];
			int dzAB = this.pointZ[b] - this.pointZ[a];

			int dxAC = this.pointX[c] - this.pointX[a];
			int dyAC = this.pointY[c] - this.pointY[a];
			int dzAC = this.pointZ[c] - this.pointZ[a];

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
				PointNormal n = this.pointNormal[a];
				n.x += var16;
				n.y += var17;
				n.z += var18;
				n.w++;

				n = this.pointNormal[b];
				n.x += var16;
				n.y += var17;
				n.z += var18;
				n.w++;

				n = this.pointNormal[c];
				n.x += var16;
				n.y += var17;
				n.z += var18;
				n.w++;
			} else if (type == 1) {
				if (this.faceNormal == null) {
					this.faceNormal = new FaceNormal[this.numFaces];
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
		this.pointNormal = null;
		this.sharedPointNormal = null;
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

		for (int v = 0; v < this.numPoints; v++) {
			int x = this.pointX[v];
			int y = this.pointY[v];
			int z = this.pointZ[v];

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
		int[] var7 = model2.pointX;
		int var8 = model2.numPoints;
		for (int var9 = 0; var9 < model1.numPoints; var9++) {
			PointNormal var10 = model1.pointNormal[var9];
			if (var10.w == 0) {
				continue;
			}

			int var11 = model1.pointY[var9] - arg3;
			if (var11 <= model2.maxY) {
				int var12 = model1.pointX[var9] - arg2;
				if (var12 < model2.minX || var12 > model2.maxX) {
					continue;
				}

				int var13 = model1.pointZ[var9] - arg4;
				if (var13 < model2.maxZ || var13 > model2.minZ) {
					continue;
				}

				for (int var14 = 0; var14 < var8; var14++) {
					PointNormal var15 = model2.pointNormal[var14];
					if (var7[var14] != var12 || model2.pointZ[var14] != var13 || model2.pointY[var14] != var11 || var15.w == 0) {
						continue;
					}

					if (model1.sharedPointNormal == null) {
						model1.sharedPointNormal = new PointNormal[model1.numPoints];
					}

					if (model2.sharedPointNormal == null) {
						model2.sharedPointNormal = new PointNormal[var8];
					}

					PointNormal var16 = model1.sharedPointNormal[var9];
					if (var16 == null) {
						var16 = model1.sharedPointNormal[var9] = new PointNormal(var10);
					}

					PointNormal var17 = model2.sharedPointNormal[var14];
					if (var17 == null) {
						var17 = model2.sharedPointNormal[var14] = new PointNormal(var15);
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

					shareMap[var9] = shareTic;
					shareMap2[var14] = shareTic;
				}
			}
		}

		if (var6 >= 3 && arg5) {
			for (int var18 = 0; var18 < model1.numFaces; var18++) {
				if (shareMap[model1.faceVertexA[var18]] == shareTic && shareMap[model1.faceVertexB[var18]] == shareTic && shareMap[model1.faceVertexC[var18]] == shareTic) {
					if (model1.faceRenderType == null) {
						model1.faceRenderType = new byte[model1.numFaces];
					}
					model1.faceRenderType[var18] = 2;
				}
			}

			for (int var19 = 0; var19 < model2.numFaces; var19++) {
				if (shareMap2[model2.faceVertexA[var19]] == shareTic && shareMap2[model2.faceVertexB[var19]] == shareTic && shareMap2[model2.faceVertexC[var19]] == shareTic) {
					if (model2.faceRenderType == null) {
						model2.faceRenderType = new byte[model2.numFaces];
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
		lit.faceColourA = new int[this.numFaces];
		lit.faceColourB = new int[this.numFaces];
		lit.faceColourC = new int[this.numFaces];

		if (this.numT > 0 && this.faceTextureAxis != null) {
			int[] axis = new int[this.numT];
			for (int f = 0; f < this.numFaces; f++) {
				if (this.faceTextureAxis[f] != -1) {
					axis[this.faceTextureAxis[f] & 0xFF]++;
				}
			}

			lit.numT = 0;
			for (int f = 0; f < this.numT; f++) {
				if (axis[f] > 0 && this.textureRenderType[f] == 0) {
					lit.numT++;
				}
			}

			lit.faceTextureP = new int[lit.numT];
			lit.faceTextureM = new int[lit.numT];
			lit.faceTextureN = new int[lit.numT];

			int textureCount = 0;
			for (int f = 0; f < this.numT; f++) {
				if (axis[f] > 0 && this.textureRenderType[f] == 0) {
					lit.faceTextureP[textureCount] = this.faceTextureP[f] & 0xFFFF;
					lit.faceTextureM[textureCount] = this.faceTextureM[f] & 0xFFFF;
					lit.faceTextureN[textureCount] = this.faceTextureN[f] & 0xFFFF;
					axis[f] = textureCount++;
				} else {
					axis[f] = -1;
				}
			}

			lit.faceTextureAxis = new byte[this.numFaces];
			for (int f = 0; f < this.numFaces; f++) {
				if (this.faceTextureAxis[f] == -1) {
					lit.faceTextureAxis[f] = -1;
				} else {
					lit.faceTextureAxis[f] = (byte) axis[this.faceTextureAxis[f] & 0xFF];
				}
			}
		}

		for (int f = 0; f < this.numFaces; f++) {
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
					if (this.sharedPointNormal == null || this.sharedPointNormal[this.faceVertexA[f]] == null) {
						normalA = this.pointNormal[this.faceVertexA[f]];
					} else {
						normalA = this.sharedPointNormal[this.faceVertexA[f]];
					}
					int intensityA = (normalA.z * z + normalA.x * x + normalA.y * y) / (normalA.w * scale) + ambient;
					lit.faceColourA[f] = getColour(colour, intensityA);

					PointNormal normalB;
					if (this.sharedPointNormal == null || this.sharedPointNormal[this.faceVertexB[f]] == null) {
						normalB = this.pointNormal[this.faceVertexB[f]];
					} else {
						normalB = this.sharedPointNormal[this.faceVertexB[f]];
					}
					int intensityB = (normalB.z * z + normalB.x * x + normalB.y * y) / (normalB.w * scale) + ambient;
					lit.faceColourB[f] = getColour(colour, intensityB);

					PointNormal normalC;
					if (this.sharedPointNormal == null || this.sharedPointNormal[this.faceVertexC[f]] == null) {
						normalC = this.pointNormal[this.faceVertexC[f]];
					} else {
						normalC = this.sharedPointNormal[this.faceVertexC[f]];
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
				if (this.sharedPointNormal == null || this.sharedPointNormal[this.faceVertexA[f]] == null) {
					normalA = this.pointNormal[this.faceVertexA[f]];
				} else {
					normalA = this.sharedPointNormal[this.faceVertexA[f]];
				}
				int intensityA = (normalA.z * z + normalA.x * x + normalA.y * y) / (normalA.w * scale) + ambient;
				lit.faceColourA[f] = getTexLight(intensityA);

				PointNormal normalB;
				if (this.sharedPointNormal == null || this.sharedPointNormal[this.faceVertexB[f]] == null) {
					normalB = this.pointNormal[this.faceVertexB[f]];
				} else {
					normalB = this.sharedPointNormal[this.faceVertexB[f]];
				}
				int intensityB = (normalB.z * z + normalB.x * x + normalB.y * y) / (normalB.w * scale) + ambient;
				lit.faceColourB[f] = getTexLight(intensityB);

				PointNormal normalC;
				if (this.sharedPointNormal == null || this.sharedPointNormal[this.faceVertexC[f]] == null) {
					normalC = this.pointNormal[this.faceVertexC[f]];
				} else {
					normalC = this.sharedPointNormal[this.faceVertexC[f]];
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

		lit.numPoints = this.numPoints;
		lit.pointX = this.pointX;
		lit.pointY = this.pointY;
		lit.pointZ = this.pointZ;

		lit.numFaces = this.numFaces;
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
