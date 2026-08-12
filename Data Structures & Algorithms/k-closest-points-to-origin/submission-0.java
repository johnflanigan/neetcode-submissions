class Solution {

    class Point {

        int x;
        int y;
        double distance;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Point> pq = new PriorityQueue<>((p1, p2) -> Double.compare(p2.distance, p1.distance));


        for (int[] point : points) {
            pq.add(new Point(point[0], point[1]));
            if (pq.size() > k) {
                pq.remove();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            Point point = pq.remove();
            result[i][0] = point.x;
            result[i][1] = point.y;
            i++;
        }

        return result;
    }
}
