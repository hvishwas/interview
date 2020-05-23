package programming.string;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * <p>
 * Note that after backspacing an empty text, the text will continue empty.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 * <p>
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 * <p>
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 * <p>
 * Input: S = "xywrrmp", T = "xywrrmu#p"
 * Output: false
 * Note:
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 * <p>
 * Can you solve it in O(N) time and O(1) space?
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("nzp#o#g", "b#nzp#o#g"));
    }

    private static boolean backspaceCompare(String s1, String s2) {
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int s1H = 0;
        int s2H = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s1.charAt(i) == '#') {
                    s1H++;
                } else if (s1H > 0) {
                    s1H--;
                } else {
                    break;
                }
                i--;
            }
            while (j >= 0) {
                if (s2.charAt(j) == '#') {
                    s2H++;
                } else if (s2H > 0) {
                    s2H--;
                } else {
                    break;
                }
                j--;
            }
            if (i >= 0 && j >= 0 && s1.charAt(i) != s2.charAt(j)) {
                return false;
            }
            if ((i >= 0 && j < 0) || (i < 0 && j >= 0)) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
