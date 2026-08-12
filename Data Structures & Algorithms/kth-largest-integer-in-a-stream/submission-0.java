class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i1, i2));
        this.k = k;

        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);

        if (pq.size() > k) {
            pq.remove();
        }

        return pq.peek();
    }
}
