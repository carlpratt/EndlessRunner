package com.cpratt.helpers;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.cpratt.gameobjects.Player;
import com.cpratt.gameworld.GameWorld;
import com.cpratt.settings.GS;

public class InputHandler implements InputProcessor {

    private GameWorld gameWorld;
    private Player player;

    public InputHandler(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        this.player = gameWorld.getPlayer();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (gameWorld.getGameState().equals(GameWorld.GameState.SPLASH)) {
            gameWorld.setGameState(GameWorld.GameState.GAME);
            return true;
        }

        player.onClick();
        return true; // Return true to say we handled the touch.
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.DPAD_UP:
                if (GS.DOUBLE_JUMP_ENABLED) {
                    if (player.canDoubleJump()) {
                        player.jump();
                        player.incNumJumpsSinceLastLanding();
                    }
                } else if (player.getVelocity().y == 0) {
                    System.out.println("JUMP");
                    player.jump();
                }
                break;
            case Input.Keys.R:
                gameWorld.reset();
        }
        return true;    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
