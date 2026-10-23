import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        // 1. Find the index of 0 in the original array
        int z0 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                z0 = i;
                break;
            }
        }

        // 2. Construct the reversed array and find 0's index there
        int[] revNums = new int[n];
        int z1 = -1;
        for (int i = 0; i < n; i++) {
            revNums[i] = nums[n - 1 - i];
            if (revNums[i] == 0) {
                z1 = i;
            }
        }

        // 3. Determine if the target sorted state exists in Type 0 or Type 1
        boolean target0Valid = true;
        for (int i = 0; i < n; i++) {
            if (nums[(z0 + i) % n] != i) {
                target0Valid = false;
                break;
            }
        }

        boolean target1Valid = true;
        for (int i = 0; i < n; i++) {
            if (revNums[(z1 + i) % n] != i) {
                target1Valid = false;
                break;
            }
        }

        // If neither configuration can form a sorted sequence, it's impossible
        if (!target0Valid && !target1Valid) return -1;

        // 4. Run BFS over the 2N states
        // state representation: type * n + shift
        int[][] dist = new int[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        
        // Start at type 0, shift 0
        dist[0][0] = 0;
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int type = curr[0];
            int shift = curr[1];
            int d = dist[type][shift];

            // Check if we reached a valid target state
            if (type == 0 && target0Valid && shift == z0) return d;
            if (type == 1 && target1Valid && shift == z1) return d;

            // Transition 1: Rotate Left by One
            int nextShift = (shift + 1) % n;
            if (dist[type][nextShift] == -1) {
                dist[type][nextShift] = d + 1;
                queue.offer(new int[]{type, nextShift});
            }

            // Transition 2: Reverse the array
            int nextType = 1 - type;
            int revShift = (n - shift) % n;
            if (dist[nextType][revShift] == -1) {
                dist[nextType][revShift] = d + 1;
                queue.offer(new int[]{nextType, revShift});
            }
        }

        return -1;
    }
}
