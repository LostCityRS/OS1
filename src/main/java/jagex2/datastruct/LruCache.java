package jagex2.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("ce")
public class LruCache {

	@ObfuscatedName("ce.r")
	public DoublyLinkable field1487 = new DoublyLinkable();

	@ObfuscatedName("ce.d")
	public int field1490;

	@ObfuscatedName("ce.l")
	public int field1489;

	@ObfuscatedName("ce.m")
	public HashTable field1488;

	@ObfuscatedName("ce.c")
	public DoublyLinkList field1491 = new DoublyLinkList();

	public LruCache(int arg0) {
		this.field1490 = arg0;
		this.field1489 = arg0;
		int var2;
		for (var2 = 1; var2 + var2 < arg0; var2 += var2) {
		}
		this.field1488 = new HashTable(var2);
	}

	@ObfuscatedName("ce.r(J)Len;")
	public DoublyLinkable method1244(long arg0) {
		DoublyLinkable var3 = (DoublyLinkable) this.field1488.method1277(arg0);
		if (var3 != null) {
			this.field1491.method1256(var3);
		}
		return var3;
	}

	@ObfuscatedName("ce.d(J)V")
	public void method1245(long arg0) {
		DoublyLinkable var3 = (DoublyLinkable) this.field1488.method1277(arg0);
		if (var3 != null) {
			var3.method1325();
			var3.method1841();
			this.field1489++;
		}
	}

	@ObfuscatedName("ce.l(Len;J)V")
	public void method1246(DoublyLinkable arg0, long arg1) {
		if (this.field1489 == 0) {
			DoublyLinkable var4 = this.field1491.method1258();
			var4.method1325();
			var4.method1841();
			if (this.field1487 == var4) {
				DoublyLinkable var5 = this.field1491.method1258();
				var5.method1325();
				var5.method1841();
			}
		} else {
			this.field1489--;
		}
		this.field1488.method1278(arg0, arg1);
		this.field1491.method1256(arg0);
	}

	@ObfuscatedName("ce.m()V")
	public void method1253() {
		this.field1491.method1260();
		this.field1488.method1283();
		this.field1487 = new DoublyLinkable();
		this.field1489 = this.field1490;
	}
}
