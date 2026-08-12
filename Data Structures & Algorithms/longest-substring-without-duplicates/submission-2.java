class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int l = 0;
        int r = 1;

        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));

        int max = 1;

        for (; r < s.length(); r++) {
            char c = s.charAt(r);

            while (set.contains(c)) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(c);

            max = Math.max(max, set.size());
        }

        return max;
    }
}
