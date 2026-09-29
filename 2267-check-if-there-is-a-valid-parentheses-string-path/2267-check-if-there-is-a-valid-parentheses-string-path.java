class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int len = m + n - 1;

        // A valid parentheses string must have even length
        if (len % 2 == 1) {
            return false;
        }

        // First must be '(' and last must be ')'
        if (grid[0][0] != '(' || grid[m - 1][n - 1] != ')') {
            return false;
        }

        // dp[i][j][balance]
        boolean[][][] dp = new boolean[m][n][len + 1];

        // Starting with '(' gives balance = 1
        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                int change = (grid[i][j] == '(') ? 1 : -1;

                for (int balance = 0; balance <= len; balance++) {

                    boolean reachable = false;

                    // From top
                    if (i > 0 && dp[i - 1][j][balance]) {
                        reachable = true;
                    }

                    // From left
                    if (j > 0 && dp[i][j - 1][balance]) {
                        reachable = true;
                    }

                    if (!reachable) {
                        continue;
                    }

                    int newBalance = balance + change;

                    // Balance can never become negative
                    if (newBalance >= 0 && newBalance <= len) {
                        dp[i][j][newBalance] = true;
                    }
                }
            }
        }

        // At the end, balance must be 0
        return dp[m - 1][n - 1][0];
    }
}