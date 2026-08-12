class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }

        int max = 0;
        
        for (int num : nums) {
            int count = 0;
            if (seen.contains(num)) {
                count++;
                seen.remove(num);
                
                int forward = num + 1;
                while (seen.contains(forward)) {
                    seen.remove(forward);
                    count++;
                    forward++;
                }
                int backward = num - 1;
                while (seen.contains(backward)) {
                    seen.remove(backward);
                    count++;
                    backward--;
                }
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
