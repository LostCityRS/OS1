package jagex3.js5;

import deob.ObfuscatedName;
import jagex3.client.applet.GameShell;
import jagex3.datastruct.ByteArrayCopier;
import jagex3.datastruct.LinkList;
import jagex3.io.FileStream;
import jagex3.io.Packet;

import java.util.zip.CRC32;

// jag::oldscape::jagex3::Js5Loader
@ObfuscatedName("dq")
public class Js5Loader extends Js5 {

	@ObfuscatedName("dq.f")
	public FileStream fileStream;

	@ObfuscatedName("dq.k")
	public FileStream indexFileStream;

	@ObfuscatedName("dq.o")
	public int archive;

	@ObfuscatedName("dq.a")
	public volatile boolean loadStatus = false;

	@ObfuscatedName("dq.h")
	public boolean field1576 = false;

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

	public Js5Loader(FileStream arg0, FileStream arg1, int archive, boolean discardPacked, boolean discardUnpacked, boolean arg5) {
		super(discardPacked, discardUnpacked);

		this.fileStream = arg0;
		this.indexFileStream = arg1;
		this.archive = archive;
		this.field1576 = arg5;

		int var8 = this.archive;
		if (Js5Net.masterIndexBuffer == null) {
			Js5Net.queueRequest(null, 255, 255, 0, (byte) 0, true);
			Js5Net.field1200[var8] = this;
		} else {
			Js5Net.masterIndexBuffer.pos = var8 * 8 + 5;
			int var9 = Js5Net.masterIndexBuffer.g4();
			int var10 = Js5Net.masterIndexBuffer.g4();
			this.method1476(var9, var10);
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

	@ObfuscatedName("dq.d(IB)V")
	public void download(int arg0) {
		Js5Net.prioritizeRequest(this.archive, arg0);
	}

	@ObfuscatedName("dq.i(IB)V")
	public void fetchGroup(int arg0) {
		if (this.fileStream == null || this.loadedGroups == null || !this.loadedGroups[arg0]) {
			Js5Net.queueRequest(this, this.archive, arg0, this.groupChecksums[arg0], (byte) 2, true);
		} else {
			Js5NetThread.method1122(arg0, this.fileStream, this);
		}
	}

	@ObfuscatedName("dq.bq(III)V")
	public void method1476(int arg0, int arg1) {
		this.indexCrc = arg0;
		this.indexVersion = arg1;
		if (this.indexFileStream == null) {
			Js5Net.queueRequest(this, 255, this.archive, this.indexCrc, (byte) 0, true);
		} else {
			Js5NetThread.method1122(this.archive, this.indexFileStream, this);
		}
	}

	@ObfuscatedName("dq.bj(I[BZZB)V")
	public void write(int arg0, byte[] arg1, boolean arg2, boolean arg3) {
		if (!arg2) {
			arg1[arg1.length - 2] = (byte) (this.groupVersions[arg0] >> 8);
			arg1[arg1.length - 1] = (byte) this.groupVersions[arg0];
			if (this.fileStream != null) {
				// todo: inlined method?
				FileStream var12 = this.fileStream;
				Js5WorkerRequest var13 = new Js5WorkerRequest();
				var13.type = 0;
				var13.key = arg0;
				var13.data = arg1;
				var13.fs = var12;
				LinkList var14 = Js5NetThread.requestQueue;
				synchronized (var14) {
					Js5NetThread.requestQueue.push(var13);
				}
				Object var16 = Js5NetThread.field1207;
				synchronized (var16) {
					if (Js5NetThread.field1205 == 0) {
						GameShell.taskHandler.threadreq(new Js5NetThread(), 5);
					}
					Js5NetThread.field1205 = 600;
				}
				this.loadedGroups[arg0] = true;
			}
			if (arg3) {
				this.packed[arg0] = ByteArrayCopier.method1131(arg1, false);
			}
			return;
		}
		if (this.loadStatus) {
			throw new RuntimeException();
		}
		if (this.indexFileStream != null) {
			int var5 = this.archive;
			FileStream var6 = this.indexFileStream;
			Js5WorkerRequest var7 = new Js5WorkerRequest();
			var7.type = 0;
			var7.key = var5;
			var7.data = arg1;
			var7.fs = var6;
			LinkList var8 = Js5NetThread.requestQueue;
			synchronized (var8) {
				Js5NetThread.requestQueue.push(var7);
			}
			Object var10 = Js5NetThread.field1207;
			synchronized (var10) {
				if (Js5NetThread.field1205 == 0) {
					GameShell.taskHandler.threadreq(new Js5NetThread(), 5);
				}
				Js5NetThread.field1205 = 600;
			}
		}
		this.decodeIndex(arg1);
		this.loadAllLocal();
	}

	@ObfuscatedName("dq.bz(Lap;I[BZI)V")
	public void method1468(FileStream arg0, int arg1, byte[] arg2, boolean arg3) {
		if (this.indexFileStream != arg0) {
			if (!arg3 && this.field1581 == arg1) {
				this.loadStatus = true;
			}
			if (arg2 == null || arg2.length <= 2) {
				this.loadedGroups[arg1] = false;
				if (this.field1576 || arg3) {
					Js5Net.queueRequest(this, this.archive, arg1, this.groupChecksums[arg1], (byte) 2, arg3);
				}
				return;
			}
			crc32.reset();
			crc32.update(arg2, 0, arg2.length - 2);
			int var9 = (int) crc32.getValue();
			int var10 = ((arg2[arg2.length - 2] & 0xFF) << 8) + (arg2[arg2.length - 1] & 0xFF);
			if (this.groupChecksums[arg1] != var9 || this.groupVersions[arg1] != var10) {
				this.loadedGroups[arg1] = false;
				if (this.field1576 || arg3) {
					Js5Net.queueRequest(this, this.archive, arg1, this.groupChecksums[arg1], (byte) 2, arg3);
				}
				return;
			}
			this.loadedGroups[arg1] = true;
			if (arg3) {
				this.packed[arg1] = ByteArrayCopier.method1131(arg2, false);
			}
			return;
		}
		if (this.loadStatus) {
			throw new RuntimeException();
		}
		if (arg2 == null) {
			Js5Net.queueRequest(this, 255, this.archive, this.indexCrc, (byte) 0, true);
			return;
		}
		crc32.reset();
		crc32.update(arg2, 0, arg2.length);
		int var5 = (int) crc32.getValue();
		Packet var6 = new Packet(Js5.decompress(arg2));
		int var7 = var6.g1();
		if (var7 != 5 && var7 != 6) {
			throw new RuntimeException("");
		}
		int var8 = 0;
		if (var7 >= 6) {
			var8 = var6.g4();
		}
		if (this.indexCrc != var5 || this.indexVersion != var8) {
			Js5Net.queueRequest(this, 255, this.archive, this.indexCrc, (byte) 0, true);
			return;
		}
		this.decodeIndex(arg2);
		this.loadAllLocal();
	}

	@ObfuscatedName("dq.bm(S)V")
	public void loadAllLocal() {
		this.loadedGroups = new boolean[this.packed.length];
		for (int var1 = 0; var1 < this.loadedGroups.length; var1++) {
			this.loadedGroups[var1] = false;
		}
		if (this.fileStream == null) {
			this.loadStatus = true;
			return;
		}
		this.field1581 = -1;
		for (int var2 = 0; var2 < this.loadedGroups.length; var2++) {
			if (this.groupSizes[var2] > 0) {
				FileStream var3 = this.fileStream;
				Js5WorkerRequest var5 = new Js5WorkerRequest();
				var5.type = 1;
				var5.key = var2;
				var5.fs = var3;
				var5.field1773 = this;
				LinkList var6 = Js5NetThread.requestQueue;
				synchronized (var6) {
					Js5NetThread.requestQueue.push(var5);
				}
				Object var8 = Js5NetThread.field1207;
				synchronized (var8) {
					if (Js5NetThread.field1205 == 0) {
						GameShell.taskHandler.threadreq(new Js5NetThread(), 5);
					}
					Js5NetThread.field1205 = 600;
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
