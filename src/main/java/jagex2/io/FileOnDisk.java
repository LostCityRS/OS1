package jagex2.io;

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

	public FileOnDisk(File file, String arg1, long maxLength) throws IOException {
		if (maxLength == -1L) {
			maxLength = Long.MAX_VALUE;
		}

		if (file.length() >= maxLength) {
			file.delete();
		}

		this.file = new RandomAccessFile(file, arg1);
		this.maxLength = maxLength;
		this.pos = 0L;

		int test = this.file.read();
		if (test != -1 && !arg1.equals("r")) {
			this.file.seek(0L);
			this.file.write(test);
		}

		this.file.seek(0L);
	}

	@ObfuscatedName("u.r(J)V")
	public final void seek(long off) throws IOException {
		this.file.seek(off);
		this.pos = off;
	}

	@ObfuscatedName("u.d([BIII)V")
	public final void write(byte[] data, int off, int len) throws IOException {
		if (this.pos + (long) len > this.maxLength) {
			this.file.seek(this.maxLength + 1L);
			this.file.write(1);
			throw new EOFException();
		} else {
			this.file.write(data, off, len);
			this.pos += len;
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
	public final int read(byte[] data, int off, int len) throws IOException {
		int bytes = this.file.read(data, off, len);
		if (bytes > 0) {
			this.pos += bytes;
		}
		return bytes;
	}

	protected void finalize() throws Throwable {
		if (this.file != null) {
			System.out.println("");
			this.close();
		}
	}
}
