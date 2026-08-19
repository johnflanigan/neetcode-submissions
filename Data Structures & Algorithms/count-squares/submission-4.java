record Point(int x, int y) {}

class CountSquares {

    Map<Point, Integer> countPoints;
    Map<Integer, Set<Integer>> pointsByX;

    public CountSquares() {
        countPoints = new HashMap<>();
        pointsByX = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        Point p = new Point(x, y);
        countPoints.put(p, countPoints.getOrDefault(p, 0) + 1);
        
        if (!pointsByX.containsKey(x)) {
            pointsByX.put(x, new HashSet<>());
        }
        pointsByX.get(x).add(y);
    }
    
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];

        if (!pointsByX.containsKey(x1)) {
            return 0;
        }


        int total = 0;

        Map<Integer, Integer> distances = new HashMap<>();
        for (int y2 : pointsByX.get(x1)) {
            if (y1 == y2) {
                continue;
            }
            int side = Math.abs(y1 - y2);

            Point p1 = new Point(x1, y2);
            Point p2 = new Point(x1 + side, y1);      
            Point p3 = new Point(x1 + side, y2);

            total += countPoints.getOrDefault(p1, 0)
                        * countPoints.getOrDefault(p2, 0)
                        * countPoints.getOrDefault(p3, 0);

            p2 = new Point(x1 - side, y1);      
            p3 = new Point(x1 - side, y2);
            total += countPoints.getOrDefault(p1, 0)
                        * countPoints.getOrDefault(p2, 0)
                        * countPoints.getOrDefault(p3, 0);
        }

        return total;
    }
}
