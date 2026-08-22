class Solution {
    public String minWindow(String s, String t) {
        int[] tCount = new int[52];

        for (char c : t.toCharArray()) {
            tCount[getIndex(c)]++;
        }

        int[] sCount = new int[52];

        int l = 0;
        int r = 0;

        String min = null;

        while (r < s.length()) {
            sCount[getIndex(s.charAt(r))]++;

            while (l < s.length() && isMatch(sCount, tCount)) {
                if (min == null || r - l + 1 < min.length()) {
                    min = s.substring(l, r + 1);
                }
                
                sCount[getIndex(s.charAt(l))]--;
                l++;
            }

            r++;
        }

        if (min == null) {
            return "";
        }
        return min;
    }

    private boolean isMatch(int[] s, int[] t) {
        for (int i = 0; i < t.length; i++) {
            if (s[i] < t[i]) {
                return false;
            }
        }

        return true;
    }

    private int getIndex(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (int) (c - 'A');
        } else if (c >= 'a' && c <= 'z') {
            return ((int) (c - 'a')) + 26;
        } else {
            throw new IllegalArgumentException("Unknown char %c".formatted(c));
        }
    }
}
