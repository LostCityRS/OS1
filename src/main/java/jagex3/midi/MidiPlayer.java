package jagex3.midi;

import deob.ObfuscatedName;
import jagex3.datastruct.ByteArrayNode;
import jagex3.datastruct.HashTable;
import jagex3.js5.Js5;
import jagex3.sound.*;

// jag::oldscape::midi2::MidiPlayer
@ObfuscatedName("ed")
public class MidiPlayer extends PcmStream {

	@ObfuscatedName("ed.z")
	public HashTable patches = new HashTable(128);

	@ObfuscatedName("ed.g")
	public int globalVolume = 256;

	@ObfuscatedName("ed.q")
	public int tempoMicroseconds = 1000000;

	@ObfuscatedName("ed.i")
	public int[] channelExpression = new int[16];

	@ObfuscatedName("ed.s")
	public int[] channelPan = new int[16];

	@ObfuscatedName("ed.u")
	public int[] channelVolume = new int[16];

	@ObfuscatedName("ed.v")
	public int[] channelDefaultPatch = new int[16];

	@ObfuscatedName("ed.w")
	public int[] channelPatch = new int[16];

	@ObfuscatedName("ed.e")
	public int[] channelBank = new int[16];

	@ObfuscatedName("ed.b")
	public int[] channelPitchBend = new int[16];

	@ObfuscatedName("ed.y")
	public int[] channelModulation = new int[16];

	@ObfuscatedName("ed.t")
	public int[] channelPortamentoTime = new int[16];

	@ObfuscatedName("ed.a")
	public int[] channelEffects = new int[16];

	@ObfuscatedName("ed.h")
	public int[] channelParameterNumber = new int[16];

	@ObfuscatedName("ed.x")
	public int[] channelPitchBendRange = new int[16];

	@ObfuscatedName("ed.p")
	public int[] channelCustom1 = new int[16];

	@ObfuscatedName("ed.ad")
	public int[] channelCustom2 = new int[16];

	@ObfuscatedName("ed.ac")
	public int[] channelCustom3 = new int[16];

	@ObfuscatedName("ed.aa")
	public MidiNote[][] channelNotes = new MidiNote[16][128];

	@ObfuscatedName("ed.as")
	public MidiNote[][] channelSecondaryNotes = new MidiNote[16][128];

	@ObfuscatedName("ed.am")
	public MidiParser parser = new MidiParser();

	@ObfuscatedName("ed.ap")
	public boolean loop;

	@ObfuscatedName("ed.av")
	public int track;

	@ObfuscatedName("ed.ak")
	public int trackCurrentTick;

	@ObfuscatedName("ed.az")
	public long trackPreviousTime;

	@ObfuscatedName("ed.an")
	public long trackCurrentTime;

	@ObfuscatedName("ed.ah")
	public MidiMixer patchStream = new MidiMixer(this);

	public MidiPlayer() {
		this.reset();
	}

	@ObfuscatedName("ed.p(II)V")
	public synchronized void setGlobalVolume(int arg0) {
		this.globalVolume = arg0;
	}

	// jag::oldscape::midi2::MidiPlayer::GetGlobalVolume
	@ObfuscatedName("ed.ad(B)I")
	public int getGlobalVolume() {
		return this.globalVolume;
	}

	// jag::oldscape::midi2::MidiPlayer::LoadAndQueuePatches
	@ObfuscatedName("ed.ac(Lei;Lch;La;IB)Z")
	public synchronized boolean loadAndQueuePatches(MidiFile arg0, Js5 arg1, WaveCache arg2, int arg3) {
		arg0.method1773();
		boolean var5 = true;
		int[] var6 = null;
		if (arg3 > 0) {
			var6 = new int[] { arg3 };
		}
		for (ByteArrayNode patch = (ByteArrayNode) arg0.patches.search(); patch != null; patch = (ByteArrayNode) arg0.patches.findnext()) {
			int var8 = (int) patch.key;
			Patch var9 = (Patch) this.patches.find((long) var8);
			if (var9 == null) {
				var9 = Patch.load(arg1, var8);
				if (var9 == null) {
					var5 = false;
					continue;
				}
				this.patches.put(var9, (long) var8);
			}
			if (!var9.loadWaves(arg2, patch.data, var6)) {
				var5 = false;
			}
		}
		if (var5) {
			arg0.method1774();
		}
		return var5;
	}

	@ObfuscatedName("ed.aa(B)V")
	public synchronized void finalizePatches() {
		for (Patch patch = (Patch) this.patches.search(); patch != null; patch = (Patch) this.patches.findnext()) {
			patch.method1781();
		}
	}

	@ObfuscatedName("ed.as(I)V")
	public synchronized void clearPatches() {
		for (Patch patch = (Patch) this.patches.search(); patch != null; patch = (Patch) this.patches.findnext()) {
			patch.unlink();
		}
	}

	@ObfuscatedName("ed.am(Lei;ZB)V")
	public synchronized void start(MidiFile arg0, boolean arg1) {
		this.stop();

		this.parser.setMidi(arg0.midi);
		this.loop = arg1;
		this.trackPreviousTime = 0L;

		int var3 = this.parser.getTrackCount();
		for (int var4 = 0; var4 < var3; var4++) {
			this.parser.setTrack(var4);
			this.parser.processDeltaTime(var4);
			this.parser.unsetTrack(var4);
		}

		this.track = this.parser.nextTrackToPlay();
		this.trackCurrentTick = this.parser.trackCurrentTick[this.track];
		this.trackCurrentTime = this.parser.timeFromTick(this.trackCurrentTick);
	}

	@ObfuscatedName("ed.ap(B)V")
	public synchronized void stop() {
		this.parser.dropMidi();
		this.reset();
	}

	@ObfuscatedName("ed.av(I)Z")
	public synchronized boolean loaded() {
		return this.parser.gotMidi();
	}

	@ObfuscatedName("ed.ak(III)V")
	public synchronized void setChannelDefaultPatch(int arg0, int arg1) {
		this.setPatchAndBank(arg0, arg1);
	}

	@ObfuscatedName("ed.az(III)V")
	public void setPatchAndBank(int arg0, int arg1) {
		this.channelDefaultPatch[arg0] = arg1;
		this.channelBank[arg0] = arg1 & 0xFFFFFF80;
		this.setInst(arg0, arg1);
	}

	// jag::oldscape::midi2::MidiPlayer::SetInst
	@ObfuscatedName("ed.an(III)V")
	public void setInst(int arg0, int arg1) {
		if (this.channelPatch[arg0] == arg1) {
			return;
		}
		this.channelPatch[arg0] = arg1;
		for (int var3 = 0; var3 < 128; var3++) {
			this.channelSecondaryNotes[arg0][var3] = null;
		}
	}

	// jag::oldscape::midi2::MidiPlayer::PlayNote
	@ObfuscatedName("ed.ah(IIII)V")
	public void playNote(int arg0, int arg1, int arg2) {
		this.stopNote(arg0, arg1, 64);
		if ((this.channelEffects[arg0] & 0x2) != 0) {
			for (MidiNote var4 = (MidiNote) this.patchStream.queue.tail(); var4 != null; var4 = (MidiNote) this.patchStream.queue.prev()) {
				if (var4.channel == arg0 && var4.releaseProgress < 0) {
					this.channelNotes[arg0][var4.noteKey] = null;
					this.channelNotes[arg0][arg1] = var4;
					int var5 = (var4.portamentoAmount * var4.portamentoDelta >> 12) + var4.pitch;
					var4.pitch += arg1 - var4.noteKey << 8;
					var4.portamentoDelta = var5 - var4.pitch;
					var4.portamentoAmount = 4096;
					var4.noteKey = arg1;
					return;
				}
			}
		}
		Patch var6 = (Patch) this.patches.find((long) this.channelPatch[arg0]);
		if (var6 == null) {
			return;
		}
		Wave var7 = var6.noteSound[arg1];
		if (var7 == null) {
			return;
		}
		MidiNote var8 = new MidiNote();
		var8.channel = arg0;
		var8.patch = var6;
		var8.sound = var7;
		var8.envelope = var6.noteEnvelope[arg1];
		var8.secondaryNote = var6.noteSecondaryNote[arg1];
		var8.noteKey = arg1;
		var8.volume = var6.volume * arg2 * arg2 * var6.noteVolume[arg1] + 1024 >> 11;
		var8.pan = var6.notePan[arg1] & 0xFF;
		var8.pitch = (arg1 << 8) - (var6.notePitch[arg1] & 0x7FFF);
		var8.decayProgress = 0;
		var8.attackProgress = 0;
		var8.attackEnvelopeProgress = 0;
		var8.releaseProgress = -1;
		var8.releaseEnvelopeProgress = 0;
		if (this.channelCustom1[arg0] == 0) {
			var8.stream = WaveStream.newRateFineVolPan(var7, this.getRateRaw(var8), this.getVolume(var8), this.getPan(var8));
		} else {
			var8.stream = WaveStream.newRateFineVolPan(var7, this.getRateRaw(var8), 0, this.getPan(var8));
			this.setSampleOffset(var8, var6.notePitch[arg1] < 0);
		}
		if (var6.notePitch[arg1] < 0) {
			var8.stream.setLoopCount(-1);
		}
		if (var8.secondaryNote >= 0) {
			MidiNote var9 = this.channelSecondaryNotes[arg0][var8.secondaryNote];
			if (var9 != null && var9.releaseProgress < 0) {
				this.channelNotes[arg0][var9.noteKey] = null;
				var9.releaseProgress = 0;
			}
			this.channelSecondaryNotes[arg0][var8.secondaryNote] = var8;
		}
		this.patchStream.queue.push(var8);
		this.channelNotes[arg0][arg1] = var8;
	}

	// jag::oldscape::midi2::MidiPlayer::SetSampleOffset
	@ObfuscatedName("ed.ay(Lej;ZI)V")
	public void setSampleOffset(MidiNote arg0, boolean arg1) {
		int var3 = arg0.sound.samples.length;
		int var5;
		if (arg1 && arg0.sound.loopReversed) {
			int var4 = var3 + var3 - arg0.sound.loopStartPosition;
			var5 = (int) ((long) this.channelCustom1[arg0.channel] * (long) var4 >> 6);
			int var6 = var3 << 8;
			if (var5 >= var6) {
				var5 = var6 + var6 - 1 - var5;
				arg0.stream.setReverse(true);
			}
		} else {
			var5 = (int) ((long) this.channelCustom1[arg0.channel] * (long) var3 >> 6);
		}
		arg0.stream.setPosition(var5);
	}

	// jag::oldscape::midi2::MidiPlayer::StopNote
	@ObfuscatedName("ed.al(IIII)V")
	public void stopNote(int arg0, int arg1, int arg2) {
		MidiNote var4 = this.channelNotes[arg0][arg1];
		if (var4 == null) {
			return;
		}
		this.channelNotes[arg0][arg1] = null;
		if ((this.channelEffects[arg0] & 0x2) == 0) {
			var4.releaseProgress = 0;
			return;
		}
		for (MidiNote var5 = (MidiNote) this.patchStream.queue.head(); var5 != null; var5 = (MidiNote) this.patchStream.queue.next()) {
			if (var4.channel == var5.channel && var5.releaseProgress < 0 && var4 != var5) {
				var4.releaseProgress = 0;
				break;
			}
		}
	}

	@ObfuscatedName("ed.ab(IIII)V")
	public void setPolyphonicKeyPressure(int arg0, int arg1, int arg2) {
	}

	// jag::oldscape::midi2::MidiPlayer::ChannelPressure
	@ObfuscatedName("ed.ao(III)V")
	public void channelPressure(int arg0, int arg1) {
	}

	// jag::oldscape::midi2::MidiPlayer::PitchWheel
	@ObfuscatedName("ed.ag(IIS)V")
	public void pitchWheel(int arg0, int arg1) {
		this.channelPitchBend[arg0] = arg1;
	}

	// jag::oldscape::midi2::MidiPlayer::AllSoundOff
	@ObfuscatedName("ed.ar(IB)V")
	public void allSoundOff(int arg0) {
		for (MidiNote var2 = (MidiNote) this.patchStream.queue.head(); var2 != null; var2 = (MidiNote) this.patchStream.queue.next()) {
			if (arg0 < 0 || var2.channel == arg0) {
				if (var2.stream != null) {
					var2.stream.rampOut(PcmPlayer.frequency / 100);

					if (var2.stream.isRamping()) {
						this.patchStream.mixer.playStream(var2.stream);
					}

					var2.dropData();
				}

				if (var2.releaseProgress < 0) {
					this.channelNotes[var2.channel][var2.noteKey] = null;
				}

				var2.unlink();
			}
		}
	}

	// jag::oldscape::midi2::MidiPlayer::AllControllersOff
	@ObfuscatedName("ed.aq(II)V")
	public void allControllersOff(int arg0) {
		if (arg0 < 0) {
			for (int var2 = 0; var2 < 16; var2++) {
				this.allControllersOff(var2);
			}
			return;
		}

		this.channelExpression[arg0] = 12800;
		this.channelPan[arg0] = 8192;
		this.channelVolume[arg0] = 16383;
		this.channelPitchBend[arg0] = 8192;
		this.channelModulation[arg0] = 0;
		this.channelPortamentoTime[arg0] = 8192;
		this.cleanPorta(arg0);
		this.cleanRetrig(arg0);
		this.channelEffects[arg0] = 0;
		this.channelParameterNumber[arg0] = 32767;
		this.channelPitchBendRange[arg0] = 256;
		this.channelCustom1[arg0] = 0;
		this.setRetrigRate(arg0, 8192);
	}

	// jag::oldscape::midi2::MidiPlayer::AllNotesOff
	@ObfuscatedName("ed.at(II)V")
	public void allNotesOff(int arg0) {
		for (MidiNote var2 = (MidiNote) this.patchStream.queue.head(); var2 != null; var2 = (MidiNote) this.patchStream.queue.next()) {
			if ((arg0 < 0 || var2.channel == arg0) && var2.releaseProgress < 0) {
				this.channelNotes[var2.channel][var2.noteKey] = null;
				var2.releaseProgress = 0;
			}
		}
	}

	// jag::oldscape::midi2::MidiPlayer::Reset
	@ObfuscatedName("ed.ae(B)V")
	public void reset() {
		this.allSoundOff(-1);
		this.allControllersOff(-1);
		for (int var1 = 0; var1 < 16; var1++) {
			this.channelPatch[var1] = this.channelDefaultPatch[var1];
		}
		for (int var2 = 0; var2 < 16; var2++) {
			this.channelBank[var2] = this.channelDefaultPatch[var2] & 0xFFFFFF80;
		}
	}

	// jag::oldscape::midi2::MidiPlayer::CleanPorta
	@ObfuscatedName("ed.au(IB)V")
	public void cleanPorta(int arg0) {
		if ((this.channelEffects[arg0] & 0x2) == 0) {
			return;
		}
		for (MidiNote var2 = (MidiNote) this.patchStream.queue.head(); var2 != null; var2 = (MidiNote) this.patchStream.queue.next()) {
			if (var2.channel == arg0 && this.channelNotes[arg0][var2.noteKey] == null && var2.releaseProgress < 0) {
				var2.releaseProgress = 0;
			}
		}
	}

	// jag::oldscape::midi2::MidiPlayer::CleanRetrig
	@ObfuscatedName("ed.ax(IB)V")
	public void cleanRetrig(int arg0) {
		if ((this.channelEffects[arg0] & 0x4) == 0) {
			return;
		}
		for (MidiNote var2 = (MidiNote) this.patchStream.queue.head(); var2 != null; var2 = (MidiNote) this.patchStream.queue.next()) {
			if (var2.channel == arg0) {
				var2.field1766 = 0;
			}
		}
	}

	// jag::oldscape::midi2::MidiPlayer::ProcessMidi
	@ObfuscatedName("ed.ai(II)V")
	public void processMidi(int arg0) {
		int var2 = arg0 & 0xF0;
		if (var2 == 128) {
			int var3 = arg0 & 0xF;
			int var4 = arg0 >> 8 & 0x7F;
			int var5 = arg0 >> 16 & 0x7F;
			this.stopNote(var3, var4, var5);
		} else if (var2 == 144) {
			int var6 = arg0 & 0xF;
			int var7 = arg0 >> 8 & 0x7F;
			int var8 = arg0 >> 16 & 0x7F;
			if (var8 > 0) {
				this.playNote(var6, var7, var8);
			} else {
				this.stopNote(var6, var7, 64);
			}
		} else if (var2 == 160) {
			int var9 = arg0 & 0xF;
			int var10 = arg0 >> 8 & 0x7F;
			int var11 = arg0 >> 16 & 0x7F;
			this.setPolyphonicKeyPressure(var9, var10, var11);
		} else if (var2 == 176) {
			int var12 = arg0 & 0xF;
			int var13 = arg0 >> 8 & 0x7F;
			int var14 = arg0 >> 16 & 0x7F;
			if (var13 == 0) {
				this.channelBank[var12] = (var14 << 14) + (this.channelBank[var12] & 0xFFE03FFF);
			}
			if (var13 == 32) {
				this.channelBank[var12] = (var14 << 7) + (this.channelBank[var12] & 0xFFFFC07F);
			}
			if (var13 == 1) {
				this.channelModulation[var12] = (var14 << 7) + (this.channelModulation[var12] & 0xFFFFC07F);
			}
			if (var13 == 33) {
				this.channelModulation[var12] = (this.channelModulation[var12] & 0xFFFFFF80) + var14;
			}
			if (var13 == 5) {
				this.channelPortamentoTime[var12] = (var14 << 7) + (this.channelPortamentoTime[var12] & 0xFFFFC07F);
			}
			if (var13 == 37) {
				this.channelPortamentoTime[var12] = (this.channelPortamentoTime[var12] & 0xFFFFFF80) + var14;
			}
			if (var13 == 7) {
				this.channelExpression[var12] = (var14 << 7) + (this.channelExpression[var12] & 0xFFFFC07F);
			}
			if (var13 == 39) {
				this.channelExpression[var12] = (this.channelExpression[var12] & 0xFFFFFF80) + var14;
			}
			if (var13 == 10) {
				this.channelPan[var12] = (var14 << 7) + (this.channelPan[var12] & 0xFFFFC07F);
			}
			if (var13 == 42) {
				this.channelPan[var12] = (this.channelPan[var12] & 0xFFFFFF80) + var14;
			}
			if (var13 == 11) {
				this.channelVolume[var12] = (var14 << 7) + (this.channelVolume[var12] & 0xFFFFC07F);
			}
			if (var13 == 43) {
				this.channelVolume[var12] = (this.channelVolume[var12] & 0xFFFFFF80) + var14;
			}
			if (var13 == 64) {
				if (var14 >= 64) {
					this.channelEffects[var12] |= 0x1;
				} else {
					this.channelEffects[var12] &= 0xFFFFFFFE;
				}
			}
			if (var13 == 65) {
				if (var14 >= 64) {
					this.channelEffects[var12] |= 0x2;
				} else {
					this.cleanPorta(var12);
					this.channelEffects[var12] &= 0xFFFFFFFD;
				}
			}
			if (var13 == 99) {
				this.channelParameterNumber[var12] = (var14 << 7) + (this.channelParameterNumber[var12] & 0x7F);
			}
			if (var13 == 98) {
				this.channelParameterNumber[var12] = (this.channelParameterNumber[var12] & 0x3F80) + var14;
			}
			if (var13 == 101) {
				this.channelParameterNumber[var12] = (var14 << 7) + (this.channelParameterNumber[var12] & 0x7F) + 16384;
			}
			if (var13 == 100) {
				this.channelParameterNumber[var12] = (this.channelParameterNumber[var12] & 0x3F80) + 16384 + var14;
			}
			if (var13 == 120) {
				this.allSoundOff(var12);
			}
			if (var13 == 121) {
				this.allControllersOff(var12);
			}
			if (var13 == 123) {
				this.allNotesOff(var12);
			}
			if (var13 == 6) {
				int var15 = this.channelParameterNumber[var12];
				if (var15 == 16384) {
					this.channelPitchBendRange[var12] = (var14 << 7) + (this.channelPitchBendRange[var12] & 0xFFFFC07F);
				}
			}
			if (var13 == 38) {
				int var16 = this.channelParameterNumber[var12];
				if (var16 == 16384) {
					this.channelPitchBendRange[var12] = (this.channelPitchBendRange[var12] & 0xFFFFFF80) + var14;
				}
			}
			if (var13 == 16) {
				this.channelCustom1[var12] = (var14 << 7) + (this.channelCustom1[var12] & 0xFFFFC07F);
			}
			if (var13 == 48) {
				this.channelCustom1[var12] = (this.channelCustom1[var12] & 0xFFFFFF80) + var14;
			}
			if (var13 == 81) {
				if (var14 >= 64) {
					this.channelEffects[var12] |= 0x4;
				} else {
					this.cleanRetrig(var12);
					this.channelEffects[var12] &= 0xFFFFFFFB;
				}
			}
			if (var13 == 17) {
				this.setRetrigRate(var12, (var14 << 7) + (this.channelCustom2[var12] & 0xFFFFC07F));
			}
			if (var13 == 49) {
				this.setRetrigRate(var12, (this.channelCustom2[var12] & 0xFFFFFF80) + var14);
			}
		} else if (var2 == 192) {
			int var17 = arg0 & 0xF;
			int var18 = arg0 >> 8 & 0x7F;
			this.setInst(var17, this.channelBank[var17] + var18);
		} else if (var2 == 208) {
			int var19 = arg0 & 0xF;
			int var20 = arg0 >> 8 & 0x7F;
			this.channelPressure(var19, var20);
		} else if (var2 == 224) {
			int var21 = arg0 & 0xF;
			int var22 = (arg0 >> 8 & 0x7F) + (arg0 >> 9 & 0x3F80);
			this.pitchWheel(var21, var22);
		} else {
			int var23 = arg0 & 0xFF;
			if (var23 == 255) {
				this.reset();
			}
		}
	}

	// jag::oldscape::midi2::MidiPlayer::SetRetrigRate
	@ObfuscatedName("ed.aj(III)V")
	public void setRetrigRate(int arg0, int arg1) {
		this.channelCustom2[arg0] = arg1;
		this.channelCustom3[arg0] = (int) (Math.pow(2.0D, (double) arg1 * 5.4931640625E-4D) * 2097152.0D + 0.5D);
	}

	// jag::oldscape::midi2::MidiPlayer::GetRateRaw
	@ObfuscatedName("ed.aw(Lej;I)I")
	public int getRateRaw(MidiNote arg0) {
		int var2 = (arg0.portamentoAmount * arg0.portamentoDelta >> 12) + arg0.pitch;
		int var3 = ((this.channelPitchBend[arg0.channel] - 8192) * this.channelPitchBendRange[arg0.channel] >> 12) + var2;
		EnvelopeSet var4 = arg0.envelope;
		if (var4.vibratoFrequency > 0 && (var4.vibratoAmplitude > 0 || this.channelModulation[arg0.channel] > 0)) {
			int var5 = var4.vibratoAmplitude << 2;
			int var6 = var4.vibratoRampTime << 1;
			if (arg0.vibratoRampProgress < var6) {
				var5 = arg0.vibratoRampProgress * var5 / var6;
			}
			int var7 = (this.channelModulation[arg0.channel] >> 7) + var5;
			double var8 = Math.sin((double) (arg0.vibratoProgress & 0x1FF) * 0.01227184630308513D);
			var3 += (int) ((double) var7 * var8);
		}
		int var10 = (int) ((double) (arg0.sound.samplingFrequency * 256) * Math.pow(2.0D, (double) var3 * 3.255208333333333E-4D) / (double) PcmPlayer.frequency + 0.5D);
		return var10 < 1 ? 1 : var10;
	}

	// jag::oldscape::midi2::MidiPlayer::GetVolume
	@ObfuscatedName("ed.af(Lej;I)I")
	public int getVolume(MidiNote arg0) {
		EnvelopeSet var2 = arg0.envelope;
		int var3 = this.channelVolume[arg0.channel] * this.channelExpression[arg0.channel] + 4096 >> 13;
		int var4 = var3 * var3 + 16384 >> 15;
		int var5 = arg0.volume * var4 + 16384 >> 15;
		int var6 = this.globalVolume * var5 + 128 >> 8;
		if (var2.decayVolume > 0) {
			var6 = (int) ((double) var6 * Math.pow(0.5D, (double) arg0.decayProgress * 1.953125E-5D * (double) var2.decayVolume) + 0.5D);
		}
		if (var2.attackVolume != null) {
			int var7 = arg0.attackProgress;
			int var8 = var2.attackVolume[arg0.attackEnvelopeProgress + 1];
			if (arg0.attackEnvelopeProgress < var2.attackVolume.length - 2) {
				int var9 = (var2.attackVolume[arg0.attackEnvelopeProgress] & 0xFF) << 8;
				int var10 = (var2.attackVolume[arg0.attackEnvelopeProgress + 2] & 0xFF) << 8;
				var8 += (var2.attackVolume[arg0.attackEnvelopeProgress + 3] - var8) * (var7 - var9) / (var10 - var9);
			}
			var6 = var6 * var8 + 32 >> 6;
		}
		if (arg0.releaseProgress > 0 && var2.releaseVolume != null) {
			int var11 = arg0.releaseProgress;
			int var12 = var2.releaseVolume[arg0.releaseEnvelopeProgress + 1];
			if (arg0.releaseEnvelopeProgress < var2.releaseVolume.length - 2) {
				int var13 = (var2.releaseVolume[arg0.releaseEnvelopeProgress] & 0xFF) << 8;
				int var14 = (var2.releaseVolume[arg0.releaseEnvelopeProgress + 2] & 0xFF) << 8;
				var12 += (var2.releaseVolume[arg0.releaseEnvelopeProgress + 3] - var12) * (var11 - var13) / (var14 - var13);
			}
			var6 = var6 * var12 + 32 >> 6;
		}
		return var6;
	}

	// jag::oldscape::midi2::MidiPlayer::GetPan
	@ObfuscatedName("ed.bh(Lej;I)I")
	public int getPan(MidiNote arg0) {
		int var2 = this.channelPan[arg0.channel];
		return var2 < 8192 ? arg0.pan * var2 + 32 >> 6 : 16384 - ((128 - arg0.pan) * (16384 - var2) + 32 >> 6);
	}

	@ObfuscatedName("ed.n()Ldx;")
	public synchronized PcmStream substreamStart() {
		return this.patchStream;
	}

	@ObfuscatedName("ed.j()Ldx;")
	public synchronized PcmStream substreamNext() {
		return null;
	}

	@ObfuscatedName("ed.z()I")
	public synchronized int selfMixCost() {
		return 0;
	}

	// jag::oldscape::midi2::MidiPlayer::DoMix
	@ObfuscatedName("ed.q([III)V")
	public synchronized void doMix(int[] arg0, int arg1, int arg2) {
		if (this.parser.gotMidi()) {
			int var4 = this.tempoMicroseconds * this.parser.division / PcmPlayer.frequency;
			do {
				long var5 = (long) arg2 * (long) var4 + this.trackPreviousTime;
				if (this.trackCurrentTime - var5 >= 0L) {
					this.trackPreviousTime = var5;
					break;
				}

				int var7 = (int) ((this.trackCurrentTime - this.trackPreviousTime + (long) var4 - 1L) / (long) var4);
				this.trackPreviousTime += (long) var4 * (long) var7;
				this.patchStream.doMix(arg0, arg1, var7);

				arg1 += var7;
				arg2 -= var7;
				this.updateMidi();
			} while (this.parser.gotMidi());
		}

		this.patchStream.doMix(arg0, arg1, arg2);
	}

	// jag::oldscape::midi2::MidiPlayer::PretendToMix
	@ObfuscatedName("ed.i(I)V")
	public synchronized void pretendToMix(int arg0) {
		if (this.parser.gotMidi()) {
			int var2 = this.tempoMicroseconds * this.parser.division / PcmPlayer.frequency;
			do {
				long var3 = (long) arg0 * (long) var2 + this.trackPreviousTime;
				if (this.trackCurrentTime - var3 >= 0L) {
					this.trackPreviousTime = var3;
					break;
				}

				int var5 = (int) ((this.trackCurrentTime - this.trackPreviousTime + (long) var2 - 1L) / (long) var2);
				this.trackPreviousTime += (long) var2 * (long) var5;
				this.patchStream.pretendToMix(var5);

				arg0 -= var5;
				this.updateMidi();
			} while (this.parser.gotMidi());
		}

		this.patchStream.pretendToMix(arg0);
	}

	// jag::oldscape::midi2::MidiPlayer::UpdateMidi
	@ObfuscatedName("ed.bi(I)V")
	public void updateMidi() {
		// todo: for loop
		int var1 = this.track;
		int var2 = this.trackCurrentTick;
		long var3 = this.trackCurrentTime;

		while (this.trackCurrentTick == var2) {
			while (this.parser.trackCurrentTick[var1] == var2) {
				this.parser.setTrack(var1);

				int var5 = this.parser.getEvent(var1);
				if (var5 == 1) {
					this.parser.finishTrack();
					this.parser.unsetTrack(var1);
					if (this.parser.allTracksFinished()) {
						if (!this.loop || var2 == 0) {
							this.reset();
							this.parser.dropMidi();
							return;
						}
						this.parser.restart(var3);
					}
					break;
				}

				if ((var5 & 0x80) != 0) {
					this.processMidi(var5);
				}

				this.parser.processDeltaTime(var1);
				this.parser.unsetTrack(var1);
			}

			var1 = this.parser.nextTrackToPlay();
			var2 = this.parser.trackCurrentTick[var1];
			var3 = this.parser.timeFromTick(var2);
		}

		this.track = var1;
		this.trackCurrentTick = var2;
		this.trackCurrentTime = var3;
	}

	// jag::oldscape::midi2::MidiPlayer::UpdateStreamlessNote
	@ObfuscatedName("ed.bs(Lej;B)Z")
	public boolean updateStreamlessNote(MidiNote note) {
		if (note.stream != null) {
			return false;
		}

		if (note.releaseProgress >= 0) {
			note.unlink();

			if (note.secondaryNote > 0 && this.channelSecondaryNotes[note.channel][note.secondaryNote] == note) {
				this.channelSecondaryNotes[note.channel][note.secondaryNote] = null;
			}
		}

		return true;
	}

	// jag::oldscape::midi2::MidiPlayer::UpdateNote
	@ObfuscatedName("ed.bk(Lej;[IIIB)Z")
	public boolean updateNote(MidiNote arg0, int[] arg1, int arg2, int arg3) {
		arg0.volumeChangeDuration = PcmPlayer.frequency / 100;

		if (arg0.releaseProgress >= 0 && (arg0.stream == null || arg0.stream.isFinished())) {
			arg0.dropData();
			arg0.unlink();

			if (arg0.secondaryNote > 0 && this.channelSecondaryNotes[arg0.channel][arg0.secondaryNote] == arg0) {
				this.channelSecondaryNotes[arg0.channel][arg0.secondaryNote] = null;
			}

			return true;
		}

		int var5 = arg0.portamentoAmount;
		if (var5 > 0) {
			int var6 = var5 - (int) (Math.pow(2.0D, (double) this.channelPortamentoTime[arg0.channel] * 4.921259842519685E-4D) * 16.0D + 0.5D);
			if (var6 < 0) {
				var6 = 0;
			}
			arg0.portamentoAmount = var6;
		}

		arg0.stream.setRateRaw(this.getRateRaw(arg0));

		EnvelopeSet var7 = arg0.envelope;
		boolean var8 = false;

		arg0.vibratoRampProgress++;
		arg0.vibratoProgress += var7.vibratoFrequency;

		double var9 = (double) ((arg0.noteKey - 60 << 8) + (arg0.portamentoAmount * arg0.portamentoDelta >> 12)) * 5.086263020833333E-6D;
		if (var7.decayVolume > 0) {
			if (var7.decaySpeed > 0) {
				arg0.decayProgress += (int) (Math.pow(2.0D, (double) var7.decaySpeed * var9) * 128.0D + 0.5D);
			} else {
				arg0.decayProgress += 128;
			}
		}

		if (var7.attackVolume != null) {
			if (var7.attackSpeed > 0) {
				arg0.attackProgress += (int) (Math.pow(2.0D, (double) var7.attackSpeed * var9) * 128.0D + 0.5D);
			} else {
				arg0.attackProgress += 128;
			}
			while (arg0.attackEnvelopeProgress < var7.attackVolume.length - 2 && arg0.attackProgress > (var7.attackVolume[arg0.attackEnvelopeProgress + 2] & 0xFF) << 8) {
				arg0.attackEnvelopeProgress += 2;
			}
			if (arg0.attackEnvelopeProgress == var7.attackVolume.length - 2 && var7.attackVolume[arg0.attackEnvelopeProgress + 1] == 0) {
				var8 = true;
			}
		}

		if (arg0.releaseProgress >= 0 && var7.releaseVolume != null && (this.channelEffects[arg0.channel] & 0x1) == 0 && (arg0.secondaryNote < 0 || this.channelSecondaryNotes[arg0.channel][arg0.secondaryNote] != arg0)) {
			if (var7.releaseSpeed > 0) {
				arg0.releaseProgress += (int) (Math.pow(2.0D, (double) var7.releaseSpeed * var9) * 128.0D + 0.5D);
			} else {
				arg0.releaseProgress += 128;
			}
			while (arg0.releaseEnvelopeProgress < var7.releaseVolume.length - 2 && arg0.releaseProgress > (var7.releaseVolume[arg0.releaseEnvelopeProgress + 2] & 0xFF) << 8) {
				arg0.releaseEnvelopeProgress += 2;
			}
			if (arg0.releaseEnvelopeProgress == var7.releaseVolume.length - 2) {
				var8 = true;
			}
		}

		if (!var8) {
			arg0.stream.rampVolPanFine(arg0.volumeChangeDuration, this.getVolume(arg0), this.getPan(arg0));
			return false;
		}

		arg0.stream.rampOut(arg0.volumeChangeDuration);

		if (arg1 == null) {
			arg0.stream.pretendToMix(arg3);
		} else {
			arg0.stream.doMix(arg1, arg2, arg3);
		}

		if (arg0.stream.isRamping()) {
			this.patchStream.mixer.playStream(arg0.stream);
		}

		arg0.dropData();

		if (arg0.releaseProgress >= 0) {
			arg0.unlink();
			if (arg0.secondaryNote > 0 && this.channelSecondaryNotes[arg0.channel][arg0.secondaryNote] == arg0) {
				this.channelSecondaryNotes[arg0.channel][arg0.secondaryNote] = null;
			}
		}

		return true;
	}
}
