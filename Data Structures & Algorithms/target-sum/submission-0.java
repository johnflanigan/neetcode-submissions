class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> next = new HashMap<>();

            for (Map.Entry<Integer, Integer> entry : sumToCount.entrySet()) {
                int plus = entry.getKey() + nums[i];
                int minus = entry.getKey() - nums[i];
                int count = entry.getValue();

                next.put(plus, next.getOrDefault(plus, 0) + count);
                next.put(minus, next.getOrDefault(minus, 0) + count);
            }

            sumToCount = next;
        }

        return sumToCount.getOrDefault(target, 0);
    }
}
