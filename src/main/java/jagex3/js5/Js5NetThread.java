package jagex3.js5;

import deob.ObfuscatedName;
import jagex3.callstack.JagException;
import jagex3.datastruct.LinkList;
import jagex3.io.net.DataFile;
import jagex3.util.ThreadSleep;

// jag::oldscape::jagex3::Js5NetThread
@ObfuscatedName("cc")
public class Js5NetThread implements Runnable {

	@ObfuscatedName("cc.r")
	public static LinkList requestQueue = new LinkList();

	@ObfuscatedName("cc.d")
	public static LinkList completed = new LinkList();

	@ObfuscatedName("cc.l")
	public static int keepAlive = 0;

	@ObfuscatedName("cc.m")
	public static Object lock = new Object();

	// jag::oldscape::jagex3::Js5LocalCache::BlockingFetchFromMainThread?
	@ObfuscatedName("cu.m(ILap;Ldq;I)V")
	public static void queueRequest(int key, DataFile fs, Js5Loader loader) {
		byte[] data = null;
		LinkList var4 = requestQueue;
		synchronized (var4) {
			for (Js5WorkerRequest req = (Js5WorkerRequest) requestQueue.head(); req != null; req = (Js5WorkerRequest) requestQueue.next()) {
				if ((long) key == req.key && req.fs == fs && req.type == 0) {
					data = req.data;
					break;
				}
			}
		}

		if (data == null) {
			byte[] src = fs.readFromFile(key);
			loader.loadIndex(fs, key, src, true);
		} else {
			loader.loadIndex(fs, key, data, true);
		}
	}

	public void run() {
		try {
			while (true) {
				LinkList var1 = requestQueue;

				Js5WorkerRequest var2;
				synchronized (var1) {
					var2 = (Js5WorkerRequest) requestQueue.head();
				}

				if (var2 == null) {
					ThreadSleep.sleepPrecise(100L);
					Object var10 = lock;
					synchronized (var10) {
						if (keepAlive <= 1) {
							keepAlive = 0;
							lock.notifyAll();
							return;
						}

						keepAlive--;
					}
				} else {
					if (var2.type == 0) {
						var2.fs.writeToFile((int) var2.key, var2.data, var2.data.length);
						LinkList var4 = requestQueue;
						synchronized (var4) {
							var2.unlink();
						}
					} else if (var2.type == 1) {
						var2.data = var2.fs.readFromFile((int) var2.key);
						LinkList var6 = requestQueue;
						synchronized (var6) {
							completed.push(var2);
						}
					}

					Object var8 = lock;
					synchronized (var8) {
						if (keepAlive <= 1) {
							keepAlive = 0;
							lock.notifyAll();
							return;
						}

						keepAlive = 600;
					}
				}
			}
		} catch (Exception ex) {
			JagException.report(null, ex);
		}
	}

	@ObfuscatedName("bv.c(B)V")
	public static void shutdown() {
		Object var0 = lock;
		synchronized (var0) {
			if (keepAlive != 0) {
				keepAlive = 1;

				try {
					lock.wait();
				} catch (InterruptedException ignore) {
				}
			}
		}
	}
}
