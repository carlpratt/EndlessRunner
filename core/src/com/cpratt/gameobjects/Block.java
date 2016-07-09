package com.cpratt.gameobjects;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cpratt.settings.GS;

public class Block {

    private Vector2 position;

    public Block (float x, float y) {
        position = new Vector2(x, y);
    }

    public Vector2 getPosition() {
        return position;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return GS.BLOCK_WIDTH;
    }

    public float getHeight() {
        return GS.BLOCK_HEIGHT;
    }

    public Rectangle getBounds() {
        return new Rectangle(position.x, position.y, GS.BLOCK_WIDTH, GS.BLOCK_HEIGHT);
    }
}
