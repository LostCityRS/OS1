package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.datastruct.DoublyLinkable;

@ObfuscatedName("fu")
public abstract class Entity extends DoublyLinkable {

	@ObfuscatedName("fu.n")
	public int minY = 1000;

	@ObfuscatedName("fu.z(IIIIIIIII)V")
	public void draw(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
		ModelUnlit model = this.getModel();
		if (model != null) {
			this.minY = model.minY;
			model.draw(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
		}
	}

	@ObfuscatedName("fu.g(I)Lfo;")
	public ModelUnlit getModel() {
		return null;
	}
}
