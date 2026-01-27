package jagex3.client;

import deob.ObfuscatedName;

// jag::oldscape::StringConstants
@ObfuscatedName("r")
public class StringConstants {

	@ObfuscatedName("r.r")
	public static String TRUE_S = "true";

	@ObfuscatedName("r.d")
	public static String COMMA = ",";

	@ObfuscatedName("r.l")
	public static String PIPE = "|";

	@ObfuscatedName("r.m")
	public static String OPEN_BRACKET = " (";

	@ObfuscatedName("r.c")
	public static String CLOSE_BRACKET = ")";

	@ObfuscatedName("r.n")
	public static String TAG_ARROW = "->";

	@ObfuscatedName("r.j")
	public static String TAG_BREAK = "<br>";

	@ObfuscatedName("r.z")
	public static String TAG_COLOURCLOSE = "</col>";

	public StringConstants() throws Throwable {
		throw new Error();
	}

	// jag::oldscape::StringConstants::TAG_IMG
	@ObfuscatedName("j.r(IS)Ljava/lang/String;")
	public static String TAG_IMG(int arg0) {
		return "<img=" + arg0 + ">";
	}

	// jag::oldscape::StringConstants::TAG_COLOUR
	@ObfuscatedName("i.d(II)Ljava/lang/String;")
	public static String TAG_COLOUR(int arg0) {
		return "<col=" + Integer.toHexString(arg0) + ">";
	}
}
