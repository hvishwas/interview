package programming.array;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or
 * vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
public class NumberOfIslands {
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

    private static int findNumberOfIslands(char[][] input) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == '1') {
                    traverse(input, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void traverse(char[][] input, int i, int j) {
        if (i < 0 || j < 0 || i >= input.length || j >= input[i].length || input[i][j] == '0') {
            return;
        }
        input[i][j] = '0';
        traverse(input, i - 1, j);
        traverse(input, i + 1, j);
        traverse(input, i, j - 1);
        traverse(input, i, j + 1);
    }
}
