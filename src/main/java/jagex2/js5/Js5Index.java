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
	public byte[] getFile(int group, int file) {
		return this.getFile(group, file, null);
	}

	@ObfuscatedName("ch.m(II[IS)[B")
	public byte[] getFile(int group, int file, int[] key) {
		if (group < 0 || group >= this.unpacked.length || this.unpacked[group] == null || file < 0 || file >= this.unpacked[group].length) {
			return null;
		}

		if (this.unpacked[group][file] == null) {
			boolean success = this.unpackGroup(group, key);
			if (!success) {
				this.fetchGroup(group);

				success = this.unpackGroup(group, key);
				if (!success) {
					return null;
				}
			}
		}

		byte[] bytes = ByteArrayCopier.method108(this.unpacked[group][file], false);

		if (this.discardUnpacked) {
			this.unpacked[group][file] = null;
		}

		return bytes;
	}

	@ObfuscatedName("ch.c(III)Z")
	public boolean requestDownload(int group, int file) {
		if (group < 0 || group >= this.unpacked.length || this.unpacked[group] == null || file < 0 || file >= this.unpacked[group].length) {
			return false;
		} else if (this.unpacked[group][file] != null) {
			return true;
		} else if (this.packed[group] == null) {
			this.fetchGroup(group);
			return this.packed[group] != null;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ch.n(II)Z")
	public boolean isGroupReady(int group) {
		if (this.packed[group] == null) {
			this.fetchGroup(group);
			return this.packed[group] != null;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ch.j(B)Z")
	public boolean fetchAll() {
		boolean success = true;

		for (int i = 0; i < this.groupIds.length; i++) {
			int id = this.groupIds[i];

			if (this.packed[id] == null) {
				this.fetchGroup(id);

				if (this.packed[id] == null) {
					success = false;
				}
			}
		}

		return success;
	}

	@ObfuscatedName("ch.z(II)[B")
	public byte[] fetchFile(int id) {
		if (this.unpacked.length == 1) {
			return this.getFile(0, id);
		} else if (this.unpacked[id].length == 1) {
			return this.getFile(id, 0);
		} else {
			throw new RuntimeException("Unable to determine if id is groupid or fileid");
		}
	}

	@ObfuscatedName("ch.g(III)[B")
	public byte[] getFileNoDiscard(int group, int file) {
		if (group < 0 || group >= this.unpacked.length || this.unpacked[group] == null || file < 0 || file >= this.unpacked[group].length) {
			return null;
		}

		if (this.unpacked[group][file] == null) {
			boolean success = this.unpackGroup(group, null);
			if (!success) {
				this.fetchGroup(group);

				success = this.unpackGroup(group, null);
				if (!success) {
					return null;
				}
			}
		}

		return ByteArrayCopier.method108(this.unpacked[group][file], false);
	}

	@ObfuscatedName("ch.q(II)[B")
	public byte[] fetchFileNoDiscard(int id) {
		if (this.unpacked.length == 1) {
			return this.getFileNoDiscard(0, id);
		} else if (this.unpacked[id].length == 1) {
			return this.getFileNoDiscard(id, 0);
		} else {
			throw new RuntimeException("Unable to determine if id is groupid or fileid");
		}
	}

	@ObfuscatedName("ch.i(IB)V")
	public void fetchGroup(int arg0) {
	}

	@ObfuscatedName("ch.s(II)[I")
	public int[] getFileIds(int group) {
		return this.fileIds[group];
	}

	@ObfuscatedName("ch.u(IS)I")
	public int getFileCount(int group) {
		return this.unpacked[group].length;
	}

	@ObfuscatedName("ch.v(I)I")
	public int getGroupCount() {
		return this.unpacked.length;
	}

	@ObfuscatedName("ch.w(II)V")
	public void discardFiles(int group) {
		for (int i = 0; i < this.unpacked[group].length; i++) {
			this.unpacked[group][i] = null;
		}
	}

	@ObfuscatedName("ch.e(I)V")
	public void discardAll() {
		for (int i = 0; i < this.unpacked.length; i++) {
			if (this.unpacked[i] != null) {
				for (int j = 0; j < this.unpacked[i].length; j++) {
					this.unpacked[i][j] = null;
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

		boolean alreadyUnpacked = true;
		for (int var7 = 0; var7 < groupSize; var7++) {
			if (unpacked[fileIds[var7]] == null) {
				alreadyUnpacked = false;
				break;
			}
		}

		if (alreadyUnpacked) {
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
	public int getGroupId(String group) {
		String lower = group.toLowerCase();
		return this.groupNameHashTable.get(JStringUtil.hashCode(lower));
	}

	@ObfuscatedName("ch.t(ILjava/lang/String;B)I")
	public int getFileId(int group, String file) {
		String lower = file.toLowerCase();
		return this.fileNameHashTables[group].get(JStringUtil.hashCode(lower));
	}

	@ObfuscatedName("ch.f(Ljava/lang/String;Ljava/lang/String;I)[B")
	public byte[] getFile(String group, String file) {
		String groupLower = group.toLowerCase();
		String fileLower = file.toLowerCase();
		int groupId = this.groupNameHashTable.get(JStringUtil.hashCode(groupLower));
		int fileId = this.fileNameHashTables[groupId].get(JStringUtil.hashCode(fileLower));
		return this.getFile(groupId, fileId);
	}

	@ObfuscatedName("ch.k(Ljava/lang/String;Ljava/lang/String;B)Z")
	public boolean requestDownload(String group, String file) {
		String groupLower = group.toLowerCase();
		String fileLower = file.toLowerCase();
		int groupId = this.groupNameHashTable.get(JStringUtil.hashCode(groupLower));
		int fileId = this.fileNameHashTables[groupId].get(JStringUtil.hashCode(fileLower));
		return this.requestDownload(groupId, fileId);
	}

	@ObfuscatedName("ch.o(Ljava/lang/String;I)V")
	public void method1056(String name) {
		String lower = name.toLowerCase();
		int groupId = this.groupNameHashTable.get(JStringUtil.hashCode(lower));
		if (groupId >= 0) {
			this.method1043(groupId);
		}
	}

	@ObfuscatedName("c.a([BI)[B")
	public static final byte[] decompress(byte[] data) {
		Packet buf = new Packet(data);
		int ctype = buf.g1();
		int clen = buf.g4();

		if (clen < 0 || maxsize != 0 && clen > maxsize) {
			throw new RuntimeException("ctype=" + ctype + " clen=" + clen + " maxsize=" + maxsize);
		}

		if (ctype == 0) {
			byte[] dest = new byte[clen];
			buf.gdata(dest, 0, clen);
			return dest;
		} else {
			int ulen = buf.g4();
			if (ulen < 0 || maxsize != 0 && ulen > maxsize) {
				throw new RuntimeException("ctype=" + ctype + " clen=" + clen + " ulen=" + ulen + " maxsize=" + maxsize);
			}

			byte[] dest = new byte[ulen];
			if (ctype == 1) {
				BZip2.decompress(dest, ulen, data, clen, 9);
			} else {
				gzip.decompress(buf, dest);
			}

			return dest;
		}
	}
}
