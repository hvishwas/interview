package programming.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagrams {

    public static void main(String[] args) {
        System.out.println(findAnagrams("abcabc", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() == 0) {
            return result;
        }

        int[] temp = new int[26];

        for (int i = 0; i < p.length(); i++) {
            temp[p.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = 0;
        int count = p.length();

        while (j < s.length()) {
            if (temp[s.charAt(j++) - 'a']-- > 0) {
                count--;
            }
            if (count == 0) {
                result.add(i);
            }
            if (j - i == p.length() && temp[s.charAt(i++) - 'a']++ >= 0) {
                count++;
            }
        }
        return result;
    }
}
