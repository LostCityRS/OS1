package jagex3.client;

import deob.ObfuscatedName;
import jagex3.config.iftype.IfType;
import jagex3.datastruct.Linkable;

// jag::oldscape::HookReq
@ObfuscatedName("du")
public class HookReq extends Linkable {

	@ObfuscatedName("du.m")
	public Object[] onop;

	@ObfuscatedName("du.c")
	public IfType component;

	@ObfuscatedName("du.n")
	public int mouseX;

	@ObfuscatedName("du.j")
	public int mouseY;

	@ObfuscatedName("du.z")
	public int opindex;

	@ObfuscatedName("du.g")
	public IfType drop;

	@ObfuscatedName("du.q")
	public int keyCode;

	@ObfuscatedName("du.i")
	public int keyChar;

	@ObfuscatedName("du.s")
	public String opbase;
}
