class MedianFinder {

    // Smaller is a max heap with largest at head
    PriorityQueue<Integer> smaller = new PriorityQueue<>(Comparator.reverseOrder());
    // Larger is a min heap with smallest at head
    PriorityQueue<Integer> larger = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if (smaller.size() == larger.size()) {
            smaller.add(num);
            larger.add(smaller.remove());
        } else {
            larger.add(num);
            smaller.add(larger.remove());
        }
    }
    
    public double findMedian() {
        if (smaller.size() > larger.size()) {
            return (double) smaller.peek();
        } else if (smaller.size() < larger.size()) {
            return (double) larger.peek();
        } else {
            double a = smaller.peek();
            double b = larger.peek();
            return (a + b) / 2.0;
        }
    }
}
