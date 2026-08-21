class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        boolean[] result = new boolean[3];

        for (int[] triplet : triplets) {
            boolean[] intermediate = helper(triplet, target);
            for (int i = 0; i < 3; i++) {
                result[i] = result[i] || intermediate[i];
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!result[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean[] helper(int[] triplet, int[] target) {
        boolean[] result = new boolean[3];

        for (int i = 0; i < 3; i++) {
            if (triplet[i] > target[i]) {
                return new boolean[] {false, false, false};
            } else if (triplet[i] == target[i]) {
                result[i] = true;
            }
        }

        return result;
    }
}
