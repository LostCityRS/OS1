package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.datastruct.LinkList;

@ObfuscatedName("aq")
public class World {

	@ObfuscatedName("aq.r")
	public static boolean lowMemory = true;

	@ObfuscatedName("aq.d")
	public int maxLevel;

	@ObfuscatedName("aq.l")
	public int maxTileX;

	@ObfuscatedName("aq.m")
	public int maxTileZ;

	@ObfuscatedName("aq.c")
	public int[][][] groundh;

	@ObfuscatedName("aq.n")
	public Square[][][] levelTiles;

	@ObfuscatedName("aq.j")
	public int minLevel = 0;

	@ObfuscatedName("aq.z")
	public int temporaryLocCount = 0;

	@ObfuscatedName("aq.g")
	public Sprite[] temporaryLocs = new Sprite[5000];

	@ObfuscatedName("aq.q")
	public int[][][] levelTileOcclusionCycles;

	@ObfuscatedName("aq.e")
	public static int fillLeft = 0;

	@ObfuscatedName("aq.b")
	public static int topLevel = 0;

	@ObfuscatedName("aq.y")
	public static int cycle;

	@ObfuscatedName("aq.t")
	public static int minDrawTileX;

	@ObfuscatedName("aq.f")
	public static int maxDrawTileX;

	@ObfuscatedName("aq.k")
	public static int minDrawTileZ;

	@ObfuscatedName("aq.o")
	public static int maxDrawTileZ;

	@ObfuscatedName("aq.a")
	public static int gx;

	@ObfuscatedName("aq.h")
	public static int gz;

	@ObfuscatedName("aq.x")
	public static int cx;

	@ObfuscatedName("aq.p")
	public static int cy;

	@ObfuscatedName("aq.ad")
	public static int cz;

	@ObfuscatedName("aq.ac")
	public static int cameraSinX;

	@ObfuscatedName("aq.aa")
	public static int cameraCosX;

	@ObfuscatedName("aq.as")
	public static int cameraSinY;

	@ObfuscatedName("aq.am")
	public static int cameraCosY;

	@ObfuscatedName("aq.ap")
	public static Sprite[] spriteBuffer = new Sprite[100];

	@ObfuscatedName("aq.av")
	public static boolean takingInput = false;

	@ObfuscatedName("aq.ak")
	public static int clickLevel = 0;

	@ObfuscatedName("aq.az")
	public static int mouseX = 0;

	@ObfuscatedName("aq.an")
	public static int mouseY = 0;

	@ObfuscatedName("aq.ah")
	public static int groundX = -1;

	@ObfuscatedName("aq.ay")
	public static int groundZ = -1;

	@ObfuscatedName("aq.ao")
	public static int levelCount = 4;

	@ObfuscatedName("aq.ag")
	public static int[] levelOccluderCount = new int[levelCount];

	@ObfuscatedName("aq.ar")
	public static Occlude[][] levelOccluders = new Occlude[levelCount][500];

	@ObfuscatedName("aq.aq")
	public static int activeOccluderCount = 0;

	@ObfuscatedName("aq.at")
	public static Occlude[] activeOccluders = new Occlude[500];

	@ObfuscatedName("aq.ae")
	public static LinkList fillQueue = new LinkList();

	@ObfuscatedName("aq.au")
	public static final int[] FRONT_WALL_TYPES = new int[] { 19, 55, 38, 155, 255, 110, 137, 205, 76 };

	@ObfuscatedName("aq.ax")
	public static final int[] DIRECTION_ALLOW_WALL_CORNER_TYPE = new int[] { 160, 192, 80, 96, 0, 144, 80, 48, 160 };

	@ObfuscatedName("aq.ai")
	public static final int[] BACK_WALL_TYPES = new int[] { 76, 8, 137, 4, 0, 1, 38, 2, 19 };

	@ObfuscatedName("aq.aj")
	public static final int[] WALL_CORNER_TYPE_16_BLOCK_LOC_SPANS = new int[] { 0, 0, 2, 0, 0, 2, 1, 1, 0 };

	@ObfuscatedName("aq.aw")
	public static final int[] WALL_CORNER_TYPE_32_BLOCK_LOC_SPANS = new int[] { 2, 0, 0, 2, 0, 0, 0, 4, 4 };

	@ObfuscatedName("aq.af")
	public static final int[] WALL_CORNER_TYPE_64_BLOCK_LOC_SPANS = new int[] { 0, 4, 4, 8, 0, 0, 8, 0, 0 };

	@ObfuscatedName("aq.bh")
	public static final int[] WALL_CORNER_TYPE_128_BLOCK_LOC_SPANS = new int[] { 1, 1, 0, 0, 0, 8, 0, 0, 8 };

	@ObfuscatedName("aq.bi")
	public int[][] MINIMAP_OVERLAY_SHAPE = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1 } };

	@ObfuscatedName("aq.bs")
	public int[][] MINIMAP_OVERLAY_ROTATION = new int[][] { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 }, { 12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3 }, { 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }, { 3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12 } };

	@ObfuscatedName("aq.bk")
	public static boolean[][][][] visibilityMatrix = new boolean[8][32][51][51];

	@ObfuscatedName("aq.bv")
	public static boolean[][] visibilityMap;

	@ObfuscatedName("aq.bg")
	public static int viewportCenterX;

	@ObfuscatedName("aq.bl")
	public static int viewportCenterY;

	@ObfuscatedName("aq.bt")
	public static int viewportLeft;

	@ObfuscatedName("aq.bw")
	public static int viewportTop;

	@ObfuscatedName("aq.by")
	public static int viewportRight;

	@ObfuscatedName("aq.bx")
	public static int viewportBottom;

	public World(int level, int x, int z, int[][][] heightmap) {
		this.maxLevel = level;
		this.maxTileX = x;
		this.maxTileZ = z;
		this.levelTiles = new Square[level][x][z];
		this.levelTileOcclusionCycles = new int[level][x + 1][z + 1];
		this.groundh = heightmap;
		this.reset();
	}

	@ObfuscatedName("aq.r()V")
	public void reset() {
		for (int level = 0; level < this.maxLevel; level++) {
			for (int x = 0; x < this.maxTileX; x++) {
				for (int z = 0; z < this.maxTileZ; z++) {
					this.levelTiles[level][x][z] = null;
				}
			}
		}

		for (int level = 0; level < levelCount; level++) {
			for (int i = 0; i < levelOccluderCount[level]; i++) {
				levelOccluders[level][i] = null;
			}

			levelOccluderCount[level] = 0;
		}

		for (int i = 0; i < this.temporaryLocCount; i++) {
			this.temporaryLocs[i] = null;
		}
		this.temporaryLocCount = 0;

		for (int i = 0; i < spriteBuffer.length; i++) {
			spriteBuffer[i] = null;
		}
	}

	@ObfuscatedName("aq.d(I)V")
	public void fillBaseLevel(int level) {
		this.minLevel = level;

		for (int x = 0; x < this.maxTileX; x++) {
			for (int z = 0; z < this.maxTileZ; z++) {
				if (this.levelTiles[level][x][z] == null) {
					this.levelTiles[level][x][z] = new Square(level, x, z);
				}
			}
		}
	}

	@ObfuscatedName("aq.l(II)V")
	public void pushDown(int x, int z) {
		Square tile = this.levelTiles[0][x][z];

		for (int i = 0; i < 3; i++) {
			Square var5 = this.levelTiles[i][x][z] = this.levelTiles[i + 1][x][z];
			if (var5 == null) {
				continue;
			}

			var5.level--;

			for (int j = 0; j < var5.spriteCount; j++) {
				Sprite loc = var5.sprites[j];

				if ((loc.typecode >> 29 & 0x3) == 2 && loc.minTileX == x && loc.minTileZ == z) {
					loc.level--;
				}
			}
		}

		if (this.levelTiles[0][x][z] == null) {
			this.levelTiles[0][x][z] = new Square(0, x, z);
		}

		this.levelTiles[0][x][z].linkedSquare = tile;
		this.levelTiles[3][x][z] = null;
	}

	@ObfuscatedName("aq.m(IIIIIIII)V")
	public static void setOcclude(int level, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		Occlude occlude = new Occlude();
		occlude.minTileX = arg2 / 128;
		occlude.maxTileX = arg3 / 128;
		occlude.minTileZ = arg4 / 128;
		occlude.maxTileZ = arg5 / 128;
		occlude.type = arg1;
		occlude.minX = arg2;
		occlude.maxX = arg3;
		occlude.minZ = arg4;
		occlude.maxZ = arg5;
		occlude.minY = arg6;
		occlude.maxY = arg7;
		levelOccluders[level][levelOccluderCount[level]++] = occlude;
	}

	@ObfuscatedName("aq.c(IIII)V")
	public void setDrawLevel(int arg0, int arg1, int arg2, int arg3) {
		Square var5 = this.levelTiles[arg0][arg1][arg2];
		if (var5 != null) {
			this.levelTiles[arg0][arg1][arg2].drawLevel = arg3;
		}
	}

	@ObfuscatedName("aq.n(IIIIIIIIIIIIIIIIIIII)V")
	public void setTile(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18, int arg19) {
		if (arg3 == 0) {
			QuickGround var21 = new QuickGround(arg10, arg11, arg12, arg13, -1, arg18, false);
			for (int var22 = arg0; var22 >= 0; var22--) {
				if (this.levelTiles[var22][arg1][arg2] == null) {
					this.levelTiles[var22][arg1][arg2] = new Square(var22, arg1, arg2);
				}
			}
			this.levelTiles[arg0][arg1][arg2].quickGround = var21;
		} else if (arg3 == 1) {
			QuickGround var23 = new QuickGround(arg14, arg15, arg16, arg17, arg5, arg19, arg6 == arg7 && arg6 == arg8 && arg6 == arg9);
			for (int var24 = arg0; var24 >= 0; var24--) {
				if (this.levelTiles[var24][arg1][arg2] == null) {
					this.levelTiles[var24][arg1][arg2] = new Square(var24, arg1, arg2);
				}
			}
			this.levelTiles[arg0][arg1][arg2].quickGround = var23;
		} else {
			Ground var25 = new Ground(arg3, arg4, arg5, arg1, arg2, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
			for (int var26 = arg0; var26 >= 0; var26--) {
				if (this.levelTiles[var26][arg1][arg2] == null) {
					this.levelTiles[var26][arg1][arg2] = new Square(var26, arg1, arg2);
				}
			}
			this.levelTiles[arg0][arg1][arg2].ground = var25;
		}
	}

	@ObfuscatedName("aq.j(IIIILfu;II)V")
	public void addGroundDecor(int arg0, int arg1, int arg2, int arg3, ModelSource arg4, int arg5, int arg6) {
		if (arg4 == null) {
			return;
		}
		GroundDecor var8 = new GroundDecor();
		var8.model = arg4;
		var8.x = arg1 * 128 + 64;
		var8.z = arg2 * 128 + 64;
		var8.y = arg3;
		var8.typecode = arg5;
		var8.typecode2 = arg6;
		if (this.levelTiles[arg0][arg1][arg2] == null) {
			this.levelTiles[arg0][arg1][arg2] = new Square(arg0, arg1, arg2);
		}
		this.levelTiles[arg0][arg1][arg2].groundDecor = var8;
	}

	@ObfuscatedName("aq.z(IIIILfu;ILfu;Lfu;)V")
	public void addObjStack(int arg0, int arg1, int arg2, int arg3, ModelSource arg4, int arg5, ModelSource arg6, ModelSource arg7) {
		GroundObject var9 = new GroundObject();
		var9.topObj = arg4;
		var9.x = arg1 * 128 + 64;
		var9.z = arg2 * 128 + 64;
		var9.y = arg3;
		var9.typecode = arg5;
		var9.bottomObj = arg6;
		var9.middleObj = arg7;
		int var10 = 0;
		Square var11 = this.levelTiles[arg0][arg1][arg2];
		if (var11 != null) {
			for (int var12 = 0; var12 < var11.spriteCount; var12++) {
				if ((var11.sprites[var12].typecode2 & 0x100) == 0x100 && var11.sprites[var12].model instanceof ModelLit) {
					ModelLit var13 = (ModelLit) var11.sprites[var12].model;
					var13.method3002();
					if (var13.minY > var10) {
						var10 = var13.minY;
					}
				}
			}
		}
		var9.height = var10;
		if (this.levelTiles[arg0][arg1][arg2] == null) {
			this.levelTiles[arg0][arg1][arg2] = new Square(arg0, arg1, arg2);
		}
		this.levelTiles[arg0][arg1][arg2].groundObject = var9;
	}

	@ObfuscatedName("aq.g(IIIILfu;Lfu;IIII)V")
	public void addWall(int arg0, int arg1, int arg2, int arg3, ModelSource arg4, ModelSource arg5, int arg6, int arg7, int arg8, int arg9) {
		if (arg4 == null && arg5 == null) {
			return;
		}
		Wall var11 = new Wall();
		var11.typecode = arg8;
		var11.typecode2 = arg9;
		var11.x = arg1 * 128 + 64;
		var11.z = arg2 * 128 + 64;
		var11.y = arg3;
		var11.modelA = arg4;
		var11.modelB = arg5;
		var11.typeA = arg6;
		var11.typeB = arg7;
		for (int var12 = arg0; var12 >= 0; var12--) {
			if (this.levelTiles[var12][arg1][arg2] == null) {
				this.levelTiles[var12][arg1][arg2] = new Square(var12, arg1, arg2);
			}
		}
		this.levelTiles[arg0][arg1][arg2].wall = var11;
	}

	@ObfuscatedName("aq.q(IIIILfu;Lfu;IIIIII)V")
	public void addDecor(int arg0, int arg1, int arg2, int arg3, ModelSource arg4, ModelSource arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
		if (arg4 == null) {
			return;
		}
		Decor var13 = new Decor();
		var13.typecode = arg10;
		var13.typecode2 = arg11;
		var13.field710 = arg1 * 128 + 64;
		var13.field707 = arg2 * 128 + 64;
		var13.field709 = arg3;
		var13.model = arg4;
		var13.field713 = arg5;
		var13.type = arg6;
		var13.field705 = arg7;
		var13.x = arg8;
		var13.z = arg9;
		for (int var14 = arg0; var14 >= 0; var14--) {
			if (this.levelTiles[var14][arg1][arg2] == null) {
				this.levelTiles[var14][arg1][arg2] = new Square(var14, arg1, arg2);
			}
		}
		this.levelTiles[arg0][arg1][arg2].decor = var13;
	}

	@ObfuscatedName("aq.i(IIIIIILfu;III)Z")
	public boolean add(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, ModelSource arg6, int arg7, int arg8, int arg9) {
		if (arg6 == null) {
			return true;
		} else {
			int var11 = arg1 * 128 + arg4 * 64;
			int var12 = arg2 * 128 + arg5 * 64;
			return this.add(arg0, arg1, arg2, arg4, arg5, var11, var12, arg3, arg6, arg7, false, arg8, arg9);
		}
	}

	@ObfuscatedName("aq.s(IIIIILfu;IIZ)Z")
	public boolean add(int arg0, int arg1, int arg2, int arg3, int arg4, ModelSource arg5, int arg6, int arg7, boolean arg8) {
		if (arg5 == null) {
			return true;
		}
		int var10 = arg1 - arg4;
		int var11 = arg2 - arg4;
		int var12 = arg1 + arg4;
		int var13 = arg2 + arg4;
		if (arg8) {
			if (arg6 > 640 && arg6 < 1408) {
				var13 += 128;
			}
			if (arg6 > 1152 && arg6 < 1920) {
				var12 += 128;
			}
			if (arg6 > 1664 || arg6 < 384) {
				var11 -= 128;
			}
			if (arg6 > 128 && arg6 < 896) {
				var10 -= 128;
			}
		}
		int var14 = var10 / 128;
		int var15 = var11 / 128;
		int var16 = var12 / 128;
		int var17 = var13 / 128;
		return this.add(arg0, var14, var15, var16 - var14 + 1, var17 - var15 + 1, arg1, arg2, arg3, arg5, arg6, true, arg7, 0);
	}

	@ObfuscatedName("aq.u(IIIIILfu;IIIIII)Z")
	public boolean add(int arg0, int arg1, int arg2, int arg3, int arg4, ModelSource arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
		return arg5 == null ? true : this.add(arg0, arg8, arg9, arg10 - arg8 + 1, arg11 - arg9 + 1, arg1, arg2, arg3, arg5, arg6, true, arg7, 0);
	}

	@ObfuscatedName("aq.v(IIIIIIIILfu;IZII)Z")
	public boolean add(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, ModelSource arg8, int arg9, boolean arg10, int arg11, int arg12) {
		for (int var14 = arg1; var14 < arg1 + arg3; var14++) {
			for (int var15 = arg2; var15 < arg2 + arg4; var15++) {
				if (var14 < 0 || var15 < 0 || var14 >= this.maxTileX || var15 >= this.maxTileZ) {
					return false;
				}
				Square var16 = this.levelTiles[arg0][var14][var15];
				if (var16 != null && var16.spriteCount >= 5) {
					return false;
				}
			}
		}
		Sprite var17 = new Sprite();
		var17.typecode = arg11;
		var17.typecode2 = arg12;
		var17.level = arg0;
		var17.x = arg5;
		var17.z = arg6;
		var17.y = arg7;
		var17.model = arg8;
		var17.yaw = arg9;
		var17.minTileX = arg1;
		var17.minTileZ = arg2;
		var17.maxTileX = arg1 + arg3 - 1;
		var17.maxTileZ = arg2 + arg4 - 1;
		for (int var18 = arg1; var18 < arg1 + arg3; var18++) {
			for (int var19 = arg2; var19 < arg2 + arg4; var19++) {
				int var20 = 0;
				if (var18 > arg1) {
					var20++;
				}
				if (var18 < arg1 + arg3 - 1) {
					var20 += 4;
				}
				if (var19 > arg2) {
					var20 += 8;
				}
				if (var19 < arg2 + arg4 - 1) {
					var20 += 2;
				}
				for (int var21 = arg0; var21 >= 0; var21--) {
					if (this.levelTiles[var21][var18][var19] == null) {
						this.levelTiles[var21][var18][var19] = new Square(var21, var18, var19);
					}
				}
				Square var22 = this.levelTiles[arg0][var18][var19];
				var22.sprites[var22.spriteCount] = var17;
				var22.spriteSpan[var22.spriteCount] = var20;
				var22.spriteSpans |= var20;
				var22.spriteCount++;
			}
		}
		if (arg10) {
			this.temporaryLocs[this.temporaryLocCount++] = var17;
		}
		return true;
	}

	@ObfuscatedName("aq.w()V")
	public void removeSprites() {
		for (int var1 = 0; var1 < this.temporaryLocCount; var1++) {
			Sprite var2 = this.temporaryLocs[var1];
			this.removeLoc(var2);
			this.temporaryLocs[var1] = null;
		}
		this.temporaryLocCount = 0;
	}

	@ObfuscatedName("aq.e(Lau;)V")
	public void removeLoc(Sprite arg0) {
		for (int var2 = arg0.minTileX; var2 <= arg0.maxTileX; var2++) {
			for (int var3 = arg0.minTileZ; var3 <= arg0.maxTileZ; var3++) {
				Square var4 = this.levelTiles[arg0.level][var2][var3];
				if (var4 == null) {
					continue;
				}
				for (int var5 = 0; var5 < var4.spriteCount; var5++) {
					if (var4.sprites[var5] == arg0) {
						var4.spriteCount--;
						for (int var6 = var5; var6 < var4.spriteCount; var6++) {
							var4.sprites[var6] = var4.sprites[var6 + 1];
							var4.spriteSpan[var6] = var4.spriteSpan[var6 + 1];
						}
						var4.sprites[var4.spriteCount] = null;
						break;
					}
				}
				var4.spriteSpans = 0;
				for (int var7 = 0; var7 < var4.spriteCount; var7++) {
					var4.spriteSpans |= var4.spriteSpan[var7];
				}
			}
		}
	}

	@ObfuscatedName("aq.b(IIII)V")
	public void setDecorOffset(int arg0, int arg1, int arg2, int arg3) {
		Square var5 = this.levelTiles[arg0][arg1][arg2];
		if (var5 == null) {
			return;
		}
		Decor var6 = var5.decor;
		if (var6 != null) {
			var6.x = var6.x * arg3 / 16;
			var6.z = var6.z * arg3 / 16;
		}
	}

	@ObfuscatedName("aq.y(III)V")
	public void removeWall(int arg0, int arg1, int arg2) {
		Square var4 = this.levelTiles[arg0][arg1][arg2];
		if (var4 != null) {
			var4.wall = null;
		}
	}

	@ObfuscatedName("aq.t(III)V")
	public void removeDecor(int arg0, int arg1, int arg2) {
		Square var4 = this.levelTiles[arg0][arg1][arg2];
		if (var4 != null) {
			var4.decor = null;
		}
	}

	@ObfuscatedName("aq.f(III)V")
	public void removeLoc(int arg0, int arg1, int arg2) {
		Square var4 = this.levelTiles[arg0][arg1][arg2];
		if (var4 == null) {
			return;
		}
		for (int var5 = 0; var5 < var4.spriteCount; var5++) {
			Sprite var6 = var4.sprites[var5];
			if ((var6.typecode >> 29 & 0x3) == 2 && var6.minTileX == arg1 && var6.minTileZ == arg2) {
				this.removeLoc(var6);
				return;
			}
		}
	}

	@ObfuscatedName("aq.k(III)V")
	public void removeGroundDecor(int arg0, int arg1, int arg2) {
		Square var4 = this.levelTiles[arg0][arg1][arg2];
		if (var4 != null) {
			var4.groundDecor = null;
		}
	}

	@ObfuscatedName("aq.o(III)V")
	public void removeObjStacks(int arg0, int arg1, int arg2) {
		Square var4 = this.levelTiles[arg0][arg1][arg2];
		if (var4 != null) {
			var4.groundObject = null;
		}
	}

	@ObfuscatedName("aq.a(III)Lat;")
	public Wall getWall(int arg0, int arg1, int arg2) {
		Square var4 = this.levelTiles[arg0][arg1][arg2];
		return var4 == null ? null : var4.wall;
	}

	@ObfuscatedName("aq.h(III)Lbh;")
	public Decor getDecor(int arg0, int arg1, int arg2) {
		Square var4 = this.levelTiles[arg0][arg1][arg2];
		return var4 == null ? null : var4.decor;
	}

	@ObfuscatedName("aq.x(III)Lau;")
	public Sprite getLoc(int arg0, int arg1, int arg2) {
		Square var4 = this.levelTiles[arg0][arg1][arg2];
		if (var4 == null) {
			return null;
		}
		for (int var5 = 0; var5 < var4.spriteCount; var5++) {
			Sprite var6 = var4.sprites[var5];
			if ((var6.typecode >> 29 & 0x3) == 2 && var6.minTileX == arg1 && var6.minTileZ == arg2) {
				return var6;
			}
		}
		return null;
	}

	@ObfuscatedName("aq.p(III)Laf;")
	public GroundDecor getGroundDecor(int arg0, int arg1, int arg2) {
		Square var4 = this.levelTiles[arg0][arg1][arg2];
		return var4 == null || var4.groundDecor == null ? null : var4.groundDecor;
	}

	@ObfuscatedName("aq.ad(III)I")
	public int wallType(int arg0, int arg1, int arg2) {
		Square var4 = this.levelTiles[arg0][arg1][arg2];
		return var4 == null || var4.wall == null ? 0 : var4.wall.typecode;
	}

	@ObfuscatedName("aq.ac(III)I")
	public int getDecorBitset(int arg0, int arg1, int arg2) {
		Square var4 = this.levelTiles[arg0][arg1][arg2];
		return var4 == null || var4.decor == null ? 0 : var4.decor.typecode;
	}

	@ObfuscatedName("aq.aa(III)I")
	public int sceneType(int arg0, int arg1, int arg2) {
		Square var4 = this.levelTiles[arg0][arg1][arg2];
		if (var4 == null) {
			return 0;
		}
		for (int var5 = 0; var5 < var4.spriteCount; var5++) {
			Sprite var6 = var4.sprites[var5];
			if ((var6.typecode >> 29 & 0x3) == 2 && var6.minTileX == arg1 && var6.minTileZ == arg2) {
				return var6.typecode;
			}
		}
		return 0;
	}

	@ObfuscatedName("aq.as(III)I")
	public int gdType(int arg0, int arg1, int arg2) {
		Square var4 = this.levelTiles[arg0][arg1][arg2];
		return var4 == null || var4.groundDecor == null ? 0 : var4.groundDecor.typecode;
	}

	@ObfuscatedName("aq.am(IIII)I")
	public int typecode2(int arg0, int arg1, int arg2, int arg3) {
		Square var5 = this.levelTiles[arg0][arg1][arg2];
		if (var5 == null) {
			return -1;
		} else if (var5.wall != null && var5.wall.typecode == arg3) {
			return var5.wall.typecode2 & 0xFF;
		} else if (var5.decor != null && var5.decor.typecode == arg3) {
			return var5.decor.typecode2 & 0xFF;
		} else if (var5.groundDecor != null && var5.groundDecor.typecode == arg3) {
			return var5.groundDecor.typecode2 & 0xFF;
		} else {
			for (int var6 = 0; var6 < var5.spriteCount; var6++) {
				if (var5.sprites[var6].typecode == arg3) {
					return var5.sprites[var6].typecode2 & 0xFF;
				}
			}
			return -1;
		}
	}

	@ObfuscatedName("aq.ap(III)V")
	public void buildModels(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < this.maxLevel; var4++) {
			for (int var5 = 0; var5 < this.maxTileX; var5++) {
				for (int var6 = 0; var6 < this.maxTileZ; var6++) {
					Square var7 = this.levelTiles[var4][var5][var6];
					if (var7 == null) {
						continue;
					}
					Wall var8 = var7.wall;
					if (var8 != null && var8.modelA instanceof ModelUnlit) {
						ModelUnlit var9 = (ModelUnlit) var8.modelA;
						this.mergeLocNormals(var9, var4, var5, var6, 1, 1);
						if (var8.modelB instanceof ModelUnlit) {
							ModelUnlit var10 = (ModelUnlit) var8.modelB;
							this.mergeLocNormals(var10, var4, var5, var6, 1, 1);
							ModelUnlit.mergeNormals(var9, var10, 0, 0, 0, false);
							var8.modelB = var10.calculateNormals(var10.field2708, var10.field2706, arg0, arg1, arg2);
						}
						var8.modelA = var9.calculateNormals(var9.field2708, var9.field2706, arg0, arg1, arg2);
					}
					for (int var11 = 0; var11 < var7.spriteCount; var11++) {
						Sprite var12 = var7.sprites[var11];
						if (var12 != null && var12.model instanceof ModelUnlit) {
							ModelUnlit var13 = (ModelUnlit) var12.model;
							this.mergeLocNormals(var13, var4, var5, var6, var12.maxTileX - var12.minTileX + 1, var12.maxTileZ - var12.minTileZ + 1);
							var12.model = var13.calculateNormals(var13.field2708, var13.field2706, arg0, arg1, arg2);
						}
					}
					GroundDecor var14 = var7.groundDecor;
					if (var14 != null && var14.model instanceof ModelUnlit) {
						ModelUnlit var15 = (ModelUnlit) var14.model;
						this.mergeGroundDecorNormals(var15, var4, var5, var6);
						var14.model = var15.calculateNormals(var15.field2708, var15.field2706, arg0, arg1, arg2);
					}
				}
			}
		}
	}

	@ObfuscatedName("aq.av(Lfw;III)V")
	public void mergeGroundDecorNormals(ModelUnlit arg0, int arg1, int arg2, int arg3) {
		if (arg2 < this.maxTileX) {
			Square var5 = this.levelTiles[arg1][arg2 + 1][arg3];
			if (var5 != null && var5.groundDecor != null && var5.groundDecor.model instanceof ModelUnlit) {
				ModelUnlit var6 = (ModelUnlit) var5.groundDecor.model;
				ModelUnlit.mergeNormals(arg0, var6, 128, 0, 0, true);
			}
		}
		if (arg3 < this.maxTileX) {
			Square var7 = this.levelTiles[arg1][arg2][arg3 + 1];
			if (var7 != null && var7.groundDecor != null && var7.groundDecor.model instanceof ModelUnlit) {
				ModelUnlit var8 = (ModelUnlit) var7.groundDecor.model;
				ModelUnlit.mergeNormals(arg0, var8, 0, 0, 128, true);
			}
		}
		if (arg2 < this.maxTileX && arg3 < this.maxTileZ) {
			Square var9 = this.levelTiles[arg1][arg2 + 1][arg3 + 1];
			if (var9 != null && var9.groundDecor != null && var9.groundDecor.model instanceof ModelUnlit) {
				ModelUnlit var10 = (ModelUnlit) var9.groundDecor.model;
				ModelUnlit.mergeNormals(arg0, var10, 128, 0, 128, true);
			}
		}
		if (arg2 >= this.maxTileX || arg3 <= 0) {
			return;
		}
		Square var11 = this.levelTiles[arg1][arg2 + 1][arg3 - 1];
		if (var11 != null && var11.groundDecor != null && var11.groundDecor.model instanceof ModelUnlit) {
			ModelUnlit var12 = (ModelUnlit) var11.groundDecor.model;
			ModelUnlit.mergeNormals(arg0, var12, 128, 0, -128, true);
		}
	}

	@ObfuscatedName("aq.ak(Lfw;IIIII)V")
	public void mergeLocNormals(ModelUnlit arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		boolean var7 = true;
		int var8 = arg2;
		int var9 = arg2 + arg4;
		int var10 = arg3 - 1;
		int var11 = arg3 + arg5;
		for (int var12 = arg1; var12 <= arg1 + 1; var12++) {
			if (this.maxLevel == var12) {
				continue;
			}
			for (int var13 = var8; var13 <= var9; var13++) {
				if (var13 < 0 || var13 >= this.maxTileX) {
					continue;
				}
				for (int var14 = var10; var14 <= var11; var14++) {
					if (var14 < 0 || var14 >= this.maxTileZ || (var7 && var13 < var9 && var14 < var11 && (var14 >= arg3 || arg2 == var13))) {
						continue;
					}
					Square var15 = this.levelTiles[var12][var13][var14];
					if (var15 == null) {
						continue;
					}
					int var16 = (this.groundh[var12][var13 + 1][var14] + this.groundh[var12][var13][var14] + this.groundh[var12][var13][var14 + 1] + this.groundh[var12][var13 + 1][var14 + 1]) / 4 - (this.groundh[arg1][arg2 + 1][arg3] + this.groundh[arg1][arg2][arg3] + this.groundh[arg1][arg2][arg3 + 1] + this.groundh[arg1][arg2 + 1][arg3 + 1]) / 4;
					Wall var17 = var15.wall;
					if (var17 != null) {
						if (var17.modelA instanceof ModelUnlit) {
							ModelUnlit var18 = (ModelUnlit) var17.modelA;
							ModelUnlit.mergeNormals(arg0, var18, (var13 - arg2) * 128 + (1 - arg4) * 64, var16, (var14 - arg3) * 128 + (1 - arg5) * 64, var7);
						}
						if (var17.modelB instanceof ModelUnlit) {
							ModelUnlit var19 = (ModelUnlit) var17.modelB;
							ModelUnlit.mergeNormals(arg0, var19, (var13 - arg2) * 128 + (1 - arg4) * 64, var16, (var14 - arg3) * 128 + (1 - arg5) * 64, var7);
						}
					}
					for (int var20 = 0; var20 < var15.spriteCount; var20++) {
						Sprite var21 = var15.sprites[var20];
						if (var21 != null && var21.model instanceof ModelUnlit) {
							ModelUnlit var22 = (ModelUnlit) var21.model;
							int var23 = var21.maxTileX - var21.minTileX + 1;
							int var24 = var21.maxTileZ - var21.minTileZ + 1;
							ModelUnlit.mergeNormals(arg0, var22, (var21.minTileX - arg2) * 128 + (var23 - arg4) * 64, var16, (var21.minTileZ - arg3) * 128 + (var24 - arg5) * 64, var7);
						}
					}
				}
			}
			var8--;
			var7 = false;
		}
	}

	@ObfuscatedName("aq.az([IIIIII)V")
	public void render2DGround(int[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		Square var7 = this.levelTiles[arg3][arg4][arg5];
		if (var7 == null) {
			return;
		}
		QuickGround var8 = var7.quickGround;
		if (var8 != null) {
			int var9 = var8.minimapRgb;
			if (var9 != 0) {
				for (int var10 = 0; var10 < 4; var10++) {
					arg0[arg1] = var9;
					arg0[arg1 + 1] = var9;
					arg0[arg1 + 2] = var9;
					arg0[arg1 + 3] = var9;
					arg1 += arg2;
				}
			}
			return;
		}
		Ground var11 = var7.ground;
		if (var11 == null) {
			return;
		}
		int var12 = var11.overlayShape;
		int var13 = var11.overlayRotation;
		int var14 = var11.minimapOverlay;
		int var15 = var11.minimapUnderlay;
		int[] var16 = this.MINIMAP_OVERLAY_SHAPE[var12];
		int[] var17 = this.MINIMAP_OVERLAY_ROTATION[var13];
		int var18 = 0;
		if (var14 != 0) {
			for (int var19 = 0; var19 < 4; var19++) {
				arg0[arg1] = var16[var17[var18++]] == 0 ? var14 : var15;
				arg0[arg1 + 1] = var16[var17[var18++]] == 0 ? var14 : var15;
				arg0[arg1 + 2] = var16[var17[var18++]] == 0 ? var14 : var15;
				arg0[arg1 + 3] = var16[var17[var18++]] == 0 ? var14 : var15;
				arg1 += arg2;
			}
			return;
		}
		for (int var20 = 0; var20 < 4; var20++) {
			if (var16[var17[var18++]] != 0) {
				arg0[arg1] = var15;
			}
			if (var16[var17[var18++]] != 0) {
				arg0[arg1 + 1] = var15;
			}
			if (var16[var17[var18++]] != 0) {
				arg0[arg1 + 2] = var15;
			}
			if (var16[var17[var18++]] != 0) {
				arg0[arg1 + 3] = var15;
			}
			arg1 += arg2;
		}
	}

	@ObfuscatedName("aq.an([IIIII)V")
	public static void init(int[] arg0, int arg1, int arg2, int arg3, int arg4) {
		viewportLeft = 0;
		viewportTop = 0;
		viewportRight = arg3;
		viewportBottom = arg4;
		viewportCenterX = arg3 / 2;
		viewportCenterY = arg4 / 2;
		boolean[][][][] var5 = new boolean[9][32][53][53];
		for (int var6 = 128; var6 <= 384; var6 += 32) {
			for (int var7 = 0; var7 < 2048; var7 += 64) {
				cameraSinX = Pix3D.sinTable[var6];
				cameraCosX = Pix3D.cosTable[var6];
				cameraSinY = Pix3D.sinTable[var7];
				cameraCosY = Pix3D.cosTable[var7];
				int var8 = (var6 - 128) / 32;
				int var9 = var7 / 64;
				for (int var10 = -26; var10 <= 26; var10++) {
					for (int var11 = -26; var11 <= 26; var11++) {
						int var12 = var10 * 128;
						int var13 = var11 * 128;
						boolean var14 = false;
						for (int var15 = -arg1; var15 <= arg2; var15 += 128) {
							if (testPoint(var12, arg0[var8] + var15, var13)) {
								var14 = true;
								break;
							}
						}
						var5[var8][var9][var10 + 25 + 1][var11 + 25 + 1] = var14;
					}
				}
			}
		}
		for (int var16 = 0; var16 < 8; var16++) {
			for (int var17 = 0; var17 < 32; var17++) {
				for (int var18 = -25; var18 < 25; var18++) {
					for (int var19 = -25; var19 < 25; var19++) {
						boolean var20 = false;
						label76:
						for (int var21 = -1; var21 <= 1; var21++) {
							for (int var22 = -1; var22 <= 1; var22++) {
								if (var5[var16][var17][var18 + var21 + 25 + 1][var19 + var22 + 25 + 1]) {
									var20 = true;
									break label76;
								}
								if (var5[var16][(var17 + 1) % 31][var18 + var21 + 25 + 1][var19 + var22 + 25 + 1]) {
									var20 = true;
									break label76;
								}
								if (var5[var16 + 1][var17][var18 + var21 + 25 + 1][var19 + var22 + 25 + 1]) {
									var20 = true;
									break label76;
								}
								if (var5[var16 + 1][(var17 + 1) % 31][var18 + var21 + 25 + 1][var19 + var22 + 25 + 1]) {
									var20 = true;
									break label76;
								}
							}
						}
						visibilityMatrix[var16][var17][var18 + 25][var19 + 25] = var20;
					}
				}
			}
		}
	}

	@ObfuscatedName("aq.ah(III)Z")
	public static boolean testPoint(int arg0, int arg1, int arg2) {
		int var3 = cameraCosY * arg0 + cameraSinY * arg2 >> 16;
		int var4 = cameraCosY * arg2 - cameraSinY * arg0 >> 16;
		int var5 = cameraSinX * arg1 + cameraCosX * var4 >> 16;
		int var6 = cameraCosX * arg1 - cameraSinX * var4 >> 16;
		if (var5 >= 50 && var5 <= 3500) {
			int var7 = (var3 << 9) / var5 + viewportCenterX;
			int var8 = (var6 << 9) / var5 + viewportCenterY;
			return var7 >= viewportLeft && var7 <= viewportRight && var8 >= viewportTop && var8 <= viewportBottom;
		} else {
			return false;
		}
	}

	@ObfuscatedName("aq.ay(III)V")
	public void click(int arg0, int arg1, int arg2) {
		takingInput = true;
		clickLevel = arg0;
		mouseX = arg1;
		mouseY = arg2;
		groundX = -1;
		groundZ = -1;
	}

	@ObfuscatedName("aq.al(IIIIII)V")
	public void renderAll(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		if (arg0 < 0) {
			arg0 = 0;
		} else if (arg0 >= this.maxTileX * 128) {
			arg0 = this.maxTileX * 128 - 1;
		}
		if (arg2 < 0) {
			arg2 = 0;
		} else if (arg2 >= this.maxTileZ * 128) {
			arg2 = this.maxTileZ * 128 - 1;
		}
		cycle++;
		cameraSinX = Pix3D.sinTable[arg3];
		cameraCosX = Pix3D.cosTable[arg3];
		cameraSinY = Pix3D.sinTable[arg4];
		cameraCosY = Pix3D.cosTable[arg4];
		visibilityMap = visibilityMatrix[(arg3 - 128) / 32][arg4 / 64];
		cx = arg0;
		cy = arg1;
		cz = arg2;
		gx = arg0 / 128;
		gz = arg2 / 128;
		topLevel = arg5;
		minDrawTileX = gx - 25;
		if (minDrawTileX < 0) {
			minDrawTileX = 0;
		}
		minDrawTileZ = gz - 25;
		if (minDrawTileZ < 0) {
			minDrawTileZ = 0;
		}
		maxDrawTileX = gx + 25;
		if (maxDrawTileX > this.maxTileX) {
			maxDrawTileX = this.maxTileX;
		}
		maxDrawTileZ = gz + 25;
		if (maxDrawTileZ > this.maxTileZ) {
			maxDrawTileZ = this.maxTileZ;
		}
		this.updateActiveOccluders();
		fillLeft = 0;
		for (int var7 = this.minLevel; var7 < this.maxLevel; var7++) {
			Square[][] var8 = this.levelTiles[var7];
			for (int var9 = minDrawTileX; var9 < maxDrawTileX; var9++) {
				for (int var10 = minDrawTileZ; var10 < maxDrawTileZ; var10++) {
					Square var11 = var8[var9][var10];
					if (var11 == null) {
						continue;
					}
					if (var11.drawLevel <= arg5 && (visibilityMap[var9 - gx + 25][var10 - gz + 25] || this.groundh[var7][var9][var10] - arg1 >= 2000)) {
						var11.drawFront = true;
						var11.drawBack = true;
						if (var11.spriteCount > 0) {
							var11.drawSprites = true;
						} else {
							var11.drawSprites = false;
						}
						fillLeft++;
					} else {
						var11.drawFront = false;
						var11.drawBack = false;
						var11.checkLocSpans = 0;
					}
				}
			}
		}
		for (int var12 = this.minLevel; var12 < this.maxLevel; var12++) {
			Square[][] var13 = this.levelTiles[var12];
			for (int var14 = -25; var14 <= 0; var14++) {
				int var15 = gx + var14;
				int var16 = gx - var14;
				if (var15 < minDrawTileX && var16 >= maxDrawTileX) {
					continue;
				}
				for (int var17 = -25; var17 <= 0; var17++) {
					int var18 = gz + var17;
					int var19 = gz - var17;
					if (var15 >= minDrawTileX) {
						if (var18 >= minDrawTileZ) {
							Square var20 = var13[var15][var18];
							if (var20 != null && var20.drawFront) {
								this.fill(var20, true);
							}
						}
						if (var19 < maxDrawTileZ) {
							Square var21 = var13[var15][var19];
							if (var21 != null && var21.drawFront) {
								this.fill(var21, true);
							}
						}
					}
					if (var16 < maxDrawTileX) {
						if (var18 >= minDrawTileZ) {
							Square var22 = var13[var16][var18];
							if (var22 != null && var22.drawFront) {
								this.fill(var22, true);
							}
						}
						if (var19 < maxDrawTileZ) {
							Square var23 = var13[var16][var19];
							if (var23 != null && var23.drawFront) {
								this.fill(var23, true);
							}
						}
					}
					if (fillLeft == 0) {
						takingInput = false;
						return;
					}
				}
			}
		}
		for (int var24 = this.minLevel; var24 < this.maxLevel; var24++) {
			Square[][] var25 = this.levelTiles[var24];
			for (int var26 = -25; var26 <= 0; var26++) {
				int var27 = gx + var26;
				int var28 = gx - var26;
				if (var27 >= minDrawTileX || var28 < maxDrawTileX) {
					for (int var29 = -25; var29 <= 0; var29++) {
						int var30 = gz + var29;
						int var31 = gz - var29;
						if (var27 >= minDrawTileX) {
							if (var30 >= minDrawTileZ) {
								Square var32 = var25[var27][var30];
								if (var32 != null && var32.drawFront) {
									this.fill(var32, false);
								}
							}
							if (var31 < maxDrawTileZ) {
								Square var33 = var25[var27][var31];
								if (var33 != null && var33.drawFront) {
									this.fill(var33, false);
								}
							}
						}
						if (var28 < maxDrawTileX) {
							if (var30 >= minDrawTileZ) {
								Square var34 = var25[var28][var30];
								if (var34 != null && var34.drawFront) {
									this.fill(var34, false);
								}
							}
							if (var31 < maxDrawTileZ) {
								Square var35 = var25[var28][var31];
								if (var35 != null && var35.drawFront) {
									this.fill(var35, false);
								}
							}
						}
						if (fillLeft == 0) {
							takingInput = false;
							return;
						}
					}
				}
			}
		}
		takingInput = false;
	}

	@ObfuscatedName("aq.ab(Les;Z)V")
	public void fill(Square arg0, boolean arg1) {
		fillQueue.push(arg0);
		while (true) {
			Square var3;
			int var4;
			int var5;
			int var6;
			int var7;
			Square[][] var8;
			Square var67;
			do {
				Square var66;
				do {
					Square var65;
					do {
						Square var64;
						do {
							do {
								do {
									while (true) {
										while (true) {
											do {
												var3 = (Square) fillQueue.pop();
												if (var3 == null) {
													return;
												}
											} while (!var3.drawBack);
											var4 = var3.x;
											var5 = var3.z;
											var6 = var3.level;
											var7 = var3.originalLevel;
											var8 = this.levelTiles[var6];
											if (!var3.drawFront) {
												break;
											}
											if (arg1) {
												if (var6 > 0) {
													Square var9 = this.levelTiles[var6 - 1][var4][var5];
													if (var9 != null && var9.drawBack) {
														continue;
													}
												}
												if (var4 <= gx && var4 > minDrawTileX) {
													Square var10 = var8[var4 - 1][var5];
													if (var10 != null && var10.drawBack && (var10.drawFront || (var3.spriteSpans & 0x1) == 0)) {
														continue;
													}
												}
												if (var4 >= gx && var4 < maxDrawTileX - 1) {
													Square var11 = var8[var4 + 1][var5];
													if (var11 != null && var11.drawBack && (var11.drawFront || (var3.spriteSpans & 0x4) == 0)) {
														continue;
													}
												}
												if (var5 <= gz && var5 > minDrawTileZ) {
													Square var12 = var8[var4][var5 - 1];
													if (var12 != null && var12.drawBack && (var12.drawFront || (var3.spriteSpans & 0x8) == 0)) {
														continue;
													}
												}
												if (var5 >= gz && var5 < maxDrawTileZ - 1) {
													Square var13 = var8[var4][var5 + 1];
													if (var13 != null && var13.drawBack && (var13.drawFront || (var3.spriteSpans & 0x2) == 0)) {
														continue;
													}
												}
											} else {
												arg1 = true;
											}
											var3.drawFront = false;
											if (var3.linkedSquare != null) {
												Square var14 = var3.linkedSquare;
												if (var14.quickGround == null) {
													if (var14.ground != null && !this.tileVisible(0, var4, var5)) {
														this.drawTileOverlay(var14.ground, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var4, var5);
													}
												} else if (!this.tileVisible(0, var4, var5)) {
													this.drawTileUnderlay(var14.quickGround, 0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var4, var5);
												}
												Wall var15 = var14.wall;
												if (var15 != null) {
													var15.modelA.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var15.x - cx, var15.y - cy, var15.z - cz, var15.typecode);
												}
												for (int var16 = 0; var16 < var14.spriteCount; var16++) {
													Sprite var17 = var14.sprites[var16];
													if (var17 != null) {
														var17.model.worldRender(var17.yaw, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var17.x - cx, var17.y - cy, var17.z - cz, var17.typecode);
													}
												}
											}
											boolean var18 = false;
											if (var3.quickGround == null) {
												if (var3.ground != null && !this.tileVisible(var7, var4, var5)) {
													var18 = true;
													this.drawTileOverlay(var3.ground, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var4, var5);
												}
											} else if (!this.tileVisible(var7, var4, var5)) {
												var18 = true;
												if (var3.quickGround.colourNE != 12345678 || takingInput && var6 <= clickLevel) {
													this.drawTileUnderlay(var3.quickGround, var7, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var4, var5);
												}
											}
											int var19 = 0;
											int var20 = 0;
											Wall var21 = var3.wall;
											Decor var22 = var3.decor;
											if (var21 != null || var22 != null) {
												if (gx == var4) {
													var19++;
												} else if (gx < var4) {
													var19 += 2;
												}
												if (gz == var5) {
													var19 += 3;
												} else if (gz > var5) {
													var19 += 6;
												}
												var20 = FRONT_WALL_TYPES[var19];
												var3.backWallTypes = BACK_WALL_TYPES[var19];
											}
											if (var21 != null) {
												if ((var21.typeA & DIRECTION_ALLOW_WALL_CORNER_TYPE[var19]) == 0) {
													var3.checkLocSpans = 0;
												} else if (var21.typeA == 16) {
													var3.checkLocSpans = 3;
													var3.blockLocSpans = WALL_CORNER_TYPE_16_BLOCK_LOC_SPANS[var19];
													var3.inverseBlockLocSpans = 3 - var3.blockLocSpans;
												} else if (var21.typeA == 32) {
													var3.checkLocSpans = 6;
													var3.blockLocSpans = WALL_CORNER_TYPE_32_BLOCK_LOC_SPANS[var19];
													var3.inverseBlockLocSpans = 6 - var3.blockLocSpans;
												} else if (var21.typeA == 64) {
													var3.checkLocSpans = 12;
													var3.blockLocSpans = WALL_CORNER_TYPE_64_BLOCK_LOC_SPANS[var19];
													var3.inverseBlockLocSpans = 12 - var3.blockLocSpans;
												} else {
													var3.checkLocSpans = 9;
													var3.blockLocSpans = WALL_CORNER_TYPE_128_BLOCK_LOC_SPANS[var19];
													var3.inverseBlockLocSpans = 9 - var3.blockLocSpans;
												}
												if ((var21.typeA & var20) != 0 && !this.wallVisible(var7, var4, var5, var21.typeA)) {
													var21.modelA.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var21.x - cx, var21.y - cy, var21.z - cz, var21.typecode);
												}
												if ((var21.typeB & var20) != 0 && !this.wallVisible(var7, var4, var5, var21.typeB)) {
													var21.modelB.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var21.x - cx, var21.y - cy, var21.z - cz, var21.typecode);
												}
											}
											if (var22 != null && !this.visible(var7, var4, var5, var22.model.minY)) {
												if ((var22.type & var20) != 0) {
													var22.model.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var22.x + (var22.field710 - cx), var22.field709 - cy, var22.z + (var22.field707 - cz), var22.typecode);
												} else if (var22.type == 256) {
													int var23 = var22.field710 - cx;
													int var24 = var22.field709 - cy;
													int var25 = var22.field707 - cz;
													int var26 = var22.field705;
													int var27;
													if (var26 == 1 || var26 == 2) {
														var27 = -var23;
													} else {
														var27 = var23;
													}
													int var28;
													if (var26 == 2 || var26 == 3) {
														var28 = -var25;
													} else {
														var28 = var25;
													}
													if (var28 < var27) {
														var22.model.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var22.x + var23, var24, var22.z + var25, var22.typecode);
													} else if (var22.field713 != null) {
														var22.field713.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var23, var24, var25, var22.typecode);
													}
												}
											}
											if (var18) {
												GroundDecor var29 = var3.groundDecor;
												if (var29 != null) {
													var29.model.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var29.x - cx, var29.y - cy, var29.z - cz, var29.typecode);
												}
												GroundObject var30 = var3.groundObject;
												if (var30 != null && var30.height == 0) {
													if (var30.bottomObj != null) {
														var30.bottomObj.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var30.x - cx, var30.y - cy, var30.z - cz, var30.typecode);
													}
													if (var30.middleObj != null) {
														var30.middleObj.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var30.x - cx, var30.y - cy, var30.z - cz, var30.typecode);
													}
													if (var30.topObj != null) {
														var30.topObj.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var30.x - cx, var30.y - cy, var30.z - cz, var30.typecode);
													}
												}
											}
											int var31 = var3.spriteSpans;
											if (var31 != 0) {
												if (var4 < gx && (var31 & 0x4) != 0) {
													Square var32 = var8[var4 + 1][var5];
													if (var32 != null && var32.drawBack) {
														fillQueue.push(var32);
													}
												}
												if (var5 < gz && (var31 & 0x2) != 0) {
													Square var33 = var8[var4][var5 + 1];
													if (var33 != null && var33.drawBack) {
														fillQueue.push(var33);
													}
												}
												if (var4 > gx && (var31 & 0x1) != 0) {
													Square var34 = var8[var4 - 1][var5];
													if (var34 != null && var34.drawBack) {
														fillQueue.push(var34);
													}
												}
												if (var5 > gz && (var31 & 0x8) != 0) {
													Square var35 = var8[var4][var5 - 1];
													if (var35 != null && var35.drawBack) {
														fillQueue.push(var35);
													}
												}
											}
											break;
										}
										if (var3.checkLocSpans != 0) {
											boolean var36 = true;
											for (int var37 = 0; var37 < var3.spriteCount; var37++) {
												if (var3.sprites[var37].cycle != cycle && (var3.spriteSpan[var37] & var3.checkLocSpans) == var3.blockLocSpans) {
													var36 = false;
													break;
												}
											}
											if (var36) {
												Wall var38 = var3.wall;
												if (!this.wallVisible(var7, var4, var5, var38.typeA)) {
													var38.modelA.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var38.x - cx, var38.y - cy, var38.z - cz, var38.typecode);
												}
												var3.checkLocSpans = 0;
											}
										}
										if (!var3.drawSprites) {
											break;
										}
										try {
											int var39 = var3.spriteCount;
											var3.drawSprites = false;
											int var40 = 0;
											label563:
											for (int var41 = 0; var41 < var39; var41++) {
												Sprite var42 = var3.sprites[var41];
												if (var42.cycle != cycle) {
													for (int var43 = var42.minTileX; var43 <= var42.maxTileX; var43++) {
														for (int var44 = var42.minTileZ; var44 <= var42.maxTileZ; var44++) {
															Square var45 = var8[var43][var44];
															if (var45.drawFront) {
																var3.drawSprites = true;
																continue label563;
															}
															if (var45.checkLocSpans != 0) {
																int var46 = 0;
																if (var43 > var42.minTileX) {
																	var46++;
																}
																if (var43 < var42.maxTileX) {
																	var46 += 4;
																}
																if (var44 > var42.minTileZ) {
																	var46 += 8;
																}
																if (var44 < var42.maxTileZ) {
																	var46 += 2;
																}
																if ((var46 & var45.checkLocSpans) == var3.inverseBlockLocSpans) {
																	var3.drawSprites = true;
																	continue label563;
																}
															}
														}
													}
													spriteBuffer[var40++] = var42;
													int var47 = gx - var42.minTileX;
													int var48 = var42.maxTileX - gx;
													if (var48 > var47) {
														var47 = var48;
													}
													int var49 = gz - var42.minTileZ;
													int var50 = var42.maxTileZ - gz;
													if (var50 > var49) {
														var42.distance = var47 + var50;
													} else {
														var42.distance = var47 + var49;
													}
												}
											}
											while (var40 > 0) {
												int var51 = -50;
												int var52 = -1;
												for (int var53 = 0; var53 < var40; var53++) {
													Sprite var54 = spriteBuffer[var53];
													if (var54.cycle != cycle) {
														if (var54.distance > var51) {
															var51 = var54.distance;
															var52 = var53;
														} else if (var54.distance == var51) {
															int var55 = var54.x - cx;
															int var56 = var54.z - cz;
															int var57 = spriteBuffer[var52].x - cx;
															int var58 = spriteBuffer[var52].z - cz;
															if (var55 * var55 + var56 * var56 > var57 * var57 + var58 * var58) {
																var52 = var53;
															}
														}
													}
												}
												if (var52 == -1) {
													break;
												}
												Sprite var59 = spriteBuffer[var52];
												var59.cycle = cycle;
												if (!this.method671(var7, var59.minTileX, var59.maxTileX, var59.minTileZ, var59.maxTileZ, var59.model.minY)) {
													var59.model.worldRender(var59.yaw, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var59.x - cx, var59.y - cy, var59.z - cz, var59.typecode);
												}
												for (int var60 = var59.minTileX; var60 <= var59.maxTileX; var60++) {
													for (int var61 = var59.minTileZ; var61 <= var59.maxTileZ; var61++) {
														Square var62 = var8[var60][var61];
														if (var62.checkLocSpans != 0) {
															fillQueue.push(var62);
														} else if ((var4 != var60 || var5 != var61) && var62.drawBack) {
															fillQueue.push(var62);
														}
													}
												}
											}
											if (!var3.drawSprites) {
												break;
											}
										} catch (Exception var82) {
											var3.drawSprites = false;
											break;
										}
									}
								} while (!var3.drawBack);
							} while (var3.checkLocSpans != 0);
							if (var4 > gx || var4 <= minDrawTileX) {
								break;
							}
							var64 = var8[var4 - 1][var5];
						} while (var64 != null && var64.drawBack);
						if (var4 < gx || var4 >= maxDrawTileX - 1) {
							break;
						}
						var65 = var8[var4 + 1][var5];
					} while (var65 != null && var65.drawBack);
					if (var5 > gz || var5 <= minDrawTileZ) {
						break;
					}
					var66 = var8[var4][var5 - 1];
				} while (var66 != null && var66.drawBack);
				if (var5 < gz || var5 >= maxDrawTileZ - 1) {
					break;
				}
				var67 = var8[var4][var5 + 1];
			} while (var67 != null && var67.drawBack);
			var3.drawBack = false;
			fillLeft--;
			GroundObject var68 = var3.groundObject;
			if (var68 != null && var68.height != 0) {
				if (var68.bottomObj != null) {
					var68.bottomObj.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var68.x - cx, var68.y - cy - var68.height, var68.z - cz, var68.typecode);
				}
				if (var68.middleObj != null) {
					var68.middleObj.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var68.x - cx, var68.y - cy - var68.height, var68.z - cz, var68.typecode);
				}
				if (var68.topObj != null) {
					var68.topObj.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var68.x - cx, var68.y - cy - var68.height, var68.z - cz, var68.typecode);
				}
			}
			if (var3.backWallTypes != 0) {
				Decor var69 = var3.decor;
				if (var69 != null && !this.visible(var7, var4, var5, var69.model.minY)) {
					if ((var69.type & var3.backWallTypes) != 0) {
						var69.model.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var69.x + (var69.field710 - cx), var69.field709 - cy, var69.z + (var69.field707 - cz), var69.typecode);
					} else if (var69.type == 0x100) {
						int var70 = var69.field710 - cx;
						int var71 = var69.field709 - cy;
						int var72 = var69.field707 - cz;
						int var73 = var69.field705;
						int var74;
						if (var73 == 1 || var73 == 2) {
							var74 = -var70;
						} else {
							var74 = var70;
						}
						int var75;
						if (var73 == 2 || var73 == 3) {
							var75 = -var72;
						} else {
							var75 = var72;
						}
						if (var75 >= var74) {
							var69.model.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var69.x + var70, var71, var69.z + var72, var69.typecode);
						} else if (var69.field713 != null) {
							var69.field713.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var70, var71, var72, var69.typecode);
						}
					}
				}
				Wall var76 = var3.wall;
				if (var76 != null) {
					if ((var76.typeB & var3.backWallTypes) != 0 && !this.wallVisible(var7, var4, var5, var76.typeB)) {
						var76.modelB.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var76.x - cx, var76.y - cy, var76.z - cz, var76.typecode);
					}
					if ((var76.typeA & var3.backWallTypes) != 0 && !this.wallVisible(var7, var4, var5, var76.typeA)) {
						var76.modelA.worldRender(0, cameraSinX, cameraCosX, cameraSinY, cameraCosY, var76.x - cx, var76.y - cy, var76.z - cz, var76.typecode);
					}
				}
			}
			if (var6 < this.maxLevel - 1) {
				Square var77 = this.levelTiles[var6 + 1][var4][var5];
				if (var77 != null && var77.drawBack) {
					fillQueue.push(var77);
				}
			}
			if (var4 < gx) {
				Square var78 = var8[var4 + 1][var5];
				if (var78 != null && var78.drawBack) {
					fillQueue.push(var78);
				}
			}
			if (var5 < gz) {
				Square var79 = var8[var4][var5 + 1];
				if (var79 != null && var79.drawBack) {
					fillQueue.push(var79);
				}
			}
			if (var4 > gx) {
				Square var80 = var8[var4 - 1][var5];
				if (var80 != null && var80.drawBack) {
					fillQueue.push(var80);
				}
			}
			if (var5 > gz) {
				Square var81 = var8[var4][var5 - 1];
				if (var81 != null && var81.drawBack) {
					fillQueue.push(var81);
				}
			}
		}
	}

	@ObfuscatedName("aq.ao(Lai;IIIIIII)V")
	public void drawTileUnderlay(QuickGround underlay, int level, int arg2, int arg3, int arg4, int arg5, int tileX, int tileZ) {
		int var9;
		int var10 = var9 = (tileX << 7) - cx;
		int var11;
		int var12 = var11 = (tileZ << 7) - cz;
		int var13;
		int var14 = var13 = var10 + 128;
		int var15;
		int var16 = var15 = var12 + 128;

		int y0 = this.groundh[level][tileX][tileZ] - cy;
		int y1 = this.groundh[level][tileX + 1][tileZ] - cy;
		int y2 = this.groundh[level][tileX + 1][tileZ + 1] - cy;
		int y3 = this.groundh[level][tileX][tileZ + 1] - cy;

		int var21 = arg4 * var12 + arg5 * var10 >> 16;
		int var22 = arg5 * var12 - arg4 * var10 >> 16;
		int var24 = arg3 * y0 - arg2 * var22 >> 16;
		int z0 = arg2 * y0 + arg3 * var22 >> 16;

		if (z0 < 50) {
			return;
		}

		int var27 = arg4 * var11 + arg5 * var14 >> 16;
		int var28 = arg5 * var11 - arg4 * var14 >> 16;
		int var30 = arg3 * y1 - arg2 * var28 >> 16;
		int z1 = arg2 * y1 + arg3 * var28 >> 16;

		if (z1 < 50) {
			return;
		}

		int var33 = arg4 * var16 + arg5 * var13 >> 16;
		int var34 = arg5 * var16 - arg4 * var13 >> 16;
		int var36 = arg3 * y2 - arg2 * var34 >> 16;
		int z2 = arg2 * y2 + arg3 * var34 >> 16;

		if (z2 < 50) {
			return;
		}

		int var39 = arg4 * var15 + arg5 * var9 >> 16;
		int var40 = arg5 * var15 - arg4 * var9 >> 16;
		int var42 = arg3 * y3 - arg2 * var40 >> 16;
		int z3 = arg2 * y3 + arg3 * var40 >> 16;

		if (z3 < 50) {
			return;
		}

		int px0 = (var21 << 9) / z0 + Pix3D.originX;
		int py0 = (var24 << 9) / z0 + Pix3D.originY;
		int pz0 = (var27 << 9) / z1 + Pix3D.originX;

		int px1 = (var30 << 9) / z1 + Pix3D.originY;
		int py1 = (var33 << 9) / z2 + Pix3D.originX;
		int pz1 = (var36 << 9) / z2 + Pix3D.originY;

		int px3 = (var39 << 9) / z3 + Pix3D.originX;
		int py3 = (var42 << 9) / z3 + Pix3D.originY;

		Pix3D.trans = 0;

		if ((px1 - py3) * (py1 - px3) - (pz0 - px3) * (pz1 - py3) > 0) {
			Pix3D.hclip = false;
			if (py1 < 0 || px3 < 0 || pz0 < 0 || py1 > Pix3D.sizeX || px3 > Pix3D.sizeX || pz0 > Pix3D.sizeX) {
				Pix3D.hclip = true;
			}

			if (takingInput && this.pointInsideTriangle(mouseX, mouseY, pz1, py3, px1, py1, px3, pz0)) {
				groundX = tileX;
				groundZ = tileZ;
			}

			if (underlay.texture == -1) {
				if (underlay.colourNE != 12345678) {
					Pix3D.gouraudTriangle(pz1, py3, px1, py1, px3, pz0, underlay.colourNE, underlay.colourNW, underlay.colourSE);
				}
			} else if (lowMemory) {
				int textureColor = Pix3D.textureProvider.getAverageRgb(underlay.texture);
				Pix3D.gouraudTriangle(pz1, py3, px1, py1, px3, pz0, mulLightness(textureColor, underlay.colourNE), mulLightness(textureColor, underlay.colourNW), mulLightness(textureColor, underlay.colourSE));
			} else if (underlay.flat) {
				Pix3D.textureTriangle(pz1, py3, px1, py1, px3, pz0, underlay.colourNE, underlay.colourNW, underlay.colourSE, var21, var27, var39, var24, var30, var42, z0, z1, z3, underlay.texture);
			} else {
				Pix3D.textureTriangle(pz1, py3, px1, py1, px3, pz0, underlay.colourNE, underlay.colourNW, underlay.colourSE, var33, var39, var27, var36, var42, var30, z2, z3, z1, underlay.texture);
			}
		}

		if ((px0 - pz0) * (py3 - px1) - (py0 - px1) * (px3 - pz0) > 0) {
			Pix3D.hclip = false;
			if (px0 < 0 || pz0 < 0 || px3 < 0 || px0 > Pix3D.sizeX || pz0 > Pix3D.sizeX || px3 > Pix3D.sizeX) {
				Pix3D.hclip = true;
			}

			if (takingInput && this.pointInsideTriangle(mouseX, mouseY, py0, px1, py3, px0, pz0, px3)) {
				groundX = tileX;
				groundZ = tileZ;
			}

			if (underlay.texture == -1) {
				if (underlay.colourSW != 12345678) {
					Pix3D.gouraudTriangle(py0, px1, py3, px0, pz0, px3, underlay.colourSW, underlay.colourSE, underlay.colourNW);
				}
			} else if (lowMemory) {
				int averageColour = Pix3D.textureProvider.getAverageRgb(underlay.texture);
				Pix3D.gouraudTriangle(py0, px1, py3, px0, pz0, px3, mulLightness(averageColour, underlay.colourSW), mulLightness(averageColour, underlay.colourSE), mulLightness(averageColour, underlay.colourNW));
			} else {
				Pix3D.textureTriangle(py0, px1, py3, px0, pz0, px3, underlay.colourSW, underlay.colourSE, underlay.colourNW, var21, var27, var39, var24, var30, var42, z0, z1, z3, underlay.texture);
			}
		}
	}

	@ObfuscatedName("aq.ag(Lar;IIIIII)V")
	public void drawTileOverlay(Ground overlay, int sinEyePitch, int cosEyePitch, int sinEyeYaw, int cosEyeYaw, int arg5, int arg6) {
		int vertexCount = overlay.vertexX.length;

		for (int i = 0; i < vertexCount; i++) {
			int vX = overlay.vertexX[i] - cx;
			int vY = overlay.vertexY[i] - cy;
			int vZ = overlay.vertexZ[i] - cz;

			int x = ((sinEyeYaw * vZ) + (cosEyeYaw * vX)) >> 16;
			int temp = ((cosEyeYaw * vZ) - (sinEyeYaw * vX)) >> 16;
			int y = ((cosEyePitch * vY) - (sinEyePitch * temp)) >> 16;
			int z = ((sinEyePitch * vY) + (cosEyePitch * temp)) >> 16;

			if (z < 50) {
				return;
			}

			if (overlay.faceTexture != null) {
				Ground.drawTextureVertexX[i] = x;
				Ground.drawTextureVertexY[i] = y;
				Ground.drawTextureVertexZ[i] = z;
			}

			Ground.drawVertexX[i] = (x << 9) / z + Pix3D.originX;
			Ground.drawVertexY[i] = (y << 9) / z + Pix3D.originY;
		}

		Pix3D.trans = 0;

		int triangleVertexCount = overlay.faceVertexA.length;
		for (int var20 = 0; var20 < triangleVertexCount; var20++) {
			int a = overlay.faceVertexA[var20];
			int b = overlay.faceVertexB[var20];
			int c = overlay.faceVertexC[var20];

			int xA = Ground.drawVertexX[a];
			int xB = Ground.drawVertexX[b];
			int xC = Ground.drawVertexX[c];

			int yA = Ground.drawVertexY[a];
			int yB = Ground.drawVertexY[b];
			int yC = Ground.drawVertexY[c];

			if ((xA - xB) * (yC - yB) - (xC - xB) * (yA - yB) > 0) {
				Pix3D.hclip = false;
				if (xA < 0 || xB < 0 || xC < 0 || xA > Pix3D.sizeX || xB > Pix3D.sizeX || xC > Pix3D.sizeX) {
					Pix3D.hclip = true;
				}

				if (takingInput && this.pointInsideTriangle(mouseX, mouseY, yA, yB, yC, xA, xB, xC)) {
					groundX = arg5;
					groundZ = arg6;
				}

				if (overlay.faceTexture == null || overlay.faceTexture[var20] == -1) {
					if (overlay.faceColourA[var20] != 12345678) {
						Pix3D.gouraudTriangle(yA, yB, yC, xA, xB, xC, overlay.faceColourA[var20], overlay.faceColourB[var20], overlay.faceColourC[var20]);
					}
				} else if (lowMemory) {
					int textureColor = Pix3D.textureProvider.getAverageRgb(overlay.faceTexture[var20]);
					Pix3D.gouraudTriangle(yA, yB, yC, xA, xB, xC, mulLightness(textureColor, overlay.faceColourA[var20]), mulLightness(textureColor, overlay.faceColourB[var20]), mulLightness(textureColor, overlay.faceColourC[var20]));
				} else if (overlay.flat) {
					Pix3D.textureTriangle(yA, yB, yC, xA, xB, xC, overlay.faceColourA[var20], overlay.faceColourB[var20], overlay.faceColourC[var20], Ground.drawTextureVertexX[0], Ground.drawTextureVertexX[1], Ground.drawTextureVertexX[3], Ground.drawTextureVertexY[0], Ground.drawTextureVertexY[1], Ground.drawTextureVertexY[3], Ground.drawTextureVertexZ[0], Ground.drawTextureVertexZ[1], Ground.drawTextureVertexZ[3], overlay.faceTexture[var20]);
				} else {
					Pix3D.textureTriangle(yA, yB, yC, xA, xB, xC, overlay.faceColourA[var20], overlay.faceColourB[var20], overlay.faceColourC[var20], Ground.drawTextureVertexX[a], Ground.drawTextureVertexX[b], Ground.drawTextureVertexX[c], Ground.drawTextureVertexY[a], Ground.drawTextureVertexY[b], Ground.drawTextureVertexY[c], Ground.drawTextureVertexZ[a], Ground.drawTextureVertexZ[b], Ground.drawTextureVertexZ[c], overlay.faceTexture[var20]);
				}
			}
		}
	}

	@ObfuscatedName("aq.ar(II)I")
	public static int mulLightness(int arg0, int arg1) {
		int var2 = (arg0 & 0x7F) * arg1 >> 7;
		if (var2 < 2) {
			var2 = 2;
		} else if (var2 > 126) {
			var2 = 126;
		}
		return (arg0 & 0xFF80) + var2;
	}

	@ObfuscatedName("aq.aq(IIIIIIII)Z")
	public boolean pointInsideTriangle(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		if (arg1 < arg2 && arg1 < arg3 && arg1 < arg4) {
			return false;
		} else if (arg1 > arg2 && arg1 > arg3 && arg1 > arg4) {
			return false;
		} else if (arg0 < arg5 && arg0 < arg6 && arg0 < arg7) {
			return false;
		} else if (arg0 > arg5 && arg0 > arg6 && arg0 > arg7) {
			return false;
		} else {
			int var9 = (arg1 - arg2) * (arg6 - arg5) - (arg0 - arg5) * (arg3 - arg2);
			int var10 = (arg1 - arg4) * (arg5 - arg7) - (arg0 - arg7) * (arg2 - arg4);
			int var11 = (arg1 - arg3) * (arg7 - arg6) - (arg0 - arg6) * (arg4 - arg3);
			return var9 * var11 > 0 && var10 * var11 > 0;
		}
	}

	@ObfuscatedName("aq.at()V")
	public void updateActiveOccluders() {
		int var1 = levelOccluderCount[topLevel];
		Occlude[] var2 = levelOccluders[topLevel];
		activeOccluderCount = 0;
		for (int var3 = 0; var3 < var1; var3++) {
			Occlude var4 = var2[var3];
			if (var4.type == 1) {
				int var5 = var4.minTileX - gx + 25;
				if (var5 >= 0 && var5 <= 50) {
					int var6 = var4.minTileZ - gz + 25;
					if (var6 < 0) {
						var6 = 0;
					}
					int var7 = var4.maxTileZ - gz + 25;
					if (var7 > 50) {
						var7 = 50;
					}
					boolean var8 = false;
					while (var6 <= var7) {
						if (visibilityMap[var5][var6++]) {
							var8 = true;
							break;
						}
					}
					if (var8) {
						int var9 = cx - var4.minX;
						if (var9 > 32) {
							var4.mode = 1;
						} else {
							if (var9 >= -32) {
								continue;
							}
							var4.mode = 2;
							var9 = -var9;
						}
						var4.minDeltaZ = (var4.minZ - cz << 8) / var9;
						var4.maxDeltaZ = (var4.maxZ - cz << 8) / var9;
						var4.minDeltaY = (var4.minY - cy << 8) / var9;
						var4.maxDeltaY = (var4.maxY - cy << 8) / var9;
						activeOccluders[activeOccluderCount++] = var4;
					}
				}
			} else if (var4.type == 2) {
				int var10 = var4.minTileZ - gz + 25;
				if (var10 >= 0 && var10 <= 50) {
					int var11 = var4.minTileX - gx + 25;
					if (var11 < 0) {
						var11 = 0;
					}
					int var12 = var4.maxTileX - gx + 25;
					if (var12 > 50) {
						var12 = 50;
					}
					boolean var13 = false;
					while (var11 <= var12) {
						if (visibilityMap[var11++][var10]) {
							var13 = true;
							break;
						}
					}
					if (var13) {
						int var14 = cz - var4.minZ;
						if (var14 > 32) {
							var4.mode = 3;
						} else {
							if (var14 >= -32) {
								continue;
							}
							var4.mode = 4;
							var14 = -var14;
						}
						var4.minDeltaX = (var4.minX - cx << 8) / var14;
						var4.maxDeltaX = (var4.maxX - cx << 8) / var14;
						var4.minDeltaY = (var4.minY - cy << 8) / var14;
						var4.maxDeltaY = (var4.maxY - cy << 8) / var14;
						activeOccluders[activeOccluderCount++] = var4;
					}
				}
			} else if (var4.type == 4) {
				int var15 = var4.minY - cy;
				if (var15 > 128) {
					int var16 = var4.minTileZ - gz + 25;
					if (var16 < 0) {
						var16 = 0;
					}
					int var17 = var4.maxTileZ - gz + 25;
					if (var17 > 50) {
						var17 = 50;
					}
					if (var16 <= var17) {
						int var18 = var4.minTileX - gx + 25;
						if (var18 < 0) {
							var18 = 0;
						}
						int var19 = var4.maxTileX - gx + 25;
						if (var19 > 50) {
							var19 = 50;
						}
						boolean var20 = false;
						label145:
						for (int var21 = var18; var21 <= var19; var21++) {
							for (int var22 = var16; var22 <= var17; var22++) {
								if (visibilityMap[var21][var22]) {
									var20 = true;
									break label145;
								}
							}
						}
						if (var20) {
							var4.mode = 5;
							var4.minDeltaX = (var4.minX - cx << 8) / var15;
							var4.maxDeltaX = (var4.maxX - cx << 8) / var15;
							var4.minDeltaZ = (var4.minZ - cz << 8) / var15;
							var4.maxDeltaZ = (var4.maxZ - cz << 8) / var15;
							activeOccluders[activeOccluderCount++] = var4;
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("aq.ae(III)Z")
	public boolean tileVisible(int arg0, int arg1, int arg2) {
		int var4 = this.levelTileOcclusionCycles[arg0][arg1][arg2];
		if (-cycle == var4) {
			return false;
		} else if (cycle == var4) {
			return true;
		} else {
			int var5 = arg1 << 7;
			int var6 = arg2 << 7;
			if (this.occluded(var5 + 1, this.groundh[arg0][arg1][arg2], var6 + 1) && this.occluded(var5 + 128 - 1, this.groundh[arg0][arg1 + 1][arg2], var6 + 1) && this.occluded(var5 + 128 - 1, this.groundh[arg0][arg1 + 1][arg2 + 1], var6 + 128 - 1) && this.occluded(var5 + 1, this.groundh[arg0][arg1][arg2 + 1], var6 + 128 - 1)) {
				this.levelTileOcclusionCycles[arg0][arg1][arg2] = cycle;
				return true;
			} else {
				this.levelTileOcclusionCycles[arg0][arg1][arg2] = -cycle;
				return false;
			}
		}
	}

	@ObfuscatedName("aq.au(IIII)Z")
	public boolean wallVisible(int arg0, int arg1, int arg2, int arg3) {
		if (!this.tileVisible(arg0, arg1, arg2)) {
			return false;
		}
		int var5 = arg1 << 7;
		int var6 = arg2 << 7;
		int var7 = this.groundh[arg0][arg1][arg2] - 1;
		int var8 = var7 - 120;
		int var9 = var7 - 230;
		int var10 = var7 - 238;
		if (arg3 < 16) {
			if (arg3 == 1) {
				if (var5 > cx) {
					if (!this.occluded(var5, var7, var6)) {
						return false;
					}
					if (!this.occluded(var5, var7, var6 + 128)) {
						return false;
					}
				}
				if (arg0 > 0) {
					if (!this.occluded(var5, var8, var6)) {
						return false;
					}
					if (!this.occluded(var5, var8, var6 + 128)) {
						return false;
					}
				}
				if (!this.occluded(var5, var9, var6)) {
					return false;
				}
				if (!this.occluded(var5, var9, var6 + 128)) {
					return false;
				}
				return true;
			}
			if (arg3 == 2) {
				if (var6 < cz) {
					if (!this.occluded(var5, var7, var6 + 128)) {
						return false;
					}
					if (!this.occluded(var5 + 128, var7, var6 + 128)) {
						return false;
					}
				}
				if (arg0 > 0) {
					if (!this.occluded(var5, var8, var6 + 128)) {
						return false;
					}
					if (!this.occluded(var5 + 128, var8, var6 + 128)) {
						return false;
					}
				}
				if (!this.occluded(var5, var9, var6 + 128)) {
					return false;
				}
				if (!this.occluded(var5 + 128, var9, var6 + 128)) {
					return false;
				}
				return true;
			}
			if (arg3 == 4) {
				if (var5 < cx) {
					if (!this.occluded(var5 + 128, var7, var6)) {
						return false;
					}
					if (!this.occluded(var5 + 128, var7, var6 + 128)) {
						return false;
					}
				}
				if (arg0 > 0) {
					if (!this.occluded(var5 + 128, var8, var6)) {
						return false;
					}
					if (!this.occluded(var5 + 128, var8, var6 + 128)) {
						return false;
					}
				}
				if (!this.occluded(var5 + 128, var9, var6)) {
					return false;
				}
				if (!this.occluded(var5 + 128, var9, var6 + 128)) {
					return false;
				}
				return true;
			}
			if (arg3 == 8) {
				if (var6 > cz) {
					if (!this.occluded(var5, var7, var6)) {
						return false;
					}
					if (!this.occluded(var5 + 128, var7, var6)) {
						return false;
					}
				}
				if (arg0 > 0) {
					if (!this.occluded(var5, var8, var6)) {
						return false;
					}
					if (!this.occluded(var5 + 128, var8, var6)) {
						return false;
					}
				}
				if (!this.occluded(var5, var9, var6)) {
					return false;
				}
				if (!this.occluded(var5 + 128, var9, var6)) {
					return false;
				}
				return true;
			}
		}
		if (!this.occluded(var5 + 64, var10, var6 + 64)) {
			return false;
		} else if (arg3 == 16) {
			return this.occluded(var5, var9, var6 + 128);
		} else if (arg3 == 32) {
			return this.occluded(var5 + 128, var9, var6 + 128);
		} else if (arg3 == 64) {
			return this.occluded(var5 + 128, var9, var6);
		} else if (arg3 == 128) {
			return this.occluded(var5, var9, var6);
		} else {
			return true;
		}
	}

	@ObfuscatedName("aq.ax(IIII)Z")
	public boolean visible(int arg0, int arg1, int arg2, int arg3) {
		if (this.tileVisible(arg0, arg1, arg2)) {
			int var5 = arg1 << 7;
			int var6 = arg2 << 7;
			return this.occluded(var5 + 1, this.groundh[arg0][arg1][arg2] - arg3, var6 + 1) && this.occluded(var5 + 128 - 1, this.groundh[arg0][arg1 + 1][arg2] - arg3, var6 + 1) && this.occluded(var5 + 128 - 1, this.groundh[arg0][arg1 + 1][arg2 + 1] - arg3, var6 + 128 - 1) && this.occluded(var5 + 1, this.groundh[arg0][arg1][arg2 + 1] - arg3, var6 + 128 - 1);
		} else {
			return false;
		}
	}

	@ObfuscatedName("aq.ai(IIIIII)Z")
	public boolean method671(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		if (arg1 != arg2 || arg3 != arg4) {
			for (int var9 = arg1; var9 <= arg2; var9++) {
				for (int var10 = arg3; var10 <= arg4; var10++) {
					if (this.levelTileOcclusionCycles[arg0][var9][var10] == -cycle) {
						return false;
					}
				}
			}
			int var11 = (arg1 << 7) + 1;
			int var12 = (arg3 << 7) + 2;
			int var13 = this.groundh[arg0][arg1][arg3] - arg5;
			if (!this.occluded(var11, var13, var12)) {
				return false;
			}
			int var14 = (arg2 << 7) - 1;
			if (!this.occluded(var14, var13, var12)) {
				return false;
			}
			int var15 = (arg4 << 7) - 1;
			if (!this.occluded(var11, var13, var15)) {
				return false;
			} else if (this.occluded(var14, var13, var15)) {
				return true;
			} else {
				return false;
			}
		} else if (this.tileVisible(arg0, arg1, arg3)) {
			int var7 = arg1 << 7;
			int var8 = arg3 << 7;
			return this.occluded(var7 + 1, this.groundh[arg0][arg1][arg3] - arg5, var8 + 1) && this.occluded(var7 + 128 - 1, this.groundh[arg0][arg1 + 1][arg3] - arg5, var8 + 1) && this.occluded(var7 + 128 - 1, this.groundh[arg0][arg1 + 1][arg3 + 1] - arg5, var8 + 128 - 1) && this.occluded(var7 + 1, this.groundh[arg0][arg1][arg3 + 1] - arg5, var8 + 128 - 1);
		} else {
			return false;
		}
	}

	@ObfuscatedName("aq.aj(III)Z")
	public boolean occluded(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < activeOccluderCount; var4++) {
			Occlude var5 = activeOccluders[var4];
			if (var5.mode == 1) {
				int var6 = var5.minX - arg0;
				if (var6 > 0) {
					int var7 = (var5.minDeltaZ * var6 >> 8) + var5.minZ;
					int var8 = (var5.maxDeltaZ * var6 >> 8) + var5.maxZ;
					int var9 = (var5.minDeltaY * var6 >> 8) + var5.minY;
					int var10 = (var5.maxDeltaY * var6 >> 8) + var5.maxY;
					if (arg2 >= var7 && arg2 <= var8 && arg1 >= var9 && arg1 <= var10) {
						return true;
					}
				}
			} else if (var5.mode == 2) {
				int var11 = arg0 - var5.minX;
				if (var11 > 0) {
					int var12 = (var5.minDeltaZ * var11 >> 8) + var5.minZ;
					int var13 = (var5.maxDeltaZ * var11 >> 8) + var5.maxZ;
					int var14 = (var5.minDeltaY * var11 >> 8) + var5.minY;
					int var15 = (var5.maxDeltaY * var11 >> 8) + var5.maxY;
					if (arg2 >= var12 && arg2 <= var13 && arg1 >= var14 && arg1 <= var15) {
						return true;
					}
				}
			} else if (var5.mode == 3) {
				int var16 = var5.minZ - arg2;
				if (var16 > 0) {
					int var17 = (var5.minDeltaX * var16 >> 8) + var5.minX;
					int var18 = (var5.maxDeltaX * var16 >> 8) + var5.maxX;
					int var19 = (var5.minDeltaY * var16 >> 8) + var5.minY;
					int var20 = (var5.maxDeltaY * var16 >> 8) + var5.maxY;
					if (arg0 >= var17 && arg0 <= var18 && arg1 >= var19 && arg1 <= var20) {
						return true;
					}
				}
			} else if (var5.mode == 4) {
				int var21 = arg2 - var5.minZ;
				if (var21 > 0) {
					int var22 = (var5.minDeltaX * var21 >> 8) + var5.minX;
					int var23 = (var5.maxDeltaX * var21 >> 8) + var5.maxX;
					int var24 = (var5.minDeltaY * var21 >> 8) + var5.minY;
					int var25 = (var5.maxDeltaY * var21 >> 8) + var5.maxY;
					if (arg0 >= var22 && arg0 <= var23 && arg1 >= var24 && arg1 <= var25) {
						return true;
					}
				}
			} else if (var5.mode == 5) {
				int var26 = arg1 - var5.minY;
				if (var26 > 0) {
					int var27 = (var5.minDeltaX * var26 >> 8) + var5.minX;
					int var28 = (var5.maxDeltaX * var26 >> 8) + var5.maxX;
					int var29 = (var5.minDeltaZ * var26 >> 8) + var5.minZ;
					int var30 = (var5.maxDeltaZ * var26 >> 8) + var5.maxZ;
					if (arg0 >= var27 && arg0 <= var28 && arg2 >= var29 && arg2 <= var30) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
