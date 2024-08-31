package com.learrn.leetcode;

/**
 * 7. Reverse Integer
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class IntReverse {

    public static void main(String[] args) {
        int t = 123;
        System.out.println(reverse(t));
    }

    public static int reverse(int x) {
        int s = 0;

        while (x != 0) {
            if (s < Integer.MIN_VALUE / 10 || s > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int t = x % 10;
            x /= 10;
            s = s*10 + t;
        }
        return s;
    }
}
