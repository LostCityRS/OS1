package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable;

// jag::oldscape::sound::PCMStream
@ObfuscatedName("dx")
public abstract class PcmStream extends Linkable {

	@ObfuscatedName("dx.m")
	public PcmStream stream;

	@ObfuscatedName("dx.c")
	public int field1646;

	@ObfuscatedName("dx.n")
	public PcmStreamable sound;

	@ObfuscatedName("dx.j")
	public volatile boolean active = true;

	// jag::oldscape::sound::PCMStream::Priority
	@ObfuscatedName("dx.c()I")
	public int priority() {
		return 255;
	}

	// jag::oldscape::sound::PCMStream::MaybeMix
	@ObfuscatedName("dx.g([III)V")
	public final void maybeMix(int[] arg0, int arg1, int arg2) {
		if (this.active) {
			this.doMix(arg0, arg1, arg2);
		} else {
			this.pretendToMix(arg2);
		}
	}

	@ObfuscatedName("dx.n()Ldx;")
	public abstract PcmStream substreamStart();

	@ObfuscatedName("dx.j()Ldx;")
	public abstract PcmStream substreamNext();

	@ObfuscatedName("dx.z()I")
	public abstract int selfMixCost();

	@ObfuscatedName("dx.q([III)V")
	public abstract void doMix(int[] arg0, int arg1, int arg2);

	@ObfuscatedName("dx.i(I)V")
	public abstract void pretendToMix(int arg0);
}
