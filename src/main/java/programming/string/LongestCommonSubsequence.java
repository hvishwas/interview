package programming.string;

import java.util.Arrays;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining
 * characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 * <p>
 * <p>
 * If there is no common subsequence, return 0.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 * <p>
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 * <p>
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 */
class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "adsfejkyt";
        String s2 = "adsfjsfejkt";
        System.out.println(Arrays.toString(findLongestCommonSubsequence(s1, s2)));
    }

    private static char[] findLongestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int max = 0, maxi = 0, maxj = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    maxi = i;
                    maxj = j;
                }
            }
        }

        char[] result = new char[max];
        int z = max - 1;
        while (dp[maxi][maxj] != 0) {
            if (dp[maxi - 1][maxj] == dp[maxi][maxj]) {
                maxi--;
            } else if (dp[maxi][maxj - 1] == dp[maxi][maxj]) {
                maxj--;
            } else {
                maxi--;
                maxj--;
                result[z--] = s1.charAt(maxi);
            }
        }
        return result;
    }
}
