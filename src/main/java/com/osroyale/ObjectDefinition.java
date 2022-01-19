package com.osroyale;

import java.io.FileWriter;

public final class ObjectDefinition {

	public static void unpackConfig(StreamLoader streamLoader) {
		stream = new Buffer(streamLoader.getFile("loc.dat"));
		Buffer stream = new Buffer(streamLoader.getFile("loc.idx"));
		int totalObjects = stream.readUnsignedShort();
		streamIndices = new int[totalObjects];
		int i = 2;
		for (int index = 0; index < totalObjects; index++) {
			streamIndices[index] = i;
			i += stream.readUnsignedShort();
		}
		cache = new ObjectDefinition[20];
		for (int index = 0; index < 20; index++)
			cache[index] = new ObjectDefinition();

		boolean dump = false;
		if (dump)
			dump(totalObjects);

	}

	private final static void dump(int total) {
		try {
			fw = new FileWriter(System.getProperty("user.home") + "/Desktop/objectDump.txt");
			for (int id = 0; id < total; id++) {
				ObjectDefinition objectDump = ObjectDefinition.forID(id);
				if (objectDump != null && objectDump.name != null) {
					fw.write(id + ": " + objectDump.name);
					fw.write(System.getProperty("line.separator"));
				} else {
					fw.write(id + ": null");
					fw.write(System.getProperty("line.separator"));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	static ObjectDefinition forID(int i) {
		if (i > streamIndices.length)
			i = streamIndices.length - 1;
		for (int j = 0; j < 20; j++)
			if (cache[j].type == i)
				return cache[j];
		cacheIndex = (cacheIndex + 1) % 20;
	    /* Seers village fix */
		if (i == 25913)
			i = 15552;
		if (i == 25916 || i == 25926)
			i = 15553;
		if (i == 25917)
			i = 15554;
		ObjectDefinition objectDefinition = cache[cacheIndex];
		stream.currentOffset = streamIndices[i];
		objectDefinition.type = i;
		objectDefinition.setDefaults();
		objectDefinition.readValues(stream);

		/* Custom/Modified Objects */
		switch (i) {

			case 10081: /* Dead Ore */
			case 2194: /* Dead Ore */
			case 26756:
			case 1536://door
				objectDefinition.interactions = new String[5];
				break;

			case 27290:
				objectDefinition.name = "Blood Money Chest";
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Unlock";
				objectDefinition.interactions[1] = "Status";
				objectDefinition.interactions[2] = "Guide";
				objectDefinition.modifiedModelColors = new int[]{14499, 12698, 12818, 12480, 12492, 14554, 13545};
				objectDefinition.originalModelColors = new int[]{947, 45, 30, 100, 100, 100, 100};
				objectDefinition.description = "This chest can only be opened with a Blood key.".getBytes();
				break;

			case 2191:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Unlock";
				objectDefinition.name = "Crystal Chest";
				break;

			case 25029:
			case 25016:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Push-through";
				break;

			case 5249:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Add-logs";
				break;

			case 27215:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Attack";
				break;

			case 3994:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Smelt";
				break;

			case 29776:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "View";
				objectDefinition.name = "PvP Leaderboard";
				break;

			case 24099:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "View";
				objectDefinition.name = "Bot Loot";
				break;

			case 22472://Tab Creation
				objectDefinition.name = "Tablet";
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Open";
				break;


			case 14826:
			case 14827:
			case 14828:
			case 14829:
			case 14830:
			case 14831:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Activate";
				objectDefinition.interactions[1] = "Set Destination";
				break;

			case 23885:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Enter";
				objectDefinition.name = "Arena stairs";
				break;

			case 11338:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Access";
				objectDefinition.name = "Clan Bank";
				objectDefinition.description = "The bank of the clan.".getBytes();
				break;

			case 884:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Activate";
				objectDefinition.interactions[1] = "Check";
				objectDefinition.name = "Well of Goodwill";
				objectDefinition.description = "A well that is filled with will of the good.".getBytes();
				objectDefinition.modelIds = new int[]{10460};
				objectDefinition.solid = true;
				objectDefinition.aBoolean779 = false;
				break;

			case 16254:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Open";
				objectDefinition.name = "Teleportation Menu";
				objectDefinition.description = "Teleport around the world in ease!".getBytes();
				break;

			case 11546:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Access";
				objectDefinition.name = "Management machine";
				objectDefinition.description = "A machine that manages players.".getBytes();
				break;

			case 26043:
				objectDefinition.name = "Marketplace";
				objectDefinition.description = "Buy/sell items using the Player owned shops.".getBytes();
				objectDefinition.interactions = new String[]{"Access", null, null, null, null};
				objectDefinition.modelIds = new int[]{55555};
				objectDefinition.solid = true;
				objectDefinition.aBoolean779 = false;
				break;

			case 10090:
				objectDefinition.name = "Marketplace Information";
				objectDefinition.description = "Information regarding the marketplace.".getBytes();
				objectDefinition.interactions = new String[]{"Read", null, null, null, null};
				objectDefinition.modelIds = new int[]{55557};
				objectDefinition.solid = true;
				objectDefinition.aBoolean779 = false;
				break;

			case 26782:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Recharge";
				break;

			case 29150:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Pray";
				break;

			case 29241:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Drink";
				break;

            /* Donator deposit box */
			case 26254:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Deposit";
				objectDefinition.name = "Donator box";
				objectDefinition.description = "A donator-only feature which allows members to quick deposit items.".getBytes();
				break;

		/* Grand exchange desk */
			case 26044:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Open";
				objectDefinition.interactions[1] = "Manage";
				objectDefinition.name = "Marketplace";
				objectDefinition.description = "The marketplace desk.".getBytes();
				break;

		/* Wilderness Sign */
			case 14503:
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Read";
				break;

		/* Magic Book Statue */
			case 576:
				objectDefinition.name = "Magic book";
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Change";
				break;

		/* Prayer Statue */
			case 575:
				objectDefinition.name = "Prayer";
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Recharge";
				break;

		/* Fountain of Charges */
			case 12089:
				objectDefinition.name = "Fountain of Charges";
				objectDefinition.interactions = new String[5];
				objectDefinition.interactions[0] = "Inspect";
				break;
		}

		return objectDefinition;
	}

	public void setDefaults() {
		modelIds = null;
		anIntArray776 = null;
		name = null;
		description = null;
		modifiedModelColors = null;
		originalModelColors = null;
		originalTexture = null;
		modifiedTexture = null;
		width = 1;
		length = 1;
		solid = true;
		impenetrable = true;
		interactive = false;
		aBoolean762 = false;
		aBoolean769 = false;
		aBoolean764 = false;
		anInt781 = -1;
		anInt775 = 16;
		aByte737 = 0;
		aByte742 = 0;
		interactions = null;
		anInt746 = -1;
		anInt758 = -1;
		aBoolean751 = false;
		aBoolean779 = true;
		anInt748 = 128;
		anInt772 = 128;
		anInt740 = 128;
		anInt768 = 0;
		anInt738 = 0;
		anInt745 = 0;
		anInt783 = 0;
		obstructsGround = false;
		removeClipping = false;
		anInt760 = -1;
		anInt774 = -1;
		anInt749 = -1;
		childrenIDs = null;
	}

	public void method574(ResourceProvider provider) {
		if (modelIds == null)
			return;
		for (int j = 0; j < modelIds.length; j++)
			provider.method560(modelIds[j] & 0xffff, 0);
	}

	public static void nullLoader() {
		mruNodes1 = null;
		mruNodes2 = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}

	public boolean method577(int i) {
		Model model = (Model) mruNodes2.get(type);
		if (anIntArray776 == null) {
			if (modelIds == null)
				return true;
			if (i != 10)
				return true;
			boolean flag1 = true;
			for (int k = 0; k < modelIds.length; k++)
				flag1 &= Model.isCached(modelIds[k] & 0xffff);
			return flag1;
		}
		for (int j = 0; j < anIntArray776.length; j++)
			if (anIntArray776[j] == i)
				return Model.isCached(modelIds[j] & 0xffff);
		return true;
	}

	public Model method578(int i, int j, int k, int l, int i1, int j1, int k1) {
		Model model = method581(i, k1, j);
		if (model == null)
			return null;
		if (aBoolean762 || aBoolean769)
			model = new Model(aBoolean762, aBoolean769, model);
		if (aBoolean762) {
			int l1 = (k + l + i1 + j1) / 4;
			for (int i2 = 0; i2 < model.anInt1626; i2++) {
				int j2 = model.anIntArray1627[i2];
				int k2 = model.anIntArray1629[i2];
				int l2 = k + ((l - k) * (j2 + 64)) / 128;
				int i3 = j1 + ((i1 - j1) * (j2 + 64)) / 128;
				int j3 = l2 + ((i3 - l2) * (k2 + 64)) / 128;
				model.anIntArray1628[i2] += j3 - l1;
			}
			model.method467();
		}
		return model;
	}

	public boolean method579() {
		if (modelIds == null)
			return true;
		boolean flag1 = true;
		for (int i = 0; i < modelIds.length; i++)
			flag1 &= Model.isCached(modelIds[i] & 0xffff);
		return flag1;
	}

	public ObjectDefinition method580() {
		int i = -1;
		if (anInt774 != -1) {
			VarBit varBit = VarBit.cache[anInt774];
			int j = varBit.anInt648;
			int k = varBit.anInt649;
			int l = varBit.anInt650;
			int i1 = Client.anIntArray1232[l - k];
			i = clientInstance.settings[j] >> k & i1;
		} else if (anInt749 != -1)
			i = clientInstance.settings[anInt749];
		if (i < 0 || i >= childrenIDs.length || childrenIDs[i] == -1)
			return null;
		else
			return forID(childrenIDs[i]);
	}

	public Model method581(int j, int k, int l) {
		Model model = null;
		long l1;
		if (anIntArray776 == null) {
			if (j != 10)
				return null;
			l1 = (long) ((type << 8) + l) + ((long) (k + 1) << 32);
			Model model_1 = (Model) mruNodes2.get(l1);
			if (model_1 != null)
				return model_1;
			if (modelIds == null)
				return null;
			boolean flag1 = aBoolean751 ^ (l > 3);
			int k1 = modelIds.length;
			for (int i2 = 0; i2 < k1; i2++) {
				int l2 = modelIds[i2];
				if (flag1)
					l2 += 0x10000;
				model = (Model) mruNodes1.get(l2);
				if (model == null) {
					model = Model.getModel(l2 & 0xffff);
					if (model == null)
						return null;
					if (flag1)
						model.method477();
					mruNodes1.put(model, l2);
				}
				if (k1 > 1)
					aModelArray741s[i2] = model;
			}

			if (k1 > 1)
				model = new Model(k1, aModelArray741s);
		} else {
			int i1 = -1;
			for (int j1 = 0; j1 < anIntArray776.length; j1++) {
				if (anIntArray776[j1] != j)
					continue;
				i1 = j1;
				break;
			}

			if (i1 == -1)
				return null;
			l1 = (long) ((type << 8) + (i1 << 3) + l) + ((long) (k + 1) << 32);
			Model model_2 = (Model) mruNodes2.get(l1);
			if (model_2 != null)
				return model_2;
			int j2 = modelIds[i1];
			boolean flag3 = aBoolean751 ^ (l > 3);
			if (flag3)
				j2 += 0x10000;
			model = (Model) mruNodes1.get(j2);
			if (model == null) {
				model = Model.getModel(j2 & 0xffff);
				if (model == null)
					return null;
				if (flag3)
					model.method477();
				mruNodes1.put(model, j2);
			}
		}
		boolean flag;
		flag = anInt748 != 128 || anInt772 != 128 || anInt740 != 128;
		boolean flag2;
		flag2 = anInt738 != 0 || anInt745 != 0 || anInt783 != 0;
		Model model_3 = new Model(modifiedModelColors == null, Frame.method532(k), l == 0 && k == -1 && !flag && !flag2, modifiedTexture == null, model);
		if (k != -1) {
			model_3.skin();
			model_3.method470(k);
			model_3.anIntArrayArray1658 = null;
			model_3.anIntArrayArray1657 = null;
		}
		while (l-- > 0)
			model_3.method473();
		if (modifiedModelColors != null) {
			for (int k2 = 0; k2 < modifiedModelColors.length; k2++)
				model_3.recolor(modifiedModelColors[k2], originalModelColors[k2]);

		}
		if (modifiedTexture != null) {
			for (int k2 = 0; k2 < modifiedTexture.length; k2++)
				model_3.retexture(modifiedTexture[k2], originalTexture[k2]);

		}
		if (flag)
			model_3.method478(anInt748, anInt740, anInt772);
		if (flag2)
			model_3.method475(anInt738, anInt745, anInt783);

		if (Settings.CUSTOM_LIGHTING) {
			model_3.light(84, 1500, -90, -280, -70, !aBoolean769);
		} else {
			model_3.light(64 + aByte737, 768 + aByte742 * 5, -50, -10, -50, !aBoolean769);
		}
		if (anInt760 == 1)
			model_3.anInt1654 = model_3.modelHeight;
		mruNodes2.put(model_3, l1);
		return model_3;
	}

	public void readValues(Buffer stream) {
		do {
			int opcode = stream.readUnsignedByte();
			if (opcode == 0)
				break;
			if (opcode == 1) {
				int len = stream.readUnsignedByte();
				if (len > 0) {
					if (modelIds == null || lowMem) {
						anIntArray776 = new int[len];
						modelIds = new int[len];
						for (int k1 = 0; k1 < len; k1++) {
							modelIds[k1] = stream.readUnsignedShort();
							anIntArray776[k1] = stream.readUnsignedByte();
						}
					} else {
						stream.currentOffset += len * 3;
					}
				}
			} else if (opcode == 2)
				name = stream.readString();
			else if (opcode == 3)
				description = stream.readBytes();
			else if (opcode == 5) {
				int len = stream.readUnsignedByte();
				if (len > 0) {
					if (modelIds == null || lowMem) {
						anIntArray776 = null;
						modelIds = new int[len];
						for (int l1 = 0; l1 < len; l1++)
							modelIds[l1] = stream.readUnsignedShort();
					} else {
						stream.currentOffset += len * 2;
					}
				}
			} else if (opcode == 14)
				width = stream.readUnsignedByte();
			else if (opcode == 15)
				length = stream.readUnsignedByte();
			else if (opcode == 17)
				solid = false;
			else if (opcode == 18)
				impenetrable = false;
			else if (opcode == 19)
				interactive = (stream.readUnsignedByte() == 1);
			else if (opcode == 21)
				aBoolean762 = true;
			else if (opcode == 22)
				aBoolean769 = true;
			else if (opcode == 23)
				aBoolean764 = true;
			else if (opcode == 24) {
				anInt781 = stream.readUnsignedShort();
				if (anInt781 == 65535)
					anInt781 = -1;
			} else if (opcode == 28)
				anInt775 = stream.readUnsignedByte();
			else if (opcode == 29)
				aByte737 = stream.readSignedByte();
			else if (opcode == 39)
				aByte742 = stream.readSignedByte();
			else if (opcode >= 30 && opcode < 39) {
				if (interactions == null)
					interactions = new String[5];
				interactions[opcode - 30] = stream.readString();
				if (interactions[opcode - 30].equalsIgnoreCase("hidden"))
					interactions[opcode - 30] = null;
			} else if (opcode == 40) {
				int i1 = stream.readUnsignedByte();
				modifiedModelColors = new int[i1];
				originalModelColors = new int[i1];
				for (int i2 = 0; i2 < i1; i2++) {
					modifiedModelColors[i2] = stream.readUnsignedShort();
					originalModelColors[i2] = stream.readUnsignedShort();
				}
			} else if (opcode == 41) {
				int j = stream.readUnsignedByte();
				modifiedTexture = new short[j];
				originalTexture = new short[j];
				for (int k = 0; k < j; k++) {
					modifiedTexture[k] = (short) stream.readUnsignedShort();
					originalTexture[k] = (short) stream.readUnsignedShort();
				}

			} else if (opcode == 82)
				anInt746 = stream.readUnsignedShort();
			else if (opcode == 62)
				aBoolean751 = true;
			else if (opcode == 64)
				aBoolean779 = false;
			else if (opcode == 65)
				anInt748 = stream.readUnsignedShort();
			else if (opcode == 66)
				anInt772 = stream.readUnsignedShort();
			else if (opcode == 67)
				anInt740 = stream.readUnsignedShort();
			else if (opcode == 68)
				anInt758 = stream.readUnsignedShort();
			else if (opcode == 69)
				anInt768 = stream.readUnsignedByte();
			else if (opcode == 70)
				anInt738 = stream.readSignedWord();
			else if (opcode == 71)
				anInt745 = stream.readSignedWord();
			else if (opcode == 72)
				anInt783 = stream.readSignedWord();
			else if (opcode == 73)
				obstructsGround = true;
			else if (opcode == 74)
				removeClipping = true;
			else if (opcode == 75)
				anInt760 = stream.readUnsignedByte();
			else if (opcode == 77) {
				anInt774 = stream.readUnsignedShort();
				if (anInt774 == 65535)
					anInt774 = -1;
				anInt749 = stream.readUnsignedShort();
				if (anInt749 == 65535)
					anInt749 = -1;
				int j1 = stream.readUnsignedByte();
				childrenIDs = new int[j1 + 1];
				for (int j2 = 0; j2 <= j1; j2++) {
					childrenIDs[j2] = stream.readUnsignedShort();
					if (childrenIDs[j2] == 65535)
						childrenIDs[j2] = -1;
				}
			}
		} while (true);

		if (name != null && !name.equals("null")) {
			interactive = modelIds != null && (anIntArray776 == null || anIntArray776[0] == 10);
			if (interactions != null)
				interactive = true;
		}

		if (removeClipping) {
			solid = false;
			impenetrable = false;
		}

		if (anInt760 == -1)
			anInt760 = solid ? 1 : 0;
	}

	public ObjectDefinition() {
		type = -1;
	}

	private short[] originalTexture;
	private short[] modifiedTexture;
	public boolean obstructsGround;
	public byte aByte737;
	public int anInt738;
	public String name;
	public int anInt740;
	public static final Model[] aModelArray741s = new Model[4];
	public byte aByte742;
	public int width;
	public int anInt745;
	public int anInt746;
	public int[] originalModelColors;
	public int anInt748;
	public int anInt749;
	public boolean aBoolean751;
	public static boolean lowMem;
	public static Buffer stream;
	public int type;
	public static int[] streamIndices;
	public boolean impenetrable;
	public int anInt758;
	public int childrenIDs[];
	public int anInt760;
	public int length;
	public boolean aBoolean762;
	public boolean aBoolean764;
	public static Client clientInstance;
	public boolean removeClipping;
	public boolean solid;
	public int anInt768;
	public boolean aBoolean769;
	public static int cacheIndex;
	public int anInt772;
	public int[] modelIds;
	public int anInt774;
	public int anInt775;
	public int[] anIntArray776;
	public byte description[];
	public boolean interactive;
	public boolean aBoolean779;
	public static Cache mruNodes2 = new Cache(30);
	public int anInt781;
	public static ObjectDefinition[] cache;
	public int anInt783;
	public int[] modifiedModelColors;
	public static Cache mruNodes1 = new Cache(500);
	public String interactions[];
	private static FileWriter fw;
}
