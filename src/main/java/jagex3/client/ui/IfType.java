package jagex3.client.ui;

import deob.ObfuscatedName;
import jagex3.config.NpcType;
import jagex3.config.ObjType;
import jagex3.config.SeqType;
import jagex3.dash3d.ModelLit;
import jagex3.dash3d.ModelUnlit;
import jagex3.dash3d.PlayerModel;
import jagex3.datastruct.Linkable;
import jagex3.datastruct.LruCache;
import jagex3.graphics.Pix32;
import jagex3.graphics.PixLoader;
import jagex3.graphics.SoftwareFont;
import jagex3.io.Packet;
import jagex3.js5.Js5;
import jagex3.jstring.Text;

@ObfuscatedName("eg")
public class IfType extends Linkable {

	// jag::oldscape::rs2lib::IfType::m_list
	@ObfuscatedName("av.m")
	public static IfType[][] list;

	// jag::oldscape::rs2lib::IfType::m_open
	@ObfuscatedName("df.c")
	public static boolean[] open;

	// jag::oldscape::rs2lib::IfType::m_pInterfaces
	@ObfuscatedName("eg.n")
	public static Js5 interfaces;

	@ObfuscatedName("eg.j")
	public static Js5 models;

	@ObfuscatedName("dc.z")
	public static Js5 sprites;

	@ObfuscatedName("eg.g")
	public static Js5 fontMetrics;

	@ObfuscatedName("eg.q")
	public static LruCache spriteCache = new LruCache(200);

	@ObfuscatedName("eg.i")
	public static LruCache field1850 = new LruCache(50);

	@ObfuscatedName("eg.s")
	public static LruCache field1891 = new LruCache(20);

	@ObfuscatedName("eg.u")
	public static boolean loadingAsset = false;

	@ObfuscatedName("eg.v")
	public boolean v3 = false;

	@ObfuscatedName("eg.w")
	public int parentlayer = -1;

	@ObfuscatedName("eg.e")
	public int subid = -1;

	@ObfuscatedName("eg.b")
	public int type;

	@ObfuscatedName("eg.y")
	public int x = 0;

	@ObfuscatedName("eg.t")
	public int buttonType = 0;

	@ObfuscatedName("eg.f")
	public int clientCode = 0;

	@ObfuscatedName("eg.k")
	public int renderx = 0;

	@ObfuscatedName("eg.o")
	public int rendery = 0;

	@ObfuscatedName("eg.a")
	public int y = 0;

	@ObfuscatedName("eg.h")
	public int renderwidth = 0;

	@ObfuscatedName("eg.x")
	public int renderheight = 0;

	@ObfuscatedName("eg.p")
	public int layerid = -1;

	@ObfuscatedName("eg.ad")
	public boolean hide = false;

	@ObfuscatedName("eg.ac")
	public int scrollX = 0;

	@ObfuscatedName("eg.aa")
	public int scrollY = 0;

	@ObfuscatedName("eg.as")
	public int scrollWidth = 0;

	@ObfuscatedName("eg.am")
	public int scrollHeight = 0;

	@ObfuscatedName("eg.ap")
	public int colour = 0;

	@ObfuscatedName("eg.av")
	public int colour2 = 0;

	@ObfuscatedName("eg.ak")
	public int colourOver = 0;

	@ObfuscatedName("eg.az")
	public int colour2Over = 0;

	@ObfuscatedName("eg.an")
	public boolean fill = false;

	@ObfuscatedName("eg.ah")
	public int trans = 0;

	@ObfuscatedName("eg.ay")
	public int lineWidth = 1;

	@ObfuscatedName("eg.al")
	public int graphic = -1;

	@ObfuscatedName("eg.ab")
	public int graphic2 = -1;

	@ObfuscatedName("eg.ao")
	public int angle2d = 0;

	@ObfuscatedName("eg.ag")
	public boolean tiling = false;

	@ObfuscatedName("eg.ar")
	public int outline = 0;

	@ObfuscatedName("eg.aq")
	public int graphicshadow = 0;

	@ObfuscatedName("eg.at")
	public boolean vflip;

	@ObfuscatedName("eg.ae")
	public boolean hflip;

	@ObfuscatedName("eg.au")
	public int modelType = 1;

	@ObfuscatedName("eg.ax")
	public int modelId = -1;

	@ObfuscatedName("eg.ai")
	public int model2Type = 1;

	@ObfuscatedName("eg.aj")
	public int model2Id = -1;

	@ObfuscatedName("eg.aw")
	public int modelAnim = -1;

	@ObfuscatedName("eg.af")
	public int model2Anim = -1;

	@ObfuscatedName("eg.bh")
	public int xof = 0;

	@ObfuscatedName("eg.bi")
	public int yof = 0;

	@ObfuscatedName("eg.bs")
	public int modelXan = 0;

	@ObfuscatedName("eg.bk")
	public int modelYan = 0;

	@ObfuscatedName("eg.bv")
	public int zan = 0;

	@ObfuscatedName("eg.bg")
	public int modelZoom = 100;

	@ObfuscatedName("eg.bl")
	public int field1827 = 0;

	@ObfuscatedName("eg.bt")
	public boolean modelOrthographic = false;

	@ObfuscatedName("eg.bw")
	public int font = -1;

	@ObfuscatedName("eg.by")
	public String text = "";

	@ObfuscatedName("eg.bx")
	public String text2 = "";

	@ObfuscatedName("eg.bf")
	public int field1832 = 0;

	@ObfuscatedName("eg.bu")
	public int halign = 0;

	@ObfuscatedName("eg.bo")
	public int field1834 = 0;

	@ObfuscatedName("eg.bq")
	public boolean shadowed = false;

	@ObfuscatedName("eg.bj")
	public int marginX = 0;

	@ObfuscatedName("eg.bz")
	public int marginY = 0;

	@ObfuscatedName("eg.bm")
	public int[] invSlotOffsetX;

	@ObfuscatedName("eg.bn")
	public int[] invSlotOffsetY;

	@ObfuscatedName("eg.be")
	public int[] invSlotGraphic;

	@ObfuscatedName("eg.bp")
	public String[] iop;

	@ObfuscatedName("eg.ba")
	public int events = 0;

	@ObfuscatedName("eg.bc")
	public String opbase = "";

	@ObfuscatedName("eg.br")
	public String[] ops;

	@ObfuscatedName("eg.bb")
	public IfType draggable = null;

	@ObfuscatedName("eg.bd")
	public int dragdeadzone = 0;

	@ObfuscatedName("eg.cr")
	public int dragdeadtime = 0;

	@ObfuscatedName("eg.cs")
	public boolean draggablebehavior = false;

	@ObfuscatedName("eg.cj")
	public String targetVerb = "";

	@ObfuscatedName("eg.cl")
	public boolean hashook = false;

	@ObfuscatedName("eg.cp")
	public Object[] onload;

	@ObfuscatedName("eg.ca")
	public Object[] onclick;

	@ObfuscatedName("eg.co")
	public Object[] onclickrepeat;

	@ObfuscatedName("eg.ch")
	public Object[] onrelease;

	@ObfuscatedName("eg.cu")
	public Object[] onhold;

	@ObfuscatedName("eg.cc")
	public Object[] onmouseover;

	@ObfuscatedName("eg.cm")
	public Object[] onmouserepeat;

	@ObfuscatedName("eg.cw")
	public Object[] onmouseleave;

	@ObfuscatedName("eg.cz")
	public Object[] ondrag;

	@ObfuscatedName("eg.cv")
	public Object[] ondragcomplete;

	@ObfuscatedName("eg.ct")
	public Object[] ontargetenter;

	@ObfuscatedName("eg.ck")
	public Object[] ontargetleave;

	@ObfuscatedName("eg.cy")
	public Object[] onvartransmit;

	@ObfuscatedName("eg.cq")
	public int[] onvartransmitlist;

	@ObfuscatedName("eg.cd")
	public Object[] oninvtransmit;

	@ObfuscatedName("eg.cx")
	public int[] oninvtransmitlist;

	@ObfuscatedName("eg.cn")
	public Object[] onstattransmit;

	@ObfuscatedName("eg.ce")
	public int[] onstattransmitlist;

	@ObfuscatedName("eg.ci")
	public Object[] ontimer;

	@ObfuscatedName("eg.cb")
	public Object[] onop;

	@ObfuscatedName("eg.cf")
	public Object[] onscrollwheel;

	@ObfuscatedName("eg.cg")
	public Object[] field1872;

	@ObfuscatedName("eg.dd")
	public Object[] field1873;

	@ObfuscatedName("eg.dg")
	public Object[] field1877;

	@ObfuscatedName("eg.df")
	public Object[] field1875;

	@ObfuscatedName("eg.dk")
	public Object[] field1777;

	@ObfuscatedName("eg.dz")
	public Object[] ondialogabort;

	@ObfuscatedName("eg.da")
	public Object[] onsubchange;

	@ObfuscatedName("eg.dj")
	public int[][] scripts;

	@ObfuscatedName("eg.dv")
	public int[] scriptComparator;

	@ObfuscatedName("eg.ds")
	public int[] scriptOperand;

	@ObfuscatedName("eg.dh")
	public int overlayer = -1;

	@ObfuscatedName("eg.dc")
	public String targetText = "";

	@ObfuscatedName("eg.dp")
	public String option = Text.OK;

	@ObfuscatedName("eg.dm")
	public int[] linkObjType;

	@ObfuscatedName("eg.di")
	public int[] linkObjCount;

	@ObfuscatedName("eg.db")
	public int field1791 = -1;

	@ObfuscatedName("eg.dq")
	public int field1888 = 0;

	@ObfuscatedName("eg.dr")
	public int animFrame = 0;

	@ObfuscatedName("eg.du")
	public int animCycle = 0;

	@ObfuscatedName("eg.dy")
	public IfType[] subcomponents;

	@ObfuscatedName("eg.de")
	public boolean field1892 = false;

	@ObfuscatedName("eg.dw")
	public boolean field1871 = false;

	@ObfuscatedName("eg.dl")
	public int field1894 = -1;

	@ObfuscatedName("eg.dn")
	public int field1895 = 0;

	@ObfuscatedName("eg.do")
	public int field1879 = 0;

	@ObfuscatedName("eg.dx")
	public int field1897 = 0;

	@ObfuscatedName("eg.dt")
	public int field1898 = -1;

	@ObfuscatedName("eg.eb")
	public int drawTime = -1;

	@ObfuscatedName("ay.c(Lch;Lch;Lch;Lch;I)V")
	public static void unpack(Js5 arg0, Js5 arg1, Js5 arg2, Js5 arg3) {
		interfaces = arg0;
		models = arg1;
		sprites = arg2;
		fontMetrics = arg3;

		list = new IfType[interfaces.getGroupCount()][];
		open = new boolean[interfaces.getGroupCount()];
	}

	@ObfuscatedName("bw.n(IB)Leg;")
	public static IfType get(int arg0) {
		int var1 = arg0 >> 16;
		int var2 = arg0 & 0xFFFF;
		if (list[var1] == null || list[var1][var2] == null) {
			boolean var3 = openInterface(var1);
			if (!var3) {
				return null;
			}
		}
		return list[var1][var2];
	}

	@ObfuscatedName("bd.j(IIB)Leg;")
	public static IfType get(int arg0, int arg1) {
		IfType var2 = get(arg0);
		if (arg1 == -1) {
			return var2;
		} else if (var2 == null || var2.subcomponents == null || arg1 >= var2.subcomponents.length) {
			return null;
		} else {
			return var2.subcomponents[arg1];
		}
	}

	// jag::oldscape::rs2lib::IfType::OpenInterface
	@ObfuscatedName("dw.z(II)Z")
	public static boolean openInterface(int id) {
		if (open[id]) {
			return true;
		}

		if (!interfaces.requestGroupDownload(id)) {
			return false;
		}

		int children = interfaces.getFileIdLimit(id);
		if (children == 0) {
			open[id] = true;
			return true;
		}

		if (list[id] == null) {
			list[id] = new IfType[children];
		}

		for (int sub = 0; sub < children; sub++) {
			if (list[id][sub] != null) {
				continue;
			}

			byte[] data = interfaces.getFile(id, sub);
			if (data == null) {
				continue;
			}

			list[id][sub] = new IfType();
			list[id][sub].parentlayer = (id << 16) + sub;
			if (data[0] == -1) {
				list[id][sub].decode3(new Packet(data));
			} else {
				list[id][sub].decode(new Packet(data));
			}
		}

		open[id] = true;
		return true;
	}

	// jag::oldscape::rs2lib::IfType::Decode
	@ObfuscatedName("eg.g(Lev;I)V")
	public void decode(Packet buf) {
		this.v3 = false;

		this.type = buf.g1();
		this.buttonType = buf.g1();
		this.clientCode = buf.g2();
		this.x = this.renderx = buf.g2b();
		this.y = this.rendery = buf.g2b();
		this.renderwidth = buf.g2();
		this.renderheight = buf.g2();
		this.trans = buf.g1();

		this.layerid = buf.g2();
		if (this.layerid == 65535) {
			this.layerid = -1;
		} else {
			this.layerid += this.parentlayer & 0xFFFF0000;
		}

		this.overlayer = buf.g2();
		if (this.overlayer == 65535) {
			this.overlayer = -1;
		}

		int scriptStackCount = buf.g1();
		if (scriptStackCount > 0) {
			this.scriptComparator = new int[scriptStackCount];
			this.scriptOperand = new int[scriptStackCount];

			for (int i = 0; i < scriptStackCount; i++) {
				this.scriptComparator[i] = buf.g1();
				this.scriptOperand[i] = buf.g2();
			}
		}

		int scriptCount = buf.g1();
		if (scriptCount > 0) {
			this.scripts = new int[scriptCount][];
			for (int i = 0; i < scriptCount; i++) {
				int scriptCount2 = buf.g2();

				this.scripts[i] = new int[scriptCount2];
				for (int j = 0; j < scriptCount2; j++) {
					this.scripts[i][j] = buf.g2();
					if (this.scripts[i][j] == 65535) {
						this.scripts[i][j] = -1;
					}
				}
			}
		}

		if (this.type == 0) {
			this.scrollHeight = buf.g2();
			this.hide = buf.g1() == 1;
		}

		if (this.type == 1) {
			buf.g2();
			buf.g1();
		}

		if (this.type == 2) {
			this.linkObjType = new int[this.renderheight * this.renderwidth];
			this.linkObjCount = new int[this.renderheight * this.renderwidth];

			int draggable = buf.g1();
			if (draggable == 1) {
				this.events |= 0x10000000;
			}

			int interactable = buf.g1();
			if (interactable == 1) {
				this.events |= 0x40000000;
			}

			int usable = buf.g1();
			if (usable == 1) {
				this.events |= 0x80000000;
			}

			int swappable = buf.g1();
			if (swappable == 1) {
				this.events |= 0x20000000;
			}

			this.marginX = buf.g1();
			this.marginY = buf.g1();

			this.invSlotOffsetX = new int[20];
			this.invSlotOffsetY = new int[20];
			this.invSlotGraphic = new int[20];

			for (int i = 0; i < 20; i++) {
				int hasGraphic = buf.g1();
				if (hasGraphic == 1) {
					this.invSlotOffsetX[i] = buf.g2b();
					this.invSlotOffsetY[i] = buf.g2b();
					this.invSlotGraphic[i] = buf.g4();
				} else {
					this.invSlotGraphic[i] = -1;
				}
			}

			this.iop = new String[5];
			for (int i = 0; i < 5; i++) {
				String op = buf.gjstr();
				if (op.length() > 0) {
					this.iop[i] = op;
					this.events |= 0x1 << i + 23;
				}
			}
		}

		if (this.type == 3) {
			this.fill = buf.g1() == 1;
		}

		if (this.type == 4 || this.type == 1) {
			this.halign = buf.g1();
			this.field1834 = buf.g1();
			this.field1832 = buf.g1();
			this.font = buf.g2();
			if (this.font == 65535) {
				this.font = -1;
			}
			this.shadowed = buf.g1() == 1;
		}

		if (this.type == 4) {
			this.text = buf.gjstr();
			this.text2 = buf.gjstr();
		}

		if (this.type == 1 || this.type == 3 || this.type == 4) {
			this.colour = buf.g4();
		}

		if (this.type == 3 || this.type == 4) {
			this.colour2 = buf.g4();
			this.colourOver = buf.g4();
			this.colour2Over = buf.g4();
		}

		if (this.type == 5) {
			this.graphic = buf.g4();
			this.graphic2 = buf.g4();
		}

		if (this.type == 6) {
			this.modelType = 1;
			this.modelId = buf.g2();
			if (this.modelId == 65535) {
				this.modelId = -1;
			}

			this.model2Type = 1;
			this.model2Id = buf.g2();
			if (this.model2Id == 65535) {
				this.model2Id = -1;
			}

			this.modelAnim = buf.g2();
			if (this.modelAnim == 65535) {
				this.modelAnim = -1;
			}

			this.model2Anim = buf.g2();
			if (this.model2Anim == 65535) {
				this.model2Anim = -1;
			}

			this.modelZoom = buf.g2();
			this.modelXan = buf.g2();
			this.modelYan = buf.g2();
		}

		if (this.type == 7) {
			this.linkObjType = new int[this.renderheight * this.renderwidth];
			this.linkObjCount = new int[this.renderheight * this.renderwidth];

			this.halign = buf.g1();
			this.font = buf.g2();
			if (this.font == 65535) {
				this.font = -1;
			}

			this.shadowed = buf.g1() == 1;
			this.colour = buf.g4();
			this.marginX = buf.g2b();
			this.marginY = buf.g2b();

			int interactable = buf.g1();
			if (interactable == 1) {
				this.events |= 0x40000000;
			}

			this.iop = new String[5];
			for (int i = 0; i < 5; i++) {
				String op = buf.gjstr();
				if (op.length() > 0) {
					this.iop[i] = op;
					this.events |= 0x1 << i + 23;
				}
			}
		}

		if (this.type == 8) {
			this.text = buf.gjstr();
		}

		if (this.buttonType == 2 || this.type == 2) {
			this.targetVerb = buf.gjstr();
			this.targetText = buf.gjstr();
			int targetMask = buf.g2() & 0x3F;
			this.events |= targetMask << 11;
		}

		if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5 || this.buttonType == 6) {
			this.option = buf.gjstr();

			if (this.option.length() == 0) {
				if (this.buttonType == 1) {
					this.option = Text.OK;
				} else if (this.buttonType == 4) {
					this.option = Text.SELECT;
				} else if (this.buttonType == 5) {
					this.option = Text.SELECT;
				} else if (this.buttonType == 6) {
					this.option = Text.CONTINUE;
				}
			}
		}

		if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5) {
			this.events |= 0x400000;
		}

		if (this.buttonType == 6) {
			this.events |= 0x1;
		}
	}

	// jag::oldscape::rs2lib::IfType::Decode
	@ObfuscatedName("eg.q(Lev;I)V")
	public void decode3(Packet buf) {
		buf.g1();
		this.v3 = true;

		this.type = buf.g1();
		this.clientCode = buf.g2();
		this.x = this.renderx = buf.g2b();
		this.y = this.rendery = buf.g2b();

		this.renderwidth = buf.g2();
		if (this.type == 9) {
			this.renderheight = buf.g2b();
		} else {
			this.renderheight = buf.g2();
		}

		this.layerid = buf.g2();
		if (this.layerid == 65535) {
			this.layerid = -1;
		} else {
			this.layerid += this.parentlayer & 0xFFFF0000;
		}

		this.hide = buf.g1() == 1;

		if (this.type == 0) {
			this.scrollWidth = buf.g2();
			this.scrollHeight = buf.g2();
		}

		if (this.type == 5) {
			this.graphic = buf.g4();
			this.angle2d = buf.g2();
			this.tiling = buf.g1() == 1;
			this.trans = buf.g1();
			this.outline = buf.g1();
			this.graphicshadow = buf.g4();
			this.vflip = buf.g1() == 1;
			this.hflip = buf.g1() == 1;
		}

		if (this.type == 6) {
			this.modelType = 1;
			this.modelId = buf.g2();
			if (this.modelId == 65535) {
				this.modelId = -1;
			}
			this.xof = buf.g2b();
			this.yof = buf.g2b();
			this.modelXan = buf.g2();
			this.modelYan = buf.g2();
			this.zan = buf.g2();
			this.modelZoom = buf.g2();
			this.modelAnim = buf.g2();
			if (this.modelAnim == 65535) {
				this.modelAnim = -1;
			}
			this.modelOrthographic = buf.g1() == 1;
		}

		if (this.type == 4) {
			this.font = buf.g2();
			if (this.font == 65535) {
				this.font = -1;
			}
			this.text = buf.gjstr();
			this.field1832 = buf.g1();
			this.halign = buf.g1();
			this.field1834 = buf.g1();
			this.shadowed = buf.g1() == 1;
			this.colour = buf.g4();
		}

		if (this.type == 3) {
			this.colour = buf.g4();
			this.fill = buf.g1() == 1;
			this.trans = buf.g1();
		}

		if (this.type == 9) {
			this.lineWidth = buf.g1();
			this.colour = buf.g4();
		}

		this.events = buf.g3();
		this.opbase = buf.gjstr();

		int var2 = buf.g1();
		if (var2 > 0) {
			this.ops = new String[var2];
			for (int var3 = 0; var3 < var2; var3++) {
				this.ops[var3] = buf.gjstr();
			}
		}

		this.dragdeadzone = buf.g1();
		this.dragdeadtime = buf.g1();
		this.draggablebehavior = buf.g1() == 1;
		this.targetVerb = buf.gjstr();

		this.onload = this.decodeHook(buf);
		this.onmouseover = this.decodeHook(buf);
		this.onmouseleave = this.decodeHook(buf);
		this.ontargetleave = this.decodeHook(buf);
		this.ontargetenter = this.decodeHook(buf);
		this.onvartransmit = this.decodeHook(buf);
		this.oninvtransmit = this.decodeHook(buf);
		this.onstattransmit = this.decodeHook(buf);
		this.ontimer = this.decodeHook(buf);
		this.onop = this.decodeHook(buf);
		this.onmouserepeat = this.decodeHook(buf);
		this.onclick = this.decodeHook(buf);
		this.onclickrepeat = this.decodeHook(buf);
		this.onrelease = this.decodeHook(buf);
		this.onhold = this.decodeHook(buf);
		this.ondrag = this.decodeHook(buf);
		this.ondragcomplete = this.decodeHook(buf);
		this.onscrollwheel = this.decodeHook(buf);
		this.onvartransmitlist = this.decodeTransmitList(buf);
		this.oninvtransmitlist = this.decodeTransmitList(buf);
		this.onstattransmitlist = this.decodeTransmitList(buf);
	}

	// jag::oldscape::rs2lib::IfType::DecodeHook
	@ObfuscatedName("eg.i(Lev;I)[Ljava/lang/Object;")
	public Object[] decodeHook(Packet arg0) {
		int var2 = arg0.g1();
		if (var2 == 0) {
			return null;
		}
		Object[] var3 = new Object[var2];
		for (int var4 = 0; var4 < var2; var4++) {
			int var5 = arg0.g1();
			if (var5 == 0) {
				var3[var4] = Integer.valueOf(arg0.g4());
			} else if (var5 == 1) {
				var3[var4] = arg0.gjstr();
			}
		}
		this.hashook = true;
		return var3;
	}

	// jag::oldscape::rs2lib::IfType::DecodeTransmitList
	@ObfuscatedName("eg.s(Lev;I)[I")
	public int[] decodeTransmitList(Packet arg0) {
		int var2 = arg0.g1();
		if (var2 == 0) {
			return null;
		}
		int[] var3 = new int[var2];
		for (int var4 = 0; var4 < var2; var4++) {
			var3[var4] = arg0.g4();
		}
		return var3;
	}

	@ObfuscatedName("eg.u(IIB)V")
	public void method1799(int arg0, int arg1) {
		int var3 = this.linkObjType[arg1];
		this.linkObjType[arg1] = this.linkObjType[arg0];
		this.linkObjType[arg0] = var3;
		int var4 = this.linkObjCount[arg1];
		this.linkObjCount[arg1] = this.linkObjCount[arg0];
		this.linkObjCount[arg0] = var4;
	}

	@ObfuscatedName("eg.v(ZB)Lfq;")
	public Pix32 getSprite(boolean arg0) {
		loadingAsset = false;

		int var2;
		if (arg0) {
			var2 = this.graphic2;
		} else {
			var2 = this.graphic;
		}
		if (var2 == -1) {
			return null;
		}

		long var3 = ((long) this.graphicshadow << 40) + ((this.hflip ? 1L : 0L) << 39) + ((this.vflip ? 1L : 0L) << 38) + ((long) this.outline << 36) + (long) var2;
		Pix32 var5 = (Pix32) spriteCache.get(var3);
		if (var5 != null) {
			return var5;
		}

		Js5 var6 = sprites;
		Pix32 var7;
		if (PixLoader.method905(var6, var2, 0)) {
			var7 = PixLoader.method759();
		} else {
			var7 = null;
		}
		if (var7 == null) {
			loadingAsset = true;
			return null;
		}

		if (this.vflip) {
			var7.vflip();
		}
		if (this.hflip) {
			var7.hflip();
		}
		if (this.outline > 0) {
			var7.pad(this.outline);
		}
		if (this.outline >= 1) {
			var7.shadow(1);
		}
		if (this.outline >= 2) {
			var7.shadow(16777215);
		}
		if (this.graphicshadow != 0) {
			var7.method2669(this.graphicshadow);
		}

		spriteCache.put(var7, var3);
		return var7;
	}

	@ObfuscatedName("eg.w(B)Lfm;")
	public SoftwareFont method1800() {
		loadingAsset = false;
		if (this.font == -1) {
			return null;
		}
		SoftwareFont var1 = (SoftwareFont) field1891.get((long) this.font);
		if (var1 != null) {
			return var1;
		}
		Js5 var2 = sprites;
		Js5 var3 = fontMetrics;
		int var4 = this.font;
		SoftwareFont var5;
		if (PixLoader.method905(var2, var4, 0)) {
			var5 = PixLoader.method260(var3.getFile(var4, 0));
		} else {
			var5 = null;
		}
		if (var5 == null) {
			loadingAsset = true;
		} else {
			field1891.put(var5, (long) this.font);
		}
		return var5;
	}

	@ObfuscatedName("eg.e(II)Lfq;")
	public Pix32 method1803(int arg0) {
		loadingAsset = false;
		if (arg0 < 0 || arg0 >= this.invSlotGraphic.length) {
			return null;
		}
		int var2 = this.invSlotGraphic[arg0];
		if (var2 == -1) {
			return null;
		}
		Pix32 var3 = (Pix32) spriteCache.get((long) var2);
		if (var3 != null) {
			return var3;
		}
		Js5 var4 = sprites;
		Pix32 var5;
		if (PixLoader.method905(var4, var2, 0)) {
			var5 = PixLoader.method759();
		} else {
			var5 = null;
		}
		if (var5 == null) {
			loadingAsset = true;
		} else {
			spriteCache.put(var5, (long) var2);
		}
		return var5;
	}

	@ObfuscatedName("eg.b(Leo;IZLct;I)Lfo;")
	public ModelLit method1802(SeqType arg0, int arg1, boolean arg2, PlayerModel arg3) {
		loadingAsset = false;
		int var5;
		int var6;
		if (arg2) {
			var5 = this.model2Type;
			var6 = this.model2Id;
		} else {
			var5 = this.modelType;
			var6 = this.modelId;
		}
		if (var5 == 0) {
			return null;
		} else if (var5 == 1 && var6 == -1) {
			return null;
		} else {
			ModelLit var7 = (ModelLit) field1850.get((long) ((var5 << 16) + var6));
			if (var7 == null) {
				if (var5 == 1) {
					ModelUnlit var8 = ModelUnlit.tryGet(models, var6, 0);
					if (var8 == null) {
						loadingAsset = true;
						return null;
					}
					var7 = var8.light(64, 768, -50, -10, -50);
				}
				if (var5 == 2) {
					ModelUnlit var9 = NpcType.list(var6).getHeadModel();
					if (var9 == null) {
						loadingAsset = true;
						return null;
					}
					var7 = var9.light(64, 768, -50, -10, -50);
				}
				if (var5 == 3) {
					if (arg3 == null) {
						return null;
					}
					ModelUnlit var10 = arg3.getHeadModel();
					if (var10 == null) {
						loadingAsset = true;
						return null;
					}
					var7 = var10.light(64, 768, -50, -10, -50);
				}
				if (var5 == 4) {
					ObjType var11 = ObjType.get(var6);
					ModelUnlit var12 = var11.getInvModel(10);
					if (var12 == null) {
						loadingAsset = true;
						return null;
					}
					var7 = var12.light(var11.ambient + 64, var11.contrast + 768, -50, -10, -50);
				}
				field1850.put(var7, (long) ((var5 << 16) + var6));
			}
			if (arg0 != null) {
				var7 = arg0.method2430(var7, arg1);
			}
			return var7;
		}
	}

	@ObfuscatedName("ch.y(I)V")
	public static void unload() {
		spriteCache.clear();
		field1850.clear();
		field1891.clear();
	}

	@ObfuscatedName("eg.t(ILjava/lang/String;B)V")
	public void method1829(int arg0, String arg1) {
		if (this.ops == null || this.ops.length <= arg0) {
			String[] var3 = new String[arg0 + 1];
			if (this.ops != null) {
				for (int var4 = 0; var4 < this.ops.length; var4++) {
					var3[var4] = this.ops[var4];
				}
			}
			this.ops = var3;
		}
		this.ops[arg0] = arg1;
	}
}
