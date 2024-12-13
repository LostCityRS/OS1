package jagex3.client.chat;

import deob.ObfuscatedName;
import jagex3.datastruct.ChatLinkable;
import jagex3.datastruct.MonotonicTime;

@ObfuscatedName("dr")
public class TimestampMessage extends ChatLinkable {

	@ObfuscatedName("dr.l")
	public String field1584;

	@ObfuscatedName("dr.m")
	public short field1583;

	public TimestampMessage(String arg0, int arg1) {
		MonotonicTime.currentTime();
		this.field1584 = arg0;
		this.field1583 = (short) arg1;
	}
}
