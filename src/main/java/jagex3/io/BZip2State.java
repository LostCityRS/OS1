package jagex3.io;

import deob.ObfuscatedName;

@ObfuscatedName("bg")
public class BZip2State {

	@ObfuscatedName("bg.x")
	public static int[] tt;

	@ObfuscatedName("bg.r")
	public final int MTFA_SIZE = 4096;

	@ObfuscatedName("bg.d")
	public final int MTFL_SIZE = 16;

	@ObfuscatedName("bg.l")
	public final int BZ_MAX_ALPHA_SIZE = 258;

	@ObfuscatedName("bg.m")
	public final int BZ_N_GROUPS = 6;

	@ObfuscatedName("bg.c")
	public final int BZ_G_SIZE = 50;

	@ObfuscatedName("bg.n")
	public final int BZ_MAX_SELECTORS = 18002;

	@ObfuscatedName("bg.j")
	public byte[] stream;

	@ObfuscatedName("bg.z")
	public int next_in = 0;

	@ObfuscatedName("bg.g")
	public int total_in_lo32;

	@ObfuscatedName("bg.q")
	public byte[] decompressed;

	@ObfuscatedName("bg.i")
	public int next_out = 0;

	@ObfuscatedName("bg.s")
	public int avail_out;

	@ObfuscatedName("bg.u")
	public int total_out_lo32;

	@ObfuscatedName("bg.v")
	public byte state_out_ch;

	@ObfuscatedName("bg.w")
	public int state_out_len;

	@ObfuscatedName("bg.e")
	public int bsBuff;

	@ObfuscatedName("bg.b")
	public int bsLive;

	@ObfuscatedName("bg.y")
	public int blockSize100k;

	@ObfuscatedName("bg.t")
	public int origPtr;

	@ObfuscatedName("bg.f")
	public int tPos;

	@ObfuscatedName("bg.k")
	public int k0;

	@ObfuscatedName("bg.o")
	public int[] unzftab = new int[256];

	@ObfuscatedName("bg.a")
	public int c_nblock_used;

	@ObfuscatedName("bg.h")
	public int[] cftab = new int[257];

	@ObfuscatedName("bg.p")
	public int nInUse;

	@ObfuscatedName("bg.ad")
	public boolean[] inUse = new boolean[256];

	@ObfuscatedName("bg.ac")
	public boolean[] inUse16 = new boolean[16];

	@ObfuscatedName("bg.aa")
	public byte[] seqToUnseq = new byte[256];

	@ObfuscatedName("bg.as")
	public byte[] mtfa = new byte[4096];

	@ObfuscatedName("bg.am")
	public int[] mtfbase = new int[16];

	@ObfuscatedName("bg.ap")
	public byte[] selector = new byte[18002];

	@ObfuscatedName("bg.av")
	public byte[] selectorMtf = new byte[18002];

	@ObfuscatedName("bg.ak")
	public byte[][] len = new byte[6][258];

	@ObfuscatedName("bg.az")
	public int[][] limit = new int[6][258];

	@ObfuscatedName("bg.an")
	public int[][] base = new int[6][258];

	@ObfuscatedName("bg.ah")
	public int[][] perm = new int[6][258];

	@ObfuscatedName("bg.ay")
	public int[] minLens = new int[6];

	@ObfuscatedName("bg.al")
	public int save_nblock;
}
