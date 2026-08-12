class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                String reversed = new StringBuilder().append(substring).reverse().toString();
                if (substring.equals(reversed) && substring.length() > longest.length()) {
                    longest = substring;
                }
            }
        }

        return longest;
    }
}
