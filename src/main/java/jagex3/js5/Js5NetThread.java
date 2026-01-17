package jagex3.js5;

import deob.ObfuscatedName;
import jagex3.client.JagException;
import jagex3.datastruct.LinkList;
import jagex3.datastruct.PreciseSleep;
import jagex3.io.FileStream;

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

	@ObfuscatedName("cu.m(ILap;Ldq;I)V")
	public static void queueRequest(int arg0, FileStream arg1, Js5Loader arg2) {
		byte[] var3 = null;
		LinkList var4 = requestQueue;
		synchronized (requestQueue) {
			for (Js5WorkerRequest var5 = (Js5WorkerRequest) requestQueue.head(); var5 != null; var5 = (Js5WorkerRequest) requestQueue.next()) {
				if ((long) arg0 == var5.key && var5.fs == arg1 && var5.type == 0) {
					var3 = var5.data;
					break;
				}
			}
		}
		if (var3 == null) {
			byte[] var7 = arg1.read(arg0);
			arg2.method1468(arg1, arg0, var7, true);
		} else {
			arg2.method1468(arg1, arg0, var3, true);
		}
	}

	public void run() {
		try {
			while (true) {
				LinkList var1 = requestQueue;
				Js5WorkerRequest var2;
				synchronized (requestQueue) {
					var2 = (Js5WorkerRequest) requestQueue.head();
				}
				if (var2 == null) {
					PreciseSleep.sleep(100L);
					Object var10 = field1207;
					synchronized (field1207) {
						if (field1205 <= 1) {
							field1205 = 0;
							field1207.notifyAll();
							return;
						}
						field1205--;
					}
				} else {
					if (var2.type == 0) {
						var2.fs.write((int) var2.key, var2.data, var2.data.length);
						LinkList var4 = requestQueue;
						synchronized (requestQueue) {
							var2.unlink();
						}
					} else if (var2.type == 1) {
						var2.data = var2.fs.read((int) var2.key);
						LinkList var6 = requestQueue;
						synchronized (requestQueue) {
							field1206.push(var2);
						}
					}
					Object var8 = field1207;
					synchronized (field1207) {
						if (field1205 <= 1) {
							field1205 = 0;
							field1207.notifyAll();
							return;
						}
						field1205 = 600;
					}
				}
			}
		} catch (Exception var18) {
			JagException.report(null, (Throwable) var18);
		}
	}

	@ObfuscatedName("bv.c(B)V")
	public static void method781() {
		Object var0 = field1207;
		synchronized (field1207) {
			if (field1205 != 0) {
				field1205 = 1;
				try {
					field1207.wait();
				} catch (InterruptedException var3) {
				}
			}
		}
	}
}
