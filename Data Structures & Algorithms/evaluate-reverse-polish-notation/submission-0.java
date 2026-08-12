class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> deque = new LinkedList<>();

        for (String token : tokens) {
            if (token.equals("+")
                || token.equals("-")
                || token.equals("*")
                || token.equals("/")) {
                    int y = Integer.parseInt(deque.removeLast());
                    int x = Integer.parseInt(deque.removeLast());
                    int result;
                    if (token.equals("+")) {
                        result = x + y;
                    } else if (token.equals("-")) {
                        result = x - y;
                    } else if (token.equals("*")) {
                        result = x * y;
                    } else {
                        result = x / y;
                    }
                    deque.addLast(Integer.toString(result));
                } else {
                    deque.addLast(token);
                }
        }

        return Integer.parseInt(deque.removeLast());
    }
}
