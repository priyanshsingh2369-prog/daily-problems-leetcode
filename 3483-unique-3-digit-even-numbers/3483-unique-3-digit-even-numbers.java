class Solution {
    public int totalNumbers(int[] digits) {
        boolean[] used = new boolean[10];
        int ans = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) continue; // first digit cannot be 0

            for (int j = 0; j < digits.length; j++) {
                if (j == i) continue;

                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j) continue;

                    // Last digit must be even
                    if (digits[k] % 2 != 0) continue;

                    int num = digits[i] * 100
                            + digits[j] * 10
                            + digits[k];

                    used[num / 100] = false; // not needed for calculation
                    ans++;
                }
            }
        }
        boolean[] seen = new boolean[1000];
        int count = 0;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) continue;
            for (int j = 0; j < digits.length; j++) {
                if (j == i) continue;
                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j) continue;
                    if (digits[k] % 2 != 0) continue;

                    int num = digits[i] * 100
                            + digits[j] * 10
                            + digits[k];

                    if (!seen[num]) {
                        seen[num] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}