package jagex3.reflectionchecker;

import deob.ObfuscatedName;
import jagex3.datastruct.Linkable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@ObfuscatedName("ek")
public class ReflectionCheck extends Linkable {

	@ObfuscatedName("ek.m")
	public byte[][][] methodArgs;

	@ObfuscatedName("ek.c")
	public int id;

	@ObfuscatedName("ek.n")
	public int size;

	@ObfuscatedName("ek.j")
	public int[] type;

	@ObfuscatedName("ek.z")
	public int[] error;

	@ObfuscatedName("ek.g")
	public Field[] field;

	@ObfuscatedName("ek.q")
	public int[] fieldValue;

	@ObfuscatedName("ek.i")
	public Method[] method;
}
