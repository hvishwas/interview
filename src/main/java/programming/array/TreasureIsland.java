package programming.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in. There are other
 * explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.
 * <p>
 * Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from the top-left corner of the map and can move one block up, down, left
 * or right at a time. The treasure island is marked as X in a block of the matrix. X will not be at the top-left corner. Any block with dangerous rocks or reefs will be marked
 * as D. You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in. The top-left corner is always safe. Output the minimum number of
 * steps to get to the treasure.
 * <p>
 * Example:
 * <p>
 * Input:
 * [['O', 'O', 'O', 'O'],
 * ['D', 'O', 'D', 'O'],
 * ['O', 'O', 'O', 'O'],
 * ['X', 'D', 'D', 'O']]
 * <p>
 * Output: 5
 * Explanation: Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
 */
public class TreasureIsland {
    public static void main(String[] args) {
        System.out.println(findMinPathToTreasure(new char[][] {
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'X'}
        }));
    }

    private static int findMinPathToTreasure(char[][] input) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        input[0][0] = 'D';
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int count = 1;
        while (!queue.isEmpty()) {
            for (int s = queue.size(); s > 0; s--) {
                int[] point = queue.poll();

                for (int[] d : directions) {
                    int x = point[0] + d[0];
                    int y = point[1] + d[1];
                    if (x >= 0 && x < input.length && y >= 0 && y < input[0].length && input[x][y] != 'D') {
                        if (input[x][y] == 'X') {
                            return count;
                        }
                        queue.add(new int[] {x, y});
                        input[x][y] = 'D';
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
