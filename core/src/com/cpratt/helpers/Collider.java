package com.cpratt.helpers;


import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.cpratt.gameobjects.Block;
import com.cpratt.gameobjects.Player;
import com.cpratt.settings.GS;

import java.util.List;

public class Collider {

    public static void handleCollisions(Player player, List<Block> blocks) {
        for (Block block : blocks) {
            if (collides(player.getBounds(), block.getBounds())) {
//                System.out.println("COLLIDES");

                // Calculate overlaps between player and colliding block. Used to determine player final destination relative to block
                float xOverlapLeft = Math.abs(player.getPosition().x + GS.PLAYER_WIDTH - block.getPosition().x);
                float xOverlapRight = Math.abs(block.getPosition().x + GS.BLOCK_WIDTH - player.getPosition().x);

                float yOverlapTop = Math.abs(player.getPosition().y + GS.PLAYER_HEIGHT - block.getPosition().y);
                float yOverlapBottom = Math.abs(block.getPosition().y + GS.BLOCK_HEIGHT - player.getPosition().y);

                float xOverlap = xOverlapLeft < xOverlapRight ? xOverlapLeft : xOverlapRight;
                float yOverlap = yOverlapTop < yOverlapBottom ? yOverlapTop : yOverlapBottom;

//                System.out.println("yOverlap: " + yOverlap);
//                System.out.println("xOverlap: " + xOverlap);

                // Slightly favor y since block top collisions are most common
                if (yOverlap < xOverlap + 1) {
                    if (yOverlapTop < yOverlapBottom) {
                        player.getPosition().y = block.getPosition().y - GS.PLAYER_HEIGHT;
                        player.setNumJumpsSinceLastLanding(0);
                    } else {
                        player.getPosition().y = block.getPosition().y + GS.BLOCK_HEIGHT;
                    }
                    player.getVelocity().y = 0;
                } else {
                    if (xOverlapLeft < xOverlapRight) {
                        player.getPosition().x = block.getPosition().x - GS.PLAYER_WIDTH;
                    } else {
                        player.getPosition().x = block.getPosition().x + GS.BLOCK_WIDTH;
                    }
                    // removed to prevent player from randomly stopping
//                    player.stopMoving();
                }
                break;
            }
        }
    }

    private static boolean collides(Rectangle playerBounds, Rectangle blockBounds) {
        if (Math.abs(playerBounds.x - blockBounds.x) <= GS.BLOCK_WIDTH
                && Math.abs(playerBounds.y - blockBounds.y) <= GS.BLOCK_HEIGHT) {
            return (Intersector.overlaps(playerBounds, blockBounds));
        }
        return false;
    }
}
