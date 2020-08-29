package hw;

import java.util.AbstractSet;

public class Homework1 {

    // 1.
    public static int xpentagonal(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += 3 * i - 2;
        }
        return result;
    }

    public static int pentagonal(int cnt) {
        return pentagonalHelper(0, cnt);
    }

    private static int pentagonalHelper(int val, int cnt) {
        val += 3 * cnt - 2;
        cnt -= 1;
        if (cnt > 0) val = pentagonalHelper(val, cnt);
        return val;
    }

    // 3.
    public static double evaluate(double[] coefficients, double x) {
        double result = coefficients[0];
        double power = 1;
        for (int i = 1; i < coefficients.length; i++) {
            power = power * x;
            result = result + coefficients[i] * power;
        }
        return result;
    }

    // 4.

    public static void main(String[] args) {
//        System.out.println(pentagonal(5));
//        System.out.println(xpentagonal(5));

    }

//    AbstractSet
}