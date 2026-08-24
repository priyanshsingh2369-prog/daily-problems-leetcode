class Solution {
    public int stoneGameVIII(int[] stones) {

        int n = stones.length;

        // Step 1: Convert stones into prefix sums
        for (int i = 1; i < n; i++) {
            stones[i] += stones[i - 1];
        }

        // Base case:
        // If we take all stones, score difference is total sum
        int dp = stones[n - 1];

        // Step 2: Calculate DP backwards
        // We stop at index 1 because first move
        // must take at least 2 stones
        for (int i = n - 2; i > 0; i--) {

            dp = Math.max(
                dp,
                stones[i] - dp
            );
        }

        return dp;
    }
}