package jagex3.js5;

import deob.ObfuscatedName;
import jagex3.client.JagException;
import jagex3.datastruct.LinkList;
import jagex3.datastruct.ThreadSleep;
import jagex3.io.DataFile;

// jag::oldscape::jagex3::Js5NetThread
@ObfuscatedName("cc")
public class Js5NetThread implements Runnable {

	@ObfuscatedName("cc.r")
	public static LinkList requestQueue = new LinkList();

	@ObfuscatedName("cc.d")
	public static LinkList field1206 = new LinkList();

	@ObfuscatedName("cc.l")
	public static int field1205 = 0;

	@ObfuscatedName("cc.m")
	public static Object field1207 = new Object();

	// jag::oldscape::jagex3::Js5LocalCache::BlockingFetchFromMainThread?
	@ObfuscatedName("cu.m(ILap;Ldq;I)V")
	public static void requestGroup(int key, DataFile fs, Js5Loader loader) {
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
			loader.method1468(fs, key, src, true);
		} else {
			loader.method1468(fs, key, data, true);
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
					Object var10 = field1207;
					synchronized (var10) {
						if (field1205 <= 1) {
							field1205 = 0;
							field1207.notifyAll();
							return;
						}

						field1205--;
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
							field1206.push(var2);
						}
					}

					Object var8 = field1207;
					synchronized (var8) {
						if (field1205 <= 1) {
							field1205 = 0;
							field1207.notifyAll();
							return;
						}

						field1205 = 600;
					}
				}
			}
		} catch (Exception ex) {
			JagException.report(null, ex);
		}
	}

	@ObfuscatedName("bv.c(B)V")
	public static void method781() {
		Object var0 = field1207;
		synchronized (var0) {
			if (field1205 != 0) {
				field1205 = 1;

				try {
					field1207.wait();
				} catch (InterruptedException ignore) {
				}
			}
		}
	}
}
