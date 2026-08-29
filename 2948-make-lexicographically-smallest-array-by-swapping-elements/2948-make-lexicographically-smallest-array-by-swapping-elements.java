

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        // Create pairs: {value, original index}
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort by value
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int i = 0;

        while (i < n) {

            int j = i;

            // Find all values belonging to the same group
            while (j + 1 < n &&
                   arr[j + 1][0] - arr[j][0] <= limit) {
                j++;
            }

            // Collect original indices of this group
            int[] indices = new int[j - i + 1];

            for (int k = i; k <= j; k++) {
                indices[k - i] = arr[k][1];
            }

            // Sort original indices
            Arrays.sort(indices);

            // Values are already sorted because arr is sorted
            // Put smallest values at smallest original indices
            for (int k = i; k <= j; k++) {
                nums[indices[k - i]] = arr[k][0];
            }

            i = j + 1;
        }

        return nums;
    }
}