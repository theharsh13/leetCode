package easy;

import core.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/find-the-difference-of-two-arrays/description/

Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.

Example 1:
Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].

Example 2:
Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
Output: [[3],[]]
Explanation:
For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
* */

public class DiffOfTwoArrays implements Solution {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> fu = new HashSet<>();
        Set<Integer> su = new HashSet<>();
        List<Integer> f = new ArrayList<>();
        List<Integer> s = new ArrayList<>();

        for(int k: nums1) fu.add(k);
        for(int k: nums2) su.add(k);

        for(int k: fu) {
            if(!su.contains(k)) f.add(k);
        }

        for(int k: su) {
            if(!fu.contains(k)) s.add(k);
        }

        return List.of(f,s);
    }

    @Override
    public void runTestCases() {
        System.out.println("result : " + findDifference(new int[]{1,2,3}, new int[]{2,4,6}));
        System.out.println("result : " + findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
    }
}
