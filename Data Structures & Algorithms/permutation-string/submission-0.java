class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        int[] array1 = new int[26];
        for (char c : s1.toCharArray()) {
            array1[c - 'a']++;
        }

        int[] array2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            array2[s2.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = s1.length();

        while (j < s2.length()) {
            if (isPermutation(array1, array2)) {
                return true;
            }
            
            array2[s2.charAt(i) - 'a']--;
            array2[s2.charAt(j) - 'a']++;

            i++;
            j++;
        }

        return isPermutation(array1, array2);
    }

    private boolean isPermutation(int[] array1, int[] array2) {
        for (int i = 0; i < 26; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
}
