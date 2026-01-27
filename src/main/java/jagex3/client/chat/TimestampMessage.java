package jagex3.client.chat;

import deob.ObfuscatedName;
import jagex3.datastruct.ChatLinkable;
import jagex3.datastruct.MonotonicTime;

@ObfuscatedName("dr")
public class TimestampMessage extends ChatLinkable {

	@ObfuscatedName("dr.l")
	public String message;

	@ObfuscatedName("dr.m")
	public short worldId;

	public TimestampMessage(String arg0, int arg1) {
		MonotonicTime.currentTime();
		this.message = arg0;
		this.worldId = (short) arg1;
	}
}
