package com.osroyale.login;

import com.osroyale.*;
import com.osroyale.login.impl.MainScreen;
import com.osroyale.login.impl.SettingScreen;

/**
 * The login screen class.
 *
 * @author Daniel
 */
public abstract class LoginComponent {

    /** Renders the login screen component. */
    public abstract void render(Client client);

    /** Handles clicking buttons on the login screen components. */
    public abstract void click(Client client);

    public abstract ScreenType type();

    /** Handles refreshing the login screen components. */
    protected void refresh(Client client) {
        if (Client.loginScreenIP == null) {
            Client.loginScreenIP = new GraphicsBuffer(765, 503, client.getGameComponent());
            Raster.reset();
        }
    }

    /** Handles loading the login screen components. */
    public void load(Client client, int rate) {
        client.loginTick += rate;
        if (client.loginTick > 255) {
            client.loginTick = 255;
            client.loginLoaded = true;
        }
    }

    /** Draws the announcement bar */
    protected void announcement(Client client) {
        if (Settings.DRAW_ANNOUNCEMENT) {
            client.announcementMovement--;
            client.announcementFade++;
            if (client.announcementMovement < -Configuration.ANNOUNCEMENT[client.announcementTicks].length() - 450) {
                client.announcementMovement = Client.frameWidth - 8;
                client.announcementTicks++;
                if (client.announcementTicks >= Configuration.ANNOUNCEMENT.length) {
                    client.announcementTicks = 0;
                }
            }
            if (client.mouseInRegion(0, 452, 655, 503)) {
                client.newFancyFont.drawBasicString("" + Configuration.ANNOUNCEMENT[client.announcementTicks], client.announcementMovement, 483, 0xb9b9b9, 0);
            } else {
                client.newFancyFont.drawBasicString(Configuration.ANNOUNCEMENT[client.announcementTicks], client.announcementMovement, 483, 0x717171, 0);
            }
        }
    }

    /** Draws the bubbles on the login screen. */
    protected void drawSetting(Client client) {
        int centerX = getX();
        int centerY = getY();

        if (Settings.DRAW_BUBBLE)
            for (Bubble bubble : Client.bubbles)
                bubble.draw(Bubble.BOUNCING_BALLS);

        if (client.mouseInRegion(656, 446, 756, 491)) {
            Client.spriteCache.get(868).drawSprite(656, 457);
        } else {
            Client.spriteCache.get(867).drawSprite(656, 457);
        }

        String string = client.loginRenderer.getScreen(ScreenType.SETTING) ? "Return" : "Options";
        client.boldText.drawCenteredText(0xb9b9b9, 707, string, centerY + 224, true);
        client.smallFont.drawCenteredText(0xb9b9b9, 707, "Click to change", centerY + 236, true);
    }

    /** Draws the bubble toggle on the login screen. */
    protected void settingButton(Client client) {
        int centerX = getX();
        int centerY = getY();
        if (client.lastMetaModifier == 1 && client.mouseInRegion(656, 446, 756, 491)) {
            if (client.loginRenderer.getScreen(ScreenType.SETTING)) {
                client.loginRenderer.setScreen(new MainScreen());
            } else {
                client.loginRenderer.setScreen(new SettingScreen());
            }
        }
    }

    /** Draws a tooltip hover to the login screen. */
    protected void addTooltip(String message) {
        if (Settings.LOGINSCREEN_HOVER_BOXES) {
            int x = Client.instance.mouseX;
            int y = Client.instance.mouseY;
            int boxWith = Client.instance.newSmallFont.getTextWidth(message) + 30;

            if (x > 638)
                x = 638;
            if (y > 467)
                y = 467;

            Raster.drawTransparentBox(x + 15, y + 10, boxWith, 22, 0x2D575C, 185);
            Raster.drawRectangle(x + 15, y + 10, boxWith, 22, 0x000000);
            Client.instance.newSmallFont.drawBasicString(message, x + 30, y + 27, 16777215, 1);
        }
    }

    /** Gets the x position of the mouse. */
    public int getX() {
        return Client.frameWidth / 2;
    }

    /** Gets the y position of the mouse. */
    public int getY() {
        return Client.frameHeight / 2;
    }
}
