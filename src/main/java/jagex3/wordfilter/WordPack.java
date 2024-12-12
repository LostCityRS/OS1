package jagex3.wordfilter;

import deob.ObfuscatedName;
import jagex3.io.Huffman;
import jagex3.io.Packet;
import jagex3.jstring.Cp1252;

// jag::game::WordPack
@ObfuscatedName("dz")
public class WordPack {

	@ObfuscatedName("dz.r")
	public static Huffman huffman;

	public WordPack() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("bw.r(Lby;I)V")
	public static void method816(Huffman arg0) {
		huffman = arg0;
	}

	@ObfuscatedName("bp.d(Lev;Ljava/lang/String;B)I")
	public static int method911(Packet arg0, String arg1) {
		int var2 = arg0.pos;
		byte[] var3 = Cp1252.method1231(arg1);
		arg0.psmart(var3.length);
		arg0.pos += huffman.method819(var3, 0, var3.length, arg0.data, arg0.pos);
		return arg0.pos - var2;
	}

	@ObfuscatedName("ca.l(Lev;I)Ljava/lang/String;")
	public static String method1035(Packet arg0) {
		String var4;
		try {
			int var1 = arg0.gsmart();
			if (var1 > 32767) {
				var1 = 32767;
			}
			byte[] var2 = new byte[var1];
			arg0.pos += huffman.method818(arg0.data, arg0.pos, var2, 0, var1);
			String var3 = Cp1252.method2397(var2, 0, var1);
			var4 = var3;
		} catch (Exception var6) {
			var4 = "Cabbage";
		}
		return var4;
	}
}
