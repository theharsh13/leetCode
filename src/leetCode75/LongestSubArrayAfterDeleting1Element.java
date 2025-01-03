package leetCode75;

import core.Solution;

/*
*1493 https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element
* Given a binary array nums, you should delete one element from it.
Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

Example 1:
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
*
Example 2:
Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
*
Example 3:
Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.

Constraints:
1 <= nums.length <= 105
nums[i] is either 0 or 1.*/

public class LongestSubArrayAfterDeleting1Element implements Solution {

    public int longestSubarray(int[] nums) {

        int left=0,right=0,max=0,zeros=0;

        while(right<nums.length) {

            if(nums[right] == 0)
                zeros++;

            if(zeros>1) {
                if(nums[left] == 0) zeros--;
                left++;
            }
            if(zeros<=1) {
                max =Math.max(max,right-left+1);
            }
            right++;
        }


        return max-1;
    }

    @Override
    public void runTestCases() {
        System.out.println("Result: " + longestSubarray(new int[]{1,1,0,1}));
        System.out.println("Result: " + longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println("Result: " + longestSubarray(new int[]{1,1,1}));
    }
}
