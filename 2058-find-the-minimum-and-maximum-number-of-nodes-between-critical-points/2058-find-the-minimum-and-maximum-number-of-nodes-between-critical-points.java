/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] ans = {-1, -1};

        // Need at least 3 nodes to have a critical point
        if (head == null || head.next == null || head.next.next == null) {
            return ans;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        int position = 1;

        // Position of first critical point
        int first = -1;

        // Position of previous critical point
        int last = -1;

        // Minimum distance
        int min = Integer.MAX_VALUE;

        while (curr.next != null) {

            ListNode next = curr.next;

            // Check if curr is a critical point
            boolean isCritical =
                (curr.val > prev.val && curr.val > next.val) ||
                (curr.val < prev.val && curr.val < next.val);

            if (isCritical) {

                // First critical point
                if (first == -1) {
                    first = position;
                }

                // We already have a previous critical point
                if (last != -1) {
                    min = Math.min(min, position - last);
                }

                last = position;
            }

            prev = curr;
            curr = next;
            position++;
        }

        // If fewer than 2 critical points
        if (first == -1 || first == last) {
            return ans;
        }

        // Maximum distance = last critical point - first critical point
        int max = last - first;

        ans[0] = min;
        ans[1] = max;

        return ans;
    }
}
