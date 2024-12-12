package jagex3.io;

import deob.ObfuscatedName;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Hashtable;

@ObfuscatedName("av")
public class CacheUtil {

	@ObfuscatedName("av.r")
	public static boolean field370 = false;

	@ObfuscatedName("av.d")
	public static File field369;

	@ObfuscatedName("av.l")
	public static Hashtable field371 = new Hashtable(16);

	public CacheUtil() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("j.r(Ljava/io/File;I)V")
	public static void method61(File arg0) {
		field369 = arg0;
		if (!field369.exists()) {
			throw new RuntimeException("");
		}
		field370 = true;
	}

	@ObfuscatedName("co.d(Ljava/lang/String;I)Ljava/io/File;")
	public static File method1039(String arg0) {
		if (!field370) {
			throw new RuntimeException("");
		}
		File var1 = (File) field371.get(arg0);
		if (var1 != null) {
			return var1;
		}
		File var2 = new File(field369, arg0);
		RandomAccessFile var3 = null;
		try {
			File var4 = new File(var2.getParent());
			if (!var4.exists()) {
				throw new RuntimeException("");
			}
			var3 = new RandomAccessFile(var2, "rw");
			int var5 = var3.read();
			var3.seek(0L);
			var3.write(var5);
			var3.seek(0L);
			var3.close();
			field371.put(arg0, var2);
			return var2;
		} catch (Exception var10) {
			try {
				if (var3 != null) {
					var3.close();
					Object var7 = null;
				}
			} catch (Exception var9) {
			}
			throw new RuntimeException();
		}
	}
}
