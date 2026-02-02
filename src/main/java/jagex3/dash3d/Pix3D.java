package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.graphics.Pix2D;

// jag::oldscape::dash3d::Pix3D
@ObfuscatedName("fx")
public class Pix3D extends Pix2D {

	// jag::oldscape::dash3d::Pix3D::SetHClip
	@ObfuscatedName("fx.u")
	public static boolean hclip = false;

	@ObfuscatedName("fx.v")
	public static boolean opaque = false;

	@ObfuscatedName("fx.w")
	public static boolean lowMem = false;

	// jag::oldscape::dash3d::Pix3D::SetLowDetail
	@ObfuscatedName("fx.e")
	public static boolean lowDetail = true;

	// jag::oldscape::dash3d::Pix3D::SetTrans
	@ObfuscatedName("fx.b")
	public static int trans = 0;

	@ObfuscatedName("fx.a")
	public static int originX;

	@ObfuscatedName("fx.h")
	public static int originY;

	@ObfuscatedName("fx.x")
	public static int sizeX;

	@ObfuscatedName("fx.p")
	public static int sizeY;

	@ObfuscatedName("fx.ad")
	public static int minX;

	@ObfuscatedName("fx.ac")
	public static int maxX;

	@ObfuscatedName("fx.aa")
	public static int minY;

	@ObfuscatedName("fx.as")
	public static int maxY;

	@ObfuscatedName("fx.am")
	public static int[] scanline = new int[1024];

	// jag::oldscape::dash3d::Pix3D::m_colourTable
	@ObfuscatedName("fx.ap")
	public static int[] colourTable = new int[65536];

	@ObfuscatedName("fx.av")
	public static TextureProvider textureProvider;

	// jag::oldscape::dash3d::Pix3D::m_divTable
	@ObfuscatedName("fx.ak")
	public static int[] divTable = new int[512];

	// jag::oldscape::dash3d::Pix3D::m_divTable2
	@ObfuscatedName("fx.az")
	public static int[] divTable2 = new int[2048];

	// jag::oldscape::dash3d::Pix3D::m_sinTable
	@ObfuscatedName("fx.an")
	public static int[] sinTable = new int[2048];

	// jag::oldscape::dash3d::Pix3D::m_cosTable
	@ObfuscatedName("fx.ah")
	public static int[] cosTable = new int[2048];

	static {
		for (int i = 1; i < 512; i++) {
			divTable[i] = 32768 / i;
		}

		for (int i = 1; i < 2048; i++) {
			divTable2[i] = 65536 / i;
		}

		for (int i = 0; i < 2048; i++) {
			sinTable[i] = (int) (Math.sin((double) i * 0.0030679615D) * 65536.0D);
			cosTable[i] = (int) (Math.cos((double) i * 0.0030679615D) * 65536.0D);
		}
	}

	public Pix3D() throws Throwable {
		throw new Error();
	}

	// jag::oldscape::dash3d::Pix3D::SetRenderClipping
	@ObfuscatedName("fx.bm()V")
	public static void setRenderClipping() {
		setClipping(clipMinX, clipMinY, clipMaxX, clipMaxY);
	}

	// jag::oldscape::dash3d::Pix3D::SetClipping
	@ObfuscatedName("fx.bn(IIII)V")
	public static void setClipping(int arg0, int arg1, int arg2, int arg3) {
		sizeX = arg2 - arg0;
		sizeY = arg3 - arg1;
		resetOrigin();

		if (scanline.length < sizeY) {
			int var4 = sizeY;
			int var13 = var4 - 1;
			int var5 = var13 | var13 >>> 1;
			int var6 = var5 | var5 >>> 2;
			int var7 = var6 | var6 >>> 4;
			int var8 = var7 | var7 >>> 8;
			int var9 = var8 | var8 >>> 16;
			int var10 = var9 + 1;
			scanline = new int[var10];
		}

		int var11 = Pix2D.width * arg1 + arg0;
		for (int var12 = 0; var12 < sizeY; var12++) {
			scanline[var12] = var11;
			var11 += Pix2D.width;
		}
	}

	// jag::oldscape::dash3d::Pix3D::ResetOrigin
	@ObfuscatedName("fx.be()V")
	public static void resetOrigin() {
		originX = sizeX / 2;
		originY = sizeY / 2;
		minX = -originX;
		maxX = sizeX - originX;
		minY = -originY;
		maxY = sizeY - originY;
	}

	// jag::oldscape::dash3d::Pix3D::SetOrigin
	@ObfuscatedName("fx.bp(II)V")
	public static void setOrigin(int arg0, int arg1) {
		int var2 = scanline[0];
		int var3 = var2 / Pix2D.width;
		int var4 = var2 - Pix2D.width * var3;
		originX = arg0 - var4;
		originY = arg1 - var3;
		minX = -originX;
		maxX = sizeX - originX;
		minY = -originY;
		maxY = sizeY - originY;
	}

	// jag::oldscape::dash3d::Pix3D::SetTextures
	@ObfuscatedName("fx.ba(Law;)V")
	public static void setTextures(TextureProvider arg0) {
		textureProvider = arg0;
	}

	// jag::oldscape::dash3d::Pix3D::InitColourTable
	@ObfuscatedName("fx.bc(D)V")
	public static void initColourTable(double arg0) {
		initColourTable(arg0, 0, 512);
	}

	// jag::oldscape::dash3d::Pix3D::InitColourTable
	@ObfuscatedName("fx.br(DII)V")
	public static void initColourTable(double arg0, int arg1, int arg2) {
		double var4 = arg0 + (Math.random() * 0.03D - 0.015D);
		int var6 = arg1 * 128;
		for (int var7 = arg1; var7 < arg2; var7++) {
			double var8 = (double) (var7 >> 3) / 64.0D + 0.0078125D;
			double var10 = (double) (var7 & 0x7) / 8.0D + 0.0625D;
			for (int var12 = 0; var12 < 128; var12++) {
				double var13 = (double) var12 / 128.0D;
				double var15 = var13;
				double var17 = var13;
				double var19 = var13;
				if (var10 != 0.0D) {
					double var21;
					if (var13 < 0.5D) {
						var21 = (var10 + 1.0D) * var13;
					} else {
						var21 = var10 + var13 - var10 * var13;
					}
					double var23 = var13 * 2.0D - var21;
					double var25 = var8 + 0.3333333333333333D;
					if (var25 > 1.0D) {
						var25--;
					}
					double var29 = var8 - 0.3333333333333333D;
					if (var29 < 0.0D) {
						var29++;
					}
					if (var25 * 6.0D < 1.0D) {
						var15 = (var21 - var23) * 6.0D * var25 + var23;
					} else if (var25 * 2.0D < 1.0D) {
						var15 = var21;
					} else if (var25 * 3.0D < 2.0D) {
						var15 = (var21 - var23) * (0.6666666666666666D - var25) * 6.0D + var23;
					} else {
						var15 = var23;
					}
					if (var8 * 6.0D < 1.0D) {
						var17 = (var21 - var23) * 6.0D * var8 + var23;
					} else if (var8 * 2.0D < 1.0D) {
						var17 = var21;
					} else if (var8 * 3.0D < 2.0D) {
						var17 = (var21 - var23) * (0.6666666666666666D - var8) * 6.0D + var23;
					} else {
						var17 = var23;
					}
					if (var29 * 6.0D < 1.0D) {
						var19 = (var21 - var23) * 6.0D * var29 + var23;
					} else if (var29 * 2.0D < 1.0D) {
						var19 = var21;
					} else if (var29 * 3.0D < 2.0D) {
						var19 = (var21 - var23) * (0.6666666666666666D - var29) * 6.0D + var23;
					} else {
						var19 = var23;
					}
				}
				int var31 = (int) (var15 * 256.0D);
				int var32 = (int) (var17 * 256.0D);
				int var33 = (int) (var19 * 256.0D);
				int var34 = (var31 << 16) + (var32 << 8) + var33;
				int var35 = gammaCorrect(var34, var4);
				if (var35 == 0) {
					var35 = 1;
				}
				colourTable[var6++] = var35;
			}
		}
	}

	// jag::math::RunetekColour::GammaCorrectOSRS
	@ObfuscatedName("fx.bb(ID)I")
	public static int gammaCorrect(int arg0, double arg1) {
		double var3 = (double) (arg0 >> 16) / 256.0D;
		double var5 = (double) (arg0 >> 8 & 0xFF) / 256.0D;
		double var7 = (double) (arg0 & 0xFF) / 256.0D;
		double var9 = Math.pow(var3, arg1);
		double var11 = Math.pow(var5, arg1);
		double var13 = Math.pow(var7, arg1);
		int var15 = (int) (var9 * 256.0D);
		int var16 = (int) (var11 * 256.0D);
		int var17 = (int) (var13 * 256.0D);
		return (var15 << 16) + (var16 << 8) + var17;
	}

	// jag::oldscape::dash3d::Pix3D::SetHClip
	@ObfuscatedName("fx.bd(III)V")
	public static void setHClip(int arg0, int arg1, int arg2) {
		hclip = arg0 < 0 || arg0 > sizeX || arg1 < 0 || arg1 > sizeX || arg2 < 0 || arg2 > sizeX;
	}

	@ObfuscatedName("fx.cr(IIIIIIIII)V")
	public static void gouraudTriangle(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
		int var9 = arg4 - arg3;
		int var10 = arg1 - arg0;
		int var11 = arg5 - arg3;
		int var12 = arg2 - arg0;
		int var13 = arg7 - arg6;
		int var14 = arg8 - arg6;
		int var15;
		if (arg1 == arg2) {
			var15 = 0;
		} else {
			var15 = (arg5 - arg4 << 16) / (arg2 - arg1);
		}
		int var16;
		if (arg0 == arg1) {
			var16 = 0;
		} else {
			var16 = (var9 << 16) / var10;
		}
		int var17;
		if (arg0 == arg2) {
			var17 = 0;
		} else {
			var17 = (var11 << 16) / var12;
		}
		int var18 = var9 * var12 - var10 * var11;
		if (var18 == 0) {
			return;
		}
		int var19 = (var12 * var13 - var10 * var14 << 8) / var18;
		int var20 = (var9 * var14 - var11 * var13 << 8) / var18;
		if (arg0 <= arg1 && arg0 <= arg2) {
			if (arg0 < sizeY) {
				if (arg1 > sizeY) {
					arg1 = sizeY;
				}
				if (arg2 > sizeY) {
					arg2 = sizeY;
				}
				int var21 = (arg6 << 8) - arg3 * var19 + var19;
				if (arg1 < arg2) {
					int var22;
					int var23 = var22 = arg3 << 16;
					if (arg0 < 0) {
						var23 -= arg0 * var17;
						var22 -= arg0 * var16;
						var21 -= arg0 * var20;
						arg0 = 0;
					}
					int var24 = arg4 << 16;
					if (arg1 < 0) {
						var24 -= arg1 * var15;
						arg1 = 0;
					}
					if ((arg0 == arg1 || var17 >= var16) && (arg0 != arg1 || var17 <= var15)) {
						int var28 = arg2 - arg1;
						int var29 = arg1 - arg0;
						int var30 = scanline[arg0];
						while (true) {
							var29--;
							if (var29 < 0) {
								while (true) {
									var28--;
									if (var28 < 0) {
										return;
									}
									gouraudRaster(Pix2D.pixels, var30, 0, 0, var24 >> 16, var23 >> 16, var21, var19);
									var23 += var17;
									var24 += var15;
									var21 += var20;
									var30 += Pix2D.width;
								}
							}
							gouraudRaster(Pix2D.pixels, var30, 0, 0, var22 >> 16, var23 >> 16, var21, var19);
							var23 += var17;
							var22 += var16;
							var21 += var20;
							var30 += Pix2D.width;
						}
					} else {
						int var25 = arg2 - arg1;
						int var26 = arg1 - arg0;
						int var27 = scanline[arg0];
						while (true) {
							var26--;
							if (var26 < 0) {
								while (true) {
									var25--;
									if (var25 < 0) {
										return;
									}
									gouraudRaster(Pix2D.pixels, var27, 0, 0, var23 >> 16, var24 >> 16, var21, var19);
									var23 += var17;
									var24 += var15;
									var21 += var20;
									var27 += Pix2D.width;
								}
							}
							gouraudRaster(Pix2D.pixels, var27, 0, 0, var23 >> 16, var22 >> 16, var21, var19);
							var23 += var17;
							var22 += var16;
							var21 += var20;
							var27 += Pix2D.width;
						}
					}
				} else {
					int var31;
					int var32 = var31 = arg3 << 16;
					if (arg0 < 0) {
						var32 -= arg0 * var17;
						var31 -= arg0 * var16;
						var21 -= arg0 * var20;
						arg0 = 0;
					}
					int var33 = arg5 << 16;
					if (arg2 < 0) {
						var33 -= arg2 * var15;
						arg2 = 0;
					}
					if (arg0 != arg2 && var17 < var16 || arg0 == arg2 && var15 > var16) {
						int var34 = arg1 - arg2;
						int var35 = arg2 - arg0;
						int var36 = scanline[arg0];
						while (true) {
							var35--;
							if (var35 < 0) {
								while (true) {
									var34--;
									if (var34 < 0) {
										return;
									}
									gouraudRaster(Pix2D.pixels, var36, 0, 0, var33 >> 16, var31 >> 16, var21, var19);
									var33 += var15;
									var31 += var16;
									var21 += var20;
									var36 += Pix2D.width;
								}
							}
							gouraudRaster(Pix2D.pixels, var36, 0, 0, var32 >> 16, var31 >> 16, var21, var19);
							var32 += var17;
							var31 += var16;
							var21 += var20;
							var36 += Pix2D.width;
						}
					} else {
						int var37 = arg1 - arg2;
						int var38 = arg2 - arg0;
						int var39 = scanline[arg0];
						while (true) {
							var38--;
							if (var38 < 0) {
								while (true) {
									var37--;
									if (var37 < 0) {
										return;
									}
									gouraudRaster(Pix2D.pixels, var39, 0, 0, var31 >> 16, var33 >> 16, var21, var19);
									var33 += var15;
									var31 += var16;
									var21 += var20;
									var39 += Pix2D.width;
								}
							}
							gouraudRaster(Pix2D.pixels, var39, 0, 0, var31 >> 16, var32 >> 16, var21, var19);
							var32 += var17;
							var31 += var16;
							var21 += var20;
							var39 += Pix2D.width;
						}
					}
				}
			}
		} else if (arg1 <= arg2) {
			if (arg1 < sizeY) {
				if (arg2 > sizeY) {
					arg2 = sizeY;
				}
				if (arg0 > sizeY) {
					arg0 = sizeY;
				}
				int var40 = (arg7 << 8) - arg4 * var19 + var19;
				if (arg2 < arg0) {
					int var41;
					int var42 = var41 = arg4 << 16;
					if (arg1 < 0) {
						var42 -= arg1 * var16;
						var41 -= arg1 * var15;
						var40 -= arg1 * var20;
						arg1 = 0;
					}
					int var43 = arg5 << 16;
					if (arg2 < 0) {
						var43 -= arg2 * var17;
						arg2 = 0;
					}
					if ((arg1 == arg2 || var16 >= var15) && (arg1 != arg2 || var16 <= var17)) {
						int var47 = arg0 - arg2;
						int var48 = arg2 - arg1;
						int var49 = scanline[arg1];
						while (true) {
							var48--;
							if (var48 < 0) {
								while (true) {
									var47--;
									if (var47 < 0) {
										return;
									}
									gouraudRaster(Pix2D.pixels, var49, 0, 0, var43 >> 16, var42 >> 16, var40, var19);
									var42 += var16;
									var43 += var17;
									var40 += var20;
									var49 += Pix2D.width;
								}
							}
							gouraudRaster(Pix2D.pixels, var49, 0, 0, var41 >> 16, var42 >> 16, var40, var19);
							var42 += var16;
							var41 += var15;
							var40 += var20;
							var49 += Pix2D.width;
						}
					} else {
						int var44 = arg0 - arg2;
						int var45 = arg2 - arg1;
						int var46 = scanline[arg1];
						while (true) {
							var45--;
							if (var45 < 0) {
								while (true) {
									var44--;
									if (var44 < 0) {
										return;
									}
									gouraudRaster(Pix2D.pixels, var46, 0, 0, var42 >> 16, var43 >> 16, var40, var19);
									var42 += var16;
									var43 += var17;
									var40 += var20;
									var46 += Pix2D.width;
								}
							}
							gouraudRaster(Pix2D.pixels, var46, 0, 0, var42 >> 16, var41 >> 16, var40, var19);
							var42 += var16;
							var41 += var15;
							var40 += var20;
							var46 += Pix2D.width;
						}
					}
				} else {
					int var50;
					int var51 = var50 = arg4 << 16;
					if (arg1 < 0) {
						var51 -= arg1 * var16;
						var50 -= arg1 * var15;
						var40 -= arg1 * var20;
						arg1 = 0;
					}
					int var52 = arg3 << 16;
					if (arg0 < 0) {
						var52 -= arg0 * var17;
						arg0 = 0;
					}
					if (var16 < var15) {
						int var53 = arg2 - arg0;
						int var54 = arg0 - arg1;
						int var55 = scanline[arg1];
						while (true) {
							var54--;
							if (var54 < 0) {
								while (true) {
									var53--;
									if (var53 < 0) {
										return;
									}
									gouraudRaster(Pix2D.pixels, var55, 0, 0, var52 >> 16, var50 >> 16, var40, var19);
									var52 += var17;
									var50 += var15;
									var40 += var20;
									var55 += Pix2D.width;
								}
							}
							gouraudRaster(Pix2D.pixels, var55, 0, 0, var51 >> 16, var50 >> 16, var40, var19);
							var51 += var16;
							var50 += var15;
							var40 += var20;
							var55 += Pix2D.width;
						}
					} else {
						int var56 = arg2 - arg0;
						int var57 = arg0 - arg1;
						int var58 = scanline[arg1];
						while (true) {
							var57--;
							if (var57 < 0) {
								while (true) {
									var56--;
									if (var56 < 0) {
										return;
									}
									gouraudRaster(Pix2D.pixels, var58, 0, 0, var50 >> 16, var52 >> 16, var40, var19);
									var52 += var17;
									var50 += var15;
									var40 += var20;
									var58 += Pix2D.width;
								}
							}
							gouraudRaster(Pix2D.pixels, var58, 0, 0, var50 >> 16, var51 >> 16, var40, var19);
							var51 += var16;
							var50 += var15;
							var40 += var20;
							var58 += Pix2D.width;
						}
					}
				}
			}
		} else if (arg2 < sizeY) {
			if (arg0 > sizeY) {
				arg0 = sizeY;
			}
			if (arg1 > sizeY) {
				arg1 = sizeY;
			}
			int var59 = (arg8 << 8) - arg5 * var19 + var19;
			if (arg0 < arg1) {
				int var60;
				int var61 = var60 = arg5 << 16;
				if (arg2 < 0) {
					var61 -= arg2 * var15;
					var60 -= arg2 * var17;
					var59 -= arg2 * var20;
					arg2 = 0;
				}
				int var62 = arg3 << 16;
				if (arg0 < 0) {
					var62 -= arg0 * var16;
					arg0 = 0;
				}
				if (var15 < var17) {
					int var63 = arg1 - arg0;
					int var64 = arg0 - arg2;
					int var65 = scanline[arg2];
					while (true) {
						var64--;
						if (var64 < 0) {
							while (true) {
								var63--;
								if (var63 < 0) {
									return;
								}
								gouraudRaster(Pix2D.pixels, var65, 0, 0, var61 >> 16, var62 >> 16, var59, var19);
								var61 += var15;
								var62 += var16;
								var59 += var20;
								var65 += Pix2D.width;
							}
						}
						gouraudRaster(Pix2D.pixels, var65, 0, 0, var61 >> 16, var60 >> 16, var59, var19);
						var61 += var15;
						var60 += var17;
						var59 += var20;
						var65 += Pix2D.width;
					}
				} else {
					int var66 = arg1 - arg0;
					int var67 = arg0 - arg2;
					int var68 = scanline[arg2];
					while (true) {
						var67--;
						if (var67 < 0) {
							while (true) {
								var66--;
								if (var66 < 0) {
									return;
								}
								gouraudRaster(Pix2D.pixels, var68, 0, 0, var62 >> 16, var61 >> 16, var59, var19);
								var61 += var15;
								var62 += var16;
								var59 += var20;
								var68 += Pix2D.width;
							}
						}
						gouraudRaster(Pix2D.pixels, var68, 0, 0, var60 >> 16, var61 >> 16, var59, var19);
						var61 += var15;
						var60 += var17;
						var59 += var20;
						var68 += Pix2D.width;
					}
				}
			} else {
				int var69;
				int var70 = var69 = arg5 << 16;
				if (arg2 < 0) {
					var70 -= arg2 * var15;
					var69 -= arg2 * var17;
					var59 -= arg2 * var20;
					arg2 = 0;
				}
				int var71 = arg4 << 16;
				if (arg1 < 0) {
					var71 -= arg1 * var16;
					arg1 = 0;
				}
				if (var15 < var17) {
					int var72 = arg0 - arg1;
					int var73 = arg1 - arg2;
					int var74 = scanline[arg2];
					while (true) {
						var73--;
						if (var73 < 0) {
							while (true) {
								var72--;
								if (var72 < 0) {
									return;
								}
								gouraudRaster(Pix2D.pixels, var74, 0, 0, var71 >> 16, var69 >> 16, var59, var19);
								var71 += var16;
								var69 += var17;
								var59 += var20;
								var74 += Pix2D.width;
							}
						}
						gouraudRaster(Pix2D.pixels, var74, 0, 0, var70 >> 16, var69 >> 16, var59, var19);
						var70 += var15;
						var69 += var17;
						var59 += var20;
						var74 += Pix2D.width;
					}
				} else {
					int var75 = arg0 - arg1;
					int var76 = arg1 - arg2;
					int var77 = scanline[arg2];
					while (true) {
						var76--;
						if (var76 < 0) {
							while (true) {
								var75--;
								if (var75 < 0) {
									return;
								}
								gouraudRaster(Pix2D.pixels, var77, 0, 0, var69 >> 16, var71 >> 16, var59, var19);
								var71 += var16;
								var69 += var17;
								var59 += var20;
								var77 += Pix2D.width;
							}
						}
						gouraudRaster(Pix2D.pixels, var77, 0, 0, var69 >> 16, var70 >> 16, var59, var19);
						var70 += var15;
						var69 += var17;
						var59 += var20;
						var77 += Pix2D.width;
					}
				}
			}
		}
	}

	@ObfuscatedName("fx.cs([IIIIIIII)V")
	public static void gouraudRaster(int[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		if (hclip) {
			if (arg5 > sizeX) {
				arg5 = sizeX;
			}
			if (arg4 < 0) {
				arg4 = 0;
			}
		}
		if (arg4 >= arg5) {
			return;
		}
		int var8 = arg1 + arg4;
		int var9 = arg4 * arg7 + arg6;
		if (!lowDetail) {
			int var27 = arg5 - arg4;
			if (trans == 0) {
				do {
					arg0[var8++] = colourTable[var9 >> 8];
					var9 += arg7;
					var27--;
				} while (var27 > 0);
			} else {
				int var28 = trans;
				int var29 = 256 - trans;
				do {
					int var30 = colourTable[var9 >> 8];
					var9 += arg7;
					int var31 = ((var30 & 0xFF00FF) * var29 >> 8 & 0xFF00FF) + ((var30 & 0xFF00) * var29 >> 8 & 0xFF00);
					int var32 = arg0[var8];
					arg0[var8++] = ((var32 & 0xFF00) * var28 >> 8 & 0xFF00) + ((var32 & 0xFF00FF) * var28 >> 8 & 0xFF00FF) + var31;
					var27--;
				} while (var27 > 0);
			}
			return;
		}
		int var10 = arg5 - arg4 >> 2;
		int var11 = arg7 << 2;
		if (trans == 0) {
			if (var10 > 0) {
				do {
					int var12 = colourTable[var9 >> 8];
					var9 += var11;
					arg0[var8++] = var12;
					arg0[var8++] = var12;
					arg0[var8++] = var12;
					arg0[var8++] = var12;
					var10--;
				} while (var10 > 0);
			}
			int var13 = arg5 - arg4 & 0x3;
			if (var13 > 0) {
				int var14 = colourTable[var9 >> 8];
				do {
					arg0[var8++] = var14;
					var13--;
				} while (var13 > 0);
			}
			return;
		}
		int var15 = trans;
		int var16 = 256 - trans;
		if (var10 > 0) {
			do {
				int var17 = colourTable[var9 >> 8];
				var9 += var11;
				int var18 = ((var17 & 0xFF00FF) * var16 >> 8 & 0xFF00FF) + ((var17 & 0xFF00) * var16 >> 8 & 0xFF00);
				int var19 = arg0[var8];
				arg0[var8++] = ((var19 & 0xFF00) * var15 >> 8 & 0xFF00) + ((var19 & 0xFF00FF) * var15 >> 8 & 0xFF00FF) + var18;
				int var20 = arg0[var8];
				arg0[var8++] = ((var20 & 0xFF00) * var15 >> 8 & 0xFF00) + ((var20 & 0xFF00FF) * var15 >> 8 & 0xFF00FF) + var18;
				int var21 = arg0[var8];
				arg0[var8++] = ((var21 & 0xFF00) * var15 >> 8 & 0xFF00) + ((var21 & 0xFF00FF) * var15 >> 8 & 0xFF00FF) + var18;
				int var22 = arg0[var8];
				arg0[var8++] = ((var22 & 0xFF00) * var15 >> 8 & 0xFF00) + ((var22 & 0xFF00FF) * var15 >> 8 & 0xFF00FF) + var18;
				var10--;
			} while (var10 > 0);
		}
		int var23 = arg5 - arg4 & 0x3;
		if (var23 <= 0) {
			return;
		}
		int var24 = colourTable[var9 >> 8];
		int var25 = ((var24 & 0xFF00FF) * var16 >> 8 & 0xFF00FF) + ((var24 & 0xFF00) * var16 >> 8 & 0xFF00);
		do {
			int var26 = arg0[var8];
			arg0[var8++] = ((var26 & 0xFF00) * var15 >> 8 & 0xFF00) + ((var26 & 0xFF00FF) * var15 >> 8 & 0xFF00FF) + var25;
			var23--;
		} while (var23 > 0);
	}

	@ObfuscatedName("fx.cj(IIIIIII)V")
	public static void flatTriangle(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		int var7 = 0;
		if (arg0 != arg1) {
			var7 = (arg4 - arg3 << 16) / (arg1 - arg0);
		}
		int var8 = 0;
		if (arg1 != arg2) {
			var8 = (arg5 - arg4 << 16) / (arg2 - arg1);
		}
		int var9 = 0;
		if (arg0 != arg2) {
			var9 = (arg3 - arg5 << 16) / (arg0 - arg2);
		}
		if (arg0 <= arg1 && arg0 <= arg2) {
			if (arg0 < sizeY) {
				if (arg1 > sizeY) {
					arg1 = sizeY;
				}
				if (arg2 > sizeY) {
					arg2 = sizeY;
				}
				if (arg1 < arg2) {
					int var10;
					int var11 = var10 = arg3 << 16;
					if (arg0 < 0) {
						var11 -= arg0 * var9;
						var10 -= arg0 * var7;
						arg0 = 0;
					}
					int var12 = arg4 << 16;
					if (arg1 < 0) {
						var12 -= arg1 * var8;
						arg1 = 0;
					}
					if (arg0 != arg1 && var9 < var7 || arg0 == arg1 && var9 > var8) {
						int var13 = arg2 - arg1;
						int var14 = arg1 - arg0;
						int var15 = scanline[arg0];
						while (true) {
							var14--;
							if (var14 < 0) {
								while (true) {
									var13--;
									if (var13 < 0) {
										return;
									}
									flatRaster(Pix2D.pixels, var15, arg6, 0, var11 >> 16, var12 >> 16);
									var11 += var9;
									var12 += var8;
									var15 += Pix2D.width;
								}
							}
							flatRaster(Pix2D.pixels, var15, arg6, 0, var11 >> 16, var10 >> 16);
							var11 += var9;
							var10 += var7;
							var15 += Pix2D.width;
						}
					} else {
						int var16 = arg2 - arg1;
						int var17 = arg1 - arg0;
						int var18 = scanline[arg0];
						while (true) {
							var17--;
							if (var17 < 0) {
								while (true) {
									var16--;
									if (var16 < 0) {
										return;
									}
									flatRaster(Pix2D.pixels, var18, arg6, 0, var12 >> 16, var11 >> 16);
									var11 += var9;
									var12 += var8;
									var18 += Pix2D.width;
								}
							}
							flatRaster(Pix2D.pixels, var18, arg6, 0, var10 >> 16, var11 >> 16);
							var11 += var9;
							var10 += var7;
							var18 += Pix2D.width;
						}
					}
				} else {
					int var19;
					int var20 = var19 = arg3 << 16;
					if (arg0 < 0) {
						var20 -= arg0 * var9;
						var19 -= arg0 * var7;
						arg0 = 0;
					}
					int var21 = arg5 << 16;
					if (arg2 < 0) {
						var21 -= arg2 * var8;
						arg2 = 0;
					}
					if (arg0 != arg2 && var9 < var7 || arg0 == arg2 && var8 > var7) {
						int var22 = arg1 - arg2;
						int var23 = arg2 - arg0;
						int var24 = scanline[arg0];
						while (true) {
							var23--;
							if (var23 < 0) {
								while (true) {
									var22--;
									if (var22 < 0) {
										return;
									}
									flatRaster(Pix2D.pixels, var24, arg6, 0, var21 >> 16, var19 >> 16);
									var21 += var8;
									var19 += var7;
									var24 += Pix2D.width;
								}
							}
							flatRaster(Pix2D.pixels, var24, arg6, 0, var20 >> 16, var19 >> 16);
							var20 += var9;
							var19 += var7;
							var24 += Pix2D.width;
						}
					} else {
						int var25 = arg1 - arg2;
						int var26 = arg2 - arg0;
						int var27 = scanline[arg0];
						while (true) {
							var26--;
							if (var26 < 0) {
								while (true) {
									var25--;
									if (var25 < 0) {
										return;
									}
									flatRaster(Pix2D.pixels, var27, arg6, 0, var19 >> 16, var21 >> 16);
									var21 += var8;
									var19 += var7;
									var27 += Pix2D.width;
								}
							}
							flatRaster(Pix2D.pixels, var27, arg6, 0, var19 >> 16, var20 >> 16);
							var20 += var9;
							var19 += var7;
							var27 += Pix2D.width;
						}
					}
				}
			}
		} else if (arg1 <= arg2) {
			if (arg1 < sizeY) {
				if (arg2 > sizeY) {
					arg2 = sizeY;
				}
				if (arg0 > sizeY) {
					arg0 = sizeY;
				}
				if (arg2 < arg0) {
					int var28;
					int var29 = var28 = arg4 << 16;
					if (arg1 < 0) {
						var29 -= arg1 * var7;
						var28 -= arg1 * var8;
						arg1 = 0;
					}
					int var30 = arg5 << 16;
					if (arg2 < 0) {
						var30 -= arg2 * var9;
						arg2 = 0;
					}
					if (arg1 != arg2 && var7 < var8 || arg1 == arg2 && var7 > var9) {
						int var31 = arg0 - arg2;
						int var32 = arg2 - arg1;
						int var33 = scanline[arg1];
						while (true) {
							var32--;
							if (var32 < 0) {
								while (true) {
									var31--;
									if (var31 < 0) {
										return;
									}
									flatRaster(Pix2D.pixels, var33, arg6, 0, var29 >> 16, var30 >> 16);
									var29 += var7;
									var30 += var9;
									var33 += Pix2D.width;
								}
							}
							flatRaster(Pix2D.pixels, var33, arg6, 0, var29 >> 16, var28 >> 16);
							var29 += var7;
							var28 += var8;
							var33 += Pix2D.width;
						}
					} else {
						int var34 = arg0 - arg2;
						int var35 = arg2 - arg1;
						int var36 = scanline[arg1];
						while (true) {
							var35--;
							if (var35 < 0) {
								while (true) {
									var34--;
									if (var34 < 0) {
										return;
									}
									flatRaster(Pix2D.pixels, var36, arg6, 0, var30 >> 16, var29 >> 16);
									var29 += var7;
									var30 += var9;
									var36 += Pix2D.width;
								}
							}
							flatRaster(Pix2D.pixels, var36, arg6, 0, var28 >> 16, var29 >> 16);
							var29 += var7;
							var28 += var8;
							var36 += Pix2D.width;
						}
					}
				} else {
					int var37;
					int var38 = var37 = arg4 << 16;
					if (arg1 < 0) {
						var38 -= arg1 * var7;
						var37 -= arg1 * var8;
						arg1 = 0;
					}
					int var39 = arg3 << 16;
					if (arg0 < 0) {
						var39 -= arg0 * var9;
						arg0 = 0;
					}
					if (var7 < var8) {
						int var40 = arg2 - arg0;
						int var41 = arg0 - arg1;
						int var42 = scanline[arg1];
						while (true) {
							var41--;
							if (var41 < 0) {
								while (true) {
									var40--;
									if (var40 < 0) {
										return;
									}
									flatRaster(Pix2D.pixels, var42, arg6, 0, var39 >> 16, var37 >> 16);
									var39 += var9;
									var37 += var8;
									var42 += Pix2D.width;
								}
							}
							flatRaster(Pix2D.pixels, var42, arg6, 0, var38 >> 16, var37 >> 16);
							var38 += var7;
							var37 += var8;
							var42 += Pix2D.width;
						}
					} else {
						int var43 = arg2 - arg0;
						int var44 = arg0 - arg1;
						int var45 = scanline[arg1];
						while (true) {
							var44--;
							if (var44 < 0) {
								while (true) {
									var43--;
									if (var43 < 0) {
										return;
									}
									flatRaster(Pix2D.pixels, var45, arg6, 0, var37 >> 16, var39 >> 16);
									var39 += var9;
									var37 += var8;
									var45 += Pix2D.width;
								}
							}
							flatRaster(Pix2D.pixels, var45, arg6, 0, var37 >> 16, var38 >> 16);
							var38 += var7;
							var37 += var8;
							var45 += Pix2D.width;
						}
					}
				}
			}
		} else if (arg2 < sizeY) {
			if (arg0 > sizeY) {
				arg0 = sizeY;
			}
			if (arg1 > sizeY) {
				arg1 = sizeY;
			}
			if (arg0 < arg1) {
				int var46;
				int var47 = var46 = arg5 << 16;
				if (arg2 < 0) {
					var47 -= arg2 * var8;
					var46 -= arg2 * var9;
					arg2 = 0;
				}
				int var48 = arg3 << 16;
				if (arg0 < 0) {
					var48 -= arg0 * var7;
					arg0 = 0;
				}
				if (var8 < var9) {
					int var49 = arg1 - arg0;
					int var50 = arg0 - arg2;
					int var51 = scanline[arg2];
					while (true) {
						var50--;
						if (var50 < 0) {
							while (true) {
								var49--;
								if (var49 < 0) {
									return;
								}
								flatRaster(Pix2D.pixels, var51, arg6, 0, var47 >> 16, var48 >> 16);
								var47 += var8;
								var48 += var7;
								var51 += Pix2D.width;
							}
						}
						flatRaster(Pix2D.pixels, var51, arg6, 0, var47 >> 16, var46 >> 16);
						var47 += var8;
						var46 += var9;
						var51 += Pix2D.width;
					}
				} else {
					int var52 = arg1 - arg0;
					int var53 = arg0 - arg2;
					int var54 = scanline[arg2];
					while (true) {
						var53--;
						if (var53 < 0) {
							while (true) {
								var52--;
								if (var52 < 0) {
									return;
								}
								flatRaster(Pix2D.pixels, var54, arg6, 0, var48 >> 16, var47 >> 16);
								var47 += var8;
								var48 += var7;
								var54 += Pix2D.width;
							}
						}
						flatRaster(Pix2D.pixels, var54, arg6, 0, var46 >> 16, var47 >> 16);
						var47 += var8;
						var46 += var9;
						var54 += Pix2D.width;
					}
				}
			} else {
				int var55;
				int var56 = var55 = arg5 << 16;
				if (arg2 < 0) {
					var56 -= arg2 * var8;
					var55 -= arg2 * var9;
					arg2 = 0;
				}
				int var57 = arg4 << 16;
				if (arg1 < 0) {
					var57 -= arg1 * var7;
					arg1 = 0;
				}
				if (var8 < var9) {
					int var58 = arg0 - arg1;
					int var59 = arg1 - arg2;
					int var60 = scanline[arg2];
					while (true) {
						var59--;
						if (var59 < 0) {
							while (true) {
								var58--;
								if (var58 < 0) {
									return;
								}
								flatRaster(Pix2D.pixels, var60, arg6, 0, var57 >> 16, var55 >> 16);
								var57 += var7;
								var55 += var9;
								var60 += Pix2D.width;
							}
						}
						flatRaster(Pix2D.pixels, var60, arg6, 0, var56 >> 16, var55 >> 16);
						var56 += var8;
						var55 += var9;
						var60 += Pix2D.width;
					}
				} else {
					int var61 = arg0 - arg1;
					int var62 = arg1 - arg2;
					int var63 = scanline[arg2];
					while (true) {
						var62--;
						if (var62 < 0) {
							while (true) {
								var61--;
								if (var61 < 0) {
									return;
								}
								flatRaster(Pix2D.pixels, var63, arg6, 0, var55 >> 16, var57 >> 16);
								var57 += var7;
								var55 += var9;
								var63 += Pix2D.width;
							}
						}
						flatRaster(Pix2D.pixels, var63, arg6, 0, var55 >> 16, var56 >> 16);
						var56 += var8;
						var55 += var9;
						var63 += Pix2D.width;
					}
				}
			}
		}
	}

	@ObfuscatedName("fx.cl([IIIIII)V")
	public static void flatRaster(int[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		if (hclip) {
			if (arg5 > sizeX) {
				arg5 = sizeX;
			}
			if (arg4 < 0) {
				arg4 = 0;
			}
		}
		if (arg4 >= arg5) {
			return;
		}
		int var6 = arg1 + arg4;
		int var7 = arg5 - arg4 >> 2;
		if (trans == 0) {
			while (true) {
				var7--;
				if (var7 < 0) {
					int var8 = arg5 - arg4 & 0x3;
					while (true) {
						var8--;
						if (var8 < 0) {
							return;
						}
						arg0[var6++] = arg2;
					}
				}
				arg0[var6++] = arg2;
				arg0[var6++] = arg2;
				arg0[var6++] = arg2;
				arg0[var6++] = arg2;
			}
		} else if (trans == 254) {
			while (true) {
				var7--;
				if (var7 < 0) {
					int var9 = arg5 - arg4 & 0x3;
					while (true) {
						var9--;
						if (var9 < 0) {
							return;
						}
						arg0[var6++] = arg0[var6];
					}
				}
				arg0[var6++] = arg0[var6];
				arg0[var6++] = arg0[var6];
				arg0[var6++] = arg0[var6];
				arg0[var6++] = arg0[var6];
			}
		} else {
			int var10 = trans;
			int var11 = 256 - trans;
			int var12 = ((arg2 & 0xFF00FF) * var11 >> 8 & 0xFF00FF) + ((arg2 & 0xFF00) * var11 >> 8 & 0xFF00);
			while (true) {
				var7--;
				if (var7 < 0) {
					int var17 = arg5 - arg4 & 0x3;
					while (true) {
						var17--;
						if (var17 < 0) {
							return;
						}
						int var18 = arg0[var6];
						arg0[var6++] = ((var18 & 0xFF00) * var10 >> 8 & 0xFF00) + ((var18 & 0xFF00FF) * var10 >> 8 & 0xFF00FF) + var12;
					}
				}
				int var13 = arg0[var6];
				arg0[var6++] = ((var13 & 0xFF00) * var10 >> 8 & 0xFF00) + ((var13 & 0xFF00FF) * var10 >> 8 & 0xFF00FF) + var12;
				int var14 = arg0[var6];
				arg0[var6++] = ((var14 & 0xFF00) * var10 >> 8 & 0xFF00) + ((var14 & 0xFF00FF) * var10 >> 8 & 0xFF00FF) + var12;
				int var15 = arg0[var6];
				arg0[var6++] = ((var15 & 0xFF00) * var10 >> 8 & 0xFF00) + ((var15 & 0xFF00FF) * var10 >> 8 & 0xFF00FF) + var12;
				int var16 = arg0[var6];
				arg0[var6++] = ((var16 & 0xFF00) * var10 >> 8 & 0xFF00) + ((var16 & 0xFF00FF) * var10 >> 8 & 0xFF00FF) + var12;
			}
		}
	}

	@ObfuscatedName("fx.cp(IIIIIIIIIIIIIIIIIII)V")
	public static void textureTriangle(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18) {
		int[] var19 = textureProvider.getTexels(arg18);
		if (var19 == null) {
			int var20 = textureProvider.getAverageRgb(arg18);
			gouraudTriangle(arg0, arg1, arg2, arg3, arg4, arg5, textureLightColour(var20, arg6), textureLightColour(var20, arg7), textureLightColour(var20, arg8));
			return;
		}
		lowMem = textureProvider.isLowMem(arg18);
		opaque = textureProvider.isOpaque(arg18);
		int var21 = arg4 - arg3;
		int var22 = arg1 - arg0;
		int var23 = arg5 - arg3;
		int var24 = arg2 - arg0;
		int var25 = arg7 - arg6;
		int var26 = arg8 - arg6;
		int var27 = 0;
		if (arg0 != arg1) {
			var27 = (arg4 - arg3 << 16) / (arg1 - arg0);
		}
		int var28 = 0;
		if (arg1 != arg2) {
			var28 = (arg5 - arg4 << 16) / (arg2 - arg1);
		}
		int var29 = 0;
		if (arg0 != arg2) {
			var29 = (arg3 - arg5 << 16) / (arg0 - arg2);
		}
		int var30 = var21 * var24 - var22 * var23;
		if (var30 == 0) {
			return;
		}
		int var31 = (var24 * var25 - var22 * var26 << 9) / var30;
		int var32 = (var21 * var26 - var23 * var25 << 9) / var30;
		int var33 = arg9 - arg10;
		int var34 = arg12 - arg13;
		int var35 = arg15 - arg16;
		int var36 = arg11 - arg9;
		int var37 = arg14 - arg12;
		int var38 = arg17 - arg15;
		int var39 = arg12 * var36 - arg9 * var37 << 14;
		int var40 = arg15 * var37 - arg12 * var38 << 8;
		int var41 = arg9 * var38 - arg15 * var36 << 5;
		int var42 = arg12 * var33 - arg9 * var34 << 14;
		int var43 = arg15 * var34 - arg12 * var35 << 8;
		int var44 = arg9 * var35 - arg15 * var33 << 5;
		int var45 = var34 * var36 - var33 * var37 << 14;
		int var46 = var35 * var37 - var34 * var38 << 8;
		int var47 = var33 * var38 - var35 * var36 << 5;
		if (arg0 <= arg1 && arg0 <= arg2) {
			if (arg0 < sizeY) {
				if (arg1 > sizeY) {
					arg1 = sizeY;
				}
				if (arg2 > sizeY) {
					arg2 = sizeY;
				}
				int var48 = (arg6 << 9) - arg3 * var31 + var31;
				if (arg1 < arg2) {
					int var49;
					int var50 = var49 = arg3 << 16;
					if (arg0 < 0) {
						var50 -= arg0 * var29;
						var49 -= arg0 * var27;
						var48 -= arg0 * var32;
						arg0 = 0;
					}
					int var51 = arg4 << 16;
					if (arg1 < 0) {
						var51 -= arg1 * var28;
						arg1 = 0;
					}
					int var52 = arg0 - originY;
					int var53 = var41 * var52 + var39;
					int var54 = var44 * var52 + var42;
					int var55 = var47 * var52 + var45;
					if (arg0 != arg1 && var29 < var27 || arg0 == arg1 && var29 > var28) {
						int var56 = arg2 - arg1;
						int var57 = arg1 - arg0;
						int var58 = scanline[arg0];
						while (true) {
							var57--;
							if (var57 < 0) {
								while (true) {
									var56--;
									if (var56 < 0) {
										return;
									}
									textureRaster(Pix2D.pixels, var19, 0, 0, var58, var50 >> 16, var51 >> 16, var48, var31, var53, var54, var55, var40, var43, var46);
									var50 += var29;
									var51 += var28;
									var48 += var32;
									var58 += Pix2D.width;
									var53 += var41;
									var54 += var44;
									var55 += var47;
								}
							}
							textureRaster(Pix2D.pixels, var19, 0, 0, var58, var50 >> 16, var49 >> 16, var48, var31, var53, var54, var55, var40, var43, var46);
							var50 += var29;
							var49 += var27;
							var48 += var32;
							var58 += Pix2D.width;
							var53 += var41;
							var54 += var44;
							var55 += var47;
						}
					} else {
						int var59 = arg2 - arg1;
						int var60 = arg1 - arg0;
						int var61 = scanline[arg0];
						while (true) {
							var60--;
							if (var60 < 0) {
								while (true) {
									var59--;
									if (var59 < 0) {
										return;
									}
									textureRaster(Pix2D.pixels, var19, 0, 0, var61, var51 >> 16, var50 >> 16, var48, var31, var53, var54, var55, var40, var43, var46);
									var50 += var29;
									var51 += var28;
									var48 += var32;
									var61 += Pix2D.width;
									var53 += var41;
									var54 += var44;
									var55 += var47;
								}
							}
							textureRaster(Pix2D.pixels, var19, 0, 0, var61, var49 >> 16, var50 >> 16, var48, var31, var53, var54, var55, var40, var43, var46);
							var50 += var29;
							var49 += var27;
							var48 += var32;
							var61 += Pix2D.width;
							var53 += var41;
							var54 += var44;
							var55 += var47;
						}
					}
				} else {
					int var62;
					int var63 = var62 = arg3 << 16;
					if (arg0 < 0) {
						var63 -= arg0 * var29;
						var62 -= arg0 * var27;
						var48 -= arg0 * var32;
						arg0 = 0;
					}
					int var64 = arg5 << 16;
					if (arg2 < 0) {
						var64 -= arg2 * var28;
						arg2 = 0;
					}
					int var65 = arg0 - originY;
					int var66 = var41 * var65 + var39;
					int var67 = var44 * var65 + var42;
					int var68 = var47 * var65 + var45;
					if ((arg0 == arg2 || var29 >= var27) && (arg0 != arg2 || var28 <= var27)) {
						int var72 = arg1 - arg2;
						int var73 = arg2 - arg0;
						int var74 = scanline[arg0];
						while (true) {
							var73--;
							if (var73 < 0) {
								while (true) {
									var72--;
									if (var72 < 0) {
										return;
									}
									textureRaster(Pix2D.pixels, var19, 0, 0, var74, var62 >> 16, var64 >> 16, var48, var31, var66, var67, var68, var40, var43, var46);
									var64 += var28;
									var62 += var27;
									var48 += var32;
									var74 += Pix2D.width;
									var66 += var41;
									var67 += var44;
									var68 += var47;
								}
							}
							textureRaster(Pix2D.pixels, var19, 0, 0, var74, var62 >> 16, var63 >> 16, var48, var31, var66, var67, var68, var40, var43, var46);
							var63 += var29;
							var62 += var27;
							var48 += var32;
							var74 += Pix2D.width;
							var66 += var41;
							var67 += var44;
							var68 += var47;
						}
					} else {
						int var69 = arg1 - arg2;
						int var70 = arg2 - arg0;
						int var71 = scanline[arg0];
						while (true) {
							var70--;
							if (var70 < 0) {
								while (true) {
									var69--;
									if (var69 < 0) {
										return;
									}
									textureRaster(Pix2D.pixels, var19, 0, 0, var71, var64 >> 16, var62 >> 16, var48, var31, var66, var67, var68, var40, var43, var46);
									var64 += var28;
									var62 += var27;
									var48 += var32;
									var71 += Pix2D.width;
									var66 += var41;
									var67 += var44;
									var68 += var47;
								}
							}
							textureRaster(Pix2D.pixels, var19, 0, 0, var71, var63 >> 16, var62 >> 16, var48, var31, var66, var67, var68, var40, var43, var46);
							var63 += var29;
							var62 += var27;
							var48 += var32;
							var71 += Pix2D.width;
							var66 += var41;
							var67 += var44;
							var68 += var47;
						}
					}
				}
			}
		} else if (arg1 <= arg2) {
			if (arg1 < sizeY) {
				if (arg2 > sizeY) {
					arg2 = sizeY;
				}
				if (arg0 > sizeY) {
					arg0 = sizeY;
				}
				int var75 = (arg7 << 9) - arg4 * var31 + var31;
				if (arg2 < arg0) {
					int var76;
					int var77 = var76 = arg4 << 16;
					if (arg1 < 0) {
						var77 -= arg1 * var27;
						var76 -= arg1 * var28;
						var75 -= arg1 * var32;
						arg1 = 0;
					}
					int var78 = arg5 << 16;
					if (arg2 < 0) {
						var78 -= arg2 * var29;
						arg2 = 0;
					}
					int var79 = arg1 - originY;
					int var80 = var41 * var79 + var39;
					int var81 = var44 * var79 + var42;
					int var82 = var47 * var79 + var45;
					if (arg1 != arg2 && var27 < var28 || arg1 == arg2 && var27 > var29) {
						int var83 = arg0 - arg2;
						int var84 = arg2 - arg1;
						int var85 = scanline[arg1];
						while (true) {
							var84--;
							if (var84 < 0) {
								while (true) {
									var83--;
									if (var83 < 0) {
										return;
									}
									textureRaster(Pix2D.pixels, var19, 0, 0, var85, var77 >> 16, var78 >> 16, var75, var31, var80, var81, var82, var40, var43, var46);
									var77 += var27;
									var78 += var29;
									var75 += var32;
									var85 += Pix2D.width;
									var80 += var41;
									var81 += var44;
									var82 += var47;
								}
							}
							textureRaster(Pix2D.pixels, var19, 0, 0, var85, var77 >> 16, var76 >> 16, var75, var31, var80, var81, var82, var40, var43, var46);
							var77 += var27;
							var76 += var28;
							var75 += var32;
							var85 += Pix2D.width;
							var80 += var41;
							var81 += var44;
							var82 += var47;
						}
					} else {
						int var86 = arg0 - arg2;
						int var87 = arg2 - arg1;
						int var88 = scanline[arg1];
						while (true) {
							var87--;
							if (var87 < 0) {
								while (true) {
									var86--;
									if (var86 < 0) {
										return;
									}
									textureRaster(Pix2D.pixels, var19, 0, 0, var88, var78 >> 16, var77 >> 16, var75, var31, var80, var81, var82, var40, var43, var46);
									var77 += var27;
									var78 += var29;
									var75 += var32;
									var88 += Pix2D.width;
									var80 += var41;
									var81 += var44;
									var82 += var47;
								}
							}
							textureRaster(Pix2D.pixels, var19, 0, 0, var88, var76 >> 16, var77 >> 16, var75, var31, var80, var81, var82, var40, var43, var46);
							var77 += var27;
							var76 += var28;
							var75 += var32;
							var88 += Pix2D.width;
							var80 += var41;
							var81 += var44;
							var82 += var47;
						}
					}
				} else {
					int var89;
					int var90 = var89 = arg4 << 16;
					if (arg1 < 0) {
						var90 -= arg1 * var27;
						var89 -= arg1 * var28;
						var75 -= arg1 * var32;
						arg1 = 0;
					}
					int var91 = arg3 << 16;
					if (arg0 < 0) {
						var91 -= arg0 * var29;
						arg0 = 0;
					}
					int var92 = arg1 - originY;
					int var93 = var41 * var92 + var39;
					int var94 = var44 * var92 + var42;
					int var95 = var47 * var92 + var45;
					if (var27 < var28) {
						int var96 = arg2 - arg0;
						int var97 = arg0 - arg1;
						int var98 = scanline[arg1];
						while (true) {
							var97--;
							if (var97 < 0) {
								while (true) {
									var96--;
									if (var96 < 0) {
										return;
									}
									textureRaster(Pix2D.pixels, var19, 0, 0, var98, var91 >> 16, var89 >> 16, var75, var31, var93, var94, var95, var40, var43, var46);
									var91 += var29;
									var89 += var28;
									var75 += var32;
									var98 += Pix2D.width;
									var93 += var41;
									var94 += var44;
									var95 += var47;
								}
							}
							textureRaster(Pix2D.pixels, var19, 0, 0, var98, var90 >> 16, var89 >> 16, var75, var31, var93, var94, var95, var40, var43, var46);
							var90 += var27;
							var89 += var28;
							var75 += var32;
							var98 += Pix2D.width;
							var93 += var41;
							var94 += var44;
							var95 += var47;
						}
					} else {
						int var99 = arg2 - arg0;
						int var100 = arg0 - arg1;
						int var101 = scanline[arg1];
						while (true) {
							var100--;
							if (var100 < 0) {
								while (true) {
									var99--;
									if (var99 < 0) {
										return;
									}
									textureRaster(Pix2D.pixels, var19, 0, 0, var101, var89 >> 16, var91 >> 16, var75, var31, var93, var94, var95, var40, var43, var46);
									var91 += var29;
									var89 += var28;
									var75 += var32;
									var101 += Pix2D.width;
									var93 += var41;
									var94 += var44;
									var95 += var47;
								}
							}
							textureRaster(Pix2D.pixels, var19, 0, 0, var101, var89 >> 16, var90 >> 16, var75, var31, var93, var94, var95, var40, var43, var46);
							var90 += var27;
							var89 += var28;
							var75 += var32;
							var101 += Pix2D.width;
							var93 += var41;
							var94 += var44;
							var95 += var47;
						}
					}
				}
			}
		} else if (arg2 < sizeY) {
			if (arg0 > sizeY) {
				arg0 = sizeY;
			}
			if (arg1 > sizeY) {
				arg1 = sizeY;
			}
			int var102 = (arg8 << 9) - arg5 * var31 + var31;
			if (arg0 < arg1) {
				int var103;
				int var104 = var103 = arg5 << 16;
				if (arg2 < 0) {
					var104 -= arg2 * var28;
					var103 -= arg2 * var29;
					var102 -= arg2 * var32;
					arg2 = 0;
				}
				int var105 = arg3 << 16;
				if (arg0 < 0) {
					var105 -= arg0 * var27;
					arg0 = 0;
				}
				int var106 = arg2 - originY;
				int var107 = var41 * var106 + var39;
				int var108 = var44 * var106 + var42;
				int var109 = var47 * var106 + var45;
				if (var28 < var29) {
					int var110 = arg1 - arg0;
					int var111 = arg0 - arg2;
					int var112 = scanline[arg2];
					while (true) {
						var111--;
						if (var111 < 0) {
							while (true) {
								var110--;
								if (var110 < 0) {
									return;
								}
								textureRaster(Pix2D.pixels, var19, 0, 0, var112, var104 >> 16, var105 >> 16, var102, var31, var107, var108, var109, var40, var43, var46);
								var104 += var28;
								var105 += var27;
								var102 += var32;
								var112 += Pix2D.width;
								var107 += var41;
								var108 += var44;
								var109 += var47;
							}
						}
						textureRaster(Pix2D.pixels, var19, 0, 0, var112, var104 >> 16, var103 >> 16, var102, var31, var107, var108, var109, var40, var43, var46);
						var104 += var28;
						var103 += var29;
						var102 += var32;
						var112 += Pix2D.width;
						var107 += var41;
						var108 += var44;
						var109 += var47;
					}
				} else {
					int var113 = arg1 - arg0;
					int var114 = arg0 - arg2;
					int var115 = scanline[arg2];
					while (true) {
						var114--;
						if (var114 < 0) {
							while (true) {
								var113--;
								if (var113 < 0) {
									return;
								}
								textureRaster(Pix2D.pixels, var19, 0, 0, var115, var105 >> 16, var104 >> 16, var102, var31, var107, var108, var109, var40, var43, var46);
								var104 += var28;
								var105 += var27;
								var102 += var32;
								var115 += Pix2D.width;
								var107 += var41;
								var108 += var44;
								var109 += var47;
							}
						}
						textureRaster(Pix2D.pixels, var19, 0, 0, var115, var103 >> 16, var104 >> 16, var102, var31, var107, var108, var109, var40, var43, var46);
						var104 += var28;
						var103 += var29;
						var102 += var32;
						var115 += Pix2D.width;
						var107 += var41;
						var108 += var44;
						var109 += var47;
					}
				}
			} else {
				int var116;
				int var117 = var116 = arg5 << 16;
				if (arg2 < 0) {
					var117 -= arg2 * var28;
					var116 -= arg2 * var29;
					var102 -= arg2 * var32;
					arg2 = 0;
				}
				int var118 = arg4 << 16;
				if (arg1 < 0) {
					var118 -= arg1 * var27;
					arg1 = 0;
				}
				int var119 = arg2 - originY;
				int var120 = var41 * var119 + var39;
				int var121 = var44 * var119 + var42;
				int var122 = var47 * var119 + var45;
				if (var28 < var29) {
					int var123 = arg0 - arg1;
					int var124 = arg1 - arg2;
					int var125 = scanline[arg2];
					while (true) {
						var124--;
						if (var124 < 0) {
							while (true) {
								var123--;
								if (var123 < 0) {
									return;
								}
								textureRaster(Pix2D.pixels, var19, 0, 0, var125, var118 >> 16, var116 >> 16, var102, var31, var120, var121, var122, var40, var43, var46);
								var118 += var27;
								var116 += var29;
								var102 += var32;
								var125 += Pix2D.width;
								var120 += var41;
								var121 += var44;
								var122 += var47;
							}
						}
						textureRaster(Pix2D.pixels, var19, 0, 0, var125, var117 >> 16, var116 >> 16, var102, var31, var120, var121, var122, var40, var43, var46);
						var117 += var28;
						var116 += var29;
						var102 += var32;
						var125 += Pix2D.width;
						var120 += var41;
						var121 += var44;
						var122 += var47;
					}
				} else {
					int var126 = arg0 - arg1;
					int var127 = arg1 - arg2;
					int var128 = scanline[arg2];
					while (true) {
						var127--;
						if (var127 < 0) {
							while (true) {
								var126--;
								if (var126 < 0) {
									return;
								}
								textureRaster(Pix2D.pixels, var19, 0, 0, var128, var116 >> 16, var118 >> 16, var102, var31, var120, var121, var122, var40, var43, var46);
								var118 += var27;
								var116 += var29;
								var102 += var32;
								var128 += Pix2D.width;
								var120 += var41;
								var121 += var44;
								var122 += var47;
							}
						}
						textureRaster(Pix2D.pixels, var19, 0, 0, var128, var116 >> 16, var117 >> 16, var102, var31, var120, var121, var122, var40, var43, var46);
						var117 += var28;
						var116 += var29;
						var102 += var32;
						var128 += Pix2D.width;
						var120 += var41;
						var121 += var44;
						var122 += var47;
					}
				}
			}
		}
	}

	@ObfuscatedName("fx.ca([I[IIIIIIIIIIIIII)V")
	public static void textureRaster(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14) {
		if (hclip) {
			if (arg6 > sizeX) {
				arg6 = sizeX;
			}
			if (arg5 < 0) {
				arg5 = 0;
			}
		}
		if (arg5 >= arg6) {
			return;
		}
		int var15 = arg4 + arg5;
		int var16 = arg5 * arg8 + arg7;
		int var17 = arg6 - arg5;
		int var10000;
		if (!lowMem) {
			int var78 = arg5 - originX;
			int var79 = (arg12 >> 3) * var78 + arg9;
			int var80 = (arg13 >> 3) * var78 + arg10;
			int var81 = (arg14 >> 3) * var78 + arg11;
			int var82 = var81 >> 14;
			int var83;
			int var84;
			if (var82 == 0) {
				var83 = 0;
				var84 = 0;
			} else {
				var83 = var79 / var82;
				var84 = var80 / var82;
				if (var83 < 0) {
					var83 = 0;
				} else if (var83 > 16256) {
					var83 = 16256;
				}
			}
			int var85 = arg12 + var79;
			int var86 = arg13 + var80;
			int var87 = arg14 + var81;
			int var88 = var87 >> 14;
			int var89;
			int var90;
			if (var88 == 0) {
				var89 = 0;
				var90 = 0;
			} else {
				var89 = var85 / var88;
				var90 = var86 / var88;
				if (var89 < 0) {
					var89 = 0;
				} else if (var89 > 16256) {
					var89 = 16256;
				}
			}
			int var91 = (var83 << 18) + var84;
			int var92 = (var89 - var83 >> 3 << 18) + (var90 - var84 >> 3);
			int var93 = var17 >> 3;
			int var94 = arg8 << 3;
			int var95 = var16 >> 8;
			if (opaque) {
				if (var93 > 0) {
					do {
						int var96 = arg1[(var91 >>> 25) + (var91 & 0x3F80)];
						arg0[var15++] = ((var96 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var96 & 0xFF00) * var95 & 0xFF0000) >> 8;
						int var97 = var91 + var92;
						int var98 = arg1[(var97 >>> 25) + (var97 & 0x3F80)];
						arg0[var15++] = ((var98 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var98 & 0xFF00) * var95 & 0xFF0000) >> 8;
						int var99 = var92 + var97;
						int var100 = arg1[(var99 >>> 25) + (var99 & 0x3F80)];
						arg0[var15++] = ((var100 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var100 & 0xFF00) * var95 & 0xFF0000) >> 8;
						int var101 = var92 + var99;
						int var102 = arg1[(var101 >>> 25) + (var101 & 0x3F80)];
						arg0[var15++] = ((var102 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var102 & 0xFF00) * var95 & 0xFF0000) >> 8;
						int var103 = var92 + var101;
						int var104 = arg1[(var103 >>> 25) + (var103 & 0x3F80)];
						arg0[var15++] = ((var104 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var104 & 0xFF00) * var95 & 0xFF0000) >> 8;
						int var105 = var92 + var103;
						int var106 = arg1[(var105 >>> 25) + (var105 & 0x3F80)];
						arg0[var15++] = ((var106 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var106 & 0xFF00) * var95 & 0xFF0000) >> 8;
						int var107 = var92 + var105;
						int var108 = arg1[(var107 >>> 25) + (var107 & 0x3F80)];
						arg0[var15++] = ((var108 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var108 & 0xFF00) * var95 & 0xFF0000) >> 8;
						int var109 = var92 + var107;
						int var110 = arg1[(var109 >>> 25) + (var109 & 0x3F80)];
						arg0[var15++] = ((var110 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var110 & 0xFF00) * var95 & 0xFF0000) >> 8;
						var10000 = var92 + var109;
						int var112 = var89;
						int var113 = var90;
						var85 += arg12;
						var86 += arg13;
						var87 += arg14;
						int var114 = var87 >> 14;
						if (var114 == 0) {
							var89 = 0;
							var90 = 0;
						} else {
							var89 = var85 / var114;
							var90 = var86 / var114;
							if (var89 < 0) {
								var89 = 0;
							} else if (var89 > 16256) {
								var89 = 16256;
							}
						}
						var91 = (var112 << 18) + var113;
						var92 = (var89 - var112 >> 3 << 18) + (var90 - var113 >> 3);
						var16 += var94;
						var95 = var16 >> 8;
						var93--;
					} while (var93 > 0);
				}
				int var115 = arg6 - arg5 & 0x7;
				if (var115 > 0) {
					do {
						int var116 = arg1[(var91 >>> 25) + (var91 & 0x3F80)];
						arg0[var15++] = ((var116 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var116 & 0xFF00) * var95 & 0xFF0000) >> 8;
						var91 += var92;
						var115--;
					} while (var115 > 0);
				}
			} else {
				if (var93 > 0) {
					do {
						int var117;
						if ((var117 = arg1[(var91 >>> 25) + (var91 & 0x3F80)]) != 0) {
							arg0[var15] = ((var117 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var117 & 0xFF00) * var95 & 0xFF0000) >> 8;
						}
						var15++;
						int var118 = var91 + var92;
						int var119;
						if ((var119 = arg1[(var118 >>> 25) + (var118 & 0x3F80)]) != 0) {
							arg0[var15] = ((var119 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var119 & 0xFF00) * var95 & 0xFF0000) >> 8;
						}
						var15++;
						int var120 = var92 + var118;
						int var121;
						if ((var121 = arg1[(var120 >>> 25) + (var120 & 0x3F80)]) != 0) {
							arg0[var15] = ((var121 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var121 & 0xFF00) * var95 & 0xFF0000) >> 8;
						}
						var15++;
						int var122 = var92 + var120;
						int var123;
						if ((var123 = arg1[(var122 >>> 25) + (var122 & 0x3F80)]) != 0) {
							arg0[var15] = ((var123 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var123 & 0xFF00) * var95 & 0xFF0000) >> 8;
						}
						var15++;
						int var124 = var92 + var122;
						int var125;
						if ((var125 = arg1[(var124 >>> 25) + (var124 & 0x3F80)]) != 0) {
							arg0[var15] = ((var125 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var125 & 0xFF00) * var95 & 0xFF0000) >> 8;
						}
						var15++;
						int var126 = var92 + var124;
						int var127;
						if ((var127 = arg1[(var126 >>> 25) + (var126 & 0x3F80)]) != 0) {
							arg0[var15] = ((var127 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var127 & 0xFF00) * var95 & 0xFF0000) >> 8;
						}
						var15++;
						int var128 = var92 + var126;
						int var129;
						if ((var129 = arg1[(var128 >>> 25) + (var128 & 0x3F80)]) != 0) {
							arg0[var15] = ((var129 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var129 & 0xFF00) * var95 & 0xFF0000) >> 8;
						}
						var15++;
						int var130 = var92 + var128;
						int var131;
						if ((var131 = arg1[(var130 >>> 25) + (var130 & 0x3F80)]) != 0) {
							arg0[var15] = ((var131 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var131 & 0xFF00) * var95 & 0xFF0000) >> 8;
						}
						var15++;
						var10000 = var92 + var130;
						int var133 = var89;
						int var134 = var90;
						var85 += arg12;
						var86 += arg13;
						var87 += arg14;
						int var135 = var87 >> 14;
						if (var135 == 0) {
							var89 = 0;
							var90 = 0;
						} else {
							var89 = var85 / var135;
							var90 = var86 / var135;
							if (var89 < 0) {
								var89 = 0;
							} else if (var89 > 16256) {
								var89 = 16256;
							}
						}
						var91 = (var133 << 18) + var134;
						var92 = (var89 - var133 >> 3 << 18) + (var90 - var134 >> 3);
						var16 += var94;
						var95 = var16 >> 8;
						var93--;
					} while (var93 > 0);
				}
				int var136 = arg6 - arg5 & 0x7;
				if (var136 > 0) {
					do {
						int var137;
						if ((var137 = arg1[(var91 >>> 25) + (var91 & 0x3F80)]) != 0) {
							arg0[var15] = ((var137 & 0xFF00FF) * var95 & 0xFF00FF00) + ((var137 & 0xFF00) * var95 & 0xFF0000) >> 8;
						}
						var15++;
						var91 += var92;
						var136--;
					} while (var136 > 0);
				}
			}
			return;
		}
		int var18 = arg5 - originX;
		int var19 = (arg12 >> 3) * var18 + arg9;
		int var20 = (arg13 >> 3) * var18 + arg10;
		int var21 = (arg14 >> 3) * var18 + arg11;
		int var22 = var21 >> 12;
		int var23;
		int var24;
		if (var22 == 0) {
			var23 = 0;
			var24 = 0;
		} else {
			var23 = var19 / var22;
			var24 = var20 / var22;
			if (var23 < 0) {
				var23 = 0;
			} else if (var23 > 4032) {
				var23 = 4032;
			}
		}
		int var25 = arg12 + var19;
		int var26 = arg13 + var20;
		int var27 = arg14 + var21;
		int var28 = var27 >> 12;
		int var29;
		int var30;
		if (var28 == 0) {
			var29 = 0;
			var30 = 0;
		} else {
			var29 = var25 / var28;
			var30 = var26 / var28;
			if (var29 < 0) {
				var29 = 0;
			} else if (var29 > 4032) {
				var29 = 4032;
			}
		}
		int var31 = (var23 << 20) + var24;
		int var32 = (var29 - var23 >> 3 << 20) + (var30 - var24 >> 3);
		int var33 = var17 >> 3;
		int var34 = arg8 << 3;
		int var35 = var16 >> 8;
		if (opaque) {
			if (var33 > 0) {
				do {
					int var36 = arg1[(var31 >>> 26) + (var31 & 0xFC0)];
					arg0[var15++] = ((var36 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var36 & 0xFF00) * var35 & 0xFF0000) >> 8;
					int var37 = var31 + var32;
					int var38 = arg1[(var37 >>> 26) + (var37 & 0xFC0)];
					arg0[var15++] = ((var38 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var38 & 0xFF00) * var35 & 0xFF0000) >> 8;
					int var39 = var32 + var37;
					int var40 = arg1[(var39 >>> 26) + (var39 & 0xFC0)];
					arg0[var15++] = ((var40 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var40 & 0xFF00) * var35 & 0xFF0000) >> 8;
					int var41 = var32 + var39;
					int var42 = arg1[(var41 >>> 26) + (var41 & 0xFC0)];
					arg0[var15++] = ((var42 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var42 & 0xFF00) * var35 & 0xFF0000) >> 8;
					int var43 = var32 + var41;
					int var44 = arg1[(var43 >>> 26) + (var43 & 0xFC0)];
					arg0[var15++] = ((var44 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var44 & 0xFF00) * var35 & 0xFF0000) >> 8;
					int var45 = var32 + var43;
					int var46 = arg1[(var45 >>> 26) + (var45 & 0xFC0)];
					arg0[var15++] = ((var46 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var46 & 0xFF00) * var35 & 0xFF0000) >> 8;
					int var47 = var32 + var45;
					int var48 = arg1[(var47 >>> 26) + (var47 & 0xFC0)];
					arg0[var15++] = ((var48 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var48 & 0xFF00) * var35 & 0xFF0000) >> 8;
					int var49 = var32 + var47;
					int var50 = arg1[(var49 >>> 26) + (var49 & 0xFC0)];
					arg0[var15++] = ((var50 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var50 & 0xFF00) * var35 & 0xFF0000) >> 8;
					var10000 = var32 + var49;
					int var52 = var29;
					int var53 = var30;
					var25 += arg12;
					var26 += arg13;
					var27 += arg14;
					int var54 = var27 >> 12;
					if (var54 == 0) {
						var29 = 0;
						var30 = 0;
					} else {
						var29 = var25 / var54;
						var30 = var26 / var54;
						if (var29 < 0) {
							var29 = 0;
						} else if (var29 > 4032) {
							var29 = 4032;
						}
					}
					var31 = (var52 << 20) + var53;
					var32 = (var29 - var52 >> 3 << 20) + (var30 - var53 >> 3);
					var16 += var34;
					var35 = var16 >> 8;
					var33--;
				} while (var33 > 0);
			}
			int var55 = arg6 - arg5 & 0x7;
			if (var55 > 0) {
				do {
					int var56 = arg1[(var31 >>> 26) + (var31 & 0xFC0)];
					arg0[var15++] = ((var56 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var56 & 0xFF00) * var35 & 0xFF0000) >> 8;
					var31 += var32;
					var55--;
				} while (var55 > 0);
			}
			return;
		}
		if (var33 > 0) {
			do {
				int var57;
				if ((var57 = arg1[(var31 >>> 26) + (var31 & 0xFC0)]) != 0) {
					arg0[var15] = ((var57 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var57 & 0xFF00) * var35 & 0xFF0000) >> 8;
				}
				var15++;
				int var58 = var31 + var32;
				int var59;
				if ((var59 = arg1[(var58 >>> 26) + (var58 & 0xFC0)]) != 0) {
					arg0[var15] = ((var59 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var59 & 0xFF00) * var35 & 0xFF0000) >> 8;
				}
				var15++;
				int var60 = var32 + var58;
				int var61;
				if ((var61 = arg1[(var60 >>> 26) + (var60 & 0xFC0)]) != 0) {
					arg0[var15] = ((var61 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var61 & 0xFF00) * var35 & 0xFF0000) >> 8;
				}
				var15++;
				int var62 = var32 + var60;
				int var63;
				if ((var63 = arg1[(var62 >>> 26) + (var62 & 0xFC0)]) != 0) {
					arg0[var15] = ((var63 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var63 & 0xFF00) * var35 & 0xFF0000) >> 8;
				}
				var15++;
				int var64 = var32 + var62;
				int var65;
				if ((var65 = arg1[(var64 >>> 26) + (var64 & 0xFC0)]) != 0) {
					arg0[var15] = ((var65 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var65 & 0xFF00) * var35 & 0xFF0000) >> 8;
				}
				var15++;
				int var66 = var32 + var64;
				int var67;
				if ((var67 = arg1[(var66 >>> 26) + (var66 & 0xFC0)]) != 0) {
					arg0[var15] = ((var67 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var67 & 0xFF00) * var35 & 0xFF0000) >> 8;
				}
				var15++;
				int var68 = var32 + var66;
				int var69;
				if ((var69 = arg1[(var68 >>> 26) + (var68 & 0xFC0)]) != 0) {
					arg0[var15] = ((var69 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var69 & 0xFF00) * var35 & 0xFF0000) >> 8;
				}
				var15++;
				int var70 = var32 + var68;
				int var71;
				if ((var71 = arg1[(var70 >>> 26) + (var70 & 0xFC0)]) != 0) {
					arg0[var15] = ((var71 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var71 & 0xFF00) * var35 & 0xFF0000) >> 8;
				}
				var15++;
				var10000 = var32 + var70;
				int var73 = var29;
				int var74 = var30;
				var25 += arg12;
				var26 += arg13;
				var27 += arg14;
				int var75 = var27 >> 12;
				if (var75 == 0) {
					var29 = 0;
					var30 = 0;
				} else {
					var29 = var25 / var75;
					var30 = var26 / var75;
					if (var29 < 0) {
						var29 = 0;
					} else if (var29 > 4032) {
						var29 = 4032;
					}
				}
				var31 = (var73 << 20) + var74;
				var32 = (var29 - var73 >> 3 << 20) + (var30 - var74 >> 3);
				var16 += var34;
				var35 = var16 >> 8;
				var33--;
			} while (var33 > 0);
		}
		int var76 = arg6 - arg5 & 0x7;
		if (var76 <= 0) {
			return;
		}
		do {
			int var77;
			if ((var77 = arg1[(var31 >>> 26) + (var31 & 0xFC0)]) != 0) {
				arg0[var15] = ((var77 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var77 & 0xFF00) * var35 & 0xFF0000) >> 8;
			}
			var15++;
			var31 += var32;
			var76--;
		} while (var76 > 0);
	}

	// jag::oldscape::dash3d::SoftwarePix3D::TextureTriangleAffine
	@ObfuscatedName("fx.co(IIIIIIIIIIIIIIIIIII)V")
	public static void textureTriangleAffine(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18) {
		int[] var19 = textureProvider.getTexels(arg18);
		if (var19 == null) {
			int var20 = textureProvider.getAverageRgb(arg18);
			gouraudTriangle(arg0, arg1, arg2, arg3, arg4, arg5, textureLightColour(var20, arg6), textureLightColour(var20, arg7), textureLightColour(var20, arg8));
			return;
		}
		lowMem = textureProvider.isLowMem(arg18);
		opaque = textureProvider.isOpaque(arg18);
		int var21 = arg4 - arg3;
		int var22 = arg1 - arg0;
		int var23 = arg5 - arg3;
		int var24 = arg2 - arg0;
		int var25 = arg7 - arg6;
		int var26 = arg8 - arg6;
		int var27 = 0;
		if (arg0 != arg1) {
			var27 = (arg4 - arg3 << 16) / (arg1 - arg0);
		}
		int var28 = 0;
		if (arg1 != arg2) {
			var28 = (arg5 - arg4 << 16) / (arg2 - arg1);
		}
		int var29 = 0;
		if (arg0 != arg2) {
			var29 = (arg3 - arg5 << 16) / (arg0 - arg2);
		}
		int var30 = var21 * var24 - var22 * var23;
		if (var30 == 0) {
			return;
		}
		int var31 = (var24 * var25 - var22 * var26 << 9) / var30;
		int var32 = (var21 * var26 - var23 * var25 << 9) / var30;
		int var33 = arg9 - arg10;
		int var34 = arg12 - arg13;
		int var35 = arg15 - arg16;
		int var36 = arg11 - arg9;
		int var37 = arg14 - arg12;
		int var38 = arg17 - arg15;
		int var39 = arg12 * var36 - arg9 * var37 << 14;
		int var40 = arg15 * var37 - arg12 * var38 << 5;
		int var41 = arg9 * var38 - arg15 * var36 << 5;
		int var42 = arg12 * var33 - arg9 * var34 << 14;
		int var43 = arg15 * var34 - arg12 * var35 << 5;
		int var44 = arg9 * var35 - arg15 * var33 << 5;
		int var45 = var34 * var36 - var33 * var37 << 14;
		int var46 = var35 * var37 - var34 * var38 << 5;
		int var47 = var33 * var38 - var35 * var36 << 5;
		if (arg0 <= arg1 && arg0 <= arg2) {
			if (arg0 < sizeY) {
				if (arg1 > sizeY) {
					arg1 = sizeY;
				}
				if (arg2 > sizeY) {
					arg2 = sizeY;
				}
				int var48 = (arg6 << 9) - arg3 * var31 + var31;
				if (arg1 < arg2) {
					int var49;
					int var50 = var49 = arg3 << 16;
					if (arg0 < 0) {
						var50 -= arg0 * var29;
						var49 -= arg0 * var27;
						var48 -= arg0 * var32;
						arg0 = 0;
					}
					int var51 = arg4 << 16;
					if (arg1 < 0) {
						var51 -= arg1 * var28;
						arg1 = 0;
					}
					int var52 = arg0 - originY;
					int var53 = var41 * var52 + var39;
					int var54 = var44 * var52 + var42;
					int var55 = var47 * var52 + var45;
					if (arg0 != arg1 && var29 < var27 || arg0 == arg1 && var29 > var28) {
						int var56 = arg2 - arg1;
						int var57 = arg1 - arg0;
						int var58 = scanline[arg0];
						while (true) {
							var57--;
							if (var57 < 0) {
								while (true) {
									var56--;
									if (var56 < 0) {
										return;
									}
									textureRasterAffine(Pix2D.pixels, var19, 0, 0, var58, var50 >> 16, var51 >> 16, var48, var31, var53, var54, var55, var40, var43, var46);
									var50 += var29;
									var51 += var28;
									var48 += var32;
									var58 += Pix2D.width;
									var53 += var41;
									var54 += var44;
									var55 += var47;
								}
							}
							textureRasterAffine(Pix2D.pixels, var19, 0, 0, var58, var50 >> 16, var49 >> 16, var48, var31, var53, var54, var55, var40, var43, var46);
							var50 += var29;
							var49 += var27;
							var48 += var32;
							var58 += Pix2D.width;
							var53 += var41;
							var54 += var44;
							var55 += var47;
						}
					} else {
						int var59 = arg2 - arg1;
						int var60 = arg1 - arg0;
						int var61 = scanline[arg0];
						while (true) {
							var60--;
							if (var60 < 0) {
								while (true) {
									var59--;
									if (var59 < 0) {
										return;
									}
									textureRasterAffine(Pix2D.pixels, var19, 0, 0, var61, var51 >> 16, var50 >> 16, var48, var31, var53, var54, var55, var40, var43, var46);
									var50 += var29;
									var51 += var28;
									var48 += var32;
									var61 += Pix2D.width;
									var53 += var41;
									var54 += var44;
									var55 += var47;
								}
							}
							textureRasterAffine(Pix2D.pixels, var19, 0, 0, var61, var49 >> 16, var50 >> 16, var48, var31, var53, var54, var55, var40, var43, var46);
							var50 += var29;
							var49 += var27;
							var48 += var32;
							var61 += Pix2D.width;
							var53 += var41;
							var54 += var44;
							var55 += var47;
						}
					}
				} else {
					int var62;
					int var63 = var62 = arg3 << 16;
					if (arg0 < 0) {
						var63 -= arg0 * var29;
						var62 -= arg0 * var27;
						var48 -= arg0 * var32;
						arg0 = 0;
					}
					int var64 = arg5 << 16;
					if (arg2 < 0) {
						var64 -= arg2 * var28;
						arg2 = 0;
					}
					int var65 = arg0 - originY;
					int var66 = var41 * var65 + var39;
					int var67 = var44 * var65 + var42;
					int var68 = var47 * var65 + var45;
					if ((arg0 == arg2 || var29 >= var27) && (arg0 != arg2 || var28 <= var27)) {
						int var72 = arg1 - arg2;
						int var73 = arg2 - arg0;
						int var74 = scanline[arg0];
						while (true) {
							var73--;
							if (var73 < 0) {
								while (true) {
									var72--;
									if (var72 < 0) {
										return;
									}
									textureRasterAffine(Pix2D.pixels, var19, 0, 0, var74, var62 >> 16, var64 >> 16, var48, var31, var66, var67, var68, var40, var43, var46);
									var64 += var28;
									var62 += var27;
									var48 += var32;
									var74 += Pix2D.width;
									var66 += var41;
									var67 += var44;
									var68 += var47;
								}
							}
							textureRasterAffine(Pix2D.pixels, var19, 0, 0, var74, var62 >> 16, var63 >> 16, var48, var31, var66, var67, var68, var40, var43, var46);
							var63 += var29;
							var62 += var27;
							var48 += var32;
							var74 += Pix2D.width;
							var66 += var41;
							var67 += var44;
							var68 += var47;
						}
					} else {
						int var69 = arg1 - arg2;
						int var70 = arg2 - arg0;
						int var71 = scanline[arg0];
						while (true) {
							var70--;
							if (var70 < 0) {
								while (true) {
									var69--;
									if (var69 < 0) {
										return;
									}
									textureRasterAffine(Pix2D.pixels, var19, 0, 0, var71, var64 >> 16, var62 >> 16, var48, var31, var66, var67, var68, var40, var43, var46);
									var64 += var28;
									var62 += var27;
									var48 += var32;
									var71 += Pix2D.width;
									var66 += var41;
									var67 += var44;
									var68 += var47;
								}
							}
							textureRasterAffine(Pix2D.pixels, var19, 0, 0, var71, var63 >> 16, var62 >> 16, var48, var31, var66, var67, var68, var40, var43, var46);
							var63 += var29;
							var62 += var27;
							var48 += var32;
							var71 += Pix2D.width;
							var66 += var41;
							var67 += var44;
							var68 += var47;
						}
					}
				}
			}
		} else if (arg1 <= arg2) {
			if (arg1 < sizeY) {
				if (arg2 > sizeY) {
					arg2 = sizeY;
				}
				if (arg0 > sizeY) {
					arg0 = sizeY;
				}
				int var75 = (arg7 << 9) - arg4 * var31 + var31;
				if (arg2 < arg0) {
					int var76;
					int var77 = var76 = arg4 << 16;
					if (arg1 < 0) {
						var77 -= arg1 * var27;
						var76 -= arg1 * var28;
						var75 -= arg1 * var32;
						arg1 = 0;
					}
					int var78 = arg5 << 16;
					if (arg2 < 0) {
						var78 -= arg2 * var29;
						arg2 = 0;
					}
					int var79 = arg1 - originY;
					int var80 = var41 * var79 + var39;
					int var81 = var44 * var79 + var42;
					int var82 = var47 * var79 + var45;
					if (arg1 != arg2 && var27 < var28 || arg1 == arg2 && var27 > var29) {
						int var83 = arg0 - arg2;
						int var84 = arg2 - arg1;
						int var85 = scanline[arg1];
						while (true) {
							var84--;
							if (var84 < 0) {
								while (true) {
									var83--;
									if (var83 < 0) {
										return;
									}
									textureRasterAffine(Pix2D.pixels, var19, 0, 0, var85, var77 >> 16, var78 >> 16, var75, var31, var80, var81, var82, var40, var43, var46);
									var77 += var27;
									var78 += var29;
									var75 += var32;
									var85 += Pix2D.width;
									var80 += var41;
									var81 += var44;
									var82 += var47;
								}
							}
							textureRasterAffine(Pix2D.pixels, var19, 0, 0, var85, var77 >> 16, var76 >> 16, var75, var31, var80, var81, var82, var40, var43, var46);
							var77 += var27;
							var76 += var28;
							var75 += var32;
							var85 += Pix2D.width;
							var80 += var41;
							var81 += var44;
							var82 += var47;
						}
					} else {
						int var86 = arg0 - arg2;
						int var87 = arg2 - arg1;
						int var88 = scanline[arg1];
						while (true) {
							var87--;
							if (var87 < 0) {
								while (true) {
									var86--;
									if (var86 < 0) {
										return;
									}
									textureRasterAffine(Pix2D.pixels, var19, 0, 0, var88, var78 >> 16, var77 >> 16, var75, var31, var80, var81, var82, var40, var43, var46);
									var77 += var27;
									var78 += var29;
									var75 += var32;
									var88 += Pix2D.width;
									var80 += var41;
									var81 += var44;
									var82 += var47;
								}
							}
							textureRasterAffine(Pix2D.pixels, var19, 0, 0, var88, var76 >> 16, var77 >> 16, var75, var31, var80, var81, var82, var40, var43, var46);
							var77 += var27;
							var76 += var28;
							var75 += var32;
							var88 += Pix2D.width;
							var80 += var41;
							var81 += var44;
							var82 += var47;
						}
					}
				} else {
					int var89;
					int var90 = var89 = arg4 << 16;
					if (arg1 < 0) {
						var90 -= arg1 * var27;
						var89 -= arg1 * var28;
						var75 -= arg1 * var32;
						arg1 = 0;
					}
					int var91 = arg3 << 16;
					if (arg0 < 0) {
						var91 -= arg0 * var29;
						arg0 = 0;
					}
					int var92 = arg1 - originY;
					int var93 = var41 * var92 + var39;
					int var94 = var44 * var92 + var42;
					int var95 = var47 * var92 + var45;
					if (var27 < var28) {
						int var96 = arg2 - arg0;
						int var97 = arg0 - arg1;
						int var98 = scanline[arg1];
						while (true) {
							var97--;
							if (var97 < 0) {
								while (true) {
									var96--;
									if (var96 < 0) {
										return;
									}
									textureRasterAffine(Pix2D.pixels, var19, 0, 0, var98, var91 >> 16, var89 >> 16, var75, var31, var93, var94, var95, var40, var43, var46);
									var91 += var29;
									var89 += var28;
									var75 += var32;
									var98 += Pix2D.width;
									var93 += var41;
									var94 += var44;
									var95 += var47;
								}
							}
							textureRasterAffine(Pix2D.pixels, var19, 0, 0, var98, var90 >> 16, var89 >> 16, var75, var31, var93, var94, var95, var40, var43, var46);
							var90 += var27;
							var89 += var28;
							var75 += var32;
							var98 += Pix2D.width;
							var93 += var41;
							var94 += var44;
							var95 += var47;
						}
					} else {
						int var99 = arg2 - arg0;
						int var100 = arg0 - arg1;
						int var101 = scanline[arg1];
						while (true) {
							var100--;
							if (var100 < 0) {
								while (true) {
									var99--;
									if (var99 < 0) {
										return;
									}
									textureRasterAffine(Pix2D.pixels, var19, 0, 0, var101, var89 >> 16, var91 >> 16, var75, var31, var93, var94, var95, var40, var43, var46);
									var91 += var29;
									var89 += var28;
									var75 += var32;
									var101 += Pix2D.width;
									var93 += var41;
									var94 += var44;
									var95 += var47;
								}
							}
							textureRasterAffine(Pix2D.pixels, var19, 0, 0, var101, var89 >> 16, var90 >> 16, var75, var31, var93, var94, var95, var40, var43, var46);
							var90 += var27;
							var89 += var28;
							var75 += var32;
							var101 += Pix2D.width;
							var93 += var41;
							var94 += var44;
							var95 += var47;
						}
					}
				}
			}
		} else if (arg2 < sizeY) {
			if (arg0 > sizeY) {
				arg0 = sizeY;
			}
			if (arg1 > sizeY) {
				arg1 = sizeY;
			}
			int var102 = (arg8 << 9) - arg5 * var31 + var31;
			if (arg0 < arg1) {
				int var103;
				int var104 = var103 = arg5 << 16;
				if (arg2 < 0) {
					var104 -= arg2 * var28;
					var103 -= arg2 * var29;
					var102 -= arg2 * var32;
					arg2 = 0;
				}
				int var105 = arg3 << 16;
				if (arg0 < 0) {
					var105 -= arg0 * var27;
					arg0 = 0;
				}
				int var106 = arg2 - originY;
				int var107 = var41 * var106 + var39;
				int var108 = var44 * var106 + var42;
				int var109 = var47 * var106 + var45;
				if (var28 < var29) {
					int var110 = arg1 - arg0;
					int var111 = arg0 - arg2;
					int var112 = scanline[arg2];
					while (true) {
						var111--;
						if (var111 < 0) {
							while (true) {
								var110--;
								if (var110 < 0) {
									return;
								}
								textureRasterAffine(Pix2D.pixels, var19, 0, 0, var112, var104 >> 16, var105 >> 16, var102, var31, var107, var108, var109, var40, var43, var46);
								var104 += var28;
								var105 += var27;
								var102 += var32;
								var112 += Pix2D.width;
								var107 += var41;
								var108 += var44;
								var109 += var47;
							}
						}
						textureRasterAffine(Pix2D.pixels, var19, 0, 0, var112, var104 >> 16, var103 >> 16, var102, var31, var107, var108, var109, var40, var43, var46);
						var104 += var28;
						var103 += var29;
						var102 += var32;
						var112 += Pix2D.width;
						var107 += var41;
						var108 += var44;
						var109 += var47;
					}
				} else {
					int var113 = arg1 - arg0;
					int var114 = arg0 - arg2;
					int var115 = scanline[arg2];
					while (true) {
						var114--;
						if (var114 < 0) {
							while (true) {
								var113--;
								if (var113 < 0) {
									return;
								}
								textureRasterAffine(Pix2D.pixels, var19, 0, 0, var115, var105 >> 16, var104 >> 16, var102, var31, var107, var108, var109, var40, var43, var46);
								var104 += var28;
								var105 += var27;
								var102 += var32;
								var115 += Pix2D.width;
								var107 += var41;
								var108 += var44;
								var109 += var47;
							}
						}
						textureRasterAffine(Pix2D.pixels, var19, 0, 0, var115, var103 >> 16, var104 >> 16, var102, var31, var107, var108, var109, var40, var43, var46);
						var104 += var28;
						var103 += var29;
						var102 += var32;
						var115 += Pix2D.width;
						var107 += var41;
						var108 += var44;
						var109 += var47;
					}
				}
			} else {
				int var116;
				int var117 = var116 = arg5 << 16;
				if (arg2 < 0) {
					var117 -= arg2 * var28;
					var116 -= arg2 * var29;
					var102 -= arg2 * var32;
					arg2 = 0;
				}
				int var118 = arg4 << 16;
				if (arg1 < 0) {
					var118 -= arg1 * var27;
					arg1 = 0;
				}
				int var119 = arg2 - originY;
				int var120 = var41 * var119 + var39;
				int var121 = var44 * var119 + var42;
				int var122 = var47 * var119 + var45;
				if (var28 < var29) {
					int var123 = arg0 - arg1;
					int var124 = arg1 - arg2;
					int var125 = scanline[arg2];
					while (true) {
						var124--;
						if (var124 < 0) {
							while (true) {
								var123--;
								if (var123 < 0) {
									return;
								}
								textureRasterAffine(Pix2D.pixels, var19, 0, 0, var125, var118 >> 16, var116 >> 16, var102, var31, var120, var121, var122, var40, var43, var46);
								var118 += var27;
								var116 += var29;
								var102 += var32;
								var125 += Pix2D.width;
								var120 += var41;
								var121 += var44;
								var122 += var47;
							}
						}
						textureRasterAffine(Pix2D.pixels, var19, 0, 0, var125, var117 >> 16, var116 >> 16, var102, var31, var120, var121, var122, var40, var43, var46);
						var117 += var28;
						var116 += var29;
						var102 += var32;
						var125 += Pix2D.width;
						var120 += var41;
						var121 += var44;
						var122 += var47;
					}
				} else {
					int var126 = arg0 - arg1;
					int var127 = arg1 - arg2;
					int var128 = scanline[arg2];
					while (true) {
						var127--;
						if (var127 < 0) {
							while (true) {
								var126--;
								if (var126 < 0) {
									return;
								}
								textureRasterAffine(Pix2D.pixels, var19, 0, 0, var128, var116 >> 16, var118 >> 16, var102, var31, var120, var121, var122, var40, var43, var46);
								var118 += var27;
								var116 += var29;
								var102 += var32;
								var128 += Pix2D.width;
								var120 += var41;
								var121 += var44;
								var122 += var47;
							}
						}
						textureRasterAffine(Pix2D.pixels, var19, 0, 0, var128, var116 >> 16, var117 >> 16, var102, var31, var120, var121, var122, var40, var43, var46);
						var117 += var28;
						var116 += var29;
						var102 += var32;
						var128 += Pix2D.width;
						var120 += var41;
						var121 += var44;
						var122 += var47;
					}
				}
			}
		}
	}

	// jag::oldscape::dash3d::SoftwarePix3D::TextureRasterAffine
	@ObfuscatedName("fx.ch([I[IIIIIIIIIIIIII)V")
	public static void textureRasterAffine(int[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14) {
		if (hclip) {
			if (arg6 > sizeX) {
				arg6 = sizeX;
			}
			if (arg5 < 0) {
				arg5 = 0;
			}
		}
		if (arg5 >= arg6) {
			return;
		}
		int var15 = arg4 + arg5;
		int var16 = arg5 * arg8 + arg7;
		int var17 = arg6 - arg5;
		if (!lowMem) {
			int var70 = arg5 - originX;
			int var71 = arg12 * var70 + arg9;
			int var72 = arg13 * var70 + arg10;
			int var73 = arg14 * var70 + arg11;
			int var74 = var73 >> 14;
			int var75;
			int var76;
			if (var74 == 0) {
				var75 = 0;
				var76 = 0;
			} else {
				var75 = var71 / var74;
				var76 = var72 / var74;
			}
			int var77 = arg12 * var17 + var71;
			int var78 = arg13 * var17 + var72;
			int var79 = arg14 * var17 + var73;
			int var80 = var79 >> 14;
			int var81;
			int var82;
			if (var80 == 0) {
				var81 = 0;
				var82 = 0;
			} else {
				var81 = var77 / var80;
				var82 = var78 / var80;
			}
			int var83 = (var75 << 18) + var76;
			int var84 = ((var81 - var75) / var17 << 18) + (var82 - var76) / var17;
			int var85 = var17 >> 3;
			int var86 = arg8 << 3;
			int var87 = var16 >> 8;
			if (opaque) {
				if (var85 > 0) {
					do {
						int var88 = arg1[(var83 >>> 25) + (var83 & 0x3F80)];
						arg0[var15++] = ((var88 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var88 & 0xFF00) * var87 & 0xFF0000) >> 8;
						int var89 = var83 + var84;
						int var90 = arg1[(var89 >>> 25) + (var89 & 0x3F80)];
						arg0[var15++] = ((var90 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var90 & 0xFF00) * var87 & 0xFF0000) >> 8;
						int var91 = var84 + var89;
						int var92 = arg1[(var91 >>> 25) + (var91 & 0x3F80)];
						arg0[var15++] = ((var92 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var92 & 0xFF00) * var87 & 0xFF0000) >> 8;
						int var93 = var84 + var91;
						int var94 = arg1[(var93 >>> 25) + (var93 & 0x3F80)];
						arg0[var15++] = ((var94 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var94 & 0xFF00) * var87 & 0xFF0000) >> 8;
						int var95 = var84 + var93;
						int var96 = arg1[(var95 >>> 25) + (var95 & 0x3F80)];
						arg0[var15++] = ((var96 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var96 & 0xFF00) * var87 & 0xFF0000) >> 8;
						int var97 = var84 + var95;
						int var98 = arg1[(var97 >>> 25) + (var97 & 0x3F80)];
						arg0[var15++] = ((var98 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var98 & 0xFF00) * var87 & 0xFF0000) >> 8;
						int var99 = var84 + var97;
						int var100 = arg1[(var99 >>> 25) + (var99 & 0x3F80)];
						arg0[var15++] = ((var100 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var100 & 0xFF00) * var87 & 0xFF0000) >> 8;
						int var101 = var84 + var99;
						int var102 = arg1[(var101 >>> 25) + (var101 & 0x3F80)];
						arg0[var15++] = ((var102 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var102 & 0xFF00) * var87 & 0xFF0000) >> 8;
						var83 = var84 + var101;
						var16 += var86;
						var87 = var16 >> 8;
						var85--;
					} while (var85 > 0);
				}
				int var103 = arg6 - arg5 & 0x7;
				if (var103 > 0) {
					do {
						int var104 = arg1[(var83 >>> 25) + (var83 & 0x3F80)];
						arg0[var15++] = ((var104 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var104 & 0xFF00) * var87 & 0xFF0000) >> 8;
						var83 += var84;
						var103--;
					} while (var103 > 0);
				}
			} else {
				if (var85 > 0) {
					do {
						int var105;
						if ((var105 = arg1[(var83 >>> 25) + (var83 & 0x3F80)]) != 0) {
							arg0[var15] = ((var105 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var105 & 0xFF00) * var87 & 0xFF0000) >> 8;
						}
						var15++;
						int var106 = var83 + var84;
						int var107;
						if ((var107 = arg1[(var106 >>> 25) + (var106 & 0x3F80)]) != 0) {
							arg0[var15] = ((var107 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var107 & 0xFF00) * var87 & 0xFF0000) >> 8;
						}
						var15++;
						int var108 = var84 + var106;
						int var109;
						if ((var109 = arg1[(var108 >>> 25) + (var108 & 0x3F80)]) != 0) {
							arg0[var15] = ((var109 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var109 & 0xFF00) * var87 & 0xFF0000) >> 8;
						}
						var15++;
						int var110 = var84 + var108;
						int var111;
						if ((var111 = arg1[(var110 >>> 25) + (var110 & 0x3F80)]) != 0) {
							arg0[var15] = ((var111 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var111 & 0xFF00) * var87 & 0xFF0000) >> 8;
						}
						var15++;
						int var112 = var84 + var110;
						int var113;
						if ((var113 = arg1[(var112 >>> 25) + (var112 & 0x3F80)]) != 0) {
							arg0[var15] = ((var113 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var113 & 0xFF00) * var87 & 0xFF0000) >> 8;
						}
						var15++;
						int var114 = var84 + var112;
						int var115;
						if ((var115 = arg1[(var114 >>> 25) + (var114 & 0x3F80)]) != 0) {
							arg0[var15] = ((var115 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var115 & 0xFF00) * var87 & 0xFF0000) >> 8;
						}
						var15++;
						int var116 = var84 + var114;
						int var117;
						if ((var117 = arg1[(var116 >>> 25) + (var116 & 0x3F80)]) != 0) {
							arg0[var15] = ((var117 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var117 & 0xFF00) * var87 & 0xFF0000) >> 8;
						}
						var15++;
						int var118 = var84 + var116;
						int var119;
						if ((var119 = arg1[(var118 >>> 25) + (var118 & 0x3F80)]) != 0) {
							arg0[var15] = ((var119 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var119 & 0xFF00) * var87 & 0xFF0000) >> 8;
						}
						var15++;
						var83 = var84 + var118;
						var16 += var86;
						var87 = var16 >> 8;
						var85--;
					} while (var85 > 0);
				}
				int var120 = arg6 - arg5 & 0x7;
				if (var120 > 0) {
					do {
						int var121;
						if ((var121 = arg1[(var83 >>> 25) + (var83 & 0x3F80)]) != 0) {
							arg0[var15] = ((var121 & 0xFF00FF) * var87 & 0xFF00FF00) + ((var121 & 0xFF00) * var87 & 0xFF0000) >> 8;
						}
						var15++;
						var83 += var84;
						var120--;
					} while (var120 > 0);
				}
			}
			return;
		}
		int var18 = arg5 - originX;
		int var19 = arg12 * var18 + arg9;
		int var20 = arg13 * var18 + arg10;
		int var21 = arg14 * var18 + arg11;
		int var22 = var21 >> 12;
		int var23;
		int var24;
		if (var22 == 0) {
			var23 = 0;
			var24 = 0;
		} else {
			var23 = var19 / var22;
			var24 = var20 / var22;
		}
		int var25 = arg12 * var17 + var19;
		int var26 = arg13 * var17 + var20;
		int var27 = arg14 * var17 + var21;
		int var28 = var27 >> 12;
		int var29;
		int var30;
		if (var28 == 0) {
			var29 = 0;
			var30 = 0;
		} else {
			var29 = var25 / var28;
			var30 = var26 / var28;
		}
		int var31 = (var23 << 20) + var24;
		int var32 = ((var29 - var23) / var17 << 20) + (var30 - var24) / var17;
		int var33 = var17 >> 3;
		int var34 = arg8 << 3;
		int var35 = var16 >> 8;
		if (opaque) {
			if (var33 > 0) {
				do {
					int var36 = arg1[(var31 >>> 26) + (var31 & 0xFC0)];
					arg0[var15++] = ((var36 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var36 & 0xFF00) * var35 & 0xFF0000) >> 8;
					int var37 = var31 + var32;
					int var38 = arg1[(var37 >>> 26) + (var37 & 0xFC0)];
					arg0[var15++] = ((var38 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var38 & 0xFF00) * var35 & 0xFF0000) >> 8;
					int var39 = var32 + var37;
					int var40 = arg1[(var39 >>> 26) + (var39 & 0xFC0)];
					arg0[var15++] = ((var40 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var40 & 0xFF00) * var35 & 0xFF0000) >> 8;
					int var41 = var32 + var39;
					int var42 = arg1[(var41 >>> 26) + (var41 & 0xFC0)];
					arg0[var15++] = ((var42 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var42 & 0xFF00) * var35 & 0xFF0000) >> 8;
					int var43 = var32 + var41;
					int var44 = arg1[(var43 >>> 26) + (var43 & 0xFC0)];
					arg0[var15++] = ((var44 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var44 & 0xFF00) * var35 & 0xFF0000) >> 8;
					int var45 = var32 + var43;
					int var46 = arg1[(var45 >>> 26) + (var45 & 0xFC0)];
					arg0[var15++] = ((var46 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var46 & 0xFF00) * var35 & 0xFF0000) >> 8;
					int var47 = var32 + var45;
					int var48 = arg1[(var47 >>> 26) + (var47 & 0xFC0)];
					arg0[var15++] = ((var48 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var48 & 0xFF00) * var35 & 0xFF0000) >> 8;
					int var49 = var32 + var47;
					int var50 = arg1[(var49 >>> 26) + (var49 & 0xFC0)];
					arg0[var15++] = ((var50 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var50 & 0xFF00) * var35 & 0xFF0000) >> 8;
					var31 = var32 + var49;
					var16 += var34;
					var35 = var16 >> 8;
					var33--;
				} while (var33 > 0);
			}
			int var51 = arg6 - arg5 & 0x7;
			if (var51 > 0) {
				do {
					int var52 = arg1[(var31 >>> 26) + (var31 & 0xFC0)];
					arg0[var15++] = ((var52 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var52 & 0xFF00) * var35 & 0xFF0000) >> 8;
					var31 += var32;
					var51--;
				} while (var51 > 0);
			}
			return;
		}
		if (var33 > 0) {
			do {
				int var53;
				if ((var53 = arg1[(var31 >>> 26) + (var31 & 0xFC0)]) != 0) {
					arg0[var15] = ((var53 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var53 & 0xFF00) * var35 & 0xFF0000) >> 8;
				}
				var15++;
				int var54 = var31 + var32;
				int var55;
				if ((var55 = arg1[(var54 >>> 26) + (var54 & 0xFC0)]) != 0) {
					arg0[var15] = ((var55 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var55 & 0xFF00) * var35 & 0xFF0000) >> 8;
				}
				var15++;
				int var56 = var32 + var54;
				int var57;
				if ((var57 = arg1[(var56 >>> 26) + (var56 & 0xFC0)]) != 0) {
					arg0[var15] = ((var57 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var57 & 0xFF00) * var35 & 0xFF0000) >> 8;
				}
				var15++;
				int var58 = var32 + var56;
				int var59;
				if ((var59 = arg1[(var58 >>> 26) + (var58 & 0xFC0)]) != 0) {
					arg0[var15] = ((var59 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var59 & 0xFF00) * var35 & 0xFF0000) >> 8;
				}
				var15++;
				int var60 = var32 + var58;
				int var61;
				if ((var61 = arg1[(var60 >>> 26) + (var60 & 0xFC0)]) != 0) {
					arg0[var15] = ((var61 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var61 & 0xFF00) * var35 & 0xFF0000) >> 8;
				}
				var15++;
				int var62 = var32 + var60;
				int var63;
				if ((var63 = arg1[(var62 >>> 26) + (var62 & 0xFC0)]) != 0) {
					arg0[var15] = ((var63 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var63 & 0xFF00) * var35 & 0xFF0000) >> 8;
				}
				var15++;
				int var64 = var32 + var62;
				int var65;
				if ((var65 = arg1[(var64 >>> 26) + (var64 & 0xFC0)]) != 0) {
					arg0[var15] = ((var65 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var65 & 0xFF00) * var35 & 0xFF0000) >> 8;
				}
				var15++;
				int var66 = var32 + var64;
				int var67;
				if ((var67 = arg1[(var66 >>> 26) + (var66 & 0xFC0)]) != 0) {
					arg0[var15] = ((var67 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var67 & 0xFF00) * var35 & 0xFF0000) >> 8;
				}
				var15++;
				var31 = var32 + var66;
				var16 += var34;
				var35 = var16 >> 8;
				var33--;
			} while (var33 > 0);
		}
		int var68 = arg6 - arg5 & 0x7;
		if (var68 <= 0) {
			return;
		}
		do {
			int var69;
			if ((var69 = arg1[(var31 >>> 26) + (var31 & 0xFC0)]) != 0) {
				arg0[var15] = ((var69 & 0xFF00FF) * var35 & 0xFF00FF00) + ((var69 & 0xFF00) * var35 & 0xFF0000) >> 8;
			}
			var15++;
			var31 += var32;
			var68--;
		} while (var68 > 0);
	}

	// jag::oldscape::dash3d::Pix3D::TextureLightColour
	@ObfuscatedName("fx.cu(II)I")
	public static int textureLightColour(int arg0, int arg1) {
		int var2 = (arg0 & 0x7F) * arg1 >> 7;
		if (var2 < 2) {
			var2 = 2;
		} else if (var2 > 126) {
			var2 = 126;
		}
		return (arg0 & 0xFF80) + var2;
	}
}
