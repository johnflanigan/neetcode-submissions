class Solution {

    class Task {
        
        char label;
        int count;
        int nextAvailable;

        Task(char label, int count) {
            this.label = label;
            this.count = count;
            this.nextAvailable = 0;
        }

        void run(int nextAvailable) {
            count--;
            this.nextAvailable = nextAvailable;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Task> ready = new PriorityQueue<>((t1, t2) -> {
            return Integer.compare(t2.count, t1.count);
        });
        PriorityQueue<Task> waiting = new PriorityQueue<>((t1, t2) -> {
            return Integer.compare(t1.nextAvailable, t2.nextAvailable);
        });

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            ready.add(new Task(entry.getKey(), entry.getValue()));
        }

        int time = 0;
        while (!ready.isEmpty() || !waiting.isEmpty()) {
            // Move tasks that are ready to run to run queue
            while (!waiting.isEmpty() && waiting.peek().nextAvailable <= time) {
                ready.add(waiting.remove());
            }

            // Remove a ready task if available
            if (!ready.isEmpty()) {
                Task task = ready.remove();

                task.run(time + n + 1);

                if (task.count > 0) {
                    waiting.add(task);
                }
            }

            time++;
        }

        return time;
    }
}
