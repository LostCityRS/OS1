package jagex2.io;

import deob.ObfuscatedName;
import jagex2.client.JagException;
import jagex2.client.PrivilegedRequest;
import jagex2.client.SignLink;
import jagex2.datastruct.PreciseSleep;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

@ObfuscatedName("am")
public class ClientStream implements Runnable {

	@ObfuscatedName("am.r")
	public InputStream field361;

	@ObfuscatedName("am.d")
	public OutputStream field353;

	@ObfuscatedName("am.l")
	public Socket field354;

	@ObfuscatedName("am.m")
	public boolean field352 = false;

	@ObfuscatedName("am.c")
	public SignLink field358;

	@ObfuscatedName("am.n")
	public PrivilegedRequest field357;

	@ObfuscatedName("am.j")
	public byte[] field355;

	@ObfuscatedName("am.z")
	public int field359 = 0;

	@ObfuscatedName("am.g")
	public int field360 = 0;

	@ObfuscatedName("am.q")
	public boolean field356 = false;

	public ClientStream(Socket arg0, SignLink arg1) throws IOException {
		this.field358 = arg1;
		this.field354 = arg0;
		this.field354.setSoTimeout(30000);
		this.field354.setTcpNoDelay(true);
		this.field361 = this.field354.getInputStream();
		this.field353 = this.field354.getOutputStream();
	}

	@ObfuscatedName("am.m(I)V")
	public void method392() {
		if (this.field352) {
			return;
		}
		synchronized (this) {
			this.field352 = true;
			this.notifyAll();
		}
		if (this.field357 != null) {
			while (this.field357.field507 == 0) {
				PreciseSleep.method1020(1L);
			}
			if (this.field357.field507 == 1) {
				try {
					((Thread) this.field357.field511).join();
				} catch (InterruptedException var4) {
				}
			}
		}
		this.field357 = null;
	}

	public void finalize() {
		this.method392();
	}

	@ObfuscatedName("am.c(I)I")
	public int method398() throws IOException {
		return this.field352 ? 0 : this.field361.read();
	}

	@ObfuscatedName("am.n(I)I")
	public int method394() throws IOException {
		return this.field352 ? 0 : this.field361.available();
	}

	@ObfuscatedName("am.j([BIII)V")
	public void method391(byte[] arg0, int arg1, int arg2) throws IOException {
		if (this.field352) {
			return;
		}
		while (arg2 > 0) {
			int var4 = this.field361.read(arg0, arg1, arg2);
			if (var4 <= 0) {
				throw new EOFException();
			}
			arg1 += var4;
			arg2 -= var4;
		}
	}

	@ObfuscatedName("am.z([BIII)V")
	public void method396(byte[] arg0, int arg1, int arg2) throws IOException {
		if (this.field352) {
			return;
		}
		if (this.field356) {
			this.field356 = false;
			throw new IOException();
		}
		if (this.field355 == null) {
			this.field355 = new byte[5000];
		}
		synchronized (this) {
			for (int var5 = 0; var5 < arg2; var5++) {
				this.field355[this.field360] = arg0[arg1 + var5];
				this.field360 = (this.field360 + 1) % 5000;
				if ((this.field359 + 4900) % 5000 == this.field360) {
					throw new IOException();
				}
			}
			if (this.field357 == null) {
				this.field357 = this.field358.method437(this, 3);
			}
			this.notifyAll();
		}
	}

	public void run() {
		try {
			while (true) {
				label84: {
					int var3;
					int var4;
					synchronized (this) {
						if (this.field360 == this.field359) {
							if (this.field352) {
								break label84;
							}
							try {
								this.wait();
							} catch (InterruptedException var13) {
							}
						}
						var3 = this.field359;
						if (this.field360 >= this.field359) {
							var4 = this.field360 - this.field359;
						} else {
							var4 = 5000 - this.field359;
						}
					}
					if (var4 <= 0) {
						continue;
					}
					try {
						this.field353.write(this.field355, var3, var4);
					} catch (IOException var12) {
						this.field356 = true;
					}
					this.field359 = (this.field359 + var4) % 5000;
					try {
						if (this.field360 == this.field359) {
							this.field353.flush();
						}
					} catch (IOException var11) {
						this.field356 = true;
					}
					continue;
				}
				try {
					if (this.field361 != null) {
						this.field361.close();
					}
					if (this.field353 != null) {
						this.field353.close();
					}
					if (this.field354 != null) {
						this.field354.close();
					}
				} catch (IOException var10) {
				}
				this.field355 = null;
				break;
			}
		} catch (Exception var15) {
			JagException.report(null, (Throwable) var15);
		}
	}
}
