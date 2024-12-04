package jagex2.io;

import deob.ObfuscatedName;

import java.util.zip.Inflater;

@ObfuscatedName("bf")
public class GZip {

	@ObfuscatedName("bf.r")
	public Inflater inflater;

	public GZip() {
		this(-1, 1000000, 1000000);
	}

	public GZip(int arg0, int arg1, int arg2) {
	}

	@ObfuscatedName("bf.r(Lev;[BB)V")
	public void decompress(Packet buf, byte[] out) {
		if (buf.data[buf.pos] != 31 || buf.data[buf.pos + 1] != -117) {
			throw new RuntimeException("");
		}

		if (this.inflater == null) {
			this.inflater = new Inflater(true);
		}

		try {
			this.inflater.setInput(buf.data, buf.pos + 10, buf.data.length - (buf.pos + 10 + 8));
			this.inflater.inflate(out);
		} catch (Exception ignore) {
			this.inflater.reset();
			throw new RuntimeException("");
		}

		this.inflater.reset();
	}
}
