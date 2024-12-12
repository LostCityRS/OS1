package jagex3.midi;

import deob.ObfuscatedName;
import jagex3.datastruct.IntUtil;

@ObfuscatedName("e")
public class VorbisFloor {

	@ObfuscatedName("e.r")
	public static final int[] field219 = new int[] { 256, 128, 86, 64 };

	@ObfuscatedName("e.d")
	public static final float[] inverse_db_table = new float[] {
		1.0649863e-07f, 1.1341951e-07f, 1.2079015e-07f, 1.2863978e-07f,
		1.3699951e-07f, 1.4590251e-07f, 1.5538408e-07f, 1.6548181e-07f,
		1.7623575e-07f, 1.8768855e-07f, 1.9988561e-07f, 2.1287530e-07f,
		2.2670913e-07f, 2.4144197e-07f, 2.5713223e-07f, 2.7384213e-07f,
		2.9163793e-07f, 3.1059021e-07f, 3.3077411e-07f, 3.5226968e-07f,
		3.7516214e-07f, 3.9954229e-07f, 4.2550680e-07f, 4.5315863e-07f,
		4.8260743e-07f, 5.1396998e-07f, 5.4737065e-07f, 5.8294187e-07f,
		6.2082472e-07f, 6.6116941e-07f, 7.0413592e-07f, 7.4989464e-07f,
		7.9862701e-07f, 8.5052630e-07f, 9.0579828e-07f, 9.6466216e-07f,
		1.0273513e-06f, 1.0941144e-06f, 1.1652161e-06f, 1.2409384e-06f,
		1.3215816e-06f, 1.4074654e-06f, 1.4989305e-06f, 1.5963394e-06f,
		1.7000785e-06f, 1.8105592e-06f, 1.9282195e-06f, 2.0535261e-06f,
		2.1869758e-06f, 2.3290978e-06f, 2.4804557e-06f, 2.6416497e-06f,
		2.8133190e-06f, 2.9961443e-06f, 3.1908506e-06f, 3.3982101e-06f,
		3.6190449e-06f, 3.8542308e-06f, 4.1047004e-06f, 4.3714470e-06f,
		4.6555282e-06f, 4.9580707e-06f, 5.2802740e-06f, 5.6234160e-06f,
		5.9888572e-06f, 6.3780469e-06f, 6.7925283e-06f, 7.2339451e-06f,
		7.7040476e-06f, 8.2047000e-06f, 8.7378876e-06f, 9.3057248e-06f,
		9.9104632e-06f, 1.0554501e-05f, 1.1240392e-05f, 1.1970856e-05f,
		1.2748789e-05f, 1.3577278e-05f, 1.4459606e-05f, 1.5399272e-05f,
		1.6400004e-05f, 1.7465768e-05f, 1.8600792e-05f, 1.9809576e-05f,
		2.1096914e-05f, 2.2467911e-05f, 2.3928002e-05f, 2.5482978e-05f,
		2.7139006e-05f, 2.8902651e-05f, 3.0780908e-05f, 3.2781225e-05f,
		3.4911534e-05f, 3.7180282e-05f, 3.9596466e-05f, 4.2169667e-05f,
		4.4910090e-05f, 4.7828601e-05f, 5.0936773e-05f, 5.4246931e-05f,
		5.7772202e-05f, 6.1526565e-05f, 6.5524908e-05f, 6.9783085e-05f,
		7.4317983e-05f, 7.9147585e-05f, 8.4291040e-05f, 8.9768747e-05f,
		9.5602426e-05f, 0.00010181521f, 0.00010843174f, 0.00011547824f,
		0.00012298267f, 0.00013097477f, 0.00013948625f, 0.00014855085f,
		0.00015820453f, 0.00016848555f, 0.00017943469f, 0.00019109536f,
		0.00020351382f, 0.00021673929f, 0.00023082423f, 0.00024582449f,
		0.00026179955f, 0.00027881276f, 0.00029693158f, 0.00031622787f,
		0.00033677814f, 0.00035866388f, 0.00038197188f, 0.00040679456f,
		0.00043323036f, 0.00046138411f, 0.00049136745f, 0.00052329927f,
		0.00055730621f, 0.00059352311f, 0.00063209358f, 0.00067317058f,
		0.00071691700f, 0.00076350630f, 0.00081312324f, 0.00086596457f,
		0.00092223983f, 0.00098217216f, 0.0010459992f,  0.0011139742f,
		0.0011863665f,  0.0012634633f,  0.0013455702f,  0.0014330129f,
		0.0015261382f,  0.0016253153f,  0.0017309374f,  0.0018434235f,
		0.0019632195f,  0.0020908006f,  0.0022266726f,  0.0023713743f,
		0.0025254795f,  0.0026895994f,  0.0028643847f,  0.0030505286f,
		0.0032487691f,  0.0034598925f,  0.0036847358f,  0.0039241906f,
		0.0041792066f,  0.0044507950f,  0.0047400328f,  0.0050480668f,
		0.0053761186f,  0.0057254891f,  0.0060975636f,  0.0064938176f,
		0.0069158225f,  0.0073652516f,  0.0078438871f,  0.0083536271f,
		0.0088964928f,  0.009474637f,   0.010090352f,   0.010746080f,
		0.011444421f,   0.012188144f,   0.012980198f,   0.013823725f,
		0.014722068f,   0.015678791f,   0.016697687f,   0.017782797f,
		0.018938423f,   0.020169149f,   0.021479854f,   0.022875735f,
		0.024362330f,   0.025945531f,   0.027631618f,   0.029427276f,
		0.031339626f,   0.033376252f,   0.035545228f,   0.037855157f,
		0.040315199f,   0.042935108f,   0.045725273f,   0.048696758f,
		0.051861348f,   0.055231591f,   0.058820850f,   0.062643361f,
		0.066714279f,   0.071049749f,   0.075666962f,   0.080584227f,
		0.085821044f,   0.091398179f,   0.097337747f,   0.10366330f,
		0.11039993f,    0.11757434f,    0.12521498f,    0.13335215f,
		0.14201813f,    0.15124727f,    0.16107617f,    0.17154380f,
		0.18269168f,    0.19456402f,    0.20720788f,    0.22067342f,
		0.23501402f,    0.25028656f,    0.26655159f,    0.28387361f,
		0.30232132f,    0.32196786f,    0.34289114f,    0.36517414f,
		0.38890521f,    0.41417847f,    0.44109412f,    0.46975890f,
		0.50028648f,    0.53279791f,    0.56742212f,    0.60429640f,
		0.64356699f,    0.68538959f,    0.72993007f,    0.77736504f,
		0.82788260f,    0.88168307f,    0.9389798f,     1.0f
	};

	@ObfuscatedName("e.l")
	public int[] Xlist;

	@ObfuscatedName("e.m")
	public int floor1_multiplier;

	@ObfuscatedName("e.c")
	public int[] partition_class_list;

	@ObfuscatedName("e.n")
	public int[] class_dimensions;

	@ObfuscatedName("e.j")
	public int[] class_subclasses;

	@ObfuscatedName("e.z")
	public int[] class_masterbooks;

	@ObfuscatedName("e.g")
	public int[][] subclass_books;

	@ObfuscatedName("e.q")
	public static int[] field223;

	@ObfuscatedName("e.i")
	public static int[] post;

	@ObfuscatedName("e.s")
	public static boolean[] field230;

	@ObfuscatedName("e.r([II)I")
	public static int method199(int[] arg0, int arg1) {
		int var2 = arg0[arg1];
		int var3 = -1;
		int var4 = Integer.MIN_VALUE;
		for (int var5 = 0; var5 < arg1; var5++) {
			int var6 = arg0[var5];
			if (var6 < var2 && var6 > var4) {
				var3 = var5;
				var4 = var6;
			}
		}
		return var3;
	}

	@ObfuscatedName("e.d([II)I")
	public static int method182(int[] arg0, int arg1) {
		int var2 = arg0[arg1];
		int var3 = -1;
		int var4 = Integer.MAX_VALUE;
		for (int var5 = 0; var5 < arg1; var5++) {
			int var6 = arg0[var5];
			if (var6 > var2 && var6 < var4) {
				var3 = var5;
				var4 = var6;
			}
		}
		return var3;
	}

	@ObfuscatedName("e.l(IIIII)I")
	public int method185(int arg0, int arg1, int arg2, int arg3, int arg4) {
		int var6 = arg3 - arg1;
		int var7 = arg2 - arg0;
		int var8 = var6 < 0 ? -var6 : var6;
		int var9 = (arg4 - arg0) * var8;
		int var10 = var9 / var7;
		return var6 < 0 ? arg1 - var10 : arg1 + var10;
	}

	@ObfuscatedName("e.m(IIII[FI)V")
	public void render_line(int x0, int y0, int x1, int y1, float[] d, int arg5) {
		int dy = y1 - y0;
		int adx = x1 - x0;
		int ady = dy < 0 ? -dy : dy;
		int base = dy / adx;
		int y = y0;
		int err = 0;
		int sy = dy < 0 ? base - 1 : base + 1;

		ady -= (base < 0 ? -base : base) * adx;

		d[x0] *= inverse_db_table[y0];

		if (x1 > arg5) {
			x1 = arg5;
		}

		for (int x = x0 + 1; x < x1; x++) {
			err += ady;

			if (err >= adx) {
				err -= adx;
				y += sy;
			} else {
				y += base;
			}

			d[x] *= inverse_db_table[y];
		}
	}

	@ObfuscatedName("e.c(II)V")
	public void method194(int arg0, int arg1) {
		if (arg0 >= arg1) {
			return;
		}

		int var3 = arg0;
		int var4 = field223[arg0];
		int var5 = post[arg0];
		boolean var6 = field230[arg0];
		for (int var7 = arg0 + 1; var7 <= arg1; var7++) {
			int var8 = field223[var7];
			if (var8 < var4) {
				field223[var3] = var8;
				post[var3] = post[var7];
				field230[var3] = field230[var7];
				var3++;
				field223[var7] = field223[var3];
				post[var7] = post[var3];
				field230[var7] = field230[var3];
			}
		}

		field223[var3] = var4;
		post[var3] = var5;
		field230[var3] = var6;

		this.method194(arg0, var3 - 1);
		this.method194(var3 + 1, arg1);
	}

	public VorbisFloor() {
		int floor_types = VorbisSound.read_bits(16);
		if (floor_types != 1) {
			throw new RuntimeException();
		}

		int partitions = VorbisSound.read_bits(5);
		int max_class = 0;
		this.partition_class_list = new int[partitions];

		for (int i = 0; i < partitions; i++) {
			int value = VorbisSound.read_bits(4);
			this.partition_class_list[i] = value;

			if (value >= max_class) {
				max_class = value + 1;
			}
		}

		this.class_dimensions = new int[max_class];
		this.class_subclasses = new int[max_class];
		this.class_masterbooks = new int[max_class];
		this.subclass_books = new int[max_class][];

		for (int i = 0; i < max_class; i++) {
			this.class_dimensions[i] = VorbisSound.read_bits(3) + 1;
			int subs = this.class_subclasses[i] = VorbisSound.read_bits(2);

			if (subs != 0) {
				this.class_masterbooks[i] = VorbisSound.read_bits(8);
			}

			int subclass_count = 0x1 << subs;
			int[] subclass = new int[subclass_count];
			this.subclass_books[i] = subclass;

			for (int j = 0; j < subclass_count; j++) {
				subclass[j] = VorbisSound.read_bits(8) - 1;
			}
		}

		this.floor1_multiplier = VorbisSound.read_bits(2) + 1;
		int rangebits = VorbisSound.read_bits(4);

		int values = 2;
		for (int i = 0; i < partitions; i++) {
			values += this.class_dimensions[this.partition_class_list[i]];
		}

		this.Xlist = new int[values];
		this.Xlist[0] = 0;
		this.Xlist[1] = 0x1 << rangebits;

		values = 2;
		for (int i = 0; i < partitions; i++) {
			int partition = this.partition_class_list[i];

			for (int j = 0; j < this.class_dimensions[partition]; j++) {
				this.Xlist[values++] = VorbisSound.read_bits(rangebits);
			}
		}

		if (field223 == null || field223.length < values) {
			field223 = new int[values];
			post = new int[values];
			field230 = new boolean[values];
		}
	}

	@ObfuscatedName("e.n()Z")
	public boolean method187() {
		boolean var1 = VorbisSound.read_bool() != 0;
		if (!var1) {
			return false;
		}
		int var2 = this.Xlist.length;
		for (int var3 = 0; var3 < var2; var3++) {
			field223[var3] = this.Xlist[var3];
		}
		int var4 = field219[this.floor1_multiplier - 1];
		int var5 = IntUtil.ilog(var4 - 1);
		post[0] = VorbisSound.read_bits(var5);
		post[1] = VorbisSound.read_bits(var5);
		int var6 = 2;
		for (int var7 = 0; var7 < this.partition_class_list.length; var7++) {
			int var8 = this.partition_class_list[var7];
			int var9 = this.class_dimensions[var8];
			int var10 = this.class_subclasses[var8];
			int var11 = (0x1 << var10) - 1;
			int var12 = 0;
			if (var10 > 0) {
				var12 = VorbisSound.codebooks[this.class_masterbooks[var8]].method320();
			}
			for (int var13 = 0; var13 < var9; var13++) {
				int var14 = this.subclass_books[var8][var12 & var11];
				var12 >>>= var10;
				post[var6++] = var14 >= 0 ? VorbisSound.codebooks[var14].method320() : 0;
			}
		}
		return true;
	}

	@ObfuscatedName("e.j([FI)V")
	public void method188(float[] arg0, int arg1) {
		int var3 = this.Xlist.length;
		int var4 = field219[this.floor1_multiplier - 1];

		boolean[] var5 = field230;
		field230[1] = true;
		var5[0] = true;

		for (int var6 = 2; var6 < var3; var6++) {
			int var7 = method199(field223, var6);
			int var8 = method182(field223, var6);
			int var9 = this.method185(field223[var7], post[var7], field223[var8], post[var8], field223[var6]);
			int var10 = post[var6];
			int var11 = var4 - var9;
			int var13 = (var11 < var9 ? var11 : var9) << 1;
			if (var10 == 0) {
				field230[var6] = false;
				post[var6] = var9;
			} else {
				boolean[] var14 = field230;
				field230[var8] = true;
				var14[var7] = true;
				field230[var6] = true;
				if (var10 >= var13) {
					post[var6] = var11 > var9 ? var10 - var9 + var9 : var9 - var10 + var11 - 1;
				} else {
					post[var6] = (var10 & 0x1) == 0 ? var10 / 2 + var9 : var9 - (var10 + 1) / 2;
				}
			}
		}

		this.method194(0, var3 - 1);

		int var16 = 0;
		int var17 = post[0] * this.floor1_multiplier;

		for (int var18 = 1; var18 < var3; var18++) {
			if (field230[var18]) {
				int var19 = field223[var18];
				int var20 = post[var18] * this.floor1_multiplier;
				this.render_line(var16, var17, var19, var20, arg0, arg1);

				if (var19 >= arg1) {
					return;
				}

				var16 = var19;
				var17 = var20;
			}
		}

		float var21 = inverse_db_table[var17];
		for (int var22 = var16; var22 < arg1; var22++) {
			arg0[var22] *= var21;
		}
	}
}
