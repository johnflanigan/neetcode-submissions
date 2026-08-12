class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                deque.addLast(c);
            } else {
                if (deque.isEmpty()) {
                    return false;
                }
                char removed = deque.removeLast();
                if (c == '}' && removed == '{' 
                    || c == ')' && removed == '(' 
                    || c == ']' && removed == '[' 
                ) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }
}
