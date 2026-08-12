class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < heights.length; i++) {
            while (!deque.isEmpty() && heights[deque.peekLast()] >= heights[i]) {
                deque.removeLast();
            }

            if (deque.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = deque.peekLast();
            }
            deque.addLast(i);
        }
        deque.clear();

        int[] right = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && heights[deque.peekLast()] >= heights[i]) {
                deque.removeLast();
            }

            if (deque.isEmpty()) {
                right[i] = heights.length;
            } else {
                right[i] = deque.peekLast();
            }
            deque.addLast(i);
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int rectangle = heights[i] * (right[i] - left[i] - 1);
            max = Math.max(max, rectangle);
            System.out.println("i: %d, rectangle: %d, left: %d, right: %d".formatted(i, rectangle, left[i], right[i]));
        }

        return max;
    }
}
