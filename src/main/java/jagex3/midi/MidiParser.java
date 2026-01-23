package jagex3.midi;

import deob.ObfuscatedName;
import jagex3.io.Packet;

// jag::oldscape::midi2::MidiParser
@ObfuscatedName("cs")
public class MidiParser {

	@ObfuscatedName("cs.r")
	public Packet packet = new Packet(null);

	@ObfuscatedName("cs.d")
	public int division;

	@ObfuscatedName("cs.l")
	public int[] trackStartPos;

	@ObfuscatedName("cs.m")
	public int[] trackCurrentPos;

	@ObfuscatedName("cs.c")
	public int[] trackCurrentTick;

	@ObfuscatedName("cs.n")
	public int[] trackCurrentStatus;

	@ObfuscatedName("cs.j")
	public int tempo;

	@ObfuscatedName("cs.g")
	public long baseTime;

	// jag::oldscape::midi2::MidiParser::m_msgLen
	@ObfuscatedName("cs.q")
	public static final byte[] msgLen = new byte[] {
		2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
		2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
		2, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
	};

	public MidiParser() {
	}

	public MidiParser(byte[] src) {
		this.setMidi(src);
	}

	// jag::oldscape::midi2::MidiParser::SetMidi
	@ObfuscatedName("cs.r([B)V")
	public void setMidi(byte[] src) {
		this.packet.data = src;
		this.packet.pos = 10;
		int var2 = this.packet.g2();
		this.division = this.packet.g2();
		this.tempo = 500000;
		this.trackStartPos = new int[var2];
		int var3 = 0;
		while (var3 < var2) {
			int var4 = this.packet.g4();
			int var5 = this.packet.g4();
			if (var4 == 0x4d54726b) {
				this.trackStartPos[var3] = this.packet.pos;
				var3++;
			}
			this.packet.pos += var5;
		}
		this.baseTime = 0L;
		this.trackCurrentPos = new int[var2];
		for (int var6 = 0; var6 < var2; var6++) {
			this.trackCurrentPos[var6] = this.trackStartPos[var6];
		}
		this.trackCurrentTick = new int[var2];
		this.trackCurrentStatus = new int[var2];
	}

	// jag::oldscape::midi2::MidiParser::DropMidi
	@ObfuscatedName("cs.d()V")
	public void dropMidi() {
		this.packet.data = null;
		this.trackStartPos = null;
		this.trackCurrentPos = null;
		this.trackCurrentTick = null;
		this.trackCurrentStatus = null;
	}

	// jag::oldscape::midi2::MidiParser::GotMidi
	@ObfuscatedName("cs.l()Z")
	public boolean gotMidi() {
		return this.packet.data != null;
	}

	@ObfuscatedName("cs.m()I")
	public int getTrackCount() {
		return this.trackCurrentPos.length;
	}

	// jag::oldscape::midi2::MidiParser::SetTrack
	@ObfuscatedName("cs.c(I)V")
	public void setTrack(int arg0) {
		this.packet.pos = this.trackCurrentPos[arg0];
	}

	// jag::oldscape::midi2::MidiParser::UnsetTrack
	@ObfuscatedName("cs.n(I)V")
	public void unsetTrack(int arg0) {
		this.trackCurrentPos[arg0] = this.packet.pos;
	}

	// jag::oldscape::midi2::MidiParser::FinishTrack
	@ObfuscatedName("cs.j()V")
	public void finishTrack() {
		this.packet.pos = -1;
	}

	// jag::oldscape::midi2::MidiParser::ProcessDeltaTime
	@ObfuscatedName("cs.z(I)V")
	public void processDeltaTime(int arg0) {
		int var2 = this.packet.gMidiVarLen();
		this.trackCurrentTick[arg0] += var2;
	}

	// jag::oldscape::midi2::MidiParser::GetEvent
	@ObfuscatedName("cs.g(I)I")
	public int getEvent(int arg0) {
		return this.getEvent2(arg0);
	}

	// jag::oldscape::midi2::MidiParser::GetEvent2
	@ObfuscatedName("cs.q(I)I")
	public int getEvent2(int arg0) {
		byte var2 = this.packet.data[this.packet.pos];
		int var3;
		if (var2 < 0) {
			var3 = var2 & 0xFF;
			this.trackCurrentStatus[arg0] = var3;
			this.packet.pos++;
		} else {
			var3 = this.trackCurrentStatus[arg0];
		}
		if (var3 != 240 && var3 != 247) {
			return this.getEvent3(arg0, var3);
		}
		int var4 = this.packet.gMidiVarLen();
		if (var3 == 247 && var4 > 0) {
			int var5 = this.packet.data[this.packet.pos] & 0xFF;
			if (var5 >= 241 && var5 <= 243 || var5 == 246 || var5 == 248 || var5 >= 250 && var5 <= 252 || var5 == 254) {
				this.packet.pos++;
				this.trackCurrentStatus[arg0] = var5;
				return this.getEvent3(arg0, var5);
			}
		}
		this.packet.pos += var4;
		return 0;
	}

	// jag::oldscape::midi2::MidiParser::GetEvent3
	@ObfuscatedName("cs.i(II)I")
	public int getEvent3(int arg0, int arg1) {
		if (arg1 != 255) {
			byte var7 = msgLen[arg1 - 128];
			int var8 = arg1;
			if (var7 >= 1) {
				var8 = arg1 | this.packet.g1() << 8;
			}
			if (var7 >= 2) {
				var8 |= this.packet.g1() << 16;
			}
			return var8;
		}
		int var3 = this.packet.g1();
		int var4 = this.packet.gMidiVarLen();
		if (var3 == 47) {
			this.packet.pos += var4;
			return 1;
		} else if (var3 == 81) {
			int var5 = this.packet.g3();
			var4 -= 3;
			int var6 = this.trackCurrentTick[arg0];
			this.baseTime += (long) (this.tempo - var5) * (long) var6;
			this.tempo = var5;
			this.packet.pos += var4;
			return 2;
		} else {
			this.packet.pos += var4;
			return 3;
		}
	}

	// jag::oldscape::midi2::MidiParser::TimeFromTick
	@ObfuscatedName("cs.s(I)J")
	public long timeFromTick(int arg0) {
		return (long) this.tempo * (long) arg0 + this.baseTime;
	}

	// jag::oldscape::midi2::MidiParser::NextTrackToPlay
	@ObfuscatedName("cs.u()I")
	public int nextTrackToPlay() {
		int var1 = this.trackCurrentPos.length;
		int var2 = -1;
		int var3 = Integer.MAX_VALUE;
		for (int var4 = 0; var4 < var1; var4++) {
			if (this.trackCurrentPos[var4] >= 0 && this.trackCurrentTick[var4] < var3) {
				var2 = var4;
				var3 = this.trackCurrentTick[var4];
			}
		}
		return var2;
	}

	// jag::oldscape::midi2::MidiParser::AllTracksFinished
	@ObfuscatedName("cs.v()Z")
	public boolean allTracksFinished() {
		int var1 = this.trackCurrentPos.length;
		for (int var2 = 0; var2 < var1; var2++) {
			if (this.trackCurrentPos[var2] >= 0) {
				return false;
			}
		}
		return true;
	}

	// jag::oldscape::midi2::MidiParser::Restart
	@ObfuscatedName("cs.w(J)V")
	public void restart(long arg0) {
		this.baseTime = arg0;
		int var3 = this.trackCurrentPos.length;
		for (int var4 = 0; var4 < var3; var4++) {
			this.trackCurrentTick[var4] = 0;
			this.trackCurrentStatus[var4] = 0;
			this.packet.pos = this.trackStartPos[var4];
			this.processDeltaTime(var4);
			this.trackCurrentPos[var4] = this.packet.pos;
		}
	}
}
