package jagex3.client.ui;

import deob.ObfuscatedName;

// jag::oldscape::rs2lib::ServerActive
@ObfuscatedName("cv")
public class ServerActive {

	public ServerActive() throws Throwable {
		throw new Error();
	}

	// jag::oldscape::rs2lib::ServerActive::PauseButton
	@ObfuscatedName("bh.r(II)Z")
	public static boolean pauseButton(int events) {
		return (events & 0x1) != 0;
	}

	// jag::oldscape::rs2lib::ServerActive::TargetMask
	@ObfuscatedName("da.d(II)I")
	public static int targetMask(int events) {
		return events >> 11 & 0x3F;
	}

	// jag::oldscape::rs2lib::ServerActive::ServerDraggable
	@ObfuscatedName("az.l(II)I")
	public static int serverDraggable(int events) {
		return events >> 17 & 0x7;
	}

	@ObfuscatedName("bn.m(II)Z")
	public static boolean objDraggable(int events) {
		return (events >> 28 & 0x1) != 0;
	}

	public static boolean objSwappable(int events) {
		return (events >> 29 & 0x1) != 0;
	}
}
