package jagex3.script;

import deob.ObfuscatedName;
import jagex3.client.Client;
import jagex3.client.JagException;
import jagex3.client.VarProvider;
import jagex3.client.chat.ChatFilterPrivacy;
import jagex3.client.ui.ClientInvCache;
import jagex3.client.ui.IfType;
import jagex3.client.ui.ServerKeyEvents;
import jagex3.client.ui.SubInterface;
import jagex3.config.EnumType;
import jagex3.config.InvType;
import jagex3.config.ObjType;
import jagex3.config.VarBitType;
import jagex3.graphics.PixFont;
import jagex3.graphics.SoftwareFont;
import jagex3.io.Packet;
import jagex3.jstring.JString;
import jagex3.jstring.StringUtil;
import jagex3.jstring.Text;
import jagex3.jstring.TextUtil;
import jagex3.wordfilter.WordPack;

import java.util.Calendar;
import java.util.Date;

// jag::oldscape::ScriptRunner
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
	public static GoSubFrame[] frames = new GoSubFrame[50];

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
	public static void runHook(HookReq req) {
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
			while (true) {
				opcount++;
				if (opcount > 200000) {
					throw new RuntimeException("slow");
				}

				pc++;
				int opcode = instructions[pc];
				lastOp = opcode; // value not saved after deob, but it must be on their end...

				if (opcode < 100) {
					if (opcode == 0) {
						// push_constant_int
						intStack[isp++] = intOperands[pc];
						continue;
					}
					if (opcode == 1) {
						// push_varp
						int var16 = intOperands[pc];
						intStack[isp++] = VarProvider.varps[var16];
						continue;
					}
					if (opcode == 2) {
						// pop_varp
						int var17 = intOperands[pc];
						isp--;
						VarProvider.varps[var17] = intStack[isp];
						continue;
					}
					if (opcode == 3) {
						// push_constant_string
						stringStack[ssp++] = script.stringOperands[pc];
						continue;
					}
					if (opcode == 6) {
						// branch
						pc += intOperands[pc];
						continue;
					}
					if (opcode == 7) {
						// branch_not
						isp -= 2;
						if (intStack[isp + 1] != intStack[isp]) {
							pc += intOperands[pc];
						}
						continue;
					}
					if (opcode == 8) {
						// branch_equals
						isp -= 2;
						if (intStack[isp + 1] == intStack[isp]) {
							pc += intOperands[pc];
						}
						continue;
					}
					if (opcode == 9) {
						// branch_less_than
						isp -= 2;
						if (intStack[isp] < intStack[isp + 1]) {
							pc += intOperands[pc];
						}
						continue;
					}
					if (opcode == 10) {
						// branch_greater_than
						isp -= 2;
						if (intStack[isp] > intStack[isp + 1]) {
							pc += intOperands[pc];
						}
						continue;
					}
					if (opcode == 21) {
						// return
						if (fp == 0) {
							return;
						}

						GoSubFrame frame = frames[--fp];
						script = frame.script;
						instructions = script.instructions;
						intOperands = script.intOperands;
						pc = frame.pc;
						intLocals = frame.intLocals;
						stringLocals = frame.stringLocals;
						continue;
					}
					if (opcode == 25) {
						// push_varbit
						int var19 = intOperands[pc];

						intStack[isp++] = VarProvider.getVarbit(var19);
						continue;
					}
					if (opcode == 27) {
						// pop_varbit
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
						// branch_less_than_or_equals
						isp -= 2;
						if (intStack[isp] <= intStack[isp + 1]) {
							pc += intOperands[pc];
						}
						continue;
					}
					if (opcode == 32) {
						// branch_greater_than_or_equals
						isp -= 2;
						if (intStack[isp] >= intStack[isp + 1]) {
							pc += intOperands[pc];
						}
						continue;
					}
					if (opcode == 33) {
						// push_int_local
						intStack[isp++] = intLocals[intOperands[pc]];
						continue;
					}
					if (opcode == 34) {
						// pop_int_local
						int var10001 = intOperands[pc];

						isp--;
						intLocals[var10001] = intStack[isp];
						continue;
					}
					if (opcode == 35) {
						// push_string_local
						stringStack[ssp++] = stringLocals[intOperands[pc]];
						continue;
					}
					if (opcode == 36) {
						// pop_string_local
						int var10001 = intOperands[pc];

						ssp--;
						stringLocals[var10001] = stringStack[ssp];
						continue;
					}
					if (opcode == 37) {
						// join_string
						int var28 = intOperands[pc];

						ssp -= var28;
						String var29 = StringUtil.method1785(stringStack, ssp, var28);

						stringStack[ssp++] = var29;
						continue;
					}
					if (opcode == 38) {
						// pop_int_discard
						isp--;
						continue;
					}
					if (opcode == 39) {
						// pop_string_discard
						ssp--;
						continue;
					}
					if (opcode == 40) {
						// gosub_with_params
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

						GoSubFrame frame = new GoSubFrame();
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
						// push_varc_int
						intStack[isp++] = Client.field2120[intOperands[pc]];
						continue;
					}
					if (opcode == 43) {
						// pop_varc_int
						int var10001 = intOperands[pc];

						isp--;
						Client.field2120[var10001] = intStack[isp];
						continue;
					}
					if (opcode == 44) {
						// define_array
						int var37 = intOperands[pc] >> 16;
						int var38 = intOperands[pc] & 0xFFFF;

						isp--;
						int var39 = intStack[isp];

						if (var39 < 0 || var39 > 5000) {
							throw new RuntimeException();
						}

						field193[var37] = var39;

						byte var40 = -1;
						if (var38 == 105) {
							var40 = 0;
						}

						for (int var41 = 0; var41 < var39; var41++) {
							field192[var37][var41] = var40;
						}

						continue;
					}
					if (opcode == 45) {
						// push_array_int
						int var42 = intOperands[pc];

						isp--;
						int var43 = intStack[isp];

						if (var43 < 0 || var43 >= field193[var42]) {
							throw new RuntimeException();
						}

						intStack[isp++] = field192[var42][var43];
						continue;

					}
					if (opcode == 46) {
						// pop_array_int
						int var44 = intOperands[pc];

						isp -= 2;
						int var45 = intStack[isp];

						if (var45 < 0 || var45 >= field193[var44]) {
							throw new RuntimeException();
						}

						field192[var44][var45] = intStack[isp + 1];
						continue;
					}
					if (opcode == 47) {
						// push_varc_str
						String var46 = Client.field1996[intOperands[pc]];
						if (var46 == null) {
							var46 = "null";
						}

						stringStack[ssp++] = var46;
						continue;
					}
					if (opcode == 48) {
						// pop_varc_str
						int var10001 = intOperands[pc];

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
						// cc_create
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
							throw new RuntimeException("Gap at:" + (var50 - 1));
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

						Client.requestRedrawComponent(var51);
						continue;
					}
					if (opcode == 101) {
						// cc_delete
						IfType var55 = secondary ? activeComponent2 : activeComponent;
						IfType var56 = IfType.get(var55.parentlayer);

						var56.subcomponents[var55.subid] = null;
						Client.requestRedrawComponent(var56);
						continue;
					}
					if (opcode == 102) {
						// cc_deleteall
						isp--;
						IfType var57 = IfType.get(intStack[isp]);

						var57.subcomponents = null;
						Client.requestRedrawComponent(var57);
						continue;
					}
					if (opcode == 200) {
						// cc_find
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
						// if/cc_setposition
						isp -= 2;
						var61.x = intStack[isp];
						var61.y = intStack[isp + 1];

						Client.requestRedrawComponent(var61);
						continue;
					}
					if (opcode == 1001) {
						// if/cc_setsize
						isp -= 2;
						var61.width = intStack[isp];
						var61.height = intStack[isp + 1];

						Client.requestRedrawComponent(var61);
						continue;
					}
					if (opcode == 1003) {
						// if/cc_sethide
						isp--;
						boolean var62 = intStack[isp] == 1;

						if (var61.hide != var62) {
							var61.hide = var62;

							Client.requestRedrawComponent(var61);
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
						// if/cc_setscrollpos
						isp -= 2;

						var63.scrollX = intStack[isp];
						if (var63.scrollX > var63.scrollWidth - var63.width) {
							var63.scrollX = var63.scrollWidth - var63.width;
						}
						if (var63.scrollX < 0) {
							var63.scrollX = 0;
						}

						var63.scrollY = intStack[isp + 1];
						if (var63.scrollY > var63.scrollHeight - var63.height) {
							var63.scrollY = var63.scrollHeight - var63.height;
						}
						if (var63.scrollY < 0) {
							var63.scrollY = 0;
						}

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1101) {
						// if/cc_setcolour
						isp--;
						var63.colour = intStack[isp];

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1102) {
						// if/cc_setfill
						isp--;
						var63.fill = intStack[isp] == 1;

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1103) {
						// if/cc_settrans
						isp--;
						var63.trans = intStack[isp];

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1104) {
						// if/cc_setlinewid
						isp--;
						var63.lineWidth = intStack[isp];

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1105) {
						// if/cc_setgraphic
						isp--;
						var63.graphic = intStack[isp];

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1106) {
						// if/cc_set2dangle
						isp--;
						var63.angle2d = intStack[isp];

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1107) {
						// if/cc_settiling
						isp--;
						var63.tiling = intStack[isp] == 1;

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1108) {
						// if/cc_setmodel
						var63.modelType = 1;

						isp--;
						var63.model = intStack[isp];

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1109) {
						// if/cc_setmodelangle
						isp -= 6;
						var63.xof = intStack[isp];
						var63.yof = intStack[isp + 1];
						var63.xan = intStack[isp + 2];
						var63.yan = intStack[isp + 3];
						var63.zan = intStack[isp + 4];
						var63.zoom = intStack[isp + 5];

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1110) {
						// if/cc_setmodelanim
						isp--;
						int var64 = intStack[isp];

						if (var63.anim != var64) {
							var63.anim = var64;
							var63.seqFrame = 0;
							var63.seqCycle = 0;

							Client.requestRedrawComponent(var63);
						}
						continue;
					}
					if (opcode == 1111) {
						// if/cc_setmodelorthog
						isp--;
						var63.modelOrthographic = intStack[isp] == 1;

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1112) {
						// if/cc_settext
						ssp--;
						String var65 = stringStack[ssp];

						if (!var65.equals(var63.text)) {
							var63.text = var65;

							Client.requestRedrawComponent(var63);
						}
						continue;
					}
					if (opcode == 1113) {
						// if/cc_settextfont
						isp--;
						var63.font = intStack[isp];

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1114) {
						// if/cc_settextalign
						isp -= 3;
						var63.halign = intStack[isp];
						var63.field1834 = intStack[isp + 1];
						var63.field1832 = intStack[isp + 2];

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1115) {
						// if/cc_settextshadow
						isp--;
						var63.shadowed = intStack[isp] == 1;

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1116) {
						// if/cc_setoutline
						isp--;
						var63.outline = intStack[isp];

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1117) {
						// if/cc_setgraphicshadow
						isp--;
						var63.graphicShadow = intStack[isp];

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1118) {
						// if/cc_setvflip
						isp--;
						var63.vflip = intStack[isp] == 1;

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1119) {
						// if/cc_sethflip
						isp--;
						var63.hflip = intStack[isp] == 1;

						Client.requestRedrawComponent(var63);
						continue;
					}
					if (opcode == 1120) {
						// if/cc_setscrollsize
						isp -= 2;
						var63.scrollWidth = intStack[isp];
						var63.scrollHeight = intStack[isp + 1];

						Client.requestRedrawComponent(var63);
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

					Client.requestRedrawComponent(var66);

					if (opcode == 1200) {
						// if/cc_setobject
						isp -= 2;
						int var67 = intStack[isp];
						int var68 = intStack[isp + 1];

						var66.field1791 = var67;
						var66.field1888 = var68;
						ObjType var69 = ObjType.get(var67);
						var66.xan = var69.xan2d;
						var66.yan = var69.yan2d;
						var66.zan = var69.zan2d;
						var66.xof = var69.xof2d;
						var66.yof = var69.yof2d;
						var66.zoom = var69.zoom2d;
						if (var66.width > 0) {
							var66.zoom = var66.zoom * 32 / var66.width;
						}
						continue;
					}
					if (opcode == 1201) {
						// if/cc_setnpchead
						var66.modelType = 2;

						isp--;
						var66.model = intStack[isp];
						continue;
					}
					if (opcode == 1202) {
						// if/cc_setplayerhead_self
						var66.modelType = 3;

						var66.model = Client.localPlayer.model.method1176();
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
						// if/cc_setop
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
						// if/cc_setdraggable
						isp -= 2;
						int var72 = intStack[isp];
						int var73 = intStack[isp + 1];

						var70.field1845 = IfType.method947(var72, var73);
						continue;
					}
					if (opcode == 1302) {
						// if/cc_setdraggablebehavior
						isp--;
						var70.field1858 = intStack[isp] == 1;
						continue;
					}
					if (opcode == 1303) {
						// if/cc_setdragdeadzone
						isp--;
						var70.field1846 = intStack[isp];
						continue;
					}
					if (opcode == 1304) {
						// if/cc_setdragdeadtime
						isp--;
						var70.field1887 = intStack[isp];
						continue;
					}
					if (opcode == 1305) {
						// if/cc_setopbase
						ssp--;
						var70.field1795 = stringStack[ssp];
						continue;
					}
					if (opcode == 1306) {
						// if/cc_settargetverb
						ssp--;
						var70.targetVerb = stringStack[ssp];
						continue;
					}
					if (opcode == 1307) {
						// if/cc_clearops
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
						// if/cc_setonclick
						var74.field1852 = var78;
					}
					if (opcode == 1401) {
						// if/cc_setonhold
						var74.field1855 = var78;
					}
					if (opcode == 1402) {
						// if/cc_setonrelease
						var74.field1851 = var78;
					}
					if (opcode == 1403) {
						// if/cc_setonmouseover
						var74.field1856 = var78;
					}
					if (opcode == 1404) {
						// if/cc_setonmouseleave
						var74.field1838 = var78;
					}
					if (opcode == 1405) {
						// if/cc_setondrag
						var74.field1781 = var78;
					}
					if (opcode == 1406) {
						// if/cc_setontargetleave
						var74.field1836 = var78;
					}
					if (opcode == 1407) {
						// if/cc_setonvartransmit
						var74.field1839 = var78;
						var74.field1889 = var76;
					}
					if (opcode == 1408) {
						// if/cc_setontimer
						var74.field1869 = var78;
					}
					if (opcode == 1409) {
						// if/cc_setonop
						var74.field1847 = var78;
					}
					if (opcode == 1410) {
						// if/cc_setondragcomplete
						var74.field1860 = var78;
					}
					if (opcode == 1411) {
						// if/cc_setonclickrepeat
						var74.field1853 = var78;
					}
					if (opcode == 1412) {
						// if/cc_setonmouserepeat
						var74.field1857 = var78;
					}
					if (opcode == 1414) {
						// if/cc_setoninvtransmit
						var74.field1865 = var78;
						var74.field1866 = var76;
					}
					if (opcode == 1415) {
						// if/cc_setonstattransmit
						var74.field1867 = var78;
						var74.field1868 = var76;
					}
					if (opcode == 1416) {
						// if/cc_setontargetenter
						var74.field1861 = var78;
					}
					if (opcode == 1417) {
						// if/cc_setonscrollwheel
						var74.field1831 = var78;
					}
					if (opcode == 1418) {
						// if/cc_setonchattransmit
						var74.field1872 = var78;
					}
					if (opcode == 1419) {
						// if/cc_setonkey
						var74.field1873 = var78;
					}
					if (opcode == 1420) {
						// if/cc_setonfriendtransmit
						var74.field1877 = var78;
					}
					if (opcode == 1421) {
						// if/cc_setonclantransmit
						var74.field1875 = var78;
					}
					if (opcode == 1422) {
						// if/cc_setonmisctransmit
						var74.field1777 = var78;
					}
					if (opcode == 1423) {
						// if/cc_setondialogabort
						var74.field1819 = var78;
					}
					if (opcode == 1424) {
						// if/cc_setonsubchange
						var74.field1878 = var78;
					}
					var74.field1813 = true;
					continue;
				} else if (opcode < 1600) {
					IfType var81 = secondary ? activeComponent2 : activeComponent;
					if (opcode == 1500) {
						// cc_x
						intStack[isp++] = var81.x;
						continue;
					}
					if (opcode == 1501) {
						// cc_y
						intStack[isp++] = var81.y;
						continue;
					}
					if (opcode == 1502) {
						// cc_getwidth
						intStack[isp++] = var81.width;
						continue;
					}
					if (opcode == 1503) {
						// cc_getheight
						intStack[isp++] = var81.height;
						continue;
					}
					if (opcode == 1504) {
						// cc_gethide
						intStack[isp++] = var81.hide ? 1 : 0;
						continue;
					}
					if (opcode == 1505) {
						// cc_getlayer
						intStack[isp++] = var81.layerid;
						continue;
					}
				} else if (opcode < 1700) {
					IfType var82 = secondary ? activeComponent2 : activeComponent;
					if (opcode == 1600) {
						// cc_getscrollx
						intStack[isp++] = var82.scrollX;
						continue;
					}
					if (opcode == 1601) {
						// cc_getscrolly
						intStack[isp++] = var82.scrollY;
						continue;
					}
					if (opcode == 1602) {
						// cc_gettext
						stringStack[ssp++] = var82.text;
						continue;
					}
					if (opcode == 1603) {
						// cc_getscrollwidth
						intStack[isp++] = var82.scrollWidth;
						continue;
					}
					if (opcode == 1604) {
						// cc_getscrollheight
						intStack[isp++] = var82.scrollHeight;
						continue;
					}
					if (opcode == 1605) {
						// cc_getmodelzoom
						intStack[isp++] = var82.zoom;
						continue;
					}
					if (opcode == 1606) {
						// cc_getmodelangle_x
						intStack[isp++] = var82.xan;
						continue;
					}
					if (opcode == 1607) {
						// cc_getmodelangle_z
						intStack[isp++] = var82.zan;
						continue;
					}
					if (opcode == 1608) {
						// cc_getmodelangle_y
						intStack[isp++] = var82.yan;
						continue;
					}
				} else if (opcode < 1800) {
					IfType var83 = secondary ? activeComponent2 : activeComponent;
					if (opcode == 1700) {
						// cc_getinvobject
						intStack[isp++] = var83.field1791;
						continue;
					}
					if (opcode == 1701) {
						// cc_getinvcount
						if (var83.field1791 == -1) {
							intStack[isp++] = 0;
						} else {
							intStack[isp++] = var83.field1888;
						}
						continue;
					}
					if (opcode == 1702) {
						// cc_getid
						intStack[isp++] = var83.subid;
						continue;
					}
				} else if (opcode < 1900) {
					IfType var84 = secondary ? activeComponent2 : activeComponent;
					if (opcode == 1800) {
						// cc_gettargetmask
						intStack[isp++] = ServerKeyEvents.getTargetMask(Client.method1512(var84));
						continue;
					}
					if (opcode == 1801) {
						// cc_getop
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
						// cc_getopbase
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
						// if_getx
						intStack[isp++] = var86.x;
						continue;
					}
					if (opcode == 2501) {
						// if_gety
						intStack[isp++] = var86.y;
						continue;
					}
					if (opcode == 2502) {
						// if_getwidth
						intStack[isp++] = var86.width;
						continue;
					}
					if (opcode == 2503) {
						// if_getheight
						intStack[isp++] = var86.height;
						continue;
					}
					if (opcode == 2504) {
						// if_gethide
						intStack[isp++] = var86.hide ? 1 : 0;
						continue;
					}
					if (opcode == 2505) {
						// if_getlayer
						intStack[isp++] = var86.layerid;
						continue;
					}
				} else if (opcode < 2700) {
					isp--;
					IfType var87 = IfType.get(intStack[isp]);
					if (opcode == 2600) {
						// if_getscrollx
						intStack[isp++] = var87.scrollX;
						continue;
					}
					if (opcode == 2601) {
						// if_getscrolly
						intStack[isp++] = var87.scrollY;
						continue;
					}
					if (opcode == 2602) {
						// if_gettext
						stringStack[ssp++] = var87.text;
						continue;
					}
					if (opcode == 2603) {
						// if_getscrollwidth
						intStack[isp++] = var87.scrollWidth;
						continue;
					}
					if (opcode == 2604) {
						// if_getscrollheight
						intStack[isp++] = var87.scrollHeight;
						continue;
					}
					if (opcode == 2605) {
						// if_getmodelzoom
						intStack[isp++] = var87.zoom;
						continue;
					}
					if (opcode == 2606) {
						// if_getmodelangle_x
						intStack[isp++] = var87.xan;
						continue;
					}
					if (opcode == 2607) {
						// if_getmodelangle_z
						intStack[isp++] = var87.zan;
						continue;
					}
					if (opcode == 2608) {
						// if_getmodelangle_y
						intStack[isp++] = var87.yan;
						continue;
					}
				} else if (opcode < 2800) {
					if (opcode == 2700) {
						// if_getinvobject
						isp--;

						IfType var88 = IfType.get(intStack[isp]);
						intStack[isp++] = var88.field1791;
						continue;
					}
					if (opcode == 2701) {
						// if_getinvcount
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
						// if_hassub
						isp--;
						int var90 = intStack[isp];

						SubInterface var91 = (SubInterface) Client.field1918.get(var90);
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
						// if_gettargetmask
						intStack[isp++] = ServerKeyEvents.getTargetMask(Client.method1512(var92));
						continue;
					}
					if (opcode == 2801) {
						// if_getop
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
						// if_getopbase
						if (var92.field1795 == null) {
							stringStack[ssp++] = "";
						} else {
							stringStack[ssp++] = var92.field1795;
						}
						continue;
					}
				} else if (opcode < 3200) {
					if (opcode == 3100) {
						// mes
						ssp--;
						String var94 = stringStack[ssp];

						Client.addMessage(0, "", var94);
						continue;
					}
					if (opcode == 3101) {
						// anim
						isp -= 2;

						Client.method1040(Client.localPlayer, intStack[isp], intStack[isp + 1]);
						continue;
					}
					if (opcode == 3103) {
						// if_close
						Client.imethod47();
						continue;
					}
					if (opcode == 3104) {
						// resume_countdialog
						ssp--;
						String var96 = stringStack[ssp];

						int var97 = 0;
						if (StringUtil.method62(var96)) {
							int var98 = StringUtil.method91(var96, 10, true);
							var97 = var98;
						}

						Client.out.pisaac1(27);
						Client.out.p4(var97);
						continue;
					}
					if (opcode == 3105) {
						// resume_namedialog
						ssp--;
						String var99 = stringStack[ssp];

						Client.out.pisaac1(223);
						Client.out.p1(var99.length() + 1);
						Client.out.pjstr(var99);
						continue;
					}
					if (opcode == 3106) {
						// resume_stringdialog
						ssp--;
						String var100 = stringStack[ssp];

						Client.out.pisaac1(127);
						Client.out.p1(var100.length() + 1);
						Client.out.pjstr(var100);
						continue;
					}
					if (opcode == 3107) {
						// opplayer
						isp--;
						int var101 = intStack[isp];

						ssp--;
						String var102 = stringStack[ssp];

						Client.method558(var101, var102);
						continue;
					}
					if (opcode == 3108) {
						// if_dragpickup
						isp -= 3;
						int var103 = intStack[isp];
						int var104 = intStack[isp + 1];
						int var105 = intStack[isp + 2];

						IfType var106 = IfType.get(var105);
						Client.method1102(var106, var103, var104);
						continue;
					}
					if (opcode == 3109) {
						// cc_dragpickup
						isp -= 2;
						int var107 = intStack[isp];
						int var108 = intStack[isp + 1];

						IfType var109 = secondary ? activeComponent2 : activeComponent;
						Client.method1102(var109, var107, var108);
						continue;
					}
				} else if (opcode < 3300) {
					if (opcode == 3200) {
						// sound_synth
						isp -= 3;

						Client.imethod46(intStack[isp], intStack[isp + 1], intStack[isp + 2]);
						continue;
					}
					if (opcode == 3201) {
						// sound_song
						isp--;

						Client.method1232(intStack[isp]);
						continue;
					}
					if (opcode == 3202) {
						// sound_jingle
						isp -= 2;

						Client.imethod45(intStack[isp], intStack[isp + 1]);
						continue;
					}
				} else if (opcode < 3400) {
					if (opcode == 3300) {
						// clientclock
						intStack[isp++] = Client.loopCycle;
						continue;
					}
					if (opcode == 3301) {
						// inv_getobj
						isp -= 2;
						int var115 = intStack[isp];
						int var116 = intStack[isp + 1];

						intStack[isp++] = ClientInvCache.getObj(var115, var116);
						continue;
					}
					if (opcode == 3302) {
						// inv_getnum
						isp -= 2;
						int var121 = intStack[isp];
						int var122 = intStack[isp + 1];

						intStack[isp++] = ClientInvCache.getNum(var121, var122);
						continue;
					}
					if (opcode == 3303) {
						// inv_total
						isp -= 2;
						int var123 = intStack[isp];
						int var124 = intStack[isp + 1];

						intStack[isp++] = ClientInvCache.getTotal(var123, var124);
						continue;
					}
					if (opcode == 3304) {
						// inv_size
						isp--;
						int var125 = intStack[isp];

						intStack[isp++] = InvType.get(var125).size;
						continue;
					}
					if (opcode == 3305) {
						// stat
						isp--;
						int var132 = intStack[isp];

						intStack[isp++] = Client.skillLevel[var132];
						continue;
					}
					if (opcode == 3306) {
						// stat_base
						isp--;
						int var133 = intStack[isp];

						intStack[isp++] = Client.skillBaseLevel[var133];
						continue;
					}
					if (opcode == 3307) {
						// stat_xp
						isp--;
						int var134 = intStack[isp];

						intStack[isp++] = Client.skillExperience[var134];
						continue;
					}
					if (opcode == 3308) {
						// coord
						int var135 = Client.minusedlevel;
						int var136 = (Client.localPlayer.x >> 7) + Client.sceneBaseTileX;
						int var137 = (Client.localPlayer.z >> 7) + Client.sceneBaseTileZ;

						intStack[isp++] = (var135 << 28) + (var136 << 14) + var137;
						continue;
					}
					if (opcode == 3309) {
						// coordx
						isp--;
						int var138 = intStack[isp];

						intStack[isp++] = var138 >> 14 & 0x3FFF;
						continue;
					}
					if (opcode == 3310) {
						// coordy
						isp--;
						int var139 = intStack[isp];

						intStack[isp++] = var139 >> 28;
						continue;
					}
					if (opcode == 3311) {
						// coordz
						isp--;
						int var140 = intStack[isp];

						intStack[isp++] = var140 & 0x3FFF;
						continue;
					}
					if (opcode == 3312) {
						// map_members
						intStack[isp++] = Client.members ? 1 : 0;
						continue;
					}
					if (opcode == 3313) {
						// invother_getobj
						isp -= 2;
						int var141 = intStack[isp] + 32768;
						int var142 = intStack[isp + 1];

						intStack[isp++] = ClientInvCache.getObj(var141, var142);
						continue;
					}
					if (opcode == 3314) {
						// invother_getnum
						isp -= 2;
						int var147 = intStack[isp] + 32768;
						int var148 = intStack[isp + 1];

						intStack[isp++] = ClientInvCache.getNum(var147, var148);
						continue;
					}
					if (opcode == 3315) {
						// invother_total
						isp -= 2;
						int var149 = intStack[isp] + 32768;
						int var150 = intStack[isp + 1];

						intStack[isp++] = ClientInvCache.getTotal(var149, var150);
						continue;
					}
					if (opcode == 3316) {
						// staffmodlevel
						if (Client.staffmodlevel >= 2) {
							intStack[isp++] = Client.staffmodlevel;
						} else {
							intStack[isp++] = 0;
						}
						continue;
					}
					if (opcode == 3317) {
						// reboottimer
						intStack[isp++] = Client.rebootTimer;
						continue;
					}
					if (opcode == 3318) {
						// map_world
						intStack[isp++] = Client.worldid;
						continue;
					}
					if (opcode == 3321) {
						// runenergy_visible
						intStack[isp++] = Client.runEnergy;
						continue;
					}
					if (opcode == 3322) {
						// runweight_visible
						intStack[isp++] = Client.runWeight;
						continue;
					}
					if (opcode == 3323) {
						// playermod
						if (Client.field2091) {
							intStack[isp++] = 1;
						} else {
							intStack[isp++] = 0;
						}
						continue;
					}
				} else if (opcode < 3500) {
					if (opcode == 3400) {
						// enum_string
						isp -= 2;
						int var151 = intStack[isp];
						int var152 = intStack[isp + 1];

						EnumType var153 = EnumType.get(var151);
						if (var153.outputtype != 's') {
							// ?
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
						// enum
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
						// friend_count
						if (Client.field2171 == 0) {
							intStack[isp++] = -2;
						} else if (Client.field2171 == 1) {
							intStack[isp++] = -1;
						} else {
							intStack[isp++] = Client.friendCount;
						}
						continue;
					}
					if (opcode == 3601) {
						// friend_getname
						isp--;

						int var161 = intStack[isp];
						if (Client.field2171 == 2 && var161 < Client.friendCount) {
							stringStack[ssp++] = Client.friendList[var161].name;
							continue;
						}

						stringStack[ssp++] = "";
						continue;
					}
					if (opcode == 3602) {
						// friend_getworld
						isp--;

						int var162 = intStack[isp];
						if (Client.field2171 == 2 && var162 < Client.friendCount) {
							intStack[isp++] = Client.friendList[var162].field174;
							continue;
						}

						intStack[isp++] = 0;
						continue;
					}
					if (opcode == 3603) {
						// friend_getrank
						isp--;
						int var163 = intStack[isp];

						if (Client.field2171 == 2 && var163 < Client.friendCount) {
							intStack[isp++] = Client.friendList[var163].field175;
							continue;
						}

						intStack[isp++] = 0;
						continue;
					}
					if (opcode == 3604) {
						// friend_setrank
						ssp--;
						String var164 = stringStack[ssp];

						isp--;
						int var165 = intStack[isp];

						Client.imethod44(var164, var165);
						continue;
					}
					if (opcode == 3605) {
						// friend_add
						ssp--;
						String var166 = stringStack[ssp];

						Client.method1103(var166);
						continue;
					}
					if (opcode == 3606) {
						// friend_del
						ssp--;
						String var167 = stringStack[ssp];

						Client.method560(var167);
						continue;
					}
					if (opcode == 3607) {
						// ignore_add
						ssp--;
						String var168 = stringStack[ssp];

						Client.method315(var168, false);
						continue;
					}
					if (opcode == 3608) {
						// ignore_del
						ssp--;
						String var169 = stringStack[ssp];

						Client.imethod43(var169);
						continue;
					}
					if (opcode == 3609) {
						// friend_test
						ssp--;
						String var177 = stringStack[ssp];

						if (var177.startsWith(TextUtil.imgTag(0)) || var177.startsWith(TextUtil.imgTag(1))) {
							var177 = var177.substring(7);
						}

						intStack[isp++] = Client.isFriend(var177) ? 1 : 0;
						continue;
					}
					if (opcode == 3611) {
						// clan_getchatdisplayname
						if (Client.field1955 == null) {
							stringStack[ssp++] = "";
						} else {
							stringStack[ssp++] = JString.imethod1(Client.field1955);
						}
						continue;
					}
					if (opcode == 3612) {
						// clan_getchatcount
						if (Client.field1955 == null) {
							intStack[isp++] = 0;
						} else {
							intStack[isp++] = Client.field1220;
						}
						continue;
					}
					if (opcode == 3613) {
						// clan_getchatusername
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
						// clan_getchatuserworld
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
						// clan_getchatuserrank
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
						// clan_getchatminkick
						intStack[isp++] = Client.field1511;
						continue;
					}
					if (opcode == 3617) {
						// clan_kickuser
						ssp--;
						String var186 = stringStack[ssp];

						Client.clanKickUser(var186);
						continue;
					}
					if (opcode == 3618) {
						// clan_getchatrank
						intStack[isp++] = Client.field1217;
						continue;
					}
					if (opcode == 3619) {
						// clan_joinchat
						ssp--;
						String var187 = stringStack[ssp];

						Client.clanJoinChat(var187);
						continue;
					}
					if (opcode == 3620) {
						// clan_leavechat
						Client.clanLeaveChat();
						continue;
					}
					if (opcode == 3621) {
						// ignore_count
						if (Client.field2171 == 0) {
							intStack[isp++] = -1;
						} else {
							intStack[isp++] = Client.ignoreCount;
						}
						continue;
					}
					if (opcode == 3622) {
						// ignore_getname
						isp--;
						int var188 = intStack[isp];

						if (Client.field2171 != 0 && var188 < Client.ignoreCount) {
							stringStack[ssp++] = Client.ignoreList[var188].name;
							continue;
						}

						stringStack[ssp++] = "";
						continue;
					}
					if (opcode == 3623) {
						// ignore_test
						ssp--;
						String var189 = stringStack[ssp];

						if (var189.startsWith(TextUtil.imgTag(0)) || var189.startsWith(TextUtil.imgTag(1))) {
							var189 = var189.substring(7);
						}

						intStack[isp++] = Client.isIgnored(var189) ? 1 : 0;
						continue;
					}
					if (opcode == 3624) {
						// clan_isself
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
						// clan_getchatownername
						if (Client.field2155 == null) {
							stringStack[ssp++] = "";
						} else {
							stringStack[ssp++] = JString.imethod1(Client.field2155);
						}
						continue;
					}
				} else if (opcode < 4100) {
					if (opcode == 4000) {
						// add
						isp -= 2;
						int var196 = intStack[isp];
						int var197 = intStack[isp + 1];

						intStack[isp++] = var196 + var197;
						continue;
					}
					if (opcode == 4001) {
						// sub
						isp -= 2;
						int var198 = intStack[isp];
						int var199 = intStack[isp + 1];

						intStack[isp++] = var198 - var199;
						continue;
					}
					if (opcode == 4002) {
						// multiply
						isp -= 2;
						int var200 = intStack[isp];
						int var201 = intStack[isp + 1];

						intStack[isp++] = var200 * var201;
						continue;
					}
					if (opcode == 4003) {
						// divide
						isp -= 2;
						int var202 = intStack[isp];
						int var203 = intStack[isp + 1];

						intStack[isp++] = var202 / var203;
						continue;
					}
					if (opcode == 4004) {
						// random
						isp--;
						int var204 = intStack[isp];

						intStack[isp++] = (int) (Math.random() * (double) var204);
						continue;
					}
					if (opcode == 4005) {
						// randominc
						isp--;
						int var205 = intStack[isp];

						intStack[isp++] = (int) (Math.random() * (double) (var205 + 1));
						continue;
					}
					if (opcode == 4006) {
						// interpolate
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
						// addpercent
						isp -= 2;
						int var211 = intStack[isp];
						int var212 = intStack[isp + 1];

						intStack[isp++] = var211 * var212 / 100 + var211;
						continue;
					}
					if (opcode == 4008) {
						// setbit
						isp -= 2;
						int var213 = intStack[isp];
						int var214 = intStack[isp + 1];

						intStack[isp++] = var213 | 0x1 << var214;
						continue;
					}
					if (opcode == 4009) {
						// clearbit
						isp -= 2;
						int var215 = intStack[isp];
						int var216 = intStack[isp + 1];

						intStack[isp++] = var215 & -1 - (0x1 << var216);
						continue;
					}
					if (opcode == 4010) {
						// testbit
						isp -= 2;
						int var217 = intStack[isp];
						int var218 = intStack[isp + 1];

						intStack[isp++] = (var217 & 0x1 << var218) == 0 ? 0 : 1;
						continue;
					}
					if (opcode == 4011) {
						// modulo
						isp -= 2;
						int var219 = intStack[isp];
						int var220 = intStack[isp + 1];

						intStack[isp++] = var219 % var220;
						continue;
					}
					if (opcode == 4012) {
						// pow
						isp -= 2;
						int var221 = intStack[isp];
						int var222 = intStack[isp + 1];

						if (var221 == 0) {
							intStack[isp++] = 0;
						} else {
							intStack[isp++] = (int) Math.pow(var221, var222);
						}
						continue;
					}
					if (opcode == 4013) {
						// invpow
						isp -= 2;
						int var223 = intStack[isp];
						int var224 = intStack[isp + 1];

						if (var223 == 0) {
							intStack[isp++] = 0;
						} else if (var224 == 0) {
							intStack[isp++] = Integer.MAX_VALUE;
						} else {
							intStack[isp++] = (int) Math.pow(var223, 1.0D / (double) var224);
						}
						continue;
					}
					if (opcode == 4014) {
						// and
						isp -= 2;
						int var225 = intStack[isp];
						int var226 = intStack[isp + 1];

						intStack[isp++] = var225 & var226;
						continue;
					}
					if (opcode == 4015) {
						// or
						isp -= 2;
						int var227 = intStack[isp];
						int var228 = intStack[isp + 1];

						intStack[isp++] = var227 | var228;
						continue;
					}
				} else if (opcode < 4200) {
					if (opcode == 4100) {
						// append_num
						ssp--;
						String var229 = stringStack[ssp];

						isp--;
						int var230 = intStack[isp];

						stringStack[ssp++] = var229 + var230;
						continue;
					}
					if (opcode == 4101) {
						// append
						ssp -= 2;
						String var231 = stringStack[ssp];
						String var232 = stringStack[ssp + 1];

						stringStack[ssp++] = var231 + var232;
						continue;
					}
					if (opcode == 4102) {
						// append_signnum
						ssp--;
						String var233 = stringStack[ssp];

						isp--;
						int var234 = intStack[isp];

						stringStack[ssp++] = var233 + StringUtil.method903(var234, true);
						continue;
					}
					if (opcode == 4103) {
						// lowercase
						ssp--;
						String var235 = stringStack[ssp];

						stringStack[ssp++] = var235.toLowerCase();
						continue;
					}
					if (opcode == 4104) {
						// fromdate
						isp--;
						int var236 = intStack[isp];

						long var237 = ((long) var236 + 11745L) * 86400000L;
						field197.setTime(new Date(var237));
						int var239 = field197.get(Calendar.DATE);
						int var240 = field197.get(Calendar.MONTH);
						int var241 = field197.get(Calendar.YEAR);
						stringStack[ssp++] = var239 + "-" + field190[var240] + "-" + var241;
						continue;
					}
					if (opcode == 4105) {
						// text_gender
						ssp -= 2;
						String var242 = stringStack[ssp];
						String var243 = stringStack[ssp + 1];

						if (Client.localPlayer.model != null && Client.localPlayer.model.field1222) {
							stringStack[ssp++] = var243;
							continue;
						}

						stringStack[ssp++] = var242;
						continue;
					}
					if (opcode == 4106) {
						// tostring
						isp--;
						int var244 = intStack[isp];

						stringStack[ssp++] = Integer.toString(var244);
						continue;
					}
					if (opcode == 4107) {
						// compare
						ssp -= 2;

						intStack[isp++] = StringUtil.compare(stringStack[ssp], stringStack[ssp + 1]);
						continue;
					}
					if (opcode == 4108) {
						// paraheight
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
						// parawidth
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
						// text_switch
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
						// escape
						ssp--;
						String var293 = stringStack[ssp];

						stringStack[ssp++] = PixFont.method2844(var293);
						continue;
					}
					if (opcode == 4112) {
						// append_char
						ssp--;
						String var294 = stringStack[ssp];

						isp--;
						int var295 = intStack[isp];

						stringStack[ssp++] = var294 + (char) var295;
						continue;
					}
					if (opcode == 4113) {
						// char_isprintable
						isp--;
						int var296 = intStack[isp];

						intStack[isp++] = StringUtil.isPrintable((char) var296) ? 1 : 0;
						continue;
					}
					if (opcode == 4114) {
						// char_isalphanumeric
						isp--;
						int var301 = intStack[isp];

						intStack[isp++] = StringUtil.isAlphaNumeric((char) var301) ? 1 : 0;
						continue;
					}
					if (opcode == 4115) {
						// char_isalpha
						isp--;
						int var306 = intStack[isp];

						intStack[isp++] = StringUtil.isAlpha((char) var306) ? 1 : 0;
						continue;
					}
					if (opcode == 4116) {
						// char_isnumeric
						isp--;
						int var307 = intStack[isp];

						intStack[isp++] = StringUtil.isNumeric((char) var307) ? 1 : 0;
						continue;
					}
					if (opcode == 4117) {
						// string_length
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
						// substring
						ssp--;
						String var313 = stringStack[ssp];

						isp -= 2;
						int var314 = intStack[isp];
						int var315 = intStack[isp + 1];

						stringStack[ssp++] = var313.substring(var314, var315);
						continue;
					}
					if (opcode == 4119) {
						// removetags
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
						// string_indexof_char
						ssp--;
						String var321 = stringStack[ssp];

						isp--;
						int var322 = intStack[isp];

						intStack[isp++] = var321.indexOf(var322);
						continue;
					}
				} else if (opcode < 4300) {
					if (opcode == 4200) {
						// oc_name
						isp--;
						int var323 = intStack[isp];

						stringStack[ssp++] = ObjType.get(var323).name;
						continue;
					}
					if (opcode == 4201) {
						// oc_op
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
						// oc_iop
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
						// oc_cost
						isp--;
						int var330 = intStack[isp];

						intStack[isp++] = ObjType.get(var330).cost;
						continue;
					}
					if (opcode == 4204) {
						// oc_stackable
						isp--;
						int var331 = intStack[isp];

						intStack[isp++] = ObjType.get(var331).stackable == 1 ? 1 : 0;
						continue;
					}
					if (opcode == 4205) {
						// oc_cert
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
						// oc_uncert
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
						// oc_members
						isp--;
						int var336 = intStack[isp];

						intStack[isp++] = ObjType.get(var336).members ? 1 : 0;
						continue;
					}
				} else if (opcode < 5100) {
					if (opcode == 5000) {
						// chat_getfilter_public
						intStack[isp++] = Client.publicChatFilter;
						continue;
					}
					if (opcode == 5001) {
						// chat_setfilter
						isp -= 3;
						Client.publicChatFilter = intStack[isp];
						Client.privateChatFilter = ChatFilterPrivacy.get(intStack[isp + 1]);
						if (Client.privateChatFilter == null) {
							Client.privateChatFilter = ChatFilterPrivacy.field1106;
						}
						Client.tradeChatFilter = intStack[isp + 2];

						Client.out.pisaac1(167);
						Client.out.p1(Client.publicChatFilter);
						Client.out.p1(Client.privateChatFilter.index);
						Client.out.p1(Client.tradeChatFilter);
						continue;
					}
					if (opcode == 5002) {
						// chat_sendabusereport
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
						// chat_gethistory_bytypeandline
						isp--;
						int var345 = intStack[isp];

						String var346 = null;
						if (var345 < 100) {
							var346 = Client.messageText[var345];
						}

						if (var346 == null) {
							var346 = "";
						}

						stringStack[ssp++] = var346;
						continue;
					}
					if (opcode == 5004) {
						// chat_gethistory_byuid
						isp--;
						int var347 = intStack[isp];

						int var348 = -1;
						if (var347 < 100 && Client.messageText[var347] != null) {
							var348 = Client.messageType[var347];
						}

						intStack[isp++] = var348;
						continue;
					}
					if (opcode == 5005) {
						// chat_getfilter_private
						// rs3
						if (Client.privateChatFilter == null) {
							intStack[isp++] = -1;
						} else {
							intStack[isp++] = Client.privateChatFilter.index;
						}
						continue;
					}
					if (opcode == 5008) {
						// chat_sendpublic
						ssp--;
						String message = stringStack[ssp];

						if (message.startsWith("::")) {
							Client.doCheat(message);
						} else {
							String colorLower = message.toLowerCase();
							byte color = 0;
							if (colorLower.startsWith(Text.CHATCOL_YELLOW)) {
								color = 0;
								message = message.substring(Text.CHATCOL_YELLOW.length());
							} else if (colorLower.startsWith(Text.CHATCOL_RED)) {
								color = 1;
								message = message.substring(Text.CHATCOL_RED.length());
							} else if (colorLower.startsWith(Text.CHATCOL_GREEN)) {
								color = 2;
								message = message.substring(Text.CHATCOL_GREEN.length());
							} else if (colorLower.startsWith(Text.CHATCOL_CYAN)) {
								color = 3;
								message = message.substring(Text.CHATCOL_CYAN.length());
							} else if (colorLower.startsWith(Text.CHATCOL_PURPLE)) {
								color = 4;
								message = message.substring(Text.CHATCOL_PURPLE.length());
							} else if (colorLower.startsWith(Text.CHATCOL_WHITE)) {
								color = 5;
								message = message.substring(Text.CHATCOL_WHITE.length());
							} else if (colorLower.startsWith(Text.CHATEFFECT_FLASH1)) {
								color = 6;
								message = message.substring(Text.CHATEFFECT_FLASH1.length());
							} else if (colorLower.startsWith(Text.CHATEFFECT_FLASH2)) {
								color = 7;
								message = message.substring(Text.CHATEFFECT_FLASH2.length());
							} else if (colorLower.startsWith(Text.CHATEFFECT_FLASH3)) {
								color = 8;
								message = message.substring(Text.CHATEFFECT_FLASH3.length());
							} else if (colorLower.startsWith(Text.CHATEFFECT_GLOW1)) {
								color = 9;
								message = message.substring(Text.CHATEFFECT_GLOW1.length());
							} else if (colorLower.startsWith(Text.CHATEFFECT_GLOW2)) {
								color = 10;
								message = message.substring(Text.CHATEFFECT_GLOW2.length());
							} else if (colorLower.startsWith(Text.CHATEFFECT_GLOW3)) {
								color = 11;
								message = message.substring(Text.CHATEFFECT_GLOW3.length());
							} else if (Client.lang != 0) {
								if (colorLower.startsWith(Text.CHATCOL_YELLOW_GER)) {
									color = 0;
									message = message.substring(Text.CHATCOL_YELLOW_GER.length());
								} else if (colorLower.startsWith(Text.CHATCOL_RED_GER)) {
									color = 1;
									message = message.substring(Text.CHATCOL_RED_GER.length());
								} else if (colorLower.startsWith(Text.CHATCOL_GREEN_GER)) {
									color = 2;
									message = message.substring(Text.CHATCOL_GREEN_GER.length());
								} else if (colorLower.startsWith(Text.CHATCOL_CYAN_GER)) {
									color = 3;
									message = message.substring(Text.CHATCOL_CYAN_GER.length());
								} else if (colorLower.startsWith(Text.CHATCOL_PURPLE_GER)) {
									color = 4;
									message = message.substring(Text.CHATCOL_PURPLE_GER.length());
								} else if (colorLower.startsWith(Text.CHATCOL_WHITE_GER)) {
									color = 5;
									message = message.substring(Text.CHATCOL_WHITE_GER.length());
								} else if (colorLower.startsWith(Text.CHATEFFECT_FLASH1_GER)) {
									color = 6;
									message = message.substring(Text.CHATEFFECT_FLASH1_GER.length());
								} else if (colorLower.startsWith(Text.CHATEFFECT_FLASH2_GER)) {
									color = 7;
									message = message.substring(Text.CHATEFFECT_FLASH2_GER.length());
								} else if (colorLower.startsWith(Text.CHATEFFECT_FLASH3_GER)) {
									color = 8;
									message = message.substring(Text.CHATEFFECT_FLASH3_GER.length());
								} else if (colorLower.startsWith(Text.CHATEFFECT_GLOW1_GER)) {
									color = 9;
									message = message.substring(Text.CHATEFFECT_GLOW1_GER.length());
								} else if (colorLower.startsWith(Text.CHATEFFECT_GLOW2_GER)) {
									color = 10;
									message = message.substring(Text.CHATEFFECT_GLOW2_GER.length());
								} else if (colorLower.startsWith(Text.CHATEFFECT_GLOW3_GER)) {
									color = 11;
									message = message.substring(Text.CHATEFFECT_GLOW3_GER.length());
								}
							}

							String effectLower = message.toLowerCase();
							byte effect = 0;
							if (effectLower.startsWith(Text.CHATEFFECT_WAVE)) {
								effect = 1;
								message = message.substring(Text.CHATEFFECT_WAVE.length());
							} else if (effectLower.startsWith(Text.CHATEFFECT_WAVE2)) {
								effect = 2;
								message = message.substring(Text.CHATEFFECT_WAVE2.length());
							} else if (effectLower.startsWith(Text.CHATEFFECT_SHAKE)) {
								effect = 3;
								message = message.substring(Text.CHATEFFECT_SHAKE.length());
							} else if (effectLower.startsWith(Text.CHATEFFECT_SCROLL)) {
								effect = 4;
								message = message.substring(Text.CHATEFFECT_SCROLL.length());
							} else if (effectLower.startsWith(Text.CHATEFFECT_SLIDE)) {
								effect = 5;
								message = message.substring(Text.CHATEFFECT_SLIDE.length());
							} else if (Client.lang != 0) {
								if (effectLower.startsWith(Text.CHATEFFECT_WAVE_GER)) {
									effect = 1;
									message = message.substring(Text.CHATEFFECT_WAVE_GER.length());
								} else if (effectLower.startsWith(Text.CHATEFFECT_WAVE2_GER)) {
									effect = 2;
									message = message.substring(Text.CHATEFFECT_WAVE2_GER.length());
								} else if (effectLower.startsWith(Text.CHATEFFECT_SHAKE_GER)) {
									effect = 3;
									message = message.substring(Text.CHATEFFECT_SHAKE_GER.length());
								} else if (effectLower.startsWith(Text.CHATEFFECT_SCROLL_GER)) {
									effect = 4;
									message = message.substring(Text.CHATEFFECT_SCROLL_GER.length());
								} else if (effectLower.startsWith(Text.CHATEFFECT_SLIDE_GER)) {
									effect = 5;
									message = message.substring(Text.CHATEFFECT_SLIDE_GER.length());
								}
							}

							// MESSAGE_PUBLIC
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
						// chat_sendprivate
						ssp -= 2;
						String var355 = stringStack[ssp];
						String var356 = stringStack[ssp + 1];

						// MESSAGE_PRIVATE
						Client.out.pisaac1(211);
						Client.out.p2(0);
						int var357 = Client.out.pos;

						Client.out.pjstr(var355);
						WordPack.method911(Client.out, var356);

						Client.out.psize2(Client.out.pos - var357);
						continue;
					}
					if (opcode == 5010) {
						// chat_sendclan
						isp--;
						int var358 = intStack[isp];

						String var359 = null;
						if (var358 < 100) {
							var359 = Client.messageSender[var358];
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
						// chat_playername
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
						// chat_getfilter_trade
						intStack[isp++] = Client.tradeChatFilter;
						continue;
					}
					if (opcode == 5017) {
						// chat_gethistorylength
						intStack[isp++] = Client.chatHistoryLength;
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
					Client.addMessage(0, "", "Clientscript error in: " + script.name);
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
					Client.addMessage(0, "", "Clientscript error - check log for details");
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
				HookReq req = new HookReq();
				req.component = com;
				req.onop = com.onload;
				runHook(req);
			}
		}
	}
}
