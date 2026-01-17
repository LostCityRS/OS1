package jagex3.js5;

import deob.ObfuscatedName;
import jagex3.datastruct.DoublyLinkList;
import jagex3.datastruct.HashTable;
import jagex3.datastruct.MonotonicTime;
import jagex3.io.ClientStream;
import jagex3.io.Packet;

import java.io.IOException;
import java.util.zip.CRC32;

@ObfuscatedName("cu")
public class Js5Net {

	@ObfuscatedName("g.r")
	public static ClientStream stream;

	@ObfuscatedName("cu.d")
	public static int timeoutMs = 0;

	@ObfuscatedName("bo.l")
	public static long lastTickMs;

	@ObfuscatedName("cu.m")
	public static HashTable pendingUrgentQueue = new HashTable(4096);

	@ObfuscatedName("cu.c")
	public static int pendingUrgentQueueSize = 0;

	@ObfuscatedName("cu.n")
	public static HashTable urgentQueue = new HashTable(32);

	@ObfuscatedName("cu.j")
	public static int urgentQueueSize = 0;

	@ObfuscatedName("cu.z")
	public static DoublyLinkList requestQueue = new DoublyLinkList();

	@ObfuscatedName("cu.g")
	public static HashTable pendingPrefetchQueue = new HashTable(4096);

	@ObfuscatedName("cu.q")
	public static int pendingPrefetchQueueSize = 0;

	@ObfuscatedName("cu.i")
	public static HashTable prefetchQueue = new HashTable(4096);

	@ObfuscatedName("cu.s")
	public static int prefetchQueueSize = 0;

	@ObfuscatedName("cu.u")
	public static boolean incomingUrgentRequest;

	@ObfuscatedName("bx.v")
	public static Js5NetRequest incomingRequest;

	@ObfuscatedName("cu.w")
	public static Packet incomingTransferHeader = new Packet(8);

	@ObfuscatedName("cu.e")
	public static Packet incomingGroupBuffer;

	@ObfuscatedName("cu.b")
	public static int incomingChunkPos = 0;

	@ObfuscatedName("cu.t")
	public static CRC32 crc32 = new CRC32();

	@ObfuscatedName("ab.f")
	public static Packet masterIndexBuffer;

	@ObfuscatedName("cu.k")
	public static Js5Loader[] field1200 = new Js5Loader[256];

	@ObfuscatedName("cu.o")
	public static byte xorKey = 0;

	@ObfuscatedName("cu.a")
	public static int crcErrorCount = 0;

	@ObfuscatedName("cu.h")
	public static int ioErrorCount = 0;

	public Js5Net() throws Throwable {
		throw new Error();
	}

	@ObfuscatedName("by.r(B)Z")
	public static boolean loop() {
		long currentTimeMs = MonotonicTime.currentTime();
		int timeDelta = (int) (currentTimeMs - lastTickMs);
		lastTickMs = currentTimeMs;
		if (timeDelta > 200) {
			timeDelta = 200;
		}
		timeoutMs += timeDelta;
		if (prefetchQueueSize == 0 && urgentQueueSize == 0 && pendingPrefetchQueueSize == 0 && pendingUrgentQueueSize == 0) {
			return true;
		} else if (stream == null) {
			return false;
		} else {
			try {
				if (timeoutMs > 30000) {
					throw new IOException();
				}
				while (urgentQueueSize < 20 && pendingUrgentQueueSize > 0) {
					Js5NetRequest pendingUrgentRequest = (Js5NetRequest) pendingUrgentQueue.first();
					Packet packet = new Packet(4);
					packet.p1(1);
					packet.p3((int) pendingUrgentRequest.key);
					stream.write(packet.data, 0, 4);
					urgentQueue.put(pendingUrgentRequest, pendingUrgentRequest.key);
					pendingUrgentQueueSize--;
					urgentQueueSize++;
				}
				while (prefetchQueueSize < 20 && pendingPrefetchQueueSize > 0) {
					Js5NetRequest pendingPrefetchRequest = (Js5NetRequest) requestQueue.head();
					Packet packet = new Packet(4);
					packet.p1(0);
					packet.p3((int) pendingPrefetchRequest.key);
					stream.write(packet.data, 0, 4);
					pendingPrefetchRequest.unlink2();
					prefetchQueue.put(pendingPrefetchRequest, pendingPrefetchRequest.key);
					pendingPrefetchQueueSize--;
					prefetchQueueSize++;
				}
				for (int i = 0; i < 100; i++) {
					int availableBytes = stream.available();
					if (availableBytes < 0) {
						throw new IOException();
					}
					if (availableBytes == 0) {
						break;
					}
					timeoutMs = 0;
					byte headerSize = 0;
					if (incomingRequest == null) {
						headerSize = 8;
					} else if (incomingChunkPos == 0) {
						headerSize = 1;
					}
					if (headerSize > 0) {
						int readableBytes = headerSize - incomingTransferHeader.pos;
						if (readableBytes > availableBytes) {
							readableBytes = availableBytes;
						}
						stream.read(incomingTransferHeader.data, incomingTransferHeader.pos, readableBytes);
						if (xorKey != 0) {
							for (int j = 0; j < readableBytes; j++) {
								incomingTransferHeader.data[incomingTransferHeader.pos + j] ^= xorKey;
							}
						}
						incomingTransferHeader.pos += readableBytes;
						if (incomingTransferHeader.pos < headerSize) {
							break;
						}
						if (incomingRequest == null) {
							incomingTransferHeader.pos = 0;
							int archiveId = incomingTransferHeader.g1();
							int groupId = incomingTransferHeader.g2();
							int compressionType = incomingTransferHeader.g1();
							int compressedSize = incomingTransferHeader.g4();
							long key = ((long) archiveId << 16) + groupId;
							Js5NetRequest request = (Js5NetRequest) urgentQueue.get(key);
							incomingUrgentRequest = true;

							if (request == null) {
								request = (Js5NetRequest) prefetchQueue.get(key);
								incomingUrgentRequest = false;
							}
							if (request == null) {
								throw new IOException();
							}
							int groupHeaderSize = compressionType == 0 ? 5 : 9;
							incomingRequest = request;
							incomingGroupBuffer = new Packet(compressedSize + groupHeaderSize + incomingRequest.padding);
							incomingGroupBuffer.p1(compressionType);
							incomingGroupBuffer.p4(compressedSize);
							incomingChunkPos = 8;
							incomingTransferHeader.pos = 0;
						} else if (incomingChunkPos == 0) {
							if (incomingTransferHeader.data[0] == -1) {
								incomingChunkPos = 1;
								incomingTransferHeader.pos = 0;
							} else {
								incomingRequest = null;
							}
						}
					} else {
						int remainingBytes = incomingGroupBuffer.data.length - incomingRequest.padding;
						int chunkRemainingBytes = 512 - incomingChunkPos;
						if (chunkRemainingBytes > remainingBytes - incomingGroupBuffer.pos) {
							chunkRemainingBytes = remainingBytes - incomingGroupBuffer.pos;
						}
						if (chunkRemainingBytes > availableBytes) {
							chunkRemainingBytes = availableBytes;
						}
						stream.read(incomingGroupBuffer.data, incomingGroupBuffer.pos, chunkRemainingBytes);
						if (xorKey != 0) {
							for (int j = 0; j < chunkRemainingBytes; j++) {
								incomingGroupBuffer.data[incomingGroupBuffer.pos + j] ^= xorKey;
							}
						}
						incomingGroupBuffer.pos += chunkRemainingBytes;
						incomingChunkPos += chunkRemainingBytes;
						if (incomingGroupBuffer.pos == remainingBytes) {
							if (incomingRequest.key == 0xff00ffL) {
								masterIndexBuffer = incomingGroupBuffer;
								for (int j = 0; j < 256; j++) {
									Js5Loader provider = field1200[j];
									if (provider != null) {
										masterIndexBuffer.pos = j * 8 + 5;
										int indexCrc = masterIndexBuffer.g4();
										int indexVersion = masterIndexBuffer.g4();
										provider.method1476(indexCrc, indexVersion);
									}
								}
							} else {
								crc32.reset();
								crc32.update(incomingGroupBuffer.data, 0, remainingBytes);
								int crc = (int) crc32.getValue();
								if (incomingRequest.expectedCrc != crc) {
									try {
										stream.close();
									} catch (Exception ignored) {
									}
									crcErrorCount++;
									stream = null;
									xorKey = (byte) (Math.random() * 255.0D + 1.0D);
									return false;
								}
								crcErrorCount = 0;
								ioErrorCount = 0;
								incomingRequest.provider.write((int) (incomingRequest.key & 0xFFFFL), incomingGroupBuffer.data, (incomingRequest.key & 0xFF0000L) == 16711680L, incomingUrgentRequest);
							}
							incomingRequest.unlink();
							if (incomingUrgentRequest) {
								urgentQueueSize--;
							} else {
								prefetchQueueSize--;
							}
							incomingChunkPos = 0;
							incomingRequest = null;
							incomingGroupBuffer = null;
						} else {
							if (incomingChunkPos != 512) {
								break;
							}
							incomingChunkPos = 0;
						}
					}
				}
				return true;
			} catch (IOException e) {
				try {
					stream.close();
				} catch (Exception ignored) {
				}
				ioErrorCount++;
				stream = null;
				return false;
			}
		}
	}

	@ObfuscatedName("p.d(ZI)V")
	public static void sendLoginLogoutPacket(boolean loggedIn) {
		if (stream == null) {
			return;
		}
		try {
			Packet packet = new Packet(4);
			packet.p1(loggedIn ? 2 : 3);
			packet.p3(0);
			stream.write(packet.data, 0, 4);
		} catch (IOException e) {
			try {
				stream.close();
			} catch (Exception ignored) {
			}
			ioErrorCount++;
			stream = null;
		}
	}

	@ObfuscatedName("q.l(Lam;ZB)V")
	public static void init(ClientStream s, boolean loggedId) {
		if (stream != null) {
			try {
				stream.close();
			} catch (Exception ignored) {
			}
			stream = null;
		}
		stream = s;
		sendLoginLogoutPacket(loggedId);
		incomingTransferHeader.pos = 0;
		incomingRequest = null;
		incomingGroupBuffer = null;
		incomingChunkPos = 0;
		while (true) {
			Js5NetRequest request = (Js5NetRequest) urgentQueue.first();
			if (request == null) {
				while (true) {
					Js5NetRequest prefetchRequest = (Js5NetRequest) prefetchQueue.first();
					if (prefetchRequest == null) {
						if (xorKey != 0) {
							try {
								Packet packet = new Packet(4);
								packet.p1(4);
								packet.p1(xorKey);
								packet.p2(0);
								stream.write(packet.data, 0, 4);
							} catch (IOException e) {
								try {
									stream.close();
								} catch (Exception ignored) {
								}
								ioErrorCount++;
								stream = null;
							}
						}
						timeoutMs = 0;
						lastTickMs = MonotonicTime.currentTime();
						return;
					}
					requestQueue.addHead(prefetchRequest);
					pendingPrefetchQueue.put(prefetchRequest, prefetchRequest.key);
					pendingPrefetchQueueSize++;
					prefetchQueueSize--;
				}
			}
			pendingUrgentQueue.put(request, request.key);
			pendingUrgentQueueSize++;
			urgentQueueSize--;
		}
	}

	@ObfuscatedName("by.m(Ldq;IIIBZI)V")
	public static void queueRequest(Js5Loader provider, int archiveId, int groupId, int expectedCrc, byte padding, boolean urgent) {
		long key = ((long) archiveId << 16) + groupId;
		Js5NetRequest pendingUrgentRequest = (Js5NetRequest) pendingUrgentQueue.get(key);
		if (pendingUrgentRequest != null) {
			return;
		}
		Js5NetRequest urgentRequest = (Js5NetRequest) urgentQueue.get(key);
		if (urgentRequest != null) {
			return;
		}
		Js5NetRequest pendingPrefetchQueue = (Js5NetRequest) Js5Net.pendingPrefetchQueue.get(key);
		if (pendingPrefetchQueue == null) {
			if (!urgent) {
				Js5NetRequest prefetchRequest = (Js5NetRequest) prefetchQueue.get(key);
				if (prefetchRequest != null) {
					return;
				}
			}
			Js5NetRequest request = new Js5NetRequest();
			request.provider = provider;
			request.expectedCrc = expectedCrc;
			request.padding = padding;
			if (urgent) {
				pendingUrgentQueue.put(request, key);
				pendingUrgentQueueSize++;
			} else {
				requestQueue.push(request);
				Js5Net.pendingPrefetchQueue.put(request, key);
				pendingPrefetchQueueSize++;
			}
		} else if (urgent) {
			pendingPrefetchQueue.unlink2();
			pendingUrgentQueue.put(pendingPrefetchQueue, key);
			pendingPrefetchQueueSize--;
			pendingUrgentQueueSize++;
		}
	}

	@ObfuscatedName("ab.c(IIS)V")
	public static void prioritizeRequest(int archiveId, int groupId) {
		long key = ((long) archiveId << 16) + groupId;
		Js5NetRequest request = (Js5NetRequest) pendingPrefetchQueue.get(key);
		if (request != null) {
			requestQueue.addHead(request);
		}
	}

	@ObfuscatedName("v.n(III)I")
	public static int transferProgress(int archiveId, int groupId) {
		long key = ((long) archiveId << 16) + groupId;
		return incomingRequest != null && incomingRequest.key == key ? incomingGroupBuffer.pos * 99 / (incomingGroupBuffer.data.length - incomingRequest.padding) + 1 : 0;
	}

	public static int urgentQueueSize() {
		return urgentQueueSize + pendingUrgentQueueSize;
	}
}
