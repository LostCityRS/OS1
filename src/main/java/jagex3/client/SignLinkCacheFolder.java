package jagex3.client;

import deob.ObfuscatedName;
import jagex3.io.BufferedFile;
import jagex3.io.CacheUtil;
import jagex3.io.FileOnDisk;
import jagex3.io.Packet;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

@ObfuscatedName("ay")
public class SignLinkCacheFolder {

	@ObfuscatedName("ay.m")
	public static File cacheLocator;

	@ObfuscatedName("ay.c")
	public static File cacheDirectory;

	@ObfuscatedName("ay.n")
	public static int archiveCount;

	@ObfuscatedName("ay.i")
	public static BufferedFile uidDat = null;

	@ObfuscatedName("ay.s")
	public static BufferedFile cacheDat = null;

	@ObfuscatedName("ay.u")
	public static BufferedFile masterIndex = null;

	@ObfuscatedName("av.v")
	public static BufferedFile[] cacheIndex;

	@ObfuscatedName("ap.w")
	public static int field368;

	@ObfuscatedName("by.e")
	public static String[] historicCacheLocations;

	@ObfuscatedName("ag.b")
	public static String[] historicCacheDirectories;

	@ObfuscatedName("s.f")
	public static String field199;

	@ObfuscatedName("f.k")
	public static String field294;

	@ObfuscatedName("ez.o")
	public static String homeDir;

	public SignLinkCacheFolder() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("i.r(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;")
	public static File method102(String arg0, String arg1, int arg2) {
		String var3 = arg2 == 0 ? "" : "" + arg2;
		cacheLocator = new File(homeDir, "jagex_cl_" + arg0 + "_" + arg1 + var3 + ".dat");
		String var4 = null;
		String var5 = null;
		boolean var6 = false;
		if (cacheLocator.exists()) {
			try {
				FileOnDisk var7 = new FileOnDisk(cacheLocator, "rw", 10000L);
				Packet var8 = new Packet((int) var7.length());
				while (var8.pos < var8.data.length) {
					int var9 = var7.read(var8.data, var8.pos, var8.data.length - var8.pos);
					if (var9 == -1) {
						throw new IOException();
					}
					var8.pos += var9;
				}
				var8.pos = 0;
				int var10 = var8.g1();
				if (var10 < 1 || var10 > 3) {
					throw new IOException("" + var10);
				}
				int var11 = 0;
				if (var10 > 1) {
					var11 = var8.g1();
				}
				if (var10 <= 2) {
					var4 = var8.gjstr2();
					if (var11 == 1) {
						var5 = var8.gjstr2();
					}
				} else {
					var4 = var8.gUTF8();
					if (var11 == 1) {
						var5 = var8.gUTF8();
					}
				}
				var7.close();
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
			label134: for (int var19 = 0; var19 < historicCacheDirectories.length; var19++) {
				for (int var20 = 0; var20 < historicCacheLocations.length; var20++) {
					File var21 = new File(historicCacheLocations[var20] + historicCacheDirectories[var19] + File.separatorChar + arg0 + File.separatorChar);
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
			var4 = homeDir + File.separatorChar + "jagexcache" + var3 + File.separatorChar + arg0 + File.separatorChar + arg1 + File.separatorChar;
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
				FileOnDisk var38 = new FileOnDisk(cacheLocator, "rw", 10000L);
				Packet var39 = new Packet(500);
				var39.p1(3);
				var39.p1(var37 == null ? 0 : 1);
				var39.pUTF8(var36.getPath());
				if (var37 != null) {
					var39.pUTF8(((File) var37).getPath());
				}
				var38.write(var39.data, 0, var39.pos);
				var38.close();
			} catch (IOException var41) {
				var41.printStackTrace();
			}
		}
		return new File(var4);
	}

	@ObfuscatedName("cv.d(B)V")
	public static void method1166() {
		try {
			File var0 = new File(homeDir, "random.dat");
			if (var0.exists()) {
				uidDat = new BufferedFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
			} else {
				label34: for (int var1 = 0; var1 < historicCacheDirectories.length; var1++) {
					for (int var2 = 0; var2 < historicCacheLocations.length; var2++) {
						File var3 = new File(historicCacheLocations[var2] + historicCacheDirectories[var1] + File.separatorChar + "random.dat");
						if (var3.exists()) {
							uidDat = new BufferedFile(new FileOnDisk(var3, "rw", 25L), 24, 0);
							break label34;
						}
					}
				}
			}
			if (uidDat == null) {
				RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
				int var5 = var4.read();
				var4.seek(0L);
				var4.write(var5);
				var4.seek(0L);
				var4.close();
				uidDat = new BufferedFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
			}
		} catch (IOException var7) {
		}
	}

	@ObfuscatedName("l.l(Lev;I)V")
	public static void pUid(Packet buf) {
		byte[] data = new byte[24];
		try {
			uidDat.seek(0L);
			uidDat.read(data);
			int i;
			for (i = 0; i < 24 && data[i] == 0; i++) {
			}
			if (i >= 24) {
				throw new IOException();
			}
		} catch (Exception ignore) {
			for (int i = 0; i < 24; i++) {
				data[i] = -1;
			}
		}
		buf.pdata(data, 0, 24);
	}

	@ObfuscatedName("ex.m(Lev;II)V")
	public static void method2298(Packet arg0, int arg1) {
		if (uidDat == null) {
			return;
		}
		try {
			uidDat.seek(0L);
			uidDat.write(arg0.data, arg1, 24);
		} catch (Exception var3) {
		}
	}

	@ObfuscatedName("cw.c(I)V")
	public static void method1141() {
		try {
			cacheDat.method137();
			for (int var0 = 0; var0 < archiveCount; var0++) {
				cacheIndex[var0].method137();
			}
			masterIndex.method137();
			uidDat.method137();
		} catch (Exception var2) {
		}
	}

	public static void imethod1(String var18, int var19) {
		try {
			archiveCount = 16;
			field368 = var19;
			try {
				field294 = System.getProperty("os.name");
			} catch (Exception var37) {
				field294 = "Unknown";
			}
			field199 = field294.toLowerCase();
			try {
				homeDir = System.getProperty("user.home");
				if (homeDir != null) {
					homeDir = homeDir + "/";
				}
			} catch (Exception var36) {
			}
			try {
				if (field199.startsWith("win")) {
					if (homeDir == null) {
						homeDir = System.getenv("USERPROFILE");
					}
				} else if (homeDir == null) {
					homeDir = System.getenv("HOME");
				}
				if (homeDir != null) {
					homeDir = homeDir + "/";
				}
			} catch (Exception var35) {
			}
			if (homeDir == null) {
				homeDir = "~/";
			}
			historicCacheLocations = new String[] { "c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", homeDir, "/tmp/", "" };
			historicCacheDirectories = new String[] { ".jagex_cache_" + field368, ".file_store_" + field368 };
			label130: for (int var23 = 0; var23 < 4; var23++) {
				cacheDirectory = method102("oldschool", var18, var23);
				if (!cacheDirectory.exists()) {
					cacheDirectory.mkdirs();
				}
				File[] var24 = cacheDirectory.listFiles();
				if (var24 == null) {
					break;
				}
				File[] var25 = var24;
				int var26 = 0;
				while (true) {
					if (var26 >= var25.length) {
						break label130;
					}
					File var27 = var25[var26];
					boolean var30;
					try {
						RandomAccessFile var28 = new RandomAccessFile(var27, "rw");
						int var29 = var28.read();
						var28.seek(0L);
						var28.write(var29);
						var28.seek(0L);
						var28.close();
						var30 = true;
					} catch (Exception var34) {
						var30 = false;
					}
					if (!var30) {
						break;
					}
					var26++;
				}
			}
			CacheUtil.method61(cacheDirectory);
			method1166();
			cacheDat = new BufferedFile(new FileOnDisk(CacheUtil.method1039("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
			masterIndex = new BufferedFile(new FileOnDisk(CacheUtil.method1039("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
			cacheIndex = new BufferedFile[archiveCount];
			for (int var32 = 0; var32 < archiveCount; var32++) {
				cacheIndex[var32] = new BufferedFile(new FileOnDisk(CacheUtil.method1039("main_file_cache.idx" + var32), "rw", 1048576L), 6000, 0);
			}
		} catch (Exception var38) {
			JagException.report(null, var38);
		}
	}
}
