/**
Code
Testcase
Testcase
Test Result
567. Permutation in String
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters. */
class Solution {
    public static boolean same(int count1[],int count2[]){
        for (int i=0;i<26;i++){
            if(count1[i]!=count2[i]){
                return false;
            }
        }
        return true;

    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;


        int count1[] = new int[26];
        for (int i =0; i<s1.length() ; i++){
            int charec = s1.charAt(i);
            int index = charec - 'a';
            count1[index]++;
        }


        int i=0;
        int windowlength = s1.length();
        int [] count2 = new int [26];

        for ( i = 0 ;i< windowlength;i++){
            int charec = s2.charAt(i);
            int index = charec - 'a';
            count2[index]++;
        }

        if(same(count1,count2)){
            return true;

        }else {
            //alag se check kr le ge
            while(i<s2.length()){ 

                char charcurr = s2.charAt(i);
                int indexcurr = charcurr - 'a';
                count2[indexcurr]++;


                char deletechar = s2.charAt(i-windowlength);
                int indexdelete = deletechar-'a';
                count2[indexdelete]--;


                if(same(count1,count2))return true;
                i++;

            }
        }


        return false;

    }
}