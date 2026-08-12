class Solution {
    public int countSubstrings(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            total += countSubstrings(s, i, i);
        }

        for (int i = 0; i < s.length() - 1; i++) {
            total += countSubstrings(s, i, i + 1);
        }

        return total;
    }

    private int countSubstrings(String s, int left, int right) {
        int total = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            total++;
            left--;
            right++;
        }

        return total;
    }
}
