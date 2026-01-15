package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.config.ObjType;

@ObfuscatedName("fy")
public class ClientObj extends ModelSource {

	@ObfuscatedName("fy.j")
	public int field2600;

	@ObfuscatedName("fy.z")
	public int field2601;

	@ObfuscatedName("fy.g(I)Lfo;")
	public final ModelLit getTempModel() {
		return ObjType.get(this.field2600).getModel(this.field2601);
	}
}
