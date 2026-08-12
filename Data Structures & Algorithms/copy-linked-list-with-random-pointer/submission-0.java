/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node fakeHead = new Node(-1);

        Map<Node, Node> oldToNew = new HashMap<>();

        Node oldCurrent = head;
        Node newCurrent = fakeHead;
        while (oldCurrent != null) {
            Node newNode = new Node(oldCurrent.val);
            newCurrent.next = newNode;

            oldToNew.put(oldCurrent, newNode);

            oldCurrent = oldCurrent.next;
            newCurrent = newCurrent.next;
        }

        oldCurrent = head;
        newCurrent = fakeHead.next;
        while (oldCurrent != null) {
            if (oldCurrent.random != null) {
                newCurrent.random = oldToNew.get(oldCurrent.random);
            }
            oldCurrent = oldCurrent.next;
            newCurrent = newCurrent.next;
        }

        return fakeHead.next;
    }
}
