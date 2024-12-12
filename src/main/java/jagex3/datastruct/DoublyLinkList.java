package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("ci")
public class DoublyLinkList {

	@ObfuscatedName("ci.r")
	public DoublyLinkable sentinel = new DoublyLinkable();

	public DoublyLinkList() {
		this.sentinel.next2 = this.sentinel;
		this.sentinel.prev2 = this.sentinel;
	}

	@ObfuscatedName("ci.r(Len;)V")
	public void push(DoublyLinkable arg0) {
		if (arg0.prev2 != null) {
			arg0.unlink2();
		}
		arg0.prev2 = this.sentinel.prev2;
		arg0.next2 = this.sentinel;
		arg0.prev2.next2 = arg0;
		arg0.next2.prev2 = arg0;
	}

	@ObfuscatedName("ci.d(Len;)V")
	public void addHead(DoublyLinkable arg0) {
		if (arg0.prev2 != null) {
			arg0.unlink2();
		}
		arg0.prev2 = this.sentinel;
		arg0.next2 = this.sentinel.next2;
		arg0.prev2.next2 = arg0;
		arg0.next2.prev2 = arg0;
	}

	@ObfuscatedName("ci.l()Len;")
	public DoublyLinkable pop() {
		DoublyLinkable var1 = this.sentinel.next2;
		if (this.sentinel == var1) {
			return null;
		} else {
			var1.unlink2();
			return var1;
		}
	}

	@ObfuscatedName("ci.m()Len;")
	public DoublyLinkable head() {
		DoublyLinkable var1 = this.sentinel.next2;
		return this.sentinel == var1 ? null : var1;
	}

	@ObfuscatedName("ci.c()V")
	public void clear() {
		while (true) {
			DoublyLinkable var1 = this.sentinel.next2;
			if (this.sentinel == var1) {
				return;
			}
			var1.unlink2();
		}
	}
}
