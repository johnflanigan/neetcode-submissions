class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String string : strs) {
            char[] charArray = string.toCharArray();
            Arrays.sort(charArray);
            String sorted = new StringBuilder().append(charArray).toString();

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }

            map.get(sorted).add(string);
        }

        return new ArrayList<>(map.values());
    }
}
