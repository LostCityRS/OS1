package jagex2.dash3d;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.datastruct.LinkList;
import jagex2.graphics.Model;
import jagex2.graphics.Pix3D;
import jagex2.graphics.SoftwareModel;

@ObfuscatedName("aq")
public class World3D {

	@ObfuscatedName("aq.r")
	public static boolean field593 = true;

	@ObfuscatedName("aq.d")
	public int field581;

	@ObfuscatedName("aq.l")
	public int field582;

	@ObfuscatedName("aq.m")
	public int field589;

	@ObfuscatedName("aq.c")
	public int[][][] field584;

	@ObfuscatedName("aq.n")
	public Ground[][][] field585;

	@ObfuscatedName("aq.j")
	public int field588 = 0;

	@ObfuscatedName("aq.z")
	public int field587 = 0;

	@ObfuscatedName("aq.g")
	public Location[] field623 = new Location[5000];

	@ObfuscatedName("aq.q")
	public int[][][] field608;

	@ObfuscatedName("aq.e")
	public static int field595 = 0;

	@ObfuscatedName("aq.b")
	public static int field596 = 0;

	@ObfuscatedName("aq.ap")
	public static Location[] field640 = new Location[100];

	@ObfuscatedName("aq.av")
	public static boolean field612 = false;

	@ObfuscatedName("aq.ak")
	public static int field600 = 0;

	@ObfuscatedName("aq.az")
	public static int field598 = 0;

	@ObfuscatedName("aq.an")
	public static int field615 = 0;

	@ObfuscatedName("aq.ah")
	public static int field580 = -1;

	@ObfuscatedName("aq.ay")
	public static int field629 = -1;

	@ObfuscatedName("aq.ao")
	public static int field620 = 4;

	@ObfuscatedName("aq.ag")
	public static int[] field635 = new int[field620];

	@ObfuscatedName("aq.ar")
	public static Occlude[][] field622 = new Occlude[field620][500];

	@ObfuscatedName("aq.aq")
	public static int field614 = 0;

	@ObfuscatedName("aq.at")
	public static Occlude[] field607 = new Occlude[500];

	@ObfuscatedName("aq.ae")
	public static LinkList field625 = new LinkList();

	@ObfuscatedName("aq.au")
	public static final int[] field583 = new int[] { 19, 55, 38, 155, 255, 110, 137, 205, 76 };

	@ObfuscatedName("aq.ax")
	public static final int[] field627 = new int[] { 160, 192, 80, 96, 0, 144, 80, 48, 160 };

	@ObfuscatedName("aq.ai")
	public static final int[] field628 = new int[] { 76, 8, 137, 4, 0, 1, 38, 2, 19 };

	@ObfuscatedName("aq.aj")
	public static final int[] field636 = new int[] { 0, 0, 2, 0, 0, 2, 1, 1, 0 };

	@ObfuscatedName("aq.aw")
	public static final int[] field630 = new int[] { 2, 0, 0, 2, 0, 0, 0, 4, 4 };

	@ObfuscatedName("aq.af")
	public static final int[] field631 = new int[] { 0, 4, 4, 8, 0, 0, 8, 0, 0 };

	@ObfuscatedName("aq.bh")
	public static final int[] field632 = new int[] { 1, 1, 0, 0, 0, 8, 0, 0, 8 };

	@ObfuscatedName("aq.bi")
	public int[][] field604 = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1 } };

	@ObfuscatedName("aq.bs")
	public int[][] field634 = new int[][] { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 }, { 12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3 }, { 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }, { 3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12 } };

	@ObfuscatedName("aq.bk")
	public static boolean[][][][] field642 = new boolean[8][32][51][51];

	public World3D(int arg0, int arg1, int arg2, int[][][] arg3) {
		this.field581 = arg0;
		this.field582 = arg1;
		this.field589 = arg2;
		this.field585 = new Ground[arg0][arg1][arg2];
		this.field608 = new int[arg0][arg1 + 1][arg2 + 1];
		this.field584 = arg3;
		this.method564();
	}

	@ObfuscatedName("aq.r()V")
	public void method564() {
		for (int var1 = 0; var1 < this.field581; var1++) {
			for (int var2 = 0; var2 < this.field582; var2++) {
				for (int var3 = 0; var3 < this.field589; var3++) {
					this.field585[var1][var2][var3] = null;
				}
			}
		}
		for (int var4 = 0; var4 < field620; var4++) {
			for (int var5 = 0; var5 < field635[var4]; var5++) {
				field622[var4][var5] = null;
			}
			field635[var4] = 0;
		}
		for (int var6 = 0; var6 < this.field587; var6++) {
			this.field623[var6] = null;
		}
		this.field587 = 0;
		for (int var7 = 0; var7 < field640.length; var7++) {
			field640[var7] = null;
		}
	}

	@ObfuscatedName("aq.d(I)V")
	public void method565(int arg0) {
		this.field588 = arg0;
		for (int var2 = 0; var2 < this.field582; var2++) {
			for (int var3 = 0; var3 < this.field589; var3++) {
				if (this.field585[arg0][var2][var3] == null) {
					this.field585[arg0][var2][var3] = new Ground(arg0, var2, var3);
				}
			}
		}
	}

	@ObfuscatedName("aq.l(II)V")
	public void method566(int arg0, int arg1) {
		Ground var3 = this.field585[0][arg0][arg1];
		for (int var4 = 0; var4 < 3; var4++) {
			Ground var5 = this.field585[var4][arg0][arg1] = this.field585[var4 + 1][arg0][arg1];
			if (var5 != null) {
				var5.field1707--;
				for (int var6 = 0; var6 < var5.field1712; var6++) {
					Location var7 = var5.field1700[var6];
					if ((var7.field678 >> 29 & 0x3) == 2 && var7.field675 == arg0 && var7.field674 == arg1) {
						var7.field670--;
					}
				}
			}
		}
		if (this.field585[0][arg0][arg1] == null) {
			this.field585[0][arg0][arg1] = new Ground(0, arg0, arg1);
		}
		this.field585[0][arg0][arg1].field1719 = var3;
		this.field585[3][arg0][arg1] = null;
	}

	@ObfuscatedName("aq.m(IIIIIIII)V")
	public static void method651(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		Occlude var8 = new Occlude();
		var8.field726 = arg2 / 128;
		var8.field735 = arg3 / 128;
		var8.field725 = arg4 / 128;
		var8.field724 = arg5 / 128;
		var8.field737 = arg1;
		var8.field739 = arg2;
		var8.field723 = arg3;
		var8.field730 = arg4;
		var8.field731 = arg5;
		var8.field727 = arg6;
		var8.field733 = arg7;
		field622[arg0][field635[arg0]++] = var8;
	}

	@ObfuscatedName("aq.c(IIII)V")
	public void method568(int arg0, int arg1, int arg2, int arg3) {
		Ground var5 = this.field585[arg0][arg1][arg2];
		if (var5 != null) {
			this.field585[arg0][arg1][arg2].field1711 = arg3;
		}
	}

	@ObfuscatedName("aq.n(IIIIIIIIIIIIIIIIIIII)V")
	public void method569(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18, int arg19) {
		if (arg3 == 0) {
			TileUnderlay var21 = new TileUnderlay(arg10, arg11, arg12, arg13, -1, arg18, false);
			for (int var22 = arg0; var22 >= 0; var22--) {
				if (this.field585[var22][arg1][arg2] == null) {
					this.field585[var22][arg1][arg2] = new Ground(var22, arg1, arg2);
				}
			}
			this.field585[arg0][arg1][arg2].field1701 = var21;
		} else if (arg3 == 1) {
			TileUnderlay var23 = new TileUnderlay(arg14, arg15, arg16, arg17, arg5, arg19, arg6 == arg7 && arg6 == arg8 && arg6 == arg9);
			for (int var24 = arg0; var24 >= 0; var24--) {
				if (this.field585[var24][arg1][arg2] == null) {
					this.field585[var24][arg1][arg2] = new Ground(var24, arg1, arg2);
				}
			}
			this.field585[arg0][arg1][arg2].field1701 = var23;
		} else {
			TileOverlay var25 = new TileOverlay(arg3, arg4, arg5, arg1, arg2, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
			for (int var26 = arg0; var26 >= 0; var26--) {
				if (this.field585[var26][arg1][arg2] == null) {
					this.field585[var26][arg1][arg2] = new Ground(var26, arg1, arg2);
				}
			}
			this.field585[arg0][arg1][arg2].field1705 = var25;
		}
	}

	@ObfuscatedName("aq.j(IIIILfu;II)V")
	public void method714(int arg0, int arg1, int arg2, int arg3, Entity arg4, int arg5, int arg6) {
		if (arg4 == null) {
			return;
		}
		GroundDecor var8 = new GroundDecor();
		var8.field701 = arg4;
		var8.field703 = arg1 * 128 + 64;
		var8.field700 = arg2 * 128 + 64;
		var8.field699 = arg3;
		var8.field702 = arg5;
		var8.field698 = arg6;
		if (this.field585[arg0][arg1][arg2] == null) {
			this.field585[arg0][arg1][arg2] = new Ground(arg0, arg1, arg2);
		}
		this.field585[arg0][arg1][arg2].field1709 = var8;
	}

	@ObfuscatedName("aq.z(IIIILfu;ILfu;Lfu;)V")
	public void method571(int arg0, int arg1, int arg2, int arg3, Entity arg4, int arg5, Entity arg6, Entity arg7) {
		GroundObject var9 = new GroundObject();
		var9.field685 = arg4;
		var9.field683 = arg1 * 128 + 64;
		var9.field682 = arg2 * 128 + 64;
		var9.field684 = arg3;
		var9.field688 = arg5;
		var9.field686 = arg6;
		var9.field687 = arg7;
		int var10 = 0;
		Ground var11 = this.field585[arg0][arg1][arg2];
		if (var11 != null) {
			for (int var12 = 0; var12 < var11.field1712; var12++) {
				if ((var11.field1700[var12].field676 & 0x100) == 256 && var11.field1700[var12].field672 instanceof SoftwareModel) {
					SoftwareModel var13 = (SoftwareModel) var11.field1700[var12].field672;
					var13.method3002();
					if (var13.field2487 > var10) {
						var10 = var13.field2487;
					}
				}
			}
		}
		var9.field689 = var10;
		if (this.field585[arg0][arg1][arg2] == null) {
			this.field585[arg0][arg1][arg2] = new Ground(arg0, arg1, arg2);
		}
		this.field585[arg0][arg1][arg2].field1706 = var9;
	}

	@ObfuscatedName("aq.g(IIIILfu;Lfu;IIII)V")
	public void method572(int arg0, int arg1, int arg2, int arg3, Entity arg4, Entity arg5, int arg6, int arg7, int arg8, int arg9) {
		if (arg4 == null && arg5 == null) {
			return;
		}
		Wall var11 = new Wall();
		var11.field647 = arg8;
		var11.field651 = arg9;
		var11.field650 = arg1 * 128 + 64;
		var11.field645 = arg2 * 128 + 64;
		var11.field648 = arg3;
		var11.field646 = arg4;
		var11.field649 = arg5;
		var11.field644 = arg6;
		var11.field643 = arg7;
		for (int var12 = arg0; var12 >= 0; var12--) {
			if (this.field585[var12][arg1][arg2] == null) {
				this.field585[var12][arg1][arg2] = new Ground(var12, arg1, arg2);
			}
		}
		this.field585[arg0][arg1][arg2].field1703 = var11;
	}

	@ObfuscatedName("aq.q(IIIILfu;Lfu;IIIIII)V")
	public void method589(int arg0, int arg1, int arg2, int arg3, Entity arg4, Entity arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
		if (arg4 == null) {
			return;
		}
		Decor var13 = new Decor();
		var13.field714 = arg10;
		var13.field715 = arg11;
		var13.field710 = arg1 * 128 + 64;
		var13.field707 = arg2 * 128 + 64;
		var13.field709 = arg3;
		var13.field712 = arg4;
		var13.field713 = arg5;
		var13.field711 = arg6;
		var13.field705 = arg7;
		var13.field708 = arg8;
		var13.field706 = arg9;
		for (int var14 = arg0; var14 >= 0; var14--) {
			if (this.field585[var14][arg1][arg2] == null) {
				this.field585[var14][arg1][arg2] = new Ground(var14, arg1, arg2);
			}
		}
		this.field585[arg0][arg1][arg2].field1704 = var13;
	}

	@ObfuscatedName("aq.i(IIIIIILfu;III)Z")
	public boolean method585(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Entity arg6, int arg7, int arg8, int arg9) {
		if (arg6 == null) {
			return true;
		} else {
			int var11 = arg1 * 128 + arg4 * 64;
			int var12 = arg2 * 128 + arg5 * 64;
			return this.method577(arg0, arg1, arg2, arg4, arg5, var11, var12, arg3, arg6, arg7, false, arg8, arg9);
		}
	}

	@ObfuscatedName("aq.s(IIIIILfu;IIZ)Z")
	public boolean method603(int arg0, int arg1, int arg2, int arg3, int arg4, Entity arg5, int arg6, int arg7, boolean arg8) {
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
		return this.method577(arg0, var14, var15, var16 - var14 + 1, var17 - var15 + 1, arg1, arg2, arg3, arg5, arg6, true, arg7, 0);
	}

	@ObfuscatedName("aq.u(IIIIILfu;IIIIII)Z")
	public boolean method637(int arg0, int arg1, int arg2, int arg3, int arg4, Entity arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
		return arg5 == null ? true : this.method577(arg0, arg8, arg9, arg10 - arg8 + 1, arg11 - arg9 + 1, arg1, arg2, arg3, arg5, arg6, true, arg7, 0);
	}

	@ObfuscatedName("aq.v(IIIIIIIILfu;IZII)Z")
	public boolean method577(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, Entity arg8, int arg9, boolean arg10, int arg11, int arg12) {
		for (int var14 = arg1; var14 < arg1 + arg3; var14++) {
			for (int var15 = arg2; var15 < arg2 + arg4; var15++) {
				if (var14 < 0 || var15 < 0 || var14 >= this.field582 || var15 >= this.field589) {
					return false;
				}
				Ground var16 = this.field585[arg0][var14][var15];
				if (var16 != null && var16.field1712 >= 5) {
					return false;
				}
			}
		}
		Location var17 = new Location();
		var17.field678 = arg11;
		var17.field676 = arg12;
		var17.field670 = arg0;
		var17.field679 = arg5;
		var17.field669 = arg6;
		var17.field666 = arg7;
		var17.field672 = arg8;
		var17.field671 = arg9;
		var17.field675 = arg1;
		var17.field674 = arg2;
		var17.field673 = arg1 + arg3 - 1;
		var17.field667 = arg2 + arg4 - 1;
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
					if (this.field585[var21][var18][var19] == null) {
						this.field585[var21][var18][var19] = new Ground(var21, var18, var19);
					}
				}
				Ground var22 = this.field585[arg0][var18][var19];
				var22.field1700[var22.field1712] = var17;
				var22.field1716[var22.field1712] = var20;
				var22.field1710 |= var20;
				var22.field1712++;
			}
		}
		if (arg10) {
			this.field623[this.field587++] = var17;
		}
		return true;
	}

	@ObfuscatedName("aq.w()V")
	public void method578() {
		for (int var1 = 0; var1 < this.field587; var1++) {
			Location var2 = this.field623[var1];
			this.method639(var2);
			this.field623[var1] = null;
		}
		this.field587 = 0;
	}

	@ObfuscatedName("aq.e(Lau;)V")
	public void method639(Location arg0) {
		for (int var2 = arg0.field675; var2 <= arg0.field673; var2++) {
			for (int var3 = arg0.field674; var3 <= arg0.field667; var3++) {
				Ground var4 = this.field585[arg0.field670][var2][var3];
				if (var4 != null) {
					for (int var5 = 0; var5 < var4.field1712; var5++) {
						if (var4.field1700[var5] == arg0) {
							var4.field1712--;
							for (int var6 = var5; var6 < var4.field1712; var6++) {
								var4.field1700[var6] = var4.field1700[var6 + 1];
								var4.field1716[var6] = var4.field1716[var6 + 1];
							}
							var4.field1700[var4.field1712] = null;
							break;
						}
					}
					var4.field1710 = 0;
					for (int var7 = 0; var7 < var4.field1712; var7++) {
						var4.field1710 |= var4.field1716[var7];
					}
				}
			}
		}
	}

	@ObfuscatedName("aq.b(IIII)V")
	public void method580(int arg0, int arg1, int arg2, int arg3) {
		Ground var5 = this.field585[arg0][arg1][arg2];
		if (var5 == null) {
			return;
		}
		Decor var6 = var5.field1704;
		if (var6 != null) {
			var6.field708 = var6.field708 * arg3 / 16;
			var6.field706 = var6.field706 * arg3 / 16;
		}
	}

	@ObfuscatedName("aq.y(III)V")
	public void method581(int arg0, int arg1, int arg2) {
		Ground var4 = this.field585[arg0][arg1][arg2];
		if (var4 != null) {
			var4.field1703 = null;
		}
	}

	@ObfuscatedName("aq.t(III)V")
	public void method582(int arg0, int arg1, int arg2) {
		Ground var4 = this.field585[arg0][arg1][arg2];
		if (var4 != null) {
			var4.field1704 = null;
		}
	}

	@ObfuscatedName("aq.f(III)V")
	public void method583(int arg0, int arg1, int arg2) {
		Ground var4 = this.field585[arg0][arg1][arg2];
		if (var4 == null) {
			return;
		}
		for (int var5 = 0; var5 < var4.field1712; var5++) {
			Location var6 = var4.field1700[var5];
			if ((var6.field678 >> 29 & 0x3) == 2 && var6.field675 == arg1 && var6.field674 == arg2) {
				this.method639(var6);
				return;
			}
		}
	}

	@ObfuscatedName("aq.k(III)V")
	public void method584(int arg0, int arg1, int arg2) {
		Ground var4 = this.field585[arg0][arg1][arg2];
		if (var4 != null) {
			var4.field1709 = null;
		}
	}

	@ObfuscatedName("aq.o(III)V")
	public void method666(int arg0, int arg1, int arg2) {
		Ground var4 = this.field585[arg0][arg1][arg2];
		if (var4 != null) {
			var4.field1706 = null;
		}
	}

	@ObfuscatedName("aq.a(III)Lat;")
	public Wall method715(int arg0, int arg1, int arg2) {
		Ground var4 = this.field585[arg0][arg1][arg2];
		return var4 == null ? null : var4.field1703;
	}

	@ObfuscatedName("aq.h(III)Lbh;")
	public Decor method602(int arg0, int arg1, int arg2) {
		Ground var4 = this.field585[arg0][arg1][arg2];
		return var4 == null ? null : var4.field1704;
	}

	@ObfuscatedName("aq.x(III)Lau;")
	public Location method686(int arg0, int arg1, int arg2) {
		Ground var4 = this.field585[arg0][arg1][arg2];
		if (var4 == null) {
			return null;
		}
		for (int var5 = 0; var5 < var4.field1712; var5++) {
			Location var6 = var4.field1700[var5];
			if ((var6.field678 >> 29 & 0x3) == 2 && var6.field675 == arg1 && var6.field674 == arg2) {
				return var6;
			}
		}
		return null;
	}

	@ObfuscatedName("aq.p(III)Laf;")
	public GroundDecor method621(int arg0, int arg1, int arg2) {
		Ground var4 = this.field585[arg0][arg1][arg2];
		return var4 == null || var4.field1709 == null ? null : var4.field1709;
	}

	@ObfuscatedName("aq.ad(III)I")
	public int method590(int arg0, int arg1, int arg2) {
		Ground var4 = this.field585[arg0][arg1][arg2];
		return var4 == null || var4.field1703 == null ? 0 : var4.field1703.field647;
	}

	@ObfuscatedName("aq.ac(III)I")
	public int method591(int arg0, int arg1, int arg2) {
		Ground var4 = this.field585[arg0][arg1][arg2];
		return var4 == null || var4.field1704 == null ? 0 : var4.field1704.field714;
	}

	@ObfuscatedName("aq.aa(III)I")
	public int method592(int arg0, int arg1, int arg2) {
		Ground var4 = this.field585[arg0][arg1][arg2];
		if (var4 == null) {
			return 0;
		}
		for (int var5 = 0; var5 < var4.field1712; var5++) {
			Location var6 = var4.field1700[var5];
			if ((var6.field678 >> 29 & 0x3) == 2 && var6.field675 == arg1 && var6.field674 == arg2) {
				return var6.field678;
			}
		}
		return 0;
	}

	@ObfuscatedName("aq.as(III)I")
	public int method593(int arg0, int arg1, int arg2) {
		Ground var4 = this.field585[arg0][arg1][arg2];
		return var4 == null || var4.field1709 == null ? 0 : var4.field1709.field702;
	}

	@ObfuscatedName("aq.am(IIII)I")
	public int method594(int arg0, int arg1, int arg2, int arg3) {
		Ground var5 = this.field585[arg0][arg1][arg2];
		if (var5 == null) {
			return -1;
		} else if (var5.field1703 != null && var5.field1703.field647 == arg3) {
			return var5.field1703.field651 & 0xFF;
		} else if (var5.field1704 != null && var5.field1704.field714 == arg3) {
			return var5.field1704.field715 & 0xFF;
		} else if (var5.field1709 != null && var5.field1709.field702 == arg3) {
			return var5.field1709.field698 & 0xFF;
		} else {
			for (int var6 = 0; var6 < var5.field1712; var6++) {
				if (var5.field1700[var6].field678 == arg3) {
					return var5.field1700[var6].field676 & 0xFF;
				}
			}
			return -1;
		}
	}

	@ObfuscatedName("aq.ap(III)V")
	public void method640(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < this.field581; var4++) {
			for (int var5 = 0; var5 < this.field582; var5++) {
				for (int var6 = 0; var6 < this.field589; var6++) {
					Ground var7 = this.field585[var4][var5][var6];
					if (var7 != null) {
						Wall var8 = var7.field1703;
						if (var8 != null && var8.field646 instanceof Model) {
							Model var9 = (Model) var8.field646;
							this.method597(var9, var4, var5, var6, 1, 1);
							if (var8.field649 instanceof Model) {
								Model var10 = (Model) var8.field649;
								this.method597(var10, var4, var5, var6, 1, 1);
								Model.method2941(var9, var10, 0, 0, 0, false);
								var8.field649 = var10.method2942(var10.field2708, var10.field2706, arg0, arg1, arg2);
							}
							var8.field646 = var9.method2942(var9.field2708, var9.field2706, arg0, arg1, arg2);
						}
						for (int var11 = 0; var11 < var7.field1712; var11++) {
							Location var12 = var7.field1700[var11];
							if (var12 != null && var12.field672 instanceof Model) {
								Model var13 = (Model) var12.field672;
								this.method597(var13, var4, var5, var6, var12.field673 - var12.field675 + 1, var12.field667 - var12.field674 + 1);
								var12.field672 = var13.method2942(var13.field2708, var13.field2706, arg0, arg1, arg2);
							}
						}
						GroundDecor var14 = var7.field1709;
						if (var14 != null && var14.field701 instanceof Model) {
							Model var15 = (Model) var14.field701;
							this.method596(var15, var4, var5, var6);
							var14.field701 = var15.method2942(var15.field2708, var15.field2706, arg0, arg1, arg2);
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("aq.av(Lfw;III)V")
	public void method596(Model arg0, int arg1, int arg2, int arg3) {
		if (arg2 < this.field582) {
			Ground var5 = this.field585[arg1][arg2 + 1][arg3];
			if (var5 != null && var5.field1709 != null && var5.field1709.field701 instanceof Model) {
				Model var6 = (Model) var5.field1709.field701;
				Model.method2941(arg0, var6, 128, 0, 0, true);
			}
		}
		if (arg3 < this.field582) {
			Ground var7 = this.field585[arg1][arg2][arg3 + 1];
			if (var7 != null && var7.field1709 != null && var7.field1709.field701 instanceof Model) {
				Model var8 = (Model) var7.field1709.field701;
				Model.method2941(arg0, var8, 0, 0, 128, true);
			}
		}
		if (arg2 < this.field582 && arg3 < this.field589) {
			Ground var9 = this.field585[arg1][arg2 + 1][arg3 + 1];
			if (var9 != null && var9.field1709 != null && var9.field1709.field701 instanceof Model) {
				Model var10 = (Model) var9.field1709.field701;
				Model.method2941(arg0, var10, 128, 0, 128, true);
			}
		}
		if (arg2 >= this.field582 || arg3 <= 0) {
			return;
		}
		Ground var11 = this.field585[arg1][arg2 + 1][arg3 - 1];
		if (var11 != null && var11.field1709 != null && var11.field1709.field701 instanceof Model) {
			Model var12 = (Model) var11.field1709.field701;
			Model.method2941(arg0, var12, 128, 0, -128, true);
		}
	}

	@ObfuscatedName("aq.ak(Lfw;IIIII)V")
	public void method597(Model arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		boolean var7 = true;
		int var8 = arg2;
		int var9 = arg2 + arg4;
		int var10 = arg3 - 1;
		int var11 = arg3 + arg5;
		for (int var12 = arg1; var12 <= arg1 + 1; var12++) {
			if (this.field581 != var12) {
				for (int var13 = var8; var13 <= var9; var13++) {
					if (var13 >= 0 && var13 < this.field582) {
						for (int var14 = var10; var14 <= var11; var14++) {
							if (var14 >= 0 && var14 < this.field589 && (!var7 || var13 >= var9 || var14 >= var11 || var14 < arg3 && arg2 != var13)) {
								Ground var15 = this.field585[var12][var13][var14];
								if (var15 != null) {
									int var16 = (this.field584[var12][var13 + 1][var14] + this.field584[var12][var13][var14] + this.field584[var12][var13][var14 + 1] + this.field584[var12][var13 + 1][var14 + 1]) / 4 - (this.field584[arg1][arg2 + 1][arg3] + this.field584[arg1][arg2][arg3] + this.field584[arg1][arg2][arg3 + 1] + this.field584[arg1][arg2 + 1][arg3 + 1]) / 4;
									Wall var17 = var15.field1703;
									if (var17 != null) {
										if (var17.field646 instanceof Model) {
											Model var18 = (Model) var17.field646;
											Model.method2941(arg0, var18, (var13 - arg2) * 128 + (1 - arg4) * 64, var16, (var14 - arg3) * 128 + (1 - arg5) * 64, var7);
										}
										if (var17.field649 instanceof Model) {
											Model var19 = (Model) var17.field649;
											Model.method2941(arg0, var19, (var13 - arg2) * 128 + (1 - arg4) * 64, var16, (var14 - arg3) * 128 + (1 - arg5) * 64, var7);
										}
									}
									for (int var20 = 0; var20 < var15.field1712; var20++) {
										Location var21 = var15.field1700[var20];
										if (var21 != null && var21.field672 instanceof Model) {
											Model var22 = (Model) var21.field672;
											int var23 = var21.field673 - var21.field675 + 1;
											int var24 = var21.field667 - var21.field674 + 1;
											Model.method2941(arg0, var22, (var21.field675 - arg2) * 128 + (var23 - arg4) * 64, var16, (var21.field674 - arg3) * 128 + (var24 - arg5) * 64, var7);
										}
									}
								}
							}
						}
					}
				}
				var8--;
				var7 = false;
			}
		}
	}

	@ObfuscatedName("aq.az([IIIIII)V")
	public void method598(int[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		Ground var7 = this.field585[arg3][arg4][arg5];
		if (var7 == null) {
			return;
		}
		TileUnderlay var8 = var7.field1701;
		if (var8 != null) {
			int var9 = var8.field697;
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
		TileOverlay var11 = var7.field1705;
		if (var11 == null) {
			return;
		}
		int var12 = var11.field563;
		int var13 = var11.field558;
		int var14 = var11.field559;
		int var15 = var11.field571;
		int[] var16 = this.field604[var12];
		int[] var17 = this.field634[var13];
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
	public static void method599(int[] arg0, int arg1, int arg2, int arg3, int arg4) {
		Statics.field639 = 0;
		Statics.field592 = 0;
		Statics.field641 = arg3;
		Statics.field613 = arg4;
		Statics.field637 = arg3 / 2;
		Statics.field638 = arg4 / 2;
		boolean[][][][] var5 = new boolean[9][32][53][53];
		for (int var6 = 128; var6 <= 384; var6 += 32) {
			for (int var7 = 0; var7 < 2048; var7 += 64) {
				Statics.field621 = Pix3D.field2533[var6];
				Statics.field616 = Pix3D.field2530[var6];
				Statics.field609 = Pix3D.field2533[var7];
				Statics.field610 = Pix3D.field2530[var7];
				int var8 = (var6 - 128) / 32;
				int var9 = var7 / 64;
				for (int var10 = -26; var10 <= 26; var10++) {
					for (int var11 = -26; var11 <= 26; var11++) {
						int var12 = var10 * 128;
						int var13 = var11 * 128;
						boolean var14 = false;
						for (int var15 = -arg1; var15 <= arg2; var15 += 128) {
							if (method600(var12, arg0[var8] + var15, var13)) {
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
						label76: for (int var21 = -1; var21 <= 1; var21++) {
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
						field642[var16][var17][var18 + 25][var19 + 25] = var20;
					}
				}
			}
		}
	}

	@ObfuscatedName("aq.ah(III)Z")
	public static boolean method600(int arg0, int arg1, int arg2) {
		int var3 = Statics.field610 * arg0 + Statics.field609 * arg2 >> 16;
		int var4 = Statics.field610 * arg2 - Statics.field609 * arg0 >> 16;
		int var5 = Statics.field621 * arg1 + Statics.field616 * var4 >> 16;
		int var6 = Statics.field616 * arg1 - Statics.field621 * var4 >> 16;
		if (var5 >= 50 && var5 <= 3500) {
			int var7 = (var3 << 9) / var5 + Statics.field637;
			int var8 = (var6 << 9) / var5 + Statics.field638;
			return var7 >= Statics.field639 && var7 <= Statics.field641 && var8 >= Statics.field592 && var8 <= Statics.field613;
		} else {
			return false;
		}
	}

	@ObfuscatedName("aq.ay(III)V")
	public void method601(int arg0, int arg1, int arg2) {
		field612 = true;
		field600 = arg0;
		field598 = arg1;
		field615 = arg2;
		field580 = -1;
		field629 = -1;
	}

	@ObfuscatedName("aq.al(IIIIII)V")
	public void method609(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		if (arg0 < 0) {
			arg0 = 0;
		} else if (arg0 >= this.field582 * 128) {
			arg0 = this.field582 * 128 - 1;
		}
		if (arg2 < 0) {
			arg2 = 0;
		} else if (arg2 >= this.field589 * 128) {
			arg2 = this.field589 * 128 - 1;
		}
		Statics.field597++;
		Statics.field621 = Pix3D.field2533[arg3];
		Statics.field616 = Pix3D.field2530[arg3];
		Statics.field609 = Pix3D.field2533[arg4];
		Statics.field610 = Pix3D.field2530[arg4];
		Statics.field633 = field642[(arg3 - 128) / 32][arg4 / 64];
		Statics.field626 = arg0;
		Statics.field605 = arg1;
		Statics.field606 = arg2;
		Statics.field602 = arg0 / 128;
		Statics.field603 = arg2 / 128;
		field596 = arg5;
		Statics.field611 = Statics.field602 - 25;
		if (Statics.field611 < 0) {
			Statics.field611 = 0;
		}
		Statics.field624 = Statics.field603 - 25;
		if (Statics.field624 < 0) {
			Statics.field624 = 0;
		}
		Statics.field599 = Statics.field602 + 25;
		if (Statics.field599 > this.field582) {
			Statics.field599 = this.field582;
		}
		Statics.field601 = Statics.field603 + 25;
		if (Statics.field601 > this.field589) {
			Statics.field601 = this.field589;
		}
		this.method608();
		field595 = 0;
		for (int var7 = this.field588; var7 < this.field581; var7++) {
			Ground[][] var8 = this.field585[var7];
			for (int var9 = Statics.field611; var9 < Statics.field599; var9++) {
				for (int var10 = Statics.field624; var10 < Statics.field601; var10++) {
					Ground var11 = var8[var9][var10];
					if (var11 != null) {
						if (var11.field1711 <= arg5 && (Statics.field633[var9 - Statics.field602 + 25][var10 - Statics.field603 + 25] || this.field584[var7][var9][var10] - arg1 >= 2000)) {
							var11.field1702 = true;
							var11.field1713 = true;
							if (var11.field1712 > 0) {
								var11.field1714 = true;
							} else {
								var11.field1714 = false;
							}
							field595++;
						} else {
							var11.field1702 = false;
							var11.field1713 = false;
							var11.field1715 = 0;
						}
					}
				}
			}
		}
		for (int var12 = this.field588; var12 < this.field581; var12++) {
			Ground[][] var13 = this.field585[var12];
			for (int var14 = -25; var14 <= 0; var14++) {
				int var15 = Statics.field602 + var14;
				int var16 = Statics.field602 - var14;
				if (var15 >= Statics.field611 || var16 < Statics.field599) {
					for (int var17 = -25; var17 <= 0; var17++) {
						int var18 = Statics.field603 + var17;
						int var19 = Statics.field603 - var17;
						if (var15 >= Statics.field611) {
							if (var18 >= Statics.field624) {
								Ground var20 = var13[var15][var18];
								if (var20 != null && var20.field1702) {
									this.method679(var20, true);
								}
							}
							if (var19 < Statics.field601) {
								Ground var21 = var13[var15][var19];
								if (var21 != null && var21.field1702) {
									this.method679(var21, true);
								}
							}
						}
						if (var16 < Statics.field599) {
							if (var18 >= Statics.field624) {
								Ground var22 = var13[var16][var18];
								if (var22 != null && var22.field1702) {
									this.method679(var22, true);
								}
							}
							if (var19 < Statics.field601) {
								Ground var23 = var13[var16][var19];
								if (var23 != null && var23.field1702) {
									this.method679(var23, true);
								}
							}
						}
						if (field595 == 0) {
							field612 = false;
							return;
						}
					}
				}
			}
		}
		for (int var24 = this.field588; var24 < this.field581; var24++) {
			Ground[][] var25 = this.field585[var24];
			for (int var26 = -25; var26 <= 0; var26++) {
				int var27 = Statics.field602 + var26;
				int var28 = Statics.field602 - var26;
				if (var27 >= Statics.field611 || var28 < Statics.field599) {
					for (int var29 = -25; var29 <= 0; var29++) {
						int var30 = Statics.field603 + var29;
						int var31 = Statics.field603 - var29;
						if (var27 >= Statics.field611) {
							if (var30 >= Statics.field624) {
								Ground var32 = var25[var27][var30];
								if (var32 != null && var32.field1702) {
									this.method679(var32, false);
								}
							}
							if (var31 < Statics.field601) {
								Ground var33 = var25[var27][var31];
								if (var33 != null && var33.field1702) {
									this.method679(var33, false);
								}
							}
						}
						if (var28 < Statics.field599) {
							if (var30 >= Statics.field624) {
								Ground var34 = var25[var28][var30];
								if (var34 != null && var34.field1702) {
									this.method679(var34, false);
								}
							}
							if (var31 < Statics.field601) {
								Ground var35 = var25[var28][var31];
								if (var35 != null && var35.field1702) {
									this.method679(var35, false);
								}
							}
						}
						if (field595 == 0) {
							field612 = false;
							return;
						}
					}
				}
			}
		}
		field612 = false;
	}

	@ObfuscatedName("aq.ab(Les;Z)V")
	public void method679(Ground arg0, boolean arg1) {
		field625.method1292(arg0);
		while (true) {
			Ground var3;
			int var4;
			int var5;
			int var6;
			int var7;
			Ground[][] var8;
			Ground var67;
			do {
				Ground var66;
				do {
					Ground var65;
					do {
						Ground var64;
						do {
							do {
								do {
									while (true) {
										while (true) {
											do {
												var3 = (Ground) field625.method1295();
												if (var3 == null) {
													return;
												}
											} while (!var3.field1713);
											var4 = var3.field1698;
											var5 = var3.field1699;
											var6 = var3.field1707;
											var7 = var3.field1697;
											var8 = this.field585[var6];
											if (!var3.field1702) {
												break;
											}
											if (arg1) {
												if (var6 > 0) {
													Ground var9 = this.field585[var6 - 1][var4][var5];
													if (var9 != null && var9.field1713) {
														continue;
													}
												}
												if (var4 <= Statics.field602 && var4 > Statics.field611) {
													Ground var10 = var8[var4 - 1][var5];
													if (var10 != null && var10.field1713 && (var10.field1702 || (var3.field1710 & 0x1) == 0)) {
														continue;
													}
												}
												if (var4 >= Statics.field602 && var4 < Statics.field599 - 1) {
													Ground var11 = var8[var4 + 1][var5];
													if (var11 != null && var11.field1713 && (var11.field1702 || (var3.field1710 & 0x4) == 0)) {
														continue;
													}
												}
												if (var5 <= Statics.field603 && var5 > Statics.field624) {
													Ground var12 = var8[var4][var5 - 1];
													if (var12 != null && var12.field1713 && (var12.field1702 || (var3.field1710 & 0x8) == 0)) {
														continue;
													}
												}
												if (var5 >= Statics.field603 && var5 < Statics.field601 - 1) {
													Ground var13 = var8[var4][var5 + 1];
													if (var13 != null && var13.field1713 && (var13.field1702 || (var3.field1710 & 0x2) == 0)) {
														continue;
													}
												}
											} else {
												arg1 = true;
											}
											var3.field1702 = false;
											if (var3.field1719 != null) {
												Ground var14 = var3.field1719;
												if (var14.field1701 == null) {
													if (var14.field1705 != null && !this.method707(0, var4, var5)) {
														this.method605(var14.field1705, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var4, var5);
													}
												} else if (!this.method707(0, var4, var5)) {
													this.method604(var14.field1701, 0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var4, var5);
												}
												Wall var15 = var14.field1703;
												if (var15 != null) {
													var15.field646.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var15.field650 - Statics.field626, var15.field648 - Statics.field605, var15.field645 - Statics.field606, var15.field647);
												}
												for (int var16 = 0; var16 < var14.field1712; var16++) {
													Location var17 = var14.field1700[var16];
													if (var17 != null) {
														var17.field672.method2642(var17.field671, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var17.field679 - Statics.field626, var17.field666 - Statics.field605, var17.field669 - Statics.field606, var17.field678);
													}
												}
											}
											boolean var18 = false;
											if (var3.field1701 == null) {
												if (var3.field1705 != null && !this.method707(var7, var4, var5)) {
													var18 = true;
													this.method605(var3.field1705, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var4, var5);
												}
											} else if (!this.method707(var7, var4, var5)) {
												var18 = true;
												if (var3.field1701.field691 != 12345678 || field612 && var6 <= field600) {
													this.method604(var3.field1701, var7, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var4, var5);
												}
											}
											int var19 = 0;
											int var20 = 0;
											Wall var21 = var3.field1703;
											Decor var22 = var3.field1704;
											if (var21 != null || var22 != null) {
												if (Statics.field602 == var4) {
													var19++;
												} else if (Statics.field602 < var4) {
													var19 += 2;
												}
												if (Statics.field603 == var5) {
													var19 += 3;
												} else if (Statics.field603 > var5) {
													var19 += 6;
												}
												var20 = field583[var19];
												var3.field1708 = field628[var19];
											}
											if (var21 != null) {
												if ((var21.field644 & field627[var19]) == 0) {
													var3.field1715 = 0;
												} else if (var21.field644 == 16) {
													var3.field1715 = 3;
													var3.field1718 = field636[var19];
													var3.field1717 = 3 - var3.field1718;
												} else if (var21.field644 == 32) {
													var3.field1715 = 6;
													var3.field1718 = field630[var19];
													var3.field1717 = 6 - var3.field1718;
												} else if (var21.field644 == 64) {
													var3.field1715 = 12;
													var3.field1718 = field631[var19];
													var3.field1717 = 12 - var3.field1718;
												} else {
													var3.field1715 = 9;
													var3.field1718 = field632[var19];
													var3.field1717 = 9 - var3.field1718;
												}
												if ((var21.field644 & var20) != 0 && !this.method610(var7, var4, var5, var21.field644)) {
													var21.field646.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var21.field650 - Statics.field626, var21.field648 - Statics.field605, var21.field645 - Statics.field606, var21.field647);
												}
												if ((var21.field643 & var20) != 0 && !this.method610(var7, var4, var5, var21.field643)) {
													var21.field649.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var21.field650 - Statics.field626, var21.field648 - Statics.field605, var21.field645 - Statics.field606, var21.field647);
												}
											}
											if (var22 != null && !this.method718(var7, var4, var5, var22.field712.field2487)) {
												if ((var22.field711 & var20) != 0) {
													var22.field712.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var22.field708 + (var22.field710 - Statics.field626), var22.field709 - Statics.field605, var22.field706 + (var22.field707 - Statics.field606), var22.field714);
												} else if (var22.field711 == 256) {
													int var23 = var22.field710 - Statics.field626;
													int var24 = var22.field709 - Statics.field605;
													int var25 = var22.field707 - Statics.field606;
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
														var22.field712.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var22.field708 + var23, var24, var22.field706 + var25, var22.field714);
													} else if (var22.field713 != null) {
														var22.field713.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var23, var24, var25, var22.field714);
													}
												}
											}
											if (var18) {
												GroundDecor var29 = var3.field1709;
												if (var29 != null) {
													var29.field701.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var29.field703 - Statics.field626, var29.field699 - Statics.field605, var29.field700 - Statics.field606, var29.field702);
												}
												GroundObject var30 = var3.field1706;
												if (var30 != null && var30.field689 == 0) {
													if (var30.field686 != null) {
														var30.field686.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var30.field683 - Statics.field626, var30.field684 - Statics.field605, var30.field682 - Statics.field606, var30.field688);
													}
													if (var30.field687 != null) {
														var30.field687.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var30.field683 - Statics.field626, var30.field684 - Statics.field605, var30.field682 - Statics.field606, var30.field688);
													}
													if (var30.field685 != null) {
														var30.field685.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var30.field683 - Statics.field626, var30.field684 - Statics.field605, var30.field682 - Statics.field606, var30.field688);
													}
												}
											}
											int var31 = var3.field1710;
											if (var31 != 0) {
												if (var4 < Statics.field602 && (var31 & 0x4) != 0) {
													Ground var32 = var8[var4 + 1][var5];
													if (var32 != null && var32.field1713) {
														field625.method1292(var32);
													}
												}
												if (var5 < Statics.field603 && (var31 & 0x2) != 0) {
													Ground var33 = var8[var4][var5 + 1];
													if (var33 != null && var33.field1713) {
														field625.method1292(var33);
													}
												}
												if (var4 > Statics.field602 && (var31 & 0x1) != 0) {
													Ground var34 = var8[var4 - 1][var5];
													if (var34 != null && var34.field1713) {
														field625.method1292(var34);
													}
												}
												if (var5 > Statics.field603 && (var31 & 0x8) != 0) {
													Ground var35 = var8[var4][var5 - 1];
													if (var35 != null && var35.field1713) {
														field625.method1292(var35);
													}
												}
											}
											break;
										}
										if (var3.field1715 != 0) {
											boolean var36 = true;
											for (int var37 = 0; var37 < var3.field1712; var37++) {
												if (var3.field1700[var37].field677 != Statics.field597 && (var3.field1716[var37] & var3.field1715) == var3.field1718) {
													var36 = false;
													break;
												}
											}
											if (var36) {
												Wall var38 = var3.field1703;
												if (!this.method610(var7, var4, var5, var38.field644)) {
													var38.field646.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var38.field650 - Statics.field626, var38.field648 - Statics.field605, var38.field645 - Statics.field606, var38.field647);
												}
												var3.field1715 = 0;
											}
										}
										if (!var3.field1714) {
											break;
										}
										try {
											int var39 = var3.field1712;
											var3.field1714 = false;
											int var40 = 0;
											label563: for (int var41 = 0; var41 < var39; var41++) {
												Location var42 = var3.field1700[var41];
												if (var42.field677 != Statics.field597) {
													for (int var43 = var42.field675; var43 <= var42.field673; var43++) {
														for (int var44 = var42.field674; var44 <= var42.field667; var44++) {
															Ground var45 = var8[var43][var44];
															if (var45.field1702) {
																var3.field1714 = true;
																continue label563;
															}
															if (var45.field1715 != 0) {
																int var46 = 0;
																if (var43 > var42.field675) {
																	var46++;
																}
																if (var43 < var42.field673) {
																	var46 += 4;
																}
																if (var44 > var42.field674) {
																	var46 += 8;
																}
																if (var44 < var42.field667) {
																	var46 += 2;
																}
																if ((var46 & var45.field1715) == var3.field1717) {
																	var3.field1714 = true;
																	continue label563;
																}
															}
														}
													}
													field640[var40++] = var42;
													int var47 = Statics.field602 - var42.field675;
													int var48 = var42.field673 - Statics.field602;
													if (var48 > var47) {
														var47 = var48;
													}
													int var49 = Statics.field603 - var42.field674;
													int var50 = var42.field667 - Statics.field603;
													if (var50 > var49) {
														var42.field668 = var47 + var50;
													} else {
														var42.field668 = var47 + var49;
													}
												}
											}
											while (var40 > 0) {
												int var51 = -50;
												int var52 = -1;
												for (int var53 = 0; var53 < var40; var53++) {
													Location var54 = field640[var53];
													if (var54.field677 != Statics.field597) {
														if (var54.field668 > var51) {
															var51 = var54.field668;
															var52 = var53;
														} else if (var54.field668 == var51) {
															int var55 = var54.field679 - Statics.field626;
															int var56 = var54.field669 - Statics.field606;
															int var57 = field640[var52].field679 - Statics.field626;
															int var58 = field640[var52].field669 - Statics.field606;
															if (var55 * var55 + var56 * var56 > var57 * var57 + var58 * var58) {
																var52 = var53;
															}
														}
													}
												}
												if (var52 == -1) {
													break;
												}
												Location var59 = field640[var52];
												var59.field677 = Statics.field597;
												if (!this.method671(var7, var59.field675, var59.field673, var59.field674, var59.field667, var59.field672.field2487)) {
													var59.field672.method2642(var59.field671, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var59.field679 - Statics.field626, var59.field666 - Statics.field605, var59.field669 - Statics.field606, var59.field678);
												}
												for (int var60 = var59.field675; var60 <= var59.field673; var60++) {
													for (int var61 = var59.field674; var61 <= var59.field667; var61++) {
														Ground var62 = var8[var60][var61];
														if (var62.field1715 != 0) {
															field625.method1292(var62);
														} else if ((var4 != var60 || var5 != var61) && var62.field1713) {
															field625.method1292(var62);
														}
													}
												}
											}
											if (!var3.field1714) {
												break;
											}
										} catch (Exception var82) {
											var3.field1714 = false;
											break;
										}
									}
								} while (!var3.field1713);
							} while (var3.field1715 != 0);
							if (var4 > Statics.field602 || var4 <= Statics.field611) {
								break;
							}
							var64 = var8[var4 - 1][var5];
						} while (var64 != null && var64.field1713);
						if (var4 < Statics.field602 || var4 >= Statics.field599 - 1) {
							break;
						}
						var65 = var8[var4 + 1][var5];
					} while (var65 != null && var65.field1713);
					if (var5 > Statics.field603 || var5 <= Statics.field624) {
						break;
					}
					var66 = var8[var4][var5 - 1];
				} while (var66 != null && var66.field1713);
				if (var5 < Statics.field603 || var5 >= Statics.field601 - 1) {
					break;
				}
				var67 = var8[var4][var5 + 1];
			} while (var67 != null && var67.field1713);
			var3.field1713 = false;
			field595--;
			GroundObject var68 = var3.field1706;
			if (var68 != null && var68.field689 != 0) {
				if (var68.field686 != null) {
					var68.field686.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var68.field683 - Statics.field626, var68.field684 - Statics.field605 - var68.field689, var68.field682 - Statics.field606, var68.field688);
				}
				if (var68.field687 != null) {
					var68.field687.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var68.field683 - Statics.field626, var68.field684 - Statics.field605 - var68.field689, var68.field682 - Statics.field606, var68.field688);
				}
				if (var68.field685 != null) {
					var68.field685.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var68.field683 - Statics.field626, var68.field684 - Statics.field605 - var68.field689, var68.field682 - Statics.field606, var68.field688);
				}
			}
			if (var3.field1708 != 0) {
				Decor var69 = var3.field1704;
				if (var69 != null && !this.method718(var7, var4, var5, var69.field712.field2487)) {
					if ((var69.field711 & var3.field1708) != 0) {
						var69.field712.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var69.field708 + (var69.field710 - Statics.field626), var69.field709 - Statics.field605, var69.field706 + (var69.field707 - Statics.field606), var69.field714);
					} else if (var69.field711 == 256) {
						int var70 = var69.field710 - Statics.field626;
						int var71 = var69.field709 - Statics.field605;
						int var72 = var69.field707 - Statics.field606;
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
							var69.field712.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var69.field708 + var70, var71, var69.field706 + var72, var69.field714);
						} else if (var69.field713 != null) {
							var69.field713.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var70, var71, var72, var69.field714);
						}
					}
				}
				Wall var76 = var3.field1703;
				if (var76 != null) {
					if ((var76.field643 & var3.field1708) != 0 && !this.method610(var7, var4, var5, var76.field643)) {
						var76.field649.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var76.field650 - Statics.field626, var76.field648 - Statics.field605, var76.field645 - Statics.field606, var76.field647);
					}
					if ((var76.field644 & var3.field1708) != 0 && !this.method610(var7, var4, var5, var76.field644)) {
						var76.field646.method2642(0, Statics.field621, Statics.field616, Statics.field609, Statics.field610, var76.field650 - Statics.field626, var76.field648 - Statics.field605, var76.field645 - Statics.field606, var76.field647);
					}
				}
			}
			if (var6 < this.field581 - 1) {
				Ground var77 = this.field585[var6 + 1][var4][var5];
				if (var77 != null && var77.field1713) {
					field625.method1292(var77);
				}
			}
			if (var4 < Statics.field602) {
				Ground var78 = var8[var4 + 1][var5];
				if (var78 != null && var78.field1713) {
					field625.method1292(var78);
				}
			}
			if (var5 < Statics.field603) {
				Ground var79 = var8[var4][var5 + 1];
				if (var79 != null && var79.field1713) {
					field625.method1292(var79);
				}
			}
			if (var4 > Statics.field602) {
				Ground var80 = var8[var4 - 1][var5];
				if (var80 != null && var80.field1713) {
					field625.method1292(var80);
				}
			}
			if (var5 > Statics.field603) {
				Ground var81 = var8[var4][var5 - 1];
				if (var81 != null && var81.field1713) {
					field625.method1292(var81);
				}
			}
		}
	}

	@ObfuscatedName("aq.ao(Lai;IIIIIII)V")
	public void method604(TileUnderlay arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		int var9;
		int var10 = var9 = (arg6 << 7) - Statics.field626;
		int var11;
		int var12 = var11 = (arg7 << 7) - Statics.field606;
		int var13;
		int var14 = var13 = var10 + 128;
		int var15;
		int var16 = var15 = var12 + 128;
		int var17 = this.field584[arg1][arg6][arg7] - Statics.field605;
		int var18 = this.field584[arg1][arg6 + 1][arg7] - Statics.field605;
		int var19 = this.field584[arg1][arg6 + 1][arg7 + 1] - Statics.field605;
		int var20 = this.field584[arg1][arg6][arg7 + 1] - Statics.field605;
		int var21 = arg4 * var12 + arg5 * var10 >> 16;
		int var22 = arg5 * var12 - arg4 * var10 >> 16;
		int var24 = arg3 * var17 - arg2 * var22 >> 16;
		int var25 = arg2 * var17 + arg3 * var22 >> 16;
		if (var25 < 50) {
			return;
		}
		int var27 = arg4 * var11 + arg5 * var14 >> 16;
		int var28 = arg5 * var11 - arg4 * var14 >> 16;
		int var30 = arg3 * var18 - arg2 * var28 >> 16;
		int var31 = arg2 * var18 + arg3 * var28 >> 16;
		if (var31 < 50) {
			return;
		}
		int var33 = arg4 * var16 + arg5 * var13 >> 16;
		int var34 = arg5 * var16 - arg4 * var13 >> 16;
		int var36 = arg3 * var19 - arg2 * var34 >> 16;
		int var37 = arg2 * var19 + arg3 * var34 >> 16;
		if (var37 < 50) {
			return;
		}
		int var39 = arg4 * var15 + arg5 * var9 >> 16;
		int var40 = arg5 * var15 - arg4 * var9 >> 16;
		int var42 = arg3 * var20 - arg2 * var40 >> 16;
		int var43 = arg2 * var20 + arg3 * var40 >> 16;
		if (var43 < 50) {
			return;
		}
		int var45 = (var21 << 9) / var25 + Statics.field2529;
		int var46 = (var24 << 9) / var25 + Statics.field2541;
		int var47 = (var27 << 9) / var31 + Statics.field2529;
		int var48 = (var30 << 9) / var31 + Statics.field2541;
		int var49 = (var33 << 9) / var37 + Statics.field2529;
		int var50 = (var36 << 9) / var37 + Statics.field2541;
		int var51 = (var39 << 9) / var43 + Statics.field2529;
		int var52 = (var42 << 9) / var43 + Statics.field2541;
		Pix3D.field2523 = 0;
		if ((var48 - var52) * (var49 - var51) - (var47 - var51) * (var50 - var52) > 0) {
			Pix3D.field2524 = false;
			if (var49 < 0 || var51 < 0 || var47 < 0 || var49 > Statics.field2536 || var51 > Statics.field2536 || var47 > Statics.field2536) {
				Pix3D.field2524 = true;
			}
			if (field612 && this.method607(field598, field615, var50, var52, var48, var49, var51, var47)) {
				field580 = arg6;
				field629 = arg7;
			}
			if (arg0.field695 == -1) {
				if (arg0.field691 != 12345678) {
					Pix3D.method2794(var50, var52, var48, var49, var51, var47, arg0.field691, arg0.field694, arg0.field692);
				}
			} else if (field593) {
				int var53 = Statics.field2539.method731(arg0.field695);
				Pix3D.method2794(var50, var52, var48, var49, var51, var47, method612(var53, arg0.field691), method612(var53, arg0.field694), method612(var53, arg0.field692));
			} else if (arg0.field693) {
				Pix3D.method2771(var50, var52, var48, var49, var51, var47, arg0.field691, arg0.field694, arg0.field692, var21, var27, var39, var24, var30, var42, var25, var31, var43, arg0.field695);
			} else {
				Pix3D.method2771(var50, var52, var48, var49, var51, var47, arg0.field691, arg0.field694, arg0.field692, var33, var39, var27, var36, var42, var30, var37, var43, var31, arg0.field695);
			}
		}
		if ((var45 - var47) * (var52 - var48) - (var46 - var48) * (var51 - var47) <= 0) {
			return;
		}
		Pix3D.field2524 = false;
		if (var45 < 0 || var47 < 0 || var51 < 0 || var45 > Statics.field2536 || var47 > Statics.field2536 || var51 > Statics.field2536) {
			Pix3D.field2524 = true;
		}
		if (field612 && this.method607(field598, field615, var46, var48, var52, var45, var47, var51)) {
			field580 = arg6;
			field629 = arg7;
		}
		if (arg0.field695 == -1) {
			if (arg0.field696 != 12345678) {
				Pix3D.method2794(var46, var48, var52, var45, var47, var51, arg0.field696, arg0.field692, arg0.field694);
			}
		} else if (field593) {
			int var54 = Statics.field2539.method731(arg0.field695);
			Pix3D.method2794(var46, var48, var52, var45, var47, var51, method612(var54, arg0.field696), method612(var54, arg0.field692), method612(var54, arg0.field694));
		} else {
			Pix3D.method2771(var46, var48, var52, var45, var47, var51, arg0.field696, arg0.field692, arg0.field694, var21, var27, var39, var24, var30, var42, var25, var31, var43, arg0.field695);
		}
	}

	@ObfuscatedName("aq.ag(Lar;IIIIII)V")
	public void method605(TileOverlay arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		int var8 = arg0.field564.length;
		for (int var9 = 0; var9 < var8; var9++) {
			int var10 = arg0.field564[var9] - Statics.field626;
			int var11 = arg0.field579[var9] - Statics.field605;
			int var12 = arg0.field560[var9] - Statics.field606;
			int var13 = arg3 * var12 + arg4 * var10 >> 16;
			int var14 = arg4 * var12 - arg3 * var10 >> 16;
			int var16 = arg2 * var11 - arg1 * var14 >> 16;
			int var17 = arg1 * var11 + arg2 * var14 >> 16;
			if (var17 < 50) {
				return;
			}
			if (arg0.field567 != null) {
				TileOverlay.field575[var9] = var13;
				TileOverlay.field576[var9] = var16;
				TileOverlay.field577[var9] = var17;
			}
			TileOverlay.field573[var9] = (var13 << 9) / var17 + Statics.field2529;
			TileOverlay.field574[var9] = (var16 << 9) / var17 + Statics.field2541;
		}
		Pix3D.field2523 = 0;
		int var19 = arg0.field561.length;
		for (int var20 = 0; var20 < var19; var20++) {
			int var21 = arg0.field561[var20];
			int var22 = arg0.field572[var20];
			int var23 = arg0.field565[var20];
			int var24 = TileOverlay.field573[var21];
			int var25 = TileOverlay.field573[var22];
			int var26 = TileOverlay.field573[var23];
			int var27 = TileOverlay.field574[var21];
			int var28 = TileOverlay.field574[var22];
			int var29 = TileOverlay.field574[var23];
			if ((var24 - var25) * (var29 - var28) - (var26 - var25) * (var27 - var28) > 0) {
				Pix3D.field2524 = false;
				if (var24 < 0 || var25 < 0 || var26 < 0 || var24 > Statics.field2536 || var25 > Statics.field2536 || var26 > Statics.field2536) {
					Pix3D.field2524 = true;
				}
				if (field612 && this.method607(field598, field615, var27, var28, var29, var24, var25, var26)) {
					field580 = arg5;
					field629 = arg6;
				}
				if (arg0.field567 == null || arg0.field567[var20] == -1) {
					if (arg0.field566[var20] != 12345678) {
						Pix3D.method2794(var27, var28, var29, var24, var25, var26, arg0.field566[var20], arg0.field562[var20], arg0.field569[var20]);
					}
				} else if (field593) {
					int var30 = Statics.field2539.method731(arg0.field567[var20]);
					Pix3D.method2794(var27, var28, var29, var24, var25, var26, method612(var30, arg0.field566[var20]), method612(var30, arg0.field562[var20]), method612(var30, arg0.field569[var20]));
				} else if (arg0.field568) {
					Pix3D.method2771(var27, var28, var29, var24, var25, var26, arg0.field566[var20], arg0.field562[var20], arg0.field569[var20], TileOverlay.field575[0], TileOverlay.field575[1], TileOverlay.field575[3], TileOverlay.field576[0], TileOverlay.field576[1], TileOverlay.field576[3], TileOverlay.field577[0], TileOverlay.field577[1], TileOverlay.field577[3], arg0.field567[var20]);
				} else {
					Pix3D.method2771(var27, var28, var29, var24, var25, var26, arg0.field566[var20], arg0.field562[var20], arg0.field569[var20], TileOverlay.field575[var21], TileOverlay.field575[var22], TileOverlay.field575[var23], TileOverlay.field576[var21], TileOverlay.field576[var22], TileOverlay.field576[var23], TileOverlay.field577[var21], TileOverlay.field577[var22], TileOverlay.field577[var23], arg0.field567[var20]);
				}
			}
		}
	}

	@ObfuscatedName("aq.ar(II)I")
	public static final int method612(int arg0, int arg1) {
		int var2 = (arg0 & 0x7F) * arg1 >> 7;
		if (var2 < 2) {
			var2 = 2;
		} else if (var2 > 126) {
			var2 = 126;
		}
		return (arg0 & 0xFF80) + var2;
	}

	@ObfuscatedName("aq.aq(IIIIIIII)Z")
	public boolean method607(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
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
	public void method608() {
		int var1 = field635[field596];
		Occlude[] var2 = field622[field596];
		field614 = 0;
		for (int var3 = 0; var3 < var1; var3++) {
			Occlude var4 = var2[var3];
			if (var4.field737 == 1) {
				int var5 = var4.field726 - Statics.field602 + 25;
				if (var5 >= 0 && var5 <= 50) {
					int var6 = var4.field725 - Statics.field603 + 25;
					if (var6 < 0) {
						var6 = 0;
					}
					int var7 = var4.field724 - Statics.field603 + 25;
					if (var7 > 50) {
						var7 = 50;
					}
					boolean var8 = false;
					while (var6 <= var7) {
						if (Statics.field633[var5][var6++]) {
							var8 = true;
							break;
						}
					}
					if (var8) {
						int var9 = Statics.field626 - var4.field739;
						if (var9 > 32) {
							var4.field734 = 1;
						} else {
							if (var9 >= -32) {
								continue;
							}
							var4.field734 = 2;
							var9 = -var9;
						}
						var4.field729 = (var4.field730 - Statics.field606 << 8) / var9;
						var4.field738 = (var4.field731 - Statics.field606 << 8) / var9;
						var4.field732 = (var4.field727 - Statics.field605 << 8) / var9;
						var4.field740 = (var4.field733 - Statics.field605 << 8) / var9;
						field607[field614++] = var4;
					}
				}
			} else if (var4.field737 == 2) {
				int var10 = var4.field725 - Statics.field603 + 25;
				if (var10 >= 0 && var10 <= 50) {
					int var11 = var4.field726 - Statics.field602 + 25;
					if (var11 < 0) {
						var11 = 0;
					}
					int var12 = var4.field735 - Statics.field602 + 25;
					if (var12 > 50) {
						var12 = 50;
					}
					boolean var13 = false;
					while (var11 <= var12) {
						if (Statics.field633[var11++][var10]) {
							var13 = true;
							break;
						}
					}
					if (var13) {
						int var14 = Statics.field606 - var4.field730;
						if (var14 > 32) {
							var4.field734 = 3;
						} else {
							if (var14 >= -32) {
								continue;
							}
							var4.field734 = 4;
							var14 = -var14;
						}
						var4.field728 = (var4.field739 - Statics.field626 << 8) / var14;
						var4.field736 = (var4.field723 - Statics.field626 << 8) / var14;
						var4.field732 = (var4.field727 - Statics.field605 << 8) / var14;
						var4.field740 = (var4.field733 - Statics.field605 << 8) / var14;
						field607[field614++] = var4;
					}
				}
			} else if (var4.field737 == 4) {
				int var15 = var4.field727 - Statics.field605;
				if (var15 > 128) {
					int var16 = var4.field725 - Statics.field603 + 25;
					if (var16 < 0) {
						var16 = 0;
					}
					int var17 = var4.field724 - Statics.field603 + 25;
					if (var17 > 50) {
						var17 = 50;
					}
					if (var16 <= var17) {
						int var18 = var4.field726 - Statics.field602 + 25;
						if (var18 < 0) {
							var18 = 0;
						}
						int var19 = var4.field735 - Statics.field602 + 25;
						if (var19 > 50) {
							var19 = 50;
						}
						boolean var20 = false;
						label145: for (int var21 = var18; var21 <= var19; var21++) {
							for (int var22 = var16; var22 <= var17; var22++) {
								if (Statics.field633[var21][var22]) {
									var20 = true;
									break label145;
								}
							}
						}
						if (var20) {
							var4.field734 = 5;
							var4.field728 = (var4.field739 - Statics.field626 << 8) / var15;
							var4.field736 = (var4.field723 - Statics.field626 << 8) / var15;
							var4.field729 = (var4.field730 - Statics.field606 << 8) / var15;
							var4.field738 = (var4.field731 - Statics.field606 << 8) / var15;
							field607[field614++] = var4;
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("aq.ae(III)Z")
	public boolean method707(int arg0, int arg1, int arg2) {
		int var4 = this.field608[arg0][arg1][arg2];
		if (-Statics.field597 == var4) {
			return false;
		} else if (Statics.field597 == var4) {
			return true;
		} else {
			int var5 = arg1 << 7;
			int var6 = arg2 << 7;
			if (this.method704(var5 + 1, this.field584[arg0][arg1][arg2], var6 + 1) && this.method704(var5 + 128 - 1, this.field584[arg0][arg1 + 1][arg2], var6 + 1) && this.method704(var5 + 128 - 1, this.field584[arg0][arg1 + 1][arg2 + 1], var6 + 128 - 1) && this.method704(var5 + 1, this.field584[arg0][arg1][arg2 + 1], var6 + 128 - 1)) {
				this.field608[arg0][arg1][arg2] = Statics.field597;
				return true;
			} else {
				this.field608[arg0][arg1][arg2] = -Statics.field597;
				return false;
			}
		}
	}

	@ObfuscatedName("aq.au(IIII)Z")
	public boolean method610(int arg0, int arg1, int arg2, int arg3) {
		if (!this.method707(arg0, arg1, arg2)) {
			return false;
		}
		int var5 = arg1 << 7;
		int var6 = arg2 << 7;
		int var7 = this.field584[arg0][arg1][arg2] - 1;
		int var8 = var7 - 120;
		int var9 = var7 - 230;
		int var10 = var7 - 238;
		if (arg3 < 16) {
			if (arg3 == 1) {
				if (var5 > Statics.field626) {
					if (!this.method704(var5, var7, var6)) {
						return false;
					}
					if (!this.method704(var5, var7, var6 + 128)) {
						return false;
					}
				}
				if (arg0 > 0) {
					if (!this.method704(var5, var8, var6)) {
						return false;
					}
					if (!this.method704(var5, var8, var6 + 128)) {
						return false;
					}
				}
				if (!this.method704(var5, var9, var6)) {
					return false;
				}
				if (!this.method704(var5, var9, var6 + 128)) {
					return false;
				}
				return true;
			}
			if (arg3 == 2) {
				if (var6 < Statics.field606) {
					if (!this.method704(var5, var7, var6 + 128)) {
						return false;
					}
					if (!this.method704(var5 + 128, var7, var6 + 128)) {
						return false;
					}
				}
				if (arg0 > 0) {
					if (!this.method704(var5, var8, var6 + 128)) {
						return false;
					}
					if (!this.method704(var5 + 128, var8, var6 + 128)) {
						return false;
					}
				}
				if (!this.method704(var5, var9, var6 + 128)) {
					return false;
				}
				if (!this.method704(var5 + 128, var9, var6 + 128)) {
					return false;
				}
				return true;
			}
			if (arg3 == 4) {
				if (var5 < Statics.field626) {
					if (!this.method704(var5 + 128, var7, var6)) {
						return false;
					}
					if (!this.method704(var5 + 128, var7, var6 + 128)) {
						return false;
					}
				}
				if (arg0 > 0) {
					if (!this.method704(var5 + 128, var8, var6)) {
						return false;
					}
					if (!this.method704(var5 + 128, var8, var6 + 128)) {
						return false;
					}
				}
				if (!this.method704(var5 + 128, var9, var6)) {
					return false;
				}
				if (!this.method704(var5 + 128, var9, var6 + 128)) {
					return false;
				}
				return true;
			}
			if (arg3 == 8) {
				if (var6 > Statics.field606) {
					if (!this.method704(var5, var7, var6)) {
						return false;
					}
					if (!this.method704(var5 + 128, var7, var6)) {
						return false;
					}
				}
				if (arg0 > 0) {
					if (!this.method704(var5, var8, var6)) {
						return false;
					}
					if (!this.method704(var5 + 128, var8, var6)) {
						return false;
					}
				}
				if (!this.method704(var5, var9, var6)) {
					return false;
				}
				if (!this.method704(var5 + 128, var9, var6)) {
					return false;
				}
				return true;
			}
		}
		if (!this.method704(var5 + 64, var10, var6 + 64)) {
			return false;
		} else if (arg3 == 16) {
			return this.method704(var5, var9, var6 + 128);
		} else if (arg3 == 32) {
			return this.method704(var5 + 128, var9, var6 + 128);
		} else if (arg3 == 64) {
			return this.method704(var5 + 128, var9, var6);
		} else if (arg3 == 128) {
			return this.method704(var5, var9, var6);
		} else {
			return true;
		}
	}

	@ObfuscatedName("aq.ax(IIII)Z")
	public boolean method718(int arg0, int arg1, int arg2, int arg3) {
		if (this.method707(arg0, arg1, arg2)) {
			int var5 = arg1 << 7;
			int var6 = arg2 << 7;
			return this.method704(var5 + 1, this.field584[arg0][arg1][arg2] - arg3, var6 + 1) && this.method704(var5 + 128 - 1, this.field584[arg0][arg1 + 1][arg2] - arg3, var6 + 1) && this.method704(var5 + 128 - 1, this.field584[arg0][arg1 + 1][arg2 + 1] - arg3, var6 + 128 - 1) && this.method704(var5 + 1, this.field584[arg0][arg1][arg2 + 1] - arg3, var6 + 128 - 1);
		} else {
			return false;
		}
	}

	@ObfuscatedName("aq.ai(IIIIII)Z")
	public boolean method671(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		if (arg1 != arg2 || arg3 != arg4) {
			for (int var9 = arg1; var9 <= arg2; var9++) {
				for (int var10 = arg3; var10 <= arg4; var10++) {
					if (this.field608[arg0][var9][var10] == -Statics.field597) {
						return false;
					}
				}
			}
			int var11 = (arg1 << 7) + 1;
			int var12 = (arg3 << 7) + 2;
			int var13 = this.field584[arg0][arg1][arg3] - arg5;
			if (!this.method704(var11, var13, var12)) {
				return false;
			}
			int var14 = (arg2 << 7) - 1;
			if (!this.method704(var14, var13, var12)) {
				return false;
			}
			int var15 = (arg4 << 7) - 1;
			if (!this.method704(var11, var13, var15)) {
				return false;
			} else if (this.method704(var14, var13, var15)) {
				return true;
			} else {
				return false;
			}
		} else if (this.method707(arg0, arg1, arg3)) {
			int var7 = arg1 << 7;
			int var8 = arg3 << 7;
			return this.method704(var7 + 1, this.field584[arg0][arg1][arg3] - arg5, var8 + 1) && this.method704(var7 + 128 - 1, this.field584[arg0][arg1 + 1][arg3] - arg5, var8 + 1) && this.method704(var7 + 128 - 1, this.field584[arg0][arg1 + 1][arg3 + 1] - arg5, var8 + 128 - 1) && this.method704(var7 + 1, this.field584[arg0][arg1][arg3 + 1] - arg5, var8 + 128 - 1);
		} else {
			return false;
		}
	}

	@ObfuscatedName("aq.aj(III)Z")
	public boolean method704(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < field614; var4++) {
			Occlude var5 = field607[var4];
			if (var5.field734 == 1) {
				int var6 = var5.field739 - arg0;
				if (var6 > 0) {
					int var7 = (var5.field729 * var6 >> 8) + var5.field730;
					int var8 = (var5.field738 * var6 >> 8) + var5.field731;
					int var9 = (var5.field732 * var6 >> 8) + var5.field727;
					int var10 = (var5.field740 * var6 >> 8) + var5.field733;
					if (arg2 >= var7 && arg2 <= var8 && arg1 >= var9 && arg1 <= var10) {
						return true;
					}
				}
			} else if (var5.field734 == 2) {
				int var11 = arg0 - var5.field739;
				if (var11 > 0) {
					int var12 = (var5.field729 * var11 >> 8) + var5.field730;
					int var13 = (var5.field738 * var11 >> 8) + var5.field731;
					int var14 = (var5.field732 * var11 >> 8) + var5.field727;
					int var15 = (var5.field740 * var11 >> 8) + var5.field733;
					if (arg2 >= var12 && arg2 <= var13 && arg1 >= var14 && arg1 <= var15) {
						return true;
					}
				}
			} else if (var5.field734 == 3) {
				int var16 = var5.field730 - arg2;
				if (var16 > 0) {
					int var17 = (var5.field728 * var16 >> 8) + var5.field739;
					int var18 = (var5.field736 * var16 >> 8) + var5.field723;
					int var19 = (var5.field732 * var16 >> 8) + var5.field727;
					int var20 = (var5.field740 * var16 >> 8) + var5.field733;
					if (arg0 >= var17 && arg0 <= var18 && arg1 >= var19 && arg1 <= var20) {
						return true;
					}
				}
			} else if (var5.field734 == 4) {
				int var21 = arg2 - var5.field730;
				if (var21 > 0) {
					int var22 = (var5.field728 * var21 >> 8) + var5.field739;
					int var23 = (var5.field736 * var21 >> 8) + var5.field723;
					int var24 = (var5.field732 * var21 >> 8) + var5.field727;
					int var25 = (var5.field740 * var21 >> 8) + var5.field733;
					if (arg0 >= var22 && arg0 <= var23 && arg1 >= var24 && arg1 <= var25) {
						return true;
					}
				}
			} else if (var5.field734 == 5) {
				int var26 = arg1 - var5.field727;
				if (var26 > 0) {
					int var27 = (var5.field728 * var26 >> 8) + var5.field739;
					int var28 = (var5.field736 * var26 >> 8) + var5.field723;
					int var29 = (var5.field729 * var26 >> 8) + var5.field730;
					int var30 = (var5.field738 * var26 >> 8) + var5.field731;
					if (arg0 >= var27 && arg0 <= var28 && arg2 >= var29 && arg2 <= var30) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
