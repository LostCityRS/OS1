package jagex2.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("dd")
public class ChatLinkable {

	@ObfuscatedName("dd.r")
	public ChatLinkable field1502;

	@ObfuscatedName("dd.d")
	public ChatLinkable field1503;

	@ObfuscatedName("dd.r()V")
	public void method1322() {
		if (this.field1503 != null) {
			this.field1503.field1502 = this.field1502;
			this.field1502.field1503 = this.field1503;
			this.field1502 = null;
			this.field1503 = null;
		}
	}
}
