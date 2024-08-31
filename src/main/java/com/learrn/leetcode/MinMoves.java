package com.learrn.leetcode;

/**
 * 453. Minimum Moves to Equal Array Elements
 * Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
 * <p>
 * In one move, you can increment n - 1 elements of the array by 1.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: 3
 * Explanation: Only three moves are needed (remember each move increments two elements):
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * Example 2:
 * <p>
 * Input: nums = [1,1,1]
 * Output: 0
 */
public class MinMoves {
    class Solution {
        public int minMoves(int[] nums) {
            if (nums.length == 1)
                return 0;

            int max = nums[0];
            int sum = 0;
            for (int i = 1; i < nums.length; i++) {
                if (max < nums[i]) {
                    sum += (nums[i] - max) * i;
                    max = nums[i];
                } else {
                    sum += max - nums[i];
                }
            }

            while (sum % (nums.length-1) != 0) {
                sum += nums.length - 1;
            }

            return sum / (nums.length - 1);
        }
    }

    public static void main(String[] args) {
        MinMoves minMoves = new MinMoves();
        //System.out.println(minMoves.new Solution().minMoves(new int[]{1}));
        System.out.println(minMoves.new Solution().minMoves(new int[]{1, 2, 3}));
        System.out.println(minMoves.new Solution().minMoves(new int[]{1, 1, 1}));
        System.out.println(minMoves.new Solution().minMoves(new int[]{1, 4, 2, 2}));
        System.out.println(minMoves.new Solution().minMoves(new int[]{1, 2, 7, 4, 5, 2}));
        System.out.println(minMoves.new Solution().minMoves(new int[]{1, 4, 2, 4, 1}));
    }
}
