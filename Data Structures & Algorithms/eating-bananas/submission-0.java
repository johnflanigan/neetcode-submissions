class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = piles[0];
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        
        int l = 1;
        int r = maxPile;

        while (l <= r) {
            int m = l + ((r - l) / 2);
            int time = compute(piles, m);

            if (time > h) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

    private int compute(int[] piles, int rate) {
        int time = 0;
        for (int pile : piles) {
            time += pile / rate;
            if (pile % rate > 0) {
                time++;
            }
        }
        return time;
    }
}
