package jagex3.midi;

import deob.ObfuscatedName;
import jagex3.datastruct.LinkList;
import jagex3.sound.Mixer;
import jagex3.sound.PcmPlayer;
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

	// jag::oldscape::midi2::MidiMixer::DoMix
	@ObfuscatedName("ex.q([III)V")
	public void doMix(int[] arg0, int arg1, int arg2) {
		this.mixer.doMix(arg0, arg1, arg2);

		for (MidiNote note = (MidiNote) this.queue.head(); note != null; note = (MidiNote) this.queue.next()) {
			if (!this.midiPlayer.updateStreamlessNote(note)) {
				int var5 = arg1;
				int var6 = arg2;
				do {
					if (var6 <= note.volumeChangeDuration) {
						this.doMix2(note, arg0, var5, var6, var5 + var6);
						note.volumeChangeDuration -= var6;
						break;
					}

					this.doMix2(note, arg0, var5, note.volumeChangeDuration, var5 + var6);
					var5 += note.volumeChangeDuration;
					var6 -= note.volumeChangeDuration;
				} while (!this.midiPlayer.updateNote(note, arg0, var5, var6));
			}
		}
	}

	// jag::oldscape::midi2::MidiMixer::PretendToMix
	@ObfuscatedName("ex.i(I)V")
	public void pretendToMix(int arg0) {
		this.mixer.pretendToMix(arg0);

		for (MidiNote note = (MidiNote) this.queue.head(); note != null; note = (MidiNote) this.queue.next()) {
			if (!this.midiPlayer.updateStreamlessNote(note)) {
				int var3 = arg0;
				do {
					if (var3 <= note.volumeChangeDuration) {
						this.pretendToMix2(note, var3);
						note.volumeChangeDuration -= var3;
						break;
					}

					this.pretendToMix2(note, note.volumeChangeDuration);
					var3 -= note.volumeChangeDuration;
				} while (!this.midiPlayer.updateNote(note, null, 0, var3));
			}
		}
	}

	// jag::oldscape::midi2::MidiMixer::DoMix2
	@ObfuscatedName("ex.p(Lej;[IIIII)V")
	public void doMix2(MidiNote arg0, int[] arg1, int arg2, int arg3, int arg4) {
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
					arg0.stream = WaveStream.newRateFineVolPan(arg0.sound, var10.getRateRaw(), var10.getVolumeFine(), var10.getPanFine());
				} else {
					arg0.stream = WaveStream.newRateFineVolPan(arg0.sound, var10.getRateRaw(), 0, var10.getPanFine());
					this.midiPlayer.setSampleOffset(arg0, arg0.patch.notePitch[arg0.noteKey] < 0);
					arg0.stream.rampVolFine(var8, var10.getVolumeFine());
				}

				if (arg0.patch.notePitch[arg0.noteKey] < 0) {
					arg0.stream.setLoopCount(-1);
				}

				var10.rampOut(var8);
				var10.doMix(arg1, arg2, arg4 - arg2);

				if (var10.isRamping()) {
					this.mixer.playStream(var10);
				}
			}
		}

		arg0.stream.doMix(arg1, arg2, arg3);
	}

	// jag::oldscape::midi2::MidiMixer::PretendToMix2
	@ObfuscatedName("ex.ad(Lej;II)V")
	public void pretendToMix2(MidiNote arg0, int arg1) {
		if ((this.midiPlayer.channelEffects[arg0.channel] & 0x4) != 0 && arg0.releaseProgress < 0) {
			int var3 = this.midiPlayer.channelCustom3[arg0.channel] / PcmPlayer.frequency;
			int var4 = (var3 + 0xfffff - arg0.field1766) / var3;

			arg0.field1766 = arg0.field1766 + arg1 * var3 & 0xFFFFF;

			if (var4 <= arg1) {
				if (this.midiPlayer.channelCustom1[arg0.channel] == 0) {
					arg0.stream = WaveStream.newRateFineVolPan(arg0.sound, arg0.stream.getRateRaw(), arg0.stream.getVolumeFine(), arg0.stream.getPanFine());
				} else {
					arg0.stream = WaveStream.newRateFineVolPan(arg0.sound, arg0.stream.getRateRaw(), 0, arg0.stream.getPanFine());
					this.midiPlayer.setSampleOffset(arg0, arg0.patch.notePitch[arg0.noteKey] < 0);
				}

				if (arg0.patch.notePitch[arg0.noteKey] < 0) {
					arg0.stream.setLoopCount(-1);
				}

				arg1 = arg0.field1766 / var3;
			}
		}

		arg0.stream.pretendToMix(arg1);
	}
}
