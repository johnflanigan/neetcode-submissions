class LRUCache {

    Map<Integer, Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer value = map.remove(key);
        if (value == null) {
            return -1;
        } else {
            map.put(key, value);
            return value;
        }
    }
    
    public void put(int key, int value) {
        map.remove(key);
        map.put(key, value);

        if (map.size() > capacity) {
            int oldestKey = map.keySet().iterator().next();
            map.remove(oldestKey);
        }
    }
}
