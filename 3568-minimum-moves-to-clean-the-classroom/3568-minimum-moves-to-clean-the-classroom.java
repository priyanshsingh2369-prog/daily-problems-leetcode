class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        // litterId[i][j] = ID of litter at this cell
        int[][] litterId = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                litterId[i][j] = -1;
            }
        }

        int sr = 0, sc = 0;
        int litterCount = 0;

        // Find S and give every L an ID
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                }
                else if (ch == 'L') {
                    litterId[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        // No litter
        if (litterCount == 0) {
            return 0;
        }

        int totalMasks = 1 << litterCount;

        /*
         * visited[row][col][energy][mask]
         *
         * mask tells which litter has been collected.
         */
        boolean[][][][] visited =
            new boolean[m][n][energy + 1][totalMasks];

        /*
         * state:
         * row, col, currentEnergy, mask
         */
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();

        queue.offer(new int[]{
            sr, sc, energy, 0
        });

        visited[sr][sc][energy][0] = true;

        int fullMask = totalMasks - 1;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one BFS level
            while (size-- > 0) {

                int[] cur = queue.poll();

                int r = cur[0];
                int c = cur[1];
                int currEnergy = cur[2];
                int mask = cur[3];

                // All litter collected
                if (mask == fullMask) {
                    return moves;
                }

                // No energy left -> cannot move
                if (currEnergy == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // Outside grid
                    if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                        continue;
                    }

                    // Wall
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    char cell = classroom[nr].charAt(nc);

                    // Moving costs 1 energy
                    int newEnergy = currEnergy - 1;

                    // Copy current mask
                    int newMask = mask;

                    // If we collect litter
                    if (cell == 'L') {

                        int id = litterId[nr][nc];

                        newMask = newMask | (1 << id);
                    }

                    // R resets energy to maximum
                    if (cell == 'R') {
                        newEnergy = energy;
                    }

                    // Visit this state only once
                    if (!visited[nr][nc][newEnergy][newMask]) {

                        visited[nr][nc][newEnergy][newMask] = true;

                        queue.offer(new int[]{
                            nr,
                            nc,
                            newEnergy,
                            newMask
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}