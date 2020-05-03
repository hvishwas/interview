package programming.dp;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * <p>
 * Example 1:
 * <p>
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 * <p>
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
class DecodeWays {
    public static void main(String[] args) {
//        String encoded = "226"; //3
        String encoded = "226226"; //9
//        String encoded = "0"; //0
//        String encoded = "2266022"; //0
//        String encoded = "10"; //1
//        String encoded = "17"; //2
        System.out.println(findDecodeWays(encoded.toCharArray()));
    }

    private static int findDecodeWays(char[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int[] dp = new int[input.length + 1];
        dp[0] = 1;
        dp[1] = input[0] == '0' ? 0 : 1;

        for (int i = 1; i < input.length; i++) {
            int current = Character.getNumericValue(input[i]);
            int prev = Character.getNumericValue(input[i - 1]);
            if (current > 0) {
                dp[i + 1] = dp[i];
            }
            if (prev == 1 || (prev == 2 && current < 7)) {
                dp[i + 1] += dp[i - 1];
            }
        }

        return dp[input.length];
    }
}
