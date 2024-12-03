package jagex2.dash3d;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.datastruct.Linkable;
import jagex2.graphics.Pix3D;
import jagex2.graphics.Pix8;
import jagex2.graphics.SpriteDataProvider;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;

@ObfuscatedName("er")
public class SceneTextureProvider extends Linkable {

	@ObfuscatedName("er.z")
	public int field1687;

	@ObfuscatedName("er.g")
	public boolean field1686;

	@ObfuscatedName("er.q")
	public int[] field1696;

	@ObfuscatedName("er.i")
	public int[] field1688;

	@ObfuscatedName("er.s")
	public int[] field1690;

	@ObfuscatedName("er.u")
	public int[] field1691;

	@ObfuscatedName("er.v")
	public int field1692;

	@ObfuscatedName("er.w")
	public int field1682;

	@ObfuscatedName("er.e")
	public int[] field1694;

	@ObfuscatedName("er.b")
	public boolean field1689 = false;

	public SceneTextureProvider(Packet arg0) {
		this.field1687 = arg0.g2();
		this.field1686 = arg0.g1() == 1;
		int var2 = arg0.g1();
		if (var2 < 1 || var2 > 4) {
			throw new RuntimeException();
		}
		this.field1696 = new int[var2];
		for (int var3 = 0; var3 < var2; var3++) {
			this.field1696[var3] = arg0.g2();
		}
		if (var2 > 1) {
			this.field1688 = new int[var2 - 1];
			for (int var4 = 0; var4 < var2 - 1; var4++) {
				this.field1688[var4] = arg0.g1();
			}
		}
		if (var2 > 1) {
			this.field1690 = new int[var2 - 1];
			for (int var5 = 0; var5 < var2 - 1; var5++) {
				this.field1690[var5] = arg0.g1();
			}
		}
		this.field1691 = new int[var2];
		for (int var6 = 0; var6 < var2; var6++) {
			this.field1691[var6] = arg0.g4();
		}
		this.field1692 = arg0.g1();
		this.field1682 = arg0.g1();
		this.field1694 = null;
	}

	@ObfuscatedName("er.c(DILch;)Z")
	public boolean method1571(double arg0, int arg1, Js5Index arg2) {
		for (int var5 = 0; var5 < this.field1696.length; var5++) {
			if (arg2.method1051(this.field1696[var5]) == null) {
				return false;
			}
		}
		int var6 = arg1 * arg1;
		this.field1694 = new int[var6];
		for (int var7 = 0; var7 < this.field1696.length; var7++) {
			Pix8 var8 = SpriteDataProvider.method127(arg2, this.field1696[var7]);
			var8.method2744();
			byte[] var9 = var8.field2511;
			int[] var10 = var8.field2512;
			int var11 = this.field1691[var7];
			if ((var11 & 0xFF000000) == 16777216) {
			}
			if ((var11 & 0xFF000000) == 33554432) {
			}
			if ((var11 & 0xFF000000) == 50331648) {
				int var12 = var11 & 0xFF00FF;
				int var13 = var11 >> 8 & 0xFF;
				for (int var14 = 0; var14 < var10.length; var14++) {
					int var15 = var10[var14];
					if (var15 >> 8 == (var15 & 0xFFFF)) {
						int var16 = var15 & 0xFF;
						var10[var14] = var12 * var16 >> 8 & 0xFF00FF | var13 * var16 & 0xFF00;
					}
				}
			}
			for (int var17 = 0; var17 < var10.length; var17++) {
				var10[var17] = Pix3D.method2756(var10[var17], arg0);
			}
			int var18;
			if (var7 == 0) {
				var18 = 0;
			} else {
				var18 = this.field1688[var7 - 1];
			}
			if (var7 == 0) {
			}
			if (var18 == 0) {
				if (var8.field2513 == arg1) {
					for (int var19 = 0; var19 < var6; var19++) {
						this.field1694[var19] = var10[var9[var19] & 0xFF];
					}
				} else if (var8.field2513 == 64 && arg1 == 128) {
					int var20 = 0;
					for (int var21 = 0; var21 < arg1; var21++) {
						for (int var22 = 0; var22 < arg1; var22++) {
							this.field1694[var20++] = var10[var9[(var21 >> 1 << 6) + (var22 >> 1)] & 0xFF];
						}
					}
				} else if (var8.field2513 == 128 && arg1 == 64) {
					int var23 = 0;
					for (int var24 = 0; var24 < arg1; var24++) {
						for (int var25 = 0; var25 < arg1; var25++) {
							this.field1694[var23++] = var10[var9[(var24 << 1 << 7) + (var25 << 1)] & 0xFF];
						}
					}
				} else {
					throw new RuntimeException();
				}
			}
			if (var18 == 1) {
			}
			if (var18 == 2) {
			}
			if (var18 == 3) {
			}
		}
		return true;
	}

	@ObfuscatedName("er.n()V")
	public void method1572() {
		this.field1694 = null;
	}

	@ObfuscatedName("er.j(I)V")
	public void method1576(int arg0) {
		if (this.field1694 == null) {
			return;
		}
		if (this.field1692 == 1 || this.field1692 == 3) {
			if (Statics.field1693 == null || Statics.field1693.length < this.field1694.length) {
				Statics.field1693 = new int[this.field1694.length];
			}
			short var2;
			if (this.field1694.length == 4096) {
				var2 = 64;
			} else {
				var2 = 128;
			}
			int var3 = this.field1694.length;
			int var4 = arg0 * var2 * this.field1682;
			int var5 = var3 - 1;
			if (this.field1692 == 1) {
				var4 = -var4;
			}
			for (int var6 = 0; var6 < var3; var6++) {
				int var7 = var4 + var6 & var5;
				Statics.field1693[var6] = this.field1694[var7];
			}
			int[] var8 = this.field1694;
			this.field1694 = Statics.field1693;
			Statics.field1693 = var8;
		}
		if (this.field1692 != 2 && this.field1692 != 4) {
			return;
		}
		if (Statics.field1693 == null || Statics.field1693.length < this.field1694.length) {
			Statics.field1693 = new int[this.field1694.length];
		}
		short var9;
		if (this.field1694.length == 4096) {
			var9 = 64;
		} else {
			var9 = 128;
		}
		int var10 = this.field1694.length;
		int var11 = this.field1682 * arg0;
		int var12 = var9 - 1;
		if (this.field1692 == 2) {
			var11 = -var11;
		}
		for (int var13 = 0; var13 < var10; var13 += var9) {
			for (int var14 = 0; var14 < var9; var14++) {
				int var15 = var13 + var14;
				int var16 = (var11 + var14 & var12) + var13;
				Statics.field1693[var15] = this.field1694[var16];
			}
		}
		int[] var17 = this.field1694;
		this.field1694 = Statics.field1693;
		Statics.field1693 = var17;
	}
}
