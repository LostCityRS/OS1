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
	public static void method919(PacketBit arg0, int arg1) {
		while (true) {
			ReflectionCheckNode var2 = (ReflectionCheckNode) field1513.head();
			if (var2 == null) {
				return;
			}
			arg0.pisaac1(arg1);
			arg0.p1(0);
			int var3 = arg0.pos;
			arg0.p4(var2.field1906);
			for (int var4 = 0; var4 < var2.field1905; var4++) {
				if (var2.field1907[var4] == 0) {
					try {
						int var5 = var2.field1910[var4];
						if (var5 == 0) {
							Field var6 = var2.field1904[var4];
							int var7 = var6.getInt(null);
							arg0.p1(0);
							arg0.p4(var7);
						} else if (var5 == 1) {
							Field var8 = var2.field1904[var4];
							var8.setInt(null, var2.field1908[var4]);
							arg0.p1(0);
						} else if (var5 == 2) {
							Field var9 = var2.field1904[var4];
							int var10 = var9.getModifiers();
							arg0.p1(0);
							arg0.p4(var10);
						}
						if (var5 == 3) {
							Method var11 = var2.field1911[var4];
							byte[][] var12 = var2.field1909[var4];
							Object[] var13 = new Object[var12.length];
							for (int var14 = 0; var14 < var12.length; var14++) {
								ObjectInputStream var15 = new ObjectInputStream(new ByteArrayInputStream(var12[var14]));
								var13[var14] = var15.readObject();
							}
							Object var16 = var11.invoke(null, var13);
							if (var16 == null) {
								arg0.p1(0);
							} else if (var16 instanceof Number) {
								arg0.p1(1);
								arg0.p8(((Number) var16).longValue());
							} else if (var16 instanceof String) {
								arg0.p1(2);
								arg0.pjstr((String) var16);
							} else {
								arg0.p1(4);
							}
						} else if (var5 == 4) {
							Method var17 = var2.field1911[var4];
							int var18 = var17.getModifiers();
							arg0.p1(0);
							arg0.p4(var18);
						}
					} catch (ClassNotFoundException var31) {
						arg0.p1(-10);
					} catch (InvalidClassException var32) {
						arg0.p1(-11);
					} catch (StreamCorruptedException var33) {
						arg0.p1(-12);
					} catch (OptionalDataException var34) {
						arg0.p1(-13);
					} catch (IllegalAccessException var35) {
						arg0.p1(-14);
					} catch (IllegalArgumentException var36) {
						arg0.p1(-15);
					} catch (InvocationTargetException var37) {
						arg0.p1(-16);
					} catch (SecurityException var38) {
						arg0.p1(-17);
					} catch (IOException var39) {
						arg0.p1(-18);
					} catch (NullPointerException var40) {
						arg0.p1(-19);
					} catch (Exception var41) {
						arg0.p1(-20);
					} catch (Throwable var42) {
						arg0.p1(-21);
					}
				} else {
					arg0.p1(var2.field1907[var4]);
				}
			}
			arg0.addcrc(var3);
			arg0.psize1(arg0.pos - var3);
			var2.unlink();
		}
	}

	@ObfuscatedName("m.d(Ljava/lang/String;I)Ljava/lang/Class;")
	public static Class method51(String arg0) throws ClassNotFoundException {
		if (arg0.equals("B")) {
			return Byte.TYPE;
		} else if (arg0.equals("I")) {
			return Integer.TYPE;
		} else if (arg0.equals("S")) {
			return Short.TYPE;
		} else if (arg0.equals("J")) {
			return Long.TYPE;
		} else if (arg0.equals("Z")) {
			return Boolean.TYPE;
		} else if (arg0.equals("F")) {
			return Float.TYPE;
		} else if (arg0.equals("D")) {
			return Double.TYPE;
		} else if (arg0.equals("C")) {
			return Character.TYPE;
		} else {
			return Class.forName(arg0);
		}
	}
}
