package jagex3.io;

import deob.ObfuscatedName;
import jagex3.client.JagException;
import jagex3.client.PrivilegedRequest;
import jagex3.client.TaskHandler;
import jagex3.datastruct.PreciseSleep;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

@ObfuscatedName("am")
public class ClientStream implements Runnable {

	@ObfuscatedName("am.r")
	public InputStream in;

	@ObfuscatedName("am.d")
	public OutputStream out;

	@ObfuscatedName("am.l")
	public Socket socket;

	@ObfuscatedName("am.m")
	public boolean dummy = false;

	@ObfuscatedName("am.c")
	public TaskHandler signlink;

	@ObfuscatedName("am.n")
	public PrivilegedRequest writer;

	@ObfuscatedName("am.j")
	public byte[] buf;

	@ObfuscatedName("am.z")
	public int tcyl = 0;

	@ObfuscatedName("am.g")
	public int tnum = 0;

	@ObfuscatedName("am.q")
	public boolean ioerror = false;

	public ClientStream(Socket arg0, TaskHandler arg1) throws IOException {
		this.signlink = arg1;
		this.socket = arg0;
		this.socket.setSoTimeout(30000);
		this.socket.setTcpNoDelay(true);
		this.in = this.socket.getInputStream();
		this.out = this.socket.getOutputStream();
	}

	@ObfuscatedName("am.m(I)V")
	public void close() {
		if (this.dummy) {
			return;
		}
		synchronized (this) {
			this.dummy = true;
			this.notifyAll();
		}
		if (this.writer != null) {
			while (this.writer.status == 0) {
				PreciseSleep.sleep(1L);
			}
			if (this.writer.status == 1) {
				try {
					((Thread) this.writer.result).join();
				} catch (InterruptedException var4) {
				}
			}
		}
		this.writer = null;
	}

	public void finalize() {
		this.close();
	}

	@ObfuscatedName("am.c(I)I")
	public int read() throws IOException {
		return this.dummy ? 0 : this.in.read();
	}

	@ObfuscatedName("am.n(I)I")
	public int available() throws IOException {
		return this.dummy ? 0 : this.in.available();
	}

	@ObfuscatedName("am.j([BIII)V")
	public void read(byte[] arg0, int arg1, int arg2) throws IOException {
		if (this.dummy) {
			return;
		}
		while (arg2 > 0) {
			int var4 = this.in.read(arg0, arg1, arg2);
			if (var4 <= 0) {
				throw new EOFException();
			}
			arg1 += var4;
			arg2 -= var4;
		}
	}

	@ObfuscatedName("am.z([BIII)V")
	public void write(byte[] arg0, int arg1, int arg2) throws IOException {
		if (this.dummy) {
			return;
		}
		if (this.ioerror) {
			this.ioerror = false;
			throw new IOException();
		}
		if (this.buf == null) {
			this.buf = new byte[5000];
		}
		synchronized (this) {
			for (int var5 = 0; var5 < arg2; var5++) {
				this.buf[this.tnum] = arg0[arg1 + var5];
				this.tnum = (this.tnum + 1) % 5000;
				if ((this.tcyl + 4900) % 5000 == this.tnum) {
					throw new IOException();
				}
			}
			if (this.writer == null) {
				this.writer = this.signlink.threadreq(this, 3);
			}
			this.notifyAll();
		}
	}

	public void run() {
		try {
			while (true) {
				label84:
				{
					int var3;
					int var4;
					synchronized (this) {
						if (this.tnum == this.tcyl) {
							if (this.dummy) {
								break label84;
							}
							try {
								this.wait();
							} catch (InterruptedException var13) {
							}
						}
						var3 = this.tcyl;
						if (this.tnum >= this.tcyl) {
							var4 = this.tnum - this.tcyl;
						} else {
							var4 = 5000 - this.tcyl;
						}
					}
					if (var4 <= 0) {
						continue;
					}
					try {
						this.out.write(this.buf, var3, var4);
					} catch (IOException var12) {
						this.ioerror = true;
					}
					this.tcyl = (this.tcyl + var4) % 5000;
					try {
						if (this.tnum == this.tcyl) {
							this.out.flush();
						}
					} catch (IOException var11) {
						this.ioerror = true;
					}
					continue;
				}
				try {
					if (this.in != null) {
						this.in.close();
					}
					if (this.out != null) {
						this.out.close();
					}
					if (this.socket != null) {
						this.socket.close();
					}
				} catch (IOException var10) {
				}
				this.buf = null;
				break;
			}
		} catch (Exception var15) {
			JagException.report(null, (Throwable) var15);
		}
	}
}
