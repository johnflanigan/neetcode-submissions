class Solution {
    public int[] plusOne(int[] digits) {
        
        boolean carry = true;
        int[] result = new int[digits.length];

        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (carry) {
                digit++;
                carry = false;
            }

            result[i] = digit % 10;
            if (digit >= 10) {
                carry = true;
            }
        }

        if (carry) {
            int[] expanded = new int[result.length + 1];
            for (int i = 0; i < result.length; i++) {
                expanded[i + 1] = result[i];
            }
            expanded[0] = 1;
            return expanded;
        }

        return result;
    }
}
