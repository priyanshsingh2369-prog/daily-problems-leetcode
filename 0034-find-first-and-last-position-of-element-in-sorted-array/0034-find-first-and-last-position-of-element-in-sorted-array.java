class Solution {
    public int[] searchRange(int[] nums, int target) {
        // lower bound 
        int[ ]arr = new int[2];
        Arrays.fill(arr,-1);

        int s =0 ;
        int e = nums.length-1;
        int lowwer = -1;

        while(s<=e){
            int mid = s +(e-s)/2;
            
            if(nums[mid]>target){
                e=mid-1;

            }else if(nums[mid] ==target){
                lowwer = mid;
                e=mid-1;
                
            }else{
                s=mid+1;
            }
        }
        arr[0 ]= lowwer;
        
        int i = 0;
        int j = nums.length-1;
        int upper=-1;

        while (i<=j){
            int mid = i+(j-i)/2;

            if(nums[mid]>target){
                upper = mid;
                j=mid-1;

            }else{
                i=mid+1;
            }
        }

        if(lowwer!=-1){
            arr[1]= upper-1;
        }
        if(lowwer!=-1&&upper==-1){
            arr[1]=nums.length-1;
        }

        return arr;
    }
}