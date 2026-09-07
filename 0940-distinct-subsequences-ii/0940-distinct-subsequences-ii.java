class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i) - 'a';
            dp[i + 1] = (2 * dp[i]) % MOD;
            if (last[ch] != -1) {
                dp[i + 1] -= dp[last[ch]];
                if (dp[i + 1] < 0) {
                    dp[i + 1] += MOD;
                }
            }   
            last[ch] = i;
        }
        return (int)((dp[n] - 1 + MOD) % MOD);
    }
}