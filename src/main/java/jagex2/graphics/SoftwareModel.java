package jagex2.graphics;

import deob.ObfuscatedName;
import jagex2.dash3d.Entity;

@ObfuscatedName("fo")
public class SoftwareModel extends Entity {

	@ObfuscatedName("fo.j")
	public static SoftwareModel field2758 = new SoftwareModel();

	@ObfuscatedName("fo.z")
	public static byte[] field2770 = new byte[1];

	@ObfuscatedName("fo.g")
	public static SoftwareModel field2720 = new SoftwareModel();

	@ObfuscatedName("fo.q")
	public static byte[] field2725 = new byte[1];

	@ObfuscatedName("fo.i")
	public int field2722 = 0;

	@ObfuscatedName("fo.s")
	public int[] field2723;

	@ObfuscatedName("fo.u")
	public int[] field2724;

	@ObfuscatedName("fo.v")
	public int[] field2779;

	@ObfuscatedName("fo.w")
	public int field2780 = 0;

	@ObfuscatedName("fo.e")
	public int[] field2727;

	@ObfuscatedName("fo.b")
	public int[] field2726;

	@ObfuscatedName("fo.y")
	public int[] field2729;

	@ObfuscatedName("fo.t")
	public int[] field2778;

	@ObfuscatedName("fo.f")
	public int[] field2731;

	@ObfuscatedName("fo.k")
	public int[] field2732;

	@ObfuscatedName("fo.o")
	public byte[] field2733;

	@ObfuscatedName("fo.a")
	public byte[] field2728;

	@ObfuscatedName("fo.h")
	public byte[] field2735;

	@ObfuscatedName("fo.x")
	public short[] field2718;

	@ObfuscatedName("fo.p")
	public byte field2737 = 0;

	@ObfuscatedName("fo.ad")
	public int field2738 = 0;

	@ObfuscatedName("fo.ac")
	public int[] field2739;

	@ObfuscatedName("fo.aa")
	public int[] field2774;

	@ObfuscatedName("fo.as")
	public int[] field2765;

	@ObfuscatedName("fo.am")
	public int[][] field2742;

	@ObfuscatedName("fo.ap")
	public int[][] field2743;

	@ObfuscatedName("fo.av")
	public boolean picking = false;

	@ObfuscatedName("fo.ak")
	public int field2745;

	@ObfuscatedName("fo.az")
	public int field2746;

	@ObfuscatedName("fo.an")
	public int field2747;

	@ObfuscatedName("fo.ah")
	public int field2748;

	@ObfuscatedName("fo.ay")
	public int field2749;

	@ObfuscatedName("fo.ab")
	public static boolean[] field2751 = new boolean[4096];

	@ObfuscatedName("fo.ao")
	public static boolean[] field2752 = new boolean[4096];

	@ObfuscatedName("fo.ag")
	public static int[] field2753 = new int[4096];

	@ObfuscatedName("fo.ar")
	public static int[] field2754 = new int[4096];

	@ObfuscatedName("fo.aq")
	public static int[] field2755 = new int[4096];

	@ObfuscatedName("fo.at")
	public static int[] field2776 = new int[4096];

	@ObfuscatedName("fo.ae")
	public static int[] field2757 = new int[4096];

	@ObfuscatedName("fo.au")
	public static int[] field2777 = new int[4096];

	@ObfuscatedName("fo.ai")
	public static int[] field2760 = new int[1600];

	@ObfuscatedName("fo.aj")
	public static int[][] field2761 = new int[1600][512];

	@ObfuscatedName("fo.aw")
	public static int[] field2767 = new int[12];

	@ObfuscatedName("fo.af")
	public static int[][] field2763 = new int[12][2000];

	@ObfuscatedName("fo.bh")
	public static int[] field2764 = new int[2000];

	@ObfuscatedName("fo.bi")
	public static int[] field2756 = new int[2000];

	@ObfuscatedName("fo.bs")
	public static int[] field2766 = new int[12];

	@ObfuscatedName("fo.bk")
	public static int[] field2740 = new int[10];

	@ObfuscatedName("fo.bv")
	public static int[] field2736 = new int[10];

	@ObfuscatedName("fo.bg")
	public static int[] field2734 = new int[10];

	@ObfuscatedName("fo.bl")
	public static int baseX;

	@ObfuscatedName("fo.bt")
	public static int baseY;

	@ObfuscatedName("fo.bw")
	public static int baseZ;

	@ObfuscatedName("fo.by")
	public static boolean field2773 = false;

	@ObfuscatedName("fo.bx")
	public static int field2719 = 0;

	@ObfuscatedName("fo.bf")
	public static int field2775 = 0;

	@ObfuscatedName("fo.bu")
	public static int field2741 = 0;

	@ObfuscatedName("fo.bo")
	public static int[] field2730 = new int[1000];

	@ObfuscatedName("fo.bq")
	public static int[] field2768 = Pix3D.sinTable;

	@ObfuscatedName("fo.bj")
	public static int[] field2721 = Pix3D.cosTable;

	@ObfuscatedName("fo.bz")
	public static int[] field2769 = Pix3D.palette;

	@ObfuscatedName("fo.bm")
	public static int[] field2781 = Pix3D.divTable2;

	public SoftwareModel() {
	}

	public SoftwareModel(SoftwareModel[] arg0, int arg1) {
		boolean var3 = false;
		boolean var4 = false;
		boolean var5 = false;
		boolean var6 = false;
		this.field2722 = 0;
		this.field2780 = 0;
		this.field2738 = 0;
		this.field2737 = -1;
		for (int var7 = 0; var7 < arg1; var7++) {
			SoftwareModel var8 = arg0[var7];
			if (var8 != null) {
				this.field2722 += var8.field2722;
				this.field2780 += var8.field2780;
				this.field2738 += var8.field2738;
				if (var8.field2733 == null) {
					if (this.field2737 == -1) {
						this.field2737 = var8.field2737;
					}
					if (this.field2737 != var8.field2737) {
						var3 = true;
					}
				} else {
					var3 = true;
				}
				var4 |= var8.field2728 != null;
				var5 |= var8.field2718 != null;
				var6 |= var8.field2735 != null;
			}
		}
		this.field2723 = new int[this.field2722];
		this.field2724 = new int[this.field2722];
		this.field2779 = new int[this.field2722];
		this.field2727 = new int[this.field2780];
		this.field2726 = new int[this.field2780];
		this.field2729 = new int[this.field2780];
		this.field2778 = new int[this.field2780];
		this.field2731 = new int[this.field2780];
		this.field2732 = new int[this.field2780];
		if (var3) {
			this.field2733 = new byte[this.field2780];
		}
		if (var4) {
			this.field2728 = new byte[this.field2780];
		}
		if (var5) {
			this.field2718 = new short[this.field2780];
		}
		if (var6) {
			this.field2735 = new byte[this.field2780];
		}
		if (this.field2738 > 0) {
			this.field2739 = new int[this.field2738];
			this.field2774 = new int[this.field2738];
			this.field2765 = new int[this.field2738];
		}
		this.field2722 = 0;
		this.field2780 = 0;
		this.field2738 = 0;
		for (int var9 = 0; var9 < arg1; var9++) {
			SoftwareModel var10 = arg0[var9];
			if (var10 != null) {
				for (int var11 = 0; var11 < var10.field2780; var11++) {
					this.field2727[this.field2780] = var10.field2727[var11] + this.field2722;
					this.field2726[this.field2780] = var10.field2726[var11] + this.field2722;
					this.field2729[this.field2780] = var10.field2729[var11] + this.field2722;
					this.field2778[this.field2780] = var10.field2778[var11];
					this.field2731[this.field2780] = var10.field2731[var11];
					this.field2732[this.field2780] = var10.field2732[var11];
					if (var3) {
						if (var10.field2733 == null) {
							this.field2733[this.field2780] = var10.field2737;
						} else {
							this.field2733[this.field2780] = var10.field2733[var11];
						}
					}
					if (var4 && var10.field2728 != null) {
						this.field2728[this.field2780] = var10.field2728[var11];
					}
					if (var5) {
						if (var10.field2718 == null) {
							this.field2718[this.field2780] = -1;
						} else {
							this.field2718[this.field2780] = var10.field2718[var11];
						}
					}
					if (var6) {
						if (var10.field2735 == null || var10.field2735[var11] == -1) {
							this.field2735[this.field2780] = -1;
						} else {
							this.field2735[this.field2780] = (byte) (var10.field2735[var11] + this.field2738);
						}
					}
					this.field2780++;
				}
				for (int var12 = 0; var12 < var10.field2738; var12++) {
					this.field2739[this.field2738] = var10.field2739[var12] + this.field2722;
					this.field2774[this.field2738] = var10.field2774[var12] + this.field2722;
					this.field2765[this.field2738] = var10.field2765[var12] + this.field2722;
					this.field2738++;
				}
				for (int var13 = 0; var13 < var10.field2722; var13++) {
					this.field2723[this.field2722] = var10.field2723[var13];
					this.field2724[this.field2722] = var10.field2724[var13];
					this.field2779[this.field2722] = var10.field2779[var13];
					this.field2722++;
				}
			}
		}
	}

	@ObfuscatedName("fo.b([[IIIIZI)Lfo;")
	public SoftwareModel method3054(int[][] arg0, int arg1, int arg2, int arg3, boolean arg4, int arg5) {
		this.method3002();
		int var7 = arg1 - this.field2747;
		int var8 = this.field2747 + arg1;
		int var9 = arg3 - this.field2747;
		int var10 = this.field2747 + arg3;
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
		SoftwareModel var15;
		if (arg4) {
			var15 = new SoftwareModel();
			var15.field2722 = this.field2722;
			var15.field2780 = this.field2780;
			var15.field2738 = this.field2738;
			var15.field2723 = this.field2723;
			var15.field2779 = this.field2779;
			var15.field2727 = this.field2727;
			var15.field2726 = this.field2726;
			var15.field2729 = this.field2729;
			var15.field2778 = this.field2778;
			var15.field2731 = this.field2731;
			var15.field2732 = this.field2732;
			var15.field2733 = this.field2733;
			var15.field2728 = this.field2728;
			var15.field2735 = this.field2735;
			var15.field2718 = this.field2718;
			var15.field2737 = this.field2737;
			var15.field2739 = this.field2739;
			var15.field2774 = this.field2774;
			var15.field2765 = this.field2765;
			var15.field2742 = this.field2742;
			var15.field2743 = this.field2743;
			var15.picking = this.picking;
			var15.field2724 = new int[var15.field2722];
		} else {
			var15 = this;
		}
		if (arg5 == 0) {
			for (int var16 = 0; var16 < var15.field2722; var16++) {
				int var17 = this.field2723[var16] + arg1;
				int var18 = this.field2779[var16] + arg3;
				int var19 = var17 & 0x7F;
				int var20 = var18 & 0x7F;
				int var21 = var17 >> 7;
				int var22 = var18 >> 7;
				int var23 = (128 - var19) * arg0[var21][var22] + arg0[var21 + 1][var22] * var19 >> 7;
				int var24 = (128 - var19) * arg0[var21][var22 + 1] + arg0[var21 + 1][var22 + 1] * var19 >> 7;
				int var25 = (128 - var20) * var23 + var20 * var24 >> 7;
				var15.field2724[var16] = this.field2724[var16] + var25 - arg2;
			}
		} else {
			for (int var26 = 0; var26 < var15.field2722; var26++) {
				int var27 = (-this.field2724[var26] << 16) / this.minY;
				if (var27 < arg5) {
					int var28 = this.field2723[var26] + arg1;
					int var29 = this.field2779[var26] + arg3;
					int var30 = var28 & 0x7F;
					int var31 = var29 & 0x7F;
					int var32 = var28 >> 7;
					int var33 = var29 >> 7;
					int var34 = (128 - var30) * arg0[var32][var33] + arg0[var32 + 1][var33] * var30 >> 7;
					int var35 = (128 - var30) * arg0[var32][var33 + 1] + arg0[var32 + 1][var33 + 1] * var30 >> 7;
					int var36 = (128 - var31) * var34 + var31 * var35 >> 7;
					var15.field2724[var26] = (var36 - arg2) * (arg5 - var27) / arg5 + this.field2724[var26];
				}
			}
		}
		var15.field2745 = 0;
		return var15;
	}

	@ObfuscatedName("fo.y(Z)Lfo;")
	public SoftwareModel method2999(boolean arg0) {
		if (!arg0 && field2770.length < this.field2780) {
			field2770 = new byte[this.field2780 + 100];
		}
		return this.method3046(arg0, field2758, field2770);
	}

	@ObfuscatedName("fo.t(Z)Lfo;")
	public SoftwareModel method3040(boolean arg0) {
		if (!arg0 && field2725.length < this.field2780) {
			field2725 = new byte[this.field2780 + 100];
		}
		return this.method3046(arg0, field2720, field2725);
	}

	@ObfuscatedName("fo.f(ZLfo;[B)Lfo;")
	public SoftwareModel method3046(boolean arg0, SoftwareModel arg1, byte[] arg2) {
		arg1.field2722 = this.field2722;
		arg1.field2780 = this.field2780;
		arg1.field2738 = this.field2738;
		if (arg1.field2723 == null || arg1.field2723.length < this.field2722) {
			arg1.field2723 = new int[this.field2722 + 100];
			arg1.field2724 = new int[this.field2722 + 100];
			arg1.field2779 = new int[this.field2722 + 100];
		}
		for (int var4 = 0; var4 < this.field2722; var4++) {
			arg1.field2723[var4] = this.field2723[var4];
			arg1.field2724[var4] = this.field2724[var4];
			arg1.field2779[var4] = this.field2779[var4];
		}
		if (arg0) {
			arg1.field2728 = this.field2728;
		} else {
			arg1.field2728 = arg2;
			if (this.field2728 == null) {
				for (int var5 = 0; var5 < this.field2780; var5++) {
					arg1.field2728[var5] = 0;
				}
			} else {
				for (int var6 = 0; var6 < this.field2780; var6++) {
					arg1.field2728[var6] = this.field2728[var6];
				}
			}
		}
		arg1.field2727 = this.field2727;
		arg1.field2726 = this.field2726;
		arg1.field2729 = this.field2729;
		arg1.field2778 = this.field2778;
		arg1.field2731 = this.field2731;
		arg1.field2732 = this.field2732;
		arg1.field2733 = this.field2733;
		arg1.field2735 = this.field2735;
		arg1.field2718 = this.field2718;
		arg1.field2737 = this.field2737;
		arg1.field2739 = this.field2739;
		arg1.field2774 = this.field2774;
		arg1.field2765 = this.field2765;
		arg1.field2742 = this.field2742;
		arg1.field2743 = this.field2743;
		arg1.picking = this.picking;
		arg1.field2745 = 0;
		return arg1;
	}

	@ObfuscatedName("fo.k()V")
	public void method3002() {
		if (this.field2745 == 1) {
			return;
		}
		this.field2745 = 1;
		this.minY = 0;
		this.field2746 = 0;
		this.field2747 = 0;
		for (int var1 = 0; var1 < this.field2722; var1++) {
			int var2 = this.field2723[var1];
			int var3 = this.field2724[var1];
			int var4 = this.field2779[var1];
			if (-var3 > this.minY) {
				this.minY = -var3;
			}
			if (var3 > this.field2746) {
				this.field2746 = var3;
			}
			int var5 = var2 * var2 + var4 * var4;
			if (var5 > this.field2747) {
				this.field2747 = var5;
			}
		}
		this.field2747 = (int) (Math.sqrt((double) this.field2747) + 0.99D);
		this.field2749 = (int) (Math.sqrt((double) (this.minY * this.minY + this.field2747 * this.field2747)) + 0.99D);
		this.field2748 = this.field2749 + (int) (Math.sqrt((double) (this.field2747 * this.field2747 + this.field2746 * this.field2746)) + 0.99D);
	}

	@ObfuscatedName("fo.o()V")
	public void method3003() {
		if (this.field2745 == 2) {
			return;
		}
		this.field2745 = 2;
		this.field2747 = 0;
		for (int var1 = 0; var1 < this.field2722; var1++) {
			int var2 = this.field2723[var1];
			int var3 = this.field2724[var1];
			int var4 = this.field2779[var1];
			int var5 = var3 * var3 + var2 * var2 + var4 * var4;
			if (var5 > this.field2747) {
				this.field2747 = var5;
			}
		}
		this.field2747 = (int) (Math.sqrt((double) this.field2747) + 0.99D);
		this.field2749 = this.field2747;
		this.field2748 = this.field2747 + this.field2747;
	}

	@ObfuscatedName("fo.a()I")
	public int method3004() {
		this.method3002();
		return this.field2747;
	}

	@ObfuscatedName("fo.h(Lfr;I)V")
	public void method3005(AnimFrameset arg0, int arg1) {
		if (this.field2742 == null || arg1 == -1) {
			return;
		}
		AnimFrame var3 = arg0.field2488[arg1];
		AnimBase var4 = var3.base;
		baseX = 0;
		baseY = 0;
		baseZ = 0;
		for (int var5 = 0; var5 < var3.length; var5++) {
			int var6 = var3.groups[var5];
			this.method3007(var4.types[var6], var4.labels[var6], var3.x[var5], var3.y[var5], var3.z[var5]);
		}
		this.field2745 = 0;
	}

	@ObfuscatedName("fo.x(Lfr;ILfr;I[I)V")
	public void method3006(AnimFrameset arg0, int arg1, AnimFrameset arg2, int arg3, int[] arg4) {
		if (arg1 == -1) {
			return;
		}
		if (arg4 == null || arg3 == -1) {
			this.method3005(arg0, arg1);
			return;
		}
		AnimFrame var6 = arg0.field2488[arg1];
		AnimFrame var7 = arg2.field2488[arg3];
		AnimBase var8 = var6.base;
		baseX = 0;
		baseY = 0;
		baseZ = 0;
		byte var9 = 0;
		int var17 = var9 + 1;
		int var10 = arg4[var9];
		for (int var11 = 0; var11 < var6.length; var11++) {
			int var12 = var6.groups[var11];
			while (var12 > var10) {
				var10 = arg4[var17++];
			}
			if (var10 != var12 || var8.types[var12] == 0) {
				this.method3007(var8.types[var12], var8.labels[var12], var6.x[var11], var6.y[var11], var6.z[var11]);
			}
		}
		baseX = 0;
		baseY = 0;
		baseZ = 0;
		byte var13 = 0;
		int var18 = var13 + 1;
		int var14 = arg4[var13];
		for (int var15 = 0; var15 < var7.length; var15++) {
			int var16 = var7.groups[var15];
			while (var16 > var14) {
				var14 = arg4[var18++];
			}
			if (var14 == var16 || var8.types[var16] == 0) {
				this.method3007(var8.types[var16], var8.labels[var16], var7.x[var15], var7.y[var15], var7.z[var15]);
			}
		}
		this.field2745 = 0;
	}

	@ObfuscatedName("fo.p(I[IIII)V")
	public void method3007(int arg0, int[] arg1, int arg2, int arg3, int arg4) {
		int var6 = arg1.length;
		if (arg0 == 0) {
			int var7 = 0;
			baseX = 0;
			baseY = 0;
			baseZ = 0;
			for (int var8 = 0; var8 < var6; var8++) {
				int var9 = arg1[var8];
				if (var9 < this.field2742.length) {
					int[] var10 = this.field2742[var9];
					for (int var11 = 0; var11 < var10.length; var11++) {
						int var12 = var10[var11];
						baseX += this.field2723[var12];
						baseY += this.field2724[var12];
						baseZ += this.field2779[var12];
						var7++;
					}
				}
			}
			if (var7 > 0) {
				baseX = baseX / var7 + arg2;
				baseY = baseY / var7 + arg3;
				baseZ = baseZ / var7 + arg4;
			} else {
				baseX = arg2;
				baseY = arg3;
				baseZ = arg4;
			}
		} else if (arg0 == 1) {
			for (int var13 = 0; var13 < var6; var13++) {
				int var14 = arg1[var13];
				if (var14 < this.field2742.length) {
					int[] var15 = this.field2742[var14];
					for (int var16 = 0; var16 < var15.length; var16++) {
						int var17 = var15[var16];
						this.field2723[var17] += arg2;
						this.field2724[var17] += arg3;
						this.field2779[var17] += arg4;
					}
				}
			}
		} else if (arg0 == 2) {
			for (int var18 = 0; var18 < var6; var18++) {
				int var19 = arg1[var18];
				if (var19 < this.field2742.length) {
					int[] var20 = this.field2742[var19];
					for (int var21 = 0; var21 < var20.length; var21++) {
						int var22 = var20[var21];
						this.field2723[var22] -= baseX;
						this.field2724[var22] -= baseY;
						this.field2779[var22] -= baseZ;
						int var23 = (arg2 & 0xFF) * 8;
						int var24 = (arg3 & 0xFF) * 8;
						int var25 = (arg4 & 0xFF) * 8;
						if (var25 != 0) {
							int var26 = field2768[var25];
							int var27 = field2721[var25];
							int var28 = this.field2724[var22] * var26 + this.field2723[var22] * var27 >> 16;
							this.field2724[var22] = this.field2724[var22] * var27 - this.field2723[var22] * var26 >> 16;
							this.field2723[var22] = var28;
						}
						if (var23 != 0) {
							int var29 = field2768[var23];
							int var30 = field2721[var23];
							int var31 = this.field2724[var22] * var30 - this.field2779[var22] * var29 >> 16;
							this.field2779[var22] = this.field2779[var22] * var30 + this.field2724[var22] * var29 >> 16;
							this.field2724[var22] = var31;
						}
						if (var24 != 0) {
							int var32 = field2768[var24];
							int var33 = field2721[var24];
							int var34 = this.field2779[var22] * var32 + this.field2723[var22] * var33 >> 16;
							this.field2779[var22] = this.field2779[var22] * var33 - this.field2723[var22] * var32 >> 16;
							this.field2723[var22] = var34;
						}
						this.field2723[var22] += baseX;
						this.field2724[var22] += baseY;
						this.field2779[var22] += baseZ;
					}
				}
			}
		} else if (arg0 == 3) {
			for (int var35 = 0; var35 < var6; var35++) {
				int var36 = arg1[var35];
				if (var36 < this.field2742.length) {
					int[] var37 = this.field2742[var36];
					for (int var38 = 0; var38 < var37.length; var38++) {
						int var39 = var37[var38];
						this.field2723[var39] -= baseX;
						this.field2724[var39] -= baseY;
						this.field2779[var39] -= baseZ;
						this.field2723[var39] = this.field2723[var39] * arg2 / 128;
						this.field2724[var39] = this.field2724[var39] * arg3 / 128;
						this.field2779[var39] = this.field2779[var39] * arg4 / 128;
						this.field2723[var39] += baseX;
						this.field2724[var39] += baseY;
						this.field2779[var39] += baseZ;
					}
				}
			}
		} else if (arg0 == 5 && (this.field2743 != null && this.field2728 != null)) {
			for (int var40 = 0; var40 < var6; var40++) {
				int var41 = arg1[var40];
				if (var41 < this.field2743.length) {
					int[] var42 = this.field2743[var41];
					for (int var43 = 0; var43 < var42.length; var43++) {
						int var44 = var42[var43];
						int var45 = (this.field2728[var44] & 0xFF) + arg2 * 8;
						if (var45 < 0) {
							var45 = 0;
						} else if (var45 > 255) {
							var45 = 255;
						}
						this.field2728[var44] = (byte) var45;
					}
				}
			}
		}
	}

	@ObfuscatedName("fo.ad()V")
	public void method3008() {
		for (int var1 = 0; var1 < this.field2722; var1++) {
			int var2 = this.field2723[var1];
			this.field2723[var1] = this.field2779[var1];
			this.field2779[var1] = -var2;
		}
		this.field2745 = 0;
	}

	@ObfuscatedName("fo.ac()V")
	public void method3009() {
		for (int var1 = 0; var1 < this.field2722; var1++) {
			this.field2723[var1] = -this.field2723[var1];
			this.field2779[var1] = -this.field2779[var1];
		}
		this.field2745 = 0;
	}

	@ObfuscatedName("fo.aa()V")
	public void method3010() {
		for (int var1 = 0; var1 < this.field2722; var1++) {
			int var2 = this.field2779[var1];
			this.field2779[var1] = this.field2723[var1];
			this.field2723[var1] = -var2;
		}
		this.field2745 = 0;
	}

	@ObfuscatedName("fo.as(I)V")
	public void method3011(int arg0) {
		int var2 = field2768[arg0];
		int var3 = field2721[arg0];
		for (int var4 = 0; var4 < this.field2722; var4++) {
			int var5 = this.field2724[var4] * var3 - this.field2779[var4] * var2 >> 16;
			this.field2779[var4] = this.field2779[var4] * var3 + this.field2724[var4] * var2 >> 16;
			this.field2724[var4] = var5;
		}
		this.field2745 = 0;
	}

	@ObfuscatedName("fo.am(III)V")
	public void method3012(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < this.field2722; var4++) {
			this.field2723[var4] += arg0;
			this.field2724[var4] += arg1;
			this.field2779[var4] += arg2;
		}
		this.field2745 = 0;
	}

	@ObfuscatedName("fo.ap(III)V")
	public void scale(int arg0, int arg1, int arg2) {
		for (int var4 = 0; var4 < this.field2722; var4++) {
			this.field2723[var4] = this.field2723[var4] * arg0 / 128;
			this.field2724[var4] = this.field2724[var4] * arg1 / 128;
			this.field2779[var4] = this.field2779[var4] * arg2 / 128;
		}
		this.field2745 = 0;
	}

	@ObfuscatedName("fo.av(IIIIIII)V")
	public final void method3014(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		field2760[0] = -1;
		if (this.field2745 != 2 && this.field2745 != 1) {
			this.method3003();
		}
		int var8 = Pix3D.centerX;
		int var9 = Pix3D.centerY;
		int var10 = field2768[arg0];
		int var11 = field2721[arg0];
		int var12 = field2768[arg1];
		int var13 = field2721[arg1];
		int var14 = field2768[arg2];
		int var15 = field2721[arg2];
		int var16 = field2768[arg3];
		int var17 = field2721[arg3];
		int var18 = arg5 * var16 + arg6 * var17 >> 16;
		for (int var19 = 0; var19 < this.field2722; var19++) {
			int var20 = this.field2723[var19];
			int var21 = this.field2724[var19];
			int var22 = this.field2779[var19];
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
			field2755[var19] = var30 - var18;
			field2753[var19] = (var26 << 9) / var30 + var8;
			field2754[var19] = (var29 << 9) / var30 + var9;
			if (this.field2738 > 0) {
				field2776[var19] = var26;
				field2757[var19] = var29;
				field2777[var19] = var30;
			}
		}
		try {
			this.method3019(false, false, 0);
		} catch (Exception var33) {
		}
	}

	@ObfuscatedName("fo.ak(IIIIIIII)V")
	public final void method3020(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		field2760[0] = -1;
		if (this.field2745 != 2 && this.field2745 != 1) {
			this.method3003();
		}
		int var9 = Pix3D.centerX;
		int var10 = Pix3D.centerY;
		int var11 = field2768[arg0];
		int var12 = field2721[arg0];
		int var13 = field2768[arg1];
		int var14 = field2721[arg1];
		int var15 = field2768[arg2];
		int var16 = field2721[arg2];
		int var17 = field2768[arg3];
		int var18 = field2721[arg3];
		int var19 = arg5 * var17 + arg6 * var18 >> 16;
		for (int var20 = 0; var20 < this.field2722; var20++) {
			int var21 = this.field2723[var20];
			int var22 = this.field2724[var20];
			int var23 = this.field2779[var20];
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
			field2755[var20] = var31 - var19;
			field2753[var20] = (var27 << 9) / arg7 + var9;
			field2754[var20] = (var30 << 9) / arg7 + var10;
			if (this.field2738 > 0) {
				field2776[var20] = var27;
				field2757[var20] = var30;
				field2777[var20] = var31;
			}
		}
		try {
			this.method3019(false, false, 0);
		} catch (Exception var34) {
		}
	}

	@ObfuscatedName("fo.z(IIIIIIIII)V")
	public void draw(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
		field2760[0] = -1;
		if (this.field2745 != 1) {
			this.method3002();
		}
		int var10 = arg4 * arg7 - arg3 * arg5 >> 16;
		int var11 = arg1 * arg6 + arg2 * var10 >> 16;
		int var12 = this.field2747 * arg2 >> 16;
		int var13 = var11 + var12;
		if (var13 <= 50 || var11 >= 3500) {
			return;
		}
		int var14 = arg3 * arg7 + arg4 * arg5 >> 16;
		int var15 = var14 - this.field2747 << 9;
		if (var15 / var13 >= Pix3D.field2534) {
			return;
		}
		int var16 = this.field2747 + var14 << 9;
		if (var16 / var13 <= Pix3D.field2542) {
			return;
		}
		int var17 = arg2 * arg6 - arg1 * var10 >> 16;
		int var18 = this.field2747 * arg1 >> 16;
		int var19 = var17 + var18 << 9;
		if (var19 / var13 <= Pix3D.field2535) {
			return;
		}
		int var20 = (this.minY * arg2 >> 16) + var18;
		int var21 = var17 - var20 << 9;
		if (var21 / var13 >= Pix3D.field2537) {
			return;
		}
		int var22 = (this.minY * arg1 >> 16) + var12;
		boolean var23 = false;
		boolean var24 = false;
		if (var11 - var22 <= 50) {
			var24 = true;
		}
		boolean var25 = var24 || this.field2738 > 0;
		boolean var26 = false;
		if (arg8 > 0 && field2773) {
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
			int var32 = field2719 - Pix3D.centerX;
			int var33 = field2775 - Pix3D.centerY;
			if (var32 > var28 && var32 < var29 && var33 > var30 && var33 < var31) {
				if (this.picking) {
					field2730[field2741++] = arg8;
				} else {
					var26 = true;
				}
			}
		}
		int var34 = Pix3D.centerX;
		int var35 = Pix3D.centerY;
		int var36 = 0;
		int var37 = 0;
		if (arg0 != 0) {
			var36 = field2768[arg0];
			var37 = field2721[arg0];
		}
		for (int var38 = 0; var38 < this.field2722; var38++) {
			int var39 = this.field2723[var38];
			int var40 = this.field2724[var38];
			int var41 = this.field2779[var38];
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
			field2755[var38] = var50 - var11;
			if (var50 >= 50) {
				field2753[var38] = (var46 << 9) / var50 + var34;
				field2754[var38] = (var49 << 9) / var50 + var35;
			} else {
				field2753[var38] = -5000;
				var23 = true;
			}
			if (var25) {
				field2776[var38] = var46;
				field2757[var38] = var49;
				field2777[var38] = var50;
			}
		}
		try {
			this.method3019(var23, var26, arg8);
		} catch (Exception var53) {
		}
	}

	@ObfuscatedName("fo.az(ZZI)V")
	public final void method3019(boolean arg0, boolean arg1, int arg2) {
		if (this.field2748 >= 1600) {
			return;
		}
		for (int var4 = 0; var4 < this.field2748; var4++) {
			field2760[var4] = 0;
		}
		for (int var5 = 0; var5 < this.field2780; var5++) {
			if (this.field2732[var5] != -2) {
				int var6 = this.field2727[var5];
				int var7 = this.field2726[var5];
				int var8 = this.field2729[var5];
				int var9 = field2753[var6];
				int var10 = field2753[var7];
				int var11 = field2753[var8];
				if (arg0 && (var9 == -5000 || var10 == -5000 || var11 == -5000)) {
					int var12 = field2776[var6];
					int var13 = field2776[var7];
					int var14 = field2776[var8];
					int var15 = field2757[var6];
					int var16 = field2757[var7];
					int var17 = field2757[var8];
					int var18 = field2777[var6];
					int var19 = field2777[var7];
					int var20 = field2777[var8];
					int var21 = var12 - var13;
					int var22 = var14 - var13;
					int var23 = var15 - var16;
					int var24 = var17 - var16;
					int var25 = var18 - var19;
					int var26 = var20 - var19;
					int var27 = var23 * var26 - var24 * var25;
					int var28 = var22 * var25 - var21 * var26;
					int var29 = var21 * var24 - var22 * var23;
					if (var19 * var29 + var13 * var27 + var16 * var28 > 0) {
						field2752[var5] = true;
						int var30 = (field2755[var6] + field2755[var7] + field2755[var8]) / 3 + this.field2749;
						field2761[var30][field2760[var30]++] = var5;
					}
				} else {
					if (arg1 && this.method3018(field2719, field2775, field2754[var6], field2754[var7], field2754[var8], var9, var10, var11)) {
						field2730[field2741++] = arg2;
						arg1 = false;
					}
					if ((field2754[var8] - field2754[var7]) * (var9 - var10) - (field2754[var6] - field2754[var7]) * (var11 - var10) > 0) {
						field2752[var5] = false;
						if (var9 >= 0 && var10 >= 0 && var11 >= 0 && var9 <= Pix3D.boundX && var10 <= Pix3D.boundX && var11 <= Pix3D.boundX) {
							field2751[var5] = false;
						} else {
							field2751[var5] = true;
						}
						int var31 = (field2755[var6] + field2755[var7] + field2755[var8]) / 3 + this.field2749;
						field2761[var31][field2760[var31]++] = var5;
					}
				}
			}
		}
		if (this.field2733 == null) {
			for (int var32 = this.field2748 - 1; var32 >= 0; var32--) {
				int var33 = field2760[var32];
				if (var33 > 0) {
					int[] var34 = field2761[var32];
					for (int var35 = 0; var35 < var33; var35++) {
						this.method3016(var34[var35]);
					}
				}
			}
			return;
		}
		for (int var36 = 0; var36 < 12; var36++) {
			field2767[var36] = 0;
			field2766[var36] = 0;
		}
		for (int var37 = this.field2748 - 1; var37 >= 0; var37--) {
			int var38 = field2760[var37];
			if (var38 > 0) {
				int[] var39 = field2761[var37];
				for (int var40 = 0; var40 < var38; var40++) {
					int var41 = var39[var40];
					byte var42 = this.field2733[var41];
					int var43 = field2767[var42]++;
					field2763[var42][var43] = var41;
					if (var42 < 10) {
						field2766[var42] += var37;
					} else if (var42 == 10) {
						field2764[var43] = var37;
					} else {
						field2756[var43] = var37;
					}
				}
			}
		}
		int var44 = 0;
		if (field2767[1] > 0 || field2767[2] > 0) {
			var44 = (field2766[1] + field2766[2]) / (field2767[1] + field2767[2]);
		}
		int var45 = 0;
		if (field2767[3] > 0 || field2767[4] > 0) {
			var45 = (field2766[3] + field2766[4]) / (field2767[3] + field2767[4]);
		}
		int var46 = 0;
		if (field2767[6] > 0 || field2767[8] > 0) {
			var46 = (field2766[6] + field2766[8]) / (field2767[6] + field2767[8]);
		}
		int var47 = 0;
		int var48 = field2767[10];
		int[] var49 = field2763[10];
		int[] var50 = field2764;
		if (var47 == var48) {
			var47 = 0;
			var48 = field2767[11];
			var49 = field2763[11];
			var50 = field2756;
		}
		int var51;
		if (var47 < var48) {
			var51 = var50[var47];
		} else {
			var51 = -1000;
		}
		for (int var52 = 0; var52 < 10; var52++) {
			while (var52 == 0 && var51 > var44) {
				this.method3016(var49[var47++]);
				if (var47 == var48 && field2763[11] != var49) {
					var47 = 0;
					var48 = field2767[11];
					var49 = field2763[11];
					var50 = field2756;
				}
				if (var47 < var48) {
					var51 = var50[var47];
				} else {
					var51 = -1000;
				}
			}
			while (var52 == 3 && var51 > var45) {
				this.method3016(var49[var47++]);
				if (var47 == var48 && field2763[11] != var49) {
					var47 = 0;
					var48 = field2767[11];
					var49 = field2763[11];
					var50 = field2756;
				}
				if (var47 < var48) {
					var51 = var50[var47];
				} else {
					var51 = -1000;
				}
			}
			while (var52 == 5 && var51 > var46) {
				this.method3016(var49[var47++]);
				if (var47 == var48 && field2763[11] != var49) {
					var47 = 0;
					var48 = field2767[11];
					var49 = field2763[11];
					var50 = field2756;
				}
				if (var47 < var48) {
					var51 = var50[var47];
				} else {
					var51 = -1000;
				}
			}
			int var53 = field2767[var52];
			int[] var54 = field2763[var52];
			for (int var55 = 0; var55 < var53; var55++) {
				this.method3016(var54[var55]);
			}
		}
		while (var51 != -1000) {
			this.method3016(var49[var47++]);
			if (var47 == var48 && field2763[11] != var49) {
				var47 = 0;
				var49 = field2763[11];
				var48 = field2767[11];
				var50 = field2756;
			}
			if (var47 < var48) {
				var51 = var50[var47];
			} else {
				var51 = -1000;
			}
		}
	}

	@ObfuscatedName("fo.an(I)V")
	public final void method3016(int arg0) {
		if (field2752[arg0]) {
			this.method3059(arg0);
			return;
		}
		int var2 = this.field2727[arg0];
		int var3 = this.field2726[arg0];
		int var4 = this.field2729[arg0];
		Pix3D.clipX = field2751[arg0];
		if (this.field2728 == null) {
			Pix3D.alpha = 0;
		} else {
			Pix3D.alpha = this.field2728[arg0] & 0xFF;
		}
		if (this.field2718 != null && this.field2718[arg0] != -1) {
			int var6;
			int var7;
			int var8;
			if (this.field2735 == null || this.field2735[arg0] == -1) {
				var6 = var2;
				var7 = var3;
				var8 = var4;
			} else {
				int var5 = this.field2735[arg0] & 0xFF;
				var6 = this.field2739[var5];
				var7 = this.field2774[var5];
				var8 = this.field2765[var5];
			}
			if (this.field2732[arg0] == -1) {
				Pix3D.method2769(field2754[var2], field2754[var3], field2754[var4], field2753[var2], field2753[var3], field2753[var4], this.field2778[arg0], this.field2778[arg0], this.field2778[arg0], field2776[var6], field2776[var7], field2776[var8], field2757[var6], field2757[var7], field2757[var8], field2777[var6], field2777[var7], field2777[var8], this.field2718[arg0]);
			} else {
				Pix3D.method2769(field2754[var2], field2754[var3], field2754[var4], field2753[var2], field2753[var3], field2753[var4], this.field2778[arg0], this.field2731[arg0], this.field2732[arg0], field2776[var6], field2776[var7], field2776[var8], field2757[var6], field2757[var7], field2757[var8], field2777[var6], field2777[var7], field2777[var8], this.field2718[arg0]);
			}
		} else if (this.field2732[arg0] == -1) {
			Pix3D.method2767(field2754[var2], field2754[var3], field2754[var4], field2753[var2], field2753[var3], field2753[var4], field2769[this.field2778[arg0]]);
		} else {
			Pix3D.fillGouraudTriangle(field2754[var2], field2754[var3], field2754[var4], field2753[var2], field2753[var3], field2753[var4], this.field2778[arg0], this.field2731[arg0], this.field2732[arg0]);
		}
	}

	@ObfuscatedName("fo.ah(I)V")
	public final void method3059(int arg0) {
		int var2 = Pix3D.centerX;
		int var3 = Pix3D.centerY;
		int var4 = 0;
		int var5 = this.field2727[arg0];
		int var6 = this.field2726[arg0];
		int var7 = this.field2729[arg0];
		int var8 = field2777[var5];
		int var9 = field2777[var6];
		int var10 = field2777[var7];
		if (this.field2728 == null) {
			Pix3D.alpha = 0;
		} else {
			Pix3D.alpha = this.field2728[arg0] & 0xFF;
		}
		if (var8 >= 50) {
			field2740[var4] = field2753[var5];
			field2736[var4] = field2754[var5];
			field2734[var4++] = this.field2778[arg0];
		} else {
			int var11 = field2776[var5];
			int var12 = field2757[var5];
			int var13 = this.field2778[arg0];
			if (var10 >= 50) {
				int var14 = (50 - var8) * field2781[var10 - var8];
				field2740[var4] = (((field2776[var7] - var11) * var14 >> 16) + var11 << 9) / 50 + var2;
				field2736[var4] = (((field2757[var7] - var12) * var14 >> 16) + var12 << 9) / 50 + var3;
				field2734[var4++] = ((this.field2732[arg0] - var13) * var14 >> 16) + var13;
			}
			if (var9 >= 50) {
				int var15 = (50 - var8) * field2781[var9 - var8];
				field2740[var4] = (((field2776[var6] - var11) * var15 >> 16) + var11 << 9) / 50 + var2;
				field2736[var4] = (((field2757[var6] - var12) * var15 >> 16) + var12 << 9) / 50 + var3;
				field2734[var4++] = ((this.field2731[arg0] - var13) * var15 >> 16) + var13;
			}
		}
		if (var9 >= 50) {
			field2740[var4] = field2753[var6];
			field2736[var4] = field2754[var6];
			field2734[var4++] = this.field2731[arg0];
		} else {
			int var16 = field2776[var6];
			int var17 = field2757[var6];
			int var18 = this.field2731[arg0];
			if (var8 >= 50) {
				int var19 = (50 - var9) * field2781[var8 - var9];
				field2740[var4] = (((field2776[var5] - var16) * var19 >> 16) + var16 << 9) / 50 + var2;
				field2736[var4] = (((field2757[var5] - var17) * var19 >> 16) + var17 << 9) / 50 + var3;
				field2734[var4++] = ((this.field2778[arg0] - var18) * var19 >> 16) + var18;
			}
			if (var10 >= 50) {
				int var20 = (50 - var9) * field2781[var10 - var9];
				field2740[var4] = (((field2776[var7] - var16) * var20 >> 16) + var16 << 9) / 50 + var2;
				field2736[var4] = (((field2757[var7] - var17) * var20 >> 16) + var17 << 9) / 50 + var3;
				field2734[var4++] = ((this.field2732[arg0] - var18) * var20 >> 16) + var18;
			}
		}
		if (var10 >= 50) {
			field2740[var4] = field2753[var7];
			field2736[var4] = field2754[var7];
			field2734[var4++] = this.field2732[arg0];
		} else {
			int var21 = field2776[var7];
			int var22 = field2757[var7];
			int var23 = this.field2732[arg0];
			if (var9 >= 50) {
				int var24 = (50 - var10) * field2781[var9 - var10];
				field2740[var4] = (((field2776[var6] - var21) * var24 >> 16) + var21 << 9) / 50 + var2;
				field2736[var4] = (((field2757[var6] - var22) * var24 >> 16) + var22 << 9) / 50 + var3;
				field2734[var4++] = ((this.field2731[arg0] - var23) * var24 >> 16) + var23;
			}
			if (var8 >= 50) {
				int var25 = (50 - var10) * field2781[var8 - var10];
				field2740[var4] = (((field2776[var5] - var21) * var25 >> 16) + var21 << 9) / 50 + var2;
				field2736[var4] = (((field2757[var5] - var22) * var25 >> 16) + var22 << 9) / 50 + var3;
				field2734[var4++] = ((this.field2778[arg0] - var23) * var25 >> 16) + var23;
			}
		}
		int var26 = field2740[0];
		int var27 = field2740[1];
		int var28 = field2740[2];
		int var29 = field2736[0];
		int var30 = field2736[1];
		int var31 = field2736[2];
		Pix3D.clipX = false;
		if (var4 == 3) {
			if (var26 < 0 || var27 < 0 || var28 < 0 || var26 > Pix3D.boundX || var27 > Pix3D.boundX || var28 > Pix3D.boundX) {
				Pix3D.clipX = true;
			}
			if (this.field2718 != null && this.field2718[arg0] != -1) {
				int var33;
				int var34;
				int var35;
				if (this.field2735 == null || this.field2735[arg0] == -1) {
					var33 = var5;
					var34 = var6;
					var35 = var7;
				} else {
					int var32 = this.field2735[arg0] & 0xFF;
					var33 = this.field2739[var32];
					var34 = this.field2774[var32];
					var35 = this.field2765[var32];
				}
				if (this.field2732[arg0] == -1) {
					Pix3D.method2769(var29, var30, var31, var26, var27, var28, this.field2778[arg0], this.field2778[arg0], this.field2778[arg0], field2776[var33], field2776[var34], field2776[var35], field2757[var33], field2757[var34], field2757[var35], field2777[var33], field2777[var34], field2777[var35], this.field2718[arg0]);
				} else {
					Pix3D.method2769(var29, var30, var31, var26, var27, var28, field2734[0], field2734[1], field2734[2], field2776[var33], field2776[var34], field2776[var35], field2757[var33], field2757[var34], field2757[var35], field2777[var33], field2777[var34], field2777[var35], this.field2718[arg0]);
				}
			} else if (this.field2732[arg0] == -1) {
				Pix3D.method2767(var29, var30, var31, var26, var27, var28, field2769[this.field2778[arg0]]);
			} else {
				Pix3D.fillGouraudTriangle(var29, var30, var31, var26, var27, var28, field2734[0], field2734[1], field2734[2]);
			}
		}
		if (var4 != 4) {
			return;
		}
		if (var26 < 0 || var27 < 0 || var28 < 0 || var26 > Pix3D.boundX || var27 > Pix3D.boundX || var28 > Pix3D.boundX || field2740[3] < 0 || field2740[3] > Pix3D.boundX) {
			Pix3D.clipX = true;
		}
		if (this.field2718 != null && this.field2718[arg0] != -1) {
			int var37;
			int var38;
			int var39;
			if (this.field2735 == null || this.field2735[arg0] == -1) {
				var37 = var5;
				var38 = var6;
				var39 = var7;
			} else {
				int var36 = this.field2735[arg0] & 0xFF;
				var37 = this.field2739[var36];
				var38 = this.field2774[var36];
				var39 = this.field2765[var36];
			}
			short var40 = this.field2718[arg0];
			if (this.field2732[arg0] == -1) {
				Pix3D.method2769(var29, var30, var31, var26, var27, var28, this.field2778[arg0], this.field2778[arg0], this.field2778[arg0], field2776[var37], field2776[var38], field2776[var39], field2757[var37], field2757[var38], field2757[var39], field2777[var37], field2777[var38], field2777[var39], var40);
				Pix3D.method2769(var29, var31, field2736[3], var26, var28, field2740[3], this.field2778[arg0], this.field2778[arg0], this.field2778[arg0], field2776[var37], field2776[var38], field2776[var39], field2757[var37], field2757[var38], field2757[var39], field2777[var37], field2777[var38], field2777[var39], var40);
			} else {
				Pix3D.method2769(var29, var30, var31, var26, var27, var28, field2734[0], field2734[1], field2734[2], field2776[var37], field2776[var38], field2776[var39], field2757[var37], field2757[var38], field2757[var39], field2777[var37], field2777[var38], field2777[var39], var40);
				Pix3D.method2769(var29, var31, field2736[3], var26, var28, field2740[3], field2734[0], field2734[2], field2734[3], field2776[var37], field2776[var38], field2776[var39], field2757[var37], field2757[var38], field2757[var39], field2777[var37], field2777[var38], field2777[var39], var40);
			}
		} else if (this.field2732[arg0] == -1) {
			int var41 = field2769[this.field2778[arg0]];
			Pix3D.method2767(var29, var30, var31, var26, var27, var28, var41);
			Pix3D.method2767(var29, var31, field2736[3], var26, var28, field2740[3], var41);
		} else {
			Pix3D.fillGouraudTriangle(var29, var30, var31, var26, var27, var28, field2734[0], field2734[1], field2734[2]);
			Pix3D.fillGouraudTriangle(var29, var31, field2736[3], var26, var28, field2740[3], field2734[0], field2734[2], field2734[3]);
		}
	}

	@ObfuscatedName("fo.ay(IIIIIIII)Z")
	public final boolean method3018(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		if (arg1 < arg2 && arg1 < arg3 && arg1 < arg4) {
			return false;
		} else if (arg1 > arg2 && arg1 > arg3 && arg1 > arg4) {
			return false;
		} else if (arg0 < arg5 && arg0 < arg6 && arg0 < arg7) {
			return false;
		} else {
			return arg0 <= arg5 || arg0 <= arg6 || arg0 <= arg7;
		}
	}
}
