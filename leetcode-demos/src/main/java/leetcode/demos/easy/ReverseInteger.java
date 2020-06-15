package leetcode.demos.easy;

/**
 * Author : Daniel Pei / Peixq
 * Email : peixq1222@icloud.com
 * Create : 2020/2/20 23:20
 */
public class ReverseInteger {
//    public int solution(int x) {
//        if (x == 0) {
//            return x;
//        }
//
//        StringBuilder result = new StringBuilder();
//
//        int sign = x / Math.abs(x);
//        x = Math.abs(x);
//
//        while (x > 0) {
//            result.append(x % 10);
//            x = x / 10;
//        }
//        try {
//            return Integer.parseInt(result.toString()) * sign;
//        } catch (NumberFormatException e) {
//            return 0;
//        } finally {
//            return 0;
//        }
//    }

    public int optimize(int x) {
        int ret = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;

            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            } else if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            ret = ret * 10 + pop;

        }
        return ret;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.optimize(0));
        System.out.println(ri.optimize(1534236469));

        System.out.println(ri.optimize(-2147483648));
        System.out.println(ri.optimize(-235));

        System.out.println(Integer.toString(ri.optimize(-235)));
    }
}
