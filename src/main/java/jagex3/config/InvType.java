package jagex3.config;

import deob.ObfuscatedName;
import jagex3.datastruct.DoublyLinkable;
import jagex3.datastruct.LruCache;
import jagex3.io.Packet;
import jagex3.js5.Js5;
import jagex3.js5.Js5Loader;

// jag::oldscape::configdecoder::InvType
@ObfuscatedName("fp")
public class InvType extends DoublyLinkable {

	// jag::oldscape::configdecoder::InvType::m_pConfigClient
	@ObfuscatedName("fp.n")
	public static Js5 configClient;

	// jag::oldscape::configdecoder::InvType::m_recentUse
	@ObfuscatedName("fp.j")
	public static LruCache recentUse = new LruCache(64);

	@ObfuscatedName("fp.z")
	public int size = 0;

	// jag::oldscape::configdecoder::InvType::Decode
	@ObfuscatedName("fp.z(Lev;I)V")
	public void decode(Packet buf) {
		while (true) {
			int code = buf.g1();
			if (code == 0) {
				return;
			}

			this.decode(buf, code);
		}
	}

	// jag::oldscape::configdecoder::InvType::Decode
	@ObfuscatedName("fp.g(Lev;II)V")
	public void decode(Packet buf, int code) {
		if (code == 2) {
			this.size = buf.g2();
		}
	}

	// jag::oldscape::configdecoder::InvType::List
	public static InvType list(int id) {
		InvType cached = (InvType) recentUse.get(id);
		if (cached != null) {
			return cached;
		}

		byte[] data = configClient.getFile(5, id);
		InvType inv = new InvType();
		if (data != null) {
			inv.decode(new Packet(data));
		}

		recentUse.put(inv, id);
		return inv;
	}

	// jag::oldscape::configdecoder::InvType::Init
	public static void init(Js5Loader config) {
		configClient = config;
	}
}
