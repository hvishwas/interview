package programming.string;

/**
 * Given two strings, write a function to determine whether they are anagrams.
 * <p>
 * eg.
 * <p>
 * isAnagram("", "") = true
 * isAnagram("A", "A") = true
 * isAnagram("A", "B") = false
 * isAnagram("ab", "ba") = true
 * isAnagram("AB", "ab") = true
 */
class Anagram {
    public static void main(String[] args) {
        String s1 = "b%fff1Aa#";
        String s2 = "1f#%aBaff";

        System.out.println(isAnagram(s1, s2));
    }

    private static boolean isAnagram(String a1, String a2) {

        if (a1 == null || a2 == null || a1.length() != a2.length()) {
            return false;
        }
        long result = 0;
        for (int j = 0; j < a1.length(); j++) {
            char c1 = a1.charAt(j);
            char c2 = a2.charAt(j);
            result = updateResult(c1, result);
            result = updateResult(c2, result);
        }
        return result == 0;
    }

    private static long updateResult(char c, long result) {
        if (c >= 65 && c <= 90) {
            return result ^= 1 << (97 - c + 32);
        } else {
            return result ^= 1 << 97 - c;
        }
    }
}
