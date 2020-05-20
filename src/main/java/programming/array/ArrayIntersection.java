package programming.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 * <p>
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class ArrayIntersection {
    public static void main(String[] args) {
        System.out.println("Find Array Intersection:" + findArrayIntersection(new int[] {4, 9, 5}, new int[] {9, 4, 9, 8, 4}));
    }

    private static List<Integer> findArrayIntersection(int[] a1, int[] a2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a1.length; i++) {
            set.add(a1[i]);
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < a2.length; i++) {
            if (set.contains(a2[i])) {
                result.add(a2[i]);
                set.remove(a2[i]);
            }
        }
        return result;
    }
}
