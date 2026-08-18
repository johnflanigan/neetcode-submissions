class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        
        double res = myPow(x, Math.abs(n) / 2);
        res = res * res;
        if (Math.abs(n) % 2 == 1) {
            res = res * x;
        }

        // System.out.println("x: %f, n: %d, res: %f".formatted(x, n, res));
        if (n < 0 && res != 0) {
            return 1 / res;
        } else {
            return res;
        }
    }
}
