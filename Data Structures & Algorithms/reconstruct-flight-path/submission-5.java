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

        Deque<String> result = new LinkedList<>();
        hierholzer("JFK", map, result);

        return new ArrayList<>(result);
    }

    private void hierholzer(String start, Map<String, PriorityQueue<String>> map, Deque<String> result) {

        while (!map.get(start).isEmpty()) {            
            String next = map.get(start).poll();
            hierholzer(next, map, result);
        }

        result.addFirst(start);
    }
}
