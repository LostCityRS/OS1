package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("cb")
public class ChatLinkList {

	@ObfuscatedName("cb.r")
	public ChatLinkable sentinel = new ChatLinkable();

	@ObfuscatedName("cb.d")
	public ChatLinkable cursor;

	public ChatLinkList() {
		this.sentinel.next = this.sentinel;
		this.sentinel.prev = this.sentinel;
	}

	@ObfuscatedName("cb.r(Ldd;)V")
	public void push(ChatLinkable node) {
		if (node.prev != null) {
			node.unlink();
		}

		node.prev = this.sentinel.prev;
		node.next = this.sentinel;
		node.prev.next = node;
		node.next.prev = node;
	}

	@ObfuscatedName("cb.d()Ldd;")
	public ChatLinkable head() {
		ChatLinkable node = this.sentinel.next;
		if (this.sentinel == node) {
			this.cursor = null;
			return null;
		} else {
			this.cursor = node.next;
			return node;
		}
	}

	@ObfuscatedName("cb.l()Ldd;")
	public ChatLinkable next() {
		ChatLinkable node = this.cursor;
		if (this.sentinel == node) {
			this.cursor = null;
			return null;
		} else {
			this.cursor = node.next;
			return node;
		}
	}
}
