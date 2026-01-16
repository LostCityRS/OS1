package jagex3.midi;

import deob.ObfuscatedName;
import jagex3.datastruct.LinkList;
import jagex3.sound.PcmPlayer;
import jagex3.sound.Mixer;
import jagex3.sound.PcmStream;
import jagex3.sound.WaveStream;

// jag::oldscape::midi2::MidiMixer
@ObfuscatedName("ex")
public class MidiMixer extends PcmStream {

	@ObfuscatedName("ex.z")
	public MidiPlayer midiPlayer;

	@ObfuscatedName("ex.g")
	public LinkList queue = new LinkList();

	@ObfuscatedName("ex.q")
	public Mixer mixer = new Mixer();

	public MidiMixer(MidiPlayer arg0) {
		this.midiPlayer = arg0;
	}

	@ObfuscatedName("ex.n()Ldx;")
	public PcmStream method1516() {
		MidiNote var1 = (MidiNote) this.queue.head();
		if (var1 == null) {
			return null;
		} else if (var1.stream == null) {
			return this.method1517();
		} else {
			return var1.stream;
		}
	}

	@ObfuscatedName("ex.j()Ldx;")
	public PcmStream method1517() {
		MidiNote var1;
		do {
			var1 = (MidiNote) this.queue.next();
			if (var1 == null) {
				return null;
			}
		} while (var1.stream == null);
		return var1.stream;
	}

	@ObfuscatedName("ex.z()I")
	public int method1518() {
		return 0;
	}

	@ObfuscatedName("ex.q([III)V")
	public void doMix(int[] arg0, int arg1, int arg2) {
		this.mixer.doMix(arg0, arg1, arg2);
		for (MidiNote var4 = (MidiNote) this.queue.head(); var4 != null; var4 = (MidiNote) this.queue.next()) {
			if (!this.midiPlayer.removeFinishedNote(var4)) {
				int var5 = arg1;
				int var6 = arg2;
				do {
					if (var6 <= var4.volumeChangeDuration) {
						this.playNote(var4, arg0, var5, var6, var5 + var6);
						var4.volumeChangeDuration -= var6;
						break;
					}
					this.playNote(var4, arg0, var5, var4.volumeChangeDuration, var5 + var6);
					var5 += var4.volumeChangeDuration;
					var6 -= var4.volumeChangeDuration;
				} while (!this.midiPlayer.progressNote(var4, arg0, var5, var6));
			}
		}
	}

	@ObfuscatedName("ex.i(I)V")
	public void pretendToMix(int arg0) {
		this.mixer.pretendToMix(arg0);
		for (MidiNote var2 = (MidiNote) this.queue.head(); var2 != null; var2 = (MidiNote) this.queue.next()) {
			if (!this.midiPlayer.removeFinishedNote(var2)) {
				int var3 = arg0;
				do {
					if (var3 <= var2.volumeChangeDuration) {
						this.method2292(var2, var3);
						var2.volumeChangeDuration -= var3;
						break;
					}
					this.method2292(var2, var2.volumeChangeDuration);
					var3 -= var2.volumeChangeDuration;
				} while (!this.midiPlayer.progressNote(var2, null, 0, var3));
			}
		}
	}

	@ObfuscatedName("ex.p(Lej;[IIIII)V")
	public void playNote(MidiNote arg0, int[] arg1, int arg2, int arg3, int arg4) {
		if ((this.midiPlayer.channelEffects[arg0.channel] & 0x4) != 0 && arg0.releaseProgress < 0) {
			int var6 = this.midiPlayer.channelCustom3[arg0.channel] / PcmPlayer.frequency;
			while (true) {
				int var7 = (var6 + 0xfffff - arg0.field1766) / var6;
				if (var7 > arg3) {
					arg0.field1766 += arg3 * var6;
					break;
				}
				arg0.stream.doMix(arg1, arg2, var7);
				arg2 += var7;
				arg3 -= var7;
				arg0.field1766 += var6 * var7 - 0x100000;
				int var8 = PcmPlayer.frequency / 100;
				int var9 = 0x40000 / var6;
				if (var9 < var8) {
					var8 = var9;
				}
				WaveStream var10 = arg0.stream;
				if (this.midiPlayer.channelCustom1[arg0.channel] == 0) {
					arg0.stream = WaveStream.create(arg0.sound, var10.getPitch(), var10.getVolume(), var10.getPan());
				} else {
					arg0.stream = WaveStream.create(arg0.sound, var10.getPitch(), 0, var10.getPan());
					this.midiPlayer.method2205(arg0, arg0.patch.notePitch[arg0.key] < 0);
					arg0.stream.changeVolumeSmooth(var8, var10.getVolume());
				}
				if (arg0.patch.notePitch[arg0.key] < 0) {
					arg0.stream.setLoopCount(-1);
				}
				var10.fadeOut(var8);
				var10.doMix(arg1, arg2, arg4 - arg2);
				if (var10.isVolumeChanging()) {
					this.mixer.playStream(var10);
				}
			}
		}
		arg0.stream.doMix(arg1, arg2, arg3);
	}

	@ObfuscatedName("ex.ad(Lej;II)V")
	public void method2292(MidiNote arg0, int arg1) {
		if ((this.midiPlayer.channelEffects[arg0.channel] & 0x4) != 0 && arg0.releaseProgress < 0) {
			int var3 = this.midiPlayer.channelCustom3[arg0.channel] / PcmPlayer.frequency;
			int var4 = (var3 + 0xfffff - arg0.field1766) / var3;
			arg0.field1766 = arg0.field1766 + arg1 * var3 & 0xFFFFF;
			if (var4 <= arg1) {
				if (this.midiPlayer.channelCustom1[arg0.channel] == 0) {
					arg0.stream = WaveStream.create(arg0.sound, arg0.stream.getPitch(), arg0.stream.getVolume(), arg0.stream.getPan());
				} else {
					arg0.stream = WaveStream.create(arg0.sound, arg0.stream.getPitch(), 0, arg0.stream.getPan());
					this.midiPlayer.method2205(arg0, arg0.patch.notePitch[arg0.key] < 0);
				}
				if (arg0.patch.notePitch[arg0.key] < 0) {
					arg0.stream.setLoopCount(-1);
				}
				arg1 = arg0.field1766 / var3;
			}
		}
		arg0.stream.pretendToMix(arg1);
	}
}
