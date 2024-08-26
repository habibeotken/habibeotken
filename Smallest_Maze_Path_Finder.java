import java.util.*;

public class SMP_Finder {

    public static void main(String[] args) {
        int[][] maze_1 = {{25, 30, 15, 13, 10},
                {3, 90, 80, 76, 14},
                {18, 92, 34, 47, 56},
                {42, 59, 5, 8, 77},
                {69, 58, 12, 9, 2}};
        int[][] maze_2 = {{528, 507, 402, 535, 31, 206, 45, 136, 346, 66},
                {696, 129, 339, 3, 115, 304, 612, 472, 661, 52},
                {318, 311, 255, 87, 199, 108, 269, 122, 164, 38},
                {367, 262, 458, 416, 374, 388, 437, 430, 276, 185},
                {556, 465, 10, 381, 640, 682, 514, 332, 192, 59},
                {353, 598, 591, 290, 626, 234, 409, 521, 24, 241},
                {444, 479, 486, 570, 171, 542, 325, 668, 360, 549},
                {493, 213, 297, 689, 101, 178, 395, 248, 73, 283},
                {654, 423, 143, 605, 675, 577, 563, 17, 619, 94},
                {633, 220, 150, 584, 157, 451, 500, 227, 647, 80}};
        int[][] maze_3 = {{238, 173, 123, 193, 23, 208, 33},
                {68, 228, 133, 98, 83, 28, 58},
                {73, 223, 38, 163, 93, 103, 18},
                {118, 43, 138, 88, 113, 198, 108},
                {143, 78, 158, 168, 233, 13, 148},
                {218, 203, 8, 53, 48, 3, 243},
                {213, 178, 188, 183, 153, 128, 63}};
        int[][] maze_4 = {{10, 30, 60},
                {40, 25, 12},
                {65, 6, 58},
                {78, 36, 90}};
        int[][] maze_5={{1,2,5},
                {4,3,10},
                {7,8,9}};

        System.out.println("Maze 1 SMP:");
        findSMP(maze_1);
        System.out.println("Maze 2 SMP:");
        findSMP(maze_2);
        System.out.println("Maze 3 SMP:");
        findSMP(maze_3);
        System.out.println("Maze 4 SMP:");
        findSMP(maze_4);
        System.out.println("Maze 5 SMP: ");
        findSMP(maze_5);
    }

    private static void findSMP(int[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int row = 0, col = 0, totalCost = 0;

        String path = "";

        while (true) {
            visited[row][col] = true;
            path = path + String.valueOf(maze[row][col]);
            if (col == cols - 1) {
                // Reached the end of the maze
                totalCost += maze[row][col];
                break;
            }

            int nextRow = -1;
            int nextCol = -1;
            int minVal = Integer.MAX_VALUE;

            // Check all four directions
            if (row > 0 && !visited[row - 1][col] && maze[row - 1][col] < minVal) {
                minVal = maze[row - 1][col];
                nextRow = row - 1;
                nextCol = col;
            }
            if (row < rows - 1 && !visited[row + 1][col] && maze[row + 1][col] < minVal) {
                minVal = maze[row + 1][col];
                nextRow = row + 1;
                nextCol = col;
            }
            if (col < cols - 1 && !visited[row][col + 1] && maze[row][col + 1] < minVal) {
                minVal = maze[row][col + 1];
                nextRow = row;
                nextCol = col + 1;
            }
            if (col > 0 && !visited[row][col - 1] && maze[row][col - 1] < minVal) {
                minVal = maze[row][col - 1];
                nextRow = row;
                nextCol = col - 1;
            }

            if (nextRow == -1) {
                // No valid move found
                System.out.println("Could not find SMP!!!");
                return;
            }

            totalCost += maze[row][col];
            row = nextRow;
            col = nextCol;
            path = path + " -> ";
        }

        System.out.println(path + ": " + totalCost);
    }
}
