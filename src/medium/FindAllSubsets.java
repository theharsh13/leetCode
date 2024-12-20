package medium;

import core.Solution;

import java.util.ArrayList;
import java.util.List;


/*
https://leetcode.com/problems/subsets/description/

Given an integer array nums of unique elements, return all possible subsets(the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
* */

public class FindAllSubsets implements Solution {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(0, temp, result,  nums);
        return result;
    }

    private void backtrack(int i, List<Integer> temp, List<List<Integer>> result, int[] nums) {
        if(i == nums.length) { //base case
            result.add(new ArrayList<>(temp));
            return;
        }
        backtrack(i+1, temp, result, nums); // Not pick case
        temp.add(nums[i]);
        backtrack(i+1, temp, result, nums);  // pick case
        temp.remove((Integer) nums[i]); // backtrack - undo choice
    }

    @Override
    public void runTestCases() {

        System.out.println("Result: " + subsets(new int[]{1,2,3}));
        System.out.println("Result: " + subsets(new int[]{0}));

    }
}
