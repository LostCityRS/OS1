package jagex2.js5;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.datastruct.DoublyLinkList;
import jagex2.datastruct.HashTable;
import jagex2.datastruct.MonotonicTime;
import jagex2.io.ClientStream;
import jagex2.io.Packet;

import java.io.IOException;
import java.util.zip.CRC32;

@ObfuscatedName("cu")
public class Js5TcpClient {

	@ObfuscatedName("cu.d")
	public static int field1190 = 0;

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

	@ObfuscatedName("cu.w")
	public static Packet field1195 = new Packet(8);

	@ObfuscatedName("cu.b")
	public static int field1201 = 0;

	@ObfuscatedName("cu.t")
	public static CRC32 field1184 = new CRC32();

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
		int var2 = (int) (var0 - Statics.field825);
		Statics.field825 = var0;
		if (var2 > 200) {
			var2 = 200;
		}
		field1190 += var2;
		if (field1197 == 0 && field1188 == 0 && field1191 == 0 && field1186 == 0) {
			return true;
		} else if (Statics.field169 == null) {
			return false;
		} else {
			try {
				if (field1190 > 30000) {
					throw new IOException();
				}
				while (field1188 < 20 && field1186 > 0) {
					Js5NetRequest var3 = (Js5NetRequest) field1185.method1284();
					Packet var4 = new Packet(4);
					var4.method1587(1);
					var4.method1624((int) var3.field1506);
					Statics.field169.method396(var4.field1732, 0, 4);
					field1187.method1278(var3, var3.field1506);
					field1186--;
					field1188++;
				}
				while (field1197 < 20 && field1191 > 0) {
					Js5NetRequest var5 = (Js5NetRequest) field1189.method1259();
					Packet var6 = new Packet(4);
					var6.method1587(0);
					var6.method1624((int) var5.field1506);
					Statics.field169.method396(var6.field1732, 0, 4);
					var5.method1841();
					field1199.method1278(var5, var5.field1506);
					field1191--;
					field1197++;
				}
				for (int var7 = 0; var7 < 100; var7++) {
					int var8 = Statics.field169.method394();
					if (var8 < 0) {
						throw new IOException();
					}
					if (var8 == 0) {
						break;
					}
					field1190 = 0;
					byte var9 = 0;
					if (Statics.field812 == null) {
						var9 = 8;
					} else if (field1201 == 0) {
						var9 = 1;
					}
					if (var9 > 0) {
						int var10 = var9 - field1195.field1729;
						if (var10 > var8) {
							var10 = var8;
						}
						Statics.field169.method391(field1195.field1732, field1195.field1729, var10);
						if (field1202 != 0) {
							for (int var11 = 0; var11 < var10; var11++) {
								field1195.field1732[field1195.field1729 + var11] ^= field1202;
							}
						}
						field1195.field1729 += var10;
						if (field1195.field1729 < var9) {
							break;
						}
						if (Statics.field812 == null) {
							field1195.field1729 = 0;
							int var12 = field1195.method1600();
							int var13 = field1195.method1602();
							int var14 = field1195.method1600();
							int var15 = field1195.method1605();
							long var16 = (long) ((var12 << 16) + var13);
							Js5NetRequest var18 = (Js5NetRequest) field1187.method1277(var16);
							Statics.field1194 = true;
							if (var18 == null) {
								var18 = (Js5NetRequest) field1199.method1277(var16);
								Statics.field1194 = false;
							}
							if (var18 == null) {
								throw new IOException();
							}
							int var19 = var14 == 0 ? 5 : 9;
							Statics.field812 = var18;
							Statics.field1196 = new Packet(var15 + var19 + Statics.field812.field2490);
							Statics.field1196.method1587(var14);
							Statics.field1196.method1761(var15);
							field1201 = 8;
							field1195.field1729 = 0;
						} else if (field1201 == 0) {
							if (field1195.field1732[0] == -1) {
								field1201 = 1;
								field1195.field1729 = 0;
							} else {
								Statics.field812 = null;
							}
						}
					} else {
						int var20 = Statics.field1196.field1732.length - Statics.field812.field2490;
						int var21 = 512 - field1201;
						if (var21 > var20 - Statics.field1196.field1729) {
							var21 = var20 - Statics.field1196.field1729;
						}
						if (var21 > var8) {
							var21 = var8;
						}
						Statics.field169.method391(Statics.field1196.field1732, Statics.field1196.field1729, var21);
						if (field1202 != 0) {
							for (int var22 = 0; var22 < var21; var22++) {
								Statics.field1196.field1732[Statics.field1196.field1729 + var22] ^= field1202;
							}
						}
						Statics.field1196.field1729 += var21;
						field1201 += var21;
						if (Statics.field1196.field1729 == var20) {
							if (Statics.field812.field1506 == 16711935L) {
								Statics.field542 = Statics.field1196;
								for (int var23 = 0; var23 < 256; var23++) {
									Js5Provider var24 = field1200[var23];
									if (var24 != null) {
										Statics.field542.field1729 = var23 * 8 + 5;
										int var25 = Statics.field542.method1605();
										int var26 = Statics.field542.method1605();
										var24.method1476(var25, var26);
									}
								}
							} else {
								field1184.reset();
								field1184.update(Statics.field1196.field1732, 0, var20);
								int var27 = (int) field1184.getValue();
								if (Statics.field812.field2491 != var27) {
									try {
										Statics.field169.method392();
									} catch (Exception var32) {
									}
									field1198++;
									Statics.field169 = null;
									field1202 = (byte) (Math.random() * 255.0D + 1.0D);
									return false;
								}
								field1198 = 0;
								field1203 = 0;
								Statics.field812.field2492.method1467((int) (Statics.field812.field1506 & 0xFFFFL), Statics.field1196.field1732, (Statics.field812.field1506 & 0xFF0000L) == 16711680L, Statics.field1194);
							}
							Statics.field812.method1325();
							if (Statics.field1194) {
								field1188--;
							} else {
								field1197--;
							}
							field1201 = 0;
							Statics.field812 = null;
							Statics.field1196 = null;
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
					Statics.field169.method392();
				} catch (Exception var31) {
				}
				field1203++;
				Statics.field169 = null;
				return false;
			}
		}
	}

	@ObfuscatedName("p.d(ZI)V")
	public static void method343(boolean arg0) {
		if (Statics.field169 == null) {
			return;
		}
		try {
			Packet var1 = new Packet(4);
			var1.method1587(arg0 ? 2 : 3);
			var1.method1624(0);
			Statics.field169.method396(var1.field1732, 0, 4);
		} catch (IOException var5) {
			try {
				Statics.field169.method392();
			} catch (Exception var4) {
			}
			field1203++;
			Statics.field169 = null;
		}
	}

	@ObfuscatedName("q.l(Lam;ZB)V")
	public static void method96(ClientStream arg0, boolean arg1) {
		if (Statics.field169 != null) {
			try {
				Statics.field169.method392();
			} catch (Exception var10) {
			}
			Statics.field169 = null;
		}
		Statics.field169 = arg0;
		method343(arg1);
		field1195.field1729 = 0;
		Statics.field812 = null;
		Statics.field1196 = null;
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
								var5.method1587(4);
								var5.method1587(field1202);
								var5.method1667(0);
								Statics.field169.method396(var5.field1732, 0, 4);
							} catch (IOException var9) {
								try {
									Statics.field169.method392();
								} catch (Exception var8) {
								}
								field1203++;
								Statics.field169 = null;
							}
						}
						field1190 = 0;
						Statics.field825 = MonotonicTime.method1135();
						return;
					}
					field1189.method1257(var4);
					field1193.method1278(var4, var4.field1506);
					field1191++;
					field1197--;
				}
			}
			field1185.method1278(var3, var3.field1506);
			field1186++;
			field1188--;
		}
	}

	@ObfuscatedName("ab.c(IIS)V")
	public static void method555(int arg0, int arg1) {
		long var2 = (long) ((arg0 << 16) + arg1);
		Js5NetRequest var4 = (Js5NetRequest) field1193.method1277(var2);
		if (var4 != null) {
			field1189.method1257(var4);
		}
	}

	@ObfuscatedName("v.n(III)I")
	public static int method161(int arg0, int arg1) {
		long var2 = (long) ((arg0 << 16) + arg1);
		return Statics.field812 != null && Statics.field812.field1506 == var2 ? Statics.field1196.field1729 * 99 / (Statics.field1196.field1732.length - Statics.field812.field2490) + 1 : 0;
	}
}
