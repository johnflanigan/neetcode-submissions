class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new LinkedList<>();

        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && temperatures[deque.peekLast()] < temperatures[i]) {
                int popped = deque.removeLast();
                result[popped] = i - popped;
            }

            deque.addLast(i);
        }

        return result;
    }
}
