package jagex3.sound;

import deob.ObfuscatedName;

// jag::oldscape::sound::Mapping
@ObfuscatedName("b")
public class Mapping {

	@ObfuscatedName("b.r")
	public int submaps;

	@ObfuscatedName("b.d")
	public int mux;

	@ObfuscatedName("b.l")
	public int[] submap_floor;

	@ObfuscatedName("b.m")
	public int[] submap_residue;

	public Mapping() {
		JagVorbis.read_bits(16); // mapping_type

		this.submaps = JagVorbis.read_bool() == 0 ? 1 : JagVorbis.read_bits(4) + 1;

		if (JagVorbis.read_bool() != 0) {
			JagVorbis.read_bits(8);
		}

		JagVorbis.read_bits(2);

		if (this.submaps > 1) {
			this.mux = JagVorbis.read_bits(4);
		}

		this.submap_floor = new int[this.submaps];
		this.submap_residue = new int[this.submaps];

		for (int i = 0; i < this.submaps; i++) {
			JagVorbis.read_bits(8); // discard

			this.submap_floor[i] = JagVorbis.read_bits(8);
			this.submap_residue[i] = JagVorbis.read_bits(8);
		}
	}
}
