package programming.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the
 * process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy
 * numbers.
 * <p>
 * Return True if n is a happy number, and False if not.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {
    public static void main(String... args) {
        System.out.println(isHappyNumber(19));
    }

    private static boolean isHappyNumber(int input) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(input)) {
            set.add(input);
            if (input == 1) {
                return true;
            }
            int sum = 0;
            while (input != 0) {
                sum += (input % 10) * (input % 10);
                input = input / 10;
            }
            input = sum;
        }
        return false;
    }
}
