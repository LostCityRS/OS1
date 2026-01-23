package jagex3.client;

import deob.ObfuscatedName;
import jagex3.datastruct.MonotonicTime;
import jagex3.io.Packet;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;

// jag::http::HTTPRequest::HTTPRequest
@ObfuscatedName("i")
public class HTTPRequest {

	@ObfuscatedName("i.r")
	public int stage;

	@ObfuscatedName("i.d")
	public PrivilegedRequest req;

	@ObfuscatedName("i.l")
	public DataInputStream stream;

	@ObfuscatedName("i.m")
	public byte[] temp = new byte[4];

	@ObfuscatedName("i.c")
	public int read1;

	@ObfuscatedName("i.n")
	public byte[] data;

	@ObfuscatedName("i.j")
	public int read2;

	@ObfuscatedName("i.z")
	public long timeout;

	public HTTPRequest(SignLink sign, URL url) {
		this.req = sign.urlreq(url);
		this.stage = 0;
		this.timeout = MonotonicTime.currentTime() + 30000L;
	}

	// jag::http::HTTPRequest::GetData
	@ObfuscatedName("i.r(I)[B")
	public byte[] getData() throws IOException {
		if (MonotonicTime.currentTime() > this.timeout) {
			throw new IOException();
		}

		if (this.stage == 0) {
			if (this.req.status == 2) {
				throw new IOException();
			}

			if (this.req.status == 1) {
				this.stream = (DataInputStream) this.req.result;
				this.stage = 1;
			}
		}

		if (this.stage == 1) {
			int available = this.stream.available();
			if (available > 0) {
				if (this.read1 + available > 4) {
					available = 4 - this.read1;
				}

				this.read1 += this.stream.read(this.temp, this.read1, available);

				if (this.read1 == 4) {
					int length = (new Packet(this.temp)).g4();
					this.data = new byte[length];
					this.stage = 2;
				}
			}
		}

		if (this.stage == 2) {
			int available = this.stream.available();
			if (available > 0) {
				if (this.read2 + available > this.data.length) {
					available = this.data.length - this.read2;
				}

				this.read2 += this.stream.read(this.data, this.read2, available);

				if (this.read2 == this.data.length) {
					return this.data;
				}
			}
		}

		return null;
	}
}
