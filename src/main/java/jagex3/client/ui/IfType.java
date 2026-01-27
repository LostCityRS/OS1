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

// jag::oldscape::rs2lib::IfType
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

	// jag::oldscape::rs2lib::IfType::m_pModels
	@ObfuscatedName("eg.j")
	public static Js5 models;

	// jag::oldscape::rs2lib::IfType::m_pSprites
	@ObfuscatedName("dc.z")
	public static Js5 sprites;

	// jag::oldscape::rs2lib::IfType::m_pFontMetrics
	@ObfuscatedName("eg.g")
	public static Js5 fontMetrics;

	// jag::oldscape::rs2lib::IfType::m_spriteCache
	@ObfuscatedName("eg.q")
	public static LruCache spriteCache = new LruCache(200);

	// jag::oldscape::rs2lib::IfType::m_modelCache
	@ObfuscatedName("eg.i")
	public static LruCache modelCache = new LruCache(50);

	// jag::oldscape::rs2lib::IfType::m_fontCache
	@ObfuscatedName("eg.s")
	public static LruCache fontCache = new LruCache(20);

	@ObfuscatedName("eg.u")
	public static boolean loadingAsset = false;

	@ObfuscatedName("eg.v")
	public boolean v3 = false;

	@ObfuscatedName("eg.w")
	public int parentId = -1;

	@ObfuscatedName("eg.e")
	public int subId = -1;

	// 0 - layer
	// 1 - unknown
	// 2 - inv
	// 3 - rect
	// 4 - text
	// 5 - graphic
	// 6 - model
	// 7 - invtext
	// 8 - tooltip
	// 9 - line
	@ObfuscatedName("eg.b")
	public int type;

	@ObfuscatedName("eg.y")
	public int dataX = 0;

	@ObfuscatedName("eg.t")
	public int buttonType = 0;

	@ObfuscatedName("eg.f")
	public int clientCode = 0;

	@ObfuscatedName("eg.k")
	public int x = 0;

	@ObfuscatedName("eg.o")
	public int y = 0;

	@ObfuscatedName("eg.a")
	public int dataY = 0;

	@ObfuscatedName("eg.h")
	public int width = 0;

	@ObfuscatedName("eg.x")
	public int height = 0;

	@ObfuscatedName("eg.p")
	public int layerId = -1;

	@ObfuscatedName("eg.ad")
	public boolean hide = false;

	@ObfuscatedName("eg.ac")
	public int scrollPosX = 0;

	@ObfuscatedName("eg.aa")
	public int scrollPosY = 0;

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
	public int rotate = 0;

	@ObfuscatedName("eg.ag")
	public boolean tiling = false;

	@ObfuscatedName("eg.ar")
	public int outline = 0;

	@ObfuscatedName("eg.aq")
	public int shadowColour = 0;

	@ObfuscatedName("eg.at")
	public boolean vFlip;

	@ObfuscatedName("eg.ae")
	public boolean hFlip;

	@ObfuscatedName("eg.au")
	public int model1Type = 1;

	@ObfuscatedName("eg.ax")
	public int model1Id = -1;

	@ObfuscatedName("eg.ai")
	public int model2Type = 1;

	@ObfuscatedName("eg.aj")
	public int model2Id = -1;

	@ObfuscatedName("eg.aw")
	public int modelAnim = -1;

	@ObfuscatedName("eg.af")
	public int modelAnim2 = -1;

	@ObfuscatedName("eg.bh")
	public int modelXOf = 0;

	@ObfuscatedName("eg.bi")
	public int modelYOf = 0;

	@ObfuscatedName("eg.bs")
	public int modelXAn = 0;

	@ObfuscatedName("eg.bk")
	public int modelYAn = 0;

	@ObfuscatedName("eg.bv")
	public int modelZAn = 0;

	@ObfuscatedName("eg.bg")
	public int modelZoom = 100;

	@ObfuscatedName("eg.bl")
	public int field1827 = 0;

	@ObfuscatedName("eg.bt")
	public boolean orthog = false;

	@ObfuscatedName("eg.bw")
	public int font = -1;

	@ObfuscatedName("eg.by")
	public String text = "";

	@ObfuscatedName("eg.bx")
	public String text2 = "";

	@ObfuscatedName("eg.bf")
	public int lineHeight = 0;

	@ObfuscatedName("eg.bu")
	public int hAlign = 0;

	@ObfuscatedName("eg.bo")
	public int vAlign = 0;

	@ObfuscatedName("eg.bq")
	public boolean shadow = false;

	@ObfuscatedName("eg.bj")
	public int marginX = 0;

	@ObfuscatedName("eg.bz")
	public int marginY = 0;

	@ObfuscatedName("eg.bm")
	public int[] invBackgroundX;

	@ObfuscatedName("eg.bn")
	public int[] invBackgroundY;

	@ObfuscatedName("eg.be")
	public int[] invBackground;

	@ObfuscatedName("eg.bp")
	public String[] iop;

	@ObfuscatedName("eg.ba")
	public int eventCode = 0;

	@ObfuscatedName("eg.bc")
	public String baseOpName = "";

	@ObfuscatedName("eg.br")
	public String[] opNames;

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
	public Object[] onchattransmit;

	@ObfuscatedName("eg.dd")
	public Object[] onkey;

	@ObfuscatedName("eg.dg")
	public Object[] onfriendtransmit;

	@ObfuscatedName("eg.df")
	public Object[] onclantransmit;

	@ObfuscatedName("eg.dk")
	public Object[] onmisctransmit;

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
	public int overLayerId = -1;

	@ObfuscatedName("eg.dc")
	public String targetBase = "";

	@ObfuscatedName("eg.dp")
	public String buttonText = Text.OK;

	@ObfuscatedName("eg.dm")
	public int[] linkObjType;

	@ObfuscatedName("eg.di")
	public int[] linkObjNumber;

	@ObfuscatedName("eg.db")
	public int invobject = -1;

	@ObfuscatedName("eg.dq")
	public int invcount = 0;

	@ObfuscatedName("eg.dr")
	public int animFrame = 0;

	@ObfuscatedName("eg.du")
	public int animCycle = 0;

	@ObfuscatedName("eg.dy")
	public IfType[] subcomponents;

	@ObfuscatedName("eg.de")
	public boolean mouseTrigger = false;

	@ObfuscatedName("eg.dw")
	public boolean clickTrigger = false;

	@ObfuscatedName("eg.dl")
	public int transmitNum = -1;

	@ObfuscatedName("eg.dn")
	public int varTransmitNum = 0;

	@ObfuscatedName("eg.do")
	public int invTransmitNum = 0;

	@ObfuscatedName("eg.dx")
	public int statTransmitNum = 0;

	@ObfuscatedName("eg.dt")
	public int drawCount = -1;

	@ObfuscatedName("eg.eb")
	public int drawTime = -1;

	// jag::oldscape::rs2lib::IfType::Init
	@ObfuscatedName("ay.c(Lch;Lch;Lch;Lch;I)V")
	public static void init(Js5 arg0, Js5 arg1, Js5 arg2, Js5 arg3) {
		interfaces = arg0;
		models = arg1;
		sprites = arg2;
		fontMetrics = arg3;

		list = new IfType[interfaces.getGroupCount()][];
		open = new boolean[interfaces.getGroupCount()];
	}

	// jag::oldscape::rs2lib::IfType::Get
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

	// jag::oldscape::rs2lib::IfType::Get
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
			list[id][sub].parentId = (id << 16) + sub;
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
		this.dataX = this.x = buf.g2b();
		this.dataY = this.y = buf.g2b();
		this.width = buf.g2();
		this.height = buf.g2();
		this.trans = buf.g1();

		this.layerId = buf.g2();
		if (this.layerId == 65535) {
			this.layerId = -1;
		} else {
			this.layerId += this.parentId & 0xFFFF0000;
		}

		this.overLayerId = buf.g2();
		if (this.overLayerId == 65535) {
			this.overLayerId = -1;
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
			// layer
			this.scrollHeight = buf.g2();
			this.hide = buf.g1() == 1;
		}

		if (this.type == 1) {
			// unknown
			buf.g2();
			buf.g1();
		}

		if (this.type == 2) {
			// inv
			this.linkObjType = new int[this.height * this.width];
			this.linkObjNumber = new int[this.height * this.width];

			int draggable = buf.g1();
			if (draggable == 1) {
				this.eventCode |= 0x10000000;
			}

			int interactable = buf.g1();
			if (interactable == 1) {
				this.eventCode |= 0x40000000;
			}

			int usable = buf.g1();
			if (usable == 1) {
				this.eventCode |= 0x80000000;
			}

			int swappable = buf.g1();
			if (swappable == 1) {
				this.eventCode |= 0x20000000;
			}

			this.marginX = buf.g1();
			this.marginY = buf.g1();

			this.invBackgroundX = new int[20];
			this.invBackgroundY = new int[20];
			this.invBackground = new int[20];

			for (int i = 0; i < 20; i++) {
				int hasGraphic = buf.g1();
				if (hasGraphic == 1) {
					this.invBackgroundX[i] = buf.g2b();
					this.invBackgroundY[i] = buf.g2b();
					this.invBackground[i] = buf.g4();
				} else {
					this.invBackground[i] = -1;
				}
			}

			this.iop = new String[5];
			for (int i = 0; i < 5; i++) {
				String op = buf.gjstr();
				if (op.length() > 0) {
					this.iop[i] = op;
					this.eventCode |= 0x1 << (i + 23);
				}
			}
		}

		if (this.type == 3) {
			// rect
			this.fill = buf.g1() == 1;
		}

		if (this.type == 4 || this.type == 1) {
			// text || unknown
			this.hAlign = buf.g1();
			this.vAlign = buf.g1();
			this.lineHeight = buf.g1();

			this.font = buf.g2();
			if (this.font == 65535) {
				this.font = -1;
			}

			this.shadow = buf.g1() == 1;
		}

		if (this.type == 4) {
			// text
			this.text = buf.gjstr();
			this.text2 = buf.gjstr();
		}

		if (this.type == 1 || this.type == 3 || this.type == 4) {
			// unknown || rect || text
			this.colour = buf.g4();
		}

		if (this.type == 3 || this.type == 4) {
			// rect || text
			this.colour2 = buf.g4();
			this.colourOver = buf.g4();
			this.colour2Over = buf.g4();
		}

		if (this.type == 5) {
			// graphic
			this.graphic = buf.g4();
			this.graphic2 = buf.g4();
		}

		if (this.type == 6) {
			// model
			this.model1Type = 1;
			this.model1Id = buf.g2();
			if (this.model1Id == 65535) {
				this.model1Id = -1;
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

			this.modelAnim2 = buf.g2();
			if (this.modelAnim2 == 65535) {
				this.modelAnim2 = -1;
			}

			this.modelZoom = buf.g2();
			this.modelXAn = buf.g2();
			this.modelYAn = buf.g2();
		}

		if (this.type == 7) {
			// invtext
			this.linkObjType = new int[this.height * this.width];
			this.linkObjNumber = new int[this.height * this.width];

			this.hAlign = buf.g1();
			this.font = buf.g2();
			if (this.font == 65535) {
				this.font = -1;
			}

			this.shadow = buf.g1() == 1;
			this.colour = buf.g4();
			this.marginX = buf.g2b();
			this.marginY = buf.g2b();

			int interactable = buf.g1();
			if (interactable == 1) {
				this.eventCode |= 0x40000000;
			}

			this.iop = new String[5];
			for (int i = 0; i < 5; i++) {
				String op = buf.gjstr();
				if (op.length() > 0) {
					this.iop[i] = op;
					this.eventCode |= 0x1 << i + 23;
				}
			}
		}

		if (this.type == 8) {
			// tooltip
			this.text = buf.gjstr();
		}

		if (this.buttonType == 2 || this.type == 2) {
			this.targetVerb = buf.gjstr();
			this.targetBase = buf.gjstr();

			int targetMask = buf.g2() & 0x3F;
			this.eventCode |= targetMask << 11;
		}

		if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5 || this.buttonType == 6) {
			this.buttonText = buf.gjstr();

			if (this.buttonText.length() == 0) {
				if (this.buttonType == 1) {
					this.buttonText = Text.OK;
				} else if (this.buttonType == 4) {
					this.buttonText = Text.SELECT;
				} else if (this.buttonType == 5) {
					this.buttonText = Text.SELECT;
				} else if (this.buttonType == 6) {
					this.buttonText = Text.CONTINUE;
				}
			}
		}

		if (this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5) {
			this.eventCode |= 0x400000;
		}

		if (this.buttonType == 6) {
			// pause
			this.eventCode |= 0x1;
		}
	}

	// jag::oldscape::rs2lib::IfType::Decode
	@ObfuscatedName("eg.q(Lev;I)V")
	public void decode3(Packet buf) {
		buf.g1();
		this.v3 = true;

		this.type = buf.g1();
		this.clientCode = buf.g2();
		this.dataX = this.x = buf.g2b();
		this.dataY = this.y = buf.g2b();

		this.width = buf.g2();
		if (this.type == 9) {
			// line
			this.height = buf.g2b();
		} else {
			this.height = buf.g2();
		}

		this.layerId = buf.g2();
		if (this.layerId == 65535) {
			this.layerId = -1;
		} else {
			this.layerId += this.parentId & 0xFFFF0000;
		}

		this.hide = buf.g1() == 1;

		if (this.type == 0) {
			// layer
			this.scrollWidth = buf.g2();
			this.scrollHeight = buf.g2();
		}

		if (this.type == 5) {
			// graphic
			this.graphic = buf.g4();
			this.rotate = buf.g2();
			this.tiling = buf.g1() == 1;
			this.trans = buf.g1();
			this.outline = buf.g1();
			this.shadowColour = buf.g4();
			this.vFlip = buf.g1() == 1;
			this.hFlip = buf.g1() == 1;
		}

		if (this.type == 6) {
			// model
			this.model1Type = 1;

			this.model1Id = buf.g2();
			if (this.model1Id == 65535) {
				this.model1Id = -1;
			}

			this.modelXOf = buf.g2b();
			this.modelYOf = buf.g2b();
			this.modelXAn = buf.g2();
			this.modelYAn = buf.g2();
			this.modelZAn = buf.g2();
			this.modelZoom = buf.g2();

			this.modelAnim = buf.g2();
			if (this.modelAnim == 65535) {
				this.modelAnim = -1;
			}

			this.orthog = buf.g1() == 1;
		}

		if (this.type == 4) {
			// text
			this.font = buf.g2();
			if (this.font == 65535) {
				this.font = -1;
			}

			this.text = buf.gjstr();
			this.lineHeight = buf.g1();
			this.hAlign = buf.g1();
			this.vAlign = buf.g1();
			this.shadow = buf.g1() == 1;
			this.colour = buf.g4();
		}

		if (this.type == 3) {
			// rect
			this.colour = buf.g4();
			this.fill = buf.g1() == 1;
			this.trans = buf.g1();
		}

		if (this.type == 9) {
			// line
			this.lineWidth = buf.g1();
			this.colour = buf.g4();
		}

		this.eventCode = buf.g3();
		this.baseOpName = buf.gjstr();

		int ops = buf.g1();
		if (ops > 0) {
			this.opNames = new String[ops];
			for (int i = 0; i < ops; i++) {
				this.opNames[i] = buf.gjstr();
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

	// jag::oldscape::rs2lib::IfType::SwapSlots
	@ObfuscatedName("eg.u(IIB)V")
	public void swapSlots(int arg0, int arg1) {
		int var3 = this.linkObjType[arg1];
		this.linkObjType[arg1] = this.linkObjType[arg0];
		this.linkObjType[arg0] = var3;
		int var4 = this.linkObjNumber[arg1];
		this.linkObjNumber[arg1] = this.linkObjNumber[arg0];
		this.linkObjNumber[arg0] = var4;
	}

	// jag::oldscape::rs2lib::IfType::GetGraphic
	@ObfuscatedName("eg.v(ZB)Lfq;")
	public Pix32 getGraphic(boolean arg0) {
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

		long var3 = ((long) this.shadowColour << 40) + ((this.hFlip ? 1L : 0L) << 39) + ((this.vFlip ? 1L : 0L) << 38) + ((long) this.outline << 36) + (long) var2;
		Pix32 var5 = (Pix32) spriteCache.find(var3);
		if (var5 != null) {
			return var5;
		}

		// todo: Inlined method (pixloader::Makepix32?)
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

		// jag::oldscape::rs2lib::IfType::PrerenderProcessSprite
		if (this.vFlip) {
			var7.vflip();
		}
		if (this.hFlip) {
			var7.hflip();
		}
		if (this.outline > 0) {
			var7.untrim(this.outline);
		}
		if (this.outline >= 1) {
			var7.addOutline(1);
		}
		if (this.outline >= 2) {
			var7.addOutline(16777215);
		}
		if (this.shadowColour != 0) {
			var7.addShadow(this.shadowColour);
		}

		spriteCache.put(var7, var3);
		return var7;
	}

	// jag::oldscape::rs2lib::IfType::GetFont
	@ObfuscatedName("eg.w(B)Lfm;")
	public SoftwareFont getFont() {
		loadingAsset = false;
		if (this.font == -1) {
			return null;
		}
		SoftwareFont var1 = (SoftwareFont) fontCache.find((long) this.font);
		if (var1 != null) {
			return var1;
		}
		// todo: inlined method (SoftwareFont::Load?)
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
			fontCache.put(var5, (long) this.font);
		}
		return var5;
	}

	// jag::oldscape::rs2lib::IfType::GetInvBackground
	@ObfuscatedName("eg.e(II)Lfq;")
	public Pix32 getInvBackground(int arg0) {
		loadingAsset = false;
		if (arg0 < 0 || arg0 >= this.invBackground.length) {
			return null;
		}
		int var2 = this.invBackground[arg0];
		if (var2 == -1) {
			return null;
		}
		Pix32 var3 = (Pix32) spriteCache.find((long) var2);
		if (var3 != null) {
			return var3;
		}
		// todo: Inlined method (pixloader::Makepix32?)
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

	// jag::oldscape::rs2lib::IfType::GetTempModel
	@ObfuscatedName("eg.b(Leo;IZLct;I)Lfo;")
	public ModelLit getTempModel(SeqType arg0, int arg1, boolean arg2, PlayerModel player) {
		loadingAsset = false;

		int type;
		int id;
		if (arg2) {
			type = this.model2Type;
			id = this.model2Id;
		} else {
			type = this.model1Type;
			id = this.model1Id;
		}

		if (type == 0) {
			return null;
		} else if (type == 1 && id == -1) {
			return null;
		}

		ModelLit var7 = (ModelLit) modelCache.find((long) ((type << 16) + id));
		if (var7 == null) {
			if (type == 1) {
				// basic
				ModelUnlit var8 = ModelUnlit.load(models, id, 0);
				if (var8 == null) {
					loadingAsset = true;
					return null;
				}

				var7 = var8.light(64, 768, -50, -10, -50);
			}

			if (type == 2) {
				// npc_head
				ModelUnlit var9 = NpcType.list(id).getHead();
				if (var9 == null) {
					loadingAsset = true;
					return null;
				}

				var7 = var9.light(64, 768, -50, -10, -50);
			}

			if (type == 3) {
				// player_head
				if (player == null) {
					return null;
				}

				ModelUnlit var10 = player.getHeadModel();
				if (var10 == null) {
					loadingAsset = true;
					return null;
				}

				var7 = var10.light(64, 768, -50, -10, -50);
			}

			if (type == 4) {
				// object
				ObjType var11 = ObjType.list(id);
				ModelUnlit var12 = var11.getModelUnlit(10);
				if (var12 == null) {
					loadingAsset = true;
					return null;
				}

				var7 = var12.light(var11.ambient + 64, var11.contrast + 768, -50, -10, -50);
			}

			modelCache.put(var7, ((long) type << 16) + id);
		}

		if (arg0 != null) {
			var7 = arg0.animateModelWithExtra(var7, arg1);
		}

		return var7;
	}

	// jag::oldscape::rs2lib::IfType::ResetCache
	@ObfuscatedName("ch.y(I)V")
	public static void resetCache() {
		spriteCache.clear();
		modelCache.clear();
		fontCache.clear();
	}

	// jag::oldscape::rs2lib::IfType::SetOpName
	@ObfuscatedName("eg.t(ILjava/lang/String;B)V")
	public void setOpName(int arg0, String arg1) {
		if (this.opNames == null || this.opNames.length <= arg0) {
			String[] var3 = new String[arg0 + 1];
			if (this.opNames != null) {
				for (int var4 = 0; var4 < this.opNames.length; var4++) {
					var3[var4] = this.opNames[var4];
				}
			}
			this.opNames = var3;
		}

		this.opNames[arg0] = arg1;
	}
}
