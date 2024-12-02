package jagex2.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("cf")
public class HashTable {

	@ObfuscatedName("cf.r")
	public int field1497;

	@ObfuscatedName("cf.d")
	public Linkable[] field1496;

	@ObfuscatedName("cf.l")
	public Linkable field1498;

	@ObfuscatedName("cf.m")
	public Linkable field1495;

	@ObfuscatedName("cf.c")
	public int field1499 = 0;

	public HashTable(int arg0) {
		this.field1497 = arg0;
		this.field1496 = new Linkable[arg0];
		for (int var2 = 0; var2 < arg0; var2++) {
			Linkable var3 = this.field1496[var2] = new Linkable();
			var3.field1505 = var3;
			var3.field1504 = var3;
		}
	}

	@ObfuscatedName("cf.r(J)Ldg;")
	public Linkable method1277(long arg0) {
		Linkable var3 = this.field1496[(int) (arg0 & (long) (this.field1497 - 1))];
		for (this.field1498 = var3.field1505; this.field1498 != var3; this.field1498 = this.field1498.field1505) {
			if (this.field1498.field1506 == arg0) {
				Linkable var4 = this.field1498;
				this.field1498 = this.field1498.field1505;
				return var4;
			}
		}
		this.field1498 = null;
		return null;
	}

	@ObfuscatedName("cf.d(Ldg;J)V")
	public void method1278(Linkable arg0, long arg1) {
		if (arg0.field1504 != null) {
			arg0.method1325();
		}
		Linkable var4 = this.field1496[(int) (arg1 & (long) (this.field1497 - 1))];
		arg0.field1504 = var4.field1504;
		arg0.field1505 = var4;
		arg0.field1504.field1505 = arg0;
		arg0.field1505.field1504 = arg0;
		arg0.field1506 = arg1;
	}

	@ObfuscatedName("cf.l()V")
	public void method1283() {
		for (int var1 = 0; var1 < this.field1497; var1++) {
			Linkable var2 = this.field1496[var1];
			while (true) {
				Linkable var3 = var2.field1505;
				if (var2 == var3) {
					break;
				}
				var3.method1325();
			}
		}
		this.field1498 = null;
		this.field1495 = null;
	}

	@ObfuscatedName("cf.m()Ldg;")
	public Linkable method1284() {
		this.field1499 = 0;
		return this.method1280();
	}

	@ObfuscatedName("cf.c()Ldg;")
	public Linkable method1280() {
		if (this.field1499 > 0 && this.field1496[this.field1499 - 1] != this.field1495) {
			Linkable var1 = this.field1495;
			this.field1495 = var1.field1505;
			return var1;
		}
		Linkable var2;
		do {
			if (this.field1499 >= this.field1497) {
				return null;
			}
			var2 = this.field1496[this.field1499++].field1505;
		} while (this.field1496[this.field1499 - 1] == var2);
		this.field1495 = var2.field1505;
		return var2;
	}
}
