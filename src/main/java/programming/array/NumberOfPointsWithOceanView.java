package programming.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), Get the points that touch water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: [2-0, 0-2, 1-1, 0-3, 2-1, 1-3]
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: [1-0, 0-1, 1-1, 2-2, 3-3, 3-4]
 */
public class NumberOfPointsWithOceanView {
    public static void main(String[] args) {
        System.out.println(findNumberOfIslands(new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}));
        System.out.println(findNumberOfIslands(new char[][] {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}}));

    }

    private static Set<String> findNumberOfIslands(char[][] input) {
        Set<String> set = new HashSet<>();
        boolean[][] visited = new boolean[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == '1' && !visited[i][j]) {
                    traverse(input, i, j, visited, set);
                }
            }
        }
        return set;
    }

    private static char traverse(char[][] input, int i, int j, boolean[][] visited, Set<String> set) {
        if (input[i][j] == '0') {
            return '0';
        }
        if (visited[i][j]) {
            return '1';
        }
        visited[i][j] = true;

        if (i - 1 >= 0 && traverse(input, i - 1, j, visited, set) == '0') {
            set.add(i + "-" + j);
        }
        if (i + 1 < input.length && traverse(input, i + 1, j, visited, set) == '0') {
            set.add(i + "-" + j);
        }
        if (j - 1 >= 0 && traverse(input, i, j - 1, visited, set) == '0') {
            set.add(i + "-" + j);
        }
        if (j + 1 < input[i].length && traverse(input, i, j + 1, visited, set) == '0') {
            set.add(i + "-" + j);
        }

        return '1';
    }
}
