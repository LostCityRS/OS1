package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("cg")
public class LinkList {

	@ObfuscatedName("cg.r")
	public Linkable sentinel = new Linkable();

	@ObfuscatedName("cg.d")
	public Linkable cursor;

	public LinkList() {
		this.sentinel.next = this.sentinel;
		this.sentinel.prev = this.sentinel;
	}

	@ObfuscatedName("cg.r()V")
	public void clear() {
		while (true) {
			Linkable node = this.sentinel.next;
			if (this.sentinel == node) {
				this.cursor = null;
				return;
			}

			node.unlink();
		}
	}

	// add to tail
	@ObfuscatedName("cg.d(Ldg;)V")
	public void push(Linkable node) {
		if (node.prev != null) {
			node.unlink();
		}

		node.prev = this.sentinel.prev;
		node.next = this.sentinel;
		node.prev.next = node;
		node.next.prev = node;
	}

	// add to head
	@ObfuscatedName("cg.l(Ldg;)V")
	public void unshift(Linkable node) {
		if (node.prev != null) {
			node.unlink();
		}

		node.prev = this.sentinel;
		node.next = this.sentinel.next;
		node.prev.next = node;
		node.next.prev = node;
	}

	@ObfuscatedName("cg.m(Ldg;Ldg;)V")
	public static void insertBefore(Linkable node1, Linkable node2) {
		if (node1.prev != null) {
			node1.unlink();
		}

		node1.prev = node2.prev;
		node1.next = node2;
		node1.prev.next = node1;
		node1.next.prev = node1;
	}

	// remove from head
	@ObfuscatedName("cg.c()Ldg;")
	public Linkable shift() {
		Linkable node = this.sentinel.next;
		if (this.sentinel == node) {
			return null;
		} else {
			node.unlink();
			return node;
		}
	}

	// remove from tail
	@ObfuscatedName("cg.n()Ldg;")
	public Linkable pop() {
		Linkable node = this.sentinel.prev;
		if (this.sentinel == node) {
			return null;
		} else {
			node.unlink();
			return node;
		}
	}

	@ObfuscatedName("cg.j()Ldg;")
	public Linkable head() {
		Linkable node = this.sentinel.next;
		if (this.sentinel == node) {
			this.cursor = null;
			return null;
		} else {
			this.cursor = node.next;
			return node;
		}
	}

	@ObfuscatedName("cg.z()Ldg;")
	public Linkable tail() {
		Linkable node = this.sentinel.prev;
		if (this.sentinel == node) {
			this.cursor = null;
			return null;
		} else {
			this.cursor = node.prev;
			return node;
		}
	}

	@ObfuscatedName("cg.g()Ldg;")
	public Linkable next() {
		Linkable node = this.cursor;
		if (this.sentinel == node) {
			this.cursor = null;
			return null;
		} else {
			this.cursor = node.next;
			return node;
		}
	}

	@ObfuscatedName("cg.q()Ldg;")
	public Linkable prev() {
		Linkable node = this.cursor;
		if (this.sentinel == node) {
			this.cursor = null;
			return null;
		} else {
			this.cursor = node.prev;
			return node;
		}
	}
}
