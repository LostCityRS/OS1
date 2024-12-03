package jagex2.client;

import deob.*;
import jagex2.datastruct.*;
import jagex2.graphics.AwtPixMap;
import jagex2.graphics.BufferedPixMap;
import jagex2.graphics.PixMap;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

@ObfuscatedName("dj")
public abstract class GameShell extends Applet implements Runnable, FocusListener, WindowListener {

	@ObfuscatedName("dj.d")
	public static GameShell field1532 = null;

	@ObfuscatedName("dj.l")
	public static int field1533 = 0;

	@ObfuscatedName("dj.m")
	public static long field1550 = 0L;

	@ObfuscatedName("dj.c")
	public static boolean field1545 = false;

	@ObfuscatedName("dj.n")
	public boolean field1531 = false;

	@ObfuscatedName("dj.z")
	public static int field1538 = 20;

	@ObfuscatedName("dj.g")
	public static int field1539 = 1;

	@ObfuscatedName("dj.q")
	public static int field1540 = 0;

	@ObfuscatedName("dj.u")
	public static long[] field1534 = new long[32];

	@ObfuscatedName("dj.w")
	public static long[] field1543 = new long[32];

	@ObfuscatedName("dj.p")
	public static volatile boolean field1536 = true;

	@ObfuscatedName("dj.ac")
	public static int field1547 = 500;

	@ObfuscatedName("dj.aa")
	public static volatile boolean field1548 = false;

	@ObfuscatedName("dj.as")
	public static volatile long field1549 = 0L;

	@ObfuscatedName("dj.am")
	public static volatile boolean field1535 = true;

	@ObfuscatedName("dj.z(IIIB)V")
	public final void method1354(int arg0, int arg1, int arg2) {
		try {
			if (field1532 != null) {
				field1533++;
				if (field1533 >= 3) {
					this.method1372("alreadyloaded");
					return;
				}
				this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
				return;
			}
			field1532 = this;
			Statics.field1544 = arg0;
			Statics.field549 = arg1;
			Statics.field2496 = arg2;
			Statics.field2495 = this;
			if (Statics.field1542 == null) {
				Statics.field1542 = new SignLink();
			}
			Statics.field1542.method437(this, 1);
		} catch (Exception var5) {
			JagException.method1490(null, var5);
			this.method1372("crash");
		}
	}

	@ObfuscatedName("dj.g(I)V")
	public final synchronized void method1391() {
		Container var1;
		if (Statics.field314 == null) {
			var1 = this;
		} else {
			var1 = Statics.field314;
		}
		if (Statics.field54 != null) {
			Statics.field54.removeFocusListener(this);
			var1.remove(Statics.field54);
		}
		Statics.field54 = new GameCanvas(this);
		var1.add(Statics.field54);
		Statics.field54.setSize(Statics.field1544, Statics.field549);
		Statics.field54.setVisible(true);
		if (Statics.field314 == null) {
			Statics.field54.setLocation(0, 0);
		} else {
			Insets var2 = Statics.field314.getInsets();
			Statics.field54.setLocation(var2.left, var2.top);
		}
		Statics.field54.addFocusListener(this);
		Statics.field54.requestFocus();
		field1536 = true;
		field1548 = false;
		field1549 = MonotonicTime.method1135();
	}

	@ObfuscatedName("dj.q(I)Z")
	public final boolean method1367() {
		if (Settings.SKIP_HOST_CHECK) {
			return true;
		}

		String var1 = this.getDocumentBase().getHost().toLowerCase();
		if (var1.equals("jagex.com") || var1.endsWith(".jagex.com")) {
			return true;
		} else if (var1.equals("runescape.com") || var1.endsWith(".runescape.com")) {
			return true;
		} else if (var1.equals("mechscape.com") || var1.endsWith(".mechscape.com")) {
			return true;
		} else if (var1.endsWith("127.0.0.1")) {
			return true;
		} else {
			while (var1.length() > 0 && var1.charAt(var1.length() - 1) >= '0' && var1.charAt(var1.length() - 1) <= '9') {
				var1 = var1.substring(0, var1.length() - 1);
			}
			if (var1.endsWith("192.168.1.")) {
				return true;
			} else {
				this.method1372("invalidhost");
				return false;
			}
		}
	}

	public void run() {
		try {
			if (Statics.field380 != null) {
				String var1 = Statics.field380.toLowerCase();
				if (var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
					String var2 = Statics.field375;
					if (var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
						this.method1372("wrongjava");
						return;
					}
					if (var2.startsWith("1.6.0_")) {
						int var3;
						for (var3 = 6; var3 < var2.length(); var3++) {
							char var4 = var2.charAt(var3);
							boolean var5 = var4 >= '0' && var4 <= '9';
							if (!var5) {
								break;
							}
						}
						String var6 = var2.substring(6, var3);
						if (JStringUtil.method62(var6)) {
							int var7 = JStringUtil.method91(var6, 10, true);
							if (var7 < 10) {
								this.method1372("wrongjava");
								return;
							}
						}
					}
					field1539 = 5;
				}
			}
			this.setFocusCycleRoot(true);
			this.method1391();
			int var8 = Statics.field1544;
			int var9 = Statics.field549;
			Canvas var10 = Statics.field54;
			PixMap var12;
			try {
				BufferedPixMap var11 = new BufferedPixMap();
				var11.method548(var8, var9, var10);
				var12 = var11;
			} catch (Throwable var23) {
				AwtPixMap var14 = new AwtPixMap();
				var14.method548(var8, var9, var10);
				var12 = var14;
			}
			Statics.field1546 = var12;
			this.method1368();
			Timer var15;
			try {
				var15 = new NanoTimer();
			} catch (Throwable var22) {
				var15 = new MillisTimer();
			}
			Statics.field1100 = var15;
			label99: while (true) {
				SignLink var18;
				Canvas var19;
				do {
					if (field1550 != 0L && MonotonicTime.method1135() >= field1550) {
						break label99;
					}
					Statics.field1537 = Statics.field1100.method380(field1538, field1539);
					for (int var17 = 0; var17 < Statics.field1537; var17++) {
						this.method1357();
					}
					this.method1358();
					var18 = Statics.field1542;
					var19 = Statics.field54;
				} while (var18.field381 == null);
				for (int var20 = 0; var20 < 50 && var18.field381.peekEvent() != null; var20++) {
					PreciseSleep.method1020(1L);
				}
				if (var19 != null) {
					var18.field381.postEvent(new ActionEvent(var19, 1001, "dummy"));
				}
			}
		} catch (Exception var24) {
			JagException.method1490(null, var24);
			this.method1372("crash");
		}
		this.method1382();
	}

	@ObfuscatedName("dj.i(I)V")
	public void method1357() {
		long var1 = MonotonicTime.method1135();
		long var3 = field1543[Statics.field1218];
		field1543[Statics.field1218] = var1;
		Statics.field1218 = Statics.field1218 + 1 & 0x1F;
		if (var3 != 0L && var1 > var3) {
		}
		synchronized (this) {
			Statics.field125 = field1535;
		}
		this.method1369();
	}

	@ObfuscatedName("dj.s(I)V")
	public void method1358() {
		long var1 = MonotonicTime.method1135();
		long var3 = field1534[Statics.field833];
		field1534[Statics.field833] = var1;
		Statics.field833 = Statics.field833 + 1 & 0x1F;
		if (var3 != 0L && var1 > var3) {
			int var5 = (int) (var1 - var3);
			field1540 = ((var5 >> 1) + 32000) / var5;
		}
		if (++field1547 - 1 > 50) {
			field1547 -= 50;
			field1536 = true;
			Statics.field54.setSize(Statics.field1544, Statics.field549);
			Statics.field54.setVisible(true);
			if (Statics.field314 == null) {
				Statics.field54.setLocation(0, 0);
			} else {
				Insets var6 = Statics.field314.getInsets();
				Statics.field54.setLocation(var6.left, var6.top);
			}
		}
		this.method1414();
	}

	@ObfuscatedName("dj.u(I)V")
	public final synchronized void method1382() {
		if (field1545) {
			return;
		}
		field1545 = true;
		try {
			Statics.field54.removeFocusListener(this);
		} catch (Exception var8) {
		}
		try {
			this.method1361();
		} catch (Exception var7) {
		}
		if (Statics.field314 != null) {
			try {
				System.exit(0);
			} catch (Throwable var6) {
			}
		}
		if (Statics.field1542 != null) {
			try {
				Statics.field1542.method436();
			} catch (Exception var5) {
			}
		}
		this.method1373();
	}

	@ObfuscatedName("bk.v(B)V")
	public static final void method770() {
		Statics.field1100.method381();
		for (int var0 = 0; var0 < 32; var0++) {
			field1534[var0] = 0L;
		}
		for (int var1 = 0; var1 < 32; var1++) {
			field1543[var1] = 0L;
		}
		Statics.field1537 = 0;
	}

	public void start() {
		if (field1532 == this && !field1545) {
			field1550 = 0L;
		}
	}

	public void stop() {
		if (field1532 == this && !field1545) {
			field1550 = MonotonicTime.method1135() + 4000L;
		}
	}

	public void destroy() {
		if (field1532 == this && !field1545) {
			field1550 = MonotonicTime.method1135();
			PreciseSleep.method1020(5000L);
			this.method1382();
		}
	}

	public final void update(Graphics arg0) {
		this.paint(arg0);
	}

	public final synchronized void paint(Graphics arg0) {
		if (field1532 != this || field1545) {
			return;
		}
		field1536 = true;
		if (Statics.field375 != null && Statics.field375.startsWith("1.5") && MonotonicTime.method1135() - field1549 > 1000L) {
			Rectangle var2 = arg0.getClipBounds();
			if (var2 == null || var2.width >= Statics.field1544 && var2.height >= Statics.field549) {
				field1548 = true;
			}
		}
	}

	public final void focusGained(FocusEvent arg0) {
		field1535 = true;
		field1536 = true;
	}

	public final void focusLost(FocusEvent arg0) {
		field1535 = false;
	}

	public final void windowActivated(WindowEvent arg0) {
	}

	public final void windowClosed(WindowEvent arg0) {
	}

	public final void windowClosing(WindowEvent arg0) {
		this.destroy();
	}

	public final void windowDeactivated(WindowEvent arg0) {
	}

	public final void windowDeiconified(WindowEvent arg0) {
	}

	public final void windowIconified(WindowEvent arg0) {
	}

	public final void windowOpened(WindowEvent arg0) {
	}

	@ObfuscatedName("dj.t(Ljava/lang/String;I)V")
	public void method1372(String arg0) {
		if (this.field1531) {
			return;
		}
		this.field1531 = true;
		System.out.println("error_game_" + arg0);
		try {
			this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + arg0 + ".ws"), "_self");
		} catch (Exception var3) {
		}
	}

	@ObfuscatedName("dj.y(B)V")
	public abstract void method1361();

	@ObfuscatedName("dj.w(I)V")
	public abstract void method1368();

	@ObfuscatedName("dj.e(B)V")
	public abstract void method1369();

	@ObfuscatedName("dj.f(I)V")
	public abstract void method1373();

	public abstract void init();

	@ObfuscatedName("dj.b(I)V")
	public abstract void method1414();
}
