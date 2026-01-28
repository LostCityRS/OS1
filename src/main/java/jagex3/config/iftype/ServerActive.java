package jagex3.config.iftype;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable;

// jag::oldscape::rs2lib::ServerActive
@ObfuscatedName("el")
public class ServerActive extends Linkable {

	@ObfuscatedName("el.m")
	public int eventCode;

	public ServerActive(int eventCode) {
		this.eventCode = eventCode;
	}

	// jag::oldscape::rs2lib::ServerActive::PauseButton
	@ObfuscatedName("bh.r(II)Z")
	public static boolean pauseButton(int eventCode) {
		return (eventCode & 0x1) != 0;
	}

	// jag::oldscape::rs2lib::ServerActive::HasOp
	public static boolean hasOp(int eventCode, int opindex) {
		return ((eventCode >> (opindex + 1)) & 0x1) != 0;
	}

	// jag::oldscape::rs2lib::ServerActive::TargetMask
	@ObfuscatedName("da.d(II)I")
	public static int targetMask(int eventCode) {
		return (eventCode >> 11) & 0x3F;
	}

	// jag::oldscape::rs2lib::ServerActive::ServerDraggable
	@ObfuscatedName("az.l(II)I")
	public static int serverDraggable(int eventCode) {
		return (eventCode >> 17) & 0x7;
	}

	// jag::oldscape::rs2lib::ServerActive::IsDragTarget
	public static boolean isDragTarget(int eventCode) {
		return ((eventCode >> 20) & 0x1) != 0;
	}

	// jag::oldscape::rs2lib::ServerActive::IsUseTarget
	public static boolean isUseTarget(int eventCode) {
		return ((eventCode >> 21) & 0x1) != 0;
	}

	@ObfuscatedName("bn.m(II)Z")
	public static boolean isObjSwapEnabled(int eventCode) {
		return ((eventCode >> 28) & 0x1) != 0;
	}

	public static boolean isObjReplaceEnabled(int eventCode) {
		return ((eventCode >> 29) & 0x1) != 0;
	}

	public static boolean isObjOpsEnabled(int eventCode) {
		return ((eventCode >> 30) & 0x1) != 0;
	}

	public static boolean isObjUseEnabled(int eventCode) {
		return ((eventCode >> 31) & 0x1) != 0;
	}
}
