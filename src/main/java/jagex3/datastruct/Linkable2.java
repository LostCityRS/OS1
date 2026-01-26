package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("en")
public class Linkable2 extends Linkable {

	@ObfuscatedName("en.m")
	public Linkable2 next2;

	@ObfuscatedName("en.c")
	public Linkable2 prev2;

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
