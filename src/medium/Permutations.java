package medium;

import core.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/permutations/description/
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]

Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

* */

public class Permutations implements Solution {


    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sol = new ArrayList<>();

        backtrack(result, sol, nums);


        return result;

    }

    private void backtrack(List<List<Integer>> result, List<Integer> sol, int[] nums) {
        if(sol.size() == nums.length) {
            result.add(new ArrayList<>(sol));
        }else {
            for (int num : nums) {
                if (sol.contains(num)) continue;
                sol.add(num);
                backtrack(result, sol, nums);
                sol.remove((Integer) num);
            }
        }


    }

    @Override
    public void runTestCases() {
        System.out.println("Result: "+ permute(new int[]{1,2,3}));
    }
}
