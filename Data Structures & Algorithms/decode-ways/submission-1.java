class Solution {
    public int numDecodings(String s) {
        int[] ways = new int[s.length()];

        if (s.charAt(0) == '0') {
            return 0;
        }

        if (s.length() <= 1) {
            return 1;
        }

        ways[0] = 1;
        if (s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) >= '0' && s.charAt(1) <= '6')) {
            ways[1]++;
        }
        if (s.charAt(1) != '0') {
            ways[1]++;
        }


        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '0' && s.charAt(i) <= '6')) {
                ways[i] += ways[i - 2];
            }
            if (s.charAt(i) != '0') {
                ways[i] += ways[i - 1];
            }
        }

        return ways[ways.length - 1];
    }
}
