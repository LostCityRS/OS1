package jagex3.io;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable;

@ObfuscatedName("ew")
public class ByteArrayNode extends Linkable {

	@ObfuscatedName("ew.m")
	public byte[] data;

	public ByteArrayNode(byte[] src) {
		this.data = src;
	}
}
