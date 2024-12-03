package jagex2.graphics;

import deob.ObfuscatedName;
import jagex2.datastruct.Linkable;
import jagex2.io.Packet;

@ObfuscatedName("ez")
public class AnimBase extends Linkable {

	@ObfuscatedName("ez.m")
	public int field1724;

	@ObfuscatedName("ez.c")
	public int field1722;

	@ObfuscatedName("ez.n")
	public int[] field1723;

	@ObfuscatedName("ez.j")
	public int[][] field1721;

	public AnimBase(int arg0, byte[] arg1) {
		this.field1724 = arg0;
		Packet var3 = new Packet(arg1);
		this.field1722 = var3.g1();
		this.field1723 = new int[this.field1722];
		this.field1721 = new int[this.field1722][];
		for (int var4 = 0; var4 < this.field1722; var4++) {
			this.field1723[var4] = var3.g1();
		}
		for (int var5 = 0; var5 < this.field1722; var5++) {
			this.field1721[var5] = new int[var3.g1()];
		}
		for (int var6 = 0; var6 < this.field1722; var6++) {
			for (int var7 = 0; var7 < this.field1721[var6].length; var7++) {
				this.field1721[var6][var7] = var3.g1();
			}
		}
	}
}
