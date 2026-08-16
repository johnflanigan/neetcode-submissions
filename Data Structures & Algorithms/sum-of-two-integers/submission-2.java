class Solution {
    public int getSum(int a, int b) {
        
        int res = 0;
        boolean carry = false;
        for (int i = 0; i < 32; i++) {
            int bits = 0;

            if (carry) {
                bits++;
                carry = false;
            }

            int pow = 1 << i;
            if ((a & pow) != 0) {
                bits++;
            }
            if ((b & pow) != 0) {
                bits++;
            }

            if (bits == 3) {
                carry = true;
                res = res | pow;
            } else if (bits == 2) {
                carry = true;
            } else if (bits == 1) {
                res = res | pow;
            }
        }

        return res;
    }
}
