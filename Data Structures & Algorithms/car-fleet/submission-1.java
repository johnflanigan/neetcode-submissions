class Solution {

    record Car(int position, int speed) {}

    public int carFleet(int target, int[] position, int[] speed) {
        LinkedList<Car> list = new LinkedList<>();
        for (int i = 0; i < position.length; i++) {
            list.add(new Car(position[i], speed[i]));
        }

        list.sort((c1, c2) -> Integer.compare(c1.position, c2.position));

        Car car = list.peekLast();
        double prevTime = (target - car.position) / ((double) car.speed);
        int fleets = 0;
        int fleetSize = 0;

        while (!list.isEmpty()) {
            car = list.removeLast();
            System.out.println(car);
            double carTime = (target - car.position) / ((double) car.speed);

            // If this car's time is faster than the previous time
            // that means we will catch it, adding to the fleet.
            if (carTime <= prevTime) {
                fleetSize++;
            }
            // Otherwise, we are not going to catch it. Thus, we need to start a new fleet.
            // This cars time will be the time to start tracking.
            else {
                fleets++;
                fleetSize = 1;
                prevTime = carTime;
            }
        }

        if (fleetSize > 0) {
            fleets++;
        }

        return fleets;
    }
}
