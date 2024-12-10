package jagex2.client;

import deob.ObfuscatedName;
import jagex2.config.*;
import jagex2.dash3d.*;
import jagex2.datastruct.*;
import jagex2.graphics.*;
import jagex2.io.*;
import jagex2.js5.Js5NetProviderRequest;
import jagex2.js5.Js5Provider;
import jagex2.js5.Js5ProviderThread;
import jagex2.js5.Js5TcpClient;
import jagex2.jstring.Cp1252;
import jagex2.jstring.EnglishLocale;
import jagex2.jstring.JString;
import jagex2.sound.*;
import jagex2.wordenc.Huffman;
import jagex2.wordenc.WordPack;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.URL;

@ObfuscatedName("client")
public class Client extends GameShell {

	@ObfuscatedName("cd.ad")
	public static Image progressBar;

	@ObfuscatedName("client.ak")
	public static boolean flagged = true;

	@ObfuscatedName("client.az")
	public static int worldid = 1;

	@ObfuscatedName("v.an")
	public static ModeWhat modewhat;

	@ObfuscatedName("client.ah")
	public static int modewhere = 0;

	@ObfuscatedName("da.ay")
	public static ModeGame modegame;

	@ObfuscatedName("ab.al")
	public static Namespace namespace;

	@ObfuscatedName("client.ab")
	public static boolean members = false;

	@ObfuscatedName("client.ao")
	public static boolean lowMemory = false;

	@ObfuscatedName("client.ag")
	public static int lang = 0;

	@ObfuscatedName("client.ar")
	public static int js = 1;

	@ObfuscatedName("client.at")
	public static int gameState = 0;

	@ObfuscatedName("client.ae")
	public static boolean field1921 = true;

	@ObfuscatedName("client.au")
	public static int loopCycle = 0;

	@ObfuscatedName("client.ax")
	public static long prevMousePressTime = 0L;

	@ObfuscatedName("dm.ai")
	public static MouseTracking mouseTracking;

	@ObfuscatedName("client.aj")
	public static int lastWriteX = 0;

	@ObfuscatedName("client.aw")
	public static int lastWriteY = 0;

	@ObfuscatedName("client.af")
	public static int lastWriteDuplicates = 0;

	@ObfuscatedName("client.bh")
	public static boolean focused = true;

	@ObfuscatedName("client.bi")
	public static boolean field1991 = false;

	@ObfuscatedName("client.bs")
	public static int systemUpdateTimer = 0;

	@ObfuscatedName("client.bk")
	public static int field1920 = 0;

	@ObfuscatedName("client.bv")
	public static int field1931 = 0;

	@ObfuscatedName("client.bg")
	public static int field1932 = 0;

	@ObfuscatedName("client.bl")
	public static int field1933 = 0;

	@ObfuscatedName("client.bt")
	public static int field1934 = 0;

	@ObfuscatedName("client.bw")
	public static int field1935 = 0;

	@ObfuscatedName("client.by")
	public static int field1936 = 0;

	@ObfuscatedName("client.bx")
	public static int field1937 = 0;

	@ObfuscatedName("client.bf")
	public static Packet field2016 = new Packet(new byte[5000]);

	@ObfuscatedName("g.bu")
	public static PrivilegedRequest field170;

	@ObfuscatedName("client.bq")
	public static int field1940 = 0;

	@ObfuscatedName("l.bj")
	public static PrivilegedRequest field36;

	@ObfuscatedName("br.bz")
	public static ClientStream field1102;

	@ObfuscatedName("client.bm")
	public static int field2090 = 0;

	@ObfuscatedName("client.bn")
	public static int field1942 = 0;

	@ObfuscatedName("client.be")
	public static long field1943;

	@ObfuscatedName("bb.bp")
	public static Js5Provider field1109;

	@ObfuscatedName("es.ba")
	public static Js5Provider field1720;

	@ObfuscatedName("cc.bc")
	public static Js5Provider configJs5;

	@ObfuscatedName("bd.br")
	public static Js5Provider field1123;

	@ObfuscatedName("df.bb")
	public static Js5Provider field1509;

	@ObfuscatedName("ck.bd")
	public static Js5Provider field1270;

	@ObfuscatedName("bb.cr")
	public static Js5Provider field1110;

	@ObfuscatedName("aa.cs")
	public static Js5Provider modelJs5;

	@ObfuscatedName("client.cj")
	public static Js5Provider field1944;

	@ObfuscatedName("client.cl")
	public static Js5Provider field1966;

	@ObfuscatedName("ab.cp")
	public static Js5Provider field544;

	@ObfuscatedName("dz.ca")
	public static Js5Provider field1515;

	@ObfuscatedName("ct.co")
	public static Js5Provider field1232;

	@ObfuscatedName("cj.ch")
	public static Js5Provider field1150;

	@ObfuscatedName("ey.cu")
	public static Js5Provider field2353;

	@ObfuscatedName("z.cc")
	public static Js5Provider field126;

	@ObfuscatedName("client.cm")
	public static int field1986 = 0;

	@ObfuscatedName("client.cw")
	public static int loginState = 0;

	@ObfuscatedName("client.cz")
	public static int field1948 = 0;

	@ObfuscatedName("client.cv")
	public static int field2105 = 0;

	@ObfuscatedName("client.ct")
	public static int field1950 = 0;

	@ObfuscatedName("c.ck")
	public static String field52;

	@ObfuscatedName("dn.cy")
	public static int field1641;

	@ObfuscatedName("d.cq")
	public static int field13;

	@ObfuscatedName("cu.cd")
	public static int field1204;

	@ObfuscatedName("client.ci")
	public static NpcEntity[] npcs = new NpcEntity[32768];

	@ObfuscatedName("client.cb")
	public static int npcCount = 0;

	@ObfuscatedName("client.cf")
	public static int[] field1956 = new int[32768];

	@ObfuscatedName("by.cg")
	public static PrivilegedRequest field806;

	@ObfuscatedName("at.dd")
	public static ClientStream stream;

	@ObfuscatedName("c.dg")
	public static ClientStream field53;

	@ObfuscatedName("client.df")
	public static PacketBit out = new PacketBit(5000);

	@ObfuscatedName("client.dk")
	public static PacketBit login = new PacketBit(5000);

	@ObfuscatedName("client.dz")
	public static PacketBit in = new PacketBit(5000);

	@ObfuscatedName("client.da")
	public static int packetSize = 0;

	@ObfuscatedName("client.dj")
	public static int packetType = 0;

	@ObfuscatedName("client.dv")
	public static int idleNetCycles = 0;

	@ObfuscatedName("client.ds")
	public static int heartbeatTimer = 0;

	@ObfuscatedName("client.dh")
	public static int idleTimeout = 0;

	@ObfuscatedName("client.dc")
	public static int lastPacketType0 = 0;

	@ObfuscatedName("client.dp")
	public static int lastPacketType1 = 0;

	@ObfuscatedName("client.dm")
	public static int lastPacketType2 = 0;

	@ObfuscatedName("client.di")
	public static boolean field1968 = false;

	@ObfuscatedName("dw.db")
	public static SoftwareFont field1621;

	@ObfuscatedName("bd.dq")
	public static SoftwareFont field1122;

	@ObfuscatedName("af.dr")
	public static SoftwareFont field704;

	@ObfuscatedName("a.de")
	public static int sceneBaseTileX;

	@ObfuscatedName("at.dw")
	public static int sceneBaseTileZ;

	@ObfuscatedName("client.dl")
	public static int field2128 = 0;

	@ObfuscatedName("cd.dn")
	public static int field1473;

	@ObfuscatedName("v.do")
	public static int field217;

	@ObfuscatedName("client.dx")
	public static int field1972 = 0;

	@ObfuscatedName("client.dt")
	public static int field2024 = 1;

	@ObfuscatedName("client.eb")
	public static int field1974 = 0;

	@ObfuscatedName("client.er")
	public static int field1975 = 1;

	@ObfuscatedName("client.es")
	public static int field2192 = 0;

	@ObfuscatedName("bw.ez")
	public static int[] field801;

	@ObfuscatedName("bo.ev")
	public static int[] field826;

	@ObfuscatedName("co.ei")
	public static int[] field1163;

	@ObfuscatedName("am.ef")
	public static int[][] mapKeys;

	@ObfuscatedName("ej.ej")
	public static byte[][] field1768;

	@ObfuscatedName("i.eh")
	public static byte[][] field186;

	@ObfuscatedName("cr.eg")
	public static World3D field1133;

	@ObfuscatedName("client.el")
	public static CollisionMap[] levelCollisionMap = new CollisionMap[4];

	@ObfuscatedName("client.en")
	public static boolean field1978 = false;

	@ObfuscatedName("client.ew")
	public static int[][][] field1979 = new int[4][13][13];

	@ObfuscatedName("client.ek")
	public static final int[] LOC_SHAPE_TO_LAYER = new int[] { 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3 };

	@ObfuscatedName("as.eq")
	public static int field351;

	@ObfuscatedName("cx.et")
	public static int field1485;

	@ObfuscatedName("client.ee")
	public static int field1981 = 0;

	@ObfuscatedName("client.ed")
	public static int[][] field2041 = new int[104][104];

	@ObfuscatedName("client.ex")
	public static int[][] field1946 = new int[104][104];

	@ObfuscatedName("client.ea")
	public static int[] field1984 = new int[4000];

	@ObfuscatedName("client.ep")
	public static int[] field1985 = new int[4000];

	@ObfuscatedName("client.em")
	public static int cameraAnticheatOffsetX = 0;

	@ObfuscatedName("client.ey")
	public static int cameraOffsetXModifier = 2;

	@ObfuscatedName("client.ec")
	public static int cameraAnticheatOffsetZ = 0;

	@ObfuscatedName("client.eo")
	public static int cameraOffsetZModifier = 2;

	@ObfuscatedName("client.eu")
	public static int cameraAnticheatAngle = 0;

	@ObfuscatedName("client.fd")
	public static int cameraOffsetYawModifier = 1;

	@ObfuscatedName("client.fb")
	public static int cameraOffsetCycle = 0;

	@ObfuscatedName("client.fc")
	public static int minimapAnticheatAngle = 0;

	@ObfuscatedName("client.fe")
	public static int minimapAngleModifier = 2;

	@ObfuscatedName("client.fj")
	public static int minimapZoom = 0;

	@ObfuscatedName("client.fp")
	public static int minimapZoomModifier = 1;

	@ObfuscatedName("client.fg")
	public static int minimapOffsetCycle = 0;

	@ObfuscatedName("client.fv")
	public static int sceneDelta = 0;

	@ObfuscatedName("al.fu")
	public static Pix32 field536;

	@ObfuscatedName("df.fr")
	public static Pix32 field1510;

	@ObfuscatedName("y.fl")
	public static Pix8[] field263;

	@ObfuscatedName("ez.fk")
	public static Pix32[] field1727;

	@ObfuscatedName("cp.fa")
	public static Pix32[] field1157;

	@ObfuscatedName("bf.fq")
	public static Pix32[] field816;

	@ObfuscatedName("i.ft")
	public static Pix32[] field187;

	@ObfuscatedName("ef.fx")
	public static Pix32[] field1744;

	@ObfuscatedName("bq.fs")
	public static Pix32[] field828;

	@ObfuscatedName("ej.fh")
	public static Pix32[] field1767;

	@ObfuscatedName("bs.ff")
	public static Pix32[] field741;

	@ObfuscatedName("ez.fy")
	public static Pix8[] field1726;

	@ObfuscatedName("ej.fn")
	public static Pix8[] field1769;

	@ObfuscatedName("by.fz")
	public static Pix8 field807;

	@ObfuscatedName("be.fw")
	public static int[] field853;

	@ObfuscatedName("g.fo")
	public static int[] field171;

	@ObfuscatedName("bq.fm")
	public static int[] field829;

	@ObfuscatedName("cd.fi")
	public static int[] field1474;

	@ObfuscatedName("client.ge")
	public static int field1919 = 2301979;

	@ObfuscatedName("client.gq")
	public static int field2113 = 5063219;

	@ObfuscatedName("client.gr")
	public static int field2095 = 3353893;

	@ObfuscatedName("client.gd")
	public static int field2002 = 7759444;

	@ObfuscatedName("client.gh")
	public static boolean field2003 = false;

	@ObfuscatedName("client.gm")
	public static int field2004 = 0;

	@ObfuscatedName("client.gl")
	public static int orbitCameraPitch = 128;

	@ObfuscatedName("client.gz")
	public static int orbitCameraYaw = 0;

	@ObfuscatedName("client.gp")
	public static int orbitCameraYawVelocity = 0;

	@ObfuscatedName("client.gf")
	public static int orbitCameraPitchVelocity = 0;

	@ObfuscatedName("client.gg")
	public static int sendCameraDelay = 0;

	@ObfuscatedName("client.gy")
	public static boolean sendCamera = false;

	@ObfuscatedName("client.gu")
	public static int cameraPitchClamp = 0;

	@ObfuscatedName("client.gb")
	public static int field2012 = 0;

	@ObfuscatedName("client.gs")
	public static int field2013 = 50;

	@ObfuscatedName("client.gi")
	public static int[] field2014 = new int[field2013];

	@ObfuscatedName("client.ga")
	public static int[] field2015 = new int[field2013];

	@ObfuscatedName("client.go")
	public static int[] field1930 = new int[field2013];

	@ObfuscatedName("client.gc")
	public static int[] field2017 = new int[field2013];

	@ObfuscatedName("client.hb")
	public static int[] field2154 = new int[field2013];

	@ObfuscatedName("client.hw")
	public static int[] field2019 = new int[field2013];

	@ObfuscatedName("client.hv")
	public static int[] field2020 = new int[field2013];

	@ObfuscatedName("client.he")
	public static String[] field2021 = new String[field2013];

	@ObfuscatedName("client.hk")
	public static int[][] field2022 = new int[104][104];

	@ObfuscatedName("client.hr")
	public static int field2023 = 0;

	@ObfuscatedName("client.hm")
	public static int field2140 = -1;

	@ObfuscatedName("client.hu")
	public static int field2025 = -1;

	@ObfuscatedName("client.hl")
	public static int field2026 = 0;

	@ObfuscatedName("client.hj")
	public static int field2027 = 0;

	@ObfuscatedName("client.hn")
	public static int crossCycle = 0;

	@ObfuscatedName("client.hs")
	public static int crossMode = 0;

	@ObfuscatedName("client.hi")
	public static int selectedCycle = 0;

	@ObfuscatedName("client.hd")
	public static int field2031 = 0;

	@ObfuscatedName("client.hq")
	public static int hoveredSlot = 0;

	@ObfuscatedName("client.hh")
	public static int objGrabX = 0;

	@ObfuscatedName("client.ht")
	public static int objGrabY = 0;

	@ObfuscatedName("client.hc")
	public static int objDragSlot = 0;

	@ObfuscatedName("client.hp")
	public static boolean objGrabThreshold = false;

	@ObfuscatedName("client.hx")
	public static int objDragCycles = 0;

	@ObfuscatedName("client.hy")
	public static int field2038 = 0;

	@ObfuscatedName("client.iq")
	public static PlayerEntity[] players = new PlayerEntity[2048];

	@ObfuscatedName("client.ie")
	public static int playerCount = 0;

	@ObfuscatedName("client.if")
	public static int[] playerIds = new int[2048];

	@ObfuscatedName("client.ih")
	public static int field2044 = 0;

	@ObfuscatedName("client.ic")
	public static int[] field2045 = new int[2048];

	@ObfuscatedName("client.im")
	public static Packet[] playerAppearanceBuffer = new Packet[2048];

	@ObfuscatedName("client.ik")
	public static int field2005 = -1;

	@ObfuscatedName("client.iy")
	public static int field2130 = 0;

	@ObfuscatedName("client.ij")
	public static int field2035 = 0;

	@ObfuscatedName("client.io")
	public static int[] field2198 = new int[1000];

	@ObfuscatedName("client.ia")
	public static final int[] field2052 = new int[] { 44, 45, 46, 47, 48, 49, 50, 51 };

	@ObfuscatedName("client.id")
	public static String[] field2053 = new String[8];

	@ObfuscatedName("client.ib")
	public static boolean[] field2054 = new boolean[8];

	@ObfuscatedName("client.il")
	public static int[] field1941 = new int[] { 768, 1024, 1280, 512, 1536, 256, 0, 1792 };

	@ObfuscatedName("client.ir")
	public static LinkList[][][] levelObjStacks = new LinkList[4][104][104];

	@ObfuscatedName("client.iv")
	public static LinkList temporaryLocs = new LinkList();

	@ObfuscatedName("client.ig")
	public static LinkList projectiles = new LinkList();

	@ObfuscatedName("client.ip")
	public static LinkList spotanims = new LinkList();

	@ObfuscatedName("client.iw")
	public static int[] field2060 = new int[25];

	@ObfuscatedName("client.iu")
	public static int[] field1960 = new int[25];

	@ObfuscatedName("client.jc")
	public static int[] field2062 = new int[25];

	@ObfuscatedName("client.je")
	public static int mouseButtonsOption = 0;

	@ObfuscatedName("client.jj")
	public static boolean field2066 = false;

	@ObfuscatedName("client.jp")
	public static int menuSize = 0;

	@ObfuscatedName("client.jg")
	public static int[] field2067 = new int[500];

	@ObfuscatedName("client.jn")
	public static int[] field2068 = new int[500];

	@ObfuscatedName("client.jr")
	public static int[] field2069 = new int[500];

	@ObfuscatedName("client.js")
	public static int[] field2070 = new int[500];

	@ObfuscatedName("client.jl")
	public static String[] field1994 = new String[500];

	@ObfuscatedName("client.jm")
	public static String[] field2072 = new String[500];

	@ObfuscatedName("client.jz")
	public static int field1971 = -1;

	@ObfuscatedName("client.jx")
	public static int field1976 = -1;

	@ObfuscatedName("client.ju")
	public static int field1995 = 0;

	@ObfuscatedName("client.ja")
	public static int field2076 = 50;

	@ObfuscatedName("client.jo")
	public static int field2077 = 0;

	@ObfuscatedName("client.it")
	public static String field2078 = null;

	@ObfuscatedName("client.jh")
	public static boolean field2079 = false;

	@ObfuscatedName("client.jw")
	public static int field2107 = -1;

	@ObfuscatedName("client.kn")
	public static String field2048 = null;

	@ObfuscatedName("client.kg")
	public static String field2082 = null;

	@ObfuscatedName("client.ki")
	public static int field2083 = -1;

	@ObfuscatedName("client.ky")
	public static HashTable field1918 = new HashTable(8);

	@ObfuscatedName("client.ko")
	public static int field2085 = 0;

	@ObfuscatedName("client.kl")
	public static int bankArrangeMode = 0;

	@ObfuscatedName("client.ka")
	public static IfType field2087 = null;

	@ObfuscatedName("client.kr")
	public static int field2080 = 0;

	@ObfuscatedName("client.ku")
	public static int field2089 = 0;

	@ObfuscatedName("client.kp")
	public static int field2049 = 0;

	@ObfuscatedName("client.kw")
	public static boolean field2091 = false;

	@ObfuscatedName("client.kc")
	public static boolean field2092 = false;

	@ObfuscatedName("client.km")
	public static boolean field2001 = false;

	@ObfuscatedName("client.ke")
	public static IfType field2094 = null;

	@ObfuscatedName("client.kx")
	public static IfType field2162 = null;

	@ObfuscatedName("client.kk")
	public static int field2115 = 0;

	@ObfuscatedName("client.kb")
	public static int field2097 = 0;

	@ObfuscatedName("client.kj")
	public static IfType field2098 = null;

	@ObfuscatedName("client.kd")
	public static boolean field2126 = false;

	@ObfuscatedName("client.kv")
	public static int field2183 = -1;

	@ObfuscatedName("client.kf")
	public static int field2101 = -1;

	@ObfuscatedName("client.kz")
	public static boolean field2102 = false;

	@ObfuscatedName("client.kq")
	public static int field2103 = -1;

	@ObfuscatedName("client.ks")
	public static int field2104 = -1;

	@ObfuscatedName("client.kh")
	public static boolean field1927 = false;

	@ObfuscatedName("client.lg")
	public static int field2117 = 1;

	@ObfuscatedName("client.lp")
	public static int[] field2110 = new int[32];

	@ObfuscatedName("client.lq")
	public static int field2084 = 0;

	@ObfuscatedName("client.lk")
	public static int[] field2112 = new int[32];

	@ObfuscatedName("client.lm")
	public static int field2050 = 0;

	@ObfuscatedName("client.lb")
	public static int[] field1999 = new int[32];

	@ObfuscatedName("client.ln")
	public static int field1982 = 0;

	@ObfuscatedName("client.li")
	public static int field2116 = 0;

	@ObfuscatedName("client.lc")
	public static int field1977 = 0;

	@ObfuscatedName("client.lw")
	public static int field2185 = 0;

	@ObfuscatedName("client.lv")
	public static int field2119 = 0;

	@ObfuscatedName("client.lx")
	public static int[] field2120 = new int[2000];

	@ObfuscatedName("client.ld")
	public static String[] field1996 = new String[1000];

	@ObfuscatedName("client.le")
	public static int field2122 = 0;

	@ObfuscatedName("client.lt")
	public static LinkList hookRequests = new LinkList();

	@ObfuscatedName("client.lo")
	public static LinkList hookRequestsTimer = new LinkList();

	@ObfuscatedName("client.lf")
	public static LinkList hookRequestsMouseStop = new LinkList();

	@ObfuscatedName("client.lz")
	public static HashTable field2061 = new HashTable(512);

	@ObfuscatedName("client.mw")
	public static int field2121 = 0;

	@ObfuscatedName("client.mo")
	public static int field2063 = -2;

	@ObfuscatedName("client.mq")
	public static boolean[] field2175 = new boolean[100];

	@ObfuscatedName("client.me")
	public static boolean[] field2131 = new boolean[100];

	@ObfuscatedName("client.mn")
	public static boolean[] field2132 = new boolean[100];

	@ObfuscatedName("client.mi")
	public static int[] field2133 = new int[100];

	@ObfuscatedName("client.mh")
	public static int[] field2007 = new int[100];

	@ObfuscatedName("client.mp")
	public static int[] field2135 = new int[100];

	@ObfuscatedName("client.ma")
	public static int[] field2136 = new int[100];

	@ObfuscatedName("client.ms")
	public static int field2137 = 0;

	@ObfuscatedName("client.mt")
	public static int[] field2139 = new int[100];

	@ObfuscatedName("client.mc")
	public static String[] field2046 = new String[100];

	@ObfuscatedName("client.mr")
	public static String[] field2173 = new String[100];

	@ObfuscatedName("client.mx")
	public static String[] field2142 = new String[100];

	@ObfuscatedName("client.mv")
	public static int field2141 = 0;

	@ObfuscatedName("client.my")
	public static int[] field2144 = new int[] { 16776960, 16711680, 65280, 65535, 16711935, 16777215 };

	@ObfuscatedName("client.mf")
	public static int field2145 = 0;

	@ObfuscatedName("client.mz")
	public static int field2146 = 0;

	@ObfuscatedName("client.mj")
	public static long[] field2148 = new long[100];

	@ObfuscatedName("client.ml")
	public static int field2149 = 0;

	@ObfuscatedName("client.mk")
	public static int field2151 = 0;

	@ObfuscatedName("client.mb")
	public static int[] field2152 = new int[128];

	@ObfuscatedName("client.ne")
	public static int[] field2153 = new int[128];

	@ObfuscatedName("client.nc")
	public static String field1955 = null;

	@ObfuscatedName("client.nh")
	public static String field2155 = null;

	@ObfuscatedName("client.nw")
	public static int minimapLevel = -1;

	@ObfuscatedName("client.nb")
	public static int field2157 = 0;

	@ObfuscatedName("client.ng")
	public static int[] field2158 = new int[1000];

	@ObfuscatedName("client.nu")
	public static int[] field2159 = new int[1000];

	@ObfuscatedName("client.no")
	public static Pix32[] field2160 = new Pix32[1000];

	@ObfuscatedName("client.nv")
	public static int flagSceneTileX = 0;

	@ObfuscatedName("client.nz")
	public static int flagSceneTileZ = 0;

	@ObfuscatedName("client.nt")
	public static int minimapState = 0;

	@ObfuscatedName("client.nl")
	public static int field2169 = 255;

	@ObfuscatedName("client.nn")
	public static int field2170 = -1;

	@ObfuscatedName("client.nq")
	public static boolean field2189 = false;

	@ObfuscatedName("client.nf")
	public static int field1952 = 127;

	@ObfuscatedName("client.oz")
	public static int field2174 = 127;

	@ObfuscatedName("client.os")
	public static int field2176 = 0;

	@ObfuscatedName("client.oe")
	public static int[] field2177 = new int[50];

	@ObfuscatedName("client.of")
	public static int[] field2006 = new int[50];

	@ObfuscatedName("client.ov")
	public static int[] field2179 = new int[50];

	@ObfuscatedName("client.oo")
	public static int[] field2180 = new int[50];

	@ObfuscatedName("client.ok")
	public static Wave[] field2181 = new Wave[50];

	@ObfuscatedName("client.oa")
	public static boolean cutscene = false;

	@ObfuscatedName("client.ol")
	public static boolean[] field2184 = new boolean[5];

	@ObfuscatedName("client.oj")
	public static int[] field2187 = new int[5];

	@ObfuscatedName("client.pk")
	public static int[] field2186 = new int[5];

	@ObfuscatedName("client.pt")
	public static int[] field2163 = new int[5];

	@ObfuscatedName("client.ps")
	public static int[] cameraModifierCycle = new int[5];

	@ObfuscatedName("client.pi")
	public static int field2071 = 0;

	@ObfuscatedName("client.pq")
	public static int field2171 = 0;

	@ObfuscatedName("client.pf")
	public static FriendListEntry[] field2111 = new FriendListEntry[200];

	@ObfuscatedName("client.pm")
	public static NodeLinkList field2193 = new NodeLinkList();

	@ObfuscatedName("client.pr")
	public static int field2194 = 0;

	@ObfuscatedName("client.pe")
	public static IgnoreListEntry[] field2196 = new IgnoreListEntry[100];

	@ObfuscatedName("client.pd")
	public static PlayerModel field2197 = new PlayerModel();

	@ObfuscatedName("client.pv")
	public static int field2018 = -1;

	@ObfuscatedName("client.pz")
	public static int field2199 = -1;

	@ObfuscatedName("cz.ny")
	public static byte field1217;

	@ObfuscatedName("df.nr")
	public static byte field1511;

	@ObfuscatedName("br.om")
	public static int cutsceneSrcLocalTileZ;

	@ObfuscatedName("bb.gk")
	public static int cameraPitch;

	@ObfuscatedName("ca.gv")
	public static int orbitCameraX;

	@ObfuscatedName("ca.jf")
	public static int field1161;

	@ObfuscatedName("co.op")
	public static int cutsceneMoveAcceleration;

	@ObfuscatedName("cv.ll")
	public static int field1219;

	@ObfuscatedName("cv.nm")
	public static int field1220;

	@ObfuscatedName("ct.gw")
	public static int cameraX;

	@ObfuscatedName("ct.or")
	public static int cutsceneDstLocalTileX;

	@ObfuscatedName("cq.ob")
	public static int cutsceneDstHeight;

	@ObfuscatedName("df.ou")
	public static int cutsceneRotateAcceleration;

	@ObfuscatedName("dq.oq")
	public static int cutsceneSrcHeight;

	@ObfuscatedName("du.oh")
	public static int cutsceneMoveSpeed;

	@ObfuscatedName("de.oy")
	public static int cutsceneRotateSpeed;

	@ObfuscatedName("dl.gt")
	public static int orbitCameraZ;

	@ObfuscatedName("client.lh")
	public static int field2106;

	@ObfuscatedName("y.gj")
	public static int cameraZ;

	@ObfuscatedName("ak.kt")
	public static int field386;

	@ObfuscatedName("m.jd")
	public static int field42;

	@ObfuscatedName("m.jv")
	public static int field43;

	@ObfuscatedName("m.la")
	public static int field44;

	@ObfuscatedName("an.ix")
	public static int field502;

	@ObfuscatedName("al.in")
	public static int currentLevel;

	@ObfuscatedName("al.jt")
	public static int field535;

	@ObfuscatedName("ag.iz")
	public static int field555;

	@ObfuscatedName("ag.jb")
	public static int field557;

	@ObfuscatedName("bs.gx")
	public static int cameraYaw;

	@ObfuscatedName("bk.ji")
	public static int field743;

	@ObfuscatedName("bv.gn")
	public static int cameraY;

	@ObfuscatedName("be.ox")
	public static int cutsceneSrcLocalTileX;

	@ObfuscatedName("bp.og")
	public static int cutsceneDstLocalTileZ;

	@ObfuscatedName("cv.hg")
	public static IfType hoveredSlotParent;

	@ObfuscatedName("ck.ha")
	public static IfType objDragInterface;

	@ObfuscatedName("l.jy")
	public static IfType field37;

	@ObfuscatedName("at.jq")
	public static IfType field654;

	@ObfuscatedName("be.hf")
	public static IfType selectedArea;

	@ObfuscatedName("cq.oc")
	public static MixerPcmStream field1460;

	@ObfuscatedName("dl.ns")
	public static Pix32 field1627;

	@ObfuscatedName("cr.ii")
	public static PlayerEntity localPlayer;

	@ObfuscatedName("dr.oi")
	public static AudioChannel field1585;

	@ObfuscatedName("l.on")
	public static AudioChannel field38;

	@ObfuscatedName("ev.od")
	public static PcmResampler field1733;

	@ObfuscatedName("az.lu")
	public static MouseWheelProvider field484;

	@ObfuscatedName("r.pa")
	public static FileStream field10;

	@ObfuscatedName("au.mg")
	public static ChatFilterPrivacy field680;

	@ObfuscatedName("eh.nd")
	public static ClanMember[] field1774;

	@ObfuscatedName("dz.lj")
	public static IfType[] field1516;

	@ObfuscatedName("client.f(I)V")
	public final void method1373() {
	}

	public static void main(String[] args) {
		Client app = new Client();
		app.initApplication(765, 503, 1);
	}

	@Override
	public URL getCodeBase() {
		try {
			if (GameShell.frame != null) {
				return new URL("http://localhost");
			}
		} catch (Exception ignore) {
		}

		return super.getDocumentBase();
	}

	@Override
	public URL getDocumentBase() {
		return this.getCodeBase();
	}

	@Override
	public String getParameter(String name) {
		if (name.equals(JavConfigParameter.MODEWHAT.id)) {
			return String.valueOf(ModeWhat.WIP.id);
		} else if (name.equals(JavConfigParameter.MODEWHERE.id)) {
			// todo: modewhere enum?
			return "2";
		} else if (name.equals(JavConfigParameter.MEMBERS.id)) {
			return "true";
		} else if (name.equals(JavConfigParameter.WORLDLIST_URL.id)) {
			return "http://localhost/slr.ws?order=LPWM";
		}

		return null;
	}

	public final void init() {
		if (!this.checkhost()) {
			return;
		}
		JavConfigParameter[] var1 = new JavConfigParameter[] { JavConfigParameter.MEMBERS, JavConfigParameter.LANG, JavConfigParameter.WORLDLIST_URL, JavConfigParameter.PLUG, JavConfigParameter.WORLDID, JavConfigParameter.MODEWHERE, JavConfigParameter.JS, JavConfigParameter.GAME, JavConfigParameter.MODEWHAT };
		JavConfigParameter[] var2 = var1;
		for (int var3 = 0; var3 < var2.length; var3++) {
			JavConfigParameter var4 = var2[var3];
			String var5 = this.getParameter(var4.id);
			if (var5 != null) {
				switch(Integer.parseInt(var4.id)) {
					case 1:
						if (var5.equalsIgnoreCase(TextUtil.truthy)) {
							js = 1;
						} else {
							js = 0;
						}
						break;
					case 2:
						worldid = Integer.parseInt(var5);
					case 3:
					default:
						break;
					case 4:
						lang = Integer.parseInt(var5);
						break;
					case 5:
						int var6 = Integer.parseInt(var5);
						ModeWhat[] var7 = new ModeWhat[] { ModeWhat.RC, ModeWhat.WIP, ModeWhat.BUILDLIVE, ModeWhat.LIVE };
						ModeWhat[] var8 = var7;
						int var9 = 0;
						ModeWhat var11;
						while (true) {
							if (var9 >= var8.length) {
								var11 = null;
								break;
							}
							ModeWhat var10 = var8[var9];
							if (var10.id == var6) {
								var11 = var10;
								break;
							}
							var9++;
						}
						modewhat = var11;
						break;
					case 6:
						if (var5.equalsIgnoreCase(TextUtil.truthy)) {
							members = true;
						} else {
							members = false;
						}
						break;
					case 7:
						modewhere = Integer.parseInt(var5);
						break;
					case 8:
						ModeGame[] var12 = ModeGame.values();
						int var13 = Integer.parseInt(var5);
						ModeGame[] var14 = var12;
						int var15 = 0;
						ModeGame var17;
						while (true) {
							if (var15 >= var14.length) {
								var17 = null;
								break;
							}
							ModeGame var16 = var14[var15];
							if (var13 == var16.getGame()) {
								var17 = var16;
								break;
							}
							var15++;
						}
						modegame = (ModeGame) var17;
						if (ModeGame.OLDSCAPE == modegame) {
							namespace = Namespace.OLDSCAPE;
						} else {
							namespace = Namespace.LEGACY;
						}
						break;
					case 9:
						LoginScreen.worldlistUrl = var5;
				}
			}
		}
		World3D.field593 = false;
		lowMemory = false;
		field52 = this.getCodeBase().getHost();
		String var18 = modewhat.name;
		byte var19 = 0;
		try {
			SignLinkCacheFolder.archiveCount = 16;
			SignLinkCacheFolder.field368 = var19;
			try {
				SignLinkCacheFolder.field294 = System.getProperty("os.name");
			} catch (Exception var37) {
				SignLinkCacheFolder.field294 = "Unknown";
			}
			SignLinkCacheFolder.field199 = SignLinkCacheFolder.field294.toLowerCase();
			try {
				SignLinkCacheFolder.homeDir = System.getProperty("user.home");
				if (SignLinkCacheFolder.homeDir != null) {
					SignLinkCacheFolder.homeDir = SignLinkCacheFolder.homeDir + "/";
				}
			} catch (Exception var36) {
			}
			try {
				if (SignLinkCacheFolder.field199.startsWith("win")) {
					if (SignLinkCacheFolder.homeDir == null) {
						SignLinkCacheFolder.homeDir = System.getenv("USERPROFILE");
					}
				} else if (SignLinkCacheFolder.homeDir == null) {
					SignLinkCacheFolder.homeDir = System.getenv("HOME");
				}
				if (SignLinkCacheFolder.homeDir != null) {
					SignLinkCacheFolder.homeDir = SignLinkCacheFolder.homeDir + "/";
				}
			} catch (Exception var35) {
			}
			if (SignLinkCacheFolder.homeDir == null) {
				SignLinkCacheFolder.homeDir = "~/";
			}
			SignLinkCacheFolder.historicCacheLocations = new String[] { "c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", SignLinkCacheFolder.homeDir, "/tmp/", "" };
			SignLinkCacheFolder.historicCacheDirectories = new String[] { ".jagex_cache_" + SignLinkCacheFolder.field368, ".file_store_" + SignLinkCacheFolder.field368 };
			label130: for (int var23 = 0; var23 < 4; var23++) {
				SignLinkCacheFolder.cacheDirectory = SignLinkCacheFolder.method102("oldschool", var18, var23);
				if (!SignLinkCacheFolder.cacheDirectory.exists()) {
					SignLinkCacheFolder.cacheDirectory.mkdirs();
				}
				File[] var24 = SignLinkCacheFolder.cacheDirectory.listFiles();
				if (var24 == null) {
					break;
				}
				File[] var25 = var24;
				int var26 = 0;
				while (true) {
					if (var26 >= var25.length) {
						break label130;
					}
					File var27 = var25[var26];
					boolean var30;
					try {
						RandomAccessFile var28 = new RandomAccessFile(var27, "rw");
						int var29 = var28.read();
						var28.seek(0L);
						var28.write(var29);
						var28.seek(0L);
						var28.close();
						var30 = true;
					} catch (Exception var34) {
						var30 = false;
					}
					if (!var30) {
						break;
					}
					var26++;
				}
			}
			CacheUtil.method61(SignLinkCacheFolder.cacheDirectory);
			SignLinkCacheFolder.method1166();
			SignLinkCacheFolder.cacheDat = new BufferedFile(new FileOnDisk(CacheUtil.method1039("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
			SignLinkCacheFolder.masterIndex = new BufferedFile(new FileOnDisk(CacheUtil.method1039("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
			SignLinkCacheFolder.cacheIndex = new BufferedFile[SignLinkCacheFolder.archiveCount];
			for (int var32 = 0; var32 < SignLinkCacheFolder.archiveCount; var32++) {
				SignLinkCacheFolder.cacheIndex[var32] = new BufferedFile(new FileOnDisk(CacheUtil.method1039("main_file_cache.idx" + var32), "rw", 1048576L), 6000, 0);
			}
		} catch (Exception var38) {
			JagException.report(null, (Throwable) var38);
		}
		this.method1354(765, 503, 1);
	}

	@ObfuscatedName("client.w(I)V")
	public final void maininit() {
		field1641 = modewhere == 0 ? 43594 : worldid + 40000;
		field13 = modewhere == 0 ? 443 : worldid + 50000;
		field1204 = field1641;
		PlayerModel.field51 = PlayerCustomisation.field1215;
		PlayerModel.field800 = PlayerCustomisation.field1214;
		PlayerModel.field1224 = PlayerCustomisation.field1213;
		PlayerModel.field1229 = PlayerCustomisation.field1216;
		JavaKeyboardProvider.imethod1();
		JavaKeyboardProvider.method53(GameShell.canvas);
		JavaMouseProvider.method163(GameShell.canvas);
		field484 = MouseWheelProvider.method779();
		if (field484 != null) {
			field484.method360(GameShell.canvas);
		}
		field10 = new FileStream(255, SignLinkCacheFolder.cacheDat, SignLinkCacheFolder.masterIndex, 500000);
		if (modewhere != 0) {
			field1991 = true;
		}
	}

	@ObfuscatedName("client.e(B)V")
	public final void mainloop() {
		loopCycle++;
		this.method1849();
		imethod1();
		MidiPlayer.method825();
		method1351();
		imethod2();
		imethod3();
		if (field484 != null) {
			int var10 = field484.method362();
			field2122 = var10;
		}
		if (gameState == 0) {
			method780();
			GameShell.method770();
		} else if (gameState == 5) {
			LoginScreen.method3(this);
			method780();
			GameShell.method770();
		} else if (gameState == 10) {
			LoginScreen.method3(this);
		} else if (gameState == 20) {
			LoginScreen.method3(this);
			updateTitle();
		} else if (gameState == 25) {
			imethod4();
		} else if (gameState == 30) {
			imethod12();
		} else if (gameState == 40) {
			updateTitle();
		}
	}

	@ObfuscatedName("client.b(I)V")
	public final void mainredraw() {
		boolean var1 = MidiPlayer.method511();
		if (var1 && field2189 && field38 != null) {
			field38.method208();
		}
		if (canvasReplaceRecommended) {
			JavaKeyboardProvider.method1143(GameShell.canvas);
			JavaMouseProvider.imethod1(GameShell.canvas);
			if (field484 != null) {
				field484.method361(GameShell.canvas);
			}
			this.addcanvas();
			JavaKeyboardProvider.method53(GameShell.canvas);
			JavaMouseProvider.method163(GameShell.canvas);
			if (field484 != null) {
				field484.method360(GameShell.canvas);
			}
		}
		if (gameState == 0) {
			GameShell.imethod1(LoginScreen.progress, LoginScreen.message, null);
		} else if (gameState == 5) {
			LoginScreen.method784(field704, field1621);
		} else if (gameState == 10) {
			LoginScreen.method784(field704, field1621);
		} else if (gameState == 20) {
			LoginScreen.method784(field704, field1621);
		} else if (gameState == 25) {
			if (field2192 == 1) {
				if (field1972 > field2024) {
					field2024 = field1972;
				}
				int var12 = (field2024 * 50 - field1972 * 50) / field2024;
				method1789(EnglishLocale.field873 + TextUtil.br + TextUtil.openParen + var12 + "%" + TextUtil.closeParen, false);
			} else if (field2192 == 2) {
				if (field1974 > field1975) {
					field1975 = field1974;
				}
				int var13 = (field1975 * 50 - field1974 * 50) / field1975 + 50;
				method1789(EnglishLocale.field873 + TextUtil.br + TextUtil.openParen + var13 + "%" + TextUtil.closeParen, false);
			} else {
				method1789(EnglishLocale.field873, false);
			}
		} else if (gameState == 30) {
			imethod22();
		} else if (gameState == 40) {
			method1789(EnglishLocale.field874 + TextUtil.br + EnglishLocale.field875, false);
		}

		if (gameState == 30 && field2137 == 0 && !fullredraw) {
			try {
				Graphics var43 = GameShell.canvas.getGraphics();
				for (int var44 = 0; var44 < field2121; var44++) {
					if (field2131[var44]) {
						GameShell.drawArea.method546(var43, field2133[var44], field2007[var44], field2135[var44], field2136[var44]);
						field2131[var44] = false;
					}
				}
			} catch (Exception var52) {
				GameShell.canvas.repaint();
			}
		} else if (gameState > 0) {
			try {
				Graphics var46 = GameShell.canvas.getGraphics();
				GameShell.drawArea.method545(var46, 0, 0);
				fullredraw = false;
				for (int var47 = 0; var47 < field2121; var47++) {
					field2131[var47] = false;
				}
			} catch (Exception var51) {
				GameShell.canvas.repaint();
			}
		}
	}

	@ObfuscatedName("client.y(B)V")
	public final void mainquit() {
		if (mouseTracking != null) {
			mouseTracking.active = false;
		}
		mouseTracking = null;
		if (stream != null) {
			stream.close();
			stream = null;
		}
		JavaKeyboardProvider.method1502();
		JavaMouseProvider.imethod2();
		field484 = null;
		if (field38 != null) {
			field38.method248();
		}
		if (field1585 != null) {
			field1585.method248();
		}
		if (LoginScreen.field169 != null) {
			LoginScreen.field169.close();
		}
		Js5ProviderThread.method781();
		SignLinkCacheFolder.method1141();
	}

	@ObfuscatedName("aj.ce(II)V")
	public static void method729(int arg0) {
		if (gameState == arg0) {
			return;
		}
		if (gameState == 0) {
			GameShell.imethod2();
		}
		if (arg0 == 20 || arg0 == 40) {
			loginState = 0;
			field1948 = 0;
			field2105 = 0;
		}
		if (arg0 != 20 && arg0 != 40 && field53 != null) {
			field53.close();
			field53 = null;
		}
		if (gameState == 25) {
			field2192 = 0;
			field1972 = 0;
			field2024 = 1;
			field1974 = 0;
			field1975 = 1;
		}
		if (arg0 == 5 || arg0 == 10 || arg0 == 20) {
			LoginScreen.imethod9(GameShell.canvas, field544, field1944);
		} else {
			LoginScreen.method831();
		}
		gameState = arg0;
	}

	@ObfuscatedName("client.ci(I)V")
	public void method1849() {
		if (gameState != 1000) {
			boolean var1 = Js5TcpClient.method826();
			if (!var1) {
				this.method1850();
			}
		}
	}

	@ObfuscatedName("client.cb(I)V")
	public void method1850() {
		if (Js5TcpClient.field1198 >= 4) {
			this.error("js5crc");
			gameState = 1000;
			return;
		}
		if (Js5TcpClient.field1203 >= 4) {
			if (gameState <= 5) {
				this.error("js5io");
				gameState = 1000;
				return;
			}
			field1942 = 3000;
			Js5TcpClient.field1203 = 3;
		}
		if (--field1942 + 1 > 0) {
			return;
		}
		try {
			if (field2090 == 0) {
				field36 = GameShell.signlink.method451(field52, field1204);
				field2090++;
			}
			if (field2090 == 1) {
				if (field36.field507 == 2) {
					this.method1851(-1);
					return;
				}
				if (field36.field507 == 1) {
					field2090++;
				}
			}
			if (field2090 == 2) {
				field1102 = new ClientStream((Socket) field36.field511, GameShell.signlink);
				Packet var1 = new Packet(5);
				var1.p1(15);
				var1.p4(1);
				field1102.write(var1.data, 0, 5);
				field2090++;
				field1943 = MonotonicTime.method1135();
			}
			if (field2090 == 3) {
				if (gameState <= 5 || field1102.available() > 0) {
					int var2 = field1102.read();
					if (var2 != 0) {
						this.method1851(var2);
						return;
					}
					field2090++;
				} else if (MonotonicTime.method1135() - field1943 > 30000L) {
					this.method1851(-2);
					return;
				}
			}
			if (field2090 == 4) {
				Js5TcpClient.method96(field1102, gameState > 20);
				field36 = null;
				field1102 = null;
				field2090 = 0;
				field1986 = 0;
			}
		} catch (IOException var4) {
			this.method1851(-3);
		}
	}

	@ObfuscatedName("client.cf(II)V")
	public void method1851(int arg0) {
		field36 = null;
		field1102 = null;
		field2090 = 0;
		if (field1641 == field1204) {
			field1204 = field13;
		} else {
			field1204 = field1641;
		}
		field1986++;
		if (field1986 >= 2 && (arg0 == 7 || arg0 == 9)) {
			if (gameState <= 5) {
				this.error("js5connect_full");
				gameState = 1000;
			} else {
				field1942 = 3000;
			}
		} else if (field1986 >= 2 && arg0 == 6) {
			this.error("js5connect_outofdate");
			gameState = 1000;
		} else if (field1986 >= 4) {
			if (gameState <= 5) {
				this.error("js5connect");
				gameState = 1000;
			} else {
				field1942 = 3000;
			}
		}
	}

	@ObfuscatedName("bv.cg(B)V")
	public static void method780() {
		if (field1940 == 0) {
			field1133 = new World3D(4, 104, 104, World.levelHeightmap);
			for (int var0 = 0; var0 < 4; var0++) {
				levelCollisionMap[var0] = new CollisionMap(104, 104);
			}
			field1627 = new Pix32(512, 512);
			LoginScreen.message = EnglishLocale.field876;
			LoginScreen.progress = 5;
			field1940 = 20;
		} else if (field1940 == 20) {
			int[] var1 = new int[9];
			for (int var2 = 0; var2 < 9; var2++) {
				int var3 = var2 * 32 + 128 + 15;
				int var4 = var3 * 3 + 600;
				int var5 = Pix3D.sinTable[var3];
				var1[var2] = var4 * var5 >> 16;
			}
			World3D.method599(var1, 500, 800, 512, 334);
			LoginScreen.message = EnglishLocale.field1026;
			LoginScreen.progress = 10;
			field1940 = 30;
		} else if (field1940 == 30) {
			field1109 = method129(0, false, true, true);
			field1720 = method129(1, false, true, true);
			configJs5 = method129(2, true, false, true);
			field1123 = method129(3, false, true, true);
			field1509 = method129(4, false, true, true);
			field1270 = method129(5, true, true, true);
			field1110 = method129(6, true, true, false);
			modelJs5 = method129(7, false, true, true);
			field1944 = method129(8, false, true, true);
			field1966 = method129(9, false, true, true);
			field544 = method129(10, false, true, true);
			field1515 = method129(11, false, true, true);
			field1232 = method129(12, false, true, true);
			field1150 = method129(13, true, false, true);
			field2353 = method129(14, false, true, false);
			field126 = method129(15, false, true, true);
			LoginScreen.message = EnglishLocale.field960;
			LoginScreen.progress = 20;
			field1940 = 40;
		} else if (field1940 == 40) {
			byte var6 = 0;
			int var7 = var6 + field1109.method1483() * 4 / 100;
			int var8 = var7 + field1720.method1483() * 4 / 100;
			int var9 = var8 + configJs5.method1483() * 2 / 100;
			int var10 = var9 + field1123.method1483() * 2 / 100;
			int var11 = var10 + field1509.method1483() * 6 / 100;
			int var12 = var11 + field1270.method1483() * 4 / 100;
			int var13 = var12 + field1110.method1483() * 2 / 100;
			int var14 = var13 + modelJs5.method1483() * 60 / 100;
			int var15 = var14 + field1944.method1483() * 2 / 100;
			int var16 = var15 + field1966.method1483() * 2 / 100;
			int var17 = var16 + field544.method1483() * 2 / 100;
			int var18 = var17 + field1515.method1483() * 2 / 100;
			int var19 = var18 + field1232.method1483() * 2 / 100;
			int var20 = var19 + field1150.method1483() * 2 / 100;
			int var21 = var20 + field2353.method1483() * 2 / 100;
			int var22 = var21 + field126.method1483() * 2 / 100;
			if (var22 == 100) {
				LoginScreen.message = EnglishLocale.field880;
				LoginScreen.progress = 30;
				field1940 = 45;
			} else {
				if (var22 != 0) {
					LoginScreen.message = EnglishLocale.field1049 + var22 + "%";
				}
				LoginScreen.progress = 30;
			}
		} else if (field1940 == 45) {
			AudioChannel.method832(22050, !lowMemory, 2);
			MidiPcmStream var23 = new MidiPcmStream();
			var23.method2201(9, 128);
			field38 = AudioChannel.method1132(GameShell.signlink, GameShell.canvas, 0, 22050);
			field38.method240(var23);
			MidiPlayer.method1511(field126, field2353, field1509, var23);
			field1585 = AudioChannel.method1132(GameShell.signlink, GameShell.canvas, 1, 2048);
			field1460 = new MixerPcmStream();
			field1585.method240(field1460);
			field1733 = new PcmResampler(22050, AudioChannel.field241);
			LoginScreen.message = EnglishLocale.field911;
			LoginScreen.progress = 35;
			field1940 = 50;
		} else if (field1940 == 50) {
			int var24 = 0;
			if (field1621 == null) {
				field1621 = SpriteDataProvider.method817(field1944, field1150, "p11_full", "");
			} else {
				var24++;
			}
			if (field1122 == null) {
				field1122 = SpriteDataProvider.method817(field1944, field1150, "p12_full", "");
			} else {
				var24++;
			}
			if (field704 == null) {
				field704 = SpriteDataProvider.method817(field1944, field1150, "b12_full", "");
			} else {
				var24++;
			}
			if (var24 < 3) {
				LoginScreen.message = EnglishLocale.field882 + var24 * 100 / 3 + "%";
				LoginScreen.progress = 40;
			} else {
				LoginScreen.message = EnglishLocale.field883;
				LoginScreen.progress = 40;
				field1940 = 60;
			}
		} else if (field1940 == 60) {
			Js5Provider var25 = field544;
			Js5Provider var26 = field1944;
			int var27 = 0;
			if (var25.requestDownload("title.jpg", "")) {
				var27++;
			}
			if (var26.requestDownload("logo", "")) {
				var27++;
			}
			if (var26.requestDownload("titlebox", "")) {
				var27++;
			}
			if (var26.requestDownload("titlebutton", "")) {
				var27++;
			}
			if (var26.requestDownload("runes", "")) {
				var27++;
			}
			if (var26.requestDownload("title_mute", "")) {
				var27++;
			}
			var26.requestDownload("sl_back", "");
			var26.requestDownload("sl_flags", "");
			var26.requestDownload("sl_arrows", "");
			var26.requestDownload("sl_stars", "");
			var26.requestDownload("sl_button", "");
			int var30 = LoginScreen.method162();
			if (var27 < var30) {
				LoginScreen.message = EnglishLocale.field884 + var27 * 100 / var30 + "%";
				LoginScreen.progress = 50;
			} else {
				LoginScreen.message = EnglishLocale.field885;
				LoginScreen.progress = 50;
				method729(5);
				field1940 = 70;
			}
		} else if (field1940 == 70) {
			if (configJs5.fetchAll()) {
				Js5Provider var31 = configJs5;
				FloType.configJs5 = var31;
				FluType.init(configJs5);
				IdkType.init(configJs5, modelJs5);
				LocType.init(configJs5, modelJs5, lowMemory);
				NpcType.init(configJs5, modelJs5);
				Js5Provider var32 = configJs5;
				Js5Provider var33 = modelJs5;
				boolean var34 = members;
				SoftwareFont var35 = field1621;
				ObjType.configJs5 = var32;
				ObjType.modelJs5 = var33;
				ObjType.membersWorld = var34;
				ObjType.configJs5.getFileCount(10);
				ObjType.field815 = var35;
				SeqType.init(configJs5, field1109, field1720);
				Js5Provider var36 = configJs5;
				Js5Provider var37 = modelJs5;
				SpotAnimType.configJs5 = var36;
				SpotAnimType.modelJs5 = var37;
				Js5Provider var38 = configJs5;
				VarBitType.configJs5 = var38;
				VarPlayerType.init(configJs5);
				IfType.init(field1123, modelJs5, field1944, field1150);
				Js5Provider var39 = configJs5;
				InvType.configJs5 = var39;
				Js5Provider var40 = configJs5;
				EnumType.configJs5 = var40;
				LoginScreen.message = EnglishLocale.field887;
				LoginScreen.progress = 60;
				field1940 = 80;
			} else {
				LoginScreen.message = EnglishLocale.field962 + configJs5.method1470() + "%";
				LoginScreen.progress = 60;
			}
		} else if (field1940 == 80) {
			int var41 = 0;
			if (field536 == null) {
				field536 = SpriteDataProvider.method4(field1944, "compass", "");
			} else {
				var41++;
			}
			if (field1510 == null) {
				field1510 = SpriteDataProvider.method4(field1944, "mapedge", "");
			} else {
				var41++;
			}
			if (field263 == null) {
				field263 = SpriteDataProvider.method541(field1944, "mapscene", "");
			} else {
				var41++;
			}
			if (field1727 == null) {
				field1727 = SpriteDataProvider.method830(field1944, "mapfunction", "");
			} else {
				var41++;
			}
			if (field1157 == null) {
				field1157 = SpriteDataProvider.method830(field1944, "hitmarks", "");
			} else {
				var41++;
			}
			if (field816 == null) {
				field816 = SpriteDataProvider.method830(field1944, "headicons_pk", "");
			} else {
				var41++;
			}
			if (field187 == null) {
				field187 = SpriteDataProvider.method830(field1944, "headicons_prayer", "");
			} else {
				var41++;
			}
			if (field1744 == null) {
				field1744 = SpriteDataProvider.method830(field1944, "headicons_hint", "");
			} else {
				var41++;
			}
			if (field828 == null) {
				field828 = SpriteDataProvider.method830(field1944, "mapmarker", "");
			} else {
				var41++;
			}
			if (field1767 == null) {
				field1767 = SpriteDataProvider.method830(field1944, "cross", "");
			} else {
				var41++;
			}
			if (field741 == null) {
				field741 = SpriteDataProvider.method830(field1944, "mapdots", "");
			} else {
				var41++;
			}
			if (field1726 == null) {
				field1726 = SpriteDataProvider.method541(field1944, "scrollbar", "");
			} else {
				var41++;
			}
			if (field1769 == null) {
				field1769 = SpriteDataProvider.method541(field1944, "mod_icons", "");
			} else {
				var41++;
			}
			if (field807 == null) {
				field807 = SpriteDataProvider.method457(field1944, "mapback", "");
			} else {
				var41++;
			}
			if (var41 < 14) {
				LoginScreen.message = EnglishLocale.field888 + var41 * 100 / 14 + "%";
				LoginScreen.progress = 70;
			} else {
				PixFont.field2553 = field1769;
				field1510.method2741();
				int var42 = (int) (Math.random() * 21.0D) - 10;
				int var43 = (int) (Math.random() * 21.0D) - 10;
				int var44 = (int) (Math.random() * 21.0D) - 10;
				int var45 = (int) (Math.random() * 41.0D) - 20;
				for (int var46 = 0; var46 < field1727.length; var46++) {
					field1727[var46].method2663(var42 + var45, var43 + var45, var44 + var45);
				}
				field263[0].method2751(var42 + var45, var43 + var45, var44 + var45);
				field853 = new int[33];
				field171 = new int[33];
				field829 = new int[151];
				field1474 = new int[151];
				for (int var47 = 0; var47 < 33; var47++) {
					int var48 = 999;
					int var49 = 0;
					for (int var50 = 0; var50 < 34; var50++) {
						if (field807.field2511[field807.field2513 * var47 + var50] == 0) {
							if (var48 == 999) {
								var48 = var50;
							}
						} else if (var48 != 999) {
							var49 = var50;
							break;
						}
					}
					field853[var47] = var48;
					field171[var47] = var49 - var48;
				}
				for (int var51 = 5; var51 < 156; var51++) {
					int var52 = 999;
					int var53 = 0;
					for (int var54 = 25; var54 < 172; var54++) {
						if (field807.field2511[field807.field2513 * var51 + var54] == 0 && (var54 > 34 || var51 > 34)) {
							if (var52 == 999) {
								var52 = var54;
							}
						} else if (var52 != 999) {
							var53 = var54;
							break;
						}
					}
					field829[var51 - 5] = var52 - 25;
					field1474[var51 - 5] = var53 - var52;
				}
				LoginScreen.message = EnglishLocale.field889;
				LoginScreen.progress = 70;
				field1940 = 90;
			}
		} else if (field1940 == 90) {
			if (field1966.fetchAll()) {
				SceneBuilderProvider var55 = new SceneBuilderProvider(field1966, field1944, 20, 0.8D, lowMemory ? 64 : 128);
				Pix3D.method2760(var55);
				Pix3D.method2761(0.8D);
				LoginScreen.message = EnglishLocale.field891;
				LoginScreen.progress = 90;
				field1940 = 110;
			} else {
				LoginScreen.message = EnglishLocale.field890 + field1966.method1470() + "%";
				LoginScreen.progress = 90;
			}
		} else if (field1940 == 110) {
			mouseTracking = new MouseTracking();
			GameShell.signlink.startThread(mouseTracking, 10);
			LoginScreen.message = EnglishLocale.field892;
			LoginScreen.progress = 94;
			field1940 = 120;
		} else if (field1940 == 120) {
			if (field544.requestDownload("huffman", "")) {
				Huffman var56 = new Huffman(field544.getFile("huffman", ""));
				WordPack.method816(var56);
				LoginScreen.message = EnglishLocale.field1051;
				LoginScreen.progress = 96;
				field1940 = 130;
			} else {
				LoginScreen.message = EnglishLocale.field1062 + "%";
				LoginScreen.progress = 96;
			}
		} else if (field1940 == 130) {
			if (!field1123.fetchAll()) {
				LoginScreen.message = EnglishLocale.field1017 + field1123.method1470() * 4 / 5 + "%";
				LoginScreen.progress = 100;
			} else if (!field1232.fetchAll()) {
				LoginScreen.message = EnglishLocale.field1017 + (field1232.method1470() / 6 + 80) + "%";
				LoginScreen.progress = 100;
			} else if (field1150.fetchAll()) {
				LoginScreen.message = EnglishLocale.field1045;
				LoginScreen.progress = 100;
				field1940 = 140;
			} else {
				LoginScreen.message = EnglishLocale.field1017 + (field1150.method1470() / 20 + 96) + "%";
				LoginScreen.progress = 100;
			}
		} else if (field1940 == 140) {
			method729(10);
		}
	}

	@ObfuscatedName("u.dd(IZZZB)Ldq;")
	public static Js5Provider method129(int arg0, boolean arg1, boolean arg2, boolean arg3) {
		FileStream var4 = null;
		if (SignLinkCacheFolder.cacheDat != null) {
			var4 = new FileStream(arg0, SignLinkCacheFolder.cacheDat, SignLinkCacheFolder.cacheIndex[arg0], 1000000);
		}
		return new Js5Provider(var4, field10, arg0, arg1, arg2, arg3);
	}

	@ObfuscatedName("ex.dg(I)V")
	public static final void updateTitle() {
		try {
			if (loginState == 0) {
				if (stream != null) {
					stream.close();
					stream = null;
				}
				field806 = null;
				field1968 = false;
				field1948 = 0;
				loginState = 1;
			}
			if (loginState == 1) {
				if (field806 == null) {
					field806 = GameShell.signlink.method451(field52, field1204);
				}
				if (field806.field507 == 2) {
					throw new IOException();
				}
				if (field806.field507 == 1) {
					stream = new ClientStream((Socket) field806.field511, GameShell.signlink);
					field806 = null;
					loginState = 2;
				}
			}
			if (loginState == 2) {
				out.pos = 0;
				out.p1(14);
				stream.write(out.data, 0, 1);
				in.pos = 0;
				loginState = 3;
			}
			if (loginState == 3) {
				if (field38 != null) {
					field38.method207();
				}
				if (field1585 != null) {
					field1585.method207();
				}
				int var0 = stream.read();
				if (field38 != null) {
					field38.method207();
				}
				if (field1585 != null) {
					field1585.method207();
				}
				if (var0 != 0) {
					method838(var0);
					return;
				}
				in.pos = 0;
				loginState = 5;
			}
			if (loginState == 5) {
				int[] var1 = new int[] { (int) (Math.random() * 9.9999999E7D), (int) (Math.random() * 9.9999999E7D), (int) (Math.random() * 9.9999999E7D), (int) (Math.random() * 9.9999999E7D) };
				out.pos = 0;
				out.p1(10);
				out.p4(var1[0]);
				out.p4(var1[1]);
				out.p4(var1[2]);
				out.p4(var1[3]);
				out.p8(0L);
				out.pjstr(LoginScreen.field133);
				out.rsaenc(PublicKeys.LOGIN_RSAN, PublicKeys.LOGIN_RSAE);
				login.pos = 0;
				if (gameState == 40) {
					login.p1(18);
				} else {
					login.p1(16);
				}
				login.p2(0);
				int var2 = login.pos;
				login.p4(1);
				login.pdata(out.data, 0, out.pos);
				int var3 = login.pos;
				login.pjstr(LoginScreen.field164);
				login.p1(lowMemory ? 1 : 0);
				SignLinkCacheFolder.method47(login);
				login.p4(field1109.crc);
				login.p4(field1720.crc);
				login.p4(configJs5.crc);
				login.p4(field1123.crc);
				login.p4(field1509.crc);
				login.p4(field1270.crc);
				login.p4(field1110.crc);
				login.p4(modelJs5.crc);
				login.p4(field1944.crc);
				login.p4(field1966.crc);
				login.p4(field544.crc);
				login.p4(field1515.crc);
				login.p4(field1232.crc);
				login.p4(field1150.crc);
				login.p4(field2353.crc);
				login.p4(field126.crc);
				login.tinyenc(var1, var3, login.pos);
				login.psize2(login.pos - var2);
				stream.write(login.data, 0, login.pos);
				out.seed(var1);
				for (int var4 = 0; var4 < 4; var4++) {
					var1[var4] += 50;
				}
				in.seed(var1);
				loginState = 6;
			}
			if (loginState == 6 && stream.available() > 0) {
				int var5 = stream.read();
				if (var5 == 21 && gameState == 20) {
					loginState = 7;
				} else if (var5 == 2) {
					loginState = 9;
				} else if (var5 == 15 && gameState == 40) {
					imethod10();
					return;
				} else if (var5 == 23 && field2105 < 1) {
					field2105++;
					loginState = 0;
				} else {
					method838(var5);
					return;
				}
			}
			if (loginState == 7 && stream.available() > 0) {
				field1950 = (stream.read() + 3) * 60;
				loginState = 8;
			}
			if (loginState == 8) {
				field1948 = 0;
				LoginScreen.method2357(EnglishLocale.field964, EnglishLocale.field898, field1950 / 60 + EnglishLocale.field899);
				if (--field1950 <= 0) {
					loginState = 0;
				}
			} else {
				if (loginState == 9 && stream.available() >= 8) {
					field2049 = stream.read();
					field2091 = stream.read() == 1;
					field2005 = stream.read();
					field2005 <<= 0x8;
					field2005 += stream.read();
					field2130 = stream.read();
					stream.read(in.data, 0, 1);
					in.pos = 0;
					packetType = in.gisaac1();
					stream.read(in.data, 0, 2);
					in.pos = 0;
					packetSize = in.g2();
					loginState = 10;
				}
				if (loginState != 10) {
					field1948++;
					if (field1948 > 2000) {
						if (field2105 < 1) {
							if (field1641 == field1204) {
								field1204 = field13;
							} else {
								field1204 = field1641;
							}
							field2105++;
							loginState = 0;
						} else {
							method838(-3);
						}
					}
				} else if (stream.available() >= packetSize) {
					in.pos = 0;
					stream.read(in.data, 0, packetSize);
					method1485();
					field1473 = -1;
					method1235(false);
					packetType = -1;
				}
			}
		} catch (IOException var10) {
			if (field2105 < 1) {
				if (field1641 == field1204) {
					field1204 = field13;
				} else {
					field1204 = field1641;
				}
				field2105++;
				loginState = 0;
			} else {
				method838(-2);
			}
		}
	}

	@ObfuscatedName("dr.df(S)V")
	public static void method1485() {
		prevMousePressTime = 0L;
		lastWriteDuplicates = 0;
		mouseTracking.length = 0;
		GameShell.focus = true;
		focused = true;
		ReflectionCheck.field1513 = new LinkList();
		out.pos = 0;
		in.pos = 0;
		packetType = -1;
		lastPacketType0 = -1;
		lastPacketType1 = -1;
		lastPacketType2 = -1;
		idleNetCycles = 0;
		systemUpdateTimer = 0;
		idleTimeout = 0;
		field1920 = 0;
		menuSize = 0;
		field2066 = false;
		JavaMouseProvider.method1845(0);
		for (int var0 = 0; var0 < 100; var0++) {
			field2142[var0] = null;
		}
		field2141 = 0;
		field2077 = 0;
		field2079 = false;
		field2176 = 0;
		cameraAnticheatOffsetX = (int) (Math.random() * 100.0D) - 50;
		cameraAnticheatOffsetZ = (int) (Math.random() * 110.0D) - 55;
		cameraAnticheatAngle = (int) (Math.random() * 80.0D) - 40;
		minimapAnticheatAngle = (int) (Math.random() * 120.0D) - 60;
		minimapZoom = (int) (Math.random() * 30.0D) - 20;
		orbitCameraYaw = (int) (Math.random() * 20.0D) - 10 & 0x7FF;
		minimapState = 0;
		minimapLevel = -1;
		flagSceneTileX = 0;
		flagSceneTileZ = 0;
		playerCount = 0;
		npcCount = 0;
		for (int var1 = 0; var1 < 2048; var1++) {
			players[var1] = null;
			playerAppearanceBuffer[var1] = null;
		}
		for (int var2 = 0; var2 < 32768; var2++) {
			npcs[var2] = null;
		}
		localPlayer = players[2047] = new PlayerEntity();
		projectiles.clear();
		spotanims.clear();
		for (int var3 = 0; var3 < 4; var3++) {
			for (int var4 = 0; var4 < 104; var4++) {
				for (int var5 = 0; var5 < 104; var5++) {
					levelObjStacks[var3][var4][var5] = null;
				}
			}
		}
		temporaryLocs = new LinkList();
		field2171 = 0;
		field2071 = 0;
		for (int var6 = 0; var6 < VarPlayerType.field2352; var6++) {
			VarPlayerType var7 = VarPlayerType.get(var6);
			if (var7 != null && var7.clientcode == 0) {
				VarProvider.field1211[var6] = 0;
				VarProvider.field1210[var6] = 0;
			}
		}
		for (int var8 = 0; var8 < field2120.length; var8++) {
			field2120[var8] = -1;
		}
		if (field2083 != -1) {
			int var9 = field2083;
			if (var9 != -1 && IfType.field1508[var9]) {
				IfType.field1806.discardFiles(var9);
				if (IfType.field373[var9] != null) {
					boolean var10 = true;
					for (int var11 = 0; var11 < IfType.field373[var9].length; var11++) {
						if (IfType.field373[var9][var11] != null) {
							if (IfType.field373[var9][var11].field1785 == 2) {
								var10 = false;
							} else {
								IfType.field373[var9][var11] = null;
							}
						}
					}
					if (var10) {
						IfType.field373[var9] = null;
					}
					IfType.field1508[var9] = false;
				}
			}
		}
		for (ComponentPointer var12 = (ComponentPointer) field1918.method1284(); var12 != null; var12 = (ComponentPointer) field1918.method1280()) {
			method408(var12, true);
		}
		field2083 = -1;
		field1918 = new HashTable(8);
		field2087 = null;
		field2066 = false;
		menuSize = 0;
		field2197.method1168(null, new int[] { 0, 0, 0, 0, 0 }, false, -1);
		for (int var13 = 0; var13 < 8; var13++) {
			field2053[var13] = null;
			field2054[var13] = false;
		}
		ClientInvCache.field1623 = new HashTable(32);
		field1921 = true;
		for (int var14 = 0; var14 < 100; var14++) {
			field2175[var14] = true;
		}
		field1955 = null;
		field1220 = 0;
		field1774 = null;
	}

	@ObfuscatedName("bf.dk(II)V")
	public static void method838(int arg0) {
		if (arg0 == -3) {
			LoginScreen.method2357(EnglishLocale.field900, EnglishLocale.field901, EnglishLocale.field881);
		} else if (arg0 == -2) {
			LoginScreen.method2357(EnglishLocale.field1061, EnglishLocale.field904, EnglishLocale.field1044);
		} else if (arg0 == -1) {
			LoginScreen.method2357(EnglishLocale.field906, EnglishLocale.field940, EnglishLocale.field908);
		} else if (arg0 == 3) {
			LoginScreen.method2357(EnglishLocale.field909, EnglishLocale.field910, EnglishLocale.field897);
		} else if (arg0 == 4) {
			LoginScreen.method2357(EnglishLocale.field912, EnglishLocale.field1089, EnglishLocale.field914);
		} else if (arg0 == 5) {
			LoginScreen.method2357(EnglishLocale.field915, EnglishLocale.field1088, EnglishLocale.field917);
		} else if (arg0 == 6) {
			LoginScreen.method2357(EnglishLocale.field918, EnglishLocale.field1080, EnglishLocale.field920);
		} else if (arg0 == 7) {
			LoginScreen.method2357(EnglishLocale.field1067, EnglishLocale.field922, EnglishLocale.field923);
		} else if (arg0 == 8) {
			LoginScreen.method2357(EnglishLocale.field986, EnglishLocale.field925, EnglishLocale.field943);
		} else if (arg0 == 9) {
			LoginScreen.method2357(EnglishLocale.field927, EnglishLocale.field928, EnglishLocale.field929);
		} else if (arg0 == 10) {
			LoginScreen.method2357(EnglishLocale.field930, EnglishLocale.field886, EnglishLocale.field932);
		} else if (arg0 == 11) {
			LoginScreen.method2357(EnglishLocale.field933, EnglishLocale.field934, EnglishLocale.field967);
		} else if (arg0 == 12) {
			LoginScreen.method2357(EnglishLocale.field936, EnglishLocale.field994, EnglishLocale.field974);
		} else if (arg0 == 13) {
			LoginScreen.method2357(EnglishLocale.field939, EnglishLocale.field937, EnglishLocale.field941);
		} else if (arg0 == 14) {
			LoginScreen.method2357(EnglishLocale.field1006, EnglishLocale.field877, EnglishLocale.field1025);
		} else if (arg0 == 16) {
			LoginScreen.method2357(EnglishLocale.field945, EnglishLocale.field946, EnglishLocale.field947);
		} else if (arg0 == 17) {
			LoginScreen.method2357(EnglishLocale.field948, EnglishLocale.field931, EnglishLocale.field950);
		} else if (arg0 == 18) {
			LoginScreen.method2357(EnglishLocale.field951, EnglishLocale.field952, EnglishLocale.field996);
		} else if (arg0 == 19) {
			LoginScreen.method2357(EnglishLocale.field1056, EnglishLocale.field955, EnglishLocale.field956);
		} else if (arg0 == 20) {
			LoginScreen.method2357(EnglishLocale.field957, EnglishLocale.field958, EnglishLocale.field1071);
		} else if (arg0 == 22) {
			LoginScreen.method2357(EnglishLocale.field969, EnglishLocale.field961, EnglishLocale.field938);
		} else if (arg0 == 23) {
			LoginScreen.method2357(EnglishLocale.field893, EnglishLocale.field949, EnglishLocale.field965);
		} else if (arg0 == 24) {
			LoginScreen.method2357(EnglishLocale.field1064, EnglishLocale.field1022, EnglishLocale.field968);
		} else if (arg0 == 25) {
			LoginScreen.method2357(EnglishLocale.field921, EnglishLocale.field970, EnglishLocale.field971);
		} else if (arg0 == 26) {
			LoginScreen.method2357(EnglishLocale.field972, EnglishLocale.field973, EnglishLocale.field963);
		} else if (arg0 == 27) {
			LoginScreen.method2357(EnglishLocale.field1094, EnglishLocale.field976, EnglishLocale.field935);
		} else if (arg0 == 31) {
			LoginScreen.method2357(EnglishLocale.field984, EnglishLocale.field985, EnglishLocale.field926);
		} else if (arg0 == 32) {
			LoginScreen.method2357(EnglishLocale.field987, EnglishLocale.field988, EnglishLocale.field1037);
		} else if (arg0 == 37) {
			LoginScreen.method2357(EnglishLocale.field990, EnglishLocale.field991, EnglishLocale.field997);
		} else if (arg0 == 38) {
			LoginScreen.method2357(EnglishLocale.field993, EnglishLocale.field944, EnglishLocale.field953);
		} else if (arg0 == 55) {
			LoginScreen.method2357(EnglishLocale.field870, EnglishLocale.field871, EnglishLocale.field975);
		} else {
			LoginScreen.method2357(EnglishLocale.field999, EnglishLocale.field866, EnglishLocale.field1001);
		}
		method729(10);
	}

	@ObfuscatedName("dq.dz(B)V")
	public static final void logout() {
		if (stream != null) {
			stream.close();
			stream = null;
		}
		method746();
		field1133.method564();
		for (int var0 = 0; var0 < 4; var0++) {
			levelCollisionMap[var0].reset();
		}
		System.gc();
		MidiPlayer.field1117 = 1;
		MidiPlayer.field1118 = null;
		MidiPlayer.field349 = -1;
		MidiPlayer.field1121 = -1;
		MidiPlayer.field1120 = 0;
		MidiPlayer.field1625 = false;
		MidiPlayer.field1152 = 2;
		field2170 = -1;
		field2189 = false;
		for (PositionedSound var1 = (PositionedSound) PositionedSound.field1612.head(); var1 != null; var1 = (PositionedSound) PositionedSound.field1612.next()) {
			if (var1.field1603 != null) {
				field1460.method2175(var1.field1603);
				var1.field1603 = null;
			}
			if (var1.field1614 != null) {
				field1460.method2175(var1.field1614);
				var1.field1614 = null;
			}
		}
		PositionedSound.field1612.clear();
		method729(10);
	}

	@ObfuscatedName("bh.da(B)V")
	public static final void method746() {
		FloType.field2411.clear();
		FluType.method2580();
		IdkType.field2396.clear();
		LocType.unload();
		NpcType.method1334();
		ObjType.field2432.clear();
		ObjType.field2433.clear();
		ObjType.field2434.clear();
		SeqType.method1123();
		SpotAnimType.field2379.clear();
		SpotAnimType.field2392.clear();
		VarBitType.field2417.clear();
		VarPlayerType.method1148();
		PlayerModel.method912();
		IfType.method1104();
		((SceneBuilderProvider) Pix3D.sceneProvider).method749();
		ClientScript.field2262.clear();
		field1109.discardAll();
		field1720.discardAll();
		field1123.discardAll();
		field1509.discardAll();
		field1270.discardAll();
		field1110.discardAll();
		modelJs5.discardAll();
		field1944.discardAll();
		field1966.discardAll();
		field544.discardAll();
		field1515.discardAll();
		field1232.discardAll();
	}

	@ObfuscatedName("da.dj(I)V")
	public static final void method1351() {
		if (field1585 != null) {
			field1585.method235();
		}
		if (field38 != null) {
			field38.method235();
		}
	}

	@ObfuscatedName("de.dv(Leo;IIII)V")
	public static void method1499(SeqType arg0, int arg1, int arg2, int arg3) {
		if (field2176 >= 50 || field2174 == 0 || (arg0.sound == null || arg1 >= arg0.sound.length)) {
			return;
		}
		int var4 = arg0.sound[arg1];
		if (var4 == 0) {
			return;
		}
		int var5 = var4 >> 8;
		int var6 = var4 >> 4 & 0x7;
		int var7 = var4 & 0xF;
		field2177[field2176] = var5;
		field2006[field2176] = var6;
		field2179[field2176] = 0;
		field2181[field2176] = null;
		int var8 = (arg2 - 64) / 128;
		int var9 = (arg3 - 64) / 128;
		field2180[field2176] = (var8 << 16) + (var9 << 8) + var7;
		field2176++;
	}

	@ObfuscatedName("ck.ds(IB)V")
	public static void method1232(int arg0) {
		if (arg0 == -1 && !field2189) {
			MidiPlayer.method917();
		} else if (arg0 != -1 && field2170 != arg0 && field2169 != 0 && !field2189) {
			MidiPlayer.method95(2, field1110, arg0, 0, field2169, false);
		}
		field2170 = arg0;
	}

	@ObfuscatedName("p.dh(III)V")
	public static final void method344(int arg0, int arg1) {
		if (minimapState != 0 && minimapState != 3 || JavaMouseProvider.mouseClickButton != 1) {
			return;
		}
		int var2 = JavaMouseProvider.mouseClickX - 25 - arg0;
		int var3 = JavaMouseProvider.mouseClickY - 5 - arg1;
		if (var2 < 0 || var3 < 0 || var2 >= 146 || var3 >= 151) {
			return;
		}
		var2 -= 73;
		var3 -= 75;
		int var4 = orbitCameraYaw + minimapAnticheatAngle & 0x7FF;
		int var5 = Pix3D.sinTable[var4];
		int var6 = Pix3D.cosTable[var4];
		int var7 = (minimapZoom + 256) * var5 >> 8;
		int var8 = (minimapZoom + 256) * var6 >> 8;
		int var9 = var2 * var8 + var3 * var7 >> 11;
		int var10 = var3 * var8 - var2 * var7 >> 11;
		int var11 = localPlayer.x + var9 >> 7;
		int var12 = localPlayer.z - var10 >> 7;
		boolean var13 = method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var11, var12, true, 0, 0, 0, 0, 0, 1);
		if (!var13) {
			return;
		}
		out.p1(var2);
		out.p1(var3);
		out.p2(orbitCameraYaw);
		out.p1(57);
		out.p1(minimapAnticheatAngle);
		out.p1(minimapZoom);
		out.p1(89);
		out.p2(localPlayer.x);
		out.p2(localPlayer.z);
		out.p1(field1981);
		out.p1(63);
	}

	@ObfuscatedName("dm.dc(B)V")
	public static final void updateEntityChats() {
		for (int var0 = -1; var0 < playerCount; var0++) {
			int var1;
			if (var0 == -1) {
				var1 = 2047;
			} else {
				var1 = playerIds[var0];
			}
			PlayerEntity var2 = players[var1];
			if (var2 != null && var2.field2634 > 0) {
				var2.field2634--;
				if (var2.field2634 == 0) {
					var2.field2644 = null;
				}
			}
		}
		for (int var3 = 0; var3 < npcCount; var3++) {
			int var4 = field1956[var3];
			NpcEntity var5 = npcs[var4];
			if (var5 != null && var5.field2634 > 0) {
				var5.field2634--;
				if (var5.field2634 == 0) {
					var5.field2644 = null;
				}
			}
		}
	}

	@ObfuscatedName("eh.dp(Ljava/lang/String;S)V")
	public static final void method1790(String arg0) {
		if (field2049 >= 2) {
			if (arg0.equalsIgnoreCase("::gc")) {
				System.gc();
			}
			if (arg0.equalsIgnoreCase("::clientdrop")) {
				tryReconnect();
			}
			if (arg0.equalsIgnoreCase("::fpson")) {
				field1991 = true;
			}
			if (arg0.equalsIgnoreCase("::fpsoff")) {
				field1991 = false;
			}
			if (arg0.equalsIgnoreCase("::noclip")) {
				for (int var1 = 0; var1 < 4; var1++) {
					for (int var2 = 1; var2 < 103; var2++) {
						for (int var3 = 1; var3 < 103; var3++) {
							levelCollisionMap[var1].field1266[var2][var3] = 0;
						}
					}
				}
			}
			if (arg0.equalsIgnoreCase("::errortest") && modewhere == 2) {
				throw new RuntimeException();
			}
		}
		out.pisaac1(30);
		out.p1(arg0.length() - 1);
		out.pjstr(arg0.substring(2));
	}

	@ObfuscatedName("ez.dm(B)V")
	public static final void applyCutscene() {
		int var0 = cutsceneSrcLocalTileX * 128 + 64;
		int var1 = cutsceneSrcLocalTileZ * 128 + 64;
		int var2 = getHeightmapY(var0, var1, currentLevel) - cutsceneSrcHeight;
		if (cameraX < var0) {
			cameraX += cutsceneMoveAcceleration * (var0 - cameraX) / 1000 + cutsceneMoveSpeed;
			if (cameraX > var0) {
				cameraX = var0;
			}
		}
		if (cameraX > var0) {
			cameraX -= cutsceneMoveAcceleration * (cameraX - var0) / 1000 + cutsceneMoveSpeed;
			if (cameraX < var0) {
				cameraX = var0;
			}
		}
		if (cameraY < var2) {
			cameraY += cutsceneMoveAcceleration * (var2 - cameraY) / 1000 + cutsceneMoveSpeed;
			if (cameraY > var2) {
				cameraY = var2;
			}
		}
		if (cameraY > var2) {
			cameraY -= cutsceneMoveAcceleration * (cameraY - var2) / 1000 + cutsceneMoveSpeed;
			if (cameraY < var2) {
				cameraY = var2;
			}
		}
		if (cameraZ < var1) {
			cameraZ += cutsceneMoveAcceleration * (var1 - cameraZ) / 1000 + cutsceneMoveSpeed;
			if (cameraZ > var1) {
				cameraZ = var1;
			}
		}
		if (cameraZ > var1) {
			cameraZ -= cutsceneMoveAcceleration * (cameraZ - var1) / 1000 + cutsceneMoveSpeed;
			if (cameraZ < var1) {
				cameraZ = var1;
			}
		}
		int var3 = cutsceneDstLocalTileX * 128 + 64;
		int var4 = cutsceneDstLocalTileZ * 128 + 64;
		int var5 = getHeightmapY(var3, var4, currentLevel) - cutsceneDstHeight;
		int var6 = var3 - cameraX;
		int var7 = var5 - cameraY;
		int var8 = var4 - cameraZ;
		int var9 = (int) Math.sqrt((double) (var6 * var6 + var8 * var8));
		int var10 = (int) (Math.atan2((double) var7, (double) var9) * 325.949D) & 0x7FF;
		int var11 = (int) (Math.atan2((double) var6, (double) var8) * -325.949D) & 0x7FF;
		if (var10 < 128) {
			var10 = 128;
		}
		if (var10 > 383) {
			var10 = 383;
		}
		if (cameraPitch < var10) {
			cameraPitch += cutsceneRotateAcceleration * (var10 - cameraPitch) / 1000 + cutsceneRotateSpeed;
			if (cameraPitch > var10) {
				cameraPitch = var10;
			}
		}
		if (cameraPitch > var10) {
			cameraPitch -= cutsceneRotateAcceleration * (cameraPitch - var10) / 1000 + cutsceneRotateSpeed;
			if (cameraPitch < var10) {
				cameraPitch = var10;
			}
		}
		int var12 = var11 - cameraYaw;
		if (var12 > 1024) {
			var12 -= 2048;
		}
		if (var12 < -1024) {
			var12 += 2048;
		}
		if (var12 > 0) {
			cameraYaw += cutsceneRotateAcceleration * var12 / 1000 + cutsceneRotateSpeed;
			cameraYaw &= 0x7FF;
		}
		if (var12 < 0) {
			cameraYaw -= cutsceneRotateAcceleration * -var12 / 1000 + cutsceneRotateSpeed;
			cameraYaw &= 0x7FF;
		}
		int var13 = var11 - cameraYaw;
		if (var13 > 1024) {
			var13 -= 2048;
		}
		if (var13 < -1024) {
			var13 += 2048;
		}
		if (var13 < 0 && var12 > 0 || var13 > 0 && var12 < 0) {
			cameraYaw = var11;
		}
	}

	@ObfuscatedName("eg.di(B)V")
	public static final void updatePlayers() {
		for (int var0 = -1; var0 < playerCount; var0++) {
			int var1;
			if (var0 == -1) {
				var1 = 2047;
			} else {
				var1 = playerIds[var0];
			}
			PlayerEntity var2 = players[var1];
			if (var2 != null) {
				updateEntity(var2, 1);
			}
		}
	}

	@ObfuscatedName("l.db(I)V")
	public static final void updateNpcs() {
		for (int var0 = 0; var0 < npcCount; var0++) {
			int var1 = field1956[var0];
			NpcEntity var2 = npcs[var1];
			if (var2 != null) {
				updateEntity(var2, var2.field2804.size);
			}
		}
	}

	@ObfuscatedName("be.dq(Lfz;IB)V")
	public static final void updateEntity(PathingEntity arg0, int arg1) {
		if (arg0.field2628 > loopCycle) {
			int var2 = arg0.field2628 - loopCycle;
			int var3 = arg0.field2657 * 64 + arg0.field2617 * 128;
			int var4 = arg0.field2657 * 64 + arg0.field2655 * 128;
			arg0.x += (var3 - arg0.x) / var2;
			arg0.z += (var4 - arg0.z) / var2;
			arg0.field2669 = 0;
			if (arg0.field2659 == 0) {
				arg0.field2618 = 1024;
			}
			if (arg0.field2659 == 1) {
				arg0.field2618 = 1536;
			}
			if (arg0.field2659 == 2) {
				arg0.field2618 = 0;
			}
			if (arg0.field2659 == 3) {
				arg0.field2618 = 512;
			}
		} else if (arg0.field2658 >= loopCycle) {
			method420(arg0);
		} else {
			method2457(arg0);
		}
		if (arg0.x < 128 || arg0.z < 128 || arg0.x >= 13184 || arg0.z >= 13184) {
			arg0.field2643 = -1;
			arg0.field2648 = -1;
			arg0.field2628 = 0;
			arg0.field2658 = 0;
			arg0.x = arg0.pathTileX[0] * 128 + arg0.field2657 * 64;
			arg0.z = arg0.pathTileZ[0] * 128 + arg0.field2657 * 64;
			arg0.method2906();
		}
		if (localPlayer == arg0 && (arg0.x < 1536 || arg0.z < 1536 || arg0.x >= 11776 || arg0.z >= 11776)) {
			arg0.field2643 = -1;
			arg0.field2648 = -1;
			arg0.field2628 = 0;
			arg0.field2658 = 0;
			arg0.x = arg0.pathTileX[0] * 128 + arg0.field2657 * 64;
			arg0.z = arg0.pathTileZ[0] * 128 + arg0.field2657 * 64;
			arg0.method2906();
		}
		method1338(arg0);
		method345(arg0);
	}

	@ObfuscatedName("ap.dr(Lfz;I)V")
	public static final void method420(PathingEntity arg0) {
		if (loopCycle == arg0.field2658 || arg0.field2643 == -1 || arg0.field2627 != 0 || arg0.field2645 + 1 > SeqType.get(arg0.field2643).delay[arg0.field2653]) {
			int var1 = arg0.field2658 - arg0.field2628;
			int var2 = loopCycle - arg0.field2628;
			int var3 = arg0.field2657 * 64 + arg0.field2617 * 128;
			int var4 = arg0.field2657 * 64 + arg0.field2655 * 128;
			int var5 = arg0.field2657 * 64 + arg0.field2654 * 128;
			int var6 = arg0.field2657 * 64 + arg0.field2642 * 128;
			arg0.x = ((var1 - var2) * var3 + var2 * var5) / var1;
			arg0.z = ((var1 - var2) * var4 + var2 * var6) / var1;
		}
		arg0.field2669 = 0;
		if (arg0.field2659 == 0) {
			arg0.field2618 = 1024;
		}
		if (arg0.field2659 == 1) {
			arg0.field2618 = 1536;
		}
		if (arg0.field2659 == 2) {
			arg0.field2618 = 0;
		}
		if (arg0.field2659 == 3) {
			arg0.field2618 = 512;
		}
		arg0.field2646 = arg0.field2618;
	}

	@ObfuscatedName("eu.du(Lfz;B)V")
	public static final void method2457(PathingEntity arg0) {
		arg0.field2640 = arg0.field2622;
		if (arg0.field2665 == 0) {
			arg0.field2669 = 0;
			return;
		}
		if (arg0.field2643 != -1 && arg0.field2627 == 0) {
			SeqType var1 = SeqType.get(arg0.field2643);
			if (arg0.field2656 > 0 && var1.preanim_move == 0) {
				arg0.field2669++;
				return;
			}
			if (arg0.field2656 <= 0 && var1.postanim_move == 0) {
				arg0.field2669++;
				return;
			}
		}
		int var2 = arg0.x;
		int var3 = arg0.z;
		int var4 = arg0.pathTileX[arg0.field2665 - 1] * 128 + arg0.field2657 * 64;
		int var5 = arg0.pathTileZ[arg0.field2665 - 1] * 128 + arg0.field2657 * 64;
		if (var4 - var2 > 256 || var4 - var2 < -256 || var5 - var3 > 256 || var5 - var3 < -256) {
			arg0.x = var4;
			arg0.z = var5;
			return;
		}
		if (var2 < var4) {
			if (var3 < var5) {
				arg0.field2618 = 1280;
			} else if (var3 > var5) {
				arg0.field2618 = 1792;
			} else {
				arg0.field2618 = 1536;
			}
		} else if (var2 > var4) {
			if (var3 < var5) {
				arg0.field2618 = 768;
			} else if (var3 > var5) {
				arg0.field2618 = 256;
			} else {
				arg0.field2618 = 512;
			}
		} else if (var3 < var5) {
			arg0.field2618 = 1024;
		} else if (var3 > var5) {
			arg0.field2618 = 0;
		}
		int var6 = arg0.field2618 - arg0.field2646 & 0x7FF;
		if (var6 > 1024) {
			var6 -= 2048;
		}
		int var7 = arg0.field2664;
		if (var6 >= -256 && var6 <= 256) {
			var7 = arg0.field2621;
		} else if (var6 >= 256 && var6 < 768) {
			var7 = arg0.field2624;
		} else if (var6 >= -768 && var6 <= -256) {
			var7 = arg0.field2623;
		}
		if (var7 == -1) {
			var7 = arg0.field2621;
		}
		arg0.field2640 = var7;
		int var8 = 4;
		boolean var9 = true;
		if (arg0 instanceof NpcEntity) {
			var9 = ((NpcEntity) arg0).field2804.walksmoothing;
		}
		if (var9) {
			if (arg0.field2646 != arg0.field2618 && arg0.field2637 == -1 && arg0.field2661 != 0) {
				var8 = 2;
			}
			if (arg0.field2665 > 2) {
				var8 = 6;
			}
			if (arg0.field2665 > 3) {
				var8 = 8;
			}
			if (arg0.field2669 > 0 && arg0.field2665 > 1) {
				var8 = 8;
				arg0.field2669--;
			}
		} else {
			if (arg0.field2665 > 1) {
				var8 = 6;
			}
			if (arg0.field2665 > 2) {
				var8 = 8;
			}
			if (arg0.field2669 > 0 && arg0.field2665 > 1) {
				var8 = 8;
				arg0.field2669--;
			}
		}
		if (arg0.field2668[arg0.field2665 - 1]) {
			var8 <<= 0x1;
		}
		if (var8 >= 8 && arg0.field2640 == arg0.field2621 && arg0.field2625 != -1) {
			arg0.field2640 = arg0.field2625;
		}
		if (var2 < var4) {
			arg0.x += var8;
			if (arg0.x > var4) {
				arg0.x = var4;
			}
		} else if (var2 > var4) {
			arg0.x -= var8;
			if (arg0.x < var4) {
				arg0.x = var4;
			}
		}
		if (var3 < var5) {
			arg0.z += var8;
			if (arg0.z > var5) {
				arg0.z = var5;
			}
		} else if (var3 > var5) {
			arg0.z -= var8;
			if (arg0.z < var5) {
				arg0.z = var5;
			}
		}
		if (arg0.x == var4 && arg0.z == var5) {
			arg0.field2665--;
			if (arg0.field2656 > 0) {
				arg0.field2656--;
			}
		}
	}

	@ObfuscatedName("dk.dy(Lfz;I)V")
	public static final void method1338(PathingEntity arg0) {
		if (arg0.field2661 == 0) {
			return;
		}
		if (arg0.field2637 != -1 && arg0.field2637 < 32768) {
			NpcEntity var1 = npcs[arg0.field2637];
			if (var1 != null) {
				int var2 = arg0.x - var1.x;
				int var3 = arg0.z - var1.z;
				if (var2 != 0 || var3 != 0) {
					arg0.field2618 = (int) (Math.atan2((double) var2, (double) var3) * 325.949D) & 0x7FF;
				}
			}
		}
		if (arg0.field2637 >= 32768) {
			int var4 = arg0.field2637 - 32768;
			if (field2005 == var4) {
				var4 = 2047;
			}
			PlayerEntity var5 = players[var4];
			if (var5 != null) {
				int var6 = arg0.x - var5.x;
				int var7 = arg0.z - var5.z;
				if (var6 != 0 || var7 != 0) {
					arg0.field2618 = (int) (Math.atan2((double) var6, (double) var7) * 325.949D) & 0x7FF;
				}
			}
		}
		if ((arg0.field2638 != 0 || arg0.field2639 != 0) && (arg0.field2665 == 0 || arg0.field2669 > 0)) {
			int var8 = arg0.x - (arg0.field2638 * 64 - sceneBaseTileX * 64 - sceneBaseTileX * 64);
			int var9 = arg0.z - (arg0.field2639 * 64 - sceneBaseTileZ * 64 - sceneBaseTileZ * 64);
			if (var8 != 0 || var9 != 0) {
				arg0.field2618 = (int) (Math.atan2((double) var8, (double) var9) * 325.949D) & 0x7FF;
			}
			arg0.field2638 = 0;
			arg0.field2639 = 0;
		}
		int var10 = arg0.field2618 - arg0.field2646 & 0x7FF;
		if (var10 == 0) {
			arg0.field2663 = 0;
			return;
		}
		arg0.field2663++;
		if (var10 > 1024) {
			arg0.field2646 -= arg0.field2661;
			boolean var11 = true;
			if (var10 < arg0.field2661 || var10 > 2048 - arg0.field2661) {
				arg0.field2646 = arg0.field2618;
				var11 = false;
			}
			if (arg0.field2640 == arg0.field2622 && (arg0.field2663 > 25 || var11)) {
				if (arg0.field2619 == -1) {
					arg0.field2640 = arg0.field2621;
				} else {
					arg0.field2640 = arg0.field2619;
				}
			}
		} else {
			arg0.field2646 += arg0.field2661;
			boolean var12 = true;
			if (var10 < arg0.field2661 || var10 > 2048 - arg0.field2661) {
				arg0.field2646 = arg0.field2618;
				var12 = false;
			}
			if (arg0.field2640 == arg0.field2622 && (arg0.field2663 > 25 || var12)) {
				if (arg0.field2620 == -1) {
					arg0.field2640 = arg0.field2621;
				} else {
					arg0.field2640 = arg0.field2620;
				}
			}
		}
		arg0.field2646 &= 0x7FF;
	}

	@ObfuscatedName("p.de(Lfz;I)V")
	public static final void method345(PathingEntity arg0) {
		arg0.field2616 = false;
		if (arg0.field2640 != -1) {
			SeqType var1 = SeqType.get(arg0.field2640);
			if (var1 == null || var1.frames == null) {
				arg0.field2640 = -1;
			} else {
				arg0.field2662++;
				if (arg0.field2641 < var1.frames.length && arg0.field2662 > var1.delay[arg0.field2641]) {
					arg0.field2662 = 1;
					arg0.field2641++;
					method1499(var1, arg0.field2641, arg0.x, arg0.z);
				}
				if (arg0.field2641 >= var1.frames.length) {
					arg0.field2662 = 0;
					arg0.field2641 = 0;
					method1499(var1, arg0.field2641, arg0.x, arg0.z);
				}
			}
		}
		if (arg0.field2648 != -1 && loopCycle >= arg0.field2651) {
			if (arg0.field2649 < 0) {
				arg0.field2649 = 0;
			}
			int var2 = SpotAnimType.get(arg0.field2648).anim;
			if (var2 == -1) {
				arg0.field2648 = -1;
			} else {
				SeqType var3 = SeqType.get(var2);
				if (var3 == null || var3.frames == null) {
					arg0.field2648 = -1;
				} else {
					arg0.field2650++;
					if (arg0.field2649 < var3.frames.length && arg0.field2650 > var3.delay[arg0.field2649]) {
						arg0.field2650 = 1;
						arg0.field2649++;
						method1499(var3, arg0.field2649, arg0.x, arg0.z);
					}
					if (arg0.field2649 >= var3.frames.length && (arg0.field2649 < 0 || arg0.field2649 >= var3.frames.length)) {
						arg0.field2648 = -1;
					}
				}
			}
		}
		if (arg0.field2643 != -1 && arg0.field2627 <= 1) {
			SeqType var4 = SeqType.get(arg0.field2643);
			if (var4.preanim_move == 1 && arg0.field2656 > 0 && arg0.field2628 <= loopCycle && arg0.field2658 < loopCycle) {
				arg0.field2627 = 1;
				return;
			}
		}
		if (arg0.field2643 != -1 && arg0.field2627 == 0) {
			SeqType var5 = SeqType.get(arg0.field2643);
			if (var5 == null || var5.frames == null) {
				arg0.field2643 = -1;
			} else {
				arg0.field2645++;
				if (arg0.field2653 < var5.frames.length && arg0.field2645 > var5.delay[arg0.field2653]) {
					arg0.field2645 = 1;
					arg0.field2653++;
					method1499(var5, arg0.field2653, arg0.x, arg0.z);
				}
				if (arg0.field2653 >= var5.frames.length) {
					arg0.field2653 -= var5.replayoff;
					arg0.field2647++;
					if (arg0.field2647 >= var5.replaycount) {
						arg0.field2643 = -1;
					} else if (arg0.field2653 >= 0 && arg0.field2653 < var5.frames.length) {
						method1499(var5, arg0.field2653, arg0.x, arg0.z);
					} else {
						arg0.field2643 = -1;
					}
				}
				arg0.field2616 = var5.stretches;
			}
		}
		if (arg0.field2627 > 0) {
			arg0.field2627--;
		}
	}

	@ObfuscatedName("co.dw(Lfi;III)V")
	public static void method1040(PlayerEntity arg0, int arg1, int arg2) {
		if (arg0.field2643 == arg1 && arg1 != -1) {
			int var3 = SeqType.get(arg1).replacemode;
			if (var3 == 1) {
				arg0.field2653 = 0;
				arg0.field2645 = 0;
				arg0.field2627 = arg2;
				arg0.field2647 = 0;
			}
			if (var3 == 2) {
				arg0.field2647 = 0;
			}
		} else if (arg1 == -1 || arg0.field2643 == -1 || SeqType.get(arg1).priority >= SeqType.get(arg0.field2643).priority) {
			arg0.field2643 = arg1;
			arg0.field2653 = 0;
			arg0.field2645 = 0;
			arg0.field2627 = arg2;
			arg0.field2647 = 0;
			arg0.field2656 = arg0.field2665;
		}
	}

	@ObfuscatedName("ej.dl(Ljava/lang/String;ZI)V")
	public static final void method1789(String arg0, boolean arg1) {
		byte var2 = 4;
		int var3 = var2 + 6;
		int var4 = var2 + 6;
		int var5 = field1122.method2818(arg0, 250);
		int var6 = field1122.method2889(arg0, 250) * 13;
		Pix2D.method2637(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
		Pix2D.method2639(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
		field1122.method2824(arg0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
		method765(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
		if (arg1) {
			try {
				Graphics var7 = GameShell.canvas.getGraphics();
				GameShell.drawArea.method545(var7, 0, 0);
			} catch (Exception var14) {
				GameShell.canvas.repaint();
			}
			return;
		}
		int var9 = var3;
		int var10 = var4;
		int var11 = var5;
		int var12 = var6;
		for (int var13 = 0; var13 < field2121; var13++) {
			if (field2135[var13] + field2133[var13] > var9 && field2133[var13] < var9 + var11 && field2136[var13] + field2007[var13] > var10 && field2007[var13] < var10 + var12) {
				field2131[var13] = true;
			}
		}
	}

	@ObfuscatedName("dl.dn(ZI)V")
	public static final void method1510(boolean arg0) {
		if (localPlayer.x >> 7 == flagSceneTileX && localPlayer.z >> 7 == flagSceneTileZ) {
			flagSceneTileX = 0;
		}
		int var1 = playerCount;
		if (arg0) {
			var1 = 1;
		}
		for (int var2 = 0; var2 < var1; var2++) {
			PlayerEntity var3;
			int var4;
			if (arg0) {
				var3 = localPlayer;
				var4 = 33538048;
			} else {
				var3 = players[playerIds[var2]];
				var4 = playerIds[var2] << 14;
			}
			if (var3 != null && var3.method2915()) {
				var3.field2795 = false;
				if ((lowMemory && playerCount > 50 || playerCount > 200) && !arg0 && var3.field2640 == var3.field2622) {
					var3.field2795 = true;
				}
				int var5 = var3.x >> 7;
				int var6 = var3.z >> 7;
				if (var5 >= 0 && var5 < 104 && var6 >= 0 && var6 < 104) {
					if (var3.field2801 == null || loopCycle < var3.field2792 || loopCycle >= var3.field2793) {
						if ((var3.x & 0x7F) == 64 && (var3.z & 0x7F) == 64) {
							if (field2023 == field2022[var5][var6]) {
								continue;
							}
							field2022[var5][var6] = field2023;
						}
						var3.field2791 = getHeightmapY(var3.x, var3.z, currentLevel);
						field1133.method603(currentLevel, var3.x, var3.z, var3.field2791, 60, var3, var3.field2646, var4, var3.field2616);
					} else {
						var3.field2795 = false;
						var3.field2791 = getHeightmapY(var3.x, var3.z, currentLevel);
						field1133.method637(currentLevel, var3.x, var3.z, var3.field2791, 60, var3, var3.field2646, var4, var3.field2798, var3.field2802, var3.field2785, var3.field2788);
					}
				}
			}
		}
	}

	@ObfuscatedName("dw.do(ZB)V")
	public static final void method1503(boolean arg0) {
		for (int var1 = 0; var1 < npcCount; var1++) {
			NpcEntity var2 = npcs[field1956[var1]];
			int var3 = (field1956[var1] << 14) + 536870912;
			if (var2 != null && var2.method2915() && var2.field2804.alwaysontop == arg0 && var2.field2804.method2339()) {
				int var4 = var2.x >> 7;
				int var5 = var2.z >> 7;
				if (var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
					if (var2.field2657 == 1 && (var2.x & 0x7F) == 64 && (var2.z & 0x7F) == 64) {
						if (field2023 == field2022[var4][var5]) {
							continue;
						}
						field2022[var4][var5] = field2023;
					}
					if (!var2.field2804.active) {
						var3 -= Integer.MIN_VALUE;
					}
					field1133.method603(currentLevel, var2.x, var2.z, getHeightmapY(var2.x + (var2.field2657 * 64 - 64), var2.z + (var2.field2657 * 64 - 64), currentLevel), var2.field2657 * 64 - 64 + 60, var2, var2.field2646, var3, var2.field2616);
				}
			}
		}
	}

	@ObfuscatedName("r.dx(I)V")
	public static final void method7() {
		for (ProjAnimEntity var0 = (ProjAnimEntity) projectiles.head(); var0 != null; var0 = (ProjAnimEntity) projectiles.next()) {
			if (currentLevel != var0.field2583 || loopCycle > var0.field2573) {
				var0.unlink();
			} else if (loopCycle >= var0.field2572) {
				if (var0.field2582 > 0) {
					NpcEntity var1 = npcs[var0.field2582 - 1];
					if (var1 != null && var1.x >= 0 && var1.x < 13312 && var1.z >= 0 && var1.z < 13312) {
						var0.method2896(var1.x, var1.z, getHeightmapY(var1.x, var1.z, var0.field2583) - var0.field2571, loopCycle);
					}
				}
				if (var0.field2582 < 0) {
					int var2 = -var0.field2582 - 1;
					PlayerEntity var3;
					if (field2005 == var2) {
						var3 = localPlayer;
					} else {
						var3 = players[var2];
					}
					if (var3 != null && var3.x >= 0 && var3.x < 13312 && var3.z >= 0 && var3.z < 13312) {
						var0.method2896(var3.x, var3.z, getHeightmapY(var3.x, var3.z, var0.field2583) - var0.field2571, loopCycle);
					}
				}
				var0.method2895(sceneDelta);
				field1133.method603(currentLevel, (int) var0.field2580, (int) var0.field2579, (int) var0.field2576, 60, var0, var0.field2586, -1, false);
			}
		}
	}

	@ObfuscatedName("bf.dt(I)V")
	public static final void method839() {
		for (SpotAnimEntity var0 = (SpotAnimEntity) spotanims.head(); var0 != null; var0 = (SpotAnimEntity) spotanims.next()) {
			if (currentLevel != var0.field2604 || var0.field2605) {
				var0.unlink();
			} else if (loopCycle >= var0.field2603) {
				var0.method2902(sceneDelta);
				if (var0.field2605) {
					var0.unlink();
				} else {
					field1133.method603(var0.field2604, var0.field2610, var0.field2606, var0.field2611, 60, var0, 0, -1, false);
				}
			}
		}
	}

	@ObfuscatedName("df.eb(III)V")
	public static final void method1333(int arg0, int arg1) {
		if (field1920 == 2) {
			method1019((field1933 - sceneBaseTileX << 7) + field1936, (field1934 - sceneBaseTileZ << 7) + field1937, field1935 * 2);
			if (field2140 > -1 && loopCycle % 20 < 10) {
				field1744[0].method2671(field2140 + arg0 - 12, field2025 + arg1 - 28);
			}
		}
	}

	@ObfuscatedName("ek.er(IIIII)V")
	public static final void method1843(int arg0, int arg1, int arg2, int arg3) {
		if (crossMode == 1) {
			field1767[crossCycle / 100].method2671(field2026 - 8, field2027 - 8);
		}
		if (crossMode == 2) {
			field1767[crossCycle / 100 + 4].method2671(field2026 - 8, field2027 - 8);
		}
		field2038 = 0;
		int var4 = (localPlayer.x >> 7) + sceneBaseTileX;
		int var5 = (localPlayer.z >> 7) + sceneBaseTileZ;
		if (var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
			field2038 = 1;
		}
		if (var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
			field2038 = 1;
		}
		if (field2038 == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
			field2038 = 0;
		}
		if (!field1991) {
			return;
		}
		int var6 = arg0 + 512 - 5;
		int var7 = arg1 + 20;
		field1122.method2864("Fps:" + field1540, var6, var7, 16776960, -1);
		int var11 = var7 + 15;
		Runtime var8 = Runtime.getRuntime();
		int var9 = (int) ((var8.totalMemory() - var8.freeMemory()) / 1024L);
		int var10 = 16776960;
		if (var9 > 32768 && lowMemory) {
			var10 = 16711680;
		}
		if (var9 > 65536 && !lowMemory) {
			var10 = 16711680;
		}
		field1122.method2864("Mem:" + var9 + "k", var6, var11, var10, -1);
		var7 = var11 + 15;
	}

	@ObfuscatedName("bd.es(Lfz;IB)V")
	public static final void method948(PathingEntity arg0, int arg1) {
		method1019(arg0.x, arg0.z, arg1);
	}

	@ObfuscatedName("cl.ez(IIII)V")
	public static final void method1019(int arg0, int arg1, int arg2) {
		if (arg0 < 128 || arg1 < 128 || arg0 > 13056 || arg1 > 13056) {
			field2140 = -1;
			field2025 = -1;
			return;
		}
		int var3 = getHeightmapY(arg0, arg1, currentLevel) - arg2;
		int var4 = arg0 - cameraX;
		int var5 = var3 - cameraY;
		int var6 = arg1 - cameraZ;
		int var7 = Pix3D.sinTable[cameraPitch];
		int var8 = Pix3D.cosTable[cameraPitch];
		int var9 = Pix3D.sinTable[cameraYaw];
		int var10 = Pix3D.cosTable[cameraYaw];
		int var11 = var4 * var10 + var6 * var9 >> 16;
		int var12 = var6 * var10 - var4 * var9 >> 16;
		int var14 = var5 * var8 - var7 * var12 >> 16;
		int var15 = var5 * var7 + var8 * var12 >> 16;
		if (var15 >= 50) {
			field2140 = (var11 << 9) / var15 + 256;
			field2025 = (var14 << 9) / var15 + 167;
		} else {
			field2140 = -1;
			field2025 = -1;
		}
	}

	@ObfuscatedName("bw.ev(IIII)I")
	public static final int getHeightmapY(int arg0, int arg1, int arg2) {
		int var3 = arg0 >> 7;
		int var4 = arg1 >> 7;
		if (var3 < 0 || var4 < 0 || var3 > 103 || var4 > 103) {
			return 0;
		}
		int var5 = arg2;
		if (arg2 < 3 && (World.levelTileFlags[1][var3][var4] & 0x2) == 2) {
			var5 = arg2 + 1;
		}
		int var6 = arg0 & 0x7F;
		int var7 = arg1 & 0x7F;
		int var8 = (128 - var6) * World.levelHeightmap[var5][var3][var4] + World.levelHeightmap[var5][var3 + 1][var4] * var6 >> 7;
		int var9 = (128 - var6) * World.levelHeightmap[var5][var3][var4 + 1] + World.levelHeightmap[var5][var3 + 1][var4 + 1] * var6 >> 7;
		return (128 - var7) * var8 + var7 * var9 >> 7;
	}

	@ObfuscatedName("cy.ei(ZI)V")
	public static final void method1235(boolean arg0) {
		field1978 = arg0;
		if (!field1978) {
			int var1 = in.g2();
			int var2 = in.g2_alt1();
			int var3 = (packetSize - in.pos) / 16;
			mapKeys = new int[var3][4];
			for (int var4 = 0; var4 < var3; var4++) {
				for (int var5 = 0; var5 < 4; var5++) {
					mapKeys[var4][var5] = in.g4_alt2();
				}
			}
			int var6 = in.g1_alt2();
			int var7 = in.g2();
			int var8 = in.g2_alt3();
			field801 = new int[var3];
			field826 = new int[var3];
			field1163 = new int[var3];
			field1768 = new byte[var3][];
			field186 = new byte[var3][];
			boolean var9 = false;
			if ((var7 / 8 == 48 || var7 / 8 == 49) && var8 / 8 == 48) {
				var9 = true;
			}
			if (var7 / 8 == 48 && var8 / 8 == 148) {
				var9 = true;
			}
			int var10 = 0;
			for (int var11 = (var7 - 6) / 8; var11 <= (var7 + 6) / 8; var11++) {
				for (int var12 = (var8 - 6) / 8; var12 <= (var8 + 6) / 8; var12++) {
					int var13 = (var11 << 8) + var12;
					if (!var9 || var12 != 49 && var12 != 149 && var12 != 147 && var11 != 50 && (var11 != 49 || var12 != 47)) {
						field801[var10] = var13;
						field826[var10] = field1270.getGroupId("m" + var11 + "_" + var12);
						field1163[var10] = field1270.getGroupId("l" + var11 + "_" + var12);
						var10++;
					}
				}
			}
			method390(var7, var8, var6, var2, var1);
		} else {
			int var14 = in.g2_alt3();
			in.accessBits();
			for (int var15 = 0; var15 < 4; var15++) {
				for (int var16 = 0; var16 < 13; var16++) {
					for (int var17 = 0; var17 < 13; var17++) {
						int var18 = in.gBit(1);
						if (var18 == 1) {
							field1979[var15][var16][var17] = in.gBit(26);
						} else {
							field1979[var15][var16][var17] = -1;
						}
					}
				}
			}
			in.accessBytes();
			int var19 = (packetSize - in.pos) / 16;
			mapKeys = new int[var19][4];
			for (int var20 = 0; var20 < var19; var20++) {
				for (int var21 = 0; var21 < 4; var21++) {
					mapKeys[var20][var21] = in.g4_alt2();
				}
			}
			int var22 = in.g2_alt3();
			int var23 = in.g1_alt2();
			int var24 = in.g2_alt1();
			int var25 = in.g2_alt3();
			field801 = new int[var19];
			field826 = new int[var19];
			field1163 = new int[var19];
			field1768 = new byte[var19][];
			field186 = new byte[var19][];
			int var26 = 0;
			for (int var27 = 0; var27 < 4; var27++) {
				for (int var28 = 0; var28 < 13; var28++) {
					for (int var29 = 0; var29 < 13; var29++) {
						int var30 = field1979[var27][var28][var29];
						if (var30 != -1) {
							int var31 = var30 >> 14 & 0x3FF;
							int var32 = var30 >> 3 & 0x7FF;
							int var33 = (var31 / 8 << 8) + var32 / 8;
							for (int var34 = 0; var34 < var26; var34++) {
								if (field801[var34] == var33) {
									var33 = -1;
									break;
								}
							}
							if (var33 != -1) {
								field801[var26] = var33;
								int var35 = var33 >> 8 & 0xFF;
								int var36 = var33 & 0xFF;
								field826[var26] = field1270.getGroupId("m" + var35 + "_" + var36);
								field1163[var26] = field1270.getGroupId("l" + var35 + "_" + var36);
								var26++;
							}
						}
					}
				}
			}
			method390(var14, var25, var23, var24, var22);
		}
	}

	@ObfuscatedName("as.ef(IIIIII)V")
	public static final void method390(int arg0, int arg1, int arg2, int arg3, int arg4) {
		if (field1473 == arg0 && field217 == arg1 && (field2128 == arg2 || !lowMemory)) {
			return;
		}
		field1473 = arg0;
		field217 = arg1;
		field2128 = arg2;
		if (!lowMemory) {
			field2128 = 0;
		}
		method729(25);
		method1789(EnglishLocale.field873, true);
		int var5 = sceneBaseTileX;
		int var6 = sceneBaseTileZ;
		sceneBaseTileX = (arg0 - 6) * 8;
		sceneBaseTileZ = (arg1 - 6) * 8;
		int var7 = sceneBaseTileX - var5;
		int var8 = sceneBaseTileZ - var6;
		int var9 = sceneBaseTileX;
		int var10 = sceneBaseTileZ;
		for (int var11 = 0; var11 < 32768; var11++) {
			NpcEntity var12 = npcs[var11];
			if (var12 != null) {
				for (int var13 = 0; var13 < 10; var13++) {
					var12.pathTileX[var13] -= var7;
					var12.pathTileZ[var13] -= var8;
				}
				var12.x -= var7 * 128;
				var12.z -= var8 * 128;
			}
		}
		for (int var14 = 0; var14 < 2048; var14++) {
			PlayerEntity var15 = players[var14];
			if (var15 != null) {
				for (int var16 = 0; var16 < 10; var16++) {
					var15.pathTileX[var16] -= var7;
					var15.pathTileZ[var16] -= var8;
				}
				var15.x -= var7 * 128;
				var15.z -= var8 * 128;
			}
		}
		currentLevel = arg2;
		localPlayer.method2907(arg3, arg4, false);
		byte var17 = 0;
		byte var18 = 104;
		byte var19 = 1;
		if (var7 < 0) {
			var17 = 103;
			var18 = -1;
			var19 = -1;
		}
		byte var20 = 0;
		byte var21 = 104;
		byte var22 = 1;
		if (var8 < 0) {
			var20 = 103;
			var21 = -1;
			var22 = -1;
		}
		for (int var23 = var17; var23 != var18; var23 += var19) {
			for (int var24 = var20; var24 != var21; var24 += var22) {
				int var25 = var7 + var23;
				int var26 = var8 + var24;
				for (int var27 = 0; var27 < 4; var27++) {
					if (var25 >= 0 && var26 >= 0 && var25 < 104 && var26 < 104) {
						levelObjStacks[var27][var23][var24] = levelObjStacks[var27][var25][var26];
					} else {
						levelObjStacks[var27][var23][var24] = null;
					}
				}
			}
		}
		for (LocSpawned var28 = (LocSpawned) temporaryLocs.head(); var28 != null; var28 = (LocSpawned) temporaryLocs.next()) {
			var28.field1633 -= var7;
			var28.field1632 -= var8;
			if (var28.field1633 < 0 || var28.field1632 < 0 || var28.field1633 >= 104 || var28.field1632 >= 104) {
				var28.unlink();
			}
		}
		if (flagSceneTileX != 0) {
			flagSceneTileX -= var7;
			flagSceneTileZ -= var8;
		}
		field2176 = 0;
		cutscene = false;
		minimapLevel = -1;
		spotanims.clear();
		projectiles.clear();
	}

	@ObfuscatedName("at.ej(ZB)V")
	public static final void method722(boolean arg0) {
		method1351();
		heartbeatTimer++;
		if (heartbeatTimer < 50 && !arg0) {
			return;
		}
		heartbeatTimer = 0;
		if (field1968 || stream == null) {
			return;
		}
		out.pisaac1(228);
		try {
			stream.write(out.data, 0, out.pos);
			out.pos = 0;
		} catch (IOException var2) {
			field1968 = true;
		}
	}

	@ObfuscatedName("bs.eh(IIIIII)V")
	public static final void method764(int arg0, int arg1, int arg2, int arg3, int arg4) {
		int var5 = field1133.method590(arg0, arg1, arg2);
		if (var5 != 0) {
			int var6 = field1133.method594(arg0, arg1, arg2, var5);
			int var7 = var6 >> 6 & 0x3;
			int var8 = var6 & 0x1F;
			int var9 = arg3;
			if (var5 > 0) {
				var9 = arg4;
			}
			int[] var10 = field1627.field2506;
			int var11 = (103 - arg2) * 2048 + arg1 * 4 + 24624;
			int var12 = var5 >> 14 & 0x7FFF;
			LocType var13 = LocType.get(var12);
			if (var13.mapscene == -1) {
				if (var8 == 0 || var8 == 2) {
					if (var7 == 0) {
						var10[var11] = var9;
						var10[var11 + 512] = var9;
						var10[var11 + 1024] = var9;
						var10[var11 + 1536] = var9;
					} else if (var7 == 1) {
						var10[var11] = var9;
						var10[var11 + 1] = var9;
						var10[var11 + 2] = var9;
						var10[var11 + 3] = var9;
					} else if (var7 == 2) {
						var10[var11 + 3] = var9;
						var10[var11 + 3 + 512] = var9;
						var10[var11 + 3 + 1024] = var9;
						var10[var11 + 3 + 1536] = var9;
					} else if (var7 == 3) {
						var10[var11 + 1536] = var9;
						var10[var11 + 1536 + 1] = var9;
						var10[var11 + 1536 + 2] = var9;
						var10[var11 + 1536 + 3] = var9;
					}
				}
				if (var8 == 3) {
					if (var7 == 0) {
						var10[var11] = var9;
					} else if (var7 == 1) {
						var10[var11 + 3] = var9;
					} else if (var7 == 2) {
						var10[var11 + 3 + 1536] = var9;
					} else if (var7 == 3) {
						var10[var11 + 1536] = var9;
					}
				}
				if (var8 == 2) {
					if (var7 == 3) {
						var10[var11] = var9;
						var10[var11 + 512] = var9;
						var10[var11 + 1024] = var9;
						var10[var11 + 1536] = var9;
					} else if (var7 == 0) {
						var10[var11] = var9;
						var10[var11 + 1] = var9;
						var10[var11 + 2] = var9;
						var10[var11 + 3] = var9;
					} else if (var7 == 1) {
						var10[var11 + 3] = var9;
						var10[var11 + 3 + 512] = var9;
						var10[var11 + 3 + 1024] = var9;
						var10[var11 + 3 + 1536] = var9;
					} else if (var7 == 2) {
						var10[var11 + 1536] = var9;
						var10[var11 + 1536 + 1] = var9;
						var10[var11 + 1536 + 2] = var9;
						var10[var11 + 1536 + 3] = var9;
					}
				}
			} else {
				Pix8 var14 = field263[var13.mapscene];
				if (var14 != null) {
					int var15 = (var13.width * 4 - var14.field2513) / 2;
					int var16 = (var13.length * 4 - var14.field2514) / 2;
					var14.method2747(arg1 * 4 + 48 + var15, (104 - arg2 - var13.length) * 4 + 48 + var16);
				}
			}
		}
		int var17 = field1133.method592(arg0, arg1, arg2);
		if (var17 != 0) {
			int var18 = field1133.method594(arg0, arg1, arg2, var17);
			int var19 = var18 >> 6 & 0x3;
			int var20 = var18 & 0x1F;
			int var21 = var17 >> 14 & 0x7FFF;
			LocType var22 = LocType.get(var21);
			if (var22.mapscene != -1) {
				Pix8 var23 = field263[var22.mapscene];
				if (var23 != null) {
					int var24 = (var22.width * 4 - var23.field2513) / 2;
					int var25 = (var22.length * 4 - var23.field2514) / 2;
					var23.method2747(arg1 * 4 + 48 + var24, (104 - arg2 - var22.length) * 4 + 48 + var25);
				}
			} else if (var20 == 9) {
				int var26 = 15658734;
				if (var17 > 0) {
					var26 = 15597568;
				}
				int[] var27 = field1627.field2506;
				int var28 = (103 - arg2) * 2048 + arg1 * 4 + 24624;
				if (var19 == 0 || var19 == 2) {
					var27[var28 + 1536] = var26;
					var27[var28 + 1024 + 1] = var26;
					var27[var28 + 512 + 2] = var26;
					var27[var28 + 3] = var26;
				} else {
					var27[var28] = var26;
					var27[var28 + 512 + 1] = var26;
					var27[var28 + 1024 + 2] = var26;
					var27[var28 + 1536 + 3] = var26;
				}
			}
		}
		int var29 = field1133.method593(arg0, arg1, arg2);
		if (var29 == 0) {
			return;
		}
		int var30 = var29 >> 14 & 0x7FFF;
		LocType var31 = LocType.get(var30);
		if (var31.mapscene == -1) {
			return;
		}
		Pix8 var32 = field263[var31.mapscene];
		if (var32 != null) {
			int var33 = (var31.width * 4 - var32.field2513) / 2;
			int var34 = (var31.length * 4 - var32.field2514) / 2;
			var32.method2747(arg1 * 4 + 48 + var33, (104 - arg2 - var31.length) * 4 + 48 + var34);
		}
	}

	@ObfuscatedName("cz.eg(IIII)Z")
	public static final boolean method1149(int arg0, int arg1, int arg2) {
		int var3 = arg2 >> 14 & 0x7FFF;
		int var4 = field1133.method594(currentLevel, arg0, arg1, arg2);
		if (var4 == -1) {
			return false;
		}
		int var5 = var4 & 0x1F;
		int var6 = var4 >> 6 & 0x3;
		if (var5 == 10 || var5 == 11 || var5 == 22) {
			LocType var7 = LocType.get(var3);
			int var8;
			int var9;
			if (var6 == 0 || var6 == 2) {
				var8 = var7.width;
				var9 = var7.length;
			} else {
				var8 = var7.length;
				var9 = var7.width;
			}
			int var10 = var7.forceapproach;
			if (var6 != 0) {
				var10 = (var10 >> 4 - var6) + (var10 << var6 & 0xF);
			}
			method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], arg0, arg1, true, 0, 0, var8, var9, var10, 2);
		} else {
			method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], arg0, arg1, true, var5 + 1, var6, 0, 0, 0, 2);
		}
		field2026 = JavaMouseProvider.mouseClickX;
		field2027 = JavaMouseProvider.mouseClickY;
		crossMode = 2;
		crossCycle = 0;
		return true;
	}

	@ObfuscatedName("eh.el(IIIIZIIIIIIS)Z")
	public static final boolean method1791(int arg0, int arg1, int arg2, int arg3, boolean arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
		for (int var11 = 0; var11 < 104; var11++) {
			for (int var12 = 0; var12 < 104; var12++) {
				field2041[var11][var12] = 0;
				field1946[var11][var12] = 99999999;
			}
		}
		int var13 = arg0;
		int var14 = arg1;
		field2041[arg0][arg1] = 99;
		field1946[arg0][arg1] = 0;
		byte var15 = 0;
		int var16 = 0;
		field1984[var15] = arg0;
		int var36 = var15 + 1;
		field1985[var15] = arg1;
		boolean var17 = false;
		int var18 = field1984.length;
		int[][] var19 = levelCollisionMap[currentLevel].field1266;
		while (var36 != var16) {
			var13 = field1984[var16];
			var14 = field1985[var16];
			var16 = (var16 + 1) % var18;
			if (arg2 == var13 && arg3 == var14) {
				var17 = true;
				break;
			}
			if (arg5 != 0) {
				if ((arg5 < 5 || arg5 == 10) && levelCollisionMap[currentLevel].method1197(var13, var14, arg2, arg3, arg5 - 1, arg6)) {
					var17 = true;
					break;
				}
				if (arg5 < 10 && levelCollisionMap[currentLevel].method1207(var13, var14, arg2, arg3, arg5 - 1, arg6)) {
					var17 = true;
					break;
				}
			}
			if (arg7 != 0 && arg8 != 0 && levelCollisionMap[currentLevel].method1208(var13, var14, arg2, arg3, arg7, arg8, arg9)) {
				var17 = true;
				break;
			}
			int var20 = field1946[var13][var14] + 1;
			if (var13 > 0 && field2041[var13 - 1][var14] == 0 && (var19[var13 - 1][var14] & 0x12C0108) == 0) {
				field1984[var36] = var13 - 1;
				field1985[var36] = var14;
				var36 = (var36 + 1) % var18;
				field2041[var13 - 1][var14] = 2;
				field1946[var13 - 1][var14] = var20;
			}
			if (var13 < 103 && field2041[var13 + 1][var14] == 0 && (var19[var13 + 1][var14] & 0x12C0180) == 0) {
				field1984[var36] = var13 + 1;
				field1985[var36] = var14;
				var36 = (var36 + 1) % var18;
				field2041[var13 + 1][var14] = 8;
				field1946[var13 + 1][var14] = var20;
			}
			if (var14 > 0 && field2041[var13][var14 - 1] == 0 && (var19[var13][var14 - 1] & 0x12C0102) == 0) {
				field1984[var36] = var13;
				field1985[var36] = var14 - 1;
				var36 = (var36 + 1) % var18;
				field2041[var13][var14 - 1] = 1;
				field1946[var13][var14 - 1] = var20;
			}
			if (var14 < 103 && field2041[var13][var14 + 1] == 0 && (var19[var13][var14 + 1] & 0x12C0120) == 0) {
				field1984[var36] = var13;
				field1985[var36] = var14 + 1;
				var36 = (var36 + 1) % var18;
				field2041[var13][var14 + 1] = 4;
				field1946[var13][var14 + 1] = var20;
			}
			if (var13 > 0 && var14 > 0 && field2041[var13 - 1][var14 - 1] == 0 && (var19[var13 - 1][var14 - 1] & 0x12C010E) == 0 && (var19[var13 - 1][var14] & 0x12C0108) == 0 && (var19[var13][var14 - 1] & 0x12C0102) == 0) {
				field1984[var36] = var13 - 1;
				field1985[var36] = var14 - 1;
				var36 = (var36 + 1) % var18;
				field2041[var13 - 1][var14 - 1] = 3;
				field1946[var13 - 1][var14 - 1] = var20;
			}
			if (var13 < 103 && var14 > 0 && field2041[var13 + 1][var14 - 1] == 0 && (var19[var13 + 1][var14 - 1] & 0x12C0183) == 0 && (var19[var13 + 1][var14] & 0x12C0180) == 0 && (var19[var13][var14 - 1] & 0x12C0102) == 0) {
				field1984[var36] = var13 + 1;
				field1985[var36] = var14 - 1;
				var36 = (var36 + 1) % var18;
				field2041[var13 + 1][var14 - 1] = 9;
				field1946[var13 + 1][var14 - 1] = var20;
			}
			if (var13 > 0 && var14 < 103 && field2041[var13 - 1][var14 + 1] == 0 && (var19[var13 - 1][var14 + 1] & 0x12C0138) == 0 && (var19[var13 - 1][var14] & 0x12C0108) == 0 && (var19[var13][var14 + 1] & 0x12C0120) == 0) {
				field1984[var36] = var13 - 1;
				field1985[var36] = var14 + 1;
				var36 = (var36 + 1) % var18;
				field2041[var13 - 1][var14 + 1] = 6;
				field1946[var13 - 1][var14 + 1] = var20;
			}
			if (var13 < 103 && var14 < 103 && field2041[var13 + 1][var14 + 1] == 0 && (var19[var13 + 1][var14 + 1] & 0x12C01E0) == 0 && (var19[var13 + 1][var14] & 0x12C0180) == 0 && (var19[var13][var14 + 1] & 0x12C0120) == 0) {
				field1984[var36] = var13 + 1;
				field1985[var36] = var14 + 1;
				var36 = (var36 + 1) % var18;
				field2041[var13 + 1][var14 + 1] = 12;
				field1946[var13 + 1][var14 + 1] = var20;
			}
		}
		field1981 = 0;
		if (!var17) {
			if (!arg4) {
				return false;
			}
			int var21 = 1000;
			int var22 = 100;
			byte var23 = 10;
			for (int var24 = arg2 - var23; var24 <= arg2 + var23; var24++) {
				for (int var25 = arg3 - var23; var25 <= arg3 + var23; var25++) {
					if (var24 >= 0 && var25 >= 0 && var24 < 104 && var25 < 104 && field1946[var24][var25] < 100) {
						int var26 = 0;
						if (var24 < arg2) {
							var26 = arg2 - var24;
						} else if (var24 > arg2 + arg7 - 1) {
							var26 = var24 - (arg2 + arg7 - 1);
						}
						int var27 = 0;
						if (var25 < arg3) {
							var27 = arg3 - var25;
						} else if (var25 > arg3 + arg8 - 1) {
							var27 = var25 - (arg3 + arg8 - 1);
						}
						int var28 = var26 * var26 + var27 * var27;
						if (var28 < var21 || var21 == var28 && field1946[var24][var25] < var22) {
							var21 = var28;
							var22 = field1946[var24][var25];
							var13 = var24;
							var14 = var25;
						}
					}
				}
			}
			if (var21 == 1000) {
				return false;
			}
			if (arg0 == var13 && arg1 == var14) {
				return false;
			}
			field1981 = 1;
		}
		byte var29 = 0;
		field1984[var29] = var13;
		int var37 = var29 + 1;
		field1985[var29] = var14;
		int var30;
		int var31 = var30 = field2041[var13][var14];
		while (arg0 != var13 || arg1 != var14) {
			if (var30 != var31) {
				var30 = var31;
				field1984[var37] = var13;
				field1985[var37++] = var14;
			}
			if ((var31 & 0x2) != 0) {
				var13++;
			} else if ((var31 & 0x8) != 0) {
				var13--;
			}
			if ((var31 & 0x1) != 0) {
				var14++;
			} else if ((var31 & 0x4) != 0) {
				var14--;
			}
			var31 = field2041[var13][var14];
		}
		if (var37 > 0) {
			int var32 = var37;
			if (var37 > 25) {
				var32 = 25;
			}
			var37--;
			int var33 = field1984[var37];
			int var34 = field1985[var37];
			if (arg10 == 0) {
				out.pisaac1(176);
				out.p1(var32 + var32 + 3);
			}
			if (arg10 == 1) {
				out.pisaac1(60);
				out.p1(var32 + var32 + 3 + 14);
			}
			if (arg10 == 2) {
				out.pisaac1(214);
				out.p1(var32 + var32 + 3);
			}
			flagSceneTileX = field1984[0];
			flagSceneTileZ = field1985[0];
			for (int var35 = 1; var35 < var32; var35++) {
				var37--;
				out.p1_alt2(field1984[var37] - var33);
				out.p1_alt3(field1985[var37] - var34);
			}
			out.p2_alt3(sceneBaseTileZ + var34);
			out.p1(JavaKeyboardProvider.actionKey[82] ? 1 : 0);
			out.p2(sceneBaseTileX + var33);
			return true;
		} else if (arg10 == 1) {
			return false;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ai.en(I)V")
	public static final void method724() {
		if (packetType == 245) {
			int var0 = in.g2();
			byte var1 = in.g1b_alt1();
			int var2 = in.g1_alt2();
			int var3 = var2 >> 2;
			int var4 = var2 & 0x3;
			int var5 = LOC_SHAPE_TO_LAYER[var3];
			int var6 = in.g2_alt2();
			int var7 = in.g2_alt1();
			int var8 = in.g2();
			int var9 = in.g1_alt3();
			int var10 = (var9 >> 4 & 0x7) + field351;
			int var11 = (var9 & 0x7) + field1485;
			byte var12 = in.g1b_alt1();
			byte var13 = in.g1b();
			byte var14 = in.g1b();
			PlayerEntity var15;
			if (field2005 == var8) {
				var15 = localPlayer;
			} else {
				var15 = players[var8];
			}
			if (var15 != null) {
				LocType var16 = LocType.get(var6);
				int var17;
				int var18;
				if (var4 == 1 || var4 == 3) {
					var17 = var16.length;
					var18 = var16.width;
				} else {
					var17 = var16.width;
					var18 = var16.length;
				}
				int var19 = (var17 >> 1) + var10;
				int var20 = (var17 + 1 >> 1) + var10;
				int var21 = (var18 >> 1) + var11;
				int var22 = (var18 + 1 >> 1) + var11;
				int[][] var23 = World.levelHeightmap[currentLevel];
				int var24 = var23[var19][var21] + var23[var20][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
				int var25 = (var10 << 7) + (var17 << 6);
				int var26 = (var11 << 7) + (var18 << 6);
				SoftwareModel var27 = var16.method2386(var3, var4, var23, var25, var24, var26);
				if (var27 != null) {
					method421(currentLevel, var10, var11, var5, -1, 0, 0, var7 + 1, var0 + 1);
					var15.field2792 = loopCycle + var7;
					var15.field2793 = loopCycle + var0;
					var15.field2801 = var27;
					var15.field2794 = var10 * 128 + var17 * 64;
					var15.field2799 = var11 * 128 + var18 * 64;
					var15.field2797 = var24;
					if (var14 > var12) {
						byte var28 = var14;
						var14 = var12;
						var12 = var28;
					}
					if (var13 > var1) {
						byte var29 = var13;
						var13 = var1;
						var1 = var29;
					}
					var15.field2798 = var10 + var14;
					var15.field2785 = var10 + var12;
					var15.field2802 = var11 + var13;
					var15.field2788 = var1 + var11;
				}
			}
		}
		if (packetType == 207) {
			int var30 = in.g2_alt3();
			int var31 = in.g1();
			int var32 = (var31 >> 4 & 0x7) + field351;
			int var33 = (var31 & 0x7) + field1485;
			if (var32 >= 0 && var33 >= 0 && var32 < 104 && var33 < 104) {
				LinkList var34 = levelObjStacks[currentLevel][var32][var33];
				if (var34 != null) {
					for (ObjStackEntity var35 = (ObjStackEntity) var34.head(); var35 != null; var35 = (ObjStackEntity) var34.next()) {
						if ((var30 & 0x7FFF) == var35.field2600) {
							var35.unlink();
							break;
						}
					}
					if (var34.head() == null) {
						levelObjStacks[currentLevel][var32][var33] = null;
					}
					method1486(var32, var33);
				}
			}
			return;
		}
		if (packetType == 205) {
			int var36 = in.g1();
			int var37 = (var36 >> 4 & 0x7) + field351;
			int var38 = (var36 & 0x7) + field1485;
			int var39 = in.g2();
			int var40 = in.g1();
			int var41 = var40 >> 4 & 0xF;
			int var42 = var40 & 0x7;
			int var43 = in.g1();
			if (var37 >= 0 && var38 >= 0 && var37 < 104 && var38 < 104) {
				int var44 = var41 + 1;
				if (localPlayer.pathTileX[0] >= var37 - var44 && localPlayer.pathTileX[0] <= var37 + var44 && localPlayer.pathTileZ[0] >= var38 - var44 && localPlayer.pathTileZ[0] <= var38 + var44 && field2174 != 0 && var42 > 0 && field2176 < 50) {
					field2177[field2176] = var39;
					field2006[field2176] = var42;
					field2179[field2176] = var43;
					field2181[field2176] = null;
					field2180[field2176] = (var37 << 16) + (var38 << 8) + var41;
					field2176++;
				}
			}
		}
		if (packetType == 6) {
			int var45 = in.g2_alt2();
			int var46 = in.g1_alt2();
			int var47 = (var46 >> 4 & 0x7) + field351;
			int var48 = (var46 & 0x7) + field1485;
			int var49 = in.g1_alt3();
			int var50 = var49 >> 2;
			int var51 = var49 & 0x3;
			int var52 = LOC_SHAPE_TO_LAYER[var50];
			if (var47 >= 0 && var48 >= 0 && var47 < 103 && var48 < 103) {
				if (var52 == 0) {
					Wall var53 = field1133.method715(currentLevel, var47, var48);
					if (var53 != null) {
						int var54 = var53.field647 >> 14 & 0x7FFF;
						if (var50 == 2) {
							var53.field646 = new LocEntity(var54, 2, var51 + 4, currentLevel, var47, var48, var45, false, var53.field646);
							var53.field649 = new LocEntity(var54, 2, var51 + 1 & 0x3, currentLevel, var47, var48, var45, false, var53.field649);
						} else {
							var53.field646 = new LocEntity(var54, var50, var51, currentLevel, var47, var48, var45, false, var53.field646);
						}
					}
				}
				if (var52 == 1) {
					Decor var55 = field1133.method602(currentLevel, var47, var48);
					if (var55 != null) {
						int var56 = var55.field714 >> 14 & 0x7FFF;
						if (var50 == 4 || var50 == 5) {
							var55.field712 = new LocEntity(var56, 4, var51, currentLevel, var47, var48, var45, false, var55.field712);
						} else if (var50 == 6) {
							var55.field712 = new LocEntity(var56, 4, var51 + 4, currentLevel, var47, var48, var45, false, var55.field712);
						} else if (var50 == 7) {
							var55.field712 = new LocEntity(var56, 4, (var51 + 2 & 0x3) + 4, currentLevel, var47, var48, var45, false, var55.field712);
						} else if (var50 == 8) {
							var55.field712 = new LocEntity(var56, 4, var51 + 4, currentLevel, var47, var48, var45, false, var55.field712);
							var55.field713 = new LocEntity(var56, 4, (var51 + 2 & 0x3) + 4, currentLevel, var47, var48, var45, false, var55.field713);
						}
					}
				}
				if (var52 == 2) {
					Location var57 = field1133.method686(currentLevel, var47, var48);
					if (var50 == 11) {
						var50 = 10;
					}
					if (var57 != null) {
						var57.field672 = new LocEntity(var57.field678 >> 14 & 0x7FFF, var50, var51, currentLevel, var47, var48, var45, false, var57.field672);
					}
				}
				if (var52 == 3) {
					GroundDecor var58 = field1133.method621(currentLevel, var47, var48);
					if (var58 != null) {
						var58.field701 = new LocEntity(var58.field702 >> 14 & 0x7FFF, 22, var51, currentLevel, var47, var48, var45, false, var58.field701);
					}
				}
			}
		} else if (packetType == 173) {
			int var59 = in.g1_alt1();
			int var60 = (var59 >> 4 & 0x7) + field351;
			int var61 = (var59 & 0x7) + field1485;
			int var62 = in.g2_alt2();
			int var63 = in.g2_alt3();
			if (var60 >= 0 && var61 >= 0 && var60 < 104 && var61 < 104) {
				ObjStackEntity var64 = new ObjStackEntity();
				var64.field2600 = var63;
				var64.field2601 = var62;
				if (levelObjStacks[currentLevel][var60][var61] == null) {
					levelObjStacks[currentLevel][var60][var61] = new LinkList();
				}
				levelObjStacks[currentLevel][var60][var61].push(var64);
				method1486(var60, var61);
			}
		} else if (packetType == 106) {
			int var65 = in.g1();
			int var66 = (var65 >> 4 & 0x7) + field351;
			int var67 = (var65 & 0x7) + field1485;
			int var68 = in.g2();
			int var69 = in.g2();
			int var70 = in.g2();
			if (var66 >= 0 && var67 >= 0 && var66 < 104 && var67 < 104) {
				LinkList var71 = levelObjStacks[currentLevel][var66][var67];
				if (var71 != null) {
					for (ObjStackEntity var72 = (ObjStackEntity) var71.head(); var72 != null; var72 = (ObjStackEntity) var71.next()) {
						if ((var68 & 0x7FFF) == var72.field2600 && var72.field2601 == var69) {
							var72.field2601 = var70;
							break;
						}
					}
					method1486(var66, var67);
				}
			}
		} else if (packetType == 154) {
			int var73 = in.g2_alt3();
			int var74 = in.g1_alt1();
			int var75 = var74 >> 2;
			int var76 = var74 & 0x3;
			int var77 = LOC_SHAPE_TO_LAYER[var75];
			int var78 = in.g1_alt2();
			int var79 = (var78 >> 4 & 0x7) + field351;
			int var80 = (var78 & 0x7) + field1485;
			if (var79 >= 0 && var80 >= 0 && var79 < 104 && var80 < 104) {
				method421(currentLevel, var79, var80, var77, var73, var75, var76, 0, -1);
			}
		} else if (packetType == 20) {
			int var81 = in.g1();
			int var82 = (var81 >> 4 & 0x7) + field351;
			int var83 = (var81 & 0x7) + field1485;
			int var84 = in.g2();
			int var85 = in.g1();
			int var86 = in.g2();
			if (var82 >= 0 && var83 >= 0 && var82 < 104 && var83 < 104) {
				int var87 = var82 * 128 + 64;
				int var88 = var83 * 128 + 64;
				SpotAnimEntity var89 = new SpotAnimEntity(var84, currentLevel, var87, var88, getHeightmapY(var87, var88, currentLevel) - var85, var86, loopCycle);
				spotanims.push(var89);
			}
		} else if (packetType == 32) {
			int var90 = in.g1();
			int var91 = (var90 >> 4 & 0x7) + field351;
			int var92 = (var90 & 0x7) + field1485;
			int var93 = var91 + in.g1b();
			int var94 = var92 + in.g1b();
			int var95 = in.g2b();
			int var96 = in.g2();
			int var97 = in.g1() * 4;
			int var98 = in.g1() * 4;
			int var99 = in.g2();
			int var100 = in.g2();
			int var101 = in.g1();
			int var102 = in.g1();
			if (var91 >= 0 && var92 >= 0 && var91 < 104 && var92 < 104 && var93 >= 0 && var94 >= 0 && var93 < 104 && var94 < 104 && var96 != 65535) {
				int var103 = var91 * 128 + 64;
				int var104 = var92 * 128 + 64;
				int var105 = var93 * 128 + 64;
				int var106 = var94 * 128 + 64;
				ProjAnimEntity var107 = new ProjAnimEntity(var96, currentLevel, var103, var104, getHeightmapY(var103, var104, currentLevel) - var97, loopCycle + var99, loopCycle + var100, var101, var102, var95, var98);
				var107.method2896(var105, var106, getHeightmapY(var105, var106, currentLevel) - var98, loopCycle + var99);
				projectiles.push(var107);
			}
		} else if (packetType == 215) {
			int var108 = in.g1_alt2();
			int var109 = (var108 >> 4 & 0x7) + field351;
			int var110 = (var108 & 0x7) + field1485;
			int var111 = in.g2();
			int var112 = in.g2_alt2();
			int var113 = in.g2();
			if (var109 >= 0 && var110 >= 0 && var109 < 104 && var110 < 104 && field2005 != var111) {
				ObjStackEntity var114 = new ObjStackEntity();
				var114.field2600 = var113;
				var114.field2601 = var112;
				if (levelObjStacks[currentLevel][var109][var110] == null) {
					levelObjStacks[currentLevel][var109][var110] = new LinkList();
				}
				levelObjStacks[currentLevel][var109][var110].push(var114);
				method1486(var109, var110);
			}
		} else if (packetType == 7) {
			int var115 = in.g1_alt3();
			int var116 = var115 >> 2;
			int var117 = var115 & 0x3;
			int var118 = LOC_SHAPE_TO_LAYER[var116];
			int var119 = in.g1_alt1();
			int var120 = (var119 >> 4 & 0x7) + field351;
			int var121 = (var119 & 0x7) + field1485;
			if (var120 >= 0 && var121 >= 0 && var120 < 104 && var121 < 104) {
				method421(currentLevel, var120, var121, var118, -1, var116, var117, 0, -1);
			}
		}
	}

	@ObfuscatedName("ap.ew(IIIIIIIIII)V")
	public static final void method421(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
		LocSpawned var9 = null;
		for (LocSpawned var10 = (LocSpawned) temporaryLocs.head(); var10 != null; var10 = (LocSpawned) temporaryLocs.next()) {
			if (var10.field1638 == arg0 && var10.field1633 == arg1 && var10.field1632 == arg2 && var10.field1630 == arg3) {
				var9 = var10;
				break;
			}
		}
		if (var9 == null) {
			var9 = new LocSpawned();
			var9.field1638 = arg0;
			var9.field1630 = arg3;
			var9.field1633 = arg1;
			var9.field1632 = arg2;
			method1447(var9);
			temporaryLocs.push(var9);
		}
		var9.field1636 = arg4;
		var9.field1631 = arg5;
		var9.field1637 = arg6;
		var9.field1639 = arg7;
		var9.field1640 = arg8;
	}

	@ObfuscatedName("dc.ek(Ldn;I)V")
	public static final void method1447(LocSpawned arg0) {
		int var1 = 0;
		int var2 = -1;
		int var3 = 0;
		int var4 = 0;
		if (arg0.field1630 == 0) {
			var1 = field1133.method590(arg0.field1638, arg0.field1633, arg0.field1632);
		}
		if (arg0.field1630 == 1) {
			var1 = field1133.method591(arg0.field1638, arg0.field1633, arg0.field1632);
		}
		if (arg0.field1630 == 2) {
			var1 = field1133.method592(arg0.field1638, arg0.field1633, arg0.field1632);
		}
		if (arg0.field1630 == 3) {
			var1 = field1133.method593(arg0.field1638, arg0.field1633, arg0.field1632);
		}
		if (var1 != 0) {
			int var5 = field1133.method594(arg0.field1638, arg0.field1633, arg0.field1632, var1);
			var2 = var1 >> 14 & 0x7FFF;
			var3 = var5 & 0x1F;
			var4 = var5 >> 6 & 0x3;
		}
		arg0.field1629 = var2;
		arg0.field1635 = var3;
		arg0.field1634 = var4;
	}

	@ObfuscatedName("f.eq(IIIIIIII)V")
	public static final void method274(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		if (arg2 < 1 || arg3 < 1 || arg2 > 102 || arg3 > 102) {
			return;
		}
		if (lowMemory && currentLevel != arg0) {
			return;
		}
		int var7 = 0;
		boolean var8 = true;
		boolean var9 = false;
		boolean var10 = false;
		if (arg1 == 0) {
			var7 = field1133.method590(arg0, arg2, arg3);
		}
		if (arg1 == 1) {
			var7 = field1133.method591(arg0, arg2, arg3);
		}
		if (arg1 == 2) {
			var7 = field1133.method592(arg0, arg2, arg3);
		}
		if (arg1 == 3) {
			var7 = field1133.method593(arg0, arg2, arg3);
		}
		if (var7 != 0) {
			int var11 = field1133.method594(arg0, arg2, arg3, var7);
			int var12 = var7 >> 14 & 0x7FFF;
			int var13 = var11 & 0x1F;
			int var14 = var11 >> 6 & 0x3;
			if (arg1 == 0) {
				field1133.method581(arg0, arg2, arg3);
				LocType var15 = LocType.get(var12);
				if (var15.blockwalk != 0) {
					levelCollisionMap[arg0].method1202(arg2, arg3, var13, var14, var15.blockrange);
				}
			}
			if (arg1 == 1) {
				field1133.method582(arg0, arg2, arg3);
			}
			if (arg1 == 2) {
				field1133.method583(arg0, arg2, arg3);
				LocType var16 = LocType.get(var12);
				if (var16.width + arg2 > 103 || var16.width + arg3 > 103 || var16.length + arg2 > 103 || var16.length + arg3 > 103) {
					return;
				}
				if (var16.blockwalk != 0) {
					levelCollisionMap[arg0].method1217(arg2, arg3, var16.width, var16.length, var14, var16.blockrange);
				}
			}
			if (arg1 == 3) {
				field1133.method584(arg0, arg2, arg3);
				LocType var17 = LocType.get(var12);
				if (var17.blockwalk == 1) {
					levelCollisionMap[arg0].method1205(arg2, arg3);
				}
			}
		}
		if (arg4 < 0) {
			return;
		}
		int var18 = arg0;
		if (arg0 < 3 && (World.levelTileFlags[1][arg2][arg3] & 0x2) == 2) {
			var18 = arg0 + 1;
		}
		World.method918(arg0, var18, arg2, arg3, arg4, arg5, arg6, field1133, levelCollisionMap[arg0]);
	}

	@ObfuscatedName("dr.et(III)V")
	public static final void method1486(int arg0, int arg1) {
		LinkList var2 = levelObjStacks[currentLevel][arg0][arg1];
		if (var2 == null) {
			field1133.method666(currentLevel, arg0, arg1);
			return;
		}
		int var3 = -99999999;
		ObjStackEntity var4 = null;
		for (ObjStackEntity var5 = (ObjStackEntity) var2.head(); var5 != null; var5 = (ObjStackEntity) var2.next()) {
			ObjType var6 = ObjType.get(var5.field2600);
			int var7 = var6.cost;
			if (var6.stackable == 1) {
				var7 = (var5.field2601 + 1) * var7;
			}
			if (var7 > var3) {
				var3 = var7;
				var4 = var5;
			}
		}
		if (var4 == null) {
			field1133.method666(currentLevel, arg0, arg1);
			return;
		}
		var2.addHead(var4);
		ObjStackEntity var8 = null;
		ObjStackEntity var9 = null;
		for (ObjStackEntity var10 = (ObjStackEntity) var2.head(); var10 != null; var10 = (ObjStackEntity) var2.next()) {
			if (var4.field2600 != var10.field2600) {
				if (var8 == null) {
					var8 = var10;
				}
				if (var8.field2600 != var10.field2600 && var9 == null) {
					var9 = var10;
				}
			}
		}
		int var11 = (arg1 << 7) + arg0 + 1610612736;
		field1133.method571(currentLevel, arg0, arg1, getHeightmapY(arg0 * 128 + 64, arg1 * 128 + 64, currentLevel), var4, var11, var8, var9);
	}

	@ObfuscatedName("ej.ee(I)V")
	public static final void method1788() {
		field2035 = 0;
		field2044 = 0;
		imethod17();
		imethod18();
		imethod19();
		imethod20();
		for (int var44 = 0; var44 < field2035; var44++) {
			int var45 = field2198[var44];
			if (loopCycle != players[var45].field2660) {
				players[var45] = null;
			}
		}
		if (packetSize != in.pos) {
			throw new RuntimeException("gpp1 pos:" + in.pos + " size:" + packetSize);
		}
		for (int var46 = 0; var46 < playerCount; var46++) {
			if (players[playerIds[var46]] == null) {
				throw new RuntimeException("gpp2 pos:" + var46 + " size:" + playerCount);
			}
		}
	}

	@ObfuscatedName("dm.ed(I)V")
	public static final void method1461() {
		while (true) {
			if (in.bitsAvailable(packetSize) >= 27) {
				int var0 = in.gBit(15);
				if (var0 != 32767) {
					boolean var1 = false;
					if (npcs[var0] == null) {
						npcs[var0] = new NpcEntity();
						var1 = true;
					}
					NpcEntity var2 = npcs[var0];
					field1956[++npcCount - 1] = var0;
					var2.field2660 = loopCycle;
					int var3 = field1941[in.gBit(3)];
					if (var1) {
						var2.field2618 = var2.field2646 = var3;
					}
					int var4 = in.gBit(5);
					if (var4 > 15) {
						var4 -= 32;
					}
					int var5 = in.gBit(1);
					if (var5 == 1) {
						field2045[++field2044 - 1] = var0;
					}
					int var6 = in.gBit(1);
					var2.field2804 = NpcType.get(in.gBit(14));
					int var7 = in.gBit(5);
					if (var7 > 15) {
						var7 -= 32;
					}
					var2.field2657 = var2.field2804.size;
					var2.field2661 = var2.field2804.turnspeed;
					if (var2.field2661 == 0) {
						var2.field2646 = 0;
					}
					var2.field2621 = var2.field2804.walkanim;
					var2.field2664 = var2.field2804.walkanim_b;
					var2.field2623 = var2.field2804.walkanim_r;
					var2.field2624 = var2.field2804.walkanim_l;
					var2.field2622 = var2.field2804.readyanim;
					var2.field2619 = var2.field2804.field2287;
					var2.field2620 = var2.field2804.field2278;
					var2.method2907(localPlayer.pathTileX[0] + var7, localPlayer.pathTileZ[0] + var4, var6 == 1);
					continue;
				}
			}
			in.accessBytes();
			return;
		}
	}

	@ObfuscatedName("ag.ex(B)V")
	public static final void method562() {
		for (int var0 = 0; var0 < field2044; var0++) {
			int var1 = field2045[var0];
			NpcEntity var2 = npcs[var1];
			int var3 = in.g1();
			if ((var3 & 0x80) != 0) {
				int var4 = in.g1();
				int var5 = in.g1_alt2();
				var2.method2911(var4, var5, loopCycle);
				var2.field2635 = loopCycle + 300;
				var2.field2613 = in.g1_alt1();
				var2.field2636 = in.g1_alt1();
			}
			if ((var3 & 0x4) != 0) {
				var2.field2637 = in.g2_alt1();
				if (var2.field2637 == 65535) {
					var2.field2637 = -1;
				}
			}
			if ((var3 & 0x2) != 0) {
				var2.field2638 = in.g2_alt3();
				var2.field2639 = in.g2_alt3();
			}
			if ((var3 & 0x1) != 0) {
				var2.field2648 = in.g2_alt1();
				int var6 = in.g4();
				var2.field2629 = var6 >> 16;
				var2.field2651 = (var6 & 0xFFFF) + loopCycle;
				var2.field2649 = 0;
				var2.field2650 = 0;
				if (var2.field2651 > loopCycle) {
					var2.field2649 = -1;
				}
				if (var2.field2648 == 65535) {
					var2.field2648 = -1;
				}
			}
			if ((var3 & 0x8) != 0) {
				int var7 = in.g2_alt3();
				if (var7 == 65535) {
					var7 = -1;
				}
				int var8 = in.g1_alt1();
				if (var2.field2643 == var7 && var7 != -1) {
					int var9 = SeqType.get(var7).replacemode;
					if (var9 == 1) {
						var2.field2653 = 0;
						var2.field2645 = 0;
						var2.field2627 = var8;
						var2.field2647 = 0;
					}
					if (var9 == 2) {
						var2.field2647 = 0;
					}
				} else if (var7 == -1 || var2.field2643 == -1 || SeqType.get(var7).priority >= SeqType.get(var2.field2643).priority) {
					var2.field2643 = var7;
					var2.field2653 = 0;
					var2.field2645 = 0;
					var2.field2627 = var8;
					var2.field2647 = 0;
					var2.field2656 = var2.field2665;
				}
			}
			if ((var3 & 0x40) != 0) {
				var2.field2804 = NpcType.get(in.g2());
				var2.field2657 = var2.field2804.size;
				var2.field2661 = var2.field2804.turnspeed;
				var2.field2621 = var2.field2804.walkanim;
				var2.field2664 = var2.field2804.walkanim_b;
				var2.field2623 = var2.field2804.walkanim_r;
				var2.field2624 = var2.field2804.walkanim_l;
				var2.field2622 = var2.field2804.readyanim;
				var2.field2619 = var2.field2804.field2287;
				var2.field2620 = var2.field2804.field2278;
			}
			if ((var3 & 0x20) != 0) {
				var2.field2644 = in.gjstr();
				var2.field2634 = 100;
			}
			if ((var3 & 0x10) != 0) {
				int var10 = in.g1_alt3();
				int var11 = in.g1_alt3();
				var2.method2911(var10, var11, loopCycle);
				var2.field2635 = loopCycle + 300;
				var2.field2613 = in.g1_alt3();
				var2.field2636 = in.g1_alt1();
			}
		}
	}

	@ObfuscatedName("bs.ea(IIIII)V")
	public static final void method765(int arg0, int arg1, int arg2, int arg3) {
		for (int var4 = 0; var4 < field2121; var4++) {
			if (field2135[var4] + field2133[var4] > arg0 && field2133[var4] < arg0 + arg2 && field2136[var4] + field2007[var4] > arg1 && field2007[var4] < arg1 + arg3) {
				field2175[var4] = true;
			}
		}
	}

	@ObfuscatedName("bk.ep(B)V")
	public static final void showContextMenu() {
		int var0 = field704.method2882(EnglishLocale.field1028);
		for (int var1 = 0; var1 < menuSize; var1++) {
			int var2 = field704.method2882(method1239(var1));
			if (var2 > var0) {
				var0 = var2;
			}
		}
		var0 += 8;
		int var3 = menuSize * 15 + 21;
		int var4 = JavaMouseProvider.mouseClickX - var0 / 2;
		if (var0 + var4 > 765) {
			var4 = 765 - var0;
		}
		if (var4 < 0) {
			var4 = 0;
		}
		int var5 = JavaMouseProvider.mouseClickY;
		if (var3 + var5 > 503) {
			var5 = 503 - var3;
		}
		if (var5 < 0) {
			var5 = 0;
		}
		field2066 = true;
		field1161 = var4;
		field743 = var5;
		field535 = var0;
		field42 = menuSize * 15 + 22;
	}

	@ObfuscatedName("br.em(II)Z")
	public static final boolean isAddFriendOption(int arg0) {
		if (arg0 < 0) {
			return false;
		}
		int var1 = field2069[arg0];
		if (var1 >= 2000) {
			var1 -= 2000;
		}
		return var1 == 1007;
	}

	@ObfuscatedName("m.ey(II)V")
	public static final void useMenuOption(int arg0) {
		if (arg0 < 0) {
			return;
		}
		int var1 = field2067[arg0];
		int var2 = field2068[arg0];
		int var3 = field2069[arg0];
		int var4 = field2070[arg0];
		if (var3 >= 2000) {
			var3 -= 2000;
		}
		if (var3 == 45) {
			PlayerEntity var5 = players[var4];
			if (var5 != null) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var5.pathTileX[0], var5.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;
				out.pisaac1(146);
				out.p2(var4);
			}
		}
		if (var3 == 35) {
			out.pisaac1(76);
			out.p2_alt1(var1);
			out.p4_alt2(var2);
			out.p2_alt1(var4);
			selectedCycle = 0;
			selectedArea = IfType.get(var2);
			field2031 = var1;
		}
		if (var3 == 8) {
			NpcEntity var6 = npcs[var4];
			if (var6 != null) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var6.pathTileX[0], var6.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;
				out.pisaac1(190);
				out.p4(field43);
				out.p2_alt2(var4);
				out.p2_alt2(field2107);
			}
		}
		if (var3 == 51) {
			PlayerEntity var7 = players[var4];
			if (var7 != null) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var7.pathTileX[0], var7.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;
				out.pisaac1(145);
				out.p2_alt1(var4);
			}
		}
		if (var3 == 28) {
			out.pisaac1(155);
			out.p4(var2);
			IfType var8 = IfType.get(var2);
			if (var8.field1874 != null && var8.field1874[0][0] == 5) {
				int var9 = var8.field1874[0][1];
				VarProvider.field1210[var9] = 1 - VarProvider.field1210[var9];
				method778(var9);
			}
		}
		if (var3 == 1002) {
			field2026 = JavaMouseProvider.mouseClickX;
			field2027 = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;
			out.pisaac1(162);
			out.p2_alt2(var4 >> 14 & 0x7FFF);
		}
		if (var3 == 31) {
			out.pisaac1(70);
			out.p2_alt1(var4);
			out.p2_alt1(field555);
			out.p2(field557);
			out.p4(var2);
			out.p2_alt1(var1);
			out.p4_alt1(field502);
			selectedCycle = 0;
			selectedArea = IfType.get(var2);
			field2031 = var1;
		}
		if (var3 == 1004) {
			field2026 = JavaMouseProvider.mouseClickX;
			field2027 = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;
			out.pisaac1(49);
			out.p2_alt1(var4);
		}
		if (var3 == 47) {
			PlayerEntity var10 = players[var4];
			if (var10 != null) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var10.pathTileX[0], var10.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;
				out.pisaac1(78);
				out.p2(var4);
			}
		}
		if (var3 == 32) {
			out.pisaac1(218);
			out.p2_alt1(field2107);
			out.p2(var1);
			out.p2(var4);
			out.p4_alt2(var2);
			out.p4_alt2(field43);
			selectedCycle = 0;
			selectedArea = IfType.get(var2);
			field2031 = var1;
		}
		if (var3 == 46) {
			PlayerEntity var11 = players[var4];
			if (var11 != null) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var11.pathTileX[0], var11.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;
				out.pisaac1(102);
				out.p2_alt1(var4);
			}
		}
		if (var3 == 20) {
			boolean var12 = method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
			if (!var12) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
			}
			field2026 = JavaMouseProvider.mouseClickX;
			field2027 = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;
			out.pisaac1(224);
			out.p2_alt2(var4);
			out.p2_alt3(sceneBaseTileX + var1);
			out.p2_alt2(sceneBaseTileZ + var2);
		}
		if (var3 == 12) {
			NpcEntity var14 = npcs[var4];
			if (var14 != null) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var14.pathTileX[0], var14.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;
				out.pisaac1(95);
				out.p2_alt1(var4);
			}
		}
		if (var3 == 14) {
			PlayerEntity var15 = players[var4];
			if (var15 != null) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var15.pathTileX[0], var15.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;
				out.pisaac1(226);
				out.p2_alt2(field555);
				out.p2_alt1(field557);
				out.p2_alt2(var4);
				out.p4_alt2(field502);
			}
		}
		if (var3 == 2 && method1149(var1, var2, var4)) {
			out.pisaac1(247);
			out.p4_alt3(field43);
			out.p2(sceneBaseTileZ + var2);
			out.p2_alt1(field2107);
			out.p2_alt2(var4 >> 14 & 0x7FFF);
			out.p2_alt1(sceneBaseTileX + var1);
		}
		if (var3 == 41) {
			out.pisaac1(6);
			out.p2_alt1(var1);
			out.p4_alt1(var2);
			out.p2_alt3(var4);
			selectedCycle = 0;
			selectedArea = IfType.get(var2);
			field2031 = var1;
		}
		if (var3 == 50) {
			PlayerEntity var16 = players[var4];
			if (var16 != null) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var16.pathTileX[0], var16.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;
				out.pisaac1(119);
				out.p2_alt3(var4);
			}
		}
		if (var3 == 29) {
			out.pisaac1(155);
			out.p4(var2);
			IfType var17 = IfType.get(var2);
			if (var17.field1874 != null && var17.field1874[0][0] == 5) {
				int var18 = var17.field1874[0][1];
				if (VarProvider.field1210[var18] != var17.field1881[0]) {
					VarProvider.field1210[var18] = var17.field1881[0];
					method778(var18);
				}
			}
		}
		if (var3 == 48) {
			PlayerEntity var19 = players[var4];
			if (var19 != null) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var19.pathTileX[0], var19.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;
				out.pisaac1(117);
				out.p2_alt2(var4);
			}
		}
		if (var3 == 33) {
			out.pisaac1(135);
			out.p4_alt2(var2);
			out.p2_alt3(var4);
			out.p2_alt3(var1);
			selectedCycle = 0;
			selectedArea = IfType.get(var2);
			field2031 = var1;
		}
		if (var3 == 1 && method1149(var1, var2, var4)) {
			out.pisaac1(241);
			out.p4_alt1(field502);
			out.p2(field557);
			out.p2(var4 >> 14 & 0x7FFF);
			out.p2_alt2(sceneBaseTileX + var1);
			out.p2_alt1(field555);
			out.p2_alt2(sceneBaseTileZ + var2);
		}
		if (var3 == 6) {
			method1149(var1, var2, var4);
			out.pisaac1(83);
			out.p2_alt2(sceneBaseTileX + var1);
			out.p2_alt3(sceneBaseTileZ + var2);
			out.p2_alt3(var4 >> 14 & 0x7FFF);
		}
		if (var3 == 15) {
			PlayerEntity var20 = players[var4];
			if (var20 != null) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var20.pathTileX[0], var20.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;
				out.pisaac1(183);
				out.p2_alt2(field2107);
				out.p4(field43);
				out.p2_alt1(var4);
			}
		}
		if (var3 == 18) {
			boolean var21 = method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
			if (!var21) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
			}
			field2026 = JavaMouseProvider.mouseClickX;
			field2027 = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;
			out.pisaac1(243);
			out.p2_alt1(var4);
			out.p2(sceneBaseTileX + var1);
			out.p2_alt3(sceneBaseTileZ + var2);
		}
		if (var3 == 5) {
			method1149(var1, var2, var4);
			out.pisaac1(133);
			out.p2_alt2(sceneBaseTileX + var1);
			out.p2_alt2(sceneBaseTileZ + var2);
			out.p2_alt3(var4 >> 14 & 0x7FFF);
		}
		if (var3 == 16) {
			boolean var23 = method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
			if (!var23) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
			}
			field2026 = JavaMouseProvider.mouseClickX;
			field2027 = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;
			out.pisaac1(235);
			out.p2(sceneBaseTileZ + var2);
			out.p2_alt2(field555);
			out.p2_alt1(sceneBaseTileX + var1);
			out.p4(field502);
			out.p2_alt1(var4);
			out.p2_alt1(field557);
		}
		if (var3 == 1001) {
			method1149(var1, var2, var4);
			out.pisaac1(56);
			out.p2(sceneBaseTileX + var1);
			out.p2_alt1(var4 >> 14 & 0x7FFF);
			out.p2_alt2(sceneBaseTileZ + var2);
		}
		if (var3 == 26) {
			out.pisaac1(129);
			for (ComponentPointer var25 = (ComponentPointer) field1918.method1284(); var25 != null; var25 = (ComponentPointer) field1918.method1280()) {
				if (var25.field1597 == 0 || var25.field1597 == 3) {
					method408(var25, true);
				}
			}
			if (field2087 != null) {
				method1238(field2087);
				field2087 = null;
			}
		}
		if (var3 == 37) {
			out.pisaac1(19);
			out.p2(var4);
			out.p4(var2);
			out.p2_alt2(var1);
			selectedCycle = 0;
			selectedArea = IfType.get(var2);
			field2031 = var1;
		}
		if (var3 == 57 || var3 == 1007) {
			method949(var4, var2, var1, field2072[arg0]);
		}
		if (var3 == 44) {
			PlayerEntity var26 = players[var4];
			if (var26 != null) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var26.pathTileX[0], var26.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;
				out.pisaac1(246);
				out.p2(var4);
			}
		}
		if (var3 == 22) {
			boolean var27 = method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
			if (!var27) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
			}
			field2026 = JavaMouseProvider.mouseClickX;
			field2027 = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;
			out.pisaac1(77);
			out.p2(sceneBaseTileX + var1);
			out.p2_alt2(sceneBaseTileZ + var2);
			out.p2_alt3(var4);
		}
		if (var3 == 24) {
			IfType var29 = IfType.get(var2);
			boolean var30 = true;
			if (var29.clientCode > 0) {
				var30 = method1580(var29);
			}
			if (var30) {
				out.pisaac1(155);
				out.p4(var2);
			}
		}
		if (var3 == 9) {
			NpcEntity var31 = npcs[var4];
			if (var31 != null) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var31.pathTileX[0], var31.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;
				out.pisaac1(84);
				out.p2_alt3(var4);
			}
		}
		if (var3 == 49) {
			PlayerEntity var32 = players[var4];
			if (var32 != null) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var32.pathTileX[0], var32.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;
				out.pisaac1(111);
				out.p2_alt3(var4);
			}
		}
		if (var3 == 25) {
			IfType var33 = IfType.method947(var2, var1);
			if (var33 != null) {
				method913();
				int var34 = WorldEntrySettings.method1350(method1512(var33));
				IfType var35 = IfType.method947(var2, var1);
				if (var35 != null && var35.field1861 != null) {
					HookRequest var36 = new HookRequest();
					var36.component = var35;
					var36.field1588 = var35.field1861;
					ScriptRunner.runHook(var36);
				}
				field2079 = true;
				field43 = var2;
				field2107 = var1;
				field386 = var34;
				method1238(var35);
				field2077 = 0;
				String var37;
				if (WorldEntrySettings.method1350(method1512(var33)) == 0) {
					var37 = null;
				} else if (var33.field1841 == null || var33.field1841.trim().length() == 0) {
					var37 = null;
				} else {
					var37 = var33.field1841;
				}
				field2048 = var37;
				if (field2048 == null) {
					field2048 = "Null";
				}
				if (var33.field1782) {
					field2082 = var33.field1795 + TextUtil.colTag(16777215);
				} else {
					field2082 = TextUtil.colTag(65280) + var33.field1883 + TextUtil.colTag(16777215);
				}
			}
			return;
		}
		if (var3 == 42) {
			out.pisaac1(186);
			out.p2(var1);
			out.p4(var2);
			out.p2(var4);
			selectedCycle = 0;
			selectedArea = IfType.get(var2);
			field2031 = var1;
		}
		if (var3 == 10) {
			NpcEntity var38 = npcs[var4];
			if (var38 != null) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var38.pathTileX[0], var38.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;
				out.pisaac1(13);
				out.p2_alt2(var4);
			}
		}
		if (var3 == 34) {
			out.pisaac1(179);
			out.p2_alt3(var1);
			out.p2_alt2(var4);
			out.p4_alt1(var2);
			selectedCycle = 0;
			selectedArea = IfType.get(var2);
			field2031 = var1;
		}
		if (var3 == 43) {
			out.pisaac1(40);
			out.p2_alt1(var4);
			out.p4_alt1(var2);
			out.p2_alt2(var1);
			selectedCycle = 0;
			selectedArea = IfType.get(var2);
			field2031 = var1;
		}
		if (var3 == 1003) {
			field2026 = JavaMouseProvider.mouseClickX;
			field2027 = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;
			NpcEntity var39 = npcs[var4];
			if (var39 != null) {
				NpcType var40 = var39.field2804;
				if (var40.multinpc != null) {
					var40 = var40.method2332();
				}
				if (var40 != null) {
					out.pisaac1(52);
					out.p2(var40.field2271);
				}
			}
		}
		if (var3 == 13) {
			NpcEntity var41 = npcs[var4];
			if (var41 != null) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var41.pathTileX[0], var41.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;
				out.pisaac1(88);
				out.p2(var4);
			}
		}
		if (var3 == 11) {
			NpcEntity var42 = npcs[var4];
			if (var42 != null) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var42.pathTileX[0], var42.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;
				out.pisaac1(67);
				out.p2_alt1(var4);
			}
		}
		if (var3 == 17) {
			boolean var43 = method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
			if (!var43) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
			}
			field2026 = JavaMouseProvider.mouseClickX;
			field2027 = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;
			out.pisaac1(81);
			out.p2_alt3(var4);
			out.p2(sceneBaseTileZ + var2);
			out.p4_alt3(field43);
			out.p2_alt2(sceneBaseTileX + var1);
			out.p2_alt2(field2107);
		}
		if (var3 == 3) {
			method1149(var1, var2, var4);
			out.pisaac1(73);
			out.p2_alt2(var4 >> 14 & 0x7FFF);
			out.p2(sceneBaseTileX + var1);
			out.p2(sceneBaseTileZ + var2);
		}
		if (var3 == 38) {
			method913();
			IfType var45 = IfType.get(var2);
			field2077 = 1;
			field557 = var1;
			field502 = var2;
			field555 = var4;
			method1238(var45);
			field2078 = TextUtil.colTag(16748608) + ObjType.get(var4).name + TextUtil.colTag(16777215);
			if (field2078 == null) {
				field2078 = "null";
			}
			return;
		}
		if (var3 == 58) {
			out.pisaac1(251);
			out.p2_alt2(field2107);
			out.p2_alt2(var1);
			out.p4(field43);
			out.p4_alt2(var2);
		}
		if (var3 == 30 && field2087 == null) {
			out.pisaac1(242);
			out.p2_alt2(var1);
			out.p4(var2);
			field2087 = IfType.method947(var2, var1);
			method1238(field2087);
		}
		if (var3 == 23) {
			field1133.method601(currentLevel, var1, var2);
		}
		if (var3 == 4) {
			method1149(var1, var2, var4);
			out.pisaac1(90);
			out.p2_alt3(sceneBaseTileZ + var2);
			out.p2_alt3(sceneBaseTileX + var1);
			out.p2_alt2(var4 >> 14 & 0x7FFF);
		}
		if (var3 == 36) {
			out.pisaac1(220);
			out.p4_alt3(var2);
			out.p2_alt2(var1);
			out.p2_alt1(var4);
			selectedCycle = 0;
			selectedArea = IfType.get(var2);
			field2031 = var1;
		}
		if (var3 == 19) {
			boolean var46 = method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
			if (!var46) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
			}
			field2026 = JavaMouseProvider.mouseClickX;
			field2027 = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;
			out.pisaac1(177);
			out.p2(sceneBaseTileZ + var2);
			out.p2_alt3(var4);
			out.p2(sceneBaseTileX + var1);
		}
		if (var3 == 40) {
			out.pisaac1(202);
			out.p2_alt1(var4);
			out.p4_alt2(var2);
			out.p2_alt1(var1);
			selectedCycle = 0;
			selectedArea = IfType.get(var2);
			field2031 = var1;
		}
		if (var3 == 1005) {
			IfType var48 = IfType.get(var2);
			if (var48 == null || var48.invSlotObjCount[var1] < 100000) {
				out.pisaac1(49);
				out.p2_alt1(var4);
			} else {
				method559(0, "", var48.invSlotObjCount[var1] + " x " + ObjType.get(var4).name);
			}
			selectedCycle = 0;
			selectedArea = IfType.get(var2);
			field2031 = var1;
		}
		if (var3 == 7) {
			NpcEntity var49 = npcs[var4];
			if (var49 != null) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var49.pathTileX[0], var49.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;
				out.pisaac1(106);
				out.p2_alt2(field557);
				out.p4(field502);
				out.p2_alt1(var4);
				out.p2_alt3(field555);
			}
		}
		if (var3 == 21) {
			boolean var50 = method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var1, var2, false, 0, 0, 0, 0, 0, 2);
			if (!var50) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var1, var2, false, 0, 0, 1, 1, 0, 2);
			}
			field2026 = JavaMouseProvider.mouseClickX;
			field2027 = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;
			out.pisaac1(139);
			out.p2_alt1(sceneBaseTileZ + var2);
			out.p2_alt1(sceneBaseTileX + var1);
			out.p2_alt3(var4);
		}
		if (var3 == 39) {
			out.pisaac1(21);
			out.p2(var1);
			out.p4_alt2(var2);
			out.p2_alt1(var4);
			selectedCycle = 0;
			selectedArea = IfType.get(var2);
			field2031 = var1;
		}
		if (field2077 != 0) {
			field2077 = 0;
			method1238(IfType.get(field502));
		}
		if (field2079) {
			method913();
		}
		if (selectedArea != null && selectedCycle == 0) {
			method1238(selectedArea);
		}
	}

	@ObfuscatedName("ao.ec(ILjava/lang/String;I)V")
	public static void method558(int arg0, String arg1) {
		String var2 = JString.method762(arg1);
		String var3 = JString.method782(JString.method1001(var2));
		if (var3 == null) {
			var3 = "";
		}
		String var5 = var3;
		boolean var6 = false;
		for (int var7 = 0; var7 < playerCount; var7++) {
			PlayerEntity var8 = players[playerIds[var7]];
			if (var8 != null && var8.field2796 != null && var8.field2796.equalsIgnoreCase(var5)) {
				method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var8.pathTileX[0], var8.pathTileZ[0], false, 0, 0, 1, 1, 0, 2);
				if (arg0 == 1) {
					out.pisaac1(246);
					out.p2(playerIds[var7]);
				} else if (arg0 == 4) {
					out.pisaac1(78);
					out.p2(playerIds[var7]);
				} else if (arg0 == 6) {
					out.pisaac1(111);
					out.p2_alt3(playerIds[var7]);
				} else if (arg0 == 7) {
					out.pisaac1(119);
					out.p2_alt3(playerIds[var7]);
				}
				var6 = true;
				break;
			}
		}
		if (!var6) {
			method559(0, "", EnglishLocale.field1004 + var5);
		}
	}

	@ObfuscatedName("ba.eo(B)V")
	public static void method913() {
		if (!field2079) {
			return;
		}
		IfType var0 = IfType.method947(field43, field2107);
		if (var0 != null && var0.field1836 != null) {
			HookRequest var1 = new HookRequest();
			var1.component = var0;
			var1.field1588 = var0.field1836;
			ScriptRunner.runHook(var1);
		}
		field2079 = false;
		method1238(var0);
	}

	@ObfuscatedName("bd.eu(IIILjava/lang/String;I)V")
	public static void method949(int arg0, int arg1, int arg2, String arg3) {
		IfType var4 = IfType.method947(arg1, arg2);
		if (var4 == null) {
			return;
		}
		if (var4.field1847 != null) {
			HookRequest var5 = new HookRequest();
			var5.component = var4;
			var5.field1591 = arg0;
			var5.field1595 = arg3;
			var5.field1588 = var4.field1847;
			ScriptRunner.runHook(var5);
		}
		boolean var6 = true;
		if (var4.clientCode > 0) {
			var6 = method1580(var4);
		}
		if (!var6) {
			return;
		}
		int var7 = method1512(var4);
		int var8 = arg0 - 1;
		boolean var9 = (var7 >> var8 + 1 & 0x1) != 0;
		if (!var9) {
			return;
		}
		if (arg0 == 1) {
			out.pisaac1(63);
			out.p4(arg1);
			out.p2(arg2);
		}
		if (arg0 == 2) {
			out.pisaac1(87);
			out.p4(arg1);
			out.p2(arg2);
		}
		if (arg0 == 3) {
			out.pisaac1(238);
			out.p4(arg1);
			out.p2(arg2);
		}
		if (arg0 == 4) {
			out.pisaac1(240);
			out.p4(arg1);
			out.p2(arg2);
		}
		if (arg0 == 5) {
			out.pisaac1(153);
			out.p4(arg1);
			out.p2(arg2);
		}
		if (arg0 == 6) {
			out.pisaac1(232);
			out.p4(arg1);
			out.p2(arg2);
		}
		if (arg0 == 7) {
			out.pisaac1(168);
			out.p4(arg1);
			out.p2(arg2);
		}
		if (arg0 == 8) {
			out.pisaac1(239);
			out.p4(arg1);
			out.p2(arg2);
		}
		if (arg0 == 9) {
			out.pisaac1(254);
			out.p4(arg1);
			out.p2(arg2);
		}
		if (arg0 == 10) {
			out.pisaac1(169);
			out.p4(arg1);
			out.p2(arg2);
		}
	}

	@ObfuscatedName("d.fd(Ljava/lang/String;Ljava/lang/String;IIIII)V")
	public static final void method8(String arg0, String arg1, int arg2, int arg3, int arg4, int arg5) {
		if (field2066 || menuSize >= 500) {
			return;
		}
		field1994[menuSize] = arg0;
		field2072[menuSize] = arg1;
		field2069[menuSize] = arg2;
		field2070[menuSize] = arg3;
		field2067[menuSize] = arg4;
		field2068[menuSize] = arg5;
		menuSize++;
	}

	@ObfuscatedName("cq.fb(IS)Ljava/lang/String;")
	public static String method1239(int arg0) {
		return field2072[arg0].length() > 0 ? field1994[arg0] + EnglishLocale.field1015 + field2072[arg0] : field1994[arg0];
	}

	@ObfuscatedName("z.fc(Lem;IIII)V")
	public static final void method64(NpcType arg0, int arg1, int arg2, int arg3) {
		if (menuSize >= 400) {
			return;
		}
		if (arg0.multinpc != null) {
			arg0 = arg0.method2332();
		}
		if (arg0 == null || !arg0.active) {
			return;
		}
		String var4 = arg0.name;
		if (arg0.vislevel != 0) {
			int var6 = arg0.vislevel;
			int var7 = localPlayer.field2789;
			int var8 = var7 - var6;
			String var9;
			if (var8 < -9) {
				var9 = TextUtil.colTag(16711680);
			} else if (var8 < -6) {
				var9 = TextUtil.colTag(16723968);
			} else if (var8 < -3) {
				var9 = TextUtil.colTag(16740352);
			} else if (var8 < 0) {
				var9 = TextUtil.colTag(16756736);
			} else if (var8 > 9) {
				var9 = TextUtil.colTag(65280);
			} else if (var8 > 6) {
				var9 = TextUtil.colTag(4259584);
			} else if (var8 > 3) {
				var9 = TextUtil.colTag(8453888);
			} else if (var8 > 0) {
				var9 = TextUtil.colTag(12648192);
			} else {
				var9 = TextUtil.colTag(16776960);
			}
			var4 = var4 + var9 + " " + TextUtil.openParen + EnglishLocale.field1011 + arg0.vislevel + TextUtil.closeParen;
		}
		if (field2077 == 1) {
			method8(EnglishLocale.field1005, field2078 + " " + TextUtil.arrow + " " + TextUtil.colTag(16776960) + var4, 7, arg1, arg2, arg3);
		} else if (!field2079) {
			String[] var10 = arg0.op;
			if (field2001) {
				var10 = method726(var10);
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
						method8(var10[var11], TextUtil.colTag(16776960) + var4, var12, arg1, arg2, arg3);
					}
				}
			}
			if (var10 != null) {
				for (int var13 = 4; var13 >= 0; var13--) {
					if (var10[var13] != null && var10[var13].equalsIgnoreCase(EnglishLocale.field902)) {
						short var14 = 0;
						if (arg0.vislevel > localPlayer.field2789) {
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
						method8(var10[var13], TextUtil.colTag(16776960) + var4, var15, arg1, arg2, arg3);
					}
				}
			}
			method8(EnglishLocale.field1075, TextUtil.colTag(16776960) + var4, 1003, arg1, arg2, arg3);
		} else if ((field386 & 0x2) == 2) {
			method8(field2048, field2082 + " " + TextUtil.arrow + " " + TextUtil.colTag(16776960) + var4, 8, arg1, arg2, arg3);
		}
	}

	@ObfuscatedName("cr.fe(Lfi;IIII)V")
	public static final void method950(PlayerEntity arg0, int arg1, int arg2, int arg3) {
		if (localPlayer == arg0 || menuSize >= 400) {
			return;
		}
		String var9;
		if (arg0.field2790 == 0) {
			String var4 = arg0.field2796;
			int var5 = arg0.field2789;
			int var6 = localPlayer.field2789;
			int var7 = var6 - var5;
			String var8;
			if (var7 < -9) {
				var8 = TextUtil.colTag(16711680);
			} else if (var7 < -6) {
				var8 = TextUtil.colTag(16723968);
			} else if (var7 < -3) {
				var8 = TextUtil.colTag(16740352);
			} else if (var7 < 0) {
				var8 = TextUtil.colTag(16756736);
			} else if (var7 > 9) {
				var8 = TextUtil.colTag(65280);
			} else if (var7 > 6) {
				var8 = TextUtil.colTag(4259584);
			} else if (var7 > 3) {
				var8 = TextUtil.colTag(8453888);
			} else if (var7 > 0) {
				var8 = TextUtil.colTag(12648192);
			} else {
				var8 = TextUtil.colTag(16776960);
			}
			var9 = var4 + var8 + " " + TextUtil.openParen + EnglishLocale.field1011 + arg0.field2789 + TextUtil.closeParen;
		} else {
			var9 = arg0.field2796 + " " + TextUtil.openParen + EnglishLocale.field879 + arg0.field2790 + TextUtil.closeParen;
		}
		if (field2077 == 1) {
			method8(EnglishLocale.field1005, field2078 + " " + TextUtil.arrow + " " + TextUtil.colTag(16777215) + var9, 14, arg1, arg2, arg3);
		} else if (!field2079) {
			for (int var10 = 7; var10 >= 0; var10--) {
				if (field2053[var10] != null) {
					short var11 = 0;
					if (field2053[var10].equalsIgnoreCase(EnglishLocale.field902)) {
						if (arg0.field2789 > localPlayer.field2789) {
							var11 = 2000;
						}
						if (localPlayer.field2803 != 0 && arg0.field2803 != 0) {
							if (localPlayer.field2803 == arg0.field2803) {
								var11 = 2000;
							} else {
								var11 = 0;
							}
						}
					} else if (field2054[var10]) {
						var11 = 2000;
					}
					boolean var12 = false;
					int var13 = field2052[var10] + var11;
					method8(field2053[var10], TextUtil.colTag(16777215) + var9, var13, arg1, arg2, arg3);
				}
			}
		} else if ((field386 & 0x8) == 8) {
			method8(field2048, field2082 + " " + TextUtil.arrow + " " + TextUtil.colTag(16777215) + var9, 15, arg1, arg2, arg3);
		}
		for (int var14 = 0; var14 < menuSize; var14++) {
			if (field2069[var14] == 23) {
				field2072[var14] = TextUtil.colTag(16777215) + var9;
				break;
			}
		}
	}

	@ObfuscatedName("fg.fj(IIIIIIIII)V")
	public static final void method2581(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		if (IfType.method1501(arg0)) {
			field1516 = null;
			method92(IfType.field373[arg0], -1, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
			if (field1516 != null) {
				method92(field1516, 0xabcdabcd, arg1, arg2, arg3, arg4, field44, field2106, arg7);
				field1516 = null;
			}
		} else if (arg7 == -1) {
			for (int var8 = 0; var8 < 100; var8++) {
				field2175[var8] = true;
			}
		} else {
			field2175[arg7] = true;
		}
	}

	@ObfuscatedName("g.fv([Leg;IIIIIIIIB)V")
	public static final void method92(IfType[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
		Pix2D.method2605(arg2, arg3, arg4, arg5);
		Pix3D.method2808();
		for (int var9 = 0; var9 < arg0.length; var9++) {
			IfType var10 = arg0[var9];
            if (var10 == null || (var10.layerid != arg1 && (arg1 != 0xabcdabcd || field2094 != var10))) {
                continue;
            }
            int var11;
            if (arg8 == -1) {
                field2133[field2121] = var10.field1788 + arg6;
                field2007[field2121] = var10.field1810 + arg7;
                field2135[field2121] = var10.field1792;
                field2136[field2121] = var10.field1793;
                var11 = ++field2121 - 1;
            } else {
                var11 = arg8;
            }
            var10.field1898 = var11;
            var10.field1899 = loopCycle;
            if (var10.field1782 && method868(var10)) {
                continue;
            }
            if (var10.clientCode > 0) {
                method1236(var10);
            }
            int var12 = var10.field1788 + arg6;
            int var13 = var10.field1810 + arg7;
            int var14 = var10.field1805;
            if (field2094 == var10) {
                if (arg1 != 0xabcdabcd && !var10.field1858) {
                    field1516 = arg0;
                    field44 = arg6;
                    field2106 = arg7;
                    continue;
                }
                if (field1927 && field2126) {
                    int var15 = JavaMouseProvider.mouseX;
                    int var16 = JavaMouseProvider.mouseY;
                    int var17 = var15 - field2115;
                    int var18 = var16 - field2097;
                    if (var17 < field2183) {
                        var17 = field2183;
                    }
                    if (var10.field1792 + var17 > field2183 + field2162.field1792) {
                        var17 = field2183 + field2162.field1792 - var10.field1792;
                    }
                    if (var18 < field2101) {
                        var18 = field2101;
                    }
                    if (var10.field1793 + var18 > field2101 + field2162.field1793) {
                        var18 = field2101 + field2162.field1793 - var10.field1793;
                    }
                    var12 = var17;
                    var13 = var18;
                }
                if (!var10.field1858) {
                    var14 = 128;
                }
            }
            int var19;
            int var20;
            int var21;
            int var22;
            if (var10.field1785 == 2) {
                var19 = arg2;
                var20 = arg3;
                var21 = arg4;
                var22 = arg5;
            } else if (var10.field1785 == 9) {
                int var23 = var12;
                int var24 = var13;
                int var25 = var10.field1792 + var12;
                int var26 = var10.field1793 + var13;
                if (var25 < var12) {
                    var23 = var25;
                    var25 = var12;
                }
                if (var26 < var13) {
                    var24 = var26;
                    var26 = var13;
                }
                var25++;
                var26++;
                var19 = var23 > arg2 ? var23 : arg2;
                var20 = var24 > arg3 ? var24 : arg3;
                var21 = var25 < arg4 ? var25 : arg4;
                var22 = var26 < arg5 ? var26 : arg5;
            } else {
                int var29 = var10.field1792 + var12;
                int var30 = var10.field1793 + var13;
                var19 = var12 > arg2 ? var12 : arg2;
                var20 = var13 > arg3 ? var13 : arg3;
                var21 = var29 < arg4 ? var29 : arg4;
                var22 = var30 < arg5 ? var30 : arg5;
            }
            if (var10.field1782 && (var19 >= var21 || var20 >= var22)) {
                continue;
            }
            if (var10.clientCode != 0) {
                if (var10.clientCode == 1337) {
                    field1971 = var12;
                    field1976 = var13;
                    imethod34(var12, var13, var10.field1792, var10.field1793);
                    Pix2D.method2605(arg2, arg3, arg4, arg5);
                    continue;
                }
                if (var10.clientCode == 1338) {
                    method915(var12, var13, var11);
                    Pix2D.method2605(arg2, arg3, arg4, arg5);
                    continue;
                }
            }
            int var127 = JavaMouseProvider.mouseX;
            int var128 = JavaMouseProvider.mouseY;
            if (!field2066 && var127 >= var19 && var128 >= var20 && var127 < var21 && var128 < var22) {
                imethod35(var10, var127 - var12, var128 - var13);
            }
            if (var10.field1785 == 0) {
                if (!var10.field1782 && method868(var10) && field37 != var10) {
                    continue;
                }
                if (!var10.field1782) {
                    if (var10.field1797 > var10.field1799 - var10.field1793) {
                        var10.field1797 = var10.field1799 - var10.field1793;
                    }
                    if (var10.field1797 < 0) {
                        var10.field1797 = 0;
                    }
                }
                method92(arg0, var10.field1783, var19, var20, var21, var22, var12 - var10.field1796, var13 - var10.field1797, var11);
                if (var10.subcomponents != null) {
                    method92(var10.subcomponents, var10.field1783, var19, var20, var21, var22, var12 - var10.field1796, var13 - var10.field1797, var11);
                }
                ComponentPointer var164 = (ComponentPointer) field1918.get((long) var10.field1783);
                if (var164 != null) {
                    if (var164.field1597 == 0 && JavaMouseProvider.mouseX >= var19 && JavaMouseProvider.mouseY >= var20 && JavaMouseProvider.mouseX < var21 && JavaMouseProvider.mouseY < var22 && !field2066 && !field2092) {
                        field1994[0] = EnglishLocale.field1078;
                        field2072[0] = "";
                        field2069[0] = 1006;
                        menuSize = 1;
                    }
                    method2581(var164.field1598, var19, var20, var21, var22, var12, var13, var11);
                }
                Pix2D.method2605(arg2, arg3, arg4, arg5);
                Pix3D.method2808();
            }
            if (!field2132[var11] && field2137 <= 1) {
                continue;
            }
            if (var10.field1785 == 0 && !var10.field1782 && var10.field1799 > var10.field1793) {
                imethod36(var13, var10.field1792 + var12, var10.field1797, var10.field1793, var10.field1799);
            } else if (var10.field1785 == 1) {
				// no-op
            } else if (var10.field1785 == 2) {
                int var171 = 0;
                for (int var172 = 0; var172 < var10.field1793; var172++) {
                    for (int var173 = 0; var173 < var10.field1792; var173++) {
                        int var174 = (var10.field1843 + 32) * var173 + var12;
                        int var175 = (var10.field1837 + 32) * var172 + var13;
                        if (var171 < 20) {
                            var174 += var10.field1854[var171];
                            var175 += var10.field1862[var171];
                        }
                        if (var10.invSlotObjId[var171] > 0) {
                            int var178 = var10.invSlotObjId[var171] - 1;
                            if (var174 + 32 > arg2 && var174 < arg4 && var175 + 32 > arg3 && var175 < arg5 || objDragInterface == var10 && hoveredSlot == var171) {
                                Pix32 var179;
                                if (field2077 == 1 && field557 == var171 && field502 == var10.field1783) {
                                    var179 = ObjType.method1837(var178, var10.invSlotObjCount[var171], 2, 0, false);
                                } else {
                                    var179 = ObjType.method1837(var178, var10.invSlotObjCount[var171], 1, 3153952, false);
                                }
                                if (var179 == null) {
                                    method1238(var10);
                                } else if (objDragInterface == var10 && hoveredSlot == var171) {
                                    int var180 = JavaMouseProvider.mouseX - objGrabX;
                                    int var181 = JavaMouseProvider.mouseY - objGrabY;
                                    if (var180 < 5 && var180 > -5) {
                                        var180 = 0;
                                    }
                                    if (var181 < 5 && var181 > -5) {
                                        var181 = 0;
                                    }
                                    if (objDragCycles < 5) {
                                        var180 = 0;
                                        var181 = 0;
                                    }
                                    var179.method2676(var174 + var180, var175 + var181, 128);
                                    if (arg1 != -1) {
                                        IfType var182 = arg0[arg1 & 0xFFFF];
                                        if (var175 + var181 < Pix2D.top && var182.field1797 > 0) {
                                            int var183 = sceneDelta * (Pix2D.top - var175 - var181) / 3;
                                            if (var183 > sceneDelta * 10) {
                                                var183 = sceneDelta * 10;
                                            }
                                            if (var183 > var182.field1797) {
                                                var183 = var182.field1797;
                                            }
                                            var182.field1797 -= var183;
                                            objGrabY += var183;
                                            method1238(var182);
                                        }
                                        if (var175 + var181 + 32 > Pix2D.bottom && var182.field1797 < var182.field1799 - var182.field1793) {
                                            int var184 = sceneDelta * (var175 + var181 + 32 - Pix2D.bottom) / 3;
                                            if (var184 > sceneDelta * 10) {
                                                var184 = sceneDelta * 10;
                                            }
                                            if (var184 > var182.field1799 - var182.field1793 - var182.field1797) {
                                                var184 = var182.field1799 - var182.field1793 - var182.field1797;
                                            }
                                            var182.field1797 += var184;
                                            objGrabY -= var184;
                                            method1238(var182);
                                        }
                                    }
                                } else if (selectedArea == var10 && field2031 == var171) {
                                    var179.method2676(var174, var175, 128);
                                } else {
                                    var179.method2671(var174, var175);
                                }
                            }
                        } else if (var10.field1840 != null && var171 < 20) {
                            Pix32 var185 = var10.method1803(var171);
                            if (var185 != null) {
                                var185.method2671(var174, var175);
                            } else if (IfType.field1870) {
                                method1238(var10);
                            }
                        }
                        var171++;
                    }
                }
            } else if (var10.field1785 == 3) {
                int var186;
                if (method56(var10)) {
                    var186 = var10.field1801;
                    if (field37 == var10 && var10.field1803 != 0) {
                        var186 = var10.field1803;
                    }
                } else {
                    var186 = var10.field1822;
                    if (field37 == var10 && var10.field1802 != 0) {
                        var186 = var10.field1802;
                    }
                }
                if (var14 == 0) {
                    if (var10.field1893) {
                        Pix2D.method2637(var12, var13, var10.field1792, var10.field1793, var186);
                    } else {
                        Pix2D.method2639(var12, var13, var10.field1792, var10.field1793, var186);
                    }
                } else if (var10.field1893) {
                    Pix2D.method2616(var12, var13, var10.field1792, var10.field1793, var186, 256 - (var14 & 0xFF));
                } else {
                    Pix2D.method2582(var12, var13, var10.field1792, var10.field1793, var186, 256 - (var14 & 0xFF));
                }
            } else if (var10.field1785 == 4) {
                SoftwareFont var187 = var10.method1800();
                if (var187 != null) {
                    String var188 = var10.field1830;
                    int var189;
                    if (method56(var10)) {
                        var189 = var10.field1801;
                        if (field37 == var10 && var10.field1803 != 0) {
                            var189 = var10.field1803;
                        }
                        if (var10.field1809.length() > 0) {
                            var188 = var10.field1809;
                        }
                    } else {
                        var189 = var10.field1822;
                        if (field37 == var10 && var10.field1802 != 0) {
                            var189 = var10.field1802;
                        }
                    }
                    if (var10.field1782 && var10.field1791 != -1) {
                        ObjType var190 = ObjType.get(var10.field1791);
                        var188 = var190.name;
                        if (var188 == null) {
                            var188 = "null";
                        }
                        if ((var190.stackable == 1 || var10.field1888 != 1) && var10.field1888 != -1) {
                            var188 = TextUtil.colTag(16748608) + var188 + TextUtil.colEnd + " " + 'x' + method1488(var10.field1888);
                        }
                    }
                    if (field2087 == var10) {
                        EnglishLocale var10000 = null;
                        var188 = EnglishLocale.field1086;
                        var189 = var10.field1822;
                    }
                    if (!var10.field1782) {
                        var188 = method1583(var188, var10);
                    }
                    var187.method2824(var188, var12, var13, var10.field1792, var10.field1793, var189, var10.field1835 ? 0 : -1, var10.field1864, var10.field1834, var10.field1832);
                } else if (IfType.field1870) {
                    method1238(var10);
                }
            } else if (var10.field1785 == 5) {
                if (var10.field1782) {
                    Pix32 var192;
                    if (var10.field1791 == -1) {
                        var192 = var10.method1827(false);
                    } else {
                        var192 = ObjType.method1837(var10.field1791, var10.field1888, var10.field1811, var10.field1812, false);
                    }
                    if (var192 != null) {
                        int var193 = var192.field2504;
                        int var194 = var192.field2505;
                        if (var10.field1794) {
                            Pix2D.method2586(var12, var13, var10.field1792 + var12, var10.field1793 + var13);
                            int var195 = (var10.field1792 + (var193 - 1)) / var193;
                            int var196 = (var10.field1793 + (var194 - 1)) / var194;
                            for (int var197 = 0; var197 < var195; var197++) {
                                for (int var198 = 0; var198 < var196; var198++) {
                                    if (var10.field1784 != 0) {
                                        var192.method2685(var193 / 2 + var193 * var197 + var12, var194 / 2 + var194 * var198 + var13, var10.field1784, 4096);
                                    } else if (var14 == 0) {
                                        var192.method2671(var193 * var197 + var12, var194 * var198 + var13);
                                    } else {
                                        var192.method2676(var193 * var197 + var12, var194 * var198 + var13, 256 - (var14 & 0xFF));
                                    }
                                }
                            }
                            Pix2D.method2605(arg2, arg3, arg4, arg5);
                        } else {
                            int var199 = var10.field1792 * 4096 / var193;
                            if (var10.field1784 != 0) {
                                var192.method2685(var10.field1792 / 2 + var12, var10.field1793 / 2 + var13, var10.field1784, var199);
                            } else if (var14 != 0) {
                                var192.method2678(var12, var13, var10.field1792, var10.field1793, 256 - (var14 & 0xFF));
                            } else if (var10.field1792 == var193 && var10.field1793 == var194) {
                                var192.method2671(var12, var13);
                            } else {
                                var192.method2664(var12, var13, var10.field1792, var10.field1793);
                            }
                        }
                    } else if (IfType.field1870) {
                        method1238(var10);
                    }
                } else {
                    Pix32 var191 = var10.method1827(method56(var10));
                    if (var191 != null) {
                        var191.method2671(var12, var13);
                    } else if (IfType.field1870) {
                        method1238(var10);
                    }
                }
            } else if (var10.field1785 == 6) {
                boolean var200 = method56(var10);
                int var201;
                if (var200) {
                    var201 = var10.field1820;
                } else {
                    var201 = var10.field1863;
                }
                SoftwareModel var202 = null;
                int var203 = 0;
                if (var10.field1791 != -1) {
                    ObjType var204 = ObjType.get(var10.field1791);
                    if (var204 != null) {
                        ObjType var205 = var204.method2523(var10.field1888);
                        var202 = var205.method2532(1);
                        if (var202 == null) {
                            method1238(var10);
                        } else {
                            var202.method3002();
                            var203 = var202.field2487 / 2;
                        }
                    }
                } else if (var10.field1815 == 5) {
                    if (var10.field1816 == 0) {
                        var202 = field2197.method1174(null, -1, null, -1);
                    } else {
                        var202 = localPlayer.method2643();
                    }
                } else if (var201 == -1) {
                    var202 = var10.method1802(null, -1, var200, localPlayer.field2786);
                    if (var202 == null && IfType.field1870) {
                        method1238(var10);
                    }
                } else {
                    SeqType var206 = SeqType.get(var201);
                    var202 = var10.method1802(var206, var10.field1779, var200, localPlayer.field2786);
                    if (var202 == null && IfType.field1870) {
                        method1238(var10);
                    }
                }
                Pix3D.method2784(var10.field1792 / 2 + var12, var10.field1793 / 2 + var13);
                int var207 = var10.field1826 * Pix3D.sinTable[var10.field1848] >> 16;
                int var208 = var10.field1826 * Pix3D.cosTable[var10.field1848] >> 16;
                if (var202 != null) {
                    if (var10.field1782) {
                        var202.method3002();
                        if (var10.field1828) {
                            var202.method3020(0, var10.field1824, var10.field1817, var10.field1848, var10.field1821, var10.field1798 + var203 + var207, var10.field1798 + var208, var10.field1826);
                        } else {
                            var202.method3014(0, var10.field1824, var10.field1817, var10.field1848, var10.field1821, var10.field1798 + var203 + var207, var10.field1798 + var208);
                        }
                    } else {
                        var202.method3014(0, var10.field1824, 0, var10.field1848, 0, var207, var208);
                    }
                }
                Pix3D.method2758();
            } else if (var10.field1785 == 7) {
                SoftwareFont var209 = var10.method1800();
                if (var209 == null) {
                    if (IfType.field1870) {
                        method1238(var10);
                    }
                    continue;
                }
                int var210 = 0;
                for (int var211 = 0; var211 < var10.field1793; var211++) {
                    for (int var212 = 0; var212 < var10.field1792; var212++) {
                        if (var10.invSlotObjId[var210] > 0) {
                            ObjType var213 = ObjType.get(var10.invSlotObjId[var210] - 1);
                            String var214;
                            if (var213.stackable != 1 && var10.invSlotObjCount[var210] == 1) {
                                var214 = TextUtil.colTag(16748608) + var213.name + TextUtil.colEnd;
                            } else {
                                var214 = TextUtil.colTag(16748608) + var213.name + TextUtil.colEnd + " " + 'x' + method1488(var10.invSlotObjCount[var210]);
                            }
                            int var215 = (var10.field1843 + 115) * var212 + var12;
                            int var216 = (var10.field1837 + 12) * var211 + var13;
                            if (var10.field1864 == 0) {
                                var209.method2821(var214, var215, var216, var10.field1822, var10.field1835 ? 0 : -1);
                            } else if (var10.field1864 == 1) {
                                var209.method2880(var214, var10.field1792 / 2 + var215, var216, var10.field1822, var10.field1835 ? 0 : -1);
                            } else {
                                var209.method2864(var214, var10.field1792 + var215 - 1, var216, var10.field1822, var10.field1835 ? 0 : -1);
                            }
                        }
                        var210++;
                    }
                }
            } else if (var10.field1785 == 8 && field654 == var10 && field2076 == field1995) {
                int var217 = 0;
                int var218 = 0;
                SoftwareFont var219 = field1122;
                String var220 = var10.field1830;
                String var221 = method1583(var220, var10);
                while (var221.length() > 0) {
                    int var222 = var221.indexOf(TextUtil.br);
                    String var223;
                    if (var222 == -1) {
                        var223 = var221;
                        var221 = "";
                    } else {
                        var223 = var221.substring(0, var222);
                        var221 = var221.substring(var222 + 4);
                    }
                    int var224 = var219.method2882(var223);
                    if (var224 > var217) {
                        var217 = var224;
                    }
                    var218 += var219.field2550 + 1;
                }
                var217 += 6;
                var218 += 7;
                int var225 = var10.field1792 + var12 - 5 - var217;
                int var226 = var10.field1793 + var13 + 5;
                if (var225 < var12 + 5) {
                    var225 = var12 + 5;
                }
                if (var217 + var225 > arg4) {
                    var225 = arg4 - var217;
                }
                if (var218 + var226 > arg5) {
                    var226 = arg5 - var218;
                }
                Pix2D.method2637(var225, var226, var217, var218, 16777120);
                Pix2D.method2639(var225, var226, var217, var218, 0);
                String var227 = var10.field1830;
                int var228 = var219.field2550 + var226 + 2;
                String var229 = method1583(var227, var10);
                while (var229.length() > 0) {
                    int var230 = var229.indexOf(TextUtil.br);
                    String var231;
                    if (var230 == -1) {
                        var231 = var229;
                        var229 = "";
                    } else {
                        var231 = var229.substring(0, var230);
                        var229 = var229.substring(var230 + 4);
                    }
                    var219.method2821(var231, var225 + 3, var228, 0, -1);
                    var228 += var219.field2550 + 1;
                }
            } else if (var10.field1785 == 9) {
                if (var10.field1804 == 1) {
                    Pix2D.method2618(var12, var13, var10.field1792 + var12, var10.field1793 + var13, var10.field1822);
                } else {
                    int var232 = var10.field1792 >= 0 ? var10.field1792 : -var10.field1792;
                    int var233 = var10.field1793 >= 0 ? var10.field1793 : -var10.field1793;
                    int var234 = var232;
                    if (var232 < var233) {
                        var234 = var233;
                    }
                    if (var234 != 0) {
                        int var235 = (var10.field1792 << 16) / var234;
                        int var236 = (var10.field1793 << 16) / var234;
                        if (var236 <= var235) {
                            var235 = -var235;
                        } else {
                            var236 = -var236;
                        }
                        int var237 = var10.field1804 * var236 >> 17;
                        int var238 = var10.field1804 * var236 + 1 >> 17;
                        int var239 = var10.field1804 * var235 >> 17;
                        int var240 = var10.field1804 * var235 + 1 >> 17;
                        int var241 = var12 + var237;
                        int var242 = var12 - var238;
                        int var243 = var10.field1792 + var12 - var238;
                        int var244 = var10.field1792 + var12 + var237;
                        int var245 = var13 + var239;
                        int var246 = var13 - var240;
                        int var247 = var10.field1793 + var13 - var240;
                        int var248 = var10.field1793 + var13 + var239;
                        Pix3D.method2764(var241, var242, var243);
                        Pix3D.method2767(var245, var246, var247, var241, var242, var243, var10.field1822);
                        Pix3D.method2764(var241, var243, var244);
                        Pix3D.method2767(var245, var247, var248, var241, var243, var244, var10.field1822);
                    }
                }
            }
        }
	}

	@ObfuscatedName("ez.fu(Ljava/lang/String;Leg;S)Ljava/lang/String;")
	public static String method1583(String arg0, IfType arg1) {
		if (arg0.indexOf("%") != -1) {
			for (int var2 = 1; var2 <= 5; var2++) {
				while (true) {
					int var3 = arg0.indexOf("%" + var2);
					if (var3 == -1) {
						break;
					}
					arg0 = arg0.substring(0, var3) + method1233(method914(arg1, var2 - 1)) + arg0.substring(var3 + 2);
				}
			}
			while (true) {
				int var4 = arg0.indexOf("%dns");
				if (var4 == -1) {
					break;
				}
				String var5 = "";
				if (field170 != null) {
					var5 = JStringUtil.method1846(field170.field508);
					if (field170.field511 != null) {
						var5 = (String) field170.field511;
					}
				}
				arg0 = arg0.substring(0, var4) + var5 + arg0.substring(var4 + 4);
			}
		}
		return arg0;
	}

	@ObfuscatedName("dy.fr(IB)Ljava/lang/String;")
	public static final String method1488(int arg0) {
		String var1 = Integer.toString(arg0);
		for (int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
			var1 = var1.substring(0, var2) + TextUtil.comma + var1.substring(var2);
		}
		if (var1.length() > 9) {
			return " " + TextUtil.colTag(65408) + var1.substring(0, var1.length() - 8) + EnglishLocale.field1016 + " " + TextUtil.openParen + var1 + TextUtil.closeParen + TextUtil.colEnd;
		} else if (var1.length() > 6) {
			return " " + TextUtil.colTag(16777215) + var1.substring(0, var1.length() - 4) + EnglishLocale.field1018 + " " + TextUtil.openParen + var1 + TextUtil.closeParen + TextUtil.colEnd;
		} else {
			return " " + TextUtil.colTag(16776960) + var1 + TextUtil.colEnd;
		}
	}

	@ObfuscatedName("q.fl(Leg;IIIIIII)V")
	public static final void method97(IfType arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		if (field2003) {
			field2004 = 32;
		} else {
			field2004 = 0;
		}
		field2003 = false;
		if (JavaMouseProvider.mouseButton != 0) {
			if (arg5 >= arg1 && arg5 < arg1 + 16 && arg6 >= arg2 && arg6 < arg2 + 16) {
				arg0.field1797 -= 4;
				method1238(arg0);
			} else if (arg5 >= arg1 && arg5 < arg1 + 16 && arg6 >= arg2 + arg3 - 16 && arg6 < arg2 + arg3) {
				arg0.field1797 += 4;
				method1238(arg0);
			} else if (arg5 >= arg1 - field2004 && arg5 < field2004 + arg1 + 16 && arg6 >= arg2 + 16 && arg6 < arg2 + arg3 - 16) {
				int var7 = (arg3 - 32) * arg3 / arg4;
				if (var7 < 8) {
					var7 = 8;
				}
				int var8 = arg6 - arg2 - 16 - var7 / 2;
				int var9 = arg3 - 32 - var7;
				arg0.field1797 = (arg4 - arg3) * var8 / var9;
				method1238(arg0);
				field2003 = true;
			}
		}
		if (field2122 == 0) {
			return;
		}
		int var10 = arg0.field1792;
		if (arg5 >= arg1 - var10 && arg6 >= arg2 && arg5 < arg1 + 16 && arg6 <= arg2 + arg3) {
			arg0.field1797 += field2122 * 45;
			method1238(arg0);
		}
	}

	@ObfuscatedName("ck.fk(II)Ljava/lang/String;")
	public static final String method1233(int arg0) {
		return arg0 < 999999999 ? Integer.toString(arg0) : "*";
	}

	@ObfuscatedName("n.fa(Leg;I)Z")
	public static final boolean method56(IfType arg0) {
		if (arg0.field1789 == null) {
			return false;
		}
		for (int var1 = 0; var1 < arg0.field1789.length; var1++) {
			int var2 = method914(arg0, var1);
			int var3 = arg0.field1881[var1];
			if (arg0.field1789[var1] == 2) {
				if (var2 >= var3) {
					return false;
				}
			} else if (arg0.field1789[var1] == 3) {
				if (var2 <= var3) {
					return false;
				}
			} else if (arg0.field1789[var1] == 4) {
				if (var2 == var3) {
					return false;
				}
			} else if (var2 != var3) {
				return false;
			}
		}
		return true;
	}

	@ObfuscatedName("ba.fq(Leg;IB)I")
	public static final int method914(IfType arg0, int arg1) {
		if (arg0.field1874 == null || arg1 >= arg0.field1874.length) {
			return -2;
		}
		try {
			int[] var2 = arg0.field1874[arg1];
			int var3 = 0;
			int var4 = 0;
			byte var5 = 0;
			while (true) {
				int var6 = var2[var4++];
				int var7 = 0;
				byte var8 = 0;
				if (var6 == 0) {
					return var3;
				}
				if (var6 == 1) {
					var7 = field2060[var2[var4++]];
				}
				if (var6 == 2) {
					var7 = field1960[var2[var4++]];
				}
				if (var6 == 3) {
					var7 = field2062[var2[var4++]];
				}
				if (var6 == 4) {
					int var9 = var2[var4++] << 16;
					int var10 = var9 + var2[var4++];
					IfType var11 = IfType.get(var10);
					int var12 = var2[var4++];
					if (var12 != -1 && (!ObjType.get(var12).membersWorld || members)) {
						for (int var13 = 0; var13 < var11.invSlotObjId.length; var13++) {
							if (var12 + 1 == var11.invSlotObjId[var13]) {
								var7 += var11.invSlotObjCount[var13];
							}
						}
					}
				}
				if (var6 == 5) {
					var7 = VarProvider.field1210[var2[var4++]];
				}
				if (var6 == 6) {
					var7 = PlayerStats.levelExperience[field1960[var2[var4++]] - 1];
				}
				if (var6 == 7) {
					var7 = VarProvider.field1210[var2[var4++]] * 100 / 46875;
				}
				if (var6 == 8) {
					var7 = localPlayer.field2789;
				}
				if (var6 == 9) {
					for (int var14 = 0; var14 < 25; var14++) {
						if (PlayerStats.enabled[var14]) {
							var7 += field1960[var14];
						}
					}
				}
				if (var6 == 10) {
					int var15 = var2[var4++] << 16;
					int var16 = var15 + var2[var4++];
					IfType var17 = IfType.get(var16);
					int var18 = var2[var4++];
					if (var18 != -1 && (!ObjType.get(var18).membersWorld || members)) {
						for (int var19 = 0; var19 < var17.invSlotObjId.length; var19++) {
							if (var18 + 1 == var17.invSlotObjId[var19]) {
								var7 = 999999999;
								break;
							}
						}
					}
				}
				if (var6 == 11) {
					var7 = field2080;
				}
				if (var6 == 12) {
					var7 = field2089;
				}
				if (var6 == 13) {
					int var20 = VarProvider.field1210[var2[var4++]];
					int var21 = var2[var4++];
					var7 = (var20 & 0x1 << var21) == 0 ? 0 : 1;
				}
				if (var6 == 14) {
					int var22 = var2[var4++];
					var7 = VarProvider.method1130(var22);
				}
				if (var6 == 15) {
					var8 = 1;
				}
				if (var6 == 16) {
					var8 = 2;
				}
				if (var6 == 17) {
					var8 = 3;
				}
				if (var6 == 18) {
					var7 = (localPlayer.x >> 7) + sceneBaseTileX;
				}
				if (var6 == 19) {
					var7 = (localPlayer.z >> 7) + sceneBaseTileZ;
				}
				if (var6 == 20) {
					var7 = var2[var4++];
				}
				if (var8 == 0) {
					if (var5 == 0) {
						var3 += var7;
					}
					if (var5 == 1) {
						var3 -= var7;
					}
					if (var5 == 2 && var7 != 0) {
						var3 /= var7;
					}
					if (var5 == 3) {
						var3 *= var7;
					}
					var5 = 0;
				} else {
					var5 = var8;
				}
			}
		} catch (Exception var24) {
			return -1;
		}
	}

	@ObfuscatedName("cz.ft(IIIIIIIS)V")
	public static final void method1145(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		if (IfType.method1501(arg0)) {
			method1836(IfType.field373[arg0], -1, arg1, arg2, arg3, arg4, arg5, arg6);
		}
	}

	@ObfuscatedName("eg.fx([Leg;IIIIIIIB)V")
	public static final void method1836(IfType[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		for (int var8 = 0; var8 < arg0.length; var8++) {
			IfType var9 = arg0[var8];
			if (var9 != null && (!var9.field1782 || var9.field1785 == 0 || var9.field1813 || method1512(var9) != 0 || field2162 == var9) && var9.layerid == arg1 && (!var9.field1782 || !method868(var9))) {
				int var10 = var9.field1788 + arg6;
				int var11 = var9.field1810 + arg7;
				int var12;
				int var13;
				int var14;
				int var15;
				if (var9.field1785 == 2) {
					var12 = arg2;
					var13 = arg3;
					var14 = arg4;
					var15 = arg5;
				} else if (var9.field1785 == 9) {
					int var16 = var10;
					int var17 = var11;
					int var18 = var9.field1792 + var10;
					int var19 = var9.field1793 + var11;
					if (var18 < var10) {
						var16 = var18;
						var18 = var10;
					}
					if (var19 < var11) {
						var17 = var19;
						var19 = var11;
					}
					var18++;
					var19++;
					var12 = var16 > arg2 ? var16 : arg2;
					var13 = var17 > arg3 ? var17 : arg3;
					var14 = var18 < arg4 ? var18 : arg4;
					var15 = var19 < arg5 ? var19 : arg5;
				} else {
					int var22 = var9.field1792 + var10;
					int var23 = var9.field1793 + var11;
					var12 = var10 > arg2 ? var10 : arg2;
					var13 = var11 > arg3 ? var11 : arg3;
					var14 = var22 < arg4 ? var22 : arg4;
					var15 = var23 < arg5 ? var23 : arg5;
				}
				if (field2094 == var9) {
					field2102 = true;
					field2103 = var10;
					field2104 = var11;
				}
				if (!var9.field1782 || var12 < var14 && var13 < var15) {
					if (var9.clientCode == 1337) {
						method1238(var9);
					} else if (var9.clientCode == 1338) {
						method344(var10, var11);
					} else {
						if (var9.field1785 == 0) {
							if (!var9.field1782 && method868(var9) && field37 != var9) {
								continue;
							}
							method1836(arg0, var9.field1783, var12, var13, var14, var15, var10 - var9.field1796, var11 - var9.field1797);
							if (var9.subcomponents != null) {
								method1836(var9.subcomponents, var9.field1783, var12, var13, var14, var15, var10 - var9.field1796, var11 - var9.field1797);
							}
							ComponentPointer var24 = (ComponentPointer) field1918.get((long) var9.field1783);
							if (var24 != null) {
								method1145(var24.field1598, var12, var13, var14, var15, var10, var11);
							}
						}
						if (var9.field1782) {
							boolean var25;
							if (JavaMouseProvider.mouseX >= var12 && JavaMouseProvider.mouseY >= var13 && JavaMouseProvider.mouseX < var14 && JavaMouseProvider.mouseY < var15) {
								var25 = true;
							} else {
								var25 = false;
							}
							boolean var26 = false;
							if (JavaMouseProvider.mouseButton == 1 && var25) {
								var26 = true;
							}
							boolean var27 = false;
							if (JavaMouseProvider.mouseClickButton == 1 && JavaMouseProvider.mouseClickX >= var12 && JavaMouseProvider.mouseClickY >= var13 && JavaMouseProvider.mouseClickX < var14 && JavaMouseProvider.mouseClickY < var15) {
								var27 = true;
							}
							if (var27) {
								method1102(var9, JavaMouseProvider.mouseClickX - var10, JavaMouseProvider.mouseClickY - var11);
							}
							if (field2094 != null && field2094 != var9 && var25) {
								int var28 = method1512(var9);
								boolean var29 = (var28 >> 20 & 0x1) != 0;
								if (var29) {
									field2098 = var9;
								}
							}
							if (field2162 == var9) {
								field2126 = true;
								field2183 = var10;
								field2101 = var11;
							}
							if (var9.field1813) {
								if (var25 && field2122 != 0 && var9.field1831 != null) {
									HookRequest var30 = new HookRequest();
									var30.component = var9;
									var30.field1587 = field2122;
									var30.field1588 = var9.field1831;
									hookRequests.push(var30);
								}
								if (field2094 != null || objDragInterface != null || field2066) {
									var27 = false;
									var26 = false;
									var25 = false;
								}
								if (!var9.field1871 && var27) {
									var9.field1871 = true;
									if (var9.field1852 != null) {
										HookRequest var31 = new HookRequest();
										var31.component = var9;
										var31.field1589 = JavaMouseProvider.mouseClickX - var10;
										var31.field1587 = JavaMouseProvider.mouseClickY - var11;
										var31.field1588 = var9.field1852;
										hookRequests.push(var31);
									}
								}
								if (var9.field1871 && var26 && var9.field1853 != null) {
									HookRequest var32 = new HookRequest();
									var32.component = var9;
									var32.field1589 = JavaMouseProvider.mouseX - var10;
									var32.field1587 = JavaMouseProvider.mouseY - var11;
									var32.field1588 = var9.field1853;
									hookRequests.push(var32);
								}
								if (var9.field1871 && !var26) {
									var9.field1871 = false;
									if (var9.field1851 != null) {
										HookRequest var33 = new HookRequest();
										var33.component = var9;
										var33.field1589 = JavaMouseProvider.mouseX - var10;
										var33.field1587 = JavaMouseProvider.mouseY - var11;
										var33.field1588 = var9.field1851;
										hookRequestsMouseStop.push(var33);
									}
								}
								if (var26 && var9.field1855 != null) {
									HookRequest var34 = new HookRequest();
									var34.component = var9;
									var34.field1589 = JavaMouseProvider.mouseX - var10;
									var34.field1587 = JavaMouseProvider.mouseY - var11;
									var34.field1588 = var9.field1855;
									hookRequests.push(var34);
								}
								if (!var9.field1892 && var25) {
									var9.field1892 = true;
									if (var9.field1856 != null) {
										HookRequest var35 = new HookRequest();
										var35.component = var9;
										var35.field1589 = JavaMouseProvider.mouseX - var10;
										var35.field1587 = JavaMouseProvider.mouseY - var11;
										var35.field1588 = var9.field1856;
										hookRequests.push(var35);
									}
								}
								if (var9.field1892 && var25 && var9.field1857 != null) {
									HookRequest var36 = new HookRequest();
									var36.component = var9;
									var36.field1589 = JavaMouseProvider.mouseX - var10;
									var36.field1587 = JavaMouseProvider.mouseY - var11;
									var36.field1588 = var9.field1857;
									hookRequests.push(var36);
								}
								if (var9.field1892 && !var25) {
									var9.field1892 = false;
									if (var9.field1838 != null) {
										HookRequest var37 = new HookRequest();
										var37.component = var9;
										var37.field1589 = JavaMouseProvider.mouseX - var10;
										var37.field1587 = JavaMouseProvider.mouseY - var11;
										var37.field1588 = var9.field1838;
										hookRequestsMouseStop.push(var37);
									}
								}
								if (var9.field1869 != null) {
									HookRequest var38 = new HookRequest();
									var38.component = var9;
									var38.field1588 = var9.field1869;
									hookRequestsTimer.push(var38);
								}
								if (var9.field1839 != null && field2084 > var9.field1895) {
									if (var9.field1889 == null || field2084 - var9.field1895 > 32) {
										HookRequest var43 = new HookRequest();
										var43.component = var9;
										var43.field1588 = var9.field1839;
										hookRequests.push(var43);
									} else {
										label383: for (int var39 = var9.field1895; var39 < field2084; var39++) {
											int var40 = field2110[var39 & 0x1F];
											for (int var41 = 0; var41 < var9.field1889.length; var41++) {
												if (var9.field1889[var41] == var40) {
													HookRequest var42 = new HookRequest();
													var42.component = var9;
													var42.field1588 = var9.field1839;
													hookRequests.push(var42);
													break label383;
												}
											}
										}
									}
									var9.field1895 = field2084;
								}
								if (var9.field1865 != null && field2050 > var9.field1879) {
									if (var9.field1866 == null || field2050 - var9.field1879 > 32) {
										HookRequest var48 = new HookRequest();
										var48.component = var9;
										var48.field1588 = var9.field1865;
										hookRequests.push(var48);
									} else {
										label363: for (int var44 = var9.field1879; var44 < field2050; var44++) {
											int var45 = field2112[var44 & 0x1F];
											for (int var46 = 0; var46 < var9.field1866.length; var46++) {
												if (var9.field1866[var46] == var45) {
													HookRequest var47 = new HookRequest();
													var47.component = var9;
													var47.field1588 = var9.field1865;
													hookRequests.push(var47);
													break label363;
												}
											}
										}
									}
									var9.field1879 = field2050;
								}
								if (var9.field1867 != null && field1982 > var9.field1897) {
									if (var9.field1868 == null || field1982 - var9.field1897 > 32) {
										HookRequest var53 = new HookRequest();
										var53.component = var9;
										var53.field1588 = var9.field1867;
										hookRequests.push(var53);
									} else {
										label343: for (int var49 = var9.field1897; var49 < field1982; var49++) {
											int var50 = field1999[var49 & 0x1F];
											for (int var51 = 0; var51 < var9.field1868.length; var51++) {
												if (var9.field1868[var51] == var50) {
													HookRequest var52 = new HookRequest();
													var52.component = var9;
													var52.field1588 = var9.field1867;
													hookRequests.push(var52);
													break label343;
												}
											}
										}
									}
									var9.field1897 = field1982;
								}
								if (field2116 > var9.field1894 && var9.field1872 != null) {
									HookRequest var54 = new HookRequest();
									var54.component = var9;
									var54.field1588 = var9.field1872;
									hookRequests.push(var54);
								}
								if (field1977 > var9.field1894 && var9.field1877 != null) {
									HookRequest var55 = new HookRequest();
									var55.component = var9;
									var55.field1588 = var9.field1877;
									hookRequests.push(var55);
								}
								if (field2185 > var9.field1894 && var9.field1875 != null) {
									HookRequest var56 = new HookRequest();
									var56.component = var9;
									var56.field1588 = var9.field1875;
									hookRequests.push(var56);
								}
								if (field2119 > var9.field1894 && var9.field1777 != null) {
									HookRequest var57 = new HookRequest();
									var57.component = var9;
									var57.field1588 = var9.field1777;
									hookRequests.push(var57);
								}
								var9.field1894 = field2117;
								if (var9.field1873 != null) {
									for (int var58 = 0; var58 < field2151; var58++) {
										HookRequest var59 = new HookRequest();
										var59.component = var9;
										var59.field1593 = field2153[var58];
										var59.field1594 = field2152[var58];
										var59.field1588 = var9.field1873;
										hookRequests.push(var59);
									}
								}
							}
						}
						if (!var9.field1782) {
							if (field2094 != null || objDragInterface != null || field2066) {
								return;
							}
							if ((var9.field1882 >= 0 || var9.field1802 != 0) && JavaMouseProvider.mouseX >= var12 && JavaMouseProvider.mouseY >= var13 && JavaMouseProvider.mouseX < var14 && JavaMouseProvider.mouseY < var15) {
								if (var9.field1882 >= 0) {
									field37 = arg0[var9.field1882];
								} else {
									field37 = var9;
								}
							}
							if (var9.field1785 == 8 && JavaMouseProvider.mouseX >= var12 && JavaMouseProvider.mouseY >= var13 && JavaMouseProvider.mouseX < var14 && JavaMouseProvider.mouseY < var15) {
								field654 = var9;
							}
							if (var9.field1799 > var9.field1793) {
								method97(var9, var9.field1792 + var10, var11, var9.field1793, var9.field1799, JavaMouseProvider.mouseX, JavaMouseProvider.mouseY);
							}
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("ai.fs(III)V")
	public static final void method725(int arg0, int arg1) {
		if (IfType.method1501(arg0)) {
			method561(IfType.field373[arg0], arg1);
		}
	}

	@ObfuscatedName("ao.fh([Leg;IB)V")
	public static final void method561(IfType[] arg0, int arg1) {
		for (int var2 = 0; var2 < arg0.length; var2++) {
			IfType var3 = arg0[var2];
			if (var3 != null) {
				if (var3.field1785 == 0) {
					if (var3.subcomponents != null) {
						method561(var3.subcomponents, arg1);
					}
					ComponentPointer var4 = (ComponentPointer) field1918.get((long) var3.field1783);
					if (var4 != null) {
						method725(var4.field1598, arg1);
					}
				}
				if (arg1 == 0 && var3.field1819 != null) {
					HookRequest var5 = new HookRequest();
					var5.component = var3;
					var5.field1588 = var3.field1819;
					ScriptRunner.runHook(var5);
				}
				if (arg1 == 1 && var3.field1878 != null) {
					if (var3.subid >= 0) {
						IfType var6 = IfType.get(var3.field1783);
						if (var6 == null || var6.subcomponents == null || var3.subid >= var6.subcomponents.length || var6.subcomponents[var3.subid] != var3) {
							continue;
						}
					}
					HookRequest var7 = new HookRequest();
					var7.component = var3;
					var7.field1588 = var3.field1878;
					ScriptRunner.runHook(var7);
				}
			}
		}
	}

	@ObfuscatedName("ch.ff(Leg;IIB)V")
	public static final void method1102(IfType arg0, int arg1, int arg2) {
		if (field2094 != null || field2066 || (arg0 == null || method766(arg0) == null)) {
			return;
		}
		field2094 = arg0;
		field2162 = method766(arg0);
		field2115 = arg1;
		field2097 = arg2;
		field1219 = 0;
		field1927 = false;
	}

	@ObfuscatedName("cq.fy(Leg;I)V")
	public static void method1238(IfType arg0) {
		if (field2063 == arg0.field1899) {
			field2175[arg0.field1898] = true;
		}
	}

	@ObfuscatedName("g.fn(B)V")
	public static void method93() {
		for (ComponentPointer var0 = (ComponentPointer) field1918.method1284(); var0 != null; var0 = (ComponentPointer) field1918.method1280()) {
			int var1 = var0.field1598;
			if (IfType.method1501(var1)) {
				boolean var2 = true;
				IfType[] var3 = IfType.field373[var1];
				for (int var4 = 0; var4 < var3.length; var4++) {
					if (var3[var4] != null) {
						var2 = var3[var4].field1782;
						break;
					}
				}
				if (!var2) {
					int var5 = (int) var0.key;
					IfType var6 = IfType.get(var5);
					if (var6 != null) {
						method1238(var6);
					}
				}
			}
		}
	}

	@ObfuscatedName("bs.fz(Leg;I)Leg;")
	public static IfType method766(IfType arg0) {
		IfType var1 = arg0;
		int var2 = WorldEntrySettings.method480(method1512(arg0));
		IfType var3;
		if (var2 == 0) {
			var3 = null;
		} else {
			int var4 = 0;
			while (true) {
				if (var4 >= var2) {
					var3 = var1;
					break;
				}
				var1 = IfType.get(var1.layerid);
				if (var1 == null) {
					var3 = null;
					break;
				}
				var4++;
			}
		}
		IfType var5 = var3;
		if (var3 == null) {
			var5 = arg0.field1845;
		}
		return var5;
	}

	@ObfuscatedName("ai.fw([Ljava/lang/String;B)[Ljava/lang/String;")
	public static final String[] method726(String[] arg0) {
		String[] var1 = new String[5];
		for (int var2 = 0; var2 < 5; var2++) {
			var1[var2] = var2 + ": ";
			if (arg0 != null && arg0[var2] != null) {
				var1[var2] = var1[var2] + arg0[var2];
			}
		}
		return var1;
	}

	@ObfuscatedName("n.fo(II)V")
	public static final void method57(int arg0) {
		if (!IfType.method1501(arg0)) {
			return;
		}
		IfType[] var1 = IfType.field373[arg0];
		for (int var2 = 0; var2 < var1.length; var2++) {
			IfType var3 = var1[var2];
			if (var3 != null) {
				var3.field1779 = 0;
				var3.field1890 = 0;
			}
		}
	}

	@ObfuscatedName("cz.fm([Leg;IB)V")
	public static final void method1146(IfType[] arg0, int arg1) {
		for (int var2 = 0; var2 < arg0.length; var2++) {
			IfType var3 = arg0[var2];
			if (var3 != null && var3.layerid == arg1 && (!var3.field1782 || !method868(var3))) {
				if (var3.field1785 == 0) {
					if (!var3.field1782 && method868(var3) && field37 != var3) {
						continue;
					}
					method1146(arg0, var3.field1783);
					if (var3.subcomponents != null) {
						method1146(var3.subcomponents, var3.field1783);
					}
					ComponentPointer var4 = (ComponentPointer) field1918.get((long) var3.field1783);
					if (var4 != null) {
						imethod23(var4.field1598);
					}
				}
				if (var3.field1785 == 6) {
					if (var3.field1863 != -1 || var3.field1820 != -1) {
						boolean var6 = method56(var3);
						int var7;
						if (var6) {
							var7 = var3.field1820;
						} else {
							var7 = var3.field1863;
						}
						if (var7 != -1) {
							SeqType var8 = SeqType.get(var7);
							var3.field1890 += sceneDelta;
							while (var3.field1890 > var8.delay[var3.field1779]) {
								var3.field1890 -= var8.delay[var3.field1779];
								var3.field1779++;
								if (var3.field1779 >= var8.frames.length) {
									var3.field1779 -= var8.replayoff;
									if (var3.field1779 < 0 || var3.field1779 >= var8.frames.length) {
										var3.field1779 = 0;
									}
								}
								method1238(var3);
							}
						}
					}
					if (var3.field1827 != 0 && !var3.field1782) {
						int var9 = var3.field1827 >> 16;
						int var10 = var3.field1827 << 16 >> 16;
						int var11 = sceneDelta * var9;
						int var12 = sceneDelta * var10;
						var3.field1848 = var3.field1848 + var11 & 0x7FF;
						var3.field1824 = var3.field1824 + var12 & 0x7FF;
						method1238(var3);
					}
				}
			}
		}
	}

	@ObfuscatedName("bv.fi(II)V")
	public static final void method778(int arg0) {
		method93();
		PositionedSound.method478();
		int var1 = VarPlayerType.get(arg0).clientcode;
		if (var1 == 0) {
			return;
		}
		int var2 = VarProvider.field1210[arg0];
		if (var1 == 1) {
			if (var2 == 1) {
				Pix3D.method2761(0.9D);
				((SceneBuilderProvider) Pix3D.sceneProvider).method757(0.9D);
			}
			if (var2 == 2) {
				Pix3D.method2761(0.8D);
				((SceneBuilderProvider) Pix3D.sceneProvider).method757(0.8D);
			}
			if (var2 == 3) {
				Pix3D.method2761(0.7D);
				((SceneBuilderProvider) Pix3D.sceneProvider).method757(0.7D);
			}
			if (var2 == 4) {
				Pix3D.method2761(0.6D);
				((SceneBuilderProvider) Pix3D.sceneProvider).method757(0.6D);
			}
			ObjType.method1352();
		}
		if (var1 == 3) {
			short var3 = 0;
			if (var2 == 0) {
				var3 = 255;
			}
			if (var2 == 1) {
				var3 = 192;
			}
			if (var2 == 2) {
				var3 = 128;
			}
			if (var2 == 3) {
				var3 = 64;
			}
			if (var2 == 4) {
				var3 = 0;
			}
			if (field2169 != var3) {
				if (field2169 == 0 && field2170 != -1) {
					MidiPlayer.method1125(field1110, field2170, 0, var3, false);
					field2189 = false;
				} else if (var3 == 0) {
					MidiPlayer.method917();
					field2189 = false;
				} else {
					MidiPlayer.method105(var3);
				}
				field2169 = var3;
			}
		}
		if (var1 == 4) {
			if (var2 == 0) {
				field1952 = 127;
			}
			if (var2 == 1) {
				field1952 = 96;
			}
			if (var2 == 2) {
				field1952 = 64;
			}
			if (var2 == 3) {
				field1952 = 32;
			}
			if (var2 == 4) {
				field1952 = 0;
			}
		}
		if (var1 == 5) {
			mouseButtonsOption = var2;
		}
		if (var1 == 6) {
			field2085 = var2;
		}
		if (var1 == 9) {
			bankArrangeMode = var2;
		}
		if (var1 != 10) {
			return;
		}
		if (var2 == 0) {
			field2174 = 127;
		}
		if (var2 == 1) {
			field2174 = 96;
		}
		if (var2 == 2) {
			field2174 = 64;
		}
		if (var2 == 3) {
			field2174 = 32;
		}
		if (var2 == 4) {
			field2174 = 0;
		}
	}

	@ObfuscatedName("cy.ge(Leg;I)V")
	public static final void method1236(IfType arg0) {
		int var1 = arg0.clientCode;
		if (var1 == 324) {
			if (field2018 == -1) {
				field2018 = arg0.field1807;
				field2199 = arg0.field1808;
			}
			if (field2197.field1222) {
				arg0.field1807 = field2018;
			} else {
				arg0.field1807 = field2199;
			}
		} else if (var1 == 325) {
			if (field2018 == -1) {
				field2018 = arg0.field1807;
				field2199 = arg0.field1808;
			}
			if (field2197.field1222) {
				arg0.field1807 = field2199;
			} else {
				arg0.field1807 = field2018;
			}
		} else if (var1 == 327) {
			arg0.field1848 = 150;
			arg0.field1824 = (int) (Math.sin((double) loopCycle / 40.0D) * 256.0D) & 0x7FF;
			arg0.field1815 = 5;
			arg0.field1816 = 0;
		} else if (var1 == 328) {
			arg0.field1848 = 150;
			arg0.field1824 = (int) (Math.sin((double) loopCycle / 40.0D) * 256.0D) & 0x7FF;
			arg0.field1815 = 5;
			arg0.field1816 = 1;
		}
	}

	@ObfuscatedName("cz.gq(IIIB)Ldy;")
	public static final ComponentPointer method1147(int arg0, int arg1, int arg2) {
		ComponentPointer var3 = new ComponentPointer();
		var3.field1598 = arg1;
		var3.field1597 = arg2;
		field1918.put(var3, (long) arg0);
		method57(arg1);
		ScriptRunner.method6(arg1);
		IfType var4 = IfType.get(arg0);
		if (var4 != null) {
			method1238(var4);
		}
		if (field2087 != null) {
			method1238(field2087);
			field2087 = null;
		}
		field2066 = false;
		menuSize = 0;
		method765(field1161, field743, field535, field42);
		if (field2083 != -1) {
			method725(field2083, 1);
		}
		return var3;
	}

	@ObfuscatedName("am.gr(Ldy;ZI)V")
	public static final void method408(ComponentPointer arg0, boolean arg1) {
		int var2 = arg0.field1598;
		int var3 = (int) arg0.key;
		arg0.unlink();
		if (arg1 && var2 != -1 && IfType.field1508[var2]) {
			IfType.field1806.discardFiles(var2);
			if (IfType.field373[var2] != null) {
				boolean var4 = true;
				for (int var5 = 0; var5 < IfType.field373[var2].length; var5++) {
					if (IfType.field373[var2][var5] != null) {
						if (IfType.field373[var2][var5].field1785 == 2) {
							var4 = false;
						} else {
							IfType.field373[var2][var5] = null;
						}
					}
				}
				if (var4) {
					IfType.field373[var2] = null;
				}
				IfType.field1508[var2] = false;
			}
		}
		method109(var2);
		IfType var6 = IfType.get(var3);
		if (var6 != null) {
			method1238(var6);
		}
		field2066 = false;
		menuSize = 0;
		method765(field1161, field743, field535, field42);
		if (field2083 != -1) {
			method725(field2083, 1);
		}
	}

	@ObfuscatedName("es.gd(Leg;B)Z")
	public static final boolean method1580(IfType arg0) {
		int var1 = arg0.clientCode;
		if (var1 == 205) {
			idleTimeout = 250;
			return true;
		}
		if (var1 >= 300 && var1 <= 313) {
			int var2 = (var1 - 300) / 2;
			int var3 = var1 & 0x1;
			field2197.method1169(var2, var3 == 1);
		}
		if (var1 >= 314 && var1 <= 323) {
			int var4 = (var1 - 314) / 2;
			int var5 = var1 & 0x1;
			field2197.method1170(var4, var5 == 1);
		}
		if (var1 == 324) {
			field2197.method1171(false);
		}
		if (var1 == 325) {
			field2197.method1171(true);
		}
		if (var1 == 326) {
			out.pisaac1(71);
			field2197.method1172(out);
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ba.gh(IIII)V")
	public static final void method915(int arg0, int arg1, int arg2) {
		method1351();
		Pix2D.method2605(arg0, arg1, field807.field2513 + arg0, field807.field2514 + arg1);
		if (minimapState == 2 || minimapState == 5) {
			Pix2D.method2599(arg0 + 25, arg1 + 5, 0, field829, field1474);
		} else {
			int var3 = orbitCameraYaw + minimapAnticheatAngle & 0x7FF;
			int var4 = localPlayer.x / 32 + 48;
			int var5 = 464 - localPlayer.z / 32;
			field1627.method2680(arg0 + 25, arg1 + 5, 146, 151, var4, var5, var3, minimapZoom + 256, field829, field1474);
			for (int var6 = 0; var6 < field2157; var6++) {
				int var7 = field2158[var6] * 4 + 2 - localPlayer.x / 32;
				int var8 = field2159[var6] * 4 + 2 - localPlayer.z / 32;
				method94(arg0, arg1, var7, var8, field2160[var6]);
			}
			for (int var9 = 0; var9 < 104; var9++) {
				for (int var10 = 0; var10 < 104; var10++) {
					LinkList var11 = levelObjStacks[currentLevel][var9][var10];
					if (var11 != null) {
						int var12 = var9 * 4 + 2 - localPlayer.x / 32;
						int var13 = var10 * 4 + 2 - localPlayer.z / 32;
						method94(arg0, arg1, var12, var13, field741[0]);
					}
				}
			}
			for (int var14 = 0; var14 < npcCount; var14++) {
				NpcEntity var15 = npcs[field1956[var14]];
				if (var15 != null && var15.method2915()) {
					NpcType var16 = var15.field2804;
					if (var16 != null && var16.multinpc != null) {
						var16 = var16.method2332();
					}
					if (var16 != null && var16.minimap && var16.active) {
						int var17 = var15.x / 32 - localPlayer.x / 32;
						int var18 = var15.z / 32 - localPlayer.z / 32;
						method94(arg0, arg1, var17, var18, field741[1]);
					}
				}
			}
			for (int var19 = 0; var19 < playerCount; var19++) {
				PlayerEntity var20 = players[playerIds[var19]];
				if (var20 != null && var20.method2915()) {
					int var21 = var20.x / 32 - localPlayer.x / 32;
					int var22 = var20.z / 32 - localPlayer.z / 32;
					boolean var23 = false;
					if (method785(var20.field2796)) {
						var23 = true;
					}
					boolean var24 = false;
					if (localPlayer.field2803 != 0 && var20.field2803 != 0 && localPlayer.field2803 == var20.field2803) {
						var24 = true;
					}
					if (var23) {
						method94(arg0, arg1, var21, var22, field741[3]);
					} else if (var24) {
						method94(arg0, arg1, var21, var22, field741[4]);
					} else {
						method94(arg0, arg1, var21, var22, field741[2]);
					}
				}
			}
			if (field1920 != 0 && loopCycle % 20 < 10) {
				if (field1920 == 1 && field1931 >= 0 && field1931 < npcs.length) {
					NpcEntity var25 = npcs[field1931];
					if (var25 != null) {
						int var26 = var25.x / 32 - localPlayer.x / 32;
						int var27 = var25.z / 32 - localPlayer.z / 32;
						method458(arg0, arg1, var26, var27, field828[1]);
					}
				}
				if (field1920 == 2) {
					int var28 = field1933 * 4 - sceneBaseTileX * 4 + 2 - localPlayer.x / 32;
					int var29 = field1934 * 4 - sceneBaseTileZ * 4 + 2 - localPlayer.z / 32;
					method458(arg0, arg1, var28, var29, field828[1]);
				}
				if (field1920 == 10 && field1932 >= 0 && field1932 < players.length) {
					PlayerEntity var30 = players[field1932];
					if (var30 != null) {
						int var31 = var30.x / 32 - localPlayer.x / 32;
						int var32 = var30.z / 32 - localPlayer.z / 32;
						method458(arg0, arg1, var31, var32, field828[1]);
					}
				}
			}
			if (flagSceneTileX != 0) {
				int var33 = flagSceneTileX * 4 + 2 - localPlayer.x / 32;
				int var34 = flagSceneTileZ * 4 + 2 - localPlayer.z / 32;
				method94(arg0, arg1, var33, var34, field828[0]);
			}
			Pix2D.method2637(arg0 + 93 + 4, arg1 + 82 - 4, 3, 3, 16777215);
		}
		if (minimapState < 3) {
			field536.method2680(arg0, arg1, 33, 33, 25, 25, orbitCameraYaw, 256, field853, field171);
		} else {
			Pix2D.method2599(arg0, arg1, 0, field853, field171);
		}
		if (field2132[arg2]) {
			field807.method2747(arg0, arg1);
		}
		field2131[arg2] = true;
	}

	@ObfuscatedName("ak.gm(IIIILfq;B)V")
	public static final void method458(int arg0, int arg1, int arg2, int arg3, Pix32 arg4) {
		int var5 = arg2 * arg2 + arg3 * arg3;
		if (var5 <= 4225 || var5 >= 90000) {
			method94(arg0, arg1, arg2, arg3, arg4);
			return;
		}
		int var6 = orbitCameraYaw + minimapAnticheatAngle & 0x7FF;
		int var7 = Pix3D.sinTable[var6];
		int var8 = Pix3D.cosTable[var6];
		int var9 = var7 * 256 / (minimapZoom + 256);
		int var10 = var8 * 256 / (minimapZoom + 256);
		int var11 = arg2 * var10 + arg3 * var9 >> 16;
		int var12 = arg3 * var10 - arg2 * var9 >> 16;
		double var13 = Math.atan2((double) var11, (double) var12);
		int var15 = (int) (Math.sin(var13) * 63.0D);
		int var16 = (int) (Math.cos(var13) * 57.0D);
		field1510.method2665(arg0 + 94 + var15 + 4 - 10, arg1 + 83 - var16 - 20, 20, 20, 15, 15, var13, 256);
	}

	@ObfuscatedName("g.gw(IIIILfq;I)V")
	public static final void method94(int arg0, int arg1, int arg2, int arg3, Pix32 arg4) {
		if (arg4 == null) {
			return;
		}
		int var5 = orbitCameraYaw + minimapAnticheatAngle & 0x7FF;
		int var6 = arg2 * arg2 + arg3 * arg3;
		if (var6 > 6400) {
			return;
		}
		int var7 = Pix3D.sinTable[var5];
		int var8 = Pix3D.cosTable[var5];
		int var9 = var7 * 256 / (minimapZoom + 256);
		int var10 = var8 * 256 / (minimapZoom + 256);
		int var11 = arg2 * var10 + arg3 * var9 >> 16;
		int var12 = arg3 * var10 - arg2 * var9 >> 16;
		if (var6 > 2500) {
			arg4.method2694(field807, arg0 + 94 + var11 - arg4.field2504 / 2 + 4, arg1 + 83 - var12 - arg4.field2505 / 2 - 4);
		} else {
			arg4.method2671(arg0 + 94 + var11 - arg4.field2504 / 2 + 4, arg1 + 83 - var12 - arg4.field2505 / 2 - 4);
		}
	}

	@ObfuscatedName("ao.gn(ILjava/lang/String;Ljava/lang/String;I)V")
	public static final void method559(int arg0, String arg1, String arg2) {
		method922(arg0, arg1, arg2, null);
	}

	@ObfuscatedName("br.gj(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V")
	public static final void method922(int arg0, String arg1, String arg2, String arg3) {
		for (int var4 = 99; var4 > 0; var4--) {
			field2139[var4] = field2139[var4 - 1];
			field2046[var4] = field2046[var4 - 1];
			field2142[var4] = field2142[var4 - 1];
			field2173[var4] = field2173[var4 - 1];
		}
		field2139[0] = arg0;
		field2046[0] = arg1;
		field2142[0] = arg2;
		field2173[0] = arg3;
		field2141++;
		field2116 = field2117;
	}

	@ObfuscatedName("bg.gk(Ljava/lang/String;B)Z")
	public static boolean method785(String arg0) {
		if (arg0 == null) {
			return false;
		}
		for (int var1 = 0; var1 < field2071; var1++) {
			if (arg0.equalsIgnoreCase(field2111[var1].field173)) {
				return true;
			}
		}
		if (arg0.equalsIgnoreCase(localPlayer.field2796)) {
			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("bi.gx(Ljava/lang/String;I)Z")
	public static boolean method761(String arg0) {
		if (arg0 == null) {
			return false;
		}
		for (int var1 = 0; var1 < field2194; var1++) {
			IgnoreListEntry var2 = field2196[var1];
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
		if (field2071 >= 200 && field2130 != 1 || field2071 >= 200) {
			method559(0, "", EnglishLocale.field1021);
			return;
		}
		String var1 = NamespaceUtil.method743(arg0, namespace);
		if (var1 == null) {
			return;
		}
		for (int var2 = 0; var2 < field2071; var2++) {
			FriendListEntry var3 = field2111[var2];
			String var4 = NamespaceUtil.method743(var3.field173, namespace);
			if (var4 != null && var4.equals(var1)) {
				method559(0, "", arg0 + EnglishLocale.field913);
				return;
			}
			if (var3.field177 != null) {
				String var5 = NamespaceUtil.method743(var3.field177, namespace);
				if (var5 != null && var5.equals(var1)) {
					method559(0, "", arg0 + EnglishLocale.field913);
					return;
				}
			}
		}
		for (int var6 = 0; var6 < field2194; var6++) {
			IgnoreListEntry var7 = field2196[var6];
			String var8 = NamespaceUtil.method743(var7.field40, namespace);
			if (var8 != null && var8.equals(var1)) {
				method559(0, "", EnglishLocale.field1027 + arg0 + EnglishLocale.field1052);
				return;
			}
			if (var7.field39 != null) {
				String var9 = NamespaceUtil.method743(var7.field39, namespace);
				if (var9 != null && var9.equals(var1)) {
					method559(0, "", EnglishLocale.field1027 + arg0 + EnglishLocale.field1052);
					return;
				}
			}
		}
		if (NamespaceUtil.method743(localPlayer.field2796, namespace).equals(var1)) {
			method559(0, "", EnglishLocale.field1069);
		} else {
			out.pisaac1(203);
			out.p1(Packet.pjstrlen(arg0));
			out.pjstr(arg0);
		}
	}

	@ObfuscatedName("a.gz(Ljava/lang/String;ZS)V")
	public static final void method315(String arg0, boolean arg1) {
		if (arg0 == null) {
			return;
		}
		if (field2194 >= 100) {
			method559(0, "", EnglishLocale.field1020);
			return;
		}
		String var2 = NamespaceUtil.method743(arg0, namespace);
		if (var2 == null) {
			return;
		}
		for (int var3 = 0; var3 < field2194; var3++) {
			IgnoreListEntry var4 = field2196[var3];
			String var5 = NamespaceUtil.method743(var4.field40, namespace);
			if (var5 != null && var5.equals(var2)) {
				method559(0, "", arg0 + EnglishLocale.field1024);
				return;
			}
			if (var4.field39 != null) {
				String var6 = NamespaceUtil.method743(var4.field39, namespace);
				if (var6 != null && var6.equals(var2)) {
					method559(0, "", arg0 + EnglishLocale.field1024);
					return;
				}
			}
		}
		for (int var7 = 0; var7 < field2071; var7++) {
			FriendListEntry var8 = field2111[var7];
			String var9 = NamespaceUtil.method743(var8.field173, namespace);
			if (var9 != null && var9.equals(var2)) {
				method559(0, "", EnglishLocale.field1029 + arg0 + EnglishLocale.field1030);
				return;
			}
			if (var8.field177 != null) {
				String var10 = NamespaceUtil.method743(var8.field177, namespace);
				if (var10 != null && var10.equals(var2)) {
					method559(0, "", EnglishLocale.field1029 + arg0 + EnglishLocale.field1030);
					return;
				}
			}
		}
		if (NamespaceUtil.method743(localPlayer.field2796, namespace).equals(var2)) {
			method559(0, "", EnglishLocale.field1000);
		} else {
			out.pisaac1(231);
			out.p1(Packet.pjstrlen(arg0));
			out.pjstr(arg0);
		}
	}

	@ObfuscatedName("ao.gp(Ljava/lang/String;B)V")
	public static final void method560(String arg0) {
		if (arg0 == null) {
			return;
		}
		String var1 = NamespaceUtil.method743(arg0, namespace);
		if (var1 == null) {
			return;
		}
		for (int var2 = 0; var2 < field2071; var2++) {
			FriendListEntry var3 = field2111[var2];
			String var4 = var3.field173;
			String var5 = NamespaceUtil.method743(var4, namespace);
			boolean var6;
			if (arg0 == null || var4 == null) {
				var6 = false;
			} else if (arg0.startsWith("#") || var4.startsWith("#")) {
				var6 = arg0.equals(var4);
			} else {
				var6 = var1.equals(var5);
			}
			if (var6) {
				field2071--;
				for (int var7 = var2; var7 < field2071; var7++) {
					field2111[var7] = field2111[var7 + 1];
				}
				field1977 = field2117;
				out.pisaac1(41);
				out.p1(Packet.pjstrlen(arg0));
				out.pjstr(arg0);
				break;
			}
		}
	}

	@ObfuscatedName("af.gf(Ljava/lang/String;I)V")
	public static final void method742(String arg0) {
		if (!arg0.equals("")) {
			out.pisaac1(185);
			out.p1(Packet.pjstrlen(arg0));
			out.pjstr(arg0);
		}
	}

	@ObfuscatedName("aa.gv(I)V")
	public static final void method388() {
		out.pisaac1(185);
		out.p1(0);
	}

	@ObfuscatedName("s.gt(II)V")
	public static void method109(int arg0) {
		for (ServerKeyProperties var1 = (ServerKeyProperties) field2061.method1284(); var1 != null; var1 = (ServerKeyProperties) field2061.method1280()) {
			if ((long) arg0 == (var1.key >> 48 & 0xFFFFL)) {
				var1.unlink();
			}
		}
	}

	@ObfuscatedName("dn.gg(Leg;B)I")
	public static int method1512(IfType arg0) {
		ServerKeyProperties var1 = (ServerKeyProperties) field2061.get(((long) arg0.field1783 << 32) + (long) arg0.subid);
		return var1 == null ? arg0.field1842 : var1.field1900;
	}

	@ObfuscatedName("bo.gy(Leg;I)Z")
	public static boolean method868(IfType arg0) {
		if (field2092) {
			if (method1512(arg0) != 0) {
				return false;
			}
			if (arg0.field1785 == 0) {
				return false;
			}
		}
		return arg0.field1880;
	}

	@ObfuscatedName("ay.gu(Leg;II)Ljava/lang/String;")
	public static String method513(IfType arg0, int arg1) {
		int var2 = method1512(arg0);
		boolean var3 = (var2 >> arg1 + 1 & 0x1) != 0;
		if (!var3 && arg0.field1847 == null) {
			return null;
		} else if (arg0.field1844 == null || arg0.field1844.length <= arg1 || arg0.field1844[arg1] == null || arg0.field1844[arg1].trim().length() == 0) {
			return null;
		} else {
			return arg0.field1844[arg1];
		}
	}

	@ObfuscatedName("ap.gb(Leg;I)Ljava/lang/String;")
	public static String method422(IfType arg0) {
		if (WorldEntrySettings.method1350(method1512(arg0)) == 0) {
			return null;
		} else if (arg0.field1841 == null || arg0.field1841.trim().length() == 0) {
			return null;
		} else {
			return arg0.field1841;
		}
	}

	// inlined methods (un-inlined by hand!)

	public static void imethod1() {
		while (true) {
			LinkList var1 = Js5ProviderThread.field1208;
			Js5NetProviderRequest var2;
			synchronized (Js5ProviderThread.field1208) {
				var2 = (Js5NetProviderRequest) Js5ProviderThread.field1206.pop();
			}
			if (var2 == null) {
				return;
			}
			var2.field1773.method1468(var2.field1770, (int) var2.key, var2.field1771, false);
		}
	}

	public static void imethod2() {
		JavaKeyboardProvider var4 = JavaKeyboardProvider.field460;
		synchronized (var4) {
			JavaKeyboardProvider.idleCycles++;
			JavaKeyboardProvider.field479 = JavaKeyboardProvider.field424;
			if (JavaKeyboardProvider.field419 >= 0) {
				while (JavaKeyboardProvider.field445 != JavaKeyboardProvider.field419) {
					int var6 = JavaKeyboardProvider.field474[JavaKeyboardProvider.field445];
					JavaKeyboardProvider.field445 = JavaKeyboardProvider.field445 + 1 & 0x7F;
					if (var6 < 0) {
						JavaKeyboardProvider.actionKey[~var6] = false;
					} else {
						JavaKeyboardProvider.actionKey[var6] = true;
					}
				}
			} else {
				for (int var5 = 0; var5 < 112; var5++) {
					JavaKeyboardProvider.actionKey[var5] = false;
				}
				JavaKeyboardProvider.field419 = JavaKeyboardProvider.field445;
			}
			JavaKeyboardProvider.field424 = JavaKeyboardProvider.field480;
		}
	}

	public static void imethod3() {
		JavaMouseProvider var8 = JavaMouseProvider.field491;
		synchronized (JavaMouseProvider.field491) {
			JavaMouseProvider.mouseButton = JavaMouseProvider.field487;
			JavaMouseProvider.mouseX = JavaMouseProvider.field501;
			JavaMouseProvider.mouseY = JavaMouseProvider.field493;
			JavaMouseProvider.mouseClickButton = JavaMouseProvider.field485;
			JavaMouseProvider.mouseClickX = JavaMouseProvider.field494;
			JavaMouseProvider.mouseClickY = JavaMouseProvider.field495;
			JavaMouseProvider.mouseClickTime = JavaMouseProvider.field496;
			JavaMouseProvider.field485 = 0;
		}
	}

	public static void imethod4() {
		method722(false);
		field1972 = 0;
		boolean var11 = true;
		for (int var12 = 0; var12 < field1768.length; var12++) {
			if (field826[var12] != -1 && field1768[var12] == null) {
				field1768[var12] = field1270.getFile(field826[var12], 0);
				if (field1768[var12] == null) {
					var11 = false;
					field1972++;
				}
			}
			if (field1163[var12] != -1 && field186[var12] == null) {
				field186[var12] = field1270.getFile(field1163[var12], 0, mapKeys[var12]);
				if (field186[var12] == null) {
					var11 = false;
					field1972++;
				}
			}
		}
		if (!var11) {
			field2192 = 1;
			return;
		}
		field1974 = 0;
		boolean var13 = true;
		for (int var14 = 0; var14 < field1768.length; var14++) {
			byte[] var15 = field186[var14];
			if (var15 != null) {
				int var16 = (field801[var14] >> 8) * 64 - sceneBaseTileX;
				int var17 = (field801[var14] & 0xFF) * 64 - sceneBaseTileZ;
				if (field1978) {
					var16 = 10;
					var17 = 10;
				}
				var13 &= World.downloadLocations(var15, var16, var17);
			}
		}
		if (!var13) {
			field2192 = 2;
			return;
		}
		if (field2192 != 0) {
			method1789(EnglishLocale.field873 + TextUtil.br + TextUtil.openParen + 100 + "%" + TextUtil.closeParen, true);
		}
		method1351();
		method746();
		method1351();
		field1133.method564();
		method1351();
		System.gc();
		for (int var18 = 0; var18 < 4; var18++) {
			levelCollisionMap[var18].reset();
		}
		for (int var19 = 0; var19 < 4; var19++) {
			for (int var20 = 0; var20 < 104; var20++) {
				for (int var21 = 0; var21 < 104; var21++) {
					World.levelTileFlags[var19][var20][var21] = 0;
				}
			}
		}
		method1351();
		imethod5();
		int var22 = field1768.length;
		imethod6();
		method722(true);
		if (!field1978) {
			for (int var24 = 0; var24 < var22; var24++) {
				int var25 = (field801[var24] >> 8) * 64 - sceneBaseTileX;
				int var26 = (field801[var24] & 0xFF) * 64 - sceneBaseTileZ;
				byte[] var27 = field1768[var24];
				if (var27 != null) {
					method1351();
					World.loadGround(var27, var25, var26, field1473 * 8 - 48, field217 * 8 - 48, levelCollisionMap);
				}
			}
			for (int var28 = 0; var28 < var22; var28++) {
				int var29 = (field801[var28] >> 8) * 64 - sceneBaseTileX;
				int var30 = (field801[var28] & 0xFF) * 64 - sceneBaseTileZ;
				byte[] var31 = field1768[var28];
				if (var31 == null && field217 < 800) {
					method1351();
					World.stitchHeightmap(var29, var30, 64, 64);
				}
			}
			method722(true);
			for (int var32 = 0; var32 < var22; var32++) {
				byte[] var33 = field186[var32];
				if (var33 != null) {
					int var34 = (field801[var32] >> 8) * 64 - sceneBaseTileX;
					int var35 = (field801[var32] & 0xFF) * 64 - sceneBaseTileZ;
					method1351();
					World.loadLocations(var33, var34, var35, field1133, levelCollisionMap);
				}
			}
		}
		if (field1978) {
			for (int var36 = 0; var36 < 4; var36++) {
				method1351();
				for (int var37 = 0; var37 < 13; var37++) {
					for (int var38 = 0; var38 < 13; var38++) {
						boolean var39 = false;
						int var40 = field1979[var36][var37][var38];
						if (var40 != -1) {
							int var41 = var40 >> 24 & 0x3;
							int var42 = var40 >> 1 & 0x3;
							int var43 = var40 >> 14 & 0x3FF;
							int var44 = var40 >> 3 & 0x7FF;
							int var45 = (var43 / 8 << 8) + var44 / 8;
							for (int var46 = 0; var46 < field801.length; var46++) {
								if (field801[var46] == var45 && field1768[var46] != null) {
									World.loadGroundRegion(field1768[var46], var36, var37 * 8, var38 * 8, var41, (var43 & 0x7) * 8, (var44 & 0x7) * 8, var42, levelCollisionMap);
									var39 = true;
									break;
								}
							}
						}
						if (!var39) {
							imethod7(var36, var37 * 8, var38 * 8);
						}
					}
				}
			}
			for (int var54 = 0; var54 < 13; var54++) {
				for (int var55 = 0; var55 < 13; var55++) {
					int var56 = field1979[0][var54][var55];
					if (var56 == -1) {
						World.stitchHeightmap(var54 * 8, var55 * 8, 8, 8);
					}
				}
			}
			method722(true);
			for (int var57 = 0; var57 < 4; var57++) {
				method1351();
				for (int var58 = 0; var58 < 13; var58++) {
					for (int var59 = 0; var59 < 13; var59++) {
						int var60 = field1979[var57][var58][var59];
						if (var60 != -1) {
							int var61 = var60 >> 24 & 0x3;
							int var62 = var60 >> 1 & 0x3;
							int var63 = var60 >> 14 & 0x3FF;
							int var64 = var60 >> 3 & 0x7FF;
							int var65 = (var63 / 8 << 8) + var64 / 8;
							for (int var66 = 0; var66 < field801.length; var66++) {
								if (field801[var66] == var65 && field186[var66] != null) {
									World.method563(field186[var66], var57, var58 * 8, var59 * 8, var61, (var63 & 0x7) * 8, (var64 & 0x7) * 8, var62, field1133, levelCollisionMap);
									break;
								}
							}
						}
					}
				}
			}
		}
		method722(true);
		method746();
		method1351();
		World.build(field1133, levelCollisionMap);
		method722(true);
		int var67 = World.currentLevel;
		if (var67 > currentLevel) {
			var67 = currentLevel;
		}
		if (var67 < currentLevel - 1) {
			int var68 = currentLevel - 1;
		}
		if (lowMemory) {
			field1133.method565(World.currentLevel);
		} else {
			field1133.method565(0);
		}
		for (int var69 = 0; var69 < 104; var69++) {
			for (int var70 = 0; var70 < 104; var70++) {
				method1486(var69, var70);
			}
		}
		method1351();
		imethod8();
		LocType.modelCacheStatic.clear();
		if (GameShell.frame != null) {
			out.pisaac1(210);
			out.p4(1057001181);
		}
		if (!field1978) {
			int var72 = (field1473 - 6) / 8;
			int var73 = (field1473 + 6) / 8;
			int var74 = (field217 - 6) / 8;
			int var75 = (field217 + 6) / 8;
			for (int var76 = var72 - 1; var76 <= var73 + 1; var76++) {
				for (int var77 = var74 - 1; var77 <= var75 + 1; var77++) {
					if (var76 < var72 || var76 > var73 || var77 < var74 || var77 > var75) {
						field1270.requestDownload("m" + var76 + "_" + var77);
						field1270.requestDownload("l" + var76 + "_" + var77);
					}
				}
			}
		}
		method729(30);
		method1351();
		World.method771();
		out.pisaac1(197);
		GameShell.method770();
	}

	// probably lives in World
	public static void imethod5() {
		World.currentLevel = 99;
		World.levelTileUnderlayIds = new byte[4][104][104];
		World.levelTileOverlayIds = new byte[4][104][104];
		World.levelTileOverlayShape = new byte[4][104][104];
		World.levelTileOverlayRotation = new byte[4][104][104];
		World.levelOccludemap = new int[4][105][105];
		World.levelShademap = new byte[4][105][105];
		World.levelLightmap = new int[105][105];
		World.blendChroma = new int[104];
		World.blendSaturation = new int[104];
		World.blendLightness = new int[104];
		World.blendLuminance = new int[104];
		World.blendMagnitude = new int[104];
	}

	public static void imethod6() {
		for (PositionedSound var23 = (PositionedSound) PositionedSound.field1612.head(); var23 != null; var23 = (PositionedSound) PositionedSound.field1612.next()) {
			if (var23.field1603 != null) {
				field1460.method2175(var23.field1603);
				var23.field1603 = null;
			}
			if (var23.field1614 != null) {
				field1460.method2175(var23.field1614);
				var23.field1614 = null;
			}
		}
		PositionedSound.field1612.clear();
	}

	public static void imethod7(int var47, int var48, int var49) {
		for (int var50 = 0; var50 < 8; var50++) {
			for (int var51 = 0; var51 < 8; var51++) {
				World.levelHeightmap[var47][var48 + var50][var49 + var51] = 0;
			}
		}
		if (var48 > 0) {
			for (int var52 = 1; var52 < 8; var52++) {
				World.levelHeightmap[var47][var48][var49 + var52] = World.levelHeightmap[var47][var48 - 1][var49 + var52];
			}
		}
		if (var49 > 0) {
			for (int var53 = 1; var53 < 8; var53++) {
				World.levelHeightmap[var47][var48 + var53][var49] = World.levelHeightmap[var47][var48 + var53][var49 - 1];
			}
		}
		if (var48 > 0 && World.levelHeightmap[var47][var48 - 1][var49] != 0) {
			World.levelHeightmap[var47][var48][var49] = World.levelHeightmap[var47][var48 - 1][var49];
		} else if (var49 > 0 && World.levelHeightmap[var47][var48][var49 - 1] != 0) {
			World.levelHeightmap[var47][var48][var49] = World.levelHeightmap[var47][var48][var49 - 1];
		} else if (var48 > 0 && var49 > 0 && World.levelHeightmap[var47][var48 - 1][var49 - 1] != 0) {
			World.levelHeightmap[var47][var48][var49] = World.levelHeightmap[var47][var48 - 1][var49 - 1];
		}
	}

	public static void imethod8() {
		for (LocSpawned var71 = (LocSpawned) temporaryLocs.head(); var71 != null; var71 = (LocSpawned) temporaryLocs.next()) {
			if (var71.field1640 == -1) {
				var71.field1639 = 0;
				method1447(var71);
			} else {
				var71.unlink();
			}
		}
	}

	public static void imethod10() {
		out.pos = 0;
		in.pos = 0;
		packetType = -1;
		lastPacketType0 = -1;
		lastPacketType1 = -1;
		lastPacketType2 = -1;
		packetSize = 0;
		idleNetCycles = 0;
		systemUpdateTimer = 0;
		menuSize = 0;
		field2066 = false;
		minimapState = 0;
		flagSceneTileX = 0;
		for (int var6 = 0; var6 < players.length; var6++) {
			if (players[var6] != null) {
				players[var6].field2637 = -1;
			}
		}
		for (int var7 = 0; var7 < npcs.length; var7++) {
			if (npcs[var7] != null) {
				npcs[var7].field2637 = -1;
			}
		}
		imethod11();
		method729(30);
		for (int var8 = 0; var8 < 100; var8++) {
			field2175[var8] = true;
		}
	}

	public static void imethod11() {
		ClientInvCache.field1623 = new HashTable(32);
	}

	public static void imethod12() {
		if (systemUpdateTimer > 1) {
			systemUpdateTimer--;
		}
		if (idleTimeout > 0) {
			idleTimeout--;
		}
		if (field1968) {
			field1968 = false;
			tryReconnect();
			return;
		}
		for (int var78 = 0; var78 < 100 && read(); var78++) {
		}
        if (gameState != 30) {
            return;
        }
        ReflectionCheck.performCheck(out, 108);
        Object var384 = mouseTracking.lock;
        synchronized (var384) {
            if (!flagged) {
                mouseTracking.length = 0;
            } else if (JavaMouseProvider.mouseClickButton != 0 || mouseTracking.length >= 40) {
                out.pisaac1(72);
                out.p1(0);
                int var385 = out.pos;
                int var386 = 0;
                for (int var387 = 0; var387 < mouseTracking.length && out.pos - var385 < 240; var387++) {
                    var386++;
                    int var388 = mouseTracking.y[var387];
                    if (var388 < 0) {
                        var388 = 0;
                    } else if (var388 > 502) {
                        var388 = 502;
                    }
                    int var389 = mouseTracking.x[var387];
                    if (var389 < 0) {
                        var389 = 0;
                    } else if (var389 > 764) {
                        var389 = 764;
                    }
                    int var390 = var388 * 765 + var389;
                    if (mouseTracking.y[var387] == -1 && mouseTracking.x[var387] == -1) {
                        var389 = -1;
                        var388 = -1;
                        var390 = 524287;
                    }
                    if (lastWriteX != var389 || lastWriteY != var388) {
                        int var391 = var389 - lastWriteX;
                        lastWriteX = var389;
                        int var392 = var388 - lastWriteY;
                        lastWriteY = var388;
                        if (lastWriteDuplicates < 8 && var391 >= -32 && var391 <= 31 && var392 >= -32 && var392 <= 31) {
                            var391 += 32;
                            var392 += 32;
                            out.p2((lastWriteDuplicates << 12) + (var391 << 6) + var392);
                            lastWriteDuplicates = 0;
                        } else if (lastWriteDuplicates < 8) {
                            out.p3((lastWriteDuplicates << 19) + 8388608 + var390);
                            lastWriteDuplicates = 0;
                        } else {
                            out.p4((lastWriteDuplicates << 19) + -1073741824 + var390);
                            lastWriteDuplicates = 0;
                        }
                    } else if (lastWriteDuplicates < 2047) {
                        lastWriteDuplicates++;
                    }
                }
                out.psize1(out.pos - var385);
                if (var386 >= mouseTracking.length) {
                    mouseTracking.length = 0;
                } else {
                    mouseTracking.length -= var386;
                    for (int var393 = 0; var393 < mouseTracking.length; var393++) {
                        mouseTracking.x[var393] = mouseTracking.x[var386 + var393];
                        mouseTracking.y[var393] = mouseTracking.y[var386 + var393];
                    }
                }
            }
        }
        if (JavaMouseProvider.mouseClickButton != 0) {
            long var395 = (JavaMouseProvider.mouseClickTime - prevMousePressTime) / 50L;
            if (var395 > 4095L) {
                var395 = 4095L;
            }
            prevMousePressTime = JavaMouseProvider.mouseClickTime;
            int var397 = JavaMouseProvider.mouseClickY;
            if (var397 < 0) {
                var397 = 0;
            } else if (var397 > 502) {
                var397 = 502;
            }
            int var398 = JavaMouseProvider.mouseClickX;
            if (var398 < 0) {
                var398 = 0;
            } else if (var398 > 764) {
                var398 = 764;
            }
            int var399 = var397 * 765 + var398;
            byte var400 = 0;
            if (JavaMouseProvider.mouseClickButton == 2) {
                var400 = 1;
            }
            int var401 = (int) var395;
            out.pisaac1(161);
            out.p4_alt2((var400 << 19) + (var401 << 20) + var399);
        }
        if (sendCameraDelay > 0) {
            sendCameraDelay--;
        }
        if (JavaKeyboardProvider.actionKey[96] || JavaKeyboardProvider.actionKey[97] || JavaKeyboardProvider.actionKey[98] || JavaKeyboardProvider.actionKey[99]) {
            sendCamera = true;
        }
        if (sendCamera && sendCameraDelay <= 0) {
            sendCameraDelay = 20;
            sendCamera = false;
            out.pisaac1(79);
            out.p2_alt1(orbitCameraPitch);
            out.p2_alt2(orbitCameraYaw);
        }
        if (GameShell.focus && !focused) {
            focused = true;
            out.pisaac1(178);
            out.p1(1);
        }
        if (!GameShell.focus && focused) {
            focused = false;
            out.pisaac1(178);
            out.p1(0);
        }
		imethod28();
        if (gameState != 30) {
            return;
        }
		imethod29();
		imethod30();
        idleNetCycles++;
        if (idleNetCycles > 750) {
			tryReconnect();
			return;
        }
        updatePlayers();
        updateNpcs();
        updateEntityChats();
        sceneDelta++;
        if (crossMode != 0) {
            crossCycle += 20;
            if (crossCycle >= 400) {
                crossMode = 0;
            }
        }
        if (selectedArea != null) {
            selectedCycle++;
            if (selectedCycle >= 15) {
                method1238(selectedArea);
                selectedArea = null;
            }
        }
        if (objDragInterface != null) {
            method1238(objDragInterface);
            objDragCycles++;
            if (JavaMouseProvider.mouseX > objGrabX + 5 || JavaMouseProvider.mouseX < objGrabX - 5 || JavaMouseProvider.mouseY > objGrabY + 5 || JavaMouseProvider.mouseY < objGrabY - 5) {
                objGrabThreshold = true;
            }
            if (JavaMouseProvider.mouseButton == 0) {
                if (objGrabThreshold && objDragCycles >= 5) {
                    if (objDragInterface == hoveredSlotParent && objDragSlot != hoveredSlot) {
                        IfType var436 = objDragInterface;
                        byte var437 = 0;
                        if (bankArrangeMode == 1 && var436.clientCode == 206) {
                            var437 = 1;
                        }
                        if (var436.invSlotObjId[objDragSlot] <= 0) {
                            var437 = 0;
                        }
                        int var438 = method1512(var436);
                        boolean var439 = (var438 >> 29 & 0x1) != 0;
                        if (var439) {
                            int var440 = hoveredSlot;
                            int var441 = objDragSlot;
                            var436.invSlotObjId[var441] = var436.invSlotObjId[var440];
                            var436.invSlotObjCount[var441] = var436.invSlotObjCount[var440];
                            var436.invSlotObjId[var440] = -1;
                            var436.invSlotObjCount[var440] = 0;
                        } else if (var437 == 1) {
                            int var442 = hoveredSlot;
                            int var443 = objDragSlot;
                            while (var442 != var443) {
                                if (var442 > var443) {
                                    var436.method1799(var442 - 1, var442);
                                    var442--;
                                } else if (var442 < var443) {
                                    var436.method1799(var442 + 1, var442);
                                    var442++;
                                }
                            }
                        } else {
                            var436.method1799(objDragSlot, hoveredSlot);
                        }
                        out.pisaac1(2);
                        out.p4_alt2(objDragInterface.field1783);
                        out.p2_alt3(objDragSlot);
                        out.p1_alt1(var437);
                        out.p2_alt1(hoveredSlot);
                    }
                } else if ((mouseButtonsOption == 1 || isAddFriendOption(menuSize - 1)) && menuSize > 2) {
                    showContextMenu();
                } else if (menuSize > 0) {
                    useMenuOption(menuSize - 1);
                }
                selectedCycle = 10;
                JavaMouseProvider.mouseClickButton = 0;
                objDragInterface = null;
            }
        }
        IfType var444 = field37;
        IfType var445 = field654;
        field37 = null;
        field654 = null;
        field2098 = null;
        field2102 = false;
        field2126 = false;
        field2151 = 0;
        while (JavaKeyboardProvider.imethod2() && field2151 < 128) {
			field2153[field2151] = JavaKeyboardProvider.field114;
			field2152[field2151] = JavaKeyboardProvider.field1162;
			field2151++;
		}
		method1145(field2083, 0, 0, 765, 503, 0, 0);
		field2117++;

		// todo: revisit this code if something is broken -- tried to flatten the do { } while () blocks
		HookRequest var449;
		IfType var450;
		IfType var451;

		do {
			var449 = (HookRequest) hookRequestsTimer.pop();
			if (var449 == null) {
				break;
			}

			var450 = var449.component;
			if (var450.subid < 0) {
				break;
			}

			var451 = IfType.get(var450.layerid);
		} while (var451 == null || var451.subcomponents == null || var450.subid >= var451.subcomponents.length || var451.subcomponents[var450.subid] != var450);

		if (var449 != null) {
			ScriptRunner.runHook(var449);
		}

		do {
			var449 = (HookRequest) hookRequestsMouseStop.pop();
			if (var449 == null) {
				break;
			}

			var450 = var449.component;
			if (var450.subid < 0) {
				break;
			}

			var451 = IfType.get(var450.layerid);
		} while (var451 == null || var451.subcomponents == null || var450.subid >= var451.subcomponents.length || var451.subcomponents[var450.subid] != var450);

		if (var449 != null) {
			ScriptRunner.runHook(var449);
		}

		do {
			var449 = (HookRequest) hookRequests.pop();
			if (var449 == null) {
				break;
			}

			var450 = var449.component;
			if (var450.subid < 0) {
				break;
			}

			var451 = IfType.get(var450.layerid);
		} while (var451 == null || var451.subcomponents == null || var450.subid >= var451.subcomponents.length || var451.subcomponents[var450.subid] != var450);

		if (var449 != null) {
			ScriptRunner.runHook(var449);
		}

		if (field2094 != null) {
			imethod31();
		}
		if (World3D.field580 != -1) {
			int var473 = World3D.field580;
			int var474 = World3D.field629;
			boolean var475 = method1791(localPlayer.pathTileX[0], localPlayer.pathTileZ[0], var473, var474, true, 0, 0, 0, 0, 0, 0);
			World3D.field580 = -1;
			if (var475) {
				field2026 = JavaMouseProvider.mouseClickX;
				field2027 = JavaMouseProvider.mouseClickY;
				crossMode = 1;
				crossCycle = 0;
			}
		}
		imethod32();
		if (field37 != var444) {
			if (var444 != null) {
				method1238(var444);
			}
			if (field37 != null) {
				method1238(field37);
			}
		}
		if (field654 != var445 && field2076 == field1995) {
			if (var445 != null) {
				method1238(var445);
			}
			if (field654 != null) {
				method1238(field654);
			}
		}
		if (field654 == null) {
			if (field1995 > 0) {
				field1995--;
			}
		} else if (field1995 < field2076) {
			field1995++;
			if (field2076 == field1995) {
				method1238(field654);
			}
		}
		imethod33();
		if (cutscene) {
			applyCutscene();
		}
		for (int var504 = 0; var504 < 5; var504++) {
			int var10002 = cameraModifierCycle[var504]++;
		}
		int var505 = JavaMouseProvider.imethod3();
		int var507 = JavaKeyboardProvider.imethod3();
		if (var505 > 15000 && var507 > 15000) {
			idleTimeout = 250;
			JavaMouseProvider.method1845(14500);
			out.pisaac1(38);
		}
		cameraOffsetCycle++;
		if (cameraOffsetCycle > 500) {
			cameraOffsetCycle = 0;
			int var509 = (int) (Math.random() * 8.0D);
			if ((var509 & 0x1) == 1) {
				cameraAnticheatOffsetX += cameraOffsetXModifier;
			}
			if ((var509 & 0x2) == 2) {
				cameraAnticheatOffsetZ += cameraOffsetZModifier;
			}
			if ((var509 & 0x4) == 4) {
				cameraAnticheatAngle += cameraOffsetYawModifier;
			}
		}
		if (cameraAnticheatOffsetX < -50) {
			cameraOffsetXModifier = 2;
		}
		if (cameraAnticheatOffsetX > 50) {
			cameraOffsetXModifier = -2;
		}
		if (cameraAnticheatOffsetZ < -55) {
			cameraOffsetZModifier = 2;
		}
		if (cameraAnticheatOffsetZ > 55) {
			cameraOffsetZModifier = -2;
		}
		if (cameraAnticheatAngle < -40) {
			cameraOffsetYawModifier = 1;
		}
		if (cameraAnticheatAngle > 40) {
			cameraOffsetYawModifier = -1;
		}
		minimapOffsetCycle++;
		if (minimapOffsetCycle > 500) {
			minimapOffsetCycle = 0;
			int var510 = (int) (Math.random() * 8.0D);
			if ((var510 & 0x1) == 1) {
				minimapAnticheatAngle += minimapAngleModifier;
			}
			if ((var510 & 0x2) == 2) {
				minimapZoom += minimapZoomModifier;
			}
		}
		if (minimapAnticheatAngle < -60) {
			minimapAngleModifier = 2;
		}
		if (minimapAnticheatAngle > 60) {
			minimapAngleModifier = -2;
		}
		if (minimapZoom < -20) {
			minimapZoomModifier = 1;
		}
		if (minimapZoom > 10) {
			minimapZoomModifier = -1;
		}
		heartbeatTimer++;
		if (heartbeatTimer > 50) {
			out.pisaac1(228);
		}
		try {
			if (stream != null && out.pos > 0) {
				stream.write(out.data, 0, out.pos);
				out.pos = 0;
				heartbeatTimer = 0;
			}
		} catch (IOException var518) {
			tryReconnect();
		}
	}

	public static void tryReconnect() {
		if (idleTimeout > 0) {
			logout();
		} else {
			method729(40);
			field53 = stream;
			stream = null;
		}
	}

	public static boolean read() {
		if (stream == null) {
			return false;
		}

		try {
			int var80 = stream.available();
			if (var80 == 0) {
				return false;
			}
			if (packetType == -1) {
				stream.read(in.data, 0, 1);
				in.pos = 0;
				packetType = in.gisaac1();
				packetSize = ServerProt.sizes[packetType];
				var80--;
			}
			if (packetSize == -1) {
				if (var80 <= 0) {
					return false;
				}
				stream.read(in.data, 0, 1);
				packetSize = in.data[0] & 0xFF;
				var80--;
			}
			if (packetSize == -2) {
				if (var80 <= 1) {
					return false;
				}
				stream.read(in.data, 0, 2);
				in.pos = 0;
				packetSize = in.g2();
				var80 -= 2;
			}
			if (var80 < packetSize) {
				return false;
			}
			in.pos = 0;
			stream.read(in.data, 0, packetSize);
			idleNetCycles = 0;
			lastPacketType2 = lastPacketType1;
			lastPacketType1 = lastPacketType0;
			lastPacketType0 = packetType;
			if (packetType == 180) {
				int var81 = in.g2_alt3();
				int var82 = in.g4();
				VarProvider.field1211[var81] = var82;
				if (VarProvider.field1210[var81] != var82) {
					VarProvider.field1210[var81] = var82;
					method778(var81);
				}
				field2110[++field2084 - 1 & 0x1F] = var81;
				packetType = -1;
				return true;
			}
			if (packetType == 168) {
				String var83 = in.gjstr();
				String var91 = PixFont.method2844(JStringUtil.method54(imethod16(in)));
				method559(6, var83, var91);
				packetType = -1;
				return true;
			}
			if (packetType == 87) {
				int var92 = in.g4();
				ComponentPointer var93 = (ComponentPointer) field1918.get((long) var92);
				if (var93 != null) {
					method408(var93, true);
				}
				if (field2087 != null) {
					method1238(field2087);
					field2087 = null;
				}
				packetType = -1;
				return true;
			}
			if (packetType == 176) {
				int var94 = in.g2b_alt3();
				int var95 = in.g4();
				IfType var96 = IfType.get(var95);
				if (var96.field1863 != var94 || var94 == -1) {
					var96.field1863 = var94;
					var96.field1779 = 0;
					var96.field1890 = 0;
					method1238(var96);
				}
				packetType = -1;
				return true;
			}
			if (packetType == 100) {
				String var97 = in.gjstr();
				if (var97.endsWith(":tradereq:")) {
					String var98 = NamespaceUtil.method743(var97.substring(0, var97.indexOf(":")), namespace);
					boolean var99 = false;
					if (method761(var98)) {
						var99 = true;
					}
					if (!var99 && field2038 == 0) {
						method559(4, var98, EnglishLocale.field1002);
					}
				} else if (var97.endsWith(":duelreq:")) {
					String var100 = NamespaceUtil.method743(var97.substring(0, var97.indexOf(":")), namespace);
					boolean var101 = false;
					if (method761(var100)) {
						var101 = true;
					}
					if (!var101 && field2038 == 0) {
						method559(8, var100, EnglishLocale.field1003);
					}
				} else if (var97.endsWith(":chalreq:")) {
					String var102 = NamespaceUtil.method743(var97.substring(0, var97.indexOf(":")), namespace);
					boolean var103 = false;
					if (method761(var102)) {
						var103 = true;
					}
					if (!var103 && field2038 == 0) {
						String var104 = var97.substring(var97.indexOf(":") + 1, var97.length() - 9);
						method559(8, var102, var104);
					}
				} else if (var97.endsWith(":assistreq:")) {
					String var105 = NamespaceUtil.method743(var97.substring(0, var97.indexOf(":")), namespace);
					boolean var106 = false;
					if (method761(var105)) {
						var106 = true;
					}
					if (!var106 && field2038 == 0) {
						method559(10, var105, "");
					}
				} else if (var97.endsWith(":clan:")) {
					String var107 = var97.substring(0, var97.indexOf(":clan:"));
					method559(11, "", var107);
				} else if (var97.endsWith(":trade:")) {
					String var108 = var97.substring(0, var97.indexOf(":trade:"));
					if (field2038 == 0) {
						method559(12, "", var108);
					}
				} else if (var97.endsWith(":assist:")) {
					String var109 = var97.substring(0, var97.indexOf(":assist:"));
					if (field2038 == 0) {
						method559(13, "", var109);
					}
				} else {
					method559(0, "", var97);
				}
				packetType = -1;
				return true;
			}
			if (packetType == 89) {
				field1485 = in.g1();
				field351 = in.g1_alt3();
				packetType = -1;
				return true;
			}
			if (packetType == 246) {
				int var110 = in.g1_alt2();
				int var111 = in.g1_alt1();
				int var112 = in.g1_alt3();
				currentLevel = var112 >> 1;
				localPlayer.method2907(var111, var110, (var112 & 0x1) == 1);
				packetType = -1;
				return true;
			}
			if (packetType == 88) {
				int var113 = in.g2_alt1();
				byte var114 = in.g1b_alt3();
				VarProvider.field1211[var113] = var114;
				if (VarProvider.field1210[var113] != var114) {
					VarProvider.field1210[var113] = var114;
					method778(var113);
				}
				field2110[++field2084 - 1 & 0x1F] = var113;
				packetType = -1;
				return true;
			}
			if (packetType == 42) {
				if (field2083 != -1) {
					method725(field2083, 0);
				}
				packetType = -1;
				return true;
			}
			if (packetType == 205 || packetType == 106 || packetType == 245 || packetType == 215 || packetType == 20 || packetType == 32 || packetType == 207 || packetType == 173 || packetType == 6 || packetType == 7 || packetType == 154) {
				method724();
				packetType = -1;
				return true;
			}
			if (packetType == 41) {
				method93();
				field2080 = in.g1();
				field2119 = field2117;
				packetType = -1;
				return true;
			}
			if (packetType == 86) {
				String var115 = in.gjstr();
				long var116 = (long) in.g2();
				long var118 = (long) in.g3();
				int var120 = in.g1();
				long var121 = (var116 << 32) + var118;
				boolean var123 = false;
				for (int var124 = 0; var124 < 100; var124++) {
					if (field2148[var124] == var121) {
						var123 = true;
						break;
					}
				}
				if (method761(var115)) {
					var123 = true;
				}
				if (!var123 && field2038 == 0) {
					field2148[field2149] = var121;
					field2149 = (field2149 + 1) % 100;
					String var132 = PixFont.method2844(JStringUtil.method54(imethod16(in)));
					if (var120 == 2 || var120 == 3) {
						method559(7, TextUtil.imgTag(1) + var115, var132);
					} else if (var120 == 1) {
						method559(7, TextUtil.imgTag(0) + var115, var132);
					} else {
						method559(3, var115, var132);
					}
				}
				packetType = -1;
				return true;
			}
			if (packetType == 184) {
				int var133 = in.g1_alt2();
				int var134 = in.g2_alt2();
				int var135 = in.g4_alt1();
				ComponentPointer var136 = (ComponentPointer) field1918.get((long) var135);
				if (var136 != null) {
					method408(var136, var136.field1598 != var134);
				}
				method1147(var135, var134, var133);
				packetType = -1;
				return true;
			}
			if (packetType == 214) {
				// UPDATE_UID192
				in.pos += 28;
				if (in.checkcrc()) {
					SignLinkCacheFolder.method2298(in, in.pos - 28);
				}
				packetType = -1;
				return true;
			}
			if (packetType == 137) {
				field2145 = in.g1();
				field2146 = in.g1();
				packetType = -1;
				return true;
			}
			if (packetType == 224) {
				logout();
				packetType = -1;
				return false;
			}
			if (packetType == 147) {
				int var137 = in.g2_alt1();
				field2083 = var137;
				method57(var137);
				ScriptRunner.method6(field2083);
				for (int var138 = 0; var138 < 100; var138++) {
					field2175[var138] = true;
				}
				packetType = -1;
				return true;
			}
			if (packetType == 241) {
				int var139 = in.g4_alt1();
				field170 = GameShell.signlink.method438(var139);
				packetType = -1;
				return true;
			}
			if (packetType == 225) {
				cutscene = true;
				cutsceneDstLocalTileX = in.g1();
				cutsceneDstLocalTileZ = in.g1();
				cutsceneDstHeight = in.g2();
				cutsceneRotateSpeed = in.g1();
				cutsceneRotateAcceleration = in.g1();
				if (cutsceneRotateAcceleration >= 100) {
					int var140 = cutsceneDstLocalTileX * 128 + 64;
					int var141 = cutsceneDstLocalTileZ * 128 + 64;
					int var142 = getHeightmapY(var140, var141, currentLevel) - cutsceneDstHeight;
					int var143 = var140 - cameraX;
					int var144 = var142 - cameraY;
					int var145 = var141 - cameraZ;
					int var146 = (int) Math.sqrt((double) (var143 * var143 + var145 * var145));
					cameraPitch = (int) (Math.atan2((double) var144, (double) var146) * 325.949D) & 0x7FF;
					cameraYaw = (int) (Math.atan2((double) var143, (double) var145) * -325.949D) & 0x7FF;
					if (cameraPitch < 128) {
						cameraPitch = 128;
					}
					if (cameraPitch > 383) {
						cameraPitch = 383;
					}
				}
				packetType = -1;
				return true;
			}
			if (packetType == 234) {
				int var147 = in.g4_alt1();
				int var148 = in.g2();
				int var149 = var148 >> 10 & 0x1F;
				int var150 = var148 >> 5 & 0x1F;
				int var151 = var148 & 0x1F;
				int var152 = (var151 << 3) + (var149 << 19) + (var150 << 11);
				IfType var153 = IfType.get(var147);
				if (var153.field1822 != var152) {
					var153.field1822 = var152;
					method1238(var153);
				}
				packetType = -1;
				return true;
			}
			if (packetType == 85) {
				int var154 = in.g2b_alt2();
				int var155 = in.g2b_alt1();
				int var156 = in.g4_alt1();
				IfType var157 = IfType.get(var156);
				int var158 = var157.field1790 + var155;
				int var159 = var157.field1780 + var154;
				if (var157.field1788 != var158 || var157.field1810 != var159) {
					var157.field1788 = var158;
					var157.field1810 = var159;
					method1238(var157);
				}
				packetType = -1;
				return true;
			}
			if (packetType == 1) {
				method93();
				field2089 = in.g2b();
				field2119 = field2117;
				packetType = -1;
				return true;
			}
			if (packetType == 48) {
				int var160 = in.g4();
				int var161 = in.g2_alt3();
				if (var161 == 65535) {
					var161 = -1;
				}
				int var162 = in.g4_alt2();
				int var163 = in.g2_alt1();
				if (var163 == 65535) {
					var163 = -1;
				}
				for (int var164 = var163; var164 <= var161; var164++) {
					long var165 = ((long) var162 << 32) + (long) var164;
					Linkable var167 = field2061.get(var165);
					if (var167 != null) {
						var167.unlink();
					}
					field2061.put(new ServerKeyProperties(var160), var165);
				}
				packetType = -1;
				return true;
			}
			if (packetType == 73) {
				method1235(true);
				packetType = -1;
				return true;
			}
			if (packetType == 17) {
				int var168 = in.g1();
				int var169 = in.g1();
				int var170 = in.g1();
				int var171 = in.g1();
				field2184[var168] = true;
				field2187[var168] = var169;
				field2186[var168] = var170;
				field2163[var168] = var171;
				cameraModifierCycle[var168] = 0;
				packetType = -1;
				return true;
			}
			if (packetType == 113) {
				// PLAYER_INFO
				method1788();
				packetType = -1;
				return true;
			}
			if (packetType == 222) {
				int var172 = in.g4();
				int var173 = in.g2();
				if (var172 < -70000) {
					var173 += 32768;
				}
				IfType var174;
				if (var172 >= 0) {
					var174 = IfType.get(var172);
				} else {
					var174 = null;
				}
				while (in.pos < packetSize) {
					int var175 = in.gsmart();
					int var176 = in.g2();
					int var177 = 0;
					if (var176 != 0) {
						var177 = in.g1();
						if (var177 == 255) {
							var177 = in.g4();
						}
					}
					if (var174 != null && var175 >= 0 && var175 < var174.invSlotObjId.length) {
						var174.invSlotObjId[var175] = var176;
						var174.invSlotObjCount[var175] = var177;
					}
					ClientInvCache.method2901(var173, var175, var176 - 1, var177);
				}
				if (var174 != null) {
					method1238(var174);
				}
				method93();
				field2112[++field2050 - 1 & 0x1F] = var173 & 0x7FFF;
				packetType = -1;
				return true;
			}
			if (packetType == 39) {
				int var178 = packetSize + in.pos;
				int var179 = in.g2();
				int var180 = in.g2();
				if (field2083 != var179) {
					field2083 = var179;
					method57(field2083);
					ScriptRunner.method6(field2083);
					for (int var181 = 0; var181 < 100; var181++) {
						field2175[var181] = true;
					}
				}
				while (var180-- > 0) {
					int var182 = in.g4();
					int var183 = in.g2();
					int var184 = in.g1();
					ComponentPointer var185 = (ComponentPointer) field1918.get((long) var182);
					if (var185 != null && var185.field1598 != var183) {
						method408(var185, true);
						var185 = null;
					}
					if (var185 == null) {
						var185 = method1147(var182, var183, var184);
					}
					var185.field1599 = true;
				}
				for (ComponentPointer var186 = (ComponentPointer) field1918.method1284(); var186 != null; var186 = (ComponentPointer) field1918.method1280()) {
					if (var186.field1599) {
						var186.field1599 = false;
					} else {
						method408(var186, true);
					}
				}
				field2061 = new HashTable(512);
				while (in.pos < var178) {
					int var187 = in.g4();
					int var188 = in.g2();
					int var189 = in.g2();
					int var190 = in.g4();
					for (int var191 = var188; var191 <= var189; var191++) {
						long var192 = ((long) var187 << 32) + (long) var191;
						field2061.put(new ServerKeyProperties(var190), var192);
					}
				}
				packetType = -1;
				return true;
			}
			if (packetType == 21) {
				method1235(false);
				packetType = -1;
				return true;
			}
			if (packetType == 190) {
				minimapState = in.g1();
				packetType = -1;
				return true;
			}
			if (packetType == 84) {
				int var194 = in.g4_alt1();
				boolean var195 = in.g1_alt3() == 1;
				IfType var196 = IfType.get(var194);
				if (var196.field1880 != var195) {
					var196.field1880 = var195;
					method1238(var196);
				}
				packetType = -1;
				return true;
			}
			if (packetType == 129) {
				for (int var197 = 0; var197 < VarPlayerType.field2352; var197++) {
					VarPlayerType var198 = VarPlayerType.get(var197);
					if (var198 != null && var198.clientcode == 0) {
						VarProvider.field1211[var197] = 0;
						VarProvider.field1210[var197] = 0;
					}
				}
				method93();
				field2084 += 32;
				packetType = -1;
				return true;
			}
			if (packetType == 92) {
				String var199 = in.gjstr();
				Object[] var200 = new Object[var199.length() + 1];
				for (int var201 = var199.length() - 1; var201 >= 0; var201--) {
					if (var199.charAt(var201) == 's') {
						var200[var201 + 1] = in.gjstr();
					} else {
						var200[var201 + 1] = Integer.valueOf(in.g4());
					}
				}
				var200[0] = Integer.valueOf(in.g4());
				HookRequest var202 = new HookRequest();
				var202.field1588 = var200;
				ScriptRunner.runHook(var202);
				packetType = -1;
				return true;
			}
			if (packetType == 67) {
				field1485 = in.g1_alt1();
				field351 = in.g1_alt3();
				for (int var203 = field351; var203 < field351 + 8; var203++) {
					for (int var204 = field1485; var204 < field1485 + 8; var204++) {
						if (levelObjStacks[currentLevel][var203][var204] != null) {
							levelObjStacks[currentLevel][var203][var204] = null;
							method1486(var203, var204);
						}
					}
				}
				for (LocSpawned var205 = (LocSpawned) temporaryLocs.head(); var205 != null; var205 = (LocSpawned) temporaryLocs.next()) {
					if (var205.field1633 >= field351 && var205.field1633 < field351 + 8 && var205.field1632 >= field1485 && var205.field1632 < field1485 + 8 && currentLevel == var205.field1638) {
						var205.field1640 = 0;
					}
				}
				packetType = -1;
				return true;
			}
			if (packetType == 66) {
				int var206 = in.g4_alt2();
				int var207 = in.g2_alt2();
				IfType var208 = IfType.get(var206);
				if (var208.field1815 != 2 || var208.field1816 != var207) {
					var208.field1815 = 2;
					var208.field1816 = var207;
					method1238(var208);
				}
				packetType = -1;
				return true;
			}
			if (packetType == 208) {
				method93();
				int var209 = in.g1_alt1();
				int var210 = in.g1_alt1();
				int var211 = in.g4();
				field2062[var210] = var211;
				field2060[var210] = var209;
				field1960[var210] = 1;
				for (int var212 = 0; var212 < 98; var212++) {
					if (var211 >= PlayerStats.levelExperience[var212]) {
						field1960[var210] = var212 + 2;
					}
				}
				field1999[++field1982 - 1 & 0x1F] = var210;
				packetType = -1;
				return true;
			}
			if (packetType == 95) {
				field2171 = 1;
				field1977 = field2117;
				packetType = -1;
				return true;
			}
			if (packetType == 164) {
				String var213 = in.gjstr();
				int var214 = in.g1_alt1();
				int var215 = in.g1_alt3();
				if (var214 >= 1 && var214 <= 8) {
					if (var213.equalsIgnoreCase("null")) {
						var213 = null;
					}
					field2053[var214 - 1] = var213;
					field2054[var214 - 1] = var215 == 0;
				}
				packetType = -1;
				return true;
			}
			if (packetType == 117) {
				int var216 = in.g4_alt1();
				IfType var217 = IfType.get(var216);
				for (int var218 = 0; var218 < var217.invSlotObjId.length; var218++) {
					var217.invSlotObjId[var218] = -1;
					var217.invSlotObjId[var218] = 0;
				}
				method1238(var217);
				packetType = -1;
				return true;
			}
			if (packetType == 172) {
				int var219 = in.g2_alt2();
				ClientInvCache.method55(var219);
				field2112[++field2050 - 1 & 0x1F] = var219 & 0x7FFF;
				packetType = -1;
				return true;
			}
			if (packetType == 70) {
				int var220 = in.g1();
				ChatFilterPrivacy[] var221 = ChatFilterPrivacy.values();
				int var222 = 0;
				ChatFilterPrivacy var224;
				while (true) {
					if (var222 >= var221.length) {
						var224 = null;
						break;
					}
					ChatFilterPrivacy var223 = var221[var222];
					if (var223.field1107 == var220) {
						var224 = var223;
						break;
					}
					var222++;
				}
				field680 = var224;
				packetType = -1;
				return true;
			}
			if (packetType == 140) {
				String var225 = in.gjstr();
				int var226 = in.g2();
				byte var227 = in.g1b();
				boolean var228 = false;
				if (var227 == -128) {
					var228 = true;
				}
				if (var228) {
					if (field1220 == 0) {
						packetType = -1;
						return true;
					}
					boolean var229 = false;
					int var230;
					for (var230 = 0; var230 < field1220 && (!field1774[var230].field1617.equals(var225) || field1774[var230].field1620 != var226); var230++) {
					}
					if (var230 < field1220) {
						while (var230 < field1220 - 1) {
							field1774[var230] = field1774[var230 + 1];
							var230++;
						}
						field1220--;
						field1774[field1220] = null;
					}
				} else {
					in.gjstr();
					ClanMember var231 = new ClanMember();
					var231.field1617 = var225;
					var231.field1618 = NamespaceUtil.method743(var231.field1617, namespace);
					var231.field1620 = var226;
					var231.field1619 = var227;
					int var232;
					for (var232 = field1220 - 1; var232 >= 0; var232--) {
						int var233 = field1774[var232].field1618.compareTo(var231.field1617);
						if (var233 == 0) {
							field1774[var232].field1620 = var226;
							field1774[var232].field1619 = var227;
							if (var225.equals(localPlayer.field2796)) {
								field1217 = var227;
							}
							field2185 = field2117;
							packetType = -1;
							return true;
						}
						if (var233 < 0) {
							break;
						}
					}
					if (field1220 >= field1774.length) {
						packetType = -1;
						return true;
					}
					for (int var234 = field1220 - 1; var234 > var232; var234--) {
						field1774[var234 + 1] = field1774[var234];
					}
					if (field1220 == 0) {
						field1774 = new ClanMember[100];
					}
					field1774[var232 + 1] = var231;
					field1220++;
					if (var225.equals(localPlayer.field2796)) {
						field1217 = var227;
					}
				}
				field2185 = field2117;
				packetType = -1;
				return true;
			}
			if (packetType == 25) {
				imethod15(in, packetSize);
				packetType = -1;
				return true;
			}
			if (packetType == 161) {
				flagSceneTileX = 0;
				packetType = -1;
				return true;
			}
			if (packetType == 160) {
				field1920 = in.g1();
				if (field1920 == 1) {
					field1931 = in.g2();
				}
				if (field1920 >= 2 && field1920 <= 6) {
					if (field1920 == 2) {
						field1936 = 64;
						field1937 = 64;
					}
					if (field1920 == 3) {
						field1936 = 0;
						field1937 = 64;
					}
					if (field1920 == 4) {
						field1936 = 128;
						field1937 = 64;
					}
					if (field1920 == 5) {
						field1936 = 64;
						field1937 = 0;
					}
					if (field1920 == 6) {
						field1936 = 64;
						field1937 = 128;
					}
					field1920 = 2;
					field1933 = in.g2();
					field1934 = in.g2();
					field1935 = in.g1();
				}
				if (field1920 == 10) {
					field1932 = in.g2();
				}
				packetType = -1;
				return true;
			}
			if (packetType == 217) {
				int var258 = in.g4_alt1();
				int var259 = in.g2_alt3();
				int var260 = in.g2_alt3();
				IfType var261 = IfType.get(var258);
				var261.field1827 = (var259 << 16) + var260;
				packetType = -1;
				return true;
			}
			if (packetType == 102) {
				int var262 = in.g4();
				int var263 = in.g2_alt2();
				if (var263 == 65535) {
					var263 = -1;
				}
				int var264 = in.g4_alt1();
				IfType var265 = IfType.get(var262);
				if (var265.field1782) {
					var265.field1791 = var263;
					var265.field1888 = var264;
					ObjType var267 = ObjType.get(var263);
					var265.field1848 = var267.xan2d;
					var265.field1824 = var267.yan2d;
					var265.field1817 = var267.zan2d;
					var265.field1821 = var267.xof2d;
					var265.field1798 = var267.yof2d;
					var265.field1826 = var267.zoom2d;
					if (var265.field1792 > 0) {
						var265.field1826 = var265.field1826 * 32 / var265.field1792;
					}
					method1238(var265);
				} else {
					if (var263 == -1) {
						var265.field1815 = 0;
						packetType = -1;
						return true;
					}
					ObjType var266 = ObjType.get(var263);
					var265.field1815 = 4;
					var265.field1816 = var263;
					var265.field1848 = var266.xan2d;
					var265.field1824 = var266.yan2d;
					var265.field1826 = var266.zoom2d * 100 / var264;
					method1238(var265);
				}
				packetType = -1;
				return true;
			}
			if (packetType == 57) {
				String var268 = in.gjstr();
				long var269 = in.g8();
				long var271 = (long) in.g2();
				long var273 = (long) in.g3();
				int var275 = in.g1();
				long var276 = (var271 << 32) + var273;
				boolean var278 = false;
				for (int var279 = 0; var279 < 100; var279++) {
					if (field2148[var279] == var276) {
						var278 = true;
						break;
					}
				}
				if (var275 <= 1 && method761(var268)) {
					var278 = true;
				}
				if (!var278 && field2038 == 0) {
					field2148[field2149] = var276;
					field2149 = (field2149 + 1) % 100;
					String var287 = PixFont.method2844(JStringUtil.method54(imethod16(in)));
					if (var275 == 2 || var275 == 3) {
						method922(9, TextUtil.imgTag(1) + var268, var287, JString.method782(var269));
					} else if (var275 == 1) {
						method922(9, TextUtil.imgTag(0) + var268, var287, JString.method782(var269));
					} else {
						method922(9, var268, var287, JString.method782(var269));
					}
				}
				packetType = -1;
				return true;
			}
			if (packetType == 80) {
				while (in.pos < packetSize) {
					boolean var288 = in.g1() == 1;
					String var289 = in.gjstr();
					String var290 = in.gjstr();
					int var291 = in.g2();
					int var292 = in.g1();
					int var293 = in.g1();
					boolean var294 = (var293 & 0x2) != 0;
					boolean var295 = (var293 & 0x1) != 0;
					if (var291 > 0) {
						in.gjstr();
						in.g1();
						in.g4();
					}
					in.gjstr();
					for (int var296 = 0; var296 < field2071; var296++) {
						FriendListEntry var297 = field2111[var296];
						if (var288) {
							if (var290.equals(var297.field173)) {
								var297.field173 = var289;
								var297.field177 = var290;
								var289 = null;
								break;
							}
						} else if (var289.equals(var297.field173)) {
							if (var297.field174 != var291) {
								boolean var298 = true;
								for (TimestampMessage var299 = (TimestampMessage) field2193.method1268(); var299 != null; var299 = (TimestampMessage) field2193.method1274()) {
									if (var299.field1584.equals(var289)) {
										if (var291 != 0 && var299.field1583 == 0) {
											var299.method1322();
											var298 = false;
										} else if (var291 == 0 && var299.field1583 != 0) {
											var299.method1322();
											var298 = false;
										}
									}
								}
								if (var298) {
									field2193.method1267(new TimestampMessage(var289, var291));
								}
								var297.field174 = var291;
							}
							var297.field177 = var290;
							var297.field175 = var292;
							var297.field172 = var294;
							var297.field176 = var295;
							var289 = null;
							break;
						}
					}
					if (var289 != null && field2071 < 200) {
						FriendListEntry var300 = new FriendListEntry();
						field2111[field2071] = var300;
						var300.field173 = var289;
						var300.field177 = var290;
						var300.field174 = var291;
						var300.field175 = var292;
						var300.field172 = var294;
						var300.field176 = var295;
						field2071++;
					}
				}
				field2171 = 2;
				field1977 = field2117;
				boolean var301 = false;
				int var302 = field2071;
				while (var302 > 0) {
					boolean var303 = true;
					var302--;
					for (int var304 = 0; var304 < var302; var304++) {
						boolean var305 = false;
						FriendListEntry var306 = field2111[var304];
						FriendListEntry var307 = field2111[var304 + 1];
						if (worldid != var306.field174 && worldid == var307.field174) {
							var305 = true;
						}
						if (!var305 && var306.field174 == 0 && var307.field174 != 0) {
							var305 = true;
						}
						if (!var305 && !var306.field172 && var307.field172) {
							var305 = true;
						}
						if (!var305 && !var306.field176 && var307.field176) {
							var305 = true;
						}
						if (var305) {
							FriendListEntry var308 = field2111[var304];
							field2111[var304] = field2111[var304 + 1];
							field2111[var304 + 1] = var308;
							var303 = false;
						}
					}
					if (var303) {
						break;
					}
				}
				packetType = -1;
				return true;
			}
			if (packetType == 120) {
				field2185 = field2117;
				if (packetSize == 0) {
					field1955 = null;
					field2155 = null;
					field1220 = 0;
					field1774 = null;
					packetType = -1;
					return true;
				}
				field2155 = in.gjstr();
				long var309 = in.g8();
				field1955 = JString.method768(var309);
				field1511 = in.g1b();
				int var311 = in.g1();
				if (var311 == 255) {
					packetType = -1;
					return true;
				}
				field1220 = var311;
				ClanMember[] var312 = new ClanMember[100];
				for (int var313 = 0; var313 < field1220; var313++) {
					var312[var313] = new ClanMember();
					var312[var313].field1617 = in.gjstr();
					var312[var313].field1618 = NamespaceUtil.method743(var312[var313].field1617, namespace);
					var312[var313].field1620 = in.g2();
					var312[var313].field1619 = in.g1b();
					in.gjstr();
					if (var312[var313].field1617.equals(localPlayer.field2796)) {
						field1217 = var312[var313].field1619;
					}
				}
				boolean var314 = false;
				int var315 = field1220;
				while (var315 > 0) {
					boolean var316 = true;
					var315--;
					for (int var317 = 0; var317 < var315; var317++) {
						if (var312[var317].field1618.compareTo(var312[var317 + 1].field1618) > 0) {
							ClanMember var318 = var312[var317];
							var312[var317] = var312[var317 + 1];
							var312[var317 + 1] = var318;
							var316 = false;
						}
					}
					if (var316) {
						break;
					}
				}
				field1774 = var312;
				packetType = -1;
				return true;
			}
			if (packetType == 29) {
				int var319 = in.g4();
				int var320 = in.g2();
				if (var319 < -70000) {
					var320 += 32768;
				}
				IfType var321;
				if (var319 >= 0) {
					var321 = IfType.get(var319);
				} else {
					var321 = null;
				}
				if (var321 != null) {
					for (int var322 = 0; var322 < var321.invSlotObjId.length; var322++) {
						var321.invSlotObjId[var322] = 0;
						var321.invSlotObjCount[var322] = 0;
					}
				}
				ClientInvCache var323 = (ClientInvCache) ClientInvCache.field1623.get((long) var320);
				if (var323 != null) {
					for (int var324 = 0; var324 < var323.field1622.length; var324++) {
						var323.field1622[var324] = -1;
						var323.field1624[var324] = 0;
					}
				}
				int var325 = in.g2();
				for (int var326 = 0; var326 < var325; var326++) {
					int var327 = in.g1_alt3();
					if (var327 == 255) {
						var327 = in.g4_alt1();
					}
					int var328 = in.g2_alt1();
					if (var321 != null && var326 < var321.invSlotObjId.length) {
						var321.invSlotObjId[var326] = var328;
						var321.invSlotObjCount[var326] = var327;
					}
					ClientInvCache.method2901(var320, var326, var328 - 1, var327);
				}
				if (var321 != null) {
					method1238(var321);
				}
				method93();
				field2112[++field2050 - 1 & 0x1F] = var320 & 0x7FFF;
				packetType = -1;
				return true;
			}
			if (packetType == 131) {
				field1485 = in.g1_alt2();
				field351 = in.g1_alt1();
				while (in.pos < packetSize) {
					packetType = in.g1();
					method724();
				}
				packetType = -1;
				return true;
			}
			if (packetType == 169) {
				cutscene = true;
				cutsceneSrcLocalTileX = in.g1();
				cutsceneSrcLocalTileZ = in.g1();
				cutsceneSrcHeight = in.g2();
				cutsceneMoveSpeed = in.g1();
				cutsceneMoveAcceleration = in.g1();
				if (cutsceneMoveAcceleration >= 100) {
					cameraX = cutsceneSrcLocalTileX * 128 + 64;
					cameraZ = cutsceneSrcLocalTileZ * 128 + 64;
					cameraY = getHeightmapY(cameraX, cameraZ, currentLevel) - cutsceneSrcHeight;
				}
				packetType = -1;
				return true;
			}
			if (packetType == 72) {
				for (int var329 = 0; var329 < players.length; var329++) {
					if (players[var329] != null) {
						players[var329].field2643 = -1;
					}
				}
				for (int var330 = 0; var330 < npcs.length; var330++) {
					if (npcs[var330] != null) {
						npcs[var330].field2643 = -1;
					}
				}
				packetType = -1;
				return true;
			}
			if (packetType == 50) {
				int var331 = in.g4_alt3();
				int var332 = in.g2();
				IfType var333 = IfType.get(var331);
				if (var333 != null && var333.field1785 == 0) {
					if (var332 > var333.field1799 - var333.field1793) {
						var332 = var333.field1799 - var333.field1793;
					}
					if (var332 < 0) {
						var332 = 0;
					}
					if (var333.field1797 != var332) {
						var333.field1797 = var332;
						method1238(var333);
					}
				}
				packetType = -1;
				return true;
			}
			if (packetType == 26) {
				int var334 = in.g2_alt2();
				int var335 = in.g2();
				int var336 = in.g4_alt1();
				int var337 = in.g2();
				IfType var338 = IfType.get(var336);
				if (var338.field1848 != var334 || var338.field1824 != var337 || var338.field1826 != var335) {
					var338.field1848 = var334;
					var338.field1824 = var337;
					var338.field1826 = var335;
					method1238(var338);
				}
				packetType = -1;
				return true;
			}
			if (packetType == 97) {
				systemUpdateTimer = in.g2_alt2() * 30;
				field2119 = field2117;
				packetType = -1;
				return true;
			}
			if (packetType == 251) {
				int var339 = in.g2();
				int var340 = in.g4_alt2();
				IfType var341 = IfType.get(var340);
				if (var341.field1815 != 1 || var341.field1816 != var339) {
					var341.field1815 = 1;
					var341.field1816 = var339;
					method1238(var341);
				}
				packetType = -1;
				return true;
			}
			if (packetType == 229) {
				int var342 = in.g2();
				int var343 = in.g1();
				int var344 = in.g2();
				if (field1952 != 0 && var343 != 0 && field2176 < 50) {
					field2177[field2176] = var342;
					field2006[field2176] = var343;
					field2179[field2176] = var344;
					field2181[field2176] = null;
					field2180[field2176] = 0;
					field2176++;
				}
				packetType = -1;
				return true;
			}
			if (packetType == 142) {
				while (in.pos < packetSize) {
					int var348 = in.g1();
					boolean var349 = (var348 & 0x1) == 1;
					String var350 = in.gjstr();
					String var351 = in.gjstr();
					in.gjstr();
					for (int var352 = 0; var352 < field2194; var352++) {
						IgnoreListEntry var353 = field2196[var352];
						if (var349) {
							if (var351.equals(var353.field40)) {
								var353.field40 = var350;
								var353.field39 = var351;
								var350 = null;
								break;
							}
						} else if (var350.equals(var353.field40)) {
							var353.field40 = var350;
							var353.field39 = var351;
							var350 = null;
							break;
						}
					}
					if (var350 != null && field2194 < 100) {
						IgnoreListEntry var354 = new IgnoreListEntry();
						field2196[field2194] = var354;
						var354.field40 = var350;
						var354.field39 = var351;
						field2194++;
					}
				}
				field1977 = field2117;
				packetType = -1;
				return true;
			}
			if (packetType == 171) {
				int var355 = in.g4_alt3();
				IfType var356 = IfType.get(var355);
				var356.field1815 = 3;
				var356.field1816 = localPlayer.field2786.method1176();
				method1238(var356);
				packetType = -1;
				return true;
			}
			if (packetType == 198) {
				cutscene = false;
				for (int var357 = 0; var357 < 5; var357++) {
					field2184[var357] = false;
				}
				packetType = -1;
				return true;
			}
			if (packetType == 211) {
				int var358 = in.g2_alt1();
				if (var358 == 65535) {
					var358 = -1;
				}
				method1232(var358);
				packetType = -1;
				return true;
			}
			if (packetType == 53) {
				int var359 = in.g2_alt2();
				if (var359 == 65535) {
					var359 = -1;
				}
				int var360 = in.g3_alt2();
				if (field2169 != 0 && var359 != -1) {
					MidiPlayer.method1125(field1515, var359, 0, field2169, false);
					field2189 = true;
				}
				packetType = -1;
				return true;
			}
			if (packetType == 111) {
				for (int var361 = 0; var361 < VarProvider.field1210.length; var361++) {
					if (VarProvider.field1211[var361] != VarProvider.field1210[var361]) {
						VarProvider.field1210[var361] = VarProvider.field1211[var361];
						method778(var361);
						field2110[++field2084 - 1 & 0x1F] = var361;
					}
				}
				packetType = -1;
				return true;
			}
			if (packetType == 167) {
				// NPC_INFO
				imethod13();
				packetType = -1;
				return true;
			}
			if (packetType == 197) {
				String var377 = in.gjstr();
				int var378 = in.g4_alt3();
				IfType var379 = IfType.get(var378);
				if (!var377.equals(var379.field1830)) {
					var379.field1830 = var377;
					method1238(var379);
				}
				packetType = -1;
				return true;
			}
			JagException.report("T1 - " + packetType + "," + lastPacketType1 + "," + lastPacketType2 + " - " + packetSize, null);
			logout();
		} catch (IOException var525) {
			tryReconnect();
		} catch (Exception var526) {
			String var382 = "T2 - " + packetType + "," + lastPacketType1 + "," + lastPacketType2 + " - " + packetSize + "," + (sceneBaseTileX + localPlayer.pathTileX[0]) + "," + (sceneBaseTileZ + localPlayer.pathTileZ[0]) + " - ";
			for (int var383 = 0; var383 < packetSize && var383 < 50; var383++) {
				var382 += in.data[var383] + ",";
			}
			JagException.report(var382, var526);
			logout();
		}

		return true;
	}

	public static void imethod13() {
		field2035 = 0;
		field2044 = 0;
		imethod14();
		method1461();
		method562();
		for (int var374 = 0; var374 < field2035; var374++) {
			int var375 = field2198[var374];
			if (loopCycle != npcs[var375].field2660) {
				npcs[var375].field2804 = null;
				npcs[var375] = null;
			}
		}
		if (packetSize != in.pos) {
			throw new RuntimeException("gnp1 pos:" + in.pos + " psize:" + packetSize);
		}
		for (int var376 = 0; var376 < npcCount; var376++) {
			if (npcs[field1956[var376]] == null) {
				throw new RuntimeException("gnp2 pos:" + var376 + " size:" + npcCount);
			}
		}
	}

	public static void imethod14() {
		in.accessBits();
		int var362 = in.gBit(8);
		if (var362 < npcCount) {
			for (int var363 = var362; var363 < npcCount; var363++) {
				field2198[++field2035 - 1] = field1956[var363];
			}
		}
		if (var362 > npcCount) {
			throw new RuntimeException("gnpov1");
		}
		npcCount = 0;
		for (int var364 = 0; var364 < var362; var364++) {
			int var365 = field1956[var364];
			NpcEntity var366 = npcs[var365];
			int var367 = in.gBit(1);
			if (var367 == 0) {
				field1956[++npcCount - 1] = var365;
				var366.field2660 = loopCycle;
			} else {
				int var368 = in.gBit(2);
				if (var368 == 0) {
					field1956[++npcCount - 1] = var365;
					var366.field2660 = loopCycle;
					field2045[++field2044 - 1] = var365;
				} else if (var368 == 1) {
					field1956[++npcCount - 1] = var365;
					var366.field2660 = loopCycle;
					int var369 = in.gBit(3);
					var366.method2908(var369, false);
					int var370 = in.gBit(1);
					if (var370 == 1) {
						field2045[++field2044 - 1] = var365;
					}
				} else if (var368 == 2) {
					field1956[++npcCount - 1] = var365;
					var366.field2660 = loopCycle;
					int var371 = in.gBit(3);
					var366.method2908(var371, true);
					int var372 = in.gBit(3);
					var366.method2908(var372, true);
					int var373 = in.gBit(1);
					if (var373 == 1) {
						field2045[++field2044 - 1] = var365;
					}
				} else if (var368 == 3) {
					field2198[++field2035 - 1] = var365;
				}
			}
		}
	}

	public static void imethod15(PacketBit var235, int var236) {
		ReflectionCheckNode var237 = new ReflectionCheckNode();
		var237.field1905 = var235.g1();
		var237.field1906 = var235.g4();
		var237.field1910 = new int[var237.field1905];
		var237.field1907 = new int[var237.field1905];
		var237.field1904 = new Field[var237.field1905];
		var237.field1908 = new int[var237.field1905];
		var237.field1911 = new Method[var237.field1905];
		var237.field1909 = new byte[var237.field1905][][];
		for (int var238 = 0; var238 < var237.field1905; var238++) {
			try {
				int var239 = var235.g1();
				if (var239 == 0 || var239 == 1 || var239 == 2) {
					String var240 = new String(var235.gjstr());
					String var241 = new String(var235.gjstr());
					int var242 = 0;
					if (var239 == 1) {
						var242 = var235.g4();
					}
					var237.field1910[var238] = var239;
					var237.field1908[var238] = var242;
					var237.field1904[var238] = ReflectionCheck.method51(var240).getDeclaredField(var241);
				} else if (var239 == 3 || var239 == 4) {
					String var243 = new String(var235.gjstr());
					String var244 = new String(var235.gjstr());
					int var245 = var235.g1();
					String[] var246 = new String[var245];
					for (int var247 = 0; var247 < var245; var247++) {
						var246[var247] = new String(var235.gjstr());
					}
					byte[][] var248 = new byte[var245][];
					if (var239 == 3) {
						for (int var249 = 0; var249 < var245; var249++) {
							int var250 = var235.g4();
							var248[var249] = new byte[var250];
							var235.gdata(var248[var249], 0, var250);
						}
					}
					var237.field1910[var238] = var239;
					Class[] var251 = new Class[var245];
					for (int var252 = 0; var252 < var245; var252++) {
						var251[var252] = ReflectionCheck.method51(var246[var252]);
					}
					var237.field1911[var238] = ReflectionCheck.method51(var243).getDeclaredMethod(var244, var251);
					var237.field1909[var238] = var248;
				}
			} catch (ClassNotFoundException var520) {
				var237.field1907[var238] = -1;
			} catch (SecurityException var521) {
				var237.field1907[var238] = -2;
			} catch (NullPointerException var522) {
				var237.field1907[var238] = -3;
			} catch (Exception var523) {
				var237.field1907[var238] = -4;
			} catch (Throwable var524) {
				var237.field1907[var238] = -5;
			}
		}
		ReflectionCheck.field1513.push(var237);
	}

	public static String imethod16(PacketBit var84) {
		try {
			int var85 = var84.gsmart();
			if (var85 > 32767) {
				var85 = 32767;
			}
			byte[] var86 = new byte[var85];
			var84.pos += WordPack.huffman.method818(var84.data, var84.pos, var86, 0, var85);
			return Cp1252.method2397(var86, 0, var85);
		} catch (Exception var515) {
			return "Cabbage";
		}
	}

	public static void imethod17() {
		in.accessBits();
		int var0 = in.gBit(1);
		if (var0 == 0) {
			return;
		}
		int var1 = in.gBit(2);
		if (var1 == 0) {
			field2045[++field2044 - 1] = 2047;
		} else if (var1 == 1) {
			int var2 = in.gBit(3);
			localPlayer.method2908(var2, false);
			int var3 = in.gBit(1);
			if (var3 == 1) {
				field2045[++field2044 - 1] = 2047;
			}
		} else if (var1 == 2) {
			int var4 = in.gBit(3);
			localPlayer.method2908(var4, true);
			int var5 = in.gBit(3);
			localPlayer.method2908(var5, true);
			int var6 = in.gBit(1);
			if (var6 == 1) {
				field2045[++field2044 - 1] = 2047;
			}
		} else if (var1 == 3) {
			currentLevel = in.gBit(2);
			int var7 = in.gBit(7);
			int var8 = in.gBit(1);
			if (var8 == 1) {
				field2045[++field2044 - 1] = 2047;
			}
			int var9 = in.gBit(7);
			int var10 = in.gBit(1);
			localPlayer.method2907(var7, var9, var10 == 1);
		}
	}

	public static void imethod18() {
		int var11 = in.gBit(8);
		if (var11 < playerCount) {
			for (int var12 = var11; var12 < playerCount; var12++) {
				field2198[++field2035 - 1] = playerIds[var12];
			}
		}
		if (var11 > playerCount) {
			throw new RuntimeException("gppov1");
		}
		playerCount = 0;
		for (int var13 = 0; var13 < var11; var13++) {
			int var14 = playerIds[var13];
			PlayerEntity var15 = players[var14];
			int var16 = in.gBit(1);
			if (var16 == 0) {
				playerIds[++playerCount - 1] = var14;
				var15.field2660 = loopCycle;
			} else {
				int var17 = in.gBit(2);
				if (var17 == 0) {
					playerIds[++playerCount - 1] = var14;
					var15.field2660 = loopCycle;
					field2045[++field2044 - 1] = var14;
				} else if (var17 == 1) {
					playerIds[++playerCount - 1] = var14;
					var15.field2660 = loopCycle;
					int var18 = in.gBit(3);
					var15.method2908(var18, false);
					int var19 = in.gBit(1);
					if (var19 == 1) {
						field2045[++field2044 - 1] = var14;
					}
				} else if (var17 == 2) {
					playerIds[++playerCount - 1] = var14;
					var15.field2660 = loopCycle;
					int var20 = in.gBit(3);
					var15.method2908(var20, true);
					int var21 = in.gBit(3);
					var15.method2908(var21, true);
					int var22 = in.gBit(1);
					if (var22 == 1) {
						field2045[++field2044 - 1] = var14;
					}
				} else if (var17 == 3) {
					field2198[++field2035 - 1] = var14;
				}
			}
		}
	}

	public static void imethod19() {
		while (in.bitsAvailable(packetSize) >= 11) {
			int var23 = in.gBit(11);
			if (var23 == 2047) {
				break;
			}
			boolean var47 = false;
			if (players[var23] == null) {
				players[var23] = new PlayerEntity();
				if (playerAppearanceBuffer[var23] != null) {
					players[var23].method3061(playerAppearanceBuffer[var23]);
				}
				var47 = true;
			}
			playerIds[++playerCount - 1] = var23;
			PlayerEntity var48 = players[var23];
			var48.field2660 = loopCycle;
			int var49 = in.gBit(5);
			if (var49 > 15) {
				var49 -= 32;
			}
			int var50 = field1941[in.gBit(3)];
			if (var47) {
				var48.field2618 = var48.field2646 = var50;
			}
			int var51 = in.gBit(5);
			if (var51 > 15) {
				var51 -= 32;
			}
			int var52 = in.gBit(1);
			int var53 = in.gBit(1);
			if (var53 == 1) {
				field2045[++field2044 - 1] = var23;
			}
			var48.method2907(localPlayer.pathTileX[0] + var51, localPlayer.pathTileZ[0] + var49, var52 == 1);
		}
		in.accessBytes();
	}

	public static void imethod20() {
		for (int var24 = 0; var24 < field2044; var24++) {
			int var25 = field2045[var24];
			PlayerEntity var26 = players[var25];
			int var27 = in.g1();
			if ((var27 & 0x40) != 0) {
				var27 += in.g1() << 8;
			}
			imethod21(var25, var26, var27);
		}
	}

	public static void imethod21(int var25, PlayerEntity var26, int var27) {
		if ((var27 & 0x4) != 0) {
			int var28 = in.g2();
			int var29 = in.g1();
			int var30 = in.g1();
			int var31 = in.pos;
			if (var26.field2796 != null && var26.field2786 != null) {
				boolean var32 = false;
				if (var29 <= 1 && method761(var26.field2796)) {
					var32 = true;
				}
				if (!var32 && field2038 == 0) {
					field2016.pos = 0;
					in.gdata(field2016.data, 0, var30);
					field2016.pos = 0;
					String var33 = PixFont.method2844(JStringUtil.method54(WordPack.method1035(field2016)));
					var26.field2644 = var33.trim();
					var26.field2652 = var28 >> 8;
					var26.field2670 = var28 & 0xFF;
					var26.field2634 = 150;
					if (var29 == 2 || var29 == 3) {
						method559(1, TextUtil.imgTag(1) + var26.field2796, var33);
					} else if (var29 == 1) {
						method559(1, TextUtil.imgTag(0) + var26.field2796, var33);
					} else {
						method559(2, var26.field2796, var33);
					}
				}
			}
			in.pos = var30 + var31;
		}
		if ((var27 & 0x2) != 0) {
			int var34 = in.g1_alt3();
			byte[] var35 = new byte[var34];
			Packet var36 = new Packet(var35);
			in.gdata_alt1(var35, 0, var34);
			playerAppearanceBuffer[var25] = var36;
			var26.method3061(var36);
		}
		if ((var27 & 0x100) != 0) {
			var26.field2617 = in.g1();
			var26.field2655 = in.g1_alt2();
			var26.field2654 = in.g1();
			var26.field2642 = in.g1_alt1();
			var26.field2628 = in.g2_alt2() + loopCycle;
			var26.field2658 = in.g2() + loopCycle;
			var26.field2659 = in.g1_alt2();
			var26.field2665 = 1;
			var26.field2656 = 0;
		}
		if ((var27 & 0x20) != 0) {
			var26.field2637 = in.g2_alt3();
			if (var26.field2637 == 65535) {
				var26.field2637 = -1;
			}
		}
		if ((var27 & 0x80) != 0) {
			var26.field2638 = in.g2_alt2();
			var26.field2639 = in.g2_alt1();
		}
		if ((var27 & 0x10) != 0) {
			int var37 = in.g2_alt2();
			if (var37 == 65535) {
				var37 = -1;
			}
			int var38 = in.g1_alt2();
			method1040(var26, var37, var38);
		}
		if ((var27 & 0x200) != 0) {
			var26.field2648 = in.g2_alt1();
			int var39 = in.g4();
			var26.field2629 = var39 >> 16;
			var26.field2651 = (var39 & 0xFFFF) + loopCycle;
			var26.field2649 = 0;
			var26.field2650 = 0;
			if (var26.field2651 > loopCycle) {
				var26.field2649 = -1;
			}
			if (var26.field2648 == 65535) {
				var26.field2648 = -1;
			}
		}
		if ((var27 & 0x400) != 0) {
			int var40 = in.g1_alt1();
			int var41 = in.g1_alt3();
			var26.method2911(var40, var41, loopCycle);
			var26.field2635 = loopCycle + 300;
			var26.field2613 = in.g1();
			var26.field2636 = in.g1_alt2();
		}
		if ((var27 & 0x1) != 0) {
			var26.field2644 = in.gjstr();
			if (var26.field2644.charAt(0) == '~') {
				var26.field2644 = var26.field2644.substring(1);
				method559(2, var26.field2796, var26.field2644);
			} else if (localPlayer == var26) {
				method559(2, var26.field2796, var26.field2644);
			}
			var26.field2652 = 0;
			var26.field2670 = 0;
			var26.field2634 = 150;
		}
		if ((var27 & 0x8) != 0) {
			int var42 = in.g1_alt1();
			int var43 = in.g1_alt3();
			var26.method2911(var42, var43, loopCycle);
			var26.field2635 = loopCycle + 300;
			var26.field2613 = in.g1_alt1();
			var26.field2636 = in.g1();
		}
	}

	public static void imethod22() {
		if (!field2066) {
			field1994[0] = EnglishLocale.field1078;
			field2072[0] = "";
			field2069[0] = 1006;
			menuSize = 1;
		}
		if (field2083 != -1) {
			imethod23(field2083);
		}
		for (int var15 = 0; var15 < field2121; var15++) {
			if (field2175[var15]) {
				field2131[var15] = true;
			}
			field2132[var15] = field2175[var15];
			field2175[var15] = false;
		}
		field2063 = loopCycle;
		field1971 = -1;
		field1976 = -1;
		hoveredSlotParent = null;
		if (field2083 != -1) {
			field2121 = 0;
			method2581(field2083, 0, 0, 765, 503, 0, 0, -1);
		}
		Pix2D.method2584();
		imethod24();
		if (field2066) {
			imethod25();
		} else if (field1971 != -1) {
			imethod27(field1971, field1976);
		}
		if (field2137 == 3) {
			for (int var42 = 0; var42 < field2121; var42++) {
				if (field2132[var42]) {
					Pix2D.method2616(field2133[var42], field2007[var42], field2135[var42], field2136[var42], 0xff00ff, 0x80);
				} else if (field2131[var42]) {
					Pix2D.method2616(field2133[var42], field2007[var42], field2135[var42], field2136[var42], 0xff0000, 0x80);
				}
			}
		}
		PositionedSound.method2297(currentLevel, localPlayer.x, localPlayer.z, sceneDelta);
		sceneDelta = 0;
	}

	public static void imethod23(int var14) {
		if (IfType.method1501(var14)) {
			method1146(IfType.field373[var14], -1);
		}
	}

	public static void imethod24() {
		boolean var16 = false;
		while (!var16) {
			var16 = true;
			for (int var17 = 0; var17 < menuSize - 1; var17++) {
				if (field2069[var17] < 1000 && field2069[var17 + 1] > 1000) {
					String var18 = field2072[var17];
					field2072[var17] = field2072[var17 + 1];
					field2072[var17 + 1] = var18;
					String var19 = field1994[var17];
					field1994[var17] = field1994[var17 + 1];
					field1994[var17 + 1] = var19;
					int var20 = field2069[var17];
					field2069[var17] = field2069[var17 + 1];
					field2069[var17 + 1] = var20;
					int var21 = field2067[var17];
					field2067[var17] = field2067[var17 + 1];
					field2067[var17 + 1] = var21;
					int var22 = field2068[var17];
					field2068[var17] = field2068[var17 + 1];
					field2068[var17 + 1] = var22;
					int var23 = field2070[var17];
					field2070[var17] = field2070[var17 + 1];
					field2070[var17 + 1] = var23;
					var16 = false;
				}
			}
		}
	}

	public static void imethod25() {
		int var27 = field1161;
		int var28 = field743;
		int var29 = field535;
		int var30 = field42;
		int var31 = 0x5d5447;
		Pix2D.method2637(var27, var28, var29, var30, var31);
		Pix2D.method2637(var27 + 1, var28 + 1, var29 - 2, 16, 0);
		Pix2D.method2639(var27 + 1, var28 + 18, var29 - 2, var30 - 19, 0);
		field704.method2821(EnglishLocale.field1028, var27 + 3, var28 + 14, var31, -1);
		int var32 = JavaMouseProvider.mouseX;
		int var33 = JavaMouseProvider.mouseY;
		for (int var34 = 0; var34 < menuSize; var34++) {
			int var35 = (menuSize - 1 - var34) * 15 + var28 + 31;
			int var36 = 0xffffff;
			if (var32 > var27 && var32 < var27 + var29 && var33 > var35 - 13 && var33 < var35 + 3) {
				var36 = 0xffff00;
			}
			field704.method2821(method1239(var34), var27 + 3, var35, var36, 0);
		}
		imethod26(field1161, field743, field535, field42);
	}

	public static void imethod26(int var37, int var38, int var39, int var40) {
		for (int var41 = 0; var41 < field2121; var41++) {
			if (field2135[var41] + field2133[var41] > var37 && field2133[var41] < var37 + var39 && field2136[var41] + field2007[var41] > var38 && field2007[var41] < var38 + var40) {
				field2131[var41] = true;
			}
		}
	}

	public static void imethod27(int var24, int var25) {
		if (menuSize >= 2 || field2077 != 0 || field2079) {
			String var26;
			if (field2077 == 1 && menuSize < 2) {
				var26 = EnglishLocale.field1005 + EnglishLocale.field1015 + field2078 + " " + TextUtil.arrow;
			} else if (field2079 && menuSize < 2) {
				var26 = field2048 + EnglishLocale.field1015 + field2082 + " " + TextUtil.arrow;
			} else {
				var26 = method1239(menuSize - 1);
			}
			if (menuSize > 2) {
				var26 = var26 + TextUtil.colTag(0xffffff) + " " + '/' + " " + (menuSize - 2) + EnglishLocale.field1009;
			}
			field704.method2828(var26, var24 + 4, var25 + 15, 0xffffff, 0, loopCycle / 1000);
		}
	}

	public static void imethod28() {
		if (lowMemory && field2128 != currentLevel) {
			method390(field1473, field217, currentLevel, localPlayer.pathTileX[0], localPlayer.pathTileZ[0]);
		} else if (minimapLevel != currentLevel) {
			minimapLevel = currentLevel;
			int var402 = currentLevel;
			int[] var403 = field1627.field2506;
			int var404 = var403.length;
			for (int var405 = 0; var405 < var404; var405++) {
				var403[var405] = 0;
			}
			int var406 = 1;
			while (true) {
				if (var406 >= 103) {
					int var409 = ((int) (Math.random() * 20.0D) + 238 - 10 << 16) + ((int) (Math.random() * 20.0D) + 238 - 10 << 8) + ((int) (Math.random() * 20.0D) + 238 - 10);
					int var410 = (int) (Math.random() * 20.0D) + 238 - 10 << 16;
					field1627.method2662();
					for (int var411 = 1; var411 < 103; var411++) {
						for (int var412 = 1; var412 < 103; var412++) {
							if ((World.levelTileFlags[var402][var412][var411] & 0x18) == 0) {
								method764(var402, var412, var411, var409, var410);
							}
							if (var402 < 3 && (World.levelTileFlags[var402 + 1][var412][var411] & 0x8) != 0) {
								method764(var402 + 1, var412, var411, var409, var410);
							}
						}
					}
					field2157 = 0;
					for (int var413 = 0; var413 < 104; var413++) {
						for (int var414 = 0; var414 < 104; var414++) {
							int var415 = field1133.method593(currentLevel, var413, var414);
							if (var415 != 0) {
								int var416 = var415 >> 14 & 0x7FFF;
								int var417 = LocType.get(var416).mapfunction;
								if (var417 >= 0) {
									int var418 = var413;
									int var419 = var414;
									if (var417 != 22 && var417 != 29 && var417 != 34 && var417 != 36 && var417 != 46 && var417 != 47 && var417 != 48) {
										int[][] var420 = levelCollisionMap[currentLevel].field1266;
										for (int var421 = 0; var421 < 10; var421++) {
											int var422 = (int) (Math.random() * 4.0D);
											if (var422 == 0 && var418 > 0 && var418 > var413 - 3 && (var420[var418 - 1][var419] & 0x12C0108) == 0) {
												var418--;
											}
											if (var422 == 1 && var418 < 103 && var418 < var413 + 3 && (var420[var418 + 1][var419] & 0x12C0180) == 0) {
												var418++;
											}
											if (var422 == 2 && var419 > 0 && var419 > var414 - 3 && (var420[var418][var419 - 1] & 0x12C0102) == 0) {
												var419--;
											}
											if (var422 == 3 && var419 < 103 && var419 < var414 + 3 && (var420[var418][var419 + 1] & 0x12C0120) == 0) {
												var419++;
											}
										}
									}
									field2160[field2157] = field1727[var417];
									field2158[field2157] = var418;
									field2159[field2157] = var419;
									field2157++;
								}
							}
						}
					}
					GameShell.drawArea.method544();
					break;
				}
				int var407 = (103 - var406) * 2048 + 24628;
				for (int var408 = 1; var408 < 103; var408++) {
					if ((World.levelTileFlags[var402][var408][var406] & 0x18) == 0) {
						field1133.method598(var403, var407, 512, var402, var408, var406);
					}
					if (var402 < 3 && (World.levelTileFlags[var402 + 1][var408][var406] & 0x8) != 0) {
						field1133.method598(var403, var407, 512, var402 + 1, var408, var406);
					}
					var407 += 4;
				}
				var406++;
			}
		}
	}

	public static void imethod29() {
		for (LocSpawned var423 = (LocSpawned) temporaryLocs.head(); var423 != null; var423 = (LocSpawned) temporaryLocs.next()) {
			if (var423.field1640 > 0) {
				var423.field1640--;
			}
			if (var423.field1640 != 0) {
				if (var423.field1639 > 0) {
					var423.field1639--;
				}
				if (var423.field1639 == 0 && var423.field1633 >= 1 && var423.field1632 >= 1 && var423.field1633 <= 102 && var423.field1632 <= 102 && (var423.field1636 < 0 || World.isLocDownloaded(var423.field1636, var423.field1631))) {
					method274(var423.field1638, var423.field1630, var423.field1633, var423.field1632, var423.field1636, var423.field1637, var423.field1631);
					var423.field1639 = -1;
					if (var423.field1636 == var423.field1629 && var423.field1629 == -1) {
						var423.unlink();
					} else if (var423.field1636 == var423.field1629 && var423.field1637 == var423.field1634 && var423.field1635 == var423.field1631) {
						var423.unlink();
					}
				}
			} else if (var423.field1629 < 0 || World.isLocDownloaded(var423.field1629, var423.field1635)) {
				method274(var423.field1638, var423.field1630, var423.field1633, var423.field1632, var423.field1629, var423.field1634, var423.field1635);
				var423.unlink();
			}
		}
	}

	public static void imethod30() {
		int var10002;
		for (int var424 = 0; var424 < field2176; var424++) {
			var10002 = field2179[var424]--;
			if (field2179[var424] >= -10) {
				Wave var426 = field2181[var424];
				if (var426 == null) {
					Wave var528 = null;
					var426 = Wave.method294(field1509, field2177[var424], 0);
					if (var426 == null) {
						continue;
					}
					field2179[var424] += var426.method292();
					field2181[var424] = var426;
				}
				if (field2179[var424] < 0) {
					int var433;
					if (field2180[var424] == 0) {
						var433 = field1952;
					} else {
						int var427 = (field2180[var424] & 0xFF) * 128;
						int var428 = field2180[var424] >> 16 & 0xFF;
						int var429 = var428 * 128 + 64 - localPlayer.x;
						if (var429 < 0) {
							var429 = -var429;
						}
						int var430 = field2180[var424] >> 8 & 0xFF;
						int var431 = var430 * 128 + 64 - localPlayer.z;
						if (var431 < 0) {
							var431 = -var431;
						}
						int var432 = var429 + var431 - 128;
						if (var432 > var427) {
							field2179[var424] = -100;
							continue;
						}
						if (var432 < 0) {
							var432 = 0;
						}
						var433 = field2174 * (var427 - var432) / var427;
					}
					if (var433 > 0) {
						PcmSound var434 = var426.method291().method2050(field1733);
						SoundPcmStream var435 = SoundPcmStream.method2144(var434, 100, var433);
						var435.method2061(field2006[var424] - 1);
						field1460.method2174(var435);
					}
					field2179[var424] = -100;
				}
			} else {
				field2176--;
				for (int var425 = var424; var425 < field2176; var425++) {
					field2177[var425] = field2177[var425 + 1];
					field2181[var425] = field2181[var425 + 1];
					field2006[var425] = field2006[var425 + 1];
					field2179[var425] = field2179[var425 + 1];
					field2180[var425] = field2180[var425 + 1];
				}
				var424--;
			}
		}
		if (field2189 && !MidiPlayer.method2456()) {
			if (field2169 != 0 && field2170 != -1) {
				MidiPlayer.method1125(field1110, field2170, 0, field2169, false);
			}
			field2189 = false;
		}
	}

	public static void imethod31() {
		method1238(field2094);
		field1219++;
		if (field2102 && field2126) {
			int var458 = JavaMouseProvider.mouseX;
			int var459 = JavaMouseProvider.mouseY;
			int var460 = var458 - field2115;
			int var461 = var459 - field2097;
			if (var460 < field2183) {
				var460 = field2183;
			}
			if (field2094.field1792 + var460 > field2183 + field2162.field1792) {
				var460 = field2183 + field2162.field1792 - field2094.field1792;
			}
			if (var461 < field2101) {
				var461 = field2101;
			}
			if (field2094.field1793 + var461 > field2101 + field2162.field1793) {
				var461 = field2101 + field2162.field1793 - field2094.field1793;
			}
			int var462 = var460 - field2103;
			int var463 = var461 - field2104;
			int var464 = field2094.field1846;
			if (field1219 > field2094.field1887 && (var462 > var464 || var462 < -var464 || var463 > var464 || var463 < -var464)) {
				field1927 = true;
			}
			int var465 = field2162.field1796 + (var460 - field2183);
			int var466 = field2162.field1797 + (var461 - field2101);
			if (field2094.field1781 != null && field1927) {
				HookRequest var467 = new HookRequest();
				var467.component = field2094;
				var467.field1589 = var465;
				var467.field1587 = var466;
				var467.field1588 = field2094.field1781;
				ScriptRunner.runHook(var467);
			}
			if (JavaMouseProvider.mouseButton == 0) {
				if (field1927) {
					if (field2094.field1860 != null) {
						HookRequest var468 = new HookRequest();
						var468.component = field2094;
						var468.field1589 = var465;
						var468.field1587 = var466;
						var468.field1592 = field2098;
						var468.field1588 = field2094.field1860;
						ScriptRunner.runHook(var468);
					}
					if (field2098 != null) {
						IfType var469 = field2094;
						int var470 = WorldEntrySettings.method480(method1512(var469));
						IfType var471;
						if (var470 == 0) {
							var471 = null;
						} else {
							int var472 = 0;
							while (true) {
								if (var472 >= var470) {
									var471 = var469;
									break;
								}
								var469 = IfType.get(var469.layerid);
								if (var469 == null) {
									var471 = null;
									break;
								}
								var472++;
							}
						}
						if (var471 != null) {
							out.pisaac1(22);
							out.p2_alt3(field2094.subid);
							out.p4_alt2(field2098.field1783);
							out.p2_alt1(field2098.subid);
							out.p4_alt2(field2094.field1783);
						}
					}
				} else if ((mouseButtonsOption == 1 || isAddFriendOption(menuSize - 1)) && menuSize > 2) {
					showContextMenu();
				} else if (menuSize > 0) {
					useMenuOption(menuSize - 1);
				}
				field2094 = null;
			}
		} else if (field1219 > 1) {
			field2094 = null;
		}
	}

	public static void imethod32() {
        if (objDragInterface != null || field2094 != null) {
            return;
        }
        int var476 = JavaMouseProvider.mouseClickButton;
        if (field2066) {
            if (var476 != 1) {
                int var477 = JavaMouseProvider.mouseX;
                int var478 = JavaMouseProvider.mouseY;
                if (var477 < field1161 - 10 || var477 > field535 + field1161 + 10 || var478 < field743 - 10 || var478 > field743 + field42 + 10) {
                    field2066 = false;
                    method765(field1161, field743, field535, field42);
                }
            }
            if (var476 == 1) {
                int var479 = field1161;
                int var480 = field743;
                int var481 = field535;
                int var482 = JavaMouseProvider.mouseClickX;
                int var483 = JavaMouseProvider.mouseClickY;
                int var484 = -1;
                for (int var485 = 0; var485 < menuSize; var485++) {
                    int var486 = (menuSize - 1 - var485) * 15 + var480 + 31;
                    if (var482 > var479 && var482 < var479 + var481 && var483 > var486 - 13 && var483 < var486 + 3) {
                        var484 = var485;
                    }
                }
                if (var484 != -1) {
                    useMenuOption(var484);
                }
                field2066 = false;
                method765(field1161, field743, field535, field42);
            }
        } else {
			if (var476 == 1 && menuSize > 0) {
				int var487 = field2069[menuSize - 1];
				if (var487 == 39 || var487 == 40 || var487 == 41 || var487 == 42 || var487 == 43 || var487 == 33 || var487 == 34 || var487 == 35 || var487 == 36 || var487 == 37 || var487 == 38 || var487 == 1005) {
					int var488 = field2067[menuSize - 1];
					int var489 = field2068[menuSize - 1];
					IfType var490 = IfType.get(var489);
					if (WorldEntrySettings.method904(method1512(var490)) || WorldEntrySettings.imethod1(method1512(var490))) {
						objGrabThreshold = false;
						objDragCycles = 0;
						if (objDragInterface != null) {
							method1238(objDragInterface);
						}
						objDragInterface = IfType.get(var489);
						hoveredSlot = var488;
						objGrabX = JavaMouseProvider.mouseClickX;
						objGrabY = JavaMouseProvider.mouseClickY;
						method1238(objDragInterface);
						return;
					}
				}
			}
			if (var476 == 1 && (mouseButtonsOption == 1 && menuSize > 2 || isAddFriendOption(menuSize - 1))) {
				var476 = 2;
			}
			if (var476 == 1 && menuSize > 0) {
				useMenuOption(menuSize - 1);
			}
			if (var476 == 2 && menuSize > 0) {
				showContextMenu();
			}
        }
    }

	public static void imethod33() {
		int var493 = cameraAnticheatOffsetX + localPlayer.x;
		int var494 = cameraAnticheatOffsetZ + localPlayer.z;
		if (orbitCameraX - var493 < -500 || orbitCameraX - var493 > 500 || orbitCameraZ - var494 < -500 || orbitCameraZ - var494 > 500) {
			orbitCameraX = var493;
			orbitCameraZ = var494;
		}
		if (orbitCameraX != var493) {
			orbitCameraX += (var493 - orbitCameraX) / 16;
		}
		if (orbitCameraZ != var494) {
			orbitCameraZ += (var494 - orbitCameraZ) / 16;
		}
		if (JavaKeyboardProvider.actionKey[96]) {
			orbitCameraYawVelocity += (-24 - orbitCameraYawVelocity) / 2;
		} else if (JavaKeyboardProvider.actionKey[97]) {
			orbitCameraYawVelocity += (24 - orbitCameraYawVelocity) / 2;
		} else {
			orbitCameraYawVelocity /= 2;
		}
		if (JavaKeyboardProvider.actionKey[98]) {
			orbitCameraPitchVelocity += (12 - orbitCameraPitchVelocity) / 2;
		} else if (JavaKeyboardProvider.actionKey[99]) {
			orbitCameraPitchVelocity += (-12 - orbitCameraPitchVelocity) / 2;
		} else {
			orbitCameraPitchVelocity /= 2;
		}
		orbitCameraYaw = orbitCameraYawVelocity / 2 + orbitCameraYaw & 0x7FF;
		orbitCameraPitch += orbitCameraPitchVelocity / 2;
		if (orbitCameraPitch < 128) {
			orbitCameraPitch = 128;
		}
		if (orbitCameraPitch > 383) {
			orbitCameraPitch = 383;
		}
		int var495 = orbitCameraX >> 7;
		int var496 = orbitCameraZ >> 7;
		int var497 = getHeightmapY(orbitCameraX, orbitCameraZ, currentLevel);
		int var498 = 0;
		if (var495 > 3 && var496 > 3 && var495 < 100 && var496 < 100) {
			for (int var499 = var495 - 4; var499 <= var495 + 4; var499++) {
				for (int var500 = var496 - 4; var500 <= var496 + 4; var500++) {
					int var501 = currentLevel;
					if (var501 < 3 && (World.levelTileFlags[1][var499][var500] & 0x2) == 2) {
						var501++;
					}
					int var502 = var497 - World.levelHeightmap[var501][var499][var500];
					if (var502 > var498) {
						var498 = var502;
					}
				}
			}
		}
		int var503 = var498 * 192;
		if (var503 > 98048) {
			var503 = 98048;
		}
		if (var503 < 32768) {
			var503 = 32768;
		}
		if (var503 > cameraPitchClamp) {
			cameraPitchClamp += (var503 - cameraPitchClamp) / 24;
		} else if (var503 < cameraPitchClamp) {
			cameraPitchClamp += (var503 - cameraPitchClamp) / 80;
		}
	}

	public static void imethod34(int var12, int var13, int var31, int var32) {
		Pix2D.method2605(var12, var13, var12 + var31, var13 + var32);
		Pix3D.method2808();
		field2023++;
		method1510(true);
		method1503(true);
		method1510(false);
		method1503(false);
		method7();
		method839();
		if (!cutscene) {
			int var33 = orbitCameraPitch;
			if (cameraPitchClamp / 256 > var33) {
				var33 = cameraPitchClamp / 256;
			}
			if (field2184[4] && field2186[4] + 128 > var33) {
				var33 = field2186[4] + 128;
			}
			imethod38(var33, orbitCameraYaw + cameraAnticheatAngle & 0x7FF, orbitCameraX, getHeightmapY(localPlayer.x, localPlayer.z, currentLevel) - 50, orbitCameraZ, var33 * 3 + 600);
		}
		int var62;
		if (cutscene) {
			var62 = imethod39();
		} else {
			var62 = imethod40();
		}
		int var65 = cameraX;
		int var66 = cameraY;
		int var67 = cameraZ;
		int var68 = cameraPitch;
		int var69 = cameraYaw;
		for (int var70 = 0; var70 < 5; var70++) {
			if (field2184[var70]) {
				int var71 = (int) (Math.random() * (double) (field2187[var70] * 2 + 1) - (double) field2187[var70] + Math.sin((double) field2163[var70] / 100.0D * (double) cameraModifierCycle[var70]) * (double) field2186[var70]);
				if (var70 == 0) {
					cameraX += var71;
				}
				if (var70 == 1) {
					cameraY += var71;
				}
				if (var70 == 2) {
					cameraZ += var71;
				}
				if (var70 == 3) {
					cameraYaw = cameraYaw + var71 & 0x7FF;
				}
				if (var70 == 4) {
					cameraPitch += var71;
					if (cameraPitch < 128) {
						cameraPitch = 128;
					}
					if (cameraPitch > 383) {
						cameraPitch = 383;
					}
				}
			}
		}
		int var72 = JavaMouseProvider.mouseX;
		int var73 = JavaMouseProvider.mouseY;
		if (var72 >= var12 && var72 < var12 + var31 && var73 >= var13 && var73 < var13 + var32) {
			SoftwareModel.field2773 = true;
			SoftwareModel.field2741 = 0;
			SoftwareModel.field2719 = JavaMouseProvider.mouseX - var12;
			SoftwareModel.field2775 = JavaMouseProvider.mouseY - var13;
		} else {
			SoftwareModel.field2773 = false;
			SoftwareModel.field2741 = 0;
		}
		method1351();
		Pix2D.method2637(var12, var13, var31, var32, 0);
		method1351();
		field1133.method609(cameraX, cameraY, cameraZ, cameraPitch, cameraYaw, var62);
		method1351();
		field1133.method578();
		imethod37(var12, var13, var31, var32);
		method1333(var12, var13);
		((SceneBuilderProvider) Pix3D.sceneProvider).method751(sceneDelta);
		method1843(var12, var13, var31, var32);
		cameraX = var65;
		cameraY = var66;
		cameraZ = var67;
		cameraPitch = var68;
		cameraYaw = var69;
		if (field1921 && Js5TcpClient.imethod1() == 0) {
			field1921 = false;
		}
		if (field1921) {
			Pix2D.method2637(var12, var13, var31, var32, 0);
			method1789(EnglishLocale.field873, false);
		}
		if (!field1921 && !field2066 && var72 >= var12 && var72 < var12 + var31 && var73 >= var13 && var73 < var13 + var32) {
			imethod41(var12, var13, var72, var73);
		}
	}

	public static void imethod35(IfType var10, int var129, int var130) {
		if (var10.field1786 == 1) {
			method8(var10.field1859, "", 24, 0, 0, var10.field1783);
		}
		if (var10.field1786 == 2 && !field2079) {
			String var131;
			if (WorldEntrySettings.method1350(method1512(var10)) == 0) {
				var131 = null;
			} else if (var10.field1841 == null || var10.field1841.trim().length() == 0) {
				var131 = null;
			} else {
				var131 = var10.field1841;
			}
			if (var131 != null) {
				method8(var131, TextUtil.colTag(65280) + var10.field1883, 25, 0, -1, var10.field1783);
			}
		}
		if (var10.field1786 == 3) {
			method8(EnglishLocale.field1014, "", 26, 0, 0, var10.field1783);
		}
		if (var10.field1786 == 4) {
			method8(var10.field1859, "", 28, 0, 0, var10.field1783);
		}
		if (var10.field1786 == 5) {
			method8(var10.field1859, "", 29, 0, 0, var10.field1783);
		}
		if (var10.field1786 == 6 && field2087 == null) {
			method8(var10.field1859, "", 30, 0, -1, var10.field1783);
		}
		if (var10.field1785 == 2) {
			int var133 = 0;
			for (int var134 = 0; var134 < var10.field1793; var134++) {
				for (int var135 = 0; var135 < var10.field1792; var135++) {
					int var136 = (var10.field1843 + 32) * var135;
					int var137 = (var10.field1837 + 32) * var134;
					if (var133 < 20) {
						var136 += var10.field1854[var133];
						var137 += var10.field1862[var133];
					}
					if (var129 >= var136 && var130 >= var137 && var129 < var136 + 32 && var130 < var137 + 32) {
						objDragSlot = var133;
						hoveredSlotParent = var10;
						if (var10.invSlotObjId[var133] > 0) {
							label1831: {
								ObjType var138 = ObjType.get(var10.invSlotObjId[var133] - 1);
								if (field2077 == 1) {
									int var139 = method1512(var10);
									boolean var140 = (var139 >> 30 & 0x1) != 0;
									if (var140) {
										if (field502 != var10.field1783 || field557 != var133) {
											method8(EnglishLocale.field1005, field2078 + " " + TextUtil.arrow + " " + TextUtil.colTag(16748608) + var138.name, 31, var138.field2435, var133, var10.field1783);
										}
										break label1831;
									}
								}
								if (field2079) {
									int var141 = method1512(var10);
									boolean var142 = (var141 >> 30 & 0x1) != 0;
									if (var142) {
										if ((field386 & 0x10) == 16) {
											method8(field2048, field2082 + " " + TextUtil.arrow + " " + TextUtil.colTag(16748608) + var138.name, 32, var138.field2435, var133, var10.field1783);
										}
										break label1831;
									}
								}
								String[] var143 = var138.iop;
								if (field2001) {
									var143 = method726(var143);
								}
								int var144 = method1512(var10);
								boolean var145 = (var144 >> 30 & 0x1) != 0;
								if (var145) {
									for (int var146 = 4; var146 >= 3; var146--) {
										if (var143 != null && var143[var146] != null) {
											byte var147;
											if (var146 == 3) {
												var147 = 36;
											} else {
												var147 = 37;
											}
											method8(var143[var146], TextUtil.colTag(16748608) + var138.name, var147, var138.field2435, var133, var10.field1783);
										} else if (var146 == 4) {
											method8(EnglishLocale.field868, TextUtil.colTag(16748608) + var138.name, 37, var138.field2435, var133, var10.field1783);
										}
									}
								}
								int var148 = method1512(var10);
								boolean var149 = (var148 >> 31 & 0x1) != 0;
								if (var149) {
									method8(EnglishLocale.field1005, TextUtil.colTag(16748608) + var138.name, 38, var138.field2435, var133, var10.field1783);
								}
								int var150 = method1512(var10);
								boolean var151 = (var150 >> 30 & 0x1) != 0;
								if (var151 && var143 != null) {
									for (int var152 = 2; var152 >= 0; var152--) {
										if (var143[var152] != null) {
											byte var153 = 0;
											if (var152 == 0) {
												var153 = 33;
											}
											if (var152 == 1) {
												var153 = 34;
											}
											if (var152 == 2) {
												var153 = 35;
											}
											method8(var143[var152], TextUtil.colTag(16748608) + var138.name, var153, var138.field2435, var133, var10.field1783);
										}
									}
								}
								String[] var154 = var10.field1833;
								if (field2001) {
									var154 = method726(var154);
								}
								if (var154 != null) {
									for (int var155 = 4; var155 >= 0; var155--) {
										if (var154[var155] != null) {
											byte var156 = 0;
											if (var155 == 0) {
												var156 = 39;
											}
											if (var155 == 1) {
												var156 = 40;
											}
											if (var155 == 2) {
												var156 = 41;
											}
											if (var155 == 3) {
												var156 = 42;
											}
											if (var155 == 4) {
												var156 = 43;
											}
											method8(var154[var155], TextUtil.colTag(16748608) + var138.name, var156, var138.field2435, var133, var10.field1783);
										}
									}
								}
								method8(EnglishLocale.field1075, TextUtil.colTag(16748608) + var138.name, 1005, var138.field2435, var133, var10.field1783);
							}
						}
					}
					var133++;
				}
			}
		}
		if (var10.field1782) {
			if (field2079) {
				int var157 = method1512(var10);
				boolean var158 = (var157 >> 21 & 0x1) != 0;
				if (var158 && (field386 & 0x20) == 32) {
					method8(field2048, field2082 + " " + TextUtil.arrow + " " + var10.field1795, 58, 0, var10.subid, var10.field1783);
				}
			} else {
				for (int var159 = 9; var159 >= 5; var159--) {
					String var160 = method513(var10, var159);
					if (var160 != null) {
						method8(var160, var10.field1795, 1007, var159 + 1, var10.subid, var10.field1783);
					}
				}
				String var161 = method422(var10);
				if (var161 != null) {
					method8(var161, var10.field1795, 25, 0, var10.subid, var10.field1783);
				}
				for (int var162 = 4; var162 >= 0; var162--) {
					String var163 = method513(var10, var162);
					if (var163 != null) {
						method8(var163, var10.field1795, 57, var162 + 1, var10.subid, var10.field1783);
					}
				}
				if (WorldEntrySettings.method745(method1512(var10))) {
					method8(EnglishLocale.field872, "", 30, 0, var10.subid, var10.field1783);
				}
			}
		}
	}

	public static void imethod36(int var13, int var165, int var166, int var167, int var168) {
		field1726[0].method2747(var165, var13);
		field1726[1].method2747(var165, var13 + var167 - 16);
		Pix2D.method2637(var165, var13 + 16, 16, var167 - 32, field1919);
		int var169 = (var167 - 32) * var167 / var168;
		if (var169 < 8) {
			var169 = 8;
		}
		int var170 = (var167 - 32 - var169) * var166 / (var168 - var167);
		Pix2D.method2637(var165, var13 + 16 + var170, 16, var169, field2113);
		Pix2D.method2596(var165, var13 + 16 + var170, var169, field2002);
		Pix2D.method2596(var165 + 1, var13 + 16 + var170, var169, field2002);
		Pix2D.method2594(var165, var13 + 16 + var170, 16, field2002);
		Pix2D.method2594(var165, var13 + 17 + var170, 16, field2002);
		Pix2D.method2596(var165 + 15, var13 + 16 + var170, var169, field2095);
		Pix2D.method2596(var165 + 14, var13 + 17 + var170, var169 - 1, field2095);
		Pix2D.method2594(var165, var13 + 15 + var170 + var169, 16, field2095);
		Pix2D.method2594(var165 + 1, var13 + 14 + var170 + var169, 15, field2095);
	}

	public static void imethod37(int var12, int var13, int var31, int var32) {
		field2012 = 0;
		for (int var74 = -1; var74 < playerCount + npcCount; var74++) {
			PathingEntity var75;
			if (var74 == -1) {
				var75 = localPlayer;
			} else if (var74 < playerCount) {
				var75 = players[playerIds[var74]];
			} else {
				var75 = npcs[field1956[var74 - playerCount]];
			}
			if (var75 != null && var75.method2915()) {
				if (var75 instanceof NpcEntity) {
					NpcType var76 = ((NpcEntity) var75).field2804;
					if (var76.multinpc != null) {
						var76 = var76.method2332();
					}
					if (var76 == null) {
						continue;
					}
				}
				if (var74 >= playerCount) {
					NpcType var79 = ((NpcEntity) var75).field2804;
					if (var79.multinpc != null) {
						var79 = var79.method2332();
					}
					if (var79.headicon >= 0 && var79.headicon < field187.length) {
						method948(var75, var75.field2626 + 15);
						if (field2140 > -1) {
							field187[var79.headicon].method2671(field2140 + var12 - 12, field2025 + var13 - 30);
						}
					}
					if (field1920 == 1 && field1931 == field1956[var74 - playerCount] && loopCycle % 20 < 10) {
						method948(var75, var75.field2626 + 15);
						if (field2140 > -1) {
							field1744[0].method2671(field2140 + var12 - 12, field2025 + var13 - 28);
						}
					}
				} else {
					int var77 = 30;
					PlayerEntity var78 = (PlayerEntity) var75;
					if (var78.field2787 != -1 || var78.field2800 != -1) {
						method948(var75, var75.field2626 + 15);
						if (field2140 > -1) {
							if (var78.field2787 != -1) {
								field816[var78.field2787].method2671(field2140 + var12 - 12, field2025 + var13 - var77);
								var77 += 25;
							}
							if (var78.field2800 != -1) {
								field187[var78.field2800].method2671(field2140 + var12 - 12, field2025 + var13 - var77);
								var77 += 25;
							}
						}
					}
					if (var74 >= 0 && field1920 == 10 && field1932 == playerIds[var74]) {
						method948(var75, var75.field2626 + 15);
						if (field2140 > -1) {
							field1744[1].method2671(field2140 + var12 - 12, field2025 + var13 - var77);
						}
					}
				}
				if (var75.field2644 != null && (var74 >= playerCount || field2145 == 0 || field2145 == 3 || field2145 == 1 && method785(((PlayerEntity) var75).field2796))) {
					method948(var75, var75.field2626);
					if (field2140 > -1 && field2012 < field2013) {
						field2017[field2012] = field704.method2882(var75.field2644) / 2;
						field1930[field2012] = field704.field2550;
						field2014[field2012] = field2140;
						field2015[field2012] = field2025;
						field2154[field2012] = var75.field2652;
						field2019[field2012] = var75.field2670;
						field2020[field2012] = var75.field2634;
						field2021[field2012] = var75.field2644;
						field2012++;
					}
				}
				if (var75.field2635 > loopCycle) {
					method948(var75, var75.field2626 + 15);
					if (field2140 > -1) {
						int var80 = var75.field2613 * 30 / var75.field2636;
						if (var80 > 30) {
							var80 = 30;
						}
						Pix2D.method2637(field2140 + var12 - 15, field2025 + var13 - 3, var80, 5, 65280);
						Pix2D.method2637(field2140 + var12 - 15 + var80, field2025 + var13 - 3, 30 - var80, 5, 16711680);
					}
				}
				for (int var81 = 0; var81 < 4; var81++) {
					if (var75.field2633[var81] > loopCycle) {
						method948(var75, var75.field2626 / 2);
						if (field2140 > -1) {
							if (var81 == 1) {
								field2025 -= 20;
							}
							if (var81 == 2) {
								field2140 -= 15;
								field2025 -= 10;
							}
							if (var81 == 3) {
								field2140 += 15;
								field2025 -= 10;
							}
							field1157[var75.field2632[var81]].method2671(field2140 + var12 - 12, field2025 + var13 - 12);
							field1621.method2880(Integer.toString(var75.field2631[var81]), field2140 + var12 - 1, field2025 + var13 + 3, 16777215, 0);
						}
					}
				}
			}
		}
		for (int var82 = 0; var82 < field2012; var82++) {
			int var83 = field2014[var82];
			int var84 = field2015[var82];
			int var85 = field2017[var82];
			int var86 = field1930[var82];
			boolean var87 = true;
			while (var87) {
				var87 = false;
				for (int var88 = 0; var88 < var82; var88++) {
					if (var84 + 2 > field2015[var88] - field1930[var88] && var84 - var86 < field2015[var88] + 2 && var83 - var85 < field2017[var88] + field2014[var88] && var83 + var85 > field2014[var88] - field2017[var88] && field2015[var88] - field1930[var88] < var84) {
						var84 = field2015[var88] - field1930[var88];
						var87 = true;
					}
				}
			}
			field2140 = field2014[var82];
			field2025 = field2015[var82] = var84;
			String var89 = field2021[var82];
			if (field2085 == 0) {
				int var90 = 16776960;
				if (field2154[var82] < 6) {
					var90 = field2144[field2154[var82]];
				}
				if (field2154[var82] == 6) {
					var90 = field2023 % 20 < 10 ? 16711680 : 16776960;
				}
				if (field2154[var82] == 7) {
					var90 = field2023 % 20 < 10 ? 255 : 65535;
				}
				if (field2154[var82] == 8) {
					var90 = field2023 % 20 < 10 ? 45056 : 8454016;
				}
				if (field2154[var82] == 9) {
					int var91 = 150 - field2020[var82];
					if (var91 < 50) {
						var90 = var91 * 1280 + 16711680;
					} else if (var91 < 100) {
						var90 = 16776960 - (var91 - 50) * 327680;
					} else if (var91 < 150) {
						var90 = (var91 - 100) * 5 + 65280;
					}
				}
				if (field2154[var82] == 10) {
					int var92 = 150 - field2020[var82];
					if (var92 < 50) {
						var90 = var92 * 5 + 16711680;
					} else if (var92 < 100) {
						var90 = 16711935 - (var92 - 50) * 327680;
					} else if (var92 < 150) {
						var90 = (var92 - 100) * 327680 + 255 - (var92 - 100) * 5;
					}
				}
				if (field2154[var82] == 11) {
					int var93 = 150 - field2020[var82];
					if (var93 < 50) {
						var90 = 16777215 - var93 * 327685;
					} else if (var93 < 100) {
						var90 = (var93 - 50) * 327685 + 65280;
					} else if (var93 < 150) {
						var90 = 16777215 - (var93 - 100) * 327680;
					}
				}
				if (field2019[var82] == 0) {
					field704.method2880(var89, field2140 + var12, field2025 + var13, var90, 0);
				}
				if (field2019[var82] == 1) {
					field704.method2825(var89, field2140 + var12, field2025 + var13, var90, 0, field2023);
				}
				if (field2019[var82] == 2) {
					field704.method2826(var89, field2140 + var12, field2025 + var13, var90, 0, field2023);
				}
				if (field2019[var82] == 3) {
					field704.method2827(var89, field2140 + var12, field2025 + var13, var90, 0, field2023, 150 - field2020[var82]);
				}
				if (field2019[var82] == 4) {
					int var94 = (150 - field2020[var82]) * (field704.method2882(var89) + 100) / 150;
					Pix2D.method2586(field2140 + var12 - 50, var13, field2140 + var12 + 50, var13 + var32);
					field704.method2821(var89, field2140 + var12 + 50 - var94, field2025 + var13, var90, 0);
					Pix2D.method2605(var12, var13, var12 + var31, var13 + var32);
				}
				if (field2019[var82] == 5) {
					int var95 = 150 - field2020[var82];
					int var96 = 0;
					if (var95 < 25) {
						var96 = var95 - 25;
					} else if (var95 > 125) {
						var96 = var95 - 125;
					}
					Pix2D.method2586(var12, field2025 + var13 - field704.field2550 - 1, var12 + var31, field2025 + var13 + 5);
					field704.method2880(var89, field2140 + var12, field2025 + var13 + var96, var90, 0);
					Pix2D.method2605(var12, var13, var12 + var31, var13 + var32);
				}
			} else {
				field704.method2880(var89, field2140 + var12, field2025 + var13, 16776960, 0);
			}
		}
	}

	public static void imethod38(int var33, int var34, int var35, int var36, int var37, int var38) {
		int var39 = 2048 - var33 & 0x7FF;
		int var40 = 2048 - var34 & 0x7FF;
		int var41 = 0;
		int var42 = 0;
		int var43 = var38;
		if (var39 != 0) {
			int var44 = Pix3D.sinTable[var39];
			int var45 = Pix3D.cosTable[var39];
			int var46 = var42 * var45 - var38 * var44 >> 16;
			var43 = var42 * var44 + var38 * var45 >> 16;
			var42 = var46;
		}
		if (var40 != 0) {
			int var47 = Pix3D.sinTable[var40];
			int var48 = Pix3D.cosTable[var40];
			int var49 = var41 * var48 + var43 * var47 >> 16;
			var43 = var43 * var48 - var41 * var47 >> 16;
			var41 = var49;
		}
		cameraX = var35 - var41;
		cameraY = var36 - var42;
		cameraZ = var37 - var43;
		cameraPitch = var33;
		cameraYaw = var34;
	}

	public static int imethod39() {
		int var63 = getHeightmapY(cameraX, cameraZ, currentLevel);
		if (var63 - cameraY >= 800 || (World.levelTileFlags[currentLevel][cameraX >> 7][cameraZ >> 7] & 0x4) == 0) {
			return 3;
		} else {
			return currentLevel;
		}
	}

	public static int imethod40() {
		int var50 = 3;
		if (cameraPitch < 310) {
			int var51 = cameraX >> 7;
			int var52 = cameraZ >> 7;
			int var53 = localPlayer.x >> 7;
			int var54 = localPlayer.z >> 7;
			if ((World.levelTileFlags[currentLevel][var51][var52] & 0x4) != 0) {
				var50 = currentLevel;
			}
			int var55;
			if (var53 > var51) {
				var55 = var53 - var51;
			} else {
				var55 = var51 - var53;
			}
			int var56;
			if (var54 > var52) {
				var56 = var54 - var52;
			} else {
				var56 = var52 - var54;
			}
			if (var55 > var56) {
				int var57 = var56 * 65536 / var55;
				int var58 = 32768;
				while (var51 != var53) {
					if (var51 < var53) {
						var51++;
					} else if (var51 > var53) {
						var51--;
					}
					if ((World.levelTileFlags[currentLevel][var51][var52] & 0x4) != 0) {
						var50 = currentLevel;
					}
					var58 += var57;
					if (var58 >= 65536) {
						var58 -= 65536;
						if (var52 < var54) {
							var52++;
						} else if (var52 > var54) {
							var52--;
						}
						if ((World.levelTileFlags[currentLevel][var51][var52] & 0x4) != 0) {
							var50 = currentLevel;
						}
					}
				}
			} else {
				int var59 = var55 * 65536 / var56;
				int var60 = 32768;
				while (var52 != var54) {
					if (var52 < var54) {
						var52++;
					} else if (var52 > var54) {
						var52--;
					}
					if ((World.levelTileFlags[currentLevel][var51][var52] & 0x4) != 0) {
						var50 = currentLevel;
					}
					var60 += var59;
					if (var60 >= 65536) {
						var60 -= 65536;
						if (var51 < var53) {
							var51++;
						} else if (var51 > var53) {
							var51--;
						}
						if ((World.levelTileFlags[currentLevel][var51][var52] & 0x4) != 0) {
							var50 = currentLevel;
						}
					}
				}
			}
		}
		if ((World.levelTileFlags[currentLevel][localPlayer.x >> 7][localPlayer.z >> 7] & 0x4) != 0) {
			var50 = currentLevel;
		}
		return var50;
	}

	public static void imethod41(int var12, int var13, int var72, int var73) {
		if (field2077 == 0 && !field2079) {
			method8(EnglishLocale.field1010, "", 23, 0, var72 - var12, var73 - var13);
		}
		int var100 = -1;
		for (int var101 = 0; var101 < SoftwareModel.field2741; var101++) {
			int var102 = SoftwareModel.field2730[var101];
			int var103 = var102 & 0x7F;
			int var104 = var102 >> 7 & 0x7F;
			int var105 = var102 >> 29 & 0x3;
			int var106 = var102 >> 14 & 0x7FFF;
            if (var100 == var102) {
                continue;
            }
            var100 = var102;
            if (var105 == 2 && field1133.method594(currentLevel, var103, var104, var102) >= 0) {
                LocType var107 = LocType.get(var106);
                if (var107.multiloc != null) {
                    var107 = var107.getMultiLoc();
                }
                if (var107 == null) {
                    continue;
                }
                if (field2077 == 1) {
                    method8(EnglishLocale.field1005, field2078 + " " + TextUtil.arrow + " " + TextUtil.colTag(65535) + var107.name, 1, var102, var103, var104);
                } else if (!field2079) {
                    String[] var108 = var107.op;
                    if (field2001) {
                        var108 = method726(var108);
                    }
                    if (var108 != null) {
                        for (int var109 = 4; var109 >= 0; var109--) {
                            if (var108[var109] != null) {
                                short var110 = 0;
                                if (var109 == 0) {
                                    var110 = 3;
                                }
                                if (var109 == 1) {
                                    var110 = 4;
                                }
                                if (var109 == 2) {
                                    var110 = 5;
                                }
                                if (var109 == 3) {
                                    var110 = 6;
                                }
                                if (var109 == 4) {
                                    var110 = 1001;
                                }
                                method8(var108[var109], TextUtil.colTag(65535) + var107.name, var110, var102, var103, var104);
                            }
                        }
                    }
                    method8(EnglishLocale.field1075, TextUtil.colTag(65535) + var107.name, 1002, var107.id << 14, var103, var104);
                } else if ((field386 & 0x4) == 4) {
                    method8(field2048, field2082 + " " + TextUtil.arrow + " " + TextUtil.colTag(65535) + var107.name, 2, var102, var103, var104);
                }
            }
            if (var105 == 1) {
                NpcEntity var111 = npcs[var106];
                if (var111.field2804.size == 1 && (var111.x & 0x7F) == 64 && (var111.z & 0x7F) == 64) {
                    for (int var112 = 0; var112 < npcCount; var112++) {
                        NpcEntity var113 = npcs[field1956[var112]];
                        if (var113 != null && var111 != var113 && var113.field2804.size == 1 && var111.x == var113.x && var111.z == var113.z) {
                            method64(var113.field2804, field1956[var112], var103, var104);
                        }
                    }
                    for (int var114 = 0; var114 < playerCount; var114++) {
                        PlayerEntity var115 = players[playerIds[var114]];
                        if (var115 != null && var111.x == var115.x && var111.z == var115.z) {
                            method950(var115, playerIds[var114], var103, var104);
                        }
                    }
                }
                method64(var111.field2804, var106, var103, var104);
            }
            if (var105 == 0) {
                PlayerEntity var116 = players[var106];
                if ((var116.x & 0x7F) == 64 && (var116.z & 0x7F) == 64) {
                    for (int var117 = 0; var117 < npcCount; var117++) {
                        NpcEntity var118 = npcs[field1956[var117]];
                        if (var118 != null && var118.field2804.size == 1 && var116.x == var118.x && var116.z == var118.z) {
                            method64(var118.field2804, field1956[var117], var103, var104);
                        }
                    }
                    for (int var119 = 0; var119 < playerCount; var119++) {
                        PlayerEntity var120 = players[playerIds[var119]];
                        if (var120 != null && var116 != var120 && var116.x == var120.x && var116.z == var120.z) {
                            method950(var120, playerIds[var119], var103, var104);
                        }
                    }
                }
                method950(var116, var106, var103, var104);
            }
            if (var105 == 3) {
                LinkList var121 = levelObjStacks[currentLevel][var103][var104];
                if (var121 == null) {
                    continue;
                }
                for (ObjStackEntity var122 = (ObjStackEntity) var121.tail(); var122 != null; var122 = (ObjStackEntity) var121.prev()) {
                    ObjType var123 = ObjType.get(var122.field2600);
                    if (field2077 == 1) {
                        method8(EnglishLocale.field1005, field2078 + " " + TextUtil.arrow + " " + TextUtil.colTag(16748608) + var123.name, 16, var122.field2600, var103, var104);
                    } else if (!field2079) {
                        String[] var124 = var123.op;
                        if (field2001) {
                            var124 = method726(var124);
                        }
                        for (int var125 = 4; var125 >= 0; var125--) {
                            if (var124 != null && var124[var125] != null) {
                                byte var126 = 0;
                                if (var125 == 0) {
                                    var126 = 18;
                                }
                                if (var125 == 1) {
                                    var126 = 19;
                                }
                                if (var125 == 2) {
                                    var126 = 20;
                                }
                                if (var125 == 3) {
                                    var126 = 21;
                                }
                                if (var125 == 4) {
                                    var126 = 22;
                                }
                                method8(var124[var125], TextUtil.colTag(16748608) + var123.name, var126, var122.field2600, var103, var104);
                            } else if (var125 == 2) {
                                method8(EnglishLocale.field867, TextUtil.colTag(16748608) + var123.name, 20, var122.field2600, var103, var104);
                            }
                        }
                        method8(EnglishLocale.field1075, TextUtil.colTag(16748608) + var123.name, 1004, var122.field2600, var103, var104);
                    } else if ((field386 & 0x1) == 1) {
                        method8(field2048, field2082 + " " + TextUtil.arrow + " " + TextUtil.colTag(16748608) + var123.name, 17, var122.field2600, var103, var104);
                    }
                }
            }
        }
	}
}
