
/*Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
All books must be allocated.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum. If it is not possible to allocate books to all students, return -1;

Note: Test cases are generated such that the answer always fits in a 32-bit integer.

Examples:

Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
=> [12] and [34, 67, 90] Maximum Pages = 191
=> [12, 34] and [67, 90] Maximum Pages = 157
=> [12, 34, 67] and [90] Maximum Pages = 113.
The third combination has the minimum pages assigned to a student which is 113.
Input: arr[] = [15, 17, 20], k = 5
Output: -1
Explanation: Since there are more students than total books, it's impossible to allocate a book to each student.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i], k ≤ 104*/
class Solution {
    public static boolean valid(int[] arr, long maxpages, int k){
       
        // int sum = 0;
        // int student =1;
        // for(int i = 0; i < arr.length; i++) {

        // if(arr[i] > mid)return false;

        // if(sum + arr[i] <= mid) {
        //     sum += arr[i];
        //     }   
        // else {
        //     student++;
        //     sum = arr[i];
        //     }
        // }
        // return student <= k;
       int student = 1;
       long pages = 0;
       
       for (int i = 0 ; i< arr.length ; i++){
           if(pages + arr[i] <= maxpages){
               pages+= arr[i];
           }else{
               student++;
               if(student > k || arr[i]> maxpages){
                   return false;
               }
               else{
                   pages =0;
                   pages += arr[i];
               }
           }
       }
       return true;
       
    }
    public int findPages(int[] arr, int k) {
        if(arr.length<k)return -1; 
       long sum =0;
        // code here
        for (int i = 0 ; i< arr.length ; i++){
            sum += arr[i];
        }
        long s = 0;
        long e =sum;
        long ans =-1;
        
        while(s<=e){
            long mid = s + (e-s)/2;
            
            if(valid(arr , mid,k)){
                ans = mid;
                e = mid -1;
            }else {
                s = mid+1;
            }
        }
        return (int)ans;
    }
}