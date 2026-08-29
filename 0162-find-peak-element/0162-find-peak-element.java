class Solution {
    public int findPeakElement(int[] nums) {
        int s  = 1 ;
        int  e = nums.length-1;
        int ans = 0;

        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid]>nums[mid-1]){
                ans = mid;
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        return ans;
    }
}