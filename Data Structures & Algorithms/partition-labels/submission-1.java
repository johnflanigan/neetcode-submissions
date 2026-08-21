class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> last = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            last.put(c, i);
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = last.get(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (i > end) {
                result.add(end - start + 1);
                start = i;
            }

            end = Math.max(end, last.get(s.charAt(i)));
        }

        result.add(end - start + 1);

        return result;
    }
}
