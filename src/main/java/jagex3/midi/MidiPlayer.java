package jagex3.midi;

import deob.ObfuscatedName;
import jagex3.datastruct.ByteArrayNode;
import jagex3.datastruct.HashTable;
import jagex3.js5.Js5Index;
import jagex3.sound.*;

// jag::oldscape::midi2::MidiPlayer
@ObfuscatedName("ed")
public class MidiPlayer extends PcmStream {

	@ObfuscatedName("ed.z")
	public HashTable patches = new HashTable(128);

	@ObfuscatedName("ed.g")
	public int volume = 256;

	@ObfuscatedName("ed.q")
	public int field2235 = 1000000;

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
	public synchronized void setVolume(int arg0) {
		this.volume = arg0;
	}

	@ObfuscatedName("ed.ad(B)I")
	public int getVolume() {
		return this.volume;
	}

	@ObfuscatedName("ed.ac(Lei;Lch;La;IB)Z")
	public synchronized boolean method2196(MidiFile arg0, Js5Index arg1, WaveCache arg2, int arg3) {
		arg0.method1773();
		boolean var5 = true;
		int[] var6 = null;
		if (arg3 > 0) {
			var6 = new int[] { arg3 };
		}
		for (ByteArrayNode var7 = (ByteArrayNode) arg0.patches.first(); var7 != null; var7 = (ByteArrayNode) arg0.patches.next()) {
			int var8 = (int) var7.nodeId;
			Patch var9 = (Patch) this.patches.get((long) var8);
			if (var9 == null) {
				var9 = Patch.method49(arg1, var8);
				if (var9 == null) {
					var5 = false;
					continue;
				}
				this.patches.put(var9, (long) var8);
			}
			if (!var9.method1784(arg2, var7.data, var6)) {
				var5 = false;
			}
		}
		if (var5) {
			arg0.method1774();
		}
		return var5;
	}

	@ObfuscatedName("ed.aa(B)V")
	public synchronized void method2220() {
		for (Patch var1 = (Patch) this.patches.first(); var1 != null; var1 = (Patch) this.patches.next()) {
			var1.method1781();
		}
	}

	@ObfuscatedName("ed.as(I)V")
	public synchronized void method2289() {
		for (Patch var1 = (Patch) this.patches.first(); var1 != null; var1 = (Patch) this.patches.next()) {
			var1.unlink();
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
			this.parser.enterTrack(var4);
			this.parser.readDelay(var4);
			this.parser.leaveTrack(var4);
		}
		this.track = this.parser.getNextTrackToPlay();
		this.trackCurrentTick = this.parser.trackCurrentTick[this.track];
		this.trackCurrentTime = this.parser.computeTime(this.trackCurrentTick);
	}

	@ObfuscatedName("ed.ap(B)V")
	public synchronized void stop() {
		this.parser.clear();
		this.reset();
	}

	@ObfuscatedName("ed.av(I)Z")
	public synchronized boolean loaded() {
		return this.parser.loaded();
	}

	@ObfuscatedName("ed.ak(III)V")
	public synchronized void setChannelDefaultPatch(int arg0, int arg1) {
		this.method2217(arg0, arg1);
	}

	@ObfuscatedName("ed.az(III)V")
	public void method2217(int arg0, int arg1) {
		this.channelDefaultPatch[arg0] = arg1;
		this.channelBank[arg0] = arg1 & 0xFFFFFF80;
		this.setChannelPatch(arg0, arg1);
	}

	@ObfuscatedName("ed.an(III)V")
	public void setChannelPatch(int arg0, int arg1) {
		if (this.channelPatch[arg0] != arg1) {
			this.channelPatch[arg0] = arg1;
			for (int var3 = 0; var3 < 128; var3++) {
				this.channelSecondaryNotes[arg0][var3] = null;
			}
		}
	}

	@ObfuscatedName("ed.ah(IIII)V")
	public void turnOnNote(int arg0, int arg1, int arg2) {
		this.turnOffNote(arg0, arg1, 64);
		if ((this.channelEffects[arg0] & 0x2) != 0) {
			for (MidiNote var4 = (MidiNote) this.patchStream.queue.tail(); var4 != null; var4 = (MidiNote) this.patchStream.queue.prev()) {
				if (var4.channel == arg0 && var4.releaseProgress < 0) {
					this.channelNotes[arg0][var4.key] = null;
					this.channelNotes[arg0][arg1] = var4;
					int var5 = (var4.portamentoAmount * var4.portamentoDelta >> 12) + var4.pitch;
					var4.pitch += arg1 - var4.key << 8;
					var4.portamentoDelta = var5 - var4.pitch;
					var4.portamentoAmount = 4096;
					var4.key = arg1;
					return;
				}
			}
		}
		Patch var6 = (Patch) this.patches.get((long) this.channelPatch[arg0]);
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
		var8.key = arg1;
		var8.volume = var6.volume * arg2 * arg2 * var6.noteVolume[arg1] + 1024 >> 11;
		var8.pan = var6.notePan[arg1] & 0xFF;
		var8.pitch = (arg1 << 8) - (var6.notePitch[arg1] & 0x7FFF);
		var8.decayProgress = 0;
		var8.attackProgress = 0;
		var8.attackEnvelopeProgress = 0;
		var8.releaseProgress = -1;
		var8.releaseEnvelopeProgress = 0;
		if (this.channelCustom1[arg0] == 0) {
			var8.stream = WaveStream.create(var7, this.computeNotePitch(var8), this.computeNoteVolume(var8), this.computeNotePan(var8));
		} else {
			var8.stream = WaveStream.create(var7, this.computeNotePitch(var8), 0, this.computeNotePan(var8));
			this.method2205(var8, var6.notePitch[arg1] < 0);
		}
		if (var6.notePitch[arg1] < 0) {
			var8.stream.setLoopCount(-1);
		}
		if (var8.secondaryNote >= 0) {
			MidiNote var9 = this.channelSecondaryNotes[arg0][var8.secondaryNote];
			if (var9 != null && var9.releaseProgress < 0) {
				this.channelNotes[arg0][var9.key] = null;
				var9.releaseProgress = 0;
			}
			this.channelSecondaryNotes[arg0][var8.secondaryNote] = var8;
		}
		this.patchStream.queue.push(var8);
		this.channelNotes[arg0][arg1] = var8;
	}

	@ObfuscatedName("ed.ay(Lej;ZI)V")
	public void method2205(MidiNote arg0, boolean arg1) {
		int var3 = arg0.sound.samples.length;
		int var5;
		if (arg1 && arg0.sound.loopReversed) {
			int var4 = var3 + var3 - arg0.sound.loopStartPosition;
			var5 = (int) ((long) this.channelCustom1[arg0.channel] * (long) var4 >> 6);
			int var6 = var3 << 8;
			if (var5 >= var6) {
				var5 = var6 + var6 - 1 - var5;
				arg0.stream.setReversed(true);
			}
		} else {
			var5 = (int) ((long) this.channelCustom1[arg0.channel] * (long) var3 >> 6);
		}
		arg0.stream.setPosition(var5);
	}

	@ObfuscatedName("ed.al(IIII)V")
	public void turnOffNote(int arg0, int arg1, int arg2) {
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

	@ObfuscatedName("ed.ao(III)V")
	public void setChannelPressure(int arg0, int arg1) {
	}

	@ObfuscatedName("ed.ag(IIS)V")
	public void setChannelPitchBend(int arg0, int arg1) {
		this.channelPitchBend[arg0] = arg1;
	}

	@ObfuscatedName("ed.ar(IB)V")
	public void controlAllSoundOff(int arg0) {
		for (MidiNote var2 = (MidiNote) this.patchStream.queue.head(); var2 != null; var2 = (MidiNote) this.patchStream.queue.next()) {
			if (arg0 < 0 || var2.channel == arg0) {
				if (var2.stream != null) {
					var2.stream.fadeOut(PcmPlayer.frequency / 100);
					if (var2.stream.isVolumeChanging()) {
						this.patchStream.mixer.playStream(var2.stream);
					}
					var2.dropData();
				}
				if (var2.releaseProgress < 0) {
					this.channelNotes[var2.channel][var2.key] = null;
				}
				var2.unlink();
			}
		}
	}

	@ObfuscatedName("ed.aq(II)V")
	public void resetChannelControls(int arg0) {
		if (arg0 < 0) {
			for (int var2 = 0; var2 < 16; var2++) {
				this.resetChannelControls(var2);
			}
			return;
		}
		this.channelExpression[arg0] = 12800;
		this.channelPan[arg0] = 8192;
		this.channelVolume[arg0] = 16383;
		this.channelPitchBend[arg0] = 8192;
		this.channelModulation[arg0] = 0;
		this.channelPortamentoTime[arg0] = 8192;
		this.resetPortamento(arg0);
		this.resetCustomEffect(arg0);
		this.channelEffects[arg0] = 0;
		this.channelParameterNumber[arg0] = 32767;
		this.channelPitchBendRange[arg0] = 256;
		this.channelCustom1[arg0] = 0;
		this.setChannelCustom2(arg0, 8192);
	}

	@ObfuscatedName("ed.at(II)V")
	public void controlAllNotesOff(int arg0) {
		for (MidiNote var2 = (MidiNote) this.patchStream.queue.head(); var2 != null; var2 = (MidiNote) this.patchStream.queue.next()) {
			if ((arg0 < 0 || var2.channel == arg0) && var2.releaseProgress < 0) {
				this.channelNotes[var2.channel][var2.key] = null;
				var2.releaseProgress = 0;
			}
		}
	}

	@ObfuscatedName("ed.ae(B)V")
	public void reset() {
		this.controlAllSoundOff(-1);
		this.resetChannelControls(-1);
		for (int var1 = 0; var1 < 16; var1++) {
			this.channelPatch[var1] = this.channelDefaultPatch[var1];
		}
		for (int var2 = 0; var2 < 16; var2++) {
			this.channelBank[var2] = this.channelDefaultPatch[var2] & 0xFFFFFF80;
		}
	}

	@ObfuscatedName("ed.au(IB)V")
	public void resetPortamento(int arg0) {
		if ((this.channelEffects[arg0] & 0x2) == 0) {
			return;
		}
		for (MidiNote var2 = (MidiNote) this.patchStream.queue.head(); var2 != null; var2 = (MidiNote) this.patchStream.queue.next()) {
			if (var2.channel == arg0 && this.channelNotes[arg0][var2.key] == null && var2.releaseProgress < 0) {
				var2.releaseProgress = 0;
			}
		}
	}

	@ObfuscatedName("ed.ax(IB)V")
	public void resetCustomEffect(int arg0) {
		if ((this.channelEffects[arg0] & 0x4) == 0) {
			return;
		}
		for (MidiNote var2 = (MidiNote) this.patchStream.queue.head(); var2 != null; var2 = (MidiNote) this.patchStream.queue.next()) {
			if (var2.channel == arg0) {
				var2.field1766 = 0;
			}
		}
	}

	@ObfuscatedName("ed.ai(II)V")
	public void processMessage(int arg0) {
		int var2 = arg0 & 0xF0;
		if (var2 == 128) {
			int var3 = arg0 & 0xF;
			int var4 = arg0 >> 8 & 0x7F;
			int var5 = arg0 >> 16 & 0x7F;
			this.turnOffNote(var3, var4, var5);
		} else if (var2 == 144) {
			int var6 = arg0 & 0xF;
			int var7 = arg0 >> 8 & 0x7F;
			int var8 = arg0 >> 16 & 0x7F;
			if (var8 > 0) {
				this.turnOnNote(var6, var7, var8);
			} else {
				this.turnOffNote(var6, var7, 64);
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
					this.resetPortamento(var12);
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
				this.controlAllSoundOff(var12);
			}
			if (var13 == 121) {
				this.resetChannelControls(var12);
			}
			if (var13 == 123) {
				this.controlAllNotesOff(var12);
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
					this.resetCustomEffect(var12);
					this.channelEffects[var12] &= 0xFFFFFFFB;
				}
			}
			if (var13 == 17) {
				this.setChannelCustom2(var12, (var14 << 7) + (this.channelCustom2[var12] & 0xFFFFC07F));
			}
			if (var13 == 49) {
				this.setChannelCustom2(var12, (this.channelCustom2[var12] & 0xFFFFFF80) + var14);
			}
		} else if (var2 == 192) {
			int var17 = arg0 & 0xF;
			int var18 = arg0 >> 8 & 0x7F;
			this.setChannelPatch(var17, this.channelBank[var17] + var18);
		} else if (var2 == 208) {
			int var19 = arg0 & 0xF;
			int var20 = arg0 >> 8 & 0x7F;
			this.setChannelPressure(var19, var20);
		} else if (var2 == 224) {
			int var21 = arg0 & 0xF;
			int var22 = (arg0 >> 8 & 0x7F) + (arg0 >> 9 & 0x3F80);
			this.setChannelPitchBend(var21, var22);
		} else {
			int var23 = arg0 & 0xFF;
			if (var23 == 255) {
				this.reset();
			}
		}
	}

	@ObfuscatedName("ed.aj(III)V")
	public void setChannelCustom2(int arg0, int arg1) {
		this.channelCustom2[arg0] = arg1;
		this.channelCustom3[arg0] = (int) (Math.pow(2.0D, (double) arg1 * 5.4931640625E-4D) * 2097152.0D + 0.5D);
	}

	@ObfuscatedName("ed.aw(Lej;I)I")
	public int computeNotePitch(MidiNote arg0) {
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

	@ObfuscatedName("ed.af(Lej;I)I")
	public int computeNoteVolume(MidiNote arg0) {
		EnvelopeSet var2 = arg0.envelope;
		int var3 = this.channelVolume[arg0.channel] * this.channelExpression[arg0.channel] + 4096 >> 13;
		int var4 = var3 * var3 + 16384 >> 15;
		int var5 = arg0.volume * var4 + 16384 >> 15;
		int var6 = this.volume * var5 + 128 >> 8;
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

	@ObfuscatedName("ed.bh(Lej;I)I")
	public int computeNotePan(MidiNote arg0) {
		int var2 = this.channelPan[arg0.channel];
		return var2 < 8192 ? arg0.pan * var2 + 32 >> 6 : 16384 - ((128 - arg0.pan) * (16384 - var2) + 32 >> 6);
	}

	@ObfuscatedName("ed.n()Ldx;")
	public synchronized PcmStream method1516() {
		return this.patchStream;
	}

	@ObfuscatedName("ed.j()Ldx;")
	public synchronized PcmStream method1517() {
		return null;
	}

	@ObfuscatedName("ed.z()I")
	public synchronized int method1518() {
		return 0;
	}

	@ObfuscatedName("ed.q([III)V")
	public synchronized void doMix(int[] arg0, int arg1, int arg2) {
		if (this.parser.loaded()) {
			int var4 = this.field2235 * this.parser.division / PcmPlayer.frequency;
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
				this.processMessages();
			} while (this.parser.loaded());
		}
		this.patchStream.doMix(arg0, arg1, arg2);
	}

	@ObfuscatedName("ed.i(I)V")
	public synchronized void pretendToMix(int arg0) {
		if (this.parser.loaded()) {
			int var2 = this.field2235 * this.parser.division / PcmPlayer.frequency;
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
				this.processMessages();
			} while (this.parser.loaded());
		}
		this.patchStream.pretendToMix(arg0);
	}

	@ObfuscatedName("ed.bi(I)V")
	public void processMessages() {
		// todo: for loop
		int var1 = this.track;
		int var2 = this.trackCurrentTick;
		long var3 = this.trackCurrentTime;
		while (this.trackCurrentTick == var2) {
			while (this.parser.trackCurrentTick[var1] == var2) {
				this.parser.enterTrack(var1);
				int var5 = this.parser.readMessage(var1);
				if (var5 == 1) {
					this.parser.stopTrack();
					this.parser.leaveTrack(var1);
					if (this.parser.isFinished()) {
						if (!this.loop || var2 == 0) {
							this.reset();
							this.parser.clear();
							return;
						}
						this.parser.startTrack(var3);
					}
					break;
				}
				if ((var5 & 0x80) != 0) {
					this.processMessage(var5);
				}
				this.parser.readDelay(var1);
				this.parser.leaveTrack(var1);
			}
			var1 = this.parser.getNextTrackToPlay();
			var2 = this.parser.trackCurrentTick[var1];
			var3 = this.parser.computeTime(var2);
		}
		this.track = var1;
		this.trackCurrentTick = var2;
		this.trackCurrentTime = var3;
	}

	@ObfuscatedName("ed.bs(Lej;B)Z")
	public boolean removeFinishedNote(MidiNote arg0) {
		if (arg0.stream != null) {
			return false;
		}
		if (arg0.releaseProgress >= 0) {
			arg0.unlink();
			if (arg0.secondaryNote > 0 && this.channelSecondaryNotes[arg0.channel][arg0.secondaryNote] == arg0) {
				this.channelSecondaryNotes[arg0.channel][arg0.secondaryNote] = null;
			}
		}
		return true;
	}

	@ObfuscatedName("ed.bk(Lej;[IIIB)Z")
	public boolean progressNote(MidiNote arg0, int[] arg1, int arg2, int arg3) {
		arg0.volumeChangeDuration = PcmPlayer.frequency / 100;
		if (arg0.releaseProgress >= 0 && (arg0.stream == null || arg0.stream.method2161())) {
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
		arg0.stream.setPitch(this.computeNotePitch(arg0));
		EnvelopeSet var7 = arg0.envelope;
		boolean var8 = false;
		arg0.vibratoRampProgress++;
		arg0.vibratoProgress += var7.vibratoFrequency;
		double var9 = (double) ((arg0.key - 60 << 8) + (arg0.portamentoAmount * arg0.portamentoDelta >> 12)) * 5.086263020833333E-6D;
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
			arg0.stream.changeVolumeSmooth(arg0.volumeChangeDuration, this.computeNoteVolume(arg0), this.computeNotePan(arg0));
			return false;
		}
		arg0.stream.fadeOut(arg0.volumeChangeDuration);
		if (arg1 == null) {
			arg0.stream.pretendToMix(arg3);
		} else {
			arg0.stream.doMix(arg1, arg2, arg3);
		}
		if (arg0.stream.isVolumeChanging()) {
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
