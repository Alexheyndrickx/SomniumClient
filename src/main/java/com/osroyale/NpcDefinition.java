package com.osroyale;

public final class NpcDefinition {

    public static void unpackConfig(StreamLoader streamLoader) {
        buffer = new Buffer(streamLoader.getFile("npc.dat"));
        Buffer stream2 = new Buffer(streamLoader.getFile("npc.idx"));
        int totalNPCs = stream2.readUnsignedShort();
        offsets = new int[totalNPCs];
        int i = 2;
        for (int j = 0; j < totalNPCs; j++) {
            offsets[j] = i;
            i += stream2.readUnsignedShort();
        }

        cache = new NpcDefinition[20];

        for (int k = 0; k < 20; k++) {
            cache[k] = new NpcDefinition();
        }

        //default dump
        /*for (int index = 7616; index < totalNPCs; index++) {
            NpcDefinition definition = lookup(index);

            if (definition == null) {
                System.out.println(index + " Null definition");
                continue;
            }

            System.out.println("{");
            System.out.println("    \"id\": " + index + ",");
            System.out.println("    \"name\": \"" + definition.name + "\",");

            int combatLevel = definition.combatLevel;

            if (combatLevel == 0) {
                combatLevel = 1;
            }

            System.out.println("    \"combat-level\": " + combatLevel + ",");
            System.out.println("    \"size\": " + definition.size + ",");
            System.out.println("    \"stand\": " + definition.standingAnimation + ",");
            System.out.println("    \"walk\": " + definition.walkingAnimation + "");
            System.out.println("},");
        }*/
    }

    static NpcDefinition lookup(int i) {
        for (int j = 0; j < 20; j++)
            if (cache[j].interfaceType == (long) i)
                return cache[j];

        anInt56 = (anInt56 + 1) % 20;
        NpcDefinition entityDef = cache[anInt56] = new NpcDefinition();
        buffer.currentOffset = offsets[i];
        entityDef.interfaceType = i;
        entityDef.decode(buffer);

        switch (i) {
            case 6773:
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Open";
                break;
            case 7481:
                entityDef.name = "RunePK Vote Agent";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Talk-to";
                entityDef.actions[2] = "Trade";
                break;
            case 7601:
                entityDef.name = "Shady Insurance Agent";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Talk-to";
                entityDef.actions[2] = "Open";
                break;
            case 2462:
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Open";
                break;
            case 3216:
                entityDef.name = "Melee store";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Open";
                break;
            case 3217:
                entityDef.name = "Ranged store";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Open";
                break;
            case 3218:
                entityDef.name = "Magic store";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Open";
                break;

            case 7062:
                entityDef.name = "Ensouled Hunter";
                break;
        /* Fishing */
            case 1518:
                entityDef.name = "Shimps & Anchovies";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Net";
                break;
            case 1526:
                entityDef.name = "Trout & Salmon";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Bait";
                break;
            case 311:
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Talk-to";
                entityDef.actions[2] = "Trade";
                entityDef.actions[3] = "Claim-armour";
                break;
            case 1519:
                entityDef.name = "Lobster & Swordfish";
                break;
            case 6533:
                entityDef.name = "RunePK Skillermen";
                break;
            case 1520:
                entityDef.name = "Shark";
                break;
            case 1521:
                entityDef.name = "Manta ray";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Net";
                break;
            case 1534:
                entityDef.name = "Monkfish";
                break;
            case 1536:
                entityDef.name = "Dark crab";
                break;
            case 1600:
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Bank";
                break;
            case 1603:
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Talk-to";
                entityDef.actions[2] = "Trade";

                break;
            case 326:
            case 321:
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Talk-to";
                entityDef.actions[2] = "Dismiss";
                break;
            case 5419:
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Open";
                entityDef.actions[3] = "Trade";
                break;
            /** Crafting master. */
            case 5811:
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Tan";
                entityDef.actions[2] = "Trade";
                break;
        /* Clanmaster */
            case 1143:
                entityDef.name = "Clanmaster";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Open";
                break;
        /* Clothing */
            case 534:
                entityDef.name = "Clothing store";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Open";
                break;

		/* Pure */
            case 5440:
                entityDef.name = "Pure store";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Open";
                break;

		/* Mage */
            case 4400:
                entityDef.name = "Mage store";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Open";
                break;

		/* Range */
            case 1576:
                entityDef.name = "Range store";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Open";
                break;


            case 1157:
            case 1158:
            case 1160:
                entityDef.actions = new String[5];
                entityDef.actions[1] = "Attack";
                break;

		/* Skill */
            case 505:
                entityDef.name = "Skilling store";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Open";
                break;

		/* Hunter */
            case 1504:
                entityDef.name = "Hunter store";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Open";
                break;

		/* Cook */
            case 1199:
                entityDef.name = "Consumable store";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Open";
                break;

		/* Farming */
            case 3258:
                entityDef.name = "Farming store";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Open";
                break;

		/* Achievement */
            case 5527:
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Talk-to";
                entityDef.actions[2] = "Trade";
                break;

		/* Banker */
            case 1480:
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Talk-to";
                entityDef.actions[2] = "Bank";
                break;

		/* Voting */
            case 3531:
                entityDef.name = "Vote";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Talk-to";
                entityDef.actions[2] = "Trade";
                entityDef.actions[3] = "Claim";
                break;

		/* Spellbook */
            case 4397:
                entityDef.name = "Spellbook";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Change";
                break;

		/* Royal Points */
            case 5523:
                entityDef.name = "The Donator King";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Talk-to";
                entityDef.actions[2] = "Open-store";
                entityDef.actions[3] = "Claim-purchase";
                entityDef.description = "What more is there to say about The Donator King?.".getBytes();
                break;

            case 306:
                entityDef.name = "RunePK Guide";
                break;

		/* Clothing */
            case 1307:
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Makeover";
                break;

		/* Thieving Stalls */
            case 3439:
                entityDef.name = "Merchant";
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Sell goods";
                break;

            case 5919:
            case 1755:
            case 2186:
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Trade";
                break;

            case 2180:
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Exchange for firecape";
                break;

		/* Nieve */
            case 490:
            case 6797:
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Talk-to";
                entityDef.actions[2] = "Open-interface";
                entityDef.actions[3] = "Offer-items";
                break;
            case 1756:
                entityDef.name = "Void Knight";
                entityDef.combatLevel = 0;
                entityDef.actions = new String[5];
                entityDef.actions[1] = "Talk-to";
                break;
            case 315:
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Talk-to";
                entityDef.actions[2] = "Trade";
                entityDef.actions[3] = "Skull";
                entityDef.modelId = new int[11];
                entityDef.modelId[0] = 181;
                entityDef.modelId[1] = 28285;
                entityDef.modelId[2] = 249;
                entityDef.modelId[3] = 28226;
                entityDef.modelId[4] = 176;
                entityDef.modelId[5] = 5232;
                entityDef.modelId[6] = 28445;
                entityDef.modelId[7] = 31772;
                entityDef.modelId[8] = 28223;
                entityDef.modelId[9] = 28286;
                entityDef.modelId[10] = 556;
                entityDef.recolorOriginal = new int[]{103, 0, 43439, 94, 43340, 43115, 43228, 43449, 929, 914, 17467, 16578, 16582, 5018, 11177, 10351}; // Original colour
                entityDef.recolorTarget = new int[]{20, 20, 20, 20, 20, 20, 20, 20, 20, 5, 900, 900, 900, 20, 900, 5}; // Colour you want to change to
                entityDef.standingAnimation = 813; // Npc's Stand Emote
                entityDef.walkingAnimation = 1146;
                entityDef.name = "Darth Pker";
                entityDef.description = "The hunter of bounties.".getBytes();
                break;
            case 316:
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Talk-to";
                entityDef.actions[2] = "Pick-up";
                entityDef.modelId = new int[11];
                entityDef.modelId[0] = 181;
                entityDef.modelId[1] = 28285;
                entityDef.modelId[2] = 249;
                entityDef.modelId[3] = 28226;
                entityDef.modelId[4] = 176;
                entityDef.modelId[5] = 5232;
                entityDef.modelId[6] = 28445;
                entityDef.modelId[7] = 31772;
                entityDef.modelId[8] = 28223;
                entityDef.modelId[9] = 28286;
                entityDef.modelId[10] = 556;
                entityDef.recolorOriginal = new int[]{103, 0, 43439, 94, 43340, 43115, 43228, 43449, 929, 914, 17467, 16578, 16582, 5018, 11177, 10351}; // Original colour
                entityDef.recolorTarget = new int[]{20, 20, 20, 20, 20, 20, 20, 20, 20, 5, 900, 900, 900, 20, 900, 5}; // Colour you want to change to
                entityDef.standingAnimation = 813;
                entityDef.walkingAnimation = 1146;
                entityDef.scaleXZ = 85;
                entityDef.scaleY =  85;
                entityDef.name = "Baby Darth";
                entityDef.description = "The baby hunter of bounties.".getBytes();
                break;
            case 345:
                entityDef.name = "Polly";
                entityDef.description = "She takes pride in prestiging.".getBytes();
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Talk-to";
                entityDef.actions[2] = "Trade";
                entityDef.actions[3] = "Prestige-panel";
                entityDef.actions[4] = "Perk-information";
                entityDef.walkingAnimation = 819;
                entityDef.standingAnimation = 808;
                entityDef.modelId = new int[10];
                entityDef.modelId[0] = 391;
                entityDef.modelId[1] = 414;
                entityDef.modelId[2] = 18983;
                entityDef.modelId[3] = 361;
                entityDef.modelId[4] = 356;
                entityDef.modelId[5] = 556;
                entityDef.modelId[6] = 332;
                entityDef.modelId[7] = 474;
                entityDef.modelId[8] = 433;
                entityDef.modelId[9] = 16348;
                entityDef.recolorTarget = new int[]{127, 127, 127, 127, 9168, -22419, 9143, 9168, 9143, 7744, 127, 127}; // Colour you want to change to//
                entityDef.recolorOriginal = new int[]{4626, 10128, 10004, 5018, 61, 10351, 57280, 54183, 54503, 6798, 8741, 25238}; // Original colour
                break;
            case 6481:
                entityDef.name = "Mac";
                entityDef.description = "Only the most knowledgeable players of OS-Royale are worthy of such a cape.".getBytes();
                entityDef.combatLevel = 126;
                entityDef.walkingAnimation = 819;
                //entityDef.standingAnimation = 808;
                entityDef.actions = new String[5];
                entityDef.actions[0] = "Talk-to";
                entityDef.modelId = new int[8];
                entityDef.modelId[0] = 29615;
                entityDef.modelId[1] = 29618;
                entityDef.modelId[2] = 29621;
                entityDef.modelId[3] = 29616;
                entityDef.modelId[4] = 29620;
                entityDef.modelId[5] = 176;
                entityDef.modelId[6] = 29619;
                entityDef.modelId[7] = 29622;
                break;
            case 367:
                entityDef.actions = new String[5]; // Actions for the npc
                entityDef.modelId = new int[9]; //Number of models it uses
                entityDef.modelId[0] = 27636; //Bandos chest
                entityDef.modelId[1] = 27625; //Tassets
                entityDef.modelId[2] = 13307; //Barrows gloves
                entityDef.modelId[3] = 28826; //BCP (arms)
                entityDef.modelId[4] = 29250; //Primordial boots
                entityDef.modelId[5] = 32678; //Elder maul
                entityDef.modelId[6] = 14424; //Serp helm
                entityDef.modelId[7] = 31227; // Torture
                entityDef.modelId[8] = 29616; //Max cape
                entityDef.standingAnimation = 7518; // Npc's Stand Emote
                entityDef.walkingAnimation = 7520;
                entityDef.recolorOriginal = new int[]{668, 675, 673, 815, 784};
                entityDef.recolorTarget = new int[]{947, 960, 7104, 8146, 0};
                entityDef.name = "Donator Guard";
                entityDef.combatLevel = 420;
                entityDef.description = "The protector of the donator zone.".getBytes(); // NPC description
                break;
        }

        return entityDef;
    }

    public Model method160() {
        if (childrenIDs != null) {
            NpcDefinition entityDef = morph();
            if (entityDef == null)
                return null;
            else
                return entityDef.method160();
        }
        if (anIntArray73 == null)
            return null;
        boolean flag1 = false;
        for (int i = 0; i < anIntArray73.length; i++)
            if (!Model.isCached(anIntArray73[i]))
                flag1 = true;

        if (flag1)
            return null;
        Model aclass30_sub2_sub4_sub6s[] = new Model[anIntArray73.length];
        for (int j = 0; j < anIntArray73.length; j++)
            aclass30_sub2_sub4_sub6s[j] = Model.getModel(anIntArray73[j]);

        Model model;
        if (aclass30_sub2_sub4_sub6s.length == 1)
            model = aclass30_sub2_sub4_sub6s[0];
        else
            model = new Model(aclass30_sub2_sub4_sub6s.length, aclass30_sub2_sub4_sub6s);
        if (recolorOriginal != null) {
            for (int k = 0; k < recolorOriginal.length; k++)
                model.recolor(recolorOriginal[k], recolorTarget[k]);

        }
        return model;
    }

    public Model getAnimatedModel(int primaryFrame, int secondaryFrame, int interleaveOrder[]) {
        if (childrenIDs != null) {
            NpcDefinition definition = morph();
            if (definition == null)
                return null;
            else
                return definition.getAnimatedModel(primaryFrame, secondaryFrame, interleaveOrder);
        }
        Model model = (Model) modelCache.get(interfaceType);
        if (model == null) {
            boolean flag = false;
            for (int index = 0; index < modelId.length; index++)
                if (!Model.isCached(modelId[index]))
                    flag = true;
            if (flag) {
                return null;
            }
            Model models[] = new Model[modelId.length];
            for (int index = 0; index < modelId.length; index++)
                models[index] = Model.getModel(modelId[index]);

            if (models.length == 1)
                model = models[0];
            else
                model = new Model(models.length, models);
            if (recolorOriginal != null) {
                for (int index = 0; index < recolorOriginal.length; index++)
                    model.recolor(recolorOriginal[index], recolorTarget[index]);

            }
            model.skin();
            model.light(64 + lightModifier, 850 + shadowModifier, -30, -50, -30, true);
            modelCache.put(model, interfaceType);
        }
        Model model_1 = Model.EMPTY_MODEL;
        model_1.method464(model, Frame.method532(secondaryFrame) & Frame.method532(primaryFrame));
        if (secondaryFrame != -1 && primaryFrame != -1)
            model_1.method471(interleaveOrder, primaryFrame, secondaryFrame);
        else if (secondaryFrame != -1)
            model_1.method470(secondaryFrame);
        if (scaleXZ != 128 || scaleY != 128)
            model_1.method478(scaleXZ, scaleXZ, scaleY);
        model_1.method466();
        model_1.anIntArrayArray1658 = null;
        model_1.anIntArrayArray1657 = null;
        if (size == 1)
            model_1.aBoolean1659 = true;
        return model_1;
    }

    public NpcDefinition morph() {
        int j = -1;
        if (anInt57 != -1) {
            VarBit varBit = VarBit.cache[anInt57];
            int k = varBit.anInt648;
            int l = varBit.anInt649;
            int i1 = varBit.anInt650;
            int j1 = Client.anIntArray1232[i1 - l];
            j = clientInstance.settings[k] >> l & j1;
        } else if (anInt59 != -1)
            j = clientInstance.settings[anInt59];
        if (j < 0 || j >= childrenIDs.length || childrenIDs[j] == -1)
            return null;
        else
            return lookup(childrenIDs[j]);
    }

    public static void clear() {
        modelCache = null;
        offsets = null;
        cache = null;
        buffer = null;
    }

    Model method164(int j, int currAnim, int nextAnim, int currCycle, int nextCycle, int ai[]) {
        if (childrenIDs != null) {
            final NpcDefinition type = morph();
            if (type == null) {
                return null;
            } else {
                return type.method164(j, currAnim, nextAnim, currCycle, nextCycle, ai);
            }
        }
        Model model = (Model) modelCache.get(interfaceType);
        if (model == null) {
            boolean flag = false;
            for (int i1 = 0; i1 < modelId.length; i1++) {
                if (!Model.isCached(modelId[i1])) {
                    flag = true;
                }
            }
            if (flag) {
                return null;
            }
            final Model[] parts = new Model[modelId.length];
            for (int j1 = 0; j1 < modelId.length; j1++) {
                parts[j1] = Model.getModel(modelId[j1]);
            }
            if (parts.length == 1) {
                model = parts[0];
            } else {
                model = new Model(parts.length, parts);
            }
            if (recolorOriginal != null) {
                for (int k1 = 0; k1 < recolorOriginal.length; k1++) {
                    model.recolor(recolorOriginal[k1], recolorTarget[k1]);
                }
            }
            model.skin();
            if (Settings.CUSTOM_LIGHTING) {
                model.light(84, 1000, -90, -580, -90, true);
            } else {
                model.light(64 + lightModifier, 850 + shadowModifier, -30, -50, -30, true);
            }
            modelCache.put(model, interfaceType);
        }
        final Model model_1 = Model.EMPTY_MODEL;
        model_1.method464(model, Frame.method532(currAnim) & Frame.method532(j));
        if (currAnim != -1 && j != -1) {
            model_1.method471(ai, j, currAnim);
        } else if (currAnim != -1) {
            if (Settings.TWEENING) {
                model_1.interpolateFrames(currAnim, nextAnim, nextCycle, currCycle);
            } else {
                model_1.method470(currAnim);
            }
        }
        if (scaleXZ != 128 || scaleY != 128) {
            model_1.method478(scaleXZ, scaleY, scaleXZ);
        }
        model_1.method466();
        model_1.anIntArrayArray1658 = null;
        model_1.anIntArrayArray1657 = null;
        if (size == 1) {
            model_1.aBoolean1659 = true;
        }
        return model_1;
    }

    public void decode(Buffer stream) {
        do {
            int i = stream.readUnsignedByte();
            if (i == 0)
                return;
            if (i == 1) {
                int j = stream.readUnsignedByte();
                modelId = new int[j];
                for (int j1 = 0; j1 < j; j1++)
                    modelId[j1] = stream.readUnsignedShort();

            } else if (i == 2)
                name = stream.readString();
            else if (i == 3)
                description = stream.readBytes();
            else if (i == 12)
                size = stream.readSignedByte();
            else if (i == 13)
                standingAnimation = stream.readUnsignedShort();
            else if (i == 14)
                walkingAnimation = stream.readUnsignedShort();
            else if (i == 17) {
                walkingAnimation = stream.readUnsignedShort();
                halfTurnAnimation = stream.readUnsignedShort();
                quarterClockwiseTurnAnimation = stream.readUnsignedShort();
                quarterAnticlockwiseTurnAnimation = stream.readUnsignedShort();
                if (halfTurnAnimation == 65535) {
                    halfTurnAnimation = walkingAnimation;
                }
                if (quarterClockwiseTurnAnimation == 65535) {
                    quarterClockwiseTurnAnimation = walkingAnimation;
                }
                if (quarterAnticlockwiseTurnAnimation == 65535) {
                    quarterAnticlockwiseTurnAnimation = walkingAnimation;
                }
            } else if (i >= 30 && i < 40) {
                if (actions == null)
                    actions = new String[5];
                actions[i - 30] = stream.readString();
                if (actions[i - 30].equalsIgnoreCase("hidden"))
                    actions[i - 30] = null;
            } else if (i == 40) {
                int colors = stream.readUnsignedByte();
                recolorOriginal = new int[colors];
                recolorTarget = new int[colors];
                for (int k1 = 0; k1 < colors; k1++) {
                    recolorOriginal[k1] = stream.readUnsignedShort();
                    recolorTarget[k1] = stream.readUnsignedShort();
                }

            } else if (i == 60) {
                int l = stream.readUnsignedByte();
                anIntArray73 = new int[l];
                for (int l1 = 0; l1 < l; l1++)
                    anIntArray73[l1] = stream.readUnsignedShort();

            } else if (i == 90)
                stream.readUnsignedShort();
            else if (i == 91)
                stream.readUnsignedShort();
            else if (i == 92)
                stream.readUnsignedShort();
            else if (i == 93)
                aBoolean87 = false;
            else if (i == 95)
                combatLevel = stream.readUnsignedShort();
            else if (i == 97)
                scaleXZ = stream.readUnsignedShort();
            else if (i == 98)
                scaleY = stream.readUnsignedShort();
            else if (i == 99)
                aBoolean93 = true;
            else if (i == 100)
                lightModifier = stream.readSignedByte();
            else if (i == 101)
                shadowModifier = stream.readSignedByte() * 5;
            else if (i == 102)
                anInt75 = stream.readUnsignedShort();
            else if (i == 103)
                rotation = stream.readUnsignedShort();
            else if (i == 106) {
                anInt57 = stream.readUnsignedShort();
                if (anInt57 == 65535)
                    anInt57 = -1;
                anInt59 = stream.readUnsignedShort();
                if (anInt59 == 65535)
                    anInt59 = -1;
                int i1 = stream.readUnsignedByte();
                childrenIDs = new int[i1 + 1];
                for (int i2 = 0; i2 <= i1; i2++) {
                    childrenIDs[i2] = stream.readUnsignedShort();
                    if (childrenIDs[i2] == 65535)
                        childrenIDs[i2] = -1;
                }

            } else if (i == 107)
                aBoolean84 = false;
        } while (true);
    }

    public NpcDefinition() {
        quarterAnticlockwiseTurnAnimation = -1;
        anInt57 = -1;
        halfTurnAnimation = -1;
        anInt59 = -1;
        combatLevel = -1;
        anInt64 = 1834;
        walkingAnimation = -1;
        size = 1;
        anInt75 = -1;
        standingAnimation = -1;
        interfaceType = -1L;
        rotation = 32;
        quarterClockwiseTurnAnimation = -1;
        aBoolean84 = true;
        scaleY = 128;
        aBoolean87 = true;
        scaleXZ = 128;
        aBoolean93 = false;
    }

    public int quarterAnticlockwiseTurnAnimation;
    public static int anInt56;
    public int anInt57;
    public int halfTurnAnimation;
    public int anInt59;
    public static Buffer buffer;
    public int combatLevel;
    public final int anInt64;
    public String name;
    public String actions[];
    public int walkingAnimation;
    public byte size;
    public int[] recolorTarget;
    public static int[] offsets;
    public int[] anIntArray73;
    public int anInt75;
    public int[] recolorOriginal;
    public int standingAnimation;
    public long interfaceType;
    public int rotation;
    public static NpcDefinition[] cache;
    public static Client clientInstance;
    public int quarterClockwiseTurnAnimation;
    public boolean aBoolean84;
    public int lightModifier;
    public int scaleY;
    public boolean aBoolean87;
    public int childrenIDs[];
    public byte description[];
    public int scaleXZ;
    public int shadowModifier;
    public boolean aBoolean93;
    public int[] modelId;
    public int interfaceZoom = 0;
    public static Cache modelCache = new Cache(30);

}
