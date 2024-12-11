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
	public static int[] intStack = new int[1000];

	@ObfuscatedName("s.j")
	public static String[] stringStack = new String[1000];

	@ObfuscatedName("s.z")
	public static int fp = 0;

	@ObfuscatedName("s.g")
	public static ScriptFrame[] frames = new ScriptFrame[50];

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
		Object[] onop = req.onop;
		int id = (Integer) onop[0];

		ClientScript script = ClientScript.get(id);
		if (script == null) {
			return;
		}

		int isp = 0;
		int ssp = 0;
		int pc = -1;
		int[] instructions = script.instructions;
		int[] intOperands = script.intOperands;
		int lastOp = -1; // byte type originally... automatic optimization because of dead code maybe?
		fp = 0;

		try {
			intLocals = new int[script.intLocalCount];
			int intCount = 0;

			stringLocals = new String[script.stringLocalCount];
			int stringCount = 0;

			for (int i = 1; i < onop.length; i++) {
				if (onop[i] instanceof Integer) {
					int op = (Integer) onop[i];

					if (op == 0x80000001) {
						op = req.mouseX;
					} else if (op == 0x80000002) {
						op = req.mouseY;
					} else if (op == 0x80000003) {
						op = req.component == null ? -1 : req.component.parentlayer;
					} else if (op == 0x80000004) {
						op = req.opindex;
					} else if (op == 0x80000005) {
						op = req.component == null ? -1 : req.component.subid;
					} else if (op == 0x80000006) {
						op = req.drop == null ? -1 : req.drop.parentlayer;
					} else if (op == 0x80000007) {
						op = req.drop == null ? -1 : req.drop.subid;
					} else if (op == 0x80000008) {
						op = req.key;
					} else if (op == 0x80000009) {
						op = req.keyChar;
					}

					intLocals[intCount++] = op;
				} else if (onop[i] instanceof String) {
					String op = (String) onop[i];

					if (op.equals("event_opbase")) {
						op = req.opbase;
					}

					stringLocals[stringCount++] = op;
				}
			}

			int opcount = 0;
			label2277: while (true) {
				opcount++;
				if (opcount > 200000) {
					throw new RuntimeException("slow");
				}

				pc++;
				int opcode = instructions[pc];
				lastOp = opcode; // value not saved after deob, but it must be on their end...

				if (opcode < 100) {
					if (opcode == 0) {
						intStack[isp++] = intOperands[pc];
						continue;
					}
					if (opcode == 1) {
						int var16 = intOperands[pc];
						intStack[isp++] = VarProvider.varps[var16];
						continue;
					}
					if (opcode == 2) {
						int var17 = intOperands[pc];
						isp--;
						VarProvider.varps[var17] = intStack[isp];
						continue;
					}
					if (opcode == 3) {
						stringStack[ssp++] = script.stringOperands[pc];
						continue;
					}
					if (opcode == 6) {
						pc += intOperands[pc];
						continue;
					}
					if (opcode == 7) {
						isp -= 2;
						if (intStack[isp + 1] != intStack[isp]) {
							pc += intOperands[pc];
						}
						continue;
					}
					if (opcode == 8) {
						isp -= 2;
						if (intStack[isp + 1] == intStack[isp]) {
							pc += intOperands[pc];
						}
						continue;
					}
					if (opcode == 9) {
						isp -= 2;
						if (intStack[isp] < intStack[isp + 1]) {
							pc += intOperands[pc];
						}
						continue;
					}
					if (opcode == 10) {
						isp -= 2;
						if (intStack[isp] > intStack[isp + 1]) {
							pc += intOperands[pc];
						}
						continue;
					}
					if (opcode == 21) {
						if (fp == 0) {
							return;
						}

						ScriptFrame frame = frames[--fp];
						script = frame.script;
						instructions = script.instructions;
						intOperands = script.intOperands;
						pc = frame.pc;
						intLocals = frame.intLocals;
						stringLocals = frame.stringLocals;
						continue;
					}
					if (opcode == 25) {
						int var19 = intOperands[pc];
						intStack[isp++] = VarProvider.getVarbit(var19);
						continue;
					}
					if (opcode == 27) {
						int var20 = intOperands[pc];
						isp--;
						int var21 = intStack[isp];
						VarBitType var22 = VarBitType.get(var20);
						int var23 = var22.basevar;
						int var24 = var22.startbit;
						int var25 = var22.endbit;
						int var26 = VarProvider.BITMASK[var25 - var24];
						if (var21 < 0 || var21 > var26) {
							var21 = 0;
						}
						int var27 = var26 << var24;
						VarProvider.varps[var23] = VarProvider.varps[var23] & ~var27 | var21 << var24 & var27;
						continue;
					}
					if (opcode == 31) {
						isp -= 2;
						if (intStack[isp] <= intStack[isp + 1]) {
							pc += intOperands[pc];
						}
						continue;
					}
					if (opcode == 32) {
						isp -= 2;
						if (intStack[isp] >= intStack[isp + 1]) {
							pc += intOperands[pc];
						}
						continue;
					}
					if (opcode == 33) {
						intStack[isp++] = intLocals[intOperands[pc]];
						continue;
					}
					int var10001;
					if (opcode == 34) {
						var10001 = intOperands[pc];
						isp--;
						intLocals[var10001] = intStack[isp];
						continue;
					}
					if (opcode == 35) {
						stringStack[ssp++] = stringLocals[intOperands[pc]];
						continue;
					}
					if (opcode == 36) {
						var10001 = intOperands[pc];
						ssp--;
						stringLocals[var10001] = stringStack[ssp];
						continue;
					}
					if (opcode == 37) {
						int var28 = intOperands[pc];
						ssp -= var28;
						String var29 = JStringUtil.method1785(stringStack, ssp, var28);
						stringStack[ssp++] = var29;
						continue;
					}
					if (opcode == 38) {
						isp--;
						continue;
					}
					if (opcode == 39) {
						ssp--;
						continue;
					}
					if (opcode == 40) {
						int procId = intOperands[pc];
						ClientScript proc = ClientScript.get(procId);

						int[] procIntLocals = new int[proc.intLocalCount];
						String[] procStringLocals = new String[proc.stringLocalCount];

						for (int i = 0; i < proc.intArgCount; i++) {
							procIntLocals[i] = intStack[isp - proc.intArgCount + i];
						}

						for (int i = 0; i < proc.stringArgCount; i++) {
							procStringLocals[i] = stringStack[ssp - proc.stringArgCount + i];
						}

						isp -= proc.intArgCount;
						ssp -= proc.stringArgCount;

						ScriptFrame frame = new ScriptFrame();
						frame.script = script;
						frame.pc = pc;
						frame.intLocals = intLocals;
						frame.stringLocals = stringLocals;
						frames[++fp - 1] = frame;

						script = proc;
						instructions = proc.instructions;
						intOperands = proc.intOperands;
						pc = -1;
						intLocals = procIntLocals;
						stringLocals = procStringLocals;
						continue;
					}
					if (opcode == 42) {
						intStack[isp++] = Client.field2120[intOperands[pc]];
						continue;
					}
					if (opcode == 43) {
						var10001 = intOperands[pc];
						isp--;
						Client.field2120[var10001] = intStack[isp];
						continue;
					}
					if (opcode == 44) {
						int var37 = intOperands[pc] >> 16;
						int var38 = intOperands[pc] & 0xFFFF;
						isp--;
						int var39 = intStack[isp];
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
						int var42 = intOperands[pc];
						isp--;
						int var43 = intStack[isp];
						if (var43 >= 0 && var43 < field193[var42]) {
							intStack[isp++] = field192[var42][var43];
							continue;
						}
						throw new RuntimeException();
					}
					if (opcode == 46) {
						int var44 = intOperands[pc];
						isp -= 2;
						int var45 = intStack[isp];
						if (var45 >= 0 && var45 < field193[var44]) {
							field192[var44][var45] = intStack[isp + 1];
							continue;
						}
						throw new RuntimeException();
					}
					if (opcode == 47) {
						String var46 = Client.field1996[intOperands[pc]];
						if (var46 == null) {
							var46 = "null";
						}
						stringStack[ssp++] = var46;
						continue;
					}
					if (opcode == 48) {
						var10001 = intOperands[pc];
						ssp--;
						Client.field1996[var10001] = stringStack[ssp];
						continue;
					}
				}

				boolean secondary;
				if (intOperands[pc] == 1) {
					secondary = true;
				} else {
					secondary = false;
				}

				if (opcode < 1000) {
					if (opcode == 100) {
						isp -= 3;
						int var48 = intStack[isp];
						int var49 = intStack[isp + 1];
						int var50 = intStack[isp + 2];
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
						var54.layerid = var54.parentlayer = var51.parentlayer;
						var54.subid = var50;
						var54.if3 = true;
						var51.subcomponents[var50] = var54;
						if (secondary) {
							activeComponent2 = var54;
						} else {
							activeComponent = var54;
						}
						Client.method1238(var51);
						continue;
					}
					if (opcode == 101) {
						IfType var55 = secondary ? activeComponent2 : activeComponent;
						IfType var56 = IfType.get(var55.parentlayer);
						var56.subcomponents[var55.subid] = null;
						Client.method1238(var56);
						continue;
					}
					if (opcode == 102) {
						isp--;
						IfType var57 = IfType.get(intStack[isp]);
						var57.subcomponents = null;
						Client.method1238(var57);
						continue;
					}
					if (opcode == 200) {
						isp -= 2;
						int var58 = intStack[isp];
						int var59 = intStack[isp + 1];
						IfType var60 = IfType.method947(var58, var59);
						if (var60 != null && var59 != -1) {
							intStack[isp++] = 1;
							if (secondary) {
								activeComponent2 = var60;
							} else {
								activeComponent = var60;
							}
							continue;
						}
						intStack[isp++] = 0;
						continue;
					}
				} else if (opcode >= 1000 && opcode < 1100 || !(opcode < 2000 || opcode >= 2100)) {
					IfType var61;
					if (opcode >= 2000) {
						opcode -= 1000;
						isp--;
						var61 = IfType.get(intStack[isp]);
					} else {
						var61 = secondary ? activeComponent2 : activeComponent;
					}
					if (opcode == 1000) {
						isp -= 2;
						var61.field1788 = intStack[isp];
						var61.field1810 = intStack[isp + 1];
						Client.method1238(var61);
						continue;
					}
					if (opcode == 1001) {
						isp -= 2;
						var61.width = intStack[isp];
						var61.height = intStack[isp + 1];
						Client.method1238(var61);
						continue;
					}
					if (opcode == 1003) {
						isp--;
						boolean var62 = intStack[isp] == 1;
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
						isp--;
						var63 = IfType.get(intStack[isp]);
					} else {
						var63 = secondary ? activeComponent2 : activeComponent;
					}
					if (opcode == 1100) {
						isp -= 2;
						var63.field1796 = intStack[isp];
						if (var63.field1796 > var63.field1884 - var63.width) {
							var63.field1796 = var63.field1884 - var63.width;
						}
						if (var63.field1796 < 0) {
							var63.field1796 = 0;
						}
						var63.field1797 = intStack[isp + 1];
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
						isp--;
						var63.colour = intStack[isp];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1102) {
						isp--;
						var63.fill = intStack[isp] == 1;
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1103) {
						isp--;
						var63.alpha = intStack[isp];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1104) {
						isp--;
						var63.field1804 = intStack[isp];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1105) {
						isp--;
						var63.graphic = intStack[isp];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1106) {
						isp--;
						var63.field1784 = intStack[isp];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1107) {
						isp--;
						var63.field1794 = intStack[isp] == 1;
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1108) {
						var63.modelType = 1;
						isp--;
						var63.model = intStack[isp];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1109) {
						isp -= 6;
						var63.field1821 = intStack[isp];
						var63.field1798 = intStack[isp + 1];
						var63.xan = intStack[isp + 2];
						var63.yan = intStack[isp + 3];
						var63.field1817 = intStack[isp + 4];
						var63.zoom = intStack[isp + 5];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1110) {
						isp--;
						int var64 = intStack[isp];
						if (var63.anim != var64) {
							var63.anim = var64;
							var63.field1779 = 0;
							var63.field1890 = 0;
							Client.method1238(var63);
						}
						continue;
					}
					if (opcode == 1111) {
						isp--;
						var63.field1828 = intStack[isp] == 1;
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1112) {
						ssp--;
						String var65 = stringStack[ssp];
						if (!var65.equals(var63.text)) {
							var63.text = var65;
							Client.method1238(var63);
						}
						continue;
					}
					if (opcode == 1113) {
						isp--;
						var63.font = intStack[isp];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1114) {
						isp -= 3;
						var63.center = intStack[isp];
						var63.field1834 = intStack[isp + 1];
						var63.field1832 = intStack[isp + 2];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1115) {
						isp--;
						var63.shadowed = intStack[isp] == 1;
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1116) {
						isp--;
						var63.field1811 = intStack[isp];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1117) {
						isp--;
						var63.field1812 = intStack[isp];
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1118) {
						isp--;
						var63.field1849 = intStack[isp] == 1;
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1119) {
						isp--;
						var63.field1814 = intStack[isp] == 1;
						Client.method1238(var63);
						continue;
					}
					if (opcode == 1120) {
						isp -= 2;
						var63.field1884 = intStack[isp];
						var63.scroll = intStack[isp + 1];
						Client.method1238(var63);
						continue;
					}
				} else if (opcode >= 1200 && opcode < 1300 || !(opcode < 2200 || opcode >= 2300)) {
					IfType var66;
					if (opcode >= 2000) {
						opcode -= 1000;
						isp--;
						var66 = IfType.get(intStack[isp]);
					} else {
						var66 = secondary ? activeComponent2 : activeComponent;
					}
					Client.method1238(var66);
					if (opcode == 1200) {
						isp -= 2;
						int var67 = intStack[isp];
						int var68 = intStack[isp + 1];
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
						isp--;
						var66.model = intStack[isp];
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
						isp--;
						var70 = IfType.get(intStack[isp]);
					} else {
						var70 = secondary ? activeComponent2 : activeComponent;
					}
					if (opcode == 1300) {
						isp--;
						int var71 = intStack[isp] - 1;
						if (var71 >= 0 && var71 <= 9) {
							ssp--;
							var70.method1829(var71, stringStack[ssp]);
							continue;
						}
						ssp--;
						continue;
					}
					if (opcode == 1301) {
						isp -= 2;
						int var72 = intStack[isp];
						int var73 = intStack[isp + 1];
						var70.field1845 = IfType.method947(var72, var73);
						continue;
					}
					if (opcode == 1302) {
						isp--;
						var70.field1858 = intStack[isp] == 1;
						continue;
					}
					if (opcode == 1303) {
						isp--;
						var70.field1846 = intStack[isp];
						continue;
					}
					if (opcode == 1304) {
						isp--;
						var70.field1887 = intStack[isp];
						continue;
					}
					if (opcode == 1305) {
						ssp--;
						var70.field1795 = stringStack[ssp];
						continue;
					}
					if (opcode == 1306) {
						ssp--;
						var70.targetVerb = stringStack[ssp];
						continue;
					}
					if (opcode == 1307) {
						var70.field1844 = null;
						continue;
					}
				} else if (opcode >= 1400 && opcode < 1500 || opcode >= 2400 && opcode < 2500) {
					IfType var74;
					if (opcode >= 2000) {
						opcode -= 1000;
						isp--;
						var74 = IfType.get(intStack[isp]);
					} else {
						var74 = secondary ? activeComponent2 : activeComponent;
					}
					ssp--;
					String var75 = stringStack[ssp];
					int[] var76 = null;
					if (var75.length() > 0 && var75.charAt(var75.length() - 1) == 'Y') {
						isp--;
						int var77 = intStack[isp];
						if (var77 > 0) {
							var76 = new int[var77];
							while (var77-- > 0) {
								isp--;
								var76[var77] = intStack[isp];
							}
						}
						var75 = var75.substring(0, var75.length() - 1);
					}
					Object[] var78 = new Object[var75.length() + 1];
					for (int var79 = var78.length - 1; var79 >= 1; var79--) {
						if (var75.charAt(var79 - 1) == 's') {
							ssp--;
							var78[var79] = stringStack[ssp];
						} else {
							isp--;
							var78[var79] = Integer.valueOf(intStack[isp]);
						}
					}
					isp--;
					int var80 = intStack[isp];
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
					IfType var81 = secondary ? activeComponent2 : activeComponent;
					if (opcode == 1500) {
						intStack[isp++] = var81.field1788;
						continue;
					}
					if (opcode == 1501) {
						intStack[isp++] = var81.field1810;
						continue;
					}
					if (opcode == 1502) {
						intStack[isp++] = var81.width;
						continue;
					}
					if (opcode == 1503) {
						intStack[isp++] = var81.height;
						continue;
					}
					if (opcode == 1504) {
						intStack[isp++] = var81.hide ? 1 : 0;
						continue;
					}
					if (opcode == 1505) {
						intStack[isp++] = var81.layerid;
						continue;
					}
				} else if (opcode < 1700) {
					IfType var82 = secondary ? activeComponent2 : activeComponent;
					if (opcode == 1600) {
						intStack[isp++] = var82.field1796;
						continue;
					}
					if (opcode == 1601) {
						intStack[isp++] = var82.field1797;
						continue;
					}
					if (opcode == 1602) {
						stringStack[ssp++] = var82.text;
						continue;
					}
					if (opcode == 1603) {
						intStack[isp++] = var82.field1884;
						continue;
					}
					if (opcode == 1604) {
						intStack[isp++] = var82.scroll;
						continue;
					}
					if (opcode == 1605) {
						intStack[isp++] = var82.zoom;
						continue;
					}
					if (opcode == 1606) {
						intStack[isp++] = var82.xan;
						continue;
					}
					if (opcode == 1607) {
						intStack[isp++] = var82.field1817;
						continue;
					}
					if (opcode == 1608) {
						intStack[isp++] = var82.yan;
						continue;
					}
				} else if (opcode < 1800) {
					IfType var83 = secondary ? activeComponent2 : activeComponent;
					if (opcode == 1700) {
						intStack[isp++] = var83.field1791;
						continue;
					}
					if (opcode == 1701) {
						if (var83.field1791 == -1) {
							intStack[isp++] = 0;
						} else {
							intStack[isp++] = var83.field1888;
						}
						continue;
					}
					if (opcode == 1702) {
						intStack[isp++] = var83.subid;
						continue;
					}
				} else if (opcode < 1900) {
					IfType var84 = secondary ? activeComponent2 : activeComponent;
					if (opcode == 1800) {
						intStack[isp++] = WorldEntrySettings.method1350(Client.method1512(var84));
						continue;
					}
					if (opcode == 1801) {
						isp--;
						int var85 = intStack[isp];
						int var368 = var85 - 1;
						if (var84.field1844 != null && var368 < var84.field1844.length && var84.field1844[var368] != null) {
							stringStack[ssp++] = var84.field1844[var368];
							continue;
						}
						stringStack[ssp++] = "";
						continue;
					}
					if (opcode == 1802) {
						if (var84.field1795 == null) {
							stringStack[ssp++] = "";
						} else {
							stringStack[ssp++] = var84.field1795;
						}
						continue;
					}
				} else if (opcode < 2600) {
					isp--;
					IfType var86 = IfType.get(intStack[isp]);
					if (opcode == 2500) {
						intStack[isp++] = var86.field1788;
						continue;
					}
					if (opcode == 2501) {
						intStack[isp++] = var86.field1810;
						continue;
					}
					if (opcode == 2502) {
						intStack[isp++] = var86.width;
						continue;
					}
					if (opcode == 2503) {
						intStack[isp++] = var86.height;
						continue;
					}
					if (opcode == 2504) {
						intStack[isp++] = var86.hide ? 1 : 0;
						continue;
					}
					if (opcode == 2505) {
						intStack[isp++] = var86.layerid;
						continue;
					}
				} else if (opcode < 2700) {
					isp--;
					IfType var87 = IfType.get(intStack[isp]);
					if (opcode == 2600) {
						intStack[isp++] = var87.field1796;
						continue;
					}
					if (opcode == 2601) {
						intStack[isp++] = var87.field1797;
						continue;
					}
					if (opcode == 2602) {
						stringStack[ssp++] = var87.text;
						continue;
					}
					if (opcode == 2603) {
						intStack[isp++] = var87.field1884;
						continue;
					}
					if (opcode == 2604) {
						intStack[isp++] = var87.scroll;
						continue;
					}
					if (opcode == 2605) {
						intStack[isp++] = var87.zoom;
						continue;
					}
					if (opcode == 2606) {
						intStack[isp++] = var87.xan;
						continue;
					}
					if (opcode == 2607) {
						intStack[isp++] = var87.field1817;
						continue;
					}
					if (opcode == 2608) {
						intStack[isp++] = var87.yan;
						continue;
					}
				} else if (opcode < 2800) {
					if (opcode == 2700) {
						isp--;
						IfType var88 = IfType.get(intStack[isp]);
						intStack[isp++] = var88.field1791;
						continue;
					}
					if (opcode == 2701) {
						isp--;
						IfType var89 = IfType.get(intStack[isp]);
						if (var89.field1791 == -1) {
							intStack[isp++] = 0;
						} else {
							intStack[isp++] = var89.field1888;
						}
						continue;
					}
					if (opcode == 2702) {
						isp--;
						int var90 = intStack[isp];
						ComponentPointer var91 = (ComponentPointer) Client.field1918.get((long) var90);
						if (var91 == null) {
							intStack[isp++] = 0;
						} else {
							intStack[isp++] = 1;
						}
						continue;
					}
				} else if (opcode < 2900) {
					isp--;
					IfType var92 = IfType.get(intStack[isp]);
					if (opcode == 2800) {
						intStack[isp++] = WorldEntrySettings.method1350(Client.method1512(var92));
						continue;
					}
					if (opcode == 2801) {
						isp--;
						int var93 = intStack[isp];
						int var369 = var93 - 1;
						if (var92.field1844 != null && var369 < var92.field1844.length && var92.field1844[var369] != null) {
							stringStack[ssp++] = var92.field1844[var369];
							continue;
						}
						stringStack[ssp++] = "";
						continue;
					}
					if (opcode == 2802) {
						if (var92.field1795 == null) {
							stringStack[ssp++] = "";
						} else {
							stringStack[ssp++] = var92.field1795;
						}
						continue;
					}
				} else if (opcode < 3200) {
					if (opcode == 3100) {
						ssp--;
						String var94 = stringStack[ssp];
						Client.addMessage(0, "", var94);
						continue;
					}
					if (opcode == 3101) {
						isp -= 2;
						Client.method1040(Client.localPlayer, intStack[isp], intStack[isp + 1]);
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
						ssp--;
						String var96 = stringStack[ssp];
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
						ssp--;
						String var99 = stringStack[ssp];
						Client.out.pisaac1(223);
						Client.out.p1(var99.length() + 1);
						Client.out.pjstr(var99);
						continue;
					}
					if (opcode == 3106) {
						ssp--;
						String var100 = stringStack[ssp];
						Client.out.pisaac1(127);
						Client.out.p1(var100.length() + 1);
						Client.out.pjstr(var100);
						continue;
					}
					if (opcode == 3107) {
						isp--;
						int var101 = intStack[isp];
						ssp--;
						String var102 = stringStack[ssp];
						Client.method558(var101, var102);
						continue;
					}
					if (opcode == 3108) {
						isp -= 3;
						int var103 = intStack[isp];
						int var104 = intStack[isp + 1];
						int var105 = intStack[isp + 2];
						IfType var106 = IfType.get(var105);
						Client.method1102(var106, var103, var104);
						continue;
					}
					if (opcode == 3109) {
						isp -= 2;
						int var107 = intStack[isp];
						int var108 = intStack[isp + 1];
						IfType var109 = secondary ? activeComponent2 : activeComponent;
						Client.method1102(var109, var107, var108);
						continue;
					}
				} else if (opcode < 3300) {
					if (opcode == 3200) {
						isp -= 3;
						int var110 = intStack[isp];
						int var111 = intStack[isp + 1];
						int var112 = intStack[isp + 2];
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
						isp--;
						Client.method1232(intStack[isp]);
						continue;
					}
					if (opcode == 3202) {
						isp -= 2;
						int var113 = intStack[isp];
						int var10000 = intStack[isp + 1];
						if (Client.field2169 != 0 && var113 != -1) {
							MidiPlayer.method1125(Client.midiJingleJs5, var113, 0, Client.field2169, false);
							Client.field2189 = true;
						}
						continue;
					}
				} else if (opcode < 3400) {
					if (opcode == 3300) {
						intStack[isp++] = Client.loopCycle;
						continue;
					}
					if (opcode == 3301) {
						isp -= 2;
						int var115 = intStack[isp];
						int var116 = intStack[isp + 1];
						int[] var117 = intStack;
						int var118 = isp++;
						ClientInvCache var119 = (ClientInvCache) ClientInvCache.field1623.get((long) var115);
						int var120;
						if (var119 == null) {
							var120 = -1;
						} else if (var116 >= 0 && var116 < var119.objId.length) {
							var120 = var119.objId[var116];
						} else {
							var120 = -1;
						}
						var117[var118] = var120;
						continue;
					}
					if (opcode == 3302) {
						isp -= 2;
						int var121 = intStack[isp];
						int var122 = intStack[isp + 1];
						intStack[isp++] = ClientInvCache.method5(var121, var122);
						continue;
					}
					if (opcode == 3303) {
						isp -= 2;
						int var123 = intStack[isp];
						int var124 = intStack[isp + 1];
						intStack[isp++] = ClientInvCache.method1446(var123, var124);
						continue;
					}
					if (opcode == 3304) {
						isp--;
						int var125 = intStack[isp];
						intStack[isp++] = InvType.get(var125).size;
						continue;
					}
					if (opcode == 3305) {
						isp--;
						int var132 = intStack[isp];
						intStack[isp++] = Client.field2060[var132];
						continue;
					}
					if (opcode == 3306) {
						isp--;
						int var133 = intStack[isp];
						intStack[isp++] = Client.field1960[var133];
						continue;
					}
					if (opcode == 3307) {
						isp--;
						int var134 = intStack[isp];
						intStack[isp++] = Client.field2062[var134];
						continue;
					}
					if (opcode == 3308) {
						int var135 = Client.currentLevel;
						int var136 = (Client.localPlayer.x >> 7) + Client.sceneBaseTileX;
						int var137 = (Client.localPlayer.z >> 7) + Client.sceneBaseTileZ;
						intStack[isp++] = (var135 << 28) + (var136 << 14) + var137;
						continue;
					}
					if (opcode == 3309) {
						isp--;
						int var138 = intStack[isp];
						intStack[isp++] = var138 >> 14 & 0x3FFF;
						continue;
					}
					if (opcode == 3310) {
						isp--;
						int var139 = intStack[isp];
						intStack[isp++] = var139 >> 28;
						continue;
					}
					if (opcode == 3311) {
						isp--;
						int var140 = intStack[isp];
						intStack[isp++] = var140 & 0x3FFF;
						continue;
					}
					if (opcode == 3312) {
						intStack[isp++] = Client.members ? 1 : 0;
						continue;
					}
					if (opcode == 3313) {
						isp -= 2;
						int var141 = intStack[isp] + 32768;
						int var142 = intStack[isp + 1];
						int[] var143 = intStack;
						int var144 = isp++;
						ClientInvCache var145 = (ClientInvCache) ClientInvCache.field1623.get((long) var141);
						int var146;
						if (var145 == null) {
							var146 = -1;
						} else if (var142 >= 0 && var142 < var145.objId.length) {
							var146 = var145.objId[var142];
						} else {
							var146 = -1;
						}
						var143[var144] = var146;
						continue;
					}
					if (opcode == 3314) {
						isp -= 2;
						int var147 = intStack[isp] + 32768;
						int var148 = intStack[isp + 1];
						intStack[isp++] = ClientInvCache.method5(var147, var148);
						continue;
					}
					if (opcode == 3315) {
						isp -= 2;
						int var149 = intStack[isp] + 32768;
						int var150 = intStack[isp + 1];
						intStack[isp++] = ClientInvCache.method1446(var149, var150);
						continue;
					}
					if (opcode == 3316) {
						if (Client.staffmodlevel >= 2) {
							intStack[isp++] = Client.staffmodlevel;
						} else {
							intStack[isp++] = 0;
						}
						continue;
					}
					if (opcode == 3317) {
						intStack[isp++] = Client.systemUpdateTimer;
						continue;
					}
					if (opcode == 3318) {
						intStack[isp++] = Client.worldid;
						continue;
					}
					if (opcode == 3321) {
						intStack[isp++] = Client.field2080;
						continue;
					}
					if (opcode == 3322) {
						intStack[isp++] = Client.field2089;
						continue;
					}
					if (opcode == 3323) {
						if (Client.field2091) {
							intStack[isp++] = 1;
						} else {
							intStack[isp++] = 0;
						}
						continue;
					}
				} else if (opcode < 3500) {
					if (opcode == 3400) {
						isp -= 2;
						int var151 = intStack[isp];
						int var152 = intStack[isp + 1];
						EnumType var153 = EnumType.get(var151);
						if (var153.outputtype != 's') {
						}
						for (int var154 = 0; var154 < var153.count; var154++) {
							if (var153.keys[var154] == var152) {
								stringStack[ssp++] = var153.stringValues[var154];
								var153 = null;
								break;
							}
						}
						if (var153 != null) {
							stringStack[ssp++] = var153.defaultString;
						}
						continue;
					}
					if (opcode == 3408) {
						isp -= 4;
						int var155 = intStack[isp];
						int var156 = intStack[isp + 1];
						int var157 = intStack[isp + 2];
						int var158 = intStack[isp + 3];
						EnumType var159 = EnumType.get(var157);
						if (var159.inputtype == var155 && var159.outputtype == var156) {
							for (int var160 = 0; var160 < var159.count; var160++) {
								if (var159.keys[var160] == var158) {
									if (var156 == 115) {
										stringStack[ssp++] = var159.stringValues[var160];
									} else {
										intStack[isp++] = var159.intValues[var160];
									}
									var159 = null;
									break;
								}
							}
							if (var159 != null) {
								if (var156 == 115) {
									stringStack[ssp++] = var159.defaultString;
								} else {
									intStack[isp++] = var159.defaultInt;
								}
							}
							continue;
						}
						if (var156 == 115) {
							stringStack[ssp++] = "null";
						} else {
							intStack[isp++] = 0;
						}
						continue;
					}
				} else if (opcode < 3700) {
					if (opcode == 3600) {
						if (Client.field2171 == 0) {
							intStack[isp++] = -2;
						} else if (Client.field2171 == 1) {
							intStack[isp++] = -1;
						} else {
							intStack[isp++] = Client.field2071;
						}
						continue;
					}
					if (opcode == 3601) {
						isp--;
						int var161 = intStack[isp];
						if (Client.field2171 == 2 && var161 < Client.field2071) {
							stringStack[ssp++] = Client.field2111[var161].field173;
							continue;
						}
						stringStack[ssp++] = "";
						continue;
					}
					if (opcode == 3602) {
						isp--;
						int var162 = intStack[isp];
						if (Client.field2171 == 2 && var162 < Client.field2071) {
							intStack[isp++] = Client.field2111[var162].field174;
							continue;
						}
						intStack[isp++] = 0;
						continue;
					}
					if (opcode == 3603) {
						isp--;
						int var163 = intStack[isp];
						if (Client.field2171 == 2 && var163 < Client.field2071) {
							intStack[isp++] = Client.field2111[var163].field175;
							continue;
						}
						intStack[isp++] = 0;
						continue;
					}
					if (opcode == 3604) {
						ssp--;
						String var164 = stringStack[ssp];
						isp--;
						int var165 = intStack[isp];
						Client.out.pisaac1(252);
						Client.out.p1(Packet.pjstrlen(var164) + 1);
						Client.out.pjstr(var164);
						Client.out.p1_alt1(var165);
						continue;
					}
					if (opcode == 3605) {
						ssp--;
						String var166 = stringStack[ssp];
						Client.method1103(var166);
						continue;
					}
					if (opcode == 3606) {
						ssp--;
						String var167 = stringStack[ssp];
						Client.method560(var167);
						continue;
					}
					if (opcode == 3607) {
						ssp--;
						String var168 = stringStack[ssp];
						Client.method315(var168, false);
						continue;
					}
					if (opcode == 3608) {
						ssp--;
						String var169 = stringStack[ssp];
						if (var169 == null) {
							continue;
						}
						String var170 = NamespaceUtil.method743(var169, Client.namespace);
						if (var170 == null) {
							continue;
						}
						int var171 = 0;
						while (true) {
							if (var171 >= Client.ignoreCount) {
								continue label2277;
							}
							IgnoreListEntry var172 = Client.ignoreList[var171];
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
								Client.ignoreCount--;
								for (int var176 = var171; var176 < Client.ignoreCount; var176++) {
									Client.ignoreList[var176] = Client.ignoreList[var176 + 1];
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
						ssp--;
						String var177 = stringStack[ssp];
						if (var177.startsWith(TextUtil.imgTag(0)) || var177.startsWith(TextUtil.imgTag(1))) {
							var177 = var177.substring(7);
						}
						intStack[isp++] = Client.method785(var177) ? 1 : 0;
						continue;
					}
					if (opcode == 3611) {
						if (Client.field1955 == null) {
							stringStack[ssp++] = "";
						} else {
							String[] var178 = stringStack;
							int var179 = ssp++;
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
							intStack[isp++] = 0;
						} else {
							intStack[isp++] = Client.field1220;
						}
						continue;
					}
					if (opcode == 3613) {
						isp--;
						int var183 = intStack[isp];
						if (Client.field1955 != null && var183 < Client.field1220) {
							stringStack[ssp++] = Client.field1774[var183].field1617;
							continue;
						}
						stringStack[ssp++] = "";
						continue;
					}
					if (opcode == 3614) {
						isp--;
						int var184 = intStack[isp];
						if (Client.field1955 != null && var184 < Client.field1220) {
							intStack[isp++] = Client.field1774[var184].field1620;
							continue;
						}
						intStack[isp++] = 0;
						continue;
					}
					if (opcode == 3615) {
						isp--;
						int var185 = intStack[isp];
						if (Client.field1955 != null && var185 < Client.field1220) {
							intStack[isp++] = Client.field1774[var185].field1619;
							continue;
						}
						intStack[isp++] = 0;
						continue;
					}
					if (opcode == 3616) {
						intStack[isp++] = Client.field1511;
						continue;
					}
					if (opcode == 3617) {
						ssp--;
						String var186 = stringStack[ssp];
						if (Client.field1774 != null) {
							Client.out.pisaac1(245);
							Client.out.p1(Packet.pjstrlen(var186));
							Client.out.pjstr(var186);
						}
						continue;
					}
					if (opcode == 3618) {
						intStack[isp++] = Client.field1217;
						continue;
					}
					if (opcode == 3619) {
						ssp--;
						String var187 = stringStack[ssp];
						Client.method742(var187);
						continue;
					}
					if (opcode == 3620) {
						Client.method388();
						continue;
					}
					if (opcode == 3621) {
						if (Client.field2171 == 0) {
							intStack[isp++] = -1;
						} else {
							intStack[isp++] = Client.ignoreCount;
						}
						continue;
					}
					if (opcode == 3622) {
						isp--;
						int var188 = intStack[isp];
						if (Client.field2171 != 0 && var188 < Client.ignoreCount) {
							stringStack[ssp++] = Client.ignoreList[var188].field40;
							continue;
						}
						stringStack[ssp++] = "";
						continue;
					}
					if (opcode == 3623) {
						ssp--;
						String var189 = stringStack[ssp];
						if (var189.startsWith(TextUtil.imgTag(0)) || var189.startsWith(TextUtil.imgTag(1))) {
							var189 = var189.substring(7);
						}
						intStack[isp++] = Client.isIgnored(var189) ? 1 : 0;
						continue;
					}
					if (opcode == 3624) {
						isp--;
						int var190 = intStack[isp];
						if (Client.field1774 != null && var190 < Client.field1220 && Client.field1774[var190].field1617.equalsIgnoreCase(Client.localPlayer.name)) {
							intStack[isp++] = 1;
							continue;
						}
						intStack[isp++] = 0;
						continue;
					}
					if (opcode == 3625) {
						if (Client.field2155 == null) {
							stringStack[ssp++] = "";
						} else {
							String[] var191 = stringStack;
							int var192 = ssp++;
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
						isp -= 2;
						int var196 = intStack[isp];
						int var197 = intStack[isp + 1];
						intStack[isp++] = var196 + var197;
						continue;
					}
					if (opcode == 4001) {
						isp -= 2;
						int var198 = intStack[isp];
						int var199 = intStack[isp + 1];
						intStack[isp++] = var198 - var199;
						continue;
					}
					if (opcode == 4002) {
						isp -= 2;
						int var200 = intStack[isp];
						int var201 = intStack[isp + 1];
						intStack[isp++] = var200 * var201;
						continue;
					}
					if (opcode == 4003) {
						isp -= 2;
						int var202 = intStack[isp];
						int var203 = intStack[isp + 1];
						intStack[isp++] = var202 / var203;
						continue;
					}
					if (opcode == 4004) {
						isp--;
						int var204 = intStack[isp];
						intStack[isp++] = (int) (Math.random() * (double) var204);
						continue;
					}
					if (opcode == 4005) {
						isp--;
						int var205 = intStack[isp];
						intStack[isp++] = (int) (Math.random() * (double) (var205 + 1));
						continue;
					}
					if (opcode == 4006) {
						isp -= 5;
						int var206 = intStack[isp];
						int var207 = intStack[isp + 1];
						int var208 = intStack[isp + 2];
						int var209 = intStack[isp + 3];
						int var210 = intStack[isp + 4];
						intStack[isp++] = (var207 - var206) * (var210 - var208) / (var209 - var208) + var206;
						continue;
					}
					if (opcode == 4007) {
						isp -= 2;
						int var211 = intStack[isp];
						int var212 = intStack[isp + 1];
						intStack[isp++] = var211 * var212 / 100 + var211;
						continue;
					}
					if (opcode == 4008) {
						isp -= 2;
						int var213 = intStack[isp];
						int var214 = intStack[isp + 1];
						intStack[isp++] = var213 | 0x1 << var214;
						continue;
					}
					if (opcode == 4009) {
						isp -= 2;
						int var215 = intStack[isp];
						int var216 = intStack[isp + 1];
						intStack[isp++] = var215 & -1 - (0x1 << var216);
						continue;
					}
					if (opcode == 4010) {
						isp -= 2;
						int var217 = intStack[isp];
						int var218 = intStack[isp + 1];
						intStack[isp++] = (var217 & 0x1 << var218) == 0 ? 0 : 1;
						continue;
					}
					if (opcode == 4011) {
						isp -= 2;
						int var219 = intStack[isp];
						int var220 = intStack[isp + 1];
						intStack[isp++] = var219 % var220;
						continue;
					}
					if (opcode == 4012) {
						isp -= 2;
						int var221 = intStack[isp];
						int var222 = intStack[isp + 1];
						if (var221 == 0) {
							intStack[isp++] = 0;
						} else {
							intStack[isp++] = (int) Math.pow((double) var221, (double) var222);
						}
						continue;
					}
					if (opcode == 4013) {
						isp -= 2;
						int var223 = intStack[isp];
						int var224 = intStack[isp + 1];
						if (var223 == 0) {
							intStack[isp++] = 0;
						} else if (var224 == 0) {
							intStack[isp++] = Integer.MAX_VALUE;
						} else {
							intStack[isp++] = (int) Math.pow((double) var223, 1.0D / (double) var224);
						}
						continue;
					}
					if (opcode == 4014) {
						isp -= 2;
						int var225 = intStack[isp];
						int var226 = intStack[isp + 1];
						intStack[isp++] = var225 & var226;
						continue;
					}
					if (opcode == 4015) {
						isp -= 2;
						int var227 = intStack[isp];
						int var228 = intStack[isp + 1];
						intStack[isp++] = var227 | var228;
						continue;
					}
				} else if (opcode < 4200) {
					if (opcode == 4100) {
						ssp--;
						String var229 = stringStack[ssp];
						isp--;
						int var230 = intStack[isp];
						stringStack[ssp++] = var229 + var230;
						continue;
					}
					if (opcode == 4101) {
						ssp -= 2;
						String var231 = stringStack[ssp];
						String var232 = stringStack[ssp + 1];
						stringStack[ssp++] = var231 + var232;
						continue;
					}
					if (opcode == 4102) {
						ssp--;
						String var233 = stringStack[ssp];
						isp--;
						int var234 = intStack[isp];
						stringStack[ssp++] = var233 + JStringUtil.method903(var234, true);
						continue;
					}
					if (opcode == 4103) {
						ssp--;
						String var235 = stringStack[ssp];
						stringStack[ssp++] = var235.toLowerCase();
						continue;
					}
					if (opcode == 4104) {
						isp--;
						int var236 = intStack[isp];
						long var237 = ((long) var236 + 11745L) * 86400000L;
						field197.setTime(new Date(var237));
						int var239 = field197.get(5);
						int var240 = field197.get(2);
						int var241 = field197.get(1);
						stringStack[ssp++] = var239 + "-" + field190[var240] + "-" + var241;
						continue;
					}
					if (opcode == 4105) {
						ssp -= 2;
						String var242 = stringStack[ssp];
						String var243 = stringStack[ssp + 1];
						if (Client.localPlayer.field2786 != null && Client.localPlayer.field2786.field1222) {
							stringStack[ssp++] = var243;
							continue;
						}
						stringStack[ssp++] = var242;
						continue;
					}
					if (opcode == 4106) {
						isp--;
						int var244 = intStack[isp];
						stringStack[ssp++] = Integer.toString(var244);
						continue;
					}
					if (opcode == 4107) {
						ssp -= 2;
						int[] var245 = intStack;
						int var246 = isp++;
						String var247 = stringStack[ssp];
						String var248 = stringStack[ssp + 1];
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
						ssp--;
						String var281 = stringStack[ssp];
						isp -= 2;
						int var282 = intStack[isp];
						int var283 = intStack[isp + 1];
						byte[] var284 = Client.fontMetricJs5.getFile(var283, 0);
						SoftwareFont var285 = new SoftwareFont(var284);
						intStack[isp++] = var285.method2889(var281, var282);
						continue;
					}
					if (opcode == 4109) {
						ssp--;
						String var286 = stringStack[ssp];
						isp -= 2;
						int var287 = intStack[isp];
						int var288 = intStack[isp + 1];
						byte[] var289 = Client.fontMetricJs5.getFile(var288, 0);
						SoftwareFont var290 = new SoftwareFont(var289);
						intStack[isp++] = var290.method2818(var286, var287);
						continue;
					}
					if (opcode == 4110) {
						ssp -= 2;
						String var291 = stringStack[ssp];
						String var292 = stringStack[ssp + 1];
						isp--;
						if (intStack[isp] == 1) {
							stringStack[ssp++] = var291;
						} else {
							stringStack[ssp++] = var292;
						}
						continue;
					}
					if (opcode == 4111) {
						ssp--;
						String var293 = stringStack[ssp];
						stringStack[ssp++] = PixFont.method2844(var293);
						continue;
					}
					if (opcode == 4112) {
						ssp--;
						String var294 = stringStack[ssp];
						isp--;
						int var295 = intStack[isp];
						stringStack[ssp++] = var294 + (char) var295;
						continue;
					}
					if (opcode == 4113) {
						isp--;
						int var296 = intStack[isp];
						int[] var297 = intStack;
						int var298 = isp++;
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
						isp--;
						int var301 = intStack[isp];
						int[] var302 = intStack;
						int var303 = isp++;
						char var304 = (char) var301;
						boolean var305 = var304 >= '0' && var304 <= '9' || var304 >= 'A' && var304 <= 'Z' || var304 >= 'a' && var304 <= 'z';
						var302[var303] = var305 ? 1 : 0;
						continue;
					}
					if (opcode == 4115) {
						isp--;
						int var306 = intStack[isp];
						intStack[isp++] = JStringUtil.method1124((char) var306) ? 1 : 0;
						continue;
					}
					if (opcode == 4116) {
						isp--;
						int var307 = intStack[isp];
						int[] var308 = intStack;
						int var309 = isp++;
						char var310 = (char) var307;
						boolean var311 = var310 >= '0' && var310 <= '9';
						var308[var309] = var311 ? 1 : 0;
						continue;
					}
					if (opcode == 4117) {
						ssp--;
						String var312 = stringStack[ssp];
						if (var312 == null) {
							intStack[isp++] = 0;
						} else {
							intStack[isp++] = var312.length();
						}
						continue;
					}
					if (opcode == 4118) {
						ssp--;
						String var313 = stringStack[ssp];
						isp -= 2;
						int var314 = intStack[isp];
						int var315 = intStack[isp + 1];
						stringStack[ssp++] = var313.substring(var314, var315);
						continue;
					}
					if (opcode == 4119) {
						ssp--;
						String var316 = stringStack[ssp];
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
						stringStack[ssp++] = var317.toString();
						continue;
					}
					if (opcode == 4120) {
						ssp--;
						String var321 = stringStack[ssp];
						isp--;
						int var322 = intStack[isp];
						intStack[isp++] = var321.indexOf(var322);
						continue;
					}
				} else if (opcode < 4300) {
					if (opcode == 4200) {
						isp--;
						int var323 = intStack[isp];
						stringStack[ssp++] = ObjType.get(var323).name;
						continue;
					}
					if (opcode == 4201) {
						isp -= 2;
						int var324 = intStack[isp];
						int var325 = intStack[isp + 1];
						ObjType var326 = ObjType.get(var324);
						if (var325 >= 1 && var325 <= 5 && var326.op[var325 - 1] != null) {
							stringStack[ssp++] = var326.op[var325 - 1];
							continue;
						}
						stringStack[ssp++] = "";
						continue;
					}
					if (opcode == 4202) {
						isp -= 2;
						int var327 = intStack[isp];
						int var328 = intStack[isp + 1];
						ObjType var329 = ObjType.get(var327);
						if (var328 >= 1 && var328 <= 5 && var329.iop[var328 - 1] != null) {
							stringStack[ssp++] = var329.iop[var328 - 1];
							continue;
						}
						stringStack[ssp++] = "";
						continue;
					}
					if (opcode == 4203) {
						isp--;
						int var330 = intStack[isp];
						intStack[isp++] = ObjType.get(var330).cost;
						continue;
					}
					if (opcode == 4204) {
						isp--;
						int var331 = intStack[isp];
						intStack[isp++] = ObjType.get(var331).stackable == 1 ? 1 : 0;
						continue;
					}
					if (opcode == 4205) {
						isp--;
						int var332 = intStack[isp];
						ObjType var333 = ObjType.get(var332);
						if (var333.certtemplate == -1 && var333.certlink >= 0) {
							intStack[isp++] = var333.certlink;
							continue;
						}
						intStack[isp++] = var332;
						continue;
					}
					if (opcode == 4206) {
						isp--;
						int var334 = intStack[isp];
						ObjType var335 = ObjType.get(var334);
						if (var335.certtemplate >= 0 && var335.certlink >= 0) {
							intStack[isp++] = var335.certlink;
							continue;
						}
						intStack[isp++] = var334;
						continue;
					}
					if (opcode == 4207) {
						isp--;
						int var336 = intStack[isp];
						intStack[isp++] = ObjType.get(var336).members ? 1 : 0;
						continue;
					}
				} else if (opcode < 5100) {
					if (opcode == 5000) {
						intStack[isp++] = Client.field2145;
						continue;
					}
					if (opcode == 5001) {
						isp -= 3;
						Client.field2145 = intStack[isp];
						int var337 = intStack[isp + 1];
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
						Client.field2146 = intStack[isp + 2];
						Client.out.pisaac1(167);
						Client.out.p1(Client.field2145);
						Client.out.p1(Client.field680.field1107);
						Client.out.p1(Client.field2146);
						continue;
					}
					if (opcode == 5002) {
						ssp--;
						String var342 = stringStack[ssp];
						isp -= 2;
						int var343 = intStack[isp];
						int var344 = intStack[isp + 1];
						Client.out.pisaac1(96);
						Client.out.p1(Packet.pjstrlen(var342) + 2);
						Client.out.pjstr(var342);
						Client.out.p1(var343 - 1);
						Client.out.p1(var344);
						continue;
					}
					if (opcode == 5003) {
						isp--;
						int var345 = intStack[isp];
						String var346 = null;
						if (var345 < 100) {
							var346 = Client.field2142[var345];
						}
						if (var346 == null) {
							var346 = "";
						}
						stringStack[ssp++] = var346;
						continue;
					}
					if (opcode == 5004) {
						isp--;
						int var347 = intStack[isp];
						int var348 = -1;
						if (var347 < 100 && Client.field2142[var347] != null) {
							var348 = Client.field2139[var347];
						}
						intStack[isp++] = var348;
						continue;
					}
					if (opcode == 5005) {
						if (Client.field680 == null) {
							intStack[isp++] = -1;
						} else {
							intStack[isp++] = Client.field680.field1107;
						}
						continue;
					}
					if (opcode == 5008) {
						ssp--;

						String message = stringStack[ssp];
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
						ssp -= 2;
						String var355 = stringStack[ssp];
						String var356 = stringStack[ssp + 1];
						Client.out.pisaac1(211);
						Client.out.p2(0);
						int var357 = Client.out.pos;
						Client.out.pjstr(var355);
						WordPack.method911(Client.out, var356);
						Client.out.psize2(Client.out.pos - var357);
						continue;
					}
					if (opcode == 5010) {
						isp--;
						int var358 = intStack[isp];
						String var359 = null;
						if (var358 < 100) {
							var359 = Client.field2046[var358];
						}
						if (var359 == null) {
							var359 = "";
						}
						stringStack[ssp++] = var359;
						continue;
					}
					if (opcode == 5011) {
						isp--;
						int var360 = intStack[isp];
						String var361 = null;
						if (var360 < 100) {
							var361 = Client.field2173[var360];
						}
						if (var361 == null) {
							var361 = "";
						}
						stringStack[ssp++] = var361;
						continue;
					}
					if (opcode == 5015) {
						String var362;
						if (Client.localPlayer == null || Client.localPlayer.name == null) {
							var362 = "";
						} else {
							var362 = Client.localPlayer.name;
						}
						stringStack[ssp++] = var362;
						continue;
					}
					if (opcode == 5016) {
						intStack[isp++] = Client.field2146;
						continue;
					}
					if (opcode == 5017) {
						intStack[isp++] = Client.field2141;
						continue;
					}
				}
				throw new IllegalStateException();
			}
		} catch (Exception ex) {
			// OS got the dumbed down output ala RS3
			/*
			StringBuilder builder = new StringBuilder(30);
			builder.append("").append(script.nodeId).append(" ");
			for (int i = fp - 1; i >= 0; i--) {
				builder.append("").append(frames[i].script.nodeId).append(" ");
			}
			builder.append("").append(lastOp);
			JagException.report(builder.toString(), ex);
			*/

			// this 468's exception handler:
			if (script.name != null) {
				// (we don't get script names in official caches, dead code for us)
				StringBuilder builder = new StringBuilder(30);
				builder.append("\n- in:").append(script.name);

				for (int i = fp - 1; i >= 0; i--) {
					builder.append("\n- via:").append(frames[i].script.name);
				}

				if (lastOp == 40) {
					int procId = intOperands[pc];
					// non-existant [sic]
					builder.append("\n- non-existant gosub script-num: ").append(procId);
				}

				if (Client.modewhere == 0) {
					Client.addMessage(0, "Clientscript error in: " + script.name, "");
				}

				JagException.report("CS2 - scr:" + script.nodeId + " op:" + lastOp + builder.toString(), ex);
			} else {
				// since this is the usual codepath, and we're already deviating, might as well add in frame info
				/* start custom code */
				StringBuilder builder = new StringBuilder(30);
				if (Client.modewhere != 0) {
					for (int i = fp - 1; i >= 0; i--) {
						builder.append("\n- via:").append(frames[i].script.nodeId);
					}

					if (lastOp == 40) {
						int procId = intOperands[pc];
						// non-existant [sic]
						builder.append("\n- non-existant gosub script-num: ").append(procId);
					}
				}
				/* end custom code */

				if (Client.modewhere == 0) {
					Client.addMessage(0, "Clientscript error - check log for details", "");
				}

				JagException.report("CS2 - scr:" + script.nodeId + " op:" + lastOp + builder.toString(), ex);
			}
		}
	}

	@ObfuscatedName("r.d(II)V")
	public static void executeOnLoad(int id) {
		if (id == -1 || !IfType.openInterface(id)) {
			return;
		}

		IfType[] all = IfType.interfaces[id];
		for (int i = 0; i < all.length; i++) {
			IfType com = all[i];

			if (com.onload != null) {
				HookRequest req = new HookRequest();
				req.component = com;
				req.onop = com.onload;
				runHook(req);
			}
		}
	}
}
