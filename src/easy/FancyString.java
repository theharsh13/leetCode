package easy;
/*
*
* A fancy string is a string where no three consecutive characters are equal.
Given a string s, delete the minimum possible number of characters from s to make it fancy.
Return the final string after the deletion. It can be shown that the answer will always be unique.

Example 1:

Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".
Example 2:

Input: s = "aaabaaaa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".
Example 3:

Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".
*
* */

import core.Solution;

public class FancyString implements Solution {

    public String makeFancyString(String s) {
        int i=0;
        StringBuilder sb = new StringBuilder(s);
        while(i < sb.length()-2){
            if((sb.charAt(i) == sb.charAt(i + 1)) &&  (sb.charAt(i+1) == sb.charAt(i+2))) {
                sb.deleteCharAt(i);
            }else
                i++;
        }
        return sb.toString();
    }

    @Override
    public void runTestCases() {
        System.out.println("unique string: " + this.makeFancyString("leeetcode"));
        System.out.println("unique string: " + this.makeFancyString("aaabaaaa"));
        System.out.println("unique string: " + this.makeFancyString("aab"));
    }
}


