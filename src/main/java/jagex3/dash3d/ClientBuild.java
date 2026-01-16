package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.client.Client;
import jagex3.config.FloType;
import jagex3.config.FluType;
import jagex3.config.LocType;
import jagex3.io.Packet;
import jagex3.sound.BgSound;

@ObfuscatedName("l")
public class ClientBuild {

	@ObfuscatedName("l.r")
	public static int[][][] groundh = new int[4][105][105];

	@ObfuscatedName("l.d")
	public static byte[][][] mapl = new byte[4][104][104];

	@ObfuscatedName("l.l")
	public static int minusedlevel = 99;

	@ObfuscatedName("l.m")
	public static byte[][][] floort1;

	@ObfuscatedName("l.c")
	public static byte[][][] floort2;

	@ObfuscatedName("l.n")
	public static byte[][][] floors;

	@ObfuscatedName("l.j")
	public static byte[][][] floorr;

	@ObfuscatedName("l.z")
	public static byte[][][] shadow;

	@ObfuscatedName("ag.g")
	public static int[][] lightmap;

	@ObfuscatedName("ax.q")
	public static int[] huetot;

	@ObfuscatedName("da.i")
	public static int[] sattot;

	@ObfuscatedName("l.s")
	public static int[] ligtot;

	@ObfuscatedName("dm.u")
	public static int[] comtot;

	@ObfuscatedName("l.v")
	public static int[] tot;

	@ObfuscatedName("bp.w")
	public static int[][][] mapo;

	@ObfuscatedName("l.t")
	public static final int[] WSHAPE0 = new int[] { 1, 2, 4, 8 };

	@ObfuscatedName("l.f")
	public static final int[] WSHAPE1 = new int[] { 16, 32, 64, 128 };

	@ObfuscatedName("l.k")
	public static final int[] DECORXOF = new int[] { 1, 0, -1, 0 };

	@ObfuscatedName("l.o")
	public static final int[] DECORZOF = new int[] { 0, -1, 0, 1 };

	@ObfuscatedName("l.a")
	public static final int[] field31 = new int[] { 1, -1, -1, 1 };

	@ObfuscatedName("l.h")
	public static final int[] field32 = new int[] { -1, -1, 1, 1 };

	@ObfuscatedName("l.x")
	public static int hueOff = (int) (Math.random() * 17.0D) - 8;

	@ObfuscatedName("l.p")
	public static int ligOff = (int) (Math.random() * 33.0D) - 16;

	public ClientBuild() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("bk.r(I)V")
	public static void unload() {
		floort1 = null;
		floort2 = null;
		floors = null;
		floorr = null;
		mapo = null;
		shadow = null;
		lightmap = null;
		huetot = null;
		sattot = null;
		ligtot = null;
		comtot = null;
		tot = null;
	}

	@ObfuscatedName("dy.d(IIIIB)V")
	public static void fadeAdjacent(int arg0, int arg1, int arg2, int arg3) {
		for (int var4 = arg1; var4 <= arg1 + arg3; var4++) {
			for (int var5 = arg0; var5 <= arg0 + arg2; var5++) {
				if (var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
					shadow[0][var5][var4] = 127;
					if (arg0 == var5 && var5 > 0) {
						groundh[0][var5][var4] = groundh[0][var5 - 1][var4];
					}
					if (arg0 + arg2 == var5 && var5 < 103) {
						groundh[0][var5][var4] = groundh[0][var5 + 1][var4];
					}
					if (arg1 == var4 && var4 > 0) {
						groundh[0][var5][var4] = groundh[0][var5][var4 - 1];
					}
					if (arg1 + arg3 == var4 && var4 < 103) {
						groundh[0][var5][var4] = groundh[0][var5][var4 + 1];
					}
				}
			}
		}
	}

	@ObfuscatedName("aa.l([BIIII[Lck;I)V")
	public static void loadGround(byte[] arg0, int arg1, int arg2, int arg3, int arg4, CollisionMap[] arg5) {
		for (int var6 = 0; var6 < 4; var6++) {
			for (int var7 = 0; var7 < 64; var7++) {
				for (int var8 = 0; var8 < 64; var8++) {
					if (arg1 + var7 > 0 && arg1 + var7 < 103 && arg2 + var8 > 0 && arg2 + var8 < 103) {
						arg5[var6].flags[arg1 + var7][arg2 + var8] &= 0xFEFFFFFF;
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
	public static void loadGroundRegion(byte[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, CollisionMap[] arg8) {
		for (int var9 = 0; var9 < 8; var9++) {
			for (int var10 = 0; var10 < 8; var10++) {
				if (arg2 + var9 > 0 && arg2 + var9 < 103 && arg3 + var10 > 0 && arg3 + var10 < 103) {
					arg8[arg1].flags[arg2 + var9][arg3 + var10] &= 0xFEFFFFFF;
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
	public static void loadGroundSquare(Packet arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
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
		mapl[arg1][arg2][arg3] = 0;
		while (true) {
			int var7 = arg0.g1();
			if (var7 == 0) {
				if (arg1 == 0) {
					groundh[0][arg2][arg3] = -perlinNoise(arg2 + 932731 + arg4, arg3 + 556238 + arg5) * 8;
				} else {
					groundh[arg1][arg2][arg3] = groundh[arg1 - 1][arg2][arg3] - 240;
				}
				break;
			}
			if (var7 == 1) {
				int var8 = arg0.g1();
				if (var8 == 1) {
					var8 = 0;
				}
				if (arg1 == 0) {
					groundh[0][arg2][arg3] = -var8 * 8;
				} else {
					groundh[arg1][arg2][arg3] = groundh[arg1 - 1][arg2][arg3] - var8 * 8;
				}
				break;
			}
			if (var7 <= 49) {
				floort2[arg1][arg2][arg3] = arg0.g1b();
				floors[arg1][arg2][arg3] = (byte) ((var7 - 2) / 4);
				floorr[arg1][arg2][arg3] = (byte) (var7 - 2 + arg6 & 0x3);
			} else if (var7 <= 81) {
				mapl[arg1][arg2][arg3] = (byte) (var7 - 49);
			} else {
				floort1[arg1][arg2][arg3] = (byte) (var7 - 81);
			}
		}
	}

	@ObfuscatedName("as.n([BIII)Z")
	public static boolean checkLocations(byte[] arg0, int arg1, int arg2) {
		boolean var3 = true;
		Packet var4 = new Packet(arg0);
		int var5 = -1;
		label57:
		while (true) {
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
						if (var13 != 22 || !Client.lowMemory || var16.active != 0 || var16.blockwalk == 1 || var16.forcedecor) {
							if (!var16.isDownloaded()) {
								Client.locModelLoadCount++;
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
	public static void loadLocations(byte[] arg0, int arg1, int arg2, World arg3, CollisionMap[] arg4) {
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
					if ((mapl[1][var16][var17] & 0x2) == 2) {
						var18 = var12 - 1;
					}
					CollisionMap var19 = null;
					if (var18 >= 0) {
						var19 = arg4[var18];
					}
					addLoc(var12, var16, var17, var6, var15, var14, arg3, var19);
				}
			}
		}
	}

	@ObfuscatedName("ag.z([BIIIIIIILaq;[Lck;I)V")
	public static void method563(byte[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, World arg8, CollisionMap[] arg9) {
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
					int var22 = arg2 + WorldRegion.rotateX(var16 & 0x7, var15 & 0x7, arg7, var21.width, var21.length, var20);
					int var23 = arg3 + WorldRegion.rotateZ(var16 & 0x7, var15 & 0x7, arg7, var21.width, var21.length, var20);
					if (var22 > 0 && var23 > 0 && var22 < 103 && var23 < 103) {
						int var24 = arg1;
						if ((mapl[1][var22][var23] & 0x2) == 2) {
							var24 = arg1 - 1;
						}
						CollisionMap var25 = null;
						if (var24 >= 0) {
							var25 = arg9[var24];
						}
						addLoc(arg1, var22, var23, var11, arg7 + var20 & 0x3, var19, arg8, var25);
					}
				}
			}
		}
	}

	@ObfuscatedName("bi.g(IIIIIILaq;Lck;I)V")
	public static void addLoc(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, World arg6, CollisionMap arg7) {
		if (Client.lowMemory && (mapl[0][arg1][arg2] & 0x2) == 0) {
			if ((mapl[arg0][arg1][arg2] & 0x10) != 0) {
				return;
			}
			int var8;
			if ((mapl[arg0][arg1][arg2] & 0x8) != 0) {
				var8 = 0;
			} else if (arg0 <= 0 || (mapl[1][arg1][arg2] & 0x2) == 0) {
				var8 = arg0;
			} else {
				var8 = arg0 - 1;
			}
			if (Client.field2128 != var8) {
				return;
			}
		}
		if (arg0 < minusedlevel) {
			minusedlevel = arg0;
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
		int[][] var16 = groundh[arg0];
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
		if (var9.hasSound()) {
			BgSound.method763(arg0, arg1, arg2, var9, arg4);
		}
		if (arg5 == 22) {
			if (!Client.lowMemory || var9.active != 0 || var9.blockwalk == 1 || var9.forcedecor) {
				ModelSource var22;
				if (var9.anim == -1 && var9.multiloc == null) {
					var22 = var9.method2364(22, arg4, var16, var18, var17, var19);
				} else {
					var22 = new ClientLocAnim(arg3, 22, arg4, arg0, arg1, arg2, var9.anim, true, null);
				}
				arg6.addGroundDecor(arg0, arg1, arg2, var17, var22, var20, var21);
				if (var9.blockwalk == 1 && arg7 != null) {
					arg7.blockGroundDecor(arg1, arg2);
				}
			}
		} else if (arg5 == 10 || arg5 == 11) {
			ModelSource var45;
			if (var9.anim == -1 && var9.multiloc == null) {
				var45 = var9.method2364(10, arg4, var16, var18, var17, var19);
			} else {
				var45 = new ClientLocAnim(arg3, 10, arg4, arg0, arg1, arg2, var9.anim, true, null);
			}
			if (var45 != null && arg6.add(arg0, arg1, arg2, var17, var10, var11, var45, arg5 == 11 ? 256 : 0, var20, var21) && var9.shadow) {
				int var46 = 15;
				if (var45 instanceof ModelLit) {
					var46 = ((ModelLit) var45).method3004() / 4;
					if (var46 > 30) {
						var46 = 30;
					}
				}
				for (int var47 = 0; var47 <= var10; var47++) {
					for (int var48 = 0; var48 <= var11; var48++) {
						if (var46 > shadow[arg0][arg1 + var47][arg2 + var48]) {
							shadow[arg0][arg1 + var47][arg2 + var48] = (byte) var46;
						}
					}
				}
			}
			if (var9.blockwalk != 0 && arg7 != null) {
				arg7.addLoc(arg1, arg2, var10, var11, var9.blockrange);
			}
		} else if (arg5 >= 12) {
			ModelSource var23;
			if (var9.anim == -1 && var9.multiloc == null) {
				var23 = var9.method2364(arg5, arg4, var16, var18, var17, var19);
			} else {
				var23 = new ClientLocAnim(arg3, arg5, arg4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.add(arg0, arg1, arg2, var17, 1, 1, var23, 0, var20, var21);
			if (arg5 >= 12 && arg5 <= 17 && arg5 != 13 && arg0 > 0) {
				mapo[arg0][arg1][arg2] |= 0x924;
			}
			if (var9.blockwalk != 0 && arg7 != null) {
				arg7.addLoc(arg1, arg2, var10, var11, var9.blockrange);
			}
		} else if (arg5 == 0) {
			ModelSource var24;
			if (var9.anim == -1 && var9.multiloc == null) {
				var24 = var9.method2364(0, arg4, var16, var18, var17, var19);
			} else {
				var24 = new ClientLocAnim(arg3, 0, arg4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.addWall(arg0, arg1, arg2, var17, var24, null, WSHAPE0[arg4], 0, var20, var21);
			if (arg4 == 0) {
				if (var9.shadow) {
					shadow[arg0][arg1][arg2] = 50;
					shadow[arg0][arg1][arg2 + 1] = 50;
				}
				if (var9.occlude) {
					mapo[arg0][arg1][arg2] |= 0x249;
				}
			} else if (arg4 == 1) {
				if (var9.shadow) {
					shadow[arg0][arg1][arg2 + 1] = 50;
					shadow[arg0][arg1 + 1][arg2 + 1] = 50;
				}
				if (var9.occlude) {
					mapo[arg0][arg1][arg2 + 1] |= 0x492;
				}
			} else if (arg4 == 2) {
				if (var9.shadow) {
					shadow[arg0][arg1 + 1][arg2] = 50;
					shadow[arg0][arg1 + 1][arg2 + 1] = 50;
				}
				if (var9.occlude) {
					mapo[arg0][arg1 + 1][arg2] |= 0x249;
				}
			} else if (arg4 == 3) {
				if (var9.shadow) {
					shadow[arg0][arg1][arg2] = 50;
					shadow[arg0][arg1 + 1][arg2] = 50;
				}
				if (var9.occlude) {
					mapo[arg0][arg1][arg2] |= 0x492;
				}
			}
			if (var9.blockwalk != 0 && arg7 != null) {
				arg7.addWall(arg1, arg2, arg5, arg4, var9.blockrange);
			}
			if (var9.wallwidth != 16) {
				arg6.setDecorOffset(arg0, arg1, arg2, var9.wallwidth);
			}
		} else if (arg5 == 1) {
			ModelSource var25;
			if (var9.anim == -1 && var9.multiloc == null) {
				var25 = var9.method2364(1, arg4, var16, var18, var17, var19);
			} else {
				var25 = new ClientLocAnim(arg3, 1, arg4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.addWall(arg0, arg1, arg2, var17, var25, null, WSHAPE1[arg4], 0, var20, var21);
			if (var9.shadow) {
				if (arg4 == 0) {
					shadow[arg0][arg1][arg2 + 1] = 50;
				} else if (arg4 == 1) {
					shadow[arg0][arg1 + 1][arg2 + 1] = 50;
				} else if (arg4 == 2) {
					shadow[arg0][arg1 + 1][arg2] = 50;
				} else if (arg4 == 3) {
					shadow[arg0][arg1][arg2] = 50;
				}
			}
			if (var9.blockwalk != 0 && arg7 != null) {
				arg7.addWall(arg1, arg2, arg5, arg4, var9.blockrange);
			}
		} else if (arg5 == 2) {
			int var26 = arg4 + 1 & 0x3;
			ModelSource var27;
			ModelSource var28;
			if (var9.anim == -1 && var9.multiloc == null) {
				var27 = var9.method2364(2, arg4 + 4, var16, var18, var17, var19);
				var28 = var9.method2364(2, var26, var16, var18, var17, var19);
			} else {
				var27 = new ClientLocAnim(arg3, 2, arg4 + 4, arg0, arg1, arg2, var9.anim, true, null);
				var28 = new ClientLocAnim(arg3, 2, var26, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.addWall(arg0, arg1, arg2, var17, var27, var28, WSHAPE0[arg4], WSHAPE0[var26], var20, var21);
			if (var9.occlude) {
				if (arg4 == 0) {
					mapo[arg0][arg1][arg2] |= 0x249;
					mapo[arg0][arg1][arg2 + 1] |= 0x492;
				} else if (arg4 == 1) {
					mapo[arg0][arg1][arg2 + 1] |= 0x492;
					mapo[arg0][arg1 + 1][arg2] |= 0x249;
				} else if (arg4 == 2) {
					mapo[arg0][arg1 + 1][arg2] |= 0x249;
					mapo[arg0][arg1][arg2] |= 0x492;
				} else if (arg4 == 3) {
					mapo[arg0][arg1][arg2] |= 0x492;
					mapo[arg0][arg1][arg2] |= 0x249;
				}
			}
			if (var9.blockwalk != 0 && arg7 != null) {
				arg7.addWall(arg1, arg2, arg5, arg4, var9.blockrange);
			}
			if (var9.wallwidth != 16) {
				arg6.setDecorOffset(arg0, arg1, arg2, var9.wallwidth);
			}
		} else if (arg5 == 3) {
			ModelSource var29;
			if (var9.anim == -1 && var9.multiloc == null) {
				var29 = var9.method2364(3, arg4, var16, var18, var17, var19);
			} else {
				var29 = new ClientLocAnim(arg3, 3, arg4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.addWall(arg0, arg1, arg2, var17, var29, null, WSHAPE1[arg4], 0, var20, var21);
			if (var9.shadow) {
				if (arg4 == 0) {
					shadow[arg0][arg1][arg2 + 1] = 50;
				} else if (arg4 == 1) {
					shadow[arg0][arg1 + 1][arg2 + 1] = 50;
				} else if (arg4 == 2) {
					shadow[arg0][arg1 + 1][arg2] = 50;
				} else if (arg4 == 3) {
					shadow[arg0][arg1][arg2] = 50;
				}
			}
			if (var9.blockwalk != 0 && arg7 != null) {
				arg7.addWall(arg1, arg2, arg5, arg4, var9.blockrange);
			}
		} else if (arg5 == 9) {
			ModelSource var30;
			if (var9.anim == -1 && var9.multiloc == null) {
				var30 = var9.method2364(arg5, arg4, var16, var18, var17, var19);
			} else {
				var30 = new ClientLocAnim(arg3, arg5, arg4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.add(arg0, arg1, arg2, var17, 1, 1, var30, 0, var20, var21);
			if (var9.blockwalk != 0 && arg7 != null) {
				arg7.addLoc(arg1, arg2, var10, var11, var9.blockrange);
			}
			if (var9.wallwidth != 16) {
				arg6.setDecorOffset(arg0, arg1, arg2, var9.wallwidth);
			}
		} else if (arg5 == 4) {
			ModelSource var31;
			if (var9.anim == -1 && var9.multiloc == null) {
				var31 = var9.method2364(4, arg4, var16, var18, var17, var19);
			} else {
				var31 = new ClientLocAnim(arg3, 4, arg4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.addDecor(arg0, arg1, arg2, var17, var31, null, WSHAPE0[arg4], 0, 0, 0, var20, var21);
		} else if (arg5 == 5) {
			int var32 = 16;
			int var33 = arg6.wallType(arg0, arg1, arg2);
			if (var33 != 0) {
				var32 = LocType.get(var33 >> 14 & 0x7FFF).wallwidth;
			}
			ModelSource var34;
			if (var9.anim == -1 && var9.multiloc == null) {
				var34 = var9.method2364(4, arg4, var16, var18, var17, var19);
			} else {
				var34 = new ClientLocAnim(arg3, 4, arg4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.addDecor(arg0, arg1, arg2, var17, var34, null, WSHAPE0[arg4], 0, DECORXOF[arg4] * var32, DECORZOF[arg4] * var32, var20, var21);
		} else if (arg5 == 6) {
			int var35 = 8;
			int var36 = arg6.wallType(arg0, arg1, arg2);
			if (var36 != 0) {
				var35 = LocType.get(var36 >> 14 & 0x7FFF).wallwidth / 2;
			}
			ModelSource var37;
			if (var9.anim == -1 && var9.multiloc == null) {
				var37 = var9.method2364(4, arg4 + 4, var16, var18, var17, var19);
			} else {
				var37 = new ClientLocAnim(arg3, 4, arg4 + 4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.addDecor(arg0, arg1, arg2, var17, var37, null, 256, arg4, field31[arg4] * var35, field32[arg4] * var35, var20, var21);
		} else if (arg5 == 7) {
			int var38 = arg4 + 2 & 0x3;
			ModelSource var39;
			if (var9.anim == -1 && var9.multiloc == null) {
				var39 = var9.method2364(4, var38 + 4, var16, var18, var17, var19);
			} else {
				var39 = new ClientLocAnim(arg3, 4, var38 + 4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.addDecor(arg0, arg1, arg2, var17, var39, null, 256, var38, 0, 0, var20, var21);
		} else if (arg5 == 8) {
			int var40 = 8;
			int var41 = arg6.wallType(arg0, arg1, arg2);
			if (var41 != 0) {
				var40 = LocType.get(var41 >> 14 & 0x7FFF).wallwidth / 2;
			}
			int var42 = arg4 + 2 & 0x3;
			ModelSource var43;
			ModelSource var44;
			if (var9.anim == -1 && var9.multiloc == null) {
				var43 = var9.method2364(4, arg4 + 4, var16, var18, var17, var19);
				var44 = var9.method2364(4, var42 + 4, var16, var18, var17, var19);
			} else {
				var43 = new ClientLocAnim(arg3, 4, arg4 + 4, arg0, arg1, arg2, var9.anim, true, null);
				var44 = new ClientLocAnim(arg3, 4, var42 + 4, arg0, arg1, arg2, var9.anim, true, null);
			}
			arg6.addDecor(arg0, arg1, arg2, var17, var43, var44, 256, arg4, field31[arg4] * var40, field32[arg4] * var40, var20, var21);
		}
	}

	@ObfuscatedName("fp.q(Laq;[Lck;I)V")
	public static void finishBuild(World arg0, CollisionMap[] arg1) {
		for (int var2 = 0; var2 < 4; var2++) {
			for (int var3 = 0; var3 < 104; var3++) {
				for (int var4 = 0; var4 < 104; var4++) {
					if ((mapl[var2][var3][var4] & 0x1) == 1) {
						int var5 = var2;
						if ((mapl[1][var3][var4] & 0x2) == 2) {
							var5 = var2 - 1;
						}
						if (var5 >= 0) {
							arg1[var5].blockGround(var3, var4);
						}
					}
				}
			}
		}
		hueOff += (int) (Math.random() * 5.0D) - 2;
		if (hueOff < -8) {
			hueOff = -8;
		}
		if (hueOff > 8) {
			hueOff = 8;
		}
		ligOff += (int) (Math.random() * 5.0D) - 2;
		if (ligOff < -16) {
			ligOff = -16;
		}
		if (ligOff > 16) {
			ligOff = 16;
		}
		for (int var6 = 0; var6 < 4; var6++) {
			byte[][] var7 = shadow[var6];
			int var8 = (int) Math.sqrt(5100.0D);
			int var9 = var8 * 768 >> 8;
			for (int var10 = 1; var10 < 103; var10++) {
				for (int var11 = 1; var11 < 103; var11++) {
					int var12 = groundh[var6][var11 + 1][var10] - groundh[var6][var11 - 1][var10];
					int var13 = groundh[var6][var11][var10 + 1] - groundh[var6][var11][var10 - 1];
					int var14 = (int) Math.sqrt((double) (var13 * var13 + var12 * var12 + 65536));
					int var15 = (var12 << 8) / var14;
					int var16 = 65536 / var14;
					int var17 = (var13 << 8) / var14;
					int var18 = (var17 * -50 + var15 * -50 + var16 * -10) / var9 + 96;
					int var19 = (var7[var11][var10] >> 1) + (var7[var11][var10 + 1] >> 3) + (var7[var11][var10 - 1] >> 2) + (var7[var11 - 1][var10] >> 2) + (var7[var11 + 1][var10] >> 3);
					lightmap[var11][var10] = var18 - var19;
				}
			}
			for (int var20 = 0; var20 < 104; var20++) {
				huetot[var20] = 0;
				sattot[var20] = 0;
				ligtot[var20] = 0;
				comtot[var20] = 0;
				tot[var20] = 0;
			}
			for (int var21 = -5; var21 < 109; var21++) {
				for (int var22 = 0; var22 < 104; var22++) {
					int var23 = var21 + 5;
					int var10002;
					if (var23 >= 0 && var23 < 104) {
						int var24 = floort1[var6][var23][var22] & 0xFF;
						if (var24 > 0) {
							FluType var25 = FluType.get(var24 - 1);
							huetot[var22] += var25.chroma;
							sattot[var22] += var25.hue;
							ligtot[var22] += var25.saturation;
							comtot[var22] += var25.luminance;
							var10002 = tot[var22]++;
						}
					}
					int var26 = var21 - 5;
					if (var26 >= 0 && var26 < 104) {
						int var27 = floort1[var6][var26][var22] & 0xFF;
						if (var27 > 0) {
							FluType var28 = FluType.get(var27 - 1);
							huetot[var22] -= var28.chroma;
							sattot[var22] -= var28.hue;
							ligtot[var22] -= var28.saturation;
							comtot[var22] -= var28.luminance;
							var10002 = tot[var22]--;
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
							var29 += huetot[var35];
							var30 += sattot[var35];
							var31 += ligtot[var35];
							var32 += comtot[var35];
							var33 += tot[var35];
						}
						int var36 = var34 - 5;
						if (var36 >= 0 && var36 < 104) {
							var29 -= huetot[var36];
							var30 -= sattot[var36];
							var31 -= ligtot[var36];
							var32 -= comtot[var36];
							var33 -= tot[var36];
						}
						if (var34 >= 1 && var34 < 103) {
							if (Client.lowMemory && (mapl[0][var21][var34] & 0x2) == 0) {
								if ((mapl[var6][var21][var34] & 0x10) != 0) {
									continue;
								}
								int var37;
								if ((mapl[var6][var21][var34] & 0x8) != 0) {
									var37 = 0;
								} else if (var6 <= 0 || (mapl[1][var21][var34] & 0x2) == 0) {
									var37 = var6;
								} else {
									var37 = var6 - 1;
								}
								if (Client.field2128 != var37) {
									continue;
								}
							}
							if (var6 < minusedlevel) {
								minusedlevel = var6;
							}
							int var38 = floort1[var6][var21][var34] & 0xFF;
							int var39 = floort2[var6][var21][var34] & 0xFF;
							if (var38 > 0 || var39 > 0) {
								int var40 = groundh[var6][var21][var34];
								int var41 = groundh[var6][var21 + 1][var34];
								int var42 = groundh[var6][var21 + 1][var34 + 1];
								int var43 = groundh[var6][var21][var34 + 1];
								int var44 = lightmap[var21][var34];
								int var45 = lightmap[var21 + 1][var34];
								int var46 = lightmap[var21 + 1][var34 + 1];
								int var47 = lightmap[var21][var34 + 1];
								int var48 = -1;
								int var49 = -1;
								if (var38 > 0) {
									int var50 = var29 * 256 / var32;
									int var51 = var30 / var33;
									int var52 = var31 / var33;
									var48 = getTable(var50, var51, var52);
									int var53 = hueOff + var50 & 0xFF;
									int var54 = ligOff + var52;
									if (var54 < 0) {
										var54 = 0;
									} else if (var54 > 255) {
										var54 = 255;
									}
									var49 = getTable(var53, var51, var54);
								}
								if (var6 > 0) {
									boolean var55 = true;
									if (var38 == 0 && floors[var6][var21][var34] != 0) {
										var55 = false;
									}
									if (var39 > 0 && !FloType.get(var39 - 1).occlude) {
										var55 = false;
									}
									if (var55 && var40 == var41 && var40 == var42 && var40 == var43) {
										mapo[var6][var21][var34] |= 0x924;
									}
								}
								int var56 = 0;
								if (var49 != -1) {
									var56 = Pix3D.palette[getUCol(var49, 96)];
								}
								if (var39 == 0) {
									arg0.setTile(var6, var21, var34, 0, 0, -1, var40, var41, var42, var43, getUCol(var48, var44), getUCol(var48, var45), getUCol(var48, var46), getUCol(var48, var47), 0, 0, 0, 0, var56, 0);
								} else {
									int var57 = floors[var6][var21][var34] + 1;
									byte var58 = floorr[var6][var21][var34];
									FloType var59 = FloType.get(var39 - 1);
									int var60 = var59.texture;
									int var61;
									int var62;
									if (var60 >= 0) {
										var61 = Pix3D.textureProvider.getAverageRgb(var60);
										var62 = -1;
									} else if (var59.rgb == 16711935) {
										var62 = -2;
										var60 = -1;
										var61 = -2;
									} else {
										var62 = getTable(var59.hue, var59.saturation, var59.luminance);
										int var63 = hueOff + var59.hue & 0xFF;
										int var64 = ligOff + var59.luminance;
										if (var64 < 0) {
											var64 = 0;
										} else if (var64 > 255) {
											var64 = 255;
										}
										var61 = getTable(var63, var59.saturation, var64);
									}
									int var65 = 0;
									if (var61 != -2) {
										var65 = Pix3D.palette[getOCol(var61, 96)];
									}
									if (var59.mapcolour != -1) {
										int var66 = hueOff + var59.mapHue & 0xFF;
										int var67 = ligOff + var59.mapLuminance;
										if (var67 < 0) {
											var67 = 0;
										} else if (var67 > 255) {
											var67 = 255;
										}
										int var68 = getTable(var66, var59.mapSaturation, var67);
										var65 = Pix3D.palette[getOCol(var68, 96)];
									}
									arg0.setTile(var6, var21, var34, var57, var58, var60, var40, var41, var42, var43, getUCol(var48, var44), getUCol(var48, var45), getUCol(var48, var46), getUCol(var48, var47), getOCol(var62, var44), getOCol(var62, var45), getOCol(var62, var46), getOCol(var62, var47), var56, var65);
								}
							}
						}
					}
				}
			}
			for (int var69 = 1; var69 < 103; var69++) {
				for (int var70 = 1; var70 < 103; var70++) {
					int var75;
					if ((mapl[var6][var70][var69] & 0x8) != 0) {
						var75 = 0;
					} else if (var6 <= 0 || (mapl[1][var70][var69] & 0x2) == 0) {
						var75 = var6;
					} else {
						var75 = var6 - 1;
					}
					arg0.setDrawLevel(var6, var70, var69, var75);
				}
			}
			floort1[var6] = null;
			floort2[var6] = null;
			floors[var6] = null;
			floorr[var6] = null;
			shadow[var6] = null;
		}
		arg0.buildModels(-50, -10, -50);
		for (int var76 = 0; var76 < 104; var76++) {
			for (int var77 = 0; var77 < 104; var77++) {
				if ((mapl[1][var76][var77] & 0x2) == 2) {
					arg0.pushDown(var76, var77);
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
						if ((mapo[var82][var84][var83] & var78) != 0) {
							int var85 = var83;
							int var86 = var83;
							int var87 = var82;
							int var88 = var82;
							while (var85 > 0 && (mapo[var82][var84][var85 - 1] & var78) != 0) {
								var85--;
							}
							while (var86 < 104 && (mapo[var82][var84][var86 + 1] & var78) != 0) {
								var86++;
							}
							label351:
							while (var87 > 0) {
								for (int var89 = var85; var89 <= var86; var89++) {
									if ((mapo[var87 - 1][var84][var89] & var78) == 0) {
										break label351;
									}
								}
								var87--;
							}
							label340:
							while (var88 < var81) {
								for (int var90 = var85; var90 <= var86; var90++) {
									if ((mapo[var88 + 1][var84][var90] & var78) == 0) {
										break label340;
									}
								}
								var88++;
							}
							int var91 = (var88 + 1 - var87) * (var86 - var85 + 1);
							if (var91 >= 8) {
								short var92 = 240;
								int var93 = groundh[var88][var84][var85] - var92;
								int var94 = groundh[var87][var84][var85];
								World.setOcclude(var81, 1, var84 * 128, var84 * 128, var85 * 128, var86 * 128 + 128, var93, var94);
								for (int var95 = var87; var95 <= var88; var95++) {
									for (int var96 = var85; var96 <= var86; var96++) {
										mapo[var95][var84][var96] &= ~var78;
									}
								}
							}
						}
						if ((mapo[var82][var84][var83] & var79) != 0) {
							int var97 = var84;
							int var98 = var84;
							int var99 = var82;
							int var100 = var82;
							while (var97 > 0 && (mapo[var82][var97 - 1][var83] & var79) != 0) {
								var97--;
							}
							while (var98 < 104 && (mapo[var82][var98 + 1][var83] & var79) != 0) {
								var98++;
							}
							label404:
							while (var99 > 0) {
								for (int var101 = var97; var101 <= var98; var101++) {
									if ((mapo[var99 - 1][var101][var83] & var79) == 0) {
										break label404;
									}
								}
								var99--;
							}
							label393:
							while (var100 < var81) {
								for (int var102 = var97; var102 <= var98; var102++) {
									if ((mapo[var100 + 1][var102][var83] & var79) == 0) {
										break label393;
									}
								}
								var100++;
							}
							int var103 = (var100 + 1 - var99) * (var98 - var97 + 1);
							if (var103 >= 8) {
								short var104 = 240;
								int var105 = groundh[var100][var97][var83] - var104;
								int var106 = groundh[var99][var97][var83];
								World.setOcclude(var81, 2, var97 * 128, var98 * 128 + 128, var83 * 128, var83 * 128, var105, var106);
								for (int var107 = var99; var107 <= var100; var107++) {
									for (int var108 = var97; var108 <= var98; var108++) {
										mapo[var107][var108][var83] &= ~var79;
									}
								}
							}
						}
						if ((mapo[var82][var84][var83] & var80) != 0) {
							int var109 = var84;
							int var110 = var84;
							int var111 = var83;
							int var112 = var83;
							while (var111 > 0 && (mapo[var82][var84][var111 - 1] & var80) != 0) {
								var111--;
							}
							while (var112 < 104 && (mapo[var82][var84][var112 + 1] & var80) != 0) {
								var112++;
							}
							label457:
							while (var109 > 0) {
								for (int var113 = var111; var113 <= var112; var113++) {
									if ((mapo[var82][var109 - 1][var113] & var80) == 0) {
										break label457;
									}
								}
								var109--;
							}
							label446:
							while (var110 < 104) {
								for (int var114 = var111; var114 <= var112; var114++) {
									if ((mapo[var82][var110 + 1][var114] & var80) == 0) {
										break label446;
									}
								}
								var110++;
							}
							if ((var110 - var109 + 1) * (var112 - var111 + 1) >= 4) {
								int var115 = groundh[var82][var109][var111];
								World.setOcclude(var81, 4, var109 * 128, var110 * 128 + 128, var111 * 128, var112 * 128 + 128, var115, var115);
								for (int var116 = var109; var116 <= var110; var116++) {
									for (int var117 = var111; var117 <= var112; var117++) {
										mapo[var82][var116][var117] &= ~var80;
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
	public static int perlinNoise(int arg0, int arg1) {
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
	public static int interpolatedNoise(int arg0, int arg1, int arg2) {
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
	public static int smoothNoise(int arg0, int arg1) {
		int var2 = noise(arg0 - 1, arg1 - 1) + noise(arg0 + 1, arg1 - 1) + noise(arg0 - 1, arg1 + 1) + noise(arg0 + 1, arg1 + 1);
		int var3 = noise(arg0 - 1, arg1) + noise(arg0 + 1, arg1) + noise(arg0, arg1 - 1) + noise(arg0, arg1 + 1);
		int var4 = noise(arg0, arg1);
		return var4 / 4 + var2 / 16 + var3 / 8;
	}

	@ObfuscatedName("ef.v(III)I")
	public static int noise(int arg0, int arg1) {
		int var2 = arg1 * 57 + arg0;
		int var3 = var2 << 13 ^ var2;
		int var4 = (var3 * var3 * 15731 + 789221) * var3 + 1376312589 & Integer.MAX_VALUE;
		return var4 >> 19 & 0xFF;
	}

	@ObfuscatedName("ch.w(IIB)I")
	public static int getUCol(int arg0, int arg1) {
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
	public static int getOCol(int arg0, int arg1) {
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
	public static int getTable(int arg0, int arg1, int arg2) {
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
	public static boolean isLocDownloaded(int arg0, int arg1) {
		LocType var2 = LocType.get(arg0);
		if (arg1 == 11) {
			arg1 = 10;
		}
		if (arg1 >= 5 && arg1 <= 8) {
			arg1 = 4;
		}
		return var2.isDownloaded(arg1);
	}

	@ObfuscatedName("bc.t(IIIIIIILaq;Lck;I)V")
	public static void addLoc(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, World arg7, CollisionMap arg8) {
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
		int[][] var16 = groundh[arg1];
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
			ModelSource var22;
			if (var9.anim == -1 && var9.multiloc == null) {
				var22 = var9.getModel(22, arg5, var16, var18, var17, var19);
			} else {
				var22 = new ClientLocAnim(arg4, 22, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.addGroundDecor(arg0, arg2, arg3, var17, var22, var20, var21);
			if (var9.blockwalk == 1) {
				arg8.blockGroundDecor(arg2, arg3);
			}
		} else if (arg6 == 10 || arg6 == 11) {
			ModelSource var45;
			if (var9.anim == -1 && var9.multiloc == null) {
				var45 = var9.getModel(10, arg5, var16, var18, var17, var19);
			} else {
				var45 = new ClientLocAnim(arg4, 10, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			if (var45 != null) {
				arg7.add(arg0, arg2, arg3, var17, var10, var11, var45, arg6 == 11 ? 256 : 0, var20, var21);
			}
			if (var9.blockwalk != 0) {
				arg8.addLoc(arg2, arg3, var10, var11, var9.blockrange);
			}
		} else if (arg6 >= 12) {
			ModelSource var23;
			if (var9.anim == -1 && var9.multiloc == null) {
				var23 = var9.getModel(arg6, arg5, var16, var18, var17, var19);
			} else {
				var23 = new ClientLocAnim(arg4, arg6, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.add(arg0, arg2, arg3, var17, 1, 1, var23, 0, var20, var21);
			if (var9.blockwalk != 0) {
				arg8.addLoc(arg2, arg3, var10, var11, var9.blockrange);
			}
		} else if (arg6 == 0) {
			ModelSource var24;
			if (var9.anim == -1 && var9.multiloc == null) {
				var24 = var9.getModel(0, arg5, var16, var18, var17, var19);
			} else {
				var24 = new ClientLocAnim(arg4, 0, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.addWall(arg0, arg2, arg3, var17, var24, null, WSHAPE0[arg5], 0, var20, var21);
			if (var9.blockwalk != 0) {
				arg8.addWall(arg2, arg3, arg6, arg5, var9.blockrange);
			}
		} else if (arg6 == 1) {
			ModelSource var25;
			if (var9.anim == -1 && var9.multiloc == null) {
				var25 = var9.getModel(1, arg5, var16, var18, var17, var19);
			} else {
				var25 = new ClientLocAnim(arg4, 1, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.addWall(arg0, arg2, arg3, var17, var25, null, WSHAPE1[arg5], 0, var20, var21);
			if (var9.blockwalk != 0) {
				arg8.addWall(arg2, arg3, arg6, arg5, var9.blockrange);
			}
		} else if (arg6 == 2) {
			int var26 = arg5 + 1 & 0x3;
			ModelSource var27;
			ModelSource var28;
			if (var9.anim == -1 && var9.multiloc == null) {
				var27 = var9.getModel(2, arg5 + 4, var16, var18, var17, var19);
				var28 = var9.getModel(2, var26, var16, var18, var17, var19);
			} else {
				var27 = new ClientLocAnim(arg4, 2, arg5 + 4, arg1, arg2, arg3, var9.anim, true, null);
				var28 = new ClientLocAnim(arg4, 2, var26, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.addWall(arg0, arg2, arg3, var17, var27, var28, WSHAPE0[arg5], WSHAPE0[var26], var20, var21);
			if (var9.blockwalk != 0) {
				arg8.addWall(arg2, arg3, arg6, arg5, var9.blockrange);
			}
		} else if (arg6 == 3) {
			ModelSource var29;
			if (var9.anim == -1 && var9.multiloc == null) {
				var29 = var9.getModel(3, arg5, var16, var18, var17, var19);
			} else {
				var29 = new ClientLocAnim(arg4, 3, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.addWall(arg0, arg2, arg3, var17, var29, null, WSHAPE1[arg5], 0, var20, var21);
			if (var9.blockwalk != 0) {
				arg8.addWall(arg2, arg3, arg6, arg5, var9.blockrange);
			}
		} else if (arg6 == 9) {
			ModelSource var30;
			if (var9.anim == -1 && var9.multiloc == null) {
				var30 = var9.getModel(arg6, arg5, var16, var18, var17, var19);
			} else {
				var30 = new ClientLocAnim(arg4, arg6, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.add(arg0, arg2, arg3, var17, 1, 1, var30, 0, var20, var21);
			if (var9.blockwalk != 0) {
				arg8.addLoc(arg2, arg3, var10, var11, var9.blockrange);
			}
		} else if (arg6 == 4) {
			ModelSource var31;
			if (var9.anim == -1 && var9.multiloc == null) {
				var31 = var9.getModel(4, arg5, var16, var18, var17, var19);
			} else {
				var31 = new ClientLocAnim(arg4, 4, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.addDecor(arg0, arg2, arg3, var17, var31, null, WSHAPE0[arg5], 0, 0, 0, var20, var21);
		} else if (arg6 == 5) {
			int var32 = 16;
			int var33 = arg7.wallType(arg0, arg2, arg3);
			if (var33 != 0) {
				var32 = LocType.get(var33 >> 14 & 0x7FFF).wallwidth;
			}
			ModelSource var34;
			if (var9.anim == -1 && var9.multiloc == null) {
				var34 = var9.getModel(4, arg5, var16, var18, var17, var19);
			} else {
				var34 = new ClientLocAnim(arg4, 4, arg5, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.addDecor(arg0, arg2, arg3, var17, var34, null, WSHAPE0[arg5], 0, DECORXOF[arg5] * var32, DECORZOF[arg5] * var32, var20, var21);
		} else if (arg6 == 6) {
			int var35 = 8;
			int var36 = arg7.wallType(arg0, arg2, arg3);
			if (var36 != 0) {
				var35 = LocType.get(var36 >> 14 & 0x7FFF).wallwidth / 2;
			}
			ModelSource var37;
			if (var9.anim == -1 && var9.multiloc == null) {
				var37 = var9.getModel(4, arg5 + 4, var16, var18, var17, var19);
			} else {
				var37 = new ClientLocAnim(arg4, 4, arg5 + 4, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.addDecor(arg0, arg2, arg3, var17, var37, null, 256, arg5, field31[arg5] * var35, field32[arg5] * var35, var20, var21);
		} else if (arg6 == 7) {
			int var38 = arg5 + 2 & 0x3;
			ModelSource var39;
			if (var9.anim == -1 && var9.multiloc == null) {
				var39 = var9.getModel(4, var38 + 4, var16, var18, var17, var19);
			} else {
				var39 = new ClientLocAnim(arg4, 4, var38 + 4, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.addDecor(arg0, arg2, arg3, var17, var39, null, 256, var38, 0, 0, var20, var21);
		} else if (arg6 == 8) {
			int var40 = 8;
			int var41 = arg7.wallType(arg0, arg2, arg3);
			if (var41 != 0) {
				var40 = LocType.get(var41 >> 14 & 0x7FFF).wallwidth / 2;
			}
			int var42 = arg5 + 2 & 0x3;
			ModelSource var43;
			ModelSource var44;
			if (var9.anim == -1 && var9.multiloc == null) {
				var43 = var9.getModel(4, arg5 + 4, var16, var18, var17, var19);
				var44 = var9.getModel(4, var42 + 4, var16, var18, var17, var19);
			} else {
				var43 = new ClientLocAnim(arg4, 4, arg5 + 4, arg1, arg2, arg3, var9.anim, true, null);
				var44 = new ClientLocAnim(arg4, 4, var42 + 4, arg1, arg2, arg3, var9.anim, true, null);
			}
			arg7.addDecor(arg0, arg2, arg3, var17, var43, var44, 256, arg5, field31[arg5] * var40, field32[arg5] * var40, var20, var21);
		}
	}

	public static void load() {
		minusedlevel = 99;
		floort1 = new byte[4][104][104];
		floort2 = new byte[4][104][104];
		floors = new byte[4][104][104];
		floorr = new byte[4][104][104];
		mapo = new int[4][105][105];
		shadow = new byte[4][105][105];
		lightmap = new int[105][105];
		huetot = new int[104];
		sattot = new int[104];
		ligtot = new int[104];
		comtot = new int[104];
		tot = new int[104];
	}
}
