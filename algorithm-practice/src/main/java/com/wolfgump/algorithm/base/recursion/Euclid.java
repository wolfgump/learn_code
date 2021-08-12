package com.wolfgump.algorithm.base.recursion;

/**
 * @author ShiTao.Gan
 * The greatest common divisor (gcd) of two positive integers is the largest integer that divides evenly into both of them. For example, the gcd(102, 68) = 34.
 * We can efficiently compute the gcd using the following property, which holds for positive integers p and q:
 * <p>
 * If p > q, the gcd of p and q is the same as the gcd of q and p % q.
 **/
public class Euclid {
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
    }

    public static void main(String[] args) {
        int result = gcd(102, 67);
        System.out.println(result);
    }
}
