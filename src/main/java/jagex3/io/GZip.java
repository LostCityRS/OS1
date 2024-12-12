package jagex3.io;

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
	public void decompress(Packet arg0, byte[] arg1) {
		if (arg0.data[arg0.pos] != 31 || arg0.data[arg0.pos + 1] != -117) {
			throw new RuntimeException("");
		}
		if (this.inflater == null) {
			this.inflater = new Inflater(true);
		}
		try {
			this.inflater.setInput(arg0.data, arg0.pos + 10, arg0.data.length - (arg0.pos + 10 + 8));
			this.inflater.inflate(arg1);
		} catch (Exception var4) {
			this.inflater.reset();
			throw new RuntimeException("");
		}
		this.inflater.reset();
	}
}
