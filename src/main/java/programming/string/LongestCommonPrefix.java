package programming.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(findLongestCommonPrefix(new String[] {"flower", "fl", "flowht"}));
    }

    private static String findLongestCommonPrefix(String[] input) {
        if (input == null || input.length == 0) {
            return "";
        }
//        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input[0].length(); i++) {
            char s = input[0].charAt(i);
            for (int j = 1; j < input.length; j++) {
                if (input[j] == null || i >= input[j].length() || input[j].charAt(i) != s) {
//                    return result.toString();
                    return input[0].substring(0, i);
                }
            }
//            result.append(s);
        }
        return input[0];
    }
}
