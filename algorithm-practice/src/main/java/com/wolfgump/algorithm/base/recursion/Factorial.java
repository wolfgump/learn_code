package com.wolfgump.algorithm.base.recursion;

/**
 * @author ShiTao.Gan
 * n!=n×(n−1)×(n−2)×…×2×1
 * n!=n*(n-1)!
 **/
public class Factorial {
    public static long factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        long n = factorial(3);
        System.out.println(n);
    }
}
