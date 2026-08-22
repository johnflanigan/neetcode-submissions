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
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String start = ticket.get(0);
            String stop = ticket.get(1);

            if (!map.containsKey(start)) {
                map.put(start, new PriorityQueue<>());
            }
            if (!map.containsKey(stop)) {
                map.put(stop, new PriorityQueue<>());
            }
            map.get(start).add(stop);
        }

        List<String> result = hierholzer("JFK", map);

        return result;
    }

    private List<String> hierholzer(String start, Map<String, PriorityQueue<String>> map) {
        List<String> result = new LinkedList<>();

        String current = start;

        while (!map.get(current).isEmpty()) {
            result.add(current);
            
            String next = map.get(current).poll();
            current = next;
        }

        result.add(current);

        for (int i = result.size() - 1; i >= 0; i--) {
            current = result.get(i);

            if (!map.get(current).isEmpty()) {
                List<String> subresult = hierholzer(current, map);

                List<String> updated = new LinkedList<>();
                updated.addAll(result.subList(0, i));
                updated.addAll(subresult);
                updated.addAll(result.subList(i + 1, result.size()));

                result = updated;
            }
        }

        return result;
    }
}
