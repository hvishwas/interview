package programming.dp;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color, and you need to cost the least. Return the minimum cost.
 * <p>
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red;
 * costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 * Example 1:
 * <p>
 * Input: {{14,2,11}, {11,14,5}, {14,3,10}}
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. Minimum cost: 2 + 5 + 3 = 10.
 * Example 2:
 * <p>
 * Input: {{1,2,3},{1,4,6}}
 * Output: 3
 * <p>
 * Input: {{3, 2, 3}, {4, 1, 4}, {5, 1, 5}, {3, 2, 3}, {4, 1, 4}, {5, 1, 5}}
 * Output: 15
 */
class PaintHouse {
    public static void main(String[] args) {
        int[][] input = new int[][] {{3, 2, 3}, {4, 1, 4}, {5, 1, 5}, {3, 2, 3}, {4, 1, 4}, {5, 1, 5}}; //1, 0, 1, 0, 2, 1//B, R, B, R, G, B
//        int[][] input = new int[][] {{14,2,11}, {11,14,5}, {14,3,10}};
//        int[][] input = new int[][] {{1,2,3},{1,4,6}};

        System.out.println(findPaintHouse(input));
    }

    private static int findPaintHouse(int[][] input) {
        if (input.length == 1) {
            return Math.min(Math.min(input[0][0], input[0][1]), input[0][2]);
        }
        for (int i = 1; i < input.length; i++) {
            input[i][0] += Math.min(input[i - 1][1], input[i - 1][2]);
            input[i][1] += Math.min(input[i - 1][0], input[i - 1][2]);
            input[i][2] += Math.min(input[i - 1][0], input[i - 1][1]);
        }
        return Math.min(Math.min(input[input.length - 1][0], input[input.length - 1][1]), input[input.length - 1][2]);
    }
}
