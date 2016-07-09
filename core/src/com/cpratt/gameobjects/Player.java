package com.cpratt.gameobjects;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.cpratt.settings.GS;

public class Player {

    private Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private int width;
    private int height;

    private int numJumpsSinceLastLanding = 0;

    public Player(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);
        velocity = new Vector2(GS.PLAYER_LATERAL_VELOCITY, 0);
        acceleration = new Vector2(GS.PLAYER_INIT_ACCELERATION_X, GS.GRAVITY_ACCELERATION);
    }

    public void update(float delta) {

        velocity.add(acceleration.cpy().scl(delta));

        if (velocity.y > 200) {
            velocity.y = 200;
        }

        System.out.println(velocity.x);

//        velocity.x = GS.PLAYER_LATERAL_VELOCITY;

        position.add(velocity.cpy().scl(delta));
    }

    public void reset() {
        position.x = GS.PLAYER_START_X;
        position.y = GS.PLAYER_START_Y;
        velocity = new Vector2(GS.PLAYER_LATERAL_VELOCITY, 0);
        acceleration = new Vector2(GS.PLAYER_INIT_ACCELERATION_X, GS.GRAVITY_ACCELERATION);
    }

    public void onClick() {
        velocity.y = -140;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Rectangle getBounds() {
        return new Rectangle(position.x, position.y, GS.PLAYER_WIDTH, GS.PLAYER_HEIGHT);
    }

    public void jump() {
        System.out.println("JUMP");
        velocity.y = GS.PLAYER_VERTICAL_VELOCITY;
        acceleration.y = GS.GRAVITY_ACCELERATION;
    }

    public void moveRight() {
        velocity.x = GS.PLAYER_LATERAL_VELOCITY;
    }

    public void moveLeft() {
        velocity.x = -GS.PLAYER_LATERAL_VELOCITY;
    }

    public void stopMoving() {
        velocity.x = 0;
    }

    public boolean canDoubleJump() {
        return numJumpsSinceLastLanding < 2;
    }

    public int getNumJumpsSinceLastLanding() {
        return numJumpsSinceLastLanding;
    }

    public void incNumJumpsSinceLastLanding() {
        numJumpsSinceLastLanding++;
    }

    public void setNumJumpsSinceLastLanding(int numJumps) {
        this.numJumpsSinceLastLanding = numJumps;
    }
}
