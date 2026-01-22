package jagex3.client;

import deob.ObfuscatedName;
import jagex3.client.applet.*;
import jagex3.client.chat.*;
import jagex3.client.obfuscation.ReflectionChecker;
import jagex3.client.ui.ClientInvCache;
import jagex3.client.ui.IfType;
import jagex3.client.ui.ServerActive;
import jagex3.client.ui.SubInterface;
import jagex3.config.*;
import jagex3.dash3d.*;
import jagex3.datastruct.*;
import jagex3.graphics.*;
import jagex3.io.ClientStream;
import jagex3.io.DataFile;
import jagex3.io.Packet;
import jagex3.io.PacketBit;
import jagex3.javconfig.JavConfigParameter;
import jagex3.javconfig.ModeGame;
import jagex3.javconfig.ModeWhat;
import jagex3.js5.Js5Loader;
import jagex3.js5.Js5Net;
import jagex3.js5.Js5NetThread;
import jagex3.js5.Js5WorkerRequest;
import jagex3.jstring.JString;
import jagex3.jstring.StringConstants;
import jagex3.jstring.StringUtil;
import jagex3.jstring.Text;
import jagex3.midi.MidiManager;
import jagex3.midi.MidiPlayer;
import jagex3.script.ClientScript;
import jagex3.script.HookReq;
import jagex3.script.ScriptRunner;
import jagex3.sound.*;
import jagex3.wordenc.Huffman;
import jagex3.wordenc.WordPack;

import java.awt.*;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;

@ObfuscatedName("client")
public class Client extends GameShell {

	@ObfuscatedName("cd.ad")
	public static Image progressBar;

	@ObfuscatedName("client.ak")
	public static boolean mouseTracked = true;

	@ObfuscatedName("client.az")
	public static int worldid = 1;

	@ObfuscatedName("v.an")
	public static ModeWhat modewhat;

	@ObfuscatedName("client.ah")
	public static int modewhere = 0;

	@ObfuscatedName("da.ay")
	public static ModeGame modegame;

	@ObfuscatedName("ab.al")
	public static NameSpace namespace;

	@ObfuscatedName("client.ab")
	public static boolean memServer = false;

	@ObfuscatedName("client.ao")
	public static boolean lowMemory = false;

	@ObfuscatedName("client.ag")
	public static int lang = 0;

	@ObfuscatedName("client.ar")
	public static int js = 1;

	@ObfuscatedName("client.at")
	public static int state = 0;

	@ObfuscatedName("client.ae")
	public static boolean field1921 = true;

	@ObfuscatedName("client.au")
	public static int loopCycle = 0;

	@ObfuscatedName("client.ax")
	public static long prevMouseClickTime = 0L;

	@ObfuscatedName("dm.ai")
	public static MouseTracking mouseTracking;

	@ObfuscatedName("client.aj")
	public static int lastWriteX = 0;

	@ObfuscatedName("client.aw")
	public static int lastWriteY = 0;

	@ObfuscatedName("client.af")
	public static int mouseTrackedDelta = 0;

	@ObfuscatedName("client.bh")
	public static boolean focusIn = true;

	@ObfuscatedName("client.bi")
	public static boolean showFps = false;

	@ObfuscatedName("client.bs")
	public static int rebootTimer = 0;

	@ObfuscatedName("client.bk")
	public static int hintType = 0;

	@ObfuscatedName("client.bv")
	public static int hintNpc = 0;

	@ObfuscatedName("client.bg")
	public static int hintPlayer = 0;

	@ObfuscatedName("client.bl")
	public static int hintTileX = 0;

	@ObfuscatedName("client.bt")
	public static int hintTileZ = 0;

	@ObfuscatedName("client.bw")
	public static int hintHeight = 0;

	@ObfuscatedName("client.by")
	public static int hintOffsetX = 0;

	@ObfuscatedName("client.bx")
	public static int hintOffsetZ = 0;

	@ObfuscatedName("client.bf")
	public static Packet field2016 = new Packet(new byte[5000]);

	@ObfuscatedName("g.bu")
	public static PrivilegedRequest field170;

	@ObfuscatedName("client.bq")
	public static int loadingStep = 0;

	@ObfuscatedName("l.bj")
	public static PrivilegedRequest js5SocketReq;

	@ObfuscatedName("br.bz")
	public static ClientStream js5Stream;

	@ObfuscatedName("client.bm")
	public static int js5ConnectState = 0;

	@ObfuscatedName("client.bn")
	public static int js5ConnectCooldown = 0;

	@ObfuscatedName("client.be")
	public static long field1943;

	@ObfuscatedName("bb.bp")
	public static Js5Loader anims;

	@ObfuscatedName("es.ba")
	public static Js5Loader bases;

	@ObfuscatedName("cc.bc")
	public static Js5Loader config;

	@ObfuscatedName("bd.br")
	public static Js5Loader interfaces;

	@ObfuscatedName("df.bb")
	public static Js5Loader jagFX;

	@ObfuscatedName("ck.bd")
	public static Js5Loader maps;

	@ObfuscatedName("bb.cr")
	public static Js5Loader songs;

	@ObfuscatedName("aa.cs")
	public static Js5Loader models;

	@ObfuscatedName("client.cj")
	public static Js5Loader sprites;

	@ObfuscatedName("client.cl")
	public static Js5Loader textures;

	@ObfuscatedName("ab.cp")
	public static Js5Loader binary;

	@ObfuscatedName("dz.ca")
	public static Js5Loader jingles;

	@ObfuscatedName("ct.co")
	public static Js5Loader scripts;

	@ObfuscatedName("cj.ch")
	public static Js5Loader fontMetrics;

	@ObfuscatedName("ey.cu")
	public static Js5Loader vorbis;

	@ObfuscatedName("z.cc")
	public static Js5Loader patches;

	@ObfuscatedName("client.cm")
	public static int js5Errors = 0;

	@ObfuscatedName("client.cw")
	public static int loginStep = 0;

	@ObfuscatedName("client.cz")
	public static int loginWaitingTime = 0;

	@ObfuscatedName("client.cv")
	public static int loginFailCount = 0;

	@ObfuscatedName("client.ct")
	public static int loginHopTimer = 0;

	@ObfuscatedName("c.ck")
	public static String loginHost;

	@ObfuscatedName("dn.cy")
	public static int loginGamePort;

	@ObfuscatedName("d.cq")
	public static int loginJs5Port;

	@ObfuscatedName("cu.cd")
	public static int loginPort;

	@ObfuscatedName("client.ci")
	public static ClientNpc[] npcs = new ClientNpc[32768];

	@ObfuscatedName("client.cb")
	public static int npcCount = 0;

	@ObfuscatedName("client.cf")
	public static int[] npcIds = new int[32768];

	@ObfuscatedName("by.cg")
	public static PrivilegedRequest field806;

	@ObfuscatedName("at.dd")
	public static ClientStream loginStream;

	@ObfuscatedName("c.dg")
	public static ClientStream stream;

	@ObfuscatedName("client.df")
	public static PacketBit out = new PacketBit(5000);

	@ObfuscatedName("client.dk")
	public static PacketBit login = new PacketBit(5000);

	@ObfuscatedName("client.dz")
	public static PacketBit in = new PacketBit(5000);

	@ObfuscatedName("client.da")
	public static int psize = 0;

	@ObfuscatedName("client.dj")
	public static int ptype = 0;

	@ObfuscatedName("client.dv")
	public static int timeoutTimer = 0;

	@ObfuscatedName("client.ds")
	public static int noTimeoutCycle = 0;

	@ObfuscatedName("client.dh")
	public static int logoutTimer = 0;

	@ObfuscatedName("client.dc")
	public static int ptype0 = 0;

	@ObfuscatedName("client.dp")
	public static int ptype1 = 0;

	@ObfuscatedName("client.dm")
	public static int ptype2 = 0;

	@ObfuscatedName("client.di")
	public static boolean networkError = false;

	@ObfuscatedName("dw.db")
	public static SoftwareFont fontPlain11;

	@ObfuscatedName("bd.dq")
	public static SoftwareFont fontPlain12;

	@ObfuscatedName("af.dr")
	public static SoftwareFont fontBold12;

	@ObfuscatedName("a.de")
	public static int mapBuildBaseX;

	@ObfuscatedName("at.dw")
	public static int mapBuildBaseZ;

	@ObfuscatedName("client.dl")
	public static int sceneState = 0;

	@ObfuscatedName("cd.dn")
	public static int mapBuildCenterZoneX;

	@ObfuscatedName("v.do")
	public static int mapBuildCenterZoneZ;

	@ObfuscatedName("client.dx")
	public static int mapLoadCount = 0;

	@ObfuscatedName("client.dt")
	public static int mapLoadPrevCount = 1;

	@ObfuscatedName("client.eb")
	public static int locModelLoadCount = 0;

	@ObfuscatedName("client.er")
	public static int locModelLoadPrevCount = 1;

	@ObfuscatedName("client.es")
	public static int mapLoadingStage = 0;

	@ObfuscatedName("bw.ez")
	public static int[] mapBuildIndex;

	@ObfuscatedName("bo.ev")
	public static int[] mapBuildGroundFile;

	@ObfuscatedName("co.ei")
	public static int[] mapBuildLocationFile;

	@ObfuscatedName("am.ef")
	public static int[][] mapKeys;

	@ObfuscatedName("ej.ej")
	public static byte[][] mapBuildGroundData;

	@ObfuscatedName("i.eh")
	public static byte[][] mapBuildLocationData;

	@ObfuscatedName("cr.eg")
	public static World world;

	@ObfuscatedName("client.el")
	public static CollisionMap[] levelCollisionMap = new CollisionMap[4];

	@ObfuscatedName("client.en")
	public static boolean regionmode = false;

	@ObfuscatedName("client.ew")
	public static int[][][] field1979 = new int[4][13][13];

	@ObfuscatedName("client.ek")
	public static final int[] LOC_SHAPE_TO_LAYER = new int[] { 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3 };

	@ObfuscatedName("as.eq")
	public static int baseX;

	@ObfuscatedName("cx.et")
	public static int baseZ;

	@ObfuscatedName("client.ee")
	public static int tryMoveNearest = 0;

	@ObfuscatedName("client.ed")
	public static int[][] field2041 = new int[104][104];

	@ObfuscatedName("client.ex")
	public static int[][] field1946 = new int[104][104];

	@ObfuscatedName("client.ea")
	public static int[] field1984 = new int[4000];

	@ObfuscatedName("client.ep")
	public static int[] field1985 = new int[4000];

	@ObfuscatedName("client.em")
	public static int macroCameraX = 0;

	@ObfuscatedName("client.ey")
	public static int macroCameraXModifier = 2;

	@ObfuscatedName("client.ec")
	public static int macroCameraZ = 0;

	@ObfuscatedName("client.eo")
	public static int macroCameraZModifier = 2;

	@ObfuscatedName("client.eu")
	public static int macroCameraAngle = 0;

	@ObfuscatedName("client.fd")
	public static int macroCameraAngleModifier = 1;

	@ObfuscatedName("client.fb")
	public static int macroCameraCycle = 0;

	@ObfuscatedName("client.fc")
	public static int macroMinimapAngle = 0;

	@ObfuscatedName("client.fe")
	public static int macroMinimapAngleModifier = 2;

	@ObfuscatedName("client.fj")
	public static int macroMinimapZoom = 0;

	@ObfuscatedName("client.fp")
	public static int macroMinimapZoomModifier = 1;

	@ObfuscatedName("client.fg")
	public static int macroMinimapCycle = 0;

	@ObfuscatedName("client.fv")
	public static int worldUpdateNum = 0;

	@ObfuscatedName("al.fu")
	public static Pix32 compass;

	@ObfuscatedName("df.fr")
	public static Pix32 mapedge;

	@ObfuscatedName("y.fl")
	public static Pix8[] mapscene;

	@ObfuscatedName("ez.fk")
	public static Pix32[] mapfunction;

	@ObfuscatedName("cp.fa")
	public static Pix32[] hitmarks;

	@ObfuscatedName("bf.fq")
	public static Pix32[] headiconsPk;

	@ObfuscatedName("i.ft")
	public static Pix32[] headiconsPrayer;

	@ObfuscatedName("ef.fx")
	public static Pix32[] headiconsHint;

	@ObfuscatedName("bq.fs")
	public static Pix32[] mapmarker;

	@ObfuscatedName("ej.fh")
	public static Pix32[] cross;

	@ObfuscatedName("bs.ff")
	public static Pix32[] mapdots;

	@ObfuscatedName("ez.fy")
	public static Pix8[] scrollbar;

	@ObfuscatedName("ej.fn")
	public static Pix8[] modIcons;

	@ObfuscatedName("by.fz")
	public static Pix8 mapback;

	@ObfuscatedName("be.fw")
	public static int[] compassMaskLineOffsets;

	@ObfuscatedName("g.fo")
	public static int[] compassMaskLineLengths;

	@ObfuscatedName("bq.fm")
	public static int[] minimapMaskLineOffsets;

	@ObfuscatedName("cd.fi")
	public static int[] minimapMaskLineLengths;

	@ObfuscatedName("client.ge")
	public static int SCROLLBAR_TRACK = 2301979;

	@ObfuscatedName("client.gq")
	public static int SCROLLBAR_GRIP_FOREGROUND = 5063219;

	@ObfuscatedName("client.gr")
	public static int SCROLLBAR_GRIP_LOWLIGHT = 3353893;

	@ObfuscatedName("client.gd")
	public static int SCROLLBAR_GRIP_HIGHLIGHT = 7759444;

	@ObfuscatedName("client.gh")
	public static boolean scrollGrabbed = false;

	@ObfuscatedName("client.gm")
	public static int scrollInputPadding = 0;

	@ObfuscatedName("ct.gw")
	public static int camX;

	@ObfuscatedName("bv.gn")
	public static int camY;

	@ObfuscatedName("y.gj")
	public static int camZ;

	@ObfuscatedName("bb.gk")
	public static int camPitch;

	@ObfuscatedName("bs.gx")
	public static int camYaw;

	@ObfuscatedName("client.gl")
	public static int orbitCameraPitch = 128;

	@ObfuscatedName("client.gz")
	public static int orbitCameraYaw = 0;

	@ObfuscatedName("client.gp")
	public static int orbitCameraYawVelocity = 0;

	@ObfuscatedName("client.gf")
	public static int orbitCameraPitchVelocity = 0;

	@ObfuscatedName("ca.gv")
	public static int orbitCameraX;

	@ObfuscatedName("dl.gt")
	public static int orbitCameraZ;

	@ObfuscatedName("client.gg")
	public static int sendCameraDelay = 0;

	@ObfuscatedName("client.gy")
	public static boolean sendCamera = false;

	@ObfuscatedName("client.gu")
	public static int cameraPitchClamp = 0;

	@ObfuscatedName("client.gb")
	public static int chatCount = 0;

	@ObfuscatedName("client.gs")
	public static int MAX_CHATS = 50;

	@ObfuscatedName("client.gi")
	public static int[] chatX = new int[MAX_CHATS];

	@ObfuscatedName("client.ga")
	public static int[] chatY = new int[MAX_CHATS];

	@ObfuscatedName("client.go")
	public static int[] chatHeight = new int[MAX_CHATS];

	@ObfuscatedName("client.gc")
	public static int[] chatWidth = new int[MAX_CHATS];

	@ObfuscatedName("client.hb")
	public static int[] chatColour = new int[MAX_CHATS];

	@ObfuscatedName("client.hw")
	public static int[] chatEffect = new int[MAX_CHATS];

	@ObfuscatedName("client.hv")
	public static int[] chatTimer = new int[MAX_CHATS];

	@ObfuscatedName("client.he")
	public static String[] chats = new String[MAX_CHATS];

	@ObfuscatedName("client.hk")
	public static int[][] tileLastOccupiedCycle = new int[104][104];

	@ObfuscatedName("client.hr")
	public static int sceneCycle = 0;

	@ObfuscatedName("client.hm")
	public static int projectX = -1;

	@ObfuscatedName("client.hu")
	public static int projectY = -1;

	@ObfuscatedName("client.hl")
	public static int crossX = 0;

	@ObfuscatedName("client.hj")
	public static int crossY = 0;

	@ObfuscatedName("client.hn")
	public static int crossCycle = 0;

	@ObfuscatedName("client.hs")
	public static int crossMode = 0;

	@ObfuscatedName("be.hf")
	public static IfType selectedArea;

	@ObfuscatedName("client.hi")
	public static int selectedCycle = 0;

	@ObfuscatedName("client.hd")
	public static int selectedItem = 0;

	@ObfuscatedName("ck.ha")
	public static IfType objDragInterface;

	@ObfuscatedName("cv.hg")
	public static IfType hoveredSlotParent;

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
	public static int overrideChat = 0;

	@ObfuscatedName("client.iq")
	public static ClientPlayer[] players = new ClientPlayer[2048];

	@ObfuscatedName("client.ie")
	public static int playerCount = 0;

	@ObfuscatedName("client.if")
	public static int[] playerIds = new int[2048];

	@ObfuscatedName("client.ih")
	public static int entityUpdateCount = 0;

	@ObfuscatedName("client.ic")
	public static int[] entityUpdateIds = new int[2048];

	@ObfuscatedName("client.im")
	public static Packet[] playerAppearanceBuffer = new Packet[2048];

	@ObfuscatedName("client.ik")
	public static int selfSlot = -1;

	@ObfuscatedName("client.iy")
	public static int membersAccount = 0;

	@ObfuscatedName("client.ij")
	public static int entityRemovalCount = 0;

	@ObfuscatedName("client.io")
	public static int[] entityRemovalIds = new int[1000];

	@ObfuscatedName("client.ia")
	public static final int[] MENUACTION_PLAYER = new int[] { 44, 45, 46, 47, 48, 49, 50, 51 };

	@ObfuscatedName("client.id")
	public static String[] playerOp = new String[8];

	@ObfuscatedName("client.ib")
	public static boolean[] playerOpPriority = new boolean[8];

	@ObfuscatedName("client.il")
	public static int[] field1941 = new int[] { 768, 1024, 1280, 512, 1536, 256, 0, 1792 };

	@ObfuscatedName("an.ix")
	public static int field502; // todo

	@ObfuscatedName("cr.ii")
	public static ClientPlayer localPlayer; // todo

	@ObfuscatedName("al.in")
	public static int minusedlevel; // todo

	@ObfuscatedName("ag.iz")
	public static int field555; // todo

	@ObfuscatedName("client.ir")
	public static LinkList[][][] objStacks = new LinkList[4][104][104];

	@ObfuscatedName("client.iv")
	public static LinkList locChanges = new LinkList();

	@ObfuscatedName("client.ig")
	public static LinkList projectiles = new LinkList();

	@ObfuscatedName("client.ip")
	public static LinkList spotanims = new LinkList();

	@ObfuscatedName("client.it")
	public static String field2078 = null; // todo

	@ObfuscatedName("client.iw")
	public static int[] skillLevel = new int[25];

	@ObfuscatedName("client.iu")
	public static int[] skillBaseLevel = new int[25];

	@ObfuscatedName("client.jc")
	public static int[] skillExperience = new int[25];

	@ObfuscatedName("client.je")
	public static int oneMouseButton = 0;

	@ObfuscatedName("client.jj")
	public static boolean isMenuOpen = false;

	@ObfuscatedName("client.jp")
	public static int menuNumEntries = 0;

	@ObfuscatedName("client.jg")
	public static int[] menuParamB = new int[500];

	@ObfuscatedName("client.jn")
	public static int[] menuParamC = new int[500];

	@ObfuscatedName("client.jr")
	public static int[] menuAction = new int[500];

	@ObfuscatedName("client.js")
	public static int[] menuParamA = new int[500];

	@ObfuscatedName("client.jl")
	public static String[] menuVerb = new String[500];

	@ObfuscatedName("client.jm")
	public static String[] menuSubject = new String[500];

	@ObfuscatedName("client.jz")
	public static int minimenuMouseOverX = -1;

	@ObfuscatedName("client.jx")
	public static int minimenuMouseOverY = -1;

	@ObfuscatedName("client.ju")
	public static int field1995 = 0;

	@ObfuscatedName("client.ja")
	public static int field2076 = 50;

	@ObfuscatedName("client.jo")
	public static int useMode = 0;

	@ObfuscatedName("client.jh")
	public static boolean targetMode = false;

	@ObfuscatedName("client.jw")
	public static int targetSub = -1;

	@ObfuscatedName("ca.jf")
	public static int menuX; // todo

	@ObfuscatedName("l.jy")
	public static IfType field37; // todo

	@ObfuscatedName("m.jd")
	public static int menuHeight; // todo

	@ObfuscatedName("m.jv")
	public static int targetCom; // todo

	@ObfuscatedName("al.jt")
	public static int menuWidth; // todo

	@ObfuscatedName("ag.jb")
	public static int field557; // todo

	@ObfuscatedName("at.jq")
	public static IfType field654; // todo

	@ObfuscatedName("bk.ji")
	public static int menuY; // todo

	@ObfuscatedName("client.kn")
	public static String targetVerb = null;

	@ObfuscatedName("client.kg")
	public static String targetOp = null;

	@ObfuscatedName("client.ki")
	public static int toplevelinterface = -1;

	@ObfuscatedName("client.ky")
	public static HashTable subinterfaces = new HashTable(8);

	@ObfuscatedName("client.ko")
	public static int chatEffects = 0;

	@ObfuscatedName("client.kl")
	public static int bankArrangeMode = 0;

	@ObfuscatedName("client.ka")
	public static IfType resumedPauseButton = null;

	@ObfuscatedName("client.kr")
	public static int runEnergy = 0;

	@ObfuscatedName("client.ku")
	public static int runWeight = 0;

	@ObfuscatedName("client.kp")
	public static int staffmodlevel = 0;

	@ObfuscatedName("client.kw")
	public static boolean playermod = false;

	@ObfuscatedName("client.kc")
	public static boolean field2092 = false;

	@ObfuscatedName("client.km")
	public static boolean field2001 = false;

	@ObfuscatedName("client.ke")
	public static IfType dragComponent = null;

	@ObfuscatedName("client.kx")
	public static IfType dragParent = null;

	@ObfuscatedName("client.kk")
	public static int dragPickupX = 0;

	@ObfuscatedName("client.kb")
	public static int dragPickupY = 0;

	@ObfuscatedName("client.kj")
	public static IfType dropComponent = null;

	@ObfuscatedName("client.kd")
	public static boolean dragParentFound = false;

	@ObfuscatedName("client.kv")
	public static int dragParentX = -1;

	@ObfuscatedName("client.kf")
	public static int dragParentY = -1;

	@ObfuscatedName("client.kz")
	public static boolean dragging = false;

	@ObfuscatedName("client.kq")
	public static int dragCurrentX = -1;

	@ObfuscatedName("client.ks")
	public static int dragCurrentY = -1;

	@ObfuscatedName("client.kh")
	public static boolean dragAlive = false;

	@ObfuscatedName("ak.kt")
	public static int targetMask; // todo

	@ObfuscatedName("client.lg")
	public static int interfaceUpdateNum = 1;

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
	public static int chatTransmitNum = 0;

	@ObfuscatedName("client.lc")
	public static int friendSystemUpdateNum = 0;

	@ObfuscatedName("client.lw")
	public static int friendChatUpdateNum = 0;

	@ObfuscatedName("client.lv")
	public static int field2119 = 0;

	@ObfuscatedName("client.lx")
	public static int[] field2120 = new int[2000];

	@ObfuscatedName("client.ld")
	public static String[] field1996 = new String[1000];

	@ObfuscatedName("client.le")
	public static int mouseWheelRotation = 0;

	@ObfuscatedName("client.lt")
	public static LinkList hookRequests = new LinkList();

	@ObfuscatedName("client.lo")
	public static LinkList hookRequestsTimer = new LinkList();

	@ObfuscatedName("client.lf")
	public static LinkList hookRequestsMouseStop = new LinkList();

	@ObfuscatedName("client.lz")
	public static HashTable serverActive = new HashTable(512);

	@ObfuscatedName("cv.ll")
	public static int dragTime; // todo

	@ObfuscatedName("dz.lj")
	public static IfType[] field1516; // todo

	@ObfuscatedName("client.lh")
	public static int field2106; // todo

	@ObfuscatedName("m.la")
	public static int field44; // todo

	@ObfuscatedName("az.lu")
	public static MouseWheelProvider field484; // todo

	@ObfuscatedName("client.mw")
	public static int componentDrawCount = 0;

	@ObfuscatedName("client.mo")
	public static int componentDrawTime = -2;

	@ObfuscatedName("client.mq")
	public static boolean[] componentRedrawRequested1 = new boolean[100];

	@ObfuscatedName("client.me")
	public static boolean[] componentRedrawRequested2 = new boolean[100];

	@ObfuscatedName("client.mn")
	public static boolean[] componentDrawSomething2 = new boolean[100];

	@ObfuscatedName("client.mi")
	public static int[] componentDrawX = new int[100];

	@ObfuscatedName("client.mh")
	public static int[] componentDrawY = new int[100];

	@ObfuscatedName("client.mp")
	public static int[] componentDrawWidth = new int[100];

	@ObfuscatedName("client.ma")
	public static int[] componentDrawHeight = new int[100];

	@ObfuscatedName("client.ms")
	public static int componentDrawMode = 0;

	@ObfuscatedName("client.mt")
	public static int[] messageType = new int[100];

	@ObfuscatedName("client.mc")
	public static String[] messageSender = new String[100];

	@ObfuscatedName("client.mr")
	public static String[] field2173 = new String[100];

	@ObfuscatedName("client.mx")
	public static String[] messageText = new String[100];

	@ObfuscatedName("client.mv")
	public static int chatHistoryLength = 0;

	@ObfuscatedName("client.my")
	public static int[] CHAT_COLOURS = new int[] { 16776960, 16711680, 65280, 65535, 16711935, 16777215 };

	@ObfuscatedName("client.mf")
	public static int publicChatFilter = 0;

	@ObfuscatedName("client.mz")
	public static int tradeChatFilter = 0;

	@ObfuscatedName("client.mj")
	public static long[] field2148 = new long[100];

	@ObfuscatedName("client.ml")
	public static int field2149 = 0;

	@ObfuscatedName("client.mk")
	public static int field2151 = 0;

	@ObfuscatedName("client.mb")
	public static int[] keypressKeychars = new int[128];

	@ObfuscatedName("au.mg")
	public static ChatFilterPrivacy privateChatFilter; // todo

	@ObfuscatedName("client.ne")
	public static int[] keypressKeycodes = new int[128];

	@ObfuscatedName("client.nc")
	public static String chatDisplayName = null;

	@ObfuscatedName("client.nh")
	public static String field2155 = null;

	@ObfuscatedName("client.nw")
	public static int minimapLevel = -1;

	@ObfuscatedName("client.nb")
	public static int activeMapFunctionCount = 0;

	@ObfuscatedName("client.ng")
	public static int[] activeMapFunctionX = new int[1000];

	@ObfuscatedName("client.nu")
	public static int[] activeMapFunctionZ = new int[1000];

	@ObfuscatedName("client.no")
	public static Pix32[] activeMapFunctions = new Pix32[1000];

	@ObfuscatedName("client.nv")
	public static int minimapFlagX = 0;

	@ObfuscatedName("client.nz")
	public static int minimapFlagZ = 0;

	@ObfuscatedName("client.nt")
	public static int minimapState = 0;

	@ObfuscatedName("client.nl")
	public static int midiVolume = 255;

	@ObfuscatedName("client.nn")
	public static int previousSong = -1;

	@ObfuscatedName("client.nq")
	public static boolean field2189 = false;

	@ObfuscatedName("client.nf")
	public static int waveVolume = 127;

	@ObfuscatedName("cz.ny")
	public static byte chatRank; // todo

	@ObfuscatedName("cv.nm")
	public static int field1220; // todo

	@ObfuscatedName("df.nr")
	public static byte chatMinKick; // todo

	@ObfuscatedName("dl.ns")
	public static Pix32 minimap; // todo

	@ObfuscatedName("eh.nd")
	public static FriendChatUser[] field1774; // todo

	@ObfuscatedName("client.oz")
	public static int ambientVolume = 127;

	@ObfuscatedName("client.os")
	public static int waveCount = 0;

	@ObfuscatedName("client.oe")
	public static int[] waveSoundIds = new int[50];

	@ObfuscatedName("client.of")
	public static int[] waveLoops = new int[50];

	@ObfuscatedName("client.ov")
	public static int[] waveDelay = new int[50];

	@ObfuscatedName("client.oo")
	public static int[] waveAmbient = new int[50];

	@ObfuscatedName("client.ok")
	public static JagFx[] waveSounds = new JagFx[50];

	@ObfuscatedName("client.oa")
	public static boolean cinemaCam = false;

	@ObfuscatedName("client.ol")
	public static boolean[] camShake = new boolean[5];

	@ObfuscatedName("client.oj")
	public static int[] camShakeAxis = new int[5];

	@ObfuscatedName("br.om")
	public static int cutsceneSrcLocalTileZ; // todo

	@ObfuscatedName("co.op")
	public static int cutsceneMoveAcceleration; // todo

	@ObfuscatedName("ct.or")
	public static int cutsceneDstLocalTileX; // todo

	@ObfuscatedName("cq.oc")
	public static Mixer soundMixer; // todo

	@ObfuscatedName("cq.ob")
	public static int cutsceneDstHeight; // todo

	@ObfuscatedName("df.ou")
	public static int cutsceneRotateAcceleration; // todo

	@ObfuscatedName("de.oy")
	public static int cutsceneRotateSpeed; // todo

	@ObfuscatedName("ev.od")
	public static Decimator soundDecimator; // todo

	@ObfuscatedName("l.on")
	public static PcmPlayer midiPcmPlayer; // todo

	@ObfuscatedName("be.ox")
	public static int cutsceneSrcLocalTileX; // todo

	@ObfuscatedName("bp.og")
	public static int cutsceneDstLocalTileZ; // todo

	@ObfuscatedName("dq.oq")
	public static int cutsceneSrcHeight; // todo

	@ObfuscatedName("du.oh")
	public static int cutsceneMoveSpeed; // todo

	@ObfuscatedName("dr.oi")
	public static PcmPlayer soundPcmPlayer; // todo

	@ObfuscatedName("client.pk")
	public static int[] camShakeRan = new int[5];

	@ObfuscatedName("client.pt")
	public static int[] camShakeAmp = new int[5];

	@ObfuscatedName("client.ps")
	public static int[] camShakeCycle = new int[5];

	@ObfuscatedName("client.pi")
	public static int friendCount = 0;

	@ObfuscatedName("client.pq")
	public static int friendListStatus = 0;

	@ObfuscatedName("client.pf")
	public static FriendListEntry[] friendList = new FriendListEntry[200];

	@ObfuscatedName("client.pm")
	public static ChatLinkList field2193 = new ChatLinkList();

	@ObfuscatedName("client.pr")
	public static int ignoreCount = 0;

	@ObfuscatedName("client.pe")
	public static IgnoreListEntry[] ignoreList = new IgnoreListEntry[100];

	@ObfuscatedName("client.pd")
	public static PlayerModel selfModel = new PlayerModel();

	@ObfuscatedName("client.pv")
	public static int genderButton1 = -1;

	@ObfuscatedName("client.pz")
	public static int genderButton2 = -1;

	@ObfuscatedName("r.pa")
	public static DataFile masterIndex;

	@ObfuscatedName("client.f(I)V")
	public final void reset() {
	}

	public static void main(String[] args) {
		Client app = new Client();
		app.startApplication(765, 503, 1);
	}

	@Override
	public URL getCodeBase() {
		try {
			if (GameShell.frame != null) {
				return new URL("http://localhost:7001");
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
			return "http://localhost:7001/slr.ws?order=LPWM";
		}

		return null;
	}

	@Override
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
				switch (Integer.parseInt(var4.id)) {
					case 1:
						if (var5.equalsIgnoreCase(StringConstants.TRUE_S)) {
							js = 1;
						} else {
							js = 0;
						}
						break;
					case 2:
						worldid = Integer.parseInt(var5);
					case 3:
						break;
					case 4:
						lang = Integer.parseInt(var5);
						break;
					case 5:
						modewhat = ModeWhat.get(Integer.parseInt(var5));
						break;
					case 6:
						if (var5.equalsIgnoreCase(StringConstants.TRUE_S)) {
							memServer = true;
						} else {
							memServer = false;
						}
						break;
					case 7:
						modewhere = Integer.parseInt(var5);
						break;
					case 8:
						modegame = ModeGame.get(Integer.parseInt(var5));

						if (ModeGame.OLDSCAPE == modegame) {
							namespace = NameSpace.RUNESCAPE;
						} else {
							namespace = NameSpace.LEGACY;
						}
						break;
					case 9:
						TitleScreen.worldlistUrl = var5;
						break;
				}
			}
		}
		setHighMemory();
		loginHost = this.getCodeBase().getHost();
		GameShellCache.imethod1(modewhat.name, 0);
		this.startCommon(765, 503, 1);
	}

	@ObfuscatedName("client.w(I)V")
	public final void maininit() {
		loginGamePort = modewhere == 0 ? 43594 : worldid + 40000;
		loginJs5Port = modewhere == 0 ? 443 : worldid + 50000;
		loginPort = loginGamePort;
		PlayerModel.recol1s = RecolsRunescape.recol1s;
		PlayerModel.recol1d = RecolsRunescape.recol1d;
		PlayerModel.recol2s = RecolsRunescape.recol2s;
		PlayerModel.recol2d = RecolsRunescape.recol2d;
		JavaKeyboardProvider.imethod1();
		JavaKeyboardProvider.method53(GameShell.canvas);
		JavaMouseProvider.addListeners(GameShell.canvas);
		field484 = MouseWheelProvider.method779();
		if (field484 != null) {
			field484.method360(GameShell.canvas);
		}
		masterIndex = new DataFile(255, GameShellCache.cacheDat, GameShellCache.masterIndex, 500000);
		if (modewhere != 0) {
			showFps = true;
		}
	}

	@ObfuscatedName("client.e(B)V")
	public final void mainloop() {
		loopCycle++;

		this.js5update();

		imethod1();
		MidiManager.method825();

		flushAudio();
		JavaKeyboardProvider.imethod4();
		JavaMouseProvider.imethod3();

		if (field484 != null) {
			int var10 = field484.method362();
			mouseWheelRotation = var10;
		}

		if (state == 0) {
			mainload();
			GameShell.doneslowupdate();
		} else if (state == 5) {
			TitleScreen.loop(this);
			mainload();
			GameShell.doneslowupdate();
		} else if (state == 10) {
			TitleScreen.loop(this);
		} else if (state == 20) {
			TitleScreen.loop(this);
			loginPoll();
		} else if (state == 25) {
			mapBuildLoop();
		} else if (state == 30) {
			gameLoop();
		} else if (state == 40) {
			loginPoll();
		}
	}

	@ObfuscatedName("client.b(I)V")
	public final void mainredraw() {
		boolean var1 = MidiManager.method511();
		if (var1 && field2189 && midiPcmPlayer != null) {
			midiPcmPlayer.play();
		}
		if (canvasReplaceRecommended) {
			JavaKeyboardProvider.method1143(GameShell.canvas);
			JavaMouseProvider.removeListeners(GameShell.canvas);
			if (field484 != null) {
				field484.method361(GameShell.canvas);
			}
			this.addcanvas();
			JavaKeyboardProvider.method53(GameShell.canvas);
			JavaMouseProvider.addListeners(GameShell.canvas);
			if (field484 != null) {
				field484.method360(GameShell.canvas);
			}
		}
		if (state == 0) {
			GameShell.drawProgress(TitleScreen.loadPos, TitleScreen.loadString, null);
		} else if (state == 5) {
			TitleScreen.draw(fontBold12, fontPlain11);
		} else if (state == 10) {
			TitleScreen.draw(fontBold12, fontPlain11);
		} else if (state == 20) {
			TitleScreen.draw(fontBold12, fontPlain11);
		} else if (state == 25) {
			if (mapLoadingStage == 1) {
				if (mapLoadCount > mapLoadPrevCount) {
					mapLoadPrevCount = mapLoadCount;
				}
				int var12 = (mapLoadPrevCount * 50 - mapLoadCount * 50) / mapLoadPrevCount;
				messageBox(Text.LOADING + StringConstants.TAG_BREAK + StringConstants.OPEN_BRACKET + var12 + "%" + StringConstants.CLOSE_BRACKET, false);
			} else if (mapLoadingStage == 2) {
				if (locModelLoadCount > locModelLoadPrevCount) {
					locModelLoadPrevCount = locModelLoadCount;
				}
				int var13 = (locModelLoadPrevCount * 50 - locModelLoadCount * 50) / locModelLoadPrevCount + 50;
				messageBox(Text.LOADING + StringConstants.TAG_BREAK + StringConstants.OPEN_BRACKET + var13 + "%" + StringConstants.CLOSE_BRACKET, false);
			} else {
				messageBox(Text.LOADING, false);
			}
		} else if (state == 30) {
			gameDraw();
		} else if (state == 40) {
			messageBox(Text.CONLOST + StringConstants.TAG_BREAK + Text.ATTEMPT_TO_REESTABLISH, false);
		}

		if (state == 30 && componentDrawMode == 0 && !fullredraw) {
			try {
				Graphics var43 = GameShell.canvas.getGraphics();
				for (int var44 = 0; var44 < componentDrawCount; var44++) {
					if (componentRedrawRequested2[var44]) {
						GameShell.drawArea.draw(var43, componentDrawX[var44], componentDrawY[var44], componentDrawWidth[var44], componentDrawHeight[var44]);
						componentRedrawRequested2[var44] = false;
					}
				}
			} catch (Exception var52) {
				GameShell.canvas.repaint();
			}
		} else if (state > 0) {
			try {
				Graphics var46 = GameShell.canvas.getGraphics();
				GameShell.drawArea.draw(var46, 0, 0);
				fullredraw = false;
				for (int var47 = 0; var47 < componentDrawCount; var47++) {
					componentRedrawRequested2[var47] = false;
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
		if (loginStream != null) {
			loginStream.close();
			loginStream = null;
		}
		JavaKeyboardProvider.method1502();
		JavaMouseProvider.imethod2();
		field484 = null;
		if (midiPcmPlayer != null) {
			midiPcmPlayer.shutdown();
		}
		if (soundPcmPlayer != null) {
			soundPcmPlayer.shutdown();
		}
		if (Js5Net.stream != null) {
			Js5Net.stream.close();
		}
		Js5NetThread.method781();
		GameShellCache.method1141();
	}

	// jag::oldscape::Client::SetMainState
	@ObfuscatedName("aj.ce(II)V")
	public static void setMainState(int newState) {
		if (state == newState) {
			return;
		}

		if (state == 0) {
			GameShell.resetProgress();
		}

		if (newState == 20 || newState == 40) {
			loginStep = 0;
			loginWaitingTime = 0;
			loginFailCount = 0;
		}

		if (newState != 20 && newState != 40 && stream != null) {
			stream.close();
			stream = null;
		}

		if (state == 25) {
			mapLoadingStage = 0;
			mapLoadCount = 0;
			mapLoadPrevCount = 1;
			locModelLoadCount = 0;
			locModelLoadPrevCount = 1;
		}

		if (newState == 5 || newState == 10 || newState == 20) {
			TitleScreen.open(GameShell.canvas, binary, sprites);
		} else {
			TitleScreen.close();
		}

		state = newState;
	}

	@ObfuscatedName("client.ci(I)V")
	public void js5update() {
		if (state != 1000) {
			boolean var1 = Js5Net.loop();
			if (!var1) {
				this.method1850();
			}
		}
	}

	@ObfuscatedName("client.cb(I)V")
	public void method1850() {
		if (Js5Net.crcErrorCount >= 4) {
			this.error("js5crc");
			state = 1000;
			return;
		}

		if (Js5Net.ioErrorCount >= 4) {
			if (state <= 5) {
				this.error("js5io");
				state = 1000;
				return;
			}
			js5ConnectCooldown = 3000;
			Js5Net.ioErrorCount = 3;
		}

		if (--js5ConnectCooldown + 1 > 0) {
			return;
		}

		try {
			if (js5ConnectState == 0) {
				js5SocketReq = GameShell.signLink.socketreq(loginHost, loginPort);
				js5ConnectState++;
			}

			if (js5ConnectState == 1) {
				if (js5SocketReq.status == 2) {
					this.js5error(-1);
					return;
				}

				if (js5SocketReq.status == 1) {
					js5ConnectState++;
				}
			}

			if (js5ConnectState == 2) {
				js5Stream = new ClientStream((Socket) js5SocketReq.result, GameShell.signLink);
				Packet var1 = new Packet(5);
				var1.p1(15); // INIT_JS5REMOTE_CONNECTION
				var1.p4(1); // revision
				js5Stream.write(var1.data, 0, 5);
				js5ConnectState++;
				field1943 = MonotonicTime.currentTime();
			}

			if (js5ConnectState == 3) {
				if (state <= 5 || js5Stream.available() > 0) {
					int response = js5Stream.read();
					if (response != 0) {
						this.js5error(response);
						return;
					}

					js5ConnectState++;
				} else if (MonotonicTime.currentTime() - field1943 > 30000L) {
					this.js5error(-2);
					return;
				}
			}

			if (js5ConnectState == 4) {
				Js5Net.init(js5Stream, state > 20);
				js5SocketReq = null;
				js5Stream = null;
				js5ConnectState = 0;
				js5Errors = 0;
			}
		} catch (IOException ex) {
			this.js5error(-3);
		}
	}

	@ObfuscatedName("client.cf(II)V")
	public void js5error(int arg0) {
		js5SocketReq = null;
		js5Stream = null;
		js5ConnectState = 0;

		if (loginGamePort == loginPort) {
			loginPort = loginJs5Port;
		} else {
			loginPort = loginGamePort;
		}

		js5Errors++;

		if (js5Errors >= 2 && (arg0 == 7 || arg0 == 9)) {
			if (state <= 5) {
				this.error("js5connect_full");
				state = 1000;
			} else {
				js5ConnectCooldown = 3000;
			}
		} else if (js5Errors >= 2 && arg0 == 6) {
			this.error("js5connect_outofdate");
			state = 1000;
		} else if (js5Errors >= 4) {
			if (state <= 5) {
				this.error("js5connect");
				state = 1000;
			} else {
				js5ConnectCooldown = 3000;
			}
		}
	}

	@ObfuscatedName("bv.cg(B)V")
	public static void mainload() {
		if (loadingStep == 0) {
			world = new World(4, 104, 104, ClientBuild.groundh);
			for (int level = 0; level < 4; level++) {
				levelCollisionMap[level] = new CollisionMap(104, 104);
			}
			minimap = new Pix32(512, 512);

			TitleScreen.loadString = Text.MAINLOAD0;
			TitleScreen.loadPos = 5;
			loadingStep = 20;
		} else if (loadingStep == 20) {
			int[] var1 = new int[9];
			for (int var2 = 0; var2 < 9; var2++) {
				int var3 = var2 * 32 + 128 + 15;
				int var4 = var3 * 3 + 600;
				int var5 = Pix3D.sinTable[var3];
				var1[var2] = var4 * var5 >> 16;
			}
			World.init(var1, 500, 800, 512, 334);

			TitleScreen.loadString = Text.MAINLOAD20;
			TitleScreen.loadPos = 10;
			loadingStep = 30;
		} else if (loadingStep == 30) {
			anims = openJs5(0, false, true, true);
			bases = openJs5(1, false, true, true);
			config = openJs5(2, true, false, true);
			interfaces = openJs5(3, false, true, true);
			jagFX = openJs5(4, false, true, true);
			maps = openJs5(5, true, true, true);
			songs = openJs5(6, true, true, false);
			models = openJs5(7, false, true, true);
			sprites = openJs5(8, false, true, true);
			textures = openJs5(9, false, true, true);
			binary = openJs5(10, false, true, true);
			jingles = openJs5(11, false, true, true);
			scripts = openJs5(12, false, true, true);
			fontMetrics = openJs5(13, true, false, true);
			vorbis = openJs5(14, false, true, false);
			patches = openJs5(15, false, true, true);

			TitleScreen.loadString = Text.MAINLOAD30;
			TitleScreen.loadPos = 20;
			loadingStep = 40;
		} else if (loadingStep == 40) {
			byte var6 = 0;
			int var7 = var6 + anims.getIndexPercentage() * 4 / 100;
			int var8 = var7 + bases.getIndexPercentage() * 4 / 100;
			int var9 = var8 + config.getIndexPercentage() * 2 / 100;
			int var10 = var9 + interfaces.getIndexPercentage() * 2 / 100;
			int var11 = var10 + jagFX.getIndexPercentage() * 6 / 100;
			int var12 = var11 + maps.getIndexPercentage() * 4 / 100;
			int var13 = var12 + songs.getIndexPercentage() * 2 / 100;
			int var14 = var13 + models.getIndexPercentage() * 60 / 100;
			int var15 = var14 + sprites.getIndexPercentage() * 2 / 100;
			int var16 = var15 + textures.getIndexPercentage() * 2 / 100;
			int var17 = var16 + binary.getIndexPercentage() * 2 / 100;
			int var18 = var17 + jingles.getIndexPercentage() * 2 / 100;
			int var19 = var18 + scripts.getIndexPercentage() * 2 / 100;
			int var20 = var19 + fontMetrics.getIndexPercentage() * 2 / 100;
			int var21 = var20 + vorbis.getIndexPercentage() * 2 / 100;
			int var22 = var21 + patches.getIndexPercentage() * 2 / 100;

			if (var22 != 100) {
				if (var22 != 0) {
					TitleScreen.loadString = Text.MAINLOAD40 + var22 + "%";
				}
				TitleScreen.loadPos = 30;
			} else {
				TitleScreen.loadString = Text.MAINLOAD40B;
				TitleScreen.loadPos = 30;
				loadingStep = 45;
			}
		} else if (loadingStep == 45) {
			PcmPlayer.init(22050, !lowMemory, 2);

			MidiPlayer midiPlayer = new MidiPlayer();
			midiPlayer.setChannelDefaultPatch(9, 128);
			midiPcmPlayer = PcmPlayer.getPlayer(GameShell.signLink, GameShell.canvas, 0, 22050);
			midiPcmPlayer.playStream(midiPlayer);
			MidiManager.init(patches, vorbis, jagFX, midiPlayer);

			soundPcmPlayer = PcmPlayer.getPlayer(GameShell.signLink, GameShell.canvas, 1, 2048);
			soundMixer = new Mixer();
			soundPcmPlayer.playStream(soundMixer);
			soundDecimator = new Decimator(22050, PcmPlayer.frequency);

			TitleScreen.loadString = Text.MAINLOAD45;
			TitleScreen.loadPos = 35;
			loadingStep = 50;
		} else if (loadingStep == 50) {
			int var24 = 0;
			if (fontPlain11 == null) {
				fontPlain11 = PixLoader.makeFont(sprites, fontMetrics, "p11_full", "");
			} else {
				var24++;
			}
			if (fontPlain12 == null) {
				fontPlain12 = PixLoader.makeFont(sprites, fontMetrics, "p12_full", "");
			} else {
				var24++;
			}
			if (fontBold12 == null) {
				fontBold12 = PixLoader.makeFont(sprites, fontMetrics, "b12_full", "");
			} else {
				var24++;
			}

			if (var24 < 3) {
				TitleScreen.loadString = Text.MAINLOAD50 + var24 * 100 / 3 + "%";
				TitleScreen.loadPos = 40;
			} else {
				TitleScreen.loadString = Text.MAINLOAD50B;
				TitleScreen.loadPos = 40;
				loadingStep = 60;
			}
		} else if (loadingStep == 60) {
			int var27 = imethod48(binary, sprites);
			int var30 = TitleScreen.method162();

			if (var27 < var30) {
				TitleScreen.loadString = Text.MAINLOAD60 + var27 * 100 / var30 + "%";
				TitleScreen.loadPos = 50;
			} else {
				TitleScreen.loadString = Text.MAINLOAD60B;
				TitleScreen.loadPos = 50;
				setMainState(5);
				loadingStep = 70;
			}
		} else if (loadingStep == 70) {
			if (!config.requestFullDownload()) {
				TitleScreen.loadString = Text.MAINLOAD70 + config.getIndexLoadProgress() + "%";
				TitleScreen.loadPos = 60;
			} else {
				FloType.init(config);
				FluType.init(config);
				IdkType.init(config, models);
				LocType.init(config, models, lowMemory);
				NpcType.init(config, models);
				ObjType.init(config, models, memServer, fontPlain11);
				SeqType.init(config, anims, bases);
				SpotType.init(config, models);
				VarBitType.init(config);
				VarpType.init(config);
				IfType.init(interfaces, models, sprites, fontMetrics);
				InvType.init(config);
				EnumType.init(config);

				TitleScreen.loadString = Text.MAINLOAD70B;
				TitleScreen.loadPos = 60;
				loadingStep = 80;
			}
		} else if (loadingStep == 80) {
			int count = 0;

			if (compass == null) {
				compass = PixLoader.makePix32(sprites, "compass", "");
			} else {
				count++;
			}

			if (mapedge == null) {
				mapedge = PixLoader.makePix32(sprites, "mapedge", "");
			} else {
				count++;
			}

			if (mapscene == null) {
				mapscene = PixLoader.makePix8Array(sprites, "mapscene", "");
			} else {
				count++;
			}

			if (mapfunction == null) {
				mapfunction = PixLoader.makePix32Array(sprites, "mapfunction", "");
			} else {
				count++;
			}

			if (hitmarks == null) {
				hitmarks = PixLoader.makePix32Array(sprites, "hitmarks", "");
			} else {
				count++;
			}

			if (headiconsPk == null) {
				headiconsPk = PixLoader.makePix32Array(sprites, "headicons_pk", "");
			} else {
				count++;
			}

			if (headiconsPrayer == null) {
				headiconsPrayer = PixLoader.makePix32Array(sprites, "headicons_prayer", "");
			} else {
				count++;
			}

			if (headiconsHint == null) {
				headiconsHint = PixLoader.makePix32Array(sprites, "headicons_hint", "");
			} else {
				count++;
			}

			if (mapmarker == null) {
				mapmarker = PixLoader.makePix32Array(sprites, "mapmarker", "");
			} else {
				count++;
			}

			if (cross == null) {
				cross = PixLoader.makePix32Array(sprites, "cross", "");
			} else {
				count++;
			}

			if (mapdots == null) {
				mapdots = PixLoader.makePix32Array(sprites, "mapdots", "");
			} else {
				count++;
			}

			if (scrollbar == null) {
				scrollbar = PixLoader.makePix8Array(sprites, "scrollbar", "");
			} else {
				count++;
			}

			if (modIcons == null) {
				modIcons = PixLoader.makePix8Array(sprites, "mod_icons", "");
			} else {
				count++;
			}

			if (mapback == null) {
				mapback = PixLoader.makePix8(sprites, "mapback", "");
			} else {
				count++;
			}

			if (count < 14) {
				TitleScreen.loadString = Text.MAINLOAD80 + count * 100 / 14 + "%";
				TitleScreen.loadPos = 70;
			} else {
				PixFont.modicons = modIcons;

				mapedge.trim();

				int randR = (int) (Math.random() * 21.0D) - 10;
				int randG = (int) (Math.random() * 21.0D) - 10;
				int randB = (int) (Math.random() * 21.0D) - 10;
				int rand = (int) (Math.random() * 41.0D) - 20;

				for (int i = 0; i < mapfunction.length; i++) {
					mapfunction[i].rgbAdjust(randR + rand, randG + rand, randB + rand);
				}

				mapscene[0].rgbAdjust(randR + rand, randG + rand, randB + rand);

				prepareMinimap();

				TitleScreen.loadString = Text.MAINLOAD80B;
				TitleScreen.loadPos = 70;
				loadingStep = 90;
			}
		} else if (loadingStep == 90) {
			if (!textures.requestFullDownload()) {
				TitleScreen.loadString = Text.MAINLOAD90 + textures.getIndexLoadProgress() + "%";
				TitleScreen.loadPos = 90;
			} else {
				WorldTextureProvider provider = new WorldTextureProvider(textures, sprites, 20, 0.8D, lowMemory ? 64 : 128);
				Pix3D.setTextures(provider);
				Pix3D.initColourTable(0.8D);

				TitleScreen.loadString = Text.MAINLOAD90B;
				TitleScreen.loadPos = 90;
				loadingStep = 110;
			}
		} else if (loadingStep == 110) {
			mouseTracking = new MouseTracking();
			GameShell.signLink.threadreq(mouseTracking, 10);

			TitleScreen.loadString = Text.MAINLOAD110;
			TitleScreen.loadPos = 94;
			loadingStep = 120;
		} else if (loadingStep == 120) {
			if (!binary.requestDownload("huffman", "")) {
				TitleScreen.loadString = Text.MAINLOAD120 + "%";
				TitleScreen.loadPos = 96;
			} else {
				Huffman huffman = new Huffman(binary.getFile("huffman", ""));
				WordPack.setHuffman(huffman);

				TitleScreen.loadString = Text.MAINLOAD120B;
				TitleScreen.loadPos = 96;
				loadingStep = 130;
			}
		} else if (loadingStep == 130) {
			if (!interfaces.requestFullDownload()) {
				TitleScreen.loadString = Text.MAINLOAD130 + interfaces.getIndexLoadProgress() * 4 / 5 + "%";
				TitleScreen.loadPos = 100;
			} else if (!scripts.requestFullDownload()) {
				TitleScreen.loadString = Text.MAINLOAD130 + (scripts.getIndexLoadProgress() / 6 + 80) + "%";
				TitleScreen.loadPos = 100;
			} else if (!fontMetrics.requestFullDownload()) {
				TitleScreen.loadString = Text.MAINLOAD130 + (fontMetrics.getIndexLoadProgress() / 20 + 96) + "%";
				TitleScreen.loadPos = 100;
			} else {
				TitleScreen.loadString = Text.MAINLOAD130B;
				TitleScreen.loadPos = 100;
				loadingStep = 140;
			}
		} else if (loadingStep == 140) {
			setMainState(10);
		}
	}

	// jag::oldscape::Client::OpenJs5
	@ObfuscatedName("u.dd(IZZZB)Ldq;")
	public static Js5Loader openJs5(int archive, boolean arg1, boolean arg2, boolean arg3) {
		DataFile stream = null;
		if (GameShellCache.cacheDat != null) {
			stream = new DataFile(archive, GameShellCache.cacheDat, GameShellCache.cacheIndex[archive], 1000000);
		}
		return new Js5Loader(stream, masterIndex, archive, arg1, arg2, arg3);
	}

	// jag::oldscape::Client::LoginPoll
	@ObfuscatedName("ex.dg(I)V")
	public static void loginPoll() {
		try {
			if (loginStep == 0) {
				if (loginStream != null) {
					loginStream.close();
					loginStream = null;
				}
				field806 = null;
				networkError = false;
				loginWaitingTime = 0;
				loginStep = 1;
			}
			if (loginStep == 1) {
				if (field806 == null) {
					field806 = GameShell.signLink.socketreq(loginHost, loginPort);
				}
				if (field806.status == 2) {
					throw new IOException();
				}
				if (field806.status == 1) {
					loginStream = new ClientStream((Socket) field806.result, GameShell.signLink);
					field806 = null;
					loginStep = 2;
				}
			}
			if (loginStep == 2) {
				out.pos = 0;
				out.p1(14); // INIT_GAME_CONNECTION
				loginStream.write(out.data, 0, 1);
				in.pos = 0;
				loginStep = 3;
			}
			if (loginStep == 3) {
				if (midiPcmPlayer != null) {
					midiPcmPlayer.method207();
				}
				if (soundPcmPlayer != null) {
					soundPcmPlayer.method207();
				}

				int var0 = loginStream.read();

				if (midiPcmPlayer != null) {
					midiPcmPlayer.method207();
				}
				if (soundPcmPlayer != null) {
					soundPcmPlayer.method207();
				}

				if (var0 != 0) {
					loginError(var0);
					return;
				}

				in.pos = 0;
				loginStep = 5;
			}

			if (loginStep == 5) {
				int[] seed = new int[] {
						(int) (Math.random() * 9.9999999E7D),
						(int) (Math.random() * 9.9999999E7D),
						(int) (Math.random() * 9.9999999E7D),
						(int) (Math.random() * 9.9999999E7D)
				};

				out.pos = 0;
				out.p1(10);
				out.p4(seed[0]);
				out.p4(seed[1]);
				out.p4(seed[2]);
				out.p4(seed[3]);
				out.p8(0L);
				out.pjstr(TitleScreen.password);
				out.rsaenc(PublicKeys.LOGIN_RSAN, PublicKeys.LOGIN_RSAE);

				login.pos = 0;
				if (state == 40) {
					login.p1(18);
				} else {
					login.p1(16); // GAMELOGIN
				}
				login.p2(0);
				int start = login.pos;

				login.p4(1); // revision
				login.pdata(out.data, 0, out.pos);

				int xteaStart = login.pos;
				login.pjstr(TitleScreen.username);
				login.p1(lowMemory ? 1 : 0);
				GameShellCache.pushUID192(login); // 24 bytes
				login.p4(anims.crc);
				login.p4(bases.crc);
				login.p4(config.crc);
				login.p4(interfaces.crc);
				login.p4(jagFX.crc);
				login.p4(maps.crc);
				login.p4(songs.crc);
				login.p4(models.crc);
				login.p4(sprites.crc);
				login.p4(textures.crc);
				login.p4(binary.crc);
				login.p4(jingles.crc);
				login.p4(scripts.crc);
				login.p4(fontMetrics.crc);
				login.p4(vorbis.crc);
				login.p4(patches.crc);
				login.tinyenc(seed, xteaStart, login.pos);

				login.psize2(login.pos - start);
				loginStream.write(login.data, 0, login.pos);

				out.seed(seed);
				for (int i = 0; i < 4; i++) {
					seed[i] += 50;
				}
				in.seed(seed);

				loginStep = 6;
			}

			if (loginStep == 6 && loginStream.available() > 0) {
				int var5 = loginStream.read();
				if (var5 == 21 && state == 20) {
					loginStep = 7;
				} else if (var5 == 2) {
					loginStep = 9;
				} else if (var5 == 15 && state == 40) {
					imethod10();
					return;
				} else if (var5 == 23 && loginFailCount < 1) {
					loginFailCount++;
					loginStep = 0;
				} else {
					loginError(var5);
					return;
				}
			}

			if (loginStep == 7 && loginStream.available() > 0) {
				loginHopTimer = (loginStream.read() + 3) * 60;
				loginStep = 8;
			}

			if (loginStep == 8) {
				loginWaitingTime = 0;
				TitleScreen.loginMes(Text.LOGINHOP_A, Text.LOGINHOP_B, loginHopTimer / 60 + Text.LOGINHOP_C);
				if (--loginHopTimer <= 0) {
					loginStep = 0;
				}
			} else {
				if (loginStep == 9 && loginStream.available() >= 8) {
					staffmodlevel = loginStream.read();
					playermod = loginStream.read() == 1;
					selfSlot = loginStream.read();
					selfSlot <<= 0x8;
					selfSlot += loginStream.read();
					membersAccount = loginStream.read();

					loginStream.read(in.data, 0, 1);
					in.pos = 0;
					ptype = in.g1Enc();

					loginStream.read(in.data, 0, 2);
					in.pos = 0;
					psize = in.g2();
					loginStep = 10;
				}

				if (loginStep != 10) {
					loginWaitingTime++;
					if (loginWaitingTime > 2000) {
						if (loginFailCount < 1) {
							if (loginGamePort == loginPort) {
								loginPort = loginJs5Port;
							} else {
								loginPort = loginGamePort;
							}
							loginFailCount++;
							loginStep = 0;
						} else {
							loginError(-3);
						}
					}
				} else if (loginStream.available() >= psize) {
					in.pos = 0;
					loginStream.read(in.data, 0, psize);
					loginDone();
					mapBuildCenterZoneX = -1;
					rebuildPacket(false);
					ptype = -1;
				}
			}
		} catch (IOException var10) {
			if (loginFailCount < 1) {
				if (loginGamePort == loginPort) {
					loginPort = loginJs5Port;
				} else {
					loginPort = loginGamePort;
				}

				loginFailCount++;
				loginStep = 0;
			} else {
				loginError(-2);
			}
		}
	}

	// jag::oldscape::Client::LoginDone
	@ObfuscatedName("dr.df(S)V")
	public static void loginDone() {
		prevMouseClickTime = 0L;
		mouseTrackedDelta = 0;
		mouseTracking.length = 0;

		GameShell.focus = true;
		focusIn = true;

		ReflectionChecker.checks = new LinkList();

		out.pos = 0;
		in.pos = 0;
		ptype = -1;
		ptype0 = -1;
		ptype1 = -1;
		ptype2 = -1;

		timeoutTimer = 0;
		rebootTimer = 0;
		logoutTimer = 0;

		hintType = 0;

		menuNumEntries = 0;
		isMenuOpen = false;

		JavaMouseProvider.setIdleCycles(0);

		for (int var0 = 0; var0 < 100; var0++) {
			messageText[var0] = null;
		}
		chatHistoryLength = 0;

		useMode = 0;
		targetMode = false;

		waveCount = 0;

		macroCameraX = (int) (Math.random() * 100.0D) - 50;
		macroCameraZ = (int) (Math.random() * 110.0D) - 55;
		macroCameraAngle = (int) (Math.random() * 80.0D) - 40;
		macroMinimapAngle = (int) (Math.random() * 120.0D) - 60;
		macroMinimapZoom = (int) (Math.random() * 30.0D) - 20;
		orbitCameraYaw = (int) (Math.random() * 20.0D) - 10 & 0x7FF;

		minimapState = 0;
		minimapLevel = -1;
		minimapFlagX = 0;
		minimapFlagZ = 0;

		playerCount = 0;
		npcCount = 0;

		for (int var1 = 0; var1 < 2048; var1++) {
			players[var1] = null;
			playerAppearanceBuffer[var1] = null;
		}

		for (int var2 = 0; var2 < 32768; var2++) {
			npcs[var2] = null;
		}

		localPlayer = players[2047] = new ClientPlayer();

		projectiles.clear();
		spotanims.clear();
		for (int var3 = 0; var3 < 4; var3++) {
			for (int var4 = 0; var4 < 104; var4++) {
				for (int var5 = 0; var5 < 104; var5++) {
					objStacks[var3][var4][var5] = null;
				}
			}
		}
		locChanges = new LinkList();

		friendListStatus = 0;
		friendCount = 0;

		for (int var6 = 0; var6 < VarpType.numDefinitions; var6++) {
			VarpType var7 = VarpType.list(var6);
			if (var7 != null && var7.clientcode == 0) {
				VarCache.varServ[var6] = 0;
				VarCache.var[var6] = 0;
			}
		}

		for (int var8 = 0; var8 < field2120.length; var8++) {
			field2120[var8] = -1;
		}

		if (toplevelinterface != -1) {
			int var9 = toplevelinterface;
			if (var9 != -1 && IfType.open[var9]) {
				IfType.interfaces.discardFiles(var9);
				if (IfType.list[var9] != null) {
					boolean var10 = true;
					for (int var11 = 0; var11 < IfType.list[var9].length; var11++) {
						if (IfType.list[var9][var11] != null) {
							if (IfType.list[var9][var11].type == 2) {
								var10 = false;
							} else {
								IfType.list[var9][var11] = null;
							}
						}
					}
					if (var10) {
						IfType.list[var9] = null;
					}
					IfType.open[var9] = false;
				}
			}
		}

		for (SubInterface var12 = (SubInterface) subinterfaces.first(); var12 != null; var12 = (SubInterface) subinterfaces.next()) {
			closeSubInterface(var12, true);
		}

		toplevelinterface = -1;
		subinterfaces = new HashTable(8);
		resumedPauseButton = null;

		isMenuOpen = false;
		menuNumEntries = 0;

		selfModel.setAppearance(null, new int[] { 0, 0, 0, 0, 0 }, false, -1);

		for (int var13 = 0; var13 < 8; var13++) {
			playerOp[var13] = null;
			playerOpPriority[var13] = false;
		}

		ClientInvCache.field1623 = new HashTable(32);
		field1921 = true;

		for (int var14 = 0; var14 < 100; var14++) {
			componentRedrawRequested1[var14] = true;
		}

		chatDisplayName = null;
		field1220 = 0;
		field1774 = null;
	}

	// jag::oldscape::Client::LoginError
	@ObfuscatedName("bf.dk(II)V")
	public static void loginError(int response) {
		if (response == -3) {
			TitleScreen.loginMes(Text.LOGINM3_A, Text.LOGINM3_B, Text.LOGINM3_C);
		} else if (response == -2) {
			TitleScreen.loginMes(Text.LOGINM2_A, Text.LOGINM2_B, Text.LOGINM2_C);
		} else if (response == -1) {
			TitleScreen.loginMes(Text.LOGINM1_A, Text.LOGINM1_B, Text.LOGINM1_C);
		} else if (response == 3) {
			TitleScreen.loginMes(Text.LOGIN3_A, Text.LOGIN3_B, Text.LOGIN3_C);
		} else if (response == 4) {
			TitleScreen.loginMes(Text.LOGIN4_A, Text.LOGIN4_B, Text.LOGIN4_C);
		} else if (response == 5) {
			TitleScreen.loginMes(Text.LOGIN5_A, Text.LOGIN5_B, Text.LOGIN5_C);
		} else if (response == 6) {
			TitleScreen.loginMes(Text.LOGIN6_A, Text.LOGIN6_B, Text.LOGIN6_C);
		} else if (response == 7) {
			TitleScreen.loginMes(Text.LOGIN7_A, Text.LOGIN7_B, Text.LOGIN7_C);
		} else if (response == 8) {
			TitleScreen.loginMes(Text.LOGIN8_A, Text.LOGIN8_B, Text.LOGIN8_C);
		} else if (response == 9) {
			TitleScreen.loginMes(Text.LOGIN9_A, Text.LOGIN9_B, Text.LOGIN9_C);
		} else if (response == 10) {
			TitleScreen.loginMes(Text.LOGIN10_A, Text.LOGIN10_B, Text.LOGIN10_C);
		} else if (response == 11) {
			TitleScreen.loginMes(Text.LOGIN11_A, Text.LOGIN11_B, Text.LOGIN11_C);
		} else if (response == 12) {
			TitleScreen.loginMes(Text.LOGIN12_A, Text.LOGIN12_B, Text.LOGIN12_C);
		} else if (response == 13) {
			TitleScreen.loginMes(Text.LOGIN13_A, Text.LOGIN13_B, Text.LOGIN13_C);
		} else if (response == 14) {
			TitleScreen.loginMes(Text.LOGIN14_A, Text.LOGIN14_B, Text.LOGIN14_C);
		} else if (response == 16) {
			TitleScreen.loginMes(Text.LOGIN16_A, Text.LOGIN16_B, Text.LOGIN16_C);
		} else if (response == 17) {
			TitleScreen.loginMes(Text.LOGIN17_A, Text.LOGIN17_B, Text.LOGIN17_C);
		} else if (response == 18) {
			TitleScreen.loginMes(Text.LOGIN18_A, Text.LOGIN18_B, Text.LOGIN18_C);
		} else if (response == 19) {
			TitleScreen.loginMes(Text.LOGIN19_A, Text.LOGIN19_B, Text.LOGIN19_C);
		} else if (response == 20) {
			TitleScreen.loginMes(Text.LOGIN20_A, Text.LOGIN20_B, Text.LOGIN20_C);
		} else if (response == 22) {
			TitleScreen.loginMes(Text.LOGIN22_A, Text.LOGIN22_B, Text.LOGIN22_C);
		} else if (response == 23) {
			TitleScreen.loginMes(Text.LOGIN23_A, Text.LOGIN23_B, Text.LOGIN23_C);
		} else if (response == 24) {
			TitleScreen.loginMes(Text.LOGIN24_A, Text.LOGIN24_B, Text.LOGIN24_C);
		} else if (response == 25) {
			TitleScreen.loginMes(Text.LOGIN25_A, Text.LOGIN25_B, Text.LOGIN25_C);
		} else if (response == 26) {
			TitleScreen.loginMes(Text.LOGIN26_A, Text.LOGIN26_B, Text.LOGIN26_C);
		} else if (response == 27) {
			TitleScreen.loginMes(Text.LOGIN27_A, Text.LOGIN27_B, Text.LOGIN27_C);
		} else if (response == 31) {
			TitleScreen.loginMes(Text.LOGIN31_A, Text.LOGIN31_B, Text.LOGIN31_C);
		} else if (response == 32) {
			TitleScreen.loginMes(Text.LOGIN32_A, Text.LOGIN32_B, Text.LOGIN32_C);
		} else if (response == 37) {
			TitleScreen.loginMes(Text.LOGIN37_A, Text.LOGIN37_B, Text.LOGIN37_C);
		} else if (response == 38) {
			TitleScreen.loginMes(Text.LOGIN38_A, Text.LOGIN38_B, Text.LOGIN38_C);
		} else if (response == 55) {
			TitleScreen.loginMes(Text.LOGIN55_A, Text.LOGIN55_B, Text.LOGIN55_C);
		} else {
			TitleScreen.loginMes(Text.LOGINMIS_A, Text.LOGINMIS_B, Text.LOGINMIS_C);
		}
		setMainState(10);
	}

	// jag::oldscape::Client::Logout
	@ObfuscatedName("dq.dz(B)V")
	public static void logout() {
		if (loginStream != null) {
			loginStream.close();
			loginStream = null;
		}

		clearCaches();
		world.resetMap();

		for (int i = 0; i < 4; i++) {
			levelCollisionMap[i].reset();
		}

		System.gc();
		MidiManager.stop2();
		previousSong = -1;
		field2189 = false;
		BgSound.reset();
		setMainState(10);
	}

	@ObfuscatedName("bh.da(B)V")
	public static void clearCaches() {
		FloType.resetCache();
		FluType.resetCache();
		IdkType.resetCache();
		LocType.resetCache();
		NpcType.resetCache();
		ObjType.resetCache();
		SeqType.resetCache();
		SpotType.resetCache();
		VarpType.resetCache();
		PlayerModel.resetCache();
		IfType.resetCache();
		((WorldTextureProvider) Pix3D.textureProvider).method749();
		ClientScript.cache.clear();

		anims.discardAllFiles();
		bases.discardAllFiles();
		interfaces.discardAllFiles();
		jagFX.discardAllFiles();
		maps.discardAllFiles();
		songs.discardAllFiles();
		models.discardAllFiles();
		sprites.discardAllFiles();
		textures.discardAllFiles();
		binary.discardAllFiles();
		jingles.discardAllFiles();
		scripts.discardAllFiles();
	}

	@ObfuscatedName("da.dj(I)V")
	public static void flushAudio() {
		if (soundPcmPlayer != null) {
			soundPcmPlayer.cycle();
		}
		if (midiPcmPlayer != null) {
			midiPcmPlayer.cycle();
		}
	}

	// jag::oldscape::Client::TriggerSeqSound
	@ObfuscatedName("de.dv(Leo;IIII)V")
	public static void triggerSeqSound(SeqType arg0, int arg1, int arg2, int arg3) {
		if (waveCount >= 50 || ambientVolume == 0 || (arg0.sound == null || arg1 >= arg0.sound.length)) {
			return;
		}

		int var4 = arg0.sound[arg1];
		if (var4 == 0) {
			return;
		}

		int var5 = var4 >> 8;
		int var6 = var4 >> 4 & 0x7;
		int var7 = var4 & 0xF;

		waveSoundIds[waveCount] = var5;
		waveLoops[waveCount] = var6;
		waveDelay[waveCount] = 0;
		waveSounds[waveCount] = null;

		int var8 = (arg2 - 64) / 128;
		int var9 = (arg3 - 64) / 128;
		waveAmbient[waveCount] = (var8 << 16) + (var9 << 8) + var7;

		waveCount++;
	}

	// jag::oldscape::Client::PlaySongs
	@ObfuscatedName("ck.ds(IB)V")
	public static void playSongs(int id) {
		if (id == -1 && !field2189) {
			MidiManager.stop();
		} else if (id != -1 && previousSong != id && midiVolume != 0 && !field2189) {
			MidiManager.play(2, songs, id, 0, midiVolume, false);
		}

		previousSong = id;
	}

	// jag::oldscape::minimap::Minimap::GlMinimap
	@ObfuscatedName("p.dh(III)V")
	public static void minimapLoop(int offsetX, int offsetY) {
		if (minimapState != 0 && minimapState != 3) {
			return;
		}

		if (JavaMouseProvider.mouseClickButton == 1) {
			int x = JavaMouseProvider.mouseClickX - 25 - offsetX;
			int y = JavaMouseProvider.mouseClickY - 5 - offsetY;

			if (x < 0 || y < 0 || x >= 146 || y >= 151) {
				return;
			}

			// make x and y relative to center of minimap
			x -= 73;
			y -= 75;

			int yaw = orbitCameraYaw + macroMinimapAngle & 0x7FF;

			int sinYaw = Pix3D.sinTable[yaw];
			int cosYaw = Pix3D.cosTable[yaw];

			int zoomX = (macroMinimapZoom + 256) * sinYaw >> 8;
			int zoomY = (macroMinimapZoom + 256) * cosYaw >> 8;

			int relX = x * zoomY + y * zoomX >> 11;
			int relY = y * zoomY - x * zoomX >> 11;

			int tileX = localPlayer.x + relX >> 7;
			int tileZ = localPlayer.z - relY >> 7;

			boolean moved = tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], tileX, tileZ, true, 0, 0, 0, 0, 0, 1);
			if (moved) {
				// identical all the way back to 2004 - same constants and all!
				out.p1(x);
				out.p1(y);
				out.p2(orbitCameraYaw);
				out.p1(57);
				out.p1(macroMinimapAngle);
				out.p1(macroMinimapZoom);
				out.p1(89);
				out.p2(localPlayer.x);
				out.p2(localPlayer.z);
				out.p1(tryMoveNearest);
				out.p1(63);
			}
		}
	}

	// jag::oldscape::Client::GlTimeoutChat
	@ObfuscatedName("dm.dc(B)V")
	public static void timeoutChat() {
		for (int var0 = -1; var0 < playerCount; var0++) {
			int var1;
			if (var0 == -1) {
				var1 = 2047;
			} else {
				var1 = playerIds[var0];
			}
			ClientPlayer var2 = players[var1];
			if (var2 != null && var2.chatTimer > 0) {
				var2.chatTimer--;
				if (var2.chatTimer == 0) {
					var2.chat = null;
				}
			}
		}
		for (int var3 = 0; var3 < npcCount; var3++) {
			int var4 = npcIds[var3];
			ClientNpc var5 = npcs[var4];
			if (var5 != null && var5.chatTimer > 0) {
				var5.chatTimer--;
				if (var5.chatTimer == 0) {
					var5.chat = null;
				}
			}
		}
	}

	// jag::oldscape::Client::DoCheat
	@ObfuscatedName("eh.dp(Ljava/lang/String;S)V")
	public static void doCheat(String message) {
		if (staffmodlevel >= 2) {
			if (message.equalsIgnoreCase("::gc")) {
				System.gc();
			} else if (message.equalsIgnoreCase("::clientdrop")) {
				lostCon();
			} else if (message.equalsIgnoreCase("::fpson")) {
				showFps = true;
			} else if (message.equalsIgnoreCase("::fpsoff")) {
				showFps = false;
			} else if (message.equalsIgnoreCase("::noclip")) {
				for (int level = 0; level < 4; level++) {
					for (int x = 1; x < 103; x++) {
						for (int z = 1; z < 103; z++) {
							levelCollisionMap[level].flags[x][z] = 0;
						}
					}
				}
			} else if (message.equalsIgnoreCase("::errortest") && modewhere == 2) {
				throw new RuntimeException();
			}
		}

		// CLIENT_CHEAT
		out.p1Enc(30);
		out.p1(message.length() - 1);
		out.pjstr(message.substring(2));
	}

	// jag::oldscape::Client::GlCinemaCamera
	@ObfuscatedName("ez.dm(B)V")
	public static void cinemaCamera() {
		int var0 = cutsceneSrcLocalTileX * 128 + 64;
		int var1 = cutsceneSrcLocalTileZ * 128 + 64;
		int var2 = getAvH(var0, var1, minusedlevel) - cutsceneSrcHeight;
		if (camX < var0) {
			camX += cutsceneMoveAcceleration * (var0 - camX) / 1000 + cutsceneMoveSpeed;
			if (camX > var0) {
				camX = var0;
			}
		}
		if (camX > var0) {
			camX -= cutsceneMoveAcceleration * (camX - var0) / 1000 + cutsceneMoveSpeed;
			if (camX < var0) {
				camX = var0;
			}
		}
		if (camY < var2) {
			camY += cutsceneMoveAcceleration * (var2 - camY) / 1000 + cutsceneMoveSpeed;
			if (camY > var2) {
				camY = var2;
			}
		}
		if (camY > var2) {
			camY -= cutsceneMoveAcceleration * (camY - var2) / 1000 + cutsceneMoveSpeed;
			if (camY < var2) {
				camY = var2;
			}
		}
		if (camZ < var1) {
			camZ += cutsceneMoveAcceleration * (var1 - camZ) / 1000 + cutsceneMoveSpeed;
			if (camZ > var1) {
				camZ = var1;
			}
		}
		if (camZ > var1) {
			camZ -= cutsceneMoveAcceleration * (camZ - var1) / 1000 + cutsceneMoveSpeed;
			if (camZ < var1) {
				camZ = var1;
			}
		}
		int var3 = cutsceneDstLocalTileX * 128 + 64;
		int var4 = cutsceneDstLocalTileZ * 128 + 64;
		int var5 = getAvH(var3, var4, minusedlevel) - cutsceneDstHeight;
		int var6 = var3 - camX;
		int var7 = var5 - camY;
		int var8 = var4 - camZ;
		int var9 = (int) Math.sqrt((double) (var6 * var6 + var8 * var8));
		int var10 = (int) (Math.atan2((double) var7, (double) var9) * 325.949D) & 0x7FF;
		int var11 = (int) (Math.atan2((double) var6, (double) var8) * -325.949D) & 0x7FF;
		if (var10 < 128) {
			var10 = 128;
		}
		if (var10 > 383) {
			var10 = 383;
		}
		if (camPitch < var10) {
			camPitch += cutsceneRotateAcceleration * (var10 - camPitch) / 1000 + cutsceneRotateSpeed;
			if (camPitch > var10) {
				camPitch = var10;
			}
		}
		if (camPitch > var10) {
			camPitch -= cutsceneRotateAcceleration * (camPitch - var10) / 1000 + cutsceneRotateSpeed;
			if (camPitch < var10) {
				camPitch = var10;
			}
		}
		int var12 = var11 - camYaw;
		if (var12 > 1024) {
			var12 -= 2048;
		}
		if (var12 < -1024) {
			var12 += 2048;
		}
		if (var12 > 0) {
			camYaw += cutsceneRotateAcceleration * var12 / 1000 + cutsceneRotateSpeed;
			camYaw &= 0x7FF;
		}
		if (var12 < 0) {
			camYaw -= cutsceneRotateAcceleration * -var12 / 1000 + cutsceneRotateSpeed;
			camYaw &= 0x7FF;
		}
		int var13 = var11 - camYaw;
		if (var13 > 1024) {
			var13 -= 2048;
		}
		if (var13 < -1024) {
			var13 += 2048;
		}
		if (var13 < 0 && var12 > 0 || var13 > 0 && var12 < 0) {
			camYaw = var11;
		}
	}

	// jag::oldscape::Client::GlMovePlayers
	@ObfuscatedName("eg.di(B)V")
	public static void movePlayers() {
		for (int var0 = -1; var0 < playerCount; var0++) {
			int var1;
			if (var0 == -1) {
				var1 = 2047;
			} else {
				var1 = playerIds[var0];
			}
			ClientPlayer var2 = players[var1];
			if (var2 != null) {
				moveEntity(var2, 1);
			}
		}
	}

	// jag::oldscape::Client::GlMoveNpcs
	@ObfuscatedName("l.db(I)V")
	public static void moveNpcs() {
		for (int var0 = 0; var0 < npcCount; var0++) {
			int var1 = npcIds[var0];
			ClientNpc var2 = npcs[var1];
			if (var2 != null) {
				moveEntity(var2, var2.type.size);
			}
		}
	}

	// jag::oldscape::Client::GlMoveEntity
	@ObfuscatedName("be.dq(Lfz;IB)V")
	public static void moveEntity(ClientEntity entity, int size) {
		if (entity.exactMoveEnd > loopCycle) {
			// todo: inlined method (exactMove1?)
			int var2 = entity.exactMoveEnd - loopCycle;
			int var3 = entity.size * 64 + entity.exactStartX * 128;
			int var4 = entity.size * 64 + entity.exactStartZ * 128;
			entity.x += (var3 - entity.x) / var2;
			entity.z += (var4 - entity.z) / var2;
			entity.animDelayMove = 0;
			if (entity.exactMoveFacing == 0) {
				entity.dstYaw = 1024;
			}
			if (entity.exactMoveFacing == 1) {
				entity.dstYaw = 1536;
			}
			if (entity.exactMoveFacing == 2) {
				entity.dstYaw = 0;
			}
			if (entity.exactMoveFacing == 3) {
				entity.dstYaw = 512;
			}
		} else if (entity.exactMoveStart >= loopCycle) {
			exactMove2(entity);
		} else {
			routeMove(entity);
		}

		if (entity.x < 128 || entity.z < 128 || entity.x >= 13184 || entity.z >= 13184) {
			entity.primarySeqId = -1;
			entity.spotanimId = -1;
			entity.exactMoveEnd = 0;
			entity.exactMoveStart = 0;
			entity.x = entity.routeX[0] * 128 + entity.size * 64;
			entity.z = entity.routeZ[0] * 128 + entity.size * 64;
			entity.abortRoute();
		}

		if (localPlayer == entity && (entity.x < 1536 || entity.z < 1536 || entity.x >= 11776 || entity.z >= 11776)) {
			entity.primarySeqId = -1;
			entity.spotanimId = -1;
			entity.exactMoveEnd = 0;
			entity.exactMoveStart = 0;
			entity.x = entity.routeX[0] * 128 + entity.size * 64;
			entity.z = entity.routeZ[0] * 128 + entity.size * 64;
			entity.abortRoute();
		}

		entityFace(entity);
		entityAnim(entity);
	}

	// jag::oldscape::Client::GlExactMove2
	@ObfuscatedName("ap.dr(Lfz;I)V")
	public static void exactMove2(ClientEntity entity) {
		if (loopCycle == entity.exactMoveStart || entity.primarySeqId == -1 || entity.primarySeqDelay != 0 || entity.primarySeqCycle + 1 > SeqType.list(entity.primarySeqId).delay[entity.primarySeqFrame]) {
			int var1 = entity.exactMoveStart - entity.exactMoveEnd;
			int var2 = loopCycle - entity.exactMoveEnd;
			int var3 = (entity.size * 64) + (entity.exactStartX * 128);
			int var4 = (entity.size * 64) + (entity.exactStartZ * 128);
			int var5 = (entity.size * 64) + (entity.exactEndX * 128);
			int var6 = (entity.size * 64) + (entity.exactEndZ * 128);
			entity.x = ((var1 - var2) * var3 + var2 * var5) / var1;
			entity.z = ((var1 - var2) * var4 + var2 * var6) / var1;
		}
		entity.animDelayMove = 0;
		if (entity.exactMoveFacing == 0) {
			entity.dstYaw = 1024;
		}
		if (entity.exactMoveFacing == 1) {
			entity.dstYaw = 1536;
		}
		if (entity.exactMoveFacing == 2) {
			entity.dstYaw = 0;
		}
		if (entity.exactMoveFacing == 3) {
			entity.dstYaw = 512;
		}
		entity.yaw = entity.dstYaw;
	}

	// jag::oldscape::Client::GlRouteMove
	@ObfuscatedName("eu.du(Lfz;B)V")
	public static void routeMove(ClientEntity entity) {
		entity.secondarySeqId = entity.readyanim;
		if (entity.routeLength == 0) {
			entity.animDelayMove = 0;
			return;
		}
		if (entity.primarySeqId != -1 && entity.primarySeqDelay == 0) {
			SeqType seq = SeqType.list(entity.primarySeqId);
			if (entity.preanimRouteLength > 0 && seq.preanim_move == 0) {
				entity.animDelayMove++;
				return;
			}
			if (entity.preanimRouteLength <= 0 && seq.postanim_move == 0) {
				entity.animDelayMove++;
				return;
			}
		}
		int var2 = entity.x;
		int var3 = entity.z;
		int var4 = (entity.routeX[entity.routeLength - 1] * 128) + (entity.size * 64);
		int var5 = (entity.routeZ[entity.routeLength - 1] * 128) + (entity.size * 64);
		if (var4 - var2 > 256 || var4 - var2 < -256 || var5 - var3 > 256 || var5 - var3 < -256) {
			entity.x = var4;
			entity.z = var5;
			return;
		}
		if (var2 < var4) {
			if (var3 < var5) {
				entity.dstYaw = 1280;
			} else if (var3 > var5) {
				entity.dstYaw = 1792;
			} else {
				entity.dstYaw = 1536;
			}
		} else if (var2 > var4) {
			if (var3 < var5) {
				entity.dstYaw = 768;
			} else if (var3 > var5) {
				entity.dstYaw = 256;
			} else {
				entity.dstYaw = 512;
			}
		} else if (var3 < var5) {
			entity.dstYaw = 1024;
		} else if (var3 > var5) {
			entity.dstYaw = 0;
		}
		int var6 = entity.dstYaw - entity.yaw & 0x7FF;
		if (var6 > 1024) {
			var6 -= 2048;
		}
		int var7 = entity.walkanim_b;
		if (var6 >= -256 && var6 <= 256) {
			var7 = entity.walkanim;
		} else if (var6 >= 256 && var6 < 768) {
			var7 = entity.walkanim_r;
		} else if (var6 >= -768 && var6 <= -256) {
			var7 = entity.walkanim_l;
		}
		if (var7 == -1) {
			var7 = entity.walkanim;
		}
		entity.secondarySeqId = var7;
		int var8 = 4;
		boolean var9 = true;
		if (entity instanceof ClientNpc) {
			var9 = ((ClientNpc) entity).type.walksmoothing;
		}
		if (var9) {
			if (entity.yaw != entity.dstYaw && entity.targetId == -1 && entity.turnSpeed != 0) {
				var8 = 2;
			}
			if (entity.routeLength > 2) {
				var8 = 6;
			}
			if (entity.routeLength > 3) {
				var8 = 8;
			}
			if (entity.animDelayMove > 0 && entity.routeLength > 1) {
				var8 = 8;
				entity.animDelayMove--;
			}
		} else {
			if (entity.routeLength > 1) {
				var8 = 6;
			}
			if (entity.routeLength > 2) {
				var8 = 8;
			}
			if (entity.animDelayMove > 0 && entity.routeLength > 1) {
				var8 = 8;
				entity.animDelayMove--;
			}
		}
		if (entity.routeRun[entity.routeLength - 1]) {
			var8 <<= 0x1;
		}
		if (var8 >= 8 && entity.secondarySeqId == entity.walkanim && entity.runanim != -1) {
			entity.secondarySeqId = entity.runanim;
		}
		if (var2 < var4) {
			entity.x += var8;
			if (entity.x > var4) {
				entity.x = var4;
			}
		} else if (var2 > var4) {
			entity.x -= var8;
			if (entity.x < var4) {
				entity.x = var4;
			}
		}
		if (var3 < var5) {
			entity.z += var8;
			if (entity.z > var5) {
				entity.z = var5;
			}
		} else if (var3 > var5) {
			entity.z -= var8;
			if (entity.z < var5) {
				entity.z = var5;
			}
		}
		if (entity.x == var4 && entity.z == var5) {
			entity.routeLength--;
			if (entity.preanimRouteLength > 0) {
				entity.preanimRouteLength--;
			}
		}
	}

	// jag::oldscape::Client::GlEntityFace
	@ObfuscatedName("dk.dy(Lfz;I)V")
	public static void entityFace(ClientEntity entity) {
		if (entity.turnSpeed == 0) {
			return;
		}
		if (entity.targetId != -1 && entity.targetId < 32768) {
			ClientNpc var1 = npcs[entity.targetId];
			if (var1 != null) {
				int var2 = entity.x - var1.x;
				int var3 = entity.z - var1.z;
				if (var2 != 0 || var3 != 0) {
					entity.dstYaw = (int) (Math.atan2(var2, var3) * 325.949D) & 0x7FF;
				}
			}
		}
		if (entity.targetId >= 32768) {
			int var4 = entity.targetId - 32768;
			if (selfSlot == var4) {
				var4 = 2047; // todo: LOCAL_PLAYER_INDEX constant
			}
			ClientPlayer var5 = players[var4];
			if (var5 != null) {
				int var6 = entity.x - var5.x;
				int var7 = entity.z - var5.z;
				if (var6 != 0 || var7 != 0) {
					entity.dstYaw = (int) (Math.atan2(var6, var7) * 325.949D) & 0x7FF;
				}
			}
		}
		if ((entity.targetTileX != 0 || entity.targetTileZ != 0) && (entity.routeLength == 0 || entity.animDelayMove > 0)) {
			int var8 = entity.x - ((entity.targetTileX * 64) - (mapBuildBaseX * 64) - (mapBuildBaseX * 64));
			int var9 = entity.z - ((entity.targetTileZ * 64) - (mapBuildBaseZ * 64) - (mapBuildBaseZ * 64));
			if (var8 != 0 || var9 != 0) {
				entity.dstYaw = (int) (Math.atan2(var8, var9) * 325.949D) & 0x7FF;
			}
			entity.targetTileX = 0;
			entity.targetTileZ = 0;
		}
		int var10 = entity.dstYaw - entity.yaw & 0x7FF;
		if (var10 == 0) {
			entity.field2663 = 0;
			return;
		}
		entity.field2663++;
		if (var10 > 1024) {
			entity.yaw -= entity.turnSpeed;
			boolean var11 = true;
			if (var10 < entity.turnSpeed || var10 > 2048 - entity.turnSpeed) {
				entity.yaw = entity.dstYaw;
				var11 = false;
			}
			if (entity.secondarySeqId == entity.readyanim && (entity.field2663 > 25 || var11)) {
				if (entity.turnleftanim == -1) {
					entity.secondarySeqId = entity.walkanim;
				} else {
					entity.secondarySeqId = entity.turnleftanim;
				}
			}
		} else {
			entity.yaw += entity.turnSpeed;
			boolean var12 = true;
			if (var10 < entity.turnSpeed || var10 > 2048 - entity.turnSpeed) {
				entity.yaw = entity.dstYaw;
				var12 = false;
			}
			if (entity.secondarySeqId == entity.readyanim && (entity.field2663 > 25 || var12)) {
				if (entity.turnrightanim == -1) {
					entity.secondarySeqId = entity.walkanim;
				} else {
					entity.secondarySeqId = entity.turnrightanim;
				}
			}
		}
		entity.yaw &= 0x7FF;
	}

	// jag::oldscape::Client::GlEntityAnim
	@ObfuscatedName("p.de(Lfz;I)V")
	public static void entityAnim(ClientEntity entity) {
		entity.needsForwardDrawPadding = false;

		if (entity.secondarySeqId != -1) {
			SeqType var1 = SeqType.list(entity.secondarySeqId);
			if (var1 == null || var1.frames == null) {
				entity.secondarySeqId = -1;
			} else {
				entity.field2662++;

				if (entity.field2641 < var1.frames.length && entity.field2662 > var1.delay[entity.field2641]) {
					entity.field2662 = 1;
					entity.field2641++;
					triggerSeqSound(var1, entity.field2641, entity.x, entity.z);
				}

				if (entity.field2641 >= var1.frames.length) {
					entity.field2662 = 0;
					entity.field2641 = 0;
					triggerSeqSound(var1, entity.field2641, entity.x, entity.z);
				}
			}
		}

		if (entity.spotanimId != -1 && loopCycle >= entity.spotanimLastCycle) {
			if (entity.spotanimFrame < 0) {
				entity.spotanimFrame = 0;
			}

			int spotAnim = SpotType.list(entity.spotanimId).anim;
			if (spotAnim == -1) {
				entity.spotanimId = -1;
			} else {
				SeqType spotSeq = SeqType.list(spotAnim);
				if (spotSeq == null || spotSeq.frames == null) {
					entity.spotanimId = -1;
				} else {
					entity.spotanimCycle++;

					if (entity.spotanimFrame < spotSeq.frames.length && entity.spotanimCycle > spotSeq.delay[entity.spotanimFrame]) {
						entity.spotanimCycle = 1;
						entity.spotanimFrame++;
						triggerSeqSound(spotSeq, entity.spotanimFrame, entity.x, entity.z);
					}

					if (entity.spotanimFrame >= spotSeq.frames.length && (entity.spotanimFrame < 0 || entity.spotanimFrame >= spotSeq.frames.length)) {
						entity.spotanimId = -1;
					}
				}
			}
		}

		if (entity.primarySeqId != -1 && entity.primarySeqDelay <= 1) {
			SeqType seq = SeqType.list(entity.primarySeqId);
			if (seq.preanim_move == 1 && entity.preanimRouteLength > 0 && entity.exactMoveEnd <= loopCycle && entity.exactMoveStart < loopCycle) {
				entity.primarySeqDelay = 1;
				return;
			}
		}

		if (entity.primarySeqId != -1 && entity.primarySeqDelay == 0) {
			SeqType seq = SeqType.list(entity.primarySeqId);
			if (seq == null || seq.frames == null) {
				entity.primarySeqId = -1;
			} else {
				entity.primarySeqCycle++;

				if (entity.primarySeqFrame < seq.frames.length && entity.primarySeqCycle > seq.delay[entity.primarySeqFrame]) {
					entity.primarySeqCycle = 1;
					entity.primarySeqFrame++;
					triggerSeqSound(seq, entity.primarySeqFrame, entity.x, entity.z);
				}

				if (entity.primarySeqFrame >= seq.frames.length) {
					entity.primarySeqFrame -= seq.loops;
					entity.field2647++;

					if (entity.field2647 >= seq.maxloops) {
						entity.primarySeqId = -1;
					} else if (entity.primarySeqFrame >= 0 && entity.primarySeqFrame < seq.frames.length) {
						triggerSeqSound(seq, entity.primarySeqFrame, entity.x, entity.z);
					} else {
						entity.primarySeqId = -1;
					}
				}

				entity.needsForwardDrawPadding = seq.stretches;
			}
		}

		if (entity.primarySeqDelay > 0) {
			entity.primarySeqDelay--;
		}
	}

	// jag::oldscape::Client::TriggerPlayerAnim
	@ObfuscatedName("co.dw(Lfi;III)V")
	public static void triggerPlayerAnim(ClientPlayer arg0, int arg1, int arg2) {
		if (arg0.primarySeqId == arg1 && arg1 != -1) {
			int var3 = SeqType.list(arg1).duplicatebehavior;
			if (var3 == 1) {
				arg0.primarySeqFrame = 0;
				arg0.primarySeqCycle = 0;
				arg0.primarySeqDelay = arg2;
				arg0.field2647 = 0;
			}
			if (var3 == 2) {
				arg0.field2647 = 0;
			}
		} else if (arg1 == -1 || arg0.primarySeqId == -1 || SeqType.list(arg1).priority >= SeqType.list(arg0.primarySeqId).priority) {
			arg0.primarySeqId = arg1;
			arg0.primarySeqFrame = 0;
			arg0.primarySeqCycle = 0;
			arg0.primarySeqDelay = arg2;
			arg0.field2647 = 0;
			arg0.preanimRouteLength = arg0.routeLength;
		}
	}

	// jag::oldscape::Client::MessageBox
	@ObfuscatedName("ej.dl(Ljava/lang/String;ZI)V")
	public static void messageBox(String arg0, boolean arg1) {
		byte var2 = 4;
		int var3 = var2 + 6;
		int var4 = var2 + 6;
		int var5 = fontPlain12.method2818(arg0, 250);
		int var6 = fontPlain12.method2889(arg0, 250) * 13;

		Pix2D.fillRect(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
		Pix2D.drawRect(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0xffffff);
		fontPlain12.drawStringMultiline(arg0, var3, var4, var5, var6, 0xffffff, -1, 1, 1, 0);
		dirtyArea(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);

		if (arg1) {
			try {
				Graphics var7 = GameShell.canvas.getGraphics();
				GameShell.drawArea.draw(var7, 0, 0);
			} catch (Exception var14) {
				GameShell.canvas.repaint();
			}
			return;
		}

		// todo: inlined method (BlitArea?)
		int var9 = var3;
		int var10 = var4;
		int var11 = var5;
		int var12 = var6;
		for (int var13 = 0; var13 < componentDrawCount; var13++) {
			if (componentDrawWidth[var13] + componentDrawX[var13] > var9 && componentDrawX[var13] < var9 + var11 && componentDrawHeight[var13] + componentDrawY[var13] > var10 && componentDrawY[var13] < var10 + var12) {
				componentRedrawRequested2[var13] = true;
			}
		}
	}

	// jag::oldscape::Client::GdmAddPlayerToWorld
	@ObfuscatedName("dl.dn(ZI)V")
	public static void addPlayers(boolean local) {
		if (localPlayer.x >> 7 == minimapFlagX && localPlayer.z >> 7 == minimapFlagZ) {
			minimapFlagX = 0;
		}
		int count = playerCount;
		if (local) {
			count = 1;
		}
		for (int i = 0; i < count; i++) {
			ClientPlayer player;
			int var4;
			if (local) {
				player = localPlayer;
				var4 = 0x1ffc000; // todo: LOCAL_PLAYER_INDEX (2047) << 14
			} else {
				player = players[playerIds[i]];
				var4 = playerIds[i] << 14;
			}
			if (player == null || !player.ready()) {
				continue;
			}
			player.lowMemory = false;
			if ((lowMemory && playerCount > 50 || playerCount > 200) && !local && player.secondarySeqId == player.readyanim) {
				player.lowMemory = true;
			}
			int x = player.x >> 7;
			int z = player.z >> 7;
			if (x < 0 || x >= 104 || z < 0 || z >= 104) {
				continue;
			}
			if (player.locModel == null || loopCycle < player.locStartCycle || loopCycle >= player.locEndCycle) {
				if ((player.x & 0x7F) == 64 && (player.z & 0x7F) == 64) {
					if (sceneCycle == tileLastOccupiedCycle[x][z]) {
						continue;
					}
					tileLastOccupiedCycle[x][z] = sceneCycle;
				}
				player.y = getAvH(player.x, player.z, minusedlevel);
				world.addDynamic(minusedlevel, player.x, player.z, player.y, 60, player, player.yaw, var4, player.needsForwardDrawPadding);
			} else {
				player.lowMemory = false;
				player.y = getAvH(player.x, player.z, minusedlevel);
				world.addDynamic(minusedlevel, player.x, player.z, player.y, 60, player, player.yaw, var4, player.minTileX, player.minTileZ, player.maxTileX, player.maxTileZ);
			}
		}
	}

	// jag::oldscape::Client::GdmAddNPCs
	@ObfuscatedName("dw.do(ZB)V")
	public static void addNpcs(boolean arg0) {
		for (int var1 = 0; var1 < npcCount; var1++) {
			ClientNpc var2 = npcs[npcIds[var1]];
			int var3 = (npcIds[var1] << 14) + 0x20000000;
			if (var2 == null || !var2.ready() || var2.type.alwaysontop != arg0 || !var2.type.isMultiNpcVisible()) {
				continue;
			}
			int var4 = var2.x >> 7;
			int var5 = var2.z >> 7;
			if (var4 < 0 || var4 >= 104 || var5 < 0 || var5 >= 104) {
				continue;
			}
			if (var2.size == 1 && (var2.x & 0x7F) == 64 && (var2.z & 0x7F) == 64) {
				if (sceneCycle == tileLastOccupiedCycle[var4][var5]) {
					continue;
				}
				tileLastOccupiedCycle[var4][var5] = sceneCycle;
			}
			if (!var2.type.active) {
				var3 -= Integer.MIN_VALUE;
			}
			world.addDynamic(minusedlevel, var2.x, var2.z, getAvH(var2.x + (var2.size * 64 - 64), var2.z + (var2.size * 64 - 64), minusedlevel), var2.size * 64 - 64 + 60, var2, var2.yaw, var3, var2.needsForwardDrawPadding);
		}
	}

	// jag::oldscape::Client::GdmAddProjectiles
	@ObfuscatedName("r.dx(I)V")
	public static void addProjectiles() {
		for (ClientProj proj = (ClientProj) projectiles.head(); proj != null; proj = (ClientProj) projectiles.next()) {
			if (minusedlevel != proj.level || loopCycle > proj.t2) {
				proj.unlink();
				continue;
			}

			if (loopCycle >= proj.t1) {
				if (proj.target > 0) {
					ClientNpc npc = npcs[proj.target - 1];

					if (npc != null && npc.x >= 0 && npc.x < 13312 && npc.z >= 0 && npc.z < 13312) {
						proj.setTarget(npc.x, npc.z, getAvH(npc.x, npc.z, proj.level) - proj.h2, loopCycle);
					}
				} else if (proj.target < 0) {
					int pid = -proj.target - 1;

					ClientPlayer player;
					if (selfSlot == pid) {
						player = localPlayer;
					} else {
						player = players[pid];
					}

					if (player != null && player.x >= 0 && player.x < 13312 && player.z >= 0 && player.z < 13312) {
						proj.setTarget(player.x, player.z, getAvH(player.x, player.z, proj.level) - proj.h2, loopCycle);
					}
				}

				proj.move(worldUpdateNum);
				world.addDynamic(minusedlevel, (int) proj.x, (int) proj.z, (int) proj.y, 60, proj, proj.yaw, -1, false);
			}
		}
	}

	// jag::oldscape::Client::GdmAddMapAnim
	@ObfuscatedName("bf.dt(I)V")
	public static void addMapAnim() {
		for (MapSpotAnim var0 = (MapSpotAnim) spotanims.head(); var0 != null; var0 = (MapSpotAnim) spotanims.next()) {
			if (minusedlevel != var0.level || var0.animComplete) {
				var0.unlink();
			} else if (loopCycle >= var0.startCycle) {
				var0.doAnim(worldUpdateNum);

				if (var0.animComplete) {
					var0.unlink();
				} else {
					world.addDynamic(var0.level, var0.x, var0.z, var0.y, 60, var0, 0, -1, false);
				}
			}
		}
	}

	// jag::oldscape::Client::GdmCoordArrow
	@ObfuscatedName("df.eb(III)V")
	public static void coordArrow(int arg0, int arg1) {
		if (hintType == 2) {
			getOverlayPos((hintTileX - mapBuildBaseX << 7) + hintOffsetX, (hintTileZ - mapBuildBaseZ << 7) + hintOffsetZ, hintHeight * 2);

			if (projectX > -1 && loopCycle % 20 < 10) {
				headiconsHint[0].plotSprite(projectX + arg0 - 12, projectY + arg1 - 28);
			}
		}
	}

	// jag::oldscape::Client::GdmOtherOverlays
	@ObfuscatedName("ek.er(IIIII)V")
	public static void otherOverlays(int arg0, int arg1, int arg2, int arg3) {
		if (crossMode == 1) {
			cross[crossCycle / 100].plotSprite(crossX - 8, crossY - 8);
		}
		if (crossMode == 2) {
			cross[crossCycle / 100 + 4].plotSprite(crossX - 8, crossY - 8);
		}
		overrideChat = 0;
		int var4 = (localPlayer.x >> 7) + mapBuildBaseX;
		int var5 = (localPlayer.z >> 7) + mapBuildBaseZ;
		if (var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
			overrideChat = 1;
		}
		if (var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
			overrideChat = 1;
		}
		if (overrideChat == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
			overrideChat = 0;
		}
		if (showFps) {
			int var6 = arg0 + 512 - 5;
			int var7 = arg1 + 20;
			fontPlain12.drawStringRight("Fps:" + fps, var6, var7, 0xffff00, -1);

			int var11 = var7 + 15;
			Runtime var8 = Runtime.getRuntime();
			int var9 = (int) ((var8.totalMemory() - var8.freeMemory()) / 1024L);
			int var10 = 0xffff00;
			if (var9 > 32768 && lowMemory) {
				var10 = 0xff0000;
			}
			if (var9 > 65536 && !lowMemory) {
				var10 = 0xff0000;
			}
			fontPlain12.drawStringRight("Mem:" + var9 + "k", var6, var11, var10, -1);
			var7 = var11 + 15;
		}
	}

	// jag::oldscape::Client::GetOverlayPos
	@ObfuscatedName("bd.es(Lfz;IB)V")
	public static void getOverlayPos(ClientEntity arg0, int arg1) {
		getOverlayPos(arg0.x, arg0.z, arg1);
	}

	// jag::oldscape::Client::GetOverlayPos
	@ObfuscatedName("cl.ez(IIII)V")
	public static void getOverlayPos(int arg0, int arg1, int arg2) {
		if (arg0 < 128 || arg1 < 128 || arg0 > 13056 || arg1 > 13056) {
			projectX = -1;
			projectY = -1;
			return;
		}
		int var3 = getAvH(arg0, arg1, minusedlevel) - arg2;
		int var4 = arg0 - camX;
		int var5 = var3 - camY;
		int var6 = arg1 - camZ;
		int var7 = Pix3D.sinTable[camPitch];
		int var8 = Pix3D.cosTable[camPitch];
		int var9 = Pix3D.sinTable[camYaw];
		int var10 = Pix3D.cosTable[camYaw];
		int var11 = var4 * var10 + var6 * var9 >> 16;
		int var12 = var6 * var10 - var4 * var9 >> 16;
		int var14 = var5 * var8 - var7 * var12 >> 16;
		int var15 = var5 * var7 + var8 * var12 >> 16;
		if (var15 >= 50) {
			projectX = (var11 << 9) / var15 + 256;
			projectY = (var14 << 9) / var15 + 167;
		} else {
			projectX = -1;
			projectY = -1;
		}
	}

	// jag::oldscape::Client::GetAvH
	@ObfuscatedName("bw.ev(IIII)I")
	public static int getAvH(int arg0, int arg1, int arg2) {
		int var3 = arg0 >> 7;
		int var4 = arg1 >> 7;
		if (var3 < 0 || var4 < 0 || var3 > 103 || var4 > 103) {
			return 0;
		}
		int var5 = arg2;
		if (arg2 < 3 && (ClientBuild.mapl[1][var3][var4] & 0x2) == 2) {
			var5 = arg2 + 1;
		}
		int var6 = arg0 & 0x7F;
		int var7 = arg1 & 0x7F;
		int var8 = (128 - var6) * ClientBuild.groundh[var5][var3][var4] + ClientBuild.groundh[var5][var3 + 1][var4] * var6 >> 7;
		int var9 = (128 - var6) * ClientBuild.groundh[var5][var3][var4 + 1] + ClientBuild.groundh[var5][var3 + 1][var4 + 1] * var6 >> 7;
		return (128 - var7) * var8 + var7 * var9 >> 7;
	}

	// jag::oldscape::Client::RebuildPacket
	@ObfuscatedName("cy.ei(ZI)V")
	public static void rebuildPacket(boolean region) {
		regionmode = region;

		if (!regionmode) {
			int var1 = in.g2();
			int var2 = in.g2_alt1();
			int var3 = (psize - in.pos) / 16;
			mapKeys = new int[var3][4];
			for (int var4 = 0; var4 < var3; var4++) {
				for (int var5 = 0; var5 < 4; var5++) {
					mapKeys[var4][var5] = in.g4_alt2();
				}
			}
			int var6 = in.g1_alt2();
			int var7 = in.g2();
			int var8 = in.g2_alt3();
			mapBuildIndex = new int[var3];
			mapBuildGroundFile = new int[var3];
			mapBuildLocationFile = new int[var3];
			mapBuildGroundData = new byte[var3][];
			mapBuildLocationData = new byte[var3][];
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
						mapBuildIndex[var10] = var13;
						mapBuildGroundFile[var10] = maps.getGroupId("m" + var11 + "_" + var12);
						mapBuildLocationFile[var10] = maps.getGroupId("l" + var11 + "_" + var12);
						var10++;
					}
				}
			}
			startRebuild(var7, var8, var6, var2, var1);
		} else {
			int var14 = in.g2_alt3();
			in.gBitStart();
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
			in.gBitEnd();
			int var19 = (psize - in.pos) / 16;
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
			mapBuildIndex = new int[var19];
			mapBuildGroundFile = new int[var19];
			mapBuildLocationFile = new int[var19];
			mapBuildGroundData = new byte[var19][];
			mapBuildLocationData = new byte[var19][];
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
								if (mapBuildIndex[var34] == var33) {
									var33 = -1;
									break;
								}
							}
							if (var33 != -1) {
								mapBuildIndex[var26] = var33;
								int var35 = var33 >> 8 & 0xFF;
								int var36 = var33 & 0xFF;
								mapBuildGroundFile[var26] = maps.getGroupId("m" + var35 + "_" + var36);
								mapBuildLocationFile[var26] = maps.getGroupId("l" + var35 + "_" + var36);
								var26++;
							}
						}
					}
				}
			}
			startRebuild(var14, var25, var23, var24, var22);
		}
	}

	// jag::oldscape::Client::StartRebuild
	@ObfuscatedName("as.ef(IIIIII)V")
	public static void startRebuild(int arg0, int arg1, int arg2, int arg3, int arg4) {
		if (mapBuildCenterZoneX == arg0 && mapBuildCenterZoneZ == arg1 && (sceneState == arg2 || !lowMemory)) {
			return;
		}

		mapBuildCenterZoneX = arg0;
		mapBuildCenterZoneZ = arg1;
		sceneState = arg2;
		if (!lowMemory) {
			sceneState = 0;
		}
		setMainState(25);
		messageBox(Text.LOADING, true);

		int var5 = mapBuildBaseX;
		int var6 = mapBuildBaseZ;
		mapBuildBaseX = (arg0 - 6) * 8;
		mapBuildBaseZ = (arg1 - 6) * 8;
		int var7 = mapBuildBaseX - var5;
		int var8 = mapBuildBaseZ - var6;
		int var9 = mapBuildBaseX;
		int var10 = mapBuildBaseZ;

		for (int var11 = 0; var11 < 32768; var11++) {
			ClientNpc var12 = npcs[var11];
			if (var12 != null) {
				for (int var13 = 0; var13 < 10; var13++) {
					var12.routeX[var13] -= var7;
					var12.routeZ[var13] -= var8;
				}
				var12.x -= var7 * 128;
				var12.z -= var8 * 128;
			}
		}

		for (int var14 = 0; var14 < 2048; var14++) {
			ClientPlayer var15 = players[var14];
			if (var15 != null) {
				for (int var16 = 0; var16 < 10; var16++) {
					var15.routeX[var16] -= var7;
					var15.routeZ[var16] -= var8;
				}
				var15.x -= var7 * 128;
				var15.z -= var8 * 128;
			}
		}

		minusedlevel = arg2;
		localPlayer.teleport(arg3, arg4, false);

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
						objStacks[var27][var23][var24] = objStacks[var27][var25][var26];
					} else {
						objStacks[var27][var23][var24] = null;
					}
				}
			}
		}

		for (LocChange var28 = (LocChange) locChanges.head(); var28 != null; var28 = (LocChange) locChanges.next()) {
			var28.x -= var7;
			var28.z -= var8;
			if (var28.x < 0 || var28.z < 0 || var28.x >= 104 || var28.z >= 104) {
				var28.unlink();
			}
		}

		if (minimapFlagX != 0) {
			minimapFlagX -= var7;
			minimapFlagZ -= var8;
		}

		waveCount = 0;
		cinemaCam = false;
		minimapLevel = -1;
		spotanims.clear();
		projectiles.clear();
	}

	// jag::oldscape::Client::PreventTimeout
	@ObfuscatedName("at.ej(ZB)V")
	public static void preventTimeout(boolean arg0) {
		flushAudio();

		noTimeoutCycle++;
		if (noTimeoutCycle < 50 && !arg0) {
			return;
		}

		noTimeoutCycle = 0;

		if (networkError || loginStream == null) {
			return;
		}

		// NO_TIMEOUT
		out.p1Enc(228);

		try {
			loginStream.write(out.data, 0, out.pos);
			out.pos = 0;
		} catch (IOException var2) {
			networkError = true;
		}
	}

	// jag::oldscape::minimap::Minimap::DrawDetail
	@ObfuscatedName("bs.eh(IIIIII)V")
	public static void drawDetail(int arg0, int arg1, int arg2, int arg3, int arg4) {
		int var5 = world.wallType(arg0, arg1, arg2);
		if (var5 != 0) {
			int var6 = world.typecode2(arg0, arg1, arg2, var5);
			int var7 = var6 >> 6 & 0x3;
			int var8 = var6 & 0x1F;
			int var9 = arg3;
			if (var5 > 0) {
				var9 = arg4;
			}
			int[] var10 = minimap.data;
			int var11 = (103 - arg2) * 2048 + arg1 * 4 + 24624;
			int var12 = var5 >> 14 & 0x7FFF;
			LocType var13 = LocType.list(var12);
			if (var13.mapscene != -1) {
				Pix8 var14 = mapscene[var13.mapscene];
				if (var14 != null) {
					int var15 = (var13.width * 4 - var14.wi) / 2;
					int var16 = (var13.length * 4 - var14.hi) / 2;
					var14.plotSprite(arg1 * 4 + 48 + var15, (104 - arg2 - var13.length) * 4 + 48 + var16);
				}
			} else {
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
			}
		}

		int var17 = world.sceneType(arg0, arg1, arg2);
		if (var17 != 0) {
			int var18 = world.typecode2(arg0, arg1, arg2, var17);
			int var19 = var18 >> 6 & 0x3;
			int var20 = var18 & 0x1F;
			int var21 = var17 >> 14 & 0x7FFF;
			LocType var22 = LocType.list(var21);
			if (var22.mapscene != -1) {
				Pix8 var23 = mapscene[var22.mapscene];
				if (var23 != null) {
					int var24 = (var22.width * 4 - var23.wi) / 2;
					int var25 = (var22.length * 4 - var23.hi) / 2;
					var23.plotSprite(arg1 * 4 + 48 + var24, (104 - arg2 - var22.length) * 4 + 48 + var25);
				}
			} else if (var20 == 9) {
				int var26 = 15658734;
				if (var17 > 0) {
					var26 = 15597568;
				}
				int[] var27 = minimap.data;
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

		int var29 = world.gdType(arg0, arg1, arg2);
		if (var29 != 0) {
			int var30 = var29 >> 14 & 0x7FFF;
			LocType var31 = LocType.list(var30);
			if (var31.mapscene != -1) {
				Pix8 var32 = mapscene[var31.mapscene];
				if (var32 != null) {
					int var33 = (var31.width * 4 - var32.wi) / 2;
					int var34 = (var31.length * 4 - var32.hi) / 2;
					var32.plotSprite(arg1 * 4 + 48 + var33, (104 - arg2 - var31.length) * 4 + 48 + var34);
				}
			}
		}
	}

	@ObfuscatedName("cz.eg(IIII)Z")
	public static boolean interactWithLoc(int arg0, int arg1, int arg2) {
		int var3 = arg2 >> 14 & 0x7FFF;
		int var4 = world.typecode2(minusedlevel, arg0, arg1, arg2);
		if (var4 == -1) {
			return false;
		}

		int shape = var4 & 0x1F;
		int angle = var4 >> 6 & 0x3;

		if (shape == 10 || shape == 11 || shape == 22) {
			LocType var7 = LocType.list(var3);

			int width;
			int length;
			if (angle == 0 || angle == 2) {
				width = var7.width;
				length = var7.length;
			} else {
				width = var7.length;
				length = var7.width;
			}

			int forceapproach = var7.forceapproach;
			if (angle != 0) {
				forceapproach = (forceapproach >> 4 - angle) + (forceapproach << angle & 0xF);
			}

			tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], arg0, arg1, true, 0, 0, width, length, forceapproach, 2);
		} else {
			tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], arg0, arg1, true, shape + 1, angle, 0, 0, 0, 2);
		}

		crossX = JavaMouseProvider.mouseClickX;
		crossY = JavaMouseProvider.mouseClickY;
		crossMode = 2;
		crossCycle = 0;
		return true;
	}

	@ObfuscatedName("eh.el(IIIIZIIIIIIS)Z")
	public static boolean tryMove(int arg0, int arg1, int arg2, int arg3, boolean arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
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
		int[][] var19 = levelCollisionMap[minusedlevel].flags;
		while (var36 != var16) {
			var13 = field1984[var16];
			var14 = field1985[var16];
			var16 = (var16 + 1) % var18;
			if (arg2 == var13 && arg3 == var14) {
				var17 = true;
				break;
			}
			if (arg5 != 0) {
				if ((arg5 < 5 || arg5 == 10) && levelCollisionMap[minusedlevel].testWall(var13, var14, arg2, arg3, arg5 - 1, arg6)) {
					var17 = true;
					break;
				}
				if (arg5 < 10 && levelCollisionMap[minusedlevel].testWDecor(var13, var14, arg2, arg3, arg5 - 1, arg6)) {
					var17 = true;
					break;
				}
			}
			if (arg7 != 0 && arg8 != 0 && levelCollisionMap[minusedlevel].testLoc(var13, var14, arg2, arg3, arg7, arg8, arg9)) {
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
		tryMoveNearest = 0;
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
			tryMoveNearest = 1;
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
				// MOVE_GAMECLICK
				out.p1Enc(176);
				out.p1(var32 + var32 + 3);
			} else if (arg10 == 1) {
				// MOVE_MINIMAPCLICK
				out.p1Enc(60);
				out.p1(var32 + var32 + 3 + 14);
			} else if (arg10 == 2) {
				// MOVE_OPCLICK (custom name)
				out.p1Enc(214);
				out.p1(var32 + var32 + 3);
			}

			minimapFlagX = field1984[0];
			minimapFlagZ = field1985[0];

			for (int var35 = 1; var35 < var32; var35++) {
				var37--;
				out.p1_alt2(field1984[var37] - var33);
				out.p1_alt3(field1985[var37] - var34);
			}

			out.p2_alt3(mapBuildBaseZ + var34);
			out.p1(JavaKeyboardProvider.actionKey[82] ? 1 : 0);
			out.p2(mapBuildBaseX + var33);
			return true;
		} else if (arg10 == 1) {
			return false;
		} else {
			return true;
		}
	}

	// jag::oldscape::Client::ZonePacket
	@ObfuscatedName("ai.en(I)V")
	public static void readZonePacket() {
		if (ptype == 245) {
			// LOC_MERGE
			int var0 = in.g2();
			byte var1 = in.g1b_alt1();
			int var2 = in.g1_alt2();
			int var3 = var2 >> 2;
			int var4 = var2 & 0x3;
			int var5 = LOC_SHAPE_TO_LAYER[var3];
			int locId = in.g2_alt2();
			int var7 = in.g2_alt1();
			int pid = in.g2();
			int var9 = in.g1_alt3();
			int var10 = (var9 >> 4 & 0x7) + baseX;
			int var11 = (var9 & 0x7) + baseZ;
			byte var12 = in.g1b_alt1();
			byte var13 = in.g1b();
			byte var14 = in.g1b();

			ClientPlayer player;
			if (selfSlot == pid) {
				player = localPlayer;
			} else {
				player = players[pid];
			}

			if (player != null) {
				LocType loc = LocType.list(locId);

				int width;
				int length;
				if (var4 == 1 || var4 == 3) {
					width = loc.length;
					length = loc.width;
				} else {
					width = loc.width;
					length = loc.length;
				}

				int var19 = (width >> 1) + var10;
				int var20 = (width + 1 >> 1) + var10;
				int var21 = (length >> 1) + var11;
				int var22 = (length + 1 >> 1) + var11;
				int[][] var23 = ClientBuild.groundh[minusedlevel];
				int locOffsetY = var23[var19][var21] + var23[var20][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
				int var25 = (var10 << 7) + (width << 6);
				int var26 = (var11 << 7) + (length << 6);

				ModelLit var27 = loc.getModelLit(var3, var4, var23, var25, locOffsetY, var26);
				if (var27 != null) {
					locChangeCreate(minusedlevel, var10, var11, var5, -1, 0, 0, var7 + 1, var0 + 1);
					player.locStartCycle = loopCycle + var7;
					player.locEndCycle = loopCycle + var0;
					player.locModel = var27;
					player.locOffsetX = var10 * 128 + width * 64;
					player.locOffsetZ = var11 * 128 + length * 64;
					player.locOffsetY = locOffsetY;
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
					player.minTileX = var10 + var14;
					player.maxTileX = var10 + var12;
					player.minTileZ = var11 + var13;
					player.maxTileZ = var1 + var11;
				}
			}
		} else if (ptype == 207) {
			int var30 = in.g2_alt3();
			int var31 = in.g1();
			int var32 = (var31 >> 4 & 0x7) + baseX;
			int var33 = (var31 & 0x7) + baseZ;
			if (var32 >= 0 && var33 >= 0 && var32 < 104 && var33 < 104) {
				LinkList var34 = objStacks[minusedlevel][var32][var33];
				if (var34 != null) {
					for (ClientObj var35 = (ClientObj) var34.head(); var35 != null; var35 = (ClientObj) var34.next()) {
						if ((var30 & 0x7FFF) == var35.id) {
							var35.unlink();
							break;
						}
					}
					if (var34.head() == null) {
						objStacks[minusedlevel][var32][var33] = null;
					}
					showObject(var32, var33);
				}
			}
		} else if (ptype == 205) {
			int var36 = in.g1();
			int var37 = (var36 >> 4 & 0x7) + baseX;
			int var38 = (var36 & 0x7) + baseZ;
			int var39 = in.g2();
			int var40 = in.g1();
			int var41 = var40 >> 4 & 0xF;
			int var42 = var40 & 0x7;
			int var43 = in.g1();
			if (var37 >= 0 && var38 >= 0 && var37 < 104 && var38 < 104) {
				int var44 = var41 + 1;
				if (localPlayer.routeX[0] >= var37 - var44 && localPlayer.routeX[0] <= var37 + var44 && localPlayer.routeZ[0] >= var38 - var44 && localPlayer.routeZ[0] <= var38 + var44 && ambientVolume != 0 && var42 > 0 && waveCount < 50) {
					waveSoundIds[waveCount] = var39;
					waveLoops[waveCount] = var42;
					waveDelay[waveCount] = var43;
					waveSounds[waveCount] = null;
					waveAmbient[waveCount] = (var37 << 16) + (var38 << 8) + var41;
					waveCount++;
				}
			}
		} else if (ptype == 6) {
			int var45 = in.g2_alt2();
			int var46 = in.g1_alt2();
			int var47 = (var46 >> 4 & 0x7) + baseX;
			int var48 = (var46 & 0x7) + baseZ;
			int var49 = in.g1_alt3();
			int var50 = var49 >> 2;
			int var51 = var49 & 0x3;
			int var52 = LOC_SHAPE_TO_LAYER[var50];
			if (var47 >= 0 && var48 >= 0 && var47 < 103 && var48 < 103) {
				if (var52 == 0) {
					Wall var53 = world.getWall(minusedlevel, var47, var48);
					if (var53 != null) {
						int var54 = var53.typecode >> 14 & 0x7FFF;
						if (var50 == 2) {
							var53.modelA = new ClientLocAnim(var54, 2, var51 + 4, minusedlevel, var47, var48, var45, false, var53.modelA);
							var53.modelB = new ClientLocAnim(var54, 2, var51 + 1 & 0x3, minusedlevel, var47, var48, var45, false, var53.modelB);
						} else {
							var53.modelA = new ClientLocAnim(var54, var50, var51, minusedlevel, var47, var48, var45, false, var53.modelA);
						}
					}
				}
				if (var52 == 1) {
					Decor var55 = world.getDecor(minusedlevel, var47, var48);
					if (var55 != null) {
						int var56 = var55.typecode >> 14 & 0x7FFF;
						if (var50 == 4 || var50 == 5) {
							var55.model = new ClientLocAnim(var56, 4, var51, minusedlevel, var47, var48, var45, false, var55.model);
						} else if (var50 == 6) {
							var55.model = new ClientLocAnim(var56, 4, var51 + 4, minusedlevel, var47, var48, var45, false, var55.model);
						} else if (var50 == 7) {
							var55.model = new ClientLocAnim(var56, 4, (var51 + 2 & 0x3) + 4, minusedlevel, var47, var48, var45, false, var55.model);
						} else if (var50 == 8) {
							var55.model = new ClientLocAnim(var56, 4, var51 + 4, minusedlevel, var47, var48, var45, false, var55.model);
							var55.model2 = new ClientLocAnim(var56, 4, (var51 + 2 & 0x3) + 4, minusedlevel, var47, var48, var45, false, var55.model2);
						}
					}
				}
				if (var52 == 2) {
					Sprite var57 = world.getScene(minusedlevel, var47, var48);
					if (var50 == 11) {
						var50 = 10;
					}
					if (var57 != null) {
						var57.model = new ClientLocAnim(var57.typecode >> 14 & 0x7FFF, var50, var51, minusedlevel, var47, var48, var45, false, var57.model);
					}
				}
				if (var52 == 3) {
					GroundDecor var58 = world.getGd(minusedlevel, var47, var48);
					if (var58 != null) {
						var58.model = new ClientLocAnim(var58.typecode >> 14 & 0x7FFF, 22, var51, minusedlevel, var47, var48, var45, false, var58.model);
					}
				}
			}
		} else if (ptype == 173) {
			int var59 = in.g1_alt1();
			int var60 = (var59 >> 4 & 0x7) + baseX;
			int var61 = (var59 & 0x7) + baseZ;
			int var62 = in.g2_alt2();
			int var63 = in.g2_alt3();
			if (var60 >= 0 && var61 >= 0 && var60 < 104 && var61 < 104) {
				ClientObj var64 = new ClientObj();
				var64.id = var63;
				var64.count = var62;
				if (objStacks[minusedlevel][var60][var61] == null) {
					objStacks[minusedlevel][var60][var61] = new LinkList();
				}
				objStacks[minusedlevel][var60][var61].push(var64);
				showObject(var60, var61);
			}
		} else if (ptype == 106) {
			int var65 = in.g1();
			int var66 = (var65 >> 4 & 0x7) + baseX;
			int var67 = (var65 & 0x7) + baseZ;
			int var68 = in.g2();
			int var69 = in.g2();
			int var70 = in.g2();
			if (var66 >= 0 && var67 >= 0 && var66 < 104 && var67 < 104) {
				LinkList var71 = objStacks[minusedlevel][var66][var67];
				if (var71 != null) {
					for (ClientObj var72 = (ClientObj) var71.head(); var72 != null; var72 = (ClientObj) var71.next()) {
						if ((var68 & 0x7FFF) == var72.id && var72.count == var69) {
							var72.count = var70;
							break;
						}
					}
					showObject(var66, var67);
				}
			}
		} else if (ptype == 154) {
			int var73 = in.g2_alt3();
			int var74 = in.g1_alt1();
			int var75 = var74 >> 2;
			int var76 = var74 & 0x3;
			int var77 = LOC_SHAPE_TO_LAYER[var75];
			int var78 = in.g1_alt2();
			int var79 = (var78 >> 4 & 0x7) + baseX;
			int var80 = (var78 & 0x7) + baseZ;
			if (var79 >= 0 && var80 >= 0 && var79 < 104 && var80 < 104) {
				locChangeCreate(minusedlevel, var79, var80, var77, var73, var75, var76, 0, -1);
			}
		} else if (ptype == 20) {
			int var81 = in.g1();
			int var82 = (var81 >> 4 & 0x7) + baseX;
			int var83 = (var81 & 0x7) + baseZ;
			int var84 = in.g2();
			int var85 = in.g1();
			int var86 = in.g2();
			if (var82 >= 0 && var83 >= 0 && var82 < 104 && var83 < 104) {
				int var87 = var82 * 128 + 64;
				int var88 = var83 * 128 + 64;
				MapSpotAnim var89 = new MapSpotAnim(var84, minusedlevel, var87, var88, getAvH(var87, var88, minusedlevel) - var85, var86, loopCycle);
				spotanims.push(var89);
			}
		} else if (ptype == 32) {
			int var90 = in.g1();
			int var91 = (var90 >> 4 & 0x7) + baseX;
			int var92 = (var90 & 0x7) + baseZ;
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
				ClientProj var107 = new ClientProj(var96, minusedlevel, var103, var104, getAvH(var103, var104, minusedlevel) - var97, loopCycle + var99, loopCycle + var100, var101, var102, var95, var98);
				var107.setTarget(var105, var106, getAvH(var105, var106, minusedlevel) - var98, loopCycle + var99);
				projectiles.push(var107);
			}
		} else if (ptype == 215) {
			int var108 = in.g1_alt2();
			int var109 = (var108 >> 4 & 0x7) + baseX;
			int var110 = (var108 & 0x7) + baseZ;
			int var111 = in.g2();
			int var112 = in.g2_alt2();
			int var113 = in.g2();
			if (var109 >= 0 && var110 >= 0 && var109 < 104 && var110 < 104 && selfSlot != var111) {
				ClientObj var114 = new ClientObj();
				var114.id = var113;
				var114.count = var112;
				if (objStacks[minusedlevel][var109][var110] == null) {
					objStacks[minusedlevel][var109][var110] = new LinkList();
				}
				objStacks[minusedlevel][var109][var110].push(var114);
				showObject(var109, var110);
			}
		} else if (ptype == 7) {
			int var115 = in.g1_alt3();
			int var116 = var115 >> 2;
			int var117 = var115 & 0x3;
			int var118 = LOC_SHAPE_TO_LAYER[var116];
			int var119 = in.g1_alt1();
			int var120 = (var119 >> 4 & 0x7) + baseX;
			int var121 = (var119 & 0x7) + baseZ;
			if (var120 >= 0 && var121 >= 0 && var120 < 104 && var121 < 104) {
				locChangeCreate(minusedlevel, var120, var121, var118, -1, var116, var117, 0, -1);
			}
		}
	}

	// jag::oldscape::Client::LocChangeCreate
	@ObfuscatedName("ap.ew(IIIIIIIIII)V")
	public static void locChangeCreate(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
		LocChange var9 = null;
		for (LocChange var10 = (LocChange) locChanges.head(); var10 != null; var10 = (LocChange) locChanges.next()) {
			if (var10.level == arg0 && var10.x == arg1 && var10.z == arg2 && var10.layer == arg3) {
				var9 = var10;
				break;
			}
		}
		if (var9 == null) {
			var9 = new LocChange();
			var9.level = arg0;
			var9.layer = arg3;
			var9.x = arg1;
			var9.z = arg2;
			locChangeSetOld(var9);
			locChanges.push(var9);
		}
		var9.newType = arg4;
		var9.newShape = arg5;
		var9.newAngle = arg6;
		var9.startTime = arg7;
		var9.endTime = arg8;
	}

	// jag::oldscape::Client::LocChangeSetOld
	@ObfuscatedName("dc.ek(Ldn;I)V")
	public static void locChangeSetOld(LocChange arg0) {
		int var1 = 0;
		int var2 = -1;
		int var3 = 0;
		int var4 = 0;
		if (arg0.layer == 0) {
			var1 = world.wallType(arg0.level, arg0.x, arg0.z);
		}
		if (arg0.layer == 1) {
			var1 = world.decorType(arg0.level, arg0.x, arg0.z);
		}
		if (arg0.layer == 2) {
			var1 = world.sceneType(arg0.level, arg0.x, arg0.z);
		}
		if (arg0.layer == 3) {
			var1 = world.gdType(arg0.level, arg0.x, arg0.z);
		}
		if (var1 != 0) {
			int var5 = world.typecode2(arg0.level, arg0.x, arg0.z, var1);
			var2 = var1 >> 14 & 0x7FFF;
			var3 = var5 & 0x1F;
			var4 = var5 >> 6 & 0x3;
		}
		arg0.oldType = var2;
		arg0.oldShape = var3;
		arg0.oldAngle = var4;
	}

	// jag::oldscape::Client::LocChangeUnchecked
	@ObfuscatedName("f.eq(IIIIIIII)V")
	public static void locChangeUnchecked(int arg0, int layer, int arg2, int arg3, int arg4, int arg5, int arg6) {
		if (arg2 < 1 || arg3 < 1 || arg2 > 102 || arg3 > 102) {
			return;
		}
		if (lowMemory && minusedlevel != arg0) {
			return;
		}
		int var7 = 0;
		boolean var8 = true;
		boolean var9 = false;
		boolean var10 = false;
		if (layer == 0) {
			var7 = world.wallType(arg0, arg2, arg3);
		}
		if (layer == 1) {
			var7 = world.decorType(arg0, arg2, arg3);
		}
		if (layer == 2) {
			var7 = world.sceneType(arg0, arg2, arg3);
		}
		if (layer == 3) {
			var7 = world.gdType(arg0, arg2, arg3);
		}
		if (var7 != 0) {
			int var11 = world.typecode2(arg0, arg2, arg3, var7);
			int var12 = var7 >> 14 & 0x7FFF;
			int var13 = var11 & 0x1F;
			int var14 = var11 >> 6 & 0x3;
			if (layer == 0) {
				world.delWall(arg0, arg2, arg3);
				LocType var15 = LocType.list(var12);
				if (var15.blockwalk != 0) {
					levelCollisionMap[arg0].delWall(arg2, arg3, var13, var14, var15.blockrange);
				}
			}
			if (layer == 1) {
				world.delDecor(arg0, arg2, arg3);
			}
			if (layer == 2) {
				world.delLoc(arg0, arg2, arg3);
				LocType var16 = LocType.list(var12);
				if (var16.width + arg2 > 103 || var16.width + arg3 > 103 || var16.length + arg2 > 103 || var16.length + arg3 > 103) {
					return;
				}
				if (var16.blockwalk != 0) {
					levelCollisionMap[arg0].delLoc(arg2, arg3, var16.width, var16.length, var14, var16.blockrange);
				}
			}
			if (layer == 3) {
				world.delGroundDecor(arg0, arg2, arg3);
				LocType var17 = LocType.list(var12);
				if (var17.blockwalk == 1) {
					levelCollisionMap[arg0].unblockGroundDecor(arg2, arg3);
				}
			}
		}
		if (arg4 >= 0) {
			int var18 = arg0;
			if (arg0 < 3 && (ClientBuild.mapl[1][arg2][arg3] & 0x2) == 2) {
				var18 = arg0 + 1;
			}
			ClientBuild.changeLocUnchecked(arg0, var18, arg2, arg3, arg4, arg5, arg6, world, levelCollisionMap[arg0]);
		}
	}

	// jag::oldscape::Client::ShowObject
	@ObfuscatedName("dr.et(III)V")
	public static void showObject(int arg0, int arg1) {
		LinkList var2 = objStacks[minusedlevel][arg0][arg1];
		if (var2 == null) {
			world.delObj(minusedlevel, arg0, arg1);
			return;
		}
		int var3 = -99999999;
		ClientObj var4 = null;
		for (ClientObj var5 = (ClientObj) var2.head(); var5 != null; var5 = (ClientObj) var2.next()) {
			ObjType var6 = ObjType.list(var5.id);
			int var7 = var6.cost;
			if (var6.stackable == 1) {
				var7 = (var5.count + 1) * var7;
			}
			if (var7 > var3) {
				var3 = var7;
				var4 = var5;
			}
		}
		if (var4 == null) {
			world.delObj(minusedlevel, arg0, arg1);
			return;
		}
		var2.addHead(var4);
		ClientObj var8 = null;
		ClientObj var9 = null;
		for (ClientObj var10 = (ClientObj) var2.head(); var10 != null; var10 = (ClientObj) var2.next()) {
			if (var4.id != var10.id) {
				if (var8 == null) {
					var8 = var10;
				}
				if (var8.id != var10.id && var9 == null) {
					var9 = var10;
				}
			}
		}
		int var11 = (arg1 << 7) + arg0 + 1610612736;
		world.setObj(minusedlevel, arg0, arg1, getAvH(arg0 * 128 + 64, arg1 * 128 + 64, minusedlevel), var4, var11, var8, var9);
	}

	@ObfuscatedName("ej.ee(I)V")
	public static void getPlayerPos() {
		entityRemovalCount = 0;
		entityUpdateCount = 0;
		getPlayerPosLocal();
		getPlayerPosOldVis();
		getPlayerPosNewVis();
		getPlayerPosExtended();
		for (int var44 = 0; var44 < entityRemovalCount; var44++) {
			int var45 = entityRemovalIds[var44];
			if (loopCycle != players[var45].cycle) {
				players[var45] = null;
			}
		}
		if (psize != in.pos) {
			throw new RuntimeException("gpp1 pos:" + in.pos + " size:" + psize);
		}
		for (int var46 = 0; var46 < playerCount; var46++) {
			if (players[playerIds[var46]] == null) {
				throw new RuntimeException("gpp2 pos:" + var46 + " size:" + playerCount);
			}
		}
	}

	public static void getPlayerPosLocal() {
		in.gBitStart();
		int var0 = in.gBit(1);
		if (var0 == 0) {
			return;
		}
		int var1 = in.gBit(2);
		if (var1 == 0) {
			entityUpdateIds[++entityUpdateCount - 1] = 2047;
		} else if (var1 == 1) {
			int var2 = in.gBit(3);
			localPlayer.moveCode(var2, false);
			int var3 = in.gBit(1);
			if (var3 == 1) {
				entityUpdateIds[++entityUpdateCount - 1] = 2047;
			}
		} else if (var1 == 2) {
			int var4 = in.gBit(3);
			localPlayer.moveCode(var4, true);
			int var5 = in.gBit(3);
			localPlayer.moveCode(var5, true);
			int var6 = in.gBit(1);
			if (var6 == 1) {
				entityUpdateIds[++entityUpdateCount - 1] = 2047;
			}
		} else if (var1 == 3) {
			minusedlevel = in.gBit(2);
			int var7 = in.gBit(7);
			int var8 = in.gBit(1);
			if (var8 == 1) {
				entityUpdateIds[++entityUpdateCount - 1] = 2047;
			}
			int var9 = in.gBit(7);
			int var10 = in.gBit(1);
			localPlayer.teleport(var7, var9, var10 == 1);
		}
	}

	public static void getPlayerPosOldVis() {
		int var11 = in.gBit(8);
		if (var11 < playerCount) {
			for (int var12 = var11; var12 < playerCount; var12++) {
				entityRemovalIds[++entityRemovalCount - 1] = playerIds[var12];
			}
		}
		if (var11 > playerCount) {
			throw new RuntimeException("gppov1");
		}
		playerCount = 0;
		for (int var13 = 0; var13 < var11; var13++) {
			int var14 = playerIds[var13];
			ClientPlayer var15 = players[var14];
			int var16 = in.gBit(1);
			if (var16 == 0) {
				playerIds[++playerCount - 1] = var14;
				var15.cycle = loopCycle;
			} else {
				int var17 = in.gBit(2);
				if (var17 == 0) {
					playerIds[++playerCount - 1] = var14;
					var15.cycle = loopCycle;
					entityUpdateIds[++entityUpdateCount - 1] = var14;
				} else if (var17 == 1) {
					playerIds[++playerCount - 1] = var14;
					var15.cycle = loopCycle;
					int var18 = in.gBit(3);
					var15.moveCode(var18, false);
					int var19 = in.gBit(1);
					if (var19 == 1) {
						entityUpdateIds[++entityUpdateCount - 1] = var14;
					}
				} else if (var17 == 2) {
					playerIds[++playerCount - 1] = var14;
					var15.cycle = loopCycle;
					int var20 = in.gBit(3);
					var15.moveCode(var20, true);
					int var21 = in.gBit(3);
					var15.moveCode(var21, true);
					int var22 = in.gBit(1);
					if (var22 == 1) {
						entityUpdateIds[++entityUpdateCount - 1] = var14;
					}
				} else if (var17 == 3) {
					entityRemovalIds[++entityRemovalCount - 1] = var14;
				}
			}
		}
	}

	public static void getPlayerPosNewVis() {
		while (in.bitsLeft(psize) >= 11) {
			int var23 = in.gBit(11);
			if (var23 == 2047) {
				break;
			}
			boolean var47 = false;
			if (players[var23] == null) {
				players[var23] = new ClientPlayer();
				if (playerAppearanceBuffer[var23] != null) {
					players[var23].setAppearance(playerAppearanceBuffer[var23]);
				}
				var47 = true;
			}
			playerIds[++playerCount - 1] = var23;
			ClientPlayer var48 = players[var23];
			var48.cycle = loopCycle;
			int var49 = in.gBit(5);
			if (var49 > 15) {
				var49 -= 32;
			}
			int var50 = field1941[in.gBit(3)];
			if (var47) {
				var48.dstYaw = var48.yaw = var50;
			}
			int var51 = in.gBit(5);
			if (var51 > 15) {
				var51 -= 32;
			}
			int var52 = in.gBit(1);
			int var53 = in.gBit(1);
			if (var53 == 1) {
				entityUpdateIds[++entityUpdateCount - 1] = var23;
			}
			var48.teleport(localPlayer.routeX[0] + var51, localPlayer.routeZ[0] + var49, var52 == 1);
		}
		in.gBitEnd();
	}

	public static void getPlayerPosExtended() {
		for (int var24 = 0; var24 < entityUpdateCount; var24++) {
			int var25 = entityUpdateIds[var24];
			ClientPlayer var26 = players[var25];
			int var27 = in.g1();
			if ((var27 & 0x40) != 0) {
				var27 += in.g1() << 8;
			}
			getPlayerPosExtended(var25, var26, var27);
		}
	}

	public static void getPlayerPosExtended(int var25, ClientPlayer var26, int var27) {
		if ((var27 & 0x4) != 0) {
			int var28 = in.g2();
			int var29 = in.g1();
			int var30 = in.g1();
			int var31 = in.pos;
			if (var26.name != null && var26.model != null) {
				boolean var32 = false;
				if (var29 <= 1 && isIgnored(var26.name)) {
					var32 = true;
				}
				if (!var32 && overrideChat == 0) {
					field2016.pos = 0;
					in.gdata(field2016.data, 0, var30);
					field2016.pos = 0;
					String var33 = PixFont.method2844(StringUtil.method54(WordPack.unpack(field2016)));
					var26.chat = var33.trim();
					var26.field2652 = var28 >> 8;
					var26.field2670 = var28 & 0xFF;
					var26.chatTimer = 150;
					if (var29 == 2 || var29 == 3) {
						addChat(1, StringConstants.TAG_IMG(1) + var26.name, var33);
					} else if (var29 == 1) {
						addChat(1, StringConstants.TAG_IMG(0) + var26.name, var33);
					} else {
						addChat(2, var26.name, var33);
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
			var26.setAppearance(var36);
		}
		if ((var27 & 0x100) != 0) {
			var26.exactStartX = in.g1();
			var26.exactStartZ = in.g1_alt2();
			var26.exactEndX = in.g1();
			var26.exactEndZ = in.g1_alt1();
			var26.exactMoveEnd = in.g2_alt2() + loopCycle;
			var26.exactMoveStart = in.g2() + loopCycle;
			var26.exactMoveFacing = in.g1_alt2();
			var26.routeLength = 1;
			var26.preanimRouteLength = 0;
		}
		if ((var27 & 0x20) != 0) {
			var26.targetId = in.g2_alt3();
			if (var26.targetId == 65535) {
				var26.targetId = -1;
			}
		}
		if ((var27 & 0x80) != 0) {
			var26.targetTileX = in.g2_alt2();
			var26.targetTileZ = in.g2_alt1();
		}
		if ((var27 & 0x10) != 0) {
			int var37 = in.g2_alt2();
			if (var37 == 65535) {
				var37 = -1;
			}
			int var38 = in.g1_alt2();
			triggerPlayerAnim(var26, var37, var38);
		}
		if ((var27 & 0x200) != 0) {
			var26.spotanimId = in.g2_alt1();
			int var39 = in.g4();
			var26.field2629 = var39 >> 16;
			var26.spotanimLastCycle = (var39 & 0xFFFF) + loopCycle;
			var26.spotanimFrame = 0;
			var26.spotanimCycle = 0;
			if (var26.spotanimLastCycle > loopCycle) {
				var26.spotanimFrame = -1;
			}
			if (var26.spotanimId == 65535) {
				var26.spotanimId = -1;
			}
		}
		if ((var27 & 0x400) != 0) {
			int var40 = in.g1_alt1();
			int var41 = in.g1_alt3();
			var26.addHitmark(var40, var41, loopCycle);
			var26.combatCycle = loopCycle + 300;
			var26.health = in.g1();
			var26.totalHealth = in.g1_alt2();
		}
		if ((var27 & 0x1) != 0) {
			var26.chat = in.gjstr();
			if (var26.chat.charAt(0) == '~') {
				var26.chat = var26.chat.substring(1);
				addChat(2, var26.name, var26.chat);
			} else if (localPlayer == var26) {
				addChat(2, var26.name, var26.chat);
			}
			var26.field2652 = 0;
			var26.field2670 = 0;
			var26.chatTimer = 150;
		}
		if ((var27 & 0x8) != 0) {
			int var42 = in.g1_alt1();
			int var43 = in.g1_alt3();
			var26.addHitmark(var42, var43, loopCycle);
			var26.combatCycle = loopCycle + 300;
			var26.health = in.g1_alt1();
			var26.totalHealth = in.g1();
		}
	}

	// jag::oldscape::Client::GetNPCPos
	public static void getNpcPos() {
		entityRemovalCount = 0;
		entityUpdateCount = 0;
		getNpcPosOldVis();
		getNpcPosNewVis();
		getNpcPosExtended();
		for (int var374 = 0; var374 < entityRemovalCount; var374++) {
			int var375 = entityRemovalIds[var374];
			if (loopCycle != npcs[var375].cycle) {
				npcs[var375].type = null;
				npcs[var375] = null;
			}
		}
		if (psize != in.pos) {
			throw new RuntimeException("gnp1 pos:" + in.pos + " psize:" + psize);
		}
		for (int var376 = 0; var376 < npcCount; var376++) {
			if (npcs[npcIds[var376]] == null) {
				throw new RuntimeException("gnp2 pos:" + var376 + " size:" + npcCount);
			}
		}
	}

	// jag::oldscape::Client::GetNPCPosOldVis
	public static void getNpcPosOldVis() {
		in.gBitStart();
		int var362 = in.gBit(8);
		if (var362 < npcCount) {
			for (int var363 = var362; var363 < npcCount; var363++) {
				entityRemovalIds[++entityRemovalCount - 1] = npcIds[var363];
			}
		}
		if (var362 > npcCount) {
			throw new RuntimeException("gnpov1");
		}
		npcCount = 0;
		for (int var364 = 0; var364 < var362; var364++) {
			int var365 = npcIds[var364];
			ClientNpc var366 = npcs[var365];
			int var367 = in.gBit(1);
			if (var367 == 0) {
				npcIds[++npcCount - 1] = var365;
				var366.cycle = loopCycle;
			} else {
				int var368 = in.gBit(2);
				if (var368 == 0) {
					npcIds[++npcCount - 1] = var365;
					var366.cycle = loopCycle;
					entityUpdateIds[++entityUpdateCount - 1] = var365;
				} else if (var368 == 1) {
					npcIds[++npcCount - 1] = var365;
					var366.cycle = loopCycle;
					int var369 = in.gBit(3);
					var366.moveCode(var369, false);
					int var370 = in.gBit(1);
					if (var370 == 1) {
						entityUpdateIds[++entityUpdateCount - 1] = var365;
					}
				} else if (var368 == 2) {
					npcIds[++npcCount - 1] = var365;
					var366.cycle = loopCycle;
					int var371 = in.gBit(3);
					var366.moveCode(var371, true);
					int var372 = in.gBit(3);
					var366.moveCode(var372, true);
					int var373 = in.gBit(1);
					if (var373 == 1) {
						entityUpdateIds[++entityUpdateCount - 1] = var365;
					}
				} else if (var368 == 3) {
					entityRemovalIds[++entityRemovalCount - 1] = var365;
				}
			}
		}
	}

	// jag::oldscape::Client::GetNPCPosNewVis
	@ObfuscatedName("dm.ed(I)V")
	public static void getNpcPosNewVis() {
		while (in.bitsLeft(psize) >= 27) {
			int var0 = in.gBit(15);
			if (var0 == 32767) {
				break;
			}

			boolean var1 = false;
			if (npcs[var0] == null) {
				npcs[var0] = new ClientNpc();
				var1 = true;
			}
			ClientNpc var2 = npcs[var0];
			npcIds[++npcCount - 1] = var0;
			var2.cycle = loopCycle;
			int var3 = field1941[in.gBit(3)];
			if (var1) {
				var2.dstYaw = var2.yaw = var3;
			}
			int var4 = in.gBit(5);
			if (var4 > 15) {
				var4 -= 32;
			}
			int var5 = in.gBit(1);
			if (var5 == 1) {
				entityUpdateIds[++entityUpdateCount - 1] = var0;
			}
			int var6 = in.gBit(1);
			var2.type = NpcType.list(in.gBit(14));
			int var7 = in.gBit(5);
			if (var7 > 15) {
				var7 -= 32;
			}
			var2.size = var2.type.size;
			var2.turnSpeed = var2.type.turnspeed;
			if (var2.turnSpeed == 0) {
				var2.yaw = 0;
			}
			var2.walkanim = var2.type.walkanim;
			var2.walkanim_b = var2.type.walkanim_b;
			var2.walkanim_l = var2.type.walkanim_r;
			var2.walkanim_r = var2.type.walkanim_l;
			var2.readyanim = var2.type.readyanim;
			var2.turnleftanim = var2.type.turnleftanim;
			var2.turnrightanim = var2.type.turnrightanim;
			var2.teleport(localPlayer.routeX[0] + var7, localPlayer.routeZ[0] + var4, var6 == 1);
		}

		in.gBitEnd();
	}

	// jag::oldscape::Client::GetNPCPosExtended
	@ObfuscatedName("ag.ex(B)V")
	public static void getNpcPosExtended() {
		for (int var0 = 0; var0 < entityUpdateCount; var0++) {
			int var1 = entityUpdateIds[var0];
			ClientNpc var2 = npcs[var1];
			int var3 = in.g1();
			if ((var3 & 0x80) != 0) {
				int var4 = in.g1();
				int var5 = in.g1_alt2();
				var2.addHitmark(var4, var5, loopCycle);
				var2.combatCycle = loopCycle + 300;
				var2.health = in.g1_alt1();
				var2.totalHealth = in.g1_alt1();
			}
			if ((var3 & 0x4) != 0) {
				var2.targetId = in.g2_alt1();
				if (var2.targetId == 65535) {
					var2.targetId = -1;
				}
			}
			if ((var3 & 0x2) != 0) {
				var2.targetTileX = in.g2_alt3();
				var2.targetTileZ = in.g2_alt3();
			}
			if ((var3 & 0x1) != 0) {
				var2.spotanimId = in.g2_alt1();
				int var6 = in.g4();
				var2.field2629 = var6 >> 16;
				var2.spotanimLastCycle = (var6 & 0xFFFF) + loopCycle;
				var2.spotanimFrame = 0;
				var2.spotanimCycle = 0;
				if (var2.spotanimLastCycle > loopCycle) {
					var2.spotanimFrame = -1;
				}
				if (var2.spotanimId == 65535) {
					var2.spotanimId = -1;
				}
			}
			if ((var3 & 0x8) != 0) {
				int var7 = in.g2_alt3();
				if (var7 == 65535) {
					var7 = -1;
				}
				int var8 = in.g1_alt1();
				if (var2.primarySeqId == var7 && var7 != -1) {
					int var9 = SeqType.list(var7).duplicatebehavior;
					if (var9 == 1) {
						var2.primarySeqFrame = 0;
						var2.primarySeqCycle = 0;
						var2.primarySeqDelay = var8;
						var2.field2647 = 0;
					}
					if (var9 == 2) {
						var2.field2647 = 0;
					}
				} else if (var7 == -1 || var2.primarySeqId == -1 || SeqType.list(var7).priority >= SeqType.list(var2.primarySeqId).priority) {
					var2.primarySeqId = var7;
					var2.primarySeqFrame = 0;
					var2.primarySeqCycle = 0;
					var2.primarySeqDelay = var8;
					var2.field2647 = 0;
					var2.preanimRouteLength = var2.routeLength;
				}
			}
			if ((var3 & 0x40) != 0) {
				var2.type = NpcType.list(in.g2());
				var2.size = var2.type.size;
				var2.turnSpeed = var2.type.turnspeed;
				var2.walkanim = var2.type.walkanim;
				var2.walkanim_b = var2.type.walkanim_b;
				var2.walkanim_l = var2.type.walkanim_r;
				var2.walkanim_r = var2.type.walkanim_l;
				var2.readyanim = var2.type.readyanim;
				var2.turnleftanim = var2.type.turnleftanim;
				var2.turnrightanim = var2.type.turnrightanim;
			}
			if ((var3 & 0x20) != 0) {
				var2.chat = in.gjstr();
				var2.chatTimer = 100;
			}
			if ((var3 & 0x10) != 0) {
				int var10 = in.g1_alt3();
				int var11 = in.g1_alt3();
				var2.addHitmark(var10, var11, loopCycle);
				var2.combatCycle = loopCycle + 300;
				var2.health = in.g1_alt3();
				var2.totalHealth = in.g1_alt1();
			}
		}
	}

	// jag::oldscape::Client::DirtyArea
	@ObfuscatedName("bs.ea(IIIII)V")
	public static void dirtyArea(int arg0, int arg1, int arg2, int arg3) {
		for (int i = 0; i < componentDrawCount; i++) {
			if (componentDrawWidth[i] + componentDrawX[i] > arg0 && componentDrawX[i] < arg0 + arg2 && componentDrawHeight[i] + componentDrawY[i] > arg1 && componentDrawY[i] < arg1 + arg3) {
				componentRedrawRequested1[i] = true;
			}
		}
	}

	// jag::oldscape::minimenu::Minimenu::Open
	@ObfuscatedName("bk.ep(B)V")
	public static void openMenu() {
		int width = fontBold12.stringWid(Text.CHOOSEOPTION);
		for (int i = 0; i < menuNumEntries; i++) {
			int var2 = fontBold12.stringWid(getLine(i));
			if (var2 > width) {
				width = var2;
			}
		}
		width += 8;

		int height = menuNumEntries * 15 + 21;

		int var4 = JavaMouseProvider.mouseClickX - width / 2;
		if (width + var4 > 765) {
			var4 = 765 - width;
		}
		if (var4 < 0) {
			var4 = 0;
		}

		int var5 = JavaMouseProvider.mouseClickY;
		if (height + var5 > 503) {
			var5 = 503 - height;
		}
		if (var5 < 0) {
			var5 = 0;
		}

		isMenuOpen = true;
		menuX = var4;
		menuY = var5;
		menuWidth = width;
		menuHeight = menuNumEntries * 15 + 22;
	}

	@ObfuscatedName("br.em(II)Z")
	public static boolean isAddFriendOption(int arg0) {
		if (arg0 < 0) {
			return false;
		}

		int var1 = menuAction[arg0];
		if (var1 >= 2000) {
			var1 -= 2000;
		}
		return var1 == 1007;
	}

	// jag::oldscape::Client::DoAction
	@ObfuscatedName("m.ey(II)V")
	public static void doAction(int arg0) {
		if (arg0 < 0) {
			return;
		}

		int b = menuParamB[arg0];
		int c = menuParamC[arg0];
		int action = menuAction[arg0];
		int a = menuParamA[arg0];

		if (action >= 2000) {
			action -= 2000;
		}

		if (action == 45) {
			ClientPlayer var5 = players[a];
			if (var5 != null) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var5.routeX[0], var5.routeZ[0], false, 0, 0, 1, 1, 0, 2);

				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;

				// OPPLAYER2
				out.p1Enc(146);
				out.p2(a);
			}
		}

		if (action == 35) {
			// OPHELD3
			out.p1Enc(76);
			out.p2_alt1(b);
			out.p4_alt2(c);
			out.p2_alt1(a);

			selectedCycle = 0;
			selectedArea = IfType.get(c);
			selectedItem = b;
		}

		if (action == 8) {
			ClientNpc var6 = npcs[a];
			if (var6 != null) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var6.routeX[0], var6.routeZ[0], false, 0, 0, 1, 1, 0, 2);
				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;

				// OPNPCT
				out.p1Enc(190);
				out.p4(targetCom);
				out.p2_alt2(a);
				out.p2_alt2(targetSub);
			}
		}

		if (action == 51) {
			ClientPlayer var7 = players[a];
			if (var7 != null) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var7.routeX[0], var7.routeZ[0], false, 0, 0, 1, 1, 0, 2);

				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;

				// OPPLAYER8
				out.p1Enc(145);
				out.p2_alt1(a);
			}
		}

		if (action == 28) {
			// IF_BUTTON
			out.p1Enc(155);
			out.p4(c);

			IfType var8 = IfType.get(c);
			if (var8.scripts != null && var8.scripts[0][0] == 5) {
				int var9 = var8.scripts[0][1];
				VarCache.var[var9] = 1 - VarCache.var[var9];
				clientVar(var9);
			}
		}

		if (action == 1002) {
			crossX = JavaMouseProvider.mouseClickX;
			crossY = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;

			// OPLOCE
			out.p1Enc(162);
			out.p2_alt2(a >> 14 & 0x7FFF);
		}

		if (action == 31) {
			// OPHELDU
			out.p1Enc(70);
			out.p2_alt1(a);
			out.p2_alt1(field555);
			out.p2(field557);
			out.p4(c);
			out.p2_alt1(b);
			out.p4_alt1(field502);

			selectedCycle = 0;
			selectedArea = IfType.get(c);
			selectedItem = b;
		}

		if (action == 1004) {
			crossX = JavaMouseProvider.mouseClickX;
			crossY = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;

			// OPOBJE
			out.p1Enc(49);
			out.p2_alt1(a);
		}

		if (action == 47) {
			ClientPlayer var10 = players[a];
			if (var10 != null) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var10.routeX[0], var10.routeZ[0], false, 0, 0, 1, 1, 0, 2);

				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;

				// OPPLAYER4
				out.p1Enc(78);
				out.p2(a);
			}
		}

		if (action == 32) {
			// OPHELDT
			out.p1Enc(218);
			out.p2_alt1(targetSub);
			out.p2(b);
			out.p2(a);
			out.p4_alt2(c);
			out.p4_alt2(targetCom);

			selectedCycle = 0;
			selectedArea = IfType.get(c);
			selectedItem = b;
		}

		if (action == 46) {
			ClientPlayer var11 = players[a];
			if (var11 != null) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var11.routeX[0], var11.routeZ[0], false, 0, 0, 1, 1, 0, 2);

				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;

				// OPPLAYER3
				out.p1Enc(102);
				out.p2_alt1(a);
			}
		}

		if (action == 20) {
			boolean var12 = tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], b, c, false, 0, 0, 0, 0, 0, 2);
			if (!var12) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], b, c, false, 0, 0, 1, 1, 0, 2);
			}

			crossX = JavaMouseProvider.mouseClickX;
			crossY = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;

			// OPOBJ3
			out.p1Enc(224);
			out.p2_alt2(a);
			out.p2_alt3(mapBuildBaseX + b);
			out.p2_alt2(mapBuildBaseZ + c);
		}

		if (action == 12) {
			ClientNpc var14 = npcs[a];
			if (var14 != null) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var14.routeX[0], var14.routeZ[0], false, 0, 0, 1, 1, 0, 2);

				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;

				// OPNPC4
				out.p1Enc(95);
				out.p2_alt1(a);
			}
		}

		if (action == 14) {
			ClientPlayer var15 = players[a];
			if (var15 != null) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var15.routeX[0], var15.routeZ[0], false, 0, 0, 1, 1, 0, 2);

				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;

				// OPPLAYERU
				out.p1Enc(226);
				out.p2_alt2(field555);
				out.p2_alt1(field557);
				out.p2_alt2(a);
				out.p4_alt2(field502);
			}
		}

		if (action == 2) {
			if (interactWithLoc(b, c, a)) {
				// OPLOCT
				out.p1Enc(247);
				out.p4_alt3(targetCom);
				out.p2(mapBuildBaseZ + c);
				out.p2_alt1(targetSub);
				out.p2_alt2(a >> 14 & 0x7FFF);
				out.p2_alt1(mapBuildBaseX + b);
			}
		}

		if (action == 41) {
			// INV_BUTTON3
			out.p1Enc(6);
			out.p2_alt1(b);
			out.p4_alt1(c);
			out.p2_alt3(a);

			selectedCycle = 0;
			selectedArea = IfType.get(c);
			selectedItem = b;
		}

		if (action == 50) {
			ClientPlayer var16 = players[a];
			if (var16 != null) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var16.routeX[0], var16.routeZ[0], false, 0, 0, 1, 1, 0, 2);

				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;

				// OPPLAYER7
				out.p1Enc(119);
				out.p2_alt3(a);
			}
		}

		if (action == 29) {
			// IF_BUTTON
			out.p1Enc(155);
			out.p4(c);

			IfType var17 = IfType.get(c);
			if (var17.scripts != null && var17.scripts[0][0] == 5) {
				int var18 = var17.scripts[0][1];
				if (VarCache.var[var18] != var17.scriptOperand[0]) {
					VarCache.var[var18] = var17.scriptOperand[0];
					clientVar(var18);
				}
			}
		}

		if (action == 48) {
			ClientPlayer var19 = players[a];
			if (var19 != null) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var19.routeX[0], var19.routeZ[0], false, 0, 0, 1, 1, 0, 2);

				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;

				// OPPLAYER5
				out.p1Enc(117);
				out.p2_alt2(a);
			}
		}

		if (action == 33) {
			// OPHELD1
			out.p1Enc(135);
			out.p4_alt2(c);
			out.p2_alt3(a);
			out.p2_alt3(b);

			selectedCycle = 0;
			selectedArea = IfType.get(c);
			selectedItem = b;
		}

		if (action == 1) {
			if (interactWithLoc(b, c, a)) {
				// OPLOCU
				out.p1Enc(241);
				out.p4_alt1(field502);
				out.p2(field557);
				out.p2(a >> 14 & 0x7FFF);
				out.p2_alt2(mapBuildBaseX + b);
				out.p2_alt1(field555);
				out.p2_alt2(mapBuildBaseZ + c);
			}
		}

		if (action == 6) {
			interactWithLoc(b, c, a);

			// OPLOC4
			out.p1Enc(83);
			out.p2_alt2(mapBuildBaseX + b);
			out.p2_alt3(mapBuildBaseZ + c);
			out.p2_alt3(a >> 14 & 0x7FFF);
		}

		if (action == 15) {
			ClientPlayer var20 = players[a];
			if (var20 != null) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var20.routeX[0], var20.routeZ[0], false, 0, 0, 1, 1, 0, 2);

				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;

				// OPPLAYERT
				out.p1Enc(183);
				out.p2_alt2(targetSub);
				out.p4(targetCom);
				out.p2_alt1(a);
			}
		}

		if (action == 18) {
			boolean var21 = tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], b, c, false, 0, 0, 0, 0, 0, 2);
			if (!var21) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], b, c, false, 0, 0, 1, 1, 0, 2);
			}

			crossX = JavaMouseProvider.mouseClickX;
			crossY = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;

			// OPOBJ1
			out.p1Enc(243);
			out.p2_alt1(a);
			out.p2(mapBuildBaseX + b);
			out.p2_alt3(mapBuildBaseZ + c);
		}

		if (action == 5) {
			interactWithLoc(b, c, a);

			// OPLOC3
			out.p1Enc(133);
			out.p2_alt2(mapBuildBaseX + b);
			out.p2_alt2(mapBuildBaseZ + c);
			out.p2_alt3(a >> 14 & 0x7FFF);
		}

		if (action == 16) {
			boolean var23 = tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], b, c, false, 0, 0, 0, 0, 0, 2);
			if (!var23) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], b, c, false, 0, 0, 1, 1, 0, 2);
			}

			crossX = JavaMouseProvider.mouseClickX;
			crossY = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;

			// OPOBJU
			out.p1Enc(235);
			out.p2(mapBuildBaseZ + c);
			out.p2_alt2(field555);
			out.p2_alt1(mapBuildBaseX + b);
			out.p4(field502);
			out.p2_alt1(a);
			out.p2_alt1(field557);
		}

		if (action == 1001) {
			interactWithLoc(b, c, a);

			// OPLOC5
			out.p1Enc(56);
			out.p2(mapBuildBaseX + b);
			out.p2_alt1(a >> 14 & 0x7FFF);
			out.p2_alt2(mapBuildBaseZ + c);
		}

		if (action == 26) {
			closeModal();
		}

		if (action == 37) {
			// OPHELD5
			out.p1Enc(19);
			out.p2(a);
			out.p4(c);
			out.p2_alt2(b);

			selectedCycle = 0;
			selectedArea = IfType.get(c);
			selectedItem = b;
		}

		if (action == 57 || action == 1007) {
			ifButtonX(a, c, b, menuSubject[arg0]);
		}

		if (action == 44) {
			ClientPlayer var26 = players[a];
			if (var26 != null) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var26.routeX[0], var26.routeZ[0], false, 0, 0, 1, 1, 0, 2);

				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;

				// OPPLAYER1
				out.p1Enc(246);
				out.p2(a);
			}
		}

		if (action == 22) {
			boolean var27 = tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], b, c, false, 0, 0, 0, 0, 0, 2);
			if (!var27) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], b, c, false, 0, 0, 1, 1, 0, 2);
			}

			crossX = JavaMouseProvider.mouseClickX;
			crossY = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;

			// OPOBJ5
			out.p1Enc(77);
			out.p2(mapBuildBaseX + b);
			out.p2_alt2(mapBuildBaseZ + c);
			out.p2_alt3(a);
		}

		if (action == 24) {
			IfType var29 = IfType.get(c);

			boolean var30 = true;
			if (var29.clientCode > 0) {
				var30 = clientButton(var29);
			}
			if (var30) {
				// IF_BUTTON
				out.p1Enc(155);
				out.p4(c);
			}
		}

		if (action == 9) {
			ClientNpc var31 = npcs[a];
			if (var31 != null) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var31.routeX[0], var31.routeZ[0], false, 0, 0, 1, 1, 0, 2);

				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;

				// OPNPC1
				out.p1Enc(84);
				out.p2_alt3(a);
			}
		}

		if (action == 49) {
			ClientPlayer var32 = players[a];
			if (var32 != null) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var32.routeX[0], var32.routeZ[0], false, 0, 0, 1, 1, 0, 2);

				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;

				// OPPLAYER6
				out.p1Enc(111);
				out.p2_alt3(a);
			}
		}

		if (action == 25) {
			IfType var33 = IfType.get(c, b);
			if (var33 != null) {
				endTargetMode();

				// todo: inlined method (minimenuEnterTargetMode?)
				int var34 = ServerActive.targetMask(getActive(var33));
				IfType var35 = IfType.get(c, b);
				if (var35 != null && var35.ontargetenter != null) {
					HookReq req = new HookReq();
					req.component = var35;
					req.onop = var35.ontargetenter;
					ScriptRunner.executeScript(req);
				}
				targetMode = true;
				targetCom = c;
				targetSub = b;
				targetMask = var34;
				componentUpdated(var35);

				useMode = 0;

				// todo: inlined method (getComponentTargetVerb?)
				String var37;
				if (ServerActive.targetMask(getActive(var33)) == 0) {
					var37 = null;
				} else if (var33.targetVerb == null || var33.targetVerb.trim().length() == 0) {
					var37 = null;
				} else {
					var37 = var33.targetVerb;
				}

				targetVerb = var37;
				if (targetVerb == null) {
					targetVerb = "Null";
				}

				if (var33.v3) {
					targetOp = var33.opbase + StringConstants.TAG_COLOUR(16777215);
				} else {
					targetOp = StringConstants.TAG_COLOUR(65280) + var33.targetText + StringConstants.TAG_COLOUR(16777215);
				}
			}

			return;
		}

		if (action == 42) {
			// INV_BUTTON4
			out.p1Enc(186);
			out.p2(b);
			out.p4(c);
			out.p2(a);

			selectedCycle = 0;
			selectedArea = IfType.get(c);
			selectedItem = b;
		}

		if (action == 10) {
			ClientNpc var38 = npcs[a];
			if (var38 != null) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var38.routeX[0], var38.routeZ[0], false, 0, 0, 1, 1, 0, 2);

				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;

				// OPNPC2
				out.p1Enc(13);
				out.p2_alt2(a);
			}
		}

		if (action == 34) {
			// OPHELD2
			out.p1Enc(179);
			out.p2_alt3(b);
			out.p2_alt2(a);
			out.p4_alt1(c);

			selectedCycle = 0;
			selectedArea = IfType.get(c);
			selectedItem = b;
		}

		if (action == 43) {
			// INV_BUTTON5
			out.p1Enc(40);
			out.p2_alt1(a);
			out.p4_alt1(c);
			out.p2_alt2(b);

			selectedCycle = 0;
			selectedArea = IfType.get(c);
			selectedItem = b;
		}

		if (action == 1003) {
			crossX = JavaMouseProvider.mouseClickX;
			crossY = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;

			ClientNpc var39 = npcs[a];
			if (var39 != null) {
				NpcType var40 = var39.type;
				if (var40.multinpc != null) {
					var40 = var40.getMultiNpc();
				}
				if (var40 != null) {
					// OPNPCE
					out.p1Enc(52);
					out.p2(var40.index);
				}
			}
		}
		if (action == 13) {
			ClientNpc var41 = npcs[a];
			if (var41 != null) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var41.routeX[0], var41.routeZ[0], false, 0, 0, 1, 1, 0, 2);

				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;

				// OPNPC5
				out.p1Enc(88);
				out.p2(a);
			}
		}

		if (action == 11) {
			ClientNpc var42 = npcs[a];
			if (var42 != null) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var42.routeX[0], var42.routeZ[0], false, 0, 0, 1, 1, 0, 2);

				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;

				// OPNPC3
				out.p1Enc(67);
				out.p2_alt1(a);
			}
		}

		if (action == 17) {
			boolean var43 = tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], b, c, false, 0, 0, 0, 0, 0, 2);
			if (!var43) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], b, c, false, 0, 0, 1, 1, 0, 2);
			}

			crossX = JavaMouseProvider.mouseClickX;
			crossY = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;

			// OPOBJT
			out.p1Enc(81);
			out.p2_alt3(a);
			out.p2(mapBuildBaseZ + c);
			out.p4_alt3(targetCom);
			out.p2_alt2(mapBuildBaseX + b);
			out.p2_alt2(targetSub);
		}

		if (action == 3) {
			interactWithLoc(b, c, a);

			// OPLOC1
			out.p1Enc(73);
			out.p2_alt2(a >> 14 & 0x7FFF);
			out.p2(mapBuildBaseX + b);
			out.p2(mapBuildBaseZ + c);
		}

		if (action == 38) {
			endTargetMode();

			IfType var45 = IfType.get(c);
			useMode = 1;
			field557 = b;
			field502 = c;
			field555 = a;
			componentUpdated(var45);

			field2078 = StringConstants.TAG_COLOUR(16748608) + ObjType.list(a).name + StringConstants.TAG_COLOUR(16777215);
			if (field2078 == null) {
				field2078 = "null";
			}

			return;
		}

		if (action == 58) {
			// IF_BUTTONT
			out.p1Enc(251);
			out.p2_alt2(targetSub);
			out.p2_alt2(b);
			out.p4(targetCom);
			out.p4_alt2(c);
		}

		if (action == 30) {
			if (resumedPauseButton == null) {
				// RESUME_PAUSEBUTTON
				out.p1Enc(242);
				out.p2_alt2(b);
				out.p4(c);

				resumedPauseButton = IfType.get(c, b);
				componentUpdated(resumedPauseButton);
			}
		}

		if (action == 23) {
			world.updateMousePicking(minusedlevel, b, c);
		}

		if (action == 4) {
			interactWithLoc(b, c, a);

			// OPLOC2
			out.p1Enc(90);
			out.p2_alt3(mapBuildBaseZ + c);
			out.p2_alt3(mapBuildBaseX + b);
			out.p2_alt2(a >> 14 & 0x7FFF);
		}

		if (action == 36) {
			// OPHELD4
			out.p1Enc(220);
			out.p4_alt3(c);
			out.p2_alt2(b);
			out.p2_alt1(a);

			selectedCycle = 0;
			selectedArea = IfType.get(c);
			selectedItem = b;
		}

		if (action == 19) {
			boolean var46 = tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], b, c, false, 0, 0, 0, 0, 0, 2);
			if (!var46) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], b, c, false, 0, 0, 1, 1, 0, 2);
			}

			crossX = JavaMouseProvider.mouseClickX;
			crossY = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;

			// OPOBJ2
			out.p1Enc(177);
			out.p2(mapBuildBaseZ + c);
			out.p2_alt3(a);
			out.p2(mapBuildBaseX + b);
		}

		if (action == 40) {
			// INV_BUTTON2
			out.p1Enc(202);
			out.p2_alt1(a);
			out.p4_alt2(c);
			out.p2_alt1(b);

			selectedCycle = 0;
			selectedArea = IfType.get(c);
			selectedItem = b;
		}

		if (action == 1005) {
			IfType var48 = IfType.get(c);
			if (var48 == null || var48.linkObjCount[b] < 100000) {
				out.p1Enc(49);
				out.p2_alt1(a);
			} else {
				addChat(0, "", var48.linkObjCount[b] + " x " + ObjType.list(a).name);
			}

			selectedCycle = 0;
			selectedArea = IfType.get(c);
			selectedItem = b;
		}

		if (action == 7) {
			ClientNpc var49 = npcs[a];
			if (var49 != null) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var49.routeX[0], var49.routeZ[0], false, 0, 0, 1, 1, 0, 2);

				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 2;
				crossCycle = 0;

				// OPNPCU
				out.p1Enc(106);
				out.p2_alt2(field557);
				out.p4(field502);
				out.p2_alt1(a);
				out.p2_alt3(field555);
			}
		}

		if (action == 21) {
			boolean var50 = tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], b, c, false, 0, 0, 0, 0, 0, 2);
			if (!var50) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], b, c, false, 0, 0, 1, 1, 0, 2);
			}

			crossX = JavaMouseProvider.mouseClickX;
			crossY = JavaMouseProvider.mouseClickY;
			crossMode = 2;
			crossCycle = 0;

			// OPOBJ4
			out.p1Enc(139);
			out.p2_alt1(mapBuildBaseZ + c);
			out.p2_alt1(mapBuildBaseX + b);
			out.p2_alt3(a);
		}

		if (action == 39) {
			// INV_BUTTON1
			out.p1Enc(21);
			out.p2(b);
			out.p4_alt2(c);
			out.p2_alt1(a);

			selectedCycle = 0;
			selectedArea = IfType.get(c);
			selectedItem = b;
		}

		if (useMode != 0) {
			useMode = 0;
			componentUpdated(IfType.get(field502));
		}

		if (targetMode) {
			endTargetMode();
		}

		if (selectedArea != null && selectedCycle == 0) {
			componentUpdated(selectedArea);
		}
	}

	// jag::oldscape::Client::OpPlayer
	@ObfuscatedName("ao.ec(ILjava/lang/String;I)V")
	public static void opPlayer(int arg0, String arg1) {
		String var2 = JString.toDisplayName(arg1);
		String var3 = JString.fromBase37Upper(JString.toBase37(var2));
		if (var3 == null) {
			var3 = "";
		}
		String var5 = var3;

		boolean found = false;
		for (int i = 0; i < playerCount; i++) {
			ClientPlayer player = players[playerIds[i]];
			if (player != null && player.name != null && player.name.equalsIgnoreCase(var5)) {
				tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], player.routeX[0], player.routeZ[0], false, 0, 0, 1, 1, 0, 2);

				if (arg0 == 1) {
					// OPPLAYER1
					out.p1Enc(246);
					out.p2(playerIds[i]);
				} else if (arg0 == 4) {
					// OPPLAYER4
					out.p1Enc(78);
					out.p2(playerIds[i]);
				} else if (arg0 == 6) {
					// OPPLAYER6
					out.p1Enc(111);
					out.p2_alt3(playerIds[i]);
				} else if (arg0 == 7) {
					// OPPLAYER7
					out.p1Enc(119);
					out.p2_alt3(playerIds[i]);
				}

				found = true;
				break;
			}
		}
		if (!found) {
			addChat(0, "", Text.UNABLETOFIND + var5);
		}
	}

	// jag::oldscape::minimenu::Minimenu::EndTargetMode
	@ObfuscatedName("ba.eo(B)V")
	public static void endTargetMode() {
		if (!targetMode) {
			return;
		}

		IfType var0 = IfType.get(targetCom, targetSub);
		if (var0 != null && var0.ontargetleave != null) {
			HookReq req = new HookReq();
			req.component = var0;
			req.onop = var0.ontargetleave;
			ScriptRunner.executeScript(req);
		}

		targetMode = false;
		componentUpdated(var0);
	}

	// jag::oldscape::Client::IfButtonX
	@ObfuscatedName("bd.eu(IIILjava/lang/String;I)V")
	public static void ifButtonX(int arg0, int arg1, int arg2, String arg3) {
		IfType var4 = IfType.get(arg1, arg2);
		if (var4 == null) {
			return;
		}
		if (var4.onop != null) {
			HookReq var5 = new HookReq();
			var5.component = var4;
			var5.opindex = arg0;
			var5.opbase = arg3;
			var5.onop = var4.onop;
			ScriptRunner.executeScript(var5);
		}
		boolean var6 = true;
		if (var4.clientCode > 0) {
			var6 = clientButton(var4);
		}
		if (!var6) {
			return;
		}
		int var7 = getActive(var4);
		int var8 = arg0 - 1;

		boolean var9 = (var7 >> var8 + 1 & 0x1) != 0;
		if (var9) {
			if (arg0 == 1) {
				// IF_BUTTON1
				out.p1Enc(63);
				out.p4(arg1);
				out.p2(arg2);
			} else if (arg0 == 2) {
				// IF_BUTTON2
				out.p1Enc(87);
				out.p4(arg1);
				out.p2(arg2);
			} else if (arg0 == 3) {
				// IF_BUTTON3
				out.p1Enc(238);
				out.p4(arg1);
				out.p2(arg2);
			} else if (arg0 == 4) {
				// IF_BUTTON4
				out.p1Enc(240);
				out.p4(arg1);
				out.p2(arg2);
			} else if (arg0 == 5) {
				// IF_BUTTON5
				out.p1Enc(153);
				out.p4(arg1);
				out.p2(arg2);
			} else if (arg0 == 6) {
				// IF_BUTTON6
				out.p1Enc(232);
				out.p4(arg1);
				out.p2(arg2);
			} else if (arg0 == 7) {
				// IF_BUTTON7
				out.p1Enc(168);
				out.p4(arg1);
				out.p2(arg2);
			} else if (arg0 == 8) {
				// IF_BUTTON8
				out.p1Enc(239);
				out.p4(arg1);
				out.p2(arg2);
			} else if (arg0 == 9) {
				// IF_BUTTON9
				out.p1Enc(254);
				out.p4(arg1);
				out.p2(arg2);
			} else if (arg0 == 10) {
				// IF_BUTTON10
				out.p1Enc(169);
				out.p4(arg1);
				out.p2(arg2);
			}
		}
	}

	@ObfuscatedName("d.fd(Ljava/lang/String;Ljava/lang/String;IIIII)V")
	public static void addMenuOption(String verb, String subject, int action, int a, int b, int c) {
		if (isMenuOpen || menuNumEntries >= 500) {
			return;
		}

		menuVerb[menuNumEntries] = verb;
		menuSubject[menuNumEntries] = subject;
		menuAction[menuNumEntries] = action;
		menuParamA[menuNumEntries] = a;
		menuParamB[menuNumEntries] = b;
		menuParamC[menuNumEntries] = c;
		menuNumEntries++;
	}

	// jag::oldscape::minimenu::Minimenu::GetLine
	@ObfuscatedName("cq.fb(IS)Ljava/lang/String;")
	public static String getLine(int arg0) {
		return menuSubject[arg0].length() > 0 ? menuVerb[arg0] + Text.MINISEPARATOR + menuSubject[arg0] : menuVerb[arg0];
	}

	// jag::oldscape::minimenu::Minimenu::AddNpcOptions
	@ObfuscatedName("z.fc(Lem;IIII)V")
	public static void addNpcOptions(NpcType arg0, int arg1, int arg2, int arg3) {
		if (menuNumEntries >= 400) {
			return;
		}

		if (arg0.multinpc != null) {
			arg0 = arg0.getMultiNpc();
		}

		if (arg0 == null || !arg0.active) {
			return;
		}

		String var4 = arg0.name;
		if (arg0.vislevel != 0) {
			int var6 = arg0.vislevel;
			int var7 = localPlayer.combatLevel;
			int var8 = var7 - var6;
			String var9;
			if (var8 < -9) {
				var9 = StringConstants.TAG_COLOUR(16711680);
			} else if (var8 < -6) {
				var9 = StringConstants.TAG_COLOUR(16723968);
			} else if (var8 < -3) {
				var9 = StringConstants.TAG_COLOUR(16740352);
			} else if (var8 < 0) {
				var9 = StringConstants.TAG_COLOUR(16756736);
			} else if (var8 > 9) {
				var9 = StringConstants.TAG_COLOUR(65280);
			} else if (var8 > 6) {
				var9 = StringConstants.TAG_COLOUR(4259584);
			} else if (var8 > 3) {
				var9 = StringConstants.TAG_COLOUR(8453888);
			} else if (var8 > 0) {
				var9 = StringConstants.TAG_COLOUR(12648192);
			} else {
				var9 = StringConstants.TAG_COLOUR(16776960);
			}
			var4 = var4 + var9 + " " + StringConstants.OPEN_BRACKET + Text.LEVEL + arg0.vislevel + StringConstants.CLOSE_BRACKET;
		}

		if (useMode == 1) {
			addMenuOption(Text.USE, field2078 + " " + StringConstants.TAG_ARROW + " " + StringConstants.TAG_COLOUR(16776960) + var4, 7, arg1, arg2, arg3);
		} else if (targetMode) {
			if ((targetMask & 0x2) == 2) {
				addMenuOption(targetVerb, targetOp + " " + StringConstants.TAG_ARROW + " " + StringConstants.TAG_COLOUR(16776960) + var4, 8, arg1, arg2, arg3);
			}
		} else {
			String[] op = arg0.op;
			if (field2001) {
				op = method726(op);
			}

			if (op != null) {
				for (int var11 = 4; var11 >= 0; var11--) {
					if (op[var11] == null || op[var11].equalsIgnoreCase(Text.ATTACK)) {
						continue;
					}

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

					addMenuOption(op[var11], StringConstants.TAG_COLOUR(16776960) + var4, var12, arg1, arg2, arg3);
				}
			}

			if (op != null) {
				for (int var13 = 4; var13 >= 0; var13--) {
					if (op[var13] == null || !op[var13].equalsIgnoreCase(Text.ATTACK)) {
						continue;
					}

					short var14 = 0;
					if (arg0.vislevel > localPlayer.combatLevel) {
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

					addMenuOption(op[var13], StringConstants.TAG_COLOUR(16776960) + var4, var15, arg1, arg2, arg3);
				}
			}

			addMenuOption(Text.EXAMINE, StringConstants.TAG_COLOUR(16776960) + var4, 1003, arg1, arg2, arg3);
		}
	}

	// jag::oldscape::minimenu::Minimenu::AddPlayerOptions
	@ObfuscatedName("cr.fe(Lfi;IIII)V")
	public static void addPlayerOptions(ClientPlayer player, int arg1, int arg2, int arg3) {
		if (localPlayer == player || menuNumEntries >= 400) {
			return;
		}

		String var9;
		if (player.skillLevel == 0) {
			String var4 = player.name;
			int var5 = player.combatLevel;
			int var6 = localPlayer.combatLevel;
			int var7 = var6 - var5;
			String var8;
			if (var7 < -9) {
				var8 = StringConstants.TAG_COLOUR(16711680);
			} else if (var7 < -6) {
				var8 = StringConstants.TAG_COLOUR(16723968);
			} else if (var7 < -3) {
				var8 = StringConstants.TAG_COLOUR(16740352);
			} else if (var7 < 0) {
				var8 = StringConstants.TAG_COLOUR(16756736);
			} else if (var7 > 9) {
				var8 = StringConstants.TAG_COLOUR(65280);
			} else if (var7 > 6) {
				var8 = StringConstants.TAG_COLOUR(4259584);
			} else if (var7 > 3) {
				var8 = StringConstants.TAG_COLOUR(8453888);
			} else if (var7 > 0) {
				var8 = StringConstants.TAG_COLOUR(12648192);
			} else {
				var8 = StringConstants.TAG_COLOUR(16776960);
			}
			var9 = var4 + var8 + " " + StringConstants.OPEN_BRACKET + Text.LEVEL + player.combatLevel + StringConstants.CLOSE_BRACKET;
		} else {
			var9 = player.name + " " + StringConstants.OPEN_BRACKET + Text.SKILL + player.skillLevel + StringConstants.CLOSE_BRACKET;
		}

		if (useMode == 1) {
			addMenuOption(Text.USE, field2078 + " " + StringConstants.TAG_ARROW + " " + StringConstants.TAG_COLOUR(16777215) + var9, 14, arg1, arg2, arg3);
		} else if (targetMode) {
			if ((targetMask & 0x8) == 8) {
				addMenuOption(targetVerb, targetOp + " " + StringConstants.TAG_ARROW + " " + StringConstants.TAG_COLOUR(16777215) + var9, 15, arg1, arg2, arg3);
			}
		} else {
			for (int i = 7; i >= 0; i--) {
				if (playerOp[i] == null) {
					continue;
				}

				short priority = 0;
				if (playerOp[i].equalsIgnoreCase(Text.ATTACK)) {
					if (player.combatLevel > localPlayer.combatLevel) {
						priority = 2000;
					}

					if (localPlayer.team != 0 && player.team != 0) {
						if (localPlayer.team == player.team) {
							priority = 2000;
						} else {
							priority = 0;
						}
					}
				} else if (playerOpPriority[i]) {
					priority = 2000;
				}

				int var13 = MENUACTION_PLAYER[i] + priority;
				addMenuOption(playerOp[i], StringConstants.TAG_COLOUR(16777215) + var9, var13, arg1, arg2, arg3);
			}
		}

		for (int var14 = 0; var14 < menuNumEntries; var14++) {
			if (menuAction[var14] == 23) {
				menuSubject[var14] = StringConstants.TAG_COLOUR(16777215) + var9;
				break;
			}
		}
	}

	// jag::oldscape::Client::DrawInterface
	@ObfuscatedName("fg.fj(IIIIIIIII)V")
	public static void drawInterface(int id, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		if (IfType.openInterface(id)) {
			field1516 = null;
			drawLayer(IfType.list[id], -1, arg1, arg2, arg3, arg4, arg5, arg6, arg7);

			if (field1516 != null) {
				drawLayer(field1516, 0xabcdabcd, arg1, arg2, arg3, arg4, field44, field2106, arg7);
				field1516 = null;
			}
		} else if (arg7 == -1) {
			for (int i = 0; i < 100; i++) {
				componentRedrawRequested1[i] = true;
			}
		} else {
			componentRedrawRequested1[arg7] = true;
		}
	}

	// jag::oldscape::Client::DrawLayer
	@ObfuscatedName("g.fv([Leg;IIIIIIIIB)V")
	public static void drawLayer(IfType[] children, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
		Pix2D.setClipping(arg2, arg3, arg4, arg5);
		Pix3D.setRenderClipping();

		for (int i = 0; i < children.length; i++) {
			IfType com = children[i];
			if (com == null || (com.layerid != arg1 && (arg1 != 0xabcdabcd || dragComponent != com))) {
				continue;
			}

			int var11;
			if (arg8 == -1) {
				componentDrawX[componentDrawCount] = com.renderx + arg6;
				componentDrawY[componentDrawCount] = com.rendery + arg7;
				componentDrawWidth[componentDrawCount] = com.renderwidth;
				componentDrawHeight[componentDrawCount] = com.renderheight;
				var11 = ++componentDrawCount - 1;
			} else {
				var11 = arg8;
			}

			com.field1898 = var11;
			com.drawTime = loopCycle;

			if (com.v3 && hide(com)) {
				continue;
			}

			if (com.clientCode > 0) {
				clientComponent(com);
			}

			int var12 = com.renderx + arg6;
			int var13 = com.rendery + arg7;
			int var14 = com.trans;

			if (dragComponent == com) {
				if (arg1 != 0xabcdabcd && !com.draggablebehavior) {
					field1516 = children;
					field44 = arg6;
					field2106 = arg7;
					continue;
				}

				if (dragAlive && dragParentFound) {
					int var15 = JavaMouseProvider.mouseX;
					int var16 = JavaMouseProvider.mouseY;

					int var17 = var15 - dragPickupX;
					int var18 = var16 - dragPickupY;

					if (var17 < dragParentX) {
						var17 = dragParentX;
					}

					if (com.renderwidth + var17 > dragParentX + dragParent.renderwidth) {
						var17 = dragParentX + dragParent.renderwidth - com.renderwidth;
					}

					if (var18 < dragParentY) {
						var18 = dragParentY;
					}

					if (com.renderheight + var18 > dragParentY + dragParent.renderheight) {
						var18 = dragParentY + dragParent.renderheight - com.renderheight;
					}

					var12 = var17;
					var13 = var18;
				}

				if (!com.draggablebehavior) {
					var14 = 128;
				}
			}

			int var19;
			int var20;
			int var21;
			int var22;
			if (com.type == 2) {
				var19 = arg2;
				var20 = arg3;
				var21 = arg4;
				var22 = arg5;
			} else if (com.type == 9) {
				int var23 = var12;
				int var24 = var13;
				int var25 = com.renderwidth + var12;
				int var26 = com.renderheight + var13;
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
				int var29 = com.renderwidth + var12;
				int var30 = com.renderheight + var13;
				var19 = var12 > arg2 ? var12 : arg2;
				var20 = var13 > arg3 ? var13 : arg3;
				var21 = var29 < arg4 ? var29 : arg4;
				var22 = var30 < arg5 ? var30 : arg5;
			}

			if (com.v3 && (var19 >= var21 || var20 >= var22)) {
				continue;
			}

			if (com.clientCode != 0) {
				if (com.clientCode == 1337) {
					minimenuMouseOverX = var12;
					minimenuMouseOverY = var13;
					gameDrawMain(var12, var13, com.renderwidth, com.renderheight);
					Pix2D.setClipping(arg2, arg3, arg4, arg5);
					continue;
				}

				if (com.clientCode == 1338) {
					minimapDraw(var12, var13, var11);
					Pix2D.setClipping(arg2, arg3, arg4, arg5);
					continue;
				}
			}

			int var127 = JavaMouseProvider.mouseX;
			int var128 = JavaMouseProvider.mouseY;

			if (!isMenuOpen && var127 >= var19 && var128 >= var20 && var127 < var21 && var128 < var22) {
				imethod35(com, var127 - var12, var128 - var13);
			}

			if (com.type == 0) {
				if (!com.v3 && hide(com) && field37 != com) {
					continue;
				}

				if (!com.v3) {
					if (com.scrollY > com.scrollHeight - com.renderheight) {
						com.scrollY = com.scrollHeight - com.renderheight;
					}

					if (com.scrollY < 0) {
						com.scrollY = 0;
					}
				}

				drawLayer(children, com.parentlayer, var19, var20, var21, var22, var12 - com.scrollX, var13 - com.scrollY, var11);

				if (com.subcomponents != null) {
					drawLayer(com.subcomponents, com.parentlayer, var19, var20, var21, var22, var12 - com.scrollX, var13 - com.scrollY, var11);
				}

				SubInterface var164 = (SubInterface) subinterfaces.get((long) com.parentlayer);
				if (var164 != null) {
					if (var164.type == 0 && JavaMouseProvider.mouseX >= var19 && JavaMouseProvider.mouseY >= var20 && JavaMouseProvider.mouseX < var21 && JavaMouseProvider.mouseY < var22 && !isMenuOpen && !field2092) {
						menuVerb[0] = Text.CANCEL;
						menuSubject[0] = "";
						menuAction[0] = 1006;
						menuNumEntries = 1;
					}

					drawInterface(var164.id, var19, var20, var21, var22, var12, var13, var11);
				}

				Pix2D.setClipping(arg2, arg3, arg4, arg5);
				Pix3D.setRenderClipping();
			}

			if (!componentDrawSomething2[var11] && componentDrawMode <= 1) {
				continue;
			}

			if (com.type == 0 && !com.v3 && com.scrollHeight > com.renderheight) {
				drawScrollbar(var13, com.renderwidth + var12, com.scrollY, com.renderheight, com.scrollHeight);
			} else if (com.type == 1) {
				// no-op
			} else if (com.type == 2) {
				int var171 = 0;
				for (int var172 = 0; var172 < com.renderheight; var172++) {
					for (int var173 = 0; var173 < com.renderwidth; var173++) {
						int var174 = (com.marginX + 32) * var173 + var12;
						int var175 = (com.marginY + 32) * var172 + var13;
						if (var171 < 20) {
							var174 += com.invBackgroundX[var171];
							var175 += com.invBackgroundY[var171];
						}
						if (com.linkObjType[var171] > 0) {
							int var178 = com.linkObjType[var171] - 1;
							if (var174 + 32 > arg2 && var174 < arg4 && var175 + 32 > arg3 && var175 < arg5 || objDragInterface == com && hoveredSlot == var171) {
								Pix32 var179;
								if (useMode == 1 && field557 == var171 && field502 == com.parentlayer) {
									var179 = ObjType.getSprite(var178, com.linkObjCount[var171], 2, 0, false);
								} else {
									var179 = ObjType.getSprite(var178, com.linkObjCount[var171], 1, 3153952, false);
								}
								if (var179 == null) {
									componentUpdated(com);
								} else if (objDragInterface == com && hoveredSlot == var171) {
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
									var179.transPlotSprite(var174 + var180, var175 + var181, 128);
									if (arg1 != -1) {
										IfType var182 = children[arg1 & 0xFFFF];
										if (var175 + var181 < Pix2D.clipMinY && var182.scrollY > 0) {
											int var183 = worldUpdateNum * (Pix2D.clipMinY - var175 - var181) / 3;
											if (var183 > worldUpdateNum * 10) {
												var183 = worldUpdateNum * 10;
											}
											if (var183 > var182.scrollY) {
												var183 = var182.scrollY;
											}
											var182.scrollY -= var183;
											objGrabY += var183;
											componentUpdated(var182);
										}
										if (var175 + var181 + 32 > Pix2D.clipMaxY && var182.scrollY < var182.scrollHeight - var182.renderheight) {
											int var184 = worldUpdateNum * (var175 + var181 + 32 - Pix2D.clipMaxY) / 3;
											if (var184 > worldUpdateNum * 10) {
												var184 = worldUpdateNum * 10;
											}
											if (var184 > var182.scrollHeight - var182.renderheight - var182.scrollY) {
												var184 = var182.scrollHeight - var182.renderheight - var182.scrollY;
											}
											var182.scrollY += var184;
											objGrabY -= var184;
											componentUpdated(var182);
										}
									}
								} else if (selectedArea == com && selectedItem == var171) {
									var179.transPlotSprite(var174, var175, 128);
								} else {
									var179.plotSprite(var174, var175);
								}
							}
						} else if (com.invBackground != null && var171 < 20) {
							Pix32 var185 = com.getInvBackground(var171);
							if (var185 != null) {
								var185.plotSprite(var174, var175);
							} else if (IfType.loadingAsset) {
								componentUpdated(com);
							}
						}
						var171++;
					}
				}
			} else if (com.type == 3) {
				int var186;
				if (getIfActive(com)) {
					var186 = com.colour2;
					if (field37 == com && com.colour2Over != 0) {
						var186 = com.colour2Over;
					}
				} else {
					var186 = com.colour;
					if (field37 == com && com.colourOver != 0) {
						var186 = com.colourOver;
					}
				}
				if (var14 == 0) {
					if (com.fill) {
						Pix2D.fillRect(var12, var13, com.renderwidth, com.renderheight, var186);
					} else {
						Pix2D.drawRect(var12, var13, com.renderwidth, com.renderheight, var186);
					}
				} else if (com.fill) {
					Pix2D.fillRectTrans(var12, var13, com.renderwidth, com.renderheight, var186, 256 - (var14 & 0xFF));
				} else {
					Pix2D.drawRectTrans(var12, var13, com.renderwidth, com.renderheight, var186, 256 - (var14 & 0xFF));
				}
			} else if (com.type == 4) {
				SoftwareFont var187 = com.getFont();
				if (var187 != null) {
					String var188 = com.text;
					int var189;
					if (getIfActive(com)) {
						var189 = com.colour2;
						if (field37 == com && com.colour2Over != 0) {
							var189 = com.colour2Over;
						}
						if (com.text2.length() > 0) {
							var188 = com.text2;
						}
					} else {
						var189 = com.colour;
						if (field37 == com && com.colourOver != 0) {
							var189 = com.colourOver;
						}
					}
					if (com.v3 && com.invobject != -1) {
						ObjType var190 = ObjType.list(com.invobject);
						var188 = var190.name;
						if (var188 == null) {
							var188 = "null";
						}
						if ((var190.stackable == 1 || com.invcount != 1) && com.invcount != -1) {
							var188 = StringConstants.TAG_COLOUR(0xff9040) + var188 + StringConstants.TAG_COLOURCLOSE + " " + 'x' + niceNumber(com.invcount);
						}
					}
					if (resumedPauseButton == com) {
						Text var10000 = null;
						var188 = Text.PLEASEWAIT;
						var189 = com.colour;
					}
					if (!com.v3) {
						var188 = substituteVars(var188, com);
					}
					var187.drawStringMultiline(var188, var12, var13, com.renderwidth, com.renderheight, var189, com.shadowed ? 0 : -1, com.halign, com.field1834, com.field1832);
				} else if (IfType.loadingAsset) {
					componentUpdated(com);
				}
			} else if (com.type == 5) {
				if (com.v3) {
					Pix32 var192;
					if (com.invobject == -1) {
						var192 = com.getGraphic(false);
					} else {
						var192 = ObjType.getSprite(com.invobject, com.invcount, com.outline, com.graphicshadow, false);
					}
					if (var192 != null) {
						int var193 = var192.owi;
						int var194 = var192.ohi;
						if (com.tiling) {
							Pix2D.setSubClipping(var12, var13, com.renderwidth + var12, com.renderheight + var13);
							int var195 = (com.renderwidth + (var193 - 1)) / var193;
							int var196 = (com.renderheight + (var194 - 1)) / var194;
							for (int var197 = 0; var197 < var195; var197++) {
								for (int var198 = 0; var198 < var196; var198++) {
									if (com.angle2d != 0) {
										var192.method2685(var193 / 2 + var193 * var197 + var12, var194 / 2 + var194 * var198 + var13, com.angle2d, 4096);
									} else if (var14 == 0) {
										var192.plotSprite(var193 * var197 + var12, var194 * var198 + var13);
									} else {
										var192.transPlotSprite(var193 * var197 + var12, var194 * var198 + var13, 256 - (var14 & 0xFF));
									}
								}
							}
							Pix2D.setClipping(arg2, arg3, arg4, arg5);
						} else {
							int var199 = com.renderwidth * 4096 / var193;
							if (com.angle2d != 0) {
								var192.method2685(com.renderwidth / 2 + var12, com.renderheight / 2 + var13, com.angle2d, var199);
							} else if (var14 != 0) {
								var192.method2678(var12, var13, com.renderwidth, com.renderheight, 256 - (var14 & 0xFF));
							} else if (com.renderwidth == var193 && com.renderheight == var194) {
								var192.plotSprite(var12, var13);
							} else {
								var192.method2664(var12, var13, com.renderwidth, com.renderheight);
							}
						}
					} else if (IfType.loadingAsset) {
						componentUpdated(com);
					}
				} else {
					Pix32 var191 = com.getGraphic(getIfActive(com));
					if (var191 != null) {
						var191.plotSprite(var12, var13);
					} else if (IfType.loadingAsset) {
						componentUpdated(com);
					}
				}
			} else if (com.type == 6) {
				boolean var200 = getIfActive(com);
				int var201;
				if (var200) {
					var201 = com.model2Anim;
				} else {
					var201 = com.modelAnim;
				}
				ModelLit var202 = null;
				int var203 = 0;
				if (com.invobject != -1) {
					ObjType var204 = ObjType.list(com.invobject);
					if (var204 != null) {
						ObjType var205 = var204.getStackSizeAlt(com.invcount);
						var202 = var205.getModelLit(1);
						if (var202 != null) {
							var202.calcBoundingCylinder();
							var203 = var202.minY / 2;
						} else {
							componentUpdated(com);
						}
					}
				} else if (com.modelType == 5) {
					if (com.modelId == 0) {
						var202 = selfModel.getTempModel(null, -1, null, -1);
					} else {
						var202 = localPlayer.getTempModel();
					}
				} else if (var201 == -1) {
					var202 = com.getTempModel(null, -1, var200, localPlayer.model);
					if (var202 == null && IfType.loadingAsset) {
						componentUpdated(com);
					}
				} else {
					SeqType var206 = SeqType.list(var201);
					var202 = com.getTempModel(var206, com.animFrame, var200, localPlayer.model);
					if (var202 == null && IfType.loadingAsset) {
						componentUpdated(com);
					}
				}
				Pix3D.setOrigin(com.renderwidth / 2 + var12, com.renderheight / 2 + var13);
				int var207 = com.modelZoom * Pix3D.sinTable[com.modelXan] >> 16;
				int var208 = com.modelZoom * Pix3D.cosTable[com.modelXan] >> 16;
				if (var202 != null) {
					if (com.v3) {
						var202.calcBoundingCylinder();
						if (com.modelOrthographic) {
							var202.objRenderOrthog(0, com.modelYan, com.modelZan, com.modelXan, com.xof, com.yof + var203 + var207, com.yof + var208, com.modelZoom);
						} else {
							var202.objRender(0, com.modelYan, com.modelZan, com.modelXan, com.xof, com.yof + var203 + var207, com.yof + var208);
						}
					} else {
						var202.objRender(0, com.modelYan, 0, com.modelXan, 0, var207, var208);
					}
				}
				Pix3D.resetOrigin();
			} else if (com.type == 7) {
				SoftwareFont var209 = com.getFont();
				if (var209 == null) {
					if (IfType.loadingAsset) {
						componentUpdated(com);
					}
					continue;
				}
				int var210 = 0;
				for (int var211 = 0; var211 < com.renderheight; var211++) {
					for (int var212 = 0; var212 < com.renderwidth; var212++) {
						if (com.linkObjType[var210] > 0) {
							ObjType var213 = ObjType.list(com.linkObjType[var210] - 1);
							String var214;
							if (var213.stackable != 1 && com.linkObjCount[var210] == 1) {
								var214 = StringConstants.TAG_COLOUR(16748608) + var213.name + StringConstants.TAG_COLOURCLOSE;
							} else {
								var214 = StringConstants.TAG_COLOUR(16748608) + var213.name + StringConstants.TAG_COLOURCLOSE + " " + 'x' + niceNumber(com.linkObjCount[var210]);
							}
							int var215 = (com.marginX + 115) * var212 + var12;
							int var216 = (com.marginY + 12) * var211 + var13;
							if (com.halign == 0) {
								var209.drawString(var214, var215, var216, com.colour, com.shadowed ? 0 : -1);
							} else if (com.halign == 1) {
								var209.centreString(var214, com.renderwidth / 2 + var215, var216, com.colour, com.shadowed ? 0 : -1);
							} else {
								var209.drawStringRight(var214, com.renderwidth + var215 - 1, var216, com.colour, com.shadowed ? 0 : -1);
							}
						}
						var210++;
					}
				}
			} else if (com.type == 8 && field654 == com && field2076 == field1995) {
				int var217 = 0;
				int var218 = 0;
				SoftwareFont var219 = fontPlain12;
				String var220 = com.text;
				String var221 = substituteVars(var220, com);
				while (var221.length() > 0) {
					int var222 = var221.indexOf(StringConstants.TAG_BREAK);
					String var223;
					if (var222 == -1) {
						var223 = var221;
						var221 = "";
					} else {
						var223 = var221.substring(0, var222);
						var221 = var221.substring(var222 + 4);
					}
					int var224 = var219.stringWid(var223);
					if (var224 > var217) {
						var217 = var224;
					}
					var218 += var219.field2550 + 1;
				}
				var217 += 6;
				var218 += 7;
				int var225 = com.renderwidth + var12 - 5 - var217;
				int var226 = com.renderheight + var13 + 5;
				if (var225 < var12 + 5) {
					var225 = var12 + 5;
				}
				if (var217 + var225 > arg4) {
					var225 = arg4 - var217;
				}
				if (var218 + var226 > arg5) {
					var226 = arg5 - var218;
				}
				Pix2D.fillRect(var225, var226, var217, var218, 16777120);
				Pix2D.drawRect(var225, var226, var217, var218, 0);
				String var227 = com.text;
				int var228 = var219.field2550 + var226 + 2;
				String var229 = substituteVars(var227, com);
				while (var229.length() > 0) {
					int var230 = var229.indexOf(StringConstants.TAG_BREAK);
					String var231;
					if (var230 == -1) {
						var231 = var229;
						var229 = "";
					} else {
						var231 = var229.substring(0, var230);
						var229 = var229.substring(var230 + 4);
					}
					var219.drawString(var231, var225 + 3, var228, 0, -1);
					var228 += var219.field2550 + 1;
				}
			} else if (com.type == 9) {
				if (com.lineWidth == 1) {
					Pix2D.method2618(var12, var13, com.renderwidth + var12, com.renderheight + var13, com.colour);
				} else {
					// todo: inlined method? (DrawLineWithStrokeWidth)
					int var232 = com.renderwidth >= 0 ? com.renderwidth : -com.renderwidth;
					int var233 = com.renderheight >= 0 ? com.renderheight : -com.renderheight;
					int var234 = var232;
					if (var232 < var233) {
						var234 = var233;
					}
					if (var234 != 0) {
						int var235 = (com.renderwidth << 16) / var234;
						int var236 = (com.renderheight << 16) / var234;
						if (var236 <= var235) {
							var235 = -var235;
						} else {
							var236 = -var236;
						}
						int var237 = com.lineWidth * var236 >> 17;
						int var238 = com.lineWidth * var236 + 1 >> 17;
						int var239 = com.lineWidth * var235 >> 17;
						int var240 = com.lineWidth * var235 + 1 >> 17;
						int var241 = var12 + var237;
						int var242 = var12 - var238;
						int var243 = com.renderwidth + var12 - var238;
						int var244 = com.renderwidth + var12 + var237;
						int var245 = var13 + var239;
						int var246 = var13 - var240;
						int var247 = com.renderheight + var13 - var240;
						int var248 = com.renderheight + var13 + var239;

						Pix3D.setHClip(var241, var242, var243);
						Pix3D.flatTriangle(var245, var246, var247, var241, var242, var243, com.colour);

						Pix3D.setHClip(var241, var243, var244);
						Pix3D.flatTriangle(var245, var247, var248, var241, var243, var244, com.colour);
					}
				}
			}
		}
	}

	// jag::oldscape::Client::SubstituteVars
	@ObfuscatedName("ez.fu(Ljava/lang/String;Leg;S)Ljava/lang/String;")
	public static String substituteVars(String text, IfType com) {
		if (text.indexOf("%") != -1) {
			for (int i = 1; i <= 5; i++) {
				while (true) {
					int var3 = text.indexOf("%" + i);
					if (var3 == -1) {
						break;
					}

					text = text.substring(0, var3) + inf(getIfVar(com, i - 1)) + text.substring(var3 + 2);
				}
			}

			while (true) {
				int var4 = text.indexOf("%dns");
				if (var4 == -1) {
					break;
				}

				String var5 = "";
				if (field170 != null) {
					var5 = StringUtil.formatIPv4(field170.intArg);
					if (field170.result != null) {
						var5 = (String) field170.result;
					}
				}

				text = text.substring(0, var4) + var5 + text.substring(var4 + 4);
			}
		}

		return text;
	}

	// jag::oldscape::Client::NiceNumber
	@ObfuscatedName("dy.fr(IB)Ljava/lang/String;")
	public static String niceNumber(int cost) {
		String value = Integer.toString(cost);
		for (int i = value.length() - 3; i > 0; i -= 3) {
			value = value.substring(0, i) + StringConstants.COMMA + value.substring(i);
		}
		if (value.length() > 9) {
			return " " + StringConstants.TAG_COLOUR(0xff80) + value.substring(0, value.length() - 8) + Text.MILLION + " " + StringConstants.OPEN_BRACKET + value + StringConstants.CLOSE_BRACKET + StringConstants.TAG_COLOURCLOSE;
		} else if (value.length() > 6) {
			return " " + StringConstants.TAG_COLOUR(0xffffff) + value.substring(0, value.length() - 4) + Text.THOUSAND + " " + StringConstants.OPEN_BRACKET + value + StringConstants.CLOSE_BRACKET + StringConstants.TAG_COLOURCLOSE;
		} else {
			return " " + StringConstants.TAG_COLOUR(0xffff00) + value + StringConstants.TAG_COLOURCLOSE;
		}
	}

	// jag::oldscape::Client::DoScrollbar
	@ObfuscatedName("q.fl(Leg;IIIIIII)V")
	public static void doScrollbar(IfType com, int left, int top, int height, int scrollableHeight, int x, int y) {
		if (scrollGrabbed) {
			scrollInputPadding = 32;
		} else {
			scrollInputPadding = 0;
		}

		scrollGrabbed = false;

		if (JavaMouseProvider.mouseButton != 0) {
			if (x >= left && x < left + 16 && y >= top && y < top + 16) {
				com.scrollY -= 4;
				componentUpdated(com);
			} else if (x >= left && x < left + 16 && y >= top + height - 16 && y < top + height) {
				com.scrollY += 4;
				componentUpdated(com);
			} else if (x >= left - scrollInputPadding && x < scrollInputPadding + left + 16 && y >= top + 16 && y < top + height - 16) {
				int gripSize = (height - 32) * height / scrollableHeight;
				if (gripSize < 8) {
					gripSize = 8;
				}

				int var8 = y - top - 16 - gripSize / 2;
				int var9 = height - 32 - gripSize;

				com.scrollY = (scrollableHeight - height) * var8 / var9;
				componentUpdated(com);
				scrollGrabbed = true;
			}
		}

		if (mouseWheelRotation != 0) {
			int width = com.renderwidth;
			if (x >= left - width && y >= top && x < left + 16 && y <= top + height) {
				com.scrollY += mouseWheelRotation * 45;
				componentUpdated(com);
			}
		}
	}

	// jag::oldscape::Client::Inf
	@ObfuscatedName("ck.fk(II)Ljava/lang/String;")
	public static String inf(int arg0) {
		return arg0 < 999999999 ? Integer.toString(arg0) : "*";
	}

	// jag::oldscape::Client::GetIfActive
	@ObfuscatedName("n.fa(Leg;I)Z")
	public static boolean getIfActive(IfType com) {
		if (com.scriptComparator == null) {
			return false;
		}

		for (int i = 0; i < com.scriptComparator.length; i++) {
			int value = getIfVar(com, i);
			int operand = com.scriptOperand[i];

			if (com.scriptComparator[i] == 2) {
				if (value >= operand) {
					return false;
				}
			} else if (com.scriptComparator[i] == 3) {
				if (value <= operand) {
					return false;
				}
			} else if (com.scriptComparator[i] == 4) {
				if (value == operand) {
					return false;
				}
			} else if (value != operand) {
				return false;
			}
		}

		return true;
	}

	// jag::oldscape::Client::GetIfVar
	@ObfuscatedName("ba.fq(Leg;IB)I")
	public static int getIfVar(IfType com, int scriptId) {
		if (com.scripts == null || scriptId >= com.scripts.length) {
			return -2;
		}

		try {
			int[] script = com.scripts[scriptId];

			int acc = 0;
			int pc = 0;
			byte arithmetic = 0;

			while (true) {
				int opcode = script[pc++];
				int register = 0;
				byte nextArithmetic = 0;

				if (opcode == 0) {
					return acc;
				}

				if (opcode == 1) {
					register = skillLevel[script[pc++]];
				} else if (opcode == 2) {
					register = skillBaseLevel[script[pc++]];
				} else if (opcode == 3) {
					register = skillExperience[script[pc++]];
				} else if (opcode == 4) {
					int var9 = script[pc++] << 16;
					int var10 = var9 + script[pc++];
					IfType var11 = IfType.get(var10);
					int var12 = script[pc++];
					if (var12 != -1 && (!ObjType.list(var12).members || memServer)) {
						for (int var13 = 0; var13 < var11.linkObjType.length; var13++) {
							if (var12 + 1 == var11.linkObjType[var13]) {
								register += var11.linkObjCount[var13];
							}
						}
					}
				} else if (opcode == 5) {
					register = VarCache.var[script[pc++]];
				} else if (opcode == 6) {
					register = PlayerSkillXPTable.levelExperience[skillBaseLevel[script[pc++]] - 1];
				} else if (opcode == 7) {
					register = VarCache.var[script[pc++]] * 100 / 46875;
				} else if (opcode == 8) {
					register = localPlayer.combatLevel;
				} else if (opcode == 9) {
					for (int var14 = 0; var14 < 25; var14++) {
						if (PlayerSkillXPTable.enabled[var14]) {
							register += skillBaseLevel[var14];
						}
					}
				} else if (opcode == 10) {
					int var15 = script[pc++] << 16;
					int var16 = var15 + script[pc++];
					IfType var17 = IfType.get(var16);
					int var18 = script[pc++];
					if (var18 != -1 && (!ObjType.list(var18).members || memServer)) {
						for (int var19 = 0; var19 < var17.linkObjType.length; var19++) {
							if (var18 + 1 == var17.linkObjType[var19]) {
								register = 999999999;
								break;
							}
						}
					}
				} else if (opcode == 11) {
					register = runEnergy;
				} else if (opcode == 12) {
					register = runWeight;
				} else if (opcode == 13) {
					int var20 = VarCache.var[script[pc++]];
					int var21 = script[pc++];
					register = (var20 & 0x1 << var21) == 0 ? 0 : 1;
				} else if (opcode == 14) {
					int var22 = script[pc++];
					register = VarCache.getVarbit(var22);
				} else if (opcode == 15) {
					nextArithmetic = 1;
				} else if (opcode == 16) {
					nextArithmetic = 2;
				} else if (opcode == 17) {
					nextArithmetic = 3;
				} else if (opcode == 18) {
					register = (localPlayer.x >> 7) + mapBuildBaseX;
				} else if (opcode == 19) {
					register = (localPlayer.z >> 7) + mapBuildBaseZ;
				} else if (opcode == 20) {
					register = script[pc++];
				}

				if (nextArithmetic == 0) {
					if (arithmetic == 0) {
						acc += register;
					} else if (arithmetic == 1) {
						acc -= register;
					} else if (arithmetic == 2 && register != 0) {
						acc /= register;
					} else if (arithmetic == 3) {
						acc *= register;
					}

					arithmetic = 0;
				} else {
					arithmetic = nextArithmetic;
				}
			}
		} catch (Exception ex) {
			return -1;
		}
	}

	// jag::oldscape::Client::LoopInterface
	@ObfuscatedName("cz.ft(IIIIIIIS)V")
	public static void loopInterface(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		if (IfType.openInterface(arg0)) {
			loopLayer(IfType.list[arg0], -1, arg1, arg2, arg3, arg4, arg5, arg6);
		}
	}

	// jag::oldscape::Client::LoopLayer
	@ObfuscatedName("eg.fx([Leg;IIIIIIIB)V")
	public static void loopLayer(IfType[] arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
		for (int var8 = 0; var8 < arg0.length; var8++) {
			IfType var9 = arg0[var8];
			if (
				var9 == null ||
				(var9.v3 && var9.type != 0 && !var9.hashook && getActive(var9) == 0 && dragParent != var9) ||
				var9.layerid != arg1 ||
				(var9.v3 && hide(var9))
			) {
				continue;
			}

			int var10 = var9.renderx + arg6;
			int var11 = var9.rendery + arg7;
			int var12;
			int var13;
			int var14;
			int var15;
			if (var9.type == 2) {
				var12 = arg2;
				var13 = arg3;
				var14 = arg4;
				var15 = arg5;
			} else if (var9.type == 9) {
				int var16 = var10;
				int var17 = var11;
				int var18 = var9.renderwidth + var10;
				int var19 = var9.renderheight + var11;
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
				int var22 = var9.renderwidth + var10;
				int var23 = var9.renderheight + var11;
				var12 = var10 > arg2 ? var10 : arg2;
				var13 = var11 > arg3 ? var11 : arg3;
				var14 = var22 < arg4 ? var22 : arg4;
				var15 = var23 < arg5 ? var23 : arg5;
			}

			if (dragComponent == var9) {
				dragging = true;
				dragCurrentX = var10;
				dragCurrentY = var11;
			}

			if (var9.v3 && (var12 >= var14 || var13 >= var15)) {
				continue;
			}

			if (var9.clientCode == 1337) {
				componentUpdated(var9);
			} else if (var9.clientCode == 1338) {
				minimapLoop(var10, var11);
			} else {
				if (var9.type == 0) {
					if (!var9.v3 && hide(var9) && field37 != var9) {
						continue;
					}

					loopLayer(arg0, var9.parentlayer, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
					if (var9.subcomponents != null) {
						loopLayer(var9.subcomponents, var9.parentlayer, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
					}

					SubInterface var24 = (SubInterface) subinterfaces.get((long) var9.parentlayer);
					if (var24 != null) {
						loopInterface(var24.id, var12, var13, var14, var15, var10, var11);
					}
				}

				if (var9.v3) {
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
						dragTryPickup(var9, JavaMouseProvider.mouseClickX - var10, JavaMouseProvider.mouseClickY - var11);
					}

					if (dragComponent != null && dragComponent != var9 && var25) {
						int var28 = getActive(var9);
						boolean var29 = (var28 >> 20 & 0x1) != 0;
						if (var29) {
							dropComponent = var9;
						}
					}

					if (dragParent == var9) {
						dragParentFound = true;
						dragParentX = var10;
						dragParentY = var11;
					}

					if (var9.hashook) {
						if (var25 && mouseWheelRotation != 0 && var9.onscrollwheel != null) {
							HookReq req = new HookReq();
							req.component = var9;
							req.mouseY = mouseWheelRotation;
							req.onop = var9.onscrollwheel;
							hookRequests.push(req);
						}

						if (dragComponent != null || objDragInterface != null || isMenuOpen) {
							var27 = false;
							var26 = false;
							var25 = false;
						}

						if (!var9.field1871 && var27) {
							var9.field1871 = true;

							if (var9.onclick != null) {
								HookReq req = new HookReq();
								req.component = var9;
								req.mouseX = JavaMouseProvider.mouseClickX - var10;
								req.mouseY = JavaMouseProvider.mouseClickY - var11;
								req.onop = var9.onclick;
								hookRequests.push(req);
							}
						}

						if (var9.field1871 && var26 && var9.onclickrepeat != null) {
							HookReq req = new HookReq();
							req.component = var9;
							req.mouseX = JavaMouseProvider.mouseX - var10;
							req.mouseY = JavaMouseProvider.mouseY - var11;
							req.onop = var9.onclickrepeat;
							hookRequests.push(req);
						}

						if (var9.field1871 && !var26) {
							var9.field1871 = false;

							if (var9.onrelease != null) {
								HookReq req = new HookReq();
								req.component = var9;
								req.mouseX = JavaMouseProvider.mouseX - var10;
								req.mouseY = JavaMouseProvider.mouseY - var11;
								req.onop = var9.onrelease;
								hookRequestsMouseStop.push(req);
							}
						}

						if (var26 && var9.onhold != null) {
							HookReq req = new HookReq();
							req.component = var9;
							req.mouseX = JavaMouseProvider.mouseX - var10;
							req.mouseY = JavaMouseProvider.mouseY - var11;
							req.onop = var9.onhold;
							hookRequests.push(req);
						}

						if (!var9.field1892 && var25) {
							var9.field1892 = true;

							if (var9.onmouseover != null) {
								HookReq req = new HookReq();
								req.component = var9;
								req.mouseX = JavaMouseProvider.mouseX - var10;
								req.mouseY = JavaMouseProvider.mouseY - var11;
								req.onop = var9.onmouseover;
								hookRequests.push(req);
							}
						}

						if (var9.field1892 && var25 && var9.onmouserepeat != null) {
							HookReq req = new HookReq();
							req.component = var9;
							req.mouseX = JavaMouseProvider.mouseX - var10;
							req.mouseY = JavaMouseProvider.mouseY - var11;
							req.onop = var9.onmouserepeat;
							hookRequests.push(req);
						}

						if (var9.field1892 && !var25) {
							var9.field1892 = false;

							if (var9.onmouseleave != null) {
								HookReq req = new HookReq();
								req.component = var9;
								req.mouseX = JavaMouseProvider.mouseX - var10;
								req.mouseY = JavaMouseProvider.mouseY - var11;
								req.onop = var9.onmouseleave;
								hookRequestsMouseStop.push(req);
							}
						}

						if (var9.ontimer != null) {
							HookReq req = new HookReq();
							req.component = var9;
							req.onop = var9.ontimer;
							hookRequestsTimer.push(req);
						}

						if (var9.onvartransmit != null && field2084 > var9.field1895) {
							if (var9.onvartransmitlist == null || field2084 - var9.field1895 > 32) {
								HookReq req = new HookReq();
								req.component = var9;
								req.onop = var9.onvartransmit;
								hookRequests.push(req);
							} else {
								label383:
								for (int var39 = var9.field1895; var39 < field2084; var39++) {
									int var40 = field2110[var39 & 0x1F];
									for (int var41 = 0; var41 < var9.onvartransmitlist.length; var41++) {
										if (var9.onvartransmitlist[var41] == var40) {
											HookReq req = new HookReq();
											req.component = var9;
											req.onop = var9.onvartransmit;
											hookRequests.push(req);
											break label383;
										}
									}
								}
							}

							var9.field1895 = field2084;
						}

						if (var9.oninvtransmit != null && field2050 > var9.field1879) {
							if (var9.oninvtransmitlist == null || field2050 - var9.field1879 > 32) {
								HookReq req = new HookReq();
								req.component = var9;
								req.onop = var9.oninvtransmit;
								hookRequests.push(req);
							} else {
								label363:
								for (int var44 = var9.field1879; var44 < field2050; var44++) {
									int var45 = field2112[var44 & 0x1F];
									for (int var46 = 0; var46 < var9.oninvtransmitlist.length; var46++) {
										if (var9.oninvtransmitlist[var46] == var45) {
											HookReq req = new HookReq();
											req.component = var9;
											req.onop = var9.oninvtransmit;
											hookRequests.push(req);
											break label363;
										}
									}
								}
							}

							var9.field1879 = field2050;
						}

						if (var9.onstattransmit != null && field1982 > var9.field1897) {
							if (var9.onstattransmitlist == null || field1982 - var9.field1897 > 32) {
								HookReq req = new HookReq();
								req.component = var9;
								req.onop = var9.onstattransmit;
								hookRequests.push(req);
							} else {
								label343:
								for (int var49 = var9.field1897; var49 < field1982; var49++) {
									int var50 = field1999[var49 & 0x1F];
									for (int var51 = 0; var51 < var9.onstattransmitlist.length; var51++) {
										if (var9.onstattransmitlist[var51] == var50) {
											HookReq req = new HookReq();
											req.component = var9;
											req.onop = var9.onstattransmit;
											hookRequests.push(req);
											break label343;
										}
									}
								}
							}

							var9.field1897 = field1982;
						}

						if (chatTransmitNum > var9.field1894 && var9.field1872 != null) {
							HookReq req = new HookReq();
							req.component = var9;
							req.onop = var9.field1872;
							hookRequests.push(req);
						}

						if (friendSystemUpdateNum > var9.field1894 && var9.field1877 != null) {
							HookReq req = new HookReq();
							req.component = var9;
							req.onop = var9.field1877;
							hookRequests.push(req);
						}

						if (friendChatUpdateNum > var9.field1894 && var9.field1875 != null) {
							HookReq req = new HookReq();
							req.component = var9;
							req.onop = var9.field1875;
							hookRequests.push(req);
						}

						if (field2119 > var9.field1894 && var9.field1777 != null) {
							HookReq req = new HookReq();
							req.component = var9;
							req.onop = var9.field1777;
							hookRequests.push(req);
						}

						var9.field1894 = interfaceUpdateNum;

						if (var9.field1873 != null) {
							for (int var58 = 0; var58 < field2151; var58++) {
								HookReq req = new HookReq();
								req.component = var9;
								req.keyCode = keypressKeycodes[var58];
								req.keyChar = keypressKeychars[var58];
								req.onop = var9.field1873;
								hookRequests.push(req);
							}
						}
					}
				}

				if (!var9.v3) {
					if (dragComponent != null || objDragInterface != null || isMenuOpen) {
						return;
					}

					if ((var9.overlayer >= 0 || var9.colourOver != 0) && JavaMouseProvider.mouseX >= var12 && JavaMouseProvider.mouseY >= var13 && JavaMouseProvider.mouseX < var14 && JavaMouseProvider.mouseY < var15) {
						if (var9.overlayer >= 0) {
							field37 = arg0[var9.overlayer];
						} else {
							field37 = var9;
						}
					}

					if (var9.type == 8 && JavaMouseProvider.mouseX >= var12 && JavaMouseProvider.mouseY >= var13 && JavaMouseProvider.mouseX < var14 && JavaMouseProvider.mouseY < var15) {
						field654 = var9;
					}

					if (var9.scrollHeight > var9.renderheight) {
						doScrollbar(var9, var9.renderwidth + var10, var11, var9.renderheight, var9.scrollHeight, JavaMouseProvider.mouseX, JavaMouseProvider.mouseY);
					}
				}
			}
		}
	}

	// jag::oldscape::Client::RunHookImmediate
	@ObfuscatedName("ai.fs(III)V")
	public static void runHookImmediate(int arg0, int arg1) {
		if (IfType.openInterface(arg0)) {
			runHookLayer(IfType.list[arg0], arg1);
		}
	}

	// jag::oldscape::Client::RunHookLayer
	@ObfuscatedName("ao.fh([Leg;IB)V")
	public static void runHookLayer(IfType[] children, int arg1) {
		for (int i = 0; i < children.length; i++) {
			IfType com = children[i];
			if (com == null) {
				continue;
			}

			if (com.type == 0) {
				if (com.subcomponents != null) {
					runHookLayer(com.subcomponents, arg1);
				}

				SubInterface sub = (SubInterface) subinterfaces.get((long) com.parentlayer);
				if (sub != null) {
					runHookImmediate(sub.id, arg1);
				}
			}

			if (arg1 == 0 && com.ondialogabort != null) {
				HookReq req = new HookReq();
				req.component = com;
				req.onop = com.ondialogabort;
				ScriptRunner.executeScript(req);
			}

			if (arg1 == 1 && com.onsubchange != null) {
				if (com.subid >= 0) {
					IfType var6 = IfType.get(com.parentlayer);
					if (var6 == null || var6.subcomponents == null || com.subid >= var6.subcomponents.length || var6.subcomponents[com.subid] != com) {
						continue;
					}
				}

				HookReq req = new HookReq();
				req.component = com;
				req.onop = com.onsubchange;
				ScriptRunner.executeScript(req);
			}
		}
	}

	// jag::oldscape::Client::DragTryPickup
	@ObfuscatedName("ch.ff(Leg;IIB)V")
	public static void dragTryPickup(IfType arg0, int arg1, int arg2) {
		if (dragComponent != null || isMenuOpen || (arg0 == null || getDragLayer(arg0) == null)) {
			return;
		}

		dragComponent = arg0;
		dragParent = getDragLayer(arg0);
		dragPickupX = arg1;
		dragPickupY = arg2;
		dragTime = 0;
		dragAlive = false;
	}

	// jag::oldscape::Client::ComponentUpdated
	@ObfuscatedName("cq.fy(Leg;I)V")
	public static void componentUpdated(IfType arg0) {
		if (componentDrawTime == arg0.drawTime) {
			componentRedrawRequested1[arg0.field1898] = true;
		}
	}

	// jag::oldscape::Client::LegacyUpdated
	@ObfuscatedName("g.fn(B)V")
	public static void legacyUpdated() {
		for (SubInterface sub = (SubInterface) subinterfaces.first(); sub != null; sub = (SubInterface) subinterfaces.next()) {
			int id = sub.id;

			if (IfType.openInterface(id)) {
				boolean newFormat = true;

				IfType[] children = IfType.list[id];
				for (int i = 0; i < children.length; i++) {
					if (children[i] != null) {
						newFormat = children[i].v3;
						break;
					}
				}

				if (!newFormat) {
					int key = (int) sub.key;

					IfType com = IfType.get(key);
					if (com != null) {
						componentUpdated(com);
					}
				}
			}
		}
	}

	// jag::oldscape::Client::GetDragLayer
	@ObfuscatedName("bs.fz(Leg;I)Leg;")
	public static IfType getDragLayer(IfType arg0) {
		// todo: inlined method (ServerDraggable?)
		IfType var1 = arg0;
		int var2 = ServerActive.serverDraggable(getActive(arg0));
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
			var5 = arg0.draggable;
		}
		return var5;
	}

	@ObfuscatedName("ai.fw([Ljava/lang/String;B)[Ljava/lang/String;")
	public static String[] method726(String[] arg0) {
		String[] var1 = new String[5];
		for (int var2 = 0; var2 < 5; var2++) {
			var1[var2] = var2 + ": ";
			if (arg0 != null && arg0[var2] != null) {
				var1[var2] = var1[var2] + arg0[var2];
			}
		}
		return var1;
	}

	// jag::oldscape::Client::IfAnimReset
	@ObfuscatedName("n.fo(II)V")
	public static void ifAnimReset(int arg0) {
		if (!IfType.openInterface(arg0)) {
			return;
		}

		IfType[] var1 = IfType.list[arg0];
		for (int var2 = 0; var2 < var1.length; var2++) {
			IfType var3 = var1[var2];
			if (var3 != null) {
				var3.animFrame = 0;
				var3.animCycle = 0;
			}
		}
	}

	// jag::oldscape::Client::AnimateLayer
	@ObfuscatedName("cz.fm([Leg;IB)V")
	public static void animateLayer(IfType[] children, int layer) {
		for (int i = 0; i < children.length; i++) {
			IfType com = children[i];
			if (com == null || com.layerid != layer || (com.v3 && hide(com))) {
				continue;
			}

			if (com.type == 0) {
				if (!com.v3 && hide(com) && field37 != com) {
					continue;
				}

				animateLayer(children, com.parentlayer);

				if (com.subcomponents != null) {
					animateLayer(com.subcomponents, com.parentlayer);
				}

				SubInterface var4 = (SubInterface) subinterfaces.get(com.parentlayer);
				if (var4 != null) {
					animateInterface(var4.id);
				}
			}

			if (com.type == 6) {
				if (com.modelAnim != -1 || com.model2Anim != -1) {
					boolean var6 = getIfActive(com);
					int var7;
					if (var6) {
						var7 = com.model2Anim;
					} else {
						var7 = com.modelAnim;
					}
					if (var7 != -1) {
						SeqType var8 = SeqType.list(var7);

						com.animCycle += worldUpdateNum;

						while (com.animCycle > var8.delay[com.animFrame]) {
							com.animCycle -= var8.delay[com.animFrame];
							com.animFrame++;

							if (com.animFrame >= var8.frames.length) {
								com.animFrame -= var8.loops;

								if (com.animFrame < 0 || com.animFrame >= var8.frames.length) {
									com.animFrame = 0;
								}
							}

							componentUpdated(com);
						}
					}
				}

				if (com.field1827 != 0 && !com.v3) {
					int var9 = com.field1827 >> 16;
					int var10 = com.field1827 << 16 >> 16;
					int var11 = worldUpdateNum * var9;
					int var12 = worldUpdateNum * var10;

					com.modelXan = com.modelXan + var11 & 0x7FF;
					com.modelYan = com.modelYan + var12 & 0x7FF;

					componentUpdated(com);
				}
			}
		}
	}

	// jag::oldscape::Client::ClientVar
	@ObfuscatedName("bv.fi(II)V")
	public static void clientVar(int varp) {
		legacyUpdated();
		BgSound.recalculateMultilocs();

		int clientcode = VarpType.list(varp).clientcode;
		if (clientcode == 0) {
			return;
		}

		int value = VarCache.var[varp];
		if (clientcode == 1) {
			if (value == 1) {
				Pix3D.initColourTable(0.9D);
				((WorldTextureProvider) Pix3D.textureProvider).setBrightness(0.9D);
			} else if (value == 2) {
				Pix3D.initColourTable(0.8D);
				((WorldTextureProvider) Pix3D.textureProvider).setBrightness(0.8D);
			} else if (value == 3) {
				Pix3D.initColourTable(0.7D);
				((WorldTextureProvider) Pix3D.textureProvider).setBrightness(0.7D);
			} else if (value == 4) {
				Pix3D.initColourTable(0.6D);
				((WorldTextureProvider) Pix3D.textureProvider).setBrightness(0.6D);
			}

			ObjType.resetSpriteCache();
		} else if (clientcode == 3) {
			short volume = 0;
			if (value == 0) {
				volume = 255;
			} else if (value == 1) {
				volume = 192;
			} else if (value == 2) {
				volume = 128;
			} else if (value == 3) {
				volume = 64;
			} else if (value == 4) {
				volume = 0;
			}

			if (midiVolume != volume) {
				if (midiVolume == 0 && previousSong != -1) {
					MidiManager.method1125(songs, previousSong, 0, volume, false);
					field2189 = false;
				} else if (volume == 0) {
					MidiManager.stop();
					field2189 = false;
				} else {
					MidiManager.method105(volume);
				}

				midiVolume = volume;
			}
		} else if (clientcode == 4) {
			if (value == 0) {
				waveVolume = 127;
			} else if (value == 1) {
				waveVolume = 96;
			} else if (value == 2) {
				waveVolume = 64;
			} else if (value == 3) {
				waveVolume = 32;
			} else if (value == 4) {
				waveVolume = 0;
			}
		} else if (clientcode == 5) {
			oneMouseButton = value;
		} else if (clientcode == 6) {
			chatEffects = value;
		} else if (clientcode == 9) {
			bankArrangeMode = value;
		} else if (clientcode == 10) {
			if (value == 0) {
				ambientVolume = 127;
			} else if (value == 1) {
				ambientVolume = 96;
			} else if (value == 2) {
				ambientVolume = 64;
			} else if (value == 3) {
				ambientVolume = 32;
			} else if (value == 4) {
				ambientVolume = 0;
			}
		}
	}

	// jag::oldscape::Client::ClientComponent
	@ObfuscatedName("cy.ge(Leg;I)V")
	public static void clientComponent(IfType com) {
		int clientCode = com.clientCode;

		if (clientCode == 324) {
			if (genderButton1 == -1) {
				genderButton1 = com.graphic;
				genderButton2 = com.graphic2;
			}

			if (selfModel.gender) {
				com.graphic = genderButton1;
			} else {
				com.graphic = genderButton2;
			}
		} else if (clientCode == 325) {
			if (genderButton1 == -1) {
				genderButton1 = com.graphic;
				genderButton2 = com.graphic2;
			}

			if (selfModel.gender) {
				com.graphic = genderButton2;
			} else {
				com.graphic = genderButton1;
			}
		} else if (clientCode == 327) {
			com.modelXan = 150;
			com.modelYan = (int) (Math.sin((double) loopCycle / 40.0D) * 256.0D) & 0x7FF;
			com.modelType = 5;
			com.modelId = 0;
		} else if (clientCode == 328) {
			com.modelXan = 150;
			com.modelYan = (int) (Math.sin((double) loopCycle / 40.0D) * 256.0D) & 0x7FF;
			com.modelType = 5;
			com.modelId = 1;
		}
	}

	// jag::oldscape::Client::OpenSubinterface
	@ObfuscatedName("cz.gq(IIIB)Ldy;")
	public static SubInterface openSubInterface(int arg0, int arg1, int arg2) {
		SubInterface sub = new SubInterface();
		sub.id = arg1;
		sub.type = arg2;
		subinterfaces.put(sub, arg0);

		ifAnimReset(arg1);
		ScriptRunner.executeOnLoad(arg1);

		IfType var4 = IfType.get(arg0);
		if (var4 != null) {
			componentUpdated(var4);
		}

		if (resumedPauseButton != null) {
			componentUpdated(resumedPauseButton);
			resumedPauseButton = null;
		}

		isMenuOpen = false;
		menuNumEntries = 0;
		dirtyArea(menuX, menuY, menuWidth, menuHeight);

		if (toplevelinterface != -1) {
			runHookImmediate(toplevelinterface, 1);
		}

		return sub;
	}

	// jag::oldscape::Client::CloseSubinterface
	@ObfuscatedName("am.gr(Ldy;ZI)V")
	public static void closeSubInterface(SubInterface sub, boolean arg1) {
		int var2 = sub.id;
		int var3 = (int) sub.key;

		sub.unlink();

		if (arg1 && var2 != -1 && IfType.open[var2]) {
			IfType.interfaces.discardFiles(var2);

			if (IfType.list[var2] != null) {
				boolean var4 = true;
				for (int var5 = 0; var5 < IfType.list[var2].length; var5++) {
					if (IfType.list[var2][var5] != null) {
						if (IfType.list[var2][var5].type == 2) {
							var4 = false;
						} else {
							IfType.list[var2][var5] = null;
						}
					}
				}
				if (var4) {
					IfType.list[var2] = null;
				}

				IfType.open[var2] = false;
			}
		}

		purgeServerActive(var2);

		IfType com = IfType.get(var3);
		if (com != null) {
			componentUpdated(com);
		}

		isMenuOpen = false;
		menuNumEntries = 0;
		dirtyArea(menuX, menuY, menuWidth, menuHeight);

		if (toplevelinterface != -1) {
			runHookImmediate(toplevelinterface, 1);
		}
	}

	// jag::oldscape::Client::ClientButton
	@ObfuscatedName("es.gd(Leg;B)Z")
	public static boolean clientButton(IfType com) {
		int clientCode = com.clientCode;

		if (clientCode == 205) {
			logoutTimer = 250;
			return true;
		} else if (clientCode >= 300 && clientCode <= 313) {
			int var2 = (clientCode - 300) / 2;
			int var3 = clientCode & 0x1;
			selfModel.idkChangePart(var2, var3 == 1);
		} else if (clientCode >= 314 && clientCode <= 323) {
			int var4 = (clientCode - 314) / 2;
			int var5 = clientCode & 0x1;
			selfModel.idkChangeColour(var4, var5 == 1);
		} else if (clientCode == 324) {
			selfModel.idkChangeGender(false);
		} else if (clientCode == 325) {
			selfModel.idkChangeGender(true);
		} else if (clientCode == 326) {
			// IDK_SAVEDESIGN
			out.p1Enc(71);
			selfModel.idkSaveDesign(out);
			return true;
		}

		return false;
	}

	// jag::oldscape::minimap::Minimap::Draw
	@ObfuscatedName("ba.gh(IIII)V")
	public static void minimapDraw(int arg0, int arg1, int arg2) {
		flushAudio();
		Pix2D.setClipping(arg0, arg1, mapback.wi + arg0, mapback.hi + arg1);

		if (minimapState == 2 || minimapState == 5) {
			Pix2D.method2599(arg0 + 25, arg1 + 5, 0, minimapMaskLineOffsets, minimapMaskLineLengths);
		} else {
			int var3 = orbitCameraYaw + macroMinimapAngle & 0x7FF;
			int var4 = localPlayer.x / 32 + 48;
			int var5 = 464 - localPlayer.z / 32;
			minimap.scanlineRotatePlotSprite(arg0 + 25, arg1 + 5, 146, 151, var4, var5, var3, macroMinimapZoom + 256, minimapMaskLineOffsets, minimapMaskLineLengths);
			for (int var6 = 0; var6 < activeMapFunctionCount; var6++) {
				int var7 = activeMapFunctionX[var6] * 4 + 2 - localPlayer.x / 32;
				int var8 = activeMapFunctionZ[var6] * 4 + 2 - localPlayer.z / 32;
				drawOnMinimap(arg0, arg1, var7, var8, activeMapFunctions[var6]);
			}
			for (int var9 = 0; var9 < 104; var9++) {
				for (int var10 = 0; var10 < 104; var10++) {
					LinkList var11 = objStacks[minusedlevel][var9][var10];
					if (var11 != null) {
						int var12 = var9 * 4 + 2 - localPlayer.x / 32;
						int var13 = var10 * 4 + 2 - localPlayer.z / 32;
						drawOnMinimap(arg0, arg1, var12, var13, mapdots[0]);
					}
				}
			}
			for (int var14 = 0; var14 < npcCount; var14++) {
				ClientNpc var15 = npcs[npcIds[var14]];
				if (var15 != null && var15.ready()) {
					NpcType var16 = var15.type;
					if (var16 != null && var16.multinpc != null) {
						var16 = var16.getMultiNpc();
					}
					if (var16 != null && var16.minimap && var16.active) {
						int var17 = var15.x / 32 - localPlayer.x / 32;
						int var18 = var15.z / 32 - localPlayer.z / 32;
						drawOnMinimap(arg0, arg1, var17, var18, mapdots[1]);
					}
				}
			}
			for (int var19 = 0; var19 < playerCount; var19++) {
				ClientPlayer var20 = players[playerIds[var19]];
				if (var20 != null && var20.ready()) {
					int var21 = var20.x / 32 - localPlayer.x / 32;
					int var22 = var20.z / 32 - localPlayer.z / 32;
					boolean var23 = false;
					if (isFriend(var20.name)) {
						var23 = true;
					}
					boolean var24 = false;
					if (localPlayer.team != 0 && var20.team != 0 && localPlayer.team == var20.team) {
						var24 = true;
					}
					if (var23) {
						drawOnMinimap(arg0, arg1, var21, var22, mapdots[3]);
					} else if (var24) {
						drawOnMinimap(arg0, arg1, var21, var22, mapdots[4]);
					} else {
						drawOnMinimap(arg0, arg1, var21, var22, mapdots[2]);
					}
				}
			}
			if (hintType != 0 && loopCycle % 20 < 10) {
				if (hintType == 1 && hintNpc >= 0 && hintNpc < npcs.length) {
					ClientNpc var25 = npcs[hintNpc];
					if (var25 != null) {
						int var26 = var25.x / 32 - localPlayer.x / 32;
						int var27 = var25.z / 32 - localPlayer.z / 32;
						drawMinimapHint(arg0, arg1, var26, var27, mapmarker[1]);
					}
				}
				if (hintType == 2) {
					int var28 = hintTileX * 4 - mapBuildBaseX * 4 + 2 - localPlayer.x / 32;
					int var29 = hintTileZ * 4 - mapBuildBaseZ * 4 + 2 - localPlayer.z / 32;
					drawMinimapHint(arg0, arg1, var28, var29, mapmarker[1]);
				}
				if (hintType == 10 && hintPlayer >= 0 && hintPlayer < players.length) {
					ClientPlayer var30 = players[hintPlayer];
					if (var30 != null) {
						int var31 = var30.x / 32 - localPlayer.x / 32;
						int var32 = var30.z / 32 - localPlayer.z / 32;
						drawMinimapHint(arg0, arg1, var31, var32, mapmarker[1]);
					}
				}
			}
			if (minimapFlagX != 0) {
				int var33 = minimapFlagX * 4 + 2 - localPlayer.x / 32;
				int var34 = minimapFlagZ * 4 + 2 - localPlayer.z / 32;
				drawOnMinimap(arg0, arg1, var33, var34, mapmarker[0]);
			}
			Pix2D.fillRect(arg0 + 93 + 4, arg1 + 82 - 4, 3, 3, 16777215);
		}
		if (minimapState < 3) {
			compass.scanlineRotatePlotSprite(arg0, arg1, 33, 33, 25, 25, orbitCameraYaw, 256, compassMaskLineOffsets, compassMaskLineLengths);
		} else {
			Pix2D.method2599(arg0, arg1, 0, compassMaskLineOffsets, compassMaskLineLengths);
		}
		if (componentDrawSomething2[arg2]) {
			mapback.plotSprite(arg0, arg1);
		}
		componentRedrawRequested2[arg2] = true;
	}

	@ObfuscatedName("ak.gm(IIIILfq;B)V")
	public static void drawMinimapHint(int arg0, int arg1, int arg2, int arg3, Pix32 arg4) {
		int var5 = arg2 * arg2 + arg3 * arg3;
		if (var5 <= 4225 || var5 >= 90000) {
			drawOnMinimap(arg0, arg1, arg2, arg3, arg4);
			return;
		}
		int var6 = orbitCameraYaw + macroMinimapAngle & 0x7FF;
		int var7 = Pix3D.sinTable[var6];
		int var8 = Pix3D.cosTable[var6];
		int var9 = var7 * 256 / (macroMinimapZoom + 256);
		int var10 = var8 * 256 / (macroMinimapZoom + 256);
		int var11 = arg2 * var10 + arg3 * var9 >> 16;
		int var12 = arg3 * var10 - arg2 * var9 >> 16;
		double var13 = Math.atan2((double) var11, (double) var12);
		int var15 = (int) (Math.sin(var13) * 63.0D);
		int var16 = (int) (Math.cos(var13) * 57.0D);
		mapedge.rotatePlotSprite(arg0 + 94 + var15 + 4 - 10, arg1 + 83 - var16 - 20, 20, 20, 15, 15, var13, 256);
	}

	@ObfuscatedName("g.gw(IIIILfq;I)V")
	public static void drawOnMinimap(int arg0, int arg1, int arg2, int arg3, Pix32 arg4) {
		if (arg4 == null) {
			return;
		}
		int var5 = orbitCameraYaw + macroMinimapAngle & 0x7FF;
		int var6 = arg2 * arg2 + arg3 * arg3;
		if (var6 > 6400) {
			return;
		}
		int var7 = Pix3D.sinTable[var5];
		int var8 = Pix3D.cosTable[var5];
		int var9 = var7 * 256 / (macroMinimapZoom + 256);
		int var10 = var8 * 256 / (macroMinimapZoom + 256);
		int var11 = arg2 * var10 + arg3 * var9 >> 16;
		int var12 = arg3 * var10 - arg2 * var9 >> 16;
		if (var6 > 2500) {
			arg4.scanlinePlotSprite(mapback, arg0 + 94 + var11 - arg4.owi / 2 + 4, arg1 + 83 - var12 - arg4.ohi / 2 - 4);
		} else {
			arg4.plotSprite(arg0 + 94 + var11 - arg4.owi / 2 + 4, arg1 + 83 - var12 - arg4.ohi / 2 - 4);
		}
	}

	// jag::oldscape::Client::AddChat
	@ObfuscatedName("ao.gn(ILjava/lang/String;Ljava/lang/String;I)V")
	public static void addChat(int type, String sender, String message) {
		addChat(type, sender, message, null);
	}

	// jag::oldscape::Client::AddChat
	@ObfuscatedName("br.gj(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V")
	public static void addChat(int type, String sender, String message, String arg3) {
		for (int i = 99; i > 0; i--) {
			messageType[i] = messageType[i - 1];
			messageSender[i] = messageSender[i - 1];
			messageText[i] = messageText[i - 1];
			field2173[i] = field2173[i - 1];
		}

		messageType[0] = type;
		messageSender[0] = sender;
		messageText[0] = message;
		field2173[0] = arg3;

		chatHistoryLength++;
		chatTransmitNum = interfaceUpdateNum;
	}

	// jag::oldscape::FriendSystem::IsFriend
	@ObfuscatedName("bg.gk(Ljava/lang/String;B)Z")
	public static boolean isFriend(String arg0) {
		if (arg0 == null) {
			return false;
		}
		for (int var1 = 0; var1 < friendCount; var1++) {
			if (arg0.equalsIgnoreCase(friendList[var1].name)) {
				return true;
			}
		}
		if (arg0.equalsIgnoreCase(localPlayer.name)) {
			return true;
		} else {
			return false;
		}
	}

	// jag::oldscape::FriendSystem::IsIgnored
	@ObfuscatedName("bi.gx(Ljava/lang/String;I)Z")
	public static boolean isIgnored(String arg0) {
		if (arg0 == null) {
			return false;
		}
		for (int var1 = 0; var1 < ignoreCount; var1++) {
			IgnoreListEntry var2 = ignoreList[var1];
			if (arg0.equalsIgnoreCase(var2.name)) {
				return true;
			}
			if (arg0.equalsIgnoreCase(var2.displayName)) {
				return true;
			}
		}
		return false;
	}

	// jag::oldscape::FriendSystem::AddFriend
	@ObfuscatedName("ch.gl(Ljava/lang/String;I)V")
	public static void addFriend(String arg0) {
		if (arg0 == null) {
			return;
		}
		if (friendCount >= 200 && membersAccount != 1 || friendCount >= 200) {
			addChat(0, "", Text.FRIENDLISTFULL);
			return;
		}
		String var1 = DisplayNameTools.toBaseDisplayName(arg0, namespace);
		if (var1 == null) {
			return;
		}
		for (int var2 = 0; var2 < friendCount; var2++) {
			FriendListEntry var3 = friendList[var2];
			String var4 = DisplayNameTools.toBaseDisplayName(var3.name, namespace);
			if (var4 != null && var4.equals(var1)) {
				addChat(0, "", arg0 + Text.FRIENDLISTDUPE);
				return;
			}
			if (var3.field177 != null) {
				String var5 = DisplayNameTools.toBaseDisplayName(var3.field177, namespace);
				if (var5 != null && var5.equals(var1)) {
					addChat(0, "", arg0 + Text.FRIENDLISTDUPE);
					return;
				}
			}
		}
		for (int var6 = 0; var6 < ignoreCount; var6++) {
			IgnoreListEntry var7 = ignoreList[var6];
			String var8 = DisplayNameTools.toBaseDisplayName(var7.name, namespace);
			if (var8 != null && var8.equals(var1)) {
				addChat(0, "", Text.REMOVEIGNORE1 + arg0 + Text.REMOVEIGNORE2);
				return;
			}
			if (var7.displayName != null) {
				String var9 = DisplayNameTools.toBaseDisplayName(var7.displayName, namespace);
				if (var9 != null && var9.equals(var1)) {
					addChat(0, "", Text.REMOVEIGNORE1 + arg0 + Text.REMOVEIGNORE2);
					return;
				}
			}
		}
		if (DisplayNameTools.toBaseDisplayName(localPlayer.name, namespace).equals(var1)) {
			addChat(0, "", Text.FRIENDCANTADDSELF);
		} else {
			// FRIENDLIST_ADD
			out.p1Enc(203);
			out.p1(Packet.pjstrlen(arg0));
			out.pjstr(arg0);
		}
	}

	// jag::oldscape::FriendSystem::AddIgnore
	@ObfuscatedName("a.gz(Ljava/lang/String;ZS)V")
	public static void addIgnore(String arg0, boolean arg1) {
		if (arg0 == null) {
			return;
		}
		if (ignoreCount >= 100) {
			addChat(0, "", Text.IGNORELISTFULL);
			return;
		}
		String var2 = DisplayNameTools.toBaseDisplayName(arg0, namespace);
		if (var2 == null) {
			return;
		}
		for (int var3 = 0; var3 < ignoreCount; var3++) {
			IgnoreListEntry var4 = ignoreList[var3];
			String var5 = DisplayNameTools.toBaseDisplayName(var4.name, namespace);
			if (var5 != null && var5.equals(var2)) {
				addChat(0, "", arg0 + Text.IGNORELISTDUPE);
				return;
			}
			if (var4.displayName != null) {
				String var6 = DisplayNameTools.toBaseDisplayName(var4.displayName, namespace);
				if (var6 != null && var6.equals(var2)) {
					addChat(0, "", arg0 + Text.IGNORELISTDUPE);
					return;
				}
			}
		}
		for (int var7 = 0; var7 < friendCount; var7++) {
			FriendListEntry var8 = friendList[var7];
			String var9 = DisplayNameTools.toBaseDisplayName(var8.name, namespace);
			if (var9 != null && var9.equals(var2)) {
				addChat(0, "", Text.REMOVEFRIEND1 + arg0 + Text.REMOVEFRIEND2);
				return;
			}
			if (var8.field177 != null) {
				String var10 = DisplayNameTools.toBaseDisplayName(var8.field177, namespace);
				if (var10 != null && var10.equals(var2)) {
					addChat(0, "", Text.REMOVEFRIEND1 + arg0 + Text.REMOVEFRIEND2);
					return;
				}
			}
		}
		if (DisplayNameTools.toBaseDisplayName(localPlayer.name, namespace).equals(var2)) {
			addChat(0, "", Text.IGNORECANTADDSELF);
		} else {
			// IGNORELIST_ADD
			out.p1Enc(231);
			out.p1(Packet.pjstrlen(arg0));
			out.pjstr(arg0);
		}
	}

	// jag::oldscape::FriendSystem::DelFriend
	@ObfuscatedName("ao.gp(Ljava/lang/String;B)V")
	public static void delFriend(String arg0) {
		if (arg0 == null) {
			return;
		}
		String var1 = DisplayNameTools.toBaseDisplayName(arg0, namespace);
		if (var1 == null) {
			return;
		}
		for (int var2 = 0; var2 < friendCount; var2++) {
			FriendListEntry var3 = friendList[var2];
			String var4 = var3.name;
			String var5 = DisplayNameTools.toBaseDisplayName(var4, namespace);
			boolean var6;
			if (arg0 == null || var4 == null) {
				var6 = false;
			} else if (arg0.startsWith("#") || var4.startsWith("#")) {
				var6 = arg0.equals(var4);
			} else {
				var6 = var1.equals(var5);
			}
			if (var6) {
				friendCount--;
				for (int var7 = var2; var7 < friendCount; var7++) {
					friendList[var7] = friendList[var7 + 1];
				}
				friendSystemUpdateNum = interfaceUpdateNum;
				// FRIENDLIST_DEL
				out.p1Enc(41);
				out.p1(Packet.pjstrlen(arg0));
				out.pjstr(arg0);
				break;
			}
		}
	}

	// jag::oldscape::Client::FriendsChatJoinChat
	@ObfuscatedName("af.gf(Ljava/lang/String;I)V")
	public static void friendsChatJoinChat(String arg0) {
		if (arg0.equals("")) {
			return;
		}

		// CLAN_JOINCHAT_LEAVECHAT
		out.p1Enc(185);
		out.p1(Packet.pjstrlen(arg0));
		out.pjstr(arg0);
	}

	// jag::oldscape::Client::FriendsChatLeaveChat
	@ObfuscatedName("aa.gv(I)V")
	public static void friendsChatLeaveChat() {
		// CLAN_JOINCHAT_LEAVECHAT
		out.p1Enc(185);
		out.p1(0);
	}

	// jag::oldscape::Client::PurgeServerActive
	@ObfuscatedName("s.gt(II)V")
	public static void purgeServerActive(int comId) {
		for (ServerActive active = (ServerActive) serverActive.first(); active != null; active = (ServerActive) serverActive.next()) {
			if ((long) comId == (active.key >> 48 & 0xFFFFL)) {
				active.unlink();
			}
		}
	}

	// jag::oldscape::Client::GetActive
	@ObfuscatedName("dn.gg(Leg;B)I")
	public static int getActive(IfType com) {
		ServerActive active = (ServerActive) serverActive.get(((long) com.parentlayer << 32) + (long) com.subid);
		return active == null ? com.events : active.events;
	}

	// jag::oldscape::Client::Hide
	@ObfuscatedName("bo.gy(Leg;I)Z")
	public static boolean hide(IfType com) {
		if (field2092) {
			if (getActive(com) != 0) {
				return false;
			}

			if (com.type == 0) {
				return false;
			}
		}

		return com.hide;
	}

	@ObfuscatedName("ay.gu(Leg;II)Ljava/lang/String;")
	public static String method513(IfType com, int arg1) {
		int var2 = getActive(com);
		boolean var3 = (var2 >> arg1 + 1 & 0x1) != 0;

		if (!var3 && com.onop == null) {
			return null;
		} else if (com.ops == null || com.ops.length <= arg1 || com.ops[arg1] == null || com.ops[arg1].trim().length() == 0) {
			return null;
		} else {
			return com.ops[arg1];
		}
	}

	// jag::oldscape::Client::TargetVerb
	@ObfuscatedName("ap.gb(Leg;I)Ljava/lang/String;")
	public static String targetVerb(IfType com) {
		if (ServerActive.targetMask(getActive(com)) == 0) {
			return null;
		} else if (com.targetVerb == null || com.targetVerb.trim().length() == 0) {
			return null;
		} else {
			return com.targetVerb;
		}
	}

	// inlined methods (un-inlined by hand!) - be careful when restoring the method order

	public static void imethod1() {
		while (true) {
			LinkList var1 = Js5NetThread.requestQueue;
			Js5WorkerRequest var2;
			synchronized (var1) {
				var2 = (Js5WorkerRequest) Js5NetThread.field1206.pop();
			}
			if (var2 == null) {
				return;
			}
			var2.field1773.method1468(var2.fs, (int) var2.key, var2.data, false);
		}
	}

	// jag::oldscape::Client::MapBuildLoop
	public static void mapBuildLoop() {
		preventTimeout(false);

		mapLoadCount = 0;

		boolean var11 = true;
		for (int var12 = 0; var12 < mapBuildGroundData.length; var12++) {
			if (mapBuildGroundFile[var12] != -1 && mapBuildGroundData[var12] == null) {
				mapBuildGroundData[var12] = maps.getFile(mapBuildGroundFile[var12], 0);
				if (mapBuildGroundData[var12] == null) {
					var11 = false;
					mapLoadCount++;
				}
			}
			if (mapBuildLocationFile[var12] != -1 && mapBuildLocationData[var12] == null) {
				mapBuildLocationData[var12] = maps.fetchFile(mapBuildLocationFile[var12], 0, mapKeys[var12]);
				if (mapBuildLocationData[var12] == null) {
					var11 = false;
					mapLoadCount++;
				}
			}
		}
		if (!var11) {
			mapLoadingStage = 1;
			return;
		}

		locModelLoadCount = 0;

		boolean var13 = true;
		for (int var14 = 0; var14 < mapBuildGroundData.length; var14++) {
			byte[] var15 = mapBuildLocationData[var14];
			if (var15 != null) {
				int var16 = (mapBuildIndex[var14] >> 8) * 64 - mapBuildBaseX;
				int var17 = (mapBuildIndex[var14] & 0xFF) * 64 - mapBuildBaseZ;
				if (regionmode) {
					var16 = 10;
					var17 = 10;
				}
				var13 &= ClientBuild.checkLocations(var15, var16, var17);
			}
		}
		if (!var13) {
			mapLoadingStage = 2;
			return;
		}

		if (mapLoadingStage != 0) {
			messageBox(Text.LOADING + StringConstants.TAG_BREAK + StringConstants.OPEN_BRACKET + 100 + "%" + StringConstants.CLOSE_BRACKET, true);
		}

		flushAudio();
		clearCaches();

		flushAudio();
		world.resetMap();

		flushAudio();
		System.gc();

		for (int var18 = 0; var18 < 4; var18++) {
			levelCollisionMap[var18].reset();
		}

		for (int var19 = 0; var19 < 4; var19++) {
			for (int var20 = 0; var20 < 104; var20++) {
				for (int var21 = 0; var21 < 104; var21++) {
					ClientBuild.mapl[var19][var20][var21] = 0;
				}
			}
		}

		flushAudio();
		ClientBuild.init();

		int maps = mapBuildGroundData.length;
		BgSound.reset();

		preventTimeout(true);

		if (!regionmode) {
			for (int var24 = 0; var24 < maps; var24++) {
				int var25 = (mapBuildIndex[var24] >> 8) * 64 - mapBuildBaseX;
				int var26 = (mapBuildIndex[var24] & 0xFF) * 64 - mapBuildBaseZ;
				byte[] var27 = mapBuildGroundData[var24];
				if (var27 != null) {
					flushAudio();
					ClientBuild.loadGround(var27, var25, var26, mapBuildCenterZoneX * 8 - 48, mapBuildCenterZoneZ * 8 - 48, levelCollisionMap);
				}
			}

			for (int var28 = 0; var28 < maps; var28++) {
				int var29 = (mapBuildIndex[var28] >> 8) * 64 - mapBuildBaseX;
				int var30 = (mapBuildIndex[var28] & 0xFF) * 64 - mapBuildBaseZ;
				byte[] var31 = mapBuildGroundData[var28];
				if (var31 == null && mapBuildCenterZoneZ < 800) {
					flushAudio();
					ClientBuild.fadeAdjacent(var29, var30, 64, 64);
				}
			}

			preventTimeout(true);

			for (int var32 = 0; var32 < maps; var32++) {
				byte[] var33 = mapBuildLocationData[var32];
				if (var33 != null) {
					int var34 = (mapBuildIndex[var32] >> 8) * 64 - mapBuildBaseX;
					int var35 = (mapBuildIndex[var32] & 0xFF) * 64 - mapBuildBaseZ;

					flushAudio();
					ClientBuild.loadLocations(var33, var34, var35, world, levelCollisionMap);
				}
			}
		}

		if (regionmode) {
			for (int var36 = 0; var36 < 4; var36++) {
				flushAudio();

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
							for (int var46 = 0; var46 < mapBuildIndex.length; var46++) {
								if (mapBuildIndex[var46] == var45 && mapBuildGroundData[var46] != null) {
									ClientBuild.loadGroundRegion(mapBuildGroundData[var46], var36, var37 * 8, var38 * 8, var41, (var43 & 0x7) * 8, (var44 & 0x7) * 8, var42, levelCollisionMap);
									var39 = true;
									break;
								}
							}
						}
						if (!var39) {
							ClientBuild.autoGroundRegion(var36, var37 * 8, var38 * 8);
						}
					}
				}
			}

			for (int var54 = 0; var54 < 13; var54++) {
				for (int var55 = 0; var55 < 13; var55++) {
					int var56 = field1979[0][var54][var55];
					if (var56 == -1) {
						ClientBuild.fadeAdjacent(var54 * 8, var55 * 8, 8, 8);
					}
				}
			}

			preventTimeout(true);

			for (int var57 = 0; var57 < 4; var57++) {
				flushAudio();

				for (int var58 = 0; var58 < 13; var58++) {
					for (int var59 = 0; var59 < 13; var59++) {
						int var60 = field1979[var57][var58][var59];
						if (var60 != -1) {
							int var61 = var60 >> 24 & 0x3;
							int var62 = var60 >> 1 & 0x3;
							int var63 = var60 >> 14 & 0x3FF;
							int var64 = var60 >> 3 & 0x7FF;
							int var65 = (var63 / 8 << 8) + var64 / 8;
							for (int var66 = 0; var66 < mapBuildIndex.length; var66++) {
								if (mapBuildIndex[var66] == var65 && mapBuildLocationData[var66] != null) {
									ClientBuild.loadLocationsRegion(mapBuildLocationData[var66], var57, var58 * 8, var59 * 8, var61, (var63 & 0x7) * 8, (var64 & 0x7) * 8, var62, world, levelCollisionMap);
									break;
								}
							}
						}
					}
				}
			}
		}

		preventTimeout(true);
		clearCaches();

		flushAudio();
		ClientBuild.finishBuild(world, levelCollisionMap);

		preventTimeout(true);

		int var67 = ClientBuild.minusedlevel;
		if (var67 > minusedlevel) {
			var67 = minusedlevel;
		}
		if (var67 < minusedlevel - 1) {
			int var68 = minusedlevel - 1;
		}

		if (lowMemory) {
			world.fillBaseLevel(ClientBuild.minusedlevel);
		} else {
			world.fillBaseLevel(0);
		}

		for (int x = 0; x < 104; x++) {
			for (int z = 0; z < 104; z++) {
				showObject(x, z);
			}
		}

		flushAudio();
		locChangePostBuildCorrect();

		LocType.mc1.clear();

		if (GameShell.frame != null) {
			// todo: packet name notifying the server the client is in a frame
			out.p1Enc(210);
			out.p4(1057001181);
		}

		if (!regionmode) {
			int var72 = (mapBuildCenterZoneX - 6) / 8;
			int var73 = (mapBuildCenterZoneX + 6) / 8;
			int var74 = (mapBuildCenterZoneZ - 6) / 8;
			int var75 = (mapBuildCenterZoneZ + 6) / 8;
			for (int var76 = var72 - 1; var76 <= var73 + 1; var76++) {
				for (int var77 = var74 - 1; var77 <= var75 + 1; var77++) {
					if (var76 < var72 || var76 > var73 || var77 < var74 || var77 > var75) {
						Client.maps.updateCacheHint("m" + var76 + "_" + var77);
						Client.maps.updateCacheHint("l" + var76 + "_" + var77);
					}
				}
			}
		}

		setMainState(30);

		flushAudio();
		ClientBuild.quit();

		// MAP_BUILD_COMPLETE
		out.p1Enc(197);

		GameShell.doneslowupdate();
	}

	// jag::oldscape::Client::LocChangePostBuildCorrect
	public static void locChangePostBuildCorrect() {
		for (LocChange loc = (LocChange) locChanges.head(); loc != null; loc = (LocChange) locChanges.next()) {
			if (loc.endTime == -1) {
				loc.startTime = 0;
				locChangeSetOld(loc);
			} else {
				loc.unlink();
			}
		}
	}

	public static void imethod10() {
		out.pos = 0;
		in.pos = 0;
		ptype = -1;
		ptype0 = -1;
		ptype1 = -1;
		ptype2 = -1;
		psize = 0;
		timeoutTimer = 0;
		rebootTimer = 0;
		menuNumEntries = 0;
		isMenuOpen = false;
		minimapState = 0;
		minimapFlagX = 0;
		for (int var6 = 0; var6 < players.length; var6++) {
			if (players[var6] != null) {
				players[var6].targetId = -1;
			}
		}
		for (int var7 = 0; var7 < npcs.length; var7++) {
			if (npcs[var7] != null) {
				npcs[var7].targetId = -1;
			}
		}
		imethod11();
		setMainState(30);
		for (int var8 = 0; var8 < 100; var8++) {
			componentRedrawRequested1[var8] = true;
		}
	}

	public static void imethod11() {
		ClientInvCache.field1623 = new HashTable(32);
	}

	public static void gameLoop() {
		if (rebootTimer > 1) {
			rebootTimer--;
		}

		if (logoutTimer > 0) {
			logoutTimer--;
		}

		if (networkError) {
			networkError = false;
			lostCon();
			return;
		}

		for (int var78 = 0; var78 < 100 && tcpIn(); var78++) {
		}

		if (state != 30) {
			return;
		}

		// REFLECTION_CHECK_REPLY
		ReflectionChecker.performCheck(out, 108);

		Object var384 = mouseTracking.lock;
		synchronized (var384) {
			if (!mouseTracked) {
				mouseTracking.length = 0;
			} else if (JavaMouseProvider.mouseClickButton != 0 || mouseTracking.length >= 40) {
				// EVENT_MOUSE_MOVE
				out.p1Enc(72);
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
						if (mouseTrackedDelta < 8 && var391 >= -32 && var391 <= 31 && var392 >= -32 && var392 <= 31) {
							var391 += 32;
							var392 += 32;
							out.p2((mouseTrackedDelta << 12) + (var391 << 6) + var392);
							mouseTrackedDelta = 0;
						} else if (mouseTrackedDelta < 8) {
							out.p3((mouseTrackedDelta << 19) + 8388608 + var390);
							mouseTrackedDelta = 0;
						} else {
							out.p4((mouseTrackedDelta << 19) + -1073741824 + var390);
							mouseTrackedDelta = 0;
						}
					} else if (mouseTrackedDelta < 2047) {
						mouseTrackedDelta++;
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
			long var395 = (JavaMouseProvider.mouseClickTime - prevMouseClickTime) / 50L;
			if (var395 > 4095L) {
				var395 = 4095L;
			}
			prevMouseClickTime = JavaMouseProvider.mouseClickTime;
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
			// EVENT_MOUSE_CLICK
			out.p1Enc(161);
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
			// EVENT_CAMERA_POSITION
			out.p1Enc(79);
			out.p2_alt1(orbitCameraPitch);
			out.p2_alt2(orbitCameraYaw);
		}
		if (GameShell.focus && !focusIn) {
			focusIn = true;
			// EVENT_APPLET_FOCUS
			out.p1Enc(178);
			out.p1(1);
		}
		if (!GameShell.focus && focusIn) {
			focusIn = false;
			// EVENT_APPLET_FOCUS
			out.p1Enc(178);
			out.p1(0);
		}
		checkMinimap();
		if (state != 30) {
			return;
		}
		locChangeDoQueue();
		soundsDoQueue();
		timeoutTimer++;
		if (timeoutTimer > 750) {
			lostCon();
			return;
		}
		movePlayers();
		moveNpcs();
		timeoutChat();
		worldUpdateNum++;
		if (crossMode != 0) {
			crossCycle += 20;
			if (crossCycle >= 400) {
				crossMode = 0;
			}
		}
		if (selectedArea != null) {
			selectedCycle++;
			if (selectedCycle >= 15) {
				componentUpdated(selectedArea);
				selectedArea = null;
			}
		}
		if (objDragInterface != null) {
			componentUpdated(objDragInterface);
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
						if (var436.linkObjType[objDragSlot] <= 0) {
							var437 = 0;
						}
						int var438 = getActive(var436);
						boolean var439 = (var438 >> 29 & 0x1) != 0;
						if (var439) {
							int var440 = hoveredSlot;
							int var441 = objDragSlot;
							var436.linkObjType[var441] = var436.linkObjType[var440];
							var436.linkObjCount[var441] = var436.linkObjCount[var440];
							var436.linkObjType[var440] = -1;
							var436.linkObjCount[var440] = 0;
						} else if (var437 == 1) {
							int var442 = hoveredSlot;
							int var443 = objDragSlot;
							while (var442 != var443) {
								if (var442 > var443) {
									var436.swapSlots(var442 - 1, var442);
									var442--;
								} else if (var442 < var443) {
									var436.swapSlots(var442 + 1, var442);
									var442++;
								}
							}
						} else {
							var436.swapSlots(objDragSlot, hoveredSlot);
						}
						// INV_BUTTOND
						out.p1Enc(2);
						out.p4_alt2(objDragInterface.parentlayer);
						out.p2_alt3(objDragSlot);
						out.p1_alt1(var437);
						out.p2_alt1(hoveredSlot);
					}
				} else if ((oneMouseButton == 1 || isAddFriendOption(menuNumEntries - 1)) && menuNumEntries > 2) {
					openMenu();
				} else if (menuNumEntries > 0) {
					doAction(menuNumEntries - 1);
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
		dropComponent = null;
		dragging = false;
		dragParentFound = false;
		field2151 = 0;
		while (JavaKeyboardProvider.imethod2() && field2151 < 128) {
			keypressKeycodes[field2151] = JavaKeyboardProvider.field114;
			keypressKeychars[field2151] = JavaKeyboardProvider.field1162;
			field2151++;
		}
		loopInterface(toplevelinterface, 0, 0, 765, 503, 0, 0);
		interfaceUpdateNum++;

		// todo: revisit this code if something is broken -- tried to flatten the do { } while () blocks
		HookReq var449;
		IfType var450;
		IfType var451;

		do {
			var449 = (HookReq) hookRequestsTimer.pop();
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
			ScriptRunner.executeScript(var449);
		}

		do {
			var449 = (HookReq) hookRequestsMouseStop.pop();
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
			ScriptRunner.executeScript(var449);
		}

		do {
			var449 = (HookReq) hookRequests.pop();
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
			ScriptRunner.executeScript(var449);
		}

		if (dragComponent != null) {
			loopIf3Drag();
		}

		if (World.groundX != -1) {
			int var473 = World.groundX;
			int var474 = World.groundZ;
			boolean var475 = tryMove(localPlayer.routeX[0], localPlayer.routeZ[0], var473, var474, true, 0, 0, 0, 0, 0, 0);
			World.groundX = -1;
			if (var475) {
				crossX = JavaMouseProvider.mouseClickX;
				crossY = JavaMouseProvider.mouseClickY;
				crossMode = 1;
				crossCycle = 0;
			}
		}
		handleMouseInput();
		if (field37 != var444) {
			if (var444 != null) {
				componentUpdated(var444);
			}
			if (field37 != null) {
				componentUpdated(field37);
			}
		}
		if (field654 != var445 && field2076 == field1995) {
			if (var445 != null) {
				componentUpdated(var445);
			}
			if (field654 != null) {
				componentUpdated(field654);
			}
		}
		if (field654 == null) {
			if (field1995 > 0) {
				field1995--;
			}
		} else if (field1995 < field2076) {
			field1995++;
			if (field2076 == field1995) {
				componentUpdated(field654);
			}
		}
		followCamera();
		if (cinemaCam) {
			cinemaCamera();
		}
		for (int var504 = 0; var504 < 5; var504++) {
			int var10002 = camShakeCycle[var504]++;
		}

		int var505 = JavaMouseProvider.getIdleCycles();
		int var507 = JavaKeyboardProvider.getIdleCycles();
		if (var505 > 15000 && var507 > 15000) {
			logoutTimer = 250;
			JavaMouseProvider.setIdleCycles(14500); // 10s backoff

			// IDLE_TIMER
			out.p1Enc(38);
		}

		macroCameraCycle++;
		if (macroCameraCycle > 500) {
			macroCameraCycle = 0;
			int var509 = (int) (Math.random() * 8.0D);
			if ((var509 & 0x1) == 1) {
				macroCameraX += macroCameraXModifier;
			}
			if ((var509 & 0x2) == 2) {
				macroCameraZ += macroCameraZModifier;
			}
			if ((var509 & 0x4) == 4) {
				macroCameraAngle += macroCameraAngleModifier;
			}
		}
		if (macroCameraX < -50) {
			macroCameraXModifier = 2;
		}
		if (macroCameraX > 50) {
			macroCameraXModifier = -2;
		}
		if (macroCameraZ < -55) {
			macroCameraZModifier = 2;
		}
		if (macroCameraZ > 55) {
			macroCameraZModifier = -2;
		}
		if (macroCameraAngle < -40) {
			macroCameraAngleModifier = 1;
		}
		if (macroCameraAngle > 40) {
			macroCameraAngleModifier = -1;
		}
		macroMinimapCycle++;
		if (macroMinimapCycle > 500) {
			macroMinimapCycle = 0;
			int var510 = (int) (Math.random() * 8.0D);
			if ((var510 & 0x1) == 1) {
				macroMinimapAngle += macroMinimapAngleModifier;
			}
			if ((var510 & 0x2) == 2) {
				macroMinimapZoom += macroMinimapZoomModifier;
			}
		}
		if (macroMinimapAngle < -60) {
			macroMinimapAngleModifier = 2;
		}
		if (macroMinimapAngle > 60) {
			macroMinimapAngleModifier = -2;
		}
		if (macroMinimapZoom < -20) {
			macroMinimapZoomModifier = 1;
		}
		if (macroMinimapZoom > 10) {
			macroMinimapZoomModifier = -1;
		}

		noTimeoutCycle++;
		if (noTimeoutCycle > 50) {
			// NO_TIMEOUT
			out.p1Enc(228);
		}

		try {
			if (loginStream != null && out.pos > 0) {
				loginStream.write(out.data, 0, out.pos);
				out.pos = 0;
				noTimeoutCycle = 0;
			}
		} catch (IOException var518) {
			lostCon();
		}
	}

	// jag::oldscape::Client::LostCon
	public static void lostCon() {
		if (logoutTimer > 0) {
			logout();
			return;
		}

		setMainState(40);
		stream = loginStream;
		loginStream = null;
	}

	public static boolean tcpIn() {
		if (loginStream == null) {
			return false;
		}

		try {
			int var80 = loginStream.available();
			if (var80 == 0) {
				return false;
			}

			if (ptype == -1) {
				loginStream.read(in.data, 0, 1);
				in.pos = 0;
				ptype = in.g1Enc();
				psize = Protocol.SERVERPROT_SIZES[ptype];
				var80--;
			}

			if (psize == -1) {
				if (var80 <= 0) {
					return false;
				}
				loginStream.read(in.data, 0, 1);
				psize = in.data[0] & 0xFF;
				var80--;
			} else if (psize == -2) {
				if (var80 <= 1) {
					return false;
				}

				loginStream.read(in.data, 0, 2);
				in.pos = 0;
				psize = in.g2();
				var80 -= 2;
			}

			if (var80 < psize) {
				return false;
			}

			in.pos = 0;
			loginStream.read(in.data, 0, psize);
			timeoutTimer = 0;
			ptype2 = ptype1;
			ptype1 = ptype0;
			ptype0 = ptype;

			if (ptype == 180) {
				// VARP_LARGE
				int var81 = in.g2_alt3();
				int var82 = in.g4();
				VarCache.varServ[var81] = var82;
				if (VarCache.var[var81] != var82) {
					VarCache.var[var81] = var82;
					clientVar(var81);
				}
				field2110[++field2084 - 1 & 0x1F] = var81;
				ptype = -1;
				return true;
			}
			if (ptype == 168) {
				// MESSAGE_PRIVATE_ECHO
				String var83 = in.gjstr();
				String var91 = PixFont.method2844(StringUtil.method54(WordPack.unpack2(in)));
				addChat(6, var83, var91);
				ptype = -1;
				return true;
			}
			if (ptype == 87) {
				// IF_CLOSESUB
				int var92 = in.g4();
				SubInterface var93 = (SubInterface) subinterfaces.get((long) var92);
				if (var93 != null) {
					closeSubInterface(var93, true);
				}
				if (resumedPauseButton != null) {
					componentUpdated(resumedPauseButton);
					resumedPauseButton = null;
				}
				ptype = -1;
				return true;
			}
			if (ptype == 176) {
				// IF_SETANIM
				int var94 = in.g2b_alt3();
				int var95 = in.g4();
				IfType var96 = IfType.get(var95);
				if (var96.modelAnim != var94 || var94 == -1) {
					var96.modelAnim = var94;
					var96.animFrame = 0;
					var96.animCycle = 0;
					componentUpdated(var96);
				}
				ptype = -1;
				return true;
			}
			if (ptype == 100) {
				// MESSAGE_GAME
				String var97 = in.gjstr();
				if (var97.endsWith(":tradereq:")) {
					String var98 = DisplayNameTools.toBaseDisplayName(var97.substring(0, var97.indexOf(":")), namespace);
					boolean var99 = false;
					if (isIgnored(var98)) {
						var99 = true;
					}
					if (!var99 && overrideChat == 0) {
						addChat(4, var98, Text.TRADEREQ);
					}
				} else if (var97.endsWith(":duelreq:")) {
					String var100 = DisplayNameTools.toBaseDisplayName(var97.substring(0, var97.indexOf(":")), namespace);
					boolean var101 = false;
					if (isIgnored(var100)) {
						var101 = true;
					}
					if (!var101 && overrideChat == 0) {
						addChat(8, var100, Text.DUELREQ);
					}
				} else if (var97.endsWith(":chalreq:")) {
					String var102 = DisplayNameTools.toBaseDisplayName(var97.substring(0, var97.indexOf(":")), namespace);
					boolean var103 = false;
					if (isIgnored(var102)) {
						var103 = true;
					}
					if (!var103 && overrideChat == 0) {
						String var104 = var97.substring(var97.indexOf(":") + 1, var97.length() - 9);
						addChat(8, var102, var104);
					}
				} else if (var97.endsWith(":assistreq:")) {
					String var105 = DisplayNameTools.toBaseDisplayName(var97.substring(0, var97.indexOf(":")), namespace);
					boolean var106 = false;
					if (isIgnored(var105)) {
						var106 = true;
					}
					if (!var106 && overrideChat == 0) {
						addChat(10, var105, "");
					}
				} else if (var97.endsWith(":clan:")) {
					String var107 = var97.substring(0, var97.indexOf(":clan:"));
					addChat(11, "", var107);
				} else if (var97.endsWith(":trade:")) {
					String var108 = var97.substring(0, var97.indexOf(":trade:"));
					if (overrideChat == 0) {
						addChat(12, "", var108);
					}
				} else if (var97.endsWith(":assist:")) {
					String var109 = var97.substring(0, var97.indexOf(":assist:"));
					if (overrideChat == 0) {
						addChat(13, "", var109);
					}
				} else {
					addChat(0, "", var97);
				}
				ptype = -1;
				return true;
			}
			if (ptype == 89) {
				// UPDATE_ZONE_PARTIAL_FOLLOWS
				baseZ = in.g1();
				baseX = in.g1_alt3();

				ptype = -1;
				return true;
			}
			if (ptype == 246) {
				// TELEPORT (unofficial name)
				int var110 = in.g1_alt2();
				int var111 = in.g1_alt1();
				int var112 = in.g1_alt3();
				minusedlevel = var112 >> 1;
				localPlayer.teleport(var111, var110, (var112 & 0x1) == 1);
				ptype = -1;
				return true;
			}
			if (ptype == 88) {
				// VARP_SMALL
				int var113 = in.g2_alt1();
				byte var114 = in.g1b_alt3();
				VarCache.varServ[var113] = var114;
				if (VarCache.var[var113] != var114) {
					VarCache.var[var113] = var114;
					clientVar(var113);
				}
				field2110[++field2084 - 1 & 0x1F] = var113;
				ptype = -1;
				return true;
			}
			if (ptype == 42) {
				// TRIGGER_ONDIALOGABORT
				if (toplevelinterface != -1) {
					runHookImmediate(toplevelinterface, 0);
				}
				ptype = -1;
				return true;
			}
			if (ptype == 205 || ptype == 106 || ptype == 245 || ptype == 215 || ptype == 20 || ptype == 32 || ptype == 207 || ptype == 173 || ptype == 6 || ptype == 7 || ptype == 154) {
				readZonePacket();
				ptype = -1;
				return true;
			}
			if (ptype == 41) {
				// UPDATE_RUNENERGY
				legacyUpdated();
				runEnergy = in.g1();
				field2119 = interfaceUpdateNum;
				ptype = -1;
				return true;
			}
			if (ptype == 86) {
				// MESSAGE_PRIVATE
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
				if (isIgnored(var115)) {
					var123 = true;
				}
				if (!var123 && overrideChat == 0) {
					field2148[field2149] = var121;
					field2149 = (field2149 + 1) % 100;
					String var132 = PixFont.method2844(StringUtil.method54(WordPack.unpack2(in)));
					if (var120 == 2 || var120 == 3) {
						addChat(7, StringConstants.TAG_IMG(1) + var115, var132);
					} else if (var120 == 1) {
						addChat(7, StringConstants.TAG_IMG(0) + var115, var132);
					} else {
						addChat(3, var115, var132);
					}
				}
				ptype = -1;
				return true;
			}
			if (ptype == 184) {
				// IF_OPENSUB
				int var133 = in.g1_alt2();
				int var134 = in.g2_alt2();
				int var135 = in.g4_alt1();
				SubInterface var136 = (SubInterface) subinterfaces.get((long) var135);
				if (var136 != null) {
					closeSubInterface(var136, var136.id != var134);
				}
				openSubInterface(var135, var134, var133);
				ptype = -1;
				return true;
			}
			if (ptype == 214) {
				// UPDATE_UID192
				in.pos += 28;
				if (in.checkcrc()) {
					GameShellCache.storeUID192(in, in.pos - 28);
				}
				ptype = -1;
				return true;
			}
			if (ptype == 137) {
				// CHAT_FILTER_SETTINGS
				publicChatFilter = in.g1();
				tradeChatFilter = in.g1();
				ptype = -1;
				return true;
			}
			if (ptype == 224) {
				// LOGOUT
				logout();
				ptype = -1;
				return false;
			}
			if (ptype == 147) {
				// IF_OPENTOP
				int var137 = in.g2_alt1();
				toplevelinterface = var137;
				ifAnimReset(var137);
				ScriptRunner.executeOnLoad(toplevelinterface);
				for (int var138 = 0; var138 < 100; var138++) {
					componentRedrawRequested1[var138] = true;
				}
				ptype = -1;
				return true;
			}
			if (ptype == 241) {
				// LAST_LOGIN_INFO
				int var139 = in.g4_alt1();
				field170 = GameShell.signLink.dnsreq(var139);
				ptype = -1;
				return true;
			}
			if (ptype == 225) {
				// CAM_LOOKAT
				cinemaCam = true;
				cutsceneDstLocalTileX = in.g1();
				cutsceneDstLocalTileZ = in.g1();
				cutsceneDstHeight = in.g2();
				cutsceneRotateSpeed = in.g1();
				cutsceneRotateAcceleration = in.g1();
				if (cutsceneRotateAcceleration >= 100) {
					int var140 = cutsceneDstLocalTileX * 128 + 64;
					int var141 = cutsceneDstLocalTileZ * 128 + 64;
					int var142 = getAvH(var140, var141, minusedlevel) - cutsceneDstHeight;
					int var143 = var140 - camX;
					int var144 = var142 - camY;
					int var145 = var141 - camZ;
					int var146 = (int) Math.sqrt((double) (var143 * var143 + var145 * var145));
					camPitch = (int) (Math.atan2((double) var144, (double) var146) * 325.949D) & 0x7FF;
					camYaw = (int) (Math.atan2((double) var143, (double) var145) * -325.949D) & 0x7FF;
					if (camPitch < 128) {
						camPitch = 128;
					}
					if (camPitch > 383) {
						camPitch = 383;
					}
				}
				ptype = -1;
				return true;
			}
			if (ptype == 234) {
				// IF_SETCOLOUR
				int var147 = in.g4_alt1();
				int var148 = in.g2();
				int var149 = var148 >> 10 & 0x1F;
				int var150 = var148 >> 5 & 0x1F;
				int var151 = var148 & 0x1F;
				int var152 = (var151 << 3) + (var149 << 19) + (var150 << 11);
				IfType var153 = IfType.get(var147);
				if (var153.colour != var152) {
					var153.colour = var152;
					componentUpdated(var153);
				}
				ptype = -1;
				return true;
			}
			if (ptype == 85) {
				// IF_SETPOSITION
				int var154 = in.g2b_alt2();
				int var155 = in.g2b_alt1();
				int var156 = in.g4_alt1();
				IfType var157 = IfType.get(var156);
				int var158 = var157.x + var155;
				int var159 = var157.y + var154;
				if (var157.renderx != var158 || var157.rendery != var159) {
					var157.renderx = var158;
					var157.rendery = var159;
					componentUpdated(var157);
				}
				ptype = -1;
				return true;
			}
			if (ptype == 1) {
				// UPDATE_RUNWEIGHT
				legacyUpdated();
				runWeight = in.g2b();
				field2119 = interfaceUpdateNum;
				ptype = -1;
				return true;
			}
			if (ptype == 48) {
				// IF_SETEVENTS
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
					Linkable var167 = serverActive.get(var165);
					if (var167 != null) {
						var167.unlink();
					}
					serverActive.put(new ServerActive(var160), var165);
				}
				ptype = -1;
				return true;
			}
			if (ptype == 73) {
				// REBUILD_REGION
				rebuildPacket(true);
				ptype = -1;
				return true;
			}
			if (ptype == 17) {
				// CAM_SHAKE
				int var168 = in.g1();
				int var169 = in.g1();
				int var170 = in.g1();
				int var171 = in.g1();

				camShake[var168] = true;
				camShakeAxis[var168] = var169;
				camShakeRan[var168] = var170;
				camShakeAmp[var168] = var171;
				camShakeCycle[var168] = 0;

				ptype = -1;
				return true;
			}
			if (ptype == 113) {
				// PLAYER_INFO
				getPlayerPos();
				ptype = -1;
				return true;
			}
			if (ptype == 222) {
				// UPDATE_INV_PARTIAL
				int comId = in.g4();
				int invId = in.g2();
				if (comId < -70000) {
					invId += 32768;
				}

				IfType com;
				if (comId >= 0) {
					com = IfType.get(comId);
				} else {
					com = null;
				}

				while (in.pos < psize) {
					int slot = in.gsmart();
					int id = in.g2();

					int count = 0;
					if (id != 0) {
						count = in.g1();
						if (count == 255) {
							count = in.g4();
						}
					}

					if (com != null && slot >= 0 && slot < com.linkObjType.length) {
						com.linkObjType[slot] = id;
						com.linkObjCount[slot] = count;
					}

					ClientInvCache.method2901(invId, slot, id - 1, count);
				}

				if (com != null) {
					componentUpdated(com);
				}

				legacyUpdated();
				field2112[++field2050 - 1 & 0x1F] = invId & 0x7FFF;
				ptype = -1;
				return true;
			}
			if (ptype == 39) {
				// IF_RESYNC (unofficial name)
				int var178 = psize + in.pos;
				int var179 = in.g2();
				int var180 = in.g2();
				if (toplevelinterface != var179) {
					toplevelinterface = var179;
					ifAnimReset(toplevelinterface);
					ScriptRunner.executeOnLoad(toplevelinterface);
					for (int var181 = 0; var181 < 100; var181++) {
						componentRedrawRequested1[var181] = true;
					}
				}
				while (var180-- > 0) {
					int var182 = in.g4();
					int var183 = in.g2();
					int var184 = in.g1();
					SubInterface var185 = (SubInterface) subinterfaces.get((long) var182);
					if (var185 != null && var185.id != var183) {
						closeSubInterface(var185, true);
						var185 = null;
					}
					if (var185 == null) {
						var185 = openSubInterface(var182, var183, var184);
					}
					var185.field1599 = true;
				}
				for (SubInterface var186 = (SubInterface) subinterfaces.first(); var186 != null; var186 = (SubInterface) subinterfaces.next()) {
					if (var186.field1599) {
						var186.field1599 = false;
					} else {
						closeSubInterface(var186, true);
					}
				}
				serverActive = new HashTable(512);
				while (in.pos < var178) {
					int var187 = in.g4();
					int var188 = in.g2();
					int var189 = in.g2();
					int var190 = in.g4();
					for (int var191 = var188; var191 <= var189; var191++) {
						long var192 = ((long) var187 << 32) + (long) var191;
						serverActive.put(new ServerActive(var190), var192);
					}
				}
				ptype = -1;
				return true;
			}
			if (ptype == 21) {
				// REBUILD_NORMAL
				rebuildPacket(false);
				ptype = -1;
				return true;
			}
			if (ptype == 190) {
				// MINIMAP_TOGGLE
				minimapState = in.g1();
				ptype = -1;
				return true;
			}
			if (ptype == 84) {
				// IF_SETHIDE
				int var194 = in.g4_alt1();
				boolean var195 = in.g1_alt3() == 1;
				IfType var196 = IfType.get(var194);
				if (var196.hide != var195) {
					var196.hide = var195;
					componentUpdated(var196);
				}
				ptype = -1;
				return true;
			}
			if (ptype == 129) {
				// VARP_RESET (unofficial name)
				for (int var197 = 0; var197 < VarpType.numDefinitions; var197++) {
					VarpType var198 = VarpType.list(var197);
					if (var198 != null && var198.clientcode == 0) {
						VarCache.varServ[var197] = 0;
						VarCache.var[var197] = 0;
					}
				}
				legacyUpdated();
				field2084 += 32;
				ptype = -1;
				return true;
			}
			if (ptype == 92) {
				// RUNCLIENTSCRIPT
				String stackDesc = in.gjstr();
				Object[] stack = new Object[stackDesc.length() + 1];
				for (int i = stackDesc.length() - 1; i >= 0; i--) {
					if (stackDesc.charAt(i) == 's') {
						stack[i + 1] = in.gjstr();
					} else {
						stack[i + 1] = Integer.valueOf(in.g4());
					}
				}
				stack[0] = Integer.valueOf(in.g4());

				HookReq req = new HookReq();
				req.onop = stack;
				ScriptRunner.executeScript(req);
				ptype = -1;
				return true;
			}
			if (ptype == 67) {
				// UPDATE_ZONE_FULL_FOLLOWS
				baseZ = in.g1_alt1();
				baseX = in.g1_alt3();

				for (int x = baseX; x < baseX + 8; x++) {
					for (int z = baseZ; z < baseZ + 8; z++) {
						if (objStacks[minusedlevel][x][z] != null) {
							objStacks[minusedlevel][x][z] = null;
							showObject(x, z);
						}
					}
				}

				for (LocChange var205 = (LocChange) locChanges.head(); var205 != null; var205 = (LocChange) locChanges.next()) {
					if (var205.x >= baseX && var205.x < baseX + 8 && var205.z >= baseZ && var205.z < baseZ + 8 && minusedlevel == var205.level) {
						var205.endTime = 0;
					}
				}

				ptype = -1;
				return true;
			}
			if (ptype == 66) {
				// IF_SETNPCHEAD
				int var206 = in.g4_alt2();
				int var207 = in.g2_alt2();
				IfType var208 = IfType.get(var206);
				if (var208.modelType != 2 || var208.modelId != var207) {
					var208.modelType = 2;
					var208.modelId = var207;
					componentUpdated(var208);
				}
				ptype = -1;
				return true;
			}
			if (ptype == 208) {
				// UPDATE_STAT
				legacyUpdated();
				int var209 = in.g1_alt1();
				int var210 = in.g1_alt1();
				int var211 = in.g4();
				skillExperience[var210] = var211;
				skillLevel[var210] = var209;
				skillBaseLevel[var210] = 1;
				for (int var212 = 0; var212 < 98; var212++) {
					if (var211 >= PlayerSkillXPTable.levelExperience[var212]) {
						skillBaseLevel[var210] = var212 + 2;
					}
				}
				field1999[++field1982 - 1 & 0x1F] = var210;
				ptype = -1;
				return true;
			}
			if (ptype == 95) {
				// FRIENDLIST_LOADED
				friendListStatus = 1;
				friendSystemUpdateNum = interfaceUpdateNum;
				ptype = -1;
				return true;
			}
			if (ptype == 164) {
				// SET_PLAYER_OP
				String var213 = in.gjstr();
				int var214 = in.g1_alt1();
				int var215 = in.g1_alt3();
				if (var214 >= 1 && var214 <= 8) {
					if (var213.equalsIgnoreCase("null")) {
						var213 = null;
					}
					playerOp[var214 - 1] = var213;
					playerOpPriority[var214 - 1] = var215 == 0;
				}
				ptype = -1;
				return true;
			}
			if (ptype == 117) {
				// UPDATE_INV_STOP_TRANSMIT
				int comId = in.g4_alt1();

				IfType com = IfType.get(comId);
				for (int i = 0; i < com.linkObjType.length; i++) {
					com.linkObjType[i] = -1;
					com.linkObjType[i] = 0;
				}

				componentUpdated(com);

				ptype = -1;
				return true;
			}
			if (ptype == 172) {
				// UPDATE_INV_STOPTRANSMIT
				int var219 = in.g2_alt2();
				ClientInvCache.method55(var219);
				field2112[++field2050 - 1 & 0x1F] = var219 & 0x7FFF;
				ptype = -1;
				return true;
			}
			if (ptype == 70) {
				// CHAT_FILTER_SETTINGS_PRIVATECHAT
				privateChatFilter = ChatFilterPrivacy.get(in.g1());
				ptype = -1;
				return true;
			}
			if (ptype == 140) {
				// UPDATE_FRIENDCHAT_CHANNEL_SINGLEUSER
				String var225 = in.gjstr();
				int var226 = in.g2();
				byte var227 = in.g1b();
				boolean var228 = false;
				if (var227 == -128) {
					var228 = true;
				}
				if (var228) {
					if (field1220 == 0) {
						ptype = -1;
						return true;
					}
					boolean var229 = false;
					int var230;
					for (var230 = 0; var230 < field1220 && (!field1774[var230].username.equals(var225) || field1774[var230].world != var226); var230++) {
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
					FriendChatUser var231 = new FriendChatUser();
					var231.username = var225;
					var231.displayName = DisplayNameTools.toBaseDisplayName(var231.username, namespace);
					var231.world = var226;
					var231.rank = var227;
					int var232;
					for (var232 = field1220 - 1; var232 >= 0; var232--) {
						int var233 = field1774[var232].displayName.compareTo(var231.username);
						if (var233 == 0) {
							field1774[var232].world = var226;
							field1774[var232].rank = var227;
							if (var225.equals(localPlayer.name)) {
								chatRank = var227;
							}
							friendChatUpdateNum = interfaceUpdateNum;
							ptype = -1;
							return true;
						}
						if (var233 < 0) {
							break;
						}
					}
					if (field1220 >= field1774.length) {
						ptype = -1;
						return true;
					}
					for (int var234 = field1220 - 1; var234 > var232; var234--) {
						field1774[var234 + 1] = field1774[var234];
					}
					if (field1220 == 0) {
						field1774 = new FriendChatUser[100];
					}
					field1774[var232 + 1] = var231;
					field1220++;
					if (var225.equals(localPlayer.name)) {
						chatRank = var227;
					}
				}
				friendChatUpdateNum = interfaceUpdateNum;
				ptype = -1;
				return true;
			}
			if (ptype == 25) {
				// REFLECTION_CHECKER
				ReflectionChecker.addCheck(in, psize);
				ptype = -1;
				return true;
			}
			if (ptype == 161) {
				// UNSET_MAP_FLAG (unofficial name)
				minimapFlagX = 0;
				ptype = -1;
				return true;
			}
			if (ptype == 160) {
				// HINT_ARROW
				hintType = in.g1();

				if (hintType == 1) {
					hintNpc = in.g2();
				} else if (hintType >= 2 && hintType <= 6) {
					if (hintType == 2) {
						hintOffsetX = 64;
						hintOffsetZ = 64;
					} else if (hintType == 3) {
						hintOffsetX = 0;
						hintOffsetZ = 64;
					} else if (hintType == 4) {
						hintOffsetX = 128;
						hintOffsetZ = 64;
					} else if (hintType == 5) {
						hintOffsetX = 64;
						hintOffsetZ = 0;
					} else if (hintType == 6) {
						hintOffsetX = 64;
						hintOffsetZ = 128;
					}

					hintType = 2;
					hintTileX = in.g2();
					hintTileZ = in.g2();
					hintHeight = in.g1();
				} else if (hintType == 10) {
					hintPlayer = in.g2();
				}

				ptype = -1;
				return true;
			}
			if (ptype == 217) {
				int var258 = in.g4_alt1();
				int var259 = in.g2_alt3();
				int var260 = in.g2_alt3();
				IfType var261 = IfType.get(var258);
				var261.field1827 = (var259 << 16) + var260;
				ptype = -1;
				return true;
			}
			if (ptype == 102) {
				// IF_SETOBJECT
				int var262 = in.g4();
				int var263 = in.g2_alt2();
				if (var263 == 65535) {
					var263 = -1;
				}
				int var264 = in.g4_alt1();
				IfType var265 = IfType.get(var262);
				if (var265.v3) {
					var265.invobject = var263;
					var265.invcount = var264;
					ObjType var267 = ObjType.list(var263);
					var265.modelXan = var267.xan2d;
					var265.modelYan = var267.yan2d;
					var265.modelZan = var267.zan2d;
					var265.xof = var267.xof2d;
					var265.yof = var267.yof2d;
					var265.modelZoom = var267.zoom2d;
					if (var265.renderwidth > 0) {
						var265.modelZoom = var265.modelZoom * 32 / var265.renderwidth;
					}
					componentUpdated(var265);
				} else {
					if (var263 == -1) {
						var265.modelType = 0;
						ptype = -1;
						return true;
					}
					ObjType var266 = ObjType.list(var263);
					var265.modelType = 4;
					var265.modelId = var263;
					var265.modelXan = var266.xan2d;
					var265.modelYan = var266.yan2d;
					var265.modelZoom = var266.zoom2d * 100 / var264;
					componentUpdated(var265);
				}
				ptype = -1;
				return true;
			}
			if (ptype == 57) {
				// MESSAGE_FRIENDCHANNEL
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
				if (var275 <= 1 && isIgnored(var268)) {
					var278 = true;
				}
				if (!var278 && overrideChat == 0) {
					field2148[field2149] = var276;
					field2149 = (field2149 + 1) % 100;
					String var287 = PixFont.method2844(StringUtil.method54(WordPack.unpack2(in)));
					if (var275 == 2 || var275 == 3) {
						addChat(9, StringConstants.TAG_IMG(1) + var268, var287, JString.fromBase37Upper(var269));
					} else if (var275 == 1) {
						addChat(9, StringConstants.TAG_IMG(0) + var268, var287, JString.fromBase37Upper(var269));
					} else {
						addChat(9, var268, var287, JString.fromBase37Upper(var269));
					}
				}
				ptype = -1;
				return true;
			}
			if (ptype == 80) {
				// UPDATE_FRIENDLIST
				while (in.pos < psize) {
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
					for (int var296 = 0; var296 < friendCount; var296++) {
						FriendListEntry var297 = friendList[var296];
						if (var288) {
							if (var290.equals(var297.name)) {
								var297.name = var289;
								var297.field177 = var290;
								var289 = null;
								break;
							}
						} else if (var289.equals(var297.name)) {
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
					if (var289 != null && friendCount < 200) {
						FriendListEntry var300 = new FriendListEntry();
						friendList[friendCount] = var300;
						var300.name = var289;
						var300.field177 = var290;
						var300.field174 = var291;
						var300.field175 = var292;
						var300.field172 = var294;
						var300.field176 = var295;
						friendCount++;
					}
				}
				friendListStatus = 2;
				friendSystemUpdateNum = interfaceUpdateNum;
				boolean var301 = false;
				int var302 = friendCount;
				while (var302 > 0) {
					boolean var303 = true;
					var302--;
					for (int var304 = 0; var304 < var302; var304++) {
						boolean var305 = false;
						FriendListEntry var306 = friendList[var304];
						FriendListEntry var307 = friendList[var304 + 1];
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
							FriendListEntry var308 = friendList[var304];
							friendList[var304] = friendList[var304 + 1];
							friendList[var304 + 1] = var308;
							var303 = false;
						}
					}
					if (var303) {
						break;
					}
				}
				ptype = -1;
				return true;
			}
			if (ptype == 120) {
				// UPDATE_FRIENDCHAT_CHANNEL_FULL
				friendChatUpdateNum = interfaceUpdateNum;
				if (psize == 0) {
					chatDisplayName = null;
					field2155 = null;
					field1220 = 0;
					field1774 = null;
					ptype = -1;
					return true;
				}
				field2155 = in.gjstr();
				long var309 = in.g8();
				chatDisplayName = JString.fromBase37(var309);
				chatMinKick = in.g1b();
				int var311 = in.g1();
				if (var311 == 255) {
					ptype = -1;
					return true;
				}
				field1220 = var311;
				FriendChatUser[] var312 = new FriendChatUser[100];
				for (int var313 = 0; var313 < field1220; var313++) {
					var312[var313] = new FriendChatUser();
					var312[var313].username = in.gjstr();
					var312[var313].displayName = DisplayNameTools.toBaseDisplayName(var312[var313].username, namespace);
					var312[var313].world = in.g2();
					var312[var313].rank = in.g1b();
					in.gjstr();
					if (var312[var313].username.equals(localPlayer.name)) {
						chatRank = var312[var313].rank;
					}
				}
				boolean var314 = false;
				int var315 = field1220;
				while (var315 > 0) {
					boolean var316 = true;
					var315--;
					for (int var317 = 0; var317 < var315; var317++) {
						if (var312[var317].displayName.compareTo(var312[var317 + 1].displayName) > 0) {
							FriendChatUser var318 = var312[var317];
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
				ptype = -1;
				return true;
			}
			if (ptype == 29) {
				// UPDATE_INV_FULL
				int comId = in.g4();
				int invId = in.g2();
				if (comId < -70000) {
					invId += 32768;
				}

				IfType com;
				if (comId >= 0) {
					com = IfType.get(comId);
				} else {
					com = null;
				}

				if (com != null) {
					for (int i = 0; i < com.linkObjType.length; i++) {
						com.linkObjType[i] = 0;
						com.linkObjCount[i] = 0;
					}
				}

				ClientInvCache inv = (ClientInvCache) ClientInvCache.field1623.get((long) invId);
				if (inv != null) {
					for (int i = 0; i < inv.objId.length; i++) {
						inv.objId[i] = -1;
						inv.objCount[i] = 0;
					}
				}

				int var325 = in.g2();
				for (int i = 0; i < var325; i++) {
					int count = in.g1_alt3();
					if (count == 255) {
						count = in.g4_alt1();
					}
					int id = in.g2_alt1();

					if (com != null && i < com.linkObjType.length) {
						com.linkObjType[i] = id;
						com.linkObjCount[i] = count;
					}

					ClientInvCache.method2901(invId, i, id - 1, count);
				}

				if (com != null) {
					componentUpdated(com);
				}

				legacyUpdated();
				field2112[++field2050 - 1 & 0x1F] = invId & 0x7FFF;
				ptype = -1;
				return true;
			}
			if (ptype == 131) {
				// UPDATE_ZONE_PARTIAL_ENCLOSED
				baseZ = in.g1_alt2();
				baseX = in.g1_alt1();

				while (in.pos < psize) {
					ptype = in.g1();
					readZonePacket();
				}

				ptype = -1;
				return true;
			}
			if (ptype == 169) {
				// CAM_MOVETO
				cinemaCam = true;
				cutsceneSrcLocalTileX = in.g1();
				cutsceneSrcLocalTileZ = in.g1();
				cutsceneSrcHeight = in.g2();
				cutsceneMoveSpeed = in.g1();
				cutsceneMoveAcceleration = in.g1();
				if (cutsceneMoveAcceleration >= 100) {
					camX = cutsceneSrcLocalTileX * 128 + 64;
					camZ = cutsceneSrcLocalTileZ * 128 + 64;
					camY = getAvH(camX, camZ, minusedlevel) - cutsceneSrcHeight;
				}
				ptype = -1;
				return true;
			}
			if (ptype == 72) {
				// RESET_ANIMS
				for (int i = 0; i < players.length; i++) {
					if (players[i] != null) {
						players[i].primarySeqId = -1;
					}
				}

				for (int i = 0; i < npcs.length; i++) {
					if (npcs[i] != null) {
						npcs[i].primarySeqId = -1;
					}
				}

				ptype = -1;
				return true;
			}
			if (ptype == 50) {
				// IF_SETSCROLLPOS
				int var331 = in.g4_alt3();
				int var332 = in.g2();
				IfType var333 = IfType.get(var331);
				if (var333 != null && var333.type == 0) {
					if (var332 > var333.scrollHeight - var333.renderheight) {
						var332 = var333.scrollHeight - var333.renderheight;
					}
					if (var332 < 0) {
						var332 = 0;
					}
					if (var333.scrollY != var332) {
						var333.scrollY = var332;
						componentUpdated(var333);
					}
				}
				ptype = -1;
				return true;
			}
			if (ptype == 26) {
				// IF_SETANGLE
				int var334 = in.g2_alt2();
				int var335 = in.g2();
				int var336 = in.g4_alt1();
				int var337 = in.g2();
				IfType var338 = IfType.get(var336);
				if (var338.modelXan != var334 || var338.modelYan != var337 || var338.modelZoom != var335) {
					var338.modelXan = var334;
					var338.modelYan = var337;
					var338.modelZoom = var335;
					componentUpdated(var338);
				}
				ptype = -1;
				return true;
			}
			if (ptype == 97) {
				// UPDATE_REBOOT_TIMER
				rebootTimer = in.g2_alt2() * 30;
				field2119 = interfaceUpdateNum;
				ptype = -1;
				return true;
			}
			if (ptype == 251) {
				// IF_SETMODEL
				int var339 = in.g2();
				int var340 = in.g4_alt2();
				IfType var341 = IfType.get(var340);
				if (var341.modelType != 1 || var341.modelId != var339) {
					var341.modelType = 1;
					var341.modelId = var339;
					componentUpdated(var341);
				}
				ptype = -1;
				return true;
			}
			if (ptype == 229) {
				// SYNTH_SOUND
				int var342 = in.g2();
				int var343 = in.g1();
				int var344 = in.g2();
				playSynth(var342, var343, var344);
				ptype = -1;
				return true;
			}
			if (ptype == 142) {
				// UPDATE_IGNORELIST
				while (in.pos < psize) {
					int var348 = in.g1();
					boolean var349 = (var348 & 0x1) == 1;
					String var350 = in.gjstr();
					String var351 = in.gjstr();
					in.gjstr();
					for (int var352 = 0; var352 < ignoreCount; var352++) {
						IgnoreListEntry var353 = ignoreList[var352];
						if (var349) {
							if (var351.equals(var353.name)) {
								var353.name = var350;
								var353.displayName = var351;
								var350 = null;
								break;
							}
						} else if (var350.equals(var353.name)) {
							var353.name = var350;
							var353.displayName = var351;
							var350 = null;
							break;
						}
					}
					if (var350 != null && ignoreCount < 100) {
						IgnoreListEntry var354 = new IgnoreListEntry();
						ignoreList[ignoreCount] = var354;
						var354.name = var350;
						var354.displayName = var351;
						ignoreCount++;
					}
				}
				friendSystemUpdateNum = interfaceUpdateNum;
				ptype = -1;
				return true;
			}
			if (ptype == 171) {
				// IF_SETPLAYERHEAD
				int var355 = in.g4_alt3();
				IfType var356 = IfType.get(var355);
				var356.modelType = 3;
				var356.modelId = localPlayer.model.method1176();
				componentUpdated(var356);
				ptype = -1;
				return true;
			}
			if (ptype == 198) {
				// CAM_RESET
				cinemaCam = false;
				for (int i = 0; i < 5; i++) {
					camShake[i] = false;
				}

				ptype = -1;
				return true;
			}
			if (ptype == 211) {
				// MIDI_SONG
				int var358 = in.g2_alt1();
				if (var358 == 65535) {
					var358 = -1;
				}
				playSongs(var358);
				ptype = -1;
				return true;
			}
			if (ptype == 53) {
				// MIDI_JINGLE
				int var359 = in.g2_alt2();
				if (var359 == 65535) {
					var359 = -1;
				}
				int var360 = in.g3_alt2();
				playJingle(var359, var360);
				ptype = -1;
				return true;
			}
			if (ptype == 111) {
				// VARP_SYNC (unofficial name)
				for (int i = 0; i < VarCache.var.length; i++) {
					if (VarCache.varServ[i] != VarCache.var[i]) {
						VarCache.var[i] = VarCache.varServ[i];
						clientVar(i);
						field2110[++field2084 - 1 & 0x1F] = i;
					}
				}
				ptype = -1;
				return true;
			}
			if (ptype == 167) {
				// NPC_INFO
				getNpcPos();
				ptype = -1;
				return true;
			}
			if (ptype == 197) {
				// IF_SETTEXT
				String var377 = in.gjstr();
				int var378 = in.g4_alt3();
				IfType var379 = IfType.get(var378);
				if (!var377.equals(var379.text)) {
					var379.text = var377;
					componentUpdated(var379);
				}
				ptype = -1;
				return true;
			}

			JagException.report("T1 - " + ptype + "," + ptype1 + "," + ptype2 + " - " + psize, null);
			logout();
		} catch (IOException ex) {
			lostCon();
		} catch (Exception ex) {
			String var382 = "T2 - " + ptype + "," + ptype1 + "," + ptype2 + " - " + psize + "," + (mapBuildBaseX + localPlayer.routeX[0]) + "," + (mapBuildBaseZ + localPlayer.routeZ[0]) + " - ";
			for (int var383 = 0; var383 < psize && var383 < 50; var383++) {
				var382 += in.data[var383] + ",";
			}
			JagException.report(var382, ex);
			logout();
		}

		return true;
	}

	public static void gameDraw() {
		if (!isMenuOpen) {
			menuVerb[0] = Text.CANCEL;
			menuSubject[0] = "";
			menuAction[0] = 1006;
			menuNumEntries = 1;
		}
		if (toplevelinterface != -1) {
			animateInterface(toplevelinterface);
		}
		for (int var15 = 0; var15 < componentDrawCount; var15++) {
			if (componentRedrawRequested1[var15]) {
				componentRedrawRequested2[var15] = true;
			}
			componentDrawSomething2[var15] = componentRedrawRequested1[var15];
			componentRedrawRequested1[var15] = false;
		}
		componentDrawTime = loopCycle;
		minimenuMouseOverX = -1;
		minimenuMouseOverY = -1;
		hoveredSlotParent = null;
		if (toplevelinterface != -1) {
			componentDrawCount = 0;
			drawInterface(toplevelinterface, 0, 0, 765, 503, 0, 0, -1);
		}
		Pix2D.resetClipping();
		imethod24();
		if (isMenuOpen) {
			drawMinimenu();
		} else if (minimenuMouseOverX != -1) {
			imethod27(minimenuMouseOverX, minimenuMouseOverY);
		}
		if (componentDrawMode == 3) {
			for (int var42 = 0; var42 < componentDrawCount; var42++) {
				if (componentDrawSomething2[var42]) {
					Pix2D.fillRectTrans(componentDrawX[var42], componentDrawY[var42], componentDrawWidth[var42], componentDrawHeight[var42], 0xff00ff, 0x80);
				} else if (componentRedrawRequested2[var42]) {
					Pix2D.fillRectTrans(componentDrawX[var42], componentDrawY[var42], componentDrawWidth[var42], componentDrawHeight[var42], 0xff0000, 0x80);
				}
			}
		}
		BgSound.method2297(minusedlevel, localPlayer.x, localPlayer.z, worldUpdateNum);
		worldUpdateNum = 0;
	}

	// jag::oldscape::Client::AnimateInterface
	public static void animateInterface(int var14) {
		if (IfType.openInterface(var14)) {
			animateLayer(IfType.list[var14], -1);
		}
	}

	public static void imethod24() {
		boolean var16 = false;
		while (!var16) {
			var16 = true;
			for (int var17 = 0; var17 < menuNumEntries - 1; var17++) {
				if (menuAction[var17] < 1000 && menuAction[var17 + 1] > 1000) {
					String var18 = menuSubject[var17];
					menuSubject[var17] = menuSubject[var17 + 1];
					menuSubject[var17 + 1] = var18;
					String var19 = menuVerb[var17];
					menuVerb[var17] = menuVerb[var17 + 1];
					menuVerb[var17 + 1] = var19;
					int var20 = menuAction[var17];
					menuAction[var17] = menuAction[var17 + 1];
					menuAction[var17 + 1] = var20;
					int var21 = menuParamB[var17];
					menuParamB[var17] = menuParamB[var17 + 1];
					menuParamB[var17 + 1] = var21;
					int var22 = menuParamC[var17];
					menuParamC[var17] = menuParamC[var17 + 1];
					menuParamC[var17 + 1] = var22;
					int var23 = menuParamA[var17];
					menuParamA[var17] = menuParamA[var17 + 1];
					menuParamA[var17 + 1] = var23;
					var16 = false;
				}
			}
		}
	}

	public static void drawMinimenu() {
		int var27 = menuX;
		int var28 = menuY;
		int var29 = menuWidth;
		int var30 = menuHeight;
		int var31 = 0x5d5447;
		Pix2D.fillRect(var27, var28, var29, var30, var31);
		Pix2D.fillRect(var27 + 1, var28 + 1, var29 - 2, 16, 0);
		Pix2D.drawRect(var27 + 1, var28 + 18, var29 - 2, var30 - 19, 0);
		fontBold12.drawString(Text.CHOOSEOPTION, var27 + 3, var28 + 14, var31, -1);
		int var32 = JavaMouseProvider.mouseX;
		int var33 = JavaMouseProvider.mouseY;
		for (int var34 = 0; var34 < menuNumEntries; var34++) {
			int var35 = (menuNumEntries - 1 - var34) * 15 + var28 + 31;
			int var36 = 0xffffff;
			if (var32 > var27 && var32 < var27 + var29 && var33 > var35 - 13 && var33 < var35 + 3) {
				var36 = 0xffff00;
			}
			fontBold12.drawString(getLine(var34), var27 + 3, var35, var36, 0);
		}
		imethod26(menuX, menuY, menuWidth, menuHeight);
	}

	public static void imethod26(int var37, int var38, int var39, int var40) {
		for (int var41 = 0; var41 < componentDrawCount; var41++) {
			if (componentDrawWidth[var41] + componentDrawX[var41] > var37 && componentDrawX[var41] < var37 + var39 && componentDrawHeight[var41] + componentDrawY[var41] > var38 && componentDrawY[var41] < var38 + var40) {
				componentRedrawRequested2[var41] = true;
			}
		}
	}

	public static void imethod27(int var24, int var25) {
		if (menuNumEntries < 2 && useMode == 0 && !targetMode) {
			return;
		}
		String var26;
		if (useMode == 1 && menuNumEntries < 2) {
			var26 = Text.USE + Text.MINISEPARATOR + field2078 + " " + StringConstants.TAG_ARROW;
		} else if (targetMode && menuNumEntries < 2) {
			var26 = targetVerb + Text.MINISEPARATOR + targetOp + " " + StringConstants.TAG_ARROW;
		} else {
			var26 = getLine(menuNumEntries - 1);
		}
		if (menuNumEntries > 2) {
			var26 = var26 + StringConstants.TAG_COLOUR(0xffffff) + " " + '/' + " " + (menuNumEntries - 2) + Text.MOREOPTIONS;
		}
		fontBold12.method2828(var26, var24 + 4, var25 + 15, 0xffffff, 0, loopCycle / 1000);
	}

	// jag::oldscape::Client::GlCheckMinimap
	public static void checkMinimap() {
		if (lowMemory && sceneState != minusedlevel) {
			startRebuild(mapBuildCenterZoneX, mapBuildCenterZoneZ, minusedlevel, localPlayer.routeX[0], localPlayer.routeZ[0]);
		} else if (minimapLevel != minusedlevel) {
			minimapLevel = minusedlevel;

			// todo: minimapBuildBuffer inlined:
			int var402 = minusedlevel;
			int[] var403 = minimap.data;
			int var404 = var403.length;
			for (int var405 = 0; var405 < var404; var405++) {
				var403[var405] = 0;
			}
			int var406 = 1;
			while (true) {
				if (var406 >= 103) {
					int var409 = ((int) (Math.random() * 20.0D) + 238 - 10 << 16) + ((int) (Math.random() * 20.0D) + 238 - 10 << 8) + ((int) (Math.random() * 20.0D) + 238 - 10);
					int var410 = (int) (Math.random() * 20.0D) + 238 - 10 << 16;
					minimap.setPixels();
					for (int var411 = 1; var411 < 103; var411++) {
						for (int var412 = 1; var412 < 103; var412++) {
							if ((ClientBuild.mapl[var402][var412][var411] & 0x18) == 0) {
								drawDetail(var402, var412, var411, var409, var410);
							}
							if (var402 < 3 && (ClientBuild.mapl[var402 + 1][var412][var411] & 0x8) != 0) {
								drawDetail(var402 + 1, var412, var411, var409, var410);
							}
						}
					}
					activeMapFunctionCount = 0;
					for (int var413 = 0; var413 < 104; var413++) {
						for (int var414 = 0; var414 < 104; var414++) {
							int var415 = world.gdType(minusedlevel, var413, var414);
							if (var415 == 0) {
								continue;
							}
							int var416 = var415 >> 14 & 0x7FFF;
							int var417 = LocType.list(var416).mapfunction;
							if (var417 < 0) {
								continue;
							}
							int var418 = var413;
							int var419 = var414;
							if (var417 != 22 && var417 != 29 && var417 != 34 && var417 != 36 && var417 != 46 && var417 != 47 && var417 != 48) {
								int[][] var420 = levelCollisionMap[minusedlevel].flags;
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
							activeMapFunctions[activeMapFunctionCount] = mapfunction[var417];
							activeMapFunctionX[activeMapFunctionCount] = var418;
							activeMapFunctionZ[activeMapFunctionCount] = var419;
							activeMapFunctionCount++;
						}
					}
					GameShell.drawArea.bind();
					break;
				}
				int var407 = (103 - var406) * 2048 + 24628;
				for (int var408 = 1; var408 < 103; var408++) {
					if ((ClientBuild.mapl[var402][var408][var406] & 0x18) == 0) {
						world.render2DGround(var403, var407, 512, var402, var408, var406);
					}
					if (var402 < 3 && (ClientBuild.mapl[var402 + 1][var408][var406] & 0x8) != 0) {
						world.render2DGround(var403, var407, 512, var402 + 1, var408, var406);
					}
					var407 += 4;
				}
				var406++;
			}
		}
	}

	// jag::oldscape::Client::LocChangeDoQueue
	public static void locChangeDoQueue() {
		for (LocChange var423 = (LocChange) locChanges.head(); var423 != null; var423 = (LocChange) locChanges.next()) {
			if (var423.endTime > 0) {
				var423.endTime--;
			}
			if (var423.endTime != 0) {
				if (var423.startTime > 0) {
					var423.startTime--;
				}
				if (var423.startTime == 0 && var423.x >= 1 && var423.z >= 1 && var423.x <= 102 && var423.z <= 102 && (var423.newType < 0 || ClientBuild.changeLocAvailable(var423.newType, var423.newShape))) {
					locChangeUnchecked(var423.level, var423.layer, var423.x, var423.z, var423.newType, var423.newAngle, var423.newShape);
					var423.startTime = -1;
					if (var423.newType == var423.oldType && var423.oldType == -1) {
						var423.unlink();
					} else if (var423.newType == var423.oldType && var423.newAngle == var423.oldAngle && var423.oldShape == var423.newShape) {
						var423.unlink();
					}
				}
			} else if (var423.oldType < 0 || ClientBuild.changeLocAvailable(var423.oldType, var423.oldShape)) {
				locChangeUnchecked(var423.level, var423.layer, var423.x, var423.z, var423.oldType, var423.oldAngle, var423.oldShape);
				var423.unlink();
			}
		}
	}

	// jag::oldscape::Client::GlDoSoundsQueue
	public static void soundsDoQueue() {
		for (int i = 0; i < waveCount; i++) {
			waveDelay[i]--;

			if (waveDelay[i] >= -10) {
				JagFx sound = waveSounds[i];

				if (sound == null) {
					sound = JagFx.load(jagFX, waveSoundIds[i], 0);
					if (sound == null) {
						continue;
					}

					waveDelay[i] += sound.optimiseStart();
					waveSounds[i] = sound;
				}

				if (waveDelay[i] < 0) {
					int finalVolume;
					if (waveAmbient[i] != 0) {
						// jag::oldscape::Client::GetFinalAmbientVolume
						int var427 = (waveAmbient[i] & 0xFF) * 128;

						int var428 = waveAmbient[i] >> 16 & 0xFF;
						int var429 = var428 * 128 + 64 - localPlayer.x;
						if (var429 < 0) {
							var429 = -var429;
						}

						int var430 = waveAmbient[i] >> 8 & 0xFF;
						int var431 = var430 * 128 + 64 - localPlayer.z;
						if (var431 < 0) {
							var431 = -var431;
						}

						int var432 = var429 + var431 - 128;
						if (var432 > var427) {
							waveDelay[i] = -100;
							continue;
						}

						if (var432 < 0) {
							var432 = 0;
						}

						finalVolume = ambientVolume * (var427 - var432) / var427;
					} else {
						// jag::oldscape::Client::GetFinalWaveVolume
						finalVolume = waveVolume;
					}

					if (finalVolume > 0) {
						Wave wave = sound.toWave().decimate(soundDecimator);
						WaveStream stream = WaveStream.newRatePercent(wave, 100, finalVolume);
						stream.setLoopCount(waveLoops[i] - 1);
						soundMixer.playStream(stream);
					}

					waveDelay[i] = -100;
				}
			} else {
				waveCount--;

				for (int j = i; j < waveCount; j++) {
					waveSoundIds[j] = waveSoundIds[j + 1];
					waveSounds[j] = waveSounds[j + 1];
					waveLoops[j] = waveLoops[j + 1];
					waveDelay[j] = waveDelay[j + 1];
					waveAmbient[j] = waveAmbient[j + 1];
				}

				i--;
			}
		}

		if (field2189 && !MidiManager.method2456()) {
			if (midiVolume != 0 && previousSong != -1) {
				MidiManager.method1125(songs, previousSong, 0, midiVolume, false);
			}

			field2189 = false;
		}
	}

	// jag::oldscape::Client::LoopIf3Drag
	public static void loopIf3Drag() {
		componentUpdated(dragComponent);
		dragTime++;

		if (dragging && dragParentFound) {
			int var458 = JavaMouseProvider.mouseX;
			int var459 = JavaMouseProvider.mouseY;

			int var460 = var458 - dragPickupX;
			int var461 = var459 - dragPickupY;

			if (var460 < dragParentX) {
				var460 = dragParentX;
			}
			if (dragComponent.renderwidth + var460 > dragParentX + dragParent.renderwidth) {
				var460 = dragParentX + dragParent.renderwidth - dragComponent.renderwidth;
			}

			if (var461 < dragParentY) {
				var461 = dragParentY;
			}
			if (dragComponent.renderheight + var461 > dragParentY + dragParent.renderheight) {
				var461 = dragParentY + dragParent.renderheight - dragComponent.renderheight;
			}

			int var462 = var460 - dragCurrentX;
			int var463 = var461 - dragCurrentY;
			int var464 = dragComponent.dragdeadzone;
			if (dragTime > dragComponent.dragdeadtime && (var462 > var464 || var462 < -var464 || var463 > var464 || var463 < -var464)) {
				dragAlive = true;
			}

			int var465 = dragParent.scrollX + (var460 - dragParentX);
			int var466 = dragParent.scrollY + (var461 - dragParentY);

			if (dragComponent.ondrag != null && dragAlive) {
				HookReq req = new HookReq();
				req.component = dragComponent;
				req.mouseX = var465;
				req.mouseY = var466;
				req.onop = dragComponent.ondrag;
				ScriptRunner.executeScript(req);
			}

			if (JavaMouseProvider.mouseButton == 0) {
				if (dragAlive) {
					if (dragComponent.ondragcomplete != null) {
						HookReq req = new HookReq();
						req.component = dragComponent;
						req.mouseX = var465;
						req.mouseY = var466;
						req.drop = dropComponent;
						req.onop = dragComponent.ondragcomplete;
						ScriptRunner.executeScript(req);
					}

					if (dropComponent != null) {
						// todo: inlined method (ServerDraggable?)
						IfType var469 = dragComponent;
						int var470 = ServerActive.serverDraggable(getActive(var469));
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
							// IF_BUTTOND
							out.p1Enc(22);
							out.p2_alt3(dragComponent.subid);
							out.p4_alt2(dropComponent.parentlayer);
							out.p2_alt1(dropComponent.subid);
							out.p4_alt2(dragComponent.parentlayer);
						}
					}
				} else if ((oneMouseButton == 1 || isAddFriendOption(menuNumEntries - 1)) && menuNumEntries > 2) {
					openMenu();
				} else if (menuNumEntries > 0) {
					doAction(menuNumEntries - 1);
				}

				dragComponent = null;
			}
		} else if (dragTime > 1) {
			dragComponent = null;
		}
	}

	public static void handleMouseInput() {
		if (objDragInterface != null || dragComponent != null) {
			return;
		}

		int button = JavaMouseProvider.mouseClickButton;
		if (isMenuOpen) {
			if (button == 1) {
				int var479 = menuX;
				int var480 = menuY;
				int var481 = menuWidth;

				int var482 = JavaMouseProvider.mouseClickX;
				int var483 = JavaMouseProvider.mouseClickY;

				int option = -1;
				for (int var485 = 0; var485 < menuNumEntries; var485++) {
					int var486 = (menuNumEntries - 1 - var485) * 15 + var480 + 31;
					if (var482 > var479 && var482 < var479 + var481 && var483 > var486 - 13 && var483 < var486 + 3) {
						option = var485;
					}
				}

				if (option != -1) {
					doAction(option);
				}

				isMenuOpen = false;
				dirtyArea(menuX, menuY, menuWidth, menuHeight);
			} else {
				int var477 = JavaMouseProvider.mouseX;
				int var478 = JavaMouseProvider.mouseY;
				if (var477 < menuX - 10 || var477 > menuWidth + menuX + 10 || var478 < menuY - 10 || var478 > menuY + menuHeight + 10) {
					isMenuOpen = false;
					dirtyArea(menuX, menuY, menuWidth, menuHeight);
				}
			}
		} else {
			if (button == 1 && menuNumEntries > 0) {
				int action = menuAction[menuNumEntries - 1];

				if (action == 39 || action == 40 || action == 41 || action == 42 || action == 43 || action == 33 || action == 34 || action == 35 || action == 36 || action == 37 || action == 38 || action == 1005) {
					int slot = menuParamB[menuNumEntries - 1];
					int comId = menuParamC[menuNumEntries - 1];

					IfType com = IfType.get(comId);
					if (ServerActive.objDraggable(getActive(com)) || ServerActive.objSwappable(getActive(com))) {
						objGrabThreshold = false;
						objDragCycles = 0;
						if (objDragInterface != null) {
							componentUpdated(objDragInterface);
						}
						objDragInterface = IfType.get(comId);
						hoveredSlot = slot;
						objGrabX = JavaMouseProvider.mouseClickX;
						objGrabY = JavaMouseProvider.mouseClickY;
						componentUpdated(objDragInterface);
						return;
					}
				}
			}

			if (button == 1 && (oneMouseButton == 1 && menuNumEntries > 2 || isAddFriendOption(menuNumEntries - 1))) {
				button = 2;
			}

			if (button == 1 && menuNumEntries > 0) {
				doAction(menuNumEntries - 1);
			} else if (button == 2 && menuNumEntries > 0) {
				openMenu();
			}
		}
	}

	// jag::oldscape::Client::GlFollowCamera
	public static void followCamera() {
		int var493 = macroCameraX + localPlayer.x;
		int var494 = macroCameraZ + localPlayer.z;
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
		int var497 = getAvH(orbitCameraX, orbitCameraZ, minusedlevel);
		int var498 = 0;
		if (var495 > 3 && var496 > 3 && var495 < 100 && var496 < 100) {
			for (int var499 = var495 - 4; var499 <= var495 + 4; var499++) {
				for (int var500 = var496 - 4; var500 <= var496 + 4; var500++) {
					int var501 = minusedlevel;
					if (var501 < 3 && (ClientBuild.mapl[1][var499][var500] & 0x2) == 2) {
						var501++;
					}
					int var502 = var497 - ClientBuild.groundh[var501][var499][var500];
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

	public static void gameDrawMain(int var12, int var13, int var31, int var32) {
		Pix2D.setClipping(var12, var13, var12 + var31, var13 + var32);
		Pix3D.setRenderClipping();

		sceneCycle++;

		addPlayers(true);
		addNpcs(true);
		addPlayers(false);
		addNpcs(false);
		addProjectiles();
		addMapAnim();

		if (!cinemaCam) {
			int var33 = orbitCameraPitch;
			if (cameraPitchClamp / 256 > var33) {
				var33 = cameraPitchClamp / 256;
			}
			if (camShake[4] && camShakeRan[4] + 128 > var33) {
				var33 = camShakeRan[4] + 128;
			}
			camFollow(var33, orbitCameraYaw + macroCameraAngle & 0x7FF, orbitCameraX, getAvH(localPlayer.x, localPlayer.z, minusedlevel) - 50, orbitCameraZ, var33 * 3 + 600);
		}

		int var62;
		if (cinemaCam) {
			var62 = roofCheck2();
		} else {
			var62 = roofCheck();
		}

		int var65 = camX;
		int var66 = camY;
		int var67 = camZ;
		int var68 = camPitch;
		int var69 = camYaw;

		for (int var70 = 0; var70 < 5; var70++) {
			if (!camShake[var70]) {
				continue;
			}

			int var71 = (int) (Math.random() * (double) (camShakeAxis[var70] * 2 + 1) - (double) camShakeAxis[var70] + Math.sin((double) camShakeAmp[var70] / 100.0D * (double) camShakeCycle[var70]) * (double) camShakeRan[var70]);
			if (var70 == 0) {
				camX += var71;
			}
			if (var70 == 1) {
				camY += var71;
			}
			if (var70 == 2) {
				camZ += var71;
			}
			if (var70 == 3) {
				camYaw = camYaw + var71 & 0x7FF;
			}
			if (var70 == 4) {
				camPitch += var71;
				if (camPitch < 128) {
					camPitch = 128;
				}
				if (camPitch > 383) {
					camPitch = 383;
				}
			}
		}

		int var72 = JavaMouseProvider.mouseX;
		int var73 = JavaMouseProvider.mouseY;

		if (var72 >= var12 && var72 < var12 + var31 && var73 >= var13 && var73 < var13 + var32) {
			ModelLit.checkHover = true;
			ModelLit.pickedCount = 0;
			ModelLit.mouseX = JavaMouseProvider.mouseX - var12;
			ModelLit.mouseY = JavaMouseProvider.mouseY - var13;
		} else {
			ModelLit.checkHover = false;
			ModelLit.pickedCount = 0;
		}

		flushAudio();
		Pix2D.fillRect(var12, var13, var31, var32, 0);

		flushAudio();
		world.renderAll(camX, camY, camZ, camPitch, camYaw, var62);

		flushAudio();
		world.removeSprites();

		entityOverlays(var12, var13, var31, var32);
		coordArrow(var12, var13);
		((WorldTextureProvider) Pix3D.textureProvider).runAnims(worldUpdateNum);
		otherOverlays(var12, var13, var31, var32);

		camX = var65;
		camY = var66;
		camZ = var67;
		camPitch = var68;
		camYaw = var69;

		if (field1921 && Js5Net.urgentQueueSize() == 0) {
			field1921 = false;
		}

		if (field1921) {
			Pix2D.fillRect(var12, var13, var31, var32, 0);
			messageBox(Text.LOADING, false);
		}

		if (!field1921 && !isMenuOpen && var72 >= var12 && var72 < var12 + var31 && var73 >= var13 && var73 < var13 + var32) {
			imethod41(var12, var13, var72, var73);
		}
	}

	public static void imethod35(IfType var10, int var129, int var130) {
		if (var10.buttonType == 1) {
			addMenuOption(var10.option, "", 24, 0, 0, var10.parentlayer);
		}
		if (var10.buttonType == 2 && !targetMode) {
			String var131;
			if (ServerActive.targetMask(getActive(var10)) == 0) {
				var131 = null;
			} else if (var10.targetVerb == null || var10.targetVerb.trim().length() == 0) {
				var131 = null;
			} else {
				var131 = var10.targetVerb;
			}
			if (var131 != null) {
				addMenuOption(var131, StringConstants.TAG_COLOUR(65280) + var10.targetText, 25, 0, -1, var10.parentlayer);
			}
		}
		if (var10.buttonType == 3) {
			addMenuOption(Text.CLOSE, "", 26, 0, 0, var10.parentlayer);
		}
		if (var10.buttonType == 4) {
			addMenuOption(var10.option, "", 28, 0, 0, var10.parentlayer);
		}
		if (var10.buttonType == 5) {
			addMenuOption(var10.option, "", 29, 0, 0, var10.parentlayer);
		}
		if (var10.buttonType == 6 && resumedPauseButton == null) {
			addMenuOption(var10.option, "", 30, 0, -1, var10.parentlayer);
		}
		if (var10.type == 2) {
			int var133 = 0;
			for (int var134 = 0; var134 < var10.renderheight; var134++) {
				for (int var135 = 0; var135 < var10.renderwidth; var135++) {
					int var136 = (var10.marginX + 32) * var135;
					int var137 = (var10.marginY + 32) * var134;
					if (var133 < 20) {
						var136 += var10.invBackgroundX[var133];
						var137 += var10.invBackgroundY[var133];
					}
					if (var129 >= var136 && var130 >= var137 && var129 < var136 + 32 && var130 < var137 + 32) {
						objDragSlot = var133;
						hoveredSlotParent = var10;
						if (var10.linkObjType[var133] > 0) {
							label1831:
							{
								ObjType var138 = ObjType.list(var10.linkObjType[var133] - 1);
								if (useMode == 1) {
									int var139 = getActive(var10);
									boolean var140 = (var139 >> 30 & 0x1) != 0;
									if (var140) {
										if (field502 != var10.parentlayer || field557 != var133) {
											addMenuOption(Text.USE, field2078 + " " + StringConstants.TAG_ARROW + " " + StringConstants.TAG_COLOUR(16748608) + var138.name, 31, var138.index, var133, var10.parentlayer);
										}
										break label1831;
									}
								}
								if (targetMode) {
									int var141 = getActive(var10);
									boolean var142 = (var141 >> 30 & 0x1) != 0;
									if (var142) {
										if ((targetMask & 0x10) == 16) {
											addMenuOption(targetVerb, targetOp + " " + StringConstants.TAG_ARROW + " " + StringConstants.TAG_COLOUR(16748608) + var138.name, 32, var138.index, var133, var10.parentlayer);
										}
										break label1831;
									}
								}
								String[] var143 = var138.iop;
								if (field2001) {
									var143 = method726(var143);
								}
								int var144 = getActive(var10);
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
											addMenuOption(var143[var146], StringConstants.TAG_COLOUR(16748608) + var138.name, var147, var138.index, var133, var10.parentlayer);
										} else if (var146 == 4) {
											addMenuOption(Text.DROP, StringConstants.TAG_COLOUR(16748608) + var138.name, 37, var138.index, var133, var10.parentlayer);
										}
									}
								}
								int var148 = getActive(var10);
								boolean var149 = (var148 >> 31 & 0x1) != 0;
								if (var149) {
									addMenuOption(Text.USE, StringConstants.TAG_COLOUR(16748608) + var138.name, 38, var138.index, var133, var10.parentlayer);
								}
								int var150 = getActive(var10);
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
											addMenuOption(var143[var152], StringConstants.TAG_COLOUR(16748608) + var138.name, var153, var138.index, var133, var10.parentlayer);
										}
									}
								}
								String[] var154 = var10.iop;
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
											addMenuOption(var154[var155], StringConstants.TAG_COLOUR(16748608) + var138.name, var156, var138.index, var133, var10.parentlayer);
										}
									}
								}
								addMenuOption(Text.EXAMINE, StringConstants.TAG_COLOUR(16748608) + var138.name, 1005, var138.index, var133, var10.parentlayer);
							}
						}
					}
					var133++;
				}
			}
		}
		if (var10.v3) {
			if (targetMode) {
				int var157 = getActive(var10);
				boolean var158 = (var157 >> 21 & 0x1) != 0;
				if (var158 && (targetMask & 0x20) == 32) {
					addMenuOption(targetVerb, targetOp + " " + StringConstants.TAG_ARROW + " " + var10.opbase, 58, 0, var10.subid, var10.parentlayer);
				}
			} else {
				for (int var159 = 9; var159 >= 5; var159--) {
					String var160 = method513(var10, var159);
					if (var160 != null) {
						addMenuOption(var160, var10.opbase, 1007, var159 + 1, var10.subid, var10.parentlayer);
					}
				}
				String var161 = targetVerb(var10);
				if (var161 != null) {
					addMenuOption(var161, var10.opbase, 25, 0, var10.subid, var10.parentlayer);
				}
				for (int var162 = 4; var162 >= 0; var162--) {
					String var163 = method513(var10, var162);
					if (var163 != null) {
						addMenuOption(var163, var10.opbase, 57, var162 + 1, var10.subid, var10.parentlayer);
					}
				}
				if (ServerActive.pauseButton(getActive(var10))) {
					addMenuOption(Text.CONTINUE, "", 30, 0, var10.subid, var10.parentlayer);
				}
			}
		}
	}

	// jag::oldscape::Client::DrawScrollbar
	public static void drawScrollbar(int var13, int var165, int var166, int var167, int var168) {
		scrollbar[0].plotSprite(var165, var13);
		scrollbar[1].plotSprite(var165, var13 + var167 - 16);
		Pix2D.fillRect(var165, var13 + 16, 16, var167 - 32, SCROLLBAR_TRACK);
		int var169 = (var167 - 32) * var167 / var168;
		if (var169 < 8) {
			var169 = 8;
		}
		int var170 = (var167 - 32 - var169) * var166 / (var168 - var167);
		Pix2D.fillRect(var165, var13 + 16 + var170, 16, var169, SCROLLBAR_GRIP_FOREGROUND);
		Pix2D.vline(var165, var13 + 16 + var170, var169, SCROLLBAR_GRIP_HIGHLIGHT);
		Pix2D.vline(var165 + 1, var13 + 16 + var170, var169, SCROLLBAR_GRIP_HIGHLIGHT);
		Pix2D.hline(var165, var13 + 16 + var170, 16, SCROLLBAR_GRIP_HIGHLIGHT);
		Pix2D.hline(var165, var13 + 17 + var170, 16, SCROLLBAR_GRIP_HIGHLIGHT);
		Pix2D.vline(var165 + 15, var13 + 16 + var170, var169, SCROLLBAR_GRIP_LOWLIGHT);
		Pix2D.vline(var165 + 14, var13 + 17 + var170, var169 - 1, SCROLLBAR_GRIP_LOWLIGHT);
		Pix2D.hline(var165, var13 + 15 + var170 + var169, 16, SCROLLBAR_GRIP_LOWLIGHT);
		Pix2D.hline(var165 + 1, var13 + 14 + var170 + var169, 15, SCROLLBAR_GRIP_LOWLIGHT);
	}

	// jag::oldscape::Client::GdmEntityOverlays
	public static void entityOverlays(int var12, int var13, int var31, int var32) {
		chatCount = 0;
		for (int var74 = -1; var74 < playerCount + npcCount; var74++) {
			ClientEntity var75;
			if (var74 == -1) {
				var75 = localPlayer;
			} else if (var74 < playerCount) {
				var75 = players[playerIds[var74]];
			} else {
				var75 = npcs[npcIds[var74 - playerCount]];
			}
			if (var75 != null && var75.ready()) {
				if (var75 instanceof ClientNpc) {
					NpcType var76 = ((ClientNpc) var75).type;
					if (var76.multinpc != null) {
						var76 = var76.getMultiNpc();
					}
					if (var76 == null) {
						continue;
					}
				}
				if (var74 >= playerCount) {
					NpcType var79 = ((ClientNpc) var75).type;
					if (var79.multinpc != null) {
						var79 = var79.getMultiNpc();
					}
					if (var79.headicon >= 0 && var79.headicon < headiconsPrayer.length) {
						getOverlayPos(var75, var75.height + 15);
						if (projectX > -1) {
							headiconsPrayer[var79.headicon].plotSprite(projectX + var12 - 12, projectY + var13 - 30);
						}
					}
					if (hintType == 1 && hintNpc == npcIds[var74 - playerCount] && loopCycle % 20 < 10) {
						getOverlayPos(var75, var75.height + 15);
						if (projectX > -1) {
							headiconsHint[0].plotSprite(projectX + var12 - 12, projectY + var13 - 28);
						}
					}
				} else {
					int var77 = 30;
					ClientPlayer var78 = (ClientPlayer) var75;
					if (var78.headiconPk != -1 || var78.headiconPrayer != -1) {
						getOverlayPos(var75, var75.height + 15);
						if (projectX > -1) {
							if (var78.headiconPk != -1) {
								headiconsPk[var78.headiconPk].plotSprite(projectX + var12 - 12, projectY + var13 - var77);
								var77 += 25;
							}
							if (var78.headiconPrayer != -1) {
								headiconsPrayer[var78.headiconPrayer].plotSprite(projectX + var12 - 12, projectY + var13 - var77);
								var77 += 25;
							}
						}
					}
					if (var74 >= 0 && hintType == 10 && hintPlayer == playerIds[var74]) {
						getOverlayPos(var75, var75.height + 15);
						if (projectX > -1) {
							headiconsHint[1].plotSprite(projectX + var12 - 12, projectY + var13 - var77);
						}
					}
				}
				if (var75.chat != null && (var74 >= playerCount || publicChatFilter == 0 || publicChatFilter == 3 || publicChatFilter == 1 && isFriend(((ClientPlayer) var75).name))) {
					getOverlayPos(var75, var75.height);
					if (projectX > -1 && chatCount < MAX_CHATS) {
						chatWidth[chatCount] = fontBold12.stringWid(var75.chat) / 2;
						chatHeight[chatCount] = fontBold12.field2550;
						chatX[chatCount] = projectX;
						chatY[chatCount] = projectY;
						chatColour[chatCount] = var75.field2652;
						chatEffect[chatCount] = var75.field2670;
						chatTimer[chatCount] = var75.chatTimer;
						chats[chatCount] = var75.chat;
						chatCount++;
					}
				}
				if (var75.combatCycle > loopCycle) {
					getOverlayPos(var75, var75.height + 15);
					if (projectX > -1) {
						int var80 = var75.health * 30 / var75.totalHealth;
						if (var80 > 30) {
							var80 = 30;
						}
						Pix2D.fillRect(projectX + var12 - 15, projectY + var13 - 3, var80, 5, 65280);
						Pix2D.fillRect(projectX + var12 - 15 + var80, projectY + var13 - 3, 30 - var80, 5, 16711680);
					}
				}
				for (int var81 = 0; var81 < 4; var81++) {
					if (var75.damageCycles[var81] <= loopCycle) {
						continue;
					}

					getOverlayPos(var75, var75.height / 2);

					if (projectX <= -1) {
						continue;
					}

					if (var81 == 1) {
						projectY -= 20;
					} else if (var81 == 2) {
						projectX -= 15;
						projectY -= 10;
					} else if (var81 == 3) {
						projectX += 15;
						projectY -= 10;
					}

					hitmarks[var75.damageTypes[var81]].plotSprite(projectX + var12 - 12, projectY + var13 - 12);
					fontPlain11.centreString(Integer.toString(var75.damageValues[var81]), projectX + var12 - 1, projectY + var13 + 3, 16777215, 0);
				}
			}
		}
		for (int var82 = 0; var82 < chatCount; var82++) {
			int var83 = chatX[var82];
			int var84 = chatY[var82];
			int var85 = chatWidth[var82];
			int var86 = chatHeight[var82];
			boolean var87 = true;
			while (var87) {
				var87 = false;
				for (int var88 = 0; var88 < var82; var88++) {
					if (var84 + 2 > chatY[var88] - chatHeight[var88] && var84 - var86 < chatY[var88] + 2 && var83 - var85 < chatWidth[var88] + chatX[var88] && var83 + var85 > chatX[var88] - chatWidth[var88] && chatY[var88] - chatHeight[var88] < var84) {
						var84 = chatY[var88] - chatHeight[var88];
						var87 = true;
					}
				}
			}
			projectX = chatX[var82];
			projectY = chatY[var82] = var84;
			String var89 = chats[var82];
			if (chatEffects == 0) {
				int var90 = 16776960;
				if (chatColour[var82] < 6) {
					var90 = CHAT_COLOURS[chatColour[var82]];
				}
				if (chatColour[var82] == 6) {
					var90 = sceneCycle % 20 < 10 ? 16711680 : 16776960;
				}
				if (chatColour[var82] == 7) {
					var90 = sceneCycle % 20 < 10 ? 255 : 65535;
				}
				if (chatColour[var82] == 8) {
					var90 = sceneCycle % 20 < 10 ? 45056 : 8454016;
				}
				if (chatColour[var82] == 9) {
					int var91 = 150 - chatTimer[var82];
					if (var91 < 50) {
						var90 = var91 * 1280 + 16711680;
					} else if (var91 < 100) {
						var90 = 16776960 - (var91 - 50) * 327680;
					} else if (var91 < 150) {
						var90 = (var91 - 100) * 5 + 65280;
					}
				}
				if (chatColour[var82] == 10) {
					int var92 = 150 - chatTimer[var82];
					if (var92 < 50) {
						var90 = var92 * 5 + 16711680;
					} else if (var92 < 100) {
						var90 = 16711935 - (var92 - 50) * 327680;
					} else if (var92 < 150) {
						var90 = (var92 - 100) * 327680 + 255 - (var92 - 100) * 5;
					}
				}
				if (chatColour[var82] == 11) {
					int var93 = 150 - chatTimer[var82];
					if (var93 < 50) {
						var90 = 16777215 - var93 * 327685;
					} else if (var93 < 100) {
						var90 = (var93 - 50) * 327685 + 65280;
					} else if (var93 < 150) {
						var90 = 16777215 - (var93 - 100) * 327680;
					}
				}
				if (chatEffect[var82] == 0) {
					fontBold12.centreString(var89, projectX + var12, projectY + var13, var90, 0);
				}
				if (chatEffect[var82] == 1) {
					fontBold12.centerStringWave(var89, projectX + var12, projectY + var13, var90, 0, sceneCycle);
				}
				if (chatEffect[var82] == 2) {
					fontBold12.method2826(var89, projectX + var12, projectY + var13, var90, 0, sceneCycle);
				}
				if (chatEffect[var82] == 3) {
					fontBold12.method2827(var89, projectX + var12, projectY + var13, var90, 0, sceneCycle, 150 - chatTimer[var82]);
				}
				if (chatEffect[var82] == 4) {
					int var94 = (150 - chatTimer[var82]) * (fontBold12.stringWid(var89) + 100) / 150;
					Pix2D.setSubClipping(projectX + var12 - 50, var13, projectX + var12 + 50, var13 + var32);
					fontBold12.drawString(var89, projectX + var12 + 50 - var94, projectY + var13, var90, 0);
					Pix2D.setClipping(var12, var13, var12 + var31, var13 + var32);
				}
				if (chatEffect[var82] == 5) {
					int var95 = 150 - chatTimer[var82];
					int var96 = 0;
					if (var95 < 25) {
						var96 = var95 - 25;
					} else if (var95 > 125) {
						var96 = var95 - 125;
					}
					Pix2D.setSubClipping(var12, projectY + var13 - fontBold12.field2550 - 1, var12 + var31, projectY + var13 + 5);
					fontBold12.centreString(var89, projectX + var12, projectY + var13 + var96, var90, 0);
					Pix2D.setClipping(var12, var13, var12 + var31, var13 + var32);
				}
			} else {
				fontBold12.centreString(var89, projectX + var12, projectY + var13, 16776960, 0);
			}
		}
	}

	// jag::oldscape::Client::CamFollow
	public static void camFollow(int var33, int var34, int var35, int var36, int var37, int var38) {
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
		camX = var35 - var41;
		camY = var36 - var42;
		camZ = var37 - var43;
		camPitch = var33;
		camYaw = var34;
	}

	// jag::oldscape::Client::GdmRoofCheck2
	public static int roofCheck2() {
		int var63 = getAvH(camX, camZ, minusedlevel);
		if (var63 - camY >= 800 || (ClientBuild.mapl[minusedlevel][camX >> 7][camZ >> 7] & 0x4) == 0) {
			return 3;
		} else {
			return minusedlevel;
		}
	}

	// jag::oldscape::Client::GdmRoofCheck
	public static int roofCheck() {
		int var50 = 3;
		if (camPitch < 310) {
			int var51 = camX >> 7;
			int var52 = camZ >> 7;
			int var53 = localPlayer.x >> 7;
			int var54 = localPlayer.z >> 7;
			if ((ClientBuild.mapl[minusedlevel][var51][var52] & 0x4) != 0) {
				var50 = minusedlevel;
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
					if ((ClientBuild.mapl[minusedlevel][var51][var52] & 0x4) != 0) {
						var50 = minusedlevel;
					}
					var58 += var57;
					if (var58 >= 65536) {
						var58 -= 65536;
						if (var52 < var54) {
							var52++;
						} else if (var52 > var54) {
							var52--;
						}
						if ((ClientBuild.mapl[minusedlevel][var51][var52] & 0x4) != 0) {
							var50 = minusedlevel;
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
					if ((ClientBuild.mapl[minusedlevel][var51][var52] & 0x4) != 0) {
						var50 = minusedlevel;
					}
					var60 += var59;
					if (var60 >= 65536) {
						var60 -= 65536;
						if (var51 < var53) {
							var51++;
						} else if (var51 > var53) {
							var51--;
						}
						if ((ClientBuild.mapl[minusedlevel][var51][var52] & 0x4) != 0) {
							var50 = minusedlevel;
						}
					}
				}
			}
		}
		if ((ClientBuild.mapl[minusedlevel][localPlayer.x >> 7][localPlayer.z >> 7] & 0x4) != 0) {
			var50 = minusedlevel;
		}
		return var50;
	}

	public static void imethod41(int var12, int var13, int var72, int var73) {
		if (useMode == 0 && !targetMode) {
			addMenuOption(Text.WALKHERE, "", 23, 0, var72 - var12, var73 - var13);
		}
		int var100 = -1;
		for (int var101 = 0; var101 < ModelLit.pickedCount; var101++) {
			int var102 = ModelLit.pickedEntityTypecode[var101];
			int var103 = var102 & 0x7F;
			int var104 = var102 >> 7 & 0x7F;
			int var105 = var102 >> 29 & 0x3;
			int var106 = var102 >> 14 & 0x7FFF;
			if (var100 == var102) {
				continue;
			}
			var100 = var102;
			if (var105 == 2 && world.typecode2(minusedlevel, var103, var104, var102) >= 0) {
				LocType var107 = LocType.list(var106);
				if (var107.multiloc != null) {
					var107 = var107.getMultiLoc();
				}
				if (var107 == null) {
					continue;
				}
				if (useMode == 1) {
					addMenuOption(Text.USE, field2078 + " " + StringConstants.TAG_ARROW + " " + StringConstants.TAG_COLOUR(65535) + var107.name, 1, var102, var103, var104);
				} else if (!targetMode) {
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
								addMenuOption(var108[var109], StringConstants.TAG_COLOUR(65535) + var107.name, var110, var102, var103, var104);
							}
						}
					}
					addMenuOption(Text.EXAMINE, StringConstants.TAG_COLOUR(65535) + var107.name, 1002, var107.id << 14, var103, var104);
				} else if ((targetMask & 0x4) == 4) {
					addMenuOption(targetVerb, targetOp + " " + StringConstants.TAG_ARROW + " " + StringConstants.TAG_COLOUR(65535) + var107.name, 2, var102, var103, var104);
				}
			}
			if (var105 == 1) {
				ClientNpc var111 = npcs[var106];
				if (var111.type.size == 1 && (var111.x & 0x7F) == 64 && (var111.z & 0x7F) == 64) {
					for (int var112 = 0; var112 < npcCount; var112++) {
						ClientNpc var113 = npcs[npcIds[var112]];
						if (var113 != null && var111 != var113 && var113.type.size == 1 && var111.x == var113.x && var111.z == var113.z) {
							addNpcOptions(var113.type, npcIds[var112], var103, var104);
						}
					}
					for (int var114 = 0; var114 < playerCount; var114++) {
						ClientPlayer var115 = players[playerIds[var114]];
						if (var115 != null && var111.x == var115.x && var111.z == var115.z) {
							addPlayerOptions(var115, playerIds[var114], var103, var104);
						}
					}
				}
				addNpcOptions(var111.type, var106, var103, var104);
			}
			if (var105 == 0) {
				ClientPlayer var116 = players[var106];
				if ((var116.x & 0x7F) == 64 && (var116.z & 0x7F) == 64) {
					for (int var117 = 0; var117 < npcCount; var117++) {
						ClientNpc var118 = npcs[npcIds[var117]];
						if (var118 != null && var118.type.size == 1 && var116.x == var118.x && var116.z == var118.z) {
							addNpcOptions(var118.type, npcIds[var117], var103, var104);
						}
					}
					for (int var119 = 0; var119 < playerCount; var119++) {
						ClientPlayer var120 = players[playerIds[var119]];
						if (var120 != null && var116 != var120 && var116.x == var120.x && var116.z == var120.z) {
							addPlayerOptions(var120, playerIds[var119], var103, var104);
						}
					}
				}
				addPlayerOptions(var116, var106, var103, var104);
			}
			if (var105 == 3) {
				LinkList var121 = objStacks[minusedlevel][var103][var104];
				if (var121 == null) {
					continue;
				}
				for (ClientObj var122 = (ClientObj) var121.tail(); var122 != null; var122 = (ClientObj) var121.prev()) {
					ObjType var123 = ObjType.list(var122.id);
					if (useMode == 1) {
						addMenuOption(Text.USE, field2078 + " " + StringConstants.TAG_ARROW + " " + StringConstants.TAG_COLOUR(16748608) + var123.name, 16, var122.id, var103, var104);
					} else if (!targetMode) {
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
								addMenuOption(var124[var125], StringConstants.TAG_COLOUR(16748608) + var123.name, var126, var122.id, var103, var104);
							} else if (var125 == 2) {
								addMenuOption(Text.TAKE, StringConstants.TAG_COLOUR(16748608) + var123.name, 20, var122.id, var103, var104);
							}
						}
						addMenuOption(Text.EXAMINE, StringConstants.TAG_COLOUR(16748608) + var123.name, 1004, var122.id, var103, var104);
					} else if ((targetMask & 0x1) == 1) {
						addMenuOption(targetVerb, targetOp + " " + StringConstants.TAG_ARROW + " " + StringConstants.TAG_COLOUR(16748608) + var123.name, 17, var122.id, var103, var104);
					}
				}
			}
		}
	}

	// jag::oldscape::Client::FriendsChatKickUser
	public static void friendsChatKickUser(String var186) {
		if (field1774 == null) {
			return;
		}

		// CLAN_KICKUSER
		out.p1Enc(245);
		out.p1(Packet.pjstrlen(var186));
		out.pjstr(var186);
	}

	// jag::oldscape::FriendSystem::DelIgnore
	public static void delIgnore(String var169) {
		if (var169 == null) {
			return;
		}

		String var170 = DisplayNameTools.toBaseDisplayName(var169, namespace);
		if (var170 == null) {
			return;
		}

		for (int var171 = 0; var171 < ignoreCount; var171++) {
			IgnoreListEntry var172 = ignoreList[var171];
			String var173 = var172.name;
			String var174 = DisplayNameTools.toBaseDisplayName(var173, namespace);

			boolean var175;
			if (var169 == null || var173 == null) {
				var175 = false;
			} else if (var169.startsWith("#") || var173.startsWith("#")) {
				var175 = var169.equals(var173);
			} else {
				var175 = var170.equals(var174);
			}

			if (var175) {
				ignoreCount--;

				for (int var176 = var171; var176 < ignoreCount; var176++) {
					ignoreList[var176] = ignoreList[var176 + 1];
				}

				friendSystemUpdateNum = interfaceUpdateNum;
				// IGNORELIST_DEL
				out.p1Enc(248);
				out.p1(Packet.pjstrlen(var169));
				out.pjstr(var169);
				break;
			}
		}
	}

	// jag::oldscape::FriendSystem::SetFriendRank
	public static void setFriendRank(String var164, int var165) {
		// FRIEND_SETRANK
		out.p1Enc(252);
		out.p1(Packet.pjstrlen(var164) + 1);
		out.pjstr(var164);
		out.p1_alt1(var165);
	}

	// jag::oldscape::Client::PlayJingle
	public static void playJingle(int var113, int var114) {
		if (midiVolume == 0 || var113 == -1) {
			return;
		}

		MidiManager.method1125(jingles, var113, 0, midiVolume, false);
		field2189 = true;
	}

	// jag::oldscape::Client::PlaySynth
	public static void playSynth(int sound, int loops, int delay) {
		if (waveVolume == 0 || loops == 0 || waveCount >= 50) {
			return;
		}

		waveSoundIds[waveCount] = sound;
		waveLoops[waveCount] = loops;
		waveDelay[waveCount] = delay;
		waveSounds[waveCount] = null;
		waveAmbient[waveCount] = 0;
		waveCount++;
	}

	// jag::oldscape::Client::CloseModal
	public static void closeModal() {
		// CLOSE_MODAL
		out.p1Enc(129);

		for (SubInterface sub = (SubInterface) subinterfaces.first(); sub != null; sub = (SubInterface) subinterfaces.next()) {
			if (sub.type == 0 || sub.type == 3) {
				closeSubInterface(sub, true);
			}
		}

		if (resumedPauseButton != null) {
			componentUpdated(resumedPauseButton);
			resumedPauseButton = null;
		}
	}

	public static int imethod48(Js5Loader var25, Js5Loader var26) {
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
		return var27;
	}

	public static void prepareMinimap() {
		compassMaskLineOffsets = new int[33];
		compassMaskLineLengths = new int[33];

		minimapMaskLineOffsets = new int[151];
		minimapMaskLineLengths = new int[151];

		for (int var47 = 0; var47 < 33; var47++) {
			int var48 = 999;
			int var49 = 0;
			for (int var50 = 0; var50 < 34; var50++) {
				if (mapback.data[mapback.wi * var47 + var50] == 0) {
					if (var48 == 999) {
						var48 = var50;
					}
				} else if (var48 != 999) {
					var49 = var50;
					break;
				}
			}
			compassMaskLineOffsets[var47] = var48;
			compassMaskLineLengths[var47] = var49 - var48;
		}

		for (int var51 = 5; var51 < 156; var51++) {
			int var52 = 999;
			int var53 = 0;
			for (int var54 = 25; var54 < 172; var54++) {
				if (mapback.data[mapback.wi * var51 + var54] == 0 && (var54 > 34 || var51 > 34)) {
					if (var52 == 999) {
						var52 = var54;
					}
				} else if (var52 != 999) {
					var53 = var54;
					break;
				}
			}
			minimapMaskLineOffsets[var51 - 5] = var52 - 25;
			minimapMaskLineLengths[var51 - 5] = var53 - var52;
		}
	}

	public static void setHighMemory() {
		World.lowMem = false;
		lowMemory = false;
	}

	// not exposed as an option anymore :(
	public static void setLowMemory() {
		World.lowMem = true;
		lowMemory = true;
	}
}
