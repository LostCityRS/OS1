package jagex2.graphics;

import deob.ObfuscatedName;
import deob.Statics;

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
		int var7 = Statics.field2481 * arg2 + arg1;
		int var8 = Statics.field2481 - arg3;
		int var9 = 0;
		int var10 = 0;
		if (arg2 < field2483) {
			int var11 = field2483 - arg2;
			arg4 -= var11;
			arg2 = field2483;
			var10 += arg3 * var11;
			var7 += Statics.field2481 * var11;
		}
		if (arg2 + arg4 > field2482) {
			arg4 -= arg2 + arg4 - field2482;
		}
		if (arg1 < field2485) {
			int var12 = field2485 - arg1;
			arg3 -= var12;
			arg1 = field2485;
			var10 += var12;
			var7 += var12;
			var9 += var12;
			var8 += var12;
		}
		if (arg1 + arg3 > field2484) {
			int var13 = arg1 + arg3 - field2484;
			arg3 -= var13;
			var9 += var13;
			var8 += var13;
		}
		if (arg3 > 0 && arg4 > 0) {
			method2834(Statics.field2486, arg0, arg5, var10, var7, arg3, arg4, var8, var9);
		}
	}

	@ObfuscatedName("fm.cv([BIIIIII)V")
	public final void method2883(byte[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		int var8 = Statics.field2481 * arg2 + arg1;
		int var9 = Statics.field2481 - arg3;
		int var10 = 0;
		int var11 = 0;
		if (arg2 < field2483) {
			int var12 = field2483 - arg2;
			arg4 -= var12;
			arg2 = field2483;
			var11 += arg3 * var12;
			var8 += Statics.field2481 * var12;
		}
		if (arg2 + arg4 > field2482) {
			arg4 -= arg2 + arg4 - field2482;
		}
		if (arg1 < field2485) {
			int var13 = field2485 - arg1;
			arg3 -= var13;
			arg1 = field2485;
			var11 += var13;
			var8 += var13;
			var10 += var13;
			var9 += var13;
		}
		if (arg1 + arg3 > field2484) {
			int var14 = arg1 + arg3 - field2484;
			arg3 -= var14;
			var10 += var14;
			var9 += var14;
		}
		if (arg3 > 0 && arg4 > 0) {
			method2839(Statics.field2486, arg0, arg5, var11, var8, arg3, arg4, var9, var10, arg6);
		}
	}
}
