package com.osroyale;

public final class FrameBase {

	public final int length;
	final int[] anIntArray342;
	final int[][] anIntArrayArray343;

	FrameBase(Buffer stream) {
		length = stream.readUnsignedShort();
		anIntArray342 = new int[length];
		anIntArrayArray343 = new int[length][];
		for (int j = 0; j < length; j++) {
			anIntArray342[j] = stream.readUnsignedShort();
		}
		for (int j = 0; j < length; j++) {
			anIntArrayArray343[j] = new int[stream.readUnsignedShort()];
		}
		for (int j = 0; j < length; j++) {
			for (int l = 0; l < anIntArrayArray343[j].length; l++) {
				anIntArrayArray343[j][l] = stream.readUnsignedShort();
			}
		}
	}
}