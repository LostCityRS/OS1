package jagex2.jstring;

import deob.ObfuscatedName;

@ObfuscatedName("cj")
public class JString {

	@ObfuscatedName("cj.r")
	public static final char[] field1149 = new char[] { '_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public JString() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("cj.r(Ljava/lang/CharSequence;I)J")
	public static long toBase37(CharSequence arg0) {
		long var1 = 0L;
		int var3 = arg0.length();
		for (int var4 = 0; var4 < var3; var4++) {
			var1 *= 37L;
			char var5 = arg0.charAt(var4);
			if (var5 >= 'A' && var5 <= 'Z') {
				var1 += var5 + 1 - 65;
			} else if (var5 >= 'a' && var5 <= 'z') {
				var1 += var5 + 1 - 97;
			} else if (var5 >= '0' && var5 <= '9') {
				var1 += var5 + 27 - 48;
			}
			if (var1 >= 177917621779460413L) {
				break;
			}
		}
		while (var1 % 37L == 0L && var1 != 0L) {
			var1 /= 37L;
		}
		return var1;
	}

	@ObfuscatedName("bk.d(J)Ljava/lang/String;")
	public static String fromBase37(long arg0) {
		if (arg0 <= 0L || arg0 >= 6582952005840035281L) {
			return null;
		} else if (arg0 % 37L == 0L) {
			return null;
		} else {
			int var2 = 0;
			for (long var3 = arg0; var3 != 0L; var3 /= 37L) {
				var2++;
			}
			StringBuilder var5 = new StringBuilder(var2);
			while (arg0 != 0L) {
				long var6 = arg0;
				arg0 /= 37L;
				var5.append(field1149[(int) (var6 - arg0 * 37L)]);
			}
			return var5.reverse().toString();
		}
	}

	@ObfuscatedName("bg.l(J)Ljava/lang/String;")
	public static String method782(long arg0) {
		if (arg0 <= 0L || arg0 >= 6582952005840035281L) {
			return null;
		} else if (arg0 % 37L == 0L) {
			return null;
		} else {
			int var2 = 0;
			for (long var3 = arg0; var3 != 0L; var3 /= 37L) {
				var2++;
			}
			StringBuilder var5 = new StringBuilder(var2);
			while (arg0 != 0L) {
				long var6 = arg0;
				arg0 /= 37L;
				char var8 = field1149[(int) (var6 - arg0 * 37L)];
				if (var8 == '_') {
					int var9 = var5.length() - 1;
					var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
					var8 = 160;
				}
				var5.append(var8);
			}
			var5.reverse();
			var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
			return var5.toString();
		}
	}

	@ObfuscatedName("y.l(CB)C")
	public static char method261(char arg0) {
		return arg0 == 181 || arg0 == 402 ? arg0 : Character.toTitleCase(arg0);
	}

	@ObfuscatedName("bs.m(Ljava/lang/CharSequence;I)Ljava/lang/String;")
	public static String toDisplayName(CharSequence arg0) {
		String var1 = fromBase37(toBase37(arg0));
		if (var1 == null) {
			var1 = "";
		}
		return var1;
	}

	public static String imethod1(String arg0) {
		String var1 = JString.method782(JString.toBase37(arg0));
		if (var1 == null) {
			var1 = "";
		}
		return var1;
	}
}
