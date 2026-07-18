/*Given an integer array arr[], which denotes the positions of stalls. All the positions are distinct. There are k aggressive cows.

Assign the cows to the stalls such that the minimum distance between any two cows is maximized.

Examples:

Input: arr[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at arr[0], the second at arr[2], and the third at arr[3]. The minimum distance between any two cows is 3 (between arr[0] and arr[2]), which is the maximum possible among all valid arrangements.
Input: arr[] = [10, 1, 2, 7, 5], k = 3
Output: 4
Explanation: The first cow can be placed at arr[0], the second at arr[1], and the third at arr[4]. In this arrangement, the minimum distance between any two cows is 4 (between arr[1] and arr[4]), which is the maximum possible among all valid arrangements.
Constraints:
2 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 108
2 ≤ k ≤ arr.size() */
class Solution {
    public static boolean valid(int[] arr, int mid, int k){
        int srtcow =0;
        int cowcont=1;
        int sum =0;
        for (int i=0;i<arr.length;i++){
            sum =Math.abs(arr[i]-arr[srtcow]);
            if(sum >= mid){
                srtcow = i;
                cowcont ++;
                sum = 0;
            }else {
                
            }
        }
        return cowcont>= k;
    }
    public int aggressiveCows(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int e =arr[arr.length-1]-arr[0];
        
        int s =0;
        int ans=0;
        
        while(s<=e){
            int mid = s+(e-s)/2;
            
            if(valid(arr , mid , k )){
                //right
                ans = mid ;
                s=mid+1;
                //write best
                
            }else{
                e=mid-1;
                
            }
        }
        return ans;
        
    }
}