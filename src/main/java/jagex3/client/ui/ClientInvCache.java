package jagex3.client.ui;

import deob.ObfuscatedName;
import jagex3.datastruct.HashTable;
import jagex3.datastruct.Linkable;

// jag::oldscape::ClientInvCache
@ObfuscatedName("dl")
public class ClientInvCache extends Linkable {

	// jag::oldscape::ClientInvCache::m_invList
	@ObfuscatedName("dl.m")
	public static HashTable invList = new HashTable(32);

	@ObfuscatedName("dl.c")
	public int[] objId = new int[] { -1 };

	@ObfuscatedName("dl.n")
	public int[] objCount = new int[] { 0 };

	// jag::oldscape::ClientInvCache::GetCount
	@ObfuscatedName("r.c(III)I")
	public static int getCount(int arg0, int arg1) {
		ClientInvCache var2 = (ClientInvCache) invList.get(arg0);
		if (var2 == null) {
			return 0;
		}
		if (arg1 < 0 || arg1 >= var2.objCount.length) {
			return 0;
		}
		return var2.objCount[arg1];
	}

	// jag::oldscape::ClientInvCache::InvTotal
	@ObfuscatedName("dj.n(IIB)I")
	public static int invTotal(int arg0, int arg1) {
		ClientInvCache var2 = (ClientInvCache) invList.get(arg0);
		if (var2 == null) {
			return 0;
		}
		if (arg1 == -1) {
			return 0;
		}
		int var3 = 0;
		for (int var4 = 0; var4 < var2.objCount.length; var4++) {
			if (var2.objId[var4] == arg1) {
				var3 += var2.objCount[var4];
			}
		}
		return var3;
	}

	// jag::oldscape::ClientInvCache::Set
	@ObfuscatedName("fh.j(IIIII)V")
	public static void method2901(int arg0, int arg1, int arg2, int arg3) {
		ClientInvCache var4 = (ClientInvCache) invList.get(arg0);
		if (var4 == null) {
			var4 = new ClientInvCache();
			invList.put(var4, (long) arg0);
		}
		if (var4.objId.length <= arg1) {
			int[] var5 = new int[arg1 + 1];
			int[] var6 = new int[arg1 + 1];
			for (int var7 = 0; var7 < var4.objId.length; var7++) {
				var5[var7] = var4.objId[var7];
				var6[var7] = var4.objCount[var7];
			}
			for (int var8 = var4.objId.length; var8 < arg1; var8++) {
				var5[var8] = -1;
				var6[var8] = 0;
			}
			var4.objId = var5;
			var4.objCount = var6;
		}
		var4.objId[arg1] = arg2;
		var4.objCount[arg1] = arg3;
	}

	// jag::oldscape::ClientInvCache::Delete
	@ObfuscatedName("n.z(IB)V")
	public static void delete(int arg0) {
		ClientInvCache var1 = (ClientInvCache) invList.get(arg0);
		if (var1 != null) {
			var1.unlink();
		}
	}

	// jag::oldscape::ClientInvCache::GetType
	public static int getType(int var141, int var142) {
		ClientInvCache var145 = (ClientInvCache) ClientInvCache.invList.get(var141);
		if (var145 == null) {
			return -1;
		}
		if (var142 < 0 || var142 >= var145.objId.length) {
			return -1;
		}
		return var145.objId[var142];
	}

	// jag::oldscape::ClientInvCache::DeleteAll
	public static void deleteAll() {
		invList = new HashTable(32);
	}
}
