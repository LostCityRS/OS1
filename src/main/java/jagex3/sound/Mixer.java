package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.datastruct.LinkList;
import jagex3.datastruct.Linkable;

// jag::oldscape::sound::Mixer
@ObfuscatedName("ee")
public class Mixer extends PcmStream {

	@ObfuscatedName("ee.z")
	public LinkList streams = new LinkList();

	@ObfuscatedName("ee.g")
	public LinkList controllers = new LinkList();

	@ObfuscatedName("ee.q")
	public int field2222 = 0;

	@ObfuscatedName("ee.i")
	public int field2220 = -1;

	// jag::oldscape::sound::Mixer::PlayStream
	@ObfuscatedName("ee.p(Ldx;)V")
	public final synchronized void playStream(PcmStream arg0) {
		this.streams.pushFront(arg0);
	}

	// jag::oldscape::sound::Mixer::StopStream
	@ObfuscatedName("ee.ad(Ldx;)V")
	public final synchronized void stopStream(PcmStream arg0) {
		arg0.unlink();
	}

	@ObfuscatedName("ee.ac()V")
	public void method2176() {
		if (this.field2222 <= 0) {
			return;
		}
		for (MixerController var1 = (MixerController) this.controllers.head(); var1 != null; var1 = (MixerController) this.controllers.next()) {
			var1.field1681 -= this.field2222;
		}
		this.field2220 -= this.field2222;
		this.field2222 = 0;
	}

	// jag::oldscape::sound::Mixer::SortController
	@ObfuscatedName("ee.aa(Ldg;Leb;)V")
	public void sortController(Linkable arg0, MixerController arg1) {
		while (this.controllers.sentinel != arg0 && ((MixerController) arg0).field1681 <= arg1.field1681) {
			arg0 = arg0.next;
		}
		LinkList.insertBefore(arg1, arg0);
		this.field2220 = ((MixerController) this.controllers.sentinel.next).field1681;
	}

	// jag::oldscape::sound::Mixer::UnlinkController
	@ObfuscatedName("ee.as(Leb;)V")
	public void unlinkController(MixerController arg0) {
		arg0.unlink();
		arg0.method1569();
		Linkable var2 = this.controllers.sentinel.next;
		if (this.controllers.sentinel == var2) {
			this.field2220 = -1;
		} else {
			this.field2220 = ((MixerController) var2).field1681;
		}
	}

	// jag::oldscape::sound::Mixer::SubstreamStart
	@ObfuscatedName("ee.n()Ldx;")
	public PcmStream substreamStart() {
		return (PcmStream) this.streams.head();
	}

	// jag::oldscape::sound::Mixer::SubstreamNext
	@ObfuscatedName("ee.j()Ldx;")
	public PcmStream substreamNext() {
		return (PcmStream) this.streams.next();
	}

	// jag::oldscape::sound::Mixer::SelfMixCost
	@ObfuscatedName("ee.z()I")
	public int selfMixCost() {
		return 0;
	}

	// jag::oldscape::sound::Mixer::DoMix
	@ObfuscatedName("ee.q([III)V")
	public final synchronized void doMix(int[] arg0, int arg1, int arg2) {
		do {
			if (this.field2220 < 0) {
				this.mix2(arg0, arg1, arg2);
				return;
			}
			if (this.field2222 + arg2 < this.field2220) {
				this.field2222 += arg2;
				this.mix2(arg0, arg1, arg2);
				return;
			}
			int var4 = this.field2220 - this.field2222;
			this.mix2(arg0, arg1, var4);
			arg1 += var4;
			arg2 -= var4;
			this.field2222 += var4;
			this.method2176();
			MixerController var5 = (MixerController) this.controllers.head();
			synchronized (var5) {
				int var7 = var5.method1565(this);
				if (var7 < 0) {
					var5.field1681 = 0;
					this.unlinkController(var5);
				} else {
					var5.field1681 = var7;
					this.sortController(var5.next, var5);
				}
			}
		} while (arg2 != 0);
	}

	// jag::oldscape::sound::Mixer::Mix2
	@ObfuscatedName("ee.am([III)V")
	public void mix2(int[] arg0, int arg1, int arg2) {
		for (PcmStream var4 = (PcmStream) this.streams.head(); var4 != null; var4 = (PcmStream) this.streams.next()) {
			var4.maybeMix(arg0, arg1, arg2);
		}
	}

	// jag::oldscape::sound::Mixer::PretendToMix
	@ObfuscatedName("ee.i(I)V")
	public final synchronized void pretendToMix(int arg0) {
		do {
			if (this.field2220 < 0) {
				this.pretendToMix2(arg0);
				return;
			}
			if (this.field2222 + arg0 < this.field2220) {
				this.field2222 += arg0;
				this.pretendToMix2(arg0);
				return;
			}
			int var2 = this.field2220 - this.field2222;
			this.pretendToMix2(var2);
			arg0 -= var2;
			this.field2222 += var2;
			this.method2176();
			MixerController var3 = (MixerController) this.controllers.head();
			synchronized (var3) {
				int var5 = var3.method1565(this);
				if (var5 < 0) {
					var3.field1681 = 0;
					this.unlinkController(var3);
				} else {
					var3.field1681 = var5;
					this.sortController(var3.next, var3);
				}
			}
		} while (arg0 != 0);
	}

	// jag::oldscape::sound::Mixer::PretendToMix2
	@ObfuscatedName("ee.ap(I)V")
	public void pretendToMix2(int arg0) {
		for (PcmStream var2 = (PcmStream) this.streams.head(); var2 != null; var2 = (PcmStream) this.streams.next()) {
			var2.pretendToMix(arg0);
		}
	}
}
