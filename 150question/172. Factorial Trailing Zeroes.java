/**
Code
Testcase
Testcase
Test Result
172. Factorial Trailing Zeroes
Solved
Medium
Topics
premium lock icon
Companies
Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

 

Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0
 

Constraints:

0 <= n <= 104
 

Follow up: Could you write a solution that works in logarithmic time complexity? */



// class Solution {
//     public static long factorial(int n){
//         if(n==0)return 1;

//         return n*factorial(n-1);
//     }

//     public int trailingZeroes(int n) {
//         if(n==0)return 0;
//         long fac = factorial(n);
//         long ans=0;
//         while(fac >=0){
//             if(fac%10 == 0){
                
//                 ans++;
//             }else break;
//             fac/=10;
//         }
//         return (int)ans;

//     }
// }
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;

        while (n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }
}