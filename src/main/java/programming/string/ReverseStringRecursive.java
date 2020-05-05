package programming.string;

class ReverseStringRecursive {
    public static void main(String[] args) {
        String s = "tutorial horizon";
        System.out.println(reverse(s));
    }

    public static String reverse(String s) {
        if (s.length() == 1) {
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }
}