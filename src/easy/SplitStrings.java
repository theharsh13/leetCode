package easy;

import core.Solution;

/*
https://leetcode.com/problems/split-a-string-in-balanced-strings/description/

Balanced strings are those that have an equal quantity of 'L' and 'R' characters.

Given a balanced string s, split it into some number of substrings such that:

Each substring is balanced.
Return the maximum number of balanced strings you can obtain.

Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.

Example 2:

Input: s = "RLRRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", each substring contains same number of 'L' and 'R'.
Note that s cannot be split into "RL", "RR", "RL", "LR", "LL", because the 2nd and 5th substrings are not balanced.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".


Constraints:

2 <= s.length <= 1000
s[i] is either 'L' or 'R'.
s is a balanced string.

* */


public class SplitStrings implements Solution {

    public int balancedStringSplit(String s) {

        char[] chars = s.toCharArray();
        int countL =0;
        int countR =0;
        int result=0;
        for (char aChar : chars) {
            if (aChar == 'R') {
                countR++;
                if ((countR != 0 && countL != 0) && countL == countR) {
                    result++;
                    countR = countL = 0;
                }

            } else {
                countL++;
                if ((countR != 0 && countL != 0) && countL == countR) {
                    result++;
                    countR = countL = 0;
                }
            }
        }
        return result;
    }

    @Override
    public void runTestCases() {
        System.out.println("Result : " + balancedStringSplit("RLRRLLRLRL"));
        System.out.println("Result : " + balancedStringSplit("RLRRRLLRLL"));
        System.out.println("Result : " + balancedStringSplit("LLLLRRRR"));
    }
}
