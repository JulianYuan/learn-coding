package com.learrn.leetcode;

/**
 * 80. Remove Duplicates from Sorted Array II
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicate2 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums.length < 3) return nums.length;

            int fast = 0;
            int slow = 0;
            int count = 0;

            while (++fast < nums.length) {
                if (nums[fast] == nums[slow]) {
                    if (count < 1) {
                        slow++;
                        count++;
                        nums[slow] = nums[fast];
                    }
                } else {
                    count = 0;
                    slow++;
                    nums[slow] = nums[fast];
                }
            }
            return slow + 1;
        }

    }

    public static void main(String[] args) {
        RemoveDuplicate2 removeDuplicate = new RemoveDuplicate2();
        int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicate.new Solution().removeDuplicates(nums));

        nums = new int[]{1,2,2};
        System.out.println(removeDuplicate.new Solution().removeDuplicates(nums));

        nums = new int[]{1, 1, 2, 3, 3, 4, 4, 4, 5};
        System.out.println(removeDuplicate.new Solution().removeDuplicates(nums));

        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicate.new Solution().removeDuplicates(nums));
    }
}