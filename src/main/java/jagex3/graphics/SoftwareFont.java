package jagex3.graphics;

import deob.ObfuscatedName;

@ObfuscatedName("fm")
public class SoftwareFont extends PixFont {

	public SoftwareFont(byte[] arg0, int[] arg1, int[] arg2, int[] arg3, int[] arg4, int[] arg5, byte[][] arg6) {
		super(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
	}

	public SoftwareFont(byte[] arg0) {
		super(arg0);
	}

	@ObfuscatedName("fm.cz([BIIIII)V")
	public final void method2823(byte[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		int var7 = Pix2D.width * arg2 + arg1;
		int var8 = Pix2D.width - arg3;
		int var9 = 0;
		int var10 = 0;
		if (arg2 < top) {
			int var11 = top - arg2;
			arg4 -= var11;
			arg2 = top;
			var10 += arg3 * var11;
			var7 += Pix2D.width * var11;
		}
		if (arg2 + arg4 > bottom) {
			arg4 -= arg2 + arg4 - bottom;
		}
		if (arg1 < left) {
			int var12 = left - arg1;
			arg3 -= var12;
			arg1 = left;
			var10 += var12;
			var7 += var12;
			var9 += var12;
			var8 += var12;
		}
		if (arg1 + arg3 > right) {
			int var13 = arg1 + arg3 - right;
			arg3 -= var13;
			var9 += var13;
			var8 += var13;
		}
		if (arg3 > 0 && arg4 > 0) {
			method2834(Pix2D.pixels, arg0, arg5, var10, var7, arg3, arg4, var8, var9);
		}
	}

	@ObfuscatedName("fm.cv([BIIIIII)V")
	public final void method2883(byte[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		int var8 = Pix2D.width * arg2 + arg1;
		int var9 = Pix2D.width - arg3;
		int var10 = 0;
		int var11 = 0;
		if (arg2 < top) {
			int var12 = top - arg2;
			arg4 -= var12;
			arg2 = top;
			var11 += arg3 * var12;
			var8 += Pix2D.width * var12;
		}
		if (arg2 + arg4 > bottom) {
			arg4 -= arg2 + arg4 - bottom;
		}
		if (arg1 < left) {
			int var13 = left - arg1;
			arg3 -= var13;
			arg1 = left;
			var11 += var13;
			var8 += var13;
			var10 += var13;
			var9 += var13;
		}
		if (arg1 + arg3 > right) {
			int var14 = arg1 + arg3 - right;
			arg3 -= var14;
			var10 += var14;
			var9 += var14;
		}
		if (arg3 > 0 && arg4 > 0) {
			method2839(Pix2D.pixels, arg0, arg5, var11, var8, arg3, arg4, var9, var10, arg6);
		}
	}
}
