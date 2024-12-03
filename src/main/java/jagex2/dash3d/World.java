package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.client.Client;
import jagex2.config.FloType;
import jagex2.config.FluType;
import jagex2.config.LocType;
import jagex2.graphics.Pix3D;
import jagex2.graphics.SoftwareModel;
import jagex2.io.Packet;
import jagex2.sound.PositionedSound;

@ObfuscatedName("l")
public class World {

	@ObfuscatedName("l.r")
	public static int[][][] levelHeightmap = new int[4][105][105];

	@ObfuscatedName("l.d")
	public static byte[][][] levelTileFlags = new byte[4][104][104];

	@ObfuscatedName("l.l")
	public static int currentLevel = 99;

	@ObfuscatedName("l.m")
	public static byte[][][] levelTileUnderlayIds;

	@ObfuscatedName("l.c")
	public static byte[][][] levelTileOverlayIds;

	@ObfuscatedName("l.n")
	public static byte[][][] levelTileOverlayShape;

	@ObfuscatedName("l.j")
	public static byte[][][] levelTileOverlayRotation;

	@ObfuscatedName("l.z")
	public static byte[][][] levelShademap;

	@ObfuscatedName("ag.g")
	public static int[][] levelLightmap;

	@ObfuscatedName("ax.q")
	public static int[] blendChroma;

	@ObfuscatedName("da.i")
	public static int[] blendSaturation;

	@ObfuscatedName("l.s")
	public static int[] blendLightness;

	@ObfuscatedName("dm.u")
	public static int[] blendLuminance;

	@ObfuscatedName("l.v")
	public static int[] blendMagnitude;

	@ObfuscatedName("bp.w")
	public static int[][][] levelOccludemap;

	@ObfuscatedName("l.t")
	public static final int[] ROTATION_WALL_TYPE = new int[] { 1, 2, 4, 8 };

	@ObfuscatedName("l.f")
	public static final int[] ROTATION_WALL_CORNER_TYPE = new int[] { 16, 32, 64, 128 };

	@ObfuscatedName("l.k")
	public static final int[] WALL_DECORATION_ROTATION_FORWARD_X = new int[] { 1, 0, -1, 0 };

	@ObfuscatedName("l.o")
	public static final int[] WALL_DECORATION_ROTATION_FORWARD_Z = new int[] { 0, -1, 0, 1 };

	@ObfuscatedName("l.a")
	public static final int[] field31 = new int[] { 1, -1, -1, 1 };

	@ObfuscatedName("l.h")
	public static final int[] field32 = new int[] { -1, -1, 1, 1 };

	@ObfuscatedName("l.x")
	public static int randomHueOffset = (int) (Math.random() * 17.0D) - 8;

	@ObfuscatedName("l.p")
	public static int randomLightnessOffset = (int) (Math.random() * 33.0D) - 16;

	public World() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("bk.r(I)V")
	public static void method771() {
		levelTileUnderlayIds = null;
		levelTileOverlayIds = null;
		levelTileOverlayShape = null;
		levelTileOverlayRotation = null;
		levelOccludemap = null;
		levelShademap = null;
		levelLightmap = null;
		blendChroma = null;
		blendSaturation = null;
		blendLightness = null;
		blendLuminance = null;
		blendMagnitude = null;
	}

	@ObfuscatedName("dy.d(IIIIB)V")
	public static final void stitchHeightmap(int arg0, int arg1, int arg2, int arg3) {
		for (int var4 = arg1; var4 <= arg1 + arg3; var4++) {
			for (int var5 = arg0; var5 <= arg0 + arg2; var5++) {
				if (var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
					levelShademap[0][var5][var4] = 127;
					if (arg0 == var5 && var5 > 0) {
						levelHeightmap[0][var5][var4] = levelHeightmap[0][var5 - 1][var4];
					}
					if (arg0 + arg2 == var5 && var5 < 103) {
						levelHeightmap[0][var5][var4] = levelHeightmap[0][var5 + 1][var4];
					}
					if (arg1 == var4 && var4 > 0) {
						levelHeightmap[0][var5][var4] = levelHeightmap[0][var5][var4 - 1];
					}
					if (arg1 + arg3 == var4 && var4 < 103) {
						levelHeightmap[0][var5][var4] = levelHeightmap[0][var5][var4 + 1];
					}
				}
			}
		}
	}

	@ObfuscatedName("aa.l([BIIII[Lck;I)V")
	public static final void loadGround(byte[] arg0, int arg1, int arg2, int arg3, int arg4, CollisionMap[] arg5) {
		for (int var6 = 0; var6 < 4; var6++) {
			for (int var7 = 0; var7 < 64; var7++) {
				for (int var8 = 0; var8 < 64; var8++) {
					if (arg1 + var7 > 0 && arg1 + var7 < 103 && arg2 + var8 > 0 && arg2 + var8 < 103) {
						arg5[var6].field1266[arg1 + var7][arg2 + var8] &= 0xFEFFFFFF;
					}
				}
			}
		}
		Packet var9 = new Packet(arg0);
		for (int var10 = 0; var10 < 4; var10++) {
			for (int var11 = 0; var11 < 64; var11++) {
				for (int var12 = 0; var12 < 64; var12++) {
					loadGroundSquare(var9, var10, arg1 + var11, arg2 + var12, arg3, arg4, 0);
				}
			}
		}
	}

	@ObfuscatedName("aa.m([BIIIIIII[Lck;B)V")
	public static final void loadGroundRegion(byte[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, CollisionMap[] arg8) {
		for (int var9 = 0; var9 < 8; var9++) {
			for (int var10 = 0; var10 < 8; var10++) {
				if (arg2 + var9 > 0 && arg2 + var9 < 103 && arg3 + var10 > 0 && arg3 + var10 < 103) {
					arg8[arg1].field1266[arg2 + var9][arg3 + var10] &= 0xFEFFFFFF;
				}
			}
		}
		Packet var11 = new Packet(arg0);
		for (int var12 = 0; var12 < 4; var12++) {
			for (int var13 = 0; var13 < 64; var13++) {
				for (int var14 = 0; var14 < 64; var14++) {
					if (arg4 == var12 && var13 >= arg5 && var13 < arg5 + 8 && var14 >= arg6 && var14 < arg6 + 8) {
						int var18 = var13 & 0x7;
						int var19 = var14 & 0x7;
						int var21 = arg7 & 0x3;
						int var22;
						if (var21 == 0) {
							var22 = var18;
						} else if (var21 == 1) {
							var22 = var19;
						} else if (var21 == 2) {
							var22 = 7 - var18;
						} else {
							var22 = 7 - var19;
						}
						int var25 = arg2 + var22;
						int var27 = var13 & 0x7;
						int var28 = var14 & 0x7;
						int var30 = arg7 & 0x3;
						int var31;
						if (var30 == 0) {
							var31 = var28;
						} else if (var30 == 1) {
							var31 = 7 - var27;
						} else if (var30 == 2) {
							var31 = 7 - var28;
						} else {
							var31 = var27;
						}
						loadGroundSquare(var11, arg1, var25, arg3 + var31, 0, 0, arg7);
					} else {
						loadGroundSquare(var11, 0, -1, -1, 0, 0, 0);
					}
				}
			}
		}
	}

	@ObfuscatedName("dz.c(Lev;IIIIIII)V")
	public static final void loadGroundSquare(Packet arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		if (arg2 < 0 || arg2 >= 104 || arg3 < 0 || arg3 >= 104) {
			while (true) {
				int var9 = arg0.g1();
				if (var9 == 0) {
					break;
				}
				if (var9 == 1) {
					arg0.g1();
					break;
				}
				if (var9 <= 49) {
					arg0.g1();
				}
			}
			return;
		}
		levelTileFlags[arg1][arg2][arg3] = 0;
		while (true) {
			int var7 = arg0.g1();
			if (var7 == 0) {
				if (arg1 == 0) {
					levelHeightmap[0][arg2][arg3] = -perlinNoise(arg2 + 932731 + arg4, arg3 + 556238 + arg5) * 8;
				} else {
					levelHeightmap[arg1][arg2][arg3] = levelHeightmap[arg1 - 1][arg2][arg3] - 240;
				}
				break;
			}
			if (var7 == 1) {
				int var8 = arg0.g1();
				if (var8 == 1) {
					var8 = 0;
				}
				if (arg1 == 0) {
					levelHeightmap[0][arg2][arg3] = -var8 * 8;
				} else {
					levelHeightmap[arg1][arg2][arg3] = levelHeightmap[arg1 - 1][arg2][arg3] - var8 * 8;
				}
				break;
			}
			if (var7 <= 49) {
				levelTileOverlayIds[arg1][arg2][arg3] = arg0.g1b();
				levelTileOverlayShape[arg1][arg2][arg3] = (byte) ((var7 - 2) / 4);
				levelTileOverlayRotation[arg1][arg2][arg3] = (byte) (var7 - 2 + arg6 & 0x3);
			} else if (var7 <= 81) {
				levelTileFlags[arg1][arg2][arg3] = (byte) (var7 - 49);
			} else {
				levelTileUnderlayIds[arg1][arg2][arg3] = (byte) (var7 - 81);
			}
		}
	}

	@ObfuscatedName("as.n([BIII)Z")
	public static final boolean prefetchLocations(byte[] arg0, int arg1, int arg2) {
		boolean var3 = true;
		Packet var4 = new Packet(arg0);
		int var5 = -1;
		label57: while (true) {
			int var6 = var4.gsmart();
			if (var6 == 0) {
				return var3;
			}
			var5 += var6;
			int var7 = 0;
			boolean var8 = false;
			while (true) {
				while (!var8) {
					int var10 = var4.gsmart();
					if (var10 == 0) {
						continue label57;
					}
					var7 += var10 - 1;
					int var11 = var7 & 0x3F;
					int var12 = var7 >> 6 & 0x3F;
					int var13 = var4.g1() >> 2;
					int var14 = arg1 + var12;
					int var15 = arg2 + var11;
					if (var14 > 0 && var15 > 0 && var14 < 103 && var15 < 103) {
						LocType var16 = LocType.get(var5);
						if (var13 != 22 || !Client.field1917 || var16.active != 0 || var16.blockwalk == 1 || var16.forcedecor) {
							if (!var16.method2366()) {
								Client.field1974++;
								var3 = false;
							}
							var8 = true;
						}
					}
				}
				int var9 = var4.gsmart();
				if (var9 == 0) {
					break;
				}
				var4.g1();
			}
		}
	}

	@ObfuscatedName("dk.j([BIILaq;[Lck;I)V")
	public static final void loadLocations(byte[] arg0, int arg1, int arg2, World3D arg3, CollisionMap[] arg4) {
		Packet var5 = new Packet(arg0);
		int var6 = -1;
		while (true) {
			int var7 = var5.gsmart();
			if (var7 == 0) {
				return;
			}
			var6 += var7;
			int var8 = 0;
			while (true) {
				int var9 = var5.gsmart();
				if (var9 == 0) {
					break;
				}
				var8 += var9 - 1;
				int var10 = var8 & 0x3F;
				int var11 = var8 >> 6 & 0x3F;
				int var12 = var8 >> 12;
				int var13 = var5.g1();
				int var14 = var13 >> 2;
				int var15 = var13 & 0x3;
				int var16 = arg1 + var11;
				int var17 = arg2 + var10;
				if (var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
					int var18 = var12;
					if ((levelTileFlags[1][var16][var17] & 0x2) == 2) {
						var18 = var12 - 1;
					}
					CollisionMap var19 = null;
					if (var18 >= 0) {
						var19 = arg4[var18];
					}
					addLocation(var12, var16, var17, var6, var15, var14, arg3, var19);
				}
			}
		}
	}

	@ObfuscatedName("ag.z([BIIIIIIILaq;[Lck;I)V")
	public static final void method563(byte[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, World3D arg8, CollisionMap[] arg9) {
		Packet var10 = new Packet(arg0);
		int var11 = -1;
		while (true) {
			int var12 = var10.gsmart();
			if (var12 == 0) {
				return;
			}
			var11 += var12;
			int var13 = 0;
			while (true) {
				int var14 = var10.gsmart();
				if (var14 == 0) {
					break;
				}
				var13 += var14 - 1;
				int var15 = var13 & 0x3F;
				int var16 = var13 >> 6 & 0x3F;
				int var17 = var13 >> 12;
				int var18 = var10.g1();
				int var19 = var18 >> 2;
				int var20 = var18 & 0x3;
				if (arg4 == var17 && var16 >= arg5 && var16 < arg5 + 8 && var15 >= arg6 && var15 < arg6 + 8) {
					LocType var21 = LocType.get(var11);
					int var22 = arg2 + WorldRegion.method837(var16 & 0x7, var15 & 0x7, arg7, var21.width, var21.length, var20);
					int var23 = arg3 + WorldRegion.method783(var16 & 0x7, var15 & 0x7, arg7, var21.width, var21.length, var20);
					if (var22 > 0 && var23 > 0 && var22 < 103 && var23 < 103) {
						int var24 = arg1;
						if ((levelTileFlags[1][var22][var23] & 0x2) == 2) {
							var24 = arg1 - 1;
						}
						CollisionMap var25 = null;
						if (var24 >= 0) {
							var25 = arg9[var24];
						}
						addLocation(arg1, var22, var23, var11, arg7 + var20 & 0x3, var19, arg8, var25);
					}
				}
			}
		}
	}

	@ObfuscatedName("bi.g(IIIIIILaq;Lck;I)V")
	public static final void addLocation(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, World3D arg6, CollisionMap arg7) {
		if (Client.field1917 && (levelTileFlags[0][arg1][arg2] & 0x2) == 0) {
			if ((levelTileFlags[arg0][arg1][arg2] & 0x10) != 0) {
				return;
			}
			int var8;
			if ((levelTileFlags[arg0][arg1][arg2] & 0x8) != 0) {
				var8 = 0;
			} else if (arg0 <= 0 || (levelTileFlags[1][arg1][arg2] & 0x2) == 0) {
				var8 = arg0;
			} else {
				var8 = arg0 - 1;
			}
			if (Client.field2128 != var8) {
				return;
			}
		}
		if (arg0 < currentLevel) {
			currentLevel = arg0;
		}
		LocType var9 = LocType.get(arg3);
		int var10;
		int var11;
		if (arg4 == 1 || arg4 == 3) {
			var10 = var9.length;
			var11 = var9.width;
		} else {
			var10 = var9.width;
			var11 = var9.length;
		}
		int var12;
		int var13;
		if (arg1 + var10 <= 104) {
			var12 = (var10 >> 1) + arg1;
			var13 = (var10 + 1 >> 1) + arg1;
		} else {
			var12 = arg1;
			var13 = arg1 + 1;
		}
		int var14;
		int var15;
		if (arg2 + var11 <= 104) {
			var14 = (var11 >> 1) + arg2;
			var15 = (var11 + 1 >> 1) + arg2;
		} else {
			var14 = arg2;
			var15 = arg2 + 1;
		}
		int[][] var16 = levelHeightmap[arg0];
		int var17 = var16[var12][var14] + var16[var13][var14] + var16[var12][var15] + var16[var13][var15] >> 2;
		int var18 = (arg1 << 7) + (var10 << 6);
		int var19 = (arg2 << 7) + (var11 << 6);
		int var20 = (arg3 << 14) + (arg2 << 7) + arg1 + 1073741824;
		if (var9.active == 0) {
			var20 -= Integer.MIN_VALUE;
		}
		int var21 = (arg4 << 6) + arg5;
		if (var9.raiseobject == 1) {
			var21 += 256;
		}
		if (var9.method2374()) {
			PositionedSound.method763(arg0, arg1, arg2, var9, arg4);
		}
		if (arg5 == 22) {
			if (!Client.field1917 || var9.active != 0 || var9.blockwalk == 1 || var9.forcedecor) {
				Entity var22;
				if (var9.anim == -1 && var9.multiloc == null) {
					var22 = var9.method2364(22, arg4, var16, var18, var17, var19);
				} else {
					var22 = new LocEntity(arg3, 22, arg4, arg0, arg1, arg2, var9.anim, true, null);
				}
				arg6.method714(arg0, arg1, arg2, var17, var22, var20, var21);
				if (var9.blockwalk == 1 && arg7 != null) {
					arg7.method1213(arg1, arg2);
				}
			}
		} else if (arg5 == 10 || arg5 == 11) {
			Entity var45;
			if (var9.anim == -1 && var9.multiloc == null) {
				var45 = var9.method2364(10, arg4, var16, var18, var17, var19);
			} else {
				var45 = new LocEntity(arg3, 10, arg4, arg0, arg1, arg2, var9.anim, true, null);
			}
			if (var45 != null && arg6.method585(arg0, arg1, arg2, var17, var10, var11, var45, arg5 == 11 ? 256 : 0, var20, var21) && var9.shadow) {
				int var46 = 15;
				if (var45 instanceof SoftwareModel) {
					var46 = ((SoftwareModel) var45).method3004() / 4;
					if (var46 > 30) {
						var46 = 30;
					}
				}
				for (int var47 = 0; var47 <= var10; var47++) {
					for (int var48 = 0; var48 <= var11; var48++) {
						if (var46 > levelShademap[arg0][arg1 + var47][arg2 + var48]) {
							levelShademap[arg0][arg1 + var47][arg2 + var48] = (byte) var46;
						}
					}
				}
			}
			if (var9.blockwalk != 0 && arg7 != null) {
				arg7.method1198(arg1, arg2, var10, var11, var9.blockrange);
			}
		} else if (arg5 >= 12) {
			Entity var23;
			if (var9.anim == -1 && var9.multiloc == null) {
				var23 = var9.method2364(arg5, arg4, var16, var18, var17, var19);
			} else {
				var23 = new LocEntity(arg3, arg5, arg4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.method585(arg0, arg1, arg2, var17, 1, 1, var23, 0, var20, var21);
			if (arg5 >= 12 && arg5 <= 17 && arg5 != 13 && arg0 > 0) {
				levelOccludemap[arg0][arg1][arg2] |= 0x924;
			}
			if (var9.blockwalk != 0 && arg7 != null) {
				arg7.method1198(arg1, arg2, var10, var11, var9.blockrange);
			}
		} else if (arg5 == 0) {
			Entity var24;
			if (var9.anim == -1 && var9.multiloc == null) {
				var24 = var9.method2364(0, arg4, var16, var18, var17, var19);
			} else {
				var24 = new LocEntity(arg3, 0, arg4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.method572(arg0, arg1, arg2, var17, var24, null, ROTATION_WALL_TYPE[arg4], 0, var20, var21);
			if (arg4 == 0) {
				if (var9.shadow) {
					levelShademap[arg0][arg1][arg2] = 50;
					levelShademap[arg0][arg1][arg2 + 1] = 50;
				}
				if (var9.occlude) {
					levelOccludemap[arg0][arg1][arg2] |= 0x249;
				}
			} else if (arg4 == 1) {
				if (var9.shadow) {
					levelShademap[arg0][arg1][arg2 + 1] = 50;
					levelShademap[arg0][arg1 + 1][arg2 + 1] = 50;
				}
				if (var9.occlude) {
					levelOccludemap[arg0][arg1][arg2 + 1] |= 0x492;
				}
			} else if (arg4 == 2) {
				if (var9.shadow) {
					levelShademap[arg0][arg1 + 1][arg2] = 50;
					levelShademap[arg0][arg1 + 1][arg2 + 1] = 50;
				}
				if (var9.occlude) {
					levelOccludemap[arg0][arg1 + 1][arg2] |= 0x249;
				}
			} else if (arg4 == 3) {
				if (var9.shadow) {
					levelShademap[arg0][arg1][arg2] = 50;
					levelShademap[arg0][arg1 + 1][arg2] = 50;
				}
				if (var9.occlude) {
					levelOccludemap[arg0][arg1][arg2] |= 0x492;
				}
			}
			if (var9.blockwalk != 0 && arg7 != null) {
				arg7.method1195(arg1, arg2, arg5, arg4, var9.blockrange);
			}
			if (var9.wallwidth != 16) {
				arg6.method580(arg0, arg1, arg2, var9.wallwidth);
			}
		} else if (arg5 == 1) {
			Entity var25;
			if (var9.anim == -1 && var9.multiloc == null) {
				var25 = var9.method2364(1, arg4, var16, var18, var17, var19);
			} else {
				var25 = new LocEntity(arg3, 1, arg4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.method572(arg0, arg1, arg2, var17, var25, null, ROTATION_WALL_CORNER_TYPE[arg4], 0, var20, var21);
			if (var9.shadow) {
				if (arg4 == 0) {
					levelShademap[arg0][arg1][arg2 + 1] = 50;
				} else if (arg4 == 1) {
					levelShademap[arg0][arg1 + 1][arg2 + 1] = 50;
				} else if (arg4 == 2) {
					levelShademap[arg0][arg1 + 1][arg2] = 50;
				} else if (arg4 == 3) {
					levelShademap[arg0][arg1][arg2] = 50;
				}
			}
			if (var9.blockwalk != 0 && arg7 != null) {
				arg7.method1195(arg1, arg2, arg5, arg4, var9.blockrange);
			}
		} else if (arg5 == 2) {
			int var26 = arg4 + 1 & 0x3;
			Entity var27;
			Entity var28;
			if (var9.anim == -1 && var9.multiloc == null) {
				var27 = var9.method2364(2, arg4 + 4, var16, var18, var17, var19);
				var28 = var9.method2364(2, var26, var16, var18, var17, var19);
			} else {
				var27 = new LocEntity(arg3, 2, arg4 + 4, arg0, arg1, arg2, var9.anim, true, null);
				var28 = new LocEntity(arg3, 2, var26, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.method572(arg0, arg1, arg2, var17, var27, var28, ROTATION_WALL_TYPE[arg4], ROTATION_WALL_TYPE[var26], var20, var21);
			if (var9.occlude) {
				if (arg4 == 0) {
					levelOccludemap[arg0][arg1][arg2] |= 0x249;
					levelOccludemap[arg0][arg1][arg2 + 1] |= 0x492;
				} else if (arg4 == 1) {
					levelOccludemap[arg0][arg1][arg2 + 1] |= 0x492;
					levelOccludemap[arg0][arg1 + 1][arg2] |= 0x249;
				} else if (arg4 == 2) {
					levelOccludemap[arg0][arg1 + 1][arg2] |= 0x249;
					levelOccludemap[arg0][arg1][arg2] |= 0x492;
				} else if (arg4 == 3) {
					levelOccludemap[arg0][arg1][arg2] |= 0x492;
					levelOccludemap[arg0][arg1][arg2] |= 0x249;
				}
			}
			if (var9.blockwalk != 0 && arg7 != null) {
				arg7.method1195(arg1, arg2, arg5, arg4, var9.blockrange);
			}
			if (var9.wallwidth != 16) {
				arg6.method580(arg0, arg1, arg2, var9.wallwidth);
			}
		} else if (arg5 == 3) {
			Entity var29;
			if (var9.anim == -1 && var9.multiloc == null) {
				var29 = var9.method2364(3, arg4, var16, var18, var17, var19);
			} else {
				var29 = new LocEntity(arg3, 3, arg4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.method572(arg0, arg1, arg2, var17, var29, null, ROTATION_WALL_CORNER_TYPE[arg4], 0, var20, var21);
			if (var9.shadow) {
				if (arg4 == 0) {
					levelShademap[arg0][arg1][arg2 + 1] = 50;
				} else if (arg4 == 1) {
					levelShademap[arg0][arg1 + 1][arg2 + 1] = 50;
				} else if (arg4 == 2) {
					levelShademap[arg0][arg1 + 1][arg2] = 50;
				} else if (arg4 == 3) {
					levelShademap[arg0][arg1][arg2] = 50;
				}
			}
			if (var9.blockwalk != 0 && arg7 != null) {
				arg7.method1195(arg1, arg2, arg5, arg4, var9.blockrange);
			}
		} else if (arg5 == 9) {
			Entity var30;
			if (var9.anim == -1 && var9.multiloc == null) {
				var30 = var9.method2364(arg5, arg4, var16, var18, var17, var19);
			} else {
				var30 = new LocEntity(arg3, arg5, arg4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.method585(arg0, arg1, arg2, var17, 1, 1, var30, 0, var20, var21);
			if (var9.blockwalk != 0 && arg7 != null) {
				arg7.method1198(arg1, arg2, var10, var11, var9.blockrange);
			}
			if (var9.wallwidth != 16) {
				arg6.method580(arg0, arg1, arg2, var9.wallwidth);
			}
		} else if (arg5 == 4) {
			Entity var31;
			if (var9.anim == -1 && var9.multiloc == null) {
				var31 = var9.method2364(4, arg4, var16, var18, var17, var19);
			} else {
				var31 = new LocEntity(arg3, 4, arg4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.method589(arg0, arg1, arg2, var17, var31, null, ROTATION_WALL_TYPE[arg4], 0, 0, 0, var20, var21);
		} else if (arg5 == 5) {
			int var32 = 16;
			int var33 = arg6.method590(arg0, arg1, arg2);
			if (var33 != 0) {
				var32 = LocType.get(var33 >> 14 & 0x7FFF).wallwidth;
			}
			Entity var34;
			if (var9.anim == -1 && var9.multiloc == null) {
				var34 = var9.method2364(4, arg4, var16, var18, var17, var19);
			} else {
				var34 = new LocEntity(arg3, 4, arg4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.method589(arg0, arg1, arg2, var17, var34, null, ROTATION_WALL_TYPE[arg4], 0, WALL_DECORATION_ROTATION_FORWARD_X[arg4] * var32, WALL_DECORATION_ROTATION_FORWARD_Z[arg4] * var32, var20, var21);
		} else if (arg5 == 6) {
			int var35 = 8;
			int var36 = arg6.method590(arg0, arg1, arg2);
			if (var36 != 0) {
				var35 = LocType.get(var36 >> 14 & 0x7FFF).wallwidth / 2;
			}
			Entity var37;
			if (var9.anim == -1 && var9.multiloc == null) {
				var37 = var9.method2364(4, arg4 + 4, var16, var18, var17, var19);
			} else {
				var37 = new LocEntity(arg3, 4, arg4 + 4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.method589(arg0, arg1, arg2, var17, var37, null, 256, arg4, field31[arg4] * var35, field32[arg4] * var35, var20, var21);
		} else if (arg5 == 7) {
			int var38 = arg4 + 2 & 0x3;
			Entity var39;
			if (var9.anim == -1 && var9.multiloc == null) {
				var39 = var9.method2364(4, var38 + 4, var16, var18, var17, var19);
			} else {
				var39 = new LocEntity(arg3, 4, var38 + 4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.method589(arg0, arg1, arg2, var17, var39, null, 256, var38, 0, 0, var20, var21);
		} else if (arg5 == 8) {
			int var40 = 8;
			int var41 = arg6.method590(arg0, arg1, arg2);
			if (var41 != 0) {
				var40 = LocType.get(var41 >> 14 & 0x7FFF).wallwidth / 2;
			}
			int var42 = arg4 + 2 & 0x3;
			Entity var43;
			Entity var44;
			if (var9.anim == -1 && var9.multiloc == null) {
				var43 = var9.method2364(4, arg4 + 4, var16, var18, var17, var19);
				var44 = var9.method2364(4, var42 + 4, var16, var18, var17, var19);
			} else {
				var43 = new LocEntity(arg3, 4, arg4 + 4, arg0, arg1, arg2, var9.anim, true, null);
				var44 = new LocEntity(arg3, 4, var42 + 4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.method589(arg0, arg1, arg2, var17, var43, var44, 256, arg4, field31[arg4] * var40, field32[arg4] * var40, var20, var21);
		}
	}

	@ObfuscatedName("fp.q(Laq;[Lck;I)V")
	public static final void build(World3D arg0, CollisionMap[] arg1) {
		for (int var2 = 0; var2 < 4; var2++) {
			for (int var3 = 0; var3 < 104; var3++) {
				for (int var4 = 0; var4 < 104; var4++) {
					if ((levelTileFlags[var2][var3][var4] & 0x1) == 1) {
						int var5 = var2;
						if ((levelTileFlags[1][var3][var4] & 0x2) == 2) {
							var5 = var2 - 1;
						}
						if (var5 >= 0) {
							arg1[var5].method1199(var3, var4);
						}
					}
				}
			}
		}
		randomHueOffset += (int) (Math.random() * 5.0D) - 2;
		if (randomHueOffset < -8) {
			randomHueOffset = -8;
		}
		if (randomHueOffset > 8) {
			randomHueOffset = 8;
		}
		randomLightnessOffset += (int) (Math.random() * 5.0D) - 2;
		if (randomLightnessOffset < -16) {
			randomLightnessOffset = -16;
		}
		if (randomLightnessOffset > 16) {
			randomLightnessOffset = 16;
		}
		for (int var6 = 0; var6 < 4; var6++) {
			byte[][] var7 = levelShademap[var6];
			int var8 = (int) Math.sqrt(5100.0D);
			int var9 = var8 * 768 >> 8;
			for (int var10 = 1; var10 < 103; var10++) {
				for (int var11 = 1; var11 < 103; var11++) {
					int var12 = levelHeightmap[var6][var11 + 1][var10] - levelHeightmap[var6][var11 - 1][var10];
					int var13 = levelHeightmap[var6][var11][var10 + 1] - levelHeightmap[var6][var11][var10 - 1];
					int var14 = (int) Math.sqrt((double) (var13 * var13 + var12 * var12 + 65536));
					int var15 = (var12 << 8) / var14;
					int var16 = 65536 / var14;
					int var17 = (var13 << 8) / var14;
					int var18 = (var17 * -50 + var15 * -50 + var16 * -10) / var9 + 96;
					int var19 = (var7[var11][var10] >> 1) + (var7[var11][var10 + 1] >> 3) + (var7[var11][var10 - 1] >> 2) + (var7[var11 - 1][var10] >> 2) + (var7[var11 + 1][var10] >> 3);
					levelLightmap[var11][var10] = var18 - var19;
				}
			}
			for (int var20 = 0; var20 < 104; var20++) {
				blendChroma[var20] = 0;
				blendSaturation[var20] = 0;
				blendLightness[var20] = 0;
				blendLuminance[var20] = 0;
				blendMagnitude[var20] = 0;
			}
			for (int var21 = -5; var21 < 109; var21++) {
				for (int var22 = 0; var22 < 104; var22++) {
					int var23 = var21 + 5;
					int var10002;
					if (var23 >= 0 && var23 < 104) {
						int var24 = levelTileUnderlayIds[var6][var23][var22] & 0xFF;
						if (var24 > 0) {
							FluType var25 = FluType.get(var24 - 1);
							blendChroma[var22] += var25.field2357;
							blendSaturation[var22] += var25.field2356;
							blendLightness[var22] += var25.field2359;
							blendLuminance[var22] += var25.field2360;
							var10002 = blendMagnitude[var22]++;
						}
					}
					int var26 = var21 - 5;
					if (var26 >= 0 && var26 < 104) {
						int var27 = levelTileUnderlayIds[var6][var26][var22] & 0xFF;
						if (var27 > 0) {
							FluType var28 = FluType.get(var27 - 1);
							blendChroma[var22] -= var28.field2357;
							blendSaturation[var22] -= var28.field2356;
							blendLightness[var22] -= var28.field2359;
							blendLuminance[var22] -= var28.field2360;
							var10002 = blendMagnitude[var22]--;
						}
					}
				}
				if (var21 >= 1 && var21 < 103) {
					int var29 = 0;
					int var30 = 0;
					int var31 = 0;
					int var32 = 0;
					int var33 = 0;
					for (int var34 = -5; var34 < 109; var34++) {
						int var35 = var34 + 5;
						if (var35 >= 0 && var35 < 104) {
							var29 += blendChroma[var35];
							var30 += blendSaturation[var35];
							var31 += blendLightness[var35];
							var32 += blendLuminance[var35];
							var33 += blendMagnitude[var35];
						}
						int var36 = var34 - 5;
						if (var36 >= 0 && var36 < 104) {
							var29 -= blendChroma[var36];
							var30 -= blendSaturation[var36];
							var31 -= blendLightness[var36];
							var32 -= blendLuminance[var36];
							var33 -= blendMagnitude[var36];
						}
						if (var34 >= 1 && var34 < 103) {
							if (Client.field1917 && (levelTileFlags[0][var21][var34] & 0x2) == 0) {
								if ((levelTileFlags[var6][var21][var34] & 0x10) != 0) {
									continue;
								}
								int var37;
								if ((levelTileFlags[var6][var21][var34] & 0x8) != 0) {
									var37 = 0;
								} else if (var6 <= 0 || (levelTileFlags[1][var21][var34] & 0x2) == 0) {
									var37 = var6;
								} else {
									var37 = var6 - 1;
								}
								if (Client.field2128 != var37) {
									continue;
								}
							}
							if (var6 < currentLevel) {
								currentLevel = var6;
							}
							int var38 = levelTileUnderlayIds[var6][var21][var34] & 0xFF;
							int var39 = levelTileOverlayIds[var6][var21][var34] & 0xFF;
							if (var38 > 0 || var39 > 0) {
								int var40 = levelHeightmap[var6][var21][var34];
								int var41 = levelHeightmap[var6][var21 + 1][var34];
								int var42 = levelHeightmap[var6][var21 + 1][var34 + 1];
								int var43 = levelHeightmap[var6][var21][var34 + 1];
								int var44 = levelLightmap[var21][var34];
								int var45 = levelLightmap[var21 + 1][var34];
								int var46 = levelLightmap[var21 + 1][var34 + 1];
								int var47 = levelLightmap[var21][var34 + 1];
								int var48 = -1;
								int var49 = -1;
								if (var38 > 0) {
									int var50 = var29 * 256 / var32;
									int var51 = var30 / var33;
									int var52 = var31 / var33;
									var48 = hsl24to16(var50, var51, var52);
									int var53 = randomHueOffset + var50 & 0xFF;
									int var54 = randomLightnessOffset + var52;
									if (var54 < 0) {
										var54 = 0;
									} else if (var54 > 255) {
										var54 = 255;
									}
									var49 = hsl24to16(var53, var51, var54);
								}
								if (var6 > 0) {
									boolean var55 = true;
									if (var38 == 0 && levelTileOverlayShape[var6][var21][var34] != 0) {
										var55 = false;
									}
									if (var39 > 0 && !FloType.get(var39 - 1).occlude) {
										var55 = false;
									}
									if (var55 && var40 == var41 && var40 == var42 && var40 == var43) {
										levelOccludemap[var6][var21][var34] |= 0x924;
									}
								}
								int var56 = 0;
								if (var49 != -1) {
									var56 = Pix3D.field2538[mulHSL(var49, 96)];
								}
								if (var39 == 0) {
									arg0.method569(var6, var21, var34, 0, 0, -1, var40, var41, var42, var43, mulHSL(var48, var44), mulHSL(var48, var45), mulHSL(var48, var46), mulHSL(var48, var47), 0, 0, 0, 0, var56, 0);
								} else {
									int var57 = levelTileOverlayShape[var6][var21][var34] + 1;
									byte var58 = levelTileOverlayRotation[var6][var21][var34];
									FloType var59 = FloType.get(var39 - 1);
									int var60 = var59.texture;
									int var61;
									int var62;
									if (var60 >= 0) {
										var61 = Pix3D.sceneProvider.method731(var60);
										var62 = -1;
									} else if (var59.rgb == 16711935) {
										var62 = -2;
										var60 = -1;
										var61 = -2;
									} else {
										var62 = hsl24to16(var59.field2409, var59.field2413, var59.field2405);
										int var63 = randomHueOffset + var59.field2409 & 0xFF;
										int var64 = randomLightnessOffset + var59.field2405;
										if (var64 < 0) {
											var64 = 0;
										} else if (var64 > 255) {
											var64 = 255;
										}
										var61 = hsl24to16(var63, var59.field2413, var64);
									}
									int var65 = 0;
									if (var61 != -2) {
										var65 = Pix3D.field2538[adjustLightness(var61, 96)];
									}
									if (var59.averageRgb != -1) {
										int var66 = randomHueOffset + var59.field2410 & 0xFF;
										int var67 = randomLightnessOffset + var59.field2415;
										if (var67 < 0) {
											var67 = 0;
										} else if (var67 > 255) {
											var67 = 255;
										}
										int var68 = hsl24to16(var66, var59.field2412, var67);
										var65 = Pix3D.field2538[adjustLightness(var68, 96)];
									}
									arg0.method569(var6, var21, var34, var57, var58, var60, var40, var41, var42, var43, mulHSL(var48, var44), mulHSL(var48, var45), mulHSL(var48, var46), mulHSL(var48, var47), adjustLightness(var62, var44), adjustLightness(var62, var45), adjustLightness(var62, var46), adjustLightness(var62, var47), var56, var65);
								}
							}
						}
					}
				}
			}
			for (int var69 = 1; var69 < 103; var69++) {
				for (int var70 = 1; var70 < 103; var70++) {
					int var75;
					if ((levelTileFlags[var6][var70][var69] & 0x8) != 0) {
						var75 = 0;
					} else if (var6 <= 0 || (levelTileFlags[1][var70][var69] & 0x2) == 0) {
						var75 = var6;
					} else {
						var75 = var6 - 1;
					}
					arg0.method568(var6, var70, var69, var75);
				}
			}
			levelTileUnderlayIds[var6] = null;
			levelTileOverlayIds[var6] = null;
			levelTileOverlayShape[var6] = null;
			levelTileOverlayRotation[var6] = null;
			levelShademap[var6] = null;
		}
		arg0.method640(-50, -10, -50);
		for (int var76 = 0; var76 < 104; var76++) {
			for (int var77 = 0; var77 < 104; var77++) {
				if ((levelTileFlags[1][var76][var77] & 0x2) == 2) {
					arg0.method566(var76, var77);
				}
			}
		}
		int var78 = 1;
		int var79 = 2;
		int var80 = 4;
		for (int var81 = 0; var81 < 4; var81++) {
			if (var81 > 0) {
				var78 <<= 0x3;
				var79 <<= 0x3;
				var80 <<= 0x3;
			}
			for (int var82 = 0; var82 <= var81; var82++) {
				for (int var83 = 0; var83 <= 104; var83++) {
					for (int var84 = 0; var84 <= 104; var84++) {
						if ((levelOccludemap[var82][var84][var83] & var78) != 0) {
							int var85 = var83;
							int var86 = var83;
							int var87 = var82;
							int var88 = var82;
							while (var85 > 0 && (levelOccludemap[var82][var84][var85 - 1] & var78) != 0) {
								var85--;
							}
							while (var86 < 104 && (levelOccludemap[var82][var84][var86 + 1] & var78) != 0) {
								var86++;
							}
							label351: while (var87 > 0) {
								for (int var89 = var85; var89 <= var86; var89++) {
									if ((levelOccludemap[var87 - 1][var84][var89] & var78) == 0) {
										break label351;
									}
								}
								var87--;
							}
							label340: while (var88 < var81) {
								for (int var90 = var85; var90 <= var86; var90++) {
									if ((levelOccludemap[var88 + 1][var84][var90] & var78) == 0) {
										break label340;
									}
								}
								var88++;
							}
							int var91 = (var88 + 1 - var87) * (var86 - var85 + 1);
							if (var91 >= 8) {
								short var92 = 240;
								int var93 = levelHeightmap[var88][var84][var85] - var92;
								int var94 = levelHeightmap[var87][var84][var85];
								World3D.method651(var81, 1, var84 * 128, var84 * 128, var85 * 128, var86 * 128 + 128, var93, var94);
								for (int var95 = var87; var95 <= var88; var95++) {
									for (int var96 = var85; var96 <= var86; var96++) {
										levelOccludemap[var95][var84][var96] &= ~var78;
									}
								}
							}
						}
						if ((levelOccludemap[var82][var84][var83] & var79) != 0) {
							int var97 = var84;
							int var98 = var84;
							int var99 = var82;
							int var100 = var82;
							while (var97 > 0 && (levelOccludemap[var82][var97 - 1][var83] & var79) != 0) {
								var97--;
							}
							while (var98 < 104 && (levelOccludemap[var82][var98 + 1][var83] & var79) != 0) {
								var98++;
							}
							label404: while (var99 > 0) {
								for (int var101 = var97; var101 <= var98; var101++) {
									if ((levelOccludemap[var99 - 1][var101][var83] & var79) == 0) {
										break label404;
									}
								}
								var99--;
							}
							label393: while (var100 < var81) {
								for (int var102 = var97; var102 <= var98; var102++) {
									if ((levelOccludemap[var100 + 1][var102][var83] & var79) == 0) {
										break label393;
									}
								}
								var100++;
							}
							int var103 = (var100 + 1 - var99) * (var98 - var97 + 1);
							if (var103 >= 8) {
								short var104 = 240;
								int var105 = levelHeightmap[var100][var97][var83] - var104;
								int var106 = levelHeightmap[var99][var97][var83];
								World3D.method651(var81, 2, var97 * 128, var98 * 128 + 128, var83 * 128, var83 * 128, var105, var106);
								for (int var107 = var99; var107 <= var100; var107++) {
									for (int var108 = var97; var108 <= var98; var108++) {
										levelOccludemap[var107][var108][var83] &= ~var79;
									}
								}
							}
						}
						if ((levelOccludemap[var82][var84][var83] & var80) != 0) {
							int var109 = var84;
							int var110 = var84;
							int var111 = var83;
							int var112 = var83;
							while (var111 > 0 && (levelOccludemap[var82][var84][var111 - 1] & var80) != 0) {
								var111--;
							}
							while (var112 < 104 && (levelOccludemap[var82][var84][var112 + 1] & var80) != 0) {
								var112++;
							}
							label457: while (var109 > 0) {
								for (int var113 = var111; var113 <= var112; var113++) {
									if ((levelOccludemap[var82][var109 - 1][var113] & var80) == 0) {
										break label457;
									}
								}
								var109--;
							}
							label446: while (var110 < 104) {
								for (int var114 = var111; var114 <= var112; var114++) {
									if ((levelOccludemap[var82][var110 + 1][var114] & var80) == 0) {
										break label446;
									}
								}
								var110++;
							}
							if ((var110 - var109 + 1) * (var112 - var111 + 1) >= 4) {
								int var115 = levelHeightmap[var82][var109][var111];
								World3D.method651(var81, 4, var109 * 128, var110 * 128 + 128, var111 * 128, var112 * 128 + 128, var115, var115);
								for (int var116 = var109; var116 <= var110; var116++) {
									for (int var117 = var111; var117 <= var112; var117++) {
										levelOccludemap[var82][var116][var117] &= ~var80;
									}
								}
							}
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("fb.i(IIB)I")
	public static final int perlinNoise(int arg0, int arg1) {
		int var2 = interpolatedNoise(arg0 + 45365, arg1 + 91923, 4) - 128 + (interpolatedNoise(arg0 + 10294, arg1 + 37821, 2) - 128 >> 1) + (interpolatedNoise(arg0, arg1, 1) - 128 >> 2);
		int var3 = (int) ((double) var2 * 0.3D) + 35;
		if (var3 < 10) {
			var3 = 10;
		} else if (var3 > 60) {
			var3 = 60;
		}
		return var3;
	}

	@ObfuscatedName("dn.s(IIIB)I")
	public static final int interpolatedNoise(int arg0, int arg1, int arg2) {
		int var3 = arg0 / arg2;
		int var4 = arg0 & arg2 - 1;
		int var5 = arg1 / arg2;
		int var6 = arg1 & arg2 - 1;
		int var7 = smoothNoise(var3, var5);
		int var8 = smoothNoise(var3 + 1, var5);
		int var9 = smoothNoise(var3, var5 + 1);
		int var10 = smoothNoise(var3 + 1, var5 + 1);
		int var11 = 65536 - Pix3D.cosTable[var4 * 1024 / arg2] >> 1;
		int var12 = ((65536 - var11) * var7 >> 16) + (var8 * var11 >> 16);
		int var14 = 65536 - Pix3D.cosTable[var4 * 1024 / arg2] >> 1;
		int var15 = ((65536 - var14) * var9 >> 16) + (var10 * var14 >> 16);
		int var17 = 65536 - Pix3D.cosTable[var6 * 1024 / arg2] >> 1;
		return ((65536 - var17) * var12 >> 16) + (var15 * var17 >> 16);
	}

	@ObfuscatedName("cw.u(III)I")
	public static final int smoothNoise(int arg0, int arg1) {
		int var2 = noise(arg0 - 1, arg1 - 1) + noise(arg0 + 1, arg1 - 1) + noise(arg0 - 1, arg1 + 1) + noise(arg0 + 1, arg1 + 1);
		int var3 = noise(arg0 - 1, arg1) + noise(arg0 + 1, arg1) + noise(arg0, arg1 - 1) + noise(arg0, arg1 + 1);
		int var4 = noise(arg0, arg1);
		return var4 / 4 + var2 / 16 + var3 / 8;
	}

	@ObfuscatedName("ef.v(III)I")
	public static final int noise(int arg0, int arg1) {
		int var2 = arg1 * 57 + arg0;
		int var3 = var2 << 13 ^ var2;
		int var4 = (var3 * var3 * 15731 + 789221) * var3 + 1376312589 & Integer.MAX_VALUE;
		return var4 >> 19 & 0xFF;
	}

	@ObfuscatedName("ch.w(IIB)I")
	public static final int mulHSL(int arg0, int arg1) {
		if (arg0 == -1) {
			return 12345678;
		}
		int var2 = (arg0 & 0x7F) * arg1 / 128;
		if (var2 < 2) {
			var2 = 2;
		} else if (var2 > 126) {
			var2 = 126;
		}
		return (arg0 & 0xFF80) + var2;
	}

	@ObfuscatedName("eg.e(III)I")
	public static final int adjustLightness(int arg0, int arg1) {
		if (arg0 == -2) {
			return 12345678;
		} else if (arg0 == -1) {
			if (arg1 < 2) {
				arg1 = 2;
			} else if (arg1 > 126) {
				arg1 = 126;
			}
			return arg1;
		} else {
			int var2 = (arg0 & 0x7F) * arg1 / 128;
			if (var2 < 2) {
				var2 = 2;
			} else if (var2 > 126) {
				var2 = 126;
			}
			return (arg0 & 0xFF80) + var2;
		}
	}

	@ObfuscatedName("aa.b(IIII)I")
	public static final int hsl24to16(int arg0, int arg1, int arg2) {
		if (arg2 > 179) {
			arg1 /= 2;
		}
		if (arg2 > 192) {
			arg1 /= 2;
		}
		if (arg2 > 217) {
			arg1 /= 2;
		}
		if (arg2 > 243) {
			arg1 /= 2;
		}
		return arg2 / 2 + (arg0 / 4 << 10) + (arg1 / 32 << 7);
	}

	@ObfuscatedName("bk.y(III)Z")
	public static final boolean isLocPrefetched(int arg0, int arg1) {
		LocType var2 = LocType.get(arg0);
		if (arg1 == 11) {
			arg1 = 10;
		}
		if (arg1 >= 5 && arg1 <= 8) {
			arg1 = 4;
		}
		return var2.method2362(arg1);
	}

	@ObfuscatedName("bc.t(IIIIIIILaq;Lck;I)V")
	public static final void method918(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, World3D arg7, CollisionMap arg8) {
		LocType var9 = LocType.get(arg4);
		int var10;
		int var11;
		if (arg5 == 1 || arg5 == 3) {
			var10 = var9.length;
			var11 = var9.width;
		} else {
			var10 = var9.width;
			var11 = var9.length;
		}
		int var12;
		int var13;
		if (arg2 + var10 <= 104) {
			var12 = (var10 >> 1) + arg2;
			var13 = (var10 + 1 >> 1) + arg2;
		} else {
			var12 = arg2;
			var13 = arg2 + 1;
		}
		int var14;
		int var15;
		if (arg3 + var11 <= 104) {
			var14 = (var11 >> 1) + arg3;
			var15 = (var11 + 1 >> 1) + arg3;
		} else {
			var14 = arg3;
			var15 = arg3 + 1;
		}
		int[][] var16 = levelHeightmap[arg1];
		int var17 = var16[var12][var14] + var16[var13][var14] + var16[var12][var15] + var16[var13][var15] >> 2;
		int var18 = (arg2 << 7) + (var10 << 6);
		int var19 = (arg3 << 7) + (var11 << 6);
		int var20 = (arg4 << 14) + (arg3 << 7) + arg2 + 1073741824;
		if (var9.active == 0) {
			var20 -= Integer.MIN_VALUE;
		}
		int var21 = (arg5 << 6) + arg6;
		if (var9.raiseobject == 1) {
			var21 += 256;
		}
		if (arg6 == 22) {
			Entity var22;
			if (var9.anim == -1 && var9.multiloc == null) {
				var22 = var9.method2386(22, arg5, var16, var18, var17, var19);
			} else {
				var22 = new LocEntity(arg4, 22, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.method714(arg0, arg2, arg3, var17, var22, var20, var21);
			if (var9.blockwalk == 1) {
				arg8.method1213(arg2, arg3);
			}
		} else if (arg6 == 10 || arg6 == 11) {
			Entity var45;
			if (var9.anim == -1 && var9.multiloc == null) {
				var45 = var9.method2386(10, arg5, var16, var18, var17, var19);
			} else {
				var45 = new LocEntity(arg4, 10, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			if (var45 != null) {
				arg7.method585(arg0, arg2, arg3, var17, var10, var11, var45, arg6 == 11 ? 256 : 0, var20, var21);
			}
			if (var9.blockwalk != 0) {
				arg8.method1198(arg2, arg3, var10, var11, var9.blockrange);
			}
		} else if (arg6 >= 12) {
			Entity var23;
			if (var9.anim == -1 && var9.multiloc == null) {
				var23 = var9.method2386(arg6, arg5, var16, var18, var17, var19);
			} else {
				var23 = new LocEntity(arg4, arg6, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.method585(arg0, arg2, arg3, var17, 1, 1, var23, 0, var20, var21);
			if (var9.blockwalk != 0) {
				arg8.method1198(arg2, arg3, var10, var11, var9.blockrange);
			}
		} else if (arg6 == 0) {
			Entity var24;
			if (var9.anim == -1 && var9.multiloc == null) {
				var24 = var9.method2386(0, arg5, var16, var18, var17, var19);
			} else {
				var24 = new LocEntity(arg4, 0, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.method572(arg0, arg2, arg3, var17, var24, null, ROTATION_WALL_TYPE[arg5], 0, var20, var21);
			if (var9.blockwalk != 0) {
				arg8.method1195(arg2, arg3, arg6, arg5, var9.blockrange);
			}
		} else if (arg6 == 1) {
			Entity var25;
			if (var9.anim == -1 && var9.multiloc == null) {
				var25 = var9.method2386(1, arg5, var16, var18, var17, var19);
			} else {
				var25 = new LocEntity(arg4, 1, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.method572(arg0, arg2, arg3, var17, var25, null, ROTATION_WALL_CORNER_TYPE[arg5], 0, var20, var21);
			if (var9.blockwalk != 0) {
				arg8.method1195(arg2, arg3, arg6, arg5, var9.blockrange);
			}
		} else if (arg6 == 2) {
			int var26 = arg5 + 1 & 0x3;
			Entity var27;
			Entity var28;
			if (var9.anim == -1 && var9.multiloc == null) {
				var27 = var9.method2386(2, arg5 + 4, var16, var18, var17, var19);
				var28 = var9.method2386(2, var26, var16, var18, var17, var19);
			} else {
				var27 = new LocEntity(arg4, 2, arg5 + 4, arg1, arg2, arg3, var9.anim, true, null);
				var28 = new LocEntity(arg4, 2, var26, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.method572(arg0, arg2, arg3, var17, var27, var28, ROTATION_WALL_TYPE[arg5], ROTATION_WALL_TYPE[var26], var20, var21);
			if (var9.blockwalk != 0) {
				arg8.method1195(arg2, arg3, arg6, arg5, var9.blockrange);
			}
		} else if (arg6 == 3) {
			Entity var29;
			if (var9.anim == -1 && var9.multiloc == null) {
				var29 = var9.method2386(3, arg5, var16, var18, var17, var19);
			} else {
				var29 = new LocEntity(arg4, 3, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.method572(arg0, arg2, arg3, var17, var29, null, ROTATION_WALL_CORNER_TYPE[arg5], 0, var20, var21);
			if (var9.blockwalk != 0) {
				arg8.method1195(arg2, arg3, arg6, arg5, var9.blockrange);
			}
		} else if (arg6 == 9) {
			Entity var30;
			if (var9.anim == -1 && var9.multiloc == null) {
				var30 = var9.method2386(arg6, arg5, var16, var18, var17, var19);
			} else {
				var30 = new LocEntity(arg4, arg6, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.method585(arg0, arg2, arg3, var17, 1, 1, var30, 0, var20, var21);
			if (var9.blockwalk != 0) {
				arg8.method1198(arg2, arg3, var10, var11, var9.blockrange);
			}
		} else if (arg6 == 4) {
			Entity var31;
			if (var9.anim == -1 && var9.multiloc == null) {
				var31 = var9.method2386(4, arg5, var16, var18, var17, var19);
			} else {
				var31 = new LocEntity(arg4, 4, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.method589(arg0, arg2, arg3, var17, var31, null, ROTATION_WALL_TYPE[arg5], 0, 0, 0, var20, var21);
		} else if (arg6 == 5) {
			int var32 = 16;
			int var33 = arg7.method590(arg0, arg2, arg3);
			if (var33 != 0) {
				var32 = LocType.get(var33 >> 14 & 0x7FFF).wallwidth;
			}
			Entity var34;
			if (var9.anim == -1 && var9.multiloc == null) {
				var34 = var9.method2386(4, arg5, var16, var18, var17, var19);
			} else {
				var34 = new LocEntity(arg4, 4, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.method589(arg0, arg2, arg3, var17, var34, null, ROTATION_WALL_TYPE[arg5], 0, WALL_DECORATION_ROTATION_FORWARD_X[arg5] * var32, WALL_DECORATION_ROTATION_FORWARD_Z[arg5] * var32, var20, var21);
		} else if (arg6 == 6) {
			int var35 = 8;
			int var36 = arg7.method590(arg0, arg2, arg3);
			if (var36 != 0) {
				var35 = LocType.get(var36 >> 14 & 0x7FFF).wallwidth / 2;
			}
			Entity var37;
			if (var9.anim == -1 && var9.multiloc == null) {
				var37 = var9.method2386(4, arg5 + 4, var16, var18, var17, var19);
			} else {
				var37 = new LocEntity(arg4, 4, arg5 + 4, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.method589(arg0, arg2, arg3, var17, var37, null, 256, arg5, field31[arg5] * var35, field32[arg5] * var35, var20, var21);
		} else if (arg6 == 7) {
			int var38 = arg5 + 2 & 0x3;
			Entity var39;
			if (var9.anim == -1 && var9.multiloc == null) {
				var39 = var9.method2386(4, var38 + 4, var16, var18, var17, var19);
			} else {
				var39 = new LocEntity(arg4, 4, var38 + 4, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.method589(arg0, arg2, arg3, var17, var39, null, 256, var38, 0, 0, var20, var21);
		} else if (arg6 == 8) {
			int var40 = 8;
			int var41 = arg7.method590(arg0, arg2, arg3);
			if (var41 != 0) {
				var40 = LocType.get(var41 >> 14 & 0x7FFF).wallwidth / 2;
			}
			int var42 = arg5 + 2 & 0x3;
			Entity var43;
			Entity var44;
			if (var9.anim == -1 && var9.multiloc == null) {
				var43 = var9.method2386(4, arg5 + 4, var16, var18, var17, var19);
				var44 = var9.method2386(4, var42 + 4, var16, var18, var17, var19);
			} else {
				var43 = new LocEntity(arg4, 4, arg5 + 4, arg1, arg2, arg3, var9.anim, true, null);
				var44 = new LocEntity(arg4, 4, var42 + 4, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.method589(arg0, arg2, arg3, var17, var43, var44, 256, arg5, field31[arg5] * var40, field32[arg5] * var40, var20, var21);
		}
	}
}
