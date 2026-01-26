package jagex3.datastruct;

import deob.ObfuscatedName;

// jag::oldscape::core::math::MathTool
@ObfuscatedName("bo")
public class MathTool {

	public MathTool() throws Throwable {
		throw new Error();
	}

	// jag::oldscape::core::math::MathTool::Hcf
	@ObfuscatedName("av.r(IIB)I")
	public static int hcf(int a, int b) {
		if (b > a) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		while (b != 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}

	@ObfuscatedName("eg.d(IB)I")
	public static int bitCount(int v) {
		v = (v >>> 1 & 0x55555555) + (v & 0x55555555);
		v = (v >>> 2 & 0x33333333) + (v & 0x33333333);
		v = (v >>> 4) + v & 0xF0F0F0F;
		v = (v >>> 8) + v;
		v = (v >>> 16) + v;
		return v & 0xFF;
	}

	// jag::oldscape::core::math::MathTool::BitsRequired
	@ObfuscatedName("az.l(IB)I")
	public static int bitsRequired(int v) {
		int bits = 0;
		if (v < 0 || v >= 65536) {
			v >>>= 16;
			bits += 16;
		}
		if (v >= 256) {
			v >>>= 8;
			bits += 8;
		}
		if (v >= 16) {
			v >>>= 4;
			bits += 4;
		}
		if (v >= 4) {
			v >>>= 2;
			bits += 2;
		}
		if (v >= 1) {
			v >>>= 1;
			bits++;
		}
		return v + bits;
	}
}
