package jagex2.dash3d.entity;

import deob.ObfuscatedName;
import jagex2.config.ObjType;
import jagex2.graphics.ModelLit;

@ObfuscatedName("fy")
public class ObjStackEntity extends Entity {

	@ObfuscatedName("fy.j")
	public int field2600;

	@ObfuscatedName("fy.z")
	public int field2601;

	@ObfuscatedName("fy.g(I)Lfo;")
	public final ModelLit getModel() {
		return ObjType.get(this.field2600).getModel(this.field2601);
	}
}
