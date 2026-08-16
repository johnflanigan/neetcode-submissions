class Solution {
    public int maxCoins(int[] nums) {
        Map<String, Integer> coins = new HashMap<>();
        return dfs(nums, coins);
    }

    private int dfs(int[] nums, Map<String, Integer> coins) {
        if (nums.length == 0) {
            return 0;
        }
        String hash = hash(nums);
        if (coins.containsKey(hash)) {
            return coins.get(hash);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int res = 1;
            if (i > 0) {
                res *= nums[i - 1];
            }
            res *= nums[i];
            if (i < nums.length - 1) {
                res *= nums[i + 1];
            }

            int[] nextNums = new int[nums.length - 1];
            int j = 0;
            int k = 0;
            while (j < nextNums.length && k < nums.length) {
                if (i != k) {
                    nextNums[j] = nums[k];
                    j++;
                }
                k++;
            }

            max = Math.max(max, res + dfs(nextNums, coins));
        }

        coins.put(hash, max);
        return max;
    }

    private String hash(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
            sb.append('#');
        }
        return sb.toString();
    }
}
