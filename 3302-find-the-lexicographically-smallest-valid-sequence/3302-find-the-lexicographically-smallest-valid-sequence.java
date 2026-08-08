import java.util.*;

class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(), m = word2.length();

        int[] suf = new int[m];
        Arrays.fill(suf, -1);

        // Step 1: Build suffix array (right to left match)
        int p = m - 1;
        for (int i = n - 1; i >= 0 && p >= 0; i--) {
            if (word1.charAt(i) == word2.charAt(p)) {
                suf[p] = i;
                p--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        boolean used = false; // mismatch used or not
        int pos = 0;

        // Step 2: Greedy construction
        for (int j = 0; j < m; j++) {
            boolean found = false;

            while (pos < n) {

                boolean canFinish;
                if (j == m - 1) {
                    canFinish = true;
                } else {
                    canFinish = (suf[j + 1] != -1 && pos < suf[j + 1]);
                }

                if (word1.charAt(pos) == word2.charAt(j)) {
                    ans.add(pos);
                    pos++;
                    found = true;
                    break;
                } 
                else if (!used && canFinish) {
                    // use mismatch here
                    used = true;
                    ans.add(pos);
                    pos++;
                    found = true;
                    break;
                }

                pos++;
            }

            if (!found) return new int[0];
        }

        // convert List -> int[]
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}