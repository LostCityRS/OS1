package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("dg")
public class Linkable {

	@ObfuscatedName("dg.r")
	public long key;

	@ObfuscatedName("dg.d")
	public Linkable next;

	@ObfuscatedName("dg.l")
	public Linkable prev;

	@ObfuscatedName("dg.r()V")
	public void unlink() {
		if (this.prev != null) {
			this.prev.next = this.next;
			this.next.prev = this.prev;
			this.next = null;
			this.prev = null;
		}
	}

	@ObfuscatedName("dg.d()Z")
	public boolean isLinked() {
		return this.prev != null;
	}
}
