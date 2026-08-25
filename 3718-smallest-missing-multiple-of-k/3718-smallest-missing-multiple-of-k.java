import java.util.*;

class Solution {
    public int missingMultiple(int[] nums, int k) {

        // Store all numbers for O(1) average lookup
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // Check k, 2k, 3k, 4k...
        int multiple = k;

        while (set.contains(multiple)) {
            multiple += k;
        }

        return multiple;
    }
}