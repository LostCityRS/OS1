package jagex3.reflectionchecker;

import deob.ObfuscatedName;
import jagex3.datastruct.LinkList;
import jagex3.io.PacketBit;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@ObfuscatedName("dk")
public class ReflectionChecker {

	@ObfuscatedName("dk.r")
	public static LinkList checks = new LinkList();

	public ReflectionChecker() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("br.r(Lea;IB)V")
	public static void performCheck(PacketBit buf, int opcode) {
		while (true) {
			ReflectionCheck check = (ReflectionCheck) checks.head();
			if (check == null) {
				return;
			}

			buf.p1Enc(opcode);
			buf.p1(0);
			int start = buf.pos;

			buf.p4(check.id);
			for (int var4 = 0; var4 < check.size; var4++) {
				if (check.error[var4] != 0) {
					buf.p1(check.error[var4]);
				} else {
					try {
						int type = check.type[var4];
						if (type == 0) {
							Field var6 = check.field[var4];
							int var7 = var6.getInt(null);
							buf.p1(0);
							buf.p4(var7);
						} else if (type == 1) {
							Field var8 = check.field[var4];
							var8.setInt(null, check.fieldValue[var4]);
							buf.p1(0);
						} else if (type == 2) {
							Field var9 = check.field[var4];
							int var10 = var9.getModifiers();
							buf.p1(0);
							buf.p4(var10);
						} else if (type == 3) {
							Method var11 = check.method[var4];
							byte[][] var12 = check.methodArgs[var4];
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
						} else if (type == 4) {
							Method var17 = check.method[var4];
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
				}
			}

			buf.addcrc(start);
			buf.psize1(buf.pos - start);
			check.unlink();
		}
	}

	@ObfuscatedName("m.d(Ljava/lang/String;I)Ljava/lang/Class;")
	public static Class findClass(String desc) throws ClassNotFoundException {
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

    public static void addCheck(PacketBit var235, int var236) {
        ReflectionCheck var237 = new ReflectionCheck();
        var237.size = var235.g1();
        var237.id = var235.g4();
        var237.type = new int[var237.size];
        var237.error = new int[var237.size];
        var237.field = new Field[var237.size];
        var237.fieldValue = new int[var237.size];
        var237.method = new Method[var237.size];
        var237.methodArgs = new byte[var237.size][][];
        for (int var238 = 0; var238 < var237.size; var238++) {
            try {
                int var239 = var235.g1();
                if (var239 == 0 || var239 == 1 || var239 == 2) {
                    String var240 = new String(var235.gjstr());
                    String var241 = new String(var235.gjstr());
                    int var242 = 0;
                    if (var239 == 1) {
                        var242 = var235.g4();
                    }
                    var237.type[var238] = var239;
                    var237.fieldValue[var238] = var242;
                    var237.field[var238] = findClass(var240).getDeclaredField(var241);
                } else if (var239 == 3 || var239 == 4) {
                    String var243 = new String(var235.gjstr());
                    String var244 = new String(var235.gjstr());
                    int var245 = var235.g1();
                    String[] var246 = new String[var245];
                    for (int var247 = 0; var247 < var245; var247++) {
                        var246[var247] = new String(var235.gjstr());
                    }
                    byte[][] var248 = new byte[var245][];
                    if (var239 == 3) {
                        for (int var249 = 0; var249 < var245; var249++) {
                            int var250 = var235.g4();
                            var248[var249] = new byte[var250];
                            var235.gdata(var248[var249], 0, var250);
                        }
                    }
                    var237.type[var238] = var239;
                    Class[] var251 = new Class[var245];
                    for (int var252 = 0; var252 < var245; var252++) {
                        var251[var252] = findClass(var246[var252]);
                    }
                    var237.method[var238] = findClass(var243).getDeclaredMethod(var244, var251);
                    var237.methodArgs[var238] = var248;
                }
            } catch (ClassNotFoundException var520) {
                var237.error[var238] = -1;
            } catch (SecurityException var521) {
                var237.error[var238] = -2;
            } catch (NullPointerException var522) {
                var237.error[var238] = -3;
            } catch (Exception var523) {
                var237.error[var238] = -4;
            } catch (Throwable var524) {
                var237.error[var238] = -5;
            }
        }
        checks.push(var237);
    }
}
