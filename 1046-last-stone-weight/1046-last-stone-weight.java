class Solution {
    
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i: stones){
            pq.add(i);
        }

        while(pq.size()>1){
            int r1 = pq.remove();
            int r2 = pq.remove();

            int weight =r1-r2;
            pq.add(weight);
        }


        return pq.peek();

    }
}