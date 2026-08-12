class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 1;

        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(l), 1);

        int max = 1;

        while (r < s.length()) {
            while (l < s.length() && r - l - getMaxValue(map) > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            if (r - l - getMaxValue(map) <= k) {
                max = Math.max(max, r - l);
            }

            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            r++;
        }

        if (r - l - getMaxValue(map) <= k) {
            max = Math.max(max, r - l);
        }

        return max;
    }

    private int getMaxValue(Map<Character, Integer> map) {
        int max = 1;
        for (int value : map.values()) {
            max = Math.max(max, value);
        }
        return max;
    }
}
