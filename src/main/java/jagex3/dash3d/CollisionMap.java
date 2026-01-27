package jagex3.dash3d;

import deob.ObfuscatedName;

// jag::oldscape::movement::CollisionMap
@ObfuscatedName("ck")
public class CollisionMap {

	@ObfuscatedName("ck.am")
	public int startX = 0;

	@ObfuscatedName("ck.ap")
	public int startZ = 0;

	@ObfuscatedName("ck.av")
	public int sizeX;

	@ObfuscatedName("ck.ak")
	public int sizeZ;

	@ObfuscatedName("ck.az")
	public int[][] flags;

	public CollisionMap(int arg0, int arg1) {
		this.sizeX = arg0;
		this.sizeZ = arg1;
		this.flags = new int[this.sizeX][this.sizeZ];
		this.reset();
	}

	// jag::oldscape::movement::CollisionMap::Reset
	@ObfuscatedName("ck.r(I)V")
	public void reset() {
		for (int var1 = 0; var1 < this.sizeX; var1++) {
			for (int var2 = 0; var2 < this.sizeZ; var2++) {
				if (var1 == 0 || var2 == 0 || var1 >= this.sizeX - 5 || var2 >= this.sizeZ - 5) {
					this.flags[var1][var2] = 16777215;
				} else {
					this.flags[var1][var2] = 16777216;
				}
			}
		}
	}

	// jag::oldscape::movement::CollisionMap::AddWall
	@ObfuscatedName("ck.d(IIIIZI)V")
	public void addWall(int arg0, int arg1, int arg2, int arg3, boolean arg4) {
		int var6 = arg0 - this.startX;
		int var7 = arg1 - this.startZ;
		if (arg2 == 0) {
			if (arg3 == 0) {
				this.addCMap(var6, var7, 128);
				this.addCMap(var6 - 1, var7, 8);
			}
			if (arg3 == 1) {
				this.addCMap(var6, var7, 2);
				this.addCMap(var6, var7 + 1, 32);
			}
			if (arg3 == 2) {
				this.addCMap(var6, var7, 8);
				this.addCMap(var6 + 1, var7, 128);
			}
			if (arg3 == 3) {
				this.addCMap(var6, var7, 32);
				this.addCMap(var6, var7 - 1, 2);
			}
		}
		if (arg2 == 1 || arg2 == 3) {
			if (arg3 == 0) {
				this.addCMap(var6, var7, 1);
				this.addCMap(var6 - 1, var7 + 1, 16);
			}
			if (arg3 == 1) {
				this.addCMap(var6, var7, 4);
				this.addCMap(var6 + 1, var7 + 1, 64);
			}
			if (arg3 == 2) {
				this.addCMap(var6, var7, 16);
				this.addCMap(var6 + 1, var7 - 1, 1);
			}
			if (arg3 == 3) {
				this.addCMap(var6, var7, 64);
				this.addCMap(var6 - 1, var7 - 1, 4);
			}
		}
		if (arg2 == 2) {
			if (arg3 == 0) {
				this.addCMap(var6, var7, 130);
				this.addCMap(var6 - 1, var7, 8);
				this.addCMap(var6, var7 + 1, 32);
			}
			if (arg3 == 1) {
				this.addCMap(var6, var7, 10);
				this.addCMap(var6, var7 + 1, 32);
				this.addCMap(var6 + 1, var7, 128);
			}
			if (arg3 == 2) {
				this.addCMap(var6, var7, 40);
				this.addCMap(var6 + 1, var7, 128);
				this.addCMap(var6, var7 - 1, 2);
			}
			if (arg3 == 3) {
				this.addCMap(var6, var7, 160);
				this.addCMap(var6, var7 - 1, 2);
				this.addCMap(var6 - 1, var7, 8);
			}
		}
		if (arg4) {
			if (arg2 == 0) {
				if (arg3 == 0) {
					this.addCMap(var6, var7, 65536);
					this.addCMap(var6 - 1, var7, 4096);
				}
				if (arg3 == 1) {
					this.addCMap(var6, var7, 1024);
					this.addCMap(var6, var7 + 1, 16384);
				}
				if (arg3 == 2) {
					this.addCMap(var6, var7, 4096);
					this.addCMap(var6 + 1, var7, 65536);
				}
				if (arg3 == 3) {
					this.addCMap(var6, var7, 16384);
					this.addCMap(var6, var7 - 1, 1024);
				}
			}
			if (arg2 == 1 || arg2 == 3) {
				if (arg3 == 0) {
					this.addCMap(var6, var7, 512);
					this.addCMap(var6 - 1, var7 + 1, 8192);
				}
				if (arg3 == 1) {
					this.addCMap(var6, var7, 2048);
					this.addCMap(var6 + 1, var7 + 1, 32768);
				}
				if (arg3 == 2) {
					this.addCMap(var6, var7, 8192);
					this.addCMap(var6 + 1, var7 - 1, 512);
				}
				if (arg3 == 3) {
					this.addCMap(var6, var7, 32768);
					this.addCMap(var6 - 1, var7 - 1, 2048);
				}
			}
			if (arg2 == 2) {
				if (arg3 == 0) {
					this.addCMap(var6, var7, 66560);
					this.addCMap(var6 - 1, var7, 4096);
					this.addCMap(var6, var7 + 1, 16384);
				}
				if (arg3 == 1) {
					this.addCMap(var6, var7, 5120);
					this.addCMap(var6, var7 + 1, 16384);
					this.addCMap(var6 + 1, var7, 65536);
				}
				if (arg3 == 2) {
					this.addCMap(var6, var7, 20480);
					this.addCMap(var6 + 1, var7, 65536);
					this.addCMap(var6, var7 - 1, 1024);
				}
				if (arg3 == 3) {
					this.addCMap(var6, var7, 81920);
					this.addCMap(var6, var7 - 1, 1024);
					this.addCMap(var6 - 1, var7, 4096);
				}
			}
		}
	}

	// jag::oldscape::movement::CollisionMap::AddLoc
	@ObfuscatedName("ck.l(IIIIZI)V")
	public void addLoc(int arg0, int arg1, int arg2, int arg3, boolean arg4) {
		int var6 = 256;
		if (arg4) {
			var6 += 131072;
		}
		int var7 = arg0 - this.startX;
		int var8 = arg1 - this.startZ;
		for (int var9 = var7; var9 < arg2 + var7; var9++) {
			if (var9 >= 0 && var9 < this.sizeX) {
				for (int var10 = var8; var10 < arg3 + var8; var10++) {
					if (var10 >= 0 && var10 < this.sizeZ) {
						this.addCMap(var9, var10, var6);
					}
				}
			}
		}
	}

	// jag::oldscape::movement::CollisionMap::BlockGround
	@ObfuscatedName("ck.m(III)V")
	public void blockGround(int arg0, int arg1) {
		int var3 = arg0 - this.startX;
		int var4 = arg1 - this.startZ;
		this.flags[var3][var4] |= 0x200000;
	}

	// jag::oldscape::movement::CollisionMap::BlockGroundDecor
	@ObfuscatedName("ck.c(IIB)V")
	public void blockGroundDecor(int arg0, int arg1) {
		int var3 = arg0 - this.startX;
		int var4 = arg1 - this.startZ;
		this.flags[var3][var4] |= 0x40000;
	}

	// jag::oldscape::movement::CollisionMap::AddCMap
	@ObfuscatedName("ck.n(IIII)V")
	public void addCMap(int arg0, int arg1, int arg2) {
		this.flags[arg0][arg1] |= arg2;
	}

	// jag::oldscape::movement::CollisionMap::DelWall
	@ObfuscatedName("ck.j(IIIIZI)V")
	public void delWall(int arg0, int arg1, int arg2, int arg3, boolean arg4) {
		int var6 = arg0 - this.startX;
		int var7 = arg1 - this.startZ;
		if (arg2 == 0) {
			if (arg3 == 0) {
				this.remCMap(var6, var7, 128);
				this.remCMap(var6 - 1, var7, 8);
			}
			if (arg3 == 1) {
				this.remCMap(var6, var7, 2);
				this.remCMap(var6, var7 + 1, 32);
			}
			if (arg3 == 2) {
				this.remCMap(var6, var7, 8);
				this.remCMap(var6 + 1, var7, 128);
			}
			if (arg3 == 3) {
				this.remCMap(var6, var7, 32);
				this.remCMap(var6, var7 - 1, 2);
			}
		}
		if (arg2 == 1 || arg2 == 3) {
			if (arg3 == 0) {
				this.remCMap(var6, var7, 1);
				this.remCMap(var6 - 1, var7 + 1, 16);
			}
			if (arg3 == 1) {
				this.remCMap(var6, var7, 4);
				this.remCMap(var6 + 1, var7 + 1, 64);
			}
			if (arg3 == 2) {
				this.remCMap(var6, var7, 16);
				this.remCMap(var6 + 1, var7 - 1, 1);
			}
			if (arg3 == 3) {
				this.remCMap(var6, var7, 64);
				this.remCMap(var6 - 1, var7 - 1, 4);
			}
		}
		if (arg2 == 2) {
			if (arg3 == 0) {
				this.remCMap(var6, var7, 130);
				this.remCMap(var6 - 1, var7, 8);
				this.remCMap(var6, var7 + 1, 32);
			}
			if (arg3 == 1) {
				this.remCMap(var6, var7, 10);
				this.remCMap(var6, var7 + 1, 32);
				this.remCMap(var6 + 1, var7, 128);
			}
			if (arg3 == 2) {
				this.remCMap(var6, var7, 40);
				this.remCMap(var6 + 1, var7, 128);
				this.remCMap(var6, var7 - 1, 2);
			}
			if (arg3 == 3) {
				this.remCMap(var6, var7, 160);
				this.remCMap(var6, var7 - 1, 2);
				this.remCMap(var6 - 1, var7, 8);
			}
		}
		if (arg4) {
			if (arg2 == 0) {
				if (arg3 == 0) {
					this.remCMap(var6, var7, 65536);
					this.remCMap(var6 - 1, var7, 4096);
				}
				if (arg3 == 1) {
					this.remCMap(var6, var7, 1024);
					this.remCMap(var6, var7 + 1, 16384);
				}
				if (arg3 == 2) {
					this.remCMap(var6, var7, 4096);
					this.remCMap(var6 + 1, var7, 65536);
				}
				if (arg3 == 3) {
					this.remCMap(var6, var7, 16384);
					this.remCMap(var6, var7 - 1, 1024);
				}
			}
			if (arg2 == 1 || arg2 == 3) {
				if (arg3 == 0) {
					this.remCMap(var6, var7, 512);
					this.remCMap(var6 - 1, var7 + 1, 8192);
				}
				if (arg3 == 1) {
					this.remCMap(var6, var7, 2048);
					this.remCMap(var6 + 1, var7 + 1, 32768);
				}
				if (arg3 == 2) {
					this.remCMap(var6, var7, 8192);
					this.remCMap(var6 + 1, var7 - 1, 512);
				}
				if (arg3 == 3) {
					this.remCMap(var6, var7, 32768);
					this.remCMap(var6 - 1, var7 - 1, 2048);
				}
			}
			if (arg2 == 2) {
				if (arg3 == 0) {
					this.remCMap(var6, var7, 66560);
					this.remCMap(var6 - 1, var7, 4096);
					this.remCMap(var6, var7 + 1, 16384);
				}
				if (arg3 == 1) {
					this.remCMap(var6, var7, 5120);
					this.remCMap(var6, var7 + 1, 16384);
					this.remCMap(var6 + 1, var7, 65536);
				}
				if (arg3 == 2) {
					this.remCMap(var6, var7, 20480);
					this.remCMap(var6 + 1, var7, 65536);
					this.remCMap(var6, var7 - 1, 1024);
				}
				if (arg3 == 3) {
					this.remCMap(var6, var7, 81920);
					this.remCMap(var6, var7 - 1, 1024);
					this.remCMap(var6 - 1, var7, 4096);
				}
			}
		}
	}

	// jag::oldscape::movement::CollisionMap::DelLoc
	@ObfuscatedName("ck.z(IIIIIZI)V")
	public void delLoc(int arg0, int arg1, int arg2, int arg3, int arg4, boolean arg5) {
		int var7 = 256;
		if (arg5) {
			var7 += 131072;
		}
		int var8 = arg0 - this.startX;
		int var9 = arg1 - this.startZ;
		if (arg4 == 1 || arg4 == 3) {
			int var10 = arg2;
			arg2 = arg3;
			arg3 = var10;
		}
		for (int var11 = var8; var11 < arg2 + var8; var11++) {
			if (var11 >= 0 && var11 < this.sizeX) {
				for (int var12 = var9; var12 < arg3 + var9; var12++) {
					if (var12 >= 0 && var12 < this.sizeZ) {
						this.remCMap(var11, var12, var7);
					}
				}
			}
		}
	}

	// jag::oldscape::movement::CollisionMap::RemCMap
	@ObfuscatedName("ck.g(IIII)V")
	public void remCMap(int arg0, int arg1, int arg2) {
		this.flags[arg0][arg1] &= ~arg2;
	}

	// jag::oldscape::movement::CollisionMap::UnblockGroundDecor
	@ObfuscatedName("ck.q(III)V")
	public void unblockGroundDecor(int arg0, int arg1) {
		int var3 = arg0 - this.startX;
		int var4 = arg1 - this.startZ;
		this.flags[var3][var4] &= 0xFFFBFFFF;
	}

	// jag::oldscape::movement::CollisionMap::TestWall
	@ObfuscatedName("ck.i(IIIIIII)Z")
	public boolean testWall(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		if (arg0 == arg2 && arg1 == arg3) {
			return true;
		}
		int var7 = arg0 - this.startX;
		int var8 = arg1 - this.startZ;
		int var9 = arg2 - this.startX;
		int var10 = arg3 - this.startZ;
		if (arg4 == 0) {
			if (arg5 == 0) {
				if (var9 - 1 == var7 && var8 == var10) {
					return true;
				}
				if (var7 == var9 && var10 + 1 == var8 && (this.flags[var7][var8] & 0x12C0120) == 0) {
					return true;
				}
				if (var7 == var9 && var10 - 1 == var8 && (this.flags[var7][var8] & 0x12C0102) == 0) {
					return true;
				}
			} else if (arg5 == 1) {
				if (var7 == var9 && var10 + 1 == var8) {
					return true;
				}
				if (var9 - 1 == var7 && var8 == var10 && (this.flags[var7][var8] & 0x12C0108) == 0) {
					return true;
				}
				if (var9 + 1 == var7 && var8 == var10 && (this.flags[var7][var8] & 0x12C0180) == 0) {
					return true;
				}
			} else if (arg5 == 2) {
				if (var9 + 1 == var7 && var8 == var10) {
					return true;
				}
				if (var7 == var9 && var10 + 1 == var8 && (this.flags[var7][var8] & 0x12C0120) == 0) {
					return true;
				}
				if (var7 == var9 && var10 - 1 == var8 && (this.flags[var7][var8] & 0x12C0102) == 0) {
					return true;
				}
			} else if (arg5 == 3) {
				if (var7 == var9 && var10 - 1 == var8) {
					return true;
				}
				if (var9 - 1 == var7 && var8 == var10 && (this.flags[var7][var8] & 0x12C0108) == 0) {
					return true;
				}
				if (var9 + 1 == var7 && var8 == var10 && (this.flags[var7][var8] & 0x12C0180) == 0) {
					return true;
				}
			}
		}
		if (arg4 == 2) {
			if (arg5 == 0) {
				if (var9 - 1 == var7 && var8 == var10) {
					return true;
				}
				if (var7 == var9 && var10 + 1 == var8) {
					return true;
				}
				if (var9 + 1 == var7 && var8 == var10 && (this.flags[var7][var8] & 0x12C0180) == 0) {
					return true;
				}
				if (var7 == var9 && var10 - 1 == var8 && (this.flags[var7][var8] & 0x12C0102) == 0) {
					return true;
				}
			} else if (arg5 == 1) {
				if (var9 - 1 == var7 && var8 == var10 && (this.flags[var7][var8] & 0x12C0108) == 0) {
					return true;
				}
				if (var7 == var9 && var10 + 1 == var8) {
					return true;
				}
				if (var9 + 1 == var7 && var8 == var10) {
					return true;
				}
				if (var7 == var9 && var10 - 1 == var8 && (this.flags[var7][var8] & 0x12C0102) == 0) {
					return true;
				}
			} else if (arg5 == 2) {
				if (var9 - 1 == var7 && var8 == var10 && (this.flags[var7][var8] & 0x12C0108) == 0) {
					return true;
				}
				if (var7 == var9 && var10 + 1 == var8 && (this.flags[var7][var8] & 0x12C0120) == 0) {
					return true;
				}
				if (var9 + 1 == var7 && var8 == var10) {
					return true;
				}
				if (var7 == var9 && var10 - 1 == var8) {
					return true;
				}
			} else if (arg5 == 3) {
				if (var9 - 1 == var7 && var8 == var10) {
					return true;
				}
				if (var7 == var9 && var10 + 1 == var8 && (this.flags[var7][var8] & 0x12C0120) == 0) {
					return true;
				}
				if (var9 + 1 == var7 && var8 == var10 && (this.flags[var7][var8] & 0x12C0180) == 0) {
					return true;
				}
				if (var7 == var9 && var10 - 1 == var8) {
					return true;
				}
			}
		}
		if (arg4 == 9) {
			if (var7 == var9 && var10 + 1 == var8 && (this.flags[var7][var8] & 0x20) == 0) {
				return true;
			}
			if (var7 == var9 && var10 - 1 == var8 && (this.flags[var7][var8] & 0x2) == 0) {
				return true;
			}
			if (var9 - 1 == var7 && var8 == var10 && (this.flags[var7][var8] & 0x8) == 0) {
				return true;
			}
			if (var9 + 1 == var7 && var8 == var10 && (this.flags[var7][var8] & 0x80) == 0) {
				return true;
			}
		}
		return false;
	}

	// jag::oldscape::movement::CollisionMap::TestWDecor
	@ObfuscatedName("ck.s(IIIIIIB)Z")
	public boolean testWDecor(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
		if (arg0 == arg2 && arg1 == arg3) {
			return true;
		}
		int var7 = arg0 - this.startX;
		int var8 = arg1 - this.startZ;
		int var9 = arg2 - this.startX;
		int var10 = arg3 - this.startZ;
		if (arg4 == 6 || arg4 == 7) {
			if (arg4 == 7) {
				arg5 = arg5 + 2 & 0x3;
			}
			if (arg5 == 0) {
				if (var9 + 1 == var7 && var8 == var10 && (this.flags[var7][var8] & 0x80) == 0) {
					return true;
				}
				if (var7 == var9 && var10 - 1 == var8 && (this.flags[var7][var8] & 0x2) == 0) {
					return true;
				}
			} else if (arg5 == 1) {
				if (var9 - 1 == var7 && var8 == var10 && (this.flags[var7][var8] & 0x8) == 0) {
					return true;
				}
				if (var7 == var9 && var10 - 1 == var8 && (this.flags[var7][var8] & 0x2) == 0) {
					return true;
				}
			} else if (arg5 == 2) {
				if (var9 - 1 == var7 && var8 == var10 && (this.flags[var7][var8] & 0x8) == 0) {
					return true;
				}
				if (var7 == var9 && var10 + 1 == var8 && (this.flags[var7][var8] & 0x20) == 0) {
					return true;
				}
			} else if (arg5 == 3) {
				if (var9 + 1 == var7 && var8 == var10 && (this.flags[var7][var8] & 0x80) == 0) {
					return true;
				}
				if (var7 == var9 && var10 + 1 == var8 && (this.flags[var7][var8] & 0x20) == 0) {
					return true;
				}
			}
		}
		if (arg4 == 8) {
			if (var7 == var9 && var10 + 1 == var8 && (this.flags[var7][var8] & 0x20) == 0) {
				return true;
			}
			if (var7 == var9 && var10 - 1 == var8 && (this.flags[var7][var8] & 0x2) == 0) {
				return true;
			}
			if (var9 - 1 == var7 && var8 == var10 && (this.flags[var7][var8] & 0x8) == 0) {
				return true;
			}
			if (var9 + 1 == var7 && var8 == var10 && (this.flags[var7][var8] & 0x80) == 0) {
				return true;
			}
		}
		return false;
	}

	// jag::oldscape::movement::CollisionMap::TestLoc
	@ObfuscatedName("ck.u(IIIIIIII)Z")
	public boolean testLoc(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
		int var8 = arg2 + arg4 - 1;
		int var9 = arg3 + arg5 - 1;
		if (arg0 >= arg2 && arg0 <= var8 && arg1 >= arg3 && arg1 <= var9) {
			return true;
		} else if (arg2 - 1 == arg0 && arg1 >= arg3 && arg1 <= var9 && (this.flags[arg0 - this.startX][arg1 - this.startZ] & 0x8) == 0 && (arg6 & 0x8) == 0) {
			return true;
		} else if (var8 + 1 == arg0 && arg1 >= arg3 && arg1 <= var9 && (this.flags[arg0 - this.startX][arg1 - this.startZ] & 0x80) == 0 && (arg6 & 0x2) == 0) {
			return true;
		} else if (arg3 - 1 == arg1 && arg0 >= arg2 && arg0 <= var8 && (this.flags[arg0 - this.startX][arg1 - this.startZ] & 0x2) == 0 && (arg6 & 0x4) == 0) {
			return true;
		} else {
			return var9 + 1 == arg1 && arg0 >= arg2 && arg0 <= var8 && (this.flags[arg0 - this.startX][arg1 - this.startZ] & 0x20) == 0 && (arg6 & 0x1) == 0;
		}
	}
}
