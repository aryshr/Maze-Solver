package com.aryan.src.MazeSolver;

import java.util.Queue;
import java.util.LinkedList;

public class PathFinder extends MazeSolver {
    private static class QNode {
        int x;
        int y;
        QNode prev;

        QNode(int x, int y, QNode prev) {
            this.x = x;
            this.y = y;
            this.prev = prev;
        }
    }

    public boolean[][] pathFinder(String[][] maze) {
        int size = maze.length;
        boolean[][] visited = new boolean[size][size];
        boolean[][] path = new boolean[size][size];
        Queue<QNode> queue = new LinkedList<>();

        visited[0][0] = true;
        queue.add(new QNode(0, 0, null));

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            QNode current = queue.poll();
            int x = current.x;
            int y = current.y;

            if (maze[x][y] == END) {
                QNode parent = current;
                while (parent != null) {
                    path[parent.x][parent.y] = true;
                    parent = parent.prev;
                }
                return path;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < size && ny >= 0 && ny < size && (maze[nx][ny] == OPEN_SPACE || maze[nx][ny] == END)
                        && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new QNode(nx, ny, current));
                }
            }
        }

        // for (int i = 0; i < size; i++) {
        // for (int j = 0; j < size; j++) {
        // System.out.println(path[i][j]);
        // }
        // }

        return path;
    }
}
