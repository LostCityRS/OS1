package jagex2.sound;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.client.SignLink;
import java.awt.Component;

@ObfuscatedName("dv")
public class SignLinkAudioChannel extends AudioChannel {

	@ObfuscatedName("dv.aa")
	public int field1551;

	public SignLinkAudioChannel(SignLink arg0, int arg1) {
		Statics.field1552 = arg0.method440();
		this.field1551 = arg1;
	}

	@ObfuscatedName("dv.s(Ljava/awt/Component;)V")
	public void method209(Component arg0) throws Exception {
		Statics.field1552.method165(arg0, Statics.field241, Statics.field236, (byte) -88);
	}

	@ObfuscatedName("dv.u(I)V")
	public void method214(int arg0) throws Exception {
		if (arg0 > 32768) {
			throw new IllegalArgumentException();
		}
		Statics.field1552.method179(this.field1551, arg0, -642380930);
	}

	@ObfuscatedName("dv.v()I")
	public int method215() {
		return Statics.field1552.method166(this.field1551, (byte) -71);
	}

	@ObfuscatedName("dv.w()V")
	public void method216() {
		Statics.field1552.method167(this.field1551, this.field243, 1301391027);
	}

	@ObfuscatedName("dv.e()V")
	public void method217() {
		Statics.field1552.method171(this.field1551, 770380333);
	}

	@ObfuscatedName("dv.b()V")
	public void method218() {
		Statics.field1552.method169(this.field1551, (byte) -35);
	}
}
