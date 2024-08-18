package com.learrn.leetcode;

/**
 * 26. Remove Duplicates from Sorted Array
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 *
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 */
public class RemoveDuplicate {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int fast = 0;
            int slow = 0;

            while(++fast < nums.length){
                if(nums[fast] != nums[slow]){
                    slow++;
                    nums[slow] = nums[fast];
                }
            }
            return slow+1;
        }
    }

    public static void main(String[] args) {
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        int[] nums = {1, 2, 3};
        System.out.println(removeDuplicate.new Solution().removeDuplicates(nums));

        nums = new int[]{1, 1, 2, 3, 3, 4, 4, 4, 5};
        System.out.println(removeDuplicate.new Solution().removeDuplicates(nums));

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicate.new Solution().removeDuplicates(nums));
    }
}
