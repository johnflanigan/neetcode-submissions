class MinStack {

    private Deque<Integer> deque = new LinkedList<>();
    private Deque<Integer> mins = new LinkedList<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        if (deque.isEmpty()) {
            mins.addLast(val);
        } else {
            mins.addLast(Math.min(val, mins.peekLast()));
        }

        deque.addLast(val);
    }
    
    public void pop() {
        mins.removeLast();
        deque.removeLast();
    }
    
    public int top() {
        return deque.peekLast();
    }
    
    public int getMin() {
        return mins.peekLast();
    }
}
