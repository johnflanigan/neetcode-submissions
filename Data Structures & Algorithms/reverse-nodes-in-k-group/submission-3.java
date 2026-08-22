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

record Pair(ListNode head, ListNode tail) {}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prevHead = new ListNode();
        prevHead.next = head;

        ListNode dummy = prevHead;

        ListNode current = head;
        ListNode kth = getKth(current, k);

        while (kth != null) {
            ListNode nextGroup = kth.next;
            Pair pair = reverseK(current, k);

            prevHead.next = pair.head;
            pair.tail.next = nextGroup;

            prevHead = pair.tail;
            current = nextGroup;
            kth = getKth(current, k);
        }

        return dummy.next;
    }

    public Pair reverseK(ListNode head, int k) {
        ListNode newTail = head;

        ListNode prev = null;
        ListNode current = head;

        int i = 0;
        while (i < k) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;

            i++;
        }

        return new Pair(prev, newTail);
    }

    public ListNode getKth(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        int i = 1;

        ListNode current = head;
        while (current != null && i < k) {
            current = current.next;
            i++;
        }
        
        return current;
    }
}
