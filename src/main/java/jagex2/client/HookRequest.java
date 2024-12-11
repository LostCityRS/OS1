package jagex2.client;

import deob.ObfuscatedName;
import jagex2.config.IfType;
import jagex2.datastruct.Linkable;

@ObfuscatedName("du")
public class HookRequest extends Linkable {

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
	public int key;

	@ObfuscatedName("du.i")
	public int keyChar;

	@ObfuscatedName("du.s")
	public String opbase;
}
