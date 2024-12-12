package jagex3.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("ew")
public class ByteArrayNode extends Linkable {

	@ObfuscatedName("ew.m")
	public byte[] data;

	public ByteArrayNode(byte[] src) {
		this.data = src;
	}
}
