package jagex3.client;

import deob.ObfuscatedName;
import jagex3.client.applet.GameShell;
import jagex3.client.applet.JavaKeyboardProvider;
import jagex3.client.applet.JavaMouseProvider;
import jagex3.graphics.*;
import jagex3.io.Packet;
import jagex3.js5.Js5Loader;
import jagex3.js5.Js5Net;
import jagex3.jstring.StringUtil;
import jagex3.jstring.Text;
import jagex3.jstring.TextUtil;
import jagex3.midi.MidiManager;

import java.awt.*;
import java.net.URL;

@ObfuscatedName("g")
public class TitleScreen {

	@ObfuscatedName("df.r")
	public static boolean opened;

	@ObfuscatedName("g.d")
	public static Pix8 field137;

	@ObfuscatedName("g.l")
	public static Pix8 field153;

	@ObfuscatedName("g.m")
	public static Pix8[] field165;

	@ObfuscatedName("g.c")
	public static Pix32 field146;

	@ObfuscatedName("ac.n")
	public static Pix32 field348;

	@ObfuscatedName("g.j")
	public static Pix8 field131;

	@ObfuscatedName("g.z")
	public static Pix8[] field132;

	@ObfuscatedName("g.g")
	public static boolean field142 = false;

	@ObfuscatedName("g.w")
	public static int[] field139 = new int[256];

	@ObfuscatedName("g.e")
	public static int[] field140;

	@ObfuscatedName("bq.b")
	public static int[] field827;

	@ObfuscatedName("bx.y")
	public static int[] field813;

	@ObfuscatedName("g.t")
	public static int[] field141;

	@ObfuscatedName("g.f")
	public static int field129 = 0;

	@ObfuscatedName("g.k")
	public static int field143 = 0;

	@ObfuscatedName("an.o")
	public static int[] field489;

	@ObfuscatedName("ay.a")
	public static int[] field527;

	@ObfuscatedName("g.h")
	public static int[] field144;

	@ObfuscatedName("r.x")
	public static int[] field9;

	@ObfuscatedName("g.p")
	public static int field145 = 0;

	@ObfuscatedName("g.ad")
	public static int field128 = 0;

	@ObfuscatedName("g.ac")
	public static int field147 = 0;

	@ObfuscatedName("g.aa")
	public static int field148 = 0;

	@ObfuscatedName("g.as")
	public static int loadPos = 10;

	@ObfuscatedName("g.am")
	public static String loadString = "";

	@ObfuscatedName("g.ap")
	public static int field151 = 0;

	@ObfuscatedName("g.av")
	public static String loginMes1 = "";

	@ObfuscatedName("g.ak")
	public static String loginMes2 = "";

	@ObfuscatedName("g.az")
	public static String loginMes3 = "";

	@ObfuscatedName("g.an")
	public static String username = "";

	@ObfuscatedName("g.ah")
	public static String password = "";

	@ObfuscatedName("g.ay")
	public static int field150 = 0;

	@ObfuscatedName("g.al")
	public static String field158 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";

	@ObfuscatedName("g.ao")
	public static boolean field160 = false;

	@ObfuscatedName("l.ag")
	public static WorldList field35;

	@ObfuscatedName("da.ar")
	public static Pix32[] field1530;

	@ObfuscatedName("be.aq")
	public static String worldlistUrl;

	@ObfuscatedName("fn.aq")
	public static Pix8[] field2612;

	@ObfuscatedName("au.at")
	public static Pix8[] field681;

	@ObfuscatedName("bx.ae")
	public static Pix8[] field811;

	@ObfuscatedName("v.au")
	public static Pix8 field215;

	@ObfuscatedName("g.ax")
	public static int worldCount = 0;

	@ObfuscatedName("v.ai")
	public static WorldEntry[] worlds;

	@ObfuscatedName("g.bi")
	public static int[] field130 = new int[] { 0, 1, 2, 3 };

	@ObfuscatedName("g.bs")
	public static int[] field167 = new int[] { 1, 1, 1, 1 };

	@ObfuscatedName("g.bk")
	public static int field168 = -1;

	public TitleScreen() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("v.r(I)I")
	public static int method162() {
		return 6;
	}

	@ObfuscatedName("bx.d(I)V")
	public static void close() {
		if (!opened) {
			return;
		}
		field137 = null;
		field153 = null;
		field165 = null;
		field146 = null;
		field348 = null;
		field131 = null;
		field132 = null;
		field1530 = null;
		field2612 = null;
		field681 = null;
		field811 = null;
		field215 = null;
		field827 = null;
		field813 = null;
		field141 = null;
		field140 = null;
		field489 = null;
		field527 = null;
		field144 = null;
		field9 = null;
		// todo: inlined midiplayer method?
		MidiManager.field1117 = 1;
		MidiManager.field1118 = null;
		MidiManager.field349 = -1;
		MidiManager.field1121 = -1;
		MidiManager.field1120 = 0;
		MidiManager.field1625 = false;
		MidiManager.field1152 = 2;
		Js5Net.sendLoginLogoutPacket(true);
		opened = false;
	}

	@ObfuscatedName("r.l(Ldj;I)V")
	public static void loop(GameShell app) {
		if (field160) {
			method1134(app);
			return;
		}
		if (JavaMouseProvider.mouseClickButton == 1 && JavaMouseProvider.mouseClickX >= 715 && JavaMouseProvider.mouseClickY >= 453) {
			field142 = !field142;
			if (field142) {
				MidiManager.method917();
			} else {
				Js5Loader var1 = Client.midiSongJs5;
				int var2 = var1.getGroupId("scape main");
				int var3 = var1.getFileId(var2, "");
				MidiManager.method1125(var1, var2, var3, 255, false);
			}
		}
		if (Client.state == 5) {
			return;
		}
		field147++;
		if (Client.state != 10) {
			return;
		}
		if (Client.lang == 0) {
			if (JavaMouseProvider.mouseClickButton == 1) {
				byte var4 = 5;
				short var5 = 463;
				byte var6 = 100;
				byte var7 = 35;
				if (JavaMouseProvider.mouseClickX >= var4 && JavaMouseProvider.mouseClickX <= var4 + var6 && JavaMouseProvider.mouseClickY >= var5 && JavaMouseProvider.mouseClickY <= var5 + var7) {
					method377();
					return;
				}
			}
			if (field35 != null) {
				method377();
			}
		}
		int var8 = JavaMouseProvider.mouseClickButton;
		int var9 = JavaMouseProvider.mouseClickX;
		int var10 = JavaMouseProvider.mouseClickY;
		if (field151 == 0) {
			short var11 = 302;
			short var12 = 291;
			if (var8 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var12 - 20 && var10 <= var12 + 20) {
				field151 = 3;
				field150 = 0;
			}
			short var13 = 462;
			if (var8 == 1 && var9 >= var13 - 75 && var9 <= var13 + 75 && var10 >= var12 - 20 && var10 <= var12 + 20) {
				loginMes1 = Text.PLEASELOGIN1;
				loginMes2 = Text.PLEASELOGIN2;
				loginMes3 = Text.PLEASELOGIN3;
				field151 = 2;
				field150 = 0;
			}
		} else if (field151 == 2) {
			short var14 = 231;
			int var26 = var14 + 30;
			if (var8 == 1 && var10 >= var26 - 15 && var10 < var26) {
				field150 = 0;
			}
			var26 += 15;
			if (var8 == 1 && var10 >= var26 - 15 && var10 < var26) {
				field150 = 1;
			}
			var26 += 15;
			short var15 = 302;
			short var16 = 321;
			if (var8 == 1 && var9 >= var15 - 75 && var9 <= var15 + 75 && var10 >= var16 - 20 && var10 <= var16 + 20) {
				username = username.trim();
				if (username.length() == 0) {
					loginMes(Text.field978, Text.field979, Text.field980);
					return;
				}
				if (password.length() == 0) {
					loginMes(Text.field981, Text.field982, Text.field983);
					return;
				}
				loginMes(Text.CONNECTING1, Text.CONNECTING2, Text.CONNECTING3);
				Client.setMainState(20);
				return;
			}
			short var17 = 462;
			if (var8 == 1 && var9 >= var17 - 75 && var9 <= var17 + 75 && var10 >= var16 - 20 && var10 <= var16 + 20) {
				field151 = 0;
				username = "";
				password = "";
			}
			while (JavaKeyboardProvider.imethod2()) {
				boolean var21 = false;
				for (int var22 = 0; var22 < field158.length(); var22++) {
					if (JavaKeyboardProvider.field1162 == field158.charAt(var22)) {
						var21 = true;
						break;
					}
				}
				if (field150 == 0) {
					if (JavaKeyboardProvider.field114 == 85 && username.length() > 0) {
						username = username.substring(0, username.length() - 1);
					}
					if (JavaKeyboardProvider.field114 == 84 || JavaKeyboardProvider.field114 == 80) {
						field150 = 1;
					}
					if (var21 && username.length() < 320) {
						username += JavaKeyboardProvider.field1162;
					}
				} else if (field150 == 1) {
					if (JavaKeyboardProvider.field114 == 85 && password.length() > 0) {
						password = password.substring(0, password.length() - 1);
					}
					if (JavaKeyboardProvider.field114 == 84 || JavaKeyboardProvider.field114 == 80) {
						field150 = 0;
					}
					if (Client.modewhere == 2 && JavaKeyboardProvider.field114 == 84) {
						username = username.trim();
						if (username.length() == 0) {
							loginMes(Text.field978, Text.field979, Text.field980);
							break;
						}
						if (password.length() == 0) {
							loginMes(Text.field981, Text.field982, Text.field983);
							break;
						}
						loginMes(Text.CONNECTING1, Text.CONNECTING2, Text.CONNECTING3);
						Client.setMainState(20);
						break;
					}
					if (var21 && password.length() < 20) {
						password += JavaKeyboardProvider.field1162;
					}
				}
			}
		} else if (field151 == 3) {
			short var23 = 382;
			short var24 = 321;
			if (var8 == 1 && var9 >= var23 - 75 && var9 <= var23 + 75 && var10 >= var24 - 20 && var10 <= var24 + 20) {
				field151 = 0;
			}
		}
	}

	@ObfuscatedName("bg.m(Lfm;Lfm;I)V")
	public static void draw(SoftwareFont arg0, SoftwareFont arg1) {
		if (field160) {
			method1500(arg0, arg1);
			return;
		}
		if (Client.state == 0 || Client.state == 5) {
			byte var2 = 20;
			arg0.centreString(Text.LOADING_TITLE, 382, 245 - var2, 16777215, -1);
			int var3 = 253 - var2;
			Pix2D.drawRect(230, var3, 304, 34, 9179409);
			Pix2D.drawRect(231, var3 + 1, 302, 32, 0);
			Pix2D.fillRect(232, var3 + 2, loadPos * 3, 30, 9179409);
			Pix2D.fillRect(loadPos * 3 + 232, var3 + 2, 300 - loadPos * 3, 30, 0);
			arg0.centreString(loadString, 382, 276 - var2, 16777215, -1);
		}
		if (Client.state == 20) {
			field137.plotSprite(382 - field137.wi / 2, 271 - field137.hi / 2);
			short var4 = 211;
			arg0.centreString(loginMes1, 382, var4, 16776960, 0);
			int var89 = var4 + 15;
			arg0.centreString(loginMes2, 382, var89, 16776960, 0);
			int var90 = var89 + 15;
			arg0.centreString(loginMes3, 382, var90, 16776960, 0);
			int var91 = var90 + 15;
			int var92 = var91 + 10;
			arg0.drawString(Text.USERNAMEPROMPT, 272, var92, 16777215, 0);
			short var5 = 200;
			String var6;
			for (var6 = username; arg0.stringWid(var6) > var5; var6 = var6.substring(0, var6.length() - 1)) {
			}
			arg0.drawString(PixFont.method2844(var6), 312, var92, 16777215, 0);
			var89 = var92 + 15;
			String var8 = Text.PASSWORDPROMPT;
			String var9 = password;
			String var10 = StringUtil.method946('*', var9.length());
			arg0.drawString(var8 + var10, 274, var89, 16777215, 0);
			var89 += 15;
		}
		if (Client.state == 10) {
			field137.plotSprite(202, 171);
			if (field151 == 0) {
				short var11 = 251;
				arg0.centreString(Text.WELCOMETORUNESCAPE, 382, var11, 16776960, 0);
				int var93 = var11 + 30;
				short var12 = 302;
				short var13 = 291;
				field153.plotSprite(var12 - 73, var13 - 20);
				arg0.method2824(Text.NEWUSER, var12 - 73, var13 - 20, 144, 40, 16777215, 0, 1, 1, 0);
				short var14 = 462;
				field153.plotSprite(var14 - 73, var13 - 20);
				arg0.method2824(Text.EXISTINGUSER, var14 - 73, var13 - 20, 144, 40, 16777215, 0, 1, 1, 0);
			} else if (field151 == 2) {
				short var15 = 211;
				arg0.centreString(loginMes1, 382, var15, 16776960, 0);
				int var94 = var15 + 15;
				arg0.centreString(loginMes2, 382, var94, 16776960, 0);
				int var95 = var94 + 15;
				arg0.centreString(loginMes3, 382, var95, 16776960, 0);
				int var96 = var95 + 15;
				int var97 = var96 + 10;
				arg0.drawString(Text.USERNAMEPROMPT, 272, var97, 16777215, 0);
				short var16 = 200;
				String var17;
				for (var17 = username; arg0.stringWid(var17) > var16; var17 = var17.substring(1)) {
				}
				arg0.drawString(PixFont.method2844(var17) + (field150 == 0 & Client.loopCycle % 40 < 20 ? TextUtil.colTag(16776960) + TextUtil.pipe : ""), 312, var97, 16777215, 0);
				var94 = var97 + 15;
				String var19 = Text.PASSWORDPROMPT;
				String var20 = password;
				String var21 = StringUtil.method946('*', var20.length());
				arg0.drawString(var19 + var21 + (field150 == 1 & Client.loopCycle % 40 < 20 ? TextUtil.colTag(16776960) + TextUtil.pipe : ""), 274, var94, 16777215, 0);
				var94 += 15;
				short var22 = 302;
				short var23 = 321;
				field153.plotSprite(var22 - 73, var23 - 20);
				arg0.centreString(Text.LOGIN, var22, var23 + 5, 16777215, 0);
				short var24 = 462;
				field153.plotSprite(var24 - 73, var23 - 20);
				arg0.centreString(Text.CANCEL, var24, var23 + 5, 16777215, 0);
			} else if (field151 == 3) {
				arg0.centreString(Text.NEWUSER1, 382, 211, 16776960, 0);
				short var25 = 236;
				arg0.centreString(Text.NEWUSER2, 382, var25, 16777215, 0);
				int var98 = var25 + 15;
				arg0.centreString(Text.NEWUSER3, 382, var98, 16777215, 0);
				int var99 = var98 + 15;
				arg0.centreString(Text.NEWUSER4, 382, var99, 16777215, 0);
				int var100 = var99 + 15;
				arg0.centreString(Text.NEWUSER5, 382, var100, 16777215, 0);
				int var101 = var100 + 15;
				short var26 = 382;
				short var27 = 321;
				field153.plotSprite(var26 - 73, var27 - 20);
				arg0.centreString(Text.CANCEL, var26, var27 + 5, 16777215, 0);
			}
		}
		if (field147 > 0) {
			int var28 = field147;
			short var29 = 256;
			field145 += var28 * 128;
			if (field145 > field489.length) {
				field145 -= field489.length;
				int var30 = (int) (Math.random() * 12.0D);
				method920(field165[var30]);
			}
			int var31 = 0;
			int var32 = var28 * 128;
			int var33 = (var29 - var28) * 128;
			for (int var34 = 0; var34 < var33; var34++) {
				int var35 = field144[var31 + var32] - field489[field145 + var31 & field489.length - 1] * var28 / 6;
				if (var35 < 0) {
					var35 = 0;
				}
				field144[var31++] = var35;
			}
			for (int var36 = var29 - var28; var36 < var29; var36++) {
				int var37 = var36 * 128;
				for (int var38 = 0; var38 < 128; var38++) {
					int var39 = (int) (Math.random() * 100.0D);
					if (var39 < 50 && var38 > 10 && var38 < 118) {
						field144[var37 + var38] = 255;
					} else {
						field144[var37 + var38] = 0;
					}
				}
			}
			if (field129 > 0) {
				field129 -= var28 * 4;
			}
			if (field143 > 0) {
				field143 -= var28 * 4;
			}
			if (field129 == 0 && field143 == 0) {
				int var40 = (int) (Math.random() * (double) (2000 / var28));
				if (var40 == 0) {
					field129 = 1024;
				}
				if (var40 == 1) {
					field143 = 1024;
				}
			}
			for (int var41 = 0; var41 < var29 - var28; var41++) {
				field139[var41] = field139[var28 + var41];
			}
			for (int var42 = var29 - var28; var42 < var29; var42++) {
				field139[var42] = (int) (Math.sin((double) field148 / 14.0D) * 16.0D + Math.sin((double) field148 / 15.0D) * 14.0D + Math.sin((double) field148 / 16.0D) * 12.0D);
				field148++;
			}
			field128 += var28 * 381703395;
			int var43 = ((Client.loopCycle & 0x1) + var28) / 2;
			if (var43 > 0) {
				for (int var44 = 0; var44 < field128 * 1196724044; var44++) {
					int var45 = (int) (Math.random() * 124.0D) + 2;
					int var46 = (int) (Math.random() * 128.0D) + 128;
					field144[(var46 << 7) + var45] = 192;
				}
				field128 = 0;
				int var47 = 0;
				label286:
				while (true) {
					if (var47 >= var29) {
						int var51 = 0;
						while (true) {
							if (var51 >= 128) {
								break label286;
							}
							int var52 = 0;
							for (int var53 = -var43; var53 < var29; var53++) {
								int var54 = var53 * 128;
								if (var43 + var53 < var29) {
									var52 += field9[var43 * 128 + var51 + var54];
								}
								if (var53 - (var43 + 1) >= 0) {
									var52 -= field9[var51 + var54 - (var43 + 1) * 128];
								}
								if (var53 >= 0) {
									field144[var51 + var54] = var52 / (var43 * 2 + 1);
								}
							}
							var51++;
						}
					}
					int var48 = 0;
					int var49 = var47 * 128;
					for (int var50 = -var43; var50 < 128; var50++) {
						if (var43 + var50 < 128) {
							var48 += field144[var49 + var50 + var43];
						}
						if (var50 - (var43 + 1) >= 0) {
							var48 -= field144[var49 + var50 - (var43 + 1)];
						}
						if (var50 >= 0) {
							field9[var49 + var50] = var48 / (var43 * 2 + 1);
						}
					}
					var47++;
				}
			}
			field147 = 0;
		}
		short var55 = 256;
		if (field129 > 0) {
			for (int var56 = 0; var56 < 256; var56++) {
				if (field129 > 768) {
					field140[var56] = method1792(field827[var56], field813[var56], 1024 - field129);
				} else if (field129 > 256) {
					field140[var56] = field813[var56];
				} else {
					field140[var56] = method1792(field813[var56], field827[var56], 256 - field129);
				}
			}
		} else if (field143 > 0) {
			for (int var57 = 0; var57 < 256; var57++) {
				if (field143 > 768) {
					field140[var57] = method1792(field827[var57], field141[var57], 1024 - field143);
				} else if (field143 > 256) {
					field140[var57] = field141[var57];
				} else {
					field140[var57] = method1792(field141[var57], field827[var57], 256 - field143);
				}
			}
		} else {
			for (int var58 = 0; var58 < 256; var58++) {
				field140[var58] = field827[var58];
			}
		}
		Pix2D.setClipping(0, 9, 128, var55 + 7);
		field146.method2667(0, 0);
		Pix2D.resetClipping();
		int var59 = 0;
		int var60 = 6885;
		for (int var61 = 1; var61 < var55 - 1; var61++) {
			int var62 = (var55 - var61) * field139[var61] / var55;
			int var63 = var62 + 22;
			if (var63 < 0) {
				var63 = 0;
			}
			var59 += var63;
			for (int var64 = var63; var64 < 128; var64++) {
				int var65 = field144[var59++];
				if (var65 == 0) {
					var60++;
				} else {
					int var67 = 256 - var65;
					int var68 = field140[var65];
					int var69 = GameShell.drawArea.data[var60];
					GameShell.drawArea.data[var60++] = ((var68 & 0xFF00) * var65 + (var69 & 0xFF00) * var67 & 0xFF0000) + ((var68 & 0xFF00FF) * var65 + (var69 & 0xFF00FF) * var67 & 0xFF00FF00) >> 8;
				}
			}
			var60 += var63 + 765 - 128;
		}
		Pix2D.setClipping(637, 9, 765, var55 + 7);
		field348.method2667(382, 0);
		Pix2D.resetClipping();
		int var70 = 0;
		int var71 = 7546;
		for (int var72 = 1; var72 < var55 - 1; var72++) {
			int var73 = (var55 - var72) * field139[var72] / var55;
			int var74 = 103 - var73;
			int var75 = var71 + var73;
			for (int var76 = 0; var76 < var74; var76++) {
				int var77 = field144[var70++];
				if (var77 == 0) {
					var75++;
				} else {
					int var79 = 256 - var77;
					int var80 = field140[var77];
					int var81 = GameShell.drawArea.data[var75];
					GameShell.drawArea.data[var75++] = ((var80 & 0xFF00FF) * var77 + (var81 & 0xFF00FF) * var79 & 0xFF00FF00) + ((var80 & 0xFF00) * var77 + (var81 & 0xFF00) * var79 & 0xFF0000) >> 8;
				}
			}
			var70 += 128 - var74;
			var71 = 765 - var74 - var73 + var75;
		}
		field132[field142 ? 1 : 0].plotSprite(725, 463);
		if (Client.state > 5 && Client.lang == 0) {
			if (field215 == null) {
				field215 = PixLoader.makePix8(Client.spriteJs5, "sl_button", "");
			} else {
				byte var82 = 5;
				short var83 = 463;
				byte var84 = 100;
				byte var85 = 35;
				field215.plotSprite(var82, var83);
				arg0.centreString(Text.WORLD + " " + Client.worldid, var84 / 2 + var82, var85 / 2 + var83 - 2, 16777215, 0);
				if (field35 == null) {
					arg1.centreString(Text.CLICKTOSWITCH, var84 / 2 + var82, var85 / 2 + var83 + 12, 16777215, 0);
				} else {
					arg1.centreString(Text.LOADINGDOTDOTDOT, var84 / 2 + var82, var85 / 2 + var83 + 12, 16777215, 0);
				}
			}
		}
		try {
			Graphics var86 = GameShell.canvas.getGraphics();
			GameShell.drawArea.draw(var86, 0, 0);
		} catch (Exception var88) {
			GameShell.canvas.repaint();
		}
	}

	// jag::oldscape::TitleScreen::LoginMes
	@ObfuscatedName("em.c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V")
	public static void loginMes(String line1, String line2, String line3) {
		loginMes1 = line1;
		loginMes2 = line2;
		loginMes3 = line3;
	}

	@ObfuscatedName("br.n(Lft;B)V")
	public static void method920(Pix8 arg0) {
		short var1 = 256;
		for (int var2 = 0; var2 < field489.length; var2++) {
			field489[var2] = 0;
		}
		for (int var3 = 0; var3 < 5000; var3++) {
			int var4 = (int) (Math.random() * 128.0D * (double) var1);
			field489[var4] = (int) (Math.random() * 256.0D);
		}
		for (int var5 = 0; var5 < 20; var5++) {
			for (int var6 = 1; var6 < var1 - 1; var6++) {
				for (int var7 = 1; var7 < 127; var7++) {
					int var8 = (var6 << 7) + var7;
					field527[var8] = (field489[var8 - 1] + field489[var8 + 1] + field489[var8 - 128] + field489[var8 + 128]) / 4;
				}
			}
			int[] var9 = field489;
			field489 = field527;
			field527 = var9;
		}
		if (arg0 == null) {
			return;
		}
		int var10 = 0;
		for (int var11 = 0; var11 < arg0.hi; var11++) {
			for (int var12 = 0; var12 < arg0.wi; var12++) {
				if (arg0.data[var10++] != 0) {
					int var13 = var12 + 16 + arg0.xof;
					int var14 = var11 + 16 + arg0.yof;
					int var15 = (var14 << 7) + var13;
					field489[var15] = 0;
				}
			}
		}
	}

	@ObfuscatedName("eh.j(IIII)I")
	public static int method1792(int arg0, int arg1, int arg2) {
		int var3 = 256 - arg2;
		return ((arg0 & 0xFF00FF) * var3 + (arg1 & 0xFF00FF) * arg2 & 0xFF00FF00) + ((arg0 & 0xFF00) * var3 + (arg1 & 0xFF00) * arg2 & 0xFF0000) >> 8;
	}

	@ObfuscatedName("de.z(Lfm;Lfm;I)V")
	public static void method1500(SoftwareFont arg0, SoftwareFont arg1) {
		if (field1530 == null) {
			field1530 = PixLoader.makePix32Array(Client.spriteJs5, "sl_back", "");
		}
		if (field2612 == null) {
			field2612 = PixLoader.makePix8Array(Client.spriteJs5, "sl_flags", "");
		}
		if (field681 == null) {
			field681 = PixLoader.makePix8Array(Client.spriteJs5, "sl_arrows", "");
		}
		if (field811 == null) {
			field811 = PixLoader.makePix8Array(Client.spriteJs5, "sl_stars", "");
		}
		Pix2D.fillRect(0, 23, 765, 480, 0);
		Pix2D.method2592(0, 0, 125, 23, 12425273, 9135624);
		Pix2D.method2592(125, 0, 640, 23, 5197647, 2697513);
		arg0.centreString(Text.SELECTAWORLD, 62, 15, 0, -1);
		if (field811 != null) {
			field811[1].plotSprite(140, 1);
			arg1.drawString(Text.MEMBERSONLYWORLD, 152, 10, 16777215, -1);
			field811[0].plotSprite(140, 12);
			arg1.drawString(Text.FREEWORLD, 152, 21, 16777215, -1);
		}
		if (field681 != null) {
			short var2 = 280;
			if (field130[0] == 0 && field167[0] == 0) {
				field681[2].plotSprite(var2, 4);
			} else {
				field681[0].plotSprite(var2, 4);
			}
			if (field130[0] == 0 && field167[0] == 1) {
				field681[3].plotSprite(var2 + 15, 4);
			} else {
				field681[1].plotSprite(var2 + 15, 4);
			}
			arg0.drawString(Text.SL_WORLD, var2 + 32, 17, 16777215, -1);
			short var3 = 390;
			if (field130[0] == 1 && field167[0] == 0) {
				field681[2].plotSprite(var3, 4);
			} else {
				field681[0].plotSprite(var3, 4);
			}
			if (field130[0] == 1 && field167[0] == 1) {
				field681[3].plotSprite(var3 + 15, 4);
			} else {
				field681[1].plotSprite(var3 + 15, 4);
			}
			arg0.drawString(Text.SL_PLAYERS, var3 + 32, 17, 16777215, -1);
			short var4 = 500;
			if (field130[0] == 2 && field167[0] == 0) {
				field681[2].plotSprite(var4, 4);
			} else {
				field681[0].plotSprite(var4, 4);
			}
			if (field130[0] == 2 && field167[0] == 1) {
				field681[3].plotSprite(var4 + 15, 4);
			} else {
				field681[1].plotSprite(var4 + 15, 4);
			}
			arg0.drawString(Text.SL_LOCATION, var4 + 32, 17, 16777215, -1);
			short var5 = 610;
			if (field130[0] == 3 && field167[0] == 0) {
				field681[2].plotSprite(var5, 4);
			} else {
				field681[0].plotSprite(var5, 4);
			}
			if (field130[0] == 3 && field167[0] == 1) {
				field681[3].plotSprite(var5 + 15, 4);
			} else {
				field681[1].plotSprite(var5 + 15, 4);
			}
			arg0.drawString(Text.SL_TYPE, var5 + 32, 17, 16777215, -1);
		}
		Pix2D.fillRect(708, 4, 50, 16, 0);
		arg1.centreString(Text.CANCEL, 733, 16, 16777215, -1);
		field168 = -1;
		if (field1530 != null) {
			byte var6 = 88;
			byte var7 = 19;
			int var8 = 765 / (var6 + 1);
			int var9 = 480 / (var7 + 1);
			int var10;
			int var11;
			do {
				var10 = var9;
				var11 = var8;
				if ((var8 - 1) * var9 >= worldCount) {
					var8--;
				}
				if ((var9 - 1) * var8 >= worldCount) {
					var9--;
				}
				if ((var9 - 1) * var8 >= worldCount) {
					var9--;
				}
			} while (var9 != var10 || var8 != var11);
			int var12 = (765 - var6 * var8) / (var8 + 1);
			if (var12 > 5) {
				var12 = 5;
			}
			int var13 = (480 - var7 * var9) / (var9 + 1);
			if (var13 > 5) {
				var13 = 5;
			}
			int var14 = (765 - var6 * var8 - (var8 - 1) * var12) / 2;
			int var15 = (480 - var7 * var9 - (var9 - 1) * var13) / 2;
			int var16 = var15 + 23;
			int var17 = var14;
			int var18 = 0;
			for (int var19 = 0; var19 < worldCount; var19++) {
				WorldEntry var20 = worlds[var19];
				boolean var21 = true;
				String var22 = Integer.toString(var20.players);
				if (var20.players == -1) {
					var22 = Text.OFFLINEWORLD;
					var21 = false;
				} else if (var20.players > 1980) {
					var22 = Text.FULLWORLD;
					var21 = false;
				}
				if (JavaMouseProvider.mouseX >= var17 && JavaMouseProvider.mouseY >= var16 && JavaMouseProvider.mouseX < var6 + var17 && JavaMouseProvider.mouseY < var7 + var16 && var21) {
					field168 = var19;
					field1530[var20.members ? 1 : 0].method2699(var17, var16, 128, 0xffffff);
				} else {
					field1530[var20.members ? 1 : 0].method2667(var17, var16);
				}
				if (field2612 != null) {
					field2612[var20.country + (var20.members ? 8 : 0)].plotSprite(var17 + 29, var16);
				}
				arg0.centreString(Integer.toString(var20.id), var17 + 15, var7 / 2 + var16 + 5, 0, -1);
				arg1.centreString(var22, var17 + 60, var7 / 2 + var16 + 5, 0xfffffff, -1);
				var16 += var7 + var13;
				var18++;
				if (var18 >= var9) {
					var16 = var15 + 23;
					var17 += var6 + var12;
					var18 = 0;
				}
			}
		}
		try {
			Graphics var23 = GameShell.canvas.getGraphics();
			GameShell.drawArea.draw(var23, 0, 0);
		} catch (Exception var25) {
			GameShell.canvas.repaint();
		}
	}

	@ObfuscatedName("cm.g(Ldj;I)V")
	public static void method1134(GameShell arg0) {
		if (JavaMouseProvider.mouseClickButton != 1) {
			return;
		}
		short var1 = 280;
		if (JavaMouseProvider.mouseClickX >= var1 && JavaMouseProvider.mouseClickX <= var1 + 14 && JavaMouseProvider.mouseClickY >= 4 && JavaMouseProvider.mouseClickY <= 18) {
			method2049(0, 0);
			return;
		}
		if (JavaMouseProvider.mouseClickX >= var1 + 15 && JavaMouseProvider.mouseClickX <= var1 + 80 && JavaMouseProvider.mouseClickY >= 4 && JavaMouseProvider.mouseClickY <= 18) {
			method2049(0, 1);
			return;
		}
		short var2 = 390;
		if (JavaMouseProvider.mouseClickX >= var2 && JavaMouseProvider.mouseClickX <= var2 + 14 && JavaMouseProvider.mouseClickY >= 4 && JavaMouseProvider.mouseClickY <= 18) {
			method2049(1, 0);
			return;
		}
		if (JavaMouseProvider.mouseClickX >= var2 + 15 && JavaMouseProvider.mouseClickX <= var2 + 80 && JavaMouseProvider.mouseClickY >= 4 && JavaMouseProvider.mouseClickY <= 18) {
			method2049(1, 1);
			return;
		}
		short var3 = 500;
		if (JavaMouseProvider.mouseClickX >= var3 && JavaMouseProvider.mouseClickX <= var3 + 14 && JavaMouseProvider.mouseClickY >= 4 && JavaMouseProvider.mouseClickY <= 18) {
			method2049(2, 0);
			return;
		}
		if (JavaMouseProvider.mouseClickX >= var3 + 15 && JavaMouseProvider.mouseClickX <= var3 + 80 && JavaMouseProvider.mouseClickY >= 4 && JavaMouseProvider.mouseClickY <= 18) {
			method2049(2, 1);
			return;
		}
		short var4 = 610;
		if (JavaMouseProvider.mouseClickX >= var4 && JavaMouseProvider.mouseClickX <= var4 + 14 && JavaMouseProvider.mouseClickY >= 4 && JavaMouseProvider.mouseClickY <= 18) {
			method2049(3, 0);
			return;
		}
		if (JavaMouseProvider.mouseClickX >= var4 + 15 && JavaMouseProvider.mouseClickX <= var4 + 80 && JavaMouseProvider.mouseClickY >= 4 && JavaMouseProvider.mouseClickY <= 18) {
			method2049(3, 1);
			return;
		}
		if (JavaMouseProvider.mouseClickX >= 708 && JavaMouseProvider.mouseClickY >= 4 && JavaMouseProvider.mouseClickX <= 758 && JavaMouseProvider.mouseClickY <= 20) {
			field160 = false;
			field146.method2667(0, 0);
			field348.method2667(382, 0);
			field131.plotSprite(382 - field131.wi / 2, 18);
			return;
		}
		if (field168 == -1) {
			return;
		}
		WorldEntry var5 = worlds[field168];
		if (Client.members == var5.members) {
			Client.loginHost = var5.host;
			Client.worldid = var5.id;
			Client.loginGamePort = Client.modewhere == 0 ? 43594 : var5.id + 40000;
			Client.loginJs5Port = Client.modewhere == 0 ? 443 : var5.id + 50000;
			Client.loginPort = Client.loginGamePort;
			field160 = false;
			field146.method2667(0, 0);
			field348.method2667(382, 0);
			field131.plotSprite(382 - field131.wi / 2, 18);
			return;
		}
		String var6 = "";
		if (Client.modewhere != 0) {
			var6 = ":" + (var5.id + 7000);
		}
		String var7 = "http://" + var5.host + var6 + "/j" + Client.js;
		try {
			arg0.getAppletContext().showDocument(new URL(var7), "_self");
		} catch (Exception var9) {
		}
	}

	@ObfuscatedName("ac.q(I)V")
	public static void method377() {
		try {
			if (field35 == null) {
				field35 = new WorldList(GameShell.taskHandler, new URL(worldlistUrl));
			} else {
				byte[] src = field35.getWorldList();
				if (src == null) {
					return;
				}

				Packet buf = new Packet(src);
				worldCount = buf.g2();
				worlds = new WorldEntry[worldCount];
				int i = 0;

				while (i < worldCount) {
					WorldEntry world = worlds[i] = new WorldEntry();
					int info = buf.g2();
					world.id = info & 0x7FFF;
					world.members = (info & 0x8000) != 0;
					world.host = buf.gjstr();
					world.country = buf.g1();
					world.players = buf.g2b();
					world.index = i++;
				}

				method747(worlds, 0, worlds.length - 1, field130, field167);
				field160 = true;
				field35 = null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			field35 = null;
		}
	}

	@ObfuscatedName("client.i(III)V")
	public static void method2049(int arg0, int arg1) {
		int[] var2 = new int[4];
		int[] var3 = new int[4];
		var2[0] = arg0;
		var3[0] = arg1;
		int var4 = 1;
		for (int var5 = 0; var5 < 4; var5++) {
			if (field130[var5] != arg0) {
				var2[var4] = field130[var5];
				var3[var4] = field167[var5];
				var4++;
			}
		}
		field130 = var2;
		field167 = var3;
		method747(worlds, 0, worlds.length - 1, field130, field167);
	}

	@ObfuscatedName("bh.s([Lc;II[I[II)V")
	public static void method747(WorldEntry[] arg0, int arg1, int arg2, int[] arg3, int[] arg4) {
		if (arg1 >= arg2) {
			return;
		}
		int var5 = arg1 - 1;
		int var6 = arg2 + 1;
		int var7 = (arg1 + arg2) / 2;
		WorldEntry var8 = arg0[var7];
		arg0[var7] = arg0[arg1];
		arg0[arg1] = var8;
		while (var5 < var6) {
			boolean var9 = true;
			do {
				var6--;
				for (int var10 = 0; var10 < 4; var10++) {
					int var11;
					int var12;
					if (arg3[var10] == 2) {
						var11 = arg0[var6].index;
						var12 = var8.index;
					} else if (arg3[var10] == 1) {
						var11 = arg0[var6].players;
						var12 = var8.players;
						if (var11 == -1 && arg4[var10] == 1) {
							var11 = 2001;
						}
						if (var12 == -1 && arg4[var10] == 1) {
							var12 = 2001;
						}
					} else if (arg3[var10] == 3) {
						var11 = arg0[var6].members ? 1 : 0;
						var12 = var8.members ? 1 : 0;
					} else {
						var11 = arg0[var6].id;
						var12 = var8.id;
					}
					if (var11 != var12) {
						if ((arg4[var10] != 1 || var11 <= var12) && (arg4[var10] != 0 || var11 >= var12)) {
							var9 = false;
						}
						break;
					}
					if (var10 == 3) {
						var9 = false;
					}
				}
			} while (var9);
			boolean var13 = true;
			do {
				var5++;
				for (int var14 = 0; var14 < 4; var14++) {
					int var15;
					int var16;
					if (arg3[var14] == 2) {
						var15 = arg0[var5].index;
						var16 = var8.index;
					} else if (arg3[var14] == 1) {
						var15 = arg0[var5].players;
						var16 = var8.players;
						if (var15 == -1 && arg4[var14] == 1) {
							var15 = 2001;
						}
						if (var16 == -1 && arg4[var14] == 1) {
							var16 = 2001;
						}
					} else if (arg3[var14] == 3) {
						var15 = arg0[var5].members ? 1 : 0;
						var16 = var8.members ? 1 : 0;
					} else {
						var15 = arg0[var5].id;
						var16 = var8.id;
					}
					if (var15 != var16) {
						if ((arg4[var14] != 1 || var15 >= var16) && (arg4[var14] != 0 || var15 <= var16)) {
							var13 = false;
						}
						break;
					}
					if (var14 == 3) {
						var13 = false;
					}
				}
			} while (var13);
			if (var5 < var6) {
				WorldEntry var17 = arg0[var5];
				arg0[var5] = arg0[var6];
				arg0[var6] = var17;
			}
		}
		method747(arg0, arg1, var6, arg3, arg4);
		method747(arg0, var6 + 1, arg2, arg3, arg4);
	}

	public static void open(Canvas var1, Js5Loader var2, Js5Loader var3) {
		if (opened) {
			return;
		}
		Pix2D.cls();
		byte[] var4 = var2.getFile("title.jpg", "");
		field146 = new Pix32(var4, var1);
		field348 = field146.method2719();
		field131 = PixLoader.makePix8(var3, "logo", "");
		field137 = PixLoader.makePix8(var3, "titlebox", "");
		field153 = PixLoader.makePix8(var3, "titlebutton", "");
		field165 = PixLoader.makePix8Array(var3, "runes", "");
		field132 = PixLoader.makePix8Array(var3, "title_mute", "");
		field827 = new int[256];
		for (int var5 = 0; var5 < 64; var5++) {
			field827[var5] = var5 * 262144;
		}
		for (int var6 = 0; var6 < 64; var6++) {
			field827[var6 + 64] = var6 * 1024 + 16711680;
		}
		for (int var7 = 0; var7 < 64; var7++) {
			field827[var7 + 128] = var7 * 4 + 16776960;
		}
		for (int var8 = 0; var8 < 64; var8++) {
			field827[var8 + 192] = 16777215;
		}
		field813 = new int[256];
		for (int var9 = 0; var9 < 64; var9++) {
			field813[var9] = var9 * 1024;
		}
		for (int var10 = 0; var10 < 64; var10++) {
			field813[var10 + 64] = var10 * 4 + 65280;
		}
		for (int var11 = 0; var11 < 64; var11++) {
			field813[var11 + 128] = var11 * 262144 + 65535;
		}
		for (int var12 = 0; var12 < 64; var12++) {
			field813[var12 + 192] = 16777215;
		}
		field141 = new int[256];
		for (int var13 = 0; var13 < 64; var13++) {
			field141[var13] = var13 * 4;
		}
		for (int var14 = 0; var14 < 64; var14++) {
			field141[var14 + 64] = var14 * 262144 + 255;
		}
		for (int var15 = 0; var15 < 64; var15++) {
			field141[var15 + 128] = var15 * 1024 + 16711935;
		}
		for (int var16 = 0; var16 < 64; var16++) {
			field141[var16 + 192] = 16777215;
		}
		field140 = new int[256];
		field489 = new int[32768];
		field527 = new int[32768];
		method920(null);
		field144 = new int[32768];
		field9 = new int[32768];
		field151 = 0;
		username = "";
		password = "";
		field160 = false;
		if (Client.midiVolume == 0) {
			field142 = true;
		} else {
			field142 = false;
		}
		if (field142) {
			MidiManager.imethod2();
		} else {
			MidiManager.imethod1(Client.midiSongJs5);
		}
		Js5Net.sendLoginLogoutPacket(false);
		opened = true;
		field146.method2667(0, 0);
		field348.method2667(382, 0);
		field131.plotSprite(382 - field131.wi / 2, 18);
	}
}
