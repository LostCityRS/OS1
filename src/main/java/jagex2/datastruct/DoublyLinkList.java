package jagex2.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("ci")
public class DoublyLinkList {

	@ObfuscatedName("ci.r")
	public DoublyLinkable field1492 = new DoublyLinkable();

	public DoublyLinkList() {
		this.field1492.field1902 = this.field1492;
		this.field1492.field1901 = this.field1492;
	}

	@ObfuscatedName("ci.r(Len;)V")
	public void method1256(DoublyLinkable arg0) {
		if (arg0.field1901 != null) {
			arg0.method1841();
		}
		arg0.field1901 = this.field1492.field1901;
		arg0.field1902 = this.field1492;
		arg0.field1901.field1902 = arg0;
		arg0.field1902.field1901 = arg0;
	}

	@ObfuscatedName("ci.d(Len;)V")
	public void method1257(DoublyLinkable arg0) {
		if (arg0.field1901 != null) {
			arg0.method1841();
		}
		arg0.field1901 = this.field1492;
		arg0.field1902 = this.field1492.field1902;
		arg0.field1901.field1902 = arg0;
		arg0.field1902.field1901 = arg0;
	}

	@ObfuscatedName("ci.l()Len;")
	public DoublyLinkable method1258() {
		DoublyLinkable var1 = this.field1492.field1902;
		if (this.field1492 == var1) {
			return null;
		} else {
			var1.method1841();
			return var1;
		}
	}

	@ObfuscatedName("ci.m()Len;")
	public DoublyLinkable method1259() {
		DoublyLinkable var1 = this.field1492.field1902;
		return this.field1492 == var1 ? null : var1;
	}

	@ObfuscatedName("ci.c()V")
	public void method1260() {
		while (true) {
			DoublyLinkable var1 = this.field1492.field1902;
			if (this.field1492 == var1) {
				return;
			}
			var1.method1841();
		}
	}
}
