package leetCode75;

import core.Solution;

/* 1071
https://leetcode.com/problems/greatest-common-divisor-of-strings
For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Example 1:
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Example 2:
Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

Example 3:
Input: str1 = "LEET", str2 = "CODE"
Output: ""

Constraints:
1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters.
* */

public class GreatestCommonDivisorOfStrings implements Solution {

    public String gcdOfStrings(String str1, String str2) {

        if(!((str1 + str2).equals(str2 + str1))) return "";
        else {
            StringBuilder result= new StringBuilder();
            boolean flag=true;
            int i=0,j=0;
            while(flag && (i<str1.length() && j<str2.length())) {
                if(str1.charAt(i) == str2.charAt(j)) {
                    result.append(str1.charAt(i));
                    i++;
                    j++;
                } else {
                    flag = false;
                }
            }
            while(!(str1.length()%result.length() == 0 && str2.length()%result.length() == 0 )) {
                result.deleteCharAt(result.length()-1);
            }
            return result.toString();
        }

    }


    @Override
    public void runTestCases() {
        System.out.println("Result:" + gcdOfStrings("ABCABC","ABC"));
        System.out.println("Result:" + gcdOfStrings("ABABAB","ABAB"));
        System.out.println("Result:" + gcdOfStrings("LEET","CODE"));
    }
}
