package programming.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {

    public static void main(String... args) {
        System.out.println(groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    private static List<List<String>> groupAnagrams(String[] input) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            char[] temp = input[i].toCharArray();
            Arrays.sort(temp);
            map.computeIfAbsent(new String(temp), s -> new LinkedList<>()).add(input[i]);
        }
        return new LinkedList<>(map.values());
    }
}
