package com.osroyale;

/**
 * Handles all configuration settings for the client.
 *
 * @author Daniel
 */
public class Configuration {

    /** The IP address client will be connecting to. */
    public static Connection CONNECTION = Connection.ECONOMY;

    /** State of client being in debug mode. */
    public static boolean DEBUG_MODE = true;

    /** Display client data. */
    static boolean CLIENT_DATA = false;

    /** Debug the interfaces. */
    static boolean DUMP_INTERFACES = false;

    /** State of client enabling RSA encryption. */
    static boolean ENABLE_RSA = true;

    /** The current NPC bits. */
    static final int NPC_BITS = 16;

    /** The current version of the client. */
    public static final int CLIENT_VERSION = 5;

    /** The current version of the cache. */
    public static final int CACHE_VERSION = 3;

    /** The current game version. */
    public static final String GAME_VERSION = "3.06";

    /** The name of the client. */
    final static String NAME = "Somnium";

    /** The prefix of the client. */
    final static String PREFIX = "";

    /** The cache file name. */
    final static String CACHE_NAME = "RunePK.Cache";

    /** The current displayed loading message. */
    static String LOADING_MESSAGE;

    public static final String SPRITE_FILE_NAME = "main_file_sprites";

    /** The character folder path. */
    static final String CHAR_PATH = Utility.findcachedir() + "Character";

    /** All the announcements which will be displayed on the loginscreen. */
    public final static String[] ANNOUNCEMENT = {
            "Latest news: Brand new login screen, winter event, vorkath revamp and much more!",
    };

    /** The loading screen messages. */
    final static String[] LOADING_MESSAGES = {
            "You can teleport around the map by clicking on the world map.",
            "Voting will be very rewarding to your account's progression.",
            "Need help? Ask any staff member or join the 'help' chan channel.",
            "Being part of a clan will make your progress a lot faster!",
            "Donating helps us keep the lights on!"
    };

    /** The left nav bar links. */
    static final String[] LEFT_NAV_LINKS = {"https://www.RunePK.io", "https://www.RunePK.io/community", "https://discord.me/RunePK"};

    /** The right nav bar links. */
    static final String[] RIGHT_NAV_LINKS = {"https://www.RunePK.io/vote", "https://www.RunePK.io/store/", "https://www.RunePK.io/highscores/"};
}
