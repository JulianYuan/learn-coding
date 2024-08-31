package com.learrn.leetcode;

import cn.hutool.core.date.StopWatch;

import java.util.Arrays;

/**
 * 示例：斐波那契数列，又称黄金分割数列，其数值为：1、1、2、3、5、8、13、21、34，递推公式为：
 * F ( 0 ) = 1 , F ( 1 ) = 1 , F ( n ) = F ( n − 1 ) + F ( n − 2 ) , n > 2 , n ∈ N ∗ F(0)=1,F(1)=1, F(n)=F(n-1)+F(n-2),n>2,n∈N^{*}
 * F(0)=1,F(1)=1,F(n)=F(n−1)+F(n−2),n>2,n∈N
 */
public class Fibonacci {

    public static void main(String[] args) {
        int n = 20;
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println(fib(n));
        watch.stop();
        // 声明数组，用于记录历史，初始化为-1
        int[] his = new int[n + 1];
        Arrays.fill(his, -1);
        watch.start();
        System.out.println(fib(n, his));
        watch.stop();

        watch.start();
        System.out.println(fib2(n));
        watch.stop();
        watch.start();
        System.out.println(fib3(n));
        watch.stop();
        System.out.println(watch.prettyPrint());
    }

    public static int fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fib(int n, int[] his) {
        if (n < 2) {
            return 1;
        }

        // 读取历史
        if (his[n] != -1) {
            return his[n];
        }
        int result = fib(n - 1, his) + fib(n - 2, his);
        // 记录历史
        his[n] = result;
        return result;
    }
    public static int fib2(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        return arr[n];
    }
    public static int fib3(int n) {
        int num_i = 0;
        int num_i_1 = 1;
        int num_i_2 = 1;
        for (int i = 2; i <= n; i++) {
            num_i = num_i_2 + num_i_1;
            num_i_2 = num_i_1;
            num_i_1 = num_i;
        }
        return num_i;
    }

}
