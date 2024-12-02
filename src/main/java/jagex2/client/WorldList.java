package jagex2.client;

import deob.ObfuscatedName;
import jagex2.datastruct.MonotonicTime;
import jagex2.io.Packet;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;

@ObfuscatedName("i")
public class WorldList {

	@ObfuscatedName("i.r")
	public int field179;

	@ObfuscatedName("i.d")
	public PrivilegedRequest field181;

	@ObfuscatedName("i.l")
	public DataInputStream field180;

	@ObfuscatedName("i.m")
	public byte[] field185 = new byte[4];

	@ObfuscatedName("i.c")
	public int field182;

	@ObfuscatedName("i.n")
	public byte[] field178;

	@ObfuscatedName("i.j")
	public int field184;

	@ObfuscatedName("i.z")
	public long field183;

	public WorldList(SignLink arg0, URL arg1) {
		this.field181 = arg0.method445(arg1);
		this.field179 = 0;
		this.field183 = MonotonicTime.method1135() + 30000L;
	}

	@ObfuscatedName("i.r(I)[B")
	public byte[] method99() throws IOException {
		if (MonotonicTime.method1135() > this.field183) {
			throw new IOException();
		}
		if (this.field179 == 0) {
			if (this.field181.field507 == 2) {
				throw new IOException();
			}
			if (this.field181.field507 == 1) {
				this.field180 = (DataInputStream) this.field181.field511;
				this.field179 = 1;
			}
		}
		if (this.field179 == 1) {
			int var1 = this.field180.available();
			if (var1 > 0) {
				if (this.field182 + var1 > 4) {
					var1 = 4 - this.field182;
				}
				this.field182 += this.field180.read(this.field185, this.field182, var1);
				if (this.field182 == 4) {
					int var2 = (new Packet(this.field185)).method1605();
					this.field178 = new byte[var2];
					this.field179 = 2;
				}
			}
		}
		if (this.field179 == 2) {
			int var3 = this.field180.available();
			if (var3 > 0) {
				if (this.field184 + var3 > this.field178.length) {
					var3 = this.field178.length - this.field184;
				}
				this.field184 += this.field180.read(this.field178, this.field184, var3);
				if (this.field184 == this.field178.length) {
					return this.field178;
				}
			}
		}
		return null;
	}
}
