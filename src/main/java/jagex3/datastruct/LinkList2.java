package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("ci")
public class LinkList2 {

	@ObfuscatedName("ci.r")
	public Linkable2 sentinel = new Linkable2();

	public LinkList2() {
		this.sentinel.next2 = this.sentinel;
		this.sentinel.prev2 = this.sentinel;
	}

	@ObfuscatedName("ci.r(Len;)V")
	public void push(Linkable2 node) {
		if (node.prev2 != null) {
			node.unlink2();
		}

		node.prev2 = this.sentinel.prev2;
		node.next2 = this.sentinel;
		node.prev2.next2 = node;
		node.next2.prev2 = node;
	}

	@ObfuscatedName("ci.d(Len;)V")
	public void pushFront(Linkable2 node) {
		if (node.prev2 != null) {
			node.unlink2();
		}

		node.prev2 = this.sentinel;
		node.next2 = this.sentinel.next2;
		node.prev2.next2 = node;
		node.next2.prev2 = node;
	}

	@ObfuscatedName("ci.l()Len;")
	public Linkable2 popFront() {
		Linkable2 node = this.sentinel.next2;
		if (this.sentinel == node) {
			return null;
		} else {
			node.unlink2();
			return node;
		}
	}

	@ObfuscatedName("ci.m()Len;")
	public Linkable2 next() {
		Linkable2 node = this.sentinel.next2;
		if (this.sentinel == node) {
			return null;
		} else {
			return node;
		}
	}

	@ObfuscatedName("ci.c()V")
	public void clear() {
		while (true) {
			Linkable2 node = this.sentinel.next2;
			if (this.sentinel == node) {
				return;
			}

			node.unlink2();
		}
	}
}
