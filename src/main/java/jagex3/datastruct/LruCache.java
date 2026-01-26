package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("ce")
public class LruCache {

	@ObfuscatedName("ce.r")
	public Linkable2 sentinel = new Linkable2();

	@ObfuscatedName("ce.d")
	public int capacity;

	@ObfuscatedName("ce.l")
	public int available;

	@ObfuscatedName("ce.m")
	public HashTable cache;

	@ObfuscatedName("ce.c")
	public LinkList2 order = new LinkList2();

	public LruCache(int capacity) {
		this.capacity = capacity;
		this.available = capacity;

		int bucketCount;
		for (bucketCount = 1; bucketCount + bucketCount < capacity; bucketCount += bucketCount) {
		}

		this.cache = new HashTable(bucketCount);
	}

	@ObfuscatedName("ce.r(J)Len;")
	public Linkable2 find(long key) {
		Linkable2 node = (Linkable2) this.cache.find(key);
		if (node != null) {
			this.order.push(node);
		}
		return node;
	}

	@ObfuscatedName("ce.d(J)V")
	public void remove(long key) {
		Linkable2 node = (Linkable2) this.cache.find(key);
		if (node != null) {
			node.unlink();
			node.unlink2();
			this.available++;
		}
	}

	@ObfuscatedName("ce.l(Len;J)V")
	public void put(Linkable2 node, long key) {
		if (this.available == 0) {
			Linkable2 first = this.order.shift();
			first.unlink();
			first.unlink2();

			if (this.sentinel == first) {
				Linkable2 second = this.order.shift();
				second.unlink();
				second.unlink2();
			}
		} else {
			this.available--;
		}

		this.cache.put(node, key);
		this.order.push(node);
	}

	@ObfuscatedName("ce.m()V")
	public void clear() {
		this.order.clear();
		this.cache.clear();
		this.sentinel = new Linkable2();
		this.available = this.capacity;
	}
}
