package jagex2.sound;

import deob.ObfuscatedName;

@ObfuscatedName("et")
public class SoundPcmStream extends PcmStream {

	@ObfuscatedName("et.z")
	public int field2213;

	@ObfuscatedName("et.g")
	public int field2206;

	@ObfuscatedName("et.q")
	public int field2207;

	@ObfuscatedName("et.i")
	public int field2208;

	@ObfuscatedName("et.s")
	public int field2209;

	@ObfuscatedName("et.u")
	public int field2219;

	@ObfuscatedName("et.v")
	public int field2205;

	@ObfuscatedName("et.w")
	public int field2212;

	@ObfuscatedName("et.e")
	public int field2215;

	@ObfuscatedName("et.b")
	public int field2214;

	@ObfuscatedName("et.y")
	public boolean field2210;

	@ObfuscatedName("et.t")
	public int field2216;

	@ObfuscatedName("et.f")
	public int field2217;

	@ObfuscatedName("et.k")
	public int field2218;

	@ObfuscatedName("et.o")
	public int field2211;

	@ObfuscatedName("et.p(II)I")
	public static int method2146(int arg0, int arg1) {
		return arg1 < 0 ? arg0 : (int) ((double) arg0 * Math.sqrt((double) (16384 - arg1) * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("et.ad(II)I")
	public static int method2135(int arg0, int arg1) {
		return arg1 < 0 ? -arg0 : (int) ((double) arg0 * Math.sqrt((double) arg1 * 1.220703125E-4D) + 0.5D);
	}

	@ObfuscatedName("et.c()I")
	public int method1514() {
		int var1 = this.field2209 * 3 >> 6;
		int var2 = (var1 >>> 31) + (var1 ^ var1 >> 31);
		if (this.field2212 == 0) {
			var2 -= this.field2213 * var2 / (((PcmSound) this.field1644).field2204.length << 8);
		} else if (this.field2212 >= 0) {
			var2 -= this.field2215 * var2 / ((PcmSound) this.field1644).field2204.length;
		}
		return var2 > 255 ? 255 : var2;
	}

	public SoundPcmStream(PcmSound arg0, int arg1, int arg2) {
		this.field1644 = arg0;
		this.field2215 = arg0.field2202;
		this.field2214 = arg0.field2203;
		this.field2210 = arg0.field2201;
		this.field2206 = arg1;
		this.field2207 = arg2;
		this.field2208 = 8192;
		this.field2213 = 0;
		this.method2060();
	}

	public SoundPcmStream(PcmSound arg0, int arg1, int arg2, int arg3) {
		this.field1644 = arg0;
		this.field2215 = arg0.field2202;
		this.field2214 = arg0.field2203;
		this.field2210 = arg0.field2201;
		this.field2206 = arg1;
		this.field2207 = arg2;
		this.field2208 = arg3;
		this.field2213 = 0;
		this.method2060();
	}

	@ObfuscatedName("et.ac(Leq;II)Let;")
	public static SoundPcmStream method2144(PcmSound arg0, int arg1, int arg2) {
		return arg0.field2204 == null || arg0.field2204.length == 0 ? null : new SoundPcmStream(arg0, (int) ((long) arg0.field2200 * 256L * (long) arg1 / (long) (AudioChannel.field241 * 100)), arg2 << 6);
	}

	@ObfuscatedName("et.aa(Leq;III)Let;")
	public static SoundPcmStream method2059(PcmSound arg0, int arg1, int arg2, int arg3) {
		return arg0.field2204 == null || arg0.field2204.length == 0 ? null : new SoundPcmStream(arg0, arg1, arg2, arg3);
	}

	@ObfuscatedName("et.as()V")
	public void method2060() {
		this.field2209 = this.field2207;
		this.field2219 = method2146(this.field2207, this.field2208);
		this.field2205 = method2135(this.field2207, this.field2208);
	}

	@ObfuscatedName("et.am(I)V")
	public synchronized void method2061(int arg0) {
		this.field2212 = arg0;
	}

	@ObfuscatedName("et.ap(I)V")
	public synchronized void method2090(int arg0) {
		this.method2132(arg0 << 6, this.method2066());
	}

	@ObfuscatedName("et.av(I)V")
	public synchronized void method2134(int arg0) {
		this.method2132(arg0, this.method2066());
	}

	@ObfuscatedName("et.ak(II)V")
	public synchronized void method2132(int arg0, int arg1) {
		this.field2207 = arg0;
		this.field2208 = arg1;
		this.field2216 = 0;
		this.method2060();
	}

	@ObfuscatedName("et.az()I")
	public synchronized int method2065() {
		return this.field2207 == Integer.MIN_VALUE ? 0 : this.field2207;
	}

	@ObfuscatedName("et.an()I")
	public synchronized int method2066() {
		return this.field2208 < 0 ? -1 : this.field2208;
	}

	@ObfuscatedName("et.ah(I)V")
	public synchronized void method2067(int arg0) {
		int var2 = ((PcmSound) this.field1644).field2204.length << 8;
		if (arg0 < -1) {
			arg0 = -1;
		}
		if (arg0 > var2) {
			arg0 = var2;
		}
		this.field2213 = arg0;
	}

	@ObfuscatedName("et.ay(Z)V")
	public synchronized void method2084(boolean arg0) {
		this.field2206 = (this.field2206 >>> 31) + (this.field2206 ^ this.field2206 >> 31);
		if (arg0) {
			this.field2206 = -this.field2206;
		}
	}

	@ObfuscatedName("et.al()V")
	public void method2069() {
		if (this.field2216 == 0) {
			return;
		}
		if (this.field2207 == Integer.MIN_VALUE) {
			this.field2207 = 0;
		}
		this.field2216 = 0;
		this.method2060();
	}

	@ObfuscatedName("et.ab(II)V")
	public synchronized void method2070(int arg0, int arg1) {
		this.method2071(arg0, arg1, this.method2066());
	}

	@ObfuscatedName("et.ao(III)V")
	public synchronized void method2071(int arg0, int arg1, int arg2) {
		if (arg0 == 0) {
			this.method2132(arg1, arg2);
			return;
		}
		int var4 = method2146(arg1, arg2);
		int var5 = method2135(arg1, arg2);
		if (this.field2219 == var4 && this.field2205 == var5) {
			this.field2216 = 0;
			return;
		}
		int var6 = arg1 - this.field2209;
		if (this.field2209 - arg1 > var6) {
			var6 = this.field2209 - arg1;
		}
		if (var4 - this.field2219 > var6) {
			var6 = var4 - this.field2219;
		}
		if (this.field2219 - var4 > var6) {
			var6 = this.field2219 - var4;
		}
		if (var5 - this.field2205 > var6) {
			var6 = var5 - this.field2205;
		}
		if (this.field2205 - var5 > var6) {
			var6 = this.field2205 - var5;
		}
		if (arg0 > var6) {
			arg0 = var6;
		}
		this.field2216 = arg0;
		this.field2207 = arg1;
		this.field2208 = arg2;
		this.field2217 = (arg1 - this.field2209) / arg0;
		this.field2218 = (var4 - this.field2219) / arg0;
		this.field2211 = (var5 - this.field2205) / arg0;
	}

	@ObfuscatedName("et.ag(I)V")
	public synchronized void method2081(int arg0) {
		if (arg0 == 0) {
			this.method2134(0);
			this.unlink();
		} else if (this.field2219 == 0 && this.field2205 == 0) {
			this.field2216 = 0;
			this.field2207 = 0;
			this.field2209 = 0;
			this.unlink();
		} else {
			int var2 = -this.field2209;
			if (this.field2209 > var2) {
				var2 = this.field2209;
			}
			if (-this.field2219 > var2) {
				var2 = -this.field2219;
			}
			if (this.field2219 > var2) {
				var2 = this.field2219;
			}
			if (-this.field2205 > var2) {
				var2 = -this.field2205;
			}
			if (this.field2205 > var2) {
				var2 = this.field2205;
			}
			if (arg0 > var2) {
				arg0 = var2;
			}
			this.field2216 = arg0;
			this.field2207 = Integer.MIN_VALUE;
			this.field2217 = -this.field2209 / arg0;
			this.field2218 = -this.field2219 / arg0;
			this.field2211 = -this.field2205 / arg0;
		}
	}

	@ObfuscatedName("et.ar(I)V")
	public synchronized void method2073(int arg0) {
		if (this.field2206 < 0) {
			this.field2206 = -arg0;
		} else {
			this.field2206 = arg0;
		}
	}

	@ObfuscatedName("et.aq()I")
	public synchronized int method2074() {
		return this.field2206 < 0 ? -this.field2206 : this.field2206;
	}

	@ObfuscatedName("et.at()Z")
	public boolean method2161() {
		return this.field2213 < 0 || this.field2213 >= ((PcmSound) this.field1644).field2204.length << 8;
	}

	@ObfuscatedName("et.ae()Z")
	public boolean method2076() {
		return this.field2216 != 0;
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
		return this.field2207 == 0 && this.field2216 == 0 ? 0 : 1;
	}

	@ObfuscatedName("et.q([III)V")
	public synchronized void method1520(int[] arg0, int arg1, int arg2) {
		if (this.field2207 == 0 && this.field2216 == 0) {
			this.method1521(arg2);
			return;
		}
		PcmSound var4 = (PcmSound) this.field1644;
		int var5 = this.field2215 << 8;
		int var6 = this.field2214 << 8;
		int var7 = var4.field2204.length << 8;
		int var8 = var6 - var5;
		if (var8 <= 0) {
			this.field2212 = 0;
		}
		int var9 = arg1;
		int var10 = arg1 + arg2;
		if (this.field2213 < 0) {
			if (this.field2206 <= 0) {
				this.method2069();
				this.unlink();
				return;
			}
			this.field2213 = 0;
		}
		if (this.field2213 >= var7) {
			if (this.field2206 >= 0) {
				this.method2069();
				this.unlink();
				return;
			}
			this.field2213 = var7 - 1;
		}
		if (this.field2212 >= 0) {
			if (this.field2212 > 0) {
				if (this.field2210) {
					label131: {
						if (this.field2206 < 0) {
							var9 = this.method2077(arg0, arg1, var5, var10, var4.field2204[this.field2215]);
							if (this.field2213 >= var5) {
								return;
							}
							this.field2213 = var5 + var5 - 1 - this.field2213;
							this.field2206 = -this.field2206;
							if (--this.field2212 == 0) {
								break label131;
							}
						}
						do {
							var9 = this.method2094(arg0, var9, var6, var10, var4.field2204[this.field2214 - 1]);
							if (this.field2213 < var6) {
								return;
							}
							this.field2213 = var6 + var6 - 1 - this.field2213;
							this.field2206 = -this.field2206;
							if (--this.field2212 == 0) {
								break;
							}
							var9 = this.method2077(arg0, var9, var5, var10, var4.field2204[this.field2215]);
							if (this.field2213 >= var5) {
								return;
							}
							this.field2213 = var5 + var5 - 1 - this.field2213;
							this.field2206 = -this.field2206;
						} while (--this.field2212 != 0);
					}
				} else if (this.field2206 < 0) {
					while (true) {
						var9 = this.method2077(arg0, var9, var5, var10, var4.field2204[this.field2214 - 1]);
						if (this.field2213 >= var5) {
							return;
						}
						int var12 = (var6 - 1 - this.field2213) / var8;
						if (var12 >= this.field2212) {
							this.field2213 += this.field2212 * var8;
							this.field2212 = 0;
							break;
						}
						this.field2213 += var8 * var12;
						this.field2212 -= var12;
					}
				} else {
					while (true) {
						var9 = this.method2094(arg0, var9, var6, var10, var4.field2204[this.field2215]);
						if (this.field2213 < var6) {
							return;
						}
						int var13 = (this.field2213 - var5) / var8;
						if (var13 >= this.field2212) {
							this.field2213 -= this.field2212 * var8;
							this.field2212 = 0;
							break;
						}
						this.field2213 -= var8 * var13;
						this.field2212 -= var13;
					}
				}
			}
			if (this.field2206 < 0) {
				this.method2077(arg0, var9, 0, var10, 0);
				if (this.field2213 < 0) {
					this.field2213 = -1;
					this.method2069();
					this.unlink();
				}
			} else {
				this.method2094(arg0, var9, var7, var10, 0);
				if (this.field2213 >= var7) {
					this.field2213 = var7;
					this.method2069();
					this.unlink();
				}
			}
		} else if (this.field2210) {
			if (this.field2206 < 0) {
				var9 = this.method2077(arg0, arg1, var5, var10, var4.field2204[this.field2215]);
				if (this.field2213 >= var5) {
					return;
				}
				this.field2213 = var5 + var5 - 1 - this.field2213;
				this.field2206 = -this.field2206;
			}
			while (true) {
				int var11 = this.method2094(arg0, var9, var6, var10, var4.field2204[this.field2214 - 1]);
				if (this.field2213 < var6) {
					return;
				}
				this.field2213 = var6 + var6 - 1 - this.field2213;
				this.field2206 = -this.field2206;
				var9 = this.method2077(arg0, var11, var5, var10, var4.field2204[this.field2215]);
				if (this.field2213 >= var5) {
					return;
				}
				this.field2213 = var5 + var5 - 1 - this.field2213;
				this.field2206 = -this.field2206;
			}
		} else if (this.field2206 < 0) {
			while (true) {
				var9 = this.method2077(arg0, var9, var5, var10, var4.field2204[this.field2214 - 1]);
				if (this.field2213 >= var5) {
					return;
				}
				this.field2213 = var6 - 1 - (var6 - 1 - this.field2213) % var8;
			}
		} else {
			while (true) {
				var9 = this.method2094(arg0, var9, var6, var10, var4.field2204[this.field2215]);
				if (this.field2213 < var6) {
					return;
				}
				this.field2213 = (this.field2213 - var5) % var8 + var5;
			}
		}
	}

	@ObfuscatedName("et.i(I)V")
	public synchronized void method1521(int arg0) {
		if (this.field2216 > 0) {
			if (arg0 >= this.field2216) {
				if (this.field2207 == Integer.MIN_VALUE) {
					this.field2207 = 0;
					this.field2205 = 0;
					this.field2219 = 0;
					this.field2209 = 0;
					this.unlink();
					arg0 = this.field2216;
				}
				this.field2216 = 0;
				this.method2060();
			} else {
				this.field2209 += this.field2217 * arg0;
				this.field2219 += this.field2218 * arg0;
				this.field2205 += this.field2211 * arg0;
				this.field2216 -= arg0;
			}
		}
		PcmSound var2 = (PcmSound) this.field1644;
		int var3 = this.field2215 << 8;
		int var4 = this.field2214 << 8;
		int var5 = var2.field2204.length << 8;
		int var6 = var4 - var3;
		if (var6 <= 0) {
			this.field2212 = 0;
		}
		if (this.field2213 < 0) {
			if (this.field2206 <= 0) {
				this.method2069();
				this.unlink();
				return;
			}
			this.field2213 = 0;
		}
		if (this.field2213 >= var5) {
			if (this.field2206 >= 0) {
				this.method2069();
				this.unlink();
				return;
			}
			this.field2213 = var5 - 1;
		}
		this.field2213 += this.field2206 * arg0;
		if (this.field2212 >= 0) {
			if (this.field2212 > 0) {
				if (this.field2210) {
					label121: {
						if (this.field2206 < 0) {
							if (this.field2213 >= var3) {
								return;
							}
							this.field2213 = var3 + var3 - 1 - this.field2213;
							this.field2206 = -this.field2206;
							if (--this.field2212 == 0) {
								break label121;
							}
						}
						do {
							if (this.field2213 < var4) {
								return;
							}
							this.field2213 = var4 + var4 - 1 - this.field2213;
							this.field2206 = -this.field2206;
							if (--this.field2212 == 0) {
								break;
							}
							if (this.field2213 >= var3) {
								return;
							}
							this.field2213 = var3 + var3 - 1 - this.field2213;
							this.field2206 = -this.field2206;
						} while (--this.field2212 != 0);
					}
				} else {
					label153: {
						if (this.field2206 < 0) {
							if (this.field2213 >= var3) {
								return;
							}
							int var7 = (var4 - 1 - this.field2213) / var6;
							if (var7 >= this.field2212) {
								this.field2213 += this.field2212 * var6;
								this.field2212 = 0;
								break label153;
							}
							this.field2213 += var6 * var7;
							this.field2212 -= var7;
						} else if (this.field2213 >= var4) {
							int var8 = (this.field2213 - var3) / var6;
							if (var8 >= this.field2212) {
								this.field2213 -= this.field2212 * var6;
								this.field2212 = 0;
								break label153;
							}
							this.field2213 -= var6 * var8;
							this.field2212 -= var8;
						} else {
							return;
						}
						return;
					}
				}
			}
			if (this.field2206 < 0) {
				if (this.field2213 < 0) {
					this.field2213 = -1;
					this.method2069();
					this.unlink();
				}
			} else if (this.field2213 >= var5) {
				this.field2213 = var5;
				this.method2069();
				this.unlink();
			}
		} else if (this.field2210) {
			if (this.field2206 < 0) {
				if (this.field2213 >= var3) {
					return;
				}
				this.field2213 = var3 + var3 - 1 - this.field2213;
				this.field2206 = -this.field2206;
			}
			while (this.field2213 >= var4) {
				this.field2213 = var4 + var4 - 1 - this.field2213;
				this.field2206 = -this.field2206;
				if (this.field2213 >= var3) {
					return;
				}
				this.field2213 = var3 + var3 - 1 - this.field2213;
				this.field2206 = -this.field2206;
			}
		} else if (this.field2206 < 0) {
			if (this.field2213 >= var3) {
				return;
			}
			this.field2213 = var4 - 1 - (var4 - 1 - this.field2213) % var6;
		} else if (this.field2213 >= var4) {
			this.field2213 = (this.field2213 - var3) % var6 + var3;
		} else {
			return;
		}
	}

	@ObfuscatedName("et.au([IIIII)I")
	public int method2094(int[] arg0, int arg1, int arg2, int arg3, int arg4) {
		while (true) {
			if (this.field2216 > 0) {
				int var6 = this.field2216 + arg1;
				if (var6 > arg3) {
					var6 = arg3;
				}
				this.field2216 += arg1;
				if (this.field2206 == 256 && (this.field2213 & 0xFF) == 0) {
					if (AudioChannel.field236) {
						arg1 = method2087(0, ((PcmSound) this.field1644).field2204, arg0, this.field2213, arg1, this.field2219, this.field2205, this.field2218, this.field2211, 0, var6, arg2, this);
					} else {
						arg1 = method2121(((PcmSound) this.field1644).field2204, arg0, this.field2213, arg1, this.field2209, this.field2217, 0, var6, arg2, this);
					}
				} else if (AudioChannel.field236) {
					arg1 = method2082(0, 0, ((PcmSound) this.field1644).field2204, arg0, this.field2213, arg1, this.field2219, this.field2205, this.field2218, this.field2211, 0, var6, arg2, this, this.field2206, arg4);
				} else {
					arg1 = method2131(0, 0, ((PcmSound) this.field1644).field2204, arg0, this.field2213, arg1, this.field2209, this.field2217, 0, var6, arg2, this, this.field2206, arg4);
				}
				this.field2216 -= arg1;
				if (this.field2216 != 0) {
					return arg1;
				}
				if (!this.method2062()) {
					continue;
				}
				return arg3;
			}
			if (this.field2206 == 256 && (this.field2213 & 0xFF) == 0) {
				if (AudioChannel.field236) {
					return method2079(0, ((PcmSound) this.field1644).field2204, arg0, this.field2213, arg1, this.field2219, this.field2205, 0, arg3, arg2, this);
				}
				return method2078(((PcmSound) this.field1644).field2204, arg0, this.field2213, arg1, this.field2209, 0, arg3, arg2, this);
			}
			if (AudioChannel.field236) {
				return method2083(0, 0, ((PcmSound) this.field1644).field2204, arg0, this.field2213, arg1, this.field2219, this.field2205, 0, arg3, arg2, this, this.field2206, arg4);
			}
			return method2072(0, 0, ((PcmSound) this.field1644).field2204, arg0, this.field2213, arg1, this.field2209, 0, arg3, arg2, this, this.field2206, arg4);
		}
	}

	@ObfuscatedName("et.ax([IIIII)I")
	public int method2077(int[] arg0, int arg1, int arg2, int arg3, int arg4) {
		while (true) {
			if (this.field2216 > 0) {
				int var6 = this.field2216 + arg1;
				if (var6 > arg3) {
					var6 = arg3;
				}
				this.field2216 += arg1;
				if (this.field2206 == -256 && (this.field2213 & 0xFF) == 0) {
					if (AudioChannel.field236) {
						arg1 = method2089(0, ((PcmSound) this.field1644).field2204, arg0, this.field2213, arg1, this.field2219, this.field2205, this.field2218, this.field2211, 0, var6, arg2, this);
					} else {
						arg1 = method2088(((PcmSound) this.field1644).field2204, arg0, this.field2213, arg1, this.field2209, this.field2217, 0, var6, arg2, this);
					}
				} else if (AudioChannel.field236) {
					arg1 = method2093(0, 0, ((PcmSound) this.field1644).field2204, arg0, this.field2213, arg1, this.field2219, this.field2205, this.field2218, this.field2211, 0, var6, arg2, this, this.field2206, arg4);
				} else {
					arg1 = method2136(0, 0, ((PcmSound) this.field1644).field2204, arg0, this.field2213, arg1, this.field2209, this.field2217, 0, var6, arg2, this, this.field2206, arg4);
				}
				this.field2216 -= arg1;
				if (this.field2216 != 0) {
					return arg1;
				}
				if (!this.method2062()) {
					continue;
				}
				return arg3;
			}
			if (this.field2206 == -256 && (this.field2213 & 0xFF) == 0) {
				if (AudioChannel.field236) {
					return method2133(0, ((PcmSound) this.field1644).field2204, arg0, this.field2213, arg1, this.field2219, this.field2205, 0, arg3, arg2, this);
				}
				return method2080(((PcmSound) this.field1644).field2204, arg0, this.field2213, arg1, this.field2209, 0, arg3, arg2, this);
			}
			if (AudioChannel.field236) {
				return method2085(0, 0, ((PcmSound) this.field1644).field2204, arg0, this.field2213, arg1, this.field2219, this.field2205, 0, arg3, arg2, this, this.field2206, arg4);
			}
			return method2068(0, 0, ((PcmSound) this.field1644).field2204, arg0, this.field2213, arg1, this.field2209, 0, arg3, arg2, this, this.field2206, arg4);
		}
	}

	@ObfuscatedName("et.ai()Z")
	public boolean method2062() {
		int var1 = this.field2207;
		int var2;
		int var3;
		if (var1 == Integer.MIN_VALUE) {
			var2 = 0;
			var3 = 0;
			var1 = 0;
		} else {
			var3 = method2146(var1, this.field2208);
			var2 = method2135(var1, this.field2208);
		}
		if (this.field2209 != var1 || this.field2219 != var3 || this.field2205 != var2) {
			if (this.field2209 < var1) {
				this.field2217 = 1;
				this.field2216 = var1 - this.field2209;
			} else if (this.field2209 > var1) {
				this.field2217 = -1;
				this.field2216 = this.field2209 - var1;
			} else {
				this.field2217 = 0;
			}
			if (this.field2219 < var3) {
				this.field2218 = 1;
				if (this.field2216 == 0 || this.field2216 > var3 - this.field2219) {
					this.field2216 = var3 - this.field2219;
				}
			} else if (this.field2219 > var3) {
				this.field2218 = -1;
				if (this.field2216 == 0 || this.field2216 > this.field2219 - var3) {
					this.field2216 = this.field2219 - var3;
				}
			} else {
				this.field2218 = 0;
			}
			if (this.field2205 < var2) {
				this.field2211 = 1;
				if (this.field2216 == 0 || this.field2216 > var2 - this.field2205) {
					this.field2216 = var2 - this.field2205;
				}
			} else if (this.field2205 > var2) {
				this.field2211 = -1;
				if (this.field2216 == 0 || this.field2216 > this.field2205 - var2) {
					this.field2216 = this.field2205 - var2;
				}
			} else {
				this.field2211 = 0;
			}
			return false;
		} else if (this.field2207 == Integer.MIN_VALUE) {
			this.field2207 = 0;
			this.field2205 = 0;
			this.field2219 = 0;
			this.field2209 = 0;
			this.unlink();
			return true;
		} else {
			this.method2060();
			return false;
		}
	}

	@ObfuscatedName("et.aj([B[IIIIIIILet;)I")
	public static int method2078(byte[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, SoundPcmStream arg8) {
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
		arg8.field2213 = var9 << 8;
		return arg3;
	}

	@ObfuscatedName("et.aw(I[B[IIIIIIIILet;)I")
	public static int method2079(int arg0, byte[] arg1, int[] arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, SoundPcmStream arg10) {
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
		arg10.field2213 = var11 << 8;
		return var16 >> 1;
	}

	@ObfuscatedName("et.af([B[IIIIIIILet;)I")
	public static int method2080(byte[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, SoundPcmStream arg8) {
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
		arg8.field2213 = var9 << 8;
		return arg3;
	}

	@ObfuscatedName("et.bh(I[B[IIIIIIIILet;)I")
	public static int method2133(int arg0, byte[] arg1, int[] arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, SoundPcmStream arg10) {
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
		arg10.field2213 = var11 << 8;
		return var16 >> 1;
	}

	@ObfuscatedName("et.bi(II[B[IIIIIIILet;II)I")
	public static int method2072(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, SoundPcmStream arg10, int arg11, int arg12) {
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
		arg10.field2213 = arg4;
		return arg5;
	}

	@ObfuscatedName("et.bs(II[B[IIIIIIIILet;II)I")
	public static int method2083(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, SoundPcmStream arg11, int arg12, int arg13) {
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
		arg11.field2213 = arg4;
		return var15 >> 1;
	}

	@ObfuscatedName("et.bk(II[B[IIIIIIILet;II)I")
	public static int method2068(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, SoundPcmStream arg10, int arg11, int arg12) {
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
		arg10.field2213 = arg4;
		return arg5;
	}

	@ObfuscatedName("et.bv(II[B[IIIIIIIILet;II)I")
	public static int method2085(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, SoundPcmStream arg11, int arg12, int arg13) {
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
		arg11.field2213 = arg4;
		return var15 >> 1;
	}

	@ObfuscatedName("et.bw([B[IIIIIIIILet;)I")
	public static int method2121(byte[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, SoundPcmStream arg9) {
		int var10 = arg2 >> 8;
		int var11 = arg8 >> 8;
		int var12 = arg4 << 2;
		int var13 = arg5 << 2;
		int var14;
		if ((var14 = arg3 + var11 - var10) > arg7) {
			var14 = arg7;
		}
		arg9.field2219 += (var14 - arg3) * arg9.field2218;
		arg9.field2205 += (var14 - arg3) * arg9.field2211;
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
		arg9.field2209 = var12 >> 2;
		arg9.field2213 = var10 << 8;
		return arg3;
	}

	@ObfuscatedName("et.by(I[B[IIIIIIIIIILet;)I")
	public static int method2087(int arg0, byte[] arg1, int[] arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, SoundPcmStream arg12) {
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
		arg12.field2209 += (var19 - arg4) * arg12.field2217;
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
		arg12.field2219 = var15 >> 2;
		arg12.field2205 = var16 >> 2;
		arg12.field2213 = var13 << 8;
		return var20 >> 1;
	}

	@ObfuscatedName("et.bx([B[IIIIIIIILet;)I")
	public static int method2088(byte[] arg0, int[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, SoundPcmStream arg9) {
		int var10 = arg2 >> 8;
		int var11 = arg8 >> 8;
		int var12 = arg4 << 2;
		int var13 = arg5 << 2;
		int var14;
		if ((var14 = arg3 + var10 - (var11 - 1)) > arg7) {
			var14 = arg7;
		}
		arg9.field2219 += (var14 - arg3) * arg9.field2218;
		arg9.field2205 += (var14 - arg3) * arg9.field2211;
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
		arg9.field2209 = var12 >> 2;
		arg9.field2213 = var10 << 8;
		return arg3;
	}

	@ObfuscatedName("et.bf(I[B[IIIIIIIIIILet;)I")
	public static int method2089(int arg0, byte[] arg1, int[] arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, SoundPcmStream arg12) {
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
		arg12.field2209 += (var19 - arg4) * arg12.field2217;
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
		arg12.field2219 = var15 >> 2;
		arg12.field2205 = var16 >> 2;
		arg12.field2213 = var13 << 8;
		return var20 >> 1;
	}

	@ObfuscatedName("et.bu(II[B[IIIIIIIILet;II)I")
	public static int method2131(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, SoundPcmStream arg11, int arg12, int arg13) {
		arg11.field2219 -= arg11.field2218 * arg5;
		arg11.field2205 -= arg11.field2211 * arg5;
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
		arg11.field2219 += arg11.field2218 * arg5;
		arg11.field2205 += arg11.field2211 * arg5;
		arg11.field2209 = arg6;
		arg11.field2213 = arg4;
		return arg5;
	}

	@ObfuscatedName("et.bo(II[B[IIIIIIIIIILet;II)I")
	public static int method2082(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, SoundPcmStream arg13, int arg14, int arg15) {
		arg13.field2209 -= arg13.field2217 * arg5;
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
		arg13.field2209 += arg13.field2217 * var27;
		arg13.field2219 = arg6;
		arg13.field2205 = arg7;
		arg13.field2213 = arg4;
		return var27;
	}

	@ObfuscatedName("et.bq(II[B[IIIIIIIILet;II)I")
	public static int method2136(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, SoundPcmStream arg11, int arg12, int arg13) {
		arg11.field2219 -= arg11.field2218 * arg5;
		arg11.field2205 -= arg11.field2211 * arg5;
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
		arg11.field2219 += arg11.field2218 * arg5;
		arg11.field2205 += arg11.field2211 * arg5;
		arg11.field2209 = arg6;
		arg11.field2213 = arg4;
		return arg5;
	}

	@ObfuscatedName("et.bj(II[B[IIIIIIIIIILet;II)I")
	public static int method2093(int arg0, int arg1, byte[] arg2, int[] arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, SoundPcmStream arg13, int arg14, int arg15) {
		arg13.field2209 -= arg13.field2217 * arg5;
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
		arg13.field2209 += arg13.field2217 * var26;
		arg13.field2219 = arg6;
		arg13.field2205 = arg7;
		arg13.field2213 = arg4;
		return var26;
	}
}
