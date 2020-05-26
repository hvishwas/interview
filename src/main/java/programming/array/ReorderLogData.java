package programming.array;

import java.util.Arrays;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 * <p>
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * <p>
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 * <p>
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in
 * case of ties.  The digit-logs should be put in their original order.
 * <p>
 * Return the final order of the logs.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 */
public class ReorderLogData {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reorderLog(new String[] {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
    }

    private static String[] reorderLog(String[] input) {
        Arrays.sort(input, (a, b) -> {
            String[] a1 = a.split(" ", 2);
            String[] b1 = b.split(" ", 2);
            boolean isDigit1 = Character.isDigit(a1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(b1[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = a1[1].compareTo(b1[1]);
                if (cmp == 0) {
                    return a1[0].compareTo(b1[0]);
                }
                return cmp;
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return input;
    }
}
