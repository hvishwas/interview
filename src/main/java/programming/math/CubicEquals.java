package programming.math;

class CubicEquals {
    private static int cnt;
    public static void main(String[] args) {
        find (100);
        System.out.println(cnt);
    }
    public static void findMatchingNumbers(int n) {
        for (int a = 1; a < n ; a++) {
            for (int b = 1; b < n; b++) {
                if(a == b) {
                    continue;
                }
                for (int c = 1; c < n; c++) {
                    if(a ==c || c == b) {
                        continue;
                    }
                    int d = (int) Math.cbrt(a*a*a + b*b*b - c*c*c);
                    if(d == a || d==b || d == c || d <= 0) {
                        continue;
                    }
                    if((a*a*a + b*b*b) == c*c*c + d*d*d) {
                        System.out.println("a="+ a + ", b=" + b + ", c=" + c + ", d=" + d);
                        cnt++;
                    }
                }
            }
        }
    }

    public static void find(int n) {
        for(int a = 1; a < n/2; a ++) {
            for (int b = n/2; b <= n; b++) {
                for(int c = 1; c < n/2; c ++) {
                    if(a ==c || c == b) {
                        continue;
                    }
                    for (int d = n/2; d <= n; d++) {
                        if(a ==d || d == b) {
                            continue;
                        }
                        if((a*a*a + b*b*b) == c*c*c + d*d*d) {
                            System.out.println("a="+ a + ", b=" + b + ", c=" + c + ", d=" + d);
                            cnt++;
                        }
                    }
                }
            }
        }
    }
}