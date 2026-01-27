package jagex3.config.iftype;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable;

// jag::oldscape::rs2lib::ServerActive
@ObfuscatedName("el")
public class ServerActive extends Linkable {

	@ObfuscatedName("el.m")
	public int events;

	public ServerActive(int events) {
		this.events = events;
	}

	// jag::oldscape::rs2lib::ServerActive::PauseButton
	@ObfuscatedName("bh.r(II)Z")
	public static boolean pauseButton(int events) {
		return (events & 0x1) != 0;
	}

	// jag::oldscape::rs2lib::ServerActive::HasOp
	public static boolean hasOp(int events, int opindex) {
		return ((events >> (opindex + 1)) & 0x1) != 0;
	}

	// jag::oldscape::rs2lib::ServerActive::TargetMask
	@ObfuscatedName("da.d(II)I")
	public static int targetMask(int events) {
		return (events >> 11) & 0x3F;
	}

	// jag::oldscape::rs2lib::ServerActive::ServerDraggable
	@ObfuscatedName("az.l(II)I")
	public static int serverDraggable(int events) {
		return (events >> 17) & 0x7;
	}

	// jag::oldscape::rs2lib::ServerActive::IsDragTarget
	public static boolean isDragTarget(int events) {
		return ((events >> 20) & 0x1) != 0;
	}

	// jag::oldscape::rs2lib::ServerActive::IsUseTarget
	public static boolean isUseTarget(int events) {
		return ((events >> 21) & 0x1) != 0;
	}

	@ObfuscatedName("bn.m(II)Z")
	public static boolean isObjSwapEnabled(int events) {
		return ((events >> 28) & 0x1) != 0;
	}

	public static boolean isObjReplaceEnabled(int events) {
		return ((events >> 29) & 0x1) != 0;
	}

	public static boolean isObjOpsEnabled(int events) {
		return ((events >> 30) & 0x1) != 0;
	}

	public static boolean isObjUseEnabled(int events) {
		return ((events >> 31) & 0x1) != 0;
	}
}
