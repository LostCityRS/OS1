package jagex2.sound;

import deob.ObfuscatedName;
import jagex2.datastruct.Linkable;

@ObfuscatedName("dx")
public abstract class PcmStream extends Linkable {

	@ObfuscatedName("dx.m")
	public PcmStream field1645;

	@ObfuscatedName("dx.c")
	public int field1646;

	@ObfuscatedName("dx.n")
	public Sound field1644;

	@ObfuscatedName("dx.j")
	public volatile boolean field1643 = true;

	@ObfuscatedName("dx.c()I")
	public int method1514() {
		return 255;
	}

	@ObfuscatedName("dx.g([III)V")
	public final void method1529(int[] arg0, int arg1, int arg2) {
		if (this.field1643) {
			this.method1520(arg0, arg1, arg2);
		} else {
			this.method1521(arg2);
		}
	}

	@ObfuscatedName("dx.n()Ldx;")
	public abstract PcmStream method1516();

	@ObfuscatedName("dx.j()Ldx;")
	public abstract PcmStream method1517();

	@ObfuscatedName("dx.z()I")
	public abstract int method1518();

	@ObfuscatedName("dx.q([III)V")
	public abstract void method1520(int[] arg0, int arg1, int arg2);

	@ObfuscatedName("dx.i(I)V")
	public abstract void method1521(int arg0);
}
