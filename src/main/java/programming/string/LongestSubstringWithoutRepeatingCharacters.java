package programming.string;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    private static int lengthOfLongestSubstring(String s) {
        int[] temp = new int[128];
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < s.length()) {
            j = Math.max(temp[s.charAt(i)], j);
            ans = Math.max(ans, i - j + 1);
            temp[s.charAt(i)] = i + 1;
            i++;
        }
        return ans;
    }
}
