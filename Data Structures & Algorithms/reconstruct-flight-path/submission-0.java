class Node {

    String label;
    List<Node> out;
    List<Node> in;

    Node(String label) {
        this.label = label;
        this.out = new LinkedList<>();
        this.in = new LinkedList<>();
    }

    void addOut(Node node) {
        out.add(node);
    }

    void addIn(Node node) {
        in.add(node);
    }

    void sort() {
        out.sort((n1, n2) -> n1.label.compareTo(n2.label));
        in.sort((n1, n2) -> n1.label.compareTo(n2.label));
    }
}

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, Node> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            for (String label : ticket) {
                if (!map.containsKey(label)) {
                    map.put(label, new Node(label));
                }
            }
        }

        for (List<String> ticket : tickets) {
            Node start = map.get(ticket.get(0));
            Node stop = map.get(ticket.get(1));

            start.addOut(stop);
            stop.addIn(start);
        }

        for (Node node : map.values()) {
            node.sort();
        }

        Node start = map.get("JFK");
        List<Node> nodes = hierholzer(start, map);

        List<String> result = new LinkedList<>();
        for (Node node : nodes) {
            result.add(node.label);
        }

        return result;
    }

    private List<Node> hierholzer(Node start, Map<String, Node> map) {
        System.out.println("hierholzer: " + start.label);

        List<Node> result = new LinkedList<>();

        result.add(start);

        if (start.out.isEmpty()) {
            return result;
        }

        Node current = start.out.get(0);
        start.out.remove(current);
        current.in.remove(start);

        while (!current.out.isEmpty()) {
            result.add(current);
            
            Node next = current.out.get(0);
            current.out.remove(next);
            next.in.remove(current);

            current = next;
        }
        result.add(current);

        for (int i = result.size() - 1; i >= 0; i--) {
            current = result.get(i);

            if (!current.out.isEmpty()) {
                List<Node> subresult = hierholzer(current, map);

                List<Node> updated = new LinkedList<>();
                updated.addAll(result.subList(0, i));
                updated.addAll(subresult);
                updated.addAll(result.subList(i + 1, result.size()));

                result = updated;
            }
        }

        return result;
    }
}
