package jagex2.datastruct;

import deob.ObfuscatedName;

@ObfuscatedName("en")
public class DoublyLinkable extends Linkable {

	@ObfuscatedName("en.m")
	public DoublyLinkable field1902;

	@ObfuscatedName("en.c")
	public DoublyLinkable field1901;

	@ObfuscatedName("en.c()V")
	public void method1841() {
		if (this.field1901 != null) {
			this.field1901.field1902 = this.field1902;
			this.field1902.field1901 = this.field1901;
			this.field1902 = null;
			this.field1901 = null;
		}
	}
}
