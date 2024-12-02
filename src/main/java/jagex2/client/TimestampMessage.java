package jagex2.client;

import deob.ObfuscatedName;
import jagex2.datastruct.MonotonicTime;
import jagex2.datastruct.NodeLinkable;

@ObfuscatedName("dr")
public class TimestampMessage extends NodeLinkable {

	@ObfuscatedName("dr.l")
	public String field1584;

	@ObfuscatedName("dr.m")
	public short field1583;

	public TimestampMessage(String arg0, int arg1) {
		MonotonicTime.method1135();
		this.field1584 = arg0;
		this.field1583 = (short) arg1;
	}
}
