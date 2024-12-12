package jagex3.midi;

import deob.ObfuscatedName;

@ObfuscatedName("b")
public class VorbisMapping {

	@ObfuscatedName("b.r")
	public int submaps;

	@ObfuscatedName("b.d")
	public int mux;

	@ObfuscatedName("b.l")
	public int[] submap_floor;

	@ObfuscatedName("b.m")
	public int[] submap_residue;

	public VorbisMapping() {
		VorbisSound.read_bits(16); // mapping_type

		this.submaps = VorbisSound.read_bool() == 0 ? 1 : VorbisSound.read_bits(4) + 1;

		if (VorbisSound.read_bool() != 0) {
			VorbisSound.read_bits(8);
		}

		VorbisSound.read_bits(2);

		if (this.submaps > 1) {
			this.mux = VorbisSound.read_bits(4);
		}

		this.submap_floor = new int[this.submaps];
		this.submap_residue = new int[this.submaps];

		for (int i = 0; i < this.submaps; i++) {
			VorbisSound.read_bits(8); // discard

			this.submap_floor[i] = VorbisSound.read_bits(8);
			this.submap_residue[i] = VorbisSound.read_bits(8);
		}
	}
}
