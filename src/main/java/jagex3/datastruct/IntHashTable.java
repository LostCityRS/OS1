package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("cn")
public class IntHashTable {

	@ObfuscatedName("cn.r")
	public int[] buckets;

	public IntHashTable(int[] keys) {
		int bucketCount;
		for (bucketCount = 1; bucketCount <= (keys.length >> 1) + keys.length; bucketCount <<= 0x1) {
		}

		this.buckets = new int[bucketCount + bucketCount];
		for (int i = 0; i < bucketCount + bucketCount; i++) {
			this.buckets[i] = -1;
		}

		int value = 0;
		while (value < keys.length) {
			int hash;
			for (hash = keys[value] & bucketCount - 1; this.buckets[hash + hash + 1] != -1; hash = hash + 1 & bucketCount - 1) {
			}

			this.buckets[hash + hash] = keys[value];
			this.buckets[hash + hash + 1] = value++;
		}
	}

	@ObfuscatedName("cn.r(I)I")
	public int find(int key) {
		int mask = (this.buckets.length >> 1) - 1;
		int hash = key & mask;
		while (true) {
			int value = this.buckets[hash + hash + 1];
			if (value == -1) {
				return -1;
			}

			if (this.buckets[hash + hash] == key) {
				return value;
			}

			hash = hash + 1 & mask;
		}
	}
}
