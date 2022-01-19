package com.osroyale.login.impl;


import com.osroyale.*;
import com.osroyale.login.LoginComponent;
import com.osroyale.login.ScreenType;

/**
 * Handles the main screen of login.
 *
 * @author Daniel
 */
public class MainScreen extends LoginComponent {

	private static final int EMAIL_CHARACTER_LIMIT = 28;

	@Override
	public void render(Client client) {
		int centerX = getX();
		int centerY = getY();
		refresh(client);
		load(client, 10);

        /* Message Check */
		if (client.loginMessage1.length() > 0 || client.loginMessage2.length() > 0) {
			client.loginRenderer.setScreen(new MessageScreen());
		}

        /* Background */
		Client.spriteCache.get(57).drawTransparentSprite((Client.frameWidth / 2) - (Client.spriteCache.get(57).width / 2), (Client.frameHeight / 2) - (Client.spriteCache.get(57).height / 2), client.loginTick);

		/* Latest updates */
		announcement(client);

		/* Left bottom bar sprite*/
		Client.spriteCache.get(872).drawSprite(655, 453);

		/* Left bottom bar sprite*/
		Client.spriteCache.get(873).drawSprite(0, 453);

		drawSetting(client);

		/* Login box */
		Client.spriteCache.get(866).drawARGBSprite(208, 230);
		Client.spriteCache.get(871).drawARGBSprite(361, 211);
		client.newFancyFont.drawCenteredString("Welcome to the world of Somnium", centerX,  262, 0x717171, 0);

        /* Login Button */
		if (client.mouseInRegion(318, 412, 445, 439)) {
			Client.spriteCache.get(59).drawSprite(318, 412);
			addTooltip("Log in");
		} else {
			Client.spriteCache.get(58).drawTransparentSprite(318, 412, client.loginTick);
		}

        /* Username and password */
		client.newFancyFont.drawCenteredString("Username:", centerX,  298, 0xb9b9b9, 0);
		if (client.mouseInRegion(292, 302, 473, 330)) {
			Client.spriteCache.get(870).drawTransparentSprite(292, 302, 200);
			addTooltip("Enter your username");
		} else {
			Client.spriteCache.get(869).drawTransparentSprite(292, 302, 200);
		}

		client.newFancyFont.drawCenteredString("Password:", centerX,  351, 0xb9b9b9, 0);
		if (client.mouseInRegion(292, 355, 473, 393)) {
			Client.spriteCache.get(870).drawTransparentSprite(292, 355, 200);
			addTooltip("Enter your password");
		} else {
			Client.spriteCache.get(869).drawTransparentSprite(292, 355, 200);
		}

		client.boldText.drawCenteredText(0x717171, centerX, Utility.formatName(client.myUsername) + ((client.loginScreenCursorPos == 0) & (Client.tick % 40 < 20) ? "|" : ""), 322, true);
		client.boldText.drawCenteredText(0x717171, centerX, StringUtils.toAsterisks(client.myPassword) + ((client.loginScreenCursorPos == 1) & (Client.tick % 40 < 20) ? "|" : ""), 375, true);

        /* Account */
		//drawAccount(client);

        /* Drawing */
		Client.loginScreenIP.drawGraphics(client.graphics, 0, 0);
		Raster.reset();
	}

	@Override
	public void click(Client client) {
		int centerX = getX();
		int centerY = getY();

        /* Username */
		if (client.lastMetaModifier == 1 && client.mouseInRegion(292, 302, 473, 330))
			client.loginScreenCursorPos = 0;

        /* Password */
		if (client.lastMetaModifier == 1 && client.mouseInRegion(292, 355, 473, 393))
			client.loginScreenCursorPos = 1;

        /* Account */
		int yPos = centerY - 70;
		if (AccountManager.ACCOUNTS != null) {
			for (int index = 0; index < AccountManager.ACCOUNTS.size(); index++, yPos += 105) {
				AccountData accountData = AccountManager.ACCOUNTS.get(index);
				if (client.lastMetaModifier == 1 && client.mouseInRegion(centerX - 230, yPos - 84, centerX - 63, yPos - 5)) {
					client.lastAccount = accountData;
					client.myUsername = Utility.formatName(accountData.username.toLowerCase());
					client.myPassword = accountData.password;
					client.attemptLogin(accountData.username, accountData.password, false);
					if (Client.loggedIn) {
						return;
					}
				}
				if (client.lastMetaModifier == 1 && client.mouseInRegion(centerX - 230, yPos - 2, centerX - 83, yPos + Client.spriteCache.get(676).height)) {
					if (client.lastAccount == null) {
						client.loginMessage1 = "There was an issue loading your account.";
						return;
					}
					client.lastAccount = accountData;
					client.loginRenderer.setScreen(new AccountScreen());
					return;
				}
				if (client.lastMetaModifier == 1 && client.mouseInRegion(centerX - 80, yPos, centerX - Client.spriteCache.get(675).width - 45, yPos + 20)) {
					AccountManager.removeAccount(accountData);
				}
			}
		}

        /* Bubble */
		settingButton(client);

        /* World Button */
		if (client.lastMetaModifier == 1 && client.mouseInRegion(centerX - 58, centerY + 132, centerX + 27, centerY + 158)) {
			switch (Configuration.CONNECTION) {
				case ECONOMY:
					Configuration.CONNECTION = Connection.MANAGEMENT;
					break;
				case MANAGEMENT:
					Configuration.CONNECTION = Connection.DEVELOPMENT;
					break;
				case DEVELOPMENT:
					Configuration.CONNECTION = Connection.ECONOMY;
					break;
			}
			Client.server = Configuration.CONNECTION.address;
		}

        /* Login Buttons */
		if (client.lastMetaModifier == 1 && client.mouseInRegion(318, 412, 445, 439))
		{
			if (!Client.loggedIn)
			{
				client.attemptLogin(client.myUsername, client.myPassword, false);
			}
		}

        /* Writing */
		handleWriting(client);
	}

	/** Handles drawing the accounts on the login screen.  */
	@SuppressWarnings("ConstantConditions")
	private void drawAccount(Client client) {
		Raster.fillRectangle(155, 126, 164, 313, 0x000000, 150);

		int centerX = getX();
		int centerY = getY();
		int yPos = centerY - 34;
		for (int index = 0; index < 3; index++, yPos += 105) {
			AccountData accountData = AccountManager.get(index);

			if (accountData == null) {
//				Client.spriteCache.get(73).drawARGBSprite(centerX - 176, yPos - 70);
//				Client.spriteCache.get(676).drawARGBSprite(centerX - 223, yPos - 2);
			} else {
				if (client.mouseInRegion(centerX - 80, yPos, centerX - Client.spriteCache.get(675).width - 45, yPos + 20)) {
					Client.spriteCache.get(675).drawARGBSprite(centerX - 80, yPos);
					addTooltip("Delete profile");
				} else {
					Client.spriteCache.get(674).drawARGBSprite(centerX - 80, yPos);
				}
				Client.spriteCache.get(accountData.avatar).drawARGBSprite(centerX - 182, yPos - 80);
				Client.spriteCache.get(676).drawARGBSprite(centerX - 223, yPos - 2);
				int rank = (accountData.rank - 1);
				String name = accountData.username;
				if (rank <= -1) {
					client.newSmallFont.drawCenteredString(Utility.formatName(name), centerX - 145, yPos + 16);
				} else {
					client.newSmallFont.drawCenteredString("<img=" + rank + ">", centerX - 145, yPos + 13);
					client.newSmallFont.drawCenteredString("<col=ffffff>" + Utility.formatName(name.toLowerCase()), centerX - 145, yPos + 22);
				}
				if (client.mouseInRegion(centerX - 227, yPos - 2, centerX - 83, yPos + Client.spriteCache.get(676).height)) {
					Raster.drawRectangle(centerX - 227, yPos - 2, Client.spriteCache.get(676).width, Client.spriteCache.get(676).height, 0x329EAB);
					Raster.fillRectangle(centerX - 227, yPos - 2, Client.spriteCache.get(676).width, Client.spriteCache.get(676).height, 0x539299, 50);
					addTooltip("Manage profile details");
				}
				if (client.mouseInRegion(centerX - 230, yPos - 84, centerX - 63, yPos - 5)) {
					Raster.drawRectangle(155, yPos - 81, 164, 80, 0x329EAB);
					Raster.fillRectangle(155, yPos - 81, 164, 80, 0x539299, 50);
					addTooltip("Log into game with profile");
				}
			}
		}
	}

	/**
	 * Handles writing in the client.
	 */
	private void handleWriting(Client client) {
		do {
			int line = client.readChar(-796);
			if (line == -1)
				break;
			boolean flag = false;
			for (int index = 0; index < Client.validUserPassChars.length(); index++) {
				if (line != Client.validUserPassChars.charAt(index))
					continue;
				flag = true;
				break;
			}

			// Main account username
			if (client.loginScreenCursorPos == 0) {
				if (line == 8 && client.myUsername.length() > 0)
					client.myUsername = client.myUsername.substring(0, client.myUsername.length() - 1);
				if (line == 9 || line == 10 || line == 13) {
					client.loginScreenCursorPos = 1;
				}
				if (flag) {
					client.myUsername += (char) line;
				}

				if (client.myUsername.length() > EMAIL_CHARACTER_LIMIT) {
					client.myUsername = client.myUsername.substring(0, EMAIL_CHARACTER_LIMIT);
				}

				// Main account password
			} else if (client.loginScreenCursorPos == 1) {
				if (line == 8 && client.myPassword.length() > 0)
					client.myPassword = client.myPassword.substring(0, client.myPassword.length() - 1);
				if (line == 9 || line == 10 || line == 13) {
					client.attemptLogin(client.myUsername, client.myPassword, false);
				}
				if (flag) {
					client.myPassword += (char) line;
				}
				if (client.myPassword.length() > 20) {
					client.myPassword = client.myPassword.substring(0, 20);
				}
			}
		} while (true);
		return;
	}

	@Override
	public ScreenType type() {
		return ScreenType.MAIN;
	}
}
