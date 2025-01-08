package leetCode75;

import core.Solution;

import java.util.Objects;
import java.util.Stack;

/*
*
* https://leetcode.com/problems/decode-string
* 394. Decode String
Medium
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.


Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"
*
Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"
*
Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

Constraints:
1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
* */

public class DecodeString implements Solution {


    public String decodeString(String s) {

        /*
        *
        * 1. start loop 1st to last char
        * 2. add it in stack
        * 3. if char is ]
        *   1. start popping till you find [
        *   2. pop till you extract digit before [
        *   3. add string number(extracted from stack) times in stack and continue
        * */

        Stack<Character> stack = new Stack<>();

        for(Character c : s.toCharArray()) {

            if(c == ']') {
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '[') {
                    sb.insert(0,stack.pop());
                }
                stack.pop();

                StringBuilder no = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    no.insert(0,stack.pop());
                }

                int n = Integer.parseInt(no.toString());
                String repeat = sb.toString().repeat(n);

                for(int i=0;i<repeat.length();i++) {
                    stack.push(repeat.charAt(i));
                }
            }else
                stack.push(c);

        }

        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }

        return res.toString();
    }

    @Override
    public void runTestCases() {
        System.out.println("Result: " + decodeString("3[a]2[bc]"));
        System.out.println("Result: " + decodeString("3[a2[c]]"));
        System.out.println("Result: " + decodeString("2[abc]3[cd]ef"));
    }
}
