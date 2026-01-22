package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.config.ObjType;

// jag::oldscape::ClientObj
@ObfuscatedName("fy")
public class ClientObj extends ModelSource {

	@ObfuscatedName("fy.j")
	public int id;

	@ObfuscatedName("fy.z")
	public int count;

	// jag::oldscape::ClientObj::GetTempModel
	@ObfuscatedName("fy.g(I)Lfo;")
	public final ModelLit getTempModel() {
		return ObjType.get(this.id).getModel(this.count);
	}
}
