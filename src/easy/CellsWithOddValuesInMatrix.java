package easy;

/*
There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.
For each location indices[i], do both of the following:
Increment all the cells on row ri.
Increment all the cells on column ci.
Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.

Example 1:
Input: m = 2, n = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.

Example 2:
Input: m = 2, n = 2, indices = [[1,1],[0,0]]
Output: 0
Explanation: Final matrix = [[2,2],[2,2]]. There are no odd numbers in the final matrix.
* */

import core.Solution;

import java.util.Arrays;

public class CellsWithOddValuesInMatrix implements Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int result=0;
        int[][] matrix = new int[m][n];
        for(int[] row: matrix){
            Arrays.fill(row,0);
        }
        for(int[] e: indices){
            for(int i=0;i<n;i++){
                matrix[e[0]][i]++;
                if(matrix[e[0]][i]%2==0) {
                    result--;
                }else {
                    result++;
                }
            }
            for(int i=0;i<m;i++){
                matrix[i][e[1]]++;
                if(matrix[i][e[1]]%2==0) {
                    result--;
                }else {
                    result++;
                }
            }
        }
        System.out.println("matrix: "+ Arrays.deepToString(matrix));
        return result;
    }

    @Override
    public void runTestCases() {
        System.out.println("result : " + oddCells(2,3, new int[][]{{0,1},{1,1}}));
        System.out.println("result : " + oddCells(2,2, new int[][]{{1,1},{0,0}}));
    }
}
