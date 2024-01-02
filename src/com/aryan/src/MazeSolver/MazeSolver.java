package com.aryan.src.MazeSolver;

import java.util.*;

public class MazeSolver {

    public static final String WALL = " || ";
    public static final String OPEN_SPACE = " _ ";
    public static final String START =  " S ";
    public static final String END = " E ";
    public static final String PATH = " * ";

    public static void main(String[] args) {

        boolean restart = true;
        Scanner scanner = new Scanner(System.in);
        int size;
        while (restart) {
            System.out.print("Enter the size of the maze: ");

            size = scanner.nextInt();

            // Generate the Maze Matrix

            GenerateMaze obj = new GenerateMaze();
            String[][] maze = obj.generateMaze(size);

            PrintMaze printMaze = new PrintMaze();
            System.err.println("Generated Maze: \n");
            printMaze.printMaze(maze);

            int choice = getUserChoice();

            switch (choice) {
                case 1: // Print the path
                    PathFinder pathFind = new PathFinder();
                    boolean[][] path = pathFind.pathFinder(maze);

                    System.out.println();

                    PathPrint printPath = new PathPrint();
                    printPath.pathPrinting(path, maze);
                    break;

                case 2:
                    break;

                case 3: // Exit
                    System.exit(0);
                    restart = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

        }
        scanner.close();

    }

    // Function to obtain user choice
    private static int getUserChoice() {
        System.out.println("Choose an option:");
        System.out.println("1. Print the path");
        System.out.println("2. Generate another puzzle");
        System.out.println("3. Exit the game");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
