package programming.array;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 * <p>
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 * <p>
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Example 4:
 * <p>
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 */
public class IntegerToEnglishWords {

    public static void main(String[] args) {
        System.out.println(numberToWords(10000));
    }

    private static String[] lessThanTwenty = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static String[] tenMultiples = new String[] {"", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static String[] thousandMultiples = new String[] {"", "thousand", "million", "billion"};

    private static String numberToWords(int input) {
        if (input == 0) {
            return "zero";
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (input > 0) {
            if (input % 1000 != 0) {
                StringBuilder temp = new StringBuilder();
                helper(temp, input % 1000);
                sb.insert(0, temp.append(thousandMultiples[index]).append(" "));
            }
            index++;
            input /= 1000;
        }
        return sb.toString();
    }

    private static void helper(StringBuilder temp, int input) {
        if (input == 0) {
            return;
        } else if (input < 20) {
            temp.append(lessThanTwenty[input]).append(" ");
            return;
        } else if (input < 100) {
            temp.append(tenMultiples[input / 10]).append(" ");
            helper(temp, input % 10);
        } else {
            temp.append(lessThanTwenty[input / 100]).append(" hundred ");
            helper(temp, input % 100);
        }
    }

}
