package jagex3.config;

import deob.ObfuscatedName;
import jagex3.datastruct.DoublyLinkable;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;
import jagex3.js5.Js5;
import jagex3.js5.Js5Loader;

// jag::oldscape::configdecoder::VarBitType
@ObfuscatedName("fc")
public class VarBitType extends DoublyLinkable {

	// jag::oldscape::configdecoder::VarBitType::m_pConfigClient
	@ObfuscatedName("fc.n")
	public static Js5 configClient;

	// jag::oldscape::configdecoder::VarBitType::m_recentUse
	@ObfuscatedName("fc.j")
	public static LruCache recentUse = new LruCache(64);

	@ObfuscatedName("fc.z")
	public int basevar;

	@ObfuscatedName("fc.g")
	public int startbit;

	@ObfuscatedName("fc.q")
	public int endbit;

	// jag::oldscape::configdecoder::VarBitType::List
	@ObfuscatedName("q.z(II)Lfc;")
	public static VarBitType list(int arg0) {
		VarBitType var1 = (VarBitType) recentUse.get((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = configClient.getFile(14, arg0);
		VarBitType var3 = new VarBitType();
		if (var2 != null) {
			var3.decode(new Packet(var2));
		}
		recentUse.put(var3, (long) arg0);
		return var3;
	}

	// jag::oldscape::configdecoder::VarBitType::Decode
	@ObfuscatedName("fc.g(Lev;B)V")
	public void decode(Packet arg0) {
		while (true) {
			int var2 = arg0.g1();
			if (var2 == 0) {
				return;
			}
			this.decode(arg0, var2);
		}
	}

	// jag::oldscape::configdecoder::VarBitType::Decode
	@ObfuscatedName("fc.q(Lev;II)V")
	public void decode(Packet arg0, int arg1) {
		if (arg1 == 1) {
			this.basevar = arg0.g2();
			this.startbit = arg0.g1();
			this.endbit = arg0.g1();
		}
	}

	// jag::oldscape::configdecoder::VarBitType::Init
	public static void init(Js5Loader var38) {
		configClient = var38;
	}

	// jag::oldscape::configdecoder::VarBitType::ResetCache
	public static void resetCache() {
		recentUse.clear();
	}
}
