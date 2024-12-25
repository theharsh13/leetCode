package leetCode75;

import core.Solution;

import java.util.List;

/* 345
https://leetcode.com/problems/reverse-vowels-of-a-string
* Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:
Input: s = "IceCreAm"
Output: "AceCreIm"
Explanation:
The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:
Input: s = "leetcode"
Output: "leotcede"

Constraints:
1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
* */

public class ReverseVowels implements Solution {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left=0,right=chars.length-1;
        String vowels = "aeiouAEIOU";
        while(left<right) {
            int x=-1,y=-1;
            if(vowels.indexOf(chars[left]) != -1) x = left;
            else left++;
            if(vowels.indexOf(chars[right]) != -1) y = right;
            else right--;
            if(x!=-1 && y!=-1) {
                char temp=chars[x];
                chars[x] = chars[y];
                chars[y] = temp;
                x=y=-1;
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }

    @Override
    public void runTestCases() {
        System.out.println("Result: "+ reverseVowels("IceCreAm"));
        System.out.println("Result: "+ reverseVowels("leetcode"));
        System.out.println("Result: "+ reverseVowels("ai"));
    }
}
