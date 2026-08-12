class Solution {
    public String longestPalindrome(String s) {

        int maxLeft = -1;
        int maxRight = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            int[] odd = checkPalindrome(s, i, i);
            if (odd[1] - odd[0] > maxRight - maxLeft) {
                maxRight = odd[1];
                maxLeft = odd[0];
            }

            int[] even = checkPalindrome(s, i, i + 1);
            if (even[1] - even[0] > maxRight - maxLeft) {
                maxRight = even[1];
                maxLeft = even[0];
            }
        }

        return s.substring(maxLeft + 1, maxRight);
    }

    int[] checkPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return new int[]{left, right};
    }
}
