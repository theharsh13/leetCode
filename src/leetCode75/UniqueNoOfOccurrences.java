package leetCode75;

import core.Solution;

import java.util.*;

/*
*
* 1207. https://leetcode.com/problems/unique-number-of-occurrences
* Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
*
Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
*
Example 2:
Input: arr = [1,2]
Output: false
*
Example 3:
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true

Constraints:
1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000
* */

public class UniqueNoOfOccurrences implements Solution {

    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer,Integer> occ = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            if(occ.containsKey(arr[i])) occ.put(arr[i], occ.get(arr[i]) + 1);
            else occ.put(arr[i], 1);
        }
        Set<Integer> map1 = new HashSet<>();
        for (int i:occ.values()){
            if (!map1.add(i)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void runTestCases() {
        System.out.println("Result: " + uniqueOccurrences(new int[]{1,2,2,1,1,3}) );
        System.out.println("Result: " + uniqueOccurrences(new int[]{1,2}) );
        System.out.println("Result: " + uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}) );
    }
}
