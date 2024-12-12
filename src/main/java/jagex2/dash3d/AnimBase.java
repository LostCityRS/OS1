package jagex2.dash3d;

import deob.ObfuscatedName;
import jagex2.datastruct.Linkable;
import jagex2.io.Packet;

// jag::oldscape::dash3d::AnimBase
@ObfuscatedName("ez")
public class AnimBase extends Linkable {

	@ObfuscatedName("ez.m")
	public int field1724;

	@ObfuscatedName("ez.c")
	public int length;

	@ObfuscatedName("ez.n")
	public int[] types;

	@ObfuscatedName("ez.j")
	public int[][] labels;

	public AnimBase(int arg0, byte[] src) {
		this.field1724 = arg0;

		Packet buf = new Packet(src);
		this.length = buf.g1();
		this.types = new int[this.length];
		this.labels = new int[this.length][];

		for (int i = 0; i < this.length; i++) {
			this.types[i] = buf.g1();
		}

		for (int i = 0; i < this.length; i++) {
			this.labels[i] = new int[buf.g1()];
		}

		for (int i = 0; i < this.length; i++) {
			for (int j = 0; j < this.labels[i].length; j++) {
				this.labels[i][j] = buf.g1();
			}
		}
	}
}
