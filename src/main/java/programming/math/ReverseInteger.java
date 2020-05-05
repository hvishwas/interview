package programming.math;

class ReverseInteger {
    public static void main(String[] args) {
        int value = -12301;
        int r = 0;
        int d = 0;
        int result = 0;
        while (value != 0) {
            r = value % 10;
            result = result * 10 + r;
            value = value / 10;
        }
        System.out.println(result);
    }
}