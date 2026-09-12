import java.util.*;

class Solution {

    class State {
        long score;
        List<Integer> indices;

        State() {
            score = 0;
            indices = new ArrayList<>();
        }

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // start, end, weight, original index
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by start time
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // Find next non-overlapping interval
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {

            int lo = i + 1;
            int hi = n;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                // start must be greater than end
                if (arr[mid][0] > arr[i][1]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            next[i] = lo;
        }

        /*
            dp[i][k] =
            best answer from index i onwards
            when we can still select k intervals
        */
        State[][] dp = new State[n + 1][5];

        // IMPORTANT:
        // Initialize k = 0 for EVERY i
        for (int i = 0; i <= n; i++) {
            dp[i][0] = new State();
        }

        // dp[n][k] = empty answer
        for (int k = 1; k <= 4; k++) {
            dp[n][k] = new State();
        }

        // Fill DP backwards
        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {

                // Option 1: Skip current interval
                State skip = dp[i + 1][k];

                // Option 2: Take current interval
                State nextState = dp[next[i]][k - 1];

                List<Integer> takeIndices =
                        new ArrayList<>(nextState.indices);

                takeIndices.add(arr[i][3]);

                // Sort original indices for lexicographical comparison
                Collections.sort(takeIndices);

                State take = new State(
                        nextState.score + arr[i][2],
                        takeIndices
                );

                // Choose better answer
                if (better(take, skip)) {
                    dp[i][k] = take;
                } else {
                    dp[i][k] = skip;
                }
            }
        }

        List<Integer> answer = dp[0][4].indices;

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    private boolean better(State a, State b) {

        // Higher score
        if (a.score != b.score) {
            return a.score > b.score;
        }

        // Same score -> lexicographically smaller
        for (int i = 0; i < Math.min(a.indices.size(),
                                     b.indices.size()); i++) {

            if (!a.indices.get(i).equals(b.indices.get(i))) {
                return a.indices.get(i) < b.indices.get(i);
            }
        }

        return a.indices.size() < b.indices.size();
    }
}