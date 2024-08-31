package com.learrn.leetcode;

import java.util.Arrays;

/**
 15. 3Sum

 Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

 Notice that the solution set must not contain duplicate triplets.
 */
public class RunningSum {

    public static void main(String[] args) {
        Arrays.stream(runningSum(new int[]{1, 2, 3, 4})).forEach(e -> System.out.print(e + " "));
        System.out.println();
        Arrays.stream(runningSum(new int[]{1, 1, 1, 1, 1})).forEach(e -> System.out.print(e + " "));
        System.out.println();
        Arrays.stream(runningSum(new int[]{3, 1, 2, 10, 1})).forEach(e -> System.out.print(e + " "));
    }

    public static int[] runningSum(int[] nums) {
        int[] r = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                r[i] = nums[i];
            } else {
                r[i] = r[i - 1] + nums[i];
            }
        }
        return r;
    }
}
