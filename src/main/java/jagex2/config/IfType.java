package jagex2.config;

import deob.ObfuscatedName;
import jagex2.dash3d.PlayerModel;
import jagex2.datastruct.Linkable;
import jagex2.datastruct.LruCache;
import jagex2.graphics.*;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;
import jagex2.jstring.EnglishLocale;

@ObfuscatedName("eg")
public class IfType extends Linkable {

	@ObfuscatedName("av.m")
	public static IfType[][] field373;

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
	public int field1783 = -1;

	@ObfuscatedName("eg.e")
	public int subid = -1;

	@ObfuscatedName("eg.b")
	public int type;

	@ObfuscatedName("eg.y")
	public int field1790 = 0;

	@ObfuscatedName("eg.t")
	public int field1786 = 0;

	@ObfuscatedName("eg.f")
	public int clientCode = 0;

	@ObfuscatedName("eg.k")
	public int field1788 = 0;

	@ObfuscatedName("eg.o")
	public int field1810 = 0;

	@ObfuscatedName("eg.a")
	public int field1780 = 0;

	@ObfuscatedName("eg.h")
	public int width = 0;

	@ObfuscatedName("eg.x")
	public int height = 0;

	@ObfuscatedName("eg.p")
	public int layerid = -1;

	@ObfuscatedName("eg.ad")
	public boolean field1880 = false;

	@ObfuscatedName("eg.ac")
	public int field1796 = 0;

	@ObfuscatedName("eg.aa")
	public int field1797 = 0;

	@ObfuscatedName("eg.as")
	public int field1884 = 0;

	@ObfuscatedName("eg.am")
	public int field1799 = 0;

	@ObfuscatedName("eg.ap")
	public int field1822 = 0;

	@ObfuscatedName("eg.av")
	public int field1801 = 0;

	@ObfuscatedName("eg.ak")
	public int field1802 = 0;

	@ObfuscatedName("eg.az")
	public int field1803 = 0;

	@ObfuscatedName("eg.an")
	public boolean field1893 = false;

	@ObfuscatedName("eg.ah")
	public int field1805 = 0;

	@ObfuscatedName("eg.ay")
	public int field1804 = 1;

	@ObfuscatedName("eg.al")
	public int field1807 = -1;

	@ObfuscatedName("eg.ab")
	public int field1808 = -1;

	@ObfuscatedName("eg.ao")
	public int field1784 = 0;

	@ObfuscatedName("eg.ag")
	public boolean field1794 = false;

	@ObfuscatedName("eg.ar")
	public int field1811 = 0;

	@ObfuscatedName("eg.aq")
	public int field1812 = 0;

	@ObfuscatedName("eg.at")
	public boolean field1849;

	@ObfuscatedName("eg.ae")
	public boolean field1814;

	@ObfuscatedName("eg.au")
	public int field1815 = 1;

	@ObfuscatedName("eg.ax")
	public int field1816 = -1;

	@ObfuscatedName("eg.ai")
	public int field1876 = 1;

	@ObfuscatedName("eg.aj")
	public int field1818 = -1;

	@ObfuscatedName("eg.aw")
	public int field1863 = -1;

	@ObfuscatedName("eg.af")
	public int field1820 = -1;

	@ObfuscatedName("eg.bh")
	public int field1821 = 0;

	@ObfuscatedName("eg.bi")
	public int field1798 = 0;

	@ObfuscatedName("eg.bs")
	public int field1848 = 0;

	@ObfuscatedName("eg.bk")
	public int field1824 = 0;

	@ObfuscatedName("eg.bv")
	public int field1817 = 0;

	@ObfuscatedName("eg.bg")
	public int field1826 = 100;

	@ObfuscatedName("eg.bl")
	public int field1827 = 0;

	@ObfuscatedName("eg.bt")
	public boolean field1828 = false;

	@ObfuscatedName("eg.bw")
	public int field1829 = -1;

	@ObfuscatedName("eg.by")
	public String field1830 = "";

	@ObfuscatedName("eg.bx")
	public String field1809 = "";

	@ObfuscatedName("eg.bf")
	public int field1832 = 0;

	@ObfuscatedName("eg.bu")
	public int field1864 = 0;

	@ObfuscatedName("eg.bo")
	public int field1834 = 0;

	@ObfuscatedName("eg.bq")
	public boolean field1835 = false;

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
	public String field1841 = "";

	@ObfuscatedName("eg.cl")
	public boolean field1813 = false;

	@ObfuscatedName("eg.cp")
	public Object[] field1775;

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
	public int[][] field1874;

	@ObfuscatedName("eg.dv")
	public int[] field1789;

	@ObfuscatedName("eg.ds")
	public int[] field1881;

	@ObfuscatedName("eg.dh")
	public int field1882 = -1;

	@ObfuscatedName("eg.dc")
	public String field1883 = "";

	@ObfuscatedName("eg.dp")
	public String field1859 = EnglishLocale.field966;

	@ObfuscatedName("eg.dm")
	public int[] invSlotObjId;

	@ObfuscatedName("eg.di")
	public int[] invSlotObjCount;

	@ObfuscatedName("eg.db")
	public int field1791 = -1;

	@ObfuscatedName("eg.dq")
	public int field1888 = 0;

	@ObfuscatedName("eg.dr")
	public int field1779 = 0;

	@ObfuscatedName("eg.du")
	public int field1890 = 0;

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
		field373 = new IfType[field1806.getGroupCount()][];
		field1508 = new boolean[field1806.getGroupCount()];
	}

	@ObfuscatedName("bw.n(IB)Leg;")
	public static IfType get(int arg0) {
		int var1 = arg0 >> 16;
		int var2 = arg0 & 0xFFFF;
		if (field373[var1] == null || field373[var1][var2] == null) {
			boolean var3 = method1501(var1);
			if (!var3) {
				return null;
			}
		}
		return field373[var1][var2];
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
	public static boolean method1501(int arg0) {
		if (field1508[arg0]) {
			return true;
		} else if (field1806.isGroupReady(arg0)) {
			int var1 = field1806.getFileCount(arg0);
			if (var1 == 0) {
				field1508[arg0] = true;
				return true;
			}
			if (field373[arg0] == null) {
				field373[arg0] = new IfType[var1];
			}
			for (int var2 = 0; var2 < var1; var2++) {
				if (field373[arg0][var2] == null) {
					byte[] var3 = field1806.getFile(arg0, var2);
					if (var3 != null) {
						field373[arg0][var2] = new IfType();
						field373[arg0][var2].field1783 = (arg0 << 16) + var2;
						if (var3[0] == -1) {
							field373[arg0][var2].decodeIf3(new Packet(var3));
						} else {
							field373[arg0][var2].decodeIf1(new Packet(var3));
						}
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
		this.field1786 = buf.g1();
		this.clientCode = buf.g2();
		this.field1790 = this.field1788 = buf.g2b();
		this.field1780 = this.field1810 = buf.g2b();
		this.width = buf.g2();
		this.height = buf.g2();
		this.field1805 = buf.g1();
		this.layerid = buf.g2();
		if (this.layerid == 65535) {
			this.layerid = -1;
		} else {
			this.layerid += this.field1783 & 0xFFFF0000;
		}
		this.field1882 = buf.g2();
		if (this.field1882 == 65535) {
			this.field1882 = -1;
		}
		int var2 = buf.g1();
		if (var2 > 0) {
			this.field1789 = new int[var2];
			this.field1881 = new int[var2];
			for (int var3 = 0; var3 < var2; var3++) {
				this.field1789[var3] = buf.g1();
				this.field1881[var3] = buf.g2();
			}
		}
		int var4 = buf.g1();
		if (var4 > 0) {
			this.field1874 = new int[var4][];
			for (int var5 = 0; var5 < var4; var5++) {
				int var6 = buf.g2();
				this.field1874[var5] = new int[var6];
				for (int var7 = 0; var7 < var6; var7++) {
					this.field1874[var5][var7] = buf.g2();
					if (this.field1874[var5][var7] == 65535) {
						this.field1874[var5][var7] = -1;
					}
				}
			}
		}
		if (this.type == 0) {
			this.field1799 = buf.g2();
			this.field1880 = buf.g1() == 1;
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
				this.events |= Integer.MIN_VALUE;
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
			for (int var12 = 0; var12 < 20; var12++) {
				int var13 = buf.g1();
				if (var13 == 1) {
					this.invSlotOffsetX[var12] = buf.g2b();
					this.invSlotOffsetY[var12] = buf.g2b();
					this.invSlotGraphic[var12] = buf.g4();
				} else {
					this.invSlotGraphic[var12] = -1;
				}
			}
			this.iop = new String[5];
			for (int var14 = 0; var14 < 5; var14++) {
				String var15 = buf.gjstr();
				if (var15.length() > 0) {
					this.iop[var14] = var15;
					this.events |= 0x1 << var14 + 23;
				}
			}
		}
		if (this.type == 3) {
			this.field1893 = buf.g1() == 1;
		}
		if (this.type == 4 || this.type == 1) {
			this.field1864 = buf.g1();
			this.field1834 = buf.g1();
			this.field1832 = buf.g1();
			this.field1829 = buf.g2();
			if (this.field1829 == 65535) {
				this.field1829 = -1;
			}
			this.field1835 = buf.g1() == 1;
		}
		if (this.type == 4) {
			this.field1830 = buf.gjstr();
			this.field1809 = buf.gjstr();
		}
		if (this.type == 1 || this.type == 3 || this.type == 4) {
			this.field1822 = buf.g4();
		}
		if (this.type == 3 || this.type == 4) {
			this.field1801 = buf.g4();
			this.field1802 = buf.g4();
			this.field1803 = buf.g4();
		}
		if (this.type == 5) {
			this.field1807 = buf.g4();
			this.field1808 = buf.g4();
		}
		if (this.type == 6) {
			this.field1815 = 1;
			this.field1816 = buf.g2();
			if (this.field1816 == 65535) {
				this.field1816 = -1;
			}
			this.field1876 = 1;
			this.field1818 = buf.g2();
			if (this.field1818 == 65535) {
				this.field1818 = -1;
			}
			this.field1863 = buf.g2();
			if (this.field1863 == 65535) {
				this.field1863 = -1;
			}
			this.field1820 = buf.g2();
			if (this.field1820 == 65535) {
				this.field1820 = -1;
			}
			this.field1826 = buf.g2();
			this.field1848 = buf.g2();
			this.field1824 = buf.g2();
		}
		if (this.type == 7) {
			this.invSlotObjId = new int[this.height * this.width];
			this.invSlotObjCount = new int[this.height * this.width];
			this.field1864 = buf.g1();
			this.field1829 = buf.g2();
			if (this.field1829 == 65535) {
				this.field1829 = -1;
			}
			this.field1835 = buf.g1() == 1;
			this.field1822 = buf.g4();
			this.marginX = buf.g2b();
			this.marginY = buf.g2b();
			int var16 = buf.g1();
			if (var16 == 1) {
				this.events |= 0x40000000;
			}
			this.iop = new String[5];
			for (int var17 = 0; var17 < 5; var17++) {
				String var18 = buf.gjstr();
				if (var18.length() > 0) {
					this.iop[var17] = var18;
					this.events |= 0x1 << var17 + 23;
				}
			}
		}
		if (this.type == 8) {
			this.field1830 = buf.gjstr();
		}
		if (this.field1786 == 2 || this.type == 2) {
			this.field1841 = buf.gjstr();
			this.field1883 = buf.gjstr();
			int var19 = buf.g2() & 0x3F;
			this.events |= var19 << 11;
		}
		if (this.field1786 == 1 || this.field1786 == 4 || this.field1786 == 5 || this.field1786 == 6) {
			this.field1859 = buf.gjstr();
			if (this.field1859.length() == 0) {
				if (this.field1786 == 1) {
					this.field1859 = EnglishLocale.field966;
				}
				if (this.field1786 == 4) {
					this.field1859 = EnglishLocale.field1013;
				}
				if (this.field1786 == 5) {
					this.field1859 = EnglishLocale.field1013;
				}
				if (this.field1786 == 6) {
					this.field1859 = EnglishLocale.field872;
				}
			}
		}
		if (this.field1786 == 1 || this.field1786 == 4 || this.field1786 == 5) {
			this.events |= 0x400000;
		}
		if (this.field1786 == 6) {
			this.events |= 0x1;
		}
	}

	@ObfuscatedName("eg.q(Lev;I)V")
	public void decodeIf3(Packet arg0) {
		arg0.g1();
		this.if3 = true;
		this.type = arg0.g1();
		this.clientCode = arg0.g2();
		this.field1790 = this.field1788 = arg0.g2b();
		this.field1780 = this.field1810 = arg0.g2b();
		this.width = arg0.g2();
		if (this.type == 9) {
			this.height = arg0.g2b();
		} else {
			this.height = arg0.g2();
		}
		this.layerid = arg0.g2();
		if (this.layerid == 65535) {
			this.layerid = -1;
		} else {
			this.layerid += this.field1783 & 0xFFFF0000;
		}
		this.field1880 = arg0.g1() == 1;
		if (this.type == 0) {
			this.field1884 = arg0.g2();
			this.field1799 = arg0.g2();
		}
		if (this.type == 5) {
			this.field1807 = arg0.g4();
			this.field1784 = arg0.g2();
			this.field1794 = arg0.g1() == 1;
			this.field1805 = arg0.g1();
			this.field1811 = arg0.g1();
			this.field1812 = arg0.g4();
			this.field1849 = arg0.g1() == 1;
			this.field1814 = arg0.g1() == 1;
		}
		if (this.type == 6) {
			this.field1815 = 1;
			this.field1816 = arg0.g2();
			if (this.field1816 == 65535) {
				this.field1816 = -1;
			}
			this.field1821 = arg0.g2b();
			this.field1798 = arg0.g2b();
			this.field1848 = arg0.g2();
			this.field1824 = arg0.g2();
			this.field1817 = arg0.g2();
			this.field1826 = arg0.g2();
			this.field1863 = arg0.g2();
			if (this.field1863 == 65535) {
				this.field1863 = -1;
			}
			this.field1828 = arg0.g1() == 1;
		}
		if (this.type == 4) {
			this.field1829 = arg0.g2();
			if (this.field1829 == 65535) {
				this.field1829 = -1;
			}
			this.field1830 = arg0.gjstr();
			this.field1832 = arg0.g1();
			this.field1864 = arg0.g1();
			this.field1834 = arg0.g1();
			this.field1835 = arg0.g1() == 1;
			this.field1822 = arg0.g4();
		}
		if (this.type == 3) {
			this.field1822 = arg0.g4();
			this.field1893 = arg0.g1() == 1;
			this.field1805 = arg0.g1();
		}
		if (this.type == 9) {
			this.field1804 = arg0.g1();
			this.field1822 = arg0.g4();
		}
		this.events = arg0.g3();
		this.field1795 = arg0.gjstr();
		int var2 = arg0.g1();
		if (var2 > 0) {
			this.field1844 = new String[var2];
			for (int var3 = 0; var3 < var2; var3++) {
				this.field1844[var3] = arg0.gjstr();
			}
		}
		this.field1846 = arg0.g1();
		this.field1887 = arg0.g1();
		this.field1858 = arg0.g1() == 1;
		this.field1841 = arg0.gjstr();
		this.field1775 = this.method1813(arg0);
		this.field1856 = this.method1813(arg0);
		this.field1838 = this.method1813(arg0);
		this.field1836 = this.method1813(arg0);
		this.field1861 = this.method1813(arg0);
		this.field1839 = this.method1813(arg0);
		this.field1865 = this.method1813(arg0);
		this.field1867 = this.method1813(arg0);
		this.field1869 = this.method1813(arg0);
		this.field1847 = this.method1813(arg0);
		this.field1857 = this.method1813(arg0);
		this.field1852 = this.method1813(arg0);
		this.field1853 = this.method1813(arg0);
		this.field1851 = this.method1813(arg0);
		this.field1855 = this.method1813(arg0);
		this.field1781 = this.method1813(arg0);
		this.field1860 = this.method1813(arg0);
		this.field1831 = this.method1813(arg0);
		this.field1889 = this.method1797(arg0);
		this.field1866 = this.method1797(arg0);
		this.field1868 = this.method1797(arg0);
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
			var2 = this.field1808;
		} else {
			var2 = this.field1807;
		}
		if (var2 == -1) {
			return null;
		}
		long var3 = ((long) this.field1812 << 40) + ((this.field1814 ? 1L : 0L) << 39) + ((this.field1849 ? 1L : 0L) << 38) + ((long) this.field1811 << 36) + (long) var2;
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
		if (this.field1849) {
			var7.method2711();
		}
		if (this.field1814) {
			var7.method2666();
		}
		if (this.field1811 > 0) {
			var7.method2725(this.field1811);
		}
		if (this.field1811 >= 1) {
			var7.method2714(1);
		}
		if (this.field1811 >= 2) {
			var7.method2714(16777215);
		}
		if (this.field1812 != 0) {
			var7.method2669(this.field1812);
		}
		field1778.put(var7, var3);
		return var7;
	}

	@ObfuscatedName("eg.w(B)Lfm;")
	public SoftwareFont method1800() {
		field1870 = false;
		if (this.field1829 == -1) {
			return null;
		}
		SoftwareFont var1 = (SoftwareFont) field1891.get((long) this.field1829);
		if (var1 != null) {
			return var1;
		}
		Js5Index var2 = field1564;
		Js5Index var3 = field1800;
		int var4 = this.field1829;
		SoftwareFont var5;
		if (SpriteDataProvider.method905(var2, var4, 0)) {
			var5 = SpriteDataProvider.method260(var3.getFile(var4, 0));
		} else {
			var5 = null;
		}
		if (var5 == null) {
			field1870 = true;
		} else {
			field1891.put(var5, (long) this.field1829);
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
	public SoftwareModel method1802(SeqType arg0, int arg1, boolean arg2, PlayerModel arg3) {
		field1870 = false;
		int var5;
		int var6;
		if (arg2) {
			var5 = this.field1876;
			var6 = this.field1818;
		} else {
			var5 = this.field1815;
			var6 = this.field1816;
		}
		if (var5 == 0) {
			return null;
		} else if (var5 == 1 && var6 == -1) {
			return null;
		} else {
			SoftwareModel var7 = (SoftwareModel) field1850.get((long) ((var5 << 16) + var6));
			if (var7 == null) {
				if (var5 == 1) {
					Model var8 = Model.tryGet(field1776, var6, 0);
					if (var8 == null) {
						field1870 = true;
						return null;
					}
					var7 = var8.method2942(64, 768, -50, -10, -50);
				}
				if (var5 == 2) {
					Model var9 = NpcType.get(var6).method2331();
					if (var9 == null) {
						field1870 = true;
						return null;
					}
					var7 = var9.method2942(64, 768, -50, -10, -50);
				}
				if (var5 == 3) {
					if (arg3 == null) {
						return null;
					}
					Model var10 = arg3.method1192();
					if (var10 == null) {
						field1870 = true;
						return null;
					}
					var7 = var10.method2942(64, 768, -50, -10, -50);
				}
				if (var5 == 4) {
					ObjType var11 = ObjType.get(var6);
					Model var12 = var11.method2521(10);
					if (var12 == null) {
						field1870 = true;
						return null;
					}
					var7 = var12.method2942(var11.ambient + 64, var11.contrast + 768, -50, -10, -50);
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
	public static void method1104() {
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
