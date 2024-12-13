package jagex3.jstring;

import deob.ObfuscatedName;
import jagex3.client.Client;

@ObfuscatedName("cl")
public class StringUtil {

	public StringUtil() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("ek.r(IB)Ljava/lang/String;")
	public static String method1846(int arg0) {
		return (arg0 >> 24 & 0xFF) + "." + (arg0 >> 16 & 0xFF) + "." + (arg0 >> 8 & 0xFF) + "." + (arg0 & 0xFF);
	}

	@ObfuscatedName("ef.d([Ljava/lang/CharSequence;III)Ljava/lang/String;")
	public static String method1785(CharSequence[] arg0, int arg1, int arg2) {
		if (arg2 == 0) {
			return "";
		} else if (arg2 == 1) {
			CharSequence var3 = arg0[arg1];
			return var3 == null ? "null" : var3.toString();
		} else {
			int var4 = arg1 + arg2;
			int var5 = 0;
			for (int var6 = arg1; var6 < var4; var6++) {
				CharSequence var7 = arg0[var6];
				if (var7 == null) {
					var5 += 4;
				} else {
					var5 += var7.length();
				}
			}
			StringBuilder var8 = new StringBuilder(var5);
			for (int var9 = arg1; var9 < var4; var9++) {
				CharSequence var10 = arg0[var9];
				if (var10 == null) {
					var8.append("null");
				} else {
					var8.append(var10);
				}
			}
			return var8.toString();
		}
	}

	@ObfuscatedName("j.l(Ljava/lang/CharSequence;I)Z")
	public static boolean method62(CharSequence arg0) {
		boolean var1 = false;
		boolean var2 = false;
		int var3 = 0;
		int var4 = arg0.length();
		int var5 = 0;
		boolean var7;
		while (true) {
			if (var5 >= var4) {
				var7 = var2;
				break;
			}
			label69:
			{
				char var6 = arg0.charAt(var5);
				if (var5 == 0) {
					if (var6 == '-') {
						var1 = true;
						break label69;
					}
					if (var6 == '+') {
						break label69;
					}
				}
				int var9;
				if (var6 >= '0' && var6 <= '9') {
					var9 = var6 - '0';
				} else if (var6 >= 'A' && var6 <= 'Z') {
					var9 = var6 - '7';
				} else {
					if (var6 < 'a' || var6 > 'z') {
						var7 = false;
						break;
					}
					var9 = var6 - 'W';
				}
				if (var9 >= 10) {
					var7 = false;
					break;
				}
				if (var1) {
					var9 = -var9;
				}
				int var8 = var3 * 10 + var9;
				if (var8 / 10 != var3) {
					var7 = false;
					break;
				}
				var3 = var8;
				var2 = true;
			}
			var5++;
		}
		return var7;
	}

	@ObfuscatedName("ao.m(Ljava/lang/CharSequence;II)I")
	public static int method557(CharSequence arg0, int arg1) {
		return method91(arg0, arg1, true);
	}

	@ObfuscatedName("g.c(Ljava/lang/CharSequence;IZB)I")
	public static int method91(CharSequence arg0, int arg1, boolean arg2) {
		if (arg1 < 2 || arg1 > 36) {
			throw new IllegalArgumentException("");
		}
		boolean var3 = false;
		boolean var4 = false;
		int var5 = 0;
		int var6 = arg0.length();
		for (int var7 = 0; var7 < var6; var7++) {
			char var8 = arg0.charAt(var7);
			if (var7 == 0) {
				if (var8 == '-') {
					var3 = true;
					continue;
				}
				if (var8 == '+' && arg2) {
					continue;
				}
			}
			int var10;
			if (var8 >= '0' && var8 <= '9') {
				var10 = var8 - '0';
			} else if (var8 >= 'A' && var8 <= 'Z') {
				var10 = var8 - '7';
			} else if (var8 >= 'a' && var8 <= 'z') {
				var10 = var8 - 'W';
			} else {
				throw new NumberFormatException();
			}
			if (var10 >= arg1) {
				throw new NumberFormatException();
			}
			if (var3) {
				var10 = -var10;
			}
			int var9 = arg1 * var5 + var10;
			if (var9 / arg1 != var5) {
				throw new NumberFormatException();
			}
			var5 = var9;
			var4 = true;
		}
		if (!var4) {
			throw new NumberFormatException();
		}
		return var5;
	}

	@ObfuscatedName("bn.n(IZI)Ljava/lang/String;")
	public static String method903(int arg0, boolean arg1) {
		if (!arg1 || arg0 < 0) {
			return Integer.toString(arg0);
		}
		int var2 = arg0;
		String var9;
		if (arg1 && arg0 >= 0) {
			int var3 = 2;
			int var4 = arg0 / 10;
			while (var4 != 0) {
				var4 /= 10;
				var3++;
			}
			char[] var5 = new char[var3];
			var5[0] = '+';
			for (int var6 = var3 - 1; var6 > 0; var6--) {
				int var7 = var2;
				var2 /= 10;
				int var8 = var7 - var2 * 10;
				if (var8 >= 10) {
					var5[var6] = (char) (var8 + 87);
				} else {
					var5[var6] = (char) (var8 + 48);
				}
			}
			var9 = new String(var5);
		} else {
			var9 = Integer.toString(arg0, 10);
		}
		return var9;
	}

	@ObfuscatedName("ck.j(Ljava/lang/CharSequence;I)I")
	public static int hashCode(CharSequence arg0) {
		int var1 = arg0.length();
		int var2 = 0;
		for (int var3 = 0; var3 < var1; var3++) {
			var2 = (var2 << 5) - var2 + Cp1252.method796(arg0.charAt(var3));
		}
		return var2;
	}

	@ObfuscatedName("cu.z(CI)Z")
	public static boolean isAlpha(char c) {
		return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
	}

	@ObfuscatedName("n.g(Ljava/lang/String;B)Ljava/lang/String;")
	public static String method54(String arg0) {
		int var1 = arg0.length();
		char[] var2 = new char[var1];
		byte var3 = 2;
		for (int var4 = 0; var4 < var1; var4++) {
			char var5 = arg0.charAt(var4);
			if (var3 == 0) {
				var5 = Character.toLowerCase(var5);
			} else if (var3 == 2 || Character.isUpperCase(var5)) {
				var5 = JString.method261(var5);
			}
			if (Character.isLetter(var5)) {
				var3 = 0;
			} else if (var5 == '.' || var5 == '?' || var5 == '!') {
				var3 = 2;
			} else if (!Character.isSpaceChar(var5)) {
				var3 = 1;
			} else if (var3 != 2) {
				var3 = 1;
			}
			var2[var4] = var5;
		}
		return new String(var2);
	}

	@ObfuscatedName("bd.q(CII)Ljava/lang/String;")
	public static String method946(char arg0, int arg1) {
		char[] var2 = new char[arg1];
		for (int var3 = 0; var3 < arg1; var3++) {
			var2[var3] = arg0;
		}
		return new String(var2);
	}

	public static boolean isNumeric(char c) {
		return c >= '0' && c <= '9';
	}

	public static boolean isAlphaNumeric(char c) {
		return c >= '0' && c <= '9' || c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
	}

	public static boolean isPrintable(char c) {
		if (c >= ' ' && c <= '~') {
			return true;
		} else if (c >= 160 && c <= 255) {
			return true;
		} else if (c == 8364 || c == 338 || c == 8212 || c == 339 || c == 376) {
			return true;
		} else {
			return false;
		}
	}

	public static int compare(String var247, String var248) {
		int var249 = Client.lang;
		int var250 = var247.length();
		int var251 = var248.length();
		int var252 = 0;
		int var253 = 0;
		byte var254 = 0;
		byte var255 = 0;
		int var256;
		label2100:
		while (true) {
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

		return var280;
	}
}
