package jagex3.wordenc;

import deob.ObfuscatedName;
import jagex3.io.Packet;
import jagex3.jstring.Cp1252;

// jag::game::Huffman
@ObfuscatedName("dz")
public class Huffman {

	@ObfuscatedName("dz.r")
	public static WordPack wordPack;

	public Huffman() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("bw.r(Lby;I)V")
	public static void method816(WordPack arg0) {
		wordPack = arg0;
	}

	@ObfuscatedName("bp.d(Lev;Ljava/lang/String;B)I")
	public static int method911(Packet arg0, String arg1) {
		int var2 = arg0.pos;
		byte[] var3 = Cp1252.method1231(arg1);
		arg0.psmart(var3.length);
		arg0.pos += wordPack.compress(var3, 0, var3.length, arg0.data, arg0.pos);
		return arg0.pos - var2;
	}

	@ObfuscatedName("ca.l(Lev;I)Ljava/lang/String;")
	public static String method1035(Packet arg0) {
		try {
			int var1 = arg0.gsmart();
			if (var1 > 32767) {
				var1 = 32767;
			}
			byte[] var2 = new byte[var1];
			arg0.pos += wordPack.decompress(arg0.data, arg0.pos, var2, 0, var1);
			return Cp1252.decode(var2, 0, var1);
		} catch (Exception var6) {
			return "Cabbage";
		}
	}
}
