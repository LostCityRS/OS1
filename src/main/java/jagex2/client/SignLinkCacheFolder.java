package jagex2.client;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.io.BufferedFile;
import jagex2.io.FileOnDisk;
import jagex2.io.Packet;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

@ObfuscatedName("ay")
public class SignLinkCacheFolder {

	@ObfuscatedName("ay.i")
	public static BufferedFile field522 = null;

	@ObfuscatedName("ay.s")
	public static BufferedFile field523 = null;

	@ObfuscatedName("ay.u")
	public static BufferedFile field524 = null;

	public SignLinkCacheFolder() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("i.r(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;")
	public static File method102(String arg0, String arg1, int arg2) {
		String var3 = arg2 == 0 ? "" : "" + arg2;
		Statics.field518 = new File(Statics.field1725, "jagex_cl_" + arg0 + "_" + arg1 + var3 + ".dat");
		String var4 = null;
		String var5 = null;
		boolean var6 = false;
		if (Statics.field518.exists()) {
			try {
				FileOnDisk var7 = new FileOnDisk(Statics.field518, "rw", 10000L);
				Packet var8 = new Packet((int) var7.method113());
				while (var8.field1729 < var8.field1732.length) {
					int var9 = var7.method114(var8.field1732, var8.field1729, var8.field1732.length - var8.field1729);
					if (var9 == -1) {
						throw new IOException();
					}
					var8.field1729 += var9;
				}
				var8.field1729 = 0;
				int var10 = var8.method1600();
				if (var10 < 1 || var10 > 3) {
					throw new IOException("" + var10);
				}
				int var11 = 0;
				if (var10 > 1) {
					var11 = var8.method1600();
				}
				if (var10 <= 2) {
					var4 = var8.method1737();
					if (var11 == 1) {
						var5 = var8.method1737();
					}
				} else {
					var4 = var8.method1617();
					if (var11 == 1) {
						var5 = var8.method1617();
					}
				}
				var7.method112();
			} catch (IOException var45) {
				var45.printStackTrace();
			}
			if (var4 != null) {
				File var13 = new File(var4);
				if (!var13.exists()) {
					var4 = null;
				}
			}
			if (var4 != null) {
				File var14 = new File(var4, "test.dat");
				boolean var17;
				try {
					RandomAccessFile var15 = new RandomAccessFile(var14, "rw");
					int var16 = var15.read();
					var15.seek(0L);
					var15.write(var16);
					var15.seek(0L);
					var15.close();
					var14.delete();
					var17 = true;
				} catch (Exception var43) {
					var17 = false;
				}
				if (!var17) {
					var4 = null;
				}
			}
		}
		if (var4 == null && arg2 == 0) {
			label134: for (int var19 = 0; var19 < Statics.field553.length; var19++) {
				for (int var20 = 0; var20 < Statics.field805.length; var20++) {
					File var21 = new File(Statics.field805[var20] + Statics.field553[var19] + File.separatorChar + arg0 + File.separatorChar);
					if (var21.exists()) {
						File var22 = new File(var21, "test.dat");
						boolean var25;
						try {
							RandomAccessFile var23 = new RandomAccessFile(var22, "rw");
							int var24 = var23.read();
							var23.seek(0L);
							var23.write(var24);
							var23.seek(0L);
							var23.close();
							var22.delete();
							var25 = true;
						} catch (Exception var42) {
							var25 = false;
						}
						if (var25) {
							var4 = var21.toString();
							var6 = true;
							break label134;
						}
					}
				}
			}
		}
		if (var4 == null) {
			var4 = Statics.field1725 + File.separatorChar + "jagexcache" + var3 + File.separatorChar + arg0 + File.separatorChar + arg1 + File.separatorChar;
			var6 = true;
		}
		if (var5 != null) {
			File var27 = new File(var5);
			File var28 = new File(var4);
			try {
				File[] var29 = var27.listFiles();
				File[] var30 = var29;
				for (int var31 = 0; var31 < var30.length; var31++) {
					File var32 = var30[var31];
					File var33 = new File(var28, var32.getName());
					boolean var34 = var32.renameTo(var33);
					if (!var34) {
						throw new IOException();
					}
				}
			} catch (Exception var44) {
				var44.printStackTrace();
			}
			var6 = true;
		}
		if (var6) {
			File var36 = new File(var4);
			Object var37 = null;
			try {
				FileOnDisk var38 = new FileOnDisk(Statics.field518, "rw", 10000L);
				Packet var39 = new Packet(500);
				var39.method1587(3);
				var39.method1587(var37 == null ? 0 : 1);
				var39.method1593(var36.getPath());
				if (var37 != null) {
					var39.method1593(((File) var37).getPath());
				}
				var38.method111(var39.field1732, 0, var39.field1729);
				var38.method112();
			} catch (IOException var41) {
				var41.printStackTrace();
			}
		}
		return new File(var4);
	}

	@ObfuscatedName("cv.d(B)V")
	public static void method1166() {
		try {
			File var0 = new File(Statics.field1725, "random.dat");
			if (var0.exists()) {
				field522 = new BufferedFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
			} else {
				label34: for (int var1 = 0; var1 < Statics.field553.length; var1++) {
					for (int var2 = 0; var2 < Statics.field805.length; var2++) {
						File var3 = new File(Statics.field805[var2] + Statics.field553[var1] + File.separatorChar + "random.dat");
						if (var3.exists()) {
							field522 = new BufferedFile(new FileOnDisk(var3, "rw", 25L), 24, 0);
							break label34;
						}
					}
				}
			}
			if (field522 == null) {
				RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
				int var5 = var4.read();
				var4.seek(0L);
				var4.write(var5);
				var4.seek(0L);
				var4.close();
				field522 = new BufferedFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
			}
		} catch (IOException var7) {
		}
	}

	@ObfuscatedName("l.l(Lev;I)V")
	public static void method47(Packet arg0) {
		byte[] var1 = new byte[24];
		try {
			field522.method132(0L);
			field522.method134(var1);
			int var2;
			for (var2 = 0; var2 < 24 && var1[var2] == 0; var2++) {
			}
			if (var2 >= 24) {
				throw new IOException();
			}
		} catch (Exception var5) {
			for (int var4 = 0; var4 < 24; var4++) {
				var1[var4] = -1;
			}
		}
		arg0.method1729(var1, 0, 24);
	}

	@ObfuscatedName("ex.m(Lev;II)V")
	public static void method2298(Packet arg0, int arg1) {
		if (field522 == null) {
			return;
		}
		try {
			field522.method132(0L);
			field522.method153(arg0.field1732, arg1, 24);
		} catch (Exception var3) {
		}
	}

	@ObfuscatedName("cw.c(I)V")
	public static void method1141() {
		try {
			field523.method137();
			for (int var0 = 0; var0 < Statics.field512; var0++) {
				Statics.field372[var0].method137();
			}
			field524.method137();
			field522.method137();
		} catch (Exception var2) {
		}
	}
}
