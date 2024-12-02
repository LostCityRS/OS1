package jagex2.io;

import deob.ObfuscatedName;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

@ObfuscatedName("u")
public class FileOnDisk {

	@ObfuscatedName("u.r")
	public RandomAccessFile field202;

	@ObfuscatedName("u.d")
	public long field201;

	@ObfuscatedName("u.l")
	public long field200;

	public FileOnDisk(File arg0, String arg1, long arg2) throws IOException {
		if (arg2 == -1L) {
			arg2 = Long.MAX_VALUE;
		}
		if (arg0.length() >= arg2) {
			arg0.delete();
		}
		this.field202 = new RandomAccessFile(arg0, arg1);
		this.field201 = arg2;
		this.field200 = 0L;
		int var5 = this.field202.read();
		if (var5 != -1 && !arg1.equals("r")) {
			this.field202.seek(0L);
			this.field202.write(var5);
		}
		this.field202.seek(0L);
	}

	@ObfuscatedName("u.r(J)V")
	public final void method110(long arg0) throws IOException {
		this.field202.seek(arg0);
		this.field200 = arg0;
	}

	@ObfuscatedName("u.d([BIII)V")
	public final void method111(byte[] arg0, int arg1, int arg2) throws IOException {
		if (this.field200 + (long) arg2 > this.field201) {
			this.field202.seek(this.field201 + 1L);
			this.field202.write(1);
			throw new EOFException();
		} else {
			this.field202.write(arg0, arg1, arg2);
			this.field200 += arg2;
		}
	}

	@ObfuscatedName("u.l(I)V")
	public final void method112() throws IOException {
		if (this.field202 != null) {
			this.field202.close();
			this.field202 = null;
		}
	}

	@ObfuscatedName("u.m(I)J")
	public final long method113() throws IOException {
		return this.field202.length();
	}

	@ObfuscatedName("u.c([BIII)I")
	public final int method114(byte[] arg0, int arg1, int arg2) throws IOException {
		int var4 = this.field202.read(arg0, arg1, arg2);
		if (var4 > 0) {
			this.field200 += var4;
		}
		return var4;
	}

	public void finalize() throws Throwable {
		if (this.field202 != null) {
			System.out.println("");
			this.method112();
		}
	}
}
