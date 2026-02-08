package jagex3.client;

import deob.ObfuscatedName;

import java.math.BigInteger;

// jag::ClientKeys
@ObfuscatedName("d")
public class ClientKeys {

	// jag::ClientKeys::login_rsae
	@ObfuscatedName("d.r")
	public static final BigInteger LOGIN_RSAE = new BigInteger("10001", 16);

	// jag::ClientKeys::login_rsan
	@ObfuscatedName("d.d")
	public static final BigInteger LOGIN_RSAN = new BigInteger("b1baf55371c5d161de2889cc95420031f4afee4f000112192b9d82fc87ab5acd6a8595bf71dac89d386879c119b8cdd98c7a62efc2b37b070b640eb06ef4726f", 16);

	public ClientKeys() throws Throwable {
		throw new Error();
	}
}
