package jagex3.graphics;

import deob.ObfuscatedName;
import jagex3.jstring.StringUtil;

import java.util.Random;

// jag::oldscape::jstring::PixfontGeneric
@ObfuscatedName("fs")
public abstract class PixFont extends Pix2D {

	@ObfuscatedName("fs.u")
	public byte[][] field2556 = new byte[256][];

	@ObfuscatedName("fs.v")
	public int[] field2554;

	@ObfuscatedName("fs.w")
	public int[] field2548;

	@ObfuscatedName("fs.e")
	public int[] field2551;

	@ObfuscatedName("fs.b")
	public int[] field2544;

	@ObfuscatedName("fs.y")
	public int[] field2549;

	@ObfuscatedName("fs.t")
	public int field2550 = 0;

	@ObfuscatedName("fs.f")
	public int field2552;

	@ObfuscatedName("fs.k")
	public int field2546;

	@ObfuscatedName("fs.o")
	public static Pix8[] modicons;

	@ObfuscatedName("fs.a")
	public byte[] field2547;

	@ObfuscatedName("fs.h")
	public static int field2555 = -1;

	@ObfuscatedName("fs.x")
	public static int field2559 = -1;

	@ObfuscatedName("fs.p")
	public static int field2557 = -1;

	@ObfuscatedName("fs.ad")
	public static int field2558 = -1;

	@ObfuscatedName("fs.ac")
	public static int field2545 = 0;

	@ObfuscatedName("fs.aa")
	public static int field2560 = 0;

	@ObfuscatedName("fs.as")
	public static int field2561 = 256;

	@ObfuscatedName("fs.am")
	public static int field2562 = 0;

	@ObfuscatedName("fs.ap")
	public static int field2563 = 0;

	@ObfuscatedName("fs.av")
	public static Random field2564 = new Random();

	@ObfuscatedName("fs.ak")
	public static String[] lines = new String[100];

	public PixFont(byte[] arg0, int[] arg1, int[] arg2, int[] arg3, int[] arg4, int[] arg5, byte[][] arg6) {
		this.field2544 = arg1;
		this.field2549 = arg2;
		this.field2548 = arg3;
		this.field2551 = arg4;
		this.method2859(arg0);
		this.field2556 = arg6;
		int var8 = Integer.MAX_VALUE;
		int var9 = Integer.MIN_VALUE;
		for (int var10 = 0; var10 < 256; var10++) {
			if (this.field2549[var10] < var8 && this.field2551[var10] != 0) {
				var8 = this.field2549[var10];
			}
			if (this.field2551[var10] + this.field2549[var10] > var9) {
				var9 = this.field2551[var10] + this.field2549[var10];
			}
		}
		this.field2552 = this.field2550 - var8;
		this.field2546 = var9 - this.field2550;
	}

	public PixFont(byte[] arg0) {
		this.method2859(arg0);
	}

	@ObfuscatedName("fs.bm([B)V")
	public void method2859(byte[] arg0) {
		this.field2554 = new int[256];
		if (arg0.length == 257) {
			for (int var2 = 0; var2 < this.field2554.length; var2++) {
				this.field2554[var2] = arg0[var2] & 0xFF;
			}
			this.field2550 = arg0[256] & 0xFF;
			return;
		}
		int var3 = 0;
		for (int var4 = 0; var4 < 256; var4++) {
			this.field2554[var4] = arg0[var3++] & 0xFF;
		}
		int[] var5 = new int[256];
		int[] var6 = new int[256];
		for (int var7 = 0; var7 < 256; var7++) {
			var5[var7] = arg0[var3++] & 0xFF;
		}
		for (int var8 = 0; var8 < 256; var8++) {
			var6[var8] = arg0[var3++] & 0xFF;
		}
		byte[][] var9 = new byte[256][];
		for (int var10 = 0; var10 < 256; var10++) {
			var9[var10] = new byte[var5[var10]];
			byte var11 = 0;
			for (int var12 = 0; var12 < var9[var10].length; var12++) {
				var11 += arg0[var3++];
				var9[var10][var12] = var11;
			}
		}
		byte[][] var13 = new byte[256][];
		for (int var14 = 0; var14 < 256; var14++) {
			var13[var14] = new byte[var5[var14]];
			byte var15 = 0;
			for (int var16 = 0; var16 < var13[var14].length; var16++) {
				var15 += arg0[var3++];
				var13[var14][var16] = var15;
			}
		}
		this.field2547 = new byte[65536];
		for (int var17 = 0; var17 < 256; var17++) {
			if (var17 != 32 && var17 != 160) {
				for (int var18 = 0; var18 < 256; var18++) {
					if (var18 != 32 && var18 != 160) {
						this.field2547[(var17 << 8) + var18] = (byte) method2835(var9, var13, var6, this.field2554, var5, var17, var18);
					}
				}
			}
		}
		this.field2550 = var5[32] + var6[32];
	}

	@ObfuscatedName("fs.bn([[B[[B[I[I[III)I")
	public static int method2835(byte[][] arg0, byte[][] arg1, int[] arg2, int[] arg3, int[] arg4, int arg5, int arg6) {
		int var7 = arg2[arg5];
		int var8 = arg4[arg5] + var7;
		int var9 = arg2[arg6];
		int var10 = arg4[arg6] + var9;
		int var11 = var7;
		if (var9 > var7) {
			var11 = var9;
		}
		int var12 = var8;
		if (var10 < var8) {
			var12 = var10;
		}
		int var13 = arg3[arg5];
		if (arg3[arg6] < var13) {
			var13 = arg3[arg6];
		}
		byte[] var14 = arg1[arg5];
		byte[] var15 = arg0[arg6];
		int var16 = var11 - var7;
		int var17 = var11 - var9;
		for (int var18 = var11; var18 < var12; var18++) {
			int var19 = var14[var16++] + var15[var17++];
			if (var19 < var13) {
				var13 = var19;
			}
		}
		return -var13;
	}

	@ObfuscatedName("fs.be(I)I")
	public int method2815(int arg0) {
		if (arg0 == 160) {
			arg0 = 32;
		}
		return this.field2554[arg0 & 0xFF];
	}

	@ObfuscatedName("fs.bp(Ljava/lang/String;)I")
	public int stringWid(String arg0) {
		if (arg0 == null) {
			return 0;
		}
		int var2 = -1;
		int var3 = -1;
		int var4 = 0;
		for (int var5 = 0; var5 < arg0.length(); var5++) {
			char var6 = arg0.charAt(var5);
			if (var6 == '<') {
				var2 = var5;
			} else {
				if (var6 == '>' && var2 != -1) {
					String var7 = arg0.substring(var2 + 1, var5);
					var2 = -1;
					if (var7.equals("lt")) {
						var6 = '<';
					} else {
						if (!var7.equals("gt")) {
							if (var7.startsWith("img=")) {
								try {
									String var8 = var7.substring(4);
									int var9 = StringUtil.method91(var8, 10, true);
									var4 += modicons[var9].owi;
									var3 = -1;
								} catch (Exception var12) {
								}
							}
							continue;
						}
						var6 = '>';
					}
				}
				if (var6 == 160) {
					var6 = ' ';
				}
				if (var2 == -1) {
					var4 += this.field2554[var6];
					if (this.field2547 != null && var3 != -1) {
						var4 += this.field2547[(var3 << 8) + var6];
					}
					var3 = var6;
				}
			}
		}
		return var4;
	}

	@ObfuscatedName("fs.ba(Ljava/lang/String;[I[Ljava/lang/String;)I")
	public int splitString(String arg0, int[] arg1, String[] arg2) {
		if (arg0 == null) {
			return 0;
		}
		int var4 = 0;
		int var5 = 0;
		StringBuilder var6 = new StringBuilder(100);
		int var7 = -1;
		int var8 = 0;
		byte var9 = 0;
		int var10 = -1;
		char var11 = 0;
		int var12 = 0;
		int var13 = arg0.length();
		for (int var14 = 0; var14 < var13; var14++) {
			char var15 = arg0.charAt(var14);
			if (var15 == '<') {
				var10 = var14;
			} else {
				if (var15 == '>' && var10 != -1) {
					String var16 = arg0.substring(var10 + 1, var14);
					var10 = -1;
					var6.append('<');
					var6.append(var16);
					var6.append('>');
					if (var16.equals("br")) {
						arg2[var12] = var6.toString().substring(var5, var6.length());
						var12++;
						var5 = var6.length();
						var4 = 0;
						var7 = -1;
						var11 = 0;
					} else if (var16.equals("lt")) {
						var4 += this.method2815(60);
						if (this.field2547 != null && var11 != -1) {
							var4 += this.field2547[(var11 << 8) + 60];
						}
						var11 = '<';
					} else if (var16.equals("gt")) {
						var4 += this.method2815(62);
						if (this.field2547 != null && var11 != -1) {
							var4 += this.field2547[(var11 << 8) + 62];
						}
						var11 = '>';
					} else if (var16.startsWith("img=")) {
						try {
							String var17 = var16.substring(4);
							int var18 = StringUtil.method91(var17, 10, true);
							var4 += modicons[var18].owi;
							var11 = 0;
						} catch (Exception var22) {
						}
					}
					var15 = 0;
				}
				if (var10 == -1) {
					if (var15 != -1) {
						var6.append(var15);
						var4 += this.method2815(var15);
						if (this.field2547 != null && var11 != -1) {
							var4 += this.field2547[(var11 << 8) + var15];
						}
						var11 = var15;
					}
					if (var15 == ' ') {
						var7 = var6.length();
						var8 = var4;
						var9 = 1;
					}
					if (arg1 != null && var4 > arg1[var12 < arg1.length ? var12 : arg1.length - 1] && var7 >= 0) {
						arg2[var12] = var6.toString().substring(var5, var7 - var9);
						var12++;
						var5 = var7;
						var7 = -1;
						var4 -= var8;
						var11 = 0;
					}
					if (var15 == '-') {
						var7 = var6.length();
						var8 = var4;
						var9 = 0;
					}
				}
			}
		}
		String var21 = var6.toString();
		if (var21.length() > var5) {
			arg2[var12++] = var21.substring(var5, var21.length());
		}
		return var12;
	}

	@ObfuscatedName("fs.bc(Ljava/lang/String;I)I")
	public int method2818(String arg0, int arg1) {
		int var3 = this.splitString(arg0, new int[] { arg1 }, lines);
		int var4 = 0;
		for (int var5 = 0; var5 < var3; var5++) {
			int var6 = this.stringWid(lines[var5]);
			if (var6 > var4) {
				var4 = var6;
			}
		}
		return var4;
	}

	@ObfuscatedName("fs.br(Ljava/lang/String;I)I")
	public int method2889(String arg0, int arg1) {
		return this.splitString(arg0, new int[] { arg1 }, lines);
	}

	@ObfuscatedName("fs.bb(Ljava/lang/String;)Ljava/lang/String;")
	public static String method2844(String arg0) {
		int var1 = arg0.length();
		int var2 = 0;
		for (int var3 = 0; var3 < var1; var3++) {
			char var4 = arg0.charAt(var3);
			if (var4 == '<' || var4 == '>') {
				var2 += 3;
			}
		}
		StringBuilder var5 = new StringBuilder(var1 + var2);
		for (int var6 = 0; var6 < var1; var6++) {
			char var7 = arg0.charAt(var6);
			if (var7 == '<') {
				var5.append("<lt>");
			} else if (var7 == '>') {
				var5.append("<gt>");
			} else {
				var5.append(var7);
			}
		}
		return var5.toString();
	}

	@ObfuscatedName("fs.bd(Ljava/lang/String;IIII)V")
	public void drawString(String arg0, int arg1, int arg2, int arg3, int arg4) {
		if (arg0 != null) {
			this.resetState(arg3, arg4);
			this.drawString(arg0, arg1, arg2);
		}
	}

	@ObfuscatedName("fs.cr(Ljava/lang/String;IIII)V")
	public void drawStringRight(String arg0, int arg1, int arg2, int arg3, int arg4) {
		if (arg0 != null) {
			this.resetState(arg3, arg4);
			this.drawString(arg0, arg1 - this.stringWid(arg0), arg2);
		}
	}

	@ObfuscatedName("fs.cs(Ljava/lang/String;IIII)V")
	public void centreString(String arg0, int arg1, int arg2, int arg3, int arg4) {
		if (arg0 != null) {
			this.resetState(arg3, arg4);
			this.drawString(arg0, arg1 - this.stringWid(arg0) / 2, arg2);
		}
	}

	// jag::oldscape::jstring::PixfontGeneric::DrawStringMultiline
	@ObfuscatedName("fs.cj(Ljava/lang/String;IIIIIIIII)I")
	public int drawStringMultiline(String arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
		if (arg0 == null) {
			return 0;
		}
		this.resetState(arg5, arg6);
		if (arg9 == 0) {
			arg9 = this.field2550;
		}
		int[] var11 = new int[] { arg3 };
		if (arg4 < this.field2552 + this.field2546 + arg9 && arg4 < arg9 + arg9) {
			var11 = null;
		}
		int var12 = this.splitString(arg0, var11, lines);
		if (arg8 == 3 && var12 == 1) {
			arg8 = 1;
		}
		int var13;
		if (arg8 == 0) {
			var13 = this.field2552 + arg2;
		} else if (arg8 == 1) {
			var13 = (arg4 - this.field2552 - this.field2546 - (var12 - 1) * arg9) / 2 + this.field2552 + arg2;
		} else if (arg8 == 2) {
			var13 = arg2 + arg4 - this.field2546 - (var12 - 1) * arg9;
		} else {
			int var14 = (arg4 - this.field2552 - this.field2546 - (var12 - 1) * arg9) / (var12 + 1);
			if (var14 < 0) {
				var14 = 0;
			}
			var13 = this.field2552 + arg2 + var14;
			arg9 += var14;
		}
		for (int var15 = 0; var15 < var12; var15++) {
			if (arg7 == 0) {
				this.drawString(lines[var15], arg1, var13);
			} else if (arg7 == 1) {
				this.drawString(lines[var15], arg1 + (arg3 - this.stringWid(lines[var15])) / 2, var13);
			} else if (arg7 == 2) {
				this.drawString(lines[var15], arg1 + arg3 - this.stringWid(lines[var15]), var13);
			} else if (var12 - 1 == var15) {
				this.drawString(lines[var15], arg1, var13);
			} else {
				this.method2831(lines[var15], arg3);
				this.drawString(lines[var15], arg1, var13);
				field2562 = 0;
			}
			var13 += arg9;
		}
		return var12;
	}

	@ObfuscatedName("fs.cl(Ljava/lang/String;IIIII)V")
	public void centerStringWave(String arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		if (arg0 == null) {
			return;
		}
		this.resetState(arg3, arg4);
		int[] var7 = new int[arg0.length()];
		for (int var8 = 0; var8 < arg0.length(); var8++) {
			var7[var8] = (int) (Math.sin((double) arg5 / 5.0D + (double) var8 / 2.0D) * 5.0D);
		}
		this.method2833(arg0, arg1 - this.stringWid(arg0) / 2, arg2, null, var7);
	}

	@ObfuscatedName("fs.cp(Ljava/lang/String;IIIII)V")
	public void method2826(String arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		if (arg0 == null) {
			return;
		}
		this.resetState(arg3, arg4);
		int[] var7 = new int[arg0.length()];
		int[] var8 = new int[arg0.length()];
		for (int var9 = 0; var9 < arg0.length(); var9++) {
			var7[var9] = (int) (Math.sin((double) arg5 / 5.0D + (double) var9 / 5.0D) * 5.0D);
			var8[var9] = (int) (Math.sin((double) arg5 / 5.0D + (double) var9 / 3.0D) * 5.0D);
		}
		this.method2833(arg0, arg1 - this.stringWid(arg0) / 2, arg2, var7, var8);
	}

	@ObfuscatedName("fs.ca(Ljava/lang/String;IIIIII)V")
	public void method2827(String arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		if (arg0 == null) {
			return;
		}
		this.resetState(arg3, arg4);
		double var8 = 7.0D - (double) arg6 / 8.0D;
		if (var8 < 0.0D) {
			var8 = 0.0D;
		}
		int[] var10 = new int[arg0.length()];
		for (int var11 = 0; var11 < arg0.length(); var11++) {
			var10[var11] = (int) (Math.sin((double) arg5 / 1.0D + (double) var11 / 1.5D) * var8);
		}
		this.method2833(arg0, arg1 - this.stringWid(arg0) / 2, arg2, null, var10);
	}

	@ObfuscatedName("fs.co(Ljava/lang/String;IIIII)V")
	public void method2828(String arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		if (arg0 == null) {
			return;
		}
		this.resetState(arg3, arg4);
		field2564.setSeed((long) arg5);
		field2561 = (field2564.nextInt() & 0x1F) + 192;
		int[] var7 = new int[arg0.length()];
		int var8 = 0;
		for (int var9 = 0; var9 < arg0.length(); var9++) {
			var7[var9] = var8;
			if ((field2564.nextInt() & 0x3) == 0) {
				var8++;
			}
		}
		this.method2833(arg0, arg1, arg2, var7, null);
	}

	// jag::oldscape::jstring::PixfontGeneric::ResetState
	@ObfuscatedName("fs.ch(II)V")
	public void resetState(int arg0, int arg1) {
		field2555 = -1;
		field2559 = -1;
		field2557 = arg1;
		field2558 = arg1;
		field2545 = arg0;
		field2560 = arg0;
		field2561 = 256;
		field2562 = 0;
		field2563 = 0;
	}

	@ObfuscatedName("fs.cu(Ljava/lang/String;)V")
	public void method2832(String arg0) {
		try {
			if (arg0.startsWith("col=")) {
				field2560 = StringUtil.method557(arg0.substring(4), 16);
			} else if (arg0.equals("/col")) {
				field2560 = field2545;
			} else if (arg0.startsWith("str=")) {
				field2555 = StringUtil.method557(arg0.substring(4), 16);
			} else if (arg0.equals("str")) {
				field2555 = 8388608;
			} else if (arg0.equals("/str")) {
				field2555 = -1;
			} else if (arg0.startsWith("u=")) {
				field2559 = StringUtil.method557(arg0.substring(2), 16);
			} else if (arg0.equals("u")) {
				field2559 = 0;
			} else if (arg0.equals("/u")) {
				field2559 = -1;
			} else if (arg0.startsWith("shad=")) {
				field2558 = StringUtil.method557(arg0.substring(5), 16);
			} else if (arg0.equals("shad")) {
				field2558 = 0;
			} else if (arg0.equals("/shad")) {
				field2558 = field2557;
			} else if (arg0.equals("br")) {
				this.resetState(field2545, field2557);
			}
		} catch (Exception var3) {
		}
	}

	@ObfuscatedName("fs.cc(Ljava/lang/String;I)V")
	public void method2831(String arg0, int arg1) {
		int var3 = 0;
		boolean var4 = false;
		for (int var5 = 0; var5 < arg0.length(); var5++) {
			char var6 = arg0.charAt(var5);
			if (var6 == '<') {
				var4 = true;
			} else if (var6 == '>') {
				var4 = false;
			} else if (!var4 && var6 == ' ') {
				var3++;
			}
		}
		if (var3 > 0) {
			field2562 = (arg1 - this.stringWid(arg0) << 8) / var3;
		}
	}

	@ObfuscatedName("fs.cm(Ljava/lang/String;II)V")
	public void drawString(String arg0, int arg1, int arg2) {
		int var4 = arg2 - this.field2550;
		int var5 = -1;
		int var6 = -1;
		for (int var7 = 0; var7 < arg0.length(); var7++) {
			char var8 = arg0.charAt(var7);
			if (var8 == '<') {
				var5 = var7;
			} else {
				if (var8 == '>' && var5 != -1) {
					String var9 = arg0.substring(var5 + 1, var7);
					var5 = -1;
					if (var9.equals("lt")) {
						var8 = '<';
					} else {
						if (!var9.equals("gt")) {
							if (var9.startsWith("img=")) {
								try {
									String var10 = var9.substring(4);
									int var11 = StringUtil.method91(var10, 10, true);
									Pix8 var13 = modicons[var11];
									var13.plotSprite(arg1, this.field2550 + var4 - var13.ohi);
									arg1 += var13.owi;
									var6 = -1;
								} catch (Exception var18) {
								}
							} else {
								this.method2832(var9);
							}
							continue;
						}
						var8 = '>';
					}
				}
				if (var8 == 160) {
					var8 = ' ';
				}
				if (var5 == -1) {
					if (this.field2547 != null && var6 != -1) {
						arg1 += this.field2547[(var6 << 8) + var8];
					}
					int var15 = this.field2548[var8];
					int var16 = this.field2551[var8];
					if (var8 == ' ') {
						if (field2562 > 0) {
							field2563 += field2562;
							arg1 += field2563 >> 8;
							field2563 &= 0xFF;
						}
					} else if (field2561 == 256) {
						if (field2558 != -1) {
							method2836(this.field2556[var8], this.field2544[var8] + arg1 + 1, this.field2549[var8] + var4 + 1, var15, var16, field2558);
						}
						this.method2823(this.field2556[var8], this.field2544[var8] + arg1, this.field2549[var8] + var4, var15, var16, field2560);
					} else {
						if (field2558 != -1) {
							method2838(this.field2556[var8], this.field2544[var8] + arg1 + 1, this.field2549[var8] + var4 + 1, var15, var16, field2558, field2561);
						}
						this.method2883(this.field2556[var8], this.field2544[var8] + arg1, this.field2549[var8] + var4, var15, var16, field2560, field2561);
					}
					int var17 = this.field2554[var8];
					if (field2555 != -1) {
						hline(arg1, (int) ((double) this.field2550 * 0.7D) + var4, var17, field2555);
					}
					if (field2559 != -1) {
						hline(arg1, this.field2550 + var4 + 1, var17, field2559);
					}
					arg1 += var17;
					var6 = var8;
				}
			}
		}
	}

	@ObfuscatedName("fs.cw(Ljava/lang/String;II[I[I)V")
	public void method2833(String arg0, int arg1, int arg2, int[] arg3, int[] arg4) {
		int var6 = arg2 - this.field2550;
		int var7 = -1;
		int var8 = -1;
		int var9 = 0;
		for (int var10 = 0; var10 < arg0.length(); var10++) {
			char var11 = arg0.charAt(var10);
			if (var11 == '<') {
				var7 = var10;
			} else {
				if (var11 == '>' && var7 != -1) {
					String var12 = arg0.substring(var7 + 1, var10);
					var7 = -1;
					if (var12.equals("lt")) {
						var11 = '<';
					} else {
						if (!var12.equals("gt")) {
							if (var12.startsWith("img=")) {
								try {
									int var13;
									if (arg3 == null) {
										var13 = 0;
									} else {
										var13 = arg3[var9];
									}
									int var14;
									if (arg4 == null) {
										var14 = 0;
									} else {
										var14 = arg4[var9];
									}
									var9++;
									String var15 = var12.substring(4);
									int var16 = StringUtil.method91(var15, 10, true);
									Pix8 var18 = modicons[var16];
									var18.plotSprite(arg1 + var13, this.field2550 + var6 - var18.ohi + var14);
									arg1 += var18.owi;
									var8 = -1;
								} catch (Exception var25) {
								}
							} else {
								this.method2832(var12);
							}
							continue;
						}
						var11 = '>';
					}
				}
				if (var11 == 160) {
					var11 = ' ';
				}
				if (var7 == -1) {
					if (this.field2547 != null && var8 != -1) {
						arg1 += this.field2547[(var8 << 8) + var11];
					}
					int var20 = this.field2548[var11];
					int var21 = this.field2551[var11];
					int var22;
					if (arg3 == null) {
						var22 = 0;
					} else {
						var22 = arg3[var9];
					}
					int var23;
					if (arg4 == null) {
						var23 = 0;
					} else {
						var23 = arg4[var9];
					}
					var9++;
					if (var11 == ' ') {
						if (field2562 > 0) {
							field2563 += field2562;
							arg1 += field2563 >> 8;
							field2563 &= 0xFF;
						}
					} else if (field2561 == 256) {
						if (field2558 != -1) {
							method2836(this.field2556[var11], this.field2544[var11] + arg1 + 1 + var22, this.field2549[var11] + var6 + 1 + var23, var20, var21, field2558);
						}
						this.method2823(this.field2556[var11], this.field2544[var11] + arg1 + var22, this.field2549[var11] + var6 + var23, var20, var21, field2560);
					} else {
						if (field2558 != -1) {
							method2838(this.field2556[var11], this.field2544[var11] + arg1 + 1 + var22, this.field2549[var11] + var6 + 1 + var23, var20, var21, field2558, field2561);
						}
						this.method2883(this.field2556[var11], this.field2544[var11] + arg1 + var22, this.field2549[var11] + var6 + var23, var20, var21, field2560, field2561);
					}
					int var24 = this.field2554[var11];
					if (field2555 != -1) {
						hline(arg1, (int) ((double) this.field2550 * 0.7D) + var6, var24, field2555);
					}
					if (field2559 != -1) {
						hline(arg1, this.field2550 + var6, var24, field2559);
					}
					arg1 += var24;
					var8 = var11;
				}
			}
		}
	}

	@ObfuscatedName("fs.ct([BIIIII)V")
	public static void method2836(byte[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		int var6 = Pix2D.width * arg2 + arg1;
		int var7 = Pix2D.width - arg3;
		int var8 = 0;
		int var9 = 0;
		if (arg2 < clipMinY) {
			int var10 = clipMinY - arg2;
			arg4 -= var10;
			arg2 = clipMinY;
			var9 += arg3 * var10;
			var6 += Pix2D.width * var10;
		}
		if (arg2 + arg4 > clipMaxY) {
			arg4 -= arg2 + arg4 - clipMaxY;
		}
		if (arg1 < clipMinX) {
			int var11 = clipMinX - arg1;
			arg3 -= var11;
			arg1 = clipMinX;
			var9 += var11;
			var6 += var11;
			var8 += var11;
			var7 += var11;
		}
		if (arg1 + arg3 > clipMaxX) {
			int var12 = arg1 + arg3 - clipMaxX;
			arg3 -= var12;
			var8 += var12;
			var7 += var12;
		}
		if (arg3 > 0 && arg4 > 0) {
			method2834(Pix2D.pixels, arg0, arg5, var9, var6, arg3, arg4, var7, var8);
		}
	}

	@ObfuscatedName("fs.ck([I[BIIIIIII)V")
	public static void method2834(int[] arg0, byte[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
		int var9 = -(arg5 >> 2);
		int var10 = -(arg5 & 0x3);
		for (int var11 = -arg6; var11 < 0; var11++) {
			for (int var12 = var9; var12 < 0; var12++) {
				if (arg1[arg3++] == 0) {
					arg4++;
				} else {
					arg0[arg4++] = arg2;
				}
				if (arg1[arg3++] == 0) {
					arg4++;
				} else {
					arg0[arg4++] = arg2;
				}
				if (arg1[arg3++] == 0) {
					arg4++;
				} else {
					arg0[arg4++] = arg2;
				}
				if (arg1[arg3++] == 0) {
					arg4++;
				} else {
					arg0[arg4++] = arg2;
				}
			}
			for (int var13 = var10; var13 < 0; var13++) {
				if (arg1[arg3++] == 0) {
					arg4++;
				} else {
					arg0[arg4++] = arg2;
				}
			}
			arg4 += arg7;
			arg3 += arg8;
		}
	}

	@ObfuscatedName("fs.cy([BIIIIII)V")
	public static void method2838(byte[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		int var7 = Pix2D.width * arg2 + arg1;
		int var8 = Pix2D.width - arg3;
		int var9 = 0;
		int var10 = 0;
		if (arg2 < clipMinY) {
			int var11 = clipMinY - arg2;
			arg4 -= var11;
			arg2 = clipMinY;
			var10 += arg3 * var11;
			var7 += Pix2D.width * var11;
		}
		if (arg2 + arg4 > clipMaxY) {
			arg4 -= arg2 + arg4 - clipMaxY;
		}
		if (arg1 < clipMinX) {
			int var12 = clipMinX - arg1;
			arg3 -= var12;
			arg1 = clipMinX;
			var10 += var12;
			var7 += var12;
			var9 += var12;
			var8 += var12;
		}
		if (arg1 + arg3 > clipMaxX) {
			int var13 = arg1 + arg3 - clipMaxX;
			arg3 -= var13;
			var9 += var13;
			var8 += var13;
		}
		if (arg3 > 0 && arg4 > 0) {
			method2839(Pix2D.pixels, arg0, arg5, var10, var7, arg3, arg4, var8, var9, arg6);
		}
	}

	@ObfuscatedName("fs.cq([I[BIIIIIIII)V")
	public static void method2839(int[] arg0, byte[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
		int var10 = ((arg2 & 0xFF00FF) * arg9 & 0xFF00FF00) + ((arg2 & 0xFF00) * arg9 & 0xFF0000) >> 8;
		int var11 = 256 - arg9;
		for (int var12 = -arg6; var12 < 0; var12++) {
			for (int var13 = -arg5; var13 < 0; var13++) {
				if (arg1[arg3++] == 0) {
					arg4++;
				} else {
					int var14 = arg0[arg4];
					arg0[arg4++] = (((var14 & 0xFF00FF) * var11 & 0xFF00FF00) + ((var14 & 0xFF00) * var11 & 0xFF0000) >> 8) + var10;
				}
			}
			arg4 += arg7;
			arg3 += arg8;
		}
	}

	@ObfuscatedName("fs.cz([BIIIII)V")
	public abstract void method2823(byte[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5);

	@ObfuscatedName("fs.cv([BIIIIII)V")
	public abstract void method2883(byte[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6);
}
