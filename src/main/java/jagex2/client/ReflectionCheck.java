package jagex2.client;

import deob.ObfuscatedName;
import jagex2.datastruct.LinkList;
import jagex2.io.PacketBit;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@ObfuscatedName("dk")
public class ReflectionCheck {

	@ObfuscatedName("dk.r")
	public static LinkList field1513 = new LinkList();

	public ReflectionCheck() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("br.r(Lea;IB)V")
	public static void performCheck(PacketBit buf, int opcode) {
		while (true) {
			ReflectionCheckNode check = (ReflectionCheckNode) field1513.head();
			if (check == null) {
				return;
			}

			buf.pisaac1(opcode);
			buf.p1(0);
			int start = buf.pos;

			buf.p4(check.field1906);
			for (int var4 = 0; var4 < check.field1905; var4++) {
				if (check.field1907[var4] == 0) {
					try {
						int var5 = check.field1910[var4];
						if (var5 == 0) {
							Field var6 = check.field1904[var4];
							int var7 = var6.getInt(null);
							buf.p1(0);
							buf.p4(var7);
						} else if (var5 == 1) {
							Field var8 = check.field1904[var4];
							var8.setInt(null, check.field1908[var4]);
							buf.p1(0);
						} else if (var5 == 2) {
							Field var9 = check.field1904[var4];
							int var10 = var9.getModifiers();
							buf.p1(0);
							buf.p4(var10);
						} else if (var5 == 3) {
							Method var11 = check.field1911[var4];
							byte[][] var12 = check.field1909[var4];
							Object[] var13 = new Object[var12.length];
							for (int var14 = 0; var14 < var12.length; var14++) {
								ObjectInputStream var15 = new ObjectInputStream(new ByteArrayInputStream(var12[var14]));
								var13[var14] = var15.readObject();
							}
							Object var16 = var11.invoke(null, var13);
							if (var16 == null) {
								buf.p1(0);
							} else if (var16 instanceof Number) {
								buf.p1(1);
								buf.p8(((Number) var16).longValue());
							} else if (var16 instanceof String) {
								buf.p1(2);
								buf.pjstr((String) var16);
							} else {
								buf.p1(4);
							}
						} else if (var5 == 4) {
							Method var17 = check.field1911[var4];
							int var18 = var17.getModifiers();
							buf.p1(0);
							buf.p4(var18);
						}
					} catch (ClassNotFoundException ignore) {
						buf.p1(-10);
					} catch (InvalidClassException ignore) {
						buf.p1(-11);
					} catch (StreamCorruptedException ignore) {
						buf.p1(-12);
					} catch (OptionalDataException ignore) {
						buf.p1(-13);
					} catch (IllegalAccessException ignore) {
						buf.p1(-14);
					} catch (IllegalArgumentException ignore) {
						buf.p1(-15);
					} catch (InvocationTargetException ignore) {
						buf.p1(-16);
					} catch (SecurityException ignore) {
						buf.p1(-17);
					} catch (IOException ignore) {
						buf.p1(-18);
					} catch (NullPointerException ignore) {
						buf.p1(-19);
					} catch (Exception ignore) {
						buf.p1(-20);
					} catch (Throwable ignore) {
						buf.p1(-21);
					}
				} else {
					buf.p1(check.field1907[var4]);
				}
			}

			buf.addcrc(start);
			buf.psize1(buf.pos - start);
			check.unlink();
		}
	}

	@ObfuscatedName("m.d(Ljava/lang/String;I)Ljava/lang/Class;")
	public static Class method51(String desc) throws ClassNotFoundException {
		if (desc.equals("B")) {
			return Byte.TYPE;
		} else if (desc.equals("I")) {
			return Integer.TYPE;
		} else if (desc.equals("S")) {
			return Short.TYPE;
		} else if (desc.equals("J")) {
			return Long.TYPE;
		} else if (desc.equals("Z")) {
			return Boolean.TYPE;
		} else if (desc.equals("F")) {
			return Float.TYPE;
		} else if (desc.equals("D")) {
			return Double.TYPE;
		} else if (desc.equals("C")) {
			return Character.TYPE;
		} else {
			return Class.forName(desc);
		}
	}
}
