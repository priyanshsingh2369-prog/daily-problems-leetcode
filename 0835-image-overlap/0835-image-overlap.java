class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        int[][] count = new int[2 * n - 1][2 * n - 1];

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (img1[i][j] == 1) {

                    for (int x = 0; x < n; x++) {
                        for (int y = 0; y < n; y++) {

                            if (img2[x][y] == 1) {

                                int dr = x - i;
                                int dc = y - j;

                                // Shift indices so negative values work
                                int r = dr + n - 1;
                                int c = dc + n - 1;

                                count[r][c]++;

                                ans = Math.max(ans, count[r][c]);
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}