package jagex2.client;

import deob.ObfuscatedName;
import jagex2.datastruct.LinkList;
import jagex2.io.PacketBit;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
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
			ReflectionCheckNode var2 = (ReflectionCheckNode) field1513.method1297();
			if (var2 == null) {
				return;
			}
			arg0.method2301(arg1);
			arg0.method1587(0);
			int var3 = arg0.field1729;
			arg0.method1761(var2.field1906);
			for (int var4 = 0; var4 < var2.field1905; var4++) {
				if (var2.field1907[var4] == 0) {
					try {
						int var5 = var2.field1910[var4];
						if (var5 == 0) {
							Field var6 = var2.field1904[var4];
							int var7 = var6.getInt(null);
							arg0.method1587(0);
							arg0.method1761(var7);
						} else if (var5 == 1) {
							Field var8 = var2.field1904[var4];
							var8.setInt(null, var2.field1908[var4]);
							arg0.method1587(0);
						} else if (var5 == 2) {
							Field var9 = var2.field1904[var4];
							int var10 = var9.getModifiers();
							arg0.method1587(0);
							arg0.method1761(var10);
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
								arg0.method1587(0);
							} else if (var16 instanceof Number) {
								arg0.method1587(1);
								arg0.method1591(((Number) var16).longValue());
							} else if (var16 instanceof String) {
								arg0.method1587(2);
								arg0.method1592((String) var16);
							} else {
								arg0.method1587(4);
							}
						} else if (var5 == 4) {
							Method var17 = var2.field1911[var4];
							int var18 = var17.getModifiers();
							arg0.method1587(0);
							arg0.method1761(var18);
						}
					} catch (ClassNotFoundException var31) {
						arg0.method1587(-10);
					} catch (InvalidClassException var32) {
						arg0.method1587(-11);
					} catch (StreamCorruptedException var33) {
						arg0.method1587(-12);
					} catch (OptionalDataException var34) {
						arg0.method1587(-13);
					} catch (IllegalAccessException var35) {
						arg0.method1587(-14);
					} catch (IllegalArgumentException var36) {
						arg0.method1587(-15);
					} catch (InvocationTargetException var37) {
						arg0.method1587(-16);
					} catch (SecurityException var38) {
						arg0.method1587(-17);
					} catch (IOException var39) {
						arg0.method1587(-18);
					} catch (NullPointerException var40) {
						arg0.method1587(-19);
					} catch (Exception var41) {
						arg0.method1587(-20);
					} catch (Throwable var42) {
						arg0.method1587(-21);
					}
				} else {
					arg0.method1587(var2.field1907[var4]);
				}
			}
			arg0.method1619(var3);
			arg0.method1715(arg0.field1729 - var3);
			var2.method1325();
		}
	}
}
