package com.cpratt.helpers;

import com.cpratt.gameobjects.Block;
import com.cpratt.gameobjects.Player;
import com.cpratt.settings.GS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CourseGenerator {

    private static final int INIT_COURSE_LENGTH = 50;
    private static final int CHUNK_LENGTH_BLOCKS = 50; // in blocks
    private static final int CHUNK_LENGTH = CHUNK_LENGTH_BLOCKS * GS.BLOCK_WIDTH;

    private static Random random = new Random();

    private Player player;

    private int chunksGenerated = 0;

    private List<Block> blocks;

    public CourseGenerator(Player player) {
        this.player = player;
    }

    public List<Block> generateInitCourse() {
        blocks = generateChunk(GS.ZERO);

        // trying to generate the initial chunk as a solid block
//        blocks = new ArrayList<Block>();
//
//        for (int i = 0; i < CHUNK_LENGTH_BLOCKS; i++) {
//            blocks.add(new Block(i * GS.BLOCK_WIDTH, GS.SCREEN_HEIGHT - GS.BLOCK_HEIGHT));
//        }
//        chunksGenerated++;

        return blocks;
    }

    public List<Block> handleCourseGeneration() {
        if (shouldGenerateNewChunk(player)) {
            blocks.addAll(generateChunk(CHUNK_LENGTH * chunksGenerated));
        }
        return blocks;
    }

    private List<Block> generateChunk(int startX) {
        List<Block> blocks = new ArrayList<Block>();

        System.out.println("generate new chunk");

        for (int i = startX; i < CHUNK_LENGTH; i++) {
            if ((random.nextInt(4)) != 0) {
                blocks.add(new Block(i * GS.BLOCK_WIDTH, GS.SCREEN_HEIGHT - GS.BLOCK_HEIGHT));
            } else {
                i++; // generate gaps in at least 2 block increments
            }
        }
        chunksGenerated++;
        return blocks;
    }

    private boolean shouldGenerateNewChunk(Player player) {
        int x = (int) player.getX();

        return (x > CHUNK_LENGTH * (chunksGenerated - 1));
    }
}
