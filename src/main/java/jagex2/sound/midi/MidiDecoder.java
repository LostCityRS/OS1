package jagex2.sound.midi;

import deob.ObfuscatedName;
import jagex2.io.Packet;

@ObfuscatedName("cs")
public class MidiDecoder {

	@ObfuscatedName("cs.r")
	public Packet field1142 = new Packet(null);

	@ObfuscatedName("cs.d")
	public int field1148;

	@ObfuscatedName("cs.l")
	public int[] field1137;

	@ObfuscatedName("cs.m")
	public int[] field1140;

	@ObfuscatedName("cs.c")
	public int[] field1135;

	@ObfuscatedName("cs.n")
	public int[] field1136;

	@ObfuscatedName("cs.j")
	public int field1141;

	@ObfuscatedName("cs.g")
	public long field1143;

	@ObfuscatedName("cs.q")
	public static final byte[] field1144 = new byte[] { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	public MidiDecoder() {
	}

	public MidiDecoder(byte[] arg0) {
		this.method952(arg0);
	}

	@ObfuscatedName("cs.r([B)V")
	public void method952(byte[] arg0) {
		this.field1142.data = arg0;
		this.field1142.pos = 10;
		int var2 = this.field1142.g2();
		this.field1148 = this.field1142.g2();
		this.field1141 = 500000;
		this.field1137 = new int[var2];
		int var3 = 0;
		while (var3 < var2) {
			int var4 = this.field1142.g4();
			int var5 = this.field1142.g4();
			if (var4 == 1297379947) {
				this.field1137[var3] = this.field1142.pos;
				var3++;
			}
			this.field1142.pos += var5;
		}
		this.field1143 = 0L;
		this.field1140 = new int[var2];
		for (int var6 = 0; var6 < var2; var6++) {
			this.field1140[var6] = this.field1137[var6];
		}
		this.field1135 = new int[var2];
		this.field1136 = new int[var2];
	}

	@ObfuscatedName("cs.d()V")
	public void method965() {
		this.field1142.data = null;
		this.field1137 = null;
		this.field1140 = null;
		this.field1135 = null;
		this.field1136 = null;
	}

	@ObfuscatedName("cs.l()Z")
	public boolean method955() {
		return this.field1142.data != null;
	}

	@ObfuscatedName("cs.m()I")
	public int method956() {
		return this.field1140.length;
	}

	@ObfuscatedName("cs.c(I)V")
	public void method957(int arg0) {
		this.field1142.pos = this.field1140[arg0];
	}

	@ObfuscatedName("cs.n(I)V")
	public void method958(int arg0) {
		this.field1140[arg0] = this.field1142.pos;
	}

	@ObfuscatedName("cs.j()V")
	public void method959() {
		this.field1142.pos = -1;
	}

	@ObfuscatedName("cs.z(I)V")
	public void method960(int arg0) {
		int var2 = this.field1142.gVarInt();
		this.field1135[arg0] += var2;
	}

	@ObfuscatedName("cs.g(I)I")
	public int method967(int arg0) {
		return this.method962(arg0);
	}

	@ObfuscatedName("cs.q(I)I")
	public int method962(int arg0) {
		byte var2 = this.field1142.data[this.field1142.pos];
		int var3;
		if (var2 < 0) {
			var3 = var2 & 0xFF;
			this.field1136[arg0] = var3;
			this.field1142.pos++;
		} else {
			var3 = this.field1136[arg0];
		}
		if (var3 != 240 && var3 != 247) {
			return this.method963(arg0, var3);
		}
		int var4 = this.field1142.gVarInt();
		if (var3 == 247 && var4 > 0) {
			int var5 = this.field1142.data[this.field1142.pos] & 0xFF;
			if (var5 >= 241 && var5 <= 243 || var5 == 246 || var5 == 248 || var5 >= 250 && var5 <= 252 || var5 == 254) {
				this.field1142.pos++;
				this.field1136[arg0] = var5;
				return this.method963(arg0, var5);
			}
		}
		this.field1142.pos += var4;
		return 0;
	}

	@ObfuscatedName("cs.i(II)I")
	public int method963(int arg0, int arg1) {
		if (arg1 != 255) {
			byte var7 = field1144[arg1 - 128];
			int var8 = arg1;
			if (var7 >= 1) {
				var8 = arg1 | this.field1142.g1() << 8;
			}
			if (var7 >= 2) {
				var8 |= this.field1142.g1() << 16;
			}
			return var8;
		}
		int var3 = this.field1142.g1();
		int var4 = this.field1142.gVarInt();
		if (var3 == 47) {
			this.field1142.pos += var4;
			return 1;
		} else if (var3 == 81) {
			int var5 = this.field1142.g3();
			var4 -= 3;
			int var6 = this.field1135[arg0];
			this.field1143 += (long) (this.field1141 - var5) * (long) var6;
			this.field1141 = var5;
			this.field1142.pos += var4;
			return 2;
		} else {
			this.field1142.pos += var4;
			return 3;
		}
	}

	@ObfuscatedName("cs.s(I)J")
	public long method964(int arg0) {
		return (long) this.field1141 * (long) arg0 + this.field1143;
	}

	@ObfuscatedName("cs.u()I")
	public int method987() {
		int var1 = this.field1140.length;
		int var2 = -1;
		int var3 = Integer.MAX_VALUE;
		for (int var4 = 0; var4 < var1; var4++) {
			if (this.field1140[var4] >= 0 && this.field1135[var4] < var3) {
				var2 = var4;
				var3 = this.field1135[var4];
			}
		}
		return var2;
	}

	@ObfuscatedName("cs.v()Z")
	public boolean method966() {
		int var1 = this.field1140.length;
		for (int var2 = 0; var2 < var1; var2++) {
			if (this.field1140[var2] >= 0) {
				return false;
			}
		}
		return true;
	}

	@ObfuscatedName("cs.w(J)V")
	public void method975(long arg0) {
		this.field1143 = arg0;
		int var3 = this.field1140.length;
		for (int var4 = 0; var4 < var3; var4++) {
			this.field1135[var4] = 0;
			this.field1136[var4] = 0;
			this.field1142.pos = this.field1137[var4];
			this.method960(var4);
			this.field1140[var4] = this.field1142.pos;
		}
	}
}
