package jagex2.sound;

import deob.ObfuscatedName;
import jagex2.datastruct.ByteArrayNode;
import jagex2.datastruct.HashTable;
import jagex2.js5.Js5Index;

@ObfuscatedName("ed")
public class MidiPcmStream extends PcmStream {

	@ObfuscatedName("ed.z")
	public HashTable field2230 = new HashTable(128);

	@ObfuscatedName("ed.g")
	public int field2234 = 256;

	@ObfuscatedName("ed.q")
	public int field2235 = 1000000;

	@ObfuscatedName("ed.i")
	public int[] field2238 = new int[16];

	@ObfuscatedName("ed.s")
	public int[] field2227 = new int[16];

	@ObfuscatedName("ed.u")
	public int[] field2239 = new int[16];

	@ObfuscatedName("ed.v")
	public int[] field2226 = new int[16];

	@ObfuscatedName("ed.w")
	public int[] field2231 = new int[16];

	@ObfuscatedName("ed.e")
	public int[] field2229 = new int[16];

	@ObfuscatedName("ed.b")
	public int[] field2233 = new int[16];

	@ObfuscatedName("ed.y")
	public int[] field2232 = new int[16];

	@ObfuscatedName("ed.t")
	public int[] field2228 = new int[16];

	@ObfuscatedName("ed.a")
	public int[] field2244 = new int[16];

	@ObfuscatedName("ed.h")
	public int[] field2240 = new int[16];

	@ObfuscatedName("ed.x")
	public int[] field2241 = new int[16];

	@ObfuscatedName("ed.p")
	public int[] field2242 = new int[16];

	@ObfuscatedName("ed.ad")
	public int[] field2243 = new int[16];

	@ObfuscatedName("ed.ac")
	public int[] field2250 = new int[16];

	@ObfuscatedName("ed.aa")
	public MidiNote[][] field2245 = new MidiNote[16][128];

	@ObfuscatedName("ed.as")
	public MidiNote[][] field2246 = new MidiNote[16][128];

	@ObfuscatedName("ed.am")
	public MidiDecoder field2247 = new MidiDecoder();

	@ObfuscatedName("ed.ap")
	public boolean field2248;

	@ObfuscatedName("ed.av")
	public int field2249;

	@ObfuscatedName("ed.ak")
	public int field2224;

	@ObfuscatedName("ed.az")
	public long field2251;

	@ObfuscatedName("ed.an")
	public long field2252;

	@ObfuscatedName("ed.ah")
	public MidiNoteStream field2253 = new MidiNoteStream(this);

	public MidiPcmStream() {
		this.method2212();
	}

	@ObfuscatedName("ed.p(II)V")
	public synchronized void method2206(int arg0) {
		this.field2234 = arg0;
	}

	@ObfuscatedName("ed.ad(B)I")
	public int method2254() {
		return this.field2234;
	}

	@ObfuscatedName("ed.ac(Lei;Lch;La;IB)Z")
	public synchronized boolean method2196(Song arg0, Js5Index arg1, SoundBank arg2, int arg3) {
		arg0.method1773();
		boolean var5 = true;
		int[] var6 = null;
		if (arg3 > 0) {
			var6 = new int[] { arg3 };
		}
		for (ByteArrayNode var7 = (ByteArrayNode) arg0.field1734.method1284(); var7 != null; var7 = (ByteArrayNode) arg0.field1734.method1280()) {
			int var8 = (int) var7.nodeId;
			MidiInstrument var9 = (MidiInstrument) this.field2230.get((long) var8);
			if (var9 == null) {
				var9 = MidiInstrument.method49(arg1, var8);
				if (var9 == null) {
					var5 = false;
					continue;
				}
				this.field2230.put(var9, (long) var8);
			}
			if (!var9.method1784(arg2, var7.data, var6)) {
				var5 = false;
			}
		}
		if (var5) {
			arg0.method1774();
		}
		return var5;
	}

	@ObfuscatedName("ed.aa(B)V")
	public synchronized void method2220() {
		for (MidiInstrument var1 = (MidiInstrument) this.field2230.method1284(); var1 != null; var1 = (MidiInstrument) this.field2230.method1280()) {
			var1.method1781();
		}
	}

	@ObfuscatedName("ed.as(I)V")
	public synchronized void method2289() {
		for (MidiInstrument var1 = (MidiInstrument) this.field2230.method1284(); var1 != null; var1 = (MidiInstrument) this.field2230.method1280()) {
			var1.unlink();
		}
	}

	@ObfuscatedName("ed.am(Lei;ZB)V")
	public synchronized void method2199(Song arg0, boolean arg1) {
		this.method2290();
		this.field2247.method952(arg0.field1735);
		this.field2248 = arg1;
		this.field2251 = 0L;
		int var3 = this.field2247.method956();
		for (int var4 = 0; var4 < var3; var4++) {
			this.field2247.method957(var4);
			this.field2247.method960(var4);
			this.field2247.method958(var4);
		}
		this.field2249 = this.field2247.method987();
		this.field2224 = this.field2247.field1135[this.field2249];
		this.field2252 = this.field2247.method964(this.field2224);
	}

	@ObfuscatedName("ed.ap(B)V")
	public synchronized void method2290() {
		this.field2247.method965();
		this.method2212();
	}

	@ObfuscatedName("ed.av(I)Z")
	public synchronized boolean method2200() {
		return this.field2247.method955();
	}

	@ObfuscatedName("ed.ak(III)V")
	public synchronized void method2201(int arg0, int arg1) {
		this.method2217(arg0, arg1);
	}

	@ObfuscatedName("ed.az(III)V")
	public void method2217(int arg0, int arg1) {
		this.field2226[arg0] = arg1;
		this.field2229[arg0] = arg1 & 0xFFFFFF80;
		this.method2226(arg0, arg1);
	}

	@ObfuscatedName("ed.an(III)V")
	public void method2226(int arg0, int arg1) {
		if (this.field2231[arg0] != arg1) {
			this.field2231[arg0] = arg1;
			for (int var3 = 0; var3 < 128; var3++) {
				this.field2246[arg0][var3] = null;
			}
		}
	}

	@ObfuscatedName("ed.ah(IIII)V")
	public void method2224(int arg0, int arg1, int arg2) {
		this.method2258(arg0, arg1, 64);
		if ((this.field2244[arg0] & 0x2) != 0) {
			for (MidiNote var4 = (MidiNote) this.field2253.field2255.tail(); var4 != null; var4 = (MidiNote) this.field2253.field2255.prev()) {
				if (var4.field1760 == arg0 && var4.field1745 < 0) {
					this.field2245[arg0][var4.field1750] = null;
					this.field2245[arg0][arg1] = var4;
					int var5 = (var4.field1755 * var4.field1754 >> 12) + var4.field1753;
					var4.field1753 += arg1 - var4.field1750 << 8;
					var4.field1754 = var5 - var4.field1753;
					var4.field1755 = 4096;
					var4.field1750 = arg1;
					return;
				}
			}
		}
		MidiInstrument var6 = (MidiInstrument) this.field2230.get((long) this.field2231[arg0]);
		if (var6 == null) {
			return;
		}
		PcmSound var7 = var6.field1738[arg1];
		if (var7 == null) {
			return;
		}
		MidiNote var8 = new MidiNote();
		var8.field1760 = arg0;
		var8.field1746 = var6;
		var8.field1759 = var7;
		var8.field1757 = var6.field1741[arg1];
		var8.field1749 = var6.field1742[arg1];
		var8.field1750 = arg1;
		var8.field1751 = var6.field1736 * arg2 * arg2 * var6.field1737[arg1] + 1024 >> 11;
		var8.field1747 = var6.field1740[arg1] & 0xFF;
		var8.field1753 = (arg1 << 8) - (var6.field1743[arg1] & 0x7FFF);
		var8.field1756 = 0;
		var8.field1752 = 0;
		var8.field1758 = 0;
		var8.field1745 = -1;
		var8.field1748 = 0;
		if (this.field2242[arg0] == 0) {
			var8.field1763 = SoundPcmStream.method2059(var7, this.method2203(var8), this.method2247(var8), this.method2251(var8));
		} else {
			var8.field1763 = SoundPcmStream.method2059(var7, this.method2203(var8), 0, this.method2251(var8));
			this.method2205(var8, var6.field1743[arg1] < 0);
		}
		if (var6.field1743[arg1] < 0) {
			var8.field1763.method2061(-1);
		}
		if (var8.field1749 >= 0) {
			MidiNote var9 = this.field2246[arg0][var8.field1749];
			if (var9 != null && var9.field1745 < 0) {
				this.field2245[arg0][var9.field1750] = null;
				var9.field1745 = 0;
			}
			this.field2246[arg0][var8.field1749] = var8;
		}
		this.field2253.field2255.push(var8);
		this.field2245[arg0][arg1] = var8;
	}

	@ObfuscatedName("ed.ay(Lej;ZI)V")
	public void method2205(MidiNote arg0, boolean arg1) {
		int var3 = arg0.field1759.field2204.length;
		int var5;
		if (arg1 && arg0.field1759.field2201) {
			int var4 = var3 + var3 - arg0.field1759.field2202;
			var5 = (int) ((long) this.field2242[arg0.field1760] * (long) var4 >> 6);
			int var6 = var3 << 8;
			if (var5 >= var6) {
				var5 = var6 + var6 - 1 - var5;
				arg0.field1763.method2084(true);
			}
		} else {
			var5 = (int) ((long) this.field2242[arg0.field1760] * (long) var3 >> 6);
		}
		arg0.field1763.method2067(var5);
	}

	@ObfuscatedName("ed.al(IIII)V")
	public void method2258(int arg0, int arg1, int arg2) {
		MidiNote var4 = this.field2245[arg0][arg1];
		if (var4 == null) {
			return;
		}
		this.field2245[arg0][arg1] = null;
		if ((this.field2244[arg0] & 0x2) == 0) {
			var4.field1745 = 0;
			return;
		}
		for (MidiNote var5 = (MidiNote) this.field2253.field2255.head(); var5 != null; var5 = (MidiNote) this.field2253.field2255.next()) {
			if (var4.field1760 == var5.field1760 && var5.field1745 < 0 && var4 != var5) {
				var4.field1745 = 0;
				break;
			}
		}
	}

	@ObfuscatedName("ed.ab(IIII)V")
	public void method2207(int arg0, int arg1, int arg2) {
	}

	@ObfuscatedName("ed.ao(III)V")
	public void method2237(int arg0, int arg1) {
	}

	@ObfuscatedName("ed.ag(IIS)V")
	public void method2208(int arg0, int arg1) {
		this.field2233[arg0] = arg1;
	}

	@ObfuscatedName("ed.ar(IB)V")
	public void method2283(int arg0) {
		for (MidiNote var2 = (MidiNote) this.field2253.field2255.head(); var2 != null; var2 = (MidiNote) this.field2253.field2255.next()) {
			if (arg0 < 0 || var2.field1760 == arg0) {
				if (var2.field1763 != null) {
					var2.field1763.method2081(AudioChannel.field241 / 100);
					if (var2.field1763.method2076()) {
						this.field2253.field2254.method2174(var2.field1763);
					}
					var2.method1787();
				}
				if (var2.field1745 < 0) {
					this.field2245[var2.field1760][var2.field1750] = null;
				}
				var2.unlink();
			}
		}
	}

	@ObfuscatedName("ed.aq(II)V")
	public void method2210(int arg0) {
		if (arg0 < 0) {
			for (int var2 = 0; var2 < 16; var2++) {
				this.method2210(var2);
			}
			return;
		}
		this.field2238[arg0] = 12800;
		this.field2227[arg0] = 8192;
		this.field2239[arg0] = 16383;
		this.field2233[arg0] = 8192;
		this.field2232[arg0] = 0;
		this.field2228[arg0] = 8192;
		this.method2202(arg0);
		this.method2214(arg0);
		this.field2244[arg0] = 0;
		this.field2240[arg0] = 32767;
		this.field2241[arg0] = 256;
		this.field2242[arg0] = 0;
		this.method2216(arg0, 8192);
	}

	@ObfuscatedName("ed.at(II)V")
	public void method2211(int arg0) {
		for (MidiNote var2 = (MidiNote) this.field2253.field2255.head(); var2 != null; var2 = (MidiNote) this.field2253.field2255.next()) {
			if ((arg0 < 0 || var2.field1760 == arg0) && var2.field1745 < 0) {
				this.field2245[var2.field1760][var2.field1750] = null;
				var2.field1745 = 0;
			}
		}
	}

	@ObfuscatedName("ed.ae(B)V")
	public void method2212() {
		this.method2283(-1);
		this.method2210(-1);
		for (int var1 = 0; var1 < 16; var1++) {
			this.field2231[var1] = this.field2226[var1];
		}
		for (int var2 = 0; var2 < 16; var2++) {
			this.field2229[var2] = this.field2226[var2] & 0xFFFFFF80;
		}
	}

	@ObfuscatedName("ed.au(IB)V")
	public void method2202(int arg0) {
		if ((this.field2244[arg0] & 0x2) == 0) {
			return;
		}
		for (MidiNote var2 = (MidiNote) this.field2253.field2255.head(); var2 != null; var2 = (MidiNote) this.field2253.field2255.next()) {
			if (var2.field1760 == arg0 && this.field2245[arg0][var2.field1750] == null && var2.field1745 < 0) {
				var2.field1745 = 0;
			}
		}
	}

	@ObfuscatedName("ed.ax(IB)V")
	public void method2214(int arg0) {
		if ((this.field2244[arg0] & 0x4) == 0) {
			return;
		}
		for (MidiNote var2 = (MidiNote) this.field2253.field2255.head(); var2 != null; var2 = (MidiNote) this.field2253.field2255.next()) {
			if (var2.field1760 == arg0) {
				var2.field1766 = 0;
			}
		}
	}

	@ObfuscatedName("ed.ai(II)V")
	public void method2215(int arg0) {
		int var2 = arg0 & 0xF0;
		if (var2 == 128) {
			int var3 = arg0 & 0xF;
			int var4 = arg0 >> 8 & 0x7F;
			int var5 = arg0 >> 16 & 0x7F;
			this.method2258(var3, var4, var5);
		} else if (var2 == 144) {
			int var6 = arg0 & 0xF;
			int var7 = arg0 >> 8 & 0x7F;
			int var8 = arg0 >> 16 & 0x7F;
			if (var8 > 0) {
				this.method2224(var6, var7, var8);
			} else {
				this.method2258(var6, var7, 64);
			}
		} else if (var2 == 160) {
			int var9 = arg0 & 0xF;
			int var10 = arg0 >> 8 & 0x7F;
			int var11 = arg0 >> 16 & 0x7F;
			this.method2207(var9, var10, var11);
		} else if (var2 == 176) {
			int var12 = arg0 & 0xF;
			int var13 = arg0 >> 8 & 0x7F;
			int var14 = arg0 >> 16 & 0x7F;
			if (var13 == 0) {
				this.field2229[var12] = (var14 << 14) + (this.field2229[var12] & 0xFFE03FFF);
			}
			if (var13 == 32) {
				this.field2229[var12] = (var14 << 7) + (this.field2229[var12] & 0xFFFFC07F);
			}
			if (var13 == 1) {
				this.field2232[var12] = (var14 << 7) + (this.field2232[var12] & 0xFFFFC07F);
			}
			if (var13 == 33) {
				this.field2232[var12] = (this.field2232[var12] & 0xFFFFFF80) + var14;
			}
			if (var13 == 5) {
				this.field2228[var12] = (var14 << 7) + (this.field2228[var12] & 0xFFFFC07F);
			}
			if (var13 == 37) {
				this.field2228[var12] = (this.field2228[var12] & 0xFFFFFF80) + var14;
			}
			if (var13 == 7) {
				this.field2238[var12] = (var14 << 7) + (this.field2238[var12] & 0xFFFFC07F);
			}
			if (var13 == 39) {
				this.field2238[var12] = (this.field2238[var12] & 0xFFFFFF80) + var14;
			}
			if (var13 == 10) {
				this.field2227[var12] = (var14 << 7) + (this.field2227[var12] & 0xFFFFC07F);
			}
			if (var13 == 42) {
				this.field2227[var12] = (this.field2227[var12] & 0xFFFFFF80) + var14;
			}
			if (var13 == 11) {
				this.field2239[var12] = (var14 << 7) + (this.field2239[var12] & 0xFFFFC07F);
			}
			if (var13 == 43) {
				this.field2239[var12] = (this.field2239[var12] & 0xFFFFFF80) + var14;
			}
			if (var13 == 64) {
				if (var14 >= 64) {
					this.field2244[var12] |= 0x1;
				} else {
					this.field2244[var12] &= 0xFFFFFFFE;
				}
			}
			if (var13 == 65) {
				if (var14 >= 64) {
					this.field2244[var12] |= 0x2;
				} else {
					this.method2202(var12);
					this.field2244[var12] &= 0xFFFFFFFD;
				}
			}
			if (var13 == 99) {
				this.field2240[var12] = (var14 << 7) + (this.field2240[var12] & 0x7F);
			}
			if (var13 == 98) {
				this.field2240[var12] = (this.field2240[var12] & 0x3F80) + var14;
			}
			if (var13 == 101) {
				this.field2240[var12] = (var14 << 7) + (this.field2240[var12] & 0x7F) + 16384;
			}
			if (var13 == 100) {
				this.field2240[var12] = (this.field2240[var12] & 0x3F80) + 16384 + var14;
			}
			if (var13 == 120) {
				this.method2283(var12);
			}
			if (var13 == 121) {
				this.method2210(var12);
			}
			if (var13 == 123) {
				this.method2211(var12);
			}
			if (var13 == 6) {
				int var15 = this.field2240[var12];
				if (var15 == 16384) {
					this.field2241[var12] = (var14 << 7) + (this.field2241[var12] & 0xFFFFC07F);
				}
			}
			if (var13 == 38) {
				int var16 = this.field2240[var12];
				if (var16 == 16384) {
					this.field2241[var12] = (this.field2241[var12] & 0xFFFFFF80) + var14;
				}
			}
			if (var13 == 16) {
				this.field2242[var12] = (var14 << 7) + (this.field2242[var12] & 0xFFFFC07F);
			}
			if (var13 == 48) {
				this.field2242[var12] = (this.field2242[var12] & 0xFFFFFF80) + var14;
			}
			if (var13 == 81) {
				if (var14 >= 64) {
					this.field2244[var12] |= 0x4;
				} else {
					this.method2214(var12);
					this.field2244[var12] &= 0xFFFFFFFB;
				}
			}
			if (var13 == 17) {
				this.method2216(var12, (var14 << 7) + (this.field2243[var12] & 0xFFFFC07F));
			}
			if (var13 == 49) {
				this.method2216(var12, (this.field2243[var12] & 0xFFFFFF80) + var14);
			}
		} else if (var2 == 192) {
			int var17 = arg0 & 0xF;
			int var18 = arg0 >> 8 & 0x7F;
			this.method2226(var17, this.field2229[var17] + var18);
		} else if (var2 == 208) {
			int var19 = arg0 & 0xF;
			int var20 = arg0 >> 8 & 0x7F;
			this.method2237(var19, var20);
		} else if (var2 == 224) {
			int var21 = arg0 & 0xF;
			int var22 = (arg0 >> 8 & 0x7F) + (arg0 >> 9 & 0x3F80);
			this.method2208(var21, var22);
		} else {
			int var23 = arg0 & 0xFF;
			if (var23 == 255) {
				this.method2212();
			}
		}
	}

	@ObfuscatedName("ed.aj(III)V")
	public void method2216(int arg0, int arg1) {
		this.field2243[arg0] = arg1;
		this.field2250[arg0] = (int) (Math.pow(2.0D, (double) arg1 * 5.4931640625E-4D) * 2097152.0D + 0.5D);
	}

	@ObfuscatedName("ed.aw(Lej;I)I")
	public int method2203(MidiNote arg0) {
		int var2 = (arg0.field1755 * arg0.field1754 >> 12) + arg0.field1753;
		int var3 = ((this.field2233[arg0.field1760] - 8192) * this.field2241[arg0.field1760] >> 12) + var2;
		MidiSound var4 = arg0.field1757;
		if (var4.field1131 > 0 && (var4.field1130 > 0 || this.field2232[arg0.field1760] > 0)) {
			int var5 = var4.field1130 << 2;
			int var6 = var4.field1124 << 1;
			if (arg0.field1761 < var6) {
				var5 = arg0.field1761 * var5 / var6;
			}
			int var7 = (this.field2232[arg0.field1760] >> 7) + var5;
			double var8 = Math.sin((double) (arg0.field1762 & 0x1FF) * 0.01227184630308513D);
			var3 += (int) ((double) var7 * var8);
		}
		int var10 = (int) ((double) (arg0.field1759.field2200 * 256) * Math.pow(2.0D, (double) var3 * 3.255208333333333E-4D) / (double) AudioChannel.field241 + 0.5D);
		return var10 < 1 ? 1 : var10;
	}

	@ObfuscatedName("ed.af(Lej;I)I")
	public int method2247(MidiNote arg0) {
		MidiSound var2 = arg0.field1757;
		int var3 = this.field2239[arg0.field1760] * this.field2238[arg0.field1760] + 4096 >> 13;
		int var4 = var3 * var3 + 16384 >> 15;
		int var5 = arg0.field1751 * var4 + 16384 >> 15;
		int var6 = this.field2234 * var5 + 128 >> 8;
		if (var2.field1126 > 0) {
			var6 = (int) ((double) var6 * Math.pow(0.5D, (double) arg0.field1756 * 1.953125E-5D * (double) var2.field1126) + 0.5D);
		}
		if (var2.field1129 != null) {
			int var7 = arg0.field1752;
			int var8 = var2.field1129[arg0.field1758 + 1];
			if (arg0.field1758 < var2.field1129.length - 2) {
				int var9 = (var2.field1129[arg0.field1758] & 0xFF) << 8;
				int var10 = (var2.field1129[arg0.field1758 + 2] & 0xFF) << 8;
				var8 += (var2.field1129[arg0.field1758 + 3] - var8) * (var7 - var9) / (var10 - var9);
			}
			var6 = var6 * var8 + 32 >> 6;
		}
		if (arg0.field1745 > 0 && var2.field1125 != null) {
			int var11 = arg0.field1745;
			int var12 = var2.field1125[arg0.field1748 + 1];
			if (arg0.field1748 < var2.field1125.length - 2) {
				int var13 = (var2.field1125[arg0.field1748] & 0xFF) << 8;
				int var14 = (var2.field1125[arg0.field1748 + 2] & 0xFF) << 8;
				var12 += (var2.field1125[arg0.field1748 + 3] - var12) * (var11 - var13) / (var14 - var13);
			}
			var6 = var6 * var12 + 32 >> 6;
		}
		return var6;
	}

	@ObfuscatedName("ed.bh(Lej;I)I")
	public int method2251(MidiNote arg0) {
		int var2 = this.field2227[arg0.field1760];
		return var2 < 8192 ? arg0.field1747 * var2 + 32 >> 6 : 16384 - ((128 - arg0.field1747) * (16384 - var2) + 32 >> 6);
	}

	@ObfuscatedName("ed.n()Ldx;")
	public synchronized PcmStream method1516() {
		return this.field2253;
	}

	@ObfuscatedName("ed.j()Ldx;")
	public synchronized PcmStream method1517() {
		return null;
	}

	@ObfuscatedName("ed.z()I")
	public synchronized int method1518() {
		return 0;
	}

	@ObfuscatedName("ed.q([III)V")
	public synchronized void method1520(int[] arg0, int arg1, int arg2) {
		if (this.field2247.method955()) {
			int var4 = this.field2235 * this.field2247.field1148 / AudioChannel.field241;
			do {
				long var5 = (long) arg2 * (long) var4 + this.field2251;
				if (this.field2252 - var5 >= 0L) {
					this.field2251 = var5;
					break;
				}
				int var7 = (int) ((this.field2252 - this.field2251 + (long) var4 - 1L) / (long) var4);
				this.field2251 += (long) var4 * (long) var7;
				this.field2253.method1520(arg0, arg1, var7);
				arg1 += var7;
				arg2 -= var7;
				this.method2222();
			} while (this.field2247.method955());
		}
		this.field2253.method1520(arg0, arg1, arg2);
	}

	@ObfuscatedName("ed.i(I)V")
	public synchronized void method1521(int arg0) {
		if (this.field2247.method955()) {
			int var2 = this.field2235 * this.field2247.field1148 / AudioChannel.field241;
			do {
				long var3 = (long) arg0 * (long) var2 + this.field2251;
				if (this.field2252 - var3 >= 0L) {
					this.field2251 = var3;
					break;
				}
				int var5 = (int) ((this.field2252 - this.field2251 + (long) var2 - 1L) / (long) var2);
				this.field2251 += (long) var2 * (long) var5;
				this.field2253.method1521(var5);
				arg0 -= var5;
				this.method2222();
			} while (this.field2247.method955());
		}
		this.field2253.method1521(arg0);
	}

	@ObfuscatedName("ed.bi(I)V")
	public void method2222() {
		int var1 = this.field2249;
		int var2 = this.field2224;
		long var3 = this.field2252;
		while (this.field2224 == var2) {
			while (this.field2247.field1135[var1] == var2) {
				this.field2247.method957(var1);
				int var5 = this.field2247.method967(var1);
				if (var5 == 1) {
					this.field2247.method959();
					this.field2247.method958(var1);
					if (this.field2247.method966()) {
						if (!this.field2248 || var2 == 0) {
							this.method2212();
							this.field2247.method965();
							return;
						}
						this.field2247.method975(var3);
					}
					break;
				}
				if ((var5 & 0x80) != 0) {
					this.method2215(var5);
				}
				this.field2247.method960(var1);
				this.field2247.method958(var1);
			}
			var1 = this.field2247.method987();
			var2 = this.field2247.field1135[var1];
			var3 = this.field2247.method964(var2);
		}
		this.field2249 = var1;
		this.field2224 = var2;
		this.field2252 = var3;
	}

	@ObfuscatedName("ed.bs(Lej;B)Z")
	public boolean method2223(MidiNote arg0) {
		if (arg0.field1763 != null) {
			return false;
		}
		if (arg0.field1745 >= 0) {
			arg0.unlink();
			if (arg0.field1749 > 0 && this.field2246[arg0.field1760][arg0.field1749] == arg0) {
				this.field2246[arg0.field1760][arg0.field1749] = null;
			}
		}
		return true;
	}

	@ObfuscatedName("ed.bk(Lej;[IIIB)Z")
	public boolean method2260(MidiNote arg0, int[] arg1, int arg2, int arg3) {
		arg0.field1764 = AudioChannel.field241 / 100;
		if (arg0.field1745 >= 0 && (arg0.field1763 == null || arg0.field1763.method2161())) {
			arg0.method1787();
			arg0.unlink();
			if (arg0.field1749 > 0 && this.field2246[arg0.field1760][arg0.field1749] == arg0) {
				this.field2246[arg0.field1760][arg0.field1749] = null;
			}
			return true;
		}
		int var5 = arg0.field1755;
		if (var5 > 0) {
			int var6 = var5 - (int) (Math.pow(2.0D, (double) this.field2228[arg0.field1760] * 4.921259842519685E-4D) * 16.0D + 0.5D);
			if (var6 < 0) {
				var6 = 0;
			}
			arg0.field1755 = var6;
		}
		arg0.field1763.method2073(this.method2203(arg0));
		MidiSound var7 = arg0.field1757;
		boolean var8 = false;
		arg0.field1761++;
		arg0.field1762 += var7.field1131;
		double var9 = (double) ((arg0.field1750 - 60 << 8) + (arg0.field1755 * arg0.field1754 >> 12)) * 5.086263020833333E-6D;
		if (var7.field1126 > 0) {
			if (var7.field1132 > 0) {
				arg0.field1756 += (int) (Math.pow(2.0D, (double) var7.field1132 * var9) * 128.0D + 0.5D);
			} else {
				arg0.field1756 += 128;
			}
		}
		if (var7.field1129 != null) {
			if (var7.field1127 > 0) {
				arg0.field1752 += (int) (Math.pow(2.0D, (double) var7.field1127 * var9) * 128.0D + 0.5D);
			} else {
				arg0.field1752 += 128;
			}
			while (arg0.field1758 < var7.field1129.length - 2 && arg0.field1752 > (var7.field1129[arg0.field1758 + 2] & 0xFF) << 8) {
				arg0.field1758 += 2;
			}
			if (arg0.field1758 == var7.field1129.length - 2 && var7.field1129[arg0.field1758 + 1] == 0) {
				var8 = true;
			}
		}
		if (arg0.field1745 >= 0 && var7.field1125 != null && (this.field2244[arg0.field1760] & 0x1) == 0 && (arg0.field1749 < 0 || this.field2246[arg0.field1760][arg0.field1749] != arg0)) {
			if (var7.field1128 > 0) {
				arg0.field1745 += (int) (Math.pow(2.0D, (double) var7.field1128 * var9) * 128.0D + 0.5D);
			} else {
				arg0.field1745 += 128;
			}
			while (arg0.field1748 < var7.field1125.length - 2 && arg0.field1745 > (var7.field1125[arg0.field1748 + 2] & 0xFF) << 8) {
				arg0.field1748 += 2;
			}
			if (arg0.field1748 == var7.field1125.length - 2) {
				var8 = true;
			}
		}
		if (!var8) {
			arg0.field1763.method2071(arg0.field1764, this.method2247(arg0), this.method2251(arg0));
			return false;
		}
		arg0.field1763.method2081(arg0.field1764);
		if (arg1 == null) {
			arg0.field1763.method1521(arg3);
		} else {
			arg0.field1763.method1520(arg1, arg2, arg3);
		}
		if (arg0.field1763.method2076()) {
			this.field2253.field2254.method2174(arg0.field1763);
		}
		arg0.method1787();
		if (arg0.field1745 >= 0) {
			arg0.unlink();
			if (arg0.field1749 > 0 && this.field2246[arg0.field1760][arg0.field1749] == arg0) {
				this.field2246[arg0.field1760][arg0.field1749] = null;
			}
		}
		return true;
	}
}
