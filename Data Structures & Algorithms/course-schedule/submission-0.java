class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            nodes.add(new Node(i));
        }

        for (int[] prerequisite : prerequisites) {
            int first = prerequisite[0];
            int second = prerequisite[1];

            nodes.get(first).prereq.add(second);
            nodes.get(second).next.add(first);
        }

        Set<Integer> taken = new HashSet<>();
        Deque<Integer> deque = new LinkedList<>();

        for (Node node : nodes) {
            if (node.prereq.isEmpty()) {
                deque.addLast(node.val);
                taken.add(node.val);
            }
        }

        while (!deque.isEmpty()) {
            int i = deque.removeFirst();
            Node node = nodes.get(i);

            for (int j : node.next) {
                Node next = nodes.get(j);
                if (taken.containsAll(next.prereq) && !taken.contains(j)) {
                    taken.add(j);
                    deque.addLast(j);
                }
            }
        }

        return taken.size() == numCourses;
    }
}

class Node {
    int val;
    List<Integer> prereq;
    List<Integer> next;

    public Node(int val) {
        this.val = val;
        prereq = new ArrayList<>();
        next = new ArrayList<>();
    }
}

