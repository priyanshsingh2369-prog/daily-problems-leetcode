/*3312. Sorted GCD Pair Queries
Hard
Topics
premium lock icon
Companies
Hint
You are given an integer array nums of length n and an integer array queries.

Let gcdPairs denote an array obtained by calculating the GCD of all possible pairs (nums[i], nums[j]), where 0 <= i < j < n, and then sorting these values in ascending order.

For each query queries[i], you need to find the element at index queries[i] in gcdPairs.

Return an integer array answer, where answer[i] is the value at gcdPairs[queries[i]] for each query.

The term gcd(a, b) denotes the greatest common divisor of a and b.

 

Example 1:

Input: nums = [2,3,4], queries = [0,2,2]

Output: [1,2,2]

Explanation:

gcdPairs = [gcd(nums[0], nums[1]), gcd(nums[0], nums[2]), gcd(nums[1], nums[2])] = [1, 2, 1].

After sorting in ascending order, gcdPairs = [1, 1, 2].

So, the answer is [gcdPairs[queries[0]], gcdPairs[queries[1]], gcdPairs[queries[2]]] = [1, 2, 2].

Example 2:

Input: nums = [4,4,2,1], queries = [5,3,1,0]

Output: [4,2,1,1]

Explanation:

gcdPairs sorted in ascending order is [1, 1, 1, 2, 2, 4].

Example 3:

Input: nums = [2,2], queries = [0,0]

Output: [2,2]

Explanation:

gcdPairs = [2].

 

Constraints:

2 <= n == nums.length <= 105
1 <= nums[i] <= 5 * 104
1 <= queries.length <= 105
0 <= queries[i] < n * (n - 1) / 2*/
class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int MAX = 50000;

        // Frequency of each number
        int[] freq = new int[MAX + 1];
        for (int num : nums) {
            freq[num]++;
        }

        // cnt[d] = how many numbers are divisible by d
        int[] cnt = new int[MAX + 1];
        for (int d = 1; d <= MAX; d++) {
            for (int multiple = d; multiple <= MAX; multiple += d) {
                cnt[d] += freq[multiple];
            }
        }

        // gcdCount[d] = number of pairs with gcd exactly d
        long[] gcdCount = new long[MAX + 1];
        for (int d = MAX; d >= 1; d--) {
            long totalPairs = (long) cnt[d] * (cnt[d] - 1) / 2;

            for (int multiple = d * 2; multiple <= MAX; multiple += d) {
                totalPairs -= gcdCount[multiple];
            }

            gcdCount[d] = totalPairs;
        }

        // Prefix sum of pair counts
        long[] prefix = new long[MAX + 1];
        for (int i = 1; i <= MAX; i++) {
            prefix[i] = prefix[i - 1] + gcdCount[i];
        }

        int[] ans = new int[queries.length];

        // Binary search for each query
        for (int i = 0; i < queries.length; i++) {
            long k = queries[i] + 1; // convert to 1-based index

            int left = 1, right = MAX;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (prefix[mid] >= k) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            ans[i] = left;
        }

        return ans;
    }
}