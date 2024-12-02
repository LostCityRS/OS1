package jagex2.io;

import deob.ObfuscatedName;
import jagex2.datastruct.ByteArrayPool;
import jagex2.datastruct.Linkable;
import jagex2.jstring.Cp1252;
import jagex2.jstring.Utf8;

import java.math.BigInteger;

@ObfuscatedName("ev")
public class Packet extends Linkable {

	@ObfuscatedName("ev.m")
	public byte[] field1732;

	@ObfuscatedName("ev.c")
	public int field1729;

	@ObfuscatedName("ev.n")
	public static int[] field1730 = new int[256];

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
			field1730[var0] = var1;
		}
	}

	public Packet(int arg0) {
		this.field1732 = ByteArrayPool.method773(arg0);
		this.field1729 = 0;
	}

	public Packet(byte[] arg0) {
		this.field1732 = arg0;
		this.field1729 = 0;
	}

	@ObfuscatedName("ev.c(II)V")
	public void method1587(int arg0) {
		this.field1732[++this.field1729 - 1] = (byte) arg0;
	}

	@ObfuscatedName("ev.n(II)V")
	public void method1667(int arg0) {
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 8);
		this.field1732[++this.field1729 - 1] = (byte) arg0;
	}

	@ObfuscatedName("ev.j(IB)V")
	public void method1624(int arg0) {
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 16);
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 8);
		this.field1732[++this.field1729 - 1] = (byte) arg0;
	}

	@ObfuscatedName("ev.z(IB)V")
	public void method1761(int arg0) {
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 24);
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 16);
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 8);
		this.field1732[++this.field1729 - 1] = (byte) arg0;
	}

	@ObfuscatedName("ev.g(J)V")
	public void method1591(long arg0) {
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 56);
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 48);
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 40);
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 32);
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 24);
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 16);
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 8);
		this.field1732[++this.field1729 - 1] = (byte) arg0;
	}

	@ObfuscatedName("ea.q(Ljava/lang/String;I)I")
	public static int method2323(String arg0) {
		return arg0.length() + 1;
	}

	@ObfuscatedName("ev.i(Ljava/lang/String;I)V")
	public void method1592(String arg0) {
		int var2 = arg0.indexOf(0);
		if (var2 >= 0) {
			throw new IllegalArgumentException("");
		}
		this.field1729 += Cp1252.method744(arg0, 0, arg0.length(), this.field1732, this.field1729);
		this.field1732[++this.field1729 - 1] = 0;
	}

	@ObfuscatedName("ev.s(Ljava/lang/CharSequence;I)V")
	public void method1593(CharSequence arg0) {
		int var2 = Utf8.method1581(arg0);
		this.field1732[++this.field1729 - 1] = 0;
		this.method1599(var2);
		this.field1729 += Utf8.method1142(this.field1732, this.field1729, arg0);
	}

	@ObfuscatedName("ev.u([BIIB)V")
	public void method1729(byte[] arg0, int arg1, int arg2) {
		for (int var4 = arg1; var4 < arg1 + arg2; var4++) {
			this.field1732[++this.field1729 - 1] = arg0[var4];
		}
	}

	@ObfuscatedName("ev.v(II)V")
	public void method1698(int arg0) {
		this.field1732[this.field1729 - arg0 - 4] = (byte) (arg0 >> 24);
		this.field1732[this.field1729 - arg0 - 3] = (byte) (arg0 >> 16);
		this.field1732[this.field1729 - arg0 - 2] = (byte) (arg0 >> 8);
		this.field1732[this.field1729 - arg0 - 1] = (byte) arg0;
	}

	@ObfuscatedName("ev.w(II)V")
	public void method1699(int arg0) {
		this.field1732[this.field1729 - arg0 - 2] = (byte) (arg0 >> 8);
		this.field1732[this.field1729 - arg0 - 1] = (byte) arg0;
	}

	@ObfuscatedName("ev.e(IB)V")
	public void method1715(int arg0) {
		this.field1732[this.field1729 - arg0 - 1] = (byte) arg0;
	}

	@ObfuscatedName("ev.b(II)V")
	public void method1598(int arg0) {
		if (arg0 >= 0 && arg0 < 128) {
			this.method1587(arg0);
		} else if (arg0 >= 0 && arg0 < 32768) {
			this.method1667(arg0 + 32768);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("ev.y(II)V")
	public void method1599(int arg0) {
		if ((arg0 & 0xFFFFFF80) != 0) {
			if ((arg0 & 0xFFFFC000) != 0) {
				if ((arg0 & 0xFFE00000) != 0) {
					if ((arg0 & 0xF0000000) != 0) {
						this.method1587(arg0 >>> 28 | 0x80);
					}
					this.method1587(arg0 >>> 21 | 0x80);
				}
				this.method1587(arg0 >>> 14 | 0x80);
			}
			this.method1587(arg0 >>> 7 | 0x80);
		}
		this.method1587(arg0 & 0x7F);
	}

	@ObfuscatedName("ev.t(I)I")
	public int method1600() {
		return this.field1732[++this.field1729 - 1] & 0xFF;
	}

	@ObfuscatedName("ev.f(I)B")
	public byte method1595() {
		return this.field1732[++this.field1729 - 1];
	}

	@ObfuscatedName("ev.k(I)I")
	public int method1602() {
		this.field1729 += 2;
		return ((this.field1732[this.field1729 - 2] & 0xFF) << 8) + (this.field1732[this.field1729 - 1] & 0xFF);
	}

	@ObfuscatedName("ev.o(I)I")
	public int method1603() {
		this.field1729 += 2;
		int var1 = ((this.field1732[this.field1729 - 2] & 0xFF) << 8) + (this.field1732[this.field1729 - 1] & 0xFF);
		if (var1 > 32767) {
			var1 -= 65536;
		}
		return var1;
	}

	@ObfuscatedName("ev.a(B)I")
	public int method1728() {
		this.field1729 += 3;
		return (this.field1732[this.field1729 - 1] & 0xFF) + ((this.field1732[this.field1729 - 2] & 0xFF) << 8) + ((this.field1732[this.field1729 - 3] & 0xFF) << 16);
	}

	@ObfuscatedName("ev.h(I)I")
	public int method1605() {
		this.field1729 += 4;
		return (this.field1732[this.field1729 - 1] & 0xFF) + ((this.field1732[this.field1729 - 2] & 0xFF) << 8) + ((this.field1732[this.field1729 - 3] & 0xFF) << 16) + ((this.field1732[this.field1729 - 4] & 0xFF) << 24);
	}

	@ObfuscatedName("ev.x(I)J")
	public long method1606() {
		long var1 = (long) this.method1605() & 0xFFFFFFFFL;
		long var3 = (long) this.method1605() & 0xFFFFFFFFL;
		return (var1 << 32) + var3;
	}

	@ObfuscatedName("ev.p(I)Ljava/lang/String;")
	public String method1671() {
		if (this.field1732[this.field1729] == 0) {
			this.field1729++;
			return null;
		} else {
			return this.method1693();
		}
	}

	@ObfuscatedName("ev.ad(I)Ljava/lang/String;")
	public String method1693() {
		int var1 = this.field1729;
		while (this.field1732[++this.field1729 - 1] != 0) {
		}
		int var2 = this.field1729 - var1 - 1;
		return var2 == 0 ? "" : Cp1252.method2397(this.field1732, var1, var2);
	}

	@ObfuscatedName("ev.ac(B)Ljava/lang/String;")
	public String method1737() {
		byte var1 = this.field1732[++this.field1729 - 1];
		if (var1 != 0) {
			throw new IllegalStateException("");
		}
		int var2 = this.field1729;
		while (this.field1732[++this.field1729 - 1] != 0) {
		}
		int var3 = this.field1729 - var2 - 1;
		return var3 == 0 ? "" : Cp1252.method2397(this.field1732, var2, var3);
	}

	@ObfuscatedName("ev.aa(I)Ljava/lang/String;")
	public String method1617() {
		byte var1 = this.field1732[++this.field1729 - 1];
		if (var1 != 0) {
			throw new IllegalStateException("");
		}
		int var2 = this.method1615();
		if (this.field1729 + var2 > this.field1732.length) {
			throw new IllegalStateException("");
		}
		byte[] var3 = this.field1732;
		int var4 = this.field1729;
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
		this.field1729 += var2;
		return var12;
	}

	@ObfuscatedName("ev.as([BIII)V")
	public void method1611(byte[] arg0, int arg1, int arg2) {
		for (int var4 = arg1; var4 < arg1 + arg2; var4++) {
			arg0[var4] = this.field1732[++this.field1729 - 1];
		}
	}

	@ObfuscatedName("ev.am(I)I")
	public int method1612() {
		int var1 = this.field1732[this.field1729] & 0xFF;
		return var1 < 128 ? this.method1600() - 64 : this.method1602() - 49152;
	}

	@ObfuscatedName("ev.ap(I)I")
	public int method1640() {
		int var1 = this.field1732[this.field1729] & 0xFF;
		return var1 < 128 ? this.method1600() : this.method1602() - 32768;
	}

	@ObfuscatedName("ev.av(S)I")
	public int method1614() {
		return this.field1732[this.field1729] < 0 ? this.method1605() & Integer.MAX_VALUE : this.method1602();
	}

	@ObfuscatedName("ev.ak(B)I")
	public int method1615() {
		byte var1 = this.field1732[++this.field1729 - 1];
		int var2 = 0;
		while (var1 < 0) {
			var2 = (var2 | var1 & 0x7F) << 7;
			var1 = this.field1732[++this.field1729 - 1];
		}
		return var2 | var1;
	}

	@ObfuscatedName("ev.az([IIII)V")
	public void method1754(int[] arg0, int arg1, int arg2) {
		int var4 = this.field1729;
		this.field1729 = arg1;
		int var5 = (arg2 - arg1) / 8;
		for (int var6 = 0; var6 < var5; var6++) {
			int var7 = this.method1605();
			int var8 = this.method1605();
			int var9 = 0;
			int var10 = -1640531527;
			int var11 = 32;
			while (var11-- > 0) {
				var7 += (var8 << 4 ^ var8 >>> 5) + var8 ^ arg0[var9 & 0x3] + var9;
				var9 += var10;
				var8 += (var7 << 4 ^ var7 >>> 5) + var7 ^ arg0[var9 >>> 11 & 0x3] + var9;
			}
			this.field1729 -= 8;
			this.method1761(var7);
			this.method1761(var8);
		}
		this.field1729 = var4;
	}

	@ObfuscatedName("ev.an([IIII)V")
	public void method1673(int[] arg0, int arg1, int arg2) {
		int var4 = this.field1729;
		this.field1729 = arg1;
		int var5 = (arg2 - arg1) / 8;
		for (int var6 = 0; var6 < var5; var6++) {
			int var7 = this.method1605();
			int var8 = this.method1605();
			int var9 = -957401312;
			int var10 = -1640531527;
			int var11 = 32;
			while (var11-- > 0) {
				var8 -= (var7 << 4 ^ var7 >>> 5) + var7 ^ arg0[var9 >>> 11 & 0x3] + var9;
				var9 -= var10;
				var7 -= (var8 << 4 ^ var8 >>> 5) + var8 ^ arg0[var9 & 0x3] + var9;
			}
			this.field1729 -= 8;
			this.method1761(var7);
			this.method1761(var8);
		}
		this.field1729 = var4;
	}

	@ObfuscatedName("ev.ah(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V")
	public void method1618(BigInteger arg0, BigInteger arg1) {
		int var3 = this.field1729;
		this.field1729 = 0;
		byte[] var4 = new byte[var3];
		this.method1611(var4, 0, var3);
		BigInteger var5 = new BigInteger(var4);
		BigInteger var6 = var5.modPow(arg0, arg1);
		byte[] var7 = var6.toByteArray();
		this.field1729 = 0;
		this.method1667(var7.length);
		this.method1729(var7, 0, var7.length);
	}

	@ObfuscatedName("ev.ay(II)I")
	public int method1619(int arg0) {
		byte[] var2 = this.field1732;
		int var3 = this.field1729;
		int var4 = -1;
		for (int var5 = arg0; var5 < var3; var5++) {
			var4 = var4 >>> 8 ^ field1730[(var4 ^ var2[var5]) & 0xFF];
		}
		int var6 = ~var4;
		this.method1761(var6);
		return var6;
	}

	@ObfuscatedName("ev.al(I)Z")
	public boolean method1656() {
		this.field1729 -= 4;
		byte[] var1 = this.field1732;
		int var2 = this.field1729;
		int var3 = -1;
		for (int var4 = 0; var4 < var2; var4++) {
			var3 = var3 >>> 8 ^ field1730[(var3 ^ var1[var4]) & 0xFF];
		}
		int var5 = ~var3;
		int var8 = this.method1605();
		return var5 == var8;
	}

	@ObfuscatedName("ev.ab(II)V")
	public void method1621(int arg0) {
		this.field1732[++this.field1729 - 1] = (byte) (arg0 + 128);
	}

	@ObfuscatedName("ev.ao(IS)V")
	public void method1620(int arg0) {
		this.field1732[++this.field1729 - 1] = (byte) -arg0;
	}

	@ObfuscatedName("ev.ag(II)V")
	public void method1623(int arg0) {
		this.field1732[++this.field1729 - 1] = (byte) (128 - arg0);
	}

	@ObfuscatedName("ev.ar(I)I")
	public int method1610() {
		return this.field1732[++this.field1729 - 1] - 128 & 0xFF;
	}

	@ObfuscatedName("ev.aq(I)I")
	public int method1685() {
		return -this.field1732[++this.field1729 - 1] & 0xFF;
	}

	@ObfuscatedName("ev.at(I)I")
	public int method1626() {
		return 128 - this.field1732[++this.field1729 - 1] & 0xFF;
	}

	@ObfuscatedName("ev.ae(I)B")
	public byte method1627() {
		return (byte) (this.field1732[++this.field1729 - 1] - 128);
	}

	@ObfuscatedName("ev.au(I)B")
	public byte method1628() {
		return (byte) (128 - this.field1732[++this.field1729 - 1]);
	}

	@ObfuscatedName("ev.ax(IB)V")
	public void method1676(int arg0) {
		this.field1732[++this.field1729 - 1] = (byte) arg0;
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 8);
	}

	@ObfuscatedName("ev.ai(IB)V")
	public void method1630(int arg0) {
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 8);
		this.field1732[++this.field1729 - 1] = (byte) (arg0 + 128);
	}

	@ObfuscatedName("ev.aj(II)V")
	public void method1631(int arg0) {
		this.field1732[++this.field1729 - 1] = (byte) (arg0 + 128);
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 8);
	}

	@ObfuscatedName("ev.aw(I)I")
	public int method1632() {
		this.field1729 += 2;
		return ((this.field1732[this.field1729 - 1] & 0xFF) << 8) + (this.field1732[this.field1729 - 2] & 0xFF);
	}

	@ObfuscatedName("ev.af(I)I")
	public int method1633() {
		this.field1729 += 2;
		return ((this.field1732[this.field1729 - 2] & 0xFF) << 8) + (this.field1732[this.field1729 - 1] - 128 & 0xFF);
	}

	@ObfuscatedName("ev.bh(I)I")
	public int method1634() {
		this.field1729 += 2;
		return ((this.field1732[this.field1729 - 1] & 0xFF) << 8) + (this.field1732[this.field1729 - 2] - 128 & 0xFF);
	}

	@ObfuscatedName("ev.bi(I)I")
	public int method1704() {
		this.field1729 += 2;
		int var1 = ((this.field1732[this.field1729 - 1] & 0xFF) << 8) + (this.field1732[this.field1729 - 2] & 0xFF);
		if (var1 > 32767) {
			var1 -= 65536;
		}
		return var1;
	}

	@ObfuscatedName("ev.bs(B)I")
	public int method1636() {
		this.field1729 += 2;
		int var1 = ((this.field1732[this.field1729 - 2] & 0xFF) << 8) + (this.field1732[this.field1729 - 1] - 128 & 0xFF);
		if (var1 > 32767) {
			var1 -= 65536;
		}
		return var1;
	}

	@ObfuscatedName("ev.bk(S)I")
	public int method1637() {
		this.field1729 += 2;
		int var1 = ((this.field1732[this.field1729 - 1] & 0xFF) << 8) + (this.field1732[this.field1729 - 2] - 128 & 0xFF);
		if (var1 > 32767) {
			var1 -= 65536;
		}
		return var1;
	}

	@ObfuscatedName("ev.bv(I)I")
	public int method1597() {
		this.field1729 += 3;
		return (this.field1732[this.field1729 - 3] & 0xFF) + ((this.field1732[this.field1729 - 1] & 0xFF) << 16) + ((this.field1732[this.field1729 - 2] & 0xFF) << 8);
	}

	@ObfuscatedName("ev.bw(IS)V")
	public void method1639(int arg0) {
		this.field1732[++this.field1729 - 1] = (byte) arg0;
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 8);
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 16);
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 24);
	}

	@ObfuscatedName("ev.by(II)V")
	public void method1709(int arg0) {
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 8);
		this.field1732[++this.field1729 - 1] = (byte) arg0;
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 24);
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 16);
	}

	@ObfuscatedName("ev.bx(IS)V")
	public void method1641(int arg0) {
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 16);
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 24);
		this.field1732[++this.field1729 - 1] = (byte) arg0;
		this.field1732[++this.field1729 - 1] = (byte) (arg0 >> 8);
	}

	@ObfuscatedName("ev.bf(I)I")
	public int method1596() {
		this.field1729 += 4;
		return (this.field1732[this.field1729 - 4] & 0xFF) + ((this.field1732[this.field1729 - 3] & 0xFF) << 8) + ((this.field1732[this.field1729 - 2] & 0xFF) << 16) + ((this.field1732[this.field1729 - 1] & 0xFF) << 24);
	}

	@ObfuscatedName("ev.bu(I)I")
	public int method1643() {
		this.field1729 += 4;
		return (this.field1732[this.field1729 - 3] & 0xFF) + ((this.field1732[this.field1729 - 4] & 0xFF) << 8) + ((this.field1732[this.field1729 - 2] & 0xFF) << 24) + ((this.field1732[this.field1729 - 1] & 0xFF) << 16);
	}

	@ObfuscatedName("ev.bo(B)I")
	public int method1604() {
		this.field1729 += 4;
		return (this.field1732[this.field1729 - 2] & 0xFF) + ((this.field1732[this.field1729 - 1] & 0xFF) << 8) + ((this.field1732[this.field1729 - 3] & 0xFF) << 24) + ((this.field1732[this.field1729 - 4] & 0xFF) << 16);
	}

	@ObfuscatedName("ev.bq([BIII)V")
	public void method1742(byte[] arg0, int arg1, int arg2) {
		for (int var4 = arg1 + arg2 - 1; var4 >= arg1; var4--) {
			arg0[var4] = this.field1732[++this.field1729 - 1];
		}
	}
}
