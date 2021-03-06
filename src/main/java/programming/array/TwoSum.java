package programming.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTwoSum(new int[] {2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(findTwoSum(new int[] {2, 6, 6, 3, 10, 11}, 9)));
    }

    private static int[] findTwoSum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            } else {
                map.put(k - nums[i], i);
            }
        }
        return new int[0];
    }
}
