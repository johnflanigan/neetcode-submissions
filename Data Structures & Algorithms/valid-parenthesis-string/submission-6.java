class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> wild = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                left.addLast(i);
            } else if (c == '*') {
                wild.addLast(i);
            } else if (c == ')') {
                if (!left.isEmpty()) {
                    left.removeLast();
                } else if (!wild.isEmpty()) {
                    wild.removeLast();
                } else {
                    return false;
                }
            }
        }

        while (!left.isEmpty() && !wild.isEmpty() && left.peekLast() < wild.peekLast()) {
            left.removeLast();
            wild.removeLast();
        }

        return left.isEmpty();
    }
}
