package jagex2.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("ce")
public class LruCache {

	@ObfuscatedName("ce.r")
	public DoublyLinkable field1487 = new DoublyLinkable();

	@ObfuscatedName("ce.d")
	public int capacity;

	@ObfuscatedName("ce.l")
	public int available;

	@ObfuscatedName("ce.m")
	public HashTable hashtable;

	@ObfuscatedName("ce.c")
	public DoublyLinkList history = new DoublyLinkList();

	public LruCache(int arg0) {
		this.capacity = arg0;
		this.available = arg0;
		int var2;
		for (var2 = 1; var2 + var2 < arg0; var2 += var2) {
		}
		this.hashtable = new HashTable(var2);
	}

	@ObfuscatedName("ce.r(J)Len;")
	public DoublyLinkable get(long arg0) {
		DoublyLinkable var3 = (DoublyLinkable) this.hashtable.get(arg0);
		if (var3 != null) {
			this.history.push(var3);
		}
		return var3;
	}

	@ObfuscatedName("ce.d(J)V")
	public void remove(long arg0) {
		DoublyLinkable var3 = (DoublyLinkable) this.hashtable.get(arg0);
		if (var3 != null) {
			var3.unlink();
			var3.unlink2();
			this.available++;
		}
	}

	@ObfuscatedName("ce.l(Len;J)V")
	public void put(DoublyLinkable arg0, long arg1) {
		if (this.available == 0) {
			DoublyLinkable var4 = this.history.pop();
			var4.unlink();
			var4.unlink2();
			if (this.field1487 == var4) {
				DoublyLinkable var5 = this.history.pop();
				var5.unlink();
				var5.unlink2();
			}
		} else {
			this.available--;
		}
		this.hashtable.put(arg0, arg1);
		this.history.push(arg0);
	}

	@ObfuscatedName("ce.m()V")
	public void clear() {
		this.history.clear();
		this.hashtable.clear();
		this.field1487 = new DoublyLinkable();
		this.available = this.capacity;
	}
}
