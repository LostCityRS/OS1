package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("cf")
public class HashTable {

	@ObfuscatedName("cf.r")
	public int bucketCount;

	@ObfuscatedName("cf.d")
	public Linkable[] buckets;

	@ObfuscatedName("cf.l")
	public Linkable searchCursor;

	@ObfuscatedName("cf.m")
	public Linkable iteratorCursor;

	@ObfuscatedName("cf.c")
	public int iteratorBucket = 0;

	public HashTable(int bucketCount) {
		this.bucketCount = bucketCount;
		this.buckets = new Linkable[bucketCount];
		for (int i = 0; i < bucketCount; i++) {
			Linkable sentinel = this.buckets[i] = new Linkable();
			sentinel.next = sentinel;
			sentinel.prev = sentinel;
		}
	}

	@ObfuscatedName("cf.r(J)Ldg;")
	public Linkable find(long key) {
		Linkable sentinel = this.buckets[(int) (key & (long) (this.bucketCount - 1))];
		for (this.searchCursor = sentinel.next; this.searchCursor != sentinel; this.searchCursor = this.searchCursor.next) {
			if (this.searchCursor.key == key) {
				Linkable value = this.searchCursor;
				this.searchCursor = this.searchCursor.next;
				return value;
			}
		}

		this.searchCursor = null;
		return null;
	}

	@ObfuscatedName("cf.d(Ldg;J)V")
	public void put(Linkable node, long key) {
		if (node.prev != null) {
			node.unlink();
		}

		Linkable sentinel = this.buckets[(int) (key & (long) (this.bucketCount - 1))];
		node.prev = sentinel.prev;
		node.next = sentinel;
		node.prev.next = node;
		node.next.prev = node;
		node.key = key;
	}

	@ObfuscatedName("cf.l()V")
	public void clear() {
		for (int i = 0; i < this.bucketCount; i++) {
			Linkable sentinel = this.buckets[i];
			while (true) {
				Linkable node = sentinel.next;
				if (sentinel == node) {
					break;
				}

				node.unlink();
			}
		}

		this.searchCursor = null;
		this.iteratorCursor = null;
	}

	@ObfuscatedName("cf.m()Ldg;")
	public Linkable search() {
		this.iteratorBucket = 0;
		return this.findnext();
	}

	@ObfuscatedName("cf.c()Ldg;")
	public Linkable findnext() {
		if (this.iteratorBucket > 0 && this.buckets[this.iteratorBucket - 1] != this.iteratorCursor) {
			Linkable node = this.iteratorCursor;
			this.iteratorCursor = node.next;
			return node;
		}

		Linkable node;
		do {
			if (this.iteratorBucket >= this.bucketCount) {
				return null;
			}

			node = this.buckets[this.iteratorBucket++].next;
		} while (this.buckets[this.iteratorBucket - 1] == node);

		this.iteratorCursor = node.next;
		return node;
	}
}
