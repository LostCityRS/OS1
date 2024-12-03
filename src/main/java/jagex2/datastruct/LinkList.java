package jagex2.datastruct;

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
			Linkable var1 = this.sentinel.next;
			if (this.sentinel == var1) {
				this.cursor = null;
				return;
			}
			var1.unlink();
		}
	}

	@ObfuscatedName("cg.d(Ldg;)V")
	public void push(Linkable arg0) {
		if (arg0.prev != null) {
			arg0.unlink();
		}
		arg0.prev = this.sentinel.prev;
		arg0.next = this.sentinel;
		arg0.prev.next = arg0;
		arg0.next.prev = arg0;
	}

	@ObfuscatedName("cg.l(Ldg;)V")
	public void addHead(Linkable arg0) {
		if (arg0.prev != null) {
			arg0.unlink();
		}
		arg0.prev = this.sentinel;
		arg0.next = this.sentinel.next;
		arg0.prev.next = arg0;
		arg0.next.prev = arg0;
	}

	@ObfuscatedName("cg.m(Ldg;Ldg;)V")
	public static void method1294(Linkable arg0, Linkable arg1) {
		if (arg0.prev != null) {
			arg0.unlink();
		}
		arg0.prev = arg1.prev;
		arg0.next = arg1;
		arg0.prev.next = arg0;
		arg0.next.prev = arg0;
	}

	@ObfuscatedName("cg.c()Ldg;")
	public Linkable pop() {
		Linkable var1 = this.sentinel.next;
		if (this.sentinel == var1) {
			return null;
		} else {
			var1.unlink();
			return var1;
		}
	}

	@ObfuscatedName("cg.n()Ldg;")
	public Linkable removeTail() {
		Linkable var1 = this.sentinel.prev;
		if (this.sentinel == var1) {
			return null;
		} else {
			var1.unlink();
			return var1;
		}
	}

	@ObfuscatedName("cg.j()Ldg;")
	public Linkable head() {
		Linkable var1 = this.sentinel.next;
		if (this.sentinel == var1) {
			this.cursor = null;
			return null;
		} else {
			this.cursor = var1.next;
			return var1;
		}
	}

	@ObfuscatedName("cg.z()Ldg;")
	public Linkable tail() {
		Linkable var1 = this.sentinel.prev;
		if (this.sentinel == var1) {
			this.cursor = null;
			return null;
		} else {
			this.cursor = var1.prev;
			return var1;
		}
	}

	@ObfuscatedName("cg.g()Ldg;")
	public Linkable next() {
		Linkable var1 = this.cursor;
		if (this.sentinel == var1) {
			this.cursor = null;
			return null;
		} else {
			this.cursor = var1.next;
			return var1;
		}
	}

	@ObfuscatedName("cg.q()Ldg;")
	public Linkable prev() {
		Linkable var1 = this.cursor;
		if (this.sentinel == var1) {
			this.cursor = null;
			return null;
		} else {
			this.cursor = var1.prev;
			return var1;
		}
	}
}
