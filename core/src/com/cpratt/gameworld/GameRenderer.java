package com.cpratt.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.cpratt.gameobjects.Block;
import com.cpratt.gameobjects.Player;
import com.cpratt.helpers.AssetLoader;
import com.cpratt.settings.GS;

public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batcher;

    private int midPointY;
    private int gameHeight;

    private TextureRegion playerAsset, playerAssetLeft, playerAssetRight, brickAsset;

    private SpriteBatch spriteBatch;
    private BitmapFont font;

    public GameRenderer(GameWorld world, int gameHeight) {
        myWorld = world;

        // The word "this" refers to this instance.
        // We are setting the instance variables' values to be that of the
        // parameters passed in from GameScreen.
        this.gameHeight = gameHeight;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, GS.SCREEN_WIDTH, GS.SCREEN_HEIGHT);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        spriteBatch = new SpriteBatch();
        font = new BitmapFont();

        initAssets();
    }

    private void initAssets() {
//        bg = AssetLoader.bg;
//        grass = AssetLoader.grass;
//        birdAnimation = AssetLoader.birdAnimation;
//        birdMid = AssetLoader.bird;
//        birdDown = AssetLoader.birdDown;
//        birdUp = AssetLoader.birdUp;
//        skullUp = AssetLoader.skullUp;
//        skullDown = AssetLoader.skullDown;
//        bar = AssetLoader.bar;
        brickAsset = AssetLoader.bricks;
        playerAssetLeft = AssetLoader.playerLeft;
        playerAssetRight = AssetLoader.playerRight;
        playerAsset = AssetLoader.playerRight;
    }

    public void render(float runTime) {

        if (myWorld.getGameState().equals(GameWorld.GameState.SPLASH)) {
            // Fill the entire screen with black, to prevent potential flickering.
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            spriteBatch.begin();
            font.setColor(Color.WHITE); // Need to use the actual screen dimensions here for some reason
            font.draw(spriteBatch, "TOUCH TO BEGIN", (Gdx.graphics.getWidth() / 2), Gdx.graphics.getHeight() / 2);
            spriteBatch.end();
            return;
        }

        /** Camera position */
        cam.position.x = myWorld.getPlayer().getX() + (GS.SCREEN_WIDTH / 2) - 100;
        cam.update();
        batcher.setProjectionMatrix(cam.combined);

        /** Render game assets (Player, Blocks) */
        // We will move these outside of the loop for performance later.
        Player player = myWorld.getPlayer();

        // Fill the entire screen with black, to prevent potential flickering.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batcher.begin();
        batcher.draw(playerAsset, player.getX(), player.getY(), GS.PLAYER_WIDTH, GS.PLAYER_HEIGHT);

        for (Block b : myWorld.getBlocks()) {
            batcher.draw(brickAsset, b.getX(), b.getY(), b.getWidth(), b.getHeight());
        }

        batcher.end();

        /** Render the score and high score */
        spriteBatch.begin();
        font.setColor(Color.WHITE); // Need to use the actual screen dimensions here for some reason
        font.draw(spriteBatch, "SCORE: " + Integer.toString(myWorld.getScore()),
                (Gdx.graphics.getWidth() / 2) - 400, Gdx.graphics.getHeight() - 20);
        font.draw(spriteBatch, "HIGH SCORE: " + Integer.toString(myWorld.getHighScore()),
                (Gdx.graphics.getWidth() / 2) - 400, Gdx.graphics.getHeight() - 40);
        spriteBatch.end();

        // Begin SpriteBatch
//        batcher.begin();
//        // Disable transparency
//        // This is good for performance when drawing images that do not require
//        // transparency.
//        batcher.disableBlending();
//        batcher.draw(AssetLoader.bg, 0, midPointY + 23, 136, 43);
//
//        // The bird needs transparency, so we enable that again.
//        batcher.enableBlending();

        // Draw bird at its coordinates. Retrieve the Animation object from
        // AssetLoader
        // Pass in the runTime variable to get the current frame.
//        batcher.draw(AssetLoader.birdAnimation.getKeyFrame(runTime),
//                bird.getX(), bird.getY(), bird.getWidth(), bird.getHeight());

        // End SpriteBatch
//        batcher.end();

    }
}
