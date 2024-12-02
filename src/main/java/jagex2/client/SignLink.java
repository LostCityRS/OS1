package jagex2.client;

import deob.ObfuscatedName;
import deob.Statics;
import jagex2.sound.AudioSource;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

@ObfuscatedName("ak")
public class SignLink implements Runnable {

	@ObfuscatedName("ak.l")
	public AudioSource field376;

	@ObfuscatedName("ak.m")
	public PrivilegedRequest field374 = null;

	@ObfuscatedName("ak.c")
	public PrivilegedRequest field378 = null;

	@ObfuscatedName("ak.n")
	public Thread field379;

	@ObfuscatedName("ak.j")
	public boolean field377 = false;

	@ObfuscatedName("ak.z")
	public EventQueue field381;

	public SignLink() {
		Statics.field380 = "Unknown";
		Statics.field375 = "1.1";
		try {
			Statics.field380 = System.getProperty("java.vendor");
			Statics.field375 = System.getProperty("java.version");
		} catch (Exception var4) {
		}
		try {
			this.field381 = Toolkit.getDefaultToolkit().getSystemEventQueue();
		} catch (Throwable var3) {
		}
		this.field377 = false;
		this.field379 = new Thread(this);
		this.field379.setPriority(10);
		this.field379.setDaemon(true);
		this.field379.start();
	}

	@ObfuscatedName("ak.m(B)V")
	public final void method436() {
		synchronized (this) {
			this.field377 = true;
			this.notifyAll();
		}
		try {
			this.field379.join();
		} catch (InterruptedException var4) {
		}
	}

	public final void run() {
		while (true) {
			PrivilegedRequest var2;
			synchronized (this) {
				while (true) {
					if (this.field377) {
						return;
					}
					if (this.field374 != null) {
						var2 = this.field374;
						this.field374 = this.field374.field509;
						if (this.field374 == null) {
							this.field378 = null;
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
				int var5 = var2.field503;
				if (var5 == 1) {
					var2.field511 = new Socket(InetAddress.getByName((String) var2.field510), var2.field508);
				} else if (var5 == 2) {
					Thread var6 = new Thread((Runnable) var2.field510);
					var6.setDaemon(true);
					var6.start();
					var6.setPriority(var2.field508);
					var2.field511 = var6;
				} else if (var5 == 4) {
					var2.field511 = new DataInputStream(((URL) var2.field510).openStream());
				} else if (var5 == 3) {
					String var7 = (var2.field508 >> 24 & 0xFF) + "." + (var2.field508 >> 16 & 0xFF) + "." + (var2.field508 >> 8 & 0xFF) + "." + (var2.field508 & 0xFF);
					var2.field511 = InetAddress.getByName(var7).getHostName();
				}
				var2.field507 = 1;
			} catch (ThreadDeath var10) {
				throw var10;
			} catch (Throwable var11) {
				var2.field507 = 2;
			}
		}
	}

	@ObfuscatedName("ak.c(IIILjava/lang/Object;S)Lah;")
	public final PrivilegedRequest method435(int arg0, int arg1, int arg2, Object arg3) {
		PrivilegedRequest var5 = new PrivilegedRequest();
		var5.field503 = arg0;
		var5.field508 = arg1;
		var5.field510 = arg3;
		synchronized (this) {
			if (this.field378 == null) {
				this.field378 = this.field374 = var5;
			} else {
				this.field378.field509 = var5;
				this.field378 = var5;
			}
			this.notify();
			return var5;
		}
	}

	@ObfuscatedName("ak.n(Ljava/lang/String;IB)Lah;")
	public final PrivilegedRequest method451(String arg0, int arg1) {
		return this.method435(1, arg1, 0, arg0);
	}

	@ObfuscatedName("ak.j(Ljava/lang/Runnable;II)Lah;")
	public final PrivilegedRequest method437(Runnable arg0, int arg1) {
		return this.method435(2, arg1, 0, arg0);
	}

	@ObfuscatedName("ak.z(II)Lah;")
	public final PrivilegedRequest method438(int arg0) {
		return this.method435(3, arg0, 0, null);
	}

	@ObfuscatedName("ak.g(Ljava/net/URL;I)Lah;")
	public final PrivilegedRequest method445(URL arg0) {
		return this.method435(4, 0, 0, arg0);
	}

	@ObfuscatedName("ak.q(I)Lw;")
	public final AudioSource method440() {
		return this.field376;
	}
}
