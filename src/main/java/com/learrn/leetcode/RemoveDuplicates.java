package com.learrn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1.
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 * <p>
 * 2.
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] t = new int[]{1, 1, 1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 6, 7, 7};
        int i = removeDuplicates1(t);
        System.out.println(i);

        t = new int[]{0, 1, 1, 1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 7};
        i = removeDuplicates21(t);
        System.out.println(i);

        List<Integer> s = new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9));


    }

    public static int removeDuplicates1(int[] nums) {
        int p1 = 1, p2 = 0;
        while (p1 < nums.length) {
            if (nums[p1] != nums[p2]) {
                nums[++p2] = nums[p1];
            }
            p1++;
        }
        return p2 + 1;
    }

    public static int removeDuplicates21(int[] nums) {
        int p1 = 1, p2 = 0;
        while (p1 < nums.length) {
            if (nums[p1] != nums[p2]) {
                nums[++p2] = nums[p1];
            } else {
                if (p2 == 0) {
                    p2++;
                } else if (nums[p2] != nums[p2 - 1]) {
                    nums[++p2] = nums[p1];
                }
            }
            p1++;
        }
        return p2 + 1;
    }


    public static int removeDuplicates22(int[] s) {
        int p1 = s[1], p2 = s[0], temp = 1;
        int t = 0;
        while (t < s.length) {
            if (p1 == p2) {
                temp++;
            } else {
                temp = 1;
            }
            if (temp > 2) {
                //s[t] =
                //s.remove(t);
            }

            t++;
        }
        System.out.println(s);
        return s.length;
    }
}
