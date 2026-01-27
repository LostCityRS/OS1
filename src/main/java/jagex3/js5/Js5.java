package jagex3.js5;

import deob.ObfuscatedName;
import jagex3.client.JagException;
import jagex3.datastruct.ByteArrayWrapper;
import jagex3.datastruct.IntHashTable;
import jagex3.io.BZip2;
import jagex3.io.GZip;
import jagex3.io.Packet;
import jagex3.jstring.StringTools;

// jag::oldscape::jagex3::Js5
// com.jagex.js5.js5
@ObfuscatedName("ch")
public abstract class Js5 {

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

	public Js5(boolean discardPacked, boolean discardUnpacked) {
		this.discardPacked = discardPacked;
		this.discardUnpacked = discardUnpacked;
	}

	@ObfuscatedName("ch.r([BI)V")
	public void decodeIndex(byte[] src) {
		// todo: inlined method (getcrc)
		int var2 = src.length;
		int var3 = -1;
		for (int var4 = 0; var4 < var2; var4++) {
			var3 = var3 >>> 8 ^ Packet.crctable[(var3 ^ src[var4]) & 0xFF];
		}
		int var5 = ~var3;
		this.crc = var5;

		Packet buf = new Packet(getUncompressedPacket(src));
		int protocol = buf.g1();
		if (protocol < 5 || protocol > 7) {
			throw new RuntimeException("Incorrect JS5 protocol number: " + protocol);
		}

		if (protocol >= 6) {
			buf.g4();
		}

		int info = buf.g1();

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

		if (info != 0) {
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

		if (info != 0) {
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

	// jag::oldscape::jagex3::Js5::UpdateCacheHint
	@ObfuscatedName("ch.d(IB)V")
	public void updateCacheHint(int hint) {
	}

	// jag::oldscape::jagex3::Js5::GetFile
	@ObfuscatedName("ch.l(III)[B")
	public byte[] getFile(int groupId, int fileId) {
		return this.fetchFile(groupId, fileId, null);
	}

	// jag::oldscape::jagex3::Js5::FetchFile
	@ObfuscatedName("ch.m(II[IS)[B")
	public byte[] fetchFile(int groupId, int fileId, int[] keys) {
		if (groupId < 0 || groupId >= this.unpacked.length || this.unpacked[groupId] == null || fileId < 0 || fileId >= this.unpacked[groupId].length) {
			return null;
		}

		if (this.unpacked[groupId][fileId] == null) {
			boolean var4 = this.unpackGroupData(groupId, keys);
			if (!var4) {
				this.requestGroupDownload2(groupId);

				boolean var5 = this.unpackGroupData(groupId, keys);
				if (!var5) {
					return null;
				}
			}
		}

		byte[] data = ByteArrayWrapper.unwrap(this.unpacked[groupId][fileId], false);
		if (this.discardUnpacked) {
			this.unpacked[groupId][fileId] = null;
		}
		return data;
	}

	// jag::oldscape::jagex3::Js5::RequestDownload
	@ObfuscatedName("ch.c(III)Z")
	public boolean requestDownload(int groupId, int fileId) {
		if (groupId < 0 || groupId >= this.unpacked.length || this.unpacked[groupId] == null || fileId < 0 || fileId >= this.unpacked[groupId].length) {
			return false;
		}

		if (this.unpacked[groupId][fileId] != null) {
			return true;
		}

		if (this.packed[groupId] != null) {
			return true;
		}

		this.requestGroupDownload2(groupId);
		return this.packed[groupId] != null;
	}

	// jag::oldscape::jagex3::Js5::RequestGroupDownload
	@ObfuscatedName("ch.n(II)Z")
	public boolean requestGroupDownload(int groupId) {
		if (this.packed[groupId] != null) {
			return true;
		}

		this.requestGroupDownload2(groupId);
		return this.packed[groupId] != null;
	}

	// jag::oldscape::jagex3::Js5::RequestFullDownload
	@ObfuscatedName("ch.j(B)Z")
	public boolean requestFullDownload() {
		boolean done = true;
		for (int i = 0; i < this.groupIds.length; i++) {
			int groupId = this.groupIds[i];
			if (this.packed[groupId] != null) {
				continue;
			}

			this.requestGroupDownload2(groupId);

			if (this.packed[groupId] == null) {
				done = false;
			}
		}
		return done;
	}

	// jag::oldscape::jagex3::Js5::GetFile
	@ObfuscatedName("ch.z(II)[B")
	public byte[] getFile(int id) {
		if (this.unpacked.length == 1) {
			return this.getFile(0, id);
		} else if (this.unpacked[id].length == 1) {
			return this.getFile(id, 0);
		} else {
			throw new RuntimeException();
		}
	}

	// jag::oldscape::jagex3::Js5::PeekFile
	@ObfuscatedName("ch.g(III)[B")
	public byte[] peekFile(int groupId, int fileId) {
		if (groupId < 0 || groupId >= this.unpacked.length || this.unpacked[groupId] == null || fileId < 0 || fileId >= this.unpacked[groupId].length) {
			return null;
		}

		if (this.unpacked[groupId][fileId] == null) {
			boolean var3 = this.unpackGroupData(groupId, null);
			if (!var3) {
				this.requestGroupDownload2(groupId);

				boolean var4 = this.unpackGroupData(groupId, null);
				if (!var4) {
					return null;
				}
			}
		}

		return ByteArrayWrapper.unwrap(this.unpacked[groupId][fileId], false);
	}

	// jag::oldscape::jagex3::Js5::PeekFile
	@ObfuscatedName("ch.q(II)[B")
	public byte[] peekFile(int id) {
		if (this.unpacked.length == 1) {
			return this.peekFile(0, id);
		} else if (this.unpacked[id].length == 1) {
			return this.peekFile(id, 0);
		} else {
			throw new RuntimeException();
		}
	}

	// jag::oldscape::jagex3::Js5::RequestGroupDownload
	@ObfuscatedName("ch.i(IB)V")
	public void requestGroupDownload2(int groupId) {
	}

	// jag::oldscape::jagex3::Js5::GetFileList
	@ObfuscatedName("ch.s(II)[I")
	public int[] getFileList(int groupId) {
		return this.fileIds[groupId];
	}

	// jag::oldscape::jagex3::Js5::GetFileIdLimit
	@ObfuscatedName("ch.u(IS)I")
	public int getFileIdLimit(int groupId) {
		return this.unpacked[groupId].length;
	}

	// jag::oldscape::jagex3::Js5::GetGroupCount
	@ObfuscatedName("ch.v(I)I")
	public int getGroupCount() {
		return this.unpacked.length;
	}

	// jag::oldscape::jagex3::Js5::DiscardFiles
	@ObfuscatedName("ch.w(II)V")
	public void discardFiles(int groupId) {
		for (int fileId = 0; fileId < this.unpacked[groupId].length; fileId++) {
			this.unpacked[groupId][fileId] = null;
		}
	}

	// jag::oldscape::jagex3::Js5::DiscardAllFiles
	@ObfuscatedName("ch.e(I)V")
	public void discardAllFiles() {
		for (int groupId = 0; groupId < this.unpacked.length; groupId++) {
			if (this.unpacked[groupId] == null) {
				continue;
			}

			for (int fileId = 0; fileId < this.unpacked[groupId].length; fileId++) {
				this.unpacked[groupId][fileId] = null;
			}
		}
	}

	// jag::oldscape::jagex3::Js5::UnpackGroupData
	@ObfuscatedName("ch.b(I[II)Z")
	public boolean unpackGroupData(int groupId, int[] key) {
		if (this.packed[groupId] == null) {
			return false;
		}

		int var3 = this.groupSizes[groupId];
		int[] var4 = this.fileIds[groupId];
		Object[] var5 = this.unpacked[groupId];
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
		if (key == null || key[0] == 0 && key[1] == 0 && key[2] == 0 && key[3] == 0) {
			var8 = ByteArrayWrapper.unwrap(this.packed[groupId], false);
		} else {
			var8 = ByteArrayWrapper.unwrap(this.packed[groupId], true);
			Packet var9 = new Packet(var8);
			var9.tinydec(key, 5, var9.data.length);
		}

		byte[] var10;
		try {
			var10 = getUncompressedPacket(var8);
		} catch (RuntimeException ex) {
			String var13 = "" + (key != null) + "," + groupId + "," + var8.length + ",";

			// todo: inlined method (getcrc)
			int var14 = var8.length;
			int var15 = -1;
			for (int var16 = 0; var16 < var14; var16++) {
				var15 = var15 >>> 8 ^ Packet.crctable[(var15 ^ var8[var16]) & 0xFF];
			}
			int var17 = ~var15;

			String var21 = var13 + var17 + ",";

			// todo: inlined method (getcrc)
			int var22 = var8.length - 2;
			int var23 = -1;
			for (int var24 = 0; var24 < var22; var24++) {
				var23 = var23 >>> 8 ^ Packet.crctable[(var23 ^ var8[var24]) & 0xFF];
			}
			int var25 = ~var23;

			throw JagException.report(ex, var21 + var25 + "," + this.groupChecksums[groupId] + "," + this.crc);
		}

		if (this.discardPacked) {
			this.packed[groupId] = null;
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
					var5[var4[var42]] = ByteArrayWrapper.wrap(var36[var42], false);
				}
			}
		} else if (this.discardUnpacked) {
			var5[var4[0]] = var10;
		} else {
			var5[var4[0]] = ByteArrayWrapper.wrap(var10, false);
		}
		return true;
	}

	// jag::oldscape::jagex3::Js5::GetGroupId
	@ObfuscatedName("ch.y(Ljava/lang/String;I)I")
	public int getGroupId(String group) {
		String lower = group.toLowerCase();
		return this.groupNameHashTable.find(StringTools.computeCp1252HashFromUtf8(lower));
	}

	// jag::oldscape::jagex3::Js5::GetFileId
	// com.jagex.js5.js5.getfileid
	@ObfuscatedName("ch.t(ILjava/lang/String;B)I")
	public int getFileId(int groupId, String file) {
		String lower = file.toLowerCase();
		return this.fileNameHashTables[groupId].find(StringTools.computeCp1252HashFromUtf8(lower));
	}

	// jag::oldscape::jagex3::Js5::GetFile
	@ObfuscatedName("ch.f(Ljava/lang/String;Ljava/lang/String;I)[B")
	public byte[] getFile(String group, String file) {
		String groupLower = group.toLowerCase();
		String fileLower = file.toLowerCase();
		int groupId = this.groupNameHashTable.find(StringTools.computeCp1252HashFromUtf8(groupLower));
		int fileId = this.fileNameHashTables[groupId].find(StringTools.computeCp1252HashFromUtf8(fileLower));
		return this.getFile(groupId, fileId);
	}

	// jag::oldscape::jagex3::Js5::RequestDownload
	@ObfuscatedName("ch.k(Ljava/lang/String;Ljava/lang/String;B)Z")
	public boolean requestDownload(String group, String file) {
		String groupLower = group.toLowerCase();
		String fileLower = file.toLowerCase();
		int groupId = this.groupNameHashTable.find(StringTools.computeCp1252HashFromUtf8(groupLower));
		int fileId = this.fileNameHashTables[groupId].find(StringTools.computeCp1252HashFromUtf8(fileLower));
		return this.requestDownload(groupId, fileId);
	}

	// jag::oldscape::jagex3::Js5::UpdateCacheHint
	@ObfuscatedName("ch.o(Ljava/lang/String;I)V")
	public void updateCacheHint(String group) {
		String lower = group.toLowerCase();
		int groupId = this.groupNameHashTable.find(StringTools.computeCp1252HashFromUtf8(lower));
		if (groupId >= 0) {
			this.updateCacheHint(groupId);
		}
	}

	// jag::oldscape::jagex3::Js5::GetUncompressedPacket
	@ObfuscatedName("c.a([BI)[B")
	public static byte[] getUncompressedPacket(byte[] src) {
		Packet buf = new Packet(src);
		int ctype = buf.g1();
		int clen = buf.g4();

		if (clen < 0 || maxsize != 0 && clen > maxsize) {
			throw new RuntimeException();
		}

		if (ctype == 0) {
			byte[] data = new byte[clen];
			buf.gdata(data, 0, clen);
			return data;
		}

		int ulen = buf.g4();
		if (ulen < 0 || maxsize != 0 && ulen > maxsize) {
			throw new RuntimeException();
		}

		byte[] data = new byte[ulen];
		if (ctype == 1) {
			BZip2.decompress(data, ulen, src, clen, 9);
		} else {
			gzip.decompress(buf, data);
		}
		return data;
	}
}
