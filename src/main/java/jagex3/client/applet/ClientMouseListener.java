package jagex3.client.applet;

import deob.ObfuscatedName;
import jagex3.datastruct.MonotonicTime;

import java.awt.*;
import java.awt.event.*;

// jag::oldscape::input::ClientMouseListener
@ObfuscatedName("an")
public class ClientMouseListener implements MouseListener, MouseMotionListener, FocusListener {

	@ObfuscatedName("an.r")
	public static ClientMouseListener instance = new ClientMouseListener();

	@ObfuscatedName("an.d")
	public static volatile int idleTimer = 0;

	@ObfuscatedName("an.l")
	public static volatile int nextMouseButton = 0;

	@ObfuscatedName("an.m")
	public static volatile int nextMouseX = -1;

	@ObfuscatedName("an.c")
	public static volatile int nextMouseY = -1;

	@ObfuscatedName("an.n")
	public static int mouseButton = 0;

	@ObfuscatedName("an.j")
	public static int mouseX = 0;

	@ObfuscatedName("an.z")
	public static int mouseY = 0;

	@ObfuscatedName("an.g")
	public static volatile int nextMouseClickButton = 0;

	@ObfuscatedName("an.q")
	public static volatile int nextMouseClickX = 0;

	@ObfuscatedName("an.i")
	public static volatile int nextMouseClickY = 0;

	@ObfuscatedName("an.s")
	public static volatile long nextMouseClickTime = 0L;

	@ObfuscatedName("an.u")
	public static int mouseClickButton = 0;

	@ObfuscatedName("an.v")
	public static int mouseClickX = 0;

	@ObfuscatedName("an.w")
	public static int mouseClickY = 0;

	@ObfuscatedName("an.e")
	public static long mouseClickTime = 0L;

	@ObfuscatedName("v.r(Ljava/awt/Component;I)V")
	public static void addListeners(Component c) {
		c.addMouseListener(instance);
		c.addMouseMotionListener(instance);
		c.addFocusListener(instance);
	}

	@ObfuscatedName("ek.d(II)V")
	public static void setIdleTimer(int v) {
		idleTimer = v;
	}

	public static void cycle() {
		ClientMouseListener lock = instance;
		synchronized (lock) {
			mouseButton = nextMouseButton;
			mouseX = nextMouseX;
			mouseY = nextMouseY;
			mouseClickButton = nextMouseClickButton;
			mouseClickX = nextMouseClickX;
			mouseClickY = nextMouseClickY;
			mouseClickTime = nextMouseClickTime;

			nextMouseClickButton = 0;
		}
	}

	public final synchronized void mousePressed(MouseEvent e) {
		if (instance != null) {
			idleTimer = 0;

			nextMouseClickX = e.getX();
			nextMouseClickY = e.getY();
			nextMouseClickTime = MonotonicTime.currentTime();

			if (e.getButton() == MouseEvent.BUTTON3) {
				nextMouseClickButton = 2;
				nextMouseButton = 2;
			} else {
				nextMouseClickButton = 1;
				nextMouseButton = 1;
			}
		}

		if (e.isPopupTrigger()) {
			e.consume();
		}
	}

	public final synchronized void mouseReleased(MouseEvent e) {
		if (instance != null) {
			idleTimer = 0;

			nextMouseButton = 0;
		}

		if (e.isPopupTrigger()) {
			e.consume();
		}
	}

	public final void mouseClicked(MouseEvent e) {
		if (e.isPopupTrigger()) {
			e.consume();
		}
	}

	public final synchronized void mouseEntered(MouseEvent e) {
		if (instance != null) {
			idleTimer = 0;

			nextMouseX = e.getX();
			nextMouseY = e.getY();
		}
	}

	public final synchronized void mouseExited(MouseEvent e) {
		if (instance != null) {
			idleTimer = 0;

			nextMouseX = -1;
			nextMouseY = -1;
		}
	}

	public final synchronized void mouseDragged(MouseEvent e) {
		if (instance != null) {
			idleTimer = 0;

			nextMouseX = e.getX();
			nextMouseY = e.getY();
		}
	}

	public final synchronized void mouseMoved(MouseEvent e) {
		if (instance != null) {
			idleTimer = 0;

			nextMouseX = e.getX();
			nextMouseY = e.getY();
		}
	}

	public final void focusGained(FocusEvent e) {
	}

	public final synchronized void focusLost(FocusEvent e) {
		if (instance != null) {
			nextMouseButton = 0;
		}
	}

	public static void removeListeners(Canvas c) {
		c.removeMouseListener(instance);
		c.removeMouseMotionListener(instance);
		c.removeFocusListener(instance);

		nextMouseButton = 0;
	}

	public static void shutdown() {
		if (instance != null) {
			ClientMouseListener lock = instance;
			synchronized (lock) {
				instance = null;
			}
		}
	}

	public static int getIdleTimer() {
		return idleTimer++;
	}
}
