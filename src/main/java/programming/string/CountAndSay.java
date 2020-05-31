package programming.string;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the
 * digits, counting the number of digits in groups of the same digit.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(findCountAndSay(4));
    }

    private static String findCountAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 0; j < result.length(); j++) {
                while (j + 1 < result.length() && result.charAt(j) == result.charAt(j + 1)) {
                    count++;
                    j++;
                }
                sb.append(count).append(result.charAt(j));
            }
            result = sb.toString();
        }
        return result;
    }
}
