package jagex2.client;

import deob.ObfuscatedName;
import deob.Settings;
import jagex2.datastruct.time.*;
import jagex2.graphics.AwtPixMap;
import jagex2.graphics.BufferedPixMap;
import jagex2.graphics.PixMap;
import jagex2.jstring.StringUtil;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

@ObfuscatedName("dj")
public abstract class GameShell extends Applet implements Runnable, FocusListener, WindowListener {

	@ObfuscatedName("dj.r")
	public static SignLink signlink;

	@ObfuscatedName("dj.d")
	public static GameShell shell = null;

	@ObfuscatedName("dj.l")
	public static int field1533 = 0;

	@ObfuscatedName("dj.m")
	public static long killtime = 0L;

	@ObfuscatedName("dj.c")
	public static boolean alreadyshutdown = false;

	@ObfuscatedName("dj.n")
	public boolean alreadyerrored = false;

	@ObfuscatedName("dj.j")
	public static int field1537;

	@ObfuscatedName("dj.z")
	public static int field1538 = 20;

	@ObfuscatedName("dj.g")
	public static int field1539 = 1;

	@ObfuscatedName("dj.q")
	public static int field1540 = 0;

	@ObfuscatedName("bc.i")
	public static Timer field1100;

	@ObfuscatedName("dj.u")
	public static long[] field1534 = new long[32];

	@ObfuscatedName("bm.v")
	public static int field833;

	@ObfuscatedName("dj.w")
	public static long[] field1543 = new long[32];

	@ObfuscatedName("cv.e")
	public static int field1218;

	@ObfuscatedName("dj.b")
	public static int canvasWid;

	@ObfuscatedName("ao.t")
	public static int canvasHei;

	@ObfuscatedName("ca.f")
	public static Font field1159;

	@ObfuscatedName("fr.k")
	public static FontMetrics field2489;

	@ObfuscatedName("dj.o")
	public static PixMap drawArea;

	@ObfuscatedName("a.a")
	public static Frame frame;

	@ObfuscatedName("c.h")
	public static Canvas canvas;

	@ObfuscatedName("dj.p")
	public static volatile boolean fullredraw = true;

	@ObfuscatedName("dj.ac")
	public static int field1547 = 500;

	@ObfuscatedName("dj.aa")
	public static volatile boolean canvasReplaceRecommended = false;

	@ObfuscatedName("dj.as")
	public static volatile long lastCanvasReplace = 0L;

	@ObfuscatedName("dj.am")
	public static volatile boolean focus_in = true;

	@ObfuscatedName("z.ap")
	public static boolean focus;

	protected final void initApplication(int width, int height, int revision) {
		frame = new Frame();
		frame.setTitle("Jagex");
		frame.setResizable(false);
		frame.setBackground(Color.BLACK);
		frame.addWindowListener(this);
		frame.setVisible(true);
		frame.toFront();
		Insets insets = frame.getInsets();
		frame.setSize(width + insets.left + insets.right, height + insets.top + insets.bottom);

		this.init();
	}

	@ObfuscatedName("dj.z(IIIB)V")
	public final void method1354(int arg0, int arg1, int arg2) {
		try {
			if (shell != null) {
				field1533++;
				if (field1533 >= 3) {
					this.error("alreadyloaded");
					return;
				}
				this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
				return;
			}
			shell = this;
			canvasWid = arg0;
			canvasHei = arg1;
			JagException.revision = arg2;
			JagException.applet = this;
			if (signlink == null) {
				signlink = new SignLink();
			}
			signlink.startThread(this, 1);
		} catch (Exception var5) {
			JagException.report(null, var5);
			this.error("crash");
		}
	}

	@ObfuscatedName("dj.g(I)V")
	public final synchronized void addcanvas() {
		Container var1;
		if (frame == null) {
			var1 = this;
		} else {
			var1 = frame;
		}
		if (canvas != null) {
			canvas.removeFocusListener(this);
			var1.remove(canvas);
		}
		canvas = new GameCanvas(this);
		var1.add(canvas);
		canvas.setSize(canvasWid, canvasHei);
		canvas.setVisible(true);
		if (frame == null) {
			canvas.setLocation(0, 0);
		} else {
			Insets var2 = frame.getInsets();
			canvas.setLocation(var2.left, var2.top);
		}
		canvas.addFocusListener(this);
		canvas.requestFocus();
		fullredraw = true;
		canvasReplaceRecommended = false;
		lastCanvasReplace = MonotonicTime.method1135();
	}

	@ObfuscatedName("dj.q(I)Z")
	public final boolean checkhost() {
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
				this.error("invalidhost");
				return false;
			}
		}
	}

	public void run() {
		try {
			if (SignLink.javaVendor != null) {
				String var1 = SignLink.javaVendor.toLowerCase();
				if (var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
					String var2 = SignLink.javaVersion;
					if (var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
						this.error("wrongjava");
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
						if (StringUtil.method62(var6)) {
							int var7 = StringUtil.method91(var6, 10, true);
							if (var7 < 10) {
								this.error("wrongjava");
								return;
							}
						}
					}
					field1539 = 5;
				}
			}
			this.setFocusCycleRoot(true);
			this.addcanvas();
			int var8 = canvasWid;
			int var9 = canvasHei;
			Canvas var10 = canvas;
			PixMap var12;
			try {
				BufferedPixMap var11 = new BufferedPixMap();
				var11.create(var8, var9, var10);
				var12 = var11;
			} catch (Throwable var23) {
				AwtPixMap var14 = new AwtPixMap();
				var14.create(var8, var9, var10);
				var12 = var14;
			}
			drawArea = var12;
			this.maininit();
			Timer var15;
			try {
				var15 = new NanoTimer();
			} catch (Throwable var22) {
				var15 = new MillisTimer();
			}
			field1100 = var15;
			label99: while (true) {
				SignLink var18;
				Canvas var19;
				do {
					if (killtime != 0L && MonotonicTime.method1135() >= killtime) {
						break label99;
					}
					field1537 = field1100.method380(field1538, field1539);
					for (int var17 = 0; var17 < field1537; var17++) {
						this.mainloopwrapper();
					}
					this.mainredrawwrapper();
					var18 = signlink;
					var19 = canvas;
				} while (var18.field381 == null);
				for (int var20 = 0; var20 < 50 && var18.field381.peekEvent() != null; var20++) {
					PreciseSleep.sleep(1L);
				}
				if (var19 != null) {
					var18.field381.postEvent(new ActionEvent(var19, 1001, "dummy"));
				}
			}
		} catch (Exception var24) {
			JagException.report(null, (Throwable) var24);
			this.error("crash");
		}
		this.shutdown();
	}

	@ObfuscatedName("dj.i(I)V")
	public void mainloopwrapper() {
		long var1 = MonotonicTime.method1135();
		long var3 = field1543[field1218];
		field1543[field1218] = var1;
		field1218 = field1218 + 1 & 0x1F;
		if (var3 != 0L && var1 > var3) {
		}
		synchronized (this) {
			focus = focus_in;
		}
		this.mainloop();
	}

	@ObfuscatedName("dj.s(I)V")
	public void mainredrawwrapper() {
		long var1 = MonotonicTime.method1135();
		long var3 = field1534[field833];
		field1534[field833] = var1;
		field833 = field833 + 1 & 0x1F;
		if (var3 != 0L && var1 > var3) {
			int var5 = (int) (var1 - var3);
			field1540 = ((var5 >> 1) + 32000) / var5;
		}
		if (++field1547 - 1 > 50) {
			field1547 -= 50;
			fullredraw = true;
			canvas.setSize(canvasWid, canvasHei);
			canvas.setVisible(true);
			if (frame == null) {
				canvas.setLocation(0, 0);
			} else {
				Insets var6 = frame.getInsets();
				canvas.setLocation(var6.left, var6.top);
			}
		}
		this.mainredraw();
	}

	@ObfuscatedName("dj.u(I)V")
	public final synchronized void shutdown() {
		if (alreadyshutdown) {
			return;
		}
		alreadyshutdown = true;
		try {
			canvas.removeFocusListener(this);
		} catch (Exception var8) {
		}
		try {
			this.mainquit();
		} catch (Exception var7) {
		}
		if (frame != null) {
			try {
				System.exit(0);
			} catch (Throwable var6) {
			}
		}
		if (signlink != null) {
			try {
				signlink.method436();
			} catch (Exception var5) {
			}
		}
		this.method1373();
	}

	@ObfuscatedName("bk.v(B)V")
	public static final void method770() {
		field1100.method381();
		for (int var0 = 0; var0 < 32; var0++) {
			field1534[var0] = 0L;
		}
		for (int var1 = 0; var1 < 32; var1++) {
			field1543[var1] = 0L;
		}
		field1537 = 0;
	}

	public void start() {
		if (shell == this && !alreadyshutdown) {
			killtime = 0L;
		}
	}

	public void stop() {
		if (shell == this && !alreadyshutdown) {
			killtime = MonotonicTime.method1135() + 4000L;
		}
	}

	public void destroy() {
		if (shell == this && !alreadyshutdown) {
			killtime = MonotonicTime.method1135();
			PreciseSleep.sleep(5000L);
			this.shutdown();
		}
	}

	public final void update(Graphics arg0) {
		this.paint(arg0);
	}

	public final synchronized void paint(Graphics arg0) {
		if (shell != this || alreadyshutdown) {
			return;
		}
		fullredraw = true;
		if (SignLink.javaVersion != null && SignLink.javaVersion.startsWith("1.5") && MonotonicTime.method1135() - lastCanvasReplace > 1000L) {
			Rectangle var2 = arg0.getClipBounds();
			if (var2 == null || var2.width >= canvasWid && var2.height >= canvasHei) {
				canvasReplaceRecommended = true;
			}
		}
	}

	public final void focusGained(FocusEvent arg0) {
		focus_in = true;
		fullredraw = true;
	}

	public final void focusLost(FocusEvent arg0) {
		focus_in = false;
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
	public void error(String arg0) {
		if (this.alreadyerrored) {
			return;
		}
		this.alreadyerrored = true;
		System.out.println("error_game_" + arg0);
		try {
			this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + arg0 + ".ws"), "_self");
		} catch (Exception var3) {
		}
	}

	@ObfuscatedName("dj.y(B)V")
	public abstract void mainquit();

	@ObfuscatedName("dj.w(I)V")
	public abstract void maininit();

	@ObfuscatedName("dj.e(B)V")
	public abstract void mainloop();

	@ObfuscatedName("dj.f(I)V")
	public abstract void method1373();

	public abstract void init();

	@ObfuscatedName("dj.b(I)V")
	public abstract void mainredraw();

	public static void imethod1(int var3, String var4, Color var5) {
		try {
			Graphics var6 = GameShell.canvas.getGraphics();
			if (GameShell.field1159 == null) {
				GameShell.field1159 = new Font("Helvetica", Font.BOLD, 13);
				GameShell.field2489 = GameShell.canvas.getFontMetrics(GameShell.field1159);
			}
			if (fullredraw) {
				fullredraw = false;
				var6.setColor(Color.black);
				var6.fillRect(0, 0, GameShell.canvasWid, GameShell.canvasHei);
			}
			if (var5 == null) {
				var5 = new Color(140, 17, 17);
			}
			try {
				if (Client.progressBar == null) {
					Client.progressBar = GameShell.canvas.createImage(304, 34);
				}
				Graphics var7 = Client.progressBar.getGraphics();
				var7.setColor(var5);
				var7.drawRect(0, 0, 303, 33);
				var7.fillRect(2, 2, var3 * 3, 30);
				var7.setColor(Color.black);
				var7.drawRect(1, 1, 301, 31);
				var7.fillRect(var3 * 3 + 2, 2, 300 - var3 * 3, 30);
				var7.setFont(GameShell.field1159);
				var7.setColor(Color.white);
				var7.drawString(var4, (304 - GameShell.field2489.stringWidth(var4)) / 2, 22);
				var6.drawImage(Client.progressBar, GameShell.canvasWid / 2 - 152, GameShell.canvasHei / 2 - 18, null);
			} catch (Exception var49) {
				int var9 = GameShell.canvasWid / 2 - 152;
				int var10 = GameShell.canvasHei / 2 - 18;
				var6.setColor(var5);
				var6.drawRect(var9, var10, 303, 33);
				var6.fillRect(var9 + 2, var10 + 2, var3 * 3, 30);
				var6.setColor(Color.black);
				var6.drawRect(var9 + 1, var10 + 1, 301, 31);
				var6.fillRect(var3 * 3 + var9 + 2, var10 + 2, 300 - var3 * 3, 30);
				var6.setFont(GameShell.field1159);
				var6.setColor(Color.white);
				var6.drawString(var4, var9 + (304 - GameShell.field2489.stringWidth(var4)) / 2, var10 + 22);
			}
		} catch (Exception var50) {
			GameShell.canvas.repaint();
		}
	}

	public static void imethod2() {
		Client.progressBar = null;
		GameShell.field1159 = null;
		GameShell.field2489 = null;
	}
}
