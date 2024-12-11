package jagex2.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("bw")
public abstract class ByteArrayCopier {

	@ObfuscatedName("bw.r")
	public static boolean field799 = false;

	@ObfuscatedName("cc.r([BZB)Ljava/lang/Object;")
	public static Object method1131(byte[] arg0, boolean arg1) {
		if (arg0 == null) {
			return null;
		}
		if (arg0.length > 136 && !field799) {
			try {
				ByteBufferNode var2 = new ByteBufferNode();
				var2.set(arg0);
				return var2;
			} catch (Throwable var7) {
				field799 = true;
			}
		}
		if (arg1) {
			int var4 = arg0.length;
			byte[] var5 = new byte[var4];
			System.arraycopy(arg0, 0, var5, 0, var4);
			return var5;
		} else {
			return arg0;
		}
	}

	@ObfuscatedName("s.d(Ljava/lang/Object;ZI)[B")
	public static byte[] method108(Object arg0, boolean arg1) {
		if (arg0 == null) {
			return null;
		} else if (arg0 instanceof byte[]) {
			byte[] var2 = (byte[]) arg0;
			if (arg1) {
				int var3 = var2.length;
				byte[] var4 = new byte[var3];
				System.arraycopy(var2, 0, var4, 0, var3);
				return var4;
			} else {
				return var2;
			}
		} else if (arg0 instanceof ByteArrayCopier) {
			ByteArrayCopier var6 = (ByteArrayCopier) arg0;
			return var6.method800();
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("bw.l(I)[B")
	public abstract byte[] method800();

	@ObfuscatedName("bw.m([BI)V")
	public abstract void set(byte[] arg0);
}
