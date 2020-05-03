package programming.dp;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of
 * them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
class HouseRobber {
    public static void main(String[] args) {
//        int[] input = new int[] {3, 1, 1, 5, 2, 5};//13
        int[] input = new int[] {2, 7, 9, 3, 1};//12
        System.out.println(findHouseRobber(input));
    }

    private static int findHouseRobber(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int prev = 0;
        int next = input[0];
        for (int i = 1; i < input.length; i++) {
            int temp = Math.max(input[i] + prev, next);
            prev = next;
            next = temp;
        }
        return next;
    }
}
