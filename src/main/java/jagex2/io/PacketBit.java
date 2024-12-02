package jagex2.io;

import deob.ObfuscatedName;

@ObfuscatedName("ea")
public class PacketBit extends Packet {

	@ObfuscatedName("ea.g")
	public Isaac field2259;

	@ObfuscatedName("ea.q")
	public static final int[] field2258 = new int[] { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1 };

	@ObfuscatedName("ea.i")
	public int field2257;

	public PacketBit(int arg0) {
		super(arg0);
	}

	@ObfuscatedName("ea.gv([II)V")
	public void method2306(int[] arg0) {
		this.field2259 = new Isaac(arg0);
	}

	@ObfuscatedName("ea.gt(II)V")
	public void method2301(int arg0) {
		this.field1732[++this.field1729 - 1] = (byte) (arg0 + this.field2259.method787());
	}

	@ObfuscatedName("ea.gg(B)I")
	public int method2315() {
		return this.field1732[++this.field1729 - 1] - this.field2259.method787() & 0xFF;
	}

	@ObfuscatedName("ea.gy(S)V")
	public void method2302() {
		this.field2257 = this.field1729 * 8;
	}

	@ObfuscatedName("ea.gu(II)I")
	public int method2303(int arg0) {
		int var2 = this.field2257 >> 3;
		int var3 = 8 - (this.field2257 & 0x7);
		int var4 = 0;
		this.field2257 += arg0;
		while (arg0 > var3) {
			var4 += (this.field1732[var2++] & field2258[var3]) << arg0 - var3;
			arg0 -= var3;
			var3 = 8;
		}
		int var5;
		if (arg0 == var3) {
			var5 = (this.field1732[var2] & field2258[var3]) + var4;
		} else {
			var5 = (this.field1732[var2] >> var3 - arg0 & field2258[arg0]) + var4;
		}
		return var5;
	}

	@ObfuscatedName("ea.gb(I)V")
	public void method2319() {
		this.field1729 = (this.field2257 + 7) / 8;
	}

	@ObfuscatedName("ea.gs(II)I")
	public int method2305(int arg0) {
		return arg0 * 8 - this.field2257;
	}
}
