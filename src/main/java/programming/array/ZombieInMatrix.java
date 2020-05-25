package programming.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D grid, each cell is either a zombie 1 or a human 0. (Or in case of the servers 1 means a server which already contains the file and 0 is an empty server). Zombies can
 * turn adjacent (up/down/left/right) human beings into zombies every hour (server can send a file to adjacent server). Find out how many hours does it take to infect all
 * humans (send the file to all servers)?
 * Example:
 * Input:
 * [[0, 1, 1, 0, 1],
 * [0, 1, 0, 1, 0],
 * [0, 0, 0, 0, 1],
 * [0, 1, 0, 0, 0]]
 * Output: 2
 * Explanation:
 * At the end of the 1st hour, the status of the grid:
 * [[1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1],
 * [0, 1, 0, 1, 1],
 * [1, 1, 1, 0, 1]]
 * At the end of the 2nd hour, the status of the grid:
 * [[1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1]]
 */
public class ZombieInMatrix {
    public static void main(String[] args) {
        System.out.println(findZombieTime(new int[][] {
                {0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0}
        }));
        System.out.println(findZombieTime(new int[][] {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        }));
    }

    private static int findZombieTime(int[][] input) {
        int hours = -1;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<Location> zQueue = new LinkedList<>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == 1) {
                    zQueue.add(new Location(i, j));
                }
            }
        }
        while (!zQueue.isEmpty()) {
            int size = zQueue.size();
            for (int i = 0; i < size; i++) {
                Location l = zQueue.poll();
                for (int[] dir : directions) {
                    int row = l.row + dir[0];
                    int col = l.column + dir[1];
                    if (row >= 0 && row < input.length && col >= 0 && col < input[row].length && input[row][col] == 0) {
                        zQueue.add(new Location(row, col));
                        input[row][col] = 1;
                    }
                }
            }
            hours++;
        }
        return hours;
    }

    private static class Location {
        int row;
        int column;

        public Location(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}