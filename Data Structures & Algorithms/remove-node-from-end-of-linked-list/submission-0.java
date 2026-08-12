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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head.next;
        }

        ListNode fakeHead = new ListNode(-1, head);
        removeNthFromEndHelper(fakeHead, n);
        return fakeHead.next;
    }

    // Returns the number of nodes in remainder of list
    // Side effect removes nth from end
    private int removeNthFromEndHelper(ListNode node, int n) {
        if (node == null) {
            return 0;
        }

        int remainder = removeNthFromEndHelper(node.next, n);

        // The current node is the nth from end
        int nthFromEnd = remainder + 1;

        if (nthFromEnd - 1 == n) {
            node.next = node.next.next;
        }

        return nthFromEnd;
    }
}
