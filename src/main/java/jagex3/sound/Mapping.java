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
		JagVorbis.readBits(16); // mapping_type

		this.submaps = JagVorbis.readBit() == 0 ? 1 : JagVorbis.readBits(4) + 1;

		if (JagVorbis.readBit() != 0) {
			JagVorbis.readBits(8);
		}

		JagVorbis.readBits(2);

		if (this.submaps > 1) {
			this.mux = JagVorbis.readBits(4);
		}

		this.submap_floor = new int[this.submaps];
		this.submap_residue = new int[this.submaps];

		for (int i = 0; i < this.submaps; i++) {
			JagVorbis.readBits(8); // discard

			this.submap_floor[i] = JagVorbis.readBits(8);
			this.submap_residue[i] = JagVorbis.readBits(8);
		}
	}
}
