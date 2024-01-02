package com.aryan.src.MazeSolver;

public class PathPrint extends MazeSolver {
    public void pathPrinting(boolean[][] path, String[][] maze) {
        int size = maze.length;
        if (path[size - 1][size - 1] != true) {
            System.out.println("Cannot reach the end cell !!");
            return;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (path[i][j] && maze[i][j] != START && maze[i][j] != END) {
                    maze[i][j] = PATH;
                }
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }
}
