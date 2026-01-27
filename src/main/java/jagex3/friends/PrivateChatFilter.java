package jagex3.friends;

import deob.ObfuscatedName;

@ObfuscatedName("bb")
public class PrivateChatFilter {

	@ObfuscatedName("bb.r")
	public static final PrivateChatFilter field1104 = new PrivateChatFilter(0);

	@ObfuscatedName("bb.d")
	public static final PrivateChatFilter FRIENDS = new PrivateChatFilter(1);

	@ObfuscatedName("bb.l")
	public static final PrivateChatFilter field1105 = new PrivateChatFilter(2);

	@ObfuscatedName("bb.m")
	public final int index;

	@ObfuscatedName("be.r(I)[Lbb;")
	public static PrivateChatFilter[] values() {
		return new PrivateChatFilter[] { field1105, field1104, FRIENDS};
	}

	public PrivateChatFilter(int arg0) {
		this.index = arg0;
	}

	public static PrivateChatFilter get(int id) {
		PrivateChatFilter[] all = PrivateChatFilter.values();
		for (int i = 0; i < all.length; i++) {
			PrivateChatFilter privacy = all[i];
			if (privacy.index == id) {
				return privacy;
			}
		}
		return null;
	}
}
