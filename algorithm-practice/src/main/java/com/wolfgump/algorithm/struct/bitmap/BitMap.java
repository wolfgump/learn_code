package com.wolfgump.algorithm.struct.bitmap;

public class BitMap {
	private char[] bytes;

	private int nBytes;

	public BitMap(int n) {
		this.nBytes = n;
		bytes = new char[n / 16 + 1];
	}

	public void set(int k) {
		if (k > nBytes) return;
		int bytesIndex = k / 16;
		int bitIndex = k % 16;
		bytes[bytesIndex] |= (1 << bitIndex);
	}

	public boolean get(int k) {
		if (k > nBytes) return false;
		int bytesIndex = k / 16;
		int bitIndex = k % 16;
		return (bytes[bytesIndex] & (1 << bitIndex)) != 0;
	}

	public static void main(String[] args) {
		BitMap bitMap=new BitMap(10);
		bitMap.set(8);
		System.out.println(bitMap.get(8));
	}
}
