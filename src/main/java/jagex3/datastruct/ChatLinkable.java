package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("dd")
public class ChatLinkable {

	@ObfuscatedName("dd.r")
	public ChatLinkable next;

	@ObfuscatedName("dd.d")
	public ChatLinkable prev;

	@ObfuscatedName("dd.r()V")
	public void unlink() {
		if (this.prev != null) {
			this.prev.next = this.next;
			this.next.prev = this.prev;
			this.next = null;
			this.prev = null;
		}
	}
}
