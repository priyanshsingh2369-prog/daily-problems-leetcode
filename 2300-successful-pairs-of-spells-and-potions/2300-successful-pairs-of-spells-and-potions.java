class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n =spells.length;
        int m = potions.length;
    
        int [] ans = new int [n];
        for(int i = 0 ; i<n ;i++){
            int s=0;
            int e=m-1;
            int curr= m;
            while(s<=e){
                int mid = s+(e-s)/2;
                if((long)spells[i]*(long)potions[mid]>=success){
                    curr = mid;
                    e=mid-1;
                }else{
                    
                    s= mid+1;
                }
            }
            ans[i]=(m-curr);
        }
        return ans;
        
    }
}