package easy;
/*
You are given a string word that consists of digits and lowercase English letters.

You will replace every non-digit character with a space. For example, "a123bc34d8ef34" will become " 123  34 8  34". Notice that you are left with some integers that are separated by at least one space: "123", "34", "8", and "34".

Return the number of different integers after performing the replacement operations on word.

Two integers are considered different if their decimal representations without any leading zeros are different.



Example 1:

Input: word = "a123bc34d8ef34"
Output: 3
Explanation: The three different integers are "123", "34", and "8". Notice that "34" is only counted once.
Example 2:

Input: word = "leet1234code234"
Output: 2
Example 3:

Input: word = "a1b01c001"
Output: 1
Explanation: The three integers "1", "01", and "001" all represent the same integer because
the leading zeros are ignored when comparing their decimal values.


* */

import core.Solution;

import java.util.HashSet;
import java.util.Set;

public class NumDiffIntegers implements Solution {

    public int numDifferentIntegers(String word) {
        int left=0;
        int right=0;
        Set<String> v = new HashSet<>();
        for(int i=0;i<word.length();i++){
            if(Character.isDigit(word.charAt(i))) {
                ++right;
            } else {
                if(right>left) {
                    v.add(word.substring(left, right).replaceFirst("^0*",""));
                }
                left=i+1;
                right=i+1;
            }
            if(i == word.length()-1) {
                if(right>left) {
                    v.add(word.substring(left, right).replaceFirst("^0*",""));
                }
            }
        }
        return v.size();
    }

    @Override
    public void runTestCases() {
        System.out.println("result: "+ numDifferentIntegers("a123bc34d8ef34"));
        System.out.println("result: "+ numDifferentIntegers("leet1234code234"));
        System.out.println("result: "+ numDifferentIntegers("a1b01c001"));
        System.out.println("result: "+ numDifferentIntegers("167278959591294"));


    }
}
