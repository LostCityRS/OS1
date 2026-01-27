package jagex3.client.applet;

import deob.ObfuscatedName;

@ObfuscatedName("ah")
public class PrivilegedRequest {

	@ObfuscatedName("ah.r")
	public PrivilegedRequest next;

	@ObfuscatedName("ah.c")
	public volatile int status = 0;

	@ObfuscatedName("ah.n")
	public int type;

	@ObfuscatedName("ah.j")
	public int intArg;

	@ObfuscatedName("ah.z")
	public Object objArg;

	@ObfuscatedName("ah.g")
	public volatile Object result;
}
