package jagex3.midi;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable;
import jagex3.sound.Wave;
import jagex3.sound.WaveStream;

// jag::oldscape::midi2::MidiNote
@ObfuscatedName("ej")
public class MidiNote extends Linkable {

	@ObfuscatedName("ej.m")
	public int channel;

	@ObfuscatedName("ej.c")
	public Patch patch;

	@ObfuscatedName("ej.n")
	public Wave sound;

	@ObfuscatedName("ej.j")
	public EnvelopeSet envelope;

	@ObfuscatedName("ej.z")
	public int secondaryNote;

	@ObfuscatedName("ej.g")
	public int key;

	@ObfuscatedName("ej.q")
	public int volume;

	@ObfuscatedName("ej.i")
	public int pan;

	@ObfuscatedName("ej.s")
	public int pitch;

	@ObfuscatedName("ej.u")
	public int portamentoDelta;

	@ObfuscatedName("ej.v")
	public int portamentoAmount;

	@ObfuscatedName("ej.w")
	public int decayProgress;

	@ObfuscatedName("ej.e")
	public int attackProgress;

	@ObfuscatedName("ej.b")
	public int attackEnvelopeProgress;

	@ObfuscatedName("ej.y")
	public int releaseProgress;

	@ObfuscatedName("ej.t")
	public int releaseEnvelopeProgress;

	@ObfuscatedName("ej.f")
	public int vibratoRampProgress;

	@ObfuscatedName("ej.k")
	public int vibratoProgress;

	@ObfuscatedName("ej.o")
	public WaveStream stream;

	@ObfuscatedName("ej.a")
	public int volumeChangeDuration;

	@ObfuscatedName("ej.x")
	public int field1766;

	@ObfuscatedName("ej.c(B)V")
	public void dropData() {
		this.patch = null;
		this.sound = null;
		this.envelope = null;
		this.stream = null;
	}
}
