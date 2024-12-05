package jagex2.client;

import deob.ObfuscatedName;

@ObfuscatedName("cd")
public class JavConfigParameter {

	@ObfuscatedName("cd.r")
	public static final JavConfigParameter JS = new JavConfigParameter("1", "1");

	@ObfuscatedName("cd.d")
	public static final JavConfigParameter MODEWHERE = new JavConfigParameter("7", "7");

	@ObfuscatedName("cd.l")
	public static final JavConfigParameter MODEWHAT = new JavConfigParameter("5", "5");

	@ObfuscatedName("cd.m")
	public static final JavConfigParameter GAME = new JavConfigParameter("8", "8");

	@ObfuscatedName("cd.c")
	public static final JavConfigParameter PLUG = new JavConfigParameter("3", "3");

	@ObfuscatedName("cd.n")
	public static final JavConfigParameter WORLDID = new JavConfigParameter("2", "2");

	@ObfuscatedName("cd.j")
	public static final JavConfigParameter MEMBERS = new JavConfigParameter("6", "6");

	@ObfuscatedName("cd.z")
	public static final JavConfigParameter LANG = new JavConfigParameter("4", "4");

	@ObfuscatedName("cd.g")
	public static final JavConfigParameter WORLDLIST_URL = new JavConfigParameter("9", "9");

	@ObfuscatedName("cd.q")
	public final String id;

	public JavConfigParameter(String name, String id) {
		this.id = id;
	}
}
