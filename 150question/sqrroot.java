class Solution {
    
    public int mySqrt(int x) {

        int s = 1;
        int e = x;

        if(x==0)return 0;
        double  ans =-1;

        while(s<=e){
            int mid  = s+(e-s)/2;
            if(mid >x/mid){
                e = mid -1;
            }else if(mid <x/mid){
                ans = mid;
                s = mid+1;
            }else{
                return mid;
            }
        }
        double factor = 1;
        int reqdecimal = 3;
        for (int round =1 ; rount <=reqdecimal; round++){
            factor = factor /10;
            for (int i =1 ; i <10;i++){
                double newans = ans +factor;
                if(newans*newans  ==x  )return newans;// it is unsafe while dealing with decimal values
                else if(newans >x/newans) break ;
                else {
                    ans = newans;

                }
            }
        }
        return Math.round(ans*1000)/1000.0;
    }
}
