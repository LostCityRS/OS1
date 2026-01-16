package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.datastruct.LinkList;
import jagex3.io.Packet;
import jagex3.js5.Js5;

@ObfuscatedName("bi")
public class WorldTextureProvider implements TextureProvider {

	@ObfuscatedName("bi.r")
	public Texture[] field719;

	@ObfuscatedName("bi.d")
	public LinkList field722 = new LinkList();

	@ObfuscatedName("bi.l")
	public int field717;

	@ObfuscatedName("bi.m")
	public int field718 = 0;

	@ObfuscatedName("bi.c")
	public double brightness = 1.0D;

	@ObfuscatedName("bi.n")
	public int resolution = 128;

	@ObfuscatedName("bi.j")
	public Js5 spriteJs5;

	public WorldTextureProvider(Js5 textureJs5, Js5 sprite, int arg2, double brightness, int resolution) {
		this.spriteJs5 = sprite;
		this.field717 = arg2;
		this.field718 = this.field717;
		this.brightness = brightness;
		this.resolution = resolution;

		int[] files = textureJs5.getFileIds(0);
		int count = files.length;

		this.field719 = new Texture[textureJs5.getFileCount(0)];
		for (int i = 0; i < count; i++) {
			Packet buf = new Packet(textureJs5.getFile(0, files[i]));
			this.field719[files[i]] = new Texture(buf);
		}
	}

	@ObfuscatedName("bi.u(D)V")
	public void setBrightness(double arg0) {
		this.brightness = arg0;
		this.method749();
	}

	@ObfuscatedName("bi.r(II)[I")
	public int[] getTexels(int textureId) {
		Texture var2 = this.field719[textureId];
		if (var2 != null) {
			if (var2.field1694 != null) {
				this.field722.addHead(var2);
				var2.field1689 = true;
				return var2.field1694;
			}
			boolean var3 = var2.method1571(this.brightness, this.resolution, this.spriteJs5);
			if (var3) {
				if (this.field718 == 0) {
					Texture var4 = (Texture) this.field722.removeTail();
					var4.method1572();
				} else {
					this.field718--;
				}
				this.field722.addHead(var2);
				var2.field1689 = true;
				return var2.field1694;
			}
		}
		return null;
	}

	@ObfuscatedName("bi.d(II)I")
	public int getAverageRgb(int textureId) {
		return this.field719[textureId] == null ? 0 : this.field719[textureId].field1687;
	}

	@ObfuscatedName("bi.l(II)Z")
	public boolean isOpaque(int textureId) {
		return this.field719[textureId].field1686;
	}

	@ObfuscatedName("bi.m(II)Z")
	public boolean isLowMem(int textureId) {
		return this.resolution == 64;
	}

	@ObfuscatedName("bi.v(I)V")
	public void method749() {
		for (int var1 = 0; var1 < this.field719.length; var1++) {
			if (this.field719[var1] != null) {
				this.field719[var1].method1572();
			}
		}
		this.field722 = new LinkList();
		this.field718 = this.field717;
	}

	@ObfuscatedName("bi.w(II)V")
	public void runAnims(int arg0) {
		for (int var2 = 0; var2 < this.field719.length; var2++) {
			Texture var3 = this.field719[var2];
			if (var3 != null && var3.field1692 != 0 && var3.field1689) {
				var3.method1576(arg0);
				var3.field1689 = false;
			}
		}
	}
}
