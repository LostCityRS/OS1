package jagex3.io;

import deob.ObfuscatedName;
import deob.Settings;
import jagex3.datastruct.Linkable;
import jagex3.jstring.Cp1252;
import jagex3.jstring.utf8.Utf8;

import java.math.BigInteger;

@ObfuscatedName("ev")
public class Packet extends Linkable {

	@ObfuscatedName("ev.m")
	public byte[] data;

	@ObfuscatedName("ev.c")
	public int pos;

	@ObfuscatedName("ev.n")
	public static int[] crctable = new int[256];

	static {
		for (int var0 = 0; var0 < 256; var0++) {
			int var1 = var0;
			for (int var2 = 0; var2 < 8; var2++) {
				if ((var1 & 0x1) == 1) {
					var1 = var1 >>> 1 ^ 0xEDB88320;
				} else {
					var1 >>>= 0x1;
				}
			}
			crctable[var0] = var1;
		}
	}

	public Packet(int arg0) {
		this.data = ByteArrayPool.alloc(arg0);
		this.pos = 0;
	}

	public Packet(byte[] arg0) {
		this.data = arg0;
		this.pos = 0;
	}

	@ObfuscatedName("ev.c(II)V")
	public void p1(int arg0) {
		this.data[++this.pos - 1] = (byte) arg0;
	}

	@ObfuscatedName("ev.n(II)V")
	public void p2(int arg0) {
		this.data[++this.pos - 1] = (byte) (arg0 >> 8);
		this.data[++this.pos - 1] = (byte) arg0;
	}

	@ObfuscatedName("ev.j(IB)V")
	public void p3(int arg0) {
		this.data[++this.pos - 1] = (byte) (arg0 >> 16);
		this.data[++this.pos - 1] = (byte) (arg0 >> 8);
		this.data[++this.pos - 1] = (byte) arg0;
	}

	@ObfuscatedName("ev.z(IB)V")
	public void p4(int arg0) {
		this.data[++this.pos - 1] = (byte) (arg0 >> 24);
		this.data[++this.pos - 1] = (byte) (arg0 >> 16);
		this.data[++this.pos - 1] = (byte) (arg0 >> 8);
		this.data[++this.pos - 1] = (byte) arg0;
	}

	@ObfuscatedName("ev.g(J)V")
	public void p8(long arg0) {
		this.data[++this.pos - 1] = (byte) (arg0 >> 56);
		this.data[++this.pos - 1] = (byte) (arg0 >> 48);
		this.data[++this.pos - 1] = (byte) (arg0 >> 40);
		this.data[++this.pos - 1] = (byte) (arg0 >> 32);
		this.data[++this.pos - 1] = (byte) (arg0 >> 24);
		this.data[++this.pos - 1] = (byte) (arg0 >> 16);
		this.data[++this.pos - 1] = (byte) (arg0 >> 8);
		this.data[++this.pos - 1] = (byte) arg0;
	}

	@ObfuscatedName("ea.q(Ljava/lang/String;I)I")
	public static int pjstrlen(String arg0) {
		return arg0.length() + 1;
	}

	// jag::PacketT::pStringUTF8ToCP1252
	@ObfuscatedName("ev.i(Ljava/lang/String;I)V")
	public void pjstr(String s) {
		int nul = s.indexOf(0);
		if (nul >= 0) {
			throw new IllegalArgumentException("");
		}

		this.pos += Cp1252.encodeStringToCp1252(s, 0, s.length(), this.data, this.pos);
		this.data[++this.pos - 1] = 0;
	}

	// jag::oldscape::javapal::Packet_pUTF8
	@ObfuscatedName("ev.s(Ljava/lang/CharSequence;I)V")
	public void pUTF8(CharSequence arg0) {
		int var2 = Utf8.getUtf8Length(arg0);
		this.data[++this.pos - 1] = 0;
		this.pMidiVarLen(var2);
		this.pos += Utf8.encodeUtf8(this.data, this.pos, arg0);
	}

	// jag::PacketT::pArrayBuffer
	@ObfuscatedName("ev.u([BIIB)V")
	public void pdata(byte[] arg0, int arg1, int arg2) {
		for (int var4 = arg1; var4 < arg1 + arg2; var4++) {
			this.data[++this.pos - 1] = arg0[var4];
		}
	}

	// jag::PacketT::pSize4
	@ObfuscatedName("ev.v(II)V")
	public void psize4(int len) {
		this.data[this.pos - len - 4] = (byte) (len >> 24);
		this.data[this.pos - len - 3] = (byte) (len >> 16);
		this.data[this.pos - len - 2] = (byte) (len >> 8);
		this.data[this.pos - len - 1] = (byte) len;
	}

	// jag::PacketT::pSize2
	@ObfuscatedName("ev.w(II)V")
	public void psize2(int len) {
		this.data[this.pos - len - 2] = (byte) (len >> 8);
		this.data[this.pos - len - 1] = (byte) len;
	}

	// jag::PacketT::pSize1
	@ObfuscatedName("ev.e(IB)V")
	public void psize1(int len) {
		this.data[this.pos - len - 1] = (byte) len;
	}

	// jag::PacketT::pSmart1or2
	@ObfuscatedName("ev.b(II)V")
	public void psmart(int n) {
		if (n >= 0 && n < 0x80) {
			this.p1(n);
		} else if (n >= 0 && n < 0x8000) {
			this.p2(n + 0x8000);
		} else {
			throw new IllegalArgumentException();
		}
	}

	// jag::oldscape::PacketJ::pMidiVarLen
	@ObfuscatedName("ev.y(II)V")
	public void pMidiVarLen(int n) {
		if ((n & 0xFFFFFF80) != 0) {
			if ((n & 0xFFFFC000) != 0) {
				if ((n & 0xFFE00000) != 0) {
					if ((n & 0xF0000000) != 0) {
						this.p1(n >>> 28 | 0x80);
					}
					this.p1(n >>> 21 | 0x80);
				}
				this.p1(n >>> 14 | 0x80);
			}
			this.p1(n >>> 7 | 0x80);
		}
		this.p1(n & 0x7F);
	}

	@ObfuscatedName("ev.t(I)I")
	public int g1() {
		return this.data[++this.pos - 1] & 0xFF;
	}

	@ObfuscatedName("ev.f(I)B")
	public byte g1b() {
		return this.data[++this.pos - 1];
	}

	@ObfuscatedName("ev.k(I)I")
	public int g2() {
		this.pos += 2;
		return ((this.data[this.pos - 2] & 0xFF) << 8) + (this.data[this.pos - 1] & 0xFF);
	}

	@ObfuscatedName("ev.o(I)I")
	public int g2b() {
		this.pos += 2;
		int var1 = ((this.data[this.pos - 2] & 0xFF) << 8) + (this.data[this.pos - 1] & 0xFF);
		if (var1 > 32767) {
			var1 -= 65536;
		}
		return var1;
	}

	@ObfuscatedName("ev.a(B)I")
	public int g3() {
		this.pos += 3;
		return (this.data[this.pos - 1] & 0xFF) + ((this.data[this.pos - 2] & 0xFF) << 8) + ((this.data[this.pos - 3] & 0xFF) << 16);
	}

	@ObfuscatedName("ev.h(I)I")
	public int g4() {
		this.pos += 4;
		return (this.data[this.pos - 1] & 0xFF) + ((this.data[this.pos - 2] & 0xFF) << 8) + ((this.data[this.pos - 3] & 0xFF) << 16) + ((this.data[this.pos - 4] & 0xFF) << 24);
	}

	@ObfuscatedName("ev.x(I)J")
	public long g8() {
		long var1 = (long) this.g4() & 0xFFFFFFFFL;
		long var3 = (long) this.g4() & 0xFFFFFFFFL;
		return (var1 << 32) + var3;
	}

	@ObfuscatedName("ev.p(I)Ljava/lang/String;")
	public String fastgstr() {
		if (this.data[this.pos] == 0) {
			this.pos++;
			return null;
		} else {
			return this.gjstr();
		}
	}

	@ObfuscatedName("ev.ad(I)Ljava/lang/String;")
	public String gjstr() {
		int var1 = this.pos;
		while (this.data[++this.pos - 1] != 0) {
		}
		int var2 = this.pos - var1 - 1;
		return var2 == 0 ? "" : Cp1252.cp1252ToUtf8(this.data, var1, var2);
	}

	@ObfuscatedName("ev.ac(B)Ljava/lang/String;")
	public String gjstr2() {
		byte var1 = this.data[++this.pos - 1];
		if (var1 != 0) {
			throw new IllegalStateException("");
		}
		int var2 = this.pos;
		while (this.data[++this.pos - 1] != 0) {
		}
		int var3 = this.pos - var2 - 1;
		return var3 == 0 ? "" : Cp1252.cp1252ToUtf8(this.data, var2, var3);
	}

	@ObfuscatedName("ev.aa(I)Ljava/lang/String;")
	public String gUTF8() {
		byte var1 = this.data[++this.pos - 1];
		if (var1 != 0) {
			throw new IllegalStateException("");
		}
		int var2 = this.gMidiVarLen();
		if (this.pos + var2 > this.data.length) {
			throw new IllegalStateException("");
		}
		byte[] var3 = this.data;
		int var4 = this.pos;
		char[] var5 = new char[var2];
		int var6 = 0;
		int var7 = var4;
		int var8 = var2 + var4;
		while (var7 < var8) {
			int var9 = var3[var7++] & 0xFF;
			int var10;
			if (var9 < 128) {
				if (var9 == 0) {
					var10 = 65533;
				} else {
					var10 = var9;
				}
			} else if (var9 < 192) {
				var10 = 65533;
			} else if (var9 < 224) {
				if (var7 < var8 && (var3[var7] & 0xC0) == 128) {
					var10 = (var9 & 0x1F) << 6 | var3[var7++] & 0x3F;
					if (var10 < 128) {
						var10 = 65533;
					}
				} else {
					var10 = 65533;
				}
			} else if (var9 < 240) {
				if (var7 + 1 < var8 && (var3[var7] & 0xC0) == 128 && (var3[var7 + 1] & 0xC0) == 128) {
					var10 = (var9 & 0xF) << 12 | (var3[var7++] & 0x3F) << 6 | var3[var7++] & 0x3F;
					if (var10 < 2048) {
						var10 = 65533;
					}
				} else {
					var10 = 65533;
				}
			} else if (var9 >= 248) {
				var10 = 65533;
			} else if (var7 + 2 < var8 && (var3[var7] & 0xC0) == 128 && (var3[var7 + 1] & 0xC0) == 128 && (var3[var7 + 2] & 0xC0) == 128) {
				int var11 = (var9 & 0x7) << 18 | (var3[var7++] & 0x3F) << 12 | (var3[var7++] & 0x3F) << 6 | var3[var7++] & 0x3F;
				if (var11 >= 65536 && var11 <= 1114111) {
					var10 = 65533;
				} else {
					var10 = 65533;
				}
			} else {
				var10 = 65533;
			}
			var5[var6++] = (char) var10;
		}
		String var12 = new String(var5, 0, var6);
		this.pos += var2;
		return var12;
	}

	@ObfuscatedName("ev.as([BIII)V")
	public void gdata(byte[] arg0, int arg1, int arg2) {
		for (int var4 = arg1; var4 < arg1 + arg2; var4++) {
			arg0[var4] = this.data[++this.pos - 1];
		}
	}

	@ObfuscatedName("ev.am(I)I")
	public int gsmarts() {
		int var1 = this.data[this.pos] & 0xFF;
		return var1 < 128 ? this.g1() - 64 : this.g2() - 49152;
	}

	@ObfuscatedName("ev.ap(I)I")
	public int gsmart() {
		int var1 = this.data[this.pos] & 0xFF;
		return var1 < 128 ? this.g1() : this.g2() - 32768;
	}

	@ObfuscatedName("ev.av(S)I")
	public int gSmart2or4() {
		return this.data[this.pos] < 0 ? this.g4() & Integer.MAX_VALUE : this.g2();
	}

	@ObfuscatedName("ev.ak(B)I")
	public int gMidiVarLen() {
		byte var1 = this.data[++this.pos - 1];
		int var2 = 0;
		while (var1 < 0) {
			var2 = (var2 | var1 & 0x7F) << 7;
			var1 = this.data[++this.pos - 1];
		}
		return var2 | var1;
	}

	@ObfuscatedName("ev.az([IIII)V")
	public void tinyenc(int[] arg0, int arg1, int arg2) {
		if (Settings.NO_TINYENC) {
			return;
		}

		int var4 = this.pos;
		this.pos = arg1;
		int var5 = (arg2 - arg1) / 8;
		for (int var6 = 0; var6 < var5; var6++) {
			int var7 = this.g4();
			int var8 = this.g4();
			int var9 = 0;
			int var10 = -1640531527;
			int var11 = 32;
			while (var11-- > 0) {
				var7 += (var8 << 4 ^ var8 >>> 5) + var8 ^ arg0[var9 & 0x3] + var9;
				var9 += var10;
				var8 += (var7 << 4 ^ var7 >>> 5) + var7 ^ arg0[var9 >>> 11 & 0x3] + var9;
			}
			this.pos -= 8;
			this.p4(var7);
			this.p4(var8);
		}
		this.pos = var4;
	}

	@ObfuscatedName("ev.an([IIII)V")
	public void tinydec(int[] arg0, int arg1, int arg2) {
		int var4 = this.pos;
		this.pos = arg1;
		int var5 = (arg2 - arg1) / 8;
		for (int var6 = 0; var6 < var5; var6++) {
			int var7 = this.g4();
			int var8 = this.g4();
			int var9 = -957401312;
			int var10 = -1640531527;
			int var11 = 32;
			while (var11-- > 0) {
				var8 -= (var7 << 4 ^ var7 >>> 5) + var7 ^ arg0[var9 >>> 11 & 0x3] + var9;
				var9 -= var10;
				var7 -= (var8 << 4 ^ var8 >>> 5) + var8 ^ arg0[var9 & 0x3] + var9;
			}
			this.pos -= 8;
			this.p4(var7);
			this.p4(var8);
		}
		this.pos = var4;
	}

	@ObfuscatedName("ev.ah(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V")
	public void rsaenc(BigInteger arg0, BigInteger arg1) {
		int var3 = this.pos;
		this.pos = 0;
		byte[] var4 = new byte[var3];
		this.gdata(var4, 0, var3);

		if (Settings.NO_RSA) {
			this.p2(var4.length);
			this.pdata(var4, 0, var4.length);
		} else {
			BigInteger var5 = new BigInteger(var4);
			BigInteger var6 = var5.modPow(arg0, arg1);
			byte[] var7 = var6.toByteArray();
			this.pos = 0;
			this.p2(var7.length);
			this.pdata(var7, 0, var7.length);
		}
	}

	@ObfuscatedName("ev.ay(II)I")
	public int addcrc(int arg0) {
		byte[] var2 = this.data;
		int var3 = this.pos;
		int var4 = -1;
		for (int var5 = arg0; var5 < var3; var5++) {
			var4 = var4 >>> 8 ^ crctable[(var4 ^ var2[var5]) & 0xFF];
		}
		int var6 = ~var4;
		this.p4(var6);
		return var6;
	}

	@ObfuscatedName("ev.al(I)Z")
	public boolean checkcrc() {
		this.pos -= 4;
		byte[] var1 = this.data;
		int var2 = this.pos;
		int var3 = -1;
		for (int var4 = 0; var4 < var2; var4++) {
			var3 = var3 >>> 8 ^ crctable[(var3 ^ var1[var4]) & 0xFF];
		}
		int var5 = ~var3;
		int var8 = this.g4();
		return var5 == var8;
	}

	@ObfuscatedName("ev.ab(II)V")
	public void p1_alt1(int arg0) {
		if (Settings.NO_ALT_METHODS) {
			this.p1(arg0);
			return;
		}

		this.data[++this.pos - 1] = (byte) (arg0 + 128);
	}

	@ObfuscatedName("ev.ao(IS)V")
	public void p1_alt2(int arg0) {
		if (Settings.NO_ALT_METHODS) {
			this.p1(arg0);
			return;
		}

		this.data[++this.pos - 1] = (byte) -arg0;
	}

	@ObfuscatedName("ev.ag(II)V")
	public void p1_alt3(int arg0) {
		if (Settings.NO_ALT_METHODS) {
			this.p1(arg0);
			return;
		}

		this.data[++this.pos - 1] = (byte) (128 - arg0);
	}

	@ObfuscatedName("ev.ar(I)I")
	public int g1_alt1() {
		if (Settings.NO_ALT_METHODS) {
			return this.g1();
		}

		return this.data[++this.pos - 1] - 128 & 0xFF;
	}

	@ObfuscatedName("ev.aq(I)I")
	public int g1_alt2() {
		if (Settings.NO_ALT_METHODS) {
			return this.g1();
		}

		return -this.data[++this.pos - 1] & 0xFF;
	}

	@ObfuscatedName("ev.at(I)I")
	public int g1_alt3() {
		if (Settings.NO_ALT_METHODS) {
			return this.g1();
		}

		return 128 - this.data[++this.pos - 1] & 0xFF;
	}

	@ObfuscatedName("ev.ae(I)B")
	public byte g1b_alt1() {
		if (Settings.NO_ALT_METHODS) {
			return this.g1b();
		}

		return (byte) (this.data[++this.pos - 1] - 128);
	}

	@ObfuscatedName("ev.au(I)B")
	public byte g1b_alt3() {
		if (Settings.NO_ALT_METHODS) {
			return this.g1b();
		}

		return (byte) (128 - this.data[++this.pos - 1]);
	}

	@ObfuscatedName("ev.ax(IB)V")
	public void p2_alt1(int arg0) {
		if (Settings.NO_ALT_METHODS) {
			this.p2(arg0);
			return;
		}

		this.data[++this.pos - 1] = (byte) arg0;
		this.data[++this.pos - 1] = (byte) (arg0 >> 8);
	}

	@ObfuscatedName("ev.ai(IB)V")
	public void p2_alt2(int arg0) {
		if (Settings.NO_ALT_METHODS) {
			this.p2(arg0);
			return;
		}

		this.data[++this.pos - 1] = (byte) (arg0 >> 8);
		this.data[++this.pos - 1] = (byte) (arg0 + 128);
	}

	@ObfuscatedName("ev.aj(II)V")
	public void p2_alt3(int arg0) {
		if (Settings.NO_ALT_METHODS) {
			this.p2(arg0);
			return;
		}

		this.data[++this.pos - 1] = (byte) (arg0 + 128);
		this.data[++this.pos - 1] = (byte) (arg0 >> 8);
	}

	@ObfuscatedName("ev.aw(I)I")
	public int g2_alt1() {
		if (Settings.NO_ALT_METHODS) {
			return this.g2();
		}

		this.pos += 2;
		return ((this.data[this.pos - 1] & 0xFF) << 8) + (this.data[this.pos - 2] & 0xFF);
	}

	@ObfuscatedName("ev.af(I)I")
	public int g2_alt2() {
		if (Settings.NO_ALT_METHODS) {
			return this.g2();
		}

		this.pos += 2;
		return ((this.data[this.pos - 2] & 0xFF) << 8) + (this.data[this.pos - 1] - 128 & 0xFF);
	}

	@ObfuscatedName("ev.bh(I)I")
	public int g2_alt3() {
		if (Settings.NO_ALT_METHODS) {
			return this.g2();
		}

		this.pos += 2;
		return ((this.data[this.pos - 1] & 0xFF) << 8) + (this.data[this.pos - 2] - 128 & 0xFF);
	}

	@ObfuscatedName("ev.bi(I)I")
	public int g2b_alt1() {
		if (Settings.NO_ALT_METHODS) {
			return this.g2b();
		}

		this.pos += 2;
		int var1 = ((this.data[this.pos - 1] & 0xFF) << 8) + (this.data[this.pos - 2] & 0xFF);
		if (var1 > 32767) {
			var1 -= 65536;
		}
		return var1;
	}

	@ObfuscatedName("ev.bs(B)I")
	public int g2b_alt2() {
		if (Settings.NO_ALT_METHODS) {
			return this.g2b();
		}

		this.pos += 2;
		int var1 = ((this.data[this.pos - 2] & 0xFF) << 8) + (this.data[this.pos - 1] - 128 & 0xFF);
		if (var1 > 32767) {
			var1 -= 65536;
		}
		return var1;
	}

	@ObfuscatedName("ev.bk(S)I")
	public int g2b_alt3() {
		if (Settings.NO_ALT_METHODS) {
			return this.g2b();
		}

		this.pos += 2;
		int var1 = ((this.data[this.pos - 1] & 0xFF) << 8) + (this.data[this.pos - 2] - 128 & 0xFF);
		if (var1 > 32767) {
			var1 -= 65536;
		}
		return var1;
	}

	@ObfuscatedName("ev.bv(I)I")
	public int g3_alt2() {
		if (Settings.NO_ALT_METHODS) {
			return this.g3();
		}

		this.pos += 3;
		return (this.data[this.pos - 3] & 0xFF) + ((this.data[this.pos - 1] & 0xFF) << 16) + ((this.data[this.pos - 2] & 0xFF) << 8);
	}

	@ObfuscatedName("ev.bw(IS)V")
	public void p4_alt1(int arg0) {
		if (Settings.NO_ALT_METHODS) {
			this.p4(arg0);
			return;
		}

		this.data[++this.pos - 1] = (byte) arg0;
		this.data[++this.pos - 1] = (byte) (arg0 >> 8);
		this.data[++this.pos - 1] = (byte) (arg0 >> 16);
		this.data[++this.pos - 1] = (byte) (arg0 >> 24);
	}

	@ObfuscatedName("ev.by(II)V")
	public void p4_alt2(int arg0) {
		if (Settings.NO_ALT_METHODS) {
			this.p4(arg0);
			return;
		}

		this.data[++this.pos - 1] = (byte) (arg0 >> 8);
		this.data[++this.pos - 1] = (byte) arg0;
		this.data[++this.pos - 1] = (byte) (arg0 >> 24);
		this.data[++this.pos - 1] = (byte) (arg0 >> 16);
	}

	@ObfuscatedName("ev.bx(IS)V")
	public void p4_alt3(int arg0) {
		if (Settings.NO_ALT_METHODS) {
			this.p4(arg0);
			return;
		}

		this.data[++this.pos - 1] = (byte) (arg0 >> 16);
		this.data[++this.pos - 1] = (byte) (arg0 >> 24);
		this.data[++this.pos - 1] = (byte) arg0;
		this.data[++this.pos - 1] = (byte) (arg0 >> 8);
	}

	@ObfuscatedName("ev.bf(I)I")
	public int g4_alt1() {
		if (Settings.NO_ALT_METHODS) {
			return this.g4();
		}

		this.pos += 4;
		return (this.data[this.pos - 4] & 0xFF) + ((this.data[this.pos - 3] & 0xFF) << 8) + ((this.data[this.pos - 2] & 0xFF) << 16) + ((this.data[this.pos - 1] & 0xFF) << 24);
	}

	@ObfuscatedName("ev.bu(I)I")
	public int g4_alt2() {
		if (Settings.NO_ALT_METHODS) {
			return this.g4();
		}

		this.pos += 4;
		return (this.data[this.pos - 3] & 0xFF) + ((this.data[this.pos - 4] & 0xFF) << 8) + ((this.data[this.pos - 2] & 0xFF) << 24) + ((this.data[this.pos - 1] & 0xFF) << 16);
	}

	@ObfuscatedName("ev.bo(B)I")
	public int g4_alt3() {
		if (Settings.NO_ALT_METHODS) {
			return this.g4();
		}

		this.pos += 4;
		return (this.data[this.pos - 2] & 0xFF) + ((this.data[this.pos - 1] & 0xFF) << 8) + ((this.data[this.pos - 3] & 0xFF) << 24) + ((this.data[this.pos - 4] & 0xFF) << 16);
	}

	@ObfuscatedName("ev.bq([BIII)V")
	public void gdata_alt1(byte[] arg0, int arg1, int arg2) {
		if (Settings.NO_ALT_METHODS) {
			this.gdata(arg0, arg1, arg2);
			return;
		}

		for (int var4 = arg1 + arg2 - 1; var4 >= arg1; var4--) {
			arg0[var4] = this.data[++this.pos - 1];
		}
	}
}
