package jagex3.js5;

import deob.ObfuscatedName;
import jagex3.client.GameShell;
import jagex3.datastruct.LinkList;
import jagex3.io.ByteArrayWrapper;
import jagex3.io.DataFile;
import jagex3.io.Packet;

import java.util.zip.CRC32;

// jag::oldscape::jagex3::Js5Loader
@ObfuscatedName("dq")
public class Js5Loader extends Js5 {

	@ObfuscatedName("dq.f")
	public DataFile dataFile;

	@ObfuscatedName("dq.k")
	public DataFile indexDataFile;

	@ObfuscatedName("dq.o")
	public int archive;

	@ObfuscatedName("dq.a")
	public volatile boolean loadStatus = false;

	@ObfuscatedName("dq.h")
	public boolean remoteEnabled = false;

	@ObfuscatedName("dq.x")
	public volatile boolean[] loadedGroups;

	@ObfuscatedName("dq.p")
	public static CRC32 crc32 = new CRC32();

	@ObfuscatedName("dq.ad")
	public int indexCrc;

	@ObfuscatedName("dq.ac")
	public int indexVersion;

	@ObfuscatedName("dq.aa")
	public int field1581 = -1;

	public Js5Loader(DataFile dat, DataFile idx, int archive, boolean discardPacked, boolean discardUnpacked, boolean arg5) {
		super(discardPacked, discardUnpacked);

		this.dataFile = dat;
		this.indexDataFile = idx;
		this.archive = archive;
		this.remoteEnabled = arg5;

		int var8 = this.archive;
		if (Js5Net.masterIndexBuffer == null) {
			Js5Net.queueRequest(null, 255, 255, 0, (byte) 0, true);
			Js5Net.field1200[var8] = this;
		} else {
			Js5Net.masterIndexBuffer.pos = var8 * 8 + 5;

			int crc = Js5Net.masterIndexBuffer.g4();
			int version = Js5Net.masterIndexBuffer.g4();
			this.requestIndex(crc, version);
		}
	}

	@ObfuscatedName("dq.bo(B)I")
	public int getIndexPercentage() {
		if (this.loadStatus) {
			return 100;
		} else if (this.packed == null) {
			int var1 = Js5Net.transferProgress(255, this.archive);
			if (var1 >= 100) {
				var1 = 99;
			}
			return var1;
		} else {
			return 99;
		}
	}

	// jag::oldscape::jagex3::Js5Loader::UpdateCacheHint
	@ObfuscatedName("dq.d(IB)V")
	public void updateCacheHint(int groupId) {
		Js5Net.updateCacheHint(this.archive, groupId);
	}

	@ObfuscatedName("dq.i(IB)V")
	public void requestGroupDownload2(int groupId) {
		if (this.dataFile == null || this.loadedGroups == null || !this.loadedGroups[groupId]) {
			Js5Net.queueRequest(this, this.archive, groupId, this.groupChecksums[groupId], (byte) 2, true);
		} else {
			Js5NetThread.queueRequest(groupId, this.dataFile, this);
		}
	}

	@ObfuscatedName("dq.bq(III)V")
	public void requestIndex(int crc, int version) {
		this.indexCrc = crc;
		this.indexVersion = version;

		if (this.indexDataFile == null) {
			Js5Net.queueRequest(this, 255, this.archive, this.indexCrc, (byte) 0, true);
		} else {
			Js5NetThread.queueRequest(this.archive, this.indexDataFile, this);
		}
	}

	@ObfuscatedName("dq.bj(I[BZZB)V")
	public void write(int arg0, byte[] arg1, boolean arg2, boolean arg3) {
		if (!arg2) {
			arg1[arg1.length - 2] = (byte) (this.groupVersions[arg0] >> 8);
			arg1[arg1.length - 1] = (byte) this.groupVersions[arg0];
			if (this.dataFile != null) {
				// todo: inlined method?
				DataFile var12 = this.dataFile;
				Js5WorkerRequest var13 = new Js5WorkerRequest();
				var13.type = 0;
				var13.key = arg0;
				var13.data = arg1;
				var13.fs = var12;
				LinkList var14 = Js5NetThread.requestQueue;
				synchronized (var14) {
					Js5NetThread.requestQueue.push(var13);
				}
				Object var16 = Js5NetThread.lock;
				synchronized (var16) {
					if (Js5NetThread.keepAlive == 0) {
						GameShell.signLink.threadreq(new Js5NetThread(), 5);
					}
					Js5NetThread.keepAlive = 600;
				}
				this.loadedGroups[arg0] = true;
			}
			if (arg3) {
				this.packed[arg0] = ByteArrayWrapper.wrap(arg1, false);
			}
			return;
		}
		if (this.loadStatus) {
			throw new RuntimeException();
		}
		if (this.indexDataFile != null) {
			int var5 = this.archive;
			DataFile var6 = this.indexDataFile;
			Js5WorkerRequest var7 = new Js5WorkerRequest();
			var7.type = 0;
			var7.key = var5;
			var7.data = arg1;
			var7.fs = var6;
			LinkList var8 = Js5NetThread.requestQueue;
			synchronized (var8) {
				Js5NetThread.requestQueue.push(var7);
			}
			Object var10 = Js5NetThread.lock;
			synchronized (var10) {
				if (Js5NetThread.keepAlive == 0) {
					GameShell.signLink.threadreq(new Js5NetThread(), 5);
				}
				Js5NetThread.keepAlive = 600;
			}
		}
		this.decodeIndex(arg1);
		this.loadAllLocal();
	}

	// jag::oldscape::jagex3::Js5Loader::Js5ForLoader::LoadIndex
	@ObfuscatedName("dq.bz(Lap;I[BZI)V")
	public void loadIndex(DataFile idx, int groupId, byte[] src, boolean urgent) {
		if (this.indexDataFile != idx) {
			if (!urgent && this.field1581 == groupId) {
				this.loadStatus = true;
			}

			if (src == null || src.length <= 2) {
				this.loadedGroups[groupId] = false;
				if (this.remoteEnabled || urgent) {
					Js5Net.queueRequest(this, this.archive, groupId, this.groupChecksums[groupId], (byte) 2, urgent);
				}
				return;
			}

			crc32.reset();
			crc32.update(src, 0, src.length - 2);

			int var9 = (int) crc32.getValue();
			int var10 = ((src[src.length - 2] & 0xFF) << 8) + (src[src.length - 1] & 0xFF);

			if (this.groupChecksums[groupId] != var9 || this.groupVersions[groupId] != var10) {
				this.loadedGroups[groupId] = false;
				if (this.remoteEnabled || urgent) {
					Js5Net.queueRequest(this, this.archive, groupId, this.groupChecksums[groupId], (byte) 2, urgent);
				}
			} else {
				this.loadedGroups[groupId] = true;
				if (urgent) {
					this.packed[groupId] = ByteArrayWrapper.wrap(src, false);
				}
			}

			return;
		}

		if (this.loadStatus) {
			throw new RuntimeException();
		}

		if (src == null) {
			Js5Net.queueRequest(this, 255, this.archive, this.indexCrc, (byte) 0, true);
			return;
		}

		crc32.reset();
		crc32.update(src, 0, src.length);

		int crc = (int) crc32.getValue();
		Packet buf = new Packet(Js5.getUncompressedPacket(src));

		int protocol = buf.g1();
		if (protocol != 5 && protocol != 6) {
			throw new RuntimeException("Incorrect JS5 protocol number: " + protocol);
		}

		int version = 0;
		if (protocol >= 6) {
			version = buf.g4();
		}

		if (this.indexCrc != crc || this.indexVersion != version) {
			Js5Net.queueRequest(this, 255, this.archive, this.indexCrc, (byte) 0, true);
			return;
		}

		this.decodeIndex(src);
		this.loadAllLocal();
	}

	@ObfuscatedName("dq.bm(S)V")
	public void loadAllLocal() {
		this.loadedGroups = new boolean[this.packed.length];
		for (int var1 = 0; var1 < this.loadedGroups.length; var1++) {
			this.loadedGroups[var1] = false;
		}
		if (this.dataFile == null) {
			this.loadStatus = true;
			return;
		}
		this.field1581 = -1;
		for (int var2 = 0; var2 < this.loadedGroups.length; var2++) {
			if (this.groupSizes[var2] > 0) {
				DataFile var3 = this.dataFile;
				Js5WorkerRequest var5 = new Js5WorkerRequest();
				var5.type = 1;
				var5.key = var2;
				var5.fs = var3;
				var5.field1773 = this;
				LinkList var6 = Js5NetThread.requestQueue;
				synchronized (var6) {
					Js5NetThread.requestQueue.push(var5);
				}
				Object var8 = Js5NetThread.lock;
				synchronized (var8) {
					if (Js5NetThread.keepAlive == 0) {
						GameShell.signLink.threadreq(new Js5NetThread(), 5);
					}
					Js5NetThread.keepAlive = 600;
				}
				this.field1581 = var2;
			}
		}
		if (this.field1581 == -1) {
			this.loadStatus = true;
		}
	}

	@ObfuscatedName("dq.bn(II)I")
	public int getGroupLoadProgress(int arg0) {
		if (this.packed[arg0] == null) {
			return this.loadedGroups[arg0] ? 100 : Js5Net.transferProgress(this.archive, arg0);
		} else {
			return 100;
		}
	}

	@ObfuscatedName("dq.be(I)I")
	public int getIndexLoadProgress() {
		int var1 = 0;
		int var2 = 0;
		for (int var3 = 0; var3 < this.packed.length; var3++) {
			if (this.groupSizes[var3] > 0) {
				var1 += 100;
				var2 += this.getGroupLoadProgress(var3);
			}
		}
		if (var1 == 0) {
			return 100;
		} else {
			return var2 * 100 / var1;
		}
	}
}
