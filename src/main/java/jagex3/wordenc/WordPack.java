package jagex3.wordenc;

import deob.ObfuscatedName;
import jagex3.io.Packet;
import jagex3.io.PacketBit;
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
	public static void setHuffman(Huffman h) {
		huffman = h;
	}

	// jag::game::WordPack::PackUTF8AsCP1252
	@ObfuscatedName("bp.d(Lev;Ljava/lang/String;B)I")
	public static int pack(Packet dst, String str) {
		int start = dst.pos;
		byte[] src = Cp1252.utf8ToCP1252(str);
		dst.psmart(src.length);
		dst.pos += huffman.encode(src, 0, src.length, dst.data, dst.pos);
		return dst.pos - start;
	}

	// jag::game::WordPack::UnpackCP1252AsUTF8
	@ObfuscatedName("ca.l(Lev;I)Ljava/lang/String;")
	public static String unpack(Packet buf) {
		try {
			int len = buf.gsmart();
			if (len > 32767) {
				len = 32767;
			}

			byte[] var2 = new byte[len];
			buf.pos += huffman.decode(buf.data, buf.pos, var2, 0, len);
			return Cp1252.decode(var2, 0, len);
		} catch (Exception ex) {
			return "Cabbage";
		}
	}

	// jag::game::WordPack::UnpackCP1252AsUTF8
	public static String unpack2(PacketBit buf) {
		try {
			int len = buf.gsmart();
			if (len > 32767) {
				len = 32767;
			}

			byte[] src = new byte[len];
			buf.pos += huffman.decode(buf.data, buf.pos, src, 0, len);
			return Cp1252.decode(src, 0, len);
		} catch (Exception ex) {
			return "Cabbage";
		}
	}
}
