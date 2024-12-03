package deob;

import jagex2.client.*;
import jagex2.config.IfType;
import jagex2.dash3d.PlayerEntity;
import jagex2.dash3d.SceneProvider;
import jagex2.dash3d.World3D;
import jagex2.datastruct.Timer;
import jagex2.graphics.Pix32;
import jagex2.graphics.Pix8;
import jagex2.graphics.PixMap;
import jagex2.graphics.SoftwareFont;
import jagex2.io.BufferedFile;
import jagex2.io.ClientStream;
import jagex2.io.FileStream;
import jagex2.io.Packet;
import jagex2.js5.Js5Index;
import jagex2.js5.Js5NetRequest;
import jagex2.js5.Js5Provider;
import jagex2.sound.*;
import jagex2.wordenc.Huffman;

import java.applet.Applet;
import java.awt.*;
import java.io.File;

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
}
