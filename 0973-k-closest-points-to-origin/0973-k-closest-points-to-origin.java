class triple implements Comparable<triple>{

    int length ;
    int x;
    int y;

    triple(int length, int x,int y){
        this.length= length;
        this.x = x;
        this.y = y ;

    }
    public int compareTo(triple t){
        return Integer.compare(t.length, this.length);
    }
}



class Solution {
//public class min_cost_toropa {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<triple> pq = new PriorityQueue<>();
            for (int []arr : points) {
                int xx = arr[0];
                int yy = arr[1];
                int dist = xx * xx + yy * yy;
                pq.add(new triple(dist, xx, yy));
                if (pq.size() > k) {
                    pq.remove();
                }
            }
            int [][] ans = new int[k][2];

                for(int i = 0; i<k;i++){
                    triple top =  pq.remove();

                    ans[i][0]=top.x;
                    ans[i][1]=top.y;

                }
            

        return ans;
    }
}

