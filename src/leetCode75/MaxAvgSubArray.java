package leetCode75;

import core.Solution;

/*
* 643. https://leetcode.com/problems/maximum-average-subarray-i

You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous sub array whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

Example 1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

Example 2:
Input: nums = [5], k = 1
Output: 5.00000

Constraints:
n == nums.length
1 <= k <= n <= 105
-104 <= nums[i] <= 104
* */

public class MaxAvgSubArray implements Solution {

    public double findMaxAverage(int[] nums, int k) {
        double avg = 0d;
        for(int i=0;i<k;i++) {
            avg+=nums[i];
        }
        double max = avg;
        for(int i=k;i<nums.length;i++) {
            avg+=nums[i];
            avg-=nums[i-k];
            max = Math.max(avg, max);
        }
        return max/k;
    }

    @Override
    public void runTestCases() {
        System.out.println("Result: "+ findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        System.out.println("Result: "+ findMaxAverage(new int[]{5}, 1));
    }
}
