package jagex2.client;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LruCache;
import jagex2.io.Packet;

@ObfuscatedName("ep")
public class ClientScript extends DoublyLinkable {

	@ObfuscatedName("ep.n")
	public static LruCache field2262 = new LruCache(128);

	@ObfuscatedName("ep.j")
	public int[] field2261;

	@ObfuscatedName("ep.z")
	public int[] field2260;

	@ObfuscatedName("ep.g")
	public String[] field2264;

	@ObfuscatedName("ep.q")
	public int field2263;

	@ObfuscatedName("ep.i")
	public int field2265;

	@ObfuscatedName("ep.s")
	public int field2266;

	@ObfuscatedName("ep.u")
	public int field2267;

	@ObfuscatedName("bq.z(II)Lep;")
	public static ClientScript method872(int arg0) {
		ClientScript var1 = (ClientScript) field2262.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = Client.field1232.getFile(arg0, 0);
		if (var2 == null) {
			return null;
		}
		ClientScript var3 = new ClientScript();
		Packet var4 = new Packet(var2);
		var4.pos = var4.data.length - 12;
		int var5 = var4.g4();
		var3.field2263 = var4.g2();
		var3.field2265 = var4.g2();
		var3.field2266 = var4.g2();
		var3.field2267 = var4.g2();
		var4.pos = 0;
		var4.fastgstr();
		var3.field2261 = new int[var5];
		var3.field2260 = new int[var5];
		var3.field2264 = new String[var5];
		int var6 = 0;
		while (var4.pos < var4.data.length - 12) {
			int var7 = var4.g2();
			if (var7 == 3) {
				var3.field2264[var6] = var4.gjstr();
			} else if (var7 >= 100 || var7 == 21 || var7 == 38 || var7 == 39) {
				var3.field2260[var6] = var4.g1();
			} else {
				var3.field2260[var6] = var4.g4();
			}
			var3.field2261[var6++] = var7;
		}
		field2262.put(var3, (long) arg0);
		return var3;
	}
}
