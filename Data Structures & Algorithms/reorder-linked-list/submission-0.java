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

    ListNode current;

    public void reorderList(ListNode head) {
        this.current = head;

        int length = getLength(head, 0);
        reorderListHelper(head, 0, length);

        return;
    }

    private int getLength(ListNode node, int length) {
        if (node == null) {
            return length;
        }

        return getLength(node.next, length + 1);
    }

    public void reorderListHelper(ListNode node, int pos, int length) {
        if (node == null) {
            return;
        }

        reorderListHelper(node.next, pos + 1, length);

        // Is the position odd, then insert into the "global" list
        if (pos > length / 2) {
            ListNode temp = current.next;
            current.next = node;
            node.next = temp;
            current = temp;
        }
        if (pos == length / 2) {
            node.next = null;
        }
    }
}
