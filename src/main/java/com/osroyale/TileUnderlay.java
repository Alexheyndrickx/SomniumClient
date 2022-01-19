package com.osroyale;

final class TileUnderlay {

	public TileUnderlay(int i, int j, int k, int l, int texture, int color, boolean flag) {
		flat = true;
		anInt716 = i;
		anInt717 = j;
		anInt718 = k;
		anInt719 = l;
		this.texture = texture;
		rgb = color;
		flat = this.texture != -1;
	}

	final int anInt716;
	final int anInt717;
	final int anInt718;
	final int anInt719;
	final int texture;
	boolean flat;
	final int rgb;
}
