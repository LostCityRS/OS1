package jagex2.client;

import deob.ObfuscatedName;
import jagex2.config.*;
import jagex2.datastruct.JStringUtil;
import jagex2.datastruct.StringComparator;
import jagex2.datastruct.TextUtil;
import jagex2.graphics.PixFont;
import jagex2.graphics.SoftwareFont;
import jagex2.io.Packet;
import jagex2.jstring.Locale;
import jagex2.jstring.JString;
import jagex2.sound.MidiPlayer;
import jagex2.wordenc.WordPack;

import java.util.Calendar;
import java.util.Date;

@ObfuscatedName("s")
public class ScriptRunner {

	@ObfuscatedName("s.d")
	public static int[] intLocals;

	@ObfuscatedName("s.l")
	public static String[] stringLocals;

	@ObfuscatedName("s.m")
	public static int[] field193 = new int[5];

	@ObfuscatedName("s.c")
	public static int[][] field192 = new int[5][5000];

	@ObfuscatedName("s.n")
	public static int[] field188 = new int[1000];

	@ObfuscatedName("s.j")
	public static String[] chatTyped = new String[1000];

	@ObfuscatedName("s.z")
	public static int field195 = 0;

	@ObfuscatedName("s.g")
	public static GoSubFrame[] field196 = new GoSubFrame[50];

	@ObfuscatedName("p.q")
	public static IfType activeComponent;

	@ObfuscatedName("bb.i")
	public static IfType activeComponent2;

	@ObfuscatedName("s.s")
	public static Calendar field197 = Calendar.getInstance();

	@ObfuscatedName("s.u")
	public static final String[] field190 = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

	public ScriptRunner() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("bv.r(Ldu;B)V")
	public static void runHook(HookRequest req) {
		Object[] var1 = req.field1588;
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
			intLocals = new int[var3.field2263];
			int var10 = 0;
			stringLocals = new String[var3.field2265];
			int var11 = 0;
			for (int var12 = 1; var12 < var1.length; var12++) {
				if (var1[var12] instanceof Integer) {
					int var13 = (Integer) var1[var12];
					if (var13 == 0x80000001) {
						var13 = req.field1589;
					}
					if (var13 == 0x80000002) {
						var13 = req.field1587;
					}
					if (var13 == 0x80000003) {
						var13 = req.component == null ? -1 : req.component.field1783;
					}
					if (var13 == 0x80000004) {
						var13 = req.field1591;
					}
					if (var13 == 0x80000005) {
						var13 = req.component == null ? -1 : req.component.subid;
					}
					if (var13 == 0x80000006) {
						var13 = req.field1592 == null ? -1 : req.field1592.field1783;
					}
					if (var13 == 0x80000007) {
						var13 = req.field1592 == null ? -1 : req.field1592.subid;
					}
					if (var13 == 0x80000008) {
						var13 = req.field1593;
					}
					if (var13 == 0x80000009) {
						var13 = req.field1594;
					}
					intLocals[var10++] = var13;
				} else if (var1[var12] instanceof String) {
					String var14 = (String) var1[var12];
					if (var14.equals("event_opbase")) {
						var14 = req.field1595;
					}
					stringLocals[var11++] = var14;
				}
			}
			int var15 = 0;
			label2277: while (true) {
				var15++;
				if (var15 > 200000) {
					throw new RuntimeException();
				}
				var6++;
				int opcode = var7[var6];
				if (opcode < 100) {
					if (opcode == 0) {
						field188[var4++] = var8[var6];
						continue;
					}
					if (opcode == 1) {
						int var16 = var8[var6];
						field188[var4++] = VarProvider.field1210[var16];
						continue;
					}
					if (opcode == 2) {
						int var17 = var8[var6];
						var4--;
						VarProvider.field1210[var17] = field188[var4];
						continue;
					}
					if (opcode == 3) {
						chatTyped[var5++] = var3.field2264[var6];
						continue;
					}
					if (opcode == 6) {
						var6 += var8[var6];
						continue;
					}
					if (opcode == 7) {
						var4 -= 2;
						if (field188[var4 + 1] != field188[var4]) {
							var6 += var8[var6];
						}
						continue;
					}
					if (opcode == 8) {
						var4 -= 2;
						if (field188[var4 + 1] == field188[var4]) {
							var6 += var8[var6];
						}
						continue;
					}
					if (opcode == 9) {
						var4 -= 2;
						if (field188[var4] < field188[var4 + 1]) {
							var6 += var8[var6];
						}
						continue;
					}
					if (opcode == 10) {
						var4 -= 2;
						if (field188[var4] > field188[var4 + 1]) {
							var6 += var8[var6];
						}
						continue;
					}
					if (opcode == 21) {
						if (field195 == 0) {
							return;
						}
						GoSubFrame var18 = field196[--field195];
						var3 = var18.script;
						var7 = var3.field2261;
						var8 = var3.field2260;
						var6 = var18.pc;
						intLocals = var18.intLocals;
						stringLocals = var18.stringLocals;
						continue;
					}
					if (opcode == 25) {
						int var19 = var8[var6];
						field188[var4++] = VarProvider.method1130(var19);
						continue;
					}
					if (opcode == 27) {
						int var20 = var8[var6];
						var4--;
						int var21 = field188[var4];
						VarBitType var22 = VarBitType.get(var20);
						int var23 = var22.basevar;
						int var24 = var22.startbit;
						int var25 = var22.endbit;
						int var26 = VarProvider.field1212[var25 - var24];
						if (var21 < 0 || var21 > var26) {
							var21 = 0;
						}
						int var27 = var26 << var24;
						VarProvider.field1210[var23] = VarProvider.field1210[var23] & ~var27 | var21 << var24 & var27;
						continue;
					}
					if (opcode == 31) {
						var4 -= 2;
						if (field188[var4] <= field188[var4 + 1]) {
							var6 += var8[var6];
						}
						continue;
					}
					if (opcode == 32) {
						var4 -= 2;
						if (field188[var4] >= field188[var4 + 1]) {
							var6 += var8[var6];
						}
						continue;
					}
					if (opcode == 33) {
						field188[var4++] = intLocals[var8[var6]];
						continue;
					}
					int var10001;
					if (opcode == 34) {
						var10001 = var8[var6];
						var4--;
						intLocals[var10001] = field188[var4];
						continue;
					}
					if (opcode == 35) {
						chatTyped[var5++] = stringLocals[var8[var6]];
						continue;
					}
					if (opcode == 36) {
						var10001 = var8[var6];
						var5--;
						stringLocals[var10001] = chatTyped[var5];
						continue;
					}
					if (opcode == 37) {
						int var28 = var8[var6];
						var5 -= var28;
						String var29 = JStringUtil.method1785(chatTyped, var5, var28);
						chatTyped[var5++] = var29;
						continue;
					}
					if (opcode == 38) {
						var4--;
						continue;
					}
					if (opcode == 39) {
						var5--;
						continue;
					}
					if (opcode == 40) {
						int var30 = var8[var6];
						ClientScript var31 = ClientScript.method872(var30);
						int[] var32 = new int[var31.field2263];
						String[] var33 = new String[var31.field2265];
						for (int var34 = 0; var34 < var31.field2266; var34++) {
							var32[var34] = field188[var4 - var31.field2266 + var34];
						}
						for (int var35 = 0; var35 < var31.field2267; var35++) {
							var33[var35] = chatTyped[var5 - var31.field2267 + var35];
						}
						var4 -= var31.field2266;
						var5 -= var31.field2267;
						GoSubFrame var36 = new GoSubFrame();
						var36.script = var3;
						var36.pc = var6;
						var36.intLocals = intLocals;
						var36.stringLocals = stringLocals;
						field196[++field195 - 1] = var36;
						var3 = var31;
						var7 = var31.field2261;
						var8 = var31.field2260;
						var6 = -1;
						intLocals = var32;
						stringLocals = var33;
						continue;
					}
					if (opcode == 42) {
						field188[var4++] = Client.field2120[var8[var6]];
						continue;
					}
					if (opcode == 43) {
						var10001 = var8[var6];
						var4--;
						Client.field2120[var10001] = field188[var4];
						continue;
					}
					if (opcode == 44) {
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
									continue label2277;
								}
								field192[var37][var41] = var40;
								var41++;
							}
						}
						throw new RuntimeException();
					}
					if (opcode == 45) {
						int var42 = var8[var6];
						var4--;
						int var43 = field188[var4];
						if (var43 >= 0 && var43 < field193[var42]) {
							field188[var4++] = field192[var42][var43];
							continue;
						}
						throw new RuntimeException();
					}
					if (opcode == 46) {
						int var44 = var8[var6];
						var4 -= 2;
						int var45 = field188[var4];
						if (var45 >= 0 && var45 < field193[var44]) {
							field192[var44][var45] = field188[var4 + 1];
							continue;
						}
						throw new RuntimeException();
					}
					if (opcode == 47) {
						String var46 = Client.field1996[var8[var6]];
						if (var46 == null) {
							var46 = "null";
						}
						chatTyped[var5++] = var46;
						continue;
					}
					if (opcode == 48) {
						var10001 = var8[var6];
						var5--;
						Client.field1996[var10001] = chatTyped[var5];
						continue;
					}
				}
				boolean var47;
				if (var8[var6] == 1) {
					var47 = true;
				} else {
					var47 = false;
				}
				if (opcode < 1000) {
					if (opcode == 100) {
						var4 -= 3;
						int var48 = field188[var4];
						int var49 = field188[var4 + 1];
						int var50 = field188[var4 + 2];
						if (var49 == 0) {
							throw new RuntimeException();
						}
						IfType var51 = IfType.get(var48);
						if (var51.subcomponents == null) {
							var51.subcomponents = new IfType[var50 + 1];
						}
						if (var51.subcomponents.length <= var50) {
							IfType[] var52 = new IfType[var50 + 1];
							for (int var53 = 0; var53 < var51.subcomponents.length; var53++) {
								var52[var53] = var51.subcomponents[var53];
							}
							var51.subcomponents = var52;
						}
						if (var50 > 0 && var51.subcomponents[var50 - 1] == null) {
							throw new RuntimeException("" + (var50 - 1));
						}
						IfType var54 = new IfType();
						var54.type = var49;
						var54.layerid = var54.field1783 = var51.field1783;
						var54.subid = var50;
						var54.if3 = true;
						var51.subcomponents[var50] = var54;
						if (var47) {
							activeComponent2 = var54;
						} else {
							activeComponent = var54;
						}
						Client.method1238(var51);
						continue;
					}
					if (opcode == 101) {
						IfType var55 = var47 ? activeComponent2 : activeComponent;
						IfType var56 = IfType.get(var55.field1783);
						var56.subcomponents[var55.subid] = null;
						Client.method1238(var56);
						continue;
					}
					if (opcode == 102) {
						var4--;
						IfType var57 = IfType.get(field188[var4]);
						var57.subcomponents = null;
						Client.method1238(var57);
						continue;
					}
					if (opcode == 200) {
						var4 -= 2;
						int var58 = field188[var4];
						int var59 = field188[var4 + 1];
						IfType var60 = IfType.method947(var58, var59);
						if (var60 != null && var59 != -1) {
							field188[var4++] = 1;
							if (var47) {
								activeComponent2 = var60;
							} else {
								activeComponent = var60;
							}
							continue;
						}
						field188[var4++] = 0;
						continue;
					}
				} else if (opcode >= 1000 && opcode < 1100 || !(opcode < 2000 || opcode >= 2100)) {
					IfType var61;
					if (opcode >= 2000) {
						opcode -= 1000;
						var4--;
						var61 = IfType.get(field188[var4]);
					} else {
						var61 = var47 ? activeComponent2 : activeComponent;
					}
					if (opcode == 1000) {
						var4 -= 2;
						var61.field1788 = field188[var4];
						var61.field1810 = field188[var4 + 1];
						Client.method1238(var61);
						continue;
					}
					if (opcode == 1001) {
						var4 -= 2;
						var61.width = field188[var4];
						var61.height = field188[var4 + 1];
						Client.method1238(var61);
						continue;
					}
					if (opcode == 1003) {
						var4--;
						boolean var62 = field188[var4] == 1;
						if (var61.hide != var62) {
							var61.hide = var62;
							Client.method1238(var61);
						}
						continue;
					}
				} else if (opcode >= 1100 && opcode < 1200 || !(opcode < 2100 || opcode >= 2200)) {
					IfType var63;
					if (opcode >= 2000) {
						opcode -= 1000;
						var4--;
						var63 = IfType.get(field188[var4]);
					} else {
						var63 = var47 ? activeComponent2 : activeComponent;
					}
					if (opcode == 1100) {
						var4 -= 2;
						var63.field1796 = field188[var4];
						if (var63.field1796 > var63.field1884 - var63.width) {
							var63.field1796 = var63.field1884 - var63.width;
						}
						if (var63.field1796 < 0) {
							var63.field1796 = 0;
						}
						var63.field1797 = field188[var4 + 1];
						if (var63.field1797 > var63.scroll - var63.height) {
							var63.field1797 = var63.scroll - var63.height;
						}
						if (var63.field1797 < 0) {
							var63.field1797 = 0;
						}
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1101) {
						var4--;
						var63.colour = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1102) {
						var4--;
						var63.fill = field188[var4] == 1;
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1103) {
						var4--;
						var63.alpha = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1104) {
						var4--;
						var63.field1804 = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1105) {
						var4--;
						var63.graphic = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1106) {
						var4--;
						var63.field1784 = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1107) {
						var4--;
						var63.field1794 = field188[var4] == 1;
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1108) {
						var63.modelType = 1;
						var4--;
						var63.model = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1109) {
						var4 -= 6;
						var63.field1821 = field188[var4];
						var63.field1798 = field188[var4 + 1];
						var63.xan = field188[var4 + 2];
						var63.yan = field188[var4 + 3];
						var63.field1817 = field188[var4 + 4];
						var63.zoom = field188[var4 + 5];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1110) {
						var4--;
						int var64 = field188[var4];
						if (var63.anim != var64) {
							var63.anim = var64;
							var63.field1779 = 0;
							var63.field1890 = 0;
							Client.method1238(var63);
						}
						continue;
					}
					if (opcode == 1111) {
						var4--;
						var63.field1828 = field188[var4] == 1;
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1112) {
						var5--;
						String var65 = chatTyped[var5];
						if (!var65.equals(var63.text)) {
							var63.text = var65;
							Client.method1238(var63);
						}
						continue;
					}
					if (opcode == 1113) {
						var4--;
						var63.font = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1114) {
						var4 -= 3;
						var63.center = field188[var4];
						var63.field1834 = field188[var4 + 1];
						var63.field1832 = field188[var4 + 2];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1115) {
						var4--;
						var63.shadowed = field188[var4] == 1;
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1116) {
						var4--;
						var63.field1811 = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1117) {
						var4--;
						var63.field1812 = field188[var4];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1118) {
						var4--;
						var63.field1849 = field188[var4] == 1;
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1119) {
						var4--;
						var63.field1814 = field188[var4] == 1;
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1120) {
						var4 -= 2;
						var63.field1884 = field188[var4];
						var63.scroll = field188[var4 + 1];
						Client.method1238(var63);
						continue;
					}
				} else if (opcode >= 1200 && opcode < 1300 || !(opcode < 2200 || opcode >= 2300)) {
					IfType var66;
					if (opcode >= 2000) {
						opcode -= 1000;
						var4--;
						var66 = IfType.get(field188[var4]);
					} else {
						var66 = var47 ? activeComponent2 : activeComponent;
					}
					Client.method1238(var66);
					if (opcode == 1200) {
						var4 -= 2;
						int var67 = field188[var4];
						int var68 = field188[var4 + 1];
						var66.field1791 = var67;
						var66.field1888 = var68;
						ObjType var69 = ObjType.get(var67);
						var66.xan = var69.xan2d;
						var66.yan = var69.yan2d;
						var66.field1817 = var69.zan2d;
						var66.field1821 = var69.xof2d;
						var66.field1798 = var69.yof2d;
						var66.zoom = var69.zoom2d;
						if (var66.width > 0) {
							var66.zoom = var66.zoom * 32 / var66.width;
						}
						continue;
					}
					if (opcode == 1201) {
						var66.modelType = 2;
						var4--;
						var66.model = field188[var4];
						continue;
					}
					if (opcode == 1202) {
						var66.modelType = 3;
						var66.model = Client.localPlayer.field2786.method1176();
						continue;
					}
				} else if ((opcode >= 1300 && opcode < 1400) || (opcode >= 2300 && opcode < 2400)) {
					IfType var70;
					if (opcode >= 2000) {
						opcode -= 1000;
						var4--;
						var70 = IfType.get(field188[var4]);
					} else {
						var70 = var47 ? activeComponent2 : activeComponent;
					}
					if (opcode == 1300) {
						var4--;
						int var71 = field188[var4] - 1;
						if (var71 >= 0 && var71 <= 9) {
							var5--;
							var70.method1829(var71, chatTyped[var5]);
							continue;
						}
						var5--;
						continue;
					}
					if (opcode == 1301) {
						var4 -= 2;
						int var72 = field188[var4];
						int var73 = field188[var4 + 1];
						var70.field1845 = IfType.method947(var72, var73);
						continue;
					}
					if (opcode == 1302) {
						var4--;
						var70.field1858 = field188[var4] == 1;
						continue;
					}
					if (opcode == 1303) {
						var4--;
						var70.field1846 = field188[var4];
						continue;
					}
					if (opcode == 1304) {
						var4--;
						var70.field1887 = field188[var4];
						continue;
					}
					if (opcode == 1305) {
						var5--;
						var70.field1795 = chatTyped[var5];
						continue;
					}
					if (opcode == 1306) {
						var5--;
						var70.targetVerb = chatTyped[var5];
						continue;
					}
					if (opcode == 1307) {
						var70.field1844 = null;
						continue;
					}
				} else {
					if (opcode >= 1400 && opcode < 1500 || opcode >= 2400 && opcode < 2500) {
						IfType var74;
						if (opcode >= 2000) {
							opcode -= 1000;
							var4--;
							var74 = IfType.get(field188[var4]);
						} else {
							var74 = var47 ? activeComponent2 : activeComponent;
						}
						var5--;
						String var75 = chatTyped[var5];
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
								var78[var79] = chatTyped[var5];
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
						if (opcode == 1400) {
							var74.field1852 = var78;
						}
						if (opcode == 1401) {
							var74.field1855 = var78;
						}
						if (opcode == 1402) {
							var74.field1851 = var78;
						}
						if (opcode == 1403) {
							var74.field1856 = var78;
						}
						if (opcode == 1404) {
							var74.field1838 = var78;
						}
						if (opcode == 1405) {
							var74.field1781 = var78;
						}
						if (opcode == 1406) {
							var74.field1836 = var78;
						}
						if (opcode == 1407) {
							var74.field1839 = var78;
							var74.field1889 = var76;
						}
						if (opcode == 1408) {
							var74.field1869 = var78;
						}
						if (opcode == 1409) {
							var74.field1847 = var78;
						}
						if (opcode == 1410) {
							var74.field1860 = var78;
						}
						if (opcode == 1411) {
							var74.field1853 = var78;
						}
						if (opcode == 1412) {
							var74.field1857 = var78;
						}
						if (opcode == 1414) {
							var74.field1865 = var78;
							var74.field1866 = var76;
						}
						if (opcode == 1415) {
							var74.field1867 = var78;
							var74.field1868 = var76;
						}
						if (opcode == 1416) {
							var74.field1861 = var78;
						}
						if (opcode == 1417) {
							var74.field1831 = var78;
						}
						if (opcode == 1418) {
							var74.field1872 = var78;
						}
						if (opcode == 1419) {
							var74.field1873 = var78;
						}
						if (opcode == 1420) {
							var74.field1877 = var78;
						}
						if (opcode == 1421) {
							var74.field1875 = var78;
						}
						if (opcode == 1422) {
							var74.field1777 = var78;
						}
						if (opcode == 1423) {
							var74.field1819 = var78;
						}
						if (opcode == 1424) {
							var74.field1878 = var78;
						}
						var74.field1813 = true;
						continue;
					}
					if (opcode < 1600) {
						IfType var81 = var47 ? activeComponent2 : activeComponent;
						if (opcode == 1500) {
							field188[var4++] = var81.field1788;
							continue;
						}
						if (opcode == 1501) {
							field188[var4++] = var81.field1810;
							continue;
						}
						if (opcode == 1502) {
							field188[var4++] = var81.width;
							continue;
						}
						if (opcode == 1503) {
							field188[var4++] = var81.height;
							continue;
						}
						if (opcode == 1504) {
							field188[var4++] = var81.hide ? 1 : 0;
							continue;
						}
						if (opcode == 1505) {
							field188[var4++] = var81.layerid;
							continue;
						}
					} else if (opcode < 1700) {
						IfType var82 = var47 ? activeComponent2 : activeComponent;
						if (opcode == 1600) {
							field188[var4++] = var82.field1796;
							continue;
						}
						if (opcode == 1601) {
							field188[var4++] = var82.field1797;
							continue;
						}
						if (opcode == 1602) {
							chatTyped[var5++] = var82.text;
							continue;
						}
						if (opcode == 1603) {
							field188[var4++] = var82.field1884;
							continue;
						}
						if (opcode == 1604) {
							field188[var4++] = var82.scroll;
							continue;
						}
						if (opcode == 1605) {
							field188[var4++] = var82.zoom;
							continue;
						}
						if (opcode == 1606) {
							field188[var4++] = var82.xan;
							continue;
						}
						if (opcode == 1607) {
							field188[var4++] = var82.field1817;
							continue;
						}
						if (opcode == 1608) {
							field188[var4++] = var82.yan;
							continue;
						}
					} else if (opcode < 1800) {
						IfType var83 = var47 ? activeComponent2 : activeComponent;
						if (opcode == 1700) {
							field188[var4++] = var83.field1791;
							continue;
						}
						if (opcode == 1701) {
							if (var83.field1791 == -1) {
								field188[var4++] = 0;
							} else {
								field188[var4++] = var83.field1888;
							}
							continue;
						}
						if (opcode == 1702) {
							field188[var4++] = var83.subid;
							continue;
						}
					} else if (opcode < 1900) {
						IfType var84 = var47 ? activeComponent2 : activeComponent;
						if (opcode == 1800) {
							field188[var4++] = WorldEntrySettings.method1350(Client.method1512(var84));
							continue;
						}
						if (opcode == 1801) {
							var4--;
							int var85 = field188[var4];
							int var368 = var85 - 1;
							if (var84.field1844 != null && var368 < var84.field1844.length && var84.field1844[var368] != null) {
								chatTyped[var5++] = var84.field1844[var368];
								continue;
							}
							chatTyped[var5++] = "";
							continue;
						}
						if (opcode == 1802) {
							if (var84.field1795 == null) {
								chatTyped[var5++] = "";
							} else {
								chatTyped[var5++] = var84.field1795;
							}
							continue;
						}
					} else if (opcode < 2600) {
						var4--;
						IfType var86 = IfType.get(field188[var4]);
						if (opcode == 2500) {
							field188[var4++] = var86.field1788;
							continue;
						}
						if (opcode == 2501) {
							field188[var4++] = var86.field1810;
							continue;
						}
						if (opcode == 2502) {
							field188[var4++] = var86.width;
							continue;
						}
						if (opcode == 2503) {
							field188[var4++] = var86.height;
							continue;
						}
						if (opcode == 2504) {
							field188[var4++] = var86.hide ? 1 : 0;
							continue;
						}
						if (opcode == 2505) {
							field188[var4++] = var86.layerid;
							continue;
						}
					} else if (opcode < 2700) {
						var4--;
						IfType var87 = IfType.get(field188[var4]);
						if (opcode == 2600) {
							field188[var4++] = var87.field1796;
							continue;
						}
						if (opcode == 2601) {
							field188[var4++] = var87.field1797;
							continue;
						}
						if (opcode == 2602) {
							chatTyped[var5++] = var87.text;
							continue;
						}
						if (opcode == 2603) {
							field188[var4++] = var87.field1884;
							continue;
						}
						if (opcode == 2604) {
							field188[var4++] = var87.scroll;
							continue;
						}
						if (opcode == 2605) {
							field188[var4++] = var87.zoom;
							continue;
						}
						if (opcode == 2606) {
							field188[var4++] = var87.xan;
							continue;
						}
						if (opcode == 2607) {
							field188[var4++] = var87.field1817;
							continue;
						}
						if (opcode == 2608) {
							field188[var4++] = var87.yan;
							continue;
						}
					} else if (opcode < 2800) {
						if (opcode == 2700) {
							var4--;
							IfType var88 = IfType.get(field188[var4]);
							field188[var4++] = var88.field1791;
							continue;
						}
						if (opcode == 2701) {
							var4--;
							IfType var89 = IfType.get(field188[var4]);
							if (var89.field1791 == -1) {
								field188[var4++] = 0;
							} else {
								field188[var4++] = var89.field1888;
							}
							continue;
						}
						if (opcode == 2702) {
							var4--;
							int var90 = field188[var4];
							ComponentPointer var91 = (ComponentPointer) Client.field1918.get((long) var90);
							if (var91 == null) {
								field188[var4++] = 0;
							} else {
								field188[var4++] = 1;
							}
							continue;
						}
					} else if (opcode < 2900) {
						var4--;
						IfType var92 = IfType.get(field188[var4]);
						if (opcode == 2800) {
							field188[var4++] = WorldEntrySettings.method1350(Client.method1512(var92));
							continue;
						}
						if (opcode == 2801) {
							var4--;
							int var93 = field188[var4];
							int var369 = var93 - 1;
							if (var92.field1844 != null && var369 < var92.field1844.length && var92.field1844[var369] != null) {
								chatTyped[var5++] = var92.field1844[var369];
								continue;
							}
							chatTyped[var5++] = "";
							continue;
						}
						if (opcode == 2802) {
							if (var92.field1795 == null) {
								chatTyped[var5++] = "";
							} else {
								chatTyped[var5++] = var92.field1795;
							}
							continue;
						}
					} else if (opcode < 3200) {
						if (opcode == 3100) {
							var5--;
							String var94 = chatTyped[var5];
							Client.addMessage(0, "", var94);
							continue;
						}
						if (opcode == 3101) {
							var4 -= 2;
							Client.method1040(Client.localPlayer, field188[var4], field188[var4 + 1]);
							continue;
						}
						if (opcode == 3103) {
							Client.out.pisaac1(129);
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
						if (opcode == 3104) {
							var5--;
							String var96 = chatTyped[var5];
							int var97 = 0;
							if (JStringUtil.method62(var96)) {
								int var98 = JStringUtil.method91(var96, 10, true);
								var97 = var98;
							}
							Client.out.pisaac1(27);
							Client.out.p4(var97);
							continue;
						}
						if (opcode == 3105) {
							var5--;
							String var99 = chatTyped[var5];
							Client.out.pisaac1(223);
							Client.out.p1(var99.length() + 1);
							Client.out.pjstr(var99);
							continue;
						}
						if (opcode == 3106) {
							var5--;
							String var100 = chatTyped[var5];
							Client.out.pisaac1(127);
							Client.out.p1(var100.length() + 1);
							Client.out.pjstr(var100);
							continue;
						}
						if (opcode == 3107) {
							var4--;
							int var101 = field188[var4];
							var5--;
							String var102 = chatTyped[var5];
							Client.method558(var101, var102);
							continue;
						}
						if (opcode == 3108) {
							var4 -= 3;
							int var103 = field188[var4];
							int var104 = field188[var4 + 1];
							int var105 = field188[var4 + 2];
							IfType var106 = IfType.get(var105);
							Client.method1102(var106, var103, var104);
							continue;
						}
						if (opcode == 3109) {
							var4 -= 2;
							int var107 = field188[var4];
							int var108 = field188[var4 + 1];
							IfType var109 = var47 ? activeComponent2 : activeComponent;
							Client.method1102(var109, var107, var108);
							continue;
						}
					} else if (opcode < 3300) {
						if (opcode == 3200) {
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
						if (opcode == 3201) {
							var4--;
							Client.method1232(field188[var4]);
							continue;
						}
						if (opcode == 3202) {
							var4 -= 2;
							int var113 = field188[var4];
							int var10000 = field188[var4 + 1];
							if (Client.field2169 != 0 && var113 != -1) {
								MidiPlayer.method1125(Client.midiJingleJs5, var113, 0, Client.field2169, false);
								Client.field2189 = true;
							}
							continue;
						}
					} else if (opcode < 3400) {
						if (opcode == 3300) {
							field188[var4++] = Client.loopCycle;
							continue;
						}
						if (opcode == 3301) {
							var4 -= 2;
							int var115 = field188[var4];
							int var116 = field188[var4 + 1];
							int[] var117 = field188;
							int var118 = var4++;
							ClientInvCache var119 = (ClientInvCache) ClientInvCache.field1623.get((long) var115);
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
						if (opcode == 3302) {
							var4 -= 2;
							int var121 = field188[var4];
							int var122 = field188[var4 + 1];
							field188[var4++] = ClientInvCache.method5(var121, var122);
							continue;
						}
						if (opcode == 3303) {
							var4 -= 2;
							int var123 = field188[var4];
							int var124 = field188[var4 + 1];
							field188[var4++] = ClientInvCache.method1446(var123, var124);
							continue;
						}
						if (opcode == 3304) {
							var4--;
							int var125 = field188[var4];
							field188[var4++] = InvType.get(var125).size;
							continue;
						}
						if (opcode == 3305) {
							var4--;
							int var132 = field188[var4];
							field188[var4++] = Client.field2060[var132];
							continue;
						}
						if (opcode == 3306) {
							var4--;
							int var133 = field188[var4];
							field188[var4++] = Client.field1960[var133];
							continue;
						}
						if (opcode == 3307) {
							var4--;
							int var134 = field188[var4];
							field188[var4++] = Client.field2062[var134];
							continue;
						}
						if (opcode == 3308) {
							int var135 = Client.currentLevel;
							int var136 = (Client.localPlayer.x >> 7) + Client.sceneBaseTileX;
							int var137 = (Client.localPlayer.z >> 7) + Client.sceneBaseTileZ;
							field188[var4++] = (var135 << 28) + (var136 << 14) + var137;
							continue;
						}
						if (opcode == 3309) {
							var4--;
							int var138 = field188[var4];
							field188[var4++] = var138 >> 14 & 0x3FFF;
							continue;
						}
						if (opcode == 3310) {
							var4--;
							int var139 = field188[var4];
							field188[var4++] = var139 >> 28;
							continue;
						}
						if (opcode == 3311) {
							var4--;
							int var140 = field188[var4];
							field188[var4++] = var140 & 0x3FFF;
							continue;
						}
						if (opcode == 3312) {
							field188[var4++] = Client.members ? 1 : 0;
							continue;
						}
						if (opcode == 3313) {
							var4 -= 2;
							int var141 = field188[var4] + 32768;
							int var142 = field188[var4 + 1];
							int[] var143 = field188;
							int var144 = var4++;
							ClientInvCache var145 = (ClientInvCache) ClientInvCache.field1623.get((long) var141);
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
						if (opcode == 3314) {
							var4 -= 2;
							int var147 = field188[var4] + 32768;
							int var148 = field188[var4 + 1];
							field188[var4++] = ClientInvCache.method5(var147, var148);
							continue;
						}
						if (opcode == 3315) {
							var4 -= 2;
							int var149 = field188[var4] + 32768;
							int var150 = field188[var4 + 1];
							field188[var4++] = ClientInvCache.method1446(var149, var150);
							continue;
						}
						if (opcode == 3316) {
							if (Client.staffmodlevel >= 2) {
								field188[var4++] = Client.staffmodlevel;
							} else {
								field188[var4++] = 0;
							}
							continue;
						}
						if (opcode == 3317) {
							field188[var4++] = Client.systemUpdateTimer;
							continue;
						}
						if (opcode == 3318) {
							field188[var4++] = Client.worldid;
							continue;
						}
						if (opcode == 3321) {
							field188[var4++] = Client.field2080;
							continue;
						}
						if (opcode == 3322) {
							field188[var4++] = Client.field2089;
							continue;
						}
						if (opcode == 3323) {
							if (Client.field2091) {
								field188[var4++] = 1;
							} else {
								field188[var4++] = 0;
							}
							continue;
						}
					} else if (opcode < 3500) {
						if (opcode == 3400) {
							var4 -= 2;
							int var151 = field188[var4];
							int var152 = field188[var4 + 1];
							EnumType var153 = EnumType.get(var151);
							if (var153.outputtype != 's') {
							}
							for (int var154 = 0; var154 < var153.count; var154++) {
								if (var153.keys[var154] == var152) {
									chatTyped[var5++] = var153.stringValues[var154];
									var153 = null;
									break;
								}
							}
							if (var153 != null) {
								chatTyped[var5++] = var153.defaultString;
							}
							continue;
						}
						if (opcode == 3408) {
							var4 -= 4;
							int var155 = field188[var4];
							int var156 = field188[var4 + 1];
							int var157 = field188[var4 + 2];
							int var158 = field188[var4 + 3];
							EnumType var159 = EnumType.get(var157);
							if (var159.inputtype == var155 && var159.outputtype == var156) {
								for (int var160 = 0; var160 < var159.count; var160++) {
									if (var159.keys[var160] == var158) {
										if (var156 == 115) {
											chatTyped[var5++] = var159.stringValues[var160];
										} else {
											field188[var4++] = var159.intValues[var160];
										}
										var159 = null;
										break;
									}
								}
								if (var159 != null) {
									if (var156 == 115) {
										chatTyped[var5++] = var159.defaultString;
									} else {
										field188[var4++] = var159.defaultInt;
									}
								}
								continue;
							}
							if (var156 == 115) {
								chatTyped[var5++] = "null";
							} else {
								field188[var4++] = 0;
							}
							continue;
						}
					} else if (opcode < 3700) {
						if (opcode == 3600) {
							if (Client.field2171 == 0) {
								field188[var4++] = -2;
							} else if (Client.field2171 == 1) {
								field188[var4++] = -1;
							} else {
								field188[var4++] = Client.field2071;
							}
							continue;
						}
						if (opcode == 3601) {
							var4--;
							int var161 = field188[var4];
							if (Client.field2171 == 2 && var161 < Client.field2071) {
								chatTyped[var5++] = Client.field2111[var161].field173;
								continue;
							}
							chatTyped[var5++] = "";
							continue;
						}
						if (opcode == 3602) {
							var4--;
							int var162 = field188[var4];
							if (Client.field2171 == 2 && var162 < Client.field2071) {
								field188[var4++] = Client.field2111[var162].field174;
								continue;
							}
							field188[var4++] = 0;
							continue;
						}
						if (opcode == 3603) {
							var4--;
							int var163 = field188[var4];
							if (Client.field2171 == 2 && var163 < Client.field2071) {
								field188[var4++] = Client.field2111[var163].field175;
								continue;
							}
							field188[var4++] = 0;
							continue;
						}
						if (opcode == 3604) {
							var5--;
							String var164 = chatTyped[var5];
							var4--;
							int var165 = field188[var4];
							Client.out.pisaac1(252);
							Client.out.p1(Packet.pjstrlen(var164) + 1);
							Client.out.pjstr(var164);
							Client.out.p1_alt1(var165);
							continue;
						}
						if (opcode == 3605) {
							var5--;
							String var166 = chatTyped[var5];
							Client.method1103(var166);
							continue;
						}
						if (opcode == 3606) {
							var5--;
							String var167 = chatTyped[var5];
							Client.method560(var167);
							continue;
						}
						if (opcode == 3607) {
							var5--;
							String var168 = chatTyped[var5];
							Client.method315(var168, false);
							continue;
						}
						if (opcode == 3608) {
							var5--;
							String var169 = chatTyped[var5];
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
									continue label2277;
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
									Client.out.pisaac1(248);
									Client.out.p1(Packet.pjstrlen(var169));
									Client.out.pjstr(var169);
									continue label2277;
								}
								var171++;
							}
						}
						if (opcode == 3609) {
							var5--;
							String var177 = chatTyped[var5];
							if (var177.startsWith(TextUtil.imgTag(0)) || var177.startsWith(TextUtil.imgTag(1))) {
								var177 = var177.substring(7);
							}
							field188[var4++] = Client.method785(var177) ? 1 : 0;
							continue;
						}
						if (opcode == 3611) {
							if (Client.field1955 == null) {
								chatTyped[var5++] = "";
							} else {
								String[] var178 = chatTyped;
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
						if (opcode == 3612) {
							if (Client.field1955 == null) {
								field188[var4++] = 0;
							} else {
								field188[var4++] = Client.field1220;
							}
							continue;
						}
						if (opcode == 3613) {
							var4--;
							int var183 = field188[var4];
							if (Client.field1955 != null && var183 < Client.field1220) {
								chatTyped[var5++] = Client.field1774[var183].field1617;
								continue;
							}
							chatTyped[var5++] = "";
							continue;
						}
						if (opcode == 3614) {
							var4--;
							int var184 = field188[var4];
							if (Client.field1955 != null && var184 < Client.field1220) {
								field188[var4++] = Client.field1774[var184].field1620;
								continue;
							}
							field188[var4++] = 0;
							continue;
						}
						if (opcode == 3615) {
							var4--;
							int var185 = field188[var4];
							if (Client.field1955 != null && var185 < Client.field1220) {
								field188[var4++] = Client.field1774[var185].field1619;
								continue;
							}
							field188[var4++] = 0;
							continue;
						}
						if (opcode == 3616) {
							field188[var4++] = Client.field1511;
							continue;
						}
						if (opcode == 3617) {
							var5--;
							String var186 = chatTyped[var5];
							if (Client.field1774 != null) {
								Client.out.pisaac1(245);
								Client.out.p1(Packet.pjstrlen(var186));
								Client.out.pjstr(var186);
							}
							continue;
						}
						if (opcode == 3618) {
							field188[var4++] = Client.field1217;
							continue;
						}
						if (opcode == 3619) {
							var5--;
							String var187 = chatTyped[var5];
							Client.method742(var187);
							continue;
						}
						if (opcode == 3620) {
							Client.method388();
							continue;
						}
						if (opcode == 3621) {
							if (Client.field2171 == 0) {
								field188[var4++] = -1;
							} else {
								field188[var4++] = Client.field2194;
							}
							continue;
						}
						if (opcode == 3622) {
							var4--;
							int var188 = field188[var4];
							if (Client.field2171 != 0 && var188 < Client.field2194) {
								chatTyped[var5++] = Client.field2196[var188].field40;
								continue;
							}
							chatTyped[var5++] = "";
							continue;
						}
						if (opcode == 3623) {
							var5--;
							String var189 = chatTyped[var5];
							if (var189.startsWith(TextUtil.imgTag(0)) || var189.startsWith(TextUtil.imgTag(1))) {
								var189 = var189.substring(7);
							}
							field188[var4++] = Client.method761(var189) ? 1 : 0;
							continue;
						}
						if (opcode == 3624) {
							var4--;
							int var190 = field188[var4];
							if (Client.field1774 != null && var190 < Client.field1220 && Client.field1774[var190].field1617.equalsIgnoreCase(Client.localPlayer.name)) {
								field188[var4++] = 1;
								continue;
							}
							field188[var4++] = 0;
							continue;
						}
						if (opcode == 3625) {
							if (Client.field2155 == null) {
								chatTyped[var5++] = "";
							} else {
								String[] var191 = chatTyped;
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
					} else if (opcode < 4100) {
						if (opcode == 4000) {
							var4 -= 2;
							int var196 = field188[var4];
							int var197 = field188[var4 + 1];
							field188[var4++] = var196 + var197;
							continue;
						}
						if (opcode == 4001) {
							var4 -= 2;
							int var198 = field188[var4];
							int var199 = field188[var4 + 1];
							field188[var4++] = var198 - var199;
							continue;
						}
						if (opcode == 4002) {
							var4 -= 2;
							int var200 = field188[var4];
							int var201 = field188[var4 + 1];
							field188[var4++] = var200 * var201;
							continue;
						}
						if (opcode == 4003) {
							var4 -= 2;
							int var202 = field188[var4];
							int var203 = field188[var4 + 1];
							field188[var4++] = var202 / var203;
							continue;
						}
						if (opcode == 4004) {
							var4--;
							int var204 = field188[var4];
							field188[var4++] = (int) (Math.random() * (double) var204);
							continue;
						}
						if (opcode == 4005) {
							var4--;
							int var205 = field188[var4];
							field188[var4++] = (int) (Math.random() * (double) (var205 + 1));
							continue;
						}
						if (opcode == 4006) {
							var4 -= 5;
							int var206 = field188[var4];
							int var207 = field188[var4 + 1];
							int var208 = field188[var4 + 2];
							int var209 = field188[var4 + 3];
							int var210 = field188[var4 + 4];
							field188[var4++] = (var207 - var206) * (var210 - var208) / (var209 - var208) + var206;
							continue;
						}
						if (opcode == 4007) {
							var4 -= 2;
							int var211 = field188[var4];
							int var212 = field188[var4 + 1];
							field188[var4++] = var211 * var212 / 100 + var211;
							continue;
						}
						if (opcode == 4008) {
							var4 -= 2;
							int var213 = field188[var4];
							int var214 = field188[var4 + 1];
							field188[var4++] = var213 | 0x1 << var214;
							continue;
						}
						if (opcode == 4009) {
							var4 -= 2;
							int var215 = field188[var4];
							int var216 = field188[var4 + 1];
							field188[var4++] = var215 & -1 - (0x1 << var216);
							continue;
						}
						if (opcode == 4010) {
							var4 -= 2;
							int var217 = field188[var4];
							int var218 = field188[var4 + 1];
							field188[var4++] = (var217 & 0x1 << var218) == 0 ? 0 : 1;
							continue;
						}
						if (opcode == 4011) {
							var4 -= 2;
							int var219 = field188[var4];
							int var220 = field188[var4 + 1];
							field188[var4++] = var219 % var220;
							continue;
						}
						if (opcode == 4012) {
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
						if (opcode == 4013) {
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
						if (opcode == 4014) {
							var4 -= 2;
							int var225 = field188[var4];
							int var226 = field188[var4 + 1];
							field188[var4++] = var225 & var226;
							continue;
						}
						if (opcode == 4015) {
							var4 -= 2;
							int var227 = field188[var4];
							int var228 = field188[var4 + 1];
							field188[var4++] = var227 | var228;
							continue;
						}
					} else if (opcode < 4200) {
						if (opcode == 4100) {
							var5--;
							String var229 = chatTyped[var5];
							var4--;
							int var230 = field188[var4];
							chatTyped[var5++] = var229 + var230;
							continue;
						}
						if (opcode == 4101) {
							var5 -= 2;
							String var231 = chatTyped[var5];
							String var232 = chatTyped[var5 + 1];
							chatTyped[var5++] = var231 + var232;
							continue;
						}
						if (opcode == 4102) {
							var5--;
							String var233 = chatTyped[var5];
							var4--;
							int var234 = field188[var4];
							chatTyped[var5++] = var233 + JStringUtil.method903(var234, true);
							continue;
						}
						if (opcode == 4103) {
							var5--;
							String var235 = chatTyped[var5];
							chatTyped[var5++] = var235.toLowerCase();
							continue;
						}
						if (opcode == 4104) {
							var4--;
							int var236 = field188[var4];
							long var237 = ((long) var236 + 11745L) * 86400000L;
							field197.setTime(new Date(var237));
							int var239 = field197.get(5);
							int var240 = field197.get(2);
							int var241 = field197.get(1);
							chatTyped[var5++] = var239 + "-" + field190[var240] + "-" + var241;
							continue;
						}
						if (opcode == 4105) {
							var5 -= 2;
							String var242 = chatTyped[var5];
							String var243 = chatTyped[var5 + 1];
							if (Client.localPlayer.field2786 != null && Client.localPlayer.field2786.field1222) {
								chatTyped[var5++] = var243;
								continue;
							}
							chatTyped[var5++] = var242;
							continue;
						}
						if (opcode == 4106) {
							var4--;
							int var244 = field188[var4];
							chatTyped[var5++] = Integer.toString(var244);
							continue;
						}
						if (opcode == 4107) {
							var5 -= 2;
							int[] var245 = field188;
							int var246 = var4++;
							String var247 = chatTyped[var5];
							String var248 = chatTyped[var5 + 1];
							int var249 = Client.lang;
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
						if (opcode == 4108) {
							var5--;
							String var281 = chatTyped[var5];
							var4 -= 2;
							int var282 = field188[var4];
							int var283 = field188[var4 + 1];
							byte[] var284 = Client.fontMetricJs5.getFile(var283, 0);
							SoftwareFont var285 = new SoftwareFont(var284);
							field188[var4++] = var285.method2889(var281, var282);
							continue;
						}
						if (opcode == 4109) {
							var5--;
							String var286 = chatTyped[var5];
							var4 -= 2;
							int var287 = field188[var4];
							int var288 = field188[var4 + 1];
							byte[] var289 = Client.fontMetricJs5.getFile(var288, 0);
							SoftwareFont var290 = new SoftwareFont(var289);
							field188[var4++] = var290.method2818(var286, var287);
							continue;
						}
						if (opcode == 4110) {
							var5 -= 2;
							String var291 = chatTyped[var5];
							String var292 = chatTyped[var5 + 1];
							var4--;
							if (field188[var4] == 1) {
								chatTyped[var5++] = var291;
							} else {
								chatTyped[var5++] = var292;
							}
							continue;
						}
						if (opcode == 4111) {
							var5--;
							String var293 = chatTyped[var5];
							chatTyped[var5++] = PixFont.method2844(var293);
							continue;
						}
						if (opcode == 4112) {
							var5--;
							String var294 = chatTyped[var5];
							var4--;
							int var295 = field188[var4];
							chatTyped[var5++] = var294 + (char) var295;
							continue;
						}
						if (opcode == 4113) {
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
						if (opcode == 4114) {
							var4--;
							int var301 = field188[var4];
							int[] var302 = field188;
							int var303 = var4++;
							char var304 = (char) var301;
							boolean var305 = var304 >= '0' && var304 <= '9' || var304 >= 'A' && var304 <= 'Z' || var304 >= 'a' && var304 <= 'z';
							var302[var303] = var305 ? 1 : 0;
							continue;
						}
						if (opcode == 4115) {
							var4--;
							int var306 = field188[var4];
							field188[var4++] = JStringUtil.method1124((char) var306) ? 1 : 0;
							continue;
						}
						if (opcode == 4116) {
							var4--;
							int var307 = field188[var4];
							int[] var308 = field188;
							int var309 = var4++;
							char var310 = (char) var307;
							boolean var311 = var310 >= '0' && var310 <= '9';
							var308[var309] = var311 ? 1 : 0;
							continue;
						}
						if (opcode == 4117) {
							var5--;
							String var312 = chatTyped[var5];
							if (var312 == null) {
								field188[var4++] = 0;
							} else {
								field188[var4++] = var312.length();
							}
							continue;
						}
						if (opcode == 4118) {
							var5--;
							String var313 = chatTyped[var5];
							var4 -= 2;
							int var314 = field188[var4];
							int var315 = field188[var4 + 1];
							chatTyped[var5++] = var313.substring(var314, var315);
							continue;
						}
						if (opcode == 4119) {
							var5--;
							String var316 = chatTyped[var5];
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
							chatTyped[var5++] = var317.toString();
							continue;
						}
						if (opcode == 4120) {
							var5--;
							String var321 = chatTyped[var5];
							var4--;
							int var322 = field188[var4];
							field188[var4++] = var321.indexOf(var322);
							continue;
						}
					} else if (opcode < 4300) {
						if (opcode == 4200) {
							var4--;
							int var323 = field188[var4];
							chatTyped[var5++] = ObjType.get(var323).name;
							continue;
						}
						if (opcode == 4201) {
							var4 -= 2;
							int var324 = field188[var4];
							int var325 = field188[var4 + 1];
							ObjType var326 = ObjType.get(var324);
							if (var325 >= 1 && var325 <= 5 && var326.op[var325 - 1] != null) {
								chatTyped[var5++] = var326.op[var325 - 1];
								continue;
							}
							chatTyped[var5++] = "";
							continue;
						}
						if (opcode == 4202) {
							var4 -= 2;
							int var327 = field188[var4];
							int var328 = field188[var4 + 1];
							ObjType var329 = ObjType.get(var327);
							if (var328 >= 1 && var328 <= 5 && var329.iop[var328 - 1] != null) {
								chatTyped[var5++] = var329.iop[var328 - 1];
								continue;
							}
							chatTyped[var5++] = "";
							continue;
						}
						if (opcode == 4203) {
							var4--;
							int var330 = field188[var4];
							field188[var4++] = ObjType.get(var330).cost;
							continue;
						}
						if (opcode == 4204) {
							var4--;
							int var331 = field188[var4];
							field188[var4++] = ObjType.get(var331).stackable == 1 ? 1 : 0;
							continue;
						}
						if (opcode == 4205) {
							var4--;
							int var332 = field188[var4];
							ObjType var333 = ObjType.get(var332);
							if (var333.certtemplate == -1 && var333.certlink >= 0) {
								field188[var4++] = var333.certlink;
								continue;
							}
							field188[var4++] = var332;
							continue;
						}
						if (opcode == 4206) {
							var4--;
							int var334 = field188[var4];
							ObjType var335 = ObjType.get(var334);
							if (var335.certtemplate >= 0 && var335.certlink >= 0) {
								field188[var4++] = var335.certlink;
								continue;
							}
							field188[var4++] = var334;
							continue;
						}
						if (opcode == 4207) {
							var4--;
							int var336 = field188[var4];
							field188[var4++] = ObjType.get(var336).members ? 1 : 0;
							continue;
						}
					} else if (opcode < 5100) {
						if (opcode == 5000) {
							field188[var4++] = Client.field2145;
							continue;
						}
						if (opcode == 5001) {
							var4 -= 3;
							Client.field2145 = field188[var4];
							int var337 = field188[var4 + 1];
							ChatFilterPrivacy[] var338 = ChatFilterPrivacy.values();
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
							Client.field680 = var341;
							if (Client.field680 == null) {
								Client.field680 = ChatFilterPrivacy.field1106;
							}
							Client.field2146 = field188[var4 + 2];
							Client.out.pisaac1(167);
							Client.out.p1(Client.field2145);
							Client.out.p1(Client.field680.field1107);
							Client.out.p1(Client.field2146);
							continue;
						}
						if (opcode == 5002) {
							var5--;
							String var342 = chatTyped[var5];
							var4 -= 2;
							int var343 = field188[var4];
							int var344 = field188[var4 + 1];
							Client.out.pisaac1(96);
							Client.out.p1(Packet.pjstrlen(var342) + 2);
							Client.out.pjstr(var342);
							Client.out.p1(var343 - 1);
							Client.out.p1(var344);
							continue;
						}
						if (opcode == 5003) {
							var4--;
							int var345 = field188[var4];
							String var346 = null;
							if (var345 < 100) {
								var346 = Client.field2142[var345];
							}
							if (var346 == null) {
								var346 = "";
							}
							chatTyped[var5++] = var346;
							continue;
						}
						if (opcode == 5004) {
							var4--;
							int var347 = field188[var4];
							int var348 = -1;
							if (var347 < 100 && Client.field2142[var347] != null) {
								var348 = Client.field2139[var347];
							}
							field188[var4++] = var348;
							continue;
						}
						if (opcode == 5005) {
							if (Client.field680 == null) {
								field188[var4++] = -1;
							} else {
								field188[var4++] = Client.field680.field1107;
							}
							continue;
						}
						if (opcode == 5008) {
							var5--;

							String message = chatTyped[var5];
							if (message.startsWith("::")) {
								Client.doCheat(message);
							} else {
								String colorLower = message.toLowerCase();
								byte color = 0;
								if (colorLower.startsWith(Locale.COLOR_YELLOW)) {
									color = 0;
									message = message.substring(Locale.COLOR_YELLOW.length());
								} else if (colorLower.startsWith(Locale.COLOR_RED)) {
									color = 1;
									message = message.substring(Locale.COLOR_RED.length());
								} else if (colorLower.startsWith(Locale.COLOR_GREEN)) {
									color = 2;
									message = message.substring(Locale.COLOR_GREEN.length());
								} else if (colorLower.startsWith(Locale.COLOR_CYAN)) {
									color = 3;
									message = message.substring(Locale.COLOR_CYAN.length());
								} else if (colorLower.startsWith(Locale.COLOR_PURPLE)) {
									color = 4;
									message = message.substring(Locale.COLOR_PURPLE.length());
								} else if (colorLower.startsWith(Locale.COLOR_WHITE)) {
									color = 5;
									message = message.substring(Locale.COLOR_WHITE.length());
								} else if (colorLower.startsWith(Locale.COLOR_FLASH1)) {
									color = 6;
									message = message.substring(Locale.COLOR_FLASH1.length());
								} else if (colorLower.startsWith(Locale.COLOR_FLASH2)) {
									color = 7;
									message = message.substring(Locale.COLOR_FLASH2.length());
								} else if (colorLower.startsWith(Locale.COLOR_FLASH3)) {
									color = 8;
									message = message.substring(Locale.COLOR_FLASH3.length());
								} else if (colorLower.startsWith(Locale.COLOR_GLOW1)) {
									color = 9;
									message = message.substring(Locale.COLOR_GLOW1.length());
								} else if (colorLower.startsWith(Locale.COLOR_GLOW2)) {
									color = 10;
									message = message.substring(Locale.COLOR_GLOW2.length());
								} else if (colorLower.startsWith(Locale.COLOR_GLOW3)) {
									color = 11;
									message = message.substring(Locale.COLOR_GLOW3.length());
								} else if (Client.lang != 0) {
									if (colorLower.startsWith(Locale.GER_COLOR_YELLOW)) {
										color = 0;
										message = message.substring(Locale.GER_COLOR_YELLOW.length());
									} else if (colorLower.startsWith(Locale.GER_COLOR_RED)) {
										color = 1;
										message = message.substring(Locale.GER_COLOR_RED.length());
									} else if (colorLower.startsWith(Locale.GER_COLOR_GREEN)) {
										color = 2;
										message = message.substring(Locale.GER_COLOR_GREEN.length());
									} else if (colorLower.startsWith(Locale.GER_COLOR_CYAN)) {
										color = 3;
										message = message.substring(Locale.GER_COLOR_CYAN.length());
									} else if (colorLower.startsWith(Locale.GER_COLOR_PURPLE)) {
										color = 4;
										message = message.substring(Locale.GER_COLOR_PURPLE.length());
									} else if (colorLower.startsWith(Locale.GER_COLOR_WHITE)) {
										color = 5;
										message = message.substring(Locale.GER_COLOR_WHITE.length());
									} else if (colorLower.startsWith(Locale.GER_COLOR_FLASH1)) {
										color = 6;
										message = message.substring(Locale.GER_COLOR_FLASH1.length());
									} else if (colorLower.startsWith(Locale.GER_COLOR_FLASH2)) {
										color = 7;
										message = message.substring(Locale.GER_COLOR_FLASH2.length());
									} else if (colorLower.startsWith(Locale.GER_COLOR_FLASH3)) {
										color = 8;
										message = message.substring(Locale.GER_COLOR_FLASH3.length());
									} else if (colorLower.startsWith(Locale.GER_COLOR_GLOW1)) {
										color = 9;
										message = message.substring(Locale.GER_COLOR_GLOW1.length());
									} else if (colorLower.startsWith(Locale.GER_COLOR_GLOW2)) {
										color = 10;
										message = message.substring(Locale.GER_COLOR_GLOW2.length());
									} else if (colorLower.startsWith(Locale.GER_COLOR_GLOW3)) {
										color = 11;
										message = message.substring(Locale.GER_COLOR_GLOW3.length());
									}
								}

								String effectLower = message.toLowerCase();
								byte effect = 0;
								if (effectLower.startsWith(Locale.EFFECT_WAVE)) {
									effect = 1;
									message = message.substring(Locale.EFFECT_WAVE.length());
								} else if (effectLower.startsWith(Locale.EFFECT_WAVE2)) {
									effect = 2;
									message = message.substring(Locale.EFFECT_WAVE2.length());
								} else if (effectLower.startsWith(Locale.EFFECT_SHAKE)) {
									effect = 3;
									message = message.substring(Locale.EFFECT_SHAKE.length());
								} else if (effectLower.startsWith(Locale.EFFECT_SCROLL)) {
									effect = 4;
									message = message.substring(Locale.EFFECT_SCROLL.length());
								} else if (effectLower.startsWith(Locale.EFFECT_SLIDE)) {
									effect = 5;
									message = message.substring(Locale.EFFECT_SLIDE.length());
								} else if (Client.lang != 0) {
									if (effectLower.startsWith(Locale.GER_EFFECT_WAVE)) {
										effect = 1;
										message = message.substring(Locale.GER_EFFECT_WAVE.length());
									} else if (effectLower.startsWith(Locale.GER_EFFECT_WAVE2)) {
										effect = 2;
										message = message.substring(Locale.GER_EFFECT_WAVE2.length());
									} else if (effectLower.startsWith(Locale.GER_EFFECT_SHAKE)) {
										effect = 3;
										message = message.substring(Locale.GER_EFFECT_SHAKE.length());
									} else if (effectLower.startsWith(Locale.GER_EFFECT_SCROLL)) {
										effect = 4;
										message = message.substring(Locale.GER_EFFECT_SCROLL.length());
									} else if (effectLower.startsWith(Locale.GER_EFFECT_SLIDE)) {
										effect = 5;
										message = message.substring(Locale.GER_EFFECT_SLIDE.length());
									}
								}

								Client.out.pisaac1(205);
								Client.out.p1(0);
								int start = Client.out.pos;

								Client.out.p1(color);
								Client.out.p1(effect);
								WordPack.method911(Client.out, message);

								Client.out.psize1(Client.out.pos - start);
							}
							continue;
						}
						if (opcode == 5009) {
							var5 -= 2;
							String var355 = chatTyped[var5];
							String var356 = chatTyped[var5 + 1];
							Client.out.pisaac1(211);
							Client.out.p2(0);
							int var357 = Client.out.pos;
							Client.out.pjstr(var355);
							WordPack.method911(Client.out, var356);
							Client.out.psize2(Client.out.pos - var357);
							continue;
						}
						if (opcode == 5010) {
							var4--;
							int var358 = field188[var4];
							String var359 = null;
							if (var358 < 100) {
								var359 = Client.field2046[var358];
							}
							if (var359 == null) {
								var359 = "";
							}
							chatTyped[var5++] = var359;
							continue;
						}
						if (opcode == 5011) {
							var4--;
							int var360 = field188[var4];
							String var361 = null;
							if (var360 < 100) {
								var361 = Client.field2173[var360];
							}
							if (var361 == null) {
								var361 = "";
							}
							chatTyped[var5++] = var361;
							continue;
						}
						if (opcode == 5015) {
							String var362;
							if (Client.localPlayer == null || Client.localPlayer.name == null) {
								var362 = "";
							} else {
								var362 = Client.localPlayer.name;
							}
							chatTyped[var5++] = var362;
							continue;
						}
						if (opcode == 5016) {
							field188[var4++] = Client.field2146;
							continue;
						}
						if (opcode == 5017) {
							field188[var4++] = Client.field2141;
							continue;
						}
					}
				}
				throw new IllegalStateException();
			}
		} catch (Exception var366) {
			StringBuilder var364 = new StringBuilder(30);
			var364.append("").append(var3.key).append(" ");
			for (int var365 = field195 - 1; var365 >= 0; var365--) {
				var364.append("").append(field196[var365].script.key).append(" ");
			}
			var364.append("").append(var9);
			JagException.report((String) var364.toString(), (Throwable) var366);
		}
	}

	@ObfuscatedName("r.d(II)V")
	public static void method6(int arg0) {
		if (arg0 == -1 || !IfType.method1501(arg0)) {
			return;
		}
		IfType[] var1 = IfType.field373[arg0];
		for (int var2 = 0; var2 < var1.length; var2++) {
			IfType var3 = var1[var2];
			if (var3.field1775 != null) {
				HookRequest var4 = new HookRequest();
				var4.component = var3;
				var4.field1588 = var3.field1775;
				runHook(var4);
			}
		}
	}
}
