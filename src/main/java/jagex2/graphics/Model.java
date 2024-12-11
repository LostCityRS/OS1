package jagex2.graphics;

import deob.ObfuscatedName;
import jagex2.dash3d.Entity;
import jagex2.dash3d.Unused10;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("fw")
public class Model extends Entity {

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
	public byte[] field2680;

	@ObfuscatedName("fw.b")
	public byte[] field2709;

	@ObfuscatedName("fw.y")
	public byte[] field2682;

	@ObfuscatedName("fw.t")
	public short[] field2704;

	@ObfuscatedName("fw.f")
	public short[] field2705;

	@ObfuscatedName("fw.k")
	public byte field2684 = 0;

	@ObfuscatedName("fw.o")
	public int texturedFaceCount;

	@ObfuscatedName("fw.a")
	public byte[] field2687;

	@ObfuscatedName("fw.h")
	public short[] field2688;

	@ObfuscatedName("fw.x")
	public short[] field2681;

	@ObfuscatedName("fw.p")
	public short[] field2690;

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
	public int[] field2713;

	@ObfuscatedName("fw.az")
	public int[] field2699;

	@ObfuscatedName("fw.an")
	public int[][] field2700;

	@ObfuscatedName("fw.ah")
	public int[][] field2701;

	@ObfuscatedName("fw.ay")
	public FaceNormal[] field2702;

	@ObfuscatedName("fw.al")
	public VertexNormal[] field2703;

	@ObfuscatedName("fw.ab")
	public VertexNormal[] field2685;

	@ObfuscatedName("fw.ao")
	public short field2708;

	@ObfuscatedName("fw.ag")
	public short field2706;

	@ObfuscatedName("fw.ar")
	public boolean field2707 = false;

	@ObfuscatedName("fw.aq")
	public int field2671;

	@ObfuscatedName("fw.at")
	public int field2686;

	@ObfuscatedName("fw.ae")
	public int field2710;

	@ObfuscatedName("fw.au")
	public int field2698;

	@ObfuscatedName("fw.ax")
	public int field2712;

	@ObfuscatedName("fw.ai")
	public static int[] field2683 = new int[10000];

	@ObfuscatedName("fw.aj")
	public static int[] field2714 = new int[10000];

	@ObfuscatedName("fw.aw")
	public static int field2715 = 0;

	@ObfuscatedName("fw.af")
	public static int[] sinTable = Pix3D.sinTable;

	@ObfuscatedName("fw.bh")
	public static int[] cosTable = Pix3D.cosTable;

	public Model() {
	}

	@ObfuscatedName("fw.b(Lch;II)Lfw;")
	public static Model tryGet(Js5Index arg0, int arg1, int arg2) {
		byte[] var3 = arg0.getFile(arg1, arg2);
		return var3 == null ? null : new Model(var3);
	}

	public Model(byte[] arg0) {
		if (arg0[arg0.length - 1] == -1 && arg0[arg0.length - 2] == -1) {
			this.method2944(arg0);
		} else {
			this.method2955(arg0);
		}
	}

	@ObfuscatedName("fw.y([B)V")
	public void method2944(byte[] arg0) {
		Packet var2 = new Packet(arg0);
		Packet var3 = new Packet(arg0);
		Packet var4 = new Packet(arg0);
		Packet var5 = new Packet(arg0);
		Packet var6 = new Packet(arg0);
		Packet var7 = new Packet(arg0);
		Packet var8 = new Packet(arg0);
		var2.pos = arg0.length - 23;
		int var9 = var2.g2();
		int var10 = var2.g2();
		int var11 = var2.g1();
		int var12 = var2.g1();
		int var13 = var2.g1();
		int var14 = var2.g1();
		int var15 = var2.g1();
		int var16 = var2.g1();
		int var17 = var2.g1();
		int var18 = var2.g2();
		int var19 = var2.g2();
		int var20 = var2.g2();
		int var21 = var2.g2();
		int var22 = var2.g2();
		int var23 = 0;
		int var24 = 0;
		int var25 = 0;
		if (var11 > 0) {
			this.field2687 = new byte[var11];
			var2.pos = 0;
			for (int var26 = 0; var26 < var11; var26++) {
				byte var27 = this.field2687[var26] = var2.g1b();
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
		if (var13 == 255) {
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
		this.texturedFaceCount = var11;
		this.vertexX = new int[var9];
		this.vertexY = new int[var9];
		this.vertexZ = new int[var9];
		this.faceVertexA = new int[var10];
		this.faceVertexB = new int[var10];
		this.faceVertexC = new int[var10];
		if (var17 == 1) {
			this.field2713 = new int[var9];
		}
		if (var12 == 1) {
			this.field2679 = new byte[var10];
		}
		if (var13 == 255) {
			this.field2680 = new byte[var10];
		} else {
			this.field2684 = (byte) var13;
		}
		if (var14 == 1) {
			this.field2709 = new byte[var10];
		}
		if (var15 == 1) {
			this.field2699 = new int[var10];
		}
		if (var16 == 1) {
			this.field2705 = new short[var10];
		}
		if (var16 == 1 && var11 > 0) {
			this.field2682 = new byte[var10];
		}
		this.field2704 = new short[var10];
		if (var11 > 0) {
			this.field2688 = new short[var11];
			this.field2681 = new short[var11];
			this.field2690 = new short[var11];
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
		var2.pos = var11;
		var3.pos = var44;
		var4.pos = var46;
		var5.pos = var48;
		var6.pos = var36;
		int var64 = 0;
		int var65 = 0;
		int var66 = 0;
		for (int var67 = 0; var67 < var9; var67++) {
			int var68 = var2.g1();
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
				this.field2713[var67] = var6.g1();
			}
		}
		var2.pos = var42;
		var3.pos = var31;
		var4.pos = var34;
		var5.pos = var37;
		var6.pos = var35;
		var7.pos = var40;
		var8.pos = var39;
		for (int var72 = 0; var72 < var10; var72++) {
			this.field2704[var72] = (short) var2.g2();
			if (var12 == 1) {
				this.field2679[var72] = var3.g1b();
			}
			if (var13 == 255) {
				this.field2680[var72] = var4.g1b();
			}
			if (var14 == 1) {
				this.field2709[var72] = var5.g1b();
			}
			if (var15 == 1) {
				this.field2699[var72] = var6.g1();
			}
			if (var16 == 1) {
				this.field2705[var72] = (short) (var7.g2() - 1);
			}
			if (this.field2682 != null && this.field2705[var72] != -1) {
				this.field2682[var72] = (byte) (var8.g1() - 1);
			}
		}
		var2.pos = var33;
		var3.pos = var30;
		int var73 = 0;
		int var74 = 0;
		int var75 = 0;
		int var76 = 0;
		for (int var77 = 0; var77 < var10; var77++) {
			int var78 = var3.g1();
			if (var78 == 1) {
				var73 = var2.gsmarts() + var76;
				var74 = var2.gsmarts() + var73;
				var75 = var2.gsmarts() + var74;
				var76 = var75;
				this.faceVertexA[var77] = var73;
				this.faceVertexB[var77] = var74;
				this.faceVertexC[var77] = var75;
			}
			if (var78 == 2) {
				var74 = var75;
				var75 = var2.gsmarts() + var76;
				var76 = var75;
				this.faceVertexA[var77] = var73;
				this.faceVertexB[var77] = var74;
				this.faceVertexC[var77] = var75;
			}
			if (var78 == 3) {
				var73 = var75;
				var75 = var2.gsmarts() + var76;
				var76 = var75;
				this.faceVertexA[var77] = var73;
				this.faceVertexB[var77] = var74;
				this.faceVertexC[var77] = var75;
			}
			if (var78 == 4) {
				int var81 = var73;
				var73 = var74;
				var74 = var81;
				var75 = var2.gsmarts() + var76;
				var76 = var75;
				this.faceVertexA[var77] = var73;
				this.faceVertexB[var77] = var81;
				this.faceVertexC[var77] = var75;
			}
		}
		var2.pos = var50;
		var3.pos = var52;
		var4.pos = var54;
		var5.pos = var56;
		var6.pos = var58;
		var7.pos = var60;
		for (int var82 = 0; var82 < var11; var82++) {
			int var83 = this.field2687[var82] & 0xFF;
			if (var83 == 0) {
				this.field2688[var82] = (short) var2.g2();
				this.field2681[var82] = (short) var2.g2();
				this.field2690[var82] = (short) var2.g2();
			}
			if (var83 == 1) {
				this.field2688[var82] = (short) var3.g2();
				this.field2681[var82] = (short) var3.g2();
				this.field2690[var82] = (short) var3.g2();
				this.field2691[var82] = (short) var4.g2();
				this.field2692[var82] = (short) var4.g2();
				this.field2693[var82] = (short) var4.g2();
				this.field2694[var82] = (short) var5.g2();
				this.field2697[var82] = var6.g1b();
				this.field2695[var82] = (short) var7.g2();
			}
			if (var83 == 2) {
				this.field2688[var82] = (short) var3.g2();
				this.field2681[var82] = (short) var3.g2();
				this.field2690[var82] = (short) var3.g2();
				this.field2691[var82] = (short) var4.g2();
				this.field2692[var82] = (short) var4.g2();
				this.field2693[var82] = (short) var4.g2();
				this.field2694[var82] = (short) var5.g2();
				this.field2697[var82] = var6.g1b();
				this.field2695[var82] = (short) var7.g2();
				this.field2696[var82] = (short) var7.g2();
			}
			if (var83 == 3) {
				this.field2688[var82] = (short) var3.g2();
				this.field2681[var82] = (short) var3.g2();
				this.field2690[var82] = (short) var3.g2();
				this.field2691[var82] = (short) var4.g2();
				this.field2692[var82] = (short) var4.g2();
				this.field2693[var82] = (short) var4.g2();
				this.field2694[var82] = (short) var5.g2();
				this.field2697[var82] = var6.g1b();
				this.field2695[var82] = (short) var7.g2();
			}
		}
		var2.pos = var62;
		int var84 = var2.g1();
		if (var84 == 0) {
			return;
		}
		new Unused10();
		var2.g2();
		var2.g2();
		var2.g2();
		var2.g4();
	}

	@ObfuscatedName("fw.t([B)V")
	public void method2955(byte[] arg0) {
		boolean var2 = false;
		boolean var3 = false;
		Packet var4 = new Packet(arg0);
		Packet var5 = new Packet(arg0);
		Packet var6 = new Packet(arg0);
		Packet var7 = new Packet(arg0);
		Packet var8 = new Packet(arg0);
		var4.pos = arg0.length - 18;
		int var9 = var4.g2();
		int var10 = var4.g2();
		int var11 = var4.g1();
		int var12 = var4.g1();
		int var13 = var4.g1();
		int var14 = var4.g1();
		int var15 = var4.g1();
		int var16 = var4.g1();
		int var17 = var4.g2();
		int var18 = var4.g2();
		int var19 = var4.g2();
		int var20 = var4.g2();
		byte var21 = 0;
		int var23 = var9 + var21;
		int var25 = var10 + var23;
		int var26 = var25;
		if (var13 == 255) {
			var25 += var10;
		}
		int var27 = var25;
		if (var15 == 1) {
			var25 += var10;
		}
		int var28 = var25;
		if (var12 == 1) {
			var25 += var10;
		}
		int var29 = var25;
		if (var16 == 1) {
			var25 += var9;
		}
		int var30 = var25;
		if (var14 == 1) {
			var25 += var10;
		}
		int var32 = var20 + var25;
		int var34 = var10 * 2 + var32;
		int var36 = var11 * 6 + var34;
		int var38 = var17 + var36;
		int var40 = var18 + var38;
		int var10000 = var19 + var40;
		this.vertexCount = var9;
		this.faceCount = var10;
		this.texturedFaceCount = var11;
		this.vertexX = new int[var9];
		this.vertexY = new int[var9];
		this.vertexZ = new int[var9];
		this.faceVertexA = new int[var10];
		this.faceVertexB = new int[var10];
		this.faceVertexC = new int[var10];
		if (var11 > 0) {
			this.field2687 = new byte[var11];
			this.field2688 = new short[var11];
			this.field2681 = new short[var11];
			this.field2690 = new short[var11];
		}
		if (var16 == 1) {
			this.field2713 = new int[var9];
		}
		if (var12 == 1) {
			this.field2679 = new byte[var10];
			this.field2682 = new byte[var10];
			this.field2705 = new short[var10];
		}
		if (var13 == 255) {
			this.field2680 = new byte[var10];
		} else {
			this.field2684 = (byte) var13;
		}
		if (var14 == 1) {
			this.field2709 = new byte[var10];
		}
		if (var15 == 1) {
			this.field2699 = new int[var10];
		}
		this.field2704 = new short[var10];
		var4.pos = var21;
		var5.pos = var36;
		var6.pos = var38;
		var7.pos = var40;
		var8.pos = var29;
		int var43 = 0;
		int var44 = 0;
		int var45 = 0;
		for (int var46 = 0; var46 < var9; var46++) {
			int var47 = var4.g1();
			int var48 = 0;
			if ((var47 & 0x1) != 0) {
				var48 = var5.gsmarts();
			}
			int var49 = 0;
			if ((var47 & 0x2) != 0) {
				var49 = var6.gsmarts();
			}
			int var50 = 0;
			if ((var47 & 0x4) != 0) {
				var50 = var7.gsmarts();
			}
			this.vertexX[var46] = var43 + var48;
			this.vertexY[var46] = var44 + var49;
			this.vertexZ[var46] = var45 + var50;
			var43 = this.vertexX[var46];
			var44 = this.vertexY[var46];
			var45 = this.vertexZ[var46];
			if (var16 == 1) {
				this.field2713[var46] = var8.g1();
			}
		}
		var4.pos = var32;
		var5.pos = var28;
		var6.pos = var26;
		var7.pos = var30;
		var8.pos = var27;
		for (int var51 = 0; var51 < var10; var51++) {
			this.field2704[var51] = (short) var4.g2();
			if (var12 == 1) {
				int var52 = var5.g1();
				if ((var52 & 0x1) == 1) {
					this.field2679[var51] = 1;
					var2 = true;
				} else {
					this.field2679[var51] = 0;
				}
				if ((var52 & 0x2) == 2) {
					this.field2682[var51] = (byte) (var52 >> 2);
					this.field2705[var51] = this.field2704[var51];
					this.field2704[var51] = 127;
					if (this.field2705[var51] != -1) {
						var3 = true;
					}
				} else {
					this.field2682[var51] = -1;
					this.field2705[var51] = -1;
				}
			}
			if (var13 == 255) {
				this.field2680[var51] = var6.g1b();
			}
			if (var14 == 1) {
				this.field2709[var51] = var7.g1b();
			}
			if (var15 == 1) {
				this.field2699[var51] = var8.g1();
			}
		}
		var4.pos = var25;
		var5.pos = var23;
		int var53 = 0;
		int var54 = 0;
		int var55 = 0;
		int var56 = 0;
		for (int var57 = 0; var57 < var10; var57++) {
			int var58 = var5.g1();
			if (var58 == 1) {
				var53 = var4.gsmarts() + var56;
				var54 = var4.gsmarts() + var53;
				var55 = var4.gsmarts() + var54;
				var56 = var55;
				this.faceVertexA[var57] = var53;
				this.faceVertexB[var57] = var54;
				this.faceVertexC[var57] = var55;
			}
			if (var58 == 2) {
				var54 = var55;
				var55 = var4.gsmarts() + var56;
				var56 = var55;
				this.faceVertexA[var57] = var53;
				this.faceVertexB[var57] = var54;
				this.faceVertexC[var57] = var55;
			}
			if (var58 == 3) {
				var53 = var55;
				var55 = var4.gsmarts() + var56;
				var56 = var55;
				this.faceVertexA[var57] = var53;
				this.faceVertexB[var57] = var54;
				this.faceVertexC[var57] = var55;
			}
			if (var58 == 4) {
				int var61 = var53;
				var53 = var54;
				var54 = var61;
				var55 = var4.gsmarts() + var56;
				var56 = var55;
				this.faceVertexA[var57] = var53;
				this.faceVertexB[var57] = var61;
				this.faceVertexC[var57] = var55;
			}
		}
		var4.pos = var34;
		for (int var62 = 0; var62 < var11; var62++) {
			this.field2687[var62] = 0;
			this.field2688[var62] = (short) var4.g2();
			this.field2681[var62] = (short) var4.g2();
			this.field2690[var62] = (short) var4.g2();
		}
		if (this.field2682 != null) {
			boolean var63 = false;
			for (int var64 = 0; var64 < var10; var64++) {
				int var65 = this.field2682[var64] & 0xFF;
				if (var65 != 255) {
					if ((this.field2688[var65] & 0xFFFF) == this.faceVertexA[var64] && (this.field2681[var65] & 0xFFFF) == this.faceVertexB[var64] && (this.field2690[var65] & 0xFFFF) == this.faceVertexC[var64]) {
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

	public Model(Model[] arg0, int arg1) {
		boolean var3 = false;
		boolean var4 = false;
		boolean var5 = false;
		boolean var6 = false;
		boolean var7 = false;
		boolean var8 = false;
		this.vertexCount = 0;
		this.faceCount = 0;
		this.texturedFaceCount = 0;
		this.field2684 = -1;
		for (int var9 = 0; var9 < arg1; var9++) {
			Model var10 = arg0[var9];
			if (var10 != null) {
				this.vertexCount += var10.vertexCount;
				this.faceCount += var10.faceCount;
				this.texturedFaceCount += var10.texturedFaceCount;
				if (var10.field2680 == null) {
					if (this.field2684 == -1) {
						this.field2684 = var10.field2684;
					}
					if (this.field2684 != var10.field2684) {
						var4 = true;
					}
				} else {
					var4 = true;
				}
				var3 |= var10.field2679 != null;
				var5 |= var10.field2709 != null;
				var6 |= var10.field2699 != null;
				var7 |= var10.field2705 != null;
				var8 |= var10.field2682 != null;
			}
		}
		this.vertexX = new int[this.vertexCount];
		this.vertexY = new int[this.vertexCount];
		this.vertexZ = new int[this.vertexCount];
		this.field2713 = new int[this.vertexCount];
		this.faceVertexA = new int[this.faceCount];
		this.faceVertexB = new int[this.faceCount];
		this.faceVertexC = new int[this.faceCount];
		if (var3) {
			this.field2679 = new byte[this.faceCount];
		}
		if (var4) {
			this.field2680 = new byte[this.faceCount];
		}
		if (var5) {
			this.field2709 = new byte[this.faceCount];
		}
		if (var6) {
			this.field2699 = new int[this.faceCount];
		}
		if (var7) {
			this.field2705 = new short[this.faceCount];
		}
		if (var8) {
			this.field2682 = new byte[this.faceCount];
		}
		this.field2704 = new short[this.faceCount];
		if (this.texturedFaceCount > 0) {
			this.field2687 = new byte[this.texturedFaceCount];
			this.field2688 = new short[this.texturedFaceCount];
			this.field2681 = new short[this.texturedFaceCount];
			this.field2690 = new short[this.texturedFaceCount];
			this.field2691 = new short[this.texturedFaceCount];
			this.field2692 = new short[this.texturedFaceCount];
			this.field2693 = new short[this.texturedFaceCount];
			this.field2694 = new short[this.texturedFaceCount];
			this.field2697 = new byte[this.texturedFaceCount];
			this.field2695 = new short[this.texturedFaceCount];
			this.field2696 = new short[this.texturedFaceCount];
		}
		this.vertexCount = 0;
		this.faceCount = 0;
		this.texturedFaceCount = 0;
		for (int var11 = 0; var11 < arg1; var11++) {
			Model var12 = arg0[var11];
			if (var12 != null) {
				for (int var13 = 0; var13 < var12.faceCount; var13++) {
					if (var3 && var12.field2679 != null) {
						this.field2679[this.faceCount] = var12.field2679[var13];
					}
					if (var4) {
						if (var12.field2680 == null) {
							this.field2680[this.faceCount] = var12.field2684;
						} else {
							this.field2680[this.faceCount] = var12.field2680[var13];
						}
					}
					if (var5 && var12.field2709 != null) {
						this.field2709[this.faceCount] = var12.field2709[var13];
					}
					if (var6 && var12.field2699 != null) {
						this.field2699[this.faceCount] = var12.field2699[var13];
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
							this.field2682[this.faceCount] = (byte) (var12.field2682[var13] + this.texturedFaceCount);
						}
					}
					this.field2704[this.faceCount] = var12.field2704[var13];
					this.faceVertexA[this.faceCount] = this.method2947(var12, var12.faceVertexA[var13]);
					this.faceVertexB[this.faceCount] = this.method2947(var12, var12.faceVertexB[var13]);
					this.faceVertexC[this.faceCount] = this.method2947(var12, var12.faceVertexC[var13]);
					this.faceCount++;
				}
				for (int var14 = 0; var14 < var12.texturedFaceCount; var14++) {
					byte var15 = this.field2687[this.texturedFaceCount] = var12.field2687[var14];
					if (var15 == 0) {
						this.field2688[this.texturedFaceCount] = (short) this.method2947(var12, var12.field2688[var14]);
						this.field2681[this.texturedFaceCount] = (short) this.method2947(var12, var12.field2681[var14]);
						this.field2690[this.texturedFaceCount] = (short) this.method2947(var12, var12.field2690[var14]);
					}
					if (var15 >= 1 && var15 <= 3) {
						this.field2688[this.texturedFaceCount] = var12.field2688[var14];
						this.field2681[this.texturedFaceCount] = var12.field2681[var14];
						this.field2690[this.texturedFaceCount] = var12.field2690[var14];
						this.field2691[this.texturedFaceCount] = var12.field2691[var14];
						this.field2692[this.texturedFaceCount] = var12.field2692[var14];
						this.field2693[this.texturedFaceCount] = var12.field2693[var14];
						this.field2694[this.texturedFaceCount] = var12.field2694[var14];
						this.field2697[this.texturedFaceCount] = var12.field2697[var14];
						this.field2695[this.texturedFaceCount] = var12.field2695[var14];
					}
					if (var15 == 2) {
						this.field2696[this.texturedFaceCount] = var12.field2696[var14];
					}
					this.texturedFaceCount++;
				}
			}
		}
	}

	@ObfuscatedName("fw.f(Lfw;I)I")
	public final int method2947(Model arg0, int arg1) {
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
			if (arg0.field2713 != null) {
				this.field2713[this.vertexCount] = arg0.field2713[arg1];
			}
			var3 = this.vertexCount++;
		}
		return var3;
	}

	public Model(Model arg0, boolean arg1, boolean arg2, boolean arg3, boolean arg4) {
		this.vertexCount = arg0.vertexCount;
		this.faceCount = arg0.faceCount;
		this.texturedFaceCount = arg0.texturedFaceCount;
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
			this.field2704 = arg0.field2704;
		} else {
			this.field2704 = new short[this.faceCount];
			for (int var7 = 0; var7 < this.faceCount; var7++) {
				this.field2704[var7] = arg0.field2704[var7];
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
			this.field2709 = arg0.field2709;
		} else {
			this.field2709 = new byte[this.faceCount];
			if (arg0.field2709 == null) {
				for (int var9 = 0; var9 < this.faceCount; var9++) {
					this.field2709[var9] = 0;
				}
			} else {
				for (int var10 = 0; var10 < this.faceCount; var10++) {
					this.field2709[var10] = arg0.field2709[var10];
				}
			}
		}
		this.faceVertexA = arg0.faceVertexA;
		this.faceVertexB = arg0.faceVertexB;
		this.faceVertexC = arg0.faceVertexC;
		this.field2679 = arg0.field2679;
		this.field2680 = arg0.field2680;
		this.field2682 = arg0.field2682;
		this.field2684 = arg0.field2684;
		this.field2687 = arg0.field2687;
		this.field2688 = arg0.field2688;
		this.field2681 = arg0.field2681;
		this.field2690 = arg0.field2690;
		this.field2691 = arg0.field2691;
		this.field2692 = arg0.field2692;
		this.field2693 = arg0.field2693;
		this.field2694 = arg0.field2694;
		this.field2697 = arg0.field2697;
		this.field2695 = arg0.field2695;
		this.field2696 = arg0.field2696;
		this.field2713 = arg0.field2713;
		this.field2699 = arg0.field2699;
		this.field2700 = arg0.field2700;
		this.field2701 = arg0.field2701;
		this.field2703 = arg0.field2703;
		this.field2702 = arg0.field2702;
		this.field2685 = arg0.field2685;
		this.field2708 = arg0.field2708;
		this.field2706 = arg0.field2706;
	}

	@ObfuscatedName("fw.k()Lfw;")
	public Model method2982() {
		Model var1 = new Model();
		if (this.field2679 != null) {
			var1.field2679 = new byte[this.faceCount];
			for (int var2 = 0; var2 < this.faceCount; var2++) {
				var1.field2679[var2] = this.field2679[var2];
			}
		}
		var1.vertexCount = this.vertexCount;
		var1.faceCount = this.faceCount;
		var1.texturedFaceCount = this.texturedFaceCount;
		var1.vertexX = this.vertexX;
		var1.vertexY = this.vertexY;
		var1.vertexZ = this.vertexZ;
		var1.faceVertexA = this.faceVertexA;
		var1.faceVertexB = this.faceVertexB;
		var1.faceVertexC = this.faceVertexC;
		var1.field2680 = this.field2680;
		var1.field2709 = this.field2709;
		var1.field2682 = this.field2682;
		var1.field2704 = this.field2704;
		var1.field2705 = this.field2705;
		var1.field2684 = this.field2684;
		var1.field2687 = this.field2687;
		var1.field2688 = this.field2688;
		var1.field2681 = this.field2681;
		var1.field2690 = this.field2690;
		var1.field2691 = this.field2691;
		var1.field2692 = this.field2692;
		var1.field2693 = this.field2693;
		var1.field2694 = this.field2694;
		var1.field2697 = this.field2697;
		var1.field2695 = this.field2695;
		var1.field2696 = this.field2696;
		var1.field2713 = this.field2713;
		var1.field2699 = this.field2699;
		var1.field2700 = this.field2700;
		var1.field2701 = this.field2701;
		var1.field2703 = this.field2703;
		var1.field2702 = this.field2702;
		var1.field2708 = this.field2708;
		var1.field2706 = this.field2706;
		return var1;
	}

	@ObfuscatedName("fw.o([[IIIIZI)Lfw;")
	public Model method2928(int[][] arg0, int arg1, int arg2, int arg3, boolean arg4, int arg5) {
		this.method2940();
		int var7 = this.field2686 + arg1;
		int var8 = this.field2710 + arg1;
		int var9 = this.field2712 + arg3;
		int var10 = this.field2698 + arg3;
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
		Model var15;
		if (arg4) {
			var15 = new Model();
			var15.vertexCount = this.vertexCount;
			var15.faceCount = this.faceCount;
			var15.texturedFaceCount = this.texturedFaceCount;
			var15.vertexX = this.vertexX;
			var15.vertexZ = this.vertexZ;
			var15.faceVertexA = this.faceVertexA;
			var15.faceVertexB = this.faceVertexB;
			var15.faceVertexC = this.faceVertexC;
			var15.field2679 = this.field2679;
			var15.field2680 = this.field2680;
			var15.field2709 = this.field2709;
			var15.field2682 = this.field2682;
			var15.field2704 = this.field2704;
			var15.field2705 = this.field2705;
			var15.field2684 = this.field2684;
			var15.field2687 = this.field2687;
			var15.field2688 = this.field2688;
			var15.field2681 = this.field2681;
			var15.field2690 = this.field2690;
			var15.field2691 = this.field2691;
			var15.field2692 = this.field2692;
			var15.field2693 = this.field2693;
			var15.field2694 = this.field2694;
			var15.field2697 = this.field2697;
			var15.field2695 = this.field2695;
			var15.field2696 = this.field2696;
			var15.field2713 = this.field2713;
			var15.field2699 = this.field2699;
			var15.field2700 = this.field2700;
			var15.field2701 = this.field2701;
			var15.field2708 = this.field2708;
			var15.field2706 = this.field2706;
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
		var15.method2986();
		return var15;
	}

	@ObfuscatedName("fw.a()V")
	public void method2929() {
		int var10002;
		if (this.field2713 != null) {
			int[] var1 = new int[256];
			int var2 = 0;
			for (int var3 = 0; var3 < this.vertexCount; var3++) {
				int var4 = this.field2713[var3];
				var10002 = var1[var4]++;
				if (var4 > var2) {
					var2 = var4;
				}
			}
			this.field2700 = new int[var2 + 1][];
			for (int var5 = 0; var5 <= var2; var5++) {
				this.field2700[var5] = new int[var1[var5]];
				var1[var5] = 0;
			}
			int var6 = 0;
			while (var6 < this.vertexCount) {
				int var7 = this.field2713[var6];
				this.field2700[var7][var1[var7]++] = var6++;
			}
			this.field2713 = null;
		}
		if (this.field2699 == null) {
			return;
		}
		int[] var8 = new int[256];
		int var9 = 0;
		for (int var10 = 0; var10 < this.faceCount; var10++) {
			int var11 = this.field2699[var10];
			var10002 = var8[var11]++;
			if (var11 > var9) {
				var9 = var11;
			}
		}
		this.field2701 = new int[var9 + 1][];
		for (int var12 = 0; var12 <= var9; var12++) {
			this.field2701[var12] = new int[var8[var12]];
			var8[var12] = 0;
		}
		int var13 = 0;
		while (var13 < this.faceCount) {
			int var14 = this.field2699[var13];
			this.field2701[var14][var8[var14]++] = var13++;
		}
		this.field2699 = null;
	}

	@ObfuscatedName("fw.h()V")
	public void method2930() {
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			int var2 = this.vertexX[var1];
			this.vertexX[var1] = this.vertexZ[var1];
			this.vertexZ[var1] = -var2;
		}
		this.method2986();
	}

	@ObfuscatedName("fw.x()V")
	public void method2931() {
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			this.vertexX[var1] = -this.vertexX[var1];
			this.vertexZ[var1] = -this.vertexZ[var1];
		}
		this.method2986();
	}

	@ObfuscatedName("fw.p()V")
	public void method2923() {
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			int var2 = this.vertexZ[var1];
			this.vertexZ[var1] = this.vertexX[var1];
			this.vertexX[var1] = -var2;
		}
		this.method2986();
	}

	@ObfuscatedName("fw.ad(I)V")
	public void method2933(int arg0) {
		int var2 = sinTable[arg0];
		int var3 = cosTable[arg0];
		for (int var4 = 0; var4 < this.vertexCount; var4++) {
			int var5 = this.vertexZ[var4] * var2 + this.vertexX[var4] * var3 >> 16;
			this.vertexZ[var4] = this.vertexZ[var4] * var3 - this.vertexX[var4] * var2 >> 16;
			this.vertexX[var4] = var5;
		}
		this.method2986();
	}

	@ObfuscatedName("fw.ac(III)V")
	public void translate(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < this.vertexCount; var4++) {
			this.vertexX[var4] += arg0;
			this.vertexY[var4] += arg1;
			this.vertexZ[var4] += arg2;
		}
		this.method2986();
	}

	@ObfuscatedName("fw.aa(SS)V")
	public void recolour(short arg0, short arg1) {
		for (int var3 = 0; var3 < this.faceCount; var3++) {
			if (this.field2704[var3] == arg0) {
				this.field2704[var3] = arg1;
			}
		}
	}

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

	@ObfuscatedName("fw.am()V")
	public void rotateY180() {
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			this.vertexZ[var1] = -this.vertexZ[var1];
		}
		for (int var2 = 0; var2 < this.faceCount; var2++) {
			int var3 = this.faceVertexA[var2];
			this.faceVertexA[var2] = this.faceVertexC[var2];
			this.faceVertexC[var2] = var3;
		}
		this.method2986();
	}

	@ObfuscatedName("fw.ap(III)V")
	public void scale(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < this.vertexCount; var4++) {
			this.vertexX[var4] = this.vertexX[var4] * arg0 / 128;
			this.vertexY[var4] = this.vertexY[var4] * arg1 / 128;
			this.vertexZ[var4] = this.vertexZ[var4] * arg2 / 128;
		}
		this.method2986();
	}

	@ObfuscatedName("fw.av()V")
	public void method2932() {
		if (this.field2703 != null) {
			return;
		}
		this.field2703 = new VertexNormal[this.vertexCount];
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			this.field2703[var1] = new VertexNormal();
		}
		for (int var2 = 0; var2 < this.faceCount; var2++) {
			int var3 = this.faceVertexA[var2];
			int var4 = this.faceVertexB[var2];
			int var5 = this.faceVertexC[var2];
			int var6 = this.vertexX[var4] - this.vertexX[var3];
			int var7 = this.vertexY[var4] - this.vertexY[var3];
			int var8 = this.vertexZ[var4] - this.vertexZ[var3];
			int var9 = this.vertexX[var5] - this.vertexX[var3];
			int var10 = this.vertexY[var5] - this.vertexY[var3];
			int var11 = this.vertexZ[var5] - this.vertexZ[var3];
			int var12 = var7 * var11 - var8 * var10;
			int var13 = var8 * var9 - var6 * var11;
			int var14;
			for (var14 = var6 * var10 - var7 * var9; var12 > 8192 || var13 > 8192 || var14 > 8192 || var12 < -8192 || var13 < -8192 || var14 < -8192; var14 >>= 0x1) {
				var12 >>= 0x1;
				var13 >>= 0x1;
			}
			int var15 = (int) Math.sqrt((double) (var14 * var14 + var12 * var12 + var13 * var13));
			if (var15 <= 0) {
				var15 = 1;
			}
			int var16 = var12 * 256 / var15;
			int var17 = var13 * 256 / var15;
			int var18 = var14 * 256 / var15;
			byte var19;
			if (this.field2679 == null) {
				var19 = 0;
			} else {
				var19 = this.field2679[var2];
			}
			if (var19 == 0) {
				VertexNormal var20 = this.field2703[var3];
				var20.x += var16;
				var20.y += var17;
				var20.z += var18;
				var20.w++;
				VertexNormal var21 = this.field2703[var4];
				var21.x += var16;
				var21.y += var17;
				var21.z += var18;
				var21.w++;
				VertexNormal var22 = this.field2703[var5];
				var22.x += var16;
				var22.y += var17;
				var22.z += var18;
				var22.w++;
			} else if (var19 == 1) {
				if (this.field2702 == null) {
					this.field2702 = new FaceNormal[this.faceCount];
				}
				FaceNormal var23 = this.field2702[var2] = new FaceNormal();
				var23.field552 = var16;
				var23.field551 = var17;
				var23.field550 = var18;
			}
		}
	}

	@ObfuscatedName("fw.ak()V")
	public void method2986() {
		this.field2703 = null;
		this.field2685 = null;
		this.field2702 = null;
		this.field2707 = false;
	}

	@ObfuscatedName("fw.az()V")
	public void method2940() {
		if (this.field2707) {
			return;
		}
		this.minY = 0;
		this.field2671 = 0;
		this.field2686 = 999999;
		this.field2710 = -999999;
		this.field2698 = -99999;
		this.field2712 = 99999;
		for (int var1 = 0; var1 < this.vertexCount; var1++) {
			int var2 = this.vertexX[var1];
			int var3 = this.vertexY[var1];
			int var4 = this.vertexZ[var1];
			if (var2 < this.field2686) {
				this.field2686 = var2;
			}
			if (var2 > this.field2710) {
				this.field2710 = var2;
			}
			if (var4 < this.field2712) {
				this.field2712 = var4;
			}
			if (var4 > this.field2698) {
				this.field2698 = var4;
			}
			if (-var3 > this.minY) {
				this.minY = -var3;
			}
			if (var3 > this.field2671) {
				this.field2671 = var3;
			}
		}
		this.field2707 = true;
	}

	@ObfuscatedName("fw.an(Lfw;Lfw;IIIZ)V")
	public static void mergeNormals(Model arg0, Model arg1, int arg2, int arg3, int arg4, boolean arg5) {
		arg0.method2940();
		arg0.method2932();
		arg1.method2940();
		arg1.method2932();
		field2715++;
		int var6 = 0;
		int[] var7 = arg1.vertexX;
		int var8 = arg1.vertexCount;
		for (int var9 = 0; var9 < arg0.vertexCount; var9++) {
			VertexNormal var10 = arg0.field2703[var9];
			if (var10.w == 0) {
				continue;
			}
			int var11 = arg0.vertexY[var9] - arg3;
			if (var11 <= arg1.field2671) {
				int var12 = arg0.vertexX[var9] - arg2;
				if (var12 < arg1.field2686 || var12 > arg1.field2710) {
					continue;
				}
				int var13 = arg0.vertexZ[var9] - arg4;
				if (var13 < arg1.field2712 || var13 > arg1.field2698) {
					continue;
				}
				for (int var14 = 0; var14 < var8; var14++) {
					VertexNormal var15 = arg1.field2703[var14];
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
					field2683[var9] = field2715;
					field2714[var14] = field2715;
				}
			}
		}
		if (var6 >= 3 && arg5) {
			for (int var18 = 0; var18 < arg0.faceCount; var18++) {
				if (field2683[arg0.faceVertexA[var18]] == field2715 && field2683[arg0.faceVertexB[var18]] == field2715 && field2683[arg0.faceVertexC[var18]] == field2715) {
					if (arg0.field2679 == null) {
						arg0.field2679 = new byte[arg0.faceCount];
					}
					arg0.field2679[var18] = 2;
				}
			}
			for (int var19 = 0; var19 < arg1.faceCount; var19++) {
				if (field2714[arg1.faceVertexA[var19]] == field2715 && field2714[arg1.faceVertexB[var19]] == field2715 && field2714[arg1.faceVertexC[var19]] == field2715) {
					if (arg1.field2679 == null) {
						arg1.field2679 = new byte[arg1.faceCount];
					}
					arg1.field2679[var19] = 2;
				}
			}
		}
	}

	@ObfuscatedName("fw.ah(IIIII)Lfo;")
	public final SoftwareModel calculateNormals(int arg0, int arg1, int arg2, int arg3, int arg4) {
		this.method2932();
		int var6 = (int) Math.sqrt(arg4 * arg4 + arg2 * arg2 + arg3 * arg3);
		int var7 = arg1 * var6 >> 8;
		SoftwareModel var8 = new SoftwareModel();
		var8.field2778 = new int[this.faceCount];
		var8.field2731 = new int[this.faceCount];
		var8.field2732 = new int[this.faceCount];
		if (this.texturedFaceCount > 0 && this.field2682 != null) {
			int[] var9 = new int[this.texturedFaceCount];
			for (int var10 = 0; var10 < this.faceCount; var10++) {
				if (this.field2682[var10] != -1) {
					var9[this.field2682[var10] & 0xFF]++;
				}
			}
			var8.field2738 = 0;
			for (int var11 = 0; var11 < this.texturedFaceCount; var11++) {
				if (var9[var11] > 0 && this.field2687[var11] == 0) {
					var8.field2738++;
				}
			}
			var8.field2739 = new int[var8.field2738];
			var8.field2774 = new int[var8.field2738];
			var8.field2765 = new int[var8.field2738];
			int var12 = 0;
			for (int var13 = 0; var13 < this.texturedFaceCount; var13++) {
				if (var9[var13] > 0 && this.field2687[var13] == 0) {
					var8.field2739[var12] = this.field2688[var13] & 0xFFFF;
					var8.field2774[var12] = this.field2681[var13] & 0xFFFF;
					var8.field2765[var12] = this.field2690[var13] & 0xFFFF;
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
			if (this.field2709 == null) {
				var17 = 0;
			} else {
				var17 = this.field2709[var15];
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
					int var19 = this.field2704[var15] & 0xFFFF;
					VertexNormal var20;
					if (this.field2685 == null || this.field2685[this.faceVertexA[var15]] == null) {
						var20 = this.field2703[this.faceVertexA[var15]];
					} else {
						var20 = this.field2685[this.faceVertexA[var15]];
					}
					int var21 = (var20.z * arg4 + var20.x * arg2 + var20.y * arg3) / (var20.w * var7) + arg0;
					var8.field2778[var15] = method2943(var19, var21);
					VertexNormal var22;
					if (this.field2685 == null || this.field2685[this.faceVertexB[var15]] == null) {
						var22 = this.field2703[this.faceVertexB[var15]];
					} else {
						var22 = this.field2685[this.faceVertexB[var15]];
					}
					int var23 = (var22.z * arg4 + var22.x * arg2 + var22.y * arg3) / (var22.w * var7) + arg0;
					var8.field2731[var15] = method2943(var19, var23);
					VertexNormal var24;
					if (this.field2685 == null || this.field2685[this.faceVertexC[var15]] == null) {
						var24 = this.field2703[this.faceVertexC[var15]];
					} else {
						var24 = this.field2685[this.faceVertexC[var15]];
					}
					int var25 = (var24.z * arg4 + var24.x * arg2 + var24.y * arg3) / (var24.w * var7) + arg0;
					var8.field2732[var15] = method2943(var19, var25);
				} else if (var16 == 1) {
					FaceNormal var26 = this.field2702[var15];
					int var27 = (var26.field550 * arg4 + var26.field552 * arg2 + var26.field551 * arg3) / (var7 / 2 + var7) + arg0;
					var8.field2778[var15] = method2943(this.field2704[var15] & 0xFFFF, var27);
					var8.field2732[var15] = -1;
				} else if (var16 == 3) {
					var8.field2778[var15] = 128;
					var8.field2732[var15] = -1;
				} else {
					var8.field2732[var15] = -2;
				}
			} else if (var16 == 0) {
				VertexNormal var28;
				if (this.field2685 == null || this.field2685[this.faceVertexA[var15]] == null) {
					var28 = this.field2703[this.faceVertexA[var15]];
				} else {
					var28 = this.field2685[this.faceVertexA[var15]];
				}
				int var29 = (var28.z * arg4 + var28.x * arg2 + var28.y * arg3) / (var28.w * var7) + arg0;
				var8.field2778[var15] = method2939(var29);
				VertexNormal var30;
				if (this.field2685 == null || this.field2685[this.faceVertexB[var15]] == null) {
					var30 = this.field2703[this.faceVertexB[var15]];
				} else {
					var30 = this.field2685[this.faceVertexB[var15]];
				}
				int var31 = (var30.z * arg4 + var30.x * arg2 + var30.y * arg3) / (var30.w * var7) + arg0;
				var8.field2731[var15] = method2939(var31);
				VertexNormal var32;
				if (this.field2685 == null || this.field2685[this.faceVertexC[var15]] == null) {
					var32 = this.field2703[this.faceVertexC[var15]];
				} else {
					var32 = this.field2685[this.faceVertexC[var15]];
				}
				int var33 = (var32.z * arg4 + var32.x * arg2 + var32.y * arg3) / (var32.w * var7) + arg0;
				var8.field2732[var15] = method2939(var33);
			} else if (var16 == 1) {
				FaceNormal var34 = this.field2702[var15];
				int var35 = (var34.field550 * arg4 + var34.field552 * arg2 + var34.field551 * arg3) / (var7 / 2 + var7) + arg0;
				var8.field2778[var15] = method2939(var35);
				var8.field2732[var15] = -1;
			} else {
				var8.field2732[var15] = -2;
			}
		}
		this.method2929();
		var8.field2722 = this.vertexCount;
		var8.field2723 = this.vertexX;
		var8.field2724 = this.vertexY;
		var8.field2779 = this.vertexZ;
		var8.field2780 = this.faceCount;
		var8.field2727 = this.faceVertexA;
		var8.field2726 = this.faceVertexB;
		var8.field2729 = this.faceVertexC;
		var8.field2733 = this.field2680;
		var8.field2728 = this.field2709;
		var8.field2737 = this.field2684;
		var8.field2742 = this.field2700;
		var8.field2743 = this.field2701;
		var8.field2718 = this.field2705;
		return var8;
	}

	@ObfuscatedName("fw.ay(II)I")
	public static final int method2943(int arg0, int arg1) {
		int var2 = (arg0 & 0x7F) * arg1 >> 7;
		if (var2 < 2) {
			var2 = 2;
		} else if (var2 > 126) {
			var2 = 126;
		}
		return (arg0 & 0xFF80) + var2;
	}

	@ObfuscatedName("fw.al(I)I")
	public static final int method2939(int arg0) {
		if (arg0 < 2) {
			arg0 = 2;
		} else if (arg0 > 126) {
			arg0 = 126;
		}
		return arg0;
	}
}
