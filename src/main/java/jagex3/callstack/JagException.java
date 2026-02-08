package jagex3.callstack;

import deob.ObfuscatedName;
import jagex3.client.applet.SignLink;

import java.applet.Applet;
import java.io.*;
import java.net.URL;

@ObfuscatedName("fa")
public class JagException extends RuntimeException {

	@ObfuscatedName("fa.r")
	public static Applet applet;

	@ObfuscatedName("fa.d")
	public static String username;

	@ObfuscatedName("fa.l")
	public static int revision;

	@ObfuscatedName("fa.m")
	public String message;

	@ObfuscatedName("fa.c")
	public Throwable cause;

	public JagException(Throwable arg0, String arg1) {
		this.message = arg1;
		this.cause = arg0;
	}

	@ObfuscatedName("dy.r(Ljava/lang/String;Ljava/lang/Throwable;I)V")
	public static void report(String arg0, Throwable arg1) {
		try {
			String var2 = "";
			if (arg1 != null) {
				// todo: inlined method
				Throwable var3 = arg1;
				String var5;
				if (arg1 instanceof JagException) {
					JagException var4 = (JagException) arg1;
					var5 = var4.message + " | ";
					var3 = var4.cause;
				} else {
					var5 = "";
				}
				StringWriter var6 = new StringWriter();
				PrintWriter var7 = new PrintWriter(var6);
				var3.printStackTrace(var7);
				var7.close();
				String var8 = var6.toString();
				BufferedReader var9 = new BufferedReader(new StringReader(var8));
				String var10 = var9.readLine();
				while (true) {
					String var11 = var9.readLine();
					if (var11 == null) {
						String var20 = var5 + "| " + var10;
						var2 = var20;
						break;
					}
					int var12 = var11.indexOf(40);
					int var13 = var11.indexOf(41, var12 + 1);
					if (var12 >= 0 && var13 >= 0) {
						String var14 = var11.substring(var12 + 1, var13);
						int var15 = var14.indexOf(".java:");
						if (var15 >= 0) {
							String var16 = var14.substring(0, var15) + var14.substring(var15 + 5);
							var5 = var5 + var16 + ' ';
							continue;
						}
						var11 = var11.substring(0, var12);
					}
					String var17 = var11.trim();
					String var18 = var17.substring(var17.lastIndexOf(32) + 1);
					String var19 = var18.substring(var18.lastIndexOf(9) + 1);
					var5 = var5 + var19 + ' ';
				}
			}
			if (arg0 != null) {
				if (arg1 != null) {
					var2 = var2 + " | ";
				}
				var2 = var2 + arg0;
			}
			System.out.println("Error: " + var2);
			String var22 = var2.replace(':', '.');
			String var23 = var22.replace('@', '_');
			String var24 = var23.replace('&', '_');
			String var25 = var24.replace('#', '_');
			if (applet == null) {
				return;
			}
			URL var26 = new URL(applet.getCodeBase(), "clienterror.ws?c=" + revision + "&u=" + username + "&v1=" + SignLink.javaVendor + "&v2=" + SignLink.javaVersion + "&e=" + var25);
			DataInputStream var27 = new DataInputStream(var26.openStream());
			var27.read();
			var27.close();
		} catch (Exception var29) {
		}
	}

	@ObfuscatedName("bh.d(Ljava/lang/Throwable;Ljava/lang/String;)Lfa;")
	public static JagException report(Throwable arg0, String arg1) {
		JagException var2;
		if (arg0 instanceof JagException) {
			var2 = (JagException) arg0;
			var2.message = var2.message + ' ' + arg1;
		} else {
			var2 = new JagException(arg0, arg1);
		}
		return var2;
	}
}
