package programming.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(findLongestPalindrome("babad"));
    }

    public static String findLongestPalindrome(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(findTheLargestPalFromCenter(i, s));
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).length() > max) {
                max = result.get(i).length();
                index = i;
            }
        }
        return result.get(index);
    }

    private static String findTheLargestPalFromCenter(int i, String s) {
        if (i == 0) {
            return s.substring(i, i);
        }

        int j = i + 1;
        while (--i > 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {

            } else {
                return s.substring(i, j);
            }
            ++j;
        }
        return s.substring(i, j);
    }
}
