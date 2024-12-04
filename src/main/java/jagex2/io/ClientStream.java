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
	public InputStream in;

	@ObfuscatedName("am.d")
	public OutputStream out;

	@ObfuscatedName("am.l")
	public Socket socket;

	@ObfuscatedName("am.m")
	public boolean dummy = false; // name comes from a debug method in 317

	@ObfuscatedName("am.c")
	public SignLink signlink;

	@ObfuscatedName("am.n")
	public PrivilegedRequest writer;

	@ObfuscatedName("am.j")
	public byte[] buf;

	@ObfuscatedName("am.z")
	public int tcyl = 0; // name comes from a debug method in 317

	@ObfuscatedName("am.g")
	public int tnum = 0; // name comes from a debug method in 317

	@ObfuscatedName("am.q")
	public boolean ioerror = false; // name comes from a debug method in 317

	public ClientStream(Socket socket, SignLink signlink) throws IOException {
		this.signlink = signlink;
		this.socket = socket;
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
			while (this.writer.field507 == 0) {
				PreciseSleep.sleep(1L);
			}

			if (this.writer.field507 == 1) {
				try {
					((Thread) this.writer.field511).join();
				} catch (InterruptedException ignore) {
				}
			}
		}

		this.writer = null;
	}

	protected void finalize() {
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
	public void read(byte[] dest, int off, int len) throws IOException {
		if (this.dummy) {
			return;
		}

		while (len > 0) {
			int read = this.in.read(dest, off, len);
			if (read <= 0) {
				throw new EOFException();
			}

			off += read;
			len -= read;
		}
	}

	@ObfuscatedName("am.z([BIII)V")
	public void write(byte[] src, int off, int len) throws IOException {
		if (this.dummy) {
			return;
		}

		if (this.ioerror) {
			this.ioerror = false;
			throw new IOException("Error in writer thread");
		}

		if (this.buf == null) {
			this.buf = new byte[5000];
		}

		synchronized (this) {
			for (int i = 0; i < len; i++) {
				this.buf[this.tnum] = src[off + i];
				this.tnum = (this.tnum + 1) % 5000;

				if (this.tnum == (this.tcyl + 4900) % 5000) {
					throw new IOException("buffer overflow");
				}
			}

			if (this.writer == null) {
				this.writer = this.signlink.startThread(this, 3);
			}

			this.notifyAll();
		}
	}

	public void run() {
		try {
			while (true) {
				loop: {
					int off;
					int available;
					synchronized (this) {
						if (this.tnum == this.tcyl) {
							if (this.dummy) {
								break loop;
							}

							try {
								this.wait();
							} catch (InterruptedException ignore) {
							}
						}

						off = this.tcyl;
						if (this.tnum >= this.tcyl) {
							available = this.tnum - this.tcyl;
						} else {
							available = 5000 - this.tcyl;
						}
					}

                    if (available > 0) {
                        try {
                            this.out.write(this.buf, off, available);
                        } catch (IOException ignore) {
                            this.ioerror = true;
                        }

                        this.tcyl = (this.tcyl + available) % 5000;

                        try {
                            if (this.tnum == this.tcyl) {
                                this.out.flush();
                            }
                        } catch (IOException ignore) {
                            this.ioerror = true;
                        }
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
				} catch (IOException ignore) {
				}

				this.buf = null;
				break;
			}
		} catch (Exception ex) {
			JagException.report(null, ex);
		}
	}
}
