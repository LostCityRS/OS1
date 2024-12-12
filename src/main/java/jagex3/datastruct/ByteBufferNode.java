package jagex3.datastruct;

import deob.ObfuscatedName;

import java.nio.ByteBuffer;

@ObfuscatedName("db")
public class ByteBufferNode extends ByteArrayCopier {

	@ObfuscatedName("db.d")
	public ByteBuffer buffer;

	@ObfuscatedName("db.l(I)[B")
	public byte[] method800() {
		byte[] data = new byte[this.buffer.capacity()];
		this.buffer.position(0);
		this.buffer.get(data);
		return data;
	}

	@ObfuscatedName("db.m([BI)V")
	public void set(byte[] src) {
		this.buffer = ByteBuffer.allocateDirect(src.length);
		this.buffer.position(0);
		this.buffer.put(src);
	}
}
