package programming.string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 * <p>
 * If possible, output any possible result.  If not possible, return the empty string.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "aab"
 * Output: "aba"
 * Example 2:
 * <p>
 * Input: S = "aaab"
 * Output: ""
 * Note:
 * <p>
 * S will consist of lowercase letters and have length in range [1, 500].
 */
class ReorganizeString {
    public static void main(String[] args) {
        String input = "aaaaaabbbbcccdde";
//        String input = "aab";
        System.out.println(reorganizeString(input));
    }

    public static String reorganizeString(String input) {
        if (input.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Queue<Character> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        queue.addAll(map.keySet());

        StringBuilder result = new StringBuilder();
        while (queue.size() > 1) {
            char c1 = queue.remove();
            char c2 = queue.remove();
            int count1 = map.get(c1);
            int count2 = map.get(c2);
            map.put(c1, --count1);
            map.put(c2, --count2);
            result.append(c1).append(c2);
            if (count1 > 0) {
                queue.add(c1);
            }
            if (count2 > 0) {
                queue.add(c2);
            }
        }

        if (queue.size() == 1) {
            char c = queue.remove();
            if (map.get(c) > 1) {
                return "";
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}