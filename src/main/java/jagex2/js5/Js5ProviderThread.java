package jagex2.js5;

import deob.ObfuscatedName;
import jagex2.client.JagException;
import jagex2.datastruct.LinkList;
import jagex2.datastruct.PreciseSleep;
import jagex2.io.FileStream;

@ObfuscatedName("cc")
public class Js5ProviderThread implements Runnable {

	@ObfuscatedName("cc.r")
	public static LinkList field1208 = new LinkList();

	@ObfuscatedName("cc.d")
	public static LinkList field1206 = new LinkList();

	@ObfuscatedName("cc.l")
	public static int field1205 = 0;

	@ObfuscatedName("cc.m")
	public static Object field1207 = new Object();

	@ObfuscatedName("cu.m(ILap;Ldq;I)V")
	public static void method1122(int arg0, FileStream arg1, Js5Provider arg2) {
		byte[] var3 = null;
		LinkList var4 = field1208;
		synchronized (field1208) {
			for (Js5NetProviderRequest var5 = (Js5NetProviderRequest) field1208.head(); var5 != null; var5 = (Js5NetProviderRequest) field1208.next()) {
				if ((long) arg0 == var5.key && var5.field1770 == arg1 && var5.field1772 == 0) {
					var3 = var5.field1771;
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
				LinkList var1 = field1208;
				Js5NetProviderRequest var2;
				synchronized (field1208) {
					var2 = (Js5NetProviderRequest) field1208.head();
				}
				if (var2 == null) {
					PreciseSleep.method1020(100L);
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
					if (var2.field1772 == 0) {
						var2.field1770.write((int) var2.key, var2.field1771, var2.field1771.length);
						LinkList var4 = field1208;
						synchronized (field1208) {
							var2.unlink();
						}
					} else if (var2.field1772 == 1) {
						var2.field1771 = var2.field1770.read((int) var2.key);
						LinkList var6 = field1208;
						synchronized (field1208) {
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
