package jagex3.client;

import deob.ObfuscatedName;

import java.math.BigInteger;

@ObfuscatedName("d")
public class PublicKeys {

	@ObfuscatedName("d.r")
	public static final BigInteger LOGIN_RSAN = new BigInteger("10001", 16);

	@ObfuscatedName("d.d")
	public static final BigInteger LOGIN_RSAE = new BigInteger("b1baf55371c5d161de2889cc95420031f4afee4f000112192b9d82fc87ab5acd6a8595bf71dac89d386879c119b8cdd98c7a62efc2b37b070b640eb06ef4726f", 16);

	public PublicKeys() throws Throwable {
		throw new Error();
	}
}
