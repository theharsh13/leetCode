package leetCode75;

import core.Solution;

import java.util.Arrays;
import java.util.List;


/*
* https://leetcode.com/problems/equal-row-and-column-pairs
* 2352. Equal Row and Column Pairs

Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).


Example 1:
Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
*
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]
*
Example 2:
Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]
*
* Constraints:

n == grid.length == grid[i].length
1 <= n <= 200
1 <= grid[i][j] <= 10^5
* */

public class EqualRowsAndColumnPairs implements Solution {

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int[][] transposed = new int[n][n];
        int result=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                transposed[i][j] = grid[j][i];
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(Arrays.equals(grid[i],transposed[j])) result++;
            }
        }
        return result;
    }



    @Override
    public void runTestCases() {
        System.out.println("Result: " + equalPairs(new int[][]{{3,2,1}, {1,7,6},{2,7,7}}));
        System.out.println("Result: " + equalPairs(new int[][]{{3,1,2,2}, {1,4,4,5},{2,4,2,2},{2,4,2,2}}));
    }
}
