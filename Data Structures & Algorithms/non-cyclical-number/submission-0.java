class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);

            int next = 0;

            while (n > 0) {
                int digit = n % 10;
                next += (digit * digit);
                n = n / 10;
            }

            n = next;
        }

        return n == 1;

    }
}
