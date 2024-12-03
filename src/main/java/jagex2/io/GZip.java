package jagex2.io;

import deob.ObfuscatedName;

import java.util.zip.Inflater;

@ObfuscatedName("bf")
public class GZip {

	@ObfuscatedName("bf.r")
	public Inflater field814;

	public GZip() {
		this(-1, 1000000, 1000000);
	}

	public GZip(int arg0, int arg1, int arg2) {
	}

	@ObfuscatedName("bf.r(Lev;[BB)V")
	public void method834(Packet arg0, byte[] arg1) {
		if (arg0.data[arg0.pos] != 31 || arg0.data[arg0.pos + 1] != -117) {
			throw new RuntimeException("");
		}
		if (this.field814 == null) {
			this.field814 = new Inflater(true);
		}
		try {
			this.field814.setInput(arg0.data, arg0.pos + 10, arg0.data.length - (arg0.pos + 10 + 8));
			this.field814.inflate(arg1);
		} catch (Exception var4) {
			this.field814.reset();
			throw new RuntimeException("");
		}
		this.field814.reset();
	}
}
