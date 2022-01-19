package com.osroyale;


public final class ItemDefinition {

    static void nullLoader() {
        mruNodes2 = null;
        mruNodes1 = null;
        BufferIndices = null;
        cache = null;
        Buffer = null;
    }

    boolean method192(int j) {
        int k = anInt175;
        int l = anInt166;
        if (j == 1) {
            k = anInt197;
            l = anInt173;
        }
        if (k == -1)
            return true;
        boolean flag = true;
        if (!Model.isCached(k))
            flag = false;
        if (l != -1 && !Model.isCached(l))
            flag = false;
        return flag;
    }

    static ItemDefinition lookup(int i) {
        for (int j = 0; j < 10; j++)
            if (cache[j].id == i)
                return cache[j];

        cacheIndex = (cacheIndex + 1) % 10;
        ItemDefinition itemDef = cache[cacheIndex];
        Buffer.currentOffset = BufferIndices[i];
        itemDef.id = i;
        itemDef.setDefaults();
        itemDef.readValues(Buffer);
        /* Customs added here? */

        switch (i) {
            case 13307:
                itemDef.description = "Lovely blood money!";
                break;
            case 13190:
                itemDef.name = "$10 Donator bond";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Redeem";
                itemDef.modelID = 29210;
                itemDef.modelZoom = 2300;
                itemDef.modelRotationY = 512;
                itemDef.originalModelColors = new int[]{5652, 5652, 5652, 5652, 5652, 5652, 5652};
                itemDef.modifiedModelColors = new int[]{22464, 20416, 22451, 22181, 22449, 22305, 21435};
                break;
            case 13191:
                itemDef.name = "$50 Donator bond";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Redeem";
                itemDef.modelID = 29210;
                itemDef.modelZoom = 2300;
                itemDef.modelRotationY = 512;
                itemDef.originalModelColors = new int[]{-21568, -21568, -21568, -21568, -21568, -21568, -21568};
                itemDef.modifiedModelColors = new int[]{22464, 20416, 22451, 22181, 22449, 22305, 21435};
                break;
            case 13192:
                itemDef.name = "$100 Donator bond";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Redeem";
                itemDef.modelID = 29210;
                itemDef.modelZoom = 2300;
                itemDef.modelRotationY = 512;
                itemDef.originalModelColors = new int[]{22464, 22464, 22464, 22464, 22464, 22464, 22464};
                itemDef.modifiedModelColors = new int[]{22464, 20416, 22451, 22181, 22449, 22305, 21435};
                break;
            case 13193:
                itemDef.name = "$200 Donator bond";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Redeem";
                itemDef.modelID = 29210;
                itemDef.modelZoom = 2300;
                itemDef.modelRotationY = 512;
                itemDef.originalModelColors = new int[]{-31858, -31858, -31858, -31858, -31858, -31858, -31858};
                itemDef.modifiedModelColors = new int[]{22464, 20416, 22451, 22181, 22449, 22305, 21435};
                break;
            case 13194:
                itemDef.name = "$500 Donator bond";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Redeem";
                itemDef.modelID = 29210;
                itemDef.modelZoom = 2300;
                itemDef.modelRotationY = 512;
                itemDef.originalModelColors = new int[]{8125, 8125, 8125, 8125, 8125, 8125, 8125};
                itemDef.modifiedModelColors = new int[]{22464, 20416, 22451, 22181, 22449, 22305, 21435};
                itemDef.certID = -1;
                itemDef.certTemplateID = -1;
                break;

            case 6798:
                itemDef.name = "Arrowhead scroll";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Unlock";
                break;
            case 6799:
                itemDef.name = "Masterbaiter scroll";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Unlock";
                break;
            case 6800:
                itemDef.name = "Double wood scroll";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Unlock";
                break;
            case 6801:
                itemDef.name = "Little birdy scroll";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Unlock";
                break;
            case 6802:
                itemDef.name = "The rock scroll";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Unlock";
                break;
            case 6803:
                itemDef.name = "Flame on scroll";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Unlock";
                break;
            case 11941:
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Check";
                break;
            case 7478:
                itemDef.itemActions = new String[5];
                itemDef.name = "Vote token";
                itemDef.description = "Exchange these tokens for a mystery box and vote points by speaking to Hopleez!";
                break;
            case 8038:
                itemDef.name = "Pet mystery box";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Open";
                break;
            case 6199:
                itemDef.name = "Bronze mystery box";
                itemDef.modelID = 2426;
                itemDef.modelZoom = 1180;
                itemDef.modelRotationX = 172;
                itemDef.modelRotationY = 160;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Open";
                itemDef.modifiedModelColors = new int[]{22410, 2999};
                itemDef.originalModelColors = new int[]{5652, 7050};
                break;
            case 12955:
                itemDef.name = "Silver mystery box";
                itemDef.modelID = 2426;
                itemDef.modelZoom = 1180;
                itemDef.modelRotationX = 172;
                itemDef.modelRotationY = 160;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Open";
                itemDef.modifiedModelColors = new int[]{22410, 2999};
                itemDef.originalModelColors = new int[]{115, 61};
                break;
            case 11739:
                itemDef.name = "Gold mystery box";
                itemDef.modelID = 2426;
                itemDef.modelZoom = 1180;
                itemDef.modelRotationX = 172;
                itemDef.modelRotationY = 160;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Open";
                itemDef.modifiedModelColors = new int[]{22410, 2999};
                itemDef.originalModelColors = new int[]{8128, 6073};
                break;

            case 5509:
            case 5510:
            case 5512:
            case 5514:
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Fill";
                itemDef.itemActions[2] = "Empty";
                break;

            case 5733:
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Yum";
                break;

            case 4155:
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Check";
                break;
            case 15098:
                itemDef.name = "Dice (up to 100)";
                itemDef.modelID = 47852;
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Private-roll";
                itemDef.itemActions[2] = "Clan-roll";
                itemDef.modelRotationX = 215;
                itemDef.modelRotationY = 94;
                itemDef.modelZoom = 1104;
                itemDef.brightness = 25;
                break;
            case 671:
                itemDef.name = "Baby Darth";
                itemDef.itemActions = new String[5];
                itemDef.groundActions= new String[5];
                itemDef.groundActions[0] = "Drop";
                itemDef.description = "Aw it's a little baby darth!";
                break;
            case 6831:
                itemDef.name = "Mime Box";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Open";
                itemDef.description = "Contains a random reward of mime costume, mime emote or 75k coins.";
                break;
            case 6832:
                itemDef.name = "Drill Demon Box";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Open";
                itemDef.description = "Contains a random reward of drill demon costume, drill demon emote or 75k coins.";
                break;
            case 12897:
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Open";
                itemDef.name = "Clan Showcase Box";
                itemDef.description = "Opening this box will award a random showcase item based on the clan's level.";
                break;
            case 6854:
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Open";
                itemDef.name = "Clan Resource Box";
                itemDef.description = "Inside this box contains random resources for the clan's bank.";
                break;
            case 2568:
                itemDef.itemActions[2] = "Check charges";
                break;
            case 13188:
                itemDef.name = "Dragon claws";
                itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                break;
            case 8013:
                itemDef.name = "Home teleport";
                break;
            case 20527:
                itemDef.name = "Royale tokens";
                itemDef.description = "The main currency for OS Royale.";
                itemDef.stackable = true;
                break;
            case 11188:
                itemDef.name = "2x experience (1hr)";
                itemDef.description = "This lamp will give clan members double experience for a random skill for 1 hour.";
                break;
            case 11189:
                itemDef.name = "2x experience (3hr)";
                itemDef.description = "This lamp will give clan members double experience for a random skill for 3 hour.";
                break;
            case 11679:
                itemDef.name = "2x experience (5hr)";
                itemDef.description = "This lamp will give clan members double experience for a random skill for 5 hour.";
                break;
            case 11187:
                itemDef.name = "250k experience lamp";
                itemDef.description = "This lamp will give clan members 250,000 experience for a random skill.";
                break;
            case 4447:
                itemDef.name = "500k experience lamp";
                itemDef.description = "This lamp will give clan members 500,000 experience for a random skill.";
                break;
            case 6543:
                itemDef.name = "Drop rate increase (1.5x)";
                itemDef.description = "This lamp will give clan members a 1x drop rate increase for a random boss. (15min)";
                break;
            case 7498:
                itemDef.name = "Drop rate increase (2x)";
                itemDef.description = "This lamp will give clan members a 3x drop rate increase for a random boss. (15min)";
                break;
            case 11137:
                itemDef.name = "Drop rate increase (2.5x)";
                itemDef.description = "This lamp will give clan members a 5x drop rate increase for a random boss. (15min)";
                break;
            case 11139:
                itemDef.name = "2x resource (15min)";
                itemDef.description = "This lamp will give clan members double resource rewards for 15 minutes.";
                break;
            case 12690://Armour sets
            case 12873:
            case 12875:
            case 12877:
            case 12879:
            case 12881:
            case 12883:
            case 12962:
            case 12972:
            case 12974:
            case 12984:
            case 12986:
            case 12988:
            case 12990:
            case 13000:
            case 13002:
            case 13012:
            case 13014:
            case 13024:
            case 13026:
            case 11738:
            case 9666:
            case 9670:
            case 12865:
            case 12867:
            case 12869:
            case 12871:
            case 12966:
            case 12964:
            case 12968:
            case 12970:
            case 12976:
            case 12978:
            case 12980:
            case 12982:
            case 12992:
            case 12994:
            case 12996:
            case 12998:
            case 13004:
            case 13006:
            case 13008:
            case 13010:
            case 13016:
            case 13018:
            case 13020:
            case 13022:
            case 13028:
            case 13030:
            case 13032:
            case 13034:
            case 13036:
            case 13038:
            case 12960:
            case 13173:
            case 13175:
            case 13064:
            case 13066:
                itemDef.itemActions = new String[5];
                itemDef.itemActions[0] = "Unpack";
                break;
        }

        if (itemDef.certTemplateID != -1)
            itemDef.toNote();
        return itemDef;
    }


    static void dumpList() {
        /*JsonArray array = new JsonArray();

        for (int index = 0; index < totalItems; index++) {
            try {
                ItemDefinition definition = lookup(index);

                if (definition.name == null || definition.name.equals("null") || definition.name.isEmpty())
                    continue;

                JsonObject object = new JsonObject();
                array.add(object);

                object.addProperty("id", definition.id);
                object.addProperty("name", definition.name);

                if (definition.stackable) {
                    object.addProperty("stackable", true);
                }
                if (definition.itemActions != null) {
                    for (int idx = 0; idx < definition.itemActions.length; idx++) {
                        String action = definition.itemActions[idx];
                        if (action != null) {
                            if (action.contains("Wear") || action.contains("Wield")) {
                                object.addProperty("equipable", true);
                            }
                            if (action.contains("Destroy")) {
                                object.addProperty("destroyable", true);
                            }
                        }
                    }
                }
                if (definition.certTemplateID == -1 && definition.certID != -1) {
                    object.addProperty("noted-id", definition.certID);
                }
                if (definition.certTemplateID != -1 && definition.certID != definition.id) {
                    object.addProperty("unnoted-id", definition.certID);
                }
                if (definition.value > 1) {
                    object.addProperty("base-value", definition.value);
                }
                if (definition.itemActions != null) {
                    for (int idx = 0; idx < definition.itemActions.length; idx++) {
                        String action = definition.itemActions[idx];
                        if (action != null) {
                            if (action.contains("Wield")) {
                                object.addProperty("equipment-type", "WEAPON");
                            }
                            break;
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println(index);
                e.printStackTrace();
            }
        }

        try {
            Files.write(Paths.get("./item_dump.json"), new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create().toJson(array).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    static void unpackConfig(StreamLoader archive) {
        Buffer = new Buffer(archive.getFile("obj.dat"));
        Buffer stream = new Buffer(archive.getFile("obj.idx"));
        totalItems = stream.readUnsignedShort();
        BufferIndices = new int[totalItems];
        int offset = 2;
        for (int _ctr = 0; _ctr < totalItems; _ctr++) {
            BufferIndices[_ctr] = offset;
            offset += stream.readUnsignedShort();
        }
        cache = new ItemDefinition[10];

        for (int _ctr = 0; _ctr < 10; _ctr++) {
            cache[_ctr] = new ItemDefinition();
        }
    }


    //		Buffer = new Buffer(FileUtility.readFile(SignLink.findcachedir() + "obj.dat"));
    //		Buffer Buffer = new Buffer(FileUtility.readFile(SignLink.findcachedir() + "obj.idx"));
    //		totalItems = Buffer.readUShort() + 21;
    //		BufferIndices = new int[totalItems + 50000];
    //		int i = 2;
    //		for (int j = 0; j < totalItems - 21; j++) {
    //			BufferIndices[j] = i;
    //			i += Buffer.readUShort();
    //		}
    //
    //		cache = new ItemDefinition[10];
    //		for (int k = 0; k < 10; k++)
    //			cache[k] = new ItemDefinition();

    Model method194(int j) {
        int k = anInt175;
        int l = anInt166;
        if (j == 1) {
            k = anInt197;
            l = anInt173;
        }
        if (k == -1)
            return null;
        Model model = Model.getModel(k);
        if (l != -1) {
            Model model_1 = Model.getModel(l);
            Model aclass30_sub2_sub4_sub6s[] = {model, model_1};
            model = new Model(2, aclass30_sub2_sub4_sub6s);
        }
        if (modifiedModelColors != null) {
            for (int i1 = 0; i1 < modifiedModelColors.length; i1++)
                model.recolor(modifiedModelColors[i1], originalModelColors[i1]);

        }
        return model;
    }

    boolean method195(int j) {
        int k = maleWield;
        int l = anInt188;
        int i1 = anInt185;
        if (j == 1) {
            k = femaleWield;
            l = anInt164;
            i1 = anInt162;
        }
        if (k == -1)
            return true;
        boolean flag = true;
        if (!Model.isCached(k))
            flag = false;
        if (l != -1 && !Model.isCached(l))
            flag = false;
        if (i1 != -1 && !Model.isCached(i1))
            flag = false;
        return flag;
    }

    Model method196(int i) {
        int j = maleWield;
        int k = anInt188;
        int l = anInt185;
        if (i == 1) {
            j = femaleWield;
            k = anInt164;
            l = anInt162;
        }
        if (j == -1)
            return null;
        Model model = Model.getModel(j);
        if (k != -1)
            if (l != -1) {
                Model model_1 = Model.getModel(k);
                Model model_3 = Model.getModel(l);
                Model aclass30_sub2_sub4_sub6_1s[] = {model, model_1, model_3};
                model = new Model(3, aclass30_sub2_sub4_sub6_1s);
            } else {
                Model model_2 = Model.getModel(k);
                Model aclass30_sub2_sub4_sub6s[] = {model, model_2};
                model = new Model(2, aclass30_sub2_sub4_sub6s);
            }
        if (i == 0 && aByte205 != 0)
            model.method475(0, aByte205, 0);
        if (i == 1 && aByte154 != 0)
            model.method475(0, aByte154, 0);
        if (modifiedModelColors != null) {
            for (int i1 = 0; i1 < modifiedModelColors.length; i1++)
                model.recolor(modifiedModelColors[i1], originalModelColors[i1]);

        }
        return model;
    }

    private void setDefaults() {
        modelID = 0;
        name = null;
        description = null;
        modifiedModelColors = null;
        originalModelColors = null;
        modelZoom = 2000;
        modelRotationY = 0;
        modelRotationX = 0;
        anInt204 = 0;
        modelOffset1 = 0;
        modelOffset2 = 0;
        stackable = false;
        value = 1;
        membersObject = false;
        groundActions = null;
        itemActions = null;
        maleWield = -1;
        anInt188 = -1;
        aByte205 = 0;
        femaleWield = -1;
        anInt164 = -1;
        aByte154 = 0;
        anInt185 = -1;
        anInt162 = -1;
        anInt175 = -1;
        anInt166 = -1;
        anInt197 = -1;
        anInt173 = -1;
        stackIDs = null;
        stackAmounts = null;
        certID = -1;
        certTemplateID = -1;
        anInt167 = 128;
        anInt192 = 128;
        anInt191 = 128;
        brightness = 0;
        anInt184 = 0;
        team = 0;
    }

    private void toNote() {
        ItemDefinition noted = lookup(certTemplateID);
        modelID = noted.modelID;
        modelZoom = noted.modelZoom;
        modelRotationY = noted.modelRotationY;
        modelRotationX = noted.modelRotationX;

        anInt204 = noted.anInt204;
        modelOffset1 = noted.modelOffset1;
        modelOffset2 = noted.modelOffset2;
        modifiedModelColors = noted.modifiedModelColors;
        originalModelColors = noted.originalModelColors;
        ItemDefinition unnoted = lookup(certID);
        name = unnoted.name;
        membersObject = unnoted.membersObject;
        value = unnoted.value;
        String s = "a";
        char c = unnoted.name.charAt(0);
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            s = "an";
        description = "Swap this note at any bank for " + s + " " + unnoted.name + ".";
        stackable = true;
    }

    public static Sprite getSprite(int item, int amount, int k) {
        if (k == 0) {
            Sprite sprite = (Sprite) mruNodes1.get(item);
            if (sprite != null && sprite.resizeHeight != amount && sprite.resizeHeight != -1) {

                sprite.unlink();
                sprite = null;
            }
            if (sprite != null)
                return sprite;
        }
        ItemDefinition itemDef = lookup(item);
        if (itemDef.stackIDs == null)
            amount = -1;
        if (amount > 1) {
            int i1 = -1;
            for (int j1 = 0; j1 < 10; j1++)
                if (amount >= itemDef.stackAmounts[j1] && itemDef.stackAmounts[j1] != 0)
                    i1 = itemDef.stackIDs[j1];

            if (i1 != -1)
                itemDef = lookup(i1);
        }
        Model model = itemDef.method201(1);
        if (model == null)
            return null;
        Sprite sprite = null;
        if (itemDef.certTemplateID != -1) {
            sprite = getSprite(itemDef.certID, 10, -1);
            if (sprite == null)
                return null;
        }
        Sprite enabledSprite = new Sprite(32, 32);
        int k1 = Rasterizer.textureInt1;
        int l1 = Rasterizer.textureInt2;
        int ai[] = Rasterizer.anIntArray1472;
        int ai1[] = Raster.pixels;
        int i2 = Raster.width;
        int j2 = Raster.height;
        int k2 = Raster.topX;
        int l2 = Raster.bottomX;
        int i3 = Raster.topY;
        int j3 = Raster.bottomY;
        Rasterizer.aBoolean1464 = false;
        Raster.initDrawingArea(enabledSprite.raster, 32, 32);
        Raster.fillRectangle(0, 0, 32, 32, 0);
        Rasterizer.method364();
        int k3 = itemDef.modelZoom;
        if (k == -1)
            k3 = (int) ((double) k3 * 1.5D);
        if (k > 0)
            k3 = (int) ((double) k3 * 1.04D);
        int l3 = Rasterizer.anIntArray1470[itemDef.modelRotationY] * k3 >> 16;
        int i4 = Rasterizer.anIntArray1471[itemDef.modelRotationY] * k3 >> 16;
        model.method482(itemDef.modelRotationX, itemDef.anInt204, itemDef.modelRotationY, itemDef.modelOffset1, l3 + model.modelHeight / 2 + itemDef.modelOffset2, i4 + itemDef.modelOffset2);
        for (int i5 = 31; i5 >= 0; i5--) {
            for (int j4 = 31; j4 >= 0; j4--)
                if (enabledSprite.raster[i5 + j4 * 32] == 0)
                    if (i5 > 0 && enabledSprite.raster[(i5 - 1) + j4 * 32] > 1)
                        enabledSprite.raster[i5 + j4 * 32] = 1;
                    else if (j4 > 0 && enabledSprite.raster[i5 + (j4 - 1) * 32] > 1)
                        enabledSprite.raster[i5 + j4 * 32] = 1;
                    else if (i5 < 31 && enabledSprite.raster[i5 + 1 + j4 * 32] > 1)
                        enabledSprite.raster[i5 + j4 * 32] = 1;
                    else if (j4 < 31 && enabledSprite.raster[i5 + (j4 + 1) * 32] > 1)
                        enabledSprite.raster[i5 + j4 * 32] = 1;

        }

        if (k > 0) {
            for (int j5 = 31; j5 >= 0; j5--) {
                for (int k4 = 31; k4 >= 0; k4--)
                    if (enabledSprite.raster[j5 + k4 * 32] == 0)
                        if (j5 > 0 && enabledSprite.raster[(j5 - 1) + k4 * 32] == 1)
                            enabledSprite.raster[j5 + k4 * 32] = k;
                        else if (k4 > 0 && enabledSprite.raster[j5 + (k4 - 1) * 32] == 1)
                            enabledSprite.raster[j5 + k4 * 32] = k;
                        else if (j5 < 31 && enabledSprite.raster[j5 + 1 + k4 * 32] == 1)
                            enabledSprite.raster[j5 + k4 * 32] = k;
                        else if (k4 < 31 && enabledSprite.raster[j5 + (k4 + 1) * 32] == 1)
                            enabledSprite.raster[j5 + k4 * 32] = k;

            }

        } else if (k == 0) {
            for (int k5 = 31; k5 >= 0; k5--) {
                for (int l4 = 31; l4 >= 0; l4--)
                    if (enabledSprite.raster[k5 + l4 * 32] == 0 && k5 > 0 && l4 > 0 && enabledSprite.raster[(k5 - 1) + (l4 - 1) * 32] > 0)
                        enabledSprite.raster[k5 + l4 * 32] = 0x302020;

            }

        }
        if (itemDef.certTemplateID != -1) {
            int l5 = sprite.resizeWidth;
            int j6 = sprite.resizeHeight;
            sprite.resizeWidth = 32;
            sprite.resizeHeight = 32;
            sprite.drawSprite(0, 0);
            sprite.resizeWidth = l5;
            sprite.resizeHeight = j6;
        }
        if (k == 0)
            mruNodes1.put(enabledSprite, item);
        Raster.initDrawingArea(ai1, i2, j2);
        Raster.setDrawingArea(k2, i3, l2, j3);
        Rasterizer.textureInt1 = k1;
        Rasterizer.textureInt2 = l1;
        Rasterizer.anIntArray1472 = ai;
        Rasterizer.aBoolean1464 = true;
        if (itemDef.stackable)
            enabledSprite.resizeWidth = 33;
        else
            enabledSprite.resizeWidth = 32;
        enabledSprite.resizeHeight = amount;
        return enabledSprite;
    }

    public static Sprite getSprite(int item, int amount, int k, int zoom) {
        if (k == 0) {
            Sprite sprite = (Sprite) mruNodes1.get(item);
            if (sprite != null && sprite.resizeHeight != amount && sprite.resizeHeight != -1) {

                sprite.unlink();
                sprite = null;
            }
            if (sprite != null)
                return sprite;
        }
        ItemDefinition itemDef = lookup(item);
        if (itemDef.stackIDs == null)
            amount = -1;
        if (amount > 1) {
            int i1 = -1;
            for (int j1 = 0; j1 < 10; j1++)
                if (amount >= itemDef.stackAmounts[j1] && itemDef.stackAmounts[j1] != 0)
                    i1 = itemDef.stackIDs[j1];

            if (i1 != -1)
                itemDef = lookup(i1);
        }
        Model model = itemDef.method201(1);
        if (model == null)
            return null;
        Sprite sprite = null;
        if (itemDef.certTemplateID != -1) {
            sprite = getSprite(itemDef.certID, 10, -1);
            if (sprite == null)
                return null;
        }
        Sprite enabledSprite = new Sprite(32, 32);
        int k1 = Rasterizer.textureInt1;
        int l1 = Rasterizer.textureInt2;
        int ai[] = Rasterizer.anIntArray1472;
        int ai1[] = Raster.pixels;
        int i2 = Raster.width;
        int j2 = Raster.height;
        int k2 = Raster.topX;
        int l2 = Raster.bottomX;
        int i3 = Raster.topY;
        int j3 = Raster.bottomY;
        Rasterizer.aBoolean1464 = false;
        Raster.initDrawingArea(enabledSprite.raster, 32, 32);
        Raster.fillRectangle(0, 0, 32, 32, 0);
        Rasterizer.method364();
        int k3 = itemDef.modelZoom;
        if (k == -1)
            k3 = (int) ((double) k3 * 1.5D);
        if (k > 0)
            k3 = (int) ((double) k3 * 1.04D);
        int l3 = Rasterizer.anIntArray1470[itemDef.modelRotationY] * k3 >> 16;
        int i4 = Rasterizer.anIntArray1471[itemDef.modelRotationY] * k3 >> 16;
        model.method482(itemDef.modelRotationX, itemDef.anInt204, itemDef.modelRotationY, itemDef.modelOffset1, l3 + model.modelHeight / 2 + itemDef.modelOffset2, i4 + itemDef.modelOffset2);
        for (int i5 = 31; i5 >= 0; i5--) {
            for (int j4 = 31; j4 >= 0; j4--)
                if (enabledSprite.raster[i5 + j4 * 32] == 0)
                    if (i5 > 0 && enabledSprite.raster[(i5 - 1) + j4 * 32] > 1)
                        enabledSprite.raster[i5 + j4 * 32] = 1;
                    else if (j4 > 0 && enabledSprite.raster[i5 + (j4 - 1) * 32] > 1)
                        enabledSprite.raster[i5 + j4 * 32] = 1;
                    else if (i5 < 31 && enabledSprite.raster[i5 + 1 + j4 * 32] > 1)
                        enabledSprite.raster[i5 + j4 * 32] = 1;
                    else if (j4 < 31 && enabledSprite.raster[i5 + (j4 + 1) * 32] > 1)
                        enabledSprite.raster[i5 + j4 * 32] = 1;

        }

        if (k > 0) {
            for (int j5 = 31; j5 >= 0; j5--) {
                for (int k4 = 31; k4 >= 0; k4--)
                    if (enabledSprite.raster[j5 + k4 * 32] == 0)
                        if (j5 > 0 && enabledSprite.raster[(j5 - 1) + k4 * 32] == 1)
                            enabledSprite.raster[j5 + k4 * 32] = k;
                        else if (k4 > 0 && enabledSprite.raster[j5 + (k4 - 1) * 32] == 1)
                            enabledSprite.raster[j5 + k4 * 32] = k;
                        else if (j5 < 31 && enabledSprite.raster[j5 + 1 + k4 * 32] == 1)
                            enabledSprite.raster[j5 + k4 * 32] = k;
                        else if (k4 < 31 && enabledSprite.raster[j5 + (k4 + 1) * 32] == 1)
                            enabledSprite.raster[j5 + k4 * 32] = k;

            }

        } else if (k == 0) {
            for (int k5 = 31; k5 >= 0; k5--) {
                for (int l4 = 31; l4 >= 0; l4--)
                    if (enabledSprite.raster[k5 + l4 * 32] == 0 && k5 > 0 && l4 > 0 && enabledSprite.raster[(k5 - 1) + (l4 - 1) * 32] > 0)
                        enabledSprite.raster[k5 + l4 * 32] = 0x302020;

            }

        }
        if (itemDef.certTemplateID != -1) {
            int l5 = sprite.resizeWidth;
            int j6 = sprite.resizeHeight;
            sprite.resizeWidth = 32;
            sprite.resizeHeight = 32;
            sprite.drawSprite(0, 0);
            sprite.resizeWidth = l5;
            sprite.resizeHeight = j6;
        }
        if (k == 0)
            mruNodes1.put(enabledSprite, item);
        Raster.initDrawingArea(ai1, i2, j2);
        Raster.setDrawingArea(k2, i3, l2, j3);
        Rasterizer.textureInt1 = k1;
        Rasterizer.textureInt2 = l1;
        Rasterizer.anIntArray1472 = ai;
        Rasterizer.aBoolean1464 = true;
        if (itemDef.stackable)
            enabledSprite.resizeWidth = 33;
        else
            enabledSprite.resizeWidth = 32;
        enabledSprite.resizeHeight = amount;
        return enabledSprite;
    }

    public Model method201(int i) {
        if (stackIDs != null && i > 1) {
            int j = -1;
            for (int k = 0; k < 10; k++)
                if (i >= stackAmounts[k] && stackAmounts[k] != 0)
                    j = stackIDs[k];

            if (j != -1)
                return lookup(j).method201(1);
        }
        Model model = (Model) mruNodes2.get(id);
        if (model != null)
            return model;
        model = Model.getModel(modelID);
        if (model == null)
            return null;
        if (anInt167 != 128 || anInt192 != 128 || anInt191 != 128)
            model.method478(anInt167, anInt191, anInt192);
        if (modifiedModelColors != null) {
            for (int l = 0; l < modifiedModelColors.length; l++)
                model.recolor(modifiedModelColors[l], originalModelColors[l]);

        }
        model.light(64 + brightness, 768 + anInt184, -50, -10, -50, true);
        model.aBoolean1659 = true;
        mruNodes2.put(model, id);
        return model;
    }

    public Model method202(int i) {
        if (stackIDs != null && i > 1) {
            int j = -1;
            for (int k = 0; k < 10; k++)
                if (i >= stackAmounts[k] && stackAmounts[k] != 0)
                    j = stackIDs[k];

            if (j != -1)
                return lookup(j).method202(1);
        }
        Model model = Model.getModel(modelID);
        if (model == null)
            return null;
        if (modifiedModelColors != null) {
            for (int l = 0; l < modifiedModelColors.length; l++)
                model.recolor(modifiedModelColors[l], originalModelColors[l]);

        }
        return model;
    }

    //	private void readValues(Buffer stream) {
    //		do {
    //			int opcode = stream.readUnsignedByte();
    //			if (opcode == 0)
    //				return;
    //			if (opcode == 1)
    //				modelID = stream.readUShort();
    //			else if (opcode == 2)
    //				name = stream.readString();
    //			else if (opcode == 3)
    //				description = stream.readString();
    //			else if (opcode == 4)
    //				modelZoom = stream.readUShort();
    //			else if (opcode == 5)
    //				modelRotationX = stream.readUShort();
    //			else if (opcode == 6)
    //				modelRotationY = stream.readUShort();
    //			else if (opcode == 7) {
    //				modelOffset1 = stream.readUShort();
    //				if (modelOffset1 > 32767)
    //					modelOffset1 -= 0x10000;
    //			} else if (opcode == 8) {
    //				modelOffset2 = stream.readUShort();
    //				if (modelOffset2 > 32767)
    //					modelOffset2 -= 0x10000;
    //			} else if (opcode == 11)
    //				stackable = true;
    //			else if (opcode == 12)
    //				value = stream.readInt();
    //			else if (opcode == 16)
    //				membersObject = true;
    //			else if (opcode == 23) {
    //				maleWield = stream.readUShort();
    //				aByte205 = stream.readSignedByte();
    //			} else if (opcode == 24)
    //				anInt188 = stream.readUShort();
    //			else if (opcode == 25) {
    //				femaleWield = stream.readUShort();
    //				aByte154 = stream.readSignedByte();
    //			} else if (opcode == 26)
    //				anInt164 = stream.readUShort();
    //			else if (opcode >= 30 && opcode < 35) {
    //				if (groundActions == null)
    //					groundActions = new String[5];
    //				groundActions[opcode - 30] = stream.readString();
    //				if (groundActions[opcode - 30].equalsIgnoreCase("hidden"))
    //					groundActions[opcode - 30] = null;
    //			} else if (opcode >= 35 && opcode < 40) {
    //				if (itemActions == null)
    //					itemActions = new String[5];
    //				itemActions[opcode - 35] = stream.readString();
    //			} else if (opcode == 40) {
    //				int j = stream.readUnsignedByte();
    //				originalModelColors = new int[j];
    //				modifiedModelColors = new int[j];
    //				for (int k = 0; k < j; k++) {
    //					originalModelColors[k] = stream.readUShort();
    //					modifiedModelColors[k] = stream.readUShort();
    //				}
    //			} else if (opcode == 41) {
    //				int j = stream.readUnsignedByte();
    //				originalTexture = new int[j];
    //				modifiedTexture = new int[j];
    //				for (int k = 0; k < j; k++) {
    //					originalTexture[k] = stream.readUShort();
    //					modifiedTexture[k] = stream.readUShort();
    //				}
    //			} else if (opcode == 42) {
    //				shiftDrop = stream.readUShort();
    //			} else if (opcode == 65) {
    //				stockMarket = true;
    //			} else if (opcode == 78)
    //				anInt185 = stream.readUShort();
    //			else if (opcode == 79)
    //				anInt162 = stream.readUShort();
    //			else if (opcode == 90)
    //				anInt175 = stream.readUShort();
    //			else if (opcode == 91)
    //				anInt197 = stream.readUShort();
    //			else if (opcode == 92)
    //				anInt166 = stream.readUShort();
    //			else if (opcode == 93)
    //				anInt173 = stream.readUShort();
    //			else if (opcode == 95)
    //				anInt204 = stream.readUShort();
    //			else if (opcode == 97)
    //				certID = stream.readUShort();
    //			else if (opcode == 98)
    //				certTemplateID = stream.readUShort();
    //			else if (opcode >= 100 && opcode < 110) {
    //				if (stackIDs == null) {
    //					stackIDs = new int[10];
    //					stackAmounts = new int[10];
    //				}
    //				stackIDs[opcode - 100] = stream.readUShort();
    //				stackAmounts[opcode - 100] = stream.readUShort();
    //			} else if (opcode == 110)
    //				anInt167 = stream.readUShort();
    //			else if (opcode == 111)
    //				anInt192 = stream.readUShort();
    //			else if (opcode == 112)
    //				anInt191 = stream.readUShort();
    //			else if (opcode == 113)
    //				brightness = stream.readSignedByte();
    //			else if (opcode == 114)
    //				anInt184 = stream.readSignedByte();
    //			else if (opcode == 115)
    //				team = stream.readUnsignedByte();
    //			else if (opcode == 139)
    //				stream.readUShort();
    //			else if (opcode == 140)
    //				stream.readUShort();
    //
    //			/*else if (opcode == 148)
    //				opcode148 = stream.readUShort();
    //			else if (opcode == 149)
    //				opcode149 = stream.readUShort();*/
    //
    //		} while (true);
    //	}

    private void readValues(Buffer buffer) {
        do {
            int opcode = buffer.readUnsignedByte();
            if (opcode == 0)
                return;
            if (opcode == 1)
                modelID = buffer.readUnsignedShort();
            else if (opcode == 2)
                name = buffer.readString();
            else if (opcode == 3)
                description = buffer.readString();
            else if (opcode == 4)
                modelZoom = buffer.readUnsignedShort();
            else if (opcode == 5)
                modelRotationY = buffer.readUnsignedShort();
            else if (opcode == 6)
                modelRotationX = buffer.readUnsignedShort();
            else if (opcode == 7) {
                modelOffset1 = buffer.readUnsignedShort();
                if (modelOffset1 > 32767)
                    modelOffset1 -= 0x10000;
            } else if (opcode == 8) {
                modelOffset2 = buffer.readUnsignedShort();
                if (modelOffset2 > 32767)
                    modelOffset2 -= 0x10000;
            } else if (opcode == 10)
                buffer.readUnsignedShort();
            else if (opcode == 11)
                stackable = true;
            else if (opcode == 12)
                value = buffer.readUnsignedInt();
            else if (opcode == 16)
                membersObject = true;
            else if (opcode == 23) {
                maleWield = buffer.readUnsignedShort();
                aByte205 = buffer.readSignedByte();
            } else if (opcode == 24)
                anInt188 = buffer.readUnsignedShort();
            else if (opcode == 25) {
                femaleWield = buffer.readUnsignedShort();
                aByte154 = buffer.readSignedByte();
            } else if (opcode == 26)
                anInt164 = buffer.readUnsignedShort();
            else if (opcode >= 30 && opcode < 35) {
                if (groundActions == null)
                    groundActions = new String[5];
                groundActions[opcode - 30] = buffer.readString();
                if (groundActions[opcode - 30].equalsIgnoreCase("hidden"))
                    groundActions[opcode - 30] = null;
            } else if (opcode >= 35 && opcode < 40) {
                if (itemActions == null)
                    itemActions = new String[5];
                itemActions[opcode - 35] = buffer.readString();
            } else if (opcode == 40) {
                int j = buffer.readUnsignedByte();
                originalModelColors = new int[j];
                modifiedModelColors = new int[j];
                for (int k = 0; k < j; k++) {
                    originalModelColors[k] = buffer.readUnsignedShort();
                    modifiedModelColors[k] = buffer.readUnsignedShort();
                }
            } else if (opcode == 41) {
                int j = buffer.readUnsignedByte();
                originalTexture = new short[j];
                modifiedTexture = new short[j];
                for (int k = 0; k < j; k++) {
                    originalTexture[k] = (short) buffer.readUnsignedShort();
                    modifiedTexture[k] = (short) buffer.readUnsignedShort();
                }

            } else if (opcode == 78)
                anInt185 = buffer.readUnsignedShort();
            else if (opcode == 79)
                anInt162 = buffer.readUnsignedShort();
            else if (opcode == 90)
                anInt175 = buffer.readUnsignedShort();
            else if (opcode == 91)
                anInt197 = buffer.readUnsignedShort();
            else if (opcode == 92)
                anInt166 = buffer.readUnsignedShort();
            else if (opcode == 93)
                anInt173 = buffer.readUnsignedShort();
            else if (opcode == 95)
                anInt204 = buffer.readUnsignedShort();
            else if (opcode == 97)
                certID = buffer.readUnsignedShort();
            else if (opcode == 98)
                certTemplateID = buffer.readUnsignedShort();
            else if (opcode >= 100 && opcode < 110) {
                if (stackIDs == null) {
                    stackIDs = new int[10];
                    stackAmounts = new int[10];
                }
                stackIDs[opcode - 100] = buffer.readUnsignedShort();
                stackAmounts[opcode - 100] = buffer.readUnsignedShort();
            } else if (opcode == 110)
                anInt167 = buffer.readUnsignedShort();
            else if (opcode == 111)
                anInt192 = buffer.readUnsignedShort();
            else if (opcode == 112)
                anInt191 = buffer.readUnsignedShort();
            else if (opcode == 113)
                brightness = buffer.readSignedByte();
            else if (opcode == 114)
                anInt184 = buffer.readSignedByte() * 5;
            else if (opcode == 115)
                team = buffer.readUnsignedByte();
            else if (opcode == 139)
                buffer.readUnsignedShort();
            else if (opcode == 140)
                buffer.readUnsignedShort();
            else if (opcode == 148)
                buffer.readUnsignedShort();
            else if (opcode == 149)
                buffer.readUnsignedShort();
        } while (true);
    }

    private ItemDefinition() {
        id = -1;
    }

    private byte aByte154;
    private byte aByte205;
    public int id;// anInt157
    public int team;
    public int value;// anInt155
    public int certID;
    public int modelID;// dropModel
    public int anInt175;
    public int femaleWield;// femWieldModel
    public int anInt204;// modelPositionUp
    public int anInt164;// femArmModel
    public int anInt197;
    public int anInt188;// maleArmModel
    public int maleWield;// maleWieldModel
    public int modelZoom;
    public int modelOffset1;
    public int modelOffset2;//
    public int certTemplateID;
    public int modelRotationX;// modelRotateRight
    public int modelRotationY;// modelRotateUp
    public static int totalItems;
    public int[] stackIDs;// modelStack
    public int[] stackAmounts;// itemAmount
    public int[] modifiedModelColors;// newModelColor
    public int[] originalModelColors;
    public short[] modifiedTexture;
    public short[] originalTexture;
    private int brightness;
    private int anInt162;
    private int anInt166;
    private int anInt184;
    private int anInt185;
    private int anInt191;
    private int anInt192;
    private int anInt167;
    private int anInt173;
    private int shiftDrop;
    private boolean stockMarket;
    private static int cacheIndex;
    private static int[] BufferIndices;
    public boolean stackable;// itemStackable
    public boolean membersObject;// aBoolean161
    public static boolean isMembers = true;
    public String name;// itemName
    public String description;// itemExamine
    public String itemActions[];// itemMenuOption
    public String groundActions[];
    private static Buffer Buffer;
    private static ItemDefinition[] cache;
    public static Cache mruNodes1 = new Cache(100);
    public static Cache mruNodes2 = new Cache(50);
}