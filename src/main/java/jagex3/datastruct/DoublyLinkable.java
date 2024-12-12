package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("en")
public class DoublyLinkable extends Linkable {

	@ObfuscatedName("en.m")
	public DoublyLinkable next2;

	@ObfuscatedName("en.c")
	public DoublyLinkable prev2;

	@ObfuscatedName("en.c()V")
	public void unlink2() {
		if (this.prev2 != null) {
			this.prev2.next2 = this.next2;
			this.next2.prev2 = this.prev2;
			this.next2 = null;
			this.prev2 = null;
		}
	}
}
