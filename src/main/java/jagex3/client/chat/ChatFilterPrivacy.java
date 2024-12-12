package jagex3.client.chat;

import deob.ObfuscatedName;

@ObfuscatedName("bb")
public class ChatFilterPrivacy {

	@ObfuscatedName("bb.r")
	public static final ChatFilterPrivacy field1104 = new ChatFilterPrivacy(0);

	@ObfuscatedName("bb.d")
	public static final ChatFilterPrivacy field1106 = new ChatFilterPrivacy(1);

	@ObfuscatedName("bb.l")
	public static final ChatFilterPrivacy field1105 = new ChatFilterPrivacy(2);

	@ObfuscatedName("bb.m")
	public final int index;

	@ObfuscatedName("be.r(I)[Lbb;")
	public static ChatFilterPrivacy[] values() {
		return new ChatFilterPrivacy[] { field1105, field1104, field1106 };
	}

	public ChatFilterPrivacy(int arg0) {
		this.index = arg0;
	}

	public static ChatFilterPrivacy get(int id) {
		ChatFilterPrivacy[] all = ChatFilterPrivacy.values();
		for (int i = 0; i < all.length; i++) {
			ChatFilterPrivacy privacy = all[i];
			if (privacy.index == id) {
				return privacy;
			}
		}
		return null;
	}
}
