package com.cpratt.endlessrunner.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cpratt.endlessrunner.EndlessRunnerGame;

public class DesktopLauncher {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "EndlessRunner";
        config.width = 960;
        config.height = 640;
        new LwjglApplication(new EndlessRunnerGame(), config);
    }
}
