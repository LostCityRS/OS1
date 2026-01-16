package jagex3.sound;

import deob.ObfuscatedName;

// jag::oldscape::sound::WaveStream
@ObfuscatedName("et")
public class WaveStream extends PcmStream {

	@ObfuscatedName("et.z")
	public int position;

	@ObfuscatedName("et.g")
	public int pitch;

	@ObfuscatedName("et.q")
	public int volume;

	@ObfuscatedName("et.i")
	public int pan;

	@ObfuscatedName("et.s")
	public int volumeMono;

	@ObfuscatedName("et.u")
	public int volumeStereoLeft;

	@ObfuscatedName("et.v")
	public int volumeStereoRight;

	@ObfuscatedName("et.w")
	public int loopCount;

	@ObfuscatedName("et.e")
	public int loopStartPosition;

	@ObfuscatedName("et.b")
	public int loopEndPosition;

	@ObfuscatedName("et.y")
	public boolean loopReversed;

	@ObfuscatedName("et.t")
	public int volumeChangeDelta;

	@ObfuscatedName("et.f")
	public int volumeChangeSpeedMono;

	@ObfuscatedName("et.k")
	public int volumeChangeSpeedStereoLeft;

	@ObfuscatedName("et.o")
	public int volumeChangeSpeedStereoRight;

	@ObfuscatedName("et.p(II)I")
	public static int panLeft(int arg0, int arg1) {
		return arg1 < 0 ? arg0 : (int) ((double) arg0 * Math.sqrt((double) (16384 - arg1) * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("et.ad(II)I")
	public static int panRight(int arg0, int arg1) {
		return arg1 < 0 ? -arg0 : (int) ((double) arg0 * Math.sqrt((double) arg1 * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("et.c()I")
	public int priority() {
		int var1 = this.volumeMono * 3 >> 6;
		int var2 = (var1 >>> 31) + (var1 ^ var1 >> 31);
		if (this.loopCount == 0) {
			var2 -= this.position * var2 / (((Wave) this.sound).samples.length << 8);
		} else if (this.loopCount >= 0) {
			var2 -= this.loopStartPosition * var2 / ((Wave) this.sound).samples.length;
		}
		return var2 > 255 ? 255 : var2;
	}

	public WaveStream(Wave arg0, int arg1, int arg2) {
		this.sound = arg0;
		this.loopStartPosition = arg0.loopStartPosition;
		this.loopEndPosition = arg0.loopEndPosition;
		this.loopReversed = arg0.loopReversed;
		this.pitch = arg1;
		this.volume = arg2;
		this.pan = 8192;
		this.position = 0;
		this.computeChannelVolumes();
	}

	public WaveStream(Wave arg0, int arg1, int arg2, int arg3) {
		this.sound = arg0;
		this.loopStartPosition = arg0.loopStartPosition;
		this.loopEndPosition = arg0.loopEndPosition;
		this.loopReversed = arg0.loopReversed;
		this.pitch = arg1;
		this.volume = arg2;
		this.pan = arg3;
		this.position = 0;
		this.computeChannelVolumes();
	}

	@ObfuscatedName("et.ac(Leq;II)Let;")
	public static WaveStream method2144(Wave arg0, int arg1, int arg2) {
		return arg0.samples == null || arg0.samples.length == 0 ? null : new WaveStream(arg0, (int) ((long) arg0.samplingFrequency * 256L * (long) arg1 / (long) (PcmPlayer.frequency * 100)), arg2 << 6);
	}

	@ObfuscatedName("et.aa(Leq;III)Let;")
	public static WaveStream create(Wave arg0, int arg1, int arg2, int arg3) {
		return arg0.samples == null || arg0.samples.length == 0 ? null : new WaveStream(arg0, arg1, arg2, arg3);
	}

	@ObfuscatedName("et.as()V")
	public void computeChannelVolumes() {
		this.volumeMono = this.volume;
		this.volumeStereoLeft = panLeft(this.volume, this.pan);
		this.volumeStereoRight = panRight(this.volume, this.pan);
	}

	@ObfuscatedName("et.am(I)V")
	public synchronized void setLoopCount(int arg0) {
		this.loopCount = arg0;
	}

	@ObfuscatedName("et.ap(I)V")
	public synchronized void method2090(int arg0) {
		this.setVolume(arg0 << 6, this.getPan());
	}

	@ObfuscatedName("et.av(I)V")
	public synchronized void setVolume(int arg0) {
		this.setVolume(arg0, this.getPan());
	}

	@ObfuscatedName("et.ak(II)V")
	public synchronized void setVolume(int arg0, int arg1) {
		this.volume = arg0;
		this.pan = arg1;
		this.volumeChangeDelta = 0;
		this.computeChannelVolumes();
	}

	@ObfuscatedName("et.az()I")
	public synchronized int getVolume() {
		return this.volume == Integer.MIN_VALUE ? 0 : this.volume;
	}

	@ObfuscatedName("et.an()I")
	public synchronized int getPan() {
		return this.pan < 0 ? -1 : this.pan;
	}

	@ObfuscatedName("et.ah(I)V")
	public synchronized void setPosition(int arg0) {
		int var2 = ((Wave) this.sound).samples.length << 8;
		if (arg0 < -1) {
			arg0 = -1;
		}
		if (arg0 > var2) {
			arg0 = var2;
		}
		this.position = arg0;
	}

	@ObfuscatedName("et.ay(Z)V")
	public synchronized void setReversed(boolean arg0) {
		this.pitch = (this.pitch >>> 31) + (this.pitch ^ this.pitch >> 31);
		if (arg0) {
			this.pitch = -this.pitch;
		}
	}

	@ObfuscatedName("et.al()V")
	public void cancelVolumeChange() {
		if (this.volumeChangeDelta == 0) {
			return;
		}
		if (this.volume == Integer.MIN_VALUE) {
			this.volume = 0;
		}
		this.volumeChangeDelta = 0;
		this.computeChannelVolumes();
	}

	@ObfuscatedName("et.ab(II)V")
	public synchronized void changeVolumeSmooth(int arg0, int arg1) {
		this.changeVolumeSmooth(arg0, arg1, this.getPan());
	}

	@ObfuscatedName("et.ao(III)V")
	public synchronized void changeVolumeSmooth(int arg0, int arg1, int arg2) {
		if (arg0 == 0) {
			this.setVolume(arg1, arg2);
			return;
		}
		int var4 = panLeft(arg1, arg2);
		int var5 = panRight(arg1, arg2);
		if (this.volumeStereoLeft == var4 && this.volumeStereoRight == var5) {
			this.volumeChangeDelta = 0;
			return;
		}
		int var6 = arg1 - this.volumeMono;
		if (this.volumeMono - arg1 > var6) {
			var6 = this.volumeMono - arg1;
		}
		if (var4 - this.volumeStereoLeft > var6) {
			var6 = var4 - this.volumeStereoLeft;
		}
		if (this.volumeStereoLeft - var4 > var6) {
			var6 = this.volumeStereoLeft - var4;
		}
		if (var5 - this.volumeStereoRight > var6) {
			var6 = var5 - this.volumeStereoRight;
		}
		if (this.volumeStereoRight - var5 > var6) {
			var6 = this.volumeStereoRight - var5;
		}
		if (arg0 > var6) {
			arg0 = var6;
		}
		this.volumeChangeDelta = arg0;
		this.volume = arg1;
		this.pan = arg2;
		this.volumeChangeSpeedMono = (arg1 - this.volumeMono) / arg0;
		this.volumeChangeSpeedStereoLeft = (var4 - this.volumeStereoLeft) / arg0;
		this.volumeChangeSpeedStereoRight = (var5 - this.volumeStereoRight) / arg0;
	}

	@ObfuscatedName("et.ag(I)V")
	public synchronized void fadeOut(int arg0) {
		if (arg0 == 0) {
			this.setVolume(0);
			this.unlink();
		} else if (this.volumeStereoLeft == 0 && this.volumeStereoRight == 0) {
			this.volumeChangeDelta = 0;
			this.volume = 0;
			this.volumeMono = 0;
			this.unlink();
		} else {
			int var2 = -this.volumeMono;
			if (this.volumeMono > var2) {
				var2 = this.volumeMono;
			}
			if (-this.volumeStereoLeft > var2) {
				var2 = -this.volumeStereoLeft;
			}
			if (this.volumeStereoLeft > var2) {
				var2 = this.volumeStereoLeft;
			}
			if (-this.volumeStereoRight > var2) {
				var2 = -this.volumeStereoRight;
			}
			if (this.volumeStereoRight > var2) {
				var2 = this.volumeStereoRight;
			}
			if (arg0 > var2) {
				arg0 = var2;
			}
			this.volumeChangeDelta = arg0;
			this.volume = Integer.MIN_VALUE;
			this.volumeChangeSpeedMono = -this.volumeMono / arg0;
			this.volumeChangeSpeedStereoLeft = -this.volumeStereoLeft / arg0;
			this.volumeChangeSpeedStereoRight = -this.volumeStereoRight / arg0;
		}
	}

	@ObfuscatedName("et.ar(I)V")
	public synchronized void setPitch(int arg0) {
		if (this.pitch < 0) {
			this.pitch = -arg0;
		} else {
			this.pitch = arg0;
		}
	}

	@ObfuscatedName("et.aq()I")
	public synchronized int getPitch() {
		return this.pitch < 0 ? -this.pitch : this.pitch;
	}

	@ObfuscatedName("et.at()Z")
	public boolean method2161() {
		return this.position < 0 || this.position >= ((Wave) this.sound).samples.length << 8;
	}

	@ObfuscatedName("et.ae()Z")
	public boolean isVolumeChanging() {
		return this.volumeChangeDelta != 0;
	}

	@ObfuscatedName("et.n()Ldx;")
	public PcmStream method1516() {
		return null;
	}

	@ObfuscatedName("et.j()Ldx;")
	public PcmStream method1517() {
		return null;
	}

	@ObfuscatedName("et.z()I")
	public int method1518() {
		return this.volume == 0 && this.volumeChangeDelta == 0 ? 0 : 1;
	}

	@ObfuscatedName("et.q([III)V")
	public synchronized void doMix(int[] arg0, int arg1, int arg2) {
		if (this.volume == 0 && this.volumeChangeDelta == 0) {
			this.pretendToMix(arg2);
			return;
		}
		Wave var4 = (Wave) this.sound;
		int var5 = this.loopStartPosition << 8;
		int var6 = this.loopEndPosition << 8;
		int var7 = var4.samples.length << 8;
		int var8 = var6 - var5;
		if (var8 <= 0) {
			this.loopCount = 0;
		}
		int var9 = arg1;
		int var10 = arg1 + arg2;
		if (this.position < 0) {
			if (this.pitch <= 0) {
				this.cancelVolumeChange();
				this.unlink();
				return;
			}
			this.position = 0;
		}
		if (this.position >= var7) {
			if (this.pitch >= 0) {
				this.cancelVolumeChange();
				this.unlink();
				return;
			}
			this.position = var7 - 1;
		}
		if (this.loopCount >= 0) {
			if (this.loopCount > 0) {
				if (this.loopReversed) {
					label131:
					{
						if (this.pitch < 0) {
							var9 = this.playReversed(arg0, arg1, var5, var10, var4.samples[this.loopStartPosition]);
							if (this.position >= var5) {
								return;
							}
							this.position = var5 + var5 - 1 - this.position;
							this.pitch = -this.pitch;
							if (--this.loopCount == 0) {
								break label131;
							}
						}
						do {
							var9 = this.play(arg0, var9, var6, var10, var4.samples[this.loopEndPosition - 1]);
							if (this.position < var6) {
								return;
							}
							this.position = var6 + var6 - 1 - this.position;
							this.pitch = -this.pitch;
							if (--this.loopCount == 0) {
								break;
							}
							var9 = this.playReversed(arg0, var9, var5, var10, var4.samples[this.loopStartPosition]);
							if (this.position >= var5) {
								return;
							}
							this.position = var5 + var5 - 1 - this.position;
							this.pitch = -this.pitch;
						} while (--this.loopCount != 0);
					}
				} else if (this.pitch < 0) {
					while (true) {
						var9 = this.playReversed(arg0, var9, var5, var10, var4.samples[this.loopEndPosition - 1]);
						if (this.position >= var5) {
							return;
						}
						int var12 = (var6 - 1 - this.position) / var8;
						if (var12 >= this.loopCount) {
							this.position += this.loopCount * var8;
							this.loopCount = 0;
							break;
						}
						this.position += var8 * var12;
						this.loopCount -= var12;
					}
				} else {
					while (true) {
						var9 = this.play(arg0, var9, var6, var10, var4.samples[this.loopStartPosition]);
						if (this.position < var6) {
							return;
						}
						int var13 = (this.position - var5) / var8;
						if (var13 >= this.loopCount) {
							this.position -= this.loopCount * var8;
							this.loopCount = 0;
							break;
						}
						this.position -= var8 * var13;
						this.loopCount -= var13;
					}
				}
			}
			if (this.pitch < 0) {
				this.playReversed(arg0, var9, 0, var10, 0);
				if (this.position < 0) {
					this.position = -1;
					this.cancelVolumeChange();
					this.unlink();
				}
			} else {
				this.play(arg0, var9, var7, var10, 0);
				if (this.position >= var7) {
					this.position = var7;
					this.cancelVolumeChange();
					this.unlink();
				}
			}
		} else if (this.loopReversed) {
			if (this.pitch < 0) {
				var9 = this.playReversed(arg0, arg1, var5, var10, var4.samples[this.loopStartPosition]);
				if (this.position >= var5) {
					return;
				}
				this.position = var5 + var5 - 1 - this.position;
				this.pitch = -this.pitch;
			}
			while (true) {
				int var11 = this.play(arg0, var9, var6, var10, var4.samples[this.loopEndPosition - 1]);
				if (this.position < var6) {
					return;
				}
				this.position = var6 + var6 - 1 - this.position;
				this.pitch = -this.pitch;
				var9 = this.playReversed(arg0, var11, var5, var10, var4.samples[this.loopStartPosition]);
				if (this.position >= var5) {
					return;
				}
				this.position = var5 + var5 - 1 - this.position;
				this.pitch = -this.pitch;
			}
		} else if (this.pitch < 0) {
			while (true) {
				var9 = this.playReversed(arg0, var9, var5, var10, var4.samples[this.loopEndPosition - 1]);
				if (this.position >= var5) {
					return;
				}
				this.position = var6 - 1 - (var6 - 1 - this.position) % var8;
			}
		} else {
			while (true) {
				var9 = this.play(arg0, var9, var6, var10, var4.samples[this.loopStartPosition]);
				if (this.position < var6) {
					return;
				}
				this.position = (this.position - var5) % var8 + var5;
			}
		}
	}

	@ObfuscatedName("et.i(I)V")
	public synchronized void pretendToMix(int arg0) {
		if (this.volumeChangeDelta > 0) {
			if (arg0 >= this.volumeChangeDelta) {
				if (this.volume == Integer.MIN_VALUE) {
					this.volume = 0;
					this.volumeStereoRight = 0;
					this.volumeStereoLeft = 0;
					this.volumeMono = 0;
					this.unlink();
					arg0 = this.volumeChangeDelta;
				}
				this.volumeChangeDelta = 0;
				this.computeChannelVolumes();
			} else {
				this.volumeMono += this.volumeChangeSpeedMono * arg0;
				this.volumeStereoLeft += this.volumeChangeSpeedStereoLeft * arg0;
				this.volumeStereoRight += this.volumeChangeSpeedStereoRight * arg0;
				this.volumeChangeDelta -= arg0;
			}
		}
		Wave var2 = (Wave) this.sound;
		int var3 = this.loopStartPosition << 8;
		int var4 = this.loopEndPosition << 8;
		int var5 = var2.samples.length << 8;
		int var6 = var4 - var3;
		if (var6 <= 0) {
			this.loopCount = 0;
		}
		if (this.position < 0) {
			if (this.pitch <= 0) {
				this.cancelVolumeChange();
				this.unlink();
				return;
			}
			this.position = 0;
		}
		if (this.position >= var5) {
			if (this.pitch >= 0) {
				this.cancelVolumeChange();
				this.unlink();
				return;
			}
			this.position = var5 - 1;
		}
		this.position += this.pitch * arg0;
		if (this.loopCount >= 0) {
			if (this.loopCount > 0) {
				if (this.loopReversed) {
					label121:
					{
						if (this.pitch < 0) {
							if (this.position >= var3) {
								return;
							}
							this.position = var3 + var3 - 1 - this.position;
							this.pitch = -this.pitch;
							if (--this.loopCount == 0) {
								break label121;
							}
						}
						do {
							if (this.position < var4) {
								return;
							}
							this.position = var4 + var4 - 1 - this.position;
							this.pitch = -this.pitch;
							if (--this.loopCount == 0) {
								break;
							}
							if (this.position >= var3) {
								return;
							}
							this.position = var3 + var3 - 1 - this.position;
							this.pitch = -this.pitch;
						} while (--this.loopCount != 0);
					}
				} else {
					label153:
					{
						if (this.pitch < 0) {
							if (this.position >= var3) {
								return;
							}
							int var7 = (var4 - 1 - this.position) / var6;
							if (var7 >= this.loopCount) {
								this.position += this.loopCount * var6;
								this.loopCount = 0;
								break label153;
							}
							this.position += var6 * var7;
							this.loopCount -= var7;
						} else if (this.position >= var4) {
							int var8 = (this.position - var3) / var6;
							if (var8 >= this.loopCount) {
								this.position -= this.loopCount * var6;
								this.loopCount = 0;
								break label153;
							}
							this.position -= var6 * var8;
							this.loopCount -= var8;
						} else {
							return;
						}
						return;
					}
				}
			}
			if (this.pitch < 0) {
				if (this.position < 0) {
					this.position = -1;
					this.cancelVolumeChange();
					this.unlink();
				}
			} else if (this.position >= var5) {
				this.position = var5;
				this.cancelVolumeChange();
				this.unlink();
			}
		} else if (this.loopReversed) {
			if (this.pitch < 0) {
				if (this.position >= var3) {
					return;
				}
				this.position = var3 + var3 - 1 - this.position;
				this.pitch = -this.pitch;
			}
			while (this.position >= var4) {
				this.position = var4 + var4 - 1 - this.position;
				this.pitch = -this.pitch;
				if (this.position >= var3) {
					return;
				}
				this.position = var3 + var3 - 1 - this.position;
				this.pitch = -this.pitch;
			}
		} else if (this.pitch < 0) {
			if (this.position >= var3) {
				return;
			}
			this.position = var4 - 1 - (var4 - 1 - this.position) % var6;
		} else if (this.position >= var4) {
			this.position = (this.position - var3) % var6 + var3;
		}
	}

	@ObfuscatedName("et.au([IIIII)I")
	public int play(int[] arg0, int arg1, int arg2, int arg3, int arg4) {
		while (true) {
			if (this.volumeChangeDelta > 0) {
				int var6 = this.volumeChangeDelta + arg1;
				if (var6 > arg3) {
					var6 = arg3;
				}
				this.volumeChangeDelta += arg1;
				if (this.pitch == 256 && (this.position & 0xFF) == 0) {
					if (PcmPlayer.stereo) {
						arg1 = method2087(0, ((Wave) this.sound).samples, arg0, this.position, arg1, this.volumeStereoLeft, this.volumeStereoRight, this.volumeChangeSpeedStereoLeft, this.volumeChangeSpeedStereoRight, 0, var6, arg2, this);
					} else {
						arg1 = method2121(((Wave) this.sound).samples, arg0, this.position, arg1, this.volumeMono, this.volumeChangeSpeedMono, 0, var6, arg2, this);
					}
				} else if (PcmPlayer.stereo) {
					arg1 = method2082(0, 0, ((Wave) this.sound).samples, arg0, this.position, arg1, this.volumeStereoLeft, this.volumeStereoRight, this.volumeChangeSpeedStereoLeft, this.volumeChangeSpeedStereoRight, 0, var6, arg2, this, this.pitch, arg4);
				} else {
					arg1 = method2131(0, 0, ((Wave) this.sound).samples, arg0, this.position, arg1, this.volumeMono, this.volumeChangeSpeedMono, 0, var6, arg2, this, this.pitch, arg4);
				}
				this.volumeChangeDelta -= arg1;
				if (this.volumeChangeDelta != 0) {
					return arg1;
				}
				if (!this.method2062()) {
					continue;
				}
				return arg3;
			}
			if (this.pitch == 256 && (this.position & 0xFF) == 0) {
				if (PcmPlayer.stereo) {
					return method2079(0, ((Wave) this.sound).samples, arg0, this.position, arg1, this.volumeStereoLeft, this.volumeStereoRight, 0, arg3, arg2, this);
				}
				return method2078(((Wave) this.sound).samples, arg0, this.position, arg1, this.volumeMono, 0, arg3, arg2, this);
			}
			if (PcmPlayer.stereo) {
				return method2083(0, 0, ((Wave) this.sound).samples, arg0, this.position, arg1, this.volumeStereoLeft, this.volumeStereoRight, 0, arg3, arg2, this, this.pitch, arg4);
			}
			return method2072(0, 0, ((Wave) this.sound).samples, arg0, this.position, arg1, this.volumeMono, 0, arg3, arg2, this, this.pitch, arg4);
		}
	}

	@ObfuscatedName("et.ax([IIIII)I")
	public int playReversed(int[] arg0, int arg1, int arg2, int arg3, int arg4) {
		while (true) {
			if (this.volumeChangeDelta > 0) {
				int var6 = this.volumeChangeDelta + arg1;
				if (var6 > arg3) {
					var6 = arg3;
				}
				this.volumeChangeDelta += arg1;
				if (this.pitch == -256 && (this.position & 0xFF) == 0) {
					if (PcmPlayer.stereo) {
						arg1 = method2089(0, ((Wave) this.sound).samples, arg0, this.position, arg1, this.volumeStereoLeft, this.volumeStereoRight, this.volumeChangeSpeedStereoLeft, this.volumeChangeSpeedStereoRight, 0, var6, arg2, this);
					} else {
						arg1 = method2088(((Wave) this.sound).samples, arg0, this.position, arg1, this.volumeMono, this.volumeChangeSpeedMono, 0, var6, arg2, this);
					}
				} else if (PcmPlayer.stereo) {
					arg1 = method2093(0, 0, ((Wave) this.sound).samples, arg0, this.position, arg1, this.volumeStereoLeft, this.volumeStereoRight, this.volumeChangeSpeedStereoLeft, this.volumeChangeSpeedStereoRight, 0, var6, arg2, this, this.pitch, arg4);
				} else {
					arg1 = method2136(0, 0, ((Wave) this.sound).samples, arg0, this.position, arg1, this.volumeMono, this.volumeChangeSpeedMono, 0, var6, arg2, this, this.pitch, arg4);
				}
				this.volumeChangeDelta -= arg1;
				if (this.volumeChangeDelta != 0) {
					return arg1;
				}
				if (!this.method2062()) {
					continue;
				}
				return arg3;
			}
			if (this.pitch == -256 && (this.position & 0xFF) == 0) {
				if (PcmPlayer.stereo) {
					return method2133(0, ((Wave) this.sound).samples, arg0, this.position, arg1, this.volumeStereoLeft, this.volumeStereoRight, 0, arg3, arg2, this);
				}
				return method2080(((Wave) this.sound).samples, arg0, this.position, arg1, this.volumeMono, 0, arg3, arg2, this);
			}
			if (PcmPlayer.stereo) {
				return method2085(0, 0, ((Wave) this.sound).samples, arg0, this.position, arg1, this.volumeStereoLeft, this.volumeStereoRight, 0, arg3, arg2, this, this.pitch, arg4);
			}
			return method2068(0, 0, ((Wave) this.sound).samples, arg0, this.position, arg1, this.volumeMono, 0, arg3, arg2, this, this.pitch, arg4);
		}
	}

	@ObfuscatedName("et.ai()Z")
	public boolean method2062() {
		int var1 = this.volume;
		int var2;
		int var3;
		if (var1 == Integer.MIN_VALUE) {
			var2 = 0;
			var3 = 0;
			var1 = 0;
		} else {
			var3 = panLeft(var1, this.pan);
			var2 = panRight(var1, this.pan);
		}
		if (this.volumeMono != var1 || this.volumeStereoLeft != var3 || this.volumeStereoRight != var2) {
			if (this.volumeMono < var1) {
				this.volumeChangeSpeedMono = 1;
				this.volumeChangeDelta = var1 - this.volumeMono;
			} else if (this.volumeMono > var1) {
				this.volumeChangeSpeedMono = -1;
				this.volumeChangeDelta = this.volumeMono - var1;
			} else {
				this.volumeChangeSpeedMono = 0;
			}
			if (this.volumeStereoLeft < var3) {
				this.volumeChangeSpeedStereoLeft = 1;
				if (this.volumeChangeDelta == 0 || this.volumeChangeDelta > var3 - this.volumeStereoLeft) {
					this.volumeChangeDelta = var3 - this.volumeStereoLeft;
				}
			} else if (this.volumeStereoLeft > var3) {
				this.volumeChangeSpeedStereoLeft = -1;
				if (this.volumeChangeDelta == 0 || this.volumeChangeDelta > this.volumeStereoLeft - var3) {
					this.volumeChangeDelta = this.volumeStereoLeft - var3;
				}
			} else {
				this.volumeChangeSpeedStereoLeft = 0;
			}
			if (this.volumeStereoRight < var2) {
				this.volumeChangeSpeedStereoRight = 1;
				if (this.volumeChangeDelta == 0 || this.volumeChangeDelta > var2 - this.volumeStereoRight) {
					this.volumeChangeDelta = var2 - this.volumeStereoRight;
				}
			} else if (this.volumeStereoRight > var2) {
				this.volumeChangeSpeedStereoRight = -1;
				if (this.volumeChangeDelta == 0 || this.volumeChangeDelta > this.volumeStereoRight - var2) {
					this.volumeChangeDelta = this.volumeStereoRight - var2;
				}
			} else {
				this.volumeChangeSpeedStereoRight = 0;
			}
			return false;
		} else if (this.volume == Integer.MIN_VALUE) {
			this.volume = 0;
			this.volumeStereoRight = 0;
			this.volumeStereoLeft = 0;
			this.volumeMono = 0;
			this.unlink();
			return true;
		} else {
			this.computeChannelVolumes();
			return false;
		}
	}

	@ObfuscatedName("et.aj([B[IIIIIIILet;)I")
	public static int method2078(byte[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, WaveStream arg8) {
		int var9 = arg2 >> 8;
		int var10 = arg7 >> 8;
		int var11 = arg4 << 2;
		int var12;
		if ((var12 = arg3 + var10 - var9) > arg6) {
			var12 = arg6;
		}
		var12 -= 3;
		int var10001;
		while (arg3 < var12) {
			var10001 = arg3++;
			arg1[var10001] += arg0[var9++] * var11;
			int var13 = arg3++;
			arg1[var13] += arg0[var9++] * var11;
			int var14 = arg3++;
			arg1[var14] += arg0[var9++] * var11;
			int var15 = arg3++;
			arg1[var15] += arg0[var9++] * var11;
		}
		var12 += 3;
		while (arg3 < var12) {
			var10001 = arg3++;
			arg1[var10001] += arg0[var9++] * var11;
		}
		arg8.position = var9 << 8;
		return arg3;
	}

	@ObfuscatedName("et.aw(I[B[IIIIIIIILet;)I")
	public static int method2079(int arg0, byte[] arg1, int[] arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, WaveStream arg10) {
		int var11 = arg3 >> 8;
		int var12 = arg9 >> 8;
		int var13 = arg5 << 2;
		int var14 = arg6 << 2;
		int var15;
		if ((var15 = arg4 + var12 - var11) > arg8) {
			var15 = arg8;
		}
		int var16 = arg4 << 1;
		int var17 = var15 << 1;
		int var23 = var17 - 6;
		while (var16 < var23) {
			byte var18 = arg1[var11++];
			int var24 = var16++;
			arg2[var24] += var13 * var18;
			int var25 = var16++;
			arg2[var25] += var14 * var18;
			byte var19 = arg1[var11++];
			int var27 = var16++;
			arg2[var27] += var13 * var19;
			int var28 = var16++;
			arg2[var28] += var14 * var19;
			byte var20 = arg1[var11++];
			int var30 = var16++;
			arg2[var30] += var13 * var20;
			int var31 = var16++;
			arg2[var31] += var14 * var20;
			byte var21 = arg1[var11++];
			int var33 = var16++;
			arg2[var33] += var13 * var21;
			int var34 = var16++;
			arg2[var34] += var14 * var21;
		}
		var17 = var23 + 6;
		while (var16 < var17) {
			byte var22 = arg1[var11++];
			int var10001 = var16++;
			arg2[var10001] += var13 * var22;
			int var35 = var16++;
			arg2[var35] += var14 * var22;
		}
		arg10.position = var11 << 8;
		return var16 >> 1;
	}

	@ObfuscatedName("et.af([B[IIIIIIILet;)I")
	public static int method2080(byte[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, WaveStream arg8) {
		int var9 = arg2 >> 8;
		int var10 = arg7 >> 8;
		int var11 = arg4 << 2;
		int var12;
		if ((var12 = arg3 + var9 - (var10 - 1)) > arg6) {
			var12 = arg6;
		}
		var12 -= 3;
		int var10001;
		while (arg3 < var12) {
			var10001 = arg3++;
			arg1[var10001] += arg0[var9--] * var11;
			int var13 = arg3++;
			arg1[var13] += arg0[var9--] * var11;
			int var14 = arg3++;
			arg1[var14] += arg0[var9--] * var11;
			int var15 = arg3++;
			arg1[var15] += arg0[var9--] * var11;
		}
		var12 += 3;
		while (arg3 < var12) {
			var10001 = arg3++;
			arg1[var10001] += arg0[var9--] * var11;
		}
		arg8.position = var9 << 8;
		return arg3;
	}

	@ObfuscatedName("et.bh(I[B[IIIIIIIILet;)I")
	public static int method2133(int arg0, byte[] arg1, int[] arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, WaveStream arg10) {
		int var11 = arg3 >> 8;
		int var12 = arg9 >> 8;
		int var13 = arg5 << 2;
		int var14 = arg6 << 2;
		int var15;
		if ((var15 = arg4 + var11 - (var12 - 1)) > arg8) {
			var15 = arg8;
		}
		int var16 = arg4 << 1;
		int var17 = var15 << 1;
		int var23 = var17 - 6;
		while (var16 < var23) {
			byte var18 = arg1[var11--];
			int var24 = var16++;
			arg2[var24] += var13 * var18;
			int var25 = var16++;
			arg2[var25] += var14 * var18;
			byte var19 = arg1[var11--];
			int var27 = var16++;
			arg2[var27] += var13 * var19;
			int var28 = var16++;
			arg2[var28] += var14 * var19;
			byte var20 = arg1[var11--];
			int var30 = var16++;
			arg2[var30] += var13 * var20;
			int var31 = var16++;
			arg2[var31] += var14 * var20;
			byte var21 = arg1[var11--];
			int var33 = var16++;
			arg2[var33] += var13 * var21;
			int var34 = var16++;
			arg2[var34] += var14 * var21;
		}
		var17 = var23 + 6;
		while (var16 < var17) {
			byte var22 = arg1[var11--];
			int var10001 = var16++;
			arg2[var10001] += var13 * var22;
			int var35 = var16++;
			arg2[var35] += var14 * var22;
		}
		arg10.position = var11 << 8;
		return var16 >> 1;
	}

	@ObfuscatedName("et.bi(II[B[IIIIIIILet;II)I")
	public static int method2072(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, WaveStream arg10, int arg11, int arg12) {
		int var13;
		if (arg11 == 0 || (var13 = (arg9 - arg4 + arg11 - 257) / arg11 + arg5) > arg8) {
			var13 = arg8;
		}
		int var10001;
		while (arg5 < var13) {
			int var14 = arg4 >> 8;
			byte var15 = arg2[var14];
			var10001 = arg5++;
			arg3[var10001] += ((var15 << 8) + (arg4 & 0xFF) * (arg2[var14 + 1] - var15)) * arg6 >> 6;
			arg4 += arg11;
		}
		int var16;
		if (arg11 == 0 || (var16 = (arg9 - arg4 + arg11 - 1) / arg11 + arg5) > arg8) {
			var16 = arg8;
		}
		int var17 = arg12;
		while (arg5 < var16) {
			byte var18 = arg2[arg4 >> 8];
			var10001 = arg5++;
			arg3[var10001] += ((var18 << 8) + (arg4 & 0xFF) * (var17 - var18)) * arg6 >> 6;
			arg4 += arg11;
		}
		arg10.position = arg4;
		return arg5;
	}

	@ObfuscatedName("et.bs(II[B[IIIIIIIILet;II)I")
	public static int method2083(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, WaveStream arg11, int arg12, int arg13) {
		int var14;
		if (arg12 == 0 || (var14 = (arg10 - arg4 + arg12 - 257) / arg12 + arg5) > arg9) {
			var14 = arg9;
		}
		int var15 = arg5 << 1;
		int var16 = var14 << 1;
		int var10001;
		while (var15 < var16) {
			int var17 = arg4 >> 8;
			byte var18 = arg2[var17];
			int var19 = (var18 << 8) + (arg4 & 0xFF) * (arg2[var17 + 1] - var18);
			var10001 = var15++;
			arg3[var10001] += arg6 * var19 >> 6;
			int var25 = var15++;
			arg3[var25] += arg7 * var19 >> 6;
			arg4 += arg12;
		}
		int var20;
		if (arg12 == 0 || (var20 = (var15 >> 1) + (arg10 - arg4 + arg12 - 1) / arg12) > arg9) {
			var20 = arg9;
		}
		int var21 = var20 << 1;
		int var22 = arg13;
		while (var15 < var21) {
			byte var23 = arg2[arg4 >> 8];
			int var24 = (var23 << 8) + (arg4 & 0xFF) * (var22 - var23);
			var10001 = var15++;
			arg3[var10001] += arg6 * var24 >> 6;
			var10001 = var15++;
			arg3[var10001] += arg7 * var24 >> 6;
			arg4 += arg12;
		}
		arg11.position = arg4;
		return var15 >> 1;
	}

	@ObfuscatedName("et.bk(II[B[IIIIIIILet;II)I")
	public static int method2068(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, WaveStream arg10, int arg11, int arg12) {
		int var13;
		if (arg11 == 0 || (var13 = (arg9 + 256 - arg4 + arg11) / arg11 + arg5) > arg8) {
			var13 = arg8;
		}
		int var10001;
		while (arg5 < var13) {
			int var14 = arg4 >> 8;
			byte var15 = arg2[var14 - 1];
			var10001 = arg5++;
			arg3[var10001] += ((var15 << 8) + (arg4 & 0xFF) * (arg2[var14] - var15)) * arg6 >> 6;
			arg4 += arg11;
		}
		int var16;
		if (arg11 == 0 || (var16 = (arg9 - arg4 + arg11) / arg11 + arg5) > arg8) {
			var16 = arg8;
		}
		int var17 = arg12;
		int var18 = arg11;
		while (arg5 < var16) {
			var10001 = arg5++;
			arg3[var10001] += ((var17 << 8) + (arg4 & 0xFF) * (arg2[arg4 >> 8] - var17)) * arg6 >> 6;
			arg4 += var18;
		}
		arg10.position = arg4;
		return arg5;
	}

	@ObfuscatedName("et.bv(II[B[IIIIIIIILet;II)I")
	public static int method2085(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, WaveStream arg11, int arg12, int arg13) {
		int var14;
		if (arg12 == 0 || (var14 = (arg10 + 256 - arg4 + arg12) / arg12 + arg5) > arg9) {
			var14 = arg9;
		}
		int var15 = arg5 << 1;
		int var16 = var14 << 1;
		int var10001;
		while (var15 < var16) {
			int var17 = arg4 >> 8;
			byte var18 = arg2[var17 - 1];
			int var19 = (var18 << 8) + (arg4 & 0xFF) * (arg2[var17] - var18);
			var10001 = var15++;
			arg3[var10001] += arg6 * var19 >> 6;
			int var24 = var15++;
			arg3[var24] += arg7 * var19 >> 6;
			arg4 += arg12;
		}
		int var20;
		if (arg12 == 0 || (var20 = (var15 >> 1) + (arg10 - arg4 + arg12) / arg12) > arg9) {
			var20 = arg9;
		}
		int var21 = var20 << 1;
		int var22 = arg13;
		while (var15 < var21) {
			int var23 = (var22 << 8) + (arg4 & 0xFF) * (arg2[arg4 >> 8] - var22);
			var10001 = var15++;
			arg3[var10001] += arg6 * var23 >> 6;
			var10001 = var15++;
			arg3[var10001] += arg7 * var23 >> 6;
			arg4 += arg12;
		}
		arg11.position = arg4;
		return var15 >> 1;
	}

	@ObfuscatedName("et.bw([B[IIIIIIIILet;)I")
	public static int method2121(byte[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, WaveStream arg9) {
		int var10 = arg2 >> 8;
		int var11 = arg8 >> 8;
		int var12 = arg4 << 2;
		int var13 = arg5 << 2;
		int var14;
		if ((var14 = arg3 + var11 - var10) > arg7) {
			var14 = arg7;
		}
		arg9.volumeStereoLeft += (var14 - arg3) * arg9.volumeChangeSpeedStereoLeft;
		arg9.volumeStereoRight += (var14 - arg3) * arg9.volumeChangeSpeedStereoRight;
		var14 -= 3;
		int var10001;
		while (arg3 < var14) {
			var10001 = arg3++;
			arg1[var10001] += arg0[var10++] * var12;
			int var15 = var12 + var13;
			int var18 = arg3++;
			arg1[var18] += arg0[var10++] * var15;
			int var16 = var13 + var15;
			int var19 = arg3++;
			arg1[var19] += arg0[var10++] * var16;
			int var17 = var13 + var16;
			int var20 = arg3++;
			arg1[var20] += arg0[var10++] * var17;
			var12 = var13 + var17;
		}
		var14 += 3;
		while (arg3 < var14) {
			var10001 = arg3++;
			arg1[var10001] += arg0[var10++] * var12;
			var12 += var13;
		}
		arg9.volumeMono = var12 >> 2;
		arg9.position = var10 << 8;
		return arg3;
	}

	@ObfuscatedName("et.by(I[B[IIIIIIIIIILet;)I")
	public static int method2087(int arg0, byte[] arg1, int[] arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, WaveStream arg12) {
		int var13 = arg3 >> 8;
		int var14 = arg11 >> 8;
		int var15 = arg5 << 2;
		int var16 = arg6 << 2;
		int var17 = arg7 << 2;
		int var18 = arg8 << 2;
		int var19;
		if ((var19 = arg4 + var14 - var13) > arg10) {
			var19 = arg10;
		}
		arg12.volumeMono += (var19 - arg4) * arg12.volumeChangeSpeedMono;
		int var20 = arg4 << 1;
		int var21 = var19 << 1;
		int var44 = var21 - 6;
		while (var20 < var44) {
			byte var22 = arg1[var13++];
			int var33 = var20++;
			arg2[var33] += var15 * var22;
			int var23 = var15 + var17;
			int var34 = var20++;
			arg2[var34] += var16 * var22;
			int var24 = var16 + var18;
			byte var25 = arg1[var13++];
			int var36 = var20++;
			arg2[var36] += var23 * var25;
			int var26 = var17 + var23;
			int var37 = var20++;
			arg2[var37] += var24 * var25;
			int var27 = var18 + var24;
			byte var28 = arg1[var13++];
			int var39 = var20++;
			arg2[var39] += var26 * var28;
			int var29 = var17 + var26;
			int var40 = var20++;
			arg2[var40] += var27 * var28;
			int var30 = var18 + var27;
			byte var31 = arg1[var13++];
			int var42 = var20++;
			arg2[var42] += var29 * var31;
			var15 = var17 + var29;
			int var43 = var20++;
			arg2[var43] += var30 * var31;
			var16 = var18 + var30;
		}
		var21 = var44 + 6;
		while (var20 < var21) {
			byte var32 = arg1[var13++];
			int var10001 = var20++;
			arg2[var10001] += var15 * var32;
			var15 += var17;
			int var45 = var20++;
			arg2[var45] += var16 * var32;
			var16 += var18;
		}
		arg12.volumeStereoLeft = var15 >> 2;
		arg12.volumeStereoRight = var16 >> 2;
		arg12.position = var13 << 8;
		return var20 >> 1;
	}

	@ObfuscatedName("et.bx([B[IIIIIIIILet;)I")
	public static int method2088(byte[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, WaveStream arg9) {
		int var10 = arg2 >> 8;
		int var11 = arg8 >> 8;
		int var12 = arg4 << 2;
		int var13 = arg5 << 2;
		int var14;
		if ((var14 = arg3 + var10 - (var11 - 1)) > arg7) {
			var14 = arg7;
		}
		arg9.volumeStereoLeft += (var14 - arg3) * arg9.volumeChangeSpeedStereoLeft;
		arg9.volumeStereoRight += (var14 - arg3) * arg9.volumeChangeSpeedStereoRight;
		var14 -= 3;
		int var10001;
		while (arg3 < var14) {
			var10001 = arg3++;
			arg1[var10001] += arg0[var10--] * var12;
			int var15 = var12 + var13;
			int var18 = arg3++;
			arg1[var18] += arg0[var10--] * var15;
			int var16 = var13 + var15;
			int var19 = arg3++;
			arg1[var19] += arg0[var10--] * var16;
			int var17 = var13 + var16;
			int var20 = arg3++;
			arg1[var20] += arg0[var10--] * var17;
			var12 = var13 + var17;
		}
		var14 += 3;
		while (arg3 < var14) {
			var10001 = arg3++;
			arg1[var10001] += arg0[var10--] * var12;
			var12 += var13;
		}
		arg9.volumeMono = var12 >> 2;
		arg9.position = var10 << 8;
		return arg3;
	}

	@ObfuscatedName("et.bf(I[B[IIIIIIIIIILet;)I")
	public static int method2089(int arg0, byte[] arg1, int[] arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, WaveStream arg12) {
		int var13 = arg3 >> 8;
		int var14 = arg11 >> 8;
		int var15 = arg5 << 2;
		int var16 = arg6 << 2;
		int var17 = arg7 << 2;
		int var18 = arg8 << 2;
		int var19;
		if ((var19 = arg4 + var13 - (var14 - 1)) > arg10) {
			var19 = arg10;
		}
		arg12.volumeMono += (var19 - arg4) * arg12.volumeChangeSpeedMono;
		int var20 = arg4 << 1;
		int var21 = var19 << 1;
		int var44 = var21 - 6;
		while (var20 < var44) {
			byte var22 = arg1[var13--];
			int var33 = var20++;
			arg2[var33] += var15 * var22;
			int var23 = var15 + var17;
			int var34 = var20++;
			arg2[var34] += var16 * var22;
			int var24 = var16 + var18;
			byte var25 = arg1[var13--];
			int var36 = var20++;
			arg2[var36] += var23 * var25;
			int var26 = var17 + var23;
			int var37 = var20++;
			arg2[var37] += var24 * var25;
			int var27 = var18 + var24;
			byte var28 = arg1[var13--];
			int var39 = var20++;
			arg2[var39] += var26 * var28;
			int var29 = var17 + var26;
			int var40 = var20++;
			arg2[var40] += var27 * var28;
			int var30 = var18 + var27;
			byte var31 = arg1[var13--];
			int var42 = var20++;
			arg2[var42] += var29 * var31;
			var15 = var17 + var29;
			int var43 = var20++;
			arg2[var43] += var30 * var31;
			var16 = var18 + var30;
		}
		var21 = var44 + 6;
		while (var20 < var21) {
			byte var32 = arg1[var13--];
			int var10001 = var20++;
			arg2[var10001] += var15 * var32;
			var15 += var17;
			int var45 = var20++;
			arg2[var45] += var16 * var32;
			var16 += var18;
		}
		arg12.volumeStereoLeft = var15 >> 2;
		arg12.volumeStereoRight = var16 >> 2;
		arg12.position = var13 << 8;
		return var20 >> 1;
	}

	@ObfuscatedName("et.bu(II[B[IIIIIIIILet;II)I")
	public static int method2131(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, WaveStream arg11, int arg12, int arg13) {
		arg11.volumeStereoLeft -= arg11.volumeChangeSpeedStereoLeft * arg5;
		arg11.volumeStereoRight -= arg11.volumeChangeSpeedStereoRight * arg5;
		int var14;
		if (arg12 == 0 || (var14 = (arg10 - arg4 + arg12 - 257) / arg12 + arg5) > arg9) {
			var14 = arg9;
		}
		int var10001;
		while (arg5 < var14) {
			int var15 = arg4 >> 8;
			byte var16 = arg2[var15];
			var10001 = arg5++;
			arg3[var10001] += ((var16 << 8) + (arg4 & 0xFF) * (arg2[var15 + 1] - var16)) * arg6 >> 6;
			arg6 += arg7;
			arg4 += arg12;
		}
		int var17;
		if (arg12 == 0 || (var17 = (arg10 - arg4 + arg12 - 1) / arg12 + arg5) > arg9) {
			var17 = arg9;
		}
		int var18 = arg13;
		while (arg5 < var17) {
			byte var19 = arg2[arg4 >> 8];
			var10001 = arg5++;
			arg3[var10001] += ((var19 << 8) + (arg4 & 0xFF) * (var18 - var19)) * arg6 >> 6;
			arg6 += arg7;
			arg4 += arg12;
		}
		arg11.volumeStereoLeft += arg11.volumeChangeSpeedStereoLeft * arg5;
		arg11.volumeStereoRight += arg11.volumeChangeSpeedStereoRight * arg5;
		arg11.volumeMono = arg6;
		arg11.position = arg4;
		return arg5;
	}

	@ObfuscatedName("et.bo(II[B[IIIIIIIIIILet;II)I")
	public static int method2082(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, WaveStream arg13, int arg14, int arg15) {
		arg13.volumeMono -= arg13.volumeChangeSpeedMono * arg5;
		int var16;
		if (arg14 == 0 || (var16 = (arg12 - arg4 + arg14 - 257) / arg14 + arg5) > arg11) {
			var16 = arg11;
		}
		int var17 = arg5 << 1;
		int var18 = var16 << 1;
		int var10001;
		while (var17 < var18) {
			int var19 = arg4 >> 8;
			byte var20 = arg2[var19];
			int var21 = (var20 << 8) + (arg4 & 0xFF) * (arg2[var19 + 1] - var20);
			var10001 = var17++;
			arg3[var10001] += arg6 * var21 >> 6;
			arg6 += arg8;
			int var28 = var17++;
			arg3[var28] += arg7 * var21 >> 6;
			arg7 += arg9;
			arg4 += arg14;
		}
		int var22;
		if (arg14 == 0 || (var22 = (var17 >> 1) + (arg12 - arg4 + arg14 - 1) / arg14) > arg11) {
			var22 = arg11;
		}
		int var23 = var22 << 1;
		int var24 = arg15;
		while (var17 < var23) {
			byte var25 = arg2[arg4 >> 8];
			int var26 = (var25 << 8) + (arg4 & 0xFF) * (var24 - var25);
			var10001 = var17++;
			arg3[var10001] += arg6 * var26 >> 6;
			arg6 += arg8;
			var10001 = var17++;
			arg3[var10001] += arg7 * var26 >> 6;
			arg7 += arg9;
			arg4 += arg14;
		}
		int var27 = var17 >> 1;
		arg13.volumeMono += arg13.volumeChangeSpeedMono * var27;
		arg13.volumeStereoLeft = arg6;
		arg13.volumeStereoRight = arg7;
		arg13.position = arg4;
		return var27;
	}

	@ObfuscatedName("et.bq(II[B[IIIIIIIILet;II)I")
	public static int method2136(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, WaveStream arg11, int arg12, int arg13) {
		arg11.volumeStereoLeft -= arg11.volumeChangeSpeedStereoLeft * arg5;
		arg11.volumeStereoRight -= arg11.volumeChangeSpeedStereoRight * arg5;
		int var14;
		if (arg12 == 0 || (var14 = (arg10 + 256 - arg4 + arg12) / arg12 + arg5) > arg9) {
			var14 = arg9;
		}
		int var10001;
		while (arg5 < var14) {
			int var15 = arg4 >> 8;
			byte var16 = arg2[var15 - 1];
			var10001 = arg5++;
			arg3[var10001] += ((var16 << 8) + (arg4 & 0xFF) * (arg2[var15] - var16)) * arg6 >> 6;
			arg6 += arg7;
			arg4 += arg12;
		}
		int var17;
		if (arg12 == 0 || (var17 = (arg10 - arg4 + arg12) / arg12 + arg5) > arg9) {
			var17 = arg9;
		}
		int var18 = arg13;
		int var19 = arg12;
		while (arg5 < var17) {
			var10001 = arg5++;
			arg3[var10001] += ((var18 << 8) + (arg4 & 0xFF) * (arg2[arg4 >> 8] - var18)) * arg6 >> 6;
			arg6 += arg7;
			arg4 += var19;
		}
		arg11.volumeStereoLeft += arg11.volumeChangeSpeedStereoLeft * arg5;
		arg11.volumeStereoRight += arg11.volumeChangeSpeedStereoRight * arg5;
		arg11.volumeMono = arg6;
		arg11.position = arg4;
		return arg5;
	}

	@ObfuscatedName("et.bj(II[B[IIIIIIIIIILet;II)I")
	public static int method2093(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, WaveStream arg13, int arg14, int arg15) {
		arg13.volumeMono -= arg13.volumeChangeSpeedMono * arg5;
		int var16;
		if (arg14 == 0 || (var16 = (arg12 + 256 - arg4 + arg14) / arg14 + arg5) > arg11) {
			var16 = arg11;
		}
		int var17 = arg5 << 1;
		int var18 = var16 << 1;
		int var10001;
		while (var17 < var18) {
			int var19 = arg4 >> 8;
			byte var20 = arg2[var19 - 1];
			int var21 = (var20 << 8) + (arg4 & 0xFF) * (arg2[var19] - var20);
			var10001 = var17++;
			arg3[var10001] += arg6 * var21 >> 6;
			arg6 += arg8;
			int var27 = var17++;
			arg3[var27] += arg7 * var21 >> 6;
			arg7 += arg9;
			arg4 += arg14;
		}
		int var22;
		if (arg14 == 0 || (var22 = (var17 >> 1) + (arg12 - arg4 + arg14) / arg14) > arg11) {
			var22 = arg11;
		}
		int var23 = var22 << 1;
		int var24 = arg15;
		while (var17 < var23) {
			int var25 = (var24 << 8) + (arg4 & 0xFF) * (arg2[arg4 >> 8] - var24);
			var10001 = var17++;
			arg3[var10001] += arg6 * var25 >> 6;
			arg6 += arg8;
			var10001 = var17++;
			arg3[var10001] += arg7 * var25 >> 6;
			arg7 += arg9;
			arg4 += arg14;
		}
		int var26 = var17 >> 1;
		arg13.volumeMono += arg13.volumeChangeSpeedMono * var26;
		arg13.volumeStereoLeft = arg6;
		arg13.volumeStereoRight = arg7;
		arg13.position = arg4;
		return var26;
	}
}
