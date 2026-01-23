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
	public LinkList field2221 = new LinkList();

	@ObfuscatedName("ee.q")
	public int field2222 = 0;

	@ObfuscatedName("ee.i")
	public int field2220 = -1;

	// jag::oldscape::sound::Mixer::PlayStream
	@ObfuscatedName("ee.p(Ldx;)V")
	public final synchronized void playStream(PcmStream arg0) {
		this.streams.addHead(arg0);
	}

	@ObfuscatedName("ee.ad(Ldx;)V")
	public final synchronized void stopStream(PcmStream arg0) {
		arg0.unlink();
	}

	@ObfuscatedName("ee.ac()V")
	public void method2176() {
		if (this.field2222 <= 0) {
			return;
		}
		for (MixerListener var1 = (MixerListener) this.field2221.head(); var1 != null; var1 = (MixerListener) this.field2221.next()) {
			var1.field1681 -= this.field2222;
		}
		this.field2220 -= this.field2222;
		this.field2222 = 0;
	}

	@ObfuscatedName("ee.aa(Ldg;Leb;)V")
	public void method2177(Linkable arg0, MixerListener arg1) {
		while (this.field2221.sentinel != arg0 && ((MixerListener) arg0).field1681 <= arg1.field1681) {
			arg0 = arg0.next;
		}
		LinkList.method1294(arg1, arg0);
		this.field2220 = ((MixerListener) this.field2221.sentinel.next).field1681;
	}

	@ObfuscatedName("ee.as(Leb;)V")
	public void method2178(MixerListener arg0) {
		arg0.unlink();
		arg0.method1569();
		Linkable var2 = this.field2221.sentinel.next;
		if (this.field2221.sentinel == var2) {
			this.field2220 = -1;
		} else {
			this.field2220 = ((MixerListener) var2).field1681;
		}
	}

	@ObfuscatedName("ee.n()Ldx;")
	public PcmStream method1516() {
		return (PcmStream) this.streams.head();
	}

	@ObfuscatedName("ee.j()Ldx;")
	public PcmStream method1517() {
		return (PcmStream) this.streams.next();
	}

	@ObfuscatedName("ee.z()I")
	public int method1518() {
		return 0;
	}

	@ObfuscatedName("ee.q([III)V")
	public final synchronized void doMix(int[] arg0, int arg1, int arg2) {
		do {
			if (this.field2220 < 0) {
				this.playStreams(arg0, arg1, arg2);
				return;
			}
			if (this.field2222 + arg2 < this.field2220) {
				this.field2222 += arg2;
				this.playStreams(arg0, arg1, arg2);
				return;
			}
			int var4 = this.field2220 - this.field2222;
			this.playStreams(arg0, arg1, var4);
			arg1 += var4;
			arg2 -= var4;
			this.field2222 += var4;
			this.method2176();
			MixerListener var5 = (MixerListener) this.field2221.head();
			synchronized (var5) {
				int var7 = var5.method1565(this);
				if (var7 < 0) {
					var5.field1681 = 0;
					this.method2178(var5);
				} else {
					var5.field1681 = var7;
					this.method2177(var5.next, var5);
				}
			}
		} while (arg2 != 0);
	}

	@ObfuscatedName("ee.am([III)V")
	public void playStreams(int[] arg0, int arg1, int arg2) {
		for (PcmStream var4 = (PcmStream) this.streams.head(); var4 != null; var4 = (PcmStream) this.streams.next()) {
			var4.maybeMix(arg0, arg1, arg2);
		}
	}

	@ObfuscatedName("ee.i(I)V")
	public final synchronized void pretendToMix(int arg0) {
		do {
			if (this.field2220 < 0) {
				this.method2180(arg0);
				return;
			}
			if (this.field2222 + arg0 < this.field2220) {
				this.field2222 += arg0;
				this.method2180(arg0);
				return;
			}
			int var2 = this.field2220 - this.field2222;
			this.method2180(var2);
			arg0 -= var2;
			this.field2222 += var2;
			this.method2176();
			MixerListener var3 = (MixerListener) this.field2221.head();
			synchronized (var3) {
				int var5 = var3.method1565(this);
				if (var5 < 0) {
					var3.field1681 = 0;
					this.method2178(var3);
				} else {
					var3.field1681 = var5;
					this.method2177(var3.next, var3);
				}
			}
		} while (arg0 != 0);
	}

	@ObfuscatedName("ee.ap(I)V")
	public void method2180(int arg0) {
		for (PcmStream var2 = (PcmStream) this.streams.head(); var2 != null; var2 = (PcmStream) this.streams.next()) {
			var2.pretendToMix(arg0);
		}
	}
}
