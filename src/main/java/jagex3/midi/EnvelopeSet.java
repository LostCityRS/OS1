package jagex3.midi;

import deob.ObfuscatedName;

// jag::oldscape::midi2::EnvelopeSet
@ObfuscatedName("cr")
public class EnvelopeSet {

	@ObfuscatedName("cr.r")
	public byte[] attackVolume;

	@ObfuscatedName("cr.d")
	public byte[] releaseVolume;

	@ObfuscatedName("cr.l")
	public int decayVolume;

	@ObfuscatedName("cr.m")
	public int attackSpeed;

	@ObfuscatedName("cr.c")
	public int releaseSpeed;

	@ObfuscatedName("cr.n")
	public int decaySpeed;

	@ObfuscatedName("cr.j")
	public int vibratoAmplitude;

	@ObfuscatedName("cr.z")
	public int vibratoFrequency;

	@ObfuscatedName("cr.g")
	public int vibratoRampTime;
}
