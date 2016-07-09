package com.cpratt.endlessrunner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.cpratt.helpers.AssetLoader;
import com.cpratt.screens.GameScreen;

public class EndlessRunnerGame extends Game {

    @Override
    public void create() {
        Gdx.app.log("EndlessRunnerGame", "created");
        AssetLoader.load();
        setScreen(new GameScreen());
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
