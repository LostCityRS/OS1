package jagex2.dash3d;

import deob.ObfuscatedName;

@ObfuscatedName("aw")
public interface TextureProvider {

	@ObfuscatedName("aw.d(II)I")
	int getAverageRgb(int textureId);

	@ObfuscatedName("aw.l(II)Z")
	boolean isOpaque(int textureId);

	@ObfuscatedName("aw.m(II)Z")
	boolean isLowDetail(int textureId);

	@ObfuscatedName("aw.r(II)[I")
	int[] getTexels(int textureId);
}