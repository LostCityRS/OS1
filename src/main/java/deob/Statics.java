package deob;

import jagex2.client.*;
import jagex2.config.*;
import jagex2.dash3d.*;
import jagex2.datastruct.LinkList;
import jagex2.datastruct.TextUtil;
import jagex2.datastruct.Timer;
import jagex2.graphics.*;
import jagex2.io.BufferedFile;
import jagex2.io.ClientStream;
import jagex2.io.FileStream;
import jagex2.io.Packet;
import jagex2.js5.*;
import jagex2.jstring.EnglishLocale;
import jagex2.jstring.JString;
import jagex2.sound.*;
import jagex2.wordenc.Huffman;

import java.applet.Applet;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Statics {

	@ObfuscatedName("r.pa")
	public static FileStream field10;

	@ObfuscatedName("bc.i")
	public static Timer field1100;

	@ObfuscatedName("br.bz")
	public static ClientStream field1102;

	@ObfuscatedName("br.om")
	public static int field1103;

	@ObfuscatedName("bb.i")
	public static IfType field1108;

	@ObfuscatedName("bb.bp")
	public static Js5Provider field1109;

	@ObfuscatedName("bb.cr")
	public static Js5Provider field1110;

	@ObfuscatedName("bb.j")
	public static Js5Index field1111;

	@ObfuscatedName("bb.gk")
	public static int field1112;

	@ObfuscatedName("bd.s")
	public static Song field1113;

	@ObfuscatedName("bd.d")
	public static Js5Index field1114;

	@ObfuscatedName("bd.l")
	public static Js5Index field1115;

	@ObfuscatedName("bd.m")
	public static MidiPcmStream field1116;

	@ObfuscatedName("bd.n")
	public static Js5Index field1118;

	@ObfuscatedName("bd.r")
	public static Js5Index field1119;

	@ObfuscatedName("bd.g")
	public static int field1120;

	@ObfuscatedName("bd.z")
	public static int field1121;

	@ObfuscatedName("bd.dq")
	public static SoftwareFont field1122;

	@ObfuscatedName("bd.br")
	public static Js5Provider field1123;

	@ObfuscatedName("cr.eg")
	public static World3D field1133;

	@ObfuscatedName("cr.ii")
	public static PlayerEntity field1134;

	@ObfuscatedName("n.cm")
	public static int field114;

	@ObfuscatedName("cj.ch")
	public static Js5Provider field1150;

	@ObfuscatedName("cl.j")
	public static int[] field1151;

	@ObfuscatedName("cl.q")
	public static int field1152;

	@ObfuscatedName("cp.fa")
	public static Pix32[] field1157;

	@ObfuscatedName("ca.f")
	public static Font field1159;

	@ObfuscatedName("ca.gv")
	public static int field1160;

	@ObfuscatedName("ca.jf")
	public static int field1161;

	@ObfuscatedName("ca.cc")
	public static char field1162;

	@ObfuscatedName("co.ei")
	public static int[] field1163;

	@ObfuscatedName("co.op")
	public static int field1164;

	@ObfuscatedName("cu.u")
	public static boolean field1194;

	@ObfuscatedName("cu.e")
	public static Packet field1196;

	@ObfuscatedName("j.j")
	public static Js5Index field120;

	@ObfuscatedName("cu.cd")
	public static int field1204;

	@ObfuscatedName("cc.bc")
	public static Js5Provider field1209;

	@ObfuscatedName("cz.ny")
	public static byte field1217;

	@ObfuscatedName("cv.e")
	public static int field1218;

	@ObfuscatedName("cv.ll")
	public static int field1219;

	@ObfuscatedName("cv.nm")
	public static int field1220;

	@ObfuscatedName("cv.hg")
	public static IfType field1221;

	@ObfuscatedName("ct.g")
	public static short[] field1224;

	@ObfuscatedName("ct.q")
	public static short[][] field1229;

	@ObfuscatedName("ct.co")
	public static Js5Provider field1232;

	@ObfuscatedName("ct.gw")
	public static int field1233;

	@ObfuscatedName("ct.or")
	public static int field1234;

	@ObfuscatedName("z.ap")
	public static boolean field125;

	@ObfuscatedName("z.cc")
	public static Js5Provider field126;

	@ObfuscatedName("ck.bd")
	public static Js5Provider field1270;

	@ObfuscatedName("ck.ha")
	public static IfType field1271;

	@ObfuscatedName("d.cq")
	public static int field13;

	@ObfuscatedName("g.j")
	public static Pix8 field131;

	@ObfuscatedName("g.z")
	public static Pix8[] field132;

	@ObfuscatedName("g.d")
	public static Pix8 field137;

	@ObfuscatedName("g.e")
	public static int[] field140;

	@ObfuscatedName("g.t")
	public static int[] field141;

	@ObfuscatedName("g.h")
	public static int[] field144;

	@ObfuscatedName("g.c")
	public static Pix32 field146;

	@ObfuscatedName("cq.oc")
	public static MixerPcmStream field1460;

	@ObfuscatedName("cq.ob")
	public static int field1461;

	@ObfuscatedName("cq.z")
	public static boolean field1462;

	@ObfuscatedName("cd.dn")
	public static int field1473;

	@ObfuscatedName("cd.fi")
	public static int[] field1474;

	@ObfuscatedName("cd.ad")
	public static Image field1475;

	@ObfuscatedName("cx.et")
	public static int field1485;

	@ObfuscatedName("df.r")
	public static boolean field1507;

	@ObfuscatedName("df.c")
	public static boolean[] field1508;

	@ObfuscatedName("df.bb")
	public static Js5Provider field1509;

	@ObfuscatedName("df.fr")
	public static Pix32 field1510;

	@ObfuscatedName("df.nr")
	public static byte field1511;

	@ObfuscatedName("df.ou")
	public static int field1512;

	@ObfuscatedName("dz.r")
	public static Huffman field1514;

	@ObfuscatedName("dz.ca")
	public static Js5Provider field1515;

	@ObfuscatedName("dz.lj")
	public static IfType[] field1516;

	@ObfuscatedName("dz.n")
	public static Js5Index field1517;

	@ObfuscatedName("da.i")
	public static int[] field1528;

	@ObfuscatedName("da.ay")
	public static ModeGame field1529;

	@ObfuscatedName("g.l")
	public static Pix8 field153;

	@ObfuscatedName("da.ar")
	public static Pix32[] field1530;

	@ObfuscatedName("dj.j")
	public static int field1537;

	@ObfuscatedName("dj.r")
	public static SignLink field1542;

	@ObfuscatedName("dj.b")
	public static int field1544;

	@ObfuscatedName("dj.o")
	public static PixMap field1546;

	@ObfuscatedName("dv.ac")
	public static AudioSource field1552;

	@ObfuscatedName("dc.z")
	public static Js5Index field1564;

	@ObfuscatedName("dm.ai")
	public static MouseTracking field1568;

	@ObfuscatedName("dm.u")
	public static int[] field1569;

	@ObfuscatedName("dq.oq")
	public static int field1582;

	@ObfuscatedName("dr.oi")
	public static AudioChannel field1585;

	@ObfuscatedName("dr.u")
	public static SoundBank field1586;

	@ObfuscatedName("du.oh")
	public static int field1596;

	@ObfuscatedName("dy.j")
	public static Js5Index field1600;

	@ObfuscatedName("de.oy")
	public static int field1616;

	@ObfuscatedName("dw.db")
	public static SoftwareFont field1621;

	@ObfuscatedName("dl.i")
	public static boolean field1625;

	@ObfuscatedName("dl.gt")
	public static int field1626;

	@ObfuscatedName("dl.ns")
	public static Pix32 field1627;

	@ObfuscatedName("dl.z")
	public static int field1628;

	@ObfuscatedName("dn.cy")
	public static int field1641;

	@ObfuscatedName("dt.ak")
	public static int[] field1647;

	@ObfuscatedName("dt.p")
	public static float[] field1649;

	@ObfuscatedName("g.m")
	public static Pix8[] field165;

	@ObfuscatedName("dt.u")
	public static int field1650;

	@ObfuscatedName("dt.q")
	public static byte[] field1653;

	@ObfuscatedName("dt.i")
	public static int field1654;

	@ObfuscatedName("dt.s")
	public static int field1655;

	@ObfuscatedName("dt.av")
	public static int[] field1656;

	@ObfuscatedName("dt.v")
	public static int field1657;

	@ObfuscatedName("dt.w")
	public static VorbisCookbook[] field1658;

	@ObfuscatedName("dt.e")
	public static VorbisFloor[] field1659;

	@ObfuscatedName("dt.y")
	public static VorbisMapping[] field1661;

	@ObfuscatedName("dt.t")
	public static boolean[] field1662;

	@ObfuscatedName("dt.f")
	public static int[] field1663;

	@ObfuscatedName("dt.b")
	public static VorbisResidue[] field1668;

	@ObfuscatedName("dt.ad")
	public static float[] field1669;

	@ObfuscatedName("dt.ac")
	public static float[] field1671;

	@ObfuscatedName("dt.aa")
	public static float[] field1672;

	@ObfuscatedName("dt.as")
	public static float[] field1673;

	@ObfuscatedName("dt.ap")
	public static float[] field1675;

	@ObfuscatedName("dt.am")
	public static float[] field1678;

	@ObfuscatedName("g.r")
	public static ClientStream field169;

	@ObfuscatedName("er.y")
	public static int[] field1693;

	@ObfuscatedName("g.bu")
	public static PrivilegedRequest field170;

	@ObfuscatedName("g.fo")
	public static int[] field171;

	@ObfuscatedName("es.ba")
	public static Js5Provider field1720;

	@ObfuscatedName("ez.o")
	public static String field1725;

	@ObfuscatedName("ez.fy")
	public static Pix8[] field1726;

	@ObfuscatedName("ez.fk")
	public static Pix32[] field1727;

	@ObfuscatedName("ev.od")
	public static PcmResampler field1733;

	@ObfuscatedName("ef.fx")
	public static Pix32[] field1744;

	@ObfuscatedName("ej.fh")
	public static Pix32[] field1767;

	@ObfuscatedName("ej.ej")
	public static byte[][] field1768;

	@ObfuscatedName("ej.fn")
	public static Pix8[] field1769;

	@ObfuscatedName("eh.nd")
	public static ClanMember[] field1774;

	@ObfuscatedName("eg.j")
	public static Js5Index field1776;

	@ObfuscatedName("l.c")
	public static byte[][][] field18;

	@ObfuscatedName("eg.g")
	public static Js5Index field1800;

	@ObfuscatedName("eg.n")
	public static Js5Index field1806;

	@ObfuscatedName("i.eh")
	public static byte[][] field186;

	@ObfuscatedName("i.ft")
	public static Pix32[] field187;

	@ObfuscatedName("s.d")
	public static int[] field189;

	@ObfuscatedName("l.m")
	public static byte[][][] field19;

	@ObfuscatedName("s.l")
	public static String[] field191;

	@ObfuscatedName("client.be")
	public static long field1943;

	@ObfuscatedName("client.cj")
	public static Js5Provider field1944;

	@ObfuscatedName("client.cl")
	public static Js5Provider field1966;

	@ObfuscatedName("s.f")
	public static String field199;

	@ObfuscatedName("l.j")
	public static byte[][][] field20;

	@ObfuscatedName("l.z")
	public static byte[][][] field21;

	@ObfuscatedName("client.lh")
	public static int field2106;

	@ObfuscatedName("v.ai")
	public static WorldEntry[] field214;

	@ObfuscatedName("v.au")
	public static Pix8 field215;

	@ObfuscatedName("v.an")
	public static ModeWhat field216;

	@ObfuscatedName("v.do")
	public static int field217;

	@ObfuscatedName("e.q")
	public static int[] field223;

	@ObfuscatedName("em.n")
	public static Js5Index field2281;

	@ObfuscatedName("e.i")
	public static int[] field229;

	@ObfuscatedName("l.v")
	public static int[] field23;

	@ObfuscatedName("e.s")
	public static boolean[] field230;

	@ObfuscatedName("ey.z")
	public static Js5Index field2303;

	@ObfuscatedName("ey.j")
	public static int field2352;

	@ObfuscatedName("ey.cu")
	public static Js5Provider field2353;

	@ObfuscatedName("ec.n")
	public static Js5Index field2358;

	@ObfuscatedName("y.d")
	public static boolean field236;

	@ObfuscatedName("eo.z")
	public static Js5Index field2361;

	@ObfuscatedName("y.m")
	public static AudioThread field238;

	@ObfuscatedName("eu.n")
	public static Js5Index field2381;

	@ObfuscatedName("eu.j")
	public static Js5Index field2385;

	@ObfuscatedName("y.l")
	public static int field239;

	@ObfuscatedName("fd.n")
	public static Js5Index field2394;

	@ObfuscatedName("fd.j")
	public static Js5Index field2397;

	@ObfuscatedName("y.r")
	public static int field241;

	@ObfuscatedName("fc.n")
	public static Js5Index field2419;

	@ObfuscatedName("fe.n")
	public static Js5Index field2422;

	@ObfuscatedName("fj.n")
	public static Js5Index field2449;

	@ObfuscatedName("fp.n")
	public static Js5Index field2476;

	@ObfuscatedName("fv.z")
	public static int field2480;

	@ObfuscatedName("fv.j")
	public static int field2481;

	@ObfuscatedName("fv.n")
	public static int[] field2486;

	@ObfuscatedName("fr.k")
	public static FontMetrics field2489;

	@ObfuscatedName("fa.r")
	public static Applet field2495;

	@ObfuscatedName("fa.l")
	public static int field2496;

	@ObfuscatedName("fa.d")
	public static String field2497;

	@ObfuscatedName("fx.a")
	public static int field2529;

	@ObfuscatedName("fx.p")
	public static int field2532;

	@ObfuscatedName("fx.ac")
	public static int field2534;

	@ObfuscatedName("fx.aa")
	public static int field2535;

	@ObfuscatedName("fx.x")
	public static int field2536;

	@ObfuscatedName("fx.as")
	public static int field2537;

	@ObfuscatedName("fx.av")
	public static SceneProvider field2539;

	@ObfuscatedName("fx.h")
	public static int field2541;

	@ObfuscatedName("fx.ad")
	public static int field2542;

	@ObfuscatedName("fs.o")
	public static Pix8[] field2553;

	@ObfuscatedName("l.n")
	public static byte[][][] field26;

	@ObfuscatedName("fn.aq")
	public static Pix8[] field2612;

	@ObfuscatedName("y.gj")
	public static int field262;

	@ObfuscatedName("y.fl")
	public static Pix8[] field263;

	@ObfuscatedName("fo.bl")
	public static int field2762;

	@ObfuscatedName("fo.bt")
	public static int field2771;

	@ObfuscatedName("fo.bw")
	public static int field2772;

	@ObfuscatedName("f.k")
	public static String field294;

	@ObfuscatedName("a.a")
	public static Frame field314;

	@ObfuscatedName("a.de")
	public static int field315;

	@ObfuscatedName("l.s")
	public static int[] field33;

	@ObfuscatedName("p.q")
	public static IfType field335;

	@ObfuscatedName("ad.z")
	public static float field343;

	@ObfuscatedName("ad.g")
	public static int field344;

	@ObfuscatedName("ac.n")
	public static Pix32 field348;

	@ObfuscatedName("aa.j")
	public static int field349;

	@ObfuscatedName("l.ag")
	public static WorldList field35;

	@ObfuscatedName("aa.cs")
	public static Js5Provider field350;

	@ObfuscatedName("as.eq")
	public static int field351;

	@ObfuscatedName("l.bj")
	public static PrivilegedRequest field36;

	@ObfuscatedName("am.ef")
	public static int[][] field362;

	@ObfuscatedName("ap.w")
	public static int field368;

	@ObfuscatedName("av.d")
	public static File field369;

	@ObfuscatedName("l.jy")
	public static IfType field37;

	@ObfuscatedName("av.v")
	public static BufferedFile[] field372;

	@ObfuscatedName("av.m")
	public static IfType[][] field373;

	@ObfuscatedName("ak.d")
	public static String field375;

	@ObfuscatedName("l.on")
	public static AudioChannel field38;

	@ObfuscatedName("ak.r")
	public static String field380;

	@ObfuscatedName("ak.kt")
	public static int field386;

	@ObfuscatedName("m.n")
	public static int[] field41;

	@ObfuscatedName("m.jd")
	public static int field42;

	@ObfuscatedName("m.jv")
	public static int field43;

	@ObfuscatedName("m.la")
	public static int field44;

	@ObfuscatedName("az.lu")
	public static MouseWheelProvider field484;

	@ObfuscatedName("an.o")
	public static int[] field489;

	@ObfuscatedName("an.ix")
	public static int field502;

	@ObfuscatedName("c.j")
	public static short[] field51;

	@ObfuscatedName("ay.n")
	public static int field512;

	@ObfuscatedName("ay.c")
	public static File field515;

	@ObfuscatedName("ay.m")
	public static File field518;

	@ObfuscatedName("c.ck")
	public static String field52;

	@ObfuscatedName("ay.a")
	public static int[] field527;

	@ObfuscatedName("al.r")
	public static int field528;

	@ObfuscatedName("al.z")
	public static int[] field529;

	@ObfuscatedName("c.dg")
	public static ClientStream field53;

	@ObfuscatedName("al.l")
	public static int field530;

	@ObfuscatedName("al.m")
	public static int[] field531;

	@ObfuscatedName("al.c")
	public static int[] field532;

	@ObfuscatedName("al.d")
	public static int field533;

	@ObfuscatedName("al.in")
	public static int field534;

	@ObfuscatedName("al.jt")
	public static int field535;

	@ObfuscatedName("al.fu")
	public static Pix32 field536;

	@ObfuscatedName("al.n")
	public static Js5Index field537;

	@ObfuscatedName("c.h")
	public static Canvas field54;

	@ObfuscatedName("ab.f")
	public static Packet field542;

	@ObfuscatedName("ab.al")
	public static Namespace field543;

	@ObfuscatedName("ab.cp")
	public static Js5Provider field544;

	@ObfuscatedName("ao.t")
	public static int field549;

	@ObfuscatedName("ag.b")
	public static String[] field553;

	@ObfuscatedName("ag.g")
	public static int[][] field554;

	@ObfuscatedName("ag.iz")
	public static int field555;

	@ObfuscatedName("ag.j")
	public static Js5Index field556;

	@ObfuscatedName("ag.jb")
	public static int field557;

	@ObfuscatedName("aq.bw")
	public static int field592;

	@ObfuscatedName("aq.y")
	public static int field597;

	@ObfuscatedName("aq.f")
	public static int field599;

	@ObfuscatedName("aq.o")
	public static int field601;

	@ObfuscatedName("aq.a")
	public static int field602;

	@ObfuscatedName("aq.h")
	public static int field603;

	@ObfuscatedName("aq.p")
	public static int field605;

	@ObfuscatedName("aq.ad")
	public static int field606;

	@ObfuscatedName("aq.as")
	public static int field609;

	@ObfuscatedName("aq.am")
	public static int field610;

	@ObfuscatedName("aq.t")
	public static int field611;

	@ObfuscatedName("aq.bx")
	public static int field613;

	@ObfuscatedName("aq.aa")
	public static int field616;

	@ObfuscatedName("aq.ac")
	public static int field621;

	@ObfuscatedName("aq.k")
	public static int field624;

	@ObfuscatedName("aq.x")
	public static int field626;

	@ObfuscatedName("aq.bv")
	public static boolean[][] field633;

	@ObfuscatedName("aq.bg")
	public static int field637;

	@ObfuscatedName("aq.bl")
	public static int field638;

	@ObfuscatedName("aq.bt")
	public static int field639;

	@ObfuscatedName("aq.by")
	public static int field641;

	@ObfuscatedName("at.dd")
	public static ClientStream field652;

	@ObfuscatedName("at.dw")
	public static int field653;

	@ObfuscatedName("at.jq")
	public static IfType field654;

	@ObfuscatedName("au.mg")
	public static ChatFilterPrivacy field680;

	@ObfuscatedName("au.at")
	public static Pix8[] field681;

	@ObfuscatedName("ax.q")
	public static int[] field690;

	@ObfuscatedName("af.dr")
	public static SoftwareFont field704;

	@ObfuscatedName("bs.ff")
	public static Pix32[] field741;

	@ObfuscatedName("bs.gx")
	public static int field742;

	@ObfuscatedName("bk.ji")
	public static int field743;

	@ObfuscatedName("bv.gn")
	public static int field750;

	@ObfuscatedName("bg.x")
	public static int[] field775;

	@ObfuscatedName("bw.z")
	public static short[][] field800;

	@ObfuscatedName("bw.ez")
	public static int[] field801;

	@ObfuscatedName("by.e")
	public static String[] field805;

	@ObfuscatedName("by.cg")
	public static PrivilegedRequest field806;

	@ObfuscatedName("by.fz")
	public static Pix8 field807;

	@ObfuscatedName("by.n")
	public static Js5Index field808;

	@ObfuscatedName("bx.r")
	public static long field809;

	@ObfuscatedName("bx.d")
	public static long field810;

	@ObfuscatedName("bx.ae")
	public static Pix8[] field811;

	@ObfuscatedName("bx.v")
	public static Js5NetRequest field812;

	@ObfuscatedName("bx.y")
	public static int[] field813;

	@ObfuscatedName("bf.s")
	public static SoftwareFont field815;

	@ObfuscatedName("bf.fq")
	public static Pix32[] field816;

	@ObfuscatedName("bo.l")
	public static long field825;

	@ObfuscatedName("bo.ev")
	public static int[] field826;

	@ObfuscatedName("bq.b")
	public static int[] field827;

	@ObfuscatedName("bq.fs")
	public static Pix32[] field828;

	@ObfuscatedName("bq.fm")
	public static int[] field829;

	@ObfuscatedName("bm.v")
	public static int field833;

	@ObfuscatedName("be.aq")
	public static String field852;

	@ObfuscatedName("be.fw")
	public static int[] field853;

	@ObfuscatedName("be.ox")
	public static int field854;

	@ObfuscatedName("be.hf")
	public static IfType field855;

	@ObfuscatedName("bp.g")
	public static byte[][] field863;

	@ObfuscatedName("bp.w")
	public static int[][][] field864;

	@ObfuscatedName("bp.og")
	public static int field865;

	@ObfuscatedName("r.x")
	public static int[] field9;

	@ObfuscatedName("cu.m(ILap;Ldq;I)V")
	public static void method1122(int arg0, FileStream arg1, Js5Provider arg2) {
		byte[] var3 = null;
		LinkList var4 = Js5ProviderThread.field1208;
		synchronized (Js5ProviderThread.field1208) {
			for (Js5NetProviderRequest var5 = (Js5NetProviderRequest) Js5ProviderThread.field1208.method1297(); var5 != null; var5 = (Js5NetProviderRequest) Js5ProviderThread.field1208.method1299()) {
				if ((long) arg0 == var5.field1506 && var5.field1770 == arg1 && var5.field1772 == 0) {
					var3 = var5.field1771;
					break;
				}
			}
		}
		if (var3 == null) {
			byte[] var7 = arg1.method418(arg0);
			arg2.method1468(arg1, arg0, var7, true);
		} else {
			arg2.method1468(arg1, arg0, var3, true);
		}
	}

	@ObfuscatedName("l.c(Lch;II)Lef;")
	public static MidiInstrument method49(Js5Index arg0, int arg1) {
		byte[] var2 = arg0.method1092(arg1);
		return var2 == null ? null : new MidiInstrument(var2);
	}

	@ObfuscatedName("i.d(II)Ljava/lang/String;")
	public static String method103(int arg0) {
		return "<col=" + Integer.toHexString(arg0) + ">";
	}

	@ObfuscatedName("eg.d(IB)I")
	public static int method1838(int arg0) {
		int var1 = (arg0 >>> 1 & 0x55555555) + (arg0 & 0x55555555);
		int var2 = (var1 >>> 2 & 0x33333333) + (var1 & 0x33333333);
		int var3 = (var2 >>> 4) + var2 & 0xF0F0F0F;
		int var4 = (var3 >>> 8) + var3;
		int var5 = (var4 >>> 16) + var4;
		return var5 & 0xFF;
	}

	@ObfuscatedName("cc.r(II)I")
	public static int method1130(int arg0) {
		VarBitType var1 = VarBitType.method98(arg0);
		int var2 = var1.field2418;
		int var3 = var1.field2416;
		int var4 = var1.field2420;
		int var5 = VarProvider.field1212[var4 - var3];
		return VarProvider.field1210[var2] >> var3 & var5;
	}

	@ObfuscatedName("ct.z(Lch;Lch;I)V")
	public static void method1194(Js5Index arg0, Js5Index arg1) {
		field2394 = arg0;
		field2397 = arg1;
		field1628 = field2394.method1054(3);
	}

	@ObfuscatedName("bx.r(IZII)V")
	public static final void method832(int arg0, boolean arg1, int arg2) {
		if (arg0 < 8000 || arg0 > 48000) {
			throw new IllegalArgumentException();
		}
		field241 = arg0;
		field236 = arg1;
		field239 = arg2;
	}

	@ObfuscatedName("y.l(CB)C")
	public static char method261(char arg0) {
		return arg0 == 181 || arg0 == 402 ? arg0 : Character.toTitleCase(arg0);
	}

	@ObfuscatedName("q.c(ILch;IIIZI)V")
	public static void method95(int arg0, Js5Index arg1, int arg2, int arg3, int arg4, boolean arg5) {
		MidiPlayer.field1117 = 1;
		field1118 = arg1;
		field349 = arg2;
		field1121 = arg3;
		field1120 = arg4;
		field1625 = arg5;
		field1152 = arg0;
	}

	@ObfuscatedName("ak.d(Lch;Ljava/lang/String;Ljava/lang/String;I)Lft;")
	public static Pix8 method457(Js5Index arg0, String arg1, String arg2) {
		int var3 = arg0.method1059(arg1);
		int var4 = arg0.method1064(var3, arg2);
		Pix8 var5;
		if (SpriteDataProvider.method905(arg0, var3, var4)) {
			var5 = SpriteDataProvider.method556();
		} else {
			var5 = null;
		}
		return var5;
	}

	@ObfuscatedName("bs.m(Ljava/lang/CharSequence;I)Ljava/lang/String;")
	public static String method762(CharSequence arg0) {
		String var1 = JString.method768(JString.method1001(arg0));
		if (var1 == null) {
			var1 = "";
		}
		return var1;
	}

	@ObfuscatedName("bx.l(Lch;Ljava/lang/String;Ljava/lang/String;I)[Lfq;")
	public static Pix32[] method830(Js5Index arg0, String arg1, String arg2) {
		int var3 = arg0.method1059(arg1);
		int var4 = arg0.method1064(var3, arg2);
		Pix32[] var5;
		if (SpriteDataProvider.method905(arg0, var3, var4)) {
			Pix32[] var6 = new Pix32[field528];
			for (int var7 = 0; var7 < field528; var7++) {
				Pix32 var8 = var6[var7] = new Pix32();
				var8.field2504 = field533;
				var8.field2505 = field530;
				var8.field2502 = field531[var7];
				var8.field2499 = field532[var7];
				var8.field2508 = field41[var7];
				var8.field2501 = field1151[var7];
				int var9 = var8.field2508 * var8.field2501;
				byte[] var10 = field863[var7];
				var8.field2506 = new int[var9];
				for (int var11 = 0; var11 < var9; var11++) {
					var8.field2506[var11] = field529[var10[var11] & 0xFF];
				}
			}
			field531 = null;
			field532 = null;
			field41 = null;
			field1151 = null;
			field529 = null;
			field863 = null;
			var5 = var6;
		} else {
			var5 = null;
		}
		return var5;
	}

	@ObfuscatedName("ex.z(IIIII)V")
	public static void method2297(int arg0, int arg1, int arg2, int arg3) {
		for (PositionedSound var4 = (PositionedSound) PositionedSound.field1612.method1297(); var4 != null; var4 = (PositionedSound) PositionedSound.field1612.method1299()) {
			if (var4.field1608 != -1 || var4.field1604 != null) {
				int var5 = 0;
				if (arg1 > var4.field1605) {
					var5 += arg1 - var4.field1605;
				} else if (arg1 < var4.field1609) {
					var5 += var4.field1609 - arg1;
				}
				if (arg2 > var4.field1610) {
					var5 += arg2 - var4.field1610;
				} else if (arg2 < var4.field1606) {
					var5 += var4.field1606 - arg2;
				}
				if (var5 - 64 > var4.field1607 || client.field2174 == 0 || var4.field1602 != arg0) {
					if (var4.field1603 != null) {
						field1460.method2175(var4.field1603);
						var4.field1603 = null;
					}
					if (var4.field1614 != null) {
						field1460.method2175(var4.field1614);
						var4.field1614 = null;
					}
				} else {
					var5 -= 64;
					if (var5 < 0) {
						var5 = 0;
					}
					int var6 = client.field2174 * (var4.field1607 - var5) / var4.field1607;
					if (var4.field1603 != null) {
						var4.field1603.method2090(var6);
					} else if (var4.field1608 >= 0) {
						Wave var7 = Wave.method294(field1509, var4.field1608, 0);
						if (var7 != null) {
							PcmSound var8 = var7.method291().method2050(field1733);
							SoundPcmStream var9 = SoundPcmStream.method2144(var8, 100, var6);
							var9.method2061(-1);
							field1460.method2174(var9);
							var4.field1603 = var9;
						}
					}
					if (var4.field1614 != null) {
						var4.field1614.method2090(var6);
						if (!var4.field1614.method1326()) {
							var4.field1614 = null;
						}
					} else if (var4.field1604 != null && (var4.field1613 -= arg3) <= 0) {
						int var10 = (int) (Math.random() * (double) var4.field1604.length);
						Wave var11 = Wave.method294(field1509, var4.field1604[var10], 0);
						if (var11 != null) {
							PcmSound var12 = var11.method291().method2050(field1733);
							SoundPcmStream var13 = SoundPcmStream.method2144(var12, 100, var6);
							var13.method2061(0);
							field1460.method2174(var13);
							var4.field1614 = var13;
							var4.field1613 = var4.field1601 + (int) (Math.random() * (double) (var4.field1611 - var4.field1601));
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("m.d(Ljava/lang/String;I)Ljava/lang/Class;")
	public static Class method51(String arg0) throws ClassNotFoundException {
		if (arg0.equals("B")) {
			return Byte.TYPE;
		} else if (arg0.equals("I")) {
			return Integer.TYPE;
		} else if (arg0.equals("S")) {
			return Short.TYPE;
		} else if (arg0.equals("J")) {
			return Long.TYPE;
		} else if (arg0.equals("Z")) {
			return Boolean.TYPE;
		} else if (arg0.equals("F")) {
			return Float.TYPE;
		} else if (arg0.equals("D")) {
			return Double.TYPE;
		} else if (arg0.equals("C")) {
			return Character.TYPE;
		} else {
			return Class.forName(arg0);
		}
	}

	@ObfuscatedName("r.l(Ldj;I)V")
	public static void method3(GameShell arg0) {
		if (LoginScreen.field160) {
			LoginScreen.method1134(arg0);
			return;
		}
		if (JavaMouseProvider.field497 == 1 && JavaMouseProvider.field498 >= 715 && JavaMouseProvider.field499 >= 453) {
			LoginScreen.field142 = !LoginScreen.field142;
			if (LoginScreen.field142) {
				MidiPlayer.method917();
			} else {
				Js5Provider var1 = field1110;
				int var2 = var1.method1059("scape main");
				int var3 = var1.method1064(var2, "");
				MidiPlayer.method1125(var1, var2, var3, 255, false);
			}
		}
		if (client.field1929 == 5) {
			return;
		}
		LoginScreen.field147++;
		if (client.field1929 != 10) {
			return;
		}
		if (client.field2047 == 0) {
			if (JavaMouseProvider.field497 == 1) {
				byte var4 = 5;
				short var5 = 463;
				byte var6 = 100;
				byte var7 = 35;
				if (JavaMouseProvider.field498 >= var4 && JavaMouseProvider.field498 <= var4 + var6 && JavaMouseProvider.field499 >= var5 && JavaMouseProvider.field499 <= var5 + var7) {
					LoginScreen.method377();
					return;
				}
			}
			if (field35 != null) {
				LoginScreen.method377();
			}
		}
		int var8 = JavaMouseProvider.field497;
		int var9 = JavaMouseProvider.field498;
		int var10 = JavaMouseProvider.field499;
		if (LoginScreen.field151 == 0) {
			short var11 = 302;
			short var12 = 291;
			if (var8 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var12 - 20 && var10 <= var12 + 20) {
				LoginScreen.field151 = 3;
				LoginScreen.field150 = 0;
			}
			short var13 = 462;
			if (var8 == 1 && var9 >= var13 - 75 && var9 <= var13 + 75 && var10 >= var12 - 20 && var10 <= var12 + 20) {
				LoginScreen.field152 = EnglishLocale.field924;
				LoginScreen.field127 = EnglishLocale.field1007;
				LoginScreen.field154 = EnglishLocale.field1068;
				LoginScreen.field151 = 2;
				LoginScreen.field150 = 0;
			}
		} else if (LoginScreen.field151 == 2) {
			short var14 = 231;
			int var26 = var14 + 30;
			if (var8 == 1 && var10 >= var26 - 15 && var10 < var26) {
				LoginScreen.field150 = 0;
			}
			var26 += 15;
			if (var8 == 1 && var10 >= var26 - 15 && var10 < var26) {
				LoginScreen.field150 = 1;
			}
			var26 += 15;
			short var15 = 302;
			short var16 = 321;
			if (var8 == 1 && var9 >= var15 - 75 && var9 <= var15 + 75 && var10 >= var16 - 20 && var10 <= var16 + 20) {
				LoginScreen.field164 = LoginScreen.field164.trim();
				if (LoginScreen.field164.length() == 0) {
					LoginScreen.method2357(EnglishLocale.field978, EnglishLocale.field979, EnglishLocale.field980);
					return;
				}
				if (LoginScreen.field133.length() == 0) {
					LoginScreen.method2357(EnglishLocale.field981, EnglishLocale.field982, EnglishLocale.field983);
					return;
				}
				LoginScreen.method2357(EnglishLocale.field905, EnglishLocale.field1070, EnglishLocale.field998);
				client.method729(20);
				return;
			}
			short var17 = 462;
			if (var8 == 1 && var9 >= var17 - 75 && var9 <= var17 + 75 && var10 >= var16 - 20 && var10 <= var16 + 20) {
				LoginScreen.field151 = 0;
				LoginScreen.field164 = "";
				LoginScreen.field133 = "";
			}
			while (true) {
				while (true) {
					JavaKeyboardProvider var18 = JavaKeyboardProvider.field460;
					boolean var19;
					synchronized (JavaKeyboardProvider.field460) {
						if (JavaKeyboardProvider.field479 == JavaKeyboardProvider.field424) {
							var19 = false;
						} else {
							field114 = JavaKeyboardProvider.field478[JavaKeyboardProvider.field479];
							field1162 = JavaKeyboardProvider.field477[JavaKeyboardProvider.field479];
							JavaKeyboardProvider.field479 = JavaKeyboardProvider.field479 + 1 & 0x7F;
							var19 = true;
						}
					}
					if (!var19) {
						return;
					}
					boolean var21 = false;
					for (int var22 = 0; var22 < LoginScreen.field158.length(); var22++) {
						if (field1162 == LoginScreen.field158.charAt(var22)) {
							var21 = true;
							break;
						}
					}
					if (LoginScreen.field150 == 0) {
						if (field114 == 85 && LoginScreen.field164.length() > 0) {
							LoginScreen.field164 = LoginScreen.field164.substring(0, LoginScreen.field164.length() - 1);
						}
						if (field114 == 84 || field114 == 80) {
							LoginScreen.field150 = 1;
						}
						if (var21 && LoginScreen.field164.length() < 320) {
							LoginScreen.field164 = LoginScreen.field164 + field1162;
						}
					} else if (LoginScreen.field150 == 1) {
						if (field114 == 85 && LoginScreen.field133.length() > 0) {
							LoginScreen.field133 = LoginScreen.field133.substring(0, LoginScreen.field133.length() - 1);
						}
						if (field114 == 84 || field114 == 80) {
							LoginScreen.field150 = 0;
						}
						if (client.field1915 == 2 && field114 == 84) {
							LoginScreen.field164 = LoginScreen.field164.trim();
							if (LoginScreen.field164.length() == 0) {
								LoginScreen.method2357(EnglishLocale.field978, EnglishLocale.field979, EnglishLocale.field980);
								return;
							}
							if (LoginScreen.field133.length() == 0) {
								LoginScreen.method2357(EnglishLocale.field981, EnglishLocale.field982, EnglishLocale.field983);
								return;
							}
							LoginScreen.method2357(EnglishLocale.field905, EnglishLocale.field1070, EnglishLocale.field998);
							client.method729(20);
							return;
						}
						if (var21 && LoginScreen.field133.length() < 20) {
							LoginScreen.field133 = LoginScreen.field133 + field1162;
						}
					}
				}
			}
		} else if (LoginScreen.field151 == 3) {
			short var23 = 382;
			short var24 = 321;
			if (var8 == 1 && var9 >= var23 - 75 && var9 <= var23 + 75 && var10 >= var24 - 20 && var10 <= var24 + 20) {
				LoginScreen.field151 = 0;
			}
		}
	}

	@ObfuscatedName("as.n([BIII)Z")
	public static final boolean method389(byte[] arg0, int arg1, int arg2) {
		boolean var3 = true;
		Packet var4 = new Packet(arg0);
		int var5 = -1;
		label57: while (true) {
			int var6 = var4.method1640();
			if (var6 == 0) {
				return var3;
			}
			var5 += var6;
			int var7 = 0;
			boolean var8 = false;
			while (true) {
				while (!var8) {
					int var10 = var4.method1640();
					if (var10 == 0) {
						continue label57;
					}
					var7 += var10 - 1;
					int var11 = var7 & 0x3F;
					int var12 = var7 >> 6 & 0x3F;
					int var13 = var4.method1600() >> 2;
					int var14 = arg1 + var12;
					int var15 = arg2 + var11;
					if (var14 > 0 && var15 > 0 && var14 < 103 && var15 < 103) {
						LocType var16 = LocType.method2564(var5);
						if (var13 != 22 || !client.field1917 || var16.field2321 != 0 || var16.field2342 == 1 || var16.field2341) {
							if (!var16.method2366()) {
								client.field1974++;
								var3 = false;
							}
							var8 = true;
						}
					}
				}
				int var9 = var4.method1640();
				if (var9 == 0) {
					break;
				}
				var4.method1600();
			}
		}
	}

	@ObfuscatedName("by.m(Ldq;IIIBZI)V")
	public static void method827(Js5Provider arg0, int arg1, int arg2, int arg3, byte arg4, boolean arg5) {
		long var6 = (long) ((arg1 << 16) + arg2);
		Js5NetRequest var8 = (Js5NetRequest) Js5TcpClient.field1185.method1277(var6);
		if (var8 != null) {
			return;
		}
		Js5NetRequest var9 = (Js5NetRequest) Js5TcpClient.field1187.method1277(var6);
		if (var9 != null) {
			return;
		}
		Js5NetRequest var10 = (Js5NetRequest) Js5TcpClient.field1193.method1277(var6);
		if (var10 == null) {
			if (!arg5) {
				Js5NetRequest var11 = (Js5NetRequest) Js5TcpClient.field1199.method1277(var6);
				if (var11 != null) {
					return;
				}
			}
			Js5NetRequest var12 = new Js5NetRequest();
			var12.field2492 = arg0;
			var12.field2491 = arg3;
			var12.field2490 = arg4;
			if (arg5) {
				Js5TcpClient.field1185.method1278(var12, var6);
				Js5TcpClient.field1186++;
			} else {
				Js5TcpClient.field1189.method1256(var12);
				Js5TcpClient.field1193.method1278(var12, var6);
				Js5TcpClient.field1191++;
			}
		} else if (arg5) {
			var10.method1841();
			Js5TcpClient.field1185.method1278(var10, var6);
			Js5TcpClient.field1191--;
			Js5TcpClient.field1186++;
		}
	}

	@ObfuscatedName("da.o(S)V")
	public static void method1352() {
		ObjType.field2434.method1253();
	}

	@ObfuscatedName("cw.u(III)I")
	public static final int method1144(int arg0, int arg1) {
		int var2 = World.method1786(arg0 - 1, arg1 - 1) + World.method1786(arg0 + 1, arg1 - 1) + World.method1786(arg0 - 1, arg1 + 1) + World.method1786(arg0 + 1, arg1 + 1);
		int var3 = World.method1786(arg0 - 1, arg1) + World.method1786(arg0 + 1, arg1) + World.method1786(arg0, arg1 - 1) + World.method1786(arg0, arg1 + 1);
		int var4 = World.method1786(arg0, arg1);
		return var4 / 4 + var2 / 16 + var3 / 8;
	}

	@ObfuscatedName("dq.dz(B)V")
	public static final void method1484() {
		if (field652 != null) {
			field652.method392();
			field652 = null;
		}
		client.method746();
		field1133.method564();
		for (int var0 = 0; var0 < 4; var0++) {
			client.field2114[var0].method1196();
		}
		System.gc();
		MidiPlayer.field1117 = 1;
		field1118 = null;
		field349 = -1;
		field1121 = -1;
		field1120 = 0;
		field1625 = false;
		field1152 = 2;
		client.field2170 = -1;
		client.field2189 = false;
		for (PositionedSound var1 = (PositionedSound) PositionedSound.field1612.method1297(); var1 != null; var1 = (PositionedSound) PositionedSound.field1612.method1299()) {
			if (var1.field1603 != null) {
				field1460.method2175(var1.field1603);
				var1.field1603 = null;
			}
			if (var1.field1614 != null) {
				field1460.method2175(var1.field1614);
				var1.field1614 = null;
			}
		}
		PositionedSound.field1612.method1291();
		client.method729(10);
	}

	@ObfuscatedName("eg.di(B)V")
	public static final void method1835() {
		for (int var0 = -1; var0 < client.field2134; var0++) {
			int var1;
			if (var0 == -1) {
				var1 = 2047;
			} else {
				var1 = client.field2043[var0];
			}
			PlayerEntity var2 = client.field2073[var1];
			if (var2 != null) {
				client.method906(var2, 1);
			}
		}
	}

	@ObfuscatedName("co.dw(Lfi;III)V")
	public static void method1040(PlayerEntity arg0, int arg1, int arg2) {
		if (arg0.field2643 == arg1 && arg1 != -1) {
			int var3 = SeqType.method104(arg1).field2377;
			if (var3 == 1) {
				arg0.field2653 = 0;
				arg0.field2645 = 0;
				arg0.field2627 = arg2;
				arg0.field2647 = 0;
			}
			if (var3 == 2) {
				arg0.field2647 = 0;
			}
		} else if (arg1 == -1 || arg0.field2643 == -1 || SeqType.method104(arg1).field2371 >= SeqType.method104(arg0.field2643).field2371) {
			arg0.field2643 = arg1;
			arg0.field2653 = 0;
			arg0.field2645 = 0;
			arg0.field2627 = arg2;
			arg0.field2647 = 0;
			arg0.field2656 = arg0.field2665;
		}
	}

	@ObfuscatedName("at.ej(ZB)V")
	public static final void method722(boolean arg0) {
		client.method1351();
		client.field1963++;
		if (client.field1963 < 50 && !arg0) {
			return;
		}
		client.field1963 = 0;
		if (client.field1968 || field652 == null) {
			return;
		}
		client.field1949.method2301(228);
		try {
			field652.method396(client.field1949.field1732, 0, client.field1949.field1729);
			client.field1949.field1729 = 0;
		} catch (IOException var2) {
			client.field1968 = true;
		}
	}

	@ObfuscatedName("dm.ed(I)V")
	public static final void method1461() {
		while (true) {
			if (client.field2100.method2305(client.field2064) >= 27) {
				int var0 = client.field2100.method2303(15);
				if (var0 != 32767) {
					boolean var1 = false;
					if (client.field1954[var0] == null) {
						client.field1954[var0] = new NpcEntity();
						var1 = true;
					}
					NpcEntity var2 = client.field1954[var0];
					client.field1956[++client.field1959 - 1] = var0;
					var2.field2660 = client.field1922;
					int var3 = client.field1941[client.field2100.method2303(3)];
					if (var1) {
						var2.field2618 = var2.field2646 = var3;
					}
					int var4 = client.field2100.method2303(5);
					if (var4 > 15) {
						var4 -= 32;
					}
					int var5 = client.field2100.method2303(1);
					if (var5 == 1) {
						client.field2045[++client.field2044 - 1] = var0;
					}
					int var6 = client.field2100.method2303(1);
					var2.field2804 = NpcType.method275(client.field2100.method2303(14));
					int var7 = client.field2100.method2303(5);
					if (var7 > 15) {
						var7 -= 32;
					}
					var2.field2657 = var2.field2804.field2283;
					var2.field2661 = var2.field2804.field2296;
					if (var2.field2661 == 0) {
						var2.field2646 = 0;
					}
					var2.field2621 = var2.field2804.field2279;
					var2.field2664 = var2.field2804.field2280;
					var2.field2623 = var2.field2804.field2294;
					var2.field2624 = var2.field2804.field2282;
					var2.field2622 = var2.field2804.field2276;
					var2.field2619 = var2.field2804.field2287;
					var2.field2620 = var2.field2804.field2278;
					var2.method2907(field1134.field2666[0] + var7, field1134.field2667[0] + var4, var6 == 1);
					continue;
				}
			}
			client.field2100.method2319();
			return;
		}
	}

	@ObfuscatedName("bk.ep(B)V")
	public static final void method769() {
		int var0 = field704.method2882(EnglishLocale.field1028);
		for (int var1 = 0; var1 < client.field1928; var1++) {
			int var2 = field704.method2882(client.method1239(var1));
			if (var2 > var0) {
				var0 = var2;
			}
		}
		var0 += 8;
		int var3 = client.field1928 * 15 + 21;
		int var4 = JavaMouseProvider.field498 - var0 / 2;
		if (var0 + var4 > 765) {
			var4 = 765 - var0;
		}
		if (var4 < 0) {
			var4 = 0;
		}
		int var5 = JavaMouseProvider.field499;
		if (var3 + var5 > 503) {
			var5 = 503 - var3;
		}
		if (var5 < 0) {
			var5 = 0;
		}
		client.field2066 = true;
		field1161 = var4;
		field743 = var5;
		field535 = var0;
		field42 = client.field1928 * 15 + 22;
	}

	@ObfuscatedName("bd.eu(IIILjava/lang/String;I)V")
	public static void method949(int arg0, int arg1, int arg2, String arg3) {
		IfType var4 = IfType.method947(arg1, arg2);
		if (var4 == null) {
			return;
		}
		if (var4.field1847 != null) {
			HookRequest var5 = new HookRequest();
			var5.field1590 = var4;
			var5.field1591 = arg0;
			var5.field1595 = arg3;
			var5.field1588 = var4.field1847;
			ScriptRunner.method777(var5);
		}
		boolean var6 = true;
		if (var4.field1787 > 0) {
			var6 = client.method1580(var4);
		}
		if (!var6) {
			return;
		}
		int var7 = client.method1512(var4);
		int var8 = arg0 - 1;
		boolean var9 = (var7 >> var8 + 1 & 0x1) != 0;
		if (!var9) {
			return;
		}
		if (arg0 == 1) {
			client.field1949.method2301(63);
			client.field1949.method1761(arg1);
			client.field1949.method1667(arg2);
		}
		if (arg0 == 2) {
			client.field1949.method2301(87);
			client.field1949.method1761(arg1);
			client.field1949.method1667(arg2);
		}
		if (arg0 == 3) {
			client.field1949.method2301(238);
			client.field1949.method1761(arg1);
			client.field1949.method1667(arg2);
		}
		if (arg0 == 4) {
			client.field1949.method2301(240);
			client.field1949.method1761(arg1);
			client.field1949.method1667(arg2);
		}
		if (arg0 == 5) {
			client.field1949.method2301(153);
			client.field1949.method1761(arg1);
			client.field1949.method1667(arg2);
		}
		if (arg0 == 6) {
			client.field1949.method2301(232);
			client.field1949.method1761(arg1);
			client.field1949.method1667(arg2);
		}
		if (arg0 == 7) {
			client.field1949.method2301(168);
			client.field1949.method1761(arg1);
			client.field1949.method1667(arg2);
		}
		if (arg0 == 8) {
			client.field1949.method2301(239);
			client.field1949.method1761(arg1);
			client.field1949.method1667(arg2);
		}
		if (arg0 == 9) {
			client.field1949.method2301(254);
			client.field1949.method1761(arg1);
			client.field1949.method1667(arg2);
		}
		if (arg0 == 10) {
			client.field1949.method2301(169);
			client.field1949.method1761(arg1);
			client.field1949.method1667(arg2);
		}
	}

	@ObfuscatedName("z.fc(Lem;IIII)V")
	public static final void method64(NpcType arg0, int arg1, int arg2, int arg3) {
		if (client.field1928 >= 400) {
			return;
		}
		if (arg0.field2273 != null) {
			arg0 = arg0.method2332();
		}
		if (arg0 == null || !arg0.field2300) {
			return;
		}
		String var4 = arg0.field2272;
		if (arg0.field2289 != 0) {
			int var6 = arg0.field2289;
			int var7 = field1134.field2789;
			int var8 = var7 - var6;
			String var9;
			if (var8 < -9) {
				var9 = method103(16711680);
			} else if (var8 < -6) {
				var9 = method103(16723968);
			} else if (var8 < -3) {
				var9 = method103(16740352);
			} else if (var8 < 0) {
				var9 = method103(16756736);
			} else if (var8 > 9) {
				var9 = method103(65280);
			} else if (var8 > 6) {
				var9 = method103(4259584);
			} else if (var8 > 3) {
				var9 = method103(8453888);
			} else if (var8 > 0) {
				var9 = method103(12648192);
			} else {
				var9 = method103(16776960);
			}
			var4 = var4 + var9 + " " + TextUtil.field2 + EnglishLocale.field1011 + arg0.field2289 + TextUtil.field5;
		}
		if (client.field2077 == 1) {
			client.method8(EnglishLocale.field1005, client.field2078 + " " + TextUtil.field6 + " " + method103(16776960) + var4, 7, arg1, arg2, arg3);
		} else if (!client.field2079) {
			String[] var10 = arg0.field2268;
			if (client.field2001) {
				var10 = client.method726(var10);
			}
			if (var10 != null) {
				for (int var11 = 4; var11 >= 0; var11--) {
					if (var10[var11] != null && !var10[var11].equalsIgnoreCase(EnglishLocale.field902)) {
						byte var12 = 0;
						if (var11 == 0) {
							var12 = 9;
						}
						if (var11 == 1) {
							var12 = 10;
						}
						if (var11 == 2) {
							var12 = 11;
						}
						if (var11 == 3) {
							var12 = 12;
						}
						if (var11 == 4) {
							var12 = 13;
						}
						client.method8(var10[var11], method103(16776960) + var4, var12, arg1, arg2, arg3);
					}
				}
			}
			if (var10 != null) {
				for (int var13 = 4; var13 >= 0; var13--) {
					if (var10[var13] != null && var10[var13].equalsIgnoreCase(EnglishLocale.field902)) {
						short var14 = 0;
						if (arg0.field2289 > field1134.field2789) {
							var14 = 2000;
						}
						int var15 = 0;
						if (var13 == 0) {
							var15 = var14 + 9;
						}
						if (var13 == 1) {
							var15 = var14 + 10;
						}
						if (var13 == 2) {
							var15 = var14 + 11;
						}
						if (var13 == 3) {
							var15 = var14 + 12;
						}
						if (var13 == 4) {
							var15 = var14 + 13;
						}
						client.method8(var10[var13], method103(16776960) + var4, var15, arg1, arg2, arg3);
					}
				}
			}
			client.method8(EnglishLocale.field1075, method103(16776960) + var4, 1003, arg1, arg2, arg3);
		} else if ((field386 & 0x2) == 2) {
			client.method8(client.field2048, client.field2082 + " " + TextUtil.field6 + " " + method103(16776960) + var4, 8, arg1, arg2, arg3);
		}
	}

	@ObfuscatedName("bi.gx(Ljava/lang/String;I)Z")
	public static boolean method761(String arg0) {
		if (arg0 == null) {
			return false;
		}
		for (int var1 = 0; var1 < client.field2194; var1++) {
			IgnoreListEntry var2 = client.field2196[var1];
			if (arg0.equalsIgnoreCase(var2.field40)) {
				return true;
			}
			if (arg0.equalsIgnoreCase(var2.field39)) {
				return true;
			}
		}
		return false;
	}

	@ObfuscatedName("ch.gl(Ljava/lang/String;I)V")
	public static final void method1103(String arg0) {
		if (arg0 == null) {
			return;
		}
		if (client.field2071 >= 200 && client.field2130 != 1 || client.field2071 >= 200) {
			client.method559(0, "", EnglishLocale.field1021);
			return;
		}
		String var1 = NamespaceUtil.method743(arg0, field543);
		if (var1 == null) {
			return;
		}
		for (int var2 = 0; var2 < client.field2071; var2++) {
			FriendListEntry var3 = client.field2111[var2];
			String var4 = NamespaceUtil.method743(var3.field173, field543);
			if (var4 != null && var4.equals(var1)) {
				client.method559(0, "", arg0 + EnglishLocale.field913);
				return;
			}
			if (var3.field177 != null) {
				String var5 = NamespaceUtil.method743(var3.field177, field543);
				if (var5 != null && var5.equals(var1)) {
					client.method559(0, "", arg0 + EnglishLocale.field913);
					return;
				}
			}
		}
		for (int var6 = 0; var6 < client.field2194; var6++) {
			IgnoreListEntry var7 = client.field2196[var6];
			String var8 = NamespaceUtil.method743(var7.field40, field543);
			if (var8 != null && var8.equals(var1)) {
				client.method559(0, "", EnglishLocale.field1027 + arg0 + EnglishLocale.field1052);
				return;
			}
			if (var7.field39 != null) {
				String var9 = NamespaceUtil.method743(var7.field39, field543);
				if (var9 != null && var9.equals(var1)) {
					client.method559(0, "", EnglishLocale.field1027 + arg0 + EnglishLocale.field1052);
					return;
				}
			}
		}
		if (NamespaceUtil.method743(field1134.field2796, field543).equals(var1)) {
			client.method559(0, "", EnglishLocale.field1069);
		} else {
			client.field1949.method2301(203);
			client.field1949.method1587(Packet.method2323(arg0));
			client.field1949.method1592(arg0);
		}
	}
}
