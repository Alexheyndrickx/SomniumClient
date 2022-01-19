package com.osroyale.login.impl;

import com.osroyale.Client;
import com.osroyale.Configuration;
import com.osroyale.Raster;
import com.osroyale.login.LoginComponent;
import com.osroyale.login.ScreenType;

/**
 * Handles the message screen of login.
 *
 * @author Daniel
 */
public class MessageScreen extends LoginComponent {

    @Override
    public void render(Client client) {
        int centerX = getX();
        int centerY = getY();
        refresh(client);
        load(client, 13);

        /* Background */
        Client.spriteCache.get(678).drawTransparentSprite((Client.frameWidth / 2) - (Client.spriteCache.get(57).width / 2), (Client.frameHeight / 2) - (Client.spriteCache.get(57).height / 2), client.loginTick);

        /* Box */
        Raster.fillRectangle(175, 215, 425, 100, 0x26464A, 150);
        Raster.drawRectangle(175, 215, 425, 100, 0x38848C);

        /* Messages */
        client.boldText.drawCenteredText(0x27A2B0, centerX + 5, "RunePK", centerY - 115, true);
        client.regularText.drawCenteredText(0xD4A190, centerX + 5, "Error Message", centerY - 95, true);
        if (client.loginMessage2.length() == 0) {
            client.regularText.drawCenteredText(0xD4A190, centerX + 5, client.loginMessage1, centerY + 25, true);
        } else if (client.loginMessage1.length() == 0) {
            client.regularText.drawCenteredText(0xD4A190, centerX + 5, client.loginMessage2, centerY + 25, true);
        } else {
            client.boldText.drawCenteredText(0xD4A190, centerX + 5, client.loginMessage1, centerY + 15, true);
            client.boldText.drawCenteredText(0xD4A190, centerX + 5, client.loginMessage2, centerY + 35, true);
        }
        client.boldText.drawCenteredText(0xFFFFFF, centerX + 5, "[ Click anywhere to return to the main screen ]", centerY + 150, true);

        /* Announcement */
        announcement(client);

        /* Bubble */
        drawSetting(client);

        client.smallFont.drawCenteredText(0x27A2B0, centerX + 330, "Client Build: " + Configuration.GAME_VERSION, centerY + 245, true);

        /* Drawing */
        Client.loginScreenIP.drawGraphics(client.graphics, 0, 0);
        Raster.reset();
    }

    @Override
    public void click(Client client) {
        int centerX = getX();
        int centerY = getY();

        /* Bubble */
        settingButton(client);

        if (client.lastMetaModifier == 1 && client.mouseInRegion(centerX - 381, centerY - 249, centerX + 381, centerY + 245)) {
            client.loginMessage1 = "";
            client.loginMessage2 = "";
            client.loginRenderer.setScreen(new MainScreen());
        }
    }

    @Override
    public ScreenType type() {
        return ScreenType.MESSAGE;
    }
}
