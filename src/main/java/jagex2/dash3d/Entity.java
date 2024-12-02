package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.datastruct.DoublyLinkable;
import jagex2.graphics.SoftwareModel;

@ObfuscatedName("fu")
public abstract class Entity extends DoublyLinkable {

	@ObfuscatedName("fu.n")
	public int field2487 = 1000;

	@ObfuscatedName("fu.z(IIIIIIIII)V")
	public void method2642(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
		SoftwareModel var10 = this.method2643();
		if (var10 != null) {
			this.field2487 = var10.field2487;
			var10.method2642(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
		}
	}

	@ObfuscatedName("fu.g(I)Lfo;")
	public SoftwareModel method2643() {
		return null;
	}
}
