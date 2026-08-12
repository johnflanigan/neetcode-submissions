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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode current = head;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> Integer.compare(l1.val, l2.val));
        for (ListNode list : lists) {
            pq.add(list);
        }

        while (!pq.isEmpty()) {
            ListNode list = pq.remove();
            current.next = list;
            current = current.next;

            if (list.next != null) {
                pq.add(list.next);
            }
        }

        current.next = null;
        return head.next;
    }
}
