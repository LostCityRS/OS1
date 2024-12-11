package jagex2.client.social;

import deob.ObfuscatedName;

@ObfuscatedName("cp")
public class NamespaceUtil {

	@ObfuscatedName("cp.l")
	public static final char[] field1155 = new char[] { ' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß' };

	@ObfuscatedName("cp.m")
	public static final char[] field1156 = new char[] { '[', ']', '#' };

	public NamespaceUtil() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("au.r(CI)Z")
	public static final boolean method723(char arg0) {
		if (Character.isISOControl(arg0)) {
			return false;
		}
		boolean var1 = arg0 >= '0' && arg0 <= '9' || arg0 >= 'A' && arg0 <= 'Z' || arg0 >= 'a' && arg0 <= 'z';
		if (var1) {
			return true;
		}
		char[] var2 = field1155;
		for (int var3 = 0; var3 < var2.length; var3++) {
			char var4 = var2[var3];
			if (arg0 == var4) {
				return true;
			}
		}
		char[] var5 = field1156;
		for (int var6 = 0; var6 < var5.length; var6++) {
			char var7 = var5[var6];
			if (arg0 == var7) {
				return true;
			}
		}
		return false;
	}

	@ObfuscatedName("bh.d(Ljava/lang/CharSequence;Lda;I)Ljava/lang/String;")
	public static String method743(CharSequence arg0, Namespace arg1) {
		if (arg0 == null) {
			return null;
		}
		int var2 = 0;
		int var3 = arg0.length();
		while (var2 < var3) {
			char var4 = arg0.charAt(var2);
			boolean var5 = var4 == 160 || var4 == ' ' || var4 == '_' || var4 == '-';
			if (!var5) {
				break;
			}
			var2++;
		}
		while (var3 > var2) {
			char var6 = arg0.charAt(var3 - 1);
			boolean var7 = var6 == 160 || var6 == ' ' || var6 == '_' || var6 == '-';
			if (!var7) {
				break;
			}
			var3--;
		}
		int var8 = var3 - var2;
		if (var8 >= 1) {
			byte var10;
			if (arg1 == null) {
				var10 = 12;
			} else {
				switch(arg1.field1526) {
					case 3:
						var10 = 20;
						break;
					default:
						var10 = 12;
				}
			}
			if (var8 <= var10) {
				StringBuilder var11 = new StringBuilder(var8);
				for (int var12 = var2; var12 < var3; var12++) {
					char var13 = arg0.charAt(var12);
					if (method723(var13)) {
						char var14;
						switch(var13) {
							case ' ':
							case '-':
							case '_':
							case ' ':
								var14 = '_';
								break;
							case '#':
							case '[':
							case ']':
								var14 = var13;
								break;
							case 'À':
							case 'Á':
							case 'Â':
							case 'Ã':
							case 'Ä':
							case 'à':
							case 'á':
							case 'â':
							case 'ã':
							case 'ä':
								var14 = 'a';
								break;
							case 'Ç':
							case 'ç':
								var14 = 'c';
								break;
							case 'È':
							case 'É':
							case 'Ê':
							case 'Ë':
							case 'è':
							case 'é':
							case 'ê':
							case 'ë':
								var14 = 'e';
								break;
							case 'Í':
							case 'Î':
							case 'Ï':
							case 'í':
							case 'î':
							case 'ï':
								var14 = 'i';
								break;
							case 'Ñ':
							case 'ñ':
								var14 = 'n';
								break;
							case 'Ò':
							case 'Ó':
							case 'Ô':
							case 'Õ':
							case 'Ö':
							case 'ò':
							case 'ó':
							case 'ô':
							case 'õ':
							case 'ö':
								var14 = 'o';
								break;
							case 'Ù':
							case 'Ú':
							case 'Û':
							case 'Ü':
							case 'ù':
							case 'ú':
							case 'û':
							case 'ü':
								var14 = 'u';
								break;
							case 'ß':
								var14 = 'b';
								break;
							case 'ÿ':
							case 'Ÿ':
								var14 = 'y';
								break;
							default:
								var14 = Character.toLowerCase(var13);
						}
						if (var14 != 0) {
							var11.append(var14);
						}
					}
				}
				if (var11.length() == 0) {
					return null;
				}
				return var11.toString();
			}
		}
		return null;
	}
}
