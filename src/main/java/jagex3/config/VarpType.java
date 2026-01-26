package jagex3.config;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable2;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;
import jagex3.js5.Js5;

// jag::oldscape::configdecoder::VarpType
@ObfuscatedName("fg")
public class VarpType extends Linkable2 {

	// jag::oldscape::configdecoder::VarpType::m_pConfigClient
	@ObfuscatedName("al.n")
	public static Js5 configClient;

	// jag::oldscape::configdecoder::VarpType::m_numDefinitions
	@ObfuscatedName("ey.j")
	public static int numDefinitions;

	// jag::oldscape::configdecoder::VarpType::m_recentUse
	@ObfuscatedName("fg.z")
	public static LruCache recentUse = new LruCache(64);

	@ObfuscatedName("fg.g")
	public int clientcode = 0;

	// jag::oldscape::configdecoder::VarpType::Init
	@ObfuscatedName("cy.z(Lch;I)V")
	public static void init(Js5 arg0) {
		configClient = arg0;
		numDefinitions = configClient.getFileIdLimit(16);
	}

	// jag::oldscape::configdecoder::VarpType::List
	@ObfuscatedName("ez.g(II)Lfg;")
	public static VarpType list(int arg0) {
		VarpType var1 = (VarpType) recentUse.find((long) arg0);
		if (var1 != null) {
			return var1;
		}
		byte[] var2 = configClient.getFile(16, arg0);
		VarpType var3 = new VarpType();
		if (var2 != null) {
			var3.decode(new Packet(var2));
		}
		recentUse.put(var3, (long) arg0);
		return var3;
	}

	// jag::oldscape::configdecoder::VarpType::Decode
	@ObfuscatedName("fg.q(Lev;I)V")
	public void decode(Packet arg0) {
		while (true) {
			int var2 = arg0.g1();
			if (var2 == 0) {
				return;
			}
			this.decode(arg0, var2);
		}
	}

	// jag::oldscape::configdecoder::VarpType::Decode
	@ObfuscatedName("fg.i(Lev;II)V")
	public void decode(Packet arg0, int arg1) {
		if (arg1 == 5) {
			this.clientcode = arg0.g2();
		}
	}

	// jag::oldscape::configdecoder::VarpType::ResetCache
	@ObfuscatedName("cz.s(I)V")
	public static void resetCache() {
		recentUse.clear();
	}
}
