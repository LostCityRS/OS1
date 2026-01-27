package jagex3.client.applet;

import deob.ObfuscatedName;
import deob.Settings;
import jagex3.client.JagException;
import jagex3.client.SignLink;
import jagex3.datastruct.*;
import jagex3.graphics.JavaPixMap;
import jagex3.graphics.JavaSafePixMap;
import jagex3.graphics.PixMap;
import jagex3.jstring.StringTools;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;

@ObfuscatedName("dj")
public abstract class GameShell extends Applet implements Runnable, FocusListener, WindowListener {

	@ObfuscatedName("dj.r")
	public static SignLink signLink;

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

	// jag::oldscape::javapal::GameShell::m_updateCount
	@ObfuscatedName("dj.j")
	public static int updateCount;

	@ObfuscatedName("dj.z")
	public static int deltime = 20;

	@ObfuscatedName("dj.g")
	public static int mindel = 1;

	@ObfuscatedName("dj.q")
	public static int fps = 0;

	@ObfuscatedName("bc.i")
	public static Timer timer;

	// jag::oldscape::javapal::GameShell::m_drawTime
	@ObfuscatedName("dj.u")
	public static long[] drawTime = new long[32];

	@ObfuscatedName("bm.v")
	public static int field833;

	// jag::oldscape::javapal::GameShell::m_updateTime
	@ObfuscatedName("dj.w")
	public static long[] updateTime = new long[32];

	@ObfuscatedName("cv.e")
	public static int field1218;

	@ObfuscatedName("dj.b")
	public static int canvasWid;

	@ObfuscatedName("ao.t")
	public static int canvasHei;

	@ObfuscatedName("cd.ad")
	public static Image progressBar;

	@ObfuscatedName("ca.f")
	public static Font progressFont;

	@ObfuscatedName("fr.k")
	public static FontMetrics progressFontMetrics;

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

	// com.jagex.game.runetek6.client.GameShell3.startApplication
	public final void startApplication(int width, int height, int revision) {
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

	// com.jagex.game.runetek6.client.GameShell3.startCommon
	@ObfuscatedName("dj.z(IIIB)V")
	public final void startCommon(int arg0, int arg1, int arg2) {
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

			if (signLink == null) {
				signLink = new SignLink();
			}
			signLink.threadreq(this, 1);
		} catch (Exception ex) {
			JagException.report(null, ex);
			this.error("crash");
		}
	}

	// com.jagex.game.runetek6.client.GameShell3.addcanvas
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
		if (frame != null) {
			Insets var2 = frame.getInsets();
			canvas.setLocation(var2.left, var2.top);
		} else {
			canvas.setLocation(0, 0);
		}
		canvas.addFocusListener(this);
		canvas.requestFocus();
		fullredraw = true;
		canvasReplaceRecommended = false;
		lastCanvasReplace = MonotonicTime.currentTime();
	}

	// com.jagex.game.runetek6.client.GameShell3.checkhost
	@ObfuscatedName("dj.q(I)Z")
	public final boolean checkhost() {
		if (Settings.NO_HOST_CHECK) {
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

	@Override
	public void run() {
		try {
			if (SignLink.javaVendor != null) {
				String vendor = SignLink.javaVendor.toLowerCase();

				if (vendor.indexOf("sun") != -1 || vendor.indexOf("apple") != -1) {
					String version = SignLink.javaVersion;

					if (version.equals("1.1") || version.startsWith("1.1.") || version.equals("1.2") || version.startsWith("1.2.") || version.equals("1.3") || version.startsWith("1.3.") || version.equals("1.4") || version.startsWith("1.4.") || version.equals("1.5") || version.startsWith("1.5.") || version.equals("1.6.0")) {
						this.error("wrongjava");
						return;
					}

					if (version.startsWith("1.6.0_")) {
						int var3;
						for (var3 = 6; var3 < version.length(); var3++) {
							char var4 = version.charAt(var3);
							boolean var5 = var4 >= '0' && var4 <= '9';
							if (!var5) {
								break;
							}
						}

						String var6 = version.substring(6, var3);
						if (StringTools.isInt(var6)) {
							int var7 = StringTools.checkedParseInt(var6, 10, true);
							if (var7 < 10) {
								this.error("wrongjava");
								return;
							}
						}
					}

					mindel = 5;
				}
			}

			this.setFocusCycleRoot(true);
			this.addcanvas();

			int wid = canvasWid;
			int hei = canvasHei;
			Canvas target = canvas;
			PixMap newDrawArea;
			try {
				JavaPixMap pix = new JavaPixMap();
				pix.create(wid, hei, target);
				newDrawArea = pix;
			} catch (Throwable var23) {
				JavaSafePixMap pix = new JavaSafePixMap();
				pix.create(wid, hei, target);
				newDrawArea = pix;
			}
			drawArea = newDrawArea;

			this.maininit();

			Timer newTimer;
			try {
				newTimer = new NanoTimer();
			} catch (Throwable ex) {
				newTimer = new MillisTimer();
			}
			timer = newTimer;

			while (killtime == 0L || MonotonicTime.currentTime() < killtime) {
				updateCount = timer.count(deltime, mindel);

				for (int i = 0; i < updateCount; i++) {
					this.mainloopwrapper();
				}

				this.mainredrawwrapper();

				SignLink.flushEvents(signLink, canvas);
			}
		} catch (Exception ex) {
			JagException.report(null, ex);
			this.error("crash");
		}

		this.shutdown();
	}

	// com.jagex.game.runetek6.client.GameShell3.mainloopwrapper
	@ObfuscatedName("dj.i(I)V")
	public void mainloopwrapper() {
		long var1 = MonotonicTime.currentTime();
		long var3 = updateTime[field1218];
		updateTime[field1218] = var1;
		field1218 = field1218 + 1 & 0x1F;

		if (var3 != 0L && var1 > var3) {
			// lps
		}

		synchronized (this) {
			focus = focus_in;
		}

		this.mainloop();
	}

	// com.jagex.game.runetek6.client.GameShell3.mainredrawwrapper
	@ObfuscatedName("dj.s(I)V")
	public void mainredrawwrapper() {
		long var1 = MonotonicTime.currentTime();
		long var3 = drawTime[field833];
		drawTime[field833] = var1;
		field833 = field833 + 1 & 0x1F;

		if (var3 != 0L && var1 > var3) {
			int var5 = (int) (var1 - var3);
			fps = ((var5 >> 1) + 32000) / var5;
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

	// com.jagex.game.runetek6.client.GameShell3.shutdown
	@ObfuscatedName("dj.u(I)V")
	public final synchronized void shutdown() {
		if (alreadyshutdown) {
			return;
		}

		alreadyshutdown = true;

		try {
			canvas.removeFocusListener(this);
		} catch (Exception ignore) {
		}

		try {
			this.mainquit();
		} catch (Exception ignore) {
		}

		if (frame != null) {
			try {
				System.exit(0);
			} catch (Throwable ignore) {
			}
		}

		if (signLink != null) {
			try {
				signLink.close();
			} catch (Exception ignore) {
			}
		}

		this.reset();
	}

	// com.jagex.game.runetek6.client.GameShell3.doneslowupdate
	@ObfuscatedName("bk.v(B)V")
	public static void doneslowupdate() {
		timer.reset();

		for (int i = 0; i < 32; i++) {
			drawTime[i] = 0L;
		}

		for (int i = 0; i < 32; i++) {
			updateTime[i] = 0L;
		}

		updateCount = 0;
	}

	@Override
	public void start() {
		if (shell != this || alreadyshutdown) {
			return;
		}

		killtime = 0L;
	}

	@Override
	public void stop() {
		if (shell != this || alreadyshutdown) {
			return;
		}

		killtime = MonotonicTime.currentTime() + 4000L;
	}

	@Override
	public void destroy() {
		if (shell != this || alreadyshutdown) {
			return;
		}

		killtime = MonotonicTime.currentTime();
		ThreadSleep.sleepPrecise(5000L);
		this.shutdown();
	}

	@Override
	public final void update(Graphics g) {
		this.paint(g);
	}

	@Override
	public final synchronized void paint(Graphics g) {
		if (shell != this || alreadyshutdown) {
			return;
		}

		fullredraw = true;

		if (SignLink.javaVersion != null && SignLink.javaVersion.startsWith("1.5") && MonotonicTime.currentTime() - lastCanvasReplace > 1000L) {
			Rectangle bounds = g.getClipBounds();
			if (bounds == null || bounds.width >= canvasWid && bounds.height >= canvasHei) {
				canvasReplaceRecommended = true;
			}
		}
	}

	@Override
	public final void focusGained(FocusEvent e) {
		focus_in = true;
		fullredraw = true;
	}

	@Override
	public final void focusLost(FocusEvent e) {
		focus_in = false;
	}

	@Override
	public final void windowActivated(WindowEvent e) {
	}

	@Override
	public final void windowClosed(WindowEvent e) {
	}

	@Override
	public final void windowClosing(WindowEvent e) {
		this.destroy();
	}

	@Override
	public final void windowDeactivated(WindowEvent e) {
	}

	@Override
	public final void windowDeiconified(WindowEvent e) {
	}

	@Override
	public final void windowIconified(WindowEvent e) {
	}

	@Override
	public final void windowOpened(WindowEvent e) {
	}

	// com.jagex.game.runetek6.client.GameShell3.error
	@ObfuscatedName("dj.t(Ljava/lang/String;I)V")
	public void error(String err) {
		if (this.alreadyerrored) {
			return;
		}

		this.alreadyerrored = true;
		System.out.println("error_game_" + err);

		try {
			this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + err + ".ws"), "_self");
		} catch (Exception ignore) {
		}
	}

	@ObfuscatedName("dj.y(B)V")
	public abstract void mainquit();

	@ObfuscatedName("dj.w(I)V")
	public abstract void maininit();

	@ObfuscatedName("dj.e(B)V")
	public abstract void mainloop();

	@ObfuscatedName("dj.f(I)V")
	public abstract void reset();

	@ObfuscatedName("dj.b(I)V")
	public abstract void mainredraw();

	@Override
	public abstract void init();

	public static void drawProgress(int progress, String message, Color color) {
		try {
			Graphics g = canvas.getGraphics();

			if (progressFont == null) {
				progressFont = new Font("Helvetica", Font.BOLD, 13);
				progressFontMetrics = canvas.getFontMetrics(progressFont);
			}

			if (fullredraw) {
				fullredraw = false;
				g.setColor(Color.black);
				g.fillRect(0, 0, canvasWid, canvasHei);
			}

			if (color == null) {
				color = new Color(140, 17, 17);
			}

			try {
				if (progressBar == null) {
					progressBar = canvas.createImage(304, 34);
				}

				Graphics bar = progressBar.getGraphics();

				bar.setColor(color);
				bar.drawRect(0, 0, 303, 33);
				bar.fillRect(2, 2, progress * 3, 30);

				bar.setColor(Color.black);
				bar.drawRect(1, 1, 301, 31);
				bar.fillRect(progress * 3 + 2, 2, 300 - progress * 3, 30);

				bar.setFont(progressFont);
				bar.setColor(Color.white);
				bar.drawString(message, (304 - progressFontMetrics.stringWidth(message)) / 2, 22);

				g.drawImage(progressBar, canvasWid / 2 - 152, canvasHei / 2 - 18, null);
			} catch (Exception ex) {
				int x = canvasWid / 2 - 152;
				int y = canvasHei / 2 - 18;

				g.setColor(color);
				g.drawRect(x, y, 303, 33);
				g.fillRect(x + 2, y + 2, progress * 3, 30);

				g.setColor(Color.black);
				g.drawRect(x + 1, y + 1, 301, 31);
				g.fillRect(progress * 3 + x + 2, y + 2, 300 - progress * 3, 30);

				g.setFont(progressFont);
				g.setColor(Color.white);
				g.drawString(message, x + (304 - progressFontMetrics.stringWidth(message)) / 2, y + 22);
			}
		} catch (Exception ex) {
			canvas.repaint();
		}
	}

	public static void resetProgress() {
		progressBar = null;
		progressFont = null;
		progressFontMetrics = null;
	}
}
