class MedianFinder {

    // Smaller is a max heap with largest at head
    PriorityQueue<Integer> smaller = new PriorityQueue<>(Comparator.reverseOrder());
    // Larger is a min heap with smallest at head
    PriorityQueue<Integer> larger = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        smaller.add(num);

        // If small heap is too big OR the largest "small" element is bigger than the smallest "large" element, rebalance
        if (smaller.size() > larger.size() + 1 || !larger.isEmpty() && smaller.peek() > larger.peek()) {
            larger.add(smaller.remove());
        } 

        if (larger.size() > smaller.size() + 1) {
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
