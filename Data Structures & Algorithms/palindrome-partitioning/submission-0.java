class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        List<String> partition = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        int i = 0;

        dfs(s, i, sb, partition, partitions);

        return partitions;
    }

    private void dfs(String s, int i, StringBuilder sb, List<String> partition, List<List<String>> partitions) {
        if (i >= s.length()) {
            String t = sb.toString();
            if (t.length() > 0 && isPalindrome(t)) {
                partition.add(t);
                partitions.add(new ArrayList<>(partition));
                partition.remove(partition.size() - 1);
            }
            return;
        }

        sb.append(s.charAt(i));
        String t = sb.toString();

        if (isPalindrome(t)) {
            partition.add(t);
            dfs(s, i + 1, new StringBuilder(), partition, partitions);
            partition.remove(partition.size() - 1);
        }

        dfs(s, i + 1, sb, partition, partitions);
        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean isPalindrome(String s) {
        String reversed = new StringBuilder().append(s).reverse().toString();
        return s.equals(reversed);
    }
}
