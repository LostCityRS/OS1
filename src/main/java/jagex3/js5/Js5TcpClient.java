package jagex3.js5;

import deob.ObfuscatedName;
import jagex3.client.LoginScreen;
import jagex3.datastruct.DoublyLinkList;
import jagex3.datastruct.HashTable;
import jagex3.datastruct.MonotonicTime;
import jagex3.io.ClientStream;
import jagex3.io.Packet;

import java.io.IOException;
import java.util.zip.CRC32;

@ObfuscatedName("cu")
public class Js5TcpClient {

	@ObfuscatedName("df.r")
	public static boolean field1507;

	@ObfuscatedName("cu.d")
	public static int field1190 = 0;

	@ObfuscatedName("bo.l")
	public static long field825;

	@ObfuscatedName("cu.m")
	public static HashTable field1185 = new HashTable(4096);

	@ObfuscatedName("cu.c")
	public static int field1186 = 0;

	@ObfuscatedName("cu.n")
	public static HashTable field1187 = new HashTable(32);

	@ObfuscatedName("cu.j")
	public static int field1188 = 0;

	@ObfuscatedName("cu.z")
	public static DoublyLinkList field1189 = new DoublyLinkList();

	@ObfuscatedName("cu.g")
	public static HashTable field1193 = new HashTable(4096);

	@ObfuscatedName("cu.q")
	public static int field1191 = 0;

	@ObfuscatedName("cu.i")
	public static HashTable field1199 = new HashTable(4096);

	@ObfuscatedName("cu.s")
	public static int field1197 = 0;

	@ObfuscatedName("cu.u")
	public static boolean field1194;

	@ObfuscatedName("bx.v")
	public static Js5NetRequest field812;

	@ObfuscatedName("cu.w")
	public static Packet field1195 = new Packet(8);

	@ObfuscatedName("cu.e")
	public static Packet field1196;

	@ObfuscatedName("cu.b")
	public static int field1201 = 0;

	@ObfuscatedName("cu.t")
	public static CRC32 field1184 = new CRC32();

	@ObfuscatedName("ab.f")
	public static Packet field542;

	@ObfuscatedName("cu.k")
	public static Js5Provider[] field1200 = new Js5Provider[256];

	@ObfuscatedName("cu.o")
	public static byte field1202 = 0;

	@ObfuscatedName("cu.a")
	public static int field1198 = 0;

	@ObfuscatedName("cu.h")
	public static int field1203 = 0;

	public Js5TcpClient() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("by.r(B)Z")
	public static boolean method826() {
		long var0 = MonotonicTime.method1135();
		int var2 = (int) (var0 - field825);
		field825 = var0;
		if (var2 > 200) {
			var2 = 200;
		}
		field1190 += var2;
		if (field1197 == 0 && field1188 == 0 && field1191 == 0 && field1186 == 0) {
			return true;
		} else if (LoginScreen.field169 == null) {
			return false;
		} else {
			try {
				if (field1190 > 30000) {
					throw new IOException();
				}
				while (field1188 < 20 && field1186 > 0) {
					Js5NetRequest var3 = (Js5NetRequest) field1185.method1284();
					Packet var4 = new Packet(4);
					var4.p1(1);
					var4.p3((int) var3.nodeId);
					LoginScreen.field169.write(var4.data, 0, 4);
					field1187.put(var3, var3.nodeId);
					field1186--;
					field1188++;
				}
				while (field1197 < 20 && field1191 > 0) {
					Js5NetRequest var5 = (Js5NetRequest) field1189.head();
					Packet var6 = new Packet(4);
					var6.p1(0);
					var6.p3((int) var5.nodeId);
					LoginScreen.field169.write(var6.data, 0, 4);
					var5.unlink2();
					field1199.put(var5, var5.nodeId);
					field1191--;
					field1197++;
				}
				for (int var7 = 0; var7 < 100; var7++) {
					int var8 = LoginScreen.field169.available();
					if (var8 < 0) {
						throw new IOException();
					}
					if (var8 == 0) {
						break;
					}
					field1190 = 0;
					byte var9 = 0;
					if (field812 == null) {
						var9 = 8;
					} else if (field1201 == 0) {
						var9 = 1;
					}
					if (var9 > 0) {
						int var10 = var9 - field1195.pos;
						if (var10 > var8) {
							var10 = var8;
						}
						LoginScreen.field169.read(field1195.data, field1195.pos, var10);
						if (field1202 != 0) {
							for (int var11 = 0; var11 < var10; var11++) {
								field1195.data[field1195.pos + var11] ^= field1202;
							}
						}
						field1195.pos += var10;
						if (field1195.pos < var9) {
							break;
						}
						if (field812 == null) {
							field1195.pos = 0;
							int var12 = field1195.g1();
							int var13 = field1195.g2();
							int var14 = field1195.g1();
							int var15 = field1195.g4();
							long var16 = (long) ((var12 << 16) + var13);
							Js5NetRequest var18 = (Js5NetRequest) field1187.get(var16);
							field1194 = true;
							if (var18 == null) {
								var18 = (Js5NetRequest) field1199.get(var16);
								field1194 = false;
							}
							if (var18 == null) {
								throw new IOException();
							}
							int var19 = var14 == 0 ? 5 : 9;
							field812 = var18;
							field1196 = new Packet(var15 + var19 + field812.field2490);
							field1196.p1(var14);
							field1196.p4(var15);
							field1201 = 8;
							field1195.pos = 0;
						} else if (field1201 == 0) {
							if (field1195.data[0] == -1) {
								field1201 = 1;
								field1195.pos = 0;
							} else {
								field812 = null;
							}
						}
					} else {
						int var20 = field1196.data.length - field812.field2490;
						int var21 = 512 - field1201;
						if (var21 > var20 - field1196.pos) {
							var21 = var20 - field1196.pos;
						}
						if (var21 > var8) {
							var21 = var8;
						}
						LoginScreen.field169.read(field1196.data, field1196.pos, var21);
						if (field1202 != 0) {
							for (int var22 = 0; var22 < var21; var22++) {
								field1196.data[field1196.pos + var22] ^= field1202;
							}
						}
						field1196.pos += var21;
						field1201 += var21;
						if (field1196.pos == var20) {
							if (field812.nodeId == 16711935L) {
								field542 = field1196;
								for (int var23 = 0; var23 < 256; var23++) {
									Js5Provider var24 = field1200[var23];
									if (var24 != null) {
										field542.pos = var23 * 8 + 5;
										int var25 = field542.g4();
										int var26 = field542.g4();
										var24.method1476(var25, var26);
									}
								}
							} else {
								field1184.reset();
								field1184.update(field1196.data, 0, var20);
								int var27 = (int) field1184.getValue();
								if (field812.field2491 != var27) {
									try {
										LoginScreen.field169.close();
									} catch (Exception var32) {
									}
									field1198++;
									LoginScreen.field169 = null;
									field1202 = (byte) (Math.random() * 255.0D + 1.0D);
									return false;
								}
								field1198 = 0;
								field1203 = 0;
								field812.field2492.method1467((int) (field812.nodeId & 0xFFFFL), field1196.data, (field812.nodeId & 0xFF0000L) == 16711680L, field1194);
							}
							field812.unlink();
							if (field1194) {
								field1188--;
							} else {
								field1197--;
							}
							field1201 = 0;
							field812 = null;
							field1196 = null;
						} else {
							if (field1201 != 512) {
								break;
							}
							field1201 = 0;
						}
					}
				}
				return true;
			} catch (IOException var33) {
				try {
					LoginScreen.field169.close();
				} catch (Exception var31) {
				}
				field1203++;
				LoginScreen.field169 = null;
				return false;
			}
		}
	}

	@ObfuscatedName("p.d(ZI)V")
	public static void method343(boolean arg0) {
		if (LoginScreen.field169 == null) {
			return;
		}
		try {
			Packet var1 = new Packet(4);
			var1.p1(arg0 ? 2 : 3);
			var1.p3(0);
			LoginScreen.field169.write(var1.data, 0, 4);
		} catch (IOException var5) {
			try {
				LoginScreen.field169.close();
			} catch (Exception var4) {
			}
			field1203++;
			LoginScreen.field169 = null;
		}
	}

	@ObfuscatedName("q.l(Lam;ZB)V")
	public static void method96(ClientStream arg0, boolean arg1) {
		if (LoginScreen.field169 != null) {
			try {
				LoginScreen.field169.close();
			} catch (Exception var10) {
			}
			LoginScreen.field169 = null;
		}
		LoginScreen.field169 = arg0;
		method343(arg1);
		field1195.pos = 0;
		field812 = null;
		field1196 = null;
		field1201 = 0;
		while (true) {
			Js5NetRequest var3 = (Js5NetRequest) field1187.method1284();
			if (var3 == null) {
				while (true) {
					Js5NetRequest var4 = (Js5NetRequest) field1199.method1284();
					if (var4 == null) {
						if (field1202 != 0) {
							try {
								Packet var5 = new Packet(4);
								var5.p1(4);
								var5.p1(field1202);
								var5.p2(0);
								LoginScreen.field169.write(var5.data, 0, 4);
							} catch (IOException var9) {
								try {
									LoginScreen.field169.close();
								} catch (Exception var8) {
								}
								field1203++;
								LoginScreen.field169 = null;
							}
						}
						field1190 = 0;
						field825 = MonotonicTime.method1135();
						return;
					}
					field1189.addHead(var4);
					field1193.put(var4, var4.nodeId);
					field1191++;
					field1197--;
				}
			}
			field1185.put(var3, var3.nodeId);
			field1186++;
			field1188--;
		}
	}

	@ObfuscatedName("by.m(Ldq;IIIBZI)V")
	public static void method827(Js5Provider arg0, int arg1, int arg2, int arg3, byte arg4, boolean arg5) {
		long var6 = (long) ((arg1 << 16) + arg2);
		Js5NetRequest var8 = (Js5NetRequest) field1185.get(var6);
		if (var8 != null) {
			return;
		}
		Js5NetRequest var9 = (Js5NetRequest) field1187.get(var6);
		if (var9 != null) {
			return;
		}
		Js5NetRequest var10 = (Js5NetRequest) field1193.get(var6);
		if (var10 == null) {
			if (!arg5) {
				Js5NetRequest var11 = (Js5NetRequest) field1199.get(var6);
				if (var11 != null) {
					return;
				}
			}
			Js5NetRequest var12 = new Js5NetRequest();
			var12.field2492 = arg0;
			var12.field2491 = arg3;
			var12.field2490 = arg4;
			if (arg5) {
				field1185.put(var12, var6);
				field1186++;
			} else {
				field1189.push(var12);
				field1193.put(var12, var6);
				field1191++;
			}
		} else if (arg5) {
			var10.unlink2();
			field1185.put(var10, var6);
			field1191--;
			field1186++;
		}
	}

	@ObfuscatedName("ab.c(IIS)V")
	public static void method555(int arg0, int arg1) {
		long var2 = (long) ((arg0 << 16) + arg1);
		Js5NetRequest var4 = (Js5NetRequest) field1193.get(var2);
		if (var4 != null) {
			field1189.addHead(var4);
		}
	}

	@ObfuscatedName("v.n(III)I")
	public static int method161(int arg0, int arg1) {
		long var2 = (long) ((arg0 << 16) + arg1);
		return field812 != null && field812.nodeId == var2 ? field1196.pos * 99 / (field1196.data.length - field812.field2490) + 1 : 0;
	}

	public static int imethod1() {
		return field1188 + field1186;
	}
}
