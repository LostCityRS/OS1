package jagex3.client;

import deob.ObfuscatedName;
import jagex3.client.input.keyboard.ClientKeyboardListener;
import jagex3.client.input.mouse.ClientMouseListener;
import jagex3.constants.Text;
import jagex3.dash3d.PixFont;
import jagex3.dash3d.PixFontGeneric;
import jagex3.graphics.Pix2D;
import jagex3.graphics.Pix32;
import jagex3.graphics.Pix8;
import jagex3.graphics.PixLoader;
import jagex3.io.Packet;
import jagex3.js5.Js5Loader;
import jagex3.js5.Js5Net;
import jagex3.jstring.StringTools;
import jagex3.midi2.MidiManager;

import java.awt.*;
import java.net.URL;

// jag::oldscape::TitleScreen
@ObfuscatedName("g")
public class TitleScreen {

	// jag::oldscape::TitleScreen::m_open
	@ObfuscatedName("df.r")
	public static boolean open;

	// jag::oldscape::TitleScreen::m_titleBox
	@ObfuscatedName("g.d")
	public static Pix8 titleBox;

	// jag::oldscape::TitleScreen::m_titleBut
	@ObfuscatedName("g.l")
	public static Pix8 titleBut;

	@ObfuscatedName("g.m")
	public static Pix8[] runes;

	// jag::oldscape::TitleScreen::m_titleBack
	@ObfuscatedName("g.c")
	public static Pix32 titleBack;

	// jag::oldscape::TitleScreen::m_titleBack2
	@ObfuscatedName("ac.n")
	public static Pix32 titleBack2;

	// jag::oldscape::TitleScreen::m_logo
	@ObfuscatedName("g.j")
	public static Pix8 logo;

	// jag::oldscape::TitleScreen::m_titleMute
	@ObfuscatedName("g.z")
	public static Pix8[] titleMute;

	// jag::oldscape::option::DeviceOptions::GetMuteTitleScreen
	@ObfuscatedName("g.g")
	public static boolean mute = false;

	@ObfuscatedName("g.w")
	public static int[] flameLineOffset = new int[256];

	@ObfuscatedName("g.e")
	public static int[] flameGradient;

	@ObfuscatedName("bq.b")
	public static int[] flameGradient0;

	@ObfuscatedName("bx.y")
	public static int[] flameGradient1;

	@ObfuscatedName("g.t")
	public static int[] flameGradient2;

	@ObfuscatedName("g.f")
	public static int flameGradientCycle0 = 0;

	@ObfuscatedName("g.k")
	public static int flameGradientCycle1 = 0;

	@ObfuscatedName("an.o")
	public static int[] flameBuffer0;

	@ObfuscatedName("ay.a")
	public static int[] flameBuffer1;

	@ObfuscatedName("g.h")
	public static int[] flameBuffer2;

	@ObfuscatedName("r.x")
	public static int[] flameBuffer3;

	@ObfuscatedName("g.p")
	public static int flameCycle0 = 0;

	@ObfuscatedName("g.ad")
	public static int flameSparks = 0;

	@ObfuscatedName("g.ac")
	public static int flameCycle = 0;

	@ObfuscatedName("g.aa")
	public static int loopCycle = 0;

	// jag::oldscape::TitleScreen::m_loadPos
	@ObfuscatedName("g.as")
	public static int loadPos = 10;

	// jag::oldscape::TitleScreen::m_loadString
	@ObfuscatedName("g.am")
	public static String loadString = "";

	// jag::oldscape::TitleScreen::m_loginscreen
	@ObfuscatedName("g.ap")
	public static int loginscreen = 0;

	// jag::oldscape::TitleScreen::m_loginMes1
	@ObfuscatedName("g.av")
	public static String loginMes1 = "";

	// jag::oldscape::TitleScreen::m_loginMes2
	@ObfuscatedName("g.ak")
	public static String loginMes2 = "";

	// jag::oldscape::TitleScreen::m_loginMes3
	@ObfuscatedName("g.az")
	public static String loginMes3 = "";

	// jag::oldscape::TitleScreen::m_loginUser
	@ObfuscatedName("g.an")
	public static String loginUser = "";

	// jag::oldscape::TitleScreen::m_loginPass
	@ObfuscatedName("g.ah")
	public static String loginPass = "";

	// // jag::oldscape::TitleScreen::m_loginSelect
	@ObfuscatedName("g.ay")
	public static int loginSelect = 0;

	// jag::oldscape::TitleScreen::m_charList
	@ObfuscatedName("g.al")
	public static String charList = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";

	// jag::oldscape::TitleScreen::m_switchScreen
	@ObfuscatedName("g.ao")
	public static boolean switchScreen = false;

	// m_gameworldListDownloadRequest
	@ObfuscatedName("l.ag")
	public static HTTPRequest gameworldListDownloadRequest;

	// jag::oldscape::TitleScreen::m_slBack
	@ObfuscatedName("da.ar")
	public static Pix32[] slBack;

	@ObfuscatedName("be.aq")
	public static String worldlistUrl;

	// jag::oldscape::TitleScreen::m_slFlags
	@ObfuscatedName("fn.aq")
	public static Pix8[] slFlags;

	// jag::oldscape::TitleScreen::m_slArrows
	@ObfuscatedName("au.at")
	public static Pix8[] slArrows;

	// jag::oldscape::TitleScreen::m_slStars
	@ObfuscatedName("bx.ae")
	public static Pix8[] slStars;

	// jag::oldscape::TitleScreen::m_slButton
	@ObfuscatedName("v.au")
	public static Pix8 slButton;

	// jag::oldscape::GameWorld::m_num
	@ObfuscatedName("g.ax")
	public static int num = 0;

	// jag::oldscape::GameWorld::m_list
	@ObfuscatedName("v.ai")
	public static WorldEntry[] list;

	// jag::oldscape::GameWorld::m_ordering
	@ObfuscatedName("g.bi")
	public static int[] ordering = new int[] { 0, 1, 2, 3 };

	// jag::oldscape::GameWorld::m_dirs
	@ObfuscatedName("g.bs")
	public static int[] dirs = new int[] { 1, 1, 1, 1 };

	// jag::oldscape::TitleScreen::m_slLastWorld
	@ObfuscatedName("g.bk")
	public static int slLastWorld = -1;

	public TitleScreen() throws Throwable {
		throw new Error();
	}

	// jag::oldscape::TitleScreen::ReadyMax
	@ObfuscatedName("v.r(I)I")
	public static int readyMax() {
		return 6;
	}

	// jag::oldscape::TitleScreen::Close
	@ObfuscatedName("bx.d(I)V")
	public static void close() {
		if (!open) {
			return;
		}

		titleBox = null;
		titleBut = null;
		runes = null;
		titleBack = null;
		titleBack2 = null;
		logo = null;
		titleMute = null;
		slBack = null;
		slFlags = null;
		slArrows = null;
		slStars = null;
		slButton = null;
		flameGradient0 = null;
		flameGradient1 = null;
		flameGradient2 = null;
		flameGradient = null;
		flameBuffer0 = null;
		flameBuffer1 = null;
		flameBuffer2 = null;
		flameBuffer3 = null;

		// todo: inlined method (MidiManager.stop?)
		MidiManager.state = 1;
		MidiManager.midis = null;
		MidiManager.pendingGroupId = -1;
		MidiManager.pendingFileId = -1;
		MidiManager.pendingVolume = 0;
		MidiManager.pendingLoop = false;
		MidiManager.fadeOutRate = 2;

		Js5Net.sendLoginLogoutPacket(true);
		open = false;
	}

	@ObfuscatedName("r.l(Ldj;I)V")
	public static void loop(GameShell app) {
		if (switchScreen) {
			worldSwitchLoop(app);
			return;
		}

		if (ClientMouseListener.mouseClickButton == 1 && ClientMouseListener.mouseClickX >= 715 && ClientMouseListener.mouseClickY >= 453) {
			mute = !mute;

			if (mute) {
				MidiManager.stop();
			} else {
				// todo: inlined method?
				Js5Loader var1 = Client.songs;
				int var2 = var1.getGroupId("scape main");
				int var3 = var1.getFileId(var2, "");
				MidiManager.play(var1, var2, var3, 255, false);
			}
		}

		if (Client.state == 5) {
			return;
		}

		flameCycle++;

		if (Client.state != 10) {
			return;
		}

		if (Client.lang == 0) {
			if (ClientMouseListener.mouseClickButton == 1) {
				byte var4 = 5;
				short var5 = 463;
				byte var6 = 100;
				byte var7 = 35;
				if (ClientMouseListener.mouseClickX >= var4 && ClientMouseListener.mouseClickX <= var4 + var6 && ClientMouseListener.mouseClickY >= var5 && ClientMouseListener.mouseClickY <= var5 + var7) {
					listFetch();
					return;
				}
			}
			if (gameworldListDownloadRequest != null) {
				listFetch();
			}
		}

		int var8 = ClientMouseListener.mouseClickButton;
		int var9 = ClientMouseListener.mouseClickX;
		int var10 = ClientMouseListener.mouseClickY;

		if (loginscreen == 0) {
			short var11 = 302;
			short var12 = 291;
			if (var8 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var12 - 20 && var10 <= var12 + 20) {
				loginscreen = 3;
				loginSelect = 0;
			}
			short var13 = 462;
			if (var8 == 1 && var9 >= var13 - 75 && var9 <= var13 + 75 && var10 >= var12 - 20 && var10 <= var12 + 20) {
				loginMes1 = Text.PLEASELOGIN1;
				loginMes2 = Text.PLEASELOGIN2;
				loginMes3 = Text.PLEASELOGIN3;
				loginscreen = 2;
				loginSelect = 0;
			}
		} else if (loginscreen == 2) {
			short var14 = 231;
			int var26 = var14 + 30;
			if (var8 == 1 && var10 >= var26 - 15 && var10 < var26) {
				loginSelect = 0;
			}
			var26 += 15;
			if (var8 == 1 && var10 >= var26 - 15 && var10 < var26) {
				loginSelect = 1;
			}
			var26 += 15;
			short var15 = 302;
			short var16 = 321;
			if (var8 == 1 && var9 >= var15 - 75 && var9 <= var15 + 75 && var10 >= var16 - 20 && var10 <= var16 + 20) {
				loginUser = loginUser.trim();
				if (loginUser.length() == 0) {
					loginMes(Text.LOGIN_USER_LENGTH_A, Text.LOGIN_USER_LENGTH_B, Text.LOGIN_USER_LENGTH_C);
					return;
				}
				if (loginPass.length() == 0) {
					loginMes(Text.LOGIN_PASS_LENGTH_A, Text.LOGIN_PASS_LENGTH_B, Text.LOGIN_PASS_LENGTH_C);
					return;
				}
				loginMes(Text.CONNECTING1, Text.CONNECTING2, Text.CONNECTING3);
				Client.setMainState(20);
				return;
			}

			short var17 = 462;
			if (var8 == 1 && var9 >= var17 - 75 && var9 <= var17 + 75 && var10 >= var16 - 20 && var10 <= var16 + 20) {
				loginscreen = 0;
				loginUser = "";
				loginPass = "";
			}

			while (ClientKeyboardListener.pollKey()) {
				boolean var21 = false;
				for (int var22 = 0; var22 < charList.length(); var22++) {
					if (ClientKeyboardListener.ch == charList.charAt(var22)) {
						var21 = true;
						break;
					}
				}

				if (loginSelect == 0) {
					if (ClientKeyboardListener.code == 85 && loginUser.length() > 0) {
						loginUser = loginUser.substring(0, loginUser.length() - 1);
					}
					if (ClientKeyboardListener.code == 84 || ClientKeyboardListener.code == 80) {
						loginSelect = 1;
					}
					if (var21 && loginUser.length() < 320) {
						loginUser += ClientKeyboardListener.ch;
					}
				} else if (loginSelect == 1) {
					if (ClientKeyboardListener.code == 85 && loginPass.length() > 0) {
						loginPass = loginPass.substring(0, loginPass.length() - 1);
					}
					if (ClientKeyboardListener.code == 84 || ClientKeyboardListener.code == 80) {
						loginSelect = 0;
					}
					if (Client.modewhere == 2 && ClientKeyboardListener.code == 84) {
						loginUser = loginUser.trim();
						if (loginUser.length() == 0) {
							loginMes(Text.LOGIN_USER_LENGTH_A, Text.LOGIN_USER_LENGTH_B, Text.LOGIN_USER_LENGTH_C);
							break;
						}
						if (loginPass.length() == 0) {
							loginMes(Text.LOGIN_PASS_LENGTH_A, Text.LOGIN_PASS_LENGTH_B, Text.LOGIN_PASS_LENGTH_C);
							break;
						}
						loginMes(Text.CONNECTING1, Text.CONNECTING2, Text.CONNECTING3);
						Client.setMainState(20);
						break;
					}
					if (var21 && loginPass.length() < 20) {
						loginPass += ClientKeyboardListener.ch;
					}
				}
			}
		} else if (loginscreen == 3) {
			short var23 = 382;
			short var24 = 321;
			if (var8 == 1 && var9 >= var23 - 75 && var9 <= var23 + 75 && var10 >= var24 - 20 && var10 <= var24 + 20) {
				loginscreen = 0;
			}
		}
	}

	// jag::oldscape::TitleScreen::Draw
	@ObfuscatedName("bg.m(Lfm;Lfm;I)V")
	public static void draw(PixFontGeneric arg0, PixFontGeneric arg1) {
		if (switchScreen) {
			worldSwitchRender(arg0, arg1);
			return;
		}

		if (Client.state == 0 || Client.state == 5) {
			int y = 20;
			arg0.centreString(Text.LOADING_TITLE, 382, 245 - y, 16777215, -1);

			int barY = 253 - y;
			Pix2D.drawRect(230, barY, 304, 34, 9179409);
			Pix2D.drawRect(231, barY + 1, 302, 32, 0);
			Pix2D.fillRect(232, barY + 2, loadPos * 3, 30, 9179409);
			Pix2D.fillRect(loadPos * 3 + 232, barY + 2, 300 - loadPos * 3, 30, 0);
			arg0.centreString(loadString, 382, 276 - y, 16777215, -1);
		}

		if (Client.state == 20) {
			titleBox.plotSprite(382 - titleBox.wi / 2, 271 - titleBox.hi / 2);

			int y = 211;
			arg0.centreString(loginMes1, 382, y, 16776960, 0);
			y += 15;

			arg0.centreString(loginMes2, 382, y, 16776960, 0);
			y += 15;

			arg0.centreString(loginMes3, 382, y, 16776960, 0);
			y += 15;

			y += 10;
			arg0.drawString(Text.USERNAMEPROMPT, 272, y, 16777215, 0);

			int var16 = 200;
			String user;
			for (user = loginUser; arg0.stringWid(user) > var16; user = user.substring(0, user.length() - 1)) {
			}

			arg0.drawString(PixFont.escape(user), 312, y, 16777215, 0);
			y += 15;

			// todo: inlined method?
			String var8 = Text.PASSWORDPROMPT;
			String var9 = loginPass;
			String var10 = StringTools.getRepeatedCharacter('*', var9.length());
			arg0.drawString(var8 + var10, 274, y, 16777215, 0);
			y += 15;
		}

		if (Client.state == 10) {
			titleBox.plotSprite(202, 171);

			if (loginscreen == 0) {
				int y = 251;
				arg0.centreString(Text.WELCOMETORUNESCAPE, 382, y, 16776960, 0);
				y += 30;

				int x = 302;
				y = 291;
				titleBut.plotSprite(x - 73, y - 20);
				arg0.drawStringMultiline(Text.NEWUSER, x - 73, y - 20, 144, 40, 16777215, 0, 1, 1, 0);

				x = 462;
				titleBut.plotSprite(x - 73, y - 20);
				arg0.drawStringMultiline(Text.EXISTINGUSER, x - 73, y - 20, 144, 40, 16777215, 0, 1, 1, 0);
			} else if (loginscreen == 2) {
				int y = 211;
				arg0.centreString(loginMes1, 382, y, 16776960, 0);
				y += 15;

				arg0.centreString(loginMes2, 382, y, 16776960, 0);
				y += 15;

				arg0.centreString(loginMes3, 382, y, 16776960, 0);
				y += 15;

				y += 10;
				arg0.drawString(Text.USERNAMEPROMPT, 272, y, 16777215, 0);

				int var16 = 200;
				String user;
				for (user = loginUser; arg0.stringWid(user) > var16; user = user.substring(1)) {
				}

				arg0.drawString(PixFont.escape(user) + (loginSelect == 0 & Client.loopCycle % 40 < 20 ? StringConstants.TAG_COLOUR(16776960) + StringConstants.PIPE : ""), 312, y, 16777215, 0);
				y += 15;

				// todo: inlined method?
				String var19 = Text.PASSWORDPROMPT;
				String var20 = loginPass;
				String var21 = StringTools.getRepeatedCharacter('*', var20.length());
				arg0.drawString(var19 + var21 + (loginSelect == 1 & Client.loopCycle % 40 < 20 ? StringConstants.TAG_COLOUR(16776960) + StringConstants.PIPE : ""), 274, y, 16777215, 0);
				y += 15;

				int x = 302;
				y = 321;
				titleBut.plotSprite(x - 73, y - 20);
				arg0.centreString(Text.LOGIN, x, y + 5, 16777215, 0);

				x = 462;
				titleBut.plotSprite(x - 73, y - 20);
				arg0.centreString(Text.CANCEL, x, y + 5, 16777215, 0);
			} else if (loginscreen == 3) {
				int y = 211;
				arg0.centreString(Text.NEWUSER1, 382, y, 16776960, 0);

				y = 236;
				arg0.centreString(Text.NEWUSER2, 382, y, 16777215, 0);
				y += 15;

				arg0.centreString(Text.NEWUSER3, 382, y, 16777215, 0);
				y += 15;

				arg0.centreString(Text.NEWUSER4, 382, y, 16777215, 0);
				y += 15;

				arg0.centreString(Text.NEWUSER5, 382, y, 16777215, 0);
				y += 15;

				int x = 382;
				y = 321;
				titleBut.plotSprite(x - 73, y - 20);
				arg0.centreString(Text.CANCEL, x, y + 5, 16777215, 0);
			}
		}

		if (flameCycle > 0) {
			int var28 = flameCycle;

			short var29 = 256;
			flameCycle0 += var28 * 128;

			if (flameCycle0 > flameBuffer0.length) {
				flameCycle0 -= flameBuffer0.length;
				int var30 = (int) (Math.random() * 12.0D);
				generateFlameCoolingMap(runes[var30]);
			}

			int var31 = 0;
			int var32 = var28 * 128;
			int var33 = (var29 - var28) * 128;
			for (int var34 = 0; var34 < var33; var34++) {
				int var35 = flameBuffer2[var31 + var32] - flameBuffer0[flameCycle0 + var31 & flameBuffer0.length - 1] * var28 / 6;
				if (var35 < 0) {
					var35 = 0;
				}

				flameBuffer2[var31++] = var35;
			}

			for (int var36 = var29 - var28; var36 < var29; var36++) {
				int var37 = var36 * 128;
				for (int var38 = 0; var38 < 128; var38++) {
					int var39 = (int) (Math.random() * 100.0D);
					if (var39 < 50 && var38 > 10 && var38 < 118) {
						flameBuffer2[var37 + var38] = 255;
					} else {
						flameBuffer2[var37 + var38] = 0;
					}
				}
			}

			if (flameGradientCycle0 > 0) {
				flameGradientCycle0 -= var28 * 4;
			}

			if (flameGradientCycle1 > 0) {
				flameGradientCycle1 -= var28 * 4;
			}

			if (flameGradientCycle0 == 0 && flameGradientCycle1 == 0) {
				int var40 = (int) (Math.random() * (double) (2000 / var28));
				if (var40 == 0) {
					flameGradientCycle0 = 1024;
				}
				if (var40 == 1) {
					flameGradientCycle1 = 1024;
				}
			}

			for (int var41 = 0; var41 < var29 - var28; var41++) {
				flameLineOffset[var41] = flameLineOffset[var28 + var41];
			}

			for (int var42 = var29 - var28; var42 < var29; var42++) {
				flameLineOffset[var42] = (int) (Math.sin((double) loopCycle / 14.0D) * 16.0D + Math.sin((double) loopCycle / 15.0D) * 14.0D + Math.sin((double) loopCycle / 16.0D) * 12.0D);
				loopCycle++;
			}

			flameSparks += var28;
			int var43 = ((Client.loopCycle & 0x1) + var28) / 2;

			if (var43 > 0) {
				for (int var44 = 0; var44 < flameSparks * 100; var44++) {
					int var45 = (int) (Math.random() * 124.0D) + 2;
					int var46 = (int) (Math.random() * 128.0D) + 128;
					flameBuffer2[(var46 << 7) + var45] = 192;
				}

				flameSparks = 0;

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
									var52 += flameBuffer3[var43 * 128 + var51 + var54];
								}
								if (var53 - (var43 + 1) >= 0) {
									var52 -= flameBuffer3[var51 + var54 - (var43 + 1) * 128];
								}
								if (var53 >= 0) {
									flameBuffer2[var51 + var54] = var52 / (var43 * 2 + 1);
								}
							}
							var51++;
						}
					}
					int var48 = 0;
					int var49 = var47 * 128;
					for (int var50 = -var43; var50 < 128; var50++) {
						if (var43 + var50 < 128) {
							var48 += flameBuffer2[var49 + var50 + var43];
						}
						if (var50 - (var43 + 1) >= 0) {
							var48 -= flameBuffer2[var49 + var50 - (var43 + 1)];
						}
						if (var50 >= 0) {
							flameBuffer3[var49 + var50] = var48 / (var43 * 2 + 1);
						}
					}
					var47++;
				}
			}
			flameCycle = 0;
		}

		short var55 = 256;
		if (flameGradientCycle0 > 0) {
			for (int var56 = 0; var56 < 256; var56++) {
				if (flameGradientCycle0 > 768) {
					flameGradient[var56] = merge(flameGradient0[var56], flameGradient1[var56], 1024 - flameGradientCycle0);
				} else if (flameGradientCycle0 > 256) {
					flameGradient[var56] = flameGradient1[var56];
				} else {
					flameGradient[var56] = merge(flameGradient1[var56], flameGradient0[var56], 256 - flameGradientCycle0);
				}
			}
		} else if (flameGradientCycle1 > 0) {
			for (int var57 = 0; var57 < 256; var57++) {
				if (flameGradientCycle1 > 768) {
					flameGradient[var57] = merge(flameGradient0[var57], flameGradient2[var57], 1024 - flameGradientCycle1);
				} else if (flameGradientCycle1 > 256) {
					flameGradient[var57] = flameGradient2[var57];
				} else {
					flameGradient[var57] = merge(flameGradient2[var57], flameGradient0[var57], 256 - flameGradientCycle1);
				}
			}
		} else {
			for (int var58 = 0; var58 < 256; var58++) {
				flameGradient[var58] = flameGradient0[var58];
			}
		}
		Pix2D.setClipping(0, 9, 128, var55 + 7);
		titleBack.quickPlotSprite(0, 0);

		Pix2D.resetClipping();
		int var59 = 0;
		int var60 = 6885;
		for (int var61 = 1; var61 < var55 - 1; var61++) {
			int var62 = (var55 - var61) * flameLineOffset[var61] / var55;
			int var63 = var62 + 22;
			if (var63 < 0) {
				var63 = 0;
			}
			var59 += var63;
			for (int var64 = var63; var64 < 128; var64++) {
				int var65 = flameBuffer2[var59++];
				if (var65 == 0) {
					var60++;
				} else {
					int var67 = 256 - var65;
					int var68 = flameGradient[var65];
					int var69 = GameShell.drawArea.data[var60];
					GameShell.drawArea.data[var60++] = ((var68 & 0xFF00) * var65 + (var69 & 0xFF00) * var67 & 0xFF0000) + ((var68 & 0xFF00FF) * var65 + (var69 & 0xFF00FF) * var67 & 0xFF00FF00) >> 8;
				}
			}
			var60 += var63 + 765 - 128;
		}
		Pix2D.setClipping(637, 9, 765, var55 + 7);
		titleBack2.quickPlotSprite(382, 0);

		Pix2D.resetClipping();
		int var70 = 0;
		int var71 = 7546;
		for (int var72 = 1; var72 < var55 - 1; var72++) {
			int var73 = (var55 - var72) * flameLineOffset[var72] / var55;
			int var74 = 103 - var73;
			int var75 = var71 + var73;
			for (int var76 = 0; var76 < var74; var76++) {
				int var77 = flameBuffer2[var70++];
				if (var77 == 0) {
					var75++;
				} else {
					int var79 = 256 - var77;
					int var80 = flameGradient[var77];
					int var81 = GameShell.drawArea.data[var75];
					GameShell.drawArea.data[var75++] = ((var80 & 0xFF00FF) * var77 + (var81 & 0xFF00FF) * var79 & 0xFF00FF00) + ((var80 & 0xFF00) * var77 + (var81 & 0xFF00) * var79 & 0xFF0000) >> 8;
				}
			}
			var70 += 128 - var74;
			var71 = 765 - var74 - var73 + var75;
		}
		titleMute[mute ? 1 : 0].plotSprite(725, 463);

		if (Client.state > 5 && Client.lang == 0) {
			if (slButton == null) {
				slButton = PixLoader.makePix8(Client.sprites, "sl_button", "");
			} else {
				byte x = 5;
				short y = 463;
				byte w = 100;
				byte h = 35;

				slButton.plotSprite(x, y);

				arg0.centreString(Text.WORLD + " " + Client.worldid, w / 2 + x, h / 2 + y - 2, 16777215, 0);

				if (gameworldListDownloadRequest == null) {
					arg1.centreString(Text.CLICKTOSWITCH, w / 2 + x, h / 2 + y + 12, 16777215, 0);
				} else {
					arg1.centreString(Text.LOADINGDOTDOTDOT, w / 2 + x, h / 2 + y + 12, 16777215, 0);
				}
			}
		}

		try {
			Graphics g = GameShell.canvas.getGraphics();
			GameShell.drawArea.draw(g, 0, 0);
		} catch (Exception ex) {
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

	// jag::oldscape::TitleFlames::GenerateFlameCoolingMap
	@ObfuscatedName("br.n(Lft;B)V")
	public static void generateFlameCoolingMap(Pix8 arg0) {
		short var1 = 256;
		for (int var2 = 0; var2 < flameBuffer0.length; var2++) {
			flameBuffer0[var2] = 0;
		}
		for (int var3 = 0; var3 < 5000; var3++) {
			int var4 = (int) (Math.random() * 128.0D * (double) var1);
			flameBuffer0[var4] = (int) (Math.random() * 256.0D);
		}
		for (int var5 = 0; var5 < 20; var5++) {
			for (int var6 = 1; var6 < var1 - 1; var6++) {
				for (int var7 = 1; var7 < 127; var7++) {
					int var8 = (var6 << 7) + var7;
					flameBuffer1[var8] = (flameBuffer0[var8 - 1] + flameBuffer0[var8 + 1] + flameBuffer0[var8 - 128] + flameBuffer0[var8 + 128]) / 4;
				}
			}
			int[] var9 = flameBuffer0;
			flameBuffer0 = flameBuffer1;
			flameBuffer1 = var9;
		}
		if (arg0 != null) {
			int var10 = 0;
			for (int var11 = 0; var11 < arg0.hi; var11++) {
				for (int var12 = 0; var12 < arg0.wi; var12++) {
					if (arg0.data[var10++] != 0) {
						int var13 = var12 + 16 + arg0.xof;
						int var14 = var11 + 16 + arg0.yof;
						int var15 = (var14 << 7) + var13;
						flameBuffer0[var15] = 0;
					}
				}
			}
		}
	}

	// jag::oldscape::TitleFlames::Merge
	@ObfuscatedName("eh.j(IIII)I")
	public static int merge(int arg0, int arg1, int arg2) {
		int var3 = 256 - arg2;
		return ((arg0 & 0xFF00FF) * var3 + (arg1 & 0xFF00FF) * arg2 & 0xFF00FF00) + ((arg0 & 0xFF00) * var3 + (arg1 & 0xFF00) * arg2 & 0xFF0000) >> 8;
	}

	// jag::oldscape::TitleScreen::WorldSwitchRender
	@ObfuscatedName("de.z(Lfm;Lfm;I)V")
	public static void worldSwitchRender(PixFontGeneric arg0, PixFontGeneric arg1) {
		if (slBack == null) {
			slBack = PixLoader.makePix32Array(Client.sprites, "sl_back", "");
		}

		if (slFlags == null) {
			slFlags = PixLoader.makePix8Array(Client.sprites, "sl_flags", "");
		}

		if (slArrows == null) {
			slArrows = PixLoader.makePix8Array(Client.sprites, "sl_arrows", "");
		}

		if (slStars == null) {
			slStars = PixLoader.makePix8Array(Client.sprites, "sl_stars", "");
		}

		Pix2D.fillRect(0, 23, 765, 480, 0);
		Pix2D.fillRectVGrad(0, 0, 125, 23, 0xbd9839, 0x8b6608);
		Pix2D.fillRectVGrad(125, 0, 640, 23, 0x4f4f4f, 0x292929);
		arg0.centreString(Text.SELECTAWORLD, 62, 15, 0, -1);

		if (slStars != null) {
			slStars[1].plotSprite(140, 1);
			arg1.drawString(Text.MEMBERSONLYWORLD, 152, 10, 16777215, -1);

			slStars[0].plotSprite(140, 12);
			arg1.drawString(Text.FREEWORLD, 152, 21, 16777215, -1);
		}

		if (slArrows != null) {
			int x = 280;

			if (ordering[0] == 0 && dirs[0] == 0) {
				slArrows[2].plotSprite(x, 4);
			} else {
				slArrows[0].plotSprite(x, 4);
			}

			if (ordering[0] == 0 && dirs[0] == 1) {
				slArrows[3].plotSprite(x + 15, 4);
			} else {
				slArrows[1].plotSprite(x + 15, 4);
			}

			arg0.drawString(Text.SL_WORLD, x + 32, 17, 16777215, -1);

			x = 390;

			if (ordering[0] == 1 && dirs[0] == 0) {
				slArrows[2].plotSprite(x, 4);
			} else {
				slArrows[0].plotSprite(x, 4);
			}

			if (ordering[0] == 1 && dirs[0] == 1) {
				slArrows[3].plotSprite(x + 15, 4);
			} else {
				slArrows[1].plotSprite(x + 15, 4);
			}

			arg0.drawString(Text.SL_PLAYERS, x + 32, 17, 16777215, -1);

			x = 500;

			if (ordering[0] == 2 && dirs[0] == 0) {
				slArrows[2].plotSprite(x, 4);
			} else {
				slArrows[0].plotSprite(x, 4);
			}

			if (ordering[0] == 2 && dirs[0] == 1) {
				slArrows[3].plotSprite(x + 15, 4);
			} else {
				slArrows[1].plotSprite(x + 15, 4);
			}

			arg0.drawString(Text.SL_LOCATION, x + 32, 17, 16777215, -1);

			x = 610;

			if (ordering[0] == 3 && dirs[0] == 0) {
				slArrows[2].plotSprite(x, 4);
			} else {
				slArrows[0].plotSprite(x, 4);
			}

			if (ordering[0] == 3 && dirs[0] == 1) {
				slArrows[3].plotSprite(x + 15, 4);
			} else {
				slArrows[1].plotSprite(x + 15, 4);
			}

			arg0.drawString(Text.SL_TYPE, x + 32, 17, 16777215, -1);
		}

		Pix2D.fillRect(708, 4, 50, 16, 0);
		arg1.centreString(Text.CANCEL, 733, 16, 16777215, -1);

		slLastWorld = -1;

		if (slBack != null) {
			byte var6 = 88;
			byte var7 = 19;
			int var8 = 765 / (var6 + 1);
			int var9 = 480 / (var7 + 1);

			int var10;
			int var11;
			do {
				var10 = var9;
				var11 = var8;
				if ((var8 - 1) * var9 >= num) {
					var8--;
				}
				if ((var9 - 1) * var8 >= num) {
					var9--;
				}
				if ((var9 - 1) * var8 >= num) {
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

			for (int var19 = 0; var19 < num; var19++) {
				WorldEntry var20 = list[var19];
				boolean var21 = true;
				String var22 = Integer.toString(var20.players);
				if (var20.players == -1) {
					var22 = Text.OFFLINEWORLD;
					var21 = false;
				} else if (var20.players > 1980) {
					var22 = Text.FULLWORLD;
					var21 = false;
				}

				if (ClientMouseListener.mouseX >= var17 && ClientMouseListener.mouseY >= var16 && ClientMouseListener.mouseX < var6 + var17 && ClientMouseListener.mouseY < var7 + var16 && var21) {
					slLastWorld = var19;
					slBack[var20.members ? 1 : 0].litPlotSprite(var17, var16, 128, 0xffffff);
				} else {
					slBack[var20.members ? 1 : 0].quickPlotSprite(var17, var16);
				}

				if (slFlags != null) {
					slFlags[var20.country + (var20.members ? 8 : 0)].plotSprite(var17 + 29, var16);
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
			Graphics g = GameShell.canvas.getGraphics();
			GameShell.drawArea.draw(g, 0, 0);
		} catch (Exception var25) {
			GameShell.canvas.repaint();
		}
	}

	// jag::oldscape::TitleScreen::WorldSwitchLoop
	@ObfuscatedName("cm.g(Ldj;I)V")
	public static void worldSwitchLoop(GameShell shell) {
		if (ClientMouseListener.mouseClickButton != 1) {
			return;
		}

		short var1 = 280;
		if (ClientMouseListener.mouseClickX >= var1 && ClientMouseListener.mouseClickX <= var1 + 14 && ClientMouseListener.mouseClickY >= 4 && ClientMouseListener.mouseClickY <= 18) {
			listReorder(0, 0);
			return;
		}
		if (ClientMouseListener.mouseClickX >= var1 + 15 && ClientMouseListener.mouseClickX <= var1 + 80 && ClientMouseListener.mouseClickY >= 4 && ClientMouseListener.mouseClickY <= 18) {
			listReorder(0, 1);
			return;
		}

		short var2 = 390;
		if (ClientMouseListener.mouseClickX >= var2 && ClientMouseListener.mouseClickX <= var2 + 14 && ClientMouseListener.mouseClickY >= 4 && ClientMouseListener.mouseClickY <= 18) {
			listReorder(1, 0);
			return;
		}
		if (ClientMouseListener.mouseClickX >= var2 + 15 && ClientMouseListener.mouseClickX <= var2 + 80 && ClientMouseListener.mouseClickY >= 4 && ClientMouseListener.mouseClickY <= 18) {
			listReorder(1, 1);
			return;
		}

		short var3 = 500;
		if (ClientMouseListener.mouseClickX >= var3 && ClientMouseListener.mouseClickX <= var3 + 14 && ClientMouseListener.mouseClickY >= 4 && ClientMouseListener.mouseClickY <= 18) {
			listReorder(2, 0);
			return;
		}
		if (ClientMouseListener.mouseClickX >= var3 + 15 && ClientMouseListener.mouseClickX <= var3 + 80 && ClientMouseListener.mouseClickY >= 4 && ClientMouseListener.mouseClickY <= 18) {
			listReorder(2, 1);
			return;
		}

		short var4 = 610;
		if (ClientMouseListener.mouseClickX >= var4 && ClientMouseListener.mouseClickX <= var4 + 14 && ClientMouseListener.mouseClickY >= 4 && ClientMouseListener.mouseClickY <= 18) {
			listReorder(3, 0);
			return;
		}
		if (ClientMouseListener.mouseClickX >= var4 + 15 && ClientMouseListener.mouseClickX <= var4 + 80 && ClientMouseListener.mouseClickY >= 4 && ClientMouseListener.mouseClickY <= 18) {
			listReorder(3, 1);
			return;
		}

		if (ClientMouseListener.mouseClickX >= 708 && ClientMouseListener.mouseClickY >= 4 && ClientMouseListener.mouseClickX <= 758 && ClientMouseListener.mouseClickY <= 20) {
			switchScreen = false;
			titleBack.quickPlotSprite(0, 0);
			titleBack2.quickPlotSprite(382, 0);
			logo.plotSprite(382 - logo.wi / 2, 18);
			return;
		}

		if (slLastWorld != -1) {
			WorldEntry var5 = list[slLastWorld];
			if (Client.memServer == var5.members) {
				Client.loginHost = var5.host;
				Client.worldid = var5.id;
				Client.loginGamePort = Client.modewhere == 0 ? 43594 : var5.id + 40000;
				Client.loginJs5Port = Client.modewhere == 0 ? 443 : var5.id + 50000;
				Client.loginPort = Client.loginGamePort;
				switchScreen = false;
				titleBack.quickPlotSprite(0, 0);
				titleBack2.quickPlotSprite(382, 0);
				logo.plotSprite(382 - logo.wi / 2, 18);
				return;
			}

			String var6 = "";
			if (Client.modewhere != 0) {
				var6 = ":" + (var5.id + 7000);
			}
			String var7 = "http://" + var5.host + var6 + "/j" + Client.js;
			try {
				shell.getAppletContext().showDocument(new URL(var7), "_self");
			} catch (Exception ignore) {
			}
		}
	}

	// jag::oldscape::GameWorld::ListFetch
	@ObfuscatedName("ac.q(I)V")
	public static void listFetch() {
		try {
			if (gameworldListDownloadRequest == null) {
				gameworldListDownloadRequest = new HTTPRequest(GameShell.signLink, new URL(worldlistUrl));
				return;
			}

			byte[] src = gameworldListDownloadRequest.getData();
			if (src == null) {
				return;
			}

			Packet buf = new Packet(src);
			num = buf.g2();
			list = new WorldEntry[num];

			int i = 0;
			while (i < num) {
				WorldEntry world = list[i] = new WorldEntry();
				int info = buf.g2();
				world.id = info & 0x7FFF;
				world.members = (info & 0x8000) != 0;
				world.host = buf.gjstr();
				world.country = buf.g1();
				world.players = buf.g2b();
				world.index = i++;
			}

			quickSort(list, 0, list.length - 1, ordering, dirs);
			switchScreen = true;
			gameworldListDownloadRequest = null;
		} catch (Exception ex) {
			ex.printStackTrace();
			gameworldListDownloadRequest = null;
		}
	}

	// jag::oldscape::GameWorld::ListReorder
	@ObfuscatedName("client.i(III)V")
	public static void listReorder(int arg0, int arg1) {
		int[] var2 = new int[4];
		int[] var3 = new int[4];
		var2[0] = arg0;
		var3[0] = arg1;

		int var4 = 1;
		for (int var5 = 0; var5 < 4; var5++) {
			if (ordering[var5] != arg0) {
				var2[var4] = ordering[var5];
				var3[var4] = dirs[var5];
				var4++;
			}
		}
		ordering = var2;
		dirs = var3;

		quickSort(list, 0, list.length - 1, ordering, dirs);
	}

	// jag::oldscape::GameWorld::QuickSort
	@ObfuscatedName("bh.s([Lc;II[I[II)V")
	public static void quickSort(WorldEntry[] arg0, int arg1, int arg2, int[] arg3, int[] arg4) {
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

		quickSort(arg0, arg1, var6, arg3, arg4);
		quickSort(arg0, var6 + 1, arg2, arg3, arg4);
	}

	// jag::oldscape::TitleScreen::Open
	public static void open(Canvas var1, Js5Loader binary, Js5Loader sprites) {
		if (open) {
			return;
		}

		Pix2D.cls();

		byte[] back = binary.getFile("title.jpg", "");
		titleBack = new Pix32(back, var1);
		titleBack2 = titleBack.copyHFlip();
		logo = PixLoader.makePix8(sprites, "logo", "");
		titleBox = PixLoader.makePix8(sprites, "titlebox", "");
		titleBut = PixLoader.makePix8(sprites, "titlebutton", "");
		runes = PixLoader.makePix8Array(sprites, "runes", "");
		titleMute = PixLoader.makePix8Array(sprites, "title_mute", "");

		flameGradient0 = new int[256];
		for (int var5 = 0; var5 < 64; var5++) {
			flameGradient0[var5] = var5 * 262144;
		}
		for (int var6 = 0; var6 < 64; var6++) {
			flameGradient0[var6 + 64] = var6 * 1024 + 16711680;
		}
		for (int var7 = 0; var7 < 64; var7++) {
			flameGradient0[var7 + 128] = var7 * 4 + 16776960;
		}
		for (int var8 = 0; var8 < 64; var8++) {
			flameGradient0[var8 + 192] = 16777215;
		}

		flameGradient1 = new int[256];
		for (int var9 = 0; var9 < 64; var9++) {
			flameGradient1[var9] = var9 * 1024;
		}
		for (int var10 = 0; var10 < 64; var10++) {
			flameGradient1[var10 + 64] = var10 * 4 + 65280;
		}
		for (int var11 = 0; var11 < 64; var11++) {
			flameGradient1[var11 + 128] = var11 * 262144 + 65535;
		}
		for (int var12 = 0; var12 < 64; var12++) {
			flameGradient1[var12 + 192] = 16777215;
		}

		flameGradient2 = new int[256];
		for (int var13 = 0; var13 < 64; var13++) {
			flameGradient2[var13] = var13 * 4;
		}
		for (int var14 = 0; var14 < 64; var14++) {
			flameGradient2[var14 + 64] = var14 * 262144 + 255;
		}
		for (int var15 = 0; var15 < 64; var15++) {
			flameGradient2[var15 + 128] = var15 * 1024 + 16711935;
		}
		for (int var16 = 0; var16 < 64; var16++) {
			flameGradient2[var16 + 192] = 16777215;
		}

		flameGradient = new int[256];
		flameBuffer0 = new int[32768];
		flameBuffer1 = new int[32768];
		generateFlameCoolingMap(null);
		flameBuffer2 = new int[32768];
		flameBuffer3 = new int[32768];

		loginscreen = 0;
		loginUser = "";
		loginPass = "";

		switchScreen = false;

		if (Client.midiVolume == 0) {
			mute = true;
		} else {
			mute = false;
		}

		if (mute) {
			MidiManager.stop2();
		} else {
			// todo: inlined method?
			Js5Loader songs = Client.songs;
			int var18 = songs.getGroupId("scape main");
			int var19 = songs.getFileId(var18, "");
			MidiManager.swapSongs(2, songs, var18, var19, 255, false);
		}

		Js5Net.sendLoginLogoutPacket(false);

		open = true;
		titleBack.quickPlotSprite(0, 0);
		titleBack2.quickPlotSprite(382, 0);
		logo.plotSprite(382 - logo.wi / 2, 18);
	}

	// jag::oldscape::TitleScreen::Ready
	public static int ready(Js5Loader var25, Js5Loader var26) {
		int var27 = 0;
		if (var25.requestDownload("title.jpg", "")) {
			var27++;
		}
		if (var26.requestDownload("logo", "")) {
			var27++;
		}
		if (var26.requestDownload("titlebox", "")) {
			var27++;
		}
		if (var26.requestDownload("titlebutton", "")) {
			var27++;
		}
		if (var26.requestDownload("runes", "")) {
			var27++;
		}
		if (var26.requestDownload("title_mute", "")) {
			var27++;
		}
		var26.requestDownload("sl_back", "");
		var26.requestDownload("sl_flags", "");
		var26.requestDownload("sl_arrows", "");
		var26.requestDownload("sl_stars", "");
		var26.requestDownload("sl_button", "");
		return var27;
	}
}
