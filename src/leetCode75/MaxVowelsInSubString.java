package leetCode75;

import core.Solution;

import java.util.List;


/*
*
* 1456  https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length
* Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
*
Example 2:
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
*
Example 3:
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.


Constraints:
1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length
* */

public class MaxVowelsInSubString implements Solution {

    public int maxVowels(String s, int k) {
        String vowels = "aeiou";
        int curr=0;
        char[] chars = s.toCharArray();
        for(int i=0;i<k;i++) {
            if(vowels.indexOf(chars[i]) != -1) curr++;
        }
        int max=curr;
        for(int i=k;i<s.length();i++) {
            if(vowels.indexOf(chars[i]) != -1) {
                curr++;
            }
            if(vowels.indexOf(chars[i-k]) != -1) {
                curr--;
            }
            max = Math.max(max, curr);
        }
        return max;
    }

    @Override
    public void runTestCases() {
        System.out.println("Result: "+ maxVowels("abciiidef",3));
        System.out.println("Result: "+ maxVowels("aeiou",2));
        System.out.println("Result: "+ maxVowels("leetcode",3));

    }
}
