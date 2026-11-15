class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i =0;
        int j=n-1;
        int ans = 0;
        if(n==2){
            return Math.min(height[i],height[j]);
        }
        while (i<j){
            if(height[i]<=height[j]){

                ans = Math.max(ans,(j-i)*height[i]);
                i++;
            }else{
                ans = Math.max(ans,(j-i)*height[j]);
                j--;
            }
        }
        return ans ;
    }
}
