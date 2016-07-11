package com.cpratt.settings;

import com.badlogic.gdx.Gdx;

/**
 * Global Settings
 */
public class GS {
    public static int SCREEN_WIDTH = Gdx.graphics.getWidth() / 2; // Scaled for ortho cam
    public static int SCREEN_HEIGHT = Gdx.graphics.getHeight() / 2; // Scaled for ortho cam

    // Movement
    public static int ZERO = 0; // Dumb, but makes it slightly easier to track down where the value 0 is used.

    public static int PLAYER_LATERAL_VELOCITY = 300;
    public static int PLAYER_VERTICAL_VELOCITY = -250;

    public static int PLAYER_INIT_ACCELERATION_X = 0;
    public static int GRAVITY_ACCELERATION = 1000;

    // Assets
    public static int PLAYER_WIDTH = 15;
    public static int PLAYER_HEIGHT = 20;

    public static int BLOCK_HEIGHT = 20;
    public static int BLOCK_WIDTH = 20;

    public static int PLAYER_START_X = 60;
    public static int PLAYER_START_Y = SCREEN_HEIGHT - BLOCK_HEIGHT - PLAYER_HEIGHT;

    // Camera
    public static int CAMERA_OFFSET_X = 100;

    // WORLD
    // Length of row of solid blocks to generate on init course creation. Prevents player from beginning over nothing.
    public static int INIT_COURSE_SAFE_ZONE_LENGTH = 15;

    // MISC
    public static int RENDER_BOUNDS_X = 400;
    public static int RENDER_BOUNDS_Y = 400;

    // FEATURES
    public static boolean DOUBLE_JUMP_ENABLED = true;
    public static boolean SPLASH_SCREEN_ENABLED = false;
}
