class TimeMap {

    Map<String, List<Integer>> timestamps;
    Map<String, Map<Integer, String>> values;

    public TimeMap() {
        this.timestamps = new HashMap<>();
        this.values = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!timestamps.containsKey(key)) {
            timestamps.put(key, new ArrayList<>());
            values.put(key, new HashMap<>());
        }

        timestamps.get(key).add(timestamp);
        values.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!timestamps.containsKey(key)) {
            return "";
        }

        List<Integer> list = timestamps.get(key);
        int t = findTimestamp(list, timestamp);

        return values.get(key).getOrDefault(t, "");
    }

    private int findTimestamp(List<Integer> list, int timestamp) {
        int l = 0;
        int r = list.size() - 1;

        int pred = -1;
        while (l <= r) {
            int m = l + ((r - l) / 2);

            if (list.get(m) < timestamp) {
                pred = list.get(m);
                l = m + 1;
            } else if (list.get(m) > timestamp) {
                r = m - 1;
            } else {
                return list.get(m);
            }
        }

        return pred;
    }
}
