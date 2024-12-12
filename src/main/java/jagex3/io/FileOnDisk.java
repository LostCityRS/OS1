package jagex3.io;

import deob.ObfuscatedName;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

@ObfuscatedName("u")
public class FileOnDisk {

	@ObfuscatedName("u.r")
	public RandomAccessFile file;

	@ObfuscatedName("u.d")
	public long maxLength;

	@ObfuscatedName("u.l")
	public long pos;

	public FileOnDisk(File arg0, String arg1, long arg2) throws IOException {
		if (arg2 == -1L) {
			arg2 = Long.MAX_VALUE;
		}
		if (arg0.length() >= arg2) {
			arg0.delete();
		}
		this.file = new RandomAccessFile(arg0, arg1);
		this.maxLength = arg2;
		this.pos = 0L;
		int var5 = this.file.read();
		if (var5 != -1 && !arg1.equals("r")) {
			this.file.seek(0L);
			this.file.write(var5);
		}
		this.file.seek(0L);
	}

	@ObfuscatedName("u.r(J)V")
	public final void seek(long arg0) throws IOException {
		this.file.seek(arg0);
		this.pos = arg0;
	}

	@ObfuscatedName("u.d([BIII)V")
	public final void write(byte[] arg0, int arg1, int arg2) throws IOException {
		if (this.pos + (long) arg2 > this.maxLength) {
			this.file.seek(this.maxLength + 1L);
			this.file.write(1);
			throw new EOFException();
		} else {
			this.file.write(arg0, arg1, arg2);
			this.pos += arg2;
		}
	}

	@ObfuscatedName("u.l(I)V")
	public final void close() throws IOException {
		if (this.file != null) {
			this.file.close();
			this.file = null;
		}
	}

	@ObfuscatedName("u.m(I)J")
	public final long length() throws IOException {
		return this.file.length();
	}

	@ObfuscatedName("u.c([BIII)I")
	public final int read(byte[] arg0, int arg1, int arg2) throws IOException {
		int var4 = this.file.read(arg0, arg1, arg2);
		if (var4 > 0) {
			this.pos += var4;
		}
		return var4;
	}

	protected void finalize() throws Throwable {
		if (this.file != null) {
			System.out.println("");
			this.close();
		}
	}
}
