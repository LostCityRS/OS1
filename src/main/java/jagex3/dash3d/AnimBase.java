package jagex3.dash3d;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable;
import jagex3.io.Packet;

// jag::oldscape::dash3d::AnimBase
@ObfuscatedName("ez")
public class AnimBase extends Linkable {

	@ObfuscatedName("ez.m")
	public int id;

	@ObfuscatedName("ez.c")
	public int size;

	@ObfuscatedName("ez.n")
	public int[] type;

	@ObfuscatedName("ez.j")
	public int[][] labels;

	public AnimBase(int id, byte[] src) {
		this.id = id;

		Packet buf = new Packet(src);
		this.size = buf.g1();
		this.type = new int[this.size];
		this.labels = new int[this.size][];

		for (int i = 0; i < this.size; i++) {
			this.type[i] = buf.g1();
		}

		for (int i = 0; i < this.size; i++) {
			this.labels[i] = new int[buf.g1()];
		}

		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.labels[i].length; j++) {
				this.labels[i][j] = buf.g1();
			}
		}
	}
}
