package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("cf")
public class HashTable {

	@ObfuscatedName("cf.r")
	public int bucketCount;

	@ObfuscatedName("cf.d")
	public Linkable[] buckets;

	@ObfuscatedName("cf.l")
	public Linkable sentinel;

	@ObfuscatedName("cf.m")
	public Linkable field1495;

	@ObfuscatedName("cf.c")
	public int field1499 = 0;

	public HashTable(int arg0) {
		this.bucketCount = arg0;
		this.buckets = new Linkable[arg0];
		for (int var2 = 0; var2 < arg0; var2++) {
			Linkable var3 = this.buckets[var2] = new Linkable();
			var3.next = var3;
			var3.prev = var3;
		}
	}

	@ObfuscatedName("cf.r(J)Ldg;")
	public Linkable find(long arg0) {
		Linkable var3 = this.buckets[(int) (arg0 & (long) (this.bucketCount - 1))];
		for (this.sentinel = var3.next; this.sentinel != var3; this.sentinel = this.sentinel.next) {
			if (this.sentinel.key == arg0) {
				Linkable var4 = this.sentinel;
				this.sentinel = this.sentinel.next;
				return var4;
			}
		}
		this.sentinel = null;
		return null;
	}

	@ObfuscatedName("cf.d(Ldg;J)V")
	public void put(Linkable arg0, long arg1) {
		if (arg0.prev != null) {
			arg0.unlink();
		}
		Linkable var4 = this.buckets[(int) (arg1 & (long) (this.bucketCount - 1))];
		arg0.prev = var4.prev;
		arg0.next = var4;
		arg0.prev.next = arg0;
		arg0.next.prev = arg0;
		arg0.key = arg1;
	}

	@ObfuscatedName("cf.l()V")
	public void clear() {
		for (int var1 = 0; var1 < this.bucketCount; var1++) {
			Linkable var2 = this.buckets[var1];
			while (true) {
				Linkable var3 = var2.next;
				if (var2 == var3) {
					break;
				}
				var3.unlink();
			}
		}
		this.sentinel = null;
		this.field1495 = null;
	}

	@ObfuscatedName("cf.m()Ldg;")
	public Linkable first() {
		this.field1499 = 0;
		return this.findnext();
	}

	@ObfuscatedName("cf.c()Ldg;")
	public Linkable findnext() {
		if (this.field1499 > 0 && this.buckets[this.field1499 - 1] != this.field1495) {
			Linkable var1 = this.field1495;
			this.field1495 = var1.next;
			return var1;
		}
		Linkable var2;
		do {
			if (this.field1499 >= this.bucketCount) {
				return null;
			}
			var2 = this.buckets[this.field1499++].next;
		} while (this.buckets[this.field1499 - 1] == var2);
		this.field1495 = var2.next;
		return var2;
	}
}
