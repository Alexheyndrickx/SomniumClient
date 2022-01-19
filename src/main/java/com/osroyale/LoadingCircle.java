package com.osroyale;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;

    public class LoadingCircle {

        public Graphics2D g2d;

        private int progressAngle = 0;

        private int progressChange = 0;

        private long lastDraw = 0;

        private void calculateAngleStep(int per) {
            progressAngle = (int) ((per / 100.0) * 360);

            if (System.currentTimeMillis() - lastDraw < 600) {
                if (progressChange <= 0) {
                    progressChange = progressAngle - angleStepper;
                }
            }

            boolean levelUp = false;
            if (progressAngle < angleStepper) {
                levelUp = true;
            }

            if (progressChange < 360 && ((progressChange > 0 && angleStepper <= progressAngle - 2) || levelUp)) {
                angleStepper += 2;
                progressChange--;
            } else {
                progressChange = 0;
                angleStepper = progressAngle;
            }

            if (angleStepper > 360) {
                angleStepper = progressAngle;
            }
        }

        private int angleStepper = 0;

        public void draw(int x, int y, int per) {

            Font font = new Font("Calibri", 1, 20);


            g2d.setFont(font);
            g2d.setColor(Color.white);
            g2d.drawString("ONG", 0,0);

            Raster.drawFilledCircle((Client.frameWidth / 2) - (220 / 2) + 110,(Client.frameHeight / 2) - (220 / 2) + 112, 0, 0x000000, 70);
            calculateAngleStep(per);
            Raster.createGraphics(true);
            Shape xpRing = createRing(x, y, 360,220,190);
            Shape progressRing = createRing(x, y, angleStepper,220,190);
            //Rasterizer2D.drawFilledCircle((Client.frameWidth / 2) - (220 / 2) + 110,(Client.frameHeight / 2) - (220 / 2) + 110, 112, 0x000000, 100); //Outer
            Raster.drawFilledCircle((Client.frameWidth / 2) - (220 / 2) + 109,(Client.frameHeight / 2) - (220 / 2) + 110, 0, 0x000000, 55); //Outline
            Raster.drawFilledCircle((Client.frameWidth / 2) - (220 / 2) + 109,(Client.frameHeight / 2) - (220 / 2) + 110, 0, 0xFFFFFF, 45);
            drawRingOut(xpRing, new Color(0, 0, 0, 145), x, y);
            drawRingInner(progressRing, new Color(53, 67, 87, 200), x, y);

        }

        public Shape createRing(int x, int y, int angle, int sectorSize, int innerSize) {
            Shape sector = Raster.createSector(x, y, sectorSize, angle);
            Shape innerCircle = Raster.createCircle(x + 15, y + 15, innerSize);
            return Raster.createRing(sector, innerCircle);
        }

        public void drawRingInner(Shape ring, Color colour, int x, int y) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(colour);
            g2d.fill(ring);

        }

        public void drawRingOut(Shape ring, Color colour, int x, int y) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(colour);
            g2d.fill(ring);

        }

    }
