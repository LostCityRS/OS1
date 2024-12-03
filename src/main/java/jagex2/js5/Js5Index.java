package jagex2.js5;

import deob.ObfuscatedName;
import jagex2.client.JagException;
import jagex2.datastruct.ByteArrayCopier;
import jagex2.datastruct.IntHashTable;
import jagex2.datastruct.JStringUtil;
import jagex2.io.BZip2;
import jagex2.io.GZip;
import jagex2.io.Packet;

@ObfuscatedName("ch")
public abstract class Js5Index {

	@ObfuscatedName("ch.r")
	public int field1181;

	@ObfuscatedName("ch.d")
	public int[] field1165;

	@ObfuscatedName("ch.l")
	public int[] field1167;

	@ObfuscatedName("ch.m")
	public IntHashTable field1168;

	@ObfuscatedName("ch.c")
	public int[] field1169;

	@ObfuscatedName("ch.n")
	public int[] field1179;

	@ObfuscatedName("ch.j")
	public int[] field1171;

	@ObfuscatedName("ch.z")
	public int[][] field1172;

	@ObfuscatedName("ch.g")
	public int[][] field1173;

	@ObfuscatedName("ch.q")
	public IntHashTable[] field1174;

	@ObfuscatedName("ch.i")
	public Object[] field1178;

	@ObfuscatedName("ch.s")
	public Object[][] field1170;

	@ObfuscatedName("ch.u")
	public static GZip field1177 = new GZip();

	@ObfuscatedName("ch.v")
	public int field1175;

	@ObfuscatedName("ch.w")
	public boolean field1166;

	@ObfuscatedName("ch.e")
	public boolean field1180;

	@ObfuscatedName("ch.b")
	public static int field1176 = 0;

	public Js5Index(boolean arg0, boolean arg1) {
		this.field1166 = arg0;
		this.field1180 = arg1;
	}

	@ObfuscatedName("ch.r([BI)V")
	public void method1042(byte[] arg0) {
		int var2 = arg0.length;
		int var3 = -1;
		for (int var4 = 0; var4 < var2; var4++) {
			var3 = var3 >>> 8 ^ Packet.crctable[(var3 ^ arg0[var4]) & 0xFF];
		}
		int var5 = ~var3;
		this.field1175 = var5;
		Packet var8 = new Packet(method52(arg0));
		int var9 = var8.g1();
		if (var9 < 5 || var9 > 7) {
			throw new RuntimeException("");
		}
		if (var9 >= 6) {
			var8.g4();
		}
		int var10 = var8.g1();
		if (var9 >= 7) {
			this.field1181 = var8.gSmart2or4();
		} else {
			this.field1181 = var8.g2();
		}
		int var11 = 0;
		int var12 = -1;
		this.field1165 = new int[this.field1181];
		if (var9 >= 7) {
			for (int var13 = 0; var13 < this.field1181; var13++) {
				this.field1165[var13] = var11 += var8.gSmart2or4();
				if (this.field1165[var13] > var12) {
					var12 = this.field1165[var13];
				}
			}
		} else {
			for (int var14 = 0; var14 < this.field1181; var14++) {
				this.field1165[var14] = var11 += var8.g2();
				if (this.field1165[var14] > var12) {
					var12 = this.field1165[var14];
				}
			}
		}
		this.field1169 = new int[var12 + 1];
		this.field1179 = new int[var12 + 1];
		this.field1171 = new int[var12 + 1];
		this.field1172 = new int[var12 + 1][];
		this.field1178 = new Object[var12 + 1];
		this.field1170 = new Object[var12 + 1][];
		if (var10 != 0) {
			this.field1167 = new int[var12 + 1];
			for (int var15 = 0; var15 < this.field1181; var15++) {
				this.field1167[this.field1165[var15]] = var8.g4();
			}
			this.field1168 = new IntHashTable(this.field1167);
		}
		for (int var16 = 0; var16 < this.field1181; var16++) {
			this.field1169[this.field1165[var16]] = var8.g4();
		}
		for (int var17 = 0; var17 < this.field1181; var17++) {
			this.field1179[this.field1165[var17]] = var8.g4();
		}
		for (int var18 = 0; var18 < this.field1181; var18++) {
			this.field1171[this.field1165[var18]] = var8.g2();
		}
		if (var9 >= 7) {
			for (int var19 = 0; var19 < this.field1181; var19++) {
				int var20 = this.field1165[var19];
				int var21 = this.field1171[var20];
				int var22 = 0;
				int var23 = -1;
				this.field1172[var20] = new int[var21];
				for (int var24 = 0; var24 < var21; var24++) {
					int var25 = this.field1172[var20][var24] = var22 += var8.gSmart2or4();
					if (var25 > var23) {
						var23 = var25;
					}
				}
				this.field1170[var20] = new Object[var23 + 1];
			}
		} else {
			for (int var26 = 0; var26 < this.field1181; var26++) {
				int var27 = this.field1165[var26];
				int var28 = this.field1171[var27];
				int var29 = 0;
				int var30 = -1;
				this.field1172[var27] = new int[var28];
				for (int var31 = 0; var31 < var28; var31++) {
					int var32 = this.field1172[var27][var31] = var29 += var8.g2();
					if (var32 > var30) {
						var30 = var32;
					}
				}
				this.field1170[var27] = new Object[var30 + 1];
			}
		}
		if (var10 == 0) {
			return;
		}
		this.field1173 = new int[var12 + 1][];
		this.field1174 = new IntHashTable[var12 + 1];
		for (int var33 = 0; var33 < this.field1181; var33++) {
			int var34 = this.field1165[var33];
			int var35 = this.field1171[var34];
			this.field1173[var34] = new int[this.field1170[var34].length];
			for (int var36 = 0; var36 < var35; var36++) {
				this.field1173[var34][this.field1172[var34][var36]] = var8.g4();
			}
			this.field1174[var34] = new IntHashTable(this.field1173[var34]);
		}
	}

	@ObfuscatedName("ch.d(IB)V")
	public void method1043(int arg0) {
	}

	@ObfuscatedName("ch.l(III)[B")
	public byte[] method1044(int arg0, int arg1) {
		return this.method1079(arg0, arg1, null);
	}

	@ObfuscatedName("ch.m(II[IS)[B")
	public byte[] method1079(int arg0, int arg1, int[] arg2) {
		if (arg0 < 0 || arg0 >= this.field1170.length || this.field1170[arg0] == null || arg1 < 0 || arg1 >= this.field1170[arg0].length) {
			return null;
		}
		if (this.field1170[arg0][arg1] == null) {
			boolean var4 = this.method1058(arg0, arg2);
			if (!var4) {
				this.method1052(arg0);
				boolean var5 = this.method1058(arg0, arg2);
				if (!var5) {
					return null;
				}
			}
		}
		byte[] var6 = ByteArrayCopier.method108(this.field1170[arg0][arg1], false);
		if (this.field1180) {
			this.field1170[arg0][arg1] = null;
		}
		return var6;
	}

	@ObfuscatedName("ch.c(III)Z")
	public boolean method1046(int arg0, int arg1) {
		if (arg0 < 0 || arg0 >= this.field1170.length || this.field1170[arg0] == null || arg1 < 0 || arg1 >= this.field1170[arg0].length) {
			return false;
		} else if (this.field1170[arg0][arg1] != null) {
			return true;
		} else if (this.field1178[arg0] == null) {
			this.method1052(arg0);
			return this.field1178[arg0] != null;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ch.n(II)Z")
	public boolean method1093(int arg0) {
		if (this.field1178[arg0] == null) {
			this.method1052(arg0);
			return this.field1178[arg0] != null;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ch.j(B)Z")
	public boolean method1048() {
		boolean var1 = true;
		for (int var2 = 0; var2 < this.field1165.length; var2++) {
			int var3 = this.field1165[var2];
			if (this.field1178[var3] == null) {
				this.method1052(var3);
				if (this.field1178[var3] == null) {
					var1 = false;
				}
			}
		}
		return var1;
	}

	@ObfuscatedName("ch.z(II)[B")
	public byte[] method1092(int arg0) {
		if (this.field1170.length == 1) {
			return this.method1044(0, arg0);
		} else if (this.field1170[arg0].length == 1) {
			return this.method1044(arg0, 0);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("ch.g(III)[B")
	public byte[] method1050(int arg0, int arg1) {
		if (arg0 < 0 || arg0 >= this.field1170.length || this.field1170[arg0] == null || arg1 < 0 || arg1 >= this.field1170[arg0].length) {
			return null;
		}
		if (this.field1170[arg0][arg1] == null) {
			boolean var3 = this.method1058(arg0, null);
			if (!var3) {
				this.method1052(arg0);
				boolean var4 = this.method1058(arg0, null);
				if (!var4) {
					return null;
				}
			}
		}
		return ByteArrayCopier.method108(this.field1170[arg0][arg1], false);
	}

	@ObfuscatedName("ch.q(II)[B")
	public byte[] method1051(int arg0) {
		if (this.field1170.length == 1) {
			return this.method1050(0, arg0);
		} else if (this.field1170[arg0].length == 1) {
			return this.method1050(arg0, 0);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("ch.i(IB)V")
	public void method1052(int arg0) {
	}

	@ObfuscatedName("ch.s(II)[I")
	public int[] method1053(int arg0) {
		return this.field1172[arg0];
	}

	@ObfuscatedName("ch.u(IS)I")
	public int method1054(int arg0) {
		return this.field1170[arg0].length;
	}

	@ObfuscatedName("ch.v(I)I")
	public int method1055() {
		return this.field1170.length;
	}

	@ObfuscatedName("ch.w(II)V")
	public void method1086(int arg0) {
		for (int var2 = 0; var2 < this.field1170[arg0].length; var2++) {
			this.field1170[arg0][var2] = null;
		}
	}

	@ObfuscatedName("ch.e(I)V")
	public void method1057() {
		for (int var1 = 0; var1 < this.field1170.length; var1++) {
			if (this.field1170[var1] != null) {
				for (int var2 = 0; var2 < this.field1170[var1].length; var2++) {
					this.field1170[var1][var2] = null;
				}
			}
		}
	}

	@ObfuscatedName("ch.b(I[II)Z")
	public boolean method1058(int arg0, int[] arg1) {
		if (this.field1178[arg0] == null) {
			return false;
		}
		int var3 = this.field1171[arg0];
		int[] var4 = this.field1172[arg0];
		Object[] var5 = this.field1170[arg0];
		boolean var6 = true;
		for (int var7 = 0; var7 < var3; var7++) {
			if (var5[var4[var7]] == null) {
				var6 = false;
				break;
			}
		}
		if (var6) {
			return true;
		}
		byte[] var8;
		if (arg1 == null || arg1[0] == 0 && arg1[1] == 0 && arg1[2] == 0 && arg1[3] == 0) {
			var8 = ByteArrayCopier.method108(this.field1178[arg0], false);
		} else {
			var8 = ByteArrayCopier.method108(this.field1178[arg0], true);
			Packet var9 = new Packet(var8);
			var9.tinydec(arg1, 5, var9.data.length);
		}
		byte[] var10;
		try {
			var10 = method52(var8);
		} catch (RuntimeException var43) {
			String var13 = "" + (arg1 != null) + "," + arg0 + "," + var8.length + ",";
			int var14 = var8.length;
			int var15 = -1;
			for (int var16 = 0; var16 < var14; var16++) {
				var15 = var15 >>> 8 ^ Packet.crctable[(var15 ^ var8[var16]) & 0xFF];
			}
			int var17 = ~var15;
			String var21 = var13 + var17 + ",";
			int var22 = var8.length - 2;
			int var23 = -1;
			for (int var24 = 0; var24 < var22; var24++) {
				var23 = var23 >>> 8 ^ Packet.crctable[(var23 ^ var8[var24]) & 0xFF];
			}
			int var25 = ~var23;
			throw JagException.report((Throwable) var43, (String) (var21 + var25 + "," + this.field1169[arg0] + "," + this.field1175));
		}
		if (this.field1166) {
			this.field1178[arg0] = null;
		}
		if (var3 > 1) {
			int var28 = var10.length;
			int var44 = var28 - 1;
			int var29 = var10[var44] & 0xFF;
			int var30 = var44 - var3 * var29 * 4;
			Packet var31 = new Packet(var10);
			int[] var32 = new int[var3];
			var31.pos = var30;
			for (int var33 = 0; var33 < var29; var33++) {
				int var34 = 0;
				for (int var35 = 0; var35 < var3; var35++) {
					var34 += var31.g4();
					var32[var35] += var34;
				}
			}
			byte[][] var36 = new byte[var3][];
			for (int var37 = 0; var37 < var3; var37++) {
				var36[var37] = new byte[var32[var37]];
				var32[var37] = 0;
			}
			var31.pos = var30;
			int var38 = 0;
			for (int var39 = 0; var39 < var29; var39++) {
				int var40 = 0;
				for (int var41 = 0; var41 < var3; var41++) {
					var40 += var31.g4();
					System.arraycopy(var10, var38, var36[var41], var32[var41], var40);
					var32[var41] += var40;
					var38 += var40;
				}
			}
			for (int var42 = 0; var42 < var3; var42++) {
				if (this.field1180) {
					var5[var4[var42]] = var36[var42];
				} else {
					var5[var4[var42]] = ByteArrayCopier.method1131(var36[var42], false);
				}
			}
		} else if (this.field1180) {
			var5[var4[0]] = var10;
		} else {
			var5[var4[0]] = ByteArrayCopier.method1131(var10, false);
		}
		return true;
	}

	@ObfuscatedName("ch.y(Ljava/lang/String;I)I")
	public int method1059(String arg0) {
		String var2 = arg0.toLowerCase();
		return this.field1168.method1241(JStringUtil.method1234(var2));
	}

	@ObfuscatedName("ch.t(ILjava/lang/String;B)I")
	public int method1064(int arg0, String arg1) {
		String var3 = arg1.toLowerCase();
		return this.field1174[arg0].method1241(JStringUtil.method1234(var3));
	}

	@ObfuscatedName("ch.f(Ljava/lang/String;Ljava/lang/String;I)[B")
	public byte[] method1061(String arg0, String arg1) {
		String var3 = arg0.toLowerCase();
		String var4 = arg1.toLowerCase();
		int var5 = this.field1168.method1241(JStringUtil.method1234(var3));
		int var6 = this.field1174[var5].method1241(JStringUtil.method1234(var4));
		return this.method1044(var5, var6);
	}

	@ObfuscatedName("ch.k(Ljava/lang/String;Ljava/lang/String;B)Z")
	public boolean method1076(String arg0, String arg1) {
		String var3 = arg0.toLowerCase();
		String var4 = arg1.toLowerCase();
		int var5 = this.field1168.method1241(JStringUtil.method1234(var3));
		int var6 = this.field1174[var5].method1241(JStringUtil.method1234(var4));
		return this.method1046(var5, var6);
	}

	@ObfuscatedName("ch.o(Ljava/lang/String;I)V")
	public void method1056(String arg0) {
		String var2 = arg0.toLowerCase();
		int var3 = this.field1168.method1241(JStringUtil.method1234(var2));
		if (var3 >= 0) {
			this.method1043(var3);
		}
	}

	@ObfuscatedName("c.a([BI)[B")
	public static final byte[] method52(byte[] arg0) {
		Packet var1 = new Packet(arg0);
		int var2 = var1.g1();
		int var3 = var1.g4();
		if (var3 < 0 || field1176 != 0 && var3 > field1176) {
			throw new RuntimeException();
		} else if (var2 == 0) {
			byte[] var4 = new byte[var3];
			var1.gdata(var4, 0, var3);
			return var4;
		} else {
			int var5 = var1.g4();
			if (var5 < 0 || field1176 != 0 && var5 > field1176) {
				throw new RuntimeException();
			}
			byte[] var6 = new byte[var5];
			if (var2 == 1) {
				BZip2.method842(var6, var5, arg0, var3, 9);
			} else {
				field1177.method834(var1, var6);
			}
			return var6;
		}
	}
}
