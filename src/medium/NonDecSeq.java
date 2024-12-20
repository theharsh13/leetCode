package medium;

import core.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/non-decreasing-subsequences/description/
Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.

Example 1:
Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]

Example 2:
Input: nums = [4,4,3,2,1]
Output: [[4,4]]

Constraints:
1 <= nums.length <= 15
-100 <= nums[i] <= 100

* */

public class NonDecSeq implements Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();
        List<Integer> sol = new ArrayList<>();

        backtrack(0, nums, sol, result );

        return new ArrayList<>(result);

    }

    private void backtrack(int i, int[] nums, List<Integer> sol, Set<List<Integer>> result) {

       // 1. length end 2. pair two or more 3. not repeated
        if(sol.size()>=2 ){
            result.add(new ArrayList<>(sol));
        }

        Set<Integer> visited = new HashSet<>();

        for(int idx=i;idx< nums.length;idx++){

            if((sol.isEmpty() || nums[idx] >= sol.get(sol.size()-1)) && !visited.contains(nums[idx])) {
                sol.add(nums[idx]);
                backtrack(idx+1, nums,sol,result);
                sol.remove((Integer) nums[idx]);
                visited.add(nums[idx]);
            }
        }
    }

    @Override
    public void runTestCases() {
        System.out.println("Result : " + findSubsequences(new int[]{4,6,7,7}));
        System.out.println("Result : " + findSubsequences(new int[]{4,4,3,2,1}));
    }
}
