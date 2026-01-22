package jagex3.client.chat;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable;

@ObfuscatedName("dw")
public class ClanMember extends Linkable {

	@ObfuscatedName("dw.m")
	public String username;

	@ObfuscatedName("dw.c")
	public String displayName;

	@ObfuscatedName("dw.n")
	public int world;

	@ObfuscatedName("dw.j")
	public byte rank;
}
