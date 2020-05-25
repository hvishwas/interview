package programming.math;

/**
 * Given two integers x and n, write a function to compute xn. We may assume that x and n are small and overflow doesn’t happen.
 * <p>
 * Input : x = 2, n = 3
 * Output : 8
 * <p>
 * Input : x = 7, n = 2
 * Output : 49
 */
public class Pow {
    public static void main(String[] args) {
        System.out.println(pow(2, 3));
    }

    public static double pow(double x, int exp) {
        if (exp > 0) {
            return power(x, exp);
        } else {
            return 1 / power(x, exp);
        }
    }

    private static double power(double base, int exp) {
        if (exp == 0) {
            return 1;
        }
        double half = power(base, exp / 2);
        if ((exp & 1) == 0) {
            return half * half;
        } else {
            return half * half * base;
        }
    }
}
