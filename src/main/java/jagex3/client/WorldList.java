package jagex3.client;

import deob.ObfuscatedName;
import jagex3.datastruct.MonotonicTime;
import jagex3.io.Packet;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;

// jag::oldscape::GameWorld (?)
@ObfuscatedName("i")
public class WorldList {

	@ObfuscatedName("i.r")
	public int stage;

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
		this.stage = 0;
		this.field183 = MonotonicTime.currentTime() + 30000L;
	}

	@ObfuscatedName("i.r(I)[B")
	public byte[] getWorldList() throws IOException {
		if (MonotonicTime.currentTime() > this.field183) {
			throw new IOException();
		}

		if (this.stage == 0) {
			if (this.field181.field507 == 2) {
				throw new IOException();
			}

			if (this.field181.field507 == 1) {
				this.field180 = (DataInputStream) this.field181.field511;
				this.stage = 1;
			}
		}

		if (this.stage == 1) {
			int available = this.field180.available();
			if (available > 0) {
				if (this.field182 + available > 4) {
					available = 4 - this.field182;
				}

				this.field182 += this.field180.read(this.field185, this.field182, available);

				if (this.field182 == 4) {
					int length = (new Packet(this.field185)).g4();
					this.field178 = new byte[length];
					this.stage = 2;
				}
			}
		}

		if (this.stage == 2) {
			int available = this.field180.available();
			if (available > 0) {
				if (this.field184 + available > this.field178.length) {
					available = this.field178.length - this.field184;
				}

				this.field184 += this.field180.read(this.field178, this.field184, available);

				if (this.field184 == this.field178.length) {
					return this.field178;
				}
			}
		}

		return null;
	}
}
