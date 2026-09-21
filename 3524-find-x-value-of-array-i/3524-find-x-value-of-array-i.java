class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];

        long[] dp = new long[k];

        for (int num : nums) {
            long[] next = new long[k];

            // Subarray containing only nums[i]
            next[num % k]++;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newRemainder = (int)((r * (long)num) % k);
                    next[newRemainder] += dp[r];
                }
            }

            dp = next;

            // Add all subarrays ending at current position
            for (int r = 0; r < k; r++) {
                ans[r] += dp[r];
            }
        }

        return ans;
    }
}
