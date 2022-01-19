package com.osroyale;

public final class Npc extends Entity {

	private Model method450() {
		int currAnim = -1;
		int nextAnim = -1;
		int currCycle = -1;
		int nextCycle = -1;
		if (super.emoteAnimation >= 0 && super.animationDelay == 0) {
			final Animation seq = Animation.animations[super.emoteAnimation];
			if (Settings.TWEENING && super.nextAnimFrame != -1) {
				nextAnim = seq.primary[super.nextAnimFrame];
				currCycle = seq.duration[super.displayedEmoteFrames];
				nextCycle = super.emoteTimeRemaining;
			}
			currAnim = seq.primary[super.displayedEmoteFrames];
			int idleAnim = -1;
			if (super.movementAnimation >= 0 && super.movementAnimation != super.idleAnimation) {
				idleAnim = Animation.animations[super.movementAnimation].primary[super.anInt1518];
			}
			return definition.method164(idleAnim, currAnim, nextAnim, currCycle, nextCycle, Animation.animations[super.emoteAnimation].interleaveOrder);
		}
		if (super.movementAnimation >= 0) {
			final Animation seq = Animation.animations[super.movementAnimation];
			currAnim = seq.primary[super.anInt1518];
			if (Settings.TWEENING && super.nextIdleFrame != -1) {
				nextAnim = seq.primary[super.nextIdleFrame];
				currCycle = seq.duration[super.anInt1518];
				nextCycle = super.anInt1519;// now to figure out what gay naming
				// seven used
			}
		}
		return definition.method164(-1, currAnim, nextAnim, currCycle, nextCycle, null);
	}

	public Model getRotatedModel() {
		if (definition == null)
			return null;
		Model model = method450();
		if (model == null)
			return null;
		super.height = model.modelHeight;
		if (super.graphic != -1 && super.currentAnimation != -1) {
			Graphic spotAnim = Graphic.cache[super.graphic];
			Model model_1 = spotAnim.getModel();
			if (model_1 != null) {
				int j = spotAnim.animationSequence.primary[super.currentAnimation];
				Model model_2 = new Model(true, Frame.method532(j), false, model_1);
				model_2.method475(0, -super.graphicHeight, 0);
				model_2.skin();
				model_2.method470(j);
				model_2.anIntArrayArray1658 = null;
				model_2.anIntArrayArray1657 = null;
				if (spotAnim.resizeXY != 128 || spotAnim.resizeZ != 128)
					model_2.method478(spotAnim.resizeXY, spotAnim.resizeXY, spotAnim.resizeZ);
				model_2.light(64 + spotAnim.modelBrightness, 850 + spotAnim.modelShadow, -30, -50, -30, true);
				Model aModel[] = {model, model_2};
				model = new Model(aModel);
			}
		}
		if (definition.size == 1)
			model.aBoolean1659 = true;
		return model;
	}

	public boolean isVisible() {
		return definition != null;
	}

	Npc() {
	}

	public NpcDefinition definition;
}
