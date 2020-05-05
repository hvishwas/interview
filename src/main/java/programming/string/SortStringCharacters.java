package programming.string;

/**
 * Given a string of lowercase characters from ‘a’ – ‘z’. We need to write a program to print the characters of this string in sorted order.
 * <p>
 * Examples:
 * <p>
 * Input : bbccdefbbaa
 * Output : aabbbbccdef
 * <p>
 * Input : geeksforgeeks
 * Output : eeeefggkkorss
 */
class SortStringCharacters {
    public static void main(String[] args) {
        String input = "zadbfad";//aabddfz
        int[] temp = new int[26];
        for (int i = 0; i < input.length(); i++) {
            temp[input.charAt(i) - 'a']++;
        }
        for (int i = 0; i < temp.length; i++) {
            while (temp[i]-- != 0) {
                System.out.print((char) ('a' + i));
            }
        }
    }
}