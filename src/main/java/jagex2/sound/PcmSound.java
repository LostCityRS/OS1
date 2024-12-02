package jagex2.sound;

import deob.ObfuscatedName;

@ObfuscatedName("eq")
public class PcmSound extends Sound {

	@ObfuscatedName("eq.c")
	public int field2200;

	@ObfuscatedName("eq.n")
	public byte[] field2204;

	@ObfuscatedName("eq.j")
	public int field2202;

	@ObfuscatedName("eq.z")
	public int field2203;

	@ObfuscatedName("eq.g")
	public boolean field2201;

	public PcmSound(int arg0, byte[] arg1, int arg2, int arg3) {
		this.field2200 = arg0;
		this.field2204 = arg1;
		this.field2202 = arg2;
		this.field2203 = arg3;
	}

	public PcmSound(int arg0, byte[] arg1, int arg2, int arg3, boolean arg4) {
		this.field2200 = arg0;
		this.field2204 = arg1;
		this.field2202 = arg2;
		this.field2203 = arg3;
		this.field2201 = arg4;
	}

	@ObfuscatedName("eq.c(Lp;)Leq;")
	public PcmSound method2050(PcmResampler arg0) {
		this.field2204 = arg0.method340(this.field2204);
		this.field2200 = arg0.method333(this.field2200);
		if (this.field2203 == this.field2202) {
			this.field2202 = this.field2203 = arg0.method334(this.field2202);
		} else {
			this.field2202 = arg0.method334(this.field2202);
			this.field2203 = arg0.method334(this.field2203);
			if (this.field2203 == this.field2202) {
				this.field2202--;
			}
		}
		return this;
	}
}
