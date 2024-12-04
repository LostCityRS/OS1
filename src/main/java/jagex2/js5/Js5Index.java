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
	public static GZip field1177 = new GZip();

	@ObfuscatedName("ch.v")
	public int crc;

	@ObfuscatedName("ch.w")
	public boolean discardPacked;

	@ObfuscatedName("ch.e")
	public boolean discardUnpacked;

	@ObfuscatedName("ch.b")
	public static int field1176 = 0;

	public Js5Index(boolean discardPacked, boolean discardUnpacked) {
		this.discardPacked = discardPacked;
		this.discardUnpacked = discardUnpacked;
	}

	@ObfuscatedName("ch.r([BI)V")
	public void decode(byte[] data) {
		this.crc = Packet.getcrc(data, data.length);

		Packet buf = new Packet(decompress(data));

		int protocol = buf.g1();
		if (protocol < 5 || protocol > 7) {
			throw new RuntimeException("Incorrect JS5 protocol number: " + protocol);
		}

		if (protocol >= 6) {
			// version
			buf.g4();
		}

		int info = buf.g1();
		boolean hasNames = (info & 0x1) != 0;

		if (protocol >= 7) {
			this.size = buf.gSmart2or4();
		} else {
			this.size = buf.g2();
		}

		int prevGroupId = 0;
		int maxGroupId = -1;
		this.groupIds = new int[this.size];
		if (protocol >= 7) {
			for (int i = 0; i < this.size; i++) {
				this.groupIds[i] = prevGroupId += buf.gSmart2or4();
				if (this.groupIds[i] > maxGroupId) {
					maxGroupId = this.groupIds[i];
				}
			}
		} else {
			for (int i = 0; i < this.size; i++) {
				this.groupIds[i] = prevGroupId += buf.g2();
				if (this.groupIds[i] > maxGroupId) {
					maxGroupId = this.groupIds[i];
				}
			}
		}

		this.groupChecksums = new int[maxGroupId + 1];
		this.groupVersions = new int[maxGroupId + 1];
		this.groupSizes = new int[maxGroupId + 1];
		this.fileIds = new int[maxGroupId + 1][];
		this.packed = new Object[maxGroupId + 1];
		this.unpacked = new Object[maxGroupId + 1][];

		if (hasNames) {
			this.groupNameHash = new int[maxGroupId + 1];

			for (int i = 0; i < this.size; i++) {
				this.groupNameHash[this.groupIds[i]] = buf.g4();
			}

			this.groupNameHashTable = new IntHashTable(this.groupNameHash);
		}

		for (int i = 0; i < this.size; i++) {
			this.groupChecksums[this.groupIds[i]] = buf.g4();
		}

		for (int i = 0; i < this.size; i++) {
			this.groupVersions[this.groupIds[i]] = buf.g4();
		}

		for (int i = 0; i < this.size; i++) {
			this.groupSizes[this.groupIds[i]] = buf.g2();
		}

		if (protocol >= 7) {
			for (int i = 0; i < this.size; i++) {
				int id = this.groupIds[i];
				int size = this.groupSizes[id];
				int prevFileId = 0;
				int maxFileId = -1;

				this.fileIds[id] = new int[size];
				for (int j = 0; j < size; j++) {
					int fileId = this.fileIds[id][j] = prevFileId += buf.gSmart2or4();
					if (fileId > maxFileId) {
						maxFileId = fileId;
					}
				}

				this.unpacked[id] = new Object[maxFileId + 1];
			}
		} else {
			for (int i = 0; i < this.size; i++) {
				int id = this.groupIds[i];
				int size = this.groupSizes[id];
				int prevFileId = 0;
				int maxFileId = -1;

				this.fileIds[id] = new int[size];
				for (int j = 0; j < size; j++) {
					int fileId = this.fileIds[id][j] = prevFileId += buf.g2();
					if (fileId > maxFileId) {
						maxFileId = fileId;
					}
				}

				this.unpacked[id] = new Object[maxFileId + 1];
			}
		}

        if (hasNames) {
            this.fileNameHashes = new int[maxGroupId + 1][];
            this.fileNameHashTables = new IntHashTable[maxGroupId + 1];

            for (int i = 0; i < this.size; i++) {
                int id = this.groupIds[i];
                int size = this.groupSizes[id];

                this.fileNameHashes[id] = new int[this.unpacked[id].length];
                for (int j = 0; j < size; j++) {
                    this.fileNameHashes[id][this.fileIds[id][j]] = buf.g4();
                }

                this.fileNameHashTables[id] = new IntHashTable(this.fileNameHashes[id]);
            }
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
		if (arg0 < 0 || arg0 >= this.unpacked.length || this.unpacked[arg0] == null || arg1 < 0 || arg1 >= this.unpacked[arg0].length) {
			return null;
		}
		if (this.unpacked[arg0][arg1] == null) {
			boolean var4 = this.unpackGroup(arg0, arg2);
			if (!var4) {
				this.method1052(arg0);
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
	public boolean method1046(int arg0, int arg1) {
		if (arg0 < 0 || arg0 >= this.unpacked.length || this.unpacked[arg0] == null || arg1 < 0 || arg1 >= this.unpacked[arg0].length) {
			return false;
		} else if (this.unpacked[arg0][arg1] != null) {
			return true;
		} else if (this.packed[arg0] == null) {
			this.method1052(arg0);
			return this.packed[arg0] != null;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ch.n(II)Z")
	public boolean method1093(int arg0) {
		if (this.packed[arg0] == null) {
			this.method1052(arg0);
			return this.packed[arg0] != null;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ch.j(B)Z")
	public boolean method1048() {
		boolean var1 = true;
		for (int var2 = 0; var2 < this.groupIds.length; var2++) {
			int var3 = this.groupIds[var2];
			if (this.packed[var3] == null) {
				this.method1052(var3);
				if (this.packed[var3] == null) {
					var1 = false;
				}
			}
		}
		return var1;
	}

	@ObfuscatedName("ch.z(II)[B")
	public byte[] method1092(int arg0) {
		if (this.unpacked.length == 1) {
			return this.method1044(0, arg0);
		} else if (this.unpacked[arg0].length == 1) {
			return this.method1044(arg0, 0);
		} else {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("ch.g(III)[B")
	public byte[] method1050(int arg0, int arg1) {
		if (arg0 < 0 || arg0 >= this.unpacked.length || this.unpacked[arg0] == null || arg1 < 0 || arg1 >= this.unpacked[arg0].length) {
			return null;
		}
		if (this.unpacked[arg0][arg1] == null) {
			boolean var3 = this.unpackGroup(arg0, null);
			if (!var3) {
				this.method1052(arg0);
				boolean var4 = this.unpackGroup(arg0, null);
				if (!var4) {
					return null;
				}
			}
		}
		return ByteArrayCopier.method108(this.unpacked[arg0][arg1], false);
	}

	@ObfuscatedName("ch.q(II)[B")
	public byte[] method1051(int arg0) {
		if (this.unpacked.length == 1) {
			return this.method1050(0, arg0);
		} else if (this.unpacked[arg0].length == 1) {
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
		return this.fileIds[arg0];
	}

	@ObfuscatedName("ch.u(IS)I")
	public int method1054(int arg0) {
		return this.unpacked[arg0].length;
	}

	@ObfuscatedName("ch.v(I)I")
	public int method1055() {
		return this.unpacked.length;
	}

	@ObfuscatedName("ch.w(II)V")
	public void method1086(int arg0) {
		for (int var2 = 0; var2 < this.unpacked[arg0].length; var2++) {
			this.unpacked[arg0][var2] = null;
		}
	}

	@ObfuscatedName("ch.e(I)V")
	public void method1057() {
		for (int var1 = 0; var1 < this.unpacked.length; var1++) {
			if (this.unpacked[var1] != null) {
				for (int var2 = 0; var2 < this.unpacked[var1].length; var2++) {
					this.unpacked[var1][var2] = null;
				}
			}
		}
	}

	@ObfuscatedName("ch.b(I[II)Z")
	public boolean unpackGroup(int group, int[] key) {
		if (this.packed[group] == null) {
			return false;
		}

		int groupSize = this.groupSizes[group];
		int[] fileIds = this.fileIds[group];
		Object[] unpacked = this.unpacked[group];

		boolean var6 = true;
		for (int var7 = 0; var7 < groupSize; var7++) {
			if (unpacked[fileIds[var7]] == null) {
				var6 = false;
				break;
			}
		}

		if (var6) {
			return true;
		}

		byte[] compressed;
		if (key == null || key[0] == 0 && key[1] == 0 && key[2] == 0 && key[3] == 0) {
			compressed = ByteArrayCopier.method108(this.packed[group], false);
		} else {
			compressed = ByteArrayCopier.method108(this.packed[group], true);
			Packet buf = new Packet(compressed);
			buf.tinydec(key, 5, buf.data.length);
		}

		byte[] uncompressed;
		try {
			uncompressed = decompress(compressed);
		} catch (RuntimeException ex) {
			String message = "" + (key != null) + "," + group + "," + compressed.length + ",";

			message += Packet.getcrc(compressed, compressed.length) + ",";
			message += Packet.getcrc(compressed, compressed.length - 2) + ",";
			message += this.groupChecksums[group] + "," + this.crc;

			throw JagException.report(ex, message);
		}

		if (this.discardPacked) {
			this.packed[group] = null;
		}

		if (groupSize > 1) {
			int pos = uncompressed.length;
			pos -= 1;

			int stripes = uncompressed[pos] & 0xFF;
			pos -= groupSize * stripes * 4;

			Packet buf = new Packet(uncompressed);
			int[] lens = new int[groupSize];
			buf.pos = pos;
			for (int i = 0; i < stripes; i++) {
				int len = 0;
				for (int j = 0; j < groupSize; j++) {
					len += buf.g4();
					lens[j] += len;
				}
			}

			byte[][] extracted = new byte[groupSize][];
			for (int i = 0; i < groupSize; i++) {
				extracted[i] = new byte[lens[i]];
				lens[i] = 0;
			}

			buf.pos = pos;
			int off = 0;

			for (int i = 0; i < stripes; i++) {
				int len = 0;
				for (int j = 0; j < groupSize; j++) {
					len += buf.g4();
					System.arraycopy(uncompressed, off, extracted[j], lens[j], len);
					lens[j] += len;
					off += len;
				}
			}

			for (int i = 0; i < groupSize; i++) {
				if (this.discardUnpacked) {
					unpacked[fileIds[i]] = extracted[i];
				} else {
					unpacked[fileIds[i]] = ByteArrayCopier.method1131(extracted[i], false);
				}
			}
		} else if (this.discardUnpacked) {
			unpacked[fileIds[0]] = uncompressed;
		} else {
			unpacked[fileIds[0]] = ByteArrayCopier.method1131(uncompressed, false);
		}

		return true;
	}

	@ObfuscatedName("ch.y(Ljava/lang/String;I)I")
	public int method1059(String arg0) {
		String var2 = arg0.toLowerCase();
		return this.groupNameHashTable.method1241(JStringUtil.method1234(var2));
	}

	@ObfuscatedName("ch.t(ILjava/lang/String;B)I")
	public int method1064(int arg0, String arg1) {
		String var3 = arg1.toLowerCase();
		return this.fileNameHashTables[arg0].method1241(JStringUtil.method1234(var3));
	}

	@ObfuscatedName("ch.f(Ljava/lang/String;Ljava/lang/String;I)[B")
	public byte[] method1061(String arg0, String arg1) {
		String var3 = arg0.toLowerCase();
		String var4 = arg1.toLowerCase();
		int var5 = this.groupNameHashTable.method1241(JStringUtil.method1234(var3));
		int var6 = this.fileNameHashTables[var5].method1241(JStringUtil.method1234(var4));
		return this.method1044(var5, var6);
	}

	@ObfuscatedName("ch.k(Ljava/lang/String;Ljava/lang/String;B)Z")
	public boolean method1076(String arg0, String arg1) {
		String var3 = arg0.toLowerCase();
		String var4 = arg1.toLowerCase();
		int var5 = this.groupNameHashTable.method1241(JStringUtil.method1234(var3));
		int var6 = this.fileNameHashTables[var5].method1241(JStringUtil.method1234(var4));
		return this.method1046(var5, var6);
	}

	@ObfuscatedName("ch.o(Ljava/lang/String;I)V")
	public void method1056(String arg0) {
		String var2 = arg0.toLowerCase();
		int var3 = this.groupNameHashTable.method1241(JStringUtil.method1234(var2));
		if (var3 >= 0) {
			this.method1043(var3);
		}
	}

	@ObfuscatedName("c.a([BI)[B")
	public static final byte[] decompress(byte[] arg0) {
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
