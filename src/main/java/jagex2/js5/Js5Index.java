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
	public int size;

	@ObfuscatedName("ch.d")
	public int[] groupIds;

	@ObfuscatedName("ch.l")
	public int[] groupNameHash;

	@ObfuscatedName("ch.m")
	public IntHashTable groupNameHashTable;

	@ObfuscatedName("ch.c")
	public int[] groupChecksums;

	@ObfuscatedName("ch.n")
	public int[] groupVersions;

	@ObfuscatedName("ch.j")
	public int[] groupSizes;

	@ObfuscatedName("ch.z")
	public int[][] fileIds;

	@ObfuscatedName("ch.g")
	public int[][] fileNameHashes;

	@ObfuscatedName("ch.q")
	public IntHashTable[] fileNameHashTables;

	@ObfuscatedName("ch.i")
	public Object[] packed;

	@ObfuscatedName("ch.s")
	public Object[][] unpacked;

	@ObfuscatedName("ch.u")
	public static GZip gzip = new GZip();

	@ObfuscatedName("ch.v")
	public int crc;

	@ObfuscatedName("ch.w")
	public boolean discardPacked;

	@ObfuscatedName("ch.e")
	public boolean discardUnpacked;

	@ObfuscatedName("ch.b")
	public static int maxsize = 0;

	public Js5Index(boolean arg0, boolean arg1) {
		this.discardPacked = arg0;
		this.discardUnpacked = arg1;
	}

	@ObfuscatedName("ch.r([BI)V")
	public void decode(byte[] arg0) {
		int var2 = arg0.length;
		int var3 = -1;
		for (int var4 = 0; var4 < var2; var4++) {
			var3 = var3 >>> 8 ^ Packet.crctable[(var3 ^ arg0[var4]) & 0xFF];
		}
		int var5 = ~var3;
		this.crc = var5;
		Packet var8 = new Packet(decompress(arg0));
		int var9 = var8.g1();
		if (var9 < 5 || var9 > 7) {
			throw new RuntimeException("");
		}
		if (var9 >= 6) {
			var8.g4();
		}
		int var10 = var8.g1();
		if (var9 >= 7) {
			this.size = var8.gSmart2or4();
		} else {
			this.size = var8.g2();
		}
		int var11 = 0;
		int var12 = -1;
		this.groupIds = new int[this.size];
		if (var9 >= 7) {
			for (int var13 = 0; var13 < this.size; var13++) {
				this.groupIds[var13] = var11 += var8.gSmart2or4();
				if (this.groupIds[var13] > var12) {
					var12 = this.groupIds[var13];
				}
			}
		} else {
			for (int var14 = 0; var14 < this.size; var14++) {
				this.groupIds[var14] = var11 += var8.g2();
				if (this.groupIds[var14] > var12) {
					var12 = this.groupIds[var14];
				}
			}
		}
		this.groupChecksums = new int[var12 + 1];
		this.groupVersions = new int[var12 + 1];
		this.groupSizes = new int[var12 + 1];
		this.fileIds = new int[var12 + 1][];
		this.packed = new Object[var12 + 1];
		this.unpacked = new Object[var12 + 1][];
		if (var10 != 0) {
			this.groupNameHash = new int[var12 + 1];
			for (int var15 = 0; var15 < this.size; var15++) {
				this.groupNameHash[this.groupIds[var15]] = var8.g4();
			}
			this.groupNameHashTable = new IntHashTable(this.groupNameHash);
		}
		for (int var16 = 0; var16 < this.size; var16++) {
			this.groupChecksums[this.groupIds[var16]] = var8.g4();
		}
		for (int var17 = 0; var17 < this.size; var17++) {
			this.groupVersions[this.groupIds[var17]] = var8.g4();
		}
		for (int var18 = 0; var18 < this.size; var18++) {
			this.groupSizes[this.groupIds[var18]] = var8.g2();
		}
		if (var9 >= 7) {
			for (int var19 = 0; var19 < this.size; var19++) {
				int var20 = this.groupIds[var19];
				int var21 = this.groupSizes[var20];
				int var22 = 0;
				int var23 = -1;
				this.fileIds[var20] = new int[var21];
				for (int var24 = 0; var24 < var21; var24++) {
					int var25 = this.fileIds[var20][var24] = var22 += var8.gSmart2or4();
					if (var25 > var23) {
						var23 = var25;
					}
				}
				this.unpacked[var20] = new Object[var23 + 1];
			}
		} else {
			for (int var26 = 0; var26 < this.size; var26++) {
				int var27 = this.groupIds[var26];
				int var28 = this.groupSizes[var27];
				int var29 = 0;
				int var30 = -1;
				this.fileIds[var27] = new int[var28];
				for (int var31 = 0; var31 < var28; var31++) {
					int var32 = this.fileIds[var27][var31] = var29 += var8.g2();
					if (var32 > var30) {
						var30 = var32;
					}
				}
				this.unpacked[var27] = new Object[var30 + 1];
			}
		}
		if (var10 == 0) {
			return;
		}
		this.fileNameHashes = new int[var12 + 1][];
		this.fileNameHashTables = new IntHashTable[var12 + 1];
		for (int var33 = 0; var33 < this.size; var33++) {
			int var34 = this.groupIds[var33];
			int var35 = this.groupSizes[var34];
			this.fileNameHashes[var34] = new int[this.unpacked[var34].length];
			for (int var36 = 0; var36 < var35; var36++) {
				this.fileNameHashes[var34][this.fileIds[var34][var36]] = var8.g4();
			}
			this.fileNameHashTables[var34] = new IntHashTable(this.fileNameHashes[var34]);
		}
	}

	@ObfuscatedName("ch.d(IB)V")
	public void download(int arg0) {
	}

	@ObfuscatedName("ch.l(III)[B")
	public byte[] getFile(int arg0, int arg1) {
		return this.getFile(arg0, arg1, null);
	}

	@ObfuscatedName("ch.m(II[IS)[B")
	public byte[] getFile(int arg0, int arg1, int[] arg2) {
		if (arg0 < 0 || arg0 >= this.unpacked.length || this.unpacked[arg0] == null || arg1 < 0 || arg1 >= this.unpacked[arg0].length) {
			return null;
		}
		if (this.unpacked[arg0][arg1] == null) {
			boolean var4 = this.unpackGroup(arg0, arg2);
			if (!var4) {
				this.fetchGroup(arg0);
				boolean var5 = this.unpackGroup(arg0, arg2);
				if (!var5) {
					return null;
				}
			}
		}
		byte[] var6 = ByteArrayCopier.method108(this.unpacked[arg0][arg1], false);
		if (this.discardUnpacked) {
			this.unpacked[arg0][arg1] = null;
		}
		return var6;
	}

	@ObfuscatedName("ch.c(III)Z")
	public boolean download(int arg0, int arg1) {
		if (arg0 < 0 || arg0 >= this.unpacked.length || this.unpacked[arg0] == null || arg1 < 0 || arg1 >= this.unpacked[arg0].length) {
			return false;
		} else if (this.unpacked[arg0][arg1] != null) {
			return true;
		} else if (this.packed[arg0] == null) {
			this.fetchGroup(arg0);
			return this.packed[arg0] != null;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ch.n(II)Z")
	public boolean isGroupReady(int arg0) {
		if (this.packed[arg0] == null) {
			this.fetchGroup(arg0);
			return this.packed[arg0] != null;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ch.j(B)Z")
	public boolean fetchAll() {
		boolean var1 = true;
		for (int var2 = 0; var2 < this.groupIds.length; var2++) {
			int var3 = this.groupIds[var2];
			if (this.packed[var3] == null) {
				this.fetchGroup(var3);
				if (this.packed[var3] == null) {
					var1 = false;
				}
			}
		}
		return var1;
	}

	@ObfuscatedName("ch.z(II)[B")
	public byte[] fetchFile(int arg0) {
		if (this.unpacked.length == 1) {
			return this.getFile(0, arg0);
		} else if (this.unpacked[arg0].length == 1) {
			return this.getFile(arg0, 0);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("ch.g(III)[B")
	public byte[] getFileNoDiscard(int arg0, int arg1) {
		if (arg0 < 0 || arg0 >= this.unpacked.length || this.unpacked[arg0] == null || arg1 < 0 || arg1 >= this.unpacked[arg0].length) {
			return null;
		}
		if (this.unpacked[arg0][arg1] == null) {
			boolean var3 = this.unpackGroup(arg0, null);
			if (!var3) {
				this.fetchGroup(arg0);
				boolean var4 = this.unpackGroup(arg0, null);
				if (!var4) {
					return null;
				}
			}
		}
		return ByteArrayCopier.method108(this.unpacked[arg0][arg1], false);
	}

	@ObfuscatedName("ch.q(II)[B")
	public byte[] fetchFileNoDiscard(int arg0) {
		if (this.unpacked.length == 1) {
			return this.getFileNoDiscard(0, arg0);
		} else if (this.unpacked[arg0].length == 1) {
			return this.getFileNoDiscard(arg0, 0);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("ch.i(IB)V")
	public void fetchGroup(int arg0) {
	}

	@ObfuscatedName("ch.s(II)[I")
	public int[] getFileIds(int arg0) {
		return this.fileIds[arg0];
	}

	@ObfuscatedName("ch.u(IS)I")
	public int getFileCount(int arg0) {
		return this.unpacked[arg0].length;
	}

	@ObfuscatedName("ch.v(I)I")
	public int getGroupCount() {
		return this.unpacked.length;
	}

	@ObfuscatedName("ch.w(II)V")
	public void discardFiles(int arg0) {
		for (int var2 = 0; var2 < this.unpacked[arg0].length; var2++) {
			this.unpacked[arg0][var2] = null;
		}
	}

	@ObfuscatedName("ch.e(I)V")
	public void discardAll() {
		for (int var1 = 0; var1 < this.unpacked.length; var1++) {
			if (this.unpacked[var1] != null) {
				for (int var2 = 0; var2 < this.unpacked[var1].length; var2++) {
					this.unpacked[var1][var2] = null;
				}
			}
		}
	}

	@ObfuscatedName("ch.b(I[II)Z")
	public boolean unpackGroup(int arg0, int[] arg1) {
		if (this.packed[arg0] == null) {
			return false;
		}
		int var3 = this.groupSizes[arg0];
		int[] var4 = this.fileIds[arg0];
		Object[] var5 = this.unpacked[arg0];
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
			var8 = ByteArrayCopier.method108(this.packed[arg0], false);
		} else {
			var8 = ByteArrayCopier.method108(this.packed[arg0], true);
			Packet var9 = new Packet(var8);
			var9.tinydec(arg1, 5, var9.data.length);
		}
		byte[] var10;
		try {
			var10 = decompress(var8);
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
			throw JagException.report((Throwable) var43, (String) (var21 + var25 + "," + this.groupChecksums[arg0] + "," + this.crc));
		}
		if (this.discardPacked) {
			this.packed[arg0] = null;
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
				if (this.discardUnpacked) {
					var5[var4[var42]] = var36[var42];
				} else {
					var5[var4[var42]] = ByteArrayCopier.method1131(var36[var42], false);
				}
			}
		} else if (this.discardUnpacked) {
			var5[var4[0]] = var10;
		} else {
			var5[var4[0]] = ByteArrayCopier.method1131(var10, false);
		}
		return true;
	}

	@ObfuscatedName("ch.y(Ljava/lang/String;I)I")
	public int getGroupId(String arg0) {
		String var2 = arg0.toLowerCase();
		return this.groupNameHashTable.get(JStringUtil.hashCode(var2));
	}

	@ObfuscatedName("ch.t(ILjava/lang/String;B)I")
	public int getFileId(int arg0, String arg1) {
		String var3 = arg1.toLowerCase();
		return this.fileNameHashTables[arg0].get(JStringUtil.hashCode(var3));
	}

	@ObfuscatedName("ch.f(Ljava/lang/String;Ljava/lang/String;I)[B")
	public byte[] getFile(String arg0, String arg1) {
		String var3 = arg0.toLowerCase();
		String var4 = arg1.toLowerCase();
		int var5 = this.groupNameHashTable.get(JStringUtil.hashCode(var3));
		int var6 = this.fileNameHashTables[var5].get(JStringUtil.hashCode(var4));
		return this.getFile(var5, var6);
	}

	@ObfuscatedName("ch.k(Ljava/lang/String;Ljava/lang/String;B)Z")
	public boolean download(String arg0, String arg1) {
		String var3 = arg0.toLowerCase();
		String var4 = arg1.toLowerCase();
		int var5 = this.groupNameHashTable.get(JStringUtil.hashCode(var3));
		int var6 = this.fileNameHashTables[var5].get(JStringUtil.hashCode(var4));
		return this.download(var5, var6);
	}

	@ObfuscatedName("ch.o(Ljava/lang/String;I)V")
	public void download(String arg0) {
		String var2 = arg0.toLowerCase();
		int var3 = this.groupNameHashTable.get(JStringUtil.hashCode(var2));
		if (var3 >= 0) {
			this.download(var3);
		}
	}

	@ObfuscatedName("c.a([BI)[B")
	public static final byte[] decompress(byte[] arg0) {
		Packet var1 = new Packet(arg0);
		int var2 = var1.g1();
		int var3 = var1.g4();
		if (var3 < 0 || maxsize != 0 && var3 > maxsize) {
			throw new RuntimeException();
		} else if (var2 == 0) {
			byte[] var4 = new byte[var3];
			var1.gdata(var4, 0, var3);
			return var4;
		} else {
			int var5 = var1.g4();
			if (var5 < 0 || maxsize != 0 && var5 > maxsize) {
				throw new RuntimeException();
			}
			byte[] var6 = new byte[var5];
			if (var2 == 1) {
				BZip2.decompress(var6, var5, arg0, var3, 9);
			} else {
				gzip.decompress(var1, var6);
			}
			return var6;
		}
	}
}
