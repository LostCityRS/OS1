package jagex2.io;

import deob.ObfuscatedName;
import deob.Settings;

@ObfuscatedName("ea")
public class PacketBit extends Packet {

	@ObfuscatedName("ea.g")
	public Isaac random;

	@ObfuscatedName("ea.q")
	public static final int[] BITMASK = new int[] { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1 };

	@ObfuscatedName("ea.i")
	public int bitPos;

	public PacketBit(int arg0) {
		super(arg0);
	}

	@ObfuscatedName("ea.gv([II)V")
	public void seed(int[] arg0) {
		this.random = new Isaac(arg0);
	}

	@ObfuscatedName("ea.gt(II)V")
	public void pisaac1(int arg0) {
		if (Settings.SKIP_ISAAC) {
			this.data[++this.pos - 1] = (byte) arg0;
		} else {
			this.data[++this.pos - 1] = (byte) (arg0 + this.random.takeNextValue());
		}
	}

	@ObfuscatedName("ea.gg(B)I")
	public int gisaac1() {
		if (Settings.SKIP_ISAAC) {
			return this.data[++this.pos - 1] & 0xFF;
		} else {
			return (this.data[++this.pos - 1] - this.random.takeNextValue()) & 0xFF;
		}
	}

	@ObfuscatedName("ea.gy(S)V")
	public void accessBits() {
		this.bitPos = this.pos * 8;
	}

	@ObfuscatedName("ea.gu(II)I")
	public int gBit(int arg0) {
		int var2 = this.bitPos >> 3;
		int var3 = 8 - (this.bitPos & 0x7);
		int var4 = 0;
		this.bitPos += arg0;
		while (arg0 > var3) {
			var4 += (this.data[var2++] & BITMASK[var3]) << arg0 - var3;
			arg0 -= var3;
			var3 = 8;
		}
		int var5;
		if (arg0 == var3) {
			var5 = (this.data[var2] & BITMASK[var3]) + var4;
		} else {
			var5 = (this.data[var2] >> var3 - arg0 & BITMASK[arg0]) + var4;
		}
		return var5;
	}

	@ObfuscatedName("ea.gb(I)V")
	public void accessBytes() {
		this.pos = (this.bitPos + 7) / 8;
	}

	@ObfuscatedName("ea.gs(II)I")
	public int bitsAvailable(int arg0) {
		return arg0 * 8 - this.bitPos;
	}
}
