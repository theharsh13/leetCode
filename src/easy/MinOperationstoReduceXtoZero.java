package easy;
/*
* You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.



Example 1:

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:

Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:

Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.*/

import core.Solution;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinOperationstoReduceXtoZero implements Solution {

    public int minOperations(int[] nums, int x) {
        if(nums[0] > x && nums[nums.length-1] > x) return -1;
        int result = 0;

        LinkedList<Integer> list = IntStream.of(nums).boxed().collect(Collectors.toCollection(LinkedList::new));
        System.out.println("Linkedlist: " + list.toString());
        while(!list.isEmpty() && x!=0){
            int firstEle = list.getFirst();
            int lastEle = list.getLast();
            System.out.println("first: " + firstEle + "last: " + lastEle);
            if(firstEle > x && lastEle > x) {
                result= -1;
                break;
            }
            if((firstEle >= lastEle  && firstEle <= x ) || firstEle == x) {
                   x-=firstEle;
                   list.removeFirst();
                   result++;
            }else {
                 if(lastEle <= x){
                     x-=lastEle;
                     list.removeLast();
                     result++;
                 }
            }
        }
        return x == 0 ? result: -1;

    }

    @Override
    public void runTestCases() {
//        System.out.println("minimum number of operations required: " + this.minOperations(new int[]{1,1,4,2,3}, 5));
//        System.out.println("minimum number of operations required: " + this.minOperations(new int[]{5,6,7,8,9}, 4));
//        System.out.println("minimum number of operations required: " + this.minOperations(new int[]{3,2,20,1,1,3}, 10));
       // System.out.println("minimum number of operations required: " + this.minOperations(new int[]{1,1}, 3));
        System.out.println("minimum number of operations required: " + this.minOperations(new int[]{6016,5483,541,4325,8149,3515,7865,2209,9623,9763,4052,6540,2123,2074,765,7520,4941,5290,5868,6150,6006,6077,2856,7826,9119}, 31841));

    }
}
