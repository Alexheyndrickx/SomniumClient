package com.osroyale;

public final class Graphic {

	static void unpackConfig(StreamLoader streamLoader) {
		Buffer stream = new Buffer(streamLoader.getFile("spotanim.dat"));
		int length = stream.readUnsignedShort();
		if (cache == null)
			cache = new Graphic[length + 50000];
		for (int j = 0; j < length; j++) {
			if (cache[j] == null)
				cache[j] = new Graphic();
			cache[j].anInt404 = j;
			cache[j].decode(stream);

			switch (j) {
			}
		}
	}

	public void decode(Buffer buffer) {
		while (true) {
			int opcode = buffer.readUnsignedByte();

			if (opcode == 0) {
				return;
			} else if (opcode == 1) {
				modelId = buffer.readUnsignedShort();
			} else if (opcode == 2) {
				animationId = buffer.readUnsignedShort();
				if (Animation.animations != null) {
					animationSequence = Animation.animations[animationId];
				}
			} else if (opcode == 4) {
				resizeXY = buffer.readUnsignedShort();
			} else if (opcode == 5) {
				resizeZ = buffer.readUnsignedShort();
			} else if (opcode == 6) {
				rotation = buffer.readUnsignedShort();
			} else if (opcode == 7) {
				modelBrightness = buffer.readUnsignedShort();
			} else if (opcode == 8) {
				modelShadow = buffer.readUnsignedShort();
			} else if (opcode == 40) {
				int length = buffer.readUnsignedByte();
				for (int index = 0; index < length; index++) {
					originalModelColours[index] = buffer.readUnsignedShort();
					modifiedModelColours[index] = buffer.readUnsignedShort();
				}
			} else if (opcode == 41) {
				int length = buffer.readUnsignedByte();
				for (int index = 0; index < length; ++index) {
					int holder1 = buffer.readUnsignedShort();
					int holder2 = buffer.readUnsignedShort();
				}
			} else {
				System.out.println("Error graphics opcode: " + opcode);
			}
		}
	}

	private void readValues(Buffer stream) {
		do {
			int i = stream.readUnsignedByte();
			if (i == 0)
				return;
			if (i == 1)
				modelId = stream.readUnsignedShort();
			else if (i == 2) {
				animationId = stream.readUnsignedShort();
				if (Animation.animations != null)
					animationSequence = Animation.animations[animationId];
			} else if (i == 4)
				resizeXY = stream.readUnsignedShort();
			else if (i == 5)
				resizeZ = stream.readUnsignedShort();
			else if (i == 6)
				rotation = stream.readUnsignedShort();
			else if (i == 7)
				modelBrightness = stream.readUnsignedShort();
			else if (i == 8)
				modelShadow = stream.readUnsignedShort();
			else if (i == 40) {
				int j = stream.readUnsignedByte();
				for (int k = 0; k < j; k++) {
					originalModelColours[k] = stream.readUnsignedShort();
					modifiedModelColours[k] = stream.readUnsignedShort();
				}
			} else
				System.out.println("Error unrecognised spotanim config code: " + i);
		} while (true);
	}

	public Model getModel() {
		Model model = (Model) aMRUNodes_415.get(anInt404);
		if (model != null)
			return model;
		model = Model.getModel(modelId);
		if (model == null)
			return null;
		for (int i = 0; i < 6; i++)
			if (originalModelColours[0] != 0)
				model.recolor(originalModelColours[i], modifiedModelColours[i]);

		aMRUNodes_415.put(model, anInt404);
		return model;
	}

	private Graphic() {
		animationId = -1;
		originalModelColours = new int[6];
		modifiedModelColours = new int[6];
		resizeXY = 128;
		resizeZ = 128;
	}

	public static Graphic cache[];
	private int anInt404;
	int modelId;
	private int animationId;
	Animation animationSequence;
	private final int[] originalModelColours;
	private final int[] modifiedModelColours;
	int resizeXY;
	int resizeZ;
	int rotation;
	int modelBrightness;
	int modelShadow;
	static Cache aMRUNodes_415 = new Cache(30);

}
