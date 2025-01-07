package leetCode75;

import core.Solution;

import java.util.Arrays;
import java.util.Stack;

/*
*
* https://leetcode.com/problems/asteroid-collision
* 735. Asteroid Collision
Medium
We are given an array asteroids of integers representing asteroids in a row. The indices of the asteroid in the array represent their relative position in space.
For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
*
Example 2:
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
*
Example 3:
Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

Constraints:
2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
* */

public class AsteroidCollision implements Solution {

    public int[] asteroidCollision(int[] asteroids) {

        /*
        * collision will only occur when first(stack top) is +ve and second is -ve (current ele)
        * conditions - smaller one get destroyed, same value - both destroyed
        * */
        Stack<Integer> at = new Stack<>();
        for(int i=0;i<asteroids.length;i++) {
            while(!at.isEmpty() && at.peek() > 0 && asteroids[i] < 0){
                int sum = at.peek()+asteroids[i];
                if (sum>0) {
                    asteroids[i]=0;
                    break;
                } else if (sum < 0) {
                    at.pop();
                } else {
                    at.pop();
                    asteroids[i]=0;
                }
            }
            if(asteroids[i]!=0) at.push(asteroids[i]);
        }
        int[] result = new int[at.size()];
        int i=at.size()-1;
        while(!at.isEmpty()) result[i--] = at.pop();

        return result;
    }

    @Override
    public void runTestCases() {
        System.out.println("Result: " + Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
        System.out.println("Result: " + Arrays.toString(asteroidCollision(new int[]{8,-8})));
        System.out.println("Result: " + Arrays.toString(asteroidCollision(new int[]{10,2,-5})));
        System.out.println("Result: " + Arrays.toString(asteroidCollision(new int[]{10,2,7,-5,-9}))); //10
        System.out.println("Result: " + Arrays.toString(asteroidCollision(new int[]{-4,3,2,-2,1}))); //10
    }
}
