package jagex2.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("cg")
public class LinkList {

	@ObfuscatedName("cg.r")
	public Linkable field1500 = new Linkable();

	@ObfuscatedName("cg.d")
	public Linkable field1501;

	public LinkList() {
		this.field1500.field1505 = this.field1500;
		this.field1500.field1504 = this.field1500;
	}

	@ObfuscatedName("cg.r()V")
	public void method1291() {
		while (true) {
			Linkable var1 = this.field1500.field1505;
			if (this.field1500 == var1) {
				this.field1501 = null;
				return;
			}
			var1.method1325();
		}
	}

	@ObfuscatedName("cg.d(Ldg;)V")
	public void method1292(Linkable arg0) {
		if (arg0.field1504 != null) {
			arg0.method1325();
		}
		arg0.field1504 = this.field1500.field1504;
		arg0.field1505 = this.field1500;
		arg0.field1504.field1505 = arg0;
		arg0.field1505.field1504 = arg0;
	}

	@ObfuscatedName("cg.l(Ldg;)V")
	public void method1312(Linkable arg0) {
		if (arg0.field1504 != null) {
			arg0.method1325();
		}
		arg0.field1504 = this.field1500;
		arg0.field1505 = this.field1500.field1505;
		arg0.field1504.field1505 = arg0;
		arg0.field1505.field1504 = arg0;
	}

	@ObfuscatedName("cg.m(Ldg;Ldg;)V")
	public static void method1294(Linkable arg0, Linkable arg1) {
		if (arg0.field1504 != null) {
			arg0.method1325();
		}
		arg0.field1504 = arg1.field1504;
		arg0.field1505 = arg1;
		arg0.field1504.field1505 = arg0;
		arg0.field1505.field1504 = arg0;
	}

	@ObfuscatedName("cg.c()Ldg;")
	public Linkable method1295() {
		Linkable var1 = this.field1500.field1505;
		if (this.field1500 == var1) {
			return null;
		} else {
			var1.method1325();
			return var1;
		}
	}

	@ObfuscatedName("cg.n()Ldg;")
	public Linkable method1290() {
		Linkable var1 = this.field1500.field1504;
		if (this.field1500 == var1) {
			return null;
		} else {
			var1.method1325();
			return var1;
		}
	}

	@ObfuscatedName("cg.j()Ldg;")
	public Linkable method1297() {
		Linkable var1 = this.field1500.field1505;
		if (this.field1500 == var1) {
			this.field1501 = null;
			return null;
		} else {
			this.field1501 = var1.field1505;
			return var1;
		}
	}

	@ObfuscatedName("cg.z()Ldg;")
	public Linkable method1304() {
		Linkable var1 = this.field1500.field1504;
		if (this.field1500 == var1) {
			this.field1501 = null;
			return null;
		} else {
			this.field1501 = var1.field1504;
			return var1;
		}
	}

	@ObfuscatedName("cg.g()Ldg;")
	public Linkable method1299() {
		Linkable var1 = this.field1501;
		if (this.field1500 == var1) {
			this.field1501 = null;
			return null;
		} else {
			this.field1501 = var1.field1505;
			return var1;
		}
	}

	@ObfuscatedName("cg.q()Ldg;")
	public Linkable method1300() {
		Linkable var1 = this.field1501;
		if (this.field1500 == var1) {
			this.field1501 = null;
			return null;
		} else {
			this.field1501 = var1.field1504;
			return var1;
		}
	}
}
