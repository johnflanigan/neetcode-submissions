class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        if (sMap.size() != tMap.size()) {
            return false;
        }
        for (char c : sMap.keySet()) {
            if (!tMap.containsKey(c)) {
                return false;
            }
            if (!sMap.get(c).equals(tMap.get(c))) {
                return false;
            }
        }

        return true;
    }
}
