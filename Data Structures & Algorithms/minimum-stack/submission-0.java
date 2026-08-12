class MinStack {

    private Deque<Integer> deque = new LinkedList<>();


    public MinStack() {
        
    }
    
    public void push(int val) {
        deque.addLast(val);
    }
    
    public void pop() {
        deque.removeLast();
    }
    
    public int top() {
        return deque.peekLast();
    }
    
    public int getMin() {
        int min = deque.peekLast();
        for (int i : deque) {
            min = Math.min(min, i);
        }
        return min;
    }
}
