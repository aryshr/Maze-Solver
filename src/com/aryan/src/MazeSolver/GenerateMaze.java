package com.aryan.src.MazeSolver;

import java.util.Random;

public class GenerateMaze extends MazeSolver {
    public String[][] generateMaze(int size) {
        String[][] maze = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                maze[i][j] = OPEN_SPACE;
            }
        }

        int walls = (int) (size * size * 0.35);
        Random random = new Random();
        for (int i = 0; i < walls; i++) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);
            maze[x][y] = WALL;
        }

        maze[0][0] = START;
        maze[size - 1][size - 1] = END;
        return maze;
    }
}
