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
	public byte[] field2679;

	@ObfuscatedName("fw.e")
	public byte[] facePriority;

	@ObfuscatedName("fw.b")
	public byte[] faceAlpha;

	@ObfuscatedName("fw.y")
	public byte[] field2682;

	@ObfuscatedName("fw.t")
	public short[] faceColour;

	@ObfuscatedName("fw.f")
	public short[] field2705;

	@ObfuscatedName("fw.k")
	public byte priority = 0;

	@ObfuscatedName("fw.o")
	public int faceTextureCount;

	@ObfuscatedName("fw.a")
	public byte[] field2687;

	@ObfuscatedName("fw.h")
	public short[] faceTextureP;

	@ObfuscatedName("fw.x")
	public short[] faceTextureM;

	@ObfuscatedName("fw.p")
	public short[] faceTextureN;

	@ObfuscatedName("fw.ad")
	public short[] field2691;

	@ObfuscatedName("fw.ac")
	public short[] field2692;

	@ObfuscatedName("fw.aa")
	public short[] field2693;

	@ObfuscatedName("fw.as")
	public short[] field2694;

	@ObfuscatedName("fw.am")
	public short[] field2695;

	@ObfuscatedName("fw.ap")
	public short[] field2696;

	@ObfuscatedName("fw.av")
	public byte[] field2697;

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
	public VertexNormal[] vertexNormal;

	@ObfuscatedName("fw.ab")
	public VertexNormal[] field2685;

	@ObfuscatedName("fw.ao")
	public short ambient;

	@ObfuscatedName("fw.ag")
	public short contrast;

	@ObfuscatedName("fw.ar")
	public boolean boundsCalculated = false;

	@ObfuscatedName("fw.aq")
	public int radius;

	@ObfuscatedName("fw.at")
	public int minX;

	@ObfuscatedName("fw.ae")
	public int maxX;

	@ObfuscatedName("fw.au")
	public int minZ;

	@ObfuscatedName("fw.ax")
	public int maxZ;

	@ObfuscatedName("fw.ai")
	public static int[] field2683 = new int[10000];

	@ObfuscatedName("fw.aj")
	public static int[] field2714 = new int[10000];

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
			this.field2687 = new byte[var11];
			var1.pos = 0;

			for (int var26 = 0; var26 < var11; var26++) {
				byte var27 = this.field2687[var26] = var1.g1b();
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
			this.field2679 = new byte[var10];
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
			this.field2705 = new short[var10];
		}

		if (var16 == 1 && var11 > 0) {
			this.field2682 = new byte[var10];
		}

		this.faceColour = new short[var10];
		if (var11 > 0) {
			this.faceTextureP = new short[var11];
			this.faceTextureM = new short[var11];
			this.faceTextureN = new short[var11];
			if (var24 > 0) {
				this.field2691 = new short[var24];
				this.field2692 = new short[var24];
				this.field2693 = new short[var24];
				this.field2694 = new short[var24];
				this.field2697 = new byte[var24];
				this.field2695 = new short[var24];
			}
			if (var25 > 0) {
				this.field2696 = new short[var25];
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
				this.field2679[var72] = var3.g1b();
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
				this.field2705[var72] = (short) (var7.g2() - 1);
			}
			if (this.field2682 != null && this.field2705[var72] != -1) {
				this.field2682[var72] = (byte) (var8.g1() - 1);
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
			int var83 = this.field2687[var82] & 0xFF;
			if (var83 == 0) {
				this.faceTextureP[var82] = (short) var1.g2();
				this.faceTextureM[var82] = (short) var1.g2();
				this.faceTextureN[var82] = (short) var1.g2();
			}
			if (var83 == 1) {
				this.faceTextureP[var82] = (short) var3.g2();
				this.faceTextureM[var82] = (short) var3.g2();
				this.faceTextureN[var82] = (short) var3.g2();
				this.field2691[var82] = (short) var4.g2();
				this.field2692[var82] = (short) var4.g2();
				this.field2693[var82] = (short) var4.g2();
				this.field2694[var82] = (short) var5.g2();
				this.field2697[var82] = var6.g1b();
				this.field2695[var82] = (short) var7.g2();
			}
			if (var83 == 2) {
				this.faceTextureP[var82] = (short) var3.g2();
				this.faceTextureM[var82] = (short) var3.g2();
				this.faceTextureN[var82] = (short) var3.g2();
				this.field2691[var82] = (short) var4.g2();
				this.field2692[var82] = (short) var4.g2();
				this.field2693[var82] = (short) var4.g2();
				this.field2694[var82] = (short) var5.g2();
				this.field2697[var82] = var6.g1b();
				this.field2695[var82] = (short) var7.g2();
				this.field2696[var82] = (short) var7.g2();
			}
			if (var83 == 3) {
				this.faceTextureP[var82] = (short) var3.g2();
				this.faceTextureM[var82] = (short) var3.g2();
				this.faceTextureN[var82] = (short) var3.g2();
				this.field2691[var82] = (short) var4.g2();
				this.field2692[var82] = (short) var4.g2();
				this.field2693[var82] = (short) var4.g2();
				this.field2694[var82] = (short) var5.g2();
				this.field2697[var82] = var6.g1b();
				this.field2695[var82] = (short) var7.g2();
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
		boolean var2 = false;
		boolean var3 = false;

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
			this.field2687 = new byte[faceTextureCount];
			this.faceTextureP = new short[faceTextureCount];
			this.faceTextureM = new short[faceTextureCount];
			this.faceTextureN = new short[faceTextureCount];
		}

		if (hasVertexLabels == 1) {
			this.vertexLabel = new int[vertexCount];
		}

		if (hasFaceInfo == 1) {
			this.field2679 = new byte[faceCount];
			this.field2682 = new byte[faceCount];
			this.field2705 = new short[faceCount];
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
					this.field2679[f] = 1;
					var2 = true;
				} else {
					this.field2679[f] = 0;
				}
				if ((var52 & 0x2) == 2) {
					this.field2682[f] = (byte) (var52 >> 2);
					this.field2705[f] = this.faceColour[f];
					this.faceColour[f] = 127;
					if (this.field2705[f] != -1) {
						var3 = true;
					}
				} else {
					this.field2682[f] = -1;
					this.field2705[f] = -1;
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
			this.field2687[f] = 0;
			this.faceTextureP[f] = (short) axis.g2();
			this.faceTextureM[f] = (short) axis.g2();
			this.faceTextureN[f] = (short) axis.g2();
		}

		if (this.field2682 != null) {
			boolean var63 = false;
			for (int var64 = 0; var64 < faceCount; var64++) {
				int var65 = this.field2682[var64] & 0xFF;
				if (var65 != 255) {
					if ((this.faceTextureP[var65] & 0xFFFF) == this.faceVertexA[var64] && (this.faceTextureM[var65] & 0xFFFF) == this.faceVertexB[var64] && (this.faceTextureN[var65] & 0xFFFF) == this.faceVertexC[var64]) {
						this.field2682[var64] = -1;
					} else {
						var63 = true;
					}
				}
			}
			if (!var63) {
				this.field2682 = null;
			}
		}

		if (!var3) {
			this.field2705 = null;
		}

		if (!var2) {
			this.field2679 = null;
		}
	}

	public ModelUnlit(ModelUnlit[] arg0, int arg1) {
		boolean var3 = false;
		boolean var4 = false;
		boolean var5 = false;
		boolean var6 = false;
		boolean var7 = false;
		boolean var8 = false;
		this.vertexCount = 0;
		this.faceCount = 0;
		this.faceTextureCount = 0;
		this.priority = -1;
		for (int var9 = 0; var9 < arg1; var9++) {
			ModelUnlit var10 = arg0[var9];
			if (var10 != null) {
				this.vertexCount += var10.vertexCount;
				this.faceCount += var10.faceCount;
				this.faceTextureCount += var10.faceTextureCount;
				if (var10.facePriority == null) {
					if (this.priority == -1) {
						this.priority = var10.priority;
					}
					if (this.priority != var10.priority) {
						var4 = true;
					}
				} else {
					var4 = true;
				}
				var3 |= var10.field2679 != null;
				var5 |= var10.faceAlpha != null;
				var6 |= var10.faceLabel != null;
				var7 |= var10.field2705 != null;
				var8 |= var10.field2682 != null;
			}
		}
		this.vertexX = new int[this.vertexCount];
		this.vertexY = new int[this.vertexCount];
		this.vertexZ = new int[this.vertexCount];
		this.vertexLabel = new int[this.vertexCount];
		this.faceVertexA = new int[this.faceCount];
		this.faceVertexB = new int[this.faceCount];
		this.faceVertexC = new int[this.faceCount];
		if (var3) {
			this.field2679 = new byte[this.faceCount];
		}
		if (var4) {
			this.facePriority = new byte[this.faceCount];
		}
		if (var5) {
			this.faceAlpha = new byte[this.faceCount];
		}
		if (var6) {
			this.faceLabel = new int[this.faceCount];
		}
		if (var7) {
			this.field2705 = new short[this.faceCount];
		}
		if (var8) {
			this.field2682 = new byte[this.faceCount];
		}
		this.faceColour = new short[this.faceCount];
		if (this.faceTextureCount > 0) {
			this.field2687 = new byte[this.faceTextureCount];
			this.faceTextureP = new short[this.faceTextureCount];
			this.faceTextureM = new short[this.faceTextureCount];
			this.faceTextureN = new short[this.faceTextureCount];
			this.field2691 = new short[this.faceTextureCount];
			this.field2692 = new short[this.faceTextureCount];
			this.field2693 = new short[this.faceTextureCount];
			this.field2694 = new short[this.faceTextureCount];
			this.field2697 = new byte[this.faceTextureCount];
			this.field2695 = new short[this.faceTextureCount];
			this.field2696 = new short[this.faceTextureCount];
		}
		this.vertexCount = 0;
		this.faceCount = 0;
		this.faceTextureCount = 0;
		for (int var11 = 0; var11 < arg1; var11++) {
			ModelUnlit var12 = arg0[var11];
			if (var12 != null) {
				for (int var13 = 0; var13 < var12.faceCount; var13++) {
					if (var3 && var12.field2679 != null) {
						this.field2679[this.faceCount] = var12.field2679[var13];
					}
					if (var4) {
						if (var12.facePriority == null) {
							this.facePriority[this.faceCount] = var12.priority;
						} else {
							this.facePriority[this.faceCount] = var12.facePriority[var13];
						}
					}
					if (var5 && var12.faceAlpha != null) {
						this.faceAlpha[this.faceCount] = var12.faceAlpha[var13];
					}
					if (var6 && var12.faceLabel != null) {
						this.faceLabel[this.faceCount] = var12.faceLabel[var13];
					}
					if (var7) {
						if (var12.field2705 == null) {
							this.field2705[this.faceCount] = -1;
						} else {
							this.field2705[this.faceCount] = var12.field2705[var13];
						}
					}
					if (var8) {
						if (var12.field2682 == null || var12.field2682[var13] == -1) {
							this.field2682[this.faceCount] = -1;
						} else {
							this.field2682[this.faceCount] = (byte) (var12.field2682[var13] + this.faceTextureCount);
						}
					}
					this.faceColour[this.faceCount] = var12.faceColour[var13];
					this.faceVertexA[this.faceCount] = this.addPoint(var12, var12.faceVertexA[var13]);
					this.faceVertexB[this.faceCount] = this.addPoint(var12, var12.faceVertexB[var13]);
					this.faceVertexC[this.faceCount] = this.addPoint(var12, var12.faceVertexC[var13]);
					this.faceCount++;
				}
				for (int var14 = 0; var14 < var12.faceTextureCount; var14++) {
					byte var15 = this.field2687[this.faceTextureCount] = var12.field2687[var14];
					if (var15 == 0) {
						this.faceTextureP[this.faceTextureCount] = (short) this.addPoint(var12, var12.faceTextureP[var14]);
						this.faceTextureM[this.faceTextureCount] = (short) this.addPoint(var12, var12.faceTextureM[var14]);
						this.faceTextureN[this.faceTextureCount] = (short) this.addPoint(var12, var12.faceTextureN[var14]);
					}
					if (var15 >= 1 && var15 <= 3) {
						this.faceTextureP[this.faceTextureCount] = var12.faceTextureP[var14];
						this.faceTextureM[this.faceTextureCount] = var12.faceTextureM[var14];
						this.faceTextureN[this.faceTextureCount] = var12.faceTextureN[var14];
						this.field2691[this.faceTextureCount] = var12.field2691[var14];
						this.field2692[this.faceTextureCount] = var12.field2692[var14];
						this.field2693[this.faceTextureCount] = var12.field2693[var14];
						this.field2694[this.faceTextureCount] = var12.field2694[var14];
						this.field2697[this.faceTextureCount] = var12.field2697[var14];
						this.field2695[this.faceTextureCount] = var12.field2695[var14];
					}
					if (var15 == 2) {
						this.field2696[this.faceTextureCount] = var12.field2696[var14];
					}
					this.faceTextureCount++;
				}
			}
		}
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::AddPoint
	@ObfuscatedName("fw.f(Lfw;I)I")
	public final int addPoint(ModelUnlit arg0, int arg1) {
		int var3 = -1;
		int var4 = arg0.vertexX[arg1];
		int var5 = arg0.vertexY[arg1];
		int var6 = arg0.vertexZ[arg1];
		for (int var7 = 0; var7 < this.vertexCount; var7++) {
			if (this.vertexX[var7] == var4 && this.vertexY[var7] == var5 && this.vertexZ[var7] == var6) {
				var3 = var7;
				break;
			}
		}
		if (var3 == -1) {
			this.vertexX[this.vertexCount] = var4;
			this.vertexY[this.vertexCount] = var5;
			this.vertexZ[this.vertexCount] = var6;
			if (arg0.vertexLabel != null) {
				this.vertexLabel[this.vertexCount] = arg0.vertexLabel[arg1];
			}
			var3 = this.vertexCount++;
		}
		return var3;
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
		if (arg3 || arg0.field2705 == null) {
			this.field2705 = arg0.field2705;
		} else {
			this.field2705 = new short[this.faceCount];
			for (int var8 = 0; var8 < this.faceCount; var8++) {
				this.field2705[var8] = arg0.field2705[var8];
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
		this.field2679 = arg0.field2679;
		this.facePriority = arg0.facePriority;
		this.field2682 = arg0.field2682;
		this.priority = arg0.priority;
		this.field2687 = arg0.field2687;
		this.faceTextureP = arg0.faceTextureP;
		this.faceTextureM = arg0.faceTextureM;
		this.faceTextureN = arg0.faceTextureN;
		this.field2691 = arg0.field2691;
		this.field2692 = arg0.field2692;
		this.field2693 = arg0.field2693;
		this.field2694 = arg0.field2694;
		this.field2697 = arg0.field2697;
		this.field2695 = arg0.field2695;
		this.field2696 = arg0.field2696;
		this.vertexLabel = arg0.vertexLabel;
		this.faceLabel = arg0.faceLabel;
		this.labelVertices = arg0.labelVertices;
		this.labelFaces = arg0.labelFaces;
		this.vertexNormal = arg0.vertexNormal;
		this.faceNormal = arg0.faceNormal;
		this.field2685 = arg0.field2685;
		this.ambient = arg0.ambient;
		this.contrast = arg0.contrast;
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::CopyForShareLight
	@ObfuscatedName("fw.k()Lfw;")
	public ModelUnlit copyForShareLight() {
		ModelUnlit var1 = new ModelUnlit();
		if (this.field2679 != null) {
			var1.field2679 = new byte[this.faceCount];
			for (int var2 = 0; var2 < this.faceCount; var2++) {
				var1.field2679[var2] = this.field2679[var2];
			}
		}
		var1.vertexCount = this.vertexCount;
		var1.faceCount = this.faceCount;
		var1.faceTextureCount = this.faceTextureCount;
		var1.vertexX = this.vertexX;
		var1.vertexY = this.vertexY;
		var1.vertexZ = this.vertexZ;
		var1.faceVertexA = this.faceVertexA;
		var1.faceVertexB = this.faceVertexB;
		var1.faceVertexC = this.faceVertexC;
		var1.facePriority = this.facePriority;
		var1.faceAlpha = this.faceAlpha;
		var1.field2682 = this.field2682;
		var1.faceColour = this.faceColour;
		var1.field2705 = this.field2705;
		var1.priority = this.priority;
		var1.field2687 = this.field2687;
		var1.faceTextureP = this.faceTextureP;
		var1.faceTextureM = this.faceTextureM;
		var1.faceTextureN = this.faceTextureN;
		var1.field2691 = this.field2691;
		var1.field2692 = this.field2692;
		var1.field2693 = this.field2693;
		var1.field2694 = this.field2694;
		var1.field2697 = this.field2697;
		var1.field2695 = this.field2695;
		var1.field2696 = this.field2696;
		var1.vertexLabel = this.vertexLabel;
		var1.faceLabel = this.faceLabel;
		var1.labelVertices = this.labelVertices;
		var1.labelFaces = this.labelFaces;
		var1.vertexNormal = this.vertexNormal;
		var1.faceNormal = this.faceNormal;
		var1.ambient = this.ambient;
		var1.contrast = this.contrast;
		return var1;
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::HillSkew
	@ObfuscatedName("fw.o([[IIIIZI)Lfw;")
	public ModelUnlit hillSkew(int[][] arg0, int arg1, int arg2, int arg3, boolean arg4, int arg5) {
		this.calcBoundingCube();
		int var7 = this.minX + arg1;
		int var8 = this.maxX + arg1;
		int var9 = this.maxZ + arg3;
		int var10 = this.minZ + arg3;
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
		ModelUnlit var15;
		if (arg4) {
			var15 = new ModelUnlit();
			var15.vertexCount = this.vertexCount;
			var15.faceCount = this.faceCount;
			var15.faceTextureCount = this.faceTextureCount;
			var15.vertexX = this.vertexX;
			var15.vertexZ = this.vertexZ;
			var15.faceVertexA = this.faceVertexA;
			var15.faceVertexB = this.faceVertexB;
			var15.faceVertexC = this.faceVertexC;
			var15.field2679 = this.field2679;
			var15.facePriority = this.facePriority;
			var15.faceAlpha = this.faceAlpha;
			var15.field2682 = this.field2682;
			var15.faceColour = this.faceColour;
			var15.field2705 = this.field2705;
			var15.priority = this.priority;
			var15.field2687 = this.field2687;
			var15.faceTextureP = this.faceTextureP;
			var15.faceTextureM = this.faceTextureM;
			var15.faceTextureN = this.faceTextureN;
			var15.field2691 = this.field2691;
			var15.field2692 = this.field2692;
			var15.field2693 = this.field2693;
			var15.field2694 = this.field2694;
			var15.field2697 = this.field2697;
			var15.field2695 = this.field2695;
			var15.field2696 = this.field2696;
			var15.vertexLabel = this.vertexLabel;
			var15.faceLabel = this.faceLabel;
			var15.labelVertices = this.labelVertices;
			var15.labelFaces = this.labelFaces;
			var15.ambient = this.ambient;
			var15.contrast = this.contrast;
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
		var15.geometryChanged();
		return var15;
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
		if (this.field2705 == null) {
			return;
		}
		for (int var3 = 0; var3 < this.faceCount; var3++) {
			if (this.field2705[var3] == arg0) {
				this.field2705[var3] = arg1;
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

		this.vertexNormal = new VertexNormal[this.vertexCount];
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			this.vertexNormal[var1] = new VertexNormal();
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

			byte var19;
			if (this.field2679 == null) {
				var19 = 0;
			} else {
				var19 = this.field2679[f];
			}

			if (var19 == 0) {
				VertexNormal n = this.vertexNormal[a];
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
			} else if (var19 == 1) {
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
		this.field2685 = null;
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
		this.radius = 0;
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

			if (y > this.radius) {
				this.radius = y;
			}
		}

		this.boundsCalculated = true;
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::ShareLight
	@ObfuscatedName("fw.an(Lfw;Lfw;IIIZ)V")
	public static void shareLight(ModelUnlit arg0, ModelUnlit arg1, int arg2, int arg3, int arg4, boolean arg5) {
		arg0.calcBoundingCube();
		arg0.calculateNormals();
		arg1.calcBoundingCube();
		arg1.calculateNormals();

		shareTic++;
		int var6 = 0;
		int[] var7 = arg1.vertexX;
		int var8 = arg1.vertexCount;
		for (int var9 = 0; var9 < arg0.vertexCount; var9++) {
			VertexNormal var10 = arg0.vertexNormal[var9];
			if (var10.w == 0) {
				continue;
			}
			int var11 = arg0.vertexY[var9] - arg3;
			if (var11 <= arg1.radius) {
				int var12 = arg0.vertexX[var9] - arg2;
				if (var12 < arg1.minX || var12 > arg1.maxX) {
					continue;
				}
				int var13 = arg0.vertexZ[var9] - arg4;
				if (var13 < arg1.maxZ || var13 > arg1.minZ) {
					continue;
				}
				for (int var14 = 0; var14 < var8; var14++) {
					VertexNormal var15 = arg1.vertexNormal[var14];
					if (var7[var14] != var12 || arg1.vertexZ[var14] != var13 || arg1.vertexY[var14] != var11 || var15.w == 0) {
						continue;
					}
					if (arg0.field2685 == null) {
						arg0.field2685 = new VertexNormal[arg0.vertexCount];
					}
					if (arg1.field2685 == null) {
						arg1.field2685 = new VertexNormal[var8];
					}
					VertexNormal var16 = arg0.field2685[var9];
					if (var16 == null) {
						var16 = arg0.field2685[var9] = new VertexNormal(var10);
					}
					VertexNormal var17 = arg1.field2685[var14];
					if (var17 == null) {
						var17 = arg1.field2685[var14] = new VertexNormal(var15);
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
					field2683[var9] = shareTic;
					field2714[var14] = shareTic;
				}
			}
		}
		if (var6 >= 3 && arg5) {
			for (int var18 = 0; var18 < arg0.faceCount; var18++) {
				if (field2683[arg0.faceVertexA[var18]] == shareTic && field2683[arg0.faceVertexB[var18]] == shareTic && field2683[arg0.faceVertexC[var18]] == shareTic) {
					if (arg0.field2679 == null) {
						arg0.field2679 = new byte[arg0.faceCount];
					}
					arg0.field2679[var18] = 2;
				}
			}
			for (int var19 = 0; var19 < arg1.faceCount; var19++) {
				if (field2714[arg1.faceVertexA[var19]] == shareTic && field2714[arg1.faceVertexB[var19]] == shareTic && field2714[arg1.faceVertexC[var19]] == shareTic) {
					if (arg1.field2679 == null) {
						arg1.field2679 = new byte[arg1.faceCount];
					}
					arg1.field2679[var19] = 2;
				}
			}
		}
	}

	// jag::oldscape::dash3d::ModelUnlitImpl::Light
	@ObfuscatedName("fw.ah(IIIII)Lfo;")
	public final ModelLit light(int arg0, int arg1, int arg2, int arg3, int arg4) {
		this.calculateNormals();
		int var6 = (int) Math.sqrt(arg4 * arg4 + arg2 * arg2 + arg3 * arg3);
		int var7 = arg1 * var6 >> 8;
		ModelLit var8 = new ModelLit();
		var8.faceColourA = new int[this.faceCount];
		var8.faceColourB = new int[this.faceCount];
		var8.faceColourC = new int[this.faceCount];
		if (this.faceTextureCount > 0 && this.field2682 != null) {
			int[] var9 = new int[this.faceTextureCount];
			for (int var10 = 0; var10 < this.faceCount; var10++) {
				if (this.field2682[var10] != -1) {
					var9[this.field2682[var10] & 0xFF]++;
				}
			}
			var8.faceTextureCount = 0;
			for (int var11 = 0; var11 < this.faceTextureCount; var11++) {
				if (var9[var11] > 0 && this.field2687[var11] == 0) {
					var8.faceTextureCount++;
				}
			}
			var8.field2739 = new int[var8.faceTextureCount];
			var8.field2774 = new int[var8.faceTextureCount];
			var8.field2765 = new int[var8.faceTextureCount];
			int var12 = 0;
			for (int var13 = 0; var13 < this.faceTextureCount; var13++) {
				if (var9[var13] > 0 && this.field2687[var13] == 0) {
					var8.field2739[var12] = this.faceTextureP[var13] & 0xFFFF;
					var8.field2774[var12] = this.faceTextureM[var13] & 0xFFFF;
					var8.field2765[var12] = this.faceTextureN[var13] & 0xFFFF;
					var9[var13] = var12++;
				} else {
					var9[var13] = -1;
				}
			}
			var8.field2735 = new byte[this.faceCount];
			for (int var14 = 0; var14 < this.faceCount; var14++) {
				if (this.field2682[var14] == -1) {
					var8.field2735[var14] = -1;
				} else {
					var8.field2735[var14] = (byte) var9[this.field2682[var14] & 0xFF];
				}
			}
		}
		for (int var15 = 0; var15 < this.faceCount; var15++) {
			byte var16;
			if (this.field2679 == null) {
				var16 = 0;
			} else {
				var16 = this.field2679[var15];
			}
			byte var17;
			if (this.faceAlpha == null) {
				var17 = 0;
			} else {
				var17 = this.faceAlpha[var15];
			}
			short var18;
			if (this.field2705 == null) {
				var18 = -1;
			} else {
				var18 = this.field2705[var15];
			}
			if (var17 == -2) {
				var16 = 3;
			}
			if (var17 == -1) {
				var16 = 2;
			}
			if (var18 == -1) {
				if (var16 == 0) {
					int var19 = this.faceColour[var15] & 0xFFFF;
					VertexNormal var20;
					if (this.field2685 == null || this.field2685[this.faceVertexA[var15]] == null) {
						var20 = this.vertexNormal[this.faceVertexA[var15]];
					} else {
						var20 = this.field2685[this.faceVertexA[var15]];
					}
					int var21 = (var20.z * arg4 + var20.x * arg2 + var20.y * arg3) / (var20.w * var7) + arg0;
					var8.faceColourA[var15] = getColour(var19, var21);
					VertexNormal var22;
					if (this.field2685 == null || this.field2685[this.faceVertexB[var15]] == null) {
						var22 = this.vertexNormal[this.faceVertexB[var15]];
					} else {
						var22 = this.field2685[this.faceVertexB[var15]];
					}
					int var23 = (var22.z * arg4 + var22.x * arg2 + var22.y * arg3) / (var22.w * var7) + arg0;
					var8.faceColourB[var15] = getColour(var19, var23);
					VertexNormal var24;
					if (this.field2685 == null || this.field2685[this.faceVertexC[var15]] == null) {
						var24 = this.vertexNormal[this.faceVertexC[var15]];
					} else {
						var24 = this.field2685[this.faceVertexC[var15]];
					}
					int var25 = (var24.z * arg4 + var24.x * arg2 + var24.y * arg3) / (var24.w * var7) + arg0;
					var8.faceColourC[var15] = getColour(var19, var25);
				} else if (var16 == 1) {
					FaceNormal var26 = this.faceNormal[var15];
					int var27 = (var26.z * arg4 + var26.x * arg2 + var26.y * arg3) / (var7 / 2 + var7) + arg0;
					var8.faceColourA[var15] = getColour(this.faceColour[var15] & 0xFFFF, var27);
					var8.faceColourC[var15] = -1;
				} else if (var16 == 3) {
					var8.faceColourA[var15] = 128;
					var8.faceColourC[var15] = -1;
				} else {
					var8.faceColourC[var15] = -2;
				}
			} else if (var16 == 0) {
				VertexNormal var28;
				if (this.field2685 == null || this.field2685[this.faceVertexA[var15]] == null) {
					var28 = this.vertexNormal[this.faceVertexA[var15]];
				} else {
					var28 = this.field2685[this.faceVertexA[var15]];
				}
				int var29 = (var28.z * arg4 + var28.x * arg2 + var28.y * arg3) / (var28.w * var7) + arg0;
				var8.faceColourA[var15] = getTexLight(var29);
				VertexNormal var30;
				if (this.field2685 == null || this.field2685[this.faceVertexB[var15]] == null) {
					var30 = this.vertexNormal[this.faceVertexB[var15]];
				} else {
					var30 = this.field2685[this.faceVertexB[var15]];
				}
				int var31 = (var30.z * arg4 + var30.x * arg2 + var30.y * arg3) / (var30.w * var7) + arg0;
				var8.faceColourB[var15] = getTexLight(var31);
				VertexNormal var32;
				if (this.field2685 == null || this.field2685[this.faceVertexC[var15]] == null) {
					var32 = this.vertexNormal[this.faceVertexC[var15]];
				} else {
					var32 = this.field2685[this.faceVertexC[var15]];
				}
				int var33 = (var32.z * arg4 + var32.x * arg2 + var32.y * arg3) / (var32.w * var7) + arg0;
				var8.faceColourC[var15] = getTexLight(var33);
			} else if (var16 == 1) {
				FaceNormal var34 = this.faceNormal[var15];
				int var35 = (var34.z * arg4 + var34.x * arg2 + var34.y * arg3) / (var7 / 2 + var7) + arg0;
				var8.faceColourA[var15] = getTexLight(var35);
				var8.faceColourC[var15] = -1;
			} else {
				var8.faceColourC[var15] = -2;
			}
		}
		this.prepareAnim();
		var8.vertexCount = this.vertexCount;
		var8.vertexX = this.vertexX;
		var8.vertexY = this.vertexY;
		var8.vertexZ = this.vertexZ;
		var8.faceCount = this.faceCount;
		var8.faceVertexA = this.faceVertexA;
		var8.faceVertexB = this.faceVertexB;
		var8.faceVertexC = this.faceVertexC;
		var8.facePriority = this.facePriority;
		var8.faceAlpha = this.faceAlpha;
		var8.field2737 = this.priority;
		var8.labelVertices = this.labelVertices;
		var8.field2743 = this.labelFaces;
		var8.field2718 = this.field2705;
		return var8;
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
