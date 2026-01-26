package jagex3.client.applet;

import deob.ObfuscatedName;
import jagex3.client.SignLink;
import jagex3.jstring.Cp1252;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@ObfuscatedName("az")
public class JavaKeyboardProvider implements KeyListener, FocusListener {

	@ObfuscatedName("az.r")
	public static JavaKeyboardProvider instance = new JavaKeyboardProvider();

	@ObfuscatedName("az.cu")
	public static boolean[] keyHeld = new boolean[112];

	@ObfuscatedName("ca.cc")
	public static char ch;

	@ObfuscatedName("n.cm")
	public static int code;

	@ObfuscatedName("az.cw")
	public static int[] keyHeldBuffer = new int[128];

	@ObfuscatedName("az.cz")
	public static int keyHeldWritePos = 0;

	@ObfuscatedName("az.cv")
	public static int keyHeldReadPos = 0;

	@ObfuscatedName("az.ct")
	public static char[] keyChBuffer = new char[128];

	@ObfuscatedName("az.ck")
	public static int[] keyCodeBuffer = new int[128];

	@ObfuscatedName("az.cy")
	public static int keyReadPos = 0;

	@ObfuscatedName("az.cq")
	public static int keyWritePos = 0;

	@ObfuscatedName("az.cd")
	public static int lastKeyWritePos = 0;

	@ObfuscatedName("az.cx")
	public static volatile int idleTimer = 0;

	@ObfuscatedName("az.cn")
	public static int[] KEY_CODE_MAP = new int[] {
		-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1,
		13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19,
		20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40,
		41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226,
		232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1, -1
	};

	@ObfuscatedName("n.r(Ljava/awt/Component;I)V")
	public static void addListeners(Component c) {
		c.setFocusTraversalKeysEnabled(false);
		c.addKeyListener(instance);
		c.addFocusListener(instance);
	}

	@ObfuscatedName("cw.d(Ljava/awt/Component;B)V")
	public static void removeListeners(Component c) {
		c.removeKeyListener(instance);
		c.removeFocusListener(instance);

		keyHeldReadPos = -1;
	}

	@ObfuscatedName("dw.l(I)V")
	public static void shutdown() {
		if (instance != null) {
			JavaKeyboardProvider lock = instance;
			synchronized (lock) {
				instance = null;
			}
		}
	}

	public static void cycle() {
		JavaKeyboardProvider lock = instance;
		synchronized (lock) {
			idleTimer++;

			keyReadPos = lastKeyWritePos;

			if (keyHeldReadPos >= 0) {
				while (keyHeldWritePos != keyHeldReadPos) {
					int key = keyHeldBuffer[keyHeldWritePos];
					keyHeldWritePos = keyHeldWritePos + 1 & 0x7F;

					if (key < 0) {
						keyHeld[~key] = false;
					} else {
						keyHeld[key] = true;
					}
				}
			} else {
				for (int i = 0; i < 112; i++) {
					keyHeld[i] = false;
				}

				keyHeldReadPos = keyHeldWritePos;
			}

			lastKeyWritePos = keyWritePos;
		}
	}

	public final synchronized void keyPressed(KeyEvent e) {
		if (instance == null) {
			return;
		}

		idleTimer = 0;

		int code = e.getKeyCode();
		int ch;
		if (code >= 0 && code < KEY_CODE_MAP.length) {
			ch = KEY_CODE_MAP[code];
			if ((ch & 0x80) != 0) {
				ch = -1;
			}
		} else {
			ch = -1;
		}

		if (keyHeldReadPos >= 0 && ch >= 0) {
			keyHeldBuffer[keyHeldReadPos] = ch;
			keyHeldReadPos = keyHeldReadPos + 1 & 0x7F;

			if (keyHeldWritePos == keyHeldReadPos) {
				keyHeldReadPos = -1;
			}
		}

		if (ch >= 0) {
			int next = keyWritePos + 1 & 0x7F;
			if (keyReadPos != next) {
				keyCodeBuffer[keyWritePos] = ch;
				keyChBuffer[keyWritePos] = 0;
				keyWritePos = next;
			}
		}

		int mod = e.getModifiers();
		if ((mod & 0xA) != 0 || ch == 85 || ch == 10) {
			e.consume();
		}
	}

	public final synchronized void keyReleased(KeyEvent e) {
		if (instance != null) {
			idleTimer = 0;

			int code = e.getKeyCode();
			int ch;
			if (code >= 0 && code < KEY_CODE_MAP.length) {
				ch = KEY_CODE_MAP[code] & 0xFFFFFF7F;
			} else {
				ch = -1;
			}

			if (keyHeldReadPos >= 0 && ch >= 0) {
				keyHeldBuffer[keyHeldReadPos] = ~ch;
				keyHeldReadPos = keyHeldReadPos + 1 & 0x7F;

				if (keyHeldWritePos == keyHeldReadPos) {
					keyHeldReadPos = -1;
				}
			}
		}

		e.consume();
	}

	public final void keyTyped(KeyEvent e) {
		if (instance != null) {
			char ch = e.getKeyChar();
			if (ch != 0 && ch != 65535 && Cp1252.method767(ch)) {
				int next = keyWritePos + 1 & 0x7F;
				if (keyReadPos != next) {
					keyCodeBuffer[keyWritePos] = -1;
					keyChBuffer[keyWritePos] = ch;
					keyWritePos = next;
				}
			}
		}

		e.consume();
	}

	public final void focusGained(FocusEvent e) {
	}

	public final synchronized void focusLost(FocusEvent e) {
		if (instance != null) {
			keyHeldReadPos = -1;
		}
	}

	public static void setupKeyCodeMap() {
		if (SignLink.javaVendor.toLowerCase().indexOf("microsoft") == -1) {
			KEY_CODE_MAP[44] = 71;
			KEY_CODE_MAP[45] = 26;
			KEY_CODE_MAP[46] = 72;
			KEY_CODE_MAP[47] = 73;
			KEY_CODE_MAP[59] = 57;
			KEY_CODE_MAP[61] = 27;
			KEY_CODE_MAP[91] = 42;
			KEY_CODE_MAP[92] = 74;
			KEY_CODE_MAP[93] = 43;
			KEY_CODE_MAP[192] = 28;
			KEY_CODE_MAP[222] = 58;
			KEY_CODE_MAP[520] = 59;
		} else {
			KEY_CODE_MAP[186] = 57;
			KEY_CODE_MAP[187] = 27;
			KEY_CODE_MAP[188] = 71;
			KEY_CODE_MAP[189] = 26;
			KEY_CODE_MAP[190] = 72;
			KEY_CODE_MAP[191] = 73;
			KEY_CODE_MAP[192] = 58;
			KEY_CODE_MAP[219] = 42;
			KEY_CODE_MAP[220] = 74;
			KEY_CODE_MAP[221] = 43;
			KEY_CODE_MAP[222] = 59;
			KEY_CODE_MAP[223] = 28;
		}
	}

	public static boolean pollKey() {
		JavaKeyboardProvider lock = instance;
		synchronized (lock) {
			if (keyReadPos == lastKeyWritePos) {
				return false;
			} else {
				code = keyCodeBuffer[keyReadPos];
				ch = keyChBuffer[keyReadPos];
				keyReadPos = keyReadPos + 1 & 0x7F;
				return true;
			}
		}
	}

	public static int getIdleTimer() {
		return idleTimer;
	}
}
