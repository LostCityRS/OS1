package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable2;
import jagex3.datastruct.LinkList;
import jagex3.js5.Js5;

// jag::oldscape::dash3d::AnimFrameSet
@ObfuscatedName("fr")
public class AnimFrameSet extends Linkable2 {

	@ObfuscatedName("fr.n")
	public AnimFrame[] list;

	public AnimFrameSet(Js5 arg0, Js5 arg1, int arg2, boolean arg3) {
		LinkList var5 = new LinkList();
		int var6 = arg0.getFileIdLimit(arg2);
		this.list = new AnimFrame[var6];
		int[] var7 = arg0.getFileList(arg2);
		for (int var8 = 0; var8 < var7.length; var8++) {
			byte[] var9 = arg0.getFile(arg2, var7[var8]);
			AnimBase var10 = null;
			int var11 = (var9[0] & 0xFF) << 8 | var9[1] & 0xFF;
			for (AnimBase var12 = (AnimBase) var5.head(); var12 != null; var12 = (AnimBase) var5.next()) {
				if (var12.id == var11) {
					var10 = var12;
					break;
				}
			}
			if (var10 == null) {
				byte[] var13;
				if (arg3) {
					var13 = arg1.peekFile(0, var11);
				} else {
					var13 = arg1.peekFile(var11, 0);
				}
				var10 = new AnimBase(var11, var13);
				var5.push(var10);
			}
			this.list[var7[var8]] = new AnimFrame(var9, var10);
		}
	}

	// jag::oldscape::dash3d::AnimFrameSet::GetAnimateTransparencies
	@ObfuscatedName("fr.z(IB)Z")
	public boolean getAnimateTransparencies(int arg0) {
		return this.list[arg0].hasAlpha;
	}
}
