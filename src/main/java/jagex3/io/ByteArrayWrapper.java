package jagex3.io;

import deob.ObfuscatedName;

@ObfuscatedName("bw")
public abstract class ByteArrayWrapper {

	@ObfuscatedName("bw.r")
	public static boolean useDirectBuffer = false;

	@ObfuscatedName("cc.r([BZB)Ljava/lang/Object;")
	public static Object wrap(byte[] src, boolean copy) {
		if (src == null) {
			return null;
		}

		if (src.length > 136 && !useDirectBuffer) {
			try {
				ByteBufferNode node = new ByteBufferNode();
				node.set(src);
				return node;
			} catch (Throwable var7) {
				useDirectBuffer = true;
			}
		}

		if (copy) {
			int len = src.length;
			byte[] tmp = new byte[len];
			System.arraycopy(src, 0, tmp, 0, len);
			return tmp;
		} else {
			return src;
		}
	}

	@ObfuscatedName("s.d(Ljava/lang/Object;ZI)[B")
	public static byte[] unwrap(Object node, boolean copy) {
		if (node == null) {
			return null;
		}

		if (node instanceof byte[]) {
			byte[] buf = (byte[]) node;
			if (copy) {
				// todo: inlined
				int len = buf.length;
				byte[] tmp = new byte[len];
				System.arraycopy(buf, 0, tmp, 0, len);
				return tmp;
			} else {
				return buf;
			}
		} else if (node instanceof ByteArrayWrapper) {
			ByteArrayWrapper buf = (ByteArrayWrapper) node;
			return buf.toByteArray();
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("bw.l(I)[B")
	public abstract byte[] toByteArray();

	@ObfuscatedName("bw.m([BI)V")
	public abstract void set(byte[] src);
}
