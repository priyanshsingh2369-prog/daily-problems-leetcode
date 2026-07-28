/*3517. Smallest Palindromic Rearrangement I
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given a palindromic string s.

Return the lexicographically smallest palindromic permutation of s.

 

Example 1:

Input: s = "z"

Output: "z"

Explanation:

A string of only one character is already the lexicographically smallest palindrome.

Example 2:

Input: s = "babab"

Output: "abbba"

Explanation:

Rearranging "babab" → "abbba" gives the smallest lexicographic palindrome.

Example 3:

Input: s = "daccad"

Output: "acddca"

Explanation:

Rearranging "daccad" → "acddca" gives the smallest lexicographic palindrome.

 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
s is guaranteed to be palindromic.
 
Seen this question in a real interview before?
1/6
Yes
No
Accepted
121,259/167.6K
Acceptance Rate
72.3%
Topics
icon
Companies
Hint 1
Hint 2
Construct one half (using s), and then the other half is its reverse to obtain the lexicographically smallest permutation.
Similar Questions
Discussion (92)

Choose a type



Copyright © 2026 LeetCode. All rights reserv*/
class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                middle = (char) ('a' + i);
            }

            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) ('a' + i));
            }
        }

        StringBuilder ans = new StringBuilder(left);

        if (middle != 0) {
            ans.append(middle);
        }

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }
}