package jagex2.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("dg")
public class Linkable {

	@ObfuscatedName("dg.r")
	public long field1506;

	@ObfuscatedName("dg.d")
	public Linkable field1505;

	@ObfuscatedName("dg.l")
	public Linkable field1504;

	@ObfuscatedName("dg.r()V")
	public void method1325() {
		if (this.field1504 != null) {
			this.field1504.field1505 = this.field1505;
			this.field1505.field1504 = this.field1504;
			this.field1505 = null;
			this.field1504 = null;
		}
	}

	@ObfuscatedName("dg.d()Z")
	public boolean method1326() {
		return this.field1504 != null;
	}
}
