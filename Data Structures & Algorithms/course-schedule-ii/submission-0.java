class Node {
    Set<Integer> in = new HashSet<>();
    Set<Integer> out = new HashSet<>();
    int val;

    Node(int val) {
        this.val = val;
    }
}

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> prereqs = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            prereqs.put(i, new Node(i));
        }
        for (int[] prerequisite : prerequisites) {
            // In example [1, 0] the direction is 0 -> 1
            prereqs.get(prerequisite[0]).in.add(prerequisite[1]);
            prereqs.get(prerequisite[1]).out.add(prerequisite[0]);
        }

        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        for (Node node : prereqs.values()) {
            if (node.in.isEmpty()) {
                deque.addLast(node.val);
                visited.add(node.val);
            }
        }

        while (!deque.isEmpty()) {
            Node node = prereqs.get(deque.removeFirst());
            result.add(node.val);

            for (int i : node.out) {
                if (visited.contains(i)) {
                    continue;
                }
                Node child = prereqs.get(i);
                child.in.remove(node.val);
                if (child.in.isEmpty()) {
                    deque.addLast(child.val);
                    visited.add(child.val);
                }
            }
        }

        // for (int i : result) {
        //     System.out.println(i);
        // }

        if (result.size() != numCourses) {
            return new int[0];
        }

        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;
    }
}
