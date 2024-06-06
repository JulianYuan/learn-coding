package com.learrn.leetcode;

/*
2938. 区分黑球与白球
桌子上有 n 个球，每个球的颜色不是黑色，就是白色。
给你一个长度为 n 、下标从 0 开始的二进制字符串 s，其中 1 和 0 分别代表黑色和白色的球。
在每一步中，你可以选择两个相邻的球并交换它们。
返回「将所有黑色球都移到右侧，所有白色球都移到左侧所需的 最小步数」。
 */
public class MinStep {

    public static void main(String[] args) {
        String s = "10010101";
        long ans = new MinStep().minimumSteps(s);
        System.out.println(ans);
    }

    public long minimumSteps(String s) {
        char[] chars = s.toCharArray();
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                sum++;
            } else {
                ans += sum;
            }
        }
        return ans;
    }
}
