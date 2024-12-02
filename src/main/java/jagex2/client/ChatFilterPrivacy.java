package jagex2.client;

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
	public final int field1107;

	@ObfuscatedName("be.r(I)[Lbb;")
	public static ChatFilterPrivacy[] method907() {
		return new ChatFilterPrivacy[] { field1105, field1104, field1106 };
	}

	public ChatFilterPrivacy(int arg0) {
		this.field1107 = arg0;
	}
}
