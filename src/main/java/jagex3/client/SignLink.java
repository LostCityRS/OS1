package jagex3.client;

import deob.ObfuscatedName;
import jagex3.datastruct.PreciseSleep;
import jagex3.sound.AudioSource;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

@ObfuscatedName("ak")
public class SignLink implements Runnable {

	@ObfuscatedName("ak.r")
	public static String javaVendor;

	@ObfuscatedName("ak.d")
	public static String javaVersion;

	@ObfuscatedName("ak.l")
	public AudioSource field376;

	@ObfuscatedName("ak.m")
	public PrivilegedRequest current = null;

	@ObfuscatedName("ak.c")
	public PrivilegedRequest task = null;

	@ObfuscatedName("ak.n")
	public Thread thread;

	@ObfuscatedName("ak.j")
	public boolean isClosed = false;

	@ObfuscatedName("ak.z")
	public EventQueue eventQueue;

	public SignLink() {
		javaVendor = "Unknown";
		javaVersion = "1.1";
		try {
			javaVendor = System.getProperty("java.vendor");
			javaVersion = System.getProperty("java.version");
		} catch (Exception var4) {
		}
		try {
			this.eventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable var3) {
		}
		this.isClosed = false;
		this.thread = new Thread(this);
		this.thread.setPriority(10);
		this.thread.setDaemon(true);
		this.thread.start();
	}

	@ObfuscatedName("ak.m(B)V")
	public final void close() {
		synchronized (this) {
			this.isClosed = true;
			this.notifyAll();
		}
		try {
			this.thread.join();
		} catch (InterruptedException var4) {
		}
	}

	public final void run() {
		while (true) {
			PrivilegedRequest req;
			synchronized (this) {
				while (true) {
					if (this.isClosed) {
						return;
					}
					if (this.current != null) {
						req = this.current;
						this.current = this.current.next;
						if (this.current == null) {
							this.task = null;
						}
						break;
					}
					try {
						this.wait();
					} catch (InterruptedException var12) {
					}
				}
			}
			try {
				int type = req.type;
				if (type == 1) {
					req.result = new Socket(InetAddress.getByName((String) req.objArg), req.intArg);
				} else if (type == 2) {
					Thread var6 = new Thread((Runnable) req.objArg);
					var6.setDaemon(true);
					var6.start();
					var6.setPriority(req.intArg);
					req.result = var6;
				} else if (type == 4) {
					req.result = new DataInputStream(((URL) req.objArg).openStream());
				} else if (type == 3) {
					String var7 = (req.intArg >> 24 & 0xFF) + "." + (req.intArg >> 16 & 0xFF) + "." + (req.intArg >> 8 & 0xFF) + "." + (req.intArg & 0xFF);
					req.result = InetAddress.getByName(var7).getHostName();
				}
				req.status = 1;
			} catch (ThreadDeath var10) {
				throw var10;
			} catch (Throwable var11) {
				req.status = 2;
			}
		}
	}

	@ObfuscatedName("ak.c(IIILjava/lang/Object;S)Lah;")
	public final PrivilegedRequest newRequest(int arg0, int arg1, int arg2, Object arg3) {
		PrivilegedRequest var5 = new PrivilegedRequest();
		var5.type = arg0;
		var5.intArg = arg1;
		var5.objArg = arg3;
		synchronized (this) {
			if (this.task == null) {
				this.task = this.current = var5;
			} else {
				this.task.next = var5;
				this.task = var5;
			}
			this.notify();
			return var5;
		}
	}

	@ObfuscatedName("ak.n(Ljava/lang/String;IB)Lah;")
	public final PrivilegedRequest socketreq(String arg0, int arg1) {
		System.out.println("socketreq " + arg0 + ":" + arg1);
		return this.newRequest(1, arg1, 0, arg0);
	}

	@ObfuscatedName("ak.j(Ljava/lang/Runnable;II)Lah;")
	public final PrivilegedRequest threadreq(Runnable arg0, int arg1) {
		return this.newRequest(2, arg1, 0, arg0);
	}

	@ObfuscatedName("ak.z(II)Lah;")
	public final PrivilegedRequest dnsreq(int arg0) {
		return this.newRequest(3, arg0, 0, null);
	}

	@ObfuscatedName("ak.g(Ljava/net/URL;I)Lah;")
	public final PrivilegedRequest urlreq(URL arg0) {
		return this.newRequest(4, 0, 0, arg0);
	}

	@ObfuscatedName("ak.q(I)Lw;")
	public final AudioSource method440() {
		return this.field376;
	}

	public static void flushEvents(SignLink handler, Object source) {
		if (handler.eventQueue == null) {
			return;
		}

		for (int i = 0; i < 50 && handler.eventQueue.peekEvent() != null; i++) {
			PreciseSleep.sleep(1L);
		}

		if (source != null) {
			handler.eventQueue.postEvent(new ActionEvent(source, 1001, "dummy"));
		}
	}
}
