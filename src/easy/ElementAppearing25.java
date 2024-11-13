package easy;
/*
Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.
Example 1:
Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6

Example 2:
Input: arr = [1,1]
Output: 1

 */

import core.Solution;

public class ElementAppearing25 implements Solution {
    public int findSpecialInteger(int[] arr) {
        int freq = arr.length/4;
        for(int i=0; i<arr.length;i++){
            if(i-freq>-1 && arr[i-freq] == arr[i]) {
                return arr[i];
            }
        }
        return -1;
    }

    @Override
    public void runTestCases() {
        System.out.println("result : " + findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
        System.out.println("result : " + findSpecialInteger(new int[]{1,1}));
    }
}
