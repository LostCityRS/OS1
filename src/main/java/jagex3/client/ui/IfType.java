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
import jagex3.graphics.SoftwareFont;
import jagex3.graphics.SpriteDataProvider;
import jagex3.io.Packet;
import jagex3.js5.Js5Index;
import jagex3.jstring.Locale;

@ObfuscatedName("eg")
public class IfType extends Linkable {

	@ObfuscatedName("av.m")
	public static IfType[][] interfaces;

	@ObfuscatedName("df.c")
	public static boolean[] field1508;

	@ObfuscatedName("eg.n")
	public static Js5Index field1806;

	@ObfuscatedName("eg.j")
	public static Js5Index field1776;

	@ObfuscatedName("dc.z")
	public static Js5Index field1564;

	@ObfuscatedName("eg.g")
	public static Js5Index field1800;

	@ObfuscatedName("eg.q")
	public static LruCache field1778 = new LruCache(200);

	@ObfuscatedName("eg.i")
	public static LruCache field1850 = new LruCache(50);

	@ObfuscatedName("eg.s")
	public static LruCache field1891 = new LruCache(20);

	@ObfuscatedName("eg.u")
	public static boolean field1870 = false;

	@ObfuscatedName("eg.v")
	public boolean if3 = false;

	@ObfuscatedName("eg.w")
	public int parentlayer = -1;

	@ObfuscatedName("eg.e")
	public int subid = -1;

	@ObfuscatedName("eg.b")
	public int type;

	@ObfuscatedName("eg.y")
	public int field1790 = 0;

	@ObfuscatedName("eg.t")
	public int buttonType = 0;

	@ObfuscatedName("eg.f")
	public int clientCode = 0;

	@ObfuscatedName("eg.k")
	public int x = 0;

	@ObfuscatedName("eg.o")
	public int y = 0;

	@ObfuscatedName("eg.a")
	public int field1780 = 0;

	@ObfuscatedName("eg.h")
	public int width = 0;

	@ObfuscatedName("eg.x")
	public int height = 0;

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
	public int activeColour = 0;

	@ObfuscatedName("eg.ak")
	public int overColour = 0;

	@ObfuscatedName("eg.az")
	public int activeOverColour = 0;

	@ObfuscatedName("eg.an")
	public boolean fill = false;

	@ObfuscatedName("eg.ah")
	public int trans = 0;

	@ObfuscatedName("eg.ay")
	public int lineWidth = 1;

	@ObfuscatedName("eg.al")
	public int graphic = -1;

	@ObfuscatedName("eg.ab")
	public int activeGraphic = -1;

	@ObfuscatedName("eg.ao")
	public int angle2d = 0;

	@ObfuscatedName("eg.ag")
	public boolean tiling = false;

	@ObfuscatedName("eg.ar")
	public int outline = 0;

	@ObfuscatedName("eg.aq")
	public int graphicShadow = 0;

	@ObfuscatedName("eg.at")
	public boolean vflip;

	@ObfuscatedName("eg.ae")
	public boolean hflip;

	@ObfuscatedName("eg.au")
	public int modelType = 1;

	@ObfuscatedName("eg.ax")
	public int model = -1;

	@ObfuscatedName("eg.ai")
	public int activeModelType = 1;

	@ObfuscatedName("eg.aj")
	public int activeModel = -1;

	@ObfuscatedName("eg.aw")
	public int anim = -1;

	@ObfuscatedName("eg.af")
	public int activeAnim = -1;

	@ObfuscatedName("eg.bh")
	public int xof = 0;

	@ObfuscatedName("eg.bi")
	public int yof = 0;

	@ObfuscatedName("eg.bs")
	public int xan = 0;

	@ObfuscatedName("eg.bk")
	public int yan = 0;

	@ObfuscatedName("eg.bv")
	public int zan = 0;

	@ObfuscatedName("eg.bg")
	public int zoom = 100;

	@ObfuscatedName("eg.bl")
	public int field1827 = 0;

	@ObfuscatedName("eg.bt")
	public boolean modelOrthographic = false;

	@ObfuscatedName("eg.bw")
	public int font = -1;

	@ObfuscatedName("eg.by")
	public String text = "";

	@ObfuscatedName("eg.bx")
	public String activeText = "";

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
	public String field1795 = "";

	@ObfuscatedName("eg.br")
	public String[] field1844;

	@ObfuscatedName("eg.bb")
	public IfType field1845 = null;

	@ObfuscatedName("eg.bd")
	public int field1846 = 0;

	@ObfuscatedName("eg.cr")
	public int field1887 = 0;

	@ObfuscatedName("eg.cs")
	public boolean field1858 = false;

	@ObfuscatedName("eg.cj")
	public String targetVerb = "";

	@ObfuscatedName("eg.cl")
	public boolean field1813 = false;

	@ObfuscatedName("eg.cp")
	public Object[] onload;

	@ObfuscatedName("eg.ca")
	public Object[] field1852;

	@ObfuscatedName("eg.co")
	public Object[] field1853;

	@ObfuscatedName("eg.ch")
	public Object[] field1851;

	@ObfuscatedName("eg.cu")
	public Object[] field1855;

	@ObfuscatedName("eg.cc")
	public Object[] field1856;

	@ObfuscatedName("eg.cm")
	public Object[] field1857;

	@ObfuscatedName("eg.cw")
	public Object[] field1838;

	@ObfuscatedName("eg.cz")
	public Object[] field1781;

	@ObfuscatedName("eg.cv")
	public Object[] field1860;

	@ObfuscatedName("eg.ct")
	public Object[] field1861;

	@ObfuscatedName("eg.ck")
	public Object[] field1836;

	@ObfuscatedName("eg.cy")
	public Object[] field1839;

	@ObfuscatedName("eg.cq")
	public int[] field1889;

	@ObfuscatedName("eg.cd")
	public Object[] field1865;

	@ObfuscatedName("eg.cx")
	public int[] field1866;

	@ObfuscatedName("eg.cn")
	public Object[] field1867;

	@ObfuscatedName("eg.ce")
	public int[] field1868;

	@ObfuscatedName("eg.ci")
	public Object[] field1869;

	@ObfuscatedName("eg.cb")
	public Object[] field1847;

	@ObfuscatedName("eg.cf")
	public Object[] field1831;

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
	public Object[] field1819;

	@ObfuscatedName("eg.da")
	public Object[] field1878;

	@ObfuscatedName("eg.dj")
	public int[][] scripts;

	@ObfuscatedName("eg.dv")
	public int[] scriptComparator;

	@ObfuscatedName("eg.ds")
	public int[] scriptOperand;

	@ObfuscatedName("eg.dh")
	public int field1882 = -1;

	@ObfuscatedName("eg.dc")
	public String targetText = "";

	@ObfuscatedName("eg.dp")
	public String option = Locale.BUTTON_OK;

	@ObfuscatedName("eg.dm")
	public int[] invSlotObjId;

	@ObfuscatedName("eg.di")
	public int[] invSlotObjCount;

	@ObfuscatedName("eg.db")
	public int field1791 = -1;

	@ObfuscatedName("eg.dq")
	public int field1888 = 0;

	@ObfuscatedName("eg.dr")
	public int seqFrame = 0;

	@ObfuscatedName("eg.du")
	public int seqCycle = 0;

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
	public int field1899 = -1;

	@ObfuscatedName("ay.c(Lch;Lch;Lch;Lch;I)V")
	public static void init(Js5Index arg0, Js5Index arg1, Js5Index arg2, Js5Index arg3) {
		field1806 = arg0;
		field1776 = arg1;
		field1564 = arg2;
		field1800 = arg3;
		interfaces = new IfType[field1806.getGroupCount()][];
		field1508 = new boolean[field1806.getGroupCount()];
	}

	@ObfuscatedName("bw.n(IB)Leg;")
	public static IfType get(int arg0) {
		int var1 = arg0 >> 16;
		int var2 = arg0 & 0xFFFF;
		if (interfaces[var1] == null || interfaces[var1][var2] == null) {
			boolean var3 = openInterface(var1);
			if (!var3) {
				return null;
			}
		}
		return interfaces[var1][var2];
	}

	@ObfuscatedName("bd.j(IIB)Leg;")
	public static IfType method947(int arg0, int arg1) {
		IfType var2 = get(arg0);
		if (arg1 == -1) {
			return var2;
		} else if (var2 == null || var2.subcomponents == null || arg1 >= var2.subcomponents.length) {
			return null;
		} else {
			return var2.subcomponents[arg1];
		}
	}

	@ObfuscatedName("dw.z(II)Z")
	public static boolean openInterface(int arg0) {
		if (field1508[arg0]) {
			return true;
		} else if (field1806.isGroupReady(arg0)) {
			int var1 = field1806.getFileCount(arg0);
			if (var1 == 0) {
				field1508[arg0] = true;
				return true;
			}
			if (interfaces[arg0] == null) {
				interfaces[arg0] = new IfType[var1];
			}
			for (int var2 = 0; var2 < var1; var2++) {
				if (interfaces[arg0][var2] == null) {
					byte[] var3 = field1806.getFile(arg0, var2);
					if (var3 != null) {
						interfaces[arg0][var2] = new IfType();
						interfaces[arg0][var2].parentlayer = (arg0 << 16) + var2;
						if (var3[0] == -1) {
							interfaces[arg0][var2].decodeIf3(new Packet(var3));
						} else {
							interfaces[arg0][var2].decodeIf1(new Packet(var3));
						}

						System.out.println(arg0 + ":" + var2 + " " + interfaces[arg0][var2].width + "x" + interfaces[arg0][var2].height + " x:" + interfaces[arg0][var2].x + " y:" + interfaces[arg0][var2].y);
					}
				}
			}
			field1508[arg0] = true;
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("eg.g(Lev;I)V")
	public void decodeIf1(Packet buf) {
		this.if3 = false;

		this.type = buf.g1();
		this.buttonType = buf.g1();
		this.clientCode = buf.g2();
		this.field1790 = this.x = buf.g2b();
		this.field1780 = this.y = buf.g2b();
		this.width = buf.g2();
		this.height = buf.g2();
		this.trans = buf.g1();

		this.layerid = buf.g2();
		if (this.layerid == 65535) {
			this.layerid = -1;
		} else {
			this.layerid += this.parentlayer & 0xFFFF0000;
		}

		this.field1882 = buf.g2();
		if (this.field1882 == 65535) {
			this.field1882 = -1;
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
			this.invSlotObjId = new int[this.height * this.width];
			this.invSlotObjCount = new int[this.height * this.width];

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
			this.activeText = buf.gjstr();
		}

		if (this.type == 1 || this.type == 3 || this.type == 4) {
			this.colour = buf.g4();
		}

		if (this.type == 3 || this.type == 4) {
			this.activeColour = buf.g4();
			this.overColour = buf.g4();
			this.activeOverColour = buf.g4();
		}

		if (this.type == 5) {
			this.graphic = buf.g4();
			this.activeGraphic = buf.g4();
		}

		if (this.type == 6) {
			this.modelType = 1;
			this.model = buf.g2();
			if (this.model == 65535) {
				this.model = -1;
			}

			this.activeModelType = 1;
			this.activeModel = buf.g2();
			if (this.activeModel == 65535) {
				this.activeModel = -1;
			}

			this.anim = buf.g2();
			if (this.anim == 65535) {
				this.anim = -1;
			}

			this.activeAnim = buf.g2();
			if (this.activeAnim == 65535) {
				this.activeAnim = -1;
			}

			this.zoom = buf.g2();
			this.xan = buf.g2();
			this.yan = buf.g2();
		}

		if (this.type == 7) {
			this.invSlotObjId = new int[this.height * this.width];
			this.invSlotObjCount = new int[this.height * this.width];

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
					this.option = Locale.BUTTON_OK;
				} else if (this.buttonType == 4) {
					this.option = Locale.BUTTON_SELECT;
				} else if (this.buttonType == 5) {
					this.option = Locale.BUTTON_SELECT;
				} else if (this.buttonType == 6) {
					this.option = Locale.BUTTON_CONTINUE;
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

	@ObfuscatedName("eg.q(Lev;I)V")
	public void decodeIf3(Packet buf) {
		buf.g1();
		this.if3 = true;

		this.type = buf.g1();
		this.clientCode = buf.g2();
		this.field1790 = this.x = buf.g2b();
		this.field1780 = this.y = buf.g2b();

		this.width = buf.g2();
		if (this.type == 9) {
			this.height = buf.g2b();
		} else {
			this.height = buf.g2();
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
			this.graphicShadow = buf.g4();
			this.vflip = buf.g1() == 1;
			this.hflip = buf.g1() == 1;
		}

		if (this.type == 6) {
			this.modelType = 1;
			this.model = buf.g2();
			if (this.model == 65535) {
				this.model = -1;
			}
			this.xof = buf.g2b();
			this.yof = buf.g2b();
			this.xan = buf.g2();
			this.yan = buf.g2();
			this.zan = buf.g2();
			this.zoom = buf.g2();
			this.anim = buf.g2();
			if (this.anim == 65535) {
				this.anim = -1;
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
		this.field1795 = buf.gjstr();
		int var2 = buf.g1();
		if (var2 > 0) {
			this.field1844 = new String[var2];
			for (int var3 = 0; var3 < var2; var3++) {
				this.field1844[var3] = buf.gjstr();
			}
		}

		this.field1846 = buf.g1();
		this.field1887 = buf.g1();
		this.field1858 = buf.g1() == 1;
		this.targetVerb = buf.gjstr();

		this.onload = this.method1813(buf);
		this.field1856 = this.method1813(buf);
		this.field1838 = this.method1813(buf);
		this.field1836 = this.method1813(buf);
		this.field1861 = this.method1813(buf);
		this.field1839 = this.method1813(buf);
		this.field1865 = this.method1813(buf);
		this.field1867 = this.method1813(buf);
		this.field1869 = this.method1813(buf);
		this.field1847 = this.method1813(buf);
		this.field1857 = this.method1813(buf);
		this.field1852 = this.method1813(buf);
		this.field1853 = this.method1813(buf);
		this.field1851 = this.method1813(buf);
		this.field1855 = this.method1813(buf);
		this.field1781 = this.method1813(buf);
		this.field1860 = this.method1813(buf);
		this.field1831 = this.method1813(buf);
		this.field1889 = this.method1797(buf);
		this.field1866 = this.method1797(buf);
		this.field1868 = this.method1797(buf);
	}

	@ObfuscatedName("eg.i(Lev;I)[Ljava/lang/Object;")
	public Object[] method1813(Packet arg0) {
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
		this.field1813 = true;
		return var3;
	}

	@ObfuscatedName("eg.s(Lev;I)[I")
	public int[] method1797(Packet arg0) {
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
		int var3 = this.invSlotObjId[arg1];
		this.invSlotObjId[arg1] = this.invSlotObjId[arg0];
		this.invSlotObjId[arg0] = var3;
		int var4 = this.invSlotObjCount[arg1];
		this.invSlotObjCount[arg1] = this.invSlotObjCount[arg0];
		this.invSlotObjCount[arg0] = var4;
	}

	@ObfuscatedName("eg.v(ZB)Lfq;")
	public Pix32 method1827(boolean arg0) {
		field1870 = false;
		int var2;
		if (arg0) {
			var2 = this.activeGraphic;
		} else {
			var2 = this.graphic;
		}
		if (var2 == -1) {
			return null;
		}
		long var3 = ((long) this.graphicShadow << 40) + ((this.hflip ? 1L : 0L) << 39) + ((this.vflip ? 1L : 0L) << 38) + ((long) this.outline << 36) + (long) var2;
		Pix32 var5 = (Pix32) field1778.get(var3);
		if (var5 != null) {
			return var5;
		}
		Js5Index var6 = field1564;
		Pix32 var7;
		if (SpriteDataProvider.method905(var6, var2, 0)) {
			var7 = SpriteDataProvider.method759();
		} else {
			var7 = null;
		}
		if (var7 == null) {
			field1870 = true;
			return null;
		}
		if (this.vflip) {
			var7.method2711();
		}
		if (this.hflip) {
			var7.method2666();
		}
		if (this.outline > 0) {
			var7.method2725(this.outline);
		}
		if (this.outline >= 1) {
			var7.method2714(1);
		}
		if (this.outline >= 2) {
			var7.method2714(16777215);
		}
		if (this.graphicShadow != 0) {
			var7.method2669(this.graphicShadow);
		}
		field1778.put(var7, var3);
		return var7;
	}

	@ObfuscatedName("eg.w(B)Lfm;")
	public SoftwareFont method1800() {
		field1870 = false;
		if (this.font == -1) {
			return null;
		}
		SoftwareFont var1 = (SoftwareFont) field1891.get((long) this.font);
		if (var1 != null) {
			return var1;
		}
		Js5Index var2 = field1564;
		Js5Index var3 = field1800;
		int var4 = this.font;
		SoftwareFont var5;
		if (SpriteDataProvider.method905(var2, var4, 0)) {
			var5 = SpriteDataProvider.method260(var3.getFile(var4, 0));
		} else {
			var5 = null;
		}
		if (var5 == null) {
			field1870 = true;
		} else {
			field1891.put(var5, (long) this.font);
		}
		return var5;
	}

	@ObfuscatedName("eg.e(II)Lfq;")
	public Pix32 method1803(int arg0) {
		field1870 = false;
		if (arg0 < 0 || arg0 >= this.invSlotGraphic.length) {
			return null;
		}
		int var2 = this.invSlotGraphic[arg0];
		if (var2 == -1) {
			return null;
		}
		Pix32 var3 = (Pix32) field1778.get((long) var2);
		if (var3 != null) {
			return var3;
		}
		Js5Index var4 = field1564;
		Pix32 var5;
		if (SpriteDataProvider.method905(var4, var2, 0)) {
			var5 = SpriteDataProvider.method759();
		} else {
			var5 = null;
		}
		if (var5 == null) {
			field1870 = true;
		} else {
			field1778.put(var5, (long) var2);
		}
		return var5;
	}

	@ObfuscatedName("eg.b(Leo;IZLct;I)Lfo;")
	public ModelUnlit method1802(SeqType arg0, int arg1, boolean arg2, PlayerModel arg3) {
		field1870 = false;
		int var5;
		int var6;
		if (arg2) {
			var5 = this.activeModelType;
			var6 = this.activeModel;
		} else {
			var5 = this.modelType;
			var6 = this.model;
		}
		if (var5 == 0) {
			return null;
		} else if (var5 == 1 && var6 == -1) {
			return null;
		} else {
			ModelUnlit var7 = (ModelUnlit) field1850.get((long) ((var5 << 16) + var6));
			if (var7 == null) {
				if (var5 == 1) {
					ModelLit var8 = ModelLit.tryGet(field1776, var6, 0);
					if (var8 == null) {
						field1870 = true;
						return null;
					}
					var7 = var8.calculateNormals(64, 768, -50, -10, -50);
				}
				if (var5 == 2) {
					ModelLit var9 = NpcType.get(var6).getHeadModel();
					if (var9 == null) {
						field1870 = true;
						return null;
					}
					var7 = var9.calculateNormals(64, 768, -50, -10, -50);
				}
				if (var5 == 3) {
					if (arg3 == null) {
						return null;
					}
					ModelLit var10 = arg3.method1192();
					if (var10 == null) {
						field1870 = true;
						return null;
					}
					var7 = var10.calculateNormals(64, 768, -50, -10, -50);
				}
				if (var5 == 4) {
					ObjType var11 = ObjType.get(var6);
					ModelLit var12 = var11.getInvModel(10);
					if (var12 == null) {
						field1870 = true;
						return null;
					}
					var7 = var12.calculateNormals(var11.ambient + 64, var11.contrast + 768, -50, -10, -50);
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
		field1778.clear();
		field1850.clear();
		field1891.clear();
	}

	@ObfuscatedName("eg.t(ILjava/lang/String;B)V")
	public void method1829(int arg0, String arg1) {
		if (this.field1844 == null || this.field1844.length <= arg0) {
			String[] var3 = new String[arg0 + 1];
			if (this.field1844 != null) {
				for (int var4 = 0; var4 < this.field1844.length; var4++) {
					var3[var4] = this.field1844[var4];
				}
			}
			this.field1844 = var3;
		}
		this.field1844[arg0] = arg1;
	}
}
