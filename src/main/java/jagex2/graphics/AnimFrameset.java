package jagex2.graphics;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.datastruct.LinkList;
import jagex2.js5.Js5Index;

@ObfuscatedName("fr")
public class AnimFrameset extends DoublyLinkable {

	@ObfuscatedName("fr.n")
	public AnimFrame[] field2488;

	public AnimFrameset(Js5Index arg0, Js5Index arg1, int arg2, boolean arg3) {
		LinkList var5 = new LinkList();
		int var6 = arg0.method1054(arg2);
		this.field2488 = new AnimFrame[var6];
		int[] var7 = arg0.method1053(arg2);
		for (int var8 = 0; var8 < var7.length; var8++) {
			byte[] var9 = arg0.method1044(arg2, var7[var8]);
			AnimBase var10 = null;
			int var11 = (var9[0] & 0xFF) << 8 | var9[1] & 0xFF;
			for (AnimBase var12 = (AnimBase) var5.method1297(); var12 != null; var12 = (AnimBase) var5.method1299()) {
				if (var12.field1724 == var11) {
					var10 = var12;
					break;
				}
			}
			if (var10 == null) {
				byte[] var13;
				if (arg3) {
					var13 = arg1.method1050(0, var11);
				} else {
					var13 = arg1.method1050(var11, 0);
				}
				var10 = new AnimBase(var11, var13);
				var5.method1292(var10);
			}
			this.field2488[var7[var8]] = new AnimFrame(var9, var10);
		}
	}

	@ObfuscatedName("fr.z(IB)Z")
	public boolean method2652(int arg0) {
		return this.field2488[arg0].field655;
	}
}
