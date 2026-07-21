/**1047. Remove All Adjacent Duplicates In String
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

 

Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay"
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters. */
class Solution {
   
    public String removeDuplicates(String s) {
        // int i = 0;
        // int j = 1;
        // while(i<s.length()&& j< s.length()){
        //     if(s.charAt(i)==s.charAt(j)){
        //         // remove(s,i,j);
        //         s = s.substring(0,i)+s.substring(j+1);
        //         i=0;
        //         j=1;
        //     }else{
        //         i++;
        //         j++;
        //     }
        // }


        StringBuilder st = new StringBuilder();
        for (char x : s.toCharArray()){
            if(st.length()>0&&st.charAt(st.length()-1)==x){
                st.deleteCharAt(st.length()-1);
            }else{
                st.append(x);
            }
        }

        return st.toString();
    }
}