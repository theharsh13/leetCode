package leetCode75;

import core.Solution;

import java.util.Arrays;

/*283.
* https://leetcode.com/problems/move-zeroes
* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
*
Example 2:
Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
* */

public class MoveZeros implements Solution {

    public void moveZeroes(int[] nums) {
        int zero=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i] != 0) {
                int a= nums[i];
                nums[i] = nums [zero];
                nums[zero] = a;
                zero++;
            }
        }
        System.out.println("array: "+ Arrays.toString(nums));

    }

    @Override
    public void runTestCases() {
        moveZeroes(new int[]{0,1,0,3,12});
        moveZeroes(new int[]{0});
    }
}
