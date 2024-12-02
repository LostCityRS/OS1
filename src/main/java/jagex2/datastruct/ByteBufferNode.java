package jagex2.datastruct;

import deob.ObfuscatedName;
import java.nio.ByteBuffer;

@ObfuscatedName("db")
public class ByteBufferNode extends ByteArrayCopier {

	@ObfuscatedName("db.d")
	public ByteBuffer field1571;

	@ObfuscatedName("db.l(I)[B")
	public byte[] method800() {
		byte[] var1 = new byte[this.field1571.capacity()];
		this.field1571.position(0);
		this.field1571.get(var1);
		return var1;
	}

	@ObfuscatedName("db.m([BI)V")
	public void method801(byte[] arg0) {
		this.field1571 = ByteBuffer.allocateDirect(arg0.length);
		this.field1571.position(0);
		this.field1571.put(arg0);
	}
}
