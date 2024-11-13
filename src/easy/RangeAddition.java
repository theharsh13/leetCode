package easy;

/*
* You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.

Count and return the number of maximum integers in the matrix after performing all the operations.
*
* Input: m = 3, n = 3, ops = [[2,2],[3,3]]
Output: 4
Explanation: The maximum integer in M is 2, and there are four of it in M. So return 4.
Example 2:

Input: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
Output: 4
Example 3:

Input: m = 3, n = 3, ops = []
Output: 9

 * */

import core.Solution;

public class RangeAddition implements Solution {

    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length == 0) return m*n;
        if(ops.length == 1) return ops[0][0]*ops[0][1];
        int minRow=ops[0][0];
        int minColumn=ops[0][1];
        for(int[] op: ops){
            if(op[0]<minRow)
                minRow=op[0];
            if(op[1]<minColumn)
                minColumn=op[1];
        }
        return minRow*minColumn;
    }

    @Override
    public void runTestCases() {
        System.out.println("maximum integers : " + this.maxCount(3,3, new int[][]{{2,2},{3,3}}));
        System.out.println("maximum integers : " + this.maxCount(3,3, new int[][]{{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3},{2,2},{3,3},{3,3},{3,3}}));
        System.out.println("maximum integers : " + this.maxCount(3,3, new int[][]{}));
    }
}
