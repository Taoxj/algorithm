package com.xjt.algorithm;

/**
 * [剑指offer] 面试题10：斐波那契数列
 */
public class Solution10 {

    /**
     * 解题思路
     * 公式:
     * f(n) = n, n <= 1
     * f(n) = f(n-1) + f(n-2), n > 1
     */
    public int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int fn1 = 0;
        int fn2 = 1;
        for (int i = 2; i <= n; i++) {
            fn2 += fn1;
            fn1 = fn2 - fn1;
        }
        return fn2;
    }
}
