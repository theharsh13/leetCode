package easy;

import core.Solution;

import java.util.ArrayList;
import java.util.List;


/*
* In a string s of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".

A group is identified by an interval [start, end], where start and end denote the start and end indices (inclusive) of the group. In the above example, "xxxx" has the interval [3,6].

A group is considered large if it has 3 or more characters.

Return the intervals of every large group sorted in increasing order by start index.

Example 1:

Input: s = "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the only large group with start index 3 and end index 6.
Example 2:

Input: s = "abc"
Output: []
Explanation: We have groups "a", "b", and "c", none of which are large groups.
Example 3:

Input: s = "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]
Explanation: The large groups are "ddd", "eeee", and "bbb".
* */

public class PositionsOfLargeGroups implements Solution {

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        int currChar = chars[0];
        for(int i=0;i<chars.length;i++){
            if(chars[i] == currChar){
                end=i;
                if(i == chars.length-1 && end - start > 1){
                        result.add(List.of(start, end));
                }
            }else {
                if(end - start > 1){
                    result.add(List.of(start, end));
                }
                start=i;
                end=i;
                currChar = chars[i];
            }
        }
        return result;
    }

    @Override
    public void runTestCases() {
        System.out.println("result : " + this.largeGroupPositions("babaaaabbb"));
        System.out.println("result : " + this.largeGroupPositions("aaa"));
        System.out.println("result : " + this.largeGroupPositions("abc"));
        System.out.println("result : " + this.largeGroupPositions("abbxxxxzzy"));
        System.out.println("result : " + this.largeGroupPositions("abcdddeeeeaabbbcd"));
    }
}
