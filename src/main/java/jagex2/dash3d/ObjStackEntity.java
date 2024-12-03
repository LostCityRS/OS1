package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.config.ObjType;
import jagex2.graphics.SoftwareModel;

@ObfuscatedName("fy")
public class ObjStackEntity extends Entity {

	@ObfuscatedName("fy.j")
	public int field2600;

	@ObfuscatedName("fy.z")
	public int field2601;

	@ObfuscatedName("fy.g(I)Lfo;")
	public final SoftwareModel method2643() {
		return ObjType.get(this.field2600).method2532(this.field2601);
	}
}
