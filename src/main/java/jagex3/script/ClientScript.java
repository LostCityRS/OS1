package jagex3.script;

import deob.ObfuscatedName;
import jagex3.client.Client;
import jagex3.datastruct.DoublyLinkable;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;

// jag::oldscape::ClientScript
@ObfuscatedName("ep")
public class ClientScript extends DoublyLinkable {

	@ObfuscatedName("ep.n")
	public static LruCache cache = new LruCache(128);

	@ObfuscatedName("ep.j")
	public int[] instructions;

	@ObfuscatedName("ep.z")
	public int[] intOperands;

	@ObfuscatedName("ep.g")
	public String[] stringOperands;

	@ObfuscatedName("ep.q")
	public int intLocalCount;

	@ObfuscatedName("ep.i")
	public int stringLocalCount;

	@ObfuscatedName("ep.s")
	public int intArgCount;

	@ObfuscatedName("ep.u")
	public int stringArgCount;

	// was in 468, not in os
	public String name;

	@ObfuscatedName("bq.z(II)Lep;")
	public static ClientScript get(int id) {
		ClientScript cached = (ClientScript) cache.get(id);
		if (cached != null) {
			return cached;
		}

		byte[] data = Client.clientScriptJs5.getFile(id, 0);
		if (data == null) {
			return null;
		}

		ClientScript script = new ClientScript();

		Packet buf = new Packet(data);
		buf.pos = buf.data.length - 12;

		int instructionCount = buf.g4();
		script.intLocalCount = buf.g2();
		script.stringLocalCount = buf.g2();
		script.intArgCount = buf.g2();
		script.stringArgCount = buf.g2();

		buf.pos = 0;
		script.name = buf.fastgstr();

		script.instructions = new int[instructionCount];
		script.intOperands = new int[instructionCount];
		script.stringOperands = new String[instructionCount];

		int i = 0;
		while (buf.pos < buf.data.length - 12) {
			int op = buf.g2();
			if (op == 3) {
				script.stringOperands[i] = buf.gjstr();
			} else if (op >= 100 || op == 21 || op == 38 || op == 39) {
				script.intOperands[i] = buf.g1();
			} else {
				script.intOperands[i] = buf.g4();
			}

			script.instructions[i++] = op;
		}

		cache.put(script, id);
		return script;
	}
}
