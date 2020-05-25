package programming.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * In a given grid, each cell can have one of three values:
 * <p>
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * <p>
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <img src="../../../resources/oranges.png">
 * <p>
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 * <p>
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 * <p>
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] is only 0, 1, or 2.
 */
public class RottingOranges {

    public static void main(String[] args) {
        System.out.println(findRottingOranges(new int[][] {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(findRottingOranges(new int[][] {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        System.out.println(findRottingOrangesQueue(new int[][] {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(findRottingOrangesQueue(new int[][] {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
    }

    private static int findRottingOrangesQueue(int[][] grid) {
        Queue<int[]> rotten = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rotten.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int count = -1;

        while (!rotten.isEmpty()) {
            int size = rotten.size();
            for (int i = 0; i < size; i++) {
                int[] l = rotten.poll();
                for (int[] d : directions) {
                    int row = l[0] + d[0];
                    int col = l[1] + d[1];
                    if (row >= 0 && col >= 0 && row < grid.length && col < grid[row].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        rotten.offer(new int[] {row, col});
                        fresh--;
                    }
                }
            }
            count++;
        }
        return fresh > 0 ? -1 : count;
    }

    private static int findRottingOranges(int[][] grid) {
        Set<Location> rotten = new HashSet<>();
        Set<Location> fresh = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fresh.add(new Location(i, j));
                } else if (grid[i][j] == 2) {
                    rotten.add(new Location(i, j));
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int count = 0;
        while (!fresh.isEmpty()) {
            Set<Location> infected = new HashSet<>();
            for (Location l : rotten) {
                for (int[] d : directions) {
                    int row = d[0] + l.row;
                    int col = d[1] + l.col;
                    if (row >= 0 && col >= 0 && row < grid.length && col < grid[row].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        Location i = new Location(row, col);
                        infected.add(i);
                        fresh.remove(i);
                    }
                }
            }
            if (infected.isEmpty()) {
                return -1;
            }
            count++;
            rotten = infected;
        }
        return count;
    }

    private static class Location {
        int row;
        int col;

        public Location(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Location location = (Location) o;
            return row == location.row &&
                    col == location.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
