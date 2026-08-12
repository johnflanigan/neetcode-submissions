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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode current = head;

        boolean carry = false;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val;
            if (carry) {
                val++;
            }

            if (val >= 10) {
                carry = true;
                val = val % 10;
            } else {
                carry = false;
            }

            current.next = new ListNode(val);
            current = current.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        if (l2 != null) {
            l1 = l2;
        }
        while (l1 != null) {
            int val = l1.val;
            if (carry) {
                val++;
            }

            if (val >= 10) {
                carry = true;
                val = val % 10;
            } else {
                carry = false;
            }

            current.next = new ListNode(val);
            current = current.next;

            l1 = l1.next;
        }

        if (carry) {
            current.next = new ListNode(1);
        }

        return head.next;
    }
}
