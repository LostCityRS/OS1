package jagex2.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("cb")
public class ChatLinkList {

	@ObfuscatedName("cb.r")
	public ChatNode field1493 = new ChatNode();

	@ObfuscatedName("cb.d")
	public ChatNode field1494;

	public ChatLinkList() {
		this.field1493.field1502 = this.field1493;
		this.field1493.field1503 = this.field1493;
	}

	@ObfuscatedName("cb.r(Ldd;)V")
	public void method1267(ChatNode arg0) {
		if (arg0.field1503 != null) {
			arg0.method1322();
		}
		arg0.field1503 = this.field1493.field1503;
		arg0.field1502 = this.field1493;
		arg0.field1503.field1502 = arg0;
		arg0.field1502.field1503 = arg0;
	}

	@ObfuscatedName("cb.d()Ldd;")
	public ChatNode method1268() {
		ChatNode var1 = this.field1493.field1502;
		if (this.field1493 == var1) {
			this.field1494 = null;
			return null;
		} else {
			this.field1494 = var1.field1502;
			return var1;
		}
	}

	@ObfuscatedName("cb.l()Ldd;")
	public ChatNode method1274() {
		ChatNode var1 = this.field1494;
		if (this.field1493 == var1) {
			this.field1494 = null;
			return null;
		} else {
			this.field1494 = var1.field1502;
			return var1;
		}
	}
}
