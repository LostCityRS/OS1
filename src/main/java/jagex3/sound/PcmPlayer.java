package jagex3.sound;

import deob.ObfuscatedName;
import jagex3.client.TaskHandler;
import jagex3.datastruct.ArrayUtil;
import jagex3.datastruct.MonotonicTime;
import jagex3.datastruct.PreciseSleep;

import java.awt.*;

// jag::oldscape::sound::PCMPlayer
@ObfuscatedName("y")
public class PcmPlayer {

	@ObfuscatedName("y.r")
	public static int frequency;

	@ObfuscatedName("y.d")
	public static boolean stereo;

	@ObfuscatedName("y.l")
	public static int threadPriority;

	@ObfuscatedName("y.m")
	public static AudioThread thread;

	@ObfuscatedName("y.j")
	public int[] samples;

	@ObfuscatedName("y.z")
	public PcmStream stream;

	@ObfuscatedName("y.g")
	public int field256 = 32;

	@ObfuscatedName("y.q")
	public long lastPlayTime = MonotonicTime.currentTime();

	@ObfuscatedName("y.i")
	public int capacity;

	@ObfuscatedName("y.s")
	public int initialTargetSampledQueued;

	@ObfuscatedName("y.u")
	public int additionalTargetSamplesQueued;

	@ObfuscatedName("y.v")
	public long reopenTime = 0L;

	@ObfuscatedName("y.w")
	public int maxAccepted = 0;

	@ObfuscatedName("y.e")
	public int previousMaxAccepted = 0;

	@ObfuscatedName("y.b")
	public int previousQueued = 0;

	@ObfuscatedName("y.y")
	public long nextAcceptedCheckTime = 0L;

	@ObfuscatedName("y.t")
	public boolean skipAcceptedCheck = true;

	@ObfuscatedName("y.x")
	public int field259 = 0;

	@ObfuscatedName("y.p")
	public PcmStream[] field240 = new PcmStream[8];

	@ObfuscatedName("y.ad")
	public PcmStream[] field261 = new PcmStream[8];

	@ObfuscatedName("bx.r(IZII)V")
	public static final void init(int arg0, boolean arg1, int arg2) {
		if (arg0 < 8000 || arg0 > 48000) {
			throw new IllegalArgumentException();
		}
		frequency = arg0;
		stereo = arg1;
		threadPriority = arg2;
	}

	@ObfuscatedName("cm.d(Lak;Ljava/awt/Component;III)Ly;")
	public static final PcmPlayer getPlayer(TaskHandler taskHandler, Component arg1, int arg2, int arg3) {
		if (frequency == 0) {
			throw new IllegalStateException();
		} else if (arg2 >= 0 && arg2 < 2) {
			if (arg3 < 256) {
				arg3 = 256;
			}
			try {
				JavaPcmPlayer var4 = new JavaPcmPlayer();
				var4.samples = new int[(stereo ? 2 : 1) * 256];
				var4.initialTargetSampledQueued = arg3;
				var4.init(arg1);
				var4.capacity = (arg3 & 0xFFFFFC00) + 1024;
				if (var4.capacity > 16384) {
					var4.capacity = 16384;
				}
				var4.open(var4.capacity);
				if (threadPriority > 0 && thread == null) {
					thread = new AudioThread();
					thread.taskHandler = taskHandler;
					taskHandler.threadreq(thread, threadPriority);
				}
				if (thread != null) {
					if (thread.players[arg2] != null) {
						throw new IllegalArgumentException();
					}
					thread.players[arg2] = var4;
				}
				return var4;
			} catch (Throwable var9) {
				try {
					JavaSafePcmPlayer var6 = new JavaSafePcmPlayer(taskHandler, arg2);
					var6.samples = new int[(stereo ? 2 : 1) * 256];
					var6.initialTargetSampledQueued = arg3;
					var6.init(arg1);
					var6.capacity = 16384;
					var6.open(var6.capacity);
					if (threadPriority > 0 && thread == null) {
						thread = new AudioThread();
						thread.taskHandler = taskHandler;
						taskHandler.threadreq(thread, threadPriority);
					}
					if (thread != null) {
						if (thread.players[arg2] != null) {
							throw new IllegalArgumentException();
						}
						thread.players[arg2] = var6;
					}
					return var6;
				} catch (Throwable var8) {
					return new PcmPlayer();
				}
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("y.l(Ldx;I)V")
	public final synchronized void playStream(PcmStream arg0) {
		this.stream = arg0;
	}

	@ObfuscatedName("y.m(B)V")
	public final synchronized void cycle() {
		if (this.samples == null) {
			return;
		}
		long var1 = MonotonicTime.currentTime();
		try {
			if (this.reopenTime != 0L) {
				if (var1 < this.reopenTime) {
					return;
				}
				this.open(this.capacity);
				this.reopenTime = 0L;
				this.skipAcceptedCheck = true;
			}
			int var3 = this.queued();
			if (this.previousQueued - var3 > this.maxAccepted) {
				this.maxAccepted = this.previousQueued - var3;
			}
			int var4 = this.additionalTargetSamplesQueued + this.initialTargetSampledQueued;
			if (var4 + 256 > 16384) {
				var4 = 16128;
			}
			if (var4 + 256 > this.capacity) {
				this.capacity += 1024;
				if (this.capacity > 16384) {
					this.capacity = 16384;
				}
				this.close();
				this.open(this.capacity);
				var3 = 0;
				this.skipAcceptedCheck = true;
				if (var4 + 256 > this.capacity) {
					var4 = this.capacity - 256;
					this.additionalTargetSamplesQueued = var4 - this.initialTargetSampledQueued;
				}
			}
			while (var3 < var4) {
				this.generate(this.samples, 256);
				this.write();
				var3 += 256;
			}
			if (var1 > this.nextAcceptedCheckTime) {
				if (this.skipAcceptedCheck) {
					this.skipAcceptedCheck = false;
				} else if (this.maxAccepted == 0 && this.previousMaxAccepted == 0) {
					this.close();
					this.reopenTime = var1 + 2000L;
					return;
				} else {
					this.additionalTargetSamplesQueued = Math.min(this.previousMaxAccepted, this.maxAccepted);
					this.previousMaxAccepted = this.maxAccepted;
				}
				this.maxAccepted = 0;
				this.nextAcceptedCheckTime = var1 + 2000L;
			}
			this.previousQueued = var3;
		} catch (Exception var8) {
			this.close();
			this.reopenTime = var1 + 2000L;
		}
		try {
			if (var1 > this.lastPlayTime + 500000L) {
				var1 = this.lastPlayTime;
			}
			while (var1 > this.lastPlayTime + 5000L) {
				this.skip(256);
				this.lastPlayTime += 256000 / frequency;
			}
		} catch (Exception var7) {
			this.lastPlayTime = var1;
		}
	}

	@ObfuscatedName("y.c(B)V")
	public final void method207() {
		this.skipAcceptedCheck = true;
	}

	@ObfuscatedName("y.n(I)V")
	public final synchronized void play() {
		this.skipAcceptedCheck = true;
		try {
			this.flush();
		} catch (Exception var2) {
			this.close();
			this.reopenTime = MonotonicTime.currentTime() + 2000L;
		}
	}

	@ObfuscatedName("y.j(I)V")
	public final synchronized void shutdown() {
		if (thread != null) {
			boolean var1 = true;
			for (int var2 = 0; var2 < 2; var2++) {
				if (thread.players[var2] == this) {
					thread.players[var2] = null;
				}
				if (thread.players[var2] != null) {
					var1 = false;
				}
			}
			if (var1) {
				thread.shutdown = true;
				while (thread.running) {
					PreciseSleep.sleep(50L);
				}
				thread = null;
			}
		}
		this.close();
		this.samples = null;
	}

	@ObfuscatedName("y.z(II)V")
	public final void skip(int arg0) {
		this.field259 -= arg0;
		if (this.field259 < 0) {
			this.field259 = 0;
		}
		if (this.stream != null) {
			this.stream.pretendToMix(arg0);
		}
	}

	@ObfuscatedName("y.g([II)V")
	public final void generate(int[] arg0, int arg1) {
		int var3 = arg1;
		if (stereo) {
			var3 = arg1 << 1;
		}
		ArrayUtil.clear(arg0, 0, var3);
		this.field259 -= arg1;
		if (this.stream != null && this.field259 <= 0) {
			this.field259 += frequency >> 4;
			method815(this.stream);
			this.method212(this.stream, this.stream.priority());
			int var4 = 0;
			int var5 = 255;
			int var6 = 7;
			label105:
			while (var5 != 0) {
				int var7;
				int var8;
				if (var6 < 0) {
					var7 = var6 & 0x3;
					var8 = -(var6 >> 2);
				} else {
					var7 = var6;
					var8 = 0;
				}
				for (int var9 = var5 >>> var7 & 0x11111111; var9 != 0; var9 >>>= 0x4) {
					if ((var9 & 0x1) != 0) {
						var5 &= ~(0x1 << var7);
						PcmStream var10 = null;
						PcmStream var11 = this.field240[var7];
						label99:
						while (true) {
							while (true) {
								if (var11 == null) {
									break label99;
								}
								PcmStreamable var12 = var11.sound;
								if (var12 == null || var12.position <= var8) {
									var11.active = true;
									int var13 = var11.method1518();
									var4 += var13;
									if (var12 != null) {
										var12.position += var13;
									}
									if (var4 >= this.field256) {
										break label105;
									}
									PcmStream var14 = var11.method1516();
									if (var14 != null) {
										// todo: for loop
										int var15 = var11.field1646;
										while (var14 != null) {
											this.method212(var14, var15 * var14.priority() >> 8);
											var14 = var11.method1517();
										}
									}
									PcmStream var16 = var11.stream;
									var11.stream = null;
									if (var10 == null) {
										this.field240[var7] = var16;
									} else {
										var10.stream = var16;
									}
									if (var16 == null) {
										this.field261[var7] = var10;
									}
									var11 = var16;
								} else {
									var5 |= 0x1 << var7;
									var10 = var11;
									var11 = var11.stream;
								}
							}
						}
					}
					var7 += 4;
					var8++;
				}
				var6--;
			}
			for (int var17 = 0; var17 < 8; var17++) {
				PcmStream var18 = this.field240[var17];
				PcmStream[] var19 = this.field240;
				this.field261[var17] = null;
				var19[var17] = null;
				while (var18 != null) {
					PcmStream var21 = var18.stream;
					var18.stream = null;
					var18 = var21;
				}
			}
		}
		if (this.field259 < 0) {
			this.field259 = 0;
		}
		if (this.stream != null) {
			this.stream.doMix(arg0, 0, arg1);
		}
		this.lastPlayTime = MonotonicTime.currentTime();
	}

	@ObfuscatedName("bw.q(Ldx;I)V")
	public static final void method815(PcmStream arg0) {
		arg0.active = false;
		if (arg0.sound != null) {
			arg0.sound.position = 0;
		}
		for (PcmStream var1 = arg0.method1516(); var1 != null; var1 = arg0.method1517()) {
			method815(var1);
		}
	}

	@ObfuscatedName("y.i(Ldx;II)V")
	public final void method212(PcmStream arg0, int arg1) {
		int var3 = arg1 >> 5;
		PcmStream var4 = this.field261[var3];
		if (var4 == null) {
			this.field240[var3] = arg0;
		} else {
			var4.stream = arg0;
		}
		this.field261[var3] = arg0;
		arg0.field1646 = arg1;
	}

	@ObfuscatedName("y.s(Ljava/awt/Component;)V")
	public void init(Component arg0) throws Exception {
	}

	@ObfuscatedName("y.u(I)V")
	public void open(int arg0) throws Exception {
	}

	@ObfuscatedName("y.v()I")
	public int queued() throws Exception {
		return this.capacity;
	}

	@ObfuscatedName("y.w()V")
	public void write() throws Exception {
	}

	@ObfuscatedName("y.e()V")
	public void close() {
	}

	@ObfuscatedName("y.b()V")
	public void flush() throws Exception {
	}
}
