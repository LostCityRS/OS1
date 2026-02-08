package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.datastruct.LinkList;
import jagex3.io.Packet;
import jagex3.js5.Js5;

@ObfuscatedName("bi")
public class TextureManager implements TextureProvider {

	@ObfuscatedName("bi.r")
	public Texture[] textures;

	@ObfuscatedName("bi.d")
	public LinkList field722 = new LinkList();

	@ObfuscatedName("bi.l")
	public int poolSize;

	@ObfuscatedName("bi.m")
	public int field718 = 0;

	@ObfuscatedName("bi.c")
	public double brightness = 1.0D;

	@ObfuscatedName("bi.n")
	public int resolution = 128;

	@ObfuscatedName("bi.j")
	public Js5 sprites;

	public TextureManager(Js5 textures, Js5 sprites, int poolSize, double brightness, int resolution) {
		this.sprites = sprites;
		this.poolSize = poolSize;
		this.field718 = this.poolSize;
		this.brightness = brightness;
		this.resolution = resolution;

		int[] files = textures.getFileList(0);
		int count = files.length;

		this.textures = new Texture[textures.getFileIdLimit(0)];
		for (int i = 0; i < count; i++) {
			Packet buf = new Packet(textures.getFile(0, files[i]));
			this.textures[files[i]] = new Texture(buf);
		}
	}

	@ObfuscatedName("bi.u(D)V")
	public void setBrightness(double arg0) {
		this.brightness = arg0;
		this.reset();
	}

	@ObfuscatedName("bi.r(II)[I")
	public int[] getTexels(int textureId) {
		Texture var2 = this.textures[textureId];
		if (var2 != null) {
			if (var2.texels != null) {
				this.field722.pushFront(var2);
				var2.field1689 = true;
				return var2.texels;
			}
			boolean var3 = var2.loadTexture(this.brightness, this.resolution, this.sprites);
			if (var3) {
				if (this.field718 == 0) {
					Texture var4 = (Texture) this.field722.pop();
					var4.unload();
				} else {
					this.field718--;
				}
				this.field722.pushFront(var2);
				var2.field1689 = true;
				return var2.texels;
			}
		}
		return null;
	}

	@ObfuscatedName("bi.d(II)I")
	public int getAverageRgb(int textureId) {
		return this.textures[textureId] == null ? 0 : this.textures[textureId].averageRgb;
	}

	@ObfuscatedName("bi.l(II)Z")
	public boolean isOpaque(int textureId) {
		return this.textures[textureId].opaque;
	}

	@ObfuscatedName("bi.m(II)Z")
	public boolean isLowMem(int textureId) {
		return this.resolution == 64;
	}

	@ObfuscatedName("bi.v(I)V")
	public void reset() {
		for (int var1 = 0; var1 < this.textures.length; var1++) {
			if (this.textures[var1] != null) {
				this.textures[var1].unload();
			}
		}
		this.field722 = new LinkList();
		this.field718 = this.poolSize;
	}

	@ObfuscatedName("bi.w(II)V")
	public void runAnims(int arg0) {
		for (int var2 = 0; var2 < this.textures.length; var2++) {
			Texture var3 = this.textures[var2];
			if (var3 != null && var3.animationDirection != 0 && var3.field1689) {
				var3.animate(arg0);
				var3.field1689 = false;
			}
		}
	}
}
