package jagex2.js5;

import deob.ObfuscatedName;
import jagex2.client.JagException;
import jagex2.datastruct.LinkList;
import jagex2.datastruct.PreciseSleep;

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

	public void run() {
		try {
			while (true) {
				LinkList var1 = field1208;
				Js5NetProviderRequest var2;
				synchronized (field1208) {
					var2 = (Js5NetProviderRequest) field1208.method1297();
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
						var2.field1770.method410((int) var2.field1506, var2.field1771, var2.field1771.length);
						LinkList var4 = field1208;
						synchronized (field1208) {
							var2.method1325();
						}
					} else if (var2.field1772 == 1) {
						var2.field1771 = var2.field1770.method418((int) var2.field1506);
						LinkList var6 = field1208;
						synchronized (field1208) {
							field1206.method1292(var2);
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
			JagException.method1490(null, var18);
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
