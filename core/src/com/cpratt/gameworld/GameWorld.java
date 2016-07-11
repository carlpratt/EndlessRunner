package com.cpratt.gameworld;


import com.badlogic.gdx.Gdx;
import com.cpratt.gameobjects.Block;
import com.cpratt.gameobjects.Player;
import com.cpratt.helpers.Collider;
import com.cpratt.helpers.CourseGenerator;
import com.cpratt.settings.GS;

import java.util.ArrayList;
import java.util.List;

public class GameWorld {

    private Player player;
    private List<Block> blocks;
    private CourseGenerator courseGenerator;
    private int score = 0;
    private int highScore = 0;
    private GameState gameState;

    public GameWorld() {
        player = new Player(GS.PLAYER_START_X, GS.PLAYER_START_Y, GS.PLAYER_WIDTH, GS.PLAYER_HEIGHT);
        courseGenerator = new CourseGenerator(player);
        blocks = courseGenerator.generateInitCourse();
        gameState = GS.SPLASH_SCREEN_ENABLED ? GameState.SPLASH : GameState.GAME;
    }

    public void update(float delta) {
        if (gameState.equals(GameState.SPLASH)) {
            return;
        }

        player.update(delta);
        System.out.println(1/delta);
        Collider.handleCollisions(player, blocks);
        courseGenerator.handleCourseGeneration();
        score = (int) player.getX();

        if (player.getY() > GS.SCREEN_HEIGHT) {
            reset();
        }
    }

    public void reset() {
        player.reset();
        courseGenerator = new CourseGenerator(player);
        blocks = courseGenerator.generateInitCourse();

        if (score > highScore) {
            highScore = score;
        }

        score = 0;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public int getScore() {
        return score;
    }

    public int getHighScore() {
        return highScore;
    }

    public GameState getGameState() {
        return this.gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public enum GameState {
        SPLASH,
        GAME;
    }
}
