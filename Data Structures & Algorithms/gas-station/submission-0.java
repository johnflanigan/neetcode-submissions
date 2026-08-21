class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        for (int g : gas) {
            totalGas += g;
        }

        int totalCost = 0;
        for (int c : cost) {
            totalCost += c;
        }

        if (totalGas < totalCost) {
            return -1;
        }

        int starting = 0;
        int total = 0;

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                starting = i + 1;
                total = 0;
            }
        }

        return starting;
    }
}
