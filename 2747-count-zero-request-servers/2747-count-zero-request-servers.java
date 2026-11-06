
import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int m = logs.length;
        int q = queries.length;

        // Sort logs by request time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        // Store query indices and sort by query time
        Integer[] indices = new Integer[q];

        for (int i = 0; i < q; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) ->
            Integer.compare(queries[a], queries[b]));

        int[] freq = new int[n + 1];
        int[] ans = new int[q];

        int left = 0;
        int right = 0;
        int active = 0;

        for (int idx : indices) {

            int time = queries[idx];
            int start = time - x;

            // Add logs with time <= query time
            while (right < m && logs[right][1] <= time) {

                int server = logs[right][0];

                if (freq[server] == 0) {
                    active++;
                }

                freq[server]++;
                right++;
            }

            // Remove logs outside the current window
            while (left < right && logs[left][1] < start) {

                int server = logs[left][0];

                freq[server]--;

                if (freq[server] == 0) {
                    active--;
                }

                left++;
            }

            // Servers receiving zero requests
            ans[idx] = n - active;
        }

        return ans;
    }
}
