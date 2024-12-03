package jagex2.client;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.config.*;
import jagex2.datastruct.JStringUtil;
import jagex2.datastruct.StringComparator;
import jagex2.datastruct.TextUtil;
import jagex2.graphics.PixFont;
import jagex2.graphics.SoftwareFont;
import jagex2.io.Packet;
import jagex2.jstring.EnglishLocale;
import jagex2.jstring.JString;
import jagex2.sound.MidiPlayer;
import jagex2.wordenc.WordPack;

import java.util.Calendar;
import java.util.Date;

@ObfuscatedName("s")
public class ScriptRunner {

	@ObfuscatedName("s.m")
	public static int[] field193 = new int[5];

	@ObfuscatedName("s.c")
	public static int[][] field192 = new int[5][5000];

	@ObfuscatedName("s.n")
	public static int[] field188 = new int[1000];

	@ObfuscatedName("s.j")
	public static String[] field194 = new String[1000];

	@ObfuscatedName("s.z")
	public static int field195 = 0;

	@ObfuscatedName("s.g")
	public static GoSubFrame[] field196 = new GoSubFrame[50];

	@ObfuscatedName("s.s")
	public static Calendar field197 = Calendar.getInstance();

	@ObfuscatedName("s.u")
	public static final String[] field190 = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

	public ScriptRunner() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("bv.r(Ldu;B)V")
	public static void method777(HookRequest arg0) {
		Object[] var1 = arg0.field1588;
		int var2 = (Integer) var1[0];
		ClientScript var3 = ClientScript.method872(var2);
		if (var3 == null) {
			return;
		}
		int var4 = 0;
		int var5 = 0;
		int var6 = -1;
		int[] var7 = var3.field2261;
		int[] var8 = var3.field2260;
		byte var9 = -1;
		field195 = 0;
		try {
			Statics.field189 = new int[var3.field2263];
			int var10 = 0;
			Statics.field191 = new String[var3.field2265];
			int var11 = 0;
			for (int var12 = 1; var12 < var1.length; var12++) {
				if (var1[var12] instanceof Integer) {
					int var13 = (Integer) var1[var12];
					if (var13 == -2147483647) {
						var13 = arg0.field1589;
					}
					if (var13 == -2147483646) {
						var13 = arg0.field1587;
					}
					if (var13 == -2147483645) {
						var13 = arg0.field1590 == null ? -1 : arg0.field1590.field1783;
					}
					if (var13 == -2147483644) {
						var13 = arg0.field1591;
					}
					if (var13 == -2147483643) {
						var13 = arg0.field1590 == null ? -1 : arg0.field1590.field1823;
					}
					if (var13 == -2147483642) {
						var13 = arg0.field1592 == null ? -1 : arg0.field1592.field1783;
					}
					if (var13 == -2147483641) {
						var13 = arg0.field1592 == null ? -1 : arg0.field1592.field1823;
					}
					if (var13 == -2147483640) {
						var13 = arg0.field1593;
					}
					if (var13 == -2147483639) {
						var13 = arg0.field1594;
					}
					Statics.field189[var10++] = var13;
				} else if (var1[var12] instanceof String) {
					String var14 = (String) var1[var12];
					if (var14.equals("event_opbase")) {
						var14 = arg0.field1595;
					}
					Statics.field191[var11++] = var14;
				}
			}
			int var15 = 0;
			label2279: while (true) {
				var15++;
				if (var15 > 200000) {
					throw new RuntimeException();
				}
				var6++;
				int var367 = var7[var6];
				if (var367 < 100) {
					if (var367 == 0) {
						field188[var4++] = var8[var6];
						continue;
					}
					if (var367 == 1) {
						int var16 = var8[var6];
						field188[var4++] = VarProvider.field1210[var16];
						continue;
					}
					if (var367 == 2) {
						int var17 = var8[var6];
						var4--;
						VarProvider.field1210[var17] = field188[var4];
						continue;
					}
					if (var367 == 3) {
						field194[var5++] = var3.field2264[var6];
						continue;
					}
					if (var367 == 6) {
						var6 += var8[var6];
						continue;
					}
					if (var367 == 7) {
						var4 -= 2;
						if (field188[var4 + 1] != field188[var4]) {
							var6 += var8[var6];
						}
						continue;
					}
					if (var367 == 8) {
						var4 -= 2;
						if (field188[var4 + 1] == field188[var4]) {
							var6 += var8[var6];
						}
						continue;
					}
					if (var367 == 9) {
						var4 -= 2;
						if (field188[var4] < field188[var4 + 1]) {
							var6 += var8[var6];
						}
						continue;
					}
					if (var367 == 10) {
						var4 -= 2;
						if (field188[var4] > field188[var4 + 1]) {
							var6 += var8[var6];
						}
						continue;
					}
					if (var367 == 21) {
						if (field195 == 0) {
							return;
						}
						GoSubFrame var18 = field196[--field195];
						var3 = var18.field122;
						var7 = var3.field2261;
						var8 = var3.field2260;
						var6 = var18.field121;
						Statics.field189 = var18.field123;
						Statics.field191 = var18.field124;
						continue;
					}
					if (var367 == 25) {
						int var19 = var8[var6];
						field188[var4++] = VarProvider.method1130(var19);
						continue;
					}
					if (var367 == 27) {
						int var20 = var8[var6];
						var4--;
						int var21 = field188[var4];
						VarBitType var22 = VarBitType.method98(var20);
						int var23 = var22.field2418;
						int var24 = var22.field2416;
						int var25 = var22.field2420;
						int var26 = VarProvider.field1212[var25 - var24];
						if (var21 < 0 || var21 > var26) {
							var21 = 0;
						}
						int var27 = var26 << var24;
						VarProvider.field1210[var23] = VarProvider.field1210[var23] & ~var27 | var21 << var24 & var27;
						continue;
					}
					if (var367 == 31) {
						var4 -= 2;
						if (field188[var4] <= field188[var4 + 1]) {
							var6 += var8[var6];
						}
						continue;
					}
					if (var367 == 32) {
						var4 -= 2;
						if (field188[var4] >= field188[var4 + 1]) {
							var6 += var8[var6];
						}
						continue;
					}
					if (var367 == 33) {
						field188[var4++] = Statics.field189[var8[var6]];
						continue;
					}
					int var10001;
					if (var367 == 34) {
						var10001 = var8[var6];
						var4--;
						Statics.field189[var10001] = field188[var4];
						continue;
					}
					if (var367 == 35) {
						field194[var5++] = Statics.field191[var8[var6]];
						continue;
					}
					if (var367 == 36) {
						var10001 = var8[var6];
						var5--;
						Statics.field191[var10001] = field194[var5];
						continue;
					}
					if (var367 == 37) {
						int var28 = var8[var6];
						var5 -= var28;
						String var29 = JStringUtil.method1785(field194, var5, var28);
						field194[var5++] = var29;
						continue;
					}
					if (var367 == 38) {
						var4--;
						continue;
					}
					if (var367 == 39) {
						var5--;
						continue;
					}
					if (var367 == 40) {
						int var30 = var8[var6];
						ClientScript var31 = ClientScript.method872(var30);
						int[] var32 = new int[var31.field2263];
						String[] var33 = new String[var31.field2265];
						for (int var34 = 0; var34 < var31.field2266; var34++) {
							var32[var34] = field188[var4 - var31.field2266 + var34];
						}
						for (int var35 = 0; var35 < var31.field2267; var35++) {
							var33[var35] = field194[var5 - var31.field2267 + var35];
						}
						var4 -= var31.field2266;
						var5 -= var31.field2267;
						GoSubFrame var36 = new GoSubFrame();
						var36.field122 = var3;
						var36.field121 = var6;
						var36.field123 = Statics.field189;
						var36.field124 = Statics.field191;
						field196[++field195 - 1] = var36;
						var3 = var31;
						var7 = var31.field2261;
						var8 = var31.field2260;
						var6 = -1;
						Statics.field189 = var32;
						Statics.field191 = var33;
						continue;
					}
					if (var367 == 42) {
						field188[var4++] = Client.field2120[var8[var6]];
						continue;
					}
					if (var367 == 43) {
						var10001 = var8[var6];
						var4--;
						Client.field2120[var10001] = field188[var4];
						continue;
					}
					if (var367 == 44) {
						int var37 = var8[var6] >> 16;
						int var38 = var8[var6] & 0xFFFF;
						var4--;
						int var39 = field188[var4];
						if (var39 >= 0 && var39 <= 5000) {
							field193[var37] = var39;
							byte var40 = -1;
							if (var38 == 105) {
								var40 = 0;
							}
							int var41 = 0;
							while (true) {
								if (var41 >= var39) {
									continue label2279;
								}
								field192[var37][var41] = var40;
								var41++;
							}
						}
						throw new RuntimeException();
					}
					if (var367 == 45) {
						int var42 = var8[var6];
						var4--;
						int var43 = field188[var4];
						if (var43 >= 0 && var43 < field193[var42]) {
							field188[var4++] = field192[var42][var43];
							continue;
						}
						throw new RuntimeException();
					}
					if (var367 == 46) {
						int var44 = var8[var6];
						var4 -= 2;
						int var45 = field188[var4];
						if (var45 >= 0 && var45 < field193[var44]) {
							field192[var44][var45] = field188[var4 + 1];
							continue;
						}
						throw new RuntimeException();
					}
					if (var367 == 47) {
						String var46 = Client.field1996[var8[var6]];
						if (var46 == null) {
							var46 = "null";
						}
						field194[var5++] = var46;
						continue;
					}
					if (var367 == 48) {
						var10001 = var8[var6];
						var5--;
						Client.field1996[var10001] = field194[var5];
						continue;
					}
				}
				boolean var47;
				if (var8[var6] == 1) {
					var47 = true;
				} else {
					var47 = false;
				}
				if (var367 < 1000) {
					if (var367 == 100) {
						var4 -= 3;
						int var48 = field188[var4];
						int var49 = field188[var4 + 1];
						int var50 = field188[var4 + 2];
						if (var49 == 0) {
							throw new RuntimeException();
						}
						IfType var51 = IfType.method813(var48);
						if (var51.field1825 == null) {
							var51.field1825 = new IfType[var50 + 1];
						}
						if (var51.field1825.length <= var50) {
							IfType[] var52 = new IfType[var50 + 1];
							for (int var53 = 0; var53 < var51.field1825.length; var53++) {
								var52[var53] = var51.field1825[var53];
							}
							var51.field1825 = var52;
						}
						if (var50 > 0 && var51.field1825[var50 - 1] == null) {
							throw new RuntimeException("" + (var50 - 1));
						}
						IfType var54 = new IfType();
						var54.field1785 = var49;
						var54.field1896 = var54.field1783 = var51.field1783;
						var54.field1823 = var50;
						var54.field1782 = true;
						var51.field1825[var50] = var54;
						if (var47) {
							Statics.field1108 = var54;
						} else {
							Statics.field335 = var54;
						}
						Client.method1238(var51);
						continue;
					}
					if (var367 == 101) {
						IfType var55 = var47 ? Statics.field1108 : Statics.field335;
						IfType var56 = IfType.method813(var55.field1783);
						var56.field1825[var55.field1823] = null;
						Client.method1238(var56);
						continue;
					}
					if (var367 == 102) {
						var4--;
						IfType var57 = IfType.method813(field188[var4]);
						var57.field1825 = null;
						Client.method1238(var57);
						continue;
					}
					if (var367 == 200) {
						var4 -= 2;
						int var58 = field188[var4];
						int var59 = field188[var4 + 1];
						IfType var60 = IfType.method947(var58, var59);
						if (var60 != null && var59 != -1) {
							field188[var4++] = 1;
							if (var47) {
								Statics.field1108 = var60;
							} else {
								Statics.field335 = var60;
							}
							continue;
						}
						field188[var4++] = 0;
						continue;
					}
				} else if (var367 >= 1000 && var367 < 1100 || !(var367 < 2000 || var367 >= 2100)) {
					IfType var61;
					if (var367 >= 2000) {
						var367 -= 1000;
						var4--;
						var61 = IfType.method813(field188[var4]);
					} else {
						var61 = var47 ? Statics.field1108 : Statics.field335;
					}
					if (var367 == 1000) {
						var4 -= 2;
						var61.field1788 = field188[var4];
						var61.field1810 = field188[var4 + 1];
						Client.method1238(var61);
						continue;
					}
					if (var367 == 1001) {
						var4 -= 2;
						var61.field1792 = field188[var4];
						var61.field1793 = field188[var4 + 1];
						Client.method1238(var61);
						continue;
					}
					if (var367 == 1003) {
						var4--;
						boolean var62 = field188[var4] == 1;
						if (var61.field1880 != var62) {
							var61.field1880 = var62;
							Client.method1238(var61);
						}
						continue;
					}
				} else if (var367 >= 1100 && var367 < 1200 || !(var367 < 2100 || var367 >= 2200)) {
					IfType var63;
					if (var367 >= 2000) {
						var367 -= 1000;
						var4--;
						var63 = IfType.method813(field188[var4]);
					} else {
						var63 = var47 ? Statics.field1108 : Statics.field335;
					}
					if (var367 == 1100) {
						var4 -= 2;
						var63.field1796 = field188[var4];
						if (var63.field1796 > var63.field1884 - var63.field1792) {
							var63.field1796 = var63.field1884 - var63.field1792;
						}
						if (var63.field1796 < 0) {
							var63.field1796 = 0;
						}
						var63.field1797 = field188[var4 + 1];
						if (var63.field1797 > var63.field1799 - var63.field1793) {
							var63.field1797 = var63.field1799 - var63.field1793;
						}
						if (var63.field1797 < 0) {
							var63.field1797 = 0;
						}
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1101) {
						var4--;
						var63.field1822 = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1102) {
						var4--;
						var63.field1893 = field188[var4] == 1;
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1103) {
						var4--;
						var63.field1805 = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1104) {
						var4--;
						var63.field1804 = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1105) {
						var4--;
						var63.field1807 = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1106) {
						var4--;
						var63.field1784 = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1107) {
						var4--;
						var63.field1794 = field188[var4] == 1;
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1108) {
						var63.field1815 = 1;
						var4--;
						var63.field1816 = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1109) {
						var4 -= 6;
						var63.field1821 = field188[var4];
						var63.field1798 = field188[var4 + 1];
						var63.field1848 = field188[var4 + 2];
						var63.field1824 = field188[var4 + 3];
						var63.field1817 = field188[var4 + 4];
						var63.field1826 = field188[var4 + 5];
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1110) {
						var4--;
						int var64 = field188[var4];
						if (var63.field1863 != var64) {
							var63.field1863 = var64;
							var63.field1779 = 0;
							var63.field1890 = 0;
							Client.method1238(var63);
						}
						continue;
					}
					if (var367 == 1111) {
						var4--;
						var63.field1828 = field188[var4] == 1;
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1112) {
						var5--;
						String var65 = field194[var5];
						if (!var65.equals(var63.field1830)) {
							var63.field1830 = var65;
							Client.method1238(var63);
						}
						continue;
					}
					if (var367 == 1113) {
						var4--;
						var63.field1829 = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1114) {
						var4 -= 3;
						var63.field1864 = field188[var4];
						var63.field1834 = field188[var4 + 1];
						var63.field1832 = field188[var4 + 2];
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1115) {
						var4--;
						var63.field1835 = field188[var4] == 1;
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1116) {
						var4--;
						var63.field1811 = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1117) {
						var4--;
						var63.field1812 = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1118) {
						var4--;
						var63.field1849 = field188[var4] == 1;
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1119) {
						var4--;
						var63.field1814 = field188[var4] == 1;
						Client.method1238(var63);
						continue;
					}
					if (var367 == 1120) {
						var4 -= 2;
						var63.field1884 = field188[var4];
						var63.field1799 = field188[var4 + 1];
						Client.method1238(var63);
						continue;
					}
				} else if (var367 >= 1200 && var367 < 1300 || !(var367 < 2200 || var367 >= 2300)) {
					IfType var66;
					if (var367 >= 2000) {
						var367 -= 1000;
						var4--;
						var66 = IfType.method813(field188[var4]);
					} else {
						var66 = var47 ? Statics.field1108 : Statics.field335;
					}
					Client.method1238(var66);
					if (var367 == 1200) {
						var4 -= 2;
						int var67 = field188[var4];
						int var68 = field188[var4 + 1];
						var66.field1791 = var67;
						var66.field1888 = var68;
						ObjType var69 = ObjType.method927(var67);
						var66.field1848 = var69.field2443;
						var66.field1824 = var69.field2444;
						var66.field1817 = var69.field2463;
						var66.field1821 = var69.field2471;
						var66.field1798 = var69.field2447;
						var66.field1826 = var69.field2442;
						if (var66.field1792 > 0) {
							var66.field1826 = var66.field1826 * 32 / var66.field1792;
						}
						continue;
					}
					if (var367 == 1201) {
						var66.field1815 = 2;
						var4--;
						var66.field1816 = field188[var4];
						continue;
					}
					if (var367 == 1202) {
						var66.field1815 = 3;
						var66.field1816 = Statics.field1134.field2786.method1176();
						continue;
					}
				} else if (var367 >= 1300 && var367 < 1400 || var367 >= 2300 && var367 < 2400) {
					IfType var70;
					if (var367 >= 2000) {
						var367 -= 1000;
						var4--;
						var70 = IfType.method813(field188[var4]);
					} else {
						var70 = var47 ? Statics.field1108 : Statics.field335;
					}
					if (var367 == 1300) {
						var4--;
						int var71 = field188[var4] - 1;
						if (var71 >= 0 && var71 <= 9) {
							var5--;
							var70.method1829(var71, field194[var5]);
							continue;
						}
						var5--;
						continue;
					}
					if (var367 == 1301) {
						var4 -= 2;
						int var72 = field188[var4];
						int var73 = field188[var4 + 1];
						var70.field1845 = IfType.method947(var72, var73);
						continue;
					}
					if (var367 == 1302) {
						var4--;
						var70.field1858 = field188[var4] == 1;
						continue;
					}
					if (var367 == 1303) {
						var4--;
						var70.field1846 = field188[var4];
						continue;
					}
					if (var367 == 1304) {
						var4--;
						var70.field1887 = field188[var4];
						continue;
					}
					if (var367 == 1305) {
						var5--;
						var70.field1795 = field194[var5];
						continue;
					}
					if (var367 == 1306) {
						var5--;
						var70.field1841 = field194[var5];
						continue;
					}
					if (var367 == 1307) {
						var70.field1844 = null;
						continue;
					}
				} else {
					if (var367 >= 1400 && var367 < 1500 || var367 >= 2400 && var367 < 2500) {
						IfType var74;
						if (var367 >= 2000) {
							var367 -= 1000;
							var4--;
							var74 = IfType.method813(field188[var4]);
						} else {
							var74 = var47 ? Statics.field1108 : Statics.field335;
						}
						var5--;
						String var75 = field194[var5];
						int[] var76 = null;
						if (var75.length() > 0 && var75.charAt(var75.length() - 1) == 'Y') {
							var4--;
							int var77 = field188[var4];
							if (var77 > 0) {
								var76 = new int[var77];
								while (var77-- > 0) {
									var4--;
									var76[var77] = field188[var4];
								}
							}
							var75 = var75.substring(0, var75.length() - 1);
						}
						Object[] var78 = new Object[var75.length() + 1];
						for (int var79 = var78.length - 1; var79 >= 1; var79--) {
							if (var75.charAt(var79 - 1) == 's') {
								var5--;
								var78[var79] = field194[var5];
							} else {
								var4--;
								var78[var79] = Integer.valueOf(field188[var4]);
							}
						}
						var4--;
						int var80 = field188[var4];
						if (var80 == -1) {
							var78 = null;
						} else {
							var78[0] = Integer.valueOf(var80);
						}
						if (var367 == 1400) {
							var74.field1852 = var78;
						}
						if (var367 == 1401) {
							var74.field1855 = var78;
						}
						if (var367 == 1402) {
							var74.field1851 = var78;
						}
						if (var367 == 1403) {
							var74.field1856 = var78;
						}
						if (var367 == 1404) {
							var74.field1838 = var78;
						}
						if (var367 == 1405) {
							var74.field1781 = var78;
						}
						if (var367 == 1406) {
							var74.field1836 = var78;
						}
						if (var367 == 1407) {
							var74.field1839 = var78;
							var74.field1889 = var76;
						}
						if (var367 == 1408) {
							var74.field1869 = var78;
						}
						if (var367 == 1409) {
							var74.field1847 = var78;
						}
						if (var367 == 1410) {
							var74.field1860 = var78;
						}
						if (var367 == 1411) {
							var74.field1853 = var78;
						}
						if (var367 == 1412) {
							var74.field1857 = var78;
						}
						if (var367 == 1414) {
							var74.field1865 = var78;
							var74.field1866 = var76;
						}
						if (var367 == 1415) {
							var74.field1867 = var78;
							var74.field1868 = var76;
						}
						if (var367 == 1416) {
							var74.field1861 = var78;
						}
						if (var367 == 1417) {
							var74.field1831 = var78;
						}
						if (var367 == 1418) {
							var74.field1872 = var78;
						}
						if (var367 == 1419) {
							var74.field1873 = var78;
						}
						if (var367 == 1420) {
							var74.field1877 = var78;
						}
						if (var367 == 1421) {
							var74.field1875 = var78;
						}
						if (var367 == 1422) {
							var74.field1777 = var78;
						}
						if (var367 == 1423) {
							var74.field1819 = var78;
						}
						if (var367 == 1424) {
							var74.field1878 = var78;
						}
						var74.field1813 = true;
						continue;
					}
					if (var367 < 1600) {
						IfType var81 = var47 ? Statics.field1108 : Statics.field335;
						if (var367 == 1500) {
							field188[var4++] = var81.field1788;
							continue;
						}
						if (var367 == 1501) {
							field188[var4++] = var81.field1810;
							continue;
						}
						if (var367 == 1502) {
							field188[var4++] = var81.field1792;
							continue;
						}
						if (var367 == 1503) {
							field188[var4++] = var81.field1793;
							continue;
						}
						if (var367 == 1504) {
							field188[var4++] = var81.field1880 ? 1 : 0;
							continue;
						}
						if (var367 == 1505) {
							field188[var4++] = var81.field1896;
							continue;
						}
					} else if (var367 < 1700) {
						IfType var82 = var47 ? Statics.field1108 : Statics.field335;
						if (var367 == 1600) {
							field188[var4++] = var82.field1796;
							continue;
						}
						if (var367 == 1601) {
							field188[var4++] = var82.field1797;
							continue;
						}
						if (var367 == 1602) {
							field194[var5++] = var82.field1830;
							continue;
						}
						if (var367 == 1603) {
							field188[var4++] = var82.field1884;
							continue;
						}
						if (var367 == 1604) {
							field188[var4++] = var82.field1799;
							continue;
						}
						if (var367 == 1605) {
							field188[var4++] = var82.field1826;
							continue;
						}
						if (var367 == 1606) {
							field188[var4++] = var82.field1848;
							continue;
						}
						if (var367 == 1607) {
							field188[var4++] = var82.field1817;
							continue;
						}
						if (var367 == 1608) {
							field188[var4++] = var82.field1824;
							continue;
						}
					} else if (var367 < 1800) {
						IfType var83 = var47 ? Statics.field1108 : Statics.field335;
						if (var367 == 1700) {
							field188[var4++] = var83.field1791;
							continue;
						}
						if (var367 == 1701) {
							if (var83.field1791 == -1) {
								field188[var4++] = 0;
							} else {
								field188[var4++] = var83.field1888;
							}
							continue;
						}
						if (var367 == 1702) {
							field188[var4++] = var83.field1823;
							continue;
						}
					} else if (var367 < 1900) {
						IfType var84 = var47 ? Statics.field1108 : Statics.field335;
						if (var367 == 1800) {
							field188[var4++] = WorldEntrySettings.method1350(Client.method1512(var84));
							continue;
						}
						if (var367 == 1801) {
							var4--;
							int var85 = field188[var4];
							int var368 = var85 - 1;
							if (var84.field1844 != null && var368 < var84.field1844.length && var84.field1844[var368] != null) {
								field194[var5++] = var84.field1844[var368];
								continue;
							}
							field194[var5++] = "";
							continue;
						}
						if (var367 == 1802) {
							if (var84.field1795 == null) {
								field194[var5++] = "";
							} else {
								field194[var5++] = var84.field1795;
							}
							continue;
						}
					} else if (var367 < 2600) {
						var4--;
						IfType var86 = IfType.method813(field188[var4]);
						if (var367 == 2500) {
							field188[var4++] = var86.field1788;
							continue;
						}
						if (var367 == 2501) {
							field188[var4++] = var86.field1810;
							continue;
						}
						if (var367 == 2502) {
							field188[var4++] = var86.field1792;
							continue;
						}
						if (var367 == 2503) {
							field188[var4++] = var86.field1793;
							continue;
						}
						if (var367 == 2504) {
							field188[var4++] = var86.field1880 ? 1 : 0;
							continue;
						}
						if (var367 == 2505) {
							field188[var4++] = var86.field1896;
							continue;
						}
					} else if (var367 < 2700) {
						var4--;
						IfType var87 = IfType.method813(field188[var4]);
						if (var367 == 2600) {
							field188[var4++] = var87.field1796;
							continue;
						}
						if (var367 == 2601) {
							field188[var4++] = var87.field1797;
							continue;
						}
						if (var367 == 2602) {
							field194[var5++] = var87.field1830;
							continue;
						}
						if (var367 == 2603) {
							field188[var4++] = var87.field1884;
							continue;
						}
						if (var367 == 2604) {
							field188[var4++] = var87.field1799;
							continue;
						}
						if (var367 == 2605) {
							field188[var4++] = var87.field1826;
							continue;
						}
						if (var367 == 2606) {
							field188[var4++] = var87.field1848;
							continue;
						}
						if (var367 == 2607) {
							field188[var4++] = var87.field1817;
							continue;
						}
						if (var367 == 2608) {
							field188[var4++] = var87.field1824;
							continue;
						}
					} else if (var367 < 2800) {
						if (var367 == 2700) {
							var4--;
							IfType var88 = IfType.method813(field188[var4]);
							field188[var4++] = var88.field1791;
							continue;
						}
						if (var367 == 2701) {
							var4--;
							IfType var89 = IfType.method813(field188[var4]);
							if (var89.field1791 == -1) {
								field188[var4++] = 0;
							} else {
								field188[var4++] = var89.field1888;
							}
							continue;
						}
						if (var367 == 2702) {
							var4--;
							int var90 = field188[var4];
							ComponentPointer var91 = (ComponentPointer) Client.field1918.method1277((long) var90);
							if (var91 == null) {
								field188[var4++] = 0;
							} else {
								field188[var4++] = 1;
							}
							continue;
						}
					} else if (var367 < 2900) {
						var4--;
						IfType var92 = IfType.method813(field188[var4]);
						if (var367 == 2800) {
							field188[var4++] = WorldEntrySettings.method1350(Client.method1512(var92));
							continue;
						}
						if (var367 == 2801) {
							var4--;
							int var93 = field188[var4];
							int var369 = var93 - 1;
							if (var92.field1844 != null && var369 < var92.field1844.length && var92.field1844[var369] != null) {
								field194[var5++] = var92.field1844[var369];
								continue;
							}
							field194[var5++] = "";
							continue;
						}
						if (var367 == 2802) {
							if (var92.field1795 == null) {
								field194[var5++] = "";
							} else {
								field194[var5++] = var92.field1795;
							}
							continue;
						}
					} else if (var367 < 3200) {
						if (var367 == 3100) {
							var5--;
							String var94 = field194[var5];
							Client.method559(0, "", var94);
							continue;
						}
						if (var367 == 3101) {
							var4 -= 2;
							Client.method1040(Statics.field1134, field188[var4], field188[var4 + 1]);
							continue;
						}
						if (var367 == 3103) {
							Client.field1949.pisaac1(129);
							for (ComponentPointer var95 = (ComponentPointer) Client.field1918.method1284(); var95 != null; var95 = (ComponentPointer) Client.field1918.method1280()) {
								if (var95.field1597 == 0 || var95.field1597 == 3) {
									Client.method408(var95, true);
								}
							}
							if (Client.field2087 != null) {
								Client.method1238(Client.field2087);
								Client.field2087 = null;
							}
							continue;
						}
						if (var367 == 3104) {
							var5--;
							String var96 = field194[var5];
							int var97 = 0;
							if (JStringUtil.method62(var96)) {
								int var98 = JStringUtil.method91(var96, 10, true);
								var97 = var98;
							}
							Client.field1949.pisaac1(27);
							Client.field1949.p4(var97);
							continue;
						}
						if (var367 == 3105) {
							var5--;
							String var99 = field194[var5];
							Client.field1949.pisaac1(223);
							Client.field1949.p1(var99.length() + 1);
							Client.field1949.pjstr(var99);
							continue;
						}
						if (var367 == 3106) {
							var5--;
							String var100 = field194[var5];
							Client.field1949.pisaac1(127);
							Client.field1949.p1(var100.length() + 1);
							Client.field1949.pjstr(var100);
							continue;
						}
						if (var367 == 3107) {
							var4--;
							int var101 = field188[var4];
							var5--;
							String var102 = field194[var5];
							Client.method558(var101, var102);
							continue;
						}
						if (var367 == 3108) {
							var4 -= 3;
							int var103 = field188[var4];
							int var104 = field188[var4 + 1];
							int var105 = field188[var4 + 2];
							IfType var106 = IfType.method813(var105);
							Client.method1102(var106, var103, var104);
							continue;
						}
						if (var367 == 3109) {
							var4 -= 2;
							int var107 = field188[var4];
							int var108 = field188[var4 + 1];
							IfType var109 = var47 ? Statics.field1108 : Statics.field335;
							Client.method1102(var109, var107, var108);
							continue;
						}
					} else if (var367 < 3300) {
						if (var367 == 3200) {
							var4 -= 3;
							int var110 = field188[var4];
							int var111 = field188[var4 + 1];
							int var112 = field188[var4 + 2];
							if (Client.field1952 != 0 && var111 != 0 && Client.field2176 < 50) {
								Client.field2177[Client.field2176] = var110;
								Client.field2006[Client.field2176] = var111;
								Client.field2179[Client.field2176] = var112;
								Client.field2181[Client.field2176] = null;
								Client.field2180[Client.field2176] = 0;
								Client.field2176++;
							}
							continue;
						}
						if (var367 == 3201) {
							var4--;
							Client.method1232(field188[var4]);
							continue;
						}
						if (var367 == 3202) {
							var4 -= 2;
							int var113 = field188[var4];
							int var10000 = field188[var4 + 1];
							if (Client.field2169 != 0 && var113 != -1) {
								MidiPlayer.method1125(Statics.field1515, var113, 0, Client.field2169, false);
								Client.field2189 = true;
							}
							continue;
						}
					} else if (var367 < 3400) {
						if (var367 == 3300) {
							field188[var4++] = Client.field1922;
							continue;
						}
						if (var367 == 3301) {
							var4 -= 2;
							int var115 = field188[var4];
							int var116 = field188[var4 + 1];
							int[] var117 = field188;
							int var118 = var4++;
							ClientInvCache var119 = (ClientInvCache) ClientInvCache.field1623.method1277((long) var115);
							int var120;
							if (var119 == null) {
								var120 = -1;
							} else if (var116 >= 0 && var116 < var119.field1622.length) {
								var120 = var119.field1622[var116];
							} else {
								var120 = -1;
							}
							var117[var118] = var120;
							continue;
						}
						if (var367 == 3302) {
							var4 -= 2;
							int var121 = field188[var4];
							int var122 = field188[var4 + 1];
							field188[var4++] = ClientInvCache.method5(var121, var122);
							continue;
						}
						if (var367 == 3303) {
							var4 -= 2;
							int var123 = field188[var4];
							int var124 = field188[var4 + 1];
							field188[var4++] = ClientInvCache.method1446(var123, var124);
							continue;
						}
						if (var367 == 3304) {
							var4--;
							int var125 = field188[var4];
							int[] var126 = field188;
							int var127 = var4++;
							InvType var128 = (InvType) InvType.field2475.method1244((long) var125);
							InvType var129;
							if (var128 == null) {
								byte[] var130 = Statics.field2476.method1044(5, var125);
								InvType var131 = new InvType();
								if (var130 != null) {
									var131.method2569(new Packet(var130));
								}
								InvType.field2475.method1246(var131, (long) var125);
								var129 = var131;
							} else {
								var129 = var128;
							}
							var126[var127] = var129.field2477;
							continue;
						}
						if (var367 == 3305) {
							var4--;
							int var132 = field188[var4];
							field188[var4++] = Client.field2060[var132];
							continue;
						}
						if (var367 == 3306) {
							var4--;
							int var133 = field188[var4];
							field188[var4++] = Client.field1960[var133];
							continue;
						}
						if (var367 == 3307) {
							var4--;
							int var134 = field188[var4];
							field188[var4++] = Client.field2062[var134];
							continue;
						}
						if (var367 == 3308) {
							int var135 = Statics.field534;
							int var136 = (Statics.field1134.field2615 >> 7) + Statics.field315;
							int var137 = (Statics.field1134.field2614 >> 7) + Statics.field653;
							field188[var4++] = (var135 << 28) + (var136 << 14) + var137;
							continue;
						}
						if (var367 == 3309) {
							var4--;
							int var138 = field188[var4];
							field188[var4++] = var138 >> 14 & 0x3FFF;
							continue;
						}
						if (var367 == 3310) {
							var4--;
							int var139 = field188[var4];
							field188[var4++] = var139 >> 28;
							continue;
						}
						if (var367 == 3311) {
							var4--;
							int var140 = field188[var4];
							field188[var4++] = var140 & 0x3FFF;
							continue;
						}
						if (var367 == 3312) {
							field188[var4++] = Client.field1983 ? 1 : 0;
							continue;
						}
						if (var367 == 3313) {
							var4 -= 2;
							int var141 = field188[var4] + 32768;
							int var142 = field188[var4 + 1];
							int[] var143 = field188;
							int var144 = var4++;
							ClientInvCache var145 = (ClientInvCache) ClientInvCache.field1623.method1277((long) var141);
							int var146;
							if (var145 == null) {
								var146 = -1;
							} else if (var142 >= 0 && var142 < var145.field1622.length) {
								var146 = var145.field1622[var142];
							} else {
								var146 = -1;
							}
							var143[var144] = var146;
							continue;
						}
						if (var367 == 3314) {
							var4 -= 2;
							int var147 = field188[var4] + 32768;
							int var148 = field188[var4 + 1];
							field188[var4++] = ClientInvCache.method5(var147, var148);
							continue;
						}
						if (var367 == 3315) {
							var4 -= 2;
							int var149 = field188[var4] + 32768;
							int var150 = field188[var4 + 1];
							field188[var4++] = ClientInvCache.method1446(var149, var150);
							continue;
						}
						if (var367 == 3316) {
							if (Client.field2049 >= 2) {
								field188[var4++] = Client.field2049;
							} else {
								field188[var4++] = 0;
							}
							continue;
						}
						if (var367 == 3317) {
							field188[var4++] = Client.field2010;
							continue;
						}
						if (var367 == 3318) {
							field188[var4++] = Client.field2075;
							continue;
						}
						if (var367 == 3321) {
							field188[var4++] = Client.field2080;
							continue;
						}
						if (var367 == 3322) {
							field188[var4++] = Client.field2089;
							continue;
						}
						if (var367 == 3323) {
							if (Client.field2091) {
								field188[var4++] = 1;
							} else {
								field188[var4++] = 0;
							}
							continue;
						}
					} else if (var367 < 3500) {
						if (var367 == 3400) {
							var4 -= 2;
							int var151 = field188[var4];
							int var152 = field188[var4 + 1];
							EnumType var153 = EnumType.method1844(var151);
							if (var153.field2424 != 's') {
							}
							for (int var154 = 0; var154 < var153.field2427; var154++) {
								if (var153.field2421[var154] == var152) {
									field194[var5++] = var153.field2430[var154];
									var153 = null;
									break;
								}
							}
							if (var153 != null) {
								field194[var5++] = var153.field2428;
							}
							continue;
						}
						if (var367 == 3408) {
							var4 -= 4;
							int var155 = field188[var4];
							int var156 = field188[var4 + 1];
							int var157 = field188[var4 + 2];
							int var158 = field188[var4 + 3];
							EnumType var159 = EnumType.method1844(var157);
							if (var159.field2423 == var155 && var159.field2424 == var156) {
								for (int var160 = 0; var160 < var159.field2427; var160++) {
									if (var159.field2421[var160] == var158) {
										if (var156 == 115) {
											field194[var5++] = var159.field2430[var160];
										} else {
											field188[var4++] = var159.field2429[var160];
										}
										var159 = null;
										break;
									}
								}
								if (var159 != null) {
									if (var156 == 115) {
										field194[var5++] = var159.field2428;
									} else {
										field188[var4++] = var159.field2426;
									}
								}
								continue;
							}
							if (var156 == 115) {
								field194[var5++] = "null";
							} else {
								field188[var4++] = 0;
							}
							continue;
						}
					} else if (var367 < 3700) {
						if (var367 == 3600) {
							if (Client.field2171 == 0) {
								field188[var4++] = -2;
							} else if (Client.field2171 == 1) {
								field188[var4++] = -1;
							} else {
								field188[var4++] = Client.field2071;
							}
							continue;
						}
						if (var367 == 3601) {
							var4--;
							int var161 = field188[var4];
							if (Client.field2171 == 2 && var161 < Client.field2071) {
								field194[var5++] = Client.field2111[var161].field173;
								continue;
							}
							field194[var5++] = "";
							continue;
						}
						if (var367 == 3602) {
							var4--;
							int var162 = field188[var4];
							if (Client.field2171 == 2 && var162 < Client.field2071) {
								field188[var4++] = Client.field2111[var162].field174;
								continue;
							}
							field188[var4++] = 0;
							continue;
						}
						if (var367 == 3603) {
							var4--;
							int var163 = field188[var4];
							if (Client.field2171 == 2 && var163 < Client.field2071) {
								field188[var4++] = Client.field2111[var163].field175;
								continue;
							}
							field188[var4++] = 0;
							continue;
						}
						if (var367 == 3604) {
							var5--;
							String var164 = field194[var5];
							var4--;
							int var165 = field188[var4];
							Client.field1949.pisaac1(252);
							Client.field1949.p1(Packet.pjstrlen(var164) + 1);
							Client.field1949.pjstr(var164);
							Client.field1949.p1_alt1(var165);
							continue;
						}
						if (var367 == 3605) {
							var5--;
							String var166 = field194[var5];
							Client.method1103(var166);
							continue;
						}
						if (var367 == 3606) {
							var5--;
							String var167 = field194[var5];
							Client.method560(var167);
							continue;
						}
						if (var367 == 3607) {
							var5--;
							String var168 = field194[var5];
							Client.method315(var168, false);
							continue;
						}
						if (var367 == 3608) {
							var5--;
							String var169 = field194[var5];
							if (var169 == null) {
								continue;
							}
							String var170 = NamespaceUtil.method743(var169, Client.namespace);
							if (var170 == null) {
								continue;
							}
							int var171 = 0;
							while (true) {
								if (var171 >= Client.field2194) {
									continue label2279;
								}
								IgnoreListEntry var172 = Client.field2196[var171];
								String var173 = var172.field40;
								String var174 = NamespaceUtil.method743(var173, Client.namespace);
								boolean var175;
								if (var169 == null || var173 == null) {
									var175 = false;
								} else if (var169.startsWith("#") || var173.startsWith("#")) {
									var175 = var169.equals(var173);
								} else {
									var175 = var170.equals(var174);
								}
								if (var175) {
									Client.field2194--;
									for (int var176 = var171; var176 < Client.field2194; var176++) {
										Client.field2196[var176] = Client.field2196[var176 + 1];
									}
									Client.field1977 = Client.field2117;
									Client.field1949.pisaac1(248);
									Client.field1949.p1(Packet.pjstrlen(var169));
									Client.field1949.pjstr(var169);
									continue label2279;
								}
								var171++;
							}
						}
						if (var367 == 3609) {
							var5--;
							String var177 = field194[var5];
							if (var177.startsWith(TextUtil.method63(0)) || var177.startsWith(TextUtil.method63(1))) {
								var177 = var177.substring(7);
							}
							field188[var4++] = Client.method785(var177) ? 1 : 0;
							continue;
						}
						if (var367 == 3611) {
							if (Client.field1955 == null) {
								field194[var5++] = "";
							} else {
								String[] var178 = field194;
								int var179 = var5++;
								String var180 = Client.field1955;
								String var181 = JString.method782(JString.method1001(var180));
								if (var181 == null) {
									var181 = "";
								}
								var178[var179] = var181;
							}
							continue;
						}
						if (var367 == 3612) {
							if (Client.field1955 == null) {
								field188[var4++] = 0;
							} else {
								field188[var4++] = Statics.field1220;
							}
							continue;
						}
						if (var367 == 3613) {
							var4--;
							int var183 = field188[var4];
							if (Client.field1955 != null && var183 < Statics.field1220) {
								field194[var5++] = Statics.field1774[var183].field1617;
								continue;
							}
							field194[var5++] = "";
							continue;
						}
						if (var367 == 3614) {
							var4--;
							int var184 = field188[var4];
							if (Client.field1955 != null && var184 < Statics.field1220) {
								field188[var4++] = Statics.field1774[var184].field1620;
								continue;
							}
							field188[var4++] = 0;
							continue;
						}
						if (var367 == 3615) {
							var4--;
							int var185 = field188[var4];
							if (Client.field1955 != null && var185 < Statics.field1220) {
								field188[var4++] = Statics.field1774[var185].field1619;
								continue;
							}
							field188[var4++] = 0;
							continue;
						}
						if (var367 == 3616) {
							field188[var4++] = Statics.field1511;
							continue;
						}
						if (var367 == 3617) {
							var5--;
							String var186 = field194[var5];
							if (Statics.field1774 != null) {
								Client.field1949.pisaac1(245);
								Client.field1949.p1(Packet.pjstrlen(var186));
								Client.field1949.pjstr(var186);
							}
							continue;
						}
						if (var367 == 3618) {
							field188[var4++] = Statics.field1217;
							continue;
						}
						if (var367 == 3619) {
							var5--;
							String var187 = field194[var5];
							Client.method742(var187);
							continue;
						}
						if (var367 == 3620) {
							Client.method388();
							continue;
						}
						if (var367 == 3621) {
							if (Client.field2171 == 0) {
								field188[var4++] = -1;
							} else {
								field188[var4++] = Client.field2194;
							}
							continue;
						}
						if (var367 == 3622) {
							var4--;
							int var188 = field188[var4];
							if (Client.field2171 != 0 && var188 < Client.field2194) {
								field194[var5++] = Client.field2196[var188].field40;
								continue;
							}
							field194[var5++] = "";
							continue;
						}
						if (var367 == 3623) {
							var5--;
							String var189 = field194[var5];
							if (var189.startsWith(TextUtil.method63(0)) || var189.startsWith(TextUtil.method63(1))) {
								var189 = var189.substring(7);
							}
							field188[var4++] = Client.method761(var189) ? 1 : 0;
							continue;
						}
						if (var367 == 3624) {
							var4--;
							int var190 = field188[var4];
							if (Statics.field1774 != null && var190 < Statics.field1220 && Statics.field1774[var190].field1617.equalsIgnoreCase(Statics.field1134.field2796)) {
								field188[var4++] = 1;
								continue;
							}
							field188[var4++] = 0;
							continue;
						}
						if (var367 == 3625) {
							if (Client.field2155 == null) {
								field194[var5++] = "";
							} else {
								String[] var191 = field194;
								int var192 = var5++;
								String var193 = Client.field2155;
								String var194 = JString.method782(JString.method1001(var193));
								if (var194 == null) {
									var194 = "";
								}
								var191[var192] = var194;
							}
							continue;
						}
					} else if (var367 < 4100) {
						if (var367 == 4000) {
							var4 -= 2;
							int var196 = field188[var4];
							int var197 = field188[var4 + 1];
							field188[var4++] = var196 + var197;
							continue;
						}
						if (var367 == 4001) {
							var4 -= 2;
							int var198 = field188[var4];
							int var199 = field188[var4 + 1];
							field188[var4++] = var198 - var199;
							continue;
						}
						if (var367 == 4002) {
							var4 -= 2;
							int var200 = field188[var4];
							int var201 = field188[var4 + 1];
							field188[var4++] = var200 * var201;
							continue;
						}
						if (var367 == 4003) {
							var4 -= 2;
							int var202 = field188[var4];
							int var203 = field188[var4 + 1];
							field188[var4++] = var202 / var203;
							continue;
						}
						if (var367 == 4004) {
							var4--;
							int var204 = field188[var4];
							field188[var4++] = (int) (Math.random() * (double) var204);
							continue;
						}
						if (var367 == 4005) {
							var4--;
							int var205 = field188[var4];
							field188[var4++] = (int) (Math.random() * (double) (var205 + 1));
							continue;
						}
						if (var367 == 4006) {
							var4 -= 5;
							int var206 = field188[var4];
							int var207 = field188[var4 + 1];
							int var208 = field188[var4 + 2];
							int var209 = field188[var4 + 3];
							int var210 = field188[var4 + 4];
							field188[var4++] = (var207 - var206) * (var210 - var208) / (var209 - var208) + var206;
							continue;
						}
						if (var367 == 4007) {
							var4 -= 2;
							int var211 = field188[var4];
							int var212 = field188[var4 + 1];
							field188[var4++] = var211 * var212 / 100 + var211;
							continue;
						}
						if (var367 == 4008) {
							var4 -= 2;
							int var213 = field188[var4];
							int var214 = field188[var4 + 1];
							field188[var4++] = var213 | 0x1 << var214;
							continue;
						}
						if (var367 == 4009) {
							var4 -= 2;
							int var215 = field188[var4];
							int var216 = field188[var4 + 1];
							field188[var4++] = var215 & -1 - (0x1 << var216);
							continue;
						}
						if (var367 == 4010) {
							var4 -= 2;
							int var217 = field188[var4];
							int var218 = field188[var4 + 1];
							field188[var4++] = (var217 & 0x1 << var218) == 0 ? 0 : 1;
							continue;
						}
						if (var367 == 4011) {
							var4 -= 2;
							int var219 = field188[var4];
							int var220 = field188[var4 + 1];
							field188[var4++] = var219 % var220;
							continue;
						}
						if (var367 == 4012) {
							var4 -= 2;
							int var221 = field188[var4];
							int var222 = field188[var4 + 1];
							if (var221 == 0) {
								field188[var4++] = 0;
							} else {
								field188[var4++] = (int) Math.pow((double) var221, (double) var222);
							}
							continue;
						}
						if (var367 == 4013) {
							var4 -= 2;
							int var223 = field188[var4];
							int var224 = field188[var4 + 1];
							if (var223 == 0) {
								field188[var4++] = 0;
							} else if (var224 == 0) {
								field188[var4++] = Integer.MAX_VALUE;
							} else {
								field188[var4++] = (int) Math.pow((double) var223, 1.0D / (double) var224);
							}
							continue;
						}
						if (var367 == 4014) {
							var4 -= 2;
							int var225 = field188[var4];
							int var226 = field188[var4 + 1];
							field188[var4++] = var225 & var226;
							continue;
						}
						if (var367 == 4015) {
							var4 -= 2;
							int var227 = field188[var4];
							int var228 = field188[var4 + 1];
							field188[var4++] = var227 | var228;
							continue;
						}
					} else if (var367 < 4200) {
						if (var367 == 4100) {
							var5--;
							String var229 = field194[var5];
							var4--;
							int var230 = field188[var4];
							field194[var5++] = var229 + var230;
							continue;
						}
						if (var367 == 4101) {
							var5 -= 2;
							String var231 = field194[var5];
							String var232 = field194[var5 + 1];
							field194[var5++] = var231 + var232;
							continue;
						}
						if (var367 == 4102) {
							var5--;
							String var233 = field194[var5];
							var4--;
							int var234 = field188[var4];
							field194[var5++] = var233 + JStringUtil.method903(var234, true);
							continue;
						}
						if (var367 == 4103) {
							var5--;
							String var235 = field194[var5];
							field194[var5++] = var235.toLowerCase();
							continue;
						}
						if (var367 == 4104) {
							var4--;
							int var236 = field188[var4];
							long var237 = ((long) var236 + 11745L) * 86400000L;
							field197.setTime(new Date(var237));
							int var239 = field197.get(5);
							int var240 = field197.get(2);
							int var241 = field197.get(1);
							field194[var5++] = var239 + "-" + field190[var240] + "-" + var241;
							continue;
						}
						if (var367 == 4105) {
							var5 -= 2;
							String var242 = field194[var5];
							String var243 = field194[var5 + 1];
							if (Statics.field1134.field2786 != null && Statics.field1134.field2786.field1222) {
								field194[var5++] = var243;
								continue;
							}
							field194[var5++] = var242;
							continue;
						}
						if (var367 == 4106) {
							var4--;
							int var244 = field188[var4];
							field194[var5++] = Integer.toString(var244);
							continue;
						}
						if (var367 == 4107) {
							var5 -= 2;
							int[] var245 = field188;
							int var246 = var4++;
							String var247 = field194[var5];
							String var248 = field194[var5 + 1];
							int var249 = Client.field2047;
							int var250 = var247.length();
							int var251 = var248.length();
							int var252 = 0;
							int var253 = 0;
							byte var254 = 0;
							byte var255 = 0;
							int var256;
							label2100: while (true) {
								if (var252 - var254 >= var250 && var253 - var255 >= var251) {
									int var267 = Math.min(var250, var251);
									for (int var268 = 0; var268 < var267; var268++) {
										char var271 = var247.charAt(var268);
										char var272 = var248.charAt(var268);
										if (var271 != var272 && Character.toUpperCase(var271) != Character.toUpperCase(var272)) {
											char var273 = Character.toLowerCase(var271);
											char var274 = Character.toLowerCase(var272);
											if (var273 != var274) {
												var256 = StringComparator.method1018(var273, var249) - StringComparator.method1018(var274, var249);
												break label2100;
											}
										}
									}
									int var275 = var250 - var251;
									if (var275 == 0) {
										for (int var276 = 0; var276 < var267; var276++) {
											char var277 = var247.charAt(var276);
											char var278 = var248.charAt(var276);
											if (var277 != var278) {
												var256 = StringComparator.method1018(var277, var249) - StringComparator.method1018(var278, var249);
												break label2100;
											}
										}
										var256 = 0;
									} else {
										var256 = var275;
									}
									break;
								}
								if (var252 - var254 >= var250) {
									var256 = -1;
									break;
								}
								if (var253 - var255 >= var251) {
									var256 = 1;
									break;
								}
								char var257;
								if (var254 == 0) {
									var257 = var247.charAt(var252++);
								} else {
									var257 = (char) var254;
									boolean var258 = false;
								}
								char var259;
								if (var255 == 0) {
									var259 = var248.charAt(var253++);
								} else {
									var259 = (char) var255;
									boolean var260 = false;
								}
								byte var261;
								if (var257 == 198) {
									var261 = 69;
								} else if (var257 == 230) {
									var261 = 101;
								} else if (var257 == 223) {
									var261 = 115;
								} else if (var257 == 338) {
									var261 = 69;
								} else if (var257 == 339) {
									var261 = 101;
								} else {
									var261 = 0;
								}
								var254 = var261;
								byte var262;
								if (var259 == 198) {
									var262 = 69;
								} else if (var259 == 230) {
									var262 = 101;
								} else if (var259 == 223) {
									var262 = 115;
								} else if (var259 == 338) {
									var262 = 69;
								} else if (var259 == 339) {
									var262 = 101;
								} else {
									var262 = 0;
								}
								var255 = var262;
								char var263 = StringComparator.method342(var257, var249);
								char var264 = StringComparator.method342(var259, var249);
								if (var263 != var264 && Character.toUpperCase(var263) != Character.toUpperCase(var264)) {
									char var265 = Character.toLowerCase(var263);
									char var266 = Character.toLowerCase(var264);
									if (var265 != var266) {
										var256 = StringComparator.method1018(var265, var249) - StringComparator.method1018(var266, var249);
										break;
									}
								}
							}
							byte var280;
							if (var256 > 0) {
								var280 = 1;
							} else if (var256 < 0) {
								var280 = -1;
							} else {
								var280 = 0;
							}
							var245[var246] = var280;
							continue;
						}
						if (var367 == 4108) {
							var5--;
							String var281 = field194[var5];
							var4 -= 2;
							int var282 = field188[var4];
							int var283 = field188[var4 + 1];
							byte[] var284 = Statics.field1150.method1044(var283, 0);
							SoftwareFont var285 = new SoftwareFont(var284);
							field188[var4++] = var285.method2889(var281, var282);
							continue;
						}
						if (var367 == 4109) {
							var5--;
							String var286 = field194[var5];
							var4 -= 2;
							int var287 = field188[var4];
							int var288 = field188[var4 + 1];
							byte[] var289 = Statics.field1150.method1044(var288, 0);
							SoftwareFont var290 = new SoftwareFont(var289);
							field188[var4++] = var290.method2818(var286, var287);
							continue;
						}
						if (var367 == 4110) {
							var5 -= 2;
							String var291 = field194[var5];
							String var292 = field194[var5 + 1];
							var4--;
							if (field188[var4] == 1) {
								field194[var5++] = var291;
							} else {
								field194[var5++] = var292;
							}
							continue;
						}
						if (var367 == 4111) {
							var5--;
							String var293 = field194[var5];
							field194[var5++] = PixFont.method2844(var293);
							continue;
						}
						if (var367 == 4112) {
							var5--;
							String var294 = field194[var5];
							var4--;
							int var295 = field188[var4];
							field194[var5++] = var294 + (char) var295;
							continue;
						}
						if (var367 == 4113) {
							var4--;
							int var296 = field188[var4];
							int[] var297 = field188;
							int var298 = var4++;
							char var299 = (char) var296;
							boolean var300;
							if (var299 >= ' ' && var299 <= '~') {
								var300 = true;
							} else if (var299 >= 160 && var299 <= 255) {
								var300 = true;
							} else if (var299 == 8364 || var299 == 338 || var299 == 8212 || var299 == 339 || var299 == 376) {
								var300 = true;
							} else {
								var300 = false;
							}
							var297[var298] = var300 ? 1 : 0;
							continue;
						}
						if (var367 == 4114) {
							var4--;
							int var301 = field188[var4];
							int[] var302 = field188;
							int var303 = var4++;
							char var304 = (char) var301;
							boolean var305 = var304 >= '0' && var304 <= '9' || var304 >= 'A' && var304 <= 'Z' || var304 >= 'a' && var304 <= 'z';
							var302[var303] = var305 ? 1 : 0;
							continue;
						}
						if (var367 == 4115) {
							var4--;
							int var306 = field188[var4];
							field188[var4++] = JStringUtil.method1124((char) var306) ? 1 : 0;
							continue;
						}
						if (var367 == 4116) {
							var4--;
							int var307 = field188[var4];
							int[] var308 = field188;
							int var309 = var4++;
							char var310 = (char) var307;
							boolean var311 = var310 >= '0' && var310 <= '9';
							var308[var309] = var311 ? 1 : 0;
							continue;
						}
						if (var367 == 4117) {
							var5--;
							String var312 = field194[var5];
							if (var312 == null) {
								field188[var4++] = 0;
							} else {
								field188[var4++] = var312.length();
							}
							continue;
						}
						if (var367 == 4118) {
							var5--;
							String var313 = field194[var5];
							var4 -= 2;
							int var314 = field188[var4];
							int var315 = field188[var4 + 1];
							field194[var5++] = var313.substring(var314, var315);
							continue;
						}
						if (var367 == 4119) {
							var5--;
							String var316 = field194[var5];
							StringBuilder var317 = new StringBuilder(var316.length());
							boolean var318 = false;
							for (int var319 = 0; var319 < var316.length(); var319++) {
								char var320 = var316.charAt(var319);
								if (var320 == '<') {
									var318 = true;
								} else if (var320 == '>') {
									var318 = false;
								} else if (!var318) {
									var317.append(var320);
								}
							}
							field194[var5++] = var317.toString();
							continue;
						}
						if (var367 == 4120) {
							var5--;
							String var321 = field194[var5];
							var4--;
							int var322 = field188[var4];
							field188[var4++] = var321.indexOf(var322);
							continue;
						}
					} else if (var367 < 4300) {
						if (var367 == 4200) {
							var4--;
							int var323 = field188[var4];
							field194[var5++] = ObjType.method927(var323).field2461;
							continue;
						}
						if (var367 == 4201) {
							var4 -= 2;
							int var324 = field188[var4];
							int var325 = field188[var4 + 1];
							ObjType var326 = ObjType.method927(var324);
							if (var325 >= 1 && var325 <= 5 && var326.field2451[var325 - 1] != null) {
								field194[var5++] = var326.field2451[var325 - 1];
								continue;
							}
							field194[var5++] = "";
							continue;
						}
						if (var367 == 4202) {
							var4 -= 2;
							int var327 = field188[var4];
							int var328 = field188[var4 + 1];
							ObjType var329 = ObjType.method927(var327);
							if (var328 >= 1 && var328 <= 5 && var329.field2452[var328 - 1] != null) {
								field194[var5++] = var329.field2452[var328 - 1];
								continue;
							}
							field194[var5++] = "";
							continue;
						}
						if (var367 == 4203) {
							var4--;
							int var330 = field188[var4];
							field188[var4++] = ObjType.method927(var330).field2470;
							continue;
						}
						if (var367 == 4204) {
							var4--;
							int var331 = field188[var4];
							field188[var4++] = ObjType.method927(var331).field2448 == 1 ? 1 : 0;
							continue;
						}
						if (var367 == 4205) {
							var4--;
							int var332 = field188[var4];
							ObjType var333 = ObjType.method927(var332);
							if (var333.field2450 == -1 && var333.field2459 >= 0) {
								field188[var4++] = var333.field2459;
								continue;
							}
							field188[var4++] = var332;
							continue;
						}
						if (var367 == 4206) {
							var4--;
							int var334 = field188[var4];
							ObjType var335 = ObjType.method927(var334);
							if (var335.field2450 >= 0 && var335.field2459 >= 0) {
								field188[var4++] = var335.field2459;
								continue;
							}
							field188[var4++] = var334;
							continue;
						}
						if (var367 == 4207) {
							var4--;
							int var336 = field188[var4];
							field188[var4++] = ObjType.method927(var336).field2457 ? 1 : 0;
							continue;
						}
					} else if (var367 < 5100) {
						if (var367 == 5000) {
							field188[var4++] = Client.field2145;
							continue;
						}
						if (var367 == 5001) {
							var4 -= 3;
							Client.field2145 = field188[var4];
							int var337 = field188[var4 + 1];
							ChatFilterPrivacy[] var338 = ChatFilterPrivacy.method907();
							int var339 = 0;
							ChatFilterPrivacy var341;
							while (true) {
								if (var339 >= var338.length) {
									var341 = null;
									break;
								}
								ChatFilterPrivacy var340 = var338[var339];
								if (var340.field1107 == var337) {
									var341 = var340;
									break;
								}
								var339++;
							}
							Statics.field680 = var341;
							if (Statics.field680 == null) {
								Statics.field680 = ChatFilterPrivacy.field1106;
							}
							Client.field2146 = field188[var4 + 2];
							Client.field1949.pisaac1(167);
							Client.field1949.p1(Client.field2145);
							Client.field1949.p1(Statics.field680.field1107);
							Client.field1949.p1(Client.field2146);
							continue;
						}
						if (var367 == 5002) {
							var5--;
							String var342 = field194[var5];
							var4 -= 2;
							int var343 = field188[var4];
							int var344 = field188[var4 + 1];
							Client.field1949.pisaac1(96);
							Client.field1949.p1(Packet.pjstrlen(var342) + 2);
							Client.field1949.pjstr(var342);
							Client.field1949.p1(var343 - 1);
							Client.field1949.p1(var344);
							continue;
						}
						if (var367 == 5003) {
							var4--;
							int var345 = field188[var4];
							String var346 = null;
							if (var345 < 100) {
								var346 = Client.field2142[var345];
							}
							if (var346 == null) {
								var346 = "";
							}
							field194[var5++] = var346;
							continue;
						}
						if (var367 == 5004) {
							var4--;
							int var347 = field188[var4];
							int var348 = -1;
							if (var347 < 100 && Client.field2142[var347] != null) {
								var348 = Client.field2139[var347];
							}
							field188[var4++] = var348;
							continue;
						}
						if (var367 == 5005) {
							if (Statics.field680 == null) {
								field188[var4++] = -1;
							} else {
								field188[var4++] = Statics.field680.field1107;
							}
							continue;
						}
						if (var367 == 5008) {
							var5--;
							String var349 = field194[var5];
							if (var349.startsWith("::")) {
								Client.method1790(var349);
							} else {
								String var350 = var349.toLowerCase();
								byte var351 = 0;
								if (var350.startsWith(EnglishLocale.field1031)) {
									var351 = 0;
									var349 = var349.substring(EnglishLocale.field1031.length());
								} else if (var350.startsWith(EnglishLocale.field1033)) {
									var351 = 1;
									var349 = var349.substring(EnglishLocale.field1033.length());
								} else if (var350.startsWith(EnglishLocale.field1035)) {
									var351 = 2;
									var349 = var349.substring(EnglishLocale.field1035.length());
								} else if (var350.startsWith(EnglishLocale.field1083)) {
									var351 = 3;
									var349 = var349.substring(EnglishLocale.field1083.length());
								} else if (var350.startsWith(EnglishLocale.field1039)) {
									var351 = 4;
									var349 = var349.substring(EnglishLocale.field1039.length());
								} else if (var350.startsWith(EnglishLocale.field1041)) {
									var351 = 5;
									var349 = var349.substring(EnglishLocale.field1041.length());
								} else if (var350.startsWith(EnglishLocale.field954)) {
									var351 = 6;
									var349 = var349.substring(EnglishLocale.field954.length());
								} else if (var350.startsWith(EnglishLocale.field977)) {
									var351 = 7;
									var349 = var349.substring(EnglishLocale.field977.length());
								} else if (var350.startsWith(EnglishLocale.field1047)) {
									var351 = 8;
									var349 = var349.substring(EnglishLocale.field1047.length());
								} else if (var350.startsWith(EnglishLocale.field1023)) {
									var351 = 9;
									var349 = var349.substring(EnglishLocale.field1023.length());
								} else if (var350.startsWith(EnglishLocale.field1008)) {
									var351 = 10;
									var349 = var349.substring(EnglishLocale.field1008.length());
								} else if (var350.startsWith(EnglishLocale.field1053)) {
									var351 = 11;
									var349 = var349.substring(EnglishLocale.field1053.length());
								} else if (Client.field2047 != 0) {
									if (var350.startsWith(EnglishLocale.field1032)) {
										var351 = 0;
										var349 = var349.substring(EnglishLocale.field1032.length());
									} else if (var350.startsWith(EnglishLocale.field1034)) {
										var351 = 1;
										var349 = var349.substring(EnglishLocale.field1034.length());
									} else if (var350.startsWith(EnglishLocale.field1036)) {
										var351 = 2;
										var349 = var349.substring(EnglishLocale.field1036.length());
									} else if (var350.startsWith(EnglishLocale.field1038)) {
										var351 = 3;
										var349 = var349.substring(EnglishLocale.field1038.length());
									} else if (var350.startsWith(EnglishLocale.field1040)) {
										var351 = 4;
										var349 = var349.substring(EnglishLocale.field1040.length());
									} else if (var350.startsWith(EnglishLocale.field1042)) {
										var351 = 5;
										var349 = var349.substring(EnglishLocale.field1042.length());
									} else if (var350.startsWith(EnglishLocale.field919)) {
										var351 = 6;
										var349 = var349.substring(EnglishLocale.field919.length());
									} else if (var350.startsWith(EnglishLocale.field1046)) {
										var351 = 7;
										var349 = var349.substring(EnglishLocale.field1046.length());
									} else if (var350.startsWith(EnglishLocale.field1048)) {
										var351 = 8;
										var349 = var349.substring(EnglishLocale.field1048.length());
									} else if (var350.startsWith(EnglishLocale.field1050)) {
										var351 = 9;
										var349 = var349.substring(EnglishLocale.field1050.length());
									} else if (var350.startsWith(EnglishLocale.field896)) {
										var351 = 10;
										var349 = var349.substring(EnglishLocale.field896.length());
									} else if (var350.startsWith(EnglishLocale.field1054)) {
										var351 = 11;
										var349 = var349.substring(EnglishLocale.field1054.length());
									}
								}
								String var352 = var349.toLowerCase();
								byte var353 = 0;
								if (var352.startsWith(EnglishLocale.field1055)) {
									var353 = 1;
									var349 = var349.substring(EnglishLocale.field1055.length());
								} else if (var352.startsWith(EnglishLocale.field1057)) {
									var353 = 2;
									var349 = var349.substring(EnglishLocale.field1057.length());
								} else if (var352.startsWith(EnglishLocale.field1059)) {
									var353 = 3;
									var349 = var349.substring(EnglishLocale.field1059.length());
								} else if (var352.startsWith(EnglishLocale.field895)) {
									var353 = 4;
									var349 = var349.substring(EnglishLocale.field895.length());
								} else if (var352.startsWith(EnglishLocale.field1063)) {
									var353 = 5;
									var349 = var349.substring(EnglishLocale.field1063.length());
								} else if (Client.field2047 != 0) {
									if (var352.startsWith(EnglishLocale.field959)) {
										var353 = 1;
										var349 = var349.substring(EnglishLocale.field959.length());
									} else if (var352.startsWith(EnglishLocale.field1058)) {
										var353 = 2;
										var349 = var349.substring(EnglishLocale.field1058.length());
									} else if (var352.startsWith(EnglishLocale.field1060)) {
										var353 = 3;
										var349 = var349.substring(EnglishLocale.field1060.length());
									} else if (var352.startsWith(EnglishLocale.field907)) {
										var353 = 4;
										var349 = var349.substring(EnglishLocale.field907.length());
									} else if (var352.startsWith(EnglishLocale.field878)) {
										var353 = 5;
										var349 = var349.substring(EnglishLocale.field878.length());
									}
								}
								Client.field1949.pisaac1(205);
								Client.field1949.p1(0);
								int var354 = Client.field1949.pos;
								Client.field1949.p1(var351);
								Client.field1949.p1(var353);
								WordPack.method911(Client.field1949, var349);
								Client.field1949.psize1(Client.field1949.pos - var354);
							}
							continue;
						}
						if (var367 == 5009) {
							var5 -= 2;
							String var355 = field194[var5];
							String var356 = field194[var5 + 1];
							Client.field1949.pisaac1(211);
							Client.field1949.p2(0);
							int var357 = Client.field1949.pos;
							Client.field1949.pjstr(var355);
							WordPack.method911(Client.field1949, var356);
							Client.field1949.psize2(Client.field1949.pos - var357);
							continue;
						}
						if (var367 == 5010) {
							var4--;
							int var358 = field188[var4];
							String var359 = null;
							if (var358 < 100) {
								var359 = Client.field2046[var358];
							}
							if (var359 == null) {
								var359 = "";
							}
							field194[var5++] = var359;
							continue;
						}
						if (var367 == 5011) {
							var4--;
							int var360 = field188[var4];
							String var361 = null;
							if (var360 < 100) {
								var361 = Client.field2173[var360];
							}
							if (var361 == null) {
								var361 = "";
							}
							field194[var5++] = var361;
							continue;
						}
						if (var367 == 5015) {
							String var362;
							if (Statics.field1134 == null || Statics.field1134.field2796 == null) {
								var362 = "";
							} else {
								var362 = Statics.field1134.field2796;
							}
							field194[var5++] = var362;
							continue;
						}
						if (var367 == 5016) {
							field188[var4++] = Client.field2146;
							continue;
						}
						if (var367 == 5017) {
							field188[var4++] = Client.field2141;
							continue;
						}
					}
				}
				throw new IllegalStateException();
			}
		} catch (Exception var366) {
			StringBuilder var364 = new StringBuilder(30);
			var364.append("").append(var3.field1506).append(" ");
			for (int var365 = field195 - 1; var365 >= 0; var365--) {
				var364.append("").append(field196[var365].field122.field1506).append(" ");
			}
			var364.append("").append(var9);
			JagException.method1490(var364.toString(), var366);
		}
	}

	@ObfuscatedName("r.d(II)V")
	public static void method6(int arg0) {
		if (arg0 == -1 || !IfType.method1501(arg0)) {
			return;
		}
		IfType[] var1 = Statics.field373[arg0];
		for (int var2 = 0; var2 < var1.length; var2++) {
			IfType var3 = var1[var2];
			if (var3.field1775 != null) {
				HookRequest var4 = new HookRequest();
				var4.field1590 = var3;
				var4.field1588 = var3.field1775;
				method777(var4);
			}
		}
	}
}
